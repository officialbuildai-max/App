package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.EjP.uA;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class sP extends com.bytedance.adsdk.ugeno.sP.Sj<com.bytedance.adsdk.ugeno.vS.sP> implements com.bytedance.adsdk.ugeno.vS.TKC {
    private int AVc;
    private boolean Aw;
    private float GMp;
    private int Grp;
    private int Ov;
    private JSONArray Ph;
    private boolean RrR;
    private boolean SP;
    private float TX;
    private boolean Xqg;
    private float dLt;

    /* renamed from: gq, reason: collision with root package name */
    private float f20904gq;
    private float hzV;

    /* renamed from: mj, reason: collision with root package name */
    private int f20905mj;
    private int oWa;
    private boolean tX;

    /* renamed from: vb, reason: collision with root package name */
    private int f20906vb;
    private String zwV;

    public sP(Context context) {
        super(context);
        this.AVc = 0;
        this.RrR = true;
        this.SP = true;
        this.dLt = 2000.0f;
        this.zwV = "normal";
        this.Xqg = false;
        this.oWa = Color.parseColor("#666666");
        this.f20905mj = Color.parseColor(IntegrationConstants.NAVIGATION_BAR_BACKGROUND_COLOR_DEFAULT);
        this.f20904gq = 1.0f;
        this.GMp = 0.0f;
        this.hzV = 0.0f;
        this.TX = 0.0f;
        this.f20906vb = 0;
        this.Grp = 0;
        this.tX = true;
    }

    private void Dq(int i11) {
        uA uAVar = this.tY;
        if (uAVar == null) {
            return;
        }
        uAVar.Sj("SwiperView://slide", Integer.valueOf(this.Ov), Integer.valueOf(i11), Integer.valueOf(!this.Aw ? 1 : 0));
    }

    private void Jcg(int i11) {
        if (this.tY == null) {
            return;
        }
        if (this.Ov == 0 && i11 == MuB() - 1) {
            this.tY.Sj("SwiperView://reloop", 1);
        }
        if (this.Ov == MuB() - 1 && i11 == 0) {
            this.tY.Sj("SwiperView://reloop", 0);
        }
    }

    private int MuB() {
        if (this.f20906vb == 1) {
            List<com.bytedance.adsdk.ugeno.sP.TKC<View>> list = ((com.bytedance.adsdk.ugeno.sP.Sj) this).Sj;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        JSONArray jSONArray = this.Ph;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    private void Sj(boolean z10, int i11, float f11) {
        if (this.tY != null && !z10 && i11 == MuB() - 1 && f11 == 0.0f && this.tX) {
            this.tY.Sj("SwiperView://finish", new Object[0]);
            this.tX = false;
        }
    }

    private void dwU() {
        List<com.bytedance.adsdk.ugeno.sP.TKC<View>> list = ((com.bytedance.adsdk.ugeno.sP.Sj) this).Sj;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.bytedance.adsdk.ugeno.sP.TKC<View> tkc = ((com.bytedance.adsdk.ugeno.sP.Sj) this).Sj.get(0);
        if (this.Ph == null) {
            return;
        }
        for (int i11 = 0; i11 < this.Ph.length(); i11++) {
            com.bytedance.adsdk.ugeno.core.uA uAVar = new com.bytedance.adsdk.ugeno.core.uA(this.sP);
            uAVar.Sj(this.TO);
            try {
                JSONObject optJSONObject = this.Ph.optJSONObject(i11);
                if (optJSONObject != null) {
                    if (optJSONObject.has("$chunk")) {
                        this.EjP.put("$item", optJSONObject.optJSONArray("$chunk"));
                    } else {
                        this.EjP.put("$item", optJSONObject);
                    }
                    ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).Sj((com.bytedance.adsdk.ugeno.vS.sP) uAVar.Sj(tkc.Yf(), this.EjP, (JSONObject) null));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void sdp() {
        for (int i11 = 0; i11 < ((com.bytedance.adsdk.ugeno.sP.Sj) this).Sj.size(); i11++) {
            com.bytedance.adsdk.ugeno.sP.TKC<View> tkc = ((com.bytedance.adsdk.ugeno.sP.Sj) this).Sj.get(i11);
            if (tkc != null) {
                com.bytedance.adsdk.ugeno.core.uA uAVar = new com.bytedance.adsdk.ugeno.core.uA(this.sP);
                uAVar.Sj(this.TO);
                ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).Sj((com.bytedance.adsdk.ugeno.vS.sP) uAVar.Sj(tkc.Yf(), this.EjP, (JSONObject) null));
            }
        }
    }

    public void EjP() {
        ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).aa(((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).getCurrentItem() - 1);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public View Sj() {
        com.bytedance.adsdk.ugeno.vS.sP sPVar = new com.bytedance.adsdk.ugeno.vS.sP(this.sP);
        this.HiB = sPVar;
        sPVar.Sj((EjP) this);
        return this.HiB;
    }

    public void Sj(int i11) {
        if (((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).getCurrentItem() != i11) {
            ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).aa(i11);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj
    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc) {
        if (tkc == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.sP.Sj) this).Sj.add(tkc);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj
    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc, ViewGroup.LayoutParams layoutParams) {
        if (tkc == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.sP.Sj) this).Sj.add(tkc);
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
            case -1593646704:
                if (str.equals("startIndex")) {
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
            case -1367379379:
                if (str.equals("driveMode")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    c11 = 4;
                    break;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    c11 = 5;
                    break;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    c11 = 6;
                    break;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    c11 = 7;
                    break;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    c11 = 14;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.Grp = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0);
                return;
            case 1:
                this.oWa = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2, this.oWa);
                return;
            case 2:
                this.TX = Dq.Sj(this.sP, com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f));
                return;
            case 3:
                this.f20906vb = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0);
                return;
            case 4:
                this.zwV = str2;
                return;
            case 5:
                if (TextUtils.equals(str2, "vertical")) {
                    this.AVc = 1;
                    return;
                } else {
                    this.AVc = 0;
                    return;
                }
            case 6:
                this.Xqg = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, false);
                return;
            case 7:
                this.hzV = Dq.Sj(this.sP, com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f));
                return;
            case '\b':
                this.RrR = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, true);
                return;
            case '\t':
                this.dLt = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 2000.0f);
                return;
            case '\n':
                this.f20904gq = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 1.0f);
                return;
            case 11:
                this.GMp = Dq.Sj(this.sP, com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f));
                return;
            case '\f':
                this.f20905mj = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2, this.f20905mj);
                return;
            case '\r':
                this.SP = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, true);
                return;
            case 14:
                this.Ph = com.bytedance.adsdk.ugeno.Jcg.sP.Sj(str2, (JSONArray) null);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.vS.TKC
    public void Sj(boolean z10, int i11) {
        if (i11 == 0) {
            if (!z10) {
                this.tX = true;
            }
            this.Aw = false;
        } else if (i11 == 1) {
            this.Aw = true;
        }
        StringBuilder sb2 = new StringBuilder("onPageScrollStateChanged: loop=");
        sb2.append(z10);
        sb2.append("; state=");
        sb2.append(i11);
    }

    @Override // com.bytedance.adsdk.ugeno.vS.TKC
    public void Sj(boolean z10, int i11, float f11, int i12) {
        StringBuilder sb2 = new StringBuilder("onPageScrolled: loop=");
        sb2.append(z10);
        sb2.append("; position=");
        sb2.append(i11);
        sb2.append("; positionOffset=");
        sb2.append(f11);
        sb2.append("; positionOffsetPixels=");
        sb2.append(i12);
        Sj(z10, i11, f11);
    }

    @Override // com.bytedance.adsdk.ugeno.vS.TKC
    public void Sj(boolean z10, int i11, int i12, boolean z11, boolean z12) {
        if (this.Ov != i11) {
            Jcg(i11);
            Dq(i11);
            this.Ov = i11;
        }
        StringBuilder sb2 = new StringBuilder("onPageSelected: loop=");
        sb2.append(z10);
        sb2.append("; position=");
        sb2.append(i11);
        sb2.append("; loopPosition=");
        sb2.append(i12);
        sb2.append("; isFirst=");
        sb2.append(z11);
        sb2.append("; isLast=");
        sb2.append(z12);
    }

    public void TKC() {
        ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).aa(((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).getCurrentItem() + 1);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj, com.bytedance.adsdk.ugeno.sP.TKC
    public void sP() {
        super.sP();
        ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).Sj(this.AVc).TKC(this.RrR).Sj(this.SP).sP((int) this.dLt).sP(this.Xqg).HiB(this.oWa).EjP(this.f20905mj).Jcg((int) this.hzV).Dq((int) this.TX).vS((int) this.GMp).Sj(this.f20904gq).Sj(this.zwV).aa(this.Grp);
        ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).setOnPageChangeListener(this);
        if (this.f20906vb == 1) {
            sdp();
        } else {
            dwU();
        }
        ((com.bytedance.adsdk.ugeno.vS.sP) this.HiB).sP();
    }
}
