package com.transsnet.downloader.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.Lifecycle;
import androidx.view.v0;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tmc.ad.utils.CommonLogUtil;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.AdvRecyclerView;
import com.tn.lib.view.NoNetworkSmallView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.room.api.IAudioApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.adapter.DownloadExpandAdapter;
import com.transsnet.downloader.adapter.u0;
import com.transsnet.downloader.api.DownloadPageType;
import com.transsnet.downloader.bean.MovieRecBean;
import com.transsnet.downloader.popup.PopupManager;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel;
import com.transsnet.downloader.widget.DownloadPanelForYouFootView;
import com.transsnet.downloader.widget.DownloadResLoadMoreView;
import com.transsnet.downloader.widget.DownloadTransferLaterTipsView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import com.transsnet.flow.event.sync.event.LocalVideoEvent;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import nh.n;
import okhttp3.internal.http2.Settings;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0006*\u0004¢\u0001¦\u0001\u0018\u0000 ª\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\\B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J!\u0010\u001e\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0005J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0005J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u0005J\u0019\u00101\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b1\u00102J\u001d\u00104\u001a\u00020\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u001aH\u0002¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b9\u0010'J\u000f\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010\u0005J\u0019\u0010=\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u0010\u0005J!\u0010B\u001a\u00020\u00062\u0006\u0010A\u001a\u00020@2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\bB\u0010CJ!\u0010D\u001a\u00020\u00062\u0006\u0010A\u001a\u00020@2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\bD\u0010CJ\u000f\u0010E\u001a\u00020\u0006H\u0016¢\u0006\u0004\bE\u0010\u0005J\r\u0010F\u001a\u00020\u0006¢\u0006\u0004\bF\u0010\u0005J\u000f\u0010G\u001a\u00020\u0006H\u0016¢\u0006\u0004\bG\u0010\u0005J\u000f\u0010H\u001a\u00020\u0006H\u0016¢\u0006\u0004\bH\u0010\u0005J\u0017\u0010K\u001a\u00020\u00022\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0006H\u0016¢\u0006\u0004\bP\u0010\u0005J\u000f\u0010Q\u001a\u00020\u0006H\u0016¢\u0006\u0004\bQ\u0010\u0005J\u0017\u0010S\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u000eH\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010W\u001a\u00020\u00062\u0006\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bW\u0010XJ\r\u0010Y\u001a\u00020\u0006¢\u0006\u0004\bY\u0010\u0005J\u000f\u0010Z\u001a\u00020\u0006H\u0016¢\u0006\u0004\bZ\u0010\u0005R\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u001d\u0010d\u001a\u0004\u0018\u00010_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010a\u001a\u0004\bg\u0010hR\u001b\u0010n\u001a\u00020j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010a\u001a\u0004\bl\u0010mR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010a\u001a\u0004\bq\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u001b\u0010|\u001a\u00020x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010a\u001a\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0019\u0010\u0082\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0081\u0001R!\u0010\u0087\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u0089\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0081\u0001R\u0018\u0010\u008b\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010~R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R,\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R,\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0092\u0001\u001a\u0006\b\u0099\u0001\u0010\u0094\u0001\"\u0006\b\u009a\u0001\u0010\u0096\u0001R\u0019\u0010\u009d\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u0081\u0001R\u0018\u0010¡\u0001\u001a\u00030\u009e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¥\u0001\u001a\u00030¢\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u0018\u0010©\u0001\u001a\u00030¦\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001¨\u0006«\u0001"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadPanelFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lpy/x;", "Lzm/e;", "<init>", "()V", "", "initViewModel", "Lcom/transsion/baselib/db/download/DownloadBean;", "seriesBean", "i1", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "", "list", "", "deduplicate", "M1", "(Ljava/util/List;Z)V", "initAdapter", "M0", "loadData", "L1", "j1", "F1", "c1", "b1", "Lcom/transsion/moviedetailapi/bean/Subject;", "subjectItem", "Landroid/content/Context;", "context", "N0", "(Lcom/transsion/moviedetailapi/bean/Subject;Landroid/content/Context;)V", "I1", "d1", "a1", "()Z", "Lcom/transsnet/downloader/bean/MovieRecBean;", "movieRecBean", "E1", "(Lcom/transsnet/downloader/bean/MovieRecBean;)V", "", "getPageName", "()Ljava/lang/String;", "z1", "m1", "l1", "L0", "resourceId", "", "W0", "(Ljava/lang/String;)I", "seriesList", "v1", "(Ljava/util/List;)V", WebConstants.FIELD_ITEM, "Z0", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "B1", "w1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onMemberStateChange", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "A1", "startLoading", "onPause", "Landroid/view/LayoutInflater;", "inflater", "Y0", "(Landroid/view/LayoutInflater;)Lpy/x;", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", TmcConstants.NAVIGATION_ON_START, "onDestroy", "hidden", "onHiddenChanged", "(Z)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "x1", "onResume", "Lcom/transsnet/downloader/adapter/DownloadExpandAdapter;", "a", "Lcom/transsnet/downloader/adapter/DownloadExpandAdapter;", "mAdapter", "Lcom/transsion/room/api/IAudioApi;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "Q0", "()Lcom/transsion/room/api/IAudioApi;", "audioApi", "Lcom/transsnet/downloader/manager/g;", "c", "R0", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", "d", "U0", "()Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", "downloadViewModel", "Lcom/transsnet/downloader/viewmodel/HistoricalPlayRecordViewModel;", "e", "V0", "()Lcom/transsnet/downloader/viewmodel/HistoricalPlayRecordViewModel;", "outDataViewModel", "Lcom/transsnet/downloader/adapter/v0;", "f", "Lcom/transsnet/downloader/adapter/v0;", "mMovieRecAdapter", "Lry/a;", be.g.f16474b, "T0", "()Lry/a;", "downloadReport", "h", "I", "pageType", "i", "Z", "isFirstStart", com.mbridge.msdk.foundation.same.report.j.f35620b, "isFirstHasData", CampaignEx.JSON_KEY_AD_K, "Ljava/util/List;", "lastList", "l", "showTransferLaterGuide", "m", "movieRecPage", "Lcom/transsnet/downloader/widget/DownloadPanelForYouFootView;", "n", "Lcom/transsnet/downloader/widget/DownloadPanelForYouFootView;", "forYouFootView", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "o", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "S0", "()Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "setDownloadNativeManager", "(Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "downloadNativeManager", TtmlNode.TAG_P, "X0", "y1", "seriesNativeManager", CampaignEx.JSON_KEY_AD_Q, "isShowAd", "Lsj/b;", CampaignEx.JSON_KEY_AD_R, "Lsj/b;", "exposureHelper", "com/transsnet/downloader/fragment/DownloadPanelFragment$b", "s", "Lcom/transsnet/downloader/fragment/DownloadPanelFragment$b;", "audioListener", "com/transsnet/downloader/fragment/DownloadPanelFragment$c", "t", "Lcom/transsnet/downloader/fragment/DownloadPanelFragment$c;", "downloadListener", TmcStartParams.KEY_URL_SHORT, "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadPanelFragment extends BaseFragment<py.x> implements zm.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private DownloadExpandAdapter mAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.transsnet.downloader.adapter.v0 mMovieRecAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int pageType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstHasData;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private List lastList;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private DownloadPanelForYouFootView forYouFootView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private BiddingNativeManager downloadNativeManager;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private BiddingNativeManager seriesNativeManager;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isShowAd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy audioApi = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.l1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IAudioApi K0;
            K0 = DownloadPanelFragment.K0();
            return K0;
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadManager = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.m1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g O0;
            O0 = DownloadPanelFragment.O0();
            return O0;
        }
    });

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(DownloadViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy outDataViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(HistoricalPlayRecordViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$special$$inlined$activityViewModels$default$4
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

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadReport = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.n1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ry.a P0;
            P0 = DownloadPanelFragment.P0();
            return P0;
        }
    });

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstStart = true;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean showTransferLaterGuide = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int movieRecPage = 1;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final sj.b exposureHelper = new sj.b(0.4f, new d(), false, 4, null);

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final b audioListener = new b();

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final c downloadListener = new c();

    /* loaded from: classes7.dex */
    public static final class b implements com.transsion.player.orplayer.f {
        b() {
        }

        private final DownloadBean a(String str) {
            List<Object> data;
            DownloadExpandAdapter downloadExpandAdapter = DownloadPanelFragment.this.mAdapter;
            int size = (downloadExpandAdapter == null || (data = downloadExpandAdapter.getData()) == null) ? 0 : data.size();
            for (int i11 = 0; i11 < size; i11++) {
                DownloadExpandAdapter downloadExpandAdapter2 = DownloadPanelFragment.this.mAdapter;
                Intrinsics.e(downloadExpandAdapter2);
                n6.a aVar = (n6.a) downloadExpandAdapter2.getData().get(i11);
                if (aVar instanceof DownloadBean) {
                    DownloadBean downloadBean = (DownloadBean) aVar;
                    if (Intrinsics.c(downloadBean.getUrl(), str)) {
                        return downloadBean;
                    }
                }
            }
            return null;
        }

        @Override // com.transsion.player.orplayer.f
        public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
            f.a.a(this, z10, i11, i12, dVar);
        }

        @Override // com.transsion.player.orplayer.f
        public void initPlayer() {
            f.a.b(this);
        }

        @Override // com.transsion.player.orplayer.f
        public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
            f.a.c(this, eVar);
        }

        @Override // com.transsion.player.orplayer.f
        public void onBufferedPosition(long j11, ao.e eVar) {
            f.a.d(this, j11, eVar);
        }

        @Override // com.transsion.player.orplayer.f
        public void onCompletion(ao.e eVar) {
            DownloadBean a11;
            f.a.e(this, eVar);
            if ((eVar != null ? eVar.k() : null) == null || (a11 = a(eVar.k())) == null) {
                return;
            }
            a.C0856a.v(lg.a.f68962a, "audioPlay", "---onCompletion, to play, name = " + a11.getName(), false, 4, null);
            a11.setAudioStatus(6);
            com.transsion.player.orplayer.f audioListener = a11.getAudioListener();
            if (audioListener != null) {
                audioListener.onCompletion(eVar);
            }
        }

        @Override // com.transsion.player.orplayer.f
        public void onFocusChange(boolean z10) {
            f.a.g(this, z10);
        }

        @Override // com.transsion.player.orplayer.f
        public void onIsPlayingChanged(boolean z10) {
            f.a.h(this, z10);
        }

        @Override // com.transsion.player.orplayer.f
        public void onLoadingBegin(ao.e eVar) {
            f.a.i(this, eVar);
        }

        @Override // com.transsion.player.orplayer.f
        public void onLoadingEnd(ao.e eVar) {
            f.a.k(this, eVar);
        }

        @Override // com.transsion.player.orplayer.f
        public void onLoadingProgress(int i11, float f11, ao.e eVar) {
            f.a.m(this, i11, f11, eVar);
        }

        @Override // com.transsion.player.orplayer.f
        public void onLoopingStart() {
            f.a.o(this);
        }

        @Override // com.transsion.player.orplayer.f
        public void onMediaItemTransition(String str) {
            f.a.p(this, str);
        }

        @Override // com.transsion.player.orplayer.f
        public void onPlayError(PlayError playError, ao.e eVar) {
            f.a.q(this, playError, eVar);
        }

        @Override // com.transsion.player.orplayer.f
        public void onPlayerRelease(ao.e eVar) {
            DownloadBean a11;
            f.a.e(this, eVar);
            if ((eVar != null ? eVar.k() : null) == null || (a11 = a(eVar.k())) == null) {
                return;
            }
            a.C0856a.v(lg.a.f68962a, "audioPlay", "---onPlayerRelease, top, name = " + a11.getName(), false, 4, null);
            a11.setAudioStatus(4);
            com.transsion.player.orplayer.f audioListener = a11.getAudioListener();
            if (audioListener != null) {
                audioListener.onVideoPause(eVar);
            }
        }

        @Override // com.transsion.player.orplayer.f
        public void onPlayerReset() {
            f.a.v(this);
        }

        @Override // com.transsion.player.orplayer.f
        public void onPrepare(ao.e eVar) {
            f.a.w(this, eVar);
        }

        @Override // com.transsion.player.orplayer.f
        public void onProgress(long j11, ao.e eVar) {
            DownloadBean a11;
            f.a.y(this, j11, eVar);
            if ((eVar != null ? eVar.k() : null) == null || (a11 = a(eVar.k())) == null) {
                return;
            }
            a11.setAudioStatus(3);
            com.transsion.player.orplayer.f audioListener = a11.getAudioListener();
            if (audioListener != null) {
                audioListener.onProgress(j11, eVar);
            }
        }

        @Override // com.transsion.player.orplayer.f
        public void onRenderFirstFrame() {
            f.a.A(this);
        }

        @Override // com.transsion.player.orplayer.f
        public void onSetDataSource() {
            f.a.B(this);
        }

        @Override // com.transsion.player.orplayer.f
        public void onTracksAudioBitrateChange(int i11) {
            f.a.C(this, i11);
        }

        @Override // com.transsion.player.orplayer.f
        public void onTracksChange(mo.c cVar) {
            f.a.D(this, cVar);
        }

        @Override // com.transsion.player.orplayer.f
        public void onTracksVideoBitrateChange(int i11) {
            f.a.E(this, i11);
        }

        @Override // com.transsion.player.orplayer.f
        public void onVideoPause(ao.e eVar) {
            DownloadBean a11;
            f.a.F(this, eVar);
            if ((eVar != null ? eVar.k() : null) == null || (a11 = a(eVar.k())) == null) {
                return;
            }
            a.C0856a.f(lg.a.f68962a, "audioPlay", "---onVideoPause, to play, name = " + a11.getName(), false, 4, null);
            a11.setAudioStatus(4);
            com.transsion.player.orplayer.f audioListener = a11.getAudioListener();
            if (audioListener != null) {
                audioListener.onVideoPause(eVar);
            }
        }

        @Override // com.transsion.player.orplayer.f
        public void onVideoSizeChanged(int i11, int i12) {
            f.a.H(this, i11, i12);
        }

        @Override // com.transsion.player.orplayer.f
        public void onVideoStart(ao.e eVar) {
            DownloadBean a11;
            f.a.I(this, eVar);
            if ((eVar != null ? eVar.k() : null) == null || (a11 = a(eVar.k())) == null) {
                return;
            }
            a.C0856a.f(lg.a.f68962a, "audioPlay", "---onVideoStart, to play, name = " + a11.getName(), false, 4, null);
            a11.setAudioStatus(3);
            com.transsion.player.orplayer.f audioListener = a11.getAudioListener();
            if (audioListener != null) {
                audioListener.onVideoStart(eVar);
            }
        }

        @Override // com.transsion.player.orplayer.f
        public void setOnSeekCompleteListener() {
            f.a.K(this);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends ny.d {
        c() {
        }

        @Override // ny.d
        public void h(DownloadBean bean, int i11) {
            Intrinsics.h(bean, "bean");
            if (i11 == 5) {
                lg.a.f68962a.i("download", "onRefresh,getList status=" + i11 + ",bean=" + bean.getName() + " subjectId=" + bean.getSubjectId() + ",resourceId=" + bean.getResourceId(), true);
                DownloadListManager.a aVar = DownloadListManager.f60117m;
                aVar.a().H(aVar.a().V(), true, DownloadPanelFragment.this.getDownloadNativeManager());
                DownloadPanelFragment.this.V0().N();
                return;
            }
            Integer num = (Integer) DownloadListManager.f60117m.a().C().get(bean.getResourceId());
            if (num == null || num.intValue() < 0) {
                num = Integer.valueOf(DownloadPanelFragment.this.W0(bean.getResourceId()));
            }
            if (num.intValue() >= 0) {
                DownloadExpandAdapter downloadExpandAdapter = DownloadPanelFragment.this.mAdapter;
                if (downloadExpandAdapter != null) {
                    downloadExpandAdapter.notifyItemChanged(num.intValue(), bean);
                    return;
                }
                return;
            }
            lg.a.f68962a.i("download", "onRefresh position=" + num + ",status=" + i11 + ",bean=" + bean.getName() + " subjectId=" + bean.getSubjectId() + ",resourceId=" + bean.getResourceId(), true);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements sj.a {
        d() {
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            List<Object> data;
            com.transsnet.downloader.adapter.v0 v0Var = DownloadPanelFragment.this.mMovieRecAdapter;
            Subject subject = (v0Var == null || (data = v0Var.getData()) == null) ? null : (Subject) CollectionsKt.l0(data, i11);
            if (subject != null) {
                DownloadPanelFragment.this.T0().a(DownloadPanelFragment.this.getPageName(), subject, i11, j11);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements u0.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0.b f58982a;

        e(u0.b bVar) {
            this.f58982a = bVar;
        }

        @Override // com.transsnet.downloader.adapter.u0.b
        public void a(int i11, int i12) {
            u0.b bVar = this.f58982a;
            if (bVar != null) {
                bVar.a(i11, i12);
            }
        }

        @Override // com.transsnet.downloader.adapter.u0.b
        public void b(int i11, int i12, int i13, boolean z10) {
            u0.b.a.a(this, i11, i12, i13, z10);
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends DiffUtil.e {
        f() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(n6.a oldItem, n6.a newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            if (!(oldItem instanceof DownloadBean) || !(newItem instanceof DownloadBean)) {
                return false;
            }
            DownloadBean downloadBean = (DownloadBean) oldItem;
            DownloadBean downloadBean2 = (DownloadBean) newItem;
            return downloadBean.getStatus() == downloadBean2.getStatus() && downloadBean.getProgress() == downloadBean2.getProgress();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(n6.a oldItem, n6.a newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            if ((oldItem instanceof DownloadBean) && (newItem instanceof DownloadBean)) {
                return Intrinsics.c(((DownloadBean) oldItem).getResourceId(), ((DownloadBean) newItem).getResourceId());
            }
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class g implements u0.b {
        g() {
        }

        private final void c() {
            Fragment parentFragment = DownloadPanelFragment.this.getParentFragment();
            FileManagerFragment fileManagerFragment = parentFragment instanceof FileManagerFragment ? (FileManagerFragment) parentFragment : null;
            if (fileManagerFragment != null) {
                fileManagerFragment.b1();
            }
        }

        @Override // com.transsnet.downloader.adapter.u0.b
        public void a(int i11, int i12) {
            DownloadTransferLaterTipsView downloadTransferLaterTipsView;
            if (i12 == 4 || i12 == 5) {
                c();
                return;
            }
            if (i12 == 6 && DownloadPanelFragment.this.showTransferLaterGuide) {
                com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("download_transfer_later_guide", false);
                py.x mViewBinding = DownloadPanelFragment.this.getMViewBinding();
                if (mViewBinding != null && (downloadTransferLaterTipsView = mViewBinding.f73090d) != null) {
                    downloadTransferLaterTipsView.setVisibility(0);
                    downloadTransferLaterTipsView.startCountdown();
                }
                DownloadPanelFragment.this.showTransferLaterGuide = false;
            }
        }

        @Override // com.transsnet.downloader.adapter.u0.b
        public void b(int i11, int i12, int i13, boolean z10) {
            u0.b.a.a(this, i11, i12, i13, z10);
        }
    }

    /* loaded from: classes7.dex */
    public static final class h implements AdvRecyclerView.a {
        h() {
        }

        @Override // com.tn.lib.view.AdvRecyclerView.a
        public void a() {
            DownloadPanelFragment.this.loadData();
        }

        @Override // com.tn.lib.view.AdvRecyclerView.a
        public void b() {
            DownloadPanelFragment.this.loadData();
        }
    }

    /* loaded from: classes7.dex */
    public static final class i implements nh.n {
        i() {
        }

        @Override // nh.n
        public void onConnected() {
            n.a.a(this);
        }

        @Override // nh.n
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            DownloadPanelFragment.this.d1();
            DownloadPanelFragment.this.F1();
        }

        @Override // nh.n
        public void onDisconnected() {
            DownloadPanelFragment.this.I1();
            DownloadPanelFragment.this.c1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class j implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f58987a;

        j(Function1 function) {
            Intrinsics.h(function, "function");
            this.f58987a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f58987a;
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
            this.f58987a.invoke(obj);
        }
    }

    private final void B1(MovieRecBean movieRecBean) {
        List<Subject> items;
        DownloadPanelForYouFootView downloadPanelForYouFootView;
        AdvRecyclerView advRecyclerView;
        final List<Subject> items2;
        Pager pager;
        String nextPage;
        Integer v11;
        r6.f h02;
        r6.f h03;
        r6.f h04;
        DownloadExpandAdapter downloadExpandAdapter = this.mAdapter;
        int i11 = 1;
        if (downloadExpandAdapter != null && (h04 = downloadExpandAdapter.h0()) != null) {
            h04.t(true);
        }
        DownloadExpandAdapter downloadExpandAdapter2 = this.mAdapter;
        if (downloadExpandAdapter2 != null && (h03 = downloadExpandAdapter2.h0()) != null) {
            h03.z(false);
        }
        DownloadExpandAdapter downloadExpandAdapter3 = this.mAdapter;
        if (downloadExpandAdapter3 != null && (h02 = downloadExpandAdapter3.h0()) != null) {
            h02.y(false);
        }
        if (movieRecBean != null && (pager = movieRecBean.getPager()) != null && (nextPage = pager.getNextPage()) != null && (v11 = StringsKt.v(nextPage)) != null) {
            i11 = v11.intValue();
        }
        this.movieRecPage = i11;
        if (this.forYouFootView != null) {
            if (movieRecBean == null || (items = movieRecBean.getItems()) == null || (downloadPanelForYouFootView = this.forYouFootView) == null) {
                return;
            }
            downloadPanelForYouFootView.setData(items);
            return;
        }
        Context context = getContext();
        if (context != null) {
            DownloadPanelForYouFootView downloadPanelForYouFootView2 = new DownloadPanelForYouFootView(context);
            if (movieRecBean != null && (items2 = movieRecBean.getItems()) != null) {
                DownloadExpandAdapter downloadExpandAdapter4 = this.mAdapter;
                if (downloadExpandAdapter4 != null) {
                    BaseQuickAdapter.u(downloadExpandAdapter4, downloadPanelForYouFootView2, 0, 0, 6, null);
                }
                downloadPanelForYouFootView2.post(new Runnable() { // from class: com.transsnet.downloader.fragment.e1
                    @Override // java.lang.Runnable
                    public final void run() {
                        DownloadPanelFragment.C1(DownloadPanelFragment.this, items2);
                    }
                });
            }
            downloadPanelForYouFootView2.setRefreshClickCallback(new Function0() { // from class: com.transsnet.downloader.fragment.f1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit D1;
                    D1 = DownloadPanelFragment.D1(DownloadPanelFragment.this);
                    return D1;
                }
            });
            py.x mViewBinding = getMViewBinding();
            downloadPanelForYouFootView2.initBrowseReport((mViewBinding == null || (advRecyclerView = mViewBinding.f73088b) == null) ? null : advRecyclerView.getRecyclerView());
            this.forYouFootView = downloadPanelForYouFootView2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(DownloadPanelFragment downloadPanelFragment, List list) {
        DownloadPanelForYouFootView downloadPanelForYouFootView = downloadPanelFragment.forYouFootView;
        if (downloadPanelForYouFootView != null) {
            downloadPanelForYouFootView.setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(DownloadPanelFragment downloadPanelFragment) {
        downloadPanelFragment.w1();
        return Unit.f67184a;
    }

    private final void E1(MovieRecBean movieRecBean) {
        AdvRecyclerView advRecyclerView;
        if (this.pageType != DownloadPageType.DOWNLOAD.ordinal()) {
            return;
        }
        py.x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f73088b) == null || !advRecyclerView.isShowEmpty()) {
            B1(movieRecBean);
            return;
        }
        com.transsnet.downloader.adapter.v0 v0Var = this.mMovieRecAdapter;
        if (v0Var != null) {
            v0Var.n1(movieRecBean != null ? movieRecBean.getItems() : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1() {
        AdvRecyclerView advRecyclerView;
        AdvRecyclerView advRecyclerView2;
        View mViewEmpty;
        RecyclerView recyclerView;
        if (this.pageType != DownloadPageType.DOWNLOAD.ordinal()) {
            return;
        }
        py.x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f73088b) == null || !advRecyclerView.isShowEmpty()) {
            w1();
            return;
        }
        py.x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (advRecyclerView2 = mViewBinding2.f73088b) == null || (mViewEmpty = advRecyclerView2.getMViewEmpty()) == null || (recyclerView = (RecyclerView) mViewEmpty.findViewById(R$id.movie_rec_list)) == null) {
            return;
        }
        jg.c.k(recyclerView);
        if (a1()) {
            return;
        }
        DownloadViewModel U0 = U0();
        if (U0 != null) {
            U0.S(1, 9);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        final com.transsnet.downloader.adapter.v0 v0Var = new com.transsnet.downloader.adapter.v0(new ArrayList());
        v0Var.w1(new p6.d() { // from class: com.transsnet.downloader.fragment.z0
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadPanelFragment.G1(DownloadPanelFragment.this, baseQuickAdapter, view, i11);
            }
        });
        v0Var.l(R$id.download);
        v0Var.s1(new p6.b() { // from class: com.transsnet.downloader.fragment.a1
            @Override // p6.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadPanelFragment.H1(DownloadPanelFragment.this, v0Var, baseQuickAdapter, view, i11);
            }
        });
        this.mMovieRecAdapter = v0Var;
        recyclerView.setAdapter(v0Var);
        recyclerView.addOnScrollListener(this.exposureHelper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(DownloadPanelFragment downloadPanelFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            downloadPanelFragment.Z0(subject);
            downloadPanelFragment.T0().b(downloadPanelFragment.getPageName(), subject, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(DownloadPanelFragment downloadPanelFragment, com.transsnet.downloader.adapter.v0 v0Var, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        Subject subject = item instanceof Subject ? (Subject) item : null;
        if (view.getId() == R$id.download) {
            downloadPanelFragment.N0(subject, v0Var.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1() {
        AdvRecyclerView advRecyclerView;
        py.x mViewBinding;
        AdvRecyclerView advRecyclerView2;
        View mViewEmpty;
        py.x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (advRecyclerView = mViewBinding2.f73088b) == null || !advRecyclerView.isShowEmpty() || (mViewBinding = getMViewBinding()) == null || (advRecyclerView2 = mViewBinding.f73088b) == null || (mViewEmpty = advRecyclerView2.getMViewEmpty()) == null) {
            return;
        }
        final NoNetworkSmallView noNetworkSmallView = (NoNetworkSmallView) mViewEmpty.findViewById(R$id.no_network_view);
        if (noNetworkSmallView != null) {
            if (jg.c.i(noNetworkSmallView)) {
                return;
            }
            jg.c.k(noNetworkSmallView);
            noNetworkSmallView.retry(new Function0() { // from class: com.transsnet.downloader.fragment.b1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit J1;
                    J1 = DownloadPanelFragment.J1(NoNetworkSmallView.this, this);
                    return J1;
                }
            });
            noNetworkSmallView.goToSetting(new Function0() { // from class: com.transsnet.downloader.fragment.c1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit K1;
                    K1 = DownloadPanelFragment.K1(DownloadPanelFragment.this);
                    return K1;
                }
            });
        }
        com.tn.lib.view.r.a(getPageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J1(NoNetworkSmallView noNetworkSmallView, DownloadPanelFragment downloadPanelFragment) {
        if (nh.m.f70597a.e()) {
            jg.c.g(noNetworkSmallView);
        }
        com.tn.lib.view.r.b(downloadPanelFragment.getPageName());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAudioApi K0() {
        return (IAudioApi) TheRouter.d(IAudioApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(DownloadPanelFragment downloadPanelFragment) {
        com.tn.lib.view.r.c(downloadPanelFragment.getPageName());
        return Unit.f67184a;
    }

    private final void L0() {
        DownloadExpandAdapter downloadExpandAdapter = this.mAdapter;
        if (downloadExpandAdapter != null) {
            downloadExpandAdapter.K1();
        }
        List list = this.lastList;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((DownloadBean) it.next()).setWrapNativeManager(null);
            }
        }
    }

    private final void L1() {
        AdvRecyclerView advRecyclerView;
        py.x mViewBinding = getMViewBinding();
        if (mViewBinding != null && (advRecyclerView = mViewBinding.f73088b) != null) {
            advRecyclerView.showEmpty();
            Unit unit = Unit.f67184a;
        }
        j1();
        if (nh.m.f70597a.e()) {
            d1();
            F1();
        } else {
            I1();
        }
        DownloadPageType.DOWNLOAD.ordinal();
    }

    private final void M0() {
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        DownloadListManager.I(aVar.a(), aVar.a().V(), false, this.downloadNativeManager, 2, null);
    }

    private final void M1(List list, boolean deduplicate) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            L1();
            return;
        }
        A1();
        DownloadPageType.DOWNLOAD.ordinal();
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        DownloadExpandAdapter downloadExpandAdapter = this.mAdapter;
        if (downloadExpandAdapter != null) {
            downloadExpandAdapter.X1(list);
        }
        if (this.isShowAd) {
            return;
        }
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new DownloadPanelFragment$updateList$1(this, null), 3, null);
    }

    private final void N0(Subject subjectItem, Context context) {
        String str;
        if (subjectItem == null) {
            return;
        }
        Integer subjectType = subjectItem.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        String str2 = "download_subject";
        if (subjectType != null && subjectType.intValue() == value) {
            DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
            Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            a11.d0((FragmentActivity) context, getPageName(), (r22 & 4) != 0 ? "" : "", null, (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : true, (r22 & 64) != 0 ? null : subjectItem, (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
            T0().c(getPageName(), subjectItem, "download_subject");
            return;
        }
        if (ak.t.f727a.b()) {
            Z0(subjectItem);
            T0().c(getPageName(), subjectItem, "play_subject");
            return;
        }
        DownloadManagerApi.a aVar = DownloadManagerApi.f58521j;
        DownloadManagerApi a12 = aVar.a();
        String subjectId = subjectItem.getSubjectId();
        ResourceDetectors resourceDetector = subjectItem.getResourceDetector();
        if (DownloadManagerApi.x0(a12, subjectId, resourceDetector != null ? resourceDetector.getResourceId() : null, subjectItem.isSeries(), false, 8, null)) {
            String subjectId2 = subjectItem.getSubjectId();
            if (subjectId2 != null) {
                DownloadManagerApi.z0(aVar.a(), subjectId2, context, getPageName(), null, 8, null);
            }
            str2 = "play_subject";
        } else {
            DownloadManagerApi a13 = aVar.a();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            String pageName = getPageName();
            String ops = subjectItem.getOps();
            ResourceDetectors resourceDetector2 = subjectItem.getResourceDetector();
            if (resourceDetector2 == null || (str = resourceDetector2.getResourceLink()) == null) {
                str = "";
            }
            a13.K(requireActivity, subjectItem, pageName, (r25 & 8) != 0 ? "" : null, ops, str, (r25 & 64) != 0 ? "" : null, (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : null, (r25 & 512) != 0 ? false : false);
        }
        T0().c(getPageName(), subjectItem, str2);
    }

    static /* synthetic */ void N1(DownloadPanelFragment downloadPanelFragment, List list, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        downloadPanelFragment.M1(list, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g O0() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ry.a P0() {
        return new ry.a();
    }

    private final IAudioApi Q0() {
        return (IAudioApi) this.audioApi.getValue();
    }

    private final com.transsnet.downloader.manager.g R0() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ry.a T0() {
        return (ry.a) this.downloadReport.getValue();
    }

    private final DownloadViewModel U0() {
        return (DownloadViewModel) this.downloadViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HistoricalPlayRecordViewModel V0() {
        return (HistoricalPlayRecordViewModel) this.outDataViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int W0(String resourceId) {
        List<Object> data;
        DownloadExpandAdapter downloadExpandAdapter = this.mAdapter;
        int size = (downloadExpandAdapter == null || (data = downloadExpandAdapter.getData()) == null) ? 0 : data.size();
        for (int i11 = 0; i11 < size; i11++) {
            DownloadExpandAdapter downloadExpandAdapter2 = this.mAdapter;
            Intrinsics.e(downloadExpandAdapter2);
            n6.a aVar = (n6.a) downloadExpandAdapter2.getData().get(i11);
            if ((aVar instanceof DownloadBean) && Intrinsics.c(((DownloadBean) aVar).getResourceId(), resourceId)) {
                return i11;
            }
        }
        return -1;
    }

    private final void Z0(Subject item) {
        if (item != null) {
            Integer subjectType = item.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
                Context context = getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                a11.d0((FragmentActivity) context, getPageName(), (r22 & 4) != 0 ? "" : "", item.getOps(), (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : false, (r22 & 64) != 0 ? null : item, (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        Navigator c11 = TheRouter.c("/movie/detail");
        Integer subjectType2 = item.getSubjectType();
        ak.k.p(c11.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("id", item.getSubjectId()).K("ops", item.getOps()));
    }

    private final boolean a1() {
        com.transsnet.downloader.adapter.v0 v0Var = this.mMovieRecAdapter;
        return (v0Var != null ? v0Var.getItemCount() : 0) > 0;
    }

    private final void b1() {
        AdvRecyclerView advRecyclerView;
        py.x mViewBinding;
        AdvRecyclerView advRecyclerView2;
        View mViewEmpty;
        LinearLayoutCompat linearLayoutCompat;
        r6.f h02;
        r6.f h03;
        r6.f h04;
        DownloadExpandAdapter downloadExpandAdapter = this.mAdapter;
        if (downloadExpandAdapter != null && (h04 = downloadExpandAdapter.h0()) != null) {
            h04.t(true);
        }
        DownloadExpandAdapter downloadExpandAdapter2 = this.mAdapter;
        if (downloadExpandAdapter2 != null && (h03 = downloadExpandAdapter2.h0()) != null) {
            h03.z(false);
        }
        DownloadExpandAdapter downloadExpandAdapter3 = this.mAdapter;
        if (downloadExpandAdapter3 != null && (h02 = downloadExpandAdapter3.h0()) != null) {
            h02.y(false);
        }
        py.x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (advRecyclerView = mViewBinding2.f73088b) == null || !advRecyclerView.isShowEmpty() || (mViewBinding = getMViewBinding()) == null || (advRecyclerView2 = mViewBinding.f73088b) == null || (mViewEmpty = advRecyclerView2.getMViewEmpty()) == null || (linearLayoutCompat = (LinearLayoutCompat) mViewEmpty.findViewById(R$id.ll_movie_rec)) == null) {
            return;
        }
        jg.c.g(linearLayoutCompat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1() {
        AdvRecyclerView advRecyclerView;
        py.x mViewBinding;
        AdvRecyclerView advRecyclerView2;
        View mViewEmpty;
        RecyclerView recyclerView;
        py.x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (advRecyclerView = mViewBinding2.f73088b) == null || !advRecyclerView.isShowEmpty() || (mViewBinding = getMViewBinding()) == null || (advRecyclerView2 = mViewBinding.f73088b) == null || (mViewEmpty = advRecyclerView2.getMViewEmpty()) == null || (recyclerView = (RecyclerView) mViewEmpty.findViewById(R$id.movie_rec_list)) == null) {
            return;
        }
        jg.c.g(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1() {
        AdvRecyclerView advRecyclerView;
        py.x mViewBinding;
        AdvRecyclerView advRecyclerView2;
        View mViewEmpty;
        NoNetworkSmallView noNetworkSmallView;
        py.x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (advRecyclerView = mViewBinding2.f73088b) == null || !advRecyclerView.isShowEmpty() || (mViewBinding = getMViewBinding()) == null || (advRecyclerView2 = mViewBinding.f73088b) == null || (mViewEmpty = advRecyclerView2.getMViewEmpty()) == null || (noNetworkSmallView = (NoNetworkSmallView) mViewEmpty.findViewById(R$id.no_network_view)) == null) {
            return;
        }
        jg.c.g(noNetworkSmallView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(final DownloadPanelFragment downloadPanelFragment, int i11, View view, DownloadBean bean, int i12, u0.b bVar) {
        Intrinsics.h(view, "view");
        Intrinsics.h(bean, "bean");
        PopupManager popupManager = new PopupManager(i11, bean);
        popupManager.J(view, i12);
        popupManager.C(new Function0() { // from class: com.transsnet.downloader.fragment.y0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit f12;
                f12 = DownloadPanelFragment.f1(DownloadPanelFragment.this);
                return f12;
            }
        });
        popupManager.B(new e(bVar));
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(DownloadPanelFragment downloadPanelFragment) {
        if (downloadPanelFragment.pageType == DownloadPageType.DOWNLOAD.ordinal()) {
            downloadPanelFragment.U0().J().q(1);
            downloadPanelFragment.U0().j0().q(0);
        } else {
            com.transsnet.downloader.popup.b bVar = new com.transsnet.downloader.popup.b(1, 0);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = com.transsnet.downloader.popup.b.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, bVar, 0L);
            FragmentActivity activity = downloadPanelFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(DownloadExpandAdapter downloadExpandAdapter, DownloadPanelFragment downloadPanelFragment) {
        if (!nh.m.f70597a.e()) {
            downloadExpandAdapter.h0().t(true);
        } else {
            downloadExpandAdapter.h0().w();
            downloadPanelFragment.w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPageName() {
        int i11 = this.pageType;
        DownloadPageType downloadPageType = DownloadPageType.SERIES;
        return i11 == downloadPageType.ordinal() ? downloadPageType.getPageName() : DownloadPageType.DOWNLOAD.getPageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(DownloadPanelFragment downloadPanelFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (view.getId() == R$id.v_all_ep_btn) {
            downloadPanelFragment.z1();
        }
    }

    private final void i1(DownloadBean seriesBean) {
        Object obj;
        if (seriesBean.getSeriesList().isEmpty()) {
            return;
        }
        Iterator<T> it = seriesBean.getSeriesList().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((DownloadBean) obj).getStatus() == 14) {
                    break;
                }
            }
        }
        if (((DownloadBean) obj) != null) {
            if (seriesBean.getSeriesList().size() == 1) {
                seriesBean.getSeriesList().clear();
            }
        } else if (seriesBean.getTotalEpisode() > seriesBean.getSeriesList().size()) {
            DownloadBean downloadBean = new DownloadBean("allEp", "allEp", seriesBean.getType() == 1 ? Utils.a().getResources().getString(R$string.download_series_all_chapters) : Utils.a().getResources().getString(R$string.download_series_all_episodes), "", 0L, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
            downloadBean.setStatus(14);
            seriesBean.getSeriesList().add(downloadBean);
        }
    }

    private final void initAdapter() {
        AdvRecyclerView advRecyclerView;
        AdvRecyclerView advRecyclerView2;
        py.x mViewBinding;
        AdvRecyclerView advRecyclerView3;
        if (this.pageType != DownloadPageType.SERIES.ordinal() && (mViewBinding = getMViewBinding()) != null && (advRecyclerView3 = mViewBinding.f73088b) != null) {
            advRecyclerView3.resetEmptyView(R$layout.layout_download_empty_default);
        }
        py.x mViewBinding2 = getMViewBinding();
        RecyclerView recyclerView = (mViewBinding2 == null || (advRecyclerView2 = mViewBinding2.f73088b) == null) ? null : advRecyclerView2.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
        }
        int i11 = this.pageType;
        py.x mViewBinding3 = getMViewBinding();
        final DownloadExpandAdapter downloadExpandAdapter = new DownloadExpandAdapter(i11, this, mViewBinding3 != null ? mViewBinding3.f73088b : null, this.downloadNativeManager, new Function5() { // from class: com.transsnet.downloader.fragment.s0
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit e12;
                e12 = DownloadPanelFragment.e1(DownloadPanelFragment.this, ((Integer) obj).intValue(), (View) obj2, (DownloadBean) obj3, ((Integer) obj4).intValue(), (u0.b) obj5);
                return e12;
            }
        });
        if (this.pageType == DownloadPageType.DOWNLOAD.ordinal()) {
            downloadExpandAdapter.h0().C(new DownloadResLoadMoreView());
            downloadExpandAdapter.h0().z(true);
            downloadExpandAdapter.h0().y(true);
            downloadExpandAdapter.h0().E(4);
            downloadExpandAdapter.h0().D(new p6.f() { // from class: com.transsnet.downloader.fragment.d1
                @Override // p6.f
                public final void a() {
                    DownloadPanelFragment.g1(DownloadExpandAdapter.this, this);
                }
            });
        }
        downloadExpandAdapter.R0(new f());
        downloadExpandAdapter.W1(new g());
        downloadExpandAdapter.l(R$id.v_all_ep_btn);
        downloadExpandAdapter.s1(new p6.b() { // from class: com.transsnet.downloader.fragment.g1
            @Override // p6.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                DownloadPanelFragment.h1(DownloadPanelFragment.this, baseQuickAdapter, view, i12);
            }
        });
        this.mAdapter = downloadExpandAdapter;
        if (recyclerView != null) {
            recyclerView.setAdapter(downloadExpandAdapter);
        }
        py.x mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (advRecyclerView = mViewBinding4.f73088b) == null) {
            return;
        }
        advRecyclerView.setOnStateClickListener(new h());
    }

    private final void initViewModel() {
        androidx.view.b0 T;
        this.downloadNativeManager = new BiddingNativeManager();
        int i11 = this.pageType;
        if (i11 == DownloadPageType.DOWNLOAD.ordinal()) {
            DownloadListManager.a aVar = DownloadListManager.f60117m;
            Collection collection = (Collection) aVar.a().B().f();
            this.isFirstHasData = !(collection == null || collection.isEmpty());
            aVar.a().B().j(this, new j(new Function1() { // from class: com.transsnet.downloader.fragment.u0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit s12;
                    s12 = DownloadPanelFragment.s1(DownloadPanelFragment.this, (List) obj);
                    return s12;
                }
            }));
        } else if (i11 == DownloadPageType.SERIES.ordinal()) {
            DownloadListManager.f60117m.a().K().j(this, new j(new Function1() { // from class: com.transsnet.downloader.fragment.v0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit t12;
                    t12 = DownloadPanelFragment.t1(DownloadPanelFragment.this, (DownloadBean) obj);
                    return t12;
                }
            }));
        }
        DownloadViewModel U0 = U0();
        if (U0 == null || (T = U0.T()) == null) {
            return;
        }
        T.j(this, new j(new Function1() { // from class: com.transsnet.downloader.fragment.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u12;
                u12 = DownloadPanelFragment.u1(DownloadPanelFragment.this, (BaseDto) obj);
                return u12;
            }
        }));
    }

    private final void j1() {
        AdvRecyclerView advRecyclerView;
        TextView textView;
        py.x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f73088b) == null || (textView = (TextView) advRecyclerView.findViewById(R$id.tv_transfer)) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadPanelFragment.k1(DownloadPanelFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(DownloadPanelFragment downloadPanelFragment, View view) {
        downloadPanelFragment.U0().J().q(1);
        downloadPanelFragment.U0().j0().q(0);
    }

    private final void l1() {
        setNetListener(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        if (this.pageType != DownloadPageType.DOWNLOAD.ordinal()) {
            DownloadPageType.SERIES.ordinal();
        } else {
            startLoading();
            DownloadListManager.I(DownloadListManager.f60117m.a(), false, false, this.downloadNativeManager, 3, null);
        }
    }

    private final void m1() {
        Function1 function1 = new Function1() { // from class: com.transsnet.downloader.fragment.h1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n12;
                n12 = DownloadPanelFragment.n1(DownloadPanelFragment.this, (LocalVideoEvent) obj);
                return n12;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LocalVideoEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, kotlinx.coroutines.y0.c().q(), false, function1);
        if (this.pageType == DownloadPageType.DOWNLOAD.ordinal()) {
            Function1 function12 = new Function1() { // from class: com.transsnet.downloader.fragment.i1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit o12;
                    o12 = DownloadPanelFragment.o1(DownloadPanelFragment.this, (DownloadRefreshEvent) obj);
                    return o12;
                }
            };
            FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name2 = DownloadRefreshEvent.class.getName();
            Intrinsics.g(name2, "getName(...)");
            flowEventBus2.observeEvent(this, name2, state, kotlinx.coroutines.y0.c().q(), false, function12);
            Function1 function13 = new Function1() { // from class: com.transsnet.downloader.fragment.j1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit p12;
                    p12 = DownloadPanelFragment.p1(DownloadPanelFragment.this, (AddToDownloadEvent) obj);
                    return p12;
                }
            };
            FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name3 = AddToDownloadEvent.class.getName();
            Intrinsics.g(name3, "getName(...)");
            flowEventBus3.observeEvent(this, name3, state, kotlinx.coroutines.y0.c().q(), false, function13);
        }
        Function1 function14 = new Function1() { // from class: com.transsnet.downloader.fragment.k1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q12;
                q12 = DownloadPanelFragment.q1(DownloadPanelFragment.this, (uy.a) obj);
                return q12;
            }
        };
        FlowEventBus flowEventBus4 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name4 = uy.a.class.getName();
        Intrinsics.g(name4, "getName(...)");
        flowEventBus4.observeEvent(this, name4, state, kotlinx.coroutines.y0.c().q(), false, function14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(DownloadPanelFragment downloadPanelFragment, LocalVideoEvent value) {
        int i11;
        List<Object> data;
        Intrinsics.h(value, "value");
        try {
            a.C0856a.f(lg.a.f68962a, "LocalVideo-d", "observeEvent resourceId:" + value.getResourceId() + ",readProgress: " + value.getReadProgress() + ", isSeries: " + value.isSeries(), false, 4, null);
            DownloadExpandAdapter downloadExpandAdapter = downloadPanelFragment.mAdapter;
            i11 = -1;
            if (downloadExpandAdapter != null && (data = downloadExpandAdapter.getData()) != null) {
                Iterator<Object> it = data.iterator();
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n6.a aVar = (n6.a) it.next();
                    if ((aVar instanceof DownloadBean) && Intrinsics.c(((DownloadBean) aVar).getResourceId(), value.getResourceId())) {
                        i11 = i12;
                        break;
                    }
                    i12++;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (value.isSeries() && downloadPanelFragment.pageType == DownloadPageType.DOWNLOAD.ordinal() && i11 < 0) {
            DownloadListManager.a aVar2 = DownloadListManager.f60117m;
            DownloadListManager.I(aVar2.a(), aVar2.a().V(), false, downloadPanelFragment.downloadNativeManager, 2, null);
            return Unit.f67184a;
        }
        if (i11 >= 0) {
            DownloadExpandAdapter downloadExpandAdapter2 = downloadPanelFragment.mAdapter;
            if (i11 < (downloadExpandAdapter2 != null ? downloadExpandAdapter2.getItemCount() : 0)) {
                DownloadExpandAdapter downloadExpandAdapter3 = downloadPanelFragment.mAdapter;
                Intrinsics.e(downloadExpandAdapter3);
                Object obj = downloadExpandAdapter3.getData().get(i11);
                Intrinsics.f(obj, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
                DownloadBean downloadBean = (DownloadBean) obj;
                a.C0856a.f(lg.a.f68962a, "LocalVideo-d", "observeEvent index:" + i11 + ", " + downloadBean.getTotalTitleName(), false, 4, null);
                if (value.getReadProgress() >= 0) {
                    downloadBean.setReadProgress(value.getReadProgress());
                }
                if (value.getDuration() >= 0) {
                    downloadBean.setDuration(Long.valueOf(value.getDuration()));
                }
                if (value.getRefreshItemAll()) {
                    DownloadExpandAdapter downloadExpandAdapter4 = downloadPanelFragment.mAdapter;
                    if (downloadExpandAdapter4 != null) {
                        downloadExpandAdapter4.notifyItemChanged(i11);
                    }
                } else {
                    DownloadExpandAdapter downloadExpandAdapter5 = downloadPanelFragment.mAdapter;
                    if (downloadExpandAdapter5 != null) {
                        downloadExpandAdapter5.notifyItemChanged(i11, downloadBean);
                    }
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(DownloadPanelFragment downloadPanelFragment, DownloadRefreshEvent value) {
        DownloadExpandAdapter downloadExpandAdapter;
        DownloadExpandAdapter downloadExpandAdapter2;
        List<Object> data;
        Intrinsics.h(value, "value");
        String resourceId = value.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            DownloadListManager.a aVar = DownloadListManager.f60117m;
            DownloadListManager.I(aVar.a(), aVar.a().V(), false, downloadPanelFragment.downloadNativeManager, 2, null);
        } else {
            String subjectId = value.getSubjectId();
            int i11 = -1;
            if (subjectId != null && subjectId.length() != 0 && (downloadExpandAdapter2 = downloadPanelFragment.mAdapter) != null && (data = downloadExpandAdapter2.getData()) != null) {
                Iterator<Object> it = data.iterator();
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n6.a aVar2 = (n6.a) it.next();
                    if (aVar2 instanceof DownloadBean ? Intrinsics.c(((DownloadBean) aVar2).getSubjectId(), value.getSubjectId()) : false) {
                        i11 = i12;
                        break;
                    }
                    i12++;
                }
            }
            if (i11 >= 0) {
                DownloadExpandAdapter downloadExpandAdapter3 = downloadPanelFragment.mAdapter;
                if (downloadExpandAdapter3 != null) {
                    downloadExpandAdapter3.notifyItemChanged(i11);
                }
            } else {
                Integer num = (Integer) DownloadListManager.f60117m.a().C().get(value.getResourceId());
                if (num != null && num.intValue() >= 0 && (downloadExpandAdapter = downloadPanelFragment.mAdapter) != null) {
                    downloadExpandAdapter.notifyItemChanged(num.intValue());
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(DownloadPanelFragment downloadPanelFragment, AddToDownloadEvent value) {
        AdvRecyclerView advRecyclerView;
        Intrinsics.h(value, "value");
        py.x mViewBinding = downloadPanelFragment.getMViewBinding();
        if (mViewBinding != null && (advRecyclerView = mViewBinding.f73088b) != null && advRecyclerView.isShowEmpty() && downloadPanelFragment.isVisible() && value.getAdd()) {
            downloadPanelFragment.lazyLoadData();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(DownloadPanelFragment downloadPanelFragment, uy.a it) {
        Intrinsics.h(it, "it");
        DownloadExpandAdapter downloadExpandAdapter = downloadPanelFragment.mAdapter;
        if (downloadExpandAdapter != null) {
            downloadExpandAdapter.notifyItemChanged(0);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(DownloadPanelFragment downloadPanelFragment) {
        downloadPanelFragment.M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(DownloadPanelFragment downloadPanelFragment, List list) {
        SwipeRefreshLayout swipeRefreshLayout;
        py.x mViewBinding;
        SwipeRefreshLayout swipeRefreshLayout2;
        py.x mViewBinding2 = downloadPanelFragment.getMViewBinding();
        if (mViewBinding2 != null && (swipeRefreshLayout = mViewBinding2.f73089c) != null && swipeRefreshLayout.isRefreshing() && (mViewBinding = downloadPanelFragment.getMViewBinding()) != null && (swipeRefreshLayout2 = mViewBinding.f73089c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        if (downloadPanelFragment.isFirstHasData) {
            downloadPanelFragment.isFirstHasData = false;
            return Unit.f67184a;
        }
        N1(downloadPanelFragment, list, false, 2, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(DownloadPanelFragment downloadPanelFragment, DownloadBean downloadBean) {
        SwipeRefreshLayout swipeRefreshLayout;
        py.x mViewBinding;
        SwipeRefreshLayout swipeRefreshLayout2;
        py.x mViewBinding2 = downloadPanelFragment.getMViewBinding();
        if (mViewBinding2 != null && (swipeRefreshLayout = mViewBinding2.f73089c) != null && swipeRefreshLayout.isRefreshing() && (mViewBinding = downloadPanelFragment.getMViewBinding()) != null && (swipeRefreshLayout2 = mViewBinding.f73089c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        if (downloadBean != null) {
            a.C0856a.f(lg.a.f68962a, "LocalVideo", "updateSeries fragment, size = " + downloadBean.getSeriesList().size(), false, 4, null);
            downloadPanelFragment.v1(downloadBean.getSeriesList());
            downloadPanelFragment.i1(downloadBean);
            downloadPanelFragment.M1(downloadBean.getSeriesList(), false);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(DownloadPanelFragment downloadPanelFragment, BaseDto baseDto) {
        if (!Intrinsics.c(baseDto.getCode(), "0") || baseDto.getData() == null) {
            downloadPanelFragment.b1();
        } else {
            downloadPanelFragment.E1((MovieRecBean) baseDto.getData());
        }
        return Unit.f67184a;
    }

    private final void v1(List seriesList) {
        if (seriesList.isEmpty()) {
            return;
        }
        Iterator it = seriesList.iterator();
        boolean z10 = false;
        boolean z11 = false;
        while (it.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it.next();
            if (!z10 && downloadBean.getStatus() < 10) {
                z10 = true;
            }
            if (downloadBean.getAdProvide() != null || downloadBean.getWrapNativeManager() != null) {
                z11 = true;
            }
        }
        if (!z10) {
            seriesList.clear();
            return;
        }
        if (z11) {
            return;
        }
        DownloadBean downloadBean2 = new DownloadBean(CommonLogUtil.TAG_AD, CommonLogUtil.TAG_AD, CommonLogUtil.TAG_AD, "", 0L, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
        downloadBean2.setStatus(13);
        downloadBean2.setWrapNativeManager(this.seriesNativeManager);
        int p11 = com.transsion.ad.scene.a.p(com.transsion.ad.scene.a.f42255a, "DownloadTvListScene", 0, 2, null);
        if (p11 >= seriesList.size()) {
            seriesList.add(downloadBean2);
        } else {
            seriesList.add(p11, downloadBean2);
        }
    }

    private final void w1() {
        if (this.pageType == DownloadPageType.DOWNLOAD.ordinal()) {
            U0().S(this.movieRecPage, 9);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15, types: [n6.a] */
    private final void z1() {
        DownloadBean downloadBean;
        List<Object> data;
        DownloadExpandAdapter downloadExpandAdapter = this.mAdapter;
        if (downloadExpandAdapter != null) {
            if (downloadExpandAdapter == null || (data = downloadExpandAdapter.getData()) == null || !data.isEmpty()) {
                DownloadExpandAdapter downloadExpandAdapter2 = this.mAdapter;
                Intrinsics.e(downloadExpandAdapter2);
                Iterator<Object> it = downloadExpandAdapter2.getData().iterator();
                while (true) {
                    downloadBean = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    ?? r22 = (n6.a) it.next();
                    DownloadBean downloadBean2 = r22 instanceof DownloadBean ? (DownloadBean) r22 : null;
                    String subjectId = downloadBean2 != null ? downloadBean2.getSubjectId() : null;
                    if (subjectId != null && subjectId.length() > 0) {
                        downloadBean = r22;
                        break;
                    }
                }
                if (downloadBean == null) {
                    uh.b.f76876a.e(Utils.a().getString(com.tn.lib.widget.R$string.no_error_content));
                    return;
                }
                Subject subject = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -1, 134217727, null);
                DownloadBean downloadBean3 = downloadBean;
                subject.setSubjectId(downloadBean3.getSubjectId());
                subject.setOps(downloadBean3.getOps());
                subject.setTitle(downloadBean3.getSubjectName());
                subject.setSubjectType(Integer.valueOf(DownloadBean.INSTANCE.a(Integer.valueOf(downloadBean3.getType()))));
                if (downloadBean3.isShotTV()) {
                    DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
                    Context context = getContext();
                    Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    a11.d0((FragmentActivity) context, getPageName(), (r22 & 4) != 0 ? "" : "", subject.getOps(), (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : true, (r22 & 64) != 0 ? null : subject, (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
                    return;
                }
                DownloadManagerApi a12 = DownloadManagerApi.f58521j.a();
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.g(requireActivity, "requireActivity(...)");
                String pageName = DownloadPageType.SERIES.getPageName();
                String groupId = downloadBean3.getGroupId();
                String ops = downloadBean3.getOps();
                String sourceUrl = downloadBean3.getSourceUrl();
                if (sourceUrl == null) {
                    sourceUrl = "";
                }
                a12.K(requireActivity, subject, pageName, (r25 & 8) != 0 ? "" : groupId, ops, sourceUrl, (r25 & 64) != 0 ? "" : null, (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : null, (r25 & 512) != 0 ? false : false);
            }
        }
    }

    public final void A1() {
        AdvRecyclerView advRecyclerView;
        py.x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f73088b) == null) {
            return;
        }
        advRecyclerView.showData();
    }

    /* renamed from: S0, reason: from getter */
    public final BiddingNativeManager getDownloadNativeManager() {
        return this.downloadNativeManager;
    }

    /* renamed from: X0, reason: from getter */
    public final BiddingNativeManager getSeriesNativeManager() {
        return this.seriesNativeManager;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public py.x getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.x c11 = py.x.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        initViewModel();
        initAdapter();
        m1();
        l1();
        this.showTransferLaterGuide = com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("download_transfer_later_guide", true);
        if (this.pageType == DownloadPageType.DOWNLOAD.ordinal() || this.pageType != DownloadPageType.SERIES.ordinal()) {
            return;
        }
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new DownloadPanelFragment$initData$1(this, null), 3, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        SwipeRefreshLayout swipeRefreshLayout;
        Intrinsics.h(view, "view");
        IAudioApi Q0 = Q0();
        if (Q0 != null) {
            Q0.addPlayerListener(this.audioListener);
        }
        if (this.pageType == DownloadPageType.DOWNLOAD.ordinal()) {
            R0().e(this.downloadListener);
        }
        py.x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (swipeRefreshLayout = mViewBinding.f73089c) == null) {
            return;
        }
        if (this.pageType == DownloadPageType.SERIES.ordinal()) {
            swipeRefreshLayout.setEnabled(false);
        }
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R$color.bg_01));
        swipeRefreshLayout.setColorSchemeColors(androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_center), androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_start));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsnet.downloader.fragment.t0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                DownloadPanelFragment.r1(DownloadPanelFragment.this);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        loadData();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        return new hj.b(getPageName(), false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        DownloadPanelForYouFootView downloadPanelForYouFootView = this.forYouFootView;
        if (downloadPanelForYouFootView != null) {
            downloadPanelForYouFootView.configChange();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.pageType = arguments != null ? arguments.getInt("extra_page_type") : 0;
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.E(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        BiddingNativeManager biddingNativeManager;
        IAudioApi Q0 = Q0();
        if (Q0 != null) {
            Q0.removePlayerListener(this.audioListener);
        }
        super.onDestroy();
        if (this.pageType == DownloadPageType.DOWNLOAD.ordinal()) {
            BiddingNativeManager biddingNativeManager2 = this.downloadNativeManager;
            if (biddingNativeManager2 != null) {
                biddingNativeManager2.V();
            }
            R0().x(this.downloadListener);
        } else if (this.pageType == DownloadPageType.SERIES.ordinal() && (biddingNativeManager = this.seriesNativeManager) != null) {
            biddingNativeManager.V();
        }
        L0();
        this.isShowAd = false;
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.t(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            x1();
        }
        if (isResumed() && hidden) {
            this.exposureHelper.f();
        }
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    @Override // zm.e
    public void onMemberStateChange() {
        BiddingNativeManager biddingNativeManager = this.downloadNativeManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.downloadNativeManager = null;
        DownloadListManager.I(DownloadListManager.f60117m.a(), false, false, null, 3, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.exposureHelper.f();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DownloadPanelForYouFootView downloadPanelForYouFootView = this.forYouFootView;
        if (downloadPanelForYouFootView != null) {
            downloadPanelForYouFootView.onPageResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (isVisible()) {
            if (this.isFirstStart) {
                this.isFirstStart = false;
            } else if (this.pageType == DownloadPageType.DOWNLOAD.ordinal()) {
                DownloadListManager.a aVar = DownloadListManager.f60117m;
                DownloadListManager.I(aVar.a(), aVar.a().V(), false, this.downloadNativeManager, 2, null);
            }
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        AdvRecyclerView advRecyclerView;
        py.x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f73088b) == null) {
            return;
        }
        advRecyclerView.showProgress();
    }

    public final void x1() {
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        DownloadListManager.I(aVar.a(), aVar.a().V(), false, this.downloadNativeManager, 2, null);
    }

    public final void y1(BiddingNativeManager biddingNativeManager) {
        this.seriesNativeManager = biddingNativeManager;
    }
}
