package eo;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.activity.ComponentActivity;
import androidx.view.Lifecycle;
import androidx.view.r;
import androidx.view.u;
import com.blankj.utilcode.util.y;
import com.tn.lib.widget.R$dimen;
import com.transsion.player.view.R$id;
import com.transsion.player.view.R$layout;
import com.transsion.player.view.R$mipmap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class m implements n {

    /* renamed from: b, reason: collision with root package name */
    private final Context f62076b;

    /* renamed from: c, reason: collision with root package name */
    private final ViewGroup f62077c;

    /* renamed from: d, reason: collision with root package name */
    private final String f62078d;

    /* renamed from: e, reason: collision with root package name */
    private com.transsion.player.orplayer.g f62079e;

    /* renamed from: f, reason: collision with root package name */
    private final View f62080f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f62081g;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f62082h;

    /* renamed from: i, reason: collision with root package name */
    private final Lazy f62083i;

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f62084j;

    /* renamed from: k, reason: collision with root package name */
    private float f62085k;

    /* renamed from: l, reason: collision with root package name */
    private Function2 f62086l;

    /* renamed from: m, reason: collision with root package name */
    private float f62087m;

    /* renamed from: n, reason: collision with root package name */
    private float f62088n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f62089o;

    /* renamed from: p, reason: collision with root package name */
    private final Runnable f62090p;

    /* loaded from: classes6.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v11) {
            Intrinsics.h(v11, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v11) {
            Intrinsics.h(v11, "v");
            int c11 = m.this.c();
            if (c11 > 100) {
                hj.i iVar = hj.i.f64628a;
                iVar.s(iVar.i(), "volume_max", MapsKt.f(new Pair("volume", String.valueOf(c11))));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements r {
        b() {
        }

        @Override // androidx.view.r
        public void onStateChanged(u source, Lifecycle.Event event) {
            Intrinsics.h(source, "source");
            Intrinsics.h(event, "event");
            if (event == Lifecycle.Event.ON_RESUME) {
                ViewGroup viewGroup = m.this.f62077c;
                if (viewGroup != null) {
                    viewGroup.setFocusableInTouchMode(true);
                    viewGroup.requestFocus();
                }
                c.f62046a.d();
            }
        }
    }

    public m(Context context, ViewGroup viewGroup) {
        Intrinsics.h(context, "context");
        this.f62076b = context;
        this.f62077c = viewGroup;
        this.f62078d = "VideoBrightnessVolume";
        this.f62080f = LayoutInflater.from(context).inflate(R$layout.orplayer_layout_brightness_volume, viewGroup, false);
        this.f62081g = LazyKt.b(new Function0() { // from class: eo.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ImageView B;
                B = m.B(m.this);
                return B;
            }
        });
        this.f62082h = LazyKt.b(new Function0() { // from class: eo.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProgressBar q11;
                q11 = m.q(m.this);
                return q11;
            }
        });
        this.f62083i = LazyKt.b(new Function0() { // from class: eo.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProgressBar D;
                D = m.D(m.this);
                return D;
            }
        });
        this.f62084j = LazyKt.b(new Function0() { // from class: eo.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                View F;
                F = m.F(m.this);
                return F;
            }
        });
        if (viewGroup == null) {
            Log.e("VideoBrightnessVolume", " error: rootView is null !!!");
        }
        this.f62085k = (y.c() / 3.0f) / 25.0f;
        if (viewGroup != null) {
            viewGroup.setOnKeyListener(new View.OnKeyListener() { // from class: eo.k
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                    boolean o11;
                    o11 = m.o(m.this, view, i11, keyEvent);
                    return o11;
                }
            });
        }
        if (viewGroup != null) {
            viewGroup.addOnAttachStateChangeListener(new a());
        }
        C();
        this.f62090p = new Runnable() { // from class: eo.l
            @Override // java.lang.Runnable
            public final void run() {
                m.r(m.this);
            }
        };
    }

    private final void A() {
        ViewGroup viewGroup = this.f62077c;
        if (viewGroup != null) {
            viewGroup.removeCallbacks(this.f62090p);
            View progressRootView = this.f62080f;
            Intrinsics.g(progressRootView, "progressRootView");
            progressRootView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageView B(m mVar) {
        return (ImageView) mVar.f62080f.findViewById(R$id.bvIV);
    }

    private final void C() {
        Context context = this.f62076b;
        if (context instanceof ComponentActivity) {
            ((ComponentActivity) context).getLifecycle().a(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProgressBar D(m mVar) {
        return (ProgressBar) mVar.f62080f.findViewById(R$id.secProgress);
    }

    private final void E(boolean z10, int i11) {
        if (i11 < 0) {
            return;
        }
        x().setImageResource(i11 == 0 ? z10 ? R$mipmap.ic_volume_0 : R$mipmap.ic_brightness_33 : i11 <= 33 ? z10 ? R$mipmap.ic_volume_33 : R$mipmap.ic_brightness_33 : i11 <= 66 ? z10 ? R$mipmap.ic_volume_66 : R$mipmap.ic_brightness_66 : i11 <= 100 ? z10 ? R$mipmap.ic_volume_66 : R$mipmap.ic_brightness_100 : z10 ? R$mipmap.ic_volume_100 : R$mipmap.ic_brightness_100);
        v().setProgress(i11);
        int i12 = RangesKt.i(RangesKt.f(i11 - 100, 0), 100);
        y().setVisibility(i12 > 0 ? 0 : 8);
        y().setProgress(i12);
        f(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View F(m mVar) {
        return mVar.f62080f.findViewById(R$id.tipsLL);
    }

    private final void G(int i11) {
        com.transsion.player.orplayer.g gVar;
        int c11 = c();
        int k11 = c.f62046a.k(i11);
        if (k11 <= 100 && (gVar = this.f62079e) != null) {
            gVar.setVolume(1.0f);
        }
        Function2 function2 = this.f62086l;
        if (function2 != null) {
            function2.invoke(Boolean.TRUE, Integer.valueOf(k11));
        }
        E(true, k11);
        s(k11, c11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(m mVar, View view, int i11, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i11 == 24) {
            int c11 = mVar.c();
            mVar.G((91 > c11 || c11 >= 100) ? 10 : 100 - c11);
        } else {
            if (i11 != 25) {
                return false;
            }
            mVar.G(-10);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProgressBar q(m mVar) {
        return (ProgressBar) mVar.f62080f.findViewById(R$id.bvProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(m mVar) {
        mVar.A();
    }

    private final void s(int i11, int i12) {
        com.transsion.player.orplayer.g gVar;
        if (i11 > 100 && (gVar = this.f62079e) != null) {
            gVar.setVolume(i11 / 100.0f);
        }
        t(i11, i12);
    }

    private final void t(int i11, int i12) {
        if (i12 >= 100 || i11 != 100) {
            return;
        }
        z().setVisibility(0);
        z().postDelayed(new Runnable() { // from class: eo.f
            @Override // java.lang.Runnable
            public final void run() {
                m.u(m.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(m mVar) {
        mVar.z().setVisibility(8);
    }

    private final ProgressBar v() {
        Object value = this.f62082h.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (ProgressBar) value;
    }

    private final ImageView x() {
        Object value = this.f62081g.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (ImageView) value;
    }

    private final ProgressBar y() {
        Object value = this.f62083i.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (ProgressBar) value;
    }

    private final View z() {
        Object value = this.f62084j.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (View) value;
    }

    @Override // eo.n
    public void a(float f11, float f12) {
        Context context = this.f62076b;
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        Window window = ((Activity) context).getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        float f13 = 1.0f;
        float f14 = f11 + (f12 * 1.0f);
        if (f14 <= 0.0f) {
            f13 = 0.0f;
        } else if (f14 < 1.0f) {
            f13 = f14;
        }
        attributes.screenBrightness = f13;
        window.setAttributes(attributes);
        Function2 function2 = this.f62086l;
        if (function2 != null) {
            function2.invoke(Boolean.FALSE, Integer.valueOf((int) (100 * f13)));
        }
        E(false, (int) (f13 * 100));
    }

    @Override // eo.n
    public float b() {
        Context context = this.f62076b;
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        Window window = ((Activity) context).getWindow();
        if (window == null) {
            return 0.0f;
        }
        float f11 = window.getAttributes().screenBrightness;
        return f11 == -1.0f ? w() : f11;
    }

    @Override // eo.n
    public int c() {
        return c.f62046a.e();
    }

    @Override // eo.n
    public void d(float f11, float f12, int i11) {
        if (this.f62087m != f11) {
            this.f62088n = f11;
            this.f62087m = f11;
        }
        if (i11 <= 0) {
            i11 = y.c();
        }
        int i12 = (int) ((((this.f62088n - f12) * 80.0f) / i11) + 0.5f);
        if (Math.abs(i12) == 0) {
            return;
        }
        this.f62088n = f12;
        G(i12);
    }

    @Override // eo.n
    public void e(com.transsion.player.orplayer.g gVar) {
        this.f62079e = gVar;
    }

    @Override // eo.n
    public void f(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("show:");
        sb2.append(z10);
        if (this.f62077c == null) {
            return;
        }
        if (!z10) {
            A();
            return;
        }
        View progressRootView = this.f62080f;
        Intrinsics.g(progressRootView, "progressRootView");
        progressRootView.setVisibility(0);
        try {
            Result.Companion companion = Result.INSTANCE;
            if (!Intrinsics.c(this.f62077c.getChildAt(r4.getChildCount() - 1), this.f62080f)) {
                this.f62077c.removeView(this.f62080f);
            }
            ViewGroup viewGroup = this.f62077c;
            View progressRootView2 = this.f62080f;
            Intrinsics.g(progressRootView2, "progressRootView");
            if (viewGroup.indexOfChild(progressRootView2) == -1) {
                this.f62077c.addView(this.f62080f);
            }
            if (this.f62089o) {
                ViewGroup.LayoutParams layoutParams = this.f62080f.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = com.blankj.utilcode.util.d.c() + ((int) this.f62076b.getResources().getDimension(R$dimen.toolbar_height));
                    this.f62080f.setLayoutParams(marginLayoutParams);
                }
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        this.f62077c.removeCallbacks(this.f62090p);
        this.f62077c.postDelayed(this.f62090p, 500L);
    }

    @Override // eo.n
    public void g() {
        this.f62089o = true;
    }

    public float w() {
        Context context = this.f62076b;
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        try {
            return (Settings.System.getFloat(((Activity) context).getContentResolver(), "screen_brightness") * 1.0f) / 255;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }
}
