package com.transsion.usercenter.profile.viewmodel;

import androidx.view.b0;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoList;
import java.util.ArrayList;
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
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.profile.viewmodel.UserProfileVideoViewModel$requestPage$1", f = "UserProfileVideoViewModel.kt", l = {129}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UserProfileVideoViewModel$requestPage$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ boolean $isSelf;
    final /* synthetic */ String $pageToken;
    final /* synthetic */ String $uid;
    int label;
    final /* synthetic */ UserProfileVideoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileVideoViewModel$requestPage$1(UserProfileVideoViewModel userProfileVideoViewModel, boolean z10, boolean z11, String str, String str2, Continuation<? super UserProfileVideoViewModel$requestPage$1> continuation) {
        super(2, continuation);
        this.this$0 = userProfileVideoViewModel;
        this.$isRefresh = z10;
        this.$isSelf = z11;
        this.$pageToken = str;
        this.$uid = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserProfileVideoViewModel$requestPage$1(this.this$0, this.$isRefresh, this.$isSelf, this.$pageToken, this.$uid, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UserProfileVideoViewModel$requestPage$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b0 b0Var;
        b0 b0Var2;
        b0 b0Var3;
        b0 b0Var4;
        b0 b0Var5;
        b0 b0Var6;
        List<UGCVideo> arrayList;
        b0 b0Var7;
        boolean z10;
        List list;
        List list2;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            try {
                if (i11 == 0) {
                    ResultKt.b(obj);
                    i0 b11 = y0.b();
                    UserProfileVideoViewModel$requestPage$1$dto$1 userProfileVideoViewModel$requestPage$1$dto$1 = new UserProfileVideoViewModel$requestPage$1$dto$1(this.$isSelf, this.this$0, this.$pageToken, this.$uid, null);
                    this.label = 1;
                    obj = i.g(b11, userProfileVideoViewModel$requestPage$1$dto$1, this);
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
                if (Intrinsics.c(baseDto.getCode(), "0")) {
                    UGCVideoList uGCVideoList = (UGCVideoList) baseDto.getData();
                    b0Var6 = this.this$0.f57429k;
                    b0Var6.q(uGCVideoList);
                    if (uGCVideoList == null || (arrayList = uGCVideoList.getItems()) == null) {
                        arrayList = new ArrayList<>();
                    }
                    if (this.$isRefresh) {
                        list2 = this.this$0.f57425g;
                        list2.clear();
                    }
                    if (!arrayList.isEmpty()) {
                        list = this.this$0.f57425g;
                        list.addAll(arrayList);
                    }
                    Pager pager = uGCVideoList != null ? uGCVideoList.getPager() : null;
                    this.this$0.f57424f = pager != null ? Intrinsics.c(pager.getHasMore(), Boxing.a(true)) : false;
                    this.this$0.f57422d = pager != null ? pager.getNextPage() : null;
                    b0Var7 = this.this$0.f57431m;
                    b0Var7.q(null);
                    a.C0856a c0856a = lg.a.f68962a;
                    Integer d11 = Boxing.d(arrayList.size());
                    z10 = this.this$0.f57424f;
                    c0856a.c("UserProfileVideoVM", "requestPage success size=" + d11 + " hasMore=" + z10, false);
                } else {
                    b0Var4 = this.this$0.f57431m;
                    b0Var4.q(baseDto.getCode());
                    b0Var5 = this.this$0.f57429k;
                    b0Var5.q(null);
                    lg.a.f68962a.i("UserProfileVideoVM", "requestPage failure code=" + baseDto.getCode(), false);
                }
            } catch (Exception e11) {
                b0Var = this.this$0.f57431m;
                b0Var.q(TmcConstants.COLD_OPEN_TYPE);
                b0Var2 = this.this$0.f57429k;
                b0Var2.q(null);
                lg.a.f68962a.i("UserProfileVideoVM", "requestPage exception: " + e11.getMessage(), false);
            }
            return Unit.f67184a;
        } finally {
            b0Var3 = this.this$0.f57426h;
            b0Var3.q(Boxing.a(false));
            this.this$0.f57428j = false;
        }
    }
}
