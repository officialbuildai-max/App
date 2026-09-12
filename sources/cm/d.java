package cm;

import java.io.Closeable;

/* loaded from: classes5.dex */
public class d {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th2) {
                bm.a.f16706a.d("error", th2.getMessage());
            }
        }
    }
}
