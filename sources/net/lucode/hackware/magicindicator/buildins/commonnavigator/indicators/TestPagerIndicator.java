package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.tn.lib.view.FlowLayout;
import j00.c;
import java.util.List;
import k00.a;

/* loaded from: classes7.dex */
public class TestPagerIndicator extends View implements c {

    /* renamed from: a, reason: collision with root package name */
    private Paint f70509a;

    /* renamed from: b, reason: collision with root package name */
    private int f70510b;

    /* renamed from: c, reason: collision with root package name */
    private int f70511c;

    /* renamed from: d, reason: collision with root package name */
    private RectF f70512d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f70513e;

    /* renamed from: f, reason: collision with root package name */
    private List f70514f;

    public TestPagerIndicator(Context context) {
        super(context);
        this.f70512d = new RectF();
        this.f70513e = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f70509a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f70510b = FlowLayout.SPACING_AUTO;
        this.f70511c = -16711936;
    }

    public int getInnerRectColor() {
        return this.f70511c;
    }

    public int getOutRectColor() {
        return this.f70510b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f70509a.setColor(this.f70510b);
        canvas.drawRect(this.f70512d, this.f70509a);
        this.f70509a.setColor(this.f70511c);
        canvas.drawRect(this.f70513e, this.f70509a);
    }

    @Override // j00.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // j00.c
    public void onPageScrolled(int i11, float f11, int i12) {
        List list = this.f70514f;
        if (list == null || list.isEmpty()) {
            return;
        }
        a f12 = g00.a.f(this.f70514f, i11);
        a f13 = g00.a.f(this.f70514f, i11 + 1);
        RectF rectF = this.f70512d;
        rectF.left = f12.f66678a + ((f13.f66678a - r1) * f11);
        rectF.top = f12.f66679b + ((f13.f66679b - r1) * f11);
        rectF.right = f12.f66680c + ((f13.f66680c - r1) * f11);
        rectF.bottom = f12.f66681d + ((f13.f66681d - r1) * f11);
        RectF rectF2 = this.f70513e;
        rectF2.left = f12.f66682e + ((f13.f66682e - r1) * f11);
        rectF2.top = f12.f66683f + ((f13.f66683f - r1) * f11);
        rectF2.right = f12.f66684g + ((f13.f66684g - r1) * f11);
        rectF2.bottom = f12.f66685h + ((f13.f66685h - r7) * f11);
        invalidate();
    }

    @Override // j00.c
    public void onPageSelected(int i11) {
    }

    @Override // j00.c
    public void onPositionDataProvide(List<a> list) {
        this.f70514f = list;
    }

    public void setInnerRectColor(int i11) {
        this.f70511c = i11;
    }

    public void setOutRectColor(int i11) {
        this.f70510b = i11;
    }
}
