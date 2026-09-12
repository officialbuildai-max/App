package com.bytedance.sdk.component.adexpress.dynamic.EjP;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class vS {
    private boolean AVc;
    private String Aw;
    private boolean Bml;
    private int Chv;
    private String DPc;
    private float Dq;
    private String EZ;
    private int Ei;
    private float EjP;
    private boolean FPG;
    private int Fm;
    private String Fmk;
    private int GMp;
    private String Gn;
    private int Grp;
    private boolean HS;
    private List<Sj> HcZ;
    private boolean HiB;
    private double HpB;
    private boolean IOh;
    private String Ir;
    private String JcM;
    private float Jcg;
    private String LD;
    private double LqL;
    private String Mts;
    private boolean MuB;
    private boolean Ov;
    private int Ph;
    private boolean QZ;
    private String RiZ;
    private double RrR;
    private JSONObject SP;
    private float Sj;
    private float TEQ;
    private int TFd;
    private float TKC;
    private int TO;
    private int TX;
    private String TzV;
    private int UHs;
    private int Uc;
    private String WMZ;
    private int Wjd;
    private int WxP;
    private String Xqg;
    private double Yf;
    private double Ym;
    private String Zq;
    private int aNB;
    private String aZ;

    /* renamed from: aa, reason: collision with root package name */
    private double f20954aa;
    private int cX;
    private JSONObject dLt;
    private String dNu;
    private int dU;

    /* renamed from: db, reason: collision with root package name */
    private boolean f20955db;
    private String dwU;

    /* renamed from: dx, reason: collision with root package name */
    private String f20956dx;
    private int eI;
    private int eMB;
    private String fF;
    private int gR;
    private JSONObject gY;

    /* renamed from: gq, reason: collision with root package name */
    private int f20957gq;
    private long hif = -1;
    private int hzV;

    /* renamed from: ib, reason: collision with root package name */
    private String f20958ib;

    /* renamed from: jb, reason: collision with root package name */
    private int f20959jb;
    private String kF;

    /* renamed from: kb, reason: collision with root package name */
    private int f20960kb;
    private int ley;
    private boolean liH;
    private int mZN;

    /* renamed from: mj, reason: collision with root package name */
    private JSONObject f20961mj;
    private boolean nP;
    private int ndK;
    private String nou;
    private int nru;
    private boolean oWa;
    private boolean pfr;
    private boolean qRN;
    private float sP;
    private String sU;
    private boolean sdp;
    private String sef;
    private int tPD;
    private boolean tX;
    private int tY;

    /* renamed from: tz, reason: collision with root package name */
    private int f20962tz;
    private float uA;
    private boolean uP;
    private String uvD;
    private float vS;

    /* renamed from: vb, reason: collision with root package name */
    private String f20963vb;
    private int wE;
    private int xD;
    private int xhi;

    /* renamed from: xu, reason: collision with root package name */
    private int f20964xu;
    private String xzt;
    private String zR;
    private int zwV;

    public static vS Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        vS vSVar = new vS();
        vSVar.sP(jSONObject.optString("adType", "embeded"));
        vSVar.Zq(jSONObject.optString("clickArea", "creative"));
        vSVar.uvD(jSONObject.optString("clickTigger", "click"));
        vSVar.TKC(jSONObject.optString(TtmlNode.ATTR_TTS_FONT_FAMILY, "PingFangSC"));
        vSVar.EjP(jSONObject.optString(TtmlNode.ATTR_TTS_TEXT_ALIGN, TtmlNode.LEFT));
        vSVar.HiB(jSONObject.optString(TtmlNode.ATTR_TTS_COLOR, "#999999"));
        vSVar.vS(jSONObject.optString("bgColor", TmcStartParams.KEY_TRANSPARENT));
        vSVar.Jcg(jSONObject.optString("bgImgUrl", ""));
        vSVar.ley(jSONObject.optString("bgImgData", ""));
        vSVar.Dq(jSONObject.optString("borderColor", "#000000"));
        vSVar.uA(jSONObject.optString("borderStyle", "solid"));
        vSVar.TEQ(jSONObject.optString("heightMode", "auto"));
        vSVar.Ym(jSONObject.optString("widthMode", "fixed"));
        vSVar.aa(jSONObject.optString("interactText", ""));
        vSVar.TKC(jSONObject.optBoolean("isShowBgControl", false));
        vSVar.Fmk(jSONObject.optString("interactBgColor", ""));
        JSONObject optJSONObject = jSONObject.optJSONObject("interactPosition");
        if (optJSONObject != null) {
            vSVar.Jcg(optJSONObject.optInt("translateY", 0));
            vSVar.Dq(optJSONObject.optInt("translateX", 0));
            vSVar.EjP(optJSONObject.optDouble("scaleX", 0.0d));
            vSVar.HiB(optJSONObject.optDouble("scaleY", 0.0d));
        }
        vSVar.sef(jSONObject.optString("interactType", ""));
        vSVar.HiB(jSONObject.optInt("interactSlideDirection", -1));
        vSVar.dNu(jSONObject.optString("justifyHorizontal", "space-around"));
        vSVar.TzV(jSONObject.optString("justifyVertical", "flex-start"));
        vSVar.sP(jSONObject.optDouble("timingStart"));
        vSVar.TKC(jSONObject.optDouble("timingEnd"));
        vSVar.EjP((float) jSONObject.optDouble("width", 0.0d));
        vSVar.TKC((float) jSONObject.optDouble("height", 0.0d));
        vSVar.Sj((float) jSONObject.optDouble("borderRadius", 0.0d));
        vSVar.sP((float) jSONObject.optDouble("borderSize", 0.0d));
        vSVar.sP(jSONObject.optBoolean("interactValidate", false));
        vSVar.uA((float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, 0.0d));
        vSVar.HiB((float) jSONObject.optDouble("paddingBottom", 0.0d));
        vSVar.vS((float) jSONObject.optDouble("paddingLeft", 0.0d));
        vSVar.Jcg((float) jSONObject.optDouble("paddingRight", 0.0d));
        vSVar.Dq((float) jSONObject.optDouble("paddingTop", 0.0d));
        vSVar.EjP(jSONObject.optBoolean("lineFeed", false));
        vSVar.uA(jSONObject.optInt("lineCount", 0));
        vSVar.vS(jSONObject.optDouble("lineHeight", 1.2d));
        vSVar.sef(jSONObject.optInt("letterSpacing", 0));
        vSVar.HiB(jSONObject.optBoolean("isDataFixed", false));
        vSVar.Zq(jSONObject.optInt(TtmlNode.ATTR_TTS_FONT_WEIGHT));
        vSVar.vS(jSONObject.optBoolean("lineLimit"));
        vSVar.uvD(jSONObject.optInt(RequestParameters.POSITION));
        vSVar.RiZ(jSONObject.optString("align"));
        vSVar.Jcg(jSONObject.optBoolean("useLeft"));
        vSVar.Dq(jSONObject.optBoolean("useRight"));
        vSVar.uA(jSONObject.optBoolean("useTop"));
        vSVar.TEQ(jSONObject.optBoolean("useBottom"));
        vSVar.sU(jSONObject.optString("data"));
        vSVar.sP(jSONObject.optJSONObject("i18n"));
        vSVar.aa(jSONObject.optInt("marginLeft"));
        vSVar.Fmk(jSONObject.optInt("marginRight"));
        vSVar.TEQ(jSONObject.optInt("marginTop"));
        vSVar.Ym(jSONObject.optInt("marginBottom"));
        vSVar.dNu(jSONObject.optInt("tagMaxCount"));
        vSVar.Ym(jSONObject.optBoolean("allowTextFlow"));
        vSVar.TzV(jSONObject.optInt("textFlowType"));
        vSVar.RiZ(jSONObject.optInt("textFlowDuration"));
        vSVar.sU(jSONObject.optInt(TtmlNode.LEFT));
        vSVar.dx(jSONObject.optInt(TtmlNode.RIGHT));
        vSVar.zR(jSONObject.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP));
        vSVar.ib(jSONObject.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT));
        vSVar.dx(jSONObject.optString("alignItems", "flex-start"));
        vSVar.zR(jSONObject.optString("direction", ""));
        vSVar.Sj(jSONObject.optBoolean("loop", false));
        vSVar.kF(jSONObject.optInt("zIndex"));
        vSVar.Yf(jSONObject.optInt("interactVisibleTime"));
        vSVar.uP(jSONObject.optInt("interactHiddenTime"));
        vSVar.Fmk(jSONObject.optBoolean("interactEnableMask"));
        vSVar.sef(jSONObject.optBoolean("interactWontHide"));
        vSVar.Sj(jSONObject.optString("bgGradient"));
        vSVar.fF(jSONObject.optInt("areaType"));
        vSVar.JcM(jSONObject.optInt("interactSlideThreshold", 0));
        vSVar.FPG(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.EjP.sP() ? 0 : 120));
        vSVar.TzV(jSONObject.optBoolean("openPlayableLandingPage", false));
        vSVar.TKC(jSONObject.optJSONObject("video"));
        vSVar.EjP(jSONObject.optJSONObject("image"));
        vSVar.WMZ(jSONObject.optInt("borderShadowExtent"));
        vSVar.Zq(jSONObject.optBoolean("bgGauseBlur"));
        vSVar.Mts(jSONObject.optInt("bgGauseBlurRadius"));
        vSVar.uvD(jSONObject.optBoolean("showTimeProgress", false));
        vSVar.dNu(jSONObject.optBoolean("showPlayButton", false));
        vSVar.Sj(jSONObject.optDouble("bgColorCg", 0.0d));
        vSVar.vS(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        vSVar.sP(jSONObject.optInt("borderTopLeftRadius", 0));
        vSVar.Sj(jSONObject.optInt("borderTopRightRadius", 0));
        vSVar.EjP(jSONObject.optInt("borderBottomLeftRadius", 0));
        vSVar.TKC(jSONObject.optInt("borderBottomRightRadius", 0));
        vSVar.HiB(jSONObject.optJSONObject("interactI18n"));
        vSVar.kF(jSONObject.optString("imageObjectFit"));
        vSVar.uP(jSONObject.optString("interactTitle"));
        vSVar.LD(jSONObject.optInt("interactTextPositionTop"));
        vSVar.ib(jSONObject.optString("imageLottieTosPath"));
        vSVar.aa(jSONObject.optBoolean("animationsLoop"));
        vSVar.wE(jSONObject.optInt("lottieAppNameMaxLength"));
        vSVar.LqL(jSONObject.optInt("lottieAdDescMaxLength"));
        vSVar.ley(jSONObject.optInt("lottieAdTitleMaxLength"));
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("animations");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i11);
                    Sj sj2 = new Sj();
                    sj2.TKC(jSONObject2.optString("animationType"));
                    sj2.Sj(jSONObject2.optDouble("animationDuration"));
                    sj2.sP(jSONObject2.optDouble("animationScaleX"));
                    sj2.TKC(jSONObject2.optDouble("animationScaleY"));
                    sj2.EjP(jSONObject2.optString("animationTimeFunction"));
                    sj2.EjP(jSONObject2.optDouble("animationDelay"));
                    sj2.vS(jSONObject2.optInt("animationIterationCount"));
                    sj2.HiB(jSONObject2.optString("animationDirection"));
                    sj2.HiB(jSONObject2.optDouble("animationInterval"));
                    sj2.Sj(jSONObject2.optInt("animationBorderWidth"));
                    sj2.Sj(jSONObject2.optLong("key"));
                    sj2.sP(jSONObject2.optInt("animationEffectWidth"));
                    sj2.TKC(jSONObject2.optInt("animationSwing", 1));
                    sj2.EjP(jSONObject2.optInt("animationTranslateX"));
                    sj2.HiB(jSONObject2.optInt("animationTranslateY"));
                    sj2.sP(jSONObject2.optString("animationRippleBackgroundColor"));
                    sj2.Sj(jSONObject2.optString("animationScaleDirection"));
                    sj2.Jcg(jSONObject2.optInt("animationFadeStart"));
                    sj2.Dq(jSONObject2.optInt("animationFadeEnd"));
                    sj2.vS(jSONObject2.optString("animationFillMode"));
                    sj2.uA(jSONObject2.optInt("animationBounceHeight"));
                    if (vSVar.RiZ() > 0.0d) {
                        sj2.EjP(sj2.sef() + vSVar.RiZ());
                    }
                    arrayList.add(sj2);
                }
                vSVar.Sj(arrayList);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                vSVar.wE(jSONObject.optString("triggerSlideDirection", "0"));
                vSVar.Sj(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception unused) {
        }
        return vSVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:211:0x03ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03cc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03df A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0404 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x040d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0416 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0444 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x044d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0456 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x045f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0468 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0471 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x047a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0484 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x048d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0496 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x04e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x04f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x04fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0506 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x050f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0518 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0521 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x052a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0533 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x053c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0545 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x054e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0557 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0560 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0569 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0572 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x057b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0584 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x058d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0596 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x059f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x05a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x05b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x05ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x05c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x05cc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x05d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x05df A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:387:0x05e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:390:0x05f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:393:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0604 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:399:0x060d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0616 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x061f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0628 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0631 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:414:0x063a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x000b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.vS r9, org.json.JSONObject r10) {
        /*
            Method dump skipped, instructions count: 2012
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.EjP.vS.Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.vS, org.json.JSONObject):void");
    }

    private void ley(String str) {
        this.Gn = str;
    }

    public boolean AVc() {
        return this.tX;
    }

    public boolean Aw() {
        return this.AVc;
    }

    public boolean Bml() {
        return this.MuB;
    }

    public boolean Chv() {
        return this.sdp;
    }

    public String DPc() {
        return this.xzt;
    }

    public double Dq() {
        return this.RrR;
    }

    public void Dq(float f11) {
        this.uA = f11;
    }

    public void Dq(int i11) {
        this.ley = i11;
    }

    public void Dq(String str) {
        this.RiZ = str;
    }

    public void Dq(boolean z10) {
        this.MuB = z10;
    }

    public int EZ() {
        return this.UHs;
    }

    public String Ei() {
        return this.Mts;
    }

    public int EjP() {
        return this.hzV;
    }

    public void EjP(double d11) {
        this.LqL = d11;
    }

    public void EjP(float f11) {
        this.EjP = f11;
    }

    public void EjP(int i11) {
        this.TX = i11;
    }

    public void EjP(String str) {
        this.Zq = str;
    }

    public void EjP(JSONObject jSONObject) {
        this.dLt = jSONObject;
    }

    public void EjP(boolean z10) {
        this.FPG = z10;
    }

    public double FPG() {
        return this.Yf;
    }

    public void FPG(int i11) {
        this.tY = i11;
    }

    public String Fm() {
        return this.JcM;
    }

    public void Fmk(int i11) {
        this.Ei = i11;
    }

    public void Fmk(String str) {
        this.kF = str;
    }

    public void Fmk(boolean z10) {
        this.tX = z10;
    }

    public boolean Fmk() {
        return this.HiB;
    }

    public boolean GMp() {
        return this.QZ;
    }

    public int Grp() {
        return this.tY;
    }

    public int HS() {
        return this.f20960kb;
    }

    public String HcZ() {
        return this.Ir;
    }

    public int HiB() {
        return this.TX;
    }

    public void HiB(double d11) {
        this.Yf = d11;
    }

    public void HiB(float f11) {
        this.vS = f11;
    }

    public void HiB(int i11) {
        this.zwV = i11;
    }

    public void HiB(String str) {
        this.uvD = str;
    }

    public void HiB(JSONObject jSONObject) {
        this.f20961mj = jSONObject;
    }

    public void HiB(boolean z10) {
        this.f20955db = z10;
    }

    public boolean HpB() {
        return this.FPG;
    }

    public int IOh() {
        return this.ndK;
    }

    public int Ir() {
        return this.aNB;
    }

    public int JcM() {
        return this.wE;
    }

    public void JcM(int i11) {
        this.eMB = i11;
    }

    public int Jcg() {
        return this.zwV;
    }

    public void Jcg(float f11) {
        this.Dq = f11;
    }

    public void Jcg(int i11) {
        this.wE = i11;
    }

    public void Jcg(String str) {
        this.TzV = str;
    }

    public void Jcg(boolean z10) {
        this.sdp = z10;
    }

    public String LD() {
        return this.kF;
    }

    public void LD(int i11) {
        this.Grp = i11;
    }

    public String LqL() {
        return this.zR;
    }

    public void LqL(int i11) {
        this.dU = i11;
    }

    public double Mts() {
        return this.LqL;
    }

    public void Mts(int i11) {
        this.eI = i11;
    }

    public boolean MuB() {
        return this.f20955db;
    }

    public JSONObject Ov() {
        return this.dLt;
    }

    public int Ph() {
        return this.TO;
    }

    public boolean QZ() {
        return this.Ov;
    }

    public double RiZ() {
        return this.Ym;
    }

    public void RiZ(int i11) {
        this.cX = i11;
    }

    public void RiZ(String str) {
        this.dwU = str;
    }

    public int RrR() {
        return this.mZN;
    }

    public boolean SP() {
        return this.oWa;
    }

    public void Sj(double d11) {
        this.RrR = d11;
    }

    public void Sj(float f11) {
        this.Sj = f11;
    }

    public void Sj(int i11) {
        this.Ph = i11;
    }

    public void Sj(long j11) {
        this.hif = j11;
    }

    public void Sj(String str) {
        this.nou = str;
    }

    public void Sj(List<Sj> list) {
        this.HcZ = list;
    }

    public void Sj(boolean z10) {
        this.HS = z10;
    }

    public boolean Sj() {
        return this.HS;
    }

    public String TEQ() {
        return this.nou;
    }

    public void TEQ(int i11) {
        this.xD = i11;
    }

    public void TEQ(String str) {
        this.f20956dx = str;
    }

    public void TEQ(boolean z10) {
        this.pfr = z10;
    }

    public int TFd() {
        return this.f20964xu;
    }

    public int TKC() {
        return this.GMp;
    }

    public void TKC(double d11) {
        this.f20954aa = d11;
    }

    public void TKC(float f11) {
        this.TKC = f11;
    }

    public void TKC(int i11) {
        this.hzV = i11;
    }

    public void TKC(String str) {
        this.sef = str;
    }

    public void TKC(JSONObject jSONObject) {
        this.SP = jSONObject;
    }

    public void TKC(boolean z10) {
        this.uP = z10;
    }

    public int TO() {
        return this.TFd;
    }

    public boolean TX() {
        return this.nP;
    }

    public float TzV() {
        return this.TEQ;
    }

    public void TzV(int i11) {
        this.aNB = i11;
    }

    public void TzV(String str) {
        this.Mts = str;
    }

    public void TzV(boolean z10) {
        this.AVc = z10;
    }

    public int UHs() {
        return this.Ei;
    }

    public JSONObject Uc() {
        return this.gY;
    }

    public int WMZ() {
        return this.ley;
    }

    public void WMZ(int i11) {
        this.TO = i11;
    }

    public String Wjd() {
        return this.LD;
    }

    public void WxP() {
        Sj(this, this.SP);
    }

    public List<Sj> Xqg() {
        return this.HcZ;
    }

    public String Yf() {
        return this.f20958ib;
    }

    public void Yf(int i11) {
        this.mZN = i11;
    }

    public float Ym() {
        return this.Sj;
    }

    public void Ym(int i11) {
        this.Fm = i11;
    }

    public void Ym(String str) {
        this.zR = str;
    }

    public void Ym(boolean z10) {
        this.Bml = z10;
    }

    public float Zq() {
        return this.Jcg;
    }

    public void Zq(int i11) {
        this.ndK = i11;
    }

    public void Zq(String str) {
        this.fF = str;
    }

    public void Zq(boolean z10) {
        this.QZ = z10;
    }

    public boolean aNB() {
        return this.IOh;
    }

    public int aZ() {
        return this.cX;
    }

    public float aa() {
        return this.sP;
    }

    public void aa(int i11) {
        this.f20959jb = i11;
    }

    public void aa(String str) {
        this.f20958ib = str;
    }

    public void aa(boolean z10) {
        this.Ov = z10;
    }

    public boolean cX() {
        return this.pfr;
    }

    public String dLt() {
        return this.f20963vb;
    }

    public float dNu() {
        return this.uA;
    }

    public void dNu(int i11) {
        this.Chv = i11;
    }

    public void dNu(String str) {
        this.WMZ = str;
    }

    public void dNu(boolean z10) {
        this.liH = z10;
    }

    public void dU() {
        Sj(this, this.dLt);
    }

    public int db() {
        return this.xD;
    }

    public double dwU() {
        return this.HpB;
    }

    public String dx() {
        return this.Zq;
    }

    public void dx(int i11) {
        this.Uc = i11;
    }

    public void dx(String str) {
        this.Ir = str;
    }

    public String eI() {
        return this.Aw;
    }

    public int eMB() {
        return this.f20962tz;
    }

    public void fF(int i11) {
        this.nru = i11;
    }

    public boolean fF() {
        return this.uP;
    }

    public boolean gR() {
        return this.Bml;
    }

    public String gY() {
        return this.dwU;
    }

    public int gq() {
        return this.eMB;
    }

    public int hzV() {
        return this.eI;
    }

    public String ib() {
        return this.dNu;
    }

    public void ib(int i11) {
        this.gR = i11;
    }

    public void ib(String str) {
        this.Aw = str;
    }

    public String jb() {
        return this.WMZ;
    }

    public String kF() {
        return this.TzV;
    }

    public void kF(int i11) {
        this.f20962tz = i11;
    }

    public void kF(String str) {
        this.f20963vb = str;
    }

    public String kb() {
        return this.EZ;
    }

    public String ley() {
        return this.f20956dx;
    }

    public void ley(int i11) {
        this.WxP = i11;
    }

    public int liH() {
        return this.WxP;
    }

    public int mZN() {
        return this.gR;
    }

    public int mj() {
        return this.nru;
    }

    public int nP() {
        return this.tPD;
    }

    public int ndK() {
        return this.Fm;
    }

    public String nru() {
        return this.aZ;
    }

    public int oWa() {
        List<Sj> list = this.HcZ;
        if (list == null) {
            return 0;
        }
        for (Sj sj2 : list) {
            if ("translate".equals(sj2.uA()) && sj2.Jcg() < 0) {
                return -sj2.Jcg();
            }
        }
        return 0;
    }

    public boolean pfr() {
        return this.qRN;
    }

    public int qRN() {
        return this.f20959jb;
    }

    public int sP() {
        return this.Ph;
    }

    public void sP(double d11) {
        this.Ym = d11;
    }

    public void sP(float f11) {
        this.sP = f11;
    }

    public void sP(int i11) {
        this.GMp = i11;
    }

    public void sP(String str) {
        this.Fmk = str;
    }

    public void sP(JSONObject jSONObject) {
        this.gY = jSONObject;
    }

    public void sP(boolean z10) {
        this.HiB = z10;
    }

    public double sU() {
        return this.f20954aa;
    }

    public void sU(int i11) {
        this.f20960kb = i11;
    }

    public void sU(String str) {
        this.EZ = str;
    }

    public int sdp() {
        return this.xhi;
    }

    public float sef() {
        return this.vS;
    }

    public void sef(int i11) {
        this.xhi = i11;
    }

    public void sef(String str) {
        this.LD = str;
    }

    public void sef(boolean z10) {
        this.oWa = z10;
    }

    public String tPD() {
        return this.DPc;
    }

    public String tX() {
        return this.Xqg;
    }

    public int tY() {
        return this.dU;
    }

    public int tz() {
        return this.Uc;
    }

    public int uA() {
        return this.f20957gq;
    }

    public void uA(float f11) {
        this.TEQ = f11;
    }

    public void uA(int i11) {
        this.Wjd = i11;
    }

    public void uA(String str) {
        this.sU = str;
    }

    public void uA(boolean z10) {
        this.IOh = z10;
    }

    public String uP() {
        return this.Gn;
    }

    public void uP(int i11) {
        this.TFd = i11;
    }

    public void uP(String str) {
        this.DPc = str;
    }

    public float uvD() {
        return this.Dq;
    }

    public void uvD(int i11) {
        this.UHs = i11;
    }

    public void uvD(String str) {
        this.JcM = str;
    }

    public void uvD(boolean z10) {
        this.nP = z10;
    }

    public JSONObject vS() {
        return this.f20961mj;
    }

    public void vS(double d11) {
        this.HpB = d11;
    }

    public void vS(float f11) {
        this.Jcg = f11;
    }

    public void vS(int i11) {
        this.f20957gq = i11;
    }

    public void vS(String str) {
        this.dNu = str;
    }

    public void vS(boolean z10) {
        this.qRN = z10;
    }

    public boolean vb() {
        return this.liH;
    }

    public String wE() {
        return this.RiZ;
    }

    public void wE(int i11) {
        this.tPD = i11;
    }

    public void wE(String str) {
        this.xzt = str;
    }

    public String xD() {
        return this.fF;
    }

    public int xhi() {
        return this.Wjd;
    }

    public int xu() {
        return this.Chv;
    }

    public long xzt() {
        return this.hif;
    }

    public String zR() {
        return this.uvD;
    }

    public void zR(int i11) {
        this.f20964xu = i11;
    }

    public void zR(String str) {
        this.aZ = str;
    }

    public int zwV() {
        return this.Grp;
    }
}
