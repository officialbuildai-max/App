package com.transsion.baseui.music;

import com.transsion.player.mediasession.MediaItem;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.baseui.music.MusicFloatManager$onPlayerRelease$1", f = "MusicFloatManager.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
final class MusicFloatManager$onPlayerRelease$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ao.e $mediaSource;
    int label;
    final /* synthetic */ MusicFloatManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicFloatManager$onPlayerRelease$1(MusicFloatManager musicFloatManager, ao.e eVar, Continuation<? super MusicFloatManager$onPlayerRelease$1> continuation) {
        super(2, continuation);
        this.this$0 = musicFloatManager;
        this.$mediaSource = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicFloatManager$onPlayerRelease$1(this.this$0, this.$mediaSource, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MusicFloatManager$onPlayerRelease$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String p11;
        com.transsion.player.orplayer.g gVar;
        CopyOnWriteArrayList copyOnWriteArrayList;
        MediaItem i11;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        com.transsion.player.mediasession.i iVar = com.transsion.player.mediasession.i.f48462a;
        p11 = this.this$0.p();
        ao.e eVar = this.$mediaSource;
        iVar.a(p11 + " --> onPlayerRelease() --> subjectId = " + ((eVar == null || (i11 = eVar.i()) == null) ? null : i11.getSubjectId()));
        gVar = this.this$0.f43515e;
        if (gVar != null) {
            gVar.removePlayerListener(this.this$0);
        }
        this.this$0.f43515e = null;
        copyOnWriteArrayList = this.this$0.f43514d;
        ao.e eVar2 = this.$mediaSource;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onPlayerRelease(eVar2);
        }
        this.this$0.B(null);
        this.this$0.C(null);
        MusicReport.f43527a.c();
        return Unit.f67184a;
    }
}
