package com.bytedance.sdk.openadsdk.core.Ym;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.Ym.sP.Sj;
import com.bytedance.sdk.openadsdk.core.Ym.sP.TKC;
import com.bytedance.sdk.openadsdk.core.Ym.sP.sP;
import com.bytedance.sdk.openadsdk.core.model.sU;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class EjP {
    private final Sj Fmk;
    private boolean RiZ;
    private boolean TzV;
    private sU dNu;

    /* renamed from: dx, reason: collision with root package name */
    private String f21122dx;
    private boolean sU;
    private long uvD;
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> Sj = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> sP = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> TKC = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> EjP = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> HiB = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> vS = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> Jcg = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> Dq = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> uA = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> TEQ = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.sP> Ym = new ArrayList();

    /* renamed from: aa, reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.Sj> f21121aa = new ArrayList();
    private final AtomicBoolean sef = new AtomicBoolean(false);
    private final AtomicBoolean Zq = new AtomicBoolean(false);

    public EjP(Sj sj2) {
        this.Fmk = sj2;
    }

    private void Sj(long j11, List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list, com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj sj2) {
        Sj(j11, list, sj2, null);
    }

    private void Sj(long j11, List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list, com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj sj2, TKC.sP sPVar) {
        Sj sj3 = this.Fmk;
        com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(list, sj2, j11, sj3 != null ? sj3.Jcg() : null, sPVar);
    }

    private void Sj(final vS vSVar, final int i11) {
        com.bytedance.sdk.component.utils.uA.sP().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ym.EjP.1
            @Override // java.lang.Runnable
            public void run() {
                vS vSVar2 = vSVar;
                if (vSVar2 != null) {
                    vSVar2.Sj(i11);
                }
            }
        });
    }

    private JSONArray TKC() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.Ym.sP.Sj> it = this.f21121aa.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().Sj());
        }
        return jSONArray;
    }

    private JSONArray sP() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.Ym.sP.sP> it = this.Ym.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().sP());
        }
        return jSONArray;
    }

    private void sP(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            com.bytedance.sdk.openadsdk.EjP.TKC.sP(this.dNu, this.f21122dx, "vast_play_track", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void Dq(long j11) {
        Sj(j11, this.uA, (com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj) null);
    }

    public void Dq(List<com.bytedance.sdk.openadsdk.core.Ym.sP.sP> list) {
        this.Ym.addAll(list);
        Collections.sort(this.Ym);
    }

    public void EjP(long j11) {
        Sj(j11, this.HiB, null, new TKC.sP("video_progress", this.dNu, 1.0f));
    }

    public void EjP(List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        this.HiB.addAll(list);
    }

    public void HiB(long j11) {
        if (this.Zq.compareAndSet(false, true)) {
            Sj(j11, this.vS, (com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj) null);
        }
    }

    public void HiB(List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        this.vS.addAll(list);
    }

    public void Jcg(long j11) {
        Sj(j11, this.Dq, null, new TKC.sP("click", this.dNu));
    }

    public void Jcg(List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        this.Dq.addAll(list);
    }

    public List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> Sj(long j11, float f11) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < this.Ym.size(); i11++) {
            com.bytedance.sdk.openadsdk.core.Ym.sP.sP sPVar = this.Ym.get(i11);
            if (sPVar.Sj(f11)) {
                arrayList.add(sPVar);
            }
        }
        for (int i12 = 0; i12 < this.f21121aa.size(); i12++) {
            com.bytedance.sdk.openadsdk.core.Ym.sP.Sj sj2 = this.f21121aa.get(i12);
            if (sj2.Sj(j11)) {
                arrayList.add(sj2);
            }
        }
        return arrayList;
    }

    public JSONObject Sj() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.Sj));
        jSONObject.put("impressionTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.sP));
        jSONObject.put("pauseTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.TKC));
        jSONObject.put("resumeTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.EjP));
        jSONObject.put("completeTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.HiB));
        jSONObject.put("closeTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.vS));
        jSONObject.put("skipTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.Jcg));
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.Dq));
        jSONObject.put("muteTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.uA));
        jSONObject.put("unMuteTrackers", com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(this.TEQ));
        jSONObject.put("fractionalTrackers", sP());
        jSONObject.put("absoluteTrackers", TKC());
        return jSONObject;
    }

    public void Sj(long j11) {
        if (this.sef.compareAndSet(false, true)) {
            Sj(j11, this.sP, null, new TKC.sP("show_impression", this.dNu));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(long r8, long r10, com.bytedance.sdk.openadsdk.core.Ym.vS r12) {
        /*
            r7 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r7.uvD
            long r0 = r0 - r2
            r2 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto Le
            return
        Le:
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 < 0) goto L87
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 <= 0) goto L87
            long r0 = java.lang.System.currentTimeMillis()
            r7.uvD = r0
            float r0 = (float) r8
            float r10 = (float) r10
            float r0 = r0 / r10
            java.util.List r4 = r7.Sj(r8, r0)
            r10 = 1048576000(0x3e800000, float:0.25)
            int r11 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            r1 = 1
            if (r11 < 0) goto L3f
            boolean r11 = r7.TzV
            if (r11 != 0) goto L3f
            java.lang.String r11 = "firstQuartile"
            r7.sP(r11)
            r7.TzV = r1
            if (r12 == 0) goto L3d
            r11 = 6
            r7.Sj(r12, r11)
        L3d:
            r0 = r10
            goto L70
        L3f:
            r10 = 1056964608(0x3f000000, float:0.5)
            int r11 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r11 < 0) goto L57
            boolean r11 = r7.RiZ
            if (r11 != 0) goto L57
            java.lang.String r11 = "midpoint"
            r7.sP(r11)
            r7.RiZ = r1
            if (r12 == 0) goto L3d
            r11 = 7
            r7.Sj(r12, r11)
            goto L3d
        L57:
            r10 = 1061158912(0x3f400000, float:0.75)
            int r11 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r11 < 0) goto L70
            boolean r11 = r7.sU
            if (r11 != 0) goto L70
            java.lang.String r11 = "thirdQuartile"
            r7.sP(r11)
            r7.sU = r1
            if (r12 == 0) goto L3d
            r11 = 8
            r7.Sj(r12, r11)
            goto L3d
        L70:
            r10 = 1022739087(0x3cf5c28f, float:0.03)
            int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r10 >= 0) goto L78
            r0 = 0
        L78:
            com.bytedance.sdk.openadsdk.core.Ym.sP.TKC$sP r6 = new com.bytedance.sdk.openadsdk.core.Ym.sP.TKC$sP
            java.lang.String r10 = "video_progress"
            com.bytedance.sdk.openadsdk.core.model.sU r11 = r7.dNu
            r6.<init>(r10, r11, r0)
            r5 = 0
            r1 = r7
            r2 = r8
            r1.Sj(r2, r4, r5, r6)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Ym.EjP.Sj(long, long, com.bytedance.sdk.openadsdk.core.Ym.vS):void");
    }

    public void Sj(EjP ejP) {
        TEQ(ejP.Sj);
        Sj(ejP.sP);
        sP(ejP.TKC);
        TKC(ejP.EjP);
        EjP(ejP.HiB);
        HiB(ejP.vS);
        vS(ejP.Jcg);
        Jcg(ejP.Dq);
        Ym(ejP.uA);
        aa(ejP.TEQ);
        Dq(ejP.Ym);
        uA(ejP.f21121aa);
    }

    public void Sj(com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj sj2) {
        Sj(-1L, this.Sj, sj2);
    }

    public void Sj(sU sUVar) {
        this.dNu = sUVar;
    }

    public void Sj(String str) {
        this.f21122dx = str;
    }

    public void Sj(String str, float f11) {
        if (TextUtils.isEmpty(str) || f11 < 0.0f) {
            return;
        }
        Dq(Collections.singletonList(new sP.Sj(str, f11).Sj()));
    }

    public void Sj(String str, long j11) {
        if (TextUtils.isEmpty(str) || j11 < 0) {
            return;
        }
        uA(Collections.singletonList(new Sj.C0276Sj(str, j11).Sj()));
    }

    public void Sj(List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        this.sP.addAll(list);
    }

    public void Sj(JSONObject jSONObject) {
        TEQ(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(jSONObject.optJSONArray("errorTrackers")));
        Sj(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(jSONObject.optJSONArray("impressionTrackers")));
        sP(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(jSONObject.optJSONArray("pauseTrackers"), true));
        TKC(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(jSONObject.optJSONArray("resumeTrackers"), true));
        EjP(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(jSONObject.optJSONArray("completeTrackers")));
        HiB(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(jSONObject.optJSONArray("closeTrackers")));
        vS(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(jSONObject.optJSONArray("skipTrackers")));
        Jcg(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(jSONObject.optJSONArray("clickTrackers")));
        Ym(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(jSONObject.optJSONArray("muteTrackers"), true));
        aa(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.Sj(jSONObject.optJSONArray("unMuteTrackers"), true));
        Dq(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.sP(jSONObject.optJSONArray("fractionalTrackers")));
        uA(com.bytedance.sdk.openadsdk.core.Ym.sP.TKC.TKC(jSONObject.optJSONArray("absoluteTrackers")));
    }

    public void TEQ(List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        this.Sj.addAll(list);
    }

    public void TKC(long j11) {
        Sj(j11, this.EjP, (com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj) null);
    }

    public void TKC(List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        this.EjP.addAll(list);
    }

    public void Ym(List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        this.uA.addAll(list);
    }

    public void aa(List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        this.TEQ.addAll(list);
    }

    public void sP(long j11) {
        Sj(j11, this.TKC, (com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj) null);
    }

    public void sP(List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        this.TKC.addAll(list);
    }

    public void uA(long j11) {
        Sj(j11, this.TEQ, (com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj) null);
    }

    public void uA(List<com.bytedance.sdk.openadsdk.core.Ym.sP.Sj> list) {
        this.f21121aa.addAll(list);
        Collections.sort(this.f21121aa);
    }

    public void vS(long j11) {
        Sj(j11, this.Jcg, (com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj) null);
    }

    public void vS(List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list) {
        this.Jcg.addAll(list);
    }
}
