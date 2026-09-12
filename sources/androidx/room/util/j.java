package androidx.room.util;

import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class j {
    public static final long a(z3.b connection) {
        Intrinsics.h(connection, "connection");
        if (b(connection) == 0) {
            return -1L;
        }
        z3.e D0 = connection.D0("SELECT last_insert_rowid()");
        try {
            D0.A0();
            long j11 = D0.getLong(0);
            AutoCloseableKt.a(D0, null);
            return j11;
        } finally {
        }
    }

    public static final int b(z3.b connection) {
        Intrinsics.h(connection, "connection");
        z3.e D0 = connection.D0("SELECT changes()");
        try {
            D0.A0();
            int i11 = (int) D0.getLong(0);
            AutoCloseableKt.a(D0, null);
            return i11;
        } finally {
        }
    }
}
