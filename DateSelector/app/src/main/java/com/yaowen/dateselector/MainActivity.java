package com.yaowen.dateselector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yaowen.adapter.MyAdapter;
import com.yaowen.classUtil.CheckboxGroup;
import com.yaowen.classUtil.DatePicker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    //private MainActivity mContext;
    private EditText idEdit;
    private TextView textView;
    private DatePicker datePicker;
    private CheckboxGroup checkboxGroup;
    private RadioGroup radioGroup;
    private List<String> list = new ArrayList<String>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        // mContext = this;
        for (int i = 0; i < 100; i++) {
            list.add("test data");
        }
        idEdit = (EditText) findViewById(R.id.edittext_id);
        textView = (TextView) findViewById(R.id.textview_modify);
        listView = (ListView) findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(this, list);
        listView.setAdapter(adapter);

        //动态刷新
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idStr = idEdit.getText().toString();
                int idInt = Integer.parseInt(idStr);
                MyAdapter.updataView(idInt, listView);//动态修改
                //Toast.makeText(MainActivity.this, "請輸入id！", Toast.LENGTH_SHORT).show();
            }
        });
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
                convertView = mLayoutInflater.inflate(R.layout.main, null);
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
