package androidx.compose.foundation.lazy.layout;

import androidx.collection.m0;
import androidx.collection.t0;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a */
    private final m0 f3128a = t0.a();

    /* renamed from: b */
    private final m0 f3129b = t0.a();

    /* renamed from: c */
    private long f3130c;

    /* renamed from: d */
    private long f3131d;

    public static final /* synthetic */ long a(f0 f0Var, long j11, long j12) {
        return f0Var.d(j11, j12);
    }

    public static final /* synthetic */ void b(f0 f0Var, long j11) {
        f0Var.f3130c = j11;
    }

    public static final /* synthetic */ void c(f0 f0Var, long j11) {
        f0Var.f3131d = j11;
    }

    public final long d(long j11, long j12) {
        if (j12 == 0) {
            return j11;
        }
        long j13 = 4;
        return (j11 / j13) + ((j12 / j13) * 3);
    }

    public final long e() {
        return this.f3130c;
    }

    public final m0 f() {
        return this.f3128a;
    }

    public final long g() {
        return this.f3131d;
    }

    public final m0 h() {
        return this.f3129b;
    }
}
