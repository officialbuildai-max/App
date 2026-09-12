package ca;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import ba.b;
import ba.i;
import ba.m;
import ba.n;
import ca.c;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okio.Utf8;

/* loaded from: classes3.dex */
public final class c extends e {

    /* renamed from: g, reason: collision with root package name */
    private final d0 f17135g = new d0();

    /* renamed from: h, reason: collision with root package name */
    private final c0 f17136h = new c0();

    /* renamed from: i, reason: collision with root package name */
    private int f17137i = -1;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f17138j;

    /* renamed from: k, reason: collision with root package name */
    private final int f17139k;

    /* renamed from: l, reason: collision with root package name */
    private final b[] f17140l;

    /* renamed from: m, reason: collision with root package name */
    private b f17141m;

    /* renamed from: n, reason: collision with root package name */
    private List f17142n;

    /* renamed from: o, reason: collision with root package name */
    private List f17143o;

    /* renamed from: p, reason: collision with root package name */
    private C0171c f17144p;

    /* renamed from: q, reason: collision with root package name */
    private int f17145q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        private static final Comparator f17146c = new Comparator() { // from class: ca.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int c11;
                c11 = c.a.c((c.a) obj, (c.a) obj2);
                return c11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final ba.b f17147a;

        /* renamed from: b, reason: collision with root package name */
        public final int f17148b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13, boolean z10, int i14, int i15) {
            b.C0151b n11 = new b.C0151b().o(charSequence).p(alignment).h(f11, i11).i(i12).k(f12).l(i13).n(f13);
            if (z10) {
                n11.s(i14);
            }
            this.f17147a = n11.a();
            this.f17148b = i15;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int c(a aVar, a aVar2) {
            return Integer.compare(aVar2.f17148b, aVar.f17148b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b {
        private static final int[] A;
        private static final int[] B;
        private static final boolean[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;
        private static final int[] G;

        /* renamed from: w, reason: collision with root package name */
        public static final int f17149w = h(2, 2, 2, 0);

        /* renamed from: x, reason: collision with root package name */
        public static final int f17150x;

        /* renamed from: y, reason: collision with root package name */
        public static final int f17151y;

        /* renamed from: z, reason: collision with root package name */
        private static final int[] f17152z;

        /* renamed from: a, reason: collision with root package name */
        private final List f17153a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final SpannableStringBuilder f17154b = new SpannableStringBuilder();

        /* renamed from: c, reason: collision with root package name */
        private boolean f17155c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f17156d;

        /* renamed from: e, reason: collision with root package name */
        private int f17157e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f17158f;

        /* renamed from: g, reason: collision with root package name */
        private int f17159g;

        /* renamed from: h, reason: collision with root package name */
        private int f17160h;

        /* renamed from: i, reason: collision with root package name */
        private int f17161i;

        /* renamed from: j, reason: collision with root package name */
        private int f17162j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f17163k;

        /* renamed from: l, reason: collision with root package name */
        private int f17164l;

        /* renamed from: m, reason: collision with root package name */
        private int f17165m;

        /* renamed from: n, reason: collision with root package name */
        private int f17166n;

        /* renamed from: o, reason: collision with root package name */
        private int f17167o;

        /* renamed from: p, reason: collision with root package name */
        private int f17168p;

        /* renamed from: q, reason: collision with root package name */
        private int f17169q;

        /* renamed from: r, reason: collision with root package name */
        private int f17170r;

        /* renamed from: s, reason: collision with root package name */
        private int f17171s;

        /* renamed from: t, reason: collision with root package name */
        private int f17172t;

        /* renamed from: u, reason: collision with root package name */
        private int f17173u;

        /* renamed from: v, reason: collision with root package name */
        private int f17174v;

        static {
            int h11 = h(0, 0, 0, 0);
            f17150x = h11;
            int h12 = h(0, 0, 0, 3);
            f17151y = h12;
            f17152z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{h11, h12, h11, h11, h12, h11, h11};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{h11, h11, h11, h11, h11, h12, h12};
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
                com.google.android.exoplayer2.util.a.c(r4, r0, r1)
                com.google.android.exoplayer2.util.a.c(r5, r0, r1)
                com.google.android.exoplayer2.util.a.c(r6, r0, r1)
                com.google.android.exoplayer2.util.a.c(r7, r0, r1)
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
            throw new UnsupportedOperationException("Method not decompiled: ca.c.b.h(int, int, int, int):int");
        }

        public void a(char c11) {
            if (c11 != '\n') {
                this.f17154b.append(c11);
                return;
            }
            this.f17153a.add(d());
            this.f17154b.clear();
            if (this.f17168p != -1) {
                this.f17168p = 0;
            }
            if (this.f17169q != -1) {
                this.f17169q = 0;
            }
            if (this.f17170r != -1) {
                this.f17170r = 0;
            }
            if (this.f17172t != -1) {
                this.f17172t = 0;
            }
            while (true) {
                if ((!this.f17163k || this.f17153a.size() < this.f17162j) && this.f17153a.size() < 15) {
                    return;
                } else {
                    this.f17153a.remove(0);
                }
            }
        }

        public void b() {
            int length = this.f17154b.length();
            if (length > 0) {
                this.f17154b.delete(length - 1, length);
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
        public ca.c.a c() {
            /*
                Method dump skipped, instructions count: 194
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ca.c.b.c():ca.c$a");
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f17154b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f17168p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f17168p, length, 33);
                }
                if (this.f17169q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f17169q, length, 33);
                }
                if (this.f17170r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f17171s), this.f17170r, length, 33);
                }
                if (this.f17172t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f17173u), this.f17172t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f17153a.clear();
            this.f17154b.clear();
            this.f17168p = -1;
            this.f17169q = -1;
            this.f17170r = -1;
            this.f17172t = -1;
            this.f17174v = 0;
        }

        public void f(boolean z10, boolean z11, boolean z12, int i11, boolean z13, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.f17155c = true;
            this.f17156d = z10;
            this.f17163k = z11;
            this.f17157e = i11;
            this.f17158f = z13;
            this.f17159g = i12;
            this.f17160h = i13;
            this.f17161i = i16;
            int i19 = i14 + 1;
            if (this.f17162j != i19) {
                this.f17162j = i19;
                while (true) {
                    if ((!z11 || this.f17153a.size() < this.f17162j) && this.f17153a.size() < 15) {
                        break;
                    } else {
                        this.f17153a.remove(0);
                    }
                }
            }
            if (i17 != 0 && this.f17165m != i17) {
                this.f17165m = i17;
                int i20 = i17 - 1;
                q(D[i20], f17151y, C[i20], 0, A[i20], B[i20], f17152z[i20]);
            }
            if (i18 == 0 || this.f17166n == i18) {
                return;
            }
            this.f17166n = i18;
            int i21 = i18 - 1;
            m(0, 1, 1, false, false, F[i21], E[i21]);
            n(f17149w, G[i21], f17150x);
        }

        public boolean i() {
            return this.f17155c;
        }

        public boolean j() {
            return !i() || (this.f17153a.isEmpty() && this.f17154b.length() == 0);
        }

        public boolean k() {
            return this.f17156d;
        }

        public void l() {
            e();
            this.f17155c = false;
            this.f17156d = false;
            this.f17157e = 4;
            this.f17158f = false;
            this.f17159g = 0;
            this.f17160h = 0;
            this.f17161i = 0;
            this.f17162j = 15;
            this.f17163k = true;
            this.f17164l = 0;
            this.f17165m = 0;
            this.f17166n = 0;
            int i11 = f17150x;
            this.f17167o = i11;
            this.f17171s = f17149w;
            this.f17173u = i11;
        }

        public void m(int i11, int i12, int i13, boolean z10, boolean z11, int i14, int i15) {
            if (this.f17168p != -1) {
                if (!z10) {
                    this.f17154b.setSpan(new StyleSpan(2), this.f17168p, this.f17154b.length(), 33);
                    this.f17168p = -1;
                }
            } else if (z10) {
                this.f17168p = this.f17154b.length();
            }
            if (this.f17169q == -1) {
                if (z11) {
                    this.f17169q = this.f17154b.length();
                }
            } else {
                if (z11) {
                    return;
                }
                this.f17154b.setSpan(new UnderlineSpan(), this.f17169q, this.f17154b.length(), 33);
                this.f17169q = -1;
            }
        }

        public void n(int i11, int i12, int i13) {
            if (this.f17170r != -1 && this.f17171s != i11) {
                this.f17154b.setSpan(new ForegroundColorSpan(this.f17171s), this.f17170r, this.f17154b.length(), 33);
            }
            if (i11 != f17149w) {
                this.f17170r = this.f17154b.length();
                this.f17171s = i11;
            }
            if (this.f17172t != -1 && this.f17173u != i12) {
                this.f17154b.setSpan(new BackgroundColorSpan(this.f17173u), this.f17172t, this.f17154b.length(), 33);
            }
            if (i12 != f17150x) {
                this.f17172t = this.f17154b.length();
                this.f17173u = i12;
            }
        }

        public void o(int i11, int i12) {
            if (this.f17174v != i11) {
                a('\n');
            }
            this.f17174v = i11;
        }

        public void p(boolean z10) {
            this.f17156d = z10;
        }

        public void q(int i11, int i12, boolean z10, int i13, int i14, int i15, int i16) {
            this.f17167o = i11;
            this.f17164l = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ca.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0171c {

        /* renamed from: a, reason: collision with root package name */
        public final int f17175a;

        /* renamed from: b, reason: collision with root package name */
        public final int f17176b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f17177c;

        /* renamed from: d, reason: collision with root package name */
        int f17178d = 0;

        public C0171c(int i11, int i12) {
            this.f17175a = i11;
            this.f17176b = i12;
            this.f17177c = new byte[(i12 * 2) - 1];
        }
    }

    public c(int i11, List list) {
        this.f17139k = i11 == -1 ? 1 : i11;
        this.f17138j = list != null && com.google.android.exoplayer2.util.f.h(list);
        this.f17140l = new b[8];
        for (int i12 = 0; i12 < 8; i12++) {
            this.f17140l[i12] = new b();
        }
        this.f17141m = this.f17140l[0];
    }

    private void A() {
        for (int i11 = 0; i11 < 8; i11++) {
            this.f17140l[i11].l();
        }
    }

    private void k() {
        if (this.f17144p == null) {
            return;
        }
        z();
        this.f17144p = null;
    }

    private List l() {
        a c11;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 8; i11++) {
            if (!this.f17140l[i11].j() && this.f17140l[i11].k() && (c11 = this.f17140l[i11].c()) != null) {
                arrayList.add(c11);
            }
        }
        Collections.sort(arrayList, a.f17146c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList2.add(((a) arrayList.get(i12)).f17147a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void m(int i11) {
        if (i11 != 0) {
            if (i11 == 3) {
                this.f17142n = l();
                return;
            }
            if (i11 == 8) {
                this.f17141m.b();
                return;
            }
            switch (i11) {
                case 12:
                    A();
                    return;
                case 13:
                    this.f17141m.a('\n');
                    return;
                case 14:
                    return;
                default:
                    if (i11 >= 17 && i11 <= 23) {
                        s.i("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i11);
                        this.f17136h.r(8);
                        return;
                    }
                    if (i11 < 24 || i11 > 31) {
                        s.i("Cea708Decoder", "Invalid C0 command: " + i11);
                        return;
                    }
                    s.i("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i11);
                    this.f17136h.r(16);
                    return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
    private void n(int i11) {
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
                if (this.f17145q != i13) {
                    this.f17145q = i13;
                    this.f17141m = this.f17140l[i13];
                    return;
                }
                return;
            case PRIVACY_URL_ERROR_VALUE:
                while (i12 <= 8) {
                    if (this.f17136h.g()) {
                        this.f17140l[8 - i12].e();
                    }
                    i12++;
                }
                return;
            case TPAT_RETRY_FAILED_VALUE:
                for (int i14 = 1; i14 <= 8; i14++) {
                    if (this.f17136h.g()) {
                        this.f17140l[8 - i14].p(true);
                    }
                }
                return;
            case 138:
                while (i12 <= 8) {
                    if (this.f17136h.g()) {
                        this.f17140l[8 - i12].p(false);
                    }
                    i12++;
                }
                return;
            case 139:
                for (int i15 = 1; i15 <= 8; i15++) {
                    if (this.f17136h.g()) {
                        this.f17140l[8 - i15].p(!r0.k());
                    }
                }
                return;
            case 140:
                while (i12 <= 8) {
                    if (this.f17136h.g()) {
                        this.f17140l[8 - i12].l();
                    }
                    i12++;
                }
                return;
            case 141:
                this.f17136h.r(8);
                return;
            case 142:
                return;
            case 143:
                A();
                return;
            case 144:
                if (this.f17141m.i()) {
                    v();
                    return;
                } else {
                    this.f17136h.r(16);
                    return;
                }
            case 145:
                if (this.f17141m.i()) {
                    w();
                    return;
                } else {
                    this.f17136h.r(24);
                    return;
                }
            case 146:
                if (this.f17141m.i()) {
                    x();
                    return;
                } else {
                    this.f17136h.r(16);
                    return;
                }
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                s.i("Cea708Decoder", "Invalid C1 command: " + i11);
                return;
            case 151:
                if (this.f17141m.i()) {
                    y();
                    return;
                } else {
                    this.f17136h.r(32);
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
                q(i16);
                if (this.f17145q != i16) {
                    this.f17145q = i16;
                    this.f17141m = this.f17140l[i16];
                    return;
                }
                return;
        }
    }

    private void o(int i11) {
        if (i11 <= 7) {
            return;
        }
        if (i11 <= 15) {
            this.f17136h.r(8);
        } else if (i11 <= 23) {
            this.f17136h.r(16);
        } else if (i11 <= 31) {
            this.f17136h.r(24);
        }
    }

    private void p(int i11) {
        if (i11 <= 135) {
            this.f17136h.r(32);
            return;
        }
        if (i11 <= 143) {
            this.f17136h.r(40);
        } else if (i11 <= 159) {
            this.f17136h.r(2);
            this.f17136h.r(this.f17136h.h(6) * 8);
        }
    }

    private void q(int i11) {
        b bVar = this.f17140l[i11];
        this.f17136h.r(2);
        boolean g11 = this.f17136h.g();
        boolean g12 = this.f17136h.g();
        boolean g13 = this.f17136h.g();
        int h11 = this.f17136h.h(3);
        boolean g14 = this.f17136h.g();
        int h12 = this.f17136h.h(7);
        int h13 = this.f17136h.h(8);
        int h14 = this.f17136h.h(4);
        int h15 = this.f17136h.h(4);
        this.f17136h.r(2);
        int h16 = this.f17136h.h(6);
        this.f17136h.r(2);
        bVar.f(g11, g12, g13, h11, g14, h12, h13, h15, h16, h14, this.f17136h.h(3), this.f17136h.h(3));
    }

    private void r(int i11) {
        if (i11 == 127) {
            this.f17141m.a((char) 9835);
        } else {
            this.f17141m.a((char) (i11 & 255));
        }
    }

    private void s(int i11) {
        this.f17141m.a((char) (i11 & 255));
    }

    private void t(int i11) {
        if (i11 == 32) {
            this.f17141m.a(' ');
            return;
        }
        if (i11 == 33) {
            this.f17141m.a((char) 160);
            return;
        }
        if (i11 == 37) {
            this.f17141m.a((char) 8230);
            return;
        }
        if (i11 == 42) {
            this.f17141m.a((char) 352);
            return;
        }
        if (i11 == 44) {
            this.f17141m.a((char) 338);
            return;
        }
        if (i11 == 63) {
            this.f17141m.a((char) 376);
            return;
        }
        if (i11 == 57) {
            this.f17141m.a((char) 8482);
            return;
        }
        if (i11 == 58) {
            this.f17141m.a((char) 353);
            return;
        }
        if (i11 == 60) {
            this.f17141m.a((char) 339);
            return;
        }
        if (i11 == 61) {
            this.f17141m.a((char) 8480);
            return;
        }
        switch (i11) {
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                this.f17141m.a((char) 9608);
                return;
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                this.f17141m.a((char) 8216);
                return;
            case 50:
                this.f17141m.a((char) 8217);
                return;
            case AD_REWARD_USER_VALUE:
                this.f17141m.a((char) 8220);
                return;
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                this.f17141m.a((char) 8221);
                return;
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                this.f17141m.a((char) 8226);
                return;
            default:
                switch (i11) {
                    case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                        this.f17141m.a((char) 8539);
                        return;
                    case JSON_ENCODE_ERROR_VALUE:
                        this.f17141m.a((char) 8540);
                        return;
                    case 120:
                        this.f17141m.a((char) 8541);
                        return;
                    case TPAT_ERROR_VALUE:
                        this.f17141m.a((char) 8542);
                        return;
                    case INVALID_ADS_ENDPOINT_VALUE:
                        this.f17141m.a((char) 9474);
                        return;
                    case INVALID_RI_ENDPOINT_VALUE:
                        this.f17141m.a((char) 9488);
                        return;
                    case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                        this.f17141m.a((char) 9492);
                        return;
                    case INVALID_METRICS_ENDPOINT_VALUE:
                        this.f17141m.a((char) 9472);
                        return;
                    case 126:
                        this.f17141m.a((char) 9496);
                        return;
                    case 127:
                        this.f17141m.a((char) 9484);
                        return;
                    default:
                        s.i("Cea708Decoder", "Invalid G2 character: " + i11);
                        return;
                }
        }
    }

    private void u(int i11) {
        if (i11 == 160) {
            this.f17141m.a((char) 13252);
            return;
        }
        s.i("Cea708Decoder", "Invalid G3 character: " + i11);
        this.f17141m.a('_');
    }

    private void v() {
        this.f17141m.m(this.f17136h.h(4), this.f17136h.h(2), this.f17136h.h(2), this.f17136h.g(), this.f17136h.g(), this.f17136h.h(3), this.f17136h.h(3));
    }

    private void w() {
        int h11 = b.h(this.f17136h.h(2), this.f17136h.h(2), this.f17136h.h(2), this.f17136h.h(2));
        int h12 = b.h(this.f17136h.h(2), this.f17136h.h(2), this.f17136h.h(2), this.f17136h.h(2));
        this.f17136h.r(2);
        this.f17141m.n(h11, h12, b.g(this.f17136h.h(2), this.f17136h.h(2), this.f17136h.h(2)));
    }

    private void x() {
        this.f17136h.r(4);
        int h11 = this.f17136h.h(4);
        this.f17136h.r(2);
        this.f17141m.o(h11, this.f17136h.h(6));
    }

    private void y() {
        int h11 = b.h(this.f17136h.h(2), this.f17136h.h(2), this.f17136h.h(2), this.f17136h.h(2));
        int h12 = this.f17136h.h(2);
        int g11 = b.g(this.f17136h.h(2), this.f17136h.h(2), this.f17136h.h(2));
        if (this.f17136h.g()) {
            h12 |= 4;
        }
        boolean g12 = this.f17136h.g();
        int h13 = this.f17136h.h(2);
        int h14 = this.f17136h.h(2);
        int h15 = this.f17136h.h(2);
        this.f17136h.r(8);
        this.f17141m.q(h11, g11, g12, h12, h13, h14, h15);
    }

    private void z() {
        C0171c c0171c = this.f17144p;
        if (c0171c.f17178d != (c0171c.f17176b * 2) - 1) {
            s.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f17144p.f17176b * 2) - 1) + ", but current index is " + this.f17144p.f17178d + " (sequence number " + this.f17144p.f17175a + ");");
        }
        c0 c0Var = this.f17136h;
        C0171c c0171c2 = this.f17144p;
        c0Var.o(c0171c2.f17177c, c0171c2.f17178d);
        boolean z10 = false;
        while (true) {
            if (this.f17136h.b() <= 0) {
                break;
            }
            int h11 = this.f17136h.h(3);
            int h12 = this.f17136h.h(5);
            if (h11 == 7) {
                this.f17136h.r(2);
                h11 = this.f17136h.h(6);
                if (h11 < 7) {
                    s.i("Cea708Decoder", "Invalid extended service number: " + h11);
                }
            }
            if (h12 == 0) {
                if (h11 != 0) {
                    s.i("Cea708Decoder", "serviceNumber is non-zero (" + h11 + ") when blockSize is 0");
                }
            } else if (h11 != this.f17139k) {
                this.f17136h.s(h12);
            } else {
                int e11 = this.f17136h.e() + (h12 * 8);
                while (this.f17136h.e() < e11) {
                    int h13 = this.f17136h.h(8);
                    if (h13 == 16) {
                        int h14 = this.f17136h.h(8);
                        if (h14 <= 31) {
                            o(h14);
                        } else {
                            if (h14 <= 127) {
                                t(h14);
                            } else if (h14 <= 159) {
                                p(h14);
                            } else if (h14 <= 255) {
                                u(h14);
                            } else {
                                s.i("Cea708Decoder", "Invalid extended command: " + h14);
                            }
                            z10 = true;
                        }
                    } else if (h13 <= 31) {
                        m(h13);
                    } else {
                        if (h13 <= 127) {
                            r(h13);
                        } else if (h13 <= 159) {
                            n(h13);
                        } else if (h13 <= 255) {
                            s(h13);
                        } else {
                            s.i("Cea708Decoder", "Invalid base command: " + h13);
                        }
                        z10 = true;
                    }
                }
            }
        }
        if (z10) {
            this.f17142n = l();
        }
    }

    @Override // ca.e
    protected i a() {
        List list = this.f17142n;
        this.f17143o = list;
        return new f((List) com.google.android.exoplayer2.util.a.e(list));
    }

    @Override // ca.e
    protected void b(m mVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(mVar.f24897c);
        this.f17135g.N(byteBuffer.array(), byteBuffer.limit());
        while (this.f17135g.a() >= 3) {
            int D = this.f17135g.D();
            int i11 = D & 3;
            boolean z10 = (D & 4) == 4;
            byte D2 = (byte) this.f17135g.D();
            byte D3 = (byte) this.f17135g.D();
            if (i11 == 2 || i11 == 3) {
                if (z10) {
                    if (i11 == 3) {
                        k();
                        int i12 = (D2 & 192) >> 6;
                        int i13 = this.f17137i;
                        if (i13 != -1 && i12 != (i13 + 1) % 4) {
                            A();
                            s.i("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f17137i + " current=" + i12);
                        }
                        this.f17137i = i12;
                        int i14 = D2 & Utf8.REPLACEMENT_BYTE;
                        if (i14 == 0) {
                            i14 = 64;
                        }
                        C0171c c0171c = new C0171c(i12, i14);
                        this.f17144p = c0171c;
                        byte[] bArr = c0171c.f17177c;
                        int i15 = c0171c.f17178d;
                        c0171c.f17178d = i15 + 1;
                        bArr[i15] = D3;
                    } else {
                        com.google.android.exoplayer2.util.a.a(i11 == 2);
                        C0171c c0171c2 = this.f17144p;
                        if (c0171c2 == null) {
                            s.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0171c2.f17177c;
                            int i16 = c0171c2.f17178d;
                            int i17 = i16 + 1;
                            c0171c2.f17178d = i17;
                            bArr2[i16] = D2;
                            c0171c2.f17178d = i16 + 2;
                            bArr2[i17] = D3;
                        }
                    }
                    C0171c c0171c3 = this.f17144p;
                    if (c0171c3.f17178d == (c0171c3.f17176b * 2) - 1) {
                        k();
                    }
                }
            }
        }
    }

    @Override // ca.e
    /* renamed from: c */
    public /* bridge */ /* synthetic */ m dequeueInputBuffer() {
        return super.dequeueInputBuffer();
    }

    @Override // ca.e
    /* renamed from: d */
    public /* bridge */ /* synthetic */ n dequeueOutputBuffer() {
        return super.dequeueOutputBuffer();
    }

    @Override // ca.e, com.google.android.exoplayer2.decoder.d
    public void flush() {
        super.flush();
        this.f17142n = null;
        this.f17143o = null;
        this.f17145q = 0;
        this.f17141m = this.f17140l[0];
        A();
        this.f17144p = null;
    }

    @Override // ca.e
    protected boolean g() {
        return this.f17142n != this.f17143o;
    }

    @Override // ca.e
    /* renamed from: h */
    public /* bridge */ /* synthetic */ void queueInputBuffer(m mVar) {
        super.queueInputBuffer(mVar);
    }

    @Override // ca.e, com.google.android.exoplayer2.decoder.d
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // ca.e, ba.j
    public /* bridge */ /* synthetic */ void setPositionUs(long j11) {
        super.setPositionUs(j11);
    }
}
