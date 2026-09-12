package com.bytedance.sdk.openadsdk.core.Ym;

import com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj;
import com.bytedance.sdk.openadsdk.core.Ym.sP.TKC;
import com.bytedance.sdk.openadsdk.core.model.sU;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TKC {
    protected String Dq;
    protected Sj.sP EjP;
    protected String HiB;
    protected List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> Jcg;
    protected int Sj;
    private String TEQ;
    protected Sj.EnumC0275Sj TKC;

    /* renamed from: aa, reason: collision with root package name */
    private sU f21124aa;
    protected int sP;
    protected List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> vS;
    private final AtomicBoolean Ym = new AtomicBoolean(false);
    protected String uA = "endcard_click";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.Ym.TKC$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Sj;

        static {
            int[] iArr = new int[Sj.sP.values().length];
            Sj = iArr;
            try {
                iArr[Sj.sP.STATIC_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Sj[Sj.sP.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Sj[Sj.sP.IFRAME_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public TKC(int i11, int i12, Sj.EnumC0275Sj enumC0275Sj, Sj.sP sPVar, String str, List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list, List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list2, String str2) {
        this.vS = new ArrayList();
        this.Jcg = new ArrayList();
        this.Sj = i11;
        this.sP = i12;
        this.TKC = enumC0275Sj;
        this.EjP = sPVar;
        this.HiB = str;
        this.vS = list;
        this.Jcg = list2;
        this.Dq = str2;
    }

    public static float Sj(int i11, int i12, int i13, int i14, Sj.sP sPVar, Sj.EnumC0275Sj enumC0275Sj) {
        if (i12 == 0 || i14 == 0) {
            return 0.0f;
        }
        float f11 = i11;
        float f12 = i13;
        return Sj(sPVar, enumC0275Sj) / ((Math.abs((f11 / i12) - (f12 / i14)) + Math.abs((f11 - f12) / f11)) + 1.0f);
    }

    private static float Sj(Sj.sP sPVar, Sj.EnumC0275Sj enumC0275Sj) {
        int i11 = AnonymousClass1.Sj[sPVar.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                return i11 != 3 ? 0.0f : 1.0f;
            }
            return 1.2f;
        }
        if (Sj.EnumC0275Sj.JAVASCRIPT.equals(enumC0275Sj)) {
            return 1.0f;
        }
        return Sj.EnumC0275Sj.IMAGE.equals(enumC0275Sj) ? 0.8f : 0.0f;
    }

    public static TKC sP(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("width");
        int optInt2 = jSONObject.optInt("height");
        String optString = jSONObject.optString("creativeType", Sj.EnumC0275Sj.NONE.toString());
        String optString2 = jSONObject.optString("resourceType", Sj.sP.HTML_RESOURCE.toString());
        String optString3 = jSONObject.optString("contentUrl");
        String optString4 = jSONObject.optString("clickThroughUri");
        JSONArray optJSONArray = jSONObject.optJSONArray("clickTrackers");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creativeViewTrackers");
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
            arrayList.add(new TKC.Sj(optJSONArray.optString(i11)).Sj());
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
            arrayList2.add(new TKC.Sj(optJSONArray2.optString(i12)).Sj());
        }
        return new TKC(optInt, optInt2, Sj.EnumC0275Sj.valueOf(optString), Sj.sP.valueOf(optString2), optString3, arrayList, arrayList2, optString4);
    }

    public String EjP() {
        int i11 = AnonymousClass1.Sj[this.EjP.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                return this.HiB;
            }
            if (i11 != 3) {
                return null;
            }
            return "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.Sj + "\" height=\"" + this.sP + "\" src=\"" + this.HiB + "\"></iframe>";
        }
        Sj.EnumC0275Sj enumC0275Sj = this.TKC;
        if (enumC0275Sj == Sj.EnumC0275Sj.IMAGE) {
            return "<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.HiB + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
        }
        if (enumC0275Sj != Sj.EnumC0275Sj.JAVASCRIPT) {
            return null;
        }
        return "<script src=\"" + this.HiB + "\"></script>";
    }

    public String HiB() {
        if (this.EjP == Sj.sP.STATIC_RESOURCE && this.TKC == Sj.EnumC0275Sj.IMAGE) {
            return this.HiB;
        }
        return null;
    }

    public JSONObject Sj() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", this.Sj);
        jSONObject.put("height", this.sP);
        jSONObject.put("creativeType", this.TKC.toString());
        jSONObject.put("resourceType", this.EjP.toString());
        jSONObject.put("contentUrl", this.HiB);
        jSONObject.put("clickThroughUri", this.Dq);
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.vS));
        jSONObject.put("creativeViewTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.Jcg));
        return jSONObject;
    }

    public void Sj(long j11) {
        com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.vS, null, j11, this.TEQ, new TKC.sP(this.uA, this.f21124aa));
    }

    public void Sj(sU sUVar) {
        this.f21124aa = sUVar;
    }

    public void Sj(String str) {
        this.TEQ = str;
    }

    public int TKC() {
        return this.sP;
    }

    public int sP() {
        return this.Sj;
    }

    public void sP(long j11) {
        if (this.Ym.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.sP(this.Jcg, null, j11, this.TEQ);
        }
    }

    public String vS() {
        return this.HiB;
    }
}
