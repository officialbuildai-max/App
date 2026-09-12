package h10;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import h10.c;
import okhttp3.internal.http2.Settings;
import org.mvel2.asm.ClassTooLargeException;

/* loaded from: classes7.dex */
public class g extends f {
    private int A;
    private d B;
    private c C;
    private int D;

    /* renamed from: c, reason: collision with root package name */
    private int f64201c;

    /* renamed from: d, reason: collision with root package name */
    private final x f64202d;

    /* renamed from: e, reason: collision with root package name */
    private int f64203e;

    /* renamed from: f, reason: collision with root package name */
    private int f64204f;

    /* renamed from: g, reason: collision with root package name */
    private int f64205g;

    /* renamed from: h, reason: collision with root package name */
    private int f64206h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f64207i;

    /* renamed from: j, reason: collision with root package name */
    private m f64208j;

    /* renamed from: k, reason: collision with root package name */
    private m f64209k;

    /* renamed from: l, reason: collision with root package name */
    private s f64210l;

    /* renamed from: m, reason: collision with root package name */
    private s f64211m;

    /* renamed from: n, reason: collision with root package name */
    private int f64212n;

    /* renamed from: o, reason: collision with root package name */
    private d f64213o;

    /* renamed from: p, reason: collision with root package name */
    private int f64214p;

    /* renamed from: q, reason: collision with root package name */
    private int f64215q;

    /* renamed from: r, reason: collision with root package name */
    private int f64216r;

    /* renamed from: s, reason: collision with root package name */
    private int f64217s;

    /* renamed from: t, reason: collision with root package name */
    private d f64218t;

    /* renamed from: u, reason: collision with root package name */
    private b f64219u;

    /* renamed from: v, reason: collision with root package name */
    private b f64220v;

    /* renamed from: w, reason: collision with root package name */
    private b f64221w;

    /* renamed from: x, reason: collision with root package name */
    private b f64222x;

    /* renamed from: y, reason: collision with root package name */
    private u f64223y;

    /* renamed from: z, reason: collision with root package name */
    private int f64224z;

    public g(int i11) {
        this(null, i11);
    }

    public g(e eVar, int i11) {
        super(458752);
        this.f64202d = eVar == null ? new x(this) : new x(this, eVar);
        if ((i11 & 2) != 0) {
            this.D = 4;
        } else if ((i11 & 1) != 0) {
            this.D = 1;
        } else {
            this.D = 0;
        }
    }

    private c[] n() {
        c.a aVar = new c.a();
        aVar.b(this.C);
        for (m mVar = this.f64208j; mVar != null; mVar = (m) mVar.f64252b) {
            mVar.e(aVar);
        }
        for (s sVar = this.f64210l; sVar != null; sVar = (s) sVar.f64299b) {
            sVar.I(aVar);
        }
        return aVar.d();
    }

    private byte[] q(byte[] bArr, boolean z10) {
        c[] n11 = n();
        this.f64208j = null;
        this.f64209k = null;
        this.f64210l = null;
        this.f64211m = null;
        this.f64219u = null;
        this.f64220v = null;
        this.f64221w = null;
        this.f64222x = null;
        this.f64223y = null;
        this.f64224z = 0;
        this.A = 0;
        this.B = null;
        this.C = null;
        this.D = z10 ? 3 : 0;
        new e(bArr, 0, false).a(this, n11, (z10 ? 8 : 0) | 256);
        return r();
    }

    @Override // h10.f
    public final void a(int i11, int i12, String str, String str2, String str3, String[] strArr) {
        this.f64201c = i11;
        this.f64203e = i12;
        x xVar = this.f64202d;
        int i13 = i11 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f64204f = xVar.f0(i13, str);
        if (str2 != null) {
            this.f64216r = this.f64202d.D(str2);
        }
        this.f64205g = str3 == null ? 0 : this.f64202d.e(str3).f64353a;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.f64206h = length;
            this.f64207i = new int[length];
            for (int i14 = 0; i14 < this.f64206h; i14++) {
                this.f64207i[i14] = this.f64202d.e(strArr[i14]).f64353a;
            }
        }
        if (this.D != 1 || i13 < 51) {
            return;
        }
        this.D = 2;
    }

    @Override // h10.f
    public final a b(String str, boolean z10) {
        d dVar = new d();
        dVar.k(this.f64202d.D(str)).k(0);
        if (z10) {
            b bVar = new b(this.f64202d, dVar, this.f64219u);
            this.f64219u = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f64202d, dVar, this.f64220v);
        this.f64220v = bVar2;
        return bVar2;
    }

    @Override // h10.f
    public final void c(c cVar) {
        cVar.f64187c = this.C;
        this.C = cVar;
    }

    @Override // h10.f
    public final void d() {
    }

    @Override // h10.f
    public final l e(int i11, String str, String str2, String str3, Object obj) {
        m mVar = new m(this.f64202d, i11, str, str2, str3, obj);
        if (this.f64208j == null) {
            this.f64208j = mVar;
        } else {
            this.f64209k.f64252b = mVar;
        }
        this.f64209k = mVar;
        return mVar;
    }

    @Override // h10.f
    public final void f(String str, String str2, String str3, int i11) {
        if (this.f64213o == null) {
            this.f64213o = new d();
        }
        w e11 = this.f64202d.e(str);
        if (e11.f64359g == 0) {
            this.f64212n++;
            this.f64213o.k(e11.f64353a);
            this.f64213o.k(str2 == null ? 0 : this.f64202d.e(str2).f64353a);
            this.f64213o.k(str3 != null ? this.f64202d.D(str3) : 0);
            this.f64213o.k(i11);
            e11.f64359g = this.f64212n;
        }
    }

    @Override // h10.f
    public final r g(int i11, String str, String str2, String str3, String[] strArr) {
        s sVar = new s(this.f64202d, i11, str, str2, str3, strArr, this.D);
        if (this.f64210l == null) {
            this.f64210l = sVar;
        } else {
            this.f64211m.f64299b = sVar;
        }
        this.f64211m = sVar;
        return sVar;
    }

    @Override // h10.f
    public final t h(String str, int i11, String str2) {
        x xVar = this.f64202d;
        u uVar = new u(xVar, xVar.y(str).f64353a, i11, str2 == null ? 0 : this.f64202d.D(str2));
        this.f64223y = uVar;
        return uVar;
    }

    @Override // h10.f
    public void i(String str) {
        this.f64224z = this.f64202d.e(str).f64353a;
    }

    @Override // h10.f
    public void j(String str) {
        if (this.B == null) {
            this.B = new d();
        }
        this.A++;
        this.B.k(this.f64202d.e(str).f64353a);
    }

    @Override // h10.f
    public final void k(String str, String str2, String str3) {
        this.f64214p = this.f64202d.e(str).f64353a;
        if (str2 == null || str3 == null) {
            return;
        }
        this.f64215q = this.f64202d.z(str2, str3);
    }

    @Override // h10.f
    public final void l(String str, String str2) {
        if (str != null) {
            this.f64217s = this.f64202d.D(str);
        }
        if (str2 != null) {
            this.f64218t = new d().a(str2, 0, Integer.MAX_VALUE);
        }
    }

    @Override // h10.f
    public final a m(int i11, z zVar, String str, boolean z10) {
        d dVar = new d();
        a0.a(i11, dVar);
        z.d(zVar, dVar);
        dVar.k(this.f64202d.D(str)).k(0);
        if (z10) {
            b bVar = new b(this.f64202d, dVar, this.f64221w);
            this.f64221w = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f64202d, dVar, this.f64222x);
        this.f64222x = bVar2;
        return bVar2;
    }

    protected ClassLoader o() {
        return getClass().getClassLoader();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String p(String str, String str2) {
        ClassLoader o11 = o();
        try {
            Class<?> cls = Class.forName(str.replace('/', '.'), false, o11);
            try {
                Class<?> cls2 = Class.forName(str2.replace('/', '.'), false, o11);
                if (cls.isAssignableFrom(cls2)) {
                    return str;
                }
                if (cls2.isAssignableFrom(cls)) {
                    return str2;
                }
                if (cls.isInterface() || cls2.isInterface()) {
                    return "java/lang/Object";
                }
                do {
                    cls = cls.getSuperclass();
                } while (!cls.isAssignableFrom(cls2));
                return cls.getName().replace('.', '/');
            } catch (ClassNotFoundException e11) {
                throw new TypeNotPresentException(str2, e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new TypeNotPresentException(str, e12);
        }
    }

    public byte[] r() {
        int i11;
        int i12;
        int i13;
        int i14 = (this.f64206h * 2) + 24;
        int i15 = 0;
        for (m mVar = this.f64208j; mVar != null; mVar = (m) mVar.f64252b) {
            i15++;
            i14 += mVar.f();
        }
        int i16 = 0;
        for (s sVar = this.f64210l; sVar != null; sVar = (s) sVar.f64299b) {
            i16++;
            i14 += sVar.L();
        }
        d dVar = this.f64213o;
        if (dVar != null) {
            i14 += dVar.f64191b + 8;
            this.f64202d.D("InnerClasses");
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (this.f64214p != 0) {
            i11++;
            i14 += 10;
            this.f64202d.D("EnclosingMethod");
        }
        if ((this.f64203e & 4096) != 0 && (this.f64201c & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 49) {
            i11++;
            i14 += 6;
            this.f64202d.D("Synthetic");
        }
        if (this.f64216r != 0) {
            i11++;
            i14 += 8;
            this.f64202d.D(RequestParameters.SIGNATURE);
        }
        if (this.f64217s != 0) {
            i11++;
            i14 += 8;
            this.f64202d.D("SourceFile");
        }
        d dVar2 = this.f64218t;
        if (dVar2 != null) {
            i11++;
            i14 += dVar2.f64191b + 6;
            this.f64202d.D("SourceDebugExtension");
        }
        if ((this.f64203e & 131072) != 0) {
            i11++;
            i14 += 6;
            this.f64202d.D("Deprecated");
        }
        b bVar = this.f64219u;
        if (bVar != null) {
            i11++;
            i14 += bVar.f("RuntimeVisibleAnnotations");
        }
        b bVar2 = this.f64220v;
        if (bVar2 != null) {
            i11++;
            i14 += bVar2.f("RuntimeInvisibleAnnotations");
        }
        b bVar3 = this.f64221w;
        if (bVar3 != null) {
            i11++;
            i14 += bVar3.f("RuntimeVisibleTypeAnnotations");
        }
        b bVar4 = this.f64222x;
        if (bVar4 != null) {
            i11++;
            i14 += bVar4.f("RuntimeInvisibleTypeAnnotations");
        }
        if (this.f64202d.L() > 0) {
            i11++;
            i14 += this.f64202d.L();
        }
        u uVar = this.f64223y;
        if (uVar != null) {
            i11 += uVar.j();
            i14 += this.f64223y.i();
        }
        if (this.f64224z != 0) {
            i11++;
            i14 += 8;
            this.f64202d.D("NestHost");
        }
        d dVar3 = this.B;
        if (dVar3 != null) {
            i11++;
            i14 += dVar3.f64191b + 8;
            this.f64202d.D("NestMembers");
        }
        c cVar = this.C;
        if (cVar != null) {
            int c11 = i11 + cVar.c();
            i14 += this.C.a(this.f64202d);
            i11 = c11;
        }
        int Q = i14 + this.f64202d.Q();
        int P = this.f64202d.P();
        if (P > 65535) {
            throw new ClassTooLargeException(this.f64202d.O(), P);
        }
        d dVar4 = new d(Q);
        dVar4.i(-889275714).i(this.f64201c);
        this.f64202d.e0(dVar4);
        dVar4.k((~((this.f64201c & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 49 ? 4096 : 0)) & this.f64203e).k(this.f64204f).k(this.f64205g);
        dVar4.k(this.f64206h);
        for (int i17 = 0; i17 < this.f64206h; i17++) {
            dVar4.k(this.f64207i[i17]);
        }
        dVar4.k(i15);
        for (m mVar2 = this.f64208j; mVar2 != null; mVar2 = (m) mVar2.f64252b) {
            mVar2.g(dVar4);
        }
        dVar4.k(i16);
        boolean z10 = false;
        boolean z11 = false;
        for (s sVar2 = this.f64210l; sVar2 != null; sVar2 = (s) sVar2.f64299b) {
            z10 |= sVar2.O();
            z11 |= sVar2.N();
            sVar2.S(dVar4);
        }
        dVar4.k(i11);
        if (this.f64213o != null) {
            d k11 = dVar4.k(this.f64202d.D("InnerClasses")).i(this.f64213o.f64191b + 2).k(this.f64212n);
            d dVar5 = this.f64213o;
            k11.h(dVar5.f64190a, 0, dVar5.f64191b);
        }
        if (this.f64214p != 0) {
            dVar4.k(this.f64202d.D("EnclosingMethod")).i(4).k(this.f64214p).k(this.f64215q);
        }
        if ((this.f64203e & 4096) != 0 && (this.f64201c & Settings.DEFAULT_INITIAL_WINDOW_SIZE) < 49) {
            dVar4.k(this.f64202d.D("Synthetic")).i(0);
        }
        if (this.f64216r != 0) {
            i12 = 2;
            dVar4.k(this.f64202d.D(RequestParameters.SIGNATURE)).i(2).k(this.f64216r);
        } else {
            i12 = 2;
        }
        if (this.f64217s != 0) {
            dVar4.k(this.f64202d.D("SourceFile")).i(i12).k(this.f64217s);
        }
        d dVar6 = this.f64218t;
        if (dVar6 != null) {
            int i18 = dVar6.f64191b;
            i13 = 0;
            dVar4.k(this.f64202d.D("SourceDebugExtension")).i(i18).h(this.f64218t.f64190a, 0, i18);
        } else {
            i13 = 0;
        }
        if ((this.f64203e & 131072) != 0) {
            dVar4.k(this.f64202d.D("Deprecated")).i(i13);
        }
        b bVar5 = this.f64219u;
        if (bVar5 != null) {
            bVar5.h(this.f64202d.D("RuntimeVisibleAnnotations"), dVar4);
        }
        b bVar6 = this.f64220v;
        if (bVar6 != null) {
            bVar6.h(this.f64202d.D("RuntimeInvisibleAnnotations"), dVar4);
        }
        b bVar7 = this.f64221w;
        if (bVar7 != null) {
            bVar7.h(this.f64202d.D("RuntimeVisibleTypeAnnotations"), dVar4);
        }
        b bVar8 = this.f64222x;
        if (bVar8 != null) {
            bVar8.h(this.f64202d.D("RuntimeInvisibleTypeAnnotations"), dVar4);
        }
        this.f64202d.d0(dVar4);
        u uVar2 = this.f64223y;
        if (uVar2 != null) {
            uVar2.k(dVar4);
        }
        if (this.f64224z != 0) {
            dVar4.k(this.f64202d.D("NestHost")).i(2).k(this.f64224z);
        }
        if (this.B != null) {
            d k12 = dVar4.k(this.f64202d.D("NestMembers")).i(this.B.f64191b + 2).k(this.A);
            d dVar7 = this.B;
            k12.h(dVar7.f64190a, 0, dVar7.f64191b);
        }
        c cVar2 = this.C;
        if (cVar2 != null) {
            cVar2.e(this.f64202d, dVar4);
        }
        return z11 ? q(dVar4.f64190a, z10) : dVar4.f64190a;
    }
}
