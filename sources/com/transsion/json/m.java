package com.transsion.json;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class m {

    /* renamed from: d, reason: collision with root package name */
    private final Map f46142d;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList f46139a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private final LinkedList f46140b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private final q f46141c = new q();

    /* renamed from: e, reason: collision with root package name */
    private final Map f46143e = new HashMap();

    public m() {
        HashMap hashMap = new HashMap();
        this.f46142d = hashMap;
        hashMap.put(Object.class, new em.b());
        hashMap.put(Collection.class, new em.k());
        hashMap.put(List.class, new em.k());
        hashMap.put(Set.class, new em.n());
        hashMap.put(Map.class, new em.m());
        hashMap.put(Integer.class, new em.i());
        hashMap.put(Integer.TYPE, new em.i());
        hashMap.put(Float.class, new em.h());
        hashMap.put(Float.TYPE, new em.h());
        hashMap.put(Double.class, new em.f());
        hashMap.put(Double.TYPE, new em.f());
        hashMap.put(Long.class, new em.l());
        hashMap.put(Long.TYPE, new em.l());
        hashMap.put(Byte.class, new em.d());
        hashMap.put(Byte.TYPE, new em.d());
        hashMap.put(Boolean.class, new em.c());
        hashMap.put(Boolean.TYPE, new em.c());
        hashMap.put(Character.class, new em.e());
        hashMap.put(Character.TYPE, new em.e());
        hashMap.put(Enum.class, new em.g());
        hashMap.put(String.class, new em.o());
        hashMap.put(Array.class, new em.a());
        hashMap.put(n.class, new em.j());
    }

    private o c(Class cls) {
        o oVar = (o) this.f46142d.get(cls);
        if (oVar != null || cls == null) {
            return oVar;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            o c11 = c(cls2);
            if (c11 != null) {
                return c11;
            }
        }
        if (cls.getSuperclass() != null) {
            return c(cls.getSuperclass());
        }
        return null;
    }

    private Class g(Type type) {
        if (type == null) {
            return null;
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.class;
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable)) {
            return null;
        }
        throw new k(this.f46141c + ":  Unknown type " + type);
    }

    private String m(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private Type n(Type type, Type type2) {
        if ((type instanceof Class) || (type instanceof ParameterizedType)) {
            return type;
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return type2;
        }
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        throw new k(this.f46141c + ":  Unknown generic type " + type + ".");
    }

    private boolean p(Map map, d dVar) {
        return map.containsKey(dVar.b()) || map.containsKey(m(dVar.b()));
    }

    private o r(Class cls) {
        o oVar = (o) this.f46143e.get(this.f46141c);
        return oVar == null ? (cls == null || !cls.isArray()) ? c(cls) : (o) this.f46142d.get(Array.class) : oVar;
    }

    private Object s(Map map, d dVar) {
        Object obj = map.get(dVar.b());
        return obj == null ? map.get(m(dVar.b())) : obj;
    }

    private Class t(Object obj, Class cls) {
        if (this.f46143e.containsKey(this.f46141c)) {
            return null;
        }
        Class f11 = f(obj instanceof Map ? h((Map) obj, null) : null, cls);
        return f11 == null ? obj.getClass() : f11;
    }

    public m a(q qVar, o oVar) {
        this.f46143e.put(qVar, oVar);
        return this;
    }

    public m b(Class cls, o oVar) {
        this.f46142d.put(cls, oVar);
        return this;
    }

    public q d() {
        return this.f46141c;
    }

    public Class e(q qVar) {
        return null;
    }

    protected Class f(Class cls, Class cls2) {
        if (cls != null && cls2 != null) {
            return cls2.isAssignableFrom(cls) ? cls : cls2;
        }
        if (cls2 != null) {
            return cls2;
        }
        if (cls != null) {
            return cls;
        }
        return null;
    }

    protected Class h(Map map, Class cls) {
        if (cls != null) {
            return cls;
        }
        String str = (String) map.get("class");
        if (str == null) {
            return null;
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.loadClass(str) : Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new k(String.format("%s:  Could not load %s", this.f46141c, str), e11);
        }
    }

    public Object i(Object obj) {
        return j(obj, null);
    }

    public Object j(Object obj, Type type) {
        this.f46140b.add(obj);
        if (obj == null) {
            this.f46140b.removeLast();
            return null;
        }
        try {
            Class t11 = t(obj, g(type));
            o r11 = r(t11);
            if (r11 != null) {
                return r11.a(this, obj, type, t11);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f46141c);
            sb2.append(": + Could not find a suitable ObjectFactory for ");
            sb2.append(t11);
            throw new k(sb2.toString());
        } finally {
            this.f46140b.removeLast();
        }
    }

    public Object k(Map map, Object obj, Type type) {
        try {
            this.f46139a.add(obj);
            c a11 = c.a(obj.getClass());
            for (d dVar : a11 != null ? a11.c() : null) {
                if (p(map, dVar)) {
                    Object s11 = s(map, dVar);
                    if (dVar.p().booleanValue()) {
                        this.f46141c.a(dVar.e());
                        Method k11 = dVar.k();
                        if (k11 != null) {
                            Type[] genericParameterTypes = k11.getGenericParameterTypes();
                            if (genericParameterTypes.length != 1) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(this.f46141c);
                                sb2.append(":  Expected a single parameter for method ");
                                sb2.append(obj.getClass().getName());
                                sb2.append(".");
                                sb2.append(k11.getName());
                                sb2.append(" but got ");
                                sb2.append(genericParameterTypes.length);
                                throw new k(sb2.toString());
                            }
                            k11.invoke(this.f46139a.getLast(), j(s11, n(genericParameterTypes[0], type)));
                        } else {
                            Field g11 = dVar.g();
                            if (g11 != null) {
                                g11.setAccessible(true);
                                g11.set(obj, j(s11, g11.getGenericType()));
                            }
                        }
                        this.f46141c.d();
                    } else {
                        continue;
                    }
                }
            }
            return this.f46139a.removeLast();
        } catch (IllegalAccessException e11) {
            throw new k(this.f46141c + ":  Could not access the no-arg constructor for " + obj.getClass().getName(), e11);
        } catch (InvocationTargetException e12) {
            throw new k(this.f46141c + ":  Exception while trying to invoke setter method.", e12);
        }
    }

    public Object l(Map map, Map map2, Type type, Type type2) {
        this.f46140b.add(map);
        this.f46139a.add(map2);
        for (Object obj : map.keySet()) {
            this.f46141c.a("keys");
            Object j11 = j(obj, type);
            this.f46141c.d();
            this.f46141c.a("values");
            Object j12 = j(map.get(obj), type2);
            this.f46141c.d();
            map2.put(j11, j12);
        }
        this.f46139a.removeLast();
        this.f46140b.removeLast();
        return map2;
    }

    public Collection o(Collection collection, Collection collection2, Type type) {
        Type type2 = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        this.f46140b.add(collection);
        this.f46139a.add(collection2);
        d().a("values");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            collection2.add(j(it.next(), type2));
        }
        d().d();
        this.f46139a.removeLast();
        this.f46140b.removeLast();
        return collection2;
    }

    public k q(Object obj, Class cls) {
        return new k(String.format("%s:  Can not convert %s into %s", this.f46141c, obj.getClass().getName(), cls.getName()));
    }
}
