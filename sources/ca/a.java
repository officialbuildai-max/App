package ca;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.view.InputDeviceCompat;
import ba.b;
import ba.i;
import ba.m;
import ba.n;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tn.lib.view.FlowLayout;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class a extends e {

    /* renamed from: h, reason: collision with root package name */
    private final int f17107h;

    /* renamed from: i, reason: collision with root package name */
    private final int f17108i;

    /* renamed from: j, reason: collision with root package name */
    private final int f17109j;

    /* renamed from: k, reason: collision with root package name */
    private final long f17110k;

    /* renamed from: n, reason: collision with root package name */
    private List f17113n;

    /* renamed from: o, reason: collision with root package name */
    private List f17114o;

    /* renamed from: p, reason: collision with root package name */
    private int f17115p;

    /* renamed from: q, reason: collision with root package name */
    private int f17116q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f17117r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f17118s;

    /* renamed from: t, reason: collision with root package name */
    private byte f17119t;

    /* renamed from: u, reason: collision with root package name */
    private byte f17120u;

    /* renamed from: w, reason: collision with root package name */
    private boolean f17122w;

    /* renamed from: x, reason: collision with root package name */
    private long f17123x;

    /* renamed from: y, reason: collision with root package name */
    private static final int[] f17104y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: z, reason: collision with root package name */
    private static final int[] f17105z = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] A = {-1, -16711936, -16776961, -16711681, FlowLayout.SPACING_AUTO, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, 109, 110, 111, 112, 113, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, Sdk$SDKError.Reason.INVALID_INDEX_URL_VALUE, Sdk$SDKError.Reason.GZIP_ENCODE_ERROR_VALUE, Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, Sdk$SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 120, Sdk$SDKError.Reason.TPAT_ERROR_VALUE, Sdk$SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 231, 247, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 241, 9632};
    private static final int[] C = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] D = {193, 201, 211, Sdk$SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, Sdk$SDKError.Reason.AD_CONSUMED_VALUE, Sdk$SDKError.Reason.AD_IS_LOADING_VALUE, 235, Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE, Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE, 239, Sdk$SDKError.Reason.PLACEMENT_SLEEP_VALUE, Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE, 249, Sdk$SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 171, 187};
    private static final int[] E = {195, 227, Sdk$SDKError.Reason.AD_IS_PLAYING_VALUE, Sdk$SDKError.Reason.AD_ALREADY_LOADED_VALUE, 236, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, 242, Sdk$SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 245, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 92, 94, 95, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 126, 196, 228, Sdk$SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, 246, Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 165, 164, 9474, 197, 229, Sdk$SDKError.Reason.AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: g, reason: collision with root package name */
    private final d0 f17106g = new d0();

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList f17111l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private C0169a f17112m = new C0169a(0, 4);

    /* renamed from: v, reason: collision with root package name */
    private int f17121v = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ca.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0169a {

        /* renamed from: a, reason: collision with root package name */
        private final List f17124a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final List f17125b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private final StringBuilder f17126c = new StringBuilder();

        /* renamed from: d, reason: collision with root package name */
        private int f17127d;

        /* renamed from: e, reason: collision with root package name */
        private int f17128e;

        /* renamed from: f, reason: collision with root package name */
        private int f17129f;

        /* renamed from: g, reason: collision with root package name */
        private int f17130g;

        /* renamed from: h, reason: collision with root package name */
        private int f17131h;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ca.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0170a {

            /* renamed from: a, reason: collision with root package name */
            public final int f17132a;

            /* renamed from: b, reason: collision with root package name */
            public final boolean f17133b;

            /* renamed from: c, reason: collision with root package name */
            public int f17134c;

            public C0170a(int i11, boolean z10, int i12) {
                this.f17132a = i11;
                this.f17133b = z10;
                this.f17134c = i12;
            }
        }

        public C0169a(int i11, int i12) {
            j(i11);
            this.f17131h = i12;
        }

        private SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f17126c);
            int length = spannableStringBuilder.length();
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = 0;
            int i16 = 0;
            boolean z10 = false;
            while (i15 < this.f17124a.size()) {
                C0170a c0170a = (C0170a) this.f17124a.get(i15);
                boolean z11 = c0170a.f17133b;
                int i17 = c0170a.f17132a;
                if (i17 != 8) {
                    boolean z12 = i17 == 7;
                    if (i17 != 7) {
                        i14 = a.A[i17];
                    }
                    z10 = z12;
                }
                int i18 = c0170a.f17134c;
                i15++;
                if (i18 != (i15 < this.f17124a.size() ? ((C0170a) this.f17124a.get(i15)).f17134c : length)) {
                    if (i11 != -1 && !z11) {
                        q(spannableStringBuilder, i11, i18);
                        i11 = -1;
                    } else if (i11 == -1 && z11) {
                        i11 = i18;
                    }
                    if (i12 != -1 && !z10) {
                        o(spannableStringBuilder, i12, i18);
                        i12 = -1;
                    } else if (i12 == -1 && z10) {
                        i12 = i18;
                    }
                    if (i14 != i13) {
                        n(spannableStringBuilder, i16, i18, i13);
                        i13 = i14;
                        i16 = i18;
                    }
                }
            }
            if (i11 != -1 && i11 != length) {
                q(spannableStringBuilder, i11, length);
            }
            if (i12 != -1 && i12 != length) {
                o(spannableStringBuilder, i12, length);
            }
            if (i16 != length) {
                n(spannableStringBuilder, i16, length, i13);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13) {
            if (i13 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i13), i11, i12, 33);
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i11, i12, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
        }

        public void e(char c11) {
            if (this.f17126c.length() < 32) {
                this.f17126c.append(c11);
            }
        }

        public void f() {
            int length = this.f17126c.length();
            if (length > 0) {
                this.f17126c.delete(length - 1, length);
                for (int size = this.f17124a.size() - 1; size >= 0; size--) {
                    C0170a c0170a = (C0170a) this.f17124a.get(size);
                    int i11 = c0170a.f17134c;
                    if (i11 != length) {
                        return;
                    }
                    c0170a.f17134c = i11 - 1;
                }
            }
        }

        public ba.b g(int i11) {
            float f11;
            int i12 = this.f17128e + this.f17129f;
            int i13 = 32 - i12;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i14 = 0; i14 < this.f17125b.size(); i14++) {
                spannableStringBuilder.append(p0.c1((CharSequence) this.f17125b.get(i14), i13));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(p0.c1(h(), i13));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i13 - spannableStringBuilder.length();
            int i15 = i12 - length;
            if (i11 == Integer.MIN_VALUE) {
                i11 = (this.f17130g != 2 || (Math.abs(i15) >= 3 && length >= 0)) ? (this.f17130g != 2 || i15 <= 0) ? 0 : 2 : 1;
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    i12 = 32 - length;
                }
                f11 = ((i12 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f11 = 0.5f;
            }
            int i16 = this.f17127d;
            if (i16 > 7) {
                i16 -= 17;
            } else if (this.f17130g == 1) {
                i16 -= this.f17131h - 1;
            }
            return new b.C0151b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i16, 1).k(f11).l(i11).a();
        }

        public boolean i() {
            return this.f17124a.isEmpty() && this.f17125b.isEmpty() && this.f17126c.length() == 0;
        }

        public void j(int i11) {
            this.f17130g = i11;
            this.f17124a.clear();
            this.f17125b.clear();
            this.f17126c.setLength(0);
            this.f17127d = 15;
            this.f17128e = 0;
            this.f17129f = 0;
        }

        public void k() {
            this.f17125b.add(h());
            this.f17126c.setLength(0);
            this.f17124a.clear();
            int min = Math.min(this.f17131h, this.f17127d);
            while (this.f17125b.size() >= min) {
                this.f17125b.remove(0);
            }
        }

        public void l(int i11) {
            this.f17130g = i11;
        }

        public void m(int i11) {
            this.f17131h = i11;
        }

        public void p(int i11, boolean z10) {
            this.f17124a.add(new C0170a(i11, z10, this.f17126c.length()));
        }
    }

    public a(String str, int i11, long j11) {
        this.f17110k = j11 > 0 ? j11 * 1000 : -9223372036854775807L;
        this.f17107h = MimeTypes.APPLICATION_MP4CEA608.equals(str) ? 2 : 3;
        if (i11 == 1) {
            this.f17109j = 0;
            this.f17108i = 0;
        } else if (i11 == 2) {
            this.f17109j = 1;
            this.f17108i = 0;
        } else if (i11 == 3) {
            this.f17109j = 0;
            this.f17108i = 1;
        } else if (i11 != 4) {
            s.i("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f17109j = 0;
            this.f17108i = 0;
        } else {
            this.f17109j = 1;
            this.f17108i = 1;
        }
        I(0);
        H();
        this.f17122w = true;
        this.f17123x = C.TIME_UNSET;
    }

    private static boolean A(byte b11) {
        return (b11 & 240) == 16;
    }

    private boolean B(boolean z10, byte b11, byte b12) {
        if (!z10 || !A(b11)) {
            this.f17118s = false;
        } else {
            if (this.f17118s && this.f17119t == b11 && this.f17120u == b12) {
                this.f17118s = false;
                return true;
            }
            this.f17118s = true;
            this.f17119t = b11;
            this.f17120u = b12;
        }
        return false;
    }

    private static boolean C(byte b11) {
        return (b11 & 247) == 20;
    }

    private static boolean D(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 48;
    }

    private static boolean E(byte b11, byte b12) {
        return (b11 & 247) == 23 && b12 >= 33 && b12 <= 35;
    }

    private static boolean F(byte b11) {
        return 1 <= b11 && b11 <= 15;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0018. Please report as an issue. */
    private void G(byte b11, byte b12) {
        if (F(b11)) {
            this.f17122w = false;
            return;
        }
        if (C(b11)) {
            if (b12 != 32 && b12 != 47) {
                switch (b12) {
                    default:
                        switch (b12) {
                            case 41:
                                break;
                            case 42:
                            case 43:
                                this.f17122w = false;
                                return;
                            default:
                                return;
                        }
                    case 37:
                    case 38:
                    case 39:
                        this.f17122w = true;
                }
            }
            this.f17122w = true;
        }
    }

    private void H() {
        this.f17112m.j(this.f17115p);
        this.f17111l.clear();
        this.f17111l.add(this.f17112m);
    }

    private void I(int i11) {
        int i12 = this.f17115p;
        if (i12 == i11) {
            return;
        }
        this.f17115p = i11;
        if (i11 == 3) {
            for (int i13 = 0; i13 < this.f17111l.size(); i13++) {
                ((C0169a) this.f17111l.get(i13)).l(i11);
            }
            return;
        }
        H();
        if (i12 == 3 || i11 == 1 || i11 == 0) {
            this.f17113n = Collections.emptyList();
        }
    }

    private void J(int i11) {
        this.f17116q = i11;
        this.f17112m.m(i11);
    }

    private boolean K() {
        return (this.f17110k == C.TIME_UNSET || this.f17123x == C.TIME_UNSET || f() - this.f17123x < this.f17110k) ? false : true;
    }

    private boolean L(byte b11) {
        if (v(b11)) {
            this.f17121v = m(b11);
        }
        return this.f17121v == this.f17109j;
    }

    private static char l(byte b11) {
        return (char) B[(b11 & Byte.MAX_VALUE) - 32];
    }

    private static int m(byte b11) {
        return (b11 >> 3) & 1;
    }

    private List n() {
        int size = this.f17111l.size();
        ArrayList arrayList = new ArrayList(size);
        int i11 = 2;
        for (int i12 = 0; i12 < size; i12++) {
            ba.b g11 = ((C0169a) this.f17111l.get(i12)).g(Integer.MIN_VALUE);
            arrayList.add(g11);
            if (g11 != null) {
                i11 = Math.min(i11, g11.f16341i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i13 = 0; i13 < size; i13++) {
            ba.b bVar = (ba.b) arrayList.get(i13);
            if (bVar != null) {
                if (bVar.f16341i != i11) {
                    bVar = (ba.b) com.google.android.exoplayer2.util.a.e(((C0169a) this.f17111l.get(i13)).g(i11));
                }
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    private static char o(byte b11) {
        return (char) D[b11 & 31];
    }

    private static char p(byte b11) {
        return (char) E[b11 & 31];
    }

    private static char q(byte b11, byte b12) {
        return (b11 & 1) == 0 ? o(b12) : p(b12);
    }

    private static char r(byte b11) {
        return (char) C[b11 & 15];
    }

    private void s(byte b11) {
        this.f17112m.e(' ');
        this.f17112m.p((b11 >> 1) & 7, (b11 & 1) == 1);
    }

    private void t(byte b11) {
        if (b11 == 32) {
            I(2);
            return;
        }
        if (b11 == 41) {
            I(3);
            return;
        }
        switch (b11) {
            case 37:
                I(1);
                J(2);
                return;
            case 38:
                I(1);
                J(3);
                return;
            case 39:
                I(1);
                J(4);
                return;
            default:
                int i11 = this.f17115p;
                if (i11 == 0) {
                    return;
                }
                if (b11 == 33) {
                    this.f17112m.f();
                    return;
                }
                switch (b11) {
                    case 44:
                        this.f17113n = Collections.emptyList();
                        int i12 = this.f17115p;
                        if (i12 == 1 || i12 == 3) {
                            H();
                            return;
                        }
                        return;
                    case 45:
                        if (i11 != 1 || this.f17112m.i()) {
                            return;
                        }
                        this.f17112m.k();
                        return;
                    case 46:
                        H();
                        return;
                    case 47:
                        this.f17113n = n();
                        H();
                        return;
                    default:
                        return;
                }
        }
    }

    private void u(byte b11, byte b12) {
        int i11 = f17104y[b11 & 7];
        if ((b12 & 32) != 0) {
            i11++;
        }
        if (i11 != this.f17112m.f17127d) {
            if (this.f17115p != 1 && !this.f17112m.i()) {
                C0169a c0169a = new C0169a(this.f17115p, this.f17116q);
                this.f17112m = c0169a;
                this.f17111l.add(c0169a);
            }
            this.f17112m.f17127d = i11;
        }
        boolean z10 = (b12 & 16) == 16;
        boolean z11 = (b12 & 1) == 1;
        int i12 = (b12 >> 1) & 7;
        this.f17112m.p(z10 ? 8 : i12, z11);
        if (z10) {
            this.f17112m.f17128e = f17105z[i12];
        }
    }

    private static boolean v(byte b11) {
        return (b11 & 224) == 0;
    }

    private static boolean w(byte b11, byte b12) {
        return (b11 & 246) == 18 && (b12 & 224) == 32;
    }

    private static boolean x(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 32;
    }

    private static boolean y(byte b11, byte b12) {
        return (b11 & 246) == 20 && (b12 & 240) == 32;
    }

    private static boolean z(byte b11, byte b12) {
        return (b11 & 240) == 16 && (b12 & 192) == 64;
    }

    @Override // ca.e
    protected i a() {
        List list = this.f17113n;
        this.f17114o = list;
        return new f((List) com.google.android.exoplayer2.util.a.e(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0017 A[SYNTHETIC] */
    @Override // ca.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void b(ba.m r10) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.a.b(ba.m):void");
    }

    @Override // ca.e
    /* renamed from: c */
    public /* bridge */ /* synthetic */ m dequeueInputBuffer() {
        return super.dequeueInputBuffer();
    }

    @Override // ca.e, com.google.android.exoplayer2.decoder.d
    /* renamed from: d */
    public n dequeueOutputBuffer() {
        n e11;
        n dequeueOutputBuffer = super.dequeueOutputBuffer();
        if (dequeueOutputBuffer != null) {
            return dequeueOutputBuffer;
        }
        if (!K() || (e11 = e()) == null) {
            return null;
        }
        this.f17113n = Collections.emptyList();
        this.f17123x = C.TIME_UNSET;
        e11.m(f(), a(), Long.MAX_VALUE);
        return e11;
    }

    @Override // ca.e, com.google.android.exoplayer2.decoder.d
    public void flush() {
        super.flush();
        this.f17113n = null;
        this.f17114o = null;
        I(0);
        J(4);
        H();
        this.f17117r = false;
        this.f17118s = false;
        this.f17119t = (byte) 0;
        this.f17120u = (byte) 0;
        this.f17121v = 0;
        this.f17122w = true;
        this.f17123x = C.TIME_UNSET;
    }

    @Override // ca.e
    protected boolean g() {
        return this.f17113n != this.f17114o;
    }

    @Override // ca.e
    /* renamed from: h */
    public /* bridge */ /* synthetic */ void queueInputBuffer(m mVar) {
        super.queueInputBuffer(mVar);
    }

    @Override // ca.e, com.google.android.exoplayer2.decoder.d
    public void release() {
    }

    @Override // ca.e, ba.j
    public /* bridge */ /* synthetic */ void setPositionUs(long j11) {
        super.setPositionUs(j11);
    }
}
