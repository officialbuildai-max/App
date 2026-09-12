package com.google.android.material.floatingactionbutton;

import ab.n;
import ab.q;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.internal.w;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class d {
    static final TimeInterpolator D = oa.a.f71043c;
    private static final int E = R$attr.motionDurationLong2;
    private static final int F = R$attr.motionEasingEmphasizedInterpolator;
    private static final int G = R$attr.motionDurationMedium1;
    private static final int H = R$attr.motionEasingEmphasizedAccelerateInterpolator;
    static final int[] I = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] J = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] K = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] L = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] M = {R.attr.state_enabled};
    static final int[] N = new int[0];
    private ViewTreeObserver.OnPreDrawListener C;

    /* renamed from: a, reason: collision with root package name */
    n f29059a;

    /* renamed from: b, reason: collision with root package name */
    ab.i f29060b;

    /* renamed from: c, reason: collision with root package name */
    Drawable f29061c;

    /* renamed from: d, reason: collision with root package name */
    com.google.android.material.floatingactionbutton.c f29062d;

    /* renamed from: e, reason: collision with root package name */
    Drawable f29063e;

    /* renamed from: f, reason: collision with root package name */
    boolean f29064f;

    /* renamed from: h, reason: collision with root package name */
    float f29066h;

    /* renamed from: i, reason: collision with root package name */
    float f29067i;

    /* renamed from: j, reason: collision with root package name */
    float f29068j;

    /* renamed from: k, reason: collision with root package name */
    int f29069k;

    /* renamed from: l, reason: collision with root package name */
    private final w f29070l;

    /* renamed from: m, reason: collision with root package name */
    private Animator f29071m;

    /* renamed from: n, reason: collision with root package name */
    private oa.h f29072n;

    /* renamed from: o, reason: collision with root package name */
    private oa.h f29073o;

    /* renamed from: p, reason: collision with root package name */
    private float f29074p;

    /* renamed from: r, reason: collision with root package name */
    private int f29076r;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList f29078t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList f29079u;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList f29080v;

    /* renamed from: w, reason: collision with root package name */
    final FloatingActionButton f29081w;

    /* renamed from: x, reason: collision with root package name */
    final za.b f29082x;

    /* renamed from: g, reason: collision with root package name */
    boolean f29065g = true;

    /* renamed from: q, reason: collision with root package name */
    private float f29075q = 1.0f;

    /* renamed from: s, reason: collision with root package name */
    private int f29077s = 0;

    /* renamed from: y, reason: collision with root package name */
    private final Rect f29083y = new Rect();

    /* renamed from: z, reason: collision with root package name */
    private final RectF f29084z = new RectF();
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();

    /* loaded from: classes4.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f29085a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f29086b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f29087c;

        a(boolean z10, k kVar) {
            this.f29086b = z10;
            this.f29087c = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f29085a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f29077s = 0;
            d.this.f29071m = null;
            if (this.f29085a) {
                return;
            }
            FloatingActionButton floatingActionButton = d.this.f29081w;
            boolean z10 = this.f29086b;
            floatingActionButton.internalSetVisibility(z10 ? 8 : 4, z10);
            k kVar = this.f29087c;
            if (kVar != null) {
                kVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.f29081w.internalSetVisibility(0, this.f29086b);
            d.this.f29077s = 1;
            d.this.f29071m = animator;
            this.f29085a = false;
        }
    }

    /* loaded from: classes4.dex */
    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f29089a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f29090b;

        b(boolean z10, k kVar) {
            this.f29089a = z10;
            this.f29090b = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f29077s = 0;
            d.this.f29071m = null;
            k kVar = this.f29090b;
            if (kVar != null) {
                kVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.f29081w.internalSetVisibility(0, this.f29089a);
            d.this.f29077s = 2;
            d.this.f29071m = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends oa.g {
        c() {
        }

        @Override // oa.g, android.animation.TypeEvaluator
        /* renamed from: a */
        public Matrix evaluate(float f11, Matrix matrix, Matrix matrix2) {
            d.this.f29075q = f11;
            return super.evaluate(f11, matrix, matrix2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.floatingactionbutton.d$d, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0397d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f29093a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f29094b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f29095c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f29096d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f29097e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f29098f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f29099g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Matrix f29100h;

        C0397d(float f11, float f12, float f13, float f14, float f15, float f16, float f17, Matrix matrix) {
            this.f29093a = f11;
            this.f29094b = f12;
            this.f29095c = f13;
            this.f29096d = f14;
            this.f29097e = f15;
            this.f29098f = f16;
            this.f29099g = f17;
            this.f29100h = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.f29081w.setAlpha(oa.a.b(this.f29093a, this.f29094b, 0.0f, 0.2f, floatValue));
            d.this.f29081w.setScaleX(oa.a.a(this.f29095c, this.f29096d, floatValue));
            d.this.f29081w.setScaleY(oa.a.a(this.f29097e, this.f29096d, floatValue));
            d.this.f29075q = oa.a.a(this.f29098f, this.f29099g, floatValue);
            d.this.h(oa.a.a(this.f29098f, this.f29099g, floatValue), this.f29100h);
            d.this.f29081w.setImageMatrix(this.f29100h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements TypeEvaluator {

        /* renamed from: a, reason: collision with root package name */
        FloatEvaluator f29102a = new FloatEvaluator();

        e() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f11, Float f12, Float f13) {
            float floatValue = this.f29102a.evaluate(f11, (Number) f12, (Number) f13).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.H();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    private class g extends m {
        g() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            return 0.0f;
        }
    }

    /* loaded from: classes4.dex */
    private class h extends m {
        h() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            d dVar = d.this;
            return dVar.f29066h + dVar.f29067i;
        }
    }

    /* loaded from: classes4.dex */
    private class i extends m {
        i() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            d dVar = d.this;
            return dVar.f29066h + dVar.f29068j;
        }
    }

    /* loaded from: classes4.dex */
    interface j {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    interface k {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    private class l extends m {
        l() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            return d.this.f29066h;
        }
    }

    /* loaded from: classes4.dex */
    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f29109a;

        /* renamed from: b, reason: collision with root package name */
        private float f29110b;

        /* renamed from: c, reason: collision with root package name */
        private float f29111c;

        private m() {
        }

        /* synthetic */ m(d dVar, a aVar) {
            this();
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.j0((int) this.f29111c);
            this.f29109a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f29109a) {
                ab.i iVar = d.this.f29060b;
                this.f29110b = iVar == null ? 0.0f : iVar.y();
                this.f29111c = a();
                this.f29109a = true;
            }
            d dVar = d.this;
            float f11 = this.f29110b;
            dVar.j0((int) (f11 + ((this.f29111c - f11) * valueAnimator.getAnimatedFraction())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FloatingActionButton floatingActionButton, za.b bVar) {
        this.f29081w = floatingActionButton;
        this.f29082x = bVar;
        w wVar = new w();
        this.f29070l = wVar;
        wVar.a(I, k(new i()));
        wVar.a(J, k(new h()));
        wVar.a(K, k(new h()));
        wVar.a(L, k(new h()));
        wVar.a(M, k(new l()));
        wVar.a(N, k(new g()));
        this.f29074p = floatingActionButton.getRotation();
    }

    private boolean d0() {
        return ViewCompat.isLaidOut(this.f29081w) && !this.f29081w.isInEditMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f11, Matrix matrix) {
        matrix.reset();
        if (this.f29081w.getDrawable() == null || this.f29076r == 0) {
            return;
        }
        RectF rectF = this.f29084z;
        RectF rectF2 = this.A;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i11 = this.f29076r;
        rectF2.set(0.0f, 0.0f, i11, i11);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i12 = this.f29076r;
        matrix.postScale(f11, f11, i12 / 2.0f, i12 / 2.0f);
    }

    private AnimatorSet i(oa.h hVar, float f11, float f12, float f13) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f29081w, (Property<FloatingActionButton, Float>) View.ALPHA, f11);
        hVar.h("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f29081w, (Property<FloatingActionButton, Float>) View.SCALE_X, f12);
        hVar.h("scale").a(ofFloat2);
        k0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f29081w, (Property<FloatingActionButton, Float>) View.SCALE_Y, f12);
        hVar.h("scale").a(ofFloat3);
        k0(ofFloat3);
        arrayList.add(ofFloat3);
        h(f13, this.B);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f29081w, new oa.f(), new c(), new Matrix(this.B));
        hVar.h("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        oa.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(float f11, float f12, float f13, int i11, int i12) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new C0397d(this.f29081w.getAlpha(), f11, this.f29081w.getScaleX(), f12, this.f29081w.getScaleY(), this.f29075q, f13, new Matrix(this.B)));
        arrayList.add(ofFloat);
        oa.b.a(animatorSet, arrayList);
        animatorSet.setDuration(wa.j.f(this.f29081w.getContext(), i11, this.f29081w.getContext().getResources().getInteger(R$integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(wa.j.g(this.f29081w.getContext(), i12, oa.a.f71042b));
        return animatorSet;
    }

    private ValueAnimator k(m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private void k0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new e());
    }

    private ViewTreeObserver.OnPreDrawListener q() {
        if (this.C == null) {
            this.C = new f();
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void A();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        ab.i iVar = this.f29060b;
        if (iVar != null) {
            ab.j.f(this.f29081w, iVar);
        }
        if (N()) {
            this.f29081w.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void C();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        ViewTreeObserver viewTreeObserver = this.f29081w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void E(int[] iArr);

    abstract void F(float f11, float f12, float f13);

    void G(Rect rect) {
        androidx.core.util.i.h(this.f29063e, "Didn't initialize content background");
        if (!c0()) {
            this.f29082x.b(this.f29063e);
        } else {
            this.f29082x.b(new InsetDrawable(this.f29063e, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    void H() {
        float rotation = this.f29081w.getRotation();
        if (this.f29074p != rotation) {
            this.f29074p = rotation;
            g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        ArrayList arrayList = this.f29080v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        ArrayList arrayList = this.f29080v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a();
            }
        }
    }

    public void K(Animator.AnimatorListener animatorListener) {
        ArrayList arrayList = this.f29079u;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(Animator.AnimatorListener animatorListener) {
        ArrayList arrayList = this.f29078t;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(j jVar) {
        ArrayList arrayList = this.f29080v;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(jVar);
    }

    abstract boolean N();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(ColorStateList colorStateList) {
        ab.i iVar = this.f29060b;
        if (iVar != null) {
            iVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f29062d;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(PorterDuff.Mode mode) {
        ab.i iVar = this.f29060b;
        if (iVar != null) {
            iVar.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(float f11) {
        if (this.f29066h != f11) {
            this.f29066h = f11;
            F(f11, this.f29067i, this.f29068j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(boolean z10) {
        this.f29064f = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S(oa.h hVar) {
        this.f29073o = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void T(float f11) {
        if (this.f29067i != f11) {
            this.f29067i = f11;
            F(this.f29066h, f11, this.f29068j);
        }
    }

    final void U(float f11) {
        this.f29075q = f11;
        Matrix matrix = this.B;
        h(f11, matrix);
        this.f29081w.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void V(int i11) {
        if (this.f29076r != i11) {
            this.f29076r = i11;
            h0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(int i11) {
        this.f29069k = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void X(float f11) {
        if (this.f29068j != f11) {
            this.f29068j = f11;
            F(this.f29066h, this.f29067i, f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(ColorStateList colorStateList) {
        Drawable drawable = this.f29061c;
        if (drawable != null) {
            a1.a.o(drawable, ya.b.d(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(boolean z10) {
        this.f29065g = z10;
        i0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a0(n nVar) {
        this.f29059a = nVar;
        ab.i iVar = this.f29060b;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        Object obj = this.f29061c;
        if (obj instanceof q) {
            ((q) obj).setShapeAppearanceModel(nVar);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f29062d;
        if (cVar != null) {
            cVar.f(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b0(oa.h hVar) {
        this.f29072n = hVar;
    }

    abstract boolean c0();

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.f29079u == null) {
            this.f29079u = new ArrayList();
        }
        this.f29079u.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e0() {
        return !this.f29064f || this.f29081w.getSizeDimension() >= this.f29069k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Animator.AnimatorListener animatorListener) {
        if (this.f29078t == null) {
            this.f29078t = new ArrayList();
        }
        this.f29078t.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0(k kVar, boolean z10) {
        if (z()) {
            return;
        }
        Animator animator = this.f29071m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z11 = this.f29072n == null;
        if (!d0()) {
            this.f29081w.internalSetVisibility(0, z10);
            this.f29081w.setAlpha(1.0f);
            this.f29081w.setScaleY(1.0f);
            this.f29081w.setScaleX(1.0f);
            U(1.0f);
            if (kVar != null) {
                kVar.a();
                return;
            }
            return;
        }
        if (this.f29081w.getVisibility() != 0) {
            this.f29081w.setAlpha(0.0f);
            this.f29081w.setScaleY(z11 ? 0.4f : 0.0f);
            this.f29081w.setScaleX(z11 ? 0.4f : 0.0f);
            U(z11 ? 0.4f : 0.0f);
        }
        oa.h hVar = this.f29072n;
        AnimatorSet i11 = hVar != null ? i(hVar, 1.0f, 1.0f, 1.0f) : j(1.0f, 1.0f, 1.0f, E, F);
        i11.addListener(new b(z10, kVar));
        ArrayList arrayList = this.f29078t;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i11.addListener((Animator.AnimatorListener) it.next());
            }
        }
        i11.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(j jVar) {
        if (this.f29080v == null) {
            this.f29080v = new ArrayList();
        }
        this.f29080v.add(jVar);
    }

    abstract void g0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h0() {
        U(this.f29075q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i0() {
        Rect rect = this.f29083y;
        r(rect);
        G(rect);
        this.f29082x.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0(float f11) {
        ab.i iVar = this.f29060b;
        if (iVar != null) {
            iVar.c0(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable l() {
        return this.f29063e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float m();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f29064f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final oa.h o() {
        return this.f29073o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p() {
        return this.f29067i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Rect rect) {
        int v11 = v();
        int max = Math.max(v11, (int) Math.ceil(this.f29065g ? m() + this.f29068j : 0.0f));
        int max2 = Math.max(v11, (int) Math.ceil(r1 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float s() {
        return this.f29068j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n t() {
        return this.f29059a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final oa.h u() {
        return this.f29072n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int v() {
        if (this.f29064f) {
            return Math.max((this.f29069k - this.f29081w.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(k kVar, boolean z10) {
        if (y()) {
            return;
        }
        Animator animator = this.f29071m;
        if (animator != null) {
            animator.cancel();
        }
        if (!d0()) {
            this.f29081w.internalSetVisibility(z10 ? 8 : 4, z10);
            if (kVar != null) {
                kVar.b();
                return;
            }
            return;
        }
        oa.h hVar = this.f29073o;
        AnimatorSet i11 = hVar != null ? i(hVar, 0.0f, 0.0f, 0.0f) : j(0.0f, 0.4f, 0.4f, G, H);
        i11.addListener(new a(z10, kVar));
        ArrayList arrayList = this.f29079u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i11.addListener((Animator.AnimatorListener) it.next());
            }
        }
        i11.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return this.f29081w.getVisibility() == 0 ? this.f29077s == 1 : this.f29077s != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        return this.f29081w.getVisibility() != 0 ? this.f29077s == 2 : this.f29077s != 1;
    }
}
