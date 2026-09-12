package com.transsion.ad.bidding.base;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.transsion.ad.db.pslink.AppInstalledBean;
import com.transsion.ad.ps.installed.AppInstallManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class x extends TAdditionalListener {
    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onAdActivate(AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onAdActivate(additionalInfo);
        AppInstallManager appInstallManager = AppInstallManager.f42250a;
        String packageName = additionalInfo.getPackageName();
        if (packageName == null) {
            packageName = "ew没有传递过来包名";
        }
        AppInstalledBean a11 = appInstallManager.a(packageName);
        a11.setECPM(additionalInfo.getECPM());
        a11.setSource(AppInstalledBean.APP_INSTALLED_BEAN_SOURCE_EW);
        a11.setHorizontalImageUrl(additionalInfo.getImageUrl());
        Application a12 = Utils.a();
        Intrinsics.g(a12, "getApp(...)");
        appInstallManager.e(a12, a11);
    }
}
