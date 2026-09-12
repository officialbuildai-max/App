package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f8820a;

    /* renamed from: b, reason: collision with root package name */
    private static final Class f8821b = a("libcore.io.Memory");

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f8822c;

    static {
        f8822c = (f8820a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b() {
        return f8821b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return f8820a || !(f8821b == null || f8822c);
    }
}
