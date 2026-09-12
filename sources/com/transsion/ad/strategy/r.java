package com.transsion.ad.strategy;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.transsion.ad.strategy.r;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f42294a = new r();

    /* renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList f42295b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static final Handler f42296c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private static final Runnable f42297d = new Runnable() { // from class: com.transsion.ad.strategy.l
        @Override // java.lang.Runnable
        public final void run() {
            r.m();
        }
    };

    /* loaded from: classes5.dex */
    public interface a {

        /* renamed from: com.transsion.ad.strategy.r$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0598a {
            public static double a(a aVar) {
                return 10.0d;
            }
        }

        double getVisibilityThreshold();

        View getVisibilityView();

        void onVisibilityChanged(boolean z10);
    }

    private r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(a aVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = f42295b;
        if (!copyOnWriteArrayList.contains(aVar)) {
            copyOnWriteArrayList.add(aVar);
        }
        if (copyOnWriteArrayList.size() == 1) {
            f42294a.p();
        }
    }

    private final void i(View view, Function1 function1) {
        if (view != null) {
            if (view.getWindowVisibility() != 0) {
                if (function1 != null) {
                    function1.invoke(Double.valueOf(0.0d));
                    return;
                }
                return;
            }
            if (!view.getGlobalVisibleRect(new Rect()) || !view.isShown()) {
                if (function1 != null) {
                    function1.invoke(Double.valueOf(0.0d));
                    return;
                }
                return;
            }
            double height = r0.height() * r0.width();
            double height2 = view.getHeight() * view.getWidth();
            if (height2 <= 0.0d) {
                if (function1 != null) {
                    function1.invoke(Double.valueOf(0.0d));
                }
            } else {
                double d11 = (height * 100) / height2;
                if (function1 != null) {
                    function1.invoke(Double.valueOf(d11));
                }
            }
        }
    }

    private final void k() {
        f42296c.removeCallbacks(f42297d);
        for (final a aVar : f42295b) {
            f42294a.i(aVar.getVisibilityView(), new Function1() { // from class: com.transsion.ad.strategy.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit l11;
                    l11 = r.l(r.a.this, ((Double) obj).doubleValue());
                    return l11;
                }
            });
        }
        if (f42295b.isEmpty()) {
            return;
        }
        f42296c.postDelayed(f42297d, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(a aVar, double d11) {
        if (d11 >= aVar.getVisibilityThreshold()) {
            aVar.onVisibilityChanged(true);
        } else {
            aVar.onVisibilityChanged(false);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        f42294a.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(a aVar) {
        f42295b.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        f42294a.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
        f42296c.removeCallbacks(f42297d);
    }

    public final void g(final a listener) {
        Intrinsics.h(listener, "listener");
        f42296c.post(new Runnable() { // from class: com.transsion.ad.strategy.n
            @Override // java.lang.Runnable
            public final void run() {
                r.h(r.a.this);
            }
        });
    }

    public final boolean j(View view) {
        if (view == null || view.getWindowVisibility() != 0) {
            return false;
        }
        if (!view.getGlobalVisibleRect(new Rect()) || !view.isShown()) {
            return false;
        }
        double height = view.getHeight() * view.getWidth();
        return height > 0.0d && ((r1.height() * r1.width()) * ((double) 100)) / height > 0.0d;
    }

    public final void n(final a listener) {
        Intrinsics.h(listener, "listener");
        f42296c.post(new Runnable() { // from class: com.transsion.ad.strategy.o
            @Override // java.lang.Runnable
            public final void run() {
                r.o(r.a.this);
            }
        });
    }

    public final void p() {
        f42296c.post(new Runnable() { // from class: com.transsion.ad.strategy.p
            @Override // java.lang.Runnable
            public final void run() {
                r.q();
            }
        });
    }

    public final void r() {
        f42296c.post(new Runnable() { // from class: com.transsion.ad.strategy.q
            @Override // java.lang.Runnable
            public final void run() {
                r.s();
            }
        });
    }
}
