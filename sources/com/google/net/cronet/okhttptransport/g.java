package com.google.net.cronet.okhttptransport;

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
/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final CronetEngine f32847a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f32848b;

    /* renamed from: c, reason: collision with root package name */
    private final i f32849c;

    /* renamed from: d, reason: collision with root package name */
    private final d f32850d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.net.cronet.okhttptransport.c f32851e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Request f32852a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OkHttpBridgeRequestCallback f32853b;

        a(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
            this.f32852a = request;
            this.f32853b = okHttpBridgeRequestCallback;
        }

        @Override // com.google.net.cronet.okhttptransport.g.c
        public Response getResponse() {
            return g.this.f32849c.f(this.f32852a, this.f32853b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final UrlRequest f32855a;

        /* renamed from: b, reason: collision with root package name */
        private final c f32856b;

        b(UrlRequest urlRequest, c cVar) {
            this.f32855a = urlRequest;
            this.f32856b = cVar;
        }

        public UrlRequest a() {
            return this.f32855a;
        }

        public Response b() {
            return this.f32856b.getResponse();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface c {
        Response getResponse();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(CronetEngine cronetEngine, Executor executor, d dVar, i iVar, com.google.net.cronet.okhttptransport.c cVar) {
        this.f32847a = cronetEngine;
        this.f32848b = executor;
        this.f32850d = dVar;
        this.f32849c = iVar;
        this.f32851e = cVar;
    }

    private c c(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
        return new a(request, okHttpBridgeRequestCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(Request request, int i11, int i12) {
        OkHttpBridgeRequestCallback okHttpBridgeRequestCallback = new OkHttpBridgeRequestCallback(i11, this.f32851e);
        UrlRequest.Builder allowDirectExecutor = this.f32847a.newUrlRequestBuilder(request.url().getUrl(), okHttpBridgeRequestCallback, MoreExecutors.a()).allowDirectExecutor();
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
                if (request.header(HttpHeaders.CONTENT_TYPE) != null || body.getContentType() == null) {
                    allowDirectExecutor.addHeader(HttpHeaders.CONTENT_TYPE, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                } else {
                    allowDirectExecutor.addHeader(HttpHeaders.CONTENT_TYPE, body.getContentType().getMediaType());
                }
                allowDirectExecutor.setUploadDataProvider(this.f32850d.a(body, i12), this.f32848b);
            }
        }
        return new b(allowDirectExecutor.build(), c(request, okHttpBridgeRequestCallback));
    }
}
