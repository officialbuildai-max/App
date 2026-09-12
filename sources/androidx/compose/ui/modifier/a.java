package androidx.compose.ui.modifier;

/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private j f5279a;

    public a(j jVar) {
        super(null);
        this.f5279a = jVar;
    }

    @Override // androidx.compose.ui.modifier.f
    public boolean a(c cVar) {
        return cVar == this.f5279a.getKey();
    }

    @Override // androidx.compose.ui.modifier.f
    public Object b(c cVar) {
        if (!(cVar == this.f5279a.getKey())) {
            g0.a.b("Check failed.");
        }
        return this.f5279a.getValue();
    }

    public final void c(j jVar) {
        this.f5279a = jVar;
    }
}
