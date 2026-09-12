package androidx.room.coroutines;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Pool {

    /* renamed from: a, reason: collision with root package name */
    private final int f14696a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f14697b;

    /* renamed from: c, reason: collision with root package name */
    private final ReentrantLock f14698c;

    /* renamed from: d, reason: collision with root package name */
    private int f14699d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f14700e;

    /* renamed from: f, reason: collision with root package name */
    private final i[] f14701f;

    /* renamed from: g, reason: collision with root package name */
    private final kotlinx.coroutines.sync.h f14702g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.collection.e f14703h;

    public Pool(int i11, Function0 connectionFactory) {
        Intrinsics.h(connectionFactory, "connectionFactory");
        this.f14696a = i11;
        this.f14697b = connectionFactory;
        this.f14698c = new ReentrantLock();
        this.f14701f = new i[i11];
        this.f14702g = k.b(i11, 0, 2, null);
        this.f14703h = new androidx.collection.e(i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f() {
        if (this.f14699d >= this.f14696a) {
            return;
        }
        i iVar = new i((z3.b) this.f14697b.invoke(), null, 2, 0 == true ? 1 : 0);
        i[] iVarArr = this.f14701f;
        int i11 = this.f14699d;
        this.f14699d = i11 + 1;
        iVarArr[i11] = iVar;
        this.f14703h.a(iVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: all -> 0x005b, TryCatch #1 {all -> 0x005b, blocks: (B:13:0x004b, B:15:0x004f, B:17:0x0057, B:18:0x005d, B:22:0x006b, B:23:0x0077), top: B:12:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[Catch: all -> 0x005b, TRY_ENTER, TryCatch #1 {all -> 0x005b, blocks: (B:13:0x004b, B:15:0x004f, B:17:0x0057, B:18:0x005d, B:22:0x006b, B:23:0x0077), top: B:12:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.room.coroutines.Pool$acquire$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.room.coroutines.Pool$acquire$1 r0 = (androidx.room.coroutines.Pool$acquire$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquire$1 r0 = new androidx.room.coroutines.Pool$acquire$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.Pool r0 = (androidx.room.coroutines.Pool) r0
            kotlin.ResultKt.b(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.sync.h r5 = r4.f14702g
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.c(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            java.util.concurrent.locks.ReentrantLock r5 = r0.f14698c     // Catch: java.lang.Throwable -> L69
            r5.lock()     // Catch: java.lang.Throwable -> L69
            boolean r1 = r0.f14700e     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L6b
            androidx.collection.e r1 = r0.f14703h     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r1.d()     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L5d
            r0.f()     // Catch: java.lang.Throwable -> L5b
            goto L5d
        L5b:
            r1 = move-exception
            goto L78
        L5d:
            androidx.collection.e r1 = r0.f14703h     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r1 = r1.e()     // Catch: java.lang.Throwable -> L5b
            androidx.room.coroutines.i r1 = (androidx.room.coroutines.i) r1     // Catch: java.lang.Throwable -> L5b
            r5.unlock()     // Catch: java.lang.Throwable -> L69
            return r1
        L69:
            r5 = move-exception
            goto L7c
        L6b:
            java.lang.String r1 = "Connection pool is closed"
            r2 = 21
            z3.a.b(r2, r1)     // Catch: java.lang.Throwable -> L5b
            kotlin.KotlinNothingValueException r1 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L5b
            r1.<init>()     // Catch: java.lang.Throwable -> L5b
            throw r1     // Catch: java.lang.Throwable -> L5b
        L78:
            r5.unlock()     // Catch: java.lang.Throwable -> L69
            throw r1     // Catch: java.lang.Throwable -> L69
        L7c:
            kotlinx.coroutines.sync.h r0 = r0.f14702g
            r0.release()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:13|14|(1:(1:33)(2:30|(1:32)))(1:16)|17|18|19|20|(1:22)(10:24|12|13|14|(0)(0)|17|18|19|20|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        r12 = r12;
        r11 = r11;
        r2 = r0;
        r0 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0076 A[Catch: all -> 0x007a, TryCatch #2 {all -> 0x007a, blocks: (B:14:0x0072, B:16:0x0076, B:30:0x007e, B:33:0x0085), top: B:13:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0061 -> B:12:0x0063). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r9, kotlin.jvm.functions.Function0 r11, kotlin.coroutines.Continuation r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof androidx.room.coroutines.Pool$acquireWithTimeout$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = (androidx.room.coroutines.Pool$acquireWithTimeout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = new androidx.room.coroutines.Pool$acquireWithTimeout$1
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            long r9 = r0.J$0
            java.lang.Object r11 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            java.lang.Object r5 = r0.L$0
            androidx.room.coroutines.Pool r5 = (androidx.room.coroutines.Pool) r5
            kotlin.ResultKt.b(r12)     // Catch: java.lang.Throwable -> L38
            goto L63
        L38:
            r12 = move-exception
            goto L6d
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L42:
            kotlin.ResultKt.b(r12)
            r5 = r8
        L46:
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            androidx.room.coroutines.Pool$acquireWithTimeout$2 r2 = new androidx.room.coroutines.Pool$acquireWithTimeout$2     // Catch: java.lang.Throwable -> L68
            r2.<init>(r12, r5, r4)     // Catch: java.lang.Throwable -> L68
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L68
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L68
            r0.L$2 = r12     // Catch: java.lang.Throwable -> L68
            r0.J$0 = r9     // Catch: java.lang.Throwable -> L68
            r0.label = r3     // Catch: java.lang.Throwable -> L68
            java.lang.Object r2 = kotlinx.coroutines.TimeoutKt.d(r9, r2, r0)     // Catch: java.lang.Throwable -> L68
            if (r2 != r1) goto L61
            return r1
        L61:
            r2 = r11
            r11 = r12
        L63:
            r12 = r11
            r11 = r2
            r2 = r0
            r0 = r4
            goto L72
        L68:
            r2 = move-exception
            r7 = r2
            r2 = r11
            r11 = r12
            r12 = r7
        L6d:
            r7 = r12
            r12 = r11
            r11 = r2
            r2 = r0
            r0 = r7
        L72:
            boolean r6 = r0 instanceof kotlinx.coroutines.TimeoutCancellationException     // Catch: java.lang.Throwable -> L7a
            if (r6 == 0) goto L7c
            r11.invoke()     // Catch: java.lang.Throwable -> L7a
            goto L83
        L7a:
            r9 = move-exception
            goto L86
        L7c:
            if (r0 != 0) goto L85
            T r12 = r12.element     // Catch: java.lang.Throwable -> L7a
            if (r12 == 0) goto L83
            return r12
        L83:
            r0 = r2
            goto L46
        L85:
            throw r0     // Catch: java.lang.Throwable -> L7a
        L86:
            T r10 = r12.element
            androidx.room.coroutines.i r10 = (androidx.room.coroutines.i) r10
            if (r10 == 0) goto L8f
            r5.e(r10)
        L8f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.b(long, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void c() {
        ReentrantLock reentrantLock = this.f14698c;
        reentrantLock.lock();
        try {
            this.f14700e = true;
            for (i iVar : this.f14701f) {
                if (iVar != null) {
                    iVar.close();
                }
            }
            Unit unit = Unit.f67184a;
            reentrantLock.unlock();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final void d(StringBuilder builder) {
        Intrinsics.h(builder, "builder");
        ReentrantLock reentrantLock = this.f14698c;
        reentrantLock.lock();
        try {
            List c11 = CollectionsKt.c();
            int f11 = this.f14703h.f();
            for (int i11 = 0; i11 < f11; i11++) {
                c11.add(this.f14703h.c(i11));
            }
            List a11 = CollectionsKt.a(c11);
            builder.append('\t' + super.toString() + " (");
            builder.append("capacity=" + this.f14696a + ", ");
            builder.append("permits=" + this.f14702g.a() + ", ");
            builder.append("queue=(size=" + a11.size() + ")[" + CollectionsKt.s0(a11, null, null, null, 0, null, null, 63, null) + "], ");
            builder.append(")");
            builder.append('\n');
            i[] iVarArr = this.f14701f;
            int length = iVarArr.length;
            int i12 = 0;
            for (int i13 = 0; i13 < length; i13++) {
                i iVar = iVarArr[i13];
                i12++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\t\t[");
                sb2.append(i12);
                sb2.append("] - ");
                sb2.append(iVar != null ? iVar.toString() : null);
                builder.append(sb2.toString());
                builder.append('\n');
                if (iVar != null) {
                    iVar.i(builder);
                }
            }
            Unit unit = Unit.f67184a;
            reentrantLock.unlock();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final void e(i connection) {
        Intrinsics.h(connection, "connection");
        ReentrantLock reentrantLock = this.f14698c;
        reentrantLock.lock();
        try {
            this.f14703h.a(connection);
            Unit unit = Unit.f67184a;
            reentrantLock.unlock();
            this.f14702g.release();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }
}
