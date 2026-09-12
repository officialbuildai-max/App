package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.util.p0;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: l, reason: collision with root package name */
    private static final byte[] f26426l = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final byte f26427a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f26428b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f26429c;

    /* renamed from: d, reason: collision with root package name */
    public final byte f26430d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f26431e;

    /* renamed from: f, reason: collision with root package name */
    public final byte f26432f;

    /* renamed from: g, reason: collision with root package name */
    public final int f26433g;

    /* renamed from: h, reason: collision with root package name */
    public final long f26434h;

    /* renamed from: i, reason: collision with root package name */
    public final int f26435i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f26436j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f26437k;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f26438a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f26439b;

        /* renamed from: c, reason: collision with root package name */
        private byte f26440c;

        /* renamed from: d, reason: collision with root package name */
        private int f26441d;

        /* renamed from: e, reason: collision with root package name */
        private long f26442e;

        /* renamed from: f, reason: collision with root package name */
        private int f26443f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f26444g = g.f26426l;

        /* renamed from: h, reason: collision with root package name */
        private byte[] f26445h = g.f26426l;

        public g i() {
            return new g(this);
        }

        public b j(byte[] bArr) {
            com.google.android.exoplayer2.util.a.e(bArr);
            this.f26444g = bArr;
            return this;
        }

        public b k(boolean z10) {
            this.f26439b = z10;
            return this;
        }

        public b l(boolean z10) {
            this.f26438a = z10;
            return this;
        }

        public b m(byte[] bArr) {
            com.google.android.exoplayer2.util.a.e(bArr);
            this.f26445h = bArr;
            return this;
        }

        public b n(byte b11) {
            this.f26440c = b11;
            return this;
        }

        public b o(int i11) {
            com.google.android.exoplayer2.util.a.a(i11 >= 0 && i11 <= 65535);
            this.f26441d = i11 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            return this;
        }

        public b p(int i11) {
            this.f26443f = i11;
            return this;
        }

        public b q(long j11) {
            this.f26442e = j11;
            return this;
        }
    }

    private g(b bVar) {
        this.f26427a = (byte) 2;
        this.f26428b = bVar.f26438a;
        this.f26429c = false;
        this.f26431e = bVar.f26439b;
        this.f26432f = bVar.f26440c;
        this.f26433g = bVar.f26441d;
        this.f26434h = bVar.f26442e;
        this.f26435i = bVar.f26443f;
        byte[] bArr = bVar.f26444g;
        this.f26436j = bArr;
        this.f26430d = (byte) (bArr.length / 4);
        this.f26437k = bVar.f26445h;
    }

    public static int b(int i11) {
        return com.google.common.math.d.g(i11 + 1, 65536);
    }

    public static int c(int i11) {
        return com.google.common.math.d.g(i11 - 1, 65536);
    }

    public static g d(com.google.android.exoplayer2.util.d0 d0Var) {
        byte[] bArr;
        if (d0Var.a() < 12) {
            return null;
        }
        int D = d0Var.D();
        byte b11 = (byte) (D >> 6);
        boolean z10 = ((D >> 5) & 1) == 1;
        byte b12 = (byte) (D & 15);
        if (b11 != 2) {
            return null;
        }
        int D2 = d0Var.D();
        boolean z11 = ((D2 >> 7) & 1) == 1;
        byte b13 = (byte) (D2 & 127);
        int J = d0Var.J();
        long F = d0Var.F();
        int n11 = d0Var.n();
        if (b12 > 0) {
            bArr = new byte[b12 * 4];
            for (int i11 = 0; i11 < b12; i11++) {
                d0Var.j(bArr, i11 * 4, 4);
            }
        } else {
            bArr = f26426l;
        }
        byte[] bArr2 = new byte[d0Var.a()];
        d0Var.j(bArr2, 0, d0Var.a());
        return new b().l(z10).k(z11).n(b13).o(J).q(F).p(n11).j(bArr).m(bArr2).i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f26432f == gVar.f26432f && this.f26433g == gVar.f26433g && this.f26431e == gVar.f26431e && this.f26434h == gVar.f26434h && this.f26435i == gVar.f26435i;
    }

    public int hashCode() {
        int i11 = (((((527 + this.f26432f) * 31) + this.f26433g) * 31) + (this.f26431e ? 1 : 0)) * 31;
        long j11 = this.f26434h;
        return ((i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f26435i;
    }

    public String toString() {
        return p0.C("RtpPacket(payloadType=%d, seq=%d, timestamp=%d, ssrc=%x, marker=%b)", Byte.valueOf(this.f26432f), Integer.valueOf(this.f26433g), Long.valueOf(this.f26434h), Integer.valueOf(this.f26435i), Boolean.valueOf(this.f26431e));
    }
}
