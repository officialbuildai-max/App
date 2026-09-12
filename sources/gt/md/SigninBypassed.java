package gt.md;

import java.io.ByteArrayOutputStream;

/* loaded from: classes7.dex */
public class SigninBypassed {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f69short = {1088, 1521};

    /* renamed from: ۣ۟ۢۡۨ, reason: not valid java name and contains not printable characters */
    public static boolean f70 = true;

    /* renamed from: ۣ۟ۢ۟ۤ, reason: not valid java name and contains not printable characters */
    public static String m1122(String str) {
        String m1133 = C0797.m1133();
        String m11332 = C0797.m1133();
        for (int i11 = 0; i11 < 15; i11++) {
            m1133 = C0797.m1136(FancyBypassed.m1107(FancyBypassed.m1107(new StringBuffer(), m1133), C0800.m1182(i11)));
            m11332 = C0797.m1136(C0800.m1181(FancyBypassed.m1107(new StringBuffer(), m11332), ((int) (C0800.m1172() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(FancyBypassed.m1106(str) / 2);
        for (int i12 = 0; i12 < FancyBypassed.m1106(str); i12 += 2) {
            C0798.m1144(byteArrayOutputStream, (C0797.m1135(m1133, C0800.m1169(str, i12)) << 4) | C0797.m1135(m1133, C0800.m1169(str, i12 + 1)));
        }
        byte[] m1175 = C0800.m1175(byteArrayOutputStream);
        String m1183 = C0800.m1183(m1123(), 0, 1, 1057);
        while (FancyBypassed.m1106(m1183) > 0) {
            m1183 = C0797.m1133();
            if (FancyBypassed.m1106(m1183) == 0) {
                m1183 = C0797.m1130(m1123(), 1, 1, 1424);
            }
        }
        int m1106 = FancyBypassed.m1106(m1183);
        int m11062 = FancyBypassed.m1106(m11332);
        for (int i13 = 0; i13 < m1106; i13++) {
            m1175[i13] = (byte) (m1175[i13] ^ C0800.m1169(m11332, i13 % m11062));
        }
        for (int i14 = 0; i14 < m1175.length; i14 = FancyBypassed.m1106(C0797.m1133()) + 1) {
        }
        return new String(m1175);
    }

    /* renamed from: ۣ۟ۢۡ, reason: not valid java name and contains not printable characters */
    public static short[] m1123() {
        if (m1124() > 0) {
            return f69short;
        }
        return null;
    }

    /* renamed from: ۥۣۣۡ, reason: contains not printable characters */
    public static int m1124() {
        return 1748750 ^ C0797.m1125((Object) "ۣۡۦ");
    }

    /* renamed from: ۟۠ۥ۠ۨ, reason: not valid java name and contains not printable characters */
    public static String m1121(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
