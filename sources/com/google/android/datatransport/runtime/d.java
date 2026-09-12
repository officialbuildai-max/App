package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.o;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class d extends o {

    /* renamed from: a, reason: collision with root package name */
    private final String f24437a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f24438b;

    /* renamed from: c, reason: collision with root package name */
    private final Priority f24439c;

    /* loaded from: classes3.dex */
    static final class b extends o.a {

        /* renamed from: a, reason: collision with root package name */
        private String f24440a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f24441b;

        /* renamed from: c, reason: collision with root package name */
        private Priority f24442c;

        @Override // com.google.android.datatransport.runtime.o.a
        public o a() {
            String str = "";
            if (this.f24440a == null) {
                str = " backendName";
            }
            if (this.f24442c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f24440a, this.f24441b, this.f24442c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.o.a
        public o.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f24440a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.o.a
        public o.a c(byte[] bArr) {
            this.f24441b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.o.a
        public o.a d(Priority priority) {
            if (priority == null) {
                throw new NullPointerException("Null priority");
            }
            this.f24442c = priority;
            return this;
        }
    }

    private d(String str, byte[] bArr, Priority priority) {
        this.f24437a = str;
        this.f24438b = bArr;
        this.f24439c = priority;
    }

    @Override // com.google.android.datatransport.runtime.o
    public String b() {
        return this.f24437a;
    }

    @Override // com.google.android.datatransport.runtime.o
    public byte[] c() {
        return this.f24438b;
    }

    @Override // com.google.android.datatransport.runtime.o
    public Priority d() {
        return this.f24439c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f24437a.equals(oVar.b())) {
            if (Arrays.equals(this.f24438b, oVar instanceof d ? ((d) oVar).f24438b : oVar.c()) && this.f24439c.equals(oVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f24437a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f24438b)) * 1000003) ^ this.f24439c.hashCode();
    }
}
