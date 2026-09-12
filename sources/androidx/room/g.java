package androidx.room;

import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class g {
    protected abstract void a(z3.e eVar, Object obj);

    protected abstract String b();

    public final void c(z3.b connection, Iterable iterable) {
        Intrinsics.h(connection, "connection");
        if (iterable == null) {
            return;
        }
        z3.e D0 = connection.D0(b());
        try {
            for (Object obj : iterable) {
                if (obj != null) {
                    a(D0, obj);
                    D0.A0();
                    D0.reset();
                }
            }
            Unit unit = Unit.f67184a;
            AutoCloseableKt.a(D0, null);
        } finally {
        }
    }

    public final void d(z3.b connection, Object obj) {
        Intrinsics.h(connection, "connection");
        if (obj == null) {
            return;
        }
        z3.e D0 = connection.D0(b());
        try {
            a(D0, obj);
            D0.A0();
            AutoCloseableKt.a(D0, null);
        } finally {
        }
    }

    public final long e(z3.b connection, Object obj) {
        Intrinsics.h(connection, "connection");
        if (obj == null) {
            return -1L;
        }
        z3.e D0 = connection.D0(b());
        try {
            a(D0, obj);
            D0.A0();
            AutoCloseableKt.a(D0, null);
            return androidx.room.util.j.a(connection);
        } finally {
        }
    }
}
