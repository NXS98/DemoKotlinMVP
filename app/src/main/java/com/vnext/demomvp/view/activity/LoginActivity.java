package com.vnext.demomvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vnext.demomvp.R;
import com.vnext.demomvp.model.interfaces.SignInContract;
import com.vnext.demomvp.presenter.SignInPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements SignInContract.View {

    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    SignInPresenter signInPresenter;
    @BindView(R.id.btn_registere)
    Button btnRegistere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        signInPresenter = new SignInPresenter(this);
    }

    public void SingIn() {
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username hoặc password không được bỏ trống", Toast.LENGTH_SHORT).show();
        } else {
            signInPresenter.handleSignIn(username, password);
        }
    }

    @Override
    public void signInSuccess() {
        Toast.makeText(this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);

    }

    @Override
    public void signInFailure(String error) {
        Toast.makeText(this, "Tên Tài Khoản Hoặc Mật Khẩu Không Chính Xác", Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.btn_login, R.id.btn_registere})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                SingIn();
                break;
            case R.id.btn_registere:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
