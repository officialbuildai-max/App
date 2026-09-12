package com.hisavana.mediation.bridge.holder;

import com.hisavana.mediation.bridge.listener.BridgeListener;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JO\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/hisavana/mediation/bridge/holder/JsAdHolderHandler;", "", "Lcom/hisavana/mediation/bridge/listener/BridgeListener;", "bridgeListener", "<init>", "(Lcom/hisavana/mediation/bridge/listener/BridgeListener;)V", "", "callbackId", "codeSeatId", "", "adType", "extInfo", "adCount", "bannerWidth", "Lcom/hisavana/mediation/bridge/holder/JsAdHolder;", "createAdHolder", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;II)Lcom/hisavana/mediation/bridge/holder/JsAdHolder;", "", "release", "()V", "a", "Lcom/hisavana/mediation/bridge/listener/BridgeListener;", "getBridgeListener", "()Lcom/hisavana/mediation/bridge/listener/BridgeListener;", "kotlin.jvm.PlatformType", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "TAG", "Lcom/hisavana/mediation/bridge/holder/JsBannerAdHolder;", "c", "Lcom/hisavana/mediation/bridge/holder/JsBannerAdHolder;", "jsBannerAdHolder", "mediation_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes4.dex */
public final class JsAdHolderHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final BridgeListener bridgeListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public JsBannerAdHolder jsBannerAdHolder;

    public JsAdHolderHandler(BridgeListener bridgeListener) {
        Intrinsics.h(bridgeListener, "bridgeListener");
        this.bridgeListener = bridgeListener;
        this.TAG = JsAdHolderHandler.class.getSimpleName();
    }

    public static /* synthetic */ JsAdHolder createAdHolder$default(JsAdHolderHandler jsAdHolderHandler, String str, String str2, int i11, String str3, int i12, int i13, int i14, Object obj) {
        if ((i14 & 8) != 0) {
            str3 = null;
        }
        String str4 = str3;
        if ((i14 & 16) != 0) {
            i12 = 1;
        }
        int i15 = i12;
        if ((i14 & 32) != 0) {
            i13 = 0;
        }
        return jsAdHolderHandler.createAdHolder(str, str2, i11, str4, i15, i13);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0033, code lost:
    
        if (r3 == null) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.hisavana.mediation.bridge.holder.JsAdHolder<? extends java.lang.Object> createAdHolder(java.lang.String r12, java.lang.String r13, int r14, java.lang.String r15, int r16, int r17) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisavana.mediation.bridge.holder.JsAdHolderHandler.createAdHolder(java.lang.String, java.lang.String, int, java.lang.String, int, int):com.hisavana.mediation.bridge.holder.JsAdHolder");
    }

    public final BridgeListener getBridgeListener() {
        return this.bridgeListener;
    }

    public final void release() {
        JsBannerAdHolder jsBannerAdHolder = this.jsBannerAdHolder;
        if (jsBannerAdHolder != null) {
            jsBannerAdHolder.release();
        }
    }
}
