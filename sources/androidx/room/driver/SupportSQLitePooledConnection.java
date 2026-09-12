package androidx.room.driver;

import androidx.room.Transactor;
import androidx.room.coroutines.j;
import androidx.room.n0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class SupportSQLitePooledConnection implements Transactor, j {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.room.driver.a f14738a;

    /* renamed from: b, reason: collision with root package name */
    private Transactor.SQLiteTransactionType f14739b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a implements n0, j {
        public a() {
        }

        @Override // androidx.room.coroutines.j
        public z3.b c() {
            return SupportSQLitePooledConnection.this.c();
        }

        @Override // androidx.room.p
        public Object d(String str, Function1 function1, Continuation continuation) {
            return SupportSQLitePooledConnection.this.d(str, function1, continuation);
        }
    }

    /* loaded from: classes2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14741a;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14741a = iArr;
        }
    }

    public SupportSQLitePooledConnection(androidx.room.driver.a delegate) {
        Intrinsics.h(delegate, "delegate");
        this.f14738a = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Enum, androidx.room.Transactor$SQLiteTransactionType] */
    /* JADX WARN: Type inference failed for: r7v1, types: [a4.d] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.room.driver.SupportSQLitePooledConnection] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(androidx.room.Transactor.SQLiteTransactionType r7, kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.room.driver.SupportSQLitePooledConnection$transaction$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.driver.SupportSQLitePooledConnection$transaction$1 r0 = (androidx.room.driver.SupportSQLitePooledConnection$transaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.driver.SupportSQLitePooledConnection$transaction$1 r0 = new androidx.room.driver.SupportSQLitePooledConnection$transaction$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r7 = r0.L$1
            a4.d r7 = (a4.d) r7
            java.lang.Object r8 = r0.L$0
            androidx.room.driver.SupportSQLitePooledConnection r8 = (androidx.room.driver.SupportSQLitePooledConnection) r8
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L32 androidx.room.coroutines.ConnectionPool.RollbackException -> L35
            goto L88
        L32:
            r9 = move-exception
            goto Lb2
        L35:
            r9 = move-exception
            goto La2
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            kotlin.ResultKt.b(r9)
            androidx.room.driver.a r9 = r6.f14738a
            a4.d r9 = r9.d()
            boolean r2 = r9.s0()
            if (r2 != 0) goto L51
            r6.f14739b = r7
        L51:
            int[] r2 = androidx.room.driver.SupportSQLitePooledConnection.b.f14741a
            int r7 = r7.ordinal()
            r7 = r2[r7]
            if (r7 == r4) goto L6f
            r2 = 2
            if (r7 == r2) goto L6b
            r2 = 3
            if (r7 != r2) goto L65
            r9.A()
            goto L72
        L65:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L6b:
            r9.K()
            goto L72
        L6f:
            r9.Y()
        L72:
            androidx.room.driver.SupportSQLitePooledConnection$a r7 = new androidx.room.driver.SupportSQLitePooledConnection$a     // Catch: java.lang.Throwable -> L97 androidx.room.coroutines.ConnectionPool.RollbackException -> L9d
            r7.<init>()     // Catch: java.lang.Throwable -> L97 androidx.room.coroutines.ConnectionPool.RollbackException -> L9d
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L97 androidx.room.coroutines.ConnectionPool.RollbackException -> L9d
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L97 androidx.room.coroutines.ConnectionPool.RollbackException -> L9d
            r0.label = r4     // Catch: java.lang.Throwable -> L97 androidx.room.coroutines.ConnectionPool.RollbackException -> L9d
            java.lang.Object r7 = r8.invoke(r7, r0)     // Catch: java.lang.Throwable -> L97 androidx.room.coroutines.ConnectionPool.RollbackException -> L9d
            if (r7 != r1) goto L84
            return r1
        L84:
            r8 = r6
            r5 = r9
            r9 = r7
            r7 = r5
        L88:
            r7.I()     // Catch: java.lang.Throwable -> L32 androidx.room.coroutines.ConnectionPool.RollbackException -> L35
            r7.L()
            boolean r7 = r7.s0()
            if (r7 != 0) goto L96
            r8.f14739b = r3
        L96:
            return r9
        L97:
            r7 = move-exception
            r8 = r6
            r5 = r9
            r9 = r7
            r7 = r5
            goto Lb2
        L9d:
            r7 = move-exception
            r8 = r6
            r5 = r9
            r9 = r7
            r7 = r5
        La2:
            java.lang.Object r9 = r9.getResult()     // Catch: java.lang.Throwable -> L32
            r7.L()
            boolean r7 = r7.s0()
            if (r7 != 0) goto Lb1
            r8.f14739b = r3
        Lb1:
            return r9
        Lb2:
            r7.L()
            boolean r7 = r7.s0()
            if (r7 != 0) goto Lbd
            r8.f14739b = r3
        Lbd:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.driver.SupportSQLitePooledConnection.f(androidx.room.Transactor$SQLiteTransactionType, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.room.Transactor
    public Object a(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, Continuation continuation) {
        return f(sQLiteTransactionType, function2, continuation);
    }

    @Override // androidx.room.Transactor
    public Object b(Continuation continuation) {
        return Boxing.a(this.f14738a.d().s0());
    }

    @Override // androidx.room.coroutines.j
    public z3.b c() {
        return this.f14738a;
    }

    @Override // androidx.room.p
    public Object d(String str, Function1 function1, Continuation continuation) {
        d D0 = this.f14738a.D0(str);
        try {
            Object invoke = function1.invoke(D0);
            AutoCloseableKt.a(D0, null);
            return invoke;
        } finally {
        }
    }
}
