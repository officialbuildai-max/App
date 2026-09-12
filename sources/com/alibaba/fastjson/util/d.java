package com.alibaba.fastjson.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

/* loaded from: classes2.dex */
public class d implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final String f18279a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f18280b;

    /* renamed from: c, reason: collision with root package name */
    public final Field f18281c;

    /* renamed from: d, reason: collision with root package name */
    private int f18282d;

    /* renamed from: e, reason: collision with root package name */
    public final Class f18283e;

    /* renamed from: f, reason: collision with root package name */
    public final Type f18284f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f18285g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f18286h;

    /* renamed from: i, reason: collision with root package name */
    public final int f18287i;

    /* renamed from: j, reason: collision with root package name */
    public final int f18288j;

    /* renamed from: k, reason: collision with root package name */
    public final String f18289k;

    /* renamed from: l, reason: collision with root package name */
    private final x4.b f18290l;

    /* renamed from: m, reason: collision with root package name */
    private final x4.b f18291m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f18292n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f18293o;

    /* renamed from: p, reason: collision with root package name */
    public final char[] f18294p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f18295q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f18296r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f18297s;

    /* renamed from: t, reason: collision with root package name */
    public final String f18298t;

    /* renamed from: u, reason: collision with root package name */
    public final String[] f18299u;

    /* renamed from: v, reason: collision with root package name */
    public final long f18300v;

    public d(String str, Class cls, Class cls2, Type type, Field field, int i11, int i12, int i13) {
        this.f18282d = 0;
        i11 = i11 < 0 ? 0 : i11;
        this.f18279a = str;
        this.f18285g = cls;
        this.f18283e = cls2;
        this.f18284f = type;
        this.f18280b = null;
        this.f18281c = field;
        this.f18282d = i11;
        this.f18287i = i12;
        this.f18288j = i13;
        this.f18295q = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f18292n = true;
            this.f18293o = Modifier.isTransient(modifiers);
        } else {
            this.f18293o = false;
            this.f18292n = false;
        }
        this.f18294p = b();
        if (field != null) {
            TypeUtils.M0(field);
        }
        this.f18289k = "";
        x4.b bVar = field == null ? null : (x4.b) TypeUtils.O(field, x4.b.class);
        this.f18290l = bVar;
        this.f18291m = null;
        this.f18286h = false;
        this.f18296r = false;
        this.f18297s = false;
        this.f18298t = null;
        this.f18299u = new String[0];
        this.f18300v = n(str, bVar);
    }

    public d(String str, Method method, Field field, Class cls, Type type, int i11, int i12, int i13, x4.b bVar, x4.b bVar2, String str2) {
        this(str, method, field, cls, type, i11, i12, i13, bVar, bVar2, str2, null);
    }

    public d(String str, Method method, Field field, Class cls, Type type, int i11, int i12, int i13, x4.b bVar, x4.b bVar2, String str2, Map map) {
        boolean z10;
        boolean isFinal;
        Class<?> cls2;
        Type type2;
        Type l11;
        Class<?> cls3;
        Class<?> cls4;
        Type type3;
        Class<?> cls5;
        Type type4;
        boolean z11 = false;
        this.f18282d = 0;
        if (field != null) {
            String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        i11 = i11 < 0 ? 0 : i11;
        this.f18279a = str;
        this.f18280b = method;
        this.f18281c = field;
        this.f18282d = i11;
        this.f18287i = i12;
        this.f18288j = i13;
        this.f18290l = bVar;
        this.f18291m = bVar2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f18292n = (modifiers & 1) != 0 || method == null;
            this.f18293o = Modifier.isTransient(modifiers) || TypeUtils.y0(method);
        } else {
            this.f18292n = false;
            this.f18293o = TypeUtils.y0(method);
        }
        if (str2 == null || str2.length() <= 0) {
            this.f18289k = "";
        } else {
            this.f18289k = str2;
        }
        x4.b e11 = e();
        this.f18300v = n(str, e11);
        if (e11 != null) {
            String format = e11.format();
            r4 = format.trim().length() != 0 ? format : null;
            z10 = e11.jsonDirect();
            this.f18297s = e11.unwrapped();
            this.f18299u = e11.alternateNames();
        } else {
            this.f18297s = false;
            this.f18299u = new String[0];
            z10 = false;
        }
        this.f18298t = r4;
        this.f18294p = b();
        if (method != null) {
            TypeUtils.M0(method);
        }
        if (field != null) {
            TypeUtils.M0(field);
        }
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls4 = parameterTypes[0];
                type4 = method.getGenericParameterTypes()[0];
            } else if (parameterTypes.length == 2 && (cls3 = parameterTypes[0]) == String.class && parameterTypes[1] == Object.class) {
                cls4 = cls3;
                type4 = cls3;
            } else {
                isFinal = true;
                cls5 = method.getReturnType();
                type3 = method.getGenericReturnType();
                this.f18285g = method.getDeclaringClass();
                cls2 = cls5;
                type2 = type3;
            }
            isFinal = false;
            cls5 = cls4;
            type3 = type4;
            this.f18285g = method.getDeclaringClass();
            cls2 = cls5;
            type2 = type3;
        } else {
            Class<?> type5 = field.getType();
            Type genericType = field.getGenericType();
            this.f18285g = field.getDeclaringClass();
            isFinal = Modifier.isFinal(field.getModifiers());
            cls2 = type5;
            type2 = genericType;
        }
        this.f18286h = isFinal;
        if (z10 && cls2 == String.class) {
            z11 = true;
        }
        this.f18296r = z11;
        if (cls != null && cls2 == Object.class && (type2 instanceof TypeVariable) && (l11 = l(cls, type, (TypeVariable) type2)) != null) {
            this.f18283e = TypeUtils.Q(l11);
            this.f18284f = l11;
            this.f18295q = cls2.isEnum();
            return;
        }
        boolean z12 = type2 instanceof Class;
        Class<?> cls6 = cls2;
        Type type6 = type2;
        if (!z12) {
            Type j11 = j(cls, type == null ? cls : type, type2, map);
            Class<?> cls7 = cls2;
            if (j11 != type2) {
                if (j11 instanceof ParameterizedType) {
                    cls7 = TypeUtils.Q(j11);
                } else {
                    cls7 = cls2;
                    if (j11 instanceof Class) {
                        cls7 = TypeUtils.Q(j11);
                    }
                }
            }
            type6 = j11;
            cls6 = cls7;
        }
        this.f18284f = type6;
        this.f18283e = cls6;
        this.f18295q = cls6.isEnum();
    }

    private static boolean f(Type[] typeArr, Map map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        boolean z10 = false;
        for (int i11 = 0; i11 < typeArr.length; i11++) {
            Type type = typeArr[i11];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (f(actualTypeArguments, map)) {
                    typeArr[i11] = com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z10 = true;
                }
            } else {
                if ((type instanceof TypeVariable) && map.containsKey(type)) {
                    typeArr[i11] = (Type) map.get(type);
                    z10 = true;
                }
            }
        }
        return z10;
    }

    private static boolean g(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z10 = false;
        for (int i11 = 0; i11 < typeArr.length; i11++) {
            Type type = typeArr[i11];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (g(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i11] = com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                    z10 = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i12 = 0; i12 < typeVariableArr.length; i12++) {
                    if (type.equals(typeVariableArr[i12])) {
                        typeArr[i11] = typeArr2[i12];
                        z10 = true;
                    }
                }
            }
        }
        return z10;
    }

    public static Type i(Class cls, Type type, Type type2) {
        return j(cls, type, type2, null);
    }

    public static Type j(Class cls, Type type, Type type2, Map map) {
        TypeVariable<Class<?>>[] typeParameters;
        ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type j11 = j(cls, type, genericComponentType, map);
                return genericComponentType != j11 ? Array.newInstance((Class<?>) TypeUtils.Q(j11), 0).getClass() : type2;
            }
            if (!TypeUtils.p0(type)) {
                return type2;
            }
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.Z(type);
                TypeVariable typeVariable = (TypeVariable) type2;
                TypeVariable[] typeParameters2 = TypeUtils.Q(parameterizedType2).getTypeParameters();
                for (int i11 = 0; i11 < typeParameters2.length; i11++) {
                    if (typeParameters2[i11].getName().equals(typeVariable.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i11];
                    }
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                boolean f11 = f(actualTypeArguments, map);
                if (!f11) {
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeParameters = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeParameters = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeParameters = type.getClass().getTypeParameters();
                        parameterizedType = parameterizedType3;
                    }
                    f11 = g(actualTypeArguments, typeParameters, parameterizedType.getActualTypeArguments());
                }
                if (f11) {
                    return com.alibaba.fastjson.g.b(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType()));
                }
            }
        }
        return type2;
    }

    private static Type l(Class cls, Type type, TypeVariable typeVariable) {
        Type[] typeArr;
        Class cls2 = typeVariable.getGenericDeclaration() instanceof Class ? (Class) typeVariable.getGenericDeclaration() : null;
        if (cls2 == cls) {
            typeArr = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            Type[] typeArr2 = null;
            while (cls != null && cls != Object.class && cls != cls2) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    g(actualTypeArguments, cls.getTypeParameters(), typeArr2);
                    typeArr2 = actualTypeArguments;
                }
                cls = cls.getSuperclass();
            }
            typeArr = typeArr2;
        }
        if (typeArr == null || cls2 == null) {
            return null;
        }
        TypeVariable[] typeParameters = cls2.getTypeParameters();
        for (int i11 = 0; i11 < typeParameters.length; i11++) {
            if (typeVariable.equals(typeParameters[i11])) {
                return typeArr[i11];
            }
        }
        return null;
    }

    private long n(String str, x4.b bVar) {
        return (bVar == null || bVar.name().length() == 0) ? TypeUtils.K(str) : TypeUtils.L(str);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        Method method = dVar.f18280b;
        if (method != null && this.f18280b != null && method.isBridge() && !this.f18280b.isBridge() && dVar.f18280b.getName().equals(this.f18280b.getName())) {
            return 1;
        }
        int i11 = this.f18282d;
        int i12 = dVar.f18282d;
        if (i11 < i12) {
            return -1;
        }
        if (i11 > i12) {
            return 1;
        }
        int compareTo = this.f18279a.compareTo(dVar.f18279a);
        if (compareTo != 0) {
            return compareTo;
        }
        Class<?> h11 = h();
        Class<?> h12 = dVar.h();
        if (h11 != null && h12 != null && h11 != h12) {
            if (h11.isAssignableFrom(h12)) {
                return -1;
            }
            if (h12.isAssignableFrom(h11)) {
                return 1;
            }
        }
        Field field = this.f18281c;
        boolean z10 = false;
        boolean z11 = field != null && field.getType() == this.f18283e;
        Field field2 = dVar.f18281c;
        if (field2 != null && field2.getType() == dVar.f18283e) {
            z10 = true;
        }
        if (z11 && !z10) {
            return 1;
        }
        if (z10 && !z11) {
            return -1;
        }
        if (dVar.f18283e.isPrimitive() && !this.f18283e.isPrimitive()) {
            return 1;
        }
        if (this.f18283e.isPrimitive() && !dVar.f18283e.isPrimitive()) {
            return -1;
        }
        if (dVar.f18283e.getName().startsWith("java.") && !this.f18283e.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.f18283e.getName().startsWith("java.") || dVar.f18283e.getName().startsWith("java.")) {
            return this.f18283e.getName().compareTo(dVar.f18283e.getName());
        }
        return -1;
    }

    protected char[] b() {
        int length = this.f18279a.length();
        char[] cArr = new char[length + 3];
        String str = this.f18279a;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    public Object d(Object obj) {
        Method method = this.f18280b;
        return method != null ? method.invoke(obj, null) : this.f18281c.get(obj);
    }

    public x4.b e() {
        x4.b bVar = this.f18290l;
        return bVar != null ? bVar : this.f18291m;
    }

    protected Class h() {
        Method method = this.f18280b;
        if (method != null) {
            return method.getDeclaringClass();
        }
        Field field = this.f18281c;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    public String k() {
        return this.f18298t;
    }

    public Member m() {
        Method method = this.f18280b;
        return method != null ? method : this.f18281c;
    }

    public void o(Object obj, Object obj2) {
        Method method = this.f18280b;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.f18281c.set(obj, obj2);
        }
    }

    public void p() {
        Method method = this.f18280b;
        if (method != null) {
            TypeUtils.M0(method);
        } else {
            TypeUtils.M0(this.f18281c);
        }
    }

    public String toString() {
        return this.f18279a;
    }
}
