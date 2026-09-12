package com.transsnet.downloader.util;

import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsnet.downloader.util.UGCHistoricalPlayRecordOpenHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.util.UGCHistoricalPlayRecordOpenHelper$gotoUGCVideoDetail$2", f = "UGCHistoricalPlayRecordOpenHelper.kt", l = {74}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class UGCHistoricalPlayRecordOpenHelper$gotoUGCVideoDetail$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $data;
    final /* synthetic */ String $logTag;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCHistoricalPlayRecordOpenHelper$gotoUGCVideoDetail$2(Object obj, String str, Continuation<? super UGCHistoricalPlayRecordOpenHelper$gotoUGCVideoDetail$2> continuation) {
        super(2, continuation);
        this.$data = obj;
        this.$logTag = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCHistoricalPlayRecordOpenHelper$gotoUGCVideoDetail$2(this.$data, this.$logTag, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCHistoricalPlayRecordOpenHelper$gotoUGCVideoDetail$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UGCHistoricalPlayRecordOpenHelper.a aVar;
        Object f11;
        Object f12 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Object obj2 = this.$data;
            if (obj2 instanceof VideoDetailPlayBean) {
                aVar = new UGCHistoricalPlayRecordOpenHelper.a(((VideoDetailPlayBean) obj2).getSubjectId(), ((VideoDetailPlayBean) this.$data).getSubjectType(), ((VideoDetailPlayBean) this.$data).getId(), null, null, null, ((VideoDetailPlayBean) this.$data).getOps(), null);
            } else {
                if (!(obj2 instanceof UGCVideoDetailPlayBean)) {
                    return Unit.f67184a;
                }
                aVar = new UGCHistoricalPlayRecordOpenHelper.a(null, null, ((UGCVideoDetailPlayBean) this.$data).getUgcVideoId(), ((UGCVideoDetailPlayBean) this.$data).getUgcVideoId(), StringsKt.W(((UGCVideoDetailPlayBean) obj2).getCollectionId(), UGCVideoDetailPlayBean.SINGLE_VIDEO_PREFIX, false, 2, null) ? null : ((UGCVideoDetailPlayBean) this.$data).getCollectionId(), ((UGCVideoDetailPlayBean) this.$data).getType(), ((UGCVideoDetailPlayBean) this.$data).getOps(), ((UGCVideoDetailPlayBean) this.$data).getVideoStyle());
            }
            String a11 = aVar.a();
            Integer b11 = aVar.b();
            String c11 = aVar.c();
            String d11 = aVar.d();
            String e11 = aVar.e();
            String f13 = aVar.f();
            String g11 = aVar.g();
            String h11 = aVar.h();
            UGCHistoricalPlayRecordOpenHelper uGCHistoricalPlayRecordOpenHelper = UGCHistoricalPlayRecordOpenHelper.f60029a;
            String str = this.$logTag;
            this.label = 1;
            f11 = uGCHistoricalPlayRecordOpenHelper.f(a11, b11, c11, d11, e11, f13, g11, h11, str, this);
            if (f11 == f12) {
                return f12;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
