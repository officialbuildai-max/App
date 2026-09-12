package com.transsion.rewardscenter.task.dada;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.cloud.config.utils.XLogUtil;
import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.widget.R$color;
import com.transsion.push.PushConstants;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.task.ad.StageTaskProgressLayout;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;
import lg.a;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJF\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\n0\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 Ji\u0010&\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020!2'\b\u0002\u0010$\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\n\u0018\u00010\u00192%\b\u0002\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010\fJ\u001b\u0010.\u001a\u00020\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\nH\u0002¢\u0006\u0004\b0\u0010\fJ%\u00106\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u0001012\f\u00105\u001a\b\u0012\u0004\u0012\u00020403¢\u0006\u0004\b6\u00107J\u0015\u00109\u001a\u00020\n2\u0006\u00108\u001a\u00020\u000e¢\u0006\u0004\b9\u0010/J\r\u0010:\u001a\u00020\n¢\u0006\u0004\b:\u0010\fJ\r\u0010;\u001a\u00020\n¢\u0006\u0004\b;\u0010\fJ\r\u0010<\u001a\u00020\u001a¢\u0006\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR$\u0010N\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010R\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010I\u001a\u0004\bP\u0010K\"\u0004\bQ\u0010MR\u001b\u0010W\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001b\u0010Z\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010T\u001a\u0004\bY\u0010VR\u001b\u0010]\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010T\u001a\u0004\b\\\u0010VR\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000e038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010?R\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010e¨\u0006g"}, d2 = {"Lcom/transsion/rewardscenter/task/dada/DadaActivateView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "x", "()V", "w", "", "getInstalledDadaPkgName", "()Ljava/lang/String;", "O", "L", "K", "v", "z", "E", "url", "packageName", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, "callback", "M", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "", EventConstants.KEY_TIME, NotificationCompat.CATEGORY_MESSAGE, "onFailure", "onSuccess", CampaignEx.JSON_KEY_AD_Q, "(JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/transsion/rewardscenter/task/dada/DadaTaskState;", "state", "setTaskState", "(Lcom/transsion/rewardscenter/task/dada/DadaTaskState;)V", "J", EventConstants.KEY_SOURCE, "H", "(Ljava/lang/String;)V", "G", "Lwp/a;", XLogUtil.TAG, "", "Lcom/transsion/rewardscenterapi/MemberTaskItem;", "tasks", "setCtxConfig", "(Lwp/a;Ljava/util/List;)V", "pkgName", "onPackageInstall", "onResume", PushConstants.PROVIDER_FIELD_DESTROY, "isCompleted", "()Z", "a", "Ljava/lang/String;", "moduleName", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lwp/a;", "ctxConfig", "Lcom/transsion/rewardscenter/task/dada/r;", "c", "Lcom/transsion/rewardscenter/task/dada/r;", "stageItem", "d", "Lcom/transsion/rewardscenterapi/MemberTaskItem;", "getStage1stTaskInfo", "()Lcom/transsion/rewardscenterapi/MemberTaskItem;", "setStage1stTaskInfo", "(Lcom/transsion/rewardscenterapi/MemberTaskItem;)V", "stage1stTaskInfo", "e", "getStage2ndTaskInfo", "setStage2ndTaskInfo", "stage2ndTaskInfo", "f", "Lkotlin/Lazy;", "getColorNormal", "()I", "colorNormal", be.g.f16474b, "getColorDownloading", "colorDownloading", "h", "getColorCompleted", "colorCompleted", "i", "Ljava/util/List;", "pkgNameList", com.mbridge.msdk.foundation.same.report.j.f35620b, "installedPkgName", "Lvp/g;", CampaignEx.JSON_KEY_AD_K, "Lvp/g;", "binding", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class DadaActivateView extends ConstraintLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String moduleName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private wp.a ctxConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private r stageItem;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MemberTaskItem stage1stTaskInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MemberTaskItem stage2ndTaskInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy colorNormal;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy colorDownloading;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy colorCompleted;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List pkgNameList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String installedPkgName;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private vp.g binding;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51221a;

        static {
            int[] iArr = new int[DadaTaskState.values().length];
            try {
                iArr[DadaTaskState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DadaTaskState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DadaTaskState.INSTALLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DadaTaskState.CLAIMED_STAGE1.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DadaTaskState.SETTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DadaTaskState.SET_DEFAULT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DadaTaskState.COMPLETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f51221a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DadaActivateView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DadaActivateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DadaActivateView(final Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.moduleName = "dada_keyboard";
        this.stageItem = new r(null, 1, null);
        this.colorNormal = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.dada.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int u11;
                u11 = DadaActivateView.u(context);
                return Integer.valueOf(u11);
            }
        });
        this.colorDownloading = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.dada.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int t11;
                t11 = DadaActivateView.t(context);
                return Integer.valueOf(t11);
            }
        });
        this.colorCompleted = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.dada.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int s11;
                s11 = DadaActivateView.s(context);
                return Integer.valueOf(s11);
            }
        });
        this.pkgNameList = CollectionsKt.o("com.dada.inputmethod", "com.dada.inputmethod.tecno", "com.dada.inputmethod.itel", "com.dada.inputmethod.infinix");
        this.installedPkgName = "";
        vp.g c11 = vp.g.c(LayoutInflater.from(context), this, true);
        Intrinsics.g(c11, "inflate(...)");
        this.binding = c11;
        x();
        w();
    }

    public /* synthetic */ DadaActivateView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(final DadaActivateView dadaActivateView, String str, boolean z10) {
        if (z10) {
            dadaActivateView.H("ps");
        } else {
            a.C0856a.f(lg.a.f68962a, "RewardsCenter", "Failed to open PalmPlay.", false, 4, null);
            N(dadaActivateView, str, null, new Function1() { // from class: com.transsion.rewardscenter.task.dada.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit B;
                    B = DadaActivateView.B(DadaActivateView.this, ((Boolean) obj).booleanValue());
                    return B;
                }
            }, 2, null);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(DadaActivateView dadaActivateView, boolean z10) {
        if (z10) {
            dadaActivateView.H("gp");
        } else {
            dadaActivateView.H("fail");
            com.transsion.rewardscenter.utils.p.a(false, "Failed to open app store.");
            a.C0856a.f(lg.a.f68962a, "RewardsCenter", "Failed to open Google Play.", false, 4, null);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(DadaActivateView dadaActivateView, String str) {
        String string = dadaActivateView.getContext().getString(R$string.dada_set_default_failed_tips);
        Intrinsics.g(string, "getString(...)");
        com.transsion.rewardscenter.utils.p.a(false, string);
        dadaActivateView.stageItem.b(DadaTaskState.CLAIMED_STAGE1);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(DadaActivateView dadaActivateView, boolean z10) {
        Integer rewardAmount;
        if (!z10) {
            Context context = dadaActivateView.getContext();
            int i11 = R$string.dada_set_default_tips;
            MemberTaskItem memberTaskItem = dadaActivateView.stage2ndTaskInfo;
            String string = context.getString(i11, Integer.valueOf((memberTaskItem == null || (rewardAmount = memberTaskItem.getRewardAmount()) == null) ? 10 : rewardAmount.intValue()));
            Intrinsics.g(string, "getString(...)");
            com.transsion.rewardscenter.utils.p.a(false, string);
            dadaActivateView.stageItem.b(DadaTaskState.CLAIMED_STAGE1);
        }
        return Unit.f67184a;
    }

    private final void E() {
        if (StringsKt.q0(getInstalledDadaPkgName())) {
            z();
        } else {
            N(this, "push://dada.com?action=openguide&utm_source=MBPoint", null, new Function1() { // from class: com.transsion.rewardscenter.task.dada.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit F;
                    F = DadaActivateView.F(((Boolean) obj).booleanValue());
                    return F;
                }
            }, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(boolean z10) {
        if (!z10) {
            com.transsion.rewardscenter.utils.p.a(false, "Failed to open app.");
        }
        return Unit.f67184a;
    }

    private final void G() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", this.moduleName);
        hashMap.put("is_installed", "1");
        hj.i.f64628a.z("broadcast", hashMap, "rewards_center");
    }

    private final void H(String source) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", this.moduleName);
        hashMap.put("ad_state", this.stageItem.a().name());
        if (source != null) {
            hashMap.put(EventConstants.KEY_SOURCE, source);
        }
        hj.i.f64628a.p("rewards_center", hashMap);
    }

    static /* synthetic */ void I(DadaActivateView dadaActivateView, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        dadaActivateView.H(str);
    }

    private final void J() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "dada_keyboard");
        hashMap.put("is_installed", !StringsKt.q0(this.installedPkgName) ? "1" : "0");
        hj.i.f64628a.D("rewards_center", hashMap);
    }

    private final void K() {
        AppCompatTextView appCompatTextView = this.binding.f77526b;
        switch (a.f51221a[this.stageItem.a().ordinal()]) {
            case 2:
                appCompatTextView.setText("Downloading...");
                appCompatTextView.setTextColor(getColorDownloading());
                return;
            case 3:
            case 6:
                appCompatTextView.setText("Claim");
                appCompatTextView.setTextColor(getColorNormal());
                return;
            case 4:
            case 5:
                appCompatTextView.setText(" Go ");
                appCompatTextView.setTextColor(getColorNormal());
                return;
            case 7:
                appCompatTextView.setText("Completed");
                appCompatTextView.setTextColor(getColorCompleted());
                return;
            default:
                appCompatTextView.setText("Get Now");
                appCompatTextView.setTextColor(getColorNormal());
                return;
        }
    }

    private final void L() {
        StageTaskProgressLayout stageTaskProgressLayout = this.binding.f77528d;
        switch (a.f51221a[this.stageItem.a().ordinal()]) {
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
                StageTaskProgressLayout.setFirstStagePointIcon$default(stageTaskProgressLayout, false, 1, null);
                break;
            case 5:
                stageTaskProgressLayout.setFirstStageProgress(100);
                StageTaskProgressLayout.setFirstStagePointIcon$default(stageTaskProgressLayout, false, 1, null);
                stageTaskProgressLayout.setSecondStageProgress(0);
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
        MemberTaskItem memberTaskItem = this.stage1stTaskInfo;
        stageTaskProgressLayout.setFirstStagePoints("+" + (memberTaskItem != null ? memberTaskItem.getRewardAmount() : null));
        MemberTaskItem memberTaskItem2 = this.stage2ndTaskInfo;
        stageTaskProgressLayout.setSecondStagePoints("+" + (memberTaskItem2 != null ? memberTaskItem2.getRewardAmount() : null));
    }

    private final void M(String url, String packageName, Function1 callback) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            if (packageName != null) {
                intent.setPackage(packageName);
            }
            intent.addFlags(ASTNode.DEOP);
            getContext().startActivity(intent);
            callback.invoke(Boolean.TRUE);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.f(lg.a.f68962a, "RewardsCenter", "--> Failed to open: " + m1188exceptionOrNullimpl, false, 4, null);
            callback.invoke(Boolean.FALSE);
        }
    }

    static /* synthetic */ void N(DadaActivateView dadaActivateView, String str, String str2, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        dadaActivateView.M(str, str2, function1);
    }

    private final void O() {
        L();
        K();
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

    private final String getInstalledDadaPkgName() {
        for (String str : this.pkgNameList) {
            com.transsion.rewardscenter.utils.o oVar = com.transsion.rewardscenter.utils.o.f51365a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            if (oVar.a(context, str)) {
                return str;
            }
        }
        return "";
    }

    private final void q(long time, Function1 onFailure, Function1 onSuccess) {
        n0 b11;
        wp.a aVar = this.ctxConfig;
        if (aVar == null || (b11 = aVar.b()) == null) {
            return;
        }
        kotlinx.coroutines.k.d(b11, null, null, new DadaActivateView$checkSetDefault$1(this, time, onFailure, onSuccess, null), 3, null);
    }

    static /* synthetic */ void r(DadaActivateView dadaActivateView, long j11, Function1 function1, Function1 function12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = 2000;
        }
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        if ((i11 & 4) != 0) {
            function12 = null;
        }
        dadaActivateView.q(j11, function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(Context context) {
        return androidx.core.content.b.getColor(context, R$color.white_50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTaskState(DadaTaskState state) {
        this.stageItem.b(state);
        O();
        q.f51239a.e(this.installedPkgName, this.stageItem.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(Context context) {
        return androidx.core.content.b.getColor(context, R$color.white_50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int u(Context context) {
        return androidx.core.content.b.getColor(context, R$color.white);
    }

    private final void v() {
        n0 b11;
        n0 b12;
        if (this.stageItem.a() != DadaTaskState.NORMAL) {
            I(this, null, 1, null);
        }
        switch (a.f51221a[this.stageItem.a().ordinal()]) {
            case 1:
                z();
                this.stageItem.b(DadaTaskState.DOWNLOADING);
                O();
                return;
            case 2:
            case 5:
            case 7:
                return;
            case 3:
                wp.a aVar = this.ctxConfig;
                if (aVar == null || (b11 = aVar.b()) == null) {
                    return;
                }
                kotlinx.coroutines.k.d(b11, null, null, new DadaActivateView$handleActionClick$1(this, null), 3, null);
                return;
            case 4:
                E();
                this.stageItem.b(DadaTaskState.SETTING);
                O();
                return;
            case 6:
                wp.a aVar2 = this.ctxConfig;
                if (aVar2 == null || (b12 = aVar2.b()) == null) {
                    return;
                }
                kotlinx.coroutines.k.d(b12, null, null, new DadaActivateView$handleActionClick$2(this, null), 3, null);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void w() {
        r rVar = this.stageItem;
        DadaTaskState c11 = q.f51239a.c(this.pkgNameList);
        if (c11 == null) {
            c11 = DadaTaskState.NORMAL;
        }
        rVar.b(c11);
        a.C0856a.f(lg.a.f68962a, "RewardsCenter", "check DaDa task state, taskState = " + this.stageItem, false, 4, null);
        this.installedPkgName = getInstalledDadaPkgName();
        if ((this.stageItem.a() == DadaTaskState.NORMAL || this.stageItem.a() == DadaTaskState.DOWNLOADING) && !StringsKt.q0(this.installedPkgName)) {
            setTaskState(DadaTaskState.INSTALLED);
        }
        J();
    }

    private final void x() {
        StageTaskProgressLayout stageTaskProgressLayout = this.binding.f77528d;
        String string = getResources().getString(R$string.dada_first_stage);
        Intrinsics.g(string, "getString(...)");
        stageTaskProgressLayout.setFirstStageText(string);
        StageTaskProgressLayout stageTaskProgressLayout2 = this.binding.f77528d;
        String string2 = getResources().getString(R$string.dada_second_stage);
        Intrinsics.g(string2, "getString(...)");
        stageTaskProgressLayout2.setSecondStageText(string2);
        AppCompatTextView btnAction = this.binding.f77526b;
        Intrinsics.g(btnAction, "btnAction");
        jg.c.c(btnAction, 0L, new Function1() { // from class: com.transsion.rewardscenter.task.dada.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y10;
                y10 = DadaActivateView.y(DadaActivateView.this, (View) obj);
                return y10;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(DadaActivateView dadaActivateView, View it) {
        Intrinsics.h(it, "it");
        dadaActivateView.v();
        return Unit.f67184a;
    }

    private final void z() {
        final String str = "https://play.google.com/store/apps/details?id=com.dada.inputmethod&referrer=MBPoint";
        M("palmplay://thirdlauncher.com/?entryType=AppDetail&packageName=com.dada.inputmethod&_source=CrossPro_MBPonit_dada&referrer=CrossPro_MBPoint_dada", MiniAppIpcConfig.PALM_STORE_PACKAGE_NAME, new Function1() { // from class: com.transsion.rewardscenter.task.dada.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit A;
                A = DadaActivateView.A(DadaActivateView.this, str, ((Boolean) obj).booleanValue());
                return A;
            }
        });
    }

    public final void destroy() {
        this.binding.f77528d.stopFirstStageAnimation();
        this.ctxConfig = null;
    }

    public final MemberTaskItem getStage1stTaskInfo() {
        return this.stage1stTaskInfo;
    }

    public final MemberTaskItem getStage2ndTaskInfo() {
        return this.stage2ndTaskInfo;
    }

    public final boolean isCompleted() {
        return this.stageItem.a() == DadaTaskState.COMPLETED;
    }

    public final void onPackageInstall(String pkgName) {
        Intrinsics.h(pkgName, "pkgName");
        if (this.pkgNameList.contains(pkgName)) {
            this.installedPkgName = pkgName;
            if (this.stageItem.a() == DadaTaskState.NORMAL || this.stageItem.a() == DadaTaskState.DOWNLOADING) {
                setTaskState(DadaTaskState.INSTALLED);
                G();
            }
        }
    }

    public final void onResume() {
        if (this.stageItem.a() == DadaTaskState.SETTING) {
            r(this, 0L, new Function1() { // from class: com.transsion.rewardscenter.task.dada.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit C;
                    C = DadaActivateView.C(DadaActivateView.this, (String) obj);
                    return C;
                }
            }, new Function1() { // from class: com.transsion.rewardscenter.task.dada.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit D;
                    D = DadaActivateView.D(DadaActivateView.this, ((Boolean) obj).booleanValue());
                    return D;
                }
            }, 1, null);
        }
    }

    public final void setCtxConfig(wp.a config, List<MemberTaskItem> tasks) {
        Object obj;
        Object obj2;
        Intrinsics.h(tasks, "tasks");
        this.ctxConfig = config;
        List<MemberTaskItem> list = tasks;
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            Integer taskSubType = ((MemberTaskItem) obj2).getTaskSubType();
            int value = TaskType.DADA_STAGE_1ST.getValue();
            if (taskSubType != null && taskSubType.intValue() == value) {
                break;
            }
        }
        this.stage1stTaskInfo = (MemberTaskItem) obj2;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            Integer taskSubType2 = ((MemberTaskItem) next).getTaskSubType();
            int value2 = TaskType.DADA_STAGE_2ND.getValue();
            if (taskSubType2 != null && taskSubType2.intValue() == value2) {
                obj = next;
                break;
            }
        }
        this.stage2ndTaskInfo = (MemberTaskItem) obj;
        if (this.stageItem.a() == DadaTaskState.CLAIMED_STAGE1) {
            r(this, 0L, null, null, 6, null);
        }
        a.C0856a.f(lg.a.f68962a, "RewardsCenter", "---> setCtxConfig state:" + this.stageItem.a(), false, 4, null);
        O();
    }

    public final void setStage1stTaskInfo(MemberTaskItem memberTaskItem) {
        this.stage1stTaskInfo = memberTaskItem;
    }

    public final void setStage2ndTaskInfo(MemberTaskItem memberTaskItem) {
        this.stage2ndTaskInfo = memberTaskItem;
    }
}
