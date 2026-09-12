package androidx.core.view;

import android.graphics.Insets;
import android.view.WindowInsetsAnimationController;

/* loaded from: classes.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final b mImpl;

    /* loaded from: classes.dex */
    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final WindowInsetsAnimationController f8418a;

        a(WindowInsetsAnimationController windowInsetsAnimationController) {
            this.f8418a = windowInsetsAnimationController;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        void a(boolean z10) {
            this.f8418a.finish(z10);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public float b() {
            float currentAlpha;
            currentAlpha = this.f8418a.getCurrentAlpha();
            return currentAlpha;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public float c() {
            float currentFraction;
            currentFraction = this.f8418a.getCurrentFraction();
            return currentFraction;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public z0.c d() {
            Insets currentInsets;
            currentInsets = this.f8418a.getCurrentInsets();
            return z0.c.f(currentInsets);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public z0.c e() {
            Insets hiddenStateInsets;
            hiddenStateInsets = this.f8418a.getHiddenStateInsets();
            return z0.c.f(hiddenStateInsets);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public z0.c f() {
            Insets shownStateInsets;
            shownStateInsets = this.f8418a.getShownStateInsets();
            return z0.c.f(shownStateInsets);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public int g() {
            int types;
            types = this.f8418a.getTypes();
            return types;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        boolean h() {
            boolean isCancelled;
            isCancelled = this.f8418a.isCancelled();
            return isCancelled;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        boolean i() {
            boolean isFinished;
            isFinished = this.f8418a.isFinished();
            return isFinished;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.b
        public void j(z0.c cVar, float f11, float f12) {
            this.f8418a.setInsetsAndAlpha(cVar == null ? null : cVar.g(), f11, f12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        b() {
        }

        abstract void a(boolean z10);

        public abstract float b();

        public abstract float c();

        public abstract z0.c d();

        public abstract z0.c e();

        public abstract z0.c f();

        public abstract int g();

        abstract boolean h();

        abstract boolean i();

        public abstract void j(z0.c cVar, float f11, float f12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new a(windowInsetsAnimationController);
    }

    public void finish(boolean z10) {
        this.mImpl.a(z10);
    }

    public float getCurrentAlpha() {
        return this.mImpl.b();
    }

    public float getCurrentFraction() {
        return this.mImpl.c();
    }

    public z0.c getCurrentInsets() {
        return this.mImpl.d();
    }

    public z0.c getHiddenStateInsets() {
        return this.mImpl.e();
    }

    public z0.c getShownStateInsets() {
        return this.mImpl.f();
    }

    public int getTypes() {
        return this.mImpl.g();
    }

    public boolean isCancelled() {
        return this.mImpl.h();
    }

    public boolean isFinished() {
        return this.mImpl.i();
    }

    public boolean isReady() {
        return (isFinished() || isCancelled()) ? false : true;
    }

    public void setInsetsAndAlpha(z0.c cVar, float f11, float f12) {
        this.mImpl.j(cVar, f11, f12);
    }
}
