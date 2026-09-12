package com.transsion.player.longvideo.ui.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.v;
import androidx.view.v0;
import androidx.view.x0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.cloud.config.utils.XLogUtil;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.PlaybackRecordDao;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.constants.LongVodPlayerConfigType;
import com.transsion.player.longvideo.member.LongVodResolutionMemberView;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsnet.downloader.R$style;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import hj.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JC\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b!\u0010\"R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000204038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010,R0\u0010?\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020;0:j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020;`<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010/\u001a\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/transsion/player/longvideo/ui/dialog/LongVdPlayerConfigDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Lgo/b;", XLogUtil.TAG, "Lgo/a;", "longVdPlayerBean", "", "A0", "(Lgo/b;Lgo/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "F0", "(Lgo/b;)V", "", "dialogName", "x0", "(Ljava/lang/String;)V", "pageName", "Lcom/transsion/player/longvideo/constants/LongVodPlayerConfigType;", "configType", "", "dataList", "Lcom/transsion/player/longvideo/ui/LongVodPlayerView;", "longVodPlayerView", "G0", "(Ljava/lang/String;Lcom/transsion/player/longvideo/constants/LongVodPlayerConfigType;Ljava/util/List;Lgo/a;Lcom/transsion/player/longvideo/ui/LongVodPlayerView;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "c", "Lcom/transsion/player/longvideo/ui/LongVodPlayerView;", "d", "Lgo/a;", "e", "Ljava/lang/String;", "f", "Lcom/transsion/player/longvideo/constants/LongVodPlayerConfigType;", be.g.f16474b, "Ljava/util/List;", "Lcom/transsion/player/longvideo/ui/dialog/a;", "h", "Lkotlin/Lazy;", "y0", "()Lcom/transsion/player/longvideo/ui/dialog/a;", "configViewModel", "", "", "i", "[Ljava/lang/Float;", "speedConfigs", j.f35620b, "configs", "Ljava/util/HashMap;", "Lcom/transsion/player/longvideo/member/LongVodResolutionMemberView;", "Lkotlin/collections/HashMap;", CampaignEx.JSON_KEY_AD_K, "Ljava/util/HashMap;", "itemViewMap", "l", "Lgo/b;", "curConfig", "Lcom/transsion/baselib/db/video/PlaybackRecordDao;", "m", "z0", "()Lcom/transsion/baselib/db/video/PlaybackRecordDao;", "playbackRecordDao", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class LongVdPlayerConfigDialog extends BaseDialog {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private LongVodPlayerView longVodPlayerView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private go.a longVdPlayerBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LongVodPlayerConfigType configType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private List dataList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy configViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Float[] speedConfigs;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private List configs;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final HashMap itemViewMap;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private go.b curConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy playbackRecordDao;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48382a;

        static {
            int[] iArr = new int[LongVodPlayerConfigType.values().length];
            try {
                iArr[LongVodPlayerConfigType.SPEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LongVodPlayerConfigType.BITRATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f48382a = iArr;
        }
    }

    public LongVdPlayerConfigDialog() {
        super(R$layout.long_vod_dialog_player_config);
        this.configType = LongVodPlayerConfigType.BITRATE;
        this.configViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.player.longvideo.ui.dialog.a.class), new Function0<x0>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
                Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$special$$inlined$activityViewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                v0.c defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.speedConfigs = new Float[]{Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.25f), Float.valueOf(1.5f), Float.valueOf(1.75f), Float.valueOf(2.0f)};
        this.configs = new ArrayList();
        this.itemViewMap = new HashMap();
        this.playbackRecordDao = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlaybackRecordDao E0;
                E0 = LongVdPlayerConfigDialog.E0();
                return E0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A0(go.b r13, go.a r14, kotlin.coroutines.Continuation r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$isIntercept$1
            if (r0 == 0) goto L13
            r0 = r15
            com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$isIntercept$1 r0 = (com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$isIntercept$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$isIntercept$1 r0 = new com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$isIntercept$1
            r0.<init>(r12, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            r5 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r13 = r0.L$1
            r14 = r13
            go.a r14 = (go.a) r14
            java.lang.Object r13 = r0.L$0
            go.b r13 = (go.b) r13
            kotlin.ResultKt.b(r15)
            goto L79
        L34:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3c:
            kotlin.ResultKt.b(r15)
            com.transsion.player.longvideo.constants.LongVodPlayerConfigType r15 = r12.configType
            com.transsion.player.longvideo.constants.LongVodPlayerConfigType r2 = com.transsion.player.longvideo.constants.LongVodPlayerConfigType.BITRATE
            if (r15 == r2) goto L4a
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r13
        L4a:
            java.lang.Class<com.transsion.memberapi.IPremiumApi> r15 = com.transsion.memberapi.IPremiumApi.class
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.Object r15 = com.therouter.TheRouter.d(r15, r2)
            com.transsion.memberapi.IPremiumApi r15 = (com.transsion.memberapi.IPremiumApi) r15
            if (r15 == 0) goto L5b
            boolean r15 = r15.c()
            goto L5c
        L5b:
            r15 = r5
        L5c:
            if (r15 == 0) goto L63
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r13
        L63:
            kotlinx.coroutines.i0 r15 = kotlinx.coroutines.y0.b()
            com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$isIntercept$isUnlocked$1 r2 = new com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$isIntercept$isUnlocked$1
            r2.<init>(r12, r14, r4)
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r3
            java.lang.Object r15 = kotlinx.coroutines.i.g(r15, r2, r0)
            if (r15 != r1) goto L79
            return r1
        L79:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L92
            lg.a$a r6 = lg.a.f68962a
            r10 = 4
            r11 = 0
            java.lang.String r7 = "premium_p"
            java.lang.String r8 = "LongVdPlayerConfigDialog --> isIntercept() --> 当前已经解锁，不拦截"
            r9 = 0
            lg.a.C0856a.f(r6, r7, r8, r9, r10, r11)
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r13
        L92:
            com.transsion.player.longvideo.intercept.h0 r15 = com.transsion.player.longvideo.intercept.h0.f48193a
            if (r14 == 0) goto L9b
            com.transsion.moviedetailapi.bean.Subject r0 = r14.m()
            goto L9c
        L9b:
            r0 = r4
        L9c:
            java.lang.String r13 = r13.d()
            boolean r13 = r15.e(r0, r13)
            if (r14 == 0) goto Laa
            com.transsion.moviedetailapi.bean.Subject r4 = r14.m()
        Laa:
            if (r14 == 0) goto Lb1
            int r14 = r14.e()
            goto Lb2
        Lb1:
            r14 = r5
        Lb2:
            boolean r14 = r15.c(r4, r14)
            if (r14 == 0) goto Lc9
            lg.a$a r6 = lg.a.f68962a
            r10 = 4
            r11 = 0
            java.lang.String r7 = "premium_p"
            java.lang.String r8 = "LongVdPlayerConfigDialog --> isIntercept() --> 当前是免费剧集不拦截"
            r9 = 0
            lg.a.C0856a.f(r6, r7, r8, r9, r10, r11)
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r13
        Lc9:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog.A0(go.b, go.a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable B0(go.b it) {
        Intrinsics.h(it, "it");
        return Integer.valueOf(it.d().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable C0(go.b it) {
        Intrinsics.h(it, "it");
        return it.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(LongVdPlayerConfigDialog longVdPlayerConfigDialog, go.b bVar, View view) {
        LifecycleCoroutineScope a11;
        FragmentActivity activity = longVdPlayerConfigDialog.getActivity();
        AppCompatActivity appCompatActivity = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        k.d(a11, null, null, new LongVdPlayerConfigDialog$onViewCreated$1$1$1(bVar, longVdPlayerConfigDialog, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlaybackRecordDao E0() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).v1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(go.b config) {
        if (config.e()) {
            return;
        }
        LongVodResolutionMemberView longVodResolutionMemberView = (LongVodResolutionMemberView) this.itemViewMap.get(this.curConfig);
        if (longVodResolutionMemberView != null) {
            longVodResolutionMemberView.setTextColor(-1);
        }
        LongVodResolutionMemberView longVodResolutionMemberView2 = (LongVodResolutionMemberView) this.itemViewMap.get(config);
        if (longVodResolutionMemberView2 != null) {
            longVodResolutionMemberView2.setGradientColorsV2(config, this.longVdPlayerBean);
        }
        this.curConfig = config;
        y0().c(config);
        dismiss();
    }

    private final void x0(String dialogName) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", dialogName);
        String str = this.pageName;
        if (str != null) {
            i.f64628a.r(str, hashMap);
        }
    }

    private final com.transsion.player.longvideo.ui.dialog.a y0() {
        return (com.transsion.player.longvideo.ui.dialog.a) this.configViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlaybackRecordDao z0() {
        return (PlaybackRecordDao) this.playbackRecordDao.getValue();
    }

    public final void G0(String pageName, LongVodPlayerConfigType configType, List dataList, go.a longVdPlayerBean, LongVodPlayerView longVodPlayerView) {
        Intrinsics.h(configType, "configType");
        Intrinsics.h(longVodPlayerView, "longVodPlayerView");
        this.pageName = pageName;
        this.configType = configType;
        this.dataList = dataList;
        this.longVdPlayerBean = longVdPlayerBean;
        this.longVodPlayerView = longVodPlayerView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.DownloadBottomDialogTheme);
        int i11 = a.f48382a[this.configType.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            x0("dialog_stream_resolution");
            List<go.b> list = this.dataList;
            if (list != null) {
                for (go.b bVar : list) {
                    this.configs.add(bVar);
                    if (bVar.e()) {
                        this.curConfig = bVar;
                    }
                }
                CollectionsKt.A(this.configs, ComparisonsKt.b(new Function1() { // from class: com.transsion.player.longvideo.ui.dialog.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Comparable B0;
                        B0 = LongVdPlayerConfigDialog.B0((go.b) obj);
                        return B0;
                    }
                }, new Function1() { // from class: com.transsion.player.longvideo.ui.dialog.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Comparable C0;
                        C0 = LongVdPlayerConfigDialog.C0((go.b) obj);
                        return C0;
                    }
                }));
                return;
            }
            return;
        }
        x0("dialog_stream_speed");
        float a11 = com.transsion.player.longvideo.helper.v.f48084a.a();
        this.configs.clear();
        for (Float f11 : this.speedConfigs) {
            float floatValue = f11.floatValue();
            go.b bVar2 = new go.b(a11 == floatValue, String.valueOf(floatValue), LongVodPlayerConfigType.SPEED);
            this.configs.add(bVar2);
            if (bVar2.e()) {
                this.curConfig = bVar2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ll_root);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.blankj.utilcode.util.i.e(48.0f));
        Iterator it = this.configs.iterator();
        while (true) {
            AttributeSet attributeSet = null;
            Object[] objArr = 0;
            if (!it.hasNext()) {
                break;
            }
            final go.b bVar = (go.b) it.next();
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            LongVodResolutionMemberView longVodResolutionMemberView = new LongVodResolutionMemberView(context, attributeSet, 2, objArr == true ? 1 : 0);
            longVodResolutionMemberView.setConfig(bVar, this.longVdPlayerBean);
            longVodResolutionMemberView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LongVdPlayerConfigDialog.D0(LongVdPlayerConfigDialog.this, bVar, view2);
                }
            });
            linearLayout.addView(longVodResolutionMemberView, layoutParams);
            this.itemViewMap.put(bVar, longVodResolutionMemberView);
        }
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(jg.c.f() ? com.tn.lib.widget.R$style.ActionSheetDialogLeft : com.tn.lib.widget.R$style.ActionSheetDialogRight);
        window.setGravity(jg.c.f() ? GravityCompat.START : GravityCompat.END);
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(null);
        window.setLayout(a0.a(140.0f), -1);
        ImmersionBar with = ImmersionBar.with((DialogFragment) this);
        with.hideBar(BarHide.FLAG_HIDE_BAR);
        with.init();
    }
}
