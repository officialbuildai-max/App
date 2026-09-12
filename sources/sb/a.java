package sb;

import sb.e;

/* loaded from: classes5.dex */
final class a extends e {

    /* renamed from: a, reason: collision with root package name */
    private final e.a f75421a;

    /* renamed from: b, reason: collision with root package name */
    private final e.c f75422b;

    /* renamed from: c, reason: collision with root package name */
    private final e.b f75423c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e.a aVar, e.c cVar, e.b bVar) {
        if (aVar == null) {
            throw new NullPointerException("Null appData");
        }
        this.f75421a = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null osData");
        }
        this.f75422b = cVar;
        if (bVar == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.f75423c = bVar;
    }

    @Override // sb.e
    public e.a a() {
        return this.f75421a;
    }

    @Override // sb.e
    public e.b c() {
        return this.f75423c;
    }

    @Override // sb.e
    public e.c d() {
        return this.f75422b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f75421a.equals(eVar.a()) && this.f75422b.equals(eVar.d()) && this.f75423c.equals(eVar.c());
    }

    public int hashCode() {
        return ((((this.f75421a.hashCode() ^ 1000003) * 1000003) ^ this.f75422b.hashCode()) * 1000003) ^ this.f75423c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f75421a + ", osData=" + this.f75422b + ", deviceData=" + this.f75423c + "}";
    }
}
