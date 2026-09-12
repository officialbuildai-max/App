package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final Class f18324a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f18325b;

    /* renamed from: c, reason: collision with root package name */
    public final Constructor f18326c;

    /* renamed from: d, reason: collision with root package name */
    public final Constructor f18327d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f18328e;

    /* renamed from: f, reason: collision with root package name */
    public final Method f18329f;

    /* renamed from: g, reason: collision with root package name */
    public final int f18330g;

    /* renamed from: h, reason: collision with root package name */
    public final d[] f18331h;

    /* renamed from: i, reason: collision with root package name */
    public final d[] f18332i;

    /* renamed from: j, reason: collision with root package name */
    public final int f18333j;

    /* renamed from: k, reason: collision with root package name */
    public final x4.d f18334k;

    /* renamed from: l, reason: collision with root package name */
    public final String f18335l;

    /* renamed from: m, reason: collision with root package name */
    public final String f18336m;

    /* renamed from: n, reason: collision with root package name */
    public String[] f18337n;

    /* renamed from: o, reason: collision with root package name */
    public Type[] f18338o;

    /* renamed from: p, reason: collision with root package name */
    public String[] f18339p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f18340q;

    /* renamed from: r, reason: collision with root package name */
    public Constructor f18341r;

    public h(Class cls, Class cls2, Constructor constructor, Constructor constructor2, Method method, Method method2, x4.d dVar, List list) {
        x4.b bVar;
        this.f18324a = cls;
        this.f18325b = cls2;
        this.f18326c = constructor;
        this.f18327d = constructor2;
        this.f18328e = method;
        this.f18333j = TypeUtils.f0(cls);
        this.f18329f = method2;
        this.f18334k = dVar;
        if (dVar != null) {
            String typeName = dVar.typeName();
            String typeKey = dVar.typeKey();
            this.f18336m = typeKey.length() <= 0 ? null : typeKey;
            if (typeName.length() != 0) {
                this.f18335l = typeName;
            } else {
                this.f18335l = cls.getName();
            }
            String[] orders = dVar.orders();
            this.f18337n = orders.length == 0 ? null : orders;
        } else {
            this.f18335l = cls.getName();
            this.f18336m = null;
            this.f18337n = null;
        }
        d[] dVarArr = new d[list.size()];
        this.f18331h = dVarArr;
        list.toArray(dVarArr);
        d[] dVarArr2 = new d[dVarArr.length];
        int i11 = 0;
        if (this.f18337n != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (d dVar2 : dVarArr) {
                linkedHashMap.put(dVar2.f18279a, dVar2);
            }
            int i12 = 0;
            for (String str : this.f18337n) {
                d dVar3 = (d) linkedHashMap.get(str);
                if (dVar3 != null) {
                    dVarArr2[i12] = dVar3;
                    linkedHashMap.remove(str);
                    i12++;
                }
            }
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                dVarArr2[i12] = (d) it.next();
                i12++;
            }
        } else {
            System.arraycopy(dVarArr, 0, dVarArr2, 0, dVarArr.length);
            Arrays.sort(dVarArr2);
        }
        this.f18332i = Arrays.equals(this.f18331h, dVarArr2) ? this.f18331h : dVarArr2;
        if (constructor != null) {
            this.f18330g = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.f18330g = method.getParameterTypes().length;
        } else {
            this.f18330g = 0;
        }
        if (constructor2 != null) {
            this.f18338o = constructor2.getParameterTypes();
            boolean t02 = TypeUtils.t0(cls);
            this.f18340q = t02;
            if (!t02) {
                if (this.f18338o.length == this.f18331h.length) {
                    while (true) {
                        Type[] typeArr = this.f18338o;
                        if (i11 >= typeArr.length) {
                            return;
                        }
                        if (typeArr[i11] != this.f18331h[i11].f18283e) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                this.f18339p = b.f(constructor2);
                return;
            }
            this.f18339p = TypeUtils.a0(cls);
            try {
                this.f18341r = cls.getConstructor(null);
            } catch (Throwable unused) {
            }
            Annotation[][] d02 = TypeUtils.d0(constructor2);
            for (int i13 = 0; i13 < this.f18339p.length && i13 < d02.length; i13++) {
                Annotation[] annotationArr = d02[i13];
                int length = annotationArr.length;
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        bVar = null;
                        break;
                    }
                    Annotation annotation = annotationArr[i14];
                    if (annotation instanceof x4.b) {
                        bVar = (x4.b) annotation;
                        break;
                    }
                    i14++;
                }
                if (bVar != null) {
                    String name = bVar.name();
                    if (name.length() > 0) {
                        this.f18339p[i13] = name;
                    }
                }
            }
        }
    }

    static boolean a(List list, d dVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            d dVar2 = (d) list.get(size);
            if (dVar2.f18279a.equals(dVar.f18279a) && (!dVar2.f18286h || dVar.f18286h)) {
                if (dVar2.f18283e.isAssignableFrom(dVar.f18283e)) {
                    list.set(size, dVar);
                    return true;
                }
                if (dVar2.compareTo(dVar) >= 0) {
                    return false;
                }
                list.set(size, dVar);
                return true;
            }
        }
        list.add(dVar);
        return true;
    }

    public static h b(Class cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return c(cls, type, propertyNamingStrategy, false, TypeUtils.f18250b, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:385:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x028e  */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [x4.b] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r6v25, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.alibaba.fastjson.util.h c(java.lang.Class r57, java.lang.reflect.Type r58, com.alibaba.fastjson.PropertyNamingStrategy r59, boolean r60, boolean r61, boolean r62) {
        /*
            Method dump skipped, instructions count: 3223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.h.c(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy, boolean, boolean, boolean):com.alibaba.fastjson.util.h");
    }

    private static Map d(Class cls) {
        Class superclass = cls.getSuperclass();
        HashMap hashMap = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            Class cls2 = superclass;
            Class cls3 = cls;
            cls = cls2;
            if (cls == null || cls == Object.class) {
                break;
            }
            if (cls3.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    if (hashMap.containsKey(actualTypeArguments[i11])) {
                        hashMap.put(typeParameters[i11], (Type) hashMap.get(actualTypeArguments[i11]));
                    } else {
                        hashMap.put(typeParameters[i11], actualTypeArguments[i11]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (java.util.concurrent.atomic.AtomicBoolean.class.equals(r2) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(java.lang.Class r20, java.lang.reflect.Type r21, com.alibaba.fastjson.PropertyNamingStrategy r22, java.util.List r23, java.lang.reflect.Field[] r24) {
        /*
            r0 = r22
            r1 = r24
            java.util.Map r15 = d(r20)
            int r14 = r1.length
            r16 = 0
            r13 = r16
        Ld:
            if (r13 >= r14) goto Ldc
            r5 = r1[r13]
            int r2 = r5.getModifiers()
            r3 = r2 & 8
            if (r3 == 0) goto L21
        L19:
            r2 = r23
            r17 = r13
            r18 = r14
            goto Ld6
        L21:
            r2 = r2 & 16
            if (r2 == 0) goto L51
            java.lang.Class r2 = r5.getType()
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 != 0) goto L51
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 != 0) goto L51
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r3 = java.util.concurrent.atomic.AtomicLong.class
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L51
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r3 = java.util.concurrent.atomic.AtomicInteger.class
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L51
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r3 = java.util.concurrent.atomic.AtomicBoolean.class
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L19
        L51:
            java.util.Iterator r2 = r23.iterator()
        L55:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L6e
            java.lang.Object r3 = r2.next()
            com.alibaba.fastjson.util.d r3 = (com.alibaba.fastjson.util.d) r3
            java.lang.String r3 = r3.f18279a
            java.lang.String r4 = r5.getName()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L55
            goto L19
        L6e:
            java.lang.String r2 = r5.getName()
            java.lang.Class<x4.b> r3 = x4.b.class
            java.lang.annotation.Annotation r3 = com.alibaba.fastjson.util.TypeUtils.O(r5, r3)
            r12 = r3
            x4.b r12 = (x4.b) r12
            if (r12 == 0) goto Laa
            boolean r3 = r12.deserialize()
            if (r3 != 0) goto L84
            goto L19
        L84:
            int r3 = r12.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r12.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            com.alibaba.fastjson.parser.Feature[] r6 = r12.parseFeatures()
            int r6 = com.alibaba.fastjson.parser.Feature.of(r6)
            java.lang.String r7 = r12.name()
            int r7 = r7.length()
            if (r7 == 0) goto La6
            java.lang.String r2 = r12.name()
        La6:
            r8 = r3
            r9 = r4
            r10 = r6
            goto Lae
        Laa:
            r8 = r16
            r9 = r8
            r10 = r9
        Lae:
            if (r0 == 0) goto Lb4
            java.lang.String r2 = r0.translate(r2)
        Lb4:
            r3 = r2
            com.alibaba.fastjson.util.d r11 = new com.alibaba.fastjson.util.d
            r17 = 0
            r18 = 0
            r4 = 0
            r2 = r11
            r6 = r20
            r7 = r21
            r19 = r11
            r11 = r17
            r17 = r13
            r13 = r18
            r18 = r14
            r14 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r2 = r23
            r3 = r19
            a(r2, r3)
        Ld6:
            int r13 = r17 + 1
            r14 = r18
            goto Ld
        Ldc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.h.e(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy, java.util.List, java.lang.reflect.Field[]):void");
    }

    public static Class f(Class cls, x4.d dVar) {
        Class builder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return TypeUtils.A0("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (dVar == null || (builder = dVar.builder()) == Void.class) {
            return null;
        }
        return builder;
    }

    public static Constructor g(Constructor[] constructorArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            if (((x4.a) constructor2.getAnnotation(x4.a.class)) != null) {
                if (constructor != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Annotation[][] d02 = TypeUtils.d0(constructor3);
            if (d02.length != 0) {
                int length = d02.length;
                int i11 = 0;
                while (true) {
                    if (i11 < length) {
                        for (Annotation annotation : d02[i11]) {
                            if (annotation instanceof x4.b) {
                                break;
                            }
                        }
                    } else {
                        if (constructor != null) {
                            throw new JSONException("multi-JSONCreator");
                        }
                        constructor = constructor3;
                    }
                    i11++;
                }
            }
        }
        return constructor;
    }

    static Constructor h(Class cls, Constructor[] constructorArr) {
        Constructor constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        int length = constructorArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            Constructor constructor2 = constructorArr[i11];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i11++;
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Class<?>[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    private static Method i(Class cls, Method[] methodArr, boolean z10) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((x4.a) TypeUtils.P(method2, x4.a.class)) != null) {
                if (method != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                method = method2;
            }
        }
        if (method != null || !z10) {
            return method;
        }
        for (Method method3 : methodArr) {
            if (TypeUtils.s0(method3)) {
                return method3;
            }
        }
        return method;
    }

    private static d j(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f18279a.equals(str)) {
                return dVar;
            }
            Field field = dVar.f18281c;
            if (field != null && dVar.e() != null && field.getName().equals(str)) {
                return dVar;
            }
        }
        return null;
    }
}
