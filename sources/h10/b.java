package h10;

import com.vungle.ads.internal.protos.Sdk$SDKError;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class b extends a {

    /* renamed from: c, reason: collision with root package name */
    private final x f64178c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f64179d;

    /* renamed from: e, reason: collision with root package name */
    private final d f64180e;

    /* renamed from: f, reason: collision with root package name */
    private final int f64181f;

    /* renamed from: g, reason: collision with root package name */
    private int f64182g;

    /* renamed from: h, reason: collision with root package name */
    private final b f64183h;

    /* renamed from: i, reason: collision with root package name */
    private b f64184i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(x xVar, d dVar, b bVar) {
        this(xVar, true, dVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(x xVar, boolean z10, d dVar, b bVar) {
        super(458752);
        this.f64178c = xVar;
        this.f64179d = z10;
        this.f64180e = dVar;
        int i11 = dVar.f64191b;
        this.f64181f = i11 == 0 ? -1 : i11 - 2;
        this.f64183h = bVar;
        if (bVar != null) {
            bVar.f64184i = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(String str, b[] bVarArr, int i11) {
        int i12 = (i11 * 2) + 7;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += bVarArr[i13] == null ? 0 : r3.f(str) - 8;
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(int i11, b[] bVarArr, int i12, d dVar) {
        int i13 = (i12 * 2) + 1;
        for (int i14 = 0; i14 < i12; i14++) {
            i13 += bVarArr[i14] == null ? 0 : r4.f(null) - 8;
        }
        dVar.k(i11);
        dVar.i(i13);
        dVar.g(i12);
        for (int i15 = 0; i15 < i12; i15++) {
            int i16 = 0;
            b bVar = null;
            for (b bVar2 = bVarArr[i15]; bVar2 != null; bVar2 = bVar2.f64183h) {
                bVar2.d();
                i16++;
                bVar = bVar2;
            }
            dVar.k(i16);
            while (bVar != null) {
                d dVar2 = bVar.f64180e;
                dVar.h(dVar2.f64190a, 0, dVar2.f64191b);
                bVar = bVar.f64184i;
            }
        }
    }

    @Override // h10.a
    public void a(String str, Object obj) {
        this.f64182g++;
        if (this.f64179d) {
            this.f64180e.k(this.f64178c.D(str));
        }
        if (obj instanceof String) {
            this.f64180e.e(Sdk$SDKError.Reason.INVALID_INDEX_URL_VALUE, this.f64178c.D((String) obj));
            return;
        }
        if (obj instanceof Byte) {
            this.f64180e.e(66, this.f64178c.l(((Byte) obj).byteValue()).f64353a);
            return;
        }
        if (obj instanceof Boolean) {
            this.f64180e.e(90, this.f64178c.l(((Boolean) obj).booleanValue() ? 1 : 0).f64353a);
            return;
        }
        if (obj instanceof Character) {
            this.f64180e.e(67, this.f64178c.l(((Character) obj).charValue()).f64353a);
            return;
        }
        if (obj instanceof Short) {
            this.f64180e.e(83, this.f64178c.l(((Short) obj).shortValue()).f64353a);
            return;
        }
        if (obj instanceof y) {
            this.f64180e.e(99, this.f64178c.D(((y) obj).e()));
            return;
        }
        int i11 = 0;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            this.f64180e.e(91, bArr.length);
            int length = bArr.length;
            while (i11 < length) {
                this.f64180e.e(66, this.f64178c.l(bArr[i11]).f64353a);
                i11++;
            }
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            this.f64180e.e(91, zArr.length);
            int length2 = zArr.length;
            while (i11 < length2) {
                this.f64180e.e(90, this.f64178c.l(zArr[i11] ? 1 : 0).f64353a);
                i11++;
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            this.f64180e.e(91, sArr.length);
            int length3 = sArr.length;
            while (i11 < length3) {
                this.f64180e.e(83, this.f64178c.l(sArr[i11]).f64353a);
                i11++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            this.f64180e.e(91, cArr.length);
            int length4 = cArr.length;
            while (i11 < length4) {
                this.f64180e.e(67, this.f64178c.l(cArr[i11]).f64353a);
                i11++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            this.f64180e.e(91, iArr.length);
            int length5 = iArr.length;
            while (i11 < length5) {
                this.f64180e.e(73, this.f64178c.l(iArr[i11]).f64353a);
                i11++;
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            this.f64180e.e(91, jArr.length);
            int length6 = jArr.length;
            while (i11 < length6) {
                this.f64180e.e(74, this.f64178c.p(jArr[i11]).f64353a);
                i11++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            this.f64180e.e(91, fArr.length);
            int length7 = fArr.length;
            while (i11 < length7) {
                this.f64180e.e(70, this.f64178c.k(fArr[i11]).f64353a);
                i11++;
            }
            return;
        }
        if (!(obj instanceof double[])) {
            w d11 = this.f64178c.d(obj);
            this.f64180e.e(".s.IFJDCS".charAt(d11.f64354b), d11.f64353a);
            return;
        }
        double[] dArr = (double[]) obj;
        this.f64180e.e(91, dArr.length);
        int length8 = dArr.length;
        while (i11 < length8) {
            this.f64180e.e(68, this.f64178c.f(dArr[i11]).f64353a);
            i11++;
        }
    }

    @Override // h10.a
    public a b(String str, String str2) {
        this.f64182g++;
        if (this.f64179d) {
            this.f64180e.k(this.f64178c.D(str));
        }
        this.f64180e.e(64, this.f64178c.D(str2)).k(0);
        return new b(this.f64178c, this.f64180e, null);
    }

    @Override // h10.a
    public a c(String str) {
        this.f64182g++;
        if (this.f64179d) {
            this.f64180e.k(this.f64178c.D(str));
        }
        this.f64180e.e(91, 0);
        return new b(this.f64178c, false, this.f64180e, null);
    }

    @Override // h10.a
    public void d() {
        int i11 = this.f64181f;
        if (i11 != -1) {
            byte[] bArr = this.f64180e.f64190a;
            int i12 = this.f64182g;
            bArr[i11] = (byte) (i12 >>> 8);
            bArr[i11 + 1] = (byte) i12;
        }
    }

    @Override // h10.a
    public void e(String str, String str2, String str3) {
        this.f64182g++;
        if (this.f64179d) {
            this.f64180e.k(this.f64178c.D(str));
        }
        this.f64180e.e(101, this.f64178c.D(str2)).k(this.f64178c.D(str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(String str) {
        if (str != null) {
            this.f64178c.D(str);
        }
        int i11 = 8;
        for (b bVar = this; bVar != null; bVar = bVar.f64183h) {
            i11 += bVar.f64180e.f64191b;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i11, d dVar) {
        int i12 = 2;
        int i13 = 0;
        b bVar = null;
        for (b bVar2 = this; bVar2 != null; bVar2 = bVar2.f64183h) {
            bVar2.d();
            i12 += bVar2.f64180e.f64191b;
            i13++;
            bVar = bVar2;
        }
        dVar.k(i11);
        dVar.i(i12);
        dVar.k(i13);
        while (bVar != null) {
            d dVar2 = bVar.f64180e;
            dVar.h(dVar2.f64190a, 0, dVar2.f64191b);
            bVar = bVar.f64184i;
        }
    }
}
