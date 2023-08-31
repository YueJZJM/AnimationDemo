package com.yjz.animationdemo.activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yjz.animationdemo.R;
import com.yjz.animationdemo.view.SearchAnimView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchAnimActivity extends AppCompatActivity {

    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.searchView)
    SearchAnimView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_anim);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_search)
    public void onClick() {
        searchView.start();
    }
}
