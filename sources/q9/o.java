package q9;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import q9.i0;

/* loaded from: classes4.dex */
public final class o implements m {

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f73489l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private final k0 f73490a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73491b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean[] f73492c;

    /* renamed from: d, reason: collision with root package name */
    private final a f73493d;

    /* renamed from: e, reason: collision with root package name */
    private final u f73494e;

    /* renamed from: f, reason: collision with root package name */
    private b f73495f;

    /* renamed from: g, reason: collision with root package name */
    private long f73496g;

    /* renamed from: h, reason: collision with root package name */
    private String f73497h;

    /* renamed from: i, reason: collision with root package name */
    private g9.e0 f73498i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f73499j;

    /* renamed from: k, reason: collision with root package name */
    private long f73500k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f73501f = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        private boolean f73502a;

        /* renamed from: b, reason: collision with root package name */
        private int f73503b;

        /* renamed from: c, reason: collision with root package name */
        public int f73504c;

        /* renamed from: d, reason: collision with root package name */
        public int f73505d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f73506e;

        public a(int i11) {
            this.f73506e = new byte[i11];
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f73502a) {
                int i13 = i12 - i11;
                byte[] bArr2 = this.f73506e;
                int length = bArr2.length;
                int i14 = this.f73504c;
                if (length < i14 + i13) {
                    this.f73506e = Arrays.copyOf(bArr2, (i14 + i13) * 2);
                }
                System.arraycopy(bArr, i11, this.f73506e, this.f73504c, i13);
                this.f73504c += i13;
            }
        }

        public boolean b(int i11, int i12) {
            int i13 = this.f73503b;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            if (i13 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i11 == 179 || i11 == 181) {
                                this.f73504c -= i12;
                                this.f73502a = false;
                                return true;
                            }
                        } else if ((i11 & 240) != 32) {
                            com.google.android.exoplayer2.util.s.i("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.f73505d = this.f73504c;
                            this.f73503b = 4;
                        }
                    } else if (i11 > 31) {
                        com.google.android.exoplayer2.util.s.i("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.f73503b = 3;
                    }
                } else if (i11 != 181) {
                    com.google.android.exoplayer2.util.s.i("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.f73503b = 2;
                }
            } else if (i11 == 176) {
                this.f73503b = 1;
                this.f73502a = true;
            }
            byte[] bArr = f73501f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f73502a = false;
            this.f73504c = 0;
            this.f73503b = 0;
        }
    }

    /* loaded from: classes4.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final g9.e0 f73507a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f73508b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f73509c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f73510d;

        /* renamed from: e, reason: collision with root package name */
        private int f73511e;

        /* renamed from: f, reason: collision with root package name */
        private int f73512f;

        /* renamed from: g, reason: collision with root package name */
        private long f73513g;

        /* renamed from: h, reason: collision with root package name */
        private long f73514h;

        public b(g9.e0 e0Var) {
            this.f73507a = e0Var;
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f73509c) {
                int i13 = this.f73512f;
                int i14 = (i11 + 1) - i13;
                if (i14 >= i12) {
                    this.f73512f = i13 + (i12 - i11);
                } else {
                    this.f73510d = ((bArr[i14] & 192) >> 6) == 0;
                    this.f73509c = false;
                }
            }
        }

        public void b(long j11, int i11, boolean z10) {
            if (this.f73511e == 182 && z10 && this.f73508b) {
                long j12 = this.f73514h;
                if (j12 != C.TIME_UNSET) {
                    this.f73507a.d(j12, this.f73510d ? 1 : 0, (int) (j11 - this.f73513g), i11, null);
                }
            }
            if (this.f73511e != 179) {
                this.f73513g = j11;
            }
        }

        public void c(int i11, long j11) {
            this.f73511e = i11;
            this.f73510d = false;
            this.f73508b = i11 == 182 || i11 == 179;
            this.f73509c = i11 == 182;
            this.f73512f = 0;
            this.f73514h = j11;
        }

        public void d() {
            this.f73508b = false;
            this.f73509c = false;
            this.f73510d = false;
            this.f73511e = -1;
        }
    }

    public o() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k0 k0Var) {
        this.f73490a = k0Var;
        this.f73492c = new boolean[4];
        this.f73493d = new a(128);
        this.f73500k = C.TIME_UNSET;
        if (k0Var != null) {
            this.f73494e = new u(178, 128);
            this.f73491b = new com.google.android.exoplayer2.util.d0();
        } else {
            this.f73494e = null;
            this.f73491b = null;
        }
    }

    private static o1 d(a aVar, int i11, String str) {
        byte[] copyOf = Arrays.copyOf(aVar.f73506e, aVar.f73504c);
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(copyOf);
        c0Var.s(i11);
        c0Var.s(4);
        c0Var.q();
        c0Var.r(8);
        if (c0Var.g()) {
            c0Var.r(4);
            c0Var.r(3);
        }
        int h11 = c0Var.h(4);
        float f11 = 1.0f;
        if (h11 == 15) {
            int h12 = c0Var.h(8);
            int h13 = c0Var.h(8);
            if (h13 == 0) {
                com.google.android.exoplayer2.util.s.i("H263Reader", "Invalid aspect ratio");
            } else {
                f11 = h12 / h13;
            }
        } else {
            float[] fArr = f73489l;
            if (h11 < fArr.length) {
                f11 = fArr[h11];
            } else {
                com.google.android.exoplayer2.util.s.i("H263Reader", "Invalid aspect ratio");
            }
        }
        if (c0Var.g()) {
            c0Var.r(2);
            c0Var.r(1);
            if (c0Var.g()) {
                c0Var.r(15);
                c0Var.q();
                c0Var.r(15);
                c0Var.q();
                c0Var.r(15);
                c0Var.q();
                c0Var.r(3);
                c0Var.r(11);
                c0Var.q();
                c0Var.r(15);
                c0Var.q();
            }
        }
        if (c0Var.h(2) != 0) {
            com.google.android.exoplayer2.util.s.i("H263Reader", "Unhandled video object layer shape");
        }
        c0Var.q();
        int h14 = c0Var.h(16);
        c0Var.q();
        if (c0Var.g()) {
            if (h14 == 0) {
                com.google.android.exoplayer2.util.s.i("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i12 = 0;
                for (int i13 = h14 - 1; i13 > 0; i13 >>= 1) {
                    i12++;
                }
                c0Var.r(i12);
            }
        }
        c0Var.q();
        int h15 = c0Var.h(13);
        c0Var.q();
        int h16 = c0Var.h(13);
        c0Var.q();
        c0Var.q();
        return new o1.b().S(str).e0(MimeTypes.VIDEO_MP4V).j0(h15).Q(h16).a0(f11).T(Collections.singletonList(copyOf)).E();
    }

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.f73495f);
        com.google.android.exoplayer2.util.a.i(this.f73498i);
        int e11 = d0Var.e();
        int f11 = d0Var.f();
        byte[] d11 = d0Var.d();
        this.f73496g += d0Var.a();
        this.f73498i.c(d0Var, d0Var.a());
        while (true) {
            int c11 = com.google.android.exoplayer2.util.x.c(d11, e11, f11, this.f73492c);
            if (c11 == f11) {
                break;
            }
            int i11 = c11 + 3;
            int i12 = d0Var.d()[i11] & 255;
            int i13 = c11 - e11;
            int i14 = 0;
            if (!this.f73499j) {
                if (i13 > 0) {
                    this.f73493d.a(d11, e11, c11);
                }
                if (this.f73493d.b(i12, i13 < 0 ? -i13 : 0)) {
                    g9.e0 e0Var = this.f73498i;
                    a aVar = this.f73493d;
                    e0Var.e(d(aVar, aVar.f73505d, (String) com.google.android.exoplayer2.util.a.e(this.f73497h)));
                    this.f73499j = true;
                }
            }
            this.f73495f.a(d11, e11, c11);
            u uVar = this.f73494e;
            if (uVar != null) {
                if (i13 > 0) {
                    uVar.a(d11, e11, c11);
                } else {
                    i14 = -i13;
                }
                if (this.f73494e.b(i14)) {
                    u uVar2 = this.f73494e;
                    ((com.google.android.exoplayer2.util.d0) p0.j(this.f73491b)).N(this.f73494e.f73633d, com.google.android.exoplayer2.util.x.q(uVar2.f73633d, uVar2.f73634e));
                    ((k0) p0.j(this.f73490a)).a(this.f73500k, this.f73491b);
                }
                if (i12 == 178 && d0Var.d()[c11 + 2] == 1) {
                    this.f73494e.e(i12);
                }
            }
            int i15 = f11 - c11;
            this.f73495f.b(this.f73496g - i15, i15, this.f73499j);
            this.f73495f.c(i12, this.f73500k);
            e11 = i11;
        }
        if (!this.f73499j) {
            this.f73493d.a(d11, e11, f11);
        }
        this.f73495f.a(d11, e11, f11);
        u uVar3 = this.f73494e;
        if (uVar3 != null) {
            uVar3.a(d11, e11, f11);
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f73500k = j11;
        }
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        this.f73497h = dVar.b();
        g9.e0 track = nVar.track(dVar.c(), 2);
        this.f73498i = track;
        this.f73495f = new b(track);
        k0 k0Var = this.f73490a;
        if (k0Var != null) {
            k0Var.b(nVar, dVar);
        }
    }

    @Override // q9.m
    public void packetFinished() {
    }

    @Override // q9.m
    public void seek() {
        com.google.android.exoplayer2.util.x.a(this.f73492c);
        this.f73493d.c();
        b bVar = this.f73495f;
        if (bVar != null) {
            bVar.d();
        }
        u uVar = this.f73494e;
        if (uVar != null) {
            uVar.d();
        }
        this.f73496g = 0L;
        this.f73500k = C.TIME_UNSET;
    }
}
