package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.p;

/* loaded from: classes3.dex */
final class i extends p {

    /* renamed from: a, reason: collision with root package name */
    private final o f24344a;

    /* loaded from: classes3.dex */
    static final class b extends p.a {

        /* renamed from: a, reason: collision with root package name */
        private o f24345a;

        @Override // com.google.android.datatransport.cct.internal.p.a
        public p a() {
            return new i(this.f24345a);
        }

        @Override // com.google.android.datatransport.cct.internal.p.a
        public p.a b(o oVar) {
            this.f24345a = oVar;
            return this;
        }
    }

    private i(o oVar) {
        this.f24344a = oVar;
    }

    @Override // com.google.android.datatransport.cct.internal.p
    public o b() {
        return this.f24344a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        o oVar = this.f24344a;
        o b11 = ((p) obj).b();
        return oVar == null ? b11 == null : oVar.equals(b11);
    }

    public int hashCode() {
        o oVar = this.f24344a;
        return (oVar == null ? 0 : oVar.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f24344a + "}";
    }
}
