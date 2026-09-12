package com.transsion.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f46092d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final Class f46093a;

    /* renamed from: b, reason: collision with root package name */
    private final c f46094b;

    /* renamed from: c, reason: collision with root package name */
    private Map f46095c;

    protected c(Class cls) {
        this.f46093a = cls;
        this.f46094b = a(cls.getSuperclass());
        g();
    }

    public static c a(Class cls) {
        ThreadLocal threadLocal = f46092d;
        if (threadLocal.get() == null) {
            threadLocal.set(new HashMap());
        }
        if (cls == null) {
            return null;
        }
        if (!((Map) threadLocal.get()).containsKey(cls)) {
            ((Map) threadLocal.get()).put(cls, new c(cls));
        }
        return (c) ((Map) threadLocal.get()).get(cls);
    }

    private void d(Map map, Map map2) {
        for (String str : map2.keySet()) {
            if (!map.containsKey(str)) {
                map.put(str, map2.get(str));
            }
        }
    }

    private void g() {
        this.f46095c = new TreeMap();
        for (Field field : this.f46093a.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers()) && !this.f46095c.containsKey(field.getName())) {
                this.f46095c.put(field.getName(), new d(field, this));
            }
        }
        for (Method method : this.f46093a.getDeclaredMethods()) {
            if (!Modifier.isStatic(method.getModifiers())) {
                int length = method.getParameterTypes().length;
                String name = method.getName();
                if (name.length() > 3 || name.startsWith("is")) {
                    if (length == 0) {
                        if (name.startsWith("get")) {
                            String i11 = i(name.substring(3));
                            if (!this.f46095c.containsKey(i11)) {
                                this.f46095c.put(i11, new d(i11, this));
                            }
                            ((d) this.f46095c.get(i11)).f(method);
                        } else if (name.startsWith("is")) {
                            String i12 = i(name.substring(2));
                            if (!this.f46095c.containsKey(i12)) {
                                this.f46095c.put(i12, new d(i12, this));
                            }
                            ((d) this.f46095c.get(i12)).f(method);
                        }
                    } else if (length == 1 && name.startsWith("set")) {
                        String i13 = i(name.substring(3));
                        if (!this.f46095c.containsKey(i13)) {
                            this.f46095c.put(i13, new d(i13, this));
                        }
                        ((d) this.f46095c.get(i13)).d(method);
                    }
                }
            }
        }
        Iterator it = this.f46095c.values().iterator();
        while (it.hasNext()) {
            if (((d) it.next()).m()) {
                it.remove();
            }
        }
    }

    private String i(String str) {
        if (str.length() < 2) {
            return str.toLowerCase();
        }
        if (Character.isUpperCase(str.charAt(0)) && Character.isUpperCase(str.charAt(1))) {
            return str;
        }
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Field b(String str) {
        try {
            return this.f46093a.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public Collection c() {
        TreeMap treeMap = new TreeMap(this.f46095c);
        for (c cVar = this.f46094b; cVar != null; cVar = cVar.f46094b) {
            d(treeMap, cVar.f46095c);
        }
        return treeMap.values();
    }

    public c e() {
        return this.f46094b;
    }

    public d f(String str) {
        for (c cVar = this; cVar != null; cVar = cVar.f46094b) {
            d dVar = (d) cVar.f46095c.get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    public boolean h(String str) {
        c cVar;
        return this.f46095c.containsKey(str) || ((cVar = this.f46094b) != null && cVar.h(str));
    }
}
