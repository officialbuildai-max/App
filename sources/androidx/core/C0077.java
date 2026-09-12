package androidx.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.appcompat.C0067;
import androidx.core.appcompat.C0068;
import androidx.core.appcompat.thg;
import androidx.core.appcompat.wty;
import androidx.core.fragmentapp.C0070;
import androidx.core.fragmentapp.C0071;
import androidx.core.fragmentapp.kc;
import java.io.ByteArrayOutputStream;

/* renamed from: androidx.core.۟ۥۣۡ۟, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0077 {

    /* renamed from: ۟ۧۤۢۧ, reason: collision with root package name */
    public static boolean f8596 = true;

    /* renamed from: ۟۠ۤۧۦ, reason: not valid java name and contains not printable characters */
    public static void m351(Object obj, Object obj2) {
        if (m370() >= 0) {
            ((Button) obj).setTypeface((Typeface) obj2);
        }
    }

    /* renamed from: ۟۠ۧۦۡ, reason: not valid java name and contains not printable characters */
    public static WindowManager.LayoutParams m352(Object obj) {
        if (C0070.m297() < 0) {
            return ((Window) obj).getAttributes();
        }
        return null;
    }

    /* renamed from: ۟ۡۢۤۢ, reason: not valid java name and contains not printable characters */
    public static double m353() {
        if (C0068.m249() < 0) {
            return Math.random();
        }
        return 0.0d;
    }

    /* renamed from: ۟ۡۨ۟ۥ, reason: not valid java name and contains not printable characters */
    public static void m354(Object obj, int i11) {
        if (C0070.m297() <= 0) {
            ((LinearLayout) obj).setGravity(i11);
        }
    }

    /* renamed from: ۟ۢۥۥۣ, reason: not valid java name and contains not printable characters */
    public static AlertDialog m355(Object obj) {
        if (m370() >= 0) {
            return ((AlertDialog.Builder) obj).create();
        }
        return null;
    }

    /* renamed from: ۟ۢۧۦ۠, reason: not valid java name and contains not printable characters */
    public static int m356() {
        if (C0071.m301() <= 0) {
            return thg.getTitlePadding();
        }
        return 0;
    }

    /* renamed from: ۣ۟ۢۨ۟, reason: not valid java name and contains not printable characters */
    public static Activity m357(Object obj) {
        if (m370() > 0) {
            return ((yke) obj).getActivity();
        }
        return null;
    }

    /* renamed from: ۣ۟۟ۦۧ, reason: not valid java name and contains not printable characters */
    public static String m358() {
        if (C0071.m301() < 0) {
            return wty.getSwitchTextColor();
        }
        return null;
    }

    /* renamed from: ۣ۟۠ۦۦ, reason: not valid java name and contains not printable characters */
    public static int m359() {
        if (C0068.m249() <= 0) {
            return thg.getSwitchCornerRadius();
        }
        return 0;
    }

    /* renamed from: ۣ۟ۡۢ, reason: not valid java name and contains not printable characters */
    public static void m360(Object obj, Object obj2) {
        if (C0068.m249() < 0) {
            ((LinearLayout) obj).setLayoutParams((ViewGroup.LayoutParams) obj2);
        }
    }

    /* renamed from: ۣۣ۟ۤۢ, reason: not valid java name and contains not printable characters */
    public static String m361() {
        if (C0068.m249() <= 0) {
            return wty.getDialogBgTopColor();
        }
        return null;
    }

    /* renamed from: ۟ۥۤۦۨ, reason: not valid java name and contains not printable characters */
    public static int m362(Object obj, Object obj2) {
        if (m370() >= 0) {
            return ((WindowManager.LayoutParams) obj).copyFrom((WindowManager.LayoutParams) obj2);
        }
        return 0;
    }

    /* renamed from: ۣ۟ۧۧۦ, reason: not valid java name and contains not printable characters */
    public static Bitmap m363(Object obj, int i11, int i12) {
        if (C0071.m301() <= 0) {
            return BitmapFactory.decodeByteArray((byte[]) obj, i11, i12);
        }
        return null;
    }

    /* renamed from: ۟ۧۥۤۧ, reason: not valid java name and contains not printable characters */
    public static void m364(Object obj, Object obj2) {
        if (C0068.m249() < 0) {
            ((View) obj).setLayoutParams((ViewGroup.LayoutParams) obj2);
        }
    }

    /* renamed from: ۟ۨۥۧ, reason: not valid java name and contains not printable characters */
    public static void m365(Object obj, Object obj2) {
        if (m370() >= 0) {
            ((TextView) obj).setText((CharSequence) obj2);
        }
    }

    /* renamed from: ۠ۢۢۤ, reason: not valid java name and contains not printable characters */
    public static void m366(Object obj, int i11, Object obj2) {
        if (C0070.m297() < 0) {
            ((Drawable) obj).setColorFilter(i11, (PorterDuff.Mode) obj2);
        }
    }

    /* renamed from: ۡ۟۟ۥ, reason: not valid java name and contains not printable characters */
    public static String m367(String str) {
        String m241 = C0067.m241();
        String m2412 = C0067.m241();
        for (int i11 = 0; i11 < 15; i11++) {
            m241 = C0068.m250(C0071.m308(C0071.m308(new StringBuffer(), m241), C0067.m221(i11)));
            m2412 = C0068.m250(C0067.m228(C0071.m308(new StringBuffer(), m2412), ((int) (m353() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(m375(str) / 2);
        for (int i12 = 0; i12 < m375(str); i12 += 2) {
            m385(byteArrayOutputStream, (C0067.m236(m241, C0068.m292(str, i12)) << 4) | C0067.m236(m241, C0068.m292(str, i12 + 1)));
        }
        byte[] m231 = C0067.m231(byteArrayOutputStream);
        int length = m231.length;
        int m375 = m375(m2412);
        while (length > 0) {
            m231[-1] = (byte) (m231[-1] ^ C0068.m292(m2412, (-1) % m375));
        }
        for (int i13 = 0; i13 < m231.length; i13 = m375(C0067.m241()) + 1) {
        }
        return new String(m231);
    }

    /* renamed from: ۡ۠ۧ۠, reason: not valid java name and contains not printable characters */
    public static void m368(Object obj, Object obj2) {
        if (C0071.m301() <= 0) {
            ((TextView) obj).setLayoutParams((ViewGroup.LayoutParams) obj2);
        }
    }

    /* renamed from: ۡۦۢۧ, reason: not valid java name and contains not printable characters */
    public static int m369() {
        if (C0070.m297() < 0) {
            return thg.getTitleTextSize();
        }
        return 0;
    }

    /* renamed from: ۡۦۦۦ, reason: not valid java name and contains not printable characters */
    public static int m370() {
        return 1752685 ^ C0068.m288((Object) "ۥۥ۟");
    }

    /* renamed from: ۣۢ۟, reason: not valid java name and contains not printable characters */
    public static void m371(Object obj) {
        if (C0071.m301() < 0) {
            ((SharedPreferences.Editor) obj).apply();
        }
    }

    /* renamed from: ۣۣۢۨ, reason: not valid java name and contains not printable characters */
    public static void m372(Object obj, int i11, float f11) {
        if (m370() > 0) {
            ((TextView) obj).setTextSize(i11, f11);
        }
    }

    /* renamed from: ۢۤ۟ۤ, reason: not valid java name and contains not printable characters */
    public static int m373() {
        if (C0070.m297() <= 0) {
            return thg.getMessagePadding();
        }
        return 0;
    }

    /* renamed from: ۢۥۣۣ, reason: not valid java name and contains not printable characters */
    public static int m374() {
        if (C0071.m301() < 0) {
            return thg.getMessageTextSize();
        }
        return 0;
    }

    /* renamed from: ۣ۟۟ۥ, reason: not valid java name and contains not printable characters */
    public static int m375(Object obj) {
        if (m370() >= 0) {
            return ((String) obj).length();
        }
        return 0;
    }

    /* renamed from: ۤ۠۠ۦ, reason: not valid java name and contains not printable characters */
    public static void m376(Object obj, boolean z10) {
        if (m370() > 0) {
            ((Paint) obj).setAntiAlias(z10);
        }
    }

    /* renamed from: ۤۡۥۦ, reason: not valid java name and contains not printable characters */
    public static void m377(Object obj, Object obj2, Object obj3) {
        if (C0068.m249() <= 0) {
            ((yke) obj).show((FragmentManager) obj2, (String) obj3);
        }
    }

    /* renamed from: ۤۦۨۧ, reason: not valid java name and contains not printable characters */
    public static String m378() {
        if (C0070.m297() < 0) {
            return kc.cdy();
        }
        return null;
    }

    /* renamed from: ۤۧۧۤ, reason: not valid java name and contains not printable characters */
    public static Paint.Style m379() {
        if (C0068.m249() <= 0) {
            return Paint.Style.STROKE;
        }
        return null;
    }

    /* renamed from: ۥ۟ۤۦ, reason: contains not printable characters */
    public static void m380(Object obj) {
        if (C0068.m249() < 0) {
            ((Exception) obj).printStackTrace();
        }
    }

    /* renamed from: ۥ۟ۧۧ, reason: contains not printable characters */
    public static void m381(Object obj, int i11) {
        if (C0070.m297() < 0) {
            ((Button) obj).setTextColor(i11);
        }
    }

    /* renamed from: ۥۢۧۤ, reason: contains not printable characters */
    public static PorterDuff.Mode m382() {
        if (m370() >= 0) {
            return PorterDuff.Mode.SRC_IN;
        }
        return null;
    }

    /* renamed from: ۥۤۥۥ, reason: contains not printable characters */
    public static String m383() {
        if (C0071.m301() < 0) {
            return wty.getIconStrokeColor();
        }
        return null;
    }

    /* renamed from: ۦۦۣۢ, reason: contains not printable characters */
    public static Resources m384(Object obj) {
        if (m370() > 0) {
            return ((yke) obj).getResources();
        }
        return null;
    }

    /* renamed from: ۦۧ, reason: contains not printable characters */
    public static void m385(Object obj, int i11) {
        if (C0071.m301() < 0) {
            ((ByteArrayOutputStream) obj).write(i11);
        }
    }

    /* renamed from: ۦۨۡ۠, reason: contains not printable characters */
    public static String m386() {
        if (C0071.m301() < 0) {
            return wty.getButtonBgTopColor();
        }
        return null;
    }

    /* renamed from: ۧۤۦۤ, reason: not valid java name and contains not printable characters */
    public static int m387() {
        if (C0071.m301() < 0) {
            return thg.getStrokeSize();
        }
        return 0;
    }

    /* renamed from: ۧۨ۟ۧ, reason: not valid java name and contains not printable characters */
    public static Typeface m388(Object obj, int i11) {
        if (C0068.m249() <= 0) {
            return Typeface.create((String) obj, i11);
        }
        return null;
    }

    /* renamed from: ۧۨۡ۠, reason: not valid java name and contains not printable characters */
    public static int m389() {
        if (m370() >= 0) {
            return thg.getPadding();
        }
        return 0;
    }

    /* renamed from: ۟۟ۡۦۨ, reason: not valid java name and contains not printable characters */
    public static String m350(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
