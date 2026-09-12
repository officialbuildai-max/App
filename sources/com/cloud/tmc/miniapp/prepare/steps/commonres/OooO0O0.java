package com.cloud.tmc.miniapp.prepare.steps.commonres;

import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppInfoQuery;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.StepType;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooO0O0 extends com.cloud.tmc.miniapp.prepare.steps.OooO00o {
    public final AppModel OooO00o(String str, AppModel appModel, PrepareContext prepareContext) {
        AppInfoModel appInfoModel = new AppInfoModel();
        appInfoModel.setAppId(str);
        appInfoModel.setDeployVersion(appModel.getTemplateDeployVersion());
        appInfoModel.setPackageUrl(appModel.getTemplatePackageUrl());
        AppModel generateAppModel = MiniAppLaunch.INSTANCE.generateAppModel(appInfoModel);
        this.OooO0O0.updateAppModel(prepareContext.getStartContext(), generateAppModel, str + "_pre");
        return generateAppModel;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.o0OoOo0
    public StepType OooO0O0() {
        return StepType.COMMON_RES_INFO_UPDATE;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooO00o, com.cloud.tmc.miniapp.prepare.steps.o0OoOo0
    public void OooO0O0(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo) {
        super.OooO0O0(prepareController, prepareContext, o000oooo);
        AppModel appModel = prepareContext.getAppModel();
        if (appModel == null) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("appModel is null"));
                return;
            }
            return;
        }
        if (!AppUtils.INSTANCE.checkUesCommonresApp(appModel.getMiniappSubtype())) {
            if (prepareController != null) {
                prepareController.moveToNext();
                return;
            }
            return;
        }
        String templateMiniappId = appModel.getTemplateMiniappId();
        if (templateMiniappId == null) {
            templateMiniappId = "";
        }
        if (templateMiniappId.length() == 0) {
            if (prepareController != null) {
                prepareController.moveToNext();
                return;
            }
            return;
        }
        String appId = appModel.getAppId();
        if (appId != null) {
            MiniAppLaunch.INSTANCE.commonResTrack(appId, "u_s");
        }
        AppModel appModel2 = this.OooO0O0.getAppModel(prepareContext.getStartContext(), AppInfoQuery.INSTANCE.make(templateMiniappId));
        if (appModel2 == null) {
            appModel2 = OooO00o(templateMiniappId, appModel, prepareContext);
        } else {
            if (appModel2.getFromCacheType() == 3 || appModel2.getFromCacheType() == 5 || appModel2.getFromCacheType() == 6) {
                MiniAppLaunch.INSTANCE.buildDownloadPath(appModel2);
            }
            if (!Intrinsics.c(appModel2.getPackageUrl(), appModel.getTemplatePackageUrl())) {
                MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
                String templateDeployVersion = appModel.getTemplateDeployVersion();
                if (templateDeployVersion == null) {
                    templateDeployVersion = "";
                }
                String deployVersion = appModel2.getDeployVersion();
                if (miniAppLaunch.compareVersion(templateDeployVersion, deployVersion != null ? deployVersion : "")) {
                    AppModel OooO00o = OooO00o(templateMiniappId, appModel, prepareContext);
                    boolean isDownloaded = this.OooO0OO.isDownloaded(prepareContext.getStartContext(), appModel2);
                    Boolean valueOf = Boolean.valueOf(isDownloaded);
                    if (isDownloaded) {
                        valueOf = null;
                    }
                    if (valueOf != null && appModel2.getFromCacheType() != 3 && appModel2.getFromCacheType() != 4) {
                        appModel2 = OooO00o;
                    }
                }
            }
        }
        prepareContext.setCommonResModel(appModel2);
        if (prepareController != null) {
            prepareController.moveToNext();
        }
    }
}
