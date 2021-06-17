package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;

public class MyView extends View {
    private static final String TAG = "MyView";
    private String mText;
    private TextPaint mTextPaint;

    public MyView(Context context) {
        super(context);

        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();
    }

    private void init() {
        mTextPaint = new TextPaint();
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setARGB(200, 254, 0, 0);
        mTextPaint.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        long t0 = System.currentTimeMillis();

        // Let's just simulate a significant delay here so it becomes obvious
        // what kind of unwanted behavior I am facing.

        if (mText != null) {
            int x = (canvas.getWidth() / 2);
            int y = (int) ((canvas.getHeight() / 2) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2)) ;

            canvas.drawText(mText, x, y, mTextPaint);
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, String.format("MyView::onDraw took %d ms", System.currentTimeMillis() - t0));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int width = MeasureSpec.getSize(widthMeasureSpec);
        final int height = 100;

        widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setText(String text) {
        mText = text;
    }
}
