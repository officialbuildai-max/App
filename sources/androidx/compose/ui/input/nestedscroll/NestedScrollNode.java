package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.f;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import y.g;

/* loaded from: classes.dex */
public final class NestedScrollNode extends f.c implements m1, b {

    /* renamed from: n, reason: collision with root package name */
    private b f5011n;

    /* renamed from: o, reason: collision with root package name */
    private NestedScrollDispatcher f5012o;

    /* renamed from: p, reason: collision with root package name */
    private final Object f5013p;

    public NestedScrollNode(b bVar, NestedScrollDispatcher nestedScrollDispatcher) {
        this.f5011n = bVar;
        this.f5012o = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.f5013p = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n0 E1() {
        n0 h11;
        NestedScrollNode G1 = G1();
        if ((G1 == null || (h11 = G1.E1()) == null) && (h11 = this.f5012o.h()) == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return h11;
    }

    private final b F1() {
        if (k1()) {
            return G1();
        }
        return null;
    }

    private final void H1() {
        if (this.f5012o.f() == this) {
            this.f5012o.j(null);
        }
    }

    private final void I1(NestedScrollDispatcher nestedScrollDispatcher) {
        H1();
        if (nestedScrollDispatcher == null) {
            this.f5012o = new NestedScrollDispatcher();
        } else if (!Intrinsics.c(nestedScrollDispatcher, this.f5012o)) {
            this.f5012o = nestedScrollDispatcher;
        }
        if (k1()) {
            J1();
        }
    }

    private final void J1() {
        this.f5012o.j(this);
        this.f5012o.i(new Function0<n0>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode$updateDispatcherFields$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final n0 invoke() {
                n0 E1;
                E1 = NestedScrollNode.this.E1();
                return E1;
            }
        });
        this.f5012o.k(d1());
    }

    @Override // androidx.compose.ui.input.nestedscroll.b
    public long B0(long j11, int i11) {
        b F1 = F1();
        long B0 = F1 != null ? F1.B0(j11, i11) : g.f78593b.c();
        return g.r(B0, this.f5011n.B0(g.q(j11, B0), i11));
    }

    @Override // androidx.compose.ui.node.m1
    public Object D() {
        return this.f5013p;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // androidx.compose.ui.input.nestedscroll.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object G(long r16, long r18, kotlin.coroutines.Continuation r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r20
            boolean r2 = r1 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            if (r2 == 0) goto L16
            r2 = r1
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.label = r3
            goto L1b
        L16:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r2 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            r2.<init>(r15, r1)
        L1b:
            java.lang.Object r1 = r2.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r3 = r2.label
            r10 = 2
            r4 = 1
            if (r3 == 0) goto L47
            if (r3 == r4) goto L39
            if (r3 != r10) goto L31
            long r2 = r2.J$0
            kotlin.ResultKt.b(r1)
            goto L8c
        L31:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L39:
            long r3 = r2.J$1
            long r5 = r2.J$0
            java.lang.Object r7 = r2.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r7 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r7
            kotlin.ResultKt.b(r1)
            r13 = r3
            r11 = r5
            goto L65
        L47:
            kotlin.ResultKt.b(r1)
            androidx.compose.ui.input.nestedscroll.b r3 = r0.f5011n
            r2.L$0 = r0
            r11 = r16
            r2.J$0 = r11
            r13 = r18
            r2.J$1 = r13
            r2.label = r4
            r4 = r16
            r6 = r18
            r8 = r2
            java.lang.Object r1 = r3.G(r4, r6, r8)
            if (r1 != r9) goto L64
            return r9
        L64:
            r7 = r0
        L65:
            o0.z r1 = (o0.z) r1
            long r4 = r1.n()
            androidx.compose.ui.input.nestedscroll.b r3 = r7.F1()
            if (r3 == 0) goto L94
            long r6 = o0.z.l(r11, r4)
            long r11 = o0.z.k(r13, r4)
            r1 = 0
            r2.L$0 = r1
            r2.J$0 = r4
            r2.label = r10
            r13 = r4
            r4 = r6
            r6 = r11
            r8 = r2
            java.lang.Object r1 = r3.G(r4, r6, r8)
            if (r1 != r9) goto L8b
            return r9
        L8b:
            r2 = r13
        L8c:
            o0.z r1 = (o0.z) r1
            long r4 = r1.n()
            r13 = r2
            goto L9b
        L94:
            r13 = r4
            o0.z$a r1 = o0.z.f70760b
            long r4 = r1.a()
        L9b:
            long r1 = o0.z.l(r13, r4)
            o0.z r1 = o0.z.b(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.G(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final NestedScrollNode G1() {
        if (k1()) {
            return (NestedScrollNode) n1.b(this);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.ui.input.nestedscroll.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object I0(long r9, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r11
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            long r9 = r0.J$0
            kotlin.ResultKt.b(r11)
            goto L7d
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            long r9 = r0.J$0
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r2
            kotlin.ResultKt.b(r11)
            goto L57
        L40:
            kotlin.ResultKt.b(r11)
            androidx.compose.ui.input.nestedscroll.b r11 = r8.F1()
            if (r11 == 0) goto L61
            r0.L$0 = r8
            r0.J$0 = r9
            r0.label = r4
            java.lang.Object r11 = r11.I0(r9, r0)
            if (r11 != r1) goto L56
            return r1
        L56:
            r2 = r8
        L57:
            o0.z r11 = (o0.z) r11
            long r4 = r11.n()
        L5d:
            r6 = r9
            r9 = r4
            r4 = r6
            goto L69
        L61:
            o0.z$a r11 = o0.z.f70760b
            long r4 = r11.a()
            r2 = r8
            goto L5d
        L69:
            androidx.compose.ui.input.nestedscroll.b r11 = r2.f5011n
            long r4 = o0.z.k(r4, r9)
            r2 = 0
            r0.L$0 = r2
            r0.J$0 = r9
            r0.label = r3
            java.lang.Object r11 = r11.I0(r4, r0)
            if (r11 != r1) goto L7d
            return r1
        L7d:
            o0.z r11 = (o0.z) r11
            long r0 = r11.n()
            long r9 = o0.z.l(r9, r0)
            o0.z r9 = o0.z.b(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.I0(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void K1(b bVar, NestedScrollDispatcher nestedScrollDispatcher) {
        this.f5011n = bVar;
        I1(nestedScrollDispatcher);
    }

    @Override // androidx.compose.ui.input.nestedscroll.b
    public long g0(long j11, long j12, int i11) {
        long g02 = this.f5011n.g0(j11, j12, i11);
        b F1 = F1();
        return g.r(g02, F1 != null ? F1.g0(g.r(j11, g02), g.q(j12, g02), i11) : g.f78593b.c());
    }

    @Override // androidx.compose.ui.f.c
    public void n1() {
        J1();
    }

    @Override // androidx.compose.ui.f.c
    public void o1() {
        H1();
    }
}
