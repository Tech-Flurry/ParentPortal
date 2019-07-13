package com.example.parentportal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parentportal.DiaryFragment.OnListFragmentInteractionListener;
import com.example.parentportal.ViewModels.DairyViewModel;
import com.example.parentportal.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyDiaryRecyclerViewAdapter extends RecyclerView.Adapter<MyDiaryRecyclerViewAdapter.ViewHolder> {

    private final List<DairyViewModel> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyDiaryRecyclerViewAdapter(List<DairyViewModel> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_diary, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mDiaryBody.setText(mValues.get(position).getBody());
        holder.mDiaryDate.setText(mValues.get(position).getDate());
        holder.mDiarySubject.setText(mValues.get(position).getSubjectName());
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
        public final TextView mDiarySubject;
        public final TextView mDiaryBody;
        public final TextView mDiaryDate;
        public DairyViewModel mItem;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            mDiaryDate =view.findViewById(R.id.txtDiaryDate);
            mDiaryBody=view.findViewById(R.id.txtDiaryBody);
            mDiarySubject=view.findViewById(R.id.txtSubjectName);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mDiarySubject.getText() + ": "+mDiaryBody.getText()+"'";
        }
    }
}
