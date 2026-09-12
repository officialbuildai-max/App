package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.adsdk.ugeno.core.HiB;
import com.bytedance.adsdk.ugeno.sP.Sj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class uA {
    private HiB Dq;
    private vS EjP;
    private com.bytedance.adsdk.ugeno.EjP.Sj.Sj Fmk;
    private aa HiB;
    private Fmk Jcg;
    private Context Sj;
    private Dq TEQ;
    private com.bytedance.adsdk.ugeno.sP.TKC<View> TKC;
    private List<String> Zq;
    private JSONObject sP;
    private boolean sef;
    private String uA;
    private Zq vS;
    private boolean Ym = true;

    /* renamed from: aa, reason: collision with root package name */
    private boolean f20903aa = false;

    public uA(Context context) {
        this.Sj = context;
    }

    private void Sj(com.bytedance.adsdk.ugeno.sP.TKC<View> tkc) {
        List<com.bytedance.adsdk.ugeno.sP.TKC<View>> uA;
        if (tkc == null) {
            return;
        }
        JSONObject kF = tkc.kF();
        Iterator<String> keys = kF.keys();
        com.bytedance.adsdk.ugeno.sP.Sj fF = tkc.fF();
        Sj.C0212Sj TEQ = fF != null ? fF.TEQ() : null;
        sP(tkc);
        while (keys.hasNext()) {
            String next = keys.next();
            String Sj = com.bytedance.adsdk.ugeno.TKC.sP.Sj(kF.optString(next), this.sP);
            tkc.Sj(next, Sj);
            if (TEQ != null) {
                TEQ.Sj(this.Sj, next, Sj);
            }
        }
        tkc.Sj(this.EjP);
        tkc.Sj(this.HiB);
        tkc.Sj(this.Jcg);
        if ((tkc instanceof com.bytedance.adsdk.ugeno.sP.Sj) && (uA = ((com.bytedance.adsdk.ugeno.sP.Sj) tkc).uA()) != null && uA.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.sP.TKC<View>> it = uA.iterator();
            while (it.hasNext()) {
                Sj(it.next());
            }
        }
        if (TEQ != null) {
            tkc.Sj(TEQ.Sj());
        }
        tkc.sP();
    }

    private void sP(com.bytedance.adsdk.ugeno.sP.TKC tkc) {
        try {
            if (!tkc.LD() || tkc.Yf() == null || tkc.Yf().vS() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", tkc.Yf().vS());
            this.sP.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    public com.bytedance.adsdk.ugeno.sP.TKC<View> Sj(HiB.Sj sj2, com.bytedance.adsdk.ugeno.sP.TKC<View> tkc) {
        List<HiB.Sj> TKC;
        Sj.C0212Sj c0212Sj = null;
        if (!HiB.Sj(sj2)) {
            return null;
        }
        String TKC2 = sj2.TKC();
        sP Sj = EjP.Sj(TKC2);
        sP sPVar = Sj;
        if (Sj == null) {
            this.sef = true;
            if (this.Zq == null) {
                this.Zq = new ArrayList();
            }
            this.Zq.add(TKC2);
            TKC2 = "View";
            sj2.Sj("View");
            sP Sj2 = EjP.Sj("View");
            sPVar = Sj2;
            if (Sj2 == null) {
                "not found component ".concat("View");
                return null;
            }
        }
        com.bytedance.adsdk.ugeno.sP.TKC Sj3 = sPVar.Sj(this.Sj);
        if (Sj3 == null) {
            return null;
        }
        JSONObject EjP = sj2.EjP();
        Sj3.HiB(com.bytedance.adsdk.ugeno.TKC.sP.Sj(sj2.Sj(), this.sP));
        Sj3.vS(TKC2);
        Sj3.TKC(EjP);
        Sj3.Sj(sj2);
        Sj3.sP(this.sP);
        HiB hiB = this.Dq;
        if (hiB == null) {
            Sj3.Sj(true);
        } else {
            Sj3.Sj(hiB.EjP());
        }
        Sj3.Sj(this.TEQ);
        Sj3.Sj(this.Fmk);
        Iterator<String> keys = EjP.keys();
        if (tkc instanceof com.bytedance.adsdk.ugeno.sP.Sj) {
            com.bytedance.adsdk.ugeno.sP.Sj sj3 = (com.bytedance.adsdk.ugeno.sP.Sj) tkc;
            c0212Sj = sj3.TEQ();
            Sj3.Sj(sj3);
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String Sj4 = com.bytedance.adsdk.ugeno.TKC.sP.Sj(EjP.optString(next), this.sP);
            Sj3.Sj(next, Sj4);
            if (c0212Sj != null) {
                c0212Sj.Sj(this.Sj, next, Sj4);
            }
        }
        if (c0212Sj != null) {
            Sj3.Sj(c0212Sj.Sj());
        }
        if (Sj3 instanceof com.bytedance.adsdk.ugeno.sP.Sj) {
            List<HiB.Sj> HiB = sj2.HiB();
            if (HiB == null || HiB.size() <= 0) {
                if (TextUtils.equals(Sj3.WMZ(), "RecyclerLayout") && (TKC = this.Dq.TKC()) != null && TKC.size() > 0) {
                    Iterator<HiB.Sj> it = TKC.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.sP.TKC<View> Sj5 = Sj(it.next(), (com.bytedance.adsdk.ugeno.sP.TKC<View>) Sj3);
                        if (Sj5 != null && Sj5.Wjd()) {
                            ((com.bytedance.adsdk.ugeno.sP.Sj) Sj3).Sj(Sj5);
                        }
                    }
                }
                return Sj3;
            }
            if (TextUtils.equals(Sj3.WMZ(), "Swiper") && HiB.size() != 1) {
                Log.e("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<HiB.Sj> it2 = HiB.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.sP.TKC<View> Sj6 = Sj(it2.next(), (com.bytedance.adsdk.ugeno.sP.TKC<View>) Sj3);
                if (Sj6 != null && !Sj6.UHs()) {
                    ((com.bytedance.adsdk.ugeno.sP.Sj) Sj3).Sj(Sj6, Sj6.ley());
                }
            }
        }
        this.TKC = Sj3;
        return Sj3;
    }

    public com.bytedance.adsdk.ugeno.sP.TKC<View> Sj(HiB.Sj sj2, JSONObject jSONObject, JSONObject jSONObject2) {
        this.sP = jSONObject;
        Zq zq2 = this.vS;
        if (zq2 != null) {
            zq2.Sj();
        }
        this.Fmk = new com.bytedance.adsdk.ugeno.EjP.Sj.Sj();
        if (this.HiB instanceof com.bytedance.adsdk.ugeno.core.Sj.sP) {
            throw null;
        }
        this.TKC = Sj(sj2, (com.bytedance.adsdk.ugeno.sP.TKC<View>) null);
        Zq zq3 = this.vS;
        if (zq3 != null) {
            zq3.sP();
            this.TKC.Sj(this.vS);
        }
        Sj(this.TKC);
        return this.TKC;
    }

    public com.bytedance.adsdk.ugeno.sP.TKC<View> Sj(JSONObject jSONObject) {
        Zq zq2 = this.vS;
        if (zq2 != null) {
            zq2.Sj();
        }
        HiB hiB = new HiB(jSONObject, this.sP);
        this.Dq = hiB;
        if (this.HiB instanceof com.bytedance.adsdk.ugeno.core.Sj.sP) {
            hiB.sP();
            throw null;
        }
        this.TKC = sP(hiB.Sj(), null);
        Zq zq3 = this.vS;
        if (zq3 != null) {
            zq3.sP();
            this.TKC.Sj(this.vS);
        }
        return this.TKC;
    }

    public com.bytedance.adsdk.ugeno.sP.TKC<View> Sj(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.sP = jSONObject2;
        Zq zq2 = this.vS;
        if (zq2 != null) {
            zq2.Sj();
        }
        this.Dq = new HiB(jSONObject, jSONObject2, jSONObject3);
        this.Fmk = new com.bytedance.adsdk.ugeno.EjP.Sj.Sj();
        if (this.HiB instanceof com.bytedance.adsdk.ugeno.core.Sj.sP) {
            this.Dq.sP();
            throw null;
        }
        this.TKC = Sj(this.Dq.Sj(), (com.bytedance.adsdk.ugeno.sP.TKC<View>) null);
        Zq zq3 = this.vS;
        if (zq3 != null) {
            zq3.sP();
            this.TKC.Sj(this.vS);
        }
        Sj(this.TKC);
        return this.TKC;
    }

    public void Sj(Fmk fmk) {
        this.Jcg = fmk;
    }

    public void Sj(aa aaVar) {
        com.bytedance.adsdk.ugeno.core.Sj.Sj HiB = com.bytedance.adsdk.ugeno.HiB.Sj().HiB();
        if (HiB == null) {
            this.HiB = aaVar;
        } else {
            if (HiB.Sj(aaVar) != null) {
                throw null;
            }
            this.HiB = aaVar;
        }
    }

    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc, JSONObject jSONObject) {
        if (tkc == null) {
            return;
        }
        if (!(tkc instanceof com.bytedance.adsdk.ugeno.sP.Sj)) {
            tkc.Sj(jSONObject);
            return;
        }
        tkc.Sj(jSONObject);
        List<com.bytedance.adsdk.ugeno.sP.TKC<View>> uA = ((com.bytedance.adsdk.ugeno.sP.Sj) tkc).uA();
        if (uA == null || uA.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.sP.TKC<View>> it = uA.iterator();
        while (it.hasNext()) {
            Sj(it.next(), jSONObject);
        }
    }

    public void Sj(String str, Dq dq2) {
        this.TEQ = dq2;
        this.uA = str;
        if (dq2 != null) {
            this.sP = dq2.Sj();
        }
    }

    public boolean Sj() {
        return this.sef;
    }

    public com.bytedance.adsdk.ugeno.sP.TKC<View> sP(HiB.Sj sj2, com.bytedance.adsdk.ugeno.sP.TKC<View> tkc) {
        List<HiB.Sj> TKC;
        Sj.C0212Sj c0212Sj = null;
        if (!HiB.Sj(sj2)) {
            return null;
        }
        String TKC2 = sj2.TKC();
        sP Sj = EjP.Sj(TKC2);
        if (Sj == null) {
            "not found component ".concat(String.valueOf(TKC2));
            this.sef = true;
            if (this.Zq == null) {
                this.Zq = new ArrayList();
            }
            this.Zq.add(TKC2);
            return null;
        }
        com.bytedance.adsdk.ugeno.sP.TKC Sj2 = Sj.Sj(this.Sj);
        if (Sj2 == null) {
            return null;
        }
        Sj2.HiB(com.bytedance.adsdk.ugeno.TKC.sP.Sj(sj2.Sj(), this.sP));
        Sj2.vS(TKC2);
        Sj2.TKC(sj2.EjP());
        Sj2.Sj(sj2);
        Sj2.Sj(this.TEQ);
        if (tkc instanceof com.bytedance.adsdk.ugeno.sP.Sj) {
            com.bytedance.adsdk.ugeno.sP.Sj sj3 = (com.bytedance.adsdk.ugeno.sP.Sj) tkc;
            Sj2.Sj(sj3);
            c0212Sj = sj3.TEQ();
        }
        Iterator<String> keys = sj2.EjP().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String Sj3 = com.bytedance.adsdk.ugeno.TKC.sP.Sj(sj2.EjP().optString(next), this.sP);
            Sj2.Sj(next, Sj3);
            if (c0212Sj != null) {
                c0212Sj.Sj(this.Sj, next, Sj3);
            }
        }
        if (Sj2 instanceof com.bytedance.adsdk.ugeno.sP.Sj) {
            List<HiB.Sj> HiB = sj2.HiB();
            if (HiB == null || HiB.size() <= 0) {
                if (TextUtils.equals(Sj2.WMZ(), "RecyclerLayout") && (TKC = this.Dq.TKC()) != null && TKC.size() > 0) {
                    Iterator<HiB.Sj> it = TKC.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.sP.TKC<View> sP = sP(it.next(), Sj2);
                        if (sP != null && sP.Wjd()) {
                            ((com.bytedance.adsdk.ugeno.sP.Sj) Sj2).Sj(sP);
                        }
                    }
                }
                return Sj2;
            }
            if (TextUtils.equals(Sj2.WMZ(), "Swiper") && HiB.size() != 1) {
                Log.e("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<HiB.Sj> it2 = HiB.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.sP.TKC<View> sP2 = sP(it2.next(), Sj2);
                if (sP2 != null && sP2.Wjd()) {
                    ((com.bytedance.adsdk.ugeno.sP.Sj) Sj2).Sj(sP2);
                }
            }
        }
        if (c0212Sj != null) {
            Sj2.Sj(c0212Sj.Sj());
        }
        this.TKC = Sj2;
        return Sj2;
    }

    public List<String> sP() {
        return this.Zq;
    }

    public void sP(JSONObject jSONObject) {
        Zq zq2 = this.vS;
        if (zq2 != null) {
            zq2.TKC();
        }
        this.sP = jSONObject;
        Sj(this.TKC, jSONObject);
        Sj(this.TKC);
        if (this.vS != null) {
            sef sefVar = new sef();
            sefVar.Sj(0);
            sefVar.Sj(this.TKC);
            this.vS.Sj(sefVar);
        }
    }
}
