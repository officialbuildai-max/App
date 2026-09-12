package com.cloud.hisavana.protocol.okhttptransport;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final CronetEngine f21566a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f21567b;

    /* renamed from: c, reason: collision with root package name */
    private final i f21568c;

    /* renamed from: d, reason: collision with root package name */
    private final d f21569d;

    /* renamed from: e, reason: collision with root package name */
    private final com.cloud.hisavana.protocol.okhttptransport.c f21570e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Request f21571a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OkHttpBridgeRequestCallback f21572b;

        a(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
            this.f21571a = request;
            this.f21572b = okHttpBridgeRequestCallback;
        }

        @Override // com.cloud.hisavana.protocol.okhttptransport.g.c
        public Response getResponse() {
            return g.this.f21568c.g(this.f21571a, this.f21572b);
        }
    }

    /* loaded from: classes3.dex */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final UrlRequest f21574a;

        /* renamed from: b, reason: collision with root package name */
        private final c f21575b;

        b(UrlRequest urlRequest, c cVar) {
            this.f21574a = urlRequest;
            this.f21575b = cVar;
        }

        public UrlRequest a() {
            return this.f21574a;
        }

        public Response b() {
            return this.f21575b.getResponse();
        }
    }

    /* loaded from: classes3.dex */
    private interface c {
        Response getResponse();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(CronetEngine cronetEngine, Executor executor, d dVar, i iVar, com.cloud.hisavana.protocol.okhttptransport.c cVar) {
        this.f21566a = cronetEngine;
        this.f21567b = executor;
        this.f21569d = dVar;
        this.f21568c = iVar;
        this.f21570e = cVar;
    }

    private c c(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
        return new a(request, okHttpBridgeRequestCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(Request request, int i11, int i12) {
        OkHttpBridgeRequestCallback okHttpBridgeRequestCallback = new OkHttpBridgeRequestCallback(i11, this.f21570e);
        UrlRequest.Builder allowDirectExecutor = this.f21566a.newUrlRequestBuilder(request.url().getUrl(), okHttpBridgeRequestCallback, MoreExecutors.a()).allowDirectExecutor();
        allowDirectExecutor.addRequestAnnotation(request.headers());
        allowDirectExecutor.setHttpMethod(request.method());
        for (int i13 = 0; i13 < request.headers().size(); i13++) {
            allowDirectExecutor.addHeader(request.headers().name(i13), request.headers().value(i13));
        }
        RequestBody body = request.body();
        if (body != null) {
            if (request.header(HttpHeaders.CONTENT_LENGTH) == null && body.contentLength() != -1) {
                allowDirectExecutor.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(body.contentLength()));
            }
            if (body.contentLength() != 0) {
                if (body.getContentType() != null) {
                    allowDirectExecutor.addHeader(HttpHeaders.CONTENT_TYPE, body.getContentType().getMediaType());
                } else if (request.header(HttpHeaders.CONTENT_TYPE) == null) {
                    allowDirectExecutor.addHeader(HttpHeaders.CONTENT_TYPE, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                }
                allowDirectExecutor.setUploadDataProvider(this.f21569d.a(body, i12), this.f21567b);
            }
        }
        return new b(allowDirectExecutor.build(), c(request, okHttpBridgeRequestCallback));
    }
}
