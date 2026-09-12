package h10;

/* loaded from: classes7.dex */
abstract class w {

    /* renamed from: a, reason: collision with root package name */
    final int f64353a;

    /* renamed from: b, reason: collision with root package name */
    final int f64354b;

    /* renamed from: c, reason: collision with root package name */
    final String f64355c;

    /* renamed from: d, reason: collision with root package name */
    final String f64356d;

    /* renamed from: e, reason: collision with root package name */
    final String f64357e;

    /* renamed from: f, reason: collision with root package name */
    final long f64358f;

    /* renamed from: g, reason: collision with root package name */
    int f64359g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(int i11, int i12, String str, String str2, String str3, long j11) {
        this.f64353a = i11;
        this.f64354b = i12;
        this.f64355c = str;
        this.f64356d = str2;
        this.f64357e = str3;
        this.f64358f = j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        if (this.f64359g == 0) {
            this.f64359g = y.c(this.f64357e);
        }
        return this.f64359g;
    }
}
