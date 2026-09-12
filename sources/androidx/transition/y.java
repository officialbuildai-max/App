package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f15198a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        static int a(ViewGroup viewGroup, int i11) {
            return viewGroup.getChildDrawingOrder(i11);
        }

        static void b(ViewGroup viewGroup, boolean z10) {
            viewGroup.suppressLayout(z10);
        }
    }

    private static void a(ViewGroup viewGroup, boolean z10) {
        if (f15198a) {
            try {
                a.b(viewGroup, z10);
            } catch (NoSuchMethodError unused) {
                f15198a = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ViewGroup viewGroup, boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.b(viewGroup, z10);
        } else {
            a(viewGroup, z10);
        }
    }
}
