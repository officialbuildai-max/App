package androidx.room;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "androidx.room.RoomTrackingLiveData", f = "RoomTrackingLiveData.android.kt", l = {TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW}, m = ToolBar.REFRESH)
/* loaded from: classes2.dex */
public final class RoomTrackingLiveData$refresh$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomTrackingLiveData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomTrackingLiveData$refresh$1(RoomTrackingLiveData roomTrackingLiveData, Continuation<? super RoomTrackingLiveData$refresh$1> continuation) {
        super(continuation);
        this.this$0 = roomTrackingLiveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object x10;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        x10 = this.this$0.x(this);
        return x10;
    }
}
