package androidx.room.coroutines;

import androidx.room.Transactor;
import androidx.room.n0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AndroidSQLiteDriverPooledConnection implements Transactor, j {

    /* renamed from: a, reason: collision with root package name */
    private final c4.a f14677a;

    /* renamed from: b, reason: collision with root package name */
    private Transactor.SQLiteTransactionType f14678b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a implements n0, j {
        public a() {
        }

        @Override // androidx.room.coroutines.j
        public z3.b c() {
            return AndroidSQLiteDriverPooledConnection.this.c();
        }

        @Override // androidx.room.p
        public Object d(String str, Function1 function1, Continuation continuation) {
            return AndroidSQLiteDriverPooledConnection.this.d(str, function1, continuation);
        }
    }

    /* loaded from: classes2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14680a;

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
            f14680a = iArr;
        }
    }

    public AndroidSQLiteDriverPooledConnection(c4.a delegate) {
        Intrinsics.h(delegate, "delegate");
        this.f14677a = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(androidx.room.Transactor.SQLiteTransactionType r7, kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1 r0 = (androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1 r0 = new androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1
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
            android.database.sqlite.SQLiteDatabase r7 = (android.database.sqlite.SQLiteDatabase) r7
            java.lang.Object r8 = r0.L$0
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection r8 = (androidx.room.coroutines.AndroidSQLiteDriverPooledConnection) r8
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
            c4.a r9 = r6.f14677a
            android.database.sqlite.SQLiteDatabase r9 = r9.d()
            boolean r2 = r9.inTransaction()
            if (r2 != 0) goto L51
            r6.f14678b = r7
        L51:
            int[] r2 = androidx.room.coroutines.AndroidSQLiteDriverPooledConnection.b.f14680a
            int r7 = r7.ordinal()
            r7 = r2[r7]
            if (r7 == r4) goto L6f
            r2 = 2
            if (r7 == r2) goto L6b
            r2 = 3
            if (r7 != r2) goto L65
            r9.beginTransaction()
            goto L72
        L65:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L6b:
            r9.beginTransactionNonExclusive()
            goto L72
        L6f:
            r9.beginTransactionNonExclusive()
        L72:
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$a r7 = new androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$a     // Catch: java.lang.Throwable -> L97 androidx.room.coroutines.ConnectionPool.RollbackException -> L9d
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
            r7.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L32 androidx.room.coroutines.ConnectionPool.RollbackException -> L35
            r7.endTransaction()
            boolean r7 = r7.inTransaction()
            if (r7 != 0) goto L96
            r8.f14678b = r3
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
            r7.endTransaction()
            boolean r7 = r7.inTransaction()
            if (r7 != 0) goto Lb1
            r8.f14678b = r3
        Lb1:
            return r9
        Lb2:
            r7.endTransaction()
            boolean r7 = r7.inTransaction()
            if (r7 != 0) goto Lbd
            r8.f14678b = r3
        Lbd:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.AndroidSQLiteDriverPooledConnection.g(androidx.room.Transactor$SQLiteTransactionType, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.room.Transactor
    public Object a(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, Continuation continuation) {
        return g(sQLiteTransactionType, function2, continuation);
    }

    @Override // androidx.room.Transactor
    public Object b(Continuation continuation) {
        return Boxing.a(this.f14677a.d().inTransaction());
    }

    @Override // androidx.room.coroutines.j
    public z3.b c() {
        return this.f14677a;
    }

    @Override // androidx.room.p
    public Object d(String str, Function1 function1, Continuation continuation) {
        z3.e D0 = this.f14677a.D0(str);
        try {
            Object invoke = function1.invoke(D0);
            AutoCloseableKt.a(D0, null);
            return invoke;
        } finally {
        }
    }

    public final c4.a f() {
        return this.f14677a;
    }
}
