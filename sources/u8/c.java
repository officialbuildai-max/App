package u8;

/* loaded from: classes4.dex */
public final class c implements b {

    /* renamed from: b, reason: collision with root package name */
    private static final c f76810b = new c(null);

    /* renamed from: a, reason: collision with root package name */
    private final Object f76811a;

    private c(Object obj) {
        this.f76811a = obj;
    }

    public static b a(Object obj) {
        return new c(d.c(obj, "instance cannot be null"));
    }

    @Override // uz.a
    public Object get() {
        return this.f76811a;
    }
}
