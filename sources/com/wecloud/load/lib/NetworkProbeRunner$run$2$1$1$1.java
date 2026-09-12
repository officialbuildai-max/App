package com.wecloud.load.lib;

import com.wecloud.load.lib.NetworkProbeRunner;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "Lcom/wecloud/load/lib/n;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Lcom/wecloud/load/lib/n;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.wecloud.load.lib.NetworkProbeRunner$run$2$1$1$1", f = "NetworkProbeRunner.kt", l = {278, 86}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
final class NetworkProbeRunner$run$2$1$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super n>, Object> {
    final /* synthetic */ NetworkProbeRunner.Link $link;
    final /* synthetic */ kotlinx.coroutines.sync.h $semaphore;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkProbeRunner$run$2$1$1$1(kotlinx.coroutines.sync.h hVar, NetworkProbeRunner.Link link, Continuation<? super NetworkProbeRunner$run$2$1$1$1> continuation) {
        super(2, continuation);
        this.$semaphore = hVar;
        this.$link = link;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetworkProbeRunner$run$2$1$1$1(this.$semaphore, this.$link, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super n> continuation) {
        return ((NetworkProbeRunner$run$2$1$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlinx.coroutines.sync.h hVar;
        NetworkProbeRunner.Link link;
        kotlinx.coroutines.sync.h hVar2;
        Throwable th2;
        Object g11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                hVar = this.$semaphore;
                link = this.$link;
                this.L$0 = hVar;
                this.L$1 = link;
                this.label = 1;
                if (hVar.c(this) == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    hVar2 = (kotlinx.coroutines.sync.h) this.L$0;
                    try {
                        ResultKt.b(obj);
                        n nVar = (n) obj;
                        hVar2.release();
                        return nVar;
                    } catch (Throwable th3) {
                        th2 = th3;
                        hVar2.release();
                        throw th2;
                    }
                }
                link = (NetworkProbeRunner.Link) this.L$1;
                kotlinx.coroutines.sync.h hVar3 = (kotlinx.coroutines.sync.h) this.L$0;
                ResultKt.b(obj);
                hVar = hVar3;
            }
            NetworkProbeRunner networkProbeRunner = NetworkProbeRunner.f60935a;
            this.L$0 = hVar;
            this.L$1 = null;
            this.label = 2;
            g11 = networkProbeRunner.g(link, this);
            if (g11 == f11) {
                return f11;
            }
            hVar2 = hVar;
            obj = g11;
            n nVar2 = (n) obj;
            hVar2.release();
            return nVar2;
        } catch (Throwable th4) {
            hVar2 = hVar;
            th2 = th4;
            hVar2.release();
            throw th2;
        }
    }
}
