package kotlinx.coroutines.internal;

/* loaded from: classes7.dex */
abstract /* synthetic */ class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f67973a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f67973a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
