package com.cloud.hisavana.protocol.okhttptransport;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.common.base.m;
import com.google.common.base.o;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.g3;
import com.google.common.util.concurrent.z;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Okio;
import okio.Source;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final ImmutableSet f21580a = ImmutableSet.of(TtmlNode.TAG_BR, "deflate", "gzip", "x-gzip");

    /* renamed from: b, reason: collision with root package name */
    private static final o f21581b = o.f(',').k().e();

    private static Protocol a(String str) {
        if (!str.contains("quic") && !str.contains("h3")) {
            if (!str.contains("spdy") && !str.contains("h2")) {
                return str.contains("http/1.1") ? Protocol.HTTP_1_1 : Protocol.HTTP_1_0;
            }
            return Protocol.HTTP_2;
        }
        return Protocol.QUIC;
    }

    private static Response.Builder b(Request request, UrlResponseInfo urlResponseInfo, Source source) {
        Response.Builder builder = new Response.Builder();
        String e11 = e(HttpHeaders.CONTENT_TYPE, urlResponseInfo);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) f(urlResponseInfo.getAllHeaders(), HttpHeaders.CONTENT_ENCODING, Collections.emptyList())).iterator();
        while (it.hasNext()) {
            g3.a(arrayList, f21581b.h((String) it.next()));
        }
        boolean z10 = arrayList.isEmpty() || !f21580a.containsAll(arrayList);
        ResponseBody c11 = source != null ? c(request, urlResponseInfo.getHttpStatusCode(), e11, z10 ? e(HttpHeaders.CONTENT_LENGTH, urlResponseInfo) : null, source) : null;
        builder.request(request).code(urlResponseInfo.getHttpStatusCode()).message(urlResponseInfo.getHttpStatusText()).protocol(a(urlResponseInfo.getNegotiatedProtocol()));
        if (c11 != null) {
            builder.body(c11);
        }
        for (Map.Entry<String, String> entry : urlResponseInfo.getAllHeadersAsList()) {
            if (z10 || (!com.google.common.base.a.a(entry.getKey(), HttpHeaders.CONTENT_LENGTH) && !com.google.common.base.a.a(entry.getKey(), HttpHeaders.CONTENT_ENCODING))) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return builder;
    }

    private static ResponseBody c(Request request, int i11, String str, String str2, Source source) {
        long j11;
        if (request.method().equals("HEAD")) {
            j11 = 0;
        } else {
            j11 = -1;
            if (str2 != null) {
                try {
                    j11 = Long.parseLong(str2);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if ((i11 != 204 && i11 != 205) || j11 <= 0) {
            return ResponseBody.create(str != null ? MediaType.parse(str) : null, j11, Okio.buffer(source));
        }
        throw new ProtocolException("HTTP " + i11 + " had non-zero Content-Length: " + str2);
    }

    private static Object d(Future future) {
        try {
            return z.a(future);
        } catch (ExecutionException e11) {
            throw new IOException(e11);
        }
    }

    private static String e(String str, UrlResponseInfo urlResponseInfo) {
        List<String> list = urlResponseInfo.getAllHeaders().get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) g3.g(list);
    }

    private static Object f(Map map, Object obj, Object obj2) {
        Object obj3 = map.get(obj);
        return obj3 == null ? m.o(obj2) : obj3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Response g(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
        UrlResponseInfo urlResponseInfo = (UrlResponseInfo) d(okHttpBridgeRequestCallback.g());
        Response.Builder b11 = b(request, urlResponseInfo, (Source) d(okHttpBridgeRequestCallback.f()));
        List h11 = okHttpBridgeRequestCallback.h();
        List<String> urlChain = urlResponseInfo.getUrlChain();
        if (!h11.isEmpty()) {
            m.e(urlChain.size() == h11.size() + 1, "The number of redirects should be consistent across URLs and headers!");
            Response response = null;
            for (int i11 = 0; i11 < h11.size(); i11++) {
                response = b(request.newBuilder().url(urlChain.get(i11)).build(), (UrlResponseInfo) h11.get(i11), null).priorResponse(response).build();
            }
            b11.request(request.newBuilder().url((String) g3.g(urlChain)).build()).priorResponse(response);
        }
        return b11.build();
    }
}
