package com.cloud.tmc.miniapp.ipc.broadcast;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import com.cloud.tmc.component_api_ps.MiniAppProtocolModuleLogger;
import com.cloud.tmc.component_api_ps.ipc.MiniAppProtocolHelper;
import com.cloud.tmc.component_api_ps.ipc.callbcak.IMiniAppDataSyncCallback;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooO00o extends BroadcastReceiver {
    public static final C0341OooO00o OooO00o = new C0341OooO00o();

    /* renamed from: com.cloud.tmc.miniapp.ipc.broadcast.OooO00o$OooO00o, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0341OooO00o {
    }

    public final void OooO00o(Bundle bundle) {
        try {
            int i11 = bundle.getInt("miniProcessId");
            String string = bundle.getString("miniGaid");
            if (string == null) {
                string = "";
            }
            MiniAppProtocolHelper miniAppProtocolHelper = MiniAppProtocolHelper.INSTANCE;
            miniAppProtocolHelper.updateMiniPid(i11);
            Bundle bundle2 = new Bundle();
            bundle2.putString("miniGaid", string);
            IMiniAppDataSyncCallback dataSyncCallback = miniAppProtocolHelper.getDataSyncCallback();
            if (dataSyncCallback != null) {
                dataSyncCallback.onSyncData(MiniAppProtocolHelper.SYNC_MINI_INIT_PROCESS, bundle2);
            }
        } catch (Throwable unused) {
        }
    }

    public final void OooO00o(String str, Bundle bundle) {
        try {
            MiniAppProtocolModuleLogger.d("MiniBroadcastReceiver", "MiniBroadcastReceiver -> reportDataToPs:" + str);
            bundle.getString("miniGaid");
            IMiniAppDataSyncCallback dataSyncCallback = MiniAppProtocolHelper.INSTANCE.getDataSyncCallback();
            if (dataSyncCallback != null) {
                dataSyncCallback.onSyncData(str, bundle);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x004a, code lost:
    
        if (r10 == null) goto L21;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            r9 = this;
            r0 = 0
            if (r11 == 0) goto L8
            java.lang.String r1 = r11.getPackage()
            goto L9
        L8:
            r1 = r0
        L9:
            if (r10 == 0) goto L10
            java.lang.String r2 = r10.getPackageName()
            goto L11
        L10:
            r2 = r0
        L11:
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r2)
            if (r1 != 0) goto L44
            if (r11 == 0) goto L1e
            java.lang.String r11 = r11.getPackage()
            goto L1f
        L1e:
            r11 = r0
        L1f:
            if (r10 == 0) goto L25
            java.lang.String r0 = r10.getPackageName()
        L25:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "MiniBroadcastReceiver -> onReceive:"
            r10.append(r1)
            r10.append(r11)
            java.lang.String r11 = " != "
            r10.append(r11)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "MiniBroadcastReceiver"
            com.cloud.tmc.component_api_ps.MiniAppProtocolModuleLogger.d(r11, r10)
            return
        L44:
            if (r11 == 0) goto L4c
            android.os.Bundle r10 = r11.getExtras()     // Catch: java.lang.Throwable -> L52
            if (r10 != 0) goto L57
        L4c:
            android.os.Bundle r10 = new android.os.Bundle     // Catch: java.lang.Throwable -> L52
            r10.<init>()     // Catch: java.lang.Throwable -> L52
            goto L57
        L52:
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>()
        L57:
            if (r11 == 0) goto L5d
            java.lang.String r0 = r11.getAction()
        L5d:
            java.lang.String r1 = "com.cloud.tmc.miniapp.process_id"
            boolean r2 = kotlin.jvm.internal.Intrinsics.c(r0, r1)
            if (r2 == 0) goto L6a
            r9.OooO00o(r10)
            goto Lf1
        L6a:
            java.lang.String r2 = "com.cloud.tmc.miniapp.addhome_success"
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r0, r2)
            java.lang.String r4 = "miniAddHomeSuccess"
            if (r3 == 0) goto L79
            r9.OooO00o(r4, r10)
            goto Lf1
        L79:
            java.lang.String r3 = "com.cloud.tmc.miniapp.start_time"
            boolean r5 = kotlin.jvm.internal.Intrinsics.c(r0, r3)
            java.lang.String r6 = "miniAppStartTime"
            if (r5 == 0) goto L87
            r9.OooO00o(r6, r10)
            goto Lf1
        L87:
            java.lang.String r5 = "com.cloud.tmc.miniapp.use_time"
            boolean r7 = kotlin.jvm.internal.Intrinsics.c(r0, r5)
            java.lang.String r8 = "miniAppUseTime"
            if (r7 == 0) goto L95
            r9.OooO00o(r8, r10)
            goto Lf1
        L95:
            java.lang.String r10 = "com.cloud.tmc.miniapp.report_cache"
            boolean r10 = kotlin.jvm.internal.Intrinsics.c(r0, r10)
            if (r10 == 0) goto Lf1
            java.lang.String r10 = "reportCachedata"
            java.util.ArrayList r10 = r11.getParcelableArrayListExtra(r10)     // Catch: java.lang.Throwable -> Lf1
            if (r10 == 0) goto Lf1
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> Lf1
        La9:
            boolean r11 = r10.hasNext()     // Catch: java.lang.Throwable -> Lf1
            if (r11 == 0) goto Lf1
            java.lang.Object r11 = r10.next()     // Catch: java.lang.Throwable -> Lf1
            com.cloud.tmc.integration.model.CacheReportBean r11 = (com.cloud.tmc.integration.model.CacheReportBean) r11     // Catch: java.lang.Throwable -> Lf1
            java.lang.String r0 = r11.getEvent()     // Catch: java.lang.Throwable -> Lf1
            boolean r7 = kotlin.jvm.internal.Intrinsics.c(r0, r1)     // Catch: java.lang.Throwable -> Lf1
            if (r7 == 0) goto Lc7
            android.os.Bundle r11 = r11.getData()     // Catch: java.lang.Throwable -> Lf1
            r9.OooO00o(r11)     // Catch: java.lang.Throwable -> Lf1
            goto La9
        Lc7:
            boolean r7 = kotlin.jvm.internal.Intrinsics.c(r0, r2)     // Catch: java.lang.Throwable -> Lf1
            if (r7 == 0) goto Ld5
            android.os.Bundle r11 = r11.getData()     // Catch: java.lang.Throwable -> Lf1
            r9.OooO00o(r4, r11)     // Catch: java.lang.Throwable -> Lf1
            goto La9
        Ld5:
            boolean r7 = kotlin.jvm.internal.Intrinsics.c(r0, r3)     // Catch: java.lang.Throwable -> Lf1
            if (r7 == 0) goto Le3
            android.os.Bundle r11 = r11.getData()     // Catch: java.lang.Throwable -> Lf1
            r9.OooO00o(r6, r11)     // Catch: java.lang.Throwable -> Lf1
            goto La9
        Le3:
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r5)     // Catch: java.lang.Throwable -> Lf1
            if (r0 == 0) goto La9
            android.os.Bundle r11 = r11.getData()     // Catch: java.lang.Throwable -> Lf1
            r9.OooO00o(r8, r11)     // Catch: java.lang.Throwable -> Lf1
            goto La9
        Lf1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.ipc.broadcast.OooO00o.onReceive(android.content.Context, android.content.Intent):void");
    }
}
