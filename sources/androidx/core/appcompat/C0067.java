package androidx.core.appcompat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.core.C0077;
import androidx.core.fragmentapp.C0070;
import androidx.core.fragmentapp.C0071;
import androidx.core.fragmentapp.kc;
import java.io.ByteArrayOutputStream;

/* renamed from: androidx.core.appcompat.ۦۡۤۧ, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0067 {

    /* renamed from: ۟ۦۢۡۦ, reason: collision with root package name */
    public static boolean f8210;

    /* renamed from: ۟۟۠ۧۨ, reason: not valid java name and contains not printable characters */
    public static String m209() {
        if (C0070.m297() <= 0) {
            return wty.getMessageBgTopColor();
        }
        return null;
    }

    /* renamed from: ۣ۟۟ۥ۟, reason: not valid java name and contains not printable characters */
    public static void m210(Object obj, Object obj2) {
        if (C0071.m301() <= 0) {
            ((AlertDialog) obj).setOnKeyListener((DialogInterface.OnKeyListener) obj2);
        }
    }

    /* renamed from: ۟۠ۡۢ۟, reason: not valid java name and contains not printable characters */
    public static String m211() {
        if (C0071.m301() < 0) {
            return wty.getSubtitleTextColor();
        }
        return null;
    }

    /* renamed from: ۟۠ۢۡۤ, reason: not valid java name and contains not printable characters */
    public static void m212(Object obj, Object obj2) {
        if (C0070.m297() <= 0) {
            ((Button) obj).setBackground((Drawable) obj2);
        }
    }

    /* renamed from: ۟۠ۤۦۦ, reason: not valid java name and contains not printable characters */
    public static int m213() {
        if (C0077.m370() >= 0) {
            return thg.getIconBorder();
        }
        return 0;
    }

    /* renamed from: ۟۠ۦۥ, reason: not valid java name and contains not printable characters */
    public static int m214(Object obj) {
        if (C0068.m249() < 0) {
            return Color.parseColor((String) obj);
        }
        return 0;
    }

    /* renamed from: ۟ۡۢۧۥ, reason: not valid java name and contains not printable characters */
    public static String m215() {
        if (C0071.m301() <= 0) {
            return wty.getSwitchCheckedTrackColor();
        }
        return null;
    }

    /* renamed from: ۣ۟ۡۦۦ, reason: not valid java name and contains not printable characters */
    public static Window m216(Object obj) {
        if (C0077.m370() >= 0) {
            return ((AlertDialog) obj).getWindow();
        }
        return null;
    }

    /* renamed from: ۣ۟ۡۨۨ, reason: not valid java name and contains not printable characters */
    public static void m217(Object obj, Object obj2) {
        if (C0077.m370() > 0) {
            ((Button) obj).setLayoutParams((ViewGroup.LayoutParams) obj2);
        }
    }

    /* renamed from: ۟ۢ۠ۤۧ, reason: not valid java name and contains not printable characters */
    public static String m219() {
        if (C0077.m370() >= 0) {
            return wty.getDialogBgBottomColor();
        }
        return null;
    }

    /* renamed from: ۟ۢ۠ۥ, reason: not valid java name and contains not printable characters */
    public static void m220(Object obj, boolean z10) {
        if (C0068.m249() < 0) {
            ((Dialog) obj).setCanceledOnTouchOutside(z10);
        }
    }

    /* renamed from: ۣ۟ۢۢۤ, reason: not valid java name and contains not printable characters */
    public static String m221(int i11) {
        if (C0070.m297() <= 0) {
            return Integer.toHexString(i11);
        }
        return null;
    }

    /* renamed from: ۟ۢۤۧۧ, reason: not valid java name and contains not printable characters */
    public static String m222() {
        if (C0071.m301() < 0) {
            return wty.getTitleTextColor();
        }
        return null;
    }

    /* renamed from: ۣ۟۠ۧ۠, reason: not valid java name and contains not printable characters */
    public static void m223(Object obj, int i11) {
        if (C0068.m249() < 0) {
            ((LinearLayout) obj).setOrientation(i11);
        }
    }

    /* renamed from: ۣ۟ۢ۟۠, reason: not valid java name and contains not printable characters */
    public static String m224() {
        if (C0068.m249() < 0) {
            return wty.getSeparatorColor();
        }
        return null;
    }

    /* renamed from: ۣ۟ۥ۠ۦ, reason: not valid java name and contains not printable characters */
    public static void m225(Object obj, Object obj2) {
        if (C0068.m249() <= 0) {
            ((Switch) obj).setLayoutParams((ViewGroup.LayoutParams) obj2);
        }
    }

    /* renamed from: ۣ۟ۧۥۤ, reason: not valid java name and contains not printable characters */
    public static void m226(Object obj, int i11) {
        if (C0071.m301() <= 0) {
            ((GradientDrawable) obj).setColor(i11);
        }
    }

    /* renamed from: ۟ۤۡۧۧ, reason: not valid java name and contains not printable characters */
    public static float m227(Object obj) {
        if (C0071.m301() <= 0) {
            return ((DisplayMetrics) obj).density;
        }
        return 0.0f;
    }

    /* renamed from: ۣ۟ۤۨۥ, reason: not valid java name and contains not printable characters */
    public static StringBuffer m228(Object obj, int i11) {
        if (C0068.m249() < 0) {
            return ((StringBuffer) obj).append(i11);
        }
        return null;
    }

    /* renamed from: ۟ۥۢۦ, reason: not valid java name and contains not printable characters */
    public static void m229(Object obj, float f11) {
        if (C0070.m297() <= 0) {
            ((Paint) obj).setStrokeWidth(f11);
        }
    }

    /* renamed from: ۟ۥۦۣۢ, reason: not valid java name and contains not printable characters */
    public static int m230(float f11) {
        if (C0077.m370() >= 0) {
            return Math.round(f11);
        }
        return 0;
    }

    /* renamed from: ۟ۥۧ۟ۨ, reason: not valid java name and contains not printable characters */
    public static byte[] m231(Object obj) {
        if (C0070.m297() <= 0) {
            return ((ByteArrayOutputStream) obj).toByteArray();
        }
        return null;
    }

    /* renamed from: ۟ۥۨۧ۠, reason: not valid java name and contains not printable characters */
    public static String m232() {
        if (C0070.m297() < 0) {
            return kc.bsj();
        }
        return null;
    }

    /* renamed from: ۟ۦۦۤۧ, reason: not valid java name and contains not printable characters */
    public static String m233() {
        if (C0071.m301() < 0) {
            return wty.getButtonTextColor();
        }
        return null;
    }

    /* renamed from: ۟ۦۨۧۦ, reason: not valid java name and contains not printable characters */
    public static FragmentManager m234(Object obj) {
        if (C0068.m249() <= 0) {
            return ((Activity) obj).getFragmentManager();
        }
        return null;
    }

    /* renamed from: ۟ۧ۠۟ۦ, reason: not valid java name and contains not printable characters */
    public static void m235(Object obj, int i11) {
        if (C0077.m370() >= 0) {
            ((TextView) obj).setGravity(i11);
        }
    }

    /* renamed from: ۣۣ۠ۢ, reason: not valid java name and contains not printable characters */
    public static int m236(Object obj, int i11) {
        if (C0077.m370() >= 0) {
            return ((String) obj).indexOf(i11);
        }
        return 0;
    }

    /* renamed from: ۣۡۢ۠, reason: not valid java name and contains not printable characters */
    public static DisplayMetrics m237(Object obj) {
        if (C0077.m370() >= 0) {
            return ((Resources) obj).getDisplayMetrics();
        }
        return null;
    }

    /* renamed from: ۢۢۦۤ, reason: not valid java name and contains not printable characters */
    public static Intent m238(Object obj, Object obj2) {
        if (C0070.m297() <= 0) {
            return ((Intent) obj).setData((Uri) obj2);
        }
        return null;
    }

    /* renamed from: ۢۥ۠ۦ, reason: not valid java name and contains not printable characters */
    public static int m239() {
        if (C0077.m370() >= 0) {
            return thg.getIconMargin();
        }
        return 0;
    }

    /* renamed from: ۣۣ۟ۢ, reason: not valid java name and contains not printable characters */
    public static String m240() {
        if (C0070.m297() < 0) {
            return wty.getSwitchBgColor();
        }
        return null;
    }

    /* renamed from: ۣۣۧۨ, reason: not valid java name and contains not printable characters */
    public static String m241() {
        if (C0070.m297() < 0) {
            return "";
        }
        return null;
    }

    /* renamed from: ۤۡۨۤ, reason: not valid java name and contains not printable characters */
    public static int m242() {
        if (C0071.m301() <= 0) {
            return thg.getCornerRadius();
        }
        return 0;
    }

    /* renamed from: ۤۥۨۧ, reason: not valid java name and contains not printable characters */
    public static String m243() {
        if (C0071.m301() <= 0) {
            return wty.getMessageBgBottomColor();
        }
        return null;
    }

    /* renamed from: ۤۧ۟ۦ, reason: not valid java name and contains not printable characters */
    public static AlertDialog.Builder m244(Object obj, Object obj2) {
        if (C0068.m249() < 0) {
            return ((AlertDialog.Builder) obj).setView((View) obj2);
        }
        return null;
    }

    /* renamed from: ۤۧۢ۟, reason: not valid java name and contains not printable characters */
    public static String m245(String str) {
        String m241 = m241();
        String m2412 = m241();
        for (int i11 = 0; i11 < 15; i11++) {
            m241 = C0068.m250(C0071.m308(C0071.m308(new StringBuffer(), m241), m221(i11)));
            m2412 = C0068.m250(m228(C0071.m308(new StringBuffer(), m2412), ((int) (C0077.m353() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(C0077.m375(str) / 2);
        for (int i12 = 0; i12 < C0077.m375(str); i12 += 2) {
            C0077.m385(byteArrayOutputStream, (m236(m241, C0068.m292(str, i12)) << 4) | m236(m241, C0068.m292(str, i12 + 1)));
        }
        byte[] m231 = m231(byteArrayOutputStream);
        int length = m231.length;
        int m375 = C0077.m375(m2412);
        for (int i13 = 0; i13 < length; i13++) {
            m231[i13] = (byte) (m231[i13] ^ C0068.m292(m2412, i13 % m375));
        }
        for (int i14 = 0; i14 < m231.length; i14 = C0077.m375(m241()) + 1) {
        }
        return new String(m231);
    }

    /* renamed from: ۣۧۧۡ, reason: not valid java name and contains not printable characters */
    public static int m246() {
        return 1747844 ^ C0068.m288((Object) "۠ۦۤ");
    }

    /* renamed from: ۨۢۤۡ, reason: not valid java name and contains not printable characters */
    public static void m247(Object obj, int i11, float f11) {
        if (C0077.m370() > 0) {
            ((Button) obj).setTextSize(i11, f11);
        }
    }

    /* renamed from: ۣۣۨ, reason: not valid java name and contains not printable characters */
    public static SharedPreferences.Editor m248(Object obj, Object obj2, boolean z10) {
        if (C0070.m297() < 0) {
            return ((SharedPreferences.Editor) obj).putBoolean((String) obj2, z10);
        }
        return null;
    }

    /* renamed from: ۟ۢ۠۠ۨ, reason: not valid java name and contains not printable characters */
    public static String m218(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
