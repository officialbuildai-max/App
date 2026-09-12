package rc;

import com.google.firebase.perf.session.SessionManager;

/* loaded from: classes5.dex */
public final class g implements uz.a {

    /* renamed from: a, reason: collision with root package name */
    private final a f74431a;

    public g(a aVar) {
        this.f74431a = aVar;
    }

    public static g a(a aVar) {
        return new g(aVar);
    }

    public static SessionManager c(a aVar) {
        return (SessionManager) hz.b.c(aVar.f());
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SessionManager get() {
        return c(this.f74431a);
    }
}
