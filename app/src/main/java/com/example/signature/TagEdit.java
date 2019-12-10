package com.example.signature;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;


@SuppressLint("AppCompatCustomView")
public class TagEdit extends ImageView implements View.OnTouchListener{



    private Paint paint = new Paint();
    private Path path = new Path();
    private Integer tagColor = Color.BLUE;
    private Integer LineWidth = 10;
    private Integer BorderLineWidth = 1;
    private Bitmap signature;

    public TagEdit(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    public TagEdit(Context context) {
        super(context);
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Integer getTagColor() {
        return tagColor;
    }

    public void setTagColor(Integer tagColor) {
        this.tagColor = tagColor;
    }

    public Integer getLineWidth() {
        return LineWidth;
    }

    public void setLineWidth(Integer lineWidth) {
        LineWidth = lineWidth;
    }

    public Integer getBorderLineWidth() {
        return BorderLineWidth;
    }

    public void setBorderLineWidth(Integer borderLineWidth) {
        BorderLineWidth = borderLineWidth;
    }

    public Bitmap getSignature() {
        return signature;
    }

    public void setSignature(Bitmap signature) {
        this.signature = signature;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }


    ////----------LES METHODES
    public void test() {
        paint.setColor(tagColor);
        paint.setStrokeWidth(LineWidth);
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(0,0);
        path.lineTo(100,100);
        invalidate(); // Force le dessin : appel de onDraw()
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint.setColor(tagColor);
        paint.setStrokeWidth(LineWidth);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent ev) {
        float x = ev.getX();
        float y = ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
        }
        invalidate();
        return false;
    }
}
