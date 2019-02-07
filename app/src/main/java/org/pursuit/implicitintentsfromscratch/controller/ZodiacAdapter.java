package org.pursuit.implicitintentsfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.implicitintentsfromscratch.R;
import org.pursuit.implicitintentsfromscratch.model.ZodiacModel;
import org.pursuit.implicitintentsfromscratch.view.ZodiacViewHolder;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {

    private List<ZodiacModel> zodiacList;

    public ZodiacAdapter(List<ZodiacModel> zodiacList) {
        this.zodiacList = zodiacList;
    }

    @NonNull
    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zodiac_itemview, viewGroup, false);
        return new ZodiacViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder zodiacViewHolder, int position) {
        zodiacViewHolder.onBind(zodiacList.get(position));
    }

    @Override
    public int getItemCount() {
        return zodiacList.size();
    }
}
