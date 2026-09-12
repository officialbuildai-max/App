package com.cloud.sdk.commonutil.util;

import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static Location f23262a = null;

    /* renamed from: b, reason: collision with root package name */
    private static double f23263b = 0.0d;

    /* renamed from: c, reason: collision with root package name */
    private static double f23264c = 0.0d;

    /* renamed from: d, reason: collision with root package name */
    private static int f23265d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static long f23266e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static String f23267f = "";

    /* renamed from: g, reason: collision with root package name */
    private static final AtomicInteger f23268g = new AtomicInteger(0);

    private static boolean a() {
        return f23263b == 0.0d && f23264c == 0.0d && f23268g.getAndIncrement() <= 1;
    }

    public static long b() {
        h();
        return f23266e;
    }

    public static String c() {
        h();
        return f23267f;
    }

    public static double d() {
        h();
        return f23263b;
    }

    private static void e() {
        try {
            if (e.a() != null) {
                LocationManager locationManager = (LocationManager) e.a().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
                if (!isProviderEnabled && !isProviderEnabled2) {
                    return;
                }
                if (isProviderEnabled) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                    f23262a = lastKnownLocation;
                    g(lastKnownLocation);
                }
                if (isProviderEnabled2 && f23262a == null) {
                    Location lastKnownLocation2 = locationManager.getLastKnownLocation("network");
                    f23262a = lastKnownLocation2;
                    g(lastKnownLocation2);
                }
            }
        } catch (Throwable unused) {
            c.Log().d("ssp", "Location Impossible to connect to LocationManager");
        }
        Location location = f23262a;
        if (location != null) {
            g(location);
        }
    }

    public static double f() {
        h();
        return f23264c;
    }

    private static void g(Location location) {
        if (location != null) {
            f23263b = location.getLatitude();
            f23264c = location.getLongitude();
            f23265d = (int) location.getAccuracy();
            f23266e = location.getTime();
            try {
                f23267f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").format(new Date(f23266e));
            } catch (Exception e11) {
                c.Log().e(Log.getStackTraceString(e11));
            }
        }
    }

    private static void h() {
        if (a()) {
            e();
        }
    }
}
