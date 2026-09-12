package com.bytedance.sdk.openadsdk.core.TEQ.HiB;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.TEQ;
import com.bytedance.sdk.openadsdk.core.TzV;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.utils.Mts;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class EjP {
    private final sU Dq;
    private com.bytedance.adsdk.ugeno.sP.TKC EjP;
    private boolean Fmk;
    private com.bytedance.adsdk.ugeno.sP.TKC HiB;
    private final Context Jcg;
    private com.bytedance.sdk.openadsdk.core.widget.HiB TEQ;
    private com.bytedance.adsdk.ugeno.sP.TKC TKC;
    private JSONObject Ym;
    private boolean Zq;

    /* renamed from: aa, reason: collision with root package name */
    private final JSONObject f21109aa;
    private boolean sef;
    private final String uA;
    private JSONArray uvD;
    private int Sj = -1;
    private int sP = -1;
    private final String vS = "UGenSwiperEvent";

    public EjP(Context context, sU sUVar, String str, JSONObject jSONObject) {
        this.Jcg = context;
        this.Dq = sUVar;
        this.uA = str;
        this.f21109aa = jSONObject;
    }

    private Context Sj(View view) {
        Activity Sj = view != null ? com.bytedance.sdk.component.utils.sP.Sj(view) : null;
        return Sj == null ? this.Jcg : Sj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("index", i11);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.EjP.TKC.sP(this.Dq, this.uA, "carousel_show", jSONObject);
    }

    private void Sj(TextView textView, int i11) {
        int currentTextColor = textView.getCurrentTextColor();
        textView.setTextColor(Color.argb(i11, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
    }

    private void Sj(JSONObject jSONObject, View view) {
        if (Sj(jSONObject.optInt("landingStyle"), jSONObject.optString("url"), jSONObject.optString("fallback_url"))) {
            TzV.Sj(Sj(view), this.Jcg instanceof Activity, jSONObject, this.Dq, this.uA, Mts.Sj(this.uA), null, this.TEQ);
        }
    }

    private void Sj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
        this.Ym = optJSONObject;
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.Ym.putOpt(next, com.bytedance.adsdk.ugeno.TKC.sP.Sj((String) this.Ym.opt(next), jSONObject2));
                } catch (Throwable unused) {
                }
            }
            try {
                jSONObject.putOpt("clickInfo", this.Ym);
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(boolean z10, boolean z11, boolean z12) {
        com.bytedance.adsdk.ugeno.sP.TKC tkc = this.TKC;
        if (tkc == null || this.EjP == null) {
            return;
        }
        View Ym = tkc.Ym();
        View Ym2 = this.EjP.Ym();
        JSONArray jSONArray = this.uvD;
        if (jSONArray != null && jSONArray.length() == 1) {
            Ym.setVisibility(8);
            Ym2.setVisibility(8);
            return;
        }
        if (z10) {
            return;
        }
        if (z11) {
            if (Ym instanceof TextView) {
                Sj((TextView) Ym, 90);
            }
            if (Ym2 instanceof TextView) {
                Sj((TextView) Ym2, 255);
                return;
            }
            return;
        }
        if (z12) {
            if (Ym instanceof TextView) {
                Sj((TextView) Ym, 255);
            }
            if (Ym2 instanceof TextView) {
                Sj((TextView) Ym2, 90);
                return;
            }
            return;
        }
        if (Ym instanceof TextView) {
            Sj((TextView) Ym, 255);
        }
        if (Ym2 instanceof TextView) {
            Sj((TextView) Ym2, 255);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0008, code lost:
    
        if (r4 != 3) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean Sj(int r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            r0 = 0
            r1 = 1
            if (r4 == r1) goto L1f
            r2 = 2
            if (r4 == r2) goto Lb
            r6 = 3
            if (r4 == r6) goto L1f
            goto L26
        Lb:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 == 0) goto L18
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 == 0) goto L18
            goto L27
        L18:
            boolean r4 = com.bytedance.sdk.component.utils.TzV.Sj(r6)
            if (r4 != 0) goto L26
            goto L27
        L1f:
            boolean r4 = com.bytedance.sdk.component.utils.TzV.Sj(r5)
            if (r4 != 0) goto L26
            goto L27
        L26:
            r0 = r1
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.TEQ.HiB.EjP.Sj(int, java.lang.String, java.lang.String):boolean");
    }

    public JSONObject EjP() {
        return this.Ym;
    }

    public void Sj() {
        Sj(this.Fmk, this.sef, this.Zq);
    }

    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC<View> tkc) {
        com.bytedance.adsdk.ugeno.sP.TKC<View> TKC = tkc.TKC("swiperLayout");
        this.HiB = TKC;
        if (TKC instanceof com.bytedance.adsdk.ugeno.TKC) {
            this.uvD = this.f21109aa.optJSONArray("dpa_data");
            this.TKC = tkc.TKC("swiperLeftArrow");
            this.EjP = tkc.TKC("swiperRightArrow");
            ((com.bytedance.adsdk.ugeno.TKC) this.HiB).Sj(new com.bytedance.adsdk.ugeno.vS.TKC() { // from class: com.bytedance.sdk.openadsdk.core.TEQ.HiB.EjP.1
                @Override // com.bytedance.adsdk.ugeno.vS.TKC
                public void Sj(boolean z10, int i11) {
                }

                @Override // com.bytedance.adsdk.ugeno.vS.TKC
                public void Sj(boolean z10, int i11, float f11, int i12) {
                }

                @Override // com.bytedance.adsdk.ugeno.vS.TKC
                public void Sj(boolean z10, int i11, int i12, boolean z11, boolean z12) {
                    EjP.this.sP = i11;
                    EjP.this.Sj = i12;
                    EjP.this.Fmk = z10;
                    EjP.this.sef = z11;
                    EjP.this.Zq = z12;
                    EjP.this.Sj(z10, z11, z12);
                    EjP.this.Sj(i11);
                }
            });
        }
    }

    public void Sj(com.bytedance.sdk.openadsdk.core.widget.HiB hiB) {
        this.TEQ = hiB;
    }

    public boolean Sj(TEQ teq) {
        JSONObject optJSONObject;
        this.Ym = null;
        int i11 = this.sP;
        if (i11 != -1 && i11 != 0) {
            try {
                JSONObject TKC = teq.TKC();
                if (TKC != null && (optJSONObject = TKC.optJSONObject("related_dpa_click")) != null) {
                    boolean optBoolean = optJSONObject.optBoolean("enableOpenExternalUrl");
                    int optInt = optJSONObject.optInt("landingStyle");
                    if (optBoolean && optInt != -1) {
                        if (this.uvD != null) {
                            String Sj = com.bytedance.adsdk.ugeno.TKC.sP.Sj(optJSONObject.optString("url"), this.uvD.optJSONObject(this.sP));
                            String Sj2 = com.bytedance.adsdk.ugeno.TKC.sP.Sj(optJSONObject.optString("fallback_url"), this.uvD.optJSONObject(this.sP));
                            optJSONObject.put("url", Sj);
                            optJSONObject.put("fallback_url", Sj2);
                            Sj(optJSONObject, this.uvD.optJSONObject(this.sP));
                        }
                        Sj(optJSONObject, teq.Sj().Ym());
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sU.sP("UGenSwiperEvent", th2.getMessage());
            }
        }
        return false;
    }

    public void TKC() {
        int i11;
        com.bytedance.adsdk.ugeno.sP.TKC tkc = this.HiB;
        if (!(tkc instanceof com.bytedance.adsdk.ugeno.TKC) || (i11 = this.Sj) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.TKC) tkc).Sj(i11 + 1);
    }

    public void sP() {
        int i11;
        com.bytedance.adsdk.ugeno.sP.TKC tkc = this.HiB;
        if (!(tkc instanceof com.bytedance.adsdk.ugeno.TKC) || (i11 = this.Sj) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.TKC) tkc).Sj(i11 - 1);
    }
}
