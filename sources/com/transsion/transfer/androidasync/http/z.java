package com.transsion.transfer.androidasync.http;

import com.google.android.gms.security.ProviderInstaller;
import com.transsion.transfer.androidasync.http.g;
import java.lang.reflect.Field;
import java.util.Hashtable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/* loaded from: classes6.dex */
public class z implements m {

    /* renamed from: a, reason: collision with root package name */
    Hashtable f55650a = new Hashtable();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements m {

        /* renamed from: a, reason: collision with root package name */
        Field f55651a;

        /* renamed from: b, reason: collision with root package name */
        Field f55652b;

        /* renamed from: c, reason: collision with root package name */
        Field f55653c;

        /* renamed from: d, reason: collision with root package name */
        Field f55654d;

        /* renamed from: e, reason: collision with root package name */
        boolean f55655e;

        public a(Class cls) {
            try {
                Field declaredField = cls.getSuperclass().getDeclaredField("peerHost");
                this.f55651a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getSuperclass().getDeclaredField("peerPort");
                this.f55652b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("sslParameters");
                this.f55653c = declaredField3;
                declaredField3.setAccessible(true);
                Field declaredField4 = this.f55653c.getType().getDeclaredField("useSni");
                this.f55654d = declaredField4;
                declaredField4.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        }

        @Override // com.transsion.transfer.androidasync.http.m
        public SSLEngine a(SSLContext sSLContext, String str, int i11) {
            return null;
        }

        @Override // com.transsion.transfer.androidasync.http.m
        public void b(SSLEngine sSLEngine, g.a aVar, String str, int i11) {
            if (this.f55654d != null && !this.f55655e) {
                try {
                    this.f55651a.set(sSLEngine, str);
                    this.f55652b.set(sSLEngine, Integer.valueOf(i11));
                    this.f55654d.set(this.f55653c.get(sSLEngine), Boolean.TRUE);
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    @Override // com.transsion.transfer.androidasync.http.m
    public SSLEngine a(SSLContext sSLContext, String str, int i11) {
        ProviderInstaller.PROVIDER_NAME.equals(sSLContext.getProvider().getName());
        return sSLContext.createSSLEngine(str, i11);
    }

    @Override // com.transsion.transfer.androidasync.http.m
    public void b(SSLEngine sSLEngine, g.a aVar, String str, int i11) {
        c(sSLEngine).b(sSLEngine, aVar, str, i11);
    }

    a c(SSLEngine sSLEngine) {
        String canonicalName = sSLEngine.getClass().getCanonicalName();
        a aVar = (a) this.f55650a.get(canonicalName);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(sSLEngine.getClass());
        this.f55650a.put(canonicalName, aVar2);
        return aVar2;
    }
}
