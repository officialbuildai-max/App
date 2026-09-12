package com.google.android.exoplayer2.drm;

import e9.u1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public interface c0 {

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f25023a;

        /* renamed from: b, reason: collision with root package name */
        private final String f25024b;

        /* renamed from: c, reason: collision with root package name */
        private final int f25025c;

        public a(byte[] bArr, String str, int i11) {
            this.f25023a = bArr;
            this.f25024b = str;
            this.f25025c = i11;
        }

        public byte[] a() {
            return this.f25023a;
        }

        public String b() {
            return this.f25024b;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(c0 c0Var, byte[] bArr, int i11, int i12, byte[] bArr2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        c0 a(UUID uuid);
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f25026a;

        /* renamed from: b, reason: collision with root package name */
        private final String f25027b;

        public d(byte[] bArr, String str) {
            this.f25026a = bArr;
            this.f25027b = str;
        }

        public byte[] a() {
            return this.f25026a;
        }

        public String b() {
            return this.f25027b;
        }
    }

    int a();

    com.google.android.exoplayer2.decoder.b b(byte[] bArr);

    boolean c(byte[] bArr, String str);

    void closeSession(byte[] bArr);

    a d(byte[] bArr, List list, int i11, HashMap hashMap);

    void e(b bVar);

    void f(byte[] bArr, u1 u1Var);

    d getProvisionRequest();

    byte[] openSession();

    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2);

    void provideProvisionResponse(byte[] bArr);

    Map queryKeyStatus(byte[] bArr);

    void release();

    void restoreKeys(byte[] bArr, byte[] bArr2);
}
