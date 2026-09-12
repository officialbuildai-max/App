package androidx.room.coroutines;

import android.database.SQLException;
import androidx.room.Transactor;
import androidx.room.n0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class PooledConnectionImpl implements Transactor, j {

    /* renamed from: a, reason: collision with root package name */
    private final i f14704a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f14705b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque f14706c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f14707d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a implements z3.e {

        /* renamed from: a, reason: collision with root package name */
        private final z3.e f14708a;

        /* renamed from: b, reason: collision with root package name */
        private final long f14709b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PooledConnectionImpl f14710c;

        public a(PooledConnectionImpl pooledConnectionImpl, z3.e delegate) {
            Intrinsics.h(delegate, "delegate");
            this.f14710c = pooledConnectionImpl;
            this.f14708a = delegate;
            this.f14709b = x3.d.b();
        }

        @Override // z3.e
        public boolean A0() {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                return this.f14708a.A0();
            }
            z3.a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public void a(int i11, double d11) {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                this.f14708a.a(i11, d11);
            } else {
                z3.a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // z3.e
        public void c(int i11, long j11) {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                this.f14708a.c(i11, j11);
            } else {
                z3.a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // z3.e, java.lang.AutoCloseable
        public void close() {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                this.f14708a.close();
            } else {
                z3.a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // z3.e
        public void e(int i11, byte[] value) {
            Intrinsics.h(value, "value");
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                this.f14708a.e(i11, value);
            } else {
                z3.a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // z3.e
        public void g(int i11) {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                this.f14708a.g(i11);
            } else {
                z3.a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // z3.e
        public byte[] getBlob(int i11) {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                return this.f14708a.getBlob(i11);
            }
            z3.a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public /* synthetic */ boolean getBoolean(int i11) {
            return z3.d.a(this, i11);
        }

        @Override // z3.e
        public int getColumnCount() {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                return this.f14708a.getColumnCount();
            }
            z3.a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public String getColumnName(int i11) {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                return this.f14708a.getColumnName(i11);
            }
            z3.a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public double getDouble(int i11) {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                return this.f14708a.getDouble(i11);
            }
            z3.a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public long getLong(int i11) {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                return this.f14708a.getLong(i11);
            }
            z3.a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public boolean isNull(int i11) {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                return this.f14708a.isNull(i11);
            }
            z3.a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public void j(int i11, String value) {
            Intrinsics.h(value, "value");
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                this.f14708a.j(i11, value);
            } else {
                z3.a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // z3.e
        public String n0(int i11) {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                return this.f14708a.n0(i11);
            }
            z3.a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // z3.e
        public void reset() {
            if (this.f14710c.m()) {
                z3.a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.f14709b == x3.d.b()) {
                this.f14708a.reset();
            } else {
                z3.a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class b implements n0, j {
        public b() {
        }

        @Override // androidx.room.coroutines.j
        public z3.b c() {
            return PooledConnectionImpl.this.c();
        }

        @Override // androidx.room.p
        public Object d(String str, Function1 function1, Continuation continuation) {
            return PooledConnectionImpl.this.d(str, function1, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final int f14712a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f14713b;

        public c(int i11, boolean z10) {
            this.f14712a = i11;
            this.f14713b = z10;
        }

        public final int a() {
            return this.f14712a;
        }

        public final boolean b() {
            return this.f14713b;
        }
    }

    /* loaded from: classes2.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14714a;

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
            f14714a = iArr;
        }
    }

    public PooledConnectionImpl(i delegate, boolean z10) {
        Intrinsics.h(delegate, "delegate");
        this.f14704a = delegate;
        this.f14705b = z10;
        this.f14706c = new ArrayDeque();
        this.f14707d = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0063 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:11:0x0055, B:13:0x0063, B:19:0x0073, B:20:0x00ae, B:24:0x007d, B:25:0x0082, B:26:0x0083, B:27:0x008b, B:28:0x0093), top: B:10:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:11:0x0055, B:13:0x0063, B:19:0x0073, B:20:0x00ae, B:24:0x007d, B:25:0x0082, B:26:0x0083, B:27:0x008b, B:28:0x0093), top: B:10:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v14, types: [kotlinx.coroutines.sync.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(androidx.room.Transactor.SQLiteTransactionType r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) r6
            java.lang.Object r1 = r0.L$1
            androidx.room.Transactor$SQLiteTransactionType r1 = (androidx.room.Transactor.SQLiteTransactionType) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.ResultKt.b(r7)
            androidx.room.coroutines.i r7 = r5.f14704a
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r0 = r7.h(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            kotlin.collections.ArrayDeque r1 = r0.f14706c     // Catch: java.lang.Throwable -> L7b
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L7b
            kotlin.collections.ArrayDeque r2 = r0.f14706c     // Catch: java.lang.Throwable -> L7b
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L7b
            if (r2 == 0) goto L93
            int[] r2 = androidx.room.coroutines.PooledConnectionImpl.d.f14714a     // Catch: java.lang.Throwable -> L7b
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L7b
            r6 = r2[r6]     // Catch: java.lang.Throwable -> L7b
            if (r6 == r3) goto L8b
            r2 = 2
            if (r6 == r2) goto L83
            r2 = 3
            if (r6 != r2) goto L7d
            androidx.room.coroutines.i r6 = r0.f14704a     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = "BEGIN EXCLUSIVE TRANSACTION"
            z3.a.a(r6, r2)     // Catch: java.lang.Throwable -> L7b
            goto Lae
        L7b:
            r6 = move-exception
            goto Lbf
        L7d:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L7b
            r6.<init>()     // Catch: java.lang.Throwable -> L7b
            throw r6     // Catch: java.lang.Throwable -> L7b
        L83:
            androidx.room.coroutines.i r6 = r0.f14704a     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = "BEGIN IMMEDIATE TRANSACTION"
            z3.a.a(r6, r2)     // Catch: java.lang.Throwable -> L7b
            goto Lae
        L8b:
            androidx.room.coroutines.i r6 = r0.f14704a     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = "BEGIN DEFERRED TRANSACTION"
            z3.a.a(r6, r2)     // Catch: java.lang.Throwable -> L7b
            goto Lae
        L93:
            androidx.room.coroutines.i r6 = r0.f14704a     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b
            r2.<init>()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = "SAVEPOINT '"
            r2.append(r3)     // Catch: java.lang.Throwable -> L7b
            r2.append(r1)     // Catch: java.lang.Throwable -> L7b
            r3 = 39
            r2.append(r3)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L7b
            z3.a.a(r6, r2)     // Catch: java.lang.Throwable -> L7b
        Lae:
            kotlin.collections.ArrayDeque r6 = r0.f14706c     // Catch: java.lang.Throwable -> L7b
            androidx.room.coroutines.PooledConnectionImpl$c r0 = new androidx.room.coroutines.PooledConnectionImpl$c     // Catch: java.lang.Throwable -> L7b
            r2 = 0
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> L7b
            r6.addLast(r0)     // Catch: java.lang.Throwable -> L7b
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L7b
            r7.unlock(r4)
            return r6
        Lbf:
            r7.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.i(androidx.room.Transactor$SQLiteTransactionType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[Catch: all -> 0x007c, TryCatch #0 {all -> 0x007c, blocks: (B:11:0x0052, B:13:0x005a, B:15:0x0066, B:17:0x006c, B:19:0x0074, B:20:0x00c9, B:24:0x007e, B:25:0x009c, B:27:0x00a4, B:28:0x00ac, B:29:0x00cf, B:30:0x00d6), top: B:10:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #0 {all -> 0x007c, blocks: (B:11:0x0052, B:13:0x005a, B:15:0x0066, B:17:0x006c, B:19:0x0074, B:20:0x00c9, B:24:0x007e, B:25:0x009c, B:27:0x00a4, B:28:0x00ac, B:29:0x00cf, B:30:0x00d6), top: B:10:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(boolean r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$endTransaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            boolean r6 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            kotlin.ResultKt.b(r7)
            goto L52
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.b(r7)
            androidx.room.coroutines.i r7 = r5.f14704a
            r0.L$0 = r5
            r0.L$1 = r7
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r0 = r7.h(r4, r0)
            if (r0 != r1) goto L50
            return r1
        L50:
            r0 = r5
            r1 = r7
        L52:
            kotlin.collections.ArrayDeque r7 = r0.f14706c     // Catch: java.lang.Throwable -> L7c
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> L7c
            if (r7 != 0) goto Lcf
            kotlin.collections.ArrayDeque r7 = r0.f14706c     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r7 = kotlin.collections.CollectionsKt.L(r7)     // Catch: java.lang.Throwable -> L7c
            androidx.room.coroutines.PooledConnectionImpl$c r7 = (androidx.room.coroutines.PooledConnectionImpl.c) r7     // Catch: java.lang.Throwable -> L7c
            r2 = 39
            if (r6 == 0) goto L9c
            boolean r6 = r7.b()     // Catch: java.lang.Throwable -> L7c
            if (r6 != 0) goto L9c
            kotlin.collections.ArrayDeque r6 = r0.f14706c     // Catch: java.lang.Throwable -> L7c
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> L7c
            if (r6 == 0) goto L7e
            androidx.room.coroutines.i r6 = r0.f14704a     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = "END TRANSACTION"
            z3.a.a(r6, r7)     // Catch: java.lang.Throwable -> L7c
            goto Lc9
        L7c:
            r6 = move-exception
            goto Ld7
        L7e:
            androidx.room.coroutines.i r6 = r0.f14704a     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r0.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = "RELEASE SAVEPOINT '"
            r0.append(r3)     // Catch: java.lang.Throwable -> L7c
            int r7 = r7.a()     // Catch: java.lang.Throwable -> L7c
            r0.append(r7)     // Catch: java.lang.Throwable -> L7c
            r0.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L7c
            z3.a.a(r6, r7)     // Catch: java.lang.Throwable -> L7c
            goto Lc9
        L9c:
            kotlin.collections.ArrayDeque r6 = r0.f14706c     // Catch: java.lang.Throwable -> L7c
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> L7c
            if (r6 == 0) goto Lac
            androidx.room.coroutines.i r6 = r0.f14704a     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = "ROLLBACK TRANSACTION"
            z3.a.a(r6, r7)     // Catch: java.lang.Throwable -> L7c
            goto Lc9
        Lac:
            androidx.room.coroutines.i r6 = r0.f14704a     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r0.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = "ROLLBACK TRANSACTION TO SAVEPOINT '"
            r0.append(r3)     // Catch: java.lang.Throwable -> L7c
            int r7 = r7.a()     // Catch: java.lang.Throwable -> L7c
            r0.append(r7)     // Catch: java.lang.Throwable -> L7c
            r0.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L7c
            z3.a.a(r6, r7)     // Catch: java.lang.Throwable -> L7c
        Lc9:
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L7c
            r1.unlock(r4)
            return r6
        Lcf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = "Not in a transaction"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L7c
            throw r6     // Catch: java.lang.Throwable -> L7c
        Ld7:
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.j(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m() {
        return this.f14707d.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b4 A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #3 {all -> 0x00c8, blocks: (B:42:0x00b0, B:44:0x00b4), top: B:41:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(androidx.room.Transactor.SQLiteTransactionType r12, kotlin.jvm.functions.Function2 r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.o(androidx.room.Transactor$SQLiteTransactionType, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.room.Transactor
    public Object a(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, Continuation continuation) {
        if (m()) {
            z3.a.b(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        androidx.room.coroutines.c cVar = (androidx.room.coroutines.c) continuation.getF67151a().get(androidx.room.coroutines.c.f14719b);
        if (cVar != null && cVar.a() == this) {
            return o(sQLiteTransactionType, function2, continuation);
        }
        z3.a.b(21, "Attempted to use connection on a different coroutine");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.Transactor
    public Object b(Continuation continuation) {
        if (m()) {
            z3.a.b(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        androidx.room.coroutines.c cVar = (androidx.room.coroutines.c) continuation.getF67151a().get(androidx.room.coroutines.c.f14719b);
        if (cVar != null && cVar.a() == this) {
            return Boxing.a(!this.f14706c.isEmpty());
        }
        z3.a.b(21, "Attempted to use connection on a different coroutine");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.coroutines.j
    public z3.b c() {
        return this.f14704a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r7v12, types: [kotlinx.coroutines.sync.a] */
    @Override // androidx.room.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.lang.String r7, kotlin.jvm.functions.Function1 r8, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$usePrepared$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r7 = r0.L$3
            kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) r7
            java.lang.Object r8 = r0.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            kotlin.ResultKt.b(r9)
            r9 = r7
            r7 = r1
            goto L77
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            kotlin.ResultKt.b(r9)
            boolean r9 = g(r6)
            r2 = 21
            if (r9 != 0) goto La5
            kotlin.coroutines.CoroutineContext r9 = r0.getF67151a()
            androidx.room.coroutines.c$a r5 = androidx.room.coroutines.c.f14719b
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r5)
            androidx.room.coroutines.c r9 = (androidx.room.coroutines.c) r9
            if (r9 == 0) goto L9a
            androidx.room.coroutines.PooledConnectionImpl r9 = r9.a()
            if (r9 != r6) goto L9a
            androidx.room.coroutines.i r9 = r6.f14704a
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.L$3 = r9
            r0.label = r3
            java.lang.Object r0 = r9.h(r4, r0)
            if (r0 != r1) goto L76
            return r1
        L76:
            r0 = r6
        L77:
            androidx.room.coroutines.PooledConnectionImpl$a r1 = new androidx.room.coroutines.PooledConnectionImpl$a     // Catch: java.lang.Throwable -> L8d
            androidx.room.coroutines.i r2 = r0.f14704a     // Catch: java.lang.Throwable -> L8d
            z3.e r7 = r2.D0(r7)     // Catch: java.lang.Throwable -> L8d
            r1.<init>(r0, r7)     // Catch: java.lang.Throwable -> L8d
            java.lang.Object r7 = r8.invoke(r1)     // Catch: java.lang.Throwable -> L8f
            kotlin.jdk7.AutoCloseableKt.a(r1, r4)     // Catch: java.lang.Throwable -> L8d
            r9.unlock(r4)
            return r7
        L8d:
            r7 = move-exception
            goto L96
        L8f:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L91
        L91:
            r8 = move-exception
            kotlin.jdk7.AutoCloseableKt.a(r1, r7)     // Catch: java.lang.Throwable -> L8d
            throw r8     // Catch: java.lang.Throwable -> L8d
        L96:
            r9.unlock(r4)
            throw r7
        L9a:
            java.lang.String r7 = "Attempted to use connection on a different coroutine"
            z3.a.b(r2, r7)
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        La5:
            java.lang.String r7 = "Connection is recycled"
            z3.a.b(r2, r7)
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.d(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final i k() {
        return this.f14704a;
    }

    public final boolean l() {
        return this.f14705b;
    }

    public final void n() {
        if (this.f14707d.compareAndSet(false, true)) {
            try {
                z3.a.a(this.f14704a, "ROLLBACK TRANSACTION");
            } catch (SQLException unused) {
            }
        }
    }
}
