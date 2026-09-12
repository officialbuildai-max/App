package com.transsion.ugcvideodetail.fragment;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.pager.PagerLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideoContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel;
import com.transsion.ugcvideodetail.widget.UGCImmVideoItemView;
import com.transsion.ugcvideodetail.widget.UGCImmVideoLoadMoreView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lg.a;
import ox.b;

@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\b\u0006*\u0004¼\u0001Â\u0001\u0018\u0000 Æ\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001SB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0013\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u0019\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0005J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0010H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\u0005J\u000f\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b/\u0010\u0005J\u000f\u00100\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u0010\u0005J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\u0005J\u000f\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u0010\u0005J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010\u0005J\u000f\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u0010\u0005J\r\u00105\u001a\u00020\u0006¢\u0006\u0004\b5\u0010\u0005J\u001f\u0010:\u001a\u00020\u00062\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u0019\u0010>\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\b>\u0010?J\u0019\u0010A\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\bA\u0010BJ!\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020C2\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\bE\u0010FJ\u0019\u0010G\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\bG\u0010?J\u000f\u0010H\u001a\u00020\u0006H\u0016¢\u0006\u0004\bH\u0010\u0005J\r\u0010I\u001a\u00020\u0006¢\u0006\u0004\bI\u0010\u0005J\r\u0010J\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010\u0005J\u000f\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0006H\u0016¢\u0006\u0004\bN\u0010\u0005J\u000f\u0010O\u001a\u00020\u0006H\u0016¢\u0006\u0004\bO\u0010\u0005J\u0017\u0010Q\u001a\u00020\u00062\b\u0010P\u001a\u0004\u0018\u00010%¢\u0006\u0004\bQ\u0010BR\u001b\u0010W\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010T\u001a\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R$\u0010c\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010^\u001a\u0004\ba\u0010'\"\u0004\bb\u0010BR\u0018\u0010e\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010^R\u0018\u0010h\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010^R\u0018\u0010l\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010^R\u0016\u0010o\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010^R\u0018\u0010s\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010^R\"\u0010w\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010^\u001a\u0004\bu\u0010'\"\u0004\bv\u0010BR$\u0010{\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010^\u001a\u0004\by\u0010'\"\u0004\bz\u0010BR$\u0010\u007f\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010^\u001a\u0004\b}\u0010'\"\u0004\b~\u0010BR(\u0010\u0083\u0001\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010^\u001a\u0005\b\u0081\u0001\u0010'\"\u0005\b\u0082\u0001\u0010BR\u0018\u0010\u0085\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010nR\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u009d\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010¡\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001a\u0010£\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¢\u0001\u0010^R'\u0010¨\u0001\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\b¤\u0001\u0010n\u001a\u0005\b¥\u0001\u0010)\"\u0006\b¦\u0001\u0010§\u0001R\u001a\u0010¬\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R!\u0010±\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010®\u00010\u00ad\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R \u0010³\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00ad\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b²\u0001\u0010°\u0001R!\u0010¶\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010´\u00010\u00ad\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010°\u0001R\u001f\u0010¹\u0001\u001a\n\u0012\u0005\u0012\u00030·\u00010\u00ad\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010°\u0001R\u001a\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u0018\u0010¿\u0001\u001a\u00030¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001a\u0010Á\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010«\u0001R\u0018\u0010Å\u0001\u001a\u00030Â\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001¨\u0006Ç\u0001"}, d2 = {"Lcom/transsion/ugcvideodetail/fragment/UGCImmVideoDetailFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lqv/f;", "Lcom/transsion/player/orplayer/f;", "<init>", "()V", "", "O0", "initAdapter", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "video", "g1", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;)V", "", "Lcom/transsion/ugcvideodetail/api/bean/UGCImmVideo;", "newList", "", "isLoadDown", "hasMore", "R0", "(Ljava/util/List;ZZ)V", "B0", "T0", "U0", "e1", "x0", "y0", "Lcom/transsion/baselib/db/download/DownloadBean;", "bean", "f1", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "Z0", "V0", "Landroid/view/LayoutInflater;", "inflater", "J0", "(Landroid/view/LayoutInflater;)Lqv/f;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "isAudioShowNoNetworkLayout", "()Z", "receiveArguments", "initViewData", "Landroidx/appcompat/widget/AppCompatImageView;", "L0", "()Landroidx/appcompat/widget/AppCompatImageView;", "initViewModel", "initListener", "retryLoadData", "onStop", "onPause", "onResume", "Y0", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "Lao/e;", "mediaSource", "onCompletion", "(Lao/e;)V", "uuid", "onMediaItemTransition", "(Ljava/lang/String;)V", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lao/e;)V", "onPrepare", "onDestroyView", "hideLoading", "startLoading", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "logResume", "logPause", "ugcVideoId", "c1", "Lcom/transsion/ugcvideodetail/viewmodel/UGCImmVideoDetailViewModel;", "a", "Lkotlin/Lazy;", "D0", "()Lcom/transsion/ugcvideodetail/viewmodel/UGCImmVideoDetailViewModel;", "detailViewModel", "Lcom/transsnet/downloader/manager/g;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "E0", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "c", "Ljava/lang/String;", "ops", "d", "C0", "setCollectionId", "collectionId", "e", "firstUgcVideoId", "f", "Lcom/transsion/ugcvideodetail/api/bean/UGCImmVideo;", "firstUgcVideo", be.g.f16474b, "ugcVideoType", "h", "subjectId", "i", "Z", "withoutHistory", com.mbridge.msdk.foundation.same.report.j.f35620b, "tabId", CampaignEx.JSON_KEY_AD_K, "fromOptId", "l", "I0", "setTrackId", "trackId", "m", "H0", "setPreviousTrackId", "previousTrackId", "n", "G0", "setPreviousPageVideoId", "previousPageVideoId", "o", "F0", "setLastPageFrom", "lastPageFrom", TtmlNode.TAG_P, "isNewPlayer", "Llo/f;", CampaignEx.JSON_KEY_AD_Q, "Llo/f;", "orPlayer", "Lcom/transsion/player/ui/ORPlayerView;", CampaignEx.JSON_KEY_AD_R, "Lcom/transsion/player/ui/ORPlayerView;", "orPlayerView", "Lcom/transsion/ugcvideodetail/adapter/a;", "s", "Lcom/transsion/ugcvideodetail/adapter/a;", "detailAdapter", "Lcom/tn/lib/pager/PagerLayoutManager;", "t", "Lcom/tn/lib/pager/PagerLayoutManager;", "pagerLayoutManager", "Lcom/transsion/ugcvideodetail/hepler/b;", TmcStartParams.KEY_URL_SHORT, "Lcom/transsion/ugcvideodetail/hepler/b;", "pagerChangeControl", "Landroid/os/Handler;", "v", "Landroid/os/Handler;", "downloadPopHandler", "Ljava/lang/Runnable;", "w", "Ljava/lang/Runnable;", "downloadPopHideRunnable", "x", "downloadingUgcVideoId", "y", "isClickPause$UGCVideoDetail_psRelease", "b1", "(Z)V", "isClickPause", "", "z", "J", "pageLoadStartTime", "Landroidx/lifecycle/c0;", "Lcom/transsion/baselib/db/video/UGCVideoDetailPlayBean;", "A", "Landroidx/lifecycle/c0;", "historyObserver", "B", "detailObserver", "Lcom/transsion/ugcvideodetail/api/bean/UGCImmVideoContent;", "C", "listObserver", "", "D", "playingEpObserver", "E", "Lcom/transsion/player/orplayer/PlayError;", "com/transsion/ugcvideodetail/fragment/UGCImmVideoDetailFragment$c", "F", "Lcom/transsion/ugcvideodetail/fragment/UGCImmVideoDetailFragment$c;", "loadingHandler", "G", "resumeTimeStamp", "com/transsion/ugcvideodetail/fragment/UGCImmVideoDetailFragment$b", "H", "Lcom/transsion/ugcvideodetail/fragment/UGCImmVideoDetailFragment$b;", "downloadListener", "I", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class UGCImmVideoDetailFragment extends PageStatusFragment<qv.f> implements com.transsion.player.orplayer.f {

    /* renamed from: I, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private final androidx.view.c0 historyObserver;

    /* renamed from: B, reason: from kotlin metadata */
    private final androidx.view.c0 detailObserver;

    /* renamed from: C, reason: from kotlin metadata */
    private final androidx.view.c0 listObserver;

    /* renamed from: D, reason: from kotlin metadata */
    private final androidx.view.c0 playingEpObserver;

    /* renamed from: E, reason: from kotlin metadata */
    private PlayError errorInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private final c loadingHandler;

    /* renamed from: G, reason: from kotlin metadata */
    private long resumeTimeStamp;

    /* renamed from: H, reason: from kotlin metadata */
    private final b downloadListener;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy detailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UGCImmVideoDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.ugcvideodetail.fragment.UGCImmVideoDetailFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.ugcvideodetail.fragment.UGCImmVideoDetailFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadManager = LazyKt.b(new Function0() { // from class: com.transsion.ugcvideodetail.fragment.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g A0;
            A0 = UGCImmVideoDetailFragment.A0();
            return A0;
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String collectionId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String firstUgcVideoId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private UGCImmVideo firstUgcVideo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String ugcVideoType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String subjectId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean withoutHistory;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String tabId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String fromOptId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String trackId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String previousTrackId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String previousPageVideoId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isNewPlayer;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private lo.f orPlayer;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private ORPlayerView orPlayerView;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private com.transsion.ugcvideodetail.adapter.a detailAdapter;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private PagerLayoutManager pagerLayoutManager;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private com.transsion.ugcvideodetail.hepler.b pagerChangeControl;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final Handler downloadPopHandler;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private Runnable downloadPopHideRunnable;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private String downloadingUgcVideoId;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean isClickPause;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private long pageLoadStartTime;

    /* renamed from: com.transsion.ugcvideodetail.fragment.UGCImmVideoDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCImmVideoDetailFragment a() {
            return new UGCImmVideoDetailFragment();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends ny.d {
        b() {
        }

        @Override // ny.d
        public void h(DownloadBean bean, int i11) {
            com.transsion.ugcvideodetail.adapter.a aVar;
            List<Object> data;
            Intrinsics.h(bean, "bean");
            com.transsion.ugcvideodetail.adapter.a aVar2 = UGCImmVideoDetailFragment.this.detailAdapter;
            int i12 = -1;
            if (aVar2 != null && (data = aVar2.getData()) != null) {
                Iterator<Object> it = data.iterator();
                int i13 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    UGCVideo ugcVideo = ((UGCImmVideo) it.next()).getUgcVideo();
                    if (Intrinsics.c(ugcVideo != null ? ugcVideo.getUgcVideoId() : null, bean.getUgcVideoId())) {
                        i12 = i13;
                        break;
                    }
                    i13++;
                }
            }
            if (i12 >= 0 && (aVar = UGCImmVideoDetailFragment.this.detailAdapter) != null) {
                aVar.notifyItemChanged(i12, Integer.valueOf(i11));
            }
            UGCImmVideoDetailFragment.this.f1(bean);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final int f56198a;

        /* renamed from: b, reason: collision with root package name */
        private final long f56199b;

        c(Looper looper) {
            super(looper);
            this.f56198a = 1;
            this.f56199b = 300L;
        }

        public final long a() {
            return this.f56199b;
        }

        public final int b() {
            return this.f56198a;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            qv.f mViewBinding;
            ProgressBar progressBar;
            Intrinsics.h(msg, "msg");
            super.handleMessage(msg);
            if (msg.what != this.f56198a || (mViewBinding = UGCImmVideoDetailFragment.this.getMViewBinding()) == null || (progressBar = mViewBinding.f73852e) == null) {
                return;
            }
            jg.c.k(progressBar);
        }
    }

    public UGCImmVideoDetailFragment() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        this.trackId = uuid;
        this.isNewPlayer = true;
        this.downloadPopHandler = new Handler(Looper.getMainLooper());
        this.historyObserver = new androidx.view.c0() { // from class: com.transsion.ugcvideodetail.fragment.d
            @Override // androidx.view.c0
            public final void onChanged(Object obj) {
                UGCImmVideoDetailFragment.K0(UGCImmVideoDetailFragment.this, (UGCVideoDetailPlayBean) obj);
            }
        };
        this.detailObserver = new androidx.view.c0() { // from class: com.transsion.ugcvideodetail.fragment.e
            @Override // androidx.view.c0
            public final void onChanged(Object obj) {
                UGCImmVideoDetailFragment.z0(UGCImmVideoDetailFragment.this, (UGCImmVideo) obj);
            }
        };
        this.listObserver = new androidx.view.c0() { // from class: com.transsion.ugcvideodetail.fragment.f
            @Override // androidx.view.c0
            public final void onChanged(Object obj) {
                UGCImmVideoDetailFragment.S0(UGCImmVideoDetailFragment.this, (UGCImmVideoContent) obj);
            }
        };
        this.playingEpObserver = new androidx.view.c0() { // from class: com.transsion.ugcvideodetail.fragment.g
            @Override // androidx.view.c0
            public final void onChanged(Object obj) {
                UGCImmVideoDetailFragment.W0(UGCImmVideoDetailFragment.this, ((Integer) obj).intValue());
            }
        };
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        this.loadingHandler = new c(myLooper);
        this.downloadListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g A0() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    private final void B0() {
        String str;
        startLoading();
        if (!nh.m.f70597a.e()) {
            String str2 = this.firstUgcVideoId;
            if (str2 != null) {
                if (StringsKt.q0(str2)) {
                    str2 = null;
                }
                if (str2 != null) {
                    D0().T0(str2, this.collectionId);
                    return;
                }
            }
            String str3 = this.subjectId;
            if (str3 != null) {
                if (StringsKt.q0(str3)) {
                    str3 = null;
                }
                if (str3 != null) {
                    hideLoading();
                    PageStatusFragment.showErrorView$default(this, false, 1, null);
                    return;
                }
                return;
            }
            return;
        }
        String str4 = this.collectionId;
        if (str4 == null || str4.length() == 0 || this.withoutHistory) {
            a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetail", "firstLoadData---1 withoutHistory:" + this.withoutHistory, false, 4, null);
            T0();
            if (this.withoutHistory || (str = this.firstUgcVideoId) == null) {
                return;
            }
            D0().Z0(str, false);
            return;
        }
        String str5 = this.firstUgcVideoId;
        if (str5 != null) {
            if (StringsKt.q0(str5)) {
                str5 = null;
            }
            if (str5 != null) {
                D0().Z0(str5, true);
                return;
            }
        }
        String str6 = this.subjectId;
        if (str6 != null) {
            String str7 = StringsKt.q0(str6) ? null : str6;
            if (str7 != null) {
                D0().K0(str7);
            }
        }
    }

    private final UGCImmVideoDetailViewModel D0() {
        return (UGCImmVideoDetailViewModel) this.detailViewModel.getValue();
    }

    private final com.transsnet.downloader.manager.g E0() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(UGCImmVideoDetailFragment uGCImmVideoDetailFragment, UGCVideoDetailPlayBean uGCVideoDetailPlayBean) {
        a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetail", "historyObserver: " + uGCVideoDetailPlayBean + ", withoutHistory=" + uGCImmVideoDetailFragment.withoutHistory + "， shouldRequestDetail:" + uGCImmVideoDetailFragment.D0().U0(), false, 4, null);
        if (uGCVideoDetailPlayBean != null && !uGCImmVideoDetailFragment.withoutHistory) {
            uGCImmVideoDetailFragment.firstUgcVideoId = uGCVideoDetailPlayBean.getUgcVideoId();
            uGCImmVideoDetailFragment.D0().D().q(uGCImmVideoDetailFragment.firstUgcVideoId);
        }
        if (uGCImmVideoDetailFragment.D0().U0()) {
            uGCImmVideoDetailFragment.T0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(UGCImmVideoDetailFragment uGCImmVideoDetailFragment) {
        uGCImmVideoDetailFragment.U0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(UGCImmVideoDetailFragment uGCImmVideoDetailFragment) {
        if (nh.m.f70597a.e()) {
            uGCImmVideoDetailFragment.e1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O0() {
        lo.e eVar;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        this.orPlayerView = new ORPlayerView(requireActivity, RenderType.TEXTURE_VIEW);
        com.transsion.player.orplayer.g b11 = com.transsion.videofloat.manager.a0.f58056a.b("ImmVideo" + this.firstUgcVideoId);
        int i11 = 1;
        boolean z10 = b11 == null;
        this.isNewPlayer = z10;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "UGCImmVideoDetail", "initOrPlayer isNewPlayer:" + z10, false, 4, null);
        com.transsion.player.shorttv.preload.c cVar = null;
        Object[] objArr = 0;
        if (b11 != null) {
            eVar = b11 instanceof lo.e ? (lo.e) b11 : null;
            if (eVar != null) {
                ORPlayerView oRPlayerView = this.orPlayerView;
                eVar.setTextureView(oRPlayerView != null ? oRPlayerView.getTextureView() : null);
            } else {
                eVar = null;
            }
        } else {
            eVar = new lo.e(cVar, i11, objArr == true ? 1 : 0);
            ORPlayerView oRPlayerView2 = this.orPlayerView;
            eVar.setTextureView(oRPlayerView2 != null ? oRPlayerView2.getTextureView() : null);
        }
        this.orPlayer = eVar;
        b.C0906b.a(ox.b.f72314a.c(), false, 1, null);
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        boolean z11 = bVar.b().getBoolean("KEY_UGC_IMM_VIDEO_AUTO_PLAY", false);
        float f11 = bVar.b().getFloat("KEY_UGC_IMM_VIDEO_SPEED", 1.0f);
        lo.f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.addPlayerListener(this);
        }
        lo.f fVar2 = this.orPlayer;
        if (fVar2 != null) {
            fVar2.setLooping(!z11);
        }
        lo.f fVar3 = this.orPlayer;
        if (fVar3 != null) {
            fVar3.setSpeed(f11);
        }
        a.C0856a.f(c0856a, "UGCImmVideoDetail", "initOrPlayer speed:" + f11 + ", autoPlay:" + z11, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(UGCImmVideoDetailFragment uGCImmVideoDetailFragment, View view) {
        hj.i.f64628a.p("/ugc_video/immersive_detail", MapsKt.l(TuplesKt.a("dialog_name", "download_view"), TuplesKt.a("module_name", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)));
        uGCImmVideoDetailFragment.V0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(UGCImmVideoDetailFragment uGCImmVideoDetailFragment, View view) {
        FragmentActivity activity = uGCImmVideoDetailFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Number, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void R0(java.util.List r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.fragment.UGCImmVideoDetailFragment.R0(java.util.List, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(UGCImmVideoDetailFragment uGCImmVideoDetailFragment, UGCImmVideoContent uGCImmVideoContent) {
        r6.f h02;
        Map a11;
        List<Object> data;
        UGCImmVideo uGCImmVideo;
        UGCVideo ugcVideo;
        UGCVideo ugcVideo2;
        List<UGCImmVideo> list = uGCImmVideoContent != null ? uGCImmVideoContent.getList() : null;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "UGCImmVideoDetail", "listObserver: " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        List<UGCImmVideo> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        boolean Y0 = uGCImmVideoDetailFragment.D0().Y0();
        boolean isLoadDown = uGCImmVideoContent.isLoadDown();
        UGCImmVideo uGCImmVideo2 = (UGCImmVideo) CollectionsKt.k0(list);
        int videoUGCPosition = (uGCImmVideo2 == null || (ugcVideo2 = uGCImmVideo2.getUgcVideo()) == null) ? -1 : ugcVideo2.videoUGCPosition();
        com.transsion.ugcvideodetail.adapter.a aVar = uGCImmVideoDetailFragment.detailAdapter;
        a.C0856a.f(c0856a, "UGCImmVideoDetail", "listObserver, isCollection: " + Y0 + ", isLoadDown:" + isLoadDown + ", firstPosition:" + videoUGCPosition + ", adapterFirstPosition:" + ((aVar == null || (data = aVar.getData()) == null || (uGCImmVideo = (UGCImmVideo) CollectionsKt.k0(data)) == null || (ugcVideo = uGCImmVideo.getUgcVideo()) == null) ? -1 : ugcVideo.videoUGCPosition()) + " ", false, 4, null);
        if (Y0) {
            boolean isLoadDown2 = uGCImmVideoContent.isLoadDown();
            Pager pager = uGCImmVideoContent.getPager();
            uGCImmVideoDetailFragment.R0(list, isLoadDown2, pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.TRUE) : false);
        } else {
            com.transsion.ugcvideodetail.adapter.a aVar2 = uGCImmVideoDetailFragment.detailAdapter;
            if (aVar2 != null && (h02 = aVar2.h0()) != null) {
                Pager pager2 = uGCImmVideoContent.getPager();
                if (pager2 != null ? Intrinsics.c(pager2.getHasMore(), Boolean.TRUE) : false) {
                    h02.s();
                } else {
                    h02.t(true);
                    h02.z(false);
                }
            }
            com.transsion.ugcvideodetail.adapter.a aVar3 = uGCImmVideoDetailFragment.detailAdapter;
            if (aVar3 != null) {
                aVar3.q(list2);
            }
        }
        for (UGCImmVideo uGCImmVideo3 : list) {
            ao.e mediaSource = uGCImmVideo3.toMediaSource();
            if (mediaSource != null) {
                lo.f fVar = uGCImmVideoDetailFragment.orPlayer;
                boolean containsKey = (fVar == null || (a11 = fVar.a()) == null) ? false : a11.containsKey(mediaSource.e());
                a.C0856a c0856a2 = lg.a.f68962a;
                UGCVideo ugcVideo3 = uGCImmVideo3.getUgcVideo();
                a.C0856a.f(c0856a2, "UGCImmVideoDetail", "listAddDataSource----isCollection:" + Y0 + " ,inPlayerList:" + containsKey + ", Position:" + (ugcVideo3 != null ? ugcVideo3.videoUGCPosition() : -1), false, 4, null);
                if (uGCImmVideoDetailFragment.isNewPlayer || !containsKey) {
                    lo.f fVar2 = uGCImmVideoDetailFragment.orPlayer;
                    if (fVar2 != null) {
                        fVar2.addDataSource(mediaSource);
                    }
                }
            }
        }
    }

    private final void T0() {
        String str = this.firstUgcVideoId;
        if (str != null) {
            if (StringsKt.q0(str)) {
                str = null;
            }
            if (str != null) {
                D0().J0(str, this.collectionId);
                return;
            }
        }
        String str2 = this.subjectId;
        if (str2 != null) {
            String str3 = StringsKt.q0(str2) ? null : str2;
            if (str3 != null) {
                D0().K0(str3);
            }
        }
    }

    private final void U0() {
        List<Object> data;
        UGCImmVideo uGCImmVideo;
        UGCVideo ugcVideo;
        String str = this.collectionId;
        int i11 = 0;
        if (str == null || str.length() == 0) {
            a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetail", "loadMoreData, getImmVideoRecommentList, ugcVideoId:" + this.firstUgcVideoId, false, 4, null);
            D0().S0(false, this.firstUgcVideoId);
            return;
        }
        com.transsion.ugcvideodetail.adapter.a aVar = this.detailAdapter;
        if (aVar != null && (data = aVar.getData()) != null && (uGCImmVideo = (UGCImmVideo) CollectionsKt.v0(data)) != null && (ugcVideo = uGCImmVideo.getUgcVideo()) != null) {
            i11 = ugcVideo.videoUGCPosition();
        }
        int i12 = i11 + 1;
        int i13 = i11 + 9;
        a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetail", "loadMoreData, startPosition:" + i12 + ", endPosition:" + i13, false, 4, null);
        UGCImmVideoDetailViewModel D0 = D0();
        String str2 = this.collectionId;
        Intrinsics.e(str2);
        UGCImmVideoDetailViewModel.Q0(D0, str2, i12, i13, true, false, 16, null);
    }

    private final void V0() {
        Navigator.x(TheRouter.c("/download/ugc_my_downloads").F("main_tab_index", 0), requireContext(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(final UGCImmVideoDetailFragment uGCImmVideoDetailFragment, int i11) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List<Object> data;
        com.transsion.ugcvideodetail.adapter.a aVar = uGCImmVideoDetailFragment.detailAdapter;
        final int i12 = -1;
        if (aVar != null && (data = aVar.getData()) != null) {
            Iterator<Object> it = data.iterator();
            int i13 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                UGCVideo ugcVideo = ((UGCImmVideo) it.next()).getUgcVideo();
                if (ugcVideo != null && ugcVideo.videoUGCPosition() == i11) {
                    i12 = i13;
                    break;
                }
                i13++;
            }
        }
        if (i12 < 0) {
            return;
        }
        a.C0856a.r(lg.a.f68962a, "UGCImmVideoDetail", new String[]{"scrollToPosition:" + i12 + ", ep:" + i11}, false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            qv.f mViewBinding = uGCImmVideoDetailFragment.getMViewBinding();
            if (mViewBinding != null && (recyclerView2 = mViewBinding.f73853f) != null) {
                recyclerView2.scrollToPosition(i12);
            }
            qv.f mViewBinding2 = uGCImmVideoDetailFragment.getMViewBinding();
            Result.m1185constructorimpl((mViewBinding2 == null || (recyclerView = mViewBinding2.f73853f) == null) ? null : Boolean.valueOf(recyclerView.post(new Runnable() { // from class: com.transsion.ugcvideodetail.fragment.l
                @Override // java.lang.Runnable
                public final void run() {
                    UGCImmVideoDetailFragment.X0(UGCImmVideoDetailFragment.this, i12);
                }
            })));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(UGCImmVideoDetailFragment uGCImmVideoDetailFragment, int i11) {
        PagerLayoutManager pagerLayoutManager = uGCImmVideoDetailFragment.pagerLayoutManager;
        if (pagerLayoutManager != null) {
            View U = pagerLayoutManager.U();
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.r(c0856a, "UGCImmVideoDetail", new String[]{"post   itemView:" + U}, false, 4, null);
            if (U != null) {
                a.C0856a.r(c0856a, "UGCImmVideoDetail", new String[]{"post   itemView: 22222"}, false, 4, null);
                com.transsion.ugcvideodetail.hepler.b bVar = uGCImmVideoDetailFragment.pagerChangeControl;
                if (bVar != null) {
                    bVar.d(i11, true, U);
                    return;
                }
                return;
            }
            int childCount = pagerLayoutManager.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = pagerLayoutManager.getChildAt(i12);
                if (childAt != null && pagerLayoutManager.getPosition(childAt) == i11) {
                    com.transsion.ugcvideodetail.hepler.b bVar2 = uGCImmVideoDetailFragment.pagerChangeControl;
                    if (bVar2 != null) {
                        bVar2.d(i11, true, childAt);
                    }
                    a.C0856a.r(lg.a.f68962a, "UGCImmVideoDetail", new String[]{"post   itemView: 11111"}, false, 4, null);
                    return;
                }
            }
        }
    }

    private final void Z0() {
        Runnable runnable = this.downloadPopHideRunnable;
        if (runnable != null) {
            this.downloadPopHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.transsion.ugcvideodetail.fragment.c
            @Override // java.lang.Runnable
            public final void run() {
                UGCImmVideoDetailFragment.a1(UGCImmVideoDetailFragment.this);
            }
        };
        this.downloadPopHideRunnable = runnable2;
        Handler handler = this.downloadPopHandler;
        Intrinsics.e(runnable2);
        handler.postDelayed(runnable2, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(UGCImmVideoDetailFragment uGCImmVideoDetailFragment) {
        qv.m mVar;
        FrameLayout root;
        qv.f mViewBinding = uGCImmVideoDetailFragment.getMViewBinding();
        if (mViewBinding == null || (mVar = mViewBinding.f73851d) == null || (root = mVar.getRoot()) == null) {
            return;
        }
        jg.c.g(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(UGCImmVideoDetailFragment uGCImmVideoDetailFragment, DownloadBean downloadBean) {
        uGCImmVideoDetailFragment.f1(downloadBean);
        return Unit.f67184a;
    }

    private final void e1() {
        r6.g o02;
        r6.g o03;
        List<Object> data;
        UGCImmVideo uGCImmVideo;
        UGCVideo ugcVideo;
        com.transsion.ugcvideodetail.adapter.a aVar = this.detailAdapter;
        int videoUGCPosition = (aVar == null || (data = aVar.getData()) == null || (uGCImmVideo = (UGCImmVideo) CollectionsKt.v0(data)) == null || (ugcVideo = uGCImmVideo.getUgcVideo()) == null) ? 1 : ugcVideo.videoUGCPosition();
        if (videoUGCPosition <= 1) {
            com.transsion.ugcvideodetail.adapter.a aVar2 = this.detailAdapter;
            if (aVar2 == null || (o03 = aVar2.o0()) == null) {
                return;
            }
            o03.d(false);
            return;
        }
        com.transsion.ugcvideodetail.adapter.a aVar3 = this.detailAdapter;
        if (aVar3 != null && (o02 = aVar3.o0()) != null) {
            o02.e(true);
        }
        int max = Math.max(videoUGCPosition - 9, 1);
        a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetail", "upFetchData, firstPosition:" + videoUGCPosition + ", startPosition:" + max, false, 4, null);
        UGCImmVideoDetailViewModel D0 = D0();
        String str = this.collectionId;
        Intrinsics.e(str);
        UGCImmVideoDetailViewModel.Q0(D0, str, max, videoUGCPosition + (-1), false, false, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(DownloadBean bean) {
        String resourceId;
        qv.m mVar;
        AppCompatTextView appCompatTextView;
        String str = this.downloadingUgcVideoId;
        if (str == null) {
            return;
        }
        if (bean == null || (resourceId = bean.getUgcVideoId()) == null) {
            resourceId = bean != null ? bean.getResourceId() : null;
            if (resourceId == null) {
                return;
            }
        }
        if (Intrinsics.c(resourceId, str)) {
            long n11 = bean != null ? RangesKt.n(bean.getProgress(), 0L, 100L) : 0L;
            qv.f mViewBinding = getMViewBinding();
            if (mViewBinding == null || (mVar = mViewBinding.f73851d) == null || (appCompatTextView = mVar.f73924c) == null) {
                return;
            }
            appCompatTextView.setText(n11 + "%");
        }
    }

    private final void g1(UGCVideo video) {
        hj.b logViewConfig;
        HashMap g11;
        HashMap g12;
        hj.b logViewConfig2;
        HashMap g13;
        hj.b logViewConfig3;
        HashMap g14;
        HashMap g15;
        HashMap g16;
        HashMap g17;
        HashMap g18;
        String str;
        HashMap g19;
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null) {
            String ops = video.getOps();
            if (ops == null) {
                ops = this.ops;
            }
            logViewConfig4.n(ops);
        }
        hj.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 != null && (g19 = logViewConfig5.g()) != null) {
            String ugcVideoId = video.getUgcVideoId();
            if (ugcVideoId == null) {
                ugcVideoId = "";
            }
        }
        hj.b logViewConfig6 = getLogViewConfig();
        if (logViewConfig6 != null && (g18 = logViewConfig6.g()) != null) {
            UGCVideoBelongToCollection belongToCollection = video.getBelongToCollection();
            if ((belongToCollection == null || (str = belongToCollection.getCollectionId()) == null) && (str = this.collectionId) == null) {
                str = "";
            }
        }
        hj.b logViewConfig7 = getLogViewConfig();
        if (logViewConfig7 != null && (g17 = logViewConfig7.g()) != null) {
            String subjectId = video.getSubjectId();
        }
        hj.b logViewConfig8 = getLogViewConfig();
        if (logViewConfig8 != null && (g16 = logViewConfig8.g()) != null) {
        }
        hj.b logViewConfig9 = getLogViewConfig();
        if (logViewConfig9 != null && (g15 = logViewConfig9.g()) != null) {
            String str2 = this.collectionId;
        }
        y0();
        String str3 = this.fromOptId;
        if (str3 != null && (logViewConfig3 = getLogViewConfig()) != null && (g14 = logViewConfig3.g()) != null) {
        }
        String str4 = this.previousPageVideoId;
        if (str4 != null && (logViewConfig2 = getLogViewConfig()) != null && (g13 = logViewConfig2.g()) != null) {
        }
        hj.b logViewConfig10 = getLogViewConfig();
        if (logViewConfig10 != null && (g12 = logViewConfig10.g()) != null) {
        }
        String str5 = this.previousTrackId;
        if (str5 != null && (logViewConfig = getLogViewConfig()) != null && (g11 = logViewConfig.g()) != null) {
        }
        hj.b logViewConfig11 = getLogViewConfig();
        if (logViewConfig11 != null) {
            logViewConfig11.k(true);
        }
    }

    private final void initAdapter() {
        com.transsion.ugcvideodetail.adapter.a aVar = new com.transsion.ugcvideodetail.adapter.a(this, this.trackId, this.previousTrackId, this.previousPageVideoId);
        aVar.h0().C(new UGCImmVideoLoadMoreView());
        aVar.h0().z(true);
        aVar.h0().E(3);
        aVar.h0().D(new p6.f() { // from class: com.transsion.ugcvideodetail.fragment.j
            @Override // p6.f
            public final void a() {
                UGCImmVideoDetailFragment.M0(UGCImmVideoDetailFragment.this);
            }
        });
        aVar.o0().d(false);
        aVar.o0().c(2);
        aVar.o0().b(new p6.g() { // from class: com.transsion.ugcvideodetail.fragment.k
            @Override // p6.g
            public final void a() {
                UGCImmVideoDetailFragment.N0(UGCImmVideoDetailFragment.this);
            }
        });
        this.detailAdapter = aVar;
    }

    private final void x0() {
        UGCVideo ugcVideo;
        UGCImmVideo uGCImmVideo = (UGCImmVideo) D0().L0().f();
        com.transsion.ugcvideodetail.adapter.a aVar = this.detailAdapter;
        if (aVar != null) {
            int g02 = aVar.g0(uGCImmVideo) + 1;
            com.transsion.ugcvideodetail.adapter.a aVar2 = this.detailAdapter;
            if (g02 >= (aVar2 != null ? aVar2.getItemCount() : 0)) {
                return;
            }
            a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetail", "autoPlayNext", false, 4, null);
            com.transsion.ugcvideodetail.adapter.a aVar3 = this.detailAdapter;
            UGCImmVideo uGCImmVideo2 = aVar3 != null ? (UGCImmVideo) aVar3.f0(g02) : null;
            if (uGCImmVideo2 == null || (ugcVideo = uGCImmVideo2.getUgcVideo()) == null) {
                return;
            }
            D0().O0().q(Integer.valueOf(ugcVideo.videoUGCPosition()));
        }
    }

    private final void y0() {
        HashMap g11;
        if (this.pageLoadStartTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.pageLoadStartTime;
            hj.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
            }
            a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetail", "load_duration: " + currentTimeMillis + " ms", false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(UGCImmVideoDetailFragment uGCImmVideoDetailFragment, UGCImmVideo uGCImmVideo) {
        UGCVideo ugcVideo;
        UGCVideoBelongToCollection belongToCollection;
        lo.f fVar;
        Map a11;
        com.transsion.ugcvideodetail.adapter.a aVar;
        r6.g o02;
        UGCVideoBelongToCollection belongToCollection2;
        Integer videoNum;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "UGCImmVideoDetail", "detailObserver: " + uGCImmVideo, false, 4, null);
        if (uGCImmVideo != null) {
            UGCVideo ugcVideo2 = uGCImmVideo.getUgcVideo();
            String ugcVideoId = ugcVideo2 != null ? ugcVideo2.getUgcVideoId() : null;
            UGCVideo ugcVideo3 = uGCImmVideo.getUgcVideo();
            String ops = ugcVideo3 != null ? ugcVideo3.getOps() : null;
            if ((ops == null || ops.length() == 0) && (ugcVideo = uGCImmVideo.getUgcVideo()) != null) {
                ugcVideo.setOps(uGCImmVideoDetailFragment.ops);
            }
            uGCImmVideoDetailFragment.firstUgcVideo = uGCImmVideo;
            UGCVideo ugcVideo4 = uGCImmVideo.getUgcVideo();
            uGCImmVideoDetailFragment.firstUgcVideoId = ugcVideoId;
            uGCImmVideoDetailFragment.D0().D().q(uGCImmVideoDetailFragment.firstUgcVideoId);
            String str = uGCImmVideoDetailFragment.collectionId;
            if (str == null || str.length() == 0) {
                UGCVideo ugcVideo5 = uGCImmVideo.getUgcVideo();
                uGCImmVideoDetailFragment.collectionId = (ugcVideo5 == null || (belongToCollection = ugcVideo5.getBelongToCollection()) == null) ? null : belongToCollection.getCollectionId();
                uGCImmVideoDetailFragment.D0().B().q(uGCImmVideoDetailFragment.collectionId);
            }
            UGCVideo ugcVideo6 = uGCImmVideo.getUgcVideo();
            boolean z10 = false;
            if (((ugcVideo6 == null || (belongToCollection2 = ugcVideo6.getBelongToCollection()) == null || (videoNum = belongToCollection2.getVideoNum()) == null) ? 0 : videoNum.intValue()) <= 1) {
                uGCImmVideoDetailFragment.collectionId = null;
            }
            String str2 = uGCImmVideoDetailFragment.collectionId;
            if (!(str2 == null || str2.length() == 0)) {
                if ((ugcVideo4 != null ? ugcVideo4.videoUGCPosition() : 1) > 1 && (aVar = uGCImmVideoDetailFragment.detailAdapter) != null && (o02 = aVar.o0()) != null) {
                    o02.d(true);
                }
            }
            UGCImmVideoDetailViewModel D0 = uGCImmVideoDetailFragment.D0();
            String str3 = uGCImmVideoDetailFragment.collectionId;
            D0.b1(!(str3 == null || str3.length() == 0));
            com.transsion.ugcvideodetail.adapter.a aVar2 = uGCImmVideoDetailFragment.detailAdapter;
            if (aVar2 != null) {
                aVar2.p(uGCImmVideo);
            }
            UGCVideo ugcVideo7 = uGCImmVideo.getUgcVideo();
            if (ugcVideo7 != null) {
                uGCImmVideoDetailFragment.g1(ugcVideo7);
            }
            ao.e mediaSource = uGCImmVideo.toMediaSource();
            if (mediaSource != null) {
                lo.f fVar2 = uGCImmVideoDetailFragment.orPlayer;
                if (fVar2 != null && (a11 = fVar2.a()) != null) {
                    z10 = a11.containsKey(mediaSource.e());
                }
                boolean z11 = z10;
                a.C0856a.f(c0856a, "UGCImmVideoDetail", "detailAddDataSource---- ,inPlayerList:" + z11, false, 4, null);
                if ((uGCImmVideoDetailFragment.isNewPlayer || !z11) && (fVar = uGCImmVideoDetailFragment.orPlayer) != null) {
                    fVar.addDataSource(mediaSource);
                }
                lo.f fVar3 = uGCImmVideoDetailFragment.orPlayer;
                if (fVar3 != null) {
                    fVar3.prepare();
                }
                lo.f fVar4 = uGCImmVideoDetailFragment.orPlayer;
                if (fVar4 != null) {
                    fVar4.play();
                }
            }
        }
    }

    /* renamed from: C0, reason: from getter */
    public final String getCollectionId() {
        return this.collectionId;
    }

    /* renamed from: F0, reason: from getter */
    public final String getLastPageFrom() {
        return this.lastPageFrom;
    }

    /* renamed from: G0, reason: from getter */
    public final String getPreviousPageVideoId() {
        return this.previousPageVideoId;
    }

    /* renamed from: H0, reason: from getter */
    public final String getPreviousTrackId() {
        return this.previousTrackId;
    }

    /* renamed from: I0, reason: from getter */
    public final String getTrackId() {
        return this.trackId;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public qv.f getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        qv.f c11 = qv.f.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    public final AppCompatImageView L0() {
        qv.f mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.f73850c;
        }
        return null;
    }

    public final void Y0() {
        lo.f fVar = this.orPlayer;
        if (fVar != null) {
            fVar.release();
        }
        com.transsion.ugcvideodetail.hepler.b bVar = this.pagerChangeControl;
        if (bVar != null) {
            bVar.g();
        }
        E0().x(this.downloadListener);
        Runnable runnable = this.downloadPopHideRunnable;
        if (runnable != null) {
            this.downloadPopHandler.removeCallbacks(runnable);
        }
    }

    public final void b1(boolean z10) {
        this.isClickPause = z10;
    }

    public final void c1(String ugcVideoId) {
        qv.m mVar;
        if (ugcVideoId == null || ugcVideoId.length() == 0) {
            return;
        }
        this.downloadingUgcVideoId = ugcVideoId;
        qv.f mViewBinding = getMViewBinding();
        if (mViewBinding == null || (mVar = mViewBinding.f73851d) == null) {
            return;
        }
        FrameLayout root = mVar.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jg.c.k(root);
        mVar.f73924c.setText("0%");
        E0().s(ugcVideoId, new Function1() { // from class: com.transsion.ugcvideodetail.fragment.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d12;
                d12 = UGCImmVideoDetailFragment.d1(UGCImmVideoDetailFragment.this, (DownloadBean) obj);
                return d12;
            }
        });
        Z0();
        hj.i.f64628a.r("/ugc_video/immersive_detail", MapsKt.f(TuplesKt.a("dialog_name", "download_view")));
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    public final void hideLoading() {
        ProgressBar progressBar;
        qv.f mViewBinding = getMViewBinding();
        if (mViewBinding != null && (progressBar = mViewBinding.f73852e) != null) {
            jg.c.g(progressBar);
        }
        c cVar = this.loadingHandler;
        cVar.removeMessages(cVar.b());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        E0().e(this.downloadListener);
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        AppCompatImageView appCompatImageView;
        FrameLayout frameLayout;
        qv.m mVar;
        FrameLayout root;
        qv.m mVar2;
        FrameLayout root2;
        qv.m mVar3;
        FrameLayout root3;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        this.pageLoadStartTime = System.currentTimeMillis();
        initAdapter();
        O0();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        PagerLayoutManager pagerLayoutManager = new PagerLayoutManager(requireActivity);
        pagerLayoutManager.Y(true);
        this.pagerLayoutManager = pagerLayoutManager;
        com.transsion.ugcvideodetail.hepler.b bVar = new com.transsion.ugcvideodetail.hepler.b(this, this.detailAdapter, this.orPlayer, this.orPlayerView, this.pagerLayoutManager);
        this.pagerChangeControl = bVar;
        PagerLayoutManager pagerLayoutManager2 = this.pagerLayoutManager;
        if (pagerLayoutManager2 != null) {
            pagerLayoutManager2.Z(bVar);
        }
        qv.f mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView2 = mViewBinding.f73853f) != null) {
            recyclerView2.setLayoutManager(this.pagerLayoutManager);
        }
        qv.f mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (recyclerView = mViewBinding2.f73853f) != null) {
            recyclerView.setAdapter(this.detailAdapter);
        }
        qv.f mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (mVar3 = mViewBinding3.f73851d) != null && (root3 = mVar3.getRoot()) != null) {
            jg.c.g(root3);
        }
        qv.f mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (mVar2 = mViewBinding4.f73851d) != null && (root2 = mVar2.getRoot()) != null) {
            jg.c.e(root2);
        }
        qv.f mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (mVar = mViewBinding5.f73851d) != null && (root = mVar.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ugcvideodetail.fragment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UGCImmVideoDetailFragment.P0(UGCImmVideoDetailFragment.this, view);
                }
            });
        }
        qv.f mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (frameLayout = mViewBinding6.f73849b) != null) {
            jg.c.e(frameLayout);
        }
        qv.f mViewBinding7 = getMViewBinding();
        if (mViewBinding7 == null || (appCompatImageView = mViewBinding7.f73850c) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ugcvideodetail.fragment.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCImmVideoDetailFragment.Q0(UGCImmVideoDetailFragment.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        D0().D().q(this.firstUgcVideoId);
        D0().B().q(this.collectionId);
        D0().J().j(this, this.historyObserver);
        D0().I0().j(this, this.detailObserver);
        D0().R0().j(this, this.listObserver);
        D0().O0().j(this, this.playingEpObserver);
        D0().d1(this.ops);
        D0().j0(this.trackId);
        D0().h0(this.previousTrackId);
        D0().g0(this.previousPageVideoId);
        B0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.resumeTimeStamp;
            a.C0856a.r(lg.a.f68962a, "Report", new String[]{"UGCImmVideoDetail fb log duration:" + elapsedRealtime}, false, 4, null);
            com.transsion.baselib.report.e.f43398a.n("UGCImmVideoDetailFragment", Long.valueOf(elapsedRealtime), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("/ugc_video/immersive_detail", false, 2, null);
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
    public void onCompletion(ao.e mediaSource) {
        f.a.e(this, mediaSource);
        if (com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("KEY_UGC_IMM_VIDEO_AUTO_PLAY", false)) {
            x0();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, nh.n
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        lo.f fVar;
        UGCImmVideoItemView f11;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        super.onConnected(network, networkCapabilities);
        a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetail", "onConnected", false, 4, null);
        T0();
        com.transsion.ugcvideodetail.hepler.b bVar = this.pagerChangeControl;
        if (bVar != null && (f11 = bVar.f()) != null) {
            f11.onNetConnect();
        }
        if (this.errorInfo == null || (fVar = this.orPlayer) == null) {
            return;
        }
        fVar.prepare();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
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
    public void onMediaItemTransition(String uuid) {
        UGCImmVideoItemView f11;
        ao.e mediaSource;
        UGCImmVideo uGCImmVideo = this.firstUgcVideo;
        if (Intrinsics.c(uuid, (uGCImmVideo == null || (mediaSource = uGCImmVideo.toMediaSource()) == null) ? null : mediaSource.e())) {
            a.C0856a.r(lg.a.f68962a, "UGCImmVideoDetail", new String[]{"onMediaItemTransition ：" + uuid + ",是当前视频，跳过"}, false, 4, null);
            return;
        }
        boolean z10 = com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("KEY_UGC_IMM_VIDEO_AUTO_PLAY", false);
        a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetail", "onMediaItemTransition autoPlay:" + z10 + ", uuid：" + uuid, false, 4, null);
        if (z10) {
            x0();
            com.transsion.ugcvideodetail.hepler.b bVar = this.pagerChangeControl;
            if (bVar == null || (f11 = bVar.f()) == null) {
                return;
            }
            f11.onItemViewMediaItemTransition();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        UGCImmVideoItemView f11;
        super.onPause();
        com.transsion.ugcvideodetail.hepler.b bVar = this.pagerChangeControl;
        if (bVar == null || (f11 = bVar.f()) == null) {
            return;
        }
        f11.onPagePause();
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e mediaSource) {
        Intrinsics.h(errorInfo, "errorInfo");
        f.a.q(this, errorInfo, mediaSource);
        this.errorInfo = errorInfo;
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(ao.e eVar) {
        f.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        f.a.v(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e mediaSource) {
        f.a.w(this, mediaSource);
        this.errorInfo = null;
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long j11, ao.e eVar) {
        f.a.y(this, j11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        f.a.A(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        UGCImmVideoItemView f11;
        super.onResume();
        com.transsion.ugcvideodetail.hepler.b bVar = this.pagerChangeControl;
        if (bVar == null || (f11 = bVar.f()) == null) {
            return;
        }
        f11.onPageResume();
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        f.a.B(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        UGCImmVideoItemView f11;
        super.onStop();
        com.transsion.ugcvideodetail.hepler.b bVar = this.pagerChangeControl;
        if (bVar == null || (f11 = bVar.f()) == null) {
            return;
        }
        f11.onPageStop();
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
        f.a.F(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        f.a.H(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e eVar) {
        f.a.I(this, eVar);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        super.receiveArguments();
        this.lastPageFrom = hj.i.f64628a.i();
        Bundle arguments = getArguments();
        this.firstUgcVideoId = arguments != null ? arguments.getString("id") : null;
        Bundle arguments2 = getArguments();
        this.collectionId = arguments2 != null ? arguments2.getString("collection_id") : null;
        Bundle arguments3 = getArguments();
        this.subjectId = arguments3 != null ? arguments3.getString("subject_id") : null;
        Bundle arguments4 = getArguments();
        this.ugcVideoType = arguments4 != null ? arguments4.getString("ugcCategory") : null;
        Bundle arguments5 = getArguments();
        this.ops = arguments5 != null ? arguments5.getString("ops") : null;
        Bundle arguments6 = getArguments();
        this.previousPageVideoId = arguments6 != null ? arguments6.getString("parent_video_id") : null;
        Bundle arguments7 = getArguments();
        this.tabId = arguments7 != null ? arguments7.getString("tab_id") : null;
        Bundle arguments8 = getArguments();
        this.withoutHistory = arguments8 != null ? arguments8.getBoolean("ugc_without_history", false) : false;
        Bundle arguments9 = getArguments();
        this.fromOptId = arguments9 != null ? arguments9.getString("from_opt_id") : null;
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(this.lastPageFrom);
        }
        a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetail", "receiveArguments: collectionId:" + this.collectionId + ", ugcVideoId=" + this.firstUgcVideoId + ", previousPageVideoId=" + this.previousPageVideoId, false, 4, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }

    public final void startLoading() {
        c cVar = this.loadingHandler;
        if (cVar.hasMessages(cVar.b())) {
            return;
        }
        c cVar2 = this.loadingHandler;
        cVar2.sendEmptyMessageDelayed(cVar2.b(), this.loadingHandler.a());
    }
}
