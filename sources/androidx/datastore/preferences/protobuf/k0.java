package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    private static final i0 f8929a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final i0 f8930b = new j0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i0 a() {
        return f8929a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i0 b() {
        return f8930b;
    }

    private static i0 c() {
        if (x0.f9013d) {
            return null;
        }
        try {
            return (i0) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
