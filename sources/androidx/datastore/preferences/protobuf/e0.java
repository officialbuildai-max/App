package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c0 f8832a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final c0 f8833b = new d0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 a() {
        return f8832a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 b() {
        return f8833b;
    }

    private static c0 c() {
        if (x0.f9013d) {
            return null;
        }
        try {
            return (c0) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
