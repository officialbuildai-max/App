package org.jsoup.parser;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f71979a;

    /* renamed from: b, reason: collision with root package name */
    private int f71980b = 0;

    public g(String str) {
        org.jsoup.helper.d.j(str);
        this.f71979a = str;
    }

    private int r() {
        return this.f71979a.length() - this.f71980b;
    }

    public static String s(String str) {
        StringBuilder o11 = org.jsoup.helper.c.o();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i11 = 0;
        char c11 = 0;
        while (i11 < length) {
            char c12 = charArray[i11];
            if (c12 != '\\') {
                o11.append(c12);
            } else if (c11 != 0 && c11 == '\\') {
                o11.append(c12);
            }
            i11++;
            c11 = c12;
        }
        return o11.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006c A[EDGE_INSN: B:14:0x006c->B:15:0x006c BREAK  A[LOOP:0: B:2:0x0007->B:22:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:0: B:2:0x0007->B:22:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(char r11, char r12) {
        /*
            r10 = this;
            r0 = -1
            r1 = 0
            r5 = r0
            r6 = r5
            r2 = r1
            r3 = r2
            r4 = r3
        L7:
            boolean r7 = r10.j()
            if (r7 == 0) goto Le
            goto L6c
        Le:
            char r7 = r10.c()
            java.lang.Character r8 = java.lang.Character.valueOf(r7)
            if (r1 == 0) goto L1c
            r9 = 92
            if (r1 == r9) goto L63
        L1c:
            r9 = 39
            java.lang.Character r9 = java.lang.Character.valueOf(r9)
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L2f
            if (r7 == r11) goto L2f
            if (r2 != 0) goto L2f
            r3 = r3 ^ 1
            goto L41
        L2f:
            r9 = 34
            java.lang.Character r9 = java.lang.Character.valueOf(r9)
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L41
            if (r7 == r11) goto L41
            if (r3 != 0) goto L41
            r2 = r2 ^ 1
        L41:
            if (r3 != 0) goto L6a
            if (r2 == 0) goto L46
            goto L6a
        L46:
            java.lang.Character r9 = java.lang.Character.valueOf(r11)
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L57
            int r4 = r4 + 1
            if (r5 != r0) goto L63
            int r5 = r10.f71980b
            goto L63
        L57:
            java.lang.Character r9 = java.lang.Character.valueOf(r12)
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L63
            int r4 = r4 + (-1)
        L63:
            if (r4 <= 0) goto L69
            if (r1 == 0) goto L69
            int r6 = r10.f71980b
        L69:
            r1 = r7
        L6a:
            if (r4 > 0) goto L7
        L6c:
            if (r6 < 0) goto L75
            java.lang.String r11 = r10.f71979a
            java.lang.String r11 = r11.substring(r5, r6)
            goto L77
        L75:
            java.lang.String r11 = ""
        L77:
            if (r4 <= 0) goto L92
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Did not find balanced marker at '"
            r12.append(r0)
            r12.append(r11)
            java.lang.String r0 = "'"
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            org.jsoup.helper.d.a(r12)
        L92:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.g.a(char, char):java.lang.String");
    }

    public String b(String str) {
        String g11 = g(str);
        k(str);
        return g11;
    }

    public char c() {
        String str = this.f71979a;
        int i11 = this.f71980b;
        this.f71980b = i11 + 1;
        return str.charAt(i11);
    }

    public void d(String str) {
        if (!l(str)) {
            throw new IllegalStateException("Queue did not match expected sequence");
        }
        int length = str.length();
        if (length > r()) {
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        this.f71980b += length;
    }

    public String e() {
        int i11 = this.f71980b;
        while (!j() && (p() || m('-', '_'))) {
            this.f71980b++;
        }
        return this.f71979a.substring(i11, this.f71980b);
    }

    public String f() {
        int i11 = this.f71980b;
        while (!j() && (p() || n("*|", "|", "_", "-"))) {
            this.f71980b++;
        }
        return this.f71979a.substring(i11, this.f71980b);
    }

    public String g(String str) {
        int indexOf = this.f71979a.indexOf(str, this.f71980b);
        if (indexOf == -1) {
            return q();
        }
        String substring = this.f71979a.substring(this.f71980b, indexOf);
        this.f71980b += substring.length();
        return substring;
    }

    public String h(String... strArr) {
        int i11 = this.f71980b;
        while (!j() && !n(strArr)) {
            this.f71980b++;
        }
        return this.f71979a.substring(i11, this.f71980b);
    }

    public boolean i() {
        boolean z10 = false;
        while (o()) {
            this.f71980b++;
            z10 = true;
        }
        return z10;
    }

    public boolean j() {
        return r() == 0;
    }

    public boolean k(String str) {
        if (!l(str)) {
            return false;
        }
        this.f71980b += str.length();
        return true;
    }

    public boolean l(String str) {
        return this.f71979a.regionMatches(true, this.f71980b, str, 0, str.length());
    }

    public boolean m(char... cArr) {
        if (j()) {
            return false;
        }
        for (char c11 : cArr) {
            if (this.f71979a.charAt(this.f71980b) == c11) {
                return true;
            }
        }
        return false;
    }

    public boolean n(String... strArr) {
        for (String str : strArr) {
            if (l(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean o() {
        return !j() && org.jsoup.helper.c.h(this.f71979a.charAt(this.f71980b));
    }

    public boolean p() {
        return !j() && Character.isLetterOrDigit(this.f71979a.charAt(this.f71980b));
    }

    public String q() {
        String str = this.f71979a;
        String substring = str.substring(this.f71980b, str.length());
        this.f71980b = this.f71979a.length();
        return substring;
    }

    public String toString() {
        return this.f71979a.substring(this.f71980b);
    }
}
