package com.mbridge.msdk.mbnative.service.net;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.tracker.network.g;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class b extends c<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private int f36465a;

    /* renamed from: b, reason: collision with root package name */
    private String f36466b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f36467a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f36468b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f36469c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f36470d;

        /* renamed from: com.mbridge.msdk.mbnative.service.net.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0513a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f36472a;

            RunnableC0513a(CampaignUnit campaignUnit) {
                this.f36472a = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                CampaignUnit campaignUnit = this.f36472a;
                if (campaignUnit == null || campaignUnit.getAds() == null || this.f36472a.getAds().size() <= 0) {
                    a aVar = a.this;
                    b.this.a(aVar.f36470d, aVar.f36468b.optString(NotificationCompat.CATEGORY_MESSAGE));
                } else {
                    a aVar2 = a.this;
                    b.this.a(aVar2.f36469c, this.f36472a);
                    b.this.saveRequestTime(this.f36472a.getAds().size());
                }
            }
        }

        a(String str, JSONObject jSONObject, List list, int i11) {
            this.f36467a = str;
            this.f36468b = jSONObject;
            this.f36469c = list;
            this.f36470d = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0513a("v5".equals(this.f36467a) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(this.f36468b.optJSONObject("data")) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(this.f36468b.optJSONObject("data"))));
        }
    }

    private void a(List<g> list, JSONObject jSONObject) {
        int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (1 != optInt) {
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        CampaignUnit parseV5CampaignUnit = "v5".equals(jSONObject.optString("version")) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject("data")) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject("data"));
        if (parseV5CampaignUnit == null || parseV5CampaignUnit.getListFrames() == null || parseV5CampaignUnit.getListFrames().size() <= 0) {
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
        } else {
            a(parseV5CampaignUnit.getListFrames());
            saveRequestTime(parseV5CampaignUnit.getListFrames().size());
        }
    }

    private void b(List<g> list, JSONObject jSONObject) {
        int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (1 != optInt) {
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new a(jSONObject.optString("version"), jSONObject, list, optInt));
    }

    public int a() {
        return this.f36465a;
    }

    public void a(int i11) {
        this.f36465a = i11;
    }

    public abstract void a(int i11, String str);

    public void a(String str) {
        this.f36466b = str;
    }

    public abstract void a(List<Frame> list);

    public abstract void a(List<g> list, CampaignUnit campaignUnit);

    public String b() {
        return this.f36466b;
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        a(aVar.f35483a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
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
        int i11 = this.f36465a;
        if (i11 == 0) {
            b(aVar.f35504b, eVar.f35482c);
        } else if (i11 == 1) {
            a(aVar.f35504b, eVar.f35482c);
        }
    }
}
