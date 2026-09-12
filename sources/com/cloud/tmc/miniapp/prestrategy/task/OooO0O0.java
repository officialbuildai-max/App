package com.cloud.tmc.miniapp.prestrategy.task;

import android.app.Application;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.miniutils.util.EncryptUtils;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OooO0O0 {
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
            TmcLogger.d("Prefetch:H5Task", "request success=" + z10);
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

    public OooO0O0(PrefetchConfigModel data) {
        Intrinsics.h(data, "data");
        this.OooO00o = data;
    }

    public final void OooO00o() {
        String appId;
        ArrayList<String> h5Url;
        try {
            TmcLogger.d("Prefetch:H5Task", "request start appId=" + this.OooO00o.getAppId() + ".");
            long currentTimeMillis = System.currentTimeMillis();
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null || (appId = this.OooO00o.getAppId()) == null || (h5Url = this.OooO00o.getH5Url()) == null) {
                return;
            }
            for (String str : h5Url) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                String encryptMD5ToString = EncryptUtils.encryptMD5ToString(str);
                long j11 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(application$com_cloud_tmc_miniapp_sdk, appId, encryptMD5ToString + "_time");
                if (j11 > 0 && this.OooO00o.getExecuteTime() == 0) {
                    TmcLogger.e("Prefetch:H5Task", "No need to make repeated requests during the validity period");
                    return;
                }
                if (currentTimeMillis - j11 < this.OooO00o.getExecuteTime() * 1000) {
                    TmcLogger.e("Prefetch:H5Task", "No need to make repeated requests during the validity period");
                    return;
                } else {
                    ((PreHtmStrategyProxy) TmcProxy.get(PreHtmStrategyProxy.class)).requestHtml(application$com_cloud_tmc_miniapp_sdk, str, new OooO00o(countDownLatch, application$com_cloud_tmc_miniapp_sdk, appId, encryptMD5ToString));
                    countDownLatch.await(60L, TimeUnit.SECONDS);
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e("Prefetch:H5Task", th2);
        }
    }
}
