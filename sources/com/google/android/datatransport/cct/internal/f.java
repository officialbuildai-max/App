package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ComplianceData;

/* loaded from: classes3.dex */
final class f extends ComplianceData {

    /* renamed from: a, reason: collision with root package name */
    private final p f24334a;

    /* renamed from: b, reason: collision with root package name */
    private final ComplianceData.ProductIdOrigin f24335b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b extends ComplianceData.a {

        /* renamed from: a, reason: collision with root package name */
        private p f24336a;

        /* renamed from: b, reason: collision with root package name */
        private ComplianceData.ProductIdOrigin f24337b;

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.a
        public ComplianceData a() {
            return new f(this.f24336a, this.f24337b);
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.a
        public ComplianceData.a b(p pVar) {
            this.f24336a = pVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.a
        public ComplianceData.a c(ComplianceData.ProductIdOrigin productIdOrigin) {
            this.f24337b = productIdOrigin;
            return this;
        }
    }

    private f(p pVar, ComplianceData.ProductIdOrigin productIdOrigin) {
        this.f24334a = pVar;
        this.f24335b = productIdOrigin;
    }

    @Override // com.google.android.datatransport.cct.internal.ComplianceData
    public p b() {
        return this.f24334a;
    }

    @Override // com.google.android.datatransport.cct.internal.ComplianceData
    public ComplianceData.ProductIdOrigin c() {
        return this.f24335b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComplianceData)) {
            return false;
        }
        ComplianceData complianceData = (ComplianceData) obj;
        p pVar = this.f24334a;
        if (pVar != null ? pVar.equals(complianceData.b()) : complianceData.b() == null) {
            ComplianceData.ProductIdOrigin productIdOrigin = this.f24335b;
            if (productIdOrigin == null) {
                if (complianceData.c() == null) {
                    return true;
                }
            } else if (productIdOrigin.equals(complianceData.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        p pVar = this.f24334a;
        int hashCode = ((pVar == null ? 0 : pVar.hashCode()) ^ 1000003) * 1000003;
        ComplianceData.ProductIdOrigin productIdOrigin = this.f24335b;
        return hashCode ^ (productIdOrigin != null ? productIdOrigin.hashCode() : 0);
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f24334a + ", productIdOrigin=" + this.f24335b + "}";
    }
}
