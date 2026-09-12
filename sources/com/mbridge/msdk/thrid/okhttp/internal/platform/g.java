package com.mbridge.msdk.thrid.okhttp.internal.platform;

import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.u;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final g f38300a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f38301b = Logger.getLogger(t.class.getName());

    private static g a() {
        g h11 = a.h();
        if (h11 != null) {
            return h11;
        }
        g h12 = b.h();
        if (h12 != null) {
            return h12;
        }
        throw new NullPointerException("No platform found on Android");
    }

    public static List<String> a(List<u> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            u uVar = list.get(i11);
            if (uVar != u.HTTP_1_0) {
                arrayList.add(uVar.toString());
            }
        }
        return arrayList;
    }

    private static g b() {
        c h11;
        if (g() && (h11 = c.h()) != null) {
            return h11;
        }
        d h12 = d.h();
        if (h12 != null) {
            return h12;
        }
        g h13 = e.h();
        return h13 != null ? h13 : new g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(List<u> list) {
        com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            u uVar = list.get(i11);
            if (uVar != u.HTTP_1_0) {
                cVar.writeByte(uVar.toString().length());
                cVar.a(uVar.toString());
            }
        }
        return cVar.n();
    }

    private static g c() {
        return f() ? a() : b();
    }

    public static g d() {
        return f38300a;
    }

    public static boolean f() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static boolean g() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public com.mbridge.msdk.thrid.okhttp.internal.tls.c a(X509TrustManager x509TrustManager) {
        return new com.mbridge.msdk.thrid.okhttp.internal.tls.a(b(x509TrustManager));
    }

    public Object a(String str) {
        if (f38301b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(int i11, String str, Throwable th2) {
        f38301b.log(i11 == 5 ? Level.WARNING : Level.INFO, str, th2);
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i11) throws IOException {
        socket.connect(inetSocketAddress, i11);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<u> list) throws IOException {
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
    }

    public com.mbridge.msdk.thrid.okhttp.internal.tls.e b(X509TrustManager x509TrustManager) {
        return new com.mbridge.msdk.thrid.okhttp.internal.tls.b(x509TrustManager.getAcceptedIssuers());
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public boolean b(String str) {
        return true;
    }

    public SSLContext e() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e11) {
            throw new IllegalStateException("No TLS provider", e11);
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
