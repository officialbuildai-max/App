package com.transsnet.downloader.fragment;

import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.TransferReceivedListFragment$deleteItem$1", f = "TransferReceivedListFragment.kt", l = {Sdk$SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 134, 135}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class TransferReceivedListFragment$deleteItem$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ HistoricalPlayRecordMultipleEntity $entity;
    int label;
    final /* synthetic */ TransferReceivedListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.fragment.TransferReceivedListFragment$deleteItem$1$1", f = "TransferReceivedListFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.fragment.TransferReceivedListFragment$deleteItem$1$1, reason: invalid class name */
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
    public TransferReceivedListFragment$deleteItem$1(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, TransferReceivedListFragment transferReceivedListFragment, Continuation<? super TransferReceivedListFragment$deleteItem$1> continuation) {
        super(2, continuation);
        this.$entity = historicalPlayRecordMultipleEntity;
        this.this$0 = transferReceivedListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransferReceivedListFragment$deleteItem$1(this.$entity, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TransferReceivedListFragment$deleteItem$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0064 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L26
            if (r1 == r5) goto L22
            if (r1 == r4) goto L1e
            if (r1 != r3) goto L16
            kotlin.ResultKt.b(r7)
            goto L65
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            kotlin.ResultKt.b(r7)
            goto L53
        L22:
            kotlin.ResultKt.b(r7)
            goto L48
        L26:
            kotlin.ResultKt.b(r7)
            com.transsnet.downloader.manager.DownloadEsHelper$a r7 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r7 = r7.a()
            com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity r1 = r6.$entity
            if (r1 == 0) goto L3e
            com.transsnet.downloader.bean.HistoricalPlayRecordBean r1 = r1.getHistorical()
            if (r1 == 0) goto L3e
            com.transsion.baselib.db.download.DownloadBean r1 = r1.getVideo()
            goto L3f
        L3e:
            r1 = r2
        L3f:
            r6.label = r5
            java.lang.Object r7 = r7.m(r1, r6)
            if (r7 != r0) goto L48
            return r0
        L48:
            r6.label = r4
            r4 = 300(0x12c, double:1.48E-321)
            java.lang.Object r7 = kotlinx.coroutines.u0.a(r4, r6)
            if (r7 != r0) goto L53
            return r0
        L53:
            kotlinx.coroutines.a2 r7 = kotlinx.coroutines.y0.c()
            com.transsnet.downloader.fragment.TransferReceivedListFragment$deleteItem$1$1 r1 = new com.transsnet.downloader.fragment.TransferReceivedListFragment$deleteItem$1$1
            r1.<init>(r2)
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.i.g(r7, r1, r6)
            if (r7 != r0) goto L65
            return r0
        L65:
            com.transsnet.downloader.fragment.TransferReceivedListFragment r7 = r6.this$0
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel r7 = r7.G0()
            r7.N()
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.TransferReceivedListFragment$deleteItem$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
