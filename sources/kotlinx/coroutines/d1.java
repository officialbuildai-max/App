package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class d1 implements p1 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f67824a;

    public d1(boolean z10) {
        this.f67824a = z10;
    }

    @Override // kotlinx.coroutines.p1
    public b2 b() {
        return null;
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return this.f67824a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(isActive() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
