package net.lucode.hackware.magicindicator.buildins.circlenavigator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import i00.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class CircleNavigator extends View implements h00.a {

    /* renamed from: a, reason: collision with root package name */
    private int f70450a;

    /* renamed from: b, reason: collision with root package name */
    private int f70451b;

    /* renamed from: c, reason: collision with root package name */
    private int f70452c;

    /* renamed from: d, reason: collision with root package name */
    private int f70453d;

    /* renamed from: e, reason: collision with root package name */
    private int f70454e;

    /* renamed from: f, reason: collision with root package name */
    private int f70455f;

    /* renamed from: g, reason: collision with root package name */
    private Interpolator f70456g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f70457h;

    /* renamed from: i, reason: collision with root package name */
    private List f70458i;

    /* renamed from: j, reason: collision with root package name */
    private float f70459j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f70460k;

    /* renamed from: l, reason: collision with root package name */
    private float f70461l;

    /* renamed from: m, reason: collision with root package name */
    private float f70462m;

    /* renamed from: n, reason: collision with root package name */
    private int f70463n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f70464o;

    /* loaded from: classes7.dex */
    public interface a {
    }

    public CircleNavigator(Context context) {
        super(context);
        this.f70456g = new LinearInterpolator();
        this.f70457h = new Paint(1);
        this.f70458i = new ArrayList();
        this.f70464o = true;
        c(context);
    }

    private void a(Canvas canvas) {
        this.f70457h.setStyle(Paint.Style.STROKE);
        this.f70457h.setStrokeWidth(this.f70452c);
        int size = this.f70458i.size();
        for (int i11 = 0; i11 < size; i11++) {
            PointF pointF = (PointF) this.f70458i.get(i11);
            canvas.drawCircle(pointF.x, pointF.y, this.f70450a, this.f70457h);
        }
    }

    private void b(Canvas canvas) {
        this.f70457h.setStyle(Paint.Style.FILL);
        if (this.f70458i.size() > 0) {
            canvas.drawCircle(this.f70459j, (int) ((getHeight() / 2.0f) + 0.5f), this.f70450a, this.f70457h);
        }
    }

    private void c(Context context) {
        this.f70463n = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f70450a = b.a(context, 3.0d);
        this.f70453d = b.a(context, 8.0d);
        this.f70452c = b.a(context, 1.0d);
    }

    private int d(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.f70450a * 2) + (this.f70452c * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private int e(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f70455f;
            return (this.f70452c * 2) + (this.f70450a * i12 * 2) + ((i12 - 1) * this.f70453d) + getPaddingLeft() + getPaddingRight();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private void f() {
        this.f70458i.clear();
        if (this.f70455f > 0) {
            int height = (int) ((getHeight() / 2.0f) + 0.5f);
            int i11 = this.f70450a;
            int i12 = (i11 * 2) + this.f70453d;
            int paddingLeft = i11 + ((int) ((this.f70452c / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i13 = 0; i13 < this.f70455f; i13++) {
                this.f70458i.add(new PointF(paddingLeft, height));
                paddingLeft += i12;
            }
            this.f70459j = ((PointF) this.f70458i.get(this.f70454e)).x;
        }
    }

    public a getCircleClickListener() {
        return null;
    }

    public int getCircleColor() {
        return this.f70451b;
    }

    public int getCircleCount() {
        return this.f70455f;
    }

    public int getCircleSpacing() {
        return this.f70453d;
    }

    public int getRadius() {
        return this.f70450a;
    }

    public Interpolator getStartInterpolator() {
        return this.f70456g;
    }

    public int getStrokeWidth() {
        return this.f70452c;
    }

    public boolean isFollowTouch() {
        return this.f70464o;
    }

    public boolean isTouchable() {
        return this.f70460k;
    }

    @Override // h00.a
    public void notifyDataSetChanged() {
        f();
        invalidate();
    }

    @Override // h00.a
    public void onAttachToMagicIndicator() {
    }

    @Override // h00.a
    public void onDetachFromMagicIndicator() {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f70457h.setColor(this.f70451b);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        f();
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        setMeasuredDimension(e(i11), d(i12));
    }

    @Override // h00.a
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // h00.a
    public void onPageScrolled(int i11, float f11, int i12) {
        if (!this.f70464o || this.f70458i.isEmpty()) {
            return;
        }
        int min = Math.min(this.f70458i.size() - 1, i11);
        int min2 = Math.min(this.f70458i.size() - 1, i11 + 1);
        PointF pointF = (PointF) this.f70458i.get(min);
        PointF pointF2 = (PointF) this.f70458i.get(min2);
        float f12 = pointF.x;
        this.f70459j = f12 + ((pointF2.x - f12) * this.f70456g.getInterpolation(f11));
        invalidate();
    }

    @Override // h00.a
    public void onPageSelected(int i11) {
        this.f70454e = i11;
        if (this.f70464o) {
            return;
        }
        this.f70459j = ((PointF) this.f70458i.get(i11)).x;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (motionEvent.getAction() != 0 || !this.f70460k) {
            return super.onTouchEvent(motionEvent);
        }
        this.f70461l = x10;
        this.f70462m = y10;
        return true;
    }

    public void setCircleClickListener(a aVar) {
        if (this.f70460k) {
            return;
        }
        this.f70460k = true;
    }

    public void setCircleColor(int i11) {
        this.f70451b = i11;
        invalidate();
    }

    public void setCircleCount(int i11) {
        this.f70455f = i11;
    }

    public void setCircleSpacing(int i11) {
        this.f70453d = i11;
        f();
        invalidate();
    }

    public void setFollowTouch(boolean z10) {
        this.f70464o = z10;
    }

    public void setRadius(int i11) {
        this.f70450a = i11;
        f();
        invalidate();
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f70456g = interpolator;
        if (interpolator == null) {
            this.f70456g = new LinearInterpolator();
        }
    }

    public void setStrokeWidth(int i11) {
        this.f70452c = i11;
        invalidate();
    }

    public void setTouchable(boolean z10) {
        this.f70460k = z10;
    }
}
