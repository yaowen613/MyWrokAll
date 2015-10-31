package com.yaowen.dateselector;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.yaowen.classUtil.CheckboxGroup;
import com.yaowen.classUtil.DatePicker;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private DatePicker datePicker;
    private CheckboxGroup checkboxGroup;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        listView = (ListView) findViewById(R.id.listview);
        MyBaseAdapter adapter = new MyBaseAdapter(this);
        listView.setAdapter(adapter);
    }

    private class MyBaseAdapter extends BaseAdapter {
        private Context context = null;
        private LayoutInflater mLayoutInflater;
        int index = 0;

        public MyBaseAdapter(Context context) {
            this.context = context;
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 10;
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

            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.main, null);
            }
            // 不要直接new一个Layout去赋值给convertView！！那样就不是重用了，否则，后果自负～～
            datePicker = (DatePicker) convertView.findViewById(R.id.myDatePicker);
            EditText editText = (EditText) convertView.findViewById(R.id.et22);
            editText.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent event) {
                    // 在TOUCH的UP事件中，要保存当前的行下标，因为弹出软键盘后，整个画面会被重画
                    // 在getView方法的最后，要根据index和当前的行下标手动为EditText设置焦点
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        index = position;
                    }
                    return false;
                }
            });
            editText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                }

                public void beforeTextChanged(CharSequence text, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence text, int start, int before, int count) {
                    // 在这个地方添加你的保存文本内容的代码，如果不保存，你就等着重新输入吧
                    // 而且不管你输入多少次，也不会有用的，因为getView全清了～～
                }
            });
            // 这个地方可以添加将保存的文本内容设置到EditText上的代码，会有用的～～

            editText.clearFocus();
            if (index != -1 && index == position) {
                // 如果当前的行下标和点击事件中保存的index一致，手动为EditText设置焦点。
                editText.requestFocus();
            }

            // 这个时候返回的东东，就是ListView对应行下标的那一行的内容。
            //checkboxGroup = (CheckboxGroup) convertView.findViewById(R.id.radioGroup);
            //radioGroup = (RadioGroup) convertView.findViewById(R.id.radioGroup);

            return convertView;
        }
    }
}
