package uc;

import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* loaded from: classes5.dex */
public class e implements ResponseHandler {

    /* renamed from: a, reason: collision with root package name */
    private final ResponseHandler f76847a;

    /* renamed from: b, reason: collision with root package name */
    private final Timer f76848b;

    /* renamed from: c, reason: collision with root package name */
    private final i f76849c;

    public e(ResponseHandler responseHandler, Timer timer, i iVar) {
        this.f76847a = responseHandler;
        this.f76848b = timer;
        this.f76849c = iVar;
    }

    @Override // org.apache.http.client.ResponseHandler
    public Object handleResponse(HttpResponse httpResponse) {
        this.f76849c.o(this.f76848b.getDurationMicros());
        this.f76849c.g(httpResponse.getStatusLine().getStatusCode());
        Long a11 = f.a(httpResponse);
        if (a11 != null) {
            this.f76849c.m(a11.longValue());
        }
        String b11 = f.b(httpResponse);
        if (b11 != null) {
            this.f76849c.l(b11);
        }
        this.f76849c.a();
        return this.f76847a.handleResponse(httpResponse);
    }
}
