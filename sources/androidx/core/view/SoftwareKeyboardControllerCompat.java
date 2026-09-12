package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class SoftwareKeyboardControllerCompat {
    private final c mImpl;

    /* loaded from: classes.dex */
    private static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private final View f8374a;

        a(View view) {
            this.f8374a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.c
        void a() {
            View view = this.f8374a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f8374a.getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.c
        void b() {
            final View view = this.f8374a;
            if (view == null) {
                return;
            }
            if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                view.requestFocus();
            } else {
                view = view.getRootView().findFocus();
            }
            if (view == null) {
                view = this.f8374a.getRootView().findViewById(R.id.content);
            }
            if (view == null || !view.hasWindowFocus()) {
                return;
            }
            view.post(new Runnable() { // from class: androidx.core.view.y
                @Override // java.lang.Runnable
                public final void run() {
                    SoftwareKeyboardControllerCompat.a.d(view);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    private static class b extends a {

        /* renamed from: b, reason: collision with root package name */
        private View f8375b;

        /* renamed from: c, reason: collision with root package name */
        private WindowInsetsController f8376c;

        b(View view) {
            super(view);
            this.f8375b = view;
        }

        b(WindowInsetsController windowInsetsController) {
            super(null);
            this.f8376c = windowInsetsController;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i11) {
            atomicBoolean.set((i11 & 8) != 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.a, androidx.core.view.SoftwareKeyboardControllerCompat.c
        void a() {
            int ime;
            View view;
            WindowInsetsController windowInsetsController = this.f8376c;
            if (windowInsetsController == null) {
                View view2 = this.f8375b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController == null) {
                super.a();
                return;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.f0
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int i11) {
                    SoftwareKeyboardControllerCompat.b.f(atomicBoolean, windowInsetsController2, i11);
                }
            };
            windowInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            if (!atomicBoolean.get() && (view = this.f8375b) != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f8375b.getWindowToken(), 0);
            }
            windowInsetsController.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            ime = WindowInsets.Type.ime();
            windowInsetsController.hide(ime);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.a, androidx.core.view.SoftwareKeyboardControllerCompat.c
        void b() {
            int ime;
            View view = this.f8375b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f8376c;
            if (windowInsetsController == null) {
                View view2 = this.f8375b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                ime = WindowInsets.Type.ime();
                windowInsetsController.show(ime);
            }
            super.b();
        }
    }

    /* loaded from: classes.dex */
    private static class c {
        c() {
        }

        abstract void a();

        abstract void b();
    }

    public SoftwareKeyboardControllerCompat(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new b(view);
        } else {
            this.mImpl = new a(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public SoftwareKeyboardControllerCompat(WindowInsetsController windowInsetsController) {
        this.mImpl = new b(windowInsetsController);
    }

    public void hide() {
        this.mImpl.a();
    }

    public void show() {
        this.mImpl.b();
    }
}
