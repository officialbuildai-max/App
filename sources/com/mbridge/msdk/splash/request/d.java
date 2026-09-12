package com.mbridge.msdk.splash.request;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.tracker.network.g;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class d extends com.mbridge.msdk.foundation.same.net.c<JSONObject> {

    /* renamed from: c, reason: collision with root package name */
    private static final String f37625c = "d";

    /* renamed from: a, reason: collision with root package name */
    private int f37626a;

    /* renamed from: b, reason: collision with root package name */
    private String f37627b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f37628a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f37629b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f37630c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f37631d;

        /* renamed from: com.mbridge.msdk.splash.request.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0545a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f37633a;

            RunnableC0545a(CampaignUnit campaignUnit) {
                this.f37633a = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                CampaignUnit campaignUnit = this.f37633a;
                if (campaignUnit != null && campaignUnit.getAds() != null && this.f37633a.getAds().size() > 0) {
                    a aVar = a.this;
                    d.this.a(aVar.f37630c, this.f37633a);
                    d.this.saveRequestTime(this.f37633a.getAds().size());
                } else {
                    CampaignUnit campaignUnit2 = this.f37633a;
                    String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                    if (TextUtils.isEmpty(msg)) {
                        msg = a.this.f37629b.optString(NotificationCompat.CATEGORY_MESSAGE);
                    }
                    a aVar2 = a.this;
                    d.this.a(aVar2.f37631d, msg);
                }
            }
        }

        a(String str, JSONObject jSONObject, List list, int i11) {
            this.f37628a = str;
            this.f37629b = jSONObject;
            this.f37630c = list;
            this.f37631d = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0545a("v5".equals(this.f37628a) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(this.f37629b.optJSONObject("data"), d.this.f37627b) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(this.f37629b.optJSONObject("data"), d.this.f37627b)));
        }
    }

    private void a(List<g> list, JSONObject jSONObject) {
        int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (1 != optInt) {
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        CampaignUnit parseV5CampaignUnit = "v5".equals(jSONObject.optString("version")) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject("data"), this.f37627b) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject("data"), this.f37627b);
        if (parseV5CampaignUnit != null && parseV5CampaignUnit.getListFrames() != null && parseV5CampaignUnit.getListFrames().size() > 0) {
            List<Frame> listFrames = parseV5CampaignUnit.getListFrames();
            a(listFrames);
            saveRequestTime(listFrames.size());
        } else {
            String msg = parseV5CampaignUnit != null ? parseV5CampaignUnit.getMsg() : null;
            if (TextUtils.isEmpty(msg)) {
                msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
            }
            a(optInt, msg);
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

    public abstract void a(int i11, String str);

    public void a(String str) {
        this.f37627b = str;
    }

    public abstract void a(List<Frame> list);

    public abstract void a(List<g> list, CampaignUnit campaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        o0.b(f37625c, "errorCode = " + aVar.f35483a);
        a(aVar.f35483a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(com.mbridge.msdk.foundation.same.net.e<JSONObject> eVar) {
        com.mbridge.msdk.foundation.same.net.toolbox.a aVar;
        super.onSuccess(eVar);
        if (eVar == null || (aVar = eVar.f35481b) == null) {
            return;
        }
        int i11 = this.f37626a;
        if (i11 == 0) {
            b(aVar.f35504b, eVar.f35482c);
        } else if (i11 == 1) {
            a(aVar.f35504b, eVar.f35482c);
        }
    }
}
