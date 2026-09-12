package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import com.bytedance.adsdk.ugeno.core.uA;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes2.dex */
public class TKC extends com.bytedance.adsdk.ugeno.sP.Sj<com.bytedance.adsdk.ugeno.vS.sP> {
    private String AVc;
    private JSONArray GMp;
    private float Grp;
    private float Ph;
    private boolean RrR;
    private boolean SP;
    private float TX;
    private String Xqg;
    private float dLt;

    /* renamed from: gq, reason: collision with root package name */
    private int f20897gq;
    private com.bytedance.adsdk.ugeno.sP.TKC hzV;

    /* renamed from: mj, reason: collision with root package name */
    private int f20898mj;
    private boolean oWa;

    /* renamed from: vb, reason: collision with root package name */
    private float f20899vb;
    private float zwV;

    public TKC(Context context) {
        super(context);
        this.RrR = true;
        this.SP = true;
        this.dLt = 0.0f;
        this.zwV = 2000.0f;
        this.Xqg = "normal";
        this.oWa = true;
        this.f20898mj = Color.parseColor("#666666");
        this.f20897gq = Color.parseColor(IntegrationConstants.NAVIGATION_BAR_BACKGROUND_COLOR_DEFAULT);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public View Sj() {
        com.bytedance.adsdk.ugeno.vS.sP sPVar = new com.bytedance.adsdk.ugeno.vS.sP(this.sP);
        this.HiB = sPVar;
        sPVar.Sj((EjP) this);
        return this.HiB;
    }

    public void Sj(int i11) {
        T t11 = this.HiB;
        if (t11 != 0) {
            ((com.bytedance.adsdk.ugeno.vS.sP) t11).aa(i11);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj
    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc) {
        this.hzV = tkc;
    }

    public void Sj(com.bytedance.adsdk.ugeno.vS.TKC tkc) {
        T t11 = this.HiB;
        if (t11 != 0) {
            ((com.bytedance.adsdk.ugeno.vS.sP) t11).setOnPageChangeListener(tkc);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void Sj(String str, String str2) {
        super.Sj(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1657957217:
                if (str.equals("delayStart")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    c11 = 3;
                    break;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    c11 = 4;
                    break;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    c11 = 5;
                    break;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    c11 = 6;
                    break;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c11 = 7;
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    c11 = '\r';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.dLt = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f);
                return;
            case 1:
                this.f20898mj = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2);
                return;
            case 2:
                this.Grp = Dq.Sj(this.sP, com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f));
                return;
            case 3:
                this.Xqg = str2;
                return;
            case 4:
                this.AVc = str2;
                return;
            case 5:
                this.oWa = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, true);
                return;
            case 6:
                this.f20899vb = Dq.Sj(this.sP, com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f));
                return;
            case 7:
                this.RrR = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, true);
                return;
            case '\b':
                this.zwV = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 500.0f);
                return;
            case '\t':
                this.Ph = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 1.0f);
                return;
            case '\n':
                this.TX = Dq.Sj(this.sP, com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f));
                return;
            case 11:
                this.f20897gq = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2);
                return;
            case '\f':
                this.SP = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, true);
                return;
            case '\r':
                this.GMp = com.bytedance.adsdk.ugeno.Jcg.sP.Sj(str2, (JSONArray) null);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void Sj(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj, com.bytedance.adsdk.ugeno.sP.TKC
    public void sP() {
        super.sP();
        JSONArray jSONArray = this.GMp;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).vS((int) this.TX).Jcg((int) this.f20899vb).Dq((int) this.Grp).sP(this.oWa).EjP(this.f20897gq).HiB(this.f20898mj).Sj(this.Xqg).TKC(this.RrR).Sj(this.Ph).Sj(this.SP).TKC((int) this.zwV).sP(this.oWa);
        for (int i11 = 0; i11 < this.GMp.length(); i11++) {
            uA uAVar = new uA(this.sP);
            uAVar.Sj(this.TO);
            com.bytedance.adsdk.ugeno.sP.TKC<View> sP = uAVar.sP(this.hzV.Yf(), null);
            uAVar.sP(this.GMp.optJSONObject(i11));
            ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).Sj((com.bytedance.adsdk.ugeno.vS.sP) sP);
        }
        if (this.SP) {
            ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).sP();
        }
    }
}
