package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.f1;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16042a = androidx.work.t.i("EnqueueRunnable");

    public static boolean a(androidx.work.impl.e0 e0Var) {
        f1 h11 = e0Var.h();
        WorkDatabase t11 = h11.t();
        t11.k();
        try {
            g.a(t11, h11.m(), e0Var);
            boolean e11 = e(e0Var);
            t11.e0();
            return e11;
        } finally {
            t11.t();
        }
    }

    public static void b(androidx.work.impl.e0 e0Var) {
        if (!e0Var.i()) {
            if (a(e0Var)) {
                f(e0Var);
            }
        } else {
            throw new IllegalStateException("WorkContinuation has cycles (" + e0Var + ")");
        }
    }

    private static boolean c(androidx.work.impl.e0 e0Var) {
        boolean d11 = d(e0Var.h(), e0Var.g(), (String[]) androidx.work.impl.e0.n(e0Var).toArray(new String[0]), e0Var.e(), e0Var.c());
        e0Var.m();
        return d11;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean d(androidx.work.impl.f1 r18, java.util.List r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.f.d(androidx.work.impl.f1, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static boolean e(androidx.work.impl.e0 e0Var) {
        List<androidx.work.impl.e0> f11 = e0Var.f();
        boolean z10 = false;
        if (f11 != null) {
            for (androidx.work.impl.e0 e0Var2 : f11) {
                if (e0Var2.k()) {
                    androidx.work.t.e().k(f16042a, "Already enqueued work ids (" + TextUtils.join(", ", e0Var2.d()) + ")");
                } else {
                    z10 |= e(e0Var2);
                }
            }
        }
        return c(e0Var) | z10;
    }

    public static void f(androidx.work.impl.e0 e0Var) {
        f1 h11 = e0Var.h();
        androidx.work.impl.x.h(h11.m(), h11.t(), h11.r());
    }
}
