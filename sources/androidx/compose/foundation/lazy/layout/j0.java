package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    private static final a f3132a;

    /* loaded from: classes.dex */
    public static final class a implements i0 {
        a() {
        }

        @Override // androidx.compose.foundation.lazy.layout.i0
        public void schedulePrefetch(g0 g0Var) {
        }
    }

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        f3132a = Intrinsics.c(lowerCase, "robolectric") ? new a() : null;
    }

    public static final i0 a(androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(1141871251, i11, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:32)");
        }
        i0 i0Var = f3132a;
        if (i0Var != null) {
            iVar.P(1213893039);
            iVar.K();
        } else {
            iVar.P(1213931944);
            View view = (View) iVar.l(AndroidCompositionLocals_androidKt.j());
            boolean O = iVar.O(view);
            Object y10 = iVar.y();
            if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new AndroidPrefetchScheduler(view);
                iVar.p(y10);
            }
            i0Var = (AndroidPrefetchScheduler) y10;
            iVar.K();
        }
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return i0Var;
    }
}
