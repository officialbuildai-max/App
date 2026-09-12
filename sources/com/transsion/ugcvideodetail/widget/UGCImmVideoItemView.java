package com.transsion.ugcvideodetail.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.c0;
import androidx.view.u;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.pager.PagerLayoutManager;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
import com.transsion.baseui.util.m;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.push.PushConstants;
import com.transsion.ugcvideodetail.R$drawable;
import com.transsion.ugcvideodetail.R$layout;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCreator;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayStream;
import com.transsion.ugcvideodetail.dialog.UGCImmVideoSettingDialog;
import com.transsion.ugcvideodetail.fragment.UGCImmVideoDetailFragment;
import com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel;
import com.transsion.ugcvideodetail.widget.UGCImmVideoItemView;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.ugc.viewmodel.UGCDownloadViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;
import qv.r;
import tv.a;
import tv.e;
import tv.g;
import tv.h;
import tv.i;
import tv.n;

@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012JI\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001cH\u0014¢\u0006\u0004\b$\u0010#J\r\u0010%\u001a\u00020\u001c¢\u0006\u0004\b%\u0010#J\r\u0010&\u001a\u00020\u001c¢\u0006\u0004\b&\u0010#J\r\u0010'\u001a\u00020\u001c¢\u0006\u0004\b'\u0010#J\r\u0010(\u001a\u00020\u001c¢\u0006\u0004\b(\u0010#J+\u0010.\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010-\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b.\u0010/J!\u00104\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u0001002\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J\r\u00107\u001a\u000206¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\b¢\u0006\u0004\b:\u0010!J\u0019\u0010<\u001a\u00020\u001c2\b\u0010;\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u001c¢\u0006\u0004\b>\u0010#J\u000f\u0010?\u001a\u00020\u001cH\u0016¢\u0006\u0004\b?\u0010#J\r\u0010@\u001a\u00020\u001c¢\u0006\u0004\b@\u0010#J\r\u0010A\u001a\u00020\u001c¢\u0006\u0004\bA\u0010#J\r\u0010B\u001a\u00020\u001c¢\u0006\u0004\bB\u0010#J\u0015\u0010D\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u001cH\u0016¢\u0006\u0004\bF\u0010#J\u001f\u0010I\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u001cH\u0016¢\u0006\u0004\bK\u0010#J\u0019\u0010N\u001a\u00020\u001c2\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bN\u0010OJ\u0019\u0010P\u001a\u00020\u001c2\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bP\u0010OJ\u0019\u0010Q\u001a\u00020\u001c2\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bQ\u0010OJ!\u0010S\u001a\u00020\u001c2\u0006\u0010R\u001a\u0002062\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bS\u0010TJ\u0019\u0010U\u001a\u00020\u001c2\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bU\u0010OJ\u0019\u0010V\u001a\u00020\u001c2\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bV\u0010OJ!\u0010Y\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020W2\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u001cH\u0016¢\u0006\u0004\b[\u0010#J\u0019\u0010\\\u001a\u00020\u001c2\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\b\\\u0010OJ\r\u0010]\u001a\u00020\u001c¢\u0006\u0004\b]\u0010#J\u000f\u0010^\u001a\u00020\u001cH\u0002¢\u0006\u0004\b^\u0010#J\u0017\u0010_\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b_\u0010`J\u0017\u0010c\u001a\u00020\u001c2\u0006\u0010b\u001a\u00020aH\u0002¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\be\u0010!J\u0017\u0010g\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u0010H\u0002¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020\u001c2\u0006\u0010b\u001a\u00020aH\u0002¢\u0006\u0004\bi\u0010dJ\u0017\u0010j\u001a\u00020\u001c2\u0006\u0010R\u001a\u000206H\u0002¢\u0006\u0004\bj\u0010kJ\u0017\u0010m\u001a\u00020\u001c2\u0006\u0010l\u001a\u000206H\u0002¢\u0006\u0004\bm\u0010kJ\u0017\u0010n\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u0010H\u0002¢\u0006\u0004\bn\u0010hJ#\u0010q\u001a\u00020\u001c2\b\u0010o\u001a\u0004\u0018\u00010\b2\b\u0010p\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020\u001cH\u0002¢\u0006\u0004\bs\u0010#J\u0017\u0010u\u001a\u00020\u001c2\u0006\u0010t\u001a\u00020\bH\u0002¢\u0006\u0004\bu\u0010!J\u000f\u0010v\u001a\u00020\u001cH\u0002¢\u0006\u0004\bv\u0010#J\u000f\u0010w\u001a\u00020\u001cH\u0002¢\u0006\u0004\bw\u0010#J\u0017\u0010x\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u0010H\u0002¢\u0006\u0004\bx\u0010hR\u0014\u0010{\u001a\u00020\u00168\u0002X\u0082D¢\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bp\u0010\u0092\u0001R\u0017\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010zR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010zR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010zR\u001a\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R!\u0010£\u0001\u001a\u00030\u009e\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R!\u0010¨\u0001\u001a\u00030¤\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¥\u0001\u0010 \u0001\u001a\u0006\b¦\u0001\u0010§\u0001R!\u0010\u00ad\u0001\u001a\u00030©\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bª\u0001\u0010 \u0001\u001a\u0006\b«\u0001\u0010¬\u0001R!\u0010²\u0001\u001a\u00030®\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¯\u0001\u0010 \u0001\u001a\u0006\b°\u0001\u0010±\u0001R!\u0010·\u0001\u001a\u00030³\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b´\u0001\u0010 \u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R!\u0010¼\u0001\u001a\u00030¸\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¹\u0001\u0010 \u0001\u001a\u0006\bº\u0001\u0010»\u0001R\u0017\u0010¿\u0001\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u0018\u0010Á\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b;\u0010À\u0001R\u0018\u0010Â\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bo\u0010À\u0001R\u0019\u0010Ä\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010À\u0001R\u0017\u0010Æ\u0001\u001a\u00020\b8\u0002X\u0082D¢\u0006\b\n\u0006\bÅ\u0001\u0010¾\u0001R\u0017\u0010È\u0001\u001a\u00020\b8\u0002X\u0082D¢\u0006\b\n\u0006\bÇ\u0001\u0010¾\u0001R\u0017\u0010Ê\u0001\u001a\u00020\b8\u0002X\u0082D¢\u0006\b\n\u0006\bÉ\u0001\u0010¾\u0001R\u0019\u0010Ì\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010¾\u0001R\u0018\u0010Í\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bc\u0010À\u0001R\u0018\u0010Î\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b^\u0010À\u0001R\u0019\u0010Ð\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010À\u0001R\u0019\u0010Ó\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ô\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bu\u0010Ò\u0001R\u0018\u0010Õ\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bv\u0010À\u0001R#\u0010Ù\u0001\u001a\u0005\u0018\u00010Ö\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¾\u0001\u0010 \u0001\u001a\u0006\b×\u0001\u0010Ø\u0001R\u0019\u0010Ú\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010¾\u0001R-\u0010ß\u0001\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010Ü\u00010Û\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u0018\u0010à\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bw\u0010À\u0001R\u0018\u0010á\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bs\u0010À\u0001R\u0019\u0010ã\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010À\u0001R\u0018\u0010ç\u0001\u001a\u00030ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u0019\u0010é\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010Ò\u0001R\u0019\u0010ë\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010À\u0001¨\u0006ì\u0001"}, d2 = {"Lcom/transsion/ugcvideodetail/widget/UGCImmVideoItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/transsion/player/orplayer/f;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "adapterPosition", "Lcom/transsion/ugcvideodetail/fragment/UGCImmVideoDetailFragment;", "fragment", "", "trackId", "previousTrackId", "previousPageVideoId", "Lcom/transsion/ugcvideodetail/api/bean/UGCImmVideo;", "data", "", "setData", "(Ljava/lang/Integer;Lcom/transsion/ugcvideodetail/fragment/UGCImmVideoDetailFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/ugcvideodetail/api/bean/UGCImmVideo;)V", NotificationCompat.CATEGORY_STATUS, "setDownloadStatus", "(I)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "onPagePause", "onPageResume", "onPageStop", "onPageDestroy", "Lcom/transsion/player/orplayer/g;", "orPlayer", "Lcom/transsion/player/ui/ORPlayerView;", "orPlayerView", WebConstants.FIELD_ITEM, "onPageSelected", "(Lcom/transsion/player/orplayer/g;Lcom/transsion/player/ui/ORPlayerView;Lcom/transsion/ugcvideodetail/api/bean/UGCImmVideo;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lcom/transsion/moviedetailapi/bean/FirstFrame;", "firstImage", "addVideoView", "(Landroid/view/View;Lcom/transsion/moviedetailapi/bean/FirstFrame;)V", "", "getProgress", "()J", RequestParameters.POSITION, "onPageRelease", "v", "onClick", "(Landroid/view/View;)V", "onNetConnect", "onPlayerReset", "reset", "app2Background", "videoStartPrepare", "url", "setVideoUrl", "(Ljava/lang/String;)V", "onSetDataSource", "width", "height", "onVideoSizeChanged", "(II)V", "onRenderFirstFrame", "Lao/e;", "mediaSource", "onPrepare", "(Lao/e;)V", "onVideoStart", "onVideoPause", NotificationCompat.CATEGORY_PROGRESS, "onProgress", "(JLao/e;)V", "onLoadingBegin", "onLoadingEnd", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lao/e;)V", "onLoopingStart", "onCompletion", "onItemViewMediaItemTransition", "D", "setContent", "(Lcom/transsion/ugcvideodetail/api/bean/UGCImmVideo;)V", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "video", "C", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;)V", "V", PushConstants.PUSH_SERVICE_TYPE_SHOW, "setDownloadLoadingIconVisibility", "(Z)V", "setupHashTags", "W", "(J)V", "max", "X", "setLoading", "w", "h", "Y", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "M", "resolution", "G", "H", "L", "setControlVisible", "a", "Ljava/lang/String;", "TAG", "Lqv/r;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lqv/r;", "viewBinding", "c", "Lcom/transsion/ugcvideodetail/fragment/UGCImmVideoDetailFragment;", "Lcom/transsion/ugcvideodetail/viewmodel/UGCImmVideoDetailViewModel;", "d", "Lcom/transsion/ugcvideodetail/viewmodel/UGCImmVideoDetailViewModel;", "detailViewModel", "Lcom/transsion/ugcvideodetail/hepler/subtitle/a;", "e", "Lcom/transsion/ugcvideodetail/hepler/subtitle/a;", "subtitleViewModel", "Lcom/transsnet/downloader/ugc/viewmodel/UGCDownloadViewModel;", "f", "Lcom/transsnet/downloader/ugc/viewmodel/UGCDownloadViewModel;", "downloadViewModel", "Lcom/transsion/ugcvideodetail/hepler/a;", be.g.f16474b, "Lcom/transsion/ugcvideodetail/hepler/a;", "dotLayer", "Lcom/transsion/ugcvideodetail/api/bean/UGCImmVideo;", "i", j.f35620b, CampaignEx.JSON_KEY_AD_K, "l", "Lcom/transsion/player/orplayer/g;", "m", "Lcom/transsion/player/ui/ORPlayerView;", "Lcom/tn/lib/pager/PagerLayoutManager;", "n", "Lcom/tn/lib/pager/PagerLayoutManager;", "pagerLayoutManager", "Ltv/i;", "o", "Lkotlin/Lazy;", "getReportDelegate", "()Ltv/i;", "reportDelegate", "Ltv/e;", TtmlNode.TAG_P, "getDownloadDelegate", "()Ltv/e;", "downloadDelegate", "Ltv/h;", CampaignEx.JSON_KEY_AD_Q, "getPlayerDelegate", "()Ltv/h;", "playerDelegate", "Ltv/a;", CampaignEx.JSON_KEY_AD_R, "getActionDelegate", "()Ltv/a;", "actionDelegate", "Ltv/n;", "s", "getSubtitleDelegate", "()Ltv/n;", "subtitleDelegate", "Ltv/g;", "t", "getGestureDelegate", "()Ltv/g;", "gestureDelegate", TmcStartParams.KEY_URL_SHORT, "I", "screenWidth", "Z", "isClickPause", "isPageHide", "x", "isDownloadImmediately", "y", "DOWNLOAD_STATUS_DOWNLOAD_NONE", "z", "DOWNLOAD_STATUS_DOWNLOADING", "A", "DOWNLOAD_STATUS_DOWNLOAD_COMPLETE", "B", "singleDownloadImmediatelyStatus", "isSearchShow", "isEpLayoutShow", "E", "isHashTagShow", "F", "J", "totalDuration", "playProgress", "isSubscriptionInitiatedByThisView", "Lcom/transsnet/loginapi/ILoginApi;", "getLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "loginApi", "curStatus", "Landroidx/lifecycle/c0;", "Lkotlin/Pair;", "K", "Landroidx/lifecycle/c0;", "subscriptObserver", "isLoading", "isFirstFrame", "N", "isPrepare", "Ljava/lang/Runnable;", "O", "Ljava/lang/Runnable;", "delayToastNetErrRunnable", "P", "lastShowNetWorkErrToastTime", "Q", "isBarHide", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class UGCImmVideoItemView extends ConstraintLayout implements com.transsion.player.orplayer.f, View.OnClickListener {

    /* renamed from: A, reason: from kotlin metadata */
    private final int DOWNLOAD_STATUS_DOWNLOAD_COMPLETE;

    /* renamed from: B, reason: from kotlin metadata */
    private int singleDownloadImmediatelyStatus;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isSearchShow;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isEpLayoutShow;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isHashTagShow;

    /* renamed from: F, reason: from kotlin metadata */
    private long totalDuration;

    /* renamed from: G, reason: from kotlin metadata */
    private long playProgress;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isSubscriptionInitiatedByThisView;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy loginApi;

    /* renamed from: J, reason: from kotlin metadata */
    private int curStatus;

    /* renamed from: K, reason: from kotlin metadata */
    private final c0 subscriptObserver;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFirstFrame;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isPrepare;

    /* renamed from: O, reason: from kotlin metadata */
    private final Runnable delayToastNetErrRunnable;

    /* renamed from: P, reason: from kotlin metadata */
    private long lastShowNetWorkErrToastTime;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isBarHide;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final r viewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private UGCImmVideoDetailFragment fragment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private UGCImmVideoDetailViewModel detailViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.transsion.ugcvideodetail.hepler.subtitle.a subtitleViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private UGCDownloadViewModel downloadViewModel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.transsion.ugcvideodetail.hepler.a dotLayer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private UGCImmVideo data;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String trackId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String previousTrackId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String previousPageVideoId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private com.transsion.player.orplayer.g orPlayer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ORPlayerView orPlayerView;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private PagerLayoutManager pagerLayoutManager;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Lazy reportDelegate;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadDelegate;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Lazy playerDelegate;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Lazy actionDelegate;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final Lazy subtitleDelegate;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Lazy gestureDelegate;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final int screenWidth;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean isClickPause;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean isPageHide;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private boolean isDownloadImmediately;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final int DOWNLOAD_STATUS_DOWNLOAD_NONE;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final int DOWNLOAD_STATUS_DOWNLOADING;

    /* loaded from: classes6.dex */
    public static final class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        private final r f56637a;

        a() {
            this.f56637a = UGCImmVideoItemView.this.viewBinding;
        }

        @Override // tv.a.b
        public r a() {
            return this.f56637a;
        }

        @Override // tv.a.b
        public UGCImmVideoDetailViewModel b() {
            return UGCImmVideoItemView.this.detailViewModel;
        }

        @Override // tv.a.b
        public UGCImmVideoDetailFragment c() {
            return UGCImmVideoItemView.this.fragment;
        }

        @Override // tv.a.b
        public String d() {
            return UGCImmVideoItemView.this.trackId;
        }

        @Override // tv.a.b
        public String e() {
            return UGCImmVideoItemView.this.previousPageVideoId;
        }

        @Override // tv.a.b
        public String f() {
            return UGCImmVideoItemView.this.previousTrackId;
        }

        @Override // tv.a.b
        public boolean g() {
            return UGCImmVideoItemView.this.isDownloadImmediately;
        }

        @Override // tv.a.b
        public UGCImmVideo getData() {
            return UGCImmVideoItemView.this.data;
        }

        @Override // tv.a.b
        public ILoginApi h() {
            return UGCImmVideoItemView.this.getLoginApi();
        }

        @Override // tv.a.b
        public void i(boolean z10) {
            UGCImmVideoItemView.this.isSubscriptionInitiatedByThisView = z10;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements e.b {
        b() {
        }

        @Override // tv.e.b
        public void a(boolean z10) {
            UGCImmVideoItemView.this.setDownloadLoadingIconVisibility(z10);
        }

        @Override // tv.e.b
        public UGCImmVideoDetailViewModel b() {
            return UGCImmVideoItemView.this.detailViewModel;
        }

        @Override // tv.e.b
        public UGCImmVideoDetailFragment c() {
            return UGCImmVideoItemView.this.fragment;
        }

        @Override // tv.e.b
        public String d() {
            return UGCImmVideoItemView.this.trackId;
        }

        @Override // tv.e.b
        public String e() {
            return UGCImmVideoItemView.this.previousTrackId;
        }

        @Override // tv.e.b
        public UGCDownloadViewModel f() {
            return UGCImmVideoItemView.this.downloadViewModel;
        }

        @Override // tv.e.b
        public String g() {
            return UGCImmVideoItemView.this.previousPageVideoId;
        }

        @Override // tv.e.b
        public UGCImmVideo getData() {
            return UGCImmVideoItemView.this.data;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements g.a {

        /* renamed from: a, reason: collision with root package name */
        private final r f56640a;

        /* renamed from: b, reason: collision with root package name */
        private final int f56641b;

        c() {
            this.f56640a = UGCImmVideoItemView.this.viewBinding;
            this.f56641b = UGCImmVideoItemView.this.screenWidth;
        }

        @Override // tv.g.a
        public r a() {
            return this.f56640a;
        }

        @Override // tv.g.a
        public UGCImmVideoDetailViewModel b() {
            return UGCImmVideoItemView.this.detailViewModel;
        }

        @Override // tv.g.a
        public PagerLayoutManager c() {
            return UGCImmVideoItemView.this.pagerLayoutManager;
        }

        @Override // tv.g.a
        public void d() {
            UGCImmVideoItemView.this.M();
        }

        @Override // tv.g.a
        public void e(boolean z10) {
            UGCImmVideoItemView.this.setControlVisible(z10);
        }

        @Override // tv.g.a
        public void f(long j11) {
            UGCImmVideoItemView.this.W(j11);
        }

        @Override // tv.g.a
        public void g() {
            UGCImmVideoItemView.this.H();
        }

        @Override // tv.g.a
        public UGCImmVideo getData() {
            return UGCImmVideoItemView.this.data;
        }

        @Override // tv.g.a
        public String getLogTag() {
            return UGCImmVideoItemView.this.TAG;
        }

        @Override // tv.g.a
        public com.transsion.player.orplayer.g getOrPlayer() {
            return UGCImmVideoItemView.this.orPlayer;
        }

        @Override // tv.g.a
        public void h(boolean z10) {
            UGCImmVideoItemView.this.isClickPause = z10;
            UGCImmVideoDetailFragment uGCImmVideoDetailFragment = UGCImmVideoItemView.this.fragment;
            if (uGCImmVideoDetailFragment != null) {
                uGCImmVideoDetailFragment.b1(z10);
            }
        }

        @Override // tv.g.a
        public int i() {
            return this.f56641b;
        }

        @Override // tv.g.a
        public boolean isLoading() {
            return UGCImmVideoItemView.this.isLoading;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements h.a {

        /* renamed from: a, reason: collision with root package name */
        private final r f56643a;

        d() {
            this.f56643a = UGCImmVideoItemView.this.viewBinding;
        }

        @Override // tv.h.a
        public r a() {
            return this.f56643a;
        }

        @Override // tv.h.a
        public UGCImmVideoDetailViewModel b() {
            return UGCImmVideoItemView.this.detailViewModel;
        }

        @Override // tv.h.a
        public void c(boolean z10) {
            UGCImmVideoItemView.this.setKeepScreenOn(z10);
        }

        @Override // tv.h.a
        public void d() {
            UGCImmVideoDetailFragment uGCImmVideoDetailFragment = UGCImmVideoItemView.this.fragment;
            if (uGCImmVideoDetailFragment != null) {
                uGCImmVideoDetailFragment.hideLoading();
            }
        }

        @Override // tv.h.a
        public n e() {
            return UGCImmVideoItemView.this.getSubtitleDelegate();
        }

        @Override // tv.h.a
        public com.transsion.ugcvideodetail.hepler.a f() {
            return UGCImmVideoItemView.this.dotLayer;
        }

        @Override // tv.h.a
        public UGCImmVideo getData() {
            return UGCImmVideoItemView.this.data;
        }

        @Override // tv.h.a
        public String getLogTag() {
            return UGCImmVideoItemView.this.TAG;
        }

        @Override // tv.h.a
        public com.transsion.player.orplayer.g getOrPlayer() {
            return UGCImmVideoItemView.this.orPlayer;
        }

        @Override // tv.h.a
        public void showLoading() {
            UGCImmVideoDetailFragment uGCImmVideoDetailFragment = UGCImmVideoItemView.this.fragment;
            if (uGCImmVideoDetailFragment != null) {
                uGCImmVideoDetailFragment.startLoading();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements i.a {
        e() {
        }

        @Override // tv.i.a
        public String d() {
            return UGCImmVideoItemView.this.trackId;
        }

        @Override // tv.i.a
        public String e() {
            return UGCImmVideoItemView.this.previousPageVideoId;
        }

        @Override // tv.i.a
        public String f() {
            return UGCImmVideoItemView.this.previousTrackId;
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements RequestListener {
        f() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable resource, Object model, Target target, DataSource dataSource, boolean z10) {
            Intrinsics.h(resource, "resource");
            Intrinsics.h(model, "model");
            Intrinsics.h(dataSource, "dataSource");
            a.C0856a.f(lg.a.f68962a, UGCImmVideoItemView.this.TAG, "onResourceReady ", false, 4, null);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            Intrinsics.h(target, "target");
            a.C0856a.f(lg.a.f68962a, UGCImmVideoItemView.this.TAG, "onLoadFailed ", false, 4, null);
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements n.a {

        /* renamed from: a, reason: collision with root package name */
        private final r f56647a;

        g() {
            this.f56647a = UGCImmVideoItemView.this.viewBinding;
        }

        @Override // tv.n.a
        public r a() {
            return this.f56647a;
        }

        @Override // tv.n.a
        public com.transsion.ugcvideodetail.hepler.subtitle.a b() {
            return UGCImmVideoItemView.this.subtitleViewModel;
        }

        @Override // tv.n.a
        public UGCImmVideoDetailFragment c() {
            return UGCImmVideoItemView.this.fragment;
        }

        @Override // tv.n.a
        public UGCImmVideo getData() {
            return UGCImmVideoItemView.this.data;
        }

        @Override // tv.n.a
        public String getLogTag() {
            return UGCImmVideoItemView.this.TAG;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoItemView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.TAG = "UGCImmVideoItemView";
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        this.trackId = uuid;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.reportDelegate = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: sv.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tv.i J;
                J = UGCImmVideoItemView.J(UGCImmVideoItemView.this);
                return J;
            }
        });
        this.downloadDelegate = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: sv.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tv.e A;
                A = UGCImmVideoItemView.A(UGCImmVideoItemView.this);
                return A;
            }
        });
        this.playerDelegate = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: sv.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tv.h I;
                I = UGCImmVideoItemView.I(UGCImmVideoItemView.this);
                return I;
            }
        });
        this.actionDelegate = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: sv.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tv.a y10;
                y10 = UGCImmVideoItemView.y(UGCImmVideoItemView.this);
                return y10;
            }
        });
        this.subtitleDelegate = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: sv.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tv.n U;
                U = UGCImmVideoItemView.U(UGCImmVideoItemView.this);
                return U;
            }
        });
        this.gestureDelegate = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: sv.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tv.g B;
                B = UGCImmVideoItemView.B(UGCImmVideoItemView.this);
                return B;
            }
        });
        this.screenWidth = y.e();
        this.DOWNLOAD_STATUS_DOWNLOAD_NONE = 1;
        this.DOWNLOAD_STATUS_DOWNLOADING = 2;
        this.DOWNLOAD_STATUS_DOWNLOAD_COMPLETE = 3;
        this.singleDownloadImmediatelyStatus = 1;
        this.loginApi = LazyKt.b(new Function0() { // from class: sv.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi F;
                F = UGCImmVideoItemView.F();
                return F;
            }
        });
        View.inflate(getContext(), R$layout.view_ugc_imm_video_detail_item, this);
        r a11 = r.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
        a11.D.setOnClickListener(this);
        a11.C.setOnClickListener(this);
        a11.f74001z.setOnClickListener(this);
        a11.f73990o.setOnClickListener(this);
        a11.f73986k.setOnClickListener(this);
        a11.f73992q.setOnClickListener(this);
        a11.H.setOnClickListener(this);
        a11.f73991p.setOnClickListener(this);
        a11.f73993r.setOnClickListener(this);
        a11.f73994s.setOnClickListener(this);
        FrameLayout vTopStatus = a11.J;
        Intrinsics.g(vTopStatus, "vTopStatus");
        jg.c.e(vTopStatus);
        getGestureDelegate().i();
        D();
        this.curStatus = -1;
        this.subscriptObserver = new c0() { // from class: sv.e
            @Override // androidx.view.c0
            public final void onChanged(Object obj) {
                UGCImmVideoItemView.T(UGCImmVideoItemView.this, (Pair) obj);
            }
        };
        this.delayToastNetErrRunnable = new Runnable() { // from class: sv.f
            @Override // java.lang.Runnable
            public final void run() {
                UGCImmVideoItemView.z(UGCImmVideoItemView.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tv.e A(UGCImmVideoItemView uGCImmVideoItemView) {
        return new tv.e(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tv.g B(UGCImmVideoItemView uGCImmVideoItemView) {
        return new tv.g(new c(), uGCImmVideoItemView.getReportDelegate());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x001b, code lost:
    
        if (r4.intValue() != 1) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0034, code lost:
    
        if (((r4 == null || (r4 = r4.getPlayInfo()) == null || (r4 = r4.getResources()) == null) ? 0 : r4.size()) <= 1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void C(com.transsion.ugcvideodetail.api.bean.UGCVideo r4) {
        /*
            r3 = this;
            boolean r0 = r4.isCollection()
            r1 = 0
            if (r0 == 0) goto L9
        L7:
            r2 = r1
            goto L36
        L9:
            java.lang.Integer r0 = r4.getDownloadStyle()
            r2 = 1
            if (r0 == 0) goto L1e
            java.lang.Integer r4 = r4.getDownloadStyle()
            if (r4 != 0) goto L17
            goto L7
        L17:
            int r4 = r4.intValue()
            if (r4 != r2) goto L7
            goto L36
        L1e:
            com.transsion.ugcvideodetail.api.bean.UGCImmVideo r4 = r3.data
            if (r4 == 0) goto L33
            com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo r4 = r4.getPlayInfo()
            if (r4 == 0) goto L33
            java.util.List r4 = r4.getResources()
            if (r4 == 0) goto L33
            int r4 = r4.size()
            goto L34
        L33:
            r4 = r1
        L34:
            if (r4 > r2) goto L7
        L36:
            r3.isDownloadImmediately = r2
            if (r2 == 0) goto L46
            com.transsion.ugcvideodetail.api.bean.UGCImmVideo r4 = r3.data
            if (r4 == 0) goto L42
            int r1 = r4.getDownloadStatus()
        L42:
            r3.V(r1)
            goto L52
        L46:
            r3.setDownloadLoadingIconVisibility(r1)
            qv.r r4 = r3.viewBinding
            androidx.appcompat.widget.AppCompatImageView r4 = r4.f73986k
            int r0 = com.transsion.ugcvideodetail.R$drawable.ugc_imm_video_ic_download
            r4.setImageResource(r0)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.widget.UGCImmVideoItemView.C(com.transsion.ugcvideodetail.api.bean.UGCVideo):void");
    }

    private final void D() {
        if (Build.VERSION.SDK_INT >= 30) {
            post(new Runnable() { // from class: sv.g
                @Override // java.lang.Runnable
                public final void run() {
                    UGCImmVideoItemView.E(UGCImmVideoItemView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        if (com.blankj.utilcode.util.d.a() > 1) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void E(com.transsion.ugcvideodetail.widget.UGCImmVideoItemView r8) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.widget.UGCImmVideoItemView.E(com.transsion.ugcvideodetail.widget.UGCImmVideoItemView):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi F() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    private final void G(int resolution) {
        UGCVideoPlayInfo playInfo;
        Integer num;
        Object obj;
        UGCVideo ugcVideo;
        Map a11;
        UGCVideo ugcVideo2;
        UGCImmVideo uGCImmVideo = this.data;
        if (uGCImmVideo == null || (playInfo = uGCImmVideo.getPlayInfo()) == null) {
            return;
        }
        Iterator<T> it = playInfo.getResources().iterator();
        while (true) {
            num = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.c(((UGCVideoPlayStream) obj).getResolutions(), String.valueOf(resolution))) {
                    break;
                }
            }
        }
        UGCVideoPlayStream uGCVideoPlayStream = (UGCVideoPlayStream) obj;
        if (uGCVideoPlayStream == null) {
            return;
        }
        String url = uGCVideoPlayStream.getUrl();
        String url2 = uGCVideoPlayStream.getUrl();
        UGCImmVideo uGCImmVideo2 = this.data;
        boolean z10 = false;
        ao.e eVar = new ao.e(url, url2, (uGCImmVideo2 == null || (ugcVideo2 = uGCImmVideo2.getUgcVideo()) == null) ? 0 : ugcVideo2.videoUGCPosition(), null, null, 24, null);
        com.transsion.player.orplayer.g gVar = this.orPlayer;
        lo.f fVar = gVar instanceof lo.f ? (lo.f) gVar : null;
        if (fVar != null && (a11 = fVar.a()) != null) {
            z10 = a11.containsKey(eVar.e());
        }
        a.C0856a c0856a = lg.a.f68962a;
        String str = this.TAG;
        UGCImmVideo uGCImmVideo3 = this.data;
        if (uGCImmVideo3 != null && (ugcVideo = uGCImmVideo3.getUgcVideo()) != null) {
            num = Integer.valueOf(ugcVideo.videoUGCPosition());
        }
        a.C0856a.f(c0856a, str, "resolution play, resolution:" + resolution + ", EP:" + num + ", inList:" + z10 + ", url:" + uGCVideoPlayStream.getUrl(), false, 4, null);
        com.transsion.player.orplayer.g gVar2 = this.orPlayer;
        long currentPosition = gVar2 != null ? gVar2.getCurrentPosition() : 0L;
        if (!z10) {
            com.transsion.player.orplayer.g gVar3 = this.orPlayer;
            if (gVar3 != null) {
                gVar3.addDataSource(eVar);
            }
            com.transsion.player.orplayer.g gVar4 = this.orPlayer;
            if (gVar4 != null) {
                gVar4.prepare();
            }
        }
        com.transsion.player.orplayer.g gVar5 = this.orPlayer;
        if (gVar5 != null) {
            String e11 = eVar.e();
            if (e11 == null) {
                e11 = "";
            }
            gVar5.seekTo(e11, currentPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        getPlayerDelegate().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h I(UGCImmVideoItemView uGCImmVideoItemView) {
        return new h(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i J(UGCImmVideoItemView uGCImmVideoItemView) {
        return new i(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(UGCVideo uGCVideo, UGCImmVideoItemView uGCImmVideoItemView, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        List<UGCVideoHashTag> filteredHashTags = uGCVideo.getFilteredHashTags();
        UGCVideoHashTag uGCVideoHashTag = filteredHashTags != null ? (UGCVideoHashTag) CollectionsKt.l0(filteredHashTags, i11) : null;
        i reportDelegate = uGCImmVideoItemView.getReportDelegate();
        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel = uGCImmVideoItemView.detailViewModel;
        reportDelegate.a("hash_tag", uGCVideo, uGCImmVideoDetailViewModel != null ? Boolean.valueOf(uGCImmVideoDetailViewModel.Y0()) : null, uGCVideoHashTag != null ? uGCVideoHashTag.getTag() : null, Integer.valueOf(i11));
        Navigator.x(TheRouter.c("/home/hashtag").I("titleHashTag", uGCVideoHashTag).K("UGCVideoId", uGCVideo.getUgcVideoId()), uGCImmVideoItemView.getContext(), null, 2, null);
    }

    private final void L() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastShowNetWorkErrToastTime > ToastStrategy.LONG_DURATION_TIMEOUT) {
            this.lastShowNetWorkErrToastTime = currentTimeMillis;
            uh.b.f76876a.d(R$string.no_network_toast);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        UGCImmVideoDetailFragment uGCImmVideoDetailFragment;
        FragmentManager childFragmentManager;
        Object m1185constructorimpl;
        UGCImmVideoDetailFragment uGCImmVideoDetailFragment2 = this.fragment;
        if (uGCImmVideoDetailFragment2 == null || !uGCImmVideoDetailFragment2.isAdded() || (uGCImmVideoDetailFragment = this.fragment) == null || (childFragmentManager = uGCImmVideoDetailFragment.getChildFragmentManager()) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            UGCImmVideoSettingDialog a11 = UGCImmVideoSettingDialog.INSTANCE.a();
            a11.u0(new Function1() { // from class: sv.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit N;
                    N = UGCImmVideoItemView.N(UGCImmVideoItemView.this, ((Float) obj).floatValue());
                    return N;
                }
            });
            a11.t0(new Function1() { // from class: sv.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit O;
                    O = UGCImmVideoItemView.O(UGCImmVideoItemView.this, ((Integer) obj).intValue());
                    return O;
                }
            });
            a11.v0(new Function1() { // from class: sv.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit P;
                    P = UGCImmVideoItemView.P(UGCImmVideoItemView.this, (eu.a) obj);
                    return P;
                }
            });
            a11.s0(new Function0() { // from class: sv.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit Q;
                    Q = UGCImmVideoItemView.Q(UGCImmVideoItemView.this);
                    return Q;
                }
            });
            a11.r0(new Function1() { // from class: sv.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit S;
                    S = UGCImmVideoItemView.S(UGCImmVideoItemView.this, ((Boolean) obj).booleanValue());
                    return S;
                }
            });
            a11.show(childFragmentManager, "UGCImmVideoSettingDialog");
            m1185constructorimpl = Result.m1185constructorimpl(a11);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Result.m1184boximpl(m1185constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(UGCImmVideoItemView uGCImmVideoItemView, float f11) {
        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel = uGCImmVideoItemView.detailViewModel;
        if (uGCImmVideoDetailViewModel != null) {
            uGCImmVideoDetailViewModel.e1(f11);
        }
        com.transsion.player.orplayer.g gVar = uGCImmVideoItemView.orPlayer;
        if (gVar != null) {
            gVar.setSpeed(f11);
        }
        a.C0856a.f(lg.a.f68962a, uGCImmVideoItemView.TAG, "setSpeed speed:" + f11, false, 4, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(UGCImmVideoItemView uGCImmVideoItemView, int i11) {
        a.C0856a.f(lg.a.f68962a, uGCImmVideoItemView.TAG, "resolution change:" + i11, false, 4, null);
        uGCImmVideoItemView.G(i11);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(UGCImmVideoItemView uGCImmVideoItemView, eu.a subtitle) {
        Intrinsics.h(subtitle, "subtitle");
        a.C0856a.f(lg.a.f68962a, uGCImmVideoItemView.TAG, "subtitle change:" + subtitle, false, 4, null);
        uGCImmVideoItemView.getSubtitleDelegate().o(subtitle);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(final UGCImmVideoItemView uGCImmVideoItemView) {
        uGCImmVideoItemView.isBarHide = true;
        uGCImmVideoItemView.post(new Runnable() { // from class: sv.h
            @Override // java.lang.Runnable
            public final void run() {
                UGCImmVideoItemView.R(UGCImmVideoItemView.this);
            }
        });
        uGCImmVideoItemView.setControlVisible(false);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(UGCImmVideoItemView uGCImmVideoItemView) {
        UGCImmVideoDetailFragment uGCImmVideoDetailFragment = uGCImmVideoItemView.fragment;
        if (uGCImmVideoDetailFragment != null) {
            ImmersionBar.with(uGCImmVideoDetailFragment).hideBar(BarHide.FLAG_HIDE_BAR).init();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(UGCImmVideoItemView uGCImmVideoItemView, boolean z10) {
        com.transsion.player.orplayer.g gVar = uGCImmVideoItemView.orPlayer;
        if (gVar != null) {
            gVar.setLooping(!z10);
        }
        a.C0856a.f(lg.a.f68962a, uGCImmVideoItemView.TAG, "autoplay change:" + z10, false, 4, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(UGCImmVideoItemView uGCImmVideoItemView, Pair pair) {
        UGCVideo ugcVideo;
        UGCVideoCreator creator;
        String uid;
        UGCVideo ugcVideo2;
        UGCVideoCreator creator2;
        UGCVideo ugcVideo3;
        UGCVideoCreator creator3;
        String str = null;
        String str2 = pair != null ? (String) pair.getFirst() : null;
        UGCImmVideo uGCImmVideo = uGCImmVideoItemView.data;
        if (uGCImmVideo != null && (ugcVideo3 = uGCImmVideo.getUgcVideo()) != null && (creator3 = ugcVideo3.getCreator()) != null) {
            str = creator3.getUid();
        }
        if (Intrinsics.c(str2, str)) {
            boolean z10 = uGCImmVideoItemView.isSubscriptionInitiatedByThisView;
            if (z10) {
                uGCImmVideoItemView.isSubscriptionInitiatedByThisView = false;
                ProgressBar pbUgcImmSubscribeLoading = uGCImmVideoItemView.viewBinding.f73996u;
                Intrinsics.g(pbUgcImmSubscribeLoading, "pbUgcImmSubscribeLoading");
                jg.c.g(pbUgcImmSubscribeLoading);
            }
            if (pair == null) {
                if (z10) {
                    AppCompatImageView ivUgcImmSubscribe = uGCImmVideoItemView.viewBinding.f73991p;
                    Intrinsics.g(ivUgcImmSubscribe, "ivUgcImmSubscribe");
                    jg.c.k(ivUgcImmSubscribe);
                    return;
                }
                return;
            }
            if (((Boolean) pair.getSecond()).booleanValue()) {
                AppCompatImageView ivUgcImmSubscribe2 = uGCImmVideoItemView.viewBinding.f73991p;
                Intrinsics.g(ivUgcImmSubscribe2, "ivUgcImmSubscribe");
                jg.c.g(ivUgcImmSubscribe2);
            }
            UGCImmVideo uGCImmVideo2 = uGCImmVideoItemView.data;
            if (uGCImmVideo2 != null && (ugcVideo2 = uGCImmVideo2.getUgcVideo()) != null && (creator2 = ugcVideo2.getCreator()) != null) {
                creator2.setHasSubscribe((Boolean) pair.getSecond());
            }
            if (z10) {
                m.c(((Boolean) pair.getSecond()).booleanValue() ? com.transsion.baseui.R$string.ugc_video_detail_followed : com.transsion.baseui.R$string.ugc_video_detail_unfollowed);
                UGCImmVideo uGCImmVideo3 = uGCImmVideoItemView.data;
                if (uGCImmVideo3 == null || (ugcVideo = uGCImmVideo3.getUgcVideo()) == null || (creator = ugcVideo.getCreator()) == null || (uid = creator.getUid()) == null) {
                    return;
                }
                ov.d dVar = new ov.d(uid, ((Boolean) pair.getSecond()).booleanValue());
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = ov.d.class.getName();
                Intrinsics.g(name, "getName(...)");
                flowEventBus.postEvent(name, dVar, 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n U(UGCImmVideoItemView uGCImmVideoItemView) {
        return new n(new g());
    }

    private final void V(int status) {
        switch (status) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
                this.singleDownloadImmediatelyStatus = this.DOWNLOAD_STATUS_DOWNLOADING;
                setDownloadLoadingIconVisibility(true);
                return;
            case 5:
                this.singleDownloadImmediatelyStatus = this.DOWNLOAD_STATUS_DOWNLOAD_COMPLETE;
                setDownloadLoadingIconVisibility(false);
                this.viewBinding.f73986k.setImageResource(R$drawable.ugc_imm_video_ic_downloaded);
                return;
            default:
                this.singleDownloadImmediatelyStatus = this.DOWNLOAD_STATUS_DOWNLOAD_NONE;
                setDownloadLoadingIconVisibility(false);
                this.viewBinding.f73986k.setImageResource(R$drawable.ugc_imm_video_ic_download);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(long progress) {
        getPlayerDelegate().g(progress);
    }

    private final void X(long max) {
        getPlayerDelegate().h(max);
    }

    private final void Y(Integer w11, Integer h11) {
        if (w11 == null || h11 == null || w11.intValue() == 0) {
            return;
        }
        int i11 = this.screenWidth;
        int c11 = w11.intValue() > h11.intValue() ? (int) (y.c() * 0.14f) : 0;
        FrameLayout flUgcImmContainer = this.viewBinding.f73979d;
        Intrinsics.g(flUgcImmContainer, "flUgcImmContainer");
        ViewGroup.LayoutParams layoutParams = flUgcImmContainer.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        int intValue = (h11.intValue() * this.screenWidth) / w11.intValue();
        if (i11 != ((ViewGroup.MarginLayoutParams) bVar).width || intValue != ((ViewGroup.MarginLayoutParams) bVar).height) {
            ((ViewGroup.MarginLayoutParams) bVar).width = i11;
            ((ViewGroup.MarginLayoutParams) bVar).height = intValue;
            a.C0856a.v(lg.a.f68962a, this.TAG, "=====> updateSurface, w:" + i11 + ", h:" + intValue, false, 4, null);
        }
        ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = c11;
        flUgcImmContainer.setLayoutParams(bVar);
        AppCompatImageView ivUgcImmCover = this.viewBinding.f73985j;
        Intrinsics.g(ivUgcImmCover, "ivUgcImmCover");
        ViewGroup.LayoutParams layoutParams2 = ivUgcImmCover.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin = c11;
        ivUgcImmCover.setLayoutParams(bVar2);
    }

    private final tv.a getActionDelegate() {
        return (tv.a) this.actionDelegate.getValue();
    }

    private final tv.e getDownloadDelegate() {
        return (tv.e) this.downloadDelegate.getValue();
    }

    private final tv.g getGestureDelegate() {
        return (tv.g) this.gestureDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILoginApi getLoginApi() {
        return (ILoginApi) this.loginApi.getValue();
    }

    private final h getPlayerDelegate() {
        return (h) this.playerDelegate.getValue();
    }

    private final i getReportDelegate() {
        return (i) this.reportDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n getSubtitleDelegate() {
        return (n) this.subtitleDelegate.getValue();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(36:5|(3:7|(1:9)|10)|11|(3:188|(1:190)|186)(4:15|(1:187)(1:19)|(1:25)|186)|26|(1:28)(1:185)|29|(1:31)(1:184)|32|33|(1:183)(3:37|(1:39)(1:182)|40)|41|(1:43)|44|(13:46|(1:48)|49|(1:51)(1:66)|52|(1:54)|55|(1:57)(1:65)|58|(1:60)|61|(1:63)|64)|67|(5:69|(3:71|(1:73)|74)(2:178|(1:180))|75|(1:77)|78)(1:181)|79|(1:177)(3:83|(1:87)|88)|89|(3:168|(1:170)(1:176)|(2:172|(1:174)(15:175|96|97|98|(1:100)(1:164)|(5:102|(1:137)(1:108)|109|(1:115)|116)(2:138|(5:140|(1:151)(1:144)|145|(1:149)|150)(5:152|(1:163)(1:156)|157|(1:161)|162))|117|118|(1:120)|121|(1:123)|124|(2:126|(1:128)(2:129|(1:133)))|134|135)))|95|96|97|98|(0)(0)|(0)(0)|117|118|(0)|121|(0)|124|(0)|134|135) */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02e3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0372, code lost:
    
        r3 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02de A[Catch: all -> 0x02e3, TryCatch #0 {all -> 0x02e3, blocks: (B:98:0x02d6, B:100:0x02de, B:102:0x02e9, B:104:0x02ef, B:106:0x02f5, B:108:0x02fb, B:109:0x0301, B:111:0x0308, B:113:0x030e, B:115:0x0314, B:116:0x0318, B:117:0x0369, B:138:0x031a, B:140:0x0320, B:142:0x0326, B:144:0x032c, B:145:0x0332, B:147:0x0339, B:149:0x033f, B:150:0x0343, B:152:0x0345, B:154:0x034b, B:156:0x0351, B:157:0x0357, B:159:0x035e, B:161:0x0364, B:162:0x0368), top: B:97:0x02d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02e9 A[Catch: all -> 0x02e3, TryCatch #0 {all -> 0x02e3, blocks: (B:98:0x02d6, B:100:0x02de, B:102:0x02e9, B:104:0x02ef, B:106:0x02f5, B:108:0x02fb, B:109:0x0301, B:111:0x0308, B:113:0x030e, B:115:0x0314, B:116:0x0318, B:117:0x0369, B:138:0x031a, B:140:0x0320, B:142:0x0326, B:144:0x032c, B:145:0x0332, B:147:0x0339, B:149:0x033f, B:150:0x0343, B:152:0x0345, B:154:0x034b, B:156:0x0351, B:157:0x0357, B:159:0x035e, B:161:0x0364, B:162:0x0368), top: B:97:0x02d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x031a A[Catch: all -> 0x02e3, TryCatch #0 {all -> 0x02e3, blocks: (B:98:0x02d6, B:100:0x02de, B:102:0x02e9, B:104:0x02ef, B:106:0x02f5, B:108:0x02fb, B:109:0x0301, B:111:0x0308, B:113:0x030e, B:115:0x0314, B:116:0x0318, B:117:0x0369, B:138:0x031a, B:140:0x0320, B:142:0x0326, B:144:0x032c, B:145:0x0332, B:147:0x0339, B:149:0x033f, B:150:0x0343, B:152:0x0345, B:154:0x034b, B:156:0x0351, B:157:0x0357, B:159:0x035e, B:161:0x0364, B:162:0x0368), top: B:97:0x02d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void setContent(com.transsion.ugcvideodetail.api.bean.UGCImmVideo r19) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.widget.UGCImmVideoItemView.setContent(com.transsion.ugcvideodetail.api.bean.UGCImmVideo):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setControlVisible(boolean show) {
        AppCompatImageView L0;
        UGCImmVideoDetailFragment uGCImmVideoDetailFragment;
        if (show && this.isBarHide && (uGCImmVideoDetailFragment = this.fragment) != null) {
            this.isBarHide = false;
            ImmersionBar.with(uGCImmVideoDetailFragment).hideBar(BarHide.FLAG_SHOW_BAR).init();
        }
        UGCImmVideoDetailFragment uGCImmVideoDetailFragment2 = this.fragment;
        if (uGCImmVideoDetailFragment2 != null && (L0 = uGCImmVideoDetailFragment2.L0()) != null) {
            L0.setVisibility(show ? 0 : 8);
        }
        Group groupUgcImmControl = this.viewBinding.f73984i;
        Intrinsics.g(groupUgcImmControl, "groupUgcImmControl");
        groupUgcImmControl.setVisibility(show ? 0 : 8);
        FrameLayout layoutUgcImmTvSearch = this.viewBinding.f73994s;
        Intrinsics.g(layoutUgcImmTvSearch, "layoutUgcImmTvSearch");
        layoutUgcImmTvSearch.setVisibility(show && this.isSearchShow ? 0 : 8);
        ConstraintLayout layoutUgcImmTvEpisode = this.viewBinding.f73993r;
        Intrinsics.g(layoutUgcImmTvEpisode, "layoutUgcImmTvEpisode");
        layoutUgcImmTvEpisode.setVisibility(show && this.isEpLayoutShow ? 0 : 8);
        RecyclerView rvUgcImmTags = this.viewBinding.f73999x;
        Intrinsics.g(rvUgcImmTags, "rvUgcImmTags");
        rvUgcImmTags.setVisibility(show && this.isHashTagShow ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDownloadLoadingIconVisibility(boolean show) {
        if (show) {
            AppCompatImageView ivUgcImmDownload = this.viewBinding.f73986k;
            Intrinsics.g(ivUgcImmDownload, "ivUgcImmDownload");
            jg.c.h(ivUgcImmDownload);
            UGCImmRingLoadingView vUgcImmDownloadLoading = this.viewBinding.K;
            Intrinsics.g(vUgcImmDownloadLoading, "vUgcImmDownloadLoading");
            jg.c.k(vUgcImmDownloadLoading);
            return;
        }
        AppCompatImageView ivUgcImmDownload2 = this.viewBinding.f73986k;
        Intrinsics.g(ivUgcImmDownload2, "ivUgcImmDownload");
        jg.c.k(ivUgcImmDownload2);
        UGCImmRingLoadingView vUgcImmDownloadLoading2 = this.viewBinding.K;
        Intrinsics.g(vUgcImmDownloadLoading2, "vUgcImmDownloadLoading");
        jg.c.g(vUgcImmDownloadLoading2);
    }

    private final void setLoading(boolean show) {
        this.isLoading = show;
        getPlayerDelegate().f(show);
    }

    private final void setupHashTags(final UGCVideo video) {
        List<UGCVideoHashTag> filteredHashTags = video.getFilteredHashTags();
        if (filteredHashTags == null || filteredHashTags.isEmpty()) {
            this.isHashTagShow = false;
            RecyclerView rvUgcImmTags = this.viewBinding.f73999x;
            Intrinsics.g(rvUgcImmTags, "rvUgcImmTags");
            jg.c.g(rvUgcImmTags);
            return;
        }
        this.isHashTagShow = true;
        RecyclerView rvUgcImmTags2 = this.viewBinding.f73999x;
        Intrinsics.g(rvUgcImmTags2, "rvUgcImmTags");
        jg.c.k(rvUgcImmTags2);
        List<UGCVideoHashTag> filteredHashTags2 = video.getFilteredHashTags();
        Intrinsics.e(filteredHashTags2);
        com.transsion.ugcvideodetail.adapter.i iVar = new com.transsion.ugcvideodetail.adapter.i(filteredHashTags2, true);
        this.viewBinding.f73999x.setAdapter(iVar);
        iVar.w1(new p6.d() { // from class: sv.m
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCImmVideoItemView.K(UGCVideo.this, this, baseQuickAdapter, view, i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tv.a y(UGCImmVideoItemView uGCImmVideoItemView) {
        return new tv.a(new a(), uGCImmVideoItemView.getReportDelegate(), uGCImmVideoItemView.getDownloadDelegate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(UGCImmVideoItemView uGCImmVideoItemView) {
        uGCImmVideoItemView.L();
    }

    public final void addVideoView(View view, FirstFrame firstImage) {
        ORPlayerView oRPlayerView = this.orPlayerView;
        if ((oRPlayerView != null ? oRPlayerView.getParent() : null) != null) {
            ORPlayerView oRPlayerView2 = this.orPlayerView;
            Object parent = oRPlayerView2 != null ? oRPlayerView2.getParent() : null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.orPlayerView);
            }
        }
        this.viewBinding.f73979d.addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (firstImage != null) {
            Y(firstImage.getWidth(), firstImage.getHeight());
        }
    }

    public final void app2Background() {
        UGCImmVideo uGCImmVideo = this.data;
        boolean isFree = uGCImmVideo != null ? uGCImmVideo.isFree() : false;
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.c(isFree, true);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    public final long getProgress() {
        return this.viewBinding.f74000y.getCurrentProgress();
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
        u viewLifecycleOwner;
        LiveData R;
        super.onAttachedToWindow();
        UGCImmVideoDetailFragment uGCImmVideoDetailFragment = this.fragment;
        if (uGCImmVideoDetailFragment != null && (viewLifecycleOwner = uGCImmVideoDetailFragment.getViewLifecycleOwner()) != null) {
            UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel = this.detailViewModel;
            if (uGCImmVideoDetailViewModel != null && (R = uGCImmVideoDetailViewModel.R()) != null) {
                R.j(viewLifecycleOwner, this.subscriptObserver);
            }
            getDownloadDelegate().j(viewLifecycleOwner);
        }
        getSubtitleDelegate().e();
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        f.a.d(this, j11, eVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v11) {
        getActionDelegate().a(v11);
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e mediaSource) {
        a.C0856a.r(lg.a.f68962a, this.TAG, new String[]{"onCompletion， play next"}, false, 4, null);
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.g();
        }
        W(0L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        u viewLifecycleOwner;
        LiveData R;
        super.onDetachedFromWindow();
        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel = this.detailViewModel;
        if (uGCImmVideoDetailViewModel != null && (R = uGCImmVideoDetailViewModel.R()) != null) {
            R.o(this.subscriptObserver);
        }
        UGCImmVideoDetailFragment uGCImmVideoDetailFragment = this.fragment;
        if (uGCImmVideoDetailFragment != null && (viewLifecycleOwner = uGCImmVideoDetailFragment.getViewLifecycleOwner()) != null) {
            getDownloadDelegate().k(viewLifecycleOwner);
        }
        getSubtitleDelegate().g();
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        f.a.g(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onIsPlayingChanged(boolean z10) {
        f.a.h(this, z10);
    }

    public final void onItemViewMediaItemTransition() {
        a.C0856a.f(lg.a.f68962a, this.TAG, "onMediaItemTransition: " + this.viewBinding.f74000y.getMaxProgress() + "  : " + this, false, 4, null);
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.g();
        }
        reset();
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingBegin(ao.e mediaSource) {
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.h();
        }
        setLoading(true);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(ao.e mediaSource) {
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.i();
        }
        setLoading(false);
        removeCallbacks(this.delayToastNetErrRunnable);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, ao.e eVar) {
        f.a.m(this, i11, f11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        a.C0856a.r(lg.a.f68962a, this.TAG, new String[]{"onLoopingStart"}, false, 4, null);
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    public final void onNetConnect() {
        a.C0856a.f(lg.a.f68962a, "ORSubtitle_v", "onNetConnect, 网络恢复，检测字幕", false, 4, null);
        getSubtitleDelegate().f();
    }

    public final void onPageDestroy() {
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.p();
        }
        com.transsion.player.orplayer.g gVar = this.orPlayer;
        if (gVar != null) {
            gVar.removePlayerListener(this);
        }
    }

    public final void onPagePause() {
        com.transsion.player.orplayer.g gVar;
        this.isPageHide = true;
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onPause", false, 4, null);
        if (ox.c.f72319a.c(this.orPlayer) || (gVar = this.orPlayer) == null) {
            return;
        }
        gVar.pause();
    }

    public final void onPageRelease(int position) {
        onPlayerReset();
    }

    public final void onPageResume() {
        UGCImmVideoDetailFragment uGCImmVideoDetailFragment;
        this.isPageHide = false;
        if (this.isClickPause || (uGCImmVideoDetailFragment = this.fragment) == null || !uGCImmVideoDetailFragment.isVisible()) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, this.TAG, "ON_RESUME", false, 4, null);
        H();
    }

    public final void onPageSelected(com.transsion.player.orplayer.g orPlayer, ORPlayerView orPlayerView, UGCImmVideo item) {
        String url;
        b0 M0;
        UGCVideoPlayInfo playInfo;
        b0 B;
        UGCVideo ugcVideo;
        UGCVideoBelongToCollection belongToCollection;
        b0 D;
        UGCVideo ugcVideo2;
        b0 L0;
        this.orPlayer = orPlayer;
        this.orPlayerView = orPlayerView;
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.t(orPlayer);
        }
        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel = this.detailViewModel;
        if (uGCImmVideoDetailViewModel != null && (L0 = uGCImmVideoDetailViewModel.L0()) != null) {
            L0.q(this.data);
        }
        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel2 = this.detailViewModel;
        if (uGCImmVideoDetailViewModel2 != null && (D = uGCImmVideoDetailViewModel2.D()) != null) {
            UGCImmVideo uGCImmVideo = this.data;
            D.q((uGCImmVideo == null || (ugcVideo2 = uGCImmVideo.getUgcVideo()) == null) ? null : ugcVideo2.getUgcVideoId());
        }
        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel3 = this.detailViewModel;
        if (uGCImmVideoDetailViewModel3 != null && (B = uGCImmVideoDetailViewModel3.B()) != null) {
            UGCImmVideo uGCImmVideo2 = this.data;
            B.q((uGCImmVideo2 == null || (ugcVideo = uGCImmVideo2.getUgcVideo()) == null || (belongToCollection = ugcVideo.getBelongToCollection()) == null) ? null : belongToCollection.getCollectionId());
        }
        if (orPlayer != null) {
            orPlayer.addPlayerListener(this);
        }
        FirstFrame firstImage = (item == null || (playInfo = item.getPlayInfo()) == null) ? null : playInfo.getFirstImage();
        if (orPlayerView != null) {
            addVideoView(orPlayerView, firstImage);
            a.C0856a.f(lg.a.f68962a, this.TAG, "addView-----", false, 4, null);
        }
        UGCVideoPlayStream a11 = pv.a.f72623a.a(item != null ? item.getPlayInfo() : null);
        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel4 = this.detailViewModel;
        if (uGCImmVideoDetailViewModel4 != null && (M0 = uGCImmVideoDetailViewModel4.M0()) != null) {
            M0.q(a11 != null ? a11.getResolutions() : null);
        }
        a.C0856a.f(lg.a.f68962a, this.TAG, "play url=" + (a11 != null ? a11.getUrl() : null) + " , duration: " + (a11 != null ? a11.getDuration() : null) + ", resolutions:" + (a11 != null ? a11.getResolutions() : null), false, 4, null);
        getSubtitleDelegate().i(a11);
        videoStartPrepare();
        if (a11 != null && (url = a11.getUrl()) != null) {
            if (orPlayer != null) {
                orPlayer.seekTo(url, 0L);
            }
            setVideoUrl(url);
        }
        if (orPlayer != null) {
            orPlayer.play();
        }
    }

    public final void onPageStop() {
        if (this.totalDuration == 0) {
            com.transsion.player.orplayer.g gVar = this.orPlayer;
            this.totalDuration = gVar != null ? gVar.getDuration() : 0L;
        }
        a.C0856a.f(lg.a.f68962a, this.TAG, "onPageStop: totalDuration:" + this.totalDuration + ",playProgress:" + this.playProgress, false, 4, null);
        getPlayerDelegate().a(this.totalDuration, this.playProgress);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e mediaSource) {
        Integer errorCode;
        Intrinsics.h(errorInfo, "errorInfo");
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.k(errorInfo);
        }
        lg.a.f68962a.i("i_media", this.TAG + " --> IPlayerListener --> onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + " url:" + (mediaSource != null ? mediaSource.k() : null) + " --> 短播放失败了", true);
        setLoading(false);
        Integer errorCode2 = errorInfo.getErrorCode();
        if ((errorCode2 != null && errorCode2.intValue() == 2001) || ((errorCode = errorInfo.getErrorCode()) != null && errorCode.intValue() == 2002)) {
            L();
        }
    }

    public void onPlayErrorChangePayer(TnPlayerType tnPlayerType, ao.e eVar) {
        f.a.s(this, tnPlayerType, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(ao.e eVar) {
        f.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.TAG, "player- onPlayerReset data: " + this.data, false, 4, null);
        getSubtitleDelegate().n();
        setKeepScreenOn(false);
        this.isClickPause = false;
        UGCImmVideoDetailFragment uGCImmVideoDetailFragment = this.fragment;
        if (uGCImmVideoDetailFragment != null) {
            uGCImmVideoDetailFragment.b1(false);
        }
        this.isFirstFrame = false;
        this.isPrepare = false;
        UGCImmVideo uGCImmVideo = this.data;
        boolean isFree = uGCImmVideo != null ? uGCImmVideo.isFree() : false;
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.c(isFree, false);
        }
        if (isFree && (uGCImmVideoDetailViewModel = this.detailViewModel) != null) {
            uGCImmVideoDetailViewModel.f1(this.data, this.playProgress, this.totalDuration);
        }
        AppCompatImageView ivUgcImmCover = this.viewBinding.f73985j;
        Intrinsics.g(ivUgcImmCover, "ivUgcImmCover");
        jg.c.k(ivUgcImmCover);
        a.C0856a.f(c0856a, this.TAG, "onPlayerReset   visible  " + this, false, 4, null);
        AppCompatImageView ivUgcImmPlayStatus = this.viewBinding.f73989n;
        Intrinsics.g(ivUgcImmPlayStatus, "ivUgcImmPlayStatus");
        jg.c.g(ivUgcImmPlayStatus);
        com.transsion.player.orplayer.g gVar = this.orPlayer;
        if (gVar != null) {
            gVar.removePlayerListener(this);
        }
        this.orPlayer = null;
        this.orPlayerView = null;
        this.pagerLayoutManager = null;
        W(0L);
        X(100L);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e mediaSource) {
        b0 H;
        UGCVideoDetailPlayBean uGCVideoDetailPlayBean;
        com.transsion.player.orplayer.g gVar;
        b0 H2;
        UGCVideo ugcVideo;
        if (this.isPrepare) {
            return;
        }
        this.isPrepare = true;
        com.transsion.player.orplayer.g gVar2 = this.orPlayer;
        long duration = gVar2 != null ? gVar2.getDuration() : 0L;
        this.totalDuration = duration;
        X(duration);
        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel = this.detailViewModel;
        if (uGCImmVideoDetailViewModel != null && (H = uGCImmVideoDetailViewModel.H()) != null && (uGCVideoDetailPlayBean = (UGCVideoDetailPlayBean) H.f()) != null) {
            String ugcVideoId = uGCVideoDetailPlayBean.getUgcVideoId();
            UGCImmVideo uGCImmVideo = this.data;
            if (Intrinsics.c(ugcVideoId, (uGCImmVideo == null || (ugcVideo = uGCImmVideo.getUgcVideo()) == null) ? null : ugcVideo.getUgcVideoId())) {
                long progress = uGCVideoDetailPlayBean.getProgress();
                a.C0856a.f(lg.a.f68962a, this.TAG, "player- onPrepare, duration = " + this.viewBinding.f74000y.getCurrentProgress() + ", progress = " + progress + "  duration = " + duration, false, 4, null);
                UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel2 = this.detailViewModel;
                if (uGCImmVideoDetailViewModel2 != null && (H2 = uGCImmVideoDetailViewModel2.H()) != null) {
                    H2.q(null);
                }
                if (progress > 0 && Math.abs(duration - progress) > 2000 && (gVar = this.orPlayer) != null) {
                    gVar.seekTo(progress);
                }
            }
        }
        setKeepScreenOn(true);
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long progress, ao.e mediaSource) {
        this.playProgress = progress;
        getPlayerDelegate().b(progress, getGestureDelegate().k());
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        a.C0856a c0856a = lg.a.f68962a;
        String str = this.TAG;
        AppCompatImageView ivUgcImmCover = this.viewBinding.f73985j;
        Intrinsics.g(ivUgcImmCover, "ivUgcImmCover");
        a.C0856a.f(c0856a, str, "player-onRenderFirstFrame   viewBinding.ivCover.isVisible:" + (ivUgcImmCover.getVisibility() == 0) + " ", false, 4, null);
        if (!this.isFirstFrame) {
            this.isFirstFrame = true;
            com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
            if (aVar != null) {
                aVar.m();
            }
        }
        setLoading(false);
        AppCompatImageView ivUgcImmCover2 = this.viewBinding.f73985j;
        Intrinsics.g(ivUgcImmCover2, "ivUgcImmCover");
        jg.c.g(ivUgcImmCover2);
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.f();
        }
        com.transsion.ugcvideodetail.hepler.a aVar2 = this.dotLayer;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.h(event, "event");
        if (getGestureDelegate().m(event)) {
            return true;
        }
        return super.onTouchEvent(event);
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
        getPlayerDelegate().c();
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int width, int height) {
        f.a.H(this, width, height);
        Y(Integer.valueOf(width), Integer.valueOf(height));
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e mediaSource) {
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onVideoStart", false, 4, null);
        onPrepare(mediaSource);
        getPlayerDelegate().d();
    }

    public final void reset() {
        a.C0856a.f(lg.a.f68962a, this.TAG, "playNewMedia data: " + this.data, false, 4, null);
        setKeepScreenOn(false);
        this.isClickPause = false;
        UGCImmVideoDetailFragment uGCImmVideoDetailFragment = this.fragment;
        if (uGCImmVideoDetailFragment != null) {
            uGCImmVideoDetailFragment.b1(false);
        }
        this.isFirstFrame = false;
        UGCImmVideo uGCImmVideo = this.data;
        boolean isFree = uGCImmVideo != null ? uGCImmVideo.isFree() : false;
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.c(isFree, false);
        }
        AppCompatImageView ivUgcImmPlayStatus = this.viewBinding.f73989n;
        Intrinsics.g(ivUgcImmPlayStatus, "ivUgcImmPlayStatus");
        jg.c.g(ivUgcImmPlayStatus);
        W(0L);
        X(100L);
    }

    public final void setData(Integer adapterPosition, UGCImmVideoDetailFragment fragment, String trackId, String previousTrackId, String previousPageVideoId, UGCImmVideo data) {
        FragmentActivity activity;
        Intrinsics.h(trackId, "trackId");
        Intrinsics.h(data, "data");
        a.C0856a.f(lg.a.f68962a, this.TAG, "--------------------------setData position:" + adapterPosition, false, 4, null);
        this.data = data;
        this.trackId = trackId;
        this.previousTrackId = previousTrackId;
        this.previousPageVideoId = previousPageVideoId;
        this.fragment = fragment;
        this.isSubscriptionInitiatedByThisView = false;
        com.transsion.ugcvideodetail.hepler.a aVar = new com.transsion.ugcvideodetail.hepler.a("/ugc_video/immersive_detail", fragment != null ? fragment.getLastPageFrom() : null);
        this.dotLayer = aVar;
        aVar.s(data.getUgcVideo());
        com.transsion.ugcvideodetail.hepler.a aVar2 = this.dotLayer;
        if (aVar2 != null) {
            aVar2.r(adapterPosition);
        }
        if (fragment != null && (activity = fragment.getActivity()) != null) {
            this.detailViewModel = (UGCImmVideoDetailViewModel) new v0(activity).a(UGCImmVideoDetailViewModel.class);
            this.subtitleViewModel = (com.transsion.ugcvideodetail.hepler.subtitle.a) new v0(activity).a(com.transsion.ugcvideodetail.hepler.subtitle.a.class);
            this.downloadViewModel = (UGCDownloadViewModel) new v0(activity).a(UGCDownloadViewModel.class);
        }
        setContent(data);
    }

    public final void setDownloadStatus(int status) {
        if (this.isDownloadImmediately && status != this.curStatus) {
            this.curStatus = status;
            UGCImmVideo uGCImmVideo = this.data;
            if (uGCImmVideo != null) {
                uGCImmVideo.setDownloadStatus(status);
            }
            V(status);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }

    public final void setVideoUrl(String url) {
        Intrinsics.h(url, "url");
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.u(url);
        }
    }

    public final void videoStartPrepare() {
        this.isFirstFrame = false;
        com.transsion.ugcvideodetail.hepler.a aVar = this.dotLayer;
        if (aVar != null) {
            aVar.f();
        }
        com.transsion.ugcvideodetail.hepler.a aVar2 = this.dotLayer;
        if (aVar2 != null) {
            aVar2.a();
        }
        setLoading(true);
    }
}
