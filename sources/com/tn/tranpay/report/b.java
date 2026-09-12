package com.tn.tranpay.report;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public static final class a {
        public static c a(b bVar) {
            return null;
        }

        public static void b(b bVar) {
            c logViewConfig = bVar.getLogViewConfig();
            if (logViewConfig == null || !logViewConfig.d()) {
                return;
            }
            e.f41734a.f(logViewConfig);
        }

        public static void c(b bVar) {
            c logViewConfig = bVar.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(SystemClock.elapsedRealtime());
                if (logViewConfig.c()) {
                    e.f41734a.g(logViewConfig);
                }
            }
        }
    }

    c getLogViewConfig();
}
