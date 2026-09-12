package com.cloud.tmc.kernel.proxy.performanceanalyse;

import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;

@DefaultImpl("com.cloud.tmc.miniapp.performanceanalyse.PerformanceUtils")
/* loaded from: classes3.dex */
public interface PerformanceImprovesProxy extends Proxiable {
    void addPeroformanceImprove(String str, String str2);

    void clearPerformanceImproves(String str);

    String getPerformanceImproves(String str);

    void resetPerformanceImproves(String str);
}
