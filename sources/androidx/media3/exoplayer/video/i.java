package androidx.media3.exoplayer.video;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class i {

    /* renamed from: c, reason: collision with root package name */
    private boolean f13205c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13206d;

    /* renamed from: f, reason: collision with root package name */
    private int f13208f;

    /* renamed from: a, reason: collision with root package name */
    private a f13203a = new a();

    /* renamed from: b, reason: collision with root package name */
    private a f13204b = new a();

    /* renamed from: e, reason: collision with root package name */
    private long f13207e = C.TIME_UNSET;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f13209a;

        /* renamed from: b, reason: collision with root package name */
        private long f13210b;

        /* renamed from: c, reason: collision with root package name */
        private long f13211c;

        /* renamed from: d, reason: collision with root package name */
        private long f13212d;

        /* renamed from: e, reason: collision with root package name */
        private long f13213e;

        /* renamed from: f, reason: collision with root package name */
        private long f13214f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean[] f13215g = new boolean[15];

        /* renamed from: h, reason: collision with root package name */
        private int f13216h;

        private static int c(long j11) {
            return (int) (j11 % 15);
        }

        public long a() {
            long j11 = this.f13213e;
            if (j11 == 0) {
                return 0L;
            }
            return this.f13214f / j11;
        }

        public long b() {
            return this.f13214f;
        }

        public boolean d() {
            long j11 = this.f13212d;
            if (j11 == 0) {
                return false;
            }
            return this.f13215g[c(j11 - 1)];
        }

        public boolean e() {
            return this.f13212d > 15 && this.f13216h == 0;
        }

        public void f(long j11) {
            long j12 = this.f13212d;
            if (j12 == 0) {
                this.f13209a = j11;
            } else if (j12 == 1) {
                long j13 = j11 - this.f13209a;
                this.f13210b = j13;
                this.f13214f = j13;
                this.f13213e = 1L;
            } else {
                long j14 = j11 - this.f13211c;
                int c11 = c(j12);
                if (Math.abs(j14 - this.f13210b) <= 1000000) {
                    this.f13213e++;
                    this.f13214f += j14;
                    boolean[] zArr = this.f13215g;
                    if (zArr[c11]) {
                        zArr[c11] = false;
                        this.f13216h--;
                    }
                } else {
                    boolean[] zArr2 = this.f13215g;
                    if (!zArr2[c11]) {
                        zArr2[c11] = true;
                        this.f13216h++;
                    }
                }
            }
            this.f13212d++;
            this.f13211c = j11;
        }

        public void g() {
            this.f13212d = 0L;
            this.f13213e = 0L;
            this.f13214f = 0L;
            this.f13216h = 0;
            Arrays.fill(this.f13215g, false);
        }
    }

    public long a() {
        return e() ? this.f13203a.a() : C.TIME_UNSET;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f13203a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f13208f;
    }

    public long d() {
        return e() ? this.f13203a.b() : C.TIME_UNSET;
    }

    public boolean e() {
        return this.f13203a.e();
    }

    public void f(long j11) {
        this.f13203a.f(j11);
        if (this.f13203a.e() && !this.f13206d) {
            this.f13205c = false;
        } else if (this.f13207e != C.TIME_UNSET) {
            if (!this.f13205c || this.f13204b.d()) {
                this.f13204b.g();
                this.f13204b.f(this.f13207e);
            }
            this.f13205c = true;
            this.f13204b.f(j11);
        }
        if (this.f13205c && this.f13204b.e()) {
            a aVar = this.f13203a;
            this.f13203a = this.f13204b;
            this.f13204b = aVar;
            this.f13205c = false;
            this.f13206d = false;
        }
        this.f13207e = j11;
        this.f13208f = this.f13203a.e() ? 0 : this.f13208f + 1;
    }

    public void g() {
        this.f13203a.g();
        this.f13204b.g();
        this.f13205c = false;
        this.f13207e = C.TIME_UNSET;
        this.f13208f = 0;
    }
}
