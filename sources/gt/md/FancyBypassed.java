package gt.md;

import android.widget.TextView;
import java.io.ByteArrayOutputStream;

/* loaded from: classes7.dex */
public class FancyBypassed {

    /* renamed from: ۧۡۤۨ, reason: not valid java name and contains not printable characters */
    public static boolean f67;

    /* renamed from: ۣ۟ۡۤۤ, reason: not valid java name and contains not printable characters */
    public static int m1106(Object obj) {
        if (C0798.m1142() > 0) {
            return ((String) obj).length();
        }
        return 0;
    }

    /* renamed from: ۟ۥ۠۠ۨ, reason: not valid java name and contains not printable characters */
    public static StringBuffer m1107(Object obj, Object obj2) {
        if (m1112() > 0) {
            return ((StringBuffer) obj).append((String) obj2);
        }
        return null;
    }

    /* renamed from: ۟ۥۡ۠ۧ, reason: not valid java name and contains not printable characters */
    public static int m1108() {
        if (m1112() >= 0) {
            return Config.textSize;
        }
        return 0;
    }

    /* renamed from: ۟ۧۡ۠ۢ, reason: not valid java name and contains not printable characters */
    public static void m1109(Object obj, int i11) {
        if (SigninBypassed.m1124() > 0) {
            ((TextView) obj).setTextColor(i11);
        }
    }

    /* renamed from: ۡ۟ۦ۠, reason: not valid java name and contains not printable characters */
    public static String m1111() {
        if (C0797.m1131() >= 0) {
            return Config.backgroundColor;
        }
        return null;
    }

    /* renamed from: ۢۥۤۡ, reason: not valid java name and contains not printable characters */
    public static int m1112() {
        return 1748780 ^ C0797.m1125((Object) "ۡۦۥ");
    }

    /* renamed from: ۣۨۡۡ, reason: not valid java name and contains not printable characters */
    public static String m1113() {
        if (m1112() >= 0) {
            return Config.message;
        }
        return null;
    }

    /* renamed from: ۦ۠۟۠, reason: contains not printable characters */
    public static String m1114(String str) {
        String m1133 = C0797.m1133();
        String m11332 = C0797.m1133();
        for (int i11 = 0; i11 < 15; i11++) {
            m1133 = C0797.m1136(m1107(m1107(new StringBuffer(), m1133), C0800.m1182(i11)));
            m11332 = C0797.m1136(C0800.m1181(m1107(new StringBuffer(), m11332), ((int) (C0800.m1172() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(m1106(str) / 2);
        for (int i12 = 0; i12 < m1106(str); i12 += 2) {
            C0798.m1144(byteArrayOutputStream, (C0797.m1135(m1133, C0800.m1169(str, i12)) << 4) | C0797.m1135(m1133, C0800.m1169(str, i12 + 1)));
        }
        byte[] m1175 = C0800.m1175(byteArrayOutputStream);
        int length = m1175.length;
        int m1106 = m1106(m11332);
        while (length > 0) {
            m1175[-1] = (byte) (m1175[-1] ^ C0800.m1169(m11332, (-1) % m1106));
        }
        for (int i13 = 0; i13 < m1175.length; i13 = m1106(C0797.m1133()) + 1) {
        }
        return new String(m1175);
    }

    /* renamed from: ۦۡۨ۟, reason: contains not printable characters */
    public static long m1115(Object obj, int i11) {
        if (C0797.m1131() >= 0) {
            return Long.parseLong((String) obj, i11);
        }
        return 0L;
    }

    /* renamed from: ۦۢۨۦ, reason: contains not printable characters */
    public static int m1116() {
        if (SigninBypassed.m1124() >= 0) {
            return Config.cornerRadius;
        }
        return 0;
    }

    /* renamed from: ۟ۧۥۧۥ, reason: not valid java name and contains not printable characters */
    public static String m1110(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
