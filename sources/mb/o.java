package mb;

import android.util.Log;
import androidx.compose.animation.core.j0;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import mb.o;

/* loaded from: classes5.dex */
public class o implements e, ac.a {

    /* renamed from: i, reason: collision with root package name */
    private static final ic.b f69594i = new ic.b() { // from class: mb.k
        @Override // ic.b
        public final Object get() {
            return Collections.emptySet();
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final Map f69595a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f69596b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f69597c;

    /* renamed from: d, reason: collision with root package name */
    private final List f69598d;

    /* renamed from: e, reason: collision with root package name */
    private Set f69599e;

    /* renamed from: f, reason: collision with root package name */
    private final t f69600f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicReference f69601g;

    /* renamed from: h, reason: collision with root package name */
    private final j f69602h;

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Executor f69603a;

        /* renamed from: b, reason: collision with root package name */
        private final List f69604b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private final List f69605c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private j f69606d = j.f69587a;

        b(Executor executor) {
            this.f69603a = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public b b(c cVar) {
            this.f69605c.add(cVar);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f69604b.add(new ic.b() { // from class: mb.p
                @Override // ic.b
                public final Object get() {
                    ComponentRegistrar f11;
                    f11 = o.b.f(ComponentRegistrar.this);
                    return f11;
                }
            });
            return this;
        }

        public b d(Collection collection) {
            this.f69604b.addAll(collection);
            return this;
        }

        public o e() {
            return new o(this.f69603a, this.f69604b, this.f69605c, this.f69606d);
        }

        public b g(j jVar) {
            this.f69606d = jVar;
            return this;
        }
    }

    private o(Executor executor, Iterable iterable, Collection collection, j jVar) {
        this.f69595a = new HashMap();
        this.f69596b = new HashMap();
        this.f69597c = new HashMap();
        this.f69599e = new HashSet();
        this.f69601g = new AtomicReference();
        t tVar = new t(executor);
        this.f69600f = tVar;
        this.f69602h = jVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.s(tVar, t.class, fc.d.class, fc.c.class));
        arrayList.add(c.s(this, ac.a.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f69598d = q(iterable);
        n(arrayList);
    }

    public static b m(Executor executor) {
        return new b(executor);
    }

    private void n(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f69598d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((ic.b) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f69602h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e11) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e11);
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Object[] array = ((c) it2.next()).j().toArray();
                int length = array.length;
                int i11 = 0;
                while (true) {
                    if (i11 < length) {
                        Object obj = array[i11];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f69599e.contains(obj.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f69599e.add(obj.toString());
                        }
                        i11++;
                    }
                }
            }
            if (this.f69595a.isEmpty()) {
                q.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f69595a.keySet());
                arrayList2.addAll(list);
                q.a(arrayList2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                final c cVar = (c) it3.next();
                this.f69595a.put(cVar, new u(new ic.b() { // from class: mb.l
                    @Override // ic.b
                    public final Object get() {
                        Object r11;
                        r11 = o.this.r(cVar);
                        return r11;
                    }
                }));
            }
            arrayList.addAll(w(list));
            arrayList.addAll(x());
            v();
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            ((Runnable) it4.next()).run();
        }
        u();
    }

    private void o(Map map, boolean z10) {
        for (Map.Entry entry : map.entrySet()) {
            c cVar = (c) entry.getKey();
            ic.b bVar = (ic.b) entry.getValue();
            if (cVar.n() || (cVar.o() && z10)) {
                bVar.get();
            }
        }
        this.f69600f.d();
    }

    private static List q(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(c cVar) {
        return cVar.h().a(new c0(cVar, this));
    }

    private void u() {
        Boolean bool = (Boolean) this.f69601g.get();
        if (bool != null) {
            o(this.f69595a, bool.booleanValue());
        }
    }

    private void v() {
        for (c cVar : this.f69595a.keySet()) {
            for (r rVar : cVar.g()) {
                if (rVar.g() && !this.f69597c.containsKey(rVar.c())) {
                    this.f69597c.put(rVar.c(), v.b(Collections.emptySet()));
                } else if (this.f69596b.containsKey(rVar.c())) {
                    continue;
                } else {
                    if (rVar.f()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", cVar, rVar.c()));
                    }
                    if (!rVar.g()) {
                        this.f69596b.put(rVar.c(), z.e());
                    }
                }
            }
        }
    }

    private List w(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.p()) {
                final ic.b bVar = (ic.b) this.f69595a.get(cVar);
                for (b0 b0Var : cVar.j()) {
                    if (this.f69596b.containsKey(b0Var)) {
                        final z zVar = (z) ((ic.b) this.f69596b.get(b0Var));
                        arrayList.add(new Runnable() { // from class: mb.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                z.this.j(bVar);
                            }
                        });
                    } else {
                        this.f69596b.put(b0Var, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private List x() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f69595a.entrySet()) {
            c cVar = (c) entry.getKey();
            if (!cVar.p()) {
                ic.b bVar = (ic.b) entry.getValue();
                for (b0 b0Var : cVar.j()) {
                    if (!hashMap.containsKey(b0Var)) {
                        hashMap.put(b0Var, new HashSet());
                    }
                    ((Set) hashMap.get(b0Var)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            if (this.f69597c.containsKey(entry2.getKey())) {
                final v vVar = (v) this.f69597c.get(entry2.getKey());
                for (final ic.b bVar2 : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: mb.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            v.this.a(bVar2);
                        }
                    });
                }
            } else {
                this.f69597c.put((b0) entry2.getKey(), v.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    @Override // mb.e
    public /* synthetic */ Object a(Class cls) {
        return d.a(this, cls);
    }

    @Override // mb.e
    public synchronized ic.b b(b0 b0Var) {
        v vVar = (v) this.f69597c.get(b0Var);
        if (vVar != null) {
            return vVar;
        }
        return f69594i;
    }

    @Override // mb.e
    public /* synthetic */ Object c(b0 b0Var) {
        return d.b(this, b0Var);
    }

    @Override // mb.e
    public /* synthetic */ Set d(Class cls) {
        return d.e(this, cls);
    }

    @Override // mb.e
    public /* synthetic */ Set e(b0 b0Var) {
        return d.f(this, b0Var);
    }

    @Override // mb.e
    public /* synthetic */ ic.b f(Class cls) {
        return d.d(this, cls);
    }

    @Override // mb.e
    public synchronized ic.b g(b0 b0Var) {
        a0.c(b0Var, "Null interface requested.");
        return (ic.b) this.f69596b.get(b0Var);
    }

    @Override // mb.e
    public ic.a h(b0 b0Var) {
        ic.b g11 = g(b0Var);
        return g11 == null ? z.e() : g11 instanceof z ? (z) g11 : z.i(g11);
    }

    @Override // mb.e
    public /* synthetic */ ic.a i(Class cls) {
        return d.c(this, cls);
    }

    public void p(boolean z10) {
        HashMap hashMap;
        if (j0.a(this.f69601g, null, Boolean.valueOf(z10))) {
            synchronized (this) {
                hashMap = new HashMap(this.f69595a);
            }
            o(hashMap, z10);
        }
    }
}
