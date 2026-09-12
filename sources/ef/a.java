package ef;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes5.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f61976a;

    /* renamed from: b, reason: collision with root package name */
    private final int f61977b;

    /* renamed from: c, reason: collision with root package name */
    private int f61978c;

    /* renamed from: d, reason: collision with root package name */
    private int f61979d;

    /* renamed from: e, reason: collision with root package name */
    private int f61980e;

    /* renamed from: f, reason: collision with root package name */
    private int f61981f;

    /* renamed from: g, reason: collision with root package name */
    private char[] f61982g;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f61976a = name;
        this.f61977b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        return new java.lang.String(r1, r2, r8.f61981f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f61978c
            r8.f61979d = r0
            r8.f61980e = r0
        L6:
            int r0 = r8.f61978c
            int r1 = r8.f61977b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f61982g
            int r2 = r8.f61979d
            int r3 = r8.f61980e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f61982g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.f61980e
            int r4 = r3 + 1
            r8.f61980e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.f61978c = r0
            goto L6
        L3e:
            int r0 = r8.f61980e
            int r2 = r0 + 1
            r8.f61980e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f61978c
            int r0 = r0 + 1
            r8.f61978c = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f61979d
            int r3 = r8.f61980e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.f61980e
            r8.f61981f = r2
            int r0 = r0 + 1
            r8.f61978c = r0
            int r0 = r2 + 1
            r8.f61980e = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.f61978c
            int r1 = r8.f61977b
            if (r0 >= r1) goto L83
            char[] r2 = r8.f61982g
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.f61980e
            int r7 = r1 + 1
            r8.f61980e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f61978c = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.f61982g
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f61982g
            int r2 = r8.f61979d
            int r3 = r8.f61981f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ef.a.a():java.lang.String");
    }

    private int c(int i11) {
        int i12;
        int i13;
        int i14 = i11 + 1;
        if (i14 >= this.f61977b) {
            throw new IllegalStateException("Malformed DN: " + this.f61976a);
        }
        char[] cArr = this.f61982g;
        char c11 = cArr[i11];
        if (c11 >= '0' && c11 <= '9') {
            i12 = c11 - '0';
        } else if (c11 >= 'a' && c11 <= 'f') {
            i12 = c11 - 'W';
        } else {
            if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f61976a);
            }
            i12 = c11 - '7';
        }
        char c12 = cArr[i14];
        if (c12 >= '0' && c12 <= '9') {
            i13 = c12 - '0';
        } else if (c12 >= 'a' && c12 <= 'f') {
            i13 = c12 - 'W';
        } else {
            if (c12 < 'A' || c12 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f61976a);
            }
            i13 = c12 - '7';
        }
        return (i12 << 4) + i13;
    }

    private char d() {
        int i11 = this.f61978c + 1;
        this.f61978c = i11;
        if (i11 == this.f61977b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f61976a);
        }
        char c11 = this.f61982g[i11];
        if (c11 == ' ' || c11 == '%' || c11 == '\\' || c11 == '_' || c11 == '\"' || c11 == '#') {
            return c11;
        }
        switch (c11) {
            case '*':
            case '+':
            case ',':
                return c11;
            default:
                switch (c11) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c11;
                    default:
                        return e();
                }
        }
    }

    private char e() {
        int i11;
        int i12;
        int c11 = c(this.f61978c);
        this.f61978c++;
        if (c11 < 128) {
            return (char) c11;
        }
        if (c11 < 192 || c11 > 247) {
            return '?';
        }
        if (c11 <= 223) {
            i11 = c11 & 31;
            i12 = 1;
        } else if (c11 <= 239) {
            i11 = c11 & 15;
            i12 = 2;
        } else {
            i11 = c11 & 7;
            i12 = 3;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = this.f61978c;
            int i15 = i14 + 1;
            this.f61978c = i15;
            if (i15 == this.f61977b || this.f61982g[i15] != '\\') {
                return '?';
            }
            int i16 = i14 + 2;
            this.f61978c = i16;
            int c12 = c(i16);
            this.f61978c++;
            if ((c12 & PsExtractor.AUDIO_STREAM) != 128) {
                return '?';
            }
            i11 = (i11 << 6) + (c12 & 63);
        }
        return (char) i11;
    }

    private String f() {
        int i11;
        char[] cArr;
        char c11;
        int i12 = this.f61978c;
        if (i12 + 4 >= this.f61977b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f61976a);
        }
        this.f61979d = i12;
        this.f61978c = i12 + 1;
        while (true) {
            i11 = this.f61978c;
            if (i11 == this.f61977b || (c11 = (cArr = this.f61982g)[i11]) == '+' || c11 == ',' || c11 == ';') {
                break;
            }
            if (c11 == ' ') {
                this.f61980e = i11;
                this.f61978c = i11 + 1;
                while (true) {
                    int i13 = this.f61978c;
                    if (i13 >= this.f61977b || this.f61982g[i13] != ' ') {
                        break;
                    }
                    this.f61978c = i13 + 1;
                }
            } else {
                if (c11 >= 'A' && c11 <= 'F') {
                    cArr[i11] = (char) (c11 + ' ');
                }
                this.f61978c = i11 + 1;
            }
        }
        this.f61980e = i11;
        int i14 = this.f61980e;
        int i15 = this.f61979d;
        int i16 = i14 - i15;
        if (i16 < 5 || (i16 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f61976a);
        }
        int i17 = i16 / 2;
        byte[] bArr = new byte[i17];
        int i18 = i15 + 1;
        for (int i19 = 0; i19 < i17; i19++) {
            bArr[i19] = (byte) c(i18);
            i18 += 2;
        }
        return new String(this.f61982g, this.f61979d, i16);
    }

    private String g() {
        int i11;
        int i12;
        int i13;
        int i14;
        char c11;
        int i15;
        int i16;
        char c12;
        char c13;
        while (true) {
            i11 = this.f61978c;
            i12 = this.f61977b;
            if (i11 >= i12 || this.f61982g[i11] != ' ') {
                break;
            }
            this.f61978c = i11 + 1;
        }
        if (i11 == i12) {
            return null;
        }
        this.f61979d = i11;
        this.f61978c = i11 + 1;
        while (true) {
            i13 = this.f61978c;
            i14 = this.f61977b;
            if (i13 >= i14 || (c13 = this.f61982g[i13]) == '=' || c13 == ' ') {
                break;
            }
            this.f61978c = i13 + 1;
        }
        if (i13 >= i14) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f61976a);
        }
        this.f61980e = i13;
        if (this.f61982g[i13] == ' ') {
            while (true) {
                i15 = this.f61978c;
                i16 = this.f61977b;
                if (i15 >= i16 || (c12 = this.f61982g[i15]) == '=' || c12 != ' ') {
                    break;
                }
                this.f61978c = i15 + 1;
            }
            if (this.f61982g[i15] != '=' || i15 == i16) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f61976a);
            }
        }
        this.f61978c++;
        while (true) {
            int i17 = this.f61978c;
            if (i17 >= this.f61977b || this.f61982g[i17] != ' ') {
                break;
            }
            this.f61978c = i17 + 1;
        }
        int i18 = this.f61980e;
        int i19 = this.f61979d;
        if (i18 - i19 > 4) {
            char[] cArr = this.f61982g;
            if (cArr[i19 + 3] == '.' && (((c11 = cArr[i19]) == 'O' || c11 == 'o') && ((cArr[i19 + 1] == 'I' || cArr[i19 + 1] == 'i') && (cArr[i19 + 2] == 'D' || cArr[i19 + 2] == 'd')))) {
                this.f61979d = i19 + 4;
            }
        }
        char[] cArr2 = this.f61982g;
        int i20 = this.f61979d;
        return new String(cArr2, i20, i18 - i20);
    }

    private String h() {
        int i11 = this.f61978c + 1;
        this.f61978c = i11;
        this.f61979d = i11;
        this.f61980e = i11;
        while (true) {
            int i12 = this.f61978c;
            if (i12 == this.f61977b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f61976a);
            }
            char[] cArr = this.f61982g;
            char c11 = cArr[i12];
            if (c11 == '\"') {
                this.f61978c = i12 + 1;
                while (true) {
                    int i13 = this.f61978c;
                    if (i13 >= this.f61977b || this.f61982g[i13] != ' ') {
                        break;
                    }
                    this.f61978c = i13 + 1;
                }
                char[] cArr2 = this.f61982g;
                int i14 = this.f61979d;
                return new String(cArr2, i14, this.f61980e - i14);
            }
            if (c11 == '\\') {
                cArr[this.f61980e] = d();
            } else {
                cArr[this.f61980e] = c11;
            }
            this.f61978c++;
            this.f61980e++;
        }
    }

    public String b(String str) {
        this.f61978c = 0;
        this.f61979d = 0;
        this.f61980e = 0;
        this.f61981f = 0;
        this.f61982g = this.f61976a.toCharArray();
        String g11 = g();
        if (g11 == null) {
            return null;
        }
        do {
            int i11 = this.f61978c;
            if (i11 == this.f61977b) {
                return null;
            }
            char c11 = this.f61982g[i11];
            String a11 = c11 != '\"' ? c11 != '#' ? (c11 == '+' || c11 == ',' || c11 == ';') ? "" : a() : f() : h();
            if (str.equalsIgnoreCase(g11)) {
                return a11;
            }
            int i12 = this.f61978c;
            if (i12 >= this.f61977b) {
                return null;
            }
            char c12 = this.f61982g[i12];
            if (c12 != ',' && c12 != ';' && c12 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f61976a);
            }
            this.f61978c = i12 + 1;
            g11 = g();
        } while (g11 != null);
        throw new IllegalStateException("Malformed DN: " + this.f61976a);
    }
}
