package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/* loaded from: classes4.dex */
public class CircleIndicator extends BaseIndicator {

    /* renamed from: d, reason: collision with root package name */
    private int f41389d;

    /* renamed from: e, reason: collision with root package name */
    private int f41390e;

    /* renamed from: f, reason: collision with root package name */
    private int f41391f;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41389d = this.f41386a.h() / 2;
        this.f41390e = this.f41386a.k() / 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d11 = this.f41386a.d();
        if (d11 <= 1) {
            return;
        }
        float f11 = 0.0f;
        int i11 = 0;
        while (i11 < d11) {
            boolean z10 = this.f41386a.a() == i11;
            Paint paint = this.f41387b;
            a aVar = this.f41386a;
            paint.setColor(z10 ? aVar.j() : aVar.g());
            a aVar2 = this.f41386a;
            int k11 = z10 ? aVar2.k() : aVar2.h();
            float f12 = z10 ? this.f41390e : this.f41389d;
            canvas.drawCircle(f11 + f12, this.f41391f, f12, this.f41387b);
            f11 += k11 + this.f41386a.e();
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
        this.f41389d = this.f41386a.h() / 2;
        int k11 = this.f41386a.k() / 2;
        this.f41390e = k11;
        this.f41391f = Math.max(k11, this.f41389d);
        int i13 = d11 - 1;
        setMeasuredDimension((this.f41386a.e() * i13) + this.f41386a.k() + (this.f41386a.h() * i13), Math.max(this.f41386a.h(), this.f41386a.k()));
    }
}
