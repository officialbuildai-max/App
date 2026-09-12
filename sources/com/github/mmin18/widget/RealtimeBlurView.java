package com.github.mmin18.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import com.github.mmin18.realtimeblurview.R$styleable;

/* loaded from: classes3.dex */
public class RealtimeBlurView extends View {

    /* renamed from: p, reason: collision with root package name */
    private static int f24194p;

    /* renamed from: q, reason: collision with root package name */
    private static int f24195q;

    /* renamed from: r, reason: collision with root package name */
    private static StopException f24196r = new StopException(null);

    /* renamed from: a, reason: collision with root package name */
    private float f24197a;

    /* renamed from: b, reason: collision with root package name */
    private int f24198b;

    /* renamed from: c, reason: collision with root package name */
    private float f24199c;

    /* renamed from: d, reason: collision with root package name */
    private final c f24200d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f24201e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f24202f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f24203g;

    /* renamed from: h, reason: collision with root package name */
    private Canvas f24204h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f24205i;

    /* renamed from: j, reason: collision with root package name */
    private Paint f24206j;

    /* renamed from: k, reason: collision with root package name */
    private final Rect f24207k;

    /* renamed from: l, reason: collision with root package name */
    private final Rect f24208l;

    /* renamed from: m, reason: collision with root package name */
    private View f24209m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f24210n;

    /* renamed from: o, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f24211o;

    /* loaded from: classes3.dex */
    private static class StopException extends RuntimeException {
        private StopException() {
        }

        /* synthetic */ StopException(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            int[] iArr = new int[2];
            Bitmap bitmap = RealtimeBlurView.this.f24203g;
            View view = RealtimeBlurView.this.f24209m;
            if (view != null && RealtimeBlurView.this.isShown() && RealtimeBlurView.this.l()) {
                boolean z10 = RealtimeBlurView.this.f24203g != bitmap;
                view.getLocationOnScreen(iArr);
                int i11 = -iArr[0];
                int i12 = -iArr[1];
                RealtimeBlurView.this.getLocationOnScreen(iArr);
                int i13 = i11 + iArr[0];
                int i14 = i12 + iArr[1];
                RealtimeBlurView.this.f24202f.eraseColor(RealtimeBlurView.this.f24198b & 16777215);
                int save = RealtimeBlurView.this.f24204h.save();
                RealtimeBlurView.this.f24205i = true;
                RealtimeBlurView.g();
                try {
                    RealtimeBlurView.this.f24204h.scale((RealtimeBlurView.this.f24202f.getWidth() * 1.0f) / RealtimeBlurView.this.getWidth(), (RealtimeBlurView.this.f24202f.getHeight() * 1.0f) / RealtimeBlurView.this.getHeight());
                    RealtimeBlurView.this.f24204h.translate(-i13, -i14);
                    if (view.getBackground() != null) {
                        view.getBackground().draw(RealtimeBlurView.this.f24204h);
                    }
                    view.draw(RealtimeBlurView.this.f24204h);
                } catch (StopException unused) {
                } catch (Throwable th2) {
                    RealtimeBlurView.this.f24205i = false;
                    RealtimeBlurView.h();
                    RealtimeBlurView.this.f24204h.restoreToCount(save);
                    throw th2;
                }
                RealtimeBlurView.this.f24205i = false;
                RealtimeBlurView.h();
                RealtimeBlurView.this.f24204h.restoreToCount(save);
                RealtimeBlurView realtimeBlurView = RealtimeBlurView.this;
                realtimeBlurView.j(realtimeBlurView.f24202f, RealtimeBlurView.this.f24203g);
                if (z10 || RealtimeBlurView.this.f24210n) {
                    RealtimeBlurView.this.invalidate();
                }
            }
            return true;
        }
    }

    public RealtimeBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24207k = new Rect();
        this.f24208l = new Rect();
        this.f24211o = new a();
        this.f24200d = getBlurImpl();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RealtimeBlurView);
        this.f24199c = obtainStyledAttributes.getDimension(R$styleable.RealtimeBlurView_realtimeBlurRadius, TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        this.f24197a = obtainStyledAttributes.getFloat(R$styleable.RealtimeBlurView_realtimeDownsampleFactor, 4.0f);
        this.f24198b = obtainStyledAttributes.getColor(R$styleable.RealtimeBlurView_realtimeOverlayColor, -1426063361);
        obtainStyledAttributes.recycle();
        this.f24206j = new Paint();
    }

    static /* synthetic */ int g() {
        int i11 = f24194p;
        f24194p = i11 + 1;
        return i11;
    }

    static /* synthetic */ int h() {
        int i11 = f24194p;
        f24194p = i11 - 1;
        return i11;
    }

    private void n() {
        Bitmap bitmap = this.f24202f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f24202f = null;
        }
        Bitmap bitmap2 = this.f24203g;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f24203g = null;
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f24205i) {
            throw f24196r;
        }
        if (f24194p > 0) {
            return;
        }
        super.draw(canvas);
    }

    protected View getActivityDecorView() {
        Context context = getContext();
        for (int i11 = 0; i11 < 4 && context != null && !(context instanceof Activity) && (context instanceof ContextWrapper); i11++) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView();
        }
        return null;
    }

    protected c getBlurImpl() {
        if (f24195q == 0) {
            try {
                com.github.mmin18.widget.a aVar = new com.github.mmin18.widget.a();
                Bitmap createBitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                aVar.b(getContext(), createBitmap, 4.0f);
                aVar.release();
                createBitmap.recycle();
                f24195q = 3;
            } catch (Throwable unused) {
            }
        }
        if (f24195q == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                b bVar = new b();
                Bitmap createBitmap2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                bVar.b(getContext(), createBitmap2, 4.0f);
                bVar.release();
                createBitmap2.recycle();
                f24195q = 1;
            } catch (Throwable unused2) {
            }
        }
        if (f24195q == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                e eVar = new e();
                Bitmap createBitmap3 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                eVar.b(getContext(), createBitmap3, 4.0f);
                eVar.release();
                createBitmap3.recycle();
                f24195q = 2;
            } catch (Throwable unused3) {
            }
        }
        if (f24195q == 0) {
            f24195q = -1;
        }
        int i11 = f24195q;
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? new d() : new com.github.mmin18.widget.a() : new e() : new b();
    }

    protected void j(Bitmap bitmap, Bitmap bitmap2) {
        this.f24200d.a(bitmap, bitmap2);
    }

    protected void k(Canvas canvas, Bitmap bitmap, int i11) {
        if (bitmap != null) {
            this.f24207k.right = bitmap.getWidth();
            this.f24207k.bottom = bitmap.getHeight();
            this.f24208l.right = getWidth();
            this.f24208l.bottom = getHeight();
            canvas.drawBitmap(bitmap, this.f24207k, this.f24208l, (Paint) null);
        }
        this.f24206j.setColor(i11);
        canvas.drawRect(this.f24208l, this.f24206j);
    }

    protected boolean l() {
        Bitmap bitmap;
        float f11 = this.f24199c;
        if (f11 == 0.0f) {
            m();
            return false;
        }
        float f12 = this.f24197a;
        float f13 = f11 / f12;
        if (f13 > 25.0f) {
            f12 = (f12 * f13) / 25.0f;
            f13 = 25.0f;
        }
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(1, (int) (width / f12));
        int max2 = Math.max(1, (int) (height / f12));
        boolean z10 = this.f24201e;
        if (this.f24204h == null || (bitmap = this.f24203g) == null || bitmap.getWidth() != max || this.f24203g.getHeight() != max2) {
            n();
            try {
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                Bitmap createBitmap = Bitmap.createBitmap(max, max2, config);
                this.f24202f = createBitmap;
                if (createBitmap == null) {
                    m();
                    return false;
                }
                this.f24204h = new Canvas(this.f24202f);
                Bitmap createBitmap2 = Bitmap.createBitmap(max, max2, config);
                this.f24203g = createBitmap2;
                if (createBitmap2 == null) {
                    m();
                    return false;
                }
                z10 = true;
            } catch (OutOfMemoryError unused) {
                m();
                return false;
            } catch (Throwable unused2) {
                m();
                return false;
            }
        }
        if (z10) {
            if (!this.f24200d.b(getContext(), this.f24202f, f13)) {
                return false;
            }
            this.f24201e = false;
        }
        return true;
    }

    protected void m() {
        n();
        this.f24200d.release();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        View activityDecorView = getActivityDecorView();
        this.f24209m = activityDecorView;
        if (activityDecorView == null) {
            this.f24210n = false;
            return;
        }
        activityDecorView.getViewTreeObserver().addOnPreDrawListener(this.f24211o);
        boolean z10 = this.f24209m.getRootView() != getRootView();
        this.f24210n = z10;
        if (z10) {
            this.f24209m.postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        View view = this.f24209m;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.f24211o);
        }
        m();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        k(canvas, this.f24203g, this.f24198b);
    }

    public void setBlurRadius(float f11) {
        if (this.f24199c != f11) {
            this.f24199c = f11;
            this.f24201e = true;
            invalidate();
        }
    }

    public void setDownsampleFactor(float f11) {
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        }
        if (this.f24197a != f11) {
            this.f24197a = f11;
            this.f24201e = true;
            n();
            invalidate();
        }
    }

    public void setOverlayColor(int i11) {
        if (this.f24198b != i11) {
            this.f24198b = i11;
            invalidate();
        }
    }
}
