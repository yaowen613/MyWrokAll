package com.yaowen.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.yaowen.classUtil.DatePicker;
import com.yaowen.dateselector.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListEditorAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<Map<String, String>> mData;// 存储的editTex值
    private List<Map<String, String>> mmData;//存儲datepicker類的edittext的值
    private Map<String, String> editorValue = new HashMap<String, String>();
    //private static HashMap<Integer, Boolean> isSelected;

    public ListEditorAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }


    public void setData(List<Map<String, String>> data, List<Map<String, String>> mmData) {
        this.mData = data;
        this.mmData = mmData;
        init();
    }

    private void init() {
        editorValue.clear();
        /*isSelected = new HashMap<Integer, Boolean>();
        if (mData != null) {
			for (int i = 0; i < mData.size(); i++) {
				isSelected.put(i, false);
			}
		}*/
    }

    @Override
    public int getCount() {
        if (mData != null) {
            return mData.size();
        }
       /* if (mmData!=null){
            return mmData.size();
        }*/
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private Integer index = -1;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.d("tag", "position = " + position);
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.main_listview_item, null);
            holder = new ViewHolder();
            //holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox1);
            //holder.textView = (TextView) convertView.findViewById(R.id.text1);
            //holder.downbtn = (Button) convertView.findViewById(R.id.downbtn1);
            //holder.downbtn.setFocusable(false);
            //holder.downbtn.setFocusableInTouchMode(false);
            //holder.upbtn = (Button) convertView.findViewById(R.id.upbtn1);
            //holder.downbtn.setFocusable(false);
            //holder.downbtn.setFocusableInTouchMode(false);
            holder.datePicker = (DatePicker) convertView.findViewById(R.id.myDatePicker);
            holder.datePicker.getEditText().setTag(position);
            holder.datePicker.getEditText().setOnTouchListener(new MyOnTouchListener());

            holder.numEdit = (EditText) convertView.findViewById(R.id.et22);
            holder.numEdit.setTag(position);
            holder.numEdit.setOnTouchListener(new MyOnTouchListener());

            class MyTextWatcher implements TextWatcher {

                public MyTextWatcher(ViewHolder holder) {
                    mHolder = holder;
                }

                private ViewHolder mHolder;

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s != null && !"".equals(s.toString())) {
                        int position = (Integer) mHolder.numEdit.getTag();
                        // 当EditText数据发生改变的时候存到mData变量中
                        mData.get(position).put("1", s.toString());
                    }
                }
            }
            class MyTextWatcher2 implements TextWatcher {

                public MyTextWatcher2(ViewHolder holder) {
                    mHolder = holder;
                }

                private ViewHolder mHolder;

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s != null && !"".equals(s.toString())) {
                        int position = (int) mHolder.datePicker.getEditText().getTag();
                        // 当datePicker的EditText数据发生改变的时候存到mmData变量中
                        mmData.get(position).put("2", s.toString());
                    }
                }
            }
            holder.numEdit.addTextChangedListener(new MyTextWatcher(holder));
            holder.datePicker.getEditText().addTextChangedListener(new MyTextWatcher2(holder));

			/*holder.downbtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					int position = (Integer) holder.numEdit.getTag();
					Log.d("tag", "clickposition = " + position);
					String edittextStr = holder.numEdit.getText().toString();
					int num = Integer.parseInt(edittextStr);
					num--;
					mData.get(position).put("list_item_inputvalue", num+"");
					holder.numEdit.setText(num+"");
				}
			});*/

			/*holder.upbtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					int position = (Integer) holder.numEdit.getTag();
					String edittextStr = holder.numEdit.getText().toString();
					int num = Integer.parseInt(edittextStr);
					num++;
					mData.get(position).put("list_item_inputvalue", num+"");
					holder.numEdit.setText(num+"");
				}
			});*/

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            holder.numEdit.setTag(position);
            holder.datePicker.getEditText().setTag(position);
        }

		/*holder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				int position = (Integer) holder.numEdit.getTag();
				isSelected.put(position, isChecked);
			}
		});*/

        //holder.checkBox.setChecked(isSelected.get(position));

        Object value = mData.get(position).get("1");
        if (value != null && !"".equals(value)) {
            holder.numEdit.setText(value.toString());
        } else {
            holder.numEdit.setText("0");
        }
        holder.numEdit.clearFocus();
        if (index != -1 && index == position) {
            holder.numEdit.requestFocus();
        }

        Object value2 = mmData.get(position).get("2");
        if (value2 != null && !"".equals(value2)) {
            holder.datePicker.getEditText().setText(value2.toString());
        }
        holder.datePicker.getEditText().clearFocus();
        if (index != -1 && index == position) {
            holder.datePicker.getEditText().requestFocus();
        }

        return convertView;
    }

	/*public HashMap<Integer,Boolean> getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(HashMap<Integer,Boolean> isSelected) {
        this.isSelected = isSelected;
    }*/

    public class ViewHolder {
        //CheckBox checkBox;
        //TextView textView;
        //Button downbtn;
        EditText numEdit;
        //Button upbtn;
        DatePicker datePicker;

    }

    class MyOnTouchListener implements OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                index = (Integer) v.getTag();
            }
            return false;
        }
    }
}
