package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.n;

/* loaded from: classes3.dex */
final class c extends n {

    /* renamed from: a, reason: collision with root package name */
    private final o f24427a;

    /* renamed from: b, reason: collision with root package name */
    private final String f24428b;

    /* renamed from: c, reason: collision with root package name */
    private final r8.d f24429c;

    /* renamed from: d, reason: collision with root package name */
    private final r8.g f24430d;

    /* renamed from: e, reason: collision with root package name */
    private final r8.c f24431e;

    /* loaded from: classes3.dex */
    static final class b extends n.a {

        /* renamed from: a, reason: collision with root package name */
        private o f24432a;

        /* renamed from: b, reason: collision with root package name */
        private String f24433b;

        /* renamed from: c, reason: collision with root package name */
        private r8.d f24434c;

        /* renamed from: d, reason: collision with root package name */
        private r8.g f24435d;

        /* renamed from: e, reason: collision with root package name */
        private r8.c f24436e;

        @Override // com.google.android.datatransport.runtime.n.a
        public n a() {
            String str = "";
            if (this.f24432a == null) {
                str = " transportContext";
            }
            if (this.f24433b == null) {
                str = str + " transportName";
            }
            if (this.f24434c == null) {
                str = str + " event";
            }
            if (this.f24435d == null) {
                str = str + " transformer";
            }
            if (this.f24436e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f24432a, this.f24433b, this.f24434c, this.f24435d, this.f24436e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.n.a
        n.a b(r8.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f24436e = cVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.n.a
        n.a c(r8.d dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f24434c = dVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.n.a
        n.a d(r8.g gVar) {
            if (gVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f24435d = gVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.n.a
        public n.a e(o oVar) {
            if (oVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f24432a = oVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.n.a
        public n.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f24433b = str;
            return this;
        }
    }

    private c(o oVar, String str, r8.d dVar, r8.g gVar, r8.c cVar) {
        this.f24427a = oVar;
        this.f24428b = str;
        this.f24429c = dVar;
        this.f24430d = gVar;
        this.f24431e = cVar;
    }

    @Override // com.google.android.datatransport.runtime.n
    public r8.c b() {
        return this.f24431e;
    }

    @Override // com.google.android.datatransport.runtime.n
    r8.d c() {
        return this.f24429c;
    }

    @Override // com.google.android.datatransport.runtime.n
    r8.g e() {
        return this.f24430d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f24427a.equals(nVar.f()) && this.f24428b.equals(nVar.g()) && this.f24429c.equals(nVar.c()) && this.f24430d.equals(nVar.e()) && this.f24431e.equals(nVar.b());
    }

    @Override // com.google.android.datatransport.runtime.n
    public o f() {
        return this.f24427a;
    }

    @Override // com.google.android.datatransport.runtime.n
    public String g() {
        return this.f24428b;
    }

    public int hashCode() {
        return ((((((((this.f24427a.hashCode() ^ 1000003) * 1000003) ^ this.f24428b.hashCode()) * 1000003) ^ this.f24429c.hashCode()) * 1000003) ^ this.f24430d.hashCode()) * 1000003) ^ this.f24431e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f24427a + ", transportName=" + this.f24428b + ", event=" + this.f24429c + ", transformer=" + this.f24430d + ", encoding=" + this.f24431e + "}";
    }
}
