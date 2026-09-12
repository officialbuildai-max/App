package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class j implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    private final Object f27645a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Map f27646b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Set f27647c = Collections.emptySet();

    /* renamed from: d, reason: collision with root package name */
    private List f27648d = Collections.emptyList();

    public void a(Object obj) {
        synchronized (this.f27645a) {
            try {
                ArrayList arrayList = new ArrayList(this.f27648d);
                arrayList.add(obj);
                this.f27648d = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.f27646b.get(obj);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f27647c);
                    hashSet.add(obj);
                    this.f27647c = Collections.unmodifiableSet(hashSet);
                }
                this.f27646b.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(Object obj) {
        synchronized (this.f27645a) {
            try {
                Integer num = (Integer) this.f27646b.get(obj);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f27648d);
                arrayList.remove(obj);
                this.f27648d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f27646b.remove(obj);
                    HashSet hashSet = new HashSet(this.f27647c);
                    hashSet.remove(obj);
                    this.f27647c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f27646b.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int count(Object obj) {
        int intValue;
        synchronized (this.f27645a) {
            try {
                intValue = this.f27646b.containsKey(obj) ? ((Integer) this.f27646b.get(obj)).intValue() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return intValue;
    }

    public Set elementSet() {
        Set set;
        synchronized (this.f27645a) {
            set = this.f27647c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Iterator it;
        synchronized (this.f27645a) {
            it = this.f27648d.iterator();
        }
        return it;
    }
}
