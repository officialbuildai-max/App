package cd;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import mb.e;
import mb.h;
import mb.j;

/* loaded from: classes4.dex */
public class b implements j {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object c(String str, mb.c cVar, e eVar) {
        try {
            c.b(str);
            return cVar.h().a(eVar);
        } finally {
            c.a();
        }
    }

    @Override // mb.j
    public List a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final mb.c cVar : componentRegistrar.getComponents()) {
            final String i11 = cVar.i();
            if (i11 != null) {
                cVar = cVar.t(new h() { // from class: cd.a
                    @Override // mb.h
                    public final Object a(e eVar) {
                        Object c11;
                        c11 = b.c(i11, cVar, eVar);
                        return c11;
                    }
                });
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }
}
