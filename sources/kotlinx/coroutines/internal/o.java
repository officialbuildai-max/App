package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.a2;

/* loaded from: classes7.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f68003a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2 f68004b;

    static {
        o oVar = new o();
        f68003a = oVar;
        a0.f("kotlinx.coroutines.fast.service.loader", true);
        f68004b = oVar.a();
    }

    private o() {
    }

    private final a2 a() {
        Object next;
        a2 e11;
        try {
            List D = SequencesKt.D(SequencesKt.e(ServiceLoader.load(n.class, n.class.getClassLoader()).iterator()));
            Iterator it = D.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int c11 = ((n) next).c();
                    do {
                        Object next2 = it.next();
                        int c12 = ((n) next2).c();
                        if (c11 < c12) {
                            next = next2;
                            c11 = c12;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            n nVar = (n) next;
            if (nVar != null && (e11 = p.e(nVar, D)) != null) {
                return e11;
            }
            p.b(null, null, 3, null);
            return null;
        } catch (Throwable th2) {
            p.b(th2, null, 2, null);
            return null;
        }
    }
}
