package com.mhs.kase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mhs.kase.R;
import com.mhs.kase.model.CatatanModel;

import java.util.List;

public class CatatanAdapter extends BaseAdapter {
    private Context context; //context
    private List<CatatanModel> items; //data source of the list adapter

    //public constructor
    public CatatanAdapter(Context context, List<CatatanModel> items) {
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
                    inflate(R.layout.list_catatan, parent, false);
        }

        CatatanModel model = items.get(position);

        TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tv_keterangan = (TextView) convertView.findViewById(R.id.tv_keterangan);
        TextView tv_harga = (TextView) convertView.findViewById(R.id.tv_harga);
        View v1 = (View) convertView.findViewById(R.id.v1);
        View v2 = (View) convertView.findViewById(R.id.v2);

        if (model.getIdcolor() % 2 == 0) {
            tv_title.setText("Uang Masuk");
            tv_keterangan.setText("Bayar iuran bulanan");
        } else {
            tv_title.setText("Uang Keluar");
            tv_keterangan.setText("Konsumsi");
        }
        SetWarna(model.getIdcolor(), v1, v2, tv_harga);

        return convertView;
    }

    void SetWarna(int id, View bb, View aa, TextView cc) {
        switch (id) {
            case 1:
                aa.setBackgroundTintList(context.getResources().getColorStateList(R.color.c1a));
                bb.setBackgroundTintList(context.getResources().getColorStateList(R.color.c1b));
                cc.setTextColor(context.getResources().getColor(R.color.c1a));
                break;
            case 2:
                aa.setBackgroundTintList(context.getResources().getColorStateList(R.color.c2a));
                bb.setBackgroundTintList(context.getResources().getColorStateList(R.color.c2b));
                cc.setTextColor(context.getResources().getColor(R.color.c2a));
                break;
            case 3:
                aa.setBackgroundTintList(context.getResources().getColorStateList(R.color.c3a));
                bb.setBackgroundTintList(context.getResources().getColorStateList(R.color.c3b));
                cc.setTextColor(context.getResources().getColor(R.color.c3a));
                break;
            case 4:
                aa.setBackgroundTintList(context.getResources().getColorStateList(R.color.c4a));
                bb.setBackgroundTintList(context.getResources().getColorStateList(R.color.c4b));
                cc.setTextColor(context.getResources().getColor(R.color.c4a));
                break;
            case 5:
                aa.setBackgroundTintList(context.getResources().getColorStateList(R.color.c5a));
                bb.setBackgroundTintList(context.getResources().getColorStateList(R.color.c5b));
                cc.setTextColor(context.getResources().getColor(R.color.c5a));
                break;
        }

    }
}
