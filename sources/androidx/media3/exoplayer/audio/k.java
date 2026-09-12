package androidx.media3.exoplayer.audio;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static final k f11279d = new b().d();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11280a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11281b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11282c;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f11283a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f11284b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f11285c;

        public k d() {
            if (this.f11283a || !(this.f11284b || this.f11285c)) {
                return new k(this);
            }
            throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
        }

        public b e(boolean z10) {
            this.f11283a = z10;
            return this;
        }

        public b f(boolean z10) {
            this.f11284b = z10;
            return this;
        }

        public b g(boolean z10) {
            this.f11285c = z10;
            return this;
        }
    }

    private k(b bVar) {
        this.f11280a = bVar.f11283a;
        this.f11281b = bVar.f11284b;
        this.f11282c = bVar.f11285c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f11280a == kVar.f11280a && this.f11281b == kVar.f11281b && this.f11282c == kVar.f11282c;
    }

    public int hashCode() {
        return ((this.f11280a ? 1 : 0) << 2) + ((this.f11281b ? 1 : 0) << 1) + (this.f11282c ? 1 : 0);
    }
}
