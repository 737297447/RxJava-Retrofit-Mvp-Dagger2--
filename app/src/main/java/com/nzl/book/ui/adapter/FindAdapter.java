package com.nzl.book.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nzl.book.R;
import com.nzl.book.bean.FindBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/8.
 */

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.ViewHolder>{

    private List<FindBean> list;

    public FindAdapter(List<FindBean> list){
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_find,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FindBean bean = list.get(position);
        holder.textView.setText(bean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_content)
        TextView textView;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this,v);
        }

    }
}
