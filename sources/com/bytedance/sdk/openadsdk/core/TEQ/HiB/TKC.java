package com.bytedance.sdk.openadsdk.core.TEQ.HiB;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.EjP.vS;
import com.bytedance.adsdk.ugeno.core.Fmk;
import com.bytedance.adsdk.ugeno.core.TEQ;
import com.bytedance.adsdk.ugeno.core.aa;
import com.bytedance.adsdk.ugeno.core.uA;
import com.bytedance.sdk.component.adexpress.EjP.vS;
import com.bytedance.sdk.component.adexpress.sP.Dq;
import com.bytedance.sdk.component.adexpress.sP.Jcg;
import com.bytedance.sdk.component.adexpress.sP.sef;
import com.bytedance.sdk.component.utils.ib;
import com.bytedance.sdk.openadsdk.core.Dq.RiZ;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.sef;
import com.bytedance.sdk.openadsdk.core.sP.TKC;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TKC implements Fmk, aa, com.bytedance.sdk.component.adexpress.dynamic.EjP, com.bytedance.sdk.component.adexpress.sP.EjP<View> {
    private static float LD = 0.0f;
    private static float LqL = 0.0f;
    private static float Yf = 0.0f;
    private static float fF = 0.0f;
    private static long ley = 0;
    protected static int sU = 24;
    protected Dq Dq;
    protected JSONObject EjP;
    protected float Fmk;
    protected sU HiB;
    private EjP JcM;
    protected FrameLayout Jcg;
    protected uA Sj;
    protected com.bytedance.adsdk.ugeno.sP.TKC<View> TKC;
    protected long TzV;
    private RiZ WMZ;
    protected com.bytedance.adsdk.ugeno.sP.TKC Ym;
    protected float Zq;

    /* renamed from: aa, reason: collision with root package name */
    protected com.bytedance.adsdk.ugeno.sP.TKC f21110aa;
    protected long dNu;

    /* renamed from: dx, reason: collision with root package name */
    protected WeakReference<View> f21111dx;
    protected JSONObject kF;
    protected Context sP;
    protected float sef;
    protected sef uA;
    private Jcg uP;
    protected float uvD;
    protected Sj vS;
    private final boolean wE;
    protected String zR;
    protected boolean RiZ = true;

    /* renamed from: ib, reason: collision with root package name */
    public SparseArray<TKC.Sj> f21112ib = new SparseArray<>();
    private String Mts = "";
    private final com.bytedance.sdk.component.Dq.Dq FPG = new com.bytedance.sdk.component.Dq.Dq("ugen_render_template") { // from class: com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC.1
        @Override // java.lang.Runnable
        public void run() {
            TKC tkc = TKC.this;
            tkc.EjP = tkc.Sj();
            if (TKC.this.WMZ != null) {
                TKC tkc2 = TKC.this;
                tkc2.Mts = tkc2.WMZ.getUgenTemplateErrorReason();
            } else {
                TKC.this.Mts = "expressView is null";
            }
            com.bytedance.sdk.openadsdk.core.sef.TKC().post(TKC.this.Wjd);
        }
    };
    private final Runnable Wjd = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC.2
        @Override // java.lang.Runnable
        public void run() {
            if (TKC.this.uP != null) {
                TKC tkc = TKC.this;
                tkc.sP(tkc.uP);
            }
        }
    };
    private boolean xD = false;
    protected AtomicBoolean TEQ = new AtomicBoolean(false);

    static {
        if (dNu.Sj() != null) {
            sU = dNu.sP();
        }
    }

    public TKC(Context context, sU sUVar, boolean z10, Sj sj2, ViewGroup viewGroup) {
        this.sP = context;
        this.wE = z10;
        this.Sj = new uA(context);
        this.HiB = sUVar;
        this.vS = sj2;
        this.Jcg = new FrameLayout(context);
        if (viewGroup instanceof RiZ) {
            this.WMZ = (RiZ) viewGroup;
        }
        this.zR = sj2.EjP();
        JSONObject sP = sP();
        this.kF = sP;
        this.JcM = new EjP(this.sP, this.HiB, this.zR, sP);
    }

    private void Sj(TEQ teq) {
        JSONObject jSONObject;
        boolean z10;
        int i11;
        String str;
        EjP ejP;
        EjP ejP2;
        EjP ejP3;
        int i12 = 5;
        boolean z11 = true;
        if (this.Dq == null) {
            return;
        }
        String optString = teq.TKC().optString(NativeComponentConstants.KEY_COMPONENT_TYPE);
        if ("swiperLeft".equals(optString) && (ejP3 = this.JcM) != null) {
            ejP3.sP();
            return;
        }
        if ("swiperRight".equals(optString) && (ejP2 = this.JcM) != null) {
            ejP2.TKC();
            return;
        }
        if (!"swiperClick".equals(optString) || (ejP = this.JcM) == null) {
            jSONObject = null;
            z10 = false;
            i11 = 0;
        } else {
            z10 = ejP.Sj(teq);
            jSONObject = this.JcM.EjP();
            i11 = 2;
        }
        optString.hashCode();
        char c11 = 65535;
        switch (optString.hashCode()) {
            case -314498168:
                if (optString.equals("privacy")) {
                    c11 = 0;
                    break;
                }
                break;
            case -191501435:
                if (optString.equals(TmcConstants.MENU_KEY_FEEDBACK)) {
                    c11 = 1;
                    break;
                }
                break;
            case 3363353:
                if (optString.equals(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                    c11 = 2;
                    break;
                }
                break;
            case 3532159:
                if (optString.equals("skip")) {
                    c11 = 3;
                    break;
                }
                break;
            case 112202875:
                if (optString.equals("video")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1820422063:
                if (optString.equals("creative")) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                i12 = 7;
                break;
            case 1:
                i12 = 3;
                break;
            case 2:
                break;
            case 3:
                i12 = 6;
                break;
            case 4:
                i12 = 4;
                break;
            case 5:
                i12 = 2;
                break;
            default:
                i12 = i11;
                break;
        }
        com.bytedance.adsdk.ugeno.sP.TKC Sj = teq.Sj();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.f21111dx;
        if (weakReference != null) {
            int[] Sj2 = FPG.Sj(weakReference.get());
            if (Sj2 != null) {
                iArr = Sj2;
            }
            int[] TKC = FPG.TKC(this.f21111dx.get());
            if (TKC != null) {
                iArr2 = TKC;
            }
        }
        sef.Sj Sj3 = new sef.Sj().EjP(this.Fmk).TKC(this.sef).sP(this.Zq).Sj(this.uvD).sP(this.dNu).Sj(this.TzV).TKC(iArr[0]).EjP(iArr[1]).HiB(iArr2[0]).vS(iArr2[1]).Sj(this.f21112ib);
        if (teq.sP() == 1 && !this.RiZ) {
            z11 = false;
        }
        sef.Sj Sj4 = Sj3.Sj(z11);
        if (Sj == null) {
            str = "";
        } else {
            str = Sj.WMZ() + "_" + Sj.JcM();
        }
        this.Dq.Sj(teq.Sj().Ym(), i12, Sj4.Sj(str).sP(z10).sP(jSONObject).Sj());
    }

    private void Sj(CharSequence charSequence, boolean z10, int i11, boolean z11) {
        com.bytedance.adsdk.ugeno.sP.TKC<View> TKC;
        int i12;
        com.bytedance.adsdk.ugeno.sP.TKC<View> tkc = this.TKC;
        if (tkc == null || (TKC = tkc.TKC("countdown")) == null) {
            return;
        }
        View Ym = TKC.Ym();
        if (Ym instanceof TextView) {
            try {
                i12 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.sU.sP("UGenRender", "parse duration exception", charSequence);
                i12 = 0;
            }
            if (z11 || i12 <= 0 || this.xD) {
                Ym.setVisibility(8);
                return;
            }
            Ym.setVisibility(0);
            if (!z10 && this.vS.Sj() && vS.sP(this.vS.EjP())) {
                ((TextView) Ym).setText(String.format(ib.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj(), "tt_reward_full_skip"), Integer.valueOf(i11)));
                return;
            }
            if (!"open_ad".equals(this.vS.EjP()) && this.vS.Sj()) {
                this.xD = true;
                Ym.setVisibility(8);
            } else {
                ((TextView) Ym).setText(((Object) charSequence) + "s");
            }
        }
    }

    private void Sj(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.sP.TKC<View> TKC;
        if (this.TKC == null || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(NativeComponentConstants.KEY_COMPONENT_TYPE);
        String optString2 = jSONObject.optString("nodeId");
        if (TextUtils.isEmpty(optString2) || (TKC = this.TKC.TKC(optString2)) == null) {
            return;
        }
        if (TextUtils.equals(optString, "onShow")) {
            TKC.TKC(0);
        } else if (TextUtils.equals(optString, "onDismiss")) {
            TKC.TKC(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(Jcg jcg) {
        this.vS.fF().Sj();
        if (this.EjP == null) {
            jcg.Sj(Sdk$SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, "ugen template is null real reason is " + this.Mts);
            return;
        }
        if (this.kF == null) {
            jcg.Sj(Sdk$SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, "ugen data is null");
            return;
        }
        int EjP = EjP();
        if (this.Sj.Sj()) {
            List<String> sP = this.Sj.sP();
            if (sP == null) {
                jcg.Sj(138, "unknow widget");
                return;
            }
            jcg.Sj(138, "unknow widget;" + sP.toString());
            return;
        }
        if (EjP != 0) {
            jcg.Sj(EjP, "ugen render fail");
            return;
        }
        if (this.TKC == null) {
            jcg.Sj(138, "ugen render error");
            return;
        }
        sP sPVar = new sP();
        this.uA = sPVar;
        sPVar.Sj(true);
        this.uA.Sj(TKC());
        setSoundMute(this.wE);
        uA();
        com.bytedance.adsdk.ugeno.sP.TKC Jcg = Jcg();
        this.Ym = Jcg;
        if (Jcg != null && (Jcg instanceof com.bytedance.sdk.openadsdk.core.TEQ.sP.sP.sP)) {
            ((sP) this.uA).Sj((FrameLayout) ((com.bytedance.sdk.openadsdk.core.TEQ.sP.sP.sP) Jcg).EjP());
        }
        com.bytedance.adsdk.ugeno.sP.TKC Dq = Dq();
        EjP ejP = this.JcM;
        if (ejP != null) {
            ejP.Sj();
        }
        if (Dq != null && Dq.Ym() != null) {
            this.f21111dx = new WeakReference<>(Dq.Ym());
        }
        com.bytedance.adsdk.ugeno.sP.TKC vS = vS();
        this.f21110aa = vS;
        if (vS != null && (vS instanceof com.bytedance.adsdk.ugeno.uA.sP.sP)) {
            ((sP) this.uA).sP((FrameLayout) vS.Ym());
        }
        this.Jcg.addView(this.TKC.Ym(), new FrameLayout.LayoutParams(this.TKC.Mts(), this.TKC.FPG()));
        float LqL2 = this.vS.LqL();
        float Yf2 = this.vS.Yf();
        float sP2 = FPG.sP(this.sP, LqL2);
        float sP3 = FPG.sP(this.sP, Yf2);
        if (TKC() != 7) {
            this.Jcg.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        } else if (Yf2 <= 0.0f) {
            this.Jcg.setLayoutParams(new FrameLayout.LayoutParams((int) sP2, -2));
        } else {
            this.Jcg.setLayoutParams(new FrameLayout.LayoutParams((int) sP2, (int) sP3));
        }
        if (Yf2 <= 0.0f || LqL2 <= 0.0f) {
            this.Jcg.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int TKC = FPG.TKC(this.sP, this.Jcg.getMeasuredWidth());
            int TKC2 = FPG.TKC(this.sP, this.Jcg.getMeasuredHeight());
            this.uA.Sj(TKC);
            this.uA.sP(TKC2);
        } else {
            this.uA.Sj(LqL2);
            this.uA.sP(Yf2);
        }
        if (this.TEQ.get()) {
            jcg.Sj(Sdk$SDKError.Reason.TPAT_RETRY_FAILED_VALUE, "ugen render timeout");
        } else {
            jcg.Sj(this.Jcg, this.uA);
        }
    }

    private void sP(CharSequence charSequence, boolean z10, int i11, boolean z11) {
        com.bytedance.adsdk.ugeno.sP.TKC<View> TKC;
        View Ym;
        com.bytedance.adsdk.ugeno.sP.TKC<View> tkc = this.TKC;
        if (tkc == null || (TKC = tkc.TKC("skip")) == null || (Ym = TKC.Ym()) == null) {
            return;
        }
        int i12 = 0;
        if (!z10 && !z11) {
            i12 = 8;
        }
        Ym.setVisibility(i12);
    }

    private void uA() {
        com.bytedance.adsdk.ugeno.sP.TKC<View> TKC;
        if (this.TKC == null) {
            return;
        }
        if (this.HiB.rB() && (TKC = this.TKC.TKC("tvskip")) != null) {
            TKC.TKC(8);
        }
        com.bytedance.adsdk.ugeno.sP.TKC<View> TKC2 = this.TKC.TKC("skip");
        if (TKC2 != null && (TKC2 instanceof com.bytedance.adsdk.ugeno.uA.EjP.TKC)) {
            if (!com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().sef(String.valueOf(this.HiB.If())) || this.HiB.dx() == 5 || this.HiB.dx() == 6 || this.HiB.DKj() == 3) {
                ((com.bytedance.adsdk.ugeno.uA.EjP.TKC) TKC2).Dq("local://tt_close_btn");
                TKC2.sP();
            }
        }
    }

    protected com.bytedance.adsdk.ugeno.sP.TKC Dq() {
        com.bytedance.adsdk.ugeno.sP.TKC<View> tkc = this.TKC;
        if (tkc == null) {
            return null;
        }
        return tkc.TKC(TmcConstants.MENU_KEY_FEEDBACK);
    }

    protected int EjP() {
        this.Sj.Sj((aa) this);
        this.Sj.Sj((Fmk) this);
        com.bytedance.adsdk.ugeno.sP.TKC<View> Sj = this.Sj.Sj(this.EjP);
        this.TKC = Sj;
        EjP ejP = this.JcM;
        if (ejP != null && Sj != null) {
            ejP.Sj(Sj);
        }
        this.vS.fF().sP();
        this.vS.fF().TKC();
        this.Sj.sP(this.kF);
        return 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.sP.EjP
    public View HiB() {
        return this.Jcg;
    }

    protected com.bytedance.adsdk.ugeno.sP.TKC Jcg() {
        com.bytedance.adsdk.ugeno.sP.TKC<View> tkc = this.TKC;
        if (tkc == null) {
            return null;
        }
        return tkc.TKC("video");
    }

    protected JSONObject Sj() {
        return this.vS.TKC();
    }

    @Override // com.bytedance.adsdk.ugeno.core.aa
    public void Sj(TEQ teq, aa.sP sPVar, aa.Sj sj2) {
        if (teq == null) {
            return;
        }
        if (teq.sP() == 1 || teq.sP() == 4) {
            Sj(teq);
        }
        if (teq.sP() == 10) {
            Sj(teq.TKC());
        }
        if (sPVar == null || teq.EjP() == null) {
            return;
        }
        sPVar.Sj(teq.EjP());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC.fF <= r2) goto L16;
     */
    @Override // com.bytedance.adsdk.ugeno.core.Fmk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.TEQ.HiB.TKC.Sj(com.bytedance.adsdk.ugeno.sP.TKC, android.view.MotionEvent):void");
    }

    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc, String str, vS.Sj sj2) {
    }

    public void Sj(Dq dq2) {
        this.Dq = dq2;
    }

    @Override // com.bytedance.sdk.component.adexpress.sP.EjP
    public void Sj(Jcg jcg) {
        this.uP = jcg;
        JcM.sP(this.FPG);
    }

    public void Sj(com.bytedance.sdk.openadsdk.core.widget.HiB hiB) {
        EjP ejP = this.JcM;
        if (ejP != null) {
            ejP.Sj(hiB);
        }
    }

    public void Sj(boolean z10) {
        this.TEQ.set(z10);
    }

    @Override // com.bytedance.sdk.component.adexpress.sP.EjP
    public int TKC() {
        return this.HiB.fF();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EjP
    public void onvideoComplate() {
    }

    protected JSONObject sP() {
        return this.vS.LD();
    }

    public void setSoundMute(boolean z10) {
        com.bytedance.adsdk.ugeno.sP.TKC<View> TKC;
        com.bytedance.adsdk.ugeno.sP.TKC<View> tkc = this.TKC;
        if (tkc == null || (TKC = tkc.TKC(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) == null) {
            return;
        }
        if (z10) {
            ((com.bytedance.adsdk.ugeno.uA.EjP.TKC) TKC).Dq("local://tt_reward_full_mute");
        } else {
            ((com.bytedance.adsdk.ugeno.uA.EjP.TKC) TKC).Dq("local://tt_reward_full_unmute");
        }
        TKC.sP();
    }

    public void setTime(CharSequence charSequence, int i11, int i12, boolean z10) {
        if (this.TKC == null) {
            return;
        }
        boolean z11 = i11 == 1;
        Sj(charSequence, z11, i12, z10);
        sP(charSequence, z11, i12, z10);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EjP
    public void setTimeUpdate(int i11) {
    }

    public com.bytedance.adsdk.ugeno.sP.TKC vS() {
        com.bytedance.adsdk.ugeno.sP.TKC<View> tkc = this.TKC;
        if (tkc == null) {
            return null;
        }
        return tkc.EjP("PlayableComponent");
    }
}
