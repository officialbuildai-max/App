package androidx.core.fragmentapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.core.C0077;
import androidx.core.appcompat.C0067;
import androidx.core.appcompat.C0068;
import androidx.core.appcompat.thg;
import androidx.core.appcompat.wty;
import androidx.core.yke;
import java.io.ByteArrayOutputStream;

/* renamed from: androidx.core.fragmentapp.۟ۥۥ۠, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0071 {

    /* renamed from: ۟ۡ۟ۦۡ, reason: collision with root package name */
    public static int f8220 = -99;

    /* renamed from: ۟۟ۢۤ, reason: not valid java name and contains not printable characters */
    public static SharedPreferences m298(Object obj, Object obj2, int i11) {
        if (m301() < 0) {
            return ((Activity) obj).getSharedPreferences((String) obj2, i11);
        }
        return null;
    }

    /* renamed from: ۟۠۟ۨۨ, reason: not valid java name and contains not printable characters */
    public static String m299() {
        if (C0077.m370() > 0) {
            return wty.getTitleBgRightColor();
        }
        return null;
    }

    /* renamed from: ۣ۟ۡ۟ۧ, reason: not valid java name and contains not printable characters */
    public static void m300(Object obj) {
        if (C0070.m297() <= 0) {
            ((yke) obj).dismiss();
        }
    }

    /* renamed from: ۟ۡۡۨۧ, reason: not valid java name and contains not printable characters */
    public static int m301() {
        return (-1749631) ^ C0068.m288((Object) "ۢ۟ۧ");
    }

    /* renamed from: ۟ۢ۠ۧ۠, reason: not valid java name and contains not printable characters */
    public static int m302(Object obj) {
        if (C0068.m249() < 0) {
            return ((Bitmap) obj).getWidth();
        }
        return 0;
    }

    /* renamed from: ۟ۢۢۨ۠, reason: not valid java name and contains not printable characters */
    public static String m303(String str) {
        String m241 = C0067.m241();
        String m2412 = C0067.m241();
        for (int i11 = 0; i11 < 15; i11++) {
            m241 = C0068.m250(m308(m308(new StringBuffer(), m241), C0067.m221(i11)));
            m2412 = C0068.m250(C0067.m228(m308(new StringBuffer(), m2412), ((int) (C0077.m353() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(C0077.m375(str) / 2);
        for (int i12 = 0; i12 < C0077.m375(str); i12 += 2) {
            C0077.m385(byteArrayOutputStream, (C0067.m236(m241, C0068.m292(str, i12)) << 4) | C0067.m236(m241, C0068.m292(str, i12 + 1)));
        }
        byte[] m231 = C0067.m231(byteArrayOutputStream);
        int length = m231.length;
        int m375 = C0077.m375(m2412);
        for (int i13 = 0; i13 < length; i13++) {
            m231[i13] = (byte) (m231[i13] ^ C0068.m292(m2412, i13 % m375));
        }
        for (int i14 = 0; i14 < m231.length; i14 = C0077.m375(C0067.m241()) + 1) {
        }
        return new String(m231);
    }

    /* renamed from: ۣ۟ۢۧ۟, reason: not valid java name and contains not printable characters */
    public static void m304(Object obj, Object obj2) {
        if (C0070.m297() < 0) {
            ((LinearLayout) obj).addView((View) obj2);
        }
    }

    /* renamed from: ۣۣ۟ۧۤ, reason: not valid java name and contains not printable characters */
    public static void m305(Object obj, Object obj2) {
        if (m301() < 0) {
            ((Window) obj).setAttributes((WindowManager.LayoutParams) obj2);
        }
    }

    /* renamed from: ۟ۤۥۣۡ, reason: not valid java name and contains not printable characters */
    public static byte[] m307(Object obj, int i11) {
        if (C0070.m297() < 0) {
            return Base64.decode((String) obj, i11);
        }
        return null;
    }

    /* renamed from: ۟ۥ۟ۦ۠, reason: not valid java name and contains not printable characters */
    public static StringBuffer m308(Object obj, Object obj2) {
        if (C0077.m370() >= 0) {
            return ((StringBuffer) obj).append((String) obj2);
        }
        return null;
    }

    /* renamed from: ۟ۥۡۨ, reason: not valid java name and contains not printable characters */
    public static void m309(Object obj, Object obj2) {
        if (C0068.m249() < 0) {
            ((TextView) obj).setBackground((Drawable) obj2);
        }
    }

    /* renamed from: ۟ۦۣۡ۠, reason: not valid java name and contains not printable characters */
    public static int m310() {
        if (C0070.m297() < 0) {
            return thg.getSwitchTextSize();
        }
        return 0;
    }

    /* renamed from: ۟ۦۨۡ۠, reason: not valid java name and contains not printable characters */
    public static PorterDuff.Mode m311() {
        if (m301() < 0) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    /* renamed from: ۣ۟ۧۡۨ, reason: not valid java name and contains not printable characters */
    public static void m312(Object obj, Object obj2) {
        if (C0068.m249() <= 0) {
            ((Window) obj).setBackgroundDrawable((Drawable) obj2);
        }
    }

    /* renamed from: ۠۠ۧ۠, reason: not valid java name and contains not printable characters */
    public static void m313(Object obj, Object obj2, Object obj3) {
        if (C0068.m249() < 0) {
            ((Canvas) obj).drawOval((RectF) obj2, (Paint) obj3);
        }
    }

    /* renamed from: ۠ۡۢۦ, reason: not valid java name and contains not printable characters */
    public static void m314(Object obj, Object obj2) {
        if (C0077.m370() > 0) {
            ((yke) obj).startActivity((Intent) obj2);
        }
    }

    /* renamed from: ۠ۦۣۢ, reason: not valid java name and contains not printable characters */
    public static void m315(Object obj, float f11) {
        if (C0070.m297() < 0) {
            ((GradientDrawable) obj).setCornerRadius(f11);
        }
    }

    /* renamed from: ۡۢۢۨ, reason: not valid java name and contains not printable characters */
    public static int m316(Object obj) {
        if (m301() < 0) {
            return ((KeyEvent) obj).getAction();
        }
        return 0;
    }

    /* renamed from: ۢۥۡ, reason: not valid java name and contains not printable characters */
    public static void m317(Object obj, Object obj2) {
        if (C0068.m249() < 0) {
            ((Switch) obj).setContentDescription((CharSequence) obj2);
        }
    }

    /* renamed from: ۢۦۣۢ, reason: not valid java name and contains not printable characters */
    public static void m318(Object obj, Object obj2) {
        if (C0068.m249() <= 0) {
            ((TextView) obj).setTypeface((Typeface) obj2);
        }
    }

    /* renamed from: ۢۨۦۥ, reason: not valid java name and contains not printable characters */
    public static int m319() {
        if (C0077.m370() >= 0) {
            return thg.getButtonTextSize();
        }
        return 0;
    }

    /* renamed from: ۣ۠ۡۡ, reason: not valid java name and contains not printable characters */
    public static String m320() {
        if (C0077.m370() >= 0) {
            return wty.getButtonBgBottomColor();
        }
        return null;
    }

    /* renamed from: ۣۣۢۢ, reason: not valid java name and contains not printable characters */
    public static void m321(Object obj, Object obj2) {
        if (C0077.m370() > 0) {
            ((Button) obj).setOnClickListener((View.OnClickListener) obj2);
        }
    }

    /* renamed from: ۣۤۡۢ, reason: not valid java name and contains not printable characters */
    public static void m322(Object obj, int i11) {
        if (m301() <= 0) {
            ((Paint) obj).setColor(i11);
        }
    }

    /* renamed from: ۣۤۡۤ, reason: not valid java name and contains not printable characters */
    public static Uri m323(Object obj) {
        if (C0077.m370() >= 0) {
            return Uri.parse((String) obj);
        }
        return null;
    }

    /* renamed from: ۣۤۦۢ, reason: not valid java name and contains not printable characters */
    public static String m324() {
        if (m301() <= 0) {
            return kc.ajk();
        }
        return null;
    }

    /* renamed from: ۤۨۤۨ, reason: not valid java name and contains not printable characters */
    public static void m325(Object obj, int i11, int i12, int i13, int i14) {
        if (C0070.m297() < 0) {
            ((LinearLayout) obj).setPadding(i11, i12, i13, i14);
        }
    }

    /* renamed from: ۥۥۣۢ, reason: contains not printable characters */
    public static void m326(Object obj, int i11, int i12) {
        if (C0077.m370() > 0) {
            ((GradientDrawable) obj).setStroke(i11, i12);
        }
    }

    /* renamed from: ۥۧۨۥ, reason: contains not printable characters */
    public static void m327(Object obj, int i11, int i12, int i13, int i14) {
        if (m301() <= 0) {
            ((TextView) obj).setPadding(i11, i12, i13, i14);
        }
    }

    /* renamed from: ۥۨۦۣ, reason: contains not printable characters */
    public static String m328() {
        if (C0070.m297() < 0) {
            return wty.getSwitchThumbColor();
        }
        return null;
    }

    /* renamed from: ۦۣۡۨ, reason: contains not printable characters */
    public static Drawable m329(Object obj) {
        if (C0070.m297() < 0) {
            return ((Switch) obj).getThumbDrawable();
        }
        return null;
    }

    /* renamed from: ۧۢۤۡ, reason: not valid java name and contains not printable characters */
    public static String m330() {
        if (C0068.m249() <= 0) {
            return wty.getTitleBoxBgColor();
        }
        return null;
    }

    /* renamed from: ۧۢۦۥ, reason: not valid java name and contains not printable characters */
    public static String m331() {
        if (C0068.m249() < 0) {
            return kc.djk();
        }
        return null;
    }

    /* renamed from: ۣۣۧۢ, reason: not valid java name and contains not printable characters */
    public static String m332() {
        if (C0068.m249() < 0) {
            return wty.getSwitchCheckedThumbColor();
        }
        return null;
    }

    /* renamed from: ۣۣۧۡ, reason: not valid java name and contains not printable characters */
    public static void m333(Object obj, Object obj2) {
        if (m301() <= 0) {
            ((Switch) obj).setTrackDrawable((Drawable) obj2);
        }
    }

    /* renamed from: ۧۤۤۤ, reason: not valid java name and contains not printable characters */
    public static Bitmap.Config m334() {
        if (C0070.m297() < 0) {
            return Bitmap.Config.ARGB_8888;
        }
        return null;
    }

    /* renamed from: ۨۨۤۥ, reason: not valid java name and contains not printable characters */
    public static int m335(int i11, int i12) {
        if (C0077.m370() > 0) {
            return Math.min(i11, i12);
        }
        return 0;
    }

    /* renamed from: ۣ۟ۤ۟, reason: not valid java name and contains not printable characters */
    public static String m306(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
