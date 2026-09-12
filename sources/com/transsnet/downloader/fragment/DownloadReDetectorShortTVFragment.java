package com.transsnet.downloader.fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.DefaultView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$drawable;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.adapter.DownloadShortTvEpListAdapter;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.transsnet.downloader.widget.DownloadInfoExtendView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lg.a;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 ±\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002²\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b#\u0010!J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010\u0004J\u0017\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000fH\u0002¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020$H\u0002¢\u0006\u0004\b7\u0010'J\u0019\u0010:\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00052\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b<\u00105J/\u0010B\u001a\u00020\u00052\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u00052\u0006\u0010A\u001a\u00020$H\u0002¢\u0006\u0004\bD\u0010'J\u000f\u0010E\u001a\u00020\u0005H\u0002¢\u0006\u0004\bE\u0010\u0004J\u000f\u0010F\u001a\u00020\u0005H\u0002¢\u0006\u0004\bF\u0010\u0004J\u000f\u0010G\u001a\u00020\u0005H\u0002¢\u0006\u0004\bG\u0010\u0004J\u000f\u0010H\u001a\u00020\u0005H\u0002¢\u0006\u0004\bH\u0010\u0004J\u000f\u0010I\u001a\u00020\u001eH\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u001eH\u0002¢\u0006\u0004\bK\u0010JJ)\u0010P\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020\u000f2\b\b\u0002\u0010O\u001a\u00020\u0012H\u0002¢\u0006\u0004\bP\u0010QJ\u0011\u0010R\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\bR\u0010JJ\u000f\u0010S\u001a\u00020\u0005H\u0002¢\u0006\u0004\bS\u0010\u0004J\u0017\u0010U\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u0012H\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010W\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u0012H\u0002¢\u0006\u0004\bW\u0010VJ\u000f\u0010X\u001a\u00020\u0012H\u0002¢\u0006\u0004\bX\u0010\u0014J\u0017\u0010Z\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0012H\u0002¢\u0006\u0004\bZ\u0010VJ\u0017\u0010[\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0012H\u0002¢\u0006\u0004\b[\u0010VJ\u0017\u0010\\\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b\\\u0010.JQ\u0010d\u001a\u00020\u00052\b\u0010]\u001a\u0004\u0018\u00010\u000f2\u0006\u0010^\u001a\u00020\u000f2\b\u0010_\u001a\u0004\u0018\u00010\u000f2\b\u0010`\u001a\u0004\u0018\u00010\u000f2\b\u0010a\u001a\u0004\u0018\u00010\u000f2\b\u0010b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010c\u001a\u00020\u000fH\u0002¢\u0006\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010gR\u001b\u0010p\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR\u001b\u0010u\u001a\u00020q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010m\u001a\u0004\bs\u0010tR\u001b\u0010z\u001a\u00020v8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010m\u001a\u0004\bx\u0010yR\u0016\u0010}\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0083\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010gR\u0018\u0010\u0085\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010gR$\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020>0\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R$\u0010\u008b\u0001\u001a\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020>0\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010gR\u0018\u0010\u008f\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010gR\u0018\u0010\u0091\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010gR\u0018\u0010^\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0093\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010_\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u0093\u0001R\u001b\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u0093\u0001R\u001a\u0010a\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u0093\u0001R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u0093\u0001R\u0018\u0010¡\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010|R\u0018\u0010£\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¢\u0001\u0010|R\u0017\u0010¤\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010gR\u0019\u0010¦\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010\u0093\u0001R\u001c\u0010ª\u0001\u001a\u0005\u0018\u00010§\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0018\u0010¬\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b«\u0001\u0010|R\"\u0010°\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001¨\u0006³\u0001"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadReDetectorShortTVFragment;", "Lcom/transsnet/downloader/fragment/DownloadReDetectorBaseFragment;", "Lpy/f0;", "<init>", "()V", "", "initViewData", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "A1", "(Landroid/view/LayoutInflater;)Lpy/f0;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "", "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "initViewModel", "initListener", "retryLoadData", TmcConstants.NAVIGATION_ON_START, "onDestroy", "b2", "initHistory", "initView", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "V1", "(Landroid/view/View;)V", "T1", "Y1", "", RequestParameters.POSITION, "U1", "(I)V", "p1", "loadData", "l2", "", "totalSize", "X1", "(J)V", NativeComponentConstants.KEY_COMPONENT_TYPE, "Z1", "(Ljava/lang/String;)V", "Lcom/transsnet/downloader/bean/DownloadListBean;", "listBean", "n2", "(Lcom/transsnet/downloader/bean/DownloadListBean;)V", "totalEpisode", "m1", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "S1", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "n1", "", "Lcom/transsion/baselib/db/download/DownloadBean;", "list", "start", TtmlNode.END, "o2", "(Ljava/util/List;II)V", "o1", "showNotNetError", "k2", "showLoading", "j2", "w1", "()Landroid/view/View;", "v1", "Landroid/content/Context;", "context", "desText", "showRightBtn", "s1", "(Landroid/content/Context;Ljava/lang/String;Z)Landroid/view/View;", "r1", "W1", "selectAll", "c2", "(Z)V", "e2", "P1", "isSelected", "g2", "f2", "Q1", "pageName", "pageFrom", "subjectId", "postId", "ops", "resourceId", "taskId", "q1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "l", "I", "padding", "m", "itemHeight", "Lcom/transsnet/downloader/manager/StartDownloadHelper;", "n", "Lkotlin/Lazy;", "z1", "()Lcom/transsnet/downloader/manager/StartDownloadHelper;", "startDownloadHelper", "Lcom/transsion/baselib/db/video/ShortTVPlayDao;", "o", "x1", "()Lcom/transsion/baselib/db/video/ShortTVPlayDao;", "shortTVPlayDao", "Lry/f;", TtmlNode.TAG_P, "y1", "()Lry/f;", "shortTVReporter", CampaignEx.JSON_KEY_AD_Q, "Z", "isContentDataRequested", "Lcom/transsnet/downloader/adapter/DownloadShortTvEpListAdapter;", CampaignEx.JSON_KEY_AD_R, "Lcom/transsnet/downloader/adapter/DownloadShortTvEpListAdapter;", "shortTVEpAdapter", "s", "curUnlockAllCount", "t", "perUnlockCount", "", TmcStartParams.KEY_URL_SHORT, "Ljava/util/Map;", "unlockDownloadLst", "v", "inDownloadStatusMap", "w", "startPosition", "x", "endPosition", "y", "curDownloadTabPosition", "z", "Ljava/lang/String;", "A", "lastPageFrom", "Lcom/transsion/moviedetailapi/bean/Subject;", "B", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "C", "D", "groupId", "E", "F", "moduleName", "G", "scroll2Download", "H", "isSelectAll", "unableSize", "J", "formatSize", "Lcom/transsion/share/share/ShareDialogFragment;", "K", "Lcom/transsion/share/share/ShareDialogFragment;", "shareDialog", "L", "isRequestingData", "Lkotlin/Function0;", "M", "Lkotlin/jvm/functions/Function0;", "selectAllCallback", "N", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@Deprecated
@SourceDebugExtension
/* loaded from: classes7.dex */
public class DownloadReDetectorShortTVFragment extends DownloadReDetectorBaseFragment<py.f0> {

    /* renamed from: N, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: B, reason: from kotlin metadata */
    private Subject subject;

    /* renamed from: C, reason: from kotlin metadata */
    private String subjectId;

    /* renamed from: D, reason: from kotlin metadata */
    private String groupId;

    /* renamed from: E, reason: from kotlin metadata */
    private String ops;

    /* renamed from: F, reason: from kotlin metadata */
    private String moduleName;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean scroll2Download;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isSelectAll;

    /* renamed from: I, reason: from kotlin metadata */
    private int unableSize;

    /* renamed from: K, reason: from kotlin metadata */
    private ShareDialogFragment shareDialog;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isRequestingData;

    /* renamed from: M, reason: from kotlin metadata */
    private Function0 selectAllCallback;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isContentDataRequested;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private DownloadShortTvEpListAdapter shortTVEpAdapter;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int curUnlockAllCount;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private int perUnlockCount;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private int curDownloadTabPosition;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int padding = com.blankj.utilcode.util.a0.a(12.0f);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int itemHeight = (com.blankj.utilcode.util.y.e() - com.blankj.utilcode.util.a0.a(24.0f)) / 5;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Lazy startDownloadHelper = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.z3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            StartDownloadHelper m22;
            m22 = DownloadReDetectorShortTVFragment.m2();
            return m22;
        }
    });

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Lazy shortTVPlayDao = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.a4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ShortTVPlayDao h22;
            h22 = DownloadReDetectorShortTVFragment.h2();
            return h22;
        }
    });

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Lazy shortTVReporter = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.b4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ry.f i22;
            i22 = DownloadReDetectorShortTVFragment.i2();
            return i22;
        }
    });

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Map unlockDownloadLst = new LinkedHashMap();

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final Map inDownloadStatusMap = new LinkedHashMap();

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int startPosition = 1;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int endPosition = 1;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private String pageFrom = "";

    /* renamed from: A, reason: from kotlin metadata */
    private String lastPageFrom = "";

    /* renamed from: J, reason: from kotlin metadata */
    private String formatSize = "";

    /* renamed from: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorShortTVFragment a(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, boolean z10) {
            DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment = new DownloadReDetectorShortTVFragment();
            downloadReDetectorShortTVFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_subject_id", str3), TuplesKt.a("extra_group_id", str4), TuplesKt.a("extra_ops", str5), TuplesKt.a("extra_module_name", str6), TuplesKt.a("extra_download_scroll_to_download", Boolean.valueOf(z10))));
            return downloadReDetectorShortTVFragment;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements TabLayout.OnTabSelectedListener {
        b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            DownloadReDetectorShortTVFragment.this.S1(tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends RecyclerView.r {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            py.f0 f0Var;
            TabLayout tabLayout;
            TabLayout.Tab tabAt;
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
            int findFirstVisibleItemPosition = ((gridLayoutManager != null ? gridLayoutManager.findFirstVisibleItemPosition() : 0) + 24) / 25;
            if (findFirstVisibleItemPosition == DownloadReDetectorShortTVFragment.this.curDownloadTabPosition || (f0Var = (py.f0) DownloadReDetectorShortTVFragment.this.getMViewBinding()) == null || (tabLayout = f0Var.f72828t) == null || (tabAt = tabLayout.getTabAt(findFirstVisibleItemPosition)) == null) {
                return;
            }
            tabAt.select();
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements com.transsion.share.share.a {
        d() {
        }

        @Override // com.transsion.share.share.a
        public void a(String id2, PostType postType) {
            Intrinsics.h(id2, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
        }

        @Override // com.transsion.share.share.a
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Intrinsics.h(url, "url");
            Intrinsics.h(fileName, "fileName");
            Intrinsics.h(fileSize, "fileSize");
            Intrinsics.h(fileImage, "fileImage");
        }

        @Override // com.transsion.share.share.a
        public void d(String id2) {
            Intrinsics.h(id2, "id");
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0650a.c(this, str);
        }
    }

    /* loaded from: classes7.dex */
    static final class e implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59122a;

        e(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59122a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59122a;
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
            this.f59122a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, View view) {
        downloadReDetectorShortTVFragment.m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, View view) {
        Intrinsics.e(view);
        downloadReDetectorShortTVFragment.V1(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, View view) {
        Intrinsics.e(view);
        downloadReDetectorShortTVFragment.T1(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, View view) {
        Intrinsics.e(view);
        downloadReDetectorShortTVFragment.Y1(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, View view) {
        downloadReDetectorShortTVFragment.W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, View view) {
        downloadReDetectorShortTVFragment.W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void H1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, View view) {
        androidx.view.b0 G;
        Long l11;
        androidx.view.b0 F;
        FrameLayout frameLayout;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        py.f0 f0Var = (py.f0) downloadReDetectorShortTVFragment.getMViewBinding();
        if (f0Var != null && (frameLayout = f0Var.f72815g) != null && frameLayout.getVisibility() == 0) {
            lg.a.f68962a.p("download", new String[]{"DownloadReDetectorGroupMainFragment --> onDownload() --> 当前正在全选中"}, true);
            return;
        }
        DownloadResourcesDetectorViewModel viewModel = downloadReDetectorShortTVFragment.getViewModel();
        Map map = (viewModel == null || (F = viewModel.F()) == null) ? null : (Map) F.f();
        if (map == null || map.isEmpty()) {
            uh.b.f76876a.e(Utils.a().getString(com.transsnet.downloader.R$string.download_short_tv_unselected_toast));
        } else {
            DownloadResourcesDetectorViewModel viewModel2 = downloadReDetectorShortTVFragment.getViewModel();
            downloadReDetectorShortTVFragment.Q1((viewModel2 == null || (G = viewModel2.G()) == null || (l11 = (Long) G.f()) == null) ? 0L : l11.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, int i11) {
        downloadReDetectorShortTVFragment.U1(i11);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, DownloadListBean downloadListBean) {
        String str;
        List x10;
        List data;
        downloadReDetectorShortTVFragment.j2();
        if (downloadListBean == null) {
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = downloadReDetectorShortTVFragment.shortTVEpAdapter;
            if (downloadShortTvEpListAdapter != null && (data = downloadShortTvEpListAdapter.getData()) != null && data.size() == 0) {
                downloadReDetectorShortTVFragment.k2();
            }
            return Unit.f67184a;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = downloadReDetectorShortTVFragment.getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        List<DownloadItem> items = downloadListBean.getItems();
        a.C0856a.f(c0856a, tag, "get data from  net, size = " + (items != null ? Integer.valueOf(items.size()) : null), false, 4, null);
        Integer totalEpisode = downloadListBean.getTotalEpisode();
        if (totalEpisode != null && totalEpisode.intValue() == 0) {
            Subject subject = downloadReDetectorShortTVFragment.subject;
            downloadListBean.setTotalEpisode(Integer.valueOf(subject != null ? subject.getTotalEpisode() : 0));
        }
        downloadReDetectorShortTVFragment.n2(downloadListBean);
        DownloadUtil downloadUtil = DownloadUtil.f60023a;
        Subject subject2 = downloadReDetectorShortTVFragment.subject;
        String str2 = downloadReDetectorShortTVFragment.groupId;
        String str3 = downloadReDetectorShortTVFragment.pageFrom;
        String str4 = downloadReDetectorShortTVFragment.lastPageFrom;
        String str5 = downloadReDetectorShortTVFragment.ops;
        if (subject2 == null || (str = subject2.getTitle()) == null) {
            str = "";
        }
        x10 = downloadUtil.x(downloadListBean, subject2, (r21 & 4) != 0 ? null : str2, (r21 & 8) != 0 ? null : str3, (r21 & 16) != 0 ? null : str4, (r21 & 32) != 0 ? null : str5, (r21 & 64) != 0 ? null : str, (r21 & 128) != 0 ? null : null);
        downloadReDetectorShortTVFragment.o2(x10, downloadListBean.getStartPosition(), downloadListBean.getEndPosition());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, Map map) {
        downloadReDetectorShortTVFragment.p1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, Long l11) {
        Intrinsics.e(l11);
        downloadReDetectorShortTVFragment.X1(l11.longValue());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, String str) {
        Intrinsics.e(str);
        downloadReDetectorShortTVFragment.Z1(str);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N1(Integer num) {
        uh.b.f76876a.d((num != null && num.intValue() == 0) ? R$string.failed_toast : (num != null && num.intValue() == 2) ? com.transsnet.downloader.R$string.short_tv_favorite_remove_toast : com.transsnet.downloader.R$string.short_tv_favorite_toast);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit O1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, uy.c value) {
        BLImageView bLImageView;
        ShortTVFavInfo shortTVFavInfo;
        Intrinsics.h(value, "value");
        try {
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        if (!TextUtils.equals(value.c(), downloadReDetectorShortTVFragment.subjectId)) {
            return Unit.f67184a;
        }
        Subject subject = downloadReDetectorShortTVFragment.subject;
        if (subject != null && (shortTVFavInfo = subject.getShortTVFavInfo()) != null) {
            shortTVFavInfo.setFavoriteNum(value.b());
            shortTVFavInfo.setHasFavorite(value.a());
        }
        py.f0 f0Var = (py.f0) downloadReDetectorShortTVFragment.getMViewBinding();
        if (f0Var != null && (bLImageView = f0Var.f72822n) != null) {
            bLImageView.setSelected(value.a());
        }
        return Unit.f67184a;
    }

    private final boolean P1() {
        return this.unableSize < this.curUnlockAllCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, com.transsion.baselib.db.download.DownloadBean] */
    private final void Q1(long totalSize) {
        ProgressBar progressBar;
        BLFrameLayout bLFrameLayout;
        ProgressBar progressBar2;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        View view;
        androidx.view.b0 F;
        Map map;
        DownloadBean downloadBean;
        if (u0(totalSize)) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel != null && (F = viewModel.F()) != null && (map = (Map) F.f()) != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (this.unlockDownloadLst.containsKey(entry.getKey()) && (downloadBean = (DownloadBean) this.unlockDownloadLst.get(entry.getKey())) != null) {
                    arrayList.add(downloadBean);
                }
            }
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "onDownload ", false, 4, null);
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var != null && (view = f0Var.F) != null) {
            jg.c.k(view);
        }
        py.f0 f0Var2 = (py.f0) getMViewBinding();
        if (f0Var2 != null && (appCompatImageView = f0Var2.f72818j) != null) {
            jg.c.g(appCompatImageView);
        }
        py.f0 f0Var3 = (py.f0) getMViewBinding();
        if (f0Var3 != null && (appCompatTextView = f0Var3.f72830v) != null) {
            jg.c.g(appCompatTextView);
        }
        py.f0 f0Var4 = (py.f0) getMViewBinding();
        if (f0Var4 != null && (progressBar2 = f0Var4.f72824p) != null) {
            jg.c.k(progressBar2);
        }
        py.f0 f0Var5 = (py.f0) getMViewBinding();
        if (f0Var5 != null && (bLFrameLayout = f0Var5.f72814f) != null) {
            jg.c.k(bLFrameLayout);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        int i11 = 0;
        for (Object obj : arrayList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            ?? r32 = (DownloadBean) obj;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "toString(...)");
            r32.setTaskId(uuid);
            if (objectRef.element != 0) {
                int ep2 = r32.getEp();
                DownloadBean downloadBean2 = (DownloadBean) objectRef.element;
                if (ep2 >= (downloadBean2 != null ? downloadBean2.getEp() : 0)) {
                    q1(this.pageFrom, this.lastPageFrom, r32.getSubjectId(), r32.getPostId(), this.ops, r32.getResourceId(), uuid);
                    lg.a.f68962a.p("download", new String[]{"剧集多资源，下载点击，开始下载: subjectId = " + r32.getSubjectId() + ",resourceId = " + r32.getResourceId() + ", name = " + r32.getTotalTitleName()}, true);
                    i11 = i12;
                }
            }
            objectRef.element = r32;
            q1(this.pageFrom, this.lastPageFrom, r32.getSubjectId(), r32.getPostId(), this.ops, r32.getResourceId(), uuid);
            lg.a.f68962a.p("download", new String[]{"剧集多资源，下载点击，开始下载: subjectId = " + r32.getSubjectId() + ",resourceId = " + r32.getResourceId() + ", name = " + r32.getTotalTitleName()}, true);
            i11 = i12;
        }
        p0().D(arrayList);
        z1().f(arrayList);
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new DownloadReDetectorShortTVFragment$onDownload$3(this, null), 3, null);
        long size = ((arrayList.size() / 20) * 100) + 300;
        py.f0 f0Var6 = (py.f0) getMViewBinding();
        if (f0Var6 == null || (progressBar = f0Var6.f72824p) == null) {
            return;
        }
        progressBar.postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.d4
            @Override // java.lang.Runnable
            public final void run() {
                DownloadReDetectorShortTVFragment.R1(arrayList, this, objectRef);
            }
        }, size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void R1(List list, DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, Ref.ObjectRef objectRef) {
        androidx.view.b0 i11;
        DownloadBean downloadBean;
        androidx.view.b0 m11;
        if (list.isEmpty()) {
            return;
        }
        DownloadResourcesDetectorViewModel viewModel = downloadReDetectorShortTVFragment.getViewModel();
        if (viewModel != null && (m11 = viewModel.m()) != null) {
            m11.q(Boolean.TRUE);
        }
        DownloadResourcesDetectorViewModel viewModel2 = downloadReDetectorShortTVFragment.getViewModel();
        if (viewModel2 != null && (i11 = viewModel2.i()) != null) {
            int size = list.size();
            String str = downloadReDetectorShortTVFragment.formatSize;
            T t11 = objectRef.element;
            if (t11 != 0) {
                Intrinsics.e(t11);
                downloadBean = (DownloadBean) t11;
            } else {
                downloadBean = (DownloadBean) list.get(0);
            }
            i11.q(new com.transsnet.downloader.viewmodel.b(size, str, downloadBean, false));
        }
        downloadReDetectorShortTVFragment.m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void S1(TabLayout.Tab tab) {
        RecyclerView recyclerView;
        py.f0 f0Var;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        if (tab == null || !tab.isSelected()) {
            return;
        }
        this.curDownloadTabPosition = tab.getPosition();
        int position = tab.getPosition() * 25;
        py.f0 f0Var2 = (py.f0) getMViewBinding();
        Object layoutManager = (f0Var2 == null || (recyclerView3 = f0Var2.f72826r) == null) ? null : recyclerView3.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager != null) {
            int findFirstCompletelyVisibleItemPosition = ((position - gridLayoutManager.findFirstCompletelyVisibleItemPosition()) / 5) * this.itemHeight;
            py.f0 f0Var3 = (py.f0) getMViewBinding();
            if (f0Var3 == null || (recyclerView = f0Var3.f72826r) == null || !recyclerView.canScrollVertically(findFirstCompletelyVisibleItemPosition) || (f0Var = (py.f0) getMViewBinding()) == null || (recyclerView2 = f0Var.f72826r) == null) {
                return;
            }
            recyclerView2.scrollBy(0, findFirstCompletelyVisibleItemPosition);
        }
    }

    private final void T1(View view) {
        ShortTVFavInfo shortTVFavInfo;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        ry.f y12 = y1();
        String str = this.subjectId;
        Subject subject = this.subject;
        y12.e(str, "", (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) ? false : shortTVFavInfo.getHasFavorite(), "minitv_download");
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.f(this.subject);
        }
    }

    private final void U1(int position) {
        androidx.view.b0 G;
        androidx.view.b0 G2;
        androidx.view.b0 G3;
        Long l11;
        Long size;
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.shortTVEpAdapter;
        Intrinsics.e(downloadShortTvEpListAdapter);
        List data = downloadShortTvEpListAdapter.getData();
        if (position >= data.size()) {
            return;
        }
        my.c cVar = (my.c) data.get(position);
        if (cVar.b()) {
            return;
        }
        if (!cVar.c()) {
            if (position == this.curUnlockAllCount) {
                l2();
                return;
            } else {
                uh.b.f76876a.d(com.transsnet.downloader.R$string.unlock_in_order);
                return;
            }
        }
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.L(cVar);
        }
        DownloadBean downloadBean = (DownloadBean) this.unlockDownloadLst.get(Integer.valueOf(position));
        long j11 = 0;
        long longValue = (downloadBean == null || (size = downloadBean.getSize()) == null) ? 0L : size.longValue();
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (G3 = viewModel2.G()) != null && (l11 = (Long) G3.f()) != null) {
            j11 = l11.longValue();
        }
        if (cVar.d()) {
            cVar.g(false);
            DownloadResourcesDetectorViewModel viewModel3 = getViewModel();
            if (viewModel3 != null && (G2 = viewModel3.G()) != null) {
                G2.q(Long.valueOf(j11 - longValue));
            }
        } else {
            cVar.g(true);
            DownloadResourcesDetectorViewModel viewModel4 = getViewModel();
            if (viewModel4 != null && (G = viewModel4.G()) != null) {
                G.q(Long.valueOf(j11 + longValue));
            }
        }
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter2 = this.shortTVEpAdapter;
        if (downloadShortTvEpListAdapter2 != null) {
            downloadShortTvEpListAdapter2.notifyItemChanged(position, cVar);
        }
    }

    private final void V1(View view) {
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        Navigator c11 = TheRouter.c(ls.a.f69157a.b());
        Subject subject = this.subject;
        Navigator.x(c11.K("id", subject != null ? subject.getSubjectId() : null), requireContext(), null, 2, null);
        m0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W1() {
        AppCompatImageView appCompatImageView;
        if (com.transsion.baseui.util.c.f43558a.a(-912345, 1000L)) {
            return;
        }
        if (!P1()) {
            uh.b.f76876a.d(com.transsnet.downloader.R$string.download_no_options_toast);
            return;
        }
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var == null || (appCompatImageView = f0Var.f72819k) == null) {
            return;
        }
        boolean z10 = !appCompatImageView.isSelected();
        this.isSelectAll = z10;
        c2(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void X1(long totalSize) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        if (totalSize <= 0) {
            py.f0 f0Var = (py.f0) getMViewBinding();
            if (f0Var == null || (appCompatTextView2 = f0Var.f72830v) == null) {
                return;
            }
            appCompatTextView2.setText(Utils.a().getString(com.transsnet.downloader.R$string.str_download));
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.v(c0856a, tag, "observe totalSize:" + totalSize, false, 4, null);
        this.formatSize = oh.b.a(totalSize, 1);
        py.f0 f0Var2 = (py.f0) getMViewBinding();
        if (f0Var2 == null || (appCompatTextView = f0Var2.f72830v) == null) {
            return;
        }
        appCompatTextView.setText(Utils.a().getString(com.transsnet.downloader.R$string.str_download) + " · " + this.formatSize);
    }

    private final void Y1(View view) {
        ShareDialogFragment a11;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        ry.f.g(y1(), this.subjectId, null, 2, null);
        if (this.shareDialog == null) {
            ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
            PostType postType = PostType.SHORT_TV_TYPE;
            String str = this.subjectId;
            String value = ReportType.SUBJECT.getValue();
            Subject subject = this.subject;
            a11 = companion.a(postType, str, "", value, (r29 & 16) != 0 ? "" : subject != null ? subject.getTitle() : null, (r29 & 32) != 0 ? "" : null, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : false, (r29 & 256) != 0 ? false : false, "subjectdetail", (r29 & 1024) != 0 ? "" : null, (r29 & 2048) != 0 ? "" : null);
            this.shareDialog = a11;
            if (a11 != null) {
                a11.G0(new d());
            }
        }
        try {
            if (isAdded()) {
                Context context = getContext();
                m0();
                ShareDialogFragment shareDialogFragment = this.shareDialog;
                if (shareDialogFragment != null) {
                    shareDialogFragment.K0(context, "share");
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private final void Z1(String type) {
        androidx.view.b0 F;
        List data;
        List data2;
        List data3;
        androidx.view.b0 F2;
        List data4;
        List data5;
        List data6;
        int hashCode = type.hashCode();
        if (hashCode != -1747705881) {
            if (hashCode != 229859771) {
                if (hashCode != 298697238) {
                    return;
                }
                type.equals("ad_cancel");
                return;
            } else if (!type.equals("ad_load_fail")) {
                return;
            }
        } else if (!type.equals("ad_success")) {
            return;
        }
        int i11 = this.endPosition;
        this.startPosition = i11 + 1;
        int i12 = i11 + this.perUnlockCount;
        this.endPosition = i12;
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.shortTVEpAdapter;
        if (i12 > ((downloadShortTvEpListAdapter == null || (data6 = downloadShortTvEpListAdapter.getData()) == null) ? 0 : data6.size())) {
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter2 = this.shortTVEpAdapter;
            this.endPosition = (downloadShortTvEpListAdapter2 == null || (data5 = downloadShortTvEpListAdapter2.getData()) == null) ? 0 : data5.size();
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "广告解锁成功 , 请求新数据， start：" + this.startPosition + ", end:" + this.endPosition, false, 4, null);
        com.transsnet.downloader.util.d0 d0Var = com.transsnet.downloader.util.d0.f60049a;
        String str = this.subjectId;
        if (str == null) {
            str = "";
        }
        d0Var.g(str, this.endPosition);
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter3 = this.shortTVEpAdapter;
        final String string = ((downloadShortTvEpListAdapter3 == null || (data4 = downloadShortTvEpListAdapter3.getData()) == null) ? 0 : data4.size()) - this.curUnlockAllCount <= this.perUnlockCount ? Utils.a().getString(com.transsnet.downloader.R$string.download_short_tv_watch_ad_all) : String.valueOf((this.endPosition - this.startPosition) + 1);
        Intrinsics.e(string);
        new Handler().postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.e4
            @Override // java.lang.Runnable
            public final void run() {
                DownloadReDetectorShortTVFragment.a2(string);
            }
        }, 400L);
        StringBuilder sb2 = new StringBuilder();
        int i13 = this.startPosition;
        int i14 = this.endPosition;
        if (i13 <= i14) {
            while (true) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(i13);
                if (i13 == i14) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        ry.f y12 = y1();
        Subject subject = this.subject;
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        ry.f.i(y12, subject, type, sb3, null, 8, null);
        int i15 = this.curUnlockAllCount;
        int i16 = this.endPosition;
        if (i15 < i16) {
            this.curUnlockAllCount = i16;
            DownloadResourcesDetectorViewModel viewModel = getViewModel();
            Map map = (viewModel == null || (F2 = viewModel.F()) == null) ? null : (Map) F2.f();
            if (map == null) {
                map = new LinkedHashMap();
            }
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter4 = this.shortTVEpAdapter;
            int size = (downloadShortTvEpListAdapter4 == null || (data3 = downloadShortTvEpListAdapter4.getData()) == null) ? 0 : data3.size();
            int i17 = this.endPosition;
            if (size >= i17) {
                for (int i18 = this.startPosition - 1; i18 < i17; i18++) {
                    DownloadShortTvEpListAdapter downloadShortTvEpListAdapter5 = this.shortTVEpAdapter;
                    if (i18 < ((downloadShortTvEpListAdapter5 == null || (data2 = downloadShortTvEpListAdapter5.getData()) == null) ? 0 : data2.size())) {
                        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter6 = this.shortTVEpAdapter;
                        my.c cVar = (downloadShortTvEpListAdapter6 == null || (data = downloadShortTvEpListAdapter6.getData()) == null) ? null : (my.c) data.get(i18);
                        if (cVar != null) {
                            if (this.isSelectAll) {
                                cVar.g(true);
                                map.put(Integer.valueOf(i18), cVar);
                            }
                            cVar.f(true);
                            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter7 = this.shortTVEpAdapter;
                            if (downloadShortTvEpListAdapter7 != null) {
                                downloadShortTvEpListAdapter7.notifyItemChanged(i18, cVar);
                            }
                        }
                    }
                }
            }
            DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
            if (viewModel2 != null && (F = viewModel2.F()) != null) {
                F.q(map);
            }
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(String str) {
        uh.b.f76876a.e(Utils.a().getString(com.transsnet.downloader.R$string.download_short_tv_unlock_success_toast, str));
    }

    private final void b2() {
        BiddingInterstitialManager.Companion companion = BiddingInterstitialManager.f42019w;
        com.transsion.ad.strategy.d dVar = com.transsion.ad.strategy.d.f42285a;
        Subject subject = this.subject;
        companion.a("ShortTvInterstitialScene", dVar.a(subject != null ? subject.getGenre() : null));
        BiddingVideoManager.Companion companion2 = BiddingVideoManager.f42103w;
        Subject subject2 = this.subject;
        companion2.a("ShortTvVideoScene", dVar.a(subject2 != null ? subject2.getGenre() : null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c2(final boolean selectAll) {
        FrameLayout frameLayout;
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "selectAll click, selectAll = " + selectAll + " ", false, 4, null);
        this.isSelectAll = selectAll;
        if (!this.isRequestingData) {
            e2(selectAll);
            return;
        }
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var != null && (frameLayout = f0Var.f72815g) != null) {
            jg.c.k(frameLayout);
        }
        this.selectAllCallback = new Function0() { // from class: com.transsnet.downloader.fragment.f4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit d22;
                d22 = DownloadReDetectorShortTVFragment.d2(DownloadReDetectorShortTVFragment.this, selectAll);
                return d22;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d2(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, boolean z10) {
        downloadReDetectorShortTVFragment.e2(z10);
        downloadReDetectorShortTVFragment.selectAllCallback = null;
        return Unit.f67184a;
    }

    private final void e2(boolean selectAll) {
        if (this.curUnlockAllCount > 30) {
            g2(selectAll);
        } else {
            f2(selectAll);
        }
    }

    private final void f2(boolean isSelected) {
        androidx.view.b0 G;
        androidx.view.b0 F;
        DownloadBean downloadBean;
        Long size;
        List data;
        List data2;
        androidx.view.b0 F2;
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        Map map = (viewModel == null || (F2 = viewModel.F()) == null) ? null : (Map) F2.f();
        if (map == null) {
            map = new LinkedHashMap();
        }
        map.clear();
        int i11 = this.curUnlockAllCount;
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.shortTVEpAdapter;
            if (i12 < ((downloadShortTvEpListAdapter == null || (data2 = downloadShortTvEpListAdapter.getData()) == null) ? 0 : data2.size())) {
                DownloadShortTvEpListAdapter downloadShortTvEpListAdapter2 = this.shortTVEpAdapter;
                my.c cVar = (downloadShortTvEpListAdapter2 == null || (data = downloadShortTvEpListAdapter2.getData()) == null) ? null : (my.c) data.get(i12);
                if (this.unlockDownloadLst.containsKey(Integer.valueOf(i12)) && (((downloadBean = (DownloadBean) this.unlockDownloadLst.get(Integer.valueOf(i12))) == null || !downloadBean.isUnable()) && cVar != null)) {
                    cVar.g(isSelected);
                    if (isSelected) {
                        j11 += (downloadBean == null || (size = downloadBean.getSize()) == null) ? 0L : size.longValue();
                        map.put(Integer.valueOf(i12), cVar);
                    } else {
                        map.remove(Integer.valueOf(i12));
                    }
                }
            }
        }
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (F = viewModel2.F()) != null) {
            F.q(map);
        }
        DownloadResourcesDetectorViewModel viewModel3 = getViewModel();
        if (viewModel3 != null && (G = viewModel3.G()) != null) {
            G.q(Long.valueOf(j11));
        }
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter3 = this.shortTVEpAdapter;
        if (downloadShortTvEpListAdapter3 != null) {
            downloadShortTvEpListAdapter3.notifyItemRangeChanged(0, this.curUnlockAllCount);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.LinkedHashMap, T] */
    private final void g2(boolean isSelected) {
        androidx.view.b0 F;
        FrameLayout frameLayout;
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var != null && (frameLayout = f0Var.f72815g) != null) {
            jg.c.k(frameLayout);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        T t11 = (viewModel == null || (F = viewModel.F()) == null) ? 0 : (Map) F.f();
        objectRef.element = t11;
        if (t11 == 0) {
            objectRef.element = new LinkedHashMap();
        }
        ((Map) objectRef.element).clear();
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1(this, isSelected, objectRef, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTVPlayDao h2() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ry.f i2() {
        return new ry.f();
    }

    private final void initHistory() {
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new DownloadReDetectorShortTVFragment$initHistory$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        AppBarLayout appBarLayout;
        AppCompatTextView appCompatTextView;
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var != null && (appCompatTextView = f0Var.C) != null) {
            Subject subject = this.subject;
            appCompatTextView.setText(subject != null ? subject.getTitle() : null);
        }
        py.f0 f0Var2 = (py.f0) getMViewBinding();
        if (f0Var2 != null && (appBarLayout = f0Var2.f72810b) != null) {
            appBarLayout.setExpanded(!this.scroll2Download);
        }
        py.f0 f0Var3 = (py.f0) getMViewBinding();
        if (f0Var3 != null && (recyclerView2 = f0Var3.f72826r) != null) {
            int i11 = this.padding;
            recyclerView2.setPadding(i11, 0, i11, 0);
            recyclerView2.setLayoutManager(new GridLayoutManager(recyclerView2.getContext(), 5, 1, false));
            recyclerView2.addOnScrollListener(new c());
        }
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = new DownloadShortTvEpListAdapter();
        downloadShortTvEpListAdapter.l(new Function1() { // from class: com.transsnet.downloader.fragment.c4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I1;
                I1 = DownloadReDetectorShortTVFragment.I1(DownloadReDetectorShortTVFragment.this, ((Integer) obj).intValue());
                return I1;
            }
        });
        this.shortTVEpAdapter = downloadShortTvEpListAdapter;
        py.f0 f0Var4 = (py.f0) getMViewBinding();
        if (f0Var4 == null || (recyclerView = f0Var4.f72826r) == null) {
            return;
        }
        recyclerView.setAdapter(this.shortTVEpAdapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j2() {
        FrameLayout frameLayout;
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var == null || (frameLayout = f0Var.f72816h) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k2() {
        FrameLayout frameLayout;
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var == null || (frameLayout = f0Var.f72816h) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        frameLayout.addView(v1());
    }

    private final void l2() {
        androidx.view.b0 p11;
        androidx.view.b0 H;
        androidx.view.b0 D;
        List data;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "showWatchAd", false, 4, null);
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.shortTVEpAdapter;
        int size = ((downloadShortTvEpListAdapter == null || (data = downloadShortTvEpListAdapter.getData()) == null) ? 0 : data.size()) - this.curUnlockAllCount;
        int i11 = this.perUnlockCount;
        String string = size <= i11 ? Utils.a().getString(com.transsnet.downloader.R$string.download_short_tv_watch_ad_all) : String.valueOf(i11);
        Intrinsics.e(string);
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel != null && (D = viewModel.D()) != null) {
            D.q(string);
        }
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (H = viewModel2.H()) != null) {
            H.q(this.subjectId);
        }
        DownloadResourcesDetectorViewModel viewModel3 = getViewModel();
        if (viewModel3 != null && (p11 = viewModel3.p()) != null) {
            p11.q(6);
        }
        ry.f.d(y1(), this.subjectId, "dialog_minitv_download_unlock", null, 4, null);
    }

    private final void loadData() {
        if (!nh.m.f70597a.e()) {
            showNotNetError();
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "loadData ,  startPosition:" + this.startPosition + ", endPosition:" + this.endPosition, false, 4, null);
        this.isRequestingData = true;
        DownloadListManager a11 = DownloadListManager.f60117m.a();
        Subject subject = this.subject;
        String subjectId = subject != null ? subject.getSubjectId() : null;
        int i11 = this.startPosition;
        int i12 = this.endPosition;
        Subject subject2 = this.subject;
        DownloadListManager.N(a11, subjectId, i11, i12, subject2 != null ? subject2.getTitle() : null, 0, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m1(int totalEpisode) {
        TabLayout tabLayout;
        TabLayout tabLayout2;
        TabLayout tabLayout3;
        int i11 = (totalEpisode + 24) / 25;
        if (i11 <= 1) {
            py.f0 f0Var = (py.f0) getMViewBinding();
            if (f0Var == null || (tabLayout3 = f0Var.f72828t) == null) {
                return;
            }
            jg.c.g(tabLayout3);
            return;
        }
        py.f0 f0Var2 = (py.f0) getMViewBinding();
        if (f0Var2 != null && (tabLayout2 = f0Var2.f72828t) != null) {
            tabLayout2.removeAllTabs();
            tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
        }
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 25;
            int i14 = i13 + 1;
            int i15 = RangesKt.i(i13 + 25, totalEpisode);
            py.f0 f0Var3 = (py.f0) getMViewBinding();
            if (f0Var3 != null && (tabLayout = f0Var3.f72828t) != null) {
                tabLayout.addTab(tabLayout.newTab().setText(i14 + "-" + i15));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StartDownloadHelper m2() {
        return new StartDownloadHelper();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n1(DownloadListBean listBean) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List<String> tags = listBean.getTags();
        if (tags == null || tags.isEmpty()) {
            py.f0 f0Var = (py.f0) getMViewBinding();
            if (f0Var == null || (recyclerView = f0Var.f72827s) == null) {
                return;
            }
            jg.c.g(recyclerView);
            return;
        }
        List<String> tags2 = listBean.getTags();
        Intrinsics.e(tags2);
        com.transsnet.downloader.adapter.t tVar = new com.transsnet.downloader.adapter.t(tags2);
        py.f0 f0Var2 = (py.f0) getMViewBinding();
        if (f0Var2 == null || (recyclerView2 = f0Var2.f72827s) == null) {
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView2.getContext());
        flexboxLayoutManager.c0(0);
        flexboxLayoutManager.d0(1);
        flexboxLayoutManager.e0(0);
        recyclerView2.setLayoutManager(flexboxLayoutManager);
        com.google.android.flexbox.d dVar = new com.google.android.flexbox.d(recyclerView2.getContext());
        dVar.l(3);
        dVar.i(androidx.core.content.b.getDrawable(Utils.a(), R$drawable.space_short_tv_tag_decoration));
        recyclerView2.addItemDecoration(dVar);
        recyclerView2.setAdapter(tVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n2(DownloadListBean listBean) {
        List data;
        String subjectId;
        DownloadInfoExtendView downloadInfoExtendView;
        BLImageView bLImageView;
        AppCompatTextView appCompatTextView;
        ShapeableImageView shapeableImageView;
        String str;
        String str2;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        Subject subject;
        if (this.isContentDataRequested) {
            return;
        }
        Integer totalEpisode = listBean.getTotalEpisode();
        if (totalEpisode != null && totalEpisode.intValue() == 0) {
            return;
        }
        int i11 = this.curUnlockAllCount;
        Integer totalEpisode2 = listBean.getTotalEpisode();
        if (i11 > (totalEpisode2 != null ? totalEpisode2.intValue() : 1)) {
            Integer totalEpisode3 = listBean.getTotalEpisode();
            this.curUnlockAllCount = totalEpisode3 != null ? totalEpisode3.intValue() : 1;
        }
        if (this.subject == null) {
            this.subject = new Subject(listBean.getSubjectId(), Integer.valueOf(listBean.getSubjectType()), listBean.getSubjectTitle(), null, null, null, listBean.getDescription(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -72, 134217727, null);
        }
        Subject subject2 = this.subject;
        if ((subject2 != null ? subject2.getShortTVFavInfo() : null) == null && (subject = this.subject) != null) {
            ShortTVFavInfo shortTVFavInfo = listBean.getShortTVFavInfo();
            String favoriteNum = shortTVFavInfo != null ? shortTVFavInfo.getFavoriteNum() : null;
            ShortTVFavInfo shortTVFavInfo2 = listBean.getShortTVFavInfo();
            boolean hasFavorite = shortTVFavInfo2 != null ? shortTVFavInfo2.getHasFavorite() : false;
            ShortTVFavInfo shortTVFavInfo3 = listBean.getShortTVFavInfo();
            subject.setShortTVFavInfo(new ShortTVFavInfo(favoriteNum, hasFavorite, shortTVFavInfo3 != null ? shortTVFavInfo3.getFavoriteTime() : null));
        }
        this.isContentDataRequested = true;
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var != null && (appCompatTextView3 = f0Var.D) != null) {
            appCompatTextView3.setText(listBean.getSubjectTitle());
        }
        py.f0 f0Var2 = (py.f0) getMViewBinding();
        if (f0Var2 != null && (appCompatTextView2 = f0Var2.C) != null) {
            appCompatTextView2.setText(listBean.getSubjectTitle());
        }
        py.f0 f0Var3 = (py.f0) getMViewBinding();
        if (f0Var3 != null && (shapeableImageView = f0Var3.f72821m) != null) {
            f.a aVar = ej.f.f62005a;
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            f.b m11 = aVar.m(requireContext);
            Cover cover = listBean.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = "";
            }
            f.b c11 = m11.g(str).i(R$color.module_04).m(shapeableImageView.getWidth()).c(shapeableImageView.getHeight());
            Cover cover2 = listBean.getCover();
            if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                str2 = "";
            }
            c11.l(str2).d(shapeableImageView);
        }
        n1(listBean);
        String genre = listBean.getGenre();
        if (genre != null && genre.length() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            String releaseDate = listBean.getReleaseDate();
            if (releaseDate != null && releaseDate.length() > 0) {
                Date l11 = com.blankj.utilcode.util.c0.l(listBean.getReleaseDate(), "yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(l11);
                stringBuffer.append(String.valueOf(calendar.get(1)));
            }
            String genre2 = listBean.getGenre();
            if (genre2 != null && genre2.length() > 0) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" • ");
                }
                String genre3 = listBean.getGenre();
                stringBuffer.append(genre3 != null ? StringsKt.Q(genre3, "，", " • ", false, 4, null) : null);
            }
            String countryName = listBean.getCountryName();
            if (countryName != null && countryName.length() > 0) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" • ");
                }
                stringBuffer.append(listBean.getCountryName());
            }
            py.f0 f0Var4 = (py.f0) getMViewBinding();
            if (f0Var4 != null && (appCompatTextView = f0Var4.f72833y) != null) {
                appCompatTextView.setText(stringBuffer);
            }
        }
        py.f0 f0Var5 = (py.f0) getMViewBinding();
        if (f0Var5 != null && (bLImageView = f0Var5.f72822n) != null) {
            ShortTVFavInfo shortTVFavInfo4 = listBean.getShortTVFavInfo();
            bLImageView.setSelected(shortTVFavInfo4 != null ? shortTVFavInfo4.getHasFavorite() : false);
        }
        py.f0 f0Var6 = (py.f0) getMViewBinding();
        if (f0Var6 != null && (downloadInfoExtendView = f0Var6.f72817i) != null) {
            String description = listBean.getDescription();
            if (description == null) {
                description = "";
            }
            downloadInfoExtendView.showData(description);
        }
        Subject subject3 = this.subject;
        int totalEpisode4 = subject3 != null ? subject3.getTotalEpisode() : 0;
        Integer totalEpisode5 = listBean.getTotalEpisode();
        int max = Math.max(totalEpisode4, totalEpisode5 != null ? totalEpisode5.intValue() : 0);
        if (max > 0) {
            m1(max);
            int i12 = 0;
            while (i12 < max) {
                DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.shortTVEpAdapter;
                if (downloadShortTvEpListAdapter != null && (data = downloadShortTvEpListAdapter.getData()) != null) {
                    Subject subject4 = this.subject;
                    data.add(new my.c((subject4 == null || (subjectId = subject4.getSubjectId()) == null) ? "" : subjectId, i12, i12 < this.curUnlockAllCount, false, this.inDownloadStatusMap.containsKey(Integer.valueOf(i12)), 8, null));
                }
                i12++;
            }
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter2 = this.shortTVEpAdapter;
            if (downloadShortTvEpListAdapter2 != null) {
                downloadShortTvEpListAdapter2.notifyItemRangeChanged(0, max);
            }
        }
    }

    private final void o1(int end) {
        int i11 = this.curUnlockAllCount;
        if (end >= i11) {
            this.isRequestingData = false;
            Function0 function0 = this.selectAllCallback;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (i11 - end > 20) {
            this.startPosition = end + 1;
            this.endPosition = end + 20;
        } else {
            this.startPosition = end + 1;
            this.endPosition = (r3 + r0) - 1;
        }
        loadData();
    }

    private final void o2(List list, int start, int end) {
        HashMap g11;
        androidx.view.b0 G;
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter;
        List data;
        List data2;
        androidx.view.b0 G2;
        Long l11;
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "updateList ,  size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            this.isRequestingData = false;
            Function0 function0 = this.selectAllCallback;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        long longValue = (viewModel == null || (G2 = viewModel.G()) == null || (l11 = (Long) G2.f()) == null) ? 0L : l11.longValue();
        String tag2 = getTAG();
        Intrinsics.g(tag2, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag2, "before curTotalSize:" + longValue, false, 4, null);
        int size = list2.size();
        long j11 = longValue;
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            int i12 = (start + i11) - 1;
            DownloadBean downloadBean = (DownloadBean) list.get(i11);
            DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = downloadBean.getUrl();
            }
            DownloadBean q11 = a11.q(resourceId);
            if (this.isSelectAll) {
                if (q11 != null) {
                    q11.setCheck(true);
                }
                downloadBean.setCheck(true);
                Long size2 = downloadBean.getSize();
                j11 += size2 != null ? size2.longValue() : 0L;
            }
            if (q11 != null) {
                q11.setUploadBy(downloadBean.getUploadBy());
                arrayList.add(q11);
                q11.setPosition(i12);
                this.unlockDownloadLst.put(Integer.valueOf(i12), q11);
                a.C0856a c0856a2 = lg.a.f68962a;
                String tag3 = getTAG();
                Intrinsics.g(tag3, "<get-TAG>(...)");
                a.C0856a.f(c0856a2, tag3, "in download ep:" + q11.getEp() + ", status:" + q11.getStatus(), false, 4, null);
            } else {
                downloadBean.setPosition(i12);
                arrayList.add(downloadBean);
                this.unlockDownloadLst.put(Integer.valueOf(i12), downloadBean);
            }
            if (q11 != null && q11.isUnable()) {
                this.unableSize++;
                this.inDownloadStatusMap.put(Integer.valueOf(i12), q11);
                a.C0856a c0856a3 = lg.a.f68962a;
                String tag4 = getTAG();
                Intrinsics.g(tag4, "<get-TAG>(...)");
                a.C0856a.v(c0856a3, tag4, "unable index:" + i12 + "， plus size = " + this.unableSize, false, 4, null);
                DownloadShortTvEpListAdapter downloadShortTvEpListAdapter2 = this.shortTVEpAdapter;
                if (i12 < ((downloadShortTvEpListAdapter2 == null || (data2 = downloadShortTvEpListAdapter2.getData()) == null) ? 0 : data2.size())) {
                    DownloadShortTvEpListAdapter downloadShortTvEpListAdapter3 = this.shortTVEpAdapter;
                    my.c cVar = (downloadShortTvEpListAdapter3 == null || (data = downloadShortTvEpListAdapter3.getData()) == null) ? null : (my.c) CollectionsKt.l0(data, i12);
                    if (cVar != null) {
                        cVar.e(true);
                    }
                    z10 = true;
                }
            }
        }
        if (z10 && (downloadShortTvEpListAdapter = this.shortTVEpAdapter) != null) {
            downloadShortTvEpListAdapter.notifyItemRangeChanged(start - 1, list.size());
        }
        a.C0856a c0856a4 = lg.a.f68962a;
        String tag5 = getTAG();
        Intrinsics.g(tag5, "<get-TAG>(...)");
        a.C0856a.v(c0856a4, tag5, "update data curTotalSize:" + j11, false, 4, null);
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (G = viewModel2.G()) != null) {
            G.q(Long.valueOf(j11));
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g11 = logViewConfig2.g()) != null) {
            g11.put("size", String.valueOf(arrayList.size()));
        }
        o1(end);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p1() {
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        androidx.view.b0 F;
        Map map;
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        int size = (viewModel == null || (F = viewModel.F()) == null || (map = (Map) F.f()) == null) ? 0 : map.size();
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "checkSelectAll, selectedCount: " + size + ", curUnlockCount:" + this.curUnlockAllCount + ", downloadize:" + this.inDownloadStatusMap.size(), false, 4, null);
        this.isSelectAll = size == this.curUnlockAllCount - this.inDownloadStatusMap.size();
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var != null && (appCompatImageView = f0Var.f72819k) != null) {
            appCompatImageView.setSelected(this.isSelectAll);
        }
        py.f0 f0Var2 = (py.f0) getMViewBinding();
        if (f0Var2 == null || (appCompatTextView = f0Var2.f72831w) == null) {
            return;
        }
        appCompatTextView.setVisibility(size > 0 ? 0 : 8);
        appCompatTextView.setText(Utils.a().getString(com.transsnet.downloader.R$string.download_ep_selected_count, String.valueOf(size)));
    }

    private final void q1(String pageName, String pageFrom, String subjectId, String postId, String ops, String resourceId, String taskId) {
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
        iVar.p(pageName, hashMap);
        Bundle bundle = new Bundle();
        bundle.putString("resource_id", resourceId);
        bundle.putString("subject_id", subjectId);
        com.transsion.baselib.report.e.f43398a.l("download_click", bundle, getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View r1() {
        LayoutInflater from = LayoutInflater.from(requireContext());
        int i11 = R$layout.layout_download_short_tv_loading;
        py.f0 f0Var = (py.f0) getMViewBinding();
        return from.inflate(i11, (ViewGroup) (f0Var != null ? f0Var.f72816h : null), false);
    }

    private final View s1(Context context, String desText, boolean showRightBtn) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_DES_BTN);
        defaultView.setDescText(desText);
        defaultView.setDescTextColor(-1);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_NO_IMAGE);
        defaultView.setBtnVisibility(showRightBtn ? 0 : 8);
        String string = context.getString(R$string.go_to_setting);
        Intrinsics.g(string, "getString(...)");
        defaultView.setBtnText(string);
        defaultView.setTipOperationVisibility(8);
        defaultView.setBtnBg(androidx.core.content.b.getDrawable(Utils.a(), R$drawable.download_empty_btn_bg));
        defaultView.setBtnTextColor(-1);
        defaultView.setBackgroundColor(0);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.h4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorShortTVFragment.t1(DefaultView.this, view);
            }
        });
        defaultView.setLeftBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.g(string2, "getString(...)");
        defaultView.setLeftBtnText(string2);
        defaultView.setLeftBtnBg(androidx.core.content.b.getDrawable(Utils.a(), R$drawable.download_empty_btn_bg));
        defaultView.setLeftBtnTextColor(-1);
        defaultView.setLeftBtnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.i4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorShortTVFragment.u1(DownloadReDetectorShortTVFragment.this, defaultView, view);
            }
        });
        defaultView.setTitleViewVisibility(8);
        int a11 = com.blankj.utilcode.util.a0.a(16.0f);
        defaultView.setPadding(a11, com.blankj.utilcode.util.a0.a(110.0f), a11, 0);
        defaultView.setVisibility(0);
        return defaultView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showLoading() {
        FrameLayout frameLayout;
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var == null || (frameLayout = f0Var.f72816h) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        frameLayout.addView(r1());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showNotNetError() {
        FrameLayout frameLayout;
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var == null || (frameLayout = f0Var.f72816h) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        frameLayout.addView(w1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(DefaultView defaultView, View view) {
        try {
            Result.Companion companion = Result.INSTANCE;
            NetworkUtils.v();
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, DefaultView defaultView, View view) {
        downloadReDetectorShortTVFragment.showLoading();
        downloadReDetectorShortTVFragment.loadData();
        defaultView.setVisibility(8);
    }

    private final View v1() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        String string = Utils.a().getString(R$string.error_load_failed);
        Intrinsics.g(string, "getString(...)");
        return s1(requireContext, string, false);
    }

    private final View w1() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        String string = Utils.a().getString(R$string.no_network_title);
        Intrinsics.g(string, "getString(...)");
        return s1(requireContext, string, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShortTVPlayDao x1() {
        return (ShortTVPlayDao) this.shortTVPlayDao.getValue();
    }

    private final ry.f y1() {
        return (ry.f) this.shortTVReporter.getValue();
    }

    private final StartDownloadHelper z1() {
        return (StartDownloadHelper) this.startDownloadHelper.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public py.f0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.f0 c11 = py.f0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        LinearLayoutCompat linearLayoutCompat;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        BLImageView bLImageView;
        BLImageView bLImageView2;
        BLView bLView;
        ImageView imageView;
        py.f0 f0Var = (py.f0) getMViewBinding();
        if (f0Var != null && (imageView = f0Var.f72820l) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.v3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.B1(DownloadReDetectorShortTVFragment.this, view);
                }
            });
        }
        py.f0 f0Var2 = (py.f0) getMViewBinding();
        if (f0Var2 != null && (bLView = f0Var2.G) != null) {
            bLView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.g4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.C1(DownloadReDetectorShortTVFragment.this, view);
                }
            });
        }
        py.f0 f0Var3 = (py.f0) getMViewBinding();
        if (f0Var3 != null && (bLImageView2 = f0Var3.f72822n) != null) {
            bLImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.j4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.D1(DownloadReDetectorShortTVFragment.this, view);
                }
            });
        }
        py.f0 f0Var4 = (py.f0) getMViewBinding();
        if (f0Var4 != null && (bLImageView = f0Var4.f72823o) != null) {
            bLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.k4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.E1(DownloadReDetectorShortTVFragment.this, view);
                }
            });
        }
        py.f0 f0Var5 = (py.f0) getMViewBinding();
        if (f0Var5 != null && (appCompatTextView = f0Var5.A) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.l4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.F1(DownloadReDetectorShortTVFragment.this, view);
                }
            });
        }
        py.f0 f0Var6 = (py.f0) getMViewBinding();
        if (f0Var6 != null && (appCompatImageView = f0Var6.f72819k) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.m4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.G1(DownloadReDetectorShortTVFragment.this, view);
                }
            });
        }
        py.f0 f0Var7 = (py.f0) getMViewBinding();
        if (f0Var7 == null || (linearLayoutCompat = f0Var7.f72812d) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.n4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorShortTVFragment.H1(DownloadReDetectorShortTVFragment.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        initView();
        b2();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.view.b0 E;
        androidx.view.b0 I;
        androidx.view.b0 G;
        androidx.view.b0 F;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            DownloadResourcesDetectorViewModel viewModel = getViewModel();
            if (viewModel != null && (F = viewModel.F()) != null) {
                F.j(parentFragment, new e(new Function1() { // from class: com.transsnet.downloader.fragment.o4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit K1;
                        K1 = DownloadReDetectorShortTVFragment.K1(DownloadReDetectorShortTVFragment.this, (Map) obj);
                        return K1;
                    }
                }));
            }
            DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
            if (viewModel2 != null && (G = viewModel2.G()) != null) {
                G.j(parentFragment, new e(new Function1() { // from class: com.transsnet.downloader.fragment.p4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit L1;
                        L1 = DownloadReDetectorShortTVFragment.L1(DownloadReDetectorShortTVFragment.this, (Long) obj);
                        return L1;
                    }
                }));
            }
            DownloadResourcesDetectorViewModel viewModel3 = getViewModel();
            if (viewModel3 != null && (I = viewModel3.I()) != null) {
                I.j(parentFragment, new e(new Function1() { // from class: com.transsnet.downloader.fragment.q4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit M1;
                        M1 = DownloadReDetectorShortTVFragment.M1(DownloadReDetectorShortTVFragment.this, (String) obj);
                        return M1;
                    }
                }));
            }
            DownloadResourcesDetectorViewModel viewModel4 = getViewModel();
            if (viewModel4 != null && (E = viewModel4.E()) != null) {
                E.j(parentFragment, new e(new Function1() { // from class: com.transsnet.downloader.fragment.w3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit N1;
                        N1 = DownloadReDetectorShortTVFragment.N1((Integer) obj);
                        return N1;
                    }
                }));
            }
        }
        Context context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsnet.downloader.fragment.x3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit O1;
                O1 = DownloadReDetectorShortTVFragment.O1(DownloadReDetectorShortTVFragment.this, (uy.c) obj);
                return O1;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = uy.c.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
        Fragment parentFragment2 = getParentFragment();
        if (parentFragment2 != null) {
            int i11 = com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0);
            DownloadListManager.a aVar = DownloadListManager.f60117m;
            aVar.a().r(i11);
            androidx.view.b0 b0Var = (androidx.view.b0) aVar.a().A().get(Integer.valueOf(i11));
            if (b0Var != null) {
                b0Var.j(parentFragment2, new e(new Function1() { // from class: com.transsnet.downloader.fragment.y3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit J1;
                        J1 = DownloadReDetectorShortTVFragment.J1(DownloadReDetectorShortTVFragment.this, (DownloadListBean) obj);
                        return J1;
                    }
                }));
            }
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "initViewModel ,loadData", false, 4, null);
        showLoading();
        loadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return true;
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        HashMap g11;
        HashMap g12;
        HashMap g13;
        HashMap g14;
        HashMap g15;
        String subjectId;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str6 = "";
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
        if (arguments4 == null || (str3 = arguments4.getString("extra_subject_id")) == null) {
            str3 = "";
        }
        this.subjectId = str3;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str4 = arguments5.getString("extra_ops")) == null) {
            str4 = "";
        }
        this.ops = str4;
        Bundle arguments6 = getArguments();
        if (arguments6 == null || (str5 = arguments6.getString("extra_module_name")) == null) {
            str5 = "";
        }
        this.moduleName = str5;
        Bundle arguments7 = getArguments();
        this.scroll2Download = arguments7 != null ? arguments7.getBoolean("extra_download_scroll_to_download") : false;
        Subject subject = this.subject;
        if (subject != null) {
            this.subjectId = subject != null ? subject.getSubjectId() : null;
        }
        com.transsnet.downloader.util.d0 d0Var = com.transsnet.downloader.util.d0.f60049a;
        Subject subject2 = this.subject;
        if (subject2 != null && (subjectId = subject2.getSubjectId()) != null) {
            str6 = subjectId;
        }
        this.curUnlockAllCount = d0Var.c(str6);
        this.perUnlockCount = d0Var.e();
        int i11 = this.curUnlockAllCount;
        if (i11 > 20) {
            i11 = 20;
        }
        this.endPosition = i11;
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
            Subject subject3 = this.subject;
            g13.put("subject_id", subject3 != null ? subject3.getSubjectId() : null);
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g12 = logViewConfig4.g()) != null) {
            g12.put("ops", this.ops);
        }
        hj.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 != null && (g11 = logViewConfig5.g()) != null) {
            g11.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "2");
        }
        ry.f.d(y1(), this.subjectId, "dialog_minitv_download", null, 4, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        aVar.a().Y(null);
        try {
            aVar.a().A().clear();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initHistory();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        List data;
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.shortTVEpAdapter;
        if (downloadShortTvEpListAdapter == null || (data = downloadShortTvEpListAdapter.getData()) == null || data.size() != 0) {
            return;
        }
        showLoading();
        loadData();
    }
}
