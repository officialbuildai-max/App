package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class o0 extends i1 {

    /* renamed from: j, reason: collision with root package name */
    protected final g1 f370j;

    /* renamed from: k, reason: collision with root package name */
    public final j1 f371k;

    /* renamed from: l, reason: collision with root package name */
    private int f372l;

    /* renamed from: m, reason: collision with root package name */
    private String f373m;

    /* renamed from: n, reason: collision with root package name */
    private String f374n;

    /* renamed from: o, reason: collision with root package name */
    private DateFormat f375o;

    /* renamed from: p, reason: collision with root package name */
    private String f376p;

    /* renamed from: q, reason: collision with root package name */
    protected IdentityHashMap f377q;

    /* renamed from: r, reason: collision with root package name */
    protected e1 f378r;

    /* renamed from: s, reason: collision with root package name */
    protected TimeZone f379s;

    /* renamed from: t, reason: collision with root package name */
    protected Locale f380t;

    public o0() {
        this(new j1(), g1.g());
    }

    public o0(j1 j1Var) {
        this(j1Var, g1.g());
    }

    public o0(j1 j1Var, g1 g1Var) {
        this.f372l = 0;
        this.f373m = "\t";
        this.f377q = null;
        this.f379s = com.alibaba.fastjson.a.defaultTimeZone;
        this.f380t = com.alibaba.fastjson.a.defaultLocale;
        this.f371k = j1Var;
        this.f370j = g1Var;
    }

    private DateFormat m(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, this.f380t);
        simpleDateFormat.setTimeZone(this.f379s);
        return simpleDateFormat;
    }

    public final void A(Object obj) {
        if (obj == null) {
            this.f371k.m0();
            return;
        }
        try {
            q(obj.getClass()).d(this, obj, null, null, 0);
        } catch (IOException e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public final void B(String str) {
        k1.f362a.f(this, str);
    }

    public void C() {
        this.f371k.m0();
    }

    public void D(Object obj) {
        e1 e1Var = this.f378r;
        if (obj == e1Var.f270b) {
            this.f371k.write("{\"$ref\":\"@\"}");
            return;
        }
        e1 e1Var2 = e1Var.f269a;
        if (e1Var2 != null && obj == e1Var2.f270b) {
            this.f371k.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            e1 e1Var3 = e1Var.f269a;
            if (e1Var3 == null) {
                break;
            } else {
                e1Var = e1Var3;
            }
        }
        if (obj == e1Var.f270b) {
            this.f371k.write("{\"$ref\":\"$\"}");
            return;
        }
        this.f371k.write("{\"$ref\":\"");
        this.f371k.write(((e1) this.f377q.get(obj)).toString());
        this.f371k.write("\"}");
    }

    public final void E(Object obj, Object obj2) {
        F(obj, obj2, null, 0);
    }

    public final void F(Object obj, Object obj2, Type type, int i11) {
        try {
            if (obj == null) {
                this.f371k.m0();
            } else {
                q(obj.getClass()).d(this, obj, obj2, type, i11);
            }
        } catch (IOException e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public final void G(Object obj, String str) {
        if (obj instanceof Date) {
            if ("unixtime".equals(str)) {
                this.f371k.h0((int) (((Date) obj).getTime() / 1000));
                return;
            }
            if ("millis".equals(str)) {
                this.f371k.l0(((Date) obj).getTime());
                return;
            }
            DateFormat n11 = n();
            if (n11 == null) {
                if (str != null) {
                    try {
                        n11 = m(str);
                    } catch (IllegalArgumentException unused) {
                        n11 = m(str.replaceAll("T", "'T'"));
                    }
                } else {
                    String str2 = this.f376p;
                    n11 = str2 != null ? m(str2) : m(com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT);
                }
            }
            this.f371k.q0(n11.format((Date) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            if (!(obj instanceof Collection)) {
                A(obj);
                return;
            }
            Collection collection = (Collection) obj;
            Iterator it = collection.iterator();
            this.f371k.write(91);
            for (int i11 = 0; i11 < collection.size(); i11++) {
                Object next = it.next();
                if (i11 != 0) {
                    this.f371k.write(44);
                }
                G(next, str);
            }
            this.f371k.write(93);
            return;
        }
        byte[] bArr = (byte[]) obj;
        if (!"gzip".equals(str) && !"gzip,base64".equals(str)) {
            if ("hex".equals(str)) {
                this.f371k.g0(bArr);
                return;
            } else {
                this.f371k.t(bArr);
                return;
            }
        }
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                gZIPOutputStream = bArr.length < 512 ? new GZIPOutputStream(byteArrayOutputStream, bArr.length) : new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                this.f371k.t(byteArrayOutputStream.toByteArray());
                com.alibaba.fastjson.util.f.a(gZIPOutputStream);
            } catch (IOException e11) {
                throw new JSONException("write gzipBytes error", e11);
            }
        } catch (Throwable th2) {
            com.alibaba.fastjson.util.f.a(gZIPOutputStream);
            throw th2;
        }
    }

    public void j(SerializerFeature serializerFeature, boolean z10) {
        this.f371k.l(serializerFeature, z10);
    }

    public boolean k(Object obj) {
        e1 e1Var;
        IdentityHashMap identityHashMap = this.f377q;
        if (identityHashMap == null || (e1Var = (e1) identityHashMap.get(obj)) == null || obj == Collections.emptyMap()) {
            return false;
        }
        Object obj2 = e1Var.f271c;
        return obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String);
    }

    public void l() {
        this.f372l--;
    }

    public DateFormat n() {
        String str;
        if (this.f375o == null && (str = this.f374n) != null) {
            this.f375o = m(str);
        }
        return this.f375o;
    }

    public String o() {
        DateFormat dateFormat = this.f375o;
        return dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : this.f374n;
    }

    public String p() {
        return this.f376p;
    }

    public z0 q(Class cls) {
        return this.f370j.h(cls);
    }

    public j1 r() {
        return this.f371k;
    }

    public void s() {
        this.f372l++;
    }

    public boolean t(SerializerFeature serializerFeature) {
        return this.f371k.q(serializerFeature);
    }

    public String toString() {
        return this.f371k.toString();
    }

    public final boolean u(Type type, Object obj) {
        e1 e1Var;
        return this.f371k.q(SerializerFeature.WriteClassName) && !(type == null && this.f371k.q(SerializerFeature.NotWriteRootClassName) && ((e1Var = this.f378r) == null || e1Var.f269a == null));
    }

    public void v() {
        this.f371k.write(10);
        for (int i11 = 0; i11 < this.f372l; i11++) {
            this.f371k.write(this.f373m);
        }
    }

    public void w(e1 e1Var, Object obj, Object obj2, int i11) {
        x(e1Var, obj, obj2, i11, 0);
    }

    public void x(e1 e1Var, Object obj, Object obj2, int i11, int i12) {
        if (this.f371k.f349h) {
            return;
        }
        this.f378r = new e1(e1Var, obj, obj2, i11, i12);
        if (this.f377q == null) {
            this.f377q = new IdentityHashMap();
        }
        this.f377q.put(obj, this.f378r);
    }

    public void y(String str) {
        this.f374n = str;
        if (this.f375o != null) {
            this.f375o = null;
        }
    }

    public void z(String str) {
        this.f376p = str;
    }
}
