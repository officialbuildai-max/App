package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final l mImpl;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final e mImpl;

        public Builder() {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 34) {
                this.mImpl = new d();
                return;
            }
            if (i11 >= 30) {
                this.mImpl = new c();
            } else if (i11 >= 29) {
                this.mImpl = new b();
            } else {
                this.mImpl = new a();
            }
        }

        public Builder(WindowInsetsCompat windowInsetsCompat) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 34) {
                this.mImpl = new d(windowInsetsCompat);
                return;
            }
            if (i11 >= 30) {
                this.mImpl = new c(windowInsetsCompat);
            } else if (i11 >= 29) {
                this.mImpl = new b(windowInsetsCompat);
            } else {
                this.mImpl = new a(windowInsetsCompat);
            }
        }

        public WindowInsetsCompat build() {
            return this.mImpl.b();
        }

        public Builder setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.c(displayCutoutCompat);
            return this;
        }

        public Builder setInsets(int i11, z0.c cVar) {
            this.mImpl.d(i11, cVar);
            return this;
        }

        public Builder setInsetsIgnoringVisibility(int i11, z0.c cVar) {
            this.mImpl.e(i11, cVar);
            return this;
        }

        @Deprecated
        public Builder setMandatorySystemGestureInsets(z0.c cVar) {
            this.mImpl.f(cVar);
            return this;
        }

        @Deprecated
        public Builder setStableInsets(z0.c cVar) {
            this.mImpl.g(cVar);
            return this;
        }

        @Deprecated
        public Builder setSystemGestureInsets(z0.c cVar) {
            this.mImpl.h(cVar);
            return this;
        }

        @Deprecated
        public Builder setSystemWindowInsets(z0.c cVar) {
            this.mImpl.i(cVar);
            return this;
        }

        @Deprecated
        public Builder setTappableElementInsets(z0.c cVar) {
            this.mImpl.j(cVar);
            return this;
        }

        public Builder setVisible(int i11, boolean z10) {
            this.mImpl.k(i11, z10);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class Side {
        public static final int BOTTOM = 8;
        public static final int LEFT = 1;
        public static final int RIGHT = 4;
        public static final int TOP = 2;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface InsetsSide {
        }

        private Side() {
        }

        public static int all() {
            return 15;
        }
    }

    /* loaded from: classes.dex */
    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 512;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 10;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int SYSTEM_OVERLAYS = 512;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface InsetsType {
        }

        private Type() {
        }

        @SuppressLint({"WrongConstant"})
        static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        static int indexOf(int i11) {
            if (i11 == 1) {
                return 0;
            }
            if (i11 == 2) {
                return 1;
            }
            if (i11 == 4) {
                return 2;
            }
            if (i11 == 8) {
                return 3;
            }
            if (i11 == 16) {
                return 4;
            }
            if (i11 == 32) {
                return 5;
            }
            if (i11 == 64) {
                return 6;
            }
            if (i11 == 128) {
                return 7;
            }
            if (i11 == 256) {
                return 8;
            }
            if (i11 == 512) {
                return 9;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i11);
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 519;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int systemOverlays() {
            return 512;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    /* loaded from: classes.dex */
    private static class a extends e {

        /* renamed from: e, reason: collision with root package name */
        private static Field f8419e;

        /* renamed from: f, reason: collision with root package name */
        private static boolean f8420f;

        /* renamed from: g, reason: collision with root package name */
        private static Constructor f8421g;

        /* renamed from: h, reason: collision with root package name */
        private static boolean f8422h;

        /* renamed from: c, reason: collision with root package name */
        private WindowInsets f8423c;

        /* renamed from: d, reason: collision with root package name */
        private z0.c f8424d;

        a() {
            this.f8423c = l();
        }

        a(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f8423c = windowInsetsCompat.toWindowInsets();
        }

        private static WindowInsets l() {
            if (!f8420f) {
                try {
                    f8419e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f8420f = true;
            }
            Field field = f8419e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f8422h) {
                try {
                    f8421g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f8422h = true;
            }
            Constructor constructor = f8421g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.f8423c);
            windowInsetsCompat.setOverriddenInsets(this.f8427b);
            windowInsetsCompat.setStableInsets(this.f8424d);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void g(z0.c cVar) {
            this.f8424d = cVar;
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void i(z0.c cVar) {
            WindowInsets windowInsets = this.f8423c;
            if (windowInsets != null) {
                this.f8423c = windowInsets.replaceSystemWindowInsets(cVar.f79248a, cVar.f79249b, cVar.f79250c, cVar.f79251d);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class b extends e {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f8425c;

        b() {
            this.f8425c = e1.c.a();
        }

        b(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            this.f8425c = windowInsets != null ? v1.a(windowInsets) : e1.c.a();
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        WindowInsetsCompat b() {
            WindowInsets build;
            a();
            build = this.f8425c.build();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(build);
            windowInsetsCompat.setOverriddenInsets(this.f8427b);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void c(DisplayCutoutCompat displayCutoutCompat) {
            this.f8425c.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void f(z0.c cVar) {
            this.f8425c.setMandatorySystemGestureInsets(cVar.g());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void g(z0.c cVar) {
            this.f8425c.setStableInsets(cVar.g());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void h(z0.c cVar) {
            this.f8425c.setSystemGestureInsets(cVar.g());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void i(z0.c cVar) {
            this.f8425c.setSystemWindowInsets(cVar.g());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void j(z0.c cVar) {
            this.f8425c.setTappableElementInsets(cVar.g());
        }
    }

    /* loaded from: classes.dex */
    private static class c extends b {
        c() {
        }

        c(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void d(int i11, z0.c cVar) {
            this.f8425c.setInsets(m.a(i11), cVar.g());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void e(int i11, z0.c cVar) {
            this.f8425c.setInsetsIgnoringVisibility(m.a(i11), cVar.g());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        void k(int i11, boolean z10) {
            this.f8425c.setVisible(m.a(i11), z10);
        }
    }

    /* loaded from: classes.dex */
    private static class d extends c {
        d() {
        }

        d(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }

        @Override // androidx.core.view.WindowInsetsCompat.c, androidx.core.view.WindowInsetsCompat.e
        void d(int i11, z0.c cVar) {
            this.f8425c.setInsets(n.a(i11), cVar.g());
        }

        @Override // androidx.core.view.WindowInsetsCompat.c, androidx.core.view.WindowInsetsCompat.e
        void e(int i11, z0.c cVar) {
            this.f8425c.setInsetsIgnoringVisibility(n.a(i11), cVar.g());
        }

        @Override // androidx.core.view.WindowInsetsCompat.c, androidx.core.view.WindowInsetsCompat.e
        void k(int i11, boolean z10) {
            this.f8425c.setVisible(n.a(i11), z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private final WindowInsetsCompat f8426a;

        /* renamed from: b, reason: collision with root package name */
        z0.c[] f8427b;

        e() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        e(WindowInsetsCompat windowInsetsCompat) {
            this.f8426a = windowInsetsCompat;
        }

        protected final void a() {
            z0.c[] cVarArr = this.f8427b;
            if (cVarArr != null) {
                z0.c cVar = cVarArr[Type.indexOf(1)];
                z0.c cVar2 = this.f8427b[Type.indexOf(2)];
                if (cVar2 == null) {
                    cVar2 = this.f8426a.getInsets(2);
                }
                if (cVar == null) {
                    cVar = this.f8426a.getInsets(1);
                }
                i(z0.c.a(cVar, cVar2));
                z0.c cVar3 = this.f8427b[Type.indexOf(16)];
                if (cVar3 != null) {
                    h(cVar3);
                }
                z0.c cVar4 = this.f8427b[Type.indexOf(32)];
                if (cVar4 != null) {
                    f(cVar4);
                }
                z0.c cVar5 = this.f8427b[Type.indexOf(64)];
                if (cVar5 != null) {
                    j(cVar5);
                }
            }
        }

        abstract WindowInsetsCompat b();

        void c(DisplayCutoutCompat displayCutoutCompat) {
        }

        void d(int i11, z0.c cVar) {
            if (this.f8427b == null) {
                this.f8427b = new z0.c[10];
            }
            for (int i12 = 1; i12 <= 512; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    this.f8427b[Type.indexOf(i12)] = cVar;
                }
            }
        }

        void e(int i11, z0.c cVar) {
            if (i11 == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        void f(z0.c cVar) {
        }

        abstract void g(z0.c cVar);

        void h(z0.c cVar) {
        }

        abstract void i(z0.c cVar);

        void j(z0.c cVar) {
        }

        void k(int i11, boolean z10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f extends l {

        /* renamed from: i, reason: collision with root package name */
        private static boolean f8428i;

        /* renamed from: j, reason: collision with root package name */
        private static Method f8429j;

        /* renamed from: k, reason: collision with root package name */
        private static Class f8430k;

        /* renamed from: l, reason: collision with root package name */
        private static Field f8431l;

        /* renamed from: m, reason: collision with root package name */
        private static Field f8432m;

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets f8433c;

        /* renamed from: d, reason: collision with root package name */
        private z0.c[] f8434d;

        /* renamed from: e, reason: collision with root package name */
        private z0.c f8435e;

        /* renamed from: f, reason: collision with root package name */
        private WindowInsetsCompat f8436f;

        /* renamed from: g, reason: collision with root package name */
        z0.c f8437g;

        /* renamed from: h, reason: collision with root package name */
        int f8438h;

        f(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f8435e = null;
            this.f8433c = windowInsets;
        }

        f(WindowInsetsCompat windowInsetsCompat, f fVar) {
            this(windowInsetsCompat, new WindowInsets(fVar.f8433c));
        }

        @SuppressLint({"PrivateApi"})
        private static void B() {
            try {
                f8429j = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f8430k = cls;
                f8431l = cls.getDeclaredField("mVisibleInsets");
                f8432m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f8431l.setAccessible(true);
                f8432m.setAccessible(true);
            } catch (ReflectiveOperationException e11) {
                Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e11.getMessage(), e11);
            }
            f8428i = true;
        }

        static boolean C(int i11, int i12) {
            return (i11 & 6) == (i12 & 6);
        }

        @SuppressLint({"WrongConstant"})
        private z0.c w(int i11, boolean z10) {
            z0.c cVar = z0.c.f79247e;
            for (int i12 = 1; i12 <= 512; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    cVar = z0.c.a(cVar, x(i12, z10));
                }
            }
            return cVar;
        }

        private z0.c y() {
            WindowInsetsCompat windowInsetsCompat = this.f8436f;
            return windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : z0.c.f79247e;
        }

        private z0.c z(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f8428i) {
                B();
            }
            Method method = f8429j;
            if (method != null && f8430k != null && f8431l != null) {
                try {
                    Object invoke = method.invoke(view, null);
                    if (invoke == null) {
                        Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f8431l.get(f8432m.get(invoke));
                    if (rect != null) {
                        return z0.c.d(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e11) {
                    Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e11.getMessage(), e11);
                }
            }
            return null;
        }

        protected boolean A(int i11) {
            if (i11 != 1 && i11 != 2) {
                if (i11 == 4) {
                    return false;
                }
                if (i11 != 8 && i11 != 128) {
                    return true;
                }
            }
            return !x(i11, false).equals(z0.c.f79247e);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        void d(View view) {
            z0.c z10 = z(view);
            if (z10 == null) {
                z10 = z0.c.f79247e;
            }
            s(z10);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        void e(WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.setRootWindowInsets(this.f8436f);
            windowInsetsCompat.setRootViewData(this.f8437g);
            windowInsetsCompat.setSystemUiVisibility(this.f8438h);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            f fVar = (f) obj;
            return Objects.equals(this.f8437g, fVar.f8437g) && C(this.f8438h, fVar.f8438h);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        public z0.c g(int i11) {
            return w(i11, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        public z0.c h(int i11) {
            return w(i11, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        final z0.c l() {
            if (this.f8435e == null) {
                this.f8435e = z0.c.c(this.f8433c.getSystemWindowInsetLeft(), this.f8433c.getSystemWindowInsetTop(), this.f8433c.getSystemWindowInsetRight(), this.f8433c.getSystemWindowInsetBottom());
            }
            return this.f8435e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        WindowInsetsCompat n(int i11, int i12, int i13, int i14) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.f8433c));
            builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(l(), i11, i12, i13, i14));
            builder.setStableInsets(WindowInsetsCompat.insetInsets(j(), i11, i12, i13, i14));
            return builder.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        boolean p() {
            return this.f8433c.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        @SuppressLint({"WrongConstant"})
        boolean q(int i11) {
            for (int i12 = 1; i12 <= 512; i12 <<= 1) {
                if ((i11 & i12) != 0 && !A(i12)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        public void r(z0.c[] cVarArr) {
            this.f8434d = cVarArr;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        void s(z0.c cVar) {
            this.f8437g = cVar;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        void t(WindowInsetsCompat windowInsetsCompat) {
            this.f8436f = windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        void v(int i11) {
            this.f8438h = i11;
        }

        protected z0.c x(int i11, boolean z10) {
            z0.c stableInsets;
            int i12;
            if (i11 == 1) {
                return z10 ? z0.c.c(0, Math.max(y().f79249b, l().f79249b), 0, 0) : (this.f8438h & 4) != 0 ? z0.c.f79247e : z0.c.c(0, l().f79249b, 0, 0);
            }
            if (i11 == 2) {
                if (z10) {
                    z0.c y10 = y();
                    z0.c j11 = j();
                    return z0.c.c(Math.max(y10.f79248a, j11.f79248a), 0, Math.max(y10.f79250c, j11.f79250c), Math.max(y10.f79251d, j11.f79251d));
                }
                if ((this.f8438h & 2) != 0) {
                    return z0.c.f79247e;
                }
                z0.c l11 = l();
                WindowInsetsCompat windowInsetsCompat = this.f8436f;
                stableInsets = windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : null;
                int i13 = l11.f79251d;
                if (stableInsets != null) {
                    i13 = Math.min(i13, stableInsets.f79251d);
                }
                return z0.c.c(l11.f79248a, 0, l11.f79250c, i13);
            }
            if (i11 != 8) {
                if (i11 == 16) {
                    return k();
                }
                if (i11 == 32) {
                    return i();
                }
                if (i11 == 64) {
                    return m();
                }
                if (i11 != 128) {
                    return z0.c.f79247e;
                }
                WindowInsetsCompat windowInsetsCompat2 = this.f8436f;
                DisplayCutoutCompat displayCutout = windowInsetsCompat2 != null ? windowInsetsCompat2.getDisplayCutout() : f();
                return displayCutout != null ? z0.c.c(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom()) : z0.c.f79247e;
            }
            z0.c[] cVarArr = this.f8434d;
            stableInsets = cVarArr != null ? cVarArr[Type.indexOf(8)] : null;
            if (stableInsets != null) {
                return stableInsets;
            }
            z0.c l12 = l();
            z0.c y11 = y();
            int i14 = l12.f79251d;
            if (i14 > y11.f79251d) {
                return z0.c.c(0, 0, 0, i14);
            }
            z0.c cVar = this.f8437g;
            return (cVar == null || cVar.equals(z0.c.f79247e) || (i12 = this.f8437g.f79251d) <= y11.f79251d) ? z0.c.f79247e : z0.c.c(0, 0, 0, i12);
        }
    }

    /* loaded from: classes.dex */
    private static class g extends f {

        /* renamed from: n, reason: collision with root package name */
        private z0.c f8439n;

        g(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f8439n = null;
        }

        g(WindowInsetsCompat windowInsetsCompat, g gVar) {
            super(windowInsetsCompat, gVar);
            this.f8439n = null;
            this.f8439n = gVar.f8439n;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        WindowInsetsCompat b() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f8433c.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        WindowInsetsCompat c() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f8433c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        final z0.c j() {
            if (this.f8439n == null) {
                this.f8439n = z0.c.c(this.f8433c.getStableInsetLeft(), this.f8433c.getStableInsetTop(), this.f8433c.getStableInsetRight(), this.f8433c.getStableInsetBottom());
            }
            return this.f8439n;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        boolean o() {
            return this.f8433c.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        public void u(z0.c cVar) {
            this.f8439n = cVar;
        }
    }

    /* loaded from: classes.dex */
    private static class h extends g {
        h(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        h(WindowInsetsCompat windowInsetsCompat, h hVar) {
            super(windowInsetsCompat, hVar);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        WindowInsetsCompat a() {
            WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.f8433c.consumeDisplayCutout();
            return WindowInsetsCompat.toWindowInsetsCompat(consumeDisplayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.f8433c, hVar.f8433c) && Objects.equals(this.f8437g, hVar.f8437g) && f.C(this.f8438h, hVar.f8438h);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        DisplayCutoutCompat f() {
            DisplayCutout displayCutout;
            displayCutout = this.f8433c.getDisplayCutout();
            return DisplayCutoutCompat.wrap(displayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        public int hashCode() {
            return this.f8433c.hashCode();
        }
    }

    /* loaded from: classes.dex */
    private static class i extends h {

        /* renamed from: o, reason: collision with root package name */
        private z0.c f8440o;

        /* renamed from: p, reason: collision with root package name */
        private z0.c f8441p;

        /* renamed from: q, reason: collision with root package name */
        private z0.c f8442q;

        i(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f8440o = null;
            this.f8441p = null;
            this.f8442q = null;
        }

        i(WindowInsetsCompat windowInsetsCompat, i iVar) {
            super(windowInsetsCompat, iVar);
            this.f8440o = null;
            this.f8441p = null;
            this.f8442q = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        z0.c i() {
            Insets mandatorySystemGestureInsets;
            if (this.f8441p == null) {
                mandatorySystemGestureInsets = this.f8433c.getMandatorySystemGestureInsets();
                this.f8441p = z0.c.f(mandatorySystemGestureInsets);
            }
            return this.f8441p;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        z0.c k() {
            Insets systemGestureInsets;
            if (this.f8440o == null) {
                systemGestureInsets = this.f8433c.getSystemGestureInsets();
                this.f8440o = z0.c.f(systemGestureInsets);
            }
            return this.f8440o;
        }

        @Override // androidx.core.view.WindowInsetsCompat.l
        z0.c m() {
            Insets tappableElementInsets;
            if (this.f8442q == null) {
                tappableElementInsets = this.f8433c.getTappableElementInsets();
                this.f8442q = z0.c.f(tappableElementInsets);
            }
            return this.f8442q;
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.l
        WindowInsetsCompat n(int i11, int i12, int i13, int i14) {
            WindowInsets inset;
            inset = this.f8433c.inset(i11, i12, i13, i14);
            return WindowInsetsCompat.toWindowInsetsCompat(inset);
        }

        @Override // androidx.core.view.WindowInsetsCompat.g, androidx.core.view.WindowInsetsCompat.l
        public void u(z0.c cVar) {
        }
    }

    /* loaded from: classes.dex */
    private static class j extends i {

        /* renamed from: r, reason: collision with root package name */
        static final WindowInsetsCompat f8443r;

        static {
            WindowInsets windowInsets;
            windowInsets = WindowInsets.CONSUMED;
            f8443r = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        }

        j(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        j(WindowInsetsCompat windowInsetsCompat, j jVar) {
            super(windowInsetsCompat, jVar);
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.l
        final void d(View view) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.l
        public z0.c g(int i11) {
            Insets insets;
            insets = this.f8433c.getInsets(m.a(i11));
            return z0.c.f(insets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.l
        public z0.c h(int i11) {
            Insets insetsIgnoringVisibility;
            insetsIgnoringVisibility = this.f8433c.getInsetsIgnoringVisibility(m.a(i11));
            return z0.c.f(insetsIgnoringVisibility);
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.l
        public boolean q(int i11) {
            boolean isVisible;
            isVisible = this.f8433c.isVisible(m.a(i11));
            return isVisible;
        }
    }

    /* loaded from: classes.dex */
    private static class k extends j {

        /* renamed from: s, reason: collision with root package name */
        static final WindowInsetsCompat f8444s;

        static {
            WindowInsets windowInsets;
            windowInsets = WindowInsets.CONSUMED;
            f8444s = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        }

        k(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        k(WindowInsetsCompat windowInsetsCompat, k kVar) {
            super(windowInsetsCompat, kVar);
        }

        @Override // androidx.core.view.WindowInsetsCompat.j, androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.l
        public z0.c g(int i11) {
            Insets insets;
            insets = this.f8433c.getInsets(n.a(i11));
            return z0.c.f(insets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.j, androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.l
        public z0.c h(int i11) {
            Insets insetsIgnoringVisibility;
            insetsIgnoringVisibility = this.f8433c.getInsetsIgnoringVisibility(n.a(i11));
            return z0.c.f(insetsIgnoringVisibility);
        }

        @Override // androidx.core.view.WindowInsetsCompat.j, androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.l
        public boolean q(int i11) {
            boolean isVisible;
            isVisible = this.f8433c.isVisible(n.a(i11));
            return isVisible;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: b, reason: collision with root package name */
        static final WindowInsetsCompat f8445b = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();

        /* renamed from: a, reason: collision with root package name */
        final WindowInsetsCompat f8446a;

        l(WindowInsetsCompat windowInsetsCompat) {
            this.f8446a = windowInsetsCompat;
        }

        WindowInsetsCompat a() {
            return this.f8446a;
        }

        WindowInsetsCompat b() {
            return this.f8446a;
        }

        WindowInsetsCompat c() {
            return this.f8446a;
        }

        void d(View view) {
        }

        void e(WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return p() == lVar.p() && o() == lVar.o() && androidx.core.util.d.a(l(), lVar.l()) && androidx.core.util.d.a(j(), lVar.j()) && androidx.core.util.d.a(f(), lVar.f());
        }

        DisplayCutoutCompat f() {
            return null;
        }

        z0.c g(int i11) {
            return z0.c.f79247e;
        }

        z0.c h(int i11) {
            if ((i11 & 8) == 0) {
                return z0.c.f79247e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return androidx.core.util.d.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        z0.c i() {
            return l();
        }

        z0.c j() {
            return z0.c.f79247e;
        }

        z0.c k() {
            return l();
        }

        z0.c l() {
            return z0.c.f79247e;
        }

        z0.c m() {
            return l();
        }

        WindowInsetsCompat n(int i11, int i12, int i13, int i14) {
            return f8445b;
        }

        boolean o() {
            return false;
        }

        boolean p() {
            return false;
        }

        boolean q(int i11) {
            return true;
        }

        public void r(z0.c[] cVarArr) {
        }

        void s(z0.c cVar) {
        }

        void t(WindowInsetsCompat windowInsetsCompat) {
        }

        public void u(z0.c cVar) {
        }

        void v(int i11) {
        }
    }

    /* loaded from: classes.dex */
    private static final class m {
        static int a(int i11) {
            int statusBars;
            int i12 = 0;
            for (int i13 = 1; i13 <= 512; i13 <<= 1) {
                if ((i11 & i13) != 0) {
                    if (i13 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i13 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i13 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i13 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i13 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i13 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i13 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i13 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i12 |= statusBars;
                }
            }
            return i12;
        }
    }

    /* loaded from: classes.dex */
    private static final class n {
        static int a(int i11) {
            int statusBars;
            int i12 = 0;
            for (int i13 = 1; i13 <= 512; i13 <<= 1) {
                if ((i11 & i13) != 0) {
                    if (i13 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i13 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i13 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i13 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i13 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i13 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i13 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i13 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    } else if (i13 == 512) {
                        statusBars = WindowInsets.Type.systemOverlays();
                    }
                    i12 |= statusBars;
                }
            }
            return i12;
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            CONSUMED = k.f8444s;
        } else if (i11 >= 30) {
            CONSUMED = j.f8443r;
        } else {
            CONSUMED = l.f8445b;
        }
    }

    private WindowInsetsCompat(WindowInsets windowInsets) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            this.mImpl = new k(this, windowInsets);
            return;
        }
        if (i11 >= 30) {
            this.mImpl = new j(this, windowInsets);
            return;
        }
        if (i11 >= 29) {
            this.mImpl = new i(this, windowInsets);
        } else if (i11 >= 28) {
            this.mImpl = new h(this, windowInsets);
        } else {
            this.mImpl = new g(this, windowInsets);
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat == null) {
            this.mImpl = new l(this);
            return;
        }
        l lVar = windowInsetsCompat.mImpl;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34 && (lVar instanceof k)) {
            this.mImpl = new k(this, (k) lVar);
        } else if (i11 >= 30 && (lVar instanceof j)) {
            this.mImpl = new j(this, (j) lVar);
        } else if (i11 >= 29 && (lVar instanceof i)) {
            this.mImpl = new i(this, (i) lVar);
        } else if (i11 >= 28 && (lVar instanceof h)) {
            this.mImpl = new h(this, (h) lVar);
        } else if (lVar instanceof g) {
            this.mImpl = new g(this, (g) lVar);
        } else if (lVar instanceof f) {
            this.mImpl = new f(this, (f) lVar);
        } else {
            this.mImpl = new l(this);
        }
        lVar.e(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z0.c insetInsets(z0.c cVar, int i11, int i12, int i13, int i14) {
        int max = Math.max(0, cVar.f79248a - i11);
        int max2 = Math.max(0, cVar.f79249b - i12);
        int max3 = Math.max(0, cVar.f79250c - i13);
        int max4 = Math.max(0, cVar.f79251d - i14);
        return (max == i11 && max2 == i12 && max3 == i13 && max4 == i14) ? cVar : z0.c.c(max, max2, max3, max4);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, null);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets, View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) androidx.core.util.i.g(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
            windowInsetsCompat.setSystemUiVisibility(view.getWindowSystemUiVisibility());
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.a();
    }

    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.b();
    }

    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void copyRootViewBounds(View view) {
        this.mImpl.d(view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return androidx.core.util.d.a(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
        }
        return false;
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.f();
    }

    public z0.c getInsets(int i11) {
        return this.mImpl.g(i11);
    }

    public z0.c getInsetsIgnoringVisibility(int i11) {
        return this.mImpl.h(i11);
    }

    @Deprecated
    public z0.c getMandatorySystemGestureInsets() {
        return this.mImpl.i();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.j().f79251d;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.j().f79248a;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.j().f79250c;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.j().f79249b;
    }

    @Deprecated
    public z0.c getStableInsets() {
        return this.mImpl.j();
    }

    @Deprecated
    public z0.c getSystemGestureInsets() {
        return this.mImpl.k();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.l().f79251d;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.l().f79248a;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.l().f79250c;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.l().f79249b;
    }

    @Deprecated
    public z0.c getSystemWindowInsets() {
        return this.mImpl.l();
    }

    @Deprecated
    public z0.c getTappableElementInsets() {
        return this.mImpl.m();
    }

    public boolean hasInsets() {
        z0.c insets = getInsets(Type.all());
        z0.c cVar = z0.c.f79247e;
        return (insets.equals(cVar) && getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(cVar) && getDisplayCutout() == null) ? false : true;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.j().equals(z0.c.f79247e);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.l().equals(z0.c.f79247e);
    }

    public int hashCode() {
        l lVar = this.mImpl;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public WindowInsetsCompat inset(int i11, int i12, int i13, int i14) {
        return this.mImpl.n(i11, i12, i13, i14);
    }

    public WindowInsetsCompat inset(z0.c cVar) {
        return inset(cVar.f79248a, cVar.f79249b, cVar.f79250c, cVar.f79251d);
    }

    public boolean isConsumed() {
        return this.mImpl.o();
    }

    public boolean isRound() {
        return this.mImpl.p();
    }

    public boolean isVisible(int i11) {
        return this.mImpl.q(i11);
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i11, int i12, int i13, int i14) {
        return new Builder(this).setSystemWindowInsets(z0.c.c(i11, i12, i13, i14)).build();
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        return new Builder(this).setSystemWindowInsets(z0.c.d(rect)).build();
    }

    void setOverriddenInsets(z0.c[] cVarArr) {
        this.mImpl.r(cVarArr);
    }

    void setRootViewData(z0.c cVar) {
        this.mImpl.s(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.t(windowInsetsCompat);
    }

    void setStableInsets(z0.c cVar) {
        this.mImpl.u(cVar);
    }

    void setSystemUiVisibility(int i11) {
        this.mImpl.v(i11);
    }

    public WindowInsets toWindowInsets() {
        l lVar = this.mImpl;
        if (lVar instanceof f) {
            return ((f) lVar).f8433c;
        }
        return null;
    }
}
