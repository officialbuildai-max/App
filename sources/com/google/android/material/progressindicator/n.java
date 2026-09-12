package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;

/* loaded from: classes4.dex */
public final class n extends b {

    /* renamed from: h, reason: collision with root package name */
    public int f29561h;

    /* renamed from: i, reason: collision with root package name */
    public int f29562i;

    /* renamed from: j, reason: collision with root package name */
    boolean f29563j;

    /* renamed from: k, reason: collision with root package name */
    public int f29564k;

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    public n(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, LinearProgressIndicator.DEF_STYLE_RES);
    }

    public n(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        TypedArray i13 = b0.i(context, attributeSet, R$styleable.LinearProgressIndicator, R$attr.linearProgressIndicatorStyle, LinearProgressIndicator.DEF_STYLE_RES, new int[0]);
        this.f29561h = i13.getInt(R$styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f29562i = i13.getInt(R$styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        this.f29564k = Math.min(i13.getDimensionPixelSize(R$styleable.LinearProgressIndicator_trackStopIndicatorSize, 0), this.f29472a);
        i13.recycle();
        e();
        this.f29563j = this.f29562i == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.b
    public void e() {
        super.e();
        if (this.f29564k < 0) {
            throw new IllegalArgumentException("Stop indicator size must be >= 0.");
        }
        if (this.f29561h == 0) {
            if (this.f29473b > 0 && this.f29478g == 0) {
                throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            }
            if (this.f29474c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }
}
