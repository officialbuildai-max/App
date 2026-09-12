package com.transsion.room.sub.viewmodel.likes;

import bh.b;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
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
import kq.a;
import lg.a;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.sub.viewmodel.likes.UgcLikesViewModel$postLikeUgcVideo$1", f = "UgcLikesViewModel.kt", l = {100}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UgcLikesViewModel$postLikeUgcVideo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLike;
    final /* synthetic */ String $ugcVideoId;
    Object L$0;
    int label;
    final /* synthetic */ UgcLikesViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UgcLikesViewModel$postLikeUgcVideo$1(String str, boolean z10, UgcLikesViewModel ugcLikesViewModel, Continuation<? super UgcLikesViewModel$postLikeUgcVideo$1> continuation) {
        super(2, continuation);
        this.$ugcVideoId = str;
        this.$isLike = z10;
        this.this$0 = ugcLikesViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UgcLikesViewModel$postLikeUgcVideo$1(this.$ugcVideoId, this.$isLike, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UgcLikesViewModel$postLikeUgcVideo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        a aVar;
        UgcLikesViewModel ugcLikesViewModel;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
        } catch (Exception e11) {
            e11.printStackTrace();
            a.C0856a c0856a = lg.a.f68962a;
            String simpleName = UgcLikesViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            c0856a.i(simpleName, "exceptionHandler " + e11.getMessage(), true);
        }
        if (i11 == 0) {
            ResultKt.b(obj);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("ugcVideoId", this.$ugcVideoId);
            jsonObject.addProperty("reqType", Boxing.d(!this.$isLike ? 1 : 0));
            b.a aVar2 = b.f16553a;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            RequestBody a11 = aVar2.a(jsonElement);
            if (a11 != null) {
                UgcLikesViewModel ugcLikesViewModel2 = this.this$0;
                aVar = ugcLikesViewModel2.f51823d;
                String a12 = vg.a.f77447a.a();
                this.L$0 = ugcLikesViewModel2;
                this.label = 1;
                obj = aVar.a(a12, a11, this);
                if (obj == f11) {
                    return f11;
                }
                ugcLikesViewModel = ugcLikesViewModel2;
            }
            return Unit.f67184a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ugcLikesViewModel = (UgcLikesViewModel) this.L$0;
        ResultKt.b(obj);
        ugcLikesViewModel.e().n(((BaseDto) obj).getData());
        return Unit.f67184a;
    }
}
