package com.aite.jiananseller.ui.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.aite.jiananseller.R;
import com.aite.jiananseller.base.BaseRecyclerViewAdapter;
import com.aite.jiananseller.bean.SpecBean;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/24
 * @description:
 */
public class GroupListAdapter extends BaseRecyclerViewAdapter<String> {
    private EditText et_price, et_count, et_warning, et_good_name;

    private List<SpecBean> specBeanList;

    public List<SpecBean> getSpecBeanList() {


        return specBeanList;
    }

    public GroupListAdapter(List<String> datas) {
        super(datas);
        specBeanList = new ArrayList<>();

        for (int i = 0; i < datas.size(); i++) {
            String[]  strings= datas.get(i).split("-");
            List<String> stringList = Arrays.asList(strings);
            SpecBean specBean = new SpecBean();
            specBean.setSp_value_color("");
            specBean.setValue(new ArrayList<>());
            for (int i1 = 0; i1 < stringList.size(); i1++) {
                SpecBean.ValueBean valueBean = new SpecBean.ValueBean("",stringList.get(i1));
                specBean.getValue().add(valueBean);
            }
            specBeanList.add(specBean);
        }



    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.layout_group_list;
    }

    @Override
    public void convert(VH holder, String data, int position) {
        holder.setText(R.id.tv_title, data);
        et_price = holder.getView(R.id.et_price);
        et_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                specBeanList.get(position).setPrice(s.toString());
            }
        });
        et_count = holder.getView(R.id.et_count);
        et_count.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                specBeanList.get(position).setSku(s.toString());
            }
        });
        et_warning = holder.getView(R.id.et_warning);
        et_warning.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                specBeanList.get(position).setAlarm(s.toString());
            }
        });
        et_good_name = holder.getView(R.id.et_good_name);
        et_good_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                specBeanList.get(position).setStock(s.toString());
            }
        });
    }

    public interface OnGetDataListner{
        void result ();
    }

    public void setOnGetDataListner(OnGetDataListner onGetDataListner) {
        this.onGetDataListner = onGetDataListner;
    }

    public OnGetDataListner onGetDataListner = null;
}
