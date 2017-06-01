package com.github.android.lvrn.lvrnproject.view.adapter.impl;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.android.lvrn.lvrnproject.R;
import com.github.android.lvrn.lvrnproject.persistent.entity.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Andrii Bei <psihey1@gmail.com>
 */
//TODO: FIX!
public class AllTaskAdapter extends RecyclerView.Adapter<AllTaskAdapter.TaskViewHolder> {
    public List<Task> mTaskData;


    public AllTaskAdapter(List<Task> mTaskData) {
        this.mTaskData = mTaskData;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.tvTaskDescription.setText(mTaskData.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mTaskData.size();
    }
//    public void setClickListener(AllNotesAdapter.ItemClickListener itemClickListener) {
//        this.mItemClickListener = itemClickListener;
//    }


    class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.text_view_task_description)
        TextView tvTaskDescription;

         TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
             itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            if (mItemClickListener != null) mItemClickListener.onClick(v,getAdapterPosition());

        }
    }
}
