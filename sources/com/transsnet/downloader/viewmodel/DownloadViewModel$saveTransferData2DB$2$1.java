package com.transsnet.downloader.viewmodel;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadViewModel$saveTransferData2DB$2$1", f = "DownloadViewModel.kt", l = {175, 176, 177}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class DownloadViewModel$saveTransferData2DB$2$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ DownloadBean $this_apply;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadViewModel$saveTransferData2DB$2$1$1", f = "DownloadViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.viewmodel.DownloadViewModel$saveTransferData2DB$2$1$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$callback.invoke();
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadViewModel$saveTransferData2DB$2$1(DownloadBean downloadBean, Function0<Unit> function0, Continuation<? super DownloadViewModel$saveTransferData2DB$2$1> continuation) {
        super(2, continuation);
        this.$this_apply = downloadBean;
        this.$callback = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewModel$saveTransferData2DB$2$1(this.$this_apply, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadViewModel$saveTransferData2DB$2$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0076 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r8)
            goto L77
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            kotlin.ResultKt.b(r8)
            goto L62
        L21:
            kotlin.ResultKt.b(r8)
            goto L57
        L25:
            kotlin.ResultKt.b(r8)
            lg.a$a r8 = lg.a.f68962a
            com.transsion.baselib.db.download.DownloadBean r1 = r7.$this_apply
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "保存到数据库, data:"
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.lang.String r5 = "Transfer_d"
            r8.p(r5, r1, r4)
            com.transsnet.downloader.manager.DownloadEsHelper$a r8 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r8 = r8.a()
            com.transsion.baselib.db.download.DownloadBean r1 = r7.$this_apply
            r7.label = r4
            java.lang.Object r8 = r8.T(r1, r7)
            if (r8 != r0) goto L57
            return r0
        L57:
            r7.label = r3
            r3 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r8 = kotlinx.coroutines.u0.a(r3, r7)
            if (r8 != r0) goto L62
            return r0
        L62:
            kotlinx.coroutines.a2 r8 = kotlinx.coroutines.y0.c()
            com.transsnet.downloader.viewmodel.DownloadViewModel$saveTransferData2DB$2$1$1 r1 = new com.transsnet.downloader.viewmodel.DownloadViewModel$saveTransferData2DB$2$1$1
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r7.$callback
            r4 = 0
            r1.<init>(r3, r4)
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.i.g(r8, r1, r7)
            if (r8 != r0) goto L77
            return r0
        L77:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.DownloadViewModel$saveTransferData2DB$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
