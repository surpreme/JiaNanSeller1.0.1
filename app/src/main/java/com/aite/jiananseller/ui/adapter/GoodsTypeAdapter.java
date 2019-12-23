package com.aite.jiananseller.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.base.BaseRecyclerViewAdapter;
import com.aite.jiananseller.bean.GoodsTypeBean;
import com.aite.jiananseller.ui.customview.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/23
 * @description:
 */
public class GoodsTypeAdapter extends BaseRecyclerViewAdapter<GoodsTypeBean.SpecListBean> {
    private GoodTypeItemAdapter itemAdapter;
    private List<List<GoodsTypeBean.SpecListBean.ValueBeanX>> Alllist = new ArrayList<List<GoodsTypeBean.SpecListBean.ValueBeanX>>();
    private List<GoodsTypeBean.SpecListBean.ValueBeanX> valueBeanXList;
    private Context context;
    private List<GoodsTypeBean.SpecListBean> datas;

    public GoodsTypeAdapter(Context context,List<GoodsTypeBean.SpecListBean> datas) {
        super(datas);
        this.context=context;
        this.datas =datas;

    }

    public void setDate(List<GoodsTypeBean.SpecListBean> datas){
        for (int i = 0; i < datas.size(); i++) {
            Alllist.add(new ArrayList<>());
        }
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.layout_goods_type;
    }

    @Override
    public void convert(VH holder, GoodsTypeBean.SpecListBean data, int position) {
        holder.setText(R.id.tv_title,data.getSp_name());
        MyGridView rvItem = holder.getView(R.id.gv_item);
        valueBeanXList = new ArrayList<>();
        valueBeanXList.addAll(data.getValue());
        itemAdapter = new GoodTypeItemAdapter(context,valueBeanXList);
        itemAdapter.setMaxSize(1000);
        rvItem.setAdapter(itemAdapter);
        rvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == valueBeanXList.size()) {

                }
            }
        });
        itemAdapter.setOnOnAddTypeListner(new GoodTypeItemAdapter.OnAddTypeListner() {
            @Override
            public void result(int position) {
                onAddTypeListner.result(data.getSp_id());
            }
        });
        itemAdapter.setOnAddListListner(new GoodTypeItemAdapter.OnAddListListner() {
            @Override
            public void result(List<GoodsTypeBean.SpecListBean.ValueBeanX> list) {
                Alllist.set(position,list);
                onReturnTypeListListner.result(Alllist);
            }
        });
    }
    public interface OnAddTypeListner {
        void result(int sp_id);
    }

    public void setOnOnAddTypeListner (OnAddTypeListner onAddTypeListner) {
        this.onAddTypeListner = onAddTypeListner;
    }

    public OnAddTypeListner onAddTypeListner = null;

    public interface OnReturnTypeListListner {
        void result(List<List<GoodsTypeBean.SpecListBean.ValueBeanX>> Alllist) ;
    }

    public void setOnReturnTypeListListner(OnReturnTypeListListner onReturnTypeListListner) {
        this.onReturnTypeListListner = onReturnTypeListListner;
    }

    public OnReturnTypeListListner onReturnTypeListListner = null;
}
