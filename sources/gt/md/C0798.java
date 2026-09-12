package gt.md;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.ByteArrayOutputStream;

/* renamed from: gt.md.ۣ۟ۤۥۨ, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0798 {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f72short = {825, 1978};

    /* renamed from: ۟ۧ۟ۦۥ, reason: not valid java name and contains not printable characters */
    public static boolean f73;

    /* renamed from: ۟۟۠ۧۧ, reason: not valid java name and contains not printable characters */
    public static void m1139(Object obj, int i11) {
        if (SigninBypassed.m1124() >= 0) {
            ((Toast) obj).setDuration(i11);
        }
    }

    /* renamed from: ۣ۟۟ۨۥ, reason: not valid java name and contains not printable characters */
    public static boolean m1140(Object obj, Object obj2) {
        if (FancyBypassed.m1112() >= 0) {
            return ((String) obj).startsWith((String) obj2);
        }
        return false;
    }

    /* renamed from: ۟۟ۦۢۢ, reason: not valid java name and contains not printable characters */
    public static String m1141(Object obj, int i11) {
        if (m1142() >= 0) {
            return ((String) obj).substring(i11);
        }
        return null;
    }

    /* renamed from: ۟۠ۡۧ۟, reason: not valid java name and contains not printable characters */
    public static int m1142() {
        return 1746873 ^ C0797.m1125((Object) "ۣ۟ۤ");
    }

    /* renamed from: ۟ۡ۠۠۠, reason: not valid java name and contains not printable characters */
    public static String m1143() {
        if (SigninBypassed.m1124() > 0) {
            return Config.textColor;
        }
        return null;
    }

    /* renamed from: ۟ۡۨۧۤ, reason: not valid java name and contains not printable characters */
    public static void m1144(Object obj, int i11) {
        if (SigninBypassed.m1124() >= 0) {
            ((ByteArrayOutputStream) obj).write(i11);
        }
    }

    /* renamed from: ۟ۢۤۦۤ, reason: not valid java name and contains not printable characters */
    public static void m1145(Object obj, float f11) {
        if (m1142() >= 0) {
            ((TextView) obj).setTextSize(f11);
        }
    }

    /* renamed from: ۣ۟ۧۦۨ, reason: not valid java name and contains not printable characters */
    public static ImageView.ScaleType m1146() {
        if (SigninBypassed.m1124() >= 0) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        return null;
    }

    /* renamed from: ۟ۤ۟ۦۣ, reason: not valid java name and contains not printable characters */
    public static void m1147(Object obj, Object obj2) {
        if (C0797.m1131() >= 0) {
            ((Toast) obj).setView((View) obj2);
        }
    }

    /* renamed from: ۟ۥۨۢۦ, reason: not valid java name and contains not printable characters */
    public static String m1148() {
        if (SigninBypassed.m1124() >= 0) {
            return Config.image;
        }
        return null;
    }

    /* renamed from: ۟ۦۡۨۨ, reason: not valid java name and contains not printable characters */
    public static void m1149(Object obj, Object obj2) {
        if (m1142() >= 0) {
            ((ImageView) obj).setImageBitmap((Bitmap) obj2);
        }
    }

    /* renamed from: ۟ۧۢۥۧ, reason: not valid java name and contains not printable characters */
    public static String m1150(String str) {
        String m1133 = C0797.m1133();
        String m11332 = C0797.m1133();
        for (int i11 = 0; i11 < 15; i11++) {
            m1133 = C0797.m1136(FancyBypassed.m1107(FancyBypassed.m1107(new StringBuffer(), m1133), C0800.m1182(i11)));
            m11332 = C0797.m1136(C0800.m1181(FancyBypassed.m1107(new StringBuffer(), m11332), ((int) (C0800.m1172() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(FancyBypassed.m1106(str) / 2);
        for (int i12 = 0; i12 < FancyBypassed.m1106(str); i12 += 2) {
            m1144(byteArrayOutputStream, (C0797.m1135(m1133, C0800.m1169(str, i12)) << 4) | C0797.m1135(m1133, C0800.m1169(str, i12 + 1)));
        }
        byte[] m1175 = C0800.m1175(byteArrayOutputStream);
        String m1183 = C0800.m1183(m1151(), 0, 1, 856);
        while (FancyBypassed.m1106(m1183) > 0) {
            m1183 = C0797.m1133();
            if (FancyBypassed.m1106(m1183) == 0) {
                m1183 = FancyBypassed.m1110(m1151(), 1, 1, Sdk$SDKMetric.SDKMetricType.APP_TERM_DURING_AD_BEFORE_IMPRESSION_VALUE);
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

    /* renamed from: ۠ۡۥۧ, reason: not valid java name and contains not printable characters */
    public static short[] m1151() {
        if (SigninBypassed.m1124() > 0) {
            return f72short;
        }
        return null;
    }

    /* renamed from: ۢۤ۠۟, reason: not valid java name and contains not printable characters */
    public static void m1152(Object obj, int i11) {
        if (C0797.m1131() > 0) {
            ((LinearLayout) obj).setOrientation(i11);
        }
    }

    /* renamed from: ۥۣ۠, reason: contains not printable characters */
    public static AssetManager m1153(Object obj) {
        if (FancyBypassed.m1112() >= 0) {
            return ((Context) obj).getAssets();
        }
        return null;
    }

    /* renamed from: ۧۨۢۢ, reason: not valid java name and contains not printable characters */
    public static void m1154(Object obj, int i11) {
        if (SigninBypassed.m1124() >= 0) {
            ((GradientDrawable) obj).setColor(i11);
        }
    }

    /* renamed from: ۨ۟ۦ۠, reason: not valid java name and contains not printable characters */
    public static void m1155(Object obj, int i11, int i12, int i13, int i14) {
        if (m1142() >= 0) {
            ((TextView) obj).setPadding(i11, i12, i13, i14);
        }
    }

    /* renamed from: ۨۤۡ, reason: not valid java name and contains not printable characters */
    public static String m1156(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
