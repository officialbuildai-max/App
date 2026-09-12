package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: classes.dex */
public class SharedFlowImpl extends kotlinx.coroutines.flow.internal.a implements x0, kotlinx.coroutines.flow.b, kotlinx.coroutines.flow.internal.j {

    /* renamed from: e, reason: collision with root package name */
    private final int f67876e;

    /* renamed from: f, reason: collision with root package name */
    private final int f67877f;

    /* renamed from: g, reason: collision with root package name */
    private final BufferOverflow f67878g;

    /* renamed from: h, reason: collision with root package name */
    private Object[] f67879h;

    /* renamed from: i, reason: collision with root package name */
    private long f67880i;

    /* renamed from: j, reason: collision with root package name */
    private long f67881j;

    /* renamed from: k, reason: collision with root package name */
    private int f67882k;

    /* renamed from: l, reason: collision with root package name */
    private int f67883l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class a implements kotlinx.coroutines.a1 {

        /* renamed from: a, reason: collision with root package name */
        public final SharedFlowImpl f67884a;

        /* renamed from: b, reason: collision with root package name */
        public long f67885b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f67886c;

        /* renamed from: d, reason: collision with root package name */
        public final Continuation f67887d;

        public a(SharedFlowImpl sharedFlowImpl, long j11, Object obj, Continuation continuation) {
            this.f67884a = sharedFlowImpl;
            this.f67885b = j11;
            this.f67886c = obj;
            this.f67887d = continuation;
        }

        @Override // kotlinx.coroutines.a1
        public void dispose() {
            this.f67884a.z(this);
        }
    }

    /* loaded from: classes7.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f67888a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f67888a = iArr;
        }
    }

    public SharedFlowImpl(int i11, int i12, BufferOverflow bufferOverflow) {
        this.f67876e = i11;
        this.f67877f = i12;
        this.f67878g = bufferOverflow;
    }

    private final void A() {
        Object f11;
        if (this.f67877f != 0 || this.f67883l > 1) {
            Object[] objArr = this.f67879h;
            Intrinsics.e(objArr);
            while (this.f67883l > 0) {
                f11 = d1.f(objArr, (L() + Q()) - 1);
                if (f11 != d1.f67899a) {
                    return;
                }
                this.f67883l--;
                d1.g(objArr, L() + Q(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a A[Catch: all -> 0x0042, TryCatch #1 {all -> 0x0042, blocks: (B:14:0x003b, B:18:0x0092, B:20:0x009a, B:28:0x00ad, B:29:0x00b0, B:36:0x005d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlinx.coroutines.flow.internal.a] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, kotlinx.coroutines.flow.SharedFlowImpl] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlinx.coroutines.flow.c] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [kotlinx.coroutines.flow.e1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v9, types: [kotlinx.coroutines.flow.e1] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00be -> B:15:0x003e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object B(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.c r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.B(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void C(long j11) {
        kotlinx.coroutines.flow.internal.c[] h11;
        if (kotlinx.coroutines.flow.internal.a.g(this) != 0 && (h11 = kotlinx.coroutines.flow.internal.a.h(this)) != null) {
            for (kotlinx.coroutines.flow.internal.c cVar : h11) {
                if (cVar != null) {
                    e1 e1Var = (e1) cVar;
                    long j12 = e1Var.f67900a;
                    if (j12 >= 0 && j12 < j11) {
                        e1Var.f67900a = j11;
                    }
                }
            }
        }
        this.f67881j = j11;
    }

    private final void F() {
        Object[] objArr = this.f67879h;
        Intrinsics.e(objArr);
        d1.g(objArr, L(), null);
        this.f67882k--;
        long L = L() + 1;
        if (this.f67880i < L) {
            this.f67880i = L;
        }
        if (this.f67881j < L) {
            C(L);
        }
    }

    static /* synthetic */ Object G(SharedFlowImpl sharedFlowImpl, Object obj, Continuation continuation) {
        Object H;
        return (!sharedFlowImpl.b(obj) && (H = sharedFlowImpl.H(obj, continuation)) == IntrinsicsKt.f()) ? H : Unit.f67184a;
    }

    private final Object H(Object obj, Continuation continuation) {
        Continuation[] continuationArr;
        a aVar;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation[] continuationArr2 = kotlinx.coroutines.flow.internal.b.f67930a;
        synchronized (this) {
            try {
                if (S(obj)) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
                    continuationArr = J(continuationArr2);
                    aVar = null;
                } else {
                    a aVar2 = new a(this, Q() + L(), obj, cancellableContinuationImpl);
                    I(aVar2);
                    this.f67883l++;
                    if (this.f67877f == 0) {
                        continuationArr2 = J(continuationArr2);
                    }
                    continuationArr = continuationArr2;
                    aVar = aVar2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (aVar != null) {
            kotlinx.coroutines.q.a(cancellableContinuationImpl, aVar);
        }
        for (Continuation continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(Object obj) {
        int Q = Q();
        Object[] objArr = this.f67879h;
        if (objArr == null) {
            objArr = R(null, 0, 2);
        } else if (Q >= objArr.length) {
            objArr = R(objArr, Q, objArr.length * 2);
        }
        d1.g(objArr, L() + Q, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    public final Continuation[] J(Continuation[] continuationArr) {
        kotlinx.coroutines.flow.internal.c[] h11;
        e1 e1Var;
        Continuation continuation;
        int length = continuationArr.length;
        if (kotlinx.coroutines.flow.internal.a.g(this) != 0 && (h11 = kotlinx.coroutines.flow.internal.a.h(this)) != null) {
            int length2 = h11.length;
            int i11 = 0;
            continuationArr = continuationArr;
            while (i11 < length2) {
                kotlinx.coroutines.flow.internal.c cVar = h11[i11];
                if (cVar != null && (continuation = (e1Var = (e1) cVar).f67901b) != null && U(e1Var) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.g(copyOf, "copyOf(...)");
                        continuationArr = copyOf;
                    }
                    continuationArr[length] = continuation;
                    e1Var.f67901b = null;
                    length++;
                }
                i11++;
                continuationArr = continuationArr;
            }
        }
        return continuationArr;
    }

    private final long K() {
        return L() + this.f67882k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long L() {
        return Math.min(this.f67881j, this.f67880i);
    }

    private final Object N(long j11) {
        Object f11;
        Object[] objArr = this.f67879h;
        Intrinsics.e(objArr);
        f11 = d1.f(objArr, j11);
        return f11 instanceof a ? ((a) f11).f67886c : f11;
    }

    private final long O() {
        return L() + this.f67882k + this.f67883l;
    }

    private final int P() {
        return (int) ((L() + this.f67882k) - this.f67880i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Q() {
        return this.f67882k + this.f67883l;
    }

    private final Object[] R(Object[] objArr, int i11, int i12) {
        Object f11;
        if (i12 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i12];
        this.f67879h = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long L = L();
        for (int i13 = 0; i13 < i11; i13++) {
            long j11 = i13 + L;
            f11 = d1.f(objArr, j11);
            d1.g(objArr2, j11, f11);
        }
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean S(Object obj) {
        if (m() == 0) {
            return T(obj);
        }
        if (this.f67882k >= this.f67877f && this.f67881j <= this.f67880i) {
            int i11 = b.f67888a[this.f67878g.ordinal()];
            if (i11 == 1) {
                return false;
            }
            if (i11 == 2) {
                return true;
            }
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        I(obj);
        int i12 = this.f67882k + 1;
        this.f67882k = i12;
        if (i12 > this.f67877f) {
            F();
        }
        if (P() > this.f67876e) {
            W(this.f67880i + 1, this.f67881j, K(), O());
        }
        return true;
    }

    private final boolean T(Object obj) {
        if (this.f67876e == 0) {
            return true;
        }
        I(obj);
        int i11 = this.f67882k + 1;
        this.f67882k = i11;
        if (i11 > this.f67876e) {
            F();
        }
        this.f67881j = L() + this.f67882k;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long U(e1 e1Var) {
        long j11 = e1Var.f67900a;
        if (j11 < K()) {
            return j11;
        }
        if (this.f67877f <= 0 && j11 <= L() && this.f67883l != 0) {
            return j11;
        }
        return -1L;
    }

    private final Object V(e1 e1Var) {
        Object obj;
        Continuation[] continuationArr = kotlinx.coroutines.flow.internal.b.f67930a;
        synchronized (this) {
            try {
                long U = U(e1Var);
                if (U < 0) {
                    obj = d1.f67899a;
                } else {
                    long j11 = e1Var.f67900a;
                    Object N = N(U);
                    e1Var.f67900a = U + 1;
                    continuationArr = X(j11);
                    obj = N;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        for (Continuation continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
            }
        }
        return obj;
    }

    private final void W(long j11, long j12, long j13, long j14) {
        long min = Math.min(j12, j11);
        for (long L = L(); L < min; L++) {
            Object[] objArr = this.f67879h;
            Intrinsics.e(objArr);
            d1.g(objArr, L, null);
        }
        this.f67880i = j11;
        this.f67881j = j12;
        this.f67882k = (int) (j13 - min);
        this.f67883l = (int) (j14 - j13);
    }

    private final Object y(e1 e1Var, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (U(e1Var) < 0) {
                    e1Var.f67901b = cancellableContinuationImpl;
                } else {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(a aVar) {
        Object f11;
        synchronized (this) {
            if (aVar.f67885b < L()) {
                return;
            }
            Object[] objArr = this.f67879h;
            Intrinsics.e(objArr);
            f11 = d1.f(objArr, aVar.f67885b);
            if (f11 != aVar) {
                return;
            }
            d1.g(objArr, aVar.f67885b, d1.f67899a);
            A();
            Unit unit = Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public e1 j() {
        return new e1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public e1[] k(int i11) {
        return new e1[i11];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object M() {
        Object f11;
        Object[] objArr = this.f67879h;
        Intrinsics.e(objArr);
        f11 = d1.f(objArr, (this.f67880i + P()) - 1);
        return f11;
    }

    public final Continuation[] X(long j11) {
        long j12;
        long j13;
        Object f11;
        Object f12;
        long j14;
        kotlinx.coroutines.flow.internal.c[] h11;
        if (j11 > this.f67881j) {
            return kotlinx.coroutines.flow.internal.b.f67930a;
        }
        long L = L();
        long j15 = this.f67882k + L;
        if (this.f67877f == 0 && this.f67883l > 0) {
            j15++;
        }
        if (kotlinx.coroutines.flow.internal.a.g(this) != 0 && (h11 = kotlinx.coroutines.flow.internal.a.h(this)) != null) {
            for (kotlinx.coroutines.flow.internal.c cVar : h11) {
                if (cVar != null) {
                    long j16 = ((e1) cVar).f67900a;
                    if (j16 >= 0 && j16 < j15) {
                        j15 = j16;
                    }
                }
            }
        }
        if (j15 <= this.f67881j) {
            return kotlinx.coroutines.flow.internal.b.f67930a;
        }
        long K = K();
        int min = m() > 0 ? Math.min(this.f67883l, this.f67877f - ((int) (K - j15))) : this.f67883l;
        Continuation[] continuationArr = kotlinx.coroutines.flow.internal.b.f67930a;
        long j17 = this.f67883l + K;
        if (min > 0) {
            continuationArr = new Continuation[min];
            Object[] objArr = this.f67879h;
            Intrinsics.e(objArr);
            long j18 = K;
            int i11 = 0;
            while (true) {
                if (K >= j17) {
                    j12 = j15;
                    j13 = j17;
                    break;
                }
                f12 = d1.f(objArr, K);
                j12 = j15;
                kotlinx.coroutines.internal.z zVar = d1.f67899a;
                if (f12 != zVar) {
                    Intrinsics.f(f12, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) f12;
                    int i12 = i11 + 1;
                    j13 = j17;
                    continuationArr[i11] = aVar.f67887d;
                    d1.g(objArr, K, zVar);
                    d1.g(objArr, j18, aVar.f67886c);
                    j14 = 1;
                    j18++;
                    if (i12 >= min) {
                        break;
                    }
                    i11 = i12;
                } else {
                    j13 = j17;
                    j14 = 1;
                }
                K += j14;
                j15 = j12;
                j17 = j13;
            }
            K = j18;
        } else {
            j12 = j15;
            j13 = j17;
        }
        int i13 = (int) (K - L);
        long j19 = m() == 0 ? K : j12;
        long max = Math.max(this.f67880i, K - Math.min(this.f67876e, i13));
        if (this.f67877f == 0 && max < j13) {
            Object[] objArr2 = this.f67879h;
            Intrinsics.e(objArr2);
            f11 = d1.f(objArr2, max);
            if (Intrinsics.c(f11, d1.f67899a)) {
                K++;
                max++;
            }
        }
        W(max, j19, K, j13);
        A();
        return !(continuationArr.length == 0) ? J(continuationArr) : continuationArr;
    }

    public final long Y() {
        long j11 = this.f67880i;
        if (j11 < this.f67881j) {
            this.f67881j = j11;
        }
        return j11;
    }

    @Override // kotlinx.coroutines.flow.c1, kotlinx.coroutines.flow.b
    public Object a(c cVar, Continuation continuation) {
        return B(this, cVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.x0
    public boolean b(Object obj) {
        int i11;
        boolean z10;
        Continuation[] continuationArr = kotlinx.coroutines.flow.internal.b.f67930a;
        synchronized (this) {
            if (S(obj)) {
                continuationArr = J(continuationArr);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (Continuation continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
            }
        }
        return z10;
    }

    @Override // kotlinx.coroutines.flow.internal.j
    public kotlinx.coroutines.flow.b d(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return d1.e(this, coroutineContext, i11, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.x0, kotlinx.coroutines.flow.c
    public Object emit(Object obj, Continuation continuation) {
        return G(this, obj, continuation);
    }

    @Override // kotlinx.coroutines.flow.x0
    public void f() {
        synchronized (this) {
            W(K(), this.f67881j, K(), O());
            Unit unit = Unit.f67184a;
        }
    }
}
