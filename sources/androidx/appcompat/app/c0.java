package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.util.Calendar;

/* loaded from: classes.dex */
class c0 {

    /* renamed from: d, reason: collision with root package name */
    private static c0 f1195d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f1196a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f1197b;

    /* renamed from: c, reason: collision with root package name */
    private final a f1198c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f1199a;

        /* renamed from: b, reason: collision with root package name */
        long f1200b;

        a() {
        }
    }

    c0(Context context, LocationManager locationManager) {
        this.f1196a = context;
        this.f1197b = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 a(Context context) {
        if (f1195d == null) {
            Context applicationContext = context.getApplicationContext();
            f1195d = new c0(applicationContext, (LocationManager) applicationContext.getSystemService(RequestParameters.SUBRESOURCE_LOCATION));
        }
        return f1195d;
    }

    private Location b() {
        Location c11 = androidx.core.content.f.b(this.f1196a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location c12 = androidx.core.content.f.b(this.f1196a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (c12 == null || c11 == null) ? c12 != null ? c12 : c11 : c12.getTime() > c11.getTime() ? c12 : c11;
    }

    private Location c(String str) {
        try {
            if (this.f1197b.isProviderEnabled(str)) {
                return this.f1197b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean e() {
        return this.f1198c.f1200b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j11;
        a aVar = this.f1198c;
        long currentTimeMillis = System.currentTimeMillis();
        b0 b11 = b0.b();
        b11.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        b11.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = b11.f1191c == 1;
        long j12 = b11.f1190b;
        long j13 = b11.f1189a;
        b11.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j14 = b11.f1190b;
        if (j12 == -1 || j13 == -1) {
            j11 = currentTimeMillis + TmcConstants.MINI_POPWINDOW_MSG_BUBBLE_INTERVAL;
        } else {
            if (currentTimeMillis <= j13) {
                j14 = currentTimeMillis > j12 ? j13 : j12;
            }
            j11 = j14 + 60000;
        }
        aVar.f1199a = z10;
        aVar.f1200b = j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f1198c;
        if (e()) {
            return aVar.f1199a;
        }
        Location b11 = b();
        if (b11 != null) {
            f(b11);
            return aVar.f1199a;
        }
        int i11 = Calendar.getInstance().get(11);
        return i11 < 6 || i11 >= 22;
    }
}
