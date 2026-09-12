package com.transsion.room.helper;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.permissionx.guolindev.callback.PermissionDialogClickType;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.room.api.bean.LocationPlace;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class LocationPlaceHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final LocationPlaceHelper f51664a = new LocationPlaceHelper();

    /* renamed from: b, reason: collision with root package name */
    private static PlacesClient f51665b;

    /* renamed from: c, reason: collision with root package name */
    private static LocationCallback f51666c;

    /* renamed from: d, reason: collision with root package name */
    private static int f51667d;

    private LocationPlaceHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(final FusedLocationProviderClient fusedLocationProviderClient) {
        int i11 = f51667d;
        if (i11 >= 3) {
            lg.a.f68962a.u("LocationP", "Location--update---- removeLocationUpdates, 超过上限3次，不再移除", true);
            return;
        }
        f51667d = i11 + 1;
        LocationCallback locationCallback = f51666c;
        if (locationCallback != null) {
            lg.a.f68962a.u("LocationP", "Location--update---- removeLocationUpdates", true);
            fusedLocationProviderClient.removeLocationUpdates(locationCallback).addOnCompleteListener(new OnCompleteListener() { // from class: com.transsion.room.helper.k
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    LocationPlaceHelper.B(FusedLocationProviderClient.this, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(FusedLocationProviderClient fusedLocationProviderClient, Task task) {
        Intrinsics.h(task, "task");
        if (task.isSuccessful()) {
            f51666c = null;
            a.C0856a.z(lg.a.f68962a, "LocationP", "Location--update----成功移除监听", false, 4, null);
        } else {
            a.C0856a.l(lg.a.f68962a, "LocationP", "Location--update----移除监听失败", false, 4, null);
            f51664a.A(fusedLocationProviderClient);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.transsion.room.api.bean.LocationPlace l(double r21, double r23, android.location.Address r25) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.room.helper.LocationPlaceHelper.l(double, double, android.location.Address):com.transsion.room.api.bean.LocationPlace");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Address m(double d11, double d12) {
        try {
            List<Address> fromLocation = new Geocoder(Utils.a(), Locale.getDefault()).getFromLocation(d11, d12, 1);
            List<Address> list = fromLocation;
            if (list != null && !list.isEmpty()) {
                return fromLocation.get(0);
            }
            return null;
        } catch (Throwable th2) {
            a.C0856a.l(lg.a.f68962a, "LocationP", "Location-------------- ll2address error:" + th2, false, 4, null);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FusedLocationProviderClient fusedLocationProviderClient, Function1 function1, Task task) {
        Intrinsics.h(task, "task");
        if (!task.isSuccessful()) {
            lg.a.f68962a.i("LocationP", "Location-------------- fail: " + task.getException() + ", do update", true);
            f51664a.y(fusedLocationProviderClient, function1);
            return;
        }
        Location location = (Location) task.getResult();
        if (location == null) {
            lg.a.f68962a.i("LocationP", "Location-------------- fail: location null---do update", true);
            f51664a.y(fusedLocationProviderClient, function1);
            return;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        lg.a.f68962a.c("LocationP", "Location--------------1 success " + longitude + ", :" + latitude, true);
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new LocationPlaceHelper$getCurrentLocation$2$1(latitude, longitude, function1, null), 3, null);
    }

    private final void q(double d11, double d12, Function1 function1) {
        String r11 = r();
        if (r11 == null || r11.length() == 0) {
            a.C0856a.f(lg.a.f68962a, "LocationP", "getNearbyPlaces apiKey isNullOrEmpty", false, 4, null);
            function1.invoke(null);
            return;
        }
        if (!Places.isInitialized()) {
            a.C0856a.r(lg.a.f68962a, "LocationP", new String[]{"getNearbyPlaces initialize place"}, false, 4, null);
            Places.initialize(Utils.a(), r11);
        }
        if (f51665b == null) {
            f51665b = Places.createClient(Utils.a());
        }
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new LocationPlaceHelper$getNearbyPlacesWithDetailApi$1(function1, FindCurrentPlaceRequest.newInstance(CollectionsKt.o(Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG)), new LatLng(d11, d12), null), 3, null);
    }

    private final String r() {
        String str;
        ConfigBean c11 = sm.f.f75530c.a().c("sa_lo_place_key", true);
        String value = c11 != null ? c11.getValue() : null;
        if (value == null || value.length() == 0 || (str = value.toString()) == null) {
            return null;
        }
        return str;
    }

    private final int s() {
        Integer v11;
        ConfigBean c11 = sm.f.f75530c.a().c("sa_lo_place_api", true);
        String value = c11 != null ? c11.getValue() : null;
        if (value == null || value.length() == 0 || (v11 = StringsKt.v(value)) == null) {
            return 1;
        }
        return v11.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(boolean z10, cf.f scope, List deniedList, boolean z11, boolean z12) {
        Intrinsics.h(scope, "scope");
        Intrinsics.h(deniedList, "deniedList");
        if (!z11) {
            a.C0856a.f(lg.a.f68962a, "LocationP", "location 请求权限之后，", false, 4, null);
            return;
        }
        if (!z12) {
            a.C0856a.f(lg.a.f68962a, "LocationP", "直接请求权限", false, 4, null);
            scope.b(deniedList);
        } else if (!z10) {
            scope.a(deniedList);
        } else {
            a.C0856a.f(lg.a.f68962a, "LocationP", "请求权限，需要跳到设置页，先展示提示弹窗", false, 4, null);
            scope.c(deniedList, new bf.a(null, Utils.a().getString(R$string.location_permission_dialog_tips), Utils.a().getString(R$string.Enable), Integer.valueOf(R$drawable.ic_location_permission_tips), Integer.valueOf(R$color.white_20), 1, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(FragmentActivity fragmentActivity, Function1 function1, boolean z10, List grantedList, List deniedList) {
        Intrinsics.h(grantedList, "grantedList");
        Intrinsics.h(deniedList, "deniedList");
        if (z10 && grantedList.size() == 1 && !ActivityCompat.j(fragmentActivity, (String) grantedList.get(0))) {
            ye.c.f79116a.d().putBoolean((String) grantedList.get(0), false);
        }
        a.C0856a.f(lg.a.f68962a, "LocationP", "location 请求权限结果:" + z10, false, 4, null);
        function1.invoke(Boolean.valueOf(z10));
    }

    private final void x(Double d11, Double d12, Function1 function1) {
        if (d11 == null || d12 == null) {
            function1.invoke(null);
            return;
        }
        String r11 = r();
        if (r11 == null || r11.length() == 0) {
            function1.invoke(null);
            return;
        }
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new LocationPlaceHelper$searchNearbyPlaces$1(d11 + "," + d12, 20000, r11, d11, d12, function1, null), 3, null);
    }

    private final void y(final FusedLocationProviderClient fusedLocationProviderClient, final Function1 function1) {
        LocationRequest build = new LocationRequest.Builder(100, 10000L).setWaitForAccurateLocation(true).setMinUpdateIntervalMillis(5000L).build();
        Intrinsics.g(build, "build(...)");
        LocationCallback locationCallback = new LocationCallback() { // from class: com.transsion.room.helper.LocationPlaceHelper$startRealTimeUpdates$1
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationAvailability(LocationAvailability availability) {
                Intrinsics.h(availability, "availability");
                if (availability.isLocationAvailable()) {
                    return;
                }
                lg.a.f68962a.x("LocationP", "Location services unavailable", true);
            }

            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult result) {
                t1 d11;
                Intrinsics.h(result, "result");
                Location lastLocation = result.getLastLocation();
                if (lastLocation != null) {
                    FusedLocationProviderClient fusedLocationProviderClient2 = FusedLocationProviderClient.this;
                    Function1 function12 = function1;
                    LocationPlaceHelper.f51667d = 0;
                    LocationPlaceHelper.f51664a.A(fusedLocationProviderClient2);
                    double latitude = lastLocation.getLatitude();
                    double longitude = lastLocation.getLongitude();
                    lg.a.f68962a.c("LocationP", "Location--update--------------1 success " + latitude + ", :" + longitude, true);
                    d11 = kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$1$1(latitude, longitude, function12, null), 3, null);
                    if (d11 != null) {
                        return;
                    }
                }
                kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$2$1(function1, null), 3, null);
            }
        };
        f51666c = locationCallback;
        Intrinsics.f(locationCallback, "null cannot be cast to non-null type com.google.android.gms.location.LocationCallback");
        fusedLocationProviderClient.requestLocationUpdates(build, locationCallback, Looper.getMainLooper()).addOnFailureListener(new OnFailureListener() { // from class: com.transsion.room.helper.j
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LocationPlaceHelper.z(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Exception e11) {
        Intrinsics.h(e11, "e");
        a.C0856a.l(lg.a.f68962a, "LocationP", "Updates request failed: " + e11.getMessage(), false, 4, null);
    }

    public final void n(FragmentActivity activity, final Function1 callback) {
        Double s11;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(callback, "callback");
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "LocationP", "Location-------------- start getCurrentLocation", false, 4, null);
        String string = com.transsion.baselib.report.launch.b.f43424a.b().getString("key_lo_mock_test_lab_lat", "");
        if (string != null && string.length() != 0 && StringsKt.c0(string, "|", false, 2, null)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                List S0 = StringsKt.S0(string, new String[]{"|"}, false, 0, 6, null);
                Double s12 = StringsKt.s((String) S0.get(0));
                if (s12 != null && (s11 = StringsKt.s((String) S0.get(1))) != null) {
                    String str = (String) S0.get(2);
                    String str2 = (String) S0.get(3);
                    LocationPlace locationPlace = new LocationPlace(null, null, null, null, 15, null);
                    locationPlace.setName(str);
                    locationPlace.setDistance("<1m");
                    locationPlace.setAddress(str2);
                    locationPlace.setLat(s12);
                    locationPlace.setLon(s11);
                    c0856a.c("LocationP", "Location-------------- mock 的定位数据 name:" + str + ",address:" + str2 + ".不使用实际定位,需要真实定位请求清楚mock数据", true);
                    callback.invoke(locationPlace);
                    return;
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
        final FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) activity);
        Intrinsics.g(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.transsion.room.helper.f
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                LocationPlaceHelper.o(FusedLocationProviderClient.this, callback, task);
            }
        });
    }

    public final void p(double d11, double d12, Function1 callback) {
        Intrinsics.h(callback, "callback");
        int s11 = s();
        if (s11 == 0) {
            lg.a.f68962a.c("LocationP", "place api use detail", true);
            q(d11, d12, callback);
        } else {
            if (s11 == 1) {
                lg.a.f68962a.c("LocationP", "place api use search", true);
                x(Double.valueOf(d11), Double.valueOf(d12), callback);
                return;
            }
            lg.a.f68962a.c("LocationP", "place api ,null " + s11, true);
            callback.invoke(null);
        }
    }

    public final void t(final FragmentActivity activity, final boolean z10, final Function1 callback) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(callback, "callback");
        ye.c.f79116a.e(activity).b("android.permission.ACCESS_FINE_LOCATION").b().c(new ze.b() { // from class: com.transsion.room.helper.g
            @Override // ze.b
            public final void a(cf.f fVar, List list, boolean z11, boolean z12) {
                LocationPlaceHelper.u(z10, fVar, list, z11, z12);
            }
        }).d(new ze.a() { // from class: com.transsion.room.helper.h
            @Override // ze.a
            public final void a(BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
                LocationPlaceHelper.v(baseDialog, bool, permissionDialogClickType);
            }
        }).a(new ze.c() { // from class: com.transsion.room.helper.i
            @Override // ze.c
            public final void a(boolean z11, List list, List list2) {
                LocationPlaceHelper.w(FragmentActivity.this, callback, z11, list, list2);
            }
        });
    }
}
