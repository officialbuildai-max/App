package androidx.room.util;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class c {
    public static final void a(z3.b connection) {
        Intrinsics.h(connection, "connection");
        List c11 = CollectionsKt.c();
        z3.e D0 = connection.D0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (D0.A0()) {
            try {
                c11.add(D0.n0(0));
            } finally {
            }
        }
        Unit unit = Unit.f67184a;
        AutoCloseableKt.a(D0, null);
        for (String str : CollectionsKt.a(c11)) {
            if (StringsKt.W(str, "room_fts_content_sync_", false, 2, null)) {
                z3.a.a(connection, "DROP TRIGGER IF EXISTS " + str);
            }
        }
    }
}
