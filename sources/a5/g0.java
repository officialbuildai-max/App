package a5;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class g0 implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final com.alibaba.fastjson.util.d f281a;

    /* renamed from: b, reason: collision with root package name */
    protected final boolean f282b;

    /* renamed from: c, reason: collision with root package name */
    protected int f283c;

    /* renamed from: d, reason: collision with root package name */
    private final String f284d;

    /* renamed from: e, reason: collision with root package name */
    private String f285e;

    /* renamed from: f, reason: collision with root package name */
    private String f286f;

    /* renamed from: g, reason: collision with root package name */
    protected p f287g;

    /* renamed from: h, reason: collision with root package name */
    private String f288h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f289i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f290j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f291k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f292l = false;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f293m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f294n;

    /* renamed from: o, reason: collision with root package name */
    private a f295o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final z0 f296a;

        /* renamed from: b, reason: collision with root package name */
        final Class f297b;

        public a(z0 z0Var, Class cls) {
            this.f296a = z0Var;
            this.f297b = cls;
        }
    }

    public g0(Class cls, com.alibaba.fastjson.util.d dVar) {
        boolean z10;
        x4.d dVar2;
        this.f289i = false;
        this.f290j = false;
        this.f291k = false;
        this.f293m = false;
        this.f281a = dVar;
        this.f287g = new p(cls, dVar);
        if (cls != null && (dVar2 = (x4.d) TypeUtils.N(cls, x4.d.class)) != null) {
            for (SerializerFeature serializerFeature : dVar2.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                    this.f289i = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                    this.f290j = true;
                } else if (serializerFeature == SerializerFeature.DisableCircularReferenceDetect) {
                    this.f291k = true;
                } else {
                    SerializerFeature serializerFeature2 = SerializerFeature.BrowserCompatible;
                    if (serializerFeature == serializerFeature2) {
                        this.f283c |= serializerFeature2.mask;
                        this.f294n = true;
                    } else {
                        SerializerFeature serializerFeature3 = SerializerFeature.WriteMapNullValue;
                        if (serializerFeature == serializerFeature3) {
                            this.f283c |= serializerFeature3.mask;
                        }
                    }
                }
            }
        }
        dVar.p();
        this.f284d = '\"' + dVar.f18279a + "\":";
        x4.b e11 = dVar.e();
        if (e11 != null) {
            SerializerFeature[] serialzeFeatures = e11.serialzeFeatures();
            int length = serialzeFeatures.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z10 = false;
                    break;
                } else {
                    if ((serialzeFeatures[i11].getMask() & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) {
                        z10 = true;
                        break;
                    }
                    i11++;
                }
            }
            String format = e11.format();
            this.f288h = format;
            if (format.trim().length() == 0) {
                this.f288h = null;
            }
            for (SerializerFeature serializerFeature4 : e11.serialzeFeatures()) {
                if (serializerFeature4 == SerializerFeature.WriteEnumUsingToString) {
                    this.f289i = true;
                } else if (serializerFeature4 == SerializerFeature.WriteEnumUsingName) {
                    this.f290j = true;
                } else if (serializerFeature4 == SerializerFeature.DisableCircularReferenceDetect) {
                    this.f291k = true;
                } else if (serializerFeature4 == SerializerFeature.BrowserCompatible) {
                    this.f294n = true;
                }
            }
            this.f283c = SerializerFeature.of(e11.serialzeFeatures()) | this.f283c;
        } else {
            z10 = false;
        }
        this.f282b = z10;
        this.f293m = TypeUtils.n0(dVar.f18280b) || TypeUtils.m0(dVar.f18280b);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g0 g0Var) {
        return this.f281a.compareTo(g0Var.f281a);
    }

    public Object b(Object obj) {
        Object d11 = this.f281a.d(obj);
        if (this.f288h == null || d11 == null) {
            return d11;
        }
        Class cls = this.f281a.f18283e;
        if (cls != Date.class && cls != java.sql.Date.class) {
            return d11;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f288h, com.alibaba.fastjson.a.defaultLocale);
        simpleDateFormat.setTimeZone(com.alibaba.fastjson.a.defaultTimeZone);
        return simpleDateFormat.format(d11);
    }

    public Object d(Object obj) {
        Object d11 = this.f281a.d(obj);
        if (!this.f293m || TypeUtils.q0(d11)) {
            return d11;
        }
        return null;
    }

    public void e(o0 o0Var) {
        j1 j1Var = o0Var.f371k;
        if (!j1Var.f347f) {
            if (this.f286f == null) {
                this.f286f = this.f281a.f18279a + ":";
            }
            j1Var.write(this.f286f);
            return;
        }
        if (!SerializerFeature.isEnabled(j1Var.f344c, this.f281a.f18287i, SerializerFeature.UseSingleQuotes)) {
            j1Var.write(this.f284d);
            return;
        }
        if (this.f285e == null) {
            this.f285e = '\'' + this.f281a.f18279a + "':";
        }
        j1Var.write(this.f285e);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(a5.o0 r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.g0.f(a5.o0, java.lang.Object):void");
    }
}
