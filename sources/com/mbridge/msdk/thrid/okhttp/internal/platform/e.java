package com.mbridge.msdk.thrid.okhttp.internal.platform;

import com.mbridge.msdk.thrid.okhttp.u;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e extends g {

    /* renamed from: c, reason: collision with root package name */
    private final Method f38289c;

    /* renamed from: d, reason: collision with root package name */
    private final Method f38290d;

    /* renamed from: e, reason: collision with root package name */
    private final Method f38291e;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f38292f;

    /* renamed from: g, reason: collision with root package name */
    private final Class<?> f38293g;

    /* loaded from: classes5.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f38294a;

        /* renamed from: b, reason: collision with root package name */
        boolean f38295b;

        /* renamed from: c, reason: collision with root package name */
        String f38296c;

        a(List<String> list) {
            this.f38294a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.mbridge.msdk.thrid.okhttp.internal.c.f37956b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f38295b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f38294a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        if (this.f38294a.contains(list.get(i11))) {
                            String str = (String) list.get(i11);
                            this.f38296c = str;
                            return str;
                        }
                    }
                    String str2 = this.f38294a.get(0);
                    this.f38296c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f38296c = (String) objArr[0];
            return null;
        }
    }

    e(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f38289c = method;
        this.f38290d = method2;
        this.f38291e = method3;
        this.f38292f = cls;
        this.f38293g = cls2;
    }

    public static g h() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new e(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public void a(SSLSocket sSLSocket) {
        try {
            this.f38291e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("unable to remove alpn", (Exception) e11);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public void a(SSLSocket sSLSocket, String str, List<u> list) {
        try {
            this.f38289c.invoke(null, sSLSocket, Proxy.newProxyInstance(g.class.getClassLoader(), new Class[]{this.f38292f, this.f38293g}, new a(g.a(list))));
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("unable to set alpn", (Exception) e11);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public String b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f38290d.invoke(null, sSLSocket));
            boolean z10 = aVar.f38295b;
            if (!z10 && aVar.f38296c == null) {
                g.d().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (z10) {
                return null;
            }
            return aVar.f38296c;
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("unable to get selected protocol", (Exception) e11);
        }
    }
}
