package com.transsion.postdetail.viewmodel;

import androidx.view.b0;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$loadPostExploreCombinedCache$1", f = "RoomPostViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class RoomPostViewModel$loadPostExploreCombinedCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RoomPostViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPostViewModel$loadPostExploreCombinedCache$1(RoomPostViewModel roomPostViewModel, Continuation<? super RoomPostViewModel$loadPostExploreCombinedCache$1> continuation) {
        super(2, continuation);
        this.this$0 = roomPostViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomPostViewModel$loadPostExploreCombinedCache$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((RoomPostViewModel$loadPostExploreCombinedCache$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List b02;
        List d02;
        List c02;
        PostSubjectBean k02;
        b0 b0Var;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        b02 = this.this$0.b0();
        d02 = this.this$0.d0("post_explore_net_cache_exp", "loadExpNetCacheItems");
        c02 = this.this$0.c0();
        k02 = this.this$0.k0(b02, d02, c02);
        if (k02 != null) {
            a.C0856a c0856a = lg.a.f68962a;
            int size = b02.size();
            int size2 = d02.size();
            int size3 = c02.size();
            List<PostSubjectItem> items = k02.getItems();
            a.C0856a.f(c0856a, "RoomPostVM", "loadPostExploreCombinedCache [实验组], 已曝光:" + size + ", 网络:" + size2 + ", 手动:" + size3 + ", 合并:" + (items != null ? Boxing.d(items.size()) : null), false, 4, null);
            b0Var = this.this$0.f50287e;
            b0Var.n(k02);
        } else {
            a.C0856a.f(lg.a.f68962a, "RoomPostVM", "loadPostExploreCombinedCache [实验组], 无缓存数据", false, 4, null);
        }
        return Unit.f67184a;
    }
}
