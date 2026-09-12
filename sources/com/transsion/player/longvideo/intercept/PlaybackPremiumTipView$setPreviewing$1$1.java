package com.transsion.player.longvideo.intercept;

import com.transsion.baselib.db.download.VipInfo;
import com.transsion.baselib.db.video.PlaybackRecordDao;
import com.transsion.baselib.db.video.PlaybackRecordTable;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$string;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.intercept.PlaybackPremiumTipView$setPreviewing$1$1", f = "PlaybackPremiumTipView.kt", l = {86}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class PlaybackPremiumTipView$setPreviewing$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ go.a $bean;
    final /* synthetic */ go.a $longVdPlayerBean;
    final /* synthetic */ PlaybackInterceptionManager $manager;
    int label;
    final /* synthetic */ PlaybackPremiumTipView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaybackPremiumTipView$setPreviewing$1$1(PlaybackPremiumTipView playbackPremiumTipView, go.a aVar, go.a aVar2, PlaybackInterceptionManager playbackInterceptionManager, Continuation<? super PlaybackPremiumTipView$setPreviewing$1$1> continuation) {
        super(2, continuation);
        this.this$0 = playbackPremiumTipView;
        this.$bean = aVar;
        this.$longVdPlayerBean = aVar2;
        this.$manager = playbackInterceptionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlaybackPremiumTipView$setPreviewing$1$1(this.this$0, this.$bean, this.$longVdPlayerBean, this.$manager, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PlaybackPremiumTipView$setPreviewing$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PlaybackRecordDao playbackRecordDao;
        String str;
        Object a11;
        String str2;
        VipInfo vipInfo;
        Integer requireMemberType;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            playbackRecordDao = this.this$0.getPlaybackRecordDao();
            Subject m11 = this.$bean.m();
            if (m11 == null || (str = m11.getSubjectId()) == null) {
                str = "";
            }
            int l11 = this.$longVdPlayerBean.l();
            int e11 = this.$longVdPlayerBean.e();
            this.label = 1;
            a11 = playbackRecordDao.a(str, l11, e11, this);
            if (a11 == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            a11 = obj;
        }
        PlaybackRecordTable playbackRecordTable = (PlaybackRecordTable) a11;
        if (playbackRecordTable == null || !playbackRecordTable.getRewardUnlock()) {
            a.C0856a.f(lg.a.f68962a, "premium_p", "PlaybackPremiumTipView --> onRenderFirstFrame() --> 试看提示 --> pageName = " + this.$bean.i() + " --> 试看提示", false, 4, null);
            this.this$0.setVisibility(0);
            this.this$0.getBinding().f64827d.setVisibility(8);
            this.this$0.getBinding().f64826c.setVisibility(0);
            this.this$0.traceId = ti.n.f76387a.b();
            com.transsion.baselib.helper.f fVar = com.transsion.baselib.helper.f.f43323a;
            String i12 = this.$bean.i();
            str2 = this.this$0.traceId;
            fVar.h(i12, "player/resolution_upgrade", str2, this.$bean.o(), 0);
            Subject m12 = this.$bean.m();
            if (m12 == null || (vipInfo = m12.getVipInfo()) == null || (requireMemberType = vipInfo.getRequireMemberType()) == null || requireMemberType.intValue() != 1) {
                this.this$0.getBinding().f64828e.setText(this.this$0.getContext().getString(R$string.p_v2_hd_previewing));
                this.this$0.getBinding().f64829f.setText(this.this$0.getContext().getString(R$string.p_v2_unlock_hd));
            } else {
                this.this$0.getBinding().f64828e.setText(this.this$0.getContext().getString(R$string.p_v2_previewing));
                this.this$0.getBinding().f64829f.setText(this.this$0.getContext().getString(R$string.p_v2_unlock_full_access));
            }
            this.this$0.g(this.$bean.i(), this.$bean.o(), this.$manager);
        } else {
            a.C0856a.f(lg.a.f68962a, "premium_p", "PlaybackPremiumTipView --> onRenderFirstFrame() --> 试看提示 --> pageName = " + this.$bean.i() + " --> 当前已经解锁，不展示提示", false, 4, null);
        }
        return Unit.f67184a;
    }
}
