package com.transsion.ninegridview.helper;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.ninegridview.helper.FileHelper", f = "FileHelper.kt", l = {102}, m = "saveToAlbum")
/* loaded from: classes6.dex */
public final class FileHelper$saveToAlbum$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileHelper$saveToAlbum$1(FileHelper fileHelper, Continuation<? super FileHelper$saveToAlbum$1> continuation) {
        super(continuation);
        this.this$0 = fileHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object u11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        u11 = this.this$0.u(null, null, null, null, false, this);
        return u11;
    }
}
