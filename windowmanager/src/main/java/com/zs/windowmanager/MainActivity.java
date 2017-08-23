package com.zs.windowmanager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WindowManager.LayoutParams mLayoutParams;
    private Button mButton;
    private WindowManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWindowButton();
    }

    private void setWindowButton() {
        mButton = new Button(this);
        mButton.setBackgroundColor(Color.YELLOW);
        mButton.setText("window");
        mLayoutParams = new WindowManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0, 0);
        mLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
        mLayoutParams.flags =  WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mLayoutParams.format = PixelFormat.TRANSLUCENT;
        mLayoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        mLayoutParams.x = 100;
        mLayoutParams.y = 300;
        mManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mLayoutParams.x = (int) event.getRawX()- mButton.getMeasuredWidth()/2;
                mLayoutParams.y = (int) event.getRawY()- mButton.getMeasuredHeight()/2-getStatusBarHeight(MainActivity.this);
                switch(event.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        mManager.updateViewLayout(mButton, mLayoutParams);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        mManager.addView(mButton, mLayoutParams);
    }
    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
