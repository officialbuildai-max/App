package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.progressindicator.b;
import java.util.Arrays;

/* loaded from: classes4.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.b> extends ProgressBar {
    public static final int HIDE_ESCAPE = 3;
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;

    /* renamed from: o, reason: collision with root package name */
    static final int f29455o = R$style.Widget_MaterialComponents_ProgressIndicator;

    /* renamed from: a, reason: collision with root package name */
    com.google.android.material.progressindicator.b f29456a;

    /* renamed from: b, reason: collision with root package name */
    private int f29457b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f29458c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f29459d;

    /* renamed from: e, reason: collision with root package name */
    private final int f29460e;

    /* renamed from: f, reason: collision with root package name */
    private final int f29461f;

    /* renamed from: g, reason: collision with root package name */
    private long f29462g;

    /* renamed from: h, reason: collision with root package name */
    com.google.android.material.progressindicator.a f29463h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f29464i;

    /* renamed from: j, reason: collision with root package name */
    private int f29465j;

    /* renamed from: k, reason: collision with root package name */
    private final Runnable f29466k;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f29467l;

    /* renamed from: m, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f29468m;

    /* renamed from: n, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f29469n;

    /* loaded from: classes4.dex */
    class a extends androidx.vectordrawable.graphics.drawable.b {
        a() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.f29457b, BaseProgressIndicator.this.f29458c);
        }
    }

    /* loaded from: classes4.dex */
    class b extends androidx.vectordrawable.graphics.drawable.b {
        b() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (BaseProgressIndicator.this.f29464i) {
                return;
            }
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setVisibility(baseProgressIndicator.f29465j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseProgressIndicator(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(bb.a.c(context, attributeSet, i11, f29455o), attributeSet, i11);
        this.f29462g = -1L;
        this.f29464i = false;
        this.f29465j = 4;
        this.f29466k = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.k();
            }
        };
        this.f29467l = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.2
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.j();
                BaseProgressIndicator.this.f29462g = -1L;
            }
        };
        this.f29468m = new a();
        this.f29469n = new b();
        Context context2 = getContext();
        this.f29456a = i(context2, attributeSet);
        TypedArray i13 = b0.i(context2, attributeSet, R$styleable.BaseProgressIndicator, i11, i12, new int[0]);
        this.f29460e = i13.getInt(R$styleable.BaseProgressIndicator_showDelay, -1);
        this.f29461f = Math.min(i13.getInt(R$styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        i13.recycle();
        this.f29463h = new com.google.android.material.progressindicator.a();
        this.f29459d = true;
    }

    @Nullable
    private h getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().w();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ((g) getCurrentDrawable()).q(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f29461f > 0) {
            this.f29462g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean m() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private void n() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().v().d(this.f29468m);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().m(this.f29469n);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().m(this.f29469n);
        }
    }

    private void o() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().s(this.f29469n);
            getIndeterminateDrawable().v().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().s(this.f29469n);
        }
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f29456a.f29477f;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public j getIndeterminateDrawable() {
        return (j) super.getIndeterminateDrawable();
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.f29456a.f29474c;
    }

    public int getIndicatorTrackGapSize() {
        return this.f29456a.f29478g;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public f getProgressDrawable() {
        return (f) super.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.f29456a.f29476e;
    }

    public int getTrackColor() {
        return this.f29456a.f29475d;
    }

    public int getTrackCornerRadius() {
        return this.f29456a.f29473b;
    }

    public int getTrackThickness() {
        return this.f29456a.f29472a;
    }

    protected void h(boolean z10) {
        if (this.f29459d) {
            ((g) getCurrentDrawable()).q(p(), false, z10);
        }
    }

    public void hide() {
        if (getVisibility() != 0) {
            removeCallbacks(this.f29466k);
            return;
        }
        removeCallbacks(this.f29467l);
        long uptimeMillis = SystemClock.uptimeMillis() - this.f29462g;
        int i11 = this.f29461f;
        if (uptimeMillis >= i11) {
            this.f29467l.run();
        } else {
            postDelayed(this.f29467l, i11 - uptimeMillis);
        }
    }

    abstract com.google.android.material.progressindicator.b i(Context context, AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (p()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f29467l);
        removeCallbacks(this.f29466k);
        ((g) getCurrentDrawable()).i();
        o();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        try {
            int save = canvas.save();
            if (getPaddingLeft() == 0) {
                if (getPaddingTop() != 0) {
                }
                if (getPaddingRight() == 0 || getPaddingBottom() != 0) {
                    canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
                }
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(save);
            }
            canvas.translate(getPaddingLeft(), getPaddingTop());
            if (getPaddingRight() == 0) {
            }
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i11, int i12) {
        try {
            h currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            setMeasuredDimension(currentDrawingDelegate.f() < 0 ? View.getDefaultSize(getSuggestedMinimumWidth(), i11) : currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.e() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i12) : currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        h(i11 == 0);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        h(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return ViewCompat.isAttachedToWindow(this) && getWindowVisibility() == 0 && l();
    }

    public void setAnimatorDurationScaleProvider(@NonNull com.google.android.material.progressindicator.a aVar) {
        this.f29463h = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f29511c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f29511c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i11) {
        this.f29456a.f29477f = i11;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z10) {
        try {
            if (z10 == isIndeterminate()) {
                return;
            }
            g gVar = (g) getCurrentDrawable();
            if (gVar != null) {
                gVar.i();
            }
            super.setIndeterminate(z10);
            g gVar2 = (g) getCurrentDrawable();
            if (gVar2 != null) {
                gVar2.q(p(), false, false);
            }
            if ((gVar2 instanceof j) && p()) {
                ((j) gVar2).v().g();
            }
            this.f29464i = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof j)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((g) drawable).i();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{com.google.android.material.color.b.b(getContext(), R$attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f29456a.f29474c = iArr;
        getIndeterminateDrawable().v().c();
        invalidate();
    }

    public void setIndicatorTrackGapSize(int i11) {
        com.google.android.material.progressindicator.b bVar = this.f29456a;
        if (bVar.f29478g != i11) {
            bVar.f29478g = i11;
            bVar.e();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i11) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i11, false);
    }

    public void setProgressCompat(int i11, boolean z10) {
        if (!isIndeterminate()) {
            super.setProgress(i11);
            if (getProgressDrawable() == null || z10) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.f29457b = i11;
            this.f29458c = z10;
            this.f29464i = true;
            if (!getIndeterminateDrawable().isVisible() || this.f29463h.a(getContext().getContentResolver()) == 0.0f) {
                this.f29468m.onAnimationEnd(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().v().f();
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof f)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            f fVar = (f) drawable;
            fVar.i();
            super.setProgressDrawable(fVar);
            fVar.B(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i11) {
        this.f29456a.f29476e = i11;
        invalidate();
    }

    public void setTrackColor(int i11) {
        com.google.android.material.progressindicator.b bVar = this.f29456a;
        if (bVar.f29475d != i11) {
            bVar.f29475d = i11;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i11) {
        com.google.android.material.progressindicator.b bVar = this.f29456a;
        if (bVar.f29473b != i11) {
            bVar.f29473b = Math.min(i11, bVar.f29472a / 2);
            invalidate();
        }
    }

    public void setTrackThickness(int i11) {
        com.google.android.material.progressindicator.b bVar = this.f29456a;
        if (bVar.f29472a != i11) {
            bVar.f29472a = i11;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i11) {
        if (i11 != 0 && i11 != 4 && i11 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f29465j = i11;
    }

    public void show() {
        if (this.f29460e <= 0) {
            this.f29466k.run();
        } else {
            removeCallbacks(this.f29466k);
            postDelayed(this.f29466k, this.f29460e);
        }
    }
}
