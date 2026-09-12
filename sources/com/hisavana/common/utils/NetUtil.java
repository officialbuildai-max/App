package com.hisavana.common.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.cloud.sdk.commonutil.util.e;

/* loaded from: classes4.dex */
public class NetUtil {
    public static boolean checkNetworkState() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (e.a().getApplicationContext() == null || (connectivityManager = (ConnectivityManager) e.a().getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isAvailable();
    }
}
