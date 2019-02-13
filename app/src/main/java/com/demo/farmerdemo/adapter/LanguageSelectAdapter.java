package com.demo.farmerdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.demo.farmerdemo.R;
import com.demo.farmerdemo.bean.PersonItem;

import java.util.List;

public class LanguageSelectAdapter extends RecyclerView.Adapter<LanguageSelectAdapter.SingleCheckViewHolder> {

//    private int mSelectedItem = -1;
    private List<PersonItem> mSingleCheckList;
    private Context mContext;
    //    private AdapterView.OnItemClickListener onItemClickListener;
    private int mSelectedPosition = -1;
    private RadioButton mSelectedRB;
    private TextView lan_txt;
    public LanguageSelectAdapter(Context context, List<PersonItem> listItems) {
        mContext = context;
        mSingleCheckList = listItems;
    }

    @Override
    public SingleCheckViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        final View view = inflater.inflate(R.layout.language_item, viewGroup, false);
        return new SingleCheckViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(final SingleCheckViewHolder viewHolder, final int position) {
        PersonItem item = mSingleCheckList.get(position);
        /*try {
            viewHolder.setDateToView(item, position);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
//        viewHolder.select_text.setTextColor(Color.BLACK);
        viewHolder.select_text.setText(item.getPersonName());

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != mSelectedPosition && lan_txt != null){
                    lan_txt.setBackgroundResource(R.drawable.round_stroke);
//                    viewHolder.select_text.setTextColor(Color.BLACK);
                }
                if (position != mSelectedPosition && mSelectedRB != null) {
                    mSelectedRB.setChecked(false);
                }

                mSelectedPosition = position;
                mSelectedRB = viewHolder.mRadio;
                lan_txt = viewHolder.select_text;

                if (mSelectedPosition != position){
                    viewHolder.select_text.setBackgroundResource(R.drawable.round_stroke);
//                    viewHolder.select_text.setTextColor(Color.BLACK);
                } else {
                    viewHolder.select_text.setBackgroundResource(R.drawable.round_solid);
//                    viewHolder.select_text.setTextColor(Color.WHITE);
                }

                if (mSelectedPosition != position) {
                    viewHolder.mRadio.setChecked(false);
                } else {
                    viewHolder.mRadio.setChecked(true);
                }


            }
        });

        if (mSelectedPosition != position) {
            viewHolder.mRadio.setChecked(false);
        } else {
            viewHolder.mRadio.setChecked(true);
        }

        if (mSelectedPosition != position) {
            viewHolder.select_text.setBackgroundResource(R.drawable.round_stroke);
//            viewHolder.select_text.setTextColor(Color.BLACK);
        } else {
            viewHolder.select_text.setBackgroundResource(R.drawable.round_solid);
//            viewHolder.select_text.setTextColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return mSingleCheckList.size();
    }


    class SingleCheckViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {

        private LanguageSelectAdapter mAdapter;
        private RadioButton mRadio;
        private TextView mText, select_text;
        private LinearLayout layout;

        public SingleCheckViewHolder(View itemView, final LanguageSelectAdapter mAdapter) {
            super(itemView);
            this.mAdapter = mAdapter;

            mText = (TextView) itemView.findViewById(R.id.text);
            mRadio = (RadioButton) itemView.findViewById(R.id.radio);
            layout = (LinearLayout) itemView.findViewById(R.id.layout);
            select_text = (TextView) itemView.findViewById(R.id.select_text);

            /*if(mSelectedRB != null && mRadio != mSelectedRB){
                mSelectedRB = mRadio;
            }*/
            }
        }
    }

//            mRadio.setOnClickListener(this);


        /*public void setDateToView(PersonItem item, int position) throws Exception {
            mRadio.setChecked(position == mSelectedItem);
            mText.setText(item.getPersonName());
        }*/

       /* @Override
        public void onClick(View v) {

           *//* mSelectedItem = getAdapterPosition();
            notifyItemRangeChanged(0, mSingleCheckList.size());
            mAdapter.onItemHolderClick(SingleCheckViewHolder.this);*//*
        }*/

        /*public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public void onItemHolderClick(SingleCheckViewHolder holder) {
        if (onItemClickListener != null)
            onItemClickListener.onItemClick(null, holder.itemView, holder.getAdapterPosition(), holder.getItemId());
    }*/

