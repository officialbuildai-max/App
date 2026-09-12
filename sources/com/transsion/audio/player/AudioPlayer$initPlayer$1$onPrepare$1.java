package com.transsion.audio.player;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.player.AudioPlayer$initPlayer$1$onPrepare$1", f = "AudioPlayer.kt", l = {234}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class AudioPlayer$initPlayer$1$onPrepare$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudioPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPlayer$initPlayer$1$onPrepare$1(AudioPlayer audioPlayer, Continuation<? super AudioPlayer$initPlayer$1$onPrepare$1> continuation) {
        super(2, continuation);
        this.this$0 = audioPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioPlayer$initPlayer$1$onPrepare$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AudioPlayer$initPlayer$1$onPrepare$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.transsion.player.orplayer.g v11;
        Long readProcess;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (this.this$0.t() != null) {
                AppDatabase.Companion companion = AppDatabase.INSTANCE;
                Application a11 = Utils.a();
                Intrinsics.g(a11, "getApp(...)");
                jj.a o12 = companion.b(a11).o1();
                AudioBean t11 = this.this$0.t();
                Intrinsics.e(t11);
                String audioUrl = t11.getAudioUrl();
                this.label = 1;
                obj = o12.c(audioUrl, this);
                if (obj == f11) {
                    return f11;
                }
            }
            return Unit.f67184a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        AudioBean audioBean = (AudioBean) obj;
        long longValue = (audioBean == null || (readProcess = audioBean.getReadProcess()) == null) ? 0L : readProcess.longValue();
        if ((audioBean == null || audioBean.getStatus() != 6) && longValue > 0 && (v11 = this.this$0.v()) != null) {
            v11.seekTo(longValue);
        }
        return Unit.f67184a;
    }
}
