package t8;

import android.content.Context;

/* loaded from: classes4.dex */
final class b extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f76198a;

    /* renamed from: b, reason: collision with root package name */
    private final c9.a f76199b;

    /* renamed from: c, reason: collision with root package name */
    private final c9.a f76200c;

    /* renamed from: d, reason: collision with root package name */
    private final String f76201d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, c9.a aVar, c9.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f76198a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f76199b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f76200c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f76201d = str;
    }

    @Override // t8.f
    public Context b() {
        return this.f76198a;
    }

    @Override // t8.f
    public String c() {
        return this.f76201d;
    }

    @Override // t8.f
    public c9.a d() {
        return this.f76200c;
    }

    @Override // t8.f
    public c9.a e() {
        return this.f76199b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f76198a.equals(fVar.b()) && this.f76199b.equals(fVar.e()) && this.f76200c.equals(fVar.d()) && this.f76201d.equals(fVar.c());
    }

    public int hashCode() {
        return ((((((this.f76198a.hashCode() ^ 1000003) * 1000003) ^ this.f76199b.hashCode()) * 1000003) ^ this.f76200c.hashCode()) * 1000003) ^ this.f76201d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f76198a + ", wallClock=" + this.f76199b + ", monotonicClock=" + this.f76200c + ", backendName=" + this.f76201d + "}";
    }
}
