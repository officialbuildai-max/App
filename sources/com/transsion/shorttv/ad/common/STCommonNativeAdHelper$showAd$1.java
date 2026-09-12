package com.transsion.shorttv.ad.common;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewGroupKt;
import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.hisavana.mediation.ad.TAdNativeView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.shorttv.R$id;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.ad.common.STCommonNativeAdHelper$showAd$1", f = "STCommonNativeAdHelper.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class STCommonNativeAdHelper$showAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ r $layoutProvider;
    final /* synthetic */ NativeWrapperAdView $nativeAdView;
    final /* synthetic */ Function1<Boolean, Unit> $showCallback;
    int label;
    final /* synthetic */ STCommonNativeAdHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public STCommonNativeAdHelper$showAd$1(STCommonNativeAdHelper sTCommonNativeAdHelper, Function1<? super Boolean, Unit> function1, NativeWrapperAdView nativeWrapperAdView, r rVar, Continuation<? super STCommonNativeAdHelper$showAd$1> continuation) {
        super(2, continuation);
        this.this$0 = sTCommonNativeAdHelper;
        this.$showCallback = function1;
        this.$nativeAdView = nativeWrapperAdView;
        this.$layoutProvider = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(NativeWrapperAdView nativeWrapperAdView) {
        Object obj;
        View view;
        Sequence<View> children;
        Object obj2;
        try {
            Result.Companion companion = Result.INSTANCE;
            ImageView imageView = (ImageView) nativeWrapperAdView.findViewById(R$id.ad_blur_view);
            if (imageView != null) {
                imageView.setBackgroundColor(Color.parseColor("#E6000000"));
            }
            Iterator f67553a = ViewGroupKt.getChildren(nativeWrapperAdView).getF67553a();
            while (true) {
                if (!f67553a.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = f67553a.next();
                    if (((View) obj) instanceof TAdNativeView) {
                        break;
                    }
                }
            }
            RelativeLayout relativeLayout = obj instanceof RelativeLayout ? (RelativeLayout) obj : null;
            if (relativeLayout == null || (children = ViewGroupKt.getChildren(relativeLayout)) == null) {
                view = null;
            } else {
                Iterator f67553a2 = children.getF67553a();
                while (true) {
                    if (!f67553a2.hasNext()) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = f67553a2.next();
                        if (((View) obj2) instanceof TNativeView) {
                            break;
                        }
                    }
                }
                view = (View) obj2;
            }
            FrameLayout frameLayout = view instanceof FrameLayout ? (FrameLayout) view : null;
            if (relativeLayout != null && frameLayout != null) {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 == null) {
                    return;
                }
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                frameLayout.setLayoutParams(layoutParams2);
                frameLayout.requestLayout();
                Result.m1185constructorimpl(Unit.f67184a);
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new STCommonNativeAdHelper$showAd$1(this.this$0, this.$showCallback, this.$nativeAdView, this.$layoutProvider, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((STCommonNativeAdHelper$showAd$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBean;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        STCommonNativeAdHelper sTCommonNativeAdHelper = this.this$0;
        Function1<Boolean, Unit> function1 = this.$showCallback;
        final NativeWrapperAdView nativeWrapperAdView = this.$nativeAdView;
        r rVar = this.$layoutProvider;
        try {
            Result.Companion companion = Result.INSTANCE;
            ur.a aVar = ur.a.f77012a;
            String o11 = sTCommonNativeAdHelper.o();
            biddingNativeManager = sTCommonNativeAdHelper.f52744c;
            aVar.b(o11, "trigger show ad", biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null);
            sTCommonNativeAdHelper.f52747f = function1;
            sTCommonNativeAdHelper.f52748g = new WeakReference(nativeWrapperAdView);
            biddingNativeManager2 = sTCommonNativeAdHelper.f52744c;
            biddingIntermediateMaterialBean = sTCommonNativeAdHelper.f52745d;
            nativeWrapperAdView.bindNativeView(biddingNativeManager2, rVar, biddingIntermediateMaterialBean);
            m1185constructorimpl = Result.m1185constructorimpl(Boxing.a(nativeWrapperAdView.post(new Runnable() { // from class: com.transsion.shorttv.ad.common.a
                @Override // java.lang.Runnable
                public final void run() {
                    STCommonNativeAdHelper$showAd$1.d(NativeWrapperAdView.this);
                }
            })));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Function1<Boolean, Unit> function12 = this.$showCallback;
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null && function12 != null) {
            function12.invoke(Boxing.a(false));
        }
        return Unit.f67184a;
    }
}
