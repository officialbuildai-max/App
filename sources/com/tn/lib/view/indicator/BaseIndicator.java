package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes4.dex */
public class BaseIndicator extends View {

    /* renamed from: a, reason: collision with root package name */
    protected a f41386a;

    /* renamed from: b, reason: collision with root package name */
    protected Paint f41387b;

    /* renamed from: c, reason: collision with root package name */
    protected float f41388c;

    public BaseIndicator(Context context) {
        this(context, null);
    }

    public BaseIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseIndicator(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41386a = new a();
        Paint paint = new Paint();
        this.f41387b = paint;
        paint.setAntiAlias(true);
        this.f41387b.setColor(0);
        this.f41387b.setColor(this.f41386a.g());
    }

    public a getIndicatorConfig() {
        return this.f41386a;
    }

    @NonNull
    public View getIndicatorView() {
        if (this.f41386a.l()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int b11 = this.f41386a.b();
            if (b11 == 0) {
                layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
            } else if (b11 == 1) {
                layoutParams.gravity = 81;
            } else if (b11 == 2) {
                layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_END;
            }
            layoutParams.leftMargin = this.f41386a.f().f41413a;
            layoutParams.rightMargin = this.f41386a.f().f41415c;
            layoutParams.topMargin = this.f41386a.f().f41414b;
            layoutParams.bottomMargin = this.f41386a.f().f41416d;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    public void onPageChanged(int i11, int i12) {
        this.f41386a.n(i11);
        this.f41386a.m(i12);
        requestLayout();
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        this.f41388c = f11;
        invalidate();
    }

    public void onPageSelected(int i11) {
        this.f41386a.m(i11);
        invalidate();
    }
}
