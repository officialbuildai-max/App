package com.pgl.ssdk;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/* loaded from: classes5.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static AccessibilityManager f40248a;

    private static AccessibilityManager a(Context context) {
        if (f40248a == null) {
            f40248a = (AccessibilityManager) context.getSystemService("accessibility");
        }
        return f40248a;
    }

    public static String b(Context context) {
        AccessibilityManager a11;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        if (context == null || (a11 = a(context)) == null || (enabledAccessibilityServiceList = a11.getEnabledAccessibilityServiceList(-1)) == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < enabledAccessibilityServiceList.size(); i11++) {
            AccessibilityServiceInfo accessibilityServiceInfo = enabledAccessibilityServiceList.get(i11);
            if (accessibilityServiceInfo != null) {
                sb2.append(String.format("%s#%s", accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName, accessibilityServiceInfo.getResolveInfo().serviceInfo.name));
                if (i11 != enabledAccessibilityServiceList.size() - 1) {
                    sb2.append(",");
                }
            }
        }
        return sb2.toString();
    }
}
