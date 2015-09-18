package com.example.weartest;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SetListItemView extends LinearLayout implements WearableListView.OnCenterProximityListener {

    private TextView mTextViewNumber;

    private final int mCenterPositionTextColor;
    private final int mNonCenterPositionTextColor;

    private final int mCenterPositionTextSize;
    private final int mNonCenterPositionTextSize;

    public SetListItemView(Context context) {
        this(context, null);
    }

    public SetListItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetListItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mCenterPositionTextColor = getResources().getColor(android.R.color.black);
        mNonCenterPositionTextColor = getResources().getColor(android.R.color.darker_gray);

        mCenterPositionTextSize = 24;
        mNonCenterPositionTextSize = 20;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mTextViewNumber = (TextView) findViewById(R.id.number);
    }

    @Override
    public void onCenterPosition(boolean animate) {
        mTextViewNumber.setTextSize(TypedValue.COMPLEX_UNIT_DIP, mCenterPositionTextSize);
        mTextViewNumber.setTextColor(mCenterPositionTextColor);
    }

    @Override
    public void onNonCenterPosition(boolean animate) {
        mTextViewNumber.setTextSize(TypedValue.COMPLEX_UNIT_DIP, mNonCenterPositionTextSize);
        mTextViewNumber.setTextColor(mNonCenterPositionTextColor);
    }
}