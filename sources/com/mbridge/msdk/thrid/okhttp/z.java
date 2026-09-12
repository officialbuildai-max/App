package com.mbridge.msdk.thrid.okhttp;

import java.io.Closeable;
import java.io.InputStream;

/* loaded from: classes5.dex */
public abstract class z implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a extends z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f38470a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.thrid.okio.e f38471b;

        a(s sVar, long j11, com.mbridge.msdk.thrid.okio.e eVar) {
            this.f38470a = j11;
            this.f38471b = eVar;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.z
        public long h() {
            return this.f38470a;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.z
        public com.mbridge.msdk.thrid.okio.e k() {
            return this.f38471b;
        }
    }

    public static z a(s sVar, long j11, com.mbridge.msdk.thrid.okio.e eVar) {
        if (eVar != null) {
            return new a(sVar, j11, eVar);
        }
        throw new NullPointerException("source == null");
    }

    public static z a(s sVar, byte[] bArr) {
        return a(sVar, bArr.length, new com.mbridge.msdk.thrid.okio.c().write(bArr));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.mbridge.msdk.thrid.okhttp.internal.c.a(k());
    }

    public final InputStream d() {
        return k().j();
    }

    public abstract long h();

    public abstract com.mbridge.msdk.thrid.okio.e k();
}
