package com.mbridge.msdk.thrid.okhttp.internal.platform;

import android.os.Build;
import android.util.Log;
import com.mbridge.msdk.thrid.okhttp.u;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class b extends g {

    /* renamed from: c, reason: collision with root package name */
    private final Class<?> f38274c;

    /* renamed from: d, reason: collision with root package name */
    private final f<Socket> f38275d;

    /* renamed from: e, reason: collision with root package name */
    private final f<Socket> f38276e;

    /* renamed from: f, reason: collision with root package name */
    private final f<Socket> f38277f;

    /* renamed from: g, reason: collision with root package name */
    private final f<Socket> f38278g;

    /* renamed from: h, reason: collision with root package name */
    private final c f38279h = c.a();

    /* loaded from: classes5.dex */
    static final class a extends com.mbridge.msdk.thrid.okhttp.internal.tls.c {

        /* renamed from: a, reason: collision with root package name */
        private final Object f38280a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f38281b;

        a(Object obj, Method method) {
            this.f38280a = obj;
            this.f38281b = method;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.tls.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f38281b.invoke(this.f38280a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            } catch (InvocationTargetException e12) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e12.getMessage());
                sSLPeerUnverifiedException.initCause(e12);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: com.mbridge.msdk.thrid.okhttp.internal.platform.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C0552b implements com.mbridge.msdk.thrid.okhttp.internal.tls.e {

        /* renamed from: a, reason: collision with root package name */
        private final X509TrustManager f38282a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f38283b;

        C0552b(X509TrustManager x509TrustManager, Method method) {
            this.f38283b = method;
            this.f38282a = x509TrustManager;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.tls.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f38283b.invoke(this.f38282a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e11) {
                throw com.mbridge.msdk.thrid.okhttp.internal.c.a("unable to get issues and signature", (Exception) e11);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0552b)) {
                return false;
            }
            C0552b c0552b = (C0552b) obj;
            return this.f38282a.equals(c0552b.f38282a) && this.f38283b.equals(c0552b.f38283b);
        }

        public int hashCode() {
            return this.f38282a.hashCode() + (this.f38283b.hashCode() * 31);
        }
    }

    /* loaded from: classes5.dex */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Method f38284a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f38285b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f38286c;

        c(Method method, Method method2, Method method3) {
            this.f38284a = method;
            this.f38285b = method2;
            this.f38286c = method3;
        }

        static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", null);
                method2 = cls.getMethod(MRAIDPresenter.OPEN, String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }

        Object a(String str) {
            Method method = this.f38284a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, null);
                    this.f38285b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean a(Object obj) {
            if (obj != null) {
                try {
                    this.f38286c.invoke(obj, null);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Class<?> cls, f<Socket> fVar, f<Socket> fVar2, f<Socket> fVar3, f<Socket> fVar4) {
        this.f38274c = cls;
        this.f38275d = fVar;
        this.f38276e = fVar2;
        this.f38277f = fVar3;
        this.f38278g = fVar4;
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return a(str, cls, obj);
        }
    }

    public static g h() {
        Class<?> cls;
        f fVar;
        f fVar2;
        if (!g.f()) {
            return null;
        }
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            f fVar3 = new f(null, "setUseSessionTickets", Boolean.TYPE);
            f fVar4 = new f(null, "setHostname", String.class);
            if (j()) {
                fVar = new f(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                fVar2 = new f(null, "setAlpnProtocols", byte[].class);
            } else {
                fVar = null;
                fVar2 = null;
            }
            return new b(cls2, fVar3, fVar4, fVar, fVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    private static boolean j() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public com.mbridge.msdk.thrid.okhttp.internal.tls.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public Object a(String str) {
        return this.f38279h.a(str);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public void a(int i11, String str, Throwable th2) {
        int min;
        int i12 = i11 != 5 ? 3 : 5;
        if (th2 != null) {
            str = str + '\n' + Log.getStackTraceString(th2);
        }
        int length = str.length();
        int i13 = 0;
        while (i13 < length) {
            int indexOf = str.indexOf(10, i13);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i13 + 4000);
                Log.println(i12, "OkHttp", str.substring(i13, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i13 = min;
                }
            }
            i13 = min + 1;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public void a(String str, Object obj) {
        if (this.f38279h.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i11) throws IOException {
        try {
            socket.connect(inetSocketAddress, i11);
        } catch (AssertionError e11) {
            if (!com.mbridge.msdk.thrid.okhttp.internal.c.a(e11)) {
                throw e11;
            }
            throw new IOException(e11);
        } catch (ClassCastException e12) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e12;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e12);
            throw iOException;
        } catch (SecurityException e13) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e13);
            throw iOException2;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public void a(SSLSocket sSLSocket, String str, List<u> list) throws IOException {
        if (str != null) {
            this.f38275d.c(sSLSocket, Boolean.TRUE);
            this.f38276e.c(sSLSocket, str);
        }
        f<Socket> fVar = this.f38278g;
        if (fVar == null || !fVar.a((f<Socket>) sSLSocket)) {
            return;
        }
        this.f38278g.d(sSLSocket, g.b(list));
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public com.mbridge.msdk.thrid.okhttp.internal.tls.e b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new C0552b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public String b(SSLSocket sSLSocket) {
        byte[] bArr;
        f<Socket> fVar = this.f38277f;
        if (fVar == null || !fVar.a((f<Socket>) sSLSocket) || (bArr = (byte[]) this.f38277f.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.mbridge.msdk.thrid.okhttp.internal.c.f37964j);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return b(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException e11) {
            e = e11;
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e12) {
            e = e12;
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e13) {
            e = e13;
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("unable to determine cleartext support", e);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public SSLContext e() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e11) {
            throw new IllegalStateException("No TLS provider", e11);
        }
    }
}
