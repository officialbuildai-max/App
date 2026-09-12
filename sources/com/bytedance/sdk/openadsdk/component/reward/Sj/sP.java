package com.bytedance.sdk.openadsdk.component.reward.Sj;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.kF;
import com.bytedance.sdk.openadsdk.core.model.dx;
import com.bytedance.sdk.openadsdk.core.model.sU;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class sP {
    private static final SparseArray<WeakReference<sU>> Sj = new SparseArray<>();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9, types: [com.bytedance.sdk.openadsdk.core.model.sU] */
    public static sU Sj(Intent intent, Bundle bundle, com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar) {
        if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            com.bytedance.sdk.openadsdk.core.model.Sj Jcg = kF.Sj().Jcg();
            r3 = Jcg != null ? new dx(Jcg) : null;
            if (sPVar != null) {
                sPVar.Sj(bundle);
            }
            kF.Sj().vS();
        } else if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_AD_INFO);
                if (stringExtra != null) {
                    r3 = new dx(com.bytedance.sdk.openadsdk.core.model.Sj.TKC(new JSONObject(stringExtra)));
                }
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.RFDM", "", e11);
            }
        }
        if (bundle != null) {
            try {
                WeakReference<sU> weakReference = Sj.get(bundle.getInt("meta_tmp"));
                if (weakReference != null) {
                    r3 = weakReference.get();
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sU.Sj("TTAD.RFDM", "", th2);
            }
        }
        if (r3 != null) {
            r3.Sj(r3.zR(), 7);
        }
        return r3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void Sj(android.content.Intent r2, android.app.Activity r3, boolean r4, com.bytedance.sdk.openadsdk.core.model.Sj r5, java.lang.String r6) {
        /*
            if (r3 != 0) goto L8
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r2.addFlags(r3)
            goto L1d
        L8:
            android.view.WindowManager r3 = r3.getWindowManager()     // Catch: java.lang.Exception -> L15
            android.view.Display r3 = r3.getDefaultDisplay()     // Catch: java.lang.Exception -> L15
            int r3 = r3.getRotation()     // Catch: java.lang.Exception -> L15
            goto L1e
        L15:
            r3 = move-exception
            java.lang.String r0 = "TTAD.RFDM"
            java.lang.String r1 = ""
            com.bytedance.sdk.component.utils.sU.Sj(r0, r1, r3)
        L1d:
            r3 = 0
        L1e:
            java.lang.String r0 = "orientation_angle"
            r2.putExtra(r0, r3)
            java.lang.String r3 = "video_is_cached"
            r2.putExtra(r3, r4)
            boolean r3 = com.bytedance.sdk.openadsdk.multipro.sP.TKC()
            if (r3 == 0) goto L44
            org.json.JSONObject r3 = r5.Fmk()
            if (r3 != 0) goto L35
            return
        L35:
            java.lang.String r4 = "multi_process_ad_info"
            java.lang.String r3 = r3.toString()
            r2.putExtra(r4, r3)
            java.lang.String r3 = "multi_process_listener_key"
            r2.putExtra(r3, r6)
            return
        L44:
            com.bytedance.sdk.openadsdk.core.kF r2 = com.bytedance.sdk.openadsdk.core.kF.Sj()
            r2.vS()
            com.bytedance.sdk.openadsdk.core.kF r2 = com.bytedance.sdk.openadsdk.core.kF.Sj()
            r2.Sj(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.Sj.sP.Sj(android.content.Intent, android.app.Activity, boolean, com.bytedance.sdk.openadsdk.core.model.Sj, java.lang.String):void");
    }

    public static void Sj(Intent intent, Sj sj2) {
        if (intent == null) {
            return;
        }
        sj2.f21074ib.sP(intent.getBooleanExtra("video_is_cached", false));
        sj2.f21072db = intent.getStringExtra("multi_process_listener_key");
        sj2.EZ = intent.getIntExtra("orientation_angle", 0) == 3;
    }

    public static void Sj(Bundle bundle, Sj sj2) {
        if (bundle == null) {
            return;
        }
        sj2.f21072db = bundle.getString("multi_process_listener_key");
        sj2.f21074ib.sP(bundle.getBoolean("video_is_cached", false));
        sj2.ndK = bundle.getBoolean("is_mute");
        if (bundle.getLong("video_current") > 0) {
            sj2.f21074ib.Sj(bundle.getLong("video_current", 0L));
        }
        sj2.Sj(bundle.getBoolean("has_show_skip_btn"));
    }

    public static void Sj(Sj sj2, Intent intent, Bundle bundle) {
        Sj(intent, sj2);
        Sj(bundle, sj2);
    }

    public static void Sj(Sj sj2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            sU sUVar = sj2.sP;
            Sj.append(sUVar.hashCode(), new WeakReference<>(sUVar));
            bundle.putInt("meta_tmp", sUVar.hashCode());
            bundle.putString("multi_process_listener_key", sj2.f21072db);
            bundle.putBoolean("video_is_cached", sj2.f21074ib.uP());
            bundle.putLong("video_current", sj2.f21074ib.Jcg());
            bundle.putBoolean("is_mute", sj2.ndK);
            bundle.putBoolean("has_show_skip_btn", sj2.gY);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.Sj("TTAD.RFDM", "onSaveInstanceState: ", th2);
        }
    }
}
