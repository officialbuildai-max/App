package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.c;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

/* loaded from: classes2.dex */
abstract class l {

    /* loaded from: classes2.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f19389a;

        /* renamed from: b, reason: collision with root package name */
        private final VolleyError f19390b;

        private b(String str, VolleyError volleyError) {
            this.f19389a = str;
            this.f19390b = volleyError;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Request request, b bVar) {
        com.android.volley.k retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.b(bVar.f19390b);
            request.addMarker(String.format("%s-retry [timeout=%s]", bVar.f19389a, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e11) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", bVar.f19389a, Integer.valueOf(timeoutMs)));
            throw e11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.android.volley.g b(Request request, long j11, List list) {
        c.a cacheEntry = request.getCacheEntry();
        if (cacheEntry == null) {
            return new com.android.volley.g(Sdk$SDKError.Reason.AD_EXPIRED_VALUE, (byte[]) null, true, j11, list);
        }
        return new com.android.volley.g(Sdk$SDKError.Reason.AD_EXPIRED_VALUE, cacheEntry.f19302a, true, j11, d.a(list, cacheEntry));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c(InputStream inputStream, int i11, ByteArrayPool byteArrayPool) {
        byte[] bArr;
        m mVar = new m(byteArrayPool, i11);
        try {
            bArr = byteArrayPool.a(1024);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    mVar.write(bArr, 0, read);
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            com.android.volley.l.e("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    byteArrayPool.b(bArr);
                    mVar.close();
                    throw th;
                }
            }
            byte[] byteArray = mVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                com.android.volley.l.e("Error occurred when closing InputStream", new Object[0]);
            }
            byteArrayPool.b(bArr);
            mVar.close();
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            bArr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(long j11, Request request, byte[] bArr, int i11) {
        if (com.android.volley.l.f19338b || j11 > 3000) {
            com.android.volley.l.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", request, Long.valueOf(j11), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(i11), Integer.valueOf(request.getRetryPolicy().a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b e(Request request, IOException iOException, long j11, e eVar, byte[] bArr) {
        if (iOException instanceof SocketTimeoutException) {
            return new b("socket", new TimeoutError());
        }
        if (iOException instanceof MalformedURLException) {
            throw new RuntimeException("Bad URL " + request.getUrl(), iOException);
        }
        if (eVar == null) {
            if (request.shouldRetryConnectionErrors()) {
                return new b("connection", new NoConnectionError());
            }
            throw new NoConnectionError(iOException);
        }
        int d11 = eVar.d();
        com.android.volley.l.c("Unexpected response code %d for %s", Integer.valueOf(d11), request.getUrl());
        if (bArr == null) {
            return new b("network", new NetworkError());
        }
        com.android.volley.g gVar = new com.android.volley.g(d11, bArr, false, SystemClock.elapsedRealtime() - j11, eVar.c());
        if (d11 == 401 || d11 == 403) {
            return new b("auth", new AuthFailureError(gVar));
        }
        if (d11 >= 400 && d11 <= 499) {
            throw new ClientError(gVar);
        }
        if (d11 < 500 || d11 > 599 || !request.shouldRetryServerErrors()) {
            throw new ServerError(gVar);
        }
        return new b(TmcConstants.CHANNEL_REQUEST_SERVER, new ServerError(gVar));
    }
}
