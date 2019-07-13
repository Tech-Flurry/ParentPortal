package com.example.parentportal;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.parentportal.ViewModels.StudentProgressViewModel;

import java.util.List;

/**
 *
 * TODO: Replace the implementation with code for your data type.
 */
public class MyStudentProgressRecyclerViewAdapter extends RecyclerView.Adapter<MyStudentProgressRecyclerViewAdapter.ViewHolder> {

    private final List<StudentProgressViewModel> mValues;
    private final StudentProgressFragment.OnListFragmentInteractionListener mListener;

    public MyStudentProgressRecyclerViewAdapter(List<StudentProgressViewModel> items, StudentProgressFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_studentprogress, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mStudentName.setText(mValues.get(position).getStudentName());
        holder.mStudentProgressPercent.setText(mValues.get(position).getProgress()+"%");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.mStudentProgress.setProgress(mValues.get(position).getProgress(),true);
        }
        else {
            holder.mStudentProgress.setProgress(mValues.get(position).getProgress());
        }
        holder.mStudentClass.setText(mValues.get(position).getStudentClass());
        holder.mStudentAttendance.setText(mValues.get(position).getAttendance()+"%");
        holder.mStudentProgressDetails.setTag(mValues.get(position).getStudentId());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mStudentName;
        public final TextView mStudentClass;
        public final TextView mStudentAttendance;
        public final TextView mStudentProgressPercent;
        public final ProgressBar mStudentProgress;
        public final Button mStudentProgressDetails;
        public StudentProgressViewModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mStudentAttendance=view.findViewById(R.id.txtAtendance);
            mStudentClass=view.findViewById(R.id.txtClass);
            mStudentName=view.findViewById(R.id.txtStudentName);
            mStudentProgress=view.findViewById(R.id.progressBar);
            mStudentProgressPercent=view.findViewById(R.id.txtProgPercent);
            mStudentProgressDetails=view.findViewById(R.id.btnDetails);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mStudentName.getText() + "'";
        }
    }
}
