package sc;

import android.util.Log;

/* loaded from: classes5.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f75445a;

    private c() {
    }

    public static synchronized c c() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f75445a == null) {
                    f75445a = new c();
                }
                cVar = f75445a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        Log.e("FirebasePerformance", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        Log.w("FirebasePerformance", str);
    }
}
