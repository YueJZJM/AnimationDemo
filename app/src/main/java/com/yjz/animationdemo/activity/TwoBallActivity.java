package com.yjz.animationdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yjz.animationdemo.R;
import com.yjz.animationdemo.view.TwoBallView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TwoBallActivity extends AppCompatActivity {

    @BindView(R.id.start)
    Button start;
    @BindView(R.id.end)
    Button end;
    @BindView(R.id.ballView)
    TwoBallView ballView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_ball);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.start, R.id.end})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                ballView.startAnimator();
                break;
            case R.id.end:
                ballView.stopAnimator();
                break;
        }
    }
}
