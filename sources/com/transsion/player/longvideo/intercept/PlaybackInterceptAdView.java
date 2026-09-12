package com.transsion.player.longvideo.intercept;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.view.LifecycleCoroutineScope;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.PlaybackRecordDao;
import com.transsion.baselib.db.video.PlaybackRecordTable;
import com.transsion.baseui.R$mipmap;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.push.PushConstants;
import com.transsion.wrapperad.R$id;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;
import lg.a;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\nJ7\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010 \u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010\nJ\u000f\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010\nJ\u0017\u0010$\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010\nJ\u0017\u0010,\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b,\u0010%J\u0017\u0010-\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b-\u0010%J\u001f\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020&2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020&H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020&H\u0002¢\u0006\u0004\b6\u00105R\u0017\u0010<\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010R\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010QR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010T\u001a\u0004\bU\u0010VR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010XR\u0016\u0010[\u001a\u00020Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010Z¨\u0006\\"}, d2 = {"Lcom/transsion/player/longvideo/intercept/PlaybackInterceptAdView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", PushConstants.PROVIDER_FIELD_DESTROY, "()V", "Lcom/transsion/player/longvideo/ui/LongVodUiType;", "uiType", "Lho/j;", "viewBinding", "onUiTypeChanged", "(Lcom/transsion/player/longvideo/ui/LongVodUiType;Lho/j;)V", "cannelPauseAd", "", "sceneId", "Lcom/transsion/player/longvideo/intercept/PlaybackInterceptionManager;", "playbackManager", "Lgo/a;", "bean", "Lcom/transsion/player/longvideo/intercept/d;", "callback", "loadNativeAd", "(Ljava/lang/String;Lcom/transsion/player/longvideo/intercept/PlaybackInterceptionManager;Lgo/a;Lcom/transsion/player/longvideo/intercept/d;)V", "getClassTag", "()Ljava/lang/String;", "Lcom/transsion/baselib/db/video/PlaybackRecordTable;", "playbackRecord", CampaignEx.JSON_KEY_AD_K, "(Ljava/lang/String;Lcom/transsion/baselib/db/video/PlaybackRecordTable;Lcom/transsion/player/longvideo/intercept/d;)V", "n", TtmlNode.TAG_P, "setBubbleTip", "(Lcom/transsion/player/longvideo/ui/LongVodUiType;)V", "", com.mbridge.msdk.foundation.same.report.j.f35620b, "(Ljava/lang/String;)I", "h", "(Ljava/lang/String;)V", "i", "m", "setLandLearnMore", EventConstants.KEY_TIME, "", "timestamp2", "", "l", "(IJ)Z", "getStartAdConfigT", "()I", "getEndAdConfigT", "Lho/m;", "a", "Lho/m;", "getBinding", "()Lho/m;", "binding", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "landAd", "Landroid/animation/AnimatorSet;", "c", "Landroid/animation/AnimatorSet;", "bubbleTipAnimator", "d", "Ljava/lang/String;", "genre", "e", "I", "remainCountdownTime", "Landroid/os/CountDownTimer;", "f", "Landroid/os/CountDownTimer;", "adShowCountDownTimer", be.g.f16474b, "Lcom/transsion/player/longvideo/intercept/d;", "Lgo/a;", "longVdPlayerBean", "Lcom/transsion/baselib/db/video/PlaybackRecordDao;", "Lkotlin/Lazy;", "getPlaybackRecordDao", "()Lcom/transsion/baselib/db/video/PlaybackRecordDao;", "playbackRecordDao", "Lcom/transsion/player/longvideo/intercept/PlaybackInterceptionManager;", "Ldi/a;", "Ldi/a;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class PlaybackInterceptAdView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ho.m binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private BiddingNativeManager landAd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private AnimatorSet bubbleTipAnimator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String genre;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int remainCountdownTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CountDownTimer adShowCountDownTimer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private d callback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private go.a longVdPlayerBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy playbackRecordDao;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private PlaybackInterceptionManager playbackManager;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private di.a listener;

    /* loaded from: classes6.dex */
    public static final class a extends CountDownTimer {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f48101b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Ref.IntRef intRef, long j11) {
            super(j11, 1000L);
            this.f48101b = intRef;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PlaybackInterceptAdView.this.remainCountdownTime = 0;
            PlaybackInterceptAdView.this.i();
            a.C0856a.f(lg.a.f68962a, "premium_p", "StartInterceptView --> adShowCountDown() --> 广告展示结束，关闭启播广告", false, 4, null);
            PlaybackInterceptAdView.this.n();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            PlaybackInterceptAdView playbackInterceptAdView = PlaybackInterceptAdView.this;
            Ref.IntRef intRef = this.f48101b;
            int i11 = intRef.element;
            intRef.element = i11 - 1;
            playbackInterceptAdView.remainCountdownTime = i11;
            PlaybackInterceptAdView.this.getBinding().f64804c.refreshCountDown(PlaybackInterceptAdView.this.remainCountdownTime);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public PlaybackInterceptAdView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlaybackInterceptAdView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        ho.m c11 = ho.m.c(LayoutInflater.from(context), this, true);
        Intrinsics.g(c11, "inflate(...)");
        this.binding = c11;
        this.playbackRecordDao = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.intercept.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlaybackRecordDao o11;
                o11 = PlaybackInterceptAdView.o();
                return o11;
            }
        });
        c11.f64807f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.intercept.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaybackInterceptAdView.e(PlaybackInterceptAdView.this, view);
            }
        });
        c11.f64803b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.intercept.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaybackInterceptAdView.f(PlaybackInterceptAdView.this, view);
            }
        });
        c11.f64804c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.intercept.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaybackInterceptAdView.g(PlaybackInterceptAdView.this, view);
            }
        });
        this.listener = new di.a() { // from class: com.transsion.player.longvideo.intercept.PlaybackInterceptAdView$listener$1
            @Override // di.a
            public void i(TAdErrorCode tAdErrorCode) {
                String classTag;
                super.i(tAdErrorCode);
                a.C0856a c0856a = lg.a.f68962a;
                classTag = PlaybackInterceptAdView.this.getClassTag();
                a.C0856a.f(c0856a, "premium_p", classTag + " --> listener --> onBiddingError() --> p0 = " + tAdErrorCode, false, 4, null);
                PlaybackInterceptAdView.this.n();
            }

            @Override // di.a
            public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingNativeManager biddingNativeManager;
                BiddingNativeManager biddingNativeManager2;
                BiddingNativeManager biddingNativeManager3;
                BiddingNativeManager biddingNativeManager4;
                String str;
                BiddingNativeManager biddingNativeManager5;
                BiddingNativeManager biddingNativeManager6;
                super.j(biddingIntermediateMaterialBean);
                PlaybackInterceptAdView.this.getBinding().f64805d.setVisibility(0);
                PlaybackInterceptAdView.this.setVisibility(0);
                Context context2 = context;
                AppCompatActivity appCompatActivity = context2 instanceof AppCompatActivity ? (AppCompatActivity) context2 : null;
                if (appCompatActivity != null) {
                    PlaybackInterceptAdView playbackInterceptAdView = PlaybackInterceptAdView.this;
                    if (((appCompatActivity.isDestroyed() || appCompatActivity.isFinishing()) ? null : appCompatActivity) == null) {
                        return;
                    }
                    cy.b bVar = cy.b.f61063a;
                    biddingNativeManager = playbackInterceptAdView.landAd;
                    com.transsion.ad.bidding.base.r a11 = bVar.a(appCompatActivity, biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null);
                    NativeWrapperAdView nativeWrapperAdView = playbackInterceptAdView.getBinding().f64806e;
                    biddingNativeManager2 = playbackInterceptAdView.landAd;
                    nativeWrapperAdView.bindNativeView(biddingNativeManager2, a11, biddingIntermediateMaterialBean);
                    playbackInterceptAdView.onUiTypeChanged(LongVodUiType.PORTRAIT, null);
                    biddingNativeManager3 = playbackInterceptAdView.landAd;
                    if (!Intrinsics.c(biddingNativeManager3 != null ? biddingNativeManager3.getMSceneId() : null, "VideoStartBidScene")) {
                        biddingNativeManager5 = playbackInterceptAdView.landAd;
                        if (!Intrinsics.c(biddingNativeManager5 != null ? biddingNativeManager5.getMSceneId() : null, "VideoEndBidScene")) {
                            biddingNativeManager6 = playbackInterceptAdView.landAd;
                            if (Intrinsics.c(biddingNativeManager6 != null ? biddingNativeManager6.getMSceneId() : null, "VerticalPauseScene")) {
                                playbackInterceptAdView.getBinding().f64804c.setVisibility(8);
                                playbackInterceptAdView.getBinding().f64803b.setVisibility(0);
                                return;
                            }
                            return;
                        }
                    }
                    playbackInterceptAdView.getBinding().f64804c.setVisibility(0);
                    playbackInterceptAdView.getBinding().f64803b.setVisibility(8);
                    playbackInterceptAdView.p();
                    biddingNativeManager4 = playbackInterceptAdView.landAd;
                    if (biddingNativeManager4 == null || (str = biddingNativeManager4.getMSceneId()) == null) {
                        str = "";
                    }
                    playbackInterceptAdView.h(str);
                }
            }

            @Override // di.a
            public void l(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                String classTag;
                super.l(biddingIntermediateMaterialBean);
                a.C0856a c0856a = lg.a.f68962a;
                classTag = PlaybackInterceptAdView.this.getClassTag();
                a.C0856a.f(c0856a, "premium_p", classTag + " --> listener --> onBiddingWrapperAdClick()", false, 4, null);
                if (Intrinsics.c(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getSceneId() : null, "VideoStartBidScene")) {
                    PlaybackInterceptAdView.this.n();
                }
            }

            @Override // di.a
            public void n(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                super.n(biddingIntermediateMaterialBean);
                kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(y0.b()), null, null, new PlaybackInterceptAdView$listener$1$onBiddingWrapperAdDisplay$1(PlaybackInterceptAdView.this, biddingIntermediateMaterialBean, context, null), 3, null);
            }

            @Override // di.a
            public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                String classTag;
                super.p(biddingIntermediateMaterialBean);
                a.C0856a c0856a = lg.a.f68962a;
                classTag = PlaybackInterceptAdView.this.getClassTag();
                a.C0856a.f(c0856a, "premium_p", classTag + " --> listener --> onBiddingWrapperAdShowError()", false, 4, null);
                PlaybackInterceptAdView.this.n();
            }
        };
    }

    public /* synthetic */ PlaybackInterceptAdView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PlaybackInterceptAdView playbackInterceptAdView, View view) {
        d dVar = playbackInterceptAdView.callback;
        if (dVar != null) {
            dVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PlaybackInterceptAdView playbackInterceptAdView, View view) {
        d dVar = playbackInterceptAdView.callback;
        if (dVar != null) {
            dVar.onComplete();
        }
        playbackInterceptAdView.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PlaybackInterceptAdView playbackInterceptAdView, View view) {
        PlaybackInterceptionManager playbackInterceptionManager = playbackInterceptAdView.playbackManager;
        if (playbackInterceptionManager != null) {
            PlaybackInterceptionManager.X(playbackInterceptionManager, true, "PlaybackInterceptAdView", ti.n.f76387a.b(), false, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = PlaybackInterceptAdView.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getEndAdConfigT() {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoEndBidScene");
        return ((b11 == null || (jsonElement = b11.get("interval")) == null) ? 1440 : jsonElement.getAsInt()) * 60000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlaybackRecordDao getPlaybackRecordDao() {
        return (PlaybackRecordDao) this.playbackRecordDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getStartAdConfigT() {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoStartBidScene");
        return ((b11 == null || (jsonElement = b11.get("interval")) == null) ? 1440 : jsonElement.getAsInt()) * 60000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String sceneId) {
        Ref.IntRef intRef = new Ref.IntRef();
        int i11 = this.remainCountdownTime;
        if (i11 == 0) {
            i11 = j(sceneId);
        }
        intRef.element = i11;
        this.binding.f64804c.refreshCountDown(i11);
        i();
        a aVar = new a(intRef, intRef.element * 1000);
        this.adShowCountDownTimer = aVar;
        aVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        CountDownTimer countDownTimer = this.adShowCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.adShowCountDownTimer = null;
    }

    private final int j(String sceneId) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        int hashCode = sceneId.hashCode();
        if (hashCode != -172473003) {
            if (hashCode != -73588874) {
                if (hashCode == 2049503279 && sceneId.equals("VideoEndBidScene")) {
                    JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoEndBidScene");
                    if (b11 == null || (jsonElement3 = b11.get("videoEndAdCountdownTime")) == null) {
                        return 10;
                    }
                    return jsonElement3.getAsInt();
                }
            } else if (sceneId.equals("VideoStartBidScene")) {
                JsonObject b12 = com.transsion.ad.scene.d.f42258a.b("VideoStartBidScene");
                if (b12 == null || (jsonElement2 = b12.get("videoStartAdCountdownTime")) == null) {
                    return 10;
                }
                return jsonElement2.getAsInt();
            }
        } else if (sceneId.equals("VideoInterpolateBidScene")) {
            JsonObject b13 = com.transsion.ad.scene.d.f42258a.b("VideoInterpolateBidScene");
            if (b13 == null || (jsonElement = b13.get("videoInterpolateAdCountdownTime")) == null) {
                return 10;
            }
            return jsonElement.getAsInt();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String sceneId, PlaybackRecordTable playbackRecord, d callback) {
        LifecycleCoroutineScope a11;
        LifecycleCoroutineScope a12;
        if (Intrinsics.c(sceneId, "VideoStartBidScene")) {
            Context context = getContext();
            AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
            if (appCompatActivity != null && (a12 = androidx.view.v.a(appCompatActivity)) != null) {
                kotlinx.coroutines.k.d(a12, null, null, new PlaybackInterceptAdView$innerLoadAd$1(playbackRecord, this, sceneId, callback, null), 3, null);
            }
        } else if (Intrinsics.c(sceneId, "VideoEndBidScene")) {
            Context context2 = getContext();
            AppCompatActivity appCompatActivity2 = context2 instanceof AppCompatActivity ? (AppCompatActivity) context2 : null;
            if (appCompatActivity2 != null && (a11 = androidx.view.v.a(appCompatActivity2)) != null) {
                kotlinx.coroutines.k.d(a11, null, null, new PlaybackInterceptAdView$innerLoadAd$2(this, playbackRecord, sceneId, callback, null), 3, null);
            }
        }
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "premium_p", getClassTag() + " --> loadNativeAd(开始加载广告) --> sceneId = " + sceneId, false, 4, null);
        BiddingNativeManager biddingNativeManager = this.landAd;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.landAd = null;
        this.callback = callback;
        if (TextUtils.equals("VerticalPauseScene", sceneId)) {
            setVisibility(8);
            a.C0856a.f(c0856a, "premium_p", getClassTag() + " --> loadNativeAd(开始加载广告) --> sceneId = " + sceneId + " --> 不可见", false, 4, null);
        } else {
            setVisibility(8);
            this.binding.f64805d.setVisibility(8);
        }
        Context context3 = getContext();
        AppCompatActivity appCompatActivity3 = context3 instanceof AppCompatActivity ? (AppCompatActivity) context3 : null;
        if (appCompatActivity3 != null) {
            AppCompatActivity appCompatActivity4 = (appCompatActivity3.isDestroyed() || appCompatActivity3.isFinishing()) ? null : appCompatActivity3;
            if (appCompatActivity4 == null) {
                return;
            }
            kotlinx.coroutines.k.d(androidx.view.v.a(appCompatActivity3), null, null, new PlaybackInterceptAdView$innerLoadAd$3$1(this, sceneId, appCompatActivity4, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(int time, long timestamp2) {
        return Math.abs(System.currentTimeMillis() - timestamp2) > ((long) time);
    }

    public static /* synthetic */ void loadNativeAd$default(PlaybackInterceptAdView playbackInterceptAdView, String str, PlaybackInterceptionManager playbackInterceptionManager, go.a aVar, d dVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            aVar = null;
        }
        if ((i11 & 8) != 0) {
            dVar = null;
        }
        playbackInterceptAdView.loadNativeAd(str, playbackInterceptionManager, aVar, dVar);
    }

    private final void m(LongVodUiType uiType) {
        if (uiType == LongVodUiType.LAND) {
            this.binding.f64807f.setImageResource(R$mipmap.ad_rotate);
        } else {
            this.binding.f64807f.setImageResource(R$mipmap.ad_fullscreen);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        setVisibility(8);
        BiddingNativeManager biddingNativeManager = this.landAd;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.landAd = null;
        i();
        d dVar = this.callback;
        if (dVar != null) {
            dVar.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlaybackRecordDao o() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).v1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        BubbleTextView bubbleTextView = (BubbleTextView) this.binding.f64806e.findViewById(R$id.bubble_tip);
        if (bubbleTextView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bubbleTextView, "translationY", -35.0f, 15.0f, -35.0f);
            ofFloat.setDuration(900L);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat);
            animatorSet.start();
            jg.c.k(bubbleTextView);
            this.bubbleTipAnimator = animatorSet;
        }
    }

    private final void setBubbleTip(LongVodUiType uiType) {
        BubbleTextView bubbleTextView = (BubbleTextView) this.binding.f64806e.findViewById(R$id.bubble_tip);
        if (bubbleTextView != null) {
            LongVodUiType longVodUiType = LongVodUiType.LAND;
            bubbleTextView.setTextSize(uiType == longVodUiType ? 16.0f : 12.0f);
            bubbleTextView.setArrowPosition(com.blankj.utilcode.util.a0.a(uiType == longVodUiType ? 110.0f : 90.0f));
        }
    }

    private final void setLandLearnMore(LongVodUiType uiType) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.binding.f64806e.findViewById(R$id.native_ad_action);
        if (appCompatTextView != null) {
            boolean z10 = uiType == LongVodUiType.LAND;
            ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).height = com.blankj.utilcode.util.a0.a(z10 ? 44.0f : 28.0f);
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = com.blankj.utilcode.util.a0.a(z10 ? 73.0f : 52.0f);
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = com.blankj.utilcode.util.a0.a(z10 ? 16.0f : 10.0f);
            }
            appCompatTextView.setTextSize(z10 ? 16.0f : 12.0f);
            int a11 = com.blankj.utilcode.util.a0.a(z10 ? 16.0f : 6.0f);
            appCompatTextView.setPadding(a11, 3, a11, 4);
        }
    }

    public final void cannelPauseAd() {
        BiddingNativeManager biddingNativeManager = this.landAd;
        if (Intrinsics.c(biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null, "VerticalPauseScene")) {
            BiddingNativeManager biddingNativeManager2 = this.landAd;
            if (biddingNativeManager2 != null) {
                biddingNativeManager2.V();
            }
            this.landAd = null;
        }
    }

    public final void destroy() {
        BiddingNativeManager biddingNativeManager = this.landAd;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.landAd = null;
        i();
        setVisibility(8);
        this.binding.f64805d.setVisibility(8);
        this.remainCountdownTime = 0;
    }

    public final ho.m getBinding() {
        return this.binding;
    }

    public final void loadNativeAd(String sceneId, PlaybackInterceptionManager playbackManager, go.a bean, d callback) {
        LifecycleCoroutineScope a11;
        Intrinsics.h(sceneId, "sceneId");
        if (bean != null) {
            this.longVdPlayerBean = bean;
            this.playbackManager = playbackManager;
            Context context = getContext();
            AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
            if (appCompatActivity == null || (a11 = androidx.view.v.a(appCompatActivity)) == null) {
                return;
            }
            kotlinx.coroutines.k.d(a11, null, null, new PlaybackInterceptAdView$loadNativeAd$1$1(this, bean, sceneId, callback, null), 3, null);
        }
    }

    public final void onUiTypeChanged(LongVodUiType uiType, ho.j viewBinding) {
        Intrinsics.h(uiType, "uiType");
        a.C0856a.f(lg.a.f68962a, "premium_p", getClassTag() + " --> loadNativeAd() --> uiType = " + uiType, false, 4, null);
        m(uiType);
        setBubbleTip(uiType);
        setLandLearnMore(uiType);
    }
}
