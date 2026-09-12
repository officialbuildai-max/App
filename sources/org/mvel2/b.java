package org.mvel2;

import i10.h;
import i10.j;
import i10.k;
import i10.l;
import i10.m;
import i10.n;
import i10.o;
import i10.p;
import i10.q;
import i10.r;
import i10.s;
import i10.t;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.mvel2.util.FastList;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f72076a;

    static {
        HashMap hashMap = new HashMap(76, 0.5f);
        f72076a = hashMap;
        m mVar = new m();
        hashMap.put(Integer.class, mVar);
        hashMap.put(Integer.TYPE, mVar);
        r rVar = new r();
        hashMap.put(Short.class, rVar);
        hashMap.put(Short.TYPE, rVar);
        o oVar = new o();
        hashMap.put(Long.class, oVar);
        hashMap.put(Long.TYPE, oVar);
        i10.g gVar = new i10.g();
        hashMap.put(Character.class, gVar);
        hashMap.put(Character.TYPE, gVar);
        i10.e eVar = new i10.e();
        hashMap.put(Byte.class, eVar);
        hashMap.put(Byte.TYPE, eVar);
        k kVar = new k();
        hashMap.put(Float.class, kVar);
        hashMap.put(Float.TYPE, kVar);
        j jVar = new j();
        hashMap.put(Double.class, jVar);
        hashMap.put(Double.TYPE, jVar);
        i10.d dVar = new i10.d();
        hashMap.put(Boolean.class, dVar);
        hashMap.put(Boolean.TYPE, dVar);
        hashMap.put(String.class, new t());
        hashMap.put(Object.class, new p());
        i10.f fVar = new i10.f();
        hashMap.put(Character[].class, fVar);
        hashMap.put(char[].class, new h(fVar, new i10.a(char[].class)));
        hashMap.put(String[].class, new s());
        hashMap.put(Integer[].class, new l());
        hashMap.put(int[].class, new i10.a(int[].class));
        hashMap.put(long[].class, new i10.a(long[].class));
        hashMap.put(double[].class, new i10.a(double[].class));
        hashMap.put(float[].class, new i10.a(float[].class));
        hashMap.put(short[].class, new i10.a(short[].class));
        hashMap.put(boolean[].class, new i10.a(boolean[].class));
        hashMap.put(byte[].class, new i10.a(byte[].class));
        hashMap.put(BigDecimal.class, new i10.b());
        hashMap.put(BigInteger.class, new i10.c());
        n nVar = new n();
        hashMap.put(List.class, nVar);
        hashMap.put(FastList.class, nVar);
        hashMap.put(ArrayList.class, nVar);
        hashMap.put(LinkedList.class, nVar);
        q qVar = new q();
        hashMap.put(Set.class, qVar);
        hashMap.put(HashSet.class, qVar);
        hashMap.put(LinkedHashSet.class, qVar);
        hashMap.put(TreeSet.class, qVar);
    }

    public static boolean a(Class cls, Class cls2) {
        if (org.mvel2.util.p.f(cls, cls2)) {
            return true;
        }
        Map map = f72076a;
        return map.containsKey(cls) ? ((a) map.get(cls)).a(org.mvel2.util.p.i(cls2)) : cls.isArray() && a(cls.getComponentType(), cls2);
    }

    public static Object b(Object obj, Class cls) {
        if (obj == null) {
            return null;
        }
        if (cls == obj.getClass() || cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        Map map = f72076a;
        a aVar = (a) map.get(cls);
        if (aVar != null || !cls.isArray()) {
            return aVar.b(obj);
        }
        i10.a aVar2 = new i10.a(cls);
        map.put(cls, aVar2);
        return aVar2.b(obj);
    }
}
