package com.transsnet.downloader.util;

import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsnet.downloader.util.DownloadUtil", f = "DownloadUtil.kt", l = {DescriptorProtos$Edition.EDITION_LEGACY_VALUE}, m = "transferFileSuccessNext")
/* loaded from: classes7.dex */
public final class DownloadUtil$transferFileSuccessNext$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadUtil$transferFileSuccessNext$1(DownloadUtil downloadUtil, Continuation<? super DownloadUtil$transferFileSuccessNext$1> continuation) {
        super(continuation);
        this.this$0 = downloadUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object Q;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Q = this.this$0.Q(null, null, null, 0, null, 0, null, false, this);
        return Q;
    }
}
