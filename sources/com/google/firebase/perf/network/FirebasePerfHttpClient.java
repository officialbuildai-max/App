package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
import uc.e;
import uc.f;
import vc.k;

/* loaded from: classes4.dex */
public class FirebasePerfHttpClient {
    static Object a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, Timer timer, k kVar) {
        i b11 = i.b(kVar);
        try {
            b11.q(httpHost.toURI() + httpRequest.getRequestLine().getUri()).f(httpRequest.getRequestLine().getMethod());
            Long a11 = f.a(httpRequest);
            if (a11 != null) {
                b11.j(a11.longValue());
            }
            timer.reset();
            b11.k(timer.getMicros());
            return httpClient.execute(httpHost, httpRequest, new e(responseHandler, timer, b11));
        } catch (IOException e11) {
            b11.o(timer.getDurationMicros());
            f.d(b11);
            throw e11;
        }
    }

    static Object b(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext, Timer timer, k kVar) {
        i b11 = i.b(kVar);
        try {
            b11.q(httpHost.toURI() + httpRequest.getRequestLine().getUri()).f(httpRequest.getRequestLine().getMethod());
            Long a11 = f.a(httpRequest);
            if (a11 != null) {
                b11.j(a11.longValue());
            }
            timer.reset();
            b11.k(timer.getMicros());
            return httpClient.execute(httpHost, httpRequest, new e(responseHandler, timer, b11), httpContext);
        } catch (IOException e11) {
            b11.o(timer.getDurationMicros());
            f.d(b11);
            throw e11;
        }
    }

    static Object c(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler, Timer timer, k kVar) {
        i b11 = i.b(kVar);
        try {
            b11.q(httpUriRequest.getURI().toString()).f(httpUriRequest.getMethod());
            Long a11 = f.a(httpUriRequest);
            if (a11 != null) {
                b11.j(a11.longValue());
            }
            timer.reset();
            b11.k(timer.getMicros());
            return httpClient.execute(httpUriRequest, new e(responseHandler, timer, b11));
        } catch (IOException e11) {
            b11.o(timer.getDurationMicros());
            f.d(b11);
            throw e11;
        }
    }

    static Object d(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext, Timer timer, k kVar) {
        i b11 = i.b(kVar);
        try {
            b11.q(httpUriRequest.getURI().toString()).f(httpUriRequest.getMethod());
            Long a11 = f.a(httpUriRequest);
            if (a11 != null) {
                b11.j(a11.longValue());
            }
            timer.reset();
            b11.k(timer.getMicros());
            return httpClient.execute(httpUriRequest, new e(responseHandler, timer, b11), httpContext);
        } catch (IOException e11) {
            b11.o(timer.getDurationMicros());
            f.d(b11);
            throw e11;
        }
    }

    static HttpResponse e(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, Timer timer, k kVar) {
        i b11 = i.b(kVar);
        try {
            b11.q(httpHost.toURI() + httpRequest.getRequestLine().getUri()).f(httpRequest.getRequestLine().getMethod());
            Long a11 = f.a(httpRequest);
            if (a11 != null) {
                b11.j(a11.longValue());
            }
            timer.reset();
            b11.k(timer.getMicros());
            HttpResponse execute = httpClient.execute(httpHost, httpRequest);
            b11.o(timer.getDurationMicros());
            b11.g(execute.getStatusLine().getStatusCode());
            Long a12 = f.a(execute);
            if (a12 != null) {
                b11.m(a12.longValue());
            }
            String b12 = f.b(execute);
            if (b12 != null) {
                b11.l(b12);
            }
            b11.a();
            return execute;
        } catch (IOException e11) {
            b11.o(timer.getDurationMicros());
            f.d(b11);
            throw e11;
        }
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) a(httpClient, httpHost, httpRequest, responseHandler, new Timer(), k.k());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) b(httpClient, httpHost, httpRequest, responseHandler, httpContext, new Timer(), k.k());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        return (T) c(httpClient, httpUriRequest, responseHandler, new Timer(), k.k());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) d(httpClient, httpUriRequest, responseHandler, httpContext, new Timer(), k.k());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return e(httpClient, httpHost, httpRequest, new Timer(), k.k());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return f(httpClient, httpHost, httpRequest, httpContext, new Timer(), k.k());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        return g(httpClient, httpUriRequest, new Timer(), k.k());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return h(httpClient, httpUriRequest, httpContext, new Timer(), k.k());
    }

    static HttpResponse f(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, Timer timer, k kVar) {
        i b11 = i.b(kVar);
        try {
            b11.q(httpHost.toURI() + httpRequest.getRequestLine().getUri()).f(httpRequest.getRequestLine().getMethod());
            Long a11 = f.a(httpRequest);
            if (a11 != null) {
                b11.j(a11.longValue());
            }
            timer.reset();
            b11.k(timer.getMicros());
            HttpResponse execute = httpClient.execute(httpHost, httpRequest, httpContext);
            b11.o(timer.getDurationMicros());
            b11.g(execute.getStatusLine().getStatusCode());
            Long a12 = f.a(execute);
            if (a12 != null) {
                b11.m(a12.longValue());
            }
            String b12 = f.b(execute);
            if (b12 != null) {
                b11.l(b12);
            }
            b11.a();
            return execute;
        } catch (IOException e11) {
            b11.o(timer.getDurationMicros());
            f.d(b11);
            throw e11;
        }
    }

    static HttpResponse g(HttpClient httpClient, HttpUriRequest httpUriRequest, Timer timer, k kVar) {
        i b11 = i.b(kVar);
        try {
            b11.q(httpUriRequest.getURI().toString()).f(httpUriRequest.getMethod());
            Long a11 = f.a(httpUriRequest);
            if (a11 != null) {
                b11.j(a11.longValue());
            }
            timer.reset();
            b11.k(timer.getMicros());
            HttpResponse execute = httpClient.execute(httpUriRequest);
            b11.o(timer.getDurationMicros());
            b11.g(execute.getStatusLine().getStatusCode());
            Long a12 = f.a(execute);
            if (a12 != null) {
                b11.m(a12.longValue());
            }
            String b12 = f.b(execute);
            if (b12 != null) {
                b11.l(b12);
            }
            b11.a();
            return execute;
        } catch (IOException e11) {
            b11.o(timer.getDurationMicros());
            f.d(b11);
            throw e11;
        }
    }

    static HttpResponse h(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, Timer timer, k kVar) {
        i b11 = i.b(kVar);
        try {
            b11.q(httpUriRequest.getURI().toString()).f(httpUriRequest.getMethod());
            Long a11 = f.a(httpUriRequest);
            if (a11 != null) {
                b11.j(a11.longValue());
            }
            timer.reset();
            b11.k(timer.getMicros());
            HttpResponse execute = httpClient.execute(httpUriRequest, httpContext);
            b11.o(timer.getDurationMicros());
            b11.g(execute.getStatusLine().getStatusCode());
            Long a12 = f.a(execute);
            if (a12 != null) {
                b11.m(a12.longValue());
            }
            String b12 = f.b(execute);
            if (b12 != null) {
                b11.l(b12);
            }
            b11.a();
            return execute;
        } catch (IOException e11) {
            b11.o(timer.getDurationMicros());
            f.d(b11);
            throw e11;
        }
    }
}
