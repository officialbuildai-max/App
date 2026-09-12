package com.transsnet.downloader.manager;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadEsHelper", f = "DownloadEsHelper.kt", l = {640, 642, 649}, m = "checkSubtitle")
/* loaded from: classes7.dex */
public final class DownloadEsHelper$checkSubtitle$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadEsHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadEsHelper$checkSubtitle$1(DownloadEsHelper downloadEsHelper, Continuation<? super DownloadEsHelper$checkSubtitle$1> continuation) {
        super(continuation);
        this.this$0 = downloadEsHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object j11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        j11 = this.this$0.j(null, this);
        return j11;
    }
}
