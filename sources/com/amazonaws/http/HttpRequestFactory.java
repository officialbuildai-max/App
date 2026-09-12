package com.amazonaws.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class HttpRequestFactory {
    private void a(Map map, Request request, ExecutionContext executionContext, ClientConfiguration clientConfiguration) {
        URI r11 = request.r();
        String host = r11.getHost();
        if (HttpUtils.d(r11)) {
            host = host + ":" + r11.getPort();
        }
        map.put(HttpHeaders.HOST, host);
        for (Map.Entry entry : request.getHeaders().entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        if (map.get(HttpHeaders.CONTENT_TYPE) == null || ((String) map.get(HttpHeaders.CONTENT_TYPE)).isEmpty()) {
            map.put(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + StringUtils.b("UTF-8"));
        }
        if (executionContext == null || executionContext.b() == null) {
            return;
        }
        map.put("User-Agent", c(clientConfiguration, executionContext.b()));
    }

    private String c(ClientConfiguration clientConfiguration, String str) {
        if (clientConfiguration.h().contains(str)) {
            return clientConfiguration.h();
        }
        return clientConfiguration.h() + " " + str;
    }

    public HttpRequest b(Request request, ClientConfiguration clientConfiguration, ExecutionContext executionContext) {
        boolean z10 = true;
        String b11 = HttpUtils.b(request.r().toString(), request.p(), true);
        String c11 = HttpUtils.c(request);
        HttpMethodName m11 = request.m();
        boolean z11 = request.getContent() != null;
        HttpMethodName httpMethodName = HttpMethodName.POST;
        if (m11 == httpMethodName && !z11) {
            z10 = false;
        }
        if (c11 != null && z10) {
            b11 = b11 + UrlUtils.QUESTION_MARK + c11;
        }
        HashMap hashMap = new HashMap();
        a(hashMap, request, executionContext, clientConfiguration);
        InputStream content = request.getContent();
        HttpMethodName httpMethodName2 = HttpMethodName.PATCH;
        if (m11 == httpMethodName2) {
            hashMap.put("X-HTTP-Method-Override", httpMethodName2.toString());
            m11 = httpMethodName;
        }
        if (m11 == httpMethodName && request.getContent() == null && c11 != null) {
            byte[] bytes = c11.getBytes(StringUtils.f19086a);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            hashMap.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(bytes.length));
            content = byteArrayInputStream;
        }
        if (clientConfiguration.k() && hashMap.get("Accept-Encoding") == null) {
            hashMap.put("Accept-Encoding", "gzip");
        } else {
            hashMap.put("Accept-Encoding", "identity");
        }
        HttpRequest httpRequest = new HttpRequest(m11.toString(), URI.create(b11), hashMap, content);
        httpRequest.g(request.k());
        return httpRequest;
    }
}
