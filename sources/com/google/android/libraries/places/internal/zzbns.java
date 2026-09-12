package com.google.android.libraries.places.internal;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbns {
    public static final PasswordAuthentication zza(String str, InetAddress inetAddress, int i11, String str2, String str3, String str4) {
        Logger logger;
        URL url;
        try {
            url = new URL("https", str, i11, "");
        } catch (MalformedURLException unused) {
            logger = zzbnu.zza;
            logger.logp(Level.WARNING, "io.grpc.internal.ProxyDetectorImpl$1", "requestPasswordAuthentication", "failed to create URL for Authenticator: {0} {1}", new Object[]{"https", str});
            url = null;
        }
        return Authenticator.requestPasswordAuthentication(str, inetAddress, i11, "https", "", null, url, Authenticator.RequestorType.PROXY);
    }
}
