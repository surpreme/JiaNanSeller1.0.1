package com.aite.jiananseller.ui.customview;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.bean.AreaCodeBean;
import com.aite.jiananseller.ui.activity.login.LoginActivity;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * @author:TQX
 * @Date: 2019/6/11
 * @description:
 */
public class Nearpopu extends PopupWindow implements View.OnClickListener {
    private Activity mActivity = null;
    private ListView lv_nearpopulist;
    public MyAdapter myadapter;
    //    private juliAdapter jla;
    private List<AreaCodeBean.ListBean> areaList;

    public void AdapterNotify() {
        myadapter.notifyDataSetChanged();
    }

    public Nearpopu(Activity activity, List<AreaCodeBean.ListBean> areaList) {
        myadapter = new MyAdapter();
//        jla = new juliAdapter();
        mActivity = activity;
//        this.arealist = lingshi.getInstance().getArealist();
//        this.categoryOne = lingshi.getInstance().getCategoryOne();
        this.areaList = areaList;

        // 设置SelectPicPopupWindow弹出窗体的宽
        setWidth(ActionBar.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        setHeight(ActionBar.LayoutParams.WRAP_CONTENT);
        WindowManager wm = (WindowManager) mActivity
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        View view = View.inflate(mActivity, R.layout.nearpopu, null);
        lv_nearpopulist = (ListView) view.findViewById(R.id.lv_nearpopulist);
        lv_nearpopulist.setAdapter(myadapter);


        setContentView(view);
        // 设置点击视图之外的地方是否取消当前的PopupWindow
        setFocusable(true);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        setBackgroundDrawable(dw);

        setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = mActivity
                        .getWindow().getAttributes();
                lp.alpha = 1f;
                mActivity.getWindow().setAttributes(lp);
            }
        });
        // 外部可被操作
        setOutsideTouchable(true);
        // setFocusable(false);

        // switch (popwstyle) {
        // case 0:
        // // 设置PopupWindow弹出窗体动画效果
        // setAnimationStyle(R.style.AnimnearPopup);
        // break;
        // case 1:
        // 设置PopupWindow弹出窗体动画效果
        setAnimationStyle(R.style.AnimnearPopup1);
        // break;
        // case 2:
        // // 设置PopupWindow弹出窗体动画效果
        // setAnimationStyle(R.style.AnimnearPopup2);
        // break;
        //
        // }
    }


    @Override
    public void onClick(View v) {

    }


    public interface OnItemClickListner{
        void  result(int position);
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public OnItemClickListner onItemClickListner =null;

    /**
     * 区域适配
     *
     * @author Administrator
     */
    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return null == areaList ? 0 : areaList.size();
        }

        @Override
        public Object getItem(int position) {

            return areaList == null ? null : areaList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(mActivity, R.layout.layout_area_list,
                        null);
                new ViewHolder(convertView);
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.tv_country.setText(areaList.get(position).getArea_name());
            holder.tv_area_num.setText(areaList.get(position).getCode());
            Glide.with(mActivity).load(areaList.get(position).getIcon()).into(holder.iv_country);
            holder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListner !=null){
                        onItemClickListner.result(position);
                    }
                }
            });

            return convertView;
        }

        class ViewHolder {
            TextView tv_country;
            ImageView iv_country;
            TextView tv_area_num;
            ConstraintLayout item;

            public ViewHolder(View convertView) {
                tv_country = (TextView) convertView.findViewById(R.id.tv_country);
                iv_country = (ImageView) convertView.findViewById(R.id.iv_country);
                tv_area_num = (TextView) convertView.findViewById(R.id.tv_area_num);
                item = (ConstraintLayout) convertView.findViewById(R.id.item);
//                item.setOnClickListener(listener);
                convertView.setTag(this);
            }
        }
    }


    private void touming(ListView view, int x) {
        Animation animation = AnimationUtils.loadAnimation(mActivity, x);
        view.startAnimation(animation);
    }

}
