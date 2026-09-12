package com.cloud.tmc.miniapp.prepare.steps.subpackage;

import android.os.Bundle;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.utils.SubpackageAppPrepareUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.utils.OooOOO0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooO0OO extends com.cloud.tmc.miniapp.prepare.steps.structure.OooO0O0 {
    public String OooO;
    public final Integer OooOO0;
    public final OooOO0 OooOO0O;
    public boolean OooOO0o;

    /* loaded from: classes3.dex */
    public static final class OooO00o implements PackageDownloadCallback {
        public final /* synthetic */ o000oOoO OooO;
        public final /* synthetic */ boolean OooO00o;
        public final /* synthetic */ OooO0OO OooO0O0;
        public final /* synthetic */ AppModel OooO0OO;
        public final /* synthetic */ String OooO0Oo;
        public final /* synthetic */ PrepareContext OooO0o;
        public final /* synthetic */ String OooO0o0;
        public final /* synthetic */ String OooO0oO;
        public final /* synthetic */ PrepareController OooO0oo;
        public final /* synthetic */ String OooOO0;

        public OooO00o(boolean z10, OooO0OO oooO0OO, AppModel appModel, String str, String str2, PrepareContext prepareContext, String str3, PrepareController prepareController, o000oOoO o000oooo, String str4) {
            this.OooO00o = z10;
            this.OooO0O0 = oooO0OO;
            this.OooO0OO = appModel;
            this.OooO0Oo = str;
            this.OooO0o0 = str2;
            this.OooO0o = prepareContext;
            this.OooO0oO = str3;
            this.OooO0oo = prepareController;
            this.OooO = o000oooo;
            this.OooOO0 = str4;
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onCancel(String str, String str2) {
            try {
                PointAnalyseType putData = PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0).putData(TmcConstants.TRACK_MPU_RESULT, "IOException").putData(TmcConstants.TRACK_MPU_ERROR_CODE, "D006").putData(TmcConstants.TRACK_MPU_ERROR_MSG, "Canceled").putData(TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID, this.OooO0o.getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
                Intrinsics.g(putData, "POINT_PACKAGE_DOWNLOAD_U…                        )");
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0o.getAppId(), this.OooO0O0.OooOO0O.OooO00o(putData), "");
                try {
                    this.OooO0O0.OooO0OO.removeDownloadAppMap(this.OooO0oO);
                } catch (Throwable th2) {
                    TmcLogger.e(TmcConstants.TAG, th2);
                }
            } catch (Throwable th3) {
                TmcLogger.e(TmcConstants.TAG, th3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onFailed(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.io.IOException r20, java.lang.String r21) {
            /*
                Method dump skipped, instructions count: 392
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prepare.steps.subpackage.OooO0OO.OooO00o.onFailed(java.lang.String, java.lang.String, java.lang.String, java.io.IOException, java.lang.String):void");
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFinish(String str, String str2) {
            try {
                TmcLogger.d(this.OooO0O0.OooO00o, "Step_Download_资源包下载完成，进行解压");
                SubpackageAppPrepareUtils.INSTANCE.changeZipDownloadStatus(this.OooO0o.getStartContext(), this.OooO0OO.getAppId(), this.OooO0oO, true);
                PointAnalyseType putData = PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0).putData(TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID, this.OooO0o.getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
                Intrinsics.g(putData, "POINT_PACKAGE_DOWNLOAD_S…                        )");
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0o.getAppId(), this.OooO0O0.OooOO0O.OooO00o(putData), "");
                try {
                    this.OooO0O0.OooO0OO.removeDownloadAppMap(this.OooO0oO);
                } catch (Throwable th2) {
                    TmcLogger.e(TmcConstants.TAG, th2);
                }
                if (this.OooO00o) {
                    PrepareController prepareController = this.OooO0oo;
                    prepareController.unlock(prepareController);
                    this.OooO0oo.moveToNext();
                } else {
                    try {
                        if (MiniAppLaunch.INSTANCE.checkEnableBackgroundUnzip()) {
                            OooOOO0.OooO00o.OooO0O0(this.OooO0o.getStartContext(), this.OooO0OO, this.OooO0O0.OooOO0O.OooO0O0(), false, true);
                        }
                    } catch (Throwable th3) {
                        TmcLogger.e(TmcConstants.TAG, th3);
                    }
                    this.OooO.backgroundDownloadZipAsync(this.OooO0OO, true);
                }
            } catch (Throwable th4) {
                TmcLogger.e(TmcConstants.TAG, th4);
                if (this.OooO00o) {
                    this.OooO0oo.moveToError(new PrepareException("download error"));
                }
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onPrepare(String str, String str2) {
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onProgress(String str, int i11, String str2) {
            if (this.OooO00o) {
                TmcLogger.d(this.OooO0O0.OooO00o, "Step_Download_下载资源包" + i11);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public /* synthetic */ void progressUpdate(String str, int i11, String str2, long j11, long j12) {
            com.cloud.tmc.kernel.proxy.network.a.a(this, str, i11, str2, j11, j12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OooO0OO() {
        this(null, 0 == true ? 1 : 0, 3);
    }

    public OooO0OO(String str, Integer num) {
        this.OooO = str;
        this.OooOO0 = num;
        this.OooOO0O = new OooOO0();
        this.OooOO0o = true;
    }

    public /* synthetic */ OooO0OO(String str, Integer num, int i11) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 1 : null);
    }

    public static final void OooO00o(OooO0OO this$0, PrepareContext context, o000oOoO callback) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(context, "$context");
        Intrinsics.h(callback, "$callback");
        this$0.getClass();
        try {
            ((IClientStarter) TmcProxy.get(IClientStarter.class)).createSubpackagePrepareController(context, callback, 2, this$0.OooOO0O.OooO0OO).start();
        } catch (Throwable th2) {
            TmcLogger.e(this$0.OooO00o, th2);
        }
    }

    public final void OooO00o(PrepareContext prepareContext, PrepareController prepareController) {
        if (!prepareContext.getVirtualStart()) {
            Bundle bundle = new Bundle();
            bundle.putInt(ChainPoint.DOWNLOAD_APP_MODE, 1);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_APP_CHAIN_INSERT, "", bundle);
        }
        prepareController.moveToNext();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OooO00o(com.cloud.tmc.miniapp.prepare.controller.PrepareController r26, com.cloud.tmc.integration.model.PrepareContext r27, com.cloud.tmc.miniapp.prepare.steps.o000oOoO r28, com.cloud.tmc.integration.model.AppModel r29, java.lang.String r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prepare.steps.subpackage.OooO0OO.OooO00o(com.cloud.tmc.miniapp.prepare.controller.PrepareController, com.cloud.tmc.integration.model.PrepareContext, com.cloud.tmc.miniapp.prepare.steps.o000oOoO, com.cloud.tmc.integration.model.AppModel, java.lang.String, boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0477 A[Catch: all -> 0x004b, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0017, B:6:0x002e, B:11:0x0036, B:13:0x003c, B:15:0x0040, B:16:0x004e, B:19:0x005b, B:21:0x00a0, B:24:0x00ba, B:26:0x00d8, B:29:0x00e2, B:31:0x0101, B:34:0x011b, B:59:0x0310, B:66:0x0314, B:68:0x0325, B:70:0x032b, B:71:0x032f, B:73:0x0335, B:76:0x0347, B:78:0x035a, B:79:0x0364, B:86:0x03d3, B:88:0x03e1, B:90:0x03f1, B:93:0x03fd, B:97:0x0406, B:100:0x040d, B:102:0x0413, B:103:0x0443, B:104:0x0473, B:106:0x0477, B:107:0x047a, B:109:0x0483, B:112:0x048a, B:114:0x0490, B:115:0x04a9, B:116:0x0508, B:118:0x050c, B:122:0x04bb, B:126:0x04fd, B:130:0x04f8, B:132:0x038e, B:134:0x03a5, B:135:0x03ab, B:160:0x0463, B:162:0x046f, B:165:0x0127, B:168:0x0133, B:170:0x012c, B:172:0x014a, B:174:0x0151, B:176:0x0158, B:178:0x015e, B:180:0x0166, B:190:0x00e8, B:125:0x04bf), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0483 A[Catch: all -> 0x004b, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0017, B:6:0x002e, B:11:0x0036, B:13:0x003c, B:15:0x0040, B:16:0x004e, B:19:0x005b, B:21:0x00a0, B:24:0x00ba, B:26:0x00d8, B:29:0x00e2, B:31:0x0101, B:34:0x011b, B:59:0x0310, B:66:0x0314, B:68:0x0325, B:70:0x032b, B:71:0x032f, B:73:0x0335, B:76:0x0347, B:78:0x035a, B:79:0x0364, B:86:0x03d3, B:88:0x03e1, B:90:0x03f1, B:93:0x03fd, B:97:0x0406, B:100:0x040d, B:102:0x0413, B:103:0x0443, B:104:0x0473, B:106:0x0477, B:107:0x047a, B:109:0x0483, B:112:0x048a, B:114:0x0490, B:115:0x04a9, B:116:0x0508, B:118:0x050c, B:122:0x04bb, B:126:0x04fd, B:130:0x04f8, B:132:0x038e, B:134:0x03a5, B:135:0x03ab, B:160:0x0463, B:162:0x046f, B:165:0x0127, B:168:0x0133, B:170:0x012c, B:172:0x014a, B:174:0x0151, B:176:0x0158, B:178:0x015e, B:180:0x0166, B:190:0x00e8, B:125:0x04bf), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x050c A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0017, B:6:0x002e, B:11:0x0036, B:13:0x003c, B:15:0x0040, B:16:0x004e, B:19:0x005b, B:21:0x00a0, B:24:0x00ba, B:26:0x00d8, B:29:0x00e2, B:31:0x0101, B:34:0x011b, B:59:0x0310, B:66:0x0314, B:68:0x0325, B:70:0x032b, B:71:0x032f, B:73:0x0335, B:76:0x0347, B:78:0x035a, B:79:0x0364, B:86:0x03d3, B:88:0x03e1, B:90:0x03f1, B:93:0x03fd, B:97:0x0406, B:100:0x040d, B:102:0x0413, B:103:0x0443, B:104:0x0473, B:106:0x0477, B:107:0x047a, B:109:0x0483, B:112:0x048a, B:114:0x0490, B:115:0x04a9, B:116:0x0508, B:118:0x050c, B:122:0x04bb, B:126:0x04fd, B:130:0x04f8, B:132:0x038e, B:134:0x03a5, B:135:0x03ab, B:160:0x0463, B:162:0x046f, B:165:0x0127, B:168:0x0133, B:170:0x012c, B:172:0x014a, B:174:0x0151, B:176:0x0158, B:178:0x015e, B:180:0x0166, B:190:0x00e8, B:125:0x04bf), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04bb A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0017, B:6:0x002e, B:11:0x0036, B:13:0x003c, B:15:0x0040, B:16:0x004e, B:19:0x005b, B:21:0x00a0, B:24:0x00ba, B:26:0x00d8, B:29:0x00e2, B:31:0x0101, B:34:0x011b, B:59:0x0310, B:66:0x0314, B:68:0x0325, B:70:0x032b, B:71:0x032f, B:73:0x0335, B:76:0x0347, B:78:0x035a, B:79:0x0364, B:86:0x03d3, B:88:0x03e1, B:90:0x03f1, B:93:0x03fd, B:97:0x0406, B:100:0x040d, B:102:0x0413, B:103:0x0443, B:104:0x0473, B:106:0x0477, B:107:0x047a, B:109:0x0483, B:112:0x048a, B:114:0x0490, B:115:0x04a9, B:116:0x0508, B:118:0x050c, B:122:0x04bb, B:126:0x04fd, B:130:0x04f8, B:132:0x038e, B:134:0x03a5, B:135:0x03ab, B:160:0x0463, B:162:0x046f, B:165:0x0127, B:168:0x0133, B:170:0x012c, B:172:0x014a, B:174:0x0151, B:176:0x0158, B:178:0x015e, B:180:0x0166, B:190:0x00e8, B:125:0x04bf), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0463 A[Catch: all -> 0x004b, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0017, B:6:0x002e, B:11:0x0036, B:13:0x003c, B:15:0x0040, B:16:0x004e, B:19:0x005b, B:21:0x00a0, B:24:0x00ba, B:26:0x00d8, B:29:0x00e2, B:31:0x0101, B:34:0x011b, B:59:0x0310, B:66:0x0314, B:68:0x0325, B:70:0x032b, B:71:0x032f, B:73:0x0335, B:76:0x0347, B:78:0x035a, B:79:0x0364, B:86:0x03d3, B:88:0x03e1, B:90:0x03f1, B:93:0x03fd, B:97:0x0406, B:100:0x040d, B:102:0x0413, B:103:0x0443, B:104:0x0473, B:106:0x0477, B:107:0x047a, B:109:0x0483, B:112:0x048a, B:114:0x0490, B:115:0x04a9, B:116:0x0508, B:118:0x050c, B:122:0x04bb, B:126:0x04fd, B:130:0x04f8, B:132:0x038e, B:134:0x03a5, B:135:0x03ab, B:160:0x0463, B:162:0x046f, B:165:0x0127, B:168:0x0133, B:170:0x012c, B:172:0x014a, B:174:0x0151, B:176:0x0158, B:178:0x015e, B:180:0x0166, B:190:0x00e8, B:125:0x04bf), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ce A[Catch: all -> 0x01b4, TryCatch #0 {all -> 0x01b4, blocks: (B:37:0x01ce, B:38:0x01d4, B:40:0x01ea, B:42:0x01fa, B:43:0x024b, B:45:0x0265, B:47:0x027f, B:51:0x0288, B:54:0x028f, B:56:0x0295, B:57:0x02d7, B:137:0x01ff, B:139:0x0205, B:140:0x0209, B:142:0x020f, B:144:0x021b, B:146:0x0226, B:148:0x022c, B:149:0x0236, B:152:0x0240, B:183:0x0174, B:185:0x01a9, B:186:0x01c3, B:187:0x01b9), top: B:182:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ea A[Catch: all -> 0x01b4, TryCatch #0 {all -> 0x01b4, blocks: (B:37:0x01ce, B:38:0x01d4, B:40:0x01ea, B:42:0x01fa, B:43:0x024b, B:45:0x0265, B:47:0x027f, B:51:0x0288, B:54:0x028f, B:56:0x0295, B:57:0x02d7, B:137:0x01ff, B:139:0x0205, B:140:0x0209, B:142:0x020f, B:144:0x021b, B:146:0x0226, B:148:0x022c, B:149:0x0236, B:152:0x0240, B:183:0x0174, B:185:0x01a9, B:186:0x01c3, B:187:0x01b9), top: B:182:0x0174 }] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.cloud.tmc.miniapp.prepare.steps.OooO00o, com.cloud.tmc.miniapp.prepare.steps.subpackage.OooO0OO] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.cloud.tmc.miniapp.prepare.controller.PrepareController, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.cloud.tmc.miniapp.prepare.controller.PrepareController, java.lang.Object] */
    @Override // com.cloud.tmc.miniapp.prepare.steps.structure.OooO0O0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void OooO0OO(com.cloud.tmc.miniapp.prepare.controller.PrepareController r23, final com.cloud.tmc.integration.model.PrepareContext r24, final com.cloud.tmc.miniapp.prepare.steps.o000oOoO r25) {
        /*
            Method dump skipped, instructions count: 1313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prepare.steps.subpackage.OooO0OO.OooO0OO(com.cloud.tmc.miniapp.prepare.controller.PrepareController, com.cloud.tmc.integration.model.PrepareContext, com.cloud.tmc.miniapp.prepare.steps.o000oOoO):void");
    }
}
