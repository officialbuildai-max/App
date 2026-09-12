package com.google.android.exoplayer2.video;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class e {

    /* renamed from: c, reason: collision with root package name */
    private boolean f27890c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f27891d;

    /* renamed from: f, reason: collision with root package name */
    private int f27893f;

    /* renamed from: a, reason: collision with root package name */
    private a f27888a = new a();

    /* renamed from: b, reason: collision with root package name */
    private a f27889b = new a();

    /* renamed from: e, reason: collision with root package name */
    private long f27892e = C.TIME_UNSET;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f27894a;

        /* renamed from: b, reason: collision with root package name */
        private long f27895b;

        /* renamed from: c, reason: collision with root package name */
        private long f27896c;

        /* renamed from: d, reason: collision with root package name */
        private long f27897d;

        /* renamed from: e, reason: collision with root package name */
        private long f27898e;

        /* renamed from: f, reason: collision with root package name */
        private long f27899f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean[] f27900g = new boolean[15];

        /* renamed from: h, reason: collision with root package name */
        private int f27901h;

        private static int c(long j11) {
            return (int) (j11 % 15);
        }

        public long a() {
            long j11 = this.f27898e;
            if (j11 == 0) {
                return 0L;
            }
            return this.f27899f / j11;
        }

        public long b() {
            return this.f27899f;
        }

        public boolean d() {
            long j11 = this.f27897d;
            if (j11 == 0) {
                return false;
            }
            return this.f27900g[c(j11 - 1)];
        }

        public boolean e() {
            return this.f27897d > 15 && this.f27901h == 0;
        }

        public void f(long j11) {
            long j12 = this.f27897d;
            if (j12 == 0) {
                this.f27894a = j11;
            } else if (j12 == 1) {
                long j13 = j11 - this.f27894a;
                this.f27895b = j13;
                this.f27899f = j13;
                this.f27898e = 1L;
            } else {
                long j14 = j11 - this.f27896c;
                int c11 = c(j12);
                if (Math.abs(j14 - this.f27895b) <= 1000000) {
                    this.f27898e++;
                    this.f27899f += j14;
                    boolean[] zArr = this.f27900g;
                    if (zArr[c11]) {
                        zArr[c11] = false;
                        this.f27901h--;
                    }
                } else {
                    boolean[] zArr2 = this.f27900g;
                    if (!zArr2[c11]) {
                        zArr2[c11] = true;
                        this.f27901h++;
                    }
                }
            }
            this.f27897d++;
            this.f27896c = j11;
        }

        public void g() {
            this.f27897d = 0L;
            this.f27898e = 0L;
            this.f27899f = 0L;
            this.f27901h = 0;
            Arrays.fill(this.f27900g, false);
        }
    }

    public long a() {
        return e() ? this.f27888a.a() : C.TIME_UNSET;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f27888a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f27893f;
    }

    public long d() {
        return e() ? this.f27888a.b() : C.TIME_UNSET;
    }

    public boolean e() {
        return this.f27888a.e();
    }

    public void f(long j11) {
        this.f27888a.f(j11);
        if (this.f27888a.e() && !this.f27891d) {
            this.f27890c = false;
        } else if (this.f27892e != C.TIME_UNSET) {
            if (!this.f27890c || this.f27889b.d()) {
                this.f27889b.g();
                this.f27889b.f(this.f27892e);
            }
            this.f27890c = true;
            this.f27889b.f(j11);
        }
        if (this.f27890c && this.f27889b.e()) {
            a aVar = this.f27888a;
            this.f27888a = this.f27889b;
            this.f27889b = aVar;
            this.f27890c = false;
            this.f27891d = false;
        }
        this.f27892e = j11;
        this.f27893f = this.f27888a.e() ? 0 : this.f27893f + 1;
    }

    public void g() {
        this.f27888a.g();
        this.f27889b.g();
        this.f27890c = false;
        this.f27892e = C.TIME_UNSET;
        this.f27893f = 0;
    }
}
