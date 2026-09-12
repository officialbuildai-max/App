package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.blankj.utilcode.util.a0;

/* loaded from: classes4.dex */
public class BannerIndicator extends BaseIndicator {

    /* renamed from: d, reason: collision with root package name */
    private float f41385d;

    public BannerIndicator(Context context) {
        this(context, null);
    }

    public BannerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41385d = a0.a(16.0f);
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
            if (z10) {
                float h11 = this.f41386a.h();
                float f12 = this.f41385d;
                canvas.drawRoundRect(f11, 0.0f, f11 + k11, h11, f12, f12, this.f41387b);
            } else {
                float h12 = this.f41386a.h() / 2;
                canvas.drawCircle(f11 + h12, h12, h12, this.f41387b);
            }
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
        int i13 = d11 - 1;
        setMeasuredDimension((this.f41386a.e() * i13) + this.f41386a.k() + (this.f41386a.h() * i13), this.f41386a.h());
    }
}
