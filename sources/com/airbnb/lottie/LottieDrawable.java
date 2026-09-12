package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    private static final boolean S;
    private static final List T;
    private static final Executor U;
    private Canvas A;
    private Rect B;
    private RectF C;
    private Paint D;
    private Rect E;
    private Rect F;
    private RectF G;
    private RectF H;
    private Matrix I;
    private Matrix J;
    private boolean K;
    private AsyncUpdates L;
    private final ValueAnimator.AnimatorUpdateListener M;
    private final Semaphore N;
    private Handler O;
    private Runnable P;
    private final Runnable Q;
    private float R;

    /* renamed from: a, reason: collision with root package name */
    private h f17749a;

    /* renamed from: b, reason: collision with root package name */
    private final v4.i f17750b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17751c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f17752d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f17753e;

    /* renamed from: f, reason: collision with root package name */
    private OnVisibleAction f17754f;

    /* renamed from: g, reason: collision with root package name */
    private final ArrayList f17755g;

    /* renamed from: h, reason: collision with root package name */
    private o4.b f17756h;

    /* renamed from: i, reason: collision with root package name */
    private String f17757i;

    /* renamed from: j, reason: collision with root package name */
    private o4.a f17758j;

    /* renamed from: k, reason: collision with root package name */
    private Map f17759k;

    /* renamed from: l, reason: collision with root package name */
    String f17760l;

    /* renamed from: m, reason: collision with root package name */
    com.airbnb.lottie.a f17761m;

    /* renamed from: n, reason: collision with root package name */
    private final k0 f17762n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f17763o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f17764p;

    /* renamed from: q, reason: collision with root package name */
    private com.airbnb.lottie.model.layer.b f17765q;

    /* renamed from: r, reason: collision with root package name */
    private int f17766r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f17767s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f17768t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f17769u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f17770v;

    /* renamed from: w, reason: collision with root package name */
    private RenderMode f17771w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f17772x;

    /* renamed from: y, reason: collision with root package name */
    private final Matrix f17773y;

    /* renamed from: z, reason: collision with root package name */
    private Bitmap f17774z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void a(h hVar);
    }

    static {
        S = Build.VERSION.SDK_INT <= 25;
        T = Arrays.asList("reduced motion", "reduced_motion", "reduced-motion", "reducedmotion");
        U = new ThreadPoolExecutor(0, 2, 35L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new v4.g());
    }

    public LottieDrawable() {
        v4.i iVar = new v4.i();
        this.f17750b = iVar;
        this.f17751c = true;
        this.f17752d = false;
        this.f17753e = false;
        this.f17754f = OnVisibleAction.NONE;
        this.f17755g = new ArrayList();
        this.f17762n = new k0();
        this.f17763o = false;
        this.f17764p = true;
        this.f17766r = 255;
        this.f17770v = false;
        this.f17771w = RenderMode.AUTOMATIC;
        this.f17772x = false;
        this.f17773y = new Matrix();
        this.K = false;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LottieDrawable.this.p0(valueAnimator);
            }
        };
        this.M = animatorUpdateListener;
        this.N = new Semaphore(1);
        this.Q = new Runnable() { // from class: com.airbnb.lottie.g0
            @Override // java.lang.Runnable
            public final void run() {
                LottieDrawable.this.r0();
            }
        };
        this.R = -3.4028235E38f;
        iVar.addUpdateListener(animatorUpdateListener);
    }

    private void A() {
        h hVar = this.f17749a;
        if (hVar == null) {
            return;
        }
        this.f17772x = this.f17771w.useSoftwareRendering(Build.VERSION.SDK_INT, hVar.q(), hVar.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(int i11, int i12, h hVar) {
        i1(i11, i12);
    }

    private boolean A1() {
        h hVar = this.f17749a;
        if (hVar == null) {
            return false;
        }
        float f11 = this.R;
        float l11 = this.f17750b.l();
        this.R = l11;
        return Math.abs(l11 - f11) * hVar.d() >= 50.0f;
    }

    private void B(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(float f11, float f12, h hVar) {
        l1(f11, f12);
    }

    private void C(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(int i11, h hVar) {
        m1(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(String str, h hVar) {
        n1(str);
    }

    private void E(Canvas canvas) {
        com.airbnb.lottie.model.layer.b bVar = this.f17765q;
        h hVar = this.f17749a;
        if (bVar == null || hVar == null) {
            return;
        }
        this.f17773y.reset();
        if (!getBounds().isEmpty()) {
            this.f17773y.preScale(r2.width() / hVar.b().width(), r2.height() / hVar.b().height());
            this.f17773y.preTranslate(r2.left, r2.top);
        }
        bVar.h(canvas, this.f17773y, this.f17766r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(float f11, h hVar) {
        o1(f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(float f11, h hVar) {
        r1(f11);
    }

    private void H(int i11, int i12) {
        Bitmap bitmap = this.f17774z;
        if (bitmap == null || bitmap.getWidth() < i11 || this.f17774z.getHeight() < i12) {
            Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            this.f17774z = createBitmap;
            this.A.setBitmap(createBitmap);
            this.K = true;
            return;
        }
        if (this.f17774z.getWidth() > i11 || this.f17774z.getHeight() > i12) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.f17774z, 0, 0, i11, i12);
            this.f17774z = createBitmap2;
            this.A.setBitmap(createBitmap2);
            this.K = true;
        }
    }

    private void I() {
        if (this.A != null) {
            return;
        }
        this.A = new Canvas();
        this.H = new RectF();
        this.I = new Matrix();
        this.J = new Matrix();
        this.B = new Rect();
        this.C = new RectF();
        this.D = new l4.a();
        this.E = new Rect();
        this.F = new Rect();
        this.G = new RectF();
    }

    private void N0(Canvas canvas, com.airbnb.lottie.model.layer.b bVar) {
        if (this.f17749a == null || bVar == null) {
            return;
        }
        I();
        canvas.getMatrix(this.I);
        canvas.getClipBounds(this.B);
        B(this.B, this.C);
        this.I.mapRect(this.C);
        C(this.C, this.B);
        if (this.f17764p) {
            this.H.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            bVar.f(this.H, null, false);
        }
        this.I.mapRect(this.H);
        Rect bounds = getBounds();
        float width = bounds.width() / getIntrinsicWidth();
        float height = bounds.height() / getIntrinsicHeight();
        R0(this.H, width, height);
        if (!j0()) {
            RectF rectF = this.H;
            Rect rect = this.B;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int ceil = (int) Math.ceil(this.H.width());
        int ceil2 = (int) Math.ceil(this.H.height());
        if (ceil <= 0 || ceil2 <= 0) {
            return;
        }
        H(ceil, ceil2);
        if (this.K) {
            this.f17773y.set(this.I);
            this.f17773y.preScale(width, height);
            Matrix matrix = this.f17773y;
            RectF rectF2 = this.H;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.f17774z.eraseColor(0);
            bVar.h(this.A, this.f17773y, this.f17766r);
            this.I.invert(this.J);
            this.J.mapRect(this.G, this.H);
            C(this.G, this.F);
        }
        this.E.set(0, 0, ceil, ceil2);
        canvas.drawBitmap(this.f17774z, this.E, this.F, this.D);
    }

    private Context P() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private o4.a Q() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f17758j == null) {
            o4.a aVar = new o4.a(getCallback(), this.f17761m);
            this.f17758j = aVar;
            String str = this.f17760l;
            if (str != null) {
                aVar.c(str);
            }
        }
        return this.f17758j;
    }

    private void R0(RectF rectF, float f11, float f12) {
        rectF.set(rectF.left * f11, rectF.top * f12, rectF.right * f11, rectF.bottom * f12);
    }

    private o4.b S() {
        o4.b bVar = this.f17756h;
        if (bVar != null && !bVar.b(P())) {
            this.f17756h = null;
        }
        if (this.f17756h == null) {
            this.f17756h = new o4.b(getCallback(), this.f17757i, null, this.f17749a.j());
        }
        return this.f17756h;
    }

    private p4.g W() {
        Iterator it = T.iterator();
        p4.g gVar = null;
        while (it.hasNext()) {
            gVar = this.f17749a.l((String) it.next());
            if (gVar != null) {
                break;
            }
        }
        return gVar;
    }

    private boolean j0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (((View) callback).getParent() instanceof ViewGroup) {
            return !((ViewGroup) r0).getClipChildren();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(p4.d dVar, Object obj, w4.c cVar, h hVar) {
        v(dVar, obj, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(ValueAnimator valueAnimator) {
        if (K()) {
            invalidateSelf();
            return;
        }
        com.airbnb.lottie.model.layer.b bVar = this.f17765q;
        if (bVar != null) {
            bVar.M(this.f17750b.l());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0() {
        com.airbnb.lottie.model.layer.b bVar = this.f17765q;
        if (bVar == null) {
            return;
        }
        try {
            this.N.acquire();
            bVar.M(this.f17750b.l());
            if (S && this.K) {
                if (this.O == null) {
                    this.O = new Handler(Looper.getMainLooper());
                    this.P = new Runnable() { // from class: com.airbnb.lottie.a0
                        @Override // java.lang.Runnable
                        public final void run() {
                            LottieDrawable.this.q0();
                        }
                    };
                }
                this.O.post(this.P);
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th2) {
            this.N.release();
            throw th2;
        }
        this.N.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(h hVar) {
        H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(h hVar) {
        P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(int i11, h hVar) {
        a1(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(String str, h hVar) {
        g1(str);
    }

    private boolean w() {
        return this.f17751c || this.f17752d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(int i11, h hVar) {
        f1(i11);
    }

    private void x() {
        h hVar = this.f17749a;
        if (hVar == null) {
            return;
        }
        com.airbnb.lottie.model.layer.b bVar = new com.airbnb.lottie.model.layer.b(this, u4.v.a(hVar), hVar.k(), hVar);
        this.f17765q = bVar;
        if (this.f17768t) {
            bVar.K(true);
        }
        this.f17765q.S(this.f17764p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(float f11, h hVar) {
        h1(f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(String str, h hVar) {
        j1(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(String str, String str2, boolean z10, h hVar) {
        k1(str, str2, z10);
    }

    public Bitmap B1(String str, Bitmap bitmap) {
        o4.b S2 = S();
        if (S2 == null) {
            v4.f.c("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap e11 = S2.e(str, bitmap);
        invalidateSelf();
        return e11;
    }

    public boolean C1() {
        return this.f17759k == null && this.f17749a.c().p() > 0;
    }

    public void D() {
    }

    public void F(LottieFeatureFlag lottieFeatureFlag, boolean z10) {
        boolean a11 = this.f17762n.a(lottieFeatureFlag, z10);
        if (this.f17749a == null || !a11) {
            return;
        }
        x();
    }

    public void G() {
        this.f17755g.clear();
        this.f17750b.k();
        if (isVisible()) {
            return;
        }
        this.f17754f = OnVisibleAction.NONE;
    }

    public void G0() {
        this.f17755g.clear();
        this.f17750b.s();
        if (isVisible()) {
            return;
        }
        this.f17754f = OnVisibleAction.NONE;
    }

    public void H0() {
        if (this.f17765q == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.h0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    LottieDrawable.this.s0(hVar);
                }
            });
            return;
        }
        A();
        if (w() || c0() == 0) {
            if (isVisible()) {
                this.f17750b.t();
                this.f17754f = OnVisibleAction.NONE;
            } else {
                this.f17754f = OnVisibleAction.PLAY;
            }
        }
        if (w()) {
            return;
        }
        p4.g W = W();
        if (W != null) {
            a1((int) W.f72425b);
        } else {
            a1((int) (e0() < 0.0f ? Y() : X()));
        }
        this.f17750b.k();
        if (isVisible()) {
            return;
        }
        this.f17754f = OnVisibleAction.NONE;
    }

    public void I0() {
        this.f17750b.removeAllListeners();
    }

    public AsyncUpdates J() {
        AsyncUpdates asyncUpdates = this.L;
        return asyncUpdates != null ? asyncUpdates : d.d();
    }

    public void J0() {
        this.f17750b.removeAllUpdateListeners();
        this.f17750b.addUpdateListener(this.M);
    }

    public boolean K() {
        return J() == AsyncUpdates.ENABLED;
    }

    public void K0(Animator.AnimatorListener animatorListener) {
        this.f17750b.removeListener(animatorListener);
    }

    public Bitmap L(String str) {
        o4.b S2 = S();
        if (S2 != null) {
            return S2.a(str);
        }
        return null;
    }

    public void L0(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f17750b.removePauseListener(animatorPauseListener);
    }

    public boolean M() {
        return this.f17770v;
    }

    public void M0(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f17750b.removeUpdateListener(animatorUpdateListener);
    }

    public boolean N() {
        return this.f17764p;
    }

    public h O() {
        return this.f17749a;
    }

    public List O0(p4.d dVar) {
        if (this.f17765q == null) {
            v4.f.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f17765q.d(dVar, 0, arrayList, new p4.d(new String[0]));
        return arrayList;
    }

    public void P0() {
        if (this.f17765q == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.b0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    LottieDrawable.this.t0(hVar);
                }
            });
            return;
        }
        A();
        if (w() || c0() == 0) {
            if (isVisible()) {
                this.f17750b.x();
                this.f17754f = OnVisibleAction.NONE;
            } else {
                this.f17754f = OnVisibleAction.RESUME;
            }
        }
        if (w()) {
            return;
        }
        a1((int) (e0() < 0.0f ? Y() : X()));
        this.f17750b.k();
        if (isVisible()) {
            return;
        }
        this.f17754f = OnVisibleAction.NONE;
    }

    public void Q0() {
        this.f17750b.y();
    }

    public int R() {
        return (int) this.f17750b.m();
    }

    public void S0(boolean z10) {
        this.f17769u = z10;
    }

    public String T() {
        return this.f17757i;
    }

    public void T0(AsyncUpdates asyncUpdates) {
        this.L = asyncUpdates;
    }

    public l0 U(String str) {
        h hVar = this.f17749a;
        if (hVar == null) {
            return null;
        }
        return (l0) hVar.j().get(str);
    }

    public void U0(boolean z10) {
        if (z10 != this.f17770v) {
            this.f17770v = z10;
            invalidateSelf();
        }
    }

    public boolean V() {
        return this.f17763o;
    }

    public void V0(boolean z10) {
        if (z10 != this.f17764p) {
            this.f17764p = z10;
            com.airbnb.lottie.model.layer.b bVar = this.f17765q;
            if (bVar != null) {
                bVar.S(z10);
            }
            invalidateSelf();
        }
    }

    public boolean W0(h hVar) {
        if (this.f17749a == hVar) {
            return false;
        }
        this.K = true;
        z();
        this.f17749a = hVar;
        x();
        this.f17750b.z(hVar);
        r1(this.f17750b.getAnimatedFraction());
        Iterator it = new ArrayList(this.f17755g).iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.a(hVar);
            }
            it.remove();
        }
        this.f17755g.clear();
        hVar.v(this.f17767s);
        A();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public float X() {
        return this.f17750b.o();
    }

    public void X0(String str) {
        this.f17760l = str;
        o4.a Q = Q();
        if (Q != null) {
            Q.c(str);
        }
    }

    public float Y() {
        return this.f17750b.p();
    }

    public void Y0(com.airbnb.lottie.a aVar) {
        this.f17761m = aVar;
        o4.a aVar2 = this.f17758j;
        if (aVar2 != null) {
            aVar2.d(aVar);
        }
    }

    public PerformanceTracker Z() {
        h hVar = this.f17749a;
        if (hVar != null) {
            return hVar.n();
        }
        return null;
    }

    public void Z0(Map map) {
        if (map == this.f17759k) {
            return;
        }
        this.f17759k = map;
        invalidateSelf();
    }

    public float a0() {
        return this.f17750b.l();
    }

    public void a1(final int i11) {
        if (this.f17749a == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.t
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    LottieDrawable.this.u0(i11, hVar);
                }
            });
        } else {
            this.f17750b.A(i11);
        }
    }

    public RenderMode b0() {
        return this.f17772x ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public void b1(boolean z10) {
        this.f17752d = z10;
    }

    public int c0() {
        return this.f17750b.getRepeatCount();
    }

    public void c1(b bVar) {
        o4.b bVar2 = this.f17756h;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
    }

    public int d0() {
        return this.f17750b.getRepeatMode();
    }

    public void d1(String str) {
        this.f17757i = str;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.airbnb.lottie.model.layer.b bVar = this.f17765q;
        if (bVar == null) {
            return;
        }
        boolean K = K();
        if (K) {
            try {
                this.N.acquire();
            } catch (InterruptedException unused) {
                if (d.g()) {
                    d.c("Drawable#draw");
                }
                if (!K) {
                    return;
                }
                this.N.release();
                if (bVar.P() == this.f17750b.l()) {
                    return;
                }
            } catch (Throwable th2) {
                if (d.g()) {
                    d.c("Drawable#draw");
                }
                if (K) {
                    this.N.release();
                    if (bVar.P() != this.f17750b.l()) {
                        U.execute(this.Q);
                    }
                }
                throw th2;
            }
        }
        if (d.g()) {
            d.b("Drawable#draw");
        }
        if (K && A1()) {
            r1(this.f17750b.l());
        }
        if (this.f17753e) {
            try {
                if (this.f17772x) {
                    N0(canvas, bVar);
                } else {
                    E(canvas);
                }
            } catch (Throwable th3) {
                v4.f.b("Lottie crashed in draw!", th3);
            }
        } else if (this.f17772x) {
            N0(canvas, bVar);
        } else {
            E(canvas);
        }
        this.K = false;
        if (d.g()) {
            d.c("Drawable#draw");
        }
        if (K) {
            this.N.release();
            if (bVar.P() == this.f17750b.l()) {
                return;
            }
            U.execute(this.Q);
        }
    }

    public float e0() {
        return this.f17750b.q();
    }

    public void e1(boolean z10) {
        this.f17763o = z10;
    }

    public t0 f0() {
        return null;
    }

    public void f1(final int i11) {
        if (this.f17749a == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.w
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    LottieDrawable.this.w0(i11, hVar);
                }
            });
        } else {
            this.f17750b.B(i11 + 0.99f);
        }
    }

    public Typeface g0(p4.b bVar) {
        Map map = this.f17759k;
        if (map != null) {
            String a11 = bVar.a();
            if (map.containsKey(a11)) {
                return (Typeface) map.get(a11);
            }
            String b11 = bVar.b();
            if (map.containsKey(b11)) {
                return (Typeface) map.get(b11);
            }
            String str = bVar.a() + "-" + bVar.c();
            if (map.containsKey(str)) {
                return (Typeface) map.get(str);
            }
        }
        o4.a Q = Q();
        if (Q != null) {
            return Q.b(bVar);
        }
        return null;
    }

    public void g1(final String str) {
        h hVar = this.f17749a;
        if (hVar == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.d0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    LottieDrawable.this.v0(str, hVar2);
                }
            });
            return;
        }
        p4.g l11 = hVar.l(str);
        if (l11 != null) {
            f1((int) (l11.f72425b + l11.f72426c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f17766r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        h hVar = this.f17749a;
        if (hVar == null) {
            return -1;
        }
        return hVar.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        h hVar = this.f17749a;
        if (hVar == null) {
            return -1;
        }
        return hVar.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h0() {
        com.airbnb.lottie.model.layer.b bVar = this.f17765q;
        return bVar != null && bVar.Q();
    }

    public void h1(final float f11) {
        h hVar = this.f17749a;
        if (hVar == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.z
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    LottieDrawable.this.x0(f11, hVar2);
                }
            });
        } else {
            this.f17750b.B(v4.k.i(hVar.p(), this.f17749a.f(), f11));
        }
    }

    public boolean i0() {
        com.airbnb.lottie.model.layer.b bVar = this.f17765q;
        return bVar != null && bVar.R();
    }

    public void i1(final int i11, final int i12) {
        if (this.f17749a == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.v
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    LottieDrawable.this.A0(i11, i12, hVar);
                }
            });
        } else {
            this.f17750b.C(i11, i12 + 0.99f);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback;
        if (this.K) {
            return;
        }
        this.K = true;
        if ((!S || Looper.getMainLooper() == Looper.myLooper()) && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return k0();
    }

    public void j1(final String str) {
        h hVar = this.f17749a;
        if (hVar == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.s
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    LottieDrawable.this.y0(str, hVar2);
                }
            });
            return;
        }
        p4.g l11 = hVar.l(str);
        if (l11 != null) {
            int i11 = (int) l11.f72425b;
            i1(i11, ((int) l11.f72426c) + i11);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public boolean k0() {
        v4.i iVar = this.f17750b;
        if (iVar == null) {
            return false;
        }
        return iVar.isRunning();
    }

    public void k1(final String str, final String str2, final boolean z10) {
        h hVar = this.f17749a;
        if (hVar == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.c0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    LottieDrawable.this.z0(str, str2, z10, hVar2);
                }
            });
            return;
        }
        p4.g l11 = hVar.l(str);
        if (l11 == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i11 = (int) l11.f72425b;
        p4.g l12 = this.f17749a.l(str2);
        if (l12 != null) {
            i1(i11, (int) (l12.f72425b + (z10 ? 1.0f : 0.0f)));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l0() {
        if (isVisible()) {
            return this.f17750b.isRunning();
        }
        OnVisibleAction onVisibleAction = this.f17754f;
        return onVisibleAction == OnVisibleAction.PLAY || onVisibleAction == OnVisibleAction.RESUME;
    }

    public void l1(final float f11, final float f12) {
        h hVar = this.f17749a;
        if (hVar == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.u
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    LottieDrawable.this.B0(f11, f12, hVar2);
                }
            });
        } else {
            i1((int) v4.k.i(hVar.p(), this.f17749a.f(), f11), (int) v4.k.i(this.f17749a.p(), this.f17749a.f(), f12));
        }
    }

    public boolean m0() {
        return this.f17769u;
    }

    public void m1(final int i11) {
        if (this.f17749a == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.x
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    LottieDrawable.this.C0(i11, hVar);
                }
            });
        } else {
            this.f17750b.D(i11);
        }
    }

    public boolean n0(LottieFeatureFlag lottieFeatureFlag) {
        return this.f17762n.b(lottieFeatureFlag);
    }

    public void n1(final String str) {
        h hVar = this.f17749a;
        if (hVar == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.e0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    LottieDrawable.this.D0(str, hVar2);
                }
            });
            return;
        }
        p4.g l11 = hVar.l(str);
        if (l11 != null) {
            m1((int) l11.f72425b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void o1(final float f11) {
        h hVar = this.f17749a;
        if (hVar == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.i0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar2) {
                    LottieDrawable.this.E0(f11, hVar2);
                }
            });
        } else {
            m1((int) v4.k.i(hVar.p(), this.f17749a.f(), f11));
        }
    }

    public void p1(boolean z10) {
        if (this.f17768t == z10) {
            return;
        }
        this.f17768t = z10;
        com.airbnb.lottie.model.layer.b bVar = this.f17765q;
        if (bVar != null) {
            bVar.K(z10);
        }
    }

    public void q1(boolean z10) {
        this.f17767s = z10;
        h hVar = this.f17749a;
        if (hVar != null) {
            hVar.v(z10);
        }
    }

    public void r1(final float f11) {
        if (this.f17749a == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.j0
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    LottieDrawable.this.F0(f11, hVar);
                }
            });
            return;
        }
        if (d.g()) {
            d.b("Drawable#setProgress");
        }
        this.f17750b.A(this.f17749a.h(f11));
        if (d.g()) {
            d.c("Drawable#setProgress");
        }
    }

    public void s(Animator.AnimatorListener animatorListener) {
        this.f17750b.addListener(animatorListener);
    }

    public void s1(RenderMode renderMode) {
        this.f17771w = renderMode;
        A();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f17766r = i11;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        v4.f.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean isVisible = isVisible();
        boolean visible = super.setVisible(z10, z11);
        if (z10) {
            OnVisibleAction onVisibleAction = this.f17754f;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                H0();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                P0();
            }
        } else if (this.f17750b.isRunning()) {
            G0();
            this.f17754f = OnVisibleAction.RESUME;
        } else if (isVisible) {
            this.f17754f = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        H0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        G();
    }

    public void t(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f17750b.addPauseListener(animatorPauseListener);
    }

    public void t1(int i11) {
        this.f17750b.setRepeatCount(i11);
    }

    public void u(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f17750b.addUpdateListener(animatorUpdateListener);
    }

    public void u1(int i11) {
        this.f17750b.setRepeatMode(i11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void v(final p4.d dVar, final Object obj, final w4.c cVar) {
        com.airbnb.lottie.model.layer.b bVar = this.f17765q;
        if (bVar == null) {
            this.f17755g.add(new a() { // from class: com.airbnb.lottie.y
                @Override // com.airbnb.lottie.LottieDrawable.a
                public final void a(h hVar) {
                    LottieDrawable.this.o0(dVar, obj, cVar, hVar);
                }
            });
            return;
        }
        boolean z10 = true;
        if (dVar == p4.d.f72419c) {
            bVar.b(obj, cVar);
        } else if (dVar.d() != null) {
            dVar.d().b(obj, cVar);
        } else {
            List O0 = O0(dVar);
            for (int i11 = 0; i11 < O0.size(); i11++) {
                ((p4.d) O0.get(i11)).d().b(obj, cVar);
            }
            z10 = true ^ O0.isEmpty();
        }
        if (z10) {
            invalidateSelf();
            if (obj == p0.E) {
                r1(a0());
            }
        }
    }

    public void v1(boolean z10) {
        this.f17753e = z10;
    }

    public void w1(float f11) {
        this.f17750b.E(f11);
    }

    public void x1(Boolean bool) {
        this.f17751c = bool.booleanValue();
    }

    public void y() {
        this.f17755g.clear();
        this.f17750b.cancel();
        if (isVisible()) {
            return;
        }
        this.f17754f = OnVisibleAction.NONE;
    }

    public void y1(t0 t0Var) {
    }

    public void z() {
        if (this.f17750b.isRunning()) {
            this.f17750b.cancel();
            if (!isVisible()) {
                this.f17754f = OnVisibleAction.NONE;
            }
        }
        this.f17749a = null;
        this.f17765q = null;
        this.f17756h = null;
        this.R = -3.4028235E38f;
        this.f17750b.j();
        invalidateSelf();
    }

    public void z1(boolean z10) {
        this.f17750b.F(z10);
    }
}
