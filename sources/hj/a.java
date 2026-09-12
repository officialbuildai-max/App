package hj;

import android.os.SystemClock;

/* loaded from: classes5.dex */
public interface a {

    /* renamed from: hj.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0806a {
        public static b a(a aVar) {
            return null;
        }

        public static void b(a aVar) {
            b logViewConfig = aVar.getLogViewConfig();
            if (logViewConfig == null || !logViewConfig.d()) {
                return;
            }
            i.f64628a.B(logViewConfig);
        }

        public static void c(a aVar) {
            b logViewConfig = aVar.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.o(SystemClock.elapsedRealtime());
                if (logViewConfig.c()) {
                    i.f64628a.C(logViewConfig);
                }
            }
        }
    }

    b getLogViewConfig();
}
