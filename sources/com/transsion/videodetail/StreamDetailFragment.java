package com.transsion.videodetail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.v0;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.MemberGuideBannerView;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.baselib.db.download.VipInfo;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baseui.activity.BaseMusicFloatActivity;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.bean.GameInfoType;
import com.transsion.commercializationapi.IGameResApi;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.fragment.ResourceDetectorEmptyFragment;
import com.transsion.moviedetail.fragment.ResourceDetectorFamilyModeFragment;
import com.transsion.moviedetail.fragment.RestrictTipsDialog;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectGameInfo;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.player.longvideo.constants.LongVodPageType;
import com.transsion.player.longvideo.intercept.PlaybackInterceptionManager;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.player.p007enum.PlayMimeType;
import com.transsion.postdetail.shorttv.widget.ShortTVHistoryView;
import com.transsion.publish.api.IPublishApi;
import com.transsion.push.PushConstants;
import com.transsion.rewardscenterapi.IRewardsCenterApi;
import com.transsion.rewardscenterapi.Lottery;
import com.transsion.rewardscenterapi.RewardsCenterData;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import com.transsion.videodetail.bean.VideoDetailStream;
import com.transsion.videodetail.bean.VideoDetailStreamList;
import com.transsion.videodetail.util.StreamFloatManager;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.wrapperad.view.cardpage.NativeCardPageAdHelper;
import com.transsion.wrapperad.view.cardpage.NativeCardPageView;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import fo.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import net.lucode.hackware.magicindicator.MagicIndicator;
import nh.n;
import ox.e;
import sx.a;

@Metadata(d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n*\u0002ò\u0001\u0018\u0000 \u0087\u00022\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0088\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0019\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u0019\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J)\u0010 \u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0005J\u0019\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b*\u0010+J%\u00100\u001a\b\u0012\u0004\u0012\u00020/0.2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u001eH\u0002¢\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u0002032\b\u00102\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u000eH\u0002¢\u0006\u0004\b7\u0010\u0011J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0005J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0005J\u000f\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010\u0005J\u000f\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010<\u001a\u00020\u0006H\u0002¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u000eH\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010\u0005J\u000f\u0010@\u001a\u00020\u0006H\u0002¢\u0006\u0004\b@\u0010\u0005J\u000f\u0010A\u001a\u00020\u0006H\u0002¢\u0006\u0004\bA\u0010\u0005J\u000f\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010\u0005J\u000f\u0010C\u001a\u00020\u0006H\u0002¢\u0006\u0004\bC\u0010\u0005J\u0019\u0010F\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0006H\u0002¢\u0006\u0004\bH\u0010\u0005J\u000f\u0010I\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010\u0005J\u0017\u0010L\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ\u0011\u0010O\u001a\u0004\u0018\u00010NH\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0006H\u0002¢\u0006\u0004\bQ\u0010\u0005J\u0017\u0010T\u001a\u00020\u00062\u0006\u0010S\u001a\u00020RH\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0006H\u0002¢\u0006\u0004\bV\u0010\u0005J\u0017\u0010W\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bW\u0010\u0016J\u0017\u0010Z\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020XH\u0002¢\u0006\u0004\bZ\u0010[J\u0019\u0010^\u001a\u00020\u00062\b\u0010]\u001a\u0004\u0018\u00010\\H\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010a\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u0013H\u0002¢\u0006\u0004\ba\u0010\u0016J\u0019\u0010d\u001a\u00020\u00062\b\u0010c\u001a\u0004\u0018\u00010bH\u0016¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020\u0006H\u0016¢\u0006\u0004\bf\u0010\u0005J\u0017\u0010i\u001a\u00020\u00022\u0006\u0010h\u001a\u00020gH\u0016¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020\\H\u0016¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020\u000eH\u0016¢\u0006\u0004\bm\u0010>J\u000f\u0010n\u001a\u00020\u0006H\u0016¢\u0006\u0004\bn\u0010\u0005J\u000f\u0010o\u001a\u00020\u0006H\u0016¢\u0006\u0004\bo\u0010\u0005J\u000f\u0010p\u001a\u00020\u0006H\u0016¢\u0006\u0004\bp\u0010\u0005J\u000f\u0010q\u001a\u00020\u0006H\u0016¢\u0006\u0004\bq\u0010\u0005J\u000f\u0010s\u001a\u00020rH\u0016¢\u0006\u0004\bs\u0010tJ\u000f\u0010u\u001a\u00020\u0006H\u0016¢\u0006\u0004\bu\u0010\u0005J\u0011\u0010w\u001a\u0004\u0018\u00010vH\u0016¢\u0006\u0004\bw\u0010xJ\u000f\u0010y\u001a\u00020\u0006H\u0016¢\u0006\u0004\by\u0010\u0005J\u000f\u0010z\u001a\u00020\u0006H\u0016¢\u0006\u0004\bz\u0010\u0005J\u000f\u0010{\u001a\u00020\u0006H\u0016¢\u0006\u0004\b{\u0010\u0005J\r\u0010|\u001a\u00020\u0006¢\u0006\u0004\b|\u0010\u0005J\u0017\u0010~\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\u000eH\u0016¢\u0006\u0004\b~\u0010\u0011J\u000f\u0010\u007f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u007f\u0010\u0005J\u0011\u0010\u0080\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0080\u0001\u0010\u0005J\u0011\u0010\u0081\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0081\u0001\u0010\u0005J$\u0010\u0084\u0001\u001a\u00020\u00062\u0010\u0010\u0083\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0082\u0001H\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0017\u0010\u0086\u0001\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u0013¢\u0006\u0005\b\u0086\u0001\u0010\u0016R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001b\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R!\u0010\u0097\u0001\u001a\u00030\u0092\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R!\u0010\u009c\u0001\u001a\u00030\u0098\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u0094\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R!\u0010¡\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u0094\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001R#\u0010¦\u0001\u001a\u0005\u0018\u00010¢\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b£\u0001\u0010\u0094\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001R\u001b\u0010©\u0001\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001b\u0010«\u0001\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010¨\u0001R\u0019\u0010®\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010°\u0001\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010¨\u0001R\u0019\u0010²\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010\u00ad\u0001R\u0019\u0010´\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010\u00ad\u0001R\u001b\u0010¶\u0001\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¨\u0001R(\u0010¼\u0001\u001a\u00020D8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0005\b»\u0001\u0010GR\u0019\u0010¾\u0001\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¸\u0001R\u0019\u0010À\u0001\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010¸\u0001R\u0019\u0010Â\u0001\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010¸\u0001R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010¨\u0001R\u0019\u0010Æ\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010\u00ad\u0001R\u001b\u0010É\u0001\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u0019\u0010Ë\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010\u00ad\u0001R\u001c\u0010Ï\u0001\u001a\u0005\u0018\u00010Ì\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R#\u0010Ô\u0001\u001a\u0005\u0018\u00010Ð\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÑ\u0001\u0010\u0094\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001R\u0019\u0010×\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u0019\u0010Ú\u0001\u001a\u00020R8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R\"\u0010Ý\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u0019\u0010ß\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010\u00ad\u0001R\u001c\u0010ã\u0001\u001a\u0005\u0018\u00010à\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R\u0019\u0010å\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010Ö\u0001R\u0019\u0010ç\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010Ö\u0001R\u0019\u0010é\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010Ö\u0001R\u0019\u0010ë\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010Ö\u0001R\u0019\u0010í\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010Ö\u0001R\u0019\u0010î\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010Ö\u0001R\u0019\u0010ï\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010Ö\u0001R\u0019\u0010ñ\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010Ö\u0001R\u0018\u0010õ\u0001\u001a\u00030ò\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bó\u0001\u0010ô\u0001R\u001a\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R \u0010û\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010(0ø\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010ý\u0001R\u001c\u0010\u0081\u0002\u001a\u0005\u0018\u00010þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0080\u0002R\u0019\u0010\u0083\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0002\u0010\u00ad\u0001R\u0019\u0010\u0084\u0002\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010¨\u0001R\u0019\u0010\u0086\u0002\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010¨\u0001¨\u0006\u0088\u0002"}, d2 = {"Lcom/transsion/videodetail/StreamDetailFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Ljx/i;", "Lyn/a;", "<init>", "()V", "", "a2", "r1", "Lcom/transsion/videodetail/bean/VideoDetailMediaSource;", "episodeMedia", "g1", "(Lcom/transsion/videodetail/bean/VideoDetailMediaSource;)V", "a1", "", "isAudioTracksChange", "O1", "(Z)V", "n2", "Lcom/transsion/moviedetailapi/bean/Subject;", "movieDetailBean", "w2", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "u1", "u2", "subject", "d2", "B1", "Lcom/transsion/baselib/db/video/VideoDetailPlayBean;", ShortTVHistoryView.TYPE_HISTORY, "", "episodeMediaList", "m1", "(Lcom/transsion/baselib/db/video/VideoDetailPlayBean;Ljava/util/List;)Lcom/transsion/videodetail/bean/VideoDetailMediaSource;", "b1", "l2", "Lgo/a;", "bean", "U1", "(Lgo/a;)V", "Lcom/transsion/videodetail/bean/VideoDetailStreamList;", "videoDetailStreamList", "W1", "(Lcom/transsion/videodetail/bean/VideoDetailStreamList;)V", "Lcom/transsion/videodetail/bean/VideoDetailStream;", "videoDetailStream", "", "Lgo/c;", "q1", "(Ljava/util/List;)Ljava/util/List;", "stream", "Lcom/transsion/player/enum/PlayMimeType;", "k1", "(Lcom/transsion/videodetail/bean/VideoDetailStream;)Lcom/transsion/player/enum/PlayMimeType;", PushConstants.PUSH_SERVICE_TYPE_SHOW, "R1", "S1", "showLoading", "e1", "k2", "f1", "Y0", "()Z", "s1", "Z0", "d1", "r2", "w1", "", "visible", "s2", "(I)V", "c1", "E1", "Lcom/transsion/videofloat/bean/FloatActionType;", "actionType", "g2", "(Lcom/transsion/videofloat/bean/FloatActionType;)Z", "Lpx/a;", "h1", "()Lpx/a;", "y1", "Lcom/transsion/player/longvideo/ui/LongVodUiType;", "uiType", "T1", "(Lcom/transsion/player/longvideo/ui/LongVodUiType;)V", "j2", "C1", "", "tsLayoutDone", "Z1", "(J)V", "", "genre", "N1", "(Ljava/lang/String;)V", "data", "o2", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "receiveArguments", "Landroid/view/LayoutInflater;", "inflater", "p1", "(Landroid/view/LayoutInflater;)Ljx/i;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "isRegisteDeviceKeyMonitor", "initViewData", "initViewModel", "initListener", "retryLoadData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "loadDefaultData", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "onResume", "onPause", "onStop", "Y1", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "onHomeClick", "onRecentClick", "onDestroy", "Lkotlin/Function0;", "callback", "R", "(Lkotlin/jvm/functions/Function0;)V", "f2", "Lfo/a;", "a", "Lfo/a;", "playerControl", "Ltn/e;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ltn/e;", "bottomRecHelper", "c", "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "d", "Lkotlin/Lazy;", "l1", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "Lcom/transsion/videodetail/VideoDetailViewModel;", "e", "o1", "()Lcom/transsion/videodetail/VideoDetailViewModel;", "videoDetailViewModel", "Lcom/transsnet/downloader/viewmodel/k0;", "f", "getDownloadViewModel", "()Lcom/transsnet/downloader/viewmodel/k0;", "downloadViewModel", "Lcom/transsion/publish/api/IPublishApi;", be.g.f16474b, "n1", "()Lcom/transsion/publish/api/IPublishApi;", "publishedApi", "h", "Ljava/lang/String;", "mSubjectId", "i", "ops", com.mbridge.msdk.foundation.same.report.j.f35620b, "Z", "netResultSuccess", CampaignEx.JSON_KEY_AD_K, "moduleName", "l", "autoDownload", "m", "autoPlay", "n", "autoPlayResourceId", "o", "I", "getPreloadId", "()I", "setPreloadId", "preloadId", TtmlNode.TAG_P, "curSeason", CampaignEx.JSON_KEY_AD_Q, "targetSeason", CampaignEx.JSON_KEY_AD_R, "targetEp", "s", "lastPageFrom", "t", "hasClickedActivityTip", TmcStartParams.KEY_URL_SHORT, "Landroid/view/View;", "gameResView", "v", "isGameResInit", "Lcom/transsion/fissionapi/IFissionProvider;", "w", "Lcom/transsion/fissionapi/IFissionProvider;", "palmPayApi", "Lcom/transsion/memberapi/IMemberApi;", "x", "j1", "()Lcom/transsion/memberapi/IMemberApi;", "memberProvider", "y", "J", "curAudioTrackPlayProgress", "z", "Lcom/transsion/player/longvideo/ui/LongVodUiType;", "curPlayerUiType", "A", "Lkotlin/jvm/functions/Function0;", "backPressedCallback", "B", "hasResource", "Lcom/transsion/wrapperad/view/cardpage/NativeCardPageAdHelper;", "C", "Lcom/transsion/wrapperad/view/cardpage/NativeCardPageAdHelper;", "adHelper", "D", "tsEnter", "E", "tsRequestStart", "F", "tsCallback", "G", "tsInitStart", "H", "tsInitDone", "tsAddView", "tsViewCreatedStart", "K", "tsViewCreatedEnd", "com/transsion/videodetail/StreamDetailFragment$d", "L", "Lcom/transsion/videodetail/StreamDetailFragment$d;", "networkStatusChangedListener", "M", "Lcom/transsion/videodetail/bean/VideoDetailStreamList;", "Landroidx/lifecycle/c0;", "N", "Landroidx/lifecycle/c0;", "playInfoObserver", "O", "Lcom/transsion/baselib/db/video/VideoDetailPlayBean;", "Ljx/j;", "P", "Ljx/j;", "loadingViewBinding", "Q", "showNetErr", "traceId", "S", "curSubjectId", "T", "VideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class StreamDetailFragment extends PageStatusFragment<jx.i> implements yn.a {

    /* renamed from: T, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private Function0 backPressedCallback;

    /* renamed from: C, reason: from kotlin metadata */
    private NativeCardPageAdHelper adHelper;

    /* renamed from: D, reason: from kotlin metadata */
    private long tsEnter;

    /* renamed from: E, reason: from kotlin metadata */
    private long tsRequestStart;

    /* renamed from: F, reason: from kotlin metadata */
    private long tsCallback;

    /* renamed from: G, reason: from kotlin metadata */
    private long tsInitStart;

    /* renamed from: H, reason: from kotlin metadata */
    private long tsInitDone;

    /* renamed from: I, reason: from kotlin metadata */
    private long tsAddView;

    /* renamed from: J, reason: from kotlin metadata */
    private long tsViewCreatedStart;

    /* renamed from: K, reason: from kotlin metadata */
    private long tsViewCreatedEnd;

    /* renamed from: M, reason: from kotlin metadata */
    private VideoDetailStreamList videoDetailStreamList;

    /* renamed from: O, reason: from kotlin metadata */
    private VideoDetailPlayBean history;

    /* renamed from: P, reason: from kotlin metadata */
    private jx.j loadingViewBinding;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean showNetErr;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private fo.a playerControl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private tn.e bottomRecHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String mSubjectId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean netResultSuccess;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean autoDownload;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String autoPlayResourceId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int preloadId;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int targetSeason;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int targetEp;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean hasClickedActivityTip;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private View gameResView;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean isGameResInit;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private long curAudioTrackPlayProgress;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$2
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
    private final Lazy videoDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(VideoDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$4
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

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsnet.downloader.viewmodel.k0.class), new Function0<androidx.view.x0>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$5
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$6
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
    private final Lazy publishedApi = LazyKt.b(new Function0() { // from class: com.transsion.videodetail.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IPublishApi X1;
            X1 = StreamDetailFragment.X1();
            return X1;
        }
    });

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int curSeason = 1;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private IFissionProvider palmPayApi = (IFissionProvider) TheRouter.d(IFissionProvider.class, new Object[0]);

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final Lazy memberProvider = LazyKt.b(new Function0() { // from class: com.transsion.videodetail.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IMemberApi Q1;
            Q1 = StreamDetailFragment.Q1();
            return Q1;
        }
    });

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private LongVodUiType curPlayerUiType = LongVodUiType.MIDDLE;

    /* renamed from: B, reason: from kotlin metadata */
    private boolean hasResource = true;

    /* renamed from: L, reason: from kotlin metadata */
    private final d networkStatusChangedListener = new d();

    /* renamed from: N, reason: from kotlin metadata */
    private final androidx.view.c0 playInfoObserver = new androidx.view.c0() { // from class: com.transsion.videodetail.j
        @Override // androidx.view.c0
        public final void onChanged(Object obj) {
            StreamDetailFragment.V1(StreamDetailFragment.this, (VideoDetailStreamList) obj);
        }
    };

    /* renamed from: R, reason: from kotlin metadata */
    private String traceId = "";

    /* renamed from: S, reason: from kotlin metadata */
    private String curSubjectId = "";

    /* renamed from: com.transsion.videodetail.StreamDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StreamDetailFragment a() {
            return new StreamDetailFragment();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BubbleTextView bubbleTextView;
            ViewTreeObserver viewTreeObserver;
            jx.i mViewBinding = StreamDetailFragment.this.getMViewBinding();
            if (mViewBinding != null && (bubbleTextView = mViewBinding.f66546b) != null && (viewTreeObserver = bubbleTextView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            jx.i mViewBinding2 = StreamDetailFragment.this.getMViewBinding();
            BubbleTextView bubbleTextView2 = mViewBinding2 != null ? mViewBinding2.f66546b : null;
            if (bubbleTextView2 == null || bubbleTextView2.getMeasuredWidth() == 0) {
                return;
            }
            float measuredWidth = (bubbleTextView2.getMeasuredWidth() / 2) - (com.blankj.utilcode.util.a0.a(16.0f) / 2);
            bubbleTextView2.setArrowPosition(measuredWidth);
            a.C0856a.f(lg.a.f68962a, "videoDetail", "activity tip width: " + bubbleTextView2.getMeasuredWidth() + ", arrowPosition: " + measuredWidth, false, 4, null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends androidx.activity.u {
        c() {
            super(true);
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            Function0 function0 = StreamDetailFragment.this.backPressedCallback;
            if (function0 == null || !((Boolean) function0.invoke()).booleanValue()) {
                if (StreamDetailFragment.this.playerControl != null) {
                    fo.a aVar = StreamDetailFragment.this.playerControl;
                    if (aVar != null) {
                        aVar.onBackPressed();
                        return;
                    }
                    return;
                }
                FragmentActivity activity = StreamDetailFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements nh.n {
        d() {
        }

        @Override // nh.n
        public void onConnected() {
            n.a.a(this);
        }

        @Override // nh.n
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            StreamDetailFragment.this.f1();
            VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) StreamDetailFragment.this.o1().x().f();
            if (videoDetailMediaSource != null) {
                StreamDetailFragment streamDetailFragment = StreamDetailFragment.this;
                VideoDetailStreamList videoDetailStreamList = (VideoDetailStreamList) streamDetailFragment.o1().w().f();
                if (videoDetailStreamList != null && videoDetailMediaSource.getSe() == videoDetailStreamList.getSe() && videoDetailMediaSource.getEp() == videoDetailStreamList.getEp()) {
                    return;
                }
                streamDetailFragment.g1(videoDetailMediaSource);
            }
        }

        @Override // nh.n
        public void onDisconnected() {
        }
    }

    /* loaded from: classes7.dex */
    static final class e implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f57718a;

        e(Function1 function) {
            Intrinsics.h(function, "function");
            this.f57718a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f57718a;
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
            this.f57718a.invoke(obj);
        }
    }

    /* loaded from: classes7.dex */
    public static final class f implements sx.a {
        f() {
        }

        @Override // sx.a
        public boolean a(px.a aVar) {
            return StreamFloatManager.f57996b.r(aVar);
        }

        @Override // sx.a
        public void b(px.a aVar) {
            a.C0946a.a(this, aVar);
            StreamFloatManager.f57996b.q(aVar);
        }

        @Override // sx.a
        public void c(px.a aVar) {
            StreamFloatManager streamFloatManager = StreamFloatManager.f57996b;
            streamFloatManager.p();
            streamFloatManager.t(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LongVodPlayerView f57719a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ StreamDetailFragment f57720b;

        g(LongVodPlayerView longVodPlayerView, StreamDetailFragment streamDetailFragment) {
            this.f57719a = longVodPlayerView;
            this.f57720b = streamDetailFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f57719a.getWidth() == 0 || this.f57719a.getHeight() == 0) {
                return;
            }
            this.f57719a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f57720b.Z1(SystemClock.elapsedRealtime());
        }
    }

    /* loaded from: classes7.dex */
    public static final class h implements a.b {
        h() {
        }

        @Override // fo.a.b
        public void a() {
            StreamDetailFragment.this.b1();
        }

        @Override // fo.a.b
        public boolean b() {
            if (StreamDetailFragment.this.showNetErr && nh.m.f70597a.e()) {
                StreamDetailFragment streamDetailFragment = StreamDetailFragment.this;
                streamDetailFragment.g1((VideoDetailMediaSource) streamDetailFragment.o1().x().f());
            }
            return StreamDetailFragment.this.showNetErr;
        }

        @Override // fo.a.b
        public boolean c(FloatActionType actionType) {
            Intrinsics.h(actionType, "actionType");
            return StreamDetailFragment.this.g2(actionType);
        }

        @Override // fo.a.b
        public void d(LongVodUiType uiType) {
            Intrinsics.h(uiType, "uiType");
            StreamDetailFragment.this.curPlayerUiType = uiType;
            StreamDetailFragment.this.T1(uiType);
            tn.e eVar = StreamDetailFragment.this.bottomRecHelper;
            if (eVar != null) {
                eVar.x(uiType != LongVodUiType.MIDDLE);
            }
        }

        @Override // fo.a.b
        public View e() {
            return StreamDetailFragment.this.gameResView;
        }

        @Override // fo.a.b
        public void f(go.a aVar) {
            StreamDetailFragment.this.U1(aVar);
        }

        @Override // fo.a.b
        public void g(boolean z10) {
            AppCompatImageView appCompatImageView;
            jx.i mViewBinding = StreamDetailFragment.this.getMViewBinding();
            if (mViewBinding == null || (appCompatImageView = mViewBinding.f66556l) == null) {
                return;
            }
            appCompatImageView.setVisibility(z10 ? 0 : 8);
        }

        @Override // fo.a.b
        public void h(String str) {
            StreamDetailFragment.this.o1().y().n(str);
        }

        @Override // fo.a.b
        public void onCompletion() {
            StreamDetailFragment.this.b1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(StreamDetailFragment streamDetailFragment, View view) {
        fo.a aVar = streamDetailFragment.playerControl;
        if (aVar != null) {
            if (aVar != null) {
                aVar.onBackPressed();
            }
        } else {
            FragmentActivity activity = streamDetailFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void B1() {
        ResourcesSeasonList resourcesSeasonList;
        if (this.mSubjectId == null || (resourcesSeasonList = (ResourcesSeasonList) o1().z().f()) == null) {
            return;
        }
        if (resourcesSeasonList.isNoSource()) {
            a.C0856a.f(lg.a.f68962a, "videoDetail", "checkPlayInfo 没有资源", false, 4, null);
            return;
        }
        if (resourcesSeasonList.isSeries()) {
            a.C0856a.f(lg.a.f68962a, "videoDetail", "checkPlayInfo 是剧集，获取记录决定哪集", false, 4, null);
            List list = (List) o1().s().f();
            if (list == null) {
                return;
            }
            VideoDetailPlayBean videoDetailPlayBean = (VideoDetailPlayBean) o1().u().f();
            this.history = videoDetailPlayBean;
            o1().C(m1(videoDetailPlayBean, list));
            return;
        }
        if (resourcesSeasonList.isMovie()) {
            a.C0856a.f(lg.a.f68962a, "videoDetail", "checkPlayInfo 是电影", false, 4, null);
            List list2 = (List) o1().s().f();
            if (list2 == null) {
                return;
            }
            this.history = (VideoDetailPlayBean) o1().u().f();
            o1().C((VideoDetailMediaSource) CollectionsKt.k0(list2));
        }
    }

    private final void C1(Subject movieDetailBean) {
        String restrictLevel = movieDetailBean.getRestrictLevel();
        if (restrictLevel == null || restrictLevel.length() == 0 || !com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("restrict_tips_dialog_again", true)) {
            return;
        }
        fo.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onHandlePause();
        }
        ConfigBean d11 = sm.f.d(sm.f.f75530c.a(), "sa_restrict_tips", false, 2, null);
        String value = d11 != null ? d11.getValue() : null;
        if (value == null || value.length() == 0) {
            value = Utils.a().getString(com.transsion.moviedetail.R$string.movie_detail_restrict_tips);
        }
        final RestrictTipsDialog a11 = RestrictTipsDialog.INSTANCE.a(value, "stream_detail", movieDetailBean.getSubjectId());
        a11.l0(this, "RestrictTipsDialog");
        a11.y0(new Function1() { // from class: com.transsion.videodetail.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D1;
                D1 = StreamDetailFragment.D1(RestrictTipsDialog.this, this, ((Boolean) obj).booleanValue());
                return D1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(RestrictTipsDialog restrictTipsDialog, StreamDetailFragment streamDetailFragment, boolean z10) {
        if (z10) {
            fo.a aVar = streamDetailFragment.playerControl;
            if (aVar != null) {
                aVar.onHandlePlay();
            }
        } else {
            FragmentActivity activity = restrictTipsDialog.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        return Unit.f67184a;
    }

    private final void E1() {
        ConstraintLayout root;
        jx.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (root = mViewBinding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.videodetail.c0
            @Override // java.lang.Runnable
            public final void run() {
                StreamDetailFragment.F1(StreamDetailFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(StreamDetailFragment streamDetailFragment) {
        Subject subject;
        String subjectId;
        String ops;
        FragmentActivity activity = streamDetailFragment.getActivity();
        if (activity == null || (subject = streamDetailFragment.mMovieDetailBean) == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        ox.b c11 = ox.b.f72314a.c();
        Subject subject2 = streamDetailFragment.mMovieDetailBean;
        c11.e(activity, subjectId, null, "stream_detail", (subject2 == null || (ops = subject2.getOps()) == null) ? streamDetailFragment.ops : ops);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1(StreamDetailFragment streamDetailFragment, VideoDetailMediaSource videoDetailMediaSource) {
        a.C0856a.v(lg.a.f68962a, "VideoDetailEpisode", "--------PlayingEpisodeMediaLiveDat:observe", false, 4, null);
        streamDetailFragment.g1(videoDetailMediaSource);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(StreamDetailFragment streamDetailFragment, VideoDetailPlayBean videoDetailPlayBean) {
        Subject subject;
        String str = streamDetailFragment.ops;
        if (str == null || str.length() == 0) {
            streamDetailFragment.ops = videoDetailPlayBean != null ? videoDetailPlayBean.getOps() : null;
        }
        Subject subject2 = streamDetailFragment.mMovieDetailBean;
        String ops = subject2 != null ? subject2.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject = streamDetailFragment.mMovieDetailBean) != null) {
            subject.setOps(videoDetailPlayBean != null ? videoDetailPlayBean.getOps() : null);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(StreamDetailFragment streamDetailFragment, DubsInfo dubsInfo) {
        fo.a aVar = streamDetailFragment.playerControl;
        streamDetailFragment.curAudioTrackPlayProgress = aVar != null ? aVar.currentPosition() : 0L;
        streamDetailFragment.mSubjectId = dubsInfo.getSubjectId();
        streamDetailFragment.mMovieDetailBean = null;
        streamDetailFragment.videoDetailStreamList = null;
        streamDetailFragment.o1().D();
        MovieDetailViewModel l12 = streamDetailFragment.l1();
        int i11 = streamDetailFragment.preloadId;
        String str = streamDetailFragment.mSubjectId;
        if (str == null) {
            str = "";
        }
        l12.S(i11, str, Integer.valueOf(streamDetailFragment.curSeason));
        streamDetailFragment.O1(true);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J1(StreamDetailFragment streamDetailFragment, Pair pair) {
        HashMap g11;
        HashMap g12;
        HashMap g13;
        Subject subject = (Subject) pair.getSecond();
        lg.a.f68962a.c("videoDetail", "get movie detail data==" + pair, true);
        if (subject == null) {
            if (Intrinsics.c(pair.getFirst(), "404")) {
                com.tn.lib.widget.toast.core.h.f41533a.k(com.transsion.moviedetail.R$string.movie_lost_content);
                kotlinx.coroutines.k.d(androidx.view.v.a(streamDetailFragment), null, null, new StreamDetailFragment$initViewModel$1$1$1(streamDetailFragment, null), 3, null);
            }
            if (nh.m.f70597a.e()) {
                PageStatusFragment.showEmptyView$default(streamDetailFragment, false, 1, null);
            } else {
                PageStatusFragment.showNoNetworkView$default(streamDetailFragment, false, 1, null);
            }
        } else {
            if (subject.getIsRefreshViewOnly()) {
                streamDetailFragment.w2(subject);
                return Unit.f67184a;
            }
            streamDetailFragment.tsCallback = SystemClock.elapsedRealtime();
            MovieDetailViewModel l12 = streamDetailFragment.l1();
            String subjectId = subject.getSubjectId();
            Integer subjectType = subject.getSubjectType();
            Context context = streamDetailFragment.getContext();
            MovieDetailViewModel.u(l12, subjectId, subjectType, 0, context != null && com.transsion.baseui.util.b.a(context), 4, null);
            streamDetailFragment.showContentView();
            streamDetailFragment.netResultSuccess = true;
            streamDetailFragment.w2(subject);
            streamDetailFragment.u2();
            streamDetailFragment.r1();
            streamDetailFragment.n2();
            hj.b logViewConfig = streamDetailFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            hj.b logViewConfig2 = streamDetailFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.n(streamDetailFragment.ops);
            }
            hj.b logViewConfig3 = streamDetailFragment.getLogViewConfig();
            if (logViewConfig3 != null && (g13 = logViewConfig3.g()) != null) {
                String subjectId2 = subject.getSubjectId();
                if (subjectId2 == null) {
                    subjectId2 = "";
                }
                g13.put("subject_id", subjectId2);
            }
            hj.b logViewConfig4 = streamDetailFragment.getLogViewConfig();
            if (logViewConfig4 != null && (g12 = logViewConfig4.g()) != null) {
                g12.put("has_resource", String.valueOf(subject.getHasResource()));
            }
            hj.b logViewConfig5 = streamDetailFragment.getLogViewConfig();
            if (logViewConfig5 != null && (g11 = logViewConfig5.g()) != null) {
                g11.put("module_name", streamDetailFragment.moduleName);
            }
            streamDetailFragment.o2(subject);
            streamDetailFragment.f2(subject);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(StreamDetailFragment streamDetailFragment, Integer num) {
        int i11 = streamDetailFragment.curSeason;
        if (num != null && i11 == num.intValue()) {
            return Unit.f67184a;
        }
        Intrinsics.e(num);
        streamDetailFragment.curSeason = num.intValue();
        String str = streamDetailFragment.mSubjectId;
        if (str != null) {
            streamDetailFragment.l1().D(str, Integer.valueOf(streamDetailFragment.curSeason), true);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(StreamDetailFragment streamDetailFragment, ResourcesSeasonList resourcesSeasonList) {
        streamDetailFragment.u2();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(StreamDetailFragment streamDetailFragment, List list) {
        streamDetailFragment.B1();
        return Unit.f67184a;
    }

    private final void N1(String genre) {
        NativeCardPageView nativeCardPageView;
        NativeCardPageAdHelper G;
        NativeCardPageAdHelper F;
        jx.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (nativeCardPageView = mViewBinding.f66560p) == null) {
            return;
        }
        jg.c.g(nativeCardPageView);
        NativeCardPageAdHelper nativeCardPageAdHelper = this.adHelper;
        if (nativeCardPageAdHelper == null || (G = nativeCardPageAdHelper.G("StreamingMediaContentScene")) == null || (F = G.F(com.transsion.ad.strategy.d.f42285a.a(genre))) == null) {
            return;
        }
        F.u(nativeCardPageView);
    }

    private final void O1(boolean isAudioTracksChange) {
        HashMap g11;
        MovieDetailActivity.INSTANCE.a("videoDetail start load data ....");
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
            String str = this.mSubjectId;
            if (str == null) {
                str = "";
            }
            g11.put("subject_id", str);
        }
        Bundle arguments = getArguments();
        this.ops = arguments != null ? arguments.getString("ops") : null;
        if (nh.m.f70597a.e()) {
            if (!isAudioTracksChange) {
                showLoadingView();
            }
            String str2 = this.mSubjectId;
            if (str2 != null) {
                this.tsRequestStart = SystemClock.elapsedRealtime();
                MovieDetailViewModel.E(l1(), str2, Integer.valueOf(this.curSeason), false, 4, null);
                o1().r(str2);
                o1().q(str2);
            }
        }
    }

    static /* synthetic */ void P1(StreamDetailFragment streamDetailFragment, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        streamDetailFragment.O1(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMemberApi Q1() {
        return (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
    }

    private final void R1(boolean show) {
        String genre;
        Subject subject = this.mMovieDetailBean;
        if (subject == null || (genre = subject.getGenre()) == null) {
            return;
        }
        String lowerCase = genre.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (lowerCase == null || !StringsKt.c0(lowerCase, "game", false, 2, null)) {
            return;
        }
        if (show) {
            IMemberApi j12 = j1();
            if (j12 != null) {
                j12.i();
                return;
            }
            return;
        }
        IMemberApi j13 = j1();
        if (j13 != null) {
            j13.q();
        }
    }

    private final void S1() {
        fo.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onPageDestroy();
        }
        nh.m.f70597a.m(this.networkStatusChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(LongVodUiType uiType) {
        if (this.gameResView == null || uiType != LongVodUiType.MIDDLE) {
            return;
        }
        j2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(go.a bean) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_PLAY").K("subject_id", this.mSubjectId);
        Subject subject = this.mMovieDetailBean;
        if (subject != null && subject.getType() == 3 && bean != null) {
            K.I("TV_DATA", new FbTvData(bean.o(), bean.l(), bean.e()));
        }
        Navigator.x(K, requireContext(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V1(StreamDetailFragment streamDetailFragment, VideoDetailStreamList videoDetailStreamList) {
        lg.a.f68962a.c("videoDetail", "playInfoObserver  playInfo==" + videoDetailStreamList, true);
        streamDetailFragment.r1();
        if (videoDetailStreamList != null || nh.m.f70597a.e()) {
            streamDetailFragment.f1();
        } else {
            streamDetailFragment.k2();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x00e7, code lost:
    
        if ((r6 != null ? r6.getSe() : 0) <= 0) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void W1(com.transsion.videodetail.bean.VideoDetailStreamList r39) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.StreamDetailFragment.W1(com.transsion.videodetail.bean.VideoDetailStreamList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPublishApi X1() {
        return (IPublishApi) TheRouter.d(IPublishApi.class, new Object[0]);
    }

    private final boolean Y0() {
        IFissionProvider iFissionProvider;
        if (this.hasClickedActivityTip || (iFissionProvider = this.palmPayApi) == null) {
            return false;
        }
        return iFissionProvider.g();
    }

    private final void Z0() {
        BubbleTextView bubbleTextView;
        ViewTreeObserver viewTreeObserver;
        jx.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f66546b) == null || (viewTreeObserver = bubbleTextView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(long tsLayoutDone) {
        if (this.tsEnter == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        String str = this.mSubjectId;
        if (str == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        hashMap.put("t_view_created_start", String.valueOf(this.tsViewCreatedStart - this.tsEnter));
        hashMap.put("t_view_created_end", String.valueOf(this.tsViewCreatedEnd - this.tsEnter));
        hashMap.put("t_request", String.valueOf(this.tsRequestStart - this.tsEnter));
        hashMap.put("t_callback", String.valueOf(this.tsCallback - this.tsEnter));
        hashMap.put("t_init_start", String.valueOf(this.tsInitStart - this.tsEnter));
        hashMap.put("t_init_done", String.valueOf(this.tsInitDone - this.tsEnter));
        hashMap.put("t_add_view", String.valueOf(this.tsAddView - this.tsEnter));
        hashMap.put("t_layout_done", String.valueOf(tsLayoutDone - this.tsEnter));
        hj.i.f64628a.s("stream_detail", "app_perf", hashMap);
    }

    private final void a1() {
        ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) o1().z().f();
        if (resourcesSeasonList == null) {
            return;
        }
        boolean z10 = false;
        if (resourcesSeasonList.isSeries()) {
            a.C0856a.f(lg.a.f68962a, "videoDetail", "checkHasNext 是剧集，判断下一集还是完成 ", false, 4, null);
            List list = (List) o1().s().f();
            if (list == null) {
                list = CollectionsKt.l();
            }
            VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) o1().x().f();
            int indexOf = videoDetailMediaSource != null ? list.indexOf(videoDetailMediaSource) : -1;
            if (indexOf >= 0 && indexOf < list.size() - 1) {
                z10 = true;
            }
        }
        fo.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.hasNextEpisode(z10);
        }
    }

    private final void a2() {
        GradientTextView gradientTextView;
        AppCompatImageView appCompatImageView;
        final Subject subject = this.mMovieDetailBean;
        if (subject != null) {
            jx.i mViewBinding = getMViewBinding();
            if (mViewBinding != null && (appCompatImageView = mViewBinding.f66557m) != null) {
                appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StreamDetailFragment.b2(StreamDetailFragment.this, subject, view);
                    }
                });
            }
            jx.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (gradientTextView = mViewBinding2.f66565u) == null) {
                return;
            }
            gradientTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StreamDetailFragment.c2(StreamDetailFragment.this, subject, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1() {
        ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) o1().z().f();
        if (resourcesSeasonList == null) {
            return;
        }
        if (resourcesSeasonList.isNoSource()) {
            a.C0856a.f(lg.a.f68962a, "videoDetail", "checkPlayNextOrReplay 没有资源", false, 4, null);
            return;
        }
        if (!resourcesSeasonList.isSeries()) {
            if (resourcesSeasonList.isMovie()) {
                a.C0856a.f(lg.a.f68962a, "videoDetail", "checkPlayInfo 是电影", false, 4, null);
                fo.a aVar = this.playerControl;
                if (aVar != null) {
                    aVar.showReplay();
                    return;
                }
                return;
            }
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "videoDetail", "checkPlayNextOrReplay 是剧集，判断下一集还是完成 ", false, 4, null);
        List list = (List) o1().s().f();
        if (list == null) {
            return;
        }
        VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) o1().x().f();
        if (videoDetailMediaSource == null) {
            o1().C((VideoDetailMediaSource) CollectionsKt.k0(list));
            return;
        }
        int indexOf = list.indexOf(videoDetailMediaSource);
        if (indexOf >= list.size() - 1) {
            a.C0856a.f(c0856a, "videoDetail", "checkPlayInfo 是剧集完成播放", false, 4, null);
            fo.a aVar2 = this.playerControl;
            if (aVar2 != null) {
                aVar2.showReplay();
                return;
            }
            return;
        }
        a.C0856a.f(c0856a, "videoDetail", "checkPlayInfo 自动播放下一集，currentIndex：" + indexOf, false, 4, null);
        o1().C((VideoDetailMediaSource) CollectionsKt.l0(list, indexOf + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(StreamDetailFragment streamDetailFragment, Subject subject, View view) {
        String str;
        IPublishApi n12 = streamDetailFragment.n1();
        if (n12 != null) {
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            String str2 = streamDetailFragment.mSubjectId;
            if (str2 == null) {
                str2 = "";
            }
            Cover cover = subject.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = "";
            }
            String title = subject.getTitle();
            if (title == null) {
                title = "";
            }
            String description = subject.getDescription();
            if (description == null) {
                description = "";
            }
            n12.e(context, str2, str, title, description, 3);
        }
        com.transsion.baselib.helper.a.f43316a.h("subjectdetail", "post", (r16 & 4) != 0 ? "" : null, (r16 & 8) != 0 ? "" : null, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? null : null);
    }

    private final void c1() {
        String str;
        ResourceDetectors resourceDetector;
        if (getContext() == null) {
            return;
        }
        Subject subject = this.mMovieDetailBean;
        str = "";
        if (subject != null && (resourceDetector = subject.getResourceDetector()) != null) {
            String resourceLink = resourceDetector.getResourceLink();
            str = resourceLink != null ? resourceLink : "";
            resourceDetector.getResourceId();
            resourceDetector.isMultiResolution();
        }
        String str2 = str;
        Subject subject2 = this.mMovieDetailBean;
        String str3 = null;
        if (subject2 != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
                Context context = getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                String str4 = this.ops;
                if (str4 == null || str4.length() == 0) {
                    Subject subject3 = this.mMovieDetailBean;
                    if (subject3 != null) {
                        str3 = subject3.getOps();
                    }
                } else {
                    str3 = this.ops;
                }
                a11.d0(fragmentActivity, "subjectdetail", (r22 & 4) != 0 ? "" : "", str3, (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : true, (r22 & 64) != 0 ? null : this.mMovieDetailBean, (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) o1().x().f();
        int ep2 = (videoDetailMediaSource == null || videoDetailMediaSource.getSe() != this.curSeason) ? 0 : videoDetailMediaSource.getEp();
        DownloadManagerApi a12 = DownloadManagerApi.f58521j.a();
        Context context2 = getContext();
        Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity2 = (FragmentActivity) context2;
        Subject subject4 = this.mMovieDetailBean;
        String str5 = this.ops;
        if (str5 == null || str5.length() == 0) {
            Subject subject5 = this.mMovieDetailBean;
            if (subject5 != null) {
                str3 = subject5.getOps();
            }
        } else {
            str3 = this.ops;
        }
        DownloadManagerApi.N(a12, fragmentActivity2, subject4, "subjectdetail", "", str3, str2, String.valueOf(ep2), this.moduleName, null, true, this.curSeason, false, 256, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(StreamDetailFragment streamDetailFragment, Subject subject, View view) {
        String str;
        IPublishApi n12 = streamDetailFragment.n1();
        if (n12 != null) {
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            String str2 = streamDetailFragment.mSubjectId;
            if (str2 == null) {
                str2 = "";
            }
            Cover cover = subject.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = "";
            }
            String title = subject.getTitle();
            if (title == null) {
                title = "";
            }
            String description = subject.getDescription();
            if (description == null) {
                description = "";
            }
            n12.e(context, str2, str, title, description, 3);
        }
        com.transsion.baselib.helper.a.f43316a.h("subjectdetail", "post", (r16 & 4) != 0 ? "" : null, (r16 & 8) != 0 ? "" : null, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? null : null);
    }

    private final void d1() {
        BubbleTextView bubbleTextView;
        this.hasClickedActivityTip = true;
        jx.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f66546b) == null) {
            return;
        }
        jg.c.g(bubbleTextView);
    }

    private final void d2(Subject subject) {
        Cover stills;
        FrameLayout frameLayout;
        a.C0856a.l(lg.a.f68962a, "videoDetail", "展示作品大图或者预告片", false, 4, null);
        if (subject != null) {
            Trailer trailer = subject.getTrailer();
            if ((trailer == null || (stills = trailer.getCover()) == null) && (stills = subject.getStills()) == null) {
                stills = subject.getCover();
            }
            if (stills != null) {
                int f11 = com.transsion.core.utils.e.f();
                jx.i mViewBinding = getMViewBinding();
                if (mViewBinding == null || (frameLayout = mViewBinding.f66552h) == null) {
                    return;
                }
                if (frameLayout.getChildCount() == 0) {
                    ImageView imageView = new ImageView(frameLayout.getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    frameLayout.addView(imageView, new FrameLayout.LayoutParams(f11, (f11 * 9) / 16));
                    f.a aVar = ej.f.f62005a;
                    String url = stills.getUrl();
                    String e11 = f.a.e(aVar, url == null ? "" : url, f11, false, false, 12, null);
                    String thumbnail = stills.getThumbnail();
                    com.transsion.base.image.blurhash.e.d(com.transsion.base.image.blurhash.e.f43045a, thumbnail == null ? "" : thumbnail, 0, 0, new Function1() { // from class: com.transsion.videodetail.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit e22;
                            e22 = StreamDetailFragment.e2(StreamDetailFragment.this, (BitmapDrawable) obj);
                            return e22;
                        }
                    }, 6, null);
                    Context context = imageView.getContext();
                    Intrinsics.g(context, "getContext(...)");
                    aVar.m(context).g(e11).i(com.tn.lib.widget.R$color.transparent).d(imageView);
                }
            }
        }
    }

    private final void e1() {
        LinearLayout root;
        ViewParent parent;
        jx.j jVar = this.loadingViewBinding;
        if (jVar == null || (root = jVar.getRoot()) == null || (parent = root.getParent()) == null || !(parent instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) parent).removeView(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e2(StreamDetailFragment streamDetailFragment, BitmapDrawable drawable) {
        FrameLayout frameLayout;
        Intrinsics.h(drawable, "drawable");
        jx.i mViewBinding = streamDetailFragment.getMViewBinding();
        if (mViewBinding != null && (frameLayout = mViewBinding.f66552h) != null) {
            frameLayout.setBackground(drawable);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1() {
        fo.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.removeNoNetError();
        }
        this.showNetErr = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(VideoDetailMediaSource episodeMedia) {
        if (episodeMedia == null) {
            return;
        }
        VideoDetailStreamList videoDetailStreamList = (VideoDetailStreamList) o1().w().f();
        if (videoDetailStreamList != null && videoDetailStreamList.getSe() == episodeMedia.getSe() && videoDetailStreamList.getEp() == episodeMedia.getEp()) {
            return;
        }
        fo.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.reset();
        }
        showLoading();
        o1().v(episodeMedia);
        a1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g2(final FloatActionType actionType) {
        final FragmentActivity activity;
        ConstraintLayout root;
        Integer subjectType;
        Subject subject = this.mMovieDetailBean;
        if (((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) != SubjectType.MUSIC.getValue() && (activity = getActivity()) != null && !activity.isDestroyed() && !activity.isFinishing()) {
            FloatActionType floatActionType = FloatActionType.ICON;
            if (actionType != floatActionType && !com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("k_pip_enable", true)) {
                lg.a.f68962a.c("VideoFloat", "设置页pip开关被关闭了", true);
                return false;
            }
            final px.a h12 = h1();
            if (h12 != null) {
                if (actionType != floatActionType && !h12.f().isPlaying()) {
                    lg.a.f68962a.c("VideoFloat-pip", "stream 视频暂停，无需触发画中画", true);
                    return false;
                }
                e.a aVar = ox.e.f72320a;
                if (aVar.b().c()) {
                    fo.a aVar2 = this.playerControl;
                    if (aVar2 != null) {
                        aVar2.hideBottomController(true);
                    }
                    lg.a.f68962a.c("VideoFloat-pip", "stream 当前可用画中画，使用画中画播放", true);
                    if (Build.VERSION.SDK_INT < 31 || actionType != FloatActionType.HOME) {
                        aVar.b().k(activity, h12, actionType, this.curPlayerUiType == LongVodUiType.LAND);
                    } else {
                        jx.i mViewBinding = getMViewBinding();
                        if (mViewBinding != null && (root = mViewBinding.getRoot()) != null) {
                            root.postDelayed(new Runnable() { // from class: com.transsion.videodetail.d
                                @Override // java.lang.Runnable
                                public final void run() {
                                    StreamDetailFragment.h2(FragmentActivity.this, h12, actionType, this);
                                }
                            }, 1000L);
                        }
                    }
                    return true;
                }
                ox.b.f72314a.c().g(activity, h12, actionType == floatActionType, this.curPlayerUiType == LongVodUiType.LAND, new Function1() { // from class: com.transsion.videodetail.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit i22;
                        i22 = StreamDetailFragment.i2(StreamDetailFragment.this, activity, ((Boolean) obj).booleanValue());
                        return i22;
                    }
                }, new f());
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x01f1, code lost:
    
        if (r2 == null) goto L107;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final px.a h1() {
        /*
            Method dump skipped, instructions count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.StreamDetailFragment.h1():px.a");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(FragmentActivity fragmentActivity, px.a aVar, FloatActionType floatActionType, StreamDetailFragment streamDetailFragment) {
        ox.e.f72320a.b().k(fragmentActivity, aVar, floatActionType, streamDetailFragment.curPlayerUiType == LongVodUiType.LAND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(StreamDetailFragment streamDetailFragment, View view) {
        streamDetailFragment.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i2(StreamDetailFragment streamDetailFragment, FragmentActivity fragmentActivity, boolean z10) {
        fo.a aVar;
        if (z10 && (aVar = streamDetailFragment.playerControl) != null) {
            aVar.exitFullScreen();
        }
        fo.a aVar2 = streamDetailFragment.playerControl;
        if (aVar2 != null) {
            aVar2.setFloatIsShow(z10);
        }
        if (z10) {
            fragmentActivity.finish();
        }
        return Unit.f67184a;
    }

    private final IMemberApi j1() {
        return (IMemberApi) this.memberProvider.getValue();
    }

    private final void j2() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        View view = this.gameResView;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.gameResView);
        }
        KeyEvent.Callback callback = this.gameResView;
        ok.a aVar = callback instanceof ok.a ? (ok.a) callback : null;
        if (aVar != null) {
            aVar.setPageStyle("detail");
        }
        jx.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout3 = mViewBinding.f66555k) != null) {
            jg.c.k(frameLayout3);
        }
        jx.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (frameLayout2 = mViewBinding2.f66555k) != null) {
            frameLayout2.removeAllViews();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        jx.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (frameLayout = mViewBinding3.f66555k) == null) {
            return;
        }
        frameLayout.addView(this.gameResView, layoutParams);
    }

    private final PlayMimeType k1(VideoDetailStream stream) {
        String str;
        String format;
        if (stream == null || (format = stream.getFormat()) == null) {
            str = null;
        } else {
            str = format.toUpperCase(Locale.ROOT);
            Intrinsics.g(str, "toUpperCase(...)");
        }
        return Intrinsics.c(str, "DASH") ? PlayMimeType.DASH : Intrinsics.c(str, "HLS") ? PlayMimeType.HLS : PlayMimeType.DEFAULT;
    }

    private final void k2() {
        fo.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.showNoNetError();
        }
        this.showNetErr = true;
    }

    private final MovieDetailViewModel l1() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    private final void l2() {
        Context context;
        List<DubsInfo> l11;
        Integer subjectType;
        if (this.playerControl == null && (context = getContext()) != null) {
            Subject subject = this.mMovieDetailBean;
            LongVodPageType longVodPageType = ((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) == SubjectType.MUSIC.getValue() ? LongVodPageType.MUSIC : LongVodPageType.STREAM;
            jx.i mViewBinding = getMViewBinding();
            if (mViewBinding != null) {
                this.tsInitStart = SystemClock.elapsedRealtime();
                LongVodPlayerView longVodPlayerView = new LongVodPlayerView(context);
                String name = longVodPageType.name();
                Subject subject2 = this.mMovieDetailBean;
                String str = name + (subject2 != null ? subject2.getSubjectId() : null);
                FrameLayout frameLayout = mViewBinding.f66551g;
                LinearLayoutCompat linearLayoutCompat = mViewBinding.f66558n.f64722f;
                Subject subject3 = this.mMovieDetailBean;
                if (subject3 == null || (l11 = subject3.getDubs()) == null) {
                    l11 = CollectionsKt.l();
                }
                a.C0784a.a(longVodPlayerView, "stream_detail", longVodPageType, str, frameLayout, linearLayoutCompat, l11, null, 64, null);
                Subject subject4 = this.mMovieDetailBean;
                longVodPlayerView.initAdHelper(subject4 != null ? subject4.getGenre() : null);
                jx.i mViewBinding2 = getMViewBinding();
                longVodPlayerView.setPortraitPremiumView(mViewBinding2 != null ? mViewBinding2.f66553i : null);
                longVodPlayerView.setFeedBackVisible(true);
                longVodPlayerView.setAudioSelectCallback(new Function1() { // from class: com.transsion.videodetail.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit m22;
                        m22 = StreamDetailFragment.m2(StreamDetailFragment.this, (DubsInfo) obj);
                        return m22;
                    }
                });
                this.tsInitDone = SystemClock.elapsedRealtime();
                this.tsAddView = SystemClock.elapsedRealtime();
                mViewBinding.f66552h.addView(longVodPlayerView);
                this.playerControl = longVodPlayerView;
                longVodPlayerView.getViewTreeObserver().addOnGlobalLayoutListener(new g(longVodPlayerView, this));
            }
            Subject subject5 = this.mMovieDetailBean;
            if (subject5 != null) {
                C1(subject5);
            }
            fo.a aVar = this.playerControl;
            if (aVar != null) {
                aVar.setCallback(new h());
            }
        }
    }

    private final VideoDetailMediaSource m1(VideoDetailPlayBean history, List episodeMediaList) {
        Object obj = null;
        if (history == null) {
            a.C0856a.f(lg.a.f68962a, "videoDetail", "getPlayingItem 无历史记录，se:" + this.targetSeason, false, 4, null);
            if (this.targetSeason <= 0) {
                return (VideoDetailMediaSource) CollectionsKt.k0(episodeMediaList);
            }
            Iterator it = episodeMediaList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) next;
                if (videoDetailMediaSource.getSe() == this.targetSeason && videoDetailMediaSource.getEp() == 1) {
                    obj = next;
                    break;
                }
            }
            VideoDetailMediaSource videoDetailMediaSource2 = (VideoDetailMediaSource) obj;
            return videoDetailMediaSource2 == null ? (VideoDetailMediaSource) CollectionsKt.k0(episodeMediaList) : videoDetailMediaSource2;
        }
        int se2 = history.getSe();
        int i11 = this.targetSeason;
        if (se2 == i11 || i11 <= 0 || history.getSe() <= 0) {
            this.curSeason = history.getSe();
            a.C0856a.f(lg.a.f68962a, "videoDetail", "getPlayingItem 有历史记录，不指定季使用历史记录，se:" + history.getSe() + ", ep:" + history.getEp(), false, 4, null);
            Iterator it2 = episodeMediaList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                VideoDetailMediaSource videoDetailMediaSource3 = (VideoDetailMediaSource) next2;
                if (videoDetailMediaSource3.getSe() == history.getSe() && videoDetailMediaSource3.getEp() == history.getEp()) {
                    obj = next2;
                    break;
                }
            }
            VideoDetailMediaSource videoDetailMediaSource4 = (VideoDetailMediaSource) obj;
            return videoDetailMediaSource4 == null ? (VideoDetailMediaSource) CollectionsKt.k0(episodeMediaList) : videoDetailMediaSource4;
        }
        a.C0856a.f(lg.a.f68962a, "videoDetail", "getPlayingItem 有历史记录，指定季，history se:" + history.getSe() + ", ep:" + history.getEp() + "， target se:" + this.targetSeason + ", targetEp:" + this.targetEp, false, 4, null);
        Iterator it3 = episodeMediaList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next3 = it3.next();
            VideoDetailMediaSource videoDetailMediaSource5 = (VideoDetailMediaSource) next3;
            if (videoDetailMediaSource5.getSe() == this.targetSeason) {
                int ep2 = videoDetailMediaSource5.getEp();
                int i12 = this.targetEp;
                if (i12 <= 0) {
                    i12 = 1;
                }
                if (ep2 == i12) {
                    obj = next3;
                    break;
                }
            }
        }
        VideoDetailMediaSource videoDetailMediaSource6 = (VideoDetailMediaSource) obj;
        return videoDetailMediaSource6 == null ? (VideoDetailMediaSource) CollectionsKt.k0(episodeMediaList) : videoDetailMediaSource6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m2(StreamDetailFragment streamDetailFragment, DubsInfo info) {
        Integer num;
        List<DubsInfo> dubs;
        Intrinsics.h(info, "info");
        a.C0856a.g(lg.a.f68962a, "AudioSelectCallback " + info, false, 2, null);
        Subject subject = streamDetailFragment.mMovieDetailBean;
        if (subject == null || (dubs = subject.getDubs()) == null) {
            num = null;
        } else {
            Iterator<DubsInfo> it = dubs.iterator();
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                }
                if (Intrinsics.c(it.next().getLanCode(), info.getLanCode())) {
                    break;
                }
                i11++;
            }
            num = Integer.valueOf(i11);
        }
        if ((num != null && num.intValue() == -1) || info.getSubjectId() == null) {
            a.C0856a.g(lg.a.f68962a, "AudioSelectCallback info can't find in dubs", false, 2, null);
        } else {
            streamDetailFragment.l1().P().q(info);
        }
        return Unit.f67184a;
    }

    private final IPublishApi n1() {
        return (IPublishApi) this.publishedApi.getValue();
    }

    private final void n2() {
        new tn.g(this, R$id.subjectDetailLayout, this.mMovieDetailBean, "stream_detail", this.moduleName, false, false, 96, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailViewModel o1() {
        return (VideoDetailViewModel) this.videoDetailViewModel.getValue();
    }

    private final void o2(Subject data) {
        MemberGuideBannerView memberGuideBannerView;
        final MemberGuideBannerView memberGuideBannerView2;
        String str;
        Lottery lottery;
        Lottery lottery2;
        MemberGuideBannerView memberGuideBannerView3;
        if (TextUtils.equals(this.curSubjectId, data.getSubjectId())) {
            return;
        }
        String subjectId = data.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        this.curSubjectId = subjectId;
        this.traceId = ti.n.f76387a.b();
        if (!com.transsion.player.longvideo.intercept.h0.f48193a.d(data)) {
            jx.i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (memberGuideBannerView = mViewBinding.f66554j) == null) {
                return;
            }
            memberGuideBannerView.setVisibility(8);
            return;
        }
        jx.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (memberGuideBannerView3 = mViewBinding2.f66554j) != null) {
            memberGuideBannerView3.setVisibility(0);
        }
        jx.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (memberGuideBannerView2 = mViewBinding3.f66554j) == null) {
            return;
        }
        memberGuideBannerView2.setRefreshMemberInfo(new Function0() { // from class: com.transsion.videodetail.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit p22;
                p22 = StreamDetailFragment.p2(StreamDetailFragment.this, memberGuideBannerView2);
                return p22;
            }
        });
        Subject subject = this.mMovieDetailBean;
        String subjectId2 = subject != null ? subject.getSubjectId() : null;
        String str2 = this.traceId;
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        Boolean valueOf = iPremiumApi != null ? Boolean.valueOf(iPremiumApi.c()) : null;
        IPremiumApi iPremiumApi2 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        Integer o11 = iPremiumApi2 != null ? iPremiumApi2.o() : null;
        IPremiumApi iPremiumApi3 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        MemberGuideBannerView.setMemberInfo$default(memberGuideBannerView2, "stream_detail", "video_detail/vip_banner", str2, subjectId2, false, valueOf, o11, iPremiumApi3 != null ? Boolean.valueOf(iPremiumApi3.u()) : null, 16, null);
        memberGuideBannerView2.setRadius(0.0f);
        IRewardsCenterApi iRewardsCenterApi = (IRewardsCenterApi) TheRouter.d(IRewardsCenterApi.class, new Object[0]);
        RewardsCenterData a11 = iRewardsCenterApi != null ? iRewardsCenterApi.a() : null;
        if (a11 == null || (lottery2 = a11.getLottery()) == null || (str = lottery2.getActivityId()) == null) {
            str = "0";
        }
        boolean z10 = Integer.parseInt(str) > 0;
        String bgImage = (a11 == null || (lottery = a11.getLottery()) == null) ? null : lottery.getBgImage();
        MemberGuideBannerView.setZeroTreasureVisible$default(memberGuideBannerView2, z10, false, 2, null);
        if (z10) {
            memberGuideBannerView2.setZeroTreasureIcon(bgImage != null ? bgImage : "");
        }
        memberGuideBannerView2.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StreamDetailFragment.q2(StreamDetailFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p2(StreamDetailFragment streamDetailFragment, MemberGuideBannerView memberGuideBannerView) {
        Subject subject = streamDetailFragment.mMovieDetailBean;
        String subjectId = subject != null ? subject.getSubjectId() : null;
        String str = streamDetailFragment.traceId;
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        Boolean valueOf = iPremiumApi != null ? Boolean.valueOf(iPremiumApi.c()) : null;
        IPremiumApi iPremiumApi2 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        Integer o11 = iPremiumApi2 != null ? iPremiumApi2.o() : null;
        IPremiumApi iPremiumApi3 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        memberGuideBannerView.setMemberInfo("stream_detail", "video_detail/vip_banner", str, subjectId, true, valueOf, o11, iPremiumApi3 != null ? Boolean.valueOf(iPremiumApi3.u()) : null);
        return Unit.f67184a;
    }

    private final List q1(List videoDetailStream) {
        ArrayList arrayList = new ArrayList();
        if (videoDetailStream != null) {
            Iterator it = videoDetailStream.iterator();
            while (it.hasNext()) {
                VideoDetailStream videoDetailStream2 = (VideoDetailStream) it.next();
                arrayList.add(new go.c(k1(videoDetailStream2), videoDetailStream2.getId(), videoDetailStream2.getUrl(), videoDetailStream2.getResolutions(), videoDetailStream2.getSize(), videoDetailStream2.getDuration(), videoDetailStream2.getSignCookie(), null, 128, null));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(StreamDetailFragment streamDetailFragment, View view) {
        PlaybackInterceptionManager playbackInterceptionManager;
        fo.a aVar = streamDetailFragment.playerControl;
        if (aVar == null || (playbackInterceptionManager = aVar.getPlaybackInterceptionManager()) == null) {
            return;
        }
        PlaybackInterceptionManager.X(playbackInterceptionManager, true, "video_detail/vip_banner", streamDetailFragment.traceId, false, 8, null);
    }

    private final void r1() {
        if (this.mMovieDetailBean == null) {
            a.C0856a.f(lg.a.f68962a, "videoDetail", "PlayInfoLive  mMovieDetailBean==null", false, 4, null);
            return;
        }
        VideoDetailStreamList videoDetailStreamList = (VideoDetailStreamList) o1().w().f();
        if (videoDetailStreamList == null) {
            a.C0856a.f(lg.a.f68962a, "videoDetail", "PlayInfoLive playInfo==null", false, 4, null);
            return;
        }
        VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) o1().x().f();
        if (videoDetailMediaSource == null) {
            a.C0856a.f(lg.a.f68962a, "videoDetail", "PlayInfoLive media==null", false, 4, null);
            return;
        }
        if (Intrinsics.c(videoDetailStreamList, this.videoDetailStreamList)) {
            a.C0856a.f(lg.a.f68962a, "videoDetail", "PlayInfoLive data:" + videoDetailStreamList + "  media:" + videoDetailMediaSource + "  重复播放数据，不处理", false, 4, null);
            return;
        }
        if (videoDetailMediaSource.getEp() == videoDetailStreamList.getEp() && videoDetailMediaSource.getSe() == videoDetailStreamList.getSe()) {
            this.videoDetailStreamList = videoDetailStreamList;
            e1();
            W1(videoDetailStreamList);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "videoDetail", "PlayInfoLive data:" + videoDetailStreamList + "  media:" + videoDetailMediaSource + "  不相同，不播放", false, 4, null);
    }

    private final void r2() {
        BubbleTextView bubbleTextView;
        jx.i mViewBinding;
        DownloadView downloadView;
        jx.i mViewBinding2;
        DownloadView downloadView2;
        BubbleTextView bubbleTextView2;
        if (!Y0() || (mViewBinding = getMViewBinding()) == null || (downloadView = mViewBinding.f66548d) == null || downloadView.getVisibility() != 0 || (mViewBinding2 = getMViewBinding()) == null || (downloadView2 = mViewBinding2.f66548d) == null || downloadView2.getType() != 0) {
            jx.i mViewBinding3 = getMViewBinding();
            if (mViewBinding3 == null || (bubbleTextView = mViewBinding3.f66546b) == null) {
                return;
            }
            jg.c.g(bubbleTextView);
            return;
        }
        jx.i mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (bubbleTextView2 = mViewBinding4.f66546b) != null) {
            jg.c.k(bubbleTextView2);
        }
        Z0();
    }

    private final void s1() {
        BubbleTextView bubbleTextView;
        BubbleTextView bubbleTextView2;
        BubbleTextView bubbleTextView3;
        jx.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (bubbleTextView3 = mViewBinding.f66546b) != null) {
            bubbleTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StreamDetailFragment.t1(StreamDetailFragment.this, view);
                }
            });
        }
        jx.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (bubbleTextView2 = mViewBinding2.f66546b) != null) {
            jg.c.k(bubbleTextView2);
        }
        Z0();
        jx.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (bubbleTextView = mViewBinding3.f66546b) == null) {
            return;
        }
        jg.c.g(bubbleTextView);
    }

    private final void s2(int visible) {
        HashMap g11;
        ResourceDetectors resourceDetector;
        DownloadView downloadView;
        jx.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (downloadView = mViewBinding.f66548d) != null) {
            downloadView.setVisibility(visible);
        }
        Subject subject = this.mMovieDetailBean;
        if (subject != null && (resourceDetector = subject.getResourceDetector()) != null) {
            resourceDetector.getResourceId();
            resourceDetector.isMultiResolution();
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
        }
        r2();
    }

    private final void showLoading() {
        LinearLayout root;
        jx.i mViewBinding;
        FrameLayout frameLayout;
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (this.loadingViewBinding == null) {
            LayoutInflater from = LayoutInflater.from(context);
            jx.i mViewBinding2 = getMViewBinding();
            this.loadingViewBinding = jx.j.c(from, mViewBinding2 != null ? mViewBinding2.f66552h : null, false);
        }
        jx.j jVar = this.loadingViewBinding;
        if (jVar == null || (root = jVar.getRoot()) == null) {
            return;
        }
        if (root.getParent() == null && (mViewBinding = getMViewBinding()) != null && (frameLayout = mViewBinding.f66552h) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.bottomMargin = com.blankj.utilcode.util.i.e(20.0f);
            Unit unit = Unit.f67184a;
            frameLayout.addView(root, layoutParams);
        }
        jg.c.k(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(StreamDetailFragment streamDetailFragment, View view) {
        a.C0856a.f(lg.a.f68962a, "videoDetail", "Click activity tip", false, 4, null);
        streamDetailFragment.hasClickedActivityTip = true;
        Intrinsics.e(view);
        jg.c.g(view);
    }

    static /* synthetic */ void t2(StreamDetailFragment streamDetailFragment, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        streamDetailFragment.s2(i11);
    }

    private final void u1() {
        Subject subject = this.mMovieDetailBean;
        jx.i mViewBinding = getMViewBinding();
        MagicIndicator magicIndicator = mViewBinding != null ? mViewBinding.f66559o : null;
        jx.i mViewBinding2 = getMViewBinding();
        this.bottomRecHelper = new tn.e(this, subject, magicIndicator, mViewBinding2 != null ? mViewBinding2.f66561q : null, "stream_detail", false, false, new Function1() { // from class: com.transsion.videodetail.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v12;
                v12 = StreamDetailFragment.v1(StreamDetailFragment.this, ((Integer) obj).intValue());
                return v12;
            }
        }, 96, null);
    }

    private final void u2() {
        Subject subject;
        ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) o1().z().f();
        if (resourcesSeasonList == null || (subject = this.mMovieDetailBean) == null) {
            return;
        }
        if (subject != null && subject.isFamilyModeIntercept()) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            androidx.fragment.app.w p11 = childFragmentManager.p();
            Intrinsics.g(p11, "beginTransaction()");
            ResourceDetectorFamilyModeFragment resourceDetectorFamilyModeFragment = new ResourceDetectorFamilyModeFragment();
            resourceDetectorFamilyModeFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("data_key_resource_detectors", this.mMovieDetailBean)));
            p11.s(R$id.resourceDetectorGroup, resourceDetectorFamilyModeFragment);
            p11.j();
            s2(8);
            return;
        }
        this.hasResource = !resourcesSeasonList.isNoSource();
        if (resourcesSeasonList.isNoSource()) {
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.g(childFragmentManager2, "getChildFragmentManager(...)");
            androidx.fragment.app.w p12 = childFragmentManager2.p();
            Intrinsics.g(p12, "beginTransaction()");
            ResourceDetectorEmptyFragment resourceDetectorEmptyFragment = new ResourceDetectorEmptyFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.mMovieDetailBean);
            resourceDetectorEmptyFragment.setArguments(bundle);
            p12.s(R$id.resourceDetectorGroup, resourceDetectorEmptyFragment);
            p12.j();
            s2(8);
        } else {
            FragmentManager childFragmentManager3 = getChildFragmentManager();
            Intrinsics.g(childFragmentManager3, "getChildFragmentManager(...)");
            androidx.fragment.app.w p13 = childFragmentManager3.p();
            Intrinsics.g(p13, "beginTransaction()");
            VideoEpisodeFragment videoEpisodeFragment = new VideoEpisodeFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("data_key_resource_detectors", this.mMovieDetailBean);
            bundle2.putString("ops", this.ops);
            bundle2.putBoolean("auto_play", this.autoPlay);
            bundle2.putString("auto_play_resource_id", this.autoPlayResourceId);
            bundle2.putString("module_name", this.moduleName);
            bundle2.putInt("season", this.curSeason);
            videoEpisodeFragment.setArguments(bundle2);
            p13.s(R$id.resourceDetectorGroup, videoEpisodeFragment);
            videoEpisodeFragment.P0(new Function1() { // from class: com.transsion.videodetail.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit v22;
                    v22 = StreamDetailFragment.v2(StreamDetailFragment.this, (DubsInfo) obj);
                    return v22;
                }
            });
            p13.j();
            t2(this, 0, 1, null);
        }
        if (!resourcesSeasonList.isNoSource()) {
            l2();
            return;
        }
        d2(this.mMovieDetailBean);
        FragmentActivity activity = getActivity();
        BaseMusicFloatActivity baseMusicFloatActivity = activity instanceof BaseMusicFloatActivity ? (BaseMusicFloatActivity) activity : null;
        if (baseMusicFloatActivity != null) {
            baseMusicFloatActivity.showMusicFloating();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(StreamDetailFragment streamDetailFragment, int i11) {
        DownloadView downloadView;
        GradientTextView gradientTextView;
        Subject subject;
        DownloadView downloadView2;
        if (!streamDetailFragment.hasResource || ((subject = streamDetailFragment.mMovieDetailBean) != null && subject.isFamilyModeIntercept())) {
            jx.i mViewBinding = streamDetailFragment.getMViewBinding();
            if (mViewBinding != null && (downloadView = mViewBinding.f66548d) != null) {
                jg.c.g(downloadView);
            }
        } else {
            jx.i mViewBinding2 = streamDetailFragment.getMViewBinding();
            if (mViewBinding2 != null && (downloadView2 = mViewBinding2.f66548d) != null) {
                downloadView2.setVisibility(i11 != 1 ? 0 : 8);
            }
        }
        jx.i mViewBinding3 = streamDetailFragment.getMViewBinding();
        if (mViewBinding3 != null && (gradientTextView = mViewBinding3.f66565u) != null) {
            gradientTextView.setVisibility(i11 == 1 ? 0 : 8);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v2(StreamDetailFragment streamDetailFragment, DubsInfo info) {
        Integer num;
        List<DubsInfo> dubs;
        Intrinsics.h(info, "info");
        a.C0856a.g(lg.a.f68962a, "AudioSelectCallback " + info, false, 2, null);
        Subject subject = streamDetailFragment.mMovieDetailBean;
        if (subject == null || (dubs = subject.getDubs()) == null) {
            num = null;
        } else {
            Iterator<DubsInfo> it = dubs.iterator();
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                }
                if (Intrinsics.c(it.next().getLanCode(), info.getLanCode())) {
                    break;
                }
                i11++;
            }
            num = Integer.valueOf(i11);
        }
        if ((num != null && num.intValue() == -1) || info.getSubjectId() == null) {
            a.C0856a.g(lg.a.f68962a, "AudioSelectCallback info can't find in dubs", false, 2, null);
        } else {
            streamDetailFragment.l1().P().q(info);
        }
        return Unit.f67184a;
    }

    private final void w1() {
        DownloadView downloadView;
        DownloadView downloadView2;
        jx.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (downloadView2 = mViewBinding.f66548d) != null) {
            DownloadView.setAttrs$default(downloadView2, null, Float.valueOf(com.transsion.core.utils.e.g(16.0f)), null, 5, null);
        }
        jx.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (downloadView = mViewBinding2.f66548d) == null) {
            return;
        }
        downloadView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StreamDetailFragment.x1(StreamDetailFragment.this, view);
            }
        });
    }

    private final void w2(Subject movieDetailBean) {
        Subject subject;
        View view;
        View view2;
        FrameLayout frameLayout;
        this.mMovieDetailBean = movieDetailBean;
        N1(movieDetailBean != null ? movieDetailBean.getGenre() : null);
        if (!this.isGameResInit) {
            y1();
            R1(true);
        }
        Subject subject2 = this.mMovieDetailBean;
        String ops = subject2 != null ? subject2.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject = this.mMovieDetailBean) != null) {
            subject.setOps(this.ops);
        }
        ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) o1().z().f();
        Subject subject3 = this.mMovieDetailBean;
        if (subject3 != null && subject3.isFamilyModeIntercept()) {
            jx.i mViewBinding = getMViewBinding();
            if (mViewBinding != null && (frameLayout = mViewBinding.f66552h) != null) {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                ((ViewGroup.MarginLayoutParams) bVar).height = dk.a.b(48);
                frameLayout.setLayoutParams(bVar);
            }
            jx.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (view2 = mViewBinding2.f66566v) != null) {
                jg.c.g(view2);
            }
            jx.i mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (view = mViewBinding3.f66567w) != null) {
                view.setBackgroundResource(com.tn.lib.widget.R$color.bg_01);
            }
        } else if (resourcesSeasonList != null && resourcesSeasonList.isNoSource()) {
            d2(this.mMovieDetailBean);
        }
        u1();
        a2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(StreamDetailFragment streamDetailFragment, View view) {
        ResourceDetectors resourceDetector;
        List<DownloadItem> resolutionList;
        Subject subject;
        ResourceDetectors resourceDetector2;
        ResourceDetectors resourceDetector3;
        List<DownloadItem> resolutionList2;
        Subject subject2 = streamDetailFragment.mMovieDetailBean;
        if (subject2 != null && (resourceDetector = subject2.getResourceDetector()) != null && (resolutionList = resourceDetector.getResolutionList()) != null && (!resolutionList.isEmpty())) {
            Subject subject3 = streamDetailFragment.mMovieDetailBean;
            Integer valueOf = (subject3 == null || (resourceDetector3 = subject3.getResourceDetector()) == null || (resolutionList2 = resourceDetector3.getResolutionList()) == null) ? null : Integer.valueOf(resolutionList2.size());
            Intrinsics.e(valueOf);
            if (valueOf.intValue() > 1 && (subject = streamDetailFragment.mMovieDetailBean) != null && (resourceDetector2 = subject.getResourceDetector()) != null) {
                resourceDetector2.setType(1);
            }
        }
        streamDetailFragment.c1();
        streamDetailFragment.d1();
    }

    private final void y1() {
        String genre;
        IGameResApi iGameResApi;
        SubjectGameInfo gameInfo;
        SubjectGameInfo gameInfo2;
        SubjectGameInfo gameInfo3;
        SubjectGameInfo gameInfo4;
        this.isGameResInit = true;
        Subject subject = this.mMovieDetailBean;
        String str = null;
        String type = (subject == null || (gameInfo4 = subject.getGameInfo()) == null) ? null : gameInfo4.getType();
        if (type != null && type.length() != 0) {
            Subject subject2 = this.mMovieDetailBean;
            String itemId = (subject2 == null || (gameInfo3 = subject2.getGameInfo()) == null) ? null : gameInfo3.getItemId();
            if (itemId != null && itemId.length() != 0) {
                a.C0856a.f(lg.a.f68962a, "GameResLoader", "stream detail game initGameRes", false, 4, null);
                Context context = getContext();
                if (context == null || (iGameResApi = (IGameResApi) TheRouter.d(IGameResApi.class, new Object[0])) == null) {
                    return;
                }
                Subject subject3 = this.mMovieDetailBean;
                GameInfoType gameInfoType = (subject3 == null || (gameInfo2 = subject3.getGameInfo()) == null) ? null : gameInfo2.getGameInfoType();
                Intrinsics.e(gameInfoType);
                Subject subject4 = this.mMovieDetailBean;
                if (subject4 != null && (gameInfo = subject4.getGameInfo()) != null) {
                    str = gameInfo.getItemId();
                }
                String str2 = str;
                Intrinsics.e(str2);
                iGameResApi.a(context, "stream_detail", gameInfoType, str2, new Function1() { // from class: com.transsion.videodetail.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit z12;
                        z12 = StreamDetailFragment.z1(StreamDetailFragment.this, (View) obj);
                        return z12;
                    }
                });
                return;
            }
        }
        Subject subject5 = this.mMovieDetailBean;
        if (subject5 == null || (genre = subject5.getGenre()) == null) {
            return;
        }
        String lowerCase = genre.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (lowerCase == null || !StringsKt.c0(lowerCase, "game", false, 2, null)) {
            return;
        }
        a.C0856a.l(lg.a.f68962a, "GameResLoader", "stream detail,  game is null", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(StreamDetailFragment streamDetailFragment, View view) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        streamDetailFragment.gameResView = view;
        if (view == null) {
            jx.i mViewBinding = streamDetailFragment.getMViewBinding();
            if (mViewBinding != null && (frameLayout2 = mViewBinding.f66555k) != null) {
                jg.c.g(frameLayout2);
            }
            jx.i mViewBinding2 = streamDetailFragment.getMViewBinding();
            if (mViewBinding2 != null && (frameLayout = mViewBinding2.f66555k) != null) {
                frameLayout.removeAllViews();
            }
        } else {
            streamDetailFragment.j2();
        }
        return Unit.f67184a;
    }

    @Override // yn.a
    public void R(Function0 callback) {
        this.backPressedCallback = callback;
    }

    public final void Y1() {
        fo.a aVar;
        ox.c cVar = ox.c.f72319a;
        fo.a aVar2 = this.playerControl;
        if (cVar.c(aVar2 != null ? aVar2.getPlayer() : null) || (aVar = this.playerControl) == null) {
            return;
        }
        aVar.release();
    }

    public final void f2(Subject data) {
        DownloadView downloadView;
        DownloadView downloadView2;
        DownloadView downloadView3;
        DownloadView downloadView4;
        DownloadView downloadView5;
        DownloadView downloadView6;
        Integer requireMemberType;
        DownloadView downloadView7;
        DownloadView downloadView8;
        DownloadView downloadView9;
        Intrinsics.h(data, "data");
        if (!com.transsion.player.longvideo.intercept.h0.f48193a.d(data)) {
            jx.i mViewBinding = getMViewBinding();
            if (mViewBinding != null && (downloadView3 = mViewBinding.f66548d) != null) {
                downloadView3.setBackgroundResource(com.transsion.baseui.R$drawable.bg_btn_radius_20);
            }
            jx.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (downloadView2 = mViewBinding2.f66548d) != null) {
                downloadView2.setDownloadIconSrc(com.transsion.baseui.R$drawable.ic_download_btn_left_dark);
            }
            jx.i mViewBinding3 = getMViewBinding();
            if (mViewBinding3 == null || (downloadView = mViewBinding3.f66548d) == null) {
                return;
            }
            downloadView.setIcTintColor(Integer.valueOf(com.tn.lib.widget.R$color.gray_dark_00));
            return;
        }
        VipInfo vipInfo = data.getVipInfo();
        if (vipInfo == null || (requireMemberType = vipInfo.getRequireMemberType()) == null || requireMemberType.intValue() != 1) {
            jx.i mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (downloadView6 = mViewBinding4.f66548d) != null) {
                downloadView6.setBackgroundResource(com.transsion.baseui.R$drawable.bg_btn_radius_20);
            }
            jx.i mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (downloadView5 = mViewBinding5.f66548d) != null) {
                downloadView5.setDownloadIconSrc(com.transsion.baseui.R$drawable.ic_download_btn_left_dark);
            }
            jx.i mViewBinding6 = getMViewBinding();
            if (mViewBinding6 == null || (downloadView4 = mViewBinding6.f66548d) == null) {
                return;
            }
            downloadView4.setIcTintColor(Integer.valueOf(com.tn.lib.widget.R$color.gray_dark_00));
            return;
        }
        jx.i mViewBinding7 = getMViewBinding();
        if (mViewBinding7 != null && (downloadView9 = mViewBinding7.f66548d) != null) {
            downloadView9.setBackgroundResource(com.transsion.baseui.R$drawable.bg_btn_radius_20_2);
        }
        jx.i mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null && (downloadView8 = mViewBinding8.f66548d) != null) {
            downloadView8.setDownloadIconSrc(com.transsion.baseui.R$mipmap.p_v2_premium);
        }
        jx.i mViewBinding9 = getMViewBinding();
        if (mViewBinding9 == null || (downloadView7 = mViewBinding9.f66548d) == null) {
            return;
        }
        downloadView7.setIcTintColor(null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View getLoadingView() {
        View inflate = LayoutInflater.from(requireContext()).inflate(R$layout.default_movie_detail_skeleton_drawing_layout, (ViewGroup) getFlStateView(), false);
        ((AppCompatImageView) inflate.findViewById(R$id.ivBack)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StreamDetailFragment.i1(StreamDetailFragment.this, view);
            }
        });
        return inflate;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        jx.i mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f66556l.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StreamDetailFragment.A1(StreamDetailFragment.this, view);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        View view;
        this.tsViewCreatedStart = SystemClock.elapsedRealtime();
        jx.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (view = mViewBinding.f66567w) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = com.blankj.utilcode.util.d.c();
            view.setLayoutParams(bVar);
        }
        requireActivity().getOnBackPressedDispatcher().i(this, new c());
        s1();
        w1();
        E1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        MovieDetailViewModel l12 = l1();
        l12.F().j(this, new e(new Function1() { // from class: com.transsion.videodetail.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit J1;
                J1 = StreamDetailFragment.J1(StreamDetailFragment.this, (Pair) obj);
                return J1;
            }
        }));
        l12.K().j(this, new e(new Function1() { // from class: com.transsion.videodetail.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K1;
                K1 = StreamDetailFragment.K1(StreamDetailFragment.this, (Integer) obj);
                return K1;
            }
        }));
        o1().z().j(this, new e(new Function1() { // from class: com.transsion.videodetail.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit L1;
                L1 = StreamDetailFragment.L1(StreamDetailFragment.this, (ResourcesSeasonList) obj);
                return L1;
            }
        }));
        o1().s().j(this, new e(new Function1() { // from class: com.transsion.videodetail.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit M1;
                M1 = StreamDetailFragment.M1(StreamDetailFragment.this, (List) obj);
                return M1;
            }
        }));
        o1().x().j(this, new e(new Function1() { // from class: com.transsion.videodetail.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G1;
                G1 = StreamDetailFragment.G1(StreamDetailFragment.this, (VideoDetailMediaSource) obj);
                return G1;
            }
        }));
        o1().u().j(this, new e(new Function1() { // from class: com.transsion.videodetail.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit H1;
                H1 = StreamDetailFragment.H1(StreamDetailFragment.this, (VideoDetailPlayBean) obj);
                return H1;
            }
        }));
        l1().P().j(this, new e(new Function1() { // from class: com.transsion.videodetail.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I1;
                I1 = StreamDetailFragment.I1(StreamDetailFragment.this, (DubsInfo) obj);
                return I1;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isRegisteDeviceKeyMonitor() {
        return true;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        P1(this, false, 1, null);
        this.tsViewCreatedEnd = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("stream_detail", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieDetailActivity.INSTANCE.a("videoDetail------- onCreate ------");
        nh.m.f70597a.l(this.networkStatusChangedListener);
        this.adHelper = new NativeCardPageAdHelper(androidx.view.v.a(this));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        S1();
        setMViewBinding(null);
        NativeCardPageAdHelper nativeCardPageAdHelper = this.adHelper;
        if (nativeCardPageAdHelper != null) {
            nativeCardPageAdHelper.x();
        }
        this.adHelper = null;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void onHomeClick() {
        super.onHomeClick();
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "StreamDetail onHomeClick", false, 4, null);
        g2(FloatActionType.HOME);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ox.c cVar = ox.c.f72319a;
        fo.a aVar = this.playerControl;
        if (!cVar.c(aVar != null ? aVar.getPlayer() : null)) {
            o1().w().o(this.playInfoObserver);
        }
        R1(false);
        NativeCardPageAdHelper nativeCardPageAdHelper = this.adHelper;
        if (nativeCardPageAdHelper != null) {
            nativeCardPageAdHelper.C();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        fo.a aVar;
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        if (isInPictureInPictureMode) {
            FragmentActivity activity = getActivity();
            if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            px.a h12 = h1();
            if (h12 != null && Build.VERSION.SDK_INT >= 31) {
                a.C0856a.f(lg.a.f68962a, "VideoFloat-pip", "onPictureInPictureModeChanged stream--- updateData==2", false, 4, null);
                ox.e.f72320a.b().h(activity, h12);
            }
        }
        ox.e.f72320a.b().onPipModeChanged(isInPictureInPictureMode);
        fo.a aVar2 = this.playerControl;
        if (aVar2 != null) {
            aVar2.onPipModeChanged(isInPictureInPictureMode);
        }
        if (isInPictureInPictureMode || (aVar = this.playerControl) == null) {
            return;
        }
        aVar.exitFullScreen();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void onRecentClick() {
        super.onRecentClick();
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "StreamDetail onRecentClick", false, 4, null);
        g2(FloatActionType.HOME);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        MemberGuideBannerView memberGuideBannerView;
        MemberGuideBannerView memberGuideBannerView2;
        MemberGuideBannerView memberGuideBannerView3;
        super.onResume();
        fo.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onViewResume();
        }
        o1().w().k(this.playInfoObserver);
        R1(true);
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi != null ? iPremiumApi.c() : false) {
            jx.i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (memberGuideBannerView3 = mViewBinding.f66554j) == null) {
                return;
            }
            memberGuideBannerView3.setVisibility(8);
            return;
        }
        if (com.transsion.player.longvideo.intercept.h0.f48193a.d(this.mMovieDetailBean)) {
            jx.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (memberGuideBannerView2 = mViewBinding2.f66554j) == null) {
                return;
            }
            memberGuideBannerView2.setVisibility(0);
            return;
        }
        jx.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (memberGuideBannerView = mViewBinding3.f66554j) == null) {
            return;
        }
        memberGuideBannerView.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        fo.a aVar;
        super.onStop();
        fo.a aVar2 = this.playerControl;
        if (aVar2 != null) {
            aVar2.onSaveHistory();
        }
        ox.c cVar = ox.c.f72319a;
        fo.a aVar3 = this.playerControl;
        if (cVar.c(aVar3 != null ? aVar3.getPlayer() : null) || (aVar = this.playerControl) == null) {
            return;
        }
        aVar.onViewPause();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public jx.i getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        jx.i c11 = jx.i.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        Bundle arguments = getArguments();
        Long valueOf = arguments != null ? Long.valueOf(arguments.getLong("ts_enter", 0L)) : null;
        if (valueOf != null && valueOf.longValue() == 0) {
            valueOf = null;
        }
        this.tsEnter = valueOf != null ? valueOf.longValue() : SystemClock.elapsedRealtime();
        this.lastPageFrom = hj.i.f64628a.i();
        Bundle arguments2 = getArguments();
        this.ops = arguments2 != null ? arguments2.getString("ops") : null;
        Bundle arguments3 = getArguments();
        this.mSubjectId = arguments3 != null ? arguments3.getString("id") : null;
        Bundle arguments4 = getArguments();
        this.autoDownload = arguments4 != null ? arguments4.getBoolean("auto_download") : false;
        Bundle arguments5 = getArguments();
        this.autoPlay = arguments5 != null ? arguments5.getBoolean("auto_play") : false;
        Bundle arguments6 = getArguments();
        this.autoPlayResourceId = arguments6 != null ? arguments6.getString("auto_play_resource_id") : null;
        Bundle arguments7 = getArguments();
        this.preloadId = arguments7 != null ? arguments7.getInt("yy_preload_id") : 0;
        Bundle arguments8 = getArguments();
        this.moduleName = arguments8 != null ? arguments8.getString("module_name") : null;
        Bundle arguments9 = getArguments();
        this.targetSeason = arguments9 != null ? arguments9.getInt("season") : 0;
        Bundle arguments10 = getArguments();
        this.targetEp = arguments10 != null ? arguments10.getInt("episode") : 0;
        int i11 = this.targetSeason;
        if (i11 <= 0) {
            i11 = 1;
        }
        this.curSeason = i11;
        MovieDetailViewModel l12 = l1();
        int i12 = this.preloadId;
        String str = this.mSubjectId;
        if (str == null) {
            str = "";
        }
        l12.S(i12, str, Integer.valueOf(this.curSeason));
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(this.lastPageFrom);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        if (this.mMovieDetailBean == null) {
            loadDefaultData();
        }
    }
}
