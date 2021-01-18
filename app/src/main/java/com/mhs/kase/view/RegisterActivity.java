package com.mhs.kase.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mhs.kase.R;
import com.mhs.kase.utils.KaseApi;

import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements KaseApi {

    private EditText etNamaLengkap;
    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etCPassword;
    private TextView btnMasuk;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initClick();
    }

    private void initView() {
        etNamaLengkap = (EditText) findViewById(R.id.et_nama_lengkap);
        etUsername = (EditText) findViewById(R.id.et_username);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        etCPassword = (EditText) findViewById(R.id.et_c_password);
        btnMasuk = (TextView) findViewById(R.id.btn_masuk);
        tvLogin = (TextView) findViewById(R.id.tv_login);
    }

    private void initClick() {
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi();
            }
        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void validasi() {
        if (!validate(etNamaLengkap) || !validate(etEmail) || !validate(etUsername) || !validate(etPassword)) {
            Toast.makeText(this, "Lengkapi data terlebih dahulu!", Toast.LENGTH_SHORT).show();
        } else if (!validate()) {
            Toast.makeText(this, "Konfirmasi sandi tidak cocok", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
    }


    private boolean validate(EditText et) {
        if (et.getText().toString().length() > 0) return true;
        else return false;
    }

    private boolean validate() {
        if (etPassword.getText().toString().equalsIgnoreCase(etCPassword.getText().toString()))
            return true;
        else return false;
    }

    @Override
    public void executeUrl(String url, Map<String, String> params) {

    }
}
