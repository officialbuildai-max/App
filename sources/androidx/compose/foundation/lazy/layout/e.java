package androidx.compose.foundation.lazy.layout;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final int f3112b = androidx.compose.runtime.collection.b.f3755d;

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f3113a = new androidx.compose.runtime.collection.b(new a[16], 0);

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f3114a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3115b;

        public a(int i11, int i12) {
            this.f3114a = i11;
            this.f3115b = i12;
            if (i11 < 0) {
                throw new IllegalArgumentException("negative start index");
            }
            if (i12 < i11) {
                throw new IllegalArgumentException("end index greater than start");
            }
        }

        public final int a() {
            return this.f3115b;
        }

        public final int b() {
            return this.f3114a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3114a == aVar.f3114a && this.f3115b == aVar.f3115b;
        }

        public int hashCode() {
            return (this.f3114a * 31) + this.f3115b;
        }

        public String toString() {
            return "Interval(start=" + this.f3114a + ", end=" + this.f3115b + ')';
        }
    }

    public final a a(int i11, int i12) {
        a aVar = new a(i11, i12);
        this.f3113a.b(aVar);
        return aVar;
    }

    public final int b() {
        int a11 = ((a) this.f3113a.l()).a();
        androidx.compose.runtime.collection.b bVar = this.f3113a;
        int n11 = bVar.n();
        if (n11 > 0) {
            Object[] m11 = bVar.m();
            int i11 = 0;
            do {
                a aVar = (a) m11[i11];
                if (aVar.a() > a11) {
                    a11 = aVar.a();
                }
                i11++;
            } while (i11 < n11);
        }
        return a11;
    }

    public final int c() {
        int b11 = ((a) this.f3113a.l()).b();
        androidx.compose.runtime.collection.b bVar = this.f3113a;
        int n11 = bVar.n();
        if (n11 > 0) {
            Object[] m11 = bVar.m();
            int i11 = 0;
            do {
                a aVar = (a) m11[i11];
                if (aVar.b() < b11) {
                    b11 = aVar.b();
                }
                i11++;
            } while (i11 < n11);
        }
        if (b11 >= 0) {
            return b11;
        }
        throw new IllegalArgumentException("negative minIndex");
    }

    public final boolean d() {
        return this.f3113a.q();
    }

    public final void e(a aVar) {
        this.f3113a.t(aVar);
    }
}
