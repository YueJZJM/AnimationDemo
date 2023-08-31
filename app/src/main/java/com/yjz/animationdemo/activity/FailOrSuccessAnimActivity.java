package com.yjz.animationdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yjz.animationdemo.R;
import com.yjz.animationdemo.view.FailOrSuccessAnimView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FailOrSuccessAnimActivity extends AppCompatActivity {

    @BindView(R.id.animView)
    FailOrSuccessAnimView animView;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn2)
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail_or_success_anim);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn, R.id.btn2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                //失败
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            animView.setProgress(0);
                            while (animView.getProgress() < 100) {
                                Thread.sleep(10);
                                animView.setProgress(animView.getProgress() + 1);
                            }
                            animView.finishFail();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                break;
            case R.id.btn2:
                //成功
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            animView.setProgress(0);
                            while (animView.getProgress() < 100) {
                                Thread.sleep(10);
                                animView.setProgress(animView.getProgress() + 1);
                            }
                            animView.finishSuccess();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                break;
        }
    }
}
