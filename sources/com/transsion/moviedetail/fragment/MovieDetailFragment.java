package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.Lifecycle;
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
import com.tn.lib.widget.R$color;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.bean.GameInfoType;
import com.transsion.commercializationapi.IGameResApi;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.MemberSource;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectGameInfo;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.player.longvideo.constants.LongVodPageType;
import com.transsion.player.longvideo.intercept.PlaybackInterceptionManager;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.player.p007enum.PlayMimeType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.publish.api.IPublishApi;
import com.transsion.push.PushConstants;
import com.transsion.rewardscenterapi.IRewardsCenterApi;
import com.transsion.rewardscenterapi.Lottery;
import com.transsion.rewardscenterapi.RewardsCenterData;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import fo.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
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
import org.mvel2.ast.ASTNode;
import ox.e;

@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Ü\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0005J\u0019\u0010'\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0019H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010\u0005J\u0017\u00103\u001a\u00020\u00192\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J\u0011\u00106\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0005J\u0017\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b=\u0010\u0005J\u0017\u0010>\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b>\u0010\u000bJ\u0019\u0010A\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\bH\u0002¢\u0006\u0004\bD\u0010\u000bJ1\u0010J\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00192\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020F2\b\b\u0002\u0010I\u001a\u00020\u0019H\u0002¢\u0006\u0004\bJ\u0010KJ\u0019\u0010N\u001a\u00020\u00062\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0006H\u0016¢\u0006\u0004\bP\u0010\u0005J\u0017\u0010S\u001a\u00020\u00022\u0006\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020FH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0019H\u0016¢\u0006\u0004\bW\u0010\u001bJ\u000f\u0010X\u001a\u00020\u0006H\u0016¢\u0006\u0004\bX\u0010\u0005J\u000f\u0010Y\u001a\u00020\u0006H\u0016¢\u0006\u0004\bY\u0010\u0005J\u000f\u0010Z\u001a\u00020\u0006H\u0016¢\u0006\u0004\bZ\u0010\u0005J\u000f\u0010[\u001a\u00020\u0006H\u0016¢\u0006\u0004\b[\u0010\u0005J\u000f\u0010]\u001a\u00020\\H\u0016¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\u0006H\u0016¢\u0006\u0004\b_\u0010\u0005J\u0011\u0010a\u001a\u0004\u0018\u00010`H\u0016¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\u0006H\u0016¢\u0006\u0004\bc\u0010\u0005J\u000f\u0010d\u001a\u00020\u0006H\u0016¢\u0006\u0004\bd\u0010\u0005J\u000f\u0010e\u001a\u00020\u0006H\u0016¢\u0006\u0004\be\u0010\u0005J\u000f\u0010f\u001a\u00020\u0006H\u0016¢\u0006\u0004\bf\u0010\u0005J\r\u0010g\u001a\u00020\u0006¢\u0006\u0004\bg\u0010\u0005J\u000f\u0010h\u001a\u00020\u0006H\u0016¢\u0006\u0004\bh\u0010\u0005J\u0017\u0010j\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u0019H\u0016¢\u0006\u0004\bj\u0010/J\u000f\u0010k\u001a\u00020\u0006H\u0016¢\u0006\u0004\bk\u0010\u0005J\u000f\u0010l\u001a\u00020\u0006H\u0016¢\u0006\u0004\bl\u0010\u0005J\u001f\u0010o\u001a\u00020\u00062\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010mH\u0016¢\u0006\u0004\bo\u0010pR\u0018\u0010t\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010x\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010{\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u001d\u0010\u0081\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0086\u0001\u001a\u00030\u0082\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0083\u0001\u0010~\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0087\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0088\u0001\u0010~\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010\u0091\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u008d\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u008d\u0001R\u0019\u0010\u009a\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0095\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u0095\u0001R\u001b\u0010\u009e\u0001\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u008d\u0001R(\u0010£\u0001\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u009f\u0001\u0010\u0090\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0005\b¢\u0001\u0010(R\u0019\u0010¥\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010\u0095\u0001R\u0019\u0010§\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010\u0090\u0001R\u001b\u0010©\u0001\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010\u008d\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0019\u0010¯\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u0095\u0001R\u001b\u0010²\u0001\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u0019\u0010´\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010\u0095\u0001R\u001c\u0010¸\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\"\u0010½\u0001\u001a\u0005\u0018\u00010¹\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bº\u0001\u0010~\u001a\u0006\b»\u0001\u0010¼\u0001R\u0019\u0010À\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010Ã\u0001\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R!\u0010Æ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u0019\u0010È\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010¿\u0001R\u0019\u0010Ê\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010¿\u0001R\u0019\u0010Ì\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010¿\u0001R\u0019\u0010Î\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010¿\u0001R\u0019\u0010Ð\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010¿\u0001R\u0019\u0010Ò\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010¿\u0001R\u0019\u0010Ô\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010¿\u0001R\u0019\u0010Õ\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010¿\u0001R\u001c\u0010Ø\u0001\u001a\u0005\u0018\u00010Ö\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010×\u0001R\u0018\u0010H\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010\u008d\u0001R\u0019\u0010Û\u0001\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010\u008d\u0001¨\u0006Ý\u0001"}, d2 = {"Lcom/transsion/moviedetail/fragment/MovieDetailFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lcn/h;", "Lyn/a;", "<init>", "()V", "", "R1", "Lcom/transsion/moviedetailapi/bean/Subject;", "movieDetailBean", "Y1", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "I1", "subject", "L1", "Lcom/transsion/moviedetailapi/bean/Trailer;", "trailer", "A1", "(Lcom/transsion/moviedetailapi/bean/Trailer;)V", "", "Lgo/c;", "c1", "(Lcom/transsion/moviedetailapi/bean/Trailer;)Ljava/util/List;", "Q1", "f1", "", "t1", "()Z", "k1", "R0", "U0", "Q0", "d1", "T0", "V1", "V0", "v1", "", "visible", "W1", "(I)V", "", "tsLayoutDone", "D1", "(J)V", PushConstants.PUSH_SERVICE_TYPE_SHOW, "x1", "(Z)V", "n1", "Lcom/transsion/videofloat/bean/FloatActionType;", "actionType", "M1", "(Lcom/transsion/videofloat/bean/FloatActionType;)Z", "Lpx/a;", "W0", "()Lpx/a;", "h1", "Lcom/transsion/player/longvideo/ui/LongVodUiType;", "uiType", "y1", "(Lcom/transsion/player/longvideo/ui/LongVodUiType;)V", "P1", "l1", "Lgo/a;", "bean", "z1", "(Lgo/a;)V", "data", "S1", "isShow", "", "sceneId", "traceId", "uiChange", "E1", "(ZLjava/lang/String;Ljava/lang/String;Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "receiveArguments", "Landroid/view/LayoutInflater;", "inflater", "b1", "(Landroid/view/LayoutInflater;)Lcn/h;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "isRegisteDeviceKeyMonitor", "initViewData", "initViewModel", "initListener", "retryLoadData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "loadDefaultData", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "onDestroyView", "onResume", "onPause", "onStop", "C1", "onDestroy", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "onHomeClick", "onRecentClick", "Lkotlin/Function0;", "callback", "R", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/transsnet/downloader/widget/DownloadView;", "a", "Lcom/transsnet/downloader/widget/DownloadView;", "downloadViewFloat", "Ltn/e;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ltn/e;", "bottomRecHelper", "c", "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "d", "Lkotlin/Lazy;", "Z0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "Lcom/transsnet/downloader/viewmodel/k0;", "e", "getDownloadViewModel", "()Lcom/transsnet/downloader/viewmodel/k0;", "downloadViewModel", "Lcom/transsion/publish/api/IPublishApi;", "f", "a1", "()Lcom/transsion/publish/api/IPublishApi;", "publishedApi", be.g.f16474b, "Ljava/lang/String;", "mSubjectId", "h", "I", "mSubjectType", "i", "ops", com.mbridge.msdk.foundation.same.report.j.f35620b, "Z", "netResultSuccess", CampaignEx.JSON_KEY_AD_K, "moduleName", "l", "autoDownload", "m", "autoPlay", "n", "autoPlayResourceId", "o", "getPreloadId", "()I", "setPreloadId", "preloadId", TtmlNode.TAG_P, "fetchDownloadFinish", CampaignEx.JSON_KEY_AD_Q, "curSeason", CampaignEx.JSON_KEY_AD_R, "lastPageFrom", "Lfo/a;", "s", "Lfo/a;", "playerControl", "t", "hasClickedActivityTip", TmcStartParams.KEY_URL_SHORT, "Landroid/view/View;", "gameResView", "v", "isGameResInit", "Lcom/transsion/fissionapi/IFissionProvider;", "w", "Lcom/transsion/fissionapi/IFissionProvider;", "palmPayApi", "Lcom/transsion/memberapi/IMemberApi;", "x", "Y0", "()Lcom/transsion/memberapi/IMemberApi;", "memberProvider", "y", "J", "curAudioTrackPlayProgress", "z", "Lcom/transsion/player/longvideo/ui/LongVodUiType;", "curPlayerUiType", "A", "Lkotlin/jvm/functions/Function0;", "backPressedCallback", "B", "tsEnter", "C", "tsRequestStart", "D", "tsCallback", "E", "tsInitStart", "F", "tsInitDone", "G", "tsAddView", "H", "tsViewCreatedStart", "tsViewCreatedEnd", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "coverFragment", "K", "L", "curSubjectId", "M", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class MovieDetailFragment extends PageStatusFragment<cn.h> implements yn.a {

    /* renamed from: M, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private Function0 backPressedCallback;

    /* renamed from: B, reason: from kotlin metadata */
    private long tsEnter;

    /* renamed from: C, reason: from kotlin metadata */
    private long tsRequestStart;

    /* renamed from: D, reason: from kotlin metadata */
    private long tsCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private long tsInitStart;

    /* renamed from: F, reason: from kotlin metadata */
    private long tsInitDone;

    /* renamed from: G, reason: from kotlin metadata */
    private long tsAddView;

    /* renamed from: H, reason: from kotlin metadata */
    private long tsViewCreatedStart;

    /* renamed from: I, reason: from kotlin metadata */
    private long tsViewCreatedEnd;

    /* renamed from: J, reason: from kotlin metadata */
    private Fragment coverFragment;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private DownloadView downloadViewFloat;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private tn.e bottomRecHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
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

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean fetchDownloadFinish;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private fo.a playerControl;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean hasClickedActivityTip;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private View gameResView;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean isGameResInit;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private long curAudioTrackPlayProgress;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$2
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
    private final Lazy downloadViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsnet.downloader.viewmodel.k0.class), new Function0<androidx.view.x0>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$4
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
    private final Lazy publishedApi = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.y
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IPublishApi B1;
            B1 = MovieDetailFragment.B1();
            return B1;
        }
    });

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mSubjectType = SubjectType.MOVIE.getValue();

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int curSeason = 1;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private IFissionProvider palmPayApi = (IFissionProvider) TheRouter.d(IFissionProvider.class, new Object[0]);

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final Lazy memberProvider = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.fragment.z
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IMemberApi u12;
            u12 = MovieDetailFragment.u1();
            return u12;
        }
    });

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private LongVodUiType curPlayerUiType = LongVodUiType.MIDDLE;

    /* renamed from: K, reason: from kotlin metadata */
    private String traceId = "";

    /* renamed from: L, reason: from kotlin metadata */
    private String curSubjectId = "";

    /* renamed from: com.transsion.moviedetail.fragment.MovieDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MovieDetailFragment a() {
            return new MovieDetailFragment();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BubbleTextView bubbleTextView;
            ViewTreeObserver viewTreeObserver;
            cn.h mViewBinding = MovieDetailFragment.this.getMViewBinding();
            if (mViewBinding != null && (bubbleTextView = mViewBinding.f17437b) != null && (viewTreeObserver = bubbleTextView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            cn.h mViewBinding2 = MovieDetailFragment.this.getMViewBinding();
            BubbleTextView bubbleTextView2 = mViewBinding2 != null ? mViewBinding2.f17437b : null;
            if (bubbleTextView2 == null || bubbleTextView2.getMeasuredWidth() == 0) {
                return;
            }
            float measuredWidth = (bubbleTextView2.getMeasuredWidth() / 2) - (com.blankj.utilcode.util.a0.a(16.0f) / 2);
            bubbleTextView2.setArrowPosition(measuredWidth);
            a.C0856a.f(lg.a.f68962a, "movie_detail", "activity tip width: " + bubbleTextView2.getMeasuredWidth() + ", arrowPosition: " + measuredWidth, false, 4, null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends androidx.activity.u {
        c() {
            super(true);
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            Function0 function0 = MovieDetailFragment.this.backPressedCallback;
            if (function0 == null || !((Boolean) function0.invoke()).booleanValue()) {
                if (MovieDetailFragment.this.playerControl != null) {
                    fo.a aVar = MovieDetailFragment.this.playerControl;
                    if (aVar != null) {
                        aVar.onBackPressed();
                        return;
                    }
                    return;
                }
                FragmentActivity activity = MovieDetailFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f47083a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f47083a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f47083a;
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
            this.f47083a.invoke(obj);
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements sx.a {
        e() {
        }

        @Override // sx.a
        public boolean a(px.a aVar) {
            return false;
        }

        @Override // sx.a
        public void b(px.a aVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("oneroom://com.community.oneroom?type=/movie/detail&id=" + (aVar != null ? aVar.r() : null)));
            intent.setFlags(ASTNode.DEOP);
            Utils.a().startActivity(intent);
        }

        @Override // sx.a
        public void c(px.a aVar) {
        }
    }

    /* loaded from: classes5.dex */
    public static final class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LongVodPlayerView f47084a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MovieDetailFragment f47085b;

        f(LongVodPlayerView longVodPlayerView, MovieDetailFragment movieDetailFragment) {
            this.f47084a = longVodPlayerView;
            this.f47085b = movieDetailFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f47084a.getWidth() == 0 || this.f47084a.getHeight() == 0) {
                return;
            }
            this.f47084a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f47085b.D1(SystemClock.elapsedRealtime());
        }
    }

    /* loaded from: classes5.dex */
    public static final class g implements a.b {
        g() {
        }

        @Override // fo.a.b
        public void a() {
        }

        @Override // fo.a.b
        public boolean b() {
            return false;
        }

        @Override // fo.a.b
        public boolean c(FloatActionType actionType) {
            Intrinsics.h(actionType, "actionType");
            return MovieDetailFragment.this.M1(actionType);
        }

        @Override // fo.a.b
        public void d(LongVodUiType uiType) {
            Intrinsics.h(uiType, "uiType");
            MovieDetailFragment.this.curPlayerUiType = uiType;
            MovieDetailFragment.this.y1(uiType);
            tn.e eVar = MovieDetailFragment.this.bottomRecHelper;
            if (eVar != null) {
                eVar.x(uiType != LongVodUiType.MIDDLE);
            }
        }

        @Override // fo.a.b
        public View e() {
            return MovieDetailFragment.this.gameResView;
        }

        @Override // fo.a.b
        public void f(go.a aVar) {
            MovieDetailFragment.this.z1(aVar);
        }

        @Override // fo.a.b
        public void g(boolean z10) {
            AppCompatImageView appCompatImageView;
            cn.h mViewBinding = MovieDetailFragment.this.getMViewBinding();
            if (mViewBinding == null || (appCompatImageView = mViewBinding.f17447l) == null) {
                return;
            }
            appCompatImageView.setVisibility(z10 ? 0 : 8);
        }

        @Override // fo.a.b
        public void h(String str) {
            a.b.C0785a.a(this, str);
        }

        @Override // fo.a.b
        public void onCompletion() {
        }
    }

    private final void A1(Trailer trailer) {
        Subject subject;
        String averageHueLight;
        String thumbnail;
        String url;
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 == null || !subject2.isFamilyModeIntercept()) {
            Q1();
            String str = this.mSubjectId;
            if (str == null || (subject = this.mMovieDetailBean) == null) {
                return;
            }
            PlayMimeType playMimeType = PlayMimeType.DEFAULT;
            long j11 = this.curAudioTrackPlayProgress;
            String title = subject.getTitle();
            String str2 = title == null ? "" : title;
            String str3 = this.lastPageFrom;
            String str4 = str3 == null ? "" : str3;
            List c12 = c1(trailer);
            Cover cover = trailer.getCover();
            String str5 = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
            Cover cover2 = trailer.getCover();
            String str6 = (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail;
            Cover cover3 = subject.getCover();
            String str7 = (cover3 == null || (averageHueLight = cover3.getAverageHueLight()) == null) ? "" : averageHueLight;
            Integer durationSeconds = subject.getDurationSeconds();
            int intValue = durationSeconds != null ? durationSeconds.intValue() : 0;
            Integer subjectType = subject.getSubjectType();
            go.a aVar = new go.a(str, playMimeType, j11, 0, 0, str2, null, str4, "subjectdetail", c12, str5, str6, str7, intValue, Integer.valueOf(subjectType != null ? subjectType.intValue() : 1), false, subject.getTitle(), subject.getOps(), 32832, null);
            aVar.A(this.mMovieDetailBean);
            lg.a.f68962a.c("movie_detail", "playTrailer  addDataSource:" + aVar + "  playerControl:" + this.playerControl, true);
            fo.a aVar2 = this.playerControl;
            if (aVar2 != null) {
                aVar2.setDataSource(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPublishApi B1() {
        return (IPublishApi) TheRouter.d(IPublishApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(long tsLayoutDone) {
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
        hj.i.f64628a.s("subjectdetail", "app_perf", hashMap);
    }

    private final void E1(boolean isShow, String sceneId, String traceId, boolean uiChange) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        Context context;
        cn.h mViewBinding;
        FrameLayout frameLayout4;
        FrameLayout frameLayout5;
        if (!isShow) {
            cn.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (frameLayout = mViewBinding2.f17444i) == null) {
                return;
            }
            frameLayout.setVisibility(8);
            return;
        }
        cn.h mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (frameLayout3 = mViewBinding3.f17444i) != null && (context = frameLayout3.getContext()) != null) {
            IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
            View a11 = iPremiumApi != null ? IPremiumApi.a.a(iPremiumApi, context, 0, new Function0() { // from class: com.transsion.moviedetail.fragment.w
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit G1;
                    G1 = MovieDetailFragment.G1(MovieDetailFragment.this);
                    return G1;
                }
            }, new Function0() { // from class: com.transsion.moviedetail.fragment.x
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit H1;
                    H1 = MovieDetailFragment.H1();
                    return H1;
                }
            }, MemberSource.SOURCE_LANDSCAPE_PLAY, null, "subjectdetail", traceId, sceneId, this.mSubjectId, 32, null) : null;
            if (a11 != null && (mViewBinding = getMViewBinding()) != null && (frameLayout4 = mViewBinding.f17444i) != null && frameLayout4.indexOfChild(a11) == -1) {
                ViewParent parent = a11.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(a11);
                }
                cn.h mViewBinding4 = getMViewBinding();
                if (mViewBinding4 != null && (frameLayout5 = mViewBinding4.f17444i) != null) {
                    frameLayout5.addView(a11);
                }
            }
        }
        cn.h mViewBinding5 = getMViewBinding();
        if (mViewBinding5 == null || (frameLayout2 = mViewBinding5.f17444i) == null) {
            return;
        }
        frameLayout2.setVisibility(0);
    }

    static /* synthetic */ void F1(MovieDetailFragment movieDetailFragment, boolean z10, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        movieDetailFragment.E1(z10, str, str2, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1(MovieDetailFragment movieDetailFragment) {
        FrameLayout frameLayout;
        cn.h mViewBinding = movieDetailFragment.getMViewBinding();
        if (mViewBinding != null && (frameLayout = mViewBinding.f17444i) != null) {
            frameLayout.setVisibility(8);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1() {
        return Unit.f67184a;
    }

    private final void I1() {
        GradientTextView gradientTextView;
        AppCompatImageView appCompatImageView;
        final Subject subject = this.mMovieDetailBean;
        if (subject != null) {
            cn.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (appCompatImageView = mViewBinding.f17448m) != null) {
                appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MovieDetailFragment.J1(MovieDetailFragment.this, subject, view);
                    }
                });
            }
            cn.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (gradientTextView = mViewBinding2.f17455t) == null) {
                return;
            }
            gradientTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MovieDetailFragment.K1(MovieDetailFragment.this, subject, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(MovieDetailFragment movieDetailFragment, Subject subject, View view) {
        String str;
        IPublishApi a12 = movieDetailFragment.a1();
        if (a12 != null) {
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            String str2 = movieDetailFragment.mSubjectId;
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
            a12.e(context, str2, str, title, description, 3);
        }
        com.transsion.baselib.helper.a.f43316a.h("subjectdetail", "post", (r16 & 4) != 0 ? "" : null, (r16 & 8) != 0 ? "" : null, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? null : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(MovieDetailFragment movieDetailFragment, Subject subject, View view) {
        String str;
        IPublishApi a12 = movieDetailFragment.a1();
        if (a12 != null) {
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            String str2 = movieDetailFragment.mSubjectId;
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
            a12.e(context, str2, str, title, description, 3);
        }
        com.transsion.baselib.helper.a.f43316a.h("subjectdetail", "post", (r16 & 4) != 0 ? "" : null, (r16 & 8) != 0 ? "" : null, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? null : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void L1(com.transsion.moviedetailapi.bean.Subject r26) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.moviedetail.fragment.MovieDetailFragment.L1(com.transsion.moviedetailapi.bean.Subject):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M1(final FloatActionType actionType) {
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
            final px.a W0 = W0();
            if (W0 != null) {
                if (actionType != floatActionType && !W0.f().isPlaying()) {
                    lg.a.f68962a.c("VideoFloat-pip", "movie 视频暂停，无需触发画中画", true);
                    return false;
                }
                e.a aVar = ox.e.f72320a;
                if (aVar.b().c()) {
                    lg.a.f68962a.c("VideoFloat-pip", "movie 当前可用画中画，使用画中画播放", true);
                    if (Build.VERSION.SDK_INT < 31 || actionType != FloatActionType.HOME) {
                        aVar.b().k(activity, W0, actionType, this.curPlayerUiType == LongVodUiType.LAND);
                    } else {
                        cn.h mViewBinding = getMViewBinding();
                        if (mViewBinding != null && (root = mViewBinding.getRoot()) != null) {
                            root.postDelayed(new Runnable() { // from class: com.transsion.moviedetail.fragment.i
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MovieDetailFragment.N1(FragmentActivity.this, W0, actionType, this);
                                }
                            }, 1000L);
                        }
                    }
                    return true;
                }
                ox.b.f72314a.c().g(activity, W0, actionType == floatActionType, this.curPlayerUiType == LongVodUiType.LAND, new Function1() { // from class: com.transsion.moviedetail.fragment.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit O1;
                        O1 = MovieDetailFragment.O1(FragmentActivity.this, ((Boolean) obj).booleanValue());
                        return O1;
                    }
                }, new e());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(FragmentActivity fragmentActivity, px.a aVar, FloatActionType floatActionType, MovieDetailFragment movieDetailFragment) {
        ox.e.f72320a.b().k(fragmentActivity, aVar, floatActionType, movieDetailFragment.curPlayerUiType == LongVodUiType.LAND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O1(FragmentActivity fragmentActivity, boolean z10) {
        if (z10 && fragmentActivity != null) {
            fragmentActivity.finish();
        }
        return Unit.f67184a;
    }

    private final void P1() {
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
        cn.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout3 = mViewBinding.f17446k) != null) {
            jg.c.k(frameLayout3);
        }
        cn.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (frameLayout2 = mViewBinding2.f17446k) != null) {
            frameLayout2.removeAllViews();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        cn.h mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (frameLayout = mViewBinding3.f17446k) == null) {
            return;
        }
        frameLayout.addView(this.gameResView, layoutParams);
    }

    private final boolean Q0() {
        IFissionProvider iFissionProvider;
        if (this.hasClickedActivityTip || (iFissionProvider = this.palmPayApi) == null) {
            return false;
        }
        return iFissionProvider.g();
    }

    private final void Q1() {
        Context context;
        Integer subjectType;
        if (this.playerControl == null && (context = getContext()) != null) {
            Subject subject = this.mMovieDetailBean;
            LongVodPageType longVodPageType = ((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) == SubjectType.MUSIC.getValue() ? LongVodPageType.MUSIC : LongVodPageType.TRAILER;
            cn.h mViewBinding = getMViewBinding();
            if (mViewBinding != null) {
                this.tsInitStart = SystemClock.elapsedRealtime();
                LongVodPlayerView longVodPlayerView = new LongVodPlayerView(context);
                String name = longVodPageType.name();
                Subject subject2 = this.mMovieDetailBean;
                a.C0784a.a(longVodPlayerView, "subjectdetail", longVodPageType, name + (subject2 != null ? subject2.getSubjectId() : null), mViewBinding.f17442g, mViewBinding.f17449n.f64722f, null, null, 96, null);
                Subject subject3 = this.mMovieDetailBean;
                longVodPlayerView.initAdHelper(subject3 != null ? subject3.getGenre() : null);
                cn.h mViewBinding2 = getMViewBinding();
                longVodPlayerView.setPortraitPremiumView(mViewBinding2 != null ? mViewBinding2.f17444i : null);
                longVodPlayerView.setFeedBackVisible(true);
                this.tsInitDone = SystemClock.elapsedRealtime();
                this.playerControl = longVodPlayerView;
                this.tsAddView = SystemClock.elapsedRealtime();
                mViewBinding.f17443h.addView(longVodPlayerView);
                longVodPlayerView.getViewTreeObserver().addOnGlobalLayoutListener(new f(longVodPlayerView, this));
            }
            Subject subject4 = this.mMovieDetailBean;
            if (subject4 != null) {
                l1(subject4);
            }
            fo.a aVar = this.playerControl;
            if (aVar != null) {
                aVar.setCallback(new g());
            }
        }
    }

    private final void R0() {
        if (t1()) {
            Subject subject = this.mMovieDetailBean;
            if (subject == null || !subject.isFamilyModeIntercept()) {
                cn.h mViewBinding = getMViewBinding();
                DownloadView downloadView = mViewBinding != null ? mViewBinding.f17439d : null;
                this.downloadViewFloat = downloadView;
                if (downloadView != null) {
                    downloadView.setPageFrom("subjectdetail");
                }
                DownloadView downloadView2 = this.downloadViewFloat;
                if (downloadView2 != null) {
                    DownloadView.setAttrs$default(downloadView2, null, Float.valueOf(com.transsion.core.utils.e.g(16.0f)), null, 5, null);
                }
                DownloadView downloadView3 = this.downloadViewFloat;
                if (downloadView3 != null) {
                    downloadView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MovieDetailFragment.S0(MovieDetailFragment.this, view);
                        }
                    });
                }
            }
        }
    }

    private final void R1() {
        new tn.g(this, R$id.subjectDetailLayout, this.mMovieDetailBean, "subjectdetail", this.moduleName, false, false, 96, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(MovieDetailFragment movieDetailFragment, View view) {
        ResourceDetectors resourceDetector;
        List<DownloadItem> resolutionList;
        Subject subject;
        ResourceDetectors resourceDetector2;
        ResourceDetectors resourceDetector3;
        List<DownloadItem> resolutionList2;
        Subject subject2 = movieDetailFragment.mMovieDetailBean;
        if (subject2 != null && (resourceDetector = subject2.getResourceDetector()) != null && (resolutionList = resourceDetector.getResolutionList()) != null && (!resolutionList.isEmpty())) {
            Subject subject3 = movieDetailFragment.mMovieDetailBean;
            Integer valueOf = (subject3 == null || (resourceDetector3 = subject3.getResourceDetector()) == null || (resolutionList2 = resourceDetector3.getResolutionList()) == null) ? null : Integer.valueOf(resolutionList2.size());
            Intrinsics.e(valueOf);
            if (valueOf.intValue() > 1 && (subject = movieDetailFragment.mMovieDetailBean) != null && (resourceDetector2 = subject.getResourceDetector()) != null) {
                resourceDetector2.setType(1);
            }
        }
        movieDetailFragment.U0();
    }

    private final void S1(Subject data) {
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
        if (!com.transsion.postdetail.util.h.f50221a.a(data)) {
            cn.h mViewBinding = getMViewBinding();
            if (mViewBinding == null || (memberGuideBannerView = mViewBinding.f17445j) == null) {
                return;
            }
            memberGuideBannerView.setVisibility(8);
            return;
        }
        cn.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (memberGuideBannerView3 = mViewBinding2.f17445j) != null) {
            memberGuideBannerView3.setVisibility(0);
        }
        cn.h mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (memberGuideBannerView2 = mViewBinding3.f17445j) == null) {
            return;
        }
        memberGuideBannerView2.setRefreshMemberInfo(new Function0() { // from class: com.transsion.moviedetail.fragment.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit T1;
                T1 = MovieDetailFragment.T1(MovieDetailFragment.this, memberGuideBannerView2);
                return T1;
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
        MemberGuideBannerView.setMemberInfo$default(memberGuideBannerView2, "subjectdetail", "video_detail/vip_banner", str2, subjectId2, false, valueOf, o11, iPremiumApi3 != null ? Boolean.valueOf(iPremiumApi3.u()) : null, 16, null);
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
        memberGuideBannerView2.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieDetailFragment.U1(MovieDetailFragment.this, memberGuideBannerView2, view);
            }
        });
    }

    private final void T0() {
        BubbleTextView bubbleTextView;
        ViewTreeObserver viewTreeObserver;
        cn.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f17437b) == null || (viewTreeObserver = bubbleTextView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T1(MovieDetailFragment movieDetailFragment, MemberGuideBannerView memberGuideBannerView) {
        Subject subject = movieDetailFragment.mMovieDetailBean;
        String subjectId = subject != null ? subject.getSubjectId() : null;
        String str = movieDetailFragment.traceId;
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        Boolean valueOf = iPremiumApi != null ? Boolean.valueOf(iPremiumApi.c()) : null;
        IPremiumApi iPremiumApi2 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        Integer o11 = iPremiumApi2 != null ? iPremiumApi2.o() : null;
        IPremiumApi iPremiumApi3 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        memberGuideBannerView.setMemberInfo("subjectdetail", "video_detail/vip_banner", str, subjectId, true, valueOf, o11, iPremiumApi3 != null ? Boolean.valueOf(iPremiumApi3.u()) : null);
        return Unit.f67184a;
    }

    private final void U0() {
        String str;
        List<ResourceDetectors> resourceDetectors;
        if (getContext() == null) {
            return;
        }
        V0();
        Subject subject = this.mMovieDetailBean;
        str = "";
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && !resourceDetectors.isEmpty()) {
            String resourceLink = resourceDetectors.get(0).getResourceLink();
            str = resourceLink != null ? resourceLink : "";
            resourceDetectors.get(0).getResourceId();
            resourceDetectors.get(0).isMultiResolution();
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
        DownloadManagerApi.N(a12, fragmentActivity2, subject4, "subjectdetail", "", str3, str2, null, this.moduleName, null, false, this.curSeason, false, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(MovieDetailFragment movieDetailFragment, MemberGuideBannerView memberGuideBannerView, View view) {
        PlaybackInterceptionManager playbackInterceptionManager;
        fo.a aVar = movieDetailFragment.playerControl;
        if (aVar == null || (playbackInterceptionManager = aVar.getPlaybackInterceptionManager()) == null) {
            F1(movieDetailFragment, true, "video_detail/vip_banner", movieDetailFragment.traceId, false, 8, null);
        } else {
            PlaybackInterceptionManager.X(playbackInterceptionManager, true, "video_detail/vip_banner", movieDetailFragment.traceId, false, 8, null);
        }
    }

    private final void V0() {
        BubbleTextView bubbleTextView;
        this.hasClickedActivityTip = true;
        cn.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f17437b) == null) {
            return;
        }
        jg.c.g(bubbleTextView);
    }

    private final void V1() {
        BubbleTextView bubbleTextView;
        DownloadView downloadView;
        DownloadView downloadView2;
        BubbleTextView bubbleTextView2;
        if (Q0() && (downloadView = this.downloadViewFloat) != null && downloadView.getVisibility() == 0 && (downloadView2 = this.downloadViewFloat) != null && downloadView2.getType() == 0) {
            cn.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (bubbleTextView2 = mViewBinding.f17437b) != null) {
                jg.c.k(bubbleTextView2);
            }
            T0();
            return;
        }
        cn.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (bubbleTextView = mViewBinding2.f17437b) == null) {
            return;
        }
        jg.c.g(bubbleTextView);
    }

    private final px.a W0() {
        String str;
        fo.a aVar = this.playerControl;
        com.transsion.player.orplayer.g player = aVar != null ? aVar.getPlayer() : null;
        fo.a aVar2 = this.playerControl;
        ORPlayerView orPlayerView = aVar2 != null ? aVar2.getOrPlayerView() : null;
        if (orPlayerView == null || player == null) {
            return null;
        }
        a.C0856a c0856a = lg.a.f68962a;
        Subject subject = this.mMovieDetailBean;
        c0856a.c("VideoFloat", "trailer--showFloat, title:" + (subject != null ? subject.getTitle() : null), true);
        FloatPlayType floatPlayType = FloatPlayType.TRAILER;
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 == null || (str = subject2.getSubjectId()) == null) {
            str = "";
        }
        return new px.a(orPlayerView, player, null, floatPlayType, str, 0, 0, "", "subjectdetail");
    }

    private final void W1(int visible) {
        HashMap g11;
        ResourceDetectors resourceDetector;
        List<ResourceDetectors> resourceDetectors;
        DownloadView downloadView = this.downloadViewFloat;
        if (downloadView != null) {
            downloadView.setVisibility(visible);
        }
        Subject subject = this.mMovieDetailBean;
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && !resourceDetectors.isEmpty()) {
            resourceDetectors.get(0).getResourceId();
            resourceDetectors.get(0).isMultiResolution();
        }
        Subject subject2 = this.mMovieDetailBean;
        if (subject2 != null && (resourceDetector = subject2.getResourceDetector()) != null) {
            resourceDetector.getResourceId();
            resourceDetector.isMultiResolution();
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
        }
        V1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(MovieDetailFragment movieDetailFragment, View view) {
        movieDetailFragment.requireActivity().finish();
    }

    static /* synthetic */ void X1(MovieDetailFragment movieDetailFragment, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        movieDetailFragment.W1(i11);
    }

    private final IMemberApi Y0() {
        return (IMemberApi) this.memberProvider.getValue();
    }

    private final void Y1(Subject movieDetailBean) {
        Subject subject;
        View view;
        View view2;
        FrameLayout frameLayout;
        this.mMovieDetailBean = movieDetailBean;
        if (!this.isGameResInit) {
            h1();
            x1(true);
        }
        Subject subject2 = this.mMovieDetailBean;
        String ops = subject2 != null ? subject2.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject = this.mMovieDetailBean) != null) {
            subject.setOps(this.ops);
        }
        Subject subject3 = this.mMovieDetailBean;
        if (subject3 == null || !subject3.isFamilyModeIntercept()) {
            L1(this.mMovieDetailBean);
        } else {
            cn.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (frameLayout = mViewBinding.f17443h) != null) {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                ((ViewGroup.MarginLayoutParams) bVar).height = dk.a.b(48);
                frameLayout.setLayoutParams(bVar);
            }
            cn.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (view2 = mViewBinding2.f17456u) != null) {
                jg.c.g(view2);
            }
            cn.h mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (view = mViewBinding3.f17457v) != null) {
                view.setBackgroundResource(R$color.bg_01);
            }
        }
        S1(movieDetailBean);
        if (this.downloadViewFloat == null) {
            R0();
            X1(this, 0, 1, null);
        }
        f1();
        k1();
        if (this.autoDownload) {
            this.autoDownload = false;
            DownloadView downloadView = this.downloadViewFloat;
            if (downloadView != null) {
                downloadView.post(new Runnable() { // from class: com.transsion.moviedetail.fragment.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        MovieDetailFragment.Z1(MovieDetailFragment.this);
                    }
                });
            }
        }
        I1();
    }

    private final MovieDetailViewModel Z0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(MovieDetailFragment movieDetailFragment) {
        movieDetailFragment.U0();
    }

    private final IPublishApi a1() {
        return (IPublishApi) this.publishedApi.getValue();
    }

    private final List c1(Trailer trailer) {
        Integer duration;
        String num;
        Long size;
        String l11;
        String url;
        String videoId;
        ArrayList arrayList = new ArrayList();
        PlayMimeType playMimeType = PlayMimeType.DEFAULT;
        PreVideoAddress videoAddress = trailer.getVideoAddress();
        String str = (videoAddress == null || (videoId = videoAddress.getVideoId()) == null) ? "" : videoId;
        PreVideoAddress videoAddress2 = trailer.getVideoAddress();
        String str2 = (videoAddress2 == null || (url = videoAddress2.getUrl()) == null) ? "" : url;
        PreVideoAddress videoAddress3 = trailer.getVideoAddress();
        String str3 = (videoAddress3 == null || (size = videoAddress3.getSize()) == null || (l11 = size.toString()) == null) ? "" : l11;
        PreVideoAddress videoAddress4 = trailer.getVideoAddress();
        arrayList.add(new go.c(playMimeType, str, str2, "", str3, (videoAddress4 == null || (duration = videoAddress4.getDuration()) == null || (num = duration.toString()) == null) ? "" : num, "", null, 128, null));
        return arrayList;
    }

    private final void d1() {
        BubbleTextView bubbleTextView;
        cn.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f17437b) == null) {
            return;
        }
        bubbleTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieDetailFragment.e1(MovieDetailFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(MovieDetailFragment movieDetailFragment, View view) {
        a.C0856a.f(lg.a.f68962a, "movie_detail", "Click activity tip", false, 4, null);
        movieDetailFragment.hasClickedActivityTip = true;
        Intrinsics.e(view);
        jg.c.g(view);
    }

    private final void f1() {
        Subject subject = this.mMovieDetailBean;
        cn.h mViewBinding = getMViewBinding();
        MagicIndicator magicIndicator = mViewBinding != null ? mViewBinding.f17450o : null;
        cn.h mViewBinding2 = getMViewBinding();
        this.bottomRecHelper = new tn.e(this, subject, magicIndicator, mViewBinding2 != null ? mViewBinding2.f17451p : null, "subjectdetail", false, false, new Function1() { // from class: com.transsion.moviedetail.fragment.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g12;
                g12 = MovieDetailFragment.g1(MovieDetailFragment.this, ((Integer) obj).intValue());
                return g12;
            }
        }, 96, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(MovieDetailFragment movieDetailFragment, int i11) {
        GradientTextView gradientTextView;
        DownloadView downloadView = movieDetailFragment.downloadViewFloat;
        if (downloadView != null && downloadView != null) {
            downloadView.setVisibility(i11 != 1 ? 0 : 8);
        }
        cn.h mViewBinding = movieDetailFragment.getMViewBinding();
        if (mViewBinding != null && (gradientTextView = mViewBinding.f17455t) != null) {
            gradientTextView.setVisibility(i11 == 1 ? 0 : 8);
        }
        return Unit.f67184a;
    }

    private final void h1() {
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
                a.C0856a.f(lg.a.f68962a, "GameResLoader", "sub detail game initGameRes", false, 4, null);
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
                iGameResApi.a(context, "subjectdetail", gameInfoType, str2, new Function1() { // from class: com.transsion.moviedetail.fragment.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit i12;
                        i12 = MovieDetailFragment.i1(MovieDetailFragment.this, (View) obj);
                        return i12;
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
        a.C0856a.l(lg.a.f68962a, "GameResLoader", "sub detail,  game is null", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(MovieDetailFragment movieDetailFragment, View view) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        movieDetailFragment.gameResView = view;
        if (view == null) {
            cn.h mViewBinding = movieDetailFragment.getMViewBinding();
            if (mViewBinding != null && (frameLayout2 = mViewBinding.f17446k) != null) {
                jg.c.g(frameLayout2);
            }
            cn.h mViewBinding2 = movieDetailFragment.getMViewBinding();
            if (mViewBinding2 != null && (frameLayout = mViewBinding2.f17446k) != null) {
                frameLayout.removeAllViews();
            }
        } else {
            movieDetailFragment.P1();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(MovieDetailFragment movieDetailFragment, View view) {
        FragmentActivity activity;
        if (movieDetailFragment.playerControl != null) {
            if (movieDetailFragment.M1(FloatActionType.BACK) || (activity = movieDetailFragment.getActivity()) == null) {
                return;
            }
            activity.finish();
            return;
        }
        FragmentActivity activity2 = movieDetailFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final void k1() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.w p11 = childFragmentManager.p();
        Intrinsics.g(p11, "beginTransaction()");
        Subject subject = this.mMovieDetailBean;
        if (subject != null && subject.isFamilyModeIntercept()) {
            ResourceDetectorFamilyModeFragment resourceDetectorFamilyModeFragment = new ResourceDetectorFamilyModeFragment();
            resourceDetectorFamilyModeFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("data_key_resource_detectors", this.mMovieDetailBean)));
            p11.s(R$id.resourceDetectorGroup, resourceDetectorFamilyModeFragment);
        } else if (t1()) {
            ResourceDetectorFragment resourceDetectorFragment = new ResourceDetectorFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.mMovieDetailBean);
            bundle.putString("ops", this.ops);
            bundle.putBoolean("auto_play", this.autoPlay);
            bundle.putString("auto_play_resource_id", this.autoPlayResourceId);
            bundle.putString("module_name", this.moduleName);
            bundle.putInt("season", this.curSeason);
            resourceDetectorFragment.setArguments(bundle);
            p11.s(R$id.resourceDetectorGroup, resourceDetectorFragment);
        } else {
            ResourceDetectorEmptyFragment resourceDetectorEmptyFragment = new ResourceDetectorEmptyFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("data_key_resource_detectors", this.mMovieDetailBean);
            resourceDetectorEmptyFragment.setArguments(bundle2);
            p11.s(R$id.resourceDetectorGroup, resourceDetectorEmptyFragment);
        }
        p11.j();
    }

    private final void l1(Subject movieDetailBean) {
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
            value = Utils.a().getString(R$string.movie_detail_restrict_tips);
        }
        final RestrictTipsDialog a11 = RestrictTipsDialog.INSTANCE.a(value, "subjectdetail", movieDetailBean.getSubjectId());
        a11.l0(this, "RestrictTipsDialog");
        a11.y0(new Function1() { // from class: com.transsion.moviedetail.fragment.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m12;
                m12 = MovieDetailFragment.m1(RestrictTipsDialog.this, this, ((Boolean) obj).booleanValue());
                return m12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(RestrictTipsDialog restrictTipsDialog, MovieDetailFragment movieDetailFragment, boolean z10) {
        if (z10) {
            fo.a aVar = movieDetailFragment.playerControl;
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

    private final void n1() {
        ConstraintLayout root;
        cn.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (root = mViewBinding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.moviedetail.fragment.e0
            @Override // java.lang.Runnable
            public final void run() {
                MovieDetailFragment.o1(MovieDetailFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(MovieDetailFragment movieDetailFragment) {
        Subject subject;
        String subjectId;
        String ops;
        FragmentActivity activity = movieDetailFragment.getActivity();
        if (activity == null || (subject = movieDetailFragment.mMovieDetailBean) == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        ox.b c11 = ox.b.f72314a.c();
        Subject subject2 = movieDetailFragment.mMovieDetailBean;
        c11.e(activity, subjectId, null, "subjectdetail", (subject2 == null || (ops = subject2.getOps()) == null) ? movieDetailFragment.ops : ops);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(MovieDetailFragment movieDetailFragment, Pair pair) {
        HashMap g11;
        HashMap g12;
        HashMap g13;
        movieDetailFragment.tsCallback = SystemClock.elapsedRealtime();
        Subject subject = (Subject) pair.getSecond();
        MovieDetailActivity.INSTANCE.a("movie_detail get movie detail data --> it = " + subject);
        if (subject == null) {
            if (Intrinsics.c(pair.getFirst(), "404")) {
                com.tn.lib.widget.toast.core.h.f41533a.k(R$string.movie_lost_content);
                kotlinx.coroutines.k.d(androidx.view.v.a(movieDetailFragment), null, null, new MovieDetailFragment$initViewModel$1$1$1(movieDetailFragment, null), 3, null);
            }
            if (nh.m.f70597a.e()) {
                PageStatusFragment.showEmptyView$default(movieDetailFragment, false, 1, null);
            } else {
                PageStatusFragment.showNoNetworkView$default(movieDetailFragment, false, 1, null);
            }
        } else {
            if (subject.getIsRefreshViewOnly()) {
                return Unit.f67184a;
            }
            MovieDetailViewModel Z0 = movieDetailFragment.Z0();
            String subjectId = subject.getSubjectId();
            Integer subjectType = subject.getSubjectType();
            Context context = movieDetailFragment.getContext();
            MovieDetailViewModel.u(Z0, subjectId, subjectType, 0, context != null && com.transsion.baseui.util.b.a(context), 4, null);
            Integer subjectType2 = subject.getSubjectType();
            movieDetailFragment.mSubjectType = subjectType2 != null ? subjectType2.intValue() : movieDetailFragment.mSubjectType;
            movieDetailFragment.showContentView();
            movieDetailFragment.netResultSuccess = true;
            movieDetailFragment.Y1(subject);
            movieDetailFragment.R1();
            hj.b logViewConfig = movieDetailFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            hj.b logViewConfig2 = movieDetailFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.n(movieDetailFragment.ops);
            }
            hj.b logViewConfig3 = movieDetailFragment.getLogViewConfig();
            if (logViewConfig3 != null && (g13 = logViewConfig3.g()) != null) {
                String subjectId2 = subject.getSubjectId();
                if (subjectId2 == null) {
                    subjectId2 = "";
                }
                g13.put("subject_id", subjectId2);
            }
            hj.b logViewConfig4 = movieDetailFragment.getLogViewConfig();
            if (logViewConfig4 != null && (g12 = logViewConfig4.g()) != null) {
                g12.put("has_resource", String.valueOf(subject.getHasResource()));
            }
            hj.b logViewConfig5 = movieDetailFragment.getLogViewConfig();
            if (logViewConfig5 != null && (g11 = logViewConfig5.g()) != null) {
                g11.put("module_name", movieDetailFragment.moduleName);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(MovieDetailFragment movieDetailFragment, DownloadListBean downloadListBean) {
        movieDetailFragment.fetchDownloadFinish = true;
        Subject subject = movieDetailFragment.mMovieDetailBean;
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.EDUCATION.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                movieDetailFragment.L1(movieDetailFragment.mMovieDetailBean);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(MovieDetailFragment movieDetailFragment, Integer num) {
        int i11 = movieDetailFragment.curSeason;
        if (num != null && i11 == num.intValue()) {
            return Unit.f67184a;
        }
        Intrinsics.e(num);
        movieDetailFragment.curSeason = num.intValue();
        String str = movieDetailFragment.mSubjectId;
        if (str != null) {
            movieDetailFragment.Z0().D(str, Integer.valueOf(movieDetailFragment.curSeason), true);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(MovieDetailFragment movieDetailFragment, DubsInfo dubsInfo) {
        fo.a aVar = movieDetailFragment.playerControl;
        movieDetailFragment.curAudioTrackPlayProgress = aVar != null ? aVar.currentPosition() : 0L;
        movieDetailFragment.mSubjectId = dubsInfo.getSubjectId();
        movieDetailFragment.mMovieDetailBean = null;
        MovieDetailViewModel Z0 = movieDetailFragment.Z0();
        int i11 = movieDetailFragment.preloadId;
        String str = movieDetailFragment.mSubjectId;
        if (str == null) {
            str = "";
        }
        Z0.S(i11, str, Integer.valueOf(movieDetailFragment.curSeason));
        movieDetailFragment.loadDefaultData();
        return Unit.f67184a;
    }

    private final boolean t1() {
        Boolean hasResource;
        Subject subject = this.mMovieDetailBean;
        if (subject == null || (hasResource = subject.getHasResource()) == null) {
            return false;
        }
        return hasResource.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMemberApi u1() {
        return (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
    }

    private final void v1() {
        Context context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.moviedetail.fragment.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit w12;
                w12 = MovieDetailFragment.w1(MovieDetailFragment.this, (AddToDownloadEvent) obj);
                return w12;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(MovieDetailFragment movieDetailFragment, AddToDownloadEvent value) {
        Intrinsics.h(value, "value");
        try {
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        if (!TextUtils.equals(value.getSubjectId(), movieDetailFragment.mSubjectId)) {
            return Unit.f67184a;
        }
        if (movieDetailFragment.downloadViewFloat != null) {
            X1(movieDetailFragment, 0, 1, null);
        }
        return Unit.f67184a;
    }

    private final void x1(boolean show) {
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
            IMemberApi Y0 = Y0();
            if (Y0 != null) {
                Y0.i();
                return;
            }
            return;
        }
        IMemberApi Y02 = Y0();
        if (Y02 != null) {
            Y02.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(LongVodUiType uiType) {
        if (this.gameResView == null || uiType != LongVodUiType.MIDDLE) {
            return;
        }
        P1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(go.a bean) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_PLAY").K("subject_id", this.mSubjectId);
        Subject subject = this.mMovieDetailBean;
        if (subject != null && subject.getType() == 3 && bean != null) {
            K.I("TV_DATA", new FbTvData(bean.o(), bean.l(), bean.e()));
        }
        Navigator.x(K, requireContext(), null, 2, null);
    }

    public final void C1() {
        fo.a aVar;
        ox.c cVar = ox.c.f72319a;
        fo.a aVar2 = this.playerControl;
        if (!cVar.c(aVar2 != null ? aVar2.getPlayer() : null) && (aVar = this.playerControl) != null) {
            aVar.release();
        }
        fo.a aVar3 = this.playerControl;
        if (aVar3 != null) {
            aVar3.onPageDestroy();
        }
    }

    @Override // yn.a
    public void R(Function0 callback) {
        this.backPressedCallback = callback;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public cn.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        cn.h c11 = cn.h.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View getLoadingView() {
        View inflate = LayoutInflater.from(requireContext()).inflate(R$layout.default_movie_detail_skeleton_drawing_layout_2, (ViewGroup) getFlStateView(), false);
        ((AppCompatImageView) inflate.findViewById(R$id.ivBack)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieDetailFragment.X0(MovieDetailFragment.this, view);
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
        cn.h mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f17447l.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MovieDetailFragment.j1(MovieDetailFragment.this, view);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        View view;
        this.tsViewCreatedStart = SystemClock.elapsedRealtime();
        cn.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (view = mViewBinding.f17457v) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = com.blankj.utilcode.util.d.c();
            view.setLayoutParams(bVar);
        }
        requireActivity().getOnBackPressedDispatcher().i(this, new c());
        v1();
        d1();
        n1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        MovieDetailViewModel Z0 = Z0();
        Z0.F().j(this, new d(new Function1() { // from class: com.transsion.moviedetail.fragment.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p12;
                p12 = MovieDetailFragment.p1(MovieDetailFragment.this, (Pair) obj);
                return p12;
            }
        }));
        Z0.y().j(this, new d(new Function1() { // from class: com.transsion.moviedetail.fragment.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q12;
                q12 = MovieDetailFragment.q1(MovieDetailFragment.this, (DownloadListBean) obj);
                return q12;
            }
        }));
        Z0.K().j(this, new d(new Function1() { // from class: com.transsion.moviedetail.fragment.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r12;
                r12 = MovieDetailFragment.r1(MovieDetailFragment.this, (Integer) obj);
                return r12;
            }
        }));
        Z0.P().j(this, new d(new Function1() { // from class: com.transsion.moviedetail.fragment.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s12;
                s12 = MovieDetailFragment.s1(MovieDetailFragment.this, (DubsInfo) obj);
                return s12;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isRegisteDeviceKeyMonitor() {
        return true;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        HashMap g11;
        MovieDetailActivity.INSTANCE.a("movie_detail start load data ....");
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
            showLoadingView();
            String str2 = this.mSubjectId;
            if (str2 != null) {
                this.tsRequestStart = SystemClock.elapsedRealtime();
                MovieDetailViewModel.E(Z0(), str2, Integer.valueOf(this.curSeason), false, 4, null);
            }
        }
        this.tsViewCreatedEnd = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("subjectdetail", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieDetailActivity.INSTANCE.a("movie_detail------- onCreate ------");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        fo.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onPageDestroy();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void onHomeClick() {
        super.onHomeClick();
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "MovieDetailFragment onHomeClick", false, 4, null);
        M1(FloatActionType.HOME);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ox.c cVar = ox.c.f72319a;
        fo.a aVar = this.playerControl;
        cVar.c(aVar != null ? aVar.getPlayer() : null);
        x1(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        if (isInPictureInPictureMode) {
            FragmentActivity activity = getActivity();
            if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            px.a W0 = W0();
            if (W0 != null && Build.VERSION.SDK_INT >= 31) {
                ox.e.f72320a.b().h(activity, W0);
            }
        }
        ox.e.f72320a.b().onPipModeChanged(isInPictureInPictureMode);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void onRecentClick() {
        super.onRecentClick();
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "MovieDetailFragment onRecentClick", false, 4, null);
        M1(FloatActionType.HOME);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        fo.a aVar = this.playerControl;
        if (aVar != null) {
            aVar.onViewResume();
        }
        x1(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        fo.a aVar;
        super.onStop();
        ox.c cVar = ox.c.f72319a;
        fo.a aVar2 = this.playerControl;
        if (cVar.c(aVar2 != null ? aVar2.getPlayer() : null) || (aVar = this.playerControl) == null) {
            return;
        }
        aVar.onViewPause();
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
        this.mSubjectType = arguments4 != null ? arguments4.getInt("subject_type", this.mSubjectType) : this.mSubjectType;
        Bundle arguments5 = getArguments();
        this.autoDownload = arguments5 != null ? arguments5.getBoolean("auto_download") : false;
        Bundle arguments6 = getArguments();
        this.autoPlay = arguments6 != null ? arguments6.getBoolean("auto_play") : false;
        Bundle arguments7 = getArguments();
        this.autoPlayResourceId = arguments7 != null ? arguments7.getString("auto_play_resource_id") : null;
        Bundle arguments8 = getArguments();
        this.preloadId = arguments8 != null ? arguments8.getInt("yy_preload_id") : 0;
        Bundle arguments9 = getArguments();
        this.moduleName = arguments9 != null ? arguments9.getString("module_name") : null;
        Bundle arguments10 = getArguments();
        this.curSeason = arguments10 != null ? arguments10.getInt("season") : 1;
        MovieDetailViewModel Z0 = Z0();
        int i11 = this.preloadId;
        String str = this.mSubjectId;
        if (str == null) {
            str = "";
        }
        Z0.S(i11, str, Integer.valueOf(this.curSeason));
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
