package com.alibaba.fastjson.asm;

/* loaded from: classes2.dex */
public class j {

    /* renamed from: e, reason: collision with root package name */
    public static final j f18211e = new j(0, null, 1443168256, 1);

    /* renamed from: f, reason: collision with root package name */
    public static final j f18212f = new j(1, null, 1509950721, 1);

    /* renamed from: g, reason: collision with root package name */
    public static final j f18213g = new j(2, null, 1124075009, 1);

    /* renamed from: h, reason: collision with root package name */
    public static final j f18214h = new j(3, null, 1107297537, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final j f18215i = new j(4, null, 1392510721, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final j f18216j = new j(5, null, 1224736769, 1);

    /* renamed from: k, reason: collision with root package name */
    public static final j f18217k = new j(6, null, 1174536705, 1);

    /* renamed from: l, reason: collision with root package name */
    public static final j f18218l = new j(7, null, 1241579778, 1);

    /* renamed from: m, reason: collision with root package name */
    public static final j f18219m = new j(8, null, 1141048066, 1);

    /* renamed from: a, reason: collision with root package name */
    protected final int f18220a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f18221b;

    /* renamed from: c, reason: collision with root package name */
    private final int f18222c;

    /* renamed from: d, reason: collision with root package name */
    private final int f18223d;

    private j(int i11, char[] cArr, int i12, int i13) {
        this.f18220a = i11;
        this.f18221b = cArr;
        this.f18222c = i12;
        this.f18223d = i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j[] a(String str) {
        char[] charArray = str.toCharArray();
        int i11 = 1;
        int i12 = 1;
        int i13 = 0;
        while (true) {
            int i14 = i12 + 1;
            char c11 = charArray[i12];
            if (c11 == ')') {
                break;
            }
            if (c11 == 'L') {
                while (true) {
                    i12 = i14 + 1;
                    if (charArray[i14] == ';') {
                        break;
                    }
                    i14 = i12;
                }
                i13++;
            } else {
                if (c11 != '[') {
                    i13++;
                }
                i12 = i14;
            }
        }
        j[] jVarArr = new j[i13];
        int i15 = 0;
        while (charArray[i11] != ')') {
            j h11 = h(charArray, i11);
            jVarArr[i15] = h11;
            i11 += h11.f18223d + (h11.f18220a == 10 ? 2 : 0);
            i15++;
        }
        return jVarArr;
    }

    public static int b(String str) {
        int i11;
        int i12 = 1;
        int i13 = 1;
        int i14 = 1;
        while (true) {
            i11 = i13 + 1;
            char charAt = str.charAt(i13);
            if (charAt == ')') {
                break;
            }
            if (charAt == 'L') {
                while (true) {
                    i13 = i11 + 1;
                    if (str.charAt(i11) == ';') {
                        break;
                    }
                    i11 = i13;
                }
                i14++;
            } else {
                i14 = (charAt == 'D' || charAt == 'J') ? i14 + 2 : i14 + 1;
                i13 = i11;
            }
        }
        char charAt2 = str.charAt(i11);
        int i15 = i14 << 2;
        if (charAt2 == 'V') {
            i12 = 0;
        } else if (charAt2 == 'D' || charAt2 == 'J') {
            i12 = 2;
        }
        return i15 | i12;
    }

    private int e() {
        int i11 = 1;
        while (this.f18221b[this.f18222c + i11] == '[') {
            i11++;
        }
        return i11;
    }

    public static j g(String str) {
        return h(str.toCharArray(), 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004d, code lost:
    
        if (r4 == 'L') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004f, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0055, code lost:
    
        if (r5[r6 + r0] == ';') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0060, code lost:
    
        return new com.alibaba.fastjson.asm.j(9, r5, r6, r0 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.alibaba.fastjson.asm.j h(char[] r5, int r6) {
        /*
            char r0 = r5[r6]
            r1 = 70
            if (r0 == r1) goto L70
            r1 = 83
            if (r0 == r1) goto L6d
            r1 = 86
            if (r0 == r1) goto L6a
            r1 = 73
            if (r0 == r1) goto L67
            r1 = 74
            if (r0 == r1) goto L64
            r1 = 90
            if (r0 == r1) goto L61
            r1 = 59
            r2 = 91
            r3 = 1
            if (r0 == r2) goto L41
            switch(r0) {
                case 66: goto L3e;
                case 67: goto L3b;
                case 68: goto L38;
                default: goto L24;
            }
        L24:
            r0 = r3
        L25:
            int r2 = r6 + r0
            char r2 = r5[r2]
            if (r2 == r1) goto L2e
            int r0 = r0 + 1
            goto L25
        L2e:
            com.alibaba.fastjson.asm.j r1 = new com.alibaba.fastjson.asm.j
            int r6 = r6 + r3
            int r0 = r0 - r3
            r2 = 10
            r1.<init>(r2, r5, r6, r0)
            return r1
        L38:
            com.alibaba.fastjson.asm.j r5 = com.alibaba.fastjson.asm.j.f18219m
            return r5
        L3b:
            com.alibaba.fastjson.asm.j r5 = com.alibaba.fastjson.asm.j.f18213g
            return r5
        L3e:
            com.alibaba.fastjson.asm.j r5 = com.alibaba.fastjson.asm.j.f18214h
            return r5
        L41:
            r0 = r3
        L42:
            int r4 = r6 + r0
            char r4 = r5[r4]
            if (r4 != r2) goto L4b
            int r0 = r0 + 1
            goto L42
        L4b:
            r2 = 76
            if (r4 != r2) goto L58
        L4f:
            int r0 = r0 + 1
            int r2 = r6 + r0
            char r2 = r5[r2]
            if (r2 == r1) goto L58
            goto L4f
        L58:
            com.alibaba.fastjson.asm.j r1 = new com.alibaba.fastjson.asm.j
            r2 = 9
            int r0 = r0 + r3
            r1.<init>(r2, r5, r6, r0)
            return r1
        L61:
            com.alibaba.fastjson.asm.j r5 = com.alibaba.fastjson.asm.j.f18212f
            return r5
        L64:
            com.alibaba.fastjson.asm.j r5 = com.alibaba.fastjson.asm.j.f18218l
            return r5
        L67:
            com.alibaba.fastjson.asm.j r5 = com.alibaba.fastjson.asm.j.f18216j
            return r5
        L6a:
            com.alibaba.fastjson.asm.j r5 = com.alibaba.fastjson.asm.j.f18211e
            return r5
        L6d:
            com.alibaba.fastjson.asm.j r5 = com.alibaba.fastjson.asm.j.f18215i
            return r5
        L70:
            com.alibaba.fastjson.asm.j r5 = com.alibaba.fastjson.asm.j.f18217k
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.asm.j.h(char[], int):com.alibaba.fastjson.asm.j");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        switch (this.f18220a) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuilder sb2 = new StringBuilder(h(this.f18221b, this.f18222c + e()).c());
                for (int e11 = e(); e11 > 0; e11--) {
                    sb2.append("[]");
                }
                return sb2.toString();
            default:
                return new String(this.f18221b, this.f18222c, this.f18223d).replace('/', '.');
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return new String(this.f18221b, this.f18222c, this.f18223d);
    }

    public String f() {
        return new String(this.f18221b, this.f18222c, this.f18223d);
    }
}
