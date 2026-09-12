package org.mvel2;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.mvel2.ast.TypeDescriptor;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.ImmutableDefaultFactory;
import org.mvel2.util.m;
import org.mvel2.util.n;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: o, reason: collision with root package name */
    private static final Object[] f72098o = new Object[0];

    /* renamed from: p, reason: collision with root package name */
    private static final Map f72099p = Collections.synchronizedMap(new WeakHashMap(10));

    /* renamed from: q, reason: collision with root package name */
    private static final Map f72100q = Collections.synchronizedMap(new WeakHashMap(10));

    /* renamed from: r, reason: collision with root package name */
    private static final Map f72101r = Collections.synchronizedMap(new WeakHashMap(10));

    /* renamed from: s, reason: collision with root package name */
    private static final Map f72102s = Collections.synchronizedMap(new WeakHashMap(10));

    /* renamed from: a, reason: collision with root package name */
    private int f72103a;

    /* renamed from: b, reason: collision with root package name */
    private int f72104b;

    /* renamed from: c, reason: collision with root package name */
    private int f72105c;

    /* renamed from: d, reason: collision with root package name */
    private char[] f72106d;

    /* renamed from: e, reason: collision with root package name */
    private int f72107e;

    /* renamed from: f, reason: collision with root package name */
    private int f72108f;

    /* renamed from: g, reason: collision with root package name */
    private Object f72109g;

    /* renamed from: h, reason: collision with root package name */
    private Object f72110h;

    /* renamed from: i, reason: collision with root package name */
    private Object f72111i;

    /* renamed from: j, reason: collision with root package name */
    private Class f72112j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f72113k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f72114l;

    /* renamed from: m, reason: collision with root package name */
    private VariableResolverFactory f72115m;

    /* renamed from: n, reason: collision with root package name */
    private ParserContext f72116n;

    public g(String str, Object obj) {
        this.f72103a = 0;
        this.f72104b = 0;
        this.f72112j = null;
        this.f72113k = true;
        this.f72114l = false;
        char[] charArray = str.toCharArray();
        this.f72106d = charArray;
        int length = charArray.length;
        this.f72108f = length;
        this.f72107e = length;
        this.f72110h = obj;
        this.f72115m = new ImmutableDefaultFactory();
    }

    public g(char[] cArr, int i11, int i12, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        this.f72112j = null;
        this.f72113k = true;
        this.f72114l = false;
        this.f72106d = cArr;
        this.f72103a = i11;
        this.f72105c = i11;
        this.f72104b = i11;
        this.f72107e = i12;
        this.f72108f = i11 + i12;
        this.f72110h = obj;
        this.f72115m = variableResolverFactory;
        this.f72109g = obj2;
        this.f72116n = parserContext;
    }

    public g(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        this.f72103a = 0;
        this.f72104b = 0;
        this.f72112j = null;
        this.f72113k = true;
        this.f72114l = false;
        this.f72106d = cArr;
        int length = cArr.length;
        this.f72108f = length;
        this.f72107e = length;
        this.f72110h = obj;
        this.f72115m = variableResolverFactory;
        this.f72109g = obj2;
        this.f72116n = parserContext;
    }

    public static void A(Object obj, VariableResolverFactory variableResolverFactory, String str, Object obj2, ParserContext parserContext) {
        new g(str.toCharArray(), obj, variableResolverFactory, null, parserContext).y(obj2);
    }

    private void D() {
        if (this.f72104b >= this.f72108f) {
            return;
        }
        while (m.q0(this.f72106d[this.f72104b])) {
            int i11 = this.f72104b + 1;
            this.f72104b = i11;
            if (i11 >= this.f72108f) {
                return;
            }
        }
    }

    private static void a(Class cls, Integer num, Method method) {
        Map map = f72101r;
        synchronized (map) {
            try {
                WeakHashMap weakHashMap = (WeakHashMap) map.get(cls);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap();
                    map.put(cls, weakHashMap);
                }
                weakHashMap.put(num, new WeakReference(new Object[]{method, method.getParameterTypes()}));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void b(Class cls, Integer num, Member member) {
        Map map = f72099p;
        synchronized (map) {
            try {
                WeakHashMap weakHashMap = (WeakHashMap) map.get(cls);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap();
                    map.put(cls, weakHashMap);
                }
                weakHashMap.put(num, new WeakReference(member));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void c(Class cls, Integer num, Member member) {
        Map map = f72100q;
        synchronized (map) {
            try {
                WeakHashMap weakHashMap = (WeakHashMap) map.get(cls);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap();
                    map.put(cls, weakHashMap);
                }
                weakHashMap.put(num, new WeakReference(member));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private String d() {
        return new String(this.f72106d, this.f72105c, B(this.f72104b) - this.f72105c);
    }

    private static Object[] e(Class cls, Integer num) {
        WeakReference weakReference;
        Map map = (Map) f72101r.get(cls);
        if (map == null || (weakReference = (WeakReference) map.get(num)) == null) {
            return null;
        }
        return (Object[]) weakReference.get();
    }

    public static Class[] f(Method method) {
        Class[] clsArr;
        Map map = f72102s;
        WeakReference weakReference = (WeakReference) map.get(method);
        if (weakReference != null && (clsArr = (Class[]) weakReference.get()) != null) {
            return clsArr;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        map.put(method, new WeakReference(parameterTypes));
        return parameterTypes;
    }

    private static Member g(Class cls, Integer num) {
        WeakReference weakReference;
        WeakHashMap weakHashMap = (WeakHashMap) f72099p.get(cls);
        if (weakHashMap == null || (weakReference = (WeakReference) weakHashMap.get(num)) == null) {
            return null;
        }
        return (Member) weakReference.get();
    }

    private static Member h(Class cls, Integer num) {
        WeakReference weakReference;
        Map map = (Map) f72100q.get(cls);
        if (map == null || (weakReference = (WeakReference) map.get(num)) == null) {
            return null;
        }
        return (Member) weakReference.get();
    }

    private static int i(String str, String str2) {
        return str.hashCode() + str2.hashCode();
    }

    private Object j() {
        this.f72111i = this.f72110h;
        try {
            return !d.f72091h ? u() : n();
        } catch (IllegalAccessException e11) {
            throw new PropertyAccessException("could not access property", this.f72106d, this.f72104b, e11, this.f72116n);
        } catch (IndexOutOfBoundsException e12) {
            int i11 = this.f72104b;
            int i12 = this.f72107e;
            if (i11 >= i12) {
                this.f72104b = i12 - 1;
            }
            throw new PropertyAccessException("array or collections index out of bounds in property: " + new String(this.f72106d, this.f72104b, this.f72107e), this.f72106d, this.f72104b, e12, this.f72116n);
        } catch (NullPointerException e13) {
            throw new PropertyAccessException("null pointer exception in property: " + new String(this.f72106d), this.f72106d, this.f72104b, e13, this.f72116n);
        } catch (InvocationTargetException e14) {
            throw new PropertyAccessException("could not access property", this.f72106d, this.f72104b, e14, this.f72116n);
        } catch (CompileException e15) {
            throw org.mvel2.util.f.a(e15, this.f72106d, this.f72105c);
        } catch (Exception e16) {
            throw new PropertyAccessException("unknown exception in expression: " + new String(this.f72106d), this.f72106d, this.f72104b, e16, this.f72116n);
        }
    }

    public static Object k(String str, Object obj) {
        return new g(str, obj).j();
    }

    public static Object l(String str, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        return new g(str.toCharArray(), obj, variableResolverFactory, obj2, parserContext).j();
    }

    public static Object m(char[] cArr, int i11, int i12, Object obj, VariableResolverFactory variableResolverFactory, Object obj2, ParserContext parserContext) {
        return new g(cArr, i11, i12, obj, variableResolverFactory, obj2, parserContext).j();
    }

    private Object n() {
        while (this.f72104b < this.f72108f) {
            int w11 = w();
            if (w11 == 0) {
                Object p11 = p(this.f72111i, d());
                this.f72111i = p11;
                if (p11 == null && k10.d.e()) {
                    k10.d.b();
                    d();
                    throw null;
                }
            } else if (w11 == 1) {
                Object t11 = t(this.f72111i, d());
                this.f72111i = t11;
                if (t11 == null && k10.d.d()) {
                    k10.d.a();
                    d();
                    throw null;
                }
            } else if (w11 == 2) {
                this.f72111i = s(this.f72111i, d());
            } else if (w11 == 3) {
                this.f72111i = v(this.f72111i);
            }
            if (this.f72114l) {
                if (this.f72111i == null) {
                    return null;
                }
                this.f72114l = false;
            } else if (this.f72111i == null && this.f72104b < this.f72108f) {
                throw null;
            }
            this.f72113k = false;
        }
        return this.f72111i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x0211, code lost:
    
        return t(r8, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object o(java.lang.Object r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.g.o(java.lang.Object, java.lang.String):java.lang.Object");
    }

    private Object p(Object obj, String str) {
        if (obj == null || !k10.d.f(obj.getClass())) {
            k10.a.c(obj, str, this.f72115m);
            return o(obj, str);
        }
        k10.d.c(obj.getClass());
        throw null;
    }

    private ClassLoader q() {
        ParserContext parserContext = this.f72116n;
        return parserContext != null ? parserContext.getClassLoader() : Thread.currentThread().getContextClassLoader();
    }

    private Object r(Object obj, String str) {
        if (str.length() != 0 && (obj = o(obj, str)) == null) {
            throw new NullPointerException("null pointer on indexed access for: " + str);
        }
        this.f72112j = null;
        int i11 = this.f72104b + 1;
        this.f72104b = i11;
        D();
        if (this.f72104b == this.f72108f || x(']')) {
            throw new PropertyAccessException("unterminated '['", this.f72106d, this.f72104b, this.f72116n);
        }
        char[] cArr = this.f72106d;
        int i12 = this.f72104b;
        this.f72104b = i12 + 1;
        String str2 = new String(cArr, i11, i12 - i11);
        if (obj instanceof Map) {
            return ((Map) obj).get(d.n(str2, obj, this.f72115m));
        }
        if (obj instanceof List) {
            return ((List) obj).get(((Integer) d.n(str2, obj, this.f72115m)).intValue());
        }
        if (!(obj instanceof Collection)) {
            if (obj.getClass().isArray()) {
                return Array.get(obj, ((Integer) d.n(str2, obj, this.f72115m)).intValue());
            }
            if (obj instanceof CharSequence) {
                return Character.valueOf(((CharSequence) obj).charAt(((Integer) d.n(str2, obj, this.f72115m)).intValue()));
            }
            try {
                return TypeDescriptor.getClassReference(this.f72116n, (Class) obj, new TypeDescriptor(this.f72106d, this.f72103a, this.f72107e, 0));
            } catch (Exception e11) {
                throw new PropertyAccessException("illegal use of []: unknown type: " + obj.getClass().getName(), this.f72106d, this.f72105c, e11, this.f72116n);
            }
        }
        int intValue = ((Integer) d.n(str2, obj, this.f72115m)).intValue();
        Collection collection = (Collection) obj;
        if (intValue <= collection.size()) {
            Iterator it = collection.iterator();
            for (int i13 = 0; i13 < intValue; i13++) {
                it.next();
            }
            return it.next();
        }
        throw new PropertyAccessException("index [" + intValue + "] out of bounds on collections", this.f72106d, this.f72104b, this.f72116n);
    }

    private Object s(Object obj, String str) {
        if (str.length() != 0) {
            obj = o(obj, str);
        }
        this.f72112j = null;
        if (obj == null) {
            return null;
        }
        int i11 = this.f72104b + 1;
        this.f72104b = i11;
        D();
        if (this.f72104b == this.f72108f || x(']')) {
            throw new PropertyAccessException("unterminated '['", this.f72106d, this.f72104b, this.f72116n);
        }
        char[] cArr = this.f72106d;
        int i12 = this.f72104b;
        this.f72104b = i12 + 1;
        String str2 = new String(cArr, i11, i12 - i11);
        if (obj instanceof Map) {
            if (!k10.d.f(Map.class)) {
                return ((Map) obj).get(d.n(str2, obj, this.f72115m));
            }
            k10.d.c(Map.class);
            throw null;
        }
        if (obj instanceof List) {
            if (!k10.d.f(List.class)) {
                return ((List) obj).get(((Integer) d.n(str2, obj, this.f72115m)).intValue());
            }
            k10.d.c(List.class);
            throw null;
        }
        if (obj instanceof Collection) {
            if (k10.d.f(Collection.class)) {
                k10.d.c(Collection.class);
                throw null;
            }
            int intValue = ((Integer) d.n(str2, obj, this.f72115m)).intValue();
            Collection collection = (Collection) obj;
            if (intValue <= collection.size()) {
                Iterator it = collection.iterator();
                for (int i13 = 0; i13 < intValue; i13++) {
                    it.next();
                }
                return it.next();
            }
            throw new PropertyAccessException("index [" + intValue + "] out of bounds on collections", this.f72106d, this.f72104b, this.f72116n);
        }
        if (obj.getClass().isArray()) {
            if (!k10.d.f(Array.class)) {
                return Array.get(obj, ((Integer) d.n(str2, obj, this.f72115m)).intValue());
            }
            k10.d.c(Array.class);
            throw null;
        }
        if (obj instanceof CharSequence) {
            if (!k10.d.f(CharSequence.class)) {
                return Character.valueOf(((CharSequence) obj).charAt(((Integer) d.n(str2, obj, this.f72115m)).intValue()));
            }
            k10.d.c(CharSequence.class);
            throw null;
        }
        try {
            char[] cArr2 = this.f72106d;
            int i14 = this.f72103a;
            return TypeDescriptor.getClassReference(this.f72116n, (Class) obj, new TypeDescriptor(cArr2, i14, this.f72108f - i14, 0));
        } catch (Exception unused) {
            throw new PropertyAccessException("illegal use of []: unknown type: " + obj.getClass().getName(), this.f72106d, this.f72105c, this.f72116n);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object t(java.lang.Object r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.g.t(java.lang.Object, java.lang.String):java.lang.Object");
    }

    private Object u() {
        while (this.f72104b < this.f72108f) {
            int w11 = w();
            if (w11 == 0) {
                this.f72111i = o(this.f72111i, d());
            } else if (w11 == 1) {
                this.f72111i = t(this.f72111i, d());
            } else if (w11 == 2) {
                this.f72111i = r(this.f72111i, d());
            } else if (w11 == 3) {
                this.f72111i = v(this.f72111i);
            }
            if (this.f72114l) {
                if (this.f72111i == null) {
                    return null;
                }
                this.f72114l = false;
            }
            this.f72113k = false;
        }
        return this.f72111i;
    }

    private Object v(Object obj) {
        int i11 = this.f72103a;
        String trim = i11 == this.f72104b ? null : new String(this.f72106d, i11, (r1 - i11) - 1).trim();
        char[] cArr = this.f72106d;
        int i12 = this.f72104b;
        int i13 = i12 + 1;
        int e11 = m.e(cArr, i12, this.f72108f, '{', this.f72116n);
        this.f72104b = e11;
        m.z0(trim, cArr, i13, e11 - i13, obj, this.f72115m);
        this.f72104b++;
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab A[LOOP:2: B:32:0x00ab->B:34:0x00b7, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4 A[EDGE_INSN: B:44:0x00a4->B:30:0x00a4 BREAK  A[LOOP:1: B:25:0x0090->B:43:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int w() {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.g.w():int");
    }

    private boolean x(char c11) {
        while (true) {
            int i11 = this.f72104b;
            int i12 = this.f72108f;
            if (i11 >= i12) {
                return true;
            }
            char[] cArr = this.f72106d;
            char c12 = cArr[i11];
            if (c12 == '\"' || c12 == '\'') {
                this.f72104b = m.h(c12, cArr, i11, i12);
            }
            char[] cArr2 = this.f72106d;
            int i13 = this.f72104b;
            if (cArr2[i13] == c11) {
                return false;
            }
            this.f72104b = i13 + 1;
        }
    }

    private void y(Object obj) {
        this.f72111i = this.f72110h;
        try {
            int i11 = this.f72108f;
            this.f72108f = m.C(this.f72106d);
            Object j11 = j();
            this.f72111i = j11;
            if (j11 == null) {
                throw new PropertyAccessException("cannot bind to null context: " + new String(this.f72106d, this.f72104b, this.f72107e), this.f72106d, this.f72104b, this.f72116n);
            }
            this.f72108f = i11;
            if (w() == 2) {
                int i12 = this.f72104b + 1;
                this.f72104b = i12;
                D();
                if (this.f72104b == this.f72107e || x(']')) {
                    throw new PropertyAccessException("unterminated '['", this.f72106d, this.f72104b, this.f72116n);
                }
                String str = new String(this.f72106d, i12, this.f72104b - i12);
                if (!d.f72091h) {
                    Object obj2 = this.f72111i;
                    if (obj2 instanceof Map) {
                        ((Map) obj2).put(d.n(str, this.f72110h, this.f72115m), obj);
                        return;
                    }
                    if (obj2 instanceof List) {
                        ((List) obj2).set(((Integer) d.o(str, this.f72110h, this.f72115m, Integer.class)).intValue(), obj);
                        return;
                    }
                    if (k10.d.f(obj2.getClass())) {
                        k10.d.c(this.f72111i.getClass());
                        throw null;
                    }
                    if (this.f72111i.getClass().isArray()) {
                        Array.set(this.f72111i, ((Integer) d.o(str, this.f72110h, this.f72115m, Integer.class)).intValue(), b.b(obj, m.I(this.f72111i.getClass())));
                        return;
                    }
                    throw new PropertyAccessException("cannot bind to collection property: " + new String(this.f72106d) + ": not a recognized collection type: " + this.f72110h.getClass(), this.f72106d, this.f72104b, this.f72116n);
                }
                k10.a.d(this.f72110h, str, this.f72115m, obj);
                Object obj3 = this.f72111i;
                if (obj3 instanceof Map) {
                    if (k10.d.f(Map.class)) {
                        k10.d.c(Map.class);
                        throw null;
                    }
                    ((Map) this.f72111i).put(d.n(str, this.f72110h, this.f72115m), obj);
                    return;
                }
                if (obj3 instanceof List) {
                    if (k10.d.f(List.class)) {
                        k10.d.c(List.class);
                        throw null;
                    }
                    ((List) this.f72111i).set(((Integer) d.o(str, this.f72110h, this.f72115m, Integer.class)).intValue(), obj);
                    return;
                }
                if (obj3.getClass().isArray()) {
                    if (k10.d.f(Array.class)) {
                        k10.d.c(Array.class);
                        throw null;
                    }
                    Array.set(this.f72111i, ((Integer) d.o(str, this.f72110h, this.f72115m, Integer.class)).intValue(), b.b(obj, m.I(this.f72111i.getClass())));
                    return;
                }
                if (k10.d.f(this.f72111i.getClass())) {
                    k10.d.c(this.f72111i.getClass());
                    throw null;
                }
                throw new PropertyAccessException("cannot bind to collection property: " + new String(this.f72106d) + ": not a recognized collection type: " + this.f72110h.getClass(), this.f72106d, this.f72104b, this.f72116n);
            }
            if (d.f72091h && k10.d.f(this.f72111i.getClass())) {
                k10.d.c(this.f72111i.getClass());
                d();
                throw null;
            }
            String d11 = d();
            Member h11 = h(this.f72111i.getClass(), Integer.valueOf(d11 == null ? 0 : d11.hashCode()));
            if (h11 == null) {
                Class<?> cls = this.f72111i.getClass();
                Integer valueOf = Integer.valueOf(d11 != null ? d11.hashCode() : -1);
                Member d12 = obj != null ? n.d(this.f72111i.getClass(), d11, obj.getClass()) : n.c(this.f72111i.getClass(), d11);
                c(cls, valueOf, d12);
                h11 = d12;
            }
            if (h11 instanceof Method) {
                Method method = (Method) h11;
                Class[] f11 = f(method);
                if (obj == null || f11[0].isAssignableFrom(obj.getClass())) {
                    method.invoke(this.f72111i, obj);
                    return;
                }
                if (b.a(f11[0], obj.getClass())) {
                    method.invoke(this.f72111i, b.b(obj, f11[0]));
                    return;
                }
                throw new CompileException("cannot convert type: " + obj.getClass() + ": to " + method.getParameterTypes()[0], this.f72106d, this.f72104b);
            }
            if (h11 != null) {
                Field field = (Field) h11;
                if (obj == null || field.getType().isAssignableFrom(obj.getClass())) {
                    field.set(this.f72111i, obj);
                    return;
                }
                if (b.a(field.getType(), obj.getClass())) {
                    field.set(this.f72111i, b.b(obj, field.getType()));
                    return;
                }
                throw new CompileException("cannot convert type: " + obj.getClass() + ": to " + field.getType(), this.f72106d, this.f72104b);
            }
            Object obj4 = this.f72111i;
            if (obj4 instanceof Map) {
                ((Map) obj4).put(d.n(d11, this.f72110h, this.f72115m), obj);
                return;
            }
            if (obj4 instanceof org.mvel2.ast.b) {
                ((org.mvel2.ast.d) obj4).c().getVariableResolver(d11).setValue(obj);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("could not access/write property (");
            sb2.append(d11);
            sb2.append(") in: ");
            Object obj5 = this.f72111i;
            sb2.append(obj5 == null ? "Unknown" : obj5.getClass().getName());
            throw new PropertyAccessException(sb2.toString(), this.f72106d, this.f72104b, this.f72116n);
        } catch (IllegalAccessException e11) {
            throw new PropertyAccessException("could not access property", this.f72106d, this.f72105c, e11, this.f72116n);
        } catch (InvocationTargetException e12) {
            throw new PropertyAccessException("could not access property", this.f72106d, this.f72105c, e12, this.f72116n);
        }
    }

    public static void z(Object obj, String str, Object obj2) {
        new g(str, obj).y(obj2);
    }

    protected int B(int i11) {
        while (i11 > 0 && m.q0(this.f72106d[i11 - 1])) {
            i11--;
        }
        return i11;
    }

    protected Object C() {
        int i11;
        int i12 = this.f72104b;
        try {
            int i13 = this.f72108f;
            int i14 = i13 - 1;
            boolean z10 = false;
            while (true) {
                int i15 = this.f72103a;
                if (i14 > i15) {
                    char[] cArr = this.f72106d;
                    char c11 = cArr[i14];
                    if (c11 == '\"') {
                        while (true) {
                            i11 = i14 - 1;
                            if (i11 > 0) {
                                char[] cArr2 = this.f72106d;
                                if (cArr2[i11] != '\"' || cArr2[i14 - 2] == '\\') {
                                    i14 = i11;
                                }
                            }
                        }
                    } else if (c11 != '\'') {
                        int i16 = 1;
                        if (c11 == ')') {
                            int i17 = i14 - 1;
                            int i18 = 1;
                            while (i17 > 0 && i18 != 0) {
                                char c12 = this.f72106d[i17];
                                if (c12 != '\"') {
                                    switch (c12) {
                                        case '(':
                                            i18--;
                                            break;
                                        case ')':
                                            i18++;
                                            break;
                                    }
                                    i17--;
                                }
                                while (i17 > 0) {
                                    char[] cArr3 = this.f72106d;
                                    if (cArr3[i17] != c12 && cArr3[i17 - 1] != '\\') {
                                        i17--;
                                    }
                                    i17--;
                                }
                                i17--;
                            }
                            z10 = true;
                            int i19 = i17;
                            i14 = i17 + 1;
                            i13 = i19;
                        } else if (c11 == '.') {
                            if (!z10) {
                                try {
                                    this.f72104b = i13;
                                    String str = new String(cArr, i15, i13 - i15);
                                    if (d.f72093j && str.endsWith(".class")) {
                                        str = str.substring(0, str.length() - 6);
                                    }
                                    return q().loadClass(str);
                                } catch (ClassNotFoundException unused) {
                                    ClassLoader q11 = q();
                                    char[] cArr4 = this.f72106d;
                                    int i20 = this.f72103a;
                                    Class<?> loadClass = q11.loadClass(new String(cArr4, i20, i14 - i20));
                                    String str2 = new String(this.f72106d, i14 + 1, (this.f72108f - i14) - 1);
                                    try {
                                        return loadClass.getField(str2);
                                    } catch (NoSuchFieldException unused2) {
                                        for (Method method : loadClass.getMethods()) {
                                            if (str2.equals(method.getName())) {
                                                return method;
                                            }
                                        }
                                        return null;
                                    }
                                }
                            }
                            i13 = i14;
                            z10 = false;
                        } else if (c11 == '}') {
                            while (true) {
                                i14--;
                                if (i14 > 0 && i16 != 0) {
                                    char c13 = this.f72106d[i14];
                                    if (c13 == '\"' || c13 == '\'') {
                                        while (i14 > 0) {
                                            char[] cArr5 = this.f72106d;
                                            if (cArr5[i14] != c13 && cArr5[i14 - 1] != '\\') {
                                                i14--;
                                            }
                                        }
                                    } else if (c13 == '{') {
                                        i16--;
                                    } else if (c13 == '}') {
                                        i16++;
                                    }
                                }
                            }
                        }
                        i14--;
                    } else {
                        while (true) {
                            i11 = i14 - 1;
                            if (i11 > 0) {
                                char[] cArr6 = this.f72106d;
                                if (cArr6[i11] != '\'' || cArr6[i14 - 2] == '\\') {
                                    i14 = i11;
                                }
                            }
                        }
                    }
                    i14 = i11;
                    i14--;
                }
            }
        } catch (Exception unused3) {
            this.f72104b = i12;
        }
        return null;
    }
}
