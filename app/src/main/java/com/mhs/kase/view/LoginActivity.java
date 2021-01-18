package com.mhs.kase.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mhs.kase.R;
import com.mhs.kase.utils.KaseApi;
import com.mhs.kase.utils.Secure;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class LoginActivity extends AppCompatActivity implements KaseApi {
    private EditText etUsername;
    private EditText etPassword;
    private TextView btnLogin;
    private TextView tvLupaPassword;
    private TextView tvDaftarDisini;

    private RequestQueue queue;
    private Cache cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initClick();

    }

    private void initView() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (TextView) findViewById(R.id.btn_login);
        tvLupaPassword = (TextView) findViewById(R.id.tv_lupa_password);
        tvDaftarDisini = (TextView) findViewById(R.id.tv_daftar_disini);
    }

    private void initClick() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paramsList.put("username", etUsername.getText().toString().trim());
                paramsList.put("password", etPassword.getText().toString().trim());
                executeUrl("auth/login", paramsList);
                /*startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();*/
            }
        });

        tvDaftarDisini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    @Override
    public void executeUrl(String url, final Map<String, String> params) {
        Log.d("isi", URL_MAIN + url);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, (URL_MAIN + url),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("responseEx", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("responseEx", error.getMessage() + " << error");
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("Content-Type", "application/xml");
                params.put("username", etUsername.getText().toString().trim() + " ");
                params.put("password", etPassword.getText().toString().trim() + " ");
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }

            @Override
            public String getBodyContentType(){
                return "application/x-www-form-urlencoded";
            }
        }/* {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("Content-Type", "application/xml");
                params.put("Authorization", "[My SAS Key]");
                params.put("Cache-Control", "no-cache");
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        }*/;
        queue.add(stringRequest);
    }
}
