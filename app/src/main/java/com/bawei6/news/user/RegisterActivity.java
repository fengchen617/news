package com.bawei6.news.user;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.bawei6.basemodel.base.BaseActivity;
import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.basemodel.ui.TitleBar;
import com.bawei6.basemodel.utils.MsgUtils;
import com.bawei6.basemodel.utils.NumberPool;
import com.bawei6.basemodel.utils.PhotoUtils;
import com.bawei6.news.R;
import com.bawei6.news.bean.RegisterBean;
import com.bawei6.news.bean.SelectBean;
import com.bawei6.news.viewmodel.RegisterViewModel;

public class RegisterActivity extends BaseActivity<RegisterViewModel, ViewDataBinding> {
    LiveData<BaseRespEntity<RegisterBean>> respEntityLiveData;
    private EditText register_ex_id;
    private EditText register_ex_name;
    private EditText register_ex_poss;
    private Button register_button_ok;
    private TitleBar register_title_bar;
    private ImageView register_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

        @Override
        protected void initEvent() {

        }

        @Override
        protected void initData() {
          //TITLEBAR的图片响应事件
            letf_img_onclick();
            //点击注册时
           register_onclick();
        }

    private void register_onclick() {
        register_button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = register_ex_id.getText().toString();
                String name = register_ex_name.getText().toString();
                String poss = register_ex_poss.getText().toString();
                int myid = Integer.parseInt(id);
                LiveData<BaseRespEntity<RegisterBean>> register = mViewModel.register(new RegisterBean(myid, name, poss, "年龄", "生日"));
                register.observe(RegisterActivity.this, new Observer<BaseRespEntity<RegisterBean>>() {
                    @Override
                    public void onChanged(BaseRespEntity<RegisterBean> registerBeanBaseRespEntity) {
                        int code = registerBeanBaseRespEntity.getCode();
                        if (code== NumberPool.ISSUCCEED){
                            MsgUtils.showmsg(RegisterActivity.this,"注册成功");
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }else {
                            MsgUtils.showmsg(RegisterActivity.this,registerBeanBaseRespEntity.getMsg());
                        }
                    }
                });
            }
        });
    }

    private void letf_img_onclick() {
        ImageView imageView_left = register_title_bar.getImageView_left();
        imageView_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
        protected void initView(Bundle savedInstanceState) {
            register_ex_id = (EditText) findViewById(R.id.register_ex_id);
            register_ex_name = (EditText) findViewById(R.id.register_ex_name);
            register_ex_poss = (EditText) findViewById(R.id.register_ex_poss);
            register_button_ok = (Button) findViewById(R.id.register_button_ok);
            register_title_bar = findViewById(R.id.register_title_bar);
            register_img = findViewById(R.id.register_img);
            //选择本地头像
        register_img_onclick();
        }

    private void register_img_onclick() {
        register_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoUtils.img(RegisterActivity.this);
            }
        });

    }

    @Override
        protected int getLayoutId() {
            return R.layout.activity_register;
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NumberPool.MSGFRIST) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                register_img.setImageURI(uri);
            }
        }
    }
}
