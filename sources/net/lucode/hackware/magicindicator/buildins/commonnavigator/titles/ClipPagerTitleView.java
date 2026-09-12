package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import j00.b;

/* loaded from: classes7.dex */
public class ClipPagerTitleView extends View implements b {

    /* renamed from: a, reason: collision with root package name */
    private String f70536a;

    /* renamed from: b, reason: collision with root package name */
    private int f70537b;

    /* renamed from: c, reason: collision with root package name */
    private int f70538c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f70539d;

    /* renamed from: e, reason: collision with root package name */
    private float f70540e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f70541f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f70542g;

    public ClipPagerTitleView(Context context) {
        super(context);
        this.f70542g = new Rect();
        a(context);
    }

    private void a(Context context) {
        int a11 = i00.b.a(context, 16.0d);
        Paint paint = new Paint(1);
        this.f70541f = paint;
        paint.setTextSize(a11);
        int a12 = i00.b.a(context, 10.0d);
        setPadding(a12, 0, a12, 0);
    }

    private int b(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : this.f70542g.height() + getPaddingTop() + getPaddingBottom() : Math.min(this.f70542g.height() + getPaddingTop() + getPaddingBottom(), size);
    }

    private void c() {
        Paint paint = this.f70541f;
        String str = this.f70536a;
        paint.getTextBounds(str, 0, str == null ? 0 : str.length(), this.f70542g);
    }

    private int d(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : this.f70542g.width() + getPaddingLeft() + getPaddingRight() : Math.min(this.f70542g.width() + getPaddingLeft() + getPaddingRight(), size);
    }

    public int getClipColor() {
        return this.f70538c;
    }

    @Override // j00.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.f70541f.getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // j00.b
    public int getContentLeft() {
        return (getLeft() + (getWidth() / 2)) - (this.f70542g.width() / 2);
    }

    @Override // j00.b
    public int getContentRight() {
        return getLeft() + (getWidth() / 2) + (this.f70542g.width() / 2);
    }

    @Override // j00.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.f70541f.getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public String getText() {
        return this.f70536a;
    }

    public int getTextColor() {
        return this.f70537b;
    }

    public float getTextSize() {
        return this.f70541f.getTextSize();
    }

    @Override // j00.d
    public void onDeselected(int i11, int i12) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = (getWidth() - this.f70542g.width()) / 2;
        Paint.FontMetrics fontMetrics = this.f70541f.getFontMetrics();
        int height = (int) (((getHeight() - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        this.f70541f.setColor(this.f70537b);
        float f11 = width;
        float f12 = height;
        canvas.drawText(this.f70536a, f11, f12, this.f70541f);
        canvas.save();
        if (this.f70539d) {
            canvas.clipRect(0.0f, 0.0f, getWidth() * this.f70540e, getHeight());
        } else {
            canvas.clipRect(getWidth() * (1.0f - this.f70540e), 0.0f, getWidth(), getHeight());
        }
        this.f70541f.setColor(this.f70538c);
        canvas.drawText(this.f70536a, f11, f12, this.f70541f);
        canvas.restore();
    }

    @Override // j00.d
    public void onEnter(int i11, int i12, float f11, boolean z10) {
        this.f70539d = z10;
        this.f70540e = f11;
        invalidate();
    }

    @Override // j00.d
    public void onLeave(int i11, int i12, float f11, boolean z10) {
        this.f70539d = !z10;
        this.f70540e = 1.0f - f11;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        c();
        setMeasuredDimension(d(i11), b(i12));
    }

    @Override // j00.d
    public void onSelected(int i11, int i12) {
    }

    public void setClipColor(int i11) {
        this.f70538c = i11;
        invalidate();
    }

    public void setText(String str) {
        this.f70536a = str;
        requestLayout();
    }

    public void setTextColor(int i11) {
        this.f70537b = i11;
        invalidate();
    }

    public void setTextSize(float f11) {
        this.f70541f.setTextSize(f11);
        requestLayout();
    }
}
