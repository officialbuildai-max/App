package com.cloud.tmc.miniapp.performanceanalyse;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.MiniCardAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.a;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooO0o {
    public void OooO00o(String str, MiniCardAnalyseType target, Bundle bundle) {
        String objectNameZh;
        StringBuilder sb2;
        Intrinsics.h(target, "target");
        if (str != null) {
            objectNameZh = target.getObjectNameZh();
            sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(str);
            sb2.append("]:");
        } else {
            objectNameZh = target.getObjectNameZh();
            sb2 = new StringBuilder();
        }
        sb2.append(objectNameZh);
        sb2.append((Object) "");
        String sb3 = sb2.toString();
        ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
        Bundle bundle2 = new Bundle();
        bundle2.putString(target.getClass().getSimpleName() + "." + target.name(), sb3);
        bundle2.putString("object_id", target.getObjectId());
        bundle2.putString("object_name", target.getObjectNameEn());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Unit unit = Unit.f67184a;
        reportProxy.report(str, "miniapp_card", bundle2);
        TmcLogger.d(TmcConstants.MINI_CARD_TAG, sb3);
        a.a(target, sb3);
    }
}
