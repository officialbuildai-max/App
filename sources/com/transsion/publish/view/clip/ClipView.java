package com.transsion.publish.view.clip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b;
import com.transsion.publish.R$color;

/* loaded from: classes6.dex */
public class ClipView extends View {
    public static final int BORDERDISTANCE = 0;
    public static final int CIRCLE_ZOOM = 3;
    public static final int CIRCULAR = 0;
    public static final int RECTANGULAR = 1;
    public static int TYPE_START = 0;
    public static int mHorizontalPadding = 16;

    /* renamed from: a, reason: collision with root package name */
    private Paint f50782a;

    /* renamed from: b, reason: collision with root package name */
    private Context f50783b;

    /* renamed from: c, reason: collision with root package name */
    private int f50784c;

    /* renamed from: d, reason: collision with root package name */
    private int f50785d;

    /* renamed from: e, reason: collision with root package name */
    private int f50786e;

    /* renamed from: f, reason: collision with root package name */
    private int f50787f;

    /* renamed from: g, reason: collision with root package name */
    private int f50788g;

    /* renamed from: h, reason: collision with root package name */
    private int f50789h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f50790i;
    public int innerCircle;

    /* renamed from: j, reason: collision with root package name */
    private boolean f50791j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f50792k;

    public ClipView(Context context) {
        this(context, null);
        this.f50783b = context;
    }

    public ClipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f50783b = context;
    }

    public ClipView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.innerCircle = getWidth() / 3;
        this.f50790i = true;
        this.f50791j = true;
        this.f50792k = true;
        this.f50782a = new Paint();
        this.f50783b = context;
    }

    public static int dip2px(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int cropHeight() {
        return this.f50785d;
    }

    public int cropWidth() {
        return this.f50784c;
    }

    public int getInnerCircle() {
        return this.innerCircle;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i11;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i12 = this.f50784c;
        if (i12 <= 0 || (i11 = this.f50785d) <= 0 || width <= 0 || height <= 0) {
            if (TYPE_START == 0) {
                this.innerCircle = width / 3;
                this.f50782a.setColor(0);
                this.f50782a.setDither(true);
                this.f50782a.setAntiAlias(true);
                this.f50782a.setStyle(Paint.Style.STROKE);
                float f11 = width / 2;
                float f12 = height / 2;
                canvas.drawCircle(f11, f12, r6 - mHorizontalPadding, this.f50782a);
                this.f50782a.setColor(b.getColor(getContext(), R$color.cl31_50_p));
                this.f50782a.setStrokeWidth(height);
                canvas.drawCircle(f11, f12, (r6 - mHorizontalPadding) + r1, this.f50782a);
                return;
            }
            this.f50782a.setColor(b.getColor(getContext(), R$color.cl31_50_p));
            float f13 = width;
            float f14 = (height - width) / 2;
            canvas.drawRect(0.0f, 0.0f, f13, f14, this.f50782a);
            float f15 = (height + width) / 2;
            canvas.drawRect(0.0f, f15, f13, height, this.f50782a);
            canvas.drawRect(0.0f, f14, 0.0f, f15, this.f50782a);
            canvas.drawRect(width, f14, f13, f15, this.f50782a);
            this.f50782a.setColor(-1);
            this.f50782a.setStrokeWidth(2.0f);
            float f16 = width;
            canvas.drawLine(0.0f, f14, f16, f14, this.f50782a);
            canvas.drawLine(0.0f, f15, f16, f15, this.f50782a);
            canvas.drawLine(0.0f, f14, 0.0f, f15, this.f50782a);
            canvas.drawLine(f16, f14, f16, f15, this.f50782a);
            return;
        }
        if (this.f50790i) {
            int[] a11 = this.f50792k ? mp.b.a(this.f50783b, i12, i11, width, height) : mp.b.b(this.f50783b, i12, i11, width, height, 1.0f);
            this.f50784c = a11[0];
            this.f50785d = a11[1];
        }
        int i13 = (width - this.f50784c) / 2;
        int i14 = (height - this.f50785d) / 2;
        this.f50782a.setColor(b.getColor(getContext(), R$color.cl31_50_p));
        float f17 = width;
        float f18 = i14;
        canvas.drawRect(0.0f, 0.0f, f17, f18, this.f50782a);
        canvas.drawRect(0.0f, this.f50785d + i14, f17, height, this.f50782a);
        canvas.drawRect(0.0f, f18, i13, this.f50785d + i14, this.f50782a);
        canvas.drawRect(this.f50784c + i13, f18, f17, this.f50785d + i14, this.f50782a);
        this.f50782a.setColor(b.getColor(getContext(), com.tn.lib.widget.R$color.white));
        this.f50782a.setStrokeWidth(1);
        this.f50786e = i13;
        this.f50787f = i14;
        int i15 = this.f50784c + i13;
        this.f50788g = i15;
        if (this.f50792k) {
            this.f50789h = this.f50785d + i14;
        } else {
            this.f50789h = this.f50785d - (i14 != 0 ? i14 : 1);
        }
        if (this.f50791j) {
            canvas.drawLine(i13, i14, i15, i14, this.f50782a);
            float f19 = this.f50786e;
            int i16 = this.f50789h;
            canvas.drawLine(f19, i16, this.f50788g, i16, this.f50782a);
            int i17 = this.f50786e;
            canvas.drawLine(i17, this.f50787f, i17, this.f50789h, this.f50782a);
            int i18 = this.f50788g;
            canvas.drawLine(i18, this.f50787f, i18, this.f50789h, this.f50782a);
        }
    }

    public Rect rect() {
        return new Rect(this.f50786e, this.f50787f, this.f50788g, this.f50789h);
    }

    public void setFullScreen(boolean z10) {
        this.f50792k = z10;
    }

    public void setNeedDivider(boolean z10) {
        this.f50791j = z10;
    }

    public void setSizeNeedChange(boolean z10) {
        this.f50790i = z10;
        invalidate();
    }

    public void setStart(int i11) {
        TYPE_START = i11;
    }

    public void setStartWH(int i11, int i12) {
        this.f50784c = i11;
        this.f50785d = i12;
    }
}
