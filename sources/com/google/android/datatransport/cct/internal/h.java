package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.o;

/* loaded from: classes3.dex */
final class h extends o {

    /* renamed from: a, reason: collision with root package name */
    private final Integer f24342a;

    /* loaded from: classes3.dex */
    static final class b extends o.a {

        /* renamed from: a, reason: collision with root package name */
        private Integer f24343a;

        @Override // com.google.android.datatransport.cct.internal.o.a
        public o a() {
            return new h(this.f24343a);
        }

        @Override // com.google.android.datatransport.cct.internal.o.a
        public o.a b(Integer num) {
            this.f24343a = num;
            return this;
        }
    }

    private h(Integer num) {
        this.f24342a = num;
    }

    @Override // com.google.android.datatransport.cct.internal.o
    public Integer b() {
        return this.f24342a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        Integer num = this.f24342a;
        Integer b11 = ((o) obj).b();
        return num == null ? b11 == null : num.equals(b11);
    }

    public int hashCode() {
        Integer num = this.f24342a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f24342a + "}";
    }
}
