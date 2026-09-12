package com.transsnet.downloader.ugc.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.b0;
import androidx.view.c0;
import androidx.view.v;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.therouter.TheRouter;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.dialog.BaseViewBindingDialog;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCategory;
import com.transsion.ugcvideodetail.api.bean.UGCVideoDownload;
import com.transsion.ugcvideodetail.api.bean.UGCVideoDownloadResource;
import com.transsion.wrapperad.view.DownloadMovieAdView;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.R$style;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.ugc.util.UGCDownloadResolutionBean;
import com.transsnet.downloader.ugc.viewmodel.UGCDownloadViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import py.c1;
import zm.a;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u008d\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u008e\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\u001f\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u001d\u0010\u001d\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0018J\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010\u0004J\u0011\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b'\u0010(J#\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002¢\u0006\u0004\b*\u0010+J\u001d\u0010-\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\fH\u0002¢\u0006\u0004\b-\u0010\u0018J\u0017\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u001bH\u0002¢\u0006\u0004\b/\u00100J;\u00106\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u00010&2\u0006\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010&2\u0006\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020)H\u0002¢\u0006\u0004\b6\u00107J%\u0010;\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u001b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000509H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u001eH\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00052\u0006\u00101\u001a\u00020&H\u0002¢\u0006\u0004\b?\u0010@J\u0019\u0010C\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001a\u00020\u00052\u0006\u0010E\u001a\u00020AH\u0016¢\u0006\u0004\bF\u0010DJ\u0019\u0010H\u001a\u00020G2\b\u0010B\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0004\bH\u0010IJ!\u0010J\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010B\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0004\bJ\u0010KJo\u0010R\u001a\u00020\u00052`\u0010Q\u001a\\\u0012\u0013\u0012\u00110\u001b¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110&¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0013\u0012\u00110)¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\t¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u00050L¢\u0006\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010UR\u0018\u0010\\\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010UR\u0018\u0010^\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010UR\u0016\u00102\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010UR\u0016\u0010a\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010UR\u0018\u00103\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010UR\u0018\u0010d\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010UR\u0018\u0010f\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010UR\u0018\u0010h\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010UR\u0016\u0010k\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001b\u0010q\u001a\u00020l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xRr\u0010|\u001a^\u0012\u0013\u0012\u00110\u001b¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110&¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0013\u0012\u00110)¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\t¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u0005\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u001d\u0010\u0081\u0001\u001a\u00020}8BX\u0082\u0084\u0002¢\u0006\r\n\u0004\b~\u0010n\u001a\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0086\u0001\u001a\u00030\u0082\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0083\u0001\u0010n\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R4\u0010\u008c\u0001\u001a\u001f\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0089\u0001\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001¨\u0006\u008f\u0001"}, d2 = {"Lcom/transsnet/downloader/ugc/dialog/UGCDownloadDialog;", "Lcom/transsion/baseui/dialog/BaseViewBindingDialog;", "Lpy/c1;", "<init>", "()V", "", "initView", "initListener", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoDownload;", "", "j1", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideoDownload;)Z", "", "Q0", "()Ljava/util/List;", "", "R0", "()Ljava/util/Set;", "y1", "initViewModel", "m1", "A1", "list", "q1", "(Ljava/util/List;)V", "currentList", "z1", "", "resolutions", "J0", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "t1", "(Landroid/view/View;)V", "showLoading", "hideLoading", "k1", "r1", "", "S0", "()Ljava/lang/String;", "Lcom/transsion/baselib/db/download/DownloadBean;", "L0", "(Ljava/util/Set;)Ljava/util/List;", "downloadList", "w1", "count", "o1", "(I)V", "pageName", "pageFrom", "ops", "taskId", "downloadBean", "O0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/baselib/db/download/DownloadBean;)V", "resolution", "Lkotlin/Function0;", "successCallback", "K0", "(ILkotlin/jvm/functions/Function0;)V", "M0", "()Landroid/view/View;", "n1", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "formatSize", "isCancel", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "s1", "(Lkotlin/jvm/functions/Function4;)V", "d", "Ljava/lang/String;", "collectionId", "e", "ugcVideoId", "f", "collectionName", be.g.f16474b, "category", "h", "subjectId", "i", com.mbridge.msdk.foundation.same.report.j.f35620b, "lastPageFrom", CampaignEx.JSON_KEY_AD_K, "l", "trackId", "m", "previousTrackId", "n", "previousPageVideoId", "o", "Z", "isImmVerticalVideo", "Lcom/transsnet/downloader/ugc/viewmodel/UGCDownloadViewModel;", TtmlNode.TAG_P, "Lkotlin/Lazy;", "U0", "()Lcom/transsnet/downloader/ugc/viewmodel/UGCDownloadViewModel;", "viewModel", "Lcom/transsnet/downloader/ugc/adapter/a;", CampaignEx.JSON_KEY_AD_Q, "Lcom/transsnet/downloader/ugc/adapter/a;", "downloadAdapter", "Lcom/transsnet/downloader/ugc/adapter/b;", CampaignEx.JSON_KEY_AD_R, "Lcom/transsnet/downloader/ugc/adapter/b;", "epTabAdapter", "s", "Lkotlin/jvm/functions/Function4;", "downloadSuccessListener", "Lcom/transsnet/downloader/manager/g;", "t", "P0", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "Lcom/transsnet/downloader/manager/StartDownloadHelper;", TmcStartParams.KEY_URL_SHORT, "T0", "()Lcom/transsnet/downloader/manager/StartDownloadHelper;", "startDownloadHelper", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "n0", "()Lkotlin/jvm/functions/Function3;", "bindingInflater", "v", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class UGCDownloadDialog extends BaseViewBindingDialog<c1> {

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String collectionId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String ugcVideoId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String collectionName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String category;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String subjectId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String pageFrom = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String trackId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String previousTrackId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String previousPageVideoId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isImmVerticalVideo;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private com.transsnet.downloader.ugc.adapter.a downloadAdapter;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private com.transsnet.downloader.ugc.adapter.b epTabAdapter;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Function4 downloadSuccessListener;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadManager;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Lazy startDownloadHelper;

    /* renamed from: com.transsnet.downloader.ugc.dialog.UGCDownloadDialog$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCDownloadDialog a(String collectionId, String str, String str2, String str3, String lastPageFrom, String str4, String str5, String str6, String str7, String str8, String str9, boolean z10) {
            Intrinsics.h(collectionId, "collectionId");
            Intrinsics.h(lastPageFrom, "lastPageFrom");
            UGCDownloadDialog uGCDownloadDialog = new UGCDownloadDialog();
            uGCDownloadDialog.setArguments(androidx.core.os.d.b(TuplesKt.a("collection_id", collectionId), TuplesKt.a("COLLECTION_NAME", str), TuplesKt.a("CATEGORY", str2), TuplesKt.a("PAGE_FROM", str3), TuplesKt.a("LAST_PAGE_FROM", lastPageFrom), TuplesKt.a("OPS", str4), TuplesKt.a("SUBJECT_ID", str5), TuplesKt.a("ugc_video_id", str6), TuplesKt.a("TRACK_ID", str7), TuplesKt.a("PREVIOUS_TRACK_ID", str8), TuplesKt.a("PREVIOUS_PAGE_VIDEO_ID", str9), TuplesKt.a("IS_IMM_VERTICAL_VIDEO", Boolean.valueOf(z10))));
            return uGCDownloadDialog;
        }

        public final UGCDownloadDialog b(String ugcVideoId, String str, String str2, String lastPageFrom, String str3, String str4, String str5, String str6, String str7, boolean z10) {
            Intrinsics.h(ugcVideoId, "ugcVideoId");
            Intrinsics.h(lastPageFrom, "lastPageFrom");
            UGCDownloadDialog uGCDownloadDialog = new UGCDownloadDialog();
            uGCDownloadDialog.setArguments(androidx.core.os.d.b(TuplesKt.a("ugc_video_id", ugcVideoId), TuplesKt.a("CATEGORY", str), TuplesKt.a("PAGE_FROM", str2), TuplesKt.a("LAST_PAGE_FROM", lastPageFrom), TuplesKt.a("OPS", str3), TuplesKt.a("SUBJECT_ID", str4), TuplesKt.a("TRACK_ID", str5), TuplesKt.a("PREVIOUS_TRACK_ID", str6), TuplesKt.a("PREVIOUS_PAGE_VIDEO_ID", str7), TuplesKt.a("IS_IMM_VERTICAL_VIDEO", Boolean.valueOf(z10))));
            return uGCDownloadDialog;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements zm.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0 f59771a;

        b(Function0 function0) {
            this.f59771a = function0;
        }

        @Override // zm.a
        public void a(MemberCheckResult memberCheckResult) {
            a.C1007a.f(this, memberCheckResult);
        }

        @Override // zm.a
        public void b(MemberCheckResult memberCheckResult) {
            a.C1007a.d(this, memberCheckResult);
        }

        @Override // zm.a
        public void c(MemberCheckResult memberCheckResult) {
            a.C1007a.g(this, memberCheckResult);
        }

        @Override // zm.a
        public void d(MemberCheckResult memberCheckResult) {
            a.C1007a.e(this, memberCheckResult);
        }

        @Override // zm.a
        public void e() {
            a.C1007a.c(this);
            this.f59771a.invoke();
        }

        @Override // zm.a
        public void f(MemberCheckResult memberCheckResult) {
            a.C1007a.a(this, memberCheckResult);
        }

        @Override // zm.a
        public void onFail(String errorMsg) {
            Intrinsics.h(errorMsg, "errorMsg");
            a.C1007a.b(this, errorMsg);
            a.C0856a.f(lg.a.f68962a, "co_mem", "DownloadResolutionTabView --> initRvAndAdapter() --> 剧集选择分辨率 -->  " + errorMsg, false, 4, null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends RecyclerView.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f59772a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f59773b;

        c(int i11, int i12) {
            this.f59772a = i11;
            this.f59773b = i12;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            int itemCount = (adapter != null ? adapter.getItemCount() : 0) - 1;
            if (childAdapterPosition == 0) {
                outRect.left = this.f59772a;
                outRect.right = this.f59773b;
            } else if (childAdapterPosition == itemCount) {
                outRect.left = this.f59773b;
                outRect.right = this.f59772a;
            } else {
                int i11 = this.f59773b;
                outRect.left = i11;
                outRect.right = i11;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59774a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59774a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59774a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59774a.invoke(obj);
        }
    }

    public UGCDownloadDialog() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsnet.downloader.ugc.dialog.UGCDownloadDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UGCDownloadViewModel.class), new Function0<x0>() { // from class: com.transsnet.downloader.ugc.dialog.UGCDownloadDialog$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsnet.downloader.ugc.dialog.UGCDownloadDialog$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object invoke = Function0.this.invoke();
                androidx.view.m mVar = invoke instanceof androidx.view.m ? (androidx.view.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.downloadManager = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.ugc.dialog.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsnet.downloader.manager.g N0;
                N0 = UGCDownloadDialog.N0();
                return N0;
            }
        });
        this.startDownloadHelper = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.ugc.dialog.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                StartDownloadHelper x12;
                x12 = UGCDownloadDialog.x1();
                return x12;
            }
        });
    }

    private final void A1() {
        AppCompatImageView appCompatImageView;
        List Q0 = Q0();
        c1 c1Var = (c1) getViewBinding();
        if (c1Var == null || (appCompatImageView = c1Var.f72766j) == null) {
            return;
        }
        appCompatImageView.setSelected(!Q0.isEmpty() && R0().size() == Q0.size());
    }

    private final void J0(List resolutions) {
        BLLinearLayout bLLinearLayout;
        TextView textView;
        BLLinearLayout bLLinearLayout2;
        if (resolutions.isEmpty() || resolutions.size() == 1) {
            c1 c1Var = (c1) getViewBinding();
            if (c1Var != null && (bLLinearLayout = c1Var.f72760d) != null) {
                jg.c.g(bLLinearLayout);
            }
            String str = this.collectionId;
            if (str != null) {
                showLoading();
                U0().q().q(CollectionsKt.k0(resolutions));
                U0().F(str, null, "1", (Integer) CollectionsKt.k0(resolutions));
                return;
            }
            return;
        }
        List list = resolutions;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Number) it.next()).intValue() + "P");
        }
        List U0 = CollectionsKt.U0(arrayList);
        int indexOf = resolutions.indexOf(Integer.valueOf(com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0)));
        if (indexOf < 0) {
            indexOf = 0;
        }
        Integer num = (Integer) CollectionsKt.l0(resolutions, indexOf);
        U0().q().q(num);
        if (num != null) {
            int intValue = num.intValue();
            if (this.collectionId != null) {
                Map map = (Map) U0().s().f();
                List list2 = map != null ? (List) map.get(Integer.valueOf(intValue)) : null;
                List list3 = list2;
                if (list3 == null || list3.isEmpty()) {
                    showLoading();
                    UGCDownloadViewModel U02 = U0();
                    String str2 = this.collectionId;
                    Intrinsics.e(str2);
                    U02.F(str2, null, "1", Integer.valueOf(intValue));
                } else {
                    U0().o().q(list2);
                }
            } else if (this.ugcVideoId != null) {
                b0 b0Var = (b0) U0().u().get(Integer.valueOf(intValue));
                Map map2 = b0Var != null ? (Map) b0Var.f() : null;
                List list4 = map2 != null ? (List) map2.get("tab") : null;
                List list5 = list4;
                if (list5 != null && !list5.isEmpty()) {
                    U0().p().q(list4);
                    if (Intrinsics.c(U0().C().f(), Boolean.TRUE)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : list4) {
                            UGCVideoDownload uGCVideoDownload = (UGCVideoDownload) obj;
                            com.transsnet.downloader.ugc.adapter.a aVar = this.downloadAdapter;
                            if (!(aVar != null ? aVar.E1(uGCVideoDownload) : false)) {
                                arrayList2.add(obj);
                            }
                        }
                        U0().L(CollectionsKt.W0(arrayList2));
                    } else {
                        U0().N();
                    }
                }
            }
        }
        c1 c1Var2 = (c1) getViewBinding();
        if (c1Var2 != null && (bLLinearLayout2 = c1Var2.f72760d) != null) {
            jg.c.k(bLLinearLayout2);
        }
        c1 c1Var3 = (c1) getViewBinding();
        if (c1Var3 == null || (textView = c1Var3.f72776t) == null) {
            return;
        }
        String str3 = (String) CollectionsKt.l0(U0, indexOf);
        if (str3 == null) {
            str3 = "";
        }
        textView.setText(str3);
    }

    private final void K0(int resolution, Function0 successCallback) {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (!(iMemberApi != null ? iMemberApi.B() : false)) {
            successCallback.invoke();
            return;
        }
        IMemberApi iMemberApi2 = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi2 != null) {
            iMemberApi2.o(Integer.valueOf(resolution), new b(successCallback));
        }
    }

    private final List L0(Set list) {
        String resolutions;
        Integer v11;
        String url;
        int A = this.collectionId != null ? U0().A() : 1;
        String S0 = S0();
        Set<UGCVideoDownload> set = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(set, 10));
        for (UGCVideoDownload uGCVideoDownload : set) {
            UGCVideoDownloadResource resource = uGCVideoDownload.getResource();
            String str = "";
            String str2 = (resource == null || (url = resource.getUrl()) == null) ? "" : url;
            UGCVideoDownloadResource resource2 = uGCVideoDownload.getResource();
            String id2 = resource2 != null ? resource2.getId() : null;
            String title = uGCVideoDownload.getTitle();
            Cover cover = uGCVideoDownload.getCover();
            String url2 = cover != null ? cover.getUrl() : null;
            UGCVideoDownloadResource resource3 = uGCVideoDownload.getResource();
            Long size = resource3 != null ? resource3.getSize() : null;
            Cover cover2 = uGCVideoDownload.getCover();
            String thumbnail = cover2 != null ? cover2.getThumbnail() : null;
            UGCVideoDownloadResource resource4 = uGCVideoDownload.getResource();
            int intValue = (resource4 == null || (resolutions = resource4.getResolutions()) == null || (v11 = StringsKt.v(resolutions)) == null) ? 0 : v11.intValue();
            UGCVideoDownloadResource resource5 = uGCVideoDownload.getResource();
            long duration = (resource5 != null ? resource5.getDuration() : 0L) * 1000;
            UGCVideoDownloadResource resource6 = uGCVideoDownload.getResource();
            String idType = resource6 != null ? resource6.getIdType() : null;
            String ugcVideoId = uGCVideoDownload.getUgcVideoId();
            int videoUGCPosition = uGCVideoDownload.videoUGCPosition();
            String str3 = this.collectionId;
            String title2 = uGCVideoDownload.getTitle();
            String str4 = this.category;
            if (str4 == null) {
                str4 = uGCVideoDownload.getCategory();
            }
            String str5 = str4;
            UGCVideoCategory cateLev1 = uGCVideoDownload.getCateLev1();
            Integer id3 = cateLev1 != null ? cateLev1.getId() : null;
            UGCVideoCategory cateLev2 = uGCVideoDownload.getCateLev2();
            Integer id4 = cateLev2 != null ? cateLev2.getId() : null;
            UGCVideoCategory cateLev3 = uGCVideoDownload.getCateLev3();
            Integer id5 = cateLev3 != null ? cateLev3.getId() : null;
            UGCVideoCategory cateLev4 = uGCVideoDownload.getCateLev4();
            Integer id6 = cateLev4 != null ? cateLev4.getId() : null;
            DownloadBean downloadBean = new DownloadBean(str2, id2, title, url2, size, null, null, null, Long.valueOf(duration), null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, intValue, 0, 0, 0, 0, 0, 0, this.subjectId, this.pageFrom, this.lastPageFrom, null, 0L, 0, A, null, null, 0L, null, null, 0L, 0, 0L, null, 0, thumbnail, null, false, false, 0, null, null, null, null, this.ops, null, null, null, null, null, null, null, null, idType, str3, ugcVideoId, title2, S0, Integer.valueOf(videoUGCPosition), str5, id3, id4, id5, id6, this.trackId, this.previousPageVideoId, this.previousTrackId, null, false, null, ak.o.f721a.d(), -940572960, 1071640573, 28672, null);
            downloadBean.setTaskId(UUID.randomUUID().toString());
            UGCVideoDownloadResource resource7 = uGCVideoDownload.getResource();
            downloadBean.setSubtitleIdType(resource7 != null ? resource7.getIdType() : null);
            String pageFrom = downloadBean.getPageFrom();
            String lastPageFrom = downloadBean.getLastPageFrom();
            if (lastPageFrom != null) {
                str = lastPageFrom;
            }
            String ops = downloadBean.getOps();
            String taskId = downloadBean.getTaskId();
            Intrinsics.e(taskId);
            ArrayList arrayList2 = arrayList;
            String str6 = S0;
            O0(pageFrom, str, ops, taskId, downloadBean);
            lg.a.f68962a.p("download", new String[]{"UGC视频，开始下载: collectionId = " + this.collectionId + ",collectionName：" + str6 + " subjectId = " + downloadBean.getSubjectId() + ", resourceId = " + downloadBean.getResourceId() + ", name = " + downloadBean.getName()}, true);
            arrayList2.add(downloadBean);
            arrayList = arrayList2;
            S0 = str6;
        }
        return arrayList;
    }

    private final View M0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        StateView.showData$default(stateView, 2, 6, false, "", null, 16, null);
        return stateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g N0() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x00a3, code lost:
    
        if (r4 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void O0(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.transsion.baselib.db.download.DownloadBean r19) {
        /*
            r14 = this;
            java.lang.String r0 = "page_from"
            r1 = r16
            kotlin.Pair r0 = kotlin.TuplesKt.a(r0, r1)
            java.lang.String r1 = "ops"
            r2 = r17
            kotlin.Pair r1 = kotlin.TuplesKt.a(r1, r2)
            java.lang.String r2 = r19.getResourceId()
            java.lang.String r3 = "resource_id"
            kotlin.Pair r2 = kotlin.TuplesKt.a(r3, r2)
            java.lang.String r4 = "task_id"
            r5 = r18
            kotlin.Pair r4 = kotlin.TuplesKt.a(r4, r5)
            java.lang.String r5 = "refer_subject_id"
            java.lang.String r6 = r19.getSubjectId()
            kotlin.Pair r5 = kotlin.TuplesKt.a(r5, r6)
            java.lang.String r6 = "content_id"
            java.lang.String r7 = r19.getUgcVideoId()
            kotlin.Pair r6 = kotlin.TuplesKt.a(r6, r7)
            java.lang.String r7 = "belong_to_collection_id"
            java.lang.String r8 = r19.getUgcVideoCollectionId()
            kotlin.Pair r7 = kotlin.TuplesKt.a(r7, r8)
            java.lang.String r8 = "category_type"
            java.lang.String r9 = r19.getUgcVideoType()
            kotlin.Pair r8 = kotlin.TuplesKt.a(r8, r9)
            java.lang.String r9 = "video_track_id"
            java.lang.String r10 = r19.getUgcVideoTrackId()
            kotlin.Pair r9 = kotlin.TuplesKt.a(r9, r10)
            java.lang.String r10 = "video_parent_content_id"
            java.lang.String r11 = r19.getUgcVideoParentVideoId()
            kotlin.Pair r10 = kotlin.TuplesKt.a(r10, r11)
            java.lang.String r11 = "video_parent_video_track_id"
            java.lang.String r12 = r19.getUgcVideoParentTrackId()
            kotlin.Pair r11 = kotlin.TuplesKt.a(r11, r12)
            r12 = 11
            kotlin.Pair[] r12 = new kotlin.Pair[r12]
            r13 = 0
            r12[r13] = r0
            r0 = 1
            r12[r0] = r1
            r0 = 2
            r12[r0] = r2
            r0 = 3
            r12[r0] = r4
            r0 = 4
            r12[r0] = r5
            r0 = 5
            r12[r0] = r6
            r0 = 6
            r12[r0] = r7
            r0 = 7
            r12[r0] = r8
            r0 = 8
            r12[r0] = r9
            r0 = 9
            r12[r0] = r10
            r0 = 10
            r12[r0] = r11
            java.util.Map r0 = kotlin.collections.MapsKt.l(r12)
            hj.i r1 = hj.i.f64628a
            java.lang.String r2 = "download_click"
            if (r15 == 0) goto La5
            boolean r4 = kotlin.text.StringsKt.q0(r15)
            if (r4 != 0) goto La2
            r4 = r15
            goto La3
        La2:
            r4 = 0
        La3:
            if (r4 != 0) goto La6
        La5:
            r4 = r2
        La6:
            r1.s(r4, r2, r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = r19.getResourceId()
            r0.putString(r3, r1)
            com.transsion.baselib.report.e r1 = com.transsion.baselib.report.e.f43398a
            android.content.Context r3 = r14.getContext()
            r1.l(r2, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.ugc.dialog.UGCDownloadDialog.O0(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.transsion.baselib.db.download.DownloadBean):void");
    }

    private final com.transsnet.downloader.manager.g P0() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
    }

    private final List Q0() {
        List list = (List) U0().p().f();
        if (list == null) {
            return CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (j1((UGCVideoDownload) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final Set R0() {
        Set set = (Set) U0().x().f();
        if (set != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : set) {
                if (j1((UGCVideoDownload) obj)) {
                    arrayList.add(obj);
                }
            }
            Set W0 = CollectionsKt.W0(arrayList);
            if (W0 != null) {
                return W0;
            }
        }
        return SetsKt.f();
    }

    private final String S0() {
        String str = this.collectionName;
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        UGCCollection uGCCollection = (UGCCollection) U0().n().f();
        if (uGCCollection != null) {
            return uGCCollection.getTitle();
        }
        return null;
    }

    private final StartDownloadHelper T0() {
        return (StartDownloadHelper) this.startDownloadHelper.getValue();
    }

    private final UGCDownloadViewModel U0() {
        return (UGCDownloadViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(UGCDownloadDialog uGCDownloadDialog, View view) {
        uGCDownloadDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(UGCDownloadDialog uGCDownloadDialog, View view) {
        Intrinsics.e(view);
        uGCDownloadDialog.t1(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(UGCDownloadDialog uGCDownloadDialog, View view) {
        uGCDownloadDialog.y1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(UGCDownloadDialog uGCDownloadDialog, View view) {
        uGCDownloadDialog.y1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(UGCDownloadDialog uGCDownloadDialog, View view) {
        DownloadMovieAdView downloadMovieAdView;
        uGCDownloadDialog.k1();
        c1 c1Var = (c1) uGCDownloadDialog.getViewBinding();
        if (c1Var == null || (downloadMovieAdView = c1Var.f72782z) == null) {
            return;
        }
        downloadMovieAdView.download();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String a1(UGCDownloadDialog uGCDownloadDialog, UGCVideoDownload item) {
        Intrinsics.h(item, "item");
        return uGCDownloadDialog.U0().t(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(UGCDownloadDialog uGCDownloadDialog, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        UGCVideoDownload uGCVideoDownload = item instanceof UGCVideoDownload ? (UGCVideoDownload) item : null;
        if (uGCVideoDownload != null && uGCDownloadDialog.j1(uGCVideoDownload)) {
            uGCDownloadDialog.U0().O(uGCVideoDownload);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(UGCDownloadDialog uGCDownloadDialog, com.transsnet.downloader.ugc.adapter.b bVar, BaseQuickAdapter adapter, View view, int i11) {
        String str;
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        String str2 = item instanceof String ? (String) item : null;
        if (str2 == null || (str = uGCDownloadDialog.collectionId) == null) {
            return;
        }
        bVar.D1(i11);
        uGCDownloadDialog.U0().I(str, str2, String.valueOf(i11 + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(final UGCDownloadDialog uGCDownloadDialog, List list) {
        List list2;
        RecyclerView recyclerView;
        uGCDownloadDialog.hideLoading();
        com.transsnet.downloader.ugc.adapter.a aVar = uGCDownloadDialog.downloadAdapter;
        if (aVar != null) {
            aVar.n1(list);
        }
        com.transsnet.downloader.ugc.adapter.a aVar2 = uGCDownloadDialog.downloadAdapter;
        List<Object> data = aVar2 != null ? aVar2.getData() : null;
        if ((data == null || data.isEmpty()) && ((list2 = list) == null || list2.isEmpty())) {
            View M0 = uGCDownloadDialog.M0();
            com.transsnet.downloader.ugc.adapter.a aVar3 = uGCDownloadDialog.downloadAdapter;
            if (aVar3 != null) {
                aVar3.Y0(M0);
            }
        }
        c1 c1Var = (c1) uGCDownloadDialog.getViewBinding();
        if (c1Var != null && (recyclerView = c1Var.f72772p) != null) {
            recyclerView.post(new Runnable() { // from class: com.transsnet.downloader.ugc.dialog.h
                @Override // java.lang.Runnable
                public final void run() {
                    UGCDownloadDialog.e1(UGCDownloadDialog.this);
                }
            });
        }
        uGCDownloadDialog.z1(list);
        if (Intrinsics.c(uGCDownloadDialog.U0().C().f(), Boolean.TRUE)) {
            uGCDownloadDialog.U0().L(CollectionsKt.W0(uGCDownloadDialog.Q0()));
        } else {
            uGCDownloadDialog.m1();
            uGCDownloadDialog.q1(list);
        }
        uGCDownloadDialog.A1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(UGCDownloadDialog uGCDownloadDialog) {
        RecyclerView recyclerView;
        c1 c1Var = (c1) uGCDownloadDialog.getViewBinding();
        if (c1Var == null || (recyclerView = c1Var.f72772p) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(UGCDownloadDialog uGCDownloadDialog, List list) {
        RecyclerView recyclerView;
        List l11;
        com.transsnet.downloader.ugc.adapter.b bVar;
        List<Object> data;
        RecyclerView recyclerView2;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            c1 c1Var = (c1) uGCDownloadDialog.getViewBinding();
            if (c1Var != null && (recyclerView = c1Var.f72773q) != null) {
                jg.c.g(recyclerView);
            }
            return Unit.f67184a;
        }
        c1 c1Var2 = (c1) uGCDownloadDialog.getViewBinding();
        if (c1Var2 != null && (recyclerView2 = c1Var2.f72773q) != null) {
            jg.c.k(recyclerView2);
        }
        com.transsnet.downloader.ugc.adapter.b bVar2 = uGCDownloadDialog.epTabAdapter;
        if (bVar2 == null || (data = bVar2.getData()) == null || (l11 = CollectionsKt.R0(data)) == null) {
            l11 = CollectionsKt.l();
        }
        com.transsnet.downloader.ugc.adapter.b bVar3 = uGCDownloadDialog.epTabAdapter;
        if (bVar3 != null) {
            bVar3.n1(CollectionsKt.U0(list2));
        }
        if (!Intrinsics.c(l11, list) && (bVar = uGCDownloadDialog.epTabAdapter) != null) {
            bVar.D1(0);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(UGCDownloadDialog uGCDownloadDialog, Set set) {
        LinearLayoutCompat linearLayoutCompat;
        c1 c1Var = (c1) uGCDownloadDialog.getViewBinding();
        if (c1Var != null && (linearLayoutCompat = c1Var.f72759c) != null) {
            Set set2 = set;
            linearLayoutCompat.setAlpha((set2 == null || set2.isEmpty()) ? 0.5f : 1.0f);
        }
        Set<String> y10 = uGCDownloadDialog.U0().y();
        com.transsnet.downloader.ugc.adapter.a aVar = uGCDownloadDialog.downloadAdapter;
        if (aVar != null) {
            aVar.H1(y10);
        }
        uGCDownloadDialog.A1();
        uGCDownloadDialog.m1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(UGCDownloadDialog uGCDownloadDialog, String str) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        if (str == null || str.length() == 0) {
            c1 c1Var = (c1) uGCDownloadDialog.getViewBinding();
            if (c1Var != null && (appCompatTextView = c1Var.f72774r) != null) {
                appCompatTextView.setText(Utils.a().getString(R$string.str_download));
            }
        } else {
            c1 c1Var2 = (c1) uGCDownloadDialog.getViewBinding();
            if (c1Var2 != null && (appCompatTextView2 = c1Var2.f72774r) != null) {
                appCompatTextView2.setText(Utils.a().getString(R$string.str_download) + " · " + str);
            }
        }
        return Unit.f67184a;
    }

    private final void hideLoading() {
        BLFrameLayout bLFrameLayout;
        c1 c1Var = (c1) getViewBinding();
        if (c1Var == null || (bLFrameLayout = c1Var.f72764h) == null) {
            return;
        }
        jg.c.g(bLFrameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(UGCDownloadDialog uGCDownloadDialog, List list) {
        Intrinsics.e(list);
        uGCDownloadDialog.J0(list);
        return Unit.f67184a;
    }

    private final void initListener() {
        LinearLayoutCompat linearLayoutCompat;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        BLLinearLayout bLLinearLayout;
        ImageView imageView;
        c1 c1Var = (c1) getViewBinding();
        if (c1Var != null && (imageView = c1Var.f72767k) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.ugc.dialog.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UGCDownloadDialog.V0(UGCDownloadDialog.this, view);
                }
            });
        }
        c1 c1Var2 = (c1) getViewBinding();
        if (c1Var2 != null && (bLLinearLayout = c1Var2.f72760d) != null) {
            bLLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.ugc.dialog.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UGCDownloadDialog.W0(UGCDownloadDialog.this, view);
                }
            });
        }
        c1 c1Var3 = (c1) getViewBinding();
        if (c1Var3 != null && (appCompatTextView = c1Var3.f72778v) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.ugc.dialog.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UGCDownloadDialog.X0(UGCDownloadDialog.this, view);
                }
            });
        }
        c1 c1Var4 = (c1) getViewBinding();
        if (c1Var4 != null && (appCompatImageView = c1Var4.f72766j) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.ugc.dialog.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UGCDownloadDialog.Y0(UGCDownloadDialog.this, view);
                }
            });
        }
        c1 c1Var5 = (c1) getViewBinding();
        if (c1Var5 == null || (linearLayoutCompat = c1Var5.f72759c) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.ugc.dialog.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCDownloadDialog.Z0(UGCDownloadDialog.this, view);
            }
        });
    }

    private final void initView() {
        DownloadMovieAdView downloadMovieAdView;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        BLConstraintLayout bLConstraintLayout;
        ViewGroup.LayoutParams layoutParams;
        int height = requireActivity().getWindow().getDecorView().getHeight();
        c1 c1Var = (c1) getViewBinding();
        if (c1Var != null && (bLConstraintLayout = c1Var.f72761e) != null && (layoutParams = bLConstraintLayout.getLayoutParams()) != null) {
            layoutParams.height = (height - ((y.e() * 9) / 16)) - (Build.VERSION.SDK_INT >= 35 ? com.blankj.utilcode.util.d.a() : 0);
        }
        final com.transsnet.downloader.ugc.adapter.b bVar = new com.transsnet.downloader.ugc.adapter.b(new ArrayList());
        bVar.w1(new p6.d() { // from class: com.transsnet.downloader.ugc.dialog.a
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCDownloadDialog.c1(UGCDownloadDialog.this, bVar, baseQuickAdapter, view, i11);
            }
        });
        this.epTabAdapter = bVar;
        c1 c1Var2 = (c1) getViewBinding();
        if (c1Var2 != null && (recyclerView2 = c1Var2.f72773q) != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
            recyclerView2.setAdapter(this.epTabAdapter);
            recyclerView2.addItemDecoration(new c(dk.a.b(12), dk.a.b(8)));
        }
        com.transsnet.downloader.ugc.adapter.a aVar = new com.transsnet.downloader.ugc.adapter.a();
        aVar.F1(new Function1() { // from class: com.transsnet.downloader.ugc.dialog.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String a12;
                a12 = UGCDownloadDialog.a1(UGCDownloadDialog.this, (UGCVideoDownload) obj);
                return a12;
            }
        });
        aVar.w1(new p6.d() { // from class: com.transsnet.downloader.ugc.dialog.m
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCDownloadDialog.b1(UGCDownloadDialog.this, baseQuickAdapter, view, i11);
            }
        });
        this.downloadAdapter = aVar;
        c1 c1Var3 = (c1) getViewBinding();
        if (c1Var3 != null && (recyclerView = c1Var3.f72772p) != null) {
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(this.downloadAdapter);
        }
        c1 c1Var4 = (c1) getViewBinding();
        if (c1Var4 == null || (downloadMovieAdView = c1Var4.f72782z) == null) {
            return;
        }
        DownloadMovieAdView.loadAd$default(downloadMovieAdView, null, 1, null);
    }

    private final void initViewModel() {
        RecyclerView recyclerView;
        U0().p().j(this, new d(new Function1() { // from class: com.transsnet.downloader.ugc.dialog.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d12;
                d12 = UGCDownloadDialog.d1(UGCDownloadDialog.this, (List) obj);
                return d12;
            }
        }));
        U0().o().j(this, new d(new Function1() { // from class: com.transsnet.downloader.ugc.dialog.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f12;
                f12 = UGCDownloadDialog.f1(UGCDownloadDialog.this, (List) obj);
                return f12;
            }
        }));
        U0().x().j(this, new d(new Function1() { // from class: com.transsnet.downloader.ugc.dialog.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g12;
                g12 = UGCDownloadDialog.g1(UGCDownloadDialog.this, (Set) obj);
                return g12;
            }
        }));
        U0().B().j(this, new d(new Function1() { // from class: com.transsnet.downloader.ugc.dialog.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h12;
                h12 = UGCDownloadDialog.h1(UGCDownloadDialog.this, (String) obj);
                return h12;
            }
        }));
        U0().w().j(this, new d(new Function1() { // from class: com.transsnet.downloader.ugc.dialog.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i12;
                i12 = UGCDownloadDialog.i1(UGCDownloadDialog.this, (List) obj);
                return i12;
            }
        }));
        if (this.collectionId == null) {
            if (this.ugcVideoId != null) {
                c1 c1Var = (c1) getViewBinding();
                if (c1Var != null && (recyclerView = c1Var.f72773q) != null) {
                    jg.c.g(recyclerView);
                }
                showLoading();
                UGCDownloadViewModel U0 = U0();
                String str = this.ugcVideoId;
                Intrinsics.e(str);
                U0.G(str);
                return;
            }
            return;
        }
        showLoading();
        UGCDownloadViewModel U02 = U0();
        String str2 = this.collectionId;
        Intrinsics.e(str2);
        U02.E(str2);
        List list = (List) U0().w().f();
        if (list == null || list.isEmpty()) {
            return;
        }
        int indexOf = list.indexOf(Integer.valueOf(com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0)));
        Integer num = (Integer) CollectionsKt.l0(list, indexOf >= 0 ? indexOf : 0);
        if (num == null) {
            num = (Integer) CollectionsKt.k0(list);
        }
        U0().q().q(num);
        UGCDownloadViewModel U03 = U0();
        String str3 = this.collectionId;
        Intrinsics.e(str3);
        U03.F(str3, null, "1", num);
    }

    private final boolean j1(UGCVideoDownload uGCVideoDownload) {
        return !(this.downloadAdapter != null ? r0.E1(uGCVideoDownload) : false);
    }

    private final void k1() {
        UGCVideoDownloadResource resource;
        String resolutions;
        Integer v11;
        final Set set = (Set) U0().x().f();
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
            return;
        }
        Set set2 = set;
        if (set2 == null || set2.isEmpty()) {
            uh.b.f76876a.d(R$string.download_unselected_tips);
            return;
        }
        int i11 = 0;
        if (this.collectionId != null) {
            Integer num = (Integer) U0().q().f();
            if (num != null) {
                i11 = num.intValue();
            }
        } else {
            UGCVideoDownload uGCVideoDownload = (UGCVideoDownload) CollectionsKt.j0(set);
            if (uGCVideoDownload != null && (resource = uGCVideoDownload.getResource()) != null && (resolutions = resource.getResolutions()) != null && (v11 = StringsKt.v(resolutions)) != null) {
                i11 = v11.intValue();
            }
        }
        K0(i11, new Function0() { // from class: com.transsnet.downloader.ugc.dialog.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit l12;
                l12 = UGCDownloadDialog.l1(UGCDownloadDialog.this, set);
                return l12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(UGCDownloadDialog uGCDownloadDialog, Set set) {
        uGCDownloadDialog.r1();
        List L0 = uGCDownloadDialog.L0(set);
        uGCDownloadDialog.w1(L0);
        uGCDownloadDialog.o1(L0.size());
        return Unit.f67184a;
    }

    private final void m1() {
        Set set = (Set) U0().x().f();
        if (set == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (j1((UGCVideoDownload) obj)) {
                arrayList.add(obj);
            }
        }
        Set W0 = CollectionsKt.W0(arrayList);
        if (W0.size() != set.size()) {
            U0().L(W0);
        }
    }

    private final void n1(String pageName) {
        hj.i.f64628a.r(pageName, MapsKt.f(TuplesKt.a("dialog_name", "download")));
    }

    private final void o1(final int count) {
        ProgressBar progressBar;
        long min = Math.min(((count / 20) * 100) + 300, 2000L);
        c1 c1Var = (c1) getViewBinding();
        if (c1Var == null || (progressBar = c1Var.f72771o) == null) {
            return;
        }
        progressBar.postDelayed(new Runnable() { // from class: com.transsnet.downloader.ugc.dialog.k
            @Override // java.lang.Runnable
            public final void run() {
                UGCDownloadDialog.p1(UGCDownloadDialog.this, count);
            }
        }, min);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:6:0x001b, B:8:0x0025, B:10:0x002b, B:13:0x0036, B:15:0x003c, B:16:0x0042, B:18:0x004c, B:19:0x0052, B:21:0x0058, B:22:0x0061, B:24:0x0067, B:25:0x0070, B:29:0x0081, B:31:0x0093, B:32:0x0097, B:34:0x009f, B:35:0x00a8, B:37:0x00ae, B:38:0x00b7, B:40:0x00bd, B:41:0x00c6, B:43:0x00cc, B:44:0x00d0, B:45:0x017b, B:47:0x017f, B:50:0x0190, B:54:0x0186, B:55:0x018d, B:59:0x0078), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:6:0x001b, B:8:0x0025, B:10:0x002b, B:13:0x0036, B:15:0x003c, B:16:0x0042, B:18:0x004c, B:19:0x0052, B:21:0x0058, B:22:0x0061, B:24:0x0067, B:25:0x0070, B:29:0x0081, B:31:0x0093, B:32:0x0097, B:34:0x009f, B:35:0x00a8, B:37:0x00ae, B:38:0x00b7, B:40:0x00bd, B:41:0x00c6, B:43:0x00cc, B:44:0x00d0, B:45:0x017b, B:47:0x017f, B:50:0x0190, B:54:0x0186, B:55:0x018d, B:59:0x0078), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:6:0x001b, B:8:0x0025, B:10:0x002b, B:13:0x0036, B:15:0x003c, B:16:0x0042, B:18:0x004c, B:19:0x0052, B:21:0x0058, B:22:0x0061, B:24:0x0067, B:25:0x0070, B:29:0x0081, B:31:0x0093, B:32:0x0097, B:34:0x009f, B:35:0x00a8, B:37:0x00ae, B:38:0x00b7, B:40:0x00bd, B:41:0x00c6, B:43:0x00cc, B:44:0x00d0, B:45:0x017b, B:47:0x017f, B:50:0x0190, B:54:0x0186, B:55:0x018d, B:59:0x0078), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:6:0x001b, B:8:0x0025, B:10:0x002b, B:13:0x0036, B:15:0x003c, B:16:0x0042, B:18:0x004c, B:19:0x0052, B:21:0x0058, B:22:0x0061, B:24:0x0067, B:25:0x0070, B:29:0x0081, B:31:0x0093, B:32:0x0097, B:34:0x009f, B:35:0x00a8, B:37:0x00ae, B:38:0x00b7, B:40:0x00bd, B:41:0x00c6, B:43:0x00cc, B:44:0x00d0, B:45:0x017b, B:47:0x017f, B:50:0x0190, B:54:0x0186, B:55:0x018d, B:59:0x0078), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:6:0x001b, B:8:0x0025, B:10:0x002b, B:13:0x0036, B:15:0x003c, B:16:0x0042, B:18:0x004c, B:19:0x0052, B:21:0x0058, B:22:0x0061, B:24:0x0067, B:25:0x0070, B:29:0x0081, B:31:0x0093, B:32:0x0097, B:34:0x009f, B:35:0x00a8, B:37:0x00ae, B:38:0x00b7, B:40:0x00bd, B:41:0x00c6, B:43:0x00cc, B:44:0x00d0, B:45:0x017b, B:47:0x017f, B:50:0x0190, B:54:0x0186, B:55:0x018d, B:59:0x0078), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:6:0x001b, B:8:0x0025, B:10:0x002b, B:13:0x0036, B:15:0x003c, B:16:0x0042, B:18:0x004c, B:19:0x0052, B:21:0x0058, B:22:0x0061, B:24:0x0067, B:25:0x0070, B:29:0x0081, B:31:0x0093, B:32:0x0097, B:34:0x009f, B:35:0x00a8, B:37:0x00ae, B:38:0x00b7, B:40:0x00bd, B:41:0x00c6, B:43:0x00cc, B:44:0x00d0, B:45:0x017b, B:47:0x017f, B:50:0x0190, B:54:0x0186, B:55:0x018d, B:59:0x0078), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ae A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:6:0x001b, B:8:0x0025, B:10:0x002b, B:13:0x0036, B:15:0x003c, B:16:0x0042, B:18:0x004c, B:19:0x0052, B:21:0x0058, B:22:0x0061, B:24:0x0067, B:25:0x0070, B:29:0x0081, B:31:0x0093, B:32:0x0097, B:34:0x009f, B:35:0x00a8, B:37:0x00ae, B:38:0x00b7, B:40:0x00bd, B:41:0x00c6, B:43:0x00cc, B:44:0x00d0, B:45:0x017b, B:47:0x017f, B:50:0x0190, B:54:0x0186, B:55:0x018d, B:59:0x0078), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:6:0x001b, B:8:0x0025, B:10:0x002b, B:13:0x0036, B:15:0x003c, B:16:0x0042, B:18:0x004c, B:19:0x0052, B:21:0x0058, B:22:0x0061, B:24:0x0067, B:25:0x0070, B:29:0x0081, B:31:0x0093, B:32:0x0097, B:34:0x009f, B:35:0x00a8, B:37:0x00ae, B:38:0x00b7, B:40:0x00bd, B:41:0x00c6, B:43:0x00cc, B:44:0x00d0, B:45:0x017b, B:47:0x017f, B:50:0x0190, B:54:0x0186, B:55:0x018d, B:59:0x0078), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:6:0x001b, B:8:0x0025, B:10:0x002b, B:13:0x0036, B:15:0x003c, B:16:0x0042, B:18:0x004c, B:19:0x0052, B:21:0x0058, B:22:0x0061, B:24:0x0067, B:25:0x0070, B:29:0x0081, B:31:0x0093, B:32:0x0097, B:34:0x009f, B:35:0x00a8, B:37:0x00ae, B:38:0x00b7, B:40:0x00bd, B:41:0x00c6, B:43:0x00cc, B:44:0x00d0, B:45:0x017b, B:47:0x017f, B:50:0x0190, B:54:0x0186, B:55:0x018d, B:59:0x0078), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0078 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:6:0x001b, B:8:0x0025, B:10:0x002b, B:13:0x0036, B:15:0x003c, B:16:0x0042, B:18:0x004c, B:19:0x0052, B:21:0x0058, B:22:0x0061, B:24:0x0067, B:25:0x0070, B:29:0x0081, B:31:0x0093, B:32:0x0097, B:34:0x009f, B:35:0x00a8, B:37:0x00ae, B:38:0x00b7, B:40:0x00bd, B:41:0x00c6, B:43:0x00cc, B:44:0x00d0, B:45:0x017b, B:47:0x017f, B:50:0x0190, B:54:0x0186, B:55:0x018d, B:59:0x0078), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0041  */
    /* JADX WARN: Type inference failed for: r94v0, types: [com.transsion.baselib.db.download.DownloadBean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void p1(com.transsnet.downloader.ugc.dialog.UGCDownloadDialog r96, int r97) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.ugc.dialog.UGCDownloadDialog.p1(com.transsnet.downloader.ugc.dialog.UGCDownloadDialog, int):void");
    }

    private final void q1(List list) {
        UGCVideoDownload uGCVideoDownload;
        String str;
        Object obj;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Set set = (Set) U0().x().f();
        if (set == null || set.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (j1((UGCVideoDownload) obj2)) {
                    arrayList.add(obj2);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            if (this.collectionId == null || (str = this.ugcVideoId) == null || str.length() == 0) {
                uGCVideoDownload = (UGCVideoDownload) CollectionsKt.k0(arrayList);
            } else {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.c(((UGCVideoDownload) obj).getUgcVideoId(), this.ugcVideoId)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                uGCVideoDownload = (UGCVideoDownload) obj;
                if (uGCVideoDownload == null) {
                    uGCVideoDownload = (UGCVideoDownload) CollectionsKt.k0(arrayList);
                }
            }
            if (uGCVideoDownload != null) {
                U0().L(SetsKt.d(uGCVideoDownload));
            }
        }
    }

    private final void r1() {
        c1 c1Var = (c1) getViewBinding();
        if (c1Var != null) {
            View vContentGap = c1Var.f72781y;
            Intrinsics.g(vContentGap, "vContentGap");
            jg.c.k(vContentGap);
            AppCompatImageView ivBtnDownloadIcon = c1Var.f72765i;
            Intrinsics.g(ivBtnDownloadIcon, "ivBtnDownloadIcon");
            jg.c.g(ivBtnDownloadIcon);
            AppCompatTextView tvBtnDownload = c1Var.f72774r;
            Intrinsics.g(tvBtnDownload, "tvBtnDownload");
            jg.c.g(tvBtnDownload);
            ProgressBar progressBarBtnDownload = c1Var.f72771o;
            Intrinsics.g(progressBarBtnDownload, "progressBarBtnDownload");
            jg.c.k(progressBarBtnDownload);
        }
    }

    private final void showLoading() {
        BLFrameLayout bLFrameLayout;
        c1 c1Var = (c1) getViewBinding();
        if (c1Var == null || (bLFrameLayout = c1Var.f72764h) == null) {
            return;
        }
        jg.c.k(bLFrameLayout);
    }

    private final void t1(View view) {
        List list = (List) U0().w().f();
        if (list == null) {
            return;
        }
        Integer num = (Integer) U0().q().f();
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            UGCDownloadResolutionBean uGCDownloadResolutionBean = new UGCDownloadResolutionBean(intValue, intValue + "P");
            uGCDownloadResolutionBean.setSelected(num != null && intValue == num.intValue());
            arrayList.add(uGCDownloadResolutionBean);
        }
        com.transsnet.downloader.ugc.util.h.b(view, CollectionsKt.U0(arrayList), new Function1() { // from class: com.transsnet.downloader.ugc.dialog.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u12;
                u12 = UGCDownloadDialog.u1(UGCDownloadDialog.this, (UGCDownloadResolutionBean) obj);
                return u12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(final UGCDownloadDialog uGCDownloadDialog, final UGCDownloadResolutionBean item) {
        Intrinsics.h(item, "item");
        final int content = item.getContent();
        final Integer num = (Integer) uGCDownloadDialog.U0().q().f();
        if (num != null && content == num.intValue()) {
            return Unit.f67184a;
        }
        uGCDownloadDialog.K0(content, new Function0() { // from class: com.transsnet.downloader.ugc.dialog.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit v12;
                v12 = UGCDownloadDialog.v1(UGCDownloadDialog.this, item, content, num);
                return v12;
            }
        });
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(UGCDownloadDialog uGCDownloadDialog, UGCDownloadResolutionBean uGCDownloadResolutionBean, int i11, Integer num) {
        String str;
        com.transsnet.downloader.ugc.adapter.b bVar;
        TextView textView;
        c1 c1Var = (c1) uGCDownloadDialog.getViewBinding();
        if (c1Var != null && (textView = c1Var.f72776t) != null) {
            textView.setText(uGCDownloadResolutionBean.getName());
        }
        uGCDownloadDialog.U0().q().q(Integer.valueOf(i11));
        if (uGCDownloadDialog.collectionId != null) {
            if (num != null && num.intValue() != i11 && (bVar = uGCDownloadDialog.epTabAdapter) != null) {
                bVar.D1(0);
            }
            b0 b0Var = (b0) uGCDownloadDialog.U0().u().get(Integer.valueOf(i11));
            Map map = b0Var != null ? (Map) b0Var.f() : null;
            if (map == null || map.isEmpty()) {
                uGCDownloadDialog.showLoading();
                UGCDownloadViewModel U0 = uGCDownloadDialog.U0();
                String str2 = uGCDownloadDialog.collectionId;
                Intrinsics.e(str2);
                U0.F(str2, null, "1", Integer.valueOf(i11));
            } else {
                Map map2 = (Map) uGCDownloadDialog.U0().s().f();
                List list = map2 != null ? (List) map2.get(Integer.valueOf(i11)) : null;
                uGCDownloadDialog.U0().o().q(list == null ? CollectionsKt.l() : list);
                List list2 = (List) map.get(((list == null || (str = (String) CollectionsKt.k0(list)) == null) && (str = (String) CollectionsKt.j0(map.keySet())) == null) ? "tab" : str);
                List list3 = list2;
                if (list3 == null || list3.isEmpty()) {
                    uGCDownloadDialog.showLoading();
                    UGCDownloadViewModel U02 = uGCDownloadDialog.U0();
                    String str3 = uGCDownloadDialog.collectionId;
                    Intrinsics.e(str3);
                    U02.F(str3, null, "1", Integer.valueOf(i11));
                } else {
                    uGCDownloadDialog.U0().p().q(list2);
                    if (Intrinsics.c(uGCDownloadDialog.U0().C().f(), Boolean.TRUE)) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list2) {
                            if (uGCDownloadDialog.j1((UGCVideoDownload) obj)) {
                                arrayList.add(obj);
                            }
                        }
                        uGCDownloadDialog.U0().L(CollectionsKt.W0(arrayList));
                    } else {
                        uGCDownloadDialog.U0().N();
                    }
                }
            }
        } else if (uGCDownloadDialog.ugcVideoId != null) {
            b0 b0Var2 = (b0) uGCDownloadDialog.U0().u().get(Integer.valueOf(i11));
            Map map3 = b0Var2 != null ? (Map) b0Var2.f() : null;
            List list4 = map3 != null ? (List) map3.get("tab") : null;
            List list5 = list4;
            if (list5 != null && !list5.isEmpty()) {
                uGCDownloadDialog.U0().p().q(list4);
                if (Intrinsics.c(uGCDownloadDialog.U0().C().f(), Boolean.TRUE)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : list4) {
                        if (uGCDownloadDialog.j1((UGCVideoDownload) obj2)) {
                            arrayList2.add(obj2);
                        }
                    }
                    uGCDownloadDialog.U0().L(CollectionsKt.W0(arrayList2));
                } else {
                    uGCDownloadDialog.U0().N();
                }
            }
        }
        return Unit.f67184a;
    }

    private final void w1(List downloadList) {
        P0().D(downloadList);
        T0().f(downloadList);
        kotlinx.coroutines.k.d(v.a(this), kotlinx.coroutines.y0.b(), null, new UGCDownloadDialog$startDownload$1(downloadList, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StartDownloadHelper x1() {
        return new StartDownloadHelper();
    }

    private final void y1() {
        List Q0 = Q0();
        if (Q0.isEmpty()) {
            return;
        }
        if (R0().size() == Q0.size()) {
            U0().K(false);
            U0().C().q(Boolean.FALSE);
        } else {
            U0().L(CollectionsKt.W0(Q0));
            U0().C().q(Boolean.TRUE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        if (r6 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void z1(java.util.List r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L4f
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        Ld:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L49
            java.lang.Object r1 = r6.next()
            com.transsion.ugcvideodetail.api.bean.UGCVideoDownload r1 = (com.transsion.ugcvideodetail.api.bean.UGCVideoDownload) r1
            com.transsion.ugcvideodetail.api.bean.UGCVideoDownloadResource r2 = r1.getResource()
            r3 = 0
            if (r2 == 0) goto L43
            java.lang.String r2 = r2.getId()
            if (r2 == 0) goto L43
            int r4 = r2.length()
            if (r4 != 0) goto L2d
            r2 = r3
        L2d:
            if (r2 == 0) goto L43
            com.transsnet.downloader.manager.DownloadEsHelper$a r4 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r4 = r4.a()
            com.transsion.baselib.db.download.DownloadBean r2 = r4.q(r2)
            if (r2 == 0) goto L43
            com.transsnet.downloader.ugc.viewmodel.UGCDownloadViewModel r2 = r5.U0()
            java.lang.String r3 = r2.t(r1)
        L43:
            if (r3 == 0) goto Ld
            r0.add(r3)
            goto Ld
        L49:
            java.util.Set r6 = kotlin.collections.CollectionsKt.W0(r0)
            if (r6 != 0) goto L53
        L4f:
            java.util.Set r6 = kotlin.collections.SetsKt.f()
        L53:
            com.transsnet.downloader.ugc.adapter.a r0 = r5.downloadAdapter
            if (r0 == 0) goto L5a
            r0.G1(r6)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.ugc.dialog.UGCDownloadDialog.z1(java.util.List):void");
    }

    @Override // com.transsion.baseui.dialog.BaseViewBindingDialog
    public Function3 n0() {
        return UGCDownloadDialog$bindingInflater$1.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String string;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null ? savedInstanceState.getBoolean("key_download_save_instance") : false) {
            dismissAllowingStateLoss();
            return;
        }
        setStyle(0, R$style.DownloadBottomDialogTheme);
        Bundle arguments = getArguments();
        this.collectionId = arguments != null ? arguments.getString("collection_id") : null;
        Bundle arguments2 = getArguments();
        this.collectionName = arguments2 != null ? arguments2.getString("COLLECTION_NAME") : null;
        Bundle arguments3 = getArguments();
        this.category = arguments3 != null ? arguments3.getString("CATEGORY") : null;
        Bundle arguments4 = getArguments();
        this.subjectId = arguments4 != null ? arguments4.getString("SUBJECT_ID") : null;
        Bundle arguments5 = getArguments();
        this.ugcVideoId = arguments5 != null ? arguments5.getString("ugc_video_id") : null;
        Bundle arguments6 = getArguments();
        String str2 = "";
        if (arguments6 == null || (str = arguments6.getString("PAGE_FROM")) == null) {
            str = "";
        }
        this.pageFrom = str;
        Bundle arguments7 = getArguments();
        if (arguments7 != null && (string = arguments7.getString("LAST_PAGE_FROM")) != null) {
            str2 = string;
        }
        this.lastPageFrom = str2;
        Bundle arguments8 = getArguments();
        this.ops = arguments8 != null ? arguments8.getString("OPS") : null;
        Bundle arguments9 = getArguments();
        this.trackId = arguments9 != null ? arguments9.getString("TRACK_ID") : null;
        Bundle arguments10 = getArguments();
        this.previousTrackId = arguments10 != null ? arguments10.getString("PREVIOUS_TRACK_ID") : null;
        Bundle arguments11 = getArguments();
        this.previousPageVideoId = arguments11 != null ? arguments11.getString("PREVIOUS_PAGE_VIDEO_ID") : null;
        Bundle arguments12 = getArguments();
        this.isImmVerticalVideo = arguments12 != null ? arguments12.getBoolean("IS_IMM_VERTICAL_VIDEO") : false;
        n1(this.pageFrom);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "onCreateDialog(...)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BottomShowAnimation);
            window.setGravity(80);
            window.setDimAmount(0.5f);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = -1;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("key_download_save_instance", true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initListener();
        initView();
        initViewModel();
    }

    public final void s1(Function4 listener) {
        Intrinsics.h(listener, "listener");
        this.downloadSuccessListener = listener;
    }
}
