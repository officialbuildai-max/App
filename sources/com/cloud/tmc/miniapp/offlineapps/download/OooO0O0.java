package com.cloud.tmc.miniapp.offlineapps.download;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.FilePathUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniutils.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class OooO0O0 {
    public static Application OooO0O0;
    public static com.cloud.tmc.miniapp.offlineapps.download.OooO00o OooO0OO;
    public static final OooO0O0 OooO00o = new OooO0O0();
    public static final ThreadPoolExecutor OooO0Oo = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new OooO0o(), new com.cloud.tmc.miniapp.offlineapps.download.OooO0OO());

    /* loaded from: classes3.dex */
    public interface OooO00o {
        void OooO00o(String str, String str2, String str3, boolean z10);
    }

    /* renamed from: com.cloud.tmc.miniapp.offlineapps.download.OooO0O0$OooO0O0, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0345OooO0O0 implements OooO00o {
        @Override // com.cloud.tmc.miniapp.offlineapps.download.OooO0O0.OooO00o
        public void OooO00o(String appId, String logoUrl, String path, boolean z10) {
            com.cloud.tmc.miniapp.offlineapps.download.OooO00o oooO00o;
            Intrinsics.h(appId, "appId");
            Intrinsics.h(logoUrl, "logoUrl");
            Intrinsics.h(path, "path");
            TmcLogger.d("IconDownloadManager", "[downloadIcon] appId:" + appId + ", logoUrl:" + logoUrl + ", path:" + path + ", success:" + z10);
            if (z10 && OooO0O0.OooO00o.OooO00o(appId, logoUrl, path) && (oooO00o = OooO0O0.OooO0OO) != null) {
                oooO00o.OooO00o(appId, logoUrl, path);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO implements PackageDownloadCallback {
        public final /* synthetic */ OooO00o OooO00o;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ String OooO0Oo;
        public final /* synthetic */ Ref.ObjectRef<String> OooO0o0;

        public OooO0OO(OooO00o oooO00o, String str, String str2, String str3, Ref.ObjectRef<String> objectRef) {
            this.OooO00o = oooO00o;
            this.OooO0O0 = str;
            this.OooO0OO = str2;
            this.OooO0Oo = str3;
            this.OooO0o0 = objectRef;
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onCancel(String str, String str2) {
            this.OooO00o.OooO00o(this.OooO0O0, this.OooO0OO, "", false);
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFailed(String str, String errorCode, String errorMsg, IOException e11, String str2) {
            Intrinsics.h(errorCode, "errorCode");
            Intrinsics.h(errorMsg, "errorMsg");
            Intrinsics.h(e11, "e");
            this.OooO00o.OooO00o(this.OooO0O0, this.OooO0OO, "", false);
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFinish(String str, String str2) {
            String generateVUrl;
            try {
                if (FilePathUtils.INSTANCE.getDowngradeStatus(this.OooO0O0)) {
                    generateVUrl = ((IImageResourceManager) TmcProxy.get(IImageResourceManager.class)).generateVUrl(this.OooO0Oo, "1000886706715795456", this.OooO0o0.element);
                    Intrinsics.g(generateVUrl, "manager.generateVUrl(downloadPath, MC_APPID, name)");
                } else {
                    generateVUrl = ((IFileResourceManager) TmcProxy.get(IFileResourceManager.class)).generateVUrl(this.OooO0Oo, "1000886706715795456", this.OooO0o0.element, TmcConstants.TEMP_DATA_PATH);
                    Intrinsics.g(generateVUrl, "manager.generateVUrl(dow…Constants.TEMP_DATA_PATH)");
                }
                this.OooO00o.OooO00o(this.OooO0O0, this.OooO0OO, generateVUrl, true);
            } catch (Throwable th2) {
                TmcLogger.e("IconDownloadManager", "[downloadIcon] error", th2);
                this.OooO00o.OooO00o(this.OooO0O0, this.OooO0OO, "", false);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onPrepare(String url1, String callbackId1) {
            Intrinsics.h(url1, "url1");
            Intrinsics.h(callbackId1, "callbackId1");
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onProgress(String url1, int i11, String callbackId1) {
            Intrinsics.h(url1, "url1");
            Intrinsics.h(callbackId1, "callbackId1");
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void progressUpdate(String url1, int i11, String callbackId1, long j11, long j12) {
            Intrinsics.h(url1, "url1");
            Intrinsics.h(callbackId1, "callbackId1");
        }
    }

    public static final void OooO0O0(String appId, String logoUrl) {
        Intrinsics.h(appId, "$appId");
        Intrinsics.h(logoUrl, "$logoUrl");
        try {
            OooO0O0 oooO0O0 = OooO00o;
            if (oooO0O0.OooO0Oo(appId, logoUrl)) {
                oooO0O0.OooO00o(appId, logoUrl, new C0345OooO0O0());
            }
        } catch (Throwable th2) {
            TmcLogger.e("IconDownloadManager", "[addTask] error", th2);
        }
    }

    public final void OooO00o(final String appId, final String logoUrl) {
        Intrinsics.h(appId, "appId");
        Intrinsics.h(logoUrl, "logoUrl");
        if (((ConfigService) TmcProxy.get(ConfigService.class)).getConfigBoolean(LauncherMiniAppConfigHelper.KEY_OFFLINE_APPS_ABILITY_SWITCH, true)) {
            OooO0Oo.submit(new Runnable() { // from class: com.cloud.tmc.miniapp.offlineapps.download.a
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0O0.OooO0O0(appId, logoUrl);
                }
            });
        } else {
            TmcLogger.d("IconDownloadManager", "[addTask] offlineAppsAbilitySwitch is close");
        }
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [T, java.lang.Object] */
    public final void OooO00o(String str, String str2, OooO00o oooO00o) {
        List l11;
        if (str.length() == 0) {
            TmcLogger.e("IconDownloadManager", "[downloadIcon] appId isEmpty");
            return;
        }
        if (str2.length() == 0) {
            TmcLogger.e("IconDownloadManager", "[downloadIcon] appid:" + str + " logoUrl isEmpty");
            return;
        }
        String path = Uri.parse(str2).getPath();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (!TextUtils.isEmpty(path)) {
            if (path == null || (l11 = StringsKt.S0(path, new String[]{"/"}, false, 0, 6, null)) == null) {
                l11 = CollectionsKt.l();
            }
            if (!l11.isEmpty()) {
                objectRef.element = l11.get(l11.size() - 1);
            }
        }
        if (((CharSequence) objectRef.element).length() == 0) {
            TmcLogger.e("IconDownloadManager", "[downloadIcon] name is empty");
            return;
        }
        String appBaseFilePath = ((PathProxy) TmcProxy.get(PathProxy.class)).getAppBaseFilePath("1000886706715795456");
        String str3 = File.separator;
        String str4 = appBaseFilePath + str3 + TmcConstants.TEMP_DATA_PATH + str3 + objectRef.element;
        if (FileUtils.createFileByDeleteOldFile(str4)) {
            ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).downloadPackage(str, str2, str4, null, String.valueOf(System.currentTimeMillis()), new OooO0OO(oooO00o, str, str2, str4, objectRef));
        } else {
            TmcLogger.e("IconDownloadManager", "[downloadIcon] createFileByDeleteOldFile fail");
        }
    }

    public final boolean OooO00o(String str, String str2, String str3) {
        boolean z10;
        Application application;
        try {
            application = OooO0O0;
        } catch (Throwable th2) {
            TmcLogger.e("IconDownloadManager", "[saveDownloadIconCache] error", th2);
        }
        if (application != null) {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(application, str, str2, str3);
            z10 = true;
            TmcLogger.d("IconDownloadManager", "[saveDownloadIconCache] appId:" + str + ", logoUrl:" + str2 + ", path:" + str3 + ", ret:" + z10);
            return z10;
        }
        z10 = false;
        TmcLogger.d("IconDownloadManager", "[saveDownloadIconCache] appId:" + str + ", logoUrl:" + str2 + ", path:" + str3 + ", ret:" + z10);
        return z10;
    }

    public final String OooO0OO(String appId, String logoUrl) {
        String str;
        Application application;
        Intrinsics.h(appId, "appId");
        Intrinsics.h(logoUrl, "logoUrl");
        try {
            application = OooO0O0;
        } catch (Throwable th2) {
            TmcLogger.e("IconDownloadManager", "[getIconPath] error", th2);
        }
        if (application != null) {
            str = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(application, appId, logoUrl);
            TmcLogger.d("IconDownloadManager", "[getIconPath] appId:" + appId + ", logoUrl:" + logoUrl + ", path:" + ((Object) str));
            return str;
        }
        str = null;
        TmcLogger.d("IconDownloadManager", "[getIconPath] appId:" + appId + ", logoUrl:" + logoUrl + ", path:" + ((Object) str));
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r2.length() == 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean OooO0Oo(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = r5.length()
            java.lang.String r1 = "IconDownloadManager"
            if (r0 <= 0) goto L2f
            int r0 = r6.length()
            if (r0 <= 0) goto L2f
            r0 = 1
            android.app.Application r2 = com.cloud.tmc.miniapp.offlineapps.download.OooO0O0.OooO0O0     // Catch: java.lang.Throwable -> L28
            if (r2 == 0) goto L30
            java.lang.Class<com.cloud.tmc.kernel.proxy.storage.KVStorageProxy> r3 = com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class
            java.lang.Object r3 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r3)     // Catch: java.lang.Throwable -> L28
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r3 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r3     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = r3.getString(r2, r5, r6)     // Catch: java.lang.Throwable -> L28
            if (r2 == 0) goto L30
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L28
            if (r2 != 0) goto L2f
            goto L30
        L28:
            r2 = move-exception
            java.lang.String r3 = "[iconIsNeedDownload] error"
            com.cloud.tmc.kernel.log.TmcLogger.e(r1, r3, r2)
            goto L30
        L2f:
            r0 = 0
        L30:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[iconIsNeedDownload] appId:"
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = ", logoUrl:"
            r2.append(r5)
            r2.append(r6)
            java.lang.String r5 = ", needDownload:"
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            com.cloud.tmc.kernel.log.TmcLogger.d(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.offlineapps.download.OooO0O0.OooO0Oo(java.lang.String, java.lang.String):boolean");
    }
}
