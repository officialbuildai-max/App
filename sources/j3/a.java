package j3;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.view.InputDeviceCompat;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tn.lib.view.FlowLayout;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import i3.k;
import i3.o;
import i3.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u1.a;

/* loaded from: classes2.dex */
public final class a extends e {

    /* renamed from: i, reason: collision with root package name */
    private final int f65980i;

    /* renamed from: j, reason: collision with root package name */
    private final int f65981j;

    /* renamed from: k, reason: collision with root package name */
    private final int f65982k;

    /* renamed from: l, reason: collision with root package name */
    private final long f65983l;

    /* renamed from: o, reason: collision with root package name */
    private List f65986o;

    /* renamed from: p, reason: collision with root package name */
    private List f65987p;

    /* renamed from: q, reason: collision with root package name */
    private int f65988q;

    /* renamed from: r, reason: collision with root package name */
    private int f65989r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f65990s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f65991t;

    /* renamed from: u, reason: collision with root package name */
    private byte f65992u;

    /* renamed from: v, reason: collision with root package name */
    private byte f65993v;

    /* renamed from: x, reason: collision with root package name */
    private boolean f65995x;

    /* renamed from: y, reason: collision with root package name */
    private long f65996y;

    /* renamed from: z, reason: collision with root package name */
    private static final int[] f65978z = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] A = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] B = {-1, -16711936, -16776961, -16711681, FlowLayout.SPACING_AUTO, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] C = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, 109, 110, 111, 112, 113, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, Sdk$SDKError.Reason.INVALID_INDEX_URL_VALUE, Sdk$SDKError.Reason.GZIP_ENCODE_ERROR_VALUE, Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, Sdk$SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 120, Sdk$SDKError.Reason.TPAT_ERROR_VALUE, Sdk$SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 231, 247, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 241, 9632};
    private static final int[] D = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] E = {193, 201, 211, Sdk$SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, Sdk$SDKError.Reason.AD_CONSUMED_VALUE, Sdk$SDKError.Reason.AD_IS_LOADING_VALUE, 235, Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE, Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE, 239, Sdk$SDKError.Reason.PLACEMENT_SLEEP_VALUE, Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE, 249, Sdk$SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 171, 187};
    private static final int[] F = {195, 227, Sdk$SDKError.Reason.AD_IS_PLAYING_VALUE, Sdk$SDKError.Reason.AD_ALREADY_LOADED_VALUE, 236, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, 242, Sdk$SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 245, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 92, 94, 95, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 126, 196, 228, Sdk$SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, 246, Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 165, 164, 9474, 197, 229, Sdk$SDKError.Reason.AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] G = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: h, reason: collision with root package name */
    private final j0 f65979h = new j0();

    /* renamed from: m, reason: collision with root package name */
    private final ArrayList f65984m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    private C0824a f65985n = new C0824a(0, 4);

    /* renamed from: w, reason: collision with root package name */
    private int f65994w = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j3.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0824a {

        /* renamed from: a, reason: collision with root package name */
        private final List f65997a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final List f65998b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private final StringBuilder f65999c = new StringBuilder();

        /* renamed from: d, reason: collision with root package name */
        private int f66000d;

        /* renamed from: e, reason: collision with root package name */
        private int f66001e;

        /* renamed from: f, reason: collision with root package name */
        private int f66002f;

        /* renamed from: g, reason: collision with root package name */
        private int f66003g;

        /* renamed from: h, reason: collision with root package name */
        private int f66004h;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0825a {

            /* renamed from: a, reason: collision with root package name */
            public final int f66005a;

            /* renamed from: b, reason: collision with root package name */
            public final boolean f66006b;

            /* renamed from: c, reason: collision with root package name */
            public int f66007c;

            public C0825a(int i11, boolean z10, int i12) {
                this.f66005a = i11;
                this.f66006b = z10;
                this.f66007c = i12;
            }
        }

        public C0824a(int i11, int i12) {
            j(i11);
            this.f66004h = i12;
        }

        private SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f65999c);
            int length = spannableStringBuilder.length();
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = 0;
            int i16 = 0;
            boolean z10 = false;
            while (i15 < this.f65997a.size()) {
                C0825a c0825a = (C0825a) this.f65997a.get(i15);
                boolean z11 = c0825a.f66006b;
                int i17 = c0825a.f66005a;
                if (i17 != 8) {
                    boolean z12 = i17 == 7;
                    if (i17 != 7) {
                        i14 = a.B[i17];
                    }
                    z10 = z12;
                }
                int i18 = c0825a.f66007c;
                i15++;
                if (i18 != (i15 < this.f65997a.size() ? ((C0825a) this.f65997a.get(i15)).f66007c : length)) {
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
            if (this.f65999c.length() < 32) {
                this.f65999c.append(c11);
            }
        }

        public void f() {
            int length = this.f65999c.length();
            if (length > 0) {
                this.f65999c.delete(length - 1, length);
                for (int size = this.f65997a.size() - 1; size >= 0; size--) {
                    C0825a c0825a = (C0825a) this.f65997a.get(size);
                    int i11 = c0825a.f66007c;
                    if (i11 != length) {
                        return;
                    }
                    c0825a.f66007c = i11 - 1;
                }
            }
        }

        public u1.a g(int i11) {
            float f11;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i12 = 0; i12 < this.f65998b.size(); i12++) {
                spannableStringBuilder.append((CharSequence) this.f65998b.get(i12));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) h());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i13 = this.f66001e + this.f66002f;
            int length = (32 - i13) - spannableStringBuilder.length();
            int i14 = i13 - length;
            if (i11 == Integer.MIN_VALUE) {
                i11 = (this.f66003g != 2 || (Math.abs(i14) >= 3 && length >= 0)) ? (this.f66003g != 2 || i14 <= 0) ? 0 : 2 : 1;
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    i13 = 32 - length;
                }
                f11 = ((i13 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f11 = 0.5f;
            }
            int i15 = this.f66000d;
            if (i15 > 7) {
                i15 -= 17;
            } else if (this.f66003g == 1) {
                i15 -= this.f66004h - 1;
            }
            return new a.b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i15, 1).k(f11).l(i11).a();
        }

        public boolean i() {
            return this.f65997a.isEmpty() && this.f65998b.isEmpty() && this.f65999c.length() == 0;
        }

        public void j(int i11) {
            this.f66003g = i11;
            this.f65997a.clear();
            this.f65998b.clear();
            this.f65999c.setLength(0);
            this.f66000d = 15;
            this.f66001e = 0;
            this.f66002f = 0;
        }

        public void k() {
            this.f65998b.add(h());
            this.f65999c.setLength(0);
            this.f65997a.clear();
            int min = Math.min(this.f66004h, this.f66000d);
            while (this.f65998b.size() >= min) {
                this.f65998b.remove(0);
            }
        }

        public void l(int i11) {
            this.f66003g = i11;
        }

        public void m(int i11) {
            this.f66004h = i11;
        }

        public void p(int i11, boolean z10) {
            this.f65997a.add(new C0825a(i11, z10, this.f65999c.length()));
        }
    }

    public a(String str, int i11, long j11) {
        if (j11 != C.TIME_UNSET) {
            androidx.media3.common.util.a.a(j11 >= 16000);
            this.f65983l = j11 * 1000;
        } else {
            this.f65983l = C.TIME_UNSET;
        }
        this.f65980i = MimeTypes.APPLICATION_MP4CEA608.equals(str) ? 2 : 3;
        if (i11 == 1) {
            this.f65982k = 0;
            this.f65981j = 0;
        } else if (i11 == 2) {
            this.f65982k = 1;
            this.f65981j = 0;
        } else if (i11 == 3) {
            this.f65982k = 0;
            this.f65981j = 1;
        } else if (i11 != 4) {
            u.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f65982k = 0;
            this.f65981j = 0;
        } else {
            this.f65982k = 1;
            this.f65981j = 1;
        }
        K(0);
        J();
        this.f65995x = true;
        this.f65996y = C.TIME_UNSET;
    }

    private static boolean A(byte b11, byte b12) {
        return (b11 & 246) == 20 && (b12 & 240) == 32;
    }

    private static boolean B(byte b11, byte b12) {
        return (b11 & 240) == 16 && (b12 & 192) == 64;
    }

    private static boolean C(byte b11) {
        return (b11 & 240) == 16;
    }

    private boolean D(boolean z10, byte b11, byte b12) {
        if (!z10 || !C(b11)) {
            this.f65991t = false;
        } else {
            if (this.f65991t && this.f65992u == b11 && this.f65993v == b12) {
                this.f65991t = false;
                return true;
            }
            this.f65991t = true;
            this.f65992u = b11;
            this.f65993v = b12;
        }
        return false;
    }

    private static boolean E(byte b11) {
        return (b11 & 246) == 20;
    }

    private static boolean F(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 48;
    }

    private static boolean G(byte b11, byte b12) {
        return (b11 & 247) == 23 && b12 >= 33 && b12 <= 35;
    }

    private static boolean H(byte b11) {
        return 1 <= b11 && b11 <= 15;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0018. Please report as an issue. */
    private void I(byte b11, byte b12) {
        if (H(b11)) {
            this.f65995x = false;
            return;
        }
        if (E(b11)) {
            if (b12 != 32 && b12 != 47) {
                switch (b12) {
                    default:
                        switch (b12) {
                            case 41:
                                break;
                            case 42:
                            case 43:
                                this.f65995x = false;
                                return;
                            default:
                                return;
                        }
                    case 37:
                    case 38:
                    case 39:
                        this.f65995x = true;
                }
            }
            this.f65995x = true;
        }
    }

    private void J() {
        this.f65985n.j(this.f65988q);
        this.f65984m.clear();
        this.f65984m.add(this.f65985n);
    }

    private void K(int i11) {
        int i12 = this.f65988q;
        if (i12 == i11) {
            return;
        }
        this.f65988q = i11;
        if (i11 == 3) {
            for (int i13 = 0; i13 < this.f65984m.size(); i13++) {
                ((C0824a) this.f65984m.get(i13)).l(i11);
            }
            return;
        }
        J();
        if (i12 == 3 || i11 == 1 || i11 == 0) {
            this.f65986o = Collections.emptyList();
        }
    }

    private void L(int i11) {
        this.f65989r = i11;
        this.f65985n.m(i11);
    }

    private boolean M() {
        return (this.f65983l == C.TIME_UNSET || this.f65996y == C.TIME_UNSET || h() - this.f65996y < this.f65983l) ? false : true;
    }

    private boolean N(byte b11) {
        if (x(b11)) {
            this.f65994w = o(b11);
        }
        return this.f65994w == this.f65982k;
    }

    private static char n(byte b11) {
        return (char) C[(b11 & Byte.MAX_VALUE) - 32];
    }

    private static int o(byte b11) {
        return (b11 >> 3) & 1;
    }

    private List p() {
        int size = this.f65984m.size();
        ArrayList arrayList = new ArrayList(size);
        int i11 = 2;
        for (int i12 = 0; i12 < size; i12++) {
            u1.a g11 = ((C0824a) this.f65984m.get(i12)).g(Integer.MIN_VALUE);
            arrayList.add(g11);
            if (g11 != null) {
                i11 = Math.min(i11, g11.f76689i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i13 = 0; i13 < size; i13++) {
            u1.a aVar = (u1.a) arrayList.get(i13);
            if (aVar != null) {
                if (aVar.f76689i != i11) {
                    aVar = (u1.a) androidx.media3.common.util.a.e(((C0824a) this.f65984m.get(i13)).g(i11));
                }
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    private static char q(byte b11) {
        return (char) E[b11 & 31];
    }

    private static char r(byte b11) {
        return (char) F[b11 & 31];
    }

    private static char s(byte b11, byte b12) {
        return (b11 & 1) == 0 ? q(b12) : r(b12);
    }

    private static char t(byte b11) {
        return (char) D[b11 & 15];
    }

    private void u(byte b11) {
        this.f65985n.e(' ');
        this.f65985n.p((b11 >> 1) & 7, (b11 & 1) == 1);
    }

    private void v(byte b11) {
        if (b11 == 32) {
            K(2);
            return;
        }
        if (b11 == 41) {
            K(3);
            return;
        }
        switch (b11) {
            case 37:
                K(1);
                L(2);
                return;
            case 38:
                K(1);
                L(3);
                return;
            case 39:
                K(1);
                L(4);
                return;
            default:
                int i11 = this.f65988q;
                if (i11 == 0) {
                    return;
                }
                if (b11 == 33) {
                    this.f65985n.f();
                    return;
                }
                switch (b11) {
                    case 44:
                        this.f65986o = Collections.emptyList();
                        int i12 = this.f65988q;
                        if (i12 == 1 || i12 == 3) {
                            J();
                            return;
                        }
                        return;
                    case 45:
                        if (i11 != 1 || this.f65985n.i()) {
                            return;
                        }
                        this.f65985n.k();
                        return;
                    case 46:
                        J();
                        return;
                    case 47:
                        this.f65986o = p();
                        J();
                        return;
                    default:
                        return;
                }
        }
    }

    private void w(byte b11, byte b12) {
        int i11 = f65978z[b11 & 7];
        if ((b12 & 32) != 0) {
            i11++;
        }
        if (i11 != this.f65985n.f66000d) {
            if (this.f65988q != 1 && !this.f65985n.i()) {
                C0824a c0824a = new C0824a(this.f65988q, this.f65989r);
                this.f65985n = c0824a;
                this.f65984m.add(c0824a);
            }
            this.f65985n.f66000d = i11;
        }
        boolean z10 = (b12 & 16) == 16;
        boolean z11 = (b12 & 1) == 1;
        int i12 = (b12 >> 1) & 7;
        this.f65985n.p(z10 ? 8 : i12, z11);
        if (z10) {
            this.f65985n.f66001e = A[i12];
        }
    }

    private static boolean x(byte b11) {
        return (b11 & 224) == 0;
    }

    private static boolean y(byte b11, byte b12) {
        return (b11 & 246) == 18 && (b12 & 224) == 32;
    }

    private static boolean z(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 32;
    }

    @Override // j3.e
    protected k c() {
        List list = this.f65986o;
        this.f65987p = list;
        return new f((List) androidx.media3.common.util.a.e(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0017 A[SYNTHETIC] */
    @Override // j3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void d(i3.o r10) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.a.d(i3.o):void");
    }

    @Override // j3.e
    /* renamed from: e */
    public /* bridge */ /* synthetic */ o dequeueInputBuffer() {
        return super.dequeueInputBuffer();
    }

    @Override // j3.e, androidx.media3.decoder.g
    /* renamed from: f */
    public p dequeueOutputBuffer() {
        p g11;
        p dequeueOutputBuffer = super.dequeueOutputBuffer();
        if (dequeueOutputBuffer != null) {
            return dequeueOutputBuffer;
        }
        if (!M() || (g11 = g()) == null) {
            return null;
        }
        this.f65986o = Collections.emptyList();
        this.f65996y = C.TIME_UNSET;
        g11.a(h(), c(), Long.MAX_VALUE);
        return g11;
    }

    @Override // j3.e, androidx.media3.decoder.g
    public void flush() {
        super.flush();
        this.f65986o = null;
        this.f65987p = null;
        K(0);
        L(4);
        J();
        this.f65990s = false;
        this.f65991t = false;
        this.f65992u = (byte) 0;
        this.f65993v = (byte) 0;
        this.f65994w = 0;
        this.f65995x = true;
        this.f65996y = C.TIME_UNSET;
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "Cea608Decoder";
    }

    @Override // j3.e
    protected boolean i() {
        return this.f65986o != this.f65987p;
    }

    @Override // j3.e
    /* renamed from: j */
    public /* bridge */ /* synthetic */ void queueInputBuffer(o oVar) {
        super.queueInputBuffer(oVar);
    }

    @Override // j3.e, androidx.media3.decoder.g
    public void release() {
    }

    @Override // j3.e, i3.l
    public /* bridge */ /* synthetic */ void setPositionUs(long j11) {
        super.setPositionUs(j11);
    }
}
