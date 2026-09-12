package com.mbridge.msdk.tracker.network.toolbox;

import android.os.SystemClock;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.tracker.network.a0;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.b0;
import com.mbridge.msdk.tracker.network.c0;
import com.mbridge.msdk.tracker.network.p;
import com.mbridge.msdk.tracker.network.q;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.t;
import com.mbridge.msdk.tracker.network.x;
import com.mbridge.msdk.tracker.network.y;
import com.mbridge.msdk.tracker.network.z;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

/* loaded from: classes5.dex */
final class k {

    /* loaded from: classes5.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        final String f38729a;

        /* renamed from: b, reason: collision with root package name */
        final b0 f38730b;

        private b(String str, b0 b0Var) {
            this.f38729a = str;
            this.f38730b = b0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q a(t<?> tVar, long j11, List<com.mbridge.msdk.tracker.network.g> list) {
        b.a d11 = tVar.d();
        if (d11 == null) {
            return new q(Sdk$SDKError.Reason.AD_EXPIRED_VALUE, null, true, j11, list);
        }
        return new q(Sdk$SDKError.Reason.AD_EXPIRED_VALUE, d11.f38606a, true, j11, f.a(list, d11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(t<?> tVar, IOException iOException, long j11, g gVar, byte[] bArr) throws b0 {
        if (iOException instanceof SocketTimeoutException) {
            return new b("socket", new z());
        }
        if (iOException instanceof MalformedURLException) {
            throw new com.mbridge.msdk.tracker.network.a("Bad URL " + tVar.t());
        }
        if (gVar == null) {
            if (tVar.A()) {
                return new b("connection", new r());
            }
            throw new r(iOException);
        }
        int d11 = gVar.d();
        c0.c("Unexpected response code %d for %s", Integer.valueOf(d11), tVar.t());
        if (bArr == null) {
            com.mbridge.msdk.tracker.network.o oVar = new com.mbridge.msdk.tracker.network.o();
            oVar.a(d11);
            return new b("network", oVar);
        }
        q qVar = new q(d11, bArr, false, SystemClock.elapsedRealtime() - j11, gVar.c());
        if (d11 >= 400 && d11 <= 499) {
            com.mbridge.msdk.tracker.network.d dVar = new com.mbridge.msdk.tracker.network.d(qVar);
            dVar.a(d11);
            throw dVar;
        }
        y yVar = new y(qVar);
        yVar.a(d11);
        if (d11 < 500) {
            throw yVar;
        }
        if (d11 > 599) {
            throw yVar;
        }
        if (tVar.B()) {
            return new b(TmcConstants.CHANNEL_REQUEST_SERVER, yVar);
        }
        throw yVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j11, t<?> tVar, byte[] bArr, int i11) {
        if (j11 > 3000) {
            c0.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", tVar, Long.valueOf(j11), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(i11), Integer.valueOf(tVar.o().c()));
        }
    }

    private static void a(p pVar) {
        if (pVar != null) {
            pVar.c(0L);
        }
    }

    private static void a(p pVar, int i11) {
        if (pVar != null) {
            pVar.c(pVar.B() + i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(t<?> tVar, b bVar) throws b0 {
        if (tVar == null) {
            throw new a0("request is null when retrying");
        }
        if (bVar == null) {
            throw new a0("retry info is null when retrying");
        }
        x o11 = tVar.o();
        if (o11 == null) {
            throw bVar.f38730b;
        }
        if (!o11.a(bVar.f38730b)) {
            throw bVar.f38730b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(InputStream inputStream, int i11, c cVar, p pVar) throws IOException {
        byte[] bArr;
        n nVar = new n(cVar, i11);
        a(pVar);
        try {
            bArr = cVar.a(1024);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    nVar.write(bArr, 0, read);
                    a(pVar, read);
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            c0.d("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    cVar.a(bArr);
                    nVar.close();
                    throw th;
                }
            }
            byte[] byteArray = nVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                c0.d("Error occurred when closing InputStream", new Object[0]);
            }
            cVar.a(bArr);
            nVar.close();
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            bArr = null;
        }
    }
}
