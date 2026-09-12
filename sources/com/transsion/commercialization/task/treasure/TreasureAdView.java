package com.transsion.commercialization.task.treasure;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.cardview.widget.CardView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001>\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\fR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcom/transsion/commercialization/task/treasure/TreasureAdView;", "Landroidx/cardview/widget/CardView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "h", "()V", "i", "onDestroy", "Lcom/transsion/commercialization/task/treasure/c;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/transsion/commercialization/task/treasure/c;)V", "Lkotlin/Function1;", "", "callback", "setAdCallback", "(Lkotlin/jvm/functions/Function1;)V", "", "genre", "setGenre", "(Ljava/lang/String;)V", "loadAd", "Lkk/k;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lkk/k;", "binding", CampaignEx.JSON_KEY_AD_K, "Lkotlin/jvm/functions/Function1;", "adCallback", "l", "Lcom/transsion/commercialization/task/treasure/c;", "m", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "n", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoading", "Lcom/transsion/commercialization/task/treasure/d;", "o", "Lcom/transsion/commercialization/task/treasure/d;", "viewBinder", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", TtmlNode.TAG_P, "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "maxEcpmObject", "Landroid/animation/ObjectAnimator;", CampaignEx.JSON_KEY_AD_Q, "Lkotlin/Lazy;", "getRefreshAnimator", "()Landroid/animation/ObjectAnimator;", "refreshAnimator", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", CampaignEx.JSON_KEY_AD_R, "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "nativeManager", "com/transsion/commercialization/task/treasure/TreasureAdView$a", "s", "Lcom/transsion/commercialization/task/treasure/TreasureAdView$a;", "nativeListener", "Commercialization_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class TreasureAdView extends CardView {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final kk.k binding;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Function1 adCallback;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private c listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String genre;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isLoading;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final d viewBinder;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private BiddingIntermediateMaterialBean maxEcpmObject;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Lazy refreshAnimator;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private BiddingNativeManager nativeManager;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final a nativeListener;

    /* loaded from: classes5.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            TreasureAdView.this.isLoading.set(false);
            Function1 function1 = TreasureAdView.this.adCallback;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
            TreasureAdView.this.i();
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            TreasureAdView.this.maxEcpmObject = biddingIntermediateMaterialBean;
            TreasureAdView.this.binding.f67020d.bindNativeView(TreasureAdView.this.nativeManager, TreasureAdView.this.viewBinder, biddingIntermediateMaterialBean);
            TreasureAdView.this.isLoading.set(false);
            TreasureAdView.this.i();
            Function1 function1 = TreasureAdView.this.adCallback;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        }

        @Override // di.a
        public void l(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.l(biddingIntermediateMaterialBean);
            c cVar = TreasureAdView.this.listener;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TreasureAdView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TreasureAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TreasureAdView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        kk.k c11 = kk.k.c(LayoutInflater.from(context), this, true);
        Intrinsics.g(c11, "inflate(...)");
        this.binding = c11;
        c11.f67019c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.treasure.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TreasureAdView.e(TreasureAdView.this, view);
            }
        });
        c11.f67021e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.treasure.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TreasureAdView.f(TreasureAdView.this, view);
            }
        });
        this.isLoading = new AtomicBoolean(false);
        this.viewBinder = new d(context);
        this.refreshAnimator = LazyKt.b(new Function0() { // from class: com.transsion.commercialization.task.treasure.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ObjectAnimator g11;
                g11 = TreasureAdView.g(TreasureAdView.this);
                return g11;
            }
        });
        this.nativeListener = new a();
    }

    public /* synthetic */ TreasureAdView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TreasureAdView treasureAdView, View view) {
        treasureAdView.loadAd();
        c cVar = treasureAdView.listener;
        if (cVar != null) {
            cVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TreasureAdView treasureAdView, View view) {
        NativeWrapperAdView.simulatingClick$default(treasureAdView.binding.f67020d, treasureAdView.maxEcpmObject, treasureAdView.viewBinder, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObjectAnimator g(TreasureAdView treasureAdView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(treasureAdView.binding.f67018b, "rotation", 0.0f, 360.0f);
        ofFloat.setDuration(800L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        return ofFloat;
    }

    private final ObjectAnimator getRefreshAnimator() {
        Object value = this.refreshAnimator.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (ObjectAnimator) value;
    }

    private final void h() {
        if (getRefreshAnimator().isRunning()) {
            return;
        }
        getRefreshAnimator().start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        getRefreshAnimator().cancel();
        this.binding.f67018b.setRotation(0.0f);
    }

    public final void loadAd() {
        if (this.nativeManager == null) {
            BiddingNativeManager biddingNativeManager = new BiddingNativeManager();
            this.nativeManager = biddingNativeManager;
            biddingNativeManager.O0("TreasureNativeAdScene");
            BiddingNativeManager biddingNativeManager2 = this.nativeManager;
            if (biddingNativeManager2 != null) {
                biddingNativeManager2.M0(com.transsion.ad.strategy.d.f42285a.a(this.genre));
            }
            BiddingNativeManager biddingNativeManager3 = this.nativeManager;
            if (biddingNativeManager3 != null) {
                biddingNativeManager3.N0(this.nativeListener);
            }
        }
        if (this.isLoading.get()) {
            return;
        }
        this.isLoading.set(true);
        h();
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new TreasureAdView$loadAd$1(this, null), 3, null);
    }

    public final void onDestroy() {
        getRefreshAnimator().cancel();
        BiddingNativeManager biddingNativeManager = this.nativeManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
    }

    public final void setAdCallback(Function1<? super Boolean, Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.adCallback = callback;
    }

    public final void setGenre(String genre) {
        this.genre = genre;
    }

    public final void setListener(c listener) {
        this.listener = listener;
    }
}
