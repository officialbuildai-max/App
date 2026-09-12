package tz;

/* loaded from: classes7.dex */
abstract class e extends h {

    /* loaded from: classes7.dex */
    static class a extends e {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public String b() {
            return "UTF-16BE";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public tz.b c(tz.a aVar) {
            byte[] bArr = aVar.f76547e;
            int min = Math.min(bArr.length, 30);
            int i11 = 10;
            int i12 = 0;
            while (true) {
                if (i12 >= min - 1) {
                    break;
                }
                int e11 = e.e(bArr[i12], bArr[i12 + 1]);
                if (i12 != 0 || e11 != 65279) {
                    i11 = e.d(e11, i11);
                    if (i11 == 0 || i11 == 100) {
                        break;
                    }
                    i12 += 2;
                } else {
                    i11 = 100;
                    break;
                }
            }
            int i13 = (min >= 4 || i11 >= 100) ? i11 : 0;
            if (i13 > 0) {
                return new tz.b(aVar, this, i13);
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    static class b extends e {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public String b() {
            return "UTF-16LE";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public tz.b c(tz.a aVar) {
            byte[] bArr = aVar.f76547e;
            int min = Math.min(bArr.length, 30);
            int i11 = 10;
            int i12 = 0;
            while (true) {
                if (i12 >= min - 1) {
                    break;
                }
                int e11 = e.e(bArr[i12 + 1], bArr[i12]);
                if (i12 != 0 || e11 != 65279) {
                    i11 = e.d(e11, i11);
                    if (i11 == 0 || i11 == 100) {
                        break;
                    }
                    i12 += 2;
                } else {
                    i11 = 100;
                    break;
                }
            }
            int i13 = (min >= 4 || i11 >= 100) ? i11 : 0;
            if (i13 > 0) {
                return new tz.b(aVar, this, i13);
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    static abstract class c extends e {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        @Override // tz.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public tz.b c(tz.a r11) {
            /*
                r10 = this;
                byte[] r0 = r11.f76547e
                int r1 = r11.f76548f
                int r1 = r1 / 4
                int r1 = r1 * 4
                r2 = 0
                if (r1 != 0) goto Lc
                return r2
            Lc:
                r3 = 0
                int r4 = r10.f(r0, r3)
                r5 = 65279(0xfeff, float:9.1475E-41)
                if (r4 != r5) goto L18
                r4 = 1
                goto L19
            L18:
                r4 = r3
            L19:
                r5 = r3
                r6 = r5
                r7 = r6
            L1c:
                if (r5 >= r1) goto L3c
                int r8 = r10.f(r0, r5)
                if (r8 < 0) goto L37
                r9 = 1114111(0x10ffff, float:1.561202E-39)
                if (r8 >= r9) goto L37
                r9 = 55296(0xd800, float:7.7486E-41)
                if (r8 < r9) goto L34
                r9 = 57343(0xdfff, float:8.0355E-41)
                if (r8 > r9) goto L34
                goto L37
            L34:
                int r7 = r7 + 1
                goto L39
            L37:
                int r6 = r6 + 1
            L39:
                int r5 = r5 + 4
                goto L1c
            L3c:
                r0 = 100
                if (r4 == 0) goto L44
                if (r6 != 0) goto L44
            L42:
                r3 = r0
                goto L5f
            L44:
                r1 = 80
                if (r4 == 0) goto L4e
                int r4 = r6 * 10
                if (r7 <= r4) goto L4e
            L4c:
                r3 = r1
                goto L5f
            L4e:
                r4 = 3
                if (r7 <= r4) goto L54
                if (r6 != 0) goto L54
                goto L42
            L54:
                if (r7 <= 0) goto L59
                if (r6 != 0) goto L59
                goto L4c
            L59:
                int r6 = r6 * 10
                if (r7 <= r6) goto L5f
                r3 = 25
            L5f:
                if (r3 != 0) goto L62
                goto L67
            L62:
                tz.b r2 = new tz.b
                r2.<init>(r11, r10, r3)
            L67:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: tz.e.c.c(tz.a):tz.b");
        }

        abstract int f(byte[] bArr, int i11);
    }

    /* loaded from: classes7.dex */
    static class d extends c {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public String b() {
            return "UTF-32BE";
        }

        @Override // tz.e.c
        int f(byte[] bArr, int i11) {
            return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
        }
    }

    /* renamed from: tz.e$e, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0958e extends c {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public String b() {
            return "UTF-32LE";
        }

        @Override // tz.e.c
        int f(byte[] bArr, int i11) {
            return (bArr[i11] & 255) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 1] & 255) << 8);
        }
    }

    e() {
    }

    static int d(int i11, int i12) {
        if (i11 == 0) {
            i12 -= 10;
        } else if ((i11 >= 32 && i11 <= 255) || i11 == 10) {
            i12 += 10;
        }
        if (i12 < 0) {
            return 0;
        }
        if (i12 > 100) {
            return 100;
        }
        return i12;
    }

    static int e(byte b11, byte b12) {
        return ((b11 & 255) << 8) | (b12 & 255);
    }
}
