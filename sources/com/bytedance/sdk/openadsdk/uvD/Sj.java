package com.bytedance.sdk.openadsdk.uvD;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.sU;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Sj implements Comparable<Sj> {
    private int HiB;
    private int Jcg;
    private int TKC;
    private final String sP;
    private long sef;
    private final ArrayList<Long> Sj = new ArrayList<>();
    private final ArrayList<Long> EjP = new ArrayList<>();
    private final ArrayList<Long> vS = new ArrayList<>();
    private final ArrayList<Long> Dq = new ArrayList<>();
    private final HashMap<String, sP> uA = new HashMap<>();
    private int TEQ = 0;
    private int Ym = 0;

    /* renamed from: aa, reason: collision with root package name */
    private final HashMap<String, sP> f21222aa = new HashMap<>();
    private int Fmk = 0;
    private final ArrayList<String> Zq = new ArrayList<>();

    public Sj(String str) {
        this.sP = str;
    }

    private void Sj(String str, JSONObject jSONObject, ArrayList<Long> arrayList, int[] iArr, long j11, JSONObject jSONObject2) throws JSONException {
        int size = arrayList.size() - 1;
        int i11 = 0;
        for (int i12 : iArr) {
            long j12 = j11 - (i12 * 60000);
            while (size >= 0 && arrayList.get(size).longValue() >= j12) {
                i11++;
                size--;
            }
            if (i11 != 0) {
                jSONObject.put(str + i12, i11);
                int optInt = jSONObject2.optInt(str + i12) + i11;
                if (optInt != 0) {
                    jSONObject2.put(str + i12, optInt);
                }
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void Sj(@NonNull JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i11;
        int i12;
        int i13;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Sj("show_c_", jSONObject, this.Sj, com.bytedance.sdk.openadsdk.vS.Sj.Sj().uA(), elapsedRealtime, jSONObject2);
        Sj("click_c_", jSONObject, this.EjP, com.bytedance.sdk.openadsdk.vS.Sj.Sj().TEQ(), elapsedRealtime, jSONObject2);
        Sj("v_play_c_", jSONObject, this.vS, com.bytedance.sdk.openadsdk.vS.Sj.Sj().Ym(), elapsedRealtime, jSONObject2);
        Sj("dislike_c_", jSONObject, this.Dq, com.bytedance.sdk.openadsdk.vS.Sj.Sj().uvD(), elapsedRealtime, jSONObject2);
        if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().vS() && (i13 = this.TKC) != 0) {
            jSONObject.put("show_c_s", i13);
            int optInt = jSONObject2.optInt("show_c_s") + this.TKC;
            if (optInt != 0) {
                jSONObject2.put("show_c_s", optInt);
            }
        }
        if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().Jcg() && (i12 = this.HiB) != 0) {
            jSONObject.put("click_c_s", i12);
            int optInt2 = jSONObject2.optInt("click_c_s") + this.HiB;
            if (optInt2 != 0) {
                jSONObject2.put("click_c_s", optInt2);
            }
        }
        if (!com.bytedance.sdk.openadsdk.vS.Sj.Sj().Dq() || (i11 = this.Jcg) == 0) {
            return;
        }
        jSONObject.put("v_play_c_s", i11);
        int optInt3 = jSONObject2.optInt("v_play_c_s") + this.Jcg;
        if (optInt3 != 0) {
            jSONObject2.put("v_play_c_s", optInt3);
        }
    }

    private void sP(@NonNull JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i11;
        int i12;
        int i13;
        long j11;
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        int[] aa2 = com.bytedance.sdk.openadsdk.vS.Sj.Sj().aa();
        long j12 = 60000;
        if (aa2 != null) {
            int i14 = 0;
            while (i14 < aa2.length) {
                int i15 = aa2[i14];
                long j13 = elapsedRealtime - (i15 * j12);
                Iterator<String> it = this.f21222aa.keySet().iterator();
                long j14 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator<String> it2 = it;
                    sP sPVar = this.f21222aa.get(next);
                    if (sPVar != null) {
                        long Sj = sPVar.Sj(j13, elapsedRealtime);
                        j14 += Sj;
                        if (Sj <= 0 && i14 == aa2.length - 1) {
                            hashSet4.add(next);
                        }
                    }
                    it = it2;
                }
                if (j14 != 0) {
                    jSONObject.put("lp_stay_t_".concat(String.valueOf(i15)), j14);
                    hashSet2 = hashSet4;
                    hashSet3 = hashSet5;
                    long optInt = jSONObject2.optInt("lp_stay_t_".concat(String.valueOf(i15))) + j14;
                    if (optInt != 0) {
                        jSONObject2.put("lp_stay_t_".concat(String.valueOf(i15)), optInt);
                    }
                } else {
                    hashSet2 = hashSet4;
                    hashSet3 = hashSet5;
                }
                i14++;
                hashSet4 = hashSet2;
                hashSet5 = hashSet3;
                j12 = 60000;
            }
        }
        HashSet hashSet6 = hashSet4;
        HashSet hashSet7 = hashSet5;
        int[] Fmk = com.bytedance.sdk.openadsdk.vS.Sj.Sj().Fmk();
        if (Fmk != null) {
            int i16 = 0;
            while (i16 < Fmk.length) {
                int i17 = Fmk[i16];
                long j15 = elapsedRealtime - (i17 * 60000);
                Iterator<String> it3 = this.uA.keySet().iterator();
                int i18 = 0;
                long j16 = 0;
                while (it3.hasNext()) {
                    String next2 = it3.next();
                    Iterator<String> it4 = it3;
                    sP sPVar2 = this.uA.get(next2);
                    if (sPVar2 != null) {
                        long Sj2 = sPVar2.Sj(j15, elapsedRealtime);
                        j16 += Sj2;
                        if (Sj2 > DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) {
                            i18++;
                        }
                        if (Sj2 <= 0 && i16 == Fmk.length - 1) {
                            hashSet = hashSet7;
                            hashSet.add(next2);
                            hashSet7 = hashSet;
                            it3 = it4;
                        }
                    }
                    hashSet = hashSet7;
                    hashSet7 = hashSet;
                    it3 = it4;
                }
                HashSet hashSet8 = hashSet7;
                if (j16 != 0) {
                    jSONObject.put("v_stay_t_".concat(String.valueOf(i17)), j16);
                    j11 = elapsedRealtime;
                    long optInt2 = jSONObject2.optInt("v_stay_t_".concat(String.valueOf(i17))) + j16;
                    if (optInt2 != 0) {
                        jSONObject2.put("v_stay_t_".concat(String.valueOf(i17)), optInt2);
                    }
                } else {
                    j11 = elapsedRealtime;
                }
                if (i18 != 0) {
                    jSONObject.put("v_20s_play_c_".concat(String.valueOf(i17)), i18);
                    int optInt3 = jSONObject2.optInt("v_20s_play_c_".concat(String.valueOf(i17))) + i18;
                    if (optInt3 != 0) {
                        jSONObject2.put("v_20s_play_c_".concat(String.valueOf(i17)), optInt3);
                    }
                }
                i16++;
                hashSet7 = hashSet8;
                elapsedRealtime = j11;
            }
        }
        HashSet hashSet9 = hashSet7;
        if (!hashSet6.isEmpty()) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                this.f21222aa.remove((String) it5.next());
            }
        }
        if (!hashSet9.isEmpty()) {
            Iterator it6 = hashSet9.iterator();
            while (it6.hasNext()) {
                this.uA.remove((String) it6.next());
            }
        }
        if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().Zq() && (i13 = this.TEQ) != 0) {
            jSONObject.put("v_stay_t_s", i13);
            int optInt4 = jSONObject2.optInt("v_stay_t_s") + this.TEQ;
            if (optInt4 != 0) {
                jSONObject2.put("v_stay_t_s", optInt4);
            }
        }
        if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().sef() && (i12 = this.Fmk) != 0) {
            jSONObject.put("lp_stay_t_s", i12);
            int optInt5 = jSONObject2.optInt("lp_stay_t_s") + this.Fmk;
            if (optInt5 != 0) {
                jSONObject2.put("lp_stay_t_s", optInt5);
            }
        }
        if (!com.bytedance.sdk.openadsdk.vS.Sj.Sj().dNu() || (i11 = this.Ym) == 0) {
            return;
        }
        jSONObject.put("v_30p_play_c_s", i11);
        int optInt6 = jSONObject2.optInt("v_30p_play_c_s") + this.Ym;
        if (optInt6 != 0) {
            jSONObject2.put("v_30p_play_c_s", optInt6);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public int compareTo(Sj sj2) {
        return sj2.TKC - this.TKC;
    }

    public JSONObject Sj(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            Sj(jSONObject2, jSONObject);
            sP(jSONObject2, jSONObject);
        } catch (Throwable th2) {
            sU.sP(th2.getMessage(), new Object[0]);
        }
        return jSONObject2;
    }

    public void Sj() {
        this.sef = SystemClock.elapsedRealtime();
        this.Ym = 0;
        this.HiB = 0;
        this.TKC = 0;
        this.Fmk = 0;
        this.TEQ = 0;
        this.Jcg = 0;
    }

    public void Sj(@NonNull String str, @Nullable String str2) {
        sP sPVar;
        sP sPVar2;
        sP sPVar3;
        sP sPVar4;
        sP sPVar5;
        sP sPVar6;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1908685858:
                if (str.equals("landingContinue")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1769688545:
                if (str.equals("landingPause")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1766371189:
                if (str.equals("landingStart")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1643912491:
                if (str.equals("feed_over")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1643892427:
                if (str.equals("feed_play")) {
                    c11 = 4;
                    break;
                }
                break;
            case 3529469:
                if (str.equals(PushConstants.PUSH_SERVICE_TYPE_SHOW)) {
                    c11 = 5;
                    break;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    c11 = 6;
                    break;
                }
                break;
            case 533457448:
                if (str.equals("feed_continue")) {
                    c11 = 7;
                    break;
                }
                break;
            case 566194974:
                if (str.equals("feed_break")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 578633749:
                if (str.equals("feed_pause")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 695109002:
                if (str.equals("landingFinish")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 702698279:
                if (str.equals("videoPercent30")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1338624943:
                if (str.equals("videoForceBreak")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 1671642405:
                if (str.equals("dislike")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 1912965437:
                if (str.equals("play_error")) {
                    c11 = 14;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                if (TextUtils.isEmpty(str2) || (sPVar = this.f21222aa.get(str2)) == null) {
                    return;
                }
                sPVar.EjP(SystemClock.elapsedRealtime());
                return;
            case 1:
                if (TextUtils.isEmpty(str2) || (sPVar2 = this.f21222aa.get(str2)) == null) {
                    return;
                }
                sPVar2.TKC(SystemClock.elapsedRealtime());
                return;
            case 2:
                if (TextUtils.isEmpty(str2) || this.f21222aa.get(str2) != null) {
                    return;
                }
                sP sPVar7 = new sP();
                this.f21222aa.put(str2, sPVar7);
                sPVar7.Sj(SystemClock.elapsedRealtime());
                return;
            case 3:
            case '\b':
            case '\f':
            case 14:
                if (TextUtils.isEmpty(str2) || (sPVar3 = this.uA.get(str2)) == null || sPVar3.Sj() == sP.HiB) {
                    return;
                }
                sPVar3.sP(SystemClock.elapsedRealtime());
                if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().Zq()) {
                    this.TEQ = (int) (this.TEQ + sPVar3.Sj(this.sef, SystemClock.elapsedRealtime()));
                    return;
                }
                return;
            case 4:
                this.vS.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().Dq()) {
                    this.Jcg++;
                }
                if (TextUtils.isEmpty(str2) || this.uA.get(str2) != null) {
                    return;
                }
                sP sPVar8 = new sP();
                this.uA.put(str2, sPVar8);
                sPVar8.Sj(SystemClock.elapsedRealtime());
                return;
            case 5:
                this.Sj.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().vS()) {
                    this.TKC++;
                    return;
                }
                return;
            case 6:
                if (this.Zq.contains(str2)) {
                    return;
                }
                if (this.Zq.size() > 50) {
                    this.Zq.subList(0, 25).clear();
                }
                this.Zq.add(str2);
                this.EjP.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().Jcg()) {
                    this.HiB++;
                    return;
                }
                return;
            case 7:
                if (TextUtils.isEmpty(str2) || (sPVar4 = this.uA.get(str2)) == null) {
                    return;
                }
                sPVar4.EjP(SystemClock.elapsedRealtime());
                return;
            case '\t':
                if (TextUtils.isEmpty(str2) || (sPVar5 = this.uA.get(str2)) == null) {
                    return;
                }
                sPVar5.TKC(SystemClock.elapsedRealtime());
                return;
            case '\n':
                if (TextUtils.isEmpty(str2) || (sPVar6 = this.f21222aa.get(str2)) == null || sPVar6.Sj() == sP.HiB) {
                    return;
                }
                sPVar6.sP(SystemClock.elapsedRealtime());
                if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().sef()) {
                    this.Fmk = (int) (this.Fmk + sPVar6.Sj(this.sef, SystemClock.elapsedRealtime()));
                    return;
                }
                return;
            case 11:
                if (com.bytedance.sdk.openadsdk.vS.Sj.Sj().dNu()) {
                    this.Ym++;
                    return;
                }
                return;
            case '\r':
                this.Dq.add(Long.valueOf(SystemClock.elapsedRealtime()));
                return;
            default:
                return;
        }
    }

    public String sP() {
        return this.sP;
    }
}
