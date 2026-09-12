package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class u0 {

    /* renamed from: a, reason: collision with root package name */
    private static final s0 f8995a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final s0 f8996b = new t0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s0 a() {
        return f8995a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s0 b() {
        return f8996b;
    }

    private static s0 c() {
        if (x0.f9013d) {
            return null;
        }
        try {
            return (s0) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
