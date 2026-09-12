package gt.md;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* renamed from: gt.md.ۣۤۧۧ, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0800 {

    /* renamed from: ۣۣۡ۠, reason: not valid java name and contains not printable characters */
    public static int f75 = 45;

    /* renamed from: ۟۟ۨۦۡ, reason: not valid java name and contains not printable characters */
    public static int m1163() {
        if (C0797.m1131() > 0) {
            return Config.duration;
        }
        return 0;
    }

    /* renamed from: ۟۠۠ۦ۠, reason: not valid java name and contains not printable characters */
    public static int m1164() {
        return 1751517 ^ C0797.m1125((Object) "ۤ۠ۥ");
    }

    /* renamed from: ۟ۡۦۣۡ, reason: not valid java name and contains not printable characters */
    public static void m1165(Object obj, Object obj2) {
        if (C0797.m1131() >= 0) {
            ((ImageView) obj).setScaleType((ImageView.ScaleType) obj2);
        }
    }

    /* renamed from: ۟ۢ۠ۥۡ, reason: not valid java name and contains not printable characters */
    public static Bitmap m1166(Object obj) {
        if (FancyBypassed.m1112() >= 0) {
            return BitmapFactory.decodeStream((InputStream) obj);
        }
        return null;
    }

    /* renamed from: ۟ۤۢۢ۠, reason: not valid java name and contains not printable characters */
    public static void m1167(Object obj, Object obj2, Object obj3) {
        if (SigninBypassed.m1124() > 0) {
            ((LinearLayout) obj).addView((View) obj2, (ViewGroup.LayoutParams) obj3);
        }
    }

    /* renamed from: ۟ۥۦۢۡ, reason: not valid java name and contains not printable characters */
    public static void m1168(Object obj, int i11) {
        if (C0797.m1131() > 0) {
            ((TextView) obj).setGravity(i11);
        }
    }

    /* renamed from: ۟ۥۧ۠ۧ, reason: not valid java name and contains not printable characters */
    public static char m1169(Object obj, int i11) {
        if (C0798.m1142() > 0) {
            return ((String) obj).charAt(i11);
        }
        return (char) 0;
    }

    /* renamed from: ۟ۥۣۨۨ, reason: not valid java name and contains not printable characters */
    public static ImageView.ScaleType m1170() {
        if (C0798.m1142() >= 0) {
            return Config.imageScaleType;
        }
        return null;
    }

    /* renamed from: ۠ۦۨ۠, reason: not valid java name and contains not printable characters */
    public static String m1171(String str) {
        String m1133 = C0797.m1133();
        String m11332 = C0797.m1133();
        for (int i11 = 0; i11 < 15; i11++) {
            m1133 = C0797.m1136(FancyBypassed.m1107(FancyBypassed.m1107(new StringBuffer(), m1133), m1182(i11)));
            m11332 = C0797.m1136(m1181(FancyBypassed.m1107(new StringBuffer(), m11332), ((int) (m1172() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(FancyBypassed.m1106(str) / 2);
        for (int i12 = 0; i12 < FancyBypassed.m1106(str); i12 += 2) {
            C0798.m1144(byteArrayOutputStream, (C0797.m1135(m1133, m1169(str, i12)) << 4) | C0797.m1135(m1133, m1169(str, i12 + 1)));
        }
        byte[] m1175 = m1175(byteArrayOutputStream);
        int length = m1175.length;
        int m1106 = FancyBypassed.m1106(m11332);
        while (length > 0) {
            m1175[-1] = (byte) (m1175[-1] ^ m1169(m11332, (-1) % m1106));
        }
        for (int i13 = 0; i13 < m1175.length; i13 = FancyBypassed.m1106(C0797.m1133()) + 1) {
        }
        return new String(m1175);
    }

    /* renamed from: ۡۨۧۧ, reason: not valid java name and contains not printable characters */
    public static double m1172() {
        if (SigninBypassed.m1124() > 0) {
            return Math.random();
        }
        return 0.0d;
    }

    /* renamed from: ۡۨۨۦ, reason: not valid java name and contains not printable characters */
    public static void m1173(Object obj, int i11, int i12, int i13) {
        if (C0797.m1131() >= 0) {
            ((Toast) obj).setGravity(i11, i12, i13);
        }
    }

    /* renamed from: ۣۢۡۡ, reason: not valid java name and contains not printable characters */
    public static InputStream m1174(Object obj, Object obj2) {
        if (FancyBypassed.m1112() >= 0) {
            return ((AssetManager) obj).open((String) obj2);
        }
        return null;
    }

    /* renamed from: ۣۤۧ, reason: not valid java name and contains not printable characters */
    public static byte[] m1175(Object obj) {
        if (C0798.m1142() >= 0) {
            return ((ByteArrayOutputStream) obj).toByteArray();
        }
        return null;
    }

    /* renamed from: ۤۤۡۧ, reason: not valid java name and contains not printable characters */
    public static void m1176(Object obj, Object obj2) {
        if (SigninBypassed.m1124() >= 0) {
            ((TextView) obj).setBackground((Drawable) obj2);
        }
    }

    /* renamed from: ۥۢۢ۠, reason: contains not printable characters */
    public static void m1177(Object obj, Object obj2, int i11) {
        if (SigninBypassed.m1124() >= 0) {
            ((TextView) obj).setTypeface((Typeface) obj2, i11);
        }
    }

    /* renamed from: ۥۣۢۥ, reason: contains not printable characters */
    public static int m1178() {
        if (C0797.m1131() > 0) {
            return Config.imageHeight;
        }
        return 0;
    }

    /* renamed from: ۥۣۨۡ, reason: contains not printable characters */
    public static Typeface m1179(Object obj) {
        if (SigninBypassed.m1124() > 0) {
            return ((TextView) obj).getTypeface();
        }
        return null;
    }

    /* renamed from: ۥۨۦۥ, reason: contains not printable characters */
    public static boolean m1180() {
        if (C0798.m1142() >= 0) {
            return Config.isItalic;
        }
        return false;
    }

    /* renamed from: ۧ۠ۢ۟, reason: not valid java name and contains not printable characters */
    public static StringBuffer m1181(Object obj, int i11) {
        if (FancyBypassed.m1112() >= 0) {
            return ((StringBuffer) obj).append(i11);
        }
        return null;
    }

    /* renamed from: ۧ۠ۦ۟, reason: not valid java name and contains not printable characters */
    public static String m1182(int i11) {
        if (C0798.m1142() >= 0) {
            return Integer.toHexString(i11);
        }
        return null;
    }

    /* renamed from: ۨۢ۠ۨ, reason: not valid java name and contains not printable characters */
    public static String m1183(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
