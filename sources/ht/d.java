package ht;

import android.os.SystemClock;
import hj.i;

/* loaded from: classes6.dex */
public interface d {

    /* loaded from: classes7.dex */
    public static final class a {
        public static hj.b a(d dVar) {
            return null;
        }

        public static void b(d dVar) {
            hj.b logViewConfig = dVar.getLogViewConfig();
            if (logViewConfig == null || !logViewConfig.d()) {
                return;
            }
            i.f64628a.B(logViewConfig);
        }

        public static void c(d dVar) {
            hj.b logViewConfig = dVar.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.o(SystemClock.elapsedRealtime());
                if (logViewConfig.c()) {
                    i.f64628a.C(logViewConfig);
                }
            }
        }
    }

    hj.b getLogViewConfig();
}
