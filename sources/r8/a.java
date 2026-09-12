package r8;

import com.google.android.datatransport.Priority;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    private final Integer f74302a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f74303b;

    /* renamed from: c, reason: collision with root package name */
    private final Priority f74304c;

    /* renamed from: d, reason: collision with root package name */
    private final f f74305d;

    /* renamed from: e, reason: collision with root package name */
    private final e f74306e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Integer num, Object obj, Priority priority, f fVar, e eVar) {
        this.f74302a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f74303b = obj;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.f74304c = priority;
        this.f74305d = fVar;
        this.f74306e = eVar;
    }

    @Override // r8.d
    public Integer a() {
        return this.f74302a;
    }

    @Override // r8.d
    public e b() {
        return this.f74306e;
    }

    @Override // r8.d
    public Object c() {
        return this.f74303b;
    }

    @Override // r8.d
    public Priority d() {
        return this.f74304c;
    }

    @Override // r8.d
    public f e() {
        return this.f74305d;
    }

    public boolean equals(Object obj) {
        f fVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        Integer num = this.f74302a;
        if (num != null ? num.equals(dVar.a()) : dVar.a() == null) {
            if (this.f74303b.equals(dVar.c()) && this.f74304c.equals(dVar.d()) && ((fVar = this.f74305d) != null ? fVar.equals(dVar.e()) : dVar.e() == null)) {
                e eVar = this.f74306e;
                if (eVar == null) {
                    if (dVar.b() == null) {
                        return true;
                    }
                } else if (eVar.equals(dVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f74302a;
        int hashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f74303b.hashCode()) * 1000003) ^ this.f74304c.hashCode()) * 1000003;
        f fVar = this.f74305d;
        int hashCode2 = (hashCode ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        e eVar = this.f74306e;
        return hashCode2 ^ (eVar != null ? eVar.hashCode() : 0);
    }

    public String toString() {
        return "Event{code=" + this.f74302a + ", payload=" + this.f74303b + ", priority=" + this.f74304c + ", productData=" + this.f74305d + ", eventContext=" + this.f74306e + "}";
    }
}
