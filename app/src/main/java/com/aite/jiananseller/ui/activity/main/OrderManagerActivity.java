package com.aite.jiananseller.ui.activity.main;

import android.os.Bundle;

import com.aite.jiananseller.R;
import com.aite.jiananseller.databinding.ActivityOrderManagerBinding;
import com.aite.jiananseller.ui.vm.main.OrderdManagerViewModel;
import com.aite.jiananseller.ui.vm.main.SearchViewModel;
import com.aite.jiananseller.utils.TableLineLengthUtils;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * @author:TQX
 * @Date: 2019/11/6
 * @description:
 */
public class OrderManagerActivity extends BaseActivity<ActivityOrderManagerBinding, OrderdManagerViewModel> {
    private ArrayList<String> tab_title_list;//存放标签页标题
    private int page = 1;
    private String orderState = "store_order";

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_order_manager;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        tab_title_list = new ArrayList<>();
        binding.tlPositionChoose.post(new Runnable() {
            @Override
            public void run() {
                TableLineLengthUtils.setIndicator(binding.tlPositionChoose, 15, 15);
            }
        });
        tab_title_list.add("全部");
        tab_title_list.add("未付款");
        tab_title_list.add("待发货");
        tab_title_list.add("已发货");
        tab_title_list.add("已完成");
        for (int i = 0; i < tab_title_list.size(); i++) {
            binding.tlPositionChoose.addTab(binding.tlPositionChoose.newTab().setText(tab_title_list.get(i)));
        }
        binding.tlPositionChoose.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                page =1;
                switch (tab.getPosition()) {
                    case 0:
                        orderState = "store_order";
                        viewModel.getOrderList("store_order",page);
                        break;
                    case 1:
                        orderState = "state_new";
                        viewModel.getOrderList("state_new",page);
                        break;
                    case 2:
                        orderState = "state_pay";
                        viewModel.getOrderList("state_pay",page);
                        break;
                    case 3:
                        orderState = "state_send";
                        viewModel.getOrderList("state_send",page);
                        break;
                    case 4:
                        orderState = "state_success";
                        viewModel.getOrderList("state_success",page);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.rvGoodsList.setAdapter(new BindingRecyclerViewAdapter());
        binding.refreshLayout.setEnableAutoLoadMore(true);//开启自动加载功能（非必须）
        binding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 1;
                        viewModel.getOrderList(orderState,page);
                        refreshLayout.finishRefresh();
                        refreshLayout.resetNoMoreData();//setNoMoreData(false);
                    }
                }, 500);
            }
        });
        binding.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {

                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        viewModel.getOrderList(orderState,page);
                        refreshLayout.finishLoadMore();
                    }
                }, 500);
            }
       });
        viewModel.setIsHasMoreListner(new OrderdManagerViewModel.IsHasMoreListner() {
            @Override
            public void back(boolean isHasMore) {
                if (isHasMore){
                    binding.refreshLayout.setNoMoreData(false);
                }else {
                    binding.refreshLayout.finishLoadMoreWithNoMoreData();
                }
            }
        });
    }
}
