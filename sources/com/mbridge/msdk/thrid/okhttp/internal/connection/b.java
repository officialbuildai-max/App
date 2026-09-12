package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.i;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<i> f37991a;

    /* renamed from: b, reason: collision with root package name */
    private int f37992b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f37993c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f37994d;

    public b(List<i> list) {
        this.f37991a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i11 = this.f37992b; i11 < this.f37991a.size(); i11++) {
            if (this.f37991a.get(i11).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public i a(SSLSocket sSLSocket) throws IOException {
        i iVar;
        int i11 = this.f37992b;
        int size = this.f37991a.size();
        while (true) {
            if (i11 >= size) {
                iVar = null;
                break;
            }
            iVar = this.f37991a.get(i11);
            if (iVar.a(sSLSocket)) {
                this.f37992b = i11 + 1;
                break;
            }
            i11++;
        }
        if (iVar != null) {
            this.f37993c = b(sSLSocket);
            com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(iVar, sSLSocket, this.f37994d);
            return iVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f37994d + ", modes=" + this.f37991a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.f37994d = true;
        if (!this.f37993c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z10 = iOException instanceof SSLHandshakeException;
        if ((z10 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z10 || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }
}
