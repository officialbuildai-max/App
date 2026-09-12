package com.alibaba.fastjson.util;

import a5.f1;
import a5.v;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import z4.b2;
import z4.o;

/* loaded from: classes2.dex */
public class TypeUtils {
    private static volatile Map A;
    private static volatile boolean B;
    private static Class D;
    private static Class N;
    private static com.alibaba.fastjson.util.e O;
    private static com.alibaba.fastjson.util.e P;
    private static com.alibaba.fastjson.util.e Q;
    public static com.alibaba.fastjson.util.e R;
    private static com.alibaba.fastjson.util.c S;
    private static com.alibaba.fastjson.util.e T;
    private static final Map U;
    private static final Set V;
    private static Object W;
    private static boolean X;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f18250b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f18251c;

    /* renamed from: f, reason: collision with root package name */
    private static Method f18254f;

    /* renamed from: h, reason: collision with root package name */
    private static Method f18256h;

    /* renamed from: j, reason: collision with root package name */
    private static Class f18258j;

    /* renamed from: l, reason: collision with root package name */
    private static Class f18260l;

    /* renamed from: s, reason: collision with root package name */
    private static volatile Class f18267s;

    /* renamed from: t, reason: collision with root package name */
    private static volatile boolean f18268t;

    /* renamed from: u, reason: collision with root package name */
    private static volatile boolean f18269u;

    /* renamed from: v, reason: collision with root package name */
    private static volatile Constructor f18270v;

    /* renamed from: w, reason: collision with root package name */
    private static volatile Method f18271w;

    /* renamed from: x, reason: collision with root package name */
    private static volatile Method f18272x;

    /* renamed from: y, reason: collision with root package name */
    private static volatile Method f18273y;

    /* renamed from: z, reason: collision with root package name */
    private static volatile boolean f18274z;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f18249a = Pattern.compile("\\.0*$");

    /* renamed from: d, reason: collision with root package name */
    private static boolean f18252d = true;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f18253e = false;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f18255g = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f18257i = false;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f18259k = false;

    /* renamed from: m, reason: collision with root package name */
    private static Class f18261m = null;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f18262n = false;

    /* renamed from: o, reason: collision with root package name */
    private static Class f18263o = null;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f18264p = false;

    /* renamed from: q, reason: collision with root package name */
    private static Method f18265q = null;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f18266r = false;
    private static ConcurrentMap C = new ConcurrentHashMap(256, 0.75f, 1);
    private static boolean E = false;
    private static Class F = null;
    private static boolean G = false;
    private static volatile Class H = null;
    private static volatile Class I = null;
    private static volatile boolean J = false;
    private static volatile Method K = null;
    private static volatile Field L = null;
    private static volatile Object M = null;

    /* loaded from: classes2.dex */
    public static class MethodInheritanceComparator implements Comparator<Method> {
        @Override // java.util.Comparator
        public int compare(Method method, Method method2) {
            int compareTo = method.getName().compareTo(method2.getName());
            if (compareTo != 0) {
                return compareTo;
            }
            Class<?> returnType = method.getReturnType();
            Class<?> returnType2 = method2.getReturnType();
            if (returnType.equals(returnType2)) {
                return 0;
            }
            if (returnType.isAssignableFrom(returnType2)) {
                return -1;
            }
            return returnType2.isAssignableFrom(returnType) ? 1 : 0;
        }
    }

    /* loaded from: classes2.dex */
    static class a implements com.alibaba.fastjson.util.e {
        a() {
        }

        @Override // com.alibaba.fastjson.util.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Class cls) {
            return Boolean.valueOf(Clob.class.isAssignableFrom(cls));
        }
    }

    /* loaded from: classes2.dex */
    static class b implements com.alibaba.fastjson.util.e {
        b() {
        }

        @Override // com.alibaba.fastjson.util.e
        public Object apply(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Date) {
                return (Date) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Date(((java.util.Date) obj).getTime());
            }
            if (obj instanceof Calendar) {
                return new Date(((Calendar) obj).getTimeInMillis());
            }
            long E0 = obj instanceof BigDecimal ? TypeUtils.E0((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0L;
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                    return null;
                }
                if (TypeUtils.v0(str)) {
                    E0 = Long.parseLong(str);
                } else {
                    y4.e eVar = new y4.e(str);
                    if (!eVar.x1(false)) {
                        throw new JSONException("can not cast to Timestamp, value : " + str);
                    }
                    E0 = eVar.J0().getTime().getTime();
                }
            }
            if (E0 > 0) {
                return new Date(E0);
            }
            throw new JSONException("can not cast to Date, value : " + obj);
        }
    }

    /* loaded from: classes2.dex */
    static class c implements com.alibaba.fastjson.util.e {
        c() {
        }

        @Override // com.alibaba.fastjson.util.e
        public Object apply(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Time) {
                return (Time) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Time(((java.util.Date) obj).getTime());
            }
            if (obj instanceof Calendar) {
                return new Time(((Calendar) obj).getTimeInMillis());
            }
            long E0 = obj instanceof BigDecimal ? TypeUtils.E0((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0L;
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
                    return null;
                }
                if (TypeUtils.v0(str)) {
                    E0 = Long.parseLong(str);
                } else {
                    if (str.length() == 8 && str.charAt(2) == ':' && str.charAt(5) == ':') {
                        return Time.valueOf(str);
                    }
                    y4.e eVar = new y4.e(str);
                    if (!eVar.x1(false)) {
                        throw new JSONException("can not cast to Timestamp, value : " + str);
                    }
                    E0 = eVar.J0().getTime().getTime();
                }
            }
            if (E0 > 0) {
                return new Time(E0);
            }
            throw new JSONException("can not cast to Date, value : " + obj);
        }
    }

    /* loaded from: classes2.dex */
    static class d implements com.alibaba.fastjson.util.e {
        d() {
        }

        @Override // com.alibaba.fastjson.util.e
        public Object apply(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Calendar) {
                return new Timestamp(((Calendar) obj).getTimeInMillis());
            }
            if (obj instanceof Timestamp) {
                return (Timestamp) obj;
            }
            if (obj instanceof java.util.Date) {
                return new Timestamp(((java.util.Date) obj).getTime());
            }
            long E0 = obj instanceof BigDecimal ? TypeUtils.E0((BigDecimal) obj) : obj instanceof Number ? ((Number) obj).longValue() : 0L;
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                    return null;
                }
                if (str.endsWith(".000000000")) {
                    str = str.substring(0, str.length() - 10);
                } else if (str.endsWith(".000000")) {
                    str = str.substring(0, str.length() - 7);
                }
                if (str.length() == 29 && str.charAt(4) == '-' && str.charAt(7) == '-' && str.charAt(10) == ' ' && str.charAt(13) == ':' && str.charAt(16) == ':' && str.charAt(19) == '.') {
                    return new Timestamp(TypeUtils.H0(str.charAt(0), str.charAt(1), str.charAt(2), str.charAt(3)) - 1900, TypeUtils.G0(str.charAt(5), str.charAt(6)) - 1, TypeUtils.G0(str.charAt(8), str.charAt(9)), TypeUtils.G0(str.charAt(11), str.charAt(12)), TypeUtils.G0(str.charAt(14), str.charAt(15)), TypeUtils.G0(str.charAt(17), str.charAt(18)), TypeUtils.I0(str.charAt(20), str.charAt(21), str.charAt(22), str.charAt(23), str.charAt(24), str.charAt(25), str.charAt(26), str.charAt(27), str.charAt(28)));
                }
                if (TypeUtils.v0(str)) {
                    E0 = Long.parseLong(str);
                } else {
                    y4.e eVar = new y4.e(str);
                    if (!eVar.x1(false)) {
                        throw new JSONException("can not cast to Timestamp, value : " + str);
                    }
                    E0 = eVar.J0().getTime().getTime();
                }
            }
            return new Timestamp(E0);
        }
    }

    /* loaded from: classes2.dex */
    static class e implements com.alibaba.fastjson.util.c {
        e() {
        }

        @Override // com.alibaba.fastjson.util.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object obj, Class cls) {
            if (cls == Date.class) {
                return TypeUtils.y(obj);
            }
            if (cls == Time.class) {
                return TypeUtils.z(obj);
            }
            if (cls == Timestamp.class) {
                return TypeUtils.B(obj);
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    static class f implements com.alibaba.fastjson.util.e {
        f() {
        }

        @Override // com.alibaba.fastjson.util.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void apply(Map map) {
            Class[] clsArr = {Time.class, Date.class, Timestamp.class};
            for (int i11 = 0; i11 < 3; i11++) {
                Class cls = clsArr[i11];
                if (cls != null) {
                    map.put(cls.getName(), cls);
                }
            }
            return null;
        }
    }

    static {
        f18250b = false;
        f18251c = false;
        N = null;
        try {
            f18250b = "true".equals(com.alibaba.fastjson.util.f.j("fastjson.compatibleWithJavaBean"));
            f18251c = "true".equals(com.alibaba.fastjson.util.f.j("fastjson.compatibleWithFieldName"));
        } catch (Throwable unused) {
        }
        try {
            N = Deque.class;
        } catch (Throwable unused2) {
        }
        O = new a();
        P = new b();
        Q = new c();
        R = new d();
        S = new e();
        T = new f();
        a();
        U = new HashMap<Class, String>(8) { // from class: com.alibaba.fastjson.util.TypeUtils.7
            {
                put(Boolean.TYPE, "Z");
                put(Character.TYPE, "C");
                put(Byte.TYPE, "B");
                put(Short.TYPE, "S");
                put(Integer.TYPE, "I");
                put(Long.TYPE, "J");
                put(Float.TYPE, "F");
                put(Double.TYPE, "D");
            }
        };
        V = new HashSet<String>(6) { // from class: com.alibaba.fastjson.util.TypeUtils.8
            {
                add("net.sf.cglib.proxy.Factory");
                add("org.springframework.cglib.proxy.Factory");
                add("javassist.util.proxy.ProxyObject");
                add("org.apache.ibatis.javassist.util.proxy.ProxyObject");
                add("org.hibernate.proxy.HibernateProxy");
                add("org.springframework.context.annotation.ConfigurationClassEnhancer$EnhancedConfiguration");
            }
        };
        X = false;
    }

    public static String A(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Class A0(String str) {
        return B0(str, null);
    }

    public static Object B(Object obj) {
        return i.b(R, obj);
    }

    public static Class B0(String str, ClassLoader classLoader) {
        return C0(str, classLoader, false);
    }

    private static void C(Class cls, Map map, PropertyNamingStrategy propertyNamingStrategy, Map map2, Field[] fieldArr) {
        String str;
        int i11;
        int i12;
        int i13;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                x4.b bVar = (x4.b) O(field, x4.b.class);
                String name = field.getName();
                if (bVar == null) {
                    str = null;
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                } else if (bVar.serialize()) {
                    int ordinal = bVar.ordinal();
                    int of2 = SerializerFeature.of(bVar.serialzeFeatures());
                    int of3 = Feature.of(bVar.parseFeatures());
                    if (bVar.name().length() != 0) {
                        name = bVar.name();
                    }
                    str = bVar.label().length() != 0 ? bVar.label() : null;
                    i11 = ordinal;
                    i12 = of2;
                    i13 = of3;
                }
                if (map == null || (name = (String) map.get(name)) != null) {
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    String str2 = name;
                    if (!map2.containsKey(str2)) {
                        map2.put(str2, new com.alibaba.fastjson.util.d(str2, null, field, cls, null, i11, i12, i13, null, bVar, str));
                    }
                }
            }
        }
    }

    public static Class C0(String str, ClassLoader classLoader, boolean z10) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() > 198) {
            throw new JSONException("illegal className : " + str);
        }
        Class<?> cls = (Class) C.get(str);
        if (cls != null) {
            return cls;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance((Class<?>) B0(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(";")) {
            return B0(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                cls = classLoader.loadClass(str);
                if (z10) {
                    C.put(str, cls);
                }
                return cls;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && contextClassLoader != classLoader) {
                cls = contextClassLoader.loadClass(str);
                if (z10) {
                    C.put(str, cls);
                }
                return cls;
            }
        } catch (Throwable unused) {
        }
        try {
            cls = Class.forName(str);
            if (z10) {
                C.put(str, cls);
            }
        } catch (Throwable unused2) {
        }
        return cls;
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x033c, code lost:
    
        if (r3 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x04b8, code lost:
    
        if (r0 == null) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x045e, code lost:
    
        if (r2 == null) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x02ab, code lost:
    
        if (r1 == null) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
    
        if (r11.getName().equals("groovy.lang.MetaClass") != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0469  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List D(java.lang.Class r41, x4.d r42, java.util.Map r43, java.util.Map r44, boolean r45, com.alibaba.fastjson.PropertyNamingStrategy r46) {
        /*
            Method dump skipped, instructions count: 1352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.D(java.lang.Class, x4.d, java.util.Map, java.util.Map, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    public static long D0(Number number) {
        return number instanceof BigDecimal ? ((BigDecimal) number).longValueExact() : number.longValue();
    }

    public static List E(Class cls, Map map, boolean z10, PropertyNamingStrategy propertyNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            C(cls2, map, propertyNamingStrategy, linkedHashMap, cls2.getDeclaredFields());
        }
        return Y(cls, z10, linkedHashMap);
    }

    public static long E0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0L;
        }
        int scale = bigDecimal.scale();
        return (scale < -100 || scale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
    }

    private static Map F(TypeVariable[] typeVariableArr, Type[] typeArr) {
        int length = typeVariableArr.length;
        HashMap hashMap = new HashMap(length);
        for (int i11 = 0; i11 < length; i11++) {
            hashMap.put(typeVariableArr[i11], typeArr[i11]);
        }
        return hashMap;
    }

    private static ParameterizedType F0(Class cls, Type[] typeArr, Map map) {
        int length = typeArr.length;
        Type[] typeArr2 = new Type[length];
        for (int i11 = 0; i11 < length; i11++) {
            typeArr2[i11] = M(typeArr[i11], map);
        }
        return new ParameterizedTypeImpl(typeArr2, null, cls);
    }

    public static Collection G(Type type) {
        Class<?> cls;
        Class i02 = i0(type);
        if (i02 == AbstractCollection.class || i02 == Collection.class) {
            return new ArrayList();
        }
        if (i02.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (i02.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (i02.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (i02.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (i02.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        if (i02.isAssignableFrom(Queue.class) || ((cls = N) != null && i02.isAssignableFrom(cls))) {
            return new LinkedList();
        }
        try {
            return (Collection) i02.newInstance();
        } catch (Exception unused) {
            throw new JSONException("create instance error, class " + i02.getName());
        }
    }

    static int G0(char c11, char c12) {
        if (c11 < '0' || c11 > '9' || c12 < '0' || c12 > '9') {
            return -1;
        }
        return ((c11 - '0') * 10) + (c12 - '0');
    }

    public static Set H(Type type) {
        Class i02 = i0(type);
        if (i02 == AbstractCollection.class || i02 == Collection.class) {
            return new HashSet();
        }
        if (i02.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (i02.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (i02.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (i02.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        try {
            return (Set) i02.newInstance();
        } catch (Exception unused) {
            throw new JSONException("create instance error, class " + i02.getName());
        }
    }

    static int H0(char c11, char c12, char c13, char c14) {
        if (c11 < '0' || c11 > '9' || c12 < '0' || c12 > '9' || c13 < '0' || c13 > '9' || c14 < '0' || c14 > '9') {
            return -1;
        }
        return ((c11 - '0') * 1000) + ((c12 - '0') * 100) + ((c13 - '0') * 10) + (c14 - '0');
    }

    public static String I(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    static int I0(char c11, char c12, char c13, char c14, char c15, char c16, char c17, char c18, char c19) {
        if (c11 < '0' || c11 > '9' || c12 < '0' || c12 > '9' || c13 < '0' || c13 > '9' || c14 < '0' || c14 > '9' || c15 < '0' || c15 > '9' || c16 < '0' || c16 > '9' || c17 < '0' || c17 > '9' || c18 < '0' || c18 > '9' || c19 < '0' || c19 > '9') {
            return -1;
        }
        return ((c11 - '0') * 100000000) + ((c12 - '0') * 10000000) + ((c13 - '0') * 1000000) + ((c14 - '0') * DefaultOggSeeker.MATCH_BYTE_RANGE) + ((c15 - '0') * 10000) + ((c16 - '0') * 1000) + ((c17 - '0') * 100) + ((c18 - '0') * 10) + (c19 - '0');
    }

    public static long J(String str) {
        long j11 = -3750763034362895579L;
        for (int i11 = 0; i11 < str.length(); i11++) {
            j11 = (j11 ^ str.charAt(i11)) * 1099511628211L;
        }
        return j11;
    }

    public static Object J0(Type type) {
        Class Q2;
        if (X || (Q2 = Q(type)) == null) {
            return null;
        }
        String name = Q2.getName();
        if (!"java.util.Optional".equals(name)) {
            return null;
        }
        if (W == null) {
            try {
                W = Class.forName(name).getMethod("empty", null).invoke(null, null);
            } catch (Throwable unused) {
                X = true;
            }
        }
        return W;
    }

    public static long K(String str) {
        long j11 = -3750763034362895579L;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt != '_' && charAt != '-') {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j11 = (j11 ^ charAt) * 1099511628211L;
            }
        }
        return j11;
    }

    public static double K0(String str) {
        double d11;
        double d12;
        int length = str.length();
        if (length > 10) {
            return Double.parseDouble(str);
        }
        long j11 = 0;
        boolean z10 = false;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (charAt == '-' && i12 == 0) {
                z10 = true;
            } else if (charAt == '.') {
                if (i11 != 0) {
                    return Double.parseDouble(str);
                }
                i11 = (length - i12) - 1;
            } else {
                if (charAt < '0' || charAt > '9') {
                    return Double.parseDouble(str);
                }
                j11 = (j11 * 10) + (charAt - '0');
            }
        }
        if (z10) {
            j11 = -j11;
        }
        switch (i11) {
            case 0:
                return j11;
            case 1:
                d11 = j11;
                d12 = 10.0d;
                break;
            case 2:
                d11 = j11;
                d12 = 100.0d;
                break;
            case 3:
                d11 = j11;
                d12 = 1000.0d;
                break;
            case 4:
                d11 = j11;
                d12 = 10000.0d;
                break;
            case 5:
                d11 = j11;
                d12 = 100000.0d;
                break;
            case 6:
                d11 = j11;
                d12 = 1000000.0d;
                break;
            case 7:
                d11 = j11;
                d12 = 1.0E7d;
                break;
            case 8:
                d11 = j11;
                d12 = 1.0E8d;
                break;
            case 9:
                d11 = j11;
                d12 = 1.0E9d;
                break;
            default:
                return Double.parseDouble(str);
        }
        return d11 / d12;
    }

    public static long L(String str) {
        long j11 = -3750763034362895579L;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt >= 'A' && charAt <= 'Z') {
                charAt = (char) (charAt + ' ');
            }
            j11 = (j11 ^ charAt) * 1099511628211L;
        }
        return j11;
    }

    public static float L0(String str) {
        float f11;
        float f12;
        int length = str.length();
        if (length >= 10) {
            return Float.parseFloat(str);
        }
        long j11 = 0;
        boolean z10 = false;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (charAt == '-' && i12 == 0) {
                z10 = true;
            } else if (charAt == '.') {
                if (i11 != 0) {
                    return Float.parseFloat(str);
                }
                i11 = (length - i12) - 1;
            } else {
                if (charAt < '0' || charAt > '9') {
                    return Float.parseFloat(str);
                }
                j11 = (j11 * 10) + (charAt - '0');
            }
        }
        if (z10) {
            j11 = -j11;
        }
        switch (i11) {
            case 0:
                return (float) j11;
            case 1:
                f11 = (float) j11;
                f12 = 10.0f;
                break;
            case 2:
                f11 = (float) j11;
                f12 = 100.0f;
                break;
            case 3:
                f11 = (float) j11;
                f12 = 1000.0f;
                break;
            case 4:
                f11 = (float) j11;
                f12 = 10000.0f;
                break;
            case 5:
                f11 = (float) j11;
                f12 = 100000.0f;
                break;
            case 6:
                f11 = (float) j11;
                f12 = 1000000.0f;
                break;
            case 7:
                f11 = (float) j11;
                f12 = 1.0E7f;
                break;
            case 8:
                f11 = (float) j11;
                f12 = 1.0E8f;
                break;
            case 9:
                f11 = (float) j11;
                f12 = 1.0E9f;
                break;
            default:
                return Float.parseFloat(str);
        }
        return f11 / f12;
    }

    private static Type M(Type type, Map map) {
        return type instanceof TypeVariable ? (Type) map.get(type) : type instanceof ParameterizedType ? F0(i0(type), ((ParameterizedType) type).getActualTypeArguments(), map) : type instanceof GenericArrayType ? new GenericArrayTypeImpl(M(((GenericArrayType) type).getGenericComponentType(), map)) : type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void M0(AccessibleObject accessibleObject) {
        if (f18252d && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (Throwable unused) {
                f18252d = false;
            }
        }
    }

    public static Annotation N(Class cls, Class cls2) {
        Annotation annotation = cls.getAnnotation(cls2);
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(cls);
        Class cls3 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls3 != null) {
            Annotation annotation2 = cls3.getAnnotation(cls2);
            Annotation[] annotations = cls3.getAnnotations();
            if (annotation2 == null && annotations.length > 0) {
                for (Annotation annotation3 : annotations) {
                    annotation2 = annotation3.annotationType().getAnnotation(cls2);
                    if (annotation2 != null) {
                        break;
                    }
                }
            }
            if (annotation2 != null) {
                return annotation2;
            }
        }
        Annotation[] annotations2 = cls.getAnnotations();
        if (annotation == null && annotations2.length > 0) {
            for (Annotation annotation4 : annotations2) {
                annotation = annotation4.annotationType().getAnnotation(cls2);
                if (annotation != null) {
                    break;
                }
            }
        }
        return annotation;
    }

    public static short N0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (short) 0;
        }
        int scale = bigDecimal.scale();
        return (scale < -100 || scale > 100) ? bigDecimal.shortValueExact() : bigDecimal.shortValue();
    }

    public static Annotation O(Field field, Class cls) {
        Annotation annotation;
        Annotation annotation2 = field.getAnnotation(cls);
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(field.getDeclaringClass());
        Field field2 = null;
        Class cls2 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls2 != null) {
            String name = field.getName();
            while (cls2 != null && cls2 != Object.class) {
                try {
                    field2 = cls2.getDeclaredField(name);
                    break;
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                }
            }
            if (field2 != null && (annotation = field2.getAnnotation(cls)) != null) {
                return annotation;
            }
        }
        return annotation2;
    }

    public static Locale O0(String str) {
        String[] split = str.split("_");
        return split.length == 1 ? new Locale(split[0]) : split.length == 2 ? new Locale(split[0], split[1]) : new Locale(split[0], split[1], split[2]);
    }

    public static Annotation P(Method method, Class cls) {
        Annotation annotation;
        Annotation annotation2 = method.getAnnotation(cls);
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(method.getDeclaringClass());
        Method method2 = null;
        Class cls2 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls2 != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (cls2 != null && cls2 != Object.class) {
                try {
                    method2 = cls2.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    cls2 = cls2.getSuperclass();
                }
            }
            if (method2 != null && (annotation = method2.getAnnotation(cls)) != null) {
                return annotation;
            }
        }
        return annotation2;
    }

    public static Type P0(Type type) {
        if (!f18257i) {
            try {
                f18258j = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } catch (Throwable th2) {
                f18257i = true;
                throw th2;
            }
            f18257i = true;
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == f18258j ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    public static Class Q(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return Q(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            Type type2 = ((TypeVariable) type).getBounds()[0];
            return type2 instanceof Class ? (Class) type2 : Q(type2);
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? Q(upperBounds[0]) : Object.class;
    }

    public static Class R(String str) {
        return (Class) C.get(str);
    }

    public static Class S(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (!(type2 instanceof Class)) {
            throw new JSONException("can not create ASMParser");
        }
        Class cls = (Class) type2;
        if (Modifier.isPublic(cls.getModifiers())) {
            return cls;
        }
        throw new JSONException("can not create ASMParser");
    }

    private static Type T(Class cls) {
        return cls.getName().startsWith("java.") ? Object.class : V(W(cls));
    }

    private static Type U(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (rawType == Collection.class) {
            return k0(actualTypeArguments[0]);
        }
        Class cls = (Class) rawType;
        Map F2 = F(cls.getTypeParameters(), actualTypeArguments);
        Type W2 = W(cls);
        if (!(W2 instanceof ParameterizedType)) {
            return T((Class) W2);
        }
        Class i02 = i0(W2);
        Type[] actualTypeArguments2 = ((ParameterizedType) W2).getActualTypeArguments();
        return actualTypeArguments2.length > 0 ? U(F0(i02, actualTypeArguments2, F2)) : T(i02);
    }

    public static Type V(Type type) {
        return type instanceof ParameterizedType ? U((ParameterizedType) type) : type instanceof Class ? T((Class) type) : Object.class;
    }

    private static Type W(Class cls) {
        Type type = null;
        for (Type type2 : cls.getGenericInterfaces()) {
            Class i02 = i0(type2);
            if (i02 == Collection.class) {
                return type2;
            }
            if (Collection.class.isAssignableFrom(i02)) {
                type = type2;
            }
        }
        return type == null ? cls.getGenericSuperclass() : type;
    }

    public static Field X(Class cls, String str, Field[] fieldArr) {
        char charAt;
        char charAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return X(superclass, str, superclass.getDeclaredFields());
    }

    private static List Y(Class cls, boolean z10, Map map) {
        ArrayList arrayList = new ArrayList();
        x4.d dVar = (x4.d) N(cls, x4.d.class);
        String[] orders = dVar != null ? dVar.orders() : null;
        if (orders == null || orders.length <= 0) {
            arrayList.addAll(map.values());
            if (z10) {
                Collections.sort(arrayList);
            }
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
            for (com.alibaba.fastjson.util.d dVar2 : map.values()) {
                linkedHashMap.put(dVar2.f18279a, dVar2);
            }
            for (String str : orders) {
                com.alibaba.fastjson.util.d dVar3 = (com.alibaba.fastjson.util.d) linkedHashMap.get(str);
                if (dVar3 != null) {
                    arrayList.add(dVar3);
                    linkedHashMap.remove(str);
                }
            }
            arrayList.addAll(linkedHashMap.values());
        }
        return arrayList;
    }

    public static Type Z(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? Z(((Class) type).getGenericSuperclass()) : type;
    }

    private static void a() {
        C.put("byte", Byte.TYPE);
        C.put("short", Short.TYPE);
        C.put("int", Integer.TYPE);
        C.put("long", Long.TYPE);
        C.put("float", Float.TYPE);
        C.put("double", Double.TYPE);
        C.put("boolean", Boolean.TYPE);
        C.put("char", Character.TYPE);
        C.put("[byte", byte[].class);
        C.put("[short", short[].class);
        C.put("[int", int[].class);
        C.put("[long", long[].class);
        C.put("[float", float[].class);
        C.put("[double", double[].class);
        C.put("[boolean", boolean[].class);
        C.put("[char", char[].class);
        C.put("[B", byte[].class);
        C.put("[S", short[].class);
        C.put("[I", int[].class);
        C.put("[J", long[].class);
        C.put("[F", float[].class);
        C.put("[D", double[].class);
        C.put("[C", char[].class);
        C.put("[Z", boolean[].class);
        Class[] clsArr = {Object.class, Cloneable.class, A0("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, LinkedHashMap.class, Hashtable.class, TreeMap.class, IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, ArrayList.class, TimeUnit.class, ConcurrentHashMap.class, AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Number.class, String.class, BigDecimal.class, BigInteger.class, BitSet.class, Calendar.class, java.util.Date.class, Locale.class, UUID.class, SimpleDateFormat.class, JSONObject.class, com.alibaba.fastjson.c.class, JSONArray.class};
        for (int i11 = 0; i11 < 69; i11++) {
            Class cls = clsArr[i11];
            if (cls != null) {
                C.put(cls.getName(), cls);
            }
        }
        i.b(T, C);
    }

    public static String[] a0(Class cls) {
        if (f18270v == null && !f18269u) {
            try {
                f18270v = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(Class.class);
            } catch (Throwable unused) {
                f18269u = true;
            }
        }
        if (f18270v == null) {
            return null;
        }
        if (f18271w == null && !f18269u) {
            try {
                f18271w = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", null);
            } catch (Throwable unused2) {
                f18269u = true;
            }
        }
        if (f18272x == null && !f18269u) {
            try {
                f18272x = KFunction.class.getMethod("getParameters", null);
            } catch (Throwable unused3) {
                f18269u = true;
            }
        }
        if (f18273y == null && !f18269u) {
            try {
                f18273y = KParameter.class.getMethod("getName", null);
            } catch (Throwable unused4) {
                f18269u = true;
            }
        }
        if (f18274z) {
            return null;
        }
        try {
            Iterator it = ((Iterable) f18271w.invoke(f18270v.newInstance(cls), null)).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) f18272x.invoke(next, null);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            if (obj == null) {
                return null;
            }
            List list2 = (List) f18272x.invoke(obj, null);
            String[] strArr = new String[list2.size()];
            for (int i11 = 0; i11 < list2.size(); i11++) {
                strArr[i11] = (String) f18273y.invoke(list2.get(i11), null);
            }
            return strArr;
        } catch (Throwable th2) {
            th2.printStackTrace();
            f18274z = true;
            return null;
        }
    }

    public static void b(String str, Class cls) {
        C.put(str, cls);
    }

    public static Constructor b0(Constructor[] constructorArr) {
        return c0(constructorArr, null);
    }

    public static f1 c(Class cls, Map map, PropertyNamingStrategy propertyNamingStrategy) {
        return d(cls, map, propertyNamingStrategy, false);
    }

    public static Constructor c0(Constructor[] constructorArr, String[] strArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if ((strArr == null || parameterTypes.length == strArr.length) && ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length))) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    public static f1 d(Class cls, Map map, PropertyNamingStrategy propertyNamingStrategy, boolean z10) {
        PropertyNamingStrategy propertyNamingStrategy2;
        int i11;
        String[] strArr;
        String str;
        String str2;
        List list;
        x4.d dVar = (x4.d) N(cls, x4.d.class);
        if (dVar != null) {
            String[] orders = dVar.orders();
            String typeName = dVar.typeName();
            if (typeName.length() == 0) {
                typeName = null;
            }
            PropertyNamingStrategy naming = dVar.naming();
            if (naming == PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue) {
                naming = propertyNamingStrategy;
            }
            int of2 = SerializerFeature.of(dVar.serialzeFeatures());
            String str3 = null;
            for (Class superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                x4.d dVar2 = (x4.d) N(superclass, x4.d.class);
                if (dVar2 == null) {
                    break;
                }
                str3 = dVar2.typeKey();
                if (str3.length() != 0) {
                    break;
                }
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                x4.d dVar3 = (x4.d) N(cls2, x4.d.class);
                if (dVar3 != null) {
                    str3 = dVar3.typeKey();
                    if (str3.length() != 0) {
                        break;
                    }
                }
            }
            str2 = (str3 == null || str3.length() != 0) ? str3 : null;
            str = typeName;
            propertyNamingStrategy2 = naming;
            i11 = of2;
            strArr = orders;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            i11 = 0;
            strArr = null;
            str = null;
            str2 = null;
        }
        HashMap hashMap = new HashMap();
        y4.h.y(cls, hashMap);
        List E2 = z10 ? E(cls, map, false, propertyNamingStrategy2) : D(cls, dVar, map, hashMap, false, propertyNamingStrategy2);
        com.alibaba.fastjson.util.d[] dVarArr = new com.alibaba.fastjson.util.d[E2.size()];
        E2.toArray(dVarArr);
        if (strArr == null || strArr.length == 0) {
            ArrayList arrayList = new ArrayList(E2);
            Collections.sort(arrayList);
            list = arrayList;
        } else {
            list = z10 ? E(cls, map, true, propertyNamingStrategy2) : D(cls, dVar, map, hashMap, true, propertyNamingStrategy2);
        }
        com.alibaba.fastjson.util.d[] dVarArr2 = new com.alibaba.fastjson.util.d[list.size()];
        list.toArray(dVarArr2);
        return new f1(cls, dVar, str, str2, i11, dVarArr, Arrays.equals(dVarArr2, dVarArr) ? dVarArr : dVarArr2);
    }

    public static Annotation[][] d0(Constructor constructor) {
        Annotation[][] parameterAnnotations;
        Constructor declaredConstructor;
        Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(constructor.getDeclaringClass());
        Constructor constructor2 = null;
        Class cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls != null) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            ArrayList arrayList = new ArrayList(2);
            for (Class<?> enclosingClass = cls.getEnclosingClass(); enclosingClass != null; enclosingClass = enclosingClass.getEnclosingClass()) {
                arrayList.add(enclosingClass);
            }
            int size = arrayList.size();
            Class cls2 = cls;
            while (true) {
                if (cls2 == null || cls2 == Object.class) {
                    break;
                }
                try {
                    if (size != 0) {
                        Class<?>[] clsArr = new Class[parameterTypes.length + size];
                        System.arraycopy(parameterTypes, 0, clsArr, size, parameterTypes.length);
                        for (int i11 = size; i11 > 0; i11--) {
                            int i12 = i11 - 1;
                            clsArr[i12] = (Class) arrayList.get(i12);
                        }
                        declaredConstructor = cls.getDeclaredConstructor(clsArr);
                    } else {
                        declaredConstructor = cls.getDeclaredConstructor(parameterTypes);
                    }
                    constructor2 = declaredConstructor;
                } catch (NoSuchMethodException unused) {
                    size--;
                    cls2 = cls2.getSuperclass();
                }
            }
            if (constructor2 != null && (parameterAnnotations = constructor2.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static byte e(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (byte) 0;
        }
        int scale = bigDecimal.scale();
        return (scale < -100 || scale > 100) ? bigDecimal.byteValueExact() : bigDecimal.byteValue();
    }

    public static Annotation[][] e0(Method method) {
        Annotation[][] parameterAnnotations;
        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(method.getDeclaringClass());
        Method method2 = null;
        Class cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (cls != null && cls != Object.class) {
                try {
                    method2 = cls.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    cls = cls.getSuperclass();
                }
            }
            if (method2 != null && (parameterAnnotations = method2.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static Object f(Object obj, Class cls, y4.h hVar) {
        Calendar calendar;
        int i11 = 0;
        if (obj == null) {
            if (cls == Integer.TYPE) {
                return 0;
            }
            if (cls == Long.TYPE) {
                return 0L;
            }
            if (cls == Short.TYPE) {
                return (short) 0;
            }
            if (cls == Byte.TYPE) {
                return (byte) 0;
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(0.0f);
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(0.0d);
            }
            if (cls == Boolean.TYPE) {
                return Boolean.FALSE;
            }
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls == obj.getClass()) {
            return obj;
        }
        if (obj instanceof Map) {
            if (cls == Map.class) {
                return obj;
            }
            Map map = (Map) obj;
            return (cls != Object.class || map.containsKey(com.alibaba.fastjson.a.DEFAULT_TYPE_KEY)) ? v(map, cls, hVar) : obj;
        }
        if (cls.isArray()) {
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                Object newInstance = Array.newInstance(cls.getComponentType(), collection.size());
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Array.set(newInstance, i11, f(it.next(), cls.getComponentType(), hVar));
                    i11++;
                }
                return newInstance;
            }
            if (cls == byte[].class) {
                return m(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return k(obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return l(obj);
        }
        if (cls == Character.TYPE || cls == Character.class) {
            return n(obj);
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return x(obj);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return t(obj);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return w(obj);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return s(obj);
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return q(obj);
        }
        if (cls == String.class) {
            return A(obj);
        }
        if (cls == BigDecimal.class) {
            return i(obj);
        }
        if (cls == BigInteger.class) {
            return j(obj);
        }
        if (cls == java.util.Date.class) {
            return o(obj);
        }
        Object a11 = i.a(S, obj, cls);
        if (a11 != null) {
            return a11;
        }
        if (cls.isEnum()) {
            return r(obj, cls, hVar);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            java.util.Date o11 = o(obj);
            if (cls == Calendar.class) {
                calendar = Calendar.getInstance(com.alibaba.fastjson.a.defaultTimeZone, com.alibaba.fastjson.a.defaultLocale);
            } else {
                try {
                    calendar = (Calendar) cls.newInstance();
                } catch (Exception e11) {
                    throw new JSONException("can not cast to : " + cls.getName(), e11);
                }
            }
            calendar.setTime(o11);
            return calendar;
        }
        String name = cls.getName();
        if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
            java.util.Date o12 = o(obj);
            Calendar calendar2 = Calendar.getInstance(com.alibaba.fastjson.a.defaultTimeZone, com.alibaba.fastjson.a.defaultLocale);
            calendar2.setTime(o12);
            return v.f426b.f(calendar2);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (cls == Currency.class) {
                return Currency.getInstance(str);
            }
            if (cls == Locale.class) {
                return O0(str);
            }
            if (name.startsWith("java.time.")) {
                return com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(str), cls);
            }
        }
        if (hVar.m(cls) != null) {
            return com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(obj), cls);
        }
        throw new JSONException("can not cast to : " + cls.getName());
    }

    public static int f0(Class cls) {
        x4.d dVar = (x4.d) N(cls, x4.d.class);
        if (dVar == null) {
            return 0;
        }
        return Feature.of(dVar.parseFeatures());
    }

    public static Object g(Object obj, ParameterizedType parameterizedType, y4.h hVar) {
        Type rawType = parameterizedType.getRawType();
        if (rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                ArrayList arrayList = new ArrayList(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    arrayList.add(type instanceof Class ? (next == null || next.getClass() != JSONObject.class) ? f(next, (Class) type, hVar) : ((JSONObject) next).toJavaObject((Class) type, hVar, 0) : h(next, type, hVar));
                }
                return arrayList;
            }
        }
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == Collection.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                Collection hashSet = (rawType == Set.class || rawType == HashSet.class) ? new HashSet() : rawType == TreeSet.class ? new TreeSet() : new ArrayList();
                Iterator it2 = ((Iterable) obj).iterator();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    hashSet.add(type2 instanceof Class ? (next2 == null || next2.getClass() != JSONObject.class) ? f(next2, (Class) type2, hVar) : ((JSONObject) next2).toJavaObject((Class) type2, hVar, 0) : h(next2, type2, hVar));
                }
                return hashSet;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    hashMap.put(h(entry.getKey(), type3, hVar), h(entry.getValue(), type4, hVar));
                }
                return hashMap;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments.length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return h(obj, rawType, hVar);
        }
        if (rawType == Map.Entry.class && (obj instanceof Map)) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                Map.Entry entry2 = (Map.Entry) map.entrySet().iterator().next();
                Object value = entry2.getValue();
                if (actualTypeArguments.length == 2 && (value instanceof Map)) {
                    entry2.setValue(h(value, actualTypeArguments[1], hVar));
                }
                return entry2;
            }
        }
        if (rawType instanceof Class) {
            if (hVar == null) {
                hVar = y4.h.f79001z;
            }
            b2 p11 = hVar.p(rawType);
            if (p11 != null) {
                return p11.c(new y4.a(com.alibaba.fastjson.a.toJSONString(obj), hVar), parameterizedType, null);
            }
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    private static String g0(Map map, String str, String str2, int i11) {
        if (!f18251c || map.containsKey(str2)) {
            return str2;
        }
        String substring = str.substring(i11);
        return map.containsKey(substring) ? substring : str2;
    }

    public static Object h(Object obj, Type type, y4.h hVar) {
        if (obj == null) {
            return null;
        }
        if (type instanceof Class) {
            return f(obj, (Class) type, hVar);
        }
        if (type instanceof ParameterizedType) {
            return g(obj, (ParameterizedType) type, hVar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    public static String h0(String str) {
        return Character.toLowerCase(str.charAt(3)) + str.substring(4);
    }

    public static BigDecimal i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f11 = (Float) obj;
            if (Float.isNaN(f11.floatValue()) || Float.isInfinite(f11.floatValue())) {
                return null;
            }
        } else if (obj instanceof Double) {
            Double d11 = (Double) obj;
            if (Double.isNaN(d11.doubleValue()) || Double.isInfinite(d11.doubleValue())) {
                return null;
            }
        } else {
            if (obj instanceof BigDecimal) {
                return (BigDecimal) obj;
            }
            if (obj instanceof BigInteger) {
                return new BigDecimal((BigInteger) obj);
            }
            if ((obj instanceof Map) && ((Map) obj).size() == 0) {
                return null;
            }
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || obj2.equalsIgnoreCase("null")) {
            return null;
        }
        if (obj2.length() <= 65535) {
            return new BigDecimal(obj2);
        }
        throw new JSONException("decimal overflow");
    }

    public static Class i0(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return i0(((ParameterizedType) type).getRawType());
        }
        if (!(type instanceof WildcardType)) {
            throw new JSONException("TODO");
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        if (upperBounds.length == 1) {
            return i0(upperBounds[0]);
        }
        throw new JSONException("TODO");
    }

    public static BigInteger j(Object obj) {
        BigDecimal bigDecimal;
        int scale;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f11 = (Float) obj;
            if (Float.isNaN(f11.floatValue()) || Float.isInfinite(f11.floatValue())) {
                return null;
            }
            return BigInteger.valueOf(f11.longValue());
        }
        if (obj instanceof Double) {
            Double d11 = (Double) obj;
            if (Double.isNaN(d11.doubleValue()) || Double.isInfinite(d11.doubleValue())) {
                return null;
            }
            return BigInteger.valueOf(d11.longValue());
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof BigDecimal) && (scale = (bigDecimal = (BigDecimal) obj).scale()) > -1000 && scale < 1000) {
            return bigDecimal.toBigInteger();
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || obj2.equalsIgnoreCase("null")) {
            return null;
        }
        if (obj2.length() <= 65535) {
            return new BigInteger(obj2);
        }
        throw new JSONException("decimal overflow");
    }

    public static x4.b j0(Class cls, Method method) {
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                for (Method method2 : cls2.getMethods()) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i11 = 0;
                        while (true) {
                            if (i11 >= parameterTypes.length) {
                                x4.b bVar = (x4.b) P(method2, x4.b.class);
                                if (bVar != null) {
                                    return bVar;
                                }
                            } else {
                                if (!parameterTypes2[i11].equals(parameterTypes[i11])) {
                                    break;
                                }
                                i11++;
                            }
                        }
                    }
                }
            }
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= parameterTypes3.length) {
                            x4.b bVar2 = (x4.b) P(method3, x4.b.class);
                            if (bVar2 != null) {
                                return bVar2;
                            }
                        } else {
                            if (!parameterTypes4[i12].equals(parameterTypes3[i12])) {
                                break;
                            }
                            i12++;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static Boolean k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof BigDecimal) {
            return Boolean.valueOf(l0((BigDecimal) obj) == 1);
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || "T".equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to boolean, value : " + obj);
    }

    private static Type k0(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length > 0 ? upperBounds[0] : Object.class;
    }

    public static Byte l(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Byte.valueOf(e((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        if (obj instanceof Boolean) {
            return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static int l0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int scale = bigDecimal.scale();
        return (scale < -100 || scale > 100) ? bigDecimal.intValueExact() : bigDecimal.intValue();
    }

    public static byte[] m(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return com.alibaba.fastjson.util.f.c((String) obj);
        }
        throw new JSONException("can not cast to byte[], value : " + obj);
    }

    public static boolean m0(Method method) {
        if (method == null) {
            return false;
        }
        if (f18263o == null && !f18264p) {
            try {
                f18263o = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable unused) {
                f18264p = true;
            }
        }
        if (f18263o != null) {
            return method.isAnnotationPresent(f18261m) || method.isAnnotationPresent(f18263o);
        }
        return false;
    }

    public static Character n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to char, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new JSONException("can not cast to char, value : " + obj);
    }

    public static boolean n0(Method method) {
        if (method == null) {
            return false;
        }
        if (f18261m == null && !f18262n) {
            try {
                f18261m = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                f18262n = true;
            }
        }
        Class<? extends Annotation> cls = f18261m;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static java.util.Date o(Object obj) {
        return p(obj, null);
    }

    public static boolean o0(Class cls) {
        Boolean bool = (Boolean) i.b(O, cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static java.util.Date p(Object obj, String str) {
        long j11;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.util.Date) {
            return (java.util.Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof BigDecimal) {
            return new java.util.Date(E0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            long longValue = ((Number) obj).longValue();
            if ("unixtime".equals(str)) {
                longValue *= 1000;
            }
            return new java.util.Date(longValue);
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            y4.e eVar = new y4.e(str2);
            try {
                if (eVar.x1(false)) {
                    return eVar.J0().getTime();
                }
                eVar.close();
                if (str2.startsWith("/Date(") && str2.endsWith(")/")) {
                    str2 = str2.substring(6, str2.length() - 2);
                }
                if (str2.indexOf(45) > 0 || str2.indexOf(43) > 0 || str != null) {
                    if (str == null) {
                        int length = str2.length();
                        str = (length == com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT.length() || (length == 22 && com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ"))) ? com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT : length == 10 ? "yyyy-MM-dd" : length == 19 ? "yyyy-MM-dd HH:mm:ss" : (length == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : (length == 23 && str2.charAt(19) == ',') ? "yyyy-MM-dd HH:mm:ss,SSS" : "yyyy-MM-dd HH:mm:ss.SSS";
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, com.alibaba.fastjson.a.defaultLocale);
                    simpleDateFormat.setTimeZone(com.alibaba.fastjson.a.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(str2);
                    } catch (ParseException unused) {
                        throw new JSONException("can not cast to Date, value : " + str2);
                    }
                }
                if (str2.length() == 0) {
                    return null;
                }
                j11 = Long.parseLong(str2);
            } finally {
                eVar.close();
            }
        } else {
            j11 = -1;
        }
        if (j11 != -1) {
            return new java.util.Date(j11);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (f18254f == null && !f18253e) {
                try {
                    f18254f = cls.getMethod("toJdbc", null);
                } catch (NoSuchMethodException unused2) {
                } catch (Throwable th2) {
                    f18253e = true;
                    throw th2;
                }
                f18253e = true;
            }
            try {
                return (java.util.Date) f18254f.invoke(obj, null);
            } catch (Exception e11) {
                throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e11);
            }
        }
        if (!"oracle.sql.DATE".equals(cls.getName())) {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
        if (f18256h == null && !f18255g) {
            try {
                f18256h = cls.getMethod("toJdbc", null);
            } catch (NoSuchMethodException unused3) {
            } catch (Throwable th3) {
                f18255g = true;
                throw th3;
            }
            f18255g = true;
        }
        try {
            return (java.util.Date) f18256h.invoke(obj, null);
        } catch (Exception e12) {
            throw new JSONException("can not cast oracle.sql.DATE to Date", e12);
        }
    }

    public static boolean p0(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        return genericSuperclass != Object.class && p0(genericSuperclass);
    }

    public static Double q(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Double.valueOf(((Boolean) obj).booleanValue() ? 1.0d : 0.0d);
            }
            throw new JSONException("can not cast to double, value : " + obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
            return null;
        }
        if (obj2.indexOf(44) != -1) {
            obj2 = obj2.replaceAll(",", "");
        }
        return Double.valueOf(Double.parseDouble(obj2));
    }

    public static boolean q0(Object obj) {
        if (obj == null) {
            return false;
        }
        if (f18265q == null && !f18266r) {
            try {
                f18265q = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
            } catch (Throwable unused) {
                f18266r = true;
            }
        }
        Method method = f18265q;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, obj)).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    public static Object r(Object obj, Class cls, y4.h hVar) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                if (hVar == null) {
                    hVar = y4.h.t();
                }
                b2 p11 = hVar.p(cls);
                return p11 instanceof z4.h ? ((z4.h) p11).a(J(str)) : Enum.valueOf(cls, str);
            }
            if (obj instanceof BigDecimal) {
                int l02 = l0((BigDecimal) obj);
                Object[] enumConstants = cls.getEnumConstants();
                if (l02 < enumConstants.length) {
                    return enumConstants[l02];
                }
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                Object[] enumConstants2 = cls.getEnumConstants();
                if (intValue < enumConstants2.length) {
                    return enumConstants2[intValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e11) {
            throw new JSONException("can not cast to : " + cls.getName(), e11);
        }
    }

    private static boolean r0(Class cls, String str) {
        x4.d dVar = (x4.d) N(cls, x4.d.class);
        if (dVar != null) {
            String[] includes = dVar.includes();
            if (includes.length > 0) {
                for (String str2 : includes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : dVar.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        if (cls.getSuperclass() == Object.class || cls.getSuperclass() == null) {
            return false;
        }
        return r0(cls.getSuperclass(), str);
    }

    public static Float s(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Float.valueOf(((Boolean) obj).booleanValue() ? 1.0f : 0.0f);
            }
            throw new JSONException("can not cast to float, value : " + obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
            return null;
        }
        if (obj2.indexOf(44) != -1) {
            obj2 = obj2.replaceAll(",", "");
        }
        return Float.valueOf(Float.parseFloat(obj2));
    }

    public static boolean s0(Method method) {
        if (method == null) {
            return false;
        }
        if (F == null && !G) {
            try {
                F = Class.forName("com.fasterxml.jackson.annotation.JsonCreator");
            } catch (Throwable unused) {
                G = true;
            }
        }
        Class<? extends Annotation> cls = F;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static Integer t(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            return Integer.valueOf(l0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != -1) {
                str = str.replaceAll(",", "");
            }
            Matcher matcher = f18249a.matcher(str);
            if (matcher.find()) {
                str = matcher.replaceAll("");
            }
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return t(it.next());
            }
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static boolean t0(Class cls) {
        if (f18267s == null && !f18268t) {
            try {
                f18267s = Metadata.class;
            } catch (Throwable unused) {
                f18268t = true;
            }
        }
        return f18267s != null && cls.isAnnotationPresent(f18267s);
    }

    public static Object u(Object obj, Class cls) {
        return f(obj, cls, y4.h.t());
    }

    private static boolean u0(Class cls, String str) {
        if (A == null && !B) {
            try {
                HashMap hashMap = new HashMap();
                CharRange.Companion companion = CharRange.INSTANCE;
                hashMap.put(CharRange.class, new String[]{"getEndInclusive", "isEmpty"});
                IntRange.Companion companion2 = IntRange.INSTANCE;
                hashMap.put(IntRange.class, new String[]{"getEndInclusive", "isEmpty"});
                LongRange.Companion companion3 = LongRange.INSTANCE;
                hashMap.put(LongRange.class, new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.b"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.a"), new String[]{"getEndInclusive", "isEmpty"});
                A = hashMap;
            } catch (Throwable unused) {
                B = true;
            }
        }
        if (A == null) {
            return false;
        }
        String[] strArr = (String[]) A.get(cls);
        return strArr != null && Arrays.binarySearch(strArr, str) >= 0;
    }

    public static Object v(Map map, Class cls, y4.h hVar) {
        int i11 = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i11 = number instanceof BigDecimal ? ((BigDecimal) number).intValueExact() : number.intValue();
                }
                return new StackTraceElement(str, str2, str3, i11);
            }
            Object obj = map.get(com.alibaba.fastjson.a.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (hVar == null) {
                    hVar = y4.h.f79001z;
                }
                Class i12 = hVar.i(str4, null);
                if (i12 == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!i12.equals(cls)) {
                    return v(map, i12, hVar);
                }
            }
            if (cls.isInterface()) {
                JSONObject jSONObject = map instanceof JSONObject ? (JSONObject) map : new JSONObject((Map<String, Object>) map);
                if (hVar == null) {
                    hVar = y4.h.t();
                }
                return hVar.m(cls) != null ? com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(jSONObject), cls) : Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get(TmcConstants.KEY_LANGUAGE);
                Object obj3 = map.get(PlaceTypes.COUNTRY);
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof JSONObject)) {
                return map.toString();
            }
            if (cls == com.alibaba.fastjson.a.class && (map instanceof JSONObject)) {
                return map;
            }
            if (cls == LinkedHashMap.class && (map instanceof JSONObject)) {
                Map<String, Object> innerMap = ((JSONObject) map).getInnerMap();
                if (innerMap instanceof LinkedHashMap) {
                    return innerMap;
                }
            }
            if (cls.isInstance(map)) {
                return map;
            }
            if (cls == JSONObject.class) {
                return new JSONObject((Map<String, Object>) map);
            }
            if (hVar == null) {
                hVar = y4.h.t();
            }
            b2 p11 = hVar.p(cls);
            o oVar = p11 instanceof o ? (o) p11 : null;
            if (oVar != null) {
                return oVar.e(map, hVar);
            }
            throw new JSONException("can not get javaBeanDeserializer. " + cls.getName());
        } catch (Exception e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public static boolean v0(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt == '+' || charAt == '-') {
                if (i11 != 0) {
                    return false;
                }
            } else if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static Long w(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Long.valueOf(E0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != -1) {
                str = str.replaceAll(",", "");
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                y4.e eVar = new y4.e(str);
                Calendar J0 = eVar.x1(false) ? eVar.J0() : null;
                eVar.close();
                if (J0 != null) {
                    return Long.valueOf(J0.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return w(it.next());
            }
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static boolean w0(Class cls) {
        if (D == null && !E) {
            try {
                D = Class.forName("java.nio.file.Path");
            } catch (Throwable unused) {
                E = true;
            }
        }
        Class cls2 = D;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static Short x(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Short.valueOf(N0((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        if (obj instanceof Boolean) {
            return Short.valueOf(((Boolean) obj).booleanValue() ? (short) 1 : (short) 0);
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static boolean x0(Class cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (V.contains(cls2.getName())) {
                return true;
            }
        }
        return false;
    }

    public static Object y(Object obj) {
        return i.b(P, obj);
    }

    public static boolean y0(Method method) {
        if (method == null) {
            return false;
        }
        if (!f18259k) {
            try {
                f18260l = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } catch (Throwable th2) {
                f18259k = true;
                throw th2;
            }
            f18259k = true;
        }
        Class cls = f18260l;
        return (cls == null || P(method, cls) == null) ? false : true;
    }

    public static Object z(Object obj) {
        return i.b(Q, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean z0(java.lang.Class r5) {
        /*
            java.lang.Class r0 = com.alibaba.fastjson.util.TypeUtils.I
            r1 = 1
            if (r0 != 0) goto L14
            boolean r0 = com.alibaba.fastjson.util.TypeUtils.J
            if (r0 != 0) goto L14
            java.lang.String r0 = "javax.xml.bind.annotation.XmlAccessorType"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L12
            com.alibaba.fastjson.util.TypeUtils.I = r0     // Catch: java.lang.Throwable -> L12
            goto L14
        L12:
            com.alibaba.fastjson.util.TypeUtils.J = r1
        L14:
            java.lang.Class r0 = com.alibaba.fastjson.util.TypeUtils.I
            r2 = 0
            if (r0 != 0) goto L1a
            return r2
        L1a:
            java.lang.Class r0 = com.alibaba.fastjson.util.TypeUtils.I
            java.lang.annotation.Annotation r5 = N(r5, r0)
            if (r5 != 0) goto L23
            return r2
        L23:
            java.lang.reflect.Method r0 = com.alibaba.fastjson.util.TypeUtils.K
            r3 = 0
            if (r0 != 0) goto L39
            boolean r0 = com.alibaba.fastjson.util.TypeUtils.J
            if (r0 != 0) goto L39
            java.lang.Class r0 = com.alibaba.fastjson.util.TypeUtils.I     // Catch: java.lang.Throwable -> L37
            java.lang.String r4 = "value"
            java.lang.reflect.Method r0 = r0.getMethod(r4, r3)     // Catch: java.lang.Throwable -> L37
            com.alibaba.fastjson.util.TypeUtils.K = r0     // Catch: java.lang.Throwable -> L37
            goto L39
        L37:
            com.alibaba.fastjson.util.TypeUtils.J = r1
        L39:
            java.lang.reflect.Method r0 = com.alibaba.fastjson.util.TypeUtils.K
            if (r0 != 0) goto L3e
            return r2
        L3e:
            boolean r0 = com.alibaba.fastjson.util.TypeUtils.J
            if (r0 != 0) goto L4b
            java.lang.reflect.Method r0 = com.alibaba.fastjson.util.TypeUtils.K     // Catch: java.lang.Throwable -> L49
            java.lang.Object r5 = r0.invoke(r5, r3)     // Catch: java.lang.Throwable -> L49
            goto L4c
        L49:
            com.alibaba.fastjson.util.TypeUtils.J = r1
        L4b:
            r5 = r3
        L4c:
            if (r5 != 0) goto L4f
            return r2
        L4f:
            java.lang.Class r0 = com.alibaba.fastjson.util.TypeUtils.H
            if (r0 != 0) goto L74
            boolean r0 = com.alibaba.fastjson.util.TypeUtils.J
            if (r0 != 0) goto L74
            java.lang.String r0 = "javax.xml.bind.annotation.XmlAccessType"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L72
            com.alibaba.fastjson.util.TypeUtils.H = r0     // Catch: java.lang.Throwable -> L72
            java.lang.Class r0 = com.alibaba.fastjson.util.TypeUtils.H     // Catch: java.lang.Throwable -> L72
            java.lang.String r4 = "FIELD"
            java.lang.reflect.Field r0 = r0.getField(r4)     // Catch: java.lang.Throwable -> L72
            com.alibaba.fastjson.util.TypeUtils.L = r0     // Catch: java.lang.Throwable -> L72
            java.lang.reflect.Field r0 = com.alibaba.fastjson.util.TypeUtils.L     // Catch: java.lang.Throwable -> L72
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L72
            com.alibaba.fastjson.util.TypeUtils.M = r0     // Catch: java.lang.Throwable -> L72
            goto L74
        L72:
            com.alibaba.fastjson.util.TypeUtils.J = r1
        L74:
            java.lang.Object r0 = com.alibaba.fastjson.util.TypeUtils.M
            if (r5 != r0) goto L79
            goto L7a
        L79:
            r1 = r2
        L7a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.z0(java.lang.Class):boolean");
    }
}
