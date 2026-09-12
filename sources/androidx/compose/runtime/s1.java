package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public abstract class s1 extends q {
    public s1(Function0 function0) {
        super(function0, null);
    }

    private final g3 f(t1 t1Var) {
        if (!t1Var.i()) {
            return t1Var.c() != null ? new x(t1Var.c()) : t1Var.f() != null ? new f0(t1Var.f()) : new c3(t1Var.d());
        }
        i1 f11 = t1Var.f();
        if (f11 == null) {
            Object g11 = t1Var.g();
            q2 e11 = t1Var.e();
            if (e11 == null) {
                e11 = r2.j();
            }
            f11 = r2.e(g11, e11);
        }
        return new f0(f11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r0 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r0 == r2) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.runtime.g3 b(androidx.compose.runtime.t1 r4, androidx.compose.runtime.g3 r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof androidx.compose.runtime.f0
            r1 = 0
            if (r0 == 0) goto L1a
            boolean r0 = r4.i()
            if (r0 == 0) goto L47
            r1 = r5
            androidx.compose.runtime.f0 r1 = (androidx.compose.runtime.f0) r1
            androidx.compose.runtime.i1 r5 = r1.b()
            java.lang.Object r0 = r4.d()
            r5.setValue(r0)
            goto L47
        L1a:
            boolean r0 = r5 instanceof androidx.compose.runtime.c3
            if (r0 == 0) goto L36
            boolean r0 = r4.j()
            if (r0 == 0) goto L47
            java.lang.Object r0 = r4.d()
            androidx.compose.runtime.c3 r5 = (androidx.compose.runtime.c3) r5
            java.lang.Object r2 = r5.b()
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r2)
            if (r0 == 0) goto L47
        L34:
            r1 = r5
            goto L47
        L36:
            boolean r0 = r5 instanceof androidx.compose.runtime.x
            if (r0 == 0) goto L47
            kotlin.jvm.functions.Function1 r0 = r4.c()
            androidx.compose.runtime.x r5 = (androidx.compose.runtime.x) r5
            kotlin.jvm.functions.Function1 r2 = r5.b()
            if (r0 != r2) goto L47
            goto L34
        L47:
            if (r1 != 0) goto L4d
            androidx.compose.runtime.g3 r1 = r3.f(r4)
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.s1.b(androidx.compose.runtime.t1, androidx.compose.runtime.g3):androidx.compose.runtime.g3");
    }

    public abstract t1 c(Object obj);

    public final t1 d(Object obj) {
        return c(obj);
    }

    public final t1 e(Object obj) {
        return c(obj).h();
    }
}
