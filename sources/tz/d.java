package tz;

/* loaded from: classes7.dex */
class d extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // tz.h
    public String b() {
        return "UTF-8";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    @Override // tz.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public tz.b c(tz.a r14) {
        /*
            r13 = this;
            byte[] r0 = r14.f76547e
            int r1 = r14.f76548f
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = 3
            if (r1 < r5) goto L24
            r1 = r0[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 239(0xef, float:3.35E-43)
            if (r1 != r6) goto L24
            r1 = r0[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 187(0xbb, float:2.62E-43)
            if (r1 != r6) goto L24
            r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 191(0xbf, float:2.68E-43)
            if (r1 != r6) goto L24
            r1 = r3
            goto L25
        L24:
            r1 = r4
        L25:
            r6 = r4
            r7 = r6
            r8 = r7
        L28:
            int r9 = r14.f76548f
            if (r6 >= r9) goto L62
            r9 = r0[r6]
            r10 = r9 & 128(0x80, float:1.794E-43)
            if (r10 != 0) goto L33
            goto L60
        L33:
            r10 = r9 & 224(0xe0, float:3.14E-43)
            r11 = 192(0xc0, float:2.69E-43)
            if (r10 != r11) goto L3b
            r9 = r3
            goto L4a
        L3b:
            r10 = r9 & 240(0xf0, float:3.36E-43)
            r12 = 224(0xe0, float:3.14E-43)
            if (r10 != r12) goto L43
            r9 = r2
            goto L4a
        L43:
            r9 = r9 & 248(0xf8, float:3.48E-43)
            r10 = 240(0xf0, float:3.36E-43)
            if (r9 != r10) goto L57
            r9 = r5
        L4a:
            int r6 = r6 + r3
            int r10 = r14.f76548f
            if (r6 < r10) goto L50
            goto L60
        L50:
            r10 = r0[r6]
            r10 = r10 & r11
            r12 = 128(0x80, float:1.794E-43)
            if (r10 == r12) goto L5a
        L57:
            int r7 = r7 + 1
            goto L60
        L5a:
            int r9 = r9 + (-1)
            if (r9 != 0) goto L4a
            int r8 = r8 + 1
        L60:
            int r6 = r6 + r3
            goto L28
        L62:
            r0 = 100
            if (r1 == 0) goto L6a
            if (r7 != 0) goto L6a
        L68:
            r4 = r0
            goto L8b
        L6a:
            r2 = 80
            if (r1 == 0) goto L74
            int r1 = r7 * 10
            if (r8 <= r1) goto L74
        L72:
            r4 = r2
            goto L8b
        L74:
            if (r8 <= r5) goto L79
            if (r7 != 0) goto L79
            goto L68
        L79:
            if (r8 <= 0) goto L7e
            if (r7 != 0) goto L7e
            goto L72
        L7e:
            if (r8 != 0) goto L85
            if (r7 != 0) goto L85
            r4 = 15
            goto L8b
        L85:
            int r7 = r7 * 10
            if (r8 <= r7) goto L8b
            r4 = 25
        L8b:
            if (r4 != 0) goto L8f
            r14 = 0
            goto L95
        L8f:
            tz.b r0 = new tz.b
            r0.<init>(r14, r13, r4)
            r14 = r0
        L95:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: tz.d.c(tz.a):tz.b");
    }
}
