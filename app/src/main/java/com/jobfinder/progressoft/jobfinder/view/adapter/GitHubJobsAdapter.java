package com.jobfinder.progressoft.jobfinder.view.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jobfinder.progressoft.jobfinder.R;
import com.jobfinder.progressoft.jobfinder.model.vo.GitHubJobs;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GitHubJobsAdapter extends RecyclerView.Adapter<GitHubJobsAdapter.MyViewHolder> implements ListAdapter {

    public static List<GitHubJobs> gitHubJobsList;
    Context context;
    private int selectedIndex;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, locatin, companyName, fullTime, createdAt;
        public ImageView imageView;
        public int index;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt_title);
            locatin = (TextView) view.findViewById(R.id.txt_locaton);
            companyName = (TextView) view.findViewById(R.id.txt_company_name);
            fullTime = (TextView) view.findViewById(R.id.txt_full_time);
            createdAt = (TextView) view.findViewById(R.id.txt_created_at);
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
        notifyDataSetChanged();
    }

    public GitHubJobsAdapter(Context context, List<GitHubJobs> gitHubJobsList) {
        this.gitHubJobsList = gitHubJobsList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.git_hub_job_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GitHubJobs jobs = gitHubJobsList.get(position);
        if (jobs.getTitle().length() > 0){
            holder.title.setText(jobs.getTitle());}
            else{
            holder.title.setVisibility(View.GONE);
        }
        String location=jobs.getLocation().replaceAll("[;\\/:*?\"<>|&']","");
        if (jobs.getLocation().length() > 0){
            holder.locatin.setText(location);}
        else{
            holder.locatin.setVisibility(View.GONE);
        }
        if (jobs.getCompany().length() > 0){
            holder.companyName.setText(jobs.getCompany());}
        else{
            holder.companyName.setVisibility(View.GONE);
        }
        if (jobs.getCreatedAt().length() > 0){
            holder.createdAt.setText(jobs.getCreatedAt());}
        else{
            holder.createdAt.setVisibility(View.GONE);
        }
        if (jobs.getType().length() > 0){
            holder.fullTime.setText(jobs.getType());}
        else{
            holder.fullTime.setVisibility(View.GONE);
        }
        if (jobs.getCompanyLogo().length() > 0){
            //Picasso.with(context).load(jobs.getCompanyLogo()).placeholder(R.drawable.splash_screen).into(holder.imageView);
            Glide.with(context)
                    .load(jobs.getCompanyLogo())
                    .into(holder.imageView);
        }
        else{
            holder.imageView.setBackgroundResource(R.drawable.splash_screen);
        }
    }

    @Override
    public int getItemCount() {
        return gitHubJobsList.size();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}