package androidx.media3.exoplayer.drm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import y1.f4;

/* loaded from: classes2.dex */
public interface b0 {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f11645a;

        /* renamed from: b, reason: collision with root package name */
        private final String f11646b;

        /* renamed from: c, reason: collision with root package name */
        private final int f11647c;

        public a(byte[] bArr, String str, int i11) {
            this.f11645a = bArr;
            this.f11646b = str;
            this.f11647c = i11;
        }

        public byte[] a() {
            return this.f11645a;
        }

        public String b() {
            return this.f11646b;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(b0 b0Var, byte[] bArr, int i11, int i12, byte[] bArr2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        b0 a(UUID uuid);
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f11648a;

        /* renamed from: b, reason: collision with root package name */
        private final String f11649b;

        public d(byte[] bArr, String str) {
            this.f11648a = bArr;
            this.f11649b = str;
        }

        public byte[] a() {
            return this.f11648a;
        }

        public String b() {
            return this.f11649b;
        }
    }

    int a();

    androidx.media3.decoder.b b(byte[] bArr);

    boolean c(byte[] bArr, String str);

    void closeSession(byte[] bArr);

    a d(byte[] bArr, List list, int i11, HashMap hashMap);

    void e(byte[] bArr, f4 f4Var);

    void f(b bVar);

    d getProvisionRequest();

    byte[] openSession();

    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2);

    void provideProvisionResponse(byte[] bArr);

    Map queryKeyStatus(byte[] bArr);

    void release();

    void restoreKeys(byte[] bArr, byte[] bArr2);
}
