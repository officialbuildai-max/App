package com.transsion.baseui.music;

import android.text.TextUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.baseui.music.MusicReport$saveLocal$1", f = "MusicReport.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class MusicReport$saveLocal$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ n $musicPlayDurationBean;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicReport$saveLocal$1(n nVar, Continuation<? super MusicReport$saveLocal$1> continuation) {
        super(2, continuation);
        this.$musicPlayDurationBean = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicReport$saveLocal$1(this.$musicPlayDurationBean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MusicReport$saveLocal$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        List<n> b11;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        n nVar = this.$musicPlayDurationBean;
        try {
            Result.Companion companion = Result.INSTANCE;
            b11 = MusicReport.f43527a.b();
            for (n nVar2 : b11) {
                if (TextUtils.equals(nVar2.d(), nVar.d())) {
                    nVar2.m(nVar2.c() + nVar.c());
                    nVar2.l(nVar2.b() + nVar.b());
                    nVar2.o(nVar2.f() + nVar.f());
                }
            }
            if (b11.isEmpty()) {
                b11.add(nVar);
            }
            com.transsion.baselib.report.launch.b.f43424a.b().putString("music_play_duration", com.blankj.utilcode.util.o.j(b11));
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            com.transsion.player.mediasession.i.f48462a.b("MusicReport --> saveLocal() --> it = " + m1188exceptionOrNullimpl);
        }
        return Unit.f67184a;
    }
}
