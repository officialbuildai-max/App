package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f30286a = new WeakHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map a(Class cls) {
        Map map;
        Map map2 = f30286a;
        synchronized (map2) {
            try {
                map = (Map) map2.get(cls);
                if (map == null) {
                    map = c(cls);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return map;
    }

    public static Optional b(Class cls, String str) {
        m.o(cls);
        m.o(str);
        return l.b(cls, str);
    }

    private static Map c(Class cls) {
        HashMap hashMap = new HashMap();
        Iterator it = EnumSet.allOf(cls).iterator();
        while (it.hasNext()) {
            Enum r22 = (Enum) it.next();
            hashMap.put(r22.name(), new WeakReference(r22));
        }
        f30286a.put(cls, hashMap);
        return hashMap;
    }
}
