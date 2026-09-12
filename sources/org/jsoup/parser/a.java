package org.jsoup.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;
import org.jsoup.UncheckedIOException;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final char[] f71928a;

    /* renamed from: b, reason: collision with root package name */
    private final Reader f71929b;

    /* renamed from: c, reason: collision with root package name */
    private int f71930c;

    /* renamed from: d, reason: collision with root package name */
    private int f71931d;

    /* renamed from: e, reason: collision with root package name */
    private int f71932e;

    /* renamed from: f, reason: collision with root package name */
    private int f71933f;

    /* renamed from: g, reason: collision with root package name */
    private int f71934g;

    /* renamed from: h, reason: collision with root package name */
    private final String[] f71935h;

    public a(Reader reader) {
        this(reader, 32768);
    }

    public a(Reader reader, int i11) {
        this.f71935h = new String[512];
        org.jsoup.helper.d.j(reader);
        org.jsoup.helper.d.d(reader.markSupported());
        this.f71929b = reader;
        this.f71928a = new char[i11 > 32768 ? 32768 : i11];
        b();
    }

    public a(String str) {
        this(new StringReader(str), str.length());
    }

    static boolean G(char[] cArr, int i11, int i12, String str) {
        if (i12 != str.length()) {
            return false;
        }
        int i13 = 0;
        while (true) {
            int i14 = i12 - 1;
            if (i12 == 0) {
                return true;
            }
            int i15 = i11 + 1;
            int i16 = i13 + 1;
            if (cArr[i11] != str.charAt(i13)) {
                return false;
            }
            i11 = i15;
            i12 = i14;
            i13 = i16;
        }
    }

    private void b() {
        int i11 = this.f71932e;
        if (i11 < this.f71931d) {
            return;
        }
        try {
            this.f71929b.skip(i11);
            this.f71929b.mark(32768);
            int read = this.f71929b.read(this.f71928a);
            this.f71929b.reset();
            if (read != -1) {
                this.f71930c = read;
                this.f71933f += this.f71932e;
                this.f71932e = 0;
                this.f71934g = 0;
                if (read > 24576) {
                    read = 24576;
                }
                this.f71931d = read;
            }
        } catch (IOException e11) {
            throw new UncheckedIOException(e11);
        }
    }

    private static String c(char[] cArr, String[] strArr, int i11, int i12) {
        if (i12 > 12) {
            return new String(cArr, i11, i12);
        }
        if (i12 < 1) {
            return "";
        }
        int i13 = 0;
        int i14 = i11;
        int i15 = 0;
        while (i13 < i12) {
            i15 = (i15 * 31) + cArr[i14];
            i13++;
            i14++;
        }
        int length = i15 & (strArr.length - 1);
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i11, i12);
            strArr[length] = str2;
            return str2;
        }
        if (G(cArr, i11, i12, str)) {
            return str;
        }
        String str3 = new String(cArr, i11, i12);
        strArr[length] = str3;
        return str3;
    }

    private boolean s() {
        return this.f71932e >= this.f71930c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        char c11;
        return !r() && (c11 = this.f71928a[this.f71932e]) >= '0' && c11 <= '9';
    }

    boolean B(String str) {
        b();
        int length = str.length();
        if (length > this.f71930c - this.f71932e) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (Character.toUpperCase(str.charAt(i11)) != Character.toUpperCase(this.f71928a[this.f71932e + i11])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        if (r()) {
            return false;
        }
        char c11 = this.f71928a[this.f71932e];
        return (c11 >= 'A' && c11 <= 'Z') || (c11 >= 'a' && c11 <= 'z') || Character.isLetter(c11);
    }

    int D(char c11) {
        b();
        for (int i11 = this.f71932e; i11 < this.f71930c; i11++) {
            if (c11 == this.f71928a[i11]) {
                return i11 - this.f71932e;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        r2 = r1 + 1;
        r4 = (r9.length() + r2) - 1;
        r5 = r8.f71930c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 >= r5) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r4 > r5) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r5 >= r4) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (r9.charAt(r3) != r8.f71928a[r5]) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r5 = r5 + 1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r5 != r4) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        return r1 - r8.f71932e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        if (r0 != r8.f71928a[r1]) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r1 >= r8.f71930c) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (r0 == r8.f71928a[r1]) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int E(java.lang.CharSequence r9) {
        /*
            r8 = this;
            r8.b()
            r0 = 0
            char r0 = r9.charAt(r0)
            int r1 = r8.f71932e
        La:
            int r2 = r8.f71930c
            if (r1 >= r2) goto L49
            char[] r2 = r8.f71928a
            char r2 = r2[r1]
            r3 = 1
            if (r0 == r2) goto L21
        L15:
            int r1 = r1 + r3
            int r2 = r8.f71930c
            if (r1 >= r2) goto L21
            char[] r2 = r8.f71928a
            char r2 = r2[r1]
            if (r0 == r2) goto L21
            goto L15
        L21:
            int r2 = r1 + 1
            int r4 = r9.length()
            int r4 = r4 + r2
            int r4 = r4 - r3
            int r5 = r8.f71930c
            if (r1 >= r5) goto L47
            if (r4 > r5) goto L47
            r5 = r2
        L30:
            if (r5 >= r4) goto L41
            char r6 = r9.charAt(r3)
            char[] r7 = r8.f71928a
            char r7 = r7[r5]
            if (r6 != r7) goto L41
            int r5 = r5 + 1
            int r3 = r3 + 1
            goto L30
        L41:
            if (r5 != r4) goto L47
            int r9 = r8.f71932e
            int r1 = r1 - r9
            return r1
        L47:
            r1 = r2
            goto La
        L49:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.a.E(java.lang.CharSequence):int");
    }

    public int F() {
        return this.f71933f + this.f71932e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        this.f71932e = this.f71934g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        this.f71932e--;
    }

    public void a() {
        this.f71932e++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char d() {
        b();
        char c11 = s() ? (char) 65535 : this.f71928a[this.f71932e];
        this.f71932e++;
        return c11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return c(r6.f71928a, r6.f71935h, r0, r3 - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String e() {
        /*
            r6 = this;
            r6.b()
            int r0 = r6.f71932e
            int r1 = r6.f71930c
            char[] r2 = r6.f71928a
        L9:
            int r3 = r6.f71932e
            if (r3 >= r1) goto L1f
            char r4 = r2[r3]
            r5 = 38
            if (r4 == r5) goto L1f
            r5 = 60
            if (r4 == r5) goto L1f
            if (r4 != 0) goto L1a
            goto L1f
        L1a:
            int r3 = r3 + 1
            r6.f71932e = r3
            goto L9
        L1f:
            if (r3 <= r0) goto L2b
            char[] r1 = r6.f71928a
            java.lang.String[] r2 = r6.f71935h
            int r3 = r3 - r0
            java.lang.String r0 = c(r1, r2, r0, r3)
            goto L2d
        L2b:
            java.lang.String r0 = ""
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.a.e():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        int i11;
        char c11;
        b();
        int i12 = this.f71932e;
        while (true) {
            i11 = this.f71932e;
            if (i11 >= this.f71930c || (c11 = this.f71928a[i11]) < '0' || c11 > '9') {
                break;
            }
            this.f71932e = i11 + 1;
        }
        return c(this.f71928a, this.f71935h, i12, i11 - i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        int i11;
        char c11;
        b();
        int i12 = this.f71932e;
        while (true) {
            i11 = this.f71932e;
            if (i11 >= this.f71930c || (((c11 = this.f71928a[i11]) < '0' || c11 > '9') && ((c11 < 'A' || c11 > 'F') && (c11 < 'a' || c11 > 'f')))) {
                break;
            }
            this.f71932e = i11 + 1;
        }
        return c(this.f71928a, this.f71935h, i12, i11 - i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        char c11;
        b();
        int i11 = this.f71932e;
        while (true) {
            int i12 = this.f71932e;
            if (i12 >= this.f71930c || (((c11 = this.f71928a[i12]) < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !Character.isLetter(c11)))) {
                break;
            }
            this.f71932e++;
        }
        return c(this.f71928a, this.f71935h, i11, this.f71932e - i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        char c11;
        b();
        int i11 = this.f71932e;
        while (true) {
            int i12 = this.f71932e;
            if (i12 >= this.f71930c || (((c11 = this.f71928a[i12]) < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !Character.isLetter(c11)))) {
                break;
            }
            this.f71932e++;
        }
        while (!s()) {
            char[] cArr = this.f71928a;
            int i13 = this.f71932e;
            char c12 = cArr[i13];
            if (c12 < '0' || c12 > '9') {
                break;
            }
            this.f71932e = i13 + 1;
        }
        return c(this.f71928a, this.f71935h, i11, this.f71932e - i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return c(r6.f71928a, r6.f71935h, r0, r3 - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String j() {
        /*
            r6 = this;
            r6.b()
            int r0 = r6.f71932e
            int r1 = r6.f71930c
            char[] r2 = r6.f71928a
        L9:
            int r3 = r6.f71932e
            if (r3 >= r1) goto L33
            char r4 = r2[r3]
            r5 = 9
            if (r4 == r5) goto L33
            r5 = 10
            if (r4 == r5) goto L33
            r5 = 13
            if (r4 == r5) goto L33
            r5 = 12
            if (r4 == r5) goto L33
            r5 = 32
            if (r4 == r5) goto L33
            r5 = 47
            if (r4 == r5) goto L33
            r5 = 62
            if (r4 == r5) goto L33
            if (r4 != 0) goto L2e
            goto L33
        L2e:
            int r3 = r3 + 1
            r6.f71932e = r3
            goto L9
        L33:
            if (r3 <= r0) goto L3f
            char[] r1 = r6.f71928a
            java.lang.String[] r2 = r6.f71935h
            int r3 = r3 - r0
            java.lang.String r0 = c(r1, r2, r0, r3)
            goto L41
        L3f:
            java.lang.String r0 = ""
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.a.j():java.lang.String");
    }

    public String k(char c11) {
        int D = D(c11);
        if (D == -1) {
            return o();
        }
        String c12 = c(this.f71928a, this.f71935h, this.f71932e, D);
        this.f71932e += D;
        return c12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l(String str) {
        int E = E(str);
        if (E == -1) {
            return o();
        }
        String c11 = c(this.f71928a, this.f71935h, this.f71932e, E);
        this.f71932e += E;
        return c11;
    }

    public String m(char... cArr) {
        b();
        int i11 = this.f71932e;
        int i12 = this.f71930c;
        char[] cArr2 = this.f71928a;
        loop0: while (this.f71932e < i12) {
            for (char c11 : cArr) {
                if (cArr2[this.f71932e] == c11) {
                    break loop0;
                }
            }
            this.f71932e++;
        }
        int i13 = this.f71932e;
        return i13 > i11 ? c(this.f71928a, this.f71935h, i11, i13 - i11) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n(char... cArr) {
        b();
        int i11 = this.f71932e;
        int i12 = this.f71930c;
        char[] cArr2 = this.f71928a;
        while (true) {
            int i13 = this.f71932e;
            if (i13 >= i12 || Arrays.binarySearch(cArr, cArr2[i13]) >= 0) {
                break;
            }
            this.f71932e++;
        }
        int i14 = this.f71932e;
        return i14 > i11 ? c(this.f71928a, this.f71935h, i11, i14 - i11) : "";
    }

    String o() {
        b();
        char[] cArr = this.f71928a;
        String[] strArr = this.f71935h;
        int i11 = this.f71932e;
        String c11 = c(cArr, strArr, i11, this.f71930c - i11);
        this.f71932e = this.f71930c;
        return c11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p(String str) {
        Locale locale = Locale.ENGLISH;
        return E(str.toLowerCase(locale)) > -1 || E(str.toUpperCase(locale)) > -1;
    }

    public char q() {
        b();
        if (s()) {
            return (char) 65535;
        }
        return this.f71928a[this.f71932e];
    }

    public boolean r() {
        b();
        return this.f71932e >= this.f71930c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        this.f71934g = this.f71932e;
    }

    public String toString() {
        char[] cArr = this.f71928a;
        int i11 = this.f71932e;
        return new String(cArr, i11, this.f71930c - i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u(String str) {
        b();
        if (!x(str)) {
            return false;
        }
        this.f71932e += str.length();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(String str) {
        if (!B(str)) {
            return false;
        }
        this.f71932e += str.length();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w(char c11) {
        return !r() && this.f71928a[this.f71932e] == c11;
    }

    boolean x(String str) {
        b();
        int length = str.length();
        if (length > this.f71930c - this.f71932e) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (str.charAt(i11) != this.f71928a[this.f71932e + i11]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(char... cArr) {
        if (r()) {
            return false;
        }
        b();
        char c11 = this.f71928a[this.f71932e];
        for (char c12 : cArr) {
            if (c12 == c11) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z(char[] cArr) {
        b();
        return !r() && Arrays.binarySearch(cArr, this.f71928a[this.f71932e]) >= 0;
    }
}
