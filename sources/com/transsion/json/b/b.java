package com.transsion.json.b;

import com.transsion.json.u;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class b extends a {
    @Override // com.transsion.json.b.n
    public void a(Object obj) {
        u G = b().G();
        int length = Array.getLength(obj);
        for (int i11 = 0; i11 < length; i11++) {
            if (G.e()) {
                b().E();
            }
            G.d();
            b().j(Array.get(obj, i11));
        }
        b().C();
    }
}
