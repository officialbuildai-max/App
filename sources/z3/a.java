package z3;

import android.database.SQLException;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class a {
    public static final void a(b bVar, String sql) {
        Intrinsics.h(bVar, "<this>");
        Intrinsics.h(sql, "sql");
        e D0 = bVar.D0(sql);
        try {
            D0.A0();
            AutoCloseableKt.a(D0, null);
        } finally {
        }
    }

    public static final Void b(int i11, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Error code: " + i11);
        if (str != null) {
            sb2.append(", message: " + str);
        }
        throw new SQLException(sb2.toString());
    }
}
