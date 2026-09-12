package com.transsion.edcation;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.edcation.CourseManager", f = "CourseManager.kt", l = {240, 241}, m = "updateCourse")
/* loaded from: classes5.dex */
public final class CourseManager$updateCourse$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CourseManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseManager$updateCourse$1(CourseManager courseManager, Continuation<? super CourseManager$updateCourse$1> continuation) {
        super(continuation);
        this.this$0 = courseManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object x10;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        x10 = this.this$0.x(null, this);
        return x10;
    }
}
