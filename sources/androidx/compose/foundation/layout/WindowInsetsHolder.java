package androidx.compose.foundation.layout;

import android.view.View;
import android.view.WindowInsets;
import androidx.compose.ui.R$id;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class WindowInsetsHolder {
    private static boolean A;

    /* renamed from: x, reason: collision with root package name */
    public static final Companion f2868x = new Companion(null);

    /* renamed from: y, reason: collision with root package name */
    public static final int f2869y = 8;

    /* renamed from: z, reason: collision with root package name */
    private static final WeakHashMap f2870z = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final a f2871a;

    /* renamed from: b, reason: collision with root package name */
    private final a f2872b;

    /* renamed from: c, reason: collision with root package name */
    private final a f2873c;

    /* renamed from: d, reason: collision with root package name */
    private final a f2874d;

    /* renamed from: e, reason: collision with root package name */
    private final a f2875e;

    /* renamed from: f, reason: collision with root package name */
    private final a f2876f;

    /* renamed from: g, reason: collision with root package name */
    private final a f2877g;

    /* renamed from: h, reason: collision with root package name */
    private final a f2878h;

    /* renamed from: i, reason: collision with root package name */
    private final a f2879i;

    /* renamed from: j, reason: collision with root package name */
    private final g0 f2880j;

    /* renamed from: k, reason: collision with root package name */
    private final h0 f2881k;

    /* renamed from: l, reason: collision with root package name */
    private final h0 f2882l;

    /* renamed from: m, reason: collision with root package name */
    private final h0 f2883m;

    /* renamed from: n, reason: collision with root package name */
    private final g0 f2884n;

    /* renamed from: o, reason: collision with root package name */
    private final g0 f2885o;

    /* renamed from: p, reason: collision with root package name */
    private final g0 f2886p;

    /* renamed from: q, reason: collision with root package name */
    private final g0 f2887q;

    /* renamed from: r, reason: collision with root package name */
    private final g0 f2888r;

    /* renamed from: s, reason: collision with root package name */
    private final g0 f2889s;

    /* renamed from: t, reason: collision with root package name */
    private final g0 f2890t;

    /* renamed from: u, reason: collision with root package name */
    private final boolean f2891u;

    /* renamed from: v, reason: collision with root package name */
    private int f2892v;

    /* renamed from: w, reason: collision with root package name */
    private final InsetsListener f2893w;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final WindowInsetsHolder d(View view) {
            WindowInsetsHolder windowInsetsHolder;
            synchronized (WindowInsetsHolder.f2870z) {
                try {
                    WeakHashMap weakHashMap = WindowInsetsHolder.f2870z;
                    Object obj = weakHashMap.get(view);
                    Object obj2 = obj;
                    if (obj == null) {
                        WindowInsetsHolder windowInsetsHolder2 = new WindowInsetsHolder(null, view, false ? 1 : 0);
                        weakHashMap.put(view, windowInsetsHolder2);
                        obj2 = windowInsetsHolder2;
                    }
                    windowInsetsHolder = (WindowInsetsHolder) obj2;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return windowInsetsHolder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final a e(WindowInsetsCompat windowInsetsCompat, int i11, String str) {
            a aVar = new a(i11, str);
            if (windowInsetsCompat != null) {
                aVar.h(windowInsetsCompat, i11);
            }
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final g0 f(WindowInsetsCompat windowInsetsCompat, int i11, String str) {
            z0.c cVar;
            if (windowInsetsCompat == null || (cVar = windowInsetsCompat.getInsetsIgnoringVisibility(i11)) == null) {
                cVar = z0.c.f79247e;
            }
            return j0.a(cVar, str);
        }

        public final WindowInsetsHolder c(androidx.compose.runtime.i iVar, int i11) {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-1366542614, i11, -1, "androidx.compose.foundation.layout.WindowInsetsHolder.Companion.current (WindowInsets.android.kt:626)");
            }
            final View view = (View) iVar.l(AndroidCompositionLocals_androidKt.j());
            final WindowInsetsHolder d11 = d(view);
            boolean A = iVar.A(d11) | iVar.A(view);
            Object y10 = iVar.y();
            if (A || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.foundation.layout.WindowInsetsHolder$Companion$current$1$1

                    /* loaded from: classes.dex */
                    public static final class a implements androidx.compose.runtime.c0 {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ WindowInsetsHolder f2894a;

                        /* renamed from: b, reason: collision with root package name */
                        final /* synthetic */ View f2895b;

                        public a(WindowInsetsHolder windowInsetsHolder, View view) {
                            this.f2894a = windowInsetsHolder;
                            this.f2895b = view;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f2894a.b(this.f2895b);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                        WindowInsetsHolder.this.p(view);
                        return new a(WindowInsetsHolder.this, view);
                    }
                };
                iVar.p(y10);
            }
            androidx.compose.runtime.g0.a(d11, (Function1) y10, iVar, 0);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
            return d11;
        }
    }

    private WindowInsetsHolder(WindowInsetsCompat windowInsetsCompat, View view) {
        DisplayCutoutCompat displayCutout;
        z0.c waterfallInsets;
        Companion companion = f2868x;
        this.f2871a = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.captionBar(), "captionBar");
        a e11 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.displayCutout(), "displayCutout");
        this.f2872b = e11;
        a e12 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.ime(), "ime");
        this.f2873c = e12;
        a e13 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.mandatorySystemGestures(), "mandatorySystemGestures");
        this.f2874d = e13;
        this.f2875e = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.navigationBars(), "navigationBars");
        this.f2876f = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.statusBars(), "statusBars");
        a e14 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.systemBars(), "systemBars");
        this.f2877g = e14;
        a e15 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.systemGestures(), "systemGestures");
        this.f2878h = e15;
        a e16 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.tappableElement(), "tappableElement");
        this.f2879i = e16;
        g0 a11 = j0.a((windowInsetsCompat == null || (displayCutout = windowInsetsCompat.getDisplayCutout()) == null || (waterfallInsets = displayCutout.getWaterfallInsets()) == null) ? z0.c.f79247e : waterfallInsets, "waterfall");
        this.f2880j = a11;
        h0 c11 = i0.c(i0.c(e14, e12), e11);
        this.f2881k = c11;
        h0 c12 = i0.c(i0.c(i0.c(e16, e13), e15), a11);
        this.f2882l = c12;
        this.f2883m = i0.c(c11, c12);
        this.f2884n = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.captionBar(), "captionBarIgnoringVisibility");
        this.f2885o = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.navigationBars(), "navigationBarsIgnoringVisibility");
        this.f2886p = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.statusBars(), "statusBarsIgnoringVisibility");
        this.f2887q = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.systemBars(), "systemBarsIgnoringVisibility");
        this.f2888r = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.tappableElement(), "tappableElementIgnoringVisibility");
        this.f2889s = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.ime(), "imeAnimationTarget");
        this.f2890t = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.ime(), "imeAnimationSource");
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        Object tag = view2 != null ? view2.getTag(R$id.consume_window_insets_tag) : null;
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        this.f2891u = bool != null ? bool.booleanValue() : true;
        this.f2893w = new InsetsListener(this);
    }

    public /* synthetic */ WindowInsetsHolder(WindowInsetsCompat windowInsetsCompat, View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsetsCompat, view);
    }

    public static /* synthetic */ void r(WindowInsetsHolder windowInsetsHolder, WindowInsetsCompat windowInsetsCompat, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        windowInsetsHolder.q(windowInsetsCompat, i11);
    }

    public final void b(View view) {
        int i11 = this.f2892v - 1;
        this.f2892v = i11;
        if (i11 == 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view, null);
            ViewCompat.setWindowInsetsAnimationCallback(view, null);
            view.removeOnAttachStateChangeListener(this.f2893w);
        }
    }

    public final a c() {
        return this.f2871a;
    }

    public final boolean d() {
        return this.f2891u;
    }

    public final a e() {
        return this.f2872b;
    }

    public final a f() {
        return this.f2873c;
    }

    public final a g() {
        return this.f2874d;
    }

    public final a h() {
        return this.f2875e;
    }

    public final h0 i() {
        return this.f2883m;
    }

    public final h0 j() {
        return this.f2881k;
    }

    public final h0 k() {
        return this.f2882l;
    }

    public final a l() {
        return this.f2876f;
    }

    public final a m() {
        return this.f2877g;
    }

    public final a n() {
        return this.f2878h;
    }

    public final g0 o() {
        return this.f2880j;
    }

    public final void p(View view) {
        if (this.f2892v == 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view, this.f2893w);
            if (view.isAttachedToWindow()) {
                view.requestApplyInsets();
            }
            view.addOnAttachStateChangeListener(this.f2893w);
            ViewCompat.setWindowInsetsAnimationCallback(view, this.f2893w);
        }
        this.f2892v++;
    }

    public final void q(WindowInsetsCompat windowInsetsCompat, int i11) {
        if (A) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            Intrinsics.e(windowInsets);
            windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        }
        this.f2871a.h(windowInsetsCompat, i11);
        this.f2873c.h(windowInsetsCompat, i11);
        this.f2872b.h(windowInsetsCompat, i11);
        this.f2875e.h(windowInsetsCompat, i11);
        this.f2876f.h(windowInsetsCompat, i11);
        this.f2877g.h(windowInsetsCompat, i11);
        this.f2878h.h(windowInsetsCompat, i11);
        this.f2879i.h(windowInsetsCompat, i11);
        this.f2874d.h(windowInsetsCompat, i11);
        if (i11 == 0) {
            this.f2884n.f(j0.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.captionBar())));
            this.f2885o.f(j0.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars())));
            this.f2886p.f(j0.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars())));
            this.f2887q.f(j0.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars())));
            this.f2888r.f(j0.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement())));
            DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
            if (displayCutout != null) {
                this.f2880j.f(j0.b(displayCutout.getWaterfallInsets()));
            }
        }
        androidx.compose.runtime.snapshots.j.f4079e.n();
    }

    public final void s(WindowInsetsCompat windowInsetsCompat) {
        this.f2890t.f(j0.b(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime())));
    }

    public final void t(WindowInsetsCompat windowInsetsCompat) {
        this.f2889s.f(j0.b(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime())));
    }
}
