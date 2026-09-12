package com.transsion.shorttv_pugc.ui.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import androidx.view.x0;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.shorttv.R$mipmap;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.base.fragment.PageStatusFragment;
import com.transsion.shorttv_pugc.base.pager.PagerLayoutManager;
import com.transsion.shorttv_pugc.base.util.DeviceKeyMonitor;
import com.transsion.shorttv_pugc.base.widget.DefaultView;
import com.transsion.shorttv_pugc.ui.dialog.ShortTvEpisodeListDialog;
import com.transsion.shorttv_pugc.ui.widget.ShortTvLoadMoreView;
import com.transsion.shorttv_pugc.ui.widget.a;
import com.transsion.shorttv_pugc.utils.ShortTvExtKt;
import com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002¢\u0001\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002µ\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0005J\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0005J\r\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0005J\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010,\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b.\u0010\u0005J\u001f\u00103\u001a\u00020\u00062\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0005J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\u0005J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\u0005J\u0015\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0014¢\u0006\u0004\b9\u0010\u0017J\r\u0010:\u001a\u00020\u0006¢\u0006\u0004\b:\u0010\u0005J\r\u0010;\u001a\u00020\u0006¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u0006H\u0016¢\u0006\u0004\b=\u0010\u0005J\u0017\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020'H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0006H\u0016¢\u0006\u0004\bA\u0010\u0005J\u000f\u0010B\u001a\u00020\u0006H\u0016¢\u0006\u0004\bB\u0010\u0005J\r\u0010C\u001a\u00020\u0006¢\u0006\u0004\bC\u0010\u0005J\u0019\u0010F\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bF\u0010GJ\u0019\u0010I\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\bI\u0010JJ!\u0010M\u001a\u00020\u00062\u0006\u0010L\u001a\u00020K2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bM\u0010NJ\u0019\u0010O\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bO\u0010GJ\u000f\u0010P\u001a\u00020\u0006H\u0016¢\u0006\u0004\bP\u0010\u0005J\u000f\u0010Q\u001a\u00020\u0006H\u0016¢\u0006\u0004\bQ\u0010\u0005J\u0011\u0010S\u001a\u0004\u0018\u00010RH\u0016¢\u0006\u0004\bS\u0010TJ\r\u0010U\u001a\u00020$¢\u0006\u0004\bU\u0010&J\u0019\u0010V\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bV\u0010GJ\u0019\u0010W\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bW\u0010GJ\u0017\u0010Y\u001a\u00020\u00062\u0006\u0010X\u001a\u00020'H\u0016¢\u0006\u0004\bY\u0010@J\u000f\u0010Z\u001a\u00020\u0006H\u0016¢\u0006\u0004\bZ\u0010\u0005J\u0017\u0010\\\u001a\u00020\u00062\u0006\u0010[\u001a\u00020'H\u0016¢\u0006\u0004\b\\\u0010@R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010c\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010iR\u0018\u0010p\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010iR\u0018\u0010r\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010iR\u0016\u0010t\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010iR\u0016\u0010v\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010bR\u001b\u0010|\u001a\u00020w8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0016\u0010\u0092\u0001\u001a\u00020$8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010iR\u0018\u0010\u0094\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010iR\u0019\u0010\u0097\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u009b\u0001\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010b\u001a\u0005\b\u0099\u0001\u0010)\"\u0005\b\u009a\u0001\u0010@R\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010¡\u0001\u001a\u00020d8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010fR\u0018\u0010¥\u0001\u001a\u00030¢\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R(\u0010«\u0001\u001a\u00020d8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b¦\u0001\u0010f\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u001a\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0018\u0010±\u0001\u001a\u00030®\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0018\u0010´\u0001\u001a\u00030²\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010³\u0001¨\u0006¶\u0001"}, d2 = {"Lcom/transsion/shorttv_pugc/ui/fragment/ShortTvDetailListFragment;", "Lcom/transsion/shorttv_pugc/base/fragment/PageStatusFragment;", "Lms/c0;", "Lcom/transsion/player/orplayer/f;", "<init>", "()V", "", "initView", "E0", "initAdapter", "showEmpty", "Landroid/content/Context;", "context", "Landroid/view/View;", "getEmptyView", "(Landroid/content/Context;)Landroid/view/View;", "loadData", "J0", "M0", "v0", "", "toPosition", "scrollToPosition", "(I)V", "C0", "R0", "Lot/d;", "x0", "()Lot/d;", "Q0", "K0", "S0", "Landroid/view/LayoutInflater;", "inflater", "y0", "(Landroid/view/LayoutInflater;)Lms/c0;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "", "isAudioShowNoNetworkLayout", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initViewData", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "initViewModel", "initListener", "retryLoadData", "ep", "N0", "hideLoading", "startLoading", "onResume", "onPause", "hidden", "onHiddenChanged", "(Z)V", "logPause", "logResume", "L0", "Lao/e;", "mediaSource", "onCompletion", "(Lao/e;)V", "uuid", "onMediaItemTransition", "(Ljava/lang/String;)V", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lao/e;)V", "onPrepare", "onDestroyView", "onDestroy", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "getPageName", "onVideoPause", "onVideoStart", "videoPlaying", "T0", "onStop", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "Lcom/transsion/shorttv_pugc/ui/dialog/ShortTvEpisodeListDialog;", "i", "Lcom/transsion/shorttv_pugc/ui/dialog/ShortTvEpisodeListDialog;", "shortListDialog", com.mbridge.msdk.foundation.same.report.j.f35620b, "Z", "isNewPlayer", "", CampaignEx.JSON_KEY_AD_K, "J", "lastShowNetWorkErrToastTime", "l", "Ljava/lang/String;", "ugcVideoId", "m", "subjectId", "n", "collectionId", "o", "fromOptId", TtmlNode.TAG_P, "ops", CampaignEx.JSON_KEY_AD_Q, "mItemType", CampaignEx.JSON_KEY_AD_R, "ugcWithoutHistory", "Lcom/transsion/shorttv_pugc/viewmodel/ShortTvViewModel;", "s", "Lkotlin/Lazy;", "z0", "()Lcom/transsion/shorttv_pugc/viewmodel/ShortTvViewModel;", "viewModel", "Lcom/transsion/shorttv_pugc/base/pager/PagerLayoutManager;", "t", "Lcom/transsion/shorttv_pugc/base/pager/PagerLayoutManager;", "mPagerLayoutManager", "Lcom/transsion/shorttv_pugc/ui/widget/u;", TmcStartParams.KEY_URL_SHORT, "Lcom/transsion/shorttv_pugc/ui/widget/u;", "mPagerChangeControl", "Lcom/transsion/shorttv_pugc/ui/adapter/e;", "v", "Lcom/transsion/shorttv_pugc/ui/adapter/e;", "mAdapter", "Llo/f;", "w", "Llo/f;", "mOrPlayer", "Lcom/transsion/player/ui/ORPlayerView;", "x", "Lcom/transsion/player/ui/ORPlayerView;", "mOrPlayerView", "y", "loggerTag", "z", "lastPageFrom", "A", "I", "lastEp", "B", "isClickPause$shortTvLib_release", "P0", "isClickPause", "Lcom/transsion/shorttv_pugc/base/util/DeviceKeyMonitor;", "C", "Lcom/transsion/shorttv_pugc/base/util/DeviceKeyMonitor;", "deviceKeyMonitor", "D", "pageStartTime", "com/transsion/shorttv_pugc/ui/fragment/ShortTvDetailListFragment$d", "E", "Lcom/transsion/shorttv_pugc/ui/fragment/ShortTvDetailListFragment$d;", "loadingHandler", "F", "getResumeTimeStamp", "()J", "setResumeTimeStamp", "(J)V", "resumeTimeStamp", "G", "Lcom/transsion/player/orplayer/PlayError;", "Lst/j;", "H", "Lst/j;", "downloadListener", "Lbt/b;", "Lbt/b;", "exposureHelper", "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTvDetailListFragment extends PageStatusFragment<ms.c0> implements com.transsion.player.orplayer.f {

    /* renamed from: A, reason: from kotlin metadata */
    private int lastEp;

    /* renamed from: B, reason: from kotlin metadata */
    private boolean isClickPause;

    /* renamed from: C, reason: from kotlin metadata */
    private DeviceKeyMonitor deviceKeyMonitor;

    /* renamed from: E, reason: from kotlin metadata */
    private final d loadingHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private long resumeTimeStamp;

    /* renamed from: G, reason: from kotlin metadata */
    private PlayError errorInfo;

    /* renamed from: H, reason: from kotlin metadata */
    private final st.j downloadListener;

    /* renamed from: I, reason: from kotlin metadata */
    private final bt.b exposureHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ShortTvEpisodeListDialog shortListDialog;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long lastShowNetWorkErrToastTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String ugcVideoId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String subjectId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String collectionId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private String fromOptId;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean ugcWithoutHistory;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private PagerLayoutManager mPagerLayoutManager;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private com.transsion.shorttv_pugc.ui.widget.u mPagerChangeControl;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private com.transsion.shorttv_pugc.ui.adapter.e mAdapter;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private lo.f mOrPlayer;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private ORPlayerView mOrPlayerView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isNewPlayer = true;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private String mItemType = "";

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(ShortTvViewModel.class), new Function0<x0>() { // from class: com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final String loggerTag = "ShortTvListFragment";

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom = "";

    /* renamed from: D, reason: from kotlin metadata */
    private long pageStartTime = System.currentTimeMillis();

    /* loaded from: classes6.dex */
    public static final class b implements bt.a {
        b() {
        }

        @Override // bt.a
        public void a(int i11, long j11, View view) {
            List<Object> data;
            com.transsion.shorttv_pugc.ui.adapter.e eVar = ShortTvDetailListFragment.this.mAdapter;
            if (eVar == null || (data = eVar.getData()) == null) {
                return;
            }
            ShortTvDetailListFragment shortTvDetailListFragment = ShortTvDetailListFragment.this;
            if (data.size() < i11) {
                return;
            }
            ut.a aVar = ut.a.f77014a;
            ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) CollectionsKt.l0(data, i11);
            String str = shortTvDetailListFragment.ops;
            if (str == null) {
                str = "";
            }
            aVar.d(j11, uGCVideo, "", str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends DiffUtil.e {
        c() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(ShorttvModel.UGCVideo oldItem, ShorttvModel.UGCVideo newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return oldItem.getEp() == newItem.getEp();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(ShorttvModel.UGCVideo oldItem, ShorttvModel.UGCVideo newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return oldItem.getEp() == newItem.getEp();
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final int f54231a;

        /* renamed from: b, reason: collision with root package name */
        private final long f54232b;

        d(Looper looper) {
            super(looper);
            this.f54231a = 1;
            this.f54232b = 300L;
        }

        public final long a() {
            return this.f54232b;
        }

        public final int b() {
            return this.f54231a;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ms.c0 c0Var;
            ProgressBar progressBar;
            Intrinsics.h(msg, "msg");
            super.handleMessage(msg);
            if (msg.what != this.f54231a || (c0Var = (ms.c0) ShortTvDetailListFragment.this.getMViewBinding()) == null || (progressBar = c0Var.f69850b) == null) {
                return;
            }
            ct.b.d(progressBar);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements DeviceKeyMonitor.b {
        e() {
        }

        @Override // com.transsion.shorttv_pugc.base.util.DeviceKeyMonitor.b
        public void onHomeClick() {
            ShortTvDetailListFragment.this.R0();
        }

        @Override // com.transsion.shorttv_pugc.base.util.DeviceKeyMonitor.b
        public void onRecentClick() {
            ShortTvDetailListFragment.this.R0();
        }
    }

    /* loaded from: classes6.dex */
    static final class f implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f54236a;

        f(Function1 function) {
            Intrinsics.h(function, "function");
            this.f54236a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f54236a;
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
            this.f54236a.invoke(obj);
        }
    }

    public ShortTvDetailListFragment() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        this.loadingHandler = new d(myLooper);
        this.downloadListener = new st.j() { // from class: com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment$downloadListener$1
            @Override // st.j
            public void a(String str, int i11) {
                String str2;
                str2 = ShortTvDetailListFragment.this.ugcVideoId;
                if (Intrinsics.c(str, str2)) {
                    kotlinx.coroutines.k.d(androidx.view.v.a(ShortTvDetailListFragment.this), null, null, new ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$1(ShortTvDetailListFragment.this, str, null), 3, null);
                }
            }
        };
        this.exposureHelper = new bt.b(0.6f, new b(), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(ShortTvDetailListFragment shortTvDetailListFragment) {
        shortTvDetailListFragment.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ShortTvDetailListFragment shortTvDetailListFragment) {
        shortTvDetailListFragment.J0();
    }

    private final void C0() {
        FrameLayout root;
        ms.c0 c0Var = (ms.c0) getMViewBinding();
        if (c0Var == null || (root = c0Var.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.shorttv_pugc.ui.fragment.a0
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvDetailListFragment.D0(ShortTvDetailListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(ShortTvDetailListFragment shortTvDetailListFragment) {
        st.e N;
        FragmentActivity activity = shortTvDetailListFragment.getActivity();
        if (activity == null || (N = shortTvDetailListFragment.z0().N()) == null) {
            return;
        }
        String str = shortTvDetailListFragment.ugcVideoId;
        if (str == null) {
            str = "";
        }
        N.b(activity, str, shortTvDetailListFragment.getPageName(), shortTvDetailListFragment.ops);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v5, types: [lo.e] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, com.transsion.player.shorttv.preload.c] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.SurfaceView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void E0() {
        /*
            r10 = this;
            com.transsion.player.ui.ORPlayerView r0 = new com.transsion.player.ui.ORPlayerView
            androidx.fragment.app.FragmentActivity r1 = r10.requireActivity()
            java.lang.String r2 = "requireActivity(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r2)
            com.transsion.player.config.RenderType r2 = com.transsion.player.config.RenderType.SURFACE_VIEW
            r0.<init>(r1, r2)
            r10.mOrPlayerView = r0
            com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel r0 = r10.z0()
            st.e r0 = r0.N()
            r1 = 0
            if (r0 == 0) goto L24
            java.lang.String r2 = r10.ugcVideoId
            com.transsion.player.orplayer.g r0 = r0.d(r2)
            goto L25
        L24:
            r0 = r1
        L25:
            r2 = 1
            if (r0 != 0) goto L2a
            r3 = r2
            goto L2b
        L2a:
            r3 = 0
        L2b:
            r10.isNewPlayer = r3
            lg.a$a r4 = lg.a.f68962a
            java.lang.String r5 = r10.loggerTag
            java.lang.String r6 = r10.ugcVideoId
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "initOrPlayer isNewPlayer:"
            r7.append(r8)
            r7.append(r3)
            java.lang.String r3 = ", mSubjectId:"
            r7.append(r3)
            r7.append(r6)
            java.lang.String r3 = "}"
            r7.append(r3)
            java.lang.String r6 = r7.toString()
            r8 = 4
            r9 = 0
            r7 = 0
            lg.a.C0856a.f(r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L6f
            boolean r2 = r0 instanceof lo.e
            if (r2 == 0) goto L60
            lo.e r0 = (lo.e) r0
            goto L61
        L60:
            r0 = r1
        L61:
            if (r0 == 0) goto L80
            com.transsion.player.ui.ORPlayerView r2 = r10.mOrPlayerView
            if (r2 == 0) goto L6b
            android.view.SurfaceView r1 = r2.getSurface()
        L6b:
            r0.setSurfaceView(r1)
            goto L7f
        L6f:
            lo.e r0 = new lo.e
            r0.<init>(r1, r2, r1)
            com.transsion.player.ui.ORPlayerView r2 = r10.mOrPlayerView
            if (r2 == 0) goto L7c
            android.view.SurfaceView r1 = r2.getSurface()
        L7c:
            r0.setSurfaceView(r1)
        L7f:
            r1 = r0
        L80:
            r10.mOrPlayer = r1
            com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel r0 = r10.z0()
            st.e r0 = r0.N()
            if (r0 == 0) goto L8f
            r0.c()
        L8f:
            lo.f r0 = r10.mOrPlayer
            if (r0 == 0) goto L96
            r0.addPlayerListener(r10)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment.E0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(ShortTvDetailListFragment shortTvDetailListFragment) {
        shortTvDetailListFragment.K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f6, code lost:
    
        if (r2 == null) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit G0(com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment r9, com.transsion.shorttv_pugc.ShorttvModel.UGCVideo r10) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment.G0(com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment, com.transsion.shorttv_pugc.ShorttvModel$UGCVideo):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(ShortTvDetailListFragment shortTvDetailListFragment, Pair pair) {
        com.transsion.shorttv_pugc.ui.adapter.e eVar;
        List<Object> data;
        List<ShorttvModel.UGCVideo> e11;
        lo.f fVar;
        shortTvDetailListFragment.hideLoading();
        List list = (List) pair.getSecond();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ao.e a11 = com.transsion.shorttv_pugc.a.a((ShorttvModel.UGCVideo) it.next());
                if (a11 != null && a11.e() != null && (fVar = shortTvDetailListFragment.mOrPlayer) != null) {
                    fVar.addDataSource(a11);
                }
            }
        }
        List list2 = (List) pair.getSecond();
        if (list2 != null && !list2.isEmpty() && (eVar = shortTvDetailListFragment.mAdapter) != null && (data = eVar.getData()) != null && (e11 = ShortTvExtKt.e(data, list2)) != null) {
            for (ShorttvModel.UGCVideo uGCVideo : e11) {
                com.transsion.shorttv_pugc.ui.adapter.e eVar2 = shortTvDetailListFragment.mAdapter;
                if (eVar2 != null) {
                    eVar2.notifyItemChanged(ShortTvExtKt.d(uGCVideo.getEp()));
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(ShortTvDetailListFragment shortTvDetailListFragment, Integer num) {
        Intrinsics.e(num);
        shortTvDetailListFragment.N0(num.intValue());
        if (shortTvDetailListFragment.lastEp != 0) {
            if (num.intValue() >= shortTvDetailListFragment.lastEp) {
                int G = shortTvDetailListFragment.z0().G();
                if (num.intValue() + 3 >= G) {
                    ShortTvViewModel.a0(shortTvDetailListFragment.z0(), null, G, G + 5, 1, null);
                }
            } else {
                int F = shortTvDetailListFragment.z0().F();
                if (F > 1) {
                    ShortTvViewModel.a0(shortTvDetailListFragment.z0(), null, F - 6, F - 1, 1, null);
                }
            }
        }
        shortTvDetailListFragment.lastEp = num.intValue();
        return Unit.f67184a;
    }

    private final void J0() {
        int intValue;
        String r11 = z0().r();
        if (r11 != null) {
            ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) CollectionsKt.k0(z0().z());
            if (uGCVideo != null) {
                intValue = uGCVideo.getEp();
            } else {
                Integer num = (Integer) z0().s().f();
                intValue = num != null ? num.intValue() : 1;
            }
            z0().Z(r11, Math.max(intValue - 10, 1), intValue);
        }
    }

    private final void M0() {
        com.transsion.shorttv_pugc.ui.widget.u uVar = this.mPagerChangeControl;
        long h11 = uVar != null ? uVar.h() : 0L;
        ShorttvModel.UGCVideo t11 = z0().t();
        if (t11 == null) {
            return;
        }
        lo.f fVar = this.mOrPlayer;
        t11.setDurationMillis(fVar != null ? fVar.getDuration() : 0L);
        z0().b0(t11, h11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(ShortTvDetailListFragment shortTvDetailListFragment, int i11) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        PagerLayoutManager pagerLayoutManager = shortTvDetailListFragment.mPagerLayoutManager;
        if (pagerLayoutManager != null) {
            View T = pagerLayoutManager.T();
            Log.e(shortTvDetailListFragment.loggerTag, "post   itemView:" + T);
            if (T != null) {
                Log.e(shortTvDetailListFragment.loggerTag, "post   itemView: 22222");
                com.transsion.shorttv_pugc.ui.widget.u uVar = shortTvDetailListFragment.mPagerChangeControl;
                if (uVar != null) {
                    uVar.d(i11, true, T);
                }
                ms.c0 c0Var = (ms.c0) shortTvDetailListFragment.getMViewBinding();
                if (c0Var == null || (recyclerView = c0Var.f69851c) == null) {
                    return;
                }
                recyclerView.requestLayout();
                return;
            }
            int childCount = pagerLayoutManager.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = pagerLayoutManager.getChildAt(i12);
                if (childAt != null && pagerLayoutManager.getPosition(childAt) == i11) {
                    com.transsion.shorttv_pugc.ui.widget.u uVar2 = shortTvDetailListFragment.mPagerChangeControl;
                    if (uVar2 != null) {
                        uVar2.d(i11, true, childAt);
                    }
                    ms.c0 c0Var2 = (ms.c0) shortTvDetailListFragment.getMViewBinding();
                    if (c0Var2 != null && (recyclerView2 = c0Var2.f69851c) != null) {
                        recyclerView2.requestLayout();
                    }
                    Log.e(shortTvDetailListFragment.loggerTag, "post   itemView: 11111");
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0() {
        ot.d x02;
        st.e N;
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        if (this.isClickPause) {
            lg.a.f68962a.c("video_float", "shottv 视频暂停，无需触发画中画", true);
        } else {
            if (this.mOrPlayer == null || this.mOrPlayerView == null || (x02 = x0()) == null || (N = z0().N()) == null) {
                return;
            }
            N.h(activity, x02);
        }
    }

    private final View getEmptyView(Context context) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        defaultView.setGravity(17);
        defaultView.setDefaultImageViewVisibility(0);
        defaultView.setDefaultImage(R$mipmap.short_tv_ic_no_content);
        String string = context.getString(R$string.short_tv_no_content);
        Intrinsics.g(string, "getString(...)");
        defaultView.setDescText(string);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string2 = context.getString(R$string.short_tv_Retry);
        Intrinsics.g(string2, "getString(...)");
        defaultView.setBtnText(string2);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv_pugc.ui.fragment.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvDetailListFragment.w0(ShortTvDetailListFragment.this, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    private final void initAdapter() {
        com.transsion.shorttv_pugc.ui.adapter.e eVar = new com.transsion.shorttv_pugc.ui.adapter.e(new ArrayList(), this, false, this.ugcVideoId, this.mItemType, false, 32, null);
        eVar.h0().C(new ShortTvLoadMoreView());
        eVar.h0().z(false);
        eVar.h0().y(false);
        eVar.h0().D(new p6.f() { // from class: com.transsion.shorttv_pugc.ui.fragment.y
            @Override // p6.f
            public final void a() {
                ShortTvDetailListFragment.A0(ShortTvDetailListFragment.this);
            }
        });
        eVar.o0().d(true);
        eVar.o0().c(2);
        eVar.o0().b(new p6.g() { // from class: com.transsion.shorttv_pugc.ui.fragment.z
            @Override // p6.g
            public final void a() {
                ShortTvDetailListFragment.B0(ShortTvDetailListFragment.this);
            }
        });
        eVar.R0(new c());
        this.mAdapter = eVar;
    }

    private final void initView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        initAdapter();
        E0();
        C0();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        this.mPagerLayoutManager = new PagerLayoutManager(requireActivity);
        com.transsion.shorttv_pugc.ui.widget.u uVar = new com.transsion.shorttv_pugc.ui.widget.u(this, this.mAdapter, this.mOrPlayer, this.mOrPlayerView, this.mPagerLayoutManager);
        this.mPagerChangeControl = uVar;
        PagerLayoutManager pagerLayoutManager = this.mPagerLayoutManager;
        if (pagerLayoutManager != null) {
            pagerLayoutManager.X(uVar);
        }
        ms.c0 c0Var = (ms.c0) getMViewBinding();
        if (c0Var != null && (recyclerView4 = c0Var.f69851c) != null) {
            recyclerView4.setLayoutManager(this.mPagerLayoutManager);
        }
        ms.c0 c0Var2 = (ms.c0) getMViewBinding();
        if (c0Var2 != null && (recyclerView3 = c0Var2.f69851c) != null) {
            recyclerView3.setAdapter(this.mAdapter);
        }
        ms.c0 c0Var3 = (ms.c0) getMViewBinding();
        if (c0Var3 != null && (recyclerView2 = c0Var3.f69851c) != null) {
            recyclerView2.addOnScrollListener(this.exposureHelper);
        }
        ms.c0 c0Var4 = (ms.c0) getMViewBinding();
        if (c0Var4 != null && (recyclerView = c0Var4.f69851c) != null) {
            recyclerView.post(new Runnable() { // from class: com.transsion.shorttv_pugc.ui.fragment.t
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvDetailListFragment.F0(ShortTvDetailListFragment.this);
                }
            });
        }
        com.transsion.shorttv_pugc.utils.e a11 = com.transsion.shorttv_pugc.utils.e.f54495c.a();
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.g(requireActivity2, "requireActivity(...)");
        a11.e(requireActivity2);
    }

    private final void loadData() {
        if (z0().A().f() == null) {
            z0().Y(this.ugcVideoId, this.subjectId, this.collectionId);
            String str = this.collectionId;
            if (str == null || str.length() == 0) {
                return;
            }
            kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new ShortTvDetailListFragment$loadData$1(this, null), 3, null);
            return;
        }
        String r11 = z0().r();
        if (r11 != null) {
            Integer num = (Integer) z0().s().f();
            int max = Math.max(1, num != null ? num.intValue() : 1);
            z0().Z(r11, max, max + 10);
        }
    }

    private final void scrollToPosition(final int toPosition) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        this.isNewPlayer = true;
        ms.c0 c0Var = (ms.c0) getMViewBinding();
        if (c0Var != null && (recyclerView2 = c0Var.f69851c) != null) {
            recyclerView2.scrollToPosition(toPosition);
        }
        ms.c0 c0Var2 = (ms.c0) getMViewBinding();
        if (c0Var2 == null || (recyclerView = c0Var2.f69851c) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.shorttv_pugc.ui.fragment.b0
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvDetailListFragment.O0(ShortTvDetailListFragment.this, toPosition);
            }
        });
    }

    private final void showEmpty() {
        com.transsion.shorttv_pugc.ui.adapter.e eVar;
        List<Object> data;
        hideLoading();
        com.transsion.shorttv_pugc.ui.adapter.e eVar2 = this.mAdapter;
        if (eVar2 == null || (data = eVar2.getData()) == null || !(!data.isEmpty())) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            View emptyView = getEmptyView(requireContext);
            if (emptyView == null || (eVar = this.mAdapter) == null) {
                return;
            }
            eVar.Y0(emptyView);
        }
    }

    private final void v0() {
        Integer num = (Integer) z0().s().f();
        if (num != null) {
            int intValue = num.intValue();
            int i11 = intValue + 1;
            com.transsion.shorttv_pugc.ui.adapter.e eVar = this.mAdapter;
            if ((eVar != null ? com.transsion.shorttv_pugc.ui.adapter.e.R1(eVar, i11, false, 2, null) : null) != null) {
                z0().c0(i11);
                a.C0856a.f(lg.a.f68962a, this.loggerTag, "autoPlayNext  currentEp:" + intValue + "  nextEp:" + i11, false, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(ShortTvDetailListFragment shortTvDetailListFragment, DefaultView defaultView, View view) {
        shortTvDetailListFragment.loadData();
        defaultView.setVisibility(8);
    }

    private final ot.d x0() {
        String str;
        Integer num = (Integer) z0().s().f();
        if (num != null) {
            int intValue = num.intValue();
            List<ShorttvModel.UGCVideo> p11 = z0().p();
            if (this.mOrPlayer != null && this.mOrPlayerView != null) {
                ArrayList arrayList = new ArrayList();
                ShorttvModel.UGCVideo uGCVideo = null;
                for (ShorttvModel.UGCVideo uGCVideo2 : p11) {
                    if (uGCVideo2.getEp() == intValue) {
                        uGCVideo = uGCVideo2;
                    }
                    arrayList.add(uGCVideo2);
                }
                ORPlayerView oRPlayerView = this.mOrPlayerView;
                Intrinsics.e(oRPlayerView);
                lo.f fVar = this.mOrPlayer;
                Intrinsics.e(fVar);
                if (uGCVideo == null || (str = uGCVideo.getUgcVideoId()) == null) {
                    str = "";
                }
                return new ot.d(oRPlayerView, fVar, str, uGCVideo != null ? uGCVideo.getEp() : 1, getPageName(), uGCVideo != null ? uGCVideo.getOps() : null, this.lastPageFrom, arrayList, uGCVideo);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShortTvViewModel z0() {
        return (ShortTvViewModel) this.viewModel.getValue();
    }

    public final void K0() {
        if (this.shortListDialog == null) {
            ShortTvEpisodeListDialog shortTvEpisodeListDialog = new ShortTvEpisodeListDialog(this.ops);
            this.shortListDialog = shortTvEpisodeListDialog;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            shortTvEpisodeListDialog.show(childFragmentManager, "preload");
            ShortTvEpisodeListDialog shortTvEpisodeListDialog2 = this.shortListDialog;
            if (shortTvEpisodeListDialog2 != null) {
                shortTvEpisodeListDialog2.dismissAllowingStateLoss();
            }
        }
    }

    public final void L0() {
        st.e N = z0().N();
        if (N != null && N.f(this.mOrPlayer)) {
            st.e N2 = z0().N();
            if (N2 != null && N2.e(this.mOrPlayer)) {
                lg.a.f68962a.c(this.loggerTag, " 播放器在缓存中，这里不能release", true);
                return;
            }
            lo.f fVar = this.mOrPlayer;
            if (fVar != null) {
                fVar.stop();
            }
            lo.f fVar2 = this.mOrPlayer;
            if (fVar2 != null) {
                fVar2.release();
            }
        }
        a.C0856a.f(lg.a.f68962a, this.loggerTag, "onDestroy  removePlayerListener", false, 4, null);
        lo.f fVar3 = this.mOrPlayer;
        if (fVar3 != null) {
            fVar3.removePlayerListener(this);
        }
        st.c L = z0().L();
        if (L != null) {
            L.c();
        }
        DeviceKeyMonitor deviceKeyMonitor = this.deviceKeyMonitor;
        if (deviceKeyMonitor != null) {
            deviceKeyMonitor.b();
        }
    }

    public final void N0(int ep2) {
        com.transsion.shorttv_pugc.ui.widget.u uVar = this.mPagerChangeControl;
        if (uVar != null) {
            int g11 = uVar.g();
            if (g11 == ShortTvExtKt.d(ep2)) {
                a.C0856a c0856a = lg.a.f68962a;
                String str = this.loggerTag;
                com.transsion.shorttv_pugc.ui.widget.u uVar2 = this.mPagerChangeControl;
                a.C0856a.f(c0856a, str, "scrollToEpisode current:" + (uVar2 != null ? Integer.valueOf(uVar2.g()) : null) + " == " + ep2, false, 4, null);
                return;
            }
            if (ep2 >= 0 && ep2 <= z0().p().size()) {
                if (g11 >= z0().p().size()) {
                    return;
                }
                com.transsion.shorttv_pugc.ui.widget.u uVar3 = this.mPagerChangeControl;
                if (uVar3 != null) {
                    uVar3.k(true);
                }
                scrollToPosition(ShortTvExtKt.d(ep2));
                return;
            }
            a.C0856a c0856a2 = lg.a.f68962a;
            String str2 = this.loggerTag;
            com.transsion.shorttv_pugc.ui.widget.u uVar4 = this.mPagerChangeControl;
            a.C0856a.f(c0856a2, str2, "scrollToEpisode current:" + (uVar4 != null ? Integer.valueOf(uVar4.g()) : null) + " over bounds", false, 4, null);
        }
    }

    public final void P0(boolean z10) {
        this.isClickPause = z10;
    }

    public final void Q0() {
        if (this.shortListDialog == null) {
            this.shortListDialog = new ShortTvEpisodeListDialog(this.ops);
        }
        ShortTvEpisodeListDialog shortTvEpisodeListDialog = this.shortListDialog;
        if (shortTvEpisodeListDialog != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            shortTvEpisodeListDialog.show(childFragmentManager, "immComment");
        }
    }

    public final void S0() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastShowNetWorkErrToastTime > ToastStrategy.LONG_DURATION_TIMEOUT) {
            this.lastShowNetWorkErrToastTime = currentTimeMillis;
            com.transsion.shorttv_pugc.base.widget.toast.core.h.f54023a.h(R$string.short_tv_no_network_toast);
        }
    }

    public void T0(boolean videoPlaying) {
        try {
            Result.Companion companion = Result.INSTANCE;
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                st.e N = z0().N();
                Unit unit = null;
                if (N != null) {
                    ORPlayerView oRPlayerView = this.mOrPlayerView;
                    Object parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
                    N.a(activity, true, videoPlaying, parent instanceof ViewGroup ? (ViewGroup) parent : null);
                    unit = Unit.f67184a;
                }
                Result.m1185constructorimpl(unit);
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    public final String getPageName() {
        return "/ugc_shorts/detail";
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    public final void hideLoading() {
        ProgressBar progressBar;
        ms.c0 c0Var = (ms.c0) getMViewBinding();
        if (c0Var != null && (progressBar = c0Var.f69850b) != null) {
            ct.b.b(progressBar);
        }
        d dVar = this.loadingHandler;
        dVar.removeMessages(dVar.b());
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public void initViewData() {
        initView();
        startLoading();
        loadData();
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public void initViewModel() {
        z0().A().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.shorttv_pugc.ui.fragment.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G0;
                G0 = ShortTvDetailListFragment.G0(ShortTvDetailListFragment.this, (ShorttvModel.UGCVideo) obj);
                return G0;
            }
        }));
        z0().u().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.shorttv_pugc.ui.fragment.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = ShortTvDetailListFragment.H0(ShortTvDetailListFragment.this, (Pair) obj);
                return H0;
            }
        }));
        z0().s().j(this, new f(new Function1() { // from class: com.transsion.shorttv_pugc.ui.fragment.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I0;
                I0 = ShortTvDetailListFragment.I0(ShortTvDetailListFragment.this, (Integer) obj);
                return I0;
            }
        }));
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.resumeTimeStamp;
            st.d M = z0().M();
            if (M != null) {
                M.a(getPageName(), Long.valueOf(elapsedRealtime), getContext());
            }
        }
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("/ugc_shorts/detail", false, 2, null);
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
        v0();
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment, nh.n
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        lo.f fVar;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        super.onConnected(network, networkCapabilities);
        Log.e(this.loggerTag, "onConnected");
        String r11 = z0().r();
        if (r11 == null || r11.length() == 0) {
            loadData();
        }
        com.transsion.shorttv_pugc.ui.widget.u uVar = this.mPagerChangeControl;
        if (uVar != null) {
            uVar.i();
        }
        if (this.errorInfo == null || (fVar = this.mOrPlayer) == null) {
            return;
        }
        fVar.prepare();
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        HashMap g11;
        super.onCreate(savedInstanceState);
        this.lastPageFrom = hj.i.f64628a.i();
        Bundle arguments = getArguments();
        this.ugcVideoId = arguments != null ? arguments.getString("id") : null;
        Bundle arguments2 = getArguments();
        this.subjectId = arguments2 != null ? arguments2.getString("subjectId") : null;
        Bundle arguments3 = getArguments();
        this.collectionId = arguments3 != null ? arguments3.getString("collectionId") : null;
        Bundle arguments4 = getArguments();
        this.fromOptId = arguments4 != null ? arguments4.getString("fromOptId") : null;
        Bundle arguments5 = getArguments();
        this.ops = arguments5 != null ? arguments5.getString("ops") : null;
        Bundle arguments6 = getArguments();
        this.ugcWithoutHistory = arguments6 != null ? arguments6.getBoolean("ugc_without_history") : false;
        z0().g0(this.ops);
        z0().h0(this.ugcWithoutHistory);
        String str = this.ugcVideoId;
        if (str == null || str.length() == 0) {
            requireActivity().finish();
        }
        st.c L = z0().L();
        if (L != null) {
            L.d(this.downloadListener);
        }
        Context context = getContext();
        if (context != null) {
            this.deviceKeyMonitor = new DeviceKeyMonitor(context, new e());
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
            g11.put("belong_to_collection_id", this.collectionId);
            g11.put("content_id", this.ugcVideoId);
            g11.put("ops", this.ops);
            g11.put("content_type", "ugc_video");
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.n(this.ops);
        }
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        DeviceKeyMonitor deviceKeyMonitor = this.deviceKeyMonitor;
        if (deviceKeyMonitor != null) {
            deviceKeyMonitor.b();
        }
        super.onDestroy();
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        f.a.g(this, z10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                lo.f fVar = this.mOrPlayer;
                if (fVar != null) {
                    fVar.pause();
                }
                logPause();
                return;
            }
            lo.f fVar2 = this.mOrPlayer;
            if (fVar2 != null) {
                fVar2.play();
            }
            logResume();
        }
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String uuid) {
        List<Object> arrayList;
        View f11;
        ShorttvModel.UGCVideo uGCVideo;
        this.isNewPlayer = true;
        Integer num = (Integer) z0().s().f();
        if (num != null) {
            int intValue = num.intValue();
            com.transsion.shorttv_pugc.ui.adapter.e eVar = this.mAdapter;
            if (eVar != null) {
                int T1 = com.transsion.shorttv_pugc.ui.adapter.e.T1(eVar, intValue, false, 2, null);
                com.transsion.shorttv_pugc.ui.adapter.e eVar2 = this.mAdapter;
                if (eVar2 == null || ((ShorttvModel.UGCVideo) eVar2.f0(T1)) == null || T1 == -1) {
                    return;
                }
                com.transsion.shorttv_pugc.ui.adapter.e eVar3 = this.mAdapter;
                if (eVar3 == null || (arrayList = eVar3.getData()) == null) {
                    arrayList = new ArrayList<>();
                }
                int i11 = T1 + 1;
                ShorttvModel.UGCVideo uGCVideo2 = (ShorttvModel.UGCVideo) CollectionsKt.l0(arrayList, i11);
                if (uGCVideo2 == null) {
                    return;
                }
                a.C0856a c0856a = lg.a.f68962a;
                a.C0856a.f(c0856a, this.loggerTag, "onMediaItemTransition uuid:" + uuid + " nextItem:" + uGCVideo2, false, 4, null);
                if (uGCVideo2.isDataNotComplete()) {
                    lo.f fVar = this.mOrPlayer;
                    if (fVar != null) {
                        fVar.pause();
                        return;
                    }
                    return;
                }
                com.transsion.shorttv_pugc.ui.adapter.e eVar4 = this.mAdapter;
                if (eVar4 != null) {
                    eVar4.notifyItemInserted(T1);
                }
                com.transsion.shorttv_pugc.ui.widget.u uVar = this.mPagerChangeControl;
                if (uVar == null || (f11 = uVar.f()) == 0) {
                    return;
                }
                if (f11 instanceof com.transsion.shorttv_pugc.ui.widget.a) {
                    com.transsion.player.orplayer.f fVar2 = (com.transsion.player.orplayer.f) f11;
                    String ugcVideoId = uGCVideo2.getUgcVideoId();
                    if (ugcVideoId == null) {
                        ugcVideoId = "";
                    }
                    fVar2.onMediaItemTransition(ugcVideoId);
                    uGCVideo = uGCVideo2;
                    a.C0665a.a((com.transsion.shorttv_pugc.ui.widget.a) f11, uGCVideo2, this, Integer.valueOf(i11), false, null, null, false, false, 128, null);
                    com.transsion.shorttv_pugc.ui.widget.u uVar2 = this.mPagerChangeControl;
                    if (uVar2 != null) {
                        uVar2.d(i11, false, f11);
                    }
                    lo.f fVar3 = this.mOrPlayer;
                    boolean isPlaying = fVar3 != null ? fVar3.isPlaying() : false;
                    a.C0856a.f(c0856a, this.loggerTag, "onMediaItemTransition  isPlaying:" + isPlaying, false, 4, null);
                    if (isPlaying) {
                        fVar2.onRenderFirstFrame();
                    }
                } else {
                    uGCVideo = uGCVideo2;
                }
                z0().c0(uGCVideo.getEp());
            }
        }
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        M0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        st.e N;
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        ot.d x02 = x0();
        if (x02 == null || (N = z0().N()) == null) {
            return;
        }
        N.g(isInPictureInPictureMode, getActivity(), x02);
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

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        f.a.B(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
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
    public void onVideoPause(ao.e mediaSource) {
        f.a.F(this, mediaSource);
        T0(false);
        hideLoading();
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        f.a.H(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e mediaSource) {
        f.a.I(this, mediaSource);
        T0(true);
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    public void retryLoadData() {
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }

    public final void startLoading() {
        d dVar = this.loadingHandler;
        if (dVar.hasMessages(dVar.b())) {
            return;
        }
        d dVar2 = this.loadingHandler;
        dVar2.sendEmptyMessageDelayed(dVar2.b(), this.loadingHandler.a());
    }

    @Override // com.transsion.shorttv_pugc.base.fragment.PageStatusFragment
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public ms.c0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        ms.c0 c11 = ms.c0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
