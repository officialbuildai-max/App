package sd;

import java.util.Objects;

/* loaded from: classes5.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final rd.b f75446a;

    /* renamed from: b, reason: collision with root package name */
    private final rd.b f75447b;

    /* renamed from: c, reason: collision with root package name */
    private final rd.c f75448c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(rd.b bVar, rd.b bVar2, rd.c cVar) {
        this.f75446a = bVar;
        this.f75447b = bVar2;
        this.f75448c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public rd.c a() {
        return this.f75448c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public rd.b b() {
        return this.f75446a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public rd.b c() {
        return this.f75447b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f75447b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f75446a, bVar.f75446a) && Objects.equals(this.f75447b, bVar.f75447b) && Objects.equals(this.f75448c, bVar.f75448c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f75446a) ^ Objects.hashCode(this.f75447b)) ^ Objects.hashCode(this.f75448c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ ");
        sb2.append(this.f75446a);
        sb2.append(" , ");
        sb2.append(this.f75447b);
        sb2.append(" : ");
        rd.c cVar = this.f75448c;
        sb2.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb2.append(" ]");
        return sb2.toString();
    }
}
