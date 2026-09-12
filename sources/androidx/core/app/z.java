package androidx.core.app;

import android.app.Service;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class z {

    /* loaded from: classes.dex */
    static class a {
        static void a(Service service, int i11) {
            service.stopForeground(i11);
        }
    }

    public static void a(Service service, int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(service, i11);
        } else {
            service.stopForeground((i11 & 1) != 0);
        }
    }
}
