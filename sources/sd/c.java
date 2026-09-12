package sd;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final List f75449a;

    /* renamed from: b, reason: collision with root package name */
    private final int f75450b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List list, int i11) {
        this.f75449a = new ArrayList(list);
        this.f75450b = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List a() {
        return this.f75449a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f75450b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(List list) {
        return this.f75449a.equals(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f75449a.equals(((c) obj).f75449a);
        }
        return false;
    }

    public int hashCode() {
        return this.f75449a.hashCode();
    }

    public String toString() {
        return "{ " + this.f75449a + " }";
    }
}
