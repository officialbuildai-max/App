package androidx.compose.foundation.gestures;

import kotlin.coroutines.Continuation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ScrollableNestedScrollConnection implements androidx.compose.ui.input.nestedscroll.b {

    /* renamed from: a, reason: collision with root package name */
    private final ScrollingLogic f2764a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2765b;

    public ScrollableNestedScrollConnection(ScrollingLogic scrollingLogic, boolean z10) {
        this.f2764a = scrollingLogic;
        this.f2765b = z10;
    }

    @Override // androidx.compose.ui.input.nestedscroll.b
    public /* synthetic */ long B0(long j11, int i11) {
        return androidx.compose.ui.input.nestedscroll.a.d(this, j11, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.compose.ui.input.nestedscroll.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object G(long r3, long r5, kotlin.coroutines.Continuation r7) {
        /*
            r2 = this;
            boolean r3 = r7 instanceof androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1
            if (r3 == 0) goto L13
            r3 = r7
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1 r3 = (androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1) r3
            int r4 = r3.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.label = r4
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1 r3 = new androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1
            r3.<init>(r2, r7)
        L18:
            java.lang.Object r4 = r3.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r3.label
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            long r5 = r3.J$0
            kotlin.ResultKt.b(r4)
            goto L47
        L2b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L33:
            kotlin.ResultKt.b(r4)
            boolean r4 = r2.f2765b
            if (r4 == 0) goto L52
            androidx.compose.foundation.gestures.ScrollingLogic r4 = r2.f2764a
            r3.J$0 = r5
            r3.label = r1
            java.lang.Object r4 = r4.n(r5, r3)
            if (r4 != r7) goto L47
            return r7
        L47:
            o0.z r4 = (o0.z) r4
            long r3 = r4.n()
            long r3 = o0.z.k(r5, r3)
            goto L58
        L52:
            o0.z$a r3 = o0.z.f70760b
            long r3 = r3.a()
        L58:
            o0.z r3 = o0.z.b(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableNestedScrollConnection.G(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.b
    public /* synthetic */ Object I0(long j11, Continuation continuation) {
        return androidx.compose.ui.input.nestedscroll.a.c(this, j11, continuation);
    }

    public final void a(boolean z10) {
        this.f2765b = z10;
    }

    @Override // androidx.compose.ui.input.nestedscroll.b
    public long g0(long j11, long j12, int i11) {
        return this.f2765b ? this.f2764a.r(j12) : y.g.f78593b.c();
    }
}
