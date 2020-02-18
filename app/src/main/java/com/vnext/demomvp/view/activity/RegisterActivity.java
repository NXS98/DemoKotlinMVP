package com.vnext.demomvp.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vnext.demomvp.R;
import com.vnext.demomvp.model.interfaces.RegisterContract;
import com.vnext.demomvp.presenter.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    @BindView(R.id.edt_registere_username)
    EditText edtRegistereUsername;
    @BindView(R.id.edt_registere_password)
    EditText edtRegisterePassword;
    @BindView(R.id.btn_registere_finish)
    Button btnRegistereFinish;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        registerPresenter = new RegisterPresenter(this);

    }

    public void register() {
        String username = edtRegistereUsername.getText().toString().trim();
        String password = edtRegisterePassword.getText().toString().trim();
        if(username.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Username hoặc Password không được bỏ trống", Toast.LENGTH_SHORT).show();
        }else{
            registerPresenter.handleRegister(username,password);
        }
    }

    @Override
    public void registerSuccess(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerFailure() {
        Toast.makeText(this, "Tên Username đã tồn tại", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_registere_finish)
    public void onViewClicked() {
        register();
    }
}
