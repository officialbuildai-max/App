package com.cloud.tmc.integration.proxy;

import com.cloud.tmc.kernel.proxy.Proxiable;

/* loaded from: classes3.dex */
public interface PerformanceProxy extends Proxiable {
    void sendPerfStageLog(String str, String str2);

    void sendPerfV2(String str);
}
