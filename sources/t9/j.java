package t9;

/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final Object f76237a;

    /* renamed from: b, reason: collision with root package name */
    public final int f76238b;

    /* renamed from: c, reason: collision with root package name */
    public final int f76239c;

    /* renamed from: d, reason: collision with root package name */
    public final long f76240d;

    /* renamed from: e, reason: collision with root package name */
    public final int f76241e;

    public j(Object obj) {
        this(obj, -1L);
    }

    public j(Object obj, int i11, int i12, long j11) {
        this(obj, i11, i12, j11, -1);
    }

    private j(Object obj, int i11, int i12, long j11, int i13) {
        this.f76237a = obj;
        this.f76238b = i11;
        this.f76239c = i12;
        this.f76240d = j11;
        this.f76241e = i13;
    }

    public j(Object obj, long j11) {
        this(obj, -1, -1, j11, -1);
    }

    public j(Object obj, long j11, int i11) {
        this(obj, -1, -1, j11, i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(j jVar) {
        this.f76237a = jVar.f76237a;
        this.f76238b = jVar.f76238b;
        this.f76239c = jVar.f76239c;
        this.f76240d = jVar.f76240d;
        this.f76241e = jVar.f76241e;
    }

    public j a(Object obj) {
        return this.f76237a.equals(obj) ? this : new j(obj, this.f76238b, this.f76239c, this.f76240d, this.f76241e);
    }

    public boolean b() {
        return this.f76238b != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f76237a.equals(jVar.f76237a) && this.f76238b == jVar.f76238b && this.f76239c == jVar.f76239c && this.f76240d == jVar.f76240d && this.f76241e == jVar.f76241e;
    }

    public int hashCode() {
        return ((((((((527 + this.f76237a.hashCode()) * 31) + this.f76238b) * 31) + this.f76239c) * 31) + ((int) this.f76240d)) * 31) + this.f76241e;
    }
}
