package com.bytedance.sdk.component.adexpress.dynamic.HiB;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.HiB.sP;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Ym {
    private static final Set<String> Sj = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", "close", "close-fill", "webview-close")));
    private static String sP;

    private static sP.TKC Sj(sP.TKC tkc, String str, String str2, String str3) {
        if (str.contains("union")) {
            tkc.Sj = 0.0f;
            tkc.sP = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = Sj(str);
            }
            if (!TextUtils.isEmpty(str3)) {
                return Sj(str3, str2);
            }
            tkc.Sj = 0.0f;
            tkc.sP = 0.0f;
        }
        return tkc;
    }

    public static sP.TKC Sj(String str, String str2) {
        return Sj(str, str2, false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(3:190|(1:193)|194)(2:219|(1:221)(5:222|196|(5:206|207|208|(3:210|(1:216)(1:213)|214)|217)|204|205))|195|196|(3:198|200|202)|206|207|208|(0)|217) */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0471 A[Catch: Exception -> 0x0482, TryCatch #6 {Exception -> 0x0482, blocks: (B:208:0x0466, B:210:0x0471, B:214:0x047b), top: B:207:0x0466 }] */
    /* JADX WARN: Type inference failed for: r10v21, types: [float, com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.bytedance.sdk.component.adexpress.dynamic.HiB.sP.TKC Sj(java.lang.String r22, java.lang.String r23, java.lang.String r24, boolean r25, boolean r26, int r27, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq r28, double r29, int r31, double r32, java.lang.String r34, com.bytedance.sdk.component.adexpress.sP.Fmk r35) {
        /*
            Method dump skipped, instructions count: 1334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.HiB.Ym.Sj(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq, double, int, double, java.lang.String, com.bytedance.sdk.component.adexpress.sP.Fmk):com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC");
    }

    public static sP.TKC Sj(String str, String str2, boolean z10) {
        sP.TKC tkc = new sP.TKC();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] Sj2 = Sj(str, (float) sP(str2), z10);
            tkc.Sj = Sj2[0];
            tkc.sP = Sj2[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                tkc.sP = 0.0f;
            }
        } catch (Exception unused) {
        }
        return tkc;
    }

    public static String Sj() {
        return sP;
    }

    public static String Sj(String str) {
        String[] split;
        return (TextUtils.isEmpty(str) || (split = str.split("adx:")) == null || split.length < 2) ? "" : split[1];
    }

    public static int[] Sj(String str, float f11, boolean z10) {
        int[] sP2 = sP(str, f11, z10);
        return new int[]{com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(com.bytedance.sdk.component.adexpress.EjP.Sj(), sP2[0]), com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(com.bytedance.sdk.component.adexpress.EjP.Sj(), sP2[1])};
    }

    public static double sP(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString(TtmlNode.ATTR_TTS_FONT_SIZE));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static boolean sP() {
        return !TextUtils.isEmpty(sP);
    }

    public static int[] sP(String str, float f11, boolean z10) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.EjP.Sj());
            textView.setTextSize(f11);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z10) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }
}
