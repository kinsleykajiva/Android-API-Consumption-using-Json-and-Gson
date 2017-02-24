package Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Cwidgets.Cfonts.MyTextView;
import Pojos.States_Api_Json;
import kinsleykajiva.co.zw.feed.R;

/**
 * Created by kinsley kajiva on 10/16/2016.Zvaganzirwa nakinsley kajiva musiwa 10/16/2016
 */

public class HomeRecyclerAdapter  extends RecyclerView.Adapter<HomeRecyclerAdapter.CustomViewHolder> {


    private List<States_Api_Json> feedItemList;


    public HomeRecyclerAdapter( List<States_Api_Json> feedItemList) {
        this.feedItemList = feedItemList;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected MyTextView txtTitle, txtDescription,txtDate;

        public CustomViewHolder(View view) {
            super(view);
            this.txtTitle = (MyTextView) view.findViewById(R.id.recycle_title);
            this.txtDescription = (MyTextView) view.findViewById(R.id.recycle_repeat_info);
            this.txtDate = (MyTextView) view.findViewById(R.id.recycle_date_time);

        }
    }
    @Override
    public HomeRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, null));
    }
    @Override
    public void onBindViewHolder(HomeRecyclerAdapter.CustomViewHolder holder, int position) {

        States_Api_Json feedItem = feedItemList.get(position);
        holder.txtTitle.setText(feedItem.getTitle());
        holder.txtDescription.setText(feedItem.getNotes());
        holder.txtDate.setText(feedItem.getRealtime_start());

    }
    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
       /* if (Configs.wasTherer_InternetServices) {
            return (null != feedItemList ? feedItemList.size() : 0);
        } else {
            return (null != results ? results.size() : 0);
        }*/
    }
    public void setitems(ArrayList<States_Api_Json> list) {
        this.feedItemList = list;
        notifyDataSetChanged();
    }
}
