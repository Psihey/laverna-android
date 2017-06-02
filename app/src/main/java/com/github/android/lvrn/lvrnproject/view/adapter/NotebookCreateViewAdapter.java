package com.github.android.lvrn.lvrnproject.view.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.android.lvrn.lvrnproject.R;
import com.github.android.lvrn.lvrnproject.persistent.entity.Notebook;
import com.github.android.lvrn.lvrnproject.view.dialog.notebookcreate.NotebookCreatePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Andrii Bei <psihey1@gmail.com>
 */

public class NotebookCreateViewAdapter extends RecyclerView.Adapter<NotebookCreateViewAdapter.NotebookCreateViewHolder> implements DataPostSetAdapter<Notebook>  {

    private List<Notebook> mNotebook;
    private NotebookCreatePresenter mNotebookCreatePresenter;
    private int mSelecteditem = -1;

    public NotebookCreateViewAdapter(NotebookCreatePresenter notebookCreatePresenter) {
        this.mNotebookCreatePresenter = notebookCreatePresenter;
    }

    @Override
    public NotebookCreateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notebook_create, parent, false);
        return new NotebookCreateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotebookCreateViewHolder holder, int position) {

        if (mSelecteditem == position)
            holder.itemView.setBackgroundColor(Color.parseColor("#000000"));
        else
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));

        holder.tvTitle.setText(mNotebook.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            if (mSelecteditem == position) {
                mSelecteditem = -1;
                mNotebookCreatePresenter.getNotebookId(null);
            } else {
                mSelecteditem = position;
                mNotebookCreatePresenter.getNotebookId(mNotebook.get(position).getId());
            }
            notifyDataSetChanged();
        });

    }

    @Override
    public int getItemCount() {
        return mNotebook.size();
    }

    @Override
    public void setData(List<Notebook> data) {
        mNotebook = data;
    }

    public class NotebookCreateViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_view_notebook_name)
        TextView tvTitle;

        public NotebookCreateViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
