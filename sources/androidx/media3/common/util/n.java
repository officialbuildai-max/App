package androidx.media3.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class n implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    private final Object f10493a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Map f10494b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Set f10495c = Collections.emptySet();

    /* renamed from: d, reason: collision with root package name */
    private List f10496d = Collections.emptyList();

    public void a(Object obj) {
        synchronized (this.f10493a) {
            try {
                ArrayList arrayList = new ArrayList(this.f10496d);
                arrayList.add(obj);
                this.f10496d = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.f10494b.get(obj);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f10495c);
                    hashSet.add(obj);
                    this.f10495c = Collections.unmodifiableSet(hashSet);
                }
                this.f10494b.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(Object obj) {
        synchronized (this.f10493a) {
            try {
                Integer num = (Integer) this.f10494b.get(obj);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f10496d);
                arrayList.remove(obj);
                this.f10496d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f10494b.remove(obj);
                    HashSet hashSet = new HashSet(this.f10495c);
                    hashSet.remove(obj);
                    this.f10495c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f10494b.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int count(Object obj) {
        int intValue;
        synchronized (this.f10493a) {
            try {
                intValue = this.f10494b.containsKey(obj) ? ((Integer) this.f10494b.get(obj)).intValue() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return intValue;
    }

    public Set elementSet() {
        Set set;
        synchronized (this.f10493a) {
            set = this.f10495c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Iterator it;
        synchronized (this.f10493a) {
            it = this.f10496d.iterator();
        }
        return it;
    }
}
