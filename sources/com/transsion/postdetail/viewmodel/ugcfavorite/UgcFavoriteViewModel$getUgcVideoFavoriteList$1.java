package com.transsion.postdetail.viewmodel.ugcfavorite;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.postdetail.bean.favorite.FeedFavorData;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.List;
import jq.a;
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
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.ugcfavorite.UgcFavoriteViewModel$getUgcVideoFavoriteList$1", f = "UgcFavoriteViewModel.kt", l = {Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UgcFavoriteViewModel$getUgcVideoFavoriteList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $page;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ UgcFavoriteViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UgcFavoriteViewModel$getUgcVideoFavoriteList$1(UgcFavoriteViewModel ugcFavoriteViewModel, String str, String str2, Continuation<? super UgcFavoriteViewModel$getUgcVideoFavoriteList$1> continuation) {
        super(2, continuation);
        this.this$0 = ugcFavoriteViewModel;
        this.$page = str;
        this.$userId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UgcFavoriteViewModel$getUgcVideoFavoriteList$1(this.this$0, this.$page, this.$userId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UgcFavoriteViewModel$getUgcVideoFavoriteList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        a aVar;
        int i11;
        List<UGCVideo> items;
        Object f11 = IntrinsicsKt.f();
        int i12 = this.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                aVar = this.this$0.f50322d;
                String a11 = vg.a.f77447a.a();
                String str = this.$page;
                i11 = UgcFavoriteViewModel.f50319i;
                String str2 = this.$userId;
                this.label = 1;
                obj = aVar.a(a11, str, i11, str2, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "subscription", "favorite data " + baseDto, false, 4, null);
            FeedFavorData feedFavorData = (FeedFavorData) baseDto.getData();
            a.C0856a.f(c0856a, "subscription", "favorite data size " + ((feedFavorData == null || (items = feedFavorData.getItems()) == null) ? null : Boxing.d(items.size())), false, 4, null);
            this.this$0.e().n(baseDto.getData());
        } catch (Exception e11) {
            e11.printStackTrace();
            a.C0856a c0856a2 = lg.a.f68962a;
            String simpleName = UgcFavoriteViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            c0856a2.i(simpleName, "exceptionHandler " + e11.getMessage(), true);
        }
        return Unit.f67184a;
    }
}
