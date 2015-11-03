package com.yaowen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.yaowen.dateselector.R;

import java.util.List;

/**
 * Created by HelloWorld on 2015/11/3.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private static List<String> strList;

    public MyAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.strList = list;
    }

    @Override
    public int getCount() {
        return strList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.main, null);
            viewHolder = new ViewHolder();
            viewHolder.iDText = (EditText) convertView.findViewById(R.id.et22);
            //viewHolder.strText = (TextView) convertView.findViewById(R.id.strText);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String str = strList.get(position);
        viewHolder.iDText.setText(position + str);
        //String str = strList.get(position);
        //viewHolder.strText.setText(str);
        return convertView;
    }

    private  class ViewHolder {
        private EditText iDText;
        //private TextView strText;
    }

    public static void updataView(int posi, ListView listView) {
        int visibleFirstPosi = listView.getFirstVisiblePosition();
        int visibleLastPosi = listView.getLastVisiblePosition();
        if (posi >= visibleFirstPosi && posi <= visibleLastPosi) {
            View view = listView.getChildAt(posi - visibleFirstPosi);
            ViewHolder holder = (ViewHolder) view.getTag();

            String txt = holder.iDText.getText().toString();
            txt = txt + "++;";
            holder.iDText.setText(txt);
            strList.set(posi, txt);
        } else {
            String txt = strList.get(posi);
            txt = txt + "++;";
            strList.set(posi, txt);
        }
    }
}
