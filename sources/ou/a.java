package ou;

import android.support.v4.media.session.PlaybackStateCompat;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: s, reason: collision with root package name */
    private static volatile a f72237s;

    /* renamed from: a, reason: collision with root package name */
    private final int f72238a;

    /* renamed from: b, reason: collision with root package name */
    private final int f72239b;

    /* renamed from: c, reason: collision with root package name */
    private final long f72240c;

    /* renamed from: d, reason: collision with root package name */
    private final int f72241d;

    /* renamed from: e, reason: collision with root package name */
    private final long f72242e;

    /* renamed from: f, reason: collision with root package name */
    private final int f72243f;

    /* renamed from: g, reason: collision with root package name */
    private final long f72244g;

    /* renamed from: h, reason: collision with root package name */
    private final long f72245h;

    /* renamed from: i, reason: collision with root package name */
    private final String f72246i;

    /* renamed from: j, reason: collision with root package name */
    private final long f72247j;

    /* renamed from: k, reason: collision with root package name */
    private final String f72248k;

    /* renamed from: l, reason: collision with root package name */
    private final long f72249l;

    /* renamed from: m, reason: collision with root package name */
    private final long f72250m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f72251n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f72252o;

    /* renamed from: p, reason: collision with root package name */
    private final String f72253p;

    /* renamed from: q, reason: collision with root package name */
    private final String f72254q;

    /* renamed from: r, reason: collision with root package name */
    private final String f72255r;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f72256a = 10000;

        /* renamed from: b, reason: collision with root package name */
        private int f72257b = 10000;

        /* renamed from: c, reason: collision with root package name */
        private long f72258c = 30000;

        /* renamed from: d, reason: collision with root package name */
        private int f72259d = 2;

        /* renamed from: e, reason: collision with root package name */
        private long f72260e = 1000;

        /* renamed from: f, reason: collision with root package name */
        private int f72261f = 1;

        /* renamed from: g, reason: collision with root package name */
        private long f72262g = 600000;

        /* renamed from: h, reason: collision with root package name */
        private long f72263h = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;

        /* renamed from: i, reason: collision with root package name */
        private String f72264i = "tinker_custom.log";

        /* renamed from: j, reason: collision with root package name */
        private long f72265j = 52428800;

        /* renamed from: k, reason: collision with root package name */
        private String f72266k = "tinker_patch";

        /* renamed from: l, reason: collision with root package name */
        private long f72267l = 10000;

        /* renamed from: m, reason: collision with root package name */
        private long f72268m = 30000;

        /* renamed from: n, reason: collision with root package name */
        private boolean f72269n = true;

        /* renamed from: o, reason: collision with root package name */
        private boolean f72270o = true;

        /* renamed from: p, reason: collision with root package name */
        private String f72271p = "wefeed-mobile-bff";

        /* renamed from: q, reason: collision with root package name */
        private String f72272q = "both";

        /* renamed from: r, reason: collision with root package name */
        private String f72273r = "";

        public static b z(a aVar) {
            b bVar = new b();
            bVar.f72256a = aVar.f72238a;
            bVar.f72257b = aVar.f72239b;
            bVar.f72258c = aVar.f72240c;
            bVar.f72259d = aVar.f72241d;
            bVar.f72260e = aVar.f72242e;
            bVar.f72261f = aVar.f72243f;
            bVar.f72262g = aVar.f72244g;
            bVar.f72263h = aVar.f72245h;
            bVar.f72264i = aVar.f72246i;
            bVar.f72265j = aVar.f72247j;
            bVar.f72266k = aVar.f72248k;
            bVar.f72267l = aVar.f72249l;
            bVar.f72268m = aVar.f72250m;
            bVar.f72269n = aVar.f72251n;
            bVar.f72270o = aVar.f72252o;
            bVar.f72271p = aVar.f72253p;
            bVar.f72272q = aVar.f72254q;
            bVar.f72273r = aVar.f72255r;
            return bVar;
        }

        public b A(int i11) {
            this.f72256a = Math.max(1000, i11);
            return this;
        }

        public b B(int i11) {
            this.f72257b = Math.max(1000, i11);
            return this;
        }

        public b C(boolean z10) {
            this.f72270o = z10;
            return this;
        }

        public b D(long j11) {
            this.f72263h = Math.max(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, j11);
            return this;
        }

        public b E(String str) {
            if (str != null && !str.trim().isEmpty()) {
                this.f72264i = str.trim();
            }
            return this;
        }

        public b F(long j11) {
            this.f72265j = Math.max(0L, j11);
            return this;
        }

        public b G(long j11) {
            this.f72258c = Math.max(1000L, j11);
            return this;
        }

        public b H(String str) {
            if (str != null && !str.trim().isEmpty()) {
                this.f72272q = str.trim();
            }
            return this;
        }

        public b I(String str) {
            if (str != null && !str.trim().isEmpty()) {
                this.f72266k = str.trim();
            }
            return this;
        }

        public b J(long j11) {
            this.f72267l = Math.max(1000L, j11);
            return this;
        }

        public b K(long j11) {
            this.f72268m = Math.max(10000L, j11);
            return this;
        }

        public a s() {
            return new a(this);
        }

        public b t(String str) {
            if (str != null) {
                this.f72273r = str.trim();
            }
            return this;
        }

        public b u(int i11) {
            this.f72261f = Math.max(1, i11);
            return this;
        }

        public b v(long j11) {
            this.f72262g = Math.max(1000L, j11);
            return this;
        }

        public b w(int i11) {
            this.f72259d = Math.max(0, i11);
            return this;
        }

        public b x(long j11) {
            this.f72260e = Math.max(0L, j11);
            return this;
        }

        public b y(boolean z10) {
            this.f72269n = z10;
            return this;
        }
    }

    private a(b bVar) {
        this.f72238a = bVar.f72256a;
        this.f72239b = bVar.f72257b;
        this.f72240c = bVar.f72258c;
        this.f72241d = bVar.f72259d;
        this.f72242e = bVar.f72260e;
        this.f72243f = bVar.f72261f;
        this.f72244g = bVar.f72262g;
        this.f72245h = bVar.f72263h;
        this.f72246i = bVar.f72264i;
        this.f72247j = bVar.f72265j;
        this.f72248k = bVar.f72266k;
        this.f72249l = bVar.f72267l;
        this.f72250m = bVar.f72268m;
        this.f72251n = bVar.f72269n;
        this.f72252o = bVar.f72270o;
        this.f72253p = bVar.f72271p;
        this.f72254q = bVar.f72272q;
        this.f72255r = bVar.f72273r;
    }

    public static void H(a aVar) {
        if (aVar != null) {
            f72237s = aVar;
        }
    }

    public static a s() {
        a aVar = f72237s;
        if (aVar == null) {
            synchronized (a.class) {
                try {
                    aVar = f72237s;
                    if (aVar == null) {
                        aVar = new b().s();
                        f72237s = aVar;
                    }
                } finally {
                }
            }
        }
        return aVar;
    }

    public int A() {
        return this.f72239b;
    }

    public long B() {
        return this.f72245h;
    }

    public String C() {
        return this.f72246i;
    }

    public long D() {
        return this.f72247j;
    }

    public long E() {
        return this.f72240c;
    }

    public String F() {
        return this.f72254q;
    }

    public String G() {
        return this.f72248k;
    }

    public boolean I() {
        return this.f72251n;
    }

    public boolean J() {
        return this.f72252o;
    }

    public String t() {
        return this.f72253p;
    }

    public String u() {
        return this.f72255r;
    }

    public int v() {
        return this.f72243f;
    }

    public long w() {
        return this.f72244g;
    }

    public int x() {
        return this.f72241d;
    }

    public long y() {
        return this.f72242e;
    }

    public int z() {
        return this.f72238a;
    }
}
