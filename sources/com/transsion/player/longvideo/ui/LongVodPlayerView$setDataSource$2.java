package com.transsion.player.longvideo.ui;

import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.player.longvideo.helper.LongVodSubtitleHelper;
import com.transsion.player.longvideo.intercept.PlaybackInterceptionManager;
import com.transsion.player.mediasession.MediaItem;
import fo.a;
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
@DebugMetadata(c = "com.transsion.player.longvideo.ui.LongVodPlayerView$setDataSource$2", f = "LongVodPlayerView.kt", l = {2692}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class LongVodPlayerView$setDataSource$2 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ go.a $bean;
    int label;
    final /* synthetic */ LongVodPlayerView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodPlayerView$setDataSource$2(LongVodPlayerView longVodPlayerView, go.a aVar, Continuation<? super LongVodPlayerView$setDataSource$2> continuation) {
        super(2, continuation);
        this.this$0 = longVodPlayerView;
        this.$bean = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerView$setDataSource$2(this.this$0, this.$bean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LongVodPlayerView$setDataSource$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.transsion.player.longvideo.helper.w wVar;
        boolean z10;
        boolean z11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            wVar = this.this$0.resolutionHelper;
            go.a aVar = this.$bean;
            this.label = 1;
            obj = wVar.a(aVar, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        go.c cVar = (go.c) obj;
        if (cVar != null) {
            LongVodPlayerView longVodPlayerView = this.this$0;
            go.a aVar2 = this.$bean;
            z10 = longVodPlayerView.isNewPlayer;
            longVodPlayerView.w2(z10);
            LongVodSubtitleHelper longVodSubtitleHelper = longVodPlayerView.subtitleHelper;
            if (longVodSubtitleHelper != null) {
                longVodSubtitleHelper.T(aVar2, cVar);
            }
            if (aVar2.w()) {
                longVodPlayerView.V0(aVar2, cVar);
            }
            longVodPlayerView.curPlayStream = cVar;
            PlaybackInterceptionManager playbackInterceptionManager = longVodPlayerView.playbackInterceptionManager;
            if (playbackInterceptionManager != null) {
                playbackInterceptionManager.S(cVar.e(), "mp4");
            }
            a.b bVar = longVodPlayerView.playerCallback;
            if (bVar != null) {
                bVar.h(cVar.e());
            }
            longVodPlayerView.P1(aVar2, cVar);
            z11 = longVodPlayerView.isNewPlayer;
            if (z11) {
                longVodPlayerView.setPlayerDataSourceAdPrepare(cVar);
            } else {
                longVodPlayerView.setPauseViewStatus(true);
                longVodPlayerView.playerControl.play();
                LongVodSubtitleHelper longVodSubtitleHelper2 = longVodPlayerView.subtitleHelper;
                if (longVodSubtitleHelper2 != null) {
                    longVodSubtitleHelper2.e0(true);
                }
            }
            a.C0856a.v(lg.a.f68962a, LongVodPlayerView.TAG, "setDataSource, reset isNewPlayer", false, 4, null);
            longVodPlayerView.isNewPlayer = true;
        }
        MediaItem q11 = MusicFloatManager.f43508h.b().q();
        if (q11 != null) {
            q11.setPageName(this.this$0.pageName);
        }
        return Unit.f67184a;
    }
}
