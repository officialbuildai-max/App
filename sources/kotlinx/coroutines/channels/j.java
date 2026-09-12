package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.w;

/* loaded from: classes7.dex */
public final class j extends w {

    /* renamed from: e, reason: collision with root package name */
    private final BufferedChannel f67817e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f67818f;

    public j(long j11, j jVar, BufferedChannel bufferedChannel, int i11) {
        super(j11, jVar, i11);
        this.f67817e = bufferedChannel;
        this.f67818f = new AtomicReferenceArray(BufferedChannelKt.f67785b * 2);
    }

    private final void E(int i11, Object obj) {
        z().set(i11 * 2, obj);
    }

    private final /* synthetic */ AtomicReferenceArray z() {
        return this.f67818f;
    }

    public final Object A(int i11) {
        return z().get(i11 * 2);
    }

    public final Object B(int i11) {
        return z().get((i11 * 2) + 1);
    }

    public final void C(int i11, boolean z10) {
        if (z10) {
            y().m1((this.f68010c * BufferedChannelKt.f67785b) + i11);
        }
        t();
    }

    public final Object D(int i11) {
        Object A = A(i11);
        w(i11);
        return A;
    }

    public final void F(int i11, Object obj) {
        z().set((i11 * 2) + 1, obj);
    }

    public final void G(int i11, Object obj) {
        E(i11, obj);
    }

    @Override // kotlinx.coroutines.internal.w
    public int r() {
        return BufferedChannelKt.f67785b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0063, code lost:
    
        w(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0066, code lost:
    
        if (r0 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0068, code lost:
    
        r4 = y().f67779b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x006e, code lost:
    
        if (r4 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0070, code lost:
    
        kotlinx.coroutines.internal.s.a(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(int r4, java.lang.Throwable r5, kotlin.coroutines.CoroutineContext r6) {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f67785b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.A(r4)
        Le:
            java.lang.Object r1 = r3.B(r4)
            boolean r2 = r1 instanceof kotlinx.coroutines.s2
            if (r2 != 0) goto L74
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.s
            if (r2 == 0) goto L1b
            goto L74
        L1b:
            kotlinx.coroutines.internal.z r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            if (r1 == r2) goto L63
            kotlinx.coroutines.internal.z r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
            if (r1 != r2) goto L28
            goto L63
        L28:
            kotlinx.coroutines.internal.z r2 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r1 == r2) goto Le
            kotlinx.coroutines.internal.z r2 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            kotlinx.coroutines.internal.z r4 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r1 == r4) goto L62
            kotlinx.coroutines.internal.z r4 = kotlinx.coroutines.channels.BufferedChannelKt.f67787d
            if (r1 != r4) goto L40
            goto L62
        L40:
            kotlinx.coroutines.internal.z r4 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            if (r1 != r4) goto L47
            return
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            return
        L63:
            r3.w(r4)
            if (r0 == 0) goto L73
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.y()
            kotlin.jvm.functions.Function1 r4 = r4.f67779b
            if (r4 == 0) goto L73
            kotlinx.coroutines.internal.s.a(r4, r5, r6)
        L73:
            return
        L74:
            if (r0 == 0) goto L7b
            kotlinx.coroutines.internal.z r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            goto L7f
        L7b:
            kotlinx.coroutines.internal.z r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
        L7f:
            boolean r1 = r3.v(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.w(r4)
            r1 = r0 ^ 1
            r3.C(r4, r1)
            if (r0 == 0) goto L9a
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.y()
            kotlin.jvm.functions.Function1 r4 = r4.f67779b
            if (r4 == 0) goto L9a
            kotlinx.coroutines.internal.s.a(r4, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.j.s(int, java.lang.Throwable, kotlin.coroutines.CoroutineContext):void");
    }

    public final boolean v(int i11, Object obj, Object obj2) {
        return i.a(z(), (i11 * 2) + 1, obj, obj2);
    }

    public final void w(int i11) {
        E(i11, null);
    }

    public final Object x(int i11, Object obj) {
        return z().getAndSet((i11 * 2) + 1, obj);
    }

    public final BufferedChannel y() {
        BufferedChannel bufferedChannel = this.f67817e;
        Intrinsics.e(bufferedChannel);
        return bufferedChannel;
    }
}
