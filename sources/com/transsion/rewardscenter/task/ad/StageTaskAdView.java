package com.transsion.rewardscenter.task.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.widget.R$color;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.push.PushConstants;
import com.transsion.rewardscenter.task.ad.v;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0010J!\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001e\u0010\u0010J0\u0010#\u001a\u00020\n2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\u001f¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020%¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\n¢\u0006\u0004\b+\u0010\fR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R3\u00104\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001b\u0010<\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010;R\u001b\u0010B\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u00109\u001a\u0004\bA\u0010;¨\u0006C"}, d2 = {"Lcom/transsion/rewardscenter/task/ad/StageTaskAdView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "x", "()V", "Lcom/transsion/rewardscenter/task/ad/v$c;", WebConstants.FIELD_ITEM, "n", "(Lcom/transsion/rewardscenter/task/ad/v$c;)V", "setProgress", "setBtnAction", CampaignEx.JSON_KEY_AD_R, TmcStartParams.KEY_URL_SHORT, "Lcom/transsion/rewardscenter/task/ad/AdTaskState;", "adTaskState", "v", "(Lcom/transsion/rewardscenter/task/ad/v$c;Lcom/transsion/rewardscenter/task/ad/AdTaskState;)V", "Lcom/transsion/rewardscenter/task/ad/BaseStageTaskAdHelper;", "helper", "setAdHelper", "(Lcom/transsion/rewardscenter/task/ad/BaseStageTaskAdHelper;)V", "stageItem", "setData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "callback", "setClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "", "skipAd", "updateUI", "(Z)V", "isBind", "()Z", PushConstants.PROVIDER_FIELD_DESTROY, "Lvp/l;", "a", "Lvp/l;", "binding", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/rewardscenter/task/ad/v$c;", "c", "Lkotlin/jvm/functions/Function1;", "clickCallback", "d", "Lcom/transsion/rewardscenter/task/ad/BaseStageTaskAdHelper;", "adHelper", "e", "Lkotlin/Lazy;", "getColorNormal", "()I", "colorNormal", "f", "getColorDownloading", "colorDownloading", be.g.f16474b, "getColorCompleted", "colorCompleted", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class StageTaskAdView extends ConstraintLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private vp.l binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private v.c stageItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function1 clickCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BaseStageTaskAdHelper adHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy colorNormal;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy colorDownloading;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy colorCompleted;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51119a;

        static {
            int[] iArr = new int[AdTaskState.values().length];
            try {
                iArr[AdTaskState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdTaskState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdTaskState.INSTALLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AdTaskState.CLAIMED_STAGE1.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AdTaskState.PLAYING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AdTaskState.PLAYED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AdTaskState.COMPLETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f51119a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StageTaskAdView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StageTaskAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StageTaskAdView(final Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.colorNormal = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.ad.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int q11;
                q11 = StageTaskAdView.q(context);
                return Integer.valueOf(q11);
            }
        });
        this.colorDownloading = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.ad.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int p11;
                p11 = StageTaskAdView.p(context);
                return Integer.valueOf(p11);
            }
        });
        this.colorCompleted = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.ad.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int o11;
                o11 = StageTaskAdView.o(context);
                return Integer.valueOf(o11);
            }
        });
        this.binding = vp.l.c(LayoutInflater.from(context), this, true);
        x();
    }

    public /* synthetic */ StageTaskAdView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final int getColorCompleted() {
        return ((Number) this.colorCompleted.getValue()).intValue();
    }

    private final int getColorDownloading() {
        return ((Number) this.colorDownloading.getValue()).intValue();
    }

    private final int getColorNormal() {
        return ((Number) this.colorNormal.getValue()).intValue();
    }

    private final void n(v.c item) {
        BaseStageTaskAdHelper baseStageTaskAdHelper = this.adHelper;
        if (baseStageTaskAdHelper != null) {
            baseStageTaskAdHelper.c(item);
        }
        NativeWrapperAdView h11 = item.h();
        if (h11 != null) {
            ViewParent parent = h11.getParent();
            vp.l lVar = null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(h11);
            }
            vp.l lVar2 = this.binding;
            if (lVar2 == null) {
                Intrinsics.z("binding");
                lVar2 = null;
            }
            lVar2.f77556b.removeAllViews();
            vp.l lVar3 = this.binding;
            if (lVar3 == null) {
                Intrinsics.z("binding");
            } else {
                lVar = lVar3;
            }
            lVar.f77556b.addView(h11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(Context context) {
        return androidx.core.content.b.getColor(context, R$color.white_30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(Context context) {
        return androidx.core.content.b.getColor(context, R$color.white_50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(Context context) {
        return androidx.core.content.b.getColor(context, R$color.white);
    }

    private final void r(final v.c item) {
        Function1 function1 = this.clickCallback;
        if (function1 != null) {
            function1.invoke(item);
        }
        switch (a.f51119a[item.e().ordinal()]) {
            case 1:
                item.m(AdTaskState.DOWNLOADING);
                item.o(System.currentTimeMillis());
                u(item);
                updateUI(true);
                w(this, item, null, 2, null);
                return;
            case 2:
            case 7:
                return;
            case 3:
                BaseStageTaskAdHelper baseStageTaskAdHelper = this.adHelper;
                if (baseStageTaskAdHelper != null) {
                    baseStageTaskAdHelper.z(item, new Function0() { // from class: com.transsion.rewardscenter.task.ad.b0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit s11;
                            s11 = StageTaskAdView.s(v.c.this, this);
                            return s11;
                        }
                    });
                    return;
                }
                return;
            case 4:
                item.m(AdTaskState.PLAYING);
                u(item);
                updateUI(true);
                w(this, item, null, 2, null);
                return;
            case 5:
                u(item);
                return;
            case 6:
                BaseStageTaskAdHelper baseStageTaskAdHelper2 = this.adHelper;
                if (baseStageTaskAdHelper2 != null) {
                    baseStageTaskAdHelper2.z(item, new Function0() { // from class: com.transsion.rewardscenter.task.ad.c0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit t11;
                            t11 = StageTaskAdView.t(v.c.this, this);
                            return t11;
                        }
                    });
                    return;
                }
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(v.c cVar, StageTaskAdView stageTaskAdView) {
        cVar.m(AdTaskState.CLAIMED_STAGE1);
        stageTaskAdView.updateUI(true);
        w(stageTaskAdView, cVar, null, 2, null);
        return Unit.f67184a;
    }

    private final void setBtnAction(v.c item) {
        vp.l lVar = this.binding;
        if (lVar == null) {
            Intrinsics.z("binding");
            lVar = null;
        }
        AppCompatTextView appCompatTextView = lVar.f77558d;
        int i11 = a.f51119a[item.e().ordinal()];
        if (i11 == 2) {
            appCompatTextView.setText("Downloading...");
            appCompatTextView.setTextColor(getColorDownloading());
            return;
        }
        if (i11 == 3 || i11 == 6) {
            appCompatTextView.setText("Claim");
            appCompatTextView.setTextColor(getColorNormal());
        } else if (i11 != 7) {
            appCompatTextView.setText("Get Now");
            appCompatTextView.setTextColor(getColorNormal());
        } else {
            appCompatTextView.setText("Completed");
            appCompatTextView.setTextColor(getColorCompleted());
        }
    }

    private final void setProgress(v.c item) {
        long e11;
        vp.l lVar = this.binding;
        if (lVar == null) {
            Intrinsics.z("binding");
            lVar = null;
        }
        StageTaskProgressLayout stageTaskProgressLayout = lVar.f77559e;
        switch (a.f51119a[item.e().ordinal()]) {
            case 1:
                stageTaskProgressLayout.reset();
                break;
            case 2:
                stageTaskProgressLayout.setFirstStageProgress(0);
                stageTaskProgressLayout.startFirstStageAnimation();
                break;
            case 3:
                stageTaskProgressLayout.stopFirstStageAnimation();
                stageTaskProgressLayout.setFirstStageProgress(100);
                break;
            case 4:
                stageTaskProgressLayout.setFirstStageProgress(100);
                if (item.j() > 0) {
                    BaseStageTaskAdHelper baseStageTaskAdHelper = this.adHelper;
                    e11 = baseStageTaskAdHelper != null ? baseStageTaskAdHelper.e(item.c().getSceneId()) : 30000L;
                    stageTaskProgressLayout.setSecondStageProgress((int) ((item.j() < e11 ? RangesKt.l(((float) item.j()) / ((float) e11), 0.0f, 1.0f) : 1.0f) * 100));
                } else {
                    stageTaskProgressLayout.setSecondStageProgress(0);
                }
                StageTaskProgressLayout.setFirstStagePointIcon$default(stageTaskProgressLayout, false, 1, null);
                break;
            case 5:
                stageTaskProgressLayout.setFirstStageProgress(100);
                StageTaskProgressLayout.setFirstStagePointIcon$default(stageTaskProgressLayout, false, 1, null);
                BaseStageTaskAdHelper baseStageTaskAdHelper2 = this.adHelper;
                e11 = baseStageTaskAdHelper2 != null ? baseStageTaskAdHelper2.e(item.c().getSceneId()) : 30000L;
                stageTaskProgressLayout.setSecondStageProgress((int) ((item.j() < e11 ? RangesKt.l(((float) item.j()) / ((float) e11), 0.0f, 1.0f) : 1.0f) * 100));
                break;
            case 6:
                stageTaskProgressLayout.setFirstStageProgress(100);
                stageTaskProgressLayout.setSecondStageProgress(100);
                StageTaskProgressLayout.setFirstStagePointIcon$default(stageTaskProgressLayout, false, 1, null);
                break;
            case 7:
                stageTaskProgressLayout.setFirstStageProgress(100);
                stageTaskProgressLayout.setSecondStageProgress(100);
                stageTaskProgressLayout.complete();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        u uVar = u.f51176a;
        MemberTaskItem j11 = uVar.j();
        stageTaskProgressLayout.setFirstStagePoints("+" + (j11 != null ? j11.getRewardAmount() : null));
        MemberTaskItem k11 = uVar.k();
        stageTaskProgressLayout.setSecondStagePoints("+" + (k11 != null ? k11.getRewardAmount() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(v.c cVar, StageTaskAdView stageTaskAdView) {
        cVar.m(AdTaskState.COMPLETED);
        stageTaskAdView.updateUI(true);
        w(stageTaskAdView, cVar, null, 2, null);
        BaseStageTaskAdHelper baseStageTaskAdHelper = stageTaskAdView.adHelper;
        if (baseStageTaskAdHelper != null) {
            String i11 = cVar.i();
            BaseStageTaskAdHelper baseStageTaskAdHelper2 = stageTaskAdView.adHelper;
            baseStageTaskAdHelper.y(i11, baseStageTaskAdHelper2 != null ? Integer.valueOf(baseStageTaskAdHelper2.q(cVar.c().getSceneId())) : null);
        }
        return Unit.f67184a;
    }

    private final void u(v.c item) {
        NativeWrapperAdView h11 = item.h();
        if (h11 != null) {
            h11.simulatingClick(item.c(), item.d(), item.k());
        }
    }

    public static /* synthetic */ void updateUI$default(StageTaskAdView stageTaskAdView, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        stageTaskAdView.updateUI(z10);
    }

    private final void v(v.c item, AdTaskState adTaskState) {
        u.f51176a.v(item.i(), adTaskState);
    }

    static /* synthetic */ void w(StageTaskAdView stageTaskAdView, v.c cVar, AdTaskState adTaskState, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            adTaskState = cVar.e();
        }
        stageTaskAdView.v(cVar, adTaskState);
    }

    private final void x() {
        vp.l lVar = this.binding;
        if (lVar == null) {
            Intrinsics.z("binding");
            lVar = null;
        }
        AppCompatTextView btnAction = lVar.f77558d;
        Intrinsics.g(btnAction, "btnAction");
        jg.c.c(btnAction, 0L, new Function1() { // from class: com.transsion.rewardscenter.task.ad.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y10;
                y10 = StageTaskAdView.y(StageTaskAdView.this, (View) obj);
                return y10;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(StageTaskAdView stageTaskAdView, View it) {
        Intrinsics.h(it, "it");
        v.c cVar = stageTaskAdView.stageItem;
        if (cVar != null) {
            stageTaskAdView.r(cVar);
        }
        return Unit.f67184a;
    }

    public final void destroy() {
        vp.l lVar = this.binding;
        if (lVar == null) {
            Intrinsics.z("binding");
            lVar = null;
        }
        lVar.f77559e.stopFirstStageAnimation();
        this.stageItem = null;
        this.adHelper = null;
    }

    public final boolean isBind() {
        return this.stageItem != null;
    }

    public final void setAdHelper(BaseStageTaskAdHelper helper) {
        this.adHelper = helper;
    }

    public final void setClickCallback(Function1<? super v.c, Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.clickCallback = callback;
    }

    public final void setData(v.c stageItem) {
        this.stageItem = stageItem;
        if (stageItem != null) {
            updateUI$default(this, false, 1, null);
        }
    }

    public final void updateUI(boolean skipAd) {
        v.c cVar = this.stageItem;
        if (cVar != null) {
            if (!skipAd) {
                n(cVar);
            }
            setProgress(cVar);
            setBtnAction(cVar);
        }
    }
}
