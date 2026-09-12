package com.mbridge.msdk.reward.request;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.tracker.network.g;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class c extends com.mbridge.msdk.foundation.same.net.c<JSONObject> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f37248d = "c";

    /* renamed from: a, reason: collision with root package name */
    private int f37249a;

    /* renamed from: b, reason: collision with root package name */
    private String f37250b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.metrics.c f37251c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f37252a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f37253b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f37254c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f37255d;

        /* renamed from: com.mbridge.msdk.reward.request.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0536a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f37257a;

            RunnableC0536a(CampaignUnit campaignUnit) {
                this.f37257a = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                CampaignUnit campaignUnit = this.f37257a;
                if (campaignUnit != null && campaignUnit.getAds() != null && this.f37257a.getAds().size() > 0) {
                    this.f37257a.setMetricsData(c.this.f37251c);
                    a aVar = a.this;
                    c.this.a(aVar.f37254c, this.f37257a);
                    c.this.saveRequestTime(this.f37257a.getAds().size());
                    return;
                }
                CampaignUnit campaignUnit2 = this.f37257a;
                String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                if (TextUtils.isEmpty(msg)) {
                    msg = a.this.f37253b.optString(NotificationCompat.CATEGORY_MESSAGE);
                }
                a aVar2 = a.this;
                c cVar = c.this;
                cVar.a(aVar2.f37255d, msg, cVar.f37251c);
            }
        }

        a(String str, JSONObject jSONObject, List list, int i11) {
            this.f37252a = str;
            this.f37253b = jSONObject;
            this.f37254c = list;
            this.f37255d = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0536a("v5".equals(this.f37252a) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(this.f37253b.optJSONObject("data"), c.this.f37250b) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(this.f37253b.optJSONObject("data"), c.this.f37250b)));
        }
    }

    private void a(List<g> list, JSONObject jSONObject) {
        int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (1 != optInt) {
            a(list, jSONObject, optInt, this.f37251c);
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        CampaignUnit parseV5CampaignUnit = "v5".equals(jSONObject.optString("version")) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject("data"), this.f37250b) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject("data"), this.f37250b);
        if (parseV5CampaignUnit != null && parseV5CampaignUnit.getListFrames() != null && parseV5CampaignUnit.getListFrames().size() > 0) {
            List<Frame> listFrames = parseV5CampaignUnit.getListFrames();
            a(listFrames);
            saveRequestTime(listFrames.size());
        } else {
            String msg = parseV5CampaignUnit != null ? parseV5CampaignUnit.getMsg() : null;
            if (TextUtils.isEmpty(msg)) {
                msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
            }
            a(optInt, msg, this.f37251c);
        }
    }

    private void a(List<g> list, JSONObject jSONObject, int i11, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        String str = "";
        if (list != null && list.size() > 0) {
            for (g gVar : list) {
                if (gVar != null) {
                    String a11 = gVar.a();
                    if (!TextUtils.isEmpty(a11) && a11.equals("data_res_type")) {
                        str = gVar.b();
                    }
                }
            }
        }
        String str2 = "errorCode: 3507 errorMessage: data load failed, errorMsg is " + jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        if (TextUtils.isEmpty(str) || !str.equals("1")) {
            com.mbridge.msdk.foundation.error.b a12 = i11 == -1 ? com.mbridge.msdk.foundation.error.a.a(880017, str2) : com.mbridge.msdk.foundation.error.a.a(880003, str2);
            if (cVar != null) {
                cVar.a(a12);
                cVar.c(false);
                if (TextUtils.isEmpty(str2)) {
                    str2 = a12.g();
                }
            }
            a(i11, str2, cVar);
            return;
        }
        com.mbridge.msdk.foundation.error.b a13 = com.mbridge.msdk.foundation.error.a.a(880018, str2);
        if (cVar != null) {
            cVar.a(a13);
            cVar.c(true);
            if (TextUtils.isEmpty(str2)) {
                str2 = a13.g();
            }
        }
        a(i11, str2, cVar);
    }

    private void b(List<g> list, JSONObject jSONObject) {
        int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (1 != optInt) {
            a(list, jSONObject, optInt, this.f37251c);
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new a(jSONObject.optString("version"), jSONObject, list, optInt));
    }

    public abstract void a(int i11, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar);

    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        this.f37251c = cVar;
    }

    public void a(String str) {
        this.f37250b = str;
    }

    public abstract void a(List<Frame> list);

    public abstract void a(List<g> list, CampaignUnit campaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        o0.b(f37248d, "errorCode = " + aVar.f35483a);
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(aVar.f35483a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
        bVar.a("campaign_request_error", aVar);
        bVar.a(aVar.f35484b);
        this.f37251c.a(bVar);
        a(aVar.f35483a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar), this.f37251c);
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(e<JSONObject> eVar) {
        com.mbridge.msdk.foundation.same.net.toolbox.a aVar;
        super.onSuccess(eVar);
        if (eVar == null || (aVar = eVar.f35481b) == null) {
            return;
        }
        int i11 = this.f37249a;
        if (i11 == 0) {
            b(aVar.f35504b, eVar.f35482c);
        } else if (i11 == 1) {
            a(aVar.f35504b, eVar.f35482c);
        }
    }
}
