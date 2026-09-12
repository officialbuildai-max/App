package t8;

import java.util.Arrays;
import t8.e;

/* loaded from: classes4.dex */
final class a extends e {

    /* renamed from: a, reason: collision with root package name */
    private final Iterable f76194a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f76195b;

    /* loaded from: classes4.dex */
    static final class b extends e.a {

        /* renamed from: a, reason: collision with root package name */
        private Iterable f76196a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f76197b;

        @Override // t8.e.a
        public e a() {
            String str = "";
            if (this.f76196a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f76196a, this.f76197b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // t8.e.a
        public e.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f76196a = iterable;
            return this;
        }

        @Override // t8.e.a
        public e.a c(byte[] bArr) {
            this.f76197b = bArr;
            return this;
        }
    }

    private a(Iterable iterable, byte[] bArr) {
        this.f76194a = iterable;
        this.f76195b = bArr;
    }

    @Override // t8.e
    public Iterable b() {
        return this.f76194a;
    }

    @Override // t8.e
    public byte[] c() {
        return this.f76195b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f76194a.equals(eVar.b())) {
            if (Arrays.equals(this.f76195b, eVar instanceof a ? ((a) eVar).f76195b : eVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f76194a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f76195b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f76194a + ", extras=" + Arrays.toString(this.f76195b) + "}";
    }
}
