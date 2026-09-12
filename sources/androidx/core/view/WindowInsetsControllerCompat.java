package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.core.view.WindowInsetsControllerCompat;
import org.mvel2.ast.ASTNode;

/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final g mImpl;

    /* loaded from: classes.dex */
    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(WindowInsetsControllerCompat windowInsetsControllerCompat, int i11);
    }

    /* loaded from: classes.dex */
    private static class a extends g {

        /* renamed from: a, reason: collision with root package name */
        protected final Window f8447a;

        /* renamed from: b, reason: collision with root package name */
        private final SoftwareKeyboardControllerCompat f8448b;

        a(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f8447a = window;
            this.f8448b = softwareKeyboardControllerCompat;
        }

        private void l(int i11) {
            if (i11 == 1) {
                m(4);
            } else if (i11 == 2) {
                m(2);
            } else {
                if (i11 != 8) {
                    return;
                }
                this.f8448b.hide();
            }
        }

        private void o(int i11) {
            if (i11 == 1) {
                p(4);
                q(1024);
            } else if (i11 == 2) {
                p(2);
            } else {
                if (i11 != 8) {
                    return;
                }
                this.f8448b.show();
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void b(int i11, long j11, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        int c() {
            Object tag = this.f8447a.getDecorView().getTag(356039078);
            if (tag != null) {
                return ((Integer) tag).intValue();
            }
            return 1;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void d(int i11) {
            for (int i12 = 1; i12 <= 512; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    l(i12);
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void g(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void j(int i11) {
            this.f8447a.getDecorView().setTag(356039078, Integer.valueOf(i11));
            if (i11 == 0) {
                p(6144);
                return;
            }
            if (i11 == 1) {
                p(4096);
                m(2048);
            } else {
                if (i11 != 2) {
                    return;
                }
                p(2048);
                m(4096);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void k(int i11) {
            for (int i12 = 1; i12 <= 512; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    o(i12);
                }
            }
        }

        protected void m(int i11) {
            View decorView = this.f8447a.getDecorView();
            decorView.setSystemUiVisibility(i11 | decorView.getSystemUiVisibility());
        }

        protected void n(int i11) {
            this.f8447a.addFlags(i11);
        }

        protected void p(int i11) {
            View decorView = this.f8447a.getDecorView();
            decorView.setSystemUiVisibility((~i11) & decorView.getSystemUiVisibility());
        }

        protected void q(int i11) {
            this.f8447a.clearFlags(i11);
        }
    }

    /* loaded from: classes.dex */
    private static class b extends a {
        b(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        public boolean f() {
            return (this.f8447a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        public void i(boolean z10) {
            if (!z10) {
                p(8192);
                return;
            }
            q(67108864);
            n(Integer.MIN_VALUE);
            m(8192);
        }
    }

    /* loaded from: classes.dex */
    private static class c extends b {
        c(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        public boolean e() {
            return (this.f8447a.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        public void h(boolean z10) {
            if (!z10) {
                p(16);
                return;
            }
            q(ASTNode.NOJIT);
            n(Integer.MIN_VALUE);
            m(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        final WindowInsetsControllerCompat f8449a;

        /* renamed from: b, reason: collision with root package name */
        final WindowInsetsController f8450b;

        /* renamed from: c, reason: collision with root package name */
        final SoftwareKeyboardControllerCompat f8451c;

        /* renamed from: d, reason: collision with root package name */
        private final androidx.collection.x0 f8452d;

        /* renamed from: e, reason: collision with root package name */
        protected Window f8453e;

        /* loaded from: classes.dex */
        class a implements WindowInsetsAnimationControlListener {

            /* renamed from: a, reason: collision with root package name */
            private WindowInsetsAnimationControllerCompat f8454a = null;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ WindowInsetsAnimationControlListenerCompat f8455b;

            a(WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
                this.f8455b = windowInsetsAnimationControlListenerCompat;
            }

            public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f8455b.onCancelled(windowInsetsAnimationController == null ? null : this.f8454a);
            }

            public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f8455b.onFinished(this.f8454a);
            }

            public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i11) {
                WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                this.f8454a = windowInsetsAnimationControllerCompat;
                this.f8455b.onReady(windowInsetsAnimationControllerCompat, i11);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        d(android.view.Window r2, androidx.core.view.WindowInsetsControllerCompat r3, androidx.core.view.SoftwareKeyboardControllerCompat r4) {
            /*
                r1 = this;
                android.view.WindowInsetsController r0 = androidx.core.view.t2.a(r2)
                r1.<init>(r0, r3, r4)
                r1.f8453e = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.WindowInsetsControllerCompat.d.<init>(android.view.Window, androidx.core.view.WindowInsetsControllerCompat, androidx.core.view.SoftwareKeyboardControllerCompat):void");
        }

        d(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f8452d = new androidx.collection.x0();
            this.f8450b = windowInsetsController;
            this.f8449a = windowInsetsControllerCompat;
            this.f8451c = softwareKeyboardControllerCompat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(OnControllableInsetsChangedListener onControllableInsetsChangedListener, WindowInsetsController windowInsetsController, int i11) {
            if (this.f8450b == windowInsetsController) {
                onControllableInsetsChangedListener.onControllableInsetsChanged(this.f8449a, i11);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void a(final OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (this.f8452d.containsKey(onControllableInsetsChangedListener)) {
                return;
            }
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener2 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.y2
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i11) {
                    WindowInsetsControllerCompat.d.this.m(onControllableInsetsChangedListener, windowInsetsController, i11);
                }
            };
            this.f8452d.put(onControllableInsetsChangedListener, onControllableInsetsChangedListener2);
            this.f8450b.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void b(int i11, long j11, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.f8450b.controlWindowInsetsAnimation(i11, j11, interpolator, cancellationSignal, new a(windowInsetsAnimationControlListenerCompat));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        int c() {
            int systemBarsBehavior;
            Window window = this.f8453e;
            if (window == null) {
                systemBarsBehavior = this.f8450b.getSystemBarsBehavior();
                return systemBarsBehavior;
            }
            Object tag = window.getDecorView().getTag(356039078);
            if (tag != null) {
                return ((Integer) tag).intValue();
            }
            return 1;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void d(int i11) {
            if ((i11 & 8) != 0) {
                this.f8451c.hide();
            }
            this.f8450b.hide(i11 & (-9));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        public boolean e() {
            int systemBarsAppearance;
            this.f8450b.setSystemBarsAppearance(0, 0);
            systemBarsAppearance = this.f8450b.getSystemBarsAppearance();
            return (systemBarsAppearance & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        public boolean f() {
            int systemBarsAppearance;
            this.f8450b.setSystemBarsAppearance(0, 0);
            systemBarsAppearance = this.f8450b.getSystemBarsAppearance();
            return (systemBarsAppearance & 8) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void g(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener a11 = w2.a(this.f8452d.remove(onControllableInsetsChangedListener));
            if (a11 != null) {
                this.f8450b.removeOnControllableInsetsChangedListener(a11);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        public void h(boolean z10) {
            if (z10) {
                if (this.f8453e != null) {
                    n(16);
                }
                this.f8450b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f8453e != null) {
                    o(16);
                }
                this.f8450b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        public void i(boolean z10) {
            if (z10) {
                if (this.f8453e != null) {
                    n(8192);
                }
                this.f8450b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f8453e != null) {
                    o(8192);
                }
                this.f8450b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void j(int i11) {
            Window window = this.f8453e;
            if (window == null) {
                this.f8450b.setSystemBarsBehavior(i11);
                return;
            }
            window.getDecorView().setTag(356039078, Integer.valueOf(i11));
            if (i11 == 0) {
                o(6144);
                return;
            }
            if (i11 == 1) {
                o(4096);
                n(2048);
            } else {
                if (i11 != 2) {
                    return;
                }
                o(2048);
                n(4096);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.g
        void k(int i11) {
            if ((i11 & 8) != 0) {
                this.f8451c.show();
            }
            this.f8450b.show(i11 & (-9));
        }

        protected void n(int i11) {
            View decorView = this.f8453e.getDecorView();
            decorView.setSystemUiVisibility(i11 | decorView.getSystemUiVisibility());
        }

        protected void o(int i11) {
            View decorView = this.f8453e.getDecorView();
            decorView.setSystemUiVisibility((~i11) & decorView.getSystemUiVisibility());
        }
    }

    /* loaded from: classes.dex */
    private static class e extends d {
        e(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
        }

        e(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(windowInsetsController, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.d, androidx.core.view.WindowInsetsControllerCompat.g
        int c() {
            int systemBarsBehavior;
            systemBarsBehavior = this.f8450b.getSystemBarsBehavior();
            return systemBarsBehavior;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.d, androidx.core.view.WindowInsetsControllerCompat.g
        void j(int i11) {
            this.f8450b.setSystemBarsBehavior(i11);
        }
    }

    /* loaded from: classes.dex */
    private static class f extends e {
        f(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
        }

        f(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(windowInsetsController, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.d, androidx.core.view.WindowInsetsControllerCompat.g
        public boolean e() {
            int systemBarsAppearance;
            systemBarsAppearance = this.f8450b.getSystemBarsAppearance();
            return (systemBarsAppearance & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.d, androidx.core.view.WindowInsetsControllerCompat.g
        public boolean f() {
            int systemBarsAppearance;
            systemBarsAppearance = this.f8450b.getSystemBarsAppearance();
            return (systemBarsAppearance & 8) != 0;
        }
    }

    /* loaded from: classes.dex */
    private static class g {
        g() {
        }

        abstract void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener);

        abstract void b(int i11, long j11, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat);

        abstract int c();

        abstract void d(int i11);

        public boolean e() {
            return false;
        }

        public abstract boolean f();

        abstract void g(OnControllableInsetsChangedListener onControllableInsetsChangedListener);

        public void h(boolean z10) {
        }

        public abstract void i(boolean z10);

        abstract void j(int i11);

        abstract void k(int i11);
    }

    public WindowInsetsControllerCompat(Window window, View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 35) {
            this.mImpl = new f(window, this, softwareKeyboardControllerCompat);
            return;
        }
        if (i11 >= 30) {
            this.mImpl = new d(window, this, softwareKeyboardControllerCompat);
        } else if (i11 >= 26) {
            this.mImpl = new c(window, softwareKeyboardControllerCompat);
        } else {
            this.mImpl = new b(window, softwareKeyboardControllerCompat);
        }
    }

    @Deprecated
    private WindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.mImpl = new f(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
        } else {
            this.mImpl = new d(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
        }
    }

    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.a(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i11, long j11, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.b(i11, j11, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    @SuppressLint({"WrongConstant"})
    public int getSystemBarsBehavior() {
        return this.mImpl.c();
    }

    public void hide(int i11) {
        this.mImpl.d(i11);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.e();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.f();
    }

    public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.g(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z10) {
        this.mImpl.h(z10);
    }

    public void setAppearanceLightStatusBars(boolean z10) {
        this.mImpl.i(z10);
    }

    public void setSystemBarsBehavior(int i11) {
        this.mImpl.j(i11);
    }

    public void show(int i11) {
        this.mImpl.k(i11);
    }
}
