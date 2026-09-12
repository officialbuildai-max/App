package com.transsnet.downloader.core;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsnet.downloader.core.DownloadResponseImpl", f = "DownloadResponseImpl.kt", l = {242, 245, 242, 245, 242, 245}, m = "tryUpdateVideoInfo")
/* loaded from: classes7.dex */
public final class DownloadResponseImpl$tryUpdateVideoInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadResponseImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadResponseImpl$tryUpdateVideoInfo$1(DownloadResponseImpl downloadResponseImpl, Continuation<? super DownloadResponseImpl$tryUpdateVideoInfo$1> continuation) {
        super(continuation);
        this.this$0 = downloadResponseImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m11 = this.this$0.m(null, this);
        return m11;
    }
}
