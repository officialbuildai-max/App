package com.cloud.tmc.integration.utils.share;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.cloud.tmc.integration.utils.share.ShareStrategy", f = "ShareStrategy.kt", l = {141}, m = "getFileUriByCursor")
/* loaded from: classes3.dex */
public final class ShareStrategy$getFileUriByCursor$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShareStrategy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareStrategy$getFileUriByCursor$1(ShareStrategy shareStrategy, Continuation<? super ShareStrategy$getFileUriByCursor$1> continuation) {
        super(continuation);
        this.this$0 = shareStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fileUriByCursor;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fileUriByCursor = this.this$0.getFileUriByCursor(null, null, this);
        return fileUriByCursor;
    }
}
