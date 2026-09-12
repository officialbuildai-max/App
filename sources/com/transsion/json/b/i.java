package com.transsion.json.b;

import com.transsion.json.q;
import com.transsion.json.u;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class i extends a {
    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        com.transsion.json.h b11 = b();
        q x10 = b11.x();
        Map map = (Map) obj;
        try {
            u H = b().H();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                Object next = it.next();
                x10.a(next != null ? next.toString() : null);
                if (b11.o(next != null ? next.toString() : null, map.get(next))) {
                    n a11 = b11.a(null, map.get(next));
                    if (!(a11 instanceof g) || !((g) a11).a().booleanValue()) {
                        if (H.e()) {
                            b().E();
                        }
                        H.d();
                        if (next != null) {
                            b().u(next.toString());
                        } else {
                            b().u(null);
                        }
                    }
                    if (next != null) {
                        H.b(next.toString());
                    } else {
                        H.b(null);
                    }
                    a11.a(map.get(next));
                }
                x10.d();
            }
            b().D();
        } catch (Exception e11) {
            throw new com.transsion.json.k(String.format("%s: Error while trying to serialize.", x10), e11);
        }
    }
}
