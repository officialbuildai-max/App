package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.d1;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.q4;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.v1;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    private static final List f4929a = CollectionsKt.l();

    /* renamed from: b, reason: collision with root package name */
    private static final int f4930b = c5.f4393a.a();

    /* renamed from: c, reason: collision with root package name */
    private static final int f4931c = d5.f4505a.b();

    /* renamed from: d, reason: collision with root package name */
    private static final int f4932d = c1.f4367a.z();

    /* renamed from: e, reason: collision with root package name */
    private static final long f4933e = u1.f4733b.d();

    /* renamed from: f, reason: collision with root package name */
    private static final int f4934f = q4.f4703a.b();

    public static final int a() {
        return f4934f;
    }

    public static final int b() {
        return f4930b;
    }

    public static final int c() {
        return f4931c;
    }

    public static final List d() {
        return f4929a;
    }

    public static final boolean e(long j11, long j12) {
        return u1.r(j11) == u1.r(j12) && u1.q(j11) == u1.q(j12) && u1.o(j11) == u1.o(j12);
    }

    public static final boolean f(v1 v1Var) {
        if (v1Var instanceof d1) {
            d1 d1Var = (d1) v1Var;
            int b11 = d1Var.b();
            c1.a aVar = c1.f4367a;
            if (c1.E(b11, aVar.z()) || c1.E(d1Var.b(), aVar.B())) {
                return true;
            }
        } else if (v1Var == null) {
            return true;
        }
        return false;
    }
}
