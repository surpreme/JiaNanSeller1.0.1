package com.aite.jiananseller.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.bean.GoodsTypeBean;
import com.aite.jiananseller.utils.DisplayUtil;
import com.aite.jiananseller.utils.XImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.aite.jiananseller.utils.ClutterUtils.getScreenWidth;

/**
 * @author:TQX
 * @Date: 2019/11/23
 * @description:
 */
public class GoodTypeItemAdapter extends ItemAdapter<GoodsTypeBean.SpecListBean.ValueBeanX> {
    private List<GoodsTypeBean.SpecListBean.ValueBeanX> beanList;
    private List<GoodsTypeBean.SpecListBean.ValueBeanX> list = new ArrayList<>();
    private int maxSize;
    //每个item的宽度
    private int itemWidth;

    private Context context;

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setList(List<GoodsTypeBean.SpecListBean.ValueBeanX> list) {
        this.beanList = list;
        notifyDataSetChanged();
    }

    public GoodTypeItemAdapter(Context context, List<GoodsTypeBean.SpecListBean.ValueBeanX> beanList) {
        super(context);
        this.context = context;
        this.beanList = beanList;
        //获取屏幕宽度

    }

    @Override
    public int getCount() {
        int dataSize = beanList == null ? 0 : beanList.size();
        if (dataSize == maxSize) {
            return dataSize;
        }
        return 1 + dataSize;
    }

    @Override
    public GoodsTypeBean.SpecListBean.ValueBeanX getItem(int position) {
        int dataSize = beanList == null ? 0 : beanList.size();
        if (dataSize == maxSize) {
            return beanList.get(position);
        } else if (position < dataSize) {
            return beanList.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    protected ItemAdapter.ViewHolder createHolder(int itemType) {
        View layout = LayoutInflater.from(context).inflate(R.layout.item_goods_type_content, null);
        return new ItemViewHolder(layout);
    }

    @Override
    protected void bindView(GoodsTypeBean.SpecListBean.ValueBeanX bean, ViewHolder holder, int posiotn) {
        ItemViewHolder h = (ItemViewHolder) holder;
        if (posiotn == /*getCount()-1*/beanList.size()) {
            h.ckType.setVisibility(View.GONE);
            h.addType.setVisibility(View.VISIBLE);
        } else {
            h.ckType.setText(bean.getSp_value_name());
        }
        h.addType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddTypeListner.result(posiotn);
            }
        });
        h.ckType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    h.ckType.setTextColor(Color.WHITE);
//                    list.add(bean.getSp_value_name());
                    list.add(bean);
                    onAddListListner.result(list);
                }else {
                    h.ckType.setTextColor(context.getResources().getColor(R.color.color_line));
//                    list.remove(bean.getSp_value_name())
                      list.remove(bean);
                    onAddListListner.result(list);
                }
            }
        });
    }

    class ItemViewHolder extends ViewHolder {
        @BindView(R.id.ck_type)
        CheckBox ckType;
        @BindView(R.id.add_type)
        TextView addType;
        @BindView(R.id.layout)
        ConstraintLayout layout;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            //将屏幕的中间间距为设为10均分3等分
//            itemWidth = (getScreenWidth(context) - DisplayUtil.dip2px(context, 20)) / 3;
//
//            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(itemWidth, itemWidth);
//            view.setLayoutParams(lp);
        }
    }

    public interface OnAddTypeListner {
        void result(int position);
    }

    public void setOnOnAddTypeListner (OnAddTypeListner onAddTypeListner) {
        this.onAddTypeListner = onAddTypeListner;
    }

    public OnAddTypeListner onAddTypeListner = null;

    public interface OnAddListListner{
        void result(List<GoodsTypeBean.SpecListBean.ValueBeanX> list);
    }

    public void setOnAddListListner(OnAddListListner onAddListListner) {
        this.onAddListListner = onAddListListner;
    }

    public OnAddListListner onAddListListner = null;

}
