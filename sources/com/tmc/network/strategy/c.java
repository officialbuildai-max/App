package com.tmc.network.strategy;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tmc.network.HttpClient;
import com.tmc.network.HttpRequestor;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private String f40870a;

    /* renamed from: b, reason: collision with root package name */
    private final a f40871b;

    /* loaded from: classes5.dex */
    public static final class a implements Callback {
        a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e11) {
            Intrinsics.h(call, "call");
            Intrinsics.h(e11, "e");
            gg.b.f63690a.c("pre connect onFailure");
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            gg.b.f63690a.c("pre connect success");
        }
    }

    public c(String url) {
        Intrinsics.h(url, "url");
        this.f40870a = url;
        this.f40871b = new a();
    }

    public final void a() {
        HttpClient httpClient;
        OkHttpClient okHttpClient;
        Call newCall;
        try {
            Request build = new Request.Builder().url(this.f40870a).header("isPre", "true").head().build();
            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
            if (companion != null && (httpClient = companion.getHttpClient()) != null && (okHttpClient = httpClient.getOkHttpClient()) != null && (newCall = okHttpClient.newCall(build)) != null) {
                FirebasePerfOkHttpClient.enqueue(newCall, this.f40871b);
            }
            gg.b.f63690a.c(Intrinsics.q("pre connect start url = ", this.f40870a));
        } catch (Throwable th2) {
            gg.b.f63690a.e(th2);
        }
    }
}
