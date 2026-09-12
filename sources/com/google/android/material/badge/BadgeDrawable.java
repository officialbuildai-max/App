package com.google.android.material.badge;

import ab.i;
import ab.n;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.y;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import xa.d;

/* loaded from: classes4.dex */
public class BadgeDrawable extends Drawable implements y.b {

    /* renamed from: n, reason: collision with root package name */
    private static final int f28334n = R$style.Widget_MaterialComponents_Badge;

    /* renamed from: o, reason: collision with root package name */
    private static final int f28335o = R$attr.badgeStyle;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f28336a;

    /* renamed from: b, reason: collision with root package name */
    private final i f28337b;

    /* renamed from: c, reason: collision with root package name */
    private final y f28338c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f28339d;

    /* renamed from: e, reason: collision with root package name */
    private final BadgeState f28340e;

    /* renamed from: f, reason: collision with root package name */
    private float f28341f;

    /* renamed from: g, reason: collision with root package name */
    private float f28342g;

    /* renamed from: h, reason: collision with root package name */
    private int f28343h;

    /* renamed from: i, reason: collision with root package name */
    private float f28344i;

    /* renamed from: j, reason: collision with root package name */
    private float f28345j;

    /* renamed from: k, reason: collision with root package name */
    private float f28346k;

    /* renamed from: l, reason: collision with root package name */
    private WeakReference f28347l;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference f28348m;

    private BadgeDrawable(Context context, int i11, int i12, int i13, BadgeState.State state) {
        this.f28336a = new WeakReference(context);
        b0.c(context);
        this.f28339d = new Rect();
        y yVar = new y(this);
        this.f28338c = yVar;
        yVar.g().setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, i11, i12, i13, state);
        this.f28340e = badgeState;
        this.f28337b = new i(n.b(context, A() ? badgeState.m() : badgeState.i(), A() ? badgeState.l() : badgeState.h()).m());
        N();
    }

    private boolean A() {
        return C() || B();
    }

    private boolean D() {
        FrameLayout j11 = j();
        return j11 != null && j11.getId() == R$id.mtrl_anchor_parent;
    }

    private void E() {
        this.f28338c.g().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void F() {
        ColorStateList valueOf = ColorStateList.valueOf(this.f28340e.e());
        if (this.f28337b.z() != valueOf) {
            this.f28337b.d0(valueOf);
            invalidateSelf();
        }
    }

    private void G() {
        this.f28338c.l(true);
        I();
        T();
        invalidateSelf();
    }

    private void H() {
        WeakReference weakReference = this.f28347l;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.f28347l.get();
        WeakReference weakReference2 = this.f28348m;
        S(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
    }

    private void I() {
        Context context = (Context) this.f28336a.get();
        if (context == null) {
            return;
        }
        this.f28337b.setShapeAppearanceModel(n.b(context, A() ? this.f28340e.m() : this.f28340e.i(), A() ? this.f28340e.l() : this.f28340e.h()).m());
        invalidateSelf();
    }

    private void J() {
        d dVar;
        Context context = (Context) this.f28336a.get();
        if (context == null || this.f28338c.e() == (dVar = new d(context, this.f28340e.A()))) {
            return;
        }
        this.f28338c.k(dVar, context);
        K();
        T();
        invalidateSelf();
    }

    private void K() {
        this.f28338c.g().setColor(this.f28340e.j());
        invalidateSelf();
    }

    private void L() {
        U();
        this.f28338c.l(true);
        T();
        invalidateSelf();
    }

    private void M() {
        boolean G = this.f28340e.G();
        setVisible(G, false);
        if (!c.f28360a || j() == null || G) {
            return;
        }
        ((ViewGroup) j().getParent()).invalidate();
    }

    private void N() {
        I();
        J();
        L();
        G();
        E();
        F();
        K();
        H();
        T();
        M();
    }

    private void Q(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R$id.mtrl_anchor_parent) {
            WeakReference weakReference = this.f28348m;
            if (weakReference == null || weakReference.get() != viewGroup) {
                R(view);
                final FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R$id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.f28348m = new WeakReference(frameLayout);
                frameLayout.post(new Runnable() { // from class: com.google.android.material.badge.BadgeDrawable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BadgeDrawable.this.S(view, frameLayout);
                    }
                });
            }
        }
    }

    private static void R(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void T() {
        Context context = (Context) this.f28336a.get();
        WeakReference weakReference = this.f28347l;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f28339d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference weakReference2 = this.f28348m;
        ViewGroup viewGroup = weakReference2 != null ? (ViewGroup) weakReference2.get() : null;
        if (viewGroup != null || c.f28360a) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        c(rect2, view);
        c.i(this.f28339d, this.f28341f, this.f28342g, this.f28345j, this.f28346k);
        float f11 = this.f28344i;
        if (f11 != -1.0f) {
            this.f28337b.a0(f11);
        }
        if (rect.equals(this.f28339d)) {
            return;
        }
        this.f28337b.setBounds(this.f28339d);
    }

    private void U() {
        if (n() != -2) {
            this.f28343h = ((int) Math.pow(10.0d, n() - 1.0d)) - 1;
        } else {
            this.f28343h = o();
        }
    }

    private void b(View view) {
        float f11;
        float f12;
        View j11 = j();
        if (j11 == null) {
            if (!(view.getParent() instanceof View)) {
                return;
            }
            float y10 = view.getY();
            f12 = view.getX();
            j11 = (View) view.getParent();
            f11 = y10;
        } else if (!D()) {
            f11 = 0.0f;
            f12 = 0.0f;
        } else {
            if (!(j11.getParent() instanceof View)) {
                return;
            }
            f11 = j11.getY();
            f12 = j11.getX();
            j11 = (View) j11.getParent();
        }
        float x10 = x(j11, f11);
        float m11 = m(j11, f12);
        float h11 = h(j11, f11);
        float s11 = s(j11, f12);
        if (x10 < 0.0f) {
            this.f28342g += Math.abs(x10);
        }
        if (m11 < 0.0f) {
            this.f28341f += Math.abs(m11);
        }
        if (h11 > 0.0f) {
            this.f28342g -= Math.abs(h11);
        }
        if (s11 > 0.0f) {
            this.f28341f -= Math.abs(s11);
        }
    }

    private void c(Rect rect, View view) {
        float f11 = A() ? this.f28340e.f28352d : this.f28340e.f28351c;
        this.f28344i = f11;
        if (f11 != -1.0f) {
            this.f28345j = f11;
            this.f28346k = f11;
        } else {
            this.f28345j = Math.round((A() ? this.f28340e.f28355g : this.f28340e.f28353e) / 2.0f);
            this.f28346k = Math.round((A() ? this.f28340e.f28356h : this.f28340e.f28354f) / 2.0f);
        }
        if (A()) {
            String g11 = g();
            this.f28345j = Math.max(this.f28345j, (this.f28338c.h(g11) / 2.0f) + this.f28340e.g());
            float max = Math.max(this.f28346k, (this.f28338c.f(g11) / 2.0f) + this.f28340e.k());
            this.f28346k = max;
            this.f28345j = Math.max(this.f28345j, max);
        }
        int z10 = z();
        int f12 = this.f28340e.f();
        if (f12 == 8388691 || f12 == 8388693) {
            this.f28342g = rect.bottom - z10;
        } else {
            this.f28342g = rect.top + z10;
        }
        int y10 = y();
        int f13 = this.f28340e.f();
        if (f13 == 8388659 || f13 == 8388691) {
            this.f28341f = ViewCompat.getLayoutDirection(view) == 0 ? (rect.left - this.f28345j) + y10 : (rect.right + this.f28345j) - y10;
        } else {
            this.f28341f = ViewCompat.getLayoutDirection(view) == 0 ? (rect.right + this.f28345j) - y10 : (rect.left - this.f28345j) + y10;
        }
        if (this.f28340e.F()) {
            b(view);
        }
    }

    public static BadgeDrawable d(Context context) {
        return new BadgeDrawable(context, 0, f28335o, f28334n, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BadgeDrawable e(Context context, BadgeState.State state) {
        return new BadgeDrawable(context, 0, f28335o, f28334n, state);
    }

    private void f(Canvas canvas) {
        String g11 = g();
        if (g11 != null) {
            Rect rect = new Rect();
            this.f28338c.g().getTextBounds(g11, 0, g11.length(), rect);
            float exactCenterY = this.f28342g - rect.exactCenterY();
            canvas.drawText(g11, this.f28341f, rect.bottom <= 0 ? (int) exactCenterY : Math.round(exactCenterY), this.f28338c.g());
        }
    }

    private String g() {
        if (C()) {
            return v();
        }
        if (B()) {
            return q();
        }
        return null;
    }

    private float h(View view, float f11) {
        if (!(view.getParent() instanceof View)) {
            return 0.0f;
        }
        return ((this.f28342g + this.f28346k) - (((View) view.getParent()).getHeight() - view.getY())) + f11;
    }

    private CharSequence k() {
        return this.f28340e.p();
    }

    private float m(View view, float f11) {
        return (this.f28341f - this.f28345j) + view.getX() + f11;
    }

    private String q() {
        if (this.f28343h == -2 || p() <= this.f28343h) {
            return NumberFormat.getInstance(this.f28340e.x()).format(p());
        }
        Context context = (Context) this.f28336a.get();
        return context == null ? "" : String.format(this.f28340e.x(), context.getString(R$string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f28343h), "+");
    }

    private String r() {
        Context context;
        if (this.f28340e.q() == 0 || (context = (Context) this.f28336a.get()) == null) {
            return null;
        }
        return (this.f28343h == -2 || p() <= this.f28343h) ? context.getResources().getQuantityString(this.f28340e.q(), p(), Integer.valueOf(p())) : context.getString(this.f28340e.n(), Integer.valueOf(this.f28343h));
    }

    private float s(View view, float f11) {
        if (!(view.getParent() instanceof View)) {
            return 0.0f;
        }
        return ((this.f28341f + this.f28345j) - (((View) view.getParent()).getWidth() - view.getX())) + f11;
    }

    private String v() {
        String u11 = u();
        int n11 = n();
        if (n11 == -2 || u11 == null || u11.length() <= n11) {
            return u11;
        }
        Context context = (Context) this.f28336a.get();
        if (context == null) {
            return "";
        }
        return String.format(context.getString(R$string.m3_exceed_max_badge_text_suffix), u11.substring(0, n11 - 1), "…");
    }

    private CharSequence w() {
        CharSequence o11 = this.f28340e.o();
        return o11 != null ? o11 : u();
    }

    private float x(View view, float f11) {
        return (this.f28342g - this.f28346k) + view.getY() + f11;
    }

    private int y() {
        int r11 = A() ? this.f28340e.r() : this.f28340e.s();
        if (this.f28340e.f28359k == 1) {
            r11 += A() ? this.f28340e.f28358j : this.f28340e.f28357i;
        }
        return r11 + this.f28340e.b();
    }

    private int z() {
        int C = this.f28340e.C();
        if (A()) {
            C = this.f28340e.B();
            Context context = (Context) this.f28336a.get();
            if (context != null) {
                C = oa.a.c(C, C - this.f28340e.t(), oa.a.b(0.0f, 1.0f, 0.3f, 1.0f, xa.c.f(context) - 1.0f));
            }
        }
        if (this.f28340e.f28359k == 0) {
            C -= Math.round(this.f28346k);
        }
        return C + this.f28340e.c();
    }

    public boolean B() {
        return !this.f28340e.E() && this.f28340e.D();
    }

    public boolean C() {
        return this.f28340e.E();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(int i11) {
        this.f28340e.I(i11);
        T();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(int i11) {
        this.f28340e.J(i11);
        T();
    }

    public void S(View view, FrameLayout frameLayout) {
        this.f28347l = new WeakReference(view);
        boolean z10 = c.f28360a;
        if (z10 && frameLayout == null) {
            Q(view);
        } else {
            this.f28348m = new WeakReference(frameLayout);
        }
        if (!z10) {
            R(view);
        }
        T();
        invalidateSelf();
    }

    @Override // com.google.android.material.internal.y.b
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f28337b.draw(canvas);
        if (A()) {
            f(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f28340e.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f28339d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f28339d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CharSequence i() {
        if (isVisible()) {
            return C() ? w() : B() ? r() : k();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public FrameLayout j() {
        WeakReference weakReference = this.f28348m;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public int l() {
        return this.f28340e.s();
    }

    public int n() {
        return this.f28340e.u();
    }

    public int o() {
        return this.f28340e.v();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.y.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public int p() {
        if (this.f28340e.D()) {
            return this.f28340e.w();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f28340e.K(i11);
        E();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BadgeState.State t() {
        return this.f28340e.y();
    }

    public String u() {
        return this.f28340e.z();
    }
}
