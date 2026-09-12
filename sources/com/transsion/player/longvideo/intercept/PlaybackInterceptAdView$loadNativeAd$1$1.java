package com.transsion.player.longvideo.intercept;

import com.transsion.baselib.db.video.PlaybackRecordDao;
import com.transsion.baselib.db.video.PlaybackRecordTable;
import com.transsion.moviedetailapi.bean.Subject;
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
@DebugMetadata(c = "com.transsion.player.longvideo.intercept.PlaybackInterceptAdView$loadNativeAd$1$1", f = "PlaybackInterceptAdView.kt", l = {260}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class PlaybackInterceptAdView$loadNativeAd$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $callback;
    final /* synthetic */ go.a $longVdPlayerBean;
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ PlaybackInterceptAdView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaybackInterceptAdView$loadNativeAd$1$1(PlaybackInterceptAdView playbackInterceptAdView, go.a aVar, String str, d dVar, Continuation<? super PlaybackInterceptAdView$loadNativeAd$1$1> continuation) {
        super(2, continuation);
        this.this$0 = playbackInterceptAdView;
        this.$longVdPlayerBean = aVar;
        this.$sceneId = str;
        this.$callback = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlaybackInterceptAdView$loadNativeAd$1$1(this.this$0, this.$longVdPlayerBean, this.$sceneId, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PlaybackInterceptAdView$loadNativeAd$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PlaybackRecordDao playbackRecordDao;
        String str;
        String classTag;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            playbackRecordDao = this.this$0.getPlaybackRecordDao();
            Subject m11 = this.$longVdPlayerBean.m();
            if (m11 == null || (str = m11.getSubjectId()) == null) {
                str = "";
            }
            int l11 = this.$longVdPlayerBean.l();
            int e11 = this.$longVdPlayerBean.e();
            this.label = 1;
            obj = playbackRecordDao.a(str, l11, e11, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        PlaybackRecordTable playbackRecordTable = (PlaybackRecordTable) obj;
        a.C0856a c0856a = lg.a.f68962a;
        classTag = this.this$0.getClassTag();
        a.C0856a.f(c0856a, "premium_p", classTag + " --> loadNativeAd() --> playbackRecord = " + playbackRecordTable, false, 4, null);
        this.this$0.k(this.$sceneId, playbackRecordTable, this.$callback);
        return Unit.f67184a;
    }
}
