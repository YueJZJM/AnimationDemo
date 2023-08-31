package com.yjz.animationdemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yjz.animationdemo.R;
import com.yjz.animationdemo.view.ElasticBallView;
import com.yjz.animationdemo.view.HeartLayoutView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HeartAnimActivity extends AppCompatActivity {


    @BindView(R.id.favorHeart)
    HeartLayoutView favorHeart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_anim);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.favorHeart)
    public void onClick() {
        favorHeart.addFavorHeart();
    }

    public static class ElasticBallActivity extends AppCompatActivity {

        @BindView(R.id.changeColor)
        Button changeColor;
        @BindView(R.id.ballView)
        ElasticBallView ballView;

        private int[] colors = new int[]{
                Color.parseColor("#FFFF0000"), Color.parseColor("#FF7CFC00"),
                Color.parseColor("#FF7A378B"), Color.parseColor("#FF436EEE"),
                Color.parseColor("#FF2ACFA2"), Color.parseColor("#FFFFFF00"),
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_elastic_ball);
            ButterKnife.bind(this);
        }

        @OnClick(R.id.changeColor)
        public void onClick() {
            int index = (int) (Math.random() * 6);
            ballView.setColor(colors[index]);
        }
    }
}
