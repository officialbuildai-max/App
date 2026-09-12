package com.transsion.ninegridview.helper;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.ninegridview.helper.FileHelper", f = "FileHelper.kt", l = {69}, m = "copyToAlbum")
/* loaded from: classes6.dex */
public final class FileHelper$copyToAlbum$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileHelper$copyToAlbum$1(FileHelper fileHelper, Continuation<? super FileHelper$copyToAlbum$1> continuation) {
        super(continuation);
        this.this$0 = fileHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object e11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        e11 = this.this$0.e(null, null, null, null, false, this);
        return e11;
    }
}
