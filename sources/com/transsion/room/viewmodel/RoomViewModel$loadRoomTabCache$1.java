package com.transsion.room.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$loadRoomTabCache$1", f = "RoomViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class RoomViewModel$loadRoomTabCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RoomViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomViewModel$loadRoomTabCache$1(RoomViewModel roomViewModel, Continuation<? super RoomViewModel$loadRoomTabCache$1> continuation) {
        super(2, continuation);
        this.this$0 = roomViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RoomViewModel$loadRoomTabCache$1 roomViewModel$loadRoomTabCache$1 = new RoomViewModel$loadRoomTabCache$1(this.this$0, continuation);
        roomViewModel$loadRoomTabCache$1.L$0 = obj;
        return roomViewModel$loadRoomTabCache$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((RoomViewModel$loadRoomTabCache$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|(2:4|5)|(8:7|(1:9)|10|11|12|13|14|15)|20|10|11|12|13|14|15) */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r3.label
            if (r0 != 0) goto L50
            kotlin.ResultKt.b(r4)
            java.lang.Object r4 = r3.L$0
            kotlinx.coroutines.n0 r4 = (kotlinx.coroutines.n0) r4
            com.transsion.room.viewmodel.RoomViewModel r4 = r3.this$0
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L28
            com.transsion.baselib.report.launch.b r0 = com.transsion.baselib.report.launch.b.f43424a     // Catch: java.lang.Throwable -> L28
            com.tencent.mmkv.MMKV r0 = r0.b()     // Catch: java.lang.Throwable -> L28
            java.lang.String r1 = "k_room_tab_cache"
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L2a
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L28
            if (r1 != 0) goto L2e
            goto L2a
        L28:
            r4 = move-exception
            goto L44
        L2a:
            java.lang.String r0 = com.transsion.room.viewmodel.RoomViewModel.p(r4)     // Catch: java.lang.Throwable -> L28
        L2e:
            java.lang.Class<com.transsion.moviedetailapi.bean.RoomTabBean> r1 = com.transsion.moviedetailapi.bean.RoomTabBean.class
            java.lang.Object r0 = com.blankj.utilcode.util.o.d(r0, r1)     // Catch: java.lang.Throwable -> L37
            com.transsion.moviedetailapi.bean.RoomTabBean r0 = (com.transsion.moviedetailapi.bean.RoomTabBean) r0     // Catch: java.lang.Throwable -> L37
            r2 = r0
        L37:
            androidx.lifecycle.b0 r4 = com.transsion.room.viewmodel.RoomViewModel.l(r4)     // Catch: java.lang.Throwable -> L28
            r4.n(r2)     // Catch: java.lang.Throwable -> L28
            kotlin.Unit r4 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L28
            kotlin.Result.m1185constructorimpl(r4)     // Catch: java.lang.Throwable -> L28
            goto L4d
        L44:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            kotlin.Result.m1185constructorimpl(r4)
        L4d:
            kotlin.Unit r4 = kotlin.Unit.f67184a
            return r4
        L50:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.room.viewmodel.RoomViewModel$loadRoomTabCache$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
