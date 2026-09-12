package com.squareup.okhttp.internal;

import com.squareup.okhttp.ConnectionSpec;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final List f40338a;

    /* renamed from: b, reason: collision with root package name */
    private int f40339b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f40340c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40341d;

    public a(List list) {
        this.f40338a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i11 = this.f40339b; i11 < this.f40338a.size(); i11++) {
            if (((ConnectionSpec) this.f40338a.get(i11)).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public ConnectionSpec a(SSLSocket sSLSocket) {
        ConnectionSpec connectionSpec;
        int i11 = this.f40339b;
        int size = this.f40338a.size();
        while (true) {
            if (i11 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = (ConnectionSpec) this.f40338a.get(i11);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.f40339b = i11 + 1;
                break;
            }
            i11++;
        }
        if (connectionSpec != null) {
            this.f40340c = c(sSLSocket);
            c.instance.apply(connectionSpec, sSLSocket, this.f40341d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f40341d + ", modes=" + this.f40338a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f40341d = true;
        if (!this.f40340c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z10 = iOException instanceof SSLHandshakeException;
        if ((z10 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z10 || (iOException instanceof SSLProtocolException);
    }
}
