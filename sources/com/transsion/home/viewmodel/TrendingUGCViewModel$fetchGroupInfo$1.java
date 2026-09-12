package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.moviedetailapi.bean.RoomItem;
import java.util.List;
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
import ol.e;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.TrendingUGCViewModel$fetchGroupInfo$1", f = "TrendingUGCViewModel.kt", l = {368}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class TrendingUGCViewModel$fetchGroupInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $useCache;
    int label;
    final /* synthetic */ TrendingUGCViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingUGCViewModel$fetchGroupInfo$1(TrendingUGCViewModel trendingUGCViewModel, Function0<Unit> function0, Continuation<? super TrendingUGCViewModel$fetchGroupInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = trendingUGCViewModel;
        this.$useCache = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrendingUGCViewModel$fetchGroupInfo$1(this.this$0, this.$useCache, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TrendingUGCViewModel$fetchGroupInfo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ol.e C;
        List<RoomItem> groups;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                C = this.this$0.C();
                this.label = 1;
                obj = e.a.c(C, null, 3, this, 1, null);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            RoomEntranceResponse roomEntranceResponse = (RoomEntranceResponse) baseDto.getData();
            if (roomEntranceResponse == null || (groups = roomEntranceResponse.getGroups()) == null || !(!groups.isEmpty())) {
                this.$useCache.invoke();
            } else {
                this.this$0.B().n(baseDto.getData());
                rl.e.f74676a.b().putString("trending_room_entrance_cache_v2", com.blankj.utilcode.util.o.j(baseDto.getData()));
            }
        } catch (Exception e11) {
            this.$useCache.invoke();
            e11.printStackTrace();
        }
        return Unit.f67184a;
    }
}
