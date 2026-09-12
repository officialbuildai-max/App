package com.transsion.postdetail.ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.Lifecycle;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.baseui.widget.f;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.CommentBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$mipmap;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.bean.CommentLikeBody;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.shorttv.ShortTvPlayListViewModel;
import com.transsion.postdetail.ui.dialog.ImmVideoCommentDialog;
import com.transsion.postdetail.ui.dialog.PostConfirmDialog;
import com.transsion.postdetail.ui.fragment.CommentFragment;
import com.transsion.postdetail.ui.fragment.VideoFragment;
import com.transsion.postdetail.ui.view.ImmVideoItemView;
import com.transsion.postdetail.viewmodel.CommentViewModel;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.push.PushConstants;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IRoomApi;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import okhttp3.internal.http2.Settings;

@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002õ\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B!\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0011Jk\u0010!\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"J\u001d\u0010'\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\r\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00182\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u001f\u00107\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u00101\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u000fH\u0016¢\u0006\u0004\b9\u0010\u0011J\u0019\u0010<\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u000f¢\u0006\u0004\b>\u0010\u0011J\u0017\u0010?\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u001a¢\u0006\u0004\bB\u0010@J\u000f\u0010C\u001a\u00020\u000fH\u0016¢\u0006\u0004\bC\u0010\u0011J\u000f\u0010D\u001a\u00020\u000fH\u0016¢\u0006\u0004\bD\u0010\u0011J\u0019\u0010E\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bE\u0010=J\u0019\u0010F\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bF\u0010=J\u0019\u0010G\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bG\u0010=J!\u0010J\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020H2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bJ\u0010KJ\u0019\u0010L\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bL\u0010=J\u0019\u0010M\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bM\u0010=J!\u0010P\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020N2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u000fH\u0016¢\u0006\u0004\bR\u0010\u0011J\u0019\u0010S\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bS\u0010=J\u000f\u0010T\u001a\u00020\u000fH\u0016¢\u0006\u0004\bT\u0010\u0011J\u0019\u0010W\u001a\u00020\u000f2\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bW\u0010XJ\r\u0010Y\u001a\u00020\u000f¢\u0006\u0004\bY\u0010\u0011J\u0019\u0010[\u001a\u00020\u000f2\b\u0010Z\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b[\u0010@J\u0017\u0010\\\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\\\u0010\rJ\u0017\u0010]\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b_\u0010^J\u0017\u0010a\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020HH\u0002¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020HH\u0002¢\u0006\u0004\bd\u0010bJ\u0017\u0010e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\be\u0010^J\u0017\u0010f\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bf\u0010^J\u0017\u0010g\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bg\u0010^J\u001f\u0010j\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u00020\u0018H\u0002¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bl\u0010^J\u001f\u0010o\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020m2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bo\u0010pJ\u0017\u0010q\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bq\u0010^J\u001f\u0010s\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bs\u0010tJ\u000f\u0010u\u001a\u00020\u000fH\u0002¢\u0006\u0004\bu\u0010\u0011J\u000f\u0010v\u001a\u00020\u000fH\u0002¢\u0006\u0004\bv\u0010\u0011J\u000f\u0010w\u001a\u00020\u000fH\u0002¢\u0006\u0004\bw\u0010\u0011J\u000f\u0010x\u001a\u00020\u000fH\u0002¢\u0006\u0004\bx\u0010\u0011J\u0017\u0010z\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020\u0018H\u0002¢\u0006\u0004\bz\u0010{J\u0017\u0010|\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\b|\u0010bJ\u0017\u0010~\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0004\b~\u0010XJ\u000f\u0010\u007f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u007f\u0010\u0011J\u0019\u0010\u0080\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u0080\u0001\u0010XJ\u0019\u0010\u0081\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u0081\u0001\u0010XJ\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u0082\u0001\u0010XJ\u001c\u0010\u0085\u0001\u001a\u00020\u000f2\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001H\u0002¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u001c\u0010\u0088\u0001\u001a\u00020\u000f2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0005\b\u0088\u0001\u0010@J\u0019\u0010\u0089\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u0089\u0001\u0010XJ\u0019\u0010\u008a\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u008a\u0001\u0010XJ\u0019\u0010\u008b\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u008b\u0001\u0010XJ\u0011\u0010\u008c\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u008c\u0001\u0010\u0011J\u001a\u0010\u008e\u0001\u001a\u00020\u000f2\u0007\u0010\u008d\u0001\u001a\u00020\u0018H\u0002¢\u0006\u0005\b\u008e\u0001\u0010{J\u0019\u0010\u008f\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u008f\u0001\u0010XJ\u0019\u0010\u0090\u0001\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020UH\u0002¢\u0006\u0005\b\u0090\u0001\u0010XR\u0017\u0010\u0093\u0001\u001a\u00020\u001a8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001c\u0010£\u0001\u001a\u0005\u0018\u00010 \u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001c\u0010§\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R*\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010\u0092\u0001R\u0018\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010\u0092\u0001R\u001a\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u001a\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001a\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001c\u0010À\u0001\u001a\u0005\u0018\u00010½\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u001c\u0010Ä\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001c\u0010È\u0001\u001a\u0005\u0018\u00010Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R#\u0010Î\u0001\u001a\u0005\u0018\u00010É\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u001c\u0010Ò\u0001\u001a\u0005\u0018\u00010Ï\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u001c\u0010Ö\u0001\u001a\u0005\u0018\u00010Ó\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0018\u0010Ø\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bV\u0010×\u0001R\u0019\u0010Ú\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010×\u0001R\u0019\u0010Ü\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010×\u0001R\u0018\u0010Ý\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b[\u0010×\u0001R\u0019\u0010Þ\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010×\u0001R\u0018\u0010à\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bo\u0010ß\u0001R\u0015\u0010á\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010vR\u0016\u0010â\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010vR\u0016\u0010ä\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bã\u0001\u0010vR\u0016\u0010æ\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bå\u0001\u0010vR\u0016\u0010ç\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010vR\u0016\u0010è\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010vR\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0092\u0001R\u0017\u0010ë\u0001\u001a\u00030é\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bv\u0010ê\u0001R\u0019\u0010ì\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010ß\u0001R\u0018\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010×\u0001R\u0018\u0010î\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bw\u0010×\u0001R\u0019\u0010ð\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010×\u0001R\u0016\u0010ñ\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010vR\u0018\u0010 \u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010×\u0001R\u001b\u0010ô\u0001\u001a\u0005\u0018\u00010ò\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b|\u0010ó\u0001R\u0018\u0010ø\u0001\u001a\u00030õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R!\u0010ý\u0001\u001a\u00030ù\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bú\u0001\u0010Ë\u0001\u001a\u0006\bû\u0001\u0010ü\u0001R\u001f\u0010\u0080\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0þ\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b~\u0010ÿ\u0001¨\u0006\u0082\u0002²\u0006\u000e\u0010\u009b\u0001\u001a\u00030\u0098\u00018\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u009f\u0001\u001a\u00030\u009c\u00018\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0081\u0002\u001a\u00030 \u00018\nX\u008a\u0084\u0002"}, d2 = {"Lcom/transsion/postdetail/ui/view/ImmVideoItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/transsion/player/orplayer/f;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/r;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", WebConstants.FIELD_ITEM, "Landroidx/fragment/app/Fragment;", "fragment", RequestParameters.POSITION, "", "videoLoadMore", "", "basePostId", "baseItemType", "attachToMain", "commentId", "pageFrom", "isFromDownloaded", "setData", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Landroidx/fragment/app/Fragment;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "Lcom/transsion/player/orplayer/g;", "orPlayer", "Lcom/transsion/player/ui/ORPlayerView;", "orPlayerView", "setPlayer", "(Lcom/transsion/player/orplayer/g;Lcom/transsion/player/ui/ORPlayerView;)V", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "pagerLayoutManager", "setPagerLayoutManager", "(Lcom/transsion/shorttv/base/pager/PagerLayoutManager;)V", "Landroid/widget/FrameLayout;", "getPlayerContainer", "()Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroidx/lifecycle/u;", EventConstants.KEY_SOURCE, "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged", "(Landroidx/lifecycle/u;Landroidx/lifecycle/Lifecycle$Event;)V", "onPlayerReset", "Lao/e;", "mediaSource", "onPlayerRelease", "(Lao/e;)V", "app2Background", "videoStartPrepare", "(Ljava/lang/String;)V", "url", "setVideoUrl", "onSetDataSource", "onRenderFirstFrame", "onVideoStart", "onPrepare", "onVideoPause", "", NotificationCompat.CATEGORY_PROGRESS, "onProgress", "(JLao/e;)V", "onLoadingBegin", "onLoadingEnd", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lao/e;)V", "onLoopingStart", "onCompletion", "setOnSeekCompleteListener", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "showCommentDialog", NativeComponentConstants.KEY_COMPONENT_TYPE, "y", "B", "p0", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "i0", "comment", "e0", "(J)V", "share", "l0", "o0", "setBottomSubjectModuleData", "setBottomRoomModuleData", "isShowSubject", "isShowRoom", "setBottomSubjectAndRoomVisibility", "(ZZ)V", "f0", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "hotComment", "A", "(Lcom/transsion/moviedetailapi/bean/CommentBean;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "W", "moduleName", "X", "(Ljava/lang/String;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "m0", "I", "L", "U", PushConstants.PUSH_SERVICE_TYPE_SHOW, "setLoading", "(Z)V", "P", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "S", "j0", "O", "N", "T", "Lcom/transsion/baselib/db/download/DownloadBean;", "download", "Y", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "id", "z", "F", "H", "G", "C", "visible", "setContentVisibility", "c0", "d0", "a", "Ljava/lang/String;", "TAG", "Lso/y;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lso/y;", "viewBinding", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "c", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "videoDetailModel", "Lcom/transsion/postdetail/shorttv/ShortTvPlayListViewModel;", "d", "Lcom/transsion/postdetail/shorttv/ShortTvPlayListViewModel;", "shortTvPlayListViewModel", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "e", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "mCommentViewModel", "Lcom/transsion/share/share/ShareDialogFragment;", "f", "Lcom/transsion/share/share/ShareDialogFragment;", "mShareDialog", be.g.f16474b, "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "data", "h", "Landroidx/fragment/app/Fragment;", "i", "Ljava/lang/Boolean;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Ljava/lang/Integer;", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", CampaignEx.JSON_KEY_AD_K, "l", "m", "Lcom/transsion/player/orplayer/g;", "n", "Lcom/transsion/player/ui/ORPlayerView;", "o", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "Lcom/transsion/room/api/IAudioApi;", TtmlNode.TAG_P, "Lcom/transsion/room/api/IAudioApi;", "audioApi", "Lcom/transsion/postdetail/ui/view/ImmVideoGuideView;", CampaignEx.JSON_KEY_AD_Q, "Lcom/transsion/postdetail/ui/view/ImmVideoGuideView;", "guideView", "Landroid/view/GestureDetector;", CampaignEx.JSON_KEY_AD_R, "Landroid/view/GestureDetector;", "gestureDetector", "Lcom/transsnet/loginapi/ILoginApi;", "s", "Lkotlin/Lazy;", "getLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "loginApi", "Lcom/transsion/postdetail/layer/b;", "t", "Lcom/transsion/postdetail/layer/b;", "dotLayer", "Lcom/transsion/postdetail/ui/dialog/ImmVideoCommentDialog;", TmcStartParams.KEY_URL_SHORT, "Lcom/transsion/postdetail/ui/dialog/ImmVideoCommentDialog;", "commentDialog", "Z", "isClickPause", "w", "isHorizontalDragging", "x", "isPageHide", "isShowHotComment", "isFavoriteShow", "J", "currentSaveProgress", "resImgLargeWidth", "resImgLargeHeight", "D", "resImgSmallWidth", "E", "resImgSmallHeight", "screenHeight", "dp170", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isSeekToFinish", "nextSeekTo", "K", "isPageRelease", "M", "isLongPressTriggered", "screenWidth", "Landroid/animation/ObjectAnimator;", "Landroid/animation/ObjectAnimator;", "rotateAnimator", "com/transsion/postdetail/ui/view/ImmVideoItemView$b", "Q", "Lcom/transsion/postdetail/ui/view/ImmVideoItemView$b;", "downloadListener", "Lcom/transsnet/downloader/manager/g;", "R", "getDownloadManager", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "Landroidx/lifecycle/c0;", "Landroidx/lifecycle/c0;", "favoriteResultObserver", "commentViewModel", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ImmVideoItemView extends ConstraintLayout implements com.transsion.player.orplayer.f, View.OnClickListener, androidx.view.r {

    /* renamed from: A, reason: from kotlin metadata */
    private long currentSaveProgress;

    /* renamed from: B, reason: from kotlin metadata */
    private final int resImgLargeWidth;

    /* renamed from: C, reason: from kotlin metadata */
    private final int resImgLargeHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private final int resImgSmallWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private final int resImgSmallHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private final int screenHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private final int dp170;

    /* renamed from: H, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: I, reason: from kotlin metadata */
    private final AtomicBoolean isSeekToFinish;

    /* renamed from: J, reason: from kotlin metadata */
    private long nextSeekTo;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean attachToMain;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isPageRelease;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isLongPressTriggered;

    /* renamed from: N, reason: from kotlin metadata */
    private final int screenWidth;

    /* renamed from: O, reason: from kotlin metadata */
    private boolean isFromDownloaded;

    /* renamed from: P, reason: from kotlin metadata */
    private ObjectAnimator rotateAnimator;

    /* renamed from: Q, reason: from kotlin metadata */
    private final b downloadListener;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy downloadManager;

    /* renamed from: S, reason: from kotlin metadata */
    private final androidx.view.c0 favoriteResultObserver;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final so.y viewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private PostDetailViewModel videoDetailModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ShortTvPlayListViewModel shortTvPlayListViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CommentViewModel mCommentViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ShareDialogFragment mShareDialog;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private PostSubjectItem data;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Fragment fragment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Boolean videoLoadMore;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Integer position;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String basePostId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String commentId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.transsion.player.orplayer.g orPlayer;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private ORPlayerView orPlayerView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private PagerLayoutManager pagerLayoutManager;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private IAudioApi audioApi;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private ImmVideoGuideView guideView;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private GestureDetector gestureDetector;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final Lazy loginApi;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private com.transsion.postdetail.layer.b dotLayer;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private ImmVideoCommentDialog commentDialog;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean isClickPause;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean isHorizontalDragging;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private boolean isPageHide;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean isShowHotComment;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private boolean isFavoriteShow;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49974a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f49974a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements lj.m0 {
        b() {
        }

        private final void i(DownloadBean downloadBean) {
            String postId = downloadBean.getPostId();
            PostSubjectItem postSubjectItem = ImmVideoItemView.this.data;
            if (!Intrinsics.c(postId, postSubjectItem != null ? postSubjectItem.getPostId() : null)) {
                String resourceId = downloadBean.getResourceId();
                PostSubjectItem postSubjectItem2 = ImmVideoItemView.this.data;
                if (!Intrinsics.c(resourceId, postSubjectItem2 != null ? postSubjectItem2.getPostId() : null)) {
                    return;
                }
            }
            final ImmVideoItemView immVideoItemView = ImmVideoItemView.this;
            immVideoItemView.post(new Runnable() { // from class: com.transsion.postdetail.ui.view.r
                @Override // java.lang.Runnable
                public final void run() {
                    ImmVideoItemView.b.j(ImmVideoItemView.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(ImmVideoItemView immVideoItemView) {
            immVideoItemView.j0();
        }

        @Override // lj.m0
        public void a(DownloadBean bean, DownloadException downloadException) {
            Intrinsics.h(bean, "bean");
            i(bean);
        }

        @Override // lj.m0
        public void b(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
            i(bean);
        }

        @Override // lj.m0
        public void c(DownloadBean bean, long j11, long j12) {
            Intrinsics.h(bean, "bean");
            i(bean);
        }

        @Override // lj.m0
        public void d(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
            i(bean);
        }

        @Override // lj.m0
        public void e(DownloadBean bean, String str) {
            Intrinsics.h(bean, "bean");
            i(bean);
        }

        @Override // lj.m0
        public void f(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
            i(bean);
        }

        @Override // lj.m0
        public void g(DownloadBean bean) {
            Intrinsics.h(bean, "bean");
            i(bean);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            return super.onDoubleTap(e11);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            super.onLongPress(e11);
            int i11 = ImmVideoItemView.this.screenWidth / 3;
            int x10 = (int) e11.getX();
            ImmVideoItemView.this.isLongPressTriggered = true;
            if (x10 >= 0 && x10 <= i11) {
                a.C0856a.f(lg.a.f68962a, ImmVideoItemView.this.TAG, "左边长按，clickX=" + x10 + ", cut=" + i11, false, 4, null);
                return;
            }
            if (x10 > i11 * 2) {
                a.C0856a.f(lg.a.f68962a, ImmVideoItemView.this.TAG, "右边长按，clickX=" + x10 + ", cut=" + i11, false, 4, null);
                return;
            }
            a.C0856a.f(lg.a.f68962a, ImmVideoItemView.this.TAG, "中间长按，clickX=" + x10 + ", cut=" + i11, false, 4, null);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            ImmVideoItemView.this.U();
            return super.onSingleTapUp(e11);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements f.a {

        /* renamed from: a, reason: collision with root package name */
        private int f49977a;

        /* renamed from: b, reason: collision with root package name */
        private int f49978b;

        /* renamed from: c, reason: collision with root package name */
        private int f49979c;

        /* renamed from: d, reason: collision with root package name */
        private String f49980d = "";

        /* renamed from: e, reason: collision with root package name */
        private int f49981e = com.blankj.utilcode.util.a0.a(1.5f);

        d() {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void a() {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void b(float f11, float f12) {
            if (!ImmVideoItemView.this.isHorizontalDragging) {
                PagerLayoutManager pagerLayoutManager = ImmVideoItemView.this.pagerLayoutManager;
                if (pagerLayoutManager != null) {
                    pagerLayoutManager.W(false);
                }
                this.f49977a = ImmVideoItemView.this.viewBinding.f75905u.getProgress();
                ImmVideoItemView.this.setContentVisibility(false);
                AppCompatTextView tvProgressDes = ImmVideoItemView.this.viewBinding.D;
                Intrinsics.g(tvProgressDes, "tvProgressDes");
                jg.c.k(tvProgressDes);
                AppCompatSeekBar seekBar = ImmVideoItemView.this.viewBinding.f75907w;
                Intrinsics.g(seekBar, "seekBar");
                jg.c.k(seekBar);
                ProgressBar progressBar = ImmVideoItemView.this.viewBinding.f75905u;
                Intrinsics.g(progressBar, "progressBar");
                jg.c.g(progressBar);
                this.f49979c = ImmVideoItemView.this.viewBinding.f75905u.getWidth();
                int max = ImmVideoItemView.this.viewBinding.f75905u.getMax();
                this.f49978b = max;
                this.f49980d = com.transsion.postdetail.util.n.c(max);
            }
            ImmVideoItemView.this.isHorizontalDragging = true;
            float f13 = f12 - f11;
            int i11 = this.f49978b;
            int i12 = (int) (this.f49977a + ((f13 * i11) / this.f49979c));
            int i13 = i12 >= 0 ? i12 > i11 ? i11 : i12 : 0;
            ImmVideoItemView.this.viewBinding.D.setText(com.transsion.postdetail.util.n.c(i13) + " / " + this.f49980d);
            ImmVideoItemView.this.viewBinding.f75905u.setProgress(i13);
            ImmVideoItemView.this.viewBinding.f75907w.setProgress(i13);
        }

        @Override // com.transsion.baseui.widget.f.a
        public void c(float f11, float f12) {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void d(float f11, float f12) {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void e() {
            com.transsion.player.orplayer.g gVar;
            PagerLayoutManager pagerLayoutManager = ImmVideoItemView.this.pagerLayoutManager;
            if (pagerLayoutManager != null) {
                pagerLayoutManager.W(true);
            }
            if (ImmVideoItemView.this.isHorizontalDragging) {
                ImmVideoItemView.this.isHorizontalDragging = false;
                ImmVideoItemView.this.setContentVisibility(true);
                AppCompatTextView tvProgressDes = ImmVideoItemView.this.viewBinding.D;
                Intrinsics.g(tvProgressDes, "tvProgressDes");
                jg.c.g(tvProgressDes);
                AppCompatSeekBar seekBar = ImmVideoItemView.this.viewBinding.f75907w;
                Intrinsics.g(seekBar, "seekBar");
                jg.c.g(seekBar);
                ProgressBar progressBar = ImmVideoItemView.this.viewBinding.f75905u;
                Intrinsics.g(progressBar, "progressBar");
                jg.c.k(progressBar);
                long progress = ImmVideoItemView.this.viewBinding.f75905u.getProgress();
                ImmVideoItemView immVideoItemView = ImmVideoItemView.this;
                if (immVideoItemView.isSeekToFinish.compareAndSet(true, false)) {
                    com.transsion.player.orplayer.g gVar2 = ImmVideoItemView.this.orPlayer;
                    if (gVar2 != null) {
                        gVar2.seekTo(progress);
                    }
                    progress = 0;
                }
                immVideoItemView.nextSeekTo = progress;
                com.transsion.player.orplayer.g gVar3 = ImmVideoItemView.this.orPlayer;
                if (gVar3 == null || gVar3.isPlaying() || (gVar = ImmVideoItemView.this.orPlayer) == null) {
                    return;
                }
                gVar.play();
            }
        }

        @Override // com.transsion.baseui.widget.f.a
        public void onDoubleTap(MotionEvent e11) {
            Intrinsics.h(e11, "e");
        }

        @Override // com.transsion.baseui.widget.f.a
        public void onLongPress(MotionEvent e11) {
            Intrinsics.h(e11, "e");
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements com.transsion.share.share.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f49983a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImmVideoItemView f49984b;

        /* loaded from: classes6.dex */
        public static final class a implements PostConfirmDialog.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ImmVideoItemView f49985a;

            a(ImmVideoItemView immVideoItemView) {
                this.f49985a = immVideoItemView;
            }

            @Override // com.transsion.postdetail.ui.dialog.PostConfirmDialog.a
            public void a() {
                String postId;
                PostDetailViewModel postDetailViewModel;
                PostSubjectItem postSubjectItem = this.f49985a.data;
                if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null || (postDetailViewModel = this.f49985a.videoDetailModel) == null) {
                    return;
                }
                postDetailViewModel.r(postId);
            }
        }

        e(View view, ImmVideoItemView immVideoItemView) {
            this.f49983a = view;
            this.f49984b = immVideoItemView;
        }

        @Override // com.transsion.share.share.a
        public void a(String id2, PostType postType) {
            Fragment fragment;
            FragmentManager childFragmentManager;
            Intrinsics.h(id2, "id");
            PostConfirmDialog postConfirmDialog = new PostConfirmDialog();
            postConfirmDialog.r0(new a(this.f49984b));
            Fragment fragment2 = this.f49984b.fragment;
            if (fragment2 == null || !fragment2.isAdded() || (fragment = this.f49984b.fragment) == null || (childFragmentManager = fragment.getChildFragmentManager()) == null) {
                return;
            }
            childFragmentManager.g0();
            if (postConfirmDialog.isAdded() || childFragmentManager.k0("PostConfirmDialog") != null) {
                return;
            }
            postConfirmDialog.show(childFragmentManager, "PostConfirmDialog");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            this.f49984b.z(str);
        }

        @Override // com.transsion.share.share.a
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Subject subject;
            ResourceDetectors resourceDetector;
            String resourceLink;
            Media media;
            Cover cover;
            Integer size;
            Media media2;
            Cover cover2;
            String url2;
            String url3;
            String url4;
            Media media3;
            Intrinsics.h(url, "url");
            Intrinsics.h(fileName, "fileName");
            Intrinsics.h(fileSize, "fileSize");
            Intrinsics.h(fileImage, "fileImage");
            if (com.transsion.baseui.util.c.f43558a.a(this.f49983a.getId(), 500L)) {
                return;
            }
            PostSubjectItem postSubjectItem = this.f49984b.data;
            Video a11 = com.transsion.postdetail.util.u.a((postSubjectItem == null || (media3 = postSubjectItem.getMedia()) == null) ? null : media3.getVideo());
            PostSubjectItem postSubjectItem2 = this.f49984b.data;
            String title = postSubjectItem2 != null ? postSubjectItem2.getTitle() : null;
            if (TextUtils.isEmpty(title)) {
                PostSubjectItem postSubjectItem3 = this.f49984b.data;
                title = postSubjectItem3 != null ? postSubjectItem3.getContent() : null;
            }
            String str = title;
            String str2 = (a11 == null || (url4 = a11.getUrl()) == null) ? "" : url4;
            String str3 = (a11 == null || (url3 = a11.getUrl()) == null) ? "" : url3;
            PostSubjectItem postSubjectItem4 = this.f49984b.data;
            String str4 = (postSubjectItem4 == null || (media2 = postSubjectItem4.getMedia()) == null || (cover2 = media2.getCover()) == null || (url2 = cover2.getUrl()) == null) ? "" : url2;
            Long valueOf = (a11 == null || (size = a11.getSize()) == null) ? null : Long.valueOf(size.intValue());
            PostSubjectItem postSubjectItem5 = this.f49984b.data;
            String postId = postSubjectItem5 != null ? postSubjectItem5.getPostId() : null;
            PostSubjectItem postSubjectItem6 = this.f49984b.data;
            DownloadBean downloadBean = new DownloadBean(str2, str3, str, str4, valueOf, postSubjectItem6 != null ? postSubjectItem6.getPostId() : null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, postId, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -134217792, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
            PostSubjectItem postSubjectItem7 = this.f49984b.data;
            downloadBean.setThumbnail((postSubjectItem7 == null || (media = postSubjectItem7.getMedia()) == null || (cover = media.getCover()) == null) ? null : cover.getThumbnail());
            PostSubjectItem postSubjectItem8 = this.f49984b.data;
            if (postSubjectItem8 == null || !postSubjectItem8.getBuiltIn()) {
                DownloadManagerApi a12 = DownloadManagerApi.f58521j.a();
                Context context = this.f49984b.getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                PostSubjectItem postSubjectItem9 = this.f49984b.data;
                String ops = postSubjectItem9 != null ? postSubjectItem9.getOps() : null;
                PostSubjectItem postSubjectItem10 = this.f49984b.data;
                a12.O(fragmentActivity, downloadBean, VideoFragment.PAGE_NAME, ops, (postSubjectItem10 == null || (subject = postSubjectItem10.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? "" : resourceLink, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
            } else {
                this.f49984b.Y(downloadBean);
            }
            com.transsion.postdetail.helper.a.f48920a.i(this.f49984b.data, VideoFragment.PAGE_NAME, this.f49984b.pageFrom);
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

    /* loaded from: classes6.dex */
    public static final class f implements CommentFragment.b {
        f() {
        }

        @Override // com.transsion.postdetail.ui.fragment.CommentFragment.b
        public void a(long j11) {
            Stat stat;
            PostSubjectItem postSubjectItem = ImmVideoItemView.this.data;
            if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                stat.setCommentCount(Long.valueOf(j11));
            }
            ImmVideoItemView.this.e0(j11);
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements ExpandView.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f49987a;

        g(Ref.BooleanRef booleanRef) {
            this.f49987a = booleanRef;
        }

        @Override // com.tn.lib.view.expand.ExpandView.c
        public void a(ExpandView expandView) {
            this.f49987a.element = true;
        }

        @Override // com.tn.lib.view.expand.ExpandView.c
        public void b(ExpandView expandView) {
            this.f49987a.element = false;
        }
    }

    /* loaded from: classes6.dex */
    public static final class h implements com.transsion.baseui.util.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f49988a;

        h(Ref.ObjectRef objectRef) {
            this.f49988a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.transsion.baseui.util.g
        public void a(List list) {
            Intrinsics.h(list, "list");
            this.f49988a.element = list;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmVideoItemView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmVideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmVideoItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.TAG = "ImmVideoPlayer";
        this.commentId = "";
        this.loginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.view.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi E;
                E = ImmVideoItemView.E();
                return E;
            }
        });
        this.screenHeight = com.blankj.utilcode.util.y.c();
        this.dp170 = com.blankj.utilcode.util.a0.a(170.0f);
        this.isSeekToFinish = new AtomicBoolean(true);
        this.attachToMain = true;
        this.screenWidth = com.blankj.utilcode.util.y.e();
        this.downloadListener = new b();
        this.downloadManager = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.view.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsnet.downloader.manager.g w11;
                w11 = ImmVideoItemView.w();
                return w11;
            }
        });
        this.favoriteResultObserver = new androidx.view.c0() { // from class: com.transsion.postdetail.ui.view.j
            @Override // androidx.view.c0
            public final void onChanged(Object obj) {
                ImmVideoItemView.x(ImmVideoItemView.this, (String) obj);
            }
        };
        View.inflate(getContext(), R$layout.layout_immersion_video_item_view, this);
        so.y a11 = so.y.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
        a11.C.setOnClickListener(this);
        a11.f75908x.setOnClickListener(this);
        a11.E.setOnClickListener(this);
        a11.f75899o.setOnClickListener(this);
        a11.f75901q.setOnClickListener(this);
        a11.f75902r.f75620b.setOnClickListener(this);
        a11.f75902r.f75624f.setOnClickListener(this);
        a11.F.setOnClickListener(this);
        a11.f75894j.setOnClickListener(this);
        a11.f75900p.setOnClickListener(this);
        a11.G.setOnClickListener(this);
        a11.f75888d.setOnClickListener(this);
        this.resImgLargeWidth = com.blankj.utilcode.util.a0.a(48.0f);
        this.resImgLargeHeight = com.blankj.utilcode.util.a0.a(64.0f);
        this.resImgSmallWidth = com.blankj.utilcode.util.a0.a(24.0f);
        this.resImgSmallHeight = com.blankj.utilcode.util.a0.a(32.0f);
        B(context);
        if (ImmVideoHelper.f48894h.a().h() > 0) {
            ViewGroup.LayoutParams layoutParams = a11.f75906v.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (((ViewGroup.MarginLayoutParams) bVar).bottomMargin < com.blankj.utilcode.util.a0.a(35.0f)) {
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin += com.blankj.utilcode.util.a0.a(10.0f);
                a11.f75906v.setLayoutParams(bVar);
            }
        }
    }

    private final void A(CommentBean hotComment, PostSubjectItem item) {
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.base_net_err);
            return;
        }
        Boolean likeStatu = hotComment.getLikeStatu();
        Boolean bool = Boolean.TRUE;
        boolean c11 = Intrinsics.c(likeStatu, bool);
        AppCompatImageView appCompatImageView = this.viewBinding.f75897m;
        if (appCompatImageView != null) {
            if (appCompatImageView.isEnabled()) {
                appCompatImageView.setEnabled(false);
                hotComment.setLikeStatu(Boolean.FALSE);
                if (hotComment.getLikeCnt() > 0) {
                    hotComment.setLikeCnt(hotComment.getLikeCnt() - 1);
                }
            } else {
                appCompatImageView.setEnabled(true);
                hotComment.setLikeStatu(bool);
                hotComment.setLikeCnt(hotComment.getLikeCnt() + 1);
            }
        }
        this.viewBinding.B.setText(hotComment.getLikeCnt() == 0 ? "" : com.transsion.baseui.util.j.a(hotComment.getLikeCnt()));
        String commentId = hotComment.getCommentId();
        if (commentId != null) {
            X(c11 ? "dislike_hot_comment" : "like_hot_comment", item);
            CommentLikeBody commentLikeBody = new CommentLikeBody(commentId, Integer.valueOf(c11 ? 1 : 0));
            CommentViewModel commentViewModel = this.mCommentViewModel;
            if (commentViewModel != null) {
                commentViewModel.q(commentLikeBody);
            }
            in.b bVar = new in.b(!c11, commentId, hotComment.getLikeCnt());
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = in.b.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, bVar, 0L);
        }
    }

    private final void B(Context context) {
        this.gestureDetector = new GestureDetector(context, new c());
        L();
        I();
        C();
    }

    private final void C() {
        new com.transsion.baseui.widget.f(getContext(), this.viewBinding.J).s(new d());
        this.viewBinding.f75907w.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.postdetail.ui.view.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean D;
                D = ImmVideoItemView.D(view, motionEvent);
                return D;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi E() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    private final void F(View view) {
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        UserInfo userInfo = new UserInfo();
        PostSubjectItem postSubjectItem = this.data;
        User user = postSubjectItem != null ? postSubjectItem.getUser() : null;
        userInfo.setUserId(user != null ? user.getUserId() : null);
        userInfo.setNickname(user != null ? user.getNickname() : null);
        userInfo.setUsername(user != null ? user.getUsername() : null);
        userInfo.setAvatar(user != null ? user.getAvatar() : null);
        Navigator.x(TheRouter.c("/profile/user_profile").K("userId", userInfo.getUserId()), getContext(), null, 2, null);
        com.transsion.postdetail.helper.a.f48920a.c(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
    }

    private final void G(View view) {
        Group group;
        Integer num;
        FragmentActivity requireActivity;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        String c11 = hh.b.f64584b.a().c();
        IRoomApi iRoomApi = (IRoomApi) TheRouter.d(IRoomApi.class, new Object[0]);
        if (!TextUtils.equals(c11, iRoomApi != null ? iRoomApi.d() : null) || (num = this.position) == null || num.intValue() != 0) {
            Navigator c12 = TheRouter.c("/room/detail");
            PostSubjectItem postSubjectItem = this.data;
            Navigator.x(c12.K("id", (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getGroupId()), getContext(), null, 2, null);
            com.transsion.postdetail.helper.a.f48920a.m(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
            return;
        }
        Fragment fragment = this.fragment;
        if (fragment == null || (requireActivity = fragment.requireActivity()) == null) {
            return;
        }
        requireActivity.finish();
    }

    private final void H(View view) {
        Subject subject;
        Subject subject2;
        Integer subjectType;
        Subject subject3;
        Subject subject4;
        Integer num;
        FragmentActivity requireActivity;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        String c11 = hh.b.f64584b.a().c();
        IMovieDetailService iMovieDetailService = (IMovieDetailService) TheRouter.d(IMovieDetailService.class, new Object[0]);
        if (TextUtils.equals(c11, iMovieDetailService != null ? iMovieDetailService.d() : null) && (num = this.position) != null && num.intValue() == 0) {
            Fragment fragment = this.fragment;
            if (fragment == null || (requireActivity = fragment.requireActivity()) == null) {
                return;
            }
            requireActivity.finish();
            return;
        }
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (subject3 = postSubjectItem.getSubject()) != null) {
            Integer subjectType2 = subject3.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType2 != null && subjectType2.intValue() == value) {
                DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
                Context context = getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                PostSubjectItem postSubjectItem2 = this.data;
                String ops = (postSubjectItem2 == null || (subject4 = postSubjectItem2.getSubject()) == null) ? null : subject4.getOps();
                PostSubjectItem postSubjectItem3 = this.data;
                a11.d0(fragmentActivity, VideoFragment.PAGE_NAME, (r22 & 4) != 0 ? "" : "", ops, (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : false, (r22 & 64) != 0 ? null : postSubjectItem3 != null ? postSubjectItem3.getSubject() : null, (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
                com.transsion.postdetail.helper.a.f48920a.C(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
            }
        }
        Navigator c12 = TheRouter.c("/movie/detail");
        PostSubjectItem postSubjectItem4 = this.data;
        Navigator F = c12.F("subject_type", (postSubjectItem4 == null || (subject2 = postSubjectItem4.getSubject()) == null || (subjectType = subject2.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
        PostSubjectItem postSubjectItem5 = this.data;
        Navigator K = F.K("id", (postSubjectItem5 == null || (subject = postSubjectItem5.getSubject()) == null) ? null : subject.getSubjectId());
        PostSubjectItem postSubjectItem6 = this.data;
        Navigator.x(K.K("ops", postSubjectItem6 != null ? postSubjectItem6.getOps() : null), getContext(), null, 2, null);
        com.transsion.postdetail.helper.a.f48920a.C(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
    }

    private final void I() {
        Context context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit J;
                J = ImmVideoItemView.J(ImmVideoItemView.this, (AddToDownloadEvent) obj);
                return J;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(appCompatActivity, name, state, kotlinx.coroutines.y0.c().q(), false, function1);
        Context context2 = getContext();
        Intrinsics.f(context2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function12 = new Function1() { // from class: com.transsion.postdetail.ui.view.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K;
                K = ImmVideoItemView.K(ImmVideoItemView.this, (uy.c) obj);
                return K;
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = uy.c.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.observeEvent((AppCompatActivity) context2, name2, state, kotlinx.coroutines.y0.c().q(), false, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(ImmVideoItemView immVideoItemView, AddToDownloadEvent value) {
        Subject subject;
        Intrinsics.h(value, "value");
        try {
            String subjectId = value.getSubjectId();
            PostSubjectItem postSubjectItem = immVideoItemView.data;
            if (!TextUtils.equals(subjectId, (postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null) ? null : subject.getSubjectId())) {
                return Unit.f67184a;
            }
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(ImmVideoItemView immVideoItemView, uy.c value) {
        String c11;
        PostSubjectItem postSubjectItem;
        Subject subject;
        ShortTVFavInfo shortTVFavInfo;
        Subject subject2;
        Intrinsics.h(value, "value");
        try {
            c11 = value.c();
            postSubjectItem = immVideoItemView.data;
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        if (!TextUtils.equals(c11, (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) ? null : subject2.getSubjectId())) {
            return Unit.f67184a;
        }
        PostSubjectItem postSubjectItem2 = immVideoItemView.data;
        if (postSubjectItem2 != null && (subject = postSubjectItem2.getSubject()) != null && (shortTVFavInfo = subject.getShortTVFavInfo()) != null) {
            shortTVFavInfo.setFavoriteNum(value.b());
            shortTVFavInfo.setHasFavorite(value.a());
        }
        immVideoItemView.viewBinding.f75909y.setSelected(value.a());
        AppCompatTextView appCompatTextView = immVideoItemView.viewBinding.f75909y;
        String b11 = value.b();
        appCompatTextView.setText(com.transsion.baseui.util.j.a(b11 != null ? Long.parseLong(b11) : 0L));
        return Unit.f67184a;
    }

    private final void L() {
        Context context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit M;
                M = ImmVideoItemView.M(ImmVideoItemView.this, (LikeEvent) obj);
                return M;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(ImmVideoItemView immVideoItemView, LikeEvent value) {
        String subjectId;
        PostSubjectItem postSubjectItem;
        Stat stat;
        Stat stat2;
        Long likeCount;
        Stat stat3;
        Stat stat4;
        Long likeCount2;
        Intrinsics.h(value, "value");
        try {
            subjectId = value.getSubjectId();
            postSubjectItem = immVideoItemView.data;
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        if (!TextUtils.equals(subjectId, postSubjectItem != null ? postSubjectItem.getPostId() : null)) {
            return Unit.f67184a;
        }
        PostSubjectItem postSubjectItem2 = immVideoItemView.data;
        if (postSubjectItem2 != null) {
            postSubjectItem2.setHasLike(Boolean.valueOf(value.getLike()));
        }
        if (value.getLike()) {
            PostSubjectItem postSubjectItem3 = immVideoItemView.data;
            if (postSubjectItem3 != null && (stat3 = postSubjectItem3.getStat()) != null) {
                PostSubjectItem postSubjectItem4 = immVideoItemView.data;
                stat3.setLikeCount((postSubjectItem4 == null || (stat4 = postSubjectItem4.getStat()) == null || (likeCount2 = stat4.getLikeCount()) == null) ? null : Long.valueOf(likeCount2.longValue() + 1));
            }
        } else {
            PostSubjectItem postSubjectItem5 = immVideoItemView.data;
            if (postSubjectItem5 != null && (stat = postSubjectItem5.getStat()) != null) {
                PostSubjectItem postSubjectItem6 = immVideoItemView.data;
                stat.setLikeCount((postSubjectItem6 == null || (stat2 = postSubjectItem6.getStat()) == null || (likeCount = stat2.getLikeCount()) == null) ? null : Long.valueOf(likeCount.longValue() - 1));
            }
        }
        PostSubjectItem postSubjectItem7 = immVideoItemView.data;
        if (postSubjectItem7 != null) {
            immVideoItemView.i0(postSubjectItem7);
        }
        return Unit.f67184a;
    }

    private final void N(View view) {
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        showCommentDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O(View view) {
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_tips);
            return;
        }
        PostSubjectItem postSubjectItem = this.data;
        int c11 = postSubjectItem != null ? Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE) : 0;
        PostDetailViewModel postDetailViewModel = this.videoDetailModel;
        if (postDetailViewModel != null) {
            PostSubjectItem postSubjectItem2 = this.data;
            postDetailViewModel.G(postSubjectItem2 != null ? postSubjectItem2.getPostId() : null, c11);
        }
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.f48920a;
        PostSubjectItem postSubjectItem3 = this.data;
        aVar.p(postSubjectItem3, postSubjectItem3 != null ? Intrinsics.c(postSubjectItem3.getHasLike(), Boolean.TRUE) : false, VideoFragment.PAGE_NAME, this.pageFrom);
    }

    private final void P(long progress) {
        Boolean bool = this.videoLoadMore;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.c(bool, bool2)) {
            ImmVideoHelper.a aVar = ImmVideoHelper.f48894h;
            if (aVar.a().n() && progress >= 1000) {
                aVar.a().t();
                ImmVideoGuideView a11 = ImmVideoGuideView.INSTANCE.a(this);
                a11.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.view.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImmVideoItemView.Q(ImmVideoItemView.this);
                    }
                }, 5000L);
                this.guideView = a11;
                return;
            }
        }
        if (Intrinsics.c(this.videoLoadMore, bool2) && Intrinsics.c(this.pageFrom, "Trending")) {
            ImmVideoHelper.a aVar2 = ImmVideoHelper.f48894h;
            if (!aVar2.a().o() || progress < 1000) {
                return;
            }
            aVar2.a().u();
            ImmVideoGuideView a12 = ImmVideoGuideView.INSTANCE.a(this);
            a12.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.view.q
                @Override // java.lang.Runnable
                public final void run() {
                    ImmVideoItemView.R(ImmVideoItemView.this);
                }
            }, 5000L);
            this.guideView = a12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(ImmVideoItemView immVideoItemView) {
        ImmVideoGuideView immVideoGuideView = immVideoItemView.guideView;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(ImmVideoItemView immVideoItemView) {
        ImmVideoGuideView immVideoGuideView = immVideoItemView.guideView;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
    }

    private final void S(View view) {
        PostSubjectItem postSubjectItem;
        DownloadBean G;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L) || (postSubjectItem = this.data) == null || (G = DownloadUtil.f60023a.G(postSubjectItem)) == null) {
            return;
        }
        DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
        String resourceId = G.getResourceId();
        if (resourceId == null) {
            resourceId = "";
        }
        DownloadBean q11 = a11.q(resourceId);
        if (q11 == null || q11.getStatus() != 5) {
            com.transsion.baseui.util.m.c(R$string.shorts_click_download);
            com.transsion.postdetail.helper.a.f48920a.i(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
            getDownloadManager().p(G);
            j0();
        }
    }

    private final void T(View view) {
        Fragment fragment;
        FragmentManager childFragmentManager;
        ShareDialogFragment shareDialogFragment;
        Integer subjectRate;
        User user;
        User user2;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        com.transsion.postdetail.helper.a.f48920a.A(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
        if (this.mShareDialog == null) {
            ILoginApi loginApi = getLoginApi();
            UserInfo i11 = loginApi != null ? loginApi.i() : null;
            PostSubjectItem postSubjectItem = this.data;
            boolean equals = TextUtils.equals((postSubjectItem == null || (user2 = postSubjectItem.getUser()) == null) ? null : user2.getUserId(), i11 != null ? i11.getUserId() : null);
            ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
            PostType postType = PostType.POST_TYPE;
            PostSubjectItem postSubjectItem2 = this.data;
            String postId = postSubjectItem2 != null ? postSubjectItem2.getPostId() : null;
            PostSubjectItem postSubjectItem3 = this.data;
            String userId = (postSubjectItem3 == null || (user = postSubjectItem3.getUser()) == null) ? null : user.getUserId();
            String value = ReportType.POST.getValue();
            PostSubjectItem postSubjectItem4 = this.data;
            String title = postSubjectItem4 != null ? postSubjectItem4.getTitle() : null;
            PostSubjectItem postSubjectItem5 = this.data;
            String num = (postSubjectItem5 == null || (subjectRate = postSubjectItem5.getSubjectRate()) == null) ? null : subjectRate.toString();
            PostSubjectItem postSubjectItem6 = this.data;
            ShareDialogFragment a11 = companion.a(postType, postId, userId, value, title, num, false, equals, false, "postdetail", postSubjectItem6 != null ? postSubjectItem6.getOps() : null, view.getContext().getString(R$string.save_video));
            this.mShareDialog = a11;
            if (a11 != null) {
                a11.G0(new e(view, this));
            }
        }
        try {
            Fragment fragment2 = this.fragment;
            if (fragment2 == null || !fragment2.isAdded() || (fragment = this.fragment) == null || (childFragmentManager = fragment.getChildFragmentManager()) == null) {
                return;
            }
            childFragmentManager.g0();
            ShareDialogFragment shareDialogFragment2 = this.mShareDialog;
            if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.k0("share") == null && (shareDialogFragment = this.mShareDialog) != null) {
                shareDialogFragment.show(childFragmentManager, "share");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        ClipLoading clLoading = this.viewBinding.f75889e;
        Intrinsics.g(clLoading, "clLoading");
        if (clLoading.getVisibility() == 0) {
            return;
        }
        com.transsion.player.orplayer.g gVar = this.orPlayer;
        if (gVar == null || !gVar.isPlaying()) {
            com.transsion.postdetail.layer.b bVar = this.dotLayer;
            if (bVar != null) {
                bVar.c();
            }
            com.transsion.player.orplayer.g gVar2 = this.orPlayer;
            if (gVar2 != null) {
                gVar2.play();
            }
            this.isClickPause = false;
            return;
        }
        com.transsion.postdetail.layer.b bVar2 = this.dotLayer;
        if (bVar2 != null) {
            bVar2.b();
        }
        com.transsion.player.orplayer.g gVar3 = this.orPlayer;
        if (gVar3 != null) {
            gVar3.pause();
        }
        this.isClickPause = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(ImmVideoItemView immVideoItemView) {
        com.transsion.player.orplayer.g gVar;
        Fragment fragment = immVideoItemView.fragment;
        if (fragment == null || !fragment.isVisible() || (gVar = immVideoItemView.orPlayer) == null) {
            return;
        }
        gVar.play();
    }

    private final void W(PostSubjectItem item) {
        String str;
        String str2;
        String str3;
        String str4;
        String value;
        Integer subjectType;
        String postId = item.getPostId();
        if (postId == null) {
            postId = "";
        }
        Pair a11 = TuplesKt.a("post_id", postId);
        Pair a12 = TuplesKt.a(WebConstants.PAGE_FROM, this.pageFrom);
        Pair a13 = TuplesKt.a("module_name", "hot_comment");
        Pair a14 = TuplesKt.a("is_cache_post", String.valueOf(item.isRoomCache()));
        User user = item.getUser();
        if (user == null || (str = user.getUserId()) == null) {
            str = "";
        }
        Pair a15 = TuplesKt.a("user_id", str);
        Group group = item.getGroup();
        if (group == null || (str2 = group.getGroupId()) == null) {
            str2 = "";
        }
        Pair a16 = TuplesKt.a("group_id", str2);
        Subject subject = item.getSubject();
        if (subject == null || (str3 = subject.getSubjectId()) == null) {
            str3 = "";
        }
        Pair a17 = TuplesKt.a("subject_id", str3);
        Subject subject2 = item.getSubject();
        if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str4 = subjectType.toString()) == null) {
            str4 = "";
        }
        Pair a18 = TuplesKt.a("subject_type", str4);
        Pair a19 = TuplesKt.a("builtin", item.getBuiltIn() ? "1" : "0");
        Media media = item.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        Pair a20 = TuplesKt.a("post_media_type", value);
        String ops = item.getOps();
        hj.i.f64628a.D(VideoFragment.PAGE_NAME, MapsKt.m(a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, TuplesKt.a("ops", ops != null ? ops : "")));
    }

    private final void X(String moduleName, PostSubjectItem item) {
        String str;
        String value;
        String groupId;
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        CommentBean hotComment = item.getHotComment();
        String str2 = "";
        if (hotComment == null || (str = hotComment.getCommentId()) == null) {
            str = "";
        }
        hashMap.put("comment_id", str);
        String postId = item.getPostId();
        if (postId == null) {
            postId = "";
        }
        hashMap.put("post_id", postId);
        String ops = item.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        Group group = item.getGroup();
        if (group != null && (groupId = group.getGroupId()) != null) {
            str2 = groupId;
        }
        hashMap.put("group_id", str2);
        Media media = item.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        String str3 = this.pageFrom;
        if (str3 != null && str3.length() != 0) {
            String str4 = this.pageFrom;
            Intrinsics.e(str4);
            hashMap.put(WebConstants.PAGE_FROM, str4);
        }
        com.transsion.baselib.helper.a.f43316a.i(VideoFragment.PAGE_NAME, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(DownloadBean download) {
        kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), null, null, new ImmVideoItemView$saveBuiltInVideo$1(download, null), 3, null);
    }

    private static final PostDetailViewModel Z(Lazy lazy) {
        return (PostDetailViewModel) lazy.getValue();
    }

    private static final ShortTvPlayListViewModel a0(Lazy lazy) {
        return (ShortTvPlayListViewModel) lazy.getValue();
    }

    private static final CommentViewModel b0(Lazy lazy) {
        return (CommentViewModel) lazy.getValue();
    }

    private final void c0(View view) {
        ObjectAnimator objectAnimator = this.rotateAnimator;
        if (objectAnimator != null) {
            Intrinsics.e(objectAnimator);
            if (objectAnimator.isRunning()) {
                return;
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
        ofFloat.setDuration(800L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
        this.rotateAnimator = ofFloat;
    }

    private final void d0(View view) {
        ObjectAnimator objectAnimator = this.rotateAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.rotateAnimator = null;
        view.setRotation(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(long comment) {
        this.viewBinding.f75908x.setText(com.transsion.baseui.util.j.a(comment));
    }

    private final void f0(final PostSubjectItem item) {
        String url;
        Subject subject;
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                BLConstraintLayout clHotComment = this.viewBinding.f75888d;
                Intrinsics.g(clHotComment, "clHotComment");
                jg.c.g(clHotComment);
                return;
            }
        }
        final CommentBean hotComment = item.getHotComment();
        String content = hotComment != null ? hotComment.getContent() : null;
        if (content == null || content.length() == 0) {
            BLConstraintLayout clHotComment2 = this.viewBinding.f75888d;
            Intrinsics.g(clHotComment2, "clHotComment");
            jg.c.g(clHotComment2);
            NestedScrollableHost nsPostDes = this.viewBinding.f75904t;
            Intrinsics.g(nsPostDes, "nsPostDes");
            jg.c.k(nsPostDes);
            return;
        }
        W(item);
        BLConstraintLayout clHotComment3 = this.viewBinding.f75888d;
        Intrinsics.g(clHotComment3, "clHotComment");
        jg.c.k(clHotComment3);
        NestedScrollableHost nsPostDes2 = this.viewBinding.f75904t;
        Intrinsics.g(nsPostDes2, "nsPostDes");
        jg.c.g(nsPostDes2);
        this.viewBinding.f75910z.setText(content);
        String avatarUrl = hotComment.getAvatarUrl();
        String str = "";
        if (avatarUrl == null) {
            avatarUrl = "";
        }
        if (avatarUrl.length() > 0) {
            f.a aVar = ej.f.f62005a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b c11 = aVar.m(context).g(avatarUrl).m(dk.a.b(20)).c(dk.a.b(20));
            ShapeableImageView ivHotCommentAvatar = this.viewBinding.f75895k;
            Intrinsics.g(ivHotCommentAvatar, "ivHotCommentAvatar");
            c11.d(ivHotCommentAvatar);
        }
        this.viewBinding.B.setText(hotComment.getLikeCnt() == 0 ? "" : com.transsion.baseui.util.j.a(hotComment.getLikeCnt()));
        this.viewBinding.f75897m.setEnabled(Intrinsics.c(hotComment.getLikeStatu(), Boolean.TRUE));
        List<Cover> imageList = hotComment.getImageList();
        if (imageList == null || imageList.isEmpty()) {
            ShapeableImageView commentCover = this.viewBinding.f75890f;
            Intrinsics.g(commentCover, "commentCover");
            jg.c.g(commentCover);
        } else {
            ShapeableImageView shapeableImageView = this.viewBinding.f75890f;
            shapeableImageView.setVisibility(0);
            f.a aVar2 = ej.f.f62005a;
            Context context2 = shapeableImageView.getContext();
            Intrinsics.g(context2, "getContext(...)");
            f.b m11 = aVar2.m(context2);
            List<Cover> imageList2 = hotComment.getImageList();
            Intrinsics.e(imageList2);
            Cover cover = imageList2.get(0);
            if (cover != null && (url = cover.getUrl()) != null) {
                str = url;
            }
            f.b g11 = m11.g(str);
            Intrinsics.e(shapeableImageView);
            g11.d(shapeableImageView);
            Intrinsics.e(shapeableImageView);
        }
        this.viewBinding.I.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImmVideoItemView.g0(ImmVideoItemView.this, hotComment, item, view);
            }
        });
        Context context3 = getContext();
        Intrinsics.f(context3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h02;
                h02 = ImmVideoItemView.h0(CommentBean.this, this, (in.b) obj);
                return h02;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = in.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent((AppCompatActivity) context3, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(ImmVideoItemView immVideoItemView, CommentBean commentBean, PostSubjectItem postSubjectItem, View view) {
        immVideoItemView.A(commentBean, postSubjectItem);
    }

    private final com.transsnet.downloader.manager.g getDownloadManager() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.loginApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(CommentBean commentBean, ImmVideoItemView immVideoItemView, in.b value) {
        Intrinsics.h(value, "value");
        if (Intrinsics.c(value.a(), commentBean.getCommentId())) {
            commentBean.setLikeStatu(Boolean.valueOf(value.c()));
            commentBean.setLikeCnt(value.b());
            immVideoItemView.viewBinding.B.setText(value.b() == 0 ? "" : com.transsion.baseui.util.j.a(value.b()));
            immVideoItemView.viewBinding.f75897m.setEnabled(value.c());
        }
        return Unit.f67184a;
    }

    private final void i0(PostSubjectItem item) {
        Long likeCount;
        AppCompatTextView appCompatTextView = this.viewBinding.C;
        Boolean hasLike = item.getHasLike();
        appCompatTextView.setSelected(hasLike != null ? hasLike.booleanValue() : false);
        Stat stat = item.getStat();
        String a11 = com.transsion.baseui.util.j.a((stat == null || (likeCount = stat.getLikeCount()) == null) ? 0L : likeCount.longValue());
        if (Intrinsics.c(a11, "0")) {
            a11 = "";
        }
        appCompatTextView.setText(a11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        final String postId;
        AppCompatImageView appCompatImageView;
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null || (appCompatImageView = this.viewBinding.f75899o) == null) {
            return;
        }
        DownloadBean q11 = DownloadEsHelper.f59542m.a().q(postId);
        if (q11 == null) {
            d0(appCompatImageView);
            appCompatImageView.setImageResource(R$mipmap.post_detail_ic_video_download_new);
            appCompatImageView.setEnabled(true);
            appCompatImageView.setOnClickListener(this);
            return;
        }
        int status = q11.getStatus();
        if (status == 1 || status == 2 || status == 3) {
            appCompatImageView.setImageResource(R$drawable.post_detail_ic_video_downloading);
            appCompatImageView.setEnabled(false);
            c0(appCompatImageView);
        } else {
            if (status != 5) {
                d0(appCompatImageView);
                appCompatImageView.setImageResource(R$mipmap.post_detail_ic_video_download_new);
                appCompatImageView.setEnabled(true);
                appCompatImageView.setOnClickListener(this);
                return;
            }
            d0(appCompatImageView);
            appCompatImageView.setImageResource(R$drawable.post_detail_ic_video_downloaded);
            appCompatImageView.setEnabled(true);
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImmVideoItemView.k0(ImmVideoItemView.this, postId, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(ImmVideoItemView immVideoItemView, String str, View view) {
        com.transsion.postdetail.helper.a.f48920a.k(immVideoItemView.data, VideoFragment.PAGE_NAME, immVideoItemView.pageFrom);
        Navigator.x(TheRouter.c("/download/panel_activity").F("extra_page_index", 0).K("extra_target_resource_id", str), immVideoItemView.getContext(), null, 2, null);
    }

    private final void l0(long share) {
        this.viewBinding.E.setText(com.transsion.baseui.util.j.a(share));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v47, types: [T, com.transsion.moviedetailapi.bean.ShortTVFavInfo] */
    private final void m0() {
        Subject subject;
        Subject subject2;
        Cover cover;
        String url;
        String str;
        Subject subject3;
        Cover cover2;
        Subject subject4;
        Subject subject5;
        Subject subject6;
        Subject subject7;
        ShortTVItem shortTVFirstEp;
        Subject subject8;
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                BLLinearLayout root = this.viewBinding.f75902r.getRoot();
                Intrinsics.g(root, "getRoot(...)");
                jg.c.g(root);
                ShapeableImageView ivVideoAvatar = this.viewBinding.f75901q;
                Intrinsics.g(ivVideoAvatar, "ivVideoAvatar");
                jg.c.g(ivVideoAvatar);
                AppCompatImageView ivDownload = this.viewBinding.f75894j;
                Intrinsics.g(ivDownload, "ivDownload");
                jg.c.k(ivDownload);
                AppCompatTextView tvTitle = this.viewBinding.G;
                Intrinsics.g(tvTitle, "tvTitle");
                jg.c.k(tvTitle);
                BLTextView tvShortTvEp = this.viewBinding.F;
                Intrinsics.g(tvShortTvEp, "tvShortTvEp");
                jg.c.k(tvShortTvEp);
                ShapeableImageView ivShortCover = this.viewBinding.f75900p;
                Intrinsics.g(ivShortCover, "ivShortCover");
                jg.c.k(ivShortCover);
                AppCompatTextView appCompatTextView = this.viewBinding.G;
                PostSubjectItem postSubjectItem2 = this.data;
                T t11 = 0;
                t11 = 0;
                appCompatTextView.setText((postSubjectItem2 == null || (subject8 = postSubjectItem2.getSubject()) == null) ? null : subject8.getTitle());
                com.transsion.postdetail.util.t tVar = com.transsion.postdetail.util.t.f50233a;
                PostSubjectItem postSubjectItem3 = this.data;
                tVar.a(Integer.valueOf((postSubjectItem3 == null || (subject7 = postSubjectItem3.getSubject()) == null || (shortTVFirstEp = subject7.getShortTVFirstEp()) == null) ? 1 : shortTVFirstEp.getEp()));
                PostSubjectItem postSubjectItem4 = this.data;
                this.viewBinding.F.setText(getContext().getString(R$string.short_tv_play_all, tVar.a(Integer.valueOf((postSubjectItem4 == null || (subject6 = postSubjectItem4.getSubject()) == null) ? 0 : subject6.getTotalEpisode()))));
                com.transsion.baseui.widget.jumpingbeans.a.a(this.viewBinding.F).e(0, this.viewBinding.F.getText().toString().length()).g(true).i(100).f(0.05f).h(10000).a();
                ShapeableImageView shapeableImageView = this.viewBinding.f75900p;
                PostSubjectItem postSubjectItem5 = this.data;
                if (postSubjectItem5 == null || !postSubjectItem5.getBuiltIn()) {
                    PostSubjectItem postSubjectItem6 = this.data;
                    if (postSubjectItem6 != null && (subject2 = postSubjectItem6.getSubject()) != null && (cover = subject2.getCover()) != null && (url = cover.getUrl()) != null) {
                        f.a aVar = ej.f.f62005a;
                        Context context = getContext();
                        Intrinsics.g(context, "getContext(...)");
                        f.b c11 = aVar.m(context).g(url).m(com.blankj.utilcode.util.i.e(21.0f)).c(com.blankj.utilcode.util.i.e(30.0f));
                        PostSubjectItem postSubjectItem7 = this.data;
                        if (postSubjectItem7 == null || (subject3 = postSubjectItem7.getSubject()) == null || (cover2 = subject3.getCover()) == null || (str = cover2.getThumbnail()) == null) {
                            str = "";
                        }
                        f.b h11 = c11.l(str).h(true);
                        ShapeableImageView ivShortCover2 = this.viewBinding.f75900p;
                        Intrinsics.g(ivShortCover2, "ivShortCover");
                        h11.d(ivShortCover2);
                    }
                } else {
                    kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), null, null, new ImmVideoItemView$updateShortTVInfo$1(this, null), 3, null);
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                PostSubjectItem postSubjectItem8 = this.data;
                if (postSubjectItem8 != null && (subject5 = postSubjectItem8.getSubject()) != null) {
                    t11 = subject5.getShortTVFavInfo();
                }
                objectRef.element = t11;
                if (t11 == 0) {
                    ?? shortTVFavInfo = new ShortTVFavInfo(null, false, null, 7, null);
                    shortTVFavInfo.setFavoriteNum("0");
                    objectRef.element = shortTVFavInfo;
                    PostSubjectItem postSubjectItem9 = this.data;
                    if (postSubjectItem9 != null && (subject4 = postSubjectItem9.getSubject()) != null) {
                        subject4.setShortTVFavInfo((ShortTVFavInfo) objectRef.element);
                    }
                }
                AppCompatTextView tvFavorite = this.viewBinding.f75909y;
                Intrinsics.g(tvFavorite, "tvFavorite");
                jg.c.k(tvFavorite);
                this.viewBinding.f75909y.setSelected(((ShortTVFavInfo) objectRef.element).getHasFavorite());
                AppCompatTextView appCompatTextView2 = this.viewBinding.f75909y;
                String favoriteNum = ((ShortTVFavInfo) objectRef.element).getFavoriteNum();
                appCompatTextView2.setText(com.transsion.baseui.util.j.a(Long.parseLong(favoriteNum != null ? favoriteNum : "0")));
                this.viewBinding.f75909y.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ImmVideoItemView.n0(ImmVideoItemView.this, objectRef, view);
                    }
                });
                return;
            }
        }
        AppCompatTextView tvTitle2 = this.viewBinding.G;
        Intrinsics.g(tvTitle2, "tvTitle");
        jg.c.g(tvTitle2);
        BLTextView tvShortTvEp2 = this.viewBinding.F;
        Intrinsics.g(tvShortTvEp2, "tvShortTvEp");
        jg.c.g(tvShortTvEp2);
        ShapeableImageView ivShortCover3 = this.viewBinding.f75900p;
        Intrinsics.g(ivShortCover3, "ivShortCover");
        jg.c.g(ivShortCover3);
        AppCompatImageView ivDownload2 = this.viewBinding.f75894j;
        Intrinsics.g(ivDownload2, "ivDownload");
        jg.c.g(ivDownload2);
        ShapeableImageView ivVideoAvatar2 = this.viewBinding.f75901q;
        Intrinsics.g(ivVideoAvatar2, "ivVideoAvatar");
        jg.c.k(ivVideoAvatar2);
        AppCompatTextView tvFavorite2 = this.viewBinding.f75909y;
        Intrinsics.g(tvFavorite2, "tvFavorite");
        jg.c.g(tvFavorite2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void n0(ImmVideoItemView immVideoItemView, Ref.ObjectRef objectRef, View view) {
        Subject subject;
        Subject subject2;
        com.transsion.postdetail.shorttv.k kVar = com.transsion.postdetail.shorttv.k.f49278a;
        PostSubjectItem postSubjectItem = immVideoItemView.data;
        String subjectId = (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) ? null : subject2.getSubjectId();
        PostSubjectItem postSubjectItem2 = immVideoItemView.data;
        kVar.c(subjectId, (postSubjectItem2 == null || (subject = postSubjectItem2.getSubject()) == null) ? null : subject.getOps(), "", ((ShortTVFavInfo) objectRef.element).getHasFavorite(), VideoFragment.PAGE_NAME, immVideoItemView.pageFrom);
        ShortTvPlayListViewModel shortTvPlayListViewModel = immVideoItemView.shortTvPlayListViewModel;
        if (shortTvPlayListViewModel != null) {
            PostSubjectItem postSubjectItem3 = immVideoItemView.data;
            shortTvPlayListViewModel.d(postSubjectItem3 != null ? postSubjectItem3.getSubject() : null);
        }
    }

    private final void o0(PostSubjectItem item) {
        setBottomSubjectAndRoomVisibility(item.getSubject() != null, item.getGroup() != null);
        if (item.getSubject() != null) {
            setBottomSubjectModuleData(item);
        }
        if (item.getGroup() != null) {
            Group group = item.getGroup();
            String name = group != null ? group.getName() : null;
            if (name == null || name.length() == 0) {
                return;
            }
            setBottomRoomModuleData(item);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void p0(final com.transsion.moviedetailapi.bean.PostSubjectItem r15) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.view.ImmVideoItemView.p0(com.transsion.moviedetailapi.bean.PostSubjectItem):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0062, code lost:
    
        if ((r9.length() > 0) == true) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit q0(com.tn.lib.view.expand.ExpandView r8, kotlin.jvm.internal.Ref.BooleanRef r9, kotlin.jvm.internal.Ref.ObjectRef r10, com.transsion.moviedetailapi.bean.PostSubjectItem r11, com.transsion.postdetail.ui.view.ImmVideoItemView r12, android.view.View r13, java.lang.String r14) {
        /*
            java.lang.CharSequence r13 = r8.getText()
            int r13 = r13.length()
            boolean r9 = r9.element
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L45
            T r9 = r10.element
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L45
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
            r10 = r1
        L1b:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L46
            java.lang.Object r2 = r9.next()
            com.transsion.baseui.util.UrlContent r2 = (com.transsion.baseui.util.UrlContent) r2
            int r3 = r2.getIndexOfUrl()
            int r4 = r2.getIndexOfUrl()
            java.lang.String r2 = r2.getUrl()
            int r2 = r2.length()
            int r4 = r4 + r2
            if (r3 > r13) goto L1b
            if (r4 >= r13) goto L3d
            goto L1b
        L3d:
            if (r3 > r13) goto L1b
            int r4 = r4 + 1
            if (r13 >= r4) goto L1b
            r10 = r0
            goto L1b
        L45:
            r10 = r1
        L46:
            if (r10 == 0) goto L4d
            r8.performClick()
            goto Lcb
        L4d:
            com.transsion.moviedetailapi.bean.Subject r9 = r11.getSubject()
            if (r9 == 0) goto L65
            java.lang.String r9 = r9.getSubjectId()
            if (r9 == 0) goto L65
            int r9 = r9.length()
            if (r9 <= 0) goto L61
            r9 = r0
            goto L62
        L61:
            r9 = r1
        L62:
            if (r9 != r0) goto L65
            goto L66
        L65:
            r0 = r1
        L66:
            r9 = 0
            if (r0 == 0) goto Lb7
            com.transsnet.downloader.DownloadManagerApi$a r10 = com.transsnet.downloader.DownloadManagerApi.f58521j
            com.transsnet.downloader.DownloadManagerApi r0 = r10.a()
            android.content.Context r8 = r8.getContext()
            java.lang.String r10 = "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity"
            kotlin.jvm.internal.Intrinsics.f(r8, r10)
            r1 = r8
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            com.transsion.moviedetailapi.bean.Subject r2 = r11.getSubject()
            kotlin.jvm.internal.Intrinsics.e(r14)
            com.transsion.moviedetailapi.bean.PostSubjectItem r8 = r12.data
            if (r8 == 0) goto L8c
            java.lang.String r8 = r8.getOps()
            r5 = r8
            goto L8d
        L8c:
            r5 = r9
        L8d:
            com.transsion.moviedetailapi.bean.Subject r8 = r11.getSubject()
            if (r8 == 0) goto La2
            com.transsion.moviedetailapi.bean.ResourceDetectors r8 = r8.getResourceDetector()
            if (r8 == 0) goto La2
            java.lang.String r8 = r8.getResourceLink()
            if (r8 != 0) goto La0
            goto La2
        La0:
            r6 = r8
            goto La5
        La2:
            java.lang.String r8 = ""
            goto La0
        La5:
            com.transsion.moviedetailapi.bean.User r8 = r11.getUser()
            if (r8 == 0) goto Laf
            java.lang.String r9 = r8.getNickname()
        Laf:
            r7 = r9
            java.lang.String r4 = "post_video_detail"
            r3 = r14
            r0.U(r1, r2, r3, r4, r5, r6, r7)
            goto Lcb
        Lb7:
            java.lang.String r10 = "/web/web"
            com.therouter.router.Navigator r10 = com.therouter.TheRouter.c(r10)
            java.lang.String r11 = "url"
            com.therouter.router.Navigator r10 = r10.K(r11, r14)
            android.content.Context r8 = r8.getContext()
            r11 = 2
            com.therouter.router.Navigator.x(r10, r8, r9, r11, r9)
        Lcb:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.view.ImmVideoItemView.q0(com.tn.lib.view.expand.ExpandView, kotlin.jvm.internal.Ref$BooleanRef, kotlin.jvm.internal.Ref$ObjectRef, com.transsion.moviedetailapi.bean.PostSubjectItem, com.transsion.postdetail.ui.view.ImmVideoItemView, android.view.View, java.lang.String):kotlin.Unit");
    }

    private final void setBottomRoomModuleData(PostSubjectItem item) {
        String str;
        Cover cover;
        AppCompatTextView appCompatTextView = this.viewBinding.f75902r.f75625g;
        Group group = item.getGroup();
        String str2 = null;
        appCompatTextView.setText(group != null ? group.getName() : null);
        f.a aVar = ej.f.f62005a;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m11 = aVar.m(context);
        Group group2 = item.getGroup();
        if (group2 == null || (str = group2.getAvatar()) == null) {
            Group group3 = item.getGroup();
            if (group3 != null && (cover = group3.getCover()) != null) {
                str2 = cover.getUrl();
            }
            str = str2 == null ? "" : str2;
        }
        f.b c11 = m11.g(str).m(dk.a.b(32)).c(dk.a.b(32));
        ShapeableImageView ivRoomCover = this.viewBinding.f75902r.f75621c;
        Intrinsics.g(ivRoomCover, "ivRoomCover");
        c11.d(ivRoomCover);
    }

    private final void setBottomSubjectAndRoomVisibility(boolean isShowSubject, boolean isShowRoom) {
        if (ak.g.f714a.b()) {
            BLLinearLayout root = this.viewBinding.f75902r.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            root.setVisibility(isShowRoom ? 0 : 8);
            ConstraintLayout clSubjectContent = this.viewBinding.f75902r.f75620b;
            Intrinsics.g(clSubjectContent, "clSubjectContent");
            jg.c.g(clSubjectContent);
            View vSubjectRoomLine = this.viewBinding.f75902r.f75631m;
            Intrinsics.g(vSubjectRoomLine, "vSubjectRoomLine");
            jg.c.g(vSubjectRoomLine);
            LinearLayout llRoomTag = this.viewBinding.f75902r.f75624f;
            Intrinsics.g(llRoomTag, "llRoomTag");
            llRoomTag.setVisibility(isShowRoom ? 0 : 8);
            return;
        }
        if (isShowSubject) {
            BLLinearLayout root2 = this.viewBinding.f75902r.getRoot();
            Intrinsics.g(root2, "getRoot(...)");
            jg.c.k(root2);
            ConstraintLayout clSubjectContent2 = this.viewBinding.f75902r.f75620b;
            Intrinsics.g(clSubjectContent2, "clSubjectContent");
            jg.c.k(clSubjectContent2);
            View vSubjectRoomLine2 = this.viewBinding.f75902r.f75631m;
            Intrinsics.g(vSubjectRoomLine2, "vSubjectRoomLine");
            vSubjectRoomLine2.setVisibility(isShowRoom ? 0 : 8);
            LinearLayout llRoomTag2 = this.viewBinding.f75902r.f75624f;
            Intrinsics.g(llRoomTag2, "llRoomTag");
            llRoomTag2.setVisibility(isShowRoom ? 0 : 8);
            return;
        }
        BLLinearLayout root3 = this.viewBinding.f75902r.getRoot();
        Intrinsics.g(root3, "getRoot(...)");
        root3.setVisibility(isShowRoom ? 0 : 8);
        ConstraintLayout clSubjectContent3 = this.viewBinding.f75902r.f75620b;
        Intrinsics.g(clSubjectContent3, "clSubjectContent");
        jg.c.g(clSubjectContent3);
        View vSubjectRoomLine3 = this.viewBinding.f75902r.f75631m;
        Intrinsics.g(vSubjectRoomLine3, "vSubjectRoomLine");
        jg.c.g(vSubjectRoomLine3);
        LinearLayout llRoomTag3 = this.viewBinding.f75902r.f75624f;
        Intrinsics.g(llRoomTag3, "llRoomTag");
        llRoomTag3.setVisibility(isShowRoom ? 0 : 8);
    }

    private final void setBottomSubjectModuleData(PostSubjectItem item) {
        String str;
        String str2;
        String str3;
        Subject subject;
        String genre;
        List S0;
        String str4;
        Cover cover;
        Cover cover2;
        f.a aVar = ej.f.f62005a;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m11 = aVar.m(context);
        Subject subject2 = item.getSubject();
        String str5 = "";
        if (subject2 == null || (cover2 = subject2.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = "";
        }
        f.b c11 = m11.g(str).m(dk.a.b(32)).c(dk.a.b(32));
        Subject subject3 = item.getSubject();
        if (subject3 == null || (cover = subject3.getCover()) == null || (str2 = cover.getThumbnail()) == null) {
            str2 = "";
        }
        f.b l11 = c11.l(str2);
        ShapeableImageView ivSubjectCover = this.viewBinding.f75902r.f75622d;
        Intrinsics.g(ivSubjectCover, "ivSubjectCover");
        l11.d(ivSubjectCover);
        AppCompatTextView appCompatTextView = this.viewBinding.f75902r.f75628j;
        Subject subject4 = item.getSubject();
        if (subject4 == null || (str3 = subject4.getTitle()) == null) {
            str3 = "";
        }
        appCompatTextView.setText(str3);
        Subject subject5 = item.getSubject();
        this.viewBinding.f75902r.f75623e.setImageResource(com.transsion.moviedetailapi.g.a(subject5 != null ? subject5.getSubjectType() : null));
        Subject subject6 = item.getSubject();
        Date l12 = com.blankj.utilcode.util.c0.l(subject6 != null ? subject6.getReleaseDate() : null, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(l12);
        this.viewBinding.f75902r.f75626h.setText(String.valueOf(calendar.get(1)));
        Subject subject7 = item.getSubject();
        String genre2 = subject7 != null ? subject7.getGenre() : null;
        if (genre2 != null && genre2.length() != 0 && (subject = item.getSubject()) != null && (genre = subject.getGenre()) != null && (S0 = StringsKt.S0(genre, new String[]{", "}, false, 0, 6, null)) != null && (str4 = (String) CollectionsKt.k0(S0)) != null) {
            str5 = str4;
        }
        AppCompatTextView tvSubjectGenre = this.viewBinding.f75902r.f75627i;
        Intrinsics.g(tvSubjectGenre, "tvSubjectGenre");
        tvSubjectGenre.setVisibility(str5.length() > 0 ? 0 : 8);
        AppCompatTextView tvSubjectGenre2 = this.viewBinding.f75902r.f75627i;
        Intrinsics.g(tvSubjectGenre2, "tvSubjectGenre");
        tvSubjectGenre2.setVisibility(str5.length() > 0 ? 0 : 8);
        this.viewBinding.f75902r.f75627i.setText(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setContentVisibility(boolean r19) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.view.ImmVideoItemView.setContentVisibility(boolean):void");
    }

    private final void setLoading(boolean show) {
        if (show) {
            ClipLoading clLoading = this.viewBinding.f75889e;
            Intrinsics.g(clLoading, "clLoading");
            jg.c.k(clLoading);
            ProgressBar progressBar = this.viewBinding.f75905u;
            Intrinsics.g(progressBar, "progressBar");
            jg.c.g(progressBar);
            this.viewBinding.f75889e.start();
            return;
        }
        ProgressBar progressBar2 = this.viewBinding.f75905u;
        Intrinsics.g(progressBar2, "progressBar");
        jg.c.k(progressBar2);
        ClipLoading clLoading2 = this.viewBinding.f75889e;
        Intrinsics.g(clLoading2, "clLoading");
        jg.c.g(clLoading2);
        this.viewBinding.f75889e.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g w() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ImmVideoItemView immVideoItemView, String str) {
        immVideoItemView.y(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void y(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L46
            int r0 = r3.hashCode()
            r1 = -1550083459(0xffffffffa39b9a7d, float:-1.6870562E-17)
            if (r0 == r1) goto L36
            r1 = -877500447(0xffffffffcbb267e1, float:-2.3384002E7)
            if (r0 == r1) goto L26
            r1 = 525878142(0x1f58437e, float:4.5795607E-20)
            if (r0 == r1) goto L16
            goto L46
        L16:
            java.lang.String r0 = "favorite_add"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L1f
            goto L46
        L1f:
            int r3 = com.transsnet.downloader.R$string.short_tv_favorite_toast
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L47
        L26:
            java.lang.String r0 = "favorite_fail"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L2f
            goto L46
        L2f:
            int r3 = com.tn.lib.widget.R$string.failed_toast
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L47
        L36:
            java.lang.String r0 = "favorite_cancel"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L3f
            goto L46
        L3f:
            int r3 = com.transsnet.downloader.R$string.short_tv_favorite_remove_toast
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L47
        L46:
            r3 = 0
        L47:
            if (r3 == 0) goto L52
            int r3 = r3.intValue()
            uh.b$a r0 = uh.b.f76876a
            r0.d(r3)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.view.ImmVideoItemView.y(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(String id2) {
        androidx.view.b0 C;
        a.C0856a.r(lg.a.f68962a, this.TAG, new String[]{"finishAfterReport, position = " + this.position}, false, 4, null);
        PostDetailViewModel postDetailViewModel = this.videoDetailModel;
        if (postDetailViewModel == null || (C = postDetailViewModel.C()) == null) {
            return;
        }
        C.q(this.position);
    }

    public final void app2Background() {
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.d(true);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    public final FrameLayout getPlayerContainer() {
        FrameLayout flContainer = this.viewBinding.f75892h;
        Intrinsics.g(flContainer, "flContainer");
        return flContainer;
    }

    public final Integer getPosition() {
        return this.position;
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
        f.a.c(this, eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        androidx.view.u viewLifecycleOwner;
        ShortTvPlayListViewModel shortTvPlayListViewModel;
        androidx.view.b0 f11;
        super.onAttachedToWindow();
        Fragment fragment = this.fragment;
        if (fragment != null && (viewLifecycleOwner = fragment.getViewLifecycleOwner()) != null && (shortTvPlayListViewModel = this.shortTvPlayListViewModel) != null && (f11 = shortTvPlayListViewModel.f()) != null) {
            f11.j(viewLifecycleOwner, this.favoriteResultObserver);
        }
        getDownloadManager().e(this.downloadListener);
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        f.a.d(this, j11, eVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v11) {
        Subject subject;
        Context context;
        PostSubjectItem postSubjectItem;
        Subject subject2;
        Integer valueOf = v11 != null ? Integer.valueOf(v11.getId()) : null;
        int i11 = R$id.tv_like;
        if (valueOf != null && valueOf.intValue() == i11) {
            O(v11);
            return;
        }
        int i12 = R$id.tv_comment;
        if (valueOf == null || valueOf.intValue() != i12) {
            int i13 = R$id.clHotComment;
            if (valueOf == null || valueOf.intValue() != i13) {
                int i14 = R$id.tv_share;
                if (valueOf != null && valueOf.intValue() == i14) {
                    T(v11);
                    return;
                }
                int i15 = R$id.iv_save;
                if (valueOf != null && valueOf.intValue() == i15) {
                    S(v11);
                    return;
                }
                int i16 = R$id.iv_video_avatar;
                if (valueOf != null && valueOf.intValue() == i16) {
                    F(v11);
                    return;
                }
                int i17 = R$id.ev_post_des;
                if (valueOf != null && valueOf.intValue() == i17) {
                    return;
                }
                int i18 = R$id.cl_subject_content;
                if (valueOf != null && valueOf.intValue() == i18) {
                    H(v11);
                    return;
                }
                int i19 = R$id.ll_room_tag;
                if (valueOf != null && valueOf.intValue() == i19) {
                    G(v11);
                    return;
                }
                int i20 = R$id.tvShortTvEp;
                if (valueOf != null && valueOf.intValue() == i20) {
                    Fragment fragment = this.fragment;
                    if (fragment == null || (context = fragment.getContext()) == null || (postSubjectItem = this.data) == null || (subject2 = postSubjectItem.getSubject()) == null) {
                        return;
                    }
                    PostSubjectItem postSubjectItem2 = this.data;
                    subject2.setOps(postSubjectItem2 != null ? postSubjectItem2.getOps() : null);
                    Navigator F = TheRouter.c(ls.a.f69157a.b()).K("id", subject2.getSubjectId()).F("ep", 1);
                    PostSubjectItem postSubjectItem3 = this.data;
                    Navigator.x(F.K("ops", postSubjectItem3 != null ? postSubjectItem3.getOps() : null), context, null, 2, null);
                    return;
                }
                int i21 = R$id.iv_download;
                if (valueOf == null || valueOf.intValue() != i21) {
                    int i22 = R$id.iv_short_cover;
                    if (valueOf == null || valueOf.intValue() != i22) {
                        int i23 = R$id.tv_title;
                        if (valueOf == null || valueOf.intValue() != i23) {
                            return;
                        }
                    }
                }
                DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
                Context context2 = getContext();
                Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context2;
                PostSubjectItem postSubjectItem4 = this.data;
                String ops = (postSubjectItem4 == null || (subject = postSubjectItem4.getSubject()) == null) ? null : subject.getOps();
                boolean z10 = v11.getId() == R$id.iv_download;
                PostSubjectItem postSubjectItem5 = this.data;
                a11.d0(fragmentActivity, VideoFragment.PAGE_NAME, (r22 & 4) != 0 ? "" : "", ops, (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : z10, (r22 & 64) != 0 ? null : postSubjectItem5 != null ? postSubjectItem5.getSubject() : null, (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        N(v11);
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e mediaSource) {
        Subject subject;
        Fragment fragment;
        Context context;
        PostSubjectItem postSubjectItem;
        Subject subject2;
        a.C0856a.r(lg.a.f68962a, this.TAG, new String[]{"player- onCompletion"}, false, 4, null);
        PostSubjectItem postSubjectItem2 = this.data;
        if (postSubjectItem2 == null || (subject = postSubjectItem2.getSubject()) == null) {
            return;
        }
        Integer subjectType = subject.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value || (fragment = this.fragment) == null || (context = fragment.getContext()) == null || (postSubjectItem = this.data) == null || (subject2 = postSubjectItem.getSubject()) == null) {
            return;
        }
        PostSubjectItem postSubjectItem3 = this.data;
        subject2.setOps(postSubjectItem3 != null ? postSubjectItem3.getOps() : null);
        Navigator F = TheRouter.c(ls.a.f69157a.b()).K("id", subject2.getSubjectId()).F("ep", 1);
        PostSubjectItem postSubjectItem4 = this.data;
        Navigator.x(F.K("ops", postSubjectItem4 != null ? postSubjectItem4.getOps() : null), context, null, 2, null);
        com.transsion.player.orplayer.g gVar = this.orPlayer;
        if (gVar != null) {
            gVar.seekTo(0L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.view.b0 f11;
        androidx.view.b0 f12;
        super.onDetachedFromWindow();
        ShortTvPlayListViewModel shortTvPlayListViewModel = this.shortTvPlayListViewModel;
        if (shortTvPlayListViewModel != null && (f12 = shortTvPlayListViewModel.f()) != null) {
            f12.q(null);
        }
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = this.shortTvPlayListViewModel;
        if (shortTvPlayListViewModel2 != null && (f11 = shortTvPlayListViewModel2.f()) != null) {
            f11.o(this.favoriteResultObserver);
        }
        getDownloadManager().x(this.downloadListener);
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
    public void onLoadingBegin(ao.e mediaSource) {
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.h();
        }
        setLoading(true);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(ao.e mediaSource) {
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.i();
        }
        setLoading(false);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, ao.e eVar) {
        f.a.m(this, i11, f11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.j();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e mediaSource) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.isSeekToFinish.set(true);
        this.nextSeekTo = 0L;
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.k(errorInfo);
        }
        lg.a.f68962a.i("i_media", this.TAG + " --> IPlayerListener --> onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + " url:" + (mediaSource != null ? mediaSource.k() : null) + " --> 短播放失败了", true);
    }

    public void onPlayErrorChangePayer(TnPlayerType tnPlayerType, ao.e eVar) {
        f.a.s(this, tnPlayerType, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(ao.e mediaSource) {
        this.isSeekToFinish.set(true);
        this.nextSeekTo = 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        String postId;
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onPlayerReset", false, 4, null);
        this.isPageRelease = true;
        this.isSeekToFinish.set(true);
        this.nextSeekTo = 0L;
        setKeepScreenOn(false);
        this.isClickPause = false;
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            com.transsion.postdetail.layer.b.e(bVar, false, 1, null);
        }
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (postId = postSubjectItem.getPostId()) != null) {
        }
        AppCompatImageView ivCover = this.viewBinding.f75893i;
        Intrinsics.g(ivCover, "ivCover");
        jg.c.k(ivCover);
        AppCompatImageView ivPause = this.viewBinding.f75898n;
        Intrinsics.g(ivPause, "ivPause");
        jg.c.g(ivPause);
        AppCompatSeekBar seekBar = this.viewBinding.f75907w;
        Intrinsics.g(seekBar, "seekBar");
        jg.c.g(seekBar);
        this.viewBinding.f75891g.reset();
        ImmVideoGuideView immVideoGuideView = this.guideView;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
        this.orPlayer = null;
        this.orPlayerView = null;
        this.pagerLayoutManager = null;
        this.currentSaveProgress = 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e mediaSource) {
        Fragment fragment;
        String postId;
        long longValue;
        com.transsion.player.orplayer.g gVar = this.orPlayer;
        boolean z10 = false;
        int duration = gVar != null ? (int) gVar.getDuration() : 0;
        this.viewBinding.f75905u.setMax(duration);
        this.viewBinding.f75907w.setMax(duration);
        PostSubjectItem postSubjectItem = this.data;
        if (postSubjectItem != null && (postId = postSubjectItem.getPostId()) != null) {
            if (this.isFromDownloaded) {
                longValue = ep.e.f62097a.c(postId);
            } else {
                Long b11 = ep.c.f62095a.b(postId);
                longValue = b11 != null ? b11.longValue() : 0L;
            }
            Long valueOf = Long.valueOf(longValue);
            if (valueOf.longValue() <= 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                long longValue2 = valueOf.longValue();
                a.C0856a.v(lg.a.f68962a, "PostFeedVideo", "immvideo seek:" + longValue2, false, 4, null);
                com.transsion.player.orplayer.g gVar2 = this.orPlayer;
                if (gVar2 != null) {
                    gVar2.seekTo(longValue2);
                }
                z10 = true;
            }
            Long l11 = (Long) ImmVideoHelper.f48894h.a().j().get(postId);
            long longValue3 = l11 != null ? l11.longValue() : 0L;
            a.C0856a.f(lg.a.f68962a, this.TAG, "player- onPrepare, duration = " + this.viewBinding.f75905u.getMax() + ", progress = " + longValue3, false, 4, null);
            if (longValue3 > 0 && !z10) {
                this.currentSaveProgress = longValue3;
                int i11 = (int) longValue3;
                this.viewBinding.f75905u.setProgress(i11);
                this.viewBinding.f75907w.setProgress(i11);
                com.transsion.player.orplayer.g gVar3 = this.orPlayer;
                if (gVar3 != null) {
                    gVar3.seekTo(longValue3);
                }
            }
        }
        if (!this.isClickPause && !this.isPageHide && (fragment = this.fragment) != null && fragment.isVisible()) {
            a.C0856a.f(lg.a.f68962a, this.TAG, "player- onPrepare， play~", false, 4, null);
            com.transsion.player.orplayer.g gVar4 = this.orPlayer;
            if (gVar4 != null) {
                gVar4.play();
            }
        }
        setKeepScreenOn(true);
        j0();
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long progress, ao.e mediaSource) {
        if (this.isSeekToFinish.get() && !this.isHorizontalDragging) {
            com.transsion.postdetail.layer.b bVar = this.dotLayer;
            if (bVar != null) {
                bVar.l(progress);
            }
            int i11 = (int) progress;
            this.viewBinding.f75905u.setProgress(i11);
            this.viewBinding.f75907w.setProgress(i11);
            P(progress);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onRenderFirstFrame", false, 4, null);
        AppCompatImageView ivCover = this.viewBinding.f75893i;
        Intrinsics.g(ivCover, "ivCover");
        jg.c.g(ivCover);
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.m();
        }
        setLoading(false);
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        this.isPageRelease = false;
        this.isSeekToFinish.set(true);
        this.nextSeekTo = 0L;
        setLoading(true);
    }

    @Override // androidx.view.r
    public void onStateChanged(androidx.view.u source, Lifecycle.Event event) {
        String postId;
        String postId2;
        Lifecycle lifecycle;
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        int i11 = a.f49974a[event.ordinal()];
        if (i11 == 1) {
            this.isPageHide = true;
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, this.TAG, "player- onPause", false, 4, null);
            com.transsion.player.orplayer.g gVar = this.orPlayer;
            if (gVar != null) {
                gVar.pause();
            }
            PostSubjectItem postSubjectItem = this.data;
            if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null) {
                return;
            }
            a.C0856a.v(c0856a, "PostFeedVideo", "immvideo savePlayProgress:" + this.viewBinding.f75905u.getProgress(), false, 4, null);
            if (this.isFromDownloaded) {
                ep.e.f62097a.e(postId, this.viewBinding.f75905u.getProgress());
                return;
            } else {
                ep.c.f62095a.c(postId, this.viewBinding.f75905u.getProgress());
                return;
            }
        }
        if (i11 == 2) {
            this.isPageHide = false;
            if (this.isClickPause) {
                return;
            }
            Fragment fragment = this.fragment;
            if (fragment != null && !fragment.isVisible()) {
                post(new Runnable() { // from class: com.transsion.postdetail.ui.view.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImmVideoItemView.V(ImmVideoItemView.this);
                    }
                });
                return;
            }
            com.transsion.player.orplayer.g gVar2 = this.orPlayer;
            if (gVar2 != null) {
                gVar2.play();
                return;
            }
            return;
        }
        if (i11 == 3) {
            PostSubjectItem postSubjectItem2 = this.data;
            if (postSubjectItem2 == null || (postId2 = postSubjectItem2.getPostId()) == null) {
                return;
            }
            return;
        }
        if (i11 != 5) {
            return;
        }
        Fragment fragment2 = this.fragment;
        if (fragment2 != null && (lifecycle = fragment2.getLifecycle()) != null) {
            lifecycle.d(this);
        }
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.p();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.h(event, "event");
        GestureDetector gestureDetector = this.gestureDetector;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(event)) {
            return super.onTouchEvent(event);
        }
        return true;
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
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onVideoPause", false, 4, null);
        AppCompatImageView ivPause = this.viewBinding.f75898n;
        Intrinsics.g(ivPause, "ivPause");
        jg.c.k(ivPause);
        AppCompatSeekBar seekBar = this.viewBinding.f75907w;
        Intrinsics.g(seekBar, "seekBar");
        jg.c.k(seekBar);
        ProgressBar progressBar = this.viewBinding.f75905u;
        Intrinsics.g(progressBar, "progressBar");
        jg.c.g(progressBar);
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.n();
        }
        setKeepScreenOn(false);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        f.a.H(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e mediaSource) {
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onVideoStart", false, 4, null);
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.o();
        }
        AppCompatImageView ivPause = this.viewBinding.f75898n;
        Intrinsics.g(ivPause, "ivPause");
        jg.c.g(ivPause);
        AppCompatSeekBar seekBar = this.viewBinding.f75907w;
        Intrinsics.g(seekBar, "seekBar");
        jg.c.g(seekBar);
        setLoading(false);
        setKeepScreenOn(true);
        IAudioApi iAudioApi = this.audioApi;
        if (iAudioApi != null) {
            iAudioApi.pause();
        }
    }

    public final void setData(PostSubjectItem item, final Fragment fragment, Integer position, boolean videoLoadMore, String basePostId, String baseItemType, boolean attachToMain, String commentId, String pageFrom, boolean isFromDownloaded) {
        Long shareCount;
        Long commentCount;
        Integer subjectType;
        Intrinsics.h(item, "item");
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(commentId, "commentId");
        Intrinsics.h(pageFrom, "pageFrom");
        com.transsion.postdetail.layer.b bVar = new com.transsion.postdetail.layer.b();
        this.dotLayer = bVar;
        bVar.s(basePostId);
        com.transsion.postdetail.layer.b bVar2 = this.dotLayer;
        if (bVar2 != null) {
            bVar2.r(baseItemType);
        }
        com.transsion.postdetail.layer.b bVar3 = this.dotLayer;
        if (bVar3 != null) {
            String postId = item.getPostId();
            if (postId == null) {
                postId = "";
            }
            bVar3.x(postId, item);
        }
        com.transsion.postdetail.layer.b bVar4 = this.dotLayer;
        if (bVar4 != null) {
            Subject subject = item.getSubject();
            bVar4.y((subject == null || (subjectType = subject.getSubjectType()) == null) ? 0 : subjectType.intValue());
        }
        this.fragment = fragment;
        this.videoLoadMore = Boolean.valueOf(videoLoadMore);
        this.basePostId = basePostId;
        this.position = position;
        this.attachToMain = attachToMain;
        this.commentId = commentId;
        this.pageFrom = pageFrom;
        this.isFromDownloaded = isFromDownloaded;
        fragment.getLifecycle().a(this);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.videoDetailModel = Z(FragmentViewModelLazyKt.a(fragment, Reflection.b(PostDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$3
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
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }));
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.shortTvPlayListViewModel = a0(FragmentViewModelLazyKt.a(fragment, Reflection.b(ShortTvPlayListViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$6
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
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }));
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$7
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.mCommentViewModel = b0(FragmentViewModelLazyKt.a(fragment, Reflection.b(CommentViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$8
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$9
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
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }));
        this.data = item;
        p0(item);
        i0(item);
        Stat stat = item.getStat();
        long j11 = 0;
        e0((stat == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue());
        Stat stat2 = item.getStat();
        if (stat2 != null && (shareCount = stat2.getShareCount()) != null) {
            j11 = shareCount.longValue();
        }
        l0(j11);
        o0(item);
        f0(item);
        if (attachToMain) {
            ViewGroup.LayoutParams layoutParams = this.viewBinding.f75906v.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.b) {
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).bottomMargin = com.blankj.utilcode.util.a0.a(16.0f);
            }
        }
        m0();
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
        this.isSeekToFinish.set(true);
        long j11 = this.nextSeekTo;
        if (j11 > 0) {
            a.C0856a.r(lg.a.f68962a, this.TAG, new String[]{"seek OnSeekComplete，nextSeekTo:" + j11}, false, 4, null);
            com.transsion.player.orplayer.g gVar = this.orPlayer;
            if (gVar != null) {
                gVar.seekTo(this.nextSeekTo);
            }
            this.nextSeekTo = 0L;
        }
    }

    public final void setPagerLayoutManager(PagerLayoutManager pagerLayoutManager) {
        Intrinsics.h(pagerLayoutManager, "pagerLayoutManager");
        this.pagerLayoutManager = pagerLayoutManager;
    }

    public final void setPlayer(com.transsion.player.orplayer.g orPlayer, ORPlayerView orPlayerView) {
        Intrinsics.h(orPlayer, "orPlayer");
        Intrinsics.h(orPlayerView, "orPlayerView");
        this.orPlayer = orPlayer;
        this.orPlayerView = orPlayerView;
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.v(orPlayer);
        }
    }

    public final void setPosition(Integer num) {
        this.position = num;
    }

    public final void setVideoUrl(String url) {
        Intrinsics.h(url, "url");
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.A(url);
        }
    }

    public final void showCommentDialog() {
        FragmentManager childFragmentManager;
        Fragment fragment = this.fragment;
        if (fragment != null && (childFragmentManager = fragment.getChildFragmentManager()) != null) {
            ImmVideoCommentDialog b11 = ImmVideoCommentDialog.Companion.b(ImmVideoCommentDialog.INSTANCE, this.data, this.commentId, VideoFragment.PAGE_NAME, null, 8, null);
            this.commentDialog = b11;
            if (b11 != null) {
                b11.show(childFragmentManager, "immComment");
            }
        }
        ImmVideoCommentDialog immVideoCommentDialog = this.commentDialog;
        if (immVideoCommentDialog != null) {
            immVideoCommentDialog.A0(new f());
        }
        com.transsion.postdetail.helper.a.f48920a.e(this.data, VideoFragment.PAGE_NAME, this.pageFrom);
    }

    public final void videoStartPrepare(String pageFrom) {
        com.transsion.postdetail.layer.b bVar;
        this.pageFrom = pageFrom;
        if (pageFrom != null && (bVar = this.dotLayer) != null) {
            bVar.t(pageFrom);
        }
        com.transsion.postdetail.layer.b bVar2 = this.dotLayer;
        if (bVar2 != null) {
            bVar2.g();
        }
        com.transsion.postdetail.layer.b bVar3 = this.dotLayer;
        if (bVar3 != null) {
            bVar3.a(0, 0);
        }
        com.transsion.postdetail.layer.b bVar4 = this.dotLayer;
        if (bVar4 != null) {
            bVar4.w(this.position);
        }
    }
}
