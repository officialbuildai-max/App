package androidx.transition;

import android.os.Build;
import android.view.View;

/* loaded from: classes2.dex */
class j0 extends h0 {

    /* renamed from: g, reason: collision with root package name */
    private static boolean f15160g = true;

    /* loaded from: classes2.dex */
    static class a {
        static void a(View view, int i11) {
            view.setTransitionVisibility(i11);
        }
    }

    @Override // androidx.transition.c0
    public void f(View view, int i11) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i11);
        } else if (f15160g) {
            try {
                a.a(view, i11);
            } catch (NoSuchMethodError unused) {
                f15160g = false;
            }
        }
    }
}
