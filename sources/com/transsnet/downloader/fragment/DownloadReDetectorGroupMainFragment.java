package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.v0;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.VipInfo;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetailapi.bean.DownloadResolutionItem;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.DubsInfoData;
import com.transsion.moviedetailapi.bean.ResolutionItem;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsion.wrapperad.view.DownloadMovieAdView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.transsnet.downloader.widget.DownloadGridTabView;
import com.transsnet.downloader.widget.DownloadResolutionTabView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;
import zm.a;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 °\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002±\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u0019\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010#J#\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002¢\u0006\u0004\b'\u0010(J%\u0010+\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J%\u00100\u001a\u00020\u00052\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0$2\u0006\u0010/\u001a\u00020)H\u0002¢\u0006\u0004\b0\u0010,J\u000f\u00101\u001a\u00020\u0005H\u0002¢\u0006\u0004\b1\u0010\u0004J\u000f\u00102\u001a\u00020\u0005H\u0002¢\u0006\u0004\b2\u0010\u0004JI\u00108\u001a\u00020\u00052\u0006\u00103\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00105\u001a\u0004\u0018\u00010)2\b\b\u0002\u00106\u001a\u00020)2\b\b\u0002\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0005H\u0002¢\u0006\u0004\b:\u0010\u0004J)\u0010<\u001a\u00020;2\u0006\u00103\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\b\u0002\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0004\b<\u0010=J%\u0010A\u001a\u00020\u00052\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0$2\u0006\u0010@\u001a\u00020\u0013H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0005H\u0002¢\u0006\u0004\bC\u0010\u0004J\u000f\u0010D\u001a\u00020\u0005H\u0002¢\u0006\u0004\bD\u0010\u0004J\u000f\u0010E\u001a\u00020\u0005H\u0002¢\u0006\u0004\bE\u0010\u0004J\u000f\u0010F\u001a\u00020\u0005H\u0002¢\u0006\u0004\bF\u0010\u0004JQ\u0010N\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010\u00102\u0006\u0010H\u001a\u00020\u00102\b\u0010I\u001a\u0004\u0018\u00010\u00102\b\u0010J\u001a\u0004\u0018\u00010\u00102\b\u0010K\u001a\u0004\u0018\u00010\u00102\b\u0010L\u001a\u0004\u0018\u00010\u00102\u0006\u0010M\u001a\u00020\u0010H\u0002¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020\u00052\u0006\u00103\u001a\u00020)H\u0002¢\u0006\u0004\bP\u0010QJ\u001d\u0010T\u001a\u00020\u00052\f\u0010S\u001a\b\u0012\u0004\u0012\u00020R0$H\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0005H\u0002¢\u0006\u0004\bV\u0010\u0004J\u0017\u0010X\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u0010H\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\u0005H\u0002¢\u0006\u0004\bZ\u0010\u0004J\u000f\u0010[\u001a\u00020\u0005H\u0002¢\u0006\u0004\b[\u0010\u0004J'\u0010_\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u00132\u0006\u0010]\u001a\u00020\u00132\u0006\u0010^\u001a\u00020\u0013H\u0002¢\u0006\u0004\b_\u0010`R\u0016\u0010H\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010d\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010bR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010bR\u0018\u0010l\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010bR\u0018\u0010K\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010bR\u0018\u0010o\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010bR\u0018\u0010q\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010bR\u0016\u0010t\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010sR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010bR\u0015\u0010\u0080\u0001\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001b\u0010\u0083\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0086\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0019\u0010\u0088\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0085\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0019\u0010\u008e\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u0085\u0001R\u0019\u0010\u0090\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0085\u0001R \u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0019\u0010\u0099\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0085\u0001R\u001a\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010bR\u0018\u0010\u009c\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010sR \u0010¡\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\by\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001R!\u0010¦\u0001\u001a\u00030¢\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b£\u0001\u0010\u009e\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001R!\u0010«\u0001\u001a\u00030§\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¨\u0001\u0010\u009e\u0001\u001a\u0006\b©\u0001\u0010ª\u0001R\u0018\u0010\u00ad\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¬\u0001\u0010bR\u0018\u0010¯\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b®\u0001\u0010b¨\u0006²\u0001"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadReDetectorGroupMainFragment;", "Lcom/transsnet/downloader/fragment/DownloadReDetectorBaseFragment;", "Lpy/a0;", "<init>", "()V", "", "initViewData", "onResume", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "x1", "(Landroid/view/LayoutInflater;)Lpy/a0;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "", "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "initViewModel", "initListener", "retryLoadData", "v0", "x0", "w0", "y0", "onDestroy", "initView", "Lcom/transsnet/downloader/bean/DownloadListBean;", "listBean", "V1", "(Lcom/transsnet/downloader/bean/DownloadListBean;)V", "", "Lcom/transsion/moviedetailapi/bean/DownloadResolutionItem;", "resolutionList", "a2", "(Ljava/util/List;)Ljava/util/List;", "", "resolutionPosition", "G1", "(Ljava/util/List;I)V", "Lcom/transsion/moviedetailapi/bean/DubsInfo;", "dubsList", "dubsPosition", "A1", "I1", "l1", "resolution", "audioChannel", "season", "tabIndex", "isShowLoading", "d2", "(IILjava/lang/String;Ljava/lang/Integer;IZ)V", "z1", "Lcom/transsnet/downloader/fragment/DownloadReDetectorGroupFragment;", "n1", "(IIZ)Lcom/transsnet/downloader/fragment/DownloadReDetectorGroupFragment;", "Lcom/transsion/baselib/db/download/DownloadBean;", "selectedList", "selectAll", "Y1", "(Ljava/util/List;Z)V", "X1", "W1", "T1", "S1", "pageName", "pageFrom", "subjectId", "postId", "ops", "resourceId", "taskId", "t1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "b2", "(I)V", "Lcom/transsnet/downloader/widget/e;", "titleList", "E1", "(Ljava/util/List;)V", "m1", CampaignEx.JSON_KEY_TITLE, "Z1", "(Ljava/lang/String;)V", "f2", "s1", "isVipSubject", "hasFreeEpisode", "isVipResource", "c2", "(ZZZ)V", "l", "Ljava/lang/String;", "m", "lastPageFrom", "Lcom/transsion/moviedetailapi/bean/Subject;", "n", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "o", "curSubjectId", TtmlNode.TAG_P, "groupId", CampaignEx.JSON_KEY_AD_Q, CampaignEx.JSON_KEY_AD_R, "targetResourceId", "s", "moduleName", "t", "Z", "dialogStyle", TmcStartParams.KEY_URL_SHORT, "isSelectAll", "", "v", "J", "localTotalSize", "w", "formatSize", "Lkotlinx/coroutines/n0;", "x", "Lkotlinx/coroutines/n0;", "downloadCoroutineScope", "y", "Lcom/transsnet/downloader/fragment/DownloadReDetectorGroupFragment;", "curFragment", "z", "I", "targetSeason", "A", "curSeason", "Lcom/transsion/baseui/widget/magicindicator/ORCommonNavigator;", "B", "Lcom/transsion/baseui/widget/magicindicator/ORCommonNavigator;", "commonNavigator", "C", "curTabIndex", "D", "curTotalEpisode", "Ljava/util/concurrent/CopyOnWriteArrayList;", "E", "Ljava/util/concurrent/CopyOnWriteArrayList;", "checkedList", "F", "Ljava/lang/Integer;", "currentResolution", "G", "currentResolutionPosition", "H", "selectedCurrentAudioSubjectId", "showPremiumIfNeed", "Lcom/transsnet/downloader/manager/StartDownloadHelper;", "Lkotlin/Lazy;", "w1", "()Lcom/transsnet/downloader/manager/StartDownloadHelper;", "startDownloadHelper", "Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", "K", "v1", "()Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", "groupMainViewModel", "Lcom/transsnet/downloader/viewmodel/k0;", "L", "u1", "()Lcom/transsnet/downloader/viewmodel/k0;", "detailDownloadViewModel", "M", "traceId", "N", "interceptTypeSceneId", "O", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadReDetectorGroupMainFragment extends DownloadReDetectorBaseFragment<py.a0> {

    /* renamed from: O, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: B, reason: from kotlin metadata */
    private ORCommonNavigator commonNavigator;

    /* renamed from: C, reason: from kotlin metadata */
    private int curTabIndex;

    /* renamed from: D, reason: from kotlin metadata */
    private int curTotalEpisode;

    /* renamed from: F, reason: from kotlin metadata */
    private Integer currentResolution;

    /* renamed from: G, reason: from kotlin metadata */
    private int currentResolutionPosition;

    /* renamed from: H, reason: from kotlin metadata */
    private String selectedCurrentAudioSubjectId;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean showPremiumIfNeed;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private Subject subject;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private String curSubjectId;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String targetResourceId;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectAll;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private long localTotalSize;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private DownloadReDetectorGroupFragment curFragment;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private int targetSeason;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String pageFrom = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom = "";

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean dialogStyle = true;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private String formatSize = "";

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final kotlinx.coroutines.n0 downloadCoroutineScope = kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b());

    /* renamed from: A, reason: from kotlin metadata */
    private int curSeason = 1;

    /* renamed from: E, reason: from kotlin metadata */
    private CopyOnWriteArrayList checkedList = new CopyOnWriteArrayList();

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy startDownloadHelper = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.t2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            StartDownloadHelper g22;
            g22 = DownloadReDetectorGroupMainFragment.g2();
            return g22;
        }
    });

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy groupMainViewModel = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.u2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DownloadResourcesDetectorViewModel y12;
            y12 = DownloadReDetectorGroupMainFragment.y1(DownloadReDetectorGroupMainFragment.this);
            return y12;
        }
    });

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy detailDownloadViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsnet.downloader.viewmodel.k0.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: M, reason: from kotlin metadata */
    private String traceId = "";

    /* renamed from: N, reason: from kotlin metadata */
    private String interceptTypeSceneId = "";

    /* renamed from: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorGroupMainFragment a(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, int i11, boolean z10) {
            DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = new DownloadReDetectorGroupMainFragment();
            downloadReDetectorGroupMainFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_group_id", str3), TuplesKt.a("extra_ops", str4), TuplesKt.a("extra_target_resource_id", str5), TuplesKt.a("extra_module_name", str6), TuplesKt.a("extra_season", Integer.valueOf(i11)), TuplesKt.a("extra_dialog_style", Boolean.valueOf(z10))));
            return downloadReDetectorGroupMainFragment;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements zm.a {
        b() {
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
            DownloadReDetectorGroupMainFragment.this.W1();
        }

        @Override // zm.a
        public void f(MemberCheckResult memberCheckResult) {
            a.C1007a.a(this, memberCheckResult);
        }

        @Override // zm.a
        public void onFail(String errorMsg) {
            Intrinsics.h(errorMsg, "errorMsg");
            a.C1007a.b(this, errorMsg);
            a.C0856a.f(lg.a.f68962a, "co_mem", "DownloadReDetectorGroupMainFragment --> onSelectAllClickIfNeed() --> 剧集全选 --> " + errorMsg, false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59047a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59047a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59047a;
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
            this.f59047a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A1(List dubsList, int dubsPosition) {
        DownloadResolutionTabView downloadResolutionTabView;
        DownloadResolutionTabView downloadResolutionTabView2;
        DownloadResourcesDetectorViewModel viewModel;
        androidx.view.b0 o11;
        DownloadResolutionTabView downloadResolutionTabView3;
        py.a0 a0Var = (py.a0) getMViewBinding();
        if (a0Var != null && (downloadResolutionTabView3 = a0Var.A) != null) {
            downloadResolutionTabView3.setAudioClickListener(new Function0() { // from class: com.transsnet.downloader.fragment.v2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit B1;
                    B1 = DownloadReDetectorGroupMainFragment.B1(DownloadReDetectorGroupMainFragment.this);
                    return B1;
                }
            });
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (viewModel = getViewModel()) != null && (o11 = viewModel.o()) != null) {
            o11.j(parentFragment, new c(new Function1() { // from class: com.transsnet.downloader.fragment.c2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit C1;
                    C1 = DownloadReDetectorGroupMainFragment.C1(DownloadReDetectorGroupMainFragment.this, (DubsInfo) obj);
                    return C1;
                }
            }));
        }
        py.a0 a0Var2 = (py.a0) getMViewBinding();
        if (a0Var2 != null && (downloadResolutionTabView2 = a0Var2.A) != null) {
            downloadResolutionTabView2.setAudioItemClickListener(new Function2() { // from class: com.transsnet.downloader.fragment.d2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit D1;
                    D1 = DownloadReDetectorGroupMainFragment.D1(DownloadReDetectorGroupMainFragment.this, ((Integer) obj).intValue(), (DubsInfo) obj2);
                    return D1;
                }
            });
        }
        py.a0 a0Var3 = (py.a0) getMViewBinding();
        if (a0Var3 == null || (downloadResolutionTabView = a0Var3.A) == null) {
            return;
        }
        downloadResolutionTabView.setAudioContentData(dubsList, dubsPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment) {
        androidx.view.b0 p11;
        DownloadResourcesDetectorViewModel viewModel = downloadReDetectorGroupMainFragment.getViewModel();
        if (viewModel != null && (p11 = viewModel.p()) != null) {
            p11.q(9);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit C1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, DubsInfo dubsInfo) {
        DownloadResolutionTabView downloadResolutionTabView;
        androidx.view.b0 g11;
        BLFrameLayout bLFrameLayout;
        String subjectId = dubsInfo.getSubjectId();
        if (subjectId != null) {
            py.a0 a0Var = (py.a0) downloadReDetectorGroupMainFragment.getMViewBinding();
            if (a0Var != null && (bLFrameLayout = a0Var.f72695f) != null) {
                jg.c.k(bLFrameLayout);
            }
            downloadReDetectorGroupMainFragment.curSubjectId = subjectId;
            DownloadResourcesDetectorViewModel viewModel = downloadReDetectorGroupMainFragment.getViewModel();
            if (viewModel != null && (g11 = viewModel.g()) != null) {
                g11.q(subjectId);
            }
            DownloadResourcesDetectorViewModel viewModel2 = downloadReDetectorGroupMainFragment.getViewModel();
            if (viewModel2 != null) {
                viewModel2.u(subjectId);
            }
            py.a0 a0Var2 = (py.a0) downloadReDetectorGroupMainFragment.getMViewBinding();
            if (a0Var2 != null && (downloadResolutionTabView = a0Var2.A) != null) {
                downloadResolutionTabView.updateAudioTrack(dubsInfo.getLanName());
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit D1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, int i11, DubsInfo item) {
        androidx.view.b0 g11;
        BLFrameLayout bLFrameLayout;
        Intrinsics.h(item, "item");
        String subjectId = item.getSubjectId();
        if (subjectId != null) {
            py.a0 a0Var = (py.a0) downloadReDetectorGroupMainFragment.getMViewBinding();
            if (a0Var != null && (bLFrameLayout = a0Var.f72695f) != null) {
                jg.c.k(bLFrameLayout);
            }
            downloadReDetectorGroupMainFragment.curSubjectId = subjectId;
            DownloadResourcesDetectorViewModel viewModel = downloadReDetectorGroupMainFragment.getViewModel();
            if (viewModel != null && (g11 = viewModel.g()) != null) {
                g11.q(downloadReDetectorGroupMainFragment.curSubjectId);
            }
            downloadReDetectorGroupMainFragment.getTAG();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initAudioTab: 切换音轨到:");
            sb2.append(item);
            DownloadResourcesDetectorViewModel viewModel2 = downloadReDetectorGroupMainFragment.getViewModel();
            if (viewModel2 != null) {
                viewModel2.u(subjectId);
            }
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void E1(final List titleList) {
        DownloadGridTabView downloadGridTabView;
        py.a0 a0Var = (py.a0) getMViewBinding();
        if (a0Var == null || (downloadGridTabView = a0Var.f72715z) == null) {
            return;
        }
        downloadGridTabView.setItemClickCallback(new Function2() { // from class: com.transsnet.downloader.fragment.n2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit F1;
                F1 = DownloadReDetectorGroupMainFragment.F1(DownloadReDetectorGroupMainFragment.this, titleList, ((Integer) obj).intValue(), (com.transsnet.downloader.widget.e) obj2);
                return F1;
            }
        });
        downloadGridTabView.setDataList(titleList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, List list, int i11, com.transsnet.downloader.widget.e item) {
        Intrinsics.h(item, "item");
        a.C0856a c0856a = lg.a.f68962a;
        String tag = downloadReDetectorGroupMainFragment.getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "ep tab click, resolution:" + downloadReDetectorGroupMainFragment.currentResolution + ", index:" + i11, false, 4, null);
        downloadReDetectorGroupMainFragment.Z1(((com.transsnet.downloader.widget.e) list.get(i11)).a());
        Integer num = downloadReDetectorGroupMainFragment.currentResolution;
        if (num != null) {
            e2(downloadReDetectorGroupMainFragment, num.intValue(), downloadReDetectorGroupMainFragment.currentResolutionPosition, downloadReDetectorGroupMainFragment.curSubjectId, null, i11, false, 40, null);
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G1(List resolutionList, int resolutionPosition) {
        DownloadResolutionTabView downloadResolutionTabView;
        DownloadResolutionTabView downloadResolutionTabView2;
        py.a0 a0Var = (py.a0) getMViewBinding();
        if (a0Var != null && (downloadResolutionTabView2 = a0Var.A) != null) {
            downloadResolutionTabView2.setResolutionItemClickListener(new Function2() { // from class: com.transsnet.downloader.fragment.e2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit H1;
                    H1 = DownloadReDetectorGroupMainFragment.H1(DownloadReDetectorGroupMainFragment.this, ((Integer) obj).intValue(), (DownloadResolutionItem) obj2);
                    return H1;
                }
            });
        }
        py.a0 a0Var2 = (py.a0) getMViewBinding();
        if (a0Var2 == null || (downloadResolutionTabView = a0Var2.A) == null) {
            return;
        }
        downloadResolutionTabView.setResolutionContentData(resolutionList, resolutionPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, int i11, DownloadResolutionItem item) {
        Intrinsics.h(item, "item");
        downloadReDetectorGroupMainFragment.b2(item.getResolution());
        e2(downloadReDetectorGroupMainFragment, item.getResolution(), i11, downloadReDetectorGroupMainFragment.curSubjectId, null, 0, false, 24, null);
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void I1() {
        DownloadResolutionTabView downloadResolutionTabView;
        DownloadResourcesDetectorViewModel viewModel;
        androidx.view.b0 z10;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (viewModel = getViewModel()) != null && (z10 = viewModel.z()) != null) {
            z10.j(parentFragment, new c(new Function1() { // from class: com.transsnet.downloader.fragment.f2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit J1;
                    J1 = DownloadReDetectorGroupMainFragment.J1(DownloadReDetectorGroupMainFragment.this, (Integer) obj);
                    return J1;
                }
            }));
        }
        py.a0 a0Var = (py.a0) getMViewBinding();
        if (a0Var == null || (downloadResolutionTabView = a0Var.A) == null) {
            return;
        }
        downloadResolutionTabView.setSeasonClickListener(new Function0() { // from class: com.transsnet.downloader.fragment.g2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit K1;
                K1 = DownloadReDetectorGroupMainFragment.K1(DownloadReDetectorGroupMainFragment.this);
                return K1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit J1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, Integer num) {
        Integer resolution;
        DownloadResolutionTabView downloadResolutionTabView;
        py.a0 a0Var = (py.a0) downloadReDetectorGroupMainFragment.getMViewBinding();
        if (a0Var != null && (downloadResolutionTabView = a0Var.A) != null) {
            Intrinsics.e(num);
            downloadResolutionTabView.setSeason(num.intValue());
        }
        Integer num2 = downloadReDetectorGroupMainFragment.currentResolution;
        e2(downloadReDetectorGroupMainFragment, num2 != null ? num2.intValue() : 360, downloadReDetectorGroupMainFragment.currentResolutionPosition, downloadReDetectorGroupMainFragment.curSubjectId, num, 0, false, 16, null);
        downloadReDetectorGroupMainFragment.m1();
        DownloadListBean downloadListBean = (DownloadListBean) downloadReDetectorGroupMainFragment.v1().s().f();
        downloadReDetectorGroupMainFragment.b2((downloadListBean == null || (resolution = downloadListBean.getResolution()) == null) ? com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0) : resolution.intValue());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment) {
        androidx.view.b0 p11;
        DownloadResourcesDetectorViewModel viewModel = downloadReDetectorGroupMainFragment.getViewModel();
        if (viewModel != null && (p11 = viewModel.p()) != null) {
            p11.q(8);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, View view) {
        downloadReDetectorGroupMainFragment.m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, View view) {
        downloadReDetectorGroupMainFragment.X1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, View view) {
        downloadReDetectorGroupMainFragment.X1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void O1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, View view) {
        DownloadMovieAdView downloadMovieAdView;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        if (downloadReDetectorGroupMainFragment.checkedList.isEmpty()) {
            uh.b.f76876a.d(com.transsnet.downloader.R$string.download_unselected_tips);
            return;
        }
        DownloadBean downloadBean = (DownloadBean) CollectionsKt.k0(downloadReDetectorGroupMainFragment.checkedList);
        if (downloadBean != null) {
            com.transsion.baselib.report.launch.b.f43424a.b().putInt("download_last_resolution", downloadBean.getResolution());
        }
        py.a0 a0Var = (py.a0) downloadReDetectorGroupMainFragment.getMViewBinding();
        if (a0Var != null && (downloadMovieAdView = a0Var.B) != null) {
            downloadMovieAdView.download();
        }
        a.C0856a.f(lg.a.f68962a, "premium_d", "DownloadReDetectorGroupMainFragment --> btnDownload{} --> 点进下载按钮", false, 4, null);
        downloadReDetectorGroupMainFragment.u1().b().q(Boolean.TRUE);
        kotlinx.coroutines.k.d(androidx.view.v.a(downloadReDetectorGroupMainFragment), null, null, new DownloadReDetectorGroupMainFragment$initView$4$2(downloadReDetectorGroupMainFragment, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, DubsInfoData dubsInfoData) {
        List<DubsInfo> dubs;
        String subjectId;
        DownloadResourcesDetectorViewModel viewModel;
        androidx.view.b0 g11;
        DownloadResourcesDetectorViewModel viewModel2;
        if (dubsInfoData != null && (dubs = dubsInfoData.getDubs()) != null) {
            int i11 = 0;
            if (dubs.isEmpty()) {
                String str = downloadReDetectorGroupMainFragment.curSubjectId;
                if (str != null && (viewModel2 = downloadReDetectorGroupMainFragment.getViewModel()) != null) {
                    viewModel2.u(str);
                }
            } else {
                Subject subject = downloadReDetectorGroupMainFragment.subject;
                Object obj = null;
                downloadReDetectorGroupMainFragment.curSubjectId = subject != null ? subject.getSubjectId() : null;
                DownloadResourcesDetectorViewModel viewModel3 = downloadReDetectorGroupMainFragment.getViewModel();
                if (viewModel3 != null && (g11 = viewModel3.g()) != null) {
                    g11.q(downloadReDetectorGroupMainFragment.curSubjectId);
                }
                Iterator<T> it = dubs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String subjectId2 = ((DubsInfo) next).getSubjectId();
                    Subject subject2 = downloadReDetectorGroupMainFragment.subject;
                    if (Intrinsics.c(subjectId2, subject2 != null ? subject2.getSubjectId() : null)) {
                        obj = next;
                        break;
                    }
                }
                DubsInfo dubsInfo = (DubsInfo) obj;
                if (dubsInfo != null) {
                    dubsInfo.setSelected(true);
                    i11 = dubs.indexOf(dubsInfo);
                }
                Subject subject3 = downloadReDetectorGroupMainFragment.subject;
                if (subject3 != null && (subjectId = subject3.getSubjectId()) != null && (viewModel = downloadReDetectorGroupMainFragment.getViewModel()) != null) {
                    viewModel.u(subjectId);
                }
            }
            downloadReDetectorGroupMainFragment.A1(CollectionsKt.U0(dubs), i11);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, DownloadListBean downloadListBean) {
        downloadReDetectorGroupMainFragment.V1(downloadListBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x013a, code lost:
    
        if (r1.intValue() != r3) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0156, code lost:
    
        if (r24.targetSeason > 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0158, code lost:
    
        r24.targetSeason = r24.curSeason;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x015c, code lost:
    
        r1 = r24.getViewModel();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0160, code lost:
    
        if (r1 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0162, code lost:
    
        r1 = r1.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0166, code lost:
    
        if (r1 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0168, code lost:
    
        r1.q(java.lang.Integer.valueOf(r24.targetSeason));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0171, code lost:
    
        r10 = r24.v1();
        r11 = r24.curSubjectId;
        r1 = r24.subject;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0179, code lost:
    
        if (r1 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x017b, code lost:
    
        r12 = r1.getTitle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0182, code lost:
    
        r10.j(r11, (r24 & 2) != 0 ? "" : r12, (r24 & 4) != 0 ? 0 : 0, (r24 & 8) != 0 ? "1" : null, (r24 & 16) != 0 ? 20 : 1, (r24 & 32) != 0 ? 1 : 0, (r24 & 64) != 0 ? 1 : 0, (r24 & 128) != 0 ? 1 : 0, (r24 & 256) != 0 ? 1 : 0, (r24 & 512) == 0 ? 0 : 1, (r24 & 1024) != 0 ? com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0) : r25);
        r11 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0181, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0152, code lost:
    
        if (r1.intValue() != r3) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit R1(com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment r24, int r25, com.transsion.moviedetailapi.bean.ResourcesSeasonList r26) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.R1(com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment, int, com.transsion.moviedetailapi.bean.ResourcesSeasonList):kotlin.Unit");
    }

    private final void S1() {
        androidx.view.b0 p11;
        androidx.view.b0 i11;
        if (this.checkedList.isEmpty()) {
            return;
        }
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel != null && (i11 = viewModel.i()) != null) {
            int size = this.checkedList.size();
            String str = this.formatSize;
            Object obj = this.checkedList.get(0);
            Intrinsics.g(obj, "get(...)");
            i11.q(new com.transsnet.downloader.viewmodel.b(size, str, (DownloadBean) obj, false));
        }
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        if (viewModel2 == null || (p11 = viewModel2.p()) == null) {
            return;
        }
        p11.q(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void T1() {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        View view;
        FrameLayout frameLayout;
        u1().b().q(Boolean.FALSE);
        if (u0(this.localTotalSize)) {
            return;
        }
        py.a0 a0Var = (py.a0) getMViewBinding();
        if (a0Var != null && (frameLayout = a0Var.f72697h) != null && frameLayout.getVisibility() == 0) {
            lg.a.f68962a.p("download", new String[]{"DownloadReDetectorGroupMainFragment --> onDownload() --> 当前正在全选中"}, true);
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "onDownload ", false, 4, null);
        py.a0 a0Var2 = (py.a0) getMViewBinding();
        if (a0Var2 != null && (view = a0Var2.f72714y) != null) {
            jg.c.k(view);
        }
        py.a0 a0Var3 = (py.a0) getMViewBinding();
        if (a0Var3 != null && (appCompatImageView = a0Var3.f72698i) != null) {
            jg.c.g(appCompatImageView);
        }
        py.a0 a0Var4 = (py.a0) getMViewBinding();
        if (a0Var4 != null && (appCompatTextView = a0Var4.f72706q) != null) {
            jg.c.g(appCompatTextView);
        }
        py.a0 a0Var5 = (py.a0) getMViewBinding();
        if (a0Var5 != null && (progressBar2 = a0Var5.f72704o) != null) {
            jg.c.k(progressBar2);
        }
        int i11 = 0;
        for (Object obj : this.checkedList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            DownloadBean downloadBean = (DownloadBean) obj;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "toString(...)");
            downloadBean.setTaskId(uuid);
            t1(this.pageFrom, this.lastPageFrom, downloadBean.getSubjectId(), downloadBean.getPostId(), this.ops, downloadBean.getResourceId(), uuid);
            lg.a.f68962a.p("download", new String[]{"剧集多资源，下载点击，开始下载: subjectId = " + downloadBean.getSubjectId() + ",resourceId = " + downloadBean.getResourceId() + ", name = " + downloadBean.getTotalTitleName()}, true);
            i11 = i12;
        }
        p0().D(this.checkedList);
        w1().f(this.checkedList);
        kotlinx.coroutines.k.d(this.downloadCoroutineScope, null, null, new DownloadReDetectorGroupMainFragment$onDownload$2(this, null), 3, null);
        long size = ((this.checkedList.size() / 20) * 100) + 300;
        py.a0 a0Var6 = (py.a0) getMViewBinding();
        if (a0Var6 != null && (progressBar = a0Var6.f72704o) != null) {
            progressBar.postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.h2
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadReDetectorGroupMainFragment.U1(DownloadReDetectorGroupMainFragment.this);
                }
            }, size);
        }
        BiddingNativeManager.Companion companion = BiddingNativeManager.f42070y;
        com.transsion.ad.strategy.d dVar = com.transsion.ad.strategy.d.f42285a;
        Subject subject = this.subject;
        companion.a("DownloadPopupScene", dVar.a(subject != null ? subject.getGenre() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment) {
        downloadReDetectorGroupMainFragment.S1();
    }

    private final void V1(DownloadListBean listBean) {
        List<DownloadResolutionItem> resolutionList;
        if (listBean == null || (resolutionList = listBean.getResolutionList()) == null) {
            return;
        }
        List<DownloadResolutionItem> resolutionList2 = listBean.getResolutionList();
        if (resolutionList2 != null) {
            Iterator<T> it = resolutionList2.iterator();
            while (it.hasNext()) {
                ((DownloadResolutionItem) it.next()).setVipInfo(listBean.getVipInfo());
            }
        }
        if (this.commonNavigator == null) {
            Integer resolution = listBean.getResolution();
            b2(resolution != null ? resolution.intValue() : com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0));
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "onGetDefResolutionData 首次，curSeason:" + this.curSeason + ",resolutionList: :" + resolutionList, false, 4, null);
        List a22 = a2(resolutionList);
        I1();
        if (a22.size() <= 1) {
            G1(a22, 0);
            this.showPremiumIfNeed = true;
            Integer resolution2 = listBean.getResolution();
            e2(this, resolution2 != null ? resolution2.intValue() : 0, 0, this.curSubjectId, null, 0, false, 56, null);
            return;
        }
        this.showPremiumIfNeed = false;
        Integer resolution3 = listBean.getResolution();
        int intValue = resolution3 != null ? resolution3.intValue() : 0;
        int i11 = -1;
        int i12 = com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", -1);
        Iterator it2 = a22.iterator();
        int i13 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i13 = -1;
                break;
            } else if (((DownloadResolutionItem) it2.next()).getResolution() == i12) {
                break;
            } else {
                i13++;
            }
        }
        if (i13 < 0 && intValue > 0) {
            Iterator it3 = a22.iterator();
            int i14 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                if (((DownloadResolutionItem) it3.next()).getResolution() == intValue) {
                    i11 = i14;
                    break;
                }
                i14++;
            }
            i13 = i11;
        }
        int i15 = i13 < 0 ? 0 : i13;
        int i16 = 0;
        int i17 = 0;
        for (Object obj : a22) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt.u();
            }
            DownloadResolutionItem downloadResolutionItem = (DownloadResolutionItem) obj;
            if (i17 == i15) {
                i16 = downloadResolutionItem.getResolution();
                downloadResolutionItem.setSelected(true);
            } else {
                downloadResolutionItem.setSelected(false);
            }
            i17 = i18;
        }
        G1(a22, i15);
        e2(this, i16, i15, this.curSubjectId, null, 0, false, 56, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void W1() {
        py.a0 a0Var;
        AppCompatImageView appCompatImageView;
        DownloadReDetectorGroupFragment downloadReDetectorGroupFragment = this.curFragment;
        if ((downloadReDetectorGroupFragment != null && !downloadReDetectorGroupFragment.l1()) || (a0Var = (py.a0) getMViewBinding()) == null || (appCompatImageView = a0Var.f72699j) == null) {
            return;
        }
        appCompatImageView.setSelected(!appCompatImageView.isSelected());
        boolean isSelected = appCompatImageView.isSelected();
        this.isSelectAll = isSelected;
        DownloadReDetectorGroupFragment downloadReDetectorGroupFragment2 = this.curFragment;
        if (downloadReDetectorGroupFragment2 != null) {
            downloadReDetectorGroupFragment2.n1(isSelected);
        }
    }

    private final void X1() {
        DownloadReDetectorGroupFragment downloadReDetectorGroupFragment;
        if (this.isSelectAll || (downloadReDetectorGroupFragment = this.curFragment) == null || !downloadReDetectorGroupFragment.d1()) {
            W1();
            return;
        }
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            DownloadReDetectorGroupFragment downloadReDetectorGroupFragment2 = this.curFragment;
            iMemberApi.o(downloadReDetectorGroupFragment2 != null ? downloadReDetectorGroupFragment2.a1() : null, new b());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cb, code lost:
    
        if ((r15 != null ? r15.isMovieType() : false) != false) goto L117;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void Y1(java.util.List r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.Y1(java.util.List, boolean):void");
    }

    private final void Z1(String title) {
        hj.i iVar = hj.i.f64628a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WebConstants.PAGE_FROM, this.pageFrom);
        linkedHashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "episode_tab");
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, title);
        Unit unit = Unit.f67184a;
        iVar.p("download", linkedHashMap);
    }

    private final List a2(List resolutionList) {
        androidx.view.b0 y10;
        ResourcesSeasonList resourcesSeasonList;
        List<ResourcesSeason> seasons;
        Object obj;
        ArrayList arrayList = new ArrayList();
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel != null && (y10 = viewModel.y()) != null && (resourcesSeasonList = (ResourcesSeasonList) y10.f()) != null && (seasons = resourcesSeasonList.getSeasons()) != null) {
            Iterator<T> it = seasons.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ResourcesSeason) obj).getSe() == this.curSeason) {
                    break;
                }
            }
            ResourcesSeason resourcesSeason = (ResourcesSeason) obj;
            if (resourcesSeason != null) {
                List<ResolutionItem> resolutions = resourcesSeason.getResolutions();
                if (resolutions == null || resolutions.isEmpty()) {
                    return resolutionList;
                }
                List<ResolutionItem> resolutions2 = resourcesSeason.getResolutions();
                if (resolutions2 != null && resolutions2.size() == resolutionList.size()) {
                    return resolutionList;
                }
                List<ResolutionItem> resolutions3 = resourcesSeason.getResolutions();
                if (resolutions3 != null) {
                    for (ResolutionItem resolutionItem : resolutions3) {
                        Iterator it2 = resolutionList.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                DownloadResolutionItem downloadResolutionItem = (DownloadResolutionItem) it2.next();
                                if (resolutionItem.getResolution() == downloadResolutionItem.getResolution()) {
                                    arrayList.add(downloadResolutionItem);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList.isEmpty() ? resolutionList : arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b2(int resolution) {
        DownloadGridTabView downloadGridTabView;
        DownloadResolutionTabView downloadResolutionTabView;
        DownloadGridTabView downloadGridTabView2;
        androidx.view.b0 y10;
        ResourcesSeasonList resourcesSeasonList;
        List<ResourcesSeason> seasons;
        Object obj;
        ResolutionItem resolutionItem;
        Object obj2;
        Object next;
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel != null && (y10 = viewModel.y()) != null && (resourcesSeasonList = (ResourcesSeasonList) y10.f()) != null && (seasons = resourcesSeasonList.getSeasons()) != null) {
            Iterator<T> it = seasons.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((ResourcesSeason) obj).getSe() == this.curSeason) {
                        break;
                    }
                }
            }
            ResourcesSeason resourcesSeason = (ResourcesSeason) obj;
            if (resourcesSeason != null) {
                if (resolution == 0) {
                    List<ResolutionItem> resolutions = resourcesSeason.getResolutions();
                    if (resolutions != null) {
                        Iterator<T> it2 = resolutions.iterator();
                        if (it2.hasNext()) {
                            next = it2.next();
                            if (it2.hasNext()) {
                                int epNum = ((ResolutionItem) next).getEpNum();
                                do {
                                    Object next2 = it2.next();
                                    int epNum2 = ((ResolutionItem) next2).getEpNum();
                                    if (epNum < epNum2) {
                                        next = next2;
                                        epNum = epNum2;
                                    }
                                } while (it2.hasNext());
                            }
                        } else {
                            next = null;
                        }
                        ResolutionItem resolutionItem2 = (ResolutionItem) next;
                        if (resolutionItem2 != null) {
                            this.curTotalEpisode = resolutionItem2.getEpNum();
                        }
                    }
                } else {
                    List<ResolutionItem> resolutions2 = resourcesSeason.getResolutions();
                    if (resolutions2 != null) {
                        Iterator<T> it3 = resolutions2.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj2 = null;
                                break;
                            } else {
                                obj2 = it3.next();
                                if (resolution == ((ResolutionItem) obj2).getResolution()) {
                                    break;
                                }
                            }
                        }
                        ResolutionItem resolutionItem3 = (ResolutionItem) obj2;
                        if (resolutionItem3 != null) {
                            this.curTotalEpisode = resolutionItem3.getEpNum();
                        }
                    }
                    List<ResolutionItem> resolutions3 = resourcesSeason.getResolutions();
                    if (resolutions3 != null && (resolutionItem = (ResolutionItem) CollectionsKt.k0(resolutions3)) != null) {
                        this.curTotalEpisode = resolutionItem.getEpNum();
                    }
                }
            }
        }
        int i11 = (this.curTotalEpisode + 49) / 50;
        if (i11 <= 1) {
            py.a0 a0Var = (py.a0) getMViewBinding();
            if (a0Var == null || (downloadGridTabView2 = a0Var.f72715z) == null) {
                return;
            }
            jg.c.g(downloadGridTabView2);
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "setSeasonOrEpTitleTab, totalEpisode:" + this.curTotalEpisode + ", titleCount:" + i11, false, 4, null);
        py.a0 a0Var2 = (py.a0) getMViewBinding();
        Object layoutParams = (a0Var2 == null || (downloadResolutionTabView = a0Var2.A) == null) ? null : downloadResolutionTabView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = com.blankj.utilcode.util.a0.a(12.0f);
        }
        py.a0 a0Var3 = (py.a0) getMViewBinding();
        if (a0Var3 != null && (downloadGridTabView = a0Var3.f72715z) != null) {
            jg.c.k(downloadGridTabView);
        }
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        while (i12 < i11) {
            int i13 = i12 * 50;
            arrayList.add(new com.transsnet.downloader.widget.e((i13 + 1) + "-" + RangesKt.i(i13 + 50, this.curTotalEpisode), i12 == 0));
            i12++;
        }
        E1(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c2(boolean isVipSubject, boolean hasFreeEpisode, boolean isVipResource) {
        LinearLayoutCompat linearLayoutCompat;
        py.a0 a0Var;
        AppCompatTextView appCompatTextView;
        LinearLayoutCompat linearLayoutCompat2;
        LinearLayoutCompat linearLayoutCompat3;
        py.a0 a0Var2;
        AppCompatTextView appCompatTextView2;
        LinearLayoutCompat linearLayoutCompat4;
        LinearLayoutCompat linearLayoutCompat5;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView3;
        Subject subject;
        AppCompatTextView appCompatTextView4;
        VipInfo vipInfo;
        Integer requireMemberType;
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        boolean c11 = iPremiumApi != null ? iPremiumApi.c() : false;
        IPremiumApi iPremiumApi2 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        int f11 = iPremiumApi2 != null ? iPremiumApi2.f() : 0;
        this.interceptTypeSceneId = "default";
        if (!c11 && f11 < 1) {
            Context context = getContext();
            if (context != null) {
                if (isVipSubject || hasFreeEpisode || !((subject = this.subject) == null || (vipInfo = subject.getVipInfo()) == null || (requireMemberType = vipInfo.getRequireMemberType()) == null || requireMemberType.intValue() != 1)) {
                    py.a0 a0Var3 = (py.a0) getMViewBinding();
                    if (a0Var3 != null && (appCompatTextView3 = a0Var3.f72706q) != null) {
                        appCompatTextView3.setText(androidx.core.content.b.getString(context, com.transsnet.downloader.R$string.p_v2_unlock_downloads));
                    }
                } else {
                    py.a0 a0Var4 = (py.a0) getMViewBinding();
                    if (a0Var4 != null && (appCompatTextView4 = a0Var4.f72706q) != null) {
                        appCompatTextView4.setText(androidx.core.content.b.getString(context, com.transsnet.downloader.R$string.p_v2_unlock_hd_downloads));
                    }
                }
            }
            py.a0 a0Var5 = (py.a0) getMViewBinding();
            if (a0Var5 != null && (appCompatImageView = a0Var5.f72698i) != null) {
                appCompatImageView.setImageResource(R$mipmap.p_v2_premium);
            }
            py.a0 a0Var6 = (py.a0) getMViewBinding();
            if (a0Var6 != null && (linearLayoutCompat5 = a0Var6.f72691b) != null) {
                linearLayoutCompat5.setBackgroundResource(R$drawable.p_v2_download_bg);
            }
            s1();
            this.interceptTypeSceneId = "download/stream_restriction";
            return;
        }
        if (isVipSubject) {
            py.a0 a0Var7 = (py.a0) getMViewBinding();
            if (a0Var7 != null && (linearLayoutCompat4 = a0Var7.f72691b) != null) {
                linearLayoutCompat4.setBackgroundResource(R$drawable.p_v2_download_bg);
            }
            if (c11) {
                return;
            }
            Context context2 = getContext();
            if (context2 != null && (a0Var2 = (py.a0) getMViewBinding()) != null && (appCompatTextView2 = a0Var2.f72706q) != null) {
                appCompatTextView2.setText(androidx.core.content.b.getString(context2, com.transsnet.downloader.R$string.p_v2_unlock_downloads));
            }
            s1();
            this.interceptTypeSceneId = "download/vip_content_block";
            return;
        }
        if (hasFreeEpisode) {
            py.a0 a0Var8 = (py.a0) getMViewBinding();
            if (a0Var8 == null || (linearLayoutCompat3 = a0Var8.f72691b) == null) {
                return;
            }
            linearLayoutCompat3.setBackgroundResource(com.transsnet.downloader.R$drawable.shape_download_group_button);
            return;
        }
        if (!isVipResource) {
            py.a0 a0Var9 = (py.a0) getMViewBinding();
            if (a0Var9 == null || (linearLayoutCompat = a0Var9.f72691b) == null) {
                return;
            }
            linearLayoutCompat.setBackgroundResource(com.transsnet.downloader.R$drawable.shape_download_group_button);
            return;
        }
        py.a0 a0Var10 = (py.a0) getMViewBinding();
        if (a0Var10 != null && (linearLayoutCompat2 = a0Var10.f72691b) != null) {
            linearLayoutCompat2.setBackgroundResource(R$drawable.p_v2_download_bg);
        }
        if (c11) {
            return;
        }
        Context context3 = getContext();
        if (context3 != null && (a0Var = (py.a0) getMViewBinding()) != null && (appCompatTextView = a0Var.f72706q) != null) {
            appCompatTextView.setText(androidx.core.content.b.getString(context3, com.transsnet.downloader.R$string.p_v2_unlock_hd_downloads));
        }
        s1();
        this.interceptTypeSceneId = "download/hd_restriction";
    }

    private final void d2(int resolution, int resolutionPosition, String audioChannel, Integer season, int tabIndex, boolean isShowLoading) {
        androidx.view.b0 h11;
        androidx.view.b0 g11;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        Integer num = this.currentResolution;
        if (num != null && resolution == num.intValue() && tabIndex == this.curTabIndex && Intrinsics.c(audioChannel, this.selectedCurrentAudioSubjectId)) {
            int i11 = this.curSeason;
            if (season != null && season.intValue() == i11) {
                a.C0856a c0856a = lg.a.f68962a;
                String tag = getTAG();
                Intrinsics.g(tag, "<get-TAG>(...)");
                a.C0856a.f(c0856a, tag, "分辨率未切换，不处理, resolution = " + resolution + ", tabIndex = " + tabIndex, false, 4, null);
                return;
            }
        }
        String str = "fragment_download_group-" + resolution + "-" + this.curSubjectId + "-" + tabIndex + "-" + season;
        a.C0856a c0856a2 = lg.a.f68962a;
        String tag2 = getTAG();
        Intrinsics.g(tag2, "<get-TAG>(...)");
        a.C0856a.f(c0856a2, tag2, "group showFragment, resolution:" + resolution + ",  curEpTabPosition:" + tabIndex + "， curSubjectId：" + this.curSubjectId + " season:" + season, false, 4, null);
        this.currentResolution = Integer.valueOf(resolution);
        this.curTabIndex = tabIndex;
        this.currentResolutionPosition = resolutionPosition;
        this.selectedCurrentAudioSubjectId = audioChannel;
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel != null && (g11 = viewModel.g()) != null) {
            g11.q(audioChannel);
        }
        this.curSeason = season != null ? season.intValue() : 1;
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (h11 = viewModel2.h()) != null) {
            h11.q(Integer.valueOf(this.curSeason));
        }
        z1();
        Fragment k02 = getChildFragmentManager().k0(str);
        if (k02 == null) {
            k02 = n1(resolution, resolutionPosition, isShowLoading);
        }
        Intrinsics.f(k02, "null cannot be cast to non-null type com.transsnet.downloader.fragment.DownloadReDetectorGroupFragment");
        DownloadReDetectorGroupFragment downloadReDetectorGroupFragment = (DownloadReDetectorGroupFragment) k02;
        this.curFragment = downloadReDetectorGroupFragment;
        if (downloadReDetectorGroupFragment != null) {
            downloadReDetectorGroupFragment.t1(this.isSelectAll);
        }
        if (downloadReDetectorGroupFragment.isAdded()) {
            getChildFragmentManager().p().y(k02).l();
        } else {
            getChildFragmentManager().p().c(R$id.fl_content, k02, str).l();
        }
    }

    static /* synthetic */ void e2(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, int i11, int i12, String str, Integer num, int i13, boolean z10, int i14, Object obj) {
        if ((i14 & 8) != 0) {
            num = Integer.valueOf(downloadReDetectorGroupMainFragment.curSeason);
        }
        Integer num2 = num;
        if ((i14 & 16) != 0) {
            i13 = 0;
        }
        int i15 = i13;
        if ((i14 & 32) != 0) {
            z10 = true;
        }
        downloadReDetectorGroupMainFragment.d2(i11, i12, str, num2, i15, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f2() {
        FrameLayout frameLayout;
        LinearLayout linearLayout;
        FrameLayout frameLayout2;
        LinearLayout linearLayout2;
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi != null ? iPremiumApi.c() : false) {
            py.a0 a0Var = (py.a0) getMViewBinding();
            if (a0Var != null && (linearLayout2 = a0Var.f72702m) != null) {
                linearLayout2.setVisibility(8);
            }
            py.a0 a0Var2 = (py.a0) getMViewBinding();
            if (a0Var2 == null || (frameLayout2 = a0Var2.f72696g) == null) {
                return;
            }
            frameLayout2.setVisibility(0);
            return;
        }
        py.a0 a0Var3 = (py.a0) getMViewBinding();
        if (a0Var3 != null && (linearLayout = a0Var3.f72702m) != null) {
            linearLayout.setVisibility(0);
        }
        py.a0 a0Var4 = (py.a0) getMViewBinding();
        if (a0Var4 == null || (frameLayout = a0Var4.f72696g) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StartDownloadHelper g2() {
        return new StartDownloadHelper();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        DownloadMovieAdView downloadMovieAdView;
        BLFrameLayout bLFrameLayout;
        LinearLayoutCompat linearLayoutCompat;
        TextView textView;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        ImageView imageView;
        BLConstraintLayout bLConstraintLayout;
        ViewGroup.LayoutParams layoutParams;
        py.a0 a0Var;
        BLConstraintLayout bLConstraintLayout2;
        if (!this.dialogStyle && (a0Var = (py.a0) getMViewBinding()) != null && (bLConstraintLayout2 = a0Var.f72692c) != null) {
            bLConstraintLayout2.setBackground(new DrawableCreator.Builder().setSolidColor(requireActivity().getResources().getColor(R$color.gray_dark_00)).build());
        }
        py.a0 a0Var2 = (py.a0) getMViewBinding();
        if (a0Var2 != null && (bLConstraintLayout = a0Var2.f72692c) != null && (layoutParams = bLConstraintLayout.getLayoutParams()) != null) {
            layoutParams.height = o0();
        }
        py.a0 a0Var3 = (py.a0) getMViewBinding();
        if (a0Var3 != null && (imageView = a0Var3.f72700k) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.p2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorGroupMainFragment.L1(DownloadReDetectorGroupMainFragment.this, view);
                }
            });
        }
        py.a0 a0Var4 = (py.a0) getMViewBinding();
        if (a0Var4 != null && (appCompatTextView = a0Var4.f72710u) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.q2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorGroupMainFragment.M1(DownloadReDetectorGroupMainFragment.this, view);
                }
            });
        }
        f2();
        py.a0 a0Var5 = (py.a0) getMViewBinding();
        if (a0Var5 != null && (appCompatImageView = a0Var5.f72699j) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.r2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorGroupMainFragment.N1(DownloadReDetectorGroupMainFragment.this, view);
                }
            });
        }
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        int f11 = iPremiumApi != null ? iPremiumApi.f() : 0;
        py.a0 a0Var6 = (py.a0) getMViewBinding();
        if (a0Var6 != null && (textView = a0Var6.f72707r) != null) {
            textView.setText(String.valueOf(f11));
        }
        py.a0 a0Var7 = (py.a0) getMViewBinding();
        if (a0Var7 != null && (linearLayoutCompat = a0Var7.f72691b) != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.s2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorGroupMainFragment.O1(DownloadReDetectorGroupMainFragment.this, view);
                }
            });
        }
        py.a0 a0Var8 = (py.a0) getMViewBinding();
        if (a0Var8 != null && (bLFrameLayout = a0Var8.f72695f) != null) {
            bLFrameLayout.setVisibility(0);
        }
        py.a0 a0Var9 = (py.a0) getMViewBinding();
        if (a0Var9 == null || (downloadMovieAdView = a0Var9.B) == null) {
            return;
        }
        Subject subject = this.subject;
        downloadMovieAdView.loadAd(subject != null ? subject.getGenre() : null);
    }

    private final void l1() {
    }

    private final void m1() {
        List<DownloadResolutionItem> resolutionList;
        DownloadListBean downloadListBean = (DownloadListBean) v1().s().f();
        if (downloadListBean == null || (resolutionList = downloadListBean.getResolutionList()) == null) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.r(c0856a, tag, new String[]{"checkSeason2RestResolution curSeason:" + this.curSeason + ",resolutionList: :" + resolutionList}, false, 4, null);
        List a22 = a2(resolutionList);
        if (a22.size() <= 1) {
            G1(a22, 0);
            return;
        }
        Integer resolution = downloadListBean.getResolution();
        int intValue = resolution != null ? resolution.intValue() : 0;
        int i11 = -1;
        int i12 = com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", -1);
        Iterator it = a22.iterator();
        int i13 = 0;
        while (true) {
            if (!it.hasNext()) {
                i13 = -1;
                break;
            }
            int resolution2 = ((DownloadResolutionItem) it.next()).getResolution();
            Integer num = this.currentResolution;
            if (num != null && resolution2 == num.intValue()) {
                break;
            } else {
                i13++;
            }
        }
        if (i13 < 0) {
            Iterator it2 = a22.iterator();
            i13 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i13 = -1;
                    break;
                } else if (((DownloadResolutionItem) it2.next()).getResolution() == i12) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        if (i13 < 0 && intValue > 0) {
            Iterator it3 = a22.iterator();
            int i14 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                if (((DownloadResolutionItem) it3.next()).getResolution() == intValue) {
                    i11 = i14;
                    break;
                }
                i14++;
            }
            i13 = i11;
        }
        if (i13 < 0) {
            i13 = 0;
        }
        int i15 = 0;
        for (Object obj : a22) {
            int i16 = i15 + 1;
            if (i15 < 0) {
                CollectionsKt.u();
            }
            ((DownloadResolutionItem) obj).setSelected(i15 == i13);
            i15 = i16;
        }
        G1(a22, i13);
    }

    private final DownloadReDetectorGroupFragment n1(int resolution, int resolutionPosition, boolean isShowLoading) {
        final DownloadReDetectorGroupFragment a11 = DownloadReDetectorGroupFragment.INSTANCE.a(this.pageFrom, this.lastPageFrom, this.subject, this.curSubjectId, this.groupId, this.ops, this.targetResourceId, Integer.valueOf(resolution), resolutionPosition, this.showPremiumIfNeed, isShowLoading, this.curSeason, this.curTabIndex);
        a11.r1(new Function2() { // from class: com.transsnet.downloader.fragment.i2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit o12;
                o12 = DownloadReDetectorGroupMainFragment.o1(DownloadReDetectorGroupMainFragment.this, (List) obj, ((Boolean) obj2).booleanValue());
                return o12;
            }
        });
        a11.s1(new Function1() { // from class: com.transsnet.downloader.fragment.j2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p12;
                p12 = DownloadReDetectorGroupMainFragment.p1(DownloadReDetectorGroupFragment.this, this, (String) obj);
                return p12;
            }
        });
        a11.u1(new Function1() { // from class: com.transsnet.downloader.fragment.k2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q12;
                q12 = DownloadReDetectorGroupMainFragment.q1(DownloadReDetectorGroupMainFragment.this, ((Boolean) obj).booleanValue());
                return q12;
            }
        });
        a11.v1(new Function1() { // from class: com.transsnet.downloader.fragment.l2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r12;
                r12 = DownloadReDetectorGroupMainFragment.r1(DownloadReDetectorGroupMainFragment.this, ((Boolean) obj).booleanValue());
                return r12;
            }
        });
        return a11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, List list, boolean z10) {
        Intrinsics.h(list, "list");
        downloadReDetectorGroupMainFragment.Y1(list, z10);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit p1(DownloadReDetectorGroupFragment downloadReDetectorGroupFragment, DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, String str) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        if (!downloadReDetectorGroupFragment.isAdded() || downloadReDetectorGroupFragment.isDetached() || downloadReDetectorGroupFragment.isRemoving()) {
            return Unit.f67184a;
        }
        if (str == null || str.length() == 0) {
            py.a0 a0Var = (py.a0) downloadReDetectorGroupMainFragment.getMViewBinding();
            if (a0Var != null && (appCompatTextView = a0Var.f72706q) != null) {
                appCompatTextView.setText(downloadReDetectorGroupFragment.getString(com.transsnet.downloader.R$string.str_download));
            }
        } else {
            py.a0 a0Var2 = (py.a0) downloadReDetectorGroupMainFragment.getMViewBinding();
            if (a0Var2 != null && (appCompatTextView2 = a0Var2.f72706q) != null) {
                appCompatTextView2.setText(downloadReDetectorGroupFragment.getString(com.transsnet.downloader.R$string.str_download) + " · " + str);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit q1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, boolean z10) {
        FrameLayout frameLayout;
        py.a0 a0Var = (py.a0) downloadReDetectorGroupMainFragment.getMViewBinding();
        if (a0Var != null && (frameLayout = a0Var.f72697h) != null) {
            frameLayout.setVisibility(z10 ? 0 : 8);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit r1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, boolean z10) {
        BLFrameLayout bLFrameLayout;
        py.a0 a0Var = (py.a0) downloadReDetectorGroupMainFragment.getMViewBinding();
        if (a0Var != null && (bLFrameLayout = a0Var.f72695f) != null) {
            bLFrameLayout.setVisibility(z10 ? 0 : 8);
        }
        return Unit.f67184a;
    }

    private final void s1() {
        if (TextUtils.isEmpty(this.traceId)) {
            String b11 = ti.n.f76387a.b();
            this.traceId = b11;
            com.transsion.baselib.helper.f fVar = com.transsion.baselib.helper.f.f43323a;
            String str = this.pageFrom;
            Subject subject = this.subject;
            fVar.h(str, "download/vip_content_block", b11, subject != null ? subject.getSubjectId() : null, 0);
        }
    }

    private final void t1(String pageName, String pageFrom, String subjectId, String postId, String ops, String resourceId, String taskId) {
        HashMap hashMap = new HashMap();
        hashMap.put(WebConstants.PAGE_FROM, pageFrom);
        hashMap.put("subject_id", subjectId);
        hashMap.put("post_id", postId);
        hashMap.put("ops", ops);
        hashMap.put("resource_id", resourceId);
        hashMap.put("task_id", taskId);
        hashMap.put("module_name", this.moduleName);
        hj.i iVar = hj.i.f64628a;
        if (pageName == null) {
            pageName = "download_click";
        }
        iVar.s(pageName, "download_click", hashMap);
        Bundle bundle = new Bundle();
        bundle.putString("resource_id", resourceId);
        bundle.putString("subject_id", subjectId);
        com.transsion.baselib.report.e.f43398a.l("download_click", bundle, getContext());
    }

    private final com.transsnet.downloader.viewmodel.k0 u1() {
        return (com.transsnet.downloader.viewmodel.k0) this.detailDownloadViewModel.getValue();
    }

    private final DownloadResourcesDetectorViewModel v1() {
        return (DownloadResourcesDetectorViewModel) this.groupMainViewModel.getValue();
    }

    private final StartDownloadHelper w1() {
        return (StartDownloadHelper) this.startDownloadHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadResourcesDetectorViewModel y1(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment) {
        return (DownloadResourcesDetectorViewModel) new androidx.view.v0(downloadReDetectorGroupMainFragment).a(DownloadResourcesDetectorViewModel.class);
    }

    private final void z1() {
        List y02 = getChildFragmentManager().y0();
        Intrinsics.g(y02, "getFragments(...)");
        Iterator it = y02.iterator();
        while (it.hasNext()) {
            getChildFragmentManager().p().p((Fragment) it.next()).l();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        a.C0856a.f(lg.a.f68962a, "premium_d", "DownloadReDetectorGroupMainFragment --> initViewData()", false, 4, null);
        initView();
        l1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        String subjectId;
        androidx.view.b0 g11;
        androidx.view.b0 n11;
        androidx.view.b0 y10;
        py.a0 a0Var;
        DownloadResolutionTabView downloadResolutionTabView;
        final int i11 = com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0);
        Subject subject = this.subject;
        if (subject != null && (a0Var = (py.a0) getMViewBinding()) != null && (downloadResolutionTabView = a0Var.A) != null) {
            downloadResolutionTabView.setSubject(subject);
        }
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel != null && (y10 = viewModel.y()) != null) {
            y10.j(this, new c(new Function1() { // from class: com.transsnet.downloader.fragment.b2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit R1;
                    R1 = DownloadReDetectorGroupMainFragment.R1(DownloadReDetectorGroupMainFragment.this, i11, (ResourcesSeasonList) obj);
                    return R1;
                }
            }));
        }
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (n11 = viewModel2.n()) != null) {
            n11.j(this, new c(new Function1() { // from class: com.transsnet.downloader.fragment.m2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit P1;
                    P1 = DownloadReDetectorGroupMainFragment.P1(DownloadReDetectorGroupMainFragment.this, (DubsInfoData) obj);
                    return P1;
                }
            }));
        }
        v1().s().j(this, new c(new Function1() { // from class: com.transsnet.downloader.fragment.o2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q1;
                Q1 = DownloadReDetectorGroupMainFragment.Q1(DownloadReDetectorGroupMainFragment.this, (DownloadListBean) obj);
                return Q1;
            }
        }));
        Subject subject2 = this.subject;
        if (subject2 != null && (subjectId = subject2.getSubjectId()) != null) {
            this.curSubjectId = subjectId;
            DownloadResourcesDetectorViewModel viewModel3 = getViewModel();
            if (viewModel3 != null && (g11 = viewModel3.g()) != null) {
                g11.q(this.curSubjectId);
            }
            DownloadResourcesDetectorViewModel viewModel4 = getViewModel();
            if (viewModel4 != null) {
                viewModel4.t(subjectId);
            }
        }
        getParentFragment();
        DownloadResourcesDetectorViewModel viewModel5 = getViewModel();
        if (viewModel5 != null) {
            viewModel5.v();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return false;
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        String str4;
        HashMap g11;
        HashMap g12;
        HashMap g13;
        HashMap g14;
        HashMap g15;
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str5 = "";
        if (arguments == null || (str = arguments.getString("extra_page_from")) == null) {
            str = "";
        }
        this.pageFrom = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("extra_last_page_from")) == null) {
            str2 = "";
        }
        this.lastPageFrom = str2;
        Bundle arguments3 = getArguments();
        this.subject = (Subject) (arguments3 != null ? arguments3.getSerializable("extra_subject") : null);
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str3 = arguments4.getString("extra_ops")) == null) {
            str3 = "";
        }
        this.ops = str3;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str4 = arguments5.getString("extra_target_resource_id")) == null) {
            str4 = "";
        }
        this.targetResourceId = str4;
        Bundle arguments6 = getArguments();
        if (arguments6 != null && (string = arguments6.getString("extra_module_name")) != null) {
            str5 = string;
        }
        this.moduleName = str5;
        Bundle arguments7 = getArguments();
        this.targetSeason = arguments7 != null ? arguments7.getInt("extra_season") : 0;
        Bundle arguments8 = getArguments();
        this.dialogStyle = arguments8 != null ? arguments8.getBoolean("extra_dialog_style") : true;
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g15 = logViewConfig.g()) != null) {
            g15.put(WebConstants.PAGE_FROM, this.pageFrom);
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g14 = logViewConfig2.g()) != null) {
            g14.put("last_page_from", this.lastPageFrom);
        }
        hj.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g13 = logViewConfig3.g()) != null) {
            Subject subject = this.subject;
            g13.put("subject_id", subject != null ? subject.getSubjectId() : null);
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g12 = logViewConfig4.g()) != null) {
            g12.put("ops", this.ops);
        }
        hj.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 == null || (g11 = logViewConfig5.g()) == null) {
            return;
        }
        g11.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "2");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        DownloadMovieAdView downloadMovieAdView;
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        aVar.a().Y(null);
        try {
            aVar.a().A().clear();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        py.a0 a0Var = (py.a0) getMViewBinding();
        if (a0Var != null && (downloadMovieAdView = a0Var.B) != null) {
            downloadMovieAdView.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        l1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void v0() {
        super.v0();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void w0() {
        super.w0();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void x0() {
        super.x0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public py.a0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.a0 c11 = py.a0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void y0() {
        super.y0();
    }
}
