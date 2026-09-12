package q4;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
abstract class p implements o {

    /* renamed from: a, reason: collision with root package name */
    final List f73234a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(List list) {
        this.f73234a = list;
    }

    @Override // q4.o
    public List b() {
        return this.f73234a;
    }

    @Override // q4.o
    public boolean c() {
        if (this.f73234a.isEmpty()) {
            return true;
        }
        return this.f73234a.size() == 1 && ((w4.a) this.f73234a.get(0)).i();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.f73234a.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(this.f73234a.toArray()));
        }
        return sb2.toString();
    }
}
