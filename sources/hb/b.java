package hb;

import android.content.Context;
import com.google.firebase.abt.AbtException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kb.a;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final ic.b f64543a;

    /* renamed from: b, reason: collision with root package name */
    private final String f64544b;

    /* renamed from: c, reason: collision with root package name */
    private Integer f64545c = null;

    public b(Context context, ic.b bVar, String str) {
        this.f64543a = bVar;
        this.f64544b = str;
    }

    private void a(a.c cVar) {
        ((kb.a) this.f64543a.get()).d(cVar);
    }

    private void b(List list) {
        ArrayDeque arrayDeque = new ArrayDeque(f());
        int i11 = i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            while (arrayDeque.size() >= i11) {
                k(((a.c) arrayDeque.pollFirst()).f66862b);
            }
            a.c f11 = aVar.f(this.f64544b);
            a(f11);
            arrayDeque.offer(f11);
        }
    }

    private static List c(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a.b((Map) it.next()));
        }
        return arrayList;
    }

    private boolean d(List list, a aVar) {
        String c11 = aVar.c();
        String e11 = aVar.e();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar2 = (a) it.next();
            if (aVar2.c().equals(c11) && aVar2.e().equals(e11)) {
                return true;
            }
        }
        return false;
    }

    private List f() {
        return ((kb.a) this.f64543a.get()).g(this.f64544b, "");
    }

    private ArrayList g(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!d(list2, aVar)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private ArrayList h(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!d(list2, aVar)) {
                arrayList.add(aVar.f(this.f64544b));
            }
        }
        return arrayList;
    }

    private int i() {
        if (this.f64545c == null) {
            this.f64545c = Integer.valueOf(((kb.a) this.f64543a.get()).f(this.f64544b));
        }
        return this.f64545c.intValue();
    }

    private void k(String str) {
        ((kb.a) this.f64543a.get()).clearConditionalUserProperty(str, null, null);
    }

    private void l(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            k(((a.c) it.next()).f66862b);
        }
    }

    private void n(List list) {
        if (list.isEmpty()) {
            j();
            return;
        }
        List e11 = e();
        l(h(e11, list));
        b(g(list, e11));
    }

    private void o() {
        if (this.f64543a.get() == null) {
            throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }

    public List e() {
        o();
        List f11 = f();
        ArrayList arrayList = new ArrayList();
        Iterator it = f11.iterator();
        while (it.hasNext()) {
            arrayList.add(a.a((a.c) it.next()));
        }
        return arrayList;
    }

    public void j() {
        o();
        l(f());
    }

    public void m(List list) {
        o();
        if (list == null) {
            throw new IllegalArgumentException("The replacementExperiments list is null.");
        }
        n(c(list));
    }
}
