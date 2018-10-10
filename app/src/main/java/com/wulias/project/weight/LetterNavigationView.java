package com.wulias.project.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.wulias.project.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表右侧拼音导航
 * Created by Administrator on 8/11 0011.
 */
public class LetterNavigationView extends View {

    private Context mContext;
    private Paint mPaint;
    private Paint mCirclePaint;

    private List<String> mDatas;

    private int mHeight;
    private int mWidth;
    private int mTextHeight;

    private int selectorPosition;

    private Paint.FontMetrics mFontMetrics;

    private OnTouchListener mOnTouchListener;

    public LetterNavigationView(Context context) {
        this(context, null);
    }

    public LetterNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LetterNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mDatas = new ArrayList<>();
        selectorPosition = 0;

        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(getResources().getColor(R.color.bottom_textcolor));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        if (!mDatas.isEmpty()) {
            mTextHeight = (mHeight / mDatas.size());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mDatas.size(); i++) {
            if (i == selectorPosition) {
                mPaint.setColor(getResources().getColor(R.color.colorPrimary));
                canvas.drawCircle(mWidth / 2, i * mTextHeight + mTextHeight / 2 - dip2px(1), dip2px(10), mCirclePaint);
            } else {
                mPaint.setColor(getResources().getColor(R.color.bottom_textcolor));
            }
            mPaint.setTextSize(dip2px(15));
            mFontMetrics = mPaint.getFontMetrics();
            canvas.drawText(mDatas.get(i), mWidth / 2, i * mTextHeight + mTextHeight / 2 + mFontMetrics.bottom, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                changePosition(y);
                break;
            case MotionEvent.ACTION_MOVE:
                changePosition(y);
                break;
            case MotionEvent.ACTION_UP:
                if (mOnTouchListener != null) {
                    mOnTouchListener.onTouchListener(mDatas.get(selectorPosition), true);
                }
                break;
        }
        return true;
    }

    /**
     * @param y
     */
    public void changePosition(int y) {
        selectorPosition = y / (mHeight / mDatas.size());
        if (selectorPosition >= mDatas.size()) {
            selectorPosition = mDatas.size() - 1;
        } else if (selectorPosition <= 0) {
            selectorPosition = 0;
        }
        if (mOnTouchListener != null) {
            mOnTouchListener.onTouchListener(mDatas.get(selectorPosition), false);
        }
        invalidate();
    }

    public void changeSelectItem(int position){
        if (position >= mDatas.size()) {
            selectorPosition = mDatas.size() - 1;
        } else if (position <= 0) {
            selectorPosition = 0;
        }else {
            selectorPosition = position;
        }
        invalidate();
    }

    public int getSelectorPosition() {
        return selectorPosition;
    }

    /**
     * @param datas
     */
    public void setData(List<String> datas) {
        mDatas = datas;
    }

    public interface OnTouchListener {
        void onTouchListener(String str, boolean hideEnable);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.mOnTouchListener = onTouchListener;
    }

    /**
     * @param dpValue
     * @return
     */
    public int dip2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
