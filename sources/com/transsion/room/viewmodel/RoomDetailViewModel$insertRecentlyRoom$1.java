package com.transsion.room.viewmodel;

import com.transsion.moviedetailapi.bean.RoomItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.viewmodel.RoomDetailViewModel$insertRecentlyRoom$1", f = "RoomDetailViewModel.kt", l = {142, 143, 146}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class RoomDetailViewModel$insertRecentlyRoom$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ RoomItem $roomItem;
    int label;
    final /* synthetic */ RoomDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDetailViewModel$insertRecentlyRoom$1(RoomItem roomItem, RoomDetailViewModel roomDetailViewModel, Continuation<? super RoomDetailViewModel$insertRecentlyRoom$1> continuation) {
        super(2, continuation);
        this.$roomItem = roomItem;
        this.this$0 = roomDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomDetailViewModel$insertRecentlyRoom$1(this.$roomItem, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((RoomDetailViewModel$insertRecentlyRoom$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
    
        r7 = r20.this$0.o();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b2 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L2b
            if (r2 == r6) goto L27
            if (r2 == r5) goto L21
            if (r2 != r4) goto L19
            kotlin.ResultKt.b(r21)
            goto Lb3
        L19:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L21:
            kotlin.ResultKt.b(r21)
            r2 = r21
            goto L8b
        L27:
            kotlin.ResultKt.b(r21)
            goto L7a
        L2b:
            kotlin.ResultKt.b(r21)
            com.transsion.moviedetailapi.bean.RoomItem r2 = r0.$roomItem
            java.lang.String r8 = r2.getGroupId()
            if (r8 == 0) goto L66
            com.transsion.moviedetailapi.bean.RoomItem r2 = r0.$roomItem
            com.transsion.baselib.db.room.RoomItemBean r19 = new com.transsion.baselib.db.room.RoomItemBean
            java.lang.String r9 = r2.getName()
            java.lang.String r10 = r2.getAvatar()
            java.lang.Boolean r11 = r2.getHasJoin()
            java.lang.Long r12 = r2.getNewPostCount()
            java.lang.String r13 = r2.getDescription()
            java.lang.Long r14 = r2.getPostCount()
            java.lang.Long r15 = r2.getUserCount()
            java.lang.String r16 = r2.getLevel()
            long r17 = java.lang.System.currentTimeMillis()
            r7 = r19
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r2 = r19
            goto L67
        L66:
            r2 = r3
        L67:
            if (r2 == 0) goto L7a
            com.transsion.room.viewmodel.RoomDetailViewModel r7 = r0.this$0
            rj.a r7 = com.transsion.room.viewmodel.RoomDetailViewModel.i(r7)
            if (r7 == 0) goto L7a
            r0.label = r6
            java.lang.Object r2 = r7.b(r2, r0)
            if (r2 != r1) goto L7a
            return r1
        L7a:
            com.transsion.room.viewmodel.RoomDetailViewModel r2 = r0.this$0
            rj.a r2 = com.transsion.room.viewmodel.RoomDetailViewModel.i(r2)
            if (r2 == 0) goto L8e
            r0.label = r5
            java.lang.Object r2 = r2.a(r0)
            if (r2 != r1) goto L8b
            return r1
        L8b:
            r3 = r2
            java.util.List r3 = (java.util.List) r3
        L8e:
            if (r3 == 0) goto Lb3
            int r2 = r3.size()
            r5 = 5
            if (r2 <= r5) goto Lb3
            com.transsion.room.viewmodel.RoomDetailViewModel r2 = r0.this$0
            rj.a r2 = com.transsion.room.viewmodel.RoomDetailViewModel.i(r2)
            if (r2 == 0) goto Lb3
            int r5 = r3.size()
            int r5 = r5 - r6
            java.lang.Object r3 = r3.get(r5)
            com.transsion.baselib.db.room.RoomItemBean r3 = (com.transsion.baselib.db.room.RoomItemBean) r3
            r0.label = r4
            java.lang.Object r2 = r2.c(r3, r0)
            if (r2 != r1) goto Lb3
            return r1
        Lb3:
            kotlin.Unit r1 = kotlin.Unit.f67184a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.room.viewmodel.RoomDetailViewModel$insertRecentlyRoom$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
