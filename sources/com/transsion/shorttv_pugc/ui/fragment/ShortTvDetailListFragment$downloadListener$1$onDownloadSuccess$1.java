package com.transsion.shorttv_pugc.ui.fragment;

import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$1", f = "ShortTvDetailListFragment.kt", l = {670}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
final class ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $ugcVideoId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ShortTvDetailListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$1(ShortTvDetailListFragment shortTvDetailListFragment, String str, Continuation<? super ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvDetailListFragment;
        this.$ugcVideoId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$1(this.this$0, this.$ugcVideoId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ShortTvViewModel z02;
        Object obj2;
        ShortTvDetailListFragment shortTvDetailListFragment;
        ShortTvViewModel z03;
        ShorttvModel.UGCVideo uGCVideo;
        String playUrl;
        lo.f fVar;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            z02 = this.this$0.z0();
            List z10 = z02.z();
            String str = this.$ugcVideoId;
            Iterator it = z10.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (Intrinsics.c(((ShorttvModel.UGCVideo) obj2).getUgcVideoId(), str)) {
                    break;
                }
            }
            ShorttvModel.UGCVideo uGCVideo2 = (ShorttvModel.UGCVideo) obj2;
            if (uGCVideo2 != null) {
                shortTvDetailListFragment = this.this$0;
                String str2 = this.$ugcVideoId;
                z03 = shortTvDetailListFragment.z0();
                this.L$0 = shortTvDetailListFragment;
                this.L$1 = uGCVideo2;
                this.label = 1;
                Object w11 = z03.w(str2, this);
                if (w11 == f11) {
                    return f11;
                }
                uGCVideo = uGCVideo2;
                obj = w11;
            }
            return Unit.f67184a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        uGCVideo = (ShorttvModel.UGCVideo) this.L$1;
        shortTvDetailListFragment = (ShortTvDetailListFragment) this.L$0;
        ResultKt.b(obj);
        ShorttvModel.UGCVideo uGCVideo3 = (ShorttvModel.UGCVideo) obj;
        if (uGCVideo3 != null && (playUrl = uGCVideo3.getPlayUrl()) != null) {
            fVar = shortTvDetailListFragment.mOrPlayer;
            if (fVar != null) {
                ao.e eVar = new ao.e(playUrl, playUrl, uGCVideo.getEp(), null, null, 24, null);
                eVar.t(playUrl);
                Boxing.a(fVar.b(eVar));
            }
            uGCVideo.setPlayUrl(playUrl);
        }
        return Unit.f67184a;
    }
}
