package androidx.room;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class h extends j0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(RoomDatabase database) {
        super(database);
        Intrinsics.h(database, "database");
    }

    protected abstract void j(a4.h hVar, Object obj);

    public final void k(Iterable entities) {
        Intrinsics.h(entities, "entities");
        a4.h b11 = b();
        try {
            Iterator it = entities.iterator();
            while (it.hasNext()) {
                j(b11, it.next());
                b11.R();
            }
        } finally {
            h(b11);
        }
    }

    public final void l(Object obj) {
        a4.h b11 = b();
        try {
            j(b11, obj);
            b11.R();
        } finally {
            h(b11);
        }
    }

    public final long m(Object obj) {
        a4.h b11 = b();
        try {
            j(b11, obj);
            return b11.R();
        } finally {
            h(b11);
        }
    }
}
