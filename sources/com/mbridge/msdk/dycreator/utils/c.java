package com.mbridge.msdk.dycreator.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.foundation.tools.o0;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class c {
    public static double a(double d11, double d12, int i11) {
        if (i11 < 0) {
            return 1.0d;
        }
        try {
            return new BigDecimal(Double.toString(d11)).divide(new BigDecimal(Double.toString(d12)), i11, 4).doubleValue();
        } catch (Exception e11) {
            o0.b("CommUtil", e11.getMessage());
            return 1.0d;
        }
    }

    public static int a(Context context, float f11) {
        if (context == null) {
            return 0;
        }
        try {
            Resources resources = context.getResources();
            if (resources == null) {
                return 0;
            }
            return (int) ((f11 * resources.getDisplayMetrics().density) + 0.5f);
        } catch (Exception e11) {
            o0.b("CommUtil", e11.getMessage());
            return 0;
        }
    }

    public static Map<String, String> a(Context context, AttributeSet attributeSet) {
        HashMap hashMap = new HashMap();
        if (context != null && attributeSet != null) {
            int attributeCount = attributeSet.getAttributeCount();
            for (int i11 = 0; i11 < attributeCount; i11++) {
                String attributeName = attributeSet.getAttributeName(i11);
                if (!TextUtils.isEmpty(attributeName)) {
                    if (attributeName.equals("mbridge_data")) {
                        try {
                            hashMap.put("mbridgeData", b.f34949a.get(attributeSet.getAttributeValue(i11).substring(8)));
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_click")) {
                        try {
                            hashMap.put("mbridgeAction", b.f34949a.get(attributeSet.getAttributeValue(i11).substring(8)));
                        } catch (Exception e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_strategy")) {
                        try {
                            hashMap.put("mbridgeStrategy", b.f34949a.get(attributeSet.getAttributeValue(i11).substring(8)));
                        } catch (Exception e13) {
                            e13.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_effect")) {
                        try {
                            hashMap.put("mbridgeEffect", b.f34949a.get(attributeSet.getAttributeValue(i11).substring(8)));
                        } catch (Exception e14) {
                            e14.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_report")) {
                        try {
                            hashMap.put("mbridgeReport", attributeSet.getAttributeValue(i11));
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static Map<String, Boolean> a(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\|");
            if (split == null || split.length <= 0) {
                if (str.equals("mbridgeAttached")) {
                    hashMap.put("mbridgeAttached", Boolean.TRUE);
                }
                if (str.equals("mbridgeDetached")) {
                    hashMap.put("mbridgeDetached", Boolean.TRUE);
                }
            } else {
                for (String str2 : split) {
                    if (str2.equals("mbridgeAttached")) {
                        hashMap.put("mbridgeAttached", Boolean.TRUE);
                    }
                    if (str2.equals("mbridgeDetached")) {
                        hashMap.put("mbridgeDetached", Boolean.TRUE);
                    }
                }
            }
        }
        return hashMap;
    }

    public static void a(Map<String, String> map, View view) {
        if (map == null || view == null) {
            return;
        }
        if (map.containsKey("mbridgeData")) {
            com.mbridge.msdk.dycreator.binding.b.a().b(view);
        }
        if (map.containsKey("mbridgeAction")) {
            com.mbridge.msdk.dycreator.binding.b.a().a(view);
        }
        if (map.containsKey("mbridgeEffect")) {
            com.mbridge.msdk.dycreator.binding.b.a().c(view);
        }
        if (map.containsKey("mbridgeReport")) {
            com.mbridge.msdk.dycreator.binding.b.a().d(view);
        }
    }
}
