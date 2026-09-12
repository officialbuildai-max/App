package com.mbridge.msdk.mbbanner.common.response;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.tracker.network.g;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class a extends c<JSONObject> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f36194b = "a";

    /* renamed from: a, reason: collision with root package name */
    private String f36195a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.mbbanner.common.response.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0503a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f36196a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f36197b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f36198c;

        /* renamed from: com.mbridge.msdk.mbbanner.common.response.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0504a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f36200a;

            RunnableC0504a(CampaignUnit campaignUnit) {
                this.f36200a = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                CampaignUnit campaignUnit = this.f36200a;
                if (campaignUnit != null && campaignUnit.getAds() != null && this.f36200a.getAds().size() > 0) {
                    a.this.a(this.f36200a);
                    if (!TextUtils.isEmpty(a.this.f36195a)) {
                        a.this.saveHbState(1);
                    }
                    a.this.saveRequestTime(this.f36200a.getAds().size());
                    return;
                }
                CampaignUnit campaignUnit2 = this.f36200a;
                String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                if (TextUtils.isEmpty(msg)) {
                    msg = RunnableC0503a.this.f36197b.optString(NotificationCompat.CATEGORY_MESSAGE);
                }
                RunnableC0503a runnableC0503a = RunnableC0503a.this;
                a.this.a(runnableC0503a.f36198c, msg);
            }
        }

        RunnableC0503a(String str, JSONObject jSONObject, int i11) {
            this.f36196a = str;
            this.f36197b = jSONObject;
            this.f36198c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0504a("v5".equals(this.f36196a) ? b.parseV5CampaignUnit(this.f36197b.optJSONObject("data"), a.this.f36195a) : b.parseCampaignUnit(this.f36197b.optJSONObject("data"), a.this.f36195a)));
        }
    }

    private void a(List<g> list, JSONObject jSONObject) {
        o0.c(f36194b, "parseLoad content = " + jSONObject);
        int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (1 != optInt) {
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new RunnableC0503a(jSONObject.optString("version"), jSONObject, optInt));
    }

    public abstract void a(int i11, String str);

    public abstract void a(CampaignUnit campaignUnit);

    public void a(String str) {
        this.f36195a = str;
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        o0.c(f36194b, "onFailed errorCode = " + aVar.f35483a);
        a(aVar.f35483a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(e<JSONObject> eVar) {
        super.onSuccess(eVar);
        a(eVar.f35481b.f35504b, eVar.f35482c);
    }
}
