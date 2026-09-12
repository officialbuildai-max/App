package androidx.compose.foundation.gestures;

import kotlinx.coroutines.sync.a;

/* loaded from: classes.dex */
public final class PressGestureScopeImpl implements i, o0.e {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ o0.e f2748a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2749b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2750c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.sync.a f2751d = kotlinx.coroutines.sync.g.a(false);

    public PressGestureScopeImpl(o0.e eVar) {
        this.f2748a = eVar;
    }

    @Override // o0.n
    public float C0() {
        return this.f2748a.C0();
    }

    @Override // o0.e
    public float E0(float f11) {
        return this.f2748a.E0(f11);
    }

    @Override // o0.n
    public long H(float f11) {
        return this.f2748a.H(f11);
    }

    @Override // o0.n
    public float J(long j11) {
        return this.f2748a.J(j11);
    }

    @Override // o0.e
    public long Q(float f11) {
        return this.f2748a.Q(f11);
    }

    @Override // o0.e
    public long Q0(long j11) {
        return this.f2748a.Q0(j11);
    }

    @Override // o0.e
    public int c0(float f11) {
        return this.f2748a.c0(f11);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.foundation.gestures.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f0(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1 r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1 r0 = new androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.gestures.PressGestureScopeImpl r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl) r0
            kotlin.ResultKt.b(r6)
            goto L4f
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.b(r6)
            boolean r6 = r5.f2749b
            if (r6 != 0) goto L55
            boolean r6 = r5.f2750c
            if (r6 != 0) goto L55
            kotlinx.coroutines.sync.a r6 = r5.f2751d
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = kotlinx.coroutines.sync.a.C0842a.a(r6, r3, r0, r4, r3)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r0 = r5
        L4f:
            kotlinx.coroutines.sync.a r6 = r0.f2751d
            kotlinx.coroutines.sync.a.C0842a.c(r6, r3, r4, r3)
            goto L56
        L55:
            r0 = r5
        L56:
            boolean r6 = r0.f2749b
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.PressGestureScopeImpl.f0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // o0.e
    public float getDensity() {
        return this.f2748a.getDensity();
    }

    @Override // o0.e
    public float h0(long j11) {
        return this.f2748a.h0(j11);
    }

    public final void n() {
        this.f2750c = true;
        a.C0842a.c(this.f2751d, null, 1, null);
    }

    public final void v() {
        this.f2749b = true;
        a.C0842a.c(this.f2751d, null, 1, null);
    }

    @Override // o0.e
    public float x0(int i11) {
        return this.f2748a.x0(i11);
    }

    @Override // o0.e
    public float y0(float f11) {
        return this.f2748a.y0(f11);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1 r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1 r0 = new androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.gestures.PressGestureScopeImpl r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl) r0
            kotlin.ResultKt.b(r5)
            goto L47
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.sync.a r5 = r4.f2751d
            r0.L$0 = r4
            r0.label = r3
            r2 = 0
            java.lang.Object r5 = kotlinx.coroutines.sync.a.C0842a.a(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L46
            return r1
        L46:
            r0 = r4
        L47:
            r5 = 0
            r0.f2749b = r5
            r0.f2750c = r5
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.PressGestureScopeImpl.z(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
