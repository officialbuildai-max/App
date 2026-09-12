package q3;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.i0;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.m;
import androidx.media3.common.util.u;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.e;
import i3.k;
import i3.r;
import i3.s;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;
import u1.a;

/* loaded from: classes2.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f73195a = new j0();

    /* renamed from: b, reason: collision with root package name */
    private final j0 f73196b = new j0();

    /* renamed from: c, reason: collision with root package name */
    private final b f73197c;

    /* renamed from: d, reason: collision with root package name */
    private Inflater f73198d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        private boolean f73200b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f73201c;

        /* renamed from: d, reason: collision with root package name */
        private int[] f73202d;

        /* renamed from: e, reason: collision with root package name */
        private int f73203e;

        /* renamed from: f, reason: collision with root package name */
        private int f73204f;

        /* renamed from: g, reason: collision with root package name */
        private Rect f73205g;

        /* renamed from: a, reason: collision with root package name */
        private final int[] f73199a = new int[4];

        /* renamed from: h, reason: collision with root package name */
        private int f73206h = -1;

        /* renamed from: i, reason: collision with root package name */
        private int f73207i = -1;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q3.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0918a {

            /* renamed from: a, reason: collision with root package name */
            public int f73208a;

            /* renamed from: b, reason: collision with root package name */
            public int f73209b;

            private C0918a() {
            }
        }

        private static int b(int[] iArr, int i11) {
            return (i11 < 0 || i11 >= iArr.length) ? iArr[0] : iArr[i11];
        }

        private static int c(String str) {
            try {
                return Integer.parseInt(str, 16);
            } catch (RuntimeException unused) {
                return 0;
            }
        }

        private void d(int[] iArr, j0 j0Var, int i11) {
            while (j0Var.f() < i11 && j0Var.a() > 0) {
                switch (j0Var.H()) {
                    case 0:
                    case 1:
                    case 2:
                        break;
                    case 3:
                        if (g(iArr, j0Var)) {
                            break;
                        } else {
                            return;
                        }
                    case 4:
                        if (e(j0Var)) {
                            break;
                        } else {
                            return;
                        }
                    case 5:
                        if (f(j0Var)) {
                            break;
                        } else {
                            return;
                        }
                    case 6:
                        if (h(j0Var)) {
                            break;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }

        private boolean e(j0 j0Var) {
            if (j0Var.a() < 2 || !this.f73201c) {
                return false;
            }
            int H = j0Var.H();
            int H2 = j0Var.H();
            int[] iArr = this.f73199a;
            iArr[3] = n(iArr[3], H >> 4);
            int[] iArr2 = this.f73199a;
            iArr2[2] = n(iArr2[2], H & 15);
            int[] iArr3 = this.f73199a;
            iArr3[1] = n(iArr3[1], H2 >> 4);
            int[] iArr4 = this.f73199a;
            iArr4[0] = n(iArr4[0], H2 & 15);
            return true;
        }

        private boolean f(j0 j0Var) {
            if (j0Var.a() < 6) {
                return false;
            }
            int H = j0Var.H();
            int H2 = j0Var.H();
            int i11 = (H << 4) | (H2 >> 4);
            int H3 = ((H2 & 15) << 8) | j0Var.H();
            int H4 = j0Var.H();
            int H5 = j0Var.H();
            this.f73205g = new Rect(i11, (H4 << 4) | (H5 >> 4), H3 + 1, (j0Var.H() | ((H5 & 15) << 8)) + 1);
            return true;
        }

        private boolean g(int[] iArr, j0 j0Var) {
            if (j0Var.a() < 2) {
                return false;
            }
            int H = j0Var.H();
            int H2 = j0Var.H();
            this.f73199a[3] = b(iArr, H >> 4);
            this.f73199a[2] = b(iArr, H & 15);
            this.f73199a[1] = b(iArr, H2 >> 4);
            this.f73199a[0] = b(iArr, H2 & 15);
            this.f73201c = true;
            return true;
        }

        private boolean h(j0 j0Var) {
            if (j0Var.a() < 4) {
                return false;
            }
            this.f73206h = j0Var.P();
            this.f73207i = j0Var.P();
            return true;
        }

        private void j(i0 i0Var, boolean z10, Rect rect, int[] iArr) {
            int width = rect.width();
            int height = rect.height();
            int i11 = !z10 ? 1 : 0;
            int i12 = i11 * width;
            C0918a c0918a = new C0918a();
            while (true) {
                int i13 = 0;
                do {
                    k(i0Var, width, c0918a);
                    int min = Math.min(c0918a.f73209b, width - i13);
                    if (min > 0) {
                        int i14 = i12 + min;
                        Arrays.fill(iArr, i12, i14, this.f73199a[c0918a.f73208a]);
                        i13 += min;
                        i12 = i14;
                    }
                } while (i13 < width);
                i11 += 2;
                if (i11 >= height) {
                    return;
                }
                i12 = i11 * width;
                i0Var.c();
            }
        }

        private static void k(i0 i0Var, int i11, C0918a c0918a) {
            int i12 = 0;
            for (int i13 = 1; i12 < i13 && i13 <= 64; i13 <<= 2) {
                if (i0Var.b() < 4) {
                    c0918a.f73208a = -1;
                    c0918a.f73209b = 0;
                    return;
                }
                i12 = (i12 << 4) | i0Var.h(4);
            }
            c0918a.f73208a = i12 & 3;
            if (i12 >= 4) {
                i11 = i12 >> 2;
            }
            c0918a.f73209b = i11;
        }

        private static int n(int i11, int i12) {
            return (i11 & 16777215) | ((i12 * 17) << 24);
        }

        public u1.a a(j0 j0Var) {
            Rect rect;
            if (this.f73202d == null || !this.f73200b || !this.f73201c || (rect = this.f73205g) == null || this.f73206h == -1 || this.f73207i == -1 || rect.width() < 2 || this.f73205g.height() < 2) {
                return null;
            }
            Rect rect2 = this.f73205g;
            int[] iArr = new int[rect2.width() * rect2.height()];
            i0 i0Var = new i0();
            j0Var.W(this.f73206h);
            i0Var.m(j0Var);
            j(i0Var, true, rect2, iArr);
            j0Var.W(this.f73207i);
            i0Var.m(j0Var);
            j(i0Var, false, rect2, iArr);
            return new a.b().f(Bitmap.createBitmap(iArr, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888)).k(rect2.left / this.f73203e).l(0).h(rect2.top / this.f73204f, 0).i(0).n(rect2.width() / this.f73203e).g(rect2.height() / this.f73204f).a();
        }

        public void i(String str) {
            for (String str2 : a1.o1(str.trim(), "\\r?\\n")) {
                if (str2.startsWith("palette: ")) {
                    String[] o12 = a1.o1(str2.substring(9), ",");
                    this.f73202d = new int[o12.length];
                    for (int i11 = 0; i11 < o12.length; i11++) {
                        this.f73202d[i11] = c(o12[i11].trim());
                    }
                } else if (str2.startsWith("size: ")) {
                    String[] o13 = a1.o1(str2.substring(6).trim(), "x");
                    if (o13.length == 2) {
                        try {
                            this.f73203e = Integer.parseInt(o13[0]);
                            this.f73204f = Integer.parseInt(o13[1]);
                            this.f73200b = true;
                        } catch (RuntimeException e11) {
                            u.i("VobsubParser", "Parsing IDX failed", e11);
                        }
                    }
                }
            }
        }

        public void l(j0 j0Var) {
            int[] iArr = this.f73202d;
            if (iArr == null || !this.f73200b) {
                return;
            }
            j0Var.X(j0Var.P() - 2);
            d(iArr, j0Var, j0Var.P());
        }

        public void m() {
            this.f73201c = false;
            this.f73205g = null;
            this.f73206h = -1;
            this.f73207i = -1;
        }
    }

    public a(List list) {
        b bVar = new b();
        this.f73197c = bVar;
        bVar.i(new String((byte[]) list.get(0), StandardCharsets.UTF_8));
    }

    private u1.a d() {
        if (this.f73198d == null) {
            this.f73198d = new Inflater();
        }
        if (a1.P0(this.f73195a, this.f73196b, this.f73198d)) {
            this.f73195a.U(this.f73196b.e(), this.f73196b.g());
        }
        this.f73197c.m();
        int a11 = this.f73195a.a();
        if (a11 < 2 || this.f73195a.P() != a11) {
            return null;
        }
        this.f73197c.l(this.f73195a);
        return this.f73197c.a(this.f73195a);
    }

    @Override // i3.s
    public void a(byte[] bArr, int i11, int i12, s.b bVar, m mVar) {
        this.f73195a.U(bArr, i12 + i11);
        this.f73195a.W(i11);
        u1.a d11 = d();
        mVar.accept(new e(d11 != null ? ImmutableList.of(d11) : ImmutableList.of(), C.TIME_UNSET, 5000000L));
    }

    @Override // i3.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.a(this, bArr, i11, i12);
    }

    @Override // i3.s
    public int c() {
        return 2;
    }

    @Override // i3.s
    public /* synthetic */ void reset() {
        r.b(this);
    }
}
