package com.google.android.material.carousel;

import ab.n;
import ab.q;
import ab.r;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.carousel.MaskableFrameLayout;
import pa.a;

/* loaded from: classes4.dex */
public class MaskableFrameLayout extends FrameLayout implements h, q {

    /* renamed from: a, reason: collision with root package name */
    private float f28651a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f28652b;

    /* renamed from: c, reason: collision with root package name */
    private n f28653c;

    /* renamed from: d, reason: collision with root package name */
    private final r f28654d;

    /* renamed from: e, reason: collision with root package name */
    private Boolean f28655e;

    public MaskableFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public MaskableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f28651a = -1.0f;
        this.f28652b = new RectF();
        this.f28654d = r.a(this);
        this.f28655e = null;
        setShapeAppearanceModel(n.f(context, attributeSet, i11, 0, 0).m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ab.d d(ab.d dVar) {
        return dVar instanceof ab.a ? ab.c.b((ab.a) dVar) : dVar;
    }

    private void e() {
        this.f28654d.f(this, this.f28652b);
    }

    private void f() {
        if (this.f28651a != -1.0f) {
            float b11 = oa.a.b(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.f28651a);
            setMaskRectF(new RectF(b11, 0.0f, getWidth() - b11, getHeight()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f28654d.e(canvas, new a.InterfaceC0910a() { // from class: qa.d
            @Override // pa.a.InterfaceC0910a
            public final void a(Canvas canvas2) {
                MaskableFrameLayout.this.c(canvas2);
            }
        });
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        RectF rectF = this.f28652b;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    @NonNull
    public RectF getMaskRectF() {
        return this.f28652b;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.f28651a;
    }

    @NonNull
    public n getShapeAppearanceModel() {
        return this.f28653c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.f28655e;
        if (bool != null) {
            this.f28654d.h(this, bool.booleanValue());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f28655e = Boolean.valueOf(this.f28654d.c());
        this.f28654d.h(this, true);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (this.f28651a != -1.0f) {
            f();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f28652b.isEmpty() && motionEvent.getAction() == 0) {
            if (!this.f28652b.contains(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceCompatClipping(boolean z10) {
        this.f28654d.h(this, z10);
    }

    @Override // com.google.android.material.carousel.h
    public void setMaskRectF(@NonNull RectF rectF) {
        this.f28652b.set(rectF);
        e();
    }

    @Deprecated
    public void setMaskXPercentage(float f11) {
        float a11 = d1.a.a(f11, 0.0f, 1.0f);
        if (this.f28651a != a11) {
            this.f28651a = a11;
            f();
        }
    }

    public void setOnMaskChangedListener(@Nullable qa.e eVar) {
    }

    @Override // ab.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        n y10 = nVar.y(new n.c() { // from class: qa.c
            @Override // ab.n.c
            public final ab.d a(ab.d dVar) {
                ab.d d11;
                d11 = MaskableFrameLayout.d(dVar);
                return d11;
            }
        });
        this.f28653c = y10;
        this.f28654d.g(this, y10);
    }
}
