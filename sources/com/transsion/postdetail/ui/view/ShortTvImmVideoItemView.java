package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.Lifecycle;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bumptech.glide.Glide;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.view.BLTextView;
import com.therouter.TheRouter;
import com.transsion.baseui.widget.f;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.postdetail.shorttv.ShortTvPlayListViewModel;
import com.transsion.push.PushConstants;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007*\u0002Ä\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B!\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0011JE\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010#\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J)\u0010.\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\t¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u001b2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u001f\u00107\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u00101\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u000fH\u0016¢\u0006\u0004\b9\u0010\u0011J\u0019\u0010<\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u000f¢\u0006\u0004\b>\u0010\u0011J\u0015\u0010@\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u0018¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u0018¢\u0006\u0004\bC\u0010AJ\u000f\u0010D\u001a\u00020\u000fH\u0016¢\u0006\u0004\bD\u0010\u0011J\u001f\u0010G\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u000fH\u0016¢\u0006\u0004\bI\u0010\u0011J\u0019\u0010J\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bJ\u0010=J\u0019\u0010K\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bK\u0010=J\u0019\u0010L\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bL\u0010=J!\u0010O\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020M2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bO\u0010PJ\u0019\u0010Q\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bQ\u0010=J\u0019\u0010R\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bR\u0010=J!\u0010U\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020S2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u000fH\u0016¢\u0006\u0004\bW\u0010\u0011J\u0019\u0010X\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bX\u0010=J\u0019\u0010Z\u001a\u00020\u000f2\b\u0010Y\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\bZ\u0010AJ\u000f\u0010[\u001a\u00020\u000fH\u0016¢\u0006\u0004\b[\u0010\u0011J\u0019\u0010]\u001a\u00020\u000f2\b\u0010\\\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b]\u0010^J\u0019\u0010`\u001a\u00020\u000f2\b\u0010_\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b`\u0010AJ\u0017\u0010a\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\ba\u0010\rJ\u0017\u0010b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\u000fH\u0002¢\u0006\u0004\bd\u0010\u0011J\u000f\u0010e\u001a\u00020\u000fH\u0002¢\u0006\u0004\be\u0010\u0011J/\u0010h\u001a\u00020\u000f2\b\u0010e\u001a\u0004\u0018\u00010\t2\b\u0010f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bh\u0010iJ\u0017\u0010k\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u001bH\u0002¢\u0006\u0004\bk\u0010lJ\u0017\u0010m\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bm\u0010nJ\u0017\u0010\\\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b\\\u0010^J\u0019\u0010p\u001a\u00020\u000f2\b\u0010o\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\bp\u0010AJ\u000f\u0010q\u001a\u00020\u000fH\u0002¢\u0006\u0004\bq\u0010\u0011J\u0017\u0010s\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020\u001bH\u0002¢\u0006\u0004\bs\u0010lR\u0014\u0010v\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010z\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010~\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bf\u0010\u008c\u0001R*\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010uR\u001a\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001b\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b`\u0010\u009c\u0001R\u001b\u0010 \u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bp\u0010\u009f\u0001R\"\u0010¥\u0001\u001a\u0005\u0018\u00010¡\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\ba\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R\u001b\u0010¨\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bq\u0010§\u0001R\u0019\u0010«\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010\u00ad\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010ª\u0001R\u0018\u0010®\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bm\u0010ª\u0001R\u0019\u0010±\u0001\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0016\u0010³\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\\\u0010²\u0001R\u0016\u0010´\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\be\u0010²\u0001R\u0017\u0010¶\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010²\u0001R\u0017\u0010¸\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010²\u0001R\u0017\u0010º\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010²\u0001R\u0016\u0010»\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bd\u0010²\u0001R\u0017\u0010?\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¼\u0001\u0010uR\u0018\u0010À\u0001\u001a\u00030½\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0018\u0010Á\u0001\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bh\u0010°\u0001R\u0018\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010ª\u0001R\u0018\u0010Ã\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bb\u0010ª\u0001R\u0018\u0010Ç\u0001\u001a\u00030Ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u0019\u0010É\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010ª\u0001¨\u0006Ê\u0001²\u0006\f\u0010~\u001a\u00020{8\nX\u008a\u0084\u0002²\u0006\r\u0010\u0082\u0001\u001a\u00020\u007f8\nX\u008a\u0084\u0002"}, d2 = {"Lcom/transsion/postdetail/ui/view/ShortTvImmVideoItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/transsion/player/orplayer/f;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/r;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Lcom/transsion/moviedetailapi/bean/Subject;", WebConstants.FIELD_ITEM, "Landroidx/fragment/app/Fragment;", "fragment", RequestParameters.POSITION, "", "basePostId", "baseItemType", "", "attachToMain", "setData", "(Lcom/transsion/moviedetailapi/bean/Subject;Landroidx/fragment/app/Fragment;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Z)V", "Lcom/transsion/player/orplayer/g;", "orPlayer", "Lcom/transsion/player/ui/ORPlayerView;", "orPlayerView", "setPlayer", "(Lcom/transsion/player/orplayer/g;Lcom/transsion/player/ui/ORPlayerView;)V", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "pagerLayoutManager", "setPagerLayoutManager", "(Lcom/transsion/shorttv/base/pager/PagerLayoutManager;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lcom/transsion/moviedetailapi/bean/Video;", "video", "maxHeight", "addVideoView", "(Landroid/view/View;Lcom/transsion/moviedetailapi/bean/Video;I)V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroidx/lifecycle/u;", EventConstants.KEY_SOURCE, "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged", "(Landroidx/lifecycle/u;Landroidx/lifecycle/Lifecycle$Event;)V", "onPlayerReset", "Lao/e;", "mediaSource", "onPlayerRelease", "(Lao/e;)V", "app2Background", "pageFrom", "videoStartPrepare", "(Ljava/lang/String;)V", "url", "setVideoUrl", "onSetDataSource", "width", "height", "onVideoSizeChanged", "(II)V", "onRenderFirstFrame", "onVideoStart", "onPrepare", "onVideoPause", "", NotificationCompat.CATEGORY_PROGRESS, "onProgress", "(JLao/e;)V", "onLoadingBegin", "onLoadingEnd", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lao/e;)V", "onLoopingStart", "onCompletion", "uuid", "onMediaItemTransition", "setOnSeekCompleteListener", "v", "onClick", "(Landroid/view/View;)V", NativeComponentConstants.KEY_COMPONENT_TYPE, "n", TtmlNode.TAG_P, "F", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "A", "w", "h", "rootHeight", "D", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", PushConstants.PUSH_SERVICE_TYPE_SHOW, "setLoading", "(Z)V", "t", "(J)V", "id", "o", CampaignEx.JSON_KEY_AD_Q, "visible", "setContentVisibility", "a", "Ljava/lang/String;", "TAG", "Lso/l0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lso/l0;", "viewBinding", "Lcom/transsion/postdetail/viewmodel/x;", "c", "Lcom/transsion/postdetail/viewmodel/x;", "videoDetailModel", "Lcom/transsion/postdetail/shorttv/ShortTvPlayListViewModel;", "d", "Lcom/transsion/postdetail/shorttv/ShortTvPlayListViewModel;", "shortTvPlayListViewModel", "Lcom/transsion/share/share/ShareDialogFragment;", "e", "Lcom/transsion/share/share/ShareDialogFragment;", "mShareDialog", "f", "Lcom/transsion/moviedetailapi/bean/Subject;", "data", be.g.f16474b, "Landroidx/fragment/app/Fragment;", "Ljava/lang/Boolean;", "videoLoadMore", "i", "Ljava/lang/Integer;", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", com.mbridge.msdk.foundation.same.report.j.f35620b, CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/player/orplayer/g;", "l", "Lcom/transsion/player/ui/ORPlayerView;", "m", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "Lcom/transsion/postdetail/ui/view/ImmVideoGuideView;", "Lcom/transsion/postdetail/ui/view/ImmVideoGuideView;", "guideView", "Landroid/view/GestureDetector;", "Landroid/view/GestureDetector;", "gestureDetector", "Lcom/transsnet/loginapi/ILoginApi;", "Lkotlin/Lazy;", "getLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "loginApi", "Lcom/transsion/postdetail/layer/b;", "Lcom/transsion/postdetail/layer/b;", "dotLayer", CampaignEx.JSON_KEY_AD_R, "Z", "isClickPause", "s", "isHorizontalDragging", "isPageHide", TmcStartParams.KEY_URL_SHORT, "J", "currentSaveProgress", "I", "resImgLargeWidth", "resImgLargeHeight", "x", "resImgSmallWidth", "y", "resImgSmallHeight", "z", "screenHeight", "dp170", "B", "Ljava/util/concurrent/atomic/AtomicBoolean;", "C", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isSeekToFinish", "nextSeekTo", "E", "isPageRelease", "com/transsion/postdetail/ui/view/ShortTvImmVideoItemView$b", "G", "Lcom/transsion/postdetail/ui/view/ShortTvImmVideoItemView$b;", "favoriteResultObserver", "H", "isPrepare", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTvImmVideoItemView extends ConstraintLayout implements com.transsion.player.orplayer.f, View.OnClickListener, androidx.view.r {

    /* renamed from: A, reason: from kotlin metadata */
    private final int dp170;

    /* renamed from: B, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: C, reason: from kotlin metadata */
    private final AtomicBoolean isSeekToFinish;

    /* renamed from: D, reason: from kotlin metadata */
    private long nextSeekTo;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean attachToMain;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isPageRelease;

    /* renamed from: G, reason: from kotlin metadata */
    private final b favoriteResultObserver;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isPrepare;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final so.l0 viewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.transsion.postdetail.viewmodel.x videoDetailModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ShortTvPlayListViewModel shortTvPlayListViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ShareDialogFragment mShareDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Subject data;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Fragment fragment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Boolean videoLoadMore;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Integer position;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String basePostId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private com.transsion.player.orplayer.g orPlayer;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private ORPlayerView orPlayerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private PagerLayoutManager pagerLayoutManager;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private ImmVideoGuideView guideView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private GestureDetector gestureDetector;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Lazy loginApi;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private com.transsion.postdetail.layer.b dotLayer;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean isClickPause;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isHorizontalDragging;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean isPageHide;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private long currentSaveProgress;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final int resImgLargeWidth;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final int resImgLargeHeight;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final int resImgSmallWidth;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final int resImgSmallHeight;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final int screenHeight;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50097a;

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
            f50097a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements androidx.view.c0 {

        /* renamed from: a, reason: collision with root package name */
        private String f50098a;

        b() {
        }

        @Override // androidx.view.c0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            if (Intrinsics.c(this.f50098a, str)) {
                return;
            }
            ShortTvImmVideoItemView.this.n(str);
        }

        public final void b(String str) {
            this.f50098a = str;
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
        public boolean onSingleTapUp(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            ShortTvImmVideoItemView.this.w();
            return super.onSingleTapUp(e11);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements f.a {

        /* renamed from: a, reason: collision with root package name */
        private int f50101a;

        /* renamed from: b, reason: collision with root package name */
        private int f50102b;

        /* renamed from: c, reason: collision with root package name */
        private int f50103c;

        /* renamed from: d, reason: collision with root package name */
        private String f50104d = "";

        /* renamed from: e, reason: collision with root package name */
        private int f50105e = com.blankj.utilcode.util.a0.a(1.5f);

        d() {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void a() {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void b(float f11, float f12) {
            if (!ShortTvImmVideoItemView.this.isHorizontalDragging) {
                PagerLayoutManager pagerLayoutManager = ShortTvImmVideoItemView.this.pagerLayoutManager;
                if (pagerLayoutManager != null) {
                    pagerLayoutManager.W(false);
                }
                this.f50101a = ShortTvImmVideoItemView.this.viewBinding.f75726m.getProgress();
                ShortTvImmVideoItemView.this.setContentVisibility(false);
                AppCompatTextView tvProgressDes = ShortTvImmVideoItemView.this.viewBinding.f75733t;
                Intrinsics.g(tvProgressDes, "tvProgressDes");
                jg.c.k(tvProgressDes);
                AppCompatSeekBar seekBar = ShortTvImmVideoItemView.this.viewBinding.f75728o;
                Intrinsics.g(seekBar, "seekBar");
                jg.c.k(seekBar);
                ProgressBar progressBar = ShortTvImmVideoItemView.this.viewBinding.f75726m;
                Intrinsics.g(progressBar, "progressBar");
                jg.c.g(progressBar);
                this.f50103c = ShortTvImmVideoItemView.this.viewBinding.f75726m.getWidth();
                int max = ShortTvImmVideoItemView.this.viewBinding.f75726m.getMax();
                this.f50102b = max;
                this.f50104d = com.transsion.postdetail.util.n.c(max);
            }
            ShortTvImmVideoItemView.this.isHorizontalDragging = true;
            float f13 = f12 - f11;
            int i11 = this.f50102b;
            int i12 = (int) (this.f50101a + ((f13 * i11) / this.f50103c));
            int i13 = i12 >= 0 ? i12 > i11 ? i11 : i12 : 0;
            ShortTvImmVideoItemView.this.viewBinding.f75733t.setText(com.transsion.postdetail.util.n.c(i13) + " / " + this.f50104d);
            ShortTvImmVideoItemView.this.viewBinding.f75726m.setProgress(i13);
            ShortTvImmVideoItemView.this.viewBinding.f75728o.setProgress(i13);
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
            PagerLayoutManager pagerLayoutManager = ShortTvImmVideoItemView.this.pagerLayoutManager;
            if (pagerLayoutManager != null) {
                pagerLayoutManager.W(true);
            }
            if (ShortTvImmVideoItemView.this.isHorizontalDragging) {
                ShortTvImmVideoItemView.this.isHorizontalDragging = false;
                ShortTvImmVideoItemView.this.setContentVisibility(true);
                AppCompatTextView tvProgressDes = ShortTvImmVideoItemView.this.viewBinding.f75733t;
                Intrinsics.g(tvProgressDes, "tvProgressDes");
                jg.c.g(tvProgressDes);
                AppCompatSeekBar seekBar = ShortTvImmVideoItemView.this.viewBinding.f75728o;
                Intrinsics.g(seekBar, "seekBar");
                jg.c.g(seekBar);
                ProgressBar progressBar = ShortTvImmVideoItemView.this.viewBinding.f75726m;
                Intrinsics.g(progressBar, "progressBar");
                jg.c.k(progressBar);
                long progress = ShortTvImmVideoItemView.this.viewBinding.f75726m.getProgress();
                ShortTvImmVideoItemView shortTvImmVideoItemView = ShortTvImmVideoItemView.this;
                if (shortTvImmVideoItemView.isSeekToFinish.compareAndSet(true, false)) {
                    com.transsion.player.orplayer.g gVar2 = ShortTvImmVideoItemView.this.orPlayer;
                    if (gVar2 != null) {
                        gVar2.seekTo(progress);
                    }
                    progress = 0;
                }
                shortTvImmVideoItemView.nextSeekTo = progress;
                com.transsion.player.orplayer.g gVar3 = ShortTvImmVideoItemView.this.orPlayer;
                if (gVar3 == null || gVar3.isPlaying() || (gVar = ShortTvImmVideoItemView.this.orPlayer) == null) {
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
        e() {
        }

        @Override // com.transsion.share.share.a
        public void a(String id2, PostType postType) {
            Intrinsics.h(id2, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            ShortTvImmVideoItemView.this.o(str);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvImmVideoItemView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvImmVideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvImmVideoItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.TAG = "ImmVideoPlayer";
        this.loginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.view.b2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi s11;
                s11 = ShortTvImmVideoItemView.s();
                return s11;
            }
        });
        this.screenHeight = com.blankj.utilcode.util.y.c();
        this.dp170 = com.blankj.utilcode.util.a0.a(170.0f);
        this.pageFrom = "";
        this.isSeekToFinish = new AtomicBoolean(true);
        this.attachToMain = true;
        this.favoriteResultObserver = new b();
        View.inflate(getContext(), R$layout.layout_short_tv_immersion_video_item_view, this);
        so.l0 a11 = so.l0.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
        a11.f75732s.setOnClickListener(this);
        a11.f75722i.setOnClickListener(this);
        a11.f75724k.setOnClickListener(this);
        a11.f75734u.setOnClickListener(this);
        a11.f75720g.setOnClickListener(this);
        a11.f75723j.setOnClickListener(this);
        a11.f75735v.setOnClickListener(this);
        a11.f75730q.setOnClickListener(this);
        this.resImgLargeWidth = com.blankj.utilcode.util.a0.a(48.0f);
        this.resImgLargeHeight = com.blankj.utilcode.util.a0.a(64.0f);
        this.resImgSmallWidth = com.blankj.utilcode.util.a0.a(24.0f);
        this.resImgSmallHeight = com.blankj.utilcode.util.a0.a(32.0f);
        p(context);
        if (ShortTvImmVideoHelper.f48908k.a().m() > 0) {
            ViewGroup.LayoutParams layoutParams = a11.f75727n.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (((ViewGroup.MarginLayoutParams) bVar).bottomMargin < com.blankj.utilcode.util.a0.a(35.0f)) {
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin += com.blankj.utilcode.util.a0.a(10.0f);
                a11.f75727n.setLayoutParams(bVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v43, types: [T, com.transsion.moviedetailapi.bean.ShortTVFavInfo] */
    private final void A() {
        Cover cover;
        String url;
        Fragment fragment;
        FragmentActivity activity;
        String str;
        Cover cover2;
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        ShapeableImageView ivVideoAvatar = this.viewBinding.f75724k;
        Intrinsics.g(ivVideoAvatar, "ivVideoAvatar");
        jg.c.g(ivVideoAvatar);
        AppCompatImageView ivDownload = this.viewBinding.f75720g;
        Intrinsics.g(ivDownload, "ivDownload");
        jg.c.k(ivDownload);
        AppCompatTextView tvTitle = this.viewBinding.f75735v;
        Intrinsics.g(tvTitle, "tvTitle");
        jg.c.k(tvTitle);
        BLTextView tvShortTvEp = this.viewBinding.f75734u;
        Intrinsics.g(tvShortTvEp, "tvShortTvEp");
        jg.c.k(tvShortTvEp);
        ShapeableImageView ivShortCover = this.viewBinding.f75723j;
        Intrinsics.g(ivShortCover, "ivShortCover");
        jg.c.k(ivShortCover);
        AppCompatTextView appCompatTextView = this.viewBinding.f75735v;
        Subject subject = this.data;
        appCompatTextView.setText(subject != null ? subject.getTitle() : null);
        com.transsion.postdetail.util.t tVar = com.transsion.postdetail.util.t.f50233a;
        Subject subject2 = this.data;
        String a11 = tVar.a(Integer.valueOf(subject2 != null ? subject2.getTotalEpisode() : 0));
        AppCompatTextView appCompatTextView2 = this.viewBinding.f75730q;
        Subject subject3 = this.data;
        appCompatTextView2.setText(subject3 != null ? subject3.getDescription() : null);
        this.viewBinding.f75734u.setText(getContext().getString(R$string.short_tv_play_all, a11));
        com.transsion.baseui.widget.jumpingbeans.a.a(this.viewBinding.f75734u).e(0, this.viewBinding.f75734u.getText().toString().length()).g(true).i(100).f(0.05f).h(10000).a();
        ShapeableImageView shapeableImageView = this.viewBinding.f75723j;
        Subject subject4 = this.data;
        if (subject4 == null || !subject4.getBuiltIn()) {
            Subject subject5 = this.data;
            if (subject5 != null && (cover = subject5.getCover()) != null && (url = cover.getUrl()) != null && (fragment = this.fragment) != null && (activity = fragment.getActivity()) != null && !activity.isFinishing()) {
                f.b c11 = ej.f.f62005a.m(activity).g(url).m(com.blankj.utilcode.util.i.e(21.0f)).c(com.blankj.utilcode.util.i.e(30.0f));
                Subject subject6 = this.data;
                if (subject6 == null || (cover2 = subject6.getCover()) == null || (str = cover2.getThumbnail()) == null) {
                    str = "";
                }
                f.b h11 = c11.l(str).h(true);
                ShapeableImageView ivShortCover2 = this.viewBinding.f75723j;
                Intrinsics.g(ivShortCover2, "ivShortCover");
                h11.d(ivShortCover2);
            }
        } else {
            kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), null, null, new ShortTvImmVideoItemView$updateShortTVInfo$1(this, null), 3, null);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Subject subject7 = this.data;
        T shortTVFavInfo = subject7 != null ? subject7.getShortTVFavInfo() : 0;
        objectRef.element = shortTVFavInfo;
        if (shortTVFavInfo == 0) {
            ?? shortTVFavInfo2 = new ShortTVFavInfo(null, false, null, 7, null);
            shortTVFavInfo2.setFavoriteNum("0");
            objectRef.element = shortTVFavInfo2;
            Subject subject8 = this.data;
            if (subject8 != 0) {
                subject8.setShortTVFavInfo(shortTVFavInfo2);
            }
        }
        AppCompatTextView tvFavorite = this.viewBinding.f75731r;
        Intrinsics.g(tvFavorite, "tvFavorite");
        jg.c.k(tvFavorite);
        this.viewBinding.f75731r.setSelected(((ShortTVFavInfo) objectRef.element).getHasFavorite());
        AppCompatTextView appCompatTextView3 = this.viewBinding.f75731r;
        String favoriteNum = ((ShortTVFavInfo) objectRef.element).getFavoriteNum();
        appCompatTextView3.setText(com.transsion.baseui.util.j.a(Long.parseLong(favoriteNum != null ? favoriteNum : "0")));
        this.viewBinding.f75731r.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvImmVideoItemView.B(ShortTvImmVideoItemView.this, objectRef, view);
            }
        });
        Context context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.z1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit C;
                C = ShortTvImmVideoItemView.C(ShortTvImmVideoItemView.this, (uy.c) obj);
                return C;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = uy.c.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
        Subject subject9 = this.data;
        if (subject9 == null || (shortTVFirstEp = subject9.getShortTVFirstEp()) == null || (video = shortTVFirstEp.getVideo()) == null || (videoAddress = video.getVideoAddress()) == null) {
            return;
        }
        E(this, videoAddress.getWidth(), videoAddress.getHeight(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void B(ShortTvImmVideoItemView shortTvImmVideoItemView, Ref.ObjectRef objectRef, View view) {
        ShortTvPlayListViewModel shortTvPlayListViewModel;
        com.transsion.postdetail.shorttv.k kVar = com.transsion.postdetail.shorttv.k.f49278a;
        Subject subject = shortTvImmVideoItemView.data;
        String subjectId = subject != null ? subject.getSubjectId() : null;
        Subject subject2 = shortTvImmVideoItemView.data;
        com.transsion.postdetail.shorttv.k.d(kVar, subjectId, subject2 != null ? subject2.getOps() : null, "", ((ShortTVFavInfo) objectRef.element).getHasFavorite(), "shorttv_detail_video", null, 32, null);
        Subject subject3 = shortTvImmVideoItemView.data;
        if (subject3 == null || (shortTvPlayListViewModel = shortTvImmVideoItemView.shortTvPlayListViewModel) == null) {
            return;
        }
        shortTvPlayListViewModel.d(subject3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(ShortTvImmVideoItemView shortTvImmVideoItemView, uy.c value) {
        String c11;
        Subject subject;
        String str;
        ShortTVFavInfo shortTVFavInfo;
        ShortTVFavInfo shortTVFavInfo2;
        Intrinsics.h(value, "value");
        try {
            c11 = value.c();
            subject = shortTvImmVideoItemView.data;
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        if (!Intrinsics.c(c11, subject != null ? subject.getSubjectId() : null)) {
            return Unit.f67184a;
        }
        Subject subject2 = shortTvImmVideoItemView.data;
        if (subject2 != null && (shortTVFavInfo2 = subject2.getShortTVFavInfo()) != null) {
            shortTVFavInfo2.update(value);
        }
        AppCompatTextView appCompatTextView = shortTvImmVideoItemView.viewBinding.f75731r;
        Subject subject3 = shortTvImmVideoItemView.data;
        if (subject3 == null || (shortTVFavInfo = subject3.getShortTVFavInfo()) == null || (str = shortTVFavInfo.getFavoriteNum()) == null) {
            str = "0";
        }
        appCompatTextView.setText(com.transsion.baseui.util.j.a(Long.parseLong(str)));
        shortTvImmVideoItemView.viewBinding.f75731r.setSelected(value.a());
        return Unit.f67184a;
    }

    private final void D(Integer w11, Integer h11, Integer rootHeight) {
        int e11;
        if (w11 == null || rootHeight == null || h11 == null || w11.intValue() == 0) {
            return;
        }
        FrameLayout flContainer = this.viewBinding.f75717d;
        Intrinsics.g(flContainer, "flContainer");
        ViewGroup.LayoutParams layoutParams = flContainer.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        int intValue = (h11.intValue() * com.blankj.utilcode.util.y.e()) / w11.intValue();
        if (RangesKt.t(1, intValue).o(rootHeight.intValue())) {
            e11 = (rootHeight.intValue() * w11.intValue()) / h11.intValue();
            intValue = rootHeight.intValue();
        } else {
            e11 = com.blankj.utilcode.util.y.e();
        }
        if (e11 != ((ViewGroup.MarginLayoutParams) bVar).width || intValue != ((ViewGroup.MarginLayoutParams) bVar).height) {
            ((ViewGroup.MarginLayoutParams) bVar).width = e11;
            ((ViewGroup.MarginLayoutParams) bVar).height = intValue;
        }
        flContainer.setLayoutParams(bVar);
    }

    static /* synthetic */ void E(ShortTvImmVideoItemView shortTvImmVideoItemView, Integer num, Integer num2, Integer num3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            ViewGroup viewGroup = (ViewGroup) shortTvImmVideoItemView.viewBinding.getRoot().getParent();
            num3 = viewGroup != null ? Integer.valueOf(viewGroup.getHeight()) : null;
        }
        shortTvImmVideoItemView.D(num, num2, num3);
    }

    private final void F(Subject item) {
        Media video;
        Cover cover;
        String url;
        Fragment fragment;
        FragmentActivity activity;
        Media video2;
        Cover cover2;
        if (!item.getBuiltIn()) {
            ShortTVItem shortTVFirstEp = item.getShortTVFirstEp();
            if (shortTVFirstEp == null || (video = shortTVFirstEp.getVideo()) == null || (cover = video.getCover()) == null || (url = cover.getUrl()) == null || (fragment = this.fragment) == null || (activity = fragment.getActivity()) == null || activity.isFinishing()) {
                return;
            }
            Glide.with(activity).load2(f.a.e(ej.f.f62005a, url, jn.b.f66360e.a(), false, false, 12, null)).into(this.viewBinding.f75719f);
            return;
        }
        String str = null;
        kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), null, null, new ShortTvImmVideoItemView$updateVideoInfo$1(item, this, null), 3, null);
        a.C0856a c0856a = lg.a.f68962a;
        String str2 = this.TAG;
        ShortTVItem shortTVFirstEp2 = item.getShortTVFirstEp();
        if (shortTVFirstEp2 != null && (video2 = shortTVFirstEp2.getVideo()) != null && (cover2 = video2.getCover()) != null) {
            str = cover2.getUrl();
        }
        a.C0856a.f(c0856a, str2, "set info - cover = " + str, false, 4, null);
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.loginApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(java.lang.String r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView.n(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String id2) {
        androidx.view.b0 o11;
        a.C0856a.r(lg.a.f68962a, this.TAG, new String[]{"finishAfterReport, position = " + this.position}, false, 4, null);
        com.transsion.postdetail.viewmodel.x xVar = this.videoDetailModel;
        if (xVar == null || (o11 = xVar.o()) == null) {
            return;
        }
        o11.q(this.position);
    }

    private final void p(Context context) {
        this.gestureDetector = new GestureDetector(context, new c());
        q();
    }

    private final void q() {
        new com.transsion.baseui.widget.f(getContext(), this.viewBinding.f75737x).s(new d());
        this.viewBinding.f75728o.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.postdetail.ui.view.d2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean r11;
                r11 = ShortTvImmVideoItemView.r(view, motionEvent);
                return r11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi s() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setContentVisibility(boolean visible) {
        Group groupContent = this.viewBinding.f75718e;
        Intrinsics.g(groupContent, "groupContent");
        groupContent.setVisibility(visible ? 0 : 8);
    }

    public static /* synthetic */ void setData$default(ShortTvImmVideoItemView shortTvImmVideoItemView, Subject subject, Fragment fragment, Integer num, String str, String str2, boolean z10, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            z10 = false;
        }
        shortTvImmVideoItemView.setData(subject, fragment, num, str, str2, z10);
    }

    private final void setLoading(boolean show) {
        a.C0856a.l(lg.a.f68962a, "yy", "setLoading:" + show + "  " + this, false, 4, null);
        if (show) {
            ClipLoading clLoading = this.viewBinding.f75716c;
            Intrinsics.g(clLoading, "clLoading");
            jg.c.k(clLoading);
            ProgressBar progressBar = this.viewBinding.f75726m;
            Intrinsics.g(progressBar, "progressBar");
            jg.c.g(progressBar);
            this.viewBinding.f75716c.start();
            return;
        }
        ProgressBar progressBar2 = this.viewBinding.f75726m;
        Intrinsics.g(progressBar2, "progressBar");
        jg.c.k(progressBar2);
        ClipLoading clLoading2 = this.viewBinding.f75716c;
        Intrinsics.g(clLoading2, "clLoading");
        jg.c.g(clLoading2);
        this.viewBinding.f75716c.stop();
    }

    private final void t(long progress) {
        if (Intrinsics.c(this.videoLoadMore, Boolean.TRUE)) {
            ShortTvImmVideoHelper.a aVar = ShortTvImmVideoHelper.f48908k;
            if (!aVar.a().s() || progress < 1000) {
                return;
            }
            aVar.a().A();
            ImmVideoGuideView a11 = ImmVideoGuideView.INSTANCE.a(this);
            a11.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.view.c2
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvImmVideoItemView.u(ShortTvImmVideoItemView.this);
                }
            }, 5000L);
            this.guideView = a11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ShortTvImmVideoItemView shortTvImmVideoItemView) {
        ImmVideoGuideView immVideoGuideView = shortTvImmVideoItemView.guideView;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
    }

    private final void v(View view) {
        Fragment fragment;
        FragmentManager childFragmentManager;
        ShareDialogFragment shareDialogFragment;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        if (this.mShareDialog == null) {
            ILoginApi loginApi = getLoginApi();
            if (loginApi != null) {
                loginApi.i();
            }
            ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
            PostType postType = PostType.SHORT_TV_TYPE;
            Subject subject = this.data;
            String subjectId = subject != null ? subject.getSubjectId() : null;
            String value = ReportType.SUBJECT.getValue();
            Subject subject2 = this.data;
            String title = subject2 != null ? subject2.getTitle() : null;
            Subject subject3 = this.data;
            ShareDialogFragment a11 = companion.a(postType, subjectId, "", value, title, "", false, false, false, "postdetail", subject3 != null ? subject3.getOps() : null, view.getContext().getString(R$string.save_video));
            this.mShareDialog = a11;
            if (a11 != null) {
                a11.G0(new e());
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
    public final void w() {
        ClipLoading clLoading = this.viewBinding.f75716c;
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
    public static final void x(ShortTvImmVideoItemView shortTvImmVideoItemView) {
        com.transsion.player.orplayer.g gVar;
        Fragment fragment = shortTvImmVideoItemView.fragment;
        if (fragment == null || !fragment.isVisible() || (gVar = shortTvImmVideoItemView.orPlayer) == null) {
            return;
        }
        gVar.play();
    }

    private static final com.transsion.postdetail.viewmodel.x y(Lazy lazy) {
        return (com.transsion.postdetail.viewmodel.x) lazy.getValue();
    }

    private static final ShortTvPlayListViewModel z(Lazy lazy) {
        return (ShortTvPlayListViewModel) lazy.getValue();
    }

    public final void addVideoView(View view, Video video, int maxHeight) {
        if (view == null) {
            return;
        }
        this.viewBinding.f75717d.addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (video != null) {
            D(video.getWidth(), video.getHeight(), Integer.valueOf(maxHeight));
        }
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
        androidx.view.b0 f11;
        androidx.view.b0 f12;
        super.onAttachedToWindow();
        Fragment fragment = this.fragment;
        if (fragment == null || (viewLifecycleOwner = fragment.getViewLifecycleOwner()) == null) {
            return;
        }
        b bVar = this.favoriteResultObserver;
        ShortTvPlayListViewModel shortTvPlayListViewModel = this.shortTvPlayListViewModel;
        bVar.b((shortTvPlayListViewModel == null || (f12 = shortTvPlayListViewModel.f()) == null) ? null : (String) f12.f());
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = this.shortTvPlayListViewModel;
        if (shortTvPlayListViewModel2 == null || (f11 = shortTvPlayListViewModel2.f()) == null) {
            return;
        }
        f11.j(viewLifecycleOwner, this.favoriteResultObserver);
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        f.a.d(this, j11, eVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v11) {
        Integer valueOf = v11 != null ? Integer.valueOf(v11.getId()) : null;
        int i11 = R$id.iv_share;
        if (valueOf != null && valueOf.intValue() == i11) {
            v(v11);
            return;
        }
        int i12 = R$id.tv_short_tv_ep;
        if (valueOf != null && valueOf.intValue() == i12) {
            Fragment fragment = this.fragment;
            if (fragment != null) {
                fragment.getContext();
                return;
            }
            return;
        }
        int i13 = R$id.iv_download;
        if (valueOf == null || valueOf.intValue() != i13) {
            int i14 = R$id.iv_short_cover;
            if (valueOf == null || valueOf.intValue() != i14) {
                int i15 = R$id.tv_title;
                if (valueOf == null || valueOf.intValue() != i15) {
                    int i16 = R$id.tv_desc;
                    if (valueOf == null || valueOf.intValue() != i16) {
                        return;
                    }
                }
            }
        }
        DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
        Context context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        Subject subject = this.data;
        a11.d0(fragmentActivity, "shorttv_detail_video", (r22 & 4) != 0 ? "" : "", subject != null ? subject.getOps() : null, (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : v11.getId() == R$id.iv_download, (r22 & 64) != 0 ? null : this.data, (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : Boolean.valueOf(v11.getId() != R$id.iv_download));
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e mediaSource) {
        Fragment fragment;
        Subject subject;
        ShortTVItem shortTVFirstEp;
        a.C0856a.r(lg.a.f68962a, this.TAG, new String[]{"player- onCompletion"}, false, 4, null);
        Subject subject2 = this.data;
        if (subject2 != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value || (fragment = this.fragment) == null || fragment.getContext() == null || (subject = this.data) == null || subject.getDeleted()) {
                return;
            }
            com.transsion.postdetail.layer.b bVar = this.dotLayer;
            if (bVar != null) {
                bVar.d(false);
            }
            Trailer trailer = subject.getTrailer();
            if ((trailer != null ? trailer.getVideoAddress() : null) == null && (shortTVFirstEp = subject.getShortTVFirstEp()) != null) {
                shortTVFirstEp.getEp();
            }
            com.transsion.player.orplayer.g gVar = this.orPlayer;
            if (gVar != null) {
                gVar.seekTo(0L);
            }
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
        if (shortTvPlayListViewModel2 == null || (f11 = shortTvPlayListViewModel2.f()) == null) {
            return;
        }
        f11.o(this.favoriteResultObserver);
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
    public void onMediaItemTransition(String uuid) {
        Fragment fragment;
        Subject subject;
        ShortTVItem shortTVFirstEp;
        f.a.p(this, uuid);
        Subject subject2 = this.data;
        if (subject2 != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value || (fragment = this.fragment) == null || fragment.getContext() == null || (subject = this.data) == null) {
                return;
            }
            com.transsion.postdetail.layer.b bVar = this.dotLayer;
            if (bVar != null) {
                bVar.d(false);
            }
            Trailer trailer = subject.getTrailer();
            if ((trailer != null ? trailer.getVideoAddress() : null) == null && (shortTVFirstEp = subject.getShortTVFirstEp()) != null) {
                shortTVFirstEp.getEp();
            }
            com.transsion.player.orplayer.g gVar = this.orPlayer;
            if (gVar != null) {
                gVar.pause();
            }
        }
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
        String a11;
        com.transsion.player.orplayer.g gVar;
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        String url;
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onPlayerReset", false, 4, null);
        this.isPrepare = false;
        this.isPageRelease = true;
        this.isSeekToFinish.set(true);
        this.nextSeekTo = 0L;
        setKeepScreenOn(false);
        this.isClickPause = false;
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            com.transsion.postdetail.layer.b.e(bVar, false, 1, null);
        }
        Subject subject = this.data;
        if (subject != null && (shortTVFirstEp = subject.getShortTVFirstEp()) != null && (video = shortTVFirstEp.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
        }
        com.transsion.player.orplayer.g gVar2 = this.orPlayer;
        if (gVar2 != null) {
            gVar2.removePlayerListener(this);
        }
        Subject subject2 = this.data;
        if (subject2 != null && subject2.getDeleted() && (a11 = com.transsion.postdetail.control.a.f48892o.a(subject2)) != null && (gVar = this.orPlayer) != null) {
            ShortTVItem shortTVFirstEp2 = subject2.getShortTVFirstEp();
            gVar.removeDataSource(new ao.e(shortTVFirstEp2 != null ? shortTVFirstEp2.getId() : null, a11, 0, null, null, 24, null));
        }
        AppCompatImageView ivCover = this.viewBinding.f75719f;
        Intrinsics.g(ivCover, "ivCover");
        jg.c.k(ivCover);
        AppCompatImageView ivPause = this.viewBinding.f75721h;
        Intrinsics.g(ivPause, "ivPause");
        jg.c.g(ivPause);
        AppCompatSeekBar seekBar = this.viewBinding.f75728o;
        Intrinsics.g(seekBar, "seekBar");
        jg.c.g(seekBar);
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
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        String url;
        if (this.isPrepare) {
            return;
        }
        this.isPrepare = true;
        com.transsion.player.orplayer.g gVar = this.orPlayer;
        int duration = gVar != null ? (int) gVar.getDuration() : 0;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.g(c0856a, "shorttv.here.duration: " + duration, false, 2, null);
        this.viewBinding.f75726m.setMax(duration);
        this.viewBinding.f75728o.setMax(duration);
        Subject subject = this.data;
        if (subject != null && (shortTVFirstEp = subject.getShortTVFirstEp()) != null && (video = shortTVFirstEp.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
            Long l11 = (Long) ShortTvImmVideoHelper.f48908k.a().o().get(url);
            long longValue = l11 != null ? l11.longValue() : 0L;
            a.C0856a.f(c0856a, this.TAG, "player- onPrepare, duration = " + this.viewBinding.f75726m.getMax() + ", progress = " + longValue, false, 4, null);
            if (longValue >= 0) {
                this.currentSaveProgress = longValue;
                int i11 = (int) longValue;
                this.viewBinding.f75726m.setProgress(i11);
                this.viewBinding.f75728o.setProgress(i11);
                com.transsion.player.orplayer.g gVar2 = this.orPlayer;
                if (gVar2 != null) {
                    gVar2.seekTo(longValue);
                }
            }
        }
        if (!this.isClickPause && !this.isPageHide && (fragment = this.fragment) != null && fragment.isVisible()) {
            a.C0856a.f(c0856a, this.TAG, "player- onPrepare， play~", false, 4, null);
            com.transsion.player.orplayer.g gVar3 = this.orPlayer;
            if (gVar3 != null) {
                gVar3.play();
            }
        }
        setKeepScreenOn(true);
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long progress, ao.e mediaSource) {
        ShortTVItem shortTVFirstEp;
        if (this.isSeekToFinish.get() && !this.isHorizontalDragging) {
            if (ap.b.f16171a.b() && mediaSource != null) {
                String e11 = mediaSource.e();
                Subject subject = this.data;
                if (!Intrinsics.c(e11, (subject == null || (shortTVFirstEp = subject.getShortTVFirstEp()) == null) ? null : shortTVFirstEp.getId())) {
                    a.C0856a.f(lg.a.f68962a, this.TAG, "onProgress- vid 不同, return", false, 4, null);
                    return;
                }
            }
            com.transsion.postdetail.layer.b bVar = this.dotLayer;
            if (bVar != null) {
                bVar.l(progress);
            }
            int i11 = (int) progress;
            this.viewBinding.f75726m.setProgress(i11);
            this.viewBinding.f75728o.setProgress(i11);
            t(progress);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onRenderFirstFrame", false, 4, null);
        AppCompatImageView ivCover = this.viewBinding.f75719f;
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
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        String url;
        Lifecycle lifecycle;
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        int i11 = a.f50097a[event.ordinal()];
        if (i11 == 1) {
            this.isPageHide = true;
            a.C0856a.f(lg.a.f68962a, this.TAG, "player- onPause", false, 4, null);
            com.transsion.player.orplayer.g gVar = this.orPlayer;
            if (gVar != null) {
                gVar.pause();
                return;
            }
            return;
        }
        if (i11 == 2) {
            this.isPageHide = false;
            if (this.isClickPause) {
                return;
            }
            Fragment fragment = this.fragment;
            if (fragment != null && !fragment.isVisible()) {
                post(new Runnable() { // from class: com.transsion.postdetail.ui.view.a2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShortTvImmVideoItemView.x(ShortTvImmVideoItemView.this);
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
            Subject subject = this.data;
            if (subject == null || (shortTVFirstEp = subject.getShortTVFirstEp()) == null || (video = shortTVFirstEp.getVideo()) == null || (videoAddress = video.getVideoAddress()) == null || (url = videoAddress.getUrl()) == null) {
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
        AppCompatImageView ivPause = this.viewBinding.f75721h;
        Intrinsics.g(ivPause, "ivPause");
        jg.c.k(ivPause);
        AppCompatSeekBar seekBar = this.viewBinding.f75728o;
        Intrinsics.g(seekBar, "seekBar");
        jg.c.k(seekBar);
        ProgressBar progressBar = this.viewBinding.f75726m;
        Intrinsics.g(progressBar, "progressBar");
        jg.c.g(progressBar);
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.n();
        }
        setKeepScreenOn(false);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int width, int height) {
        f.a.H(this, width, height);
        E(this, Integer.valueOf(width), Integer.valueOf(height), null, 4, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e mediaSource) {
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onVideoStart", false, 4, null);
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
            bVar.o();
        }
        AppCompatImageView ivPause = this.viewBinding.f75721h;
        Intrinsics.g(ivPause, "ivPause");
        jg.c.g(ivPause);
        AppCompatSeekBar seekBar = this.viewBinding.f75728o;
        Intrinsics.g(seekBar, "seekBar");
        jg.c.g(seekBar);
        setLoading(false);
        setKeepScreenOn(true);
    }

    public final void setData(Subject item, final Fragment fragment, Integer position, String basePostId, String baseItemType, boolean attachToMain) {
        Intrinsics.h(item, "item");
        Intrinsics.h(fragment, "fragment");
        com.transsion.postdetail.layer.b bVar = new com.transsion.postdetail.layer.b();
        this.dotLayer = bVar;
        bVar.s(basePostId);
        com.transsion.postdetail.layer.b bVar2 = this.dotLayer;
        if (bVar2 != null) {
            bVar2.r(baseItemType);
        }
        com.transsion.postdetail.layer.b bVar3 = this.dotLayer;
        if (bVar3 != null) {
            bVar3.y(SubjectType.SHORT_TV.getValue());
        }
        PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, null, false, null, false, false, false, false, null, -1, 1, null);
        postSubjectItem.setSubject(item);
        postSubjectItem.setOps(item.getOps());
        postSubjectItem.setItemType("7");
        com.transsion.postdetail.layer.b bVar4 = this.dotLayer;
        if (bVar4 != null) {
            bVar4.x("", postSubjectItem);
        }
        this.fragment = fragment;
        this.videoLoadMore = this.videoLoadMore;
        this.basePostId = basePostId;
        this.position = position;
        this.attachToMain = attachToMain;
        fragment.getLifecycle().a(this);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.videoDetailModel = y(FragmentViewModelLazyKt.a(fragment, Reflection.b(com.transsion.postdetail.viewmodel.x.class), new Function0<androidx.view.x0>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$3
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
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.shortTvPlayListViewModel = z(FragmentViewModelLazyKt.a(fragment, Reflection.b(ShortTvPlayListViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$6
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
        F(item);
        if (attachToMain) {
            ViewGroup.LayoutParams layoutParams = this.viewBinding.f75727n.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.b) {
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).bottomMargin = com.blankj.utilcode.util.a0.a(16.0f);
            }
        }
        A();
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

    public final void videoStartPrepare(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        this.pageFrom = pageFrom;
        com.transsion.postdetail.layer.b bVar = this.dotLayer;
        if (bVar != null) {
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
