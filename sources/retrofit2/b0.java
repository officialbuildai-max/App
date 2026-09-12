package retrofit2;

import android.os.Build;
import java.util.concurrent.Executor;
import retrofit2.c;
import retrofit2.d0;

/* loaded from: classes7.dex */
abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    static final Executor f74515a;

    /* renamed from: b, reason: collision with root package name */
    static final d0 f74516b;

    /* renamed from: c, reason: collision with root package name */
    static final c f74517c;

    static {
        String property = System.getProperty("java.vm.name");
        property.hashCode();
        if (property.equals("RoboVM")) {
            f74515a = null;
            f74516b = new d0();
            f74517c = new c();
        } else {
            if (!property.equals("Dalvik")) {
                f74515a = null;
                f74516b = new d0.b();
                f74517c = new c.a();
                return;
            }
            f74515a = new a();
            if (Build.VERSION.SDK_INT >= 24) {
                f74516b = new d0.a();
                f74517c = new c.a();
            } else {
                f74516b = new d0();
                f74517c = new c();
            }
        }
    }
}
