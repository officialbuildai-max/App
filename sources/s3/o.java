package s3;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class o implements m {

    /* renamed from: m, reason: collision with root package name */
    private static final float[] f75203m = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private final n0 f75204a;

    /* renamed from: b, reason: collision with root package name */
    private final String f75205b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75206c;

    /* renamed from: f, reason: collision with root package name */
    private final w f75209f;

    /* renamed from: g, reason: collision with root package name */
    private b f75210g;

    /* renamed from: h, reason: collision with root package name */
    private long f75211h;

    /* renamed from: i, reason: collision with root package name */
    private String f75212i;

    /* renamed from: j, reason: collision with root package name */
    private s0 f75213j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f75214k;

    /* renamed from: d, reason: collision with root package name */
    private final boolean[] f75207d = new boolean[4];

    /* renamed from: e, reason: collision with root package name */
    private final a f75208e = new a(128);

    /* renamed from: l, reason: collision with root package name */
    private long f75215l = C.TIME_UNSET;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f75216f = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        private boolean f75217a;

        /* renamed from: b, reason: collision with root package name */
        private int f75218b;

        /* renamed from: c, reason: collision with root package name */
        public int f75219c;

        /* renamed from: d, reason: collision with root package name */
        public int f75220d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f75221e;

        public a(int i11) {
            this.f75221e = new byte[i11];
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f75217a) {
                int i13 = i12 - i11;
                byte[] bArr2 = this.f75221e;
                int length = bArr2.length;
                int i14 = this.f75219c;
                if (length < i14 + i13) {
                    this.f75221e = Arrays.copyOf(bArr2, (i14 + i13) * 2);
                }
                System.arraycopy(bArr, i11, this.f75221e, this.f75219c, i13);
                this.f75219c += i13;
            }
        }

        public boolean b(int i11, int i12) {
            int i13 = this.f75218b;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            if (i13 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i11 == 179 || i11 == 181) {
                                this.f75219c -= i12;
                                this.f75217a = false;
                                return true;
                            }
                        } else if ((i11 & 240) != 32) {
                            androidx.media3.common.util.u.h("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.f75220d = this.f75219c;
                            this.f75218b = 4;
                        }
                    } else if (i11 > 31) {
                        androidx.media3.common.util.u.h("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.f75218b = 3;
                    }
                } else if (i11 != 181) {
                    androidx.media3.common.util.u.h("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.f75218b = 2;
                }
            } else if (i11 == 176) {
                this.f75218b = 1;
                this.f75217a = true;
            }
            byte[] bArr = f75216f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f75217a = false;
            this.f75219c = 0;
            this.f75218b = 0;
        }
    }

    /* loaded from: classes2.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final s0 f75222a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f75223b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f75224c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f75225d;

        /* renamed from: e, reason: collision with root package name */
        private int f75226e;

        /* renamed from: f, reason: collision with root package name */
        private int f75227f;

        /* renamed from: g, reason: collision with root package name */
        private long f75228g;

        /* renamed from: h, reason: collision with root package name */
        private long f75229h;

        public b(s0 s0Var) {
            this.f75222a = s0Var;
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f75224c) {
                int i13 = this.f75227f;
                int i14 = (i11 + 1) - i13;
                if (i14 >= i12) {
                    this.f75227f = i13 + (i12 - i11);
                } else {
                    this.f75225d = ((bArr[i14] & 192) >> 6) == 0;
                    this.f75224c = false;
                }
            }
        }

        public void b(long j11, int i11, boolean z10) {
            androidx.media3.common.util.a.g(this.f75229h != C.TIME_UNSET);
            if (this.f75226e == 182 && z10 && this.f75223b) {
                this.f75222a.d(this.f75229h, this.f75225d ? 1 : 0, (int) (j11 - this.f75228g), i11, null);
            }
            if (this.f75226e != 179) {
                this.f75228g = j11;
            }
        }

        public void c(int i11, long j11) {
            this.f75226e = i11;
            this.f75225d = false;
            this.f75223b = i11 == 182 || i11 == 179;
            this.f75224c = i11 == 182;
            this.f75227f = 0;
            this.f75229h = j11;
        }

        public void d() {
            this.f75223b = false;
            this.f75224c = false;
            this.f75225d = false;
            this.f75226e = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n0 n0Var, String str) {
        this.f75204a = n0Var;
        this.f75205b = str;
        if (n0Var != null) {
            this.f75209f = new w(178, 128);
            this.f75206c = new androidx.media3.common.util.j0();
        } else {
            this.f75209f = null;
            this.f75206c = null;
        }
    }

    private static androidx.media3.common.r e(a aVar, int i11, String str, String str2) {
        byte[] copyOf = Arrays.copyOf(aVar.f75221e, aVar.f75219c);
        androidx.media3.common.util.i0 i0Var = new androidx.media3.common.util.i0(copyOf);
        i0Var.s(i11);
        i0Var.s(4);
        i0Var.q();
        i0Var.r(8);
        if (i0Var.g()) {
            i0Var.r(4);
            i0Var.r(3);
        }
        int h11 = i0Var.h(4);
        float f11 = 1.0f;
        if (h11 == 15) {
            int h12 = i0Var.h(8);
            int h13 = i0Var.h(8);
            if (h13 == 0) {
                androidx.media3.common.util.u.h("H263Reader", "Invalid aspect ratio");
            } else {
                f11 = h12 / h13;
            }
        } else {
            float[] fArr = f75203m;
            if (h11 < fArr.length) {
                f11 = fArr[h11];
            } else {
                androidx.media3.common.util.u.h("H263Reader", "Invalid aspect ratio");
            }
        }
        if (i0Var.g()) {
            i0Var.r(2);
            i0Var.r(1);
            if (i0Var.g()) {
                i0Var.r(15);
                i0Var.q();
                i0Var.r(15);
                i0Var.q();
                i0Var.r(15);
                i0Var.q();
                i0Var.r(3);
                i0Var.r(11);
                i0Var.q();
                i0Var.r(15);
                i0Var.q();
            }
        }
        if (i0Var.h(2) != 0) {
            androidx.media3.common.util.u.h("H263Reader", "Unhandled video object layer shape");
        }
        i0Var.q();
        int h14 = i0Var.h(16);
        i0Var.q();
        if (i0Var.g()) {
            if (h14 == 0) {
                androidx.media3.common.util.u.h("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i12 = 0;
                for (int i13 = h14 - 1; i13 > 0; i13 >>= 1) {
                    i12++;
                }
                i0Var.r(i12);
            }
        }
        i0Var.q();
        int h15 = i0Var.h(13);
        i0Var.q();
        int h16 = i0Var.h(13);
        i0Var.q();
        i0Var.q();
        return new r.b().f0(str).U(str2).u0(MimeTypes.VIDEO_MP4V).B0(h15).d0(h16).q0(f11).g0(Collections.singletonList(copyOf)).N();
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        androidx.media3.common.util.a.i(this.f75210g);
        androidx.media3.common.util.a.i(this.f75213j);
        int f11 = j0Var.f();
        int g11 = j0Var.g();
        byte[] e11 = j0Var.e();
        this.f75211h += j0Var.a();
        this.f75213j.b(j0Var, j0Var.a());
        while (true) {
            int e12 = androidx.media3.container.g.e(e11, f11, g11, this.f75207d);
            if (e12 == g11) {
                break;
            }
            int i11 = e12 + 3;
            int i12 = j0Var.e()[i11] & 255;
            int i13 = e12 - f11;
            int i14 = 0;
            if (!this.f75214k) {
                if (i13 > 0) {
                    this.f75208e.a(e11, f11, e12);
                }
                if (this.f75208e.b(i12, i13 < 0 ? -i13 : 0)) {
                    s0 s0Var = this.f75213j;
                    a aVar = this.f75208e;
                    s0Var.c(e(aVar, aVar.f75220d, (String) androidx.media3.common.util.a.e(this.f75212i), this.f75205b));
                    this.f75214k = true;
                }
            }
            this.f75210g.a(e11, f11, e12);
            w wVar = this.f75209f;
            if (wVar != null) {
                if (i13 > 0) {
                    wVar.a(e11, f11, e12);
                } else {
                    i14 = -i13;
                }
                if (this.f75209f.b(i14)) {
                    w wVar2 = this.f75209f;
                    ((androidx.media3.common.util.j0) a1.i(this.f75206c)).U(this.f75209f.f75385d, androidx.media3.container.g.L(wVar2.f75385d, wVar2.f75386e));
                    ((n0) a1.i(this.f75204a)).a(this.f75215l, this.f75206c);
                }
                if (i12 == 178 && j0Var.e()[e12 + 2] == 1) {
                    this.f75209f.e(i12);
                }
            }
            int i15 = g11 - e12;
            this.f75210g.b(this.f75211h - i15, i15, this.f75214k);
            this.f75210g.c(i12, this.f75215l);
            f11 = i11;
        }
        if (!this.f75214k) {
            this.f75208e.a(e11, f11, g11);
        }
        this.f75210g.a(e11, f11, g11);
        w wVar3 = this.f75209f;
        if (wVar3 != null) {
            wVar3.a(e11, f11, g11);
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75215l = j11;
    }

    @Override // s3.m
    public void c(boolean z10) {
        androidx.media3.common.util.a.i(this.f75210g);
        if (z10) {
            this.f75210g.b(this.f75211h, 0, this.f75214k);
            this.f75210g.d();
        }
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75212i = dVar.b();
        s0 track = tVar.track(dVar.c(), 2);
        this.f75213j = track;
        this.f75210g = new b(track);
        n0 n0Var = this.f75204a;
        if (n0Var != null) {
            n0Var.b(tVar, dVar);
        }
    }

    @Override // s3.m
    public void seek() {
        androidx.media3.container.g.c(this.f75207d);
        this.f75208e.c();
        b bVar = this.f75210g;
        if (bVar != null) {
            bVar.d();
        }
        w wVar = this.f75209f;
        if (wVar != null) {
            wVar.d();
        }
        this.f75211h = 0L;
        this.f75215l = C.TIME_UNSET;
    }
}
