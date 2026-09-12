package com.transsion.json.b;

import com.transsion.json.q;
import com.transsion.json.u;

/* loaded from: classes.dex */
public class l extends a {
    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        com.transsion.json.h b11 = b();
        q x10 = b11.x();
        com.transsion.json.f z10 = b11.z();
        try {
            if (z10.contains(obj)) {
                u A = b().A();
                if (A != null) {
                    A.a();
                    return;
                }
                return;
            }
            b11.f(new com.transsion.json.f(z10));
            b11.z().add(obj);
            com.transsion.json.c a11 = com.transsion.json.c.a(c(obj));
            u H = b11.H();
            for (com.transsion.json.d dVar : a11 != null ? a11.c() : null) {
                x10.a(dVar.e());
                if (b11.n(dVar) && dVar.n().booleanValue()) {
                    Object a12 = dVar.a(obj);
                    if (!b11.z().contains(a12)) {
                        n a13 = b11.a(dVar, a12);
                        if (!(a13 instanceof g) || !((g) a13).a().booleanValue()) {
                            if (H.e()) {
                                b11.E();
                            }
                            H.d();
                            b11.u(dVar.b());
                        }
                        H.b(dVar.b());
                        a13.a(a12);
                    }
                }
                x10.d();
            }
            b11.D();
            b11.f((com.transsion.json.f) b11.z().a());
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
        } catch (InstantiationException e12) {
            e12.printStackTrace();
        }
    }

    protected Class c(Object obj) {
        return obj.getClass();
    }
}
