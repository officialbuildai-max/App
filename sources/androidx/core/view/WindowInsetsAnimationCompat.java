package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.R$id;
import androidx.core.view.WindowInsetsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private b mImpl;

    /* loaded from: classes.dex */
    public static final class BoundsCompat {
        private final z0.c mLowerBound;
        private final z0.c mUpperBound;

        private BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            this.mLowerBound = a.k(bounds);
            this.mUpperBound = a.j(bounds);
        }

        public BoundsCompat(z0.c cVar, z0.c cVar2) {
            this.mLowerBound = cVar;
            this.mUpperBound = cVar2;
        }

        public static BoundsCompat toBoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        public z0.c getLowerBound() {
            return this.mLowerBound;
        }

        public z0.c getUpperBound() {
            return this.mUpperBound;
        }

        public BoundsCompat inset(z0.c cVar) {
            return new BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, cVar.f79248a, cVar.f79249b, cVar.f79250c, cVar.f79251d), WindowInsetsCompat.insetInsets(this.mUpperBound, cVar.f79248a, cVar.f79249b, cVar.f79250c, cVar.f79251d));
        }

        public WindowInsetsAnimation.Bounds toBounds() {
            return a.i(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + "}";
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsetsCompat mDispachedInsets;
        private final int mDispatchMode;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface DispatchMode {
        }

        public Callback(int i11) {
            this.mDispatchMode = i11;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public abstract WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list);

        public BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Impl21 extends b {

        /* renamed from: f, reason: collision with root package name */
        private static final Interpolator f8393f = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* renamed from: g, reason: collision with root package name */
        private static final Interpolator f8394g = new o1.a();

        /* renamed from: h, reason: collision with root package name */
        private static final Interpolator f8395h = new DecelerateInterpolator(1.5f);

        /* renamed from: i, reason: collision with root package name */
        private static final Interpolator f8396i = new AccelerateInterpolator(1.5f);

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            final Callback f8397a;

            /* renamed from: b, reason: collision with root package name */
            private WindowInsetsCompat f8398b;

            /* loaded from: classes.dex */
            class a implements ValueAnimator.AnimatorUpdateListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ WindowInsetsAnimationCompat f8399a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ WindowInsetsCompat f8400b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ WindowInsetsCompat f8401c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f8402d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f8403e;

                a(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i11, View view) {
                    this.f8399a = windowInsetsAnimationCompat;
                    this.f8400b = windowInsetsCompat;
                    this.f8401c = windowInsetsCompat2;
                    this.f8402d = i11;
                    this.f8403e = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f8399a.setFraction(valueAnimator.getAnimatedFraction());
                    Impl21.o(this.f8403e, Impl21.s(this.f8400b, this.f8401c, this.f8399a.getInterpolatedFraction(), this.f8402d), Collections.singletonList(this.f8399a));
                }
            }

            /* loaded from: classes.dex */
            class b extends AnimatorListenerAdapter {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ WindowInsetsAnimationCompat f8405a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ View f8406b;

                b(WindowInsetsAnimationCompat windowInsetsAnimationCompat, View view) {
                    this.f8405a = windowInsetsAnimationCompat;
                    this.f8406b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.f8405a.setFraction(1.0f);
                    Impl21.m(this.f8406b, this.f8405a);
                }
            }

            Impl21OnApplyWindowInsetsListener(View view, Callback callback) {
                this.f8397a = callback;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
                this.f8398b = rootWindowInsets != null ? new WindowInsetsCompat.Builder(rootWindowInsets).build() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(final View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.f8398b = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                    return Impl21.q(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                if (this.f8398b == null) {
                    this.f8398b = ViewCompat.getRootWindowInsets(view);
                }
                if (this.f8398b == null) {
                    this.f8398b = windowInsetsCompat;
                    return Impl21.q(view, windowInsets);
                }
                Callback r11 = Impl21.r(view);
                if (r11 != null && Objects.equals(r11.mDispachedInsets, windowInsetsCompat)) {
                    return Impl21.q(view, windowInsets);
                }
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                Impl21.i(windowInsetsCompat, this.f8398b, iArr, iArr2);
                int i11 = iArr[0];
                int i12 = iArr2[0];
                int i13 = i11 | i12;
                if (i13 == 0) {
                    this.f8398b = windowInsetsCompat;
                    return Impl21.q(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat2 = this.f8398b;
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(i13, Impl21.k(i11, i12), (WindowInsetsCompat.Type.ime() & i13) != 0 ? 160L : 250L);
                windowInsetsAnimationCompat.setFraction(0.0f);
                final ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.getDurationMillis());
                final BoundsCompat j11 = Impl21.j(windowInsetsCompat, windowInsetsCompat2, i13);
                Impl21.n(view, windowInsetsAnimationCompat, windowInsetsCompat, false);
                duration.addUpdateListener(new a(windowInsetsAnimationCompat, windowInsetsCompat, windowInsetsCompat2, i13, view));
                duration.addListener(new b(windowInsetsAnimationCompat, view));
                OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Impl21.p(view, windowInsetsAnimationCompat, j11);
                        duration.start();
                    }
                });
                this.f8398b = windowInsetsCompat;
                return Impl21.q(view, windowInsets);
            }
        }

        Impl21(int i11, Interpolator interpolator, long j11) {
            super(i11, interpolator, j11);
        }

        static void i(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int[] iArr, int[] iArr2) {
            for (int i11 = 1; i11 <= 512; i11 <<= 1) {
                z0.c insets = windowInsetsCompat.getInsets(i11);
                z0.c insets2 = windowInsetsCompat2.getInsets(i11);
                int i12 = insets.f79248a;
                int i13 = insets2.f79248a;
                boolean z10 = i12 > i13 || insets.f79249b > insets2.f79249b || insets.f79250c > insets2.f79250c || insets.f79251d > insets2.f79251d;
                if (z10 != (i12 < i13 || insets.f79249b < insets2.f79249b || insets.f79250c < insets2.f79250c || insets.f79251d < insets2.f79251d)) {
                    if (z10) {
                        iArr[0] = iArr[0] | i11;
                    } else {
                        iArr2[0] = iArr2[0] | i11;
                    }
                }
            }
        }

        static BoundsCompat j(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i11) {
            z0.c insets = windowInsetsCompat.getInsets(i11);
            z0.c insets2 = windowInsetsCompat2.getInsets(i11);
            return new BoundsCompat(z0.c.c(Math.min(insets.f79248a, insets2.f79248a), Math.min(insets.f79249b, insets2.f79249b), Math.min(insets.f79250c, insets2.f79250c), Math.min(insets.f79251d, insets2.f79251d)), z0.c.c(Math.max(insets.f79248a, insets2.f79248a), Math.max(insets.f79249b, insets2.f79249b), Math.max(insets.f79250c, insets2.f79250c), Math.max(insets.f79251d, insets2.f79251d)));
        }

        static Interpolator k(int i11, int i12) {
            if ((WindowInsetsCompat.Type.ime() & i11) != 0) {
                return f8393f;
            }
            if ((WindowInsetsCompat.Type.ime() & i12) != 0) {
                return f8394g;
            }
            if ((i11 & WindowInsetsCompat.Type.systemBars()) != 0) {
                return f8395h;
            }
            if ((WindowInsetsCompat.Type.systemBars() & i12) != 0) {
                return f8396i;
            }
            return null;
        }

        private static View.OnApplyWindowInsetsListener l(View view, Callback callback) {
            return new Impl21OnApplyWindowInsetsListener(view, callback);
        }

        static void m(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback r11 = r(view);
            if (r11 != null) {
                r11.onEnd(windowInsetsAnimationCompat);
                if (r11.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    m(viewGroup.getChildAt(i11), windowInsetsAnimationCompat);
                }
            }
        }

        static void n(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, boolean z10) {
            Callback r11 = r(view);
            if (r11 != null) {
                r11.mDispachedInsets = windowInsetsCompat;
                if (!z10) {
                    r11.onPrepare(windowInsetsAnimationCompat);
                    z10 = r11.getDispatchMode() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    n(viewGroup.getChildAt(i11), windowInsetsAnimationCompat, windowInsetsCompat, z10);
                }
            }
        }

        static void o(View view, WindowInsetsCompat windowInsetsCompat, List list) {
            Callback r11 = r(view);
            if (r11 != null) {
                windowInsetsCompat = r11.onProgress(windowInsetsCompat, list);
                if (r11.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    o(viewGroup.getChildAt(i11), windowInsetsCompat, list);
                }
            }
        }

        static void p(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback r11 = r(view);
            if (r11 != null) {
                r11.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (r11.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    p(viewGroup.getChildAt(i11), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        static WindowInsets q(View view, WindowInsets windowInsets) {
            return view.getTag(R$id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        static Callback r(View view) {
            Object tag = view.getTag(R$id.tag_window_insets_animation_callback);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).f8397a;
            }
            return null;
        }

        static WindowInsetsCompat s(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f11, int i11) {
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
            for (int i12 = 1; i12 <= 512; i12 <<= 1) {
                if ((i11 & i12) == 0) {
                    builder.setInsets(i12, windowInsetsCompat.getInsets(i12));
                } else {
                    z0.c insets = windowInsetsCompat.getInsets(i12);
                    z0.c insets2 = windowInsetsCompat2.getInsets(i12);
                    float f12 = 1.0f - f11;
                    builder.setInsets(i12, WindowInsetsCompat.insetInsets(insets, (int) (((insets.f79248a - insets2.f79248a) * f12) + 0.5d), (int) (((insets.f79249b - insets2.f79249b) * f12) + 0.5d), (int) (((insets.f79250c - insets2.f79250c) * f12) + 0.5d), (int) (((insets.f79251d - insets2.f79251d) * f12) + 0.5d)));
                }
            }
            return builder.build();
        }

        static void t(View view, Callback callback) {
            View.OnApplyWindowInsetsListener l11 = callback != null ? l(view, callback) : null;
            view.setTag(R$id.tag_window_insets_animation_callback, l11);
            if (view.getTag(R$id.tag_compat_insets_dispatch) == null && view.getTag(R$id.tag_on_apply_window_listener) == null) {
                view.setOnApplyWindowInsetsListener(l11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends b {

        /* renamed from: f, reason: collision with root package name */
        private final WindowInsetsAnimation f8408f;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0075a extends WindowInsetsAnimation$Callback {

            /* renamed from: a, reason: collision with root package name */
            private final Callback f8409a;

            /* renamed from: b, reason: collision with root package name */
            private List f8410b;

            /* renamed from: c, reason: collision with root package name */
            private ArrayList f8411c;

            /* renamed from: d, reason: collision with root package name */
            private final HashMap f8412d;

            C0075a(Callback callback) {
                super(callback.getDispatchMode());
                this.f8412d = new HashMap();
                this.f8409a = callback;
            }

            private WindowInsetsAnimationCompat a(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) this.f8412d.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat != null) {
                    return windowInsetsAnimationCompat;
                }
                WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(windowInsetsAnimation);
                this.f8412d.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
                return windowInsetsAnimationCompat2;
            }

            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f8409a.onEnd(a(windowInsetsAnimation));
                this.f8412d.remove(windowInsetsAnimation);
            }

            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f8409a.onPrepare(a(windowInsetsAnimation));
            }

            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                float fraction;
                ArrayList arrayList = this.f8411c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.f8411c = arrayList2;
                    this.f8410b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation a11 = e1.a(list.get(size));
                    WindowInsetsAnimationCompat a12 = a(a11);
                    fraction = a11.getFraction();
                    a12.setFraction(fraction);
                    this.f8411c.add(a12);
                }
                return this.f8409a.onProgress(WindowInsetsCompat.toWindowInsetsCompat(windowInsets), this.f8410b).toWindowInsets();
            }

            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f8409a.onStart(a(windowInsetsAnimation), BoundsCompat.toBoundsCompat(bounds)).toBounds();
            }
        }

        a(int i11, Interpolator interpolator, long j11) {
            this(s0.a(i11, interpolator, j11));
        }

        a(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f8408f = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds i(BoundsCompat boundsCompat) {
            u0.a();
            return t0.a(boundsCompat.getLowerBound().g(), boundsCompat.getUpperBound().g());
        }

        public static z0.c j(WindowInsetsAnimation.Bounds bounds) {
            Insets upperBound;
            upperBound = bounds.getUpperBound();
            return z0.c.f(upperBound);
        }

        public static z0.c k(WindowInsetsAnimation.Bounds bounds) {
            Insets lowerBound;
            lowerBound = bounds.getLowerBound();
            return z0.c.f(lowerBound);
        }

        public static void l(View view, Callback callback) {
            view.setWindowInsetsAnimationCallback(callback != null ? new C0075a(callback) : null);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public float a() {
            float alpha;
            alpha = this.f8408f.getAlpha();
            return alpha;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public long b() {
            long durationMillis;
            durationMillis = this.f8408f.getDurationMillis();
            return durationMillis;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public float c() {
            float fraction;
            fraction = this.f8408f.getFraction();
            return fraction;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public float d() {
            float interpolatedFraction;
            interpolatedFraction = this.f8408f.getInterpolatedFraction();
            return interpolatedFraction;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public Interpolator e() {
            Interpolator interpolator;
            interpolator = this.f8408f.getInterpolator();
            return interpolator;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public int f() {
            int typeMask;
            typeMask = this.f8408f.getTypeMask();
            return typeMask;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public void g(float f11) {
            this.f8408f.setAlpha(f11);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public void h(float f11) {
            this.f8408f.setFraction(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f8413a;

        /* renamed from: b, reason: collision with root package name */
        private float f8414b;

        /* renamed from: c, reason: collision with root package name */
        private final Interpolator f8415c;

        /* renamed from: d, reason: collision with root package name */
        private final long f8416d;

        /* renamed from: e, reason: collision with root package name */
        private float f8417e = 1.0f;

        b(int i11, Interpolator interpolator, long j11) {
            this.f8413a = i11;
            this.f8415c = interpolator;
            this.f8416d = j11;
        }

        public float a() {
            return this.f8417e;
        }

        public long b() {
            return this.f8416d;
        }

        public float c() {
            return this.f8414b;
        }

        public float d() {
            Interpolator interpolator = this.f8415c;
            return interpolator != null ? interpolator.getInterpolation(this.f8414b) : this.f8414b;
        }

        public Interpolator e() {
            return this.f8415c;
        }

        public int f() {
            return this.f8413a;
        }

        public void g(float f11) {
            this.f8417e = f11;
        }

        public void h(float f11) {
            this.f8414b = f11;
        }
    }

    public WindowInsetsAnimationCompat(int i11, Interpolator interpolator, long j11) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new a(i11, interpolator, j11);
        } else {
            this.mImpl = new Impl21(i11, interpolator, j11);
        }
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new a(windowInsetsAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCallback(View view, Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.l(view, callback);
        } else {
            Impl21.t(view, callback);
        }
    }

    static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    public float getAlpha() {
        return this.mImpl.a();
    }

    public long getDurationMillis() {
        return this.mImpl.b();
    }

    public float getFraction() {
        return this.mImpl.c();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.d();
    }

    public Interpolator getInterpolator() {
        return this.mImpl.e();
    }

    public int getTypeMask() {
        return this.mImpl.f();
    }

    public void setAlpha(float f11) {
        this.mImpl.g(f11);
    }

    public void setFraction(float f11) {
        this.mImpl.h(f11);
    }
}
