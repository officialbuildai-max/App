package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private static final p f8982a = new q();

    /* renamed from: b, reason: collision with root package name */
    private static final p f8983b = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p a() {
        p pVar = f8983b;
        if (pVar != null) {
            return pVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p b() {
        return f8982a;
    }

    private static p c() {
        if (x0.f9013d) {
            return null;
        }
        try {
            return (p) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
