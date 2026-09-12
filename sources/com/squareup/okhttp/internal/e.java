package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final e f40346a = e();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends e {

        /* renamed from: b, reason: collision with root package name */
        private final d f40347b;

        /* renamed from: c, reason: collision with root package name */
        private final d f40348c;

        /* renamed from: d, reason: collision with root package name */
        private final Method f40349d;

        /* renamed from: e, reason: collision with root package name */
        private final Method f40350e;

        /* renamed from: f, reason: collision with root package name */
        private final d f40351f;

        /* renamed from: g, reason: collision with root package name */
        private final d f40352g;

        public a(d dVar, d dVar2, Method method, Method method2, d dVar3, d dVar4) {
            this.f40347b = dVar;
            this.f40348c = dVar2;
            this.f40349d = method;
            this.f40350e = method2;
            this.f40351f = dVar3;
            this.f40352g = dVar4;
        }

        @Override // com.squareup.okhttp.internal.e
        public void c(SSLSocket sSLSocket, String str, List list) {
            if (str != null) {
                this.f40347b.e(sSLSocket, Boolean.TRUE);
                this.f40348c.e(sSLSocket, str);
            }
            d dVar = this.f40352g;
            if (dVar == null || !dVar.g(sSLSocket)) {
                return;
            }
            this.f40352g.f(sSLSocket, e.b(list));
        }

        @Override // com.squareup.okhttp.internal.e
        public void d(Socket socket, InetSocketAddress inetSocketAddress, int i11) {
            try {
                socket.connect(inetSocketAddress, i11);
            } catch (AssertionError e11) {
                if (!g.o(e11)) {
                    throw e11;
                }
                throw new IOException(e11);
            } catch (SecurityException e12) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e12);
                throw iOException;
            }
        }

        @Override // com.squareup.okhttp.internal.e
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            d dVar = this.f40351f;
            if (dVar == null || !dVar.g(sSLSocket) || (bArr = (byte[]) this.f40351f.f(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, g.f40486c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends e {

        /* renamed from: b, reason: collision with root package name */
        private final Method f40353b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f40354c;

        /* renamed from: d, reason: collision with root package name */
        private final Method f40355d;

        /* renamed from: e, reason: collision with root package name */
        private final Class f40356e;

        /* renamed from: f, reason: collision with root package name */
        private final Class f40357f;

        public b(Method method, Method method2, Method method3, Class cls, Class cls2) {
            this.f40353b = method;
            this.f40354c = method2;
            this.f40355d = method3;
            this.f40356e = cls;
            this.f40357f = cls2;
        }

        @Override // com.squareup.okhttp.internal.e
        public void a(SSLSocket sSLSocket) {
            try {
                this.f40355d.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }

        @Override // com.squareup.okhttp.internal.e
        public void c(SSLSocket sSLSocket, String str, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Protocol protocol = (Protocol) list.get(i11);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                this.f40353b.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f40356e, this.f40357f}, new c(arrayList)));
            } catch (IllegalAccessException | InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }

        @Override // com.squareup.okhttp.internal.e
        public String h(SSLSocket sSLSocket) {
            try {
                c cVar = (c) Proxy.getInvocationHandler(this.f40354c.invoke(null, sSLSocket));
                if (!cVar.f40359b && cVar.f40360c == null) {
                    com.squareup.okhttp.internal.c.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (cVar.f40359b) {
                    return null;
                }
                return cVar.f40360c;
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }
    }

    /* loaded from: classes5.dex */
    private static class c implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final List f40358a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f40359b;

        /* renamed from: c, reason: collision with root package name */
        private String f40360c;

        public c(List list) {
            this.f40358a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = g.f40485b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f40359b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f40358a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        if (this.f40358a.contains(list.get(i11))) {
                            String str = (String) list.get(i11);
                            this.f40360c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f40358a.get(0);
                    this.f40360c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f40360c = (String) objArr[0];
            return null;
        }
    }

    static byte[] b(List list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Protocol protocol = (Protocol) list.get(i11);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    private static e e() {
        Method method;
        d dVar;
        Method method2;
        try {
            try {
                try {
                    Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
                } catch (ClassNotFoundException unused) {
                    Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                    return new b(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return new e();
            }
        } catch (ClassNotFoundException unused3) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        d dVar2 = null;
        d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
        d dVar4 = new d(null, "setHostname", String.class);
        try {
            Class<?> cls3 = Class.forName("android.net.TrafficStats");
            method2 = cls3.getMethod("tagSocket", Socket.class);
            try {
                method = cls3.getMethod("untagSocket", Socket.class);
                try {
                    Class.forName("android.net.Network");
                    dVar = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    try {
                        dVar2 = new d(null, "setAlpnProtocols", byte[].class);
                    } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    dVar = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused6) {
                method = null;
                dVar = null;
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused7) {
            method = null;
            dVar = null;
            method2 = null;
        }
        return new a(dVar3, dVar4, method2, method, dVar, dVar2);
    }

    public static e f() {
        return f40346a;
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }

    public void d(Socket socket, InetSocketAddress inetSocketAddress, int i11) {
        socket.connect(inetSocketAddress, i11);
    }

    public String g() {
        return "OkHttp";
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public void i(String str) {
        System.out.println(str);
    }
}
