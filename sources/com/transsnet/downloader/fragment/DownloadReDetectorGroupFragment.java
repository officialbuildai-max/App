package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.tn.lib.view.DefaultView;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.transsnet.downloader.widget.DownloadResLoadMoreView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 §\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002¨\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0004J'\u0010\u0017\u001a\u00020\n2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H\u0002¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020\nH\u0016¢\u0006\u0004\b+\u0010\u0004J\u0019\u0010.\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0004\b7\u0010%J\u000f\u00108\u001a\u00020\u0007H\u0016¢\u0006\u0004\b8\u0010%J\u000f\u00109\u001a\u00020\nH\u0016¢\u0006\u0004\b9\u0010\u0004J\u000f\u0010:\u001a\u00020\nH\u0016¢\u0006\u0004\b:\u0010\u0004J\u000f\u0010;\u001a\u00020\nH\u0016¢\u0006\u0004\b;\u0010\u0004J\u0017\u0010=\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0007H\u0016¢\u0006\u0004\b=\u0010\u000fJ\u000f\u0010>\u001a\u00020\nH\u0016¢\u0006\u0004\b>\u0010\u0004J<\u0010E\u001a\u00020\n2-\u0010D\u001a)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140@\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\n0?¢\u0006\u0004\bE\u0010FJ#\u0010H\u001a\u00020\n2\u0014\u0010D\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0004\u0012\u00020\n0G¢\u0006\u0004\bH\u0010IJ!\u0010J\u001a\u00020\n2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0G¢\u0006\u0004\bJ\u0010IJ!\u0010K\u001a\u00020\n2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0G¢\u0006\u0004\bK\u0010IJ\r\u0010L\u001a\u00020\u0007¢\u0006\u0004\bL\u0010%J\u0015\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u0007¢\u0006\u0004\bN\u0010\u000fJ\r\u0010O\u001a\u00020\u0007¢\u0006\u0004\bO\u0010%R\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010[\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010]R\u0016\u0010b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010ZR\u0016\u0010d\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010UR\u0016\u0010f\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010UR\"\u0010j\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010Z\u001a\u0004\bh\u0010%\"\u0004\bi\u0010\u000fR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010t\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010]R\u0018\u0010v\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010]R\u0018\u0010x\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010]R\u0018\u0010z\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010]R\u0016\u0010|\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010UR\u0016\u0010~\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010UR\u0017\u0010\u0080\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010UR\u0018\u0010\u0082\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010UR\u0018\u0010\u0084\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010UR\u0018\u0010\u0086\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010UR\u0018\u0010\u0088\u0001\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010]R\u0017\u0010\u0089\u0001\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010]R\u0018\u0010\u008b\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010UR%\u0010C\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010Z\u001a\u0005\b\u008d\u0001\u0010%\"\u0005\b\u008e\u0001\u0010\u000fR\u001a\u0010\u0091\u0001\u001a\u00030\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008a\u0001R\u0018\u0010\u0093\u0001\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010]R\u0018\u0010\u0095\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010UR\u0018\u0010\u0099\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R3\u0010\u009c\u0001\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140@\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R)\u0010\u009f\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0004\u0012\u00020\n\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R'\u0010¡\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010\u009e\u0001R'\u0010£\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010\u009e\u0001R\u0016\u0010¦\u0001\u001a\u0004\u0018\u00010'8F¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001¨\u0006©\u0001"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadReDetectorGroupFragment;", "Lcom/transsnet/downloader/fragment/DownloadReDetectorBaseFragment;", "Lpy/z;", "<init>", "()V", "Lcom/transsnet/downloader/bean/DownloadListBean;", "bean", "", "c1", "(Lcom/transsnet/downloader/bean/DownloadListBean;)Z", "", "initView", "m1", "isSelected", "o1", "(Z)V", "p1", "loadData", "showNotNetError", "", "Lcom/transsion/baselib/db/download/DownloadBean;", "list", "hasMore", "y1", "(Ljava/util/List;Z)V", "targetItem", "x1", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "showEmpty", "Landroid/content/Context;", "context", "Landroid/view/View;", "getEmptyView", "(Landroid/content/Context;)Landroid/view/View;", "startLoading", "hideLoading", "j1", "()Z", "q1", "", "Z0", "()I", "Y0", "initViewData", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "b1", "(Landroid/view/LayoutInflater;)Lpy/z;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "isAudioShowNoNetworkLayout", "isMonitorNetworkState", "initViewModel", "initListener", "retryLoadData", "hidden", "onHiddenChanged", "onDestroy", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSelectAll", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "r1", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "s1", "(Lkotlin/jvm/functions/Function1;)V", "v1", "u1", "d1", "selectAll", "n1", "l1", "Lcom/transsnet/downloader/adapter/g;", "l", "Lcom/transsnet/downloader/adapter/g;", "mAdapter", "m", "I", "resolution", "n", "resolutionTabPosition", "o", "Z", "isShowLoading", TtmlNode.TAG_P, "Ljava/lang/String;", "pageFrom", CampaignEx.JSON_KEY_AD_Q, "lastPageFrom", CampaignEx.JSON_KEY_AD_R, "showPremiumIfNeed", "s", "curSeason", "t", "epIndex", TmcStartParams.KEY_URL_SHORT, "getHasMoreSeasons", "setHasMoreSeasons", "hasMoreSeasons", "Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", "v", "Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", "currentViewModel", "Lcom/transsion/moviedetailapi/bean/Subject;", "w", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "x", "curSubjectId", "y", "groupId", "z", "ops", "A", "targetResourceId", "B", "startPosition", "C", "endPosition", "D", "totalPosition", "E", "curTotalPosition", "F", "startEpisode", "G", "endEpisode", "H", "loadType", "nextPage", "J", "perPage", "K", "k1", "t1", "", "L", "localTotalSize", "M", "formatSize", "N", "unableSize", "Lkotlinx/coroutines/n0;", "O", "Lkotlinx/coroutines/n0;", "downloadCoroutineScope", "P", "Lkotlin/jvm/functions/Function2;", "checkListListener", "Q", "Lkotlin/jvm/functions/Function1;", "formatSizeListener", "R", "loadingListener", "S", "selessctAllLoadinVisibilityListener", "a1", "()Ljava/lang/Integer;", "maxResolution", "T", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public class DownloadReDetectorGroupFragment extends DownloadReDetectorBaseFragment<py.z> {

    /* renamed from: T, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private String targetResourceId;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isSelectAll;

    /* renamed from: L, reason: from kotlin metadata */
    private long localTotalSize;

    /* renamed from: N, reason: from kotlin metadata */
    private int unableSize;

    /* renamed from: P, reason: from kotlin metadata */
    private Function2 checkListListener;

    /* renamed from: Q, reason: from kotlin metadata */
    private Function1 formatSizeListener;

    /* renamed from: R, reason: from kotlin metadata */
    private Function1 loadingListener;

    /* renamed from: S, reason: from kotlin metadata */
    private Function1 selessctAllLoadinVisibilityListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private com.transsnet.downloader.adapter.g mAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int resolution;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int resolutionTabPosition;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean showPremiumIfNeed;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int curSeason;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private int epIndex;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean hasMoreSeasons;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private DownloadResourcesDetectorViewModel currentViewModel;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private Subject subject;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private String curSubjectId;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isShowLoading = true;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String pageFrom = "";

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom = "";

    /* renamed from: B, reason: from kotlin metadata */
    private int startPosition = 1;

    /* renamed from: C, reason: from kotlin metadata */
    private int endPosition = 1;

    /* renamed from: D, reason: from kotlin metadata */
    private int totalPosition = 1;

    /* renamed from: E, reason: from kotlin metadata */
    private int curTotalPosition = 1;

    /* renamed from: F, reason: from kotlin metadata */
    private int startEpisode = 1;

    /* renamed from: G, reason: from kotlin metadata */
    private int endEpisode = 1;

    /* renamed from: H, reason: from kotlin metadata */
    private String loadType = "PAGE";

    /* renamed from: I, reason: from kotlin metadata */
    private String nextPage = "1";

    /* renamed from: J, reason: from kotlin metadata */
    private int perPage = 20;

    /* renamed from: M, reason: from kotlin metadata */
    private String formatSize = "";

    /* renamed from: O, reason: from kotlin metadata */
    private final kotlinx.coroutines.n0 downloadCoroutineScope = kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b());

    /* renamed from: com.transsnet.downloader.fragment.DownloadReDetectorGroupFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorGroupFragment a(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, Integer num, int i11, boolean z10, boolean z11, int i12, int i13) {
            DownloadReDetectorGroupFragment downloadReDetectorGroupFragment = new DownloadReDetectorGroupFragment();
            downloadReDetectorGroupFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_subject_id", str3), TuplesKt.a("extra_group_id", str4), TuplesKt.a("extra_ops", str5), TuplesKt.a("extra_target_resource_id", str6), TuplesKt.a("extra_resolution", num), TuplesKt.a("extra_show_premium_if_need", Boolean.valueOf(z10)), TuplesKt.a("extra_resolution_position", Integer.valueOf(i11)), TuplesKt.a("extra_resolution_is_show_loading", Boolean.valueOf(z11)), TuplesKt.a("extra_season", Integer.valueOf(i12)), TuplesKt.a("extra_ep_index", Integer.valueOf(i13))));
            return downloadReDetectorGroupFragment;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends DiffUtil.e {
        b() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(DownloadBean oldItem, DownloadBean newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.getResourceId(), newItem.getResourceId()) && oldItem.getStatus() == newItem.getStatus() && oldItem.getProgress() == newItem.getProgress() && Intrinsics.c(oldItem.getUpdateTimeStamp(), newItem.getUpdateTimeStamp());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(DownloadBean oldItem, DownloadBean newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.getUrl(), newItem.getUrl());
        }
    }

    /* loaded from: classes7.dex */
    static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59030a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59030a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59030a;
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
            this.f59030a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(DownloadReDetectorGroupFragment downloadReDetectorGroupFragment, DefaultView defaultView, View view) {
        downloadReDetectorGroupFragment.startLoading();
        downloadReDetectorGroupFragment.loadData();
        defaultView.setVisibility(8);
    }

    private final int Y0() {
        return RangesKt.i(this.startEpisode + 19, RangesKt.i(this.curTotalPosition, this.totalPosition));
    }

    private final int Z0() {
        return RangesKt.i(this.startPosition + 19, RangesKt.i(this.curTotalPosition, this.totalPosition));
    }

    private final boolean c1(DownloadListBean bean) {
        String str;
        Boolean hasMore;
        Boolean hasMore2;
        String str2 = this.loadType;
        if (Intrinsics.c(str2, "POSITION")) {
            this.startPosition = this.endPosition + 1;
            int Z0 = Z0();
            this.endPosition = Z0;
            if (this.startPosition >= Z0) {
                return false;
            }
        } else {
            if (!Intrinsics.c(str2, "EPISODE")) {
                Pager pager = bean.getPager();
                if (pager == null || (str = pager.getNextPage()) == null) {
                    str = "1";
                }
                this.nextPage = str;
                Pager pager2 = bean.getPager();
                if (pager2 == null || (hasMore = pager2.getHasMore()) == null) {
                    return false;
                }
                return hasMore.booleanValue();
            }
            this.startEpisode = this.endEpisode + 1;
            this.endEpisode = Y0();
            Pager pager3 = bean.getPager();
            if (!((pager3 == null || (hasMore2 = pager3.getHasMore()) == null) ? false : hasMore2.booleanValue()) || this.startEpisode >= this.endEpisode) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(DownloadReDetectorGroupFragment downloadReDetectorGroupFragment, long j11, boolean z10) {
        downloadReDetectorGroupFragment.q1();
        downloadReDetectorGroupFragment.m1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f1(DownloadReDetectorGroupFragment downloadReDetectorGroupFragment) {
        return downloadReDetectorGroupFragment.hasMoreSeasons;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(DownloadReDetectorGroupFragment downloadReDetectorGroupFragment, final com.transsnet.downloader.adapter.g gVar) {
        if (nh.m.f70597a.e()) {
            downloadReDetectorGroupFragment.loadData();
        } else {
            uh.b.f76876a.d(R$string.no_network_toast);
            gVar.getRecyclerView().postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.z1
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadReDetectorGroupFragment.h1(com.transsnet.downloader.adapter.g.this);
                }
            }, 500L);
        }
    }

    private final View getEmptyView(Context context) {
        final DefaultView defaultView = new DefaultView(context);
        defaultView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        defaultView.setGravity(17);
        defaultView.setDefaultImageViewVisibility(0);
        defaultView.setDefaultImage(R$mipmap.ic_no_content);
        String string = context.getString(R$string.no_content);
        Intrinsics.g(string, "getString(...)");
        defaultView.setDescText(string);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.g(string2, "getString(...)");
        defaultView.setBtnText(string2);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorGroupFragment.X0(DownloadReDetectorGroupFragment.this, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(com.transsnet.downloader.adapter.g gVar) {
        gVar.h0().v();
    }

    private final void hideLoading() {
        Function1 function1 = this.loadingListener;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(DownloadReDetectorGroupFragment downloadReDetectorGroupFragment, DownloadListBean downloadListBean) {
        String str;
        List x10;
        r6.f h02;
        r6.f h03;
        com.transsnet.downloader.adapter.g gVar;
        r6.f h04;
        List<Object> data;
        downloadReDetectorGroupFragment.hideLoading();
        if (downloadListBean == null) {
            com.transsnet.downloader.adapter.g gVar2 = downloadReDetectorGroupFragment.mAdapter;
            if (gVar2 == null || (data = gVar2.getData()) == null || data.size() != 0) {
                com.transsnet.downloader.adapter.g gVar3 = downloadReDetectorGroupFragment.mAdapter;
                if (gVar3 != null && (h03 = gVar3.h0()) != null && h03.r() && (gVar = downloadReDetectorGroupFragment.mAdapter) != null && (h04 = gVar.h0()) != null) {
                    h04.v();
                }
                com.transsnet.downloader.adapter.g gVar4 = downloadReDetectorGroupFragment.mAdapter;
                if (gVar4 != null && (h02 = gVar4.h0()) != null) {
                    r6.f.u(h02, false, 1, null);
                }
            } else if (nh.m.f70597a.e()) {
                downloadReDetectorGroupFragment.showEmpty();
            }
            return Unit.f67184a;
        }
        boolean c12 = downloadReDetectorGroupFragment.c1(downloadListBean);
        a.C0856a c0856a = lg.a.f68962a;
        String tag = downloadReDetectorGroupFragment.getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        List<DownloadItem> items = downloadListBean.getItems();
        Integer valueOf = items != null ? Integer.valueOf(items.size()) : null;
        a.C0856a.r(c0856a, tag, new String[]{"get data from  net, size: " + valueOf + ",loadType:" + downloadReDetectorGroupFragment.loadType + ",hasMore:" + c12 + ",start:" + downloadReDetectorGroupFragment.startPosition + ",end:" + downloadReDetectorGroupFragment.endPosition + ", startEp:" + downloadReDetectorGroupFragment.startEpisode + ",endEp:" + downloadReDetectorGroupFragment.endEpisode}, false, 4, null);
        String subjectId = downloadListBean.getSubjectId();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initViewModel#resDataLiveData: subjectId:");
        sb2.append(subjectId);
        DownloadUtil downloadUtil = DownloadUtil.f60023a;
        Subject subject = downloadReDetectorGroupFragment.subject;
        String str2 = downloadReDetectorGroupFragment.groupId;
        String str3 = downloadReDetectorGroupFragment.pageFrom;
        String str4 = downloadReDetectorGroupFragment.lastPageFrom;
        String str5 = downloadReDetectorGroupFragment.ops;
        String subjectTitle = downloadListBean.getSubjectTitle();
        if (subjectTitle == null) {
            Subject subject2 = downloadReDetectorGroupFragment.subject;
            String title = subject2 != null ? subject2.getTitle() : null;
            if (title == null) {
                title = "";
            }
            str = title;
        } else {
            str = subjectTitle;
        }
        x10 = downloadUtil.x(downloadListBean, subject, (r21 & 4) != 0 ? null : str2, (r21 & 8) != 0 ? null : str3, (r21 & 16) != 0 ? null : str4, (r21 & 32) != 0 ? null : str5, (r21 & 64) != 0 ? null : str, (r21 & 128) != 0 ? null : null);
        downloadReDetectorGroupFragment.y1(x10, c12);
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        py.z zVar = (py.z) getMViewBinding();
        if (zVar != null && (recyclerView2 = zVar.f73121d) != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        int i11 = this.curSeason;
        ArrayList arrayList = new ArrayList();
        String str = this.pageFrom;
        String str2 = this.curSubjectId;
        Subject subject = this.subject;
        final com.transsnet.downloader.adapter.g gVar = new com.transsnet.downloader.adapter.g(i11, arrayList, str, str2, subject != null ? subject.getSubjectType() : null, Boolean.valueOf(this.showPremiumIfNeed), new Function0() { // from class: com.transsnet.downloader.fragment.u1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean f12;
                f12 = DownloadReDetectorGroupFragment.f1(DownloadReDetectorGroupFragment.this);
                return Boolean.valueOf(f12);
            }
        });
        if (this.subject == null) {
            gVar.h0().z(false);
            gVar.h0().y(false);
        } else {
            gVar.h0().C(new DownloadResLoadMoreView());
            gVar.h0().z(true);
            gVar.h0().y(true);
            gVar.h0().E(2);
            gVar.h0().D(new p6.f() { // from class: com.transsnet.downloader.fragment.v1
                @Override // p6.f
                public final void a() {
                    DownloadReDetectorGroupFragment.g1(DownloadReDetectorGroupFragment.this, gVar);
                }
            });
        }
        gVar.R0(new b());
        this.mAdapter = gVar;
        py.z zVar2 = (py.z) getMViewBinding();
        if (zVar2 != null && (recyclerView = zVar2.f73121d) != null) {
            recyclerView.setAdapter(this.mAdapter);
        }
        com.transsnet.downloader.adapter.g gVar2 = this.mAdapter;
        if (gVar2 != null) {
            gVar2.N1(new Function2() { // from class: com.transsnet.downloader.fragment.w1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e12;
                    e12 = DownloadReDetectorGroupFragment.e1(DownloadReDetectorGroupFragment.this, ((Long) obj).longValue(), ((Boolean) obj2).booleanValue());
                    return e12;
                }
            });
        }
    }

    private final boolean j1() {
        r6.f h02;
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        return (gVar == null || (h02 = gVar.h0()) == null || !h02.r()) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if (r1.intValue() != r3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
    
        r1 = r18.endPosition;
        r3 = r18.startPosition;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        if (r1 >= r3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
    
        r18.endPosition = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        if (r18.totalPosition <= 50) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        r4 = r18.currentViewModel;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
    
        if (r4 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        r5 = r18.curSubjectId;
        r1 = r18.subject;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
    
        r2 = r1.getTitle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
    
        r4.j(r5, (r24 & 2) != 0 ? "" : r2, (r24 & 4) != 0 ? 0 : 2, (r24 & 8) != 0 ? "1" : null, (r24 & 16) != 0 ? 20 : 0, (r24 & 32) != 0 ? 1 : 0, (r24 & 64) != 0 ? 1 : 0, (r24 & 128) != 0 ? 1 : r18.curSeason, (r24 & 256) != 0 ? 1 : r18.startEpisode, (r24 & 512) == 0 ? r18.endEpisode : 1, (r24 & 1024) != 0 ? com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0) : r18.resolution);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        r1 = "EPISODE";
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a9, code lost:
    
        r18.loadType = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        r1 = r18.currentViewModel;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        if (r1 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0089, code lost:
    
        r3 = r18.curSubjectId;
        r4 = r18.subject;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        if (r4 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
    
        r2 = r4.getTitle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0093, code lost:
    
        r1.j(r3, (r24 & 2) != 0 ? "" : r2, (r24 & 4) != 0 ? 0 : 1, (r24 & 8) != 0 ? "1" : null, (r24 & 16) != 0 ? 20 : 0, (r24 & 32) != 0 ? 1 : r18.startPosition, (r24 & 64) != 0 ? 1 : r18.endPosition, (r24 & 128) != 0 ? 1 : 0, (r24 & 256) != 0 ? 1 : 0, (r24 & 512) == 0 ? 0 : 1, (r24 & 1024) != 0 ? com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0) : r18.resolution);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a7, code lost:
    
        r1 = "POSITION";
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x004d, code lost:
    
        if (r1.intValue() != r3) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void loadData() {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadReDetectorGroupFragment.loadData():void");
    }

    private final void m1() {
        CopyOnWriteArrayList<DownloadBean> F1;
        Function2 function2;
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        if (gVar == null || (F1 = gVar.F1()) == null || (function2 = this.checkListListener) == null) {
            return;
        }
        int size = F1.size() + this.unableSize;
        com.transsnet.downloader.adapter.g gVar2 = this.mAdapter;
        Intrinsics.e(gVar2);
        function2.invoke(F1, Boolean.valueOf(size == gVar2.getData().size()));
    }

    private final void o1(boolean isSelected) {
        CopyOnWriteArrayList<DownloadBean> F1;
        List<Object> data;
        Function1 function1 = this.selessctAllLoadinVisibilityListener;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        ArrayList arrayList = new ArrayList();
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        if (gVar != null && (data = gVar.getData()) != null) {
            arrayList.addAll(data);
        }
        com.transsnet.downloader.adapter.g gVar2 = this.mAdapter;
        if (gVar2 != null && (F1 = gVar2.F1()) != null) {
            F1.clear();
        }
        kotlinx.coroutines.k.d(this.downloadCoroutineScope, null, null, new DownloadReDetectorGroupFragment$selectAllWithSizeGreaterThan30$1(arrayList, this, isSelected, arrayList.size(), null), 3, null);
    }

    private final void p1(boolean isSelected) {
        CopyOnWriteArrayList<DownloadBean> F1;
        List<Object> data;
        CopyOnWriteArrayList<DownloadBean> F12;
        List<Object> data2;
        CopyOnWriteArrayList<DownloadBean> F13;
        CopyOnWriteArrayList<DownloadBean> F14;
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        if (gVar != null && (F14 = gVar.F1()) != null) {
            F14.clear();
        }
        com.transsnet.downloader.adapter.g gVar2 = this.mAdapter;
        long j11 = 0;
        if (gVar2 != null && (data2 = gVar2.getData()) != null) {
            Iterator<T> it = data2.iterator();
            long j12 = 0;
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                downloadBean.setCheck(isSelected);
                if (this.isSelectAll && !downloadBean.isUnable()) {
                    Long size = downloadBean.getSize();
                    j12 += size != null ? size.longValue() : 0L;
                    com.transsnet.downloader.adapter.g gVar3 = this.mAdapter;
                    if (gVar3 != null && (F13 = gVar3.F1()) != null) {
                        F13.add(downloadBean);
                    }
                }
            }
            j11 = j12;
        }
        com.transsnet.downloader.adapter.g gVar4 = this.mAdapter;
        if (gVar4 != null) {
            gVar4.notifyDataSetChanged();
        }
        this.localTotalSize = j11;
        Integer num = null;
        if (isSelected) {
            String a11 = oh.b.a(j11, 1);
            this.formatSize = a11;
            Function1 function1 = this.formatSizeListener;
            if (function1 != null) {
                function1.invoke(a11);
            }
        } else {
            Function1 function12 = this.formatSizeListener;
            if (function12 != null) {
                function12.invoke(null);
            }
        }
        com.transsnet.downloader.adapter.g gVar5 = this.mAdapter;
        if (gVar5 == null || (F1 = gVar5.F1()) == null) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        com.transsnet.downloader.adapter.g gVar6 = this.mAdapter;
        Integer valueOf = (gVar6 == null || (F12 = gVar6.F1()) == null) ? null : Integer.valueOf(F12.size());
        int i11 = this.unableSize;
        com.transsnet.downloader.adapter.g gVar7 = this.mAdapter;
        if (gVar7 != null && (data = gVar7.getData()) != null) {
            num = Integer.valueOf(data.size());
        }
        a.C0856a.v(c0856a, tag, "selectAllWithSizeLessThan30,checkedSize = " + valueOf + ",unableSize = " + i11 + ", dataSize = " + num, false, 4, null);
        q1();
        Function2 function2 = this.checkListListener;
        if (function2 != null) {
            int size2 = F1.size() + this.unableSize;
            com.transsnet.downloader.adapter.g gVar8 = this.mAdapter;
            Intrinsics.e(gVar8);
            function2.invoke(F1, Boolean.valueOf(size2 == gVar8.getData().size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1() {
        androidx.view.b0 A;
        CopyOnWriteArrayList<DownloadBean> F1;
        ArrayList arrayList = new ArrayList();
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        if (gVar != null && (F1 = gVar.F1()) != null) {
            for (DownloadBean downloadBean : F1) {
                if (!downloadBean.isUnable() && downloadBean.isSeries()) {
                    arrayList.add(downloadBean.getEpName());
                }
            }
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "setCheckItem, size:" + arrayList.size(), false, 4, null);
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel == null || (A = viewModel.A()) == null) {
            return;
        }
        A.q(arrayList);
    }

    private final void showEmpty() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        View emptyView = getEmptyView(requireContext);
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        if (gVar != null) {
            gVar.Y0(emptyView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showNotNetError() {
        AppCompatTextView appCompatTextView;
        LinearLayout linearLayout;
        hideLoading();
        py.z zVar = (py.z) getMViewBinding();
        if (zVar != null && (linearLayout = zVar.f73120c) != null) {
            linearLayout.setVisibility(0);
        }
        py.z zVar2 = (py.z) getMViewBinding();
        if (zVar2 == null || (appCompatTextView = zVar2.f73124g) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorGroupFragment.w1(DownloadReDetectorGroupFragment.this, view);
            }
        });
    }

    private final void startLoading() {
        Function1 function1 = this.loadingListener;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(DownloadReDetectorGroupFragment downloadReDetectorGroupFragment, View view) {
        if (nh.m.f70597a.e()) {
            downloadReDetectorGroupFragment.startLoading();
            downloadReDetectorGroupFragment.loadData();
        }
    }

    private final void x1(DownloadBean targetItem) {
        CopyOnWriteArrayList<DownloadBean> F1;
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        if (gVar == null || (F1 = gVar.F1()) == null) {
            return;
        }
        F1.add(targetItem);
        q1();
        Function2 function2 = this.checkListListener;
        if (function2 != null) {
            int size = F1.size() + this.unableSize;
            com.transsnet.downloader.adapter.g gVar2 = this.mAdapter;
            Intrinsics.e(gVar2);
            function2.invoke(F1, Boolean.valueOf(size == gVar2.getData().size()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e9, code lost:
    
        if (r12.getResolution() == com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 360)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0108, code lost:
    
        if (r11 <= 0) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void y1(java.util.List r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadReDetectorGroupFragment.y1(java.util.List, boolean):void");
    }

    public final Integer a1() {
        List<Object> data;
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        if (gVar != null && (data = gVar.getData()) != null) {
            Iterator<T> it = data.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                int resolution = ((DownloadBean) next).getResolution();
                do {
                    Object next2 = it.next();
                    int resolution2 = ((DownloadBean) next2).getResolution();
                    if (resolution < resolution2) {
                        next = next2;
                        resolution = resolution2;
                    }
                } while (it.hasNext());
            }
            DownloadBean downloadBean = (DownloadBean) next;
            if (downloadBean != null) {
                return Integer.valueOf(downloadBean.getResolution());
            }
        }
        return null;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public py.z getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.z c11 = py.z.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    public final boolean d1() {
        List<Object> data;
        Integer requireMemberType;
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        boolean B = iMemberApi != null ? iMemberApi.B() : false;
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        if (gVar != null && (data = gVar.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                if (B && (requireMemberType = downloadBean.getRequireMemberType()) != null && requireMemberType.intValue() == 1) {
                    return true;
                }
            }
        }
        return false;
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
        initView();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        Fragment parentFragment;
        if (this.isShowLoading) {
            startLoading();
        }
        Fragment parentFragment2 = getParentFragment();
        if (parentFragment2 != null && (parentFragment = parentFragment2.getParentFragment()) != null) {
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = (DownloadResourcesDetectorViewModel) new androidx.view.v0(parentFragment).a(DownloadResourcesDetectorViewModel.class);
            ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) downloadResourcesDetectorViewModel.y().f();
            if (resourcesSeasonList != null) {
                List<ResourcesSeason> seasons = resourcesSeasonList.getSeasons();
                this.hasMoreSeasons = (seasons != null ? seasons.size() : 0) > 1;
                List<ResourcesSeason> seasons2 = resourcesSeasonList.getSeasons();
                if (seasons2 != null) {
                    Pair A = DownloadUtil.f60023a.A(seasons2, this.curSeason, this.resolution);
                    this.totalPosition = ((Number) A.getFirst()).intValue();
                    this.startPosition = ((Number) A.getSecond()).intValue() + (this.epIndex * 50);
                    this.endPosition = Z0();
                    this.startEpisode = (this.epIndex * 50) + 1;
                    this.endEpisode = Y0();
                    a.C0856a c0856a = lg.a.f68962a;
                    String tag = getTAG();
                    Intrinsics.g(tag, "<get-TAG>(...)");
                    a.C0856a.r(c0856a, tag, new String[]{"initViewModel,season:" + this.curSeason + ", epIndex:" + this.epIndex + ", resolution:" + this.resolution + " start:" + this.startPosition + ", end:" + this.endPosition + ", total:" + this.totalPosition + ", startEp:" + this.startEpisode + ", endEp:" + this.endEpisode}, false, 4, null);
                }
            }
            E0(downloadResourcesDetectorViewModel);
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel2 = (DownloadResourcesDetectorViewModel) new androidx.view.v0(this).a(DownloadResourcesDetectorViewModel.class);
        downloadResourcesDetectorViewModel2.s().j(this, new c(new Function1() { // from class: com.transsnet.downloader.fragment.y1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i12;
                i12 = DownloadReDetectorGroupFragment.i1(DownloadReDetectorGroupFragment.this, (DownloadListBean) obj);
                return i12;
            }
        }));
        this.currentViewModel = downloadResourcesDetectorViewModel2;
        loadData();
        Function2 function2 = this.checkListListener;
        if (function2 != null) {
            function2.invoke(new ArrayList(), Boolean.FALSE);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return true;
    }

    /* renamed from: k1, reason: from getter */
    public final boolean getIsSelectAll() {
        return this.isSelectAll;
    }

    public final boolean l1() {
        List<Object> data;
        int i11 = this.unableSize;
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        return i11 < ((gVar == null || (data = gVar.getData()) == null) ? 0 : data.size()) && !j1();
    }

    public final void n1(boolean selectAll) {
        List<Object> data;
        List<Object> data2;
        int i11 = this.unableSize;
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        int i12 = 0;
        if (i11 >= ((gVar == null || (data2 = gVar.getData()) == null) ? 0 : data2.size())) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "selectAll click, selectAll = " + selectAll + " ", false, 4, null);
        this.isSelectAll = selectAll;
        com.transsnet.downloader.adapter.g gVar2 = this.mAdapter;
        if (gVar2 != null && (data = gVar2.getData()) != null) {
            i12 = data.size();
        }
        if (i12 > 30) {
            o1(selectAll);
        } else {
            p1(selectAll);
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        HashMap g11;
        HashMap g12;
        HashMap g13;
        HashMap g14;
        HashMap g15;
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.resolution = arguments != null ? arguments.getInt("extra_resolution") : 0;
        Bundle arguments2 = getArguments();
        this.resolutionTabPosition = arguments2 != null ? arguments2.getInt("extra_resolution_position") : 0;
        Bundle arguments3 = getArguments();
        this.isShowLoading = arguments3 != null ? arguments3.getBoolean("extra_resolution_is_show_loading") : true;
        Bundle arguments4 = getArguments();
        String str4 = "";
        if (arguments4 == null || (str = arguments4.getString("extra_page_from")) == null) {
            str = "";
        }
        this.pageFrom = str;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str2 = arguments5.getString("extra_last_page_from")) == null) {
            str2 = "";
        }
        this.lastPageFrom = str2;
        Bundle arguments6 = getArguments();
        this.subject = (Subject) (arguments6 != null ? arguments6.getSerializable("extra_subject") : null);
        Bundle arguments7 = getArguments();
        this.curSubjectId = arguments7 != null ? arguments7.getString("extra_subject_id") : null;
        Bundle arguments8 = getArguments();
        if (arguments8 == null || (str3 = arguments8.getString("extra_ops")) == null) {
            str3 = "";
        }
        this.ops = str3;
        Bundle arguments9 = getArguments();
        if (arguments9 != null && (string = arguments9.getString("extra_target_resource_id")) != null) {
            str4 = string;
        }
        this.targetResourceId = str4;
        Bundle arguments10 = getArguments();
        this.showPremiumIfNeed = arguments10 != null ? arguments10.getBoolean("extra_show_premium_if_need") : false;
        Bundle arguments11 = getArguments();
        this.curSeason = arguments11 != null ? arguments11.getInt("extra_season") : 0;
        Bundle arguments12 = getArguments();
        int i11 = arguments12 != null ? arguments12.getInt("extra_ep_index") : 0;
        this.epIndex = i11;
        this.curTotalPosition = (i11 + 1) * 50;
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

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        CopyOnWriteArrayList<DownloadBean> F1;
        List<Object> data;
        CopyOnWriteArrayList<DownloadBean> F12;
        com.transsnet.downloader.adapter.g gVar;
        List<Object> data2;
        boolean z10;
        androidx.view.b0 A;
        androidx.view.b0 A2;
        androidx.view.b0 A3;
        List list;
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        Integer num = null;
        a.C0856a.f(c0856a, tag, "--onHiddenChanged, size:" + ((viewModel == null || (A3 = viewModel.A()) == null || (list = (List) A3.f()) == null) ? null : Integer.valueOf(list.size())), false, 4, null);
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        List list2 = (viewModel2 == null || (A2 = viewModel2.A()) == null) ? null : (List) A2.f();
        if (list2 != null && !list2.isEmpty() && (gVar = this.mAdapter) != null && (data2 = gVar.getData()) != null) {
            Iterator<T> it = data2.iterator();
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                DownloadResourcesDetectorViewModel viewModel3 = getViewModel();
                List list3 = (viewModel3 == null || (A = viewModel3.A()) == null) ? null : (List) A.f();
                Intrinsics.e(list3);
                Iterator it2 = list3.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z10 = false;
                        break;
                    } else if (Intrinsics.c(downloadBean.getEpName(), (String) it2.next()) && !downloadBean.isUnable()) {
                        z10 = true;
                        break;
                    }
                }
                downloadBean.setCheck(z10);
                com.transsnet.downloader.adapter.g gVar2 = this.mAdapter;
                if (gVar2 != null) {
                    gVar2.C1(downloadBean, z10);
                }
            }
        }
        com.transsnet.downloader.adapter.g gVar3 = this.mAdapter;
        if (gVar3 != null) {
            gVar3.notifyDataSetChanged();
        }
        m1();
        com.transsnet.downloader.adapter.g gVar4 = this.mAdapter;
        if (gVar4 == null || (F1 = gVar4.F1()) == null) {
            return;
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        String tag2 = getTAG();
        Intrinsics.g(tag2, "<get-TAG>(...)");
        int i11 = this.resolutionTabPosition;
        com.transsnet.downloader.adapter.g gVar5 = this.mAdapter;
        Integer valueOf = (gVar5 == null || (F12 = gVar5.F1()) == null) ? null : Integer.valueOf(F12.size());
        int i12 = this.unableSize;
        com.transsnet.downloader.adapter.g gVar6 = this.mAdapter;
        if (gVar6 != null && (data = gVar6.getData()) != null) {
            num = Integer.valueOf(data.size());
        }
        a.C0856a.v(c0856a2, tag2, "onHiddenChanged, resolutionTabPosition = " + i11 + ",checkedSize = " + valueOf + ",unableSize = " + i12 + ", dataSize = " + num, false, 4, null);
        Function2 function2 = this.checkListListener;
        if (function2 != null) {
            int size = F1.size() + this.unableSize;
            com.transsnet.downloader.adapter.g gVar7 = this.mAdapter;
            Intrinsics.e(gVar7);
            function2.invoke(F1, Boolean.valueOf(size == gVar7.getData().size()));
        }
    }

    public final void r1(Function2 listener) {
        Intrinsics.h(listener, "listener");
        this.checkListListener = listener;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        List<Object> data;
        com.transsnet.downloader.adapter.g gVar = this.mAdapter;
        if (gVar == null || (data = gVar.getData()) == null || data.size() != 0) {
            return;
        }
        startLoading();
        loadData();
    }

    public final void s1(Function1 listener) {
        Intrinsics.h(listener, "listener");
        this.formatSizeListener = listener;
    }

    public final void t1(boolean z10) {
        this.isSelectAll = z10;
    }

    public final void u1(Function1 listener) {
        Intrinsics.h(listener, "listener");
        this.selessctAllLoadinVisibilityListener = listener;
    }

    public final void v1(Function1 listener) {
        Intrinsics.h(listener, "listener");
        this.loadingListener = listener;
    }
}
