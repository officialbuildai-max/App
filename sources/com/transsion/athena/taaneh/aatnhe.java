package com.transsion.athena.taaneh;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.util.Log;
import com.transsion.core.log.ObjectLogUtils;

/* loaded from: classes5.dex */
public class aatnhe {

    /* renamed from: a, reason: collision with root package name */
    private static int f42850a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static aethna f42851b;

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    /* loaded from: classes5.dex */
    public static class aethna extends ConnectivityManager.NetworkCallback {
        private aethna() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            aatnhe.a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            aatnhe.a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            aatnhe.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[RETURN] */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(android.content.Context r4) {
        /*
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            r1 = 0
            if (r0 == 0) goto L29
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r2 >= r3) goto L16
            int r0 = r0.getNetworkType()
            goto L2a
        L16:
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            int r2 = androidx.core.content.b.checkSelfPermission(r4, r2)
            if (r2 == 0) goto L24
            boolean r2 = r0.hasCarrierPrivileges()
            if (r2 == 0) goto L29
        L24:
            int r0 = nh.a.a(r0)
            goto L2a
        L29:
            r0 = r1
        L2a:
            if (r0 != 0) goto L49
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r2 = "connectivity"
            java.lang.Object r4 = r4.getSystemService(r2)
            android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4
            if (r4 == 0) goto L49
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()
            if (r4 == 0) goto L49
            int r0 = r4.getSubtype()
            java.lang.String r4 = r4.getSubtypeName()
            goto L4b
        L49:
            java.lang.String r4 = ""
        L4b:
            r2 = 3
            switch(r0) {
                case 1: goto L78;
                case 2: goto L78;
                case 3: goto L77;
                case 4: goto L78;
                case 5: goto L77;
                case 6: goto L77;
                case 7: goto L78;
                case 8: goto L77;
                case 9: goto L77;
                case 10: goto L77;
                case 11: goto L78;
                case 12: goto L77;
                case 13: goto L75;
                case 14: goto L77;
                case 15: goto L77;
                case 16: goto L78;
                case 17: goto L77;
                case 18: goto L75;
                case 19: goto L75;
                case 20: goto L73;
                default: goto L4f;
            }
        L4f:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L70
            java.lang.String r0 = "TD-SCDMA"
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 != 0) goto L6f
            java.lang.String r0 = "WCDMA"
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 != 0) goto L6f
            java.lang.String r0 = "CDMA2000"
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 == 0) goto L6e
            goto L6f
        L6e:
            return r1
        L6f:
            return r2
        L70:
            r4 = 99
            return r4
        L73:
            r4 = 5
            return r4
        L75:
            r4 = 4
            return r4
        L77:
            return r2
        L78:
            r4 = 2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.taaneh.aatnhe.a(android.content.Context):int");
    }

    public static void a() {
        f42850a = -1;
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(3);
    }

    public static int b(Context context) {
        NetworkCapabilities networkCapabilities;
        int i11 = f42850a;
        if (i11 != -1 && i11 != 0 && i11 != 99) {
            return i11;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!b(connectivityManager)) {
                f42850a = 99;
                return 99;
            }
            if (c(connectivityManager)) {
                f42850a = 1;
            } else if (a(connectivityManager)) {
                f42850a = 6;
            } else {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                boolean z10 = false;
                if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                    z10 = networkCapabilities.hasTransport(0);
                }
                if (z10) {
                    f42850a = a(context);
                } else {
                    f42850a = 100;
                }
            }
            return f42850a;
        } catch (Exception unused) {
            return 99;
        }
    }

    private static boolean b(ConnectivityManager connectivityManager) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16);
    }

    public static boolean c(Context context) {
        try {
            return b((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e11) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.f42852a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return false;
        }
    }

    private static boolean c(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }

    public static boolean d(Context context) {
        try {
            if (!c(context)) {
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!c(connectivityManager)) {
                if (!a(connectivityManager)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void e(Context context) {
        try {
            if (f42851b == null) {
                f42851b = new aethna();
            }
            NetworkRequest build = new NetworkRequest.Builder().build();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(build, f42851b);
            }
        } catch (Exception e11) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.f42852a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }
}
