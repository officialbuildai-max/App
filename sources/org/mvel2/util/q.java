package org.mvel2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public class q implements Map {

    /* renamed from: a, reason: collision with root package name */
    private final Map f72209a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f72210b;

    /* loaded from: classes7.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        private int f72211a;

        /* renamed from: b, reason: collision with root package name */
        private Object f72212b;

        /* renamed from: c, reason: collision with root package name */
        private Object f72213c;

        public a(int i11, Object obj, Object obj2) {
            this.f72211a = i11;
            this.f72212b = obj;
            this.f72213c = obj2;
        }

        public int a() {
            return this.f72211a;
        }

        public Object b() {
            return this.f72212b;
        }

        public Object c() {
            return this.f72213c;
        }

        void d(Object obj) {
            this.f72213c = obj;
        }
    }

    public q() {
        this.f72209a = new HashMap();
        this.f72210b = new ArrayList();
    }

    public q(q qVar, boolean z10) {
        this.f72210b = new ArrayList(qVar.f72210b.size());
        this.f72209a = new HashMap();
        int i11 = 0;
        if (z10) {
            Iterator it = qVar.f72210b.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                a aVar2 = new a(i11, aVar.b(), null);
                this.f72210b.add(aVar2);
                this.f72209a.put(aVar.b(), aVar2);
                i11++;
            }
            return;
        }
        Iterator it2 = qVar.f72210b.iterator();
        while (it2.hasNext()) {
            a aVar3 = (a) it2.next();
            a aVar4 = new a(i11, aVar3.b(), aVar3.c());
            this.f72210b.add(aVar4);
            this.f72209a.put(aVar3.b(), aVar4);
            i11++;
        }
    }

    public Object a(int i11) {
        return ((a) this.f72210b.get(i11)).c();
    }

    public int c(Object obj) {
        return ((a) this.f72209a.get(obj)).a();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("cannot clear map");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f72209a.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f72209a.containsValue(obj);
    }

    public void d(int i11, Object obj) {
        ((a) this.f72210b.get(i11)).d(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return ((a) this.f72209a.get(obj)).c();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f72209a.isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        return this.f72209a.keySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        a aVar = (a) this.f72209a.get(obj);
        if (aVar == null) {
            throw new RuntimeException("cannot add a new entry.  you must allocate a new key with addKey() first.");
        }
        this.f72210b.add(aVar);
        return ((a) this.f72209a.put(obj, aVar)).c();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("cannot remove keys");
    }

    @Override // java.util.Map
    public int size() {
        return this.f72209a.size();
    }

    @Override // java.util.Map
    public Collection values() {
        throw new UnsupportedOperationException();
    }
}
