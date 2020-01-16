package com.bawei6.news.user;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.bawei6.basemodel.base.BaseActivity;
import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.basemodel.ui.TitleBar;
import com.bawei6.basemodel.utils.MsgUtils;
import com.bawei6.basemodel.utils.NumberPool;
import com.bawei6.basemodel.utils.SPUtils;
import com.bawei6.news.R;
import com.bawei6.news.bean.LoginBean;
import com.bawei6.news.viewmodel.LoginViewModel;

public class LoginActivity extends BaseActivity<LoginViewModel, ViewDataBinding> {

    LiveData<BaseRespEntity<LoginBean>> respEntityLiveData;
    private ImageView select_title_img;
    private EditText login_ex_username;
    private EditText login_mm_password;
    private CheckBox login_mima_remember;
    private Button select_login;
    private Button login_register;
    private TextView login_find;
    private TitleBar login_title_bar;

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        select_title_img = findViewById(R.id.select_title_img);
        login_ex_username = findViewById(R.id.login_ex_username);
        login_mm_password = findViewById(R.id.login_mm_password);
        select_login = findViewById(R.id.select_login);
        login_register = findViewById(R.id.login_register);
        login_title_bar = findViewById(R.id.login_title_bar);
        login_mima_remember=findViewById(R.id.login_mima_remember);
       //TITLEBAR的图片响应事件
        title_onclick();
        //跳转注册页面
       register_onclick();
        //登录
       login_onclick();
    }

    private void login_onclick() {
        //是否记住了密码
        boolean getflag = SPUtils.getInstance().getflag(this, NumberPool.LoginIsFlag);
        if(getflag){
            String name_sp = SPUtils.getInstance().getString(this, NumberPool.LoginUserName);
            String pwd_sp = SPUtils.getInstance().getString(this, NumberPool.LoginPossWord);
            login_ex_username.setText(name_sp);
            login_mm_password.setText(pwd_sp);
        }
        select_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = login_ex_username.getText().toString();
                String pwd = login_mm_password.getText().toString();
                boolean checked = login_mima_remember.isChecked();
                //存储
                SPUtils.getInstance().setBoolean(LoginActivity.this,NumberPool.LoginIsFlag,checked);
                SPUtils.getInstance().setString(LoginActivity.this,NumberPool.LoginUserName,name);
                SPUtils.getInstance().setString(LoginActivity.this,NumberPool.LoginPossWord,pwd);

                LiveData<BaseRespEntity<LoginBean>> login = mViewModel.login(name, pwd);
                login.observe(LoginActivity.this, new Observer<BaseRespEntity<LoginBean>>() {
                    @Override
                    public void onChanged(BaseRespEntity<LoginBean> loginBeanBaseRespEntity) {
                        if (name.equals("")&&pwd.equals("")){
                            MsgUtils.showmsg(LoginActivity.this,"请输入正确得到信息");
                        }else {
                            Intent intent = new Intent(LoginActivity.this, StratActivity.class);
                            startActivity(intent);
                        }
//                        int code = loginBeanBaseRespEntity.getCode();
//                        if (code==NumberPool.ISSUCCEED){
//                            MsgUtils.showmsg(LoginActivity.this,"登录成功");
//                        }else {
//                            MsgUtils.showmsg(LoginActivity.this,loginBeanBaseRespEntity.getMsg());
//                        }
                    }
                });
            }
        });
    }

    private void register_onclick() {
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void title_onclick() {
        ImageView imageView_left = login_title_bar.getImageView_left();
        imageView_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}