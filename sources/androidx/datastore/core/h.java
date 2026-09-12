package androidx.datastore.core;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.y0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final y0 f8676a;

    public h() {
        u uVar = u.f8708b;
        Intrinsics.f(uVar, "null cannot be cast to non-null type androidx.datastore.core.State<T of androidx.datastore.core.DataStoreInMemoryCache>");
        this.f8676a = j1.a(uVar);
    }

    public final r a() {
        return (r) this.f8676a.getValue();
    }

    public final kotlinx.coroutines.flow.b b() {
        return this.f8676a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r6.a() > r2.a()) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.datastore.core.r c(androidx.datastore.core.r r6) {
        /*
            r5 = this;
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.Intrinsics.h(r6, r0)
            kotlinx.coroutines.flow.y0 r0 = r5.f8676a
        L7:
            java.lang.Object r1 = r0.getValue()
            r2 = r1
            androidx.datastore.core.r r2 = (androidx.datastore.core.r) r2
            boolean r3 = r2 instanceof androidx.datastore.core.o
            if (r3 == 0) goto L14
            r3 = 1
            goto L1a
        L14:
            androidx.datastore.core.u r3 = androidx.datastore.core.u.f8708b
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r2, r3)
        L1a:
            if (r3 == 0) goto L1d
            goto L2b
        L1d:
            boolean r3 = r2 instanceof androidx.datastore.core.d
            if (r3 == 0) goto L2d
            int r3 = r6.a()
            int r4 = r2.a()
            if (r3 <= r4) goto L31
        L2b:
            r2 = r6
            goto L31
        L2d:
            boolean r3 = r2 instanceof androidx.datastore.core.i
            if (r3 == 0) goto L38
        L31:
            boolean r1 = r0.e(r1, r2)
            if (r1 == 0) goto L7
            return r2
        L38:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.h.c(androidx.datastore.core.r):androidx.datastore.core.r");
    }
}
