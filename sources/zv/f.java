package zv;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class f {

    /* renamed from: f, reason: collision with root package name */
    public static final Lazy f79600f = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, com.transsion.upgradesdk.net.f.f56721a);

    /* renamed from: a, reason: collision with root package name */
    public boolean f79601a;

    /* renamed from: c, reason: collision with root package name */
    public long f79603c;

    /* renamed from: b, reason: collision with root package name */
    public final com.transsion.upgradesdk.net.g f79602b = new com.transsion.upgradesdk.net.g(this);

    /* renamed from: d, reason: collision with root package name */
    public final String f79604d = "UpgradeSdkManager";

    /* renamed from: e, reason: collision with root package name */
    public final e f79605e = new e(this);

    public static final void b(f fVar) {
        fVar.getClass();
        Intrinsics.z("connectivityManager");
        throw null;
    }

    public final void a() {
        if (this.f79601a) {
            return;
        }
        this.f79601a = true;
        Application application = xv.a.f78570a;
        Application application2 = null;
        if (application == null) {
            Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
            application = null;
        }
        Object systemService = application.getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (Build.VERSION.SDK_INT >= 24) {
            connectivityManager.registerDefaultNetworkCallback(this.f79605e);
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        Application application3 = xv.a.f78570a;
        if (application3 != null) {
            application2 = application3;
        } else {
            Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
        }
        application2.registerReceiver(this.f79602b, intentFilter);
    }
}
