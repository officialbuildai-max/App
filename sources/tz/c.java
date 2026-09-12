package tz;

/* loaded from: classes7.dex */
abstract class c extends h {

    /* loaded from: classes7.dex */
    static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private byte[][] f76560a = {new byte[]{27, 36, 41, 65}, new byte[]{27, 36, 41, 71}, new byte[]{27, 36, 42, 72}, new byte[]{27, 36, 41, 69}, new byte[]{27, 36, 43, 73}, new byte[]{27, 36, 43, 74}, new byte[]{27, 36, 43, 75}, new byte[]{27, 36, 43, 76}, new byte[]{27, 36, 43, 77}, new byte[]{27, 78}, new byte[]{27, 79}};

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public String b() {
            return "ISO-2022-CN";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public tz.b c(tz.a aVar) {
            int d11 = d(aVar.f76543a, aVar.f76544b, this.f76560a);
            if (d11 == 0) {
                return null;
            }
            return new tz.b(aVar, this, d11);
        }
    }

    /* loaded from: classes7.dex */
    static class b extends c {

        /* renamed from: a, reason: collision with root package name */
        private byte[][] f76561a = {new byte[]{27, 36, 40, 67}, new byte[]{27, 36, 40, 68}, new byte[]{27, 36, 64}, new byte[]{27, 36, 65}, new byte[]{27, 36, 66}, new byte[]{27, 38, 64}, new byte[]{27, 40, 66}, new byte[]{27, 40, 72}, new byte[]{27, 40, 73}, new byte[]{27, 40, 74}, new byte[]{27, 46, 65}, new byte[]{27, 46, 70}};

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public String b() {
            return "ISO-2022-JP";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public tz.b c(tz.a aVar) {
            int d11 = d(aVar.f76543a, aVar.f76544b, this.f76561a);
            if (d11 == 0) {
                return null;
            }
            return new tz.b(aVar, this, d11);
        }
    }

    /* renamed from: tz.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0957c extends c {

        /* renamed from: a, reason: collision with root package name */
        private byte[][] f76562a = {new byte[]{27, 36, 41, 67}};

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public String b() {
            return "ISO-2022-KR";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public tz.b c(tz.a aVar) {
            int d11 = d(aVar.f76543a, aVar.f76544b, this.f76562a);
            if (d11 == 0) {
                return null;
            }
            return new tz.b(aVar, this, d11);
        }
    }

    c() {
    }

    int d(byte[] bArr, int i11, byte[][] bArr2) {
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 < i11) {
            if (bArr[i12] == 27) {
                for (byte[] bArr3 : bArr2) {
                    if (i11 - i12 >= bArr3.length) {
                        for (int i16 = 1; i16 < bArr3.length; i16++) {
                            if (bArr3[i16] != bArr[i12 + i16]) {
                                break;
                            }
                        }
                        i13++;
                        i12 += bArr3.length - 1;
                        break;
                    }
                }
                i14++;
            }
            byte b11 = bArr[i12];
            if (b11 == 14 || b11 == 15) {
                i15++;
            }
            i12++;
        }
        if (i13 == 0) {
            return 0;
        }
        int i17 = ((i13 * 100) - (i14 * 100)) / (i14 + i13);
        int i18 = i13 + i15;
        if (i18 < 5) {
            i17 -= (5 - i18) * 10;
        }
        if (i17 < 0) {
            return 0;
        }
        return i17;
    }
}
