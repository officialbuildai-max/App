package com.transsnet.downloader.ugc.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$string;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.ugc.fragment.UGCTransferReceivedFragment$deleteItem$1", f = "UGCTransferReceivedFragment.kt", l = {151, 152, 153}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class UGCTransferReceivedFragment$deleteItem$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $entity;
    int label;
    final /* synthetic */ UGCTransferReceivedFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.ugc.fragment.UGCTransferReceivedFragment$deleteItem$1$1", f = "UGCTransferReceivedFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.ugc.fragment.UGCTransferReceivedFragment$deleteItem$1$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            uh.b.f76876a.d(R$string.download_delete_success);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCTransferReceivedFragment$deleteItem$1(DownloadBean downloadBean, UGCTransferReceivedFragment uGCTransferReceivedFragment, Continuation<? super UGCTransferReceivedFragment$deleteItem$1> continuation) {
        super(2, continuation);
        this.$entity = downloadBean;
        this.this$0 = uGCTransferReceivedFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCTransferReceivedFragment$deleteItem$1(this.$entity, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCTransferReceivedFragment$deleteItem$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r6)
            goto L57
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            kotlin.ResultKt.b(r6)
            goto L44
        L21:
            kotlin.ResultKt.b(r6)
            goto L39
        L25:
            kotlin.ResultKt.b(r6)
            com.transsnet.downloader.manager.DownloadEsHelper$a r6 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r6 = r6.a()
            com.transsion.baselib.db.download.DownloadBean r1 = r5.$entity
            r5.label = r4
            java.lang.Object r6 = r6.m(r1, r5)
            if (r6 != r0) goto L39
            return r0
        L39:
            r5.label = r3
            r3 = 300(0x12c, double:1.48E-321)
            java.lang.Object r6 = kotlinx.coroutines.u0.a(r3, r5)
            if (r6 != r0) goto L44
            return r0
        L44:
            kotlinx.coroutines.a2 r6 = kotlinx.coroutines.y0.c()
            com.transsnet.downloader.ugc.fragment.UGCTransferReceivedFragment$deleteItem$1$1 r1 = new com.transsnet.downloader.ugc.fragment.UGCTransferReceivedFragment$deleteItem$1$1
            r3 = 0
            r1.<init>(r3)
            r5.label = r2
            java.lang.Object r6 = kotlinx.coroutines.i.g(r6, r1, r5)
            if (r6 != r0) goto L57
            return r0
        L57:
            com.transsnet.downloader.ugc.fragment.UGCTransferReceivedFragment r6 = r5.this$0
            com.transsnet.downloader.ugc.fragment.UGCTransferReceivedFragment.o1(r6)
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.ugc.fragment.UGCTransferReceivedFragment$deleteItem$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
