package com.google.zxing.oned;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import qd.q;

/* loaded from: classes4.dex */
public final class Code128Writer extends q {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class MinimalEncoder {

        /* renamed from: a, reason: collision with root package name */
        private int[][] f32973a;

        /* renamed from: b, reason: collision with root package name */
        private Latch[][] f32974b;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public enum Charset {
            A,
            B,
            C,
            NONE
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public enum Latch {
            A,
            B,
            C,
            SHIFT,
            NONE
        }

        private MinimalEncoder() {
        }

        /* synthetic */ MinimalEncoder(a aVar) {
            this();
        }

        private static void b(Collection collection, int i11, int[] iArr, int[] iArr2, int i12) {
            collection.add(com.google.zxing.oned.a.f32977a[i11]);
            if (i12 != 0) {
                iArr2[0] = iArr2[0] + 1;
            }
            iArr[0] = iArr[0] + (i11 * iArr2[0]);
        }

        private boolean c(CharSequence charSequence, Charset charset, int i11) {
            int i12;
            char charAt = charSequence.charAt(i11);
            int i13 = a.f32976b[charset.ordinal()];
            if (i13 == 1) {
                return charAt == 241 || charAt == 242 || charAt == 243 || charAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fÿ".indexOf(charAt) >= 0;
            }
            if (i13 == 2) {
                return charAt == 241 || charAt == 242 || charAt == 243 || charAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007fÿ".indexOf(charAt) >= 0;
            }
            if (i13 != 3) {
                return false;
            }
            return charAt == 241 || ((i12 = i11 + 1) < charSequence.length() && f(charAt) && f(charSequence.charAt(i12)));
        }

        private int d(CharSequence charSequence, Charset charset, int i11) {
            int i12;
            int i13;
            int i14 = this.f32973a[charset.ordinal()][i11];
            if (i14 > 0) {
                return i14;
            }
            Latch latch = Latch.NONE;
            int i15 = i11 + 1;
            boolean z10 = i15 >= charSequence.length();
            Charset[] charsetArr = {Charset.A, Charset.B};
            int i16 = Integer.MAX_VALUE;
            for (int i17 = 0; i17 <= 1; i17++) {
                if (c(charSequence, charsetArr[i17], i11)) {
                    Latch latch2 = Latch.NONE;
                    Charset charset2 = charsetArr[i17];
                    if (charset != charset2) {
                        latch2 = Latch.valueOf(charset2.toString());
                        i13 = 2;
                    } else {
                        i13 = 1;
                    }
                    if (!z10) {
                        i13 += d(charSequence, charsetArr[i17], i15);
                    }
                    if (i13 < i16) {
                        latch = latch2;
                        i16 = i13;
                    }
                    if (charset == charsetArr[(i17 + 1) % 2]) {
                        Latch latch3 = Latch.SHIFT;
                        int d11 = !z10 ? d(charSequence, charset, i15) + 2 : 2;
                        if (d11 < i16) {
                            latch = latch3;
                            i16 = d11;
                        }
                    }
                }
            }
            Charset charset3 = Charset.C;
            if (c(charSequence, charset3, i11)) {
                Latch latch4 = Latch.NONE;
                if (charset != charset3) {
                    latch4 = Latch.C;
                    i12 = 2;
                } else {
                    i12 = 1;
                }
                int i18 = (charSequence.charAt(i11) == 241 ? 1 : 2) + i11;
                if (i18 < charSequence.length()) {
                    i12 += d(charSequence, charset3, i18);
                }
                if (i12 < i16) {
                    latch = latch4;
                    i16 = i12;
                }
            }
            if (i16 != Integer.MAX_VALUE) {
                this.f32973a[charset.ordinal()][i11] = i16;
                this.f32974b[charset.ordinal()][i11] = latch;
                return i16;
            }
            throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) charSequence.charAt(i11)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00ba  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean[] e(java.lang.String r17) {
            /*
                Method dump skipped, instructions count: 278
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.MinimalEncoder.e(java.lang.String):boolean[]");
        }

        private static boolean f(char c11) {
            return c11 >= '0' && c11 <= '9';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32975a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f32976b;

        static {
            int[] iArr = new int[MinimalEncoder.Charset.values().length];
            f32976b = iArr;
            try {
                iArr[MinimalEncoder.Charset.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32976b[MinimalEncoder.Charset.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32976b[MinimalEncoder.Charset.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[MinimalEncoder.Latch.values().length];
            f32975a = iArr2;
            try {
                iArr2[MinimalEncoder.Latch.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32975a[MinimalEncoder.Latch.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32975a[MinimalEncoder.Latch.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32975a[MinimalEncoder.Latch.SHIFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0074. Please report as an issue. */
    private static int i(String str, Map map) {
        int i11 = -1;
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.FORCE_CODE_SET;
            if (map.containsKey(encodeHintType)) {
                String obj = map.get(encodeHintType).toString();
                obj.hashCode();
                switch (obj.hashCode()) {
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                        if (obj.equals("A")) {
                            i11 = 0;
                            break;
                        }
                        break;
                    case 66:
                        if (obj.equals("B")) {
                            i11 = 1;
                            break;
                        }
                        break;
                    case 67:
                        if (obj.equals("C")) {
                            i11 = 2;
                            break;
                        }
                        break;
                }
                switch (i11) {
                    case 0:
                        i11 = 101;
                        break;
                    case 1:
                        i11 = 100;
                        break;
                    case 2:
                        i11 = 99;
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported code set hint: " + obj);
                }
            }
        }
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            switch (charAt) {
                default:
                    if (charAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) charAt));
                    }
                case 241:
                case 242:
                case 243:
                case 244:
                    switch (i11) {
                        case 99:
                            if (charAt < '0' || ((charAt > '9' && charAt <= 127) || charAt == 242 || charAt == 243 || charAt == 244)) {
                                throw new IllegalArgumentException("Bad character in input for forced code set C: ASCII value=" + ((int) charAt));
                            }
                            break;
                            break;
                        case 100:
                            if (charAt < ' ') {
                                throw new IllegalArgumentException("Bad character in input for forced code set B: ASCII value=" + ((int) charAt));
                            }
                            break;
                        case 101:
                            if (charAt > '_' && charAt <= 127) {
                                throw new IllegalArgumentException("Bad character in input for forced code set A: ASCII value=" + ((int) charAt));
                            }
                            break;
                    }
                    break;
            }
        }
        return i11;
    }

    private static int j(CharSequence charSequence, int i11, int i12) {
        CType l11;
        CType l12;
        char charAt;
        CType l13 = l(charSequence, i11);
        CType cType = CType.ONE_DIGIT;
        if (l13 == cType) {
            return i12 == 101 ? 101 : 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (l13 == cType2) {
            return (i11 >= charSequence.length() || ((charAt = charSequence.charAt(i11)) >= ' ' && (i12 != 101 || (charAt >= '`' && (charAt < 241 || charAt > 244))))) ? 100 : 101;
        }
        if (i12 == 101 && l13 == CType.FNC_1) {
            return 101;
        }
        if (i12 == 99) {
            return 99;
        }
        if (i12 != 100) {
            if (l13 == CType.FNC_1) {
                l13 = l(charSequence, i11 + 1);
            }
            return l13 == CType.TWO_DIGITS ? 99 : 100;
        }
        CType cType3 = CType.FNC_1;
        if (l13 == cType3 || (l11 = l(charSequence, i11 + 2)) == cType2 || l11 == cType) {
            return 100;
        }
        if (l11 == cType3) {
            return l(charSequence, i11 + 3) == CType.TWO_DIGITS ? 99 : 100;
        }
        int i13 = i11 + 4;
        while (true) {
            l12 = l(charSequence, i13);
            if (l12 != CType.TWO_DIGITS) {
                break;
            }
            i13 += 2;
        }
        return l12 == CType.ONE_DIGIT ? 100 : 99;
    }

    private static boolean[] k(String str, int i11) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1;
        while (i12 < length) {
            int j11 = i11 == -1 ? j(str, i12, i14) : i11;
            int i16 = 100;
            if (j11 == i14) {
                switch (str.charAt(i12)) {
                    case 241:
                        i16 = 102;
                        break;
                    case 242:
                        i16 = 97;
                        break;
                    case 243:
                        i16 = 96;
                        break;
                    case 244:
                        if (i14 == 101) {
                            i16 = 101;
                            break;
                        }
                        break;
                    default:
                        if (i14 == 100) {
                            i16 = str.charAt(i12) - ' ';
                            break;
                        } else if (i14 == 101) {
                            char charAt = str.charAt(i12);
                            i16 = charAt - ' ';
                            if (i16 < 0) {
                                i16 = charAt + '@';
                                break;
                            }
                        } else {
                            int i17 = i12 + 1;
                            if (i17 == length) {
                                throw new IllegalArgumentException("Bad number of characters for digit only encoding.");
                            }
                            i16 = Integer.parseInt(str.substring(i12, i12 + 2));
                            i12 = i17;
                            break;
                        }
                        break;
                }
                i12++;
            } else {
                if (i14 == 0) {
                    i16 = j11 != 100 ? j11 != 101 ? 105 : 103 : 104;
                } else {
                    i16 = j11;
                }
                i14 = j11;
            }
            arrayList.add(com.google.zxing.oned.a.f32977a[i16]);
            i13 += i16 * i15;
            if (i12 != 0) {
                i15++;
            }
        }
        return m(arrayList, i13);
    }

    private static CType l(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        if (i11 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i11);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i12 = i11 + 1;
        if (i12 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i12);
        return (charAt2 < '0' || charAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    static boolean[] m(Collection collection, int i11) {
        int[][] iArr = com.google.zxing.oned.a.f32977a;
        collection.add(iArr[i11 % 103]);
        collection.add(iArr[106]);
        Iterator it = collection.iterator();
        int i12 = 0;
        int i13 = 0;
        while (it.hasNext()) {
            for (int i14 : (int[]) it.next()) {
                i13 += i14;
            }
        }
        boolean[] zArr = new boolean[i13];
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            i12 += q.b(zArr, i12, (int[]) it2.next(), true);
        }
        return zArr;
    }

    @Override // qd.q
    public boolean[] d(String str) {
        return e(str, null);
    }

    @Override // qd.q
    public boolean[] e(String str, Map map) {
        int i11 = i(str, map);
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CODE128_COMPACT;
            if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                return new MinimalEncoder(null).e(str);
            }
        }
        return k(str, i11);
    }

    @Override // qd.q
    protected Collection g() {
        return Collections.singleton(BarcodeFormat.CODE_128);
    }
}
