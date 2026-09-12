package com.transsion.api.gateway.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class NetworkUtils {
    private static AtomicBoolean isNetworkAvailable = new AtomicBoolean();

    /* loaded from: classes5.dex */
    public enum NetworkType {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G,
        NETWORK_5G,
        NETWORK_ETHERNET
    }

    public static boolean checkNetworkState() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        try {
            if (ContextUtils.getContext().getApplicationContext() == null || (connectivityManager = (ConnectivityManager) ContextUtils.getContext().getApplicationContext().getSystemService("connectivity")) == null) {
                return false;
            }
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
                networkInfo = null;
            }
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static NetworkType getNetworkType(Context context) {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        try {
            networkInfo = connectivityManager.getNetworkInfo(9);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (networkInfo == null || ((state = networkInfo.getState()) != NetworkInfo.State.CONNECTED && state != NetworkInfo.State.CONNECTING)) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getType() == 1) {
                    return NetworkType.NETWORK_WIFI;
                }
                if (activeNetworkInfo.getType() != 0) {
                    return NetworkType.NETWORK_UNKNOWN;
                }
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return NetworkType.NETWORK_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return NetworkType.NETWORK_3G;
                    case 13:
                    case 18:
                        return NetworkType.NETWORK_4G;
                    case 19:
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return NetworkType.NETWORK_UNKNOWN;
                        }
                        return NetworkType.NETWORK_3G;
                    case 20:
                        return NetworkType.NETWORK_5G;
                }
            }
            return NetworkType.NETWORK_UNKNOWN;
        }
        return NetworkType.NETWORK_ETHERNET;
    }

    public static boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ContextUtils.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
