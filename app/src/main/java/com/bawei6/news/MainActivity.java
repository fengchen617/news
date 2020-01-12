package com.bawei6.news;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.bawei6.basemodel.base.BaseActivity;
import com.bawei6.basemodel.base.InitActivity;
import com.bawei6.basemodel.utils.NumberPool;
import com.bawei6.news.user.SelectActivity;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：壳工程：欢迎页面.
 */
public class MainActivity extends InitActivity {

    private TextView welcome_text;


    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==NumberPool.MSGFRIST){
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.guo,R.anim.guo);
                finish();
            }
        }
    };
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        welcome_text = (TextView) findViewById(R.id.welcome_text);
        /**
         * 跳转   动画
         */
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.welcome_animation);
        welcome_text.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                handler.sendEmptyMessageDelayed(NumberPool.MSGFRIST,1000);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
