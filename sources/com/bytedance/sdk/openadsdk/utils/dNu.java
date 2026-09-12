package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class dNu {
    public static void Sj() {
        Context Sj = com.bytedance.sdk.openadsdk.core.dNu.Sj();
        if (Sj != null && com.bytedance.sdk.component.utils.Zq.EjP()) {
            String packageName = Sj.getPackageName();
            int i11 = Sj.getApplicationInfo().targetSdkVersion;
            try {
                String[] strArr = Sj.getPackageManager().getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr == null || strArr.length <= 0) {
                    return;
                }
                List<String> sP = sP();
                for (String str : strArr) {
                    if (str != null) {
                        sP.remove(str);
                    }
                }
                if (sP.isEmpty()) {
                    return;
                }
                for (String str2 : sP) {
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static List<String> sP() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }
}
