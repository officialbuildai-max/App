package com.transsion.player.longvideo.member;

import com.therouter.TheRouter;
import com.transsion.ad.strategy.r;
import com.transsion.memberapi.IMemberApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.member.LongVodResolutionMemberTipView$showResolutionTip$1", f = "LongVodResolutionMemberTipView.kt", l = {147}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class LongVodResolutionMemberTipView$showResolutionTip$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ go.a $curBean;
    final /* synthetic */ boolean $hasAtLeast720P;
    final /* synthetic */ Integer $target;
    int label;
    final /* synthetic */ LongVodResolutionMemberTipView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodResolutionMemberTipView$showResolutionTip$1(go.a aVar, LongVodResolutionMemberTipView longVodResolutionMemberTipView, boolean z10, Integer num, Continuation<? super LongVodResolutionMemberTipView$showResolutionTip$1> continuation) {
        super(2, continuation);
        this.$curBean = aVar;
        this.this$0 = longVodResolutionMemberTipView;
        this.$hasAtLeast720P = z10;
        this.$target = num;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodResolutionMemberTipView$showResolutionTip$1(this.$curBean, this.this$0, this.$hasAtLeast720P, this.$target, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LongVodResolutionMemberTipView$showResolutionTip$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String classTag;
        String classTag2;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            ResolutionMemberManager resolutionMemberManager = ResolutionMemberManager.f48259a;
            go.a aVar = this.$curBean;
            this.label = 1;
            obj = resolutionMemberManager.f(aVar, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            ok.c cVar = ok.c.f71157a;
            classTag2 = this.this$0.getClassTag();
            cVar.a(classTag2 + " --> showResolutionTip() --> 已出现过，不显示");
            return Unit.f67184a;
        }
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        boolean c11 = iMemberApi != null ? iMemberApi.c() : false;
        if (!c11 && this.$hasAtLeast720P) {
            this.this$0.setVisibility(0);
            this.this$0.curBean = this.$curBean;
            r.f42294a.g(this.this$0);
            this.this$0.e();
            ok.c cVar2 = ok.c.f71157a;
            classTag = this.this$0.getClassTag();
            cVar2.a(classTag + " --> showResolutionTip() --> isMember = " + c11 + " --> 右下角提示 --> target = " + this.$target);
        }
        return Unit.f67184a;
    }
}
