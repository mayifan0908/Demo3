package com.yf.fengmai.demo3;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fengmai on 2017/3/23.
 */

class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<String> list;
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> headerlist;
    private int HEADER=0;
    private int SUM=1;
    private int FOOTER=2;
    private FragmentManager fm;

    public Myadapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
        inflater= LayoutInflater.from(context);
    }
//    Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if (headervp.getCurrentItem()==0){
//                headervp.setCurrentItem(1);
//            }if (headervp.getCurrentItem()==1){
//                headervp.setCurrentItem(2);
//            }if (headervp.getCurrentItem()==2){
//                headervp.setCurrentItem(3);
//            }if (headervp.getCurrentItem()==3){
//                headervp.setCurrentItem(0);
//            }
//        }
//    };

    public Myadapter(ArrayList<String> list, Context context, FragmentManager fm) {
        this.list = list;
        this.context = context;
        this.fm = fm;
        inflater= LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          //  View view=null;
        //RecyclerView.ViewHolder holder=null;
        if (viewType==HEADER){
           //View view=inflater.inflate(R.layout.headeritem,parent,false);
            return  new headerviewholder(inflater.inflate(R.layout.headeritem, parent, false));
        }else if (viewType==FOOTER){
            return  new footerviewholder(inflater.inflate(R.layout.footeritem,parent,false));
        }
        else {
            return  new Myviewholder(inflater.inflate(R.layout.item, parent, false));
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof headerviewholder){
           ArrayList<android.support.v4.app.Fragment> flist=new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Fragment f1=new Fragment();
                flist.add(f1);
            }
            Fragmentadapter fadapter=new Fragmentadapter(fm,flist);
            //headervp.setAdapter(fadapter);
            ((headerviewholder) holder).headervp.setAdapter(fadapter);

      }else if (holder instanceof footerviewholder){
            ((footerviewholder) holder).footertv.setText("加载中。。。。");
        }else {
            ((Myviewholder) holder).item_tv.setText(list.get(position));
        }

    }


    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return HEADER;
        }else if (position==getItemCount()-1){
            return FOOTER;
        }else {
            return SUM;
        }

    }
    //item布局
    class Myviewholder extends RecyclerView.ViewHolder{
        TextView item_tv;
        public Myviewholder(View itemView) {
            super(itemView);
            item_tv= (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
    class headerviewholder extends RecyclerView.ViewHolder{
         ViewPager headervp;
        public headerviewholder(View itemView) {
            super(itemView);
            headervp= (ViewPager) itemView.findViewById(R.id.headervp);
        }
    }
    class footerviewholder extends RecyclerView.ViewHolder{
        TextView footertv;
        public footerviewholder(View itemView) {
            super(itemView);
            footertv= (TextView) itemView.findViewById(R.id.footertv);
        }
    }
}
