package com.aite.baselibrary.view.util.PopupWindows;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aite.baselibrary.R;
import com.aite.baselibrary.view.util.screen.ScreenUtils;
import com.aite.baselibrary.window.ActivityManager;

/**
 * @Auther: valy
 * @datetime: 2019-12-21
 * @desc:
 */
public class PopupWindowsUtils {
    private volatile static PopupWindowsUtils mInstance;
    private PopupWindow popupWindow;
    private static final int bottom_recyandcanceLayout = R.layout.base_bottom_recyandcancel_pop;
    private static final int dailog_talk_Layout = R.layout.base_talk_dailog_pop;
    private static final int dailog_advice_Layout = R.layout.base_advice_dailog_pop;
    private static final int dailog_sencond_advice_Layout = R.layout.base_advice_two_dailog_pop;

    public static PopupWindowsUtils getmInstance() {
        if (mInstance == null) {
            synchronized (PopupWindowsUtils.class) {
                if (mInstance == null) {
                    mInstance = new PopupWindowsUtils();
                }
            }
        }
        return mInstance;
    }

    public void showBottomRecyAndCancelPopupWindow(final Context context, RecyclerView.Adapter adapter, LinearLayoutManager linearLayoutManager) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(context).inflate(bottom_recyandcanceLayout, null);
        ScreenUtils.setBackGroundAlpha(0.5f, context);
        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, false);
        RecyclerView recycler_view = view.findViewById(R.id.recycler_view);
        TextView cancel_tv = view.findViewById(R.id.cancel_tv);
        cancel_tv.setOnClickListener(v -> popupWindow.dismiss());
        recycler_view.setAdapter(adapter);
        recycler_view.setLayoutManager(linearLayoutManager);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popupWindow.setOnDismissListener(() -> ScreenUtils.setBackGroundAlpha(1.0f, context));

    }

    public void showAdviceDialogPopupWindow(final Context context, String information, String sureStr, View.OnClickListener listenersure) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(dailog_advice_Layout, null);
        ScreenUtils.setBackGroundAlpha(0.6f, context);
        popupWindow = new PopupWindow(view, 650, LinearLayout.LayoutParams.WRAP_CONTENT, false);
        final TextView information_tv = view.findViewById(R.id.information_tv);
        final Button sure_btn = view.findViewById(R.id.sure_btn);
        view.setAlpha(0.9f);
        if (isStringUnEmpty(sureStr)) sure_btn.setText(sureStr);
        information_tv.setText(information);
        if (listenersure != null)
            sure_btn.setOnClickListener(listenersure);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ScreenUtils.setBackGroundAlpha(1.0f, context);
                dismissPopWindow();
            }
        });


    }

    public void showTwoAdviceDialogPopupWindow(final Context context, int information, int sencondInformation, String sureStr, View.OnClickListener listenersure) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(dailog_sencond_advice_Layout, null);
        ScreenUtils.setBackGroundAlpha(0.6f, context);
        popupWindow = new PopupWindow(view, ScreenUtils.getScreenWidth(ActivityManager.getInstance().getCurrentActivity()) / 5 * 4, LinearLayout.LayoutParams.WRAP_CONTENT, false);
        final TextView information_tv = view.findViewById(R.id.information_tv);
        final TextView second_information_tv = view.findViewById(R.id.second_information_tv);
        final Button sure_btn = view.findViewById(R.id.sure_btn);
        view.setAlpha(0.9f);
        if (isStringUnEmpty(sureStr)) sure_btn.setText(sureStr);
        second_information_tv.setText(sencondInformation);
        information_tv.setText(information);
        if (listenersure != null)
            sure_btn.setOnClickListener(listenersure);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ScreenUtils.setBackGroundAlpha(1.0f, context);
                dismissPopWindow();
            }
        });


    }

    public void showDialogPopupWindow(final Context context, String information, View.OnClickListener listenersure) {
        showDialogPopupWindow(context, information, listenersure, null);
    }


    public void showDialogPopupWindow(final Context context, String information, View.OnClickListener listenersure, View.OnClickListener listenercancel) {
        showDialogPopupWindow(context, information, null, null, listenersure, listenercancel);
    }

    public void showDialogPopupWindow(final Context context, String information, String sureStr, String cancelStr, View.OnClickListener listenersure, View.OnClickListener listenercancel) {
        showDialogPopupWindow(context, null, information, sureStr, cancelStr, listenersure, listenercancel);

    }

    public void showDialogPopupWindow(final Context context, String titles, String information, String sureStr, String cancelStr, View.OnClickListener listenersure, View.OnClickListener listenercancel) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(dailog_talk_Layout, null);
        ScreenUtils.setBackGroundAlpha(0.6f, context);
        popupWindow = new PopupWindow(view, 850, LinearLayout.LayoutParams.WRAP_CONTENT, false);
        final TextView title_tv = view.findViewById(R.id.title_tv);
        final TextView information_tv = view.findViewById(R.id.information_tv);
        final Button sure_btn = view.findViewById(R.id.sure_btn);
        final Button cancel_btn = view.findViewById(R.id.cancel_btn);
        information_tv.setLines(3);
        view.setAlpha(0.9f);
        if (isStringUnEmpty(titles)) title_tv.setText(titles);
        if (isStringUnEmpty(sureStr)) sure_btn.setText(sureStr);
        if (isStringUnEmpty(cancelStr)) cancel_btn.setText(cancelStr);
        information_tv.setText(information);
        sure_btn.setOnClickListener(listenersure);
        if (listenercancel == null) {
            cancel_btn.setOnClickListener(v -> {
                ScreenUtils.setBackGroundAlpha(1.0f, context);
                dismissPopWindow();
            });
        } else {
            cancel_btn.setOnClickListener(listenercancel);
        }

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ScreenUtils.setBackGroundAlpha(1.0f, context);
                dismissPopWindow();
            }
        });

    }

    private boolean isStringUnEmpty(String str) {
        return str != null && !str.equals("") && !str.equals("null");
    }

    public void dismissPopWindow() {
        if (popupWindow != null)
            popupWindow.dismiss();
    }
}
