package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function2;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a */
    private static final z f67970a = new z("CLOSED");

    public static final b b(b bVar) {
        while (true) {
            Object g11 = bVar.g();
            if (g11 == f67970a) {
                return bVar;
            }
            b bVar2 = (b) g11;
            if (bVar2 != null) {
                bVar = bVar2;
            } else if (bVar.m()) {
                return bVar;
            }
        }
    }

    public static final Object c(w wVar, long j11, Function2 function2) {
        while (true) {
            if (wVar.f68010c >= j11 && !wVar.k()) {
                return x.a(wVar);
            }
            Object g11 = wVar.g();
            if (g11 == f67970a) {
                return x.a(f67970a);
            }
            w wVar2 = (w) ((b) g11);
            if (wVar2 == null) {
                wVar2 = (w) function2.invoke(Long.valueOf(wVar.f68010c + 1), wVar);
                if (wVar.o(wVar2)) {
                    if (wVar.k()) {
                        wVar.n();
                    }
                }
            }
            wVar = wVar2;
        }
    }
}
