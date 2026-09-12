package y4;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.cloud.tmc.miniutils.constant.TimeConstants;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public final class e extends c {

    /* renamed from: t, reason: collision with root package name */
    private final String f78987t;

    /* renamed from: u, reason: collision with root package name */
    private final int f78988u;

    public e(String str) {
        this(str, com.alibaba.fastjson.a.DEFAULT_PARSER_FEATURE);
    }

    public e(String str, int i11) {
        super(i11);
        this.f78987t = str;
        this.f78988u = str.length();
        this.f78975e = -1;
        next();
        if (this.f78974d == 65279) {
            next();
        }
    }

    public e(char[] cArr, int i11, int i12) {
        this(new String(cArr, 0, i11), i12);
    }

    static boolean t1(String str, int i11, char[] cArr) {
        int length = cArr.length;
        if (length + i11 > str.length()) {
            return false;
        }
        for (int i12 = 0; i12 < length; i12++) {
            if (cArr[i12] != str.charAt(i11 + i12)) {
                return false;
            }
        }
        return true;
    }

    static boolean u1(char c11, char c12, char c13, char c14, char c15, char c16, int i11, int i12) {
        if (c11 >= '0' && c11 <= '9' && c12 >= '0' && c12 <= '9' && c13 >= '0' && c13 <= '9' && c14 >= '0' && c14 <= '9') {
            if (c15 == '0') {
                if (c16 < '1' || c16 > '9') {
                    return false;
                }
            } else if (c15 != '1' || (c16 != '0' && c16 != '1' && c16 != '2')) {
                return false;
            }
            if (i11 == 48) {
                return i12 >= 49 && i12 <= 57;
            }
            if (i11 != 49 && i11 != 50) {
                return i11 == 51 && (i12 == 48 || i12 == 49);
            }
            if (i12 >= 48 && i12 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x001d, code lost:
    
        if (r6 <= '4') goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean v1(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
            r4 = this;
            r0 = 57
            r1 = 0
            r2 = 48
            if (r5 != r2) goto Lc
            if (r6 < r2) goto Lb
            if (r6 <= r0) goto L20
        Lb:
            return r1
        Lc:
            r3 = 49
            if (r5 != r3) goto L15
            if (r6 < r2) goto L14
            if (r6 <= r0) goto L20
        L14:
            return r1
        L15:
            r3 = 50
            if (r5 != r3) goto L42
            if (r6 < r2) goto L42
            r5 = 52
            if (r6 <= r5) goto L20
            goto L42
        L20:
            r5 = 54
            r6 = 53
            if (r7 < r2) goto L2d
            if (r7 > r6) goto L2d
            if (r8 < r2) goto L2c
            if (r8 <= r0) goto L32
        L2c:
            return r1
        L2d:
            if (r7 != r5) goto L42
            if (r8 == r2) goto L32
            return r1
        L32:
            if (r9 < r2) goto L3b
            if (r9 > r6) goto L3b
            if (r10 < r2) goto L3a
            if (r10 <= r0) goto L40
        L3a:
            return r1
        L3b:
            if (r9 != r5) goto L42
            if (r10 == r2) goto L40
            return r1
        L40:
            r5 = 1
            return r5
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.e.v1(char, char, char, char, char, char):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0217 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0219  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean y1(boolean r35, int r36) {
        /*
            Method dump skipped, instructions count: 1814
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.e.y1(boolean, int):boolean");
    }

    private void z1(char c11, char c12, char c13, char c14, char c15, char c16, char c17, char c18) {
        Calendar calendar = Calendar.getInstance(this.f78982l, this.f78983m);
        this.f78981k = calendar;
        calendar.set(1, ((c11 - '0') * 1000) + ((c12 - '0') * 100) + ((c13 - '0') * 10) + (c14 - '0'));
        this.f78981k.set(2, (((c15 - '0') * 10) + (c16 - '0')) - 1);
        this.f78981k.set(5, ((c17 - '0') * 10) + (c18 - '0'));
    }

    protected void A1(char c11, char c12, char c13, char c14, char c15, char c16) {
        this.f78981k.set(11, ((c11 - '0') * 10) + (c12 - '0'));
        this.f78981k.set(12, ((c13 - '0') * 10) + (c14 - '0'));
        this.f78981k.set(13, ((c15 - '0') * 10) + (c16 - '0'));
    }

    protected void B1(char c11, char c12, char c13) {
        C1(c11, c12, c13, '0', '0');
    }

    @Override // y4.c, y4.b
    public final String C0() {
        char G0 = G0((this.f78979i + this.f78978h) - 1);
        int i11 = this.f78978h;
        if (G0 == 'L' || G0 == 'S' || G0 == 'B' || G0 == 'F' || G0 == 'D') {
            i11--;
        }
        return r1(this.f78979i, i11);
    }

    protected void C1(char c11, char c12, char c13, char c14, char c15) {
        int i11 = ((((c12 - '0') * 10) + (c13 - '0')) * TimeConstants.HOUR) + ((((c14 - '0') * 10) + (c15 - '0')) * 60000);
        if (c11 == '-') {
            i11 = -i11;
        }
        if (this.f78981k.getTimeZone().getRawOffset() != i11) {
            this.f78981k.setTimeZone(new SimpleTimeZone(i11, Integer.toString(i11)));
        }
    }

    public final void D1(boolean z10) {
        int i11 = this.f78975e;
        boolean z11 = false;
        int i12 = 0;
        while (i11 < this.f78987t.length()) {
            char charAt = this.f78987t.charAt(i11);
            if (charAt == '\\') {
                if (i11 >= this.f78988u - 1) {
                    this.f78974d = charAt;
                    this.f78975e = i11;
                    throw new JSONException("illegal str, " + k());
                }
                i11++;
            } else if (charAt == '\"') {
                z11 = !z11;
            } else if (charAt != '[') {
                if (charAt == '{' && z10) {
                    int i13 = this.f78975e + 1;
                    this.f78975e = i13;
                    this.f78974d = i13 < this.f78987t.length() ? this.f78987t.charAt(i13) : (char) 26;
                    E1(z10);
                } else if (charAt == ']' && !z11 && i12 - 1 == -1) {
                    int i14 = i11 + 1;
                    this.f78975e = i14;
                    if (i14 == this.f78987t.length()) {
                        this.f78974d = (char) 26;
                        this.f78971a = 20;
                        return;
                    } else {
                        this.f78974d = this.f78987t.charAt(this.f78975e);
                        c0(16);
                        return;
                    }
                }
            } else if (!z11) {
                i12++;
            }
            i11++;
        }
        if (i11 != this.f78987t.length()) {
            return;
        }
        throw new JSONException("illegal str, " + k());
    }

    @Override // y4.c
    protected final void E0(int i11, char[] cArr, int i12, int i13) {
        this.f78987t.getChars(i11, i13 + i11, cArr, i12);
    }

    public final void E1(boolean z10) {
        int i11 = this.f78975e;
        boolean z11 = false;
        int i12 = 0;
        while (i11 < this.f78987t.length()) {
            char charAt = this.f78987t.charAt(i11);
            if (charAt == '\\') {
                if (i11 >= this.f78988u - 1) {
                    this.f78974d = charAt;
                    this.f78975e = i11;
                    throw new JSONException("illegal str, " + k());
                }
                i11++;
            } else if (charAt == '\"') {
                z11 = !z11;
            } else if (charAt == '{') {
                if (!z11) {
                    i12++;
                }
            } else if (charAt == '}' && !z11 && i12 - 1 == -1) {
                int i13 = i11 + 1;
                this.f78975e = i13;
                if (i13 == this.f78987t.length()) {
                    this.f78974d = (char) 26;
                    this.f78971a = 20;
                    return;
                }
                char charAt2 = this.f78987t.charAt(this.f78975e);
                this.f78974d = charAt2;
                if (charAt2 == ',') {
                    this.f78971a = 16;
                    int i14 = this.f78975e + 1;
                    this.f78975e = i14;
                    this.f78974d = i14 < this.f78987t.length() ? this.f78987t.charAt(i14) : (char) 26;
                    return;
                }
                if (charAt2 == '}') {
                    this.f78971a = 13;
                    next();
                    return;
                } else if (charAt2 != ']') {
                    c0(16);
                    return;
                } else {
                    this.f78971a = 15;
                    next();
                    return;
                }
            }
            i11++;
        }
        for (int i15 = 0; i15 < this.f78975e; i15++) {
            if (i15 < this.f78987t.length() && this.f78987t.charAt(i15) == ' ') {
                i11++;
            }
        }
        if (i11 != this.f78987t.length()) {
            return;
        }
        throw new JSONException("illegal str, " + k());
    }

    @Override // y4.c
    public final boolean F0(char[] cArr) {
        return t1(this.f78987t, this.f78975e, cArr);
    }

    @Override // y4.c
    public final char G0(int i11) {
        if (i11 >= this.f78988u) {
            return (char) 26;
        }
        return this.f78987t.charAt(i11);
    }

    @Override // y4.c
    protected final void H0(int i11, int i12, char[] cArr) {
        this.f78987t.getChars(i11, i12 + i11, cArr, 0);
    }

    @Override // y4.c
    public final int K0(char c11, int i11) {
        return this.f78987t.indexOf(c11, i11);
    }

    @Override // y4.c
    public boolean L0() {
        int i11 = this.f78975e;
        int i12 = this.f78988u;
        if (i11 != i12) {
            return this.f78974d == 26 && i11 + 1 >= i12;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0151, code lost:
    
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f3 A[SYNTHETIC] */
    @Override // y4.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean W0(char[] r12) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.e.W0(char[]):boolean");
    }

    @Override // y4.c
    public Date X0(char[] cArr) {
        long j11;
        Date date;
        char c11;
        char G0;
        boolean z10 = false;
        this.f78984n = 0;
        int i11 = this.f78975e;
        char c12 = this.f78974d;
        if (!t1(this.f78987t, i11, cArr)) {
            this.f78984n = -2;
            return null;
        }
        int length = this.f78975e + cArr.length;
        int i12 = length + 1;
        char G02 = G0(length);
        if (G02 == '\"') {
            int K0 = K0('\"', i12);
            if (K0 == -1) {
                throw new JSONException("unclosed str");
            }
            this.f78975e = i12;
            if (!y1(false, K0 - i12)) {
                this.f78975e = i11;
                this.f78984n = -1;
                return null;
            }
            date = this.f78981k.getTime();
            c11 = G0(K0 + 1);
            this.f78975e = i11;
            while (c11 != ',' && c11 != '}') {
                if (!c.M0(c11)) {
                    this.f78984n = -1;
                    return null;
                }
                int i13 = K0 + 1;
                char G03 = G0(K0 + 2);
                K0 = i13;
                c11 = G03;
            }
            this.f78975e = K0 + 1;
            this.f78974d = c11;
        } else {
            char c13 = '9';
            char c14 = '0';
            if (G02 != '-' && (G02 < '0' || G02 > '9')) {
                this.f78984n = -1;
                return null;
            }
            if (G02 == '-') {
                G02 = G0(i12);
                i12 = length + 2;
                z10 = true;
            }
            if (G02 < '0' || G02 > '9') {
                j11 = 0;
            } else {
                long j12 = G02 - '0';
                while (true) {
                    int i14 = i12 + 1;
                    G0 = G0(i12);
                    if (G0 < c14 || G0 > c13) {
                        break;
                    }
                    j12 = (j12 * 10) + (G0 - '0');
                    i12 = i14;
                    c13 = '9';
                    c14 = '0';
                }
                if (G0 == ',' || G0 == '}') {
                    this.f78975e = i12;
                }
                long j13 = j12;
                G02 = G0;
                j11 = j13;
            }
            if (j11 < 0) {
                this.f78984n = -1;
                return null;
            }
            if (z10) {
                j11 = -j11;
            }
            date = new Date(j11);
            c11 = G02;
        }
        if (c11 == ',') {
            int i15 = this.f78975e + 1;
            this.f78975e = i15;
            this.f78974d = G0(i15);
            this.f78984n = 3;
            this.f78971a = 16;
            return date;
        }
        int i16 = this.f78975e + 1;
        this.f78975e = i16;
        char G04 = G0(i16);
        if (G04 == ',') {
            this.f78971a = 16;
            int i17 = this.f78975e + 1;
            this.f78975e = i17;
            this.f78974d = G0(i17);
        } else if (G04 == ']') {
            this.f78971a = 15;
            int i18 = this.f78975e + 1;
            this.f78975e = i18;
            this.f78974d = G0(i18);
        } else if (G04 == '}') {
            this.f78971a = 13;
            int i19 = this.f78975e + 1;
            this.f78975e = i19;
            this.f78974d = G0(i19);
        } else {
            if (G04 != 26) {
                this.f78975e = i11;
                this.f78974d = c12;
                this.f78984n = -1;
                return null;
            }
            this.f78971a = 20;
        }
        this.f78984n = 4;
        return date;
    }

    @Override // y4.c
    public final String b(int i11, int i12, int i13, i iVar) {
        return iVar.a(this.f78987t, i11, i12, i13);
    }

    @Override // y4.c, y4.b
    public final BigDecimal d0() {
        char G0 = G0((this.f78979i + this.f78978h) - 1);
        int i11 = this.f78978h;
        if (G0 == 'L' || G0 == 'S' || G0 == 'B' || G0 == 'F' || G0 == 'D') {
            i11--;
        }
        if (i11 > 65535) {
            throw new JSONException("decimal overflow");
        }
        int i12 = this.f78979i;
        char[] cArr = this.f78977g;
        if (i11 < cArr.length) {
            this.f78987t.getChars(i12, i12 + i11, cArr, 0);
            return new BigDecimal(this.f78977g, 0, i11, MathContext.UNLIMITED);
        }
        char[] cArr2 = new char[i11];
        this.f78987t.getChars(i12, i12 + i11, cArr2, 0);
        return new BigDecimal(cArr2, 0, i11, MathContext.UNLIMITED);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
    
        if (r12 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        r14.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        if (r4 >= 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        r14.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
    
        if (r7 == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
    
        if (r12 == '\"') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
    
        r14.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0074, code lost:
    
        r15 = r15 + 2;
        r12 = G0(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007a, code lost:
    
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007f, code lost:
    
        if (r12 == ',') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0081, code lost:
    
        if (r12 != '}') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0088, code lost:
    
        if (y4.c.M0(r12) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008a, code lost:
    
        r15 = r11 + 1;
        r12 = G0(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007a, code lost:
    
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0091, code lost:
    
        r14.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0094, code lost:
    
        r14.f78975e = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009a, code lost:
    
        if (r12 != ',') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009c, code lost:
    
        r14.f78975e = r11;
        r14.f78974d = G0(r11);
        r14.f78984n = 3;
        r14.f78971a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a9, code lost:
    
        if (r3 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ac, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ad, code lost:
    
        if (r12 != '}') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00af, code lost:
    
        r14.f78975e = r11;
        r8 = G0(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b5, code lost:
    
        if (r8 != ',') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c7, code lost:
    
        if (r8 != ']') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d9, code lost:
    
        if (r8 != '}') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ed, code lost:
    
        if (r8 != 26) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00fb, code lost:
    
        if (y4.c.M0(r8) == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00fd, code lost:
    
        r8 = r14.f78975e + 1;
        r14.f78975e = r8;
        r8 = G0(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0107, code lost:
    
        r14.f78975e = r1;
        r14.f78974d = r2;
        r14.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x010d, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ef, code lost:
    
        r14.f78971a = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00f3, code lost:
    
        r14.f78984n = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00db, code lost:
    
        r14.f78971a = 13;
        r15 = r14.f78975e + 1;
        r14.f78975e = r15;
        r14.f78974d = G0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00c9, code lost:
    
        r14.f78971a = 15;
        r15 = r14.f78975e + 1;
        r14.f78975e = r15;
        r14.f78974d = G0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00b7, code lost:
    
        r14.f78971a = 16;
        r15 = r14.f78975e + 1;
        r14.f78975e = r15;
        r14.f78974d = G0(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x010e, code lost:
    
        if (r3 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0111, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
    
        return r4;
     */
    @Override // y4.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int d1(char[] r15) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.e.d1(char[]):int");
    }

    @Override // y4.c
    public long f1(char[] cArr) {
        int i11;
        char G0;
        boolean z10 = false;
        this.f78984n = 0;
        int i12 = this.f78975e;
        char c11 = this.f78974d;
        if (!t1(this.f78987t, i12, cArr)) {
            this.f78984n = -2;
            return 0L;
        }
        int length = this.f78975e + cArr.length;
        int i13 = length + 1;
        char G02 = G0(length);
        boolean z11 = G02 == '\"';
        if (z11) {
            G02 = G0(i13);
            i13 = length + 2;
        }
        if (G02 == '-') {
            G02 = G0(i13);
            i13++;
            z10 = true;
        }
        if (G02 < '0' || G02 > '9') {
            this.f78975e = i12;
            this.f78974d = c11;
            this.f78984n = -1;
            return 0L;
        }
        long j11 = G02 - '0';
        while (true) {
            i11 = i13 + 1;
            G0 = G0(i13);
            if (G0 < '0' || G0 > '9') {
                break;
            }
            j11 = (j11 * 10) + (G0 - '0');
            i13 = i11;
        }
        if (G0 == '.') {
            this.f78984n = -1;
            return 0L;
        }
        if (z11) {
            if (G0 != '\"') {
                this.f78984n = -1;
                return 0L;
            }
            G0 = G0(i11);
            i11 = i13 + 2;
        }
        if (G0 == ',' || G0 == '}') {
            this.f78975e = i11 - 1;
        }
        if (j11 < 0 && (j11 != Long.MIN_VALUE || !z10)) {
            this.f78975e = i12;
            this.f78974d = c11;
            this.f78984n = -1;
            return 0L;
        }
        while (G0 != ',') {
            if (G0 == '}') {
                int i14 = 1;
                int i15 = this.f78975e + 1;
                this.f78975e = i15;
                char G03 = G0(i15);
                while (true) {
                    if (G03 == ',') {
                        this.f78971a = 16;
                        int i16 = this.f78975e + i14;
                        this.f78975e = i16;
                        this.f78974d = G0(i16);
                        break;
                    }
                    if (G03 == ']') {
                        this.f78971a = 15;
                        int i17 = this.f78975e + i14;
                        this.f78975e = i17;
                        this.f78974d = G0(i17);
                        break;
                    }
                    if (G03 == '}') {
                        this.f78971a = 13;
                        int i18 = this.f78975e + i14;
                        this.f78975e = i18;
                        this.f78974d = G0(i18);
                        break;
                    }
                    if (G03 == 26) {
                        this.f78971a = 20;
                        break;
                    }
                    if (!c.M0(G03)) {
                        this.f78975e = i12;
                        this.f78974d = c11;
                        this.f78984n = -1;
                        return 0L;
                    }
                    int i19 = this.f78975e + 1;
                    this.f78975e = i19;
                    G03 = G0(i19);
                    i14 = 1;
                }
                this.f78984n = 4;
                return z10 ? -j11 : j11;
            }
            if (!c.M0(G0)) {
                this.f78984n = -1;
                return 0L;
            }
            this.f78975e = i11;
            G0 = G0(i11);
            i11++;
        }
        int i20 = this.f78975e + 1;
        this.f78975e = i20;
        this.f78974d = G0(i20);
        this.f78984n = 3;
        this.f78971a = 16;
        return z10 ? -j11 : j11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        if (r13 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        r16.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0083, code lost:
    
        if (r7 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:
    
        if (r13 == '\"') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
    
        r16.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
    
        r13 = G0(r12);
        r12 = r3 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        if (r4 >= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:
    
        r16.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0098, code lost:
    
        if (r13 != r17) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00af, code lost:
    
        if (y4.c.M0(r13) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b1, code lost:
    
        r13 = G0(r12);
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b9, code lost:
    
        r16.f78984n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bb, code lost:
    
        if (r6 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00be, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009a, code lost:
    
        r16.f78975e = r12;
        r16.f78974d = G0(r12);
        r16.f78984n = 3;
        r16.f78971a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a7, code lost:
    
        if (r6 == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00aa, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return r4;
     */
    @Override // y4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g0(char r17) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.e.g0(char):int");
    }

    @Override // y4.c
    public String g1(char[] cArr) {
        this.f78984n = 0;
        int i11 = this.f78975e;
        char c11 = this.f78974d;
        while (!t1(this.f78987t, this.f78975e, cArr)) {
            if (!c.M0(this.f78974d)) {
                this.f78984n = -2;
                return q1();
            }
            next();
            while (c.M0(this.f78974d)) {
                next();
            }
        }
        int length = this.f78975e + cArr.length;
        int i12 = length + 1;
        char G0 = G0(length);
        int i13 = 0;
        if (G0 != '\"') {
            while (c.M0(G0)) {
                i13++;
                int i14 = i12 + 1;
                char G02 = G0(i12);
                i12 = i14;
                G0 = G02;
            }
            if (G0 != '\"') {
                this.f78984n = -1;
                return q1();
            }
        }
        int K0 = K0('\"', i12);
        if (K0 == -1) {
            throw new JSONException("unclosed str");
        }
        String r12 = r1(i12, K0 - i12);
        if (r12.indexOf(92) != -1) {
            while (true) {
                int i15 = 0;
                for (int i16 = K0 - 1; i16 >= 0 && G0(i16) == '\\'; i16--) {
                    i15++;
                }
                if (i15 % 2 == 0) {
                    break;
                }
                K0 = K0('\"', K0 + 1);
            }
            int i17 = this.f78975e;
            int length2 = K0 - (((cArr.length + i17) + 1) + i13);
            r12 = c.S0(s1(i17 + cArr.length + 1 + i13, length2), length2);
        }
        if ((this.f78973c & Feature.TrimStringFieldValue.mask) != 0) {
            r12 = r12.trim();
        }
        char G03 = G0(K0 + 1);
        while (G03 != ',' && G03 != '}') {
            if (!c.M0(G03)) {
                this.f78984n = -1;
                return q1();
            }
            char G04 = G0(K0 + 2);
            K0++;
            G03 = G04;
        }
        this.f78975e = K0 + 1;
        this.f78974d = G03;
        if (G03 == ',') {
            int i18 = K0 + 2;
            this.f78975e = i18;
            this.f78974d = G0(i18);
            this.f78984n = 3;
            return r12;
        }
        int i19 = K0 + 2;
        this.f78975e = i19;
        char G05 = G0(i19);
        if (G05 == ',') {
            this.f78971a = 16;
            int i20 = this.f78975e + 1;
            this.f78975e = i20;
            this.f78974d = G0(i20);
        } else if (G05 == ']') {
            this.f78971a = 15;
            int i21 = this.f78975e + 1;
            this.f78975e = i21;
            this.f78974d = G0(i21);
        } else if (G05 == '}') {
            this.f78971a = 13;
            int i22 = this.f78975e + 1;
            this.f78975e = i22;
            this.f78974d = G0(i22);
        } else {
            if (G05 != 26) {
                this.f78975e = i11;
                this.f78974d = c11;
                this.f78984n = -1;
                return q1();
            }
            this.f78971a = 20;
        }
        this.f78984n = 4;
        return r12;
    }

    @Override // y4.b
    public byte[] h0() {
        if (this.f78971a != 26) {
            return !this.f78980j ? com.alibaba.fastjson.util.f.d(this.f78987t, this.f78979i + 1, this.f78978h) : com.alibaba.fastjson.util.f.c(new String(this.f78977g, 0, this.f78978h));
        }
        int i11 = this.f78979i + 1;
        int i12 = this.f78978h;
        if (i12 % 2 != 0) {
            throw new JSONException("illegal state. " + i12);
        }
        int i13 = i12 / 2;
        byte[] bArr = new byte[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = (i14 * 2) + i11;
            char charAt = this.f78987t.charAt(i15);
            char charAt2 = this.f78987t.charAt(i15 + 1);
            char c11 = '7';
            int i16 = charAt - (charAt <= '9' ? '0' : '7');
            if (charAt2 <= '9') {
                c11 = '0';
            }
            bArr[i14] = (byte) ((i16 << 4) | (charAt2 - c11));
        }
        return bArr;
    }

    @Override // y4.c, y4.b
    public String k() {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 1;
        int i12 = 1;
        int i13 = 0;
        while (i13 < this.f78975e) {
            if (this.f78987t.charAt(i13) == '\n') {
                i11++;
                i12 = 1;
            }
            i13++;
            i12++;
        }
        sb2.append("pos ");
        sb2.append(this.f78975e);
        sb2.append(", line ");
        sb2.append(i11);
        sb2.append(", column ");
        sb2.append(i12);
        if (this.f78987t.length() < 65535) {
            sb2.append(this.f78987t);
        } else {
            sb2.append(this.f78987t.substring(0, Settings.DEFAULT_INITIAL_WINDOW_SIZE));
        }
        return sb2.toString();
    }

    @Override // y4.c, y4.b
    public final String k0() {
        return !this.f78980j ? r1(this.f78979i + 1, this.f78978h) : new String(this.f78977g, 0, this.f78978h);
    }

    @Override // y4.b
    public String m0(i iVar) {
        int indexOf;
        if (!this.f78987t.startsWith("\"@type\":\"", this.f78975e) || (indexOf = this.f78987t.indexOf(34, this.f78975e + 9)) == -1) {
            return null;
        }
        int i11 = this.f78975e + 9;
        this.f78975e = i11;
        int i12 = 0;
        while (i11 < indexOf) {
            i12 = (i12 * 31) + this.f78987t.charAt(i11);
            i11++;
        }
        int i13 = this.f78975e;
        String b11 = b(i13, indexOf - i13, i12, iVar);
        char charAt = this.f78987t.charAt(indexOf + 1);
        if (charAt != ',' && charAt != ']') {
            return null;
        }
        int i14 = indexOf + 2;
        this.f78975e = i14;
        this.f78974d = this.f78987t.charAt(i14);
        return b11;
    }

    @Override // y4.c, y4.b
    public final char next() {
        int i11 = this.f78975e + 1;
        this.f78975e = i11;
        char charAt = i11 >= this.f78988u ? (char) 26 : this.f78987t.charAt(i11);
        this.f78974d = charAt;
        return charAt;
    }

    @Override // y4.c
    public final String r1(int i11, int i12) {
        if (!com.alibaba.fastjson.util.b.f18278b) {
            return this.f78987t.substring(i11, i12 + i11);
        }
        char[] cArr = this.f78977g;
        if (i12 < cArr.length) {
            this.f78987t.getChars(i11, i11 + i12, cArr, 0);
            return new String(this.f78977g, 0, i12);
        }
        char[] cArr2 = new char[i12];
        this.f78987t.getChars(i11, i12 + i11, cArr2, 0);
        return new String(cArr2);
    }

    @Override // y4.b
    public double s(char c11) {
        int i11;
        char G0;
        long j11;
        int i12;
        int i13;
        double parseDouble;
        char G02;
        this.f78984n = 0;
        int i14 = this.f78975e;
        int i15 = i14 + 1;
        char G03 = G0(i14);
        boolean z10 = G03 == '\"';
        if (z10) {
            G03 = G0(i15);
            i15 = i14 + 2;
        }
        boolean z11 = G03 == '-';
        if (z11) {
            G03 = G0(i15);
            i15++;
        }
        if (G03 >= '0') {
            char c12 = '9';
            if (G03 <= '9') {
                long j12 = G03 - '0';
                while (true) {
                    i11 = i15 + 1;
                    G0 = G0(i15);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    j12 = (j12 * 10) + (G0 - '0');
                    i15 = i11;
                }
                if (G0 == '.') {
                    int i16 = i15 + 2;
                    char G04 = G0(i11);
                    if (G04 < '0' || G04 > '9') {
                        this.f78984n = -1;
                        return 0.0d;
                    }
                    j12 = (j12 * 10) + (G04 - '0');
                    long j13 = 10;
                    while (true) {
                        i11 = i16 + 1;
                        G02 = G0(i16);
                        if (G02 < '0' || G02 > c12) {
                            break;
                        }
                        j12 = (j12 * 10) + (G02 - '0');
                        j13 *= 10;
                        i16 = i11;
                        c12 = '9';
                    }
                    long j14 = j13;
                    G0 = G02;
                    j11 = j14;
                } else {
                    j11 = 1;
                }
                boolean z12 = G0 == 'e' || G0 == 'E';
                if (z12) {
                    int i17 = i11 + 1;
                    char G05 = G0(i11);
                    if (G05 == '+' || G05 == '-') {
                        i11 += 2;
                        G0 = G0(i17);
                    } else {
                        i11 = i17;
                        G0 = G05;
                    }
                    while (G0 >= '0' && G0 <= '9') {
                        int i18 = i11 + 1;
                        char G06 = G0(i11);
                        i11 = i18;
                        G0 = G06;
                    }
                }
                if (!z10) {
                    i12 = this.f78975e;
                    i13 = (i11 - i12) - 1;
                } else {
                    if (G0 != '\"') {
                        this.f78984n = -1;
                        return 0.0d;
                    }
                    int i19 = i11 + 1;
                    char G07 = G0(i11);
                    i12 = this.f78975e + 1;
                    i13 = (i19 - i12) - 2;
                    i11 = i19;
                    G0 = G07;
                }
                if (z12 || i13 >= 18) {
                    parseDouble = Double.parseDouble(r1(i12, i13));
                } else {
                    parseDouble = j12 / j11;
                    if (z11) {
                        parseDouble = -parseDouble;
                    }
                }
                if (G0 != c11) {
                    this.f78984n = -1;
                    return parseDouble;
                }
                this.f78975e = i11;
                this.f78974d = G0(i11);
                this.f78984n = 3;
                this.f78971a = 16;
                return parseDouble;
            }
        }
        if (G03 == 'n') {
            int i20 = i15 + 1;
            if (G0(i15) == 'u') {
                int i21 = i15 + 2;
                if (G0(i20) == 'l') {
                    int i22 = i15 + 3;
                    if (G0(i21) == 'l') {
                        this.f78984n = 5;
                        int i23 = i15 + 4;
                        char G08 = G0(i22);
                        if (z10 && G08 == '\"') {
                            G08 = G0(i23);
                            i23 = i15 + 5;
                        }
                        while (G08 != ',') {
                            if (G08 == ']') {
                                this.f78975e = i23;
                                this.f78974d = G0(i23);
                                this.f78984n = 5;
                                this.f78971a = 15;
                                return 0.0d;
                            }
                            if (!c.M0(G08)) {
                                this.f78984n = -1;
                                return 0.0d;
                            }
                            char G09 = G0(i23);
                            i23++;
                            G08 = G09;
                        }
                        this.f78975e = i23;
                        this.f78974d = G0(i23);
                        this.f78984n = 5;
                        this.f78971a = 16;
                        return 0.0d;
                    }
                }
            }
        }
        this.f78984n = -1;
        return 0.0d;
    }

    @Override // y4.c
    public final char[] s1(int i11, int i12) {
        if (com.alibaba.fastjson.util.b.f18278b) {
            char[] cArr = this.f78977g;
            if (i12 < cArr.length) {
                this.f78987t.getChars(i11, i12 + i11, cArr, 0);
                return this.f78977g;
            }
        }
        char[] cArr2 = new char[i12];
        this.f78987t.getChars(i11, i12 + i11, cArr2, 0);
        return cArr2;
    }

    public boolean w1() {
        return x1(true);
    }

    @Override // y4.b
    public long x0(char c11) {
        int i11;
        char G0;
        this.f78984n = 0;
        int i12 = this.f78975e;
        int i13 = i12 + 1;
        char G02 = G0(i12);
        boolean z10 = G02 == '\"';
        if (z10) {
            G02 = G0(i13);
            i13 = i12 + 2;
        }
        boolean z11 = G02 == '-';
        if (z11) {
            G02 = G0(i13);
            i13++;
        }
        if (G02 >= '0' && G02 <= '9') {
            long j11 = G02 - '0';
            while (true) {
                i11 = i13 + 1;
                G0 = G0(i13);
                if (G0 < '0' || G0 > '9') {
                    break;
                }
                j11 = (j11 * 10) + (G0 - '0');
                i13 = i11;
            }
            if (G0 == '.') {
                this.f78984n = -1;
                return 0L;
            }
            if (z10) {
                if (G0 != '\"') {
                    this.f78984n = -1;
                    return 0L;
                }
                G0 = G0(i11);
                i11 = i13 + 2;
            }
            if (j11 < 0 && (j11 != Long.MIN_VALUE || !z11)) {
                this.f78984n = -1;
                return 0L;
            }
            while (G0 != c11) {
                if (!c.M0(G0)) {
                    this.f78984n = -1;
                    return j11;
                }
                G0 = G0(i11);
                i11++;
            }
            this.f78975e = i11;
            this.f78974d = G0(i11);
            this.f78984n = 3;
            this.f78971a = 16;
            return z11 ? -j11 : j11;
        }
        if (G02 == 'n') {
            int i14 = i13 + 1;
            if (G0(i13) == 'u') {
                int i15 = i13 + 2;
                if (G0(i14) == 'l') {
                    int i16 = i13 + 3;
                    if (G0(i15) == 'l') {
                        this.f78984n = 5;
                        int i17 = i13 + 4;
                        char G03 = G0(i16);
                        if (z10 && G03 == '\"') {
                            G03 = G0(i17);
                            i17 = i13 + 5;
                        }
                        while (G03 != ',') {
                            if (G03 == ']') {
                                this.f78975e = i17;
                                this.f78974d = G0(i17);
                                this.f78984n = 5;
                                this.f78971a = 15;
                                return 0L;
                            }
                            if (!c.M0(G03)) {
                                this.f78984n = -1;
                                return 0L;
                            }
                            char G04 = G0(i17);
                            i17++;
                            G03 = G04;
                        }
                        this.f78975e = i17;
                        this.f78974d = G0(i17);
                        this.f78984n = 5;
                        this.f78971a = 16;
                        return 0L;
                    }
                }
            }
        }
        this.f78984n = -1;
        return 0L;
    }

    public boolean x1(boolean z10) {
        return y1(z10, this.f78988u - this.f78975e);
    }
}
