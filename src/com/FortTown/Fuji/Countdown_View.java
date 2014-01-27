package com.FortTown.Fuji;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: Forrest
 * Date: 1/26/14
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Countdown_View extends View {
    private int circleColor, labelColor;
    private String circleText;
    private Paint circlePaint;

    public Countdown_View(Context context, AttributeSet attrs) {
        super(context, attrs);

        //paint object for drawing in onDraw
        circlePaint = new Paint();

        //get the attributes specified in attr.xml using the name we included
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.Countdown_View, 0, 0);

        try {
            //get the text and colors specified using the names in attr.xml
            circleText = typedArray.getString(R.styleable.Countdown_View_circleColor);
            circleColor = typedArray.getInteger(R.styleable.Countdown_View_circleColor, 0);
            labelColor = typedArray.getInteger(R.styleable.Countdown_View_labelColor, 0);
        } finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //get half of width and height
        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;
        
        //get the radius
        int radius = 0;
        if (viewWidthHalf > viewHeightHalf)
            radius = viewHeightHalf - 10;
        else
            radius = viewWidthHalf - 10;
        
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);

        //set the paint color using the circle color specified
        circlePaint.setColor(circleColor);

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);

        circlePaint.setColor(labelColor);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);
        canvas.drawText(circleText, viewWidthHalf, viewHeightHalf, circlePaint);

    }

}
