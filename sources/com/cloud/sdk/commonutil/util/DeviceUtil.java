package com.cloud.sdk.commonutil.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.integration.athena.Constants;
import com.transsion.sdk.oneid.OneID;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class DeviceUtil {

    /* renamed from: a, reason: collision with root package name */
    private static String f23237a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f23238b;

    /* renamed from: d, reason: collision with root package name */
    private static String f23240d;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f23239c = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    private static String f23241e = "";

    /* renamed from: f, reason: collision with root package name */
    private static int f23242f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static long f23243g = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: com.cloud.sdk.commonutil.util.DeviceUtil$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0320a {

            /* renamed from: a, reason: collision with root package name */
            private final String f23244a;

            /* renamed from: b, reason: collision with root package name */
            private final boolean f23245b;

            C0320a(String str, boolean z10) {
                this.f23244a = str;
                this.f23245b = z10;
            }

            public String a() {
                return this.f23244a;
            }

            public boolean b() {
                return this.f23245b;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class b implements ServiceConnection {

            /* renamed from: a, reason: collision with root package name */
            boolean f23246a;

            /* renamed from: b, reason: collision with root package name */
            private final LinkedBlockingQueue f23247b;

            private b() {
                this.f23246a = false;
                this.f23247b = new LinkedBlockingQueue(1);
            }

            public IBinder a() {
                if (this.f23246a) {
                    throw new IllegalStateException();
                }
                this.f23246a = true;
                return (IBinder) this.f23247b.take();
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    this.f23247b.put(iBinder);
                } catch (Exception e11) {
                    com.cloud.sdk.commonutil.util.c.Log().e(Log.getStackTraceString(e11));
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class c implements IInterface {

            /* renamed from: a, reason: collision with root package name */
            private final IBinder f23248a;

            c(IBinder iBinder) {
                this.f23248a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23248a;
            }

            public String getId() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f23248a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            boolean isLimitAdTrackingEnabled(boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f23248a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        static C0320a a(Context context) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (!context.bindService(intent, bVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                try {
                    c cVar = new c(bVar.a());
                    return new C0320a(cVar.getId(), cVar.isLimitAdTrackingEnabled(true));
                } catch (Exception e11) {
                    throw e11;
                }
            } finally {
                context.unbindService(bVar);
            }
        }
    }

    public static boolean b(String str, AtomicInteger atomicInteger, int i11) {
        return TextUtils.isEmpty(str) && atomicInteger.getAndIncrement() < i11;
    }

    public static String c() {
        String[] strArr = Build.SUPPORTED_ABIS;
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            sb2.append(strArr[i11]);
            if (i11 < strArr.length - 1) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    public static String d() {
        try {
            if (!TextUtils.isEmpty(f23238b)) {
                return f23238b;
            }
            String simCountryIso = ((TelephonyManager) e.a().getSystemService("phone")).getSimCountryIso();
            if (TextUtils.isEmpty(simCountryIso)) {
                return "";
            }
            String upperCase = simCountryIso.toUpperCase();
            f23238b = upperCase;
            return upperCase;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        if (TextUtils.isEmpty(f23241e)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f23243g < 10000) {
                return f23241e;
            }
            f23243g = currentTimeMillis;
            f23241e = j7.a.e().j("device_util_ga_id");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.sdk.commonutil.util.DeviceUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DeviceUtil.s();
                    }
                });
            } else {
                s();
            }
        }
        return f23241e;
    }

    public static int f() {
        if (f23242f == 0) {
            f23242f = j7.a.e().g("is_limit_ad_tracking_enabled", 0);
        }
        return f23242f;
    }

    public static String g() {
        int cid;
        int lac;
        if (!b(f23237a, f23239c, 1)) {
            return f23237a;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) e.a().getSystemService("phone");
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation == null) {
                return "";
            }
            if (telephonyManager.getPhoneType() == 2) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                cid = cdmaCellLocation.getBaseStationId();
                lac = cdmaCellLocation.getNetworkId();
            } else {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                cid = gsmCellLocation.getCid();
                lac = gsmCellLocation.getLac();
            }
            String str = cid + "|" + lac;
            f23237a = str;
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) e.a().getApplicationContext().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo.isConnected()) {
                f23240d = i();
            } else if (networkInfo2.isConnected()) {
                f23240d = p(((WifiManager) e.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress());
            }
        } catch (Exception e11) {
            c.Log().d("ssp", "获取本地ip地址失败 " + e11.getMessage());
        }
        return f23240d;
    }

    private static String i() {
        String str = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && r(nextElement.getHostAddress())) {
                        str = nextElement.getHostAddress();
                    }
                }
            }
        } catch (SocketException e11) {
            c.Log().d("ssp", "获取本地ip地址失败 " + e11.getMessage());
        }
        return str;
    }

    public static String j() {
        try {
            return OneID.e().a(Constants.AD_APPID);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int k() {
        return Build.VERSION.SDK_INT;
    }

    public static String l() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) e.a().getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m() {
        return Build.VERSION.RELEASE.replace(";", "");
    }

    public static long n() {
        try {
            ActivityManager activityManager = (ActivityManager) e.a().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        } catch (Exception e11) {
            c.Log().d("ssp", "获取本地运行内存失败 " + e11.getMessage());
            return 0L;
        }
    }

    public static String o() {
        return UUID.randomUUID().toString();
    }

    public static String p(int i11) {
        return (i11 & 255) + "." + ((i11 >> 8) & 255) + "." + ((i11 >> 16) & 255) + "." + ((i11 >> 24) & 255);
    }

    public static boolean q() {
        try {
            Context a11 = e.a();
            if (a11.getResources() != null) {
                return (a11.getResources().getConfiguration().screenLayout & 15) >= 3;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean r(String str) {
        try {
            return InetAddress.getByName(str) != null;
        } catch (UnknownHostException e11) {
            c.Log().d("ssp", "获取本地ip地址失败 " + e11.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s() {
        try {
            a.C0320a a11 = a.a(e.a());
            if (a11 == null || a11.a().equals(f23241e)) {
                return;
            }
            f23241e = a11.a();
            boolean b11 = a11.b();
            j7.a.e().r("device_util_ga_id", f23241e);
            j7.a.e().p("is_limit_ad_tracking_enabled", b11 ? 1 : 2);
            c.Log().i("ssp", "gaid limit ：" + b11 + " GAID is ：" + f23241e);
        } catch (Exception e11) {
            c.Log().e("DeviceUtil", Log.getStackTraceString(e11));
        }
    }
}
