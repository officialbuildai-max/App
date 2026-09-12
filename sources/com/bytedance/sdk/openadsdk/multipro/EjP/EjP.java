package com.bytedance.sdk.openadsdk.multipro.EjP;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.Sj;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.uA;

/* loaded from: classes3.dex */
public class EjP {
    public static int Sj(String str, String str2, int i11) {
        return Sj() ? i11 : com.bytedance.sdk.openadsdk.multipro.sP.TKC() ? Sj.Sj(sP(str), str2, i11) : Sj.Sj(dNu.Sj(), sP(str), str2, i11);
    }

    public static long Sj(String str, String str2, long j11) {
        return Sj() ? j11 : com.bytedance.sdk.openadsdk.multipro.sP.TKC() ? Sj.Sj(sP(str), str2, j11) : Sj.Sj(dNu.Sj(), sP(str), str2, j11);
    }

    public static void Sj(String str) {
        if (Sj()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            Sj.Sj(sP(str));
        } else {
            sP.sP(dNu.Sj(), sP(str));
        }
    }

    public static void Sj(String str, String str2) {
        if (Sj()) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
                Sj.sP(sP(str), str2);
            } else {
                sP.sP(dNu.Sj(), sP(str), str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void Sj(String str, String str2, Boolean bool) {
        if (Sj()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            Sj.Sj(sP(str), str2, bool);
        } else {
            Sj(sP(str), str2, bool);
        }
    }

    public static void Sj(String str, String str2, Integer num) {
        if (Sj()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            Sj.Sj(sP(str), str2, num);
        } else {
            Sj(sP(str), str2, num);
        }
    }

    public static void Sj(String str, String str2, Long l11) {
        if (Sj()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            Sj.Sj(sP(str), str2, l11);
        } else {
            Sj(sP(str), str2, l11);
        }
    }

    private static <T> void Sj(String str, String str2, T t11) {
        String Sj = Sj.Sj(str, str2);
        if (uA.Jcg(Sj)) {
            Sj.TKC sP = com.bytedance.sdk.component.Sj.Sj(dNu.Sj(), sP(Sj)).sP();
            sP.Sj(sP, str2, (Object) t11);
            sP.apply();
        } else {
            SharedPreferences Sj2 = sP.Sj(dNu.Sj(), sP(Sj));
            if (Sj2 == null) {
                return;
            }
            SharedPreferences.Editor edit = Sj2.edit();
            sP.Sj(edit, str2, t11);
            edit.apply();
        }
    }

    public static void Sj(String str, String str2, String str3) {
        if (Sj()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            Sj.Sj(sP(str), str2, str3);
        } else {
            Sj(sP(str), str2, str3);
        }
    }

    private static boolean Sj() {
        return dNu.Sj() == null;
    }

    public static boolean Sj(String str, String str2, boolean z10) {
        return Sj() ? z10 : com.bytedance.sdk.openadsdk.multipro.sP.TKC() ? Sj.Sj(sP(str), str2, z10) : Sj.Sj(dNu.Sj(), sP(str), str2, z10);
    }

    private static String sP(String str) {
        return TextUtils.isEmpty(str) ? "tt_sp" : str;
    }

    public static String sP(String str, String str2, String str3) {
        return Sj() ? str3 : com.bytedance.sdk.openadsdk.multipro.sP.TKC() ? Sj.sP(sP(str), str2, str3) : Sj.Sj(dNu.Sj(), sP(str), str2, str3);
    }
}
