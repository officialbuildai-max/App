package com.transsion.api.gateway.interceptor;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.api.gateway.GateWaySdk;
import com.transsion.api.gateway.analytics.a;
import com.transsion.api.gateway.bean.GatewayResponse;
import com.transsion.api.gateway.bean.GatewayStrategy;
import com.transsion.api.gateway.bean.TimeBean;
import com.transsion.api.gateway.config.b;
import com.transsion.api.gateway.dns.GateWayDns;
import com.transsion.api.gateway.utils.ContextUtils;
import com.transsion.api.gateway.utils.GatewayUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import java.io.IOException;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* loaded from: classes.dex */
public class GatewayInterceptor implements Interceptor {
    public boolean isReadResponse = false;
    public Response mResponse = null;
    public long startNs;

    private Request changeRequestUrl(Interceptor.Chain chain, GatewayStrategy gatewayStrategy, a aVar) {
        Request request = chain.request();
        if (gatewayStrategy == null) {
            return request;
        }
        HttpUrl build = request.url().newBuilder().host(GateWaySdk.getHost()).build();
        if (gatewayStrategy.isUseOriginHost() && !TextUtils.isEmpty(aVar.f42542i)) {
            build = build.newBuilder().host(aVar.f42542i).build();
        }
        aVar.f42536c = gatewayStrategy.isNoDns();
        Request.Builder newBuilder = request.newBuilder().url(build).build().newBuilder();
        if (!gatewayStrategy.isUseOriginHost() && !TextUtils.isEmpty(aVar.f42542i)) {
            newBuilder.addHeader(HttpHeaders.HOST, aVar.f42542i + ":443");
            GateWayDns.getInstance().setIsUseGatewayDns(gatewayStrategy.isNoDns());
        }
        return newBuilder.build();
    }

    private Response doGatewayJob(Interceptor.Chain chain, a aVar) throws IOException {
        Response response;
        GatewayUtils.L.d(" gateway request：" + this.startNs);
        List list = b.a().f42568a.f42556k;
        int i11 = 0;
        aVar.f42539f = changeRequestUrl(chain, (GatewayStrategy) list.get(0), aVar).url().host();
        try {
            response = chain.proceed(doGzipOrSign(chain.request()));
        } catch (IOException e11) {
            GatewayUtils.L.e("request fail, reason:" + e11);
            if (list.size() <= 1) {
                setRequestResult(e11.toString(), aVar);
                throw e11;
            }
            response = null;
        }
        long timeOffset = getTimeOffset(response);
        if (timeOffset > 0) {
            SafeStringUtils.getInstance(ContextUtils.getContext()).saveLong("time_offset", timeOffset - System.currentTimeMillis());
            try {
                response = chain.proceed(doGzipOrSign(chain.request()));
            } catch (Exception e12) {
                if (list.size() <= 1) {
                    setRequestResult(e12.toString(), aVar);
                    throw e12;
                }
            }
        }
        while (response == null && i11 < list.size() - 1) {
            i11++;
            Request changeRequestUrl = changeRequestUrl(chain, (GatewayStrategy) list.get(i11), aVar);
            aVar.f42543j = i11;
            try {
                response = chain.proceed(doGzipOrSign(changeRequestUrl));
            } catch (IOException e13) {
                GatewayUtils.L.d("gateway request fail  ");
                GatewayUtils.L.d("gateway request count: " + i11 + "reason" + e13.toString() + "duration" + (System.currentTimeMillis() - this.startNs));
                if (i11 >= list.size() - 1) {
                    GatewayUtils.L.d("gateway request count: : " + i11 + "reason" + e13.toString());
                    setRequestResult(e13.toString(), aVar);
                    throw e13;
                }
            }
        }
        recordResponse(response, aVar);
        GatewayUtils.L.d(" gateway request success, duration：" + (System.currentTimeMillis() - this.startNs) + "gateway retry count" + i11);
        return response;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private okhttp3.Request doGzipOrSign(okhttp3.Request r20) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.api.gateway.interceptor.GatewayInterceptor.doGzipOrSign(okhttp3.Request):okhttp3.Request");
    }

    private long getTimeOffset(Response response) {
        if (response != null) {
            try {
                if (!response.isSuccessful() && response.body() != null && response.code() == 500) {
                    this.isReadResponse = true;
                    String string = response.body().string();
                    this.mResponse = response.newBuilder().body(ResponseBody.create(response.body().get$contentType(), string)).build();
                    GatewayUtils.L.d("responseString:" + string);
                    GatewayResponse gatewayResponse = (GatewayResponse) com.transsion.json.b.a(string, GatewayResponse.class);
                    if ("GW.4410".equals(gatewayResponse.errorCode)) {
                        GatewayUtils.L.d("verify sign failed, retrying update time");
                        return ((TimeBean) com.transsion.json.b.a(com.transsion.api.gateway.dns.a.a(gatewayResponse.errorMsg), TimeBean.class)).time;
                    }
                }
            } catch (Exception e11) {
                GatewayUtils.L.e(e11);
            }
        }
        return 0L;
    }

    private RequestBody gzip(final RequestBody requestBody) {
        return new RequestBody() { // from class: com.transsion.api.gateway.interceptor.GatewayInterceptor.1
            @Override // okhttp3.RequestBody
            /* renamed from: contentType */
            public MediaType getContentType() {
                return requestBody.getContentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                requestBody.writeTo(buffer);
                buffer.close();
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void recordRequest(okhttp3.Request r9, com.transsion.api.gateway.analytics.a r10) {
        /*
            r8 = this;
            if (r9 == 0) goto Lb1
            okhttp3.HttpUrl r0 = r9.url()
            java.lang.String r0 = r0.getUrl()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L12
            goto Lb1
        L12:
            r0 = 1
            r10.f42537d = r0
            okhttp3.HttpUrl r0 = r9.url()
            java.lang.String r0 = r0.host()
            r10.f42539f = r0
            okhttp3.HttpUrl r0 = r9.url()
            java.lang.String r0 = r0.getUrl()
            r10.f42541h = r0
            okhttp3.HttpUrl r0 = r9.url()
            java.lang.String r0 = r0.host()
            r10.f42542i = r0
            okhttp3.HttpUrl r0 = r9.url()
            java.net.URI r0 = r0.uri()
            java.lang.String r0 = r0.getPath()
            r10.f42540g = r0
            okhttp3.RequestBody r0 = r9.body()
            if (r0 != 0) goto L5f
            com.transsion.api.gateway.utils.ObjectLogUtils r0 = com.transsion.api.gateway.utils.GatewayUtils.L
            java.lang.String r1 = "recordRequest, request body is null"
            r0.d(r1)
            okhttp3.HttpUrl r9 = r9.url()
            java.lang.String r9 = r9.getUrl()
            byte[] r9 = r9.getBytes()
            int r9 = r9.length
            long r0 = (long) r9
            r10.f42538e = r0
            return
        L5f:
            r1 = 0
            long r3 = r0.contentLength()     // Catch: java.io.IOException -> L7e
            com.transsion.api.gateway.utils.ObjectLogUtils r0 = com.transsion.api.gateway.utils.GatewayUtils.L     // Catch: java.io.IOException -> L7c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L7c
            r5.<init>()     // Catch: java.io.IOException -> L7c
            java.lang.String r6 = "recordRequest, request length is "
            r5.append(r6)     // Catch: java.io.IOException -> L7c
            r5.append(r3)     // Catch: java.io.IOException -> L7c
            java.lang.String r5 = r5.toString()     // Catch: java.io.IOException -> L7c
            r0.d(r5)     // Catch: java.io.IOException -> L7c
            goto L9a
        L7c:
            r0 = move-exception
            goto L80
        L7e:
            r0 = move-exception
            r3 = r1
        L80:
            com.transsion.api.gateway.utils.ObjectLogUtils r5 = com.transsion.api.gateway.utils.GatewayUtils.L
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "recordRequest exception: "
            r6.append(r7)
            java.lang.String r0 = r0.toString()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r5.d(r0)
        L9a:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto La1
            r10.f42538e = r3
            goto Lb1
        La1:
            okhttp3.HttpUrl r9 = r9.url()
            java.lang.String r9 = r9.getUrl()
            byte[] r9 = r9.getBytes()
            int r9 = r9.length
            long r0 = (long) r9
            r10.f42538e = r0
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.api.gateway.interceptor.GatewayInterceptor.recordRequest(okhttp3.Request, com.transsion.api.gateway.analytics.a):void");
    }

    private void recordResponse(Response response, a aVar) {
        if (response == null) {
            return;
        }
        aVar.f42544k = response.code();
        if (response.isSuccessful()) {
            setRequestResult(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, aVar);
        }
    }

    private void setRequestResult(String str, a aVar) {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response;
        if (!GateWaySdk.getIsInited()) {
            return chain.proceed(chain.request());
        }
        this.startNs = System.currentTimeMillis();
        this.isReadResponse = false;
        GatewayUtils.L.d(" request start time：" + this.startNs);
        a aVar = new a();
        recordRequest(chain.request(), aVar);
        if (GatewayUtils.canUseGateWay(aVar.f42539f, aVar.f42540g)) {
            return doGatewayJob(chain, aVar);
        }
        GatewayUtils.L.d("transparent request：" + this.startNs);
        try {
            Response proceed = chain.proceed(doGzipOrSign(chain.request()));
            long currentTimeMillis = System.currentTimeMillis();
            long timeOffset = getTimeOffset(proceed);
            if (timeOffset > 0) {
                this.isReadResponse = false;
                this.mResponse = null;
                SafeStringUtils.getInstance(ContextUtils.getContext()).saveLong("time_offset", timeOffset - System.currentTimeMillis());
                try {
                    proceed = chain.proceed(doGzipOrSign(chain.request()));
                    GatewayUtils.L.d("retry for timeoffset duration：" + (System.currentTimeMillis() - currentTimeMillis));
                } catch (IOException e11) {
                    GatewayUtils.L.e(e11);
                    setRequestResult(e11.toString(), aVar);
                    GatewayUtils.L.d("request fail, duration：" + (System.currentTimeMillis() - this.startNs));
                    throw e11;
                }
            }
            recordResponse(proceed, aVar);
            if (aVar.f42544k == 200) {
                GatewayUtils.L.d(" request success, duration：" + (System.currentTimeMillis() - this.startNs));
            } else {
                GatewayUtils.L.d(" request fail, code:  " + aVar.f42544k);
            }
            return (!this.isReadResponse || (response = this.mResponse) == null) ? proceed : response;
        } catch (IOException e12) {
            GatewayUtils.L.e(e12);
            setRequestResult(e12.toString(), aVar);
            GatewayUtils.L.d("request fail, duration：" + (System.currentTimeMillis() - this.startNs));
            throw e12;
        }
    }
}
