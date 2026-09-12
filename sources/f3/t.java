package f3;

/* loaded from: classes2.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final int f62414a;

    /* renamed from: b, reason: collision with root package name */
    public final int f62415b;

    /* renamed from: c, reason: collision with root package name */
    public final long f62416c;

    /* renamed from: d, reason: collision with root package name */
    public final long f62417d;

    /* renamed from: e, reason: collision with root package name */
    public final long f62418e;

    /* renamed from: f, reason: collision with root package name */
    public final long f62419f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.media3.common.r f62420g;

    /* renamed from: h, reason: collision with root package name */
    public final int f62421h;

    /* renamed from: i, reason: collision with root package name */
    public final long[] f62422i;

    /* renamed from: j, reason: collision with root package name */
    public final long[] f62423j;

    /* renamed from: k, reason: collision with root package name */
    public final int f62424k;

    /* renamed from: l, reason: collision with root package name */
    private final u[] f62425l;

    public t(int i11, int i12, long j11, long j12, long j13, long j14, androidx.media3.common.r rVar, int i13, u[] uVarArr, int i14, long[] jArr, long[] jArr2) {
        this.f62414a = i11;
        this.f62415b = i12;
        this.f62416c = j11;
        this.f62417d = j12;
        this.f62418e = j13;
        this.f62419f = j14;
        this.f62420g = rVar;
        this.f62421h = i13;
        this.f62425l = uVarArr;
        this.f62424k = i14;
        this.f62422i = jArr;
        this.f62423j = jArr2;
    }

    public t a(androidx.media3.common.r rVar) {
        return new t(this.f62414a, this.f62415b, this.f62416c, this.f62417d, this.f62418e, this.f62419f, rVar, this.f62421h, this.f62425l, this.f62424k, this.f62422i, this.f62423j);
    }

    public u b(int i11) {
        u[] uVarArr = this.f62425l;
        if (uVarArr == null) {
            return null;
        }
        return uVarArr[i11];
    }
}
