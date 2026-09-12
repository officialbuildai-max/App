package com.cloud.tmc.miniapp.ui.extension;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewGroupKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.offlineapps.OfflineAppBean;
import com.cloud.tmc.miniapp.offlineapps.scan.OooO00o;
import com.cloud.tmc.miniapp.widget.OfflineAppView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class OfflineAppExtensionKt$realOfflineAppUpdate$1 implements OooO00o {
    public final /* synthetic */ ConstraintLayout $clOfflineAppsContainer;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ LinearLayout $llOfflineApps;
    public final /* synthetic */ LinearLayout $llOfflineAppsMore;

    public OfflineAppExtensionKt$realOfflineAppUpdate$1(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, Context context) {
        this.$clOfflineAppsContainer = constraintLayout;
        this.$llOfflineAppsMore = linearLayout;
        this.$llOfflineApps = linearLayout2;
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void result$lambda$5(List offlineApps, ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, final Context context) {
        String str;
        int i11;
        Intrinsics.h(offlineApps, "$offlineApps");
        Intrinsics.h(context, "$context");
        try {
            if (offlineApps.isEmpty()) {
                if (constraintLayout == null) {
                    return;
                }
                constraintLayout.setVisibility(8);
                return;
            }
            Bundle bundle = new Bundle();
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            int size = offlineApps.size();
            i11 = OfflineAppExtensionKt.offlineAppViews;
            if (size > i11) {
                bundle.putString(NotificationCompat.CATEGORY_STATUS, "more");
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record("", PointAnalyseType.POINT_LATER_OFFLINE_EX, "", bundle);
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < 4; i12++) {
                if (i12 >= offlineApps.size()) {
                    View view = linearLayout2 != null ? ViewGroupKt.get(linearLayout2, i12) : null;
                    if (view != null) {
                        view.setVisibility(4);
                    }
                } else {
                    OfflineAppBean offlineAppBean = (OfflineAppBean) offlineApps.get(i12);
                    View view2 = linearLayout2 != null ? ViewGroupKt.get(linearLayout2, i12) : null;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    View view3 = linearLayout2 != null ? ViewGroupKt.get(linearLayout2, i12) : null;
                    OfflineAppView offlineAppView = view3 instanceof OfflineAppView ? (OfflineAppView) view3 : null;
                    if (offlineAppView != null) {
                        String appId = offlineAppBean.getAppId();
                        String logoUrl = offlineAppBean.getLogoUrl();
                        if (logoUrl == null) {
                            logoUrl = "";
                        }
                        String name = offlineAppBean.getName();
                        if (name == null) {
                            name = "";
                        }
                        String logoPath = offlineAppBean.getLogoPath();
                        if (logoPath == null) {
                            logoPath = "";
                        }
                        offlineAppView.OooO00o(appId, logoUrl, name, logoPath);
                        offlineAppView.OooO00o();
                        offlineAppView.OooO0OO.setText(offlineAppView.OooO0oO);
                        offlineAppView.OooO00o(null, null);
                    }
                    arrayList.add(offlineAppBean.getAppId());
                }
            }
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_LATER_OFFLINE_APP_EX;
            Bundle bundle2 = new Bundle();
            bundle2.putString("miniappid", arrayList.toString());
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.record("", pointAnalyseType, "", bundle2);
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.ui.extension.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        OfflineAppExtensionKt$realOfflineAppUpdate$1.result$lambda$5$lambda$4(context, view4);
                    }
                });
            }
        } catch (Throwable th2) {
            str = OfflineAppExtensionKt.TAG;
            TmcLogger.e(str, "offlineAppUpdate fail:", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void result$lambda$5$lambda$4(Context context, View view) {
        Intrinsics.h(context, "$context");
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_LATER_OFFLINE_CLICK;
        Bundle bundle = new Bundle();
        bundle.putString(NativeComponentConstants.KEY_COMPONENT_TYPE, "more");
        Unit unit = Unit.f67184a;
        performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putString(TmcConstants.EXTRA_OPEN_MC_SCENE, "1");
        ByteAppManager.launchMiniAppForId(context, "1000886706715795456", "120011", bundle2);
    }

    @Override // com.cloud.tmc.miniapp.offlineapps.scan.OooO00o
    public void result(final List<OfflineAppBean> offlineApps) {
        Intrinsics.h(offlineApps, "offlineApps");
        final ConstraintLayout constraintLayout = this.$clOfflineAppsContainer;
        final LinearLayout linearLayout = this.$llOfflineAppsMore;
        final LinearLayout linearLayout2 = this.$llOfflineApps;
        final Context context = this.$context;
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.extension.h
            @Override // java.lang.Runnable
            public final void run() {
                OfflineAppExtensionKt$realOfflineAppUpdate$1.result$lambda$5(offlineApps, constraintLayout, linearLayout, linearLayout2, context);
            }
        });
    }
}
