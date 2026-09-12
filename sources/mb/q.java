package mb;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
abstract class q {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final mb.c f69608a;

        /* renamed from: b, reason: collision with root package name */
        private final Set f69609b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        private final Set f69610c = new HashSet();

        b(mb.c cVar) {
            this.f69608a = cVar;
        }

        void a(b bVar) {
            this.f69609b.add(bVar);
        }

        void b(b bVar) {
            this.f69610c.add(bVar);
        }

        mb.c c() {
            return this.f69608a;
        }

        Set d() {
            return this.f69609b;
        }

        boolean e() {
            return this.f69609b.isEmpty();
        }

        boolean f() {
            return this.f69610c.isEmpty();
        }

        void g(b bVar) {
            this.f69610c.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final b0 f69611a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f69612b;

        private c(b0 b0Var, boolean z10) {
            this.f69611a = b0Var;
            this.f69612b = z10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f69611a.equals(this.f69611a) && cVar.f69612b == this.f69612b;
        }

        public int hashCode() {
            return ((this.f69611a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f69612b).hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List list) {
        Set<b> c11 = c(list);
        Set b11 = b(c11);
        int i11 = 0;
        while (!b11.isEmpty()) {
            b bVar = (b) b11.iterator().next();
            b11.remove(bVar);
            i11++;
            for (b bVar2 : bVar.d()) {
                bVar2.g(bVar);
                if (bVar2.f()) {
                    b11.add(bVar2);
                }
            }
        }
        if (i11 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar3 : c11) {
            if (!bVar3.f() && !bVar3.e()) {
                arrayList.add(bVar3.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    private static Set b(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set c(List list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = hashMap.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (r rVar : bVar.c().g()) {
                            if (rVar.e() && (set = (Set) hashMap.get(new c(rVar.c(), rVar.g()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = hashMap.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            mb.c cVar = (mb.c) it.next();
            b bVar3 = new b(cVar);
            for (b0 b0Var : cVar.j()) {
                c cVar2 = new c(b0Var, !cVar.p());
                if (!hashMap.containsKey(cVar2)) {
                    hashMap.put(cVar2, new HashSet());
                }
                Set set2 = (Set) hashMap.get(cVar2);
                if (!set2.isEmpty() && !cVar2.f69612b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", b0Var));
                }
                set2.add(bVar3);
            }
        }
    }
}
