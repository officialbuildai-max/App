package com.transsnet.downloader.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.DubsInfoData;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.PushConstants;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$style;
import com.transsnet.downloader.dialog.DownloadAudioTrackSelectDialog;
import com.transsnet.downloader.dialog.DownloadSeasonsSelectFragment;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadDialogShowEvent;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 i2\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014Jo\u0010 \u001a\u00020\u00042`\u0010\u001f\u001a\\\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0004\b \u0010!J0\u0010%\u001a\u00020\u00042!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00040\"¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0003J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000eH\u0016¢\u0006\u0004\b)\u0010\u0011J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J!\u00104\u001a\u00020\u00042\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010;R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010;R\u0018\u0010K\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010;R\u0016\u0010M\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010;R\u0016\u0010O\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010;R\u0018\u0010Q\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010;R\u0018\u0010S\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010;R\u0018\u0010U\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010;R\u0016\u0010X\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010WR\u0016\u0010\\\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010WRr\u0010_\u001a^\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R3\u0010b\u001a\u001f\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010>¨\u0006k"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadReDetectorMainDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "", "initViewModel", "", NativeComponentConstants.KEY_COMPONENT_TYPE, "B0", "(I)V", "t0", "Landroidx/fragment/app/Fragment;", "s0", "(I)Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "count", "", "formatSize", "Lcom/transsion/baselib/db/download/DownloadBean;", "downloadBean", "", "isCancel", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "z0", "(Lkotlin/jvm/functions/Function4;)V", "Lkotlin/Function1;", "Lmy/b;", "info", "A0", "(Lkotlin/jvm/functions/Function1;)V", "onDestroy", "outState", "onSaveInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "Landroidx/fragment/app/FragmentManager;", "manager", "tag", PushConstants.PUSH_SERVICE_TYPE_SHOW, "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "c", "Ljava/lang/String;", "resourceFrom", "d", "I", "basePageType", "e", "curPageType", "f", "linkUrl", "Lcom/transsion/moviedetailapi/bean/Subject;", be.g.f16474b, "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "h", "subjectId", "i", "groupId", com.mbridge.msdk.foundation.same.report.j.f35620b, "pageFrom", CampaignEx.JSON_KEY_AD_K, "lastPageFrom", "l", "ops", "m", "targetResourceId", "n", "moduleName", "o", "Z", "scroll2Download", TtmlNode.TAG_P, "dialogStyle", CampaignEx.JSON_KEY_AD_Q, "animationExecuteDownload", CampaignEx.JSON_KEY_AD_R, "Lkotlin/jvm/functions/Function4;", "analysingSuccessListener", "s", "Lkotlin/jvm/functions/Function1;", "pathSelectListener", "Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", "t", "Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", "viewModel", TmcStartParams.KEY_URL_SHORT, "season", "v", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadReDetectorMainDialog extends BaseDialog {

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String resourceFrom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int basePageType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int curPageType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String linkUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Subject subject;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String subjectId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String pageFrom;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String targetResourceId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean scroll2Download;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean dialogStyle;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean animationExecuteDownload;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private Function4 analysingSuccessListener;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Function1 pathSelectListener;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private DownloadResourcesDetectorViewModel viewModel;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int season;

    /* renamed from: com.transsnet.downloader.fragment.DownloadReDetectorMainDialog$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorMainDialog a(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, String str7, int i11, boolean z10) {
            DownloadReDetectorMainDialog downloadReDetectorMainDialog = new DownloadReDetectorMainDialog();
            if (subject != null) {
                Integer subjectType = subject.getSubjectType();
                SubjectType.EDUCATION.getValue();
                if (subjectType != null) {
                    subjectType.intValue();
                }
            }
            downloadReDetectorMainDialog.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_download_page_type", 2), TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_group_id", str3), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_ops", str4), TuplesKt.a("extra_resource", str5), TuplesKt.a("extra_target_resource_id", str6), TuplesKt.a("extra_module_name", str7), TuplesKt.a("extra_season", Integer.valueOf(i11)), TuplesKt.a("extra_dialog_style", Boolean.valueOf(z10))));
            return downloadReDetectorMainDialog;
        }

        public final DownloadReDetectorMainDialog b(String str, String str2, String str3, Subject subject, String str4, String resourceFrom, String str5) {
            Intrinsics.h(resourceFrom, "resourceFrom");
            DownloadReDetectorMainDialog downloadReDetectorMainDialog = new DownloadReDetectorMainDialog();
            downloadReDetectorMainDialog.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_download_page_type", 3), TuplesKt.a("extra_page_from", str2), TuplesKt.a("extra_last_page_from", str3), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_link_url", str), TuplesKt.a("extra_ops", str4), TuplesKt.a("extra_resource", resourceFrom), TuplesKt.a("extra_module_name", str5)));
            return downloadReDetectorMainDialog;
        }

        public final DownloadReDetectorMainDialog c() {
            DownloadReDetectorMainDialog downloadReDetectorMainDialog = new DownloadReDetectorMainDialog();
            downloadReDetectorMainDialog.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_download_page_type", 4)));
            return downloadReDetectorMainDialog;
        }

        public final DownloadReDetectorMainDialog d(String resourceFrom, String str) {
            Intrinsics.h(resourceFrom, "resourceFrom");
            DownloadReDetectorMainDialog downloadReDetectorMainDialog = new DownloadReDetectorMainDialog();
            downloadReDetectorMainDialog.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_download_page_type", 1), TuplesKt.a("extra_resource", resourceFrom), TuplesKt.a("extra_module_name", str)));
            return downloadReDetectorMainDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59069a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59069a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59069a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59069a.invoke(obj);
        }
    }

    public DownloadReDetectorMainDialog() {
        super(R$layout.dialog_download_res_main);
        this.basePageType = 1;
        this.curPageType = 1;
        this.pageFrom = "";
        this.lastPageFrom = "";
        this.dialogStyle = true;
    }

    private final void B0(int type) {
        String str;
        String str2 = "download_ana_single_resources";
        switch (type) {
            case 2:
                str2 = "download_ana_series";
                break;
            case 3:
                str2 = "download_ana_animation";
                break;
            case 4:
                str2 = "download_path_setting";
                break;
            case 5:
                str2 = "download_short_tv";
                break;
            case 6:
                str2 = "download_short_tv_ad";
                break;
            case 7:
                str2 = "download_edu";
                break;
            case 8:
                str2 = "season_list";
                break;
            case 9:
                str2 = "audio_track";
                break;
        }
        a.C0856a.f(lg.a.f68962a, "DownloadReDetectorMainDialog", "showFragment tag = " + str2, false, 4, null);
        if (this.basePageType == 3 && (str = this.linkUrl) != null && str.length() != 0 && (type == 1 || type == 2 || type == 7)) {
            this.basePageType = type;
        }
        this.curPageType = type;
        setCancelable((type == 3 || type == 6) ? false : true);
        t0();
        Fragment k02 = getChildFragmentManager().k0(str2);
        if (k02 == null) {
            k02 = s0(type);
        }
        if (k02.isAdded()) {
            getChildFragmentManager().p().y(k02).l();
        } else {
            getChildFragmentManager().p().c(R$id.fl_container, k02, str2).l();
        }
    }

    private final void initViewModel() {
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = (DownloadResourcesDetectorViewModel) new androidx.view.v0(this).a(DownloadResourcesDetectorViewModel.class);
        downloadResourcesDetectorViewModel.p().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.a3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u02;
                u02 = DownloadReDetectorMainDialog.u0(DownloadReDetectorMainDialog.this, (Integer) obj);
                return u02;
            }
        }));
        downloadResourcesDetectorViewModel.m().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.b3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v02;
                v02 = DownloadReDetectorMainDialog.v0(DownloadReDetectorMainDialog.this, (Boolean) obj);
                return v02;
            }
        }));
        downloadResourcesDetectorViewModel.B().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.c3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x02;
                x02 = DownloadReDetectorMainDialog.x0(DownloadReDetectorMainDialog.this, (my.b) obj);
                return x02;
            }
        }));
        this.viewModel = downloadResourcesDetectorViewModel;
    }

    private final Fragment s0(int type) {
        androidx.view.b0 y10;
        androidx.view.b0 n11;
        r0 = null;
        DubsInfoData dubsInfoData = null;
        switch (type) {
            case 2:
                return DownloadReDetectorGroupMainFragment.INSTANCE.a(this.pageFrom, this.lastPageFrom, this.subject, this.groupId, this.ops, this.targetResourceId, this.moduleName, this.season, this.dialogStyle);
            case 3:
                return DownloadReDetectorAnalysingFragment.INSTANCE.a(this.linkUrl, this.subject, this.pageFrom, this.lastPageFrom, this.ops, this.resourceFrom, Boolean.valueOf(this.animationExecuteDownload), this.moduleName);
            case 4:
                return DownloadReDetectorPathSettingFragment.INSTANCE.a(this.basePageType);
            case 5:
                return DownloadReDetectorShortTVFragment.INSTANCE.a(this.pageFrom, this.lastPageFrom, this.subject, this.subjectId, this.groupId, this.ops, this.moduleName, this.scroll2Download);
            case 6:
                return DownloadReDetectorShortTVADFragment.INSTANCE.a();
            case 7:
                return DownloadReDetectorMultiFragment.INSTANCE.a(this.pageFrom, this.lastPageFrom, this.subject, this.groupId, this.ops, this.targetResourceId, this.moduleName, this.season);
            case 8:
                DownloadSeasonsSelectFragment.Companion companion = DownloadSeasonsSelectFragment.INSTANCE;
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = this.viewModel;
                ResourcesSeasonList resourcesSeasonList = (downloadResourcesDetectorViewModel == null || (y10 = downloadResourcesDetectorViewModel.y()) == null) ? null : (ResourcesSeasonList) y10.f();
                Subject subject = this.subject;
                return companion.a(resourcesSeasonList, subject != null ? subject.getSubjectType() : null, this.dialogStyle);
            case 9:
                DownloadAudioTrackSelectDialog.Companion companion2 = DownloadAudioTrackSelectDialog.INSTANCE;
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel2 = this.viewModel;
                if (downloadResourcesDetectorViewModel2 != null && (n11 = downloadResourcesDetectorViewModel2.n()) != null) {
                    dubsInfoData = (DubsInfoData) n11.f();
                }
                return companion2.a(dubsInfoData, this.dialogStyle);
            default:
                return DownloadReDetectorSingleResFragment.INSTANCE.a(this.moduleName);
        }
    }

    private final void t0() {
        List y02 = getChildFragmentManager().y0();
        Intrinsics.g(y02, "getFragments(...)");
        Iterator it = y02.iterator();
        while (it.hasNext()) {
            getChildFragmentManager().p().p((Fragment) it.next()).l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(DownloadReDetectorMainDialog downloadReDetectorMainDialog, Integer num) {
        Intrinsics.e(num);
        downloadReDetectorMainDialog.B0(num.intValue());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(final DownloadReDetectorMainDialog downloadReDetectorMainDialog, Boolean bool) {
        androidx.view.b0 i11;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = downloadReDetectorMainDialog.viewModel;
        if (downloadResourcesDetectorViewModel != null && (i11 = downloadResourcesDetectorViewModel.i()) != null) {
            i11.j(downloadReDetectorMainDialog, new b(new Function1() { // from class: com.transsnet.downloader.fragment.d3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit w02;
                    w02 = DownloadReDetectorMainDialog.w0(DownloadReDetectorMainDialog.this, (com.transsnet.downloader.viewmodel.b) obj);
                    return w02;
                }
            }));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(DownloadReDetectorMainDialog downloadReDetectorMainDialog, com.transsnet.downloader.viewmodel.b bVar) {
        DownloadBean b11 = bVar.b();
        Subject subject = downloadReDetectorMainDialog.subject;
        b11.setGenre(subject != null ? subject.getGenre() : null);
        DownloadBean b12 = bVar.b();
        Subject subject2 = downloadReDetectorMainDialog.subject;
        b12.setCurrentDubLanName(subject2 != null ? subject2.currentDubLandName() : null);
        DownloadBean b13 = bVar.b();
        Subject subject3 = downloadReDetectorMainDialog.subject;
        b13.setCurrentDubLanCode(subject3 != null ? subject3.currentDubLandCode() : null);
        Function4 function4 = downloadReDetectorMainDialog.analysingSuccessListener;
        if (function4 != null) {
            function4.invoke(Integer.valueOf(bVar.a()), bVar.c(), bVar.b(), Boolean.valueOf(bVar.d()));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(DownloadReDetectorMainDialog downloadReDetectorMainDialog, my.b bVar) {
        Function1 function1;
        if (bVar != null && (function1 = downloadReDetectorMainDialog.pathSelectListener) != null) {
            function1.invoke(bVar);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y0(DownloadReDetectorMainDialog downloadReDetectorMainDialog, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        if (i11 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        int i12 = downloadReDetectorMainDialog.curPageType;
        if (i12 == 3) {
            a.C0856a.f(lg.a.f68962a, "DownloadReDetectorMainDialog", "back click~  anima do nothing", false, 4, null);
            return true;
        }
        if (i12 != downloadReDetectorMainDialog.basePageType) {
            a.C0856a.f(lg.a.f68962a, "DownloadReDetectorMainDialog", "back click~ show base", false, 4, null);
            downloadReDetectorMainDialog.B0(downloadReDetectorMainDialog.basePageType);
        } else {
            a.C0856a.f(lg.a.f68962a, "DownloadReDetectorMainDialog", "back click~ dismiss", false, 4, null);
            downloadReDetectorMainDialog.dismissAllowingStateLoss();
        }
        return true;
    }

    public final void A0(Function1 listener) {
        Intrinsics.h(listener, "listener");
        this.pathSelectListener = listener;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public hj.b newLogViewConfig() {
        return new hj.b("download_main_dialog", false);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String string;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null ? savedInstanceState.getBoolean("key_download_save_instance") : false) {
            dismissAllowingStateLoss();
            return;
        }
        a.C0856a.f(lg.a.f68962a, "premium_d", "DownloadReDetectorMainDialog --> onCreate()", false, 4, null);
        setStyle(0, R$style.DownloadBottomDialogTheme);
        Bundle arguments = getArguments();
        String str9 = "";
        if (arguments == null || (str = arguments.getString("extra_resource")) == null) {
            str = "";
        }
        this.resourceFrom = str;
        Bundle arguments2 = getArguments();
        this.basePageType = arguments2 != null ? arguments2.getInt("extra_download_page_type") : 1;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str2 = arguments3.getString("extra_page_from")) == null) {
            str2 = "";
        }
        this.pageFrom = str2;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str3 = arguments4.getString("extra_last_page_from")) == null) {
            str3 = "";
        }
        this.lastPageFrom = str3;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str4 = arguments5.getString("extra_group_id")) == null) {
            str4 = "";
        }
        this.groupId = str4;
        Bundle arguments6 = getArguments();
        this.subject = (Subject) (arguments6 != null ? arguments6.getSerializable("extra_subject") : null);
        Bundle arguments7 = getArguments();
        if (arguments7 == null || (str5 = arguments7.getString("extra_link_url")) == null) {
            str5 = "";
        }
        this.linkUrl = str5;
        Bundle arguments8 = getArguments();
        if (arguments8 == null || (str6 = arguments8.getString("extra_ops")) == null) {
            str6 = "";
        }
        this.ops = str6;
        Bundle arguments9 = getArguments();
        if (arguments9 == null || (str7 = arguments9.getString("extra_target_resource_id")) == null) {
            str7 = "";
        }
        this.targetResourceId = str7;
        Bundle arguments10 = getArguments();
        this.animationExecuteDownload = arguments10 != null ? arguments10.getBoolean("extra_download_execute_download", false) : false;
        Bundle arguments11 = getArguments();
        if (arguments11 == null || (str8 = arguments11.getString("extra_module_name")) == null) {
            str8 = "";
        }
        this.moduleName = str8;
        Bundle arguments12 = getArguments();
        if (arguments12 != null && (string = arguments12.getString("extra_subject_id")) != null) {
            str9 = string;
        }
        this.subjectId = str9;
        Bundle arguments13 = getArguments();
        this.scroll2Download = arguments13 != null ? arguments13.getBoolean("extra_download_scroll_to_download", false) : false;
        Bundle arguments14 = getArguments();
        this.season = arguments14 != null ? arguments14.getInt("extra_season") : 0;
        Bundle arguments15 = getArguments();
        this.dialogStyle = arguments15 != null ? arguments15.getBoolean("extra_dialog_style") : true;
        initViewModel();
        B0(this.basePageType);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "onCreateDialog(...)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BottomShowAnimation);
            window.setGravity(80);
            window.setDimAmount(this.dialogStyle ? 0.5f : 0.0f);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = -1;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.transsnet.downloader.fragment.z2
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                boolean y02;
                y02 = DownloadReDetectorMainDialog.y0(DownloadReDetectorMainDialog.this, dialogInterface, i11, keyEvent);
                return y02;
            }
        });
        return onCreateDialog;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        aVar.a().Y(null);
        aVar.a().b0(null);
        super.onDestroy();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        DownloadDialogShowEvent downloadDialogShowEvent = new DownloadDialogShowEvent(false);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadDialogShowEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, downloadDialogShowEvent, 0L);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("key_download_save_instance", true);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        Intrinsics.h(manager, "manager");
        super.show(manager, tag);
        DownloadDialogShowEvent downloadDialogShowEvent = new DownloadDialogShowEvent(true);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadDialogShowEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, downloadDialogShowEvent, 0L);
    }

    public final void z0(Function4 listener) {
        Intrinsics.h(listener, "listener");
        this.analysingSuccessListener = listener;
    }
}
