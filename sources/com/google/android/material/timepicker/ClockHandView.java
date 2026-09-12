package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class ClockHandView extends View {

    /* renamed from: a, reason: collision with root package name */
    private final int f30103a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeInterpolator f30104b;

    /* renamed from: c, reason: collision with root package name */
    private final ValueAnimator f30105c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f30106d;

    /* renamed from: e, reason: collision with root package name */
    private float f30107e;

    /* renamed from: f, reason: collision with root package name */
    private float f30108f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f30109g;

    /* renamed from: h, reason: collision with root package name */
    private final int f30110h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f30111i;

    /* renamed from: j, reason: collision with root package name */
    private final List f30112j;

    /* renamed from: k, reason: collision with root package name */
    private final int f30113k;

    /* renamed from: l, reason: collision with root package name */
    private final float f30114l;

    /* renamed from: m, reason: collision with root package name */
    private final Paint f30115m;

    /* renamed from: n, reason: collision with root package name */
    private final RectF f30116n;

    /* renamed from: o, reason: collision with root package name */
    private final int f30117o;

    /* renamed from: p, reason: collision with root package name */
    private float f30118p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f30119q;

    /* renamed from: r, reason: collision with root package name */
    private b f30120r;

    /* renamed from: s, reason: collision with root package name */
    private double f30121s;

    /* renamed from: t, reason: collision with root package name */
    private int f30122t;

    /* renamed from: u, reason: collision with root package name */
    private int f30123u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(float f11, boolean z10);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void d(float f11, boolean z10);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f30105c = new ValueAnimator();
        this.f30112j = new ArrayList();
        Paint paint = new Paint();
        this.f30115m = paint;
        this.f30116n = new RectF();
        this.f30123u = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, i11, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.f30103a = wa.j.f(context, R$attr.motionDurationLong2, 200);
        this.f30104b = wa.j.g(context, R$attr.motionEasingEmphasizedInterpolator, oa.a.f71042b);
        this.f30122t = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.f30113k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        this.f30117o = getResources().getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.f30114l = r7.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R$styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        q(0.0f);
        this.f30110h = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        obtainStyledAttributes.recycle();
    }

    private void c(float f11, float f12) {
        this.f30123u = va.a.a((float) (getWidth() / 2), (float) (getHeight() / 2), f11, f12) > ((float) i(2)) + f0.g(getContext(), 12) ? 1 : 2;
    }

    private void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f11 = width;
        float i11 = i(this.f30123u);
        float cos = (((float) Math.cos(this.f30121s)) * i11) + f11;
        float f12 = height;
        float sin = (i11 * ((float) Math.sin(this.f30121s))) + f12;
        this.f30115m.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.f30113k, this.f30115m);
        double sin2 = Math.sin(this.f30121s);
        double cos2 = Math.cos(this.f30121s);
        this.f30115m.setStrokeWidth(this.f30117o);
        canvas.drawLine(f11, f12, width + ((int) (cos2 * r7)), height + ((int) (r7 * sin2)), this.f30115m);
        canvas.drawCircle(f11, f12, this.f30114l, this.f30115m);
    }

    private int g(float f11, float f12) {
        int degrees = (int) Math.toDegrees(Math.atan2(f12 - (getHeight() / 2), f11 - (getWidth() / 2)));
        int i11 = degrees + 90;
        return i11 < 0 ? degrees + 450 : i11;
    }

    private int i(int i11) {
        return i11 == 2 ? Math.round(this.f30122t * 0.66f) : this.f30122t;
    }

    private Pair k(float f11) {
        float h11 = h();
        if (Math.abs(h11 - f11) > 180.0f) {
            if (h11 > 180.0f && f11 < 180.0f) {
                f11 += 360.0f;
            }
            if (h11 < 180.0f && f11 > 180.0f) {
                h11 += 360.0f;
            }
        }
        return new Pair(Float.valueOf(h11), Float.valueOf(f11));
    }

    private boolean l(float f11, float f12, boolean z10, boolean z11, boolean z12) {
        float g11 = g(f11, f12);
        boolean z13 = false;
        boolean z14 = h() != g11;
        if (z11 && z14) {
            return true;
        }
        if (!z14 && !z10) {
            return false;
        }
        if (z12 && this.f30106d) {
            z13 = true;
        }
        r(g11, z13);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        s(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void s(float f11, boolean z10) {
        float f12 = f11 % 360.0f;
        this.f30118p = f12;
        this.f30121s = Math.toRadians(f12 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float i11 = i(this.f30123u);
        float cos = width + (((float) Math.cos(this.f30121s)) * i11);
        float sin = height + (i11 * ((float) Math.sin(this.f30121s)));
        RectF rectF = this.f30116n;
        int i12 = this.f30113k;
        rectF.set(cos - i12, sin - i12, cos + i12, sin + i12);
        Iterator it = this.f30112j.iterator();
        while (it.hasNext()) {
            ((c) it.next()).d(f12, z10);
        }
        invalidate();
    }

    public void b(c cVar) {
        this.f30112j.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f30123u;
    }

    public RectF f() {
        return this.f30116n;
    }

    public float h() {
        return this.f30118p;
    }

    public int j() {
        return this.f30113k;
    }

    public void n(boolean z10) {
        this.f30106d = z10;
    }

    public void o(int i11) {
        this.f30122t = i11;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        if (this.f30105c.isRunning()) {
            return;
        }
        q(h());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        b bVar;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f30107e = x10;
            this.f30108f = y10;
            this.f30109g = true;
            this.f30119q = false;
            z10 = false;
            z11 = false;
            z12 = true;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i11 = (int) (x10 - this.f30107e);
            int i12 = (int) (y10 - this.f30108f);
            this.f30109g = (i11 * i11) + (i12 * i12) > this.f30110h;
            boolean z13 = this.f30119q;
            z10 = actionMasked == 1;
            if (this.f30111i) {
                c(x10, y10);
            }
            z12 = false;
            z11 = z13;
        } else {
            z10 = false;
            z11 = false;
            z12 = false;
        }
        boolean l11 = l(x10, y10, z11, z12, z10) | this.f30119q;
        this.f30119q = l11;
        if (l11 && z10 && (bVar = this.f30120r) != null) {
            bVar.a(g(x10, y10), this.f30109g);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i11) {
        this.f30123u = i11;
        invalidate();
    }

    public void q(float f11) {
        r(f11, false);
    }

    public void r(float f11, boolean z10) {
        ValueAnimator valueAnimator = this.f30105c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z10) {
            s(f11, false);
            return;
        }
        Pair k11 = k(f11);
        this.f30105c.setFloatValues(((Float) k11.first).floatValue(), ((Float) k11.second).floatValue());
        this.f30105c.setDuration(this.f30103a);
        this.f30105c.setInterpolator(this.f30104b);
        this.f30105c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ClockHandView.this.m(valueAnimator2);
            }
        });
        this.f30105c.addListener(new a());
        this.f30105c.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(boolean z10) {
        if (this.f30111i && !z10) {
            this.f30123u = 1;
        }
        this.f30111i = z10;
        invalidate();
    }

    public void u(b bVar) {
        this.f30120r = bVar;
    }
}
