package com.transsion.mbwidget;

import com.transsion.mbwidget.SportSchedulePreviewWidgetProvider;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion", f = "SportSchedulePreviewWidgetProvider.kt", l = {431}, m = "loadTeamLogo")
/* loaded from: classes5.dex */
public final class SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SportSchedulePreviewWidgetProvider.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1(SportSchedulePreviewWidgetProvider.Companion companion, Continuation<? super SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m11 = this.this$0.m(null, 0, null, 0, this);
        return m11;
    }
}
