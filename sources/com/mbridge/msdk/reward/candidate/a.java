package com.mbridge.msdk.reward.candidate;

import android.text.TextUtils;
import com.cloud.config.utils.XLogUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.mbridge.msdk.foundation.cache.a;
import com.mbridge.msdk.foundation.cache.d;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.t0;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private d f37116a;

    public a(String str, boolean z10) {
        try {
            this.f37116a = b.a().b(str, com.mbridge.msdk.videocommon.setting.b.b().a(c.m().b(), str, z10).B());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private com.mbridge.msdk.foundation.cache.c a(double d11, String str, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar2, String str2, int i11) {
        com.mbridge.msdk.foundation.cache.c a11 = this.f37116a.a();
        try {
        } catch (Exception unused) {
            a11.d("getHighestCampaigns exception");
            a11.a(com.mbridge.msdk.foundation.cache.c.f35037k);
        }
        if (a11.g() > 0) {
            return a11;
        }
        JSONObject c11 = this.f37116a.c(str);
        if (c11 != null) {
            int optInt = c11.optInt("max_usage_limit", 10);
            int optInt2 = c11.optInt("max_cache_num", 20);
            if (optInt2 > 0) {
                long j11 = 8640000;
                long optLong = c11.optLong("show_interval_time", 8640000L);
                if (optLong != 0) {
                    j11 = optLong;
                }
                List<com.mbridge.msdk.foundation.cache.b> a12 = this.f37116a.a(optInt, System.currentTimeMillis() - (j11 * 1000));
                if (a12 != null && a12.size() > 0) {
                    return a(a12, c11, optInt2, d11, cVar, cVar2, str2, true, i11);
                }
                a11.d("no cache");
                a11.a(com.mbridge.msdk.foundation.cache.c.f35037k);
                a(cVar2, str2, a11, (List<a.b>) null, c11, 2);
            } else {
                a11.d("max cache num error");
                a11.a(com.mbridge.msdk.foundation.cache.c.f35037k);
            }
        } else {
            a11.d("setting config not mapping");
            a11.a(com.mbridge.msdk.foundation.cache.c.f35037k);
        }
        return a11;
    }

    private com.mbridge.msdk.foundation.cache.c a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str2, com.mbridge.msdk.foundation.error.b bVar, int i11, com.mbridge.msdk.reward.adapter.c cVar2) {
        String str3;
        int i12;
        if (bVar != null) {
            int c11 = bVar.c();
            str3 = bVar.g();
            i12 = c11;
        } else {
            str3 = null;
            i12 = 0;
        }
        String str4 = str3;
        d dVar = this.f37116a;
        if (dVar == null) {
            com.mbridge.msdk.foundation.cache.c cVar3 = new com.mbridge.msdk.foundation.cache.c();
            cVar3.d("can not get manager");
            cVar3.a(com.mbridge.msdk.foundation.cache.c.f35037k);
            return cVar3;
        }
        com.mbridge.msdk.foundation.cache.c a11 = dVar.a(str);
        if (a11.g() > com.mbridge.msdk.foundation.cache.c.f35036j) {
            return a11;
        }
        String[] split = i0.a(str.split("_")[3]).split("\\|");
        double parseDouble = Double.parseDouble(split[0]);
        com.mbridge.msdk.foundation.cache.c a12 = a(parseDouble, split.length > 1 ? split[1] : "", cVar2, cVar, str, i11);
        this.f37116a.a(a12.c(), cVar, str2, i12, str4, i11, parseDouble);
        return a12;
    }

    private com.mbridge.msdk.foundation.cache.c a(List<com.mbridge.msdk.foundation.cache.b> list, JSONObject jSONObject, int i11, double d11, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar2, String str, boolean z10, int i12) {
        ArrayList arrayList;
        int i13;
        com.mbridge.msdk.foundation.cache.c cVar3;
        a aVar = this;
        List<com.mbridge.msdk.foundation.cache.b> list2 = list;
        com.mbridge.msdk.foundation.cache.c cVar4 = new com.mbridge.msdk.foundation.cache.c();
        if (jSONObject == null) {
            cVar4.d("config is null");
            cVar4.a(com.mbridge.msdk.foundation.cache.c.f35037k);
            return cVar4;
        }
        if (list2 == null || list.size() == 0) {
            cVar4.d("candidate is null");
            cVar4.a(com.mbridge.msdk.foundation.cache.c.f35037k);
            return cVar4;
        }
        int i14 = 0;
        for (int i15 = 0; i15 < list.size(); i15++) {
            com.mbridge.msdk.foundation.cache.b bVar = list2.get(i15);
            if (bVar != null) {
                cVar4.a(bVar.e());
            }
        }
        if (list.size() > 0 && ((list2 = aVar.a(list2, cVar4)) == null || list2.size() == 0)) {
            cVar4.d("existed");
            cVar4.a(com.mbridge.msdk.foundation.cache.c.f35037k);
        }
        if (list2.size() > 0 && ((list2 = aVar.a(list2, cVar, cVar4)) == null || list2.size() == 0)) {
            cVar4.d("not ready");
            cVar4.a(com.mbridge.msdk.foundation.cache.c.f35037k);
        }
        com.mbridge.msdk.foundation.cache.b bVar2 = null;
        if (list2 == null || list2.size() <= 0) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            double optDouble = jSONObject.optDouble("t_disc", 0.8d);
            double optDouble2 = jSONObject.optDouble("u_disc", 0.95d);
            double d12 = 0.0d;
            double optDouble3 = jSONObject.optDouble("max_ecppv_diff", 0.0d);
            int optInt = jSONObject.optInt("time_interval", 1800);
            int size = list2.size();
            while (i14 < size) {
                List<com.mbridge.msdk.foundation.cache.b> list3 = list2;
                com.mbridge.msdk.foundation.cache.b bVar3 = list2.get(i14);
                if (bVar3 != null) {
                    i13 = size;
                    cVar3 = cVar4;
                    double pow = Math.pow(optDouble2, bVar3.f()) * bVar3.b() * Math.pow(optDouble, (System.currentTimeMillis() - bVar3.h()) / (optInt * 1000.0d));
                    arrayList2.add(new a.b(pow, bVar3));
                    if (pow >= d11 - optDouble3 && pow > d12) {
                        bVar2 = bVar3;
                        d12 = pow;
                    }
                } else {
                    i13 = size;
                    cVar3 = cVar4;
                }
                i14++;
                aVar = this;
                list2 = list3;
                size = i13;
                cVar4 = cVar3;
            }
            com.mbridge.msdk.foundation.cache.c cVar5 = cVar4;
            d dVar = aVar.f37116a;
            if (dVar != null) {
                dVar.a(arrayList2, i11);
            }
            if (bVar2 != null) {
                cVar4 = cVar5;
                cVar4.a(bVar2.a());
                cVar4.a(com.mbridge.msdk.foundation.cache.c.f35038l);
            } else {
                cVar4 = cVar5;
                cVar4.d("no match campaign");
                cVar4.a(com.mbridge.msdk.foundation.cache.c.f35037k);
            }
            arrayList = arrayList2;
        }
        if (z10) {
            a(cVar2, str, cVar4, arrayList, jSONObject, 2);
        }
        return cVar4;
    }

    private List<com.mbridge.msdk.foundation.cache.b> a(List<com.mbridge.msdk.foundation.cache.b> list, com.mbridge.msdk.foundation.cache.c cVar) {
        CopyOnWriteArrayList<CampaignEx> a11;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.mbridge.msdk.foundation.cache.b bVar = list.get(i11);
            if (bVar != null && (a11 = bVar.a()) != null && a11.size() != 0) {
                int i12 = 0;
                boolean z10 = false;
                while (true) {
                    if (i12 >= a11.size()) {
                        break;
                    }
                    CampaignEx campaignEx = a11.get(i12);
                    boolean c11 = t0.c(c.m().d(), campaignEx.getPackageName());
                    if (c11) {
                        cVar.b(bVar.e());
                        d dVar = this.f37116a;
                        if (dVar != null) {
                            dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        }
                        z10 = c11;
                    } else {
                        i12++;
                        z10 = c11;
                    }
                }
                if (!z10) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private List<com.mbridge.msdk.foundation.cache.b> a(List<com.mbridge.msdk.foundation.cache.b> list, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.cache.c cVar2) {
        CopyOnWriteArrayList<CampaignEx> a11;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.mbridge.msdk.foundation.cache.b bVar = list.get(i11);
            if (bVar != null && (a11 = bVar.a()) != null && a11.size() != 0) {
                int i12 = 0;
                boolean z10 = false;
                while (true) {
                    if (i12 >= a11.size()) {
                        break;
                    }
                    CampaignEx campaignEx = a11.get(i12);
                    if (cVar == null || (z10 = cVar.a(a11, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())))) {
                        i12++;
                    } else {
                        cVar2.c(bVar.e());
                        d dVar = this.f37116a;
                        if (dVar != null) {
                            dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        }
                    }
                }
                if (z10) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public com.mbridge.msdk.foundation.cache.c a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, CampaignEx campaignEx, com.mbridge.msdk.foundation.error.b bVar, int i11, com.mbridge.msdk.reward.adapter.c cVar2) {
        String requestId;
        com.mbridge.msdk.foundation.cache.c cVar3 = new com.mbridge.msdk.foundation.cache.c();
        if (campaignEx == null) {
            requestId = "";
        } else {
            try {
                try {
                    requestId = campaignEx.getRequestId();
                } catch (Exception unused) {
                    cVar3.d("getRewardCandidateCampaignList result exception");
                    cVar3.a(com.mbridge.msdk.foundation.cache.c.f35037k);
                    return cVar3;
                }
            } catch (Exception unused2) {
                cVar3.d("getCandidateCampaignList result exception");
                cVar3.a(com.mbridge.msdk.foundation.cache.c.f35037k);
                return cVar3;
            }
        }
        return a(str, cVar, requestId, bVar, i11, cVar2);
    }

    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str, com.mbridge.msdk.foundation.cache.c cVar2, List<a.b> list, JSONObject jSONObject, int i11) {
        try {
            e eVar = new e();
            eVar.a(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, i11 != 1 ? i11 != 2 ? i11 != 3 ? TmcConstants.ROUTE_UNKNOWN : "track" : "candidate" : "cb");
            d dVar = this.f37116a;
            if (dVar != null) {
                double b11 = dVar.b(str);
                if (b11 >= 0.0d) {
                    eVar.a("bp", i0.b(b11 + ""));
                }
                eVar.a("cb_state", a(str) ? MRAIDPresenter.OPEN : "close");
                try {
                    d dVar2 = this.f37116a;
                    JSONObject c11 = dVar2.c(dVar2.d(str));
                    if (c11 != null) {
                        eVar.a(XLogUtil.TAG, c11.toString());
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (cVar2 != null) {
                if (cVar2.g() == com.mbridge.msdk.foundation.cache.c.f35038l) {
                    eVar.a("result", 1);
                } else {
                    eVar.a("result", 2);
                    eVar.a("reason", cVar2.e());
                }
                eVar.a("acr", cVar2.a());
                eVar.a("her", cVar2.d());
                eVar.a("nrr", cVar2.f());
                eVar.a("cer", cVar2.b());
            } else {
                eVar.a("result", 2);
                eVar.a("reason", "candidate result is null");
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i12 = 0; i12 < list.size(); i12++) {
                    com.mbridge.msdk.foundation.cache.b a11 = list.get(i12).a();
                    if (a11 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ecppv", i0.b(a11.b() + ""));
                        jSONObject2.put("showCount", a11.f());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - a11.h());
                        jSONArray.put(jSONObject2);
                    }
                }
                eVar.a("data", jSONArray.toString());
            }
            if (cVar != null) {
                cVar.i("m_candidate_data");
                cVar.d("m_candidate_data");
                cVar.a("m_candidate_data", eVar);
                if (cVar2 != null && cVar2.c() != null) {
                    cVar.b(cVar2.c());
                }
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().b("m_candidate_data", cVar, null);
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public void a(String str, String str2, int i11, String str3) {
        d dVar = this.f37116a;
        if (dVar != null) {
            dVar.a(str, str2, i11, str3);
        }
    }

    public void a(List<CampaignEx> list, String str, com.mbridge.msdk.reward.adapter.c cVar, String str2) {
        try {
            if (this.f37116a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f37116a.a(com.mbridge.msdk.foundation.cache.a.f35017f, 2, list, this.f37116a.a(list, str) > 0, "", "", -1, str2);
            d dVar = this.f37116a;
            JSONObject c11 = dVar.c(dVar.d(str));
            if (c11 == null || this.f37116a.b(str) <= 0.0d) {
                return;
            }
            a(this.f37116a.a(c11.optInt("max_usage_limit", 10), 0L), c11, c11.optInt("max_cache_num", 20), -1.0d, cVar, new com.mbridge.msdk.foundation.same.report.metrics.c(), str, false, 0);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public boolean a(String str) {
        JSONObject c11;
        try {
            d dVar = this.f37116a;
            if (dVar != null && (c11 = dVar.c(dVar.d(str))) != null) {
                return c11.optInt("c_cb", 0) == 1;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return false;
    }
}
