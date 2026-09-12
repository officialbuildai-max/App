package j3;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.util.i0;
import androidx.media3.common.util.j;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;
import i3.k;
import i3.o;
import i3.p;
import j3.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okio.Utf8;
import u1.a;

/* loaded from: classes2.dex */
public final class c extends e {

    /* renamed from: h, reason: collision with root package name */
    private final j0 f66008h = new j0();

    /* renamed from: i, reason: collision with root package name */
    private final i0 f66009i = new i0();

    /* renamed from: j, reason: collision with root package name */
    private int f66010j = -1;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f66011k;

    /* renamed from: l, reason: collision with root package name */
    private final int f66012l;

    /* renamed from: m, reason: collision with root package name */
    private final b[] f66013m;

    /* renamed from: n, reason: collision with root package name */
    private b f66014n;

    /* renamed from: o, reason: collision with root package name */
    private List f66015o;

    /* renamed from: p, reason: collision with root package name */
    private List f66016p;

    /* renamed from: q, reason: collision with root package name */
    private C0826c f66017q;

    /* renamed from: r, reason: collision with root package name */
    private int f66018r;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        private static final Comparator f66019c = new Comparator() { // from class: j3.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int c11;
                c11 = c.a.c((c.a) obj, (c.a) obj2);
                return c11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final u1.a f66020a;

        /* renamed from: b, reason: collision with root package name */
        public final int f66021b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13, boolean z10, int i14, int i15) {
            a.b n11 = new a.b().o(charSequence).p(alignment).h(f11, i11).i(i12).k(f12).l(i13).n(f13);
            if (z10) {
                n11.s(i14);
            }
            this.f66020a = n11.a();
            this.f66021b = i15;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int c(a aVar, a aVar2) {
            return Integer.compare(aVar2.f66021b, aVar.f66021b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        private static final int[] A;
        private static final boolean[] B;
        private static final int[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;

        /* renamed from: v, reason: collision with root package name */
        public static final int f66022v = h(2, 2, 2, 0);

        /* renamed from: w, reason: collision with root package name */
        public static final int f66023w;

        /* renamed from: x, reason: collision with root package name */
        public static final int f66024x;

        /* renamed from: y, reason: collision with root package name */
        private static final int[] f66025y;

        /* renamed from: z, reason: collision with root package name */
        private static final int[] f66026z;

        /* renamed from: a, reason: collision with root package name */
        private final List f66027a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final SpannableStringBuilder f66028b = new SpannableStringBuilder();

        /* renamed from: c, reason: collision with root package name */
        private boolean f66029c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f66030d;

        /* renamed from: e, reason: collision with root package name */
        private int f66031e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f66032f;

        /* renamed from: g, reason: collision with root package name */
        private int f66033g;

        /* renamed from: h, reason: collision with root package name */
        private int f66034h;

        /* renamed from: i, reason: collision with root package name */
        private int f66035i;

        /* renamed from: j, reason: collision with root package name */
        private int f66036j;

        /* renamed from: k, reason: collision with root package name */
        private int f66037k;

        /* renamed from: l, reason: collision with root package name */
        private int f66038l;

        /* renamed from: m, reason: collision with root package name */
        private int f66039m;

        /* renamed from: n, reason: collision with root package name */
        private int f66040n;

        /* renamed from: o, reason: collision with root package name */
        private int f66041o;

        /* renamed from: p, reason: collision with root package name */
        private int f66042p;

        /* renamed from: q, reason: collision with root package name */
        private int f66043q;

        /* renamed from: r, reason: collision with root package name */
        private int f66044r;

        /* renamed from: s, reason: collision with root package name */
        private int f66045s;

        /* renamed from: t, reason: collision with root package name */
        private int f66046t;

        /* renamed from: u, reason: collision with root package name */
        private int f66047u;

        static {
            int h11 = h(0, 0, 0, 0);
            f66023w = h11;
            int h12 = h(0, 0, 0, 3);
            f66024x = h12;
            f66025y = new int[]{0, 0, 0, 0, 0, 2, 0};
            f66026z = new int[]{0, 0, 0, 0, 0, 0, 2};
            A = new int[]{3, 3, 3, 3, 3, 3, 1};
            B = new boolean[]{false, false, false, true, true, true, false};
            C = new int[]{h11, h12, h11, h11, h12, h11, h11};
            D = new int[]{0, 1, 2, 3, 4, 3, 4};
            E = new int[]{0, 0, 0, 0, 0, 3, 3};
            F = new int[]{h11, h11, h11, h11, h11, h12, h12};
        }

        public b() {
            l();
        }

        public static int g(int i11, int i12, int i13) {
            return h(i11, i12, i13, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                androidx.media3.common.util.a.c(r4, r0, r1)
                androidx.media3.common.util.a.c(r5, r0, r1)
                androidx.media3.common.util.a.c(r6, r0, r1)
                androidx.media3.common.util.a.c(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L1b
                if (r7 == r1) goto L1b
                r3 = 2
                if (r7 == r3) goto L1f
                r3 = 3
                if (r7 == r3) goto L1d
            L1b:
                r7 = r2
                goto L21
            L1d:
                r7 = r0
                goto L21
            L1f:
                r7 = 127(0x7f, float:1.78E-43)
            L21:
                if (r4 <= r1) goto L25
                r4 = r2
                goto L26
            L25:
                r4 = r0
            L26:
                if (r5 <= r1) goto L2a
                r5 = r2
                goto L2b
            L2a:
                r5 = r0
            L2b:
                if (r6 <= r1) goto L2e
                r0 = r2
            L2e:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: j3.c.b.h(int, int, int, int):int");
        }

        public void a(char c11) {
            if (c11 != '\n') {
                this.f66028b.append(c11);
                return;
            }
            this.f66027a.add(d());
            this.f66028b.clear();
            if (this.f66041o != -1) {
                this.f66041o = 0;
            }
            if (this.f66042p != -1) {
                this.f66042p = 0;
            }
            if (this.f66043q != -1) {
                this.f66043q = 0;
            }
            if (this.f66045s != -1) {
                this.f66045s = 0;
            }
            while (true) {
                if (this.f66027a.size() < this.f66036j && this.f66027a.size() < 15) {
                    this.f66047u = this.f66027a.size();
                    return;
                }
                this.f66027a.remove(0);
            }
        }

        public void b() {
            int length = this.f66028b.length();
            if (length > 0) {
                this.f66028b.delete(length - 1, length);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public j3.c.a c() {
            /*
                Method dump skipped, instructions count: 194
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: j3.c.b.c():j3.c$a");
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f66028b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f66041o != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f66041o, length, 33);
                }
                if (this.f66042p != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f66042p, length, 33);
                }
                if (this.f66043q != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f66044r), this.f66043q, length, 33);
                }
                if (this.f66045s != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f66046t), this.f66045s, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f66027a.clear();
            this.f66028b.clear();
            this.f66041o = -1;
            this.f66042p = -1;
            this.f66043q = -1;
            this.f66045s = -1;
            this.f66047u = 0;
        }

        public void f(boolean z10, int i11, boolean z11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f66029c = true;
            this.f66030d = z10;
            this.f66031e = i11;
            this.f66032f = z11;
            this.f66033g = i12;
            this.f66034h = i13;
            this.f66035i = i15;
            int i18 = i14 + 1;
            if (this.f66036j != i18) {
                this.f66036j = i18;
                while (true) {
                    if (this.f66027a.size() < this.f66036j && this.f66027a.size() < 15) {
                        break;
                    } else {
                        this.f66027a.remove(0);
                    }
                }
            }
            if (i16 != 0 && this.f66038l != i16) {
                this.f66038l = i16;
                int i19 = i16 - 1;
                q(C[i19], f66024x, B[i19], 0, f66026z[i19], A[i19], f66025y[i19]);
            }
            if (i17 == 0 || this.f66039m == i17) {
                return;
            }
            this.f66039m = i17;
            int i20 = i17 - 1;
            m(0, 1, 1, false, false, E[i20], D[i20]);
            n(f66022v, F[i20], f66023w);
        }

        public boolean i() {
            return this.f66029c;
        }

        public boolean j() {
            return !i() || (this.f66027a.isEmpty() && this.f66028b.length() == 0);
        }

        public boolean k() {
            return this.f66030d;
        }

        public void l() {
            e();
            this.f66029c = false;
            this.f66030d = false;
            this.f66031e = 4;
            this.f66032f = false;
            this.f66033g = 0;
            this.f66034h = 0;
            this.f66035i = 0;
            this.f66036j = 15;
            this.f66037k = 0;
            this.f66038l = 0;
            this.f66039m = 0;
            int i11 = f66023w;
            this.f66040n = i11;
            this.f66044r = f66022v;
            this.f66046t = i11;
        }

        public void m(int i11, int i12, int i13, boolean z10, boolean z11, int i14, int i15) {
            if (this.f66041o != -1) {
                if (!z10) {
                    this.f66028b.setSpan(new StyleSpan(2), this.f66041o, this.f66028b.length(), 33);
                    this.f66041o = -1;
                }
            } else if (z10) {
                this.f66041o = this.f66028b.length();
            }
            if (this.f66042p == -1) {
                if (z11) {
                    this.f66042p = this.f66028b.length();
                }
            } else {
                if (z11) {
                    return;
                }
                this.f66028b.setSpan(new UnderlineSpan(), this.f66042p, this.f66028b.length(), 33);
                this.f66042p = -1;
            }
        }

        public void n(int i11, int i12, int i13) {
            if (this.f66043q != -1 && this.f66044r != i11) {
                this.f66028b.setSpan(new ForegroundColorSpan(this.f66044r), this.f66043q, this.f66028b.length(), 33);
            }
            if (i11 != f66022v) {
                this.f66043q = this.f66028b.length();
                this.f66044r = i11;
            }
            if (this.f66045s != -1 && this.f66046t != i12) {
                this.f66028b.setSpan(new BackgroundColorSpan(this.f66046t), this.f66045s, this.f66028b.length(), 33);
            }
            if (i12 != f66023w) {
                this.f66045s = this.f66028b.length();
                this.f66046t = i12;
            }
        }

        public void o(int i11, int i12) {
            if (this.f66047u != i11) {
                a('\n');
            }
            this.f66047u = i11;
        }

        public void p(boolean z10) {
            this.f66030d = z10;
        }

        public void q(int i11, int i12, boolean z10, int i13, int i14, int i15, int i16) {
            this.f66040n = i11;
            this.f66037k = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j3.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0826c {

        /* renamed from: a, reason: collision with root package name */
        public final int f66048a;

        /* renamed from: b, reason: collision with root package name */
        public final int f66049b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f66050c;

        /* renamed from: d, reason: collision with root package name */
        int f66051d = 0;

        public C0826c(int i11, int i12) {
            this.f66048a = i11;
            this.f66049b = i12;
            this.f66050c = new byte[(i12 * 2) - 1];
        }
    }

    public c(int i11, List list) {
        this.f66012l = i11 == -1 ? 1 : i11;
        this.f66011k = list != null && j.v(list);
        this.f66013m = new b[8];
        for (int i12 = 0; i12 < 8; i12++) {
            this.f66013m[i12] = new b();
        }
        this.f66014n = this.f66013m[0];
    }

    private void A() {
        int h11 = b.h(this.f66009i.h(2), this.f66009i.h(2), this.f66009i.h(2), this.f66009i.h(2));
        int h12 = this.f66009i.h(2);
        int g11 = b.g(this.f66009i.h(2), this.f66009i.h(2), this.f66009i.h(2));
        if (this.f66009i.g()) {
            h12 |= 4;
        }
        boolean g12 = this.f66009i.g();
        int h13 = this.f66009i.h(2);
        int h14 = this.f66009i.h(2);
        int h15 = this.f66009i.h(2);
        this.f66009i.r(8);
        this.f66014n.q(h11, g11, g12, h12, h13, h14, h15);
    }

    private void B() {
        C0826c c0826c = this.f66017q;
        if (c0826c.f66051d != (c0826c.f66049b * 2) - 1) {
            u.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f66017q.f66049b * 2) - 1) + ", but current index is " + this.f66017q.f66051d + " (sequence number " + this.f66017q.f66048a + ");");
        }
        i0 i0Var = this.f66009i;
        C0826c c0826c2 = this.f66017q;
        i0Var.o(c0826c2.f66050c, c0826c2.f66051d);
        boolean z10 = false;
        while (true) {
            if (this.f66009i.b() <= 0) {
                break;
            }
            int h11 = this.f66009i.h(3);
            int h12 = this.f66009i.h(5);
            if (h11 == 7) {
                this.f66009i.r(2);
                h11 = this.f66009i.h(6);
                if (h11 < 7) {
                    u.h("Cea708Decoder", "Invalid extended service number: " + h11);
                }
            }
            if (h12 == 0) {
                if (h11 != 0) {
                    u.h("Cea708Decoder", "serviceNumber is non-zero (" + h11 + ") when blockSize is 0");
                }
            } else if (h11 != this.f66012l) {
                this.f66009i.s(h12);
            } else {
                int e11 = this.f66009i.e() + (h12 * 8);
                while (this.f66009i.e() < e11) {
                    int h13 = this.f66009i.h(8);
                    if (h13 == 16) {
                        int h14 = this.f66009i.h(8);
                        if (h14 <= 31) {
                            q(h14);
                        } else {
                            if (h14 <= 127) {
                                v(h14);
                            } else if (h14 <= 159) {
                                r(h14);
                            } else if (h14 <= 255) {
                                w(h14);
                            } else {
                                u.h("Cea708Decoder", "Invalid extended command: " + h14);
                            }
                            z10 = true;
                        }
                    } else if (h13 <= 31) {
                        o(h13);
                    } else {
                        if (h13 <= 127) {
                            t(h13);
                        } else if (h13 <= 159) {
                            p(h13);
                        } else if (h13 <= 255) {
                            u(h13);
                        } else {
                            u.h("Cea708Decoder", "Invalid base command: " + h13);
                        }
                        z10 = true;
                    }
                }
            }
        }
        if (z10) {
            this.f66015o = n();
        }
    }

    private void C() {
        for (int i11 = 0; i11 < 8; i11++) {
            this.f66013m[i11].l();
        }
    }

    private void m() {
        if (this.f66017q == null) {
            return;
        }
        B();
        this.f66017q = null;
    }

    private List n() {
        a c11;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 8; i11++) {
            if (!this.f66013m[i11].j() && this.f66013m[i11].k() && (c11 = this.f66013m[i11].c()) != null) {
                arrayList.add(c11);
            }
        }
        Collections.sort(arrayList, a.f66019c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList2.add(((a) arrayList.get(i12)).f66020a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void o(int i11) {
        if (i11 != 0) {
            if (i11 == 3) {
                this.f66015o = n();
                return;
            }
            if (i11 == 8) {
                this.f66014n.b();
                return;
            }
            switch (i11) {
                case 12:
                    C();
                    return;
                case 13:
                    this.f66014n.a('\n');
                    return;
                case 14:
                    return;
                default:
                    if (i11 >= 17 && i11 <= 23) {
                        u.h("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i11);
                        this.f66009i.r(8);
                        return;
                    }
                    if (i11 < 24 || i11 > 31) {
                        u.h("Cea708Decoder", "Invalid C0 command: " + i11);
                        return;
                    }
                    u.h("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i11);
                    this.f66009i.r(16);
                    return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
    private void p(int i11) {
        int i12 = 1;
        switch (i11) {
            case 128:
            case 129:
            case 130:
            case MRAID_JS_WRITE_FAILED_VALUE:
            case OMSDK_DOWNLOAD_JS_ERROR_VALUE:
            case OMSDK_JS_WRITE_FAILED_VALUE:
            case 134:
            case 135:
                int i13 = i11 - 128;
                if (this.f66018r != i13) {
                    this.f66018r = i13;
                    this.f66014n = this.f66013m[i13];
                    return;
                }
                return;
            case PRIVACY_URL_ERROR_VALUE:
                while (i12 <= 8) {
                    if (this.f66009i.g()) {
                        this.f66013m[8 - i12].e();
                    }
                    i12++;
                }
                return;
            case TPAT_RETRY_FAILED_VALUE:
                for (int i14 = 1; i14 <= 8; i14++) {
                    if (this.f66009i.g()) {
                        this.f66013m[8 - i14].p(true);
                    }
                }
                return;
            case 138:
                while (i12 <= 8) {
                    if (this.f66009i.g()) {
                        this.f66013m[8 - i12].p(false);
                    }
                    i12++;
                }
                return;
            case 139:
                for (int i15 = 1; i15 <= 8; i15++) {
                    if (this.f66009i.g()) {
                        this.f66013m[8 - i15].p(!r0.k());
                    }
                }
                return;
            case 140:
                while (i12 <= 8) {
                    if (this.f66009i.g()) {
                        this.f66013m[8 - i12].l();
                    }
                    i12++;
                }
                return;
            case 141:
                this.f66009i.r(8);
                return;
            case 142:
                return;
            case 143:
                C();
                return;
            case 144:
                if (this.f66014n.i()) {
                    x();
                    return;
                } else {
                    this.f66009i.r(16);
                    return;
                }
            case 145:
                if (this.f66014n.i()) {
                    y();
                    return;
                } else {
                    this.f66009i.r(24);
                    return;
                }
            case 146:
                if (this.f66014n.i()) {
                    z();
                    return;
                } else {
                    this.f66009i.r(16);
                    return;
                }
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                u.h("Cea708Decoder", "Invalid C1 command: " + i11);
                return;
            case 151:
                if (this.f66014n.i()) {
                    A();
                    return;
                } else {
                    this.f66009i.r(32);
                    return;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i16 = i11 - 152;
                s(i16);
                if (this.f66018r != i16) {
                    this.f66018r = i16;
                    this.f66014n = this.f66013m[i16];
                    return;
                }
                return;
        }
    }

    private void q(int i11) {
        if (i11 <= 7) {
            return;
        }
        if (i11 <= 15) {
            this.f66009i.r(8);
        } else if (i11 <= 23) {
            this.f66009i.r(16);
        } else if (i11 <= 31) {
            this.f66009i.r(24);
        }
    }

    private void r(int i11) {
        if (i11 <= 135) {
            this.f66009i.r(32);
            return;
        }
        if (i11 <= 143) {
            this.f66009i.r(40);
        } else if (i11 <= 159) {
            this.f66009i.r(2);
            this.f66009i.r(this.f66009i.h(6) * 8);
        }
    }

    private void s(int i11) {
        b bVar = this.f66013m[i11];
        this.f66009i.r(2);
        boolean g11 = this.f66009i.g();
        this.f66009i.r(2);
        int h11 = this.f66009i.h(3);
        boolean g12 = this.f66009i.g();
        int h12 = this.f66009i.h(7);
        int h13 = this.f66009i.h(8);
        int h14 = this.f66009i.h(4);
        int h15 = this.f66009i.h(4);
        this.f66009i.r(2);
        this.f66009i.r(6);
        this.f66009i.r(2);
        bVar.f(g11, h11, g12, h12, h13, h15, h14, this.f66009i.h(3), this.f66009i.h(3));
    }

    private void t(int i11) {
        if (i11 == 127) {
            this.f66014n.a((char) 9835);
        } else {
            this.f66014n.a((char) (i11 & 255));
        }
    }

    private void u(int i11) {
        this.f66014n.a((char) (i11 & 255));
    }

    private void v(int i11) {
        if (i11 == 32) {
            this.f66014n.a(' ');
            return;
        }
        if (i11 == 33) {
            this.f66014n.a((char) 160);
            return;
        }
        if (i11 == 37) {
            this.f66014n.a((char) 8230);
            return;
        }
        if (i11 == 42) {
            this.f66014n.a((char) 352);
            return;
        }
        if (i11 == 44) {
            this.f66014n.a((char) 338);
            return;
        }
        if (i11 == 63) {
            this.f66014n.a((char) 376);
            return;
        }
        if (i11 == 57) {
            this.f66014n.a((char) 8482);
            return;
        }
        if (i11 == 58) {
            this.f66014n.a((char) 353);
            return;
        }
        if (i11 == 60) {
            this.f66014n.a((char) 339);
            return;
        }
        if (i11 == 61) {
            this.f66014n.a((char) 8480);
            return;
        }
        switch (i11) {
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                this.f66014n.a((char) 9608);
                return;
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                this.f66014n.a((char) 8216);
                return;
            case 50:
                this.f66014n.a((char) 8217);
                return;
            case AD_REWARD_USER_VALUE:
                this.f66014n.a((char) 8220);
                return;
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                this.f66014n.a((char) 8221);
                return;
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                this.f66014n.a((char) 8226);
                return;
            default:
                switch (i11) {
                    case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                        this.f66014n.a((char) 8539);
                        return;
                    case JSON_ENCODE_ERROR_VALUE:
                        this.f66014n.a((char) 8540);
                        return;
                    case 120:
                        this.f66014n.a((char) 8541);
                        return;
                    case TPAT_ERROR_VALUE:
                        this.f66014n.a((char) 8542);
                        return;
                    case INVALID_ADS_ENDPOINT_VALUE:
                        this.f66014n.a((char) 9474);
                        return;
                    case INVALID_RI_ENDPOINT_VALUE:
                        this.f66014n.a((char) 9488);
                        return;
                    case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                        this.f66014n.a((char) 9492);
                        return;
                    case INVALID_METRICS_ENDPOINT_VALUE:
                        this.f66014n.a((char) 9472);
                        return;
                    case 126:
                        this.f66014n.a((char) 9496);
                        return;
                    case 127:
                        this.f66014n.a((char) 9484);
                        return;
                    default:
                        u.h("Cea708Decoder", "Invalid G2 character: " + i11);
                        return;
                }
        }
    }

    private void w(int i11) {
        if (i11 == 160) {
            this.f66014n.a((char) 13252);
            return;
        }
        u.h("Cea708Decoder", "Invalid G3 character: " + i11);
        this.f66014n.a('_');
    }

    private void x() {
        this.f66014n.m(this.f66009i.h(4), this.f66009i.h(2), this.f66009i.h(2), this.f66009i.g(), this.f66009i.g(), this.f66009i.h(3), this.f66009i.h(3));
    }

    private void y() {
        int h11 = b.h(this.f66009i.h(2), this.f66009i.h(2), this.f66009i.h(2), this.f66009i.h(2));
        int h12 = b.h(this.f66009i.h(2), this.f66009i.h(2), this.f66009i.h(2), this.f66009i.h(2));
        this.f66009i.r(2);
        this.f66014n.n(h11, h12, b.g(this.f66009i.h(2), this.f66009i.h(2), this.f66009i.h(2)));
    }

    private void z() {
        this.f66009i.r(4);
        int h11 = this.f66009i.h(4);
        this.f66009i.r(2);
        this.f66014n.o(h11, this.f66009i.h(6));
    }

    @Override // j3.e
    protected k c() {
        List list = this.f66015o;
        this.f66016p = list;
        return new f((List) androidx.media3.common.util.a.e(list));
    }

    @Override // j3.e
    protected void d(o oVar) {
        ByteBuffer byteBuffer = (ByteBuffer) androidx.media3.common.util.a.e(oVar.f11000c);
        this.f66008h.U(byteBuffer.array(), byteBuffer.limit());
        while (this.f66008h.a() >= 3) {
            int H = this.f66008h.H();
            int i11 = H & 3;
            boolean z10 = (H & 4) == 4;
            byte H2 = (byte) this.f66008h.H();
            byte H3 = (byte) this.f66008h.H();
            if (i11 == 2 || i11 == 3) {
                if (z10) {
                    if (i11 == 3) {
                        m();
                        int i12 = (H2 & 192) >> 6;
                        int i13 = this.f66010j;
                        if (i13 != -1 && i12 != (i13 + 1) % 4) {
                            C();
                            u.h("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f66010j + " current=" + i12);
                        }
                        this.f66010j = i12;
                        int i14 = H2 & Utf8.REPLACEMENT_BYTE;
                        if (i14 == 0) {
                            i14 = 64;
                        }
                        C0826c c0826c = new C0826c(i12, i14);
                        this.f66017q = c0826c;
                        byte[] bArr = c0826c.f66050c;
                        int i15 = c0826c.f66051d;
                        c0826c.f66051d = i15 + 1;
                        bArr[i15] = H3;
                    } else {
                        androidx.media3.common.util.a.a(i11 == 2);
                        C0826c c0826c2 = this.f66017q;
                        if (c0826c2 == null) {
                            u.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0826c2.f66050c;
                            int i16 = c0826c2.f66051d;
                            int i17 = i16 + 1;
                            c0826c2.f66051d = i17;
                            bArr2[i16] = H2;
                            c0826c2.f66051d = i16 + 2;
                            bArr2[i17] = H3;
                        }
                    }
                    C0826c c0826c3 = this.f66017q;
                    if (c0826c3.f66051d == (c0826c3.f66049b * 2) - 1) {
                        m();
                    }
                }
            }
        }
    }

    @Override // j3.e
    /* renamed from: e */
    public /* bridge */ /* synthetic */ o dequeueInputBuffer() {
        return super.dequeueInputBuffer();
    }

    @Override // j3.e
    /* renamed from: f */
    public /* bridge */ /* synthetic */ p dequeueOutputBuffer() {
        return super.dequeueOutputBuffer();
    }

    @Override // j3.e, androidx.media3.decoder.g
    public void flush() {
        super.flush();
        this.f66015o = null;
        this.f66016p = null;
        this.f66018r = 0;
        this.f66014n = this.f66013m[0];
        C();
        this.f66017q = null;
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "Cea708Decoder";
    }

    @Override // j3.e
    protected boolean i() {
        return this.f66015o != this.f66016p;
    }

    @Override // j3.e
    /* renamed from: j */
    public /* bridge */ /* synthetic */ void queueInputBuffer(o oVar) {
        super.queueInputBuffer(oVar);
    }

    @Override // j3.e, androidx.media3.decoder.g
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // j3.e, i3.l
    public /* bridge */ /* synthetic */ void setPositionUs(long j11) {
        super.setPositionUs(j11);
    }
}
