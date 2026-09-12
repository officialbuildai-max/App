package com.transsion.postdetail.viewmodel;

import android.app.Application;
import androidx.view.b0;
import com.blankj.utilcode.util.Utils;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$loadPostExploreBuiltInCache$1", f = "RoomPostViewModel.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class RoomPostViewModel$loadPostExploreBuiltInCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RoomPostViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPostViewModel$loadPostExploreBuiltInCache$1(RoomPostViewModel roomPostViewModel, Continuation<? super RoomPostViewModel$loadPostExploreBuiltInCache$1> continuation) {
        super(2, continuation);
        this.this$0 = roomPostViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RoomPostViewModel$loadPostExploreBuiltInCache$1 roomPostViewModel$loadPostExploreBuiltInCache$1 = new RoomPostViewModel$loadPostExploreBuiltInCache$1(this.this$0, continuation);
        roomPostViewModel$loadPostExploreBuiltInCache$1.L$0 = obj;
        return roomPostViewModel$loadPostExploreBuiltInCache$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((RoomPostViewModel$loadPostExploreBuiltInCache$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        yo.a A;
        String a11;
        String str;
        b0 b0Var;
        PostSubjectItem postSubjectItem;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        String string = bVar.b().getString("room_cache_data", "");
        if (this.this$0.X()) {
            String string2 = bVar.b().getString("post_explore_net_cache_exp", "");
            String string3 = bVar.b().getString("post_explore_exposed_cache", "");
            if ((string != null && string.length() != 0) || ((string2 != null && string2.length() != 0) || (string3 != null && string3.length() != 0))) {
                a.C0856a.f(lg.a.f68962a, "RoomPostVM", "loadPostExploreBuiltInCache, 有缓存数据，不使用内置", false, 4, null);
                return Unit.f67184a;
            }
        } else {
            String string4 = bVar.b().getString("post_explore_net_cache", "");
            if ((string != null && string.length() != 0) || (string4 != null && string4.length() != 0)) {
                a.C0856a.f(lg.a.f68962a, "RoomPostVM", "loadPostExploreBuiltInCache, 有手动缓存或网络缓存，不使用内置", false, 4, null);
                return Unit.f67184a;
            }
        }
        RoomPostViewModel roomPostViewModel = this.this$0;
        try {
            Result.Companion companion = Result.INSTANCE;
            roomPostViewModel.f50297o = System.currentTimeMillis();
            A = roomPostViewModel.A();
            Application a12 = Utils.a();
            Intrinsics.g(a12, "getApp(...)");
            a11 = A.a(a12);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (a11 != null && a11.length() != 0) {
            PostSubjectBean postSubjectBean = (PostSubjectBean) com.blankj.utilcode.util.o.d(a11, PostSubjectBean.class);
            a.C0856a c0856a = lg.a.f68962a;
            List<PostSubjectItem> items = postSubjectBean.getItems();
            if (items == null || (postSubjectItem = (PostSubjectItem) CollectionsKt.k0(items)) == null) {
                str = null;
            } else {
                String title = postSubjectItem.getTitle();
                if (title != null && title.length() != 0) {
                    str = postSubjectItem.getTitle();
                }
                str = postSubjectItem.getContent();
            }
            a.C0856a.f(c0856a, "RoomPostVM", "loadPostExploreBuiltInCache, 内置--hase cache,show cache, firstContent:" + str, false, 4, null);
            List<PostSubjectItem> items2 = postSubjectBean.getItems();
            if (items2 != null && !items2.isEmpty()) {
                b0Var = roomPostViewModel.f50287e;
                b0Var.n(postSubjectBean);
            }
            Result.m1185constructorimpl(Unit.f67184a);
            return Unit.f67184a;
        }
        a.C0856a.f(lg.a.f68962a, "RoomPostVM", "loadPostExploreBuiltInCache, 无内置", false, 4, null);
        Result.m1185constructorimpl(Unit.f67184a);
        return Unit.f67184a;
    }
}
