package ou;

import com.transsion.tinker.lib.custom.api.DownloadPolicy;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f72274a;

    /* renamed from: b, reason: collision with root package name */
    private final String f72275b;

    /* renamed from: c, reason: collision with root package name */
    private final String f72276c;

    /* renamed from: d, reason: collision with root package name */
    private final int f72277d;

    /* renamed from: e, reason: collision with root package name */
    private final int f72278e;

    /* renamed from: f, reason: collision with root package name */
    private final String f72279f;

    /* renamed from: g, reason: collision with root package name */
    private final String f72280g;

    /* renamed from: h, reason: collision with root package name */
    private final String f72281h;

    /* renamed from: i, reason: collision with root package name */
    private final long f72282i;

    /* renamed from: j, reason: collision with root package name */
    private final String f72283j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f72284k;

    /* renamed from: l, reason: collision with root package name */
    private final long f72285l;

    /* renamed from: m, reason: collision with root package name */
    private final DownloadPolicy f72286m;

    /* renamed from: n, reason: collision with root package name */
    private final int f72287n;

    /* renamed from: o, reason: collision with root package name */
    private final long f72288o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f72289p;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f72290a;

        /* renamed from: b, reason: collision with root package name */
        private final String f72291b;

        /* renamed from: c, reason: collision with root package name */
        private String f72292c;

        /* renamed from: d, reason: collision with root package name */
        private int f72293d;

        /* renamed from: e, reason: collision with root package name */
        private int f72294e;

        /* renamed from: f, reason: collision with root package name */
        private String f72295f;

        /* renamed from: g, reason: collision with root package name */
        private String f72296g;

        /* renamed from: h, reason: collision with root package name */
        private String f72297h;

        /* renamed from: i, reason: collision with root package name */
        private long f72298i;

        /* renamed from: j, reason: collision with root package name */
        private String f72299j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f72300k = false;

        /* renamed from: l, reason: collision with root package name */
        private long f72301l = 0;

        /* renamed from: m, reason: collision with root package name */
        private DownloadPolicy f72302m = DownloadPolicy.ANY;

        /* renamed from: n, reason: collision with root package name */
        private int f72303n = 0;

        /* renamed from: o, reason: collision with root package name */
        private long f72304o = 0;

        /* renamed from: p, reason: collision with root package name */
        private boolean f72305p = true;

        public b(String str, String str2) {
            if (str == null || str.trim().isEmpty()) {
                throw new IllegalArgumentException("PatchInfo.Builder: url must not be empty");
            }
            if (str2 == null || str2.trim().isEmpty()) {
                throw new IllegalArgumentException("PatchInfo.Builder: patchId must not be empty");
            }
            this.f72290a = str;
            this.f72291b = str2;
        }

        public d q() {
            return new d(this);
        }

        public b r(DownloadPolicy downloadPolicy) {
            this.f72302m = downloadPolicy;
            return this;
        }

        public b s(long j11) {
            this.f72301l = j11;
            return this;
        }

        public b t(boolean z10) {
            this.f72300k = z10;
            return this;
        }

        public b u(String str) {
            this.f72296g = str;
            return this;
        }

        public b v(int i11) {
            this.f72303n = Math.max(0, i11);
            return this;
        }

        public b w(long j11) {
            this.f72304o = Math.max(0L, j11);
            return this;
        }

        public b x(long j11) {
            this.f72298i = j11;
            return this;
        }

        public b y(String str) {
            this.f72295f = str;
            return this;
        }
    }

    private d(b bVar) {
        this.f72274a = bVar.f72290a;
        this.f72275b = bVar.f72291b;
        this.f72276c = bVar.f72292c;
        this.f72277d = bVar.f72293d;
        this.f72278e = bVar.f72294e;
        this.f72279f = bVar.f72295f;
        this.f72280g = bVar.f72296g;
        this.f72281h = bVar.f72297h;
        this.f72282i = bVar.f72298i;
        this.f72283j = bVar.f72299j;
        this.f72284k = bVar.f72300k;
        this.f72285l = bVar.f72301l;
        this.f72286m = bVar.f72302m != null ? bVar.f72302m : DownloadPolicy.ANY;
        this.f72287n = bVar.f72303n;
        this.f72288o = bVar.f72304o;
        this.f72289p = bVar.f72305p;
    }

    public String a() {
        return this.f72276c;
    }

    public DownloadPolicy b() {
        return this.f72286m;
    }

    public String c() {
        return this.f72274a;
    }

    public long d() {
        return this.f72285l;
    }

    public String e() {
        return this.f72280g;
    }

    public String f() {
        return this.f72275b;
    }

    public int g() {
        return this.f72287n;
    }

    public long h() {
        return this.f72288o;
    }

    public long i() {
        return this.f72282i;
    }

    public String j() {
        return this.f72279f;
    }

    public int k() {
        return this.f72278e;
    }

    public int l() {
        return this.f72277d;
    }

    public boolean m() {
        return this.f72289p;
    }

    public boolean n() {
        return this.f72284k;
    }
}
