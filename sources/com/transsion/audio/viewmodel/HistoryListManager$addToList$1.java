package com.transsion.audio.viewmodel;

import com.transsion.baselib.db.audio.AudioBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$addToList$1", f = "HistoryListManager.kt", l = {101}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HistoryListManager$addToList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioBean $audioBean;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$addToList$1$1", f = "HistoryListManager.kt", l = {103, 105, 107}, m = "invokeSuspend")
    /* renamed from: com.transsion.audio.viewmodel.HistoryListManager$addToList$1$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioBean $audioBean;
        int label;
        final /* synthetic */ HistoryListManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AudioBean audioBean, HistoryListManager historyListManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$audioBean = audioBean;
            this.this$0 = historyListManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$audioBean, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[RETURN] */
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
                goto L83
            L15:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1d:
                kotlin.ResultKt.b(r8)
                goto L59
            L21:
                kotlin.ResultKt.b(r8)
                goto L48
            L25:
                kotlin.ResultKt.b(r8)
                com.transsion.baselib.db.audio.AudioBean r8 = r7.$audioBean
                long r5 = java.lang.System.currentTimeMillis()
                java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
                r8.setUpdateTimeStamp(r1)
                com.transsion.audio.viewmodel.HistoryListManager r8 = r7.this$0
                jj.a r8 = com.transsion.audio.viewmodel.HistoryListManager.f(r8)
                if (r8 == 0) goto L48
                com.transsion.baselib.db.audio.AudioBean r1 = r7.$audioBean
                r7.label = r4
                java.lang.Object r8 = r8.h(r1, r7)
                if (r8 != r0) goto L48
                return r0
            L48:
                com.transsion.audio.viewmodel.HistoryListManager r8 = r7.this$0
                jj.a r8 = com.transsion.audio.viewmodel.HistoryListManager.f(r8)
                if (r8 == 0) goto L5c
                r7.label = r3
                java.lang.Object r8 = r8.e(r7)
                if (r8 != r0) goto L59
                return r0
            L59:
                java.util.List r8 = (java.util.List) r8
                goto L5d
            L5c:
                r8 = 0
            L5d:
                if (r8 == 0) goto L83
                int r1 = r8.size()
                r3 = 30
                if (r1 <= r3) goto L83
                com.transsion.audio.viewmodel.HistoryListManager r1 = r7.this$0
                jj.a r1 = com.transsion.audio.viewmodel.HistoryListManager.f(r1)
                if (r1 == 0) goto L83
                int r3 = r8.size()
                int r3 = r3 - r4
                java.lang.Object r8 = r8.get(r3)
                com.transsion.baselib.db.audio.AudioBean r8 = (com.transsion.baselib.db.audio.AudioBean) r8
                r7.label = r2
                java.lang.Object r8 = r1.b(r8, r7)
                if (r8 != r0) goto L83
                return r0
            L83:
                kotlin.Unit r8 = kotlin.Unit.f67184a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.audio.viewmodel.HistoryListManager$addToList$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryListManager$addToList$1(AudioBean audioBean, HistoryListManager historyListManager, Continuation<? super HistoryListManager$addToList$1> continuation) {
        super(2, continuation);
        this.$audioBean = audioBean;
        this.this$0 = historyListManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$addToList$1(this.$audioBean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HistoryListManager$addToList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            i0 b11 = y0.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$audioBean, this.this$0, null);
            this.label = 1;
            if (i.g(b11, anonymousClass1, this) == f11) {
                return f11;
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
