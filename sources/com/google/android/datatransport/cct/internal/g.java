package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.n;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class g extends n {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f24338a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f24339b;

    /* loaded from: classes3.dex */
    static final class b extends n.a {

        /* renamed from: a, reason: collision with root package name */
        private byte[] f24340a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f24341b;

        @Override // com.google.android.datatransport.cct.internal.n.a
        public n a() {
            return new g(this.f24340a, this.f24341b);
        }

        @Override // com.google.android.datatransport.cct.internal.n.a
        public n.a b(byte[] bArr) {
            this.f24340a = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.n.a
        public n.a c(byte[] bArr) {
            this.f24341b = bArr;
            return this;
        }
    }

    private g(byte[] bArr, byte[] bArr2) {
        this.f24338a = bArr;
        this.f24339b = bArr2;
    }

    @Override // com.google.android.datatransport.cct.internal.n
    public byte[] b() {
        return this.f24338a;
    }

    @Override // com.google.android.datatransport.cct.internal.n
    public byte[] c() {
        return this.f24339b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        boolean z10 = nVar instanceof g;
        if (Arrays.equals(this.f24338a, z10 ? ((g) nVar).f24338a : nVar.b())) {
            if (Arrays.equals(this.f24339b, z10 ? ((g) nVar).f24339b : nVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.f24338a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f24339b);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f24338a) + ", encryptedBlob=" + Arrays.toString(this.f24339b) + "}";
    }
}
