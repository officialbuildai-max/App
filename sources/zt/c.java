package zt;

import android.app.Application;
import com.transsion.gslb.DomainManager;
import com.transsion.gslb.GslbSdk;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f79583a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f79584b = new AtomicBoolean(false);

    private c() {
    }

    public final void a(Application application) {
        Intrinsics.h(application, "application");
        if (f79584b.compareAndSet(false, true)) {
            try {
                File filesDir = application.getFilesDir();
                Intrinsics.g(filesDir, "getFilesDir(...)");
                GslbSdk.init(new d(application, filesDir), new String[0], (GslbSdk.GslbInitListener) null);
                DomainManager.getInstance();
            } catch (Exception e11) {
                lg.a.f68962a.i("GslbCrashCompat", "install failed: " + ExceptionsKt.b(e11), true);
            } catch (LinkageError e12) {
                lg.a.f68962a.i("GslbCrashCompat", "install linkage error: " + ExceptionsKt.b(e12), true);
            }
        }
    }
}
