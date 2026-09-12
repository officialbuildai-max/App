package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

/* loaded from: classes4.dex */
public class RectangleIndicator extends BaseIndicator {

    /* renamed from: d, reason: collision with root package name */
    RectF f41394d;

    public RectangleIndicator(Context context) {
        this(context, null);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41394d = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d11 = this.f41386a.d();
        if (d11 <= 1) {
            return;
        }
        int i11 = 0;
        float f11 = 0.0f;
        while (i11 < d11) {
            this.f41387b.setColor(this.f41386a.a() == i11 ? this.f41386a.j() : this.f41386a.g());
            this.f41394d.set(f11, 0.0f, (this.f41386a.a() == i11 ? this.f41386a.k() : this.f41386a.h()) + f11, this.f41386a.c());
            f11 += r4 + this.f41386a.e();
            canvas.drawRoundRect(this.f41394d, this.f41386a.i(), this.f41386a.i(), this.f41387b);
            i11++;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int d11 = this.f41386a.d();
        if (d11 <= 1) {
            return;
        }
        int i13 = d11 - 1;
        setMeasuredDimension((this.f41386a.e() * i13) + (this.f41386a.h() * i13) + this.f41386a.k(), this.f41386a.c());
    }
}
