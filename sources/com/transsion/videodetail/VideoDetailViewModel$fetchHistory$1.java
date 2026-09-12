package com.transsion.videodetail;

import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.videodetail.util.StreamFloatManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchHistory$1", f = "VideoDetailViewModel.kt", l = {127}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class VideoDetailViewModel$fetchHistory$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ VideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDetailViewModel$fetchHistory$1(VideoDetailViewModel videoDetailViewModel, String str, Continuation<? super VideoDetailViewModel$fetchHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = videoDetailViewModel;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDetailViewModel$fetchHistory$1(this.this$0, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((VideoDetailViewModel$fetchHistory$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        VideoDetailPlayDao B;
        androidx.view.b0 b0Var;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            B = this.this$0.B();
            String str = this.$subjectId;
            this.label = 1;
            obj = B.c(str, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        VideoDetailPlayBean videoDetailPlayBean = (VideoDetailPlayBean) obj;
        if (videoDetailPlayBean != null) {
            String str2 = this.$subjectId + "+" + videoDetailPlayBean.getSe() + "+" + videoDetailPlayBean.getEp();
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "VideoDetail", "fetchHistory--key:" + str2, false, 4, null);
            Long g11 = StreamFloatManager.f57996b.g(str2);
            if (g11 != null) {
                long longValue = g11.longValue();
                a.C0856a.r(c0856a, "VideoDetail", new String[]{"update--key:" + str2 + ", value:" + longValue + ",last:" + videoDetailPlayBean.getProgress()}, false, 4, null);
                if (longValue > 0 && longValue != videoDetailPlayBean.getProgress()) {
                    videoDetailPlayBean.setProgress(longValue);
                }
            }
        }
        a.C0856a.r(lg.a.f68962a, "VideoDetail", new String[]{"fetchHistory  subjectId:" + this.$subjectId + ",history:" + videoDetailPlayBean}, false, 4, null);
        b0Var = this.this$0.f57770h;
        b0Var.q(videoDetailPlayBean);
        return Unit.f67184a;
    }
}
