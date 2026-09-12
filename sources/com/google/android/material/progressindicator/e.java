package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;

/* loaded from: classes4.dex */
public final class e extends b {

    /* renamed from: h, reason: collision with root package name */
    public int f29499h;

    /* renamed from: i, reason: collision with root package name */
    public int f29500i;

    /* renamed from: j, reason: collision with root package name */
    public int f29501j;

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public e(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, CircularProgressIndicator.DEF_STYLE_RES);
    }

    public e(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_inset_medium);
        TypedArray i13 = b0.i(context, attributeSet, R$styleable.CircularProgressIndicator, i11, i12, new int[0]);
        this.f29499h = Math.max(xa.c.d(context, i13, R$styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.f29472a * 2);
        this.f29500i = xa.c.d(context, i13, R$styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f29501j = i13.getInt(R$styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        i13.recycle();
        e();
    }
}
