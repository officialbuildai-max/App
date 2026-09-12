package d3;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.i;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;
import androidx.media3.common.util.v;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import l2.h;
import l2.l0;
import l2.m0;
import l2.q;
import l2.r;
import l2.s0;
import l2.t;
import l2.t0;
import l2.w;
import l2.x;
import org.mvel2.ast.ASTNode;

/* loaded from: classes2.dex */
public class e implements r {

    /* renamed from: f0, reason: collision with root package name */
    public static final x f61278f0 = new x() { // from class: d3.d
        @Override // l2.x
        public /* synthetic */ x a(s.a aVar) {
            return w.d(this, aVar);
        }

        @Override // l2.x
        public /* synthetic */ x b(int i11) {
            return w.b(this, i11);
        }

        @Override // l2.x
        public /* synthetic */ r[] c(Uri uri, Map map) {
            return w.a(this, uri, map);
        }

        @Override // l2.x
        public final r[] createExtractors() {
            r[] B;
            B = e.B();
            return B;
        }

        @Override // l2.x
        public /* synthetic */ x d(boolean z10) {
            return w.c(this, z10);
        }
    };

    /* renamed from: g0, reason: collision with root package name */
    private static final byte[] f61279g0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: h0, reason: collision with root package name */
    private static final byte[] f61280h0 = a1.u0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: i0, reason: collision with root package name */
    private static final byte[] f61281i0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: j0, reason: collision with root package name */
    private static final byte[] f61282j0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};

    /* renamed from: k0, reason: collision with root package name */
    private static final UUID f61283k0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* renamed from: l0, reason: collision with root package name */
    private static final Map f61284l0;
    private long A;
    private boolean B;
    private long C;
    private long D;
    private long E;
    private v F;
    private v G;
    private boolean H;
    private boolean I;
    private int J;
    private long K;
    private long L;
    private int M;
    private int N;
    private int[] O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private boolean T;
    private long U;
    private int V;
    private int W;
    private int X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a, reason: collision with root package name */
    private final d3.c f61285a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f61286a0;

    /* renamed from: b, reason: collision with root package name */
    private final g f61287b;

    /* renamed from: b0, reason: collision with root package name */
    private int f61288b0;

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray f61289c;

    /* renamed from: c0, reason: collision with root package name */
    private byte f61290c0;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f61291d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f61292d0;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f61293e;

    /* renamed from: e0, reason: collision with root package name */
    private t f61294e0;

    /* renamed from: f, reason: collision with root package name */
    private final s.a f61295f;

    /* renamed from: g, reason: collision with root package name */
    private final j0 f61296g;

    /* renamed from: h, reason: collision with root package name */
    private final j0 f61297h;

    /* renamed from: i, reason: collision with root package name */
    private final j0 f61298i;

    /* renamed from: j, reason: collision with root package name */
    private final j0 f61299j;

    /* renamed from: k, reason: collision with root package name */
    private final j0 f61300k;

    /* renamed from: l, reason: collision with root package name */
    private final j0 f61301l;

    /* renamed from: m, reason: collision with root package name */
    private final j0 f61302m;

    /* renamed from: n, reason: collision with root package name */
    private final j0 f61303n;

    /* renamed from: o, reason: collision with root package name */
    private final j0 f61304o;

    /* renamed from: p, reason: collision with root package name */
    private final j0 f61305p;

    /* renamed from: q, reason: collision with root package name */
    private ByteBuffer f61306q;

    /* renamed from: r, reason: collision with root package name */
    private long f61307r;

    /* renamed from: s, reason: collision with root package name */
    private long f61308s;

    /* renamed from: t, reason: collision with root package name */
    private long f61309t;

    /* renamed from: u, reason: collision with root package name */
    private long f61310u;

    /* renamed from: v, reason: collision with root package name */
    private long f61311v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f61312w;

    /* renamed from: x, reason: collision with root package name */
    private c f61313x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f61314y;

    /* renamed from: z, reason: collision with root package name */
    private int f61315z;

    /* loaded from: classes2.dex */
    private final class b implements d3.b {
        private b() {
        }

        @Override // d3.b
        public void a(int i11, int i12, l2.s sVar) {
            e.this.m(i11, i12, sVar);
        }

        @Override // d3.b
        public void endMasterElement(int i11) {
            e.this.p(i11);
        }

        @Override // d3.b
        public void floatElement(int i11, double d11) {
            e.this.s(i11, d11);
        }

        @Override // d3.b
        public int getElementType(int i11) {
            return e.this.v(i11);
        }

        @Override // d3.b
        public void integerElement(int i11, long j11) {
            e.this.y(i11, j11);
        }

        @Override // d3.b
        public boolean isLevel1Element(int i11) {
            return e.this.A(i11);
        }

        @Override // d3.b
        public void startMasterElement(int i11, long j11, long j12) {
            e.this.H(i11, j11, j12);
        }

        @Override // d3.b
        public void stringElement(int i11, String str) {
            e.this.I(i11, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class c {
        public byte[] P;
        public t0 V;
        public boolean W;
        public s0 Z;

        /* renamed from: a, reason: collision with root package name */
        public boolean f61317a;

        /* renamed from: a0, reason: collision with root package name */
        public int f61318a0;

        /* renamed from: b, reason: collision with root package name */
        public String f61319b;

        /* renamed from: c, reason: collision with root package name */
        public String f61320c;

        /* renamed from: d, reason: collision with root package name */
        public int f61321d;

        /* renamed from: e, reason: collision with root package name */
        public int f61322e;

        /* renamed from: f, reason: collision with root package name */
        public int f61323f;

        /* renamed from: g, reason: collision with root package name */
        public int f61324g;

        /* renamed from: h, reason: collision with root package name */
        private int f61325h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f61326i;

        /* renamed from: j, reason: collision with root package name */
        public byte[] f61327j;

        /* renamed from: k, reason: collision with root package name */
        public s0.a f61328k;

        /* renamed from: l, reason: collision with root package name */
        public byte[] f61329l;

        /* renamed from: m, reason: collision with root package name */
        public DrmInitData f61330m;

        /* renamed from: n, reason: collision with root package name */
        public int f61331n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f61332o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f61333p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f61334q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f61335r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f61336s = 0;

        /* renamed from: t, reason: collision with root package name */
        public int f61337t = -1;

        /* renamed from: u, reason: collision with root package name */
        public float f61338u = 0.0f;

        /* renamed from: v, reason: collision with root package name */
        public float f61339v = 0.0f;

        /* renamed from: w, reason: collision with root package name */
        public float f61340w = 0.0f;

        /* renamed from: x, reason: collision with root package name */
        public byte[] f61341x = null;

        /* renamed from: y, reason: collision with root package name */
        public int f61342y = -1;

        /* renamed from: z, reason: collision with root package name */
        public boolean f61343z = false;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = 1000;
        public int E = 200;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public float N = -1.0f;
        public float O = -1.0f;
        public int Q = 1;
        public int R = -1;
        public int S = 8000;
        public long T = 0;
        public long U = 0;
        public boolean X = true;
        private String Y = "eng";

        protected c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            androidx.media3.common.util.a.e(this.Z);
        }

        private byte[] g(String str) {
            byte[] bArr = this.f61329l;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, null);
        }

        private byte[] h() {
            if (this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f || this.N == -1.0f || this.O == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((this.F * 50000.0f) + 0.5f));
            order.putShort((short) ((this.G * 50000.0f) + 0.5f));
            order.putShort((short) ((this.H * 50000.0f) + 0.5f));
            order.putShort((short) ((this.I * 50000.0f) + 0.5f));
            order.putShort((short) ((this.J * 50000.0f) + 0.5f));
            order.putShort((short) ((this.K * 50000.0f) + 0.5f));
            order.putShort((short) ((this.L * 50000.0f) + 0.5f));
            order.putShort((short) ((this.M * 50000.0f) + 0.5f));
            order.putShort((short) (this.N + 0.5f));
            order.putShort((short) (this.O + 0.5f));
            order.putShort((short) this.D);
            order.putShort((short) this.E);
            return bArr;
        }

        private static Pair k(j0 j0Var) {
            try {
                j0Var.X(16);
                long x10 = j0Var.x();
                if (x10 == 1482049860) {
                    return new Pair("video/divx", null);
                }
                if (x10 == 859189832) {
                    return new Pair(MimeTypes.VIDEO_H263, null);
                }
                if (x10 != 826496599) {
                    u.h("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair(MimeTypes.VIDEO_UNKNOWN, null);
                }
                byte[] e11 = j0Var.e();
                for (int f11 = j0Var.f() + 20; f11 < e11.length - 4; f11++) {
                    if (e11[f11] == 0 && e11[f11 + 1] == 0 && e11[f11 + 2] == 1 && e11[f11 + 3] == 15) {
                        return new Pair(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(e11, f11, e11.length)));
                    }
                }
                throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }

        private static boolean l(j0 j0Var) {
            try {
                int z10 = j0Var.z();
                if (z10 == 1) {
                    return true;
                }
                if (z10 != 65534) {
                    return false;
                }
                j0Var.W(24);
                if (j0Var.A() == e.f61283k0.getMostSignificantBits()) {
                    if (j0Var.A() == e.f61283k0.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
            }
        }

        private static List m(byte[] bArr) {
            int i11;
            int i12;
            try {
                if (bArr[0] != 2) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i13 = 0;
                int i14 = 1;
                while (true) {
                    i11 = bArr[i14];
                    if ((i11 & 255) != 255) {
                        break;
                    }
                    i13 += 255;
                    i14++;
                }
                int i15 = i14 + 1;
                int i16 = i13 + (i11 & 255);
                int i17 = 0;
                while (true) {
                    i12 = bArr[i15];
                    if ((i12 & 255) != 255) {
                        break;
                    }
                    i17 += 255;
                    i15++;
                }
                int i18 = i15 + 1;
                int i19 = i17 + (i12 & 255);
                if (bArr[i18] != 1) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i16];
                System.arraycopy(bArr, i18, bArr2, 0, i16);
                int i20 = i18 + i16;
                if (bArr[i20] != 3) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i21 = i20 + i19;
                if (bArr[i21] != 5) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i21];
                System.arraycopy(bArr, i21, bArr3, 0, bArr.length - i21);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean o(boolean z10) {
            return "A_OPUS".equals(this.f61320c) ? z10 : this.f61324g > 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x01dd. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0453  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x046c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x047b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x05b8  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x05d3  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x05d6  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x048d  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x046e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i(l2.t r20, int r21) {
            /*
                Method dump skipped, instructions count: 1754
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: d3.e.c.i(l2.t, int):void");
        }

        public void j() {
            t0 t0Var = this.V;
            if (t0Var != null) {
                t0Var.a(this.Z, this.f61328k);
            }
        }

        public void n() {
            t0 t0Var = this.V;
            if (t0Var != null) {
                t0Var.b();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        f61284l0 = Collections.unmodifiableMap(hashMap);
    }

    @Deprecated
    public e() {
        this(new d3.a(), 2, s.a.f65046a);
    }

    e(d3.c cVar, int i11, s.a aVar) {
        this.f61308s = -1L;
        this.f61309t = C.TIME_UNSET;
        this.f61310u = C.TIME_UNSET;
        this.f61311v = C.TIME_UNSET;
        this.C = -1L;
        this.D = -1L;
        this.E = C.TIME_UNSET;
        this.f61285a = cVar;
        cVar.b(new b());
        this.f61295f = aVar;
        this.f61291d = (i11 & 1) == 0;
        this.f61293e = (i11 & 2) == 0;
        this.f61287b = new g();
        this.f61289c = new SparseArray();
        this.f61298i = new j0(4);
        this.f61299j = new j0(ByteBuffer.allocate(4).putInt(-1).array());
        this.f61300k = new j0(4);
        this.f61296g = new j0(androidx.media3.container.g.f10675a);
        this.f61297h = new j0(4);
        this.f61301l = new j0();
        this.f61302m = new j0();
        this.f61303n = new j0(8);
        this.f61304o = new j0();
        this.f61305p = new j0();
        this.O = new int[1];
    }

    public e(s.a aVar, int i11) {
        this(new d3.a(), i11, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r[] B() {
        return new r[]{new e(s.a.f65046a, 2)};
    }

    private boolean C(l0 l0Var, long j11) {
        if (this.B) {
            this.D = j11;
            l0Var.f68743a = this.C;
            this.B = false;
            return true;
        }
        if (this.f61314y) {
            long j12 = this.D;
            if (j12 != -1) {
                l0Var.f68743a = j12;
                this.D = -1L;
                return true;
            }
        }
        return false;
    }

    private void D(l2.s sVar, int i11) {
        if (this.f61298i.g() >= i11) {
            return;
        }
        if (this.f61298i.b() < i11) {
            j0 j0Var = this.f61298i;
            j0Var.c(Math.max(j0Var.b() * 2, i11));
        }
        sVar.readFully(this.f61298i.e(), this.f61298i.g(), i11 - this.f61298i.g());
        this.f61298i.V(i11);
    }

    private void E() {
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = false;
        this.Z = false;
        this.f61286a0 = false;
        this.f61288b0 = 0;
        this.f61290c0 = (byte) 0;
        this.f61292d0 = false;
        this.f61301l.S(0);
    }

    private long F(long j11) {
        long j12 = this.f61309t;
        if (j12 != C.TIME_UNSET) {
            return a1.e1(j11, j12, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private static void G(String str, long j11, byte[] bArr) {
        byte[] t11;
        int i11;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    c11 = 0;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                t11 = t(j11, "%01d:%02d:%02d:%02d", 10000L);
                i11 = 21;
                break;
            case 1:
                t11 = t(j11, "%02d:%02d:%02d.%03d", 1000L);
                i11 = 25;
                break;
            case 2:
                t11 = t(j11, "%02d:%02d:%02d,%03d", 1000L);
                i11 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(t11, 0, bArr, i11, t11.length);
    }

    private int J(l2.s sVar, c cVar, int i11, boolean z10) {
        int i12;
        if ("S_TEXT/UTF8".equals(cVar.f61320c)) {
            K(sVar, f61279g0, i11);
            return r();
        }
        if ("S_TEXT/ASS".equals(cVar.f61320c)) {
            K(sVar, f61281i0, i11);
            return r();
        }
        if ("S_TEXT/WEBVTT".equals(cVar.f61320c)) {
            K(sVar, f61282j0, i11);
            return r();
        }
        s0 s0Var = cVar.Z;
        if (!this.Y) {
            if (cVar.f61326i) {
                this.R &= -1073741825;
                if (!this.Z) {
                    sVar.readFully(this.f61298i.e(), 0, 1);
                    this.V++;
                    if ((this.f61298i.e()[0] & 128) == 128) {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                    this.f61290c0 = this.f61298i.e()[0];
                    this.Z = true;
                }
                byte b11 = this.f61290c0;
                if ((b11 & 1) == 1) {
                    boolean z11 = (b11 & 2) == 2;
                    this.R |= 1073741824;
                    if (!this.f61292d0) {
                        sVar.readFully(this.f61303n.e(), 0, 8);
                        this.V += 8;
                        this.f61292d0 = true;
                        this.f61298i.e()[0] = (byte) ((z11 ? 128 : 0) | 8);
                        this.f61298i.W(0);
                        s0Var.a(this.f61298i, 1, 1);
                        this.W++;
                        this.f61303n.W(0);
                        s0Var.a(this.f61303n, 8, 1);
                        this.W += 8;
                    }
                    if (z11) {
                        if (!this.f61286a0) {
                            sVar.readFully(this.f61298i.e(), 0, 1);
                            this.V++;
                            this.f61298i.W(0);
                            this.f61288b0 = this.f61298i.H();
                            this.f61286a0 = true;
                        }
                        int i13 = this.f61288b0 * 4;
                        this.f61298i.S(i13);
                        sVar.readFully(this.f61298i.e(), 0, i13);
                        this.V += i13;
                        short s11 = (short) ((this.f61288b0 / 2) + 1);
                        int i14 = (s11 * 6) + 2;
                        ByteBuffer byteBuffer = this.f61306q;
                        if (byteBuffer == null || byteBuffer.capacity() < i14) {
                            this.f61306q = ByteBuffer.allocate(i14);
                        }
                        this.f61306q.position(0);
                        this.f61306q.putShort(s11);
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            i12 = this.f61288b0;
                            if (i15 >= i12) {
                                break;
                            }
                            int L = this.f61298i.L();
                            if (i15 % 2 == 0) {
                                this.f61306q.putShort((short) (L - i16));
                            } else {
                                this.f61306q.putInt(L - i16);
                            }
                            i15++;
                            i16 = L;
                        }
                        int i17 = (i11 - this.V) - i16;
                        if (i12 % 2 == 1) {
                            this.f61306q.putInt(i17);
                        } else {
                            this.f61306q.putShort((short) i17);
                            this.f61306q.putInt(0);
                        }
                        this.f61304o.U(this.f61306q.array(), i14);
                        s0Var.a(this.f61304o, i14, 1);
                        this.W += i14;
                    }
                }
            } else {
                byte[] bArr = cVar.f61327j;
                if (bArr != null) {
                    this.f61301l.U(bArr, bArr.length);
                }
            }
            if (cVar.o(z10)) {
                this.R |= ASTNode.DEOP;
                this.f61305p.S(0);
                int g11 = (this.f61301l.g() + i11) - this.V;
                this.f61298i.S(4);
                this.f61298i.e()[0] = (byte) ((g11 >> 24) & 255);
                this.f61298i.e()[1] = (byte) ((g11 >> 16) & 255);
                this.f61298i.e()[2] = (byte) ((g11 >> 8) & 255);
                this.f61298i.e()[3] = (byte) (g11 & 255);
                s0Var.a(this.f61298i, 4, 2);
                this.W += 4;
            }
            this.Y = true;
        }
        int g12 = i11 + this.f61301l.g();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f61320c) && !"V_MPEGH/ISO/HEVC".equals(cVar.f61320c)) {
            if (cVar.V != null) {
                androidx.media3.common.util.a.g(this.f61301l.g() == 0);
                cVar.V.d(sVar);
            }
            while (true) {
                int i18 = this.V;
                if (i18 >= g12) {
                    break;
                }
                int L2 = L(sVar, s0Var, g12 - i18);
                this.V += L2;
                this.W += L2;
            }
        } else {
            byte[] e11 = this.f61297h.e();
            e11[0] = 0;
            e11[1] = 0;
            e11[2] = 0;
            int i19 = cVar.f61318a0;
            int i20 = 4 - i19;
            while (this.V < g12) {
                int i21 = this.X;
                if (i21 == 0) {
                    M(sVar, e11, i20, i19);
                    this.V += i19;
                    this.f61297h.W(0);
                    this.X = this.f61297h.L();
                    this.f61296g.W(0);
                    s0Var.b(this.f61296g, 4);
                    this.W += 4;
                } else {
                    int L3 = L(sVar, s0Var, i21);
                    this.V += L3;
                    this.W += L3;
                    this.X -= L3;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f61320c)) {
            this.f61299j.W(0);
            s0Var.b(this.f61299j, 4);
            this.W += 4;
        }
        return r();
    }

    private void K(l2.s sVar, byte[] bArr, int i11) {
        int length = bArr.length + i11;
        if (this.f61302m.b() < length) {
            this.f61302m.T(Arrays.copyOf(bArr, length + i11));
        } else {
            System.arraycopy(bArr, 0, this.f61302m.e(), 0, bArr.length);
        }
        sVar.readFully(this.f61302m.e(), bArr.length, i11);
        this.f61302m.W(0);
        this.f61302m.V(length);
    }

    private int L(l2.s sVar, s0 s0Var, int i11) {
        int a11 = this.f61301l.a();
        if (a11 <= 0) {
            return s0Var.e(sVar, i11, false);
        }
        int min = Math.min(i11, a11);
        s0Var.b(this.f61301l, min);
        return min;
    }

    private void M(l2.s sVar, byte[] bArr, int i11, int i12) {
        int min = Math.min(i12, this.f61301l.a());
        sVar.readFully(bArr, i11 + min, i12 - min);
        if (min > 0) {
            this.f61301l.l(bArr, i11, min);
        }
    }

    private void j(int i11) {
        if (this.F == null || this.G == null) {
            throw ParserException.createForMalformedContainer("Element " + i11 + " must be in a Cues", null);
        }
    }

    private void k(int i11) {
        if (this.f61313x != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i11 + " must be in a TrackEntry", null);
    }

    private void l() {
        androidx.media3.common.util.a.i(this.f61294e0);
    }

    private m0 n(v vVar, v vVar2) {
        int i11;
        if (this.f61308s == -1 || this.f61311v == C.TIME_UNSET || vVar == null || vVar.d() == 0 || vVar2 == null || vVar2.d() != vVar.d()) {
            return new m0.b(this.f61311v);
        }
        int d11 = vVar.d();
        int[] iArr = new int[d11];
        long[] jArr = new long[d11];
        long[] jArr2 = new long[d11];
        long[] jArr3 = new long[d11];
        int i12 = 0;
        for (int i13 = 0; i13 < d11; i13++) {
            jArr3[i13] = vVar.c(i13);
            jArr[i13] = this.f61308s + vVar2.c(i13);
        }
        while (true) {
            i11 = d11 - 1;
            if (i12 >= i11) {
                break;
            }
            int i14 = i12 + 1;
            iArr[i12] = (int) (jArr[i14] - jArr[i12]);
            jArr2[i12] = jArr3[i14] - jArr3[i12];
            i12 = i14;
        }
        int i15 = i11;
        while (i15 > 0 && jArr3[i15] > this.f61311v) {
            i15--;
        }
        iArr[i15] = (int) ((this.f61308s + this.f61307r) - jArr[i15]);
        jArr2[i15] = this.f61311v - jArr3[i15];
        if (i15 < i11) {
            u.h("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration");
            int i16 = i15 + 1;
            iArr = Arrays.copyOf(iArr, i16);
            jArr = Arrays.copyOf(jArr, i16);
            jArr2 = Arrays.copyOf(jArr2, i16);
            jArr3 = Arrays.copyOf(jArr3, i16);
        }
        return new h(iArr, jArr, jArr2, jArr3);
    }

    private void o(c cVar, long j11, int i11, int i12, int i13) {
        t0 t0Var = cVar.V;
        if (t0Var != null) {
            t0Var.c(cVar.Z, j11, i11, i12, i13, cVar.f61328k);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f61320c) || "S_TEXT/ASS".equals(cVar.f61320c) || "S_TEXT/WEBVTT".equals(cVar.f61320c)) {
                if (this.N > 1) {
                    u.h("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j12 = this.L;
                    if (j12 == C.TIME_UNSET) {
                        u.h("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        G(cVar.f61320c, j12, this.f61302m.e());
                        int f11 = this.f61302m.f();
                        while (true) {
                            if (f11 >= this.f61302m.g()) {
                                break;
                            }
                            if (this.f61302m.e()[f11] == 0) {
                                this.f61302m.V(f11);
                                break;
                            }
                            f11++;
                        }
                        s0 s0Var = cVar.Z;
                        j0 j0Var = this.f61302m;
                        s0Var.b(j0Var, j0Var.g());
                        i12 += this.f61302m.g();
                    }
                }
            }
            if ((268435456 & i11) != 0) {
                if (this.N > 1) {
                    this.f61305p.S(0);
                } else {
                    int g11 = this.f61305p.g();
                    cVar.Z.a(this.f61305p, g11, 2);
                    i12 += g11;
                }
            }
            cVar.Z.d(j11, i11, i12, i13, cVar.f61328k);
        }
        this.I = true;
    }

    private static int[] q(int[] iArr, int i11) {
        return iArr == null ? new int[i11] : iArr.length >= i11 ? iArr : new int[Math.max(iArr.length * 2, i11)];
    }

    private int r() {
        int i11 = this.W;
        E();
        return i11;
    }

    private static byte[] t(long j11, String str, long j12) {
        androidx.media3.common.util.a.a(j11 != C.TIME_UNSET);
        int i11 = (int) (j11 / 3600000000L);
        long j13 = j11 - (i11 * 3600000000L);
        int i12 = (int) (j13 / 60000000);
        long j14 = j13 - (i12 * 60000000);
        int i13 = (int) (j14 / 1000000);
        return a1.u0(String.format(Locale.US, str, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j14 - (i13 * 1000000)) / j12))));
    }

    private static boolean z(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    c11 = 0;
                    break;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    c11 = 5;
                    break;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    c11 = 6;
                    break;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    c11 = 7;
                    break;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    c11 = '\b';
                    break;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    c11 = '\t';
                    break;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    c11 = '\n';
                    break;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    c11 = 11;
                    break;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    c11 = 14;
                    break;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    c11 = 15;
                    break;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    c11 = 16;
                    break;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    c11 = 17;
                    break;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    c11 = 18;
                    break;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    c11 = 19;
                    break;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    c11 = 20;
                    break;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    c11 = 21;
                    break;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    c11 = 22;
                    break;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    c11 = 23;
                    break;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    c11 = 24;
                    break;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    c11 = 25;
                    break;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    c11 = 26;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    c11 = 27;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    c11 = 28;
                    break;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    c11 = 29;
                    break;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    c11 = 30;
                    break;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    c11 = 31;
                    break;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    c11 = ' ';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case NOTIFICATION_REDIRECT_VALUE:
            case 30:
            case TEMPLATE_HTML_SIZE_VALUE:
            case ' ':
                return true;
            default:
                return false;
        }
    }

    protected boolean A(int i11) {
        return i11 == 357149030 || i11 == 524531317 || i11 == 475249515 || i11 == 374648427;
    }

    protected void H(int i11, long j11, long j12) {
        l();
        if (i11 == 160) {
            this.T = false;
            this.U = 0L;
            return;
        }
        if (i11 == 174) {
            c cVar = new c();
            this.f61313x = cVar;
            cVar.f61317a = this.f61312w;
            return;
        }
        if (i11 == 187) {
            this.H = false;
            return;
        }
        if (i11 == 19899) {
            this.f61315z = -1;
            this.A = -1L;
            return;
        }
        if (i11 == 20533) {
            u(i11).f61326i = true;
            return;
        }
        if (i11 == 21968) {
            u(i11).f61343z = true;
            return;
        }
        if (i11 == 408125543) {
            long j13 = this.f61308s;
            if (j13 != -1 && j13 != j11) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
            }
            this.f61308s = j11;
            this.f61307r = j12;
            return;
        }
        if (i11 == 475249515) {
            this.F = new v();
            this.G = new v();
        } else if (i11 == 524531317 && !this.f61314y) {
            if (this.f61291d && this.C != -1) {
                this.B = true;
            } else {
                this.f61294e0.f(new m0.b(this.f61311v));
                this.f61314y = true;
            }
        }
    }

    protected void I(int i11, String str) {
        if (i11 == 134) {
            u(i11).f61320c = str;
            return;
        }
        if (i11 != 17026) {
            if (i11 == 21358) {
                u(i11).f61319b = str;
                return;
            } else {
                if (i11 != 2274716) {
                    return;
                }
                u(i11).Y = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            this.f61312w = Objects.equals(str, "webm");
            return;
        }
        throw ParserException.createForMalformedContainer("DocType " + str + " not supported", null);
    }

    @Override // l2.r
    public final void b(t tVar) {
        if (this.f61293e) {
            tVar = new i3.t(tVar, this.f61295f);
        }
        this.f61294e0 = tVar;
    }

    @Override // l2.r
    public final int c(l2.s sVar, l0 l0Var) {
        this.I = false;
        boolean z10 = true;
        while (z10 && !this.I) {
            z10 = this.f61285a.a(sVar);
            if (z10 && C(l0Var, sVar.getPosition())) {
                return 1;
            }
        }
        if (z10) {
            return 0;
        }
        for (int i11 = 0; i11 < this.f61289c.size(); i11++) {
            c cVar = (c) this.f61289c.valueAt(i11);
            cVar.f();
            cVar.j();
        }
        return -1;
    }

    @Override // l2.r
    public final boolean d(l2.s sVar) {
        return new f().b(sVar);
    }

    @Override // l2.r
    public /* synthetic */ r e() {
        return q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return q.a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x0231, code lost:
    
        throw androidx.media3.common.ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void m(int r22, int r23, l2.s r24) {
        /*
            Method dump skipped, instructions count: 749
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.e.m(int, int, l2.s):void");
    }

    protected void p(int i11) {
        l();
        if (i11 == 160) {
            if (this.J != 2) {
                return;
            }
            c cVar = (c) this.f61289c.get(this.P);
            cVar.f();
            if (this.U > 0 && "A_OPUS".equals(cVar.f61320c)) {
                this.f61305p.T(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.U).array());
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.N; i13++) {
                i12 += this.O[i13];
            }
            int i14 = 0;
            while (i14 < this.N) {
                long j11 = this.K + ((cVar.f61323f * i14) / 1000);
                int i15 = this.R;
                if (i14 == 0 && !this.T) {
                    i15 |= 1;
                }
                int i16 = this.O[i14];
                int i17 = i12 - i16;
                o(cVar, j11, i15, i16, i17);
                i14++;
                i12 = i17;
            }
            this.J = 0;
            return;
        }
        if (i11 == 174) {
            c cVar2 = (c) androidx.media3.common.util.a.i(this.f61313x);
            String str = cVar2.f61320c;
            if (str == null) {
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
            }
            if (z(str)) {
                cVar2.i(this.f61294e0, cVar2.f61321d);
                this.f61289c.put(cVar2.f61321d, cVar2);
            }
            this.f61313x = null;
            return;
        }
        if (i11 == 19899) {
            int i18 = this.f61315z;
            if (i18 != -1) {
                long j12 = this.A;
                if (j12 != -1) {
                    if (i18 == 475249515) {
                        this.C = j12;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i11 == 25152) {
            k(i11);
            c cVar3 = this.f61313x;
            if (cVar3.f61326i) {
                if (cVar3.f61328k == null) {
                    throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.f61330m = new DrmInitData(new DrmInitData.SchemeData(androidx.media3.common.h.f10063a, MimeTypes.VIDEO_WEBM, this.f61313x.f61328k.f68803b));
                return;
            }
            return;
        }
        if (i11 == 28032) {
            k(i11);
            c cVar4 = this.f61313x;
            if (cVar4.f61326i && cVar4.f61327j != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i11 == 357149030) {
            if (this.f61309t == C.TIME_UNSET) {
                this.f61309t = 1000000L;
            }
            long j13 = this.f61310u;
            if (j13 != C.TIME_UNSET) {
                this.f61311v = F(j13);
                return;
            }
            return;
        }
        if (i11 == 374648427) {
            if (this.f61289c.size() == 0) {
                throw ParserException.createForMalformedContainer("No valid tracks were found", null);
            }
            this.f61294e0.endTracks();
        } else {
            if (i11 != 475249515) {
                return;
            }
            if (!this.f61314y) {
                this.f61294e0.f(n(this.F, this.G));
                this.f61314y = true;
            }
            this.F = null;
            this.G = null;
        }
    }

    @Override // l2.r
    public final void release() {
    }

    protected void s(int i11, double d11) {
        if (i11 == 181) {
            u(i11).S = (int) d11;
            return;
        }
        if (i11 == 17545) {
            this.f61310u = (long) d11;
            return;
        }
        switch (i11) {
            case 21969:
                u(i11).F = (float) d11;
                return;
            case 21970:
                u(i11).G = (float) d11;
                return;
            case 21971:
                u(i11).H = (float) d11;
                return;
            case 21972:
                u(i11).I = (float) d11;
                return;
            case 21973:
                u(i11).J = (float) d11;
                return;
            case 21974:
                u(i11).K = (float) d11;
                return;
            case 21975:
                u(i11).L = (float) d11;
                return;
            case 21976:
                u(i11).M = (float) d11;
                return;
            case 21977:
                u(i11).N = (float) d11;
                return;
            case 21978:
                u(i11).O = (float) d11;
                return;
            default:
                switch (i11) {
                    case 30323:
                        u(i11).f61338u = (float) d11;
                        return;
                    case 30324:
                        u(i11).f61339v = (float) d11;
                        return;
                    case 30325:
                        u(i11).f61340w = (float) d11;
                        return;
                    default:
                        return;
                }
        }
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        this.E = C.TIME_UNSET;
        this.J = 0;
        this.f61285a.reset();
        this.f61287b.e();
        E();
        for (int i11 = 0; i11 < this.f61289c.size(); i11++) {
            ((c) this.f61289c.valueAt(i11)).n();
        }
    }

    protected c u(int i11) {
        k(i11);
        return this.f61313x;
    }

    protected int v(int i11) {
        switch (i11) {
            case MRAID_JS_WRITE_FAILED_VALUE:
            case PRIVACY_URL_ERROR_VALUE:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case AD_RESPONSE_EMPTY_VALUE:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21938:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected void w(c cVar, l2.s sVar, int i11) {
        if (cVar.f61325h != 1685485123 && cVar.f61325h != 1685480259) {
            sVar.skipFully(i11);
            return;
        }
        byte[] bArr = new byte[i11];
        cVar.P = bArr;
        sVar.readFully(bArr, 0, i11);
    }

    protected void x(c cVar, int i11, l2.s sVar, int i12) {
        if (i11 != 4 || !"V_VP9".equals(cVar.f61320c)) {
            sVar.skipFully(i12);
        } else {
            this.f61305p.S(i12);
            sVar.readFully(this.f61305p.e(), 0, i12);
        }
    }

    protected void y(int i11, long j11) {
        if (i11 == 20529) {
            if (j11 == 0) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingOrder " + j11 + " not supported", null);
        }
        if (i11 == 20530) {
            if (j11 == 1) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingScope " + j11 + " not supported", null);
        }
        switch (i11) {
            case MRAID_JS_WRITE_FAILED_VALUE:
                u(i11).f61322e = (int) j11;
                return;
            case PRIVACY_URL_ERROR_VALUE:
                u(i11).X = j11 == 1;
                return;
            case 155:
                this.L = F(j11);
                return;
            case 159:
                u(i11).Q = (int) j11;
                return;
            case 176:
                u(i11).f61331n = (int) j11;
                return;
            case 179:
                j(i11);
                this.F.a(F(j11));
                return;
            case 186:
                u(i11).f61332o = (int) j11;
                return;
            case AD_RESPONSE_EMPTY_VALUE:
                u(i11).f61321d = (int) j11;
                return;
            case 231:
                this.E = F(j11);
                return;
            case 238:
                this.S = (int) j11;
                return;
            case 241:
                if (this.H) {
                    return;
                }
                j(i11);
                this.G.a(j11);
                this.H = true;
                return;
            case 251:
                this.T = true;
                return;
            case 16871:
                u(i11).f61325h = (int) j11;
                return;
            case 16980:
                if (j11 == 3) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentCompAlgo " + j11 + " not supported", null);
            case 17029:
                if (j11 < 1 || j11 > 2) {
                    throw ParserException.createForMalformedContainer("DocTypeReadVersion " + j11 + " not supported", null);
                }
                return;
            case 17143:
                if (j11 == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("EBMLReadVersion " + j11 + " not supported", null);
            case 18401:
                if (j11 == 5) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentEncAlgo " + j11 + " not supported", null);
            case 18408:
                if (j11 == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("AESSettingsCipherMode " + j11 + " not supported", null);
            case 21420:
                this.A = j11 + this.f61308s;
                return;
            case 21432:
                int i12 = (int) j11;
                k(i11);
                if (i12 == 0) {
                    this.f61313x.f61342y = 0;
                    return;
                }
                if (i12 == 1) {
                    this.f61313x.f61342y = 2;
                    return;
                } else if (i12 == 3) {
                    this.f61313x.f61342y = 1;
                    return;
                } else {
                    if (i12 != 15) {
                        return;
                    }
                    this.f61313x.f61342y = 3;
                    return;
                }
            case 21680:
                u(i11).f61334q = (int) j11;
                return;
            case 21682:
                u(i11).f61336s = (int) j11;
                return;
            case 21690:
                u(i11).f61335r = (int) j11;
                return;
            case 21930:
                u(i11).W = j11 == 1;
                return;
            case 21938:
                k(i11);
                c cVar = this.f61313x;
                cVar.f61343z = true;
                cVar.f61333p = (int) j11;
                return;
            case 21998:
                u(i11).f61324g = (int) j11;
                return;
            case 22186:
                u(i11).T = j11;
                return;
            case 22203:
                u(i11).U = j11;
                return;
            case 25188:
                u(i11).R = (int) j11;
                return;
            case 30114:
                this.U = j11;
                return;
            case 30321:
                k(i11);
                int i13 = (int) j11;
                if (i13 == 0) {
                    this.f61313x.f61337t = 0;
                    return;
                }
                if (i13 == 1) {
                    this.f61313x.f61337t = 1;
                    return;
                } else if (i13 == 2) {
                    this.f61313x.f61337t = 2;
                    return;
                } else {
                    if (i13 != 3) {
                        return;
                    }
                    this.f61313x.f61337t = 3;
                    return;
                }
            case 2352003:
                u(i11).f61323f = (int) j11;
                return;
            case 2807729:
                this.f61309t = j11;
                return;
            default:
                switch (i11) {
                    case 21945:
                        k(i11);
                        int i14 = (int) j11;
                        if (i14 == 1) {
                            this.f61313x.C = 2;
                            return;
                        } else {
                            if (i14 != 2) {
                                return;
                            }
                            this.f61313x.C = 1;
                            return;
                        }
                    case 21946:
                        k(i11);
                        int k11 = i.k((int) j11);
                        if (k11 != -1) {
                            this.f61313x.B = k11;
                            return;
                        }
                        return;
                    case 21947:
                        k(i11);
                        this.f61313x.f61343z = true;
                        int j12 = i.j((int) j11);
                        if (j12 != -1) {
                            this.f61313x.A = j12;
                            return;
                        }
                        return;
                    case 21948:
                        u(i11).D = (int) j11;
                        return;
                    case 21949:
                        u(i11).E = (int) j11;
                        return;
                    default:
                        return;
                }
        }
    }
}
