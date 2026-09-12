package androidx.palette.graphics;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f14090e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f14091f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f14092g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f14093h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f14094i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f14095j;

    /* renamed from: a, reason: collision with root package name */
    final float[] f14096a;

    /* renamed from: b, reason: collision with root package name */
    final float[] f14097b;

    /* renamed from: c, reason: collision with root package name */
    final float[] f14098c = new float[3];

    /* renamed from: d, reason: collision with root package name */
    boolean f14099d = true;

    static {
        b bVar = new b();
        f14090e = bVar;
        m(bVar);
        p(bVar);
        b bVar2 = new b();
        f14091f = bVar2;
        o(bVar2);
        p(bVar2);
        b bVar3 = new b();
        f14092g = bVar3;
        l(bVar3);
        p(bVar3);
        b bVar4 = new b();
        f14093h = bVar4;
        m(bVar4);
        n(bVar4);
        b bVar5 = new b();
        f14094i = bVar5;
        o(bVar5);
        n(bVar5);
        b bVar6 = new b();
        f14095j = bVar6;
        l(bVar6);
        n(bVar6);
    }

    b() {
        float[] fArr = new float[3];
        this.f14096a = fArr;
        float[] fArr2 = new float[3];
        this.f14097b = fArr2;
        r(fArr);
        r(fArr2);
        q();
    }

    private static void l(b bVar) {
        float[] fArr = bVar.f14097b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    private static void m(b bVar) {
        float[] fArr = bVar.f14097b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void n(b bVar) {
        float[] fArr = bVar.f14096a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    private static void o(b bVar) {
        float[] fArr = bVar.f14097b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void p(b bVar) {
        float[] fArr = bVar.f14096a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private void q() {
        float[] fArr = this.f14098c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    private static void r(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    public float a() {
        return this.f14098c[1];
    }

    public float b() {
        return this.f14097b[2];
    }

    public float c() {
        return this.f14096a[2];
    }

    public float d() {
        return this.f14097b[0];
    }

    public float e() {
        return this.f14096a[0];
    }

    public float f() {
        return this.f14098c[2];
    }

    public float g() {
        return this.f14098c[0];
    }

    public float h() {
        return this.f14097b[1];
    }

    public float i() {
        return this.f14096a[1];
    }

    public boolean j() {
        return this.f14099d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        int length = this.f14098c.length;
        float f11 = 0.0f;
        for (int i11 = 0; i11 < length; i11++) {
            float f12 = this.f14098c[i11];
            if (f12 > 0.0f) {
                f11 += f12;
            }
        }
        if (f11 != 0.0f) {
            int length2 = this.f14098c.length;
            for (int i12 = 0; i12 < length2; i12++) {
                float[] fArr = this.f14098c;
                float f13 = fArr[i12];
                if (f13 > 0.0f) {
                    fArr[i12] = f13 / f11;
                }
            }
        }
    }
}
