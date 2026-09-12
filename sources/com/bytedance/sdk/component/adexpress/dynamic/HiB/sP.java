package com.bytedance.sdk.component.adexpress.dynamic.HiB;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.sP.Fmk;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class sP {
    private String Dq;
    private double HiB;
    private double Jcg;
    private Fmk uA;
    private int vS;
    public Map<String, TKC> Sj = new HashMap();
    public Map<String, TKC> sP = new HashMap();
    public Map<String, TKC> TKC = new HashMap();
    private double EjP = Math.random();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Sj implements Cloneable {
        float Sj;
        float TKC;
        boolean sP;

        Sj() {
        }

        public Object clone() {
            try {
                return (Sj) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TKC {
        float Sj;
        float sP;

        public TKC() {
        }

        public TKC(float f11, float f12) {
            this.Sj = f11;
            this.sP = f12;
        }

        public String toString() {
            return "UnitSize{width=" + this.Sj + ", height=" + this.sP + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$sP, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0226sP {
        double EjP;
        float HiB;
        float Sj;
        int TKC;
        int sP;

        C0226sP() {
        }

        static JSONObject Sj(C0226sP c0226sP) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_SIZE, c0226sP.Sj);
                jSONObject.put("letterSpacing", c0226sP.sP);
                jSONObject.put("lineHeight", c0226sP.EjP);
                jSONObject.put("maxWidth", c0226sP.HiB);
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_WEIGHT, c0226sP.TKC);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public sP(double d11, int i11, double d12, String str, Fmk fmk) {
        this.HiB = d11;
        this.vS = i11;
        this.Jcg = d12;
        this.Dq = str;
        this.uA = fmk;
    }

    private String EjP(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String TKC2 = list.get(i11).TKC();
            if (i11 < list.size() - 1) {
                sb2.append(TKC2);
                sb2.append("-");
            } else {
                sb2.append(TKC2);
            }
        }
        return sb2.toString();
    }

    private void EjP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        this.Sj.remove(HiB(dq2));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu = dq2.dNu();
        if (dNu == null || dNu.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> it = dNu.iterator();
        while (it.hasNext()) {
            TKC(it.next());
        }
    }

    private TKC HiB(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2, float f11, float f12) {
        String str = dq2.TKC() + "_" + f11 + "_" + f12;
        if (this.TKC.containsKey(str)) {
            return this.TKC.get(str);
        }
        TKC vS = vS(dq2, f11, f12);
        this.TKC.put(str, vS);
        return vS;
    }

    private String HiB(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        return dq2.TKC();
    }

    private TKC Sj(String str, C0226sP c0226sP, boolean z10, boolean z11, int i11, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        return Ym.Sj(str, dq2.TEQ().sP(), C0226sP.Sj(c0226sP).toString(), z10, z11, i11, dq2, this.HiB, this.vS, this.Jcg, this.Dq, this.uA);
    }

    private void Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2, TKC tkc) {
        this.Sj.put(HiB(dq2), tkc);
    }

    private void Sj(List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> list, float f11, float f12) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> it = list.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (Sj(it.next(), false)) {
                z10 = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list2 : list) {
            Sj sj2 = new Sj();
            boolean Sj2 = Sj(list2, !z10);
            sj2.Sj = Sj2 ? 1.0f : sP(list2, f11, f12).sP;
            sj2.sP = !Sj2;
            arrayList.add(sj2);
        }
        List<Sj> Sj3 = TEQ.Sj(f12, arrayList);
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (((Sj) arrayList.get(i11)).Sj != Sj3.get(i11).Sj) {
                List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list3 = list.get(i11);
                TKC(list3);
                sP(list3, f11, Sj3.get(i11).Sj);
            }
        }
    }

    private void Sj(List<Sj> list, float f11, List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list2) {
        float f12 = 0.0f;
        for (Sj sj2 : list) {
            if (sj2.sP) {
                f12 += sj2.Sj;
            }
        }
        if (f12 > f11) {
            int i11 = 0;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                if (list.get(i12).sP && list2.get(i12).zR()) {
                    i11++;
                }
            }
            if (i11 > 0) {
                float ceil = (float) (Math.ceil(((f12 - f11) / i11) * 1000.0f) / 1000.0d);
                for (int i13 = 0; i13 < list2.size(); i13++) {
                    Sj sj3 = list.get(i13);
                    if (sj3.sP && list2.get(i13).zR()) {
                        sj3.Sj -= ceil;
                    }
                }
            }
        }
    }

    private void Sj(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list, TKC tkc) {
        this.sP.put(EjP(list), tkc);
    }

    private boolean Sj(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list, boolean z10) {
        for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2 : list) {
            com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB = dq2.TEQ().HiB();
            String ley = HiB.ley();
            if (TextUtils.equals(ley, "flex") || (z10 && ((TextUtils.equals(HiB.LqL(), "flex") && TextUtils.equals(HiB.ley(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.EjP.HiB.Sj.get(dq2.TEQ().sP()).intValue() == 7) || TextUtils.equals(ley, "flex")))) {
                return true;
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it = list.iterator();
        while (it.hasNext()) {
            if (TKC(it.next())) {
                return true;
            }
        }
        return false;
    }

    private TKC TKC(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list, float f11, float f12) {
        float f13;
        EjP(list);
        TKC tkc = new TKC();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2 : list) {
            com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB = dq2.TEQ().HiB();
            if (HiB.EZ() == 1 || HiB.EZ() == 2) {
                arrayList.add(dq2);
            }
            if (HiB.EZ() != 1 && HiB.EZ() != 2) {
                arrayList2.add(dq2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TKC((com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq) it.next(), f11, f12);
        }
        if (arrayList2.size() <= 0) {
            return tkc;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(TKC(it2.next(), f11, f12).Sj));
        }
        ArrayList arrayList4 = new ArrayList();
        int i11 = 0;
        while (true) {
            if (i11 >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq3 = arrayList2.get(i11);
            String LqL = dq3.TEQ().HiB().LqL();
            float Dq = dq3.Dq();
            boolean equals = TextUtils.equals(LqL, "flex");
            if (TextUtils.equals(LqL, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu = dq3.dNu();
                if (dNu != null && dNu.size() > 0) {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> it3 = dNu.iterator();
                    while (it3.hasNext()) {
                        if (sP(it3.next())) {
                            equals = true;
                            break;
                        }
                    }
                }
                equals = false;
            }
            Sj sj2 = new Sj();
            if (!equals) {
                Dq = ((Float) arrayList3.get(i11)).floatValue();
            }
            sj2.Sj = Dq;
            sj2.sP = !equals;
            if (equals) {
                f13 = ((Float) arrayList3.get(i11)).floatValue();
            }
            sj2.TKC = f13;
            arrayList4.add(sj2);
            i11++;
        }
        Sj(arrayList4, f11, arrayList2);
        List<Sj> Sj2 = TEQ.Sj(f11, arrayList4);
        float f14 = 0.0f;
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            f14 += Sj2.get(i12).Sj;
            if (((Float) arrayList3.get(i12)).floatValue() != Sj2.get(i12).Sj) {
                EjP(arrayList2.get(i12));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it4 = arrayList2.iterator();
        int i13 = 0;
        boolean z10 = false;
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            i13++;
            if (!sP(it4.next())) {
                z10 = false;
                break;
            }
            if (i13 == arrayList2.size()) {
                z10 = true;
            }
        }
        f13 = z10 ? f12 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i14 = 0; i14 < arrayList2.size(); i14++) {
            com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq4 = arrayList2.get(i14);
            TKC TKC2 = TKC(dq4, Sj2.get(i14).Sj, f12);
            if (!sP(dq4)) {
                f13 = Math.max(f13, TKC2.sP);
            }
            arrayList5.add(TKC2);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((TKC) it5.next()).sP));
        }
        if (!z10) {
            for (int i15 = 0; i15 < arrayList2.size(); i15++) {
                com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq5 = arrayList2.get(i15);
                if (sP(dq5) && ((Float) arrayList6.get(i15)).floatValue() != f13) {
                    EjP(dq5);
                    TKC(dq5, Sj2.get(i15).Sj, f13);
                }
            }
        }
        tkc.Sj = f14;
        tkc.sP = f13;
        return tkc;
    }

    private void TKC(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.sP.remove(EjP(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it = list.iterator();
        while (it.hasNext()) {
            EjP(it.next());
        }
    }

    private boolean TKC(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu;
        if (!dq2.TzV() && TextUtils.equals(dq2.TEQ().HiB().ley(), "auto") && (dNu = dq2.dNu()) != null && dNu.size() > 0) {
            if (dNu.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it = dNu.get(0).iterator();
                while (it.hasNext()) {
                    if (!sP(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> it2 = dNu.iterator();
            while (it2.hasNext()) {
                if (Sj(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private TKC sP(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list, float f11, float f12) {
        TKC Sj2 = Sj(list);
        if (Sj2 != null && (Sj2.Sj != 0.0f || Sj2.sP != 0.0f)) {
            return Sj2;
        }
        TKC TKC2 = TKC(list, f11, f12);
        Sj(list, TKC2);
        return TKC2;
    }

    private boolean sP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        if (dq2 == null) {
            return false;
        }
        if (TextUtils.equals(dq2.TEQ().HiB().ley(), "flex")) {
            return true;
        }
        return TKC(dq2);
    }

    private boolean sP(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>> dNu;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().TEQ().HiB().LqL(), "flex")) {
                return true;
            }
        }
        while (true) {
            boolean z10 = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2 : list) {
                if (TextUtils.equals(dq2.TEQ().HiB().LqL(), "auto") && (dNu = dq2.dNu()) != null) {
                    int i11 = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list2 : dNu) {
                        i11++;
                        if (!sP(list2)) {
                            break;
                        }
                        if (i11 == list2.size()) {
                            z10 = true;
                        }
                    }
                }
            }
            return z10;
        }
    }

    private TKC vS(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2, float f11, float f12) {
        new TKC();
        com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB = dq2.TEQ().HiB();
        dq2.TEQ().TKC();
        HiB.MuB();
        float TzV = HiB.TzV();
        int sdp = HiB.sdp();
        double dwU = HiB.dwU();
        int IOh = HiB.IOh();
        boolean HpB = HiB.HpB();
        boolean pfr = HiB.pfr();
        int xhi = HiB.xhi();
        C0226sP c0226sP = new C0226sP();
        c0226sP.Sj = TzV;
        c0226sP.sP = sdp;
        c0226sP.TKC = IOh;
        c0226sP.EjP = dwU;
        c0226sP.HiB = f11;
        return Sj(dq2.TEQ().TKC(), c0226sP, HpB, pfr, xhi, dq2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.adexpress.dynamic.HiB.sP.TKC EjP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq r21, float r22, float r23) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.HiB.sP.EjP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq, float, float):com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC");
    }

    public TKC Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        return this.Sj.get(HiB(dq2));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.adexpress.dynamic.HiB.sP.TKC Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq r13, float r14, float r15) {
        /*
            r12 = this;
            com.bytedance.sdk.component.adexpress.dynamic.EjP.HiB r0 = r13.TEQ()
            java.lang.String r0 = r0.TKC()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L23
            com.bytedance.sdk.component.adexpress.dynamic.EjP.HiB r0 = r13.TEQ()
            com.bytedance.sdk.component.adexpress.dynamic.EjP.vS r0 = r0.HiB()
            java.lang.String r0 = r0.kb()
            if (r0 != 0) goto L23
            com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC r13 = new com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC
            r13.<init>(r1, r1)
            return r13
        L23:
            com.bytedance.sdk.component.adexpress.dynamic.EjP.HiB r0 = r13.TEQ()
            java.lang.String r0 = r0.sP()
            java.lang.String r2 = "creative-playable-bait"
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L39
            com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC r13 = new com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC
            r13.<init>(r1, r1)
            return r13
        L39:
            float r0 = r13.Dq()
            float r1 = r13.uA()
            com.bytedance.sdk.component.adexpress.dynamic.EjP.HiB r2 = r13.TEQ()
            com.bytedance.sdk.component.adexpress.dynamic.EjP.vS r2 = r2.HiB()
            java.lang.String r3 = r2.LqL()
            java.lang.String r2 = r2.ley()
            int r4 = r13.Fmk()
            float r4 = (float) r4
            int r5 = r13.sef()
            float r5 = (float) r5
            float r6 = r13.Zq()
            float r7 = r13.uvD()
            java.lang.String r8 = "fixed"
            boolean r9 = android.text.TextUtils.equals(r3, r8)
            java.lang.String r10 = "flex"
            java.lang.String r11 = "auto"
            if (r9 == 0) goto L86
            float r14 = java.lang.Math.min(r0, r14)
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Lb7
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC r13 = r12.sP(r13, r0, r1)
            float r13 = r13.sP
        L83:
            float r1 = r13 + r7
            goto Lb7
        L86:
            boolean r9 = android.text.TextUtils.equals(r3, r11)
            if (r9 == 0) goto L9f
            float r14 = r14 - r6
            float r0 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC r13 = r12.sP(r13, r14, r0)
            float r14 = r13.Sj
            float r14 = r14 + r6
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Lb7
            float r13 = r13.sP
            goto L83
        L9f:
            boolean r3 = android.text.TextUtils.equals(r3, r10)
            if (r3 == 0) goto Lb6
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Lb7
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC r13 = r12.sP(r13, r0, r1)
            float r13 = r13.sP
            goto L83
        Lb6:
            r14 = r0
        Lb7:
            java.lang.String r13 = "scale"
            boolean r13 = android.text.TextUtils.equals(r2, r13)
            if (r13 == 0) goto Ld9
            float r13 = r14 - r4
            float r13 = r13 / r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r13 = r13 + r5
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 <= 0) goto Ld7
            float r13 = r15 - r5
            float r13 = r13 * r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r14 = r13 + r4
            goto Led
        Ld7:
            r15 = r13
            goto Led
        Ld9:
            boolean r13 = android.text.TextUtils.equals(r2, r8)
            if (r13 == 0) goto Le5
            float r1 = r1 + r5
            float r15 = java.lang.Math.min(r1, r15)
            goto Led
        Le5:
            boolean r13 = android.text.TextUtils.equals(r2, r10)
            if (r13 == 0) goto Lec
            goto Led
        Lec:
            r15 = r1
        Led:
            com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC r13 = new com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC
            r13.<init>()
            r13.Sj = r14
            r13.sP = r15
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.HiB.sP.Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq, float, float):com.bytedance.sdk.component.adexpress.dynamic.HiB.sP$TKC");
    }

    public TKC Sj(List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq> list) {
        return this.sP.get(EjP(list));
    }

    public void Sj() {
        this.TKC.clear();
        this.Sj.clear();
        this.sP.clear();
    }

    public TKC TKC(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2, float f11, float f12) {
        if (dq2 == null) {
            return null;
        }
        TKC Sj2 = Sj(dq2);
        if (Sj2 != null && (Sj2.Sj != 0.0f || Sj2.sP != 0.0f)) {
            return Sj2;
        }
        TKC EjP = EjP(dq2, f11, f12);
        Sj(dq2, EjP);
        return EjP;
    }

    public TKC sP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2, float f11, float f12) {
        TKC tkc = new TKC();
        if (dq2.TEQ().HiB() == null) {
            return tkc;
        }
        TKC HiB = HiB(dq2, f11, f12);
        float f13 = HiB.Sj;
        float f14 = HiB.sP;
        tkc.Sj = Math.min(f13, f11);
        tkc.sP = Math.min(f14, f12);
        return tkc;
    }
}
