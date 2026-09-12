package kd;

import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f66884h = new a(4201, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final a f66885i = new a(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final a f66886j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f66887k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f66888l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f66889m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f66890n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f66891o;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f66892a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f66893b;

    /* renamed from: c, reason: collision with root package name */
    private final b f66894c;

    /* renamed from: d, reason: collision with root package name */
    private final b f66895d;

    /* renamed from: e, reason: collision with root package name */
    private final int f66896e;

    /* renamed from: f, reason: collision with root package name */
    private final int f66897f;

    /* renamed from: g, reason: collision with root package name */
    private final int f66898g;

    static {
        a aVar = new a(67, 64, 1);
        f66886j = aVar;
        f66887k = new a(19, 16, 1);
        f66888l = new a(285, 256, 0);
        a aVar2 = new a(Sdk$SDKError.Reason.MRAID_ERROR_VALUE, 256, 1);
        f66889m = aVar2;
        f66890n = aVar2;
        f66891o = aVar;
    }

    public a(int i11, int i12, int i13) {
        this.f66897f = i11;
        this.f66896e = i12;
        this.f66898g = i13;
        this.f66892a = new int[i12];
        this.f66893b = new int[i12];
        int i14 = 1;
        for (int i15 = 0; i15 < i12; i15++) {
            this.f66892a[i15] = i14;
            i14 *= 2;
            if (i14 >= i12) {
                i14 = (i14 ^ i11) & (i12 - 1);
            }
        }
        for (int i16 = 0; i16 < i12 - 1; i16++) {
            this.f66893b[this.f66892a[i16]] = i16;
        }
        this.f66894c = new b(this, new int[]{0});
        this.f66895d = new b(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i11, int i12) {
        return i11 ^ i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException();
        }
        if (i12 == 0) {
            return this.f66894c;
        }
        int[] iArr = new int[i11 + 1];
        iArr[0] = i12;
        return new b(this, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i11) {
        return this.f66892a[i11];
    }

    public int d() {
        return this.f66898g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e() {
        return this.f66895d;
    }

    public int f() {
        return this.f66896e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g() {
        return this.f66894c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i11) {
        if (i11 != 0) {
            return this.f66892a[(this.f66896e - this.f66893b[i11]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i11) {
        if (i11 != 0) {
            return this.f66893b[i11];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(int i11, int i12) {
        if (i11 == 0 || i12 == 0) {
            return 0;
        }
        int[] iArr = this.f66892a;
        int[] iArr2 = this.f66893b;
        return iArr[(iArr2[i11] + iArr2[i12]) % (this.f66896e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f66897f) + ',' + this.f66896e + ')';
    }
}
