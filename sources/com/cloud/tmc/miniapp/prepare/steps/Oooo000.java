package com.cloud.tmc.miniapp.prepare.steps;

import android.os.Bundle;
import com.cloud.tmc.integration.chain.endState.LoadStepEndState;
import com.cloud.tmc.integration.chain.startState.LocalDataFileScanStepStartState;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.performance.offscreen.webview.OffScreenWebviewPool;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.FilePathUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.FileUtils;
import java.io.File;
import java.util.List;

/* loaded from: classes3.dex */
public class Oooo000 extends OooO00o {
    public final void OooO00o(PrepareContext prepareContext, FileProxy fileProxy, IFileResourceManager iFileResourceManager, List<File> list, String str) {
        for (File file : list) {
            if (file.isDirectory()) {
                OooO00o(prepareContext, fileProxy, iFileResourceManager, fileProxy.listFilesInDir(file.getAbsolutePath()), str + "/" + file.getName());
            } else {
                String generateVUrl = iFileResourceManager.generateVUrl(file.getAbsolutePath(), prepareContext.getAppId(), file.getName(), str);
                String str2 = this.OooO00o;
                StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("Step_LocalDataFileScanStep: fileName: ");
                OooO00o.append(file.getName());
                OooO00o.append(", vUrl: ");
                OooO00o.append(generateVUrl);
                TmcLogger.d(str2, OooO00o.toString());
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.o0OoOo0
    public StepType OooO0O0() {
        return StepType.FILE_SCAN;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooO00o, com.cloud.tmc.miniapp.prepare.steps.o0OoOo0
    public void OooO0O0(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo) throws PrepareException {
        if (!prepareContext.getVirtualStart()) {
            try {
                MiniAppLaunch.INSTANCE.commonResTrack(prepareContext.getAppId(), "l_e");
            } catch (Throwable unused) {
            }
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "app");
            OooO0O0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, bundle, ChainPoint.CHAIN_ID);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_CHAIN_END, ChainPoint.LoadStep, bundle);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_CHAIN_START, ChainPoint.LocalDataFileScanStep, bundle);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.AppLoadStep, new Bundle());
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_START, ChainPoint.AppLocalDataFileScanStep, new Bundle());
            new LoadStepEndState(new Bundle()).setChainContext(prepareContext.getAppChainContext());
            new LocalDataFileScanStepStartState(new Bundle()).setChainContext(prepareContext.getAppChainContext());
            if (prepareContext.getActivity() != null) {
                OffScreenWebviewPool.INSTANCE.retryOffScreenRender(prepareContext.getActivity(), this, prepareContext);
            }
        }
        if (AppPrepareUtils.INSTANCE.isShellType(prepareContext.getAppModel())) {
            prepareController.moveToNext();
            return;
        }
        super.OooO0O0(prepareController, prepareContext, o000oooo);
        TmcLogger.d(this.OooO00o, "Step_进度:LocalDataFileScanStep");
        String appBaseFilePath = ((PathProxy) TmcProxy.get(PathProxy.class)).getAppBaseFilePath(prepareContext.getAppId());
        File file = new File(appBaseFilePath, TmcConstants.LOCAL_DATA_PATH);
        File file2 = new File(appBaseFilePath, TmcConstants.TEMP_DATA_PATH);
        FileProxy fileProxy = (FileProxy) TmcProxy.get(FileProxy.class);
        try {
            boolean createOrExistsDir = FileUtils.createOrExistsDir(file);
            boolean createOrExistsDir2 = FileUtils.createOrExistsDir(file2);
            String str = this.OooO00o;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Creating local_data directory ");
            sb2.append(createOrExistsDir ? "successful" : "failed");
            TmcLogger.d(str, sb2.toString());
            String str2 = this.OooO00o;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Creating temp_data directory ");
            sb3.append(createOrExistsDir2 ? "successful" : "failed");
            TmcLogger.d(str2, sb3.toString());
            String appId = prepareContext.getAppId();
            boolean mMKVDowngradeStatus = FilePathUtils.INSTANCE.getMMKVDowngradeStatus();
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(prepareContext.getStartContext(), appId, appId + "_scan_downgrade", mMKVDowngradeStatus);
            TmcLogger.e(this.OooO00o, "LocalDataFileScanStep downgrade status = " + mMKVDowngradeStatus);
            if (!mMKVDowngradeStatus) {
                TmcLogger.e(this.OooO00o, "skip LocalDataFileScanStep");
                prepareController.moveToNext();
                return;
            }
            List<File> listFilesInDir = fileProxy.listFilesInDir(file.getAbsolutePath());
            List<File> listFilesInDir2 = fileProxy.listFilesInDir(file2.getAbsolutePath());
            if (!listFilesInDir.isEmpty() || !listFilesInDir2.isEmpty()) {
                IFileResourceManager iFileResourceManager = (IFileResourceManager) TmcProxy.get(IFileResourceManager.class);
                OooO00o(prepareContext, fileProxy, iFileResourceManager, listFilesInDir, TmcConstants.LOCAL_DATA_PATH);
                OooO00o(prepareContext, fileProxy, iFileResourceManager, listFilesInDir2, TmcConstants.TEMP_DATA_PATH);
            }
            if (o000oooo != null) {
                o000oooo.OooO00o(prepareContext.getPrepareData(), prepareContext.getAppModel(), prepareContext.getStartParams(), prepareContext.getSceneParams());
            }
            prepareController.moveToNext();
        } catch (Exception e11) {
            prepareController.moveToError(new PrepareException("12", "Resource file error: " + e11, e11));
        }
    }
}
