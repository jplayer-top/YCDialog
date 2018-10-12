package com.pedaily.yc.ycdialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mTv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        mTv1 = (TextView) findViewById(R.id.tv_1);


        mTv1.setOnClickListener(this);
        findViewById(R.id.tv_2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_1:
                showPopupWindow();
                break;
            case R.id.tv_2:
                Toast.makeText(this,"吐司",Toast.LENGTH_SHORT).show();
                showDialogFragment();
                break;
        }
    }

    private void showPopupWindow() {
        //创建对象
        PopupWindow popupWindow = new PopupWindow(this);
        View inflate = LayoutInflater.from(this).inflate(R.layout.view_pop_custom, null);
        //设置view布局
        popupWindow.setContentView(inflate);
        popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //设置动画的方法
        popupWindow.setAnimationStyle(R.style.BottomDialog);
        //设置PopUpWindow的焦点，设置为true之后，PopupWindow内容区域，才可以响应点击事件
        popupWindow.setTouchable(true);
        //设置背景透明
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        //点击空白处的时候让PopupWindow消失
        popupWindow.setOutsideTouchable(true);
        // true时，点击返回键先消失 PopupWindow
        // 但是设置为true时setOutsideTouchable，setTouchable方法就失效了（点击外部不消失，内容区域也不响应事件）
        // false时PopupWindow不处理返回键，默认是false
        popupWindow.setFocusable(false);
        //设置dismiss事件
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        boolean showing = popupWindow.isShowing();
        if (!showing){
            //show，并且可以设置位置
            popupWindow.showAsDropDown(mTv1);
        }
        //popupWindow.dismiss();
    }


    private void showDialogFragment() {
        CustomDialogFragment.showDialog(this);
    }


}
