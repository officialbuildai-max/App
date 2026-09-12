package gt.md;

import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;

/* renamed from: gt.md.ۣۣ۟۠ۥ, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0797 {

    /* renamed from: ۥۤۢۥ, reason: contains not printable characters */
    public static boolean f71;

    /* renamed from: ۟۠ۨ۟۠, reason: not valid java name and contains not printable characters */
    public static int m1125(Object obj) {
        return obj.hashCode();
    }

    /* renamed from: ۣ۟ۦۤ۠, reason: not valid java name and contains not printable characters */
    public static void m1128(Object obj, int i11) {
        if (SigninBypassed.m1124() >= 0) {
            ((LinearLayout) obj).setGravity(i11);
        }
    }

    /* renamed from: ۟ۥۣۢۦ, reason: not valid java name and contains not printable characters */
    public static String m1129(String str) {
        String m1133 = m1133();
        String m11332 = m1133();
        for (int i11 = 0; i11 < 15; i11++) {
            m1133 = m1136(FancyBypassed.m1107(FancyBypassed.m1107(new StringBuffer(), m1133), C0800.m1182(i11)));
            m11332 = m1136(C0800.m1181(FancyBypassed.m1107(new StringBuffer(), m11332), ((int) (C0800.m1172() * 10)) ^ i11));
        }
        do {
        } while (FancyBypassed.m1106(m1133) > 0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(FancyBypassed.m1106(str) / 2);
        for (int i12 = 0; i12 < FancyBypassed.m1106(str); i12 += 2) {
            C0798.m1144(byteArrayOutputStream, (m1135(m1133, C0800.m1169(str, i12)) << 4) | m1135(m1133, C0800.m1169(str, i12 + 1)));
        }
        byte[] m1175 = C0800.m1175(byteArrayOutputStream);
        int length = m1175.length;
        int m1106 = FancyBypassed.m1106(m11332);
        for (int i13 = 0; i13 < length; i13++) {
            m1175[i13] = (byte) (m1175[i13] ^ C0800.m1169(m11332, i13 % m1106));
        }
        return new String(m1175);
    }

    /* renamed from: ۟ۧۧۦ۟, reason: not valid java name and contains not printable characters */
    public static int m1131() {
        return 1749821 ^ m1125((Object) "ۢۨۢ");
    }

    /* renamed from: ۠ۦۥۦ, reason: not valid java name and contains not printable characters */
    public static void m1132(Object obj) {
        if (SigninBypassed.m1124() > 0) {
            ((Toast) obj).show();
        }
    }

    /* renamed from: ۣۢۡۥ, reason: not valid java name and contains not printable characters */
    public static String m1133() {
        if (C0798.m1142() >= 0) {
            return "";
        }
        return null;
    }

    /* renamed from: ۢۤۢۧ, reason: not valid java name and contains not printable characters */
    public static boolean m1134() {
        if (C0798.m1142() >= 0) {
            return Config.isBold;
        }
        return false;
    }

    /* renamed from: ۥۦ۠ۦ, reason: contains not printable characters */
    public static int m1135(Object obj, int i11) {
        if (m1131() > 0) {
            return ((String) obj).indexOf(i11);
        }
        return 0;
    }

    /* renamed from: ۦۧۧ۟, reason: contains not printable characters */
    public static String m1136(Object obj) {
        if (SigninBypassed.m1124() > 0) {
            return ((StringBuffer) obj).toString();
        }
        return null;
    }

    /* renamed from: ۧ۟, reason: not valid java name and contains not printable characters */
    public static void m1137(Object obj, float f11) {
        if (m1131() > 0) {
            ((GradientDrawable) obj).setCornerRadius(f11);
        }
    }

    /* renamed from: ۧۨ۠ۤ, reason: not valid java name and contains not printable characters */
    public static void m1138(Object obj, Object obj2) {
        if (m1131() > 0) {
            ((TextView) obj).setText((CharSequence) obj2);
        }
    }

    /* renamed from: ۟۠ۨ۟۠, reason: not valid java name and contains not printable characters */
    public static Class<?> m1126(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    /* renamed from: ۟۠ۨ۟۠, reason: not valid java name and contains not printable characters */
    public static String m1127(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }

    /* renamed from: ۟ۦۥۨۢ, reason: not valid java name and contains not printable characters */
    public static String m1130(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
