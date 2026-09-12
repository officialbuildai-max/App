package androidx.room;

import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class e {
    protected abstract void a(z3.e eVar, Object obj);

    protected abstract String b();

    public final int c(z3.b connection, Object obj) {
        Intrinsics.h(connection, "connection");
        if (obj == null) {
            return 0;
        }
        z3.e D0 = connection.D0(b());
        try {
            a(D0, obj);
            D0.A0();
            AutoCloseableKt.a(D0, null);
            return androidx.room.util.j.b(connection);
        } finally {
        }
    }
}
