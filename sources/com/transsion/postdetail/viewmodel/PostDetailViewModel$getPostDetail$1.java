package com.transsion.postdetail.viewmodel;

import androidx.view.b0;
import com.tn.lib.net.bean.BaseDto;
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
import retrofit2.HttpException;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.PostDetailViewModel$getPostDetail$1", f = "PostDetailViewModel.kt", l = {76}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class PostDetailViewModel$getPostDetail$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    Object L$0;
    int label;
    final /* synthetic */ PostDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostDetailViewModel$getPostDetail$1(PostDetailViewModel postDetailViewModel, String str, Continuation<? super PostDetailViewModel$getPostDetail$1> continuation) {
        super(2, continuation);
        this.this$0 = postDetailViewModel;
        this.$postId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostDetailViewModel$getPostDetail$1(this.this$0, this.$postId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PostDetailViewModel$getPostDetail$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        b0 z10;
        xo.b D;
        PostDetailViewModel postDetailViewModel;
        b0 z11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                PostDetailViewModel postDetailViewModel2 = this.this$0;
                String str = this.$postId;
                Result.Companion companion = Result.INSTANCE;
                D = postDetailViewModel2.D();
                String a11 = vg.a.f77447a.a();
                this.L$0 = postDetailViewModel2;
                this.label = 1;
                Object a12 = D.a(a11, str, this);
                if (a12 == f11) {
                    return f11;
                }
                postDetailViewModel = postDetailViewModel2;
                obj = a12;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                postDetailViewModel = (PostDetailViewModel) this.L$0;
                ResultKt.b(obj);
            }
            z11 = postDetailViewModel.z();
            z11.q(((BaseDto) obj).getData());
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        PostDetailViewModel postDetailViewModel3 = this.this$0;
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            if (m1188exceptionOrNullimpl instanceof HttpException) {
                HttpException httpException = (HttpException) m1188exceptionOrNullimpl;
                if (httpException.code() == 404) {
                    postDetailViewModel3.y().q(String.valueOf(httpException.code()));
                }
            }
            z10 = postDetailViewModel3.z();
            z10.q(null);
        }
        return Unit.f67184a;
    }
}
