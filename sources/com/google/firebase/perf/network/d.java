package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import uc.f;
import vc.k;

/* loaded from: classes4.dex */
public class d implements Callback {

    /* renamed from: a, reason: collision with root package name */
    private final Callback f32374a;

    /* renamed from: b, reason: collision with root package name */
    private final i f32375b;

    /* renamed from: c, reason: collision with root package name */
    private final Timer f32376c;

    /* renamed from: d, reason: collision with root package name */
    private final long f32377d;

    public d(Callback callback, k kVar, Timer timer, long j11) {
        this.f32374a = callback;
        this.f32375b = i.b(kVar);
        this.f32377d = j11;
        this.f32376c = timer;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        Request request = call.request();
        if (request != null) {
            HttpUrl url = request.url();
            if (url != null) {
                this.f32375b.q(url.url().toString());
            }
            if (request.method() != null) {
                this.f32375b.f(request.method());
            }
        }
        this.f32375b.k(this.f32377d);
        this.f32375b.o(this.f32376c.getDurationMicros());
        f.d(this.f32375b);
        this.f32374a.onFailure(call, iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        FirebasePerfOkHttpClient.a(response, this.f32375b, this.f32377d, this.f32376c.getDurationMicros());
        this.f32374a.onResponse(call, response);
    }
}
