package androidx.compose.ui.input.nestedscroll;

import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.n0;
import y.g;

/* loaded from: classes.dex */
public final class NestedScrollDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private NestedScrollNode f5006a;

    /* renamed from: b, reason: collision with root package name */
    private Function0 f5007b = new Function0<n0>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$calculateNestedScrollScope$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final n0 invoke() {
            return NestedScrollDispatcher.this.h();
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private n0 f5008c;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r8, long r10, kotlin.coroutines.Continuation r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            r0.<init>(r7, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.b(r12)
            goto L47
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.b(r12)
            androidx.compose.ui.input.nestedscroll.b r1 = r7.g()
            if (r1 == 0) goto L4e
            r6.label = r2
            r2 = r8
            r4 = r10
            java.lang.Object r12 = r1.G(r2, r4, r6)
            if (r12 != r0) goto L47
            return r0
        L47:
            o0.z r12 = (o0.z) r12
            long r8 = r12.n()
            goto L54
        L4e:
            o0.z$a r8 = o0.z.f70760b
            long r8 = r8.a()
        L54:
            o0.z r8 = o0.z.b(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher.a(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long b(long j11, long j12, int i11) {
        b g11 = g();
        return g11 != null ? g11.g0(j11, j12, i11) : g.f78593b.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(long r5, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            androidx.compose.ui.input.nestedscroll.b r7 = r4.g()
            if (r7 == 0) goto L4a
            r0.label = r3
            java.lang.Object r7 = r7.I0(r5, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            o0.z r7 = (o0.z) r7
            long r5 = r7.n()
            goto L50
        L4a:
            o0.z$a r5 = o0.z.f70760b
            long r5 = r5.a()
        L50:
            o0.z r5 = o0.z.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher.c(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long d(long j11, int i11) {
        b g11 = g();
        return g11 != null ? g11.B0(j11, i11) : g.f78593b.c();
    }

    public final n0 e() {
        n0 n0Var = (n0) this.f5007b.invoke();
        if (n0Var != null) {
            return n0Var;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final NestedScrollNode f() {
        return this.f5006a;
    }

    public final b g() {
        NestedScrollNode nestedScrollNode = this.f5006a;
        if (nestedScrollNode != null) {
            return nestedScrollNode.G1();
        }
        return null;
    }

    public final n0 h() {
        return this.f5008c;
    }

    public final void i(Function0 function0) {
        this.f5007b = function0;
    }

    public final void j(NestedScrollNode nestedScrollNode) {
        this.f5006a = nestedScrollNode;
    }

    public final void k(n0 n0Var) {
        this.f5008c = n0Var;
    }
}
