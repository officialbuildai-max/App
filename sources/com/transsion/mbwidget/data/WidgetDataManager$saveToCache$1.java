package com.transsion.mbwidget.data;

import com.blankj.utilcode.util.o;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.mbwidget.data.WidgetDataManager$saveToCache$1", f = "WidgetDataManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class WidgetDataManager$saveToCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeskWidgetResp $resp;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDataManager$saveToCache$1(DeskWidgetResp deskWidgetResp, Continuation<? super WidgetDataManager$saveToCache$1> continuation) {
        super(2, continuation);
        this.$resp = deskWidgetResp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WidgetDataManager$saveToCache$1 widgetDataManager$saveToCache$1 = new WidgetDataManager$saveToCache$1(this.$resp, continuation);
        widgetDataManager$saveToCache$1.L$0 = obj;
        return widgetDataManager$saveToCache$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((WidgetDataManager$saveToCache$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        DeskWidgetResp deskWidgetResp = this.$resp;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (deskWidgetResp.getHotList().isEmpty()) {
                copyOnWriteArrayList2 = WidgetDataManager.f46315g;
                deskWidgetResp.setHotList(copyOnWriteArrayList2);
            }
            if (deskWidgetResp.getInterestList().isEmpty()) {
                copyOnWriteArrayList = WidgetDataManager.f46316h;
                deskWidgetResp.setInterestList(copyOnWriteArrayList);
            }
            Result.m1185constructorimpl(com.transsion.mbwidget.d.f46293a.k().putString("hot_widget_cache_key", o.j(deskWidgetResp)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return Unit.f67184a;
    }
}
