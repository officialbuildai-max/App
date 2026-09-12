package zl;

import com.transsion.core.pool.b;
import com.transsion.http.c;
import com.transsion.http.impl.r;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private b f79553a = com.transsion.core.pool.a.b();

    /* renamed from: b, reason: collision with root package name */
    private List f79554b = Collections.synchronizedList(new LinkedList());

    public void a(wl.b bVar, r rVar) {
        c cVar = new c(bVar, rVar);
        if (bVar.c().m() != null) {
            this.f79554b.add(cVar);
        }
        this.f79553a.a(cVar);
    }
}
