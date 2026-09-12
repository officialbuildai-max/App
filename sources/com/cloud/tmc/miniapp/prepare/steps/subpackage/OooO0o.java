package com.cloud.tmc.miniapp.prepare.steps.subpackage;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareCallbackParam;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.resource.ISubPackageResourceManager;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.SubpackageAppPrepareUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooO0o extends com.cloud.tmc.miniapp.prepare.steps.structure.OooO0OO {
    public final String OooO;
    public final Integer OooOO0;
    public final OooOO0 OooOO0O;

    /* JADX WARN: Multi-variable type inference failed */
    public OooO0o() {
        this(null, 0 == true ? 1 : 0, 3);
    }

    public OooO0o(String str, Integer num) {
        this.OooO = str;
        this.OooOO0 = num;
        this.OooOO0O = new OooOO0();
    }

    public /* synthetic */ OooO0o(String str, Integer num, int i11) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 1 : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00db A[Catch: all -> 0x00f4, TryCatch #1 {all -> 0x00f4, blocks: (B:21:0x00d3, B:23:0x00db, B:25:0x00e3, B:26:0x00e9), top: B:20:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OooO00o(com.cloud.tmc.integration.model.AppModel r7, com.cloud.tmc.miniapp.prepare.controller.PrepareController r8, java.util.Map r9, java.util.Map r10, com.cloud.tmc.kernel.resource.IPackageResourceManager r11, com.cloud.tmc.integration.structure.AppLoadResult r12) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prepare.steps.subpackage.OooO0o.OooO00o(com.cloud.tmc.integration.model.AppModel, com.cloud.tmc.miniapp.prepare.controller.PrepareController, java.util.Map, java.util.Map, com.cloud.tmc.kernel.resource.IPackageResourceManager, com.cloud.tmc.integration.structure.AppLoadResult):void");
    }

    public final void OooO00o(AppModel appModel, List<? extends File> list, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, IPackageResourceManager iPackageResourceManager, String str) {
        for (File file : list) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    OooO00o(appModel, ArraysKt.K0(listFiles), hashMap, hashMap2, iPackageResourceManager, str + "/" + file.getName());
                }
            } else {
                String vUrl = iPackageResourceManager.generateVUrl(file.getAbsolutePath(), appModel.getAppId(), file.getName(), str);
                TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "SubpackageStartStep:absPath:" + file.getAbsolutePath() + ";vUrl:" + vUrl);
                String name = file.getName();
                Intrinsics.g(name, "f.name");
                Intrinsics.g(vUrl, "vUrl");
                hashMap.put(name, vUrl);
                String name2 = file.getName();
                Intrinsics.g(name2, "f.name");
                Locale locale = Locale.getDefault();
                Intrinsics.g(locale, "getDefault()");
                String lowerCase = name2.toLowerCase(locale);
                Intrinsics.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (StringsKt.c0(lowerCase, ".html", false, 2, null)) {
                    hashMap2.put(file.getName(), vUrl);
                }
                TmcLogger.d(this.OooO00o, "Step_LoadStep: tar包结构: " + file.getName());
                TmcLogger.d(this.OooO00o, "Step_LoadStep: tar包结构: " + vUrl);
            }
        }
    }

    public final void OooO00o(PrepareController prepareController, PrepareContext prepareContext, AppModel appModel, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3, IPackageResourceManager iPackageResourceManager, String str) {
        try {
            AppModel frameWorkModel = prepareContext.getFrameWorkModel();
            if (frameWorkModel != null) {
                List<File> listFilesInDir = this.OooO0o0.listFilesInDir(frameWorkModel);
                if (listFilesInDir != null && !listFilesInDir.isEmpty()) {
                    OooO00o(frameWorkModel, listFilesInDir, hashMap2, hashMap3, iPackageResourceManager, "");
                }
                AppPrepareUtils.INSTANCE.clearAllFilesForVersion(prepareContext.getStartContext(), frameWorkModel);
                if (prepareController != null) {
                    prepareController.moveToError(new PrepareException("14", "frameworkzip error"));
                    return;
                }
                return;
            }
        } catch (Throwable unused) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("14", "frameworkzip error"));
            }
            TmcLogger.d(this.OooO00o, "请先下载框架包资源文件：");
        }
        try {
            Context startContext = prepareContext.getStartContext();
            if (appModel != null && startContext != null) {
                List<File> listFilesInDir2 = this.OooO0o0.listFilesInDir(appModel, str);
                if (listFilesInDir2 != null && !listFilesInDir2.isEmpty()) {
                    this.OooOO0O.OooO00o();
                    if (this.OooOO0O.OooO0O0) {
                        return;
                    }
                    OooO00o(appModel, listFilesInDir2, hashMap, hashMap3, iPackageResourceManager, "");
                    return;
                }
                SubpackageAppPrepareUtils.INSTANCE.clearAllFilesForVersion(startContext, appModel, str);
                if (prepareController != null) {
                    prepareController.moveToError(new PrepareException(PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION, "miniappzip error"));
                }
            }
        } catch (Throwable th2) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException(PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION, th2.getMessage()));
            }
            TmcLogger.d(this.OooO00o, "资源文件出错");
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.structure.OooO0OO
    public void OooO00o(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo, PrepareCallbackParam prepareCallbackParam) {
        String str;
        Integer num = this.OooOO0O.OooO0o0;
        if (num != null && 1 == num.intValue() && (str = this.OooOO0O.OooO0OO) != null && str.length() != 0) {
            AppModel appModel = prepareContext.getAppModel();
            String appId = appModel != null ? appModel.getAppId() : null;
            if (appId != null && appId.length() != 0) {
                Context startContext = prepareContext.getStartContext();
                if (startContext == null) {
                    super.OooO00o(prepareController, prepareContext, o000oooo, prepareCallbackParam);
                    return;
                }
                KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
                StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
                AppModel appModel2 = prepareContext.getAppModel();
                String format = String.format(TmcConstants.SUBPACKAGE_LOAD_SYNC_LOCK_STATUS_KEY_FORMAT, Arrays.copyOf(new Object[]{appModel2 != null ? appModel2.getMainPackageUrlEncryption() : null}, 1));
                Intrinsics.g(format, "format(format, *args)");
                int i11 = kVStorageProxy.getInt(startContext, TmcConstants.SUBPACKAGE_STORAGE_FILE, format) + 1;
                if (i11 >= 2) {
                    kVStorageProxy.remove(startContext, TmcConstants.SUBPACKAGE_STORAGE_FILE, format);
                    super.OooO00o(prepareController, prepareContext, o000oooo, prepareCallbackParam);
                    return;
                } else {
                    kVStorageProxy.putInt(startContext, TmcConstants.SUBPACKAGE_STORAGE_FILE, format, i11);
                    if (prepareController != null) {
                        prepareController.finish();
                        return;
                    }
                    return;
                }
            }
        }
        super.OooO00o(prepareController, prepareContext, o000oooo, prepareCallbackParam);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.structure.OooO0OO
    public PrepareCallbackParam OooO0OO(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo) {
        String str;
        IPackageResourceManager iPackageResourceManager;
        try {
            TraceLog.i(this.OooO00o, "startStep 创建normal app config");
            AppModel appModel = prepareContext.getAppModel();
            this.OooOO0O.OooO00o(appModel, this.OooO, prepareContext, this.OooOO0);
            String OooO00o = this.OooOO0O.OooO00o(appModel);
            if ((appModel != null ? appModel.getPermissions() : null) != null) {
                ((AuthenticationProxy) TmcProxy.get(AuthenticationProxy.class)).setPermissionModel(appModel.getAppId(), appModel.getPermissions());
            }
            this.OooO0O0.updateAppModel(prepareContext.getStartContext(), appModel, (appModel != null ? appModel.getAppId() : null) + "_used");
            if (this.OooO0O0.getPreUnzipStatus(prepareContext.getStartContext(), appModel != null ? appModel.getAppId() : null)) {
                TmcLogger.d(TmcConstants.TAG, "startStep_使用了预先解压的包");
                ((PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class)).addPeroformanceImprove(appModel != null ? appModel.getAppId() : null, "preunzip");
                this.OooO0O0.updatePreUnzipStatus(prepareContext.getStartContext(), appModel != null ? appModel.getAppId() : null, false);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            HashMap<String, String> hashMap2 = new HashMap<>();
            HashMap<String, String> hashMap3 = new HashMap<>();
            IPackageResourceManager manager = (IPackageResourceManager) TmcProxy.get(IPackageResourceManager.class);
            if (OooO00o != null) {
                Intrinsics.g(manager, "manager");
                str = "manager";
                iPackageResourceManager = manager;
                OooO00o(prepareController, prepareContext, appModel, hashMap, hashMap2, hashMap3, manager, OooO00o);
            } else {
                str = "manager";
                iPackageResourceManager = manager;
            }
            AppLoadResult appLoadResult = new AppLoadResult();
            appLoadResult.appVersion = MiniAppLaunch.INSTANCE.getMiniAppVersion(appModel);
            appLoadResult.mainHtmlUrl = FrameworkConstants.TEMPLATE_URL;
            IPackageResourceManager iPackageResourceManager2 = iPackageResourceManager;
            Intrinsics.g(iPackageResourceManager2, str);
            Object obj = TmcProxy.get(ISubPackageResourceManager.class);
            Intrinsics.g(obj, "get(ISubPackageResourceManager::class.java)");
            OooO00o(appModel, prepareController, hashMap, hashMap2, iPackageResourceManager2, appLoadResult);
            appLoadResult.htmlMap = hashMap3;
            appLoadResult.appType = TmcConstants.TYPE_WEB_TINY;
            appLoadResult.frameWorkModel = prepareContext.getFrameWorkModel();
            new PrepareCallbackParam(prepareContext).appLoadResult = appLoadResult;
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(prepareContext);
            prepareCallbackParam.appLoadResult = appLoadResult;
            return prepareCallbackParam;
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO00o, th2);
            return null;
        }
    }
}
