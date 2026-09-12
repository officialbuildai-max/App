package com.transsion.ninegridview.preview;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.photoview.PhotoView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ninegridview.preview.GifImagePreviewFragment$initView$5", f = "GifImagePreviewFragment.kt", l = {139}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class GifImagePreviewFragment$initView$5 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ PhotoView $pv;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GifImagePreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifImagePreviewFragment$initView$5(GifImagePreviewFragment gifImagePreviewFragment, PhotoView photoView, Continuation<? super GifImagePreviewFragment$initView$5> continuation) {
        super(2, continuation);
        this.this$0 = gifImagePreviewFragment;
        this.$pv = photoView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GifImagePreviewFragment$initView$5 gifImagePreviewFragment$initView$5 = new GifImagePreviewFragment$initView$5(this.this$0, this.$pv, continuation);
        gifImagePreviewFragment$initView$5.L$0 = obj;
        return gifImagePreviewFragment$initView$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((GifImagePreviewFragment$initView$5) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Image image;
        String url;
        AssetManager assets;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (i11 == 0) {
            ResultKt.b(obj);
            image = this.this$0.image;
            if (image != null && (url = image.getUrl()) != null) {
                PhotoView photoView = this.$pv;
                Result.Companion companion2 = Result.INSTANCE;
                Context context = photoView.getContext();
                Bitmap decodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(url));
                a2 c11 = y0.c();
                GifImagePreviewFragment$initView$5$1$1$1 gifImagePreviewFragment$initView$5$1$1$1 = new GifImagePreviewFragment$initView$5$1$1$1(photoView, decodeStream, null);
                this.label = 1;
                if (kotlinx.coroutines.i.g(c11, gifImagePreviewFragment$initView$5$1$1$1, this) == f11) {
                    return f11;
                }
            }
            return Unit.f67184a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Result.m1185constructorimpl(Unit.f67184a);
        return Unit.f67184a;
    }
}
