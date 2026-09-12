package androidx.room.coroutines;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class b implements ConnectionPool {

    /* renamed from: a, reason: collision with root package name */
    private final z3.c f14716a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14717b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f14718c;

    public b(z3.c driver, String fileName) {
        Intrinsics.h(driver, "driver");
        Intrinsics.h(fileName, "fileName");
        this.f14716a = driver;
        this.f14717b = fileName;
        this.f14718c = LazyKt.b(new Function0() { // from class: androidx.room.coroutines.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AndroidSQLiteDriverPooledConnection d11;
                d11 = b.d(b.this);
                return d11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AndroidSQLiteDriverPooledConnection d(b bVar) {
        z3.b open = bVar.f14716a.open(bVar.f14717b);
        Intrinsics.f(open, "null cannot be cast to non-null type androidx.sqlite.driver.AndroidSQLiteConnection");
        return new AndroidSQLiteDriverPooledConnection((c4.a) open);
    }

    private final AndroidSQLiteDriverPooledConnection h() {
        return (AndroidSQLiteDriverPooledConnection) this.f14718c.getValue();
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        h().f().close();
    }

    @Override // androidx.room.coroutines.ConnectionPool
    public Object f(boolean z10, Function2 function2, Continuation continuation) {
        return function2.invoke(h(), continuation);
    }
}
