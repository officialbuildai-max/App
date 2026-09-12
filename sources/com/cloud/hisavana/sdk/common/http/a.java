package com.cloud.hisavana.sdk.common.http;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.RequestParams;
import com.cloud.hisavana.net.impl.StringCallback;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener;
import com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.h0;
import com.transsion.push.PushConstants;
import java.util.Locale;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Headers;

/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: k, reason: collision with root package name */
    private static String f22149k;

    /* renamed from: l, reason: collision with root package name */
    private static String f22150l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f22151m;

    /* renamed from: c, reason: collision with root package name */
    private String f22152c = "0";

    /* renamed from: d, reason: collision with root package name */
    private String f22153d = "";

    /* renamed from: e, reason: collision with root package name */
    private boolean f22154e = false;

    /* renamed from: f, reason: collision with root package name */
    private SSLSocketFactory f22155f = null;

    /* renamed from: g, reason: collision with root package name */
    private b f22156g = null;

    /* renamed from: h, reason: collision with root package name */
    private String f22157h = "0";

    /* renamed from: i, reason: collision with root package name */
    private String f22158i = "1";

    /* renamed from: j, reason: collision with root package name */
    private AdxImpBean f22159j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cloud.hisavana.sdk.common.http.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0310a extends StringCallback {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22160c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0310a(boolean z10, String str) {
            super(z10);
            this.f22160c = str;
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback, com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void l(Headers headers) {
            super.l(headers);
            if (headers != null) {
                for (int i11 = 0; i11 < headers.size(); i11++) {
                    String name = headers.name(i11);
                    if (!TextUtils.isEmpty(name) && name.toLowerCase(Locale.ROOT).contains("cloudcontrolversion")) {
                        String value = headers.value(i11);
                        com.cloud.sdk.commonutil.util.c.netLog("okhttp -> get new cloud control version from header,version: " + value);
                        if (!TextUtils.isEmpty(value) && !value.equals(a.f22149k)) {
                            String unused = a.f22149k = value;
                            boolean unused2 = a.f22151m = true;
                            com.cloud.sdk.commonutil.util.c.netLog("okhttp ->  cloud control version update");
                            j7.a.e().r("new_config_ver", value);
                        }
                        j7.a.e().q("last_req_config_time", System.currentTimeMillis());
                    }
                    if (!TextUtils.isEmpty(name) && name.toLowerCase(Locale.ROOT).contains("cloudcontrolofflineversion")) {
                        String value2 = headers.value(i11);
                        com.cloud.sdk.commonutil.util.c.netLog("okhttp -> get new hisavana cloud control version from header,version: " + value2);
                        if (!TextUtils.isEmpty(value2) && !value2.equals(a.f22150l)) {
                            String unused3 = a.f22150l = value2;
                            com.cloud.sdk.commonutil.util.c.netLog("okhttp -> hisavana cloud control version update");
                            j7.a.e().r("new_hisavana_ver", value2);
                        }
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
        @Override // com.cloud.hisavana.net.impl.StringCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void x(int r4, java.lang.String r5, java.lang.Throwable r6) {
            /*
                r3 = this;
                boolean r0 = com.cloud.hisavana.sdk.h0.g(r4, r5)
                if (r0 == 0) goto Lc
                com.cloud.hisavana.sdk.common.http.a r4 = com.cloud.hisavana.sdk.common.http.a.this
                com.cloud.hisavana.sdk.common.http.a.c(r4)
                return
            Lc:
                if (r6 == 0) goto L41
                boolean r0 = a7.c.p()
                if (r0 == 0) goto L41
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r3.f22160c
                r0.append(r1)
                java.lang.String r1 = " ----- error statusCode = "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " ----- error message = "
                r0.append(r1)
                java.lang.String r1 = r6.getMessage()
                r0.append(r1)
                java.lang.String r1 = " ----- response = "
                r0.append(r1)
                r0.append(r5)
                java.lang.String r0 = r0.toString()
                com.cloud.sdk.commonutil.util.c.netLog(r0)
            L41:
                com.cloud.hisavana.sdk.common.http.a r0 = com.cloud.hisavana.sdk.common.http.a.this
                com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener r0 = r0.f22167b
                if (r0 == 0) goto L96
                if (r5 == 0) goto L57
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L55
                r0.<init>(r5)     // Catch: java.lang.Exception -> L55
                java.lang.String r1 = "code"
                int r0 = r0.optInt(r1)     // Catch: java.lang.Exception -> L55
                goto L76
            L55:
                r0 = move-exception
                goto L5d
            L57:
                java.lang.String r0 = "can't get code,response is null"
                com.cloud.sdk.commonutil.util.c.netLog(r0)     // Catch: java.lang.Exception -> L55
                goto L75
            L5d:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getCode error "
                r1.append(r2)
                java.lang.String r0 = r0.getMessage()
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                com.cloud.sdk.commonutil.util.c.netLog(r0)
            L75:
                r0 = 0
            L76:
                if (r0 != 0) goto L79
                r0 = r4
            L79:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "statusCode = "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                com.cloud.sdk.commonutil.util.c.netLog(r4)
                com.cloud.hisavana.sdk.common.http.a r4 = com.cloud.hisavana.sdk.common.http.a.this
                com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener r4 = r4.f22167b
                com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener r4 = (com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener) r4
                r4.c(r0, r5, r6)
            L96:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.http.a.C0310a.x(int, java.lang.String, java.lang.Throwable):void");
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void y(int i11, String str) {
            if (a7.c.p()) {
                com.cloud.sdk.commonutil.util.c.netLog(this.f22160c + "\n ----- status code = " + i11 + "\n ----- response = " + str);
            }
            if (TextUtils.isEmpty(str)) {
                ResponseBaseListener responseBaseListener = a.this.f22167b;
                if (responseBaseListener != null) {
                    ((CommonResponseListener) responseBaseListener).e(TaErrorCode.ERROR_RESPONSE_IS_NULL);
                }
                com.cloud.sdk.commonutil.util.c.netLog("TextUtils.isEmpty(response) == true ,  response is null ");
                return;
            }
            ResponseBaseListener responseBaseListener2 = a.this.f22167b;
            if (responseBaseListener2 != null) {
                ((CommonResponseListener) responseBaseListener2).i(i11, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        String a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String a11 = this.f22156g.a();
        if (TextUtils.isEmpty(a11)) {
            ResponseBaseListener responseBaseListener = this.f22167b;
            if (responseBaseListener != null) {
                ((CommonResponseListener) responseBaseListener).c(-1, "TextUtils.isEmpty(postBodyString) == true ", null);
            }
            com.cloud.sdk.commonutil.util.c.netLog("sendRequestToServer() --> TextUtils.isEmpty(postBodyString) == true ");
            return;
        }
        AdxImpBean adxImpBean = this.f22159j;
        if (adxImpBean != null) {
            adxImpBean.requestTs = Long.valueOf(System.currentTimeMillis());
            AthenaTracker.g0(this.f22159j);
        }
        try {
            String str = "----- full url = " + this.f22153d + "\n ----- postBodyString = " + a11.trim();
            String k11 = j7.a.e().k("cloudControlVersion", null);
            String k12 = j7.a.e().k("hisavanaCurrentCloudControlVersion", null);
            if (TextUtils.isEmpty(this.f22153d)) {
                return;
            }
            ResponseBaseListener responseBaseListener2 = this.f22167b;
            boolean z10 = true;
            if (responseBaseListener2 != null) {
                ((CommonResponseListener) responseBaseListener2).f(1);
            }
            if (g7.a.c() == 0) {
                z10 = false;
            }
            h0.f(z10);
            String c11 = h0.c("post", "", "application/json", this.f22153d, a11);
            RequestParams requestParams = new RequestParams();
            requestParams.i("x-tr-signature", c11);
            requestParams.i("cloudControlVersion", k11);
            requestParams.i("cloudControlOfflineVersion", k12);
            requestParams.i("defaultAd", "2");
            requestParams.i("offlineAd", this.f22157h);
            requestParams.i("Accept-Timezone", "UTC");
            requestParams.i("sdktype", this.f22158i);
            requestParams.i(PushConstants.PROVIDER_FIELD_PKG, com.cloud.sdk.commonutil.util.e.a().getPackageName());
            requestParams.n(a11);
            HttpRequest.j(this.f22153d, requestParams, new C0310a(false, str));
        } catch (Throwable th2) {
            com.cloud.sdk.commonutil.util.c.netLog("AdServerRequest --> " + Log.getStackTraceString(th2));
            ResponseBaseListener responseBaseListener3 = this.f22167b;
            if (responseBaseListener3 != null) {
                ((CommonResponseListener) responseBaseListener3).e(new TaErrorCode(-1, th2.getMessage()));
            }
        }
    }

    @Override // com.cloud.hisavana.sdk.common.http.d
    protected void a() {
        i();
    }

    public a j(AdxImpBean adxImpBean) {
        this.f22159j = adxImpBean;
        return this;
    }

    public a k(boolean z10) {
        this.f22154e = z10;
        return this;
    }

    public a l(boolean z10) {
        this.f22157h = z10 ? "1" : "0";
        return this;
    }

    public a m(CommonResponseListener commonResponseListener) {
        this.f22167b = commonResponseListener;
        return this;
    }

    public a n(String str) {
        this.f22152c = str;
        return this;
    }

    public a o(b bVar) {
        this.f22156g = bVar;
        return this;
    }

    public a p(String str) {
        this.f22158i = str;
        return this;
    }

    public a q(String str) {
        this.f22153d = str;
        return this;
    }
}
