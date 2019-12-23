package com.aite.jiananseller.ui.customview;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.utils.DensityUtils;

import androidx.appcompat.app.AlertDialog;

public class MMAlertDialog {
    /**
     * @param context      上下文
     * @param title        顶部标题
     * @param btnText      按钮的文字
     * @param touchOutside 点击外部取消
     * @return
     */
    public synchronized static AlertDialog showDialogXieYi(Context context,
                                                           String title,
                                                           String content,
                                                           String btnText,
                                                           boolean touchOutside
    ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(touchOutside);
        dialog.setCancelable(false);

        // 是否包含标题，设置Title
        if (TextUtils.isEmpty(title)) {
            title = "提示";
        }
        View view = View.inflate(context, R.layout.alert_dialog_xieyi, null);
        //提示框title
        TextView tvTitle = view.findViewById(R.id.alert_tv_title);
        //网页webView
//        WebView webView = view.findViewById(R.id.alert_wv);
        TextView webView = view.findViewById(R.id.alert_wv);
        //按钮
        Button button = view.findViewById(R.id.alert_btn);
        //finish按钮
        ImageView imageView = view.findViewById(R.id.alert_iv_finish);
        webView.setText(content);
        tvTitle.setText(title);
        button.setText(TextUtils.isEmpty(btnText) ? "确定" : btnText);
//        webView.setWebViewClient(new WebViewClient());
//        webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        //设置webView里字体大小
//        WebSettings settings = webView.getSettings();
//        settings.setTextZoom(55);
//        settings.setJavaScriptEnabled(true);
//        settings.setSupportZoom(true);
//        settings.setBuiltInZoomControls(true);
//        webView.loadUrl(webUrl);
        final AlertDialog dialogFinal = dialog;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setWindowAnimations(R.style.AnimMM);
        dialog.setContentView(view);

        return dialog;
    }

    /**
     * @param context        上下文
     * @param title          标题
     * @param content        内容
     * @param btnCancleText  取消按钮文本
     * @param btnSureText    确定按钮文本
     * @param touchOutside   外部取消
     * @param cancleListener 取消监听
     * @param sureListener   确定监听
     * @return
     */
    public synchronized static AlertDialog showDialog(Context context,
                                                      String title,
                                                      String content,
                                                      String btnCancleText,
                                                      String btnSureText,
                                                      boolean touchOutside,
                                                      DialogInterface.OnClickListener cancleListener,
                                                      DialogInterface.OnClickListener sureListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(touchOutside);
        dialog.setCancelable(false);

        View view = View.inflate(context, R.layout.alert_dialog, null);
        //标题
        TextView tvTitle = view.findViewById(R.id.tv_alert_title);
        //内容
        TextView tvContent = view.findViewById(R.id.tv_alert_content);
        //取消按钮
        Button buttonCancle = view.findViewById(R.id.btn_alert_cancel);
        //确定按钮
        Button buttonOk = view.findViewById(R.id.btn_alert_ok);
        //线
        View viewLine = view.findViewById(R.id.v_alert_line);

        if (TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.GONE);
        } else {
            tvTitle.setText(title);
        }

        tvContent.setText(TextUtils.isEmpty(content) ? "" : content);

        if (TextUtils.isEmpty(btnCancleText)) {
            buttonCancle.setVisibility(View.GONE);
            viewLine.setVisibility(View.GONE);
        } else {
            buttonCancle.setText(btnCancleText);
        }

        buttonOk.setText(TextUtils.isEmpty(btnSureText) ? "确定" : btnSureText);
        final AlertDialog dialogFinal = dialog;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
            }
        });

        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setWindowAnimations(R.style.AnimMM);
        dialog.setContentView(view);

        return dialog;
    }

    /**
     * @param context      上下文
     * @param touchOutside 外部取消
     * @return
     */
    public synchronized static AlertDialog showChoosePhotoDialog(Context context,
                                                                 boolean touchOutside,
                                                                 DialogInterface.OnClickListener cancleListener,
                                                                 DialogInterface.OnClickListener sureListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(touchOutside);
        dialog.setCancelable(true);

        View view = View.inflate(context, R.layout.alert_choose_photo, null);
        //标题
        TextView tvLocalPhoto = view.findViewById(R.id.tv_local_photo);
        //内容
        TextView tvSpacePhoto = view.findViewById(R.id.tv_space_photo);

        final AlertDialog dialogFinal = dialog;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        tvLocalPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });
        tvSpacePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
            }
        });

        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setWindowAnimations(R.style.AnimMM);
        dialog.setContentView(view);

        return dialog;
    }

    /**
     * @param context        上下文
     * @param title          标题
     * @param btnCancleText  取消按钮文本
     * @param btnSureText    确定按钮文本
     * @param touchOutside   外部取消
     * @param cancleListener 取消监听
     *                       //     * @param sureListener   确定监听
     * @return
     */
    public synchronized static AlertDialog showAddTypeDialog(Context context,
                                                             String title,
                                                             String btnCancleText,
                                                             String btnSureText,
                                                             boolean touchOutside,
                                                             DialogInterface.OnClickListener cancleListener,
                                                             OnAddTypeListner onAddTypeListner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(touchOutside);
        dialog.setCancelable(false);

        View view = View.inflate(context, R.layout.alert_dialog_add_goods_type, null);
        //标题
        TextView tvTitle = view.findViewById(R.id.tv_alert_title);
        //内容
        EditText etContent = view.findViewById(R.id.tv_alert_content);
        //取消按钮
        Button buttonCancle = view.findViewById(R.id.btn_alert_cancel);
        //确定按钮
        Button buttonOk = view.findViewById(R.id.btn_alert_ok);
        //线
        View viewLine = view.findViewById(R.id.v_alert_line);

        if (TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.GONE);
        } else {
            tvTitle.setText(title);
        }


        if (TextUtils.isEmpty(btnCancleText)) {
            buttonCancle.setVisibility(View.GONE);
            viewLine.setVisibility(View.GONE);
        } else {
            buttonCancle.setText(btnCancleText);
        }

        buttonOk.setText(TextUtils.isEmpty(btnSureText) ? "确定" : btnSureText);
        final AlertDialog dialogFinal = dialog;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
//        final DialogInterface.OnClickListener finalSureListener = sureListener;
        final OnAddTypeListner monAddTypeListner = onAddTypeListner;
        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
                monAddTypeListner.onClick(etContent.getText().toString());
                dialog.dismiss();
            }
        });

        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setWindowAnimations(R.style.AnimMM);
        dialog.setContentView(view);

        return dialog;
    }

    public interface OnAddTypeListner {
        void onClick(String name);
    }

    public void setOnAddTypeListner(OnAddTypeListner onAddTypeListner) {
        this.onAddTypeListner = onAddTypeListner;
    }

    public OnAddTypeListner onAddTypeListner = null;


}
