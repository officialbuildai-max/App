package com.bytedance.adsdk.ugeno.Jcg;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.transsion.gslb.Utils;

/* loaded from: classes2.dex */
public class Sj {

    /* renamed from: com.bytedance.adsdk.ugeno.Jcg.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0207Sj {
        public GradientDrawable.Orientation Sj;
        public float[] TKC;
        public int[] sP;
    }

    public static GradientDrawable.Orientation EjP(String str) {
        try {
            int parseInt = str.contains("deg") ? Integer.parseInt(str.substring(0, str.length() - 3).trim()) : Integer.parseInt(str);
            return parseInt == 90 ? GradientDrawable.Orientation.LEFT_RIGHT : parseInt == 180 ? GradientDrawable.Orientation.TOP_BOTTOM : parseInt == 270 ? GradientDrawable.Orientation.RIGHT_LEFT : parseInt == 135 ? GradientDrawable.Orientation.TL_BR : parseInt == 45 ? GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    public static int Sj(int i11, int i12) {
        if (i12 < 0 || i12 > 255) {
            Log.e("ColorUtils", "alpha must be between 0 and 255. ");
            i12 = 255;
        }
        return (i11 & 16777215) | (i12 << 24);
    }

    public static int Sj(String str) {
        return Sj(str, ViewCompat.MEASURED_STATE_MASK);
    }

    public static int Sj(String str, char c11) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            if (str.charAt(i12) == c11) {
                i11++;
            }
        }
        return i11;
    }

    public static int Sj(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        if (str.equals(TmcStartParams.KEY_TRANSPARENT)) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 4) {
            StringBuilder sb2 = new StringBuilder(Utils.SEPARATOR);
            char[] charArray = str.toCharArray();
            for (int i12 = 1; i12 < charArray.length; i12++) {
                sb2.append(charArray[i12]);
                sb2.append(charArray[i12]);
            }
            return Color.parseColor(sb2.toString());
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (!str.startsWith("rgba")) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (split == null || split.length != 4) {
            return i11;
        }
        return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2]));
    }

    public static boolean TKC(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("linear-gradient");
    }

    public static C0207Sj sP(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String substring = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")"));
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            int Sj = Sj(substring, '%');
            int indexOf = substring.indexOf(",");
            String substring2 = substring.substring(0, indexOf);
            C0207Sj c0207Sj = new C0207Sj();
            c0207Sj.Sj = EjP(substring2);
            String substring3 = substring.substring(indexOf + 1);
            int[] iArr = new int[Sj];
            float[] fArr = new float[Sj];
            for (int i11 = 0; i11 < Sj; i11++) {
                int indexOf2 = substring3.indexOf("%");
                String trim = substring3.substring(0, indexOf2 + 1).trim();
                int indexOf3 = (trim.contains("rgba") ? trim.indexOf(")") : trim.indexOf(" ")) + 1;
                iArr[i11] = Sj(trim.substring(0, indexOf3).trim());
                fArr[i11] = TKC.Sj(trim.substring(indexOf3, trim.indexOf("%")).trim(), 0.0f) / 100.0f;
                int i12 = indexOf2 + 2;
                if (substring3.length() <= i12) {
                    break;
                }
                substring3 = substring3.substring(i12);
            }
            if (Sj < 2) {
                return null;
            }
            c0207Sj.sP = iArr;
            c0207Sj.TKC = fArr;
            return c0207Sj;
        } catch (Throwable unused) {
            return null;
        }
    }
}
