package m9;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.t;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.a0;
import g9.b0;
import g9.e0;
import g9.f0;
import g9.l;
import g9.m;
import g9.n;
import g9.q;
import g9.r;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.mvel2.ast.ASTNode;

/* loaded from: classes4.dex */
public class e implements l {

    /* renamed from: c0, reason: collision with root package name */
    public static final r f69480c0 = new r() { // from class: m9.d
        @Override // g9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // g9.r
        public final l[] createExtractors() {
            l[] z10;
            z10 = e.z();
            return z10;
        }
    };

    /* renamed from: d0, reason: collision with root package name */
    private static final byte[] f69481d0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: e0, reason: collision with root package name */
    private static final byte[] f69482e0 = p0.n0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: f0, reason: collision with root package name */
    private static final byte[] f69483f0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: g0, reason: collision with root package name */
    private static final byte[] f69484g0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};

    /* renamed from: h0, reason: collision with root package name */
    private static final UUID f69485h0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* renamed from: i0, reason: collision with root package name */
    private static final Map f69486i0;
    private long A;
    private long B;
    private t C;
    private t D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private int Y;
    private byte Z;

    /* renamed from: a, reason: collision with root package name */
    private final m9.c f69487a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f69488a0;

    /* renamed from: b, reason: collision with root package name */
    private final g f69489b;

    /* renamed from: b0, reason: collision with root package name */
    private n f69490b0;

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray f69491c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f69492d;

    /* renamed from: e, reason: collision with root package name */
    private final d0 f69493e;

    /* renamed from: f, reason: collision with root package name */
    private final d0 f69494f;

    /* renamed from: g, reason: collision with root package name */
    private final d0 f69495g;

    /* renamed from: h, reason: collision with root package name */
    private final d0 f69496h;

    /* renamed from: i, reason: collision with root package name */
    private final d0 f69497i;

    /* renamed from: j, reason: collision with root package name */
    private final d0 f69498j;

    /* renamed from: k, reason: collision with root package name */
    private final d0 f69499k;

    /* renamed from: l, reason: collision with root package name */
    private final d0 f69500l;

    /* renamed from: m, reason: collision with root package name */
    private final d0 f69501m;

    /* renamed from: n, reason: collision with root package name */
    private final d0 f69502n;

    /* renamed from: o, reason: collision with root package name */
    private ByteBuffer f69503o;

    /* renamed from: p, reason: collision with root package name */
    private long f69504p;

    /* renamed from: q, reason: collision with root package name */
    private long f69505q;

    /* renamed from: r, reason: collision with root package name */
    private long f69506r;

    /* renamed from: s, reason: collision with root package name */
    private long f69507s;

    /* renamed from: t, reason: collision with root package name */
    private long f69508t;

    /* renamed from: u, reason: collision with root package name */
    private c f69509u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f69510v;

    /* renamed from: w, reason: collision with root package name */
    private int f69511w;

    /* renamed from: x, reason: collision with root package name */
    private long f69512x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f69513y;

    /* renamed from: z, reason: collision with root package name */
    private long f69514z;

    /* loaded from: classes4.dex */
    private final class b implements m9.b {
        private b() {
        }

        @Override // m9.b
        public void a(int i11, int i12, m mVar) {
            e.this.k(i11, i12, mVar);
        }

        @Override // m9.b
        public void endMasterElement(int i11) {
            e.this.n(i11);
        }

        @Override // m9.b
        public void floatElement(int i11, double d11) {
            e.this.q(i11, d11);
        }

        @Override // m9.b
        public int getElementType(int i11) {
            return e.this.t(i11);
        }

        @Override // m9.b
        public void integerElement(int i11, long j11) {
            e.this.w(i11, j11);
        }

        @Override // m9.b
        public boolean isLevel1Element(int i11) {
            return e.this.y(i11);
        }

        @Override // m9.b
        public void startMasterElement(int i11, long j11, long j12) {
            e.this.F(i11, j11, j12);
        }

        @Override // m9.b
        public void stringElement(int i11, String str) {
            e.this.G(i11, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static final class c {
        public byte[] N;
        public f0 T;
        public boolean U;
        public e0 X;
        public int Y;

        /* renamed from: a, reason: collision with root package name */
        public String f69516a;

        /* renamed from: b, reason: collision with root package name */
        public String f69517b;

        /* renamed from: c, reason: collision with root package name */
        public int f69518c;

        /* renamed from: d, reason: collision with root package name */
        public int f69519d;

        /* renamed from: e, reason: collision with root package name */
        public int f69520e;

        /* renamed from: f, reason: collision with root package name */
        public int f69521f;

        /* renamed from: g, reason: collision with root package name */
        private int f69522g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f69523h;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f69524i;

        /* renamed from: j, reason: collision with root package name */
        public e0.a f69525j;

        /* renamed from: k, reason: collision with root package name */
        public byte[] f69526k;

        /* renamed from: l, reason: collision with root package name */
        public DrmInitData f69527l;

        /* renamed from: m, reason: collision with root package name */
        public int f69528m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f69529n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f69530o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f69531p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f69532q = 0;

        /* renamed from: r, reason: collision with root package name */
        public int f69533r = -1;

        /* renamed from: s, reason: collision with root package name */
        public float f69534s = 0.0f;

        /* renamed from: t, reason: collision with root package name */
        public float f69535t = 0.0f;

        /* renamed from: u, reason: collision with root package name */
        public float f69536u = 0.0f;

        /* renamed from: v, reason: collision with root package name */
        public byte[] f69537v = null;

        /* renamed from: w, reason: collision with root package name */
        public int f69538w = -1;

        /* renamed from: x, reason: collision with root package name */
        public boolean f69539x = false;

        /* renamed from: y, reason: collision with root package name */
        public int f69540y = -1;

        /* renamed from: z, reason: collision with root package name */
        public int f69541z = -1;
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        private String W = "eng";

        protected c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            com.google.android.exoplayer2.util.a.e(this.X);
        }

        private byte[] g(String str) {
            byte[] bArr = this.f69526k;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, null);
        }

        private byte[] h() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((this.D * 50000.0f) + 0.5f));
            order.putShort((short) ((this.E * 50000.0f) + 0.5f));
            order.putShort((short) ((this.F * 50000.0f) + 0.5f));
            order.putShort((short) ((this.G * 50000.0f) + 0.5f));
            order.putShort((short) ((this.H * 50000.0f) + 0.5f));
            order.putShort((short) ((this.I * 50000.0f) + 0.5f));
            order.putShort((short) ((this.J * 50000.0f) + 0.5f));
            order.putShort((short) ((this.K * 50000.0f) + 0.5f));
            order.putShort((short) (this.L + 0.5f));
            order.putShort((short) (this.M + 0.5f));
            order.putShort((short) this.B);
            order.putShort((short) this.C);
            return bArr;
        }

        private static Pair k(d0 d0Var) {
            try {
                d0Var.Q(16);
                long t11 = d0Var.t();
                if (t11 == 1482049860) {
                    return new Pair("video/divx", null);
                }
                if (t11 == 859189832) {
                    return new Pair(MimeTypes.VIDEO_H263, null);
                }
                if (t11 != 826496599) {
                    s.i("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair(MimeTypes.VIDEO_UNKNOWN, null);
                }
                byte[] d11 = d0Var.d();
                for (int e11 = d0Var.e() + 20; e11 < d11.length - 4; e11++) {
                    if (d11[e11] == 0 && d11[e11 + 1] == 0 && d11[e11 + 2] == 1 && d11[e11 + 3] == 15) {
                        return new Pair(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(d11, e11, d11.length)));
                    }
                }
                throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }

        private static boolean l(d0 d0Var) {
            try {
                int v11 = d0Var.v();
                if (v11 == 1) {
                    return true;
                }
                if (v11 != 65534) {
                    return false;
                }
                d0Var.P(24);
                if (d0Var.w() == e.f69485h0.getMostSignificantBits()) {
                    if (d0Var.w() == e.f69485h0.getLeastSignificantBits()) {
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
            return "A_OPUS".equals(this.f69517b) ? z10 : this.f69521f > 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x01dd. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0428  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x043f  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x044e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x056a  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0460  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0441  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i(g9.n r20, int r21) {
            /*
                Method dump skipped, instructions count: 1664
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: m9.e.c.i(g9.n, int):void");
        }

        public void j() {
            f0 f0Var = this.T;
            if (f0Var != null) {
                f0Var.a(this.X, this.f69525j);
            }
        }

        public void n() {
            f0 f0Var = this.T;
            if (f0Var != null) {
                f0Var.b();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        f69486i0 = Collections.unmodifiableMap(hashMap);
    }

    public e() {
        this(0);
    }

    public e(int i11) {
        this(new m9.a(), i11);
    }

    e(m9.c cVar, int i11) {
        this.f69505q = -1L;
        this.f69506r = C.TIME_UNSET;
        this.f69507s = C.TIME_UNSET;
        this.f69508t = C.TIME_UNSET;
        this.f69514z = -1L;
        this.A = -1L;
        this.B = C.TIME_UNSET;
        this.f69487a = cVar;
        cVar.b(new b());
        this.f69492d = (i11 & 1) == 0;
        this.f69489b = new g();
        this.f69491c = new SparseArray();
        this.f69495g = new d0(4);
        this.f69496h = new d0(ByteBuffer.allocate(4).putInt(-1).array());
        this.f69497i = new d0(4);
        this.f69493e = new d0(x.f27718a);
        this.f69494f = new d0(4);
        this.f69498j = new d0();
        this.f69499k = new d0();
        this.f69500l = new d0(8);
        this.f69501m = new d0();
        this.f69502n = new d0();
        this.L = new int[1];
    }

    private boolean A(a0 a0Var, long j11) {
        if (this.f69513y) {
            this.A = j11;
            a0Var.f63492a = this.f69514z;
            this.f69513y = false;
            return true;
        }
        if (this.f69510v) {
            long j12 = this.A;
            if (j12 != -1) {
                a0Var.f63492a = j12;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    private void B(m mVar, int i11) {
        if (this.f69495g.f() >= i11) {
            return;
        }
        if (this.f69495g.b() < i11) {
            d0 d0Var = this.f69495g;
            d0Var.c(Math.max(d0Var.b() * 2, i11));
        }
        mVar.readFully(this.f69495g.d(), this.f69495g.f(), i11 - this.f69495g.f());
        this.f69495g.O(i11);
    }

    private void C() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = (byte) 0;
        this.f69488a0 = false;
        this.f69498j.L(0);
    }

    private long D(long j11) {
        long j12 = this.f69506r;
        if (j12 != C.TIME_UNSET) {
            return p0.N0(j11, j12, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private static void E(String str, long j11, byte[] bArr) {
        byte[] r11;
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
                r11 = r(j11, "%01d:%02d:%02d:%02d", 10000L);
                i11 = 21;
                break;
            case 1:
                r11 = r(j11, "%02d:%02d:%02d.%03d", 1000L);
                i11 = 25;
                break;
            case 2:
                r11 = r(j11, "%02d:%02d:%02d,%03d", 1000L);
                i11 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(r11, 0, bArr, i11, r11.length);
    }

    private int H(m mVar, c cVar, int i11, boolean z10) {
        int i12;
        if ("S_TEXT/UTF8".equals(cVar.f69517b)) {
            I(mVar, f69481d0, i11);
            return p();
        }
        if ("S_TEXT/ASS".equals(cVar.f69517b)) {
            I(mVar, f69483f0, i11);
            return p();
        }
        if ("S_TEXT/WEBVTT".equals(cVar.f69517b)) {
            I(mVar, f69484g0, i11);
            return p();
        }
        e0 e0Var = cVar.X;
        if (!this.V) {
            if (cVar.f69523h) {
                this.O &= -1073741825;
                if (!this.W) {
                    mVar.readFully(this.f69495g.d(), 0, 1);
                    this.S++;
                    if ((this.f69495g.d()[0] & 128) == 128) {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                    this.Z = this.f69495g.d()[0];
                    this.W = true;
                }
                byte b11 = this.Z;
                if ((b11 & 1) == 1) {
                    boolean z11 = (b11 & 2) == 2;
                    this.O |= 1073741824;
                    if (!this.f69488a0) {
                        mVar.readFully(this.f69500l.d(), 0, 8);
                        this.S += 8;
                        this.f69488a0 = true;
                        this.f69495g.d()[0] = (byte) ((z11 ? 128 : 0) | 8);
                        this.f69495g.P(0);
                        e0Var.f(this.f69495g, 1, 1);
                        this.T++;
                        this.f69500l.P(0);
                        e0Var.f(this.f69500l, 8, 1);
                        this.T += 8;
                    }
                    if (z11) {
                        if (!this.X) {
                            mVar.readFully(this.f69495g.d(), 0, 1);
                            this.S++;
                            this.f69495g.P(0);
                            this.Y = this.f69495g.D();
                            this.X = true;
                        }
                        int i13 = this.Y * 4;
                        this.f69495g.L(i13);
                        mVar.readFully(this.f69495g.d(), 0, i13);
                        this.S += i13;
                        short s11 = (short) ((this.Y / 2) + 1);
                        int i14 = (s11 * 6) + 2;
                        ByteBuffer byteBuffer = this.f69503o;
                        if (byteBuffer == null || byteBuffer.capacity() < i14) {
                            this.f69503o = ByteBuffer.allocate(i14);
                        }
                        this.f69503o.position(0);
                        this.f69503o.putShort(s11);
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            i12 = this.Y;
                            if (i15 >= i12) {
                                break;
                            }
                            int H = this.f69495g.H();
                            if (i15 % 2 == 0) {
                                this.f69503o.putShort((short) (H - i16));
                            } else {
                                this.f69503o.putInt(H - i16);
                            }
                            i15++;
                            i16 = H;
                        }
                        int i17 = (i11 - this.S) - i16;
                        if (i12 % 2 == 1) {
                            this.f69503o.putInt(i17);
                        } else {
                            this.f69503o.putShort((short) i17);
                            this.f69503o.putInt(0);
                        }
                        this.f69501m.N(this.f69503o.array(), i14);
                        e0Var.f(this.f69501m, i14, 1);
                        this.T += i14;
                    }
                }
            } else {
                byte[] bArr = cVar.f69524i;
                if (bArr != null) {
                    this.f69498j.N(bArr, bArr.length);
                }
            }
            if (cVar.o(z10)) {
                this.O |= ASTNode.DEOP;
                this.f69502n.L(0);
                int f11 = (this.f69498j.f() + i11) - this.S;
                this.f69495g.L(4);
                this.f69495g.d()[0] = (byte) ((f11 >> 24) & 255);
                this.f69495g.d()[1] = (byte) ((f11 >> 16) & 255);
                this.f69495g.d()[2] = (byte) ((f11 >> 8) & 255);
                this.f69495g.d()[3] = (byte) (f11 & 255);
                e0Var.f(this.f69495g, 4, 2);
                this.T += 4;
            }
            this.V = true;
        }
        int f12 = i11 + this.f69498j.f();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f69517b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f69517b)) {
            if (cVar.T != null) {
                com.google.android.exoplayer2.util.a.g(this.f69498j.f() == 0);
                cVar.T.d(mVar);
            }
            while (true) {
                int i18 = this.S;
                if (i18 >= f12) {
                    break;
                }
                int J = J(mVar, e0Var, f12 - i18);
                this.S += J;
                this.T += J;
            }
        } else {
            byte[] d11 = this.f69494f.d();
            d11[0] = 0;
            d11[1] = 0;
            d11[2] = 0;
            int i19 = cVar.Y;
            int i20 = 4 - i19;
            while (this.S < f12) {
                int i21 = this.U;
                if (i21 == 0) {
                    K(mVar, d11, i20, i19);
                    this.S += i19;
                    this.f69494f.P(0);
                    this.U = this.f69494f.H();
                    this.f69493e.P(0);
                    e0Var.c(this.f69493e, 4);
                    this.T += 4;
                } else {
                    int J2 = J(mVar, e0Var, i21);
                    this.S += J2;
                    this.T += J2;
                    this.U -= J2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f69517b)) {
            this.f69496h.P(0);
            e0Var.c(this.f69496h, 4);
            this.T += 4;
        }
        return p();
    }

    private void I(m mVar, byte[] bArr, int i11) {
        int length = bArr.length + i11;
        if (this.f69499k.b() < length) {
            this.f69499k.M(Arrays.copyOf(bArr, length + i11));
        } else {
            System.arraycopy(bArr, 0, this.f69499k.d(), 0, bArr.length);
        }
        mVar.readFully(this.f69499k.d(), bArr.length, i11);
        this.f69499k.P(0);
        this.f69499k.O(length);
    }

    private int J(m mVar, e0 e0Var, int i11) {
        int a11 = this.f69498j.a();
        if (a11 <= 0) {
            return e0Var.b(mVar, i11, false);
        }
        int min = Math.min(i11, a11);
        e0Var.c(this.f69498j, min);
        return min;
    }

    private void K(m mVar, byte[] bArr, int i11, int i12) {
        int min = Math.min(i12, this.f69498j.a());
        mVar.readFully(bArr, i11 + min, i12 - min);
        if (min > 0) {
            this.f69498j.j(bArr, i11, min);
        }
    }

    private void h(int i11) {
        if (this.C == null || this.D == null) {
            throw ParserException.createForMalformedContainer("Element " + i11 + " must be in a Cues", null);
        }
    }

    private void i(int i11) {
        if (this.f69509u != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i11 + " must be in a TrackEntry", null);
    }

    private void j() {
        com.google.android.exoplayer2.util.a.i(this.f69490b0);
    }

    private b0 l(t tVar, t tVar2) {
        int i11;
        if (this.f69505q == -1 || this.f69508t == C.TIME_UNSET || tVar == null || tVar.c() == 0 || tVar2 == null || tVar2.c() != tVar.c()) {
            return new b0.b(this.f69508t);
        }
        int c11 = tVar.c();
        int[] iArr = new int[c11];
        long[] jArr = new long[c11];
        long[] jArr2 = new long[c11];
        long[] jArr3 = new long[c11];
        int i12 = 0;
        for (int i13 = 0; i13 < c11; i13++) {
            jArr3[i13] = tVar.b(i13);
            jArr[i13] = this.f69505q + tVar2.b(i13);
        }
        while (true) {
            i11 = c11 - 1;
            if (i12 >= i11) {
                break;
            }
            int i14 = i12 + 1;
            iArr[i12] = (int) (jArr[i14] - jArr[i12]);
            jArr2[i12] = jArr3[i14] - jArr3[i12];
            i12 = i14;
        }
        iArr[i11] = (int) ((this.f69505q + this.f69504p) - jArr[i11]);
        long j11 = this.f69508t - jArr3[i11];
        jArr2[i11] = j11;
        if (j11 <= 0) {
            s.i("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j11);
            iArr = Arrays.copyOf(iArr, i11);
            jArr = Arrays.copyOf(jArr, i11);
            jArr2 = Arrays.copyOf(jArr2, i11);
            jArr3 = Arrays.copyOf(jArr3, i11);
        }
        return new g9.d(iArr, jArr, jArr2, jArr3);
    }

    private void m(c cVar, long j11, int i11, int i12, int i13) {
        f0 f0Var = cVar.T;
        if (f0Var != null) {
            f0Var.c(cVar.X, j11, i11, i12, i13, cVar.f69525j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f69517b) || "S_TEXT/ASS".equals(cVar.f69517b) || "S_TEXT/WEBVTT".equals(cVar.f69517b)) {
                if (this.K > 1) {
                    s.i("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j12 = this.I;
                    if (j12 == C.TIME_UNSET) {
                        s.i("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        E(cVar.f69517b, j12, this.f69499k.d());
                        int e11 = this.f69499k.e();
                        while (true) {
                            if (e11 >= this.f69499k.f()) {
                                break;
                            }
                            if (this.f69499k.d()[e11] == 0) {
                                this.f69499k.O(e11);
                                break;
                            }
                            e11++;
                        }
                        e0 e0Var = cVar.X;
                        d0 d0Var = this.f69499k;
                        e0Var.c(d0Var, d0Var.f());
                        i12 += this.f69499k.f();
                    }
                }
            }
            if ((268435456 & i11) != 0) {
                if (this.K > 1) {
                    this.f69502n.L(0);
                } else {
                    int f11 = this.f69502n.f();
                    cVar.X.f(this.f69502n, f11, 2);
                    i12 += f11;
                }
            }
            cVar.X.d(j11, i11, i12, i13, cVar.f69525j);
        }
        this.F = true;
    }

    private static int[] o(int[] iArr, int i11) {
        return iArr == null ? new int[i11] : iArr.length >= i11 ? iArr : new int[Math.max(iArr.length * 2, i11)];
    }

    private int p() {
        int i11 = this.T;
        C();
        return i11;
    }

    private static byte[] r(long j11, String str, long j12) {
        com.google.android.exoplayer2.util.a.a(j11 != C.TIME_UNSET);
        int i11 = (int) (j11 / 3600000000L);
        long j13 = j11 - (i11 * 3600000000L);
        int i12 = (int) (j13 / 60000000);
        long j14 = j13 - (i12 * 60000000);
        int i13 = (int) (j14 / 1000000);
        return p0.n0(String.format(Locale.US, str, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j14 - (i13 * 1000000)) / j12))));
    }

    private static boolean x(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] z() {
        return new l[]{new e()};
    }

    protected void F(int i11, long j11, long j12) {
        j();
        if (i11 == 160) {
            this.Q = false;
            this.R = 0L;
            return;
        }
        if (i11 == 174) {
            this.f69509u = new c();
            return;
        }
        if (i11 == 187) {
            this.E = false;
            return;
        }
        if (i11 == 19899) {
            this.f69511w = -1;
            this.f69512x = -1L;
            return;
        }
        if (i11 == 20533) {
            s(i11).f69523h = true;
            return;
        }
        if (i11 == 21968) {
            s(i11).f69539x = true;
            return;
        }
        if (i11 == 408125543) {
            long j13 = this.f69505q;
            if (j13 != -1 && j13 != j11) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
            }
            this.f69505q = j11;
            this.f69504p = j12;
            return;
        }
        if (i11 == 475249515) {
            this.C = new t();
            this.D = new t();
        } else if (i11 == 524531317 && !this.f69510v) {
            if (this.f69492d && this.f69514z != -1) {
                this.f69513y = true;
            } else {
                this.f69490b0.d(new b0.b(this.f69508t));
                this.f69510v = true;
            }
        }
    }

    protected void G(int i11, String str) {
        if (i11 == 134) {
            s(i11).f69517b = str;
            return;
        }
        if (i11 != 17026) {
            if (i11 == 21358) {
                s(i11).f69516a = str;
                return;
            } else {
                if (i11 != 2274716) {
                    return;
                }
                s(i11).W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw ParserException.createForMalformedContainer("DocType " + str + " not supported", null);
    }

    @Override // g9.l
    public final void b(n nVar) {
        this.f69490b0 = nVar;
    }

    @Override // g9.l
    public final int c(m mVar, a0 a0Var) {
        this.F = false;
        boolean z10 = true;
        while (z10 && !this.F) {
            z10 = this.f69487a.a(mVar);
            if (z10 && A(a0Var, mVar.getPosition())) {
                return 1;
            }
        }
        if (z10) {
            return 0;
        }
        for (int i11 = 0; i11 < this.f69491c.size(); i11++) {
            c cVar = (c) this.f69491c.valueAt(i11);
            cVar.f();
            cVar.j();
        }
        return -1;
    }

    @Override // g9.l
    public final boolean d(m mVar) {
        return new f().b(mVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x0231, code lost:
    
        throw com.google.android.exoplayer2.ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void k(int r22, int r23, g9.m r24) {
        /*
            Method dump skipped, instructions count: 749
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.e.k(int, int, g9.m):void");
    }

    protected void n(int i11) {
        j();
        if (i11 == 160) {
            if (this.G != 2) {
                return;
            }
            c cVar = (c) this.f69491c.get(this.M);
            cVar.f();
            if (this.R > 0 && "A_OPUS".equals(cVar.f69517b)) {
                this.f69502n.M(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.K; i13++) {
                i12 += this.L[i13];
            }
            int i14 = 0;
            while (i14 < this.K) {
                long j11 = this.H + ((cVar.f69520e * i14) / 1000);
                int i15 = this.O;
                if (i14 == 0 && !this.Q) {
                    i15 |= 1;
                }
                int i16 = this.L[i14];
                int i17 = i12 - i16;
                m(cVar, j11, i15, i16, i17);
                i14++;
                i12 = i17;
            }
            this.G = 0;
            return;
        }
        if (i11 == 174) {
            c cVar2 = (c) com.google.android.exoplayer2.util.a.i(this.f69509u);
            String str = cVar2.f69517b;
            if (str == null) {
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
            }
            if (x(str)) {
                cVar2.i(this.f69490b0, cVar2.f69518c);
                this.f69491c.put(cVar2.f69518c, cVar2);
            }
            this.f69509u = null;
            return;
        }
        if (i11 == 19899) {
            int i18 = this.f69511w;
            if (i18 != -1) {
                long j12 = this.f69512x;
                if (j12 != -1) {
                    if (i18 == 475249515) {
                        this.f69514z = j12;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i11 == 25152) {
            i(i11);
            c cVar3 = this.f69509u;
            if (cVar3.f69523h) {
                if (cVar3.f69525j == null) {
                    throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.f69527l = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.l.f25240a, MimeTypes.VIDEO_WEBM, this.f69509u.f69525j.f63514b));
                return;
            }
            return;
        }
        if (i11 == 28032) {
            i(i11);
            c cVar4 = this.f69509u;
            if (cVar4.f69523h && cVar4.f69524i != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i11 == 357149030) {
            if (this.f69506r == C.TIME_UNSET) {
                this.f69506r = 1000000L;
            }
            long j13 = this.f69507s;
            if (j13 != C.TIME_UNSET) {
                this.f69508t = D(j13);
                return;
            }
            return;
        }
        if (i11 == 374648427) {
            if (this.f69491c.size() == 0) {
                throw ParserException.createForMalformedContainer("No valid tracks were found", null);
            }
            this.f69490b0.endTracks();
        } else {
            if (i11 != 475249515) {
                return;
            }
            if (!this.f69510v) {
                this.f69490b0.d(l(this.C, this.D));
                this.f69510v = true;
            }
            this.C = null;
            this.D = null;
        }
    }

    protected void q(int i11, double d11) {
        if (i11 == 181) {
            s(i11).Q = (int) d11;
            return;
        }
        if (i11 == 17545) {
            this.f69507s = (long) d11;
            return;
        }
        switch (i11) {
            case 21969:
                s(i11).D = (float) d11;
                return;
            case 21970:
                s(i11).E = (float) d11;
                return;
            case 21971:
                s(i11).F = (float) d11;
                return;
            case 21972:
                s(i11).G = (float) d11;
                return;
            case 21973:
                s(i11).H = (float) d11;
                return;
            case 21974:
                s(i11).I = (float) d11;
                return;
            case 21975:
                s(i11).J = (float) d11;
                return;
            case 21976:
                s(i11).K = (float) d11;
                return;
            case 21977:
                s(i11).L = (float) d11;
                return;
            case 21978:
                s(i11).M = (float) d11;
                return;
            default:
                switch (i11) {
                    case 30323:
                        s(i11).f69534s = (float) d11;
                        return;
                    case 30324:
                        s(i11).f69535t = (float) d11;
                        return;
                    case 30325:
                        s(i11).f69536u = (float) d11;
                        return;
                    default:
                        return;
                }
        }
    }

    @Override // g9.l
    public final void release() {
    }

    protected c s(int i11) {
        i(i11);
        return this.f69509u;
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        this.B = C.TIME_UNSET;
        this.G = 0;
        this.f69487a.reset();
        this.f69489b.e();
        C();
        for (int i11 = 0; i11 < this.f69491c.size(); i11++) {
            ((c) this.f69491c.valueAt(i11)).n();
        }
    }

    protected int t(int i11) {
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

    protected void u(c cVar, m mVar, int i11) {
        if (cVar.f69522g != 1685485123 && cVar.f69522g != 1685480259) {
            mVar.skipFully(i11);
            return;
        }
        byte[] bArr = new byte[i11];
        cVar.N = bArr;
        mVar.readFully(bArr, 0, i11);
    }

    protected void v(c cVar, int i11, m mVar, int i12) {
        if (i11 != 4 || !"V_VP9".equals(cVar.f69517b)) {
            mVar.skipFully(i12);
        } else {
            this.f69502n.L(i12);
            mVar.readFully(this.f69502n.d(), 0, i12);
        }
    }

    protected void w(int i11, long j11) {
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
                s(i11).f69519d = (int) j11;
                return;
            case PRIVACY_URL_ERROR_VALUE:
                s(i11).V = j11 == 1;
                return;
            case 155:
                this.I = D(j11);
                return;
            case 159:
                s(i11).O = (int) j11;
                return;
            case 176:
                s(i11).f69528m = (int) j11;
                return;
            case 179:
                h(i11);
                this.C.a(D(j11));
                return;
            case 186:
                s(i11).f69529n = (int) j11;
                return;
            case AD_RESPONSE_EMPTY_VALUE:
                s(i11).f69518c = (int) j11;
                return;
            case 231:
                this.B = D(j11);
                return;
            case 238:
                this.P = (int) j11;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                h(i11);
                this.D.a(j11);
                this.E = true;
                return;
            case 251:
                this.Q = true;
                return;
            case 16871:
                s(i11).f69522g = (int) j11;
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
                this.f69512x = j11 + this.f69505q;
                return;
            case 21432:
                int i12 = (int) j11;
                i(i11);
                if (i12 == 0) {
                    this.f69509u.f69538w = 0;
                    return;
                }
                if (i12 == 1) {
                    this.f69509u.f69538w = 2;
                    return;
                } else if (i12 == 3) {
                    this.f69509u.f69538w = 1;
                    return;
                } else {
                    if (i12 != 15) {
                        return;
                    }
                    this.f69509u.f69538w = 3;
                    return;
                }
            case 21680:
                s(i11).f69530o = (int) j11;
                return;
            case 21682:
                s(i11).f69532q = (int) j11;
                return;
            case 21690:
                s(i11).f69531p = (int) j11;
                return;
            case 21930:
                s(i11).U = j11 == 1;
                return;
            case 21998:
                s(i11).f69521f = (int) j11;
                return;
            case 22186:
                s(i11).R = j11;
                return;
            case 22203:
                s(i11).S = j11;
                return;
            case 25188:
                s(i11).P = (int) j11;
                return;
            case 30114:
                this.R = j11;
                return;
            case 30321:
                i(i11);
                int i13 = (int) j11;
                if (i13 == 0) {
                    this.f69509u.f69533r = 0;
                    return;
                }
                if (i13 == 1) {
                    this.f69509u.f69533r = 1;
                    return;
                } else if (i13 == 2) {
                    this.f69509u.f69533r = 2;
                    return;
                } else {
                    if (i13 != 3) {
                        return;
                    }
                    this.f69509u.f69533r = 3;
                    return;
                }
            case 2352003:
                s(i11).f69520e = (int) j11;
                return;
            case 2807729:
                this.f69506r = j11;
                return;
            default:
                switch (i11) {
                    case 21945:
                        i(i11);
                        int i14 = (int) j11;
                        if (i14 == 1) {
                            this.f69509u.A = 2;
                            return;
                        } else {
                            if (i14 != 2) {
                                return;
                            }
                            this.f69509u.A = 1;
                            return;
                        }
                    case 21946:
                        i(i11);
                        int c11 = com.google.android.exoplayer2.video.c.c((int) j11);
                        if (c11 != -1) {
                            this.f69509u.f69541z = c11;
                            return;
                        }
                        return;
                    case 21947:
                        i(i11);
                        this.f69509u.f69539x = true;
                        int b11 = com.google.android.exoplayer2.video.c.b((int) j11);
                        if (b11 != -1) {
                            this.f69509u.f69540y = b11;
                            return;
                        }
                        return;
                    case 21948:
                        s(i11).B = (int) j11;
                        return;
                    case 21949:
                        s(i11).C = (int) j11;
                        return;
                    default:
                        return;
                }
        }
    }

    protected boolean y(int i11) {
        return i11 == 357149030 || i11 == 524531317 || i11 == 475249515 || i11 == 374648427;
    }
}
