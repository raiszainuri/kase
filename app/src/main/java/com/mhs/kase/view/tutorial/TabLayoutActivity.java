package com.mhs.kase.view.tutorial;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;
import com.mhs.kase.R;
import com.mhs.kase.utils.KaseApi;
import com.mhs.kase.utils.Secure;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class TabLayoutActivity extends AppCompatActivity implements KaseApi {

    private TabLayout tblayout;
    private Button tb_tekan;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        initView();
        initClick();

        Secure ss = new Secure(this);
        queue = Volley.newRequestQueue(this, ss.hurlStack);

        tblayout.setTabTextColors(getResources().getColor(R.color.t_dark), getResources().getColor(R.color.white));
        tblayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
    }

    private void initView() {
        tblayout = (TabLayout) findViewById(R.id.tblayout);
        tb_tekan = findViewById(R.id.tb_tekan);
    }

    private void initClick() {
        tb_tekan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //executeUrl("auth/login", paramsList);
                retrieveData();
            }
        });
    }

    @Override
    public void executeUrl(String url, final Map<String, String> params) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, (URL_MAIN + url),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", "raiszainuri09@gmail.com");
                params.put("password", "namasaya");
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                headers.put("Content-type", "application/json");
                return headers;
            }
        };
        queue.add(stringRequest);
    }

    void retrieveData() {
        String url = URL_MAIN + "auth/register";
        Log.d("retrieve", "retrieveData: " + url);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(TabLayoutActivity.this, response + "", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", "raiszainur09@gmail.com");
                params.put("password", "katasandi");
                return params;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}