package y4;

import a5.g1;
import a5.j0;
import a5.k1;
import a5.u0;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import z4.b2;
import z4.h3;
import z4.l;
import z4.m;
import z4.o;

/* loaded from: classes3.dex */
public class a implements Closeable {

    /* renamed from: p, reason: collision with root package name */
    private static final Set f78948p;

    /* renamed from: a, reason: collision with root package name */
    public final Object f78949a;

    /* renamed from: b, reason: collision with root package name */
    public final i f78950b;

    /* renamed from: c, reason: collision with root package name */
    protected h f78951c;

    /* renamed from: d, reason: collision with root package name */
    private String f78952d;

    /* renamed from: e, reason: collision with root package name */
    private DateFormat f78953e;

    /* renamed from: f, reason: collision with root package name */
    public final b f78954f;

    /* renamed from: g, reason: collision with root package name */
    protected g f78955g;

    /* renamed from: h, reason: collision with root package name */
    private g[] f78956h;

    /* renamed from: i, reason: collision with root package name */
    private int f78957i;

    /* renamed from: j, reason: collision with root package name */
    private List f78958j;

    /* renamed from: k, reason: collision with root package name */
    public int f78959k;

    /* renamed from: l, reason: collision with root package name */
    private List f78960l;

    /* renamed from: m, reason: collision with root package name */
    private List f78961m;

    /* renamed from: n, reason: collision with root package name */
    private int f78962n;

    /* renamed from: o, reason: collision with root package name */
    private String[] f78963o;

    /* renamed from: y4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0994a {

        /* renamed from: a, reason: collision with root package name */
        public final g f78964a;

        /* renamed from: b, reason: collision with root package name */
        public final String f78965b;

        /* renamed from: c, reason: collision with root package name */
        public l f78966c;

        /* renamed from: d, reason: collision with root package name */
        public g f78967d;

        public C0994a(g gVar, String str) {
            this.f78964a = gVar;
            this.f78965b = str;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f78948p = hashSet;
        hashSet.addAll(Arrays.asList(Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class));
    }

    public a(Object obj, b bVar, h hVar) {
        this.f78952d = com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT;
        this.f78957i = 0;
        this.f78959k = 0;
        this.f78960l = null;
        this.f78961m = null;
        this.f78962n = 0;
        this.f78963o = null;
        this.f78954f = bVar;
        this.f78949a = obj;
        this.f78951c = hVar;
        this.f78950b = hVar.f79006e;
        char d11 = bVar.d();
        if (d11 == '{') {
            bVar.next();
            ((c) bVar).f78971a = 12;
        } else if (d11 != '[') {
            bVar.Z();
        } else {
            bVar.next();
            ((c) bVar).f78971a = 14;
        }
    }

    public a(String str) {
        this(str, h.t(), com.alibaba.fastjson.a.DEFAULT_PARSER_FEATURE);
    }

    public a(String str, h hVar) {
        this(str, new e(str, com.alibaba.fastjson.a.DEFAULT_PARSER_FEATURE), hVar);
    }

    public a(String str, h hVar, int i11) {
        this(str, new e(str, i11), hVar);
    }

    public a(char[] cArr, int i11, h hVar, int i12) {
        this(cArr, new e(cArr, i11, i12), hVar);
    }

    private void h(g gVar) {
        int i11 = this.f78957i;
        this.f78957i = i11 + 1;
        g[] gVarArr = this.f78956h;
        if (gVarArr == null) {
            this.f78956h = new g[8];
        } else if (i11 >= gVarArr.length) {
            g[] gVarArr2 = new g[(gVarArr.length * 3) / 2];
            System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
            this.f78956h = gVarArr2;
        }
        this.f78956h[i11] = gVar;
    }

    public void B0(g gVar) {
        if (this.f78954f.n(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.f78955g = gVar;
    }

    public void C0(String str) {
        this.f78952d = str;
        this.f78953e = null;
    }

    public void E0(int i11) {
        this.f78959k = i11;
    }

    public Object T() {
        return U(null);
    }

    public Object U(Object obj) {
        b bVar = this.f78954f;
        int q02 = bVar.q0();
        if (q02 == 2) {
            Number o02 = bVar.o0();
            bVar.Z();
            return o02;
        }
        if (q02 == 3) {
            Number z02 = bVar.z0(bVar.n(Feature.UseBigDecimal));
            bVar.Z();
            return z02;
        }
        if (q02 == 4) {
            String k02 = bVar.k0();
            bVar.c0(16);
            if (bVar.n(Feature.AllowISO8601DateFormat)) {
                e eVar = new e(k02);
                try {
                    if (eVar.w1()) {
                        return eVar.J0().getTime();
                    }
                } finally {
                    eVar.close();
                }
            }
            return k02;
        }
        if (q02 == 12) {
            return r0(x(Feature.UseNativeJavaObject) ? bVar.n(Feature.OrderedField) ? new HashMap() : new LinkedHashMap() : new JSONObject(bVar.n(Feature.OrderedField)), obj);
        }
        if (q02 == 14) {
            Collection arrayList = x(Feature.UseNativeJavaObject) ? new ArrayList() : new JSONArray();
            g0(arrayList, obj);
            return bVar.n(Feature.UseObjectArray) ? arrayList.toArray() : arrayList;
        }
        if (q02 == 18) {
            if ("NaN".equals(bVar.k0())) {
                bVar.Z();
                return null;
            }
            throw new JSONException("syntax error, " + bVar.k());
        }
        if (q02 == 26) {
            byte[] h02 = bVar.h0();
            bVar.Z();
            return h02;
        }
        switch (q02) {
            case 6:
                bVar.Z();
                return Boolean.TRUE;
            case 7:
                bVar.Z();
                return Boolean.FALSE;
            case 8:
                bVar.Z();
                return null;
            case 9:
                bVar.c0(18);
                if (bVar.q0() != 18) {
                    throw new JSONException("syntax error");
                }
                bVar.c0(10);
                b(10);
                long longValue = bVar.o0().longValue();
                b(2);
                b(11);
                return new Date(longValue);
            default:
                switch (q02) {
                    case 20:
                        if (bVar.U()) {
                            return null;
                        }
                        throw new JSONException("unterminated json string, " + bVar.k());
                    case 21:
                        bVar.Z();
                        HashSet hashSet = new HashSet();
                        g0(hashSet, obj);
                        return hashSet;
                    case 22:
                        bVar.Z();
                        TreeSet treeSet = new TreeSet();
                        g0(treeSet, obj);
                        return treeSet;
                    case 23:
                        bVar.Z();
                        return null;
                    default:
                        throw new JSONException("syntax error, " + bVar.k());
                }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0239, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object V(z4.f3 r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.a.V(z4.f3, java.lang.Object):java.lang.Object");
    }

    public void Z(Class cls, Collection collection) {
        a0(cls, collection);
    }

    public void a0(Type type, Collection collection) {
        c0(type, collection, null);
    }

    public final void b(int i11) {
        b bVar = this.f78954f;
        if (bVar.q0() == i11) {
            bVar.Z();
            return;
        }
        throw new JSONException("syntax error, expect " + f.a(i11) + ", actual " + f.a(bVar.q0()));
    }

    public void c0(Type type, Collection collection, Object obj) {
        b2 p11;
        int q02 = this.f78954f.q0();
        if (q02 == 21 || q02 == 22) {
            this.f78954f.Z();
            q02 = this.f78954f.q0();
        }
        if (q02 != 14) {
            throw new JSONException("field " + obj + " expect '[', but " + f.a(q02) + ", " + this.f78954f.k());
        }
        if (Integer.TYPE == type) {
            p11 = j0.f335a;
            this.f78954f.c0(2);
        } else if (String.class == type) {
            p11 = k1.f362a;
            this.f78954f.c0(4);
        } else {
            p11 = this.f78951c.p(type);
            this.f78954f.c0(p11.b());
        }
        g gVar = this.f78955g;
        y0(collection, obj);
        int i11 = 0;
        while (true) {
            try {
                if (this.f78954f.n(Feature.AllowArbitraryCommas)) {
                    while (this.f78954f.q0() == 16) {
                        this.f78954f.Z();
                    }
                }
                if (this.f78954f.q0() == 15) {
                    B0(gVar);
                    this.f78954f.c0(16);
                    return;
                }
                Object obj2 = null;
                if (Integer.TYPE == type) {
                    collection.add(j0.f335a.c(this, null, null));
                } else if (String.class == type) {
                    if (this.f78954f.q0() == 4) {
                        obj2 = this.f78954f.k0();
                        this.f78954f.c0(16);
                    } else {
                        Object T = T();
                        if (T != null) {
                            obj2 = T.toString();
                        }
                    }
                    collection.add(obj2);
                } else {
                    if (this.f78954f.q0() == 8) {
                        this.f78954f.Z();
                    } else {
                        obj2 = p11.c(this, type, Integer.valueOf(i11));
                    }
                    collection.add(obj2);
                    k(collection);
                }
                if (this.f78954f.q0() == 16) {
                    this.f78954f.c0(p11.b());
                }
                i11++;
            } catch (Throwable th2) {
                B0(gVar);
                throw th2;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b bVar = this.f78954f;
        try {
            if (bVar.n(Feature.AutoCloseSource) && bVar.q0() != 20) {
                throw new JSONException("not close json text, token : " + f.a(bVar.q0()));
            }
        } finally {
            bVar.close();
        }
    }

    public void d(String str) {
        b bVar = this.f78954f;
        bVar.u();
        if (bVar.q0() != 4) {
            throw new JSONException("type not match error");
        }
        if (!str.equals(bVar.k0())) {
            throw new JSONException("type not match error");
        }
        bVar.Z();
        if (bVar.q0() == 16) {
            bVar.Z();
        }
    }

    public final void d0(Collection collection) {
        g0(collection, null);
    }

    public final void g0(Collection collection, Object obj) {
        Object obj2;
        b bVar = this.f78954f;
        if (bVar.q0() == 21 || bVar.q0() == 22) {
            bVar.Z();
        }
        if (bVar.q0() != 14) {
            throw new JSONException("syntax error, expect [, actual " + f.a(bVar.q0()) + ", pos " + bVar.h() + ", fieldName " + obj);
        }
        bVar.c0(4);
        g gVar = this.f78955g;
        if (gVar != null && gVar.f78992d > 512) {
            throw new JSONException("array level > 512");
        }
        y0(collection, obj);
        int i11 = 0;
        while (true) {
            try {
                try {
                    if (bVar.n(Feature.AllowArbitraryCommas)) {
                        while (bVar.q0() == 16) {
                            bVar.Z();
                        }
                    }
                    int q02 = bVar.q0();
                    if (q02 == 2) {
                        Number o02 = bVar.o0();
                        bVar.c0(16);
                        obj2 = o02;
                    } else if (q02 == 3) {
                        obj2 = bVar.n(Feature.UseBigDecimal) ? bVar.z0(true) : bVar.z0(false);
                        bVar.c0(16);
                    } else if (q02 == 4) {
                        String k02 = bVar.k0();
                        bVar.c0(16);
                        obj2 = k02;
                        if (bVar.n(Feature.AllowISO8601DateFormat)) {
                            e eVar = new e(k02);
                            Object obj3 = k02;
                            if (eVar.w1()) {
                                obj3 = eVar.J0().getTime();
                            }
                            eVar.close();
                            obj2 = obj3;
                        }
                    } else if (q02 == 6) {
                        Boolean bool = Boolean.TRUE;
                        bVar.c0(16);
                        obj2 = bool;
                    } else if (q02 != 7) {
                        obj2 = null;
                        obj2 = null;
                        if (q02 == 8) {
                            bVar.c0(4);
                        } else if (q02 == 12) {
                            obj2 = r0(new JSONObject(bVar.n(Feature.OrderedField)), Integer.valueOf(i11));
                        } else {
                            if (q02 == 20) {
                                throw new JSONException("unclosed jsonArray");
                            }
                            if (q02 == 23) {
                                bVar.c0(4);
                            } else if (q02 == 14) {
                                JSONArray jSONArray = new JSONArray();
                                g0(jSONArray, Integer.valueOf(i11));
                                obj2 = jSONArray;
                                if (bVar.n(Feature.UseObjectArray)) {
                                    obj2 = jSONArray.toArray();
                                }
                            } else {
                                if (q02 == 15) {
                                    bVar.c0(16);
                                    B0(gVar);
                                    return;
                                }
                                obj2 = T();
                            }
                        }
                    } else {
                        Boolean bool2 = Boolean.FALSE;
                        bVar.c0(16);
                        obj2 = bool2;
                    }
                    collection.add(obj2);
                    k(collection);
                    if (bVar.q0() == 16) {
                        bVar.c0(4);
                    }
                    i11++;
                } catch (ClassCastException e11) {
                    throw new JSONException("unkown error", e11);
                }
            } catch (Throwable th2) {
                B0(gVar);
                throw th2;
            }
        }
    }

    public Object[] h0(Type[] typeArr) {
        Object h11;
        Class<?> cls;
        boolean z10;
        Class cls2;
        int i11 = 8;
        if (this.f78954f.q0() == 8) {
            this.f78954f.c0(16);
            return null;
        }
        int i12 = 14;
        if (this.f78954f.q0() != 14) {
            throw new JSONException("syntax error : " + this.f78954f.v());
        }
        Object[] objArr = new Object[typeArr.length];
        if (typeArr.length == 0) {
            this.f78954f.c0(15);
            if (this.f78954f.q0() != 15) {
                throw new JSONException("syntax error");
            }
            this.f78954f.c0(16);
            return new Object[0];
        }
        this.f78954f.c0(2);
        int i13 = 0;
        while (i13 < typeArr.length) {
            if (this.f78954f.q0() == i11) {
                this.f78954f.c0(16);
                h11 = null;
            } else {
                Type type = typeArr[i13];
                if (type == Integer.TYPE || type == Integer.class) {
                    if (this.f78954f.q0() == 2) {
                        h11 = Integer.valueOf(this.f78954f.o());
                        this.f78954f.c0(16);
                    } else {
                        h11 = TypeUtils.h(T(), type, this.f78951c);
                    }
                } else if (type != String.class) {
                    if (i13 == typeArr.length - 1 && (type instanceof Class) && (((cls2 = (Class) type) != byte[].class && cls2 != char[].class) || this.f78954f.q0() != 4)) {
                        z10 = cls2.isArray();
                        cls = cls2.getComponentType();
                    } else {
                        cls = null;
                        z10 = false;
                    }
                    if (!z10 || this.f78954f.q0() == i12) {
                        h11 = this.f78951c.p(type).c(this, type, Integer.valueOf(i13));
                    } else {
                        ArrayList arrayList = new ArrayList();
                        b2 p11 = this.f78951c.p(cls);
                        int b11 = p11.b();
                        if (this.f78954f.q0() != 15) {
                            while (true) {
                                arrayList.add(p11.c(this, type, null));
                                if (this.f78954f.q0() != 16) {
                                    break;
                                }
                                this.f78954f.c0(b11);
                            }
                            if (this.f78954f.q0() != 15) {
                                throw new JSONException("syntax error :" + f.a(this.f78954f.q0()));
                            }
                        }
                        h11 = TypeUtils.h(arrayList, type, this.f78951c);
                    }
                } else if (this.f78954f.q0() == 4) {
                    h11 = this.f78954f.k0();
                    this.f78954f.c0(16);
                } else {
                    h11 = TypeUtils.h(T(), type, this.f78951c);
                }
            }
            objArr[i13] = h11;
            if (this.f78954f.q0() == 15) {
                break;
            }
            if (this.f78954f.q0() != 16) {
                throw new JSONException("syntax error :" + f.a(this.f78954f.q0()));
            }
            if (i13 == typeArr.length - 1) {
                this.f78954f.c0(15);
            } else {
                this.f78954f.c0(2);
            }
            i13++;
            i11 = 8;
            i12 = 14;
        }
        if (this.f78954f.q0() != 15) {
            throw new JSONException("syntax error");
        }
        this.f78954f.c0(16);
        return objArr;
    }

    public void i(C0994a c0994a) {
        if (this.f78958j == null) {
            this.f78958j = new ArrayList(2);
        }
        this.f78958j.add(c0994a);
    }

    public void k(Collection collection) {
        if (this.f78959k == 1) {
            if (!(collection instanceof List)) {
                C0994a r11 = r();
                r11.f78966c = new h3(collection);
                r11.f78967d = this.f78955g;
                E0(0);
                return;
            }
            int size = collection.size() - 1;
            C0994a r12 = r();
            r12.f78966c = new h3(this, (List) collection, size);
            r12.f78967d = this.f78955g;
            E0(0);
        }
    }

    public void k0(Object obj, String str) {
        this.f78954f.u();
        List list = this.f78960l;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
        }
        T();
        List list2 = this.f78961m;
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            if (it2.hasNext()) {
                android.support.v4.media.session.c.a(it2.next());
                throw null;
            }
        }
        if (this.f78959k == 1) {
            this.f78959k = 0;
        }
    }

    public void l(Map map, Object obj) {
        if (this.f78959k == 1) {
            h3 h3Var = new h3(map, obj);
            C0994a r11 = r();
            r11.f78966c = h3Var;
            r11.f78967d = this.f78955g;
            E0(0);
        }
    }

    public JSONObject l0() {
        Object q02 = q0(new JSONObject(this.f78954f.n(Feature.OrderedField)));
        if (q02 instanceof JSONObject) {
            return (JSONObject) q02;
        }
        if (q02 == null) {
            return null;
        }
        return new JSONObject((Map<String, Object>) q02);
    }

    public h m() {
        return this.f78951c;
    }

    public Object m0(Class cls) {
        return p0(cls, null);
    }

    public g n() {
        return this.f78955g;
    }

    public String o() {
        return this.f78952d;
    }

    public Object o0(Type type) {
        return p0(type, null);
    }

    public DateFormat p() {
        if (this.f78953e == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f78952d, this.f78954f.B0());
            this.f78953e = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f78954f.l0());
        }
        return this.f78953e;
    }

    public Object p0(Type type, Object obj) {
        int q02 = this.f78954f.q0();
        if (q02 == 8) {
            this.f78954f.Z();
            return TypeUtils.J0(type);
        }
        if (q02 == 4) {
            if (type == byte[].class) {
                byte[] h02 = this.f78954f.h0();
                this.f78954f.Z();
                return h02;
            }
            if (type == char[].class) {
                String k02 = this.f78954f.k0();
                this.f78954f.Z();
                return k02.toCharArray();
            }
        }
        b2 p11 = this.f78951c.p(type);
        try {
            if (p11.getClass() != o.class) {
                return p11.c(this, type, obj);
            }
            if (this.f78954f.q0() != 12 && this.f78954f.q0() != 14) {
                throw new JSONException("syntax error,expect start with { or [,but actually start with " + this.f78954f.v());
            }
            return ((o) p11).g(this, type, obj, 0);
        } catch (JSONException e11) {
            throw e11;
        } catch (Throwable th2) {
            throw new JSONException(th2.getMessage(), th2);
        }
    }

    public m q() {
        return null;
    }

    public Object q0(Map map) {
        return r0(map, null);
    }

    public C0994a r() {
        return (C0994a) this.f78958j.get(r0.size() - 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x034b, code lost:
    
        if (r3 == z4.k3.class) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x034d, code lost:
    
        E0(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x035a, code lost:
    
        r0 = r0.c(r17, r8, r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x035e, code lost:
    
        B0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0361, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0354, code lost:
    
        if ((r0 instanceof z4.z1) == false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0356, code lost:
    
        E0(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x02a6, code lost:
    
        r5.c0(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x02b1, code lost:
    
        if (r5.q0() != 13) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x02b3, code lost:
    
        r5.c0(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x02be, code lost:
    
        if ((r17.f78951c.p(r8) instanceof z4.o) == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02c0, code lost:
    
        r13 = com.alibaba.fastjson.util.TypeUtils.f(r18, r8, r17.f78951c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02ca, code lost:
    
        if (r13 != null) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02ce, code lost:
    
        if (r8 != java.lang.Cloneable.class) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02d0, code lost:
    
        r13 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02dc, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02de, code lost:
    
        r13 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02e9, code lost:
    
        if ("java.util.Collections$UnmodifiableMap".equals(r7) == false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02eb, code lost:
    
        r13 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02f5, code lost:
    
        r13 = r8.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02f9, code lost:
    
        B0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02fc, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02c8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0304, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0305, code lost:
    
        E0(2);
        r3 = r17.f78955g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x030b, code lost:
    
        if (r3 == null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x030d, code lost:
    
        if (r19 == null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0311, code lost:
    
        if ((r19 instanceof java.lang.Integer) != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0317, code lost:
    
        if ((r3.f78991c instanceof java.lang.Integer) != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0319, code lost:
    
        v0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0320, code lost:
    
        if (r18.size() <= 0) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0322, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.f(r18, r8, r17.f78951c);
        E0(0);
        u0(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x032f, code lost:
    
        B0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0332, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0333, code lost:
    
        r0 = r17.f78951c.p(r8);
        r3 = r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0343, code lost:
    
        if (z4.o.class.isAssignableFrom(r3) == false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0347, code lost:
    
        if (r3 == z4.o.class) goto L192;
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0471 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:45:0x0237, B:52:0x024d, B:54:0x025b, B:57:0x029e, B:59:0x02a6, B:61:0x02b3, B:63:0x02b6, B:65:0x02c0, B:69:0x02d0, B:70:0x02d6, B:72:0x02de, B:73:0x02e3, B:75:0x02eb, B:76:0x02f5, B:81:0x02fd, B:82:0x0304, B:83:0x0305, B:86:0x030f, B:88:0x0313, B:90:0x0319, B:91:0x031c, B:93:0x0322, B:96:0x0333, B:102:0x034d, B:103:0x035a, B:106:0x0352, B:108:0x0356, B:109:0x0261, B:112:0x026c, B:116:0x0278, B:118:0x027e, B:122:0x028b, B:125:0x028e, B:134:0x036b, B:263:0x0377, B:267:0x037f, B:269:0x0389, B:271:0x039a, B:273:0x03a4, B:275:0x03ac, B:277:0x03b0, B:279:0x03b6, B:282:0x03bb, B:284:0x03bf, B:285:0x0424, B:287:0x042c, B:290:0x0435, B:291:0x044f, B:294:0x03c5, B:296:0x03cd, B:299:0x03d3, B:300:0x03e0, B:303:0x03e9, B:307:0x03ef, B:310:0x03f4, B:311:0x0401, B:313:0x040b, B:314:0x0419, B:316:0x0450, B:317:0x046e, B:140:0x0471, B:142:0x0475, B:144:0x0479, B:147:0x047f, B:151:0x0488, B:157:0x0498, B:159:0x04a7, B:161:0x04b2, B:162:0x04ba, B:163:0x04bd, B:164:0x04e9, B:166:0x04f4, B:173:0x0501, B:176:0x0511, B:177:0x0531, B:182:0x04cd, B:184:0x04d7, B:185:0x04e6, B:186:0x04dc, B:191:0x0536, B:193:0x0540, B:195:0x0548, B:196:0x054b, B:198:0x0556, B:199:0x055a, B:208:0x0565, B:201:0x056c, B:205:0x0578, B:206:0x057d, B:213:0x0582, B:215:0x0587, B:218:0x0593, B:220:0x059b, B:222:0x05ae, B:224:0x05c9, B:225:0x05d1, B:228:0x05d9, B:230:0x05dd, B:231:0x05e4, B:233:0x05e9, B:234:0x05ec, B:245:0x05f4, B:236:0x05fe, B:239:0x0608, B:240:0x060d, B:242:0x0612, B:243:0x062c, B:249:0x05b7, B:250:0x05bc, B:252:0x062d, B:260:0x063f, B:254:0x0646, B:257:0x0654, B:258:0x0674, B:321:0x00c1, B:322:0x00df, B:398:0x00e4, B:400:0x00ef, B:402:0x00f3, B:404:0x00f7, B:407:0x00fd, B:327:0x010c, B:329:0x0114, B:333:0x0126, B:334:0x013e, B:336:0x013f, B:337:0x0144, B:346:0x0159, B:348:0x015f, B:350:0x0166, B:351:0x0171, B:356:0x0183, B:360:0x018d, B:361:0x01a5, B:362:0x017e, B:363:0x016b, B:365:0x01a6, B:366:0x01be, B:374:0x01c8, B:376:0x01d0, B:380:0x01e3, B:381:0x0203, B:383:0x0204, B:384:0x0209, B:385:0x020a, B:387:0x0214, B:389:0x0675, B:390:0x067c, B:392:0x067d, B:393:0x0682, B:395:0x0683, B:396:0x0688), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0498 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:45:0x0237, B:52:0x024d, B:54:0x025b, B:57:0x029e, B:59:0x02a6, B:61:0x02b3, B:63:0x02b6, B:65:0x02c0, B:69:0x02d0, B:70:0x02d6, B:72:0x02de, B:73:0x02e3, B:75:0x02eb, B:76:0x02f5, B:81:0x02fd, B:82:0x0304, B:83:0x0305, B:86:0x030f, B:88:0x0313, B:90:0x0319, B:91:0x031c, B:93:0x0322, B:96:0x0333, B:102:0x034d, B:103:0x035a, B:106:0x0352, B:108:0x0356, B:109:0x0261, B:112:0x026c, B:116:0x0278, B:118:0x027e, B:122:0x028b, B:125:0x028e, B:134:0x036b, B:263:0x0377, B:267:0x037f, B:269:0x0389, B:271:0x039a, B:273:0x03a4, B:275:0x03ac, B:277:0x03b0, B:279:0x03b6, B:282:0x03bb, B:284:0x03bf, B:285:0x0424, B:287:0x042c, B:290:0x0435, B:291:0x044f, B:294:0x03c5, B:296:0x03cd, B:299:0x03d3, B:300:0x03e0, B:303:0x03e9, B:307:0x03ef, B:310:0x03f4, B:311:0x0401, B:313:0x040b, B:314:0x0419, B:316:0x0450, B:317:0x046e, B:140:0x0471, B:142:0x0475, B:144:0x0479, B:147:0x047f, B:151:0x0488, B:157:0x0498, B:159:0x04a7, B:161:0x04b2, B:162:0x04ba, B:163:0x04bd, B:164:0x04e9, B:166:0x04f4, B:173:0x0501, B:176:0x0511, B:177:0x0531, B:182:0x04cd, B:184:0x04d7, B:185:0x04e6, B:186:0x04dc, B:191:0x0536, B:193:0x0540, B:195:0x0548, B:196:0x054b, B:198:0x0556, B:199:0x055a, B:208:0x0565, B:201:0x056c, B:205:0x0578, B:206:0x057d, B:213:0x0582, B:215:0x0587, B:218:0x0593, B:220:0x059b, B:222:0x05ae, B:224:0x05c9, B:225:0x05d1, B:228:0x05d9, B:230:0x05dd, B:231:0x05e4, B:233:0x05e9, B:234:0x05ec, B:245:0x05f4, B:236:0x05fe, B:239:0x0608, B:240:0x060d, B:242:0x0612, B:243:0x062c, B:249:0x05b7, B:250:0x05bc, B:252:0x062d, B:260:0x063f, B:254:0x0646, B:257:0x0654, B:258:0x0674, B:321:0x00c1, B:322:0x00df, B:398:0x00e4, B:400:0x00ef, B:402:0x00f3, B:404:0x00f7, B:407:0x00fd, B:327:0x010c, B:329:0x0114, B:333:0x0126, B:334:0x013e, B:336:0x013f, B:337:0x0144, B:346:0x0159, B:348:0x015f, B:350:0x0166, B:351:0x0171, B:356:0x0183, B:360:0x018d, B:361:0x01a5, B:362:0x017e, B:363:0x016b, B:365:0x01a6, B:366:0x01be, B:374:0x01c8, B:376:0x01d0, B:380:0x01e3, B:381:0x0203, B:383:0x0204, B:384:0x0209, B:385:0x020a, B:387:0x0214, B:389:0x0675, B:390:0x067c, B:392:0x067d, B:393:0x0682, B:395:0x0683, B:396:0x0688), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04f4 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:45:0x0237, B:52:0x024d, B:54:0x025b, B:57:0x029e, B:59:0x02a6, B:61:0x02b3, B:63:0x02b6, B:65:0x02c0, B:69:0x02d0, B:70:0x02d6, B:72:0x02de, B:73:0x02e3, B:75:0x02eb, B:76:0x02f5, B:81:0x02fd, B:82:0x0304, B:83:0x0305, B:86:0x030f, B:88:0x0313, B:90:0x0319, B:91:0x031c, B:93:0x0322, B:96:0x0333, B:102:0x034d, B:103:0x035a, B:106:0x0352, B:108:0x0356, B:109:0x0261, B:112:0x026c, B:116:0x0278, B:118:0x027e, B:122:0x028b, B:125:0x028e, B:134:0x036b, B:263:0x0377, B:267:0x037f, B:269:0x0389, B:271:0x039a, B:273:0x03a4, B:275:0x03ac, B:277:0x03b0, B:279:0x03b6, B:282:0x03bb, B:284:0x03bf, B:285:0x0424, B:287:0x042c, B:290:0x0435, B:291:0x044f, B:294:0x03c5, B:296:0x03cd, B:299:0x03d3, B:300:0x03e0, B:303:0x03e9, B:307:0x03ef, B:310:0x03f4, B:311:0x0401, B:313:0x040b, B:314:0x0419, B:316:0x0450, B:317:0x046e, B:140:0x0471, B:142:0x0475, B:144:0x0479, B:147:0x047f, B:151:0x0488, B:157:0x0498, B:159:0x04a7, B:161:0x04b2, B:162:0x04ba, B:163:0x04bd, B:164:0x04e9, B:166:0x04f4, B:173:0x0501, B:176:0x0511, B:177:0x0531, B:182:0x04cd, B:184:0x04d7, B:185:0x04e6, B:186:0x04dc, B:191:0x0536, B:193:0x0540, B:195:0x0548, B:196:0x054b, B:198:0x0556, B:199:0x055a, B:208:0x0565, B:201:0x056c, B:205:0x0578, B:206:0x057d, B:213:0x0582, B:215:0x0587, B:218:0x0593, B:220:0x059b, B:222:0x05ae, B:224:0x05c9, B:225:0x05d1, B:228:0x05d9, B:230:0x05dd, B:231:0x05e4, B:233:0x05e9, B:234:0x05ec, B:245:0x05f4, B:236:0x05fe, B:239:0x0608, B:240:0x060d, B:242:0x0612, B:243:0x062c, B:249:0x05b7, B:250:0x05bc, B:252:0x062d, B:260:0x063f, B:254:0x0646, B:257:0x0654, B:258:0x0674, B:321:0x00c1, B:322:0x00df, B:398:0x00e4, B:400:0x00ef, B:402:0x00f3, B:404:0x00f7, B:407:0x00fd, B:327:0x010c, B:329:0x0114, B:333:0x0126, B:334:0x013e, B:336:0x013f, B:337:0x0144, B:346:0x0159, B:348:0x015f, B:350:0x0166, B:351:0x0171, B:356:0x0183, B:360:0x018d, B:361:0x01a5, B:362:0x017e, B:363:0x016b, B:365:0x01a6, B:366:0x01be, B:374:0x01c8, B:376:0x01d0, B:380:0x01e3, B:381:0x0203, B:383:0x0204, B:384:0x0209, B:385:0x020a, B:387:0x0214, B:389:0x0675, B:390:0x067c, B:392:0x067d, B:393:0x0682, B:395:0x0683, B:396:0x0688), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x018d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x021e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:45:0x0237, B:52:0x024d, B:54:0x025b, B:57:0x029e, B:59:0x02a6, B:61:0x02b3, B:63:0x02b6, B:65:0x02c0, B:69:0x02d0, B:70:0x02d6, B:72:0x02de, B:73:0x02e3, B:75:0x02eb, B:76:0x02f5, B:81:0x02fd, B:82:0x0304, B:83:0x0305, B:86:0x030f, B:88:0x0313, B:90:0x0319, B:91:0x031c, B:93:0x0322, B:96:0x0333, B:102:0x034d, B:103:0x035a, B:106:0x0352, B:108:0x0356, B:109:0x0261, B:112:0x026c, B:116:0x0278, B:118:0x027e, B:122:0x028b, B:125:0x028e, B:134:0x036b, B:263:0x0377, B:267:0x037f, B:269:0x0389, B:271:0x039a, B:273:0x03a4, B:275:0x03ac, B:277:0x03b0, B:279:0x03b6, B:282:0x03bb, B:284:0x03bf, B:285:0x0424, B:287:0x042c, B:290:0x0435, B:291:0x044f, B:294:0x03c5, B:296:0x03cd, B:299:0x03d3, B:300:0x03e0, B:303:0x03e9, B:307:0x03ef, B:310:0x03f4, B:311:0x0401, B:313:0x040b, B:314:0x0419, B:316:0x0450, B:317:0x046e, B:140:0x0471, B:142:0x0475, B:144:0x0479, B:147:0x047f, B:151:0x0488, B:157:0x0498, B:159:0x04a7, B:161:0x04b2, B:162:0x04ba, B:163:0x04bd, B:164:0x04e9, B:166:0x04f4, B:173:0x0501, B:176:0x0511, B:177:0x0531, B:182:0x04cd, B:184:0x04d7, B:185:0x04e6, B:186:0x04dc, B:191:0x0536, B:193:0x0540, B:195:0x0548, B:196:0x054b, B:198:0x0556, B:199:0x055a, B:208:0x0565, B:201:0x056c, B:205:0x0578, B:206:0x057d, B:213:0x0582, B:215:0x0587, B:218:0x0593, B:220:0x059b, B:222:0x05ae, B:224:0x05c9, B:225:0x05d1, B:228:0x05d9, B:230:0x05dd, B:231:0x05e4, B:233:0x05e9, B:234:0x05ec, B:245:0x05f4, B:236:0x05fe, B:239:0x0608, B:240:0x060d, B:242:0x0612, B:243:0x062c, B:249:0x05b7, B:250:0x05bc, B:252:0x062d, B:260:0x063f, B:254:0x0646, B:257:0x0654, B:258:0x0674, B:321:0x00c1, B:322:0x00df, B:398:0x00e4, B:400:0x00ef, B:402:0x00f3, B:404:0x00f7, B:407:0x00fd, B:327:0x010c, B:329:0x0114, B:333:0x0126, B:334:0x013e, B:336:0x013f, B:337:0x0144, B:346:0x0159, B:348:0x015f, B:350:0x0166, B:351:0x0171, B:356:0x0183, B:360:0x018d, B:361:0x01a5, B:362:0x017e, B:363:0x016b, B:365:0x01a6, B:366:0x01be, B:374:0x01c8, B:376:0x01d0, B:380:0x01e3, B:381:0x0203, B:383:0x0204, B:384:0x0209, B:385:0x020a, B:387:0x0214, B:389:0x0675, B:390:0x067c, B:392:0x067d, B:393:0x0682, B:395:0x0683, B:396:0x0688), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x029e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:45:0x0237, B:52:0x024d, B:54:0x025b, B:57:0x029e, B:59:0x02a6, B:61:0x02b3, B:63:0x02b6, B:65:0x02c0, B:69:0x02d0, B:70:0x02d6, B:72:0x02de, B:73:0x02e3, B:75:0x02eb, B:76:0x02f5, B:81:0x02fd, B:82:0x0304, B:83:0x0305, B:86:0x030f, B:88:0x0313, B:90:0x0319, B:91:0x031c, B:93:0x0322, B:96:0x0333, B:102:0x034d, B:103:0x035a, B:106:0x0352, B:108:0x0356, B:109:0x0261, B:112:0x026c, B:116:0x0278, B:118:0x027e, B:122:0x028b, B:125:0x028e, B:134:0x036b, B:263:0x0377, B:267:0x037f, B:269:0x0389, B:271:0x039a, B:273:0x03a4, B:275:0x03ac, B:277:0x03b0, B:279:0x03b6, B:282:0x03bb, B:284:0x03bf, B:285:0x0424, B:287:0x042c, B:290:0x0435, B:291:0x044f, B:294:0x03c5, B:296:0x03cd, B:299:0x03d3, B:300:0x03e0, B:303:0x03e9, B:307:0x03ef, B:310:0x03f4, B:311:0x0401, B:313:0x040b, B:314:0x0419, B:316:0x0450, B:317:0x046e, B:140:0x0471, B:142:0x0475, B:144:0x0479, B:147:0x047f, B:151:0x0488, B:157:0x0498, B:159:0x04a7, B:161:0x04b2, B:162:0x04ba, B:163:0x04bd, B:164:0x04e9, B:166:0x04f4, B:173:0x0501, B:176:0x0511, B:177:0x0531, B:182:0x04cd, B:184:0x04d7, B:185:0x04e6, B:186:0x04dc, B:191:0x0536, B:193:0x0540, B:195:0x0548, B:196:0x054b, B:198:0x0556, B:199:0x055a, B:208:0x0565, B:201:0x056c, B:205:0x0578, B:206:0x057d, B:213:0x0582, B:215:0x0587, B:218:0x0593, B:220:0x059b, B:222:0x05ae, B:224:0x05c9, B:225:0x05d1, B:228:0x05d9, B:230:0x05dd, B:231:0x05e4, B:233:0x05e9, B:234:0x05ec, B:245:0x05f4, B:236:0x05fe, B:239:0x0608, B:240:0x060d, B:242:0x0612, B:243:0x062c, B:249:0x05b7, B:250:0x05bc, B:252:0x062d, B:260:0x063f, B:254:0x0646, B:257:0x0654, B:258:0x0674, B:321:0x00c1, B:322:0x00df, B:398:0x00e4, B:400:0x00ef, B:402:0x00f3, B:404:0x00f7, B:407:0x00fd, B:327:0x010c, B:329:0x0114, B:333:0x0126, B:334:0x013e, B:336:0x013f, B:337:0x0144, B:346:0x0159, B:348:0x015f, B:350:0x0166, B:351:0x0171, B:356:0x0183, B:360:0x018d, B:361:0x01a5, B:362:0x017e, B:363:0x016b, B:365:0x01a6, B:366:0x01be, B:374:0x01c8, B:376:0x01d0, B:380:0x01e3, B:381:0x0203, B:383:0x0204, B:384:0x0209, B:385:0x020a, B:387:0x0214, B:389:0x0675, B:390:0x067c, B:392:0x067d, B:393:0x0682, B:395:0x0683, B:396:0x0688), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02a6 A[EDGE_INSN: B:58:0x02a6->B:59:0x02a6 BREAK  A[LOOP:0: B:28:0x0085->B:50:0x0085], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r0(java.util.Map r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 1677
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.a.r0(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public b s() {
        return this.f78954f;
    }

    public Object t(String str) {
        for (int i11 = 0; i11 < this.f78957i; i11++) {
            if (str.equals(this.f78956h[i11].toString())) {
                return this.f78956h[i11].f78989a;
            }
        }
        return null;
    }

    public int u() {
        return this.f78959k;
    }

    public void u0(Object obj) {
        Object c11;
        Class<?> cls = obj.getClass();
        b2 p11 = this.f78951c.p(cls);
        o oVar = p11 instanceof o ? (o) p11 : null;
        if (this.f78954f.q0() != 12 && this.f78954f.q0() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.f78954f.v());
        }
        while (true) {
            String i11 = this.f78954f.i(this.f78950b);
            if (i11 == null) {
                if (this.f78954f.q0() == 13) {
                    this.f78954f.c0(16);
                    return;
                } else if (this.f78954f.q0() == 16 && this.f78954f.n(Feature.AllowArbitraryCommas)) {
                }
            }
            l j11 = oVar != null ? oVar.j(i11) : null;
            if (j11 != null) {
                com.alibaba.fastjson.util.d dVar = j11.f79366a;
                Class cls2 = dVar.f18283e;
                Type type = dVar.f18284f;
                if (cls2 == Integer.TYPE) {
                    this.f78954f.q(2);
                    c11 = j0.f335a.c(this, type, null);
                } else if (cls2 == String.class) {
                    this.f78954f.q(4);
                    c11 = k1.e(this);
                } else if (cls2 == Long.TYPE) {
                    this.f78954f.q(2);
                    c11 = u0.f425a.c(this, type, null);
                } else {
                    b2 o11 = this.f78951c.o(cls2, type);
                    this.f78954f.q(o11.b());
                    c11 = o11.c(this, type, null);
                }
                j11.h(obj, c11);
                if (this.f78954f.q0() != 16 && this.f78954f.q0() == 13) {
                    this.f78954f.c0(16);
                    return;
                }
            } else {
                if (!this.f78954f.n(Feature.IgnoreNotMatch)) {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + i11);
                }
                this.f78954f.u();
                T();
                if (this.f78954f.q0() == 13) {
                    this.f78954f.Z();
                    return;
                }
            }
        }
    }

    public i v() {
        return this.f78950b;
    }

    public void v0() {
        if (this.f78954f.n(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.f78955g = this.f78955g.f78990b;
        int i11 = this.f78957i;
        if (i11 <= 0) {
            return;
        }
        int i12 = i11 - 1;
        this.f78957i = i12;
        this.f78956h[i12] = null;
    }

    public void w(Object obj) {
        Object obj2;
        g gVar;
        com.alibaba.fastjson.util.d dVar;
        List list = this.f78958j;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            C0994a c0994a = (C0994a) this.f78958j.get(i11);
            String str = c0994a.f78965b;
            g gVar2 = c0994a.f78967d;
            Object obj3 = gVar2 != null ? gVar2.f78989a : null;
            if (str.startsWith("$")) {
                obj2 = t(str);
                if (obj2 == null) {
                    try {
                        JSONPath jSONPath = new JSONPath(str, g1.g(), this.f78951c, true);
                        if (jSONPath.n()) {
                            obj2 = jSONPath.e(obj);
                        }
                    } catch (JSONPathException unused) {
                    }
                }
            } else {
                obj2 = c0994a.f78964a.f78989a;
            }
            l lVar = c0994a.f78966c;
            if (lVar != null) {
                if (obj2 != null && obj2.getClass() == JSONObject.class && (dVar = lVar.f79366a) != null && !Map.class.isAssignableFrom(dVar.f18283e)) {
                    Object obj4 = this.f78956h[0].f78989a;
                    JSONPath b11 = JSONPath.b(str);
                    if (b11.n()) {
                        obj2 = b11.e(obj4);
                    }
                }
                if (lVar.c() != null && !lVar.c().isInstance(obj3) && (gVar = c0994a.f78967d.f78990b) != null) {
                    while (true) {
                        if (gVar == null) {
                            break;
                        }
                        if (lVar.c().isInstance(gVar.f78989a)) {
                            obj3 = gVar.f78989a;
                            break;
                        }
                        gVar = gVar.f78990b;
                    }
                }
                lVar.h(obj3, obj2);
            }
        }
    }

    public boolean x(Feature feature) {
        return this.f78954f.n(feature);
    }

    public Object x0(String str) {
        if (this.f78956h == null) {
            return null;
        }
        int i11 = 0;
        while (true) {
            g[] gVarArr = this.f78956h;
            if (i11 >= gVarArr.length || i11 >= this.f78957i) {
                break;
            }
            g gVar = gVarArr[i11];
            if (gVar.toString().equals(str)) {
                return gVar.f78989a;
            }
            i11++;
        }
        return null;
    }

    public g y0(Object obj, Object obj2) {
        if (this.f78954f.n(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return z0(this.f78955g, obj, obj2);
    }

    public g z0(g gVar, Object obj, Object obj2) {
        if (this.f78954f.n(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        g gVar2 = new g(gVar, obj, obj2);
        this.f78955g = gVar2;
        h(gVar2);
        return this.f78955g;
    }
}
