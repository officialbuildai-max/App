package com.bytedance.sdk.component.adexpress.dynamic.EjP;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Dq {
    private float Dq;
    private float EjP;
    private String Fmk;
    private float HiB;
    private float Jcg;
    private String Sj;
    private List<Dq> TEQ;
    private float TKC;
    private Dq Ym;

    /* renamed from: aa, reason: collision with root package name */
    private List<List<Dq>> f20951aa;
    private float sP;
    private boolean sef;
    private HiB uA;
    private float vS;
    private Map<String, String> Zq = new HashMap();
    private Map<Integer, String> uvD = new HashMap();

    public float Dq() {
        return this.vS;
    }

    public float EjP() {
        return this.EjP;
    }

    public void EjP(float f11) {
        this.TKC = f11;
    }

    public int Fmk() {
        vS HiB = this.uA.HiB();
        return HiB.qRN() + HiB.UHs();
    }

    public float HiB() {
        return this.HiB;
    }

    public void HiB(float f11) {
        this.vS = f11;
    }

    public float Jcg() {
        return this.TKC;
    }

    public void Jcg(float f11) {
        this.Dq = f11;
    }

    public boolean RiZ() {
        return this.sef;
    }

    public String Sj() {
        return this.Fmk;
    }

    public String Sj(int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.uA.sP());
        sb2.append(":");
        sb2.append(this.Sj);
        if (this.uA.HiB() != null) {
            sb2.append(":");
            sb2.append(this.uA.HiB().mj());
        }
        sb2.append(":");
        sb2.append(i11);
        return sb2.toString();
    }

    public void Sj(float f11) {
        this.EjP = f11;
    }

    public void Sj(Dq dq2) {
        this.Ym = dq2;
    }

    public void Sj(HiB hiB) {
        this.uA = hiB;
    }

    public void Sj(String str) {
        this.Fmk = str;
    }

    public void Sj(String str, String str2) {
        this.Zq.put(str, str2);
    }

    public void Sj(List<Dq> list) {
        this.TEQ = list;
    }

    public void Sj(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                    this.uvD.put(Integer.valueOf(optJSONObject.optInt("id")), optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void Sj(boolean z10) {
        this.sef = z10;
    }

    public HiB TEQ() {
        return this.uA;
    }

    public String TKC() {
        return this.Sj;
    }

    public void TKC(float f11) {
        this.sP = f11;
    }

    public void TKC(String str) {
        this.uA.HiB().vS(str);
    }

    public boolean TzV() {
        List<Dq> list = this.TEQ;
        return list == null || list.size() <= 0;
    }

    public List<Dq> Ym() {
        return this.TEQ;
    }

    public float Zq() {
        vS HiB = this.uA.HiB();
        return Fmk() + HiB.Zq() + HiB.uvD() + (HiB.aa() * 2.0f);
    }

    public Dq aa() {
        return this.Ym;
    }

    public List<List<Dq>> dNu() {
        return this.f20951aa;
    }

    public void dx() {
        List<List<Dq>> list = this.f20951aa;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<Dq> list2 : this.f20951aa) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.f20951aa = arrayList;
    }

    public String ib() {
        return this.uA.HiB().ib();
    }

    public boolean kF() {
        return this.uA.HiB().TFd() < 0 || this.uA.HiB().mZN() < 0 || this.uA.HiB().HS() < 0 || this.uA.HiB().tz() < 0;
    }

    public Map<Integer, String> sP() {
        return this.uvD;
    }

    public void sP(float f11) {
        this.HiB = f11;
    }

    public void sP(String str) {
        this.Sj = str;
    }

    public void sP(List<List<Dq>> list) {
        this.f20951aa = list;
    }

    public Map<String, String> sU() {
        return this.Zq;
    }

    public int sef() {
        vS HiB = this.uA.HiB();
        return HiB.db() + HiB.ndK();
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.Sj + "', x=" + this.sP + ", y=" + this.TKC + ", width=" + this.vS + ", height=" + this.Jcg + ", remainWidth=" + this.Dq + ", rootBrick=" + this.uA + ", childrenBrickUnits=" + this.TEQ + '}';
    }

    public float uA() {
        return this.Jcg;
    }

    public float uvD() {
        vS HiB = this.uA.HiB();
        return sef() + HiB.dNu() + HiB.sef() + (HiB.aa() * 2.0f);
    }

    public float vS() {
        return this.sP;
    }

    public void vS(float f11) {
        this.Jcg = f11;
    }

    public boolean zR() {
        return TextUtils.equals(this.uA.HiB().LqL(), "flex");
    }
}
