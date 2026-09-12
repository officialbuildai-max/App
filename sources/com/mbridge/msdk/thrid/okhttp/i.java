package com.mbridge.msdk.thrid.okhttp;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    private static final f[] f37939e;

    /* renamed from: f, reason: collision with root package name */
    private static final f[] f37940f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f37941g;

    /* renamed from: h, reason: collision with root package name */
    public static final i f37942h;

    /* renamed from: i, reason: collision with root package name */
    public static final i f37943i;

    /* renamed from: j, reason: collision with root package name */
    public static final i f37944j;

    /* renamed from: a, reason: collision with root package name */
    final boolean f37945a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f37946b;

    /* renamed from: c, reason: collision with root package name */
    final String[] f37947c;

    /* renamed from: d, reason: collision with root package name */
    final String[] f37948d;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f37949a;

        /* renamed from: b, reason: collision with root package name */
        String[] f37950b;

        /* renamed from: c, reason: collision with root package name */
        String[] f37951c;

        /* renamed from: d, reason: collision with root package name */
        boolean f37952d;

        public a(i iVar) {
            this.f37949a = iVar.f37945a;
            this.f37950b = iVar.f37947c;
            this.f37951c = iVar.f37948d;
            this.f37952d = iVar.f37946b;
        }

        a(boolean z10) {
            this.f37949a = z10;
        }

        public a a(boolean z10) {
            if (!this.f37949a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f37952d = z10;
            return this;
        }

        public a a(b0... b0VarArr) {
            if (!this.f37949a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[b0VarArr.length];
            for (int i11 = 0; i11 < b0VarArr.length; i11++) {
                strArr[i11] = b0VarArr[i11].f37828a;
            }
            return b(strArr);
        }

        public a a(f... fVarArr) {
            if (!this.f37949a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[fVarArr.length];
            for (int i11 = 0; i11 < fVarArr.length; i11++) {
                strArr[i11] = fVarArr[i11].f37929a;
            }
            return a(strArr);
        }

        public a a(String... strArr) {
            if (!this.f37949a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f37950b = (String[]) strArr.clone();
            return this;
        }

        public i a() {
            return new i(this);
        }

        public a b(String... strArr) {
            if (!this.f37949a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f37951c = (String[]) strArr.clone();
            return this;
        }
    }

    static {
        f fVar = f.f37900n1;
        f fVar2 = f.f37903o1;
        f fVar3 = f.f37906p1;
        f fVar4 = f.f37909q1;
        f fVar5 = f.f37912r1;
        f fVar6 = f.Z0;
        f fVar7 = f.f37870d1;
        f fVar8 = f.f37861a1;
        f fVar9 = f.f37873e1;
        f fVar10 = f.f37891k1;
        f fVar11 = f.f37888j1;
        f[] fVarArr = {fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11};
        f37939e = fVarArr;
        f[] fVarArr2 = {fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, f.K0, f.L0, f.f37884i0, f.f37887j0, f.G, f.K, f.f37889k};
        f37940f = fVarArr2;
        a a11 = new a(true).a(fVarArr);
        b0 b0Var = b0.TLS_1_3;
        b0 b0Var2 = b0.TLS_1_2;
        f37941g = a11.a(b0Var, b0Var2).a(true).a();
        a a12 = new a(true).a(fVarArr2);
        b0 b0Var3 = b0.TLS_1_0;
        f37942h = a12.a(b0Var, b0Var2, b0.TLS_1_1, b0Var3).a(true).a();
        f37943i = new a(true).a(fVarArr2).a(b0Var3).a(true).a();
        f37944j = new a(false).a();
    }

    i(a aVar) {
        this.f37945a = aVar.f37949a;
        this.f37947c = aVar.f37950b;
        this.f37948d = aVar.f37951c;
        this.f37946b = aVar.f37952d;
    }

    private i b(SSLSocket sSLSocket, boolean z10) {
        String[] a11 = this.f37947c != null ? com.mbridge.msdk.thrid.okhttp.internal.c.a(f.f37862b, sSLSocket.getEnabledCipherSuites(), this.f37947c) : sSLSocket.getEnabledCipherSuites();
        String[] a12 = this.f37948d != null ? com.mbridge.msdk.thrid.okhttp.internal.c.a(com.mbridge.msdk.thrid.okhttp.internal.c.f37971q, sSLSocket.getEnabledProtocols(), this.f37948d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a13 = com.mbridge.msdk.thrid.okhttp.internal.c.a(f.f37862b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z10 && a13 != -1) {
            a11 = com.mbridge.msdk.thrid.okhttp.internal.c.a(a11, supportedCipherSuites[a13]);
        }
        return new a(this).a(a11).b(a12).a();
    }

    public List<f> a() {
        String[] strArr = this.f37947c;
        if (strArr != null) {
            return f.a(strArr);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z10) {
        i b11 = b(sSLSocket, z10);
        String[] strArr = b11.f37948d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b11.f37947c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f37945a) {
            return false;
        }
        String[] strArr = this.f37948d;
        if (strArr != null && !com.mbridge.msdk.thrid.okhttp.internal.c.b(com.mbridge.msdk.thrid.okhttp.internal.c.f37971q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f37947c;
        return strArr2 == null || com.mbridge.msdk.thrid.okhttp.internal.c.b(f.f37862b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean b() {
        return this.f37945a;
    }

    public boolean c() {
        return this.f37946b;
    }

    public List<b0> d() {
        String[] strArr = this.f37948d;
        if (strArr != null) {
            return b0.a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        i iVar = (i) obj;
        boolean z10 = this.f37945a;
        if (z10 != iVar.f37945a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f37947c, iVar.f37947c) && Arrays.equals(this.f37948d, iVar.f37948d) && this.f37946b == iVar.f37946b);
    }

    public int hashCode() {
        if (this.f37945a) {
            return ((((Arrays.hashCode(this.f37947c) + 527) * 31) + Arrays.hashCode(this.f37948d)) * 31) + (!this.f37946b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f37945a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f37947c != null ? a().toString() : "[all enabled]") + ", tlsVersions=" + (this.f37948d != null ? d().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f37946b + ")";
    }
}
