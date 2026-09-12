package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter;
import com.transsion.home.bean.BannerData;
import com.transsion.moviedetailapi.bean.Image;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter$onBindViewHolder$1", f = "SubHorizontalViewPagerAdapter.kt", l = {67}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class SubHorizontalViewPagerAdapter$onBindViewHolder$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BannerData $bannerData;
    final /* synthetic */ SubHorizontalViewPagerAdapter.a $holder;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubHorizontalViewPagerAdapter$onBindViewHolder$1(BannerData bannerData, SubHorizontalViewPagerAdapter.a aVar, Continuation<? super SubHorizontalViewPagerAdapter$onBindViewHolder$1> continuation) {
        super(2, continuation);
        this.$bannerData = bannerData;
        this.$holder = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubHorizontalViewPagerAdapter$onBindViewHolder$1(this.$bannerData, this.$holder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubHorizontalViewPagerAdapter$onBindViewHolder$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String url;
        AssetManager assets;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Image image = this.$bannerData.getImage();
            if (image != null && (url = image.getUrl()) != null) {
                SubHorizontalViewPagerAdapter.a aVar = this.$holder;
                Context context = aVar.getImageView().getContext();
                Bitmap decodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(url));
                a2 c11 = y0.c();
                SubHorizontalViewPagerAdapter$onBindViewHolder$1$1$1 subHorizontalViewPagerAdapter$onBindViewHolder$1$1$1 = new SubHorizontalViewPagerAdapter$onBindViewHolder$1$1$1(aVar, decodeStream, null);
                this.label = 1;
                if (kotlinx.coroutines.i.g(c11, subHorizontalViewPagerAdapter$onBindViewHolder$1$1$1, this) == f11) {
                    return f11;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
