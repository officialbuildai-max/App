package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import uc.f;
import vc.k;

/* loaded from: classes.dex */
public class FirebasePerfOkHttpClient {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Response response, i iVar, long j11, long j12) {
        Request request = response.request();
        if (request == null) {
            return;
        }
        iVar.q(request.url().url().toString());
        iVar.f(request.method());
        if (request.body() != null) {
            long contentLength = request.body().contentLength();
            if (contentLength != -1) {
                iVar.j(contentLength);
            }
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength2 = body.getContentLength();
            if (contentLength2 != -1) {
                iVar.m(contentLength2);
            }
            MediaType mediaType = body.get$contentType();
            if (mediaType != null) {
                iVar.l(mediaType.getMediaType());
            }
        }
        iVar.g(response.code());
        iVar.k(j11);
        iVar.o(j12);
        iVar.a();
    }

    @Keep
    public static void enqueue(Call call, Callback callback) {
        Timer timer = new Timer();
        call.enqueue(new d(callback, k.k(), timer, timer.getMicros()));
    }

    @Keep
    public static Response execute(Call call) throws IOException {
        i b11 = i.b(k.k());
        Timer timer = new Timer();
        long micros = timer.getMicros();
        try {
            Response execute = call.execute();
            a(execute, b11, micros, timer.getDurationMicros());
            return execute;
        } catch (IOException e11) {
            Request request = call.request();
            if (request != null) {
                HttpUrl url = request.url();
                if (url != null) {
                    b11.q(url.url().toString());
                }
                if (request.method() != null) {
                    b11.f(request.method());
                }
            }
            b11.k(micros);
            b11.o(timer.getDurationMicros());
            f.d(b11);
            throw e11;
        }
    }
}
