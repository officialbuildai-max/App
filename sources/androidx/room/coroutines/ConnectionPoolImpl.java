package androidx.room.coroutines;

import android.database.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* loaded from: classes2.dex */
public final class ConnectionPoolImpl implements ConnectionPool {

    /* renamed from: a, reason: collision with root package name */
    private final z3.c f14681a;

    /* renamed from: b, reason: collision with root package name */
    private final Pool f14682b;

    /* renamed from: c, reason: collision with root package name */
    private final Pool f14683c;

    /* renamed from: d, reason: collision with root package name */
    private final ThreadLocal f14684d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f14685e;

    /* renamed from: f, reason: collision with root package name */
    private long f14686f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f14687g;

    public ConnectionPoolImpl(final z3.c driver, final String fileName) {
        Intrinsics.h(driver, "driver");
        Intrinsics.h(fileName, "fileName");
        this.f14684d = new ThreadLocal();
        this.f14685e = new AtomicBoolean(false);
        Duration.Companion companion = Duration.INSTANCE;
        this.f14686f = DurationKt.s(30, DurationUnit.SECONDS);
        this.f14681a = driver;
        Pool pool = new Pool(1, new Function0() { // from class: androidx.room.coroutines.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                z3.b k11;
                k11 = ConnectionPoolImpl.k(z3.c.this, fileName);
                return k11;
            }
        });
        this.f14682b = pool;
        this.f14683c = pool;
    }

    public ConnectionPoolImpl(final z3.c driver, final String fileName, int i11, int i12) {
        Intrinsics.h(driver, "driver");
        Intrinsics.h(fileName, "fileName");
        this.f14684d = new ThreadLocal();
        this.f14685e = new AtomicBoolean(false);
        Duration.Companion companion = Duration.INSTANCE;
        this.f14686f = DurationKt.s(30, DurationUnit.SECONDS);
        if (i11 <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0");
        }
        if (i12 <= 0) {
            throw new IllegalArgumentException("Maximum number of writers must be greater than 0");
        }
        this.f14681a = driver;
        this.f14682b = new Pool(i11, new Function0() { // from class: androidx.room.coroutines.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                z3.b l11;
                l11 = ConnectionPoolImpl.l(z3.c.this, fileName);
                return l11;
            }
        });
        this.f14683c = new Pool(i12, new Function0() { // from class: androidx.room.coroutines.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                z3.b m11;
                m11 = ConnectionPoolImpl.m(z3.c.this, fileName);
                return m11;
            }
        });
    }

    private final boolean isClosed() {
        return this.f14685e.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z3.b k(z3.c cVar, String str) {
        return cVar.open(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z3.b l(z3.c cVar, String str) {
        z3.b open = cVar.open(str);
        z3.a.a(open, "PRAGMA query_only = 1");
        return open;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z3.b m(z3.c cVar, String str) {
        return cVar.open(str);
    }

    private final CoroutineContext n(PooledConnectionImpl pooledConnectionImpl) {
        return new c(pooledConnectionImpl).plus(x3.d.a(this.f14684d, pooledConnectionImpl));
    }

    private final void o(boolean z10) {
        String str = z10 ? "reader" : "writer";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Timed out attempting to acquire a " + str + " connection.");
        sb2.append('\n');
        sb2.append('\n');
        sb2.append("Writer pool:");
        sb2.append('\n');
        this.f14683c.d(sb2);
        sb2.append("Reader pool:");
        sb2.append('\n');
        this.f14682b.d(sb2);
        try {
            z3.a.b(5, sb2.toString());
            throw new KotlinNothingValueException();
        } catch (SQLException e11) {
            if (this.f14687g) {
                throw e11;
            }
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(ConnectionPoolImpl connectionPoolImpl, boolean z10) {
        connectionPoolImpl.o(z10);
        return Unit.f67184a;
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this.f14685e.compareAndSet(false, true)) {
            this.f14682b.c();
            this.f14683c.c();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|(1:(2:66|67)(1:(1:(3:12|13|14)(2:41|42))(9:43|44|45|46|47|48|(1:51)|52|(2:54|(1:56)(1:57))(2:58|59))))(2:68|(3:70|(2:72|(1:74)(1:75))|(1:(3:82|(2:84|(1:86))(2:87|(1:89))|67)(2:80|81))(5:(1:91)(1:101)|92|93|94|(1:96)(6:97|47|48|(1:51)|52|(0)(0))))(2:102|103))|15|16|(1:18)|20))|104|6|(0)(0)|15|16|(0)|20|(2:(1:28)|(0))) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x015f A[Catch: all -> 0x0170, TRY_LEAVE, TryCatch #0 {all -> 0x0170, blocks: (B:16:0x0159, B:18:0x015f), top: B:15:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137 A[Catch: all -> 0x0171, TRY_LEAVE, TryCatch #1 {all -> 0x0171, blocks: (B:48:0x011d, B:52:0x012c, B:54:0x0137, B:58:0x0176, B:59:0x017d), top: B:47:0x011d }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0176 A[Catch: all -> 0x0171, TRY_ENTER, TryCatch #1 {all -> 0x0171, blocks: (B:48:0x011d, B:52:0x012c, B:54:0x0137, B:58:0x0176, B:59:0x017d), top: B:47:0x011d }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.room.coroutines.PooledConnectionImpl, T] */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(boolean r18, kotlin.jvm.functions.Function2 r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.f(boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
