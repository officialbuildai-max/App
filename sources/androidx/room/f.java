package androidx.room;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class f extends j0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(RoomDatabase database) {
        super(database);
        Intrinsics.h(database, "database");
    }

    protected abstract void j(a4.h hVar, Object obj);

    public final int k(Object obj) {
        a4.h b11 = b();
        try {
            j(b11, obj);
            return b11.F();
        } finally {
            h(b11);
        }
    }

    public final int l(Iterable entities) {
        Intrinsics.h(entities, "entities");
        a4.h b11 = b();
        try {
            Iterator it = entities.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                j(b11, it.next());
                i11 += b11.F();
            }
            return i11;
        } finally {
            h(b11);
        }
    }
}
