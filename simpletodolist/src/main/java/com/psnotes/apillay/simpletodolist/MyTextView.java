package com.psnotes.apillay.simpletodolist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by apillay on 2/29/2016.
 */
public class MyTextView extends TextView{
    private Paint linePaint;

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.GREEN);
        linePaint.setStrokeWidth(10.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0, 0, 0, getMeasuredHeight(), linePaint);
        canvas.drawLine(0, getMeasuredHeight(),getMeasuredWidth(), getMeasuredHeight(), linePaint);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
    }
}
