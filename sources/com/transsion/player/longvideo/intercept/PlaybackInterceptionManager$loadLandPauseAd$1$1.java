package com.transsion.player.longvideo.intercept;

import androidx.appcompat.app.AppCompatActivity;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.tools.zip.UnixStat;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.intercept.PlaybackInterceptionManager$loadLandPauseAd$1$1", f = "PlaybackInterceptionManager.kt", l = {UnixStat.DEFAULT_DIR_PERM}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class PlaybackInterceptionManager$loadLandPauseAd$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ go.a $bean;
    final /* synthetic */ AppCompatActivity $compatActivity;
    final /* synthetic */ PlaybackInterceptAdView $startView;
    int label;
    final /* synthetic */ PlaybackInterceptionManager this$0;

    /* loaded from: classes6.dex */
    public static final class a extends di.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PlaybackInterceptAdView f48135d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PlaybackInterceptionManager f48136e;

        a(PlaybackInterceptAdView playbackInterceptAdView, PlaybackInterceptionManager playbackInterceptionManager) {
            this.f48135d = playbackInterceptAdView;
            this.f48136e = playbackInterceptionManager;
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            BiddingInterstitialManager biddingInterstitialManager;
            super.i(tAdErrorCode);
            biddingInterstitialManager = this.f48136e.f48119p;
            if (biddingInterstitialManager != null) {
                biddingInterstitialManager.V();
            }
            this.f48136e.f48119p = null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
        
            r2 = r8.f48136e.f48119p;
         */
        @Override // di.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void j(com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r9) {
            /*
                r8 = this;
                super.j(r9)
                com.transsion.player.longvideo.intercept.PlaybackInterceptAdView r0 = r8.f48135d
                android.content.Context r0 = r0.getContext()
                if (r0 == 0) goto L1d
                com.transsion.player.longvideo.intercept.PlaybackInterceptionManager r1 = r8.f48136e
                com.transsion.ad.bidding.interstitial.BiddingInterstitialManager r2 = com.transsion.player.longvideo.intercept.PlaybackInterceptionManager.q(r1)
                if (r2 == 0) goto L1d
                r3 = r0
                androidx.appcompat.app.AppCompatActivity r3 = (androidx.appcompat.app.AppCompatActivity) r3
                r6 = 4
                r7 = 0
                r5 = 0
                r4 = r9
                com.transsion.ad.bidding.base.AbsAdBidding.R0(r2, r3, r4, r5, r6, r7)
            L1d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.player.longvideo.intercept.PlaybackInterceptionManager$loadLandPauseAd$1$1.a.j(com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean):void");
        }

        @Override // di.a
        public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            BiddingInterstitialManager biddingInterstitialManager;
            super.m(biddingIntermediateMaterialBean);
            biddingInterstitialManager = this.f48136e.f48119p;
            if (biddingInterstitialManager != null) {
                biddingInterstitialManager.V();
            }
            this.f48136e.f48119p = null;
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            BiddingInterstitialManager biddingInterstitialManager;
            super.p(biddingIntermediateMaterialBean);
            biddingInterstitialManager = this.f48136e.f48119p;
            if (biddingInterstitialManager != null) {
                biddingInterstitialManager.V();
            }
            this.f48136e.f48119p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaybackInterceptionManager$loadLandPauseAd$1$1(AppCompatActivity appCompatActivity, PlaybackInterceptionManager playbackInterceptionManager, go.a aVar, PlaybackInterceptAdView playbackInterceptAdView, Continuation<? super PlaybackInterceptionManager$loadLandPauseAd$1$1> continuation) {
        super(2, continuation);
        this.$compatActivity = appCompatActivity;
        this.this$0 = playbackInterceptionManager;
        this.$bean = aVar;
        this.$startView = playbackInterceptAdView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlaybackInterceptionManager$loadLandPauseAd$1$1(this.$compatActivity, this.this$0, this.$bean, this.$startView, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PlaybackInterceptionManager$loadLandPauseAd$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingInterstitialManager biddingInterstitialManager;
        BiddingInterstitialManager biddingInterstitialManager2;
        BiddingInterstitialManager biddingInterstitialManager3;
        BiddingInterstitialManager biddingInterstitialManager4;
        BiddingInterstitialManager biddingInterstitialManager5;
        Subject m11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            AppCompatActivity appCompatActivity = this.$compatActivity;
            String str = null;
            if (appCompatActivity.isDestroyed() || appCompatActivity.isFinishing()) {
                appCompatActivity = null;
            }
            if (appCompatActivity == null) {
                return Unit.f67184a;
            }
            this.this$0.f48119p = new BiddingInterstitialManager();
            biddingInterstitialManager = this.this$0.f48119p;
            if (biddingInterstitialManager != null) {
                biddingInterstitialManager.O0("LandscapePauseSceneNew");
            }
            biddingInterstitialManager2 = this.this$0.f48119p;
            if (biddingInterstitialManager2 != null) {
                com.transsion.ad.strategy.d dVar = com.transsion.ad.strategy.d.f42285a;
                go.a aVar = this.$bean;
                if (aVar != null && (m11 = aVar.m()) != null) {
                    str = m11.getGenre();
                }
                biddingInterstitialManager2.M0(dVar.a(str));
            }
            biddingInterstitialManager3 = this.this$0.f48119p;
            if (biddingInterstitialManager3 != null) {
                biddingInterstitialManager3.L0(appCompatActivity);
            }
            biddingInterstitialManager4 = this.this$0.f48119p;
            if (biddingInterstitialManager4 != null) {
                biddingInterstitialManager4.N0(new a(this.$startView, this.this$0));
            }
            biddingInterstitialManager5 = this.this$0.f48119p;
            if (biddingInterstitialManager5 != null) {
                this.label = 1;
                if (AbsAdBidding.w0(biddingInterstitialManager5, 0, false, this, 3, null) == f11) {
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
