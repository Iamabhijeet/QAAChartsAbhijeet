package com.example.abhi.moinrecycler;



        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.drawable.BitmapDrawable;
        import android.graphics.drawable.Drawable;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import java.util.ArrayList;

/**
 * Created by abhi on 25-08-2016.
 */
class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;
    private int[] mDataSetTypes;


    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;

    private Context mycontext;

    private ArrayList<MainActivity.DataSet> myDataList = new ArrayList<>();

    public void setContext(Context someContext){
        this.mycontext = someContext;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    public class FirstViewHolder extends ViewHolder {
        TextView tv1st;

        public FirstViewHolder(View v) {
            super(v);
            this.tv1st = (TextView) v.findViewById(R.id.tv1st);
        }
    }

    public class SecondViewHolder extends ViewHolder {
        ImageView iv3rd;

        public SecondViewHolder(View v) {
            super(v);
            this.iv3rd = (ImageView)v.findViewById(R.id.iv3rd);
        }
    }

    public class ThirdViewHolder extends ViewHolder {
        TextView tv2nd;
        //Button read_more;

        public ThirdViewHolder(View v) {
            super(v);
            this.tv2nd = (TextView)v.findViewById(R.id.tv2nd);
            //this.read_more = (Button) v.findViewById(R.id.read_more);
        }
    }


    public CustomAdapter(ArrayList<MainActivity.DataSet> list) {
//        myDat = dataSet;
//        mDataSetTypes = dataSetTypes;
        for (int i=0;i<list.size();i++){
            myDataList.add(list.get(i));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == FIRST) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card_view, viewGroup, false);

            return new FirstViewHolder(v);
        } else if (viewType == THIRD) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card_view3, viewGroup, false);
            return new ThirdViewHolder(v);
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.card_view2, viewGroup, false);
            return new SecondViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if (viewHolder.getItemViewType() == FIRST) {
            FirstViewHolder holder = (FirstViewHolder) viewHolder;
            holder.tv1st.setText(myDataList.get(position).content);
        }
        else if (viewHolder.getItemViewType() == THIRD) {
            ThirdViewHolder holder = (ThirdViewHolder) viewHolder;
            holder.tv2nd.setText(myDataList.get(position).content);


        }
        else {
            SecondViewHolder holder = (SecondViewHolder) viewHolder;
//            holder.iv3rd.setImageResource(R.drawable.abhijeet);
            Picasso.with(mycontext)
                    .load(myDataList.get(position).content)
                    .resize(50, 50)
                    .centerCrop()
                    .into(holder.iv3rd);

        }
    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
//        int type = 0;

        return (myDataList.get(position).type);

//        return type;
    }
}