package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class ScreenAdapterLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f41070a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f41071b;

    /* renamed from: c, reason: collision with root package name */
    private float f41072c;

    /* renamed from: d, reason: collision with root package name */
    private float f41073d;

    public ScreenAdapterLayout(Context context) {
        super(context);
        this.f41070a = false;
        this.f41071b = false;
    }

    public ScreenAdapterLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41070a = false;
        this.f41071b = false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        if (this.f41070a && !this.f41071b) {
            this.f41071b = true;
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i13).getLayoutParams();
                int i14 = layoutParams.width;
                if (i14 > 0) {
                    layoutParams.width = (int) (i14 * this.f41072c);
                    layoutParams.height = (int) (layoutParams.height * this.f41073d);
                }
                float f11 = layoutParams.topMargin;
                float f12 = this.f41073d;
                layoutParams.topMargin = (int) (f11 * f12);
                layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * f12);
            }
            this.f41070a = false;
        }
        super.onMeasure(i11, i12);
    }

    public void setScale(float f11, float f12) {
        this.f41070a = true;
        this.f41072c = f11;
        this.f41073d = f12;
    }
}
