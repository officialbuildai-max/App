package xc;

import java.util.Iterator;
import java.util.Set;
import mb.r;

/* loaded from: classes5.dex */
public class c implements i {

    /* renamed from: a, reason: collision with root package name */
    private final String f78314a;

    /* renamed from: b, reason: collision with root package name */
    private final d f78315b;

    c(Set set, d dVar) {
        this.f78314a = d(set);
        this.f78315b = dVar;
    }

    public static mb.c b() {
        return mb.c.c(i.class).b(r.o(f.class)).f(new mb.h() { // from class: xc.b
            @Override // mb.h
            public final Object a(mb.e eVar) {
                i c11;
                c11 = c.c(eVar);
                return c11;
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i c(mb.e eVar) {
        return new c(eVar.d(f.class), d.a());
    }

    private static String d(Set set) {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            sb2.append(fVar.b());
            sb2.append('/');
            sb2.append(fVar.c());
            if (it.hasNext()) {
                sb2.append(' ');
            }
        }
        return sb2.toString();
    }

    @Override // xc.i
    public String getUserAgent() {
        if (this.f78315b.b().isEmpty()) {
            return this.f78314a;
        }
        return this.f78314a + ' ' + d(this.f78315b.b());
    }
}
