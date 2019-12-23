package com.aite.jiananseller.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;

import com.aite.jiananseller.R;
import com.aite.jiananseller.databinding.ActivityGroupLsitBinding;
import com.aite.jiananseller.ui.adapter.GroupListAdapter;
import com.aite.jiananseller.ui.vm.main.GroupListViewModel;
import com.aite.jiananseller.utils.BeanConvertor;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.recyclerview.widget.LinearLayoutManager;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * @author:TQX
 * @Date: 2019/11/24
 * @description:
 */
public class GroupListActivity extends BaseActivity<ActivityGroupLsitBinding, GroupListViewModel> {
    private List<String> typeList = new ArrayList<>();
    private GroupListAdapter adapter;
    private ArrayList<ArrayList<String>> allTypelist = new ArrayList<>();

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_group_lsit;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.title.tvTitle.setText("组合列表");
        binding.tvCommit.setOnClickListener((v) -> {
            Intent intent = new Intent();
            intent.putExtra("resultList", JSON.toJSONString(adapter.getSpecBeanList()));
            setResult(RESULT_OK, intent);
            onBackPressed();
        });
        binding.title.ivReturn.setOnClickListener((v) -> onBackPressed());

        allTypelist = (ArrayList<ArrayList<String>>) getIntent().getBundleExtra("bundle").getSerializable("AllList");
        descartes(allTypelist, new ArrayList<List<String>>(), 0, new ArrayList<>());
//        typeList.addAll(Objects.requireNonNull(getIntent().getStringArrayListExtra("AllList")));
        adapter = new GroupListAdapter(typeList);
        binding.rvGrouppList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvGrouppList.setAdapter(adapter);
    }


    //笛卡尔积算法
    private void descartes(List<ArrayList<String>> dimvalue, List<List<String>> result, int layer, List<String> curList) {

        if (layer < dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                descartes(dimvalue, result, layer + 1, curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    descartes(dimvalue, result, layer + 1, list);
                }
            }
        } else if (layer == dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                result.add(curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    result.add(list);
                }
            }
        }
        typeList.clear();
        for (List<String> resultList : result) {
            String newType = "";
            for (int i = 0; i < resultList.size(); i++) {
                if (i == 0) {
                    newType = resultList.get(i);
                } else {
                    newType = newType + "-" + resultList.get(i);
                }
            }
            typeList.add(newType);
        }
    }

}
