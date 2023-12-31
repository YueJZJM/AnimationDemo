package com.yjz.animationdemo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

/**
 * Author:wuxianglong;
 * Time:2016/12/21.
 */
public class ElasticBallView extends View {

    //画笔
    private Paint paint;
    //颜色
    private int color = Color.parseColor("#0000FF");
    //半径
    private int radius = 10;

    private float density;
    private RectF rectF;

    //起点、终点、当前点
    private int startX, startY, endY, currentY;

    public ElasticBallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        density = getResources().getDisplayMetrics().density;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //获取视图的中心点
        startX = getWidth() / 2;
        endY = getHeight() / 2;
        startY = endY * 5 / 6;
        paint.setColor(color);
        if (currentY == 0) {
            playAnimator();
        } else {
            drawCircle(canvas);
            drawShader(canvas);
        }
    }

    /**
     * 执行动画
     */
    private void playAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(startY, endY);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentY = (Integer) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(500);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setInterpolator(new AccelerateInterpolator(1.2f));
        valueAnimator.start();
    }

    /**
     * 绘制圆形
     *
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {
        //当接触到底部时候，我们为了要描绘一种压扁的效果，实际上就是绘制椭圆
        if (endY - currentY > 10) {
            canvas.drawCircle(startX, currentY, radius * density, paint);
        } else {
            rectF = new RectF(startX - radius * density - 2, currentY - radius * density + 5,
                    startX + radius * density + 2, currentY + radius * density);
            canvas.drawOval(rectF, paint);
        }
    }

    /**
     * 绘制阴影部分
     *
     * @param canvas
     */
    private void drawShader(Canvas canvas) {
        //计算差值高度
        int dx = endY - startY;
        //计算当前点的高度差值
        int dx1 = currentY - startY;
        float radio = (float) (dx1 * 1.0 / dx);
        if (radio <= 0.3) {
            return;
        }
        int ovalRadius = (int) (radius * radio * density);
        //绘制倒影的颜色
        paint.setColor(Color.parseColor("#3F3B2D"));
        //绘制椭圆
        rectF = new RectF(startX - ovalRadius, endY + 10, startX + ovalRadius, endY + 15);
        canvas.drawOval(rectF, paint);
    }

    /**
     * 设置颜色
     *
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
    }
}
