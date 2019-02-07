package org.pursuit.implicitintentsfromscratch.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.implicitintentsfromscratch.DisplayActivity;
import org.pursuit.implicitintentsfromscratch.R;
import org.pursuit.implicitintentsfromscratch.model.ZodiacModel;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView nunberTextView;


    public ZodiacViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_textview);
        nunberTextView = itemView.findViewById(R.id.number_textview);
    }

    public void onBind(final ZodiacModel zodiacModel){
        nameTextView.setText(zodiacModel.getName());
        nunberTextView.setText(zodiacModel.getNumber());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra("name", zodiacModel.getName());
                intent.putExtra("date", zodiacModel.getNumber());
                intent.putExtra("image", zodiacModel.getImage());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
