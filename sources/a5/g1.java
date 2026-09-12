package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class g1 {

    /* renamed from: j, reason: collision with root package name */
    public static final g1 f298j = new g1();

    /* renamed from: k, reason: collision with root package name */
    private static boolean f299k = false;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f300l = false;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f301m = false;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f302n = false;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f303o = false;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f304p = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f305a;

    /* renamed from: b, reason: collision with root package name */
    private a f306b;

    /* renamed from: c, reason: collision with root package name */
    protected String f307c;

    /* renamed from: d, reason: collision with root package name */
    public PropertyNamingStrategy f308d;

    /* renamed from: e, reason: collision with root package name */
    private final com.alibaba.fastjson.util.g f309e;

    /* renamed from: f, reason: collision with root package name */
    private final com.alibaba.fastjson.util.g f310f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f311g;

    /* renamed from: h, reason: collision with root package name */
    private long[] f312h;

    /* renamed from: i, reason: collision with root package name */
    private List f313i;

    public g1() {
        this(8192);
    }

    public g1(int i11) {
        this(i11, false);
    }

    public g1(int i11, boolean z10) {
        this.f305a = !com.alibaba.fastjson.util.b.f18278b;
        this.f307c = com.alibaba.fastjson.a.DEFAULT_TYPE_KEY;
        this.f312h = new long[]{4165360493669296979L, 4446674157046724083L};
        this.f313i = new ArrayList();
        this.f311g = z10;
        this.f309e = new com.alibaba.fastjson.util.g(i11);
        this.f310f = new com.alibaba.fastjson.util.g(16);
        try {
            if (this.f305a) {
                this.f306b = new a();
            }
        } catch (Throwable unused) {
            this.f305a = false;
        }
        j();
    }

    private final p0 a(f1 f1Var) {
        p0 z10 = this.f306b.z(f1Var);
        int i11 = 0;
        while (true) {
            g0[] g0VarArr = z10.f385k;
            if (i11 >= g0VarArr.length) {
                return z10;
            }
            Class cls = g0VarArr[i11].f281a.f18283e;
            if (cls.isEnum() && !(h(cls) instanceof e0)) {
                z10.f329i = false;
            }
            i11++;
        }
    }

    private static Member f(Class cls) {
        Method method = null;
        for (Method method2 : cls.getMethods()) {
            if (method2.getReturnType() != Void.class && ((x4.b) method2.getAnnotation(x4.b.class)) != null) {
                if (method != null) {
                    return null;
                }
                method = method2;
            }
        }
        for (Field field : cls.getFields()) {
            if (((x4.b) field.getAnnotation(x4.b.class)) != null) {
                if (method != null) {
                    return null;
                }
                method = field;
            }
        }
        return method;
    }

    public static g1 g() {
        return f298j;
    }

    private void j() {
        k(Boolean.class, t.f419a);
        k(Character.class, x.f434a);
        k(Byte.class, j0.f335a);
        k(Short.class, j0.f335a);
        k(Integer.class, j0.f335a);
        k(Long.class, u0.f425a);
        k(Float.class, h0.f315b);
        k(Double.class, d0.f264b);
        k(BigDecimal.class, r.f415c);
        k(BigInteger.class, s.f418c);
        k(String.class, k1.f362a);
        k(byte[].class, a1.f262a);
        k(short[].class, a1.f262a);
        k(int[].class, a1.f262a);
        k(long[].class, a1.f262a);
        k(float[].class, a1.f262a);
        k(double[].class, a1.f262a);
        k(boolean[].class, a1.f262a);
        k(char[].class, a1.f262a);
        k(Object[].class, y0.f436a);
        w0 w0Var = w0.f431b;
        k(Class.class, w0Var);
        k(SimpleDateFormat.class, w0Var);
        k(Currency.class, new w0());
        k(TimeZone.class, w0Var);
        k(InetAddress.class, w0Var);
        k(Inet4Address.class, w0Var);
        k(Inet6Address.class, w0Var);
        k(InetSocketAddress.class, w0Var);
        k(File.class, w0Var);
        k kVar = k.f360a;
        k(Appendable.class, kVar);
        k(StringBuffer.class, kVar);
        k(StringBuilder.class, kVar);
        l1 l1Var = l1.f366a;
        k(Charset.class, l1Var);
        k(Pattern.class, l1Var);
        k(Locale.class, l1Var);
        k(URI.class, l1Var);
        k(URL.class, l1Var);
        k(UUID.class, l1Var);
        m mVar = m.f367a;
        k(AtomicBoolean.class, mVar);
        k(AtomicInteger.class, mVar);
        k(AtomicLong.class, mVar);
        d1 d1Var = d1.f266a;
        k(AtomicReference.class, d1Var);
        k(AtomicIntegerArray.class, mVar);
        k(AtomicLongArray.class, mVar);
        k(WeakReference.class, d1Var);
        k(SoftReference.class, d1Var);
        k(LinkedList.class, z.f437a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x015d, code lost:
    
        r0 = a(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0161, code lost:
    
        if (r0 == null) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0163, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x017c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0188, code lost:
    
        if (r0.getMessage().indexOf("Metaspace") != (-1)) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x018b, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0164, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x017b, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create asm serializer error, verson 1.2.83, class " + r0, r15);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a5.z0 b(a5.f1 r15) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.g1.b(a5.f1):a5.z0");
    }

    public final z0 c(Class cls) {
        String name = cls.getName();
        if (Arrays.binarySearch(this.f312h, TypeUtils.J(name)) < 0) {
            f1 d11 = TypeUtils.d(cls, null, this.f308d, this.f311g);
            return (d11.f278e.length == 0 && Iterable.class.isAssignableFrom(cls)) ? w0.f431b : b(d11);
        }
        throw new JSONException("not support class : " + name);
    }

    public final z0 d(Type type) {
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return (z0) this.f309e.b(type);
        }
        com.alibaba.fastjson.util.g gVar = (com.alibaba.fastjson.util.g) this.f310f.b(type);
        if (gVar == null) {
            return null;
        }
        return (z0) gVar.b(mixInAnnotations);
    }

    protected z0 e() {
        return e0.f267b;
    }

    public z0 h(Class cls) {
        return i(cls, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a5.z0 i(java.lang.Class r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1131
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.g1.i(java.lang.Class, boolean):a5.z0");
    }

    public boolean k(Type type, z0 z0Var) {
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.f309e.c(type, z0Var);
        }
        com.alibaba.fastjson.util.g gVar = (com.alibaba.fastjson.util.g) this.f310f.b(type);
        if (gVar == null) {
            gVar = new com.alibaba.fastjson.util.g(4);
            this.f310f.c(type, gVar);
        }
        return gVar.c(mixInAnnotations, z0Var);
    }

    public void l(boolean z10) {
        if (com.alibaba.fastjson.util.b.f18278b) {
            return;
        }
        this.f305a = z10;
    }
}
