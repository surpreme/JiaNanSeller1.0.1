package com.aite.jiananseller.ui.activity.main;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.aite.jiananseller.R;
import com.aite.jiananseller.databinding.ActivityGoodsManagerBinding;
import com.aite.jiananseller.ui.customview.MMAlertDialog;
import com.aite.jiananseller.ui.vm.main.GoodsdManagerViewModel;
import com.aite.jiananseller.ui.vm.main.MsgCenterViewModel;
import com.aite.jiananseller.ui.vm.main.SearchViewModel;
import com.aite.jiananseller.utils.TableLineLengthUtils;
import com.blankj.rxbus.RxBus;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.bus.Messenger;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * @author:TQX
 * @Date: 2019/11/6
 * @description:
 */
public class GoodsManagerActivity extends BaseActivity<ActivityGoodsManagerBinding, GoodsdManagerViewModel> {
    private ArrayList<String> tab_title_list;//存放标签页标题
    private int page = 1;
    private String type = "0";

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_goods_manager;
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
        tab_title_list.add("上架商品");
        tab_title_list.add("违规商品");
        tab_title_list.add("待审核");
        tab_title_list.add("仓库");
        for (int i = 0; i < tab_title_list.size(); i++) {
            binding.tlPositionChoose.addTab(binding.tlPositionChoose.newTab().setText(tab_title_list.get(i)));
        }
        binding.tlPositionChoose.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        page = 1;
                        type = "0";
                        viewModel.getGoodsList(page);
                        break;
                    case 1:
                        page = 1;
                        type = "lock_up";
                        viewModel.getGoodsList("lock_up", page);
                        break;
                    case 2:
                        page = 1;
                        type = "wait_verify";
                        viewModel.getGoodsList("wait_verify", page);
                        break;
                    case 3:
                        page = 1;
                        type = "verified";
                        viewModel.getGoodsList("verified", page);
                        break;

                }
                Messenger.getDefault().send(viewModel.observableList.size() == 0 ? "NODATA" : "HAVEDATA", GoodsdManagerViewModel.TOKEN_NODATA_REFRESH);


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.rvGoodsList.setAdapter(new BindingRecyclerViewAdapter());
        binding.etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("type", 1);
                switch (binding.tlPositionChoose.getSelectedTabPosition()) {
                    case 1:
                        bundle.putString("goodsType", "lock_up");
                        bundle.putInt("type", 2);
                        break;
                    case 2:
                        bundle.putString("goodsType", "wait_verify");
                        bundle.putInt("type", 2);
                        break;
                    case 3:
                        bundle.putString("goodsType", "verified");
                        bundle.putInt("type", 2);
                        break;
                }
                startActivity(SearchActivity.class, bundle);
            }
        });
        Messenger.getDefault().register(this, GoodsdManagerViewModel.TOKEN_NODATA_REFRESH, String.class, s -> {
            binding.nodataIv.setVisibility(s.equals("NODATA") ? View.VISIBLE : View.GONE);
        });
        RxBus.getDefault().subscribe(this, "deleteGoodsPosition", new RxBus.Callback<Integer>() {
            @Override
            public void onEvent(Integer integer) {
                showDeleteDialog(integer);
            }
        });
        RxBus.getDefault().subscribe(this, "ShowPosition", new RxBus.Callback<Integer>() {
            @Override
            public void onEvent(Integer integer) {
                viewModel.ShowGoods(integer);
            }
        });
        RxBus.getDefault().subscribe(this, "unShowPosition", new RxBus.Callback<Integer>() {
            @Override
            public void onEvent(Integer integer) {
                viewModel.unShowGoods(integer);
//                showDeleteDialog(integer);
            }
        });
        binding.refreshLayout.setEnableAutoLoadMore(true);//开启自动加载功能（非必须）
        binding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 1;
                        if (type.equals("0")) {
                            viewModel.getGoodsList(page);
                        } else {
                            viewModel.getGoodsList(type, page);
                        }
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
                        if (type.equals("0")) {
                            viewModel.getGoodsList(page);
                        } else {
                            viewModel.getGoodsList(type, page);
                        }
                        refreshLayout.finishLoadMore();
                    }
                }, 500);
            }
        });
        viewModel.setIsHasMoreListner(new GoodsdManagerViewModel.IsHasMoreListner() {
            @Override
            public void back(boolean isHasMore) {
                if (isHasMore) {
                    binding.refreshLayout.setNoMoreData(false);
                } else {
                    binding.refreshLayout.finishLoadMoreWithNoMoreData();
                }
            }
        });
    }

    private void showDeleteDialog(int position) {
        MMAlertDialog.showDialog(this, "", "确定删除此商品吗", "取消", "确定", true,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        viewModel.deleteGoods(position);
                    }
                });
    }
}
