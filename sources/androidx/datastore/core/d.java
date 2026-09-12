package androidx.datastore.core;

/* loaded from: classes.dex */
public final class d extends r {

    /* renamed from: b, reason: collision with root package name */
    private final Object f8673b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8674c;

    public d(Object obj, int i11, int i12) {
        super(i12, null);
        this.f8673b = obj;
        this.f8674c = i11;
    }

    public final void b() {
        Object obj = this.f8673b;
        if ((obj != null ? obj.hashCode() : 0) != this.f8674c) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
        }
    }

    public final Object c() {
        return this.f8673b;
    }
}
