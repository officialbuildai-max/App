package com.bykv.vk.openvk.preload.a.d;

import com.bykv.vk.openvk.preload.a.b.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class a implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    private final Reader f20565b;

    /* renamed from: i, reason: collision with root package name */
    private long f20572i;

    /* renamed from: j, reason: collision with root package name */
    private int f20573j;

    /* renamed from: k, reason: collision with root package name */
    private String f20574k;

    /* renamed from: l, reason: collision with root package name */
    private int[] f20575l;

    /* renamed from: n, reason: collision with root package name */
    private String[] f20577n;

    /* renamed from: o, reason: collision with root package name */
    private int[] f20578o;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20566c = false;

    /* renamed from: d, reason: collision with root package name */
    private final char[] f20567d = new char[1024];

    /* renamed from: e, reason: collision with root package name */
    private int f20568e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f20569f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f20570g = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f20571h = 0;

    /* renamed from: a, reason: collision with root package name */
    int f20564a = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f20576m = 1;

    static {
        e.f20521a = new e() { // from class: com.bykv.vk.openvk.preload.a.d.a.1
            @Override // com.bykv.vk.openvk.preload.a.b.e
            public final void a(a aVar) throws IOException {
                if (aVar instanceof com.bykv.vk.openvk.preload.a.b.a.e) {
                    throw null;
                }
                int i11 = aVar.f20564a;
                if (i11 == 0) {
                    i11 = aVar.q();
                }
                if (i11 == 13) {
                    aVar.f20564a = 9;
                    return;
                }
                if (i11 == 12) {
                    aVar.f20564a = 8;
                } else {
                    if (i11 == 14) {
                        aVar.f20564a = 10;
                        return;
                    }
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.r());
                }
            }
        };
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f20575l = iArr;
        iArr[0] = 6;
        this.f20577n = new String[32];
        this.f20578o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f20565b = reader;
    }

    private void a(int i11) {
        int i12 = this.f20576m;
        int[] iArr = this.f20575l;
        if (i12 == iArr.length) {
            int i13 = i12 << 1;
            this.f20575l = Arrays.copyOf(iArr, i13);
            this.f20578o = Arrays.copyOf(this.f20578o, i13);
            this.f20577n = (String[]) Arrays.copyOf(this.f20577n, i13);
        }
        int[] iArr2 = this.f20575l;
        int i14 = this.f20576m;
        this.f20576m = i14 + 1;
        iArr2[i14] = i11;
    }

    private boolean a(char c11) throws IOException {
        if (c11 == '\t' || c11 == '\n' || c11 == '\f' || c11 == '\r' || c11 == ' ') {
            return false;
        }
        if (c11 != '#') {
            if (c11 == ',') {
                return false;
            }
            if (c11 != '/' && c11 != '=') {
                if (c11 == '{' || c11 == '}' || c11 == ':') {
                    return false;
                }
                if (c11 != ';') {
                    switch (c11) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        v();
        return false;
    }

    private boolean a(String str) throws IOException {
        int i11;
        int length = str.length();
        while (true) {
            if (this.f20568e + length > this.f20569f && !b(length)) {
                return false;
            }
            char[] cArr = this.f20567d;
            int i12 = this.f20568e;
            if (cArr[i12] != '\n') {
                while (i11 < length) {
                    i11 = this.f20567d[this.f20568e + i11] == str.charAt(i11) ? i11 + 1 : 0;
                }
                return true;
            }
            this.f20570g++;
            this.f20571h = i12 + 1;
            this.f20568e++;
        }
    }

    private int b(boolean z10) throws IOException {
        char[] cArr = this.f20567d;
        int i11 = this.f20568e;
        int i12 = this.f20569f;
        while (true) {
            if (i11 == i12) {
                this.f20568e = i11;
                if (!b(1)) {
                    if (!z10) {
                        return -1;
                    }
                    throw new EOFException("End of input" + r());
                }
                i11 = this.f20568e;
                i12 = this.f20569f;
            }
            int i13 = i11 + 1;
            char c11 = cArr[i11];
            if (c11 == '\n') {
                this.f20570g++;
                this.f20571h = i13;
            } else if (c11 != ' ' && c11 != '\r' && c11 != '\t') {
                if (c11 == '/') {
                    this.f20568e = i13;
                    if (i13 == i12) {
                        this.f20568e = i11;
                        boolean b11 = b(2);
                        this.f20568e++;
                        if (!b11) {
                            return c11;
                        }
                    }
                    v();
                    int i14 = this.f20568e;
                    char c12 = cArr[i14];
                    if (c12 == '*') {
                        this.f20568e = i14 + 1;
                        if (!a("*/")) {
                            throw b("Unterminated comment");
                        }
                        i11 = this.f20568e + 2;
                        i12 = this.f20569f;
                    } else {
                        if (c12 != '/') {
                            return c11;
                        }
                        this.f20568e = i14 + 1;
                        w();
                        i11 = this.f20568e;
                        i12 = this.f20569f;
                    }
                } else {
                    if (c11 != '#') {
                        this.f20568e = i13;
                        return c11;
                    }
                    this.f20568e = i13;
                    v();
                    w();
                    i11 = this.f20568e;
                    i12 = this.f20569f;
                }
            }
            i11 = i13;
        }
    }

    private IOException b(String str) throws IOException {
        throw new d(str + r());
    }

    private String b(char c11) throws IOException {
        char[] cArr = this.f20567d;
        StringBuilder sb2 = null;
        while (true) {
            int i11 = this.f20568e;
            int i12 = this.f20569f;
            int i13 = i11;
            while (true) {
                if (i13 < i12) {
                    int i14 = i13 + 1;
                    char c12 = cArr[i13];
                    if (c12 == c11) {
                        this.f20568e = i14;
                        int i15 = (i14 - i11) - 1;
                        if (sb2 == null) {
                            return new String(cArr, i11, i15);
                        }
                        sb2.append(cArr, i11, i15);
                        return sb2.toString();
                    }
                    if (c12 == '\\') {
                        this.f20568e = i14;
                        int i16 = i14 - i11;
                        int i17 = i16 - 1;
                        if (sb2 == null) {
                            sb2 = new StringBuilder(Math.max(i16 << 1, 16));
                        }
                        sb2.append(cArr, i11, i17);
                        sb2.append(x());
                    } else {
                        if (c12 == '\n') {
                            this.f20570g++;
                            this.f20571h = i14;
                        }
                        i13 = i14;
                    }
                } else {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max((i13 - i11) << 1, 16));
                    }
                    sb2.append(cArr, i11, i13 - i11);
                    this.f20568e = i13;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean b(int i11) throws IOException {
        int i12;
        int i13;
        char[] cArr = this.f20567d;
        int i14 = this.f20571h;
        int i15 = this.f20568e;
        this.f20571h = i14 - i15;
        int i16 = this.f20569f;
        if (i16 != i15) {
            int i17 = i16 - i15;
            this.f20569f = i17;
            System.arraycopy(cArr, i15, cArr, 0, i17);
        } else {
            this.f20569f = 0;
        }
        this.f20568e = 0;
        do {
            Reader reader = this.f20565b;
            int i18 = this.f20569f;
            int read = reader.read(cArr, i18, cArr.length - i18);
            if (read == -1) {
                return false;
            }
            i12 = this.f20569f + read;
            this.f20569f = i12;
            if (this.f20570g == 0 && (i13 = this.f20571h) == 0 && i12 > 0 && cArr[0] == 65279) {
                this.f20568e++;
                this.f20571h = i13 + 1;
                i11++;
            }
        } while (i12 < i11);
        return true;
    }

    private void c(char c11) throws IOException {
        char[] cArr = this.f20567d;
        while (true) {
            int i11 = this.f20568e;
            int i12 = this.f20569f;
            while (true) {
                if (i11 < i12) {
                    int i13 = i11 + 1;
                    char c12 = cArr[i11];
                    if (c12 == c11) {
                        this.f20568e = i13;
                        return;
                    }
                    if (c12 == '\\') {
                        this.f20568e = i13;
                        x();
                        break;
                    } else {
                        if (c12 == '\n') {
                            this.f20570g++;
                            this.f20571h = i13;
                        }
                        i11 = i13;
                    }
                } else {
                    this.f20568e = i11;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    private int s() throws IOException {
        String str;
        String str2;
        int i11;
        char c11 = this.f20567d[this.f20568e];
        if (c11 == 't' || c11 == 'T') {
            str = "true";
            str2 = "TRUE";
            i11 = 5;
        } else if (c11 == 'f' || c11 == 'F') {
            str = "false";
            str2 = "FALSE";
            i11 = 6;
        } else {
            if (c11 != 'n' && c11 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i11 = 7;
        }
        int length = str.length();
        for (int i12 = 1; i12 < length; i12++) {
            if (this.f20568e + i12 >= this.f20569f && !b(i12 + 1)) {
                return 0;
            }
            char c12 = this.f20567d[this.f20568e + i12];
            if (c12 != str.charAt(i12) && c12 != str2.charAt(i12)) {
                return 0;
            }
        }
        if ((this.f20568e + length < this.f20569f || b(length + 1)) && a(this.f20567d[this.f20568e + length])) {
            return 0;
        }
        this.f20568e += length;
        this.f20564a = i11;
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0093, code lost:
    
        if (r9 != 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0095, code lost:
    
        if (r10 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009d, code lost:
    
        if (r13 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a3, code lost:
    
        if (r11 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a5, code lost:
    
        if (r13 != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a7, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ab, code lost:
    
        r18.f20572i = r11;
        r18.f20568e += r8;
        r18.f20564a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b7, code lost:
    
        if (r9 == 2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ba, code lost:
    
        if (r9 == 4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bd, code lost:
    
        if (r9 != 7) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
    
        r18.f20573j = r8;
        r18.f20564a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x008f, code lost:
    
        if (a(r14) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0091, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int t() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.d.a.t():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        v();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String u() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f20568e
            int r4 = r3 + r2
            int r5 = r6.f20569f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f20567d
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.v()
            goto L5c
        L4e:
            char[] r3 = r6.f20567d
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.b(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f20567d
            int r4 = r6.f20568e
            r0.append(r3, r4, r2)
            int r3 = r6.f20568e
            int r3 = r3 + r2
            r6.f20568e = r3
            r2 = 1
            boolean r2 = r6.b(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f20567d
            int r3 = r6.f20568e
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f20567d
            int r3 = r6.f20568e
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f20568e
            int r2 = r2 + r1
            r6.f20568e = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.d.a.u():java.lang.String");
    }

    private void v() throws IOException {
        if (!this.f20566c) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void w() throws IOException {
        char c11;
        do {
            if (this.f20568e >= this.f20569f && !b(1)) {
                return;
            }
            char[] cArr = this.f20567d;
            int i11 = this.f20568e;
            int i12 = i11 + 1;
            this.f20568e = i12;
            c11 = cArr[i11];
            if (c11 == '\n') {
                this.f20570g++;
                this.f20571h = i12;
                return;
            }
        } while (c11 != '\r');
    }

    private char x() throws IOException {
        int i11;
        if (this.f20568e == this.f20569f && !b(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.f20567d;
        int i12 = this.f20568e;
        int i13 = i12 + 1;
        this.f20568e = i13;
        char c11 = cArr[i12];
        if (c11 == '\n') {
            this.f20570g++;
            this.f20571h = i13;
        } else if (c11 != '\"' && c11 != '\'' && c11 != '/' && c11 != '\\') {
            if (c11 == 'b') {
                return '\b';
            }
            if (c11 == 'f') {
                return '\f';
            }
            if (c11 == 'n') {
                return '\n';
            }
            if (c11 == 'r') {
                return '\r';
            }
            if (c11 == 't') {
                return '\t';
            }
            if (c11 != 'u') {
                throw b("Invalid escape sequence");
            }
            if (i12 + 5 > this.f20569f && !b(4)) {
                throw b("Unterminated escape sequence");
            }
            int i14 = this.f20568e;
            int i15 = i14 + 4;
            char c12 = 0;
            while (i14 < i15) {
                char c13 = this.f20567d[i14];
                char c14 = (char) (c12 << 4);
                if (c13 >= '0' && c13 <= '9') {
                    i11 = c13 - '0';
                } else if (c13 >= 'a' && c13 <= 'f') {
                    i11 = c13 - 'W';
                } else {
                    if (c13 < 'A' || c13 > 'F') {
                        throw new NumberFormatException("\\u" + new String(this.f20567d, this.f20568e, 4));
                    }
                    i11 = c13 - '7';
                }
                c12 = (char) (c14 + i11);
                i14++;
            }
            this.f20568e += 4;
            return c12;
        }
        return c11;
    }

    private void y() throws IOException {
        b(true);
        int i11 = this.f20568e;
        int i12 = i11 - 1;
        this.f20568e = i12;
        if (i11 + 4 <= this.f20569f || b(5)) {
            char[] cArr = this.f20567d;
            if (cArr[i12] == ')' && cArr[i11] == ']' && cArr[i11 + 1] == '}' && cArr[i11 + 2] == '\'' && cArr[i11 + 3] == '\n') {
                this.f20568e += 5;
            }
        }
    }

    public void a() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 == 3) {
            a(1);
            this.f20578o[this.f20576m - 1] = 0;
            this.f20564a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + r());
        }
    }

    public final void a(boolean z10) {
        this.f20566c = z10;
    }

    public void b() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + f() + r());
        }
        int i12 = this.f20576m;
        this.f20576m = i12 - 1;
        int[] iArr = this.f20578o;
        int i13 = i12 - 2;
        iArr[i13] = iArr[i13] + 1;
        this.f20564a = 0;
    }

    public void c() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 == 1) {
            a(3);
            this.f20564a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + r());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f20564a = 0;
        this.f20575l[0] = 8;
        this.f20576m = 1;
        this.f20565b.close();
    }

    public void d() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + f() + r());
        }
        int i12 = this.f20576m;
        int i13 = i12 - 1;
        this.f20576m = i13;
        this.f20577n[i13] = null;
        int[] iArr = this.f20578o;
        int i14 = i12 - 2;
        iArr[i14] = iArr[i14] + 1;
        this.f20564a = 0;
    }

    public boolean e() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        return (i11 == 2 || i11 == 4) ? false : true;
    }

    public b f() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        switch (i11) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String g() throws IOException {
        String b11;
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 == 14) {
            b11 = u();
        } else if (i11 == 12) {
            b11 = b('\'');
        } else {
            if (i11 != 13) {
                throw new IllegalStateException("Expected a name but was " + f() + r());
            }
            b11 = b('\"');
        }
        this.f20564a = 0;
        this.f20577n[this.f20576m - 1] = b11;
        return b11;
    }

    public String h() throws IOException {
        String str;
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 == 10) {
            str = u();
        } else if (i11 == 8) {
            str = b('\'');
        } else if (i11 == 9) {
            str = b('\"');
        } else if (i11 == 11) {
            str = this.f20574k;
            this.f20574k = null;
        } else if (i11 == 15) {
            str = Long.toString(this.f20572i);
        } else {
            if (i11 != 16) {
                throw new IllegalStateException("Expected a string but was " + f() + r());
            }
            str = new String(this.f20567d, this.f20568e, this.f20573j);
            this.f20568e += this.f20573j;
        }
        this.f20564a = 0;
        int[] iArr = this.f20578o;
        int i12 = this.f20576m - 1;
        iArr[i12] = iArr[i12] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 == 5) {
            this.f20564a = 0;
            int[] iArr = this.f20578o;
            int i12 = this.f20576m - 1;
            iArr[i12] = iArr[i12] + 1;
            return true;
        }
        if (i11 != 6) {
            throw new IllegalStateException("Expected a boolean but was " + f() + r());
        }
        this.f20564a = 0;
        int[] iArr2 = this.f20578o;
        int i13 = this.f20576m - 1;
        iArr2[i13] = iArr2[i13] + 1;
        return false;
    }

    public void j() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 != 7) {
            throw new IllegalStateException("Expected null but was " + f() + r());
        }
        this.f20564a = 0;
        int[] iArr = this.f20578o;
        int i12 = this.f20576m - 1;
        iArr[i12] = iArr[i12] + 1;
    }

    public double k() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 == 15) {
            this.f20564a = 0;
            int[] iArr = this.f20578o;
            int i12 = this.f20576m - 1;
            iArr[i12] = iArr[i12] + 1;
            return this.f20572i;
        }
        if (i11 == 16) {
            this.f20574k = new String(this.f20567d, this.f20568e, this.f20573j);
            this.f20568e += this.f20573j;
        } else if (i11 == 8 || i11 == 9) {
            this.f20574k = b(i11 == 8 ? '\'' : '\"');
        } else if (i11 == 10) {
            this.f20574k = u();
        } else if (i11 != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + r());
        }
        this.f20564a = 11;
        double parseDouble = Double.parseDouble(this.f20574k);
        if (!this.f20566c && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new d("JSON forbids NaN and infinities: " + parseDouble + r());
        }
        this.f20574k = null;
        this.f20564a = 0;
        int[] iArr2 = this.f20578o;
        int i13 = this.f20576m - 1;
        iArr2[i13] = iArr2[i13] + 1;
        return parseDouble;
    }

    public long l() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 == 15) {
            this.f20564a = 0;
            int[] iArr = this.f20578o;
            int i12 = this.f20576m - 1;
            iArr[i12] = iArr[i12] + 1;
            return this.f20572i;
        }
        if (i11 == 16) {
            this.f20574k = new String(this.f20567d, this.f20568e, this.f20573j);
            this.f20568e += this.f20573j;
        } else {
            if (i11 != 8 && i11 != 9 && i11 != 10) {
                throw new IllegalStateException("Expected a long but was " + f() + r());
            }
            if (i11 == 10) {
                this.f20574k = u();
            } else {
                this.f20574k = b(i11 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.f20574k);
                this.f20564a = 0;
                int[] iArr2 = this.f20578o;
                int i13 = this.f20576m - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f20564a = 11;
        double parseDouble = Double.parseDouble(this.f20574k);
        long j11 = (long) parseDouble;
        if (j11 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f20574k + r());
        }
        this.f20574k = null;
        this.f20564a = 0;
        int[] iArr3 = this.f20578o;
        int i14 = this.f20576m - 1;
        iArr3[i14] = iArr3[i14] + 1;
        return j11;
    }

    public int m() throws IOException {
        int i11 = this.f20564a;
        if (i11 == 0) {
            i11 = q();
        }
        if (i11 == 15) {
            long j11 = this.f20572i;
            int i12 = (int) j11;
            if (j11 != i12) {
                throw new NumberFormatException("Expected an int but was " + this.f20572i + r());
            }
            this.f20564a = 0;
            int[] iArr = this.f20578o;
            int i13 = this.f20576m - 1;
            iArr[i13] = iArr[i13] + 1;
            return i12;
        }
        if (i11 == 16) {
            this.f20574k = new String(this.f20567d, this.f20568e, this.f20573j);
            this.f20568e += this.f20573j;
        } else {
            if (i11 != 8 && i11 != 9 && i11 != 10) {
                throw new IllegalStateException("Expected an int but was " + f() + r());
            }
            if (i11 == 10) {
                this.f20574k = u();
            } else {
                this.f20574k = b(i11 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.f20574k);
                this.f20564a = 0;
                int[] iArr2 = this.f20578o;
                int i14 = this.f20576m - 1;
                iArr2[i14] = iArr2[i14] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f20564a = 11;
        double parseDouble = Double.parseDouble(this.f20574k);
        int i15 = (int) parseDouble;
        if (i15 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.f20574k + r());
        }
        this.f20574k = null;
        this.f20564a = 0;
        int[] iArr3 = this.f20578o;
        int i16 = this.f20576m - 1;
        iArr3[i16] = iArr3[i16] + 1;
        return i15;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:65:0x009d. Please report as an issue. */
    public void n() throws IOException {
        int i11 = 0;
        do {
            int i12 = this.f20564a;
            if (i12 == 0) {
                i12 = q();
            }
            if (i12 == 3) {
                a(1);
            } else if (i12 == 1) {
                a(3);
            } else {
                if (i12 == 4) {
                    this.f20576m--;
                } else if (i12 == 2) {
                    this.f20576m--;
                } else {
                    if (i12 == 14 || i12 == 10) {
                        do {
                            int i13 = 0;
                            while (true) {
                                int i14 = this.f20568e;
                                if (i14 + i13 < this.f20569f) {
                                    char c11 = this.f20567d[i14 + i13];
                                    if (c11 != '\t' && c11 != '\n' && c11 != '\f' && c11 != '\r' && c11 != ' ') {
                                        if (c11 != '#') {
                                            if (c11 != ',') {
                                                if (c11 != '/' && c11 != '=') {
                                                    if (c11 != '{' && c11 != '}' && c11 != ':') {
                                                        if (c11 != ';') {
                                                            switch (c11) {
                                                                case '[':
                                                                case ']':
                                                                    break;
                                                                case '\\':
                                                                    break;
                                                                default:
                                                                    i13++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    this.f20568e = i14 + i13;
                                }
                            }
                            v();
                            this.f20568e += i13;
                        } while (b(1));
                    } else if (i12 == 8 || i12 == 12) {
                        c('\'');
                    } else if (i12 == 9 || i12 == 13) {
                        c('\"');
                    } else if (i12 == 16) {
                        this.f20568e += this.f20573j;
                    }
                    this.f20564a = 0;
                }
                i11--;
                this.f20564a = 0;
            }
            i11++;
            this.f20564a = 0;
        } while (i11 != 0);
        int[] iArr = this.f20578o;
        int i15 = this.f20576m;
        int i16 = i15 - 1;
        iArr[i16] = iArr[i16] + 1;
        this.f20577n[i15 - 1] = "null";
    }

    public String o() {
        StringBuilder sb2 = new StringBuilder("$");
        int i11 = this.f20576m;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f20575l[i12];
            if (i13 == 1 || i13 == 2) {
                sb2.append('[');
                sb2.append(this.f20578o[i12]);
                sb2.append(']');
            } else if (i13 == 3 || i13 == 4 || i13 == 5) {
                sb2.append('.');
                String str = this.f20577n[i12];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }

    public final boolean p() {
        return this.f20566c;
    }

    final int q() throws IOException {
        int b11;
        int[] iArr = this.f20575l;
        int i11 = this.f20576m;
        int i12 = iArr[i11 - 1];
        if (i12 == 1) {
            iArr[i11 - 1] = 2;
        } else if (i12 == 2) {
            int b12 = b(true);
            if (b12 != 44) {
                if (b12 != 59) {
                    if (b12 != 93) {
                        throw b("Unterminated array");
                    }
                    this.f20564a = 4;
                    return 4;
                }
                v();
            }
        } else {
            if (i12 == 3 || i12 == 5) {
                iArr[i11 - 1] = 4;
                if (i12 == 5 && (b11 = b(true)) != 44) {
                    if (b11 != 59) {
                        if (b11 != 125) {
                            throw b("Unterminated object");
                        }
                        this.f20564a = 2;
                        return 2;
                    }
                    v();
                }
                int b13 = b(true);
                if (b13 == 34) {
                    this.f20564a = 13;
                    return 13;
                }
                if (b13 == 39) {
                    v();
                    this.f20564a = 12;
                    return 12;
                }
                if (b13 == 125) {
                    if (i12 == 5) {
                        throw b("Expected name");
                    }
                    this.f20564a = 2;
                    return 2;
                }
                v();
                this.f20568e--;
                if (!a((char) b13)) {
                    throw b("Expected name");
                }
                this.f20564a = 14;
                return 14;
            }
            if (i12 == 4) {
                iArr[i11 - 1] = 5;
                int b14 = b(true);
                if (b14 != 58) {
                    if (b14 != 61) {
                        throw b("Expected ':'");
                    }
                    v();
                    if (this.f20568e < this.f20569f || b(1)) {
                        char[] cArr = this.f20567d;
                        int i13 = this.f20568e;
                        if (cArr[i13] == '>') {
                            this.f20568e = i13 + 1;
                        }
                    }
                }
            } else if (i12 == 6) {
                if (this.f20566c) {
                    y();
                }
                this.f20575l[this.f20576m - 1] = 7;
            } else if (i12 == 7) {
                if (b(false) == -1) {
                    this.f20564a = 17;
                    return 17;
                }
                v();
                this.f20568e--;
            } else if (i12 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int b15 = b(true);
        if (b15 == 34) {
            this.f20564a = 9;
            return 9;
        }
        if (b15 == 39) {
            v();
            this.f20564a = 8;
            return 8;
        }
        if (b15 != 44 && b15 != 59) {
            if (b15 == 91) {
                this.f20564a = 3;
                return 3;
            }
            if (b15 != 93) {
                if (b15 == 123) {
                    this.f20564a = 1;
                    return 1;
                }
                this.f20568e--;
                int s11 = s();
                if (s11 != 0) {
                    return s11;
                }
                int t11 = t();
                if (t11 != 0) {
                    return t11;
                }
                if (!a(this.f20567d[this.f20568e])) {
                    throw b("Expected value");
                }
                v();
                this.f20564a = 10;
                return 10;
            }
            if (i12 == 1) {
                this.f20564a = 4;
                return 4;
            }
        }
        if (i12 != 1 && i12 != 2) {
            throw b("Unexpected value");
        }
        v();
        this.f20568e--;
        this.f20564a = 7;
        return 7;
    }

    final String r() {
        return " at line " + (this.f20570g + 1) + " column " + ((this.f20568e - this.f20571h) + 1) + " path " + o();
    }

    public String toString() {
        return getClass().getSimpleName() + r();
    }
}
