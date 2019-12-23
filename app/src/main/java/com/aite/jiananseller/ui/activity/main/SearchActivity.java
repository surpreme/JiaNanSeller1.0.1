package com.aite.jiananseller.ui.activity.main;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.databinding.ActivitySearchBinding;
import com.aite.jiananseller.databinding.ActivityShipmentsBinding;
import com.aite.jiananseller.ui.customview.MMAlertDialog;
import com.aite.jiananseller.ui.customview.flowlayout.FlowLayout;
import com.aite.jiananseller.ui.customview.flowlayout.TagAdapter;
import com.aite.jiananseller.ui.customview.flowlayout.TagFlowLayout;
import com.aite.jiananseller.ui.vm.main.MsgCenterViewModel;
import com.aite.jiananseller.ui.vm.main.SearchViewModel;
import com.aite.jiananseller.ui.vm.main.ShipmentsViewModel;
import com.aite.jiananseller.utils.db.RecordsDao;
import com.blankj.rxbus.RxBus;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description: 搜索
 */
public class SearchActivity extends BaseActivity<ActivitySearchBinding, SearchViewModel> {
    private RecordsDao mRecordsDao;
    private List<String> recordList;
    private TagAdapter recordsAdapter;
    private int type = 1,page=1;
    private String goodsType,record;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_search;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        type = getIntent().getIntExtra("type", 1);
        recordList = new ArrayList<>();
        if (type == 1) {
            mRecordsDao = new RecordsDao(this, "007");//商品搜索
            viewModel.isGood = true;
        } else if (type == 2) {
            mRecordsDao = new RecordsDao(this, "007");//商品搜索
            goodsType = getIntent().getStringExtra("goodsType");
            viewModel.isGood = true;
        } else {
            mRecordsDao = new RecordsDao(this, "008");//订单搜索
            viewModel.isGood = false;
        }
        initView();
        getSearchHistory();
        RxBus.getDefault().subscribe(this, "deleteGoodsPosition", new RxBus.Callback<Integer>() {
            @Override
            public void onEvent(Integer integer) {
                showDeleteDialog(integer);
            }
        });
    }


    private void initView() {
        recordsAdapter = new TagAdapter<String>(recordList) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(SearchActivity.this).inflate(R.layout.tv_history,
                        binding.flSearchRecords, false);
                //为标签设置对应的内容
                tv.setText(s);
                return tv;
            }
        };
        binding.flSearchRecords.setAdapter(recordsAdapter);
        binding.flSearchRecords.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(View view, int position, FlowLayout parent) {
//                //清空editText之前的数据
                binding.etSearch.setText("");
                //将获取到的字符串传到搜索结果界面,点击后搜索对应条目内容
                binding.etSearch.setText(recordList.get(position));
                binding.etSearch.setSelection(binding.etSearch.length());
            }
        });
        binding.tvSearch.setOnClickListener((v) -> {
           record = binding.etSearch.getText().toString();
            if (!TextUtils.isEmpty(record)) {
                //添加数据
                mRecordsDao.addRecords(record);
                page =1;
                switch (type) {
                    case 1:
                        viewModel.getGoodsList(record,page);
                        break;
                    case 2:
                        viewModel.getGoodsList(goodsType, record,page);
                        break;
                    case 3:
                        viewModel.getOrderList(record,page);
                        break;
                }
            }
        });
        binding.clearAllRecords.setOnClickListener((v) -> {
            binding.flSearchRecords.setLimit(true);
            //清除所有数据
            mRecordsDao.deleteUsernameAllRecords();
        });
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    viewModel.clearList();
                }
            }
        });

        mRecordsDao.setNotifyDataChanged(new RecordsDao.NotifyDataChanged() {
            @Override
            public void notifyDataChanged() {
                getSearchHistory();
            }
        });
        binding.refreshLayout.setEnableAutoLoadMore(true);//开启自动加载功能（非必须）
        binding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        record = binding.etSearch.getText().toString();
                        page = 1;
                        switch (type) {
                            case 1:
                                viewModel.getGoodsList(record,page);
                                break;
                            case 2:
                                viewModel.getGoodsList(goodsType, record,page);
                                break;
                            case 3:
                                viewModel.getOrderList(record,page);
                                break;
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
                        record = binding.etSearch.getText().toString();
                        page++;
                        switch (type) {
                            case 1:
                                viewModel.getGoodsList(record,page);
                                break;
                            case 2:
                                viewModel.getGoodsList(goodsType, record,page);
                                break;
                            case 3:
                                viewModel.getOrderList(record,page);
                                break;
                        }
                        refreshLayout.finishLoadMore();
                    }
                }, 500);
            }
        });
        viewModel.setIsHasMoreListner(new SearchViewModel.IsHasMoreListner() {
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


    @SuppressLint("CheckResult")
    private void getSearchHistory() {
        Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> emitter) throws Exception {
                emitter.onNext(mRecordsDao.getRecordsByNumber(10));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> s) throws Exception {
                        recordList.clear();
                        recordList.addAll(s);
                        recordsAdapter.notifyDataChanged();
                    }
                });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRecordsDao.closeDatabase();
        mRecordsDao.removeNotifyDataChanged();
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
                        viewModel.deleteGoods(position);
                    }
                });
    }
}
