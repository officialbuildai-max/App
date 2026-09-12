package com.transsion.postdetail.viewmodel;

import androidx.view.b0;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$loadPostSubPageCache$1", f = "RoomPostViewModel.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class RoomPostViewModel$loadPostSubPageCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $tabId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RoomPostViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPostViewModel$loadPostSubPageCache$1(String str, RoomPostViewModel roomPostViewModel, Continuation<? super RoomPostViewModel$loadPostSubPageCache$1> continuation) {
        super(2, continuation);
        this.$tabId = str;
        this.this$0 = roomPostViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RoomPostViewModel$loadPostSubPageCache$1 roomPostViewModel$loadPostSubPageCache$1 = new RoomPostViewModel$loadPostSubPageCache$1(this.$tabId, this.this$0, continuation);
        roomPostViewModel$loadPostSubPageCache$1.L$0 = obj;
        return roomPostViewModel$loadPostSubPageCache$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((RoomPostViewModel$loadPostSubPageCache$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String string;
        b0 b0Var;
        b0 b0Var2;
        PostSubjectItem postSubjectItem;
        String content;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String str2 = this.$tabId;
        RoomPostViewModel roomPostViewModel = this.this$0;
        try {
            Result.Companion companion = Result.INSTANCE;
            str = null;
            string = com.transsion.baselib.report.launch.b.f43424a.b().getString("post_sub_page_cache_" + str2, null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (string != null && string.length() != 0) {
            PostSubjectBean postSubjectBean = (PostSubjectBean) com.blankj.utilcode.util.o.d(string, PostSubjectBean.class);
            a.C0856a c0856a = lg.a.f68962a;
            List<PostSubjectItem> items = postSubjectBean.getItems();
            if (items != null && (postSubjectItem = (PostSubjectItem) CollectionsKt.k0(items)) != null) {
                String title = postSubjectItem.getTitle();
                if (title != null && title.length() != 0) {
                    content = postSubjectItem.getTitle();
                    str = content;
                }
                content = postSubjectItem.getContent();
                str = content;
            }
            a.C0856a.f(c0856a, "RoomPostVM", "loadPostSubPageCache, hase cache,show cache, tabId:" + str2 + ", content:" + str, false, 4, null);
            b0Var2 = roomPostViewModel.f50295m;
            b0Var2.n(postSubjectBean);
            Result.m1185constructorimpl(Unit.f67184a);
            return Unit.f67184a;
        }
        if (!nh.m.f70597a.e()) {
            b0Var = roomPostViewModel.f50295m;
            b0Var.n(null);
        }
        Result.m1185constructorimpl(Unit.f67184a);
        return Unit.f67184a;
    }
}
