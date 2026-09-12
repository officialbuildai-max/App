package com.google.android.material.progressindicator;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public int f29472a;

    /* renamed from: b, reason: collision with root package name */
    public int f29473b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f29474c = new int[0];

    /* renamed from: d, reason: collision with root package name */
    public int f29475d;

    /* renamed from: e, reason: collision with root package name */
    public int f29476e;

    /* renamed from: f, reason: collision with root package name */
    public int f29477f;

    /* renamed from: g, reason: collision with root package name */
    public int f29478g;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, AttributeSet attributeSet, int i11, int i12) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        TypedArray i13 = b0.i(context, attributeSet, R$styleable.BaseProgressIndicator, i11, i12, new int[0]);
        this.f29472a = xa.c.d(context, i13, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.f29473b = Math.min(xa.c.d(context, i13, R$styleable.BaseProgressIndicator_trackCornerRadius, 0), this.f29472a / 2);
        this.f29476e = i13.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f29477f = i13.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        this.f29478g = i13.getDimensionPixelSize(R$styleable.BaseProgressIndicator_indicatorTrackGapSize, 0);
        c(context, i13);
        d(context, i13);
        i13.recycle();
    }

    private void c(Context context, TypedArray typedArray) {
        if (!typedArray.hasValue(R$styleable.BaseProgressIndicator_indicatorColor)) {
            this.f29474c = new int[]{com.google.android.material.color.b.b(context, R$attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(R$styleable.BaseProgressIndicator_indicatorColor).type != 1) {
            this.f29474c = new int[]{typedArray.getColor(R$styleable.BaseProgressIndicator_indicatorColor, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(R$styleable.BaseProgressIndicator_indicatorColor, -1));
        this.f29474c = intArray;
        if (intArray.length == 0) {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    private void d(Context context, TypedArray typedArray) {
        if (typedArray.hasValue(R$styleable.BaseProgressIndicator_trackColor)) {
            this.f29475d = typedArray.getColor(R$styleable.BaseProgressIndicator_trackColor, -1);
            return;
        }
        this.f29475d = this.f29474c[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
        float f11 = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.f29475d = com.google.android.material.color.b.a(this.f29475d, (int) (f11 * 255.0f));
    }

    public boolean a() {
        return this.f29477f != 0;
    }

    public boolean b() {
        return this.f29476e != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f29478g < 0) {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
    }
}
