package com.mhs.kase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mhs.kase.R;
import com.mhs.kase.model.CatatanModel;
import com.mhs.kase.model.MemberModel;

import java.util.List;

public class MemberAdapter extends BaseAdapter {
    private Context context; //context
    private List<MemberModel> items; //data source of the list adapter

    //public constructor
    public MemberAdapter(Context context, List<MemberModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.list_member, parent, false);
        }

        MemberModel model = items.get(position);

        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tv_username = (TextView) convertView.findViewById(R.id.tv_username);
        View v1 = (View) convertView.findViewById(R.id.v1);
        View v2 = (View) convertView.findViewById(R.id.v2);

        tv_name.setText(model.getName());
        tv_username.setText(model.getUsername());
        SetWarna(model.getIdcolor(), v1, v2);

        return convertView;
    }

    void SetWarna(int id, View bb, View aa) {
        switch (id) {
            case 1:
                aa.setBackgroundTintList(context.getResources().getColorStateList(R.color.c1a));
                bb.setBackgroundTintList(context.getResources().getColorStateList(R.color.c1b));
                break;
            case 2:
                aa.setBackgroundTintList(context.getResources().getColorStateList(R.color.c2a));
                bb.setBackgroundTintList(context.getResources().getColorStateList(R.color.c2b));
                break;
            case 3:
                aa.setBackgroundTintList(context.getResources().getColorStateList(R.color.c3a));
                bb.setBackgroundTintList(context.getResources().getColorStateList(R.color.c3b));
                break;
            case 4:
                aa.setBackgroundTintList(context.getResources().getColorStateList(R.color.c4a));
                bb.setBackgroundTintList(context.getResources().getColorStateList(R.color.c4b));
                break;
            case 5:
                aa.setBackgroundTintList(context.getResources().getColorStateList(R.color.c5a));
                bb.setBackgroundTintList(context.getResources().getColorStateList(R.color.c5b));
                break;
        }

    }
}
