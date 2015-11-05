package com.yaowen.dateselector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yaowen.adapter.ListEditorAdapter;
import com.yaowen.classUtil.CheckboxGroup;
import com.yaowen.classUtil.DatePicker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //private MainActivity mContext;
    private EditText idEdit;
    private TextView textView;
    private DatePicker datePicker;
    private CheckboxGroup checkboxGroup;
    private RadioGroup radioGroup;
    private ListView listView;
    private ListEditorAdapter mAdapter;

    private List<Map<String, String>> mData = new ArrayList<Map<String, String>>();
    private List<Map<String, String>> mmData = new ArrayList<Map<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        // mContext = this;
       /* for (int i = 0; i < 100; i++) {
            list.add("test data");
        }*/
        idEdit = (EditText) findViewById(R.id.edittext_id);
        textView = (TextView) findViewById(R.id.textview_modify);
        listView = (ListView) findViewById(R.id.listview);
        mAdapter = new ListEditorAdapter(this);
        listView.setAdapter(mAdapter);
        for (int i = 0; i < 20; i++) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("1", i + "");
            mData.add(item);
            Map<String, String> item2 = new HashMap<String, String>();
            item2.put("2", i + "");
            mmData.add(item2);

        }
        mAdapter.setData(mData, mmData);
        mAdapter.notifyDataSetChanged();

        /*//动态刷新
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idStr = idEdit.getText().toString();
                int idInt = Integer.parseInt(idStr);
                //MyAdapter.updataView(idInt, listView);//动态修改
                //Toast.makeText(MainActivity.this, "請輸入id！", Toast.LENGTH_SHORT).show();
            }
        });*/
    }





   /* private class MyBaseAdapter extends BaseAdapter {
        private Context context = null;
        private LayoutInflater mLayoutInflater;
        private List<String> list;

        public MyBaseAdapter(Context context, List<String> list) {
            this.context = context;
            this.list = list;
            mLayoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return 20;
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.main_listview_item, null);
                holder = new ViewHolder();
                holder.editText = (EditText) convertView.findViewById(R.id.et22);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.editText.setText("helloworld!");
            return convertView;
        }
    }*/
}
