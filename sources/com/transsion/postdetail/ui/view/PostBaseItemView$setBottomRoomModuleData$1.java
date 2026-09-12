package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ui.view.PostBaseItemView$setBottomRoomModuleData$1", f = "PostBaseItemView.kt", l = {793}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class PostBaseItemView$setBottomRoomModuleData$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostSubjectItem $item;
    int label;
    final /* synthetic */ PostBaseItemView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostBaseItemView$setBottomRoomModuleData$1(PostSubjectItem postSubjectItem, PostBaseItemView postBaseItemView, Continuation<? super PostBaseItemView$setBottomRoomModuleData$1> continuation) {
        super(2, continuation);
        this.$item = postSubjectItem;
        this.this$0 = postBaseItemView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostBaseItemView$setBottomRoomModuleData$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PostBaseItemView$setBottomRoomModuleData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Group group;
        Cover cover;
        String url;
        AssetManager assets;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Group group2 = this.$item.getGroup();
            if ((group2 == null || group2.getAvatar() == null) && (group = this.$item.getGroup()) != null && (cover = group.getCover()) != null && (url = cover.getUrl()) != null) {
                PostBaseItemView postBaseItemView = this.this$0;
                Context context = postBaseItemView.getContext();
                Bitmap decodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(url));
                kotlinx.coroutines.a2 c11 = kotlinx.coroutines.y0.c();
                PostBaseItemView$setBottomRoomModuleData$1$1$1 postBaseItemView$setBottomRoomModuleData$1$1$1 = new PostBaseItemView$setBottomRoomModuleData$1$1$1(postBaseItemView, decodeStream, null);
                this.label = 1;
                if (kotlinx.coroutines.i.g(c11, postBaseItemView$setBottomRoomModuleData$1$1$1, this) == f11) {
                    return f11;
                }
            }
            return Unit.f67184a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Unit unit = Unit.f67184a;
        return Unit.f67184a;
    }
}
