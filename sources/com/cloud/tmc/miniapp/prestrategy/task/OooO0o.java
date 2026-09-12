package com.cloud.tmc.miniapp.prestrategy.task;

import android.app.Application;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class OooO0o {
    public final PrefetchConfigModel OooO00o;

    /* loaded from: classes3.dex */
    public static final class OooO00o extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ CountDownLatch OooO00o;
        public final /* synthetic */ Application OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ String OooO0Oo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(CountDownLatch countDownLatch, Application application, String str, String str2) {
            super(1);
            this.OooO00o = countDownLatch;
            this.OooO0O0 = application;
            this.OooO0OO = str;
            this.OooO0Oo = str2;
        }

        public final void OooO00o(boolean z10) {
            this.OooO00o.countDown();
            if (z10) {
                ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(this.OooO0O0, this.OooO0OO, this.OooO0Oo + "_time", System.currentTimeMillis());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            OooO00o(((Boolean) obj).booleanValue());
            return Unit.f67184a;
        }
    }

    public OooO0o(PrefetchConfigModel data) {
        Intrinsics.h(data, "data");
        this.OooO00o = data;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:3:0x0002, B:7:0x002e, B:10:0x0037, B:13:0x004c, B:15:0x0052, B:18:0x005e, B:20:0x0064, B:22:0x0079, B:24:0x00aa, B:26:0x00c3, B:28:0x00b4, B:30:0x00cb), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079 A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:3:0x0002, B:7:0x002e, B:10:0x0037, B:13:0x004c, B:15:0x0052, B:18:0x005e, B:20:0x0064, B:22:0x0079, B:24:0x00aa, B:26:0x00c3, B:28:0x00b4, B:30:0x00cb), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OooO00o() {
        /*
            r13 = this;
            java.lang.String r0 = "Prefetch:ShellH5Task"
            com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel r1 = r13.OooO00o     // Catch: java.lang.Throwable -> L59
            java.lang.String r1 = r1.getAppId()     // Catch: java.lang.Throwable -> L59
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r2.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r3 = "request start appId="
            r2.append(r3)     // Catch: java.lang.Throwable -> L59
            r2.append(r1)     // Catch: java.lang.Throwable -> L59
            java.lang.String r1 = "."
            r2.append(r1)     // Catch: java.lang.Throwable -> L59
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L59
            com.cloud.tmc.kernel.log.TmcLogger.d(r0, r1)     // Catch: java.lang.Throwable -> L59
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L59
            com.cloud.tmc.miniapp.ByteAppManager r3 = com.cloud.tmc.miniapp.ByteAppManager.INSTANCE     // Catch: java.lang.Throwable -> L59
            android.app.Application r3 = r3.getApplication$com_cloud_tmc_miniapp_sdk()     // Catch: java.lang.Throwable -> L59
            if (r3 != 0) goto L2e
            return
        L2e:
            com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel r4 = r13.OooO00o     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = r4.getAppId()     // Catch: java.lang.Throwable -> L59
            if (r4 != 0) goto L37
            return
        L37:
            java.lang.Class<com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager> r5 = com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager.class
            java.lang.Object r5 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r5)     // Catch: java.lang.Throwable -> L59
            com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager r5 = (com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager) r5     // Catch: java.lang.Throwable -> L59
            com.cloud.tmc.integration.model.AppInfoQuery$Companion r6 = com.cloud.tmc.integration.model.AppInfoQuery.INSTANCE     // Catch: java.lang.Throwable -> L59
            com.cloud.tmc.integration.model.AppInfoQuery r6 = r6.make(r4)     // Catch: java.lang.Throwable -> L59
            com.cloud.tmc.integration.model.AppModel r5 = r5.getAppModel(r3, r6)     // Catch: java.lang.Throwable -> L59
            if (r5 != 0) goto L4c
            return
        L4c:
            com.cloud.tmc.integration.model.ExtendModel r5 = r5.getExtend()     // Catch: java.lang.Throwable -> L59
            if (r5 == 0) goto L5c
            java.lang.String r5 = r5.getH5Url()     // Catch: java.lang.Throwable -> L59
            if (r5 != 0) goto L5e
            goto L5c
        L59:
            r1 = move-exception
            goto Le9
        L5c:
            java.lang.String r5 = ""
        L5e:
            int r6 = r5.length()     // Catch: java.lang.Throwable -> L59
            if (r6 != 0) goto L79
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r1.<init>()     // Catch: java.lang.Throwable -> L59
            r1.append(r4)     // Catch: java.lang.Throwable -> L59
            java.lang.String r2 = " ->h5Url is empty ,return!"
            r1.append(r2)     // Catch: java.lang.Throwable -> L59
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L59
            com.cloud.tmc.kernel.log.TmcLogger.d(r0, r1)     // Catch: java.lang.Throwable -> L59
            return
        L79:
            com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel r6 = r13.OooO00o     // Catch: java.lang.Throwable -> L59
            android.os.Bundle r6 = r6.getBundle()     // Catch: java.lang.Throwable -> L59
            java.lang.String r5 = com.cloud.tmc.kernel.utils.KUrlUtils.generateShellUrl(r5, r6)     // Catch: java.lang.Throwable -> L59
            java.lang.String r6 = com.cloud.tmc.miniutils.util.EncryptUtils.encryptMD5ToString(r5)     // Catch: java.lang.Throwable -> L59
            java.lang.Class<com.cloud.tmc.kernel.proxy.storage.KVStorageProxy> r7 = com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class
            java.lang.Object r7 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r7)     // Catch: java.lang.Throwable -> L59
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r7 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r7     // Catch: java.lang.Throwable -> L59
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r8.<init>()     // Catch: java.lang.Throwable -> L59
            r8.append(r6)     // Catch: java.lang.Throwable -> L59
            java.lang.String r9 = "_time"
            r8.append(r9)     // Catch: java.lang.Throwable -> L59
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L59
            long r7 = r7.getLong(r3, r4, r8)     // Catch: java.lang.Throwable -> L59
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 <= 0) goto Lb4
            com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel r11 = r13.OooO00o     // Catch: java.lang.Throwable -> L59
            long r11 = r11.getExecuteTime()     // Catch: java.lang.Throwable -> L59
            int r9 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r9 == 0) goto Lc3
        Lb4:
            long r1 = r1 - r7
            com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel r7 = r13.OooO00o     // Catch: java.lang.Throwable -> L59
            long r7 = r7.getExecuteTime()     // Catch: java.lang.Throwable -> L59
            r9 = 1000(0x3e8, float:1.401E-42)
            long r9 = (long) r9     // Catch: java.lang.Throwable -> L59
            long r7 = r7 * r9
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 >= 0) goto Lcb
        Lc3:
            java.lang.String r1 = "Prefetch:H5Task"
            java.lang.String r2 = "No need to make repeated requests during the validity period"
            com.cloud.tmc.kernel.log.TmcLogger.e(r1, r2)     // Catch: java.lang.Throwable -> L59
            return
        Lcb:
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch: java.lang.Throwable -> L59
            r2 = 1
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L59
            java.lang.Class<com.cloud.tmc.integration.proxy.PreHtmStrategyProxy> r2 = com.cloud.tmc.integration.proxy.PreHtmStrategyProxy.class
            java.lang.Object r2 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r2)     // Catch: java.lang.Throwable -> L59
            com.cloud.tmc.integration.proxy.PreHtmStrategyProxy r2 = (com.cloud.tmc.integration.proxy.PreHtmStrategyProxy) r2     // Catch: java.lang.Throwable -> L59
            com.cloud.tmc.miniapp.prestrategy.task.OooO0o$OooO00o r7 = new com.cloud.tmc.miniapp.prestrategy.task.OooO0o$OooO00o     // Catch: java.lang.Throwable -> L59
            r7.<init>(r1, r3, r4, r6)     // Catch: java.lang.Throwable -> L59
            r2.requestHtml(r3, r5, r7)     // Catch: java.lang.Throwable -> L59
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L59
            r3 = 60
            r1.await(r3, r2)     // Catch: java.lang.Throwable -> L59
            goto Lec
        Le9:
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r1)
        Lec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prestrategy.task.OooO0o.OooO00o():void");
    }
}
