package z4;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import y4.a;

/* loaded from: classes3.dex */
public class z1 extends e implements b2 {

    /* renamed from: a, reason: collision with root package name */
    public static z1 f79401a = new z1();

    public static Object i(y4.a aVar, Map map, Type type, Type type2, Object obj) {
        Object c11;
        y4.b bVar = aVar.f78954f;
        if (bVar.q0() != 12 && bVar.q0() != 16) {
            throw new JSONException("syntax error, expect {, actual " + bVar.v());
        }
        b2 p11 = aVar.m().p(type);
        b2 p12 = aVar.m().p(type2);
        bVar.c0(p11.b());
        y4.g n11 = aVar.n();
        while (bVar.q0() != 13) {
            try {
                Object obj2 = null;
                if (bVar.q0() == 4 && bVar.x() && !bVar.n(Feature.DisableSpecialKeyDetect)) {
                    bVar.q(4);
                    if (bVar.q0() != 4) {
                        throw new JSONException("illegal ref, " + y4.f.a(bVar.q0()));
                    }
                    String k02 = bVar.k0();
                    if ("..".equals(k02)) {
                        obj2 = n11.f78990b.f78989a;
                    } else if ("$".equals(k02)) {
                        y4.g gVar = n11;
                        while (true) {
                            y4.g gVar2 = gVar.f78990b;
                            if (gVar2 == null) {
                                break;
                            }
                            gVar = gVar2;
                        }
                        obj2 = gVar.f78989a;
                    } else {
                        aVar.i(new a.C0994a(n11, k02));
                        aVar.E0(1);
                    }
                    bVar.c0(13);
                    if (bVar.q0() != 13) {
                        throw new JSONException("illegal ref");
                    }
                    bVar.c0(16);
                    return obj2;
                }
                if (map.size() == 0 && bVar.q0() == 4 && com.alibaba.fastjson.a.DEFAULT_TYPE_KEY.equals(bVar.k0()) && !bVar.n(Feature.DisableSpecialKeyDetect)) {
                    bVar.q(4);
                    bVar.c0(16);
                    if (bVar.q0() == 13) {
                        bVar.Z();
                        return map;
                    }
                    bVar.c0(p11.b());
                }
                if (bVar.q0() == 4 && (p11 instanceof o)) {
                    String k03 = bVar.k0();
                    bVar.Z();
                    y4.a aVar2 = new y4.a(k03, aVar.m(), aVar.s().r());
                    aVar2.C0(aVar.o());
                    c11 = p11.c(aVar2, type, null);
                } else {
                    c11 = p11.c(aVar, type, null);
                }
                if (bVar.q0() != 17) {
                    throw new JSONException("syntax error, expect :, actual " + bVar.q0());
                }
                bVar.c0(p12.b());
                Object c12 = p12.c(aVar, type2, c11);
                aVar.l(map, c11);
                map.put(c11, c12);
                if (bVar.q0() == 16) {
                    bVar.c0(p11.b());
                }
            } finally {
                aVar.B0(n11);
            }
        }
        bVar.c0(16);
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x022e, code lost:
    
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map j(y4.a r11, java.util.Map r12, java.lang.reflect.Type r13, java.lang.Object r14, int r15) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.z1.j(y4.a, java.util.Map, java.lang.reflect.Type, java.lang.Object, int):java.util.Map");
    }

    @Override // z4.b2
    public int b() {
        return 12;
    }

    @Override // z4.e
    public Object e(y4.a aVar, Type type, Object obj, String str, int i11) {
        if (type == JSONObject.class) {
            aVar.q();
            return aVar.l0();
        }
        y4.b bVar = aVar.f78954f;
        if (bVar.q0() == 8) {
            bVar.c0(16);
            return null;
        }
        boolean z10 = (type instanceof Class) && "java.util.Collections$UnmodifiableMap".equals(((Class) type).getName());
        Map g11 = (bVar.r() & Feature.OrderedField.mask) != 0 ? g(type, bVar.r()) : f(type);
        y4.g n11 = aVar.n();
        try {
            aVar.z0(n11, g11, obj);
            Object h11 = h(aVar, type, obj, g11, i11);
            if (z10) {
                h11 = Collections.unmodifiableMap((Map) h11);
            }
            return h11;
        } finally {
            aVar.B0(n11);
        }
    }

    public Map f(Type type) {
        return g(type, com.alibaba.fastjson.a.DEFAULT_GENERATE_FEATURE);
    }

    public Map g(Type type, int i11) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class) {
            return (Feature.OrderedField.mask & i11) != 0 ? new LinkedHashMap() : new HashMap();
        }
        if (type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : g(rawType, i11);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        }
        if ("java.util.Collections$UnmodifiableMap".equals(cls.getName())) {
            return new HashMap();
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e11) {
            throw new JSONException("unsupport type " + type, e11);
        }
    }

    protected Object h(y4.a aVar, Type type, Object obj, Map map, int i11) {
        if (!(type instanceof ParameterizedType)) {
            return aVar.r0(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap") ? List.class : parameterizedType.getActualTypeArguments()[1];
        return String.class == type2 ? j(aVar, map, type3, obj, i11) : i(aVar, map, type2, type3, obj);
    }
}
