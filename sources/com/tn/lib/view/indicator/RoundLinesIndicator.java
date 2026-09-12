package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class RoundLinesIndicator extends BaseIndicator {
    public RoundLinesIndicator(Context context) {
        this(context, null);
    }

    public RoundLinesIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinesIndicator(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41387b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f41386a.d() <= 1) {
            return;
        }
        this.f41387b.setColor(this.f41386a.g());
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), this.f41386a.c()), this.f41386a.i(), this.f41386a.i(), this.f41387b);
        this.f41387b.setColor(this.f41386a.j());
        canvas.drawRoundRect(new RectF(this.f41386a.a() * this.f41386a.k(), 0.0f, r0 + this.f41386a.k(), this.f41386a.c()), this.f41386a.i(), this.f41386a.i(), this.f41387b);
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int d11 = this.f41386a.d();
        if (d11 <= 1) {
            return;
        }
        setMeasuredDimension(this.f41386a.k() * d11, this.f41386a.c());
    }
}
