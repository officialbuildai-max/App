package y4;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import okio.internal.Buffer;

/* loaded from: classes3.dex */
public abstract class c implements b, Closeable {

    /* renamed from: q, reason: collision with root package name */
    private static final ThreadLocal f78968q = new ThreadLocal();

    /* renamed from: r, reason: collision with root package name */
    protected static final char[] f78969r = ("\"" + com.alibaba.fastjson.a.DEFAULT_TYPE_KEY + "\":\"").toCharArray();

    /* renamed from: s, reason: collision with root package name */
    protected static final int[] f78970s = new int[103];

    /* renamed from: a, reason: collision with root package name */
    protected int f78971a;

    /* renamed from: b, reason: collision with root package name */
    protected int f78972b;

    /* renamed from: c, reason: collision with root package name */
    protected int f78973c;

    /* renamed from: d, reason: collision with root package name */
    protected char f78974d;

    /* renamed from: e, reason: collision with root package name */
    protected int f78975e;

    /* renamed from: f, reason: collision with root package name */
    protected int f78976f;

    /* renamed from: g, reason: collision with root package name */
    protected char[] f78977g;

    /* renamed from: h, reason: collision with root package name */
    protected int f78978h;

    /* renamed from: i, reason: collision with root package name */
    protected int f78979i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f78980j;

    /* renamed from: o, reason: collision with root package name */
    protected String f78985o;

    /* renamed from: k, reason: collision with root package name */
    protected Calendar f78981k = null;

    /* renamed from: l, reason: collision with root package name */
    protected TimeZone f78982l = com.alibaba.fastjson.a.defaultTimeZone;

    /* renamed from: m, reason: collision with root package name */
    protected Locale f78983m = com.alibaba.fastjson.a.defaultLocale;

    /* renamed from: n, reason: collision with root package name */
    public int f78984n = 0;

    /* renamed from: p, reason: collision with root package name */
    protected int f78986p = 0;

    static {
        for (int i11 = 48; i11 <= 57; i11++) {
            f78970s[i11] = i11 - 48;
        }
        for (int i12 = 97; i12 <= 102; i12++) {
            f78970s[i12] = i12 - 87;
        }
        for (int i13 = 65; i13 <= 70; i13++) {
            f78970s[i13] = i13 - 55;
        }
    }

    public c(int i11) {
        this.f78985o = null;
        this.f78973c = i11;
        if ((i11 & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.f78985o = "";
        }
        char[] cArr = (char[]) f78968q.get();
        this.f78977g = cArr;
        if (cArr == null) {
            this.f78977g = new char[512];
        }
    }

    public static boolean M0(char c11) {
        return c11 <= ' ' && (c11 == ' ' || c11 == '\n' || c11 == '\r' || c11 == '\t' || c11 == '\f' || c11 == '\b');
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0044. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x0047. Please report as an issue. */
    public static String S0(char[] cArr, int i11) {
        int i12;
        int i13;
        int i14;
        int i15 = 5;
        char[] cArr2 = new char[i11];
        int i16 = 0;
        int i17 = 0;
        while (i16 < i11) {
            char c11 = cArr[i16];
            if (c11 != '\\') {
                cArr2[i17] = c11;
                i12 = i15;
                i17++;
            } else {
                int i18 = i16 + 1;
                char c12 = cArr[i18];
                if (c12 == '\"') {
                    i12 = i15;
                    i13 = i17 + 1;
                    cArr2[i17] = '\"';
                } else if (c12 != '\'') {
                    if (c12 != 'F') {
                        if (c12 == '\\') {
                            i12 = i15;
                            i13 = i17 + 1;
                            cArr2[i17] = '\\';
                        } else if (c12 == 'b') {
                            i12 = i15;
                            i13 = i17 + 1;
                            cArr2[i17] = '\b';
                        } else if (c12 != 'f') {
                            if (c12 == 'n') {
                                i12 = i15;
                                i13 = i17 + 1;
                                cArr2[i17] = '\n';
                            } else if (c12 == 'r') {
                                i12 = i15;
                                i13 = i17 + 1;
                                cArr2[i17] = '\r';
                            } else if (c12 != 'x') {
                                switch (c12) {
                                    case '/':
                                        i12 = i15;
                                        i13 = i17 + 1;
                                        cArr2[i17] = '/';
                                        break;
                                    case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                                        i12 = i15;
                                        i13 = i17 + 1;
                                        cArr2[i17] = 0;
                                        break;
                                    case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                                        i12 = i15;
                                        i13 = i17 + 1;
                                        cArr2[i17] = 1;
                                        break;
                                    case '2':
                                        i12 = i15;
                                        i13 = i17 + 1;
                                        cArr2[i17] = 2;
                                        break;
                                    case AD_REWARD_USER_VALUE:
                                        i12 = i15;
                                        i13 = i17 + 1;
                                        cArr2[i17] = 3;
                                        break;
                                    case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                                        i12 = i15;
                                        i13 = i17 + 1;
                                        cArr2[i17] = 4;
                                        break;
                                    case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                                        i13 = i17 + 1;
                                        i12 = 5;
                                        cArr2[i17] = 5;
                                        break;
                                    case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                                        i14 = i17 + 1;
                                        cArr2[i17] = 6;
                                        i17 = i14;
                                        i16 = i18;
                                        i12 = 5;
                                        break;
                                    case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                                        i14 = i17 + 1;
                                        cArr2[i17] = 7;
                                        i17 = i14;
                                        i16 = i18;
                                        i12 = 5;
                                        break;
                                    default:
                                        switch (c12) {
                                            case GZIP_ENCODE_ERROR_VALUE:
                                                i14 = i17 + 1;
                                                cArr2[i17] = '\t';
                                                i17 = i14;
                                                i16 = i18;
                                                i12 = 5;
                                                break;
                                            case ASSET_FAILED_STATUS_CODE_VALUE:
                                                char c13 = cArr[i16 + 2];
                                                char c14 = cArr[i16 + 3];
                                                char c15 = cArr[i16 + 4];
                                                i16 += i15;
                                                cArr2[i17] = (char) Integer.parseInt(new String(new char[]{c13, c14, c15, cArr[i16]}), 16);
                                                i17++;
                                                i12 = 5;
                                                break;
                                            case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                                                cArr2[i17] = 11;
                                                i12 = i15;
                                                i17++;
                                                i16 = i18;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i12 = i15;
                                int[] iArr = f78970s;
                                int i19 = iArr[cArr[i16 + 2]] * 16;
                                i16 += 3;
                                cArr2[i17] = (char) (i19 + iArr[cArr[i16]]);
                                i17++;
                            }
                        }
                    }
                    i12 = i15;
                    i13 = i17 + 1;
                    cArr2[i17] = '\f';
                } else {
                    i12 = i15;
                    i13 = i17 + 1;
                    cArr2[i17] = '\'';
                }
                i17 = i13;
                i16 = i18;
            }
            i16++;
            i15 = i12;
        }
        return new String(cArr2, 0, i17);
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0149, code lost:
    
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r5 + r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l1() {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.l1():void");
    }

    @Override // y4.b
    public Locale B0() {
        return this.f78983m;
    }

    @Override // y4.b
    public abstract String C0();

    protected abstract void E0(int i11, char[] cArr, int i12, int i13);

    protected abstract boolean F0(char[] cArr);

    public abstract char G0(int i11);

    protected abstract void H0(int i11, int i12, char[] cArr);

    public double I0() {
        return Double.parseDouble(C0());
    }

    public Calendar J0() {
        return this.f78981k;
    }

    public abstract int K0(char c11, int i11);

    public abstract boolean L0();

    protected void N0(String str, Object... objArr) {
        this.f78971a = 1;
    }

    public final boolean O0(char[] cArr) {
        while (!F0(cArr)) {
            if (!M0(this.f78974d)) {
                return false;
            }
            next();
        }
        int length = this.f78975e + cArr.length;
        this.f78975e = length;
        char G0 = G0(length);
        this.f78974d = G0;
        if (G0 == '{') {
            next();
            this.f78971a = 12;
        } else if (G0 == '[') {
            next();
            this.f78971a = 14;
        } else if (G0 == 'S' && G0(this.f78975e + 1) == 'e' && G0(this.f78975e + 2) == 't' && G0(this.f78975e + 3) == '[') {
            int i11 = this.f78975e + 3;
            this.f78975e = i11;
            this.f78974d = G0(i11);
            this.f78971a = 21;
        } else {
            Z();
        }
        return true;
    }

    public final void P0() {
        while (M0(this.f78974d)) {
            next();
        }
        char c11 = this.f78974d;
        if (c11 == '_' || c11 == '$' || Character.isLetter(c11)) {
            i1();
        } else {
            Z();
        }
    }

    public final void Q0(char c11) {
        this.f78978h = 0;
        while (true) {
            char c12 = this.f78974d;
            if (c12 == c11) {
                next();
                Z();
                return;
            }
            if (c12 != ' ' && c12 != '\n' && c12 != '\r' && c12 != '\t' && c12 != '\f' && c12 != '\b') {
                throw new JSONException("not match " + c11 + " - " + this.f78974d + ", info : " + k());
            }
            next();
        }
    }

    protected final void R0(char c11) {
        int i11 = this.f78978h;
        char[] cArr = this.f78977g;
        if (i11 >= cArr.length) {
            int length = cArr.length * 2;
            if (length < i11) {
                length = i11 + 1;
            }
            char[] cArr2 = new char[length];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.f78977g = cArr2;
        }
        char[] cArr3 = this.f78977g;
        int i12 = this.f78978h;
        this.f78978h = i12 + 1;
        cArr3[i12] = c11;
    }

    @Override // y4.b
    public Enum T(Class cls, i iVar, char c11) {
        String m12 = m1(iVar, c11);
        if (m12 == null) {
            return null;
        }
        return Enum.valueOf(cls, m12);
    }

    public long T0(char[] cArr) {
        this.f78984n = 0;
        if (!F0(cArr)) {
            this.f78984n = -2;
            return 0L;
        }
        int length = cArr.length;
        int i11 = length + 1;
        if (G0(this.f78975e + length) != '\"') {
            this.f78984n = -1;
            return 0L;
        }
        long j11 = -3750763034362895579L;
        while (true) {
            int i12 = i11 + 1;
            char G0 = G0(this.f78975e + i11);
            if (G0 == '\"') {
                int i13 = i11 + 2;
                char G02 = G0(this.f78975e + i12);
                if (G02 == ',') {
                    int i14 = this.f78975e + i13;
                    this.f78975e = i14;
                    this.f78974d = G0(i14);
                    this.f78984n = 3;
                    return j11;
                }
                if (G02 != '}') {
                    this.f78984n = -1;
                    return 0L;
                }
                int i15 = i11 + 3;
                char G03 = G0(this.f78975e + i13);
                if (G03 == ',') {
                    this.f78971a = 16;
                    int i16 = this.f78975e + i15;
                    this.f78975e = i16;
                    this.f78974d = G0(i16);
                } else if (G03 == ']') {
                    this.f78971a = 15;
                    int i17 = this.f78975e + i15;
                    this.f78975e = i17;
                    this.f78974d = G0(i17);
                } else if (G03 == '}') {
                    this.f78971a = 13;
                    int i18 = this.f78975e + i15;
                    this.f78975e = i18;
                    this.f78974d = G0(i18);
                } else {
                    if (G03 != 26) {
                        this.f78984n = -1;
                        return 0L;
                    }
                    this.f78971a = 20;
                    this.f78975e += i11 + 2;
                    this.f78974d = (char) 26;
                }
                this.f78984n = 4;
                return j11;
            }
            j11 = (j11 ^ ((G0 < 'A' || G0 > 'Z') ? G0 : G0 + ' ')) * 1099511628211L;
            if (G0 == '\\') {
                this.f78984n = -1;
                return 0L;
            }
            i11 = i12;
        }
    }

    @Override // y4.b
    public boolean U() {
        int i11 = 0;
        while (true) {
            char G0 = G0(i11);
            if (G0 == 26) {
                this.f78971a = 20;
                return true;
            }
            if (!M0(G0)) {
                return false;
            }
            i11++;
        }
    }

    public final void U0() {
        if (this.f78974d != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f78974d != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f78974d != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f78974d != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f78974d != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        char c11 = this.f78974d;
        if (c11 != ' ' && c11 != ',' && c11 != '}' && c11 != ']' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != 26 && c11 != '\f' && c11 != '\b' && c11 != ':' && c11 != '/') {
            throw new JSONException("scan false error");
        }
        this.f78971a = 7;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a6  */
    @Override // y4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean V(char r10) {
        /*
            r9 = this;
            r0 = 0
            r9.f78984n = r0
            int r1 = r9.f78975e
            char r1 = r9.G0(r1)
            r2 = 116(0x74, float:1.63E-43)
            r3 = 5
            r4 = 101(0x65, float:1.42E-43)
            r5 = -1
            r6 = 3
            r7 = 2
            r8 = 1
            if (r1 != r2) goto L40
            int r1 = r9.f78975e
            int r1 = r1 + r8
            char r1 = r9.G0(r1)
            r2 = 114(0x72, float:1.6E-43)
            if (r1 != r2) goto L3d
            int r1 = r9.f78975e
            int r1 = r1 + r7
            char r1 = r9.G0(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L3d
            int r1 = r9.f78975e
            int r1 = r1 + r6
            char r1 = r9.G0(r1)
            if (r1 != r4) goto L3d
            int r0 = r9.f78975e
            int r0 = r0 + 4
            char r1 = r9.G0(r0)
        L3b:
            r0 = r8
            goto L96
        L3d:
            r9.f78984n = r5
            return r0
        L40:
            r2 = 102(0x66, float:1.43E-43)
            if (r1 != r2) goto L7b
            int r1 = r9.f78975e
            int r1 = r1 + r8
            char r1 = r9.G0(r1)
            r2 = 97
            if (r1 != r2) goto L78
            int r1 = r9.f78975e
            int r1 = r1 + r7
            char r1 = r9.G0(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L78
            int r1 = r9.f78975e
            int r1 = r1 + r6
            char r1 = r9.G0(r1)
            r2 = 115(0x73, float:1.61E-43)
            if (r1 != r2) goto L78
            int r1 = r9.f78975e
            int r1 = r1 + 4
            char r1 = r9.G0(r1)
            if (r1 != r4) goto L78
            int r1 = r9.f78975e
            int r1 = r1 + r3
            char r1 = r9.G0(r1)
            r3 = 6
            goto L96
        L78:
            r9.f78984n = r5
            return r0
        L7b:
            r2 = 49
            if (r1 != r2) goto L88
            int r0 = r9.f78975e
            int r0 = r0 + r8
            char r1 = r9.G0(r0)
            r3 = r7
            goto L3b
        L88:
            r2 = 48
            if (r1 != r2) goto L95
            int r1 = r9.f78975e
            int r1 = r1 + r8
            char r1 = r9.G0(r1)
            r3 = r7
            goto L96
        L95:
            r3 = r8
        L96:
            if (r1 != r10) goto La6
            int r10 = r9.f78975e
            int r10 = r10 + r3
            r9.f78975e = r10
            char r10 = r9.G0(r10)
            r9.f78974d = r10
            r9.f78984n = r6
            return r0
        La6:
            boolean r1 = M0(r1)
            if (r1 == 0) goto Lb7
            int r1 = r9.f78975e
            int r2 = r3 + 1
            int r1 = r1 + r3
            char r1 = r9.G0(r1)
            r3 = r2
            goto L96
        Lb7:
            r9.f78984n = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.V(char):boolean");
    }

    public BigInteger V0(char[] cArr) {
        int i11;
        char G0;
        boolean z10;
        int length;
        int i12;
        BigInteger bigInteger;
        this.f78984n = 0;
        if (!F0(cArr)) {
            this.f78984n = -2;
            return null;
        }
        int length2 = cArr.length;
        int i13 = length2 + 1;
        char G02 = G0(this.f78975e + length2);
        boolean z11 = G02 == '\"';
        if (z11) {
            G02 = G0(this.f78975e + i13);
            i13 = length2 + 2;
        }
        boolean z12 = G02 == '-';
        if (z12) {
            G02 = G0(this.f78975e + i13);
            i13++;
        }
        if (G02 >= '0') {
            char c11 = '9';
            if (G02 <= '9') {
                long j11 = G02 - '0';
                while (true) {
                    i11 = i13 + 1;
                    G0 = G0(this.f78975e + i13);
                    if (G0 < '0' || G0 > c11) {
                        break;
                    }
                    long j12 = (10 * j11) + (G0 - '0');
                    if (j12 < j11) {
                        z10 = true;
                        break;
                    }
                    j11 = j12;
                    i13 = i11;
                    c11 = '9';
                }
                z10 = false;
                if (!z11) {
                    int i14 = this.f78975e;
                    length = cArr.length + i14;
                    i12 = ((i14 + i11) - length) - 1;
                } else {
                    if (G0 != '\"') {
                        this.f78984n = -1;
                        return null;
                    }
                    int i15 = i13 + 2;
                    G0 = G0(this.f78975e + i11);
                    int i16 = this.f78975e;
                    length = cArr.length + i16 + 1;
                    i12 = ((i16 + i15) - length) - 2;
                    i11 = i15;
                }
                if (!z10 && (i12 < 20 || (z12 && i12 < 21))) {
                    if (z12) {
                        j11 = -j11;
                    }
                    bigInteger = BigInteger.valueOf(j11);
                } else {
                    if (i12 > 65535) {
                        throw new JSONException("scanInteger overflow");
                    }
                    bigInteger = new BigInteger(r1(length, i12), 10);
                }
                if (G0 == ',') {
                    int i17 = this.f78975e + i11;
                    this.f78975e = i17;
                    this.f78974d = G0(i17);
                    this.f78984n = 3;
                    this.f78971a = 16;
                    return bigInteger;
                }
                if (G0 != '}') {
                    this.f78984n = -1;
                    return null;
                }
                int i18 = i11 + 1;
                char G03 = G0(this.f78975e + i11);
                if (G03 == ',') {
                    this.f78971a = 16;
                    int i19 = this.f78975e + i18;
                    this.f78975e = i19;
                    this.f78974d = G0(i19);
                } else if (G03 == ']') {
                    this.f78971a = 15;
                    int i20 = this.f78975e + i18;
                    this.f78975e = i20;
                    this.f78974d = G0(i20);
                } else if (G03 == '}') {
                    this.f78971a = 13;
                    int i21 = this.f78975e + i18;
                    this.f78975e = i21;
                    this.f78974d = G0(i21);
                } else {
                    if (G03 != 26) {
                        this.f78984n = -1;
                        return null;
                    }
                    this.f78971a = 20;
                    this.f78975e += i11;
                    this.f78974d = (char) 26;
                }
                this.f78984n = 4;
                return bigInteger;
            }
        }
        if (G02 != 'n' || G0(this.f78975e + i13) != 'u' || G0(this.f78975e + i13 + 1) != 'l' || G0(this.f78975e + i13 + 2) != 'l') {
            this.f78984n = -1;
            return null;
        }
        this.f78984n = 5;
        int i22 = i13 + 4;
        char G04 = G0(this.f78975e + i13 + 3);
        if (z11 && G04 == '\"') {
            G04 = G0(this.f78975e + i22);
            i22 = i13 + 5;
        }
        while (G04 != ',') {
            if (G04 == '}') {
                int i23 = this.f78975e + i22;
                this.f78975e = i23;
                this.f78974d = G0(i23);
                this.f78984n = 5;
                this.f78971a = 13;
                return null;
            }
            if (!M0(G04)) {
                this.f78984n = -1;
                return null;
            }
            G04 = G0(this.f78975e + i22);
            i22++;
        }
        int i24 = this.f78975e + i22;
        this.f78975e = i24;
        this.f78974d = G0(i24);
        this.f78984n = 5;
        this.f78971a = 16;
        return null;
    }

    public abstract boolean W0(char[] cArr);

    public abstract Date X0(char[] cArr);

    public BigDecimal Y0(char[] cArr) {
        int i11;
        char G0;
        int length;
        int i12;
        this.f78984n = 0;
        if (!F0(cArr)) {
            this.f78984n = -2;
            return null;
        }
        int length2 = cArr.length;
        int i13 = length2 + 1;
        char G02 = G0(this.f78975e + length2);
        boolean z10 = G02 == '\"';
        if (z10) {
            G02 = G0(this.f78975e + i13);
            i13 = length2 + 2;
        }
        if (G02 == '-') {
            G02 = G0(this.f78975e + i13);
            i13++;
        }
        if (G02 < '0' || G02 > '9') {
            if (G02 != 'n' || G0(this.f78975e + i13) != 'u' || G0(this.f78975e + i13 + 1) != 'l' || G0(this.f78975e + i13 + 2) != 'l') {
                this.f78984n = -1;
                return null;
            }
            this.f78984n = 5;
            int i14 = i13 + 4;
            char G03 = G0(this.f78975e + i13 + 3);
            if (z10 && G03 == '\"') {
                G03 = G0(this.f78975e + i14);
                i14 = i13 + 5;
            }
            while (G03 != ',') {
                if (G03 == '}') {
                    int i15 = this.f78975e + i14;
                    this.f78975e = i15;
                    this.f78974d = G0(i15);
                    this.f78984n = 5;
                    this.f78971a = 13;
                    return null;
                }
                if (!M0(G03)) {
                    this.f78984n = -1;
                    return null;
                }
                G03 = G0(this.f78975e + i14);
                i14++;
            }
            int i16 = this.f78975e + i14;
            this.f78975e = i16;
            this.f78974d = G0(i16);
            this.f78984n = 5;
            this.f78971a = 16;
            return null;
        }
        while (true) {
            i11 = i13 + 1;
            G0 = G0(this.f78975e + i13);
            if (G0 < '0' || G0 > '9') {
                break;
            }
            i13 = i11;
        }
        if (G0 == '.') {
            int i17 = i13 + 2;
            char G04 = G0(this.f78975e + i11);
            if (G04 >= '0' && G04 <= '9') {
                while (true) {
                    i11 = i17 + 1;
                    G0 = G0(this.f78975e + i17);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    i17 = i11;
                }
            } else {
                this.f78984n = -1;
                return null;
            }
        }
        if (G0 == 'e' || G0 == 'E') {
            int i18 = i11 + 1;
            G0 = G0(this.f78975e + i11);
            if (G0 == '+' || G0 == '-') {
                i11 += 2;
                G0 = G0(this.f78975e + i18);
            } else {
                i11 = i18;
            }
            while (G0 >= '0' && G0 <= '9') {
                char G05 = G0(this.f78975e + i11);
                i11++;
                G0 = G05;
            }
        }
        if (!z10) {
            int i19 = this.f78975e;
            length = cArr.length + i19;
            i12 = ((i19 + i11) - length) - 1;
        } else {
            if (G0 != '\"') {
                this.f78984n = -1;
                return null;
            }
            int i20 = i11 + 1;
            char G06 = G0(this.f78975e + i11);
            int i21 = this.f78975e;
            length = cArr.length + i21 + 1;
            i12 = ((i21 + i20) - length) - 2;
            i11 = i20;
            G0 = G06;
        }
        if (i12 > 65535) {
            throw new JSONException("scan decimal overflow");
        }
        char[] s12 = s1(length, i12);
        BigDecimal bigDecimal = new BigDecimal(s12, 0, s12.length, MathContext.UNLIMITED);
        if (G0 == ',') {
            int i22 = this.f78975e + i11;
            this.f78975e = i22;
            this.f78974d = G0(i22);
            this.f78984n = 3;
            this.f78971a = 16;
            return bigDecimal;
        }
        if (G0 != '}') {
            this.f78984n = -1;
            return null;
        }
        int i23 = i11 + 1;
        char G07 = G0(this.f78975e + i11);
        if (G07 == ',') {
            this.f78971a = 16;
            int i24 = this.f78975e + i23;
            this.f78975e = i24;
            this.f78974d = G0(i24);
        } else if (G07 == ']') {
            this.f78971a = 15;
            int i25 = this.f78975e + i23;
            this.f78975e = i25;
            this.f78974d = G0(i25);
        } else if (G07 == '}') {
            this.f78971a = 13;
            int i26 = this.f78975e + i23;
            this.f78975e = i26;
            this.f78974d = G0(i26);
        } else {
            if (G07 != 26) {
                this.f78984n = -1;
                return null;
            }
            this.f78971a = 20;
            this.f78975e += i11;
            this.f78974d = (char) 26;
        }
        this.f78984n = 4;
        return bigDecimal;
    }

    @Override // y4.b
    public final void Z() {
        this.f78978h = 0;
        while (true) {
            this.f78972b = this.f78975e;
            char c11 = this.f78974d;
            if (c11 == '/') {
                p1();
            } else {
                if (c11 == '\"') {
                    a0();
                    return;
                }
                if (c11 == ',') {
                    next();
                    this.f78971a = 16;
                    return;
                }
                if (c11 >= '0' && c11 <= '9') {
                    p();
                    return;
                }
                if (c11 == '-') {
                    p();
                    return;
                }
                switch (c11) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        break;
                    case '\'':
                        if (!n(Feature.AllowSingleQuotes)) {
                            throw new JSONException("Feature.AllowSingleQuotes is false");
                        }
                        l1();
                        return;
                    case '(':
                        next();
                        this.f78971a = 10;
                        return;
                    case ')':
                        next();
                        this.f78971a = 11;
                        return;
                    case '+':
                        next();
                        p();
                        return;
                    case '.':
                        next();
                        this.f78971a = 25;
                        return;
                    case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                        next();
                        this.f78971a = 17;
                        return;
                    case ';':
                        next();
                        this.f78971a = 24;
                        return;
                    case 'N':
                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_BACK_SHOW /* 83 */:
                    case 'T':
                    case ASSET_FAILED_STATUS_CODE_VALUE:
                        i1();
                        return;
                    case '[':
                        next();
                        this.f78971a = 14;
                        return;
                    case ']':
                        next();
                        this.f78971a = 15;
                        return;
                    case 'f':
                        U0();
                        return;
                    case 'n':
                        j1();
                        return;
                    case GZIP_ENCODE_ERROR_VALUE:
                        n1();
                        return;
                    case 'x':
                        h1();
                        return;
                    case INVALID_RI_ENDPOINT_VALUE:
                        next();
                        this.f78971a = 12;
                        return;
                    case INVALID_METRICS_ENDPOINT_VALUE:
                        next();
                        this.f78971a = 13;
                        return;
                    default:
                        if (L0()) {
                            if (this.f78971a == 20) {
                                throw new JSONException("EOF error");
                            }
                            this.f78971a = 20;
                            int i11 = this.f78975e;
                            this.f78972b = i11;
                            this.f78976f = i11;
                            return;
                        }
                        char c12 = this.f78974d;
                        if (c12 > 31 && c12 != 127) {
                            N0("illegal.char", String.valueOf((int) c12));
                            next();
                            return;
                        } else {
                            next();
                            break;
                        }
                }
            }
        }
    }

    public final double Z0(char[] cArr) {
        int i11;
        char G0;
        long j11;
        int length;
        int i12;
        double parseDouble;
        this.f78984n = 0;
        if (!F0(cArr)) {
            this.f78984n = -2;
            return 0.0d;
        }
        int length2 = cArr.length;
        int i13 = length2 + 1;
        char G02 = G0(this.f78975e + length2);
        boolean z10 = G02 == '\"';
        if (z10) {
            G02 = G0(this.f78975e + i13);
            i13 = length2 + 2;
        }
        boolean z11 = G02 == '-';
        if (z11) {
            G02 = G0(this.f78975e + i13);
            i13++;
        }
        if (G02 < '0' || G02 > '9') {
            if (G02 != 'n' || G0(this.f78975e + i13) != 'u' || G0(this.f78975e + i13 + 1) != 'l' || G0(this.f78975e + i13 + 2) != 'l') {
                this.f78984n = -1;
                return 0.0d;
            }
            this.f78984n = 5;
            int i14 = i13 + 4;
            char G03 = G0(this.f78975e + i13 + 3);
            if (z10 && G03 == '\"') {
                G03 = G0(this.f78975e + i14);
                i14 = i13 + 5;
            }
            while (G03 != ',') {
                if (G03 == '}') {
                    int i15 = this.f78975e + i14;
                    this.f78975e = i15;
                    this.f78974d = G0(i15);
                    this.f78984n = 5;
                    this.f78971a = 13;
                    return 0.0d;
                }
                if (!M0(G03)) {
                    this.f78984n = -1;
                    return 0.0d;
                }
                G03 = G0(this.f78975e + i14);
                i14++;
            }
            int i16 = this.f78975e + i14;
            this.f78975e = i16;
            this.f78974d = G0(i16);
            this.f78984n = 5;
            this.f78971a = 16;
            return 0.0d;
        }
        long j12 = G02 - '0';
        while (true) {
            i11 = i13 + 1;
            G0 = G0(this.f78975e + i13);
            if (G0 < '0' || G0 > '9') {
                break;
            }
            j12 = (j12 * 10) + (G0 - '0');
            i13 = i11;
        }
        if (G0 == '.') {
            int i17 = i13 + 2;
            char G04 = G0(this.f78975e + i11);
            if (G04 >= '0' && G04 <= '9') {
                j12 = (j12 * 10) + (G04 - '0');
                j11 = 10;
                while (true) {
                    i11 = i17 + 1;
                    G0 = G0(this.f78975e + i17);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    j12 = (j12 * 10) + (G0 - '0');
                    j11 *= 10;
                    i17 = i11;
                }
            } else {
                this.f78984n = -1;
                return 0.0d;
            }
        } else {
            j11 = 1;
        }
        boolean z12 = G0 == 'e' || G0 == 'E';
        if (z12) {
            int i18 = i11 + 1;
            G0 = G0(this.f78975e + i11);
            if (G0 == '+' || G0 == '-') {
                i11 += 2;
                G0 = G0(this.f78975e + i18);
            } else {
                i11 = i18;
            }
            while (G0 >= '0' && G0 <= '9') {
                G0 = G0(this.f78975e + i11);
                i11++;
            }
        }
        if (!z10) {
            int i19 = this.f78975e;
            length = cArr.length + i19;
            i12 = ((i19 + i11) - length) - 1;
        } else {
            if (G0 != '\"') {
                this.f78984n = -1;
                return 0.0d;
            }
            int i20 = i11 + 1;
            G0 = G0(this.f78975e + i11);
            int i21 = this.f78975e;
            length = cArr.length + i21 + 1;
            i12 = ((i21 + i20) - length) - 2;
            i11 = i20;
        }
        if (z12 || i12 >= 17) {
            parseDouble = Double.parseDouble(r1(length, i12));
        } else {
            parseDouble = j12 / j11;
            if (z11) {
                parseDouble = -parseDouble;
            }
        }
        if (G0 == ',') {
            int i22 = this.f78975e + i11;
            this.f78975e = i22;
            this.f78974d = G0(i22);
            this.f78984n = 3;
            this.f78971a = 16;
            return parseDouble;
        }
        if (G0 != '}') {
            this.f78984n = -1;
            return 0.0d;
        }
        int i23 = i11 + 1;
        char G05 = G0(this.f78975e + i11);
        if (G05 == ',') {
            this.f78971a = 16;
            int i24 = this.f78975e + i23;
            this.f78975e = i24;
            this.f78974d = G0(i24);
        } else if (G05 == ']') {
            this.f78971a = 15;
            int i25 = this.f78975e + i23;
            this.f78975e = i25;
            this.f78974d = G0(i25);
        } else if (G05 == '}') {
            this.f78971a = 13;
            int i26 = this.f78975e + i23;
            this.f78975e = i26;
            this.f78974d = G0(i26);
        } else {
            if (G05 != 26) {
                this.f78984n = -1;
                return 0.0d;
            }
            this.f78971a = 20;
            this.f78975e += i11;
            this.f78974d = (char) 26;
        }
        this.f78984n = 4;
        return parseDouble;
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x016f, code lost:
    
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r5 + r7);
     */
    @Override // y4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0() {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.a0():void");
    }

    public final float a1(char[] cArr) {
        int i11;
        char G0;
        long j11;
        int length;
        int i12;
        float parseFloat;
        this.f78984n = 0;
        if (!F0(cArr)) {
            this.f78984n = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i13 = length2 + 1;
        char G02 = G0(this.f78975e + length2);
        boolean z10 = G02 == '\"';
        if (z10) {
            G02 = G0(this.f78975e + i13);
            i13 = length2 + 2;
        }
        boolean z11 = G02 == '-';
        if (z11) {
            G02 = G0(this.f78975e + i13);
            i13++;
        }
        if (G02 < '0' || G02 > '9') {
            if (G02 != 'n' || G0(this.f78975e + i13) != 'u' || G0(this.f78975e + i13 + 1) != 'l' || G0(this.f78975e + i13 + 2) != 'l') {
                this.f78984n = -1;
                return 0.0f;
            }
            this.f78984n = 5;
            int i14 = i13 + 4;
            char G03 = G0(this.f78975e + i13 + 3);
            if (z10 && G03 == '\"') {
                G03 = G0(this.f78975e + i14);
                i14 = i13 + 5;
            }
            while (G03 != ',') {
                if (G03 == '}') {
                    int i15 = this.f78975e + i14;
                    this.f78975e = i15;
                    this.f78974d = G0(i15);
                    this.f78984n = 5;
                    this.f78971a = 13;
                    return 0.0f;
                }
                if (!M0(G03)) {
                    this.f78984n = -1;
                    return 0.0f;
                }
                G03 = G0(this.f78975e + i14);
                i14++;
            }
            int i16 = this.f78975e + i14;
            this.f78975e = i16;
            this.f78974d = G0(i16);
            this.f78984n = 5;
            this.f78971a = 16;
            return 0.0f;
        }
        long j12 = G02 - '0';
        while (true) {
            i11 = i13 + 1;
            G0 = G0(this.f78975e + i13);
            if (G0 < '0' || G0 > '9') {
                break;
            }
            j12 = (j12 * 10) + (G0 - '0');
            i13 = i11;
        }
        if (G0 == '.') {
            int i17 = i13 + 2;
            char G04 = G0(this.f78975e + i11);
            if (G04 >= '0' && G04 <= '9') {
                j12 = (j12 * 10) + (G04 - '0');
                j11 = 10;
                while (true) {
                    i11 = i17 + 1;
                    G0 = G0(this.f78975e + i17);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    j12 = (j12 * 10) + (G0 - '0');
                    j11 *= 10;
                    i17 = i11;
                }
            } else {
                this.f78984n = -1;
                return 0.0f;
            }
        } else {
            j11 = 1;
        }
        boolean z12 = G0 == 'e' || G0 == 'E';
        if (z12) {
            int i18 = i11 + 1;
            G0 = G0(this.f78975e + i11);
            if (G0 == '+' || G0 == '-') {
                i11 += 2;
                G0 = G0(this.f78975e + i18);
            } else {
                i11 = i18;
            }
            while (G0 >= '0' && G0 <= '9') {
                char G05 = G0(this.f78975e + i11);
                i11++;
                G0 = G05;
            }
        }
        if (!z10) {
            int i19 = this.f78975e;
            length = cArr.length + i19;
            i12 = ((i19 + i11) - length) - 1;
        } else {
            if (G0 != '\"') {
                this.f78984n = -1;
                return 0.0f;
            }
            int i20 = i11 + 1;
            G0 = G0(this.f78975e + i11);
            int i21 = this.f78975e;
            length = cArr.length + i21 + 1;
            i12 = ((i21 + i20) - length) - 2;
            i11 = i20;
        }
        if (z12 || i12 >= 17) {
            parseFloat = Float.parseFloat(r1(length, i12));
        } else {
            parseFloat = (float) (j12 / j11);
            if (z11) {
                parseFloat = -parseFloat;
            }
        }
        if (G0 == ',') {
            int i22 = this.f78975e + i11;
            this.f78975e = i22;
            this.f78974d = G0(i22);
            this.f78984n = 3;
            this.f78971a = 16;
            return parseFloat;
        }
        if (G0 != '}') {
            this.f78984n = -1;
            return 0.0f;
        }
        int i23 = i11 + 1;
        char G06 = G0(this.f78975e + i11);
        if (G06 == ',') {
            this.f78971a = 16;
            int i24 = this.f78975e + i23;
            this.f78975e = i24;
            this.f78974d = G0(i24);
        } else if (G06 == ']') {
            this.f78971a = 15;
            int i25 = this.f78975e + i23;
            this.f78975e = i25;
            this.f78974d = G0(i25);
        } else if (G06 == '}') {
            this.f78971a = 13;
            int i26 = this.f78975e + i23;
            this.f78975e = i26;
            this.f78974d = G0(i26);
        } else {
            if (G06 != 26) {
                this.f78984n = -1;
                return 0.0f;
            }
            this.f78975e += i11;
            this.f78971a = 20;
            this.f78974d = (char) 26;
        }
        this.f78984n = 4;
        return parseFloat;
    }

    public abstract String b(int i11, int i12, int i13, i iVar);

    /* JADX WARN: Code restructure failed: missing block: B:107:0x01b6, code lost:
    
        r1 = r4;
        r19.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01b9, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[] b1(char[] r20) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.b1(char[]):float[]");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0029. Please report as an issue. */
    @Override // y4.b
    public final void c0(int i11) {
        this.f78978h = 0;
        while (true) {
            if (i11 == 2) {
                char c11 = this.f78974d;
                if (c11 >= '0' && c11 <= '9') {
                    this.f78972b = this.f78975e;
                    p();
                    return;
                }
                if (c11 == '\"') {
                    this.f78972b = this.f78975e;
                    a0();
                    return;
                } else if (c11 == '[') {
                    this.f78971a = 14;
                    next();
                    return;
                } else if (c11 == '{') {
                    this.f78971a = 12;
                    next();
                    return;
                }
            } else if (i11 == 4) {
                char c12 = this.f78974d;
                if (c12 == '\"') {
                    this.f78972b = this.f78975e;
                    a0();
                    return;
                }
                if (c12 >= '0' && c12 <= '9') {
                    this.f78972b = this.f78975e;
                    p();
                    return;
                } else if (c12 == '[') {
                    this.f78971a = 14;
                    next();
                    return;
                } else if (c12 == '{') {
                    this.f78971a = 12;
                    next();
                    return;
                }
            } else if (i11 == 12) {
                char c13 = this.f78974d;
                if (c13 == '{') {
                    this.f78971a = 12;
                    next();
                    return;
                } else if (c13 == '[') {
                    this.f78971a = 14;
                    next();
                    return;
                }
            } else {
                if (i11 == 18) {
                    P0();
                    return;
                }
                if (i11 != 20) {
                    switch (i11) {
                        case 14:
                            char c14 = this.f78974d;
                            if (c14 == '[') {
                                this.f78971a = 14;
                                next();
                                return;
                            } else if (c14 == '{') {
                                this.f78971a = 12;
                                next();
                                return;
                            }
                            break;
                        case 15:
                            if (this.f78974d == ']') {
                                this.f78971a = 15;
                                next();
                                return;
                            }
                            break;
                        case 16:
                            char c15 = this.f78974d;
                            if (c15 == ',') {
                                this.f78971a = 16;
                                next();
                                return;
                            }
                            if (c15 == '}') {
                                this.f78971a = 13;
                                next();
                                return;
                            } else if (c15 == ']') {
                                this.f78971a = 15;
                                next();
                                return;
                            } else if (c15 == 26) {
                                this.f78971a = 20;
                                return;
                            } else if (c15 == 'n') {
                                k1(false);
                                return;
                            }
                            break;
                    }
                }
                if (this.f78974d == 26) {
                    this.f78971a = 20;
                    return;
                }
            }
            char c16 = this.f78974d;
            if (c16 != ' ' && c16 != '\n' && c16 != '\r' && c16 != '\t' && c16 != '\f' && c16 != '\b') {
                Z();
                return;
            }
            next();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x014a, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00b2, code lost:
    
        r21.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00b4, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0193, code lost:
    
        r21.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0196, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0135, code lost:
    
        r4 = r18 + 1;
        r1 = G0(r21.f78975e + r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0140, code lost:
    
        if (r2 == r3.length) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0142, code lost:
    
        r5 = new float[r2];
        r7 = 0;
        java.lang.System.arraycopy(r3, 0, r5, 0, r2);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x014c, code lost:
    
        if (r8 < r6.length) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x014e, code lost:
    
        r5 = new float[(r6.length * 3) / 2];
        java.lang.System.arraycopy(r3, r7, r5, r7, r2);
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0159, code lost:
    
        r5 = r8 + 1;
        r6[r8] = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x015f, code lost:
    
        if (r1 != ',') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0161, code lost:
    
        r3 = G0(r21.f78975e + r4);
        r2 = r18 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0170, code lost:
    
        if (r1 != ']') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x017d, code lost:
    
        r3 = r1;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0172, code lost:
    
        r2 = r18 + 2;
        r3 = G0(r21.f78975e + r4);
        r8 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[][] c1(char[] r22) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.c1(char[]):float[][]");
    }

    @Override // y4.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.f78977g;
        if (cArr.length <= 8192) {
            f78968q.set(cArr);
        }
        this.f78977g = null;
    }

    @Override // y4.b
    public final char d() {
        return this.f78974d;
    }

    @Override // y4.b
    public abstract BigDecimal d0();

    public abstract int d1(char[] cArr);

    public final int[] e1(char[] cArr) {
        boolean z10;
        int i11;
        char G0;
        int i12;
        char G02;
        int i13;
        int[] iArr;
        this.f78984n = 0;
        int[] iArr2 = null;
        if (!F0(cArr)) {
            this.f78984n = -2;
            return null;
        }
        int length = cArr.length;
        int i14 = length + 1;
        if (G0(this.f78975e + length) != '[') {
            this.f78984n = -2;
            return null;
        }
        int i15 = length + 2;
        char G03 = G0(this.f78975e + i14);
        int[] iArr3 = new int[16];
        if (G03 != ']') {
            int i16 = 0;
            while (true) {
                if (G03 == '-') {
                    G03 = G0(this.f78975e + i15);
                    i15++;
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (G03 < '0' || G03 > '9') {
                    break;
                }
                int i17 = G03 - '0';
                while (true) {
                    i11 = i15 + 1;
                    G0 = G0(this.f78975e + i15);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    i17 = (i17 * 10) + (G0 - '0');
                    i15 = i11;
                }
                if (i16 >= iArr3.length) {
                    int[] iArr4 = new int[(iArr3.length * 3) / 2];
                    System.arraycopy(iArr3, 0, iArr4, 0, i16);
                    iArr3 = iArr4;
                }
                i12 = i16 + 1;
                if (z10) {
                    i17 = -i17;
                }
                iArr3[i16] = i17;
                if (G0 == ',') {
                    i15 += 2;
                    G03 = G0(this.f78975e + i11);
                    iArr = null;
                } else {
                    if (G0 == ']') {
                        G02 = G0(this.f78975e + i11);
                        i13 = i15 + 2;
                        break;
                    }
                    iArr = null;
                    G03 = G0;
                    i15 = i11;
                }
                iArr2 = iArr;
                i16 = i12;
            }
            int[] iArr5 = iArr2;
            this.f78984n = -1;
            return iArr5;
        }
        i13 = length + 3;
        G02 = G0(this.f78975e + i15);
        i12 = 0;
        if (i12 != iArr3.length) {
            int[] iArr6 = new int[i12];
            System.arraycopy(iArr3, 0, iArr6, 0, i12);
            iArr3 = iArr6;
        }
        if (G02 == ',') {
            this.f78975e += i13 - 1;
            next();
            this.f78984n = 3;
            this.f78971a = 16;
            return iArr3;
        }
        if (G02 != '}') {
            this.f78984n = -1;
            return null;
        }
        char G04 = G0(this.f78975e + i13);
        if (G04 == ',') {
            this.f78971a = 16;
            this.f78975e += i13;
            next();
        } else if (G04 == ']') {
            this.f78971a = 15;
            this.f78975e += i13;
            next();
        } else if (G04 == '}') {
            this.f78971a = 13;
            this.f78975e += i13;
            next();
        } else {
            if (G04 != 26) {
                this.f78984n = -1;
                return null;
            }
            this.f78975e += i13;
            this.f78971a = 20;
            this.f78974d = (char) 26;
        }
        this.f78984n = 4;
        return iArr3;
    }

    public abstract long f1(char[] cArr);

    public abstract String g1(char[] cArr);

    @Override // y4.b
    public final int h() {
        return this.f78972b;
    }

    public final void h1() {
        char next;
        if (this.f78974d != 'x') {
            throw new JSONException("illegal state. " + this.f78974d);
        }
        next();
        if (this.f78974d != '\'') {
            throw new JSONException("illegal state. " + this.f78974d);
        }
        this.f78979i = this.f78975e;
        next();
        if (this.f78974d == '\'') {
            next();
            this.f78971a = 26;
            return;
        }
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            } else {
                this.f78978h++;
            }
        }
        if (next == '\'') {
            this.f78978h++;
            next();
            this.f78971a = 26;
        } else {
            throw new JSONException("illegal state. " + next);
        }
    }

    @Override // y4.b
    public final String i(i iVar) {
        u0();
        char c11 = this.f78974d;
        if (c11 == '\"') {
            return y0(iVar, '\"');
        }
        if (c11 == '\'') {
            if (n(Feature.AllowSingleQuotes)) {
                return y0(iVar, '\'');
            }
            throw new JSONException("syntax error");
        }
        if (c11 == '}') {
            next();
            this.f78971a = 13;
            return null;
        }
        if (c11 == ',') {
            next();
            this.f78971a = 16;
            return null;
        }
        if (c11 == 26) {
            this.f78971a = 20;
            return null;
        }
        if (n(Feature.AllowUnQuotedFieldNames)) {
            return w(iVar);
        }
        throw new JSONException("syntax error");
    }

    public final void i1() {
        this.f78979i = this.f78975e - 1;
        this.f78980j = false;
        do {
            this.f78978h++;
            next();
        } while (Character.isLetterOrDigit(this.f78974d));
        String k02 = k0();
        if ("null".equalsIgnoreCase(k02)) {
            this.f78971a = 8;
            return;
        }
        if ("new".equals(k02)) {
            this.f78971a = 9;
            return;
        }
        if ("true".equals(k02)) {
            this.f78971a = 6;
            return;
        }
        if ("false".equals(k02)) {
            this.f78971a = 7;
            return;
        }
        if ("undefined".equals(k02)) {
            this.f78971a = 23;
            return;
        }
        if ("Set".equals(k02)) {
            this.f78971a = 21;
        } else if ("TreeSet".equals(k02)) {
            this.f78971a = 22;
        } else {
            this.f78971a = 18;
        }
    }

    @Override // y4.b
    public final boolean isEnabled(int i11) {
        return (i11 & this.f78973c) != 0;
    }

    public final void j1() {
        k1(true);
    }

    @Override // y4.b
    public abstract String k();

    @Override // y4.b
    public abstract String k0();

    public final void k1(boolean z10) {
        if (this.f78974d != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        char c11 = this.f78974d;
        if (c11 != 'u') {
            if (c11 != 'e') {
                throw new JSONException("error parse new");
            }
            next();
            if (this.f78974d != 'w') {
                throw new JSONException("error parse new");
            }
            next();
            char c12 = this.f78974d;
            if (c12 != ' ' && c12 != ',' && c12 != '}' && c12 != ']' && c12 != '\n' && c12 != '\r' && c12 != '\t' && c12 != 26 && c12 != '\f' && c12 != '\b') {
                throw new JSONException("scan new error");
            }
            this.f78971a = 9;
            return;
        }
        next();
        if (this.f78974d != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        if (this.f78974d != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        char c13 = this.f78974d;
        if (c13 != ' ' && c13 != ',' && c13 != '}' && c13 != ']' && c13 != '\n' && c13 != '\r' && c13 != '\t' && c13 != 26 && ((c13 != ':' || !z10) && c13 != '\f' && c13 != '\b')) {
            throw new JSONException("scan null error");
        }
        this.f78971a = 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005c -> B:9:0x002e). Please report as a decompilation issue!!! */
    @Override // y4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l() {
        /*
            r13 = this;
            int r0 = r13.f78979i
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L8
            r13.f78979i = r2
        L8:
            int r0 = r13.f78979i
            int r1 = r13.f78978h
            int r1 = r1 + r0
            char r3 = r13.G0(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L1d
            int r0 = r0 + 1
            r2 = -9223372036854775808
            r3 = r2
            r2 = r5
            goto L22
        L1d:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L22:
            if (r0 >= r1) goto L30
            int r6 = r0 + 1
            char r0 = r13.G0(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L2e:
            r0 = r6
            goto L32
        L30:
            r7 = 0
        L32:
            if (r0 >= r1) goto L73
            int r6 = r0 + 1
            char r0 = r13.G0(r0)
            r9 = 76
            if (r0 == r9) goto L72
            r9 = 83
            if (r0 == r9) goto L72
            r9 = 66
            if (r0 != r9) goto L47
            goto L72
        L47:
            int r0 = r0 + (-48)
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 < 0) goto L68
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r3 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L5e
            long r7 = r7 - r9
            goto L2e
        L5e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.C0()
            r0.<init>(r1)
            throw r0
        L68:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.C0()
            r0.<init>(r1)
            throw r0
        L72:
            r0 = r6
        L73:
            if (r2 == 0) goto L85
            int r1 = r13.f78979i
            int r1 = r1 + r5
            if (r0 <= r1) goto L7b
            return r7
        L7b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.C0()
            r0.<init>(r1)
            throw r0
        L85:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.l():long");
    }

    @Override // y4.b
    public TimeZone l0() {
        return this.f78982l;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c5 -> B:41:0x00b4). Please report as a decompilation issue!!! */
    @Override // y4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float m(char r21) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.m(char):float");
    }

    public String m1(i iVar, char c11) {
        int i11 = 0;
        this.f78984n = 0;
        char G0 = G0(this.f78975e);
        if (G0 == 'n') {
            if (G0(this.f78975e + 1) != 'u' || G0(this.f78975e + 2) != 'l' || G0(this.f78975e + 3) != 'l') {
                this.f78984n = -1;
                return null;
            }
            if (G0(this.f78975e + 4) != c11) {
                this.f78984n = -1;
                return null;
            }
            int i12 = this.f78975e + 5;
            this.f78975e = i12;
            this.f78974d = G0(i12);
            this.f78984n = 3;
            return null;
        }
        if (G0 != '\"') {
            this.f78984n = -1;
            return null;
        }
        int i13 = 1;
        while (true) {
            int i14 = i13 + 1;
            char G02 = G0(this.f78975e + i13);
            if (G02 == '\"') {
                int i15 = this.f78975e;
                int i16 = i15 + 1;
                String b11 = b(i16, ((i15 + i14) - i16) - 1, i11, iVar);
                int i17 = i13 + 2;
                char G03 = G0(this.f78975e + i14);
                while (G03 != c11) {
                    if (!M0(G03)) {
                        this.f78984n = -1;
                        return b11;
                    }
                    G03 = G0(this.f78975e + i17);
                    i17++;
                }
                int i18 = this.f78975e + i17;
                this.f78975e = i18;
                this.f78974d = G0(i18);
                this.f78984n = 3;
                return b11;
            }
            i11 = (i11 * 31) + G02;
            if (G02 == '\\') {
                this.f78984n = -1;
                return null;
            }
            i13 = i14;
        }
    }

    @Override // y4.b
    public final boolean n(Feature feature) {
        return isEnabled(feature.mask);
    }

    public final void n1() {
        if (this.f78974d != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f78974d != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f78974d != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f78974d != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        char c11 = this.f78974d;
        if (c11 != ' ' && c11 != ',' && c11 != '}' && c11 != ']' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != 26 && c11 != '\f' && c11 != '\b' && c11 != ':' && c11 != '/') {
            throw new JSONException("scan true error");
        }
        this.f78971a = 6;
    }

    @Override // y4.b
    public abstract char next();

    @Override // y4.b
    public final int o() {
        int i11;
        boolean z10;
        int i12 = 0;
        if (this.f78979i == -1) {
            this.f78979i = 0;
        }
        int i13 = this.f78979i;
        int i14 = this.f78978h + i13;
        if (G0(i13) == '-') {
            i13++;
            i11 = Integer.MIN_VALUE;
            z10 = true;
        } else {
            i11 = -2147483647;
            z10 = false;
        }
        if (i13 < i14) {
            i12 = -(G0(i13) - '0');
            i13++;
        }
        while (i13 < i14) {
            int i15 = i13 + 1;
            char G0 = G0(i13);
            if (G0 == 'L' || G0 == 'S' || G0 == 'B') {
                i13 = i15;
                break;
            }
            int i16 = G0 - '0';
            if (i12 < -214748364) {
                throw new NumberFormatException(C0());
            }
            int i17 = i12 * 10;
            if (i17 < i11 + i16) {
                throw new NumberFormatException(C0());
            }
            i12 = i17 - i16;
            i13 = i15;
        }
        if (!z10) {
            return -i12;
        }
        if (i13 > this.f78979i + 1) {
            return i12;
        }
        throw new NumberFormatException(C0());
    }

    @Override // y4.b
    public final Number o0() {
        char c11;
        long j11;
        long j12;
        boolean z10 = false;
        if (this.f78979i == -1) {
            this.f78979i = 0;
        }
        int i11 = this.f78979i;
        int i12 = this.f78978h + i11;
        char G0 = G0(i12 - 1);
        if (G0 == 'B') {
            i12--;
            c11 = 'B';
        } else if (G0 == 'L') {
            i12--;
            c11 = 'L';
        } else if (G0 != 'S') {
            c11 = ' ';
        } else {
            i12--;
            c11 = 'S';
        }
        if (G0(this.f78979i) == '-') {
            i11++;
            j11 = Long.MIN_VALUE;
            z10 = true;
        } else {
            j11 = C.TIME_UNSET;
        }
        if (i11 < i12) {
            j12 = -(G0(i11) - '0');
            i11++;
        } else {
            j12 = 0;
        }
        while (i11 < i12) {
            int i13 = i11 + 1;
            int G02 = G0(i11) - '0';
            if (j12 < Buffer.OVERFLOW_ZONE) {
                return new BigInteger(C0(), 10);
            }
            long j13 = j12 * 10;
            long j14 = G02;
            if (j13 < j11 + j14) {
                return new BigInteger(C0(), 10);
            }
            j12 = j13 - j14;
            i11 = i13;
        }
        if (!z10) {
            long j15 = -j12;
            return (j15 > 2147483647L || c11 == 'L') ? Long.valueOf(j15) : c11 == 'S' ? Short.valueOf((short) j15) : c11 == 'B' ? Byte.valueOf((byte) j15) : Integer.valueOf((int) j15);
        }
        if (i11 > this.f78979i + 1) {
            return (j12 < -2147483648L || c11 == 'L') ? Long.valueOf(j12) : c11 == 'S' ? Short.valueOf((short) j12) : c11 == 'B' ? Byte.valueOf((byte) j12) : Integer.valueOf((int) j12);
        }
        throw new JSONException("illegal number format : " + C0());
    }

    public void o1(TimeZone timeZone) {
        this.f78982l = timeZone;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    @Override // y4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.p():void");
    }

    @Override // y4.b
    public float p0() {
        char charAt;
        String C0 = C0();
        float parseFloat = Float.parseFloat(C0);
        if ((parseFloat != 0.0f && parseFloat != Float.POSITIVE_INFINITY) || (charAt = C0.charAt(0)) <= '0' || charAt > '9') {
            return parseFloat;
        }
        throw new JSONException("float overflow : " + C0);
    }

    protected void p1() {
        char c11;
        next();
        char c12 = this.f78974d;
        if (c12 != '/') {
            if (c12 != '*') {
                throw new JSONException("invalid comment");
            }
            next();
            while (true) {
                char c13 = this.f78974d;
                if (c13 == 26) {
                    return;
                }
                if (c13 == '*') {
                    next();
                    if (this.f78974d == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        }
        do {
            next();
            c11 = this.f78974d;
            if (c11 == '\n') {
                next();
                return;
            }
        } while (c11 != 26);
    }

    @Override // y4.b
    public final void q(int i11) {
        Q0(':');
    }

    @Override // y4.b
    public final int q0() {
        return this.f78971a;
    }

    public final String q1() {
        return this.f78985o;
    }

    @Override // y4.b
    public int r() {
        return this.f78973c;
    }

    @Override // y4.b
    public String r0(char c11) {
        this.f78984n = 0;
        char G0 = G0(this.f78975e);
        if (G0 == 'n') {
            if (G0(this.f78975e + 1) != 'u' || G0(this.f78975e + 2) != 'l' || G0(this.f78975e + 3) != 'l') {
                this.f78984n = -1;
                return null;
            }
            if (G0(this.f78975e + 4) != c11) {
                this.f78984n = -1;
                return null;
            }
            int i11 = this.f78975e + 5;
            this.f78975e = i11;
            this.f78974d = G0(i11);
            this.f78984n = 3;
            return null;
        }
        int i12 = 1;
        while (G0 != '\"') {
            if (!M0(G0)) {
                this.f78984n = -1;
                return q1();
            }
            G0 = G0(this.f78975e + i12);
            i12++;
        }
        int i13 = this.f78975e + i12;
        int K0 = K0('\"', i13);
        if (K0 == -1) {
            throw new JSONException("unclosed str");
        }
        String r12 = r1(this.f78975e + i12, K0 - i13);
        if (r12.indexOf(92) != -1) {
            while (true) {
                int i14 = 0;
                for (int i15 = K0 - 1; i15 >= 0 && G0(i15) == '\\'; i15--) {
                    i14++;
                }
                if (i14 % 2 == 0) {
                    break;
                }
                K0 = K0('\"', K0 + 1);
            }
            int i16 = K0 - i13;
            r12 = S0(s1(this.f78975e + 1, i16), i16);
        }
        int i17 = i12 + (K0 - i13) + 1;
        int i18 = i17 + 1;
        char G02 = G0(this.f78975e + i17);
        while (G02 != c11) {
            if (!M0(G02)) {
                if (G02 == ']') {
                    int i19 = this.f78975e + i18;
                    this.f78975e = i19;
                    this.f78974d = G0(i19);
                    this.f78984n = -1;
                }
                return r12;
            }
            G02 = G0(this.f78975e + i18);
            i18++;
        }
        int i20 = this.f78975e + i18;
        this.f78975e = i20;
        this.f78974d = G0(i20);
        this.f78984n = 3;
        this.f78971a = 16;
        return r12;
    }

    public abstract String r1(int i11, int i12);

    protected abstract char[] s1(int i11, int i12);

    /* JADX WARN: Removed duplicated region for block: B:75:0x0097 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0099 -> B:70:0x0089). Please report as a decompilation issue!!! */
    @Override // y4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.math.BigDecimal t(char r18) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.t(char):java.math.BigDecimal");
    }

    @Override // y4.b
    public final void u() {
        Q0(':');
    }

    @Override // y4.b
    public final void u0() {
        while (true) {
            char c11 = this.f78974d;
            if (c11 > '/') {
                return;
            }
            if (c11 == ' ' || c11 == '\r' || c11 == '\n' || c11 == '\t' || c11 == '\f' || c11 == '\b') {
                next();
            } else if (c11 != '/') {
                return;
            } else {
                p1();
            }
        }
    }

    @Override // y4.b
    public final String v() {
        return f.a(this.f78971a);
    }

    @Override // y4.b
    public final void v0() {
        this.f78978h = 0;
    }

    @Override // y4.b
    public final String w(i iVar) {
        if (this.f78971a == 1 && this.f78972b == 0 && this.f78975e == 1) {
            this.f78975e = 0;
        }
        boolean[] zArr = com.alibaba.fastjson.util.f.f18304d;
        int i11 = this.f78974d;
        if (i11 < zArr.length && !zArr[i11]) {
            throw new JSONException("illegal identifier : " + this.f78974d + k());
        }
        boolean[] zArr2 = com.alibaba.fastjson.util.f.f18305e;
        this.f78979i = this.f78975e;
        this.f78978h = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i11 = (i11 * 31) + next;
            this.f78978h++;
        }
        this.f78974d = G0(this.f78975e);
        this.f78971a = 18;
        if (this.f78978h == 4 && i11 == 3392903 && G0(this.f78979i) == 'n' && G0(this.f78979i + 1) == 'u' && G0(this.f78979i + 2) == 'l' && G0(this.f78979i + 3) == 'l') {
            return null;
        }
        return iVar == null ? r1(this.f78979i, this.f78978h) : b(this.f78979i, this.f78978h, i11, iVar);
    }

    @Override // y4.b
    public final boolean x() {
        return this.f78978h == 4 && G0(this.f78979i + 1) == '$' && G0(this.f78979i + 2) == 'r' && G0(this.f78979i + 3) == 'e' && G0(this.f78979i + 4) == 'f';
    }

    @Override // y4.b
    public final String y0(i iVar, char c11) {
        String c12;
        this.f78979i = this.f78975e;
        this.f78978h = 0;
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            char next = next();
            if (next == c11) {
                this.f78971a = 4;
                if (z10) {
                    c12 = iVar.c(this.f78977g, 0, this.f78978h, i11);
                } else {
                    int i12 = this.f78979i;
                    c12 = b(i12 == -1 ? 0 : i12 + 1, this.f78978h, i11, iVar);
                }
                this.f78978h = 0;
                next();
                return c12;
            }
            if (next == 26) {
                throw new JSONException("unclosed.str");
            }
            if (next == '\\') {
                if (!z10) {
                    int i13 = this.f78978h;
                    char[] cArr = this.f78977g;
                    if (i13 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i13 <= length) {
                            i13 = length;
                        }
                        char[] cArr2 = new char[i13];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f78977g = cArr2;
                    }
                    E0(this.f78979i + 1, this.f78977g, 0, this.f78978h);
                    z10 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i11 = (i11 * 31) + 34;
                    R0('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i11 = (i11 * 31) + 92;
                            R0('\\');
                        } else if (next2 == 'b') {
                            i11 = (i11 * 31) + 8;
                            R0('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i11 = (i11 * 31) + 10;
                                R0('\n');
                            } else if (next2 == 'r') {
                                i11 = (i11 * 31) + 13;
                                R0('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i11 = (i11 * 31) + 47;
                                        R0('/');
                                        break;
                                    case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                                        i11 = (i11 * 31) + next2;
                                        R0((char) 0);
                                        break;
                                    case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                                        i11 = (i11 * 31) + next2;
                                        R0((char) 1);
                                        break;
                                    case '2':
                                        i11 = (i11 * 31) + next2;
                                        R0((char) 2);
                                        break;
                                    case AD_REWARD_USER_VALUE:
                                        i11 = (i11 * 31) + next2;
                                        R0((char) 3);
                                        break;
                                    case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                                        i11 = (i11 * 31) + next2;
                                        R0((char) 4);
                                        break;
                                    case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                                        i11 = (i11 * 31) + next2;
                                        R0((char) 5);
                                        break;
                                    case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                                        i11 = (i11 * 31) + next2;
                                        R0((char) 6);
                                        break;
                                    case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                                        i11 = (i11 * 31) + next2;
                                        R0((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case GZIP_ENCODE_ERROR_VALUE:
                                                i11 = (i11 * 31) + 9;
                                                R0('\t');
                                                break;
                                            case ASSET_FAILED_STATUS_CODE_VALUE:
                                                int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i11 = (i11 * 31) + parseInt;
                                                R0((char) parseInt);
                                                break;
                                            case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                                                i11 = (i11 * 31) + 11;
                                                R0((char) 11);
                                                break;
                                            default:
                                                this.f78974d = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.f78974d = next3;
                                char next4 = next();
                                this.f78974d = next4;
                                int[] iArr = f78970s;
                                char c13 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i11 = (i11 * 31) + c13;
                                R0(c13);
                            }
                        }
                    }
                    i11 = (i11 * 31) + 12;
                    R0('\f');
                } else {
                    i11 = (i11 * 31) + 39;
                    R0('\'');
                }
            } else {
                i11 = (i11 * 31) + next;
                if (z10) {
                    int i14 = this.f78978h;
                    char[] cArr3 = this.f78977g;
                    if (i14 == cArr3.length) {
                        R0(next);
                    } else {
                        this.f78978h = i14 + 1;
                        cArr3[i14] = next;
                    }
                } else {
                    this.f78978h++;
                }
            }
        }
    }

    @Override // y4.b
    public final Number z0(boolean z10) {
        char G0 = G0((this.f78979i + this.f78978h) - 1);
        try {
            return G0 == 'F' ? Float.valueOf(Float.parseFloat(C0())) : G0 == 'D' ? Double.valueOf(Double.parseDouble(C0())) : z10 ? d0() : Double.valueOf(I0());
        } catch (NumberFormatException e11) {
            throw new JSONException(e11.getMessage() + ", " + k());
        }
    }
}
