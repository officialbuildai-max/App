package r8;

/* loaded from: classes4.dex */
final class b extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Integer f74307a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Integer num) {
        this.f74307a = num;
    }

    @Override // r8.f
    public Integer a() {
        return this.f74307a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        Integer num = this.f74307a;
        Integer a11 = ((f) obj).a();
        return num == null ? a11 == null : num.equals(a11);
    }

    public int hashCode() {
        Integer num = this.f74307a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.f74307a + "}";
    }
}
