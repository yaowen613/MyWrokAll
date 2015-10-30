package com.yaowen.dateselector;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.yaowen.classUtil.CheckboxGroup;
import com.yaowen.classUtil.DatePicker;

public class MainActivity extends AppCompatActivity {
    //    private ImageButton dataButton;
//    private Button timeButton;
//    private EditText editTextDate;
//    private EditText editTextTime;
//    private final static int DATE_DIALOG = 0;
//    private final static int TIME_DIALOG = 1;
//    private Calendar calendar;
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
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.main, null);
            }
            datePicker = (DatePicker) convertView.findViewById(R.id.myDatePicker);
            //checkboxGroup = (CheckboxGroup) convertView.findViewById(R.id.radioGroup);
            //radioGroup = (RadioGroup) convertView.findViewById(R.id.radioGroup);
            return convertView;
        }
    }
//         datePicker = (DatePicker) findViewById(R.id.myDatePicker);
//        //datePicker.setEditText("NIHAO");
////        Date date = new Date();
////
////       String dateFormat="yyyy-MM-dd hh:mm:ss";
////        //String dateStr = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss").format(date);
////        Log.d("TAG", "date:" + date);
////        //datePicker.setValue(date);
////        datePicker.setValue(date, dateFormat);
////        //Log.d("TAG", datePicker.getValue());
////        Date date1=datePicker.getValue();
//        Log.d("TAG", datePicker.getInitValue());
//        datePicker.setDateChangeListener(new DatePicker.OnDateChangeListener() {
//            @Override
//            public void OnDateChanged(View datePicker, Date date) {
//            }
//        });
//        datePicker.setOnTextChangeListener(new DatePicker.OnTextChangeListener() {
//            @Override
//            public void OnTextChanged(View datePicker, String text) {
//            }
//        });
//       /* setContentView(R.layout.activity_main);
//        editTextDate = (EditText) findViewById(R.id.et);
//        editTextTime= (EditText) findViewById(R.id.et2);
//        dataButton = (ImageButton) findViewById(R.id.dateBtn1);
//        timeButton = (Button) findViewById(R.id.timeBtn);
//        dataButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog(DATE_DIALOG);
//            }
//        });
//        timeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog(TIME_DIALOG);
//            }
//        });
//    }
//
//    *//**
//     * 创建日期及时间选择对话框
//     *//*
//    @Override
//    protected Dialog onCreateDialog(int id) {
//        Dialog dialog = null;
//        switch (id) {
//            case DATE_DIALOG: {
//                calendar = Calendar.getInstance();
//                dialog = new DatePickerDialog(
//                        this,
//                        new DatePickerDialog.OnDateSetListener() {
//
//                            @Override
//                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                                Log.d("TAG","this is a debug text!");
//                                editTextDate.setText("您选择了：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
//                            }
//                        },
//                        calendar.get(Calendar.YEAR),//传入年
//                        calendar.get(Calendar.MONTH),//传入月
//                        calendar.get(Calendar.DAY_OF_MONTH)//传入日
//                );
//                break;
//            }
//            case TIME_DIALOG:{
//                calendar = Calendar.getInstance();
//                dialog = new TimePickerDialog(
//                        this,
//                        new TimePickerDialog.OnTimeSetListener(){
//
//                            @Override
//                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                                editTextTime.setText("您选择了：" + hourOfDay + "时" + minute + "分");
//                            }
//                        },
//                        calendar.get(Calendar.HOUR_OF_DAY),
//                        calendar.get(Calendar.MINUTE),
//                        false
//                );
//                break;
//            }
//        }
//        return dialog;*/

}
