package com.transsion.shorttv.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.view.Lifecycle;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.LiveData;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.view.BLTextView;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.player.p007enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.push.PushConstants;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv.ad.AdLoadState;
import com.transsion.shorttv.ad.common.STCommonVideoAdHelper;
import com.transsion.shorttv.ad.playeroverlayad.ShortTvPlayerOverlayAdContainer;
import com.transsion.shorttv.ad.playeroverlayad.ShortTvPlayerOverlayAdManager;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import com.transsion.shorttv.base.widget.e;
import com.transsion.shorttv.base.widget.expand.ExpandView;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.DubsInfo;
import com.transsion.shorttv.bean.DubsInfoData;
import com.transsion.shorttv.bean.Media;
import com.transsion.shorttv.bean.ShortTVFavInfo;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.ShortTvInnerPlayBean;
import com.transsion.shorttv.bean.SkuInfo;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.bean.SubjectType;
import com.transsion.shorttv.bean.Video;
import com.transsion.shorttv.order.b;
import com.transsion.shorttv.order.bean.CreatePaynicornOrderReqBean;
import com.transsion.shorttv.order.bean.GetPaynicornOrderStatusRespEntity;
import com.transsion.shorttv.subtitle.a;
import com.transsion.shorttv.subtitle.manager.b;
import com.transsion.shorttv.ui.dialog.ShortTvAlertDialog;
import com.transsion.shorttv.ui.dialog.ShortTvLanguageSelectDialog;
import com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment;
import com.transsion.shorttv.ui.widget.ShortTvVideoItemView;
import com.transsion.shorttv.ui.widget.c;
import com.transsion.shorttv.utils.ShortTvVideoCtrBean;
import com.transsion.shorttv.viewmodel.ShortTvViewModel;
import com.transsion.subtitle_download.a;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lg.a;

@Metadata(d1 = {"\u0000ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0002¨\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B!\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0013JU\u0010!\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH\u0016¢\u0006\u0004\b!\u0010\"J-\u0010'\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b'\u0010(J-\u0010)\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b)\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00100\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00112\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u0017\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u001aH\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ\u001f\u0010H\u001a\u00020\u00112\u0006\u0010F\u001a\u00020E2\u0006\u0010B\u001a\u00020GH\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0011H\u0016¢\u0006\u0004\bJ\u0010\u0013J\r\u0010K\u001a\u00020\u0011¢\u0006\u0004\bK\u0010\u0013J\r\u0010L\u001a\u00020\u0011¢\u0006\u0004\bL\u0010\u0013J\u000f\u0010M\u001a\u00020\u0011H\u0016¢\u0006\u0004\bM\u0010\u0013J\u0015\u0010O\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u001c¢\u0006\u0004\bO\u0010PJ\u0015\u0010R\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020\u001c¢\u0006\u0004\bR\u0010PJ\u000f\u0010S\u001a\u00020\u0011H\u0016¢\u0006\u0004\bS\u0010\u0013J\u000f\u0010T\u001a\u00020\u0011H\u0016¢\u0006\u0004\bT\u0010\u0013J\u0019\u0010W\u001a\u00020\u00112\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bW\u0010XJ\u0019\u0010Y\u001a\u00020\u00112\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bY\u0010XJ\u0019\u0010Z\u001a\u00020\u00112\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bZ\u0010XJ!\u0010]\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020[2\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\b]\u0010^J\u0019\u0010_\u001a\u00020\u00112\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\b_\u0010XJ\u0019\u0010`\u001a\u00020\u00112\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\b`\u0010XJ!\u0010c\u001a\u00020\u00112\u0006\u0010b\u001a\u00020a2\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\u0011H\u0016¢\u0006\u0004\be\u0010\u0013J\u0019\u0010f\u001a\u00020\u00112\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bf\u0010XJ\u0019\u0010i\u001a\u00020\u00112\b\u0010h\u001a\u0004\u0018\u00010gH\u0016¢\u0006\u0004\bi\u0010jJ\r\u0010k\u001a\u00020\u0011¢\u0006\u0004\bk\u0010\u0013J\u000f\u0010l\u001a\u00020[H\u0016¢\u0006\u0004\bl\u0010mJ\u0019\u0010q\u001a\u00020\u00112\b\u0010n\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\bo\u0010pJ\u0019\u0010t\u001a\u00020\u00112\b\b\u0002\u0010r\u001a\u00020\u001aH\u0000¢\u0006\u0004\bs\u0010@J\r\u0010u\u001a\u00020\u0011¢\u0006\u0004\bu\u0010\u0013J\u000f\u0010v\u001a\u00020\u0011H\u0016¢\u0006\u0004\bv\u0010\u0013J\u000f\u0010w\u001a\u00020\u0011H\u0016¢\u0006\u0004\bw\u0010\u0013J\u001f\u0010z\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020xH\u0016¢\u0006\u0004\bz\u0010{J\u0017\u0010|\u001a\u00020\u00112\u0006\u0010y\u001a\u00020xH\u0016¢\u0006\u0004\b|\u0010}J(\u0010\u0082\u0001\u001a\u00020\u00112\u000b\u0010\u0080\u0001\u001a\u00060~j\u0002`\u007f2\u0007\u0010\u0081\u0001\u001a\u00020xH\u0016¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0011\u0010\u0084\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u0084\u0001\u0010\u0013J\u001e\u0010\u0087\u0001\u001a\u00020\u00112\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0019\u0010\u0089\u0001\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0089\u0001\u0010\u000fJ\u0011\u0010\u008a\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u008a\u0001\u0010\u0013J\u0011\u0010\u008b\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u0013J\u001a\u0010\u008d\u0001\u001a\u00020\u00112\u0007\u0010\u008c\u0001\u001a\u00020\u001aH\u0002¢\u0006\u0005\b\u008d\u0001\u0010@J(\u0010\u0090\u0001\u001a\u00020\u00112\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J:\u0010\u0096\u0001\u001a\u00020\u00112\u0007\u0010\u0092\u0001\u001a\u00020\u001c2\b\u0010\u0094\u0001\u001a\u00030\u0093\u00012\t\u0010\u0016\u001a\u0005\u0018\u00010\u0095\u00012\b\b\u0002\u0010 \u001a\u00020\u001aH\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u001b\u0010\u0098\u0001\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0005\b\u0098\u0001\u00101J\u001a\u0010\u0099\u0001\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020[H\u0002¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u001b\u0010\u009c\u0001\u001a\u00020\u00112\u0007\u0010\u009b\u0001\u001a\u00020[H\u0002¢\u0006\u0006\b\u009c\u0001\u0010\u009a\u0001J\u0011\u0010\u009d\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u009d\u0001\u0010\u0013J\u0011\u0010\u009e\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u009e\u0001\u0010\u0013J\u0011\u0010\u009f\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u009f\u0001\u0010\u0013J\u0011\u0010 \u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b \u0001\u0010\u0013J\u001a\u0010¢\u0001\u001a\u00020\u00112\u0007\u0010¡\u0001\u001a\u00020\u001aH\u0002¢\u0006\u0005\b¢\u0001\u0010@J\u001a\u0010¤\u0001\u001a\u00020\u00112\u0007\u0010£\u0001\u001a\u00020gH\u0002¢\u0006\u0005\b¤\u0001\u0010jJ\u0011\u0010¥\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b¥\u0001\u0010\u0013J\u0011\u0010¦\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b¦\u0001\u0010\u0013J\u0011\u0010§\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b§\u0001\u0010\u0013J\u0011\u0010¨\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b¨\u0001\u0010\u0013J&\u0010«\u0001\u001a\u00020\u00112\u0006\u0010&\u001a\u00020%2\n\u0010ª\u0001\u001a\u0005\u0018\u00010©\u0001H\u0002¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0011\u0010\u00ad\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u00ad\u0001\u0010\u0013J\u0011\u0010®\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b®\u0001\u0010\u0013J\u001b\u0010¯\u0001\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0005\b¯\u0001\u00101J\u0011\u0010°\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b°\u0001\u0010\u0013J)\u0010±\u0001\u001a\u00020\u00112\t\u0010£\u0001\u001a\u0004\u0018\u00010g2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0002¢\u0006\u0006\b±\u0001\u0010²\u0001J)\u0010³\u0001\u001a\u00020\u00112\t\u0010£\u0001\u001a\u0004\u0018\u00010g2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0002¢\u0006\u0006\b³\u0001\u0010²\u0001J\u0011\u0010´\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b´\u0001\u0010\u0013J\u0011\u0010µ\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\bµ\u0001\u0010\u0013J\u001c\u0010¸\u0001\u001a\u00030·\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0006\b¸\u0001\u0010¹\u0001J\u001b\u0010»\u0001\u001a\u00020\u00112\u0007\u0010º\u0001\u001a\u00020[H\u0002¢\u0006\u0006\b»\u0001\u0010\u009a\u0001J\u0011\u0010¼\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b¼\u0001\u0010\u0013J\u001c\u0010¾\u0001\u001a\u00020\u00112\t\u0010½\u0001\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0005\b¾\u0001\u0010PJ\u0011\u0010¿\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b¿\u0001\u0010\u0013J\u0011\u0010À\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\bÀ\u0001\u0010\u0013J\u0011\u0010Á\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\bÁ\u0001\u0010\u0013J\u0011\u0010Â\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\bÂ\u0001\u0010\u0013J\u0011\u0010Ã\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\bÃ\u0001\u0010\u0013J\u0011\u0010Ä\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\bÄ\u0001\u0010\u0013J\u0011\u0010Å\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\bÅ\u0001\u0010\u0013J\u0011\u0010Æ\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\bÆ\u0001\u0010\u0013J\u001b\u0010È\u0001\u001a\u00020\u00112\u0007\u0010\u0016\u001a\u00030Ç\u0001H\u0002¢\u0006\u0006\bÈ\u0001\u0010É\u0001J\u001c\u0010Ì\u0001\u001a\u00020\u00112\b\u0010Ë\u0001\u001a\u00030Ê\u0001H\u0002¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u001b\u0010Î\u0001\u001a\u00020\u00112\u0007\u0010\u0016\u001a\u00030Ç\u0001H\u0002¢\u0006\u0006\bÎ\u0001\u0010É\u0001J\u0012\u0010Ï\u0001\u001a\u00020\u001aH\u0002¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\u0012\u0010Ñ\u0001\u001a\u00020\u001aH\u0002¢\u0006\u0006\bÑ\u0001\u0010Ð\u0001J\u0019\u0010Ò\u0001\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0005\bÒ\u0001\u00101J\u0019\u0010Ó\u0001\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0005\bÓ\u0001\u00101R\u0017\u0010Ö\u0001\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0017\u0010Ø\u0001\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010«\u0001R\u0018\u0010Ü\u0001\u001a\u00030Ù\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R\u001b\u0010ß\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u001c\u0010á\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010à\u0001R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010æ\u0001R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010Õ\u0001R\u001a\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R\u001a\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R\u001a\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001c\u0010ñ\u0001\u001a\u0005\u0018\u00010î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u001c\u0010õ\u0001\u001a\u0005\u0018\u00010ò\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010ô\u0001R\u0019\u0010÷\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010\u0089\u0001R\u0019\u0010ù\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010\u0089\u0001R\u0019\u0010û\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010\u0089\u0001R\u0019\u0010ý\u0001\u001a\u00020[8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010±\u0001R(\u0010ÿ\u0001\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bþ\u0001\u0010\u0089\u0001\u001a\u0006\bÿ\u0001\u0010Ð\u0001\"\u0005\b\u0080\u0002\u0010@R\u001c\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0081\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0002\u0010\u0083\u0002R\u0017\u0010\u0086\u0002\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0002\u0010«\u0001R\u0016\u0010\u0087\u0002\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bh\u0010«\u0001R\u0017\u0010\u0088\u0002\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010«\u0001R\u0017\u0010\u008a\u0002\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0002\u0010«\u0001R\u0018\u0010N\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010Õ\u0001R\u001b\u0010\u008e\u0002\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u008d\u0002R\u001c\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u008f\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0019\u0010\u0094\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0002\u0010«\u0001R\u0019\u0010\u0096\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0002\u0010«\u0001R\u001c\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0002\u0010\u0099\u0002R\u001a\u0010\u009e\u0002\u001a\u00030\u009b\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u009d\u0002R\u0017\u0010 \u0002\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0002\u0010\u0089\u0001R\u0019\u0010¢\u0002\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0002\u0010\u0089\u0001R\u001e\u0010¦\u0002\u001a\t\u0012\u0004\u0012\u00020\u001a0£\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0002\u0010¥\u0002R \u0010§\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0£\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¥\u0002R\u0018\u0010ª\u0002\u001a\u00030¨\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010©\u0002R\u0019\u0010«\u0002\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010\u0089\u0001R\u0019\u0010¬\u0002\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010\u0089\u0001R\u001d\u0010±\u0002\u001a\b0\u00ad\u0002j\u0003`®\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0002\u0010°\u0002R\u0019\u0010²\u0002\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010\u0089\u0001R\u0018\u0010µ\u0002\u001a\u00030³\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010´\u0002R\u001d\u0010·\u0002\u001a\b0\u00ad\u0002j\u0003`®\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0002\u0010°\u0002R\u001b\u0010¸\u0002\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010æ\u0001R\u001b\u0010»\u0002\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0002\u0010º\u0002R\u0019\u0010¼\u0002\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u0089\u0001R\u001c\u0010À\u0002\u001a\u0005\u0018\u00010½\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0002\u0010¿\u0002R\u0019\u0010Á\u0002\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0089\u0001R,\u0010È\u0002\u001a\u0005\u0018\u00010Â\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010Ã\u0002\u001a\u0006\bÄ\u0002\u0010Å\u0002\"\u0006\bÆ\u0002\u0010Ç\u0002R\u001c\u0010Ê\u0002\u001a\u0005\u0018\u00010Ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010É\u0002R\u0019\u0010Ë\u0002\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010\u0089\u0001¨\u0006Ì\u0002"}, d2 = {"Lcom/transsion/shorttv/ui/widget/ShortTvVideoItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/transsion/player/orplayer/f;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/r;", "Lcom/transsion/shorttv/ui/widget/d;", "Lcom/transsion/subtitle_download/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Ljs/e;", WebConstants.FIELD_ITEM, "Lcom/transsion/shorttv/ui/fragment/ShortTvDetailListFragment;", "fragment", RequestParameters.POSITION, "", "videoLoadMore", "", "basePostId", "baseItemType", "isPayloads", "fromTrending", "setData", "(Ljs/e;Lcom/transsion/shorttv/ui/fragment/ShortTvDetailListFragment;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;ZZ)V", "Lcom/transsion/player/orplayer/g;", "orPlayer", "Lcom/transsion/player/ui/ORPlayerView;", "orPlayerView", "onPageSelected", "(Lcom/transsion/player/orplayer/g;Lcom/transsion/player/ui/ORPlayerView;Ljs/e;)V", "updateShortTvInfo", "onPageRelease", "(I)V", "width", "height", "onVideoSizeChanged", "(II)V", "updateLockState", "(Ljs/e;)V", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "pagerLayoutManager", "setPagerLayoutManager", "(Lcom/transsion/shorttv/base/pager/PagerLayoutManager;)V", "Landroid/widget/FrameLayout;", "getPlayerContainer", "()Landroid/widget/FrameLayout;", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/transsion/shorttv/viewmodel/ShortTvViewModel;", "getViewModel", "(Landroidx/fragment/app/FragmentActivity;)Lcom/transsion/shorttv/viewmodel/ShortTvViewModel;", "hasWindowFocus", "onWindowFocusChanged", "(Z)V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroidx/lifecycle/u;", EventConstants.KEY_SOURCE, "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged", "(Landroidx/lifecycle/u;Landroidx/lifecycle/Lifecycle$Event;)V", "onPlayerReset", "onMediaItemTransition", "reset", "app2Background", "pageFrom", "videoStartPrepare", "(Ljava/lang/String;)V", "url", "setVideoUrl", "onSetDataSource", "onRenderFirstFrame", "Lao/e;", "mediaSource", "onVideoStart", "(Lao/e;)V", "onPrepare", "onVideoPause", "", NotificationCompat.CATEGORY_PROGRESS, "onProgress", "(JLao/e;)V", "onLoadingBegin", "onLoadingEnd", "Lcom/transsion/player/orplayer/PlayError;", "errorInfo", "onPlayError", "(Lcom/transsion/player/orplayer/PlayError;Lao/e;)V", "onLoopingStart", "onCompletion", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "showEpisodeListDialog", "getProgress", "()J", "remaining", "updateUnlockCountdownText$shortTvLib_release", "(Ljava/lang/Integer;)V", "updateUnlockCountdownText", "isAuto", "watchAdToUnlock$shortTvLib_release", "watchAdToUnlock", "onNetConnect", "onGetDubsInfo", "onAudioTrackChange", "Lcom/transsion/subtitle_download/db/SubtitleDownloadTable;", "stDownloadTable", "onDownloading", "(ILcom/transsion/subtitle_download/db/SubtitleDownloadTable;)V", "onComplete", "(Lcom/transsion/subtitle_download/db/SubtitleDownloadTable;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "dbBean", "onFail", "(Ljava/lang/Exception;Lcom/transsion/subtitle_download/db/SubtitleDownloadTable;)V", "T0", "Ljs/f;", "result", "U", "(Ljs/f;)V", "Z", "Y", "Q0", "isImmersive", "Y0", "w", "h", "Z0", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "ep", "Lcom/transsion/shorttv/bean/Subject;", "subject", "Lcom/transsion/shorttv/bean/ShortTVItem;", "I0", "(Ljava/lang/String;Lcom/transsion/shorttv/bean/Subject;Lcom/transsion/shorttv/bean/ShortTVItem;Z)V", "b1", "V0", "(J)V", "max", "W0", "v0", "H0", "O0", "a0", PushConstants.PUSH_SERVICE_TYPE_SHOW, "setLoading", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "B0", "e0", "X", "L", "P0", "Lcom/transsion/shorttv/bean/Video;", "video", "I", "(Lcom/transsion/player/ui/ORPlayerView;Lcom/transsion/shorttv/bean/Video;)V", "R0", "S0", "K0", "W", "J", "(Landroid/view/View;Lcom/transsion/shorttv/bean/Subject;)V", "K", "J0", "V", EventConstants.KEY_TIME, "Landroid/text/SpannableString;", "N", "(Ljava/lang/String;)Landroid/text/SpannableString;", "remainingMs", "U0", "O", "userId", "Q", "h0", "C0", "g0", "z0", "b0", "x0", "q0", "E0", "Lts/b;", "G0", "(Lts/b;)V", "Lcom/transsion/shorttv/bean/DubsInfo;", "info", "s0", "(Lcom/transsion/shorttv/bean/DubsInfo;)V", "S", "j0", "()Z", "i0", "o0", "k0", "a", "Ljava/lang/String;", "TAG", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "screenWidth", "Lms/k0;", "c", "Lms/k0;", "viewBinding", "d", "Ljs/e;", "data", "Lcom/transsion/shorttv/bean/Subject;", "shortTvInfo", "f", "Lcom/transsion/shorttv/ui/fragment/ShortTvDetailListFragment;", be.g.f16474b, "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "i", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsion/player/orplayer/g;", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/player/ui/ORPlayerView;", "l", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "Landroid/view/GestureDetector;", "m", "Landroid/view/GestureDetector;", "gestureDetector", "Lss/c;", "n", "Lss/c;", "dotLayer", "o", "isClickPause", TtmlNode.TAG_P, "isHorizontalDragging", CampaignEx.JSON_KEY_AD_Q, "isPageHide", CampaignEx.JSON_KEY_AD_R, "currentSaveProgress", "s", "isFirstPlayInSession", "setFirstPlayInSession", "Lcom/transsion/shorttv/ui/widget/c;", "t", "Lcom/transsion/shorttv/ui/widget/c;", "downloadGuideBubbleController", TmcStartParams.KEY_URL_SHORT, "resImgLargeWidth", "resImgLargeHeight", "resImgSmallWidth", "x", "resImgSmallHeight", "y", "z", "Lcom/transsion/shorttv/viewmodel/ShortTvViewModel;", "mShortTvViewModel", "Lws/a;", "A", "Lws/a;", "mShortTvSubViewModel", "B", "videoWidth", "C", "videoHeight", "Lcom/transsion/shorttv/subtitle/a;", "D", "Lcom/transsion/shorttv/subtitle/a;", "subtitleControl", "Landroidx/constraintlayout/widget/Group;", "E", "Landroidx/constraintlayout/widget/Group;", "groupContent", "F", "isOptimizeEnable", "G", "hasAd", "Landroidx/lifecycle/c0;", "H", "Landroidx/lifecycle/c0;", "observer", "favoriteObserver", "com/transsion/shorttv/ui/widget/ShortTvVideoItemView$d", "Lcom/transsion/shorttv/ui/widget/ShortTvVideoItemView$d;", "favoriteResultObserver", "isFirstFrame", "isPrepare", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "M", "Ljava/lang/Runnable;", "delayToastNetErrRunnable", "isLoading", "Landroid/os/Handler;", "Landroid/os/Handler;", "autoHideRightMenuHandle", "P", "autoHideRightMenuRunnable", "watchAdUnlockSeconds", "R", "Landroid/view/View;", "lockedView", "isEpisodeLocked", "Lcom/transsion/shorttv/ad/common/STCommonVideoAdHelper;", "T", "Lcom/transsion/shorttv/ad/common/STCommonVideoAdHelper;", "videoAdHelper", "isFreePreviewMode", "Lcom/transsion/shorttv/ui/widget/a1;", "Lcom/transsion/shorttv/ui/widget/a1;", "getCountdownController", "()Lcom/transsion/shorttv/ui/widget/a1;", "setCountdownController", "(Lcom/transsion/shorttv/ui/widget/a1;)V", "countdownController", "Lts/b;", "subDownloadBean", "hasSubDownloading", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTvVideoItemView extends ConstraintLayout implements com.transsion.player.orplayer.f, View.OnClickListener, androidx.view.r, com.transsion.shorttv.ui.widget.d, com.transsion.subtitle_download.a {

    /* renamed from: A, reason: from kotlin metadata */
    private ws.a mShortTvSubViewModel;

    /* renamed from: B, reason: from kotlin metadata */
    private int videoWidth;

    /* renamed from: C, reason: from kotlin metadata */
    private int videoHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private com.transsion.shorttv.subtitle.a subtitleControl;

    /* renamed from: E, reason: from kotlin metadata */
    private Group groupContent;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean isOptimizeEnable;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasAd;

    /* renamed from: H, reason: from kotlin metadata */
    private final androidx.view.c0 observer;

    /* renamed from: I, reason: from kotlin metadata */
    private final androidx.view.c0 favoriteObserver;

    /* renamed from: J, reason: from kotlin metadata */
    private final d favoriteResultObserver;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isFirstFrame;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isPrepare;

    /* renamed from: M, reason: from kotlin metadata */
    private final Runnable delayToastNetErrRunnable;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: O, reason: from kotlin metadata */
    private final Handler autoHideRightMenuHandle;

    /* renamed from: P, reason: from kotlin metadata */
    private final Runnable autoHideRightMenuRunnable;

    /* renamed from: Q, reason: from kotlin metadata */
    private Integer watchAdUnlockSeconds;

    /* renamed from: R, reason: from kotlin metadata */
    private View lockedView;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isEpisodeLocked;

    /* renamed from: T, reason: from kotlin metadata */
    private STCommonVideoAdHelper videoAdHelper;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isFreePreviewMode;

    /* renamed from: V, reason: from kotlin metadata */
    private a1 countdownController;

    /* renamed from: W, reason: from kotlin metadata */
    private ts.b subDownloadBean;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean hasSubDownloading;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int screenWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ms.k0 viewBinding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private js.e data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Subject shortTvInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ShortTvDetailListFragment fragment;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Boolean videoLoadMore;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Integer position;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String basePostId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private com.transsion.player.orplayer.g orPlayer;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ORPlayerView orPlayerView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private PagerLayoutManager pagerLayoutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GestureDetector gestureDetector;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private ss.c dotLayer;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isClickPause;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isHorizontalDragging;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isPageHide;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private long currentSaveProgress;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstPlayInSession;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private com.transsion.shorttv.ui.widget.c downloadGuideBubbleController;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final int resImgLargeWidth;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final int resImgLargeHeight;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final int resImgSmallWidth;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final int resImgSmallHeight;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private String pageFrom;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private ShortTvViewModel mShortTvViewModel;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f53592a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f53593b;

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
            f53592a = iArr;
            int[] iArr2 = new int[AdLoadState.values().length];
            try {
                iArr2[AdLoadState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[AdLoadState.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[AdLoadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[AdLoadState.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[AdLoadState.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[AdLoadState.SUCCEED.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            f53593b = iArr2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements androidx.view.c0 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ qs.i f53595b;

        b(qs.i iVar) {
            this.f53595b = iVar;
        }

        @Override // androidx.view.c0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Unit unit) {
            LiveData H0;
            androidx.view.b0 l02;
            androidx.view.b0 l03;
            ShortTvVideoItemView.this.setLoading(false);
            ShortTvViewModel shortTvViewModel = ShortTvVideoItemView.this.mShortTvViewModel;
            if (shortTvViewModel != null && (l03 = shortTvViewModel.l0()) != null) {
                l03.o(this);
            }
            ShortTvViewModel shortTvViewModel2 = ShortTvVideoItemView.this.mShortTvViewModel;
            Subject subject = null;
            if (shortTvViewModel2 != null && (l02 = shortTvViewModel2.l0()) != null) {
                l02.q(null);
            }
            ShortTvViewModel shortTvViewModel3 = ShortTvVideoItemView.this.mShortTvViewModel;
            if (shortTvViewModel3 != null && (H0 = shortTvViewModel3.H0()) != null) {
                subject = (Subject) H0.f();
            }
            if (subject == null || subject.isPaid() != 1) {
                ShortTvVideoItemView.this.Q(this.f53595b.getUserId());
            } else {
                ShortTvVideoItemView shortTvVideoItemView = ShortTvVideoItemView.this;
                shortTvVideoItemView.updateShortTvInfo(shortTvVideoItemView.orPlayer, ShortTvVideoItemView.this.orPlayerView, ShortTvVideoItemView.this.data);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements com.transsion.shorttv.order.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Subject f53597b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f53598c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f53599d;

        c(Subject subject, int i11, String str) {
            this.f53597b = subject;
            this.f53598c = i11;
            this.f53599d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(ShortTvVideoItemView shortTvVideoItemView, String str) {
            shortTvVideoItemView.Q(str);
            return Unit.f67184a;
        }

        @Override // com.transsion.shorttv.order.b
        public void a(String errorCode, String errorMsg) {
            ShortTvAlertDialog a11;
            Intrinsics.h(errorCode, "errorCode");
            Intrinsics.h(errorMsg, "errorMsg");
            b.a.a(this, errorCode, errorMsg);
            a.C0856a.l(lg.a.f68962a, ShortTvVideoItemView.this.TAG, "callPayMethod onPayFail, errorCode=" + errorCode + ", errorMsg=" + errorMsg, false, 4, null);
            ss.b.f75981a.j(this.f53597b, this.f53598c, "fail", errorMsg, errorCode, MediaItem.MUSIC_FLOAT_STATE_PLAY);
            ShortTvAlertDialog.Companion companion = ShortTvAlertDialog.INSTANCE;
            String string = ShortTvVideoItemView.this.getContext().getString(R$string.short_tv_pay_failed_title);
            Intrinsics.g(string, "getString(...)");
            String string2 = ShortTvVideoItemView.this.getContext().getString(R$string.short_tv_pay_failed_message);
            Intrinsics.g(string2, "getString(...)");
            String string3 = ShortTvVideoItemView.this.getContext().getString(R$string.short_tv_payment_retry);
            Intrinsics.g(string3, "getString(...)");
            final ShortTvVideoItemView shortTvVideoItemView = ShortTvVideoItemView.this;
            final String str = this.f53599d;
            a11 = companion.a(string, string2, string3, (r16 & 8) != 0 ? null : new Function0() { // from class: com.transsion.shorttv.ui.widget.y0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit d11;
                    d11 = ShortTvVideoItemView.c.d(ShortTvVideoItemView.this, str);
                    return d11;
                }
            }, (r16 & 16) != 0 ? null : ShortTvVideoItemView.this.getContext().getString(R$string.short_tv_payment_cancel), (r16 & 32) != 0 ? null : null);
            a11.i0(ShortTvVideoItemView.this.getContext(), "ShortTvAlertDialog");
        }

        @Override // com.transsion.shorttv.order.b
        public void b(GetPaynicornOrderStatusRespEntity getPaynicornOrderStatusRespEntity) {
            String str;
            String str2;
            String orderStatus;
            b.a.b(this, getPaynicornOrderStatusRespEntity);
            a.C0856a.r(lg.a.f68962a, ShortTvVideoItemView.this.TAG, new String[]{"callPayMethod onPurchase, orderStatus=" + getPaynicornOrderStatusRespEntity}, false, 4, null);
            fs.b.f62582a.e(ShortTvVideoItemView.this.getContext().getString(R$string.short_tv_pay_series_successfully));
            Integer v11 = (getPaynicornOrderStatusRespEntity == null || (orderStatus = getPaynicornOrderStatusRespEntity.getOrderStatus()) == null) ? null : StringsKt.v(orderStatus);
            if (v11 != null && v11.intValue() == 2) {
                ss.b.f75981a.j(this.f53597b, this.f53598c, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, "", "0", MediaItem.MUSIC_FLOAT_STATE_PLAY);
                ShortTvViewModel shortTvViewModel = ShortTvVideoItemView.this.mShortTvViewModel;
                if (shortTvViewModel != null) {
                    shortTvViewModel.R0(1);
                }
                ShortTvVideoItemView shortTvVideoItemView = ShortTvVideoItemView.this;
                shortTvVideoItemView.updateShortTvInfo(shortTvVideoItemView.orPlayer, ShortTvVideoItemView.this.orPlayerView, ShortTvVideoItemView.this.data);
                return;
            }
            if (v11 != null && v11.intValue() == 3) {
                ss.b.f75981a.j(this.f53597b, this.f53598c, "cancel", "", "0", MediaItem.MUSIC_FLOAT_STATE_PLAY);
                return;
            }
            ss.b bVar = ss.b.f75981a;
            Subject subject = this.f53597b;
            int i11 = this.f53598c;
            if (getPaynicornOrderStatusRespEntity == null || (str = getPaynicornOrderStatusRespEntity.getDescription()) == null) {
                str = "";
            }
            String str3 = str;
            if (v11 == null || (str2 = v11.toString()) == null) {
                str2 = TmcConstants.COLD_OPEN_TYPE;
            }
            bVar.j(subject, i11, "fail", str3, str2, MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements androidx.view.c0 {

        /* renamed from: a, reason: collision with root package name */
        private js.f f53600a;

        d() {
        }

        @Override // androidx.view.c0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(js.f fVar) {
            if (Intrinsics.c(this.f53600a, fVar)) {
                return;
            }
            ShortTvVideoItemView.this.U(fVar);
        }

        public final void b(js.f fVar) {
            this.f53600a = fVar;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends GestureDetector.SimpleOnGestureListener {
        e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            ShortTvVideoItemView.this.v0();
            return super.onSingleTapUp(e11);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements c.b {
        f() {
        }

        @Override // com.transsion.shorttv.ui.widget.c.b
        public qs.d a() {
            ShortTvViewModel shortTvViewModel = ShortTvVideoItemView.this.mShortTvViewModel;
            if (shortTvViewModel != null) {
                return shortTvViewModel.s0();
            }
            return null;
        }

        @Override // com.transsion.shorttv.ui.widget.c.b
        public String b() {
            ShortTVItem d11;
            Media video;
            Video video2;
            js.e eVar = ShortTvVideoItemView.this.data;
            if (eVar == null || (d11 = eVar.d()) == null || (video = d11.getVideo()) == null || (video2 = video.getVideo()) == null) {
                return null;
            }
            return video2.getUrl();
        }

        @Override // com.transsion.shorttv.ui.widget.c.b
        public boolean c() {
            return ShortTvVideoItemView.this.isLoading;
        }

        @Override // com.transsion.shorttv.ui.widget.c.b
        public void d() {
            ShortTvVideoItemView.this.P0();
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements e.a {

        /* renamed from: a, reason: collision with root package name */
        private int f53604a;

        /* renamed from: b, reason: collision with root package name */
        private int f53605b;

        /* renamed from: c, reason: collision with root package name */
        private int f53606c;

        /* renamed from: d, reason: collision with root package name */
        private String f53607d = "";

        /* renamed from: e, reason: collision with root package name */
        private int f53608e = com.blankj.utilcode.util.a0.a(1.5f);

        g() {
        }

        @Override // com.transsion.shorttv.base.widget.e.a
        public void a() {
        }

        @Override // com.transsion.shorttv.base.widget.e.a
        public void b(float f11, float f12) {
            if (!ShortTvVideoItemView.this.isHorizontalDragging) {
                PagerLayoutManager pagerLayoutManager = ShortTvVideoItemView.this.pagerLayoutManager;
                if (pagerLayoutManager != null) {
                    pagerLayoutManager.W(false);
                }
                this.f53604a = ShortTvVideoItemView.this.viewBinding.f69977s.getProgress();
                AppCompatTextView tvProgressDes = ShortTvVideoItemView.this.viewBinding.C;
                Intrinsics.g(tvProgressDes, "tvProgressDes");
                yr.b.e(tvProgressDes);
                AppCompatSeekBar seekBar = ShortTvVideoItemView.this.viewBinding.f69979u;
                Intrinsics.g(seekBar, "seekBar");
                yr.b.e(seekBar);
                ProgressBar progressBar = ShortTvVideoItemView.this.viewBinding.f69977s;
                Intrinsics.g(progressBar, "progressBar");
                yr.b.b(progressBar);
                this.f53606c = ShortTvVideoItemView.this.viewBinding.f69977s.getWidth();
                int max = ShortTvVideoItemView.this.viewBinding.f69977s.getMax();
                this.f53605b = max;
                this.f53607d = com.transsion.shorttv.utils.m.a(max);
            }
            ShortTvVideoItemView.this.isHorizontalDragging = true;
            float f13 = f12 - f11;
            int i11 = this.f53605b;
            int i12 = (int) (this.f53604a + ((f13 * i11) / this.f53606c));
            int i13 = i12 >= 0 ? i12 > i11 ? i11 : i12 : 0;
            ShortTvVideoItemView.this.viewBinding.C.setText(com.transsion.shorttv.utils.m.a(i13) + " / " + this.f53607d);
            ShortTvVideoItemView.this.V0((long) i13);
        }

        @Override // com.transsion.shorttv.base.widget.e.a
        public void c(float f11, float f12) {
        }

        @Override // com.transsion.shorttv.base.widget.e.a
        public void d(float f11, float f12) {
        }

        @Override // com.transsion.shorttv.base.widget.e.a
        public void e() {
            PagerLayoutManager pagerLayoutManager = ShortTvVideoItemView.this.pagerLayoutManager;
            if (pagerLayoutManager != null) {
                pagerLayoutManager.W(true);
            }
            if (ShortTvVideoItemView.this.isHorizontalDragging) {
                ShortTvVideoItemView.this.isHorizontalDragging = false;
                AppCompatTextView tvProgressDes = ShortTvVideoItemView.this.viewBinding.C;
                Intrinsics.g(tvProgressDes, "tvProgressDes");
                yr.b.b(tvProgressDes);
                AppCompatSeekBar seekBar = ShortTvVideoItemView.this.viewBinding.f69979u;
                Intrinsics.g(seekBar, "seekBar");
                yr.b.b(seekBar);
                ProgressBar progressBar = ShortTvVideoItemView.this.viewBinding.f69977s;
                Intrinsics.g(progressBar, "progressBar");
                yr.b.e(progressBar);
                long progress = ShortTvVideoItemView.this.viewBinding.f69977s.getProgress();
                js.e eVar = ShortTvVideoItemView.this.data;
                if (eVar == null || !js.l.a(eVar)) {
                    a.C0856a.f(lg.a.f68962a, ShortTvVideoItemView.this.TAG, "数据还没有拉下来，不进行seek", false, 4, null);
                    return;
                }
                com.transsion.player.orplayer.g gVar = ShortTvVideoItemView.this.orPlayer;
                if (gVar != null) {
                    gVar.seekTo(progress);
                }
                com.transsion.player.orplayer.g gVar2 = ShortTvVideoItemView.this.orPlayer;
                if (gVar2 == null || gVar2.isPlaying()) {
                    return;
                }
                ShortTvVideoItemView.this.H0();
            }
        }

        @Override // com.transsion.shorttv.base.widget.e.a
        public void onDoubleTap(MotionEvent e11) {
            Intrinsics.h(e11, "e");
        }

        @Override // com.transsion.shorttv.base.widget.e.a
        public void onLongPress(MotionEvent e11) {
            Intrinsics.h(e11, "e");
        }
    }

    /* loaded from: classes6.dex */
    public static final class h implements ExpandView.c {
        h() {
        }

        @Override // com.transsion.shorttv.base.widget.expand.ExpandView.c
        public void a(ExpandView expandView) {
            ShortTvVideoItemView.this.P0();
        }

        @Override // com.transsion.shorttv.base.widget.expand.ExpandView.c
        public void b(ExpandView expandView) {
            ShortTvVideoItemView.this.L();
        }
    }

    /* loaded from: classes6.dex */
    public static final class i implements RequestListener {
        i() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable resource, Object model, Target target, DataSource dataSource, boolean z10) {
            Intrinsics.h(resource, "resource");
            Intrinsics.h(model, "model");
            Intrinsics.h(dataSource, "dataSource");
            a.C0856a.f(lg.a.f68962a, ShortTvVideoItemView.this.TAG, "onResourceReady  " + ShortTvVideoItemView.this, false, 4, null);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            Intrinsics.h(target, "target");
            a.C0856a.f(lg.a.f68962a, ShortTvVideoItemView.this.TAG, "onLoadFailed  " + ShortTvVideoItemView.this, false, 4, null);
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvVideoItemView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvVideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ShortTvVideoItemView(android.content.Context r4, android.util.AttributeSet r5, int r6) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.widget.ShortTvVideoItemView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(ShortTvVideoItemView shortTvVideoItemView, Ref.IntRef intRef, ShortTVItem shortTVItem, ShortTvVideoCtrBean clickItem) {
        ShortTVItem d11;
        List<Video> addressList;
        Object obj;
        ShortTVItem d12;
        Map a11;
        ShortTVItem d13;
        Integer v11;
        Intrinsics.h(clickItem, "clickItem");
        shortTvVideoItemView.L();
        float content = clickItem.getContent();
        if (intRef.element == content) {
            return Unit.f67184a;
        }
        com.transsion.shorttv.utils.h.f53707a.d().putInt("k_short_tv_resolution", (int) clickItem.getContent());
        shortTvVideoItemView.viewBinding.D.setText(((int) content) + "P");
        Media video = shortTVItem.getVideo();
        int i11 = 0;
        if (video != null && (addressList = video.getAddressList()) != null) {
            Iterator<T> it = addressList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String resolution = ((Video) obj).getResolution();
                if (((resolution == null || (v11 = StringsKt.v(resolution)) == null) ? 0 : v11.intValue()) == ((int) clickItem.getContent())) {
                    break;
                }
            }
            Video video2 = (Video) obj;
            if (video2 != null) {
                String url = video2.getUrl();
                String url2 = video2.getUrl();
                String str = url2 == null ? "" : url2;
                js.e eVar = shortTvVideoItemView.data;
                ao.e eVar2 = new ao.e(url, str, (eVar == null || (d13 = eVar.d()) == null) ? 0 : d13.getEp(), null, null, 24, null);
                com.transsion.player.orplayer.g gVar = shortTvVideoItemView.orPlayer;
                lo.f fVar = gVar instanceof lo.f ? (lo.f) gVar : null;
                boolean containsKey = (fVar == null || (a11 = fVar.a()) == null) ? false : a11.containsKey(eVar2.e());
                a.C0856a c0856a = lg.a.f68962a;
                String str2 = shortTvVideoItemView.TAG;
                float content2 = clickItem.getContent();
                js.e eVar3 = shortTvVideoItemView.data;
                Integer valueOf = (eVar3 == null || (d12 = eVar3.d()) == null) ? null : Integer.valueOf(d12.getEp());
                a.C0856a.f(c0856a, str2, "resolution play, res:" + content2 + ", EP:" + valueOf + ", inList:" + containsKey + ", url:" + video2.getUrl(), false, 4, null);
                com.transsion.player.orplayer.g gVar2 = shortTvVideoItemView.orPlayer;
                long currentPosition = gVar2 != null ? gVar2.getCurrentPosition() : 0L;
                if (!containsKey) {
                    com.transsion.player.orplayer.g gVar3 = shortTvVideoItemView.orPlayer;
                    if (gVar3 != null) {
                        gVar3.addDataSource(eVar2);
                    }
                    com.transsion.player.orplayer.g gVar4 = shortTvVideoItemView.orPlayer;
                    if (gVar4 != null) {
                        gVar4.prepare();
                    }
                }
                com.transsion.player.orplayer.g gVar5 = shortTvVideoItemView.orPlayer;
                if (gVar5 != null) {
                    String e11 = eVar2.e();
                    gVar5.seekTo(e11 != null ? e11 : "", currentPosition);
                }
            }
        }
        ShortTvViewModel shortTvViewModel = shortTvVideoItemView.mShortTvViewModel;
        if (shortTvViewModel != null) {
            String valueOf2 = String.valueOf(content);
            js.e eVar4 = shortTvVideoItemView.data;
            if (eVar4 != null && (d11 = eVar4.d()) != null) {
                i11 = d11.getEp();
            }
            com.transsion.player.orplayer.g gVar6 = shortTvVideoItemView.orPlayer;
            shortTvViewModel.W0(valueOf2, i11, gVar6 instanceof lo.f ? (lo.f) gVar6 : null);
        }
        return Unit.f67184a;
    }

    private final void B0(View view) {
        LiveData H0;
        Subject subject;
        qs.k C0;
        String str;
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        if (shortTvViewModel == null || (H0 = shortTvViewModel.H0()) == null || (subject = (Subject) H0.f()) == null) {
            return;
        }
        ss.b bVar = ss.b.f75981a;
        String subjectId = subject.getSubjectId();
        String ops = subject.getOps();
        js.e eVar = this.data;
        ss.b.n(bVar, subjectId, ops, eVar != null ? Integer.valueOf(eVar.c()) : null, null, 8, null);
        ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
        if (shortTvViewModel2 == null || (C0 = shortTvViewModel2.C0()) == null) {
            return;
        }
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        String subjectId2 = subject.getSubjectId();
        Subject subject2 = this.shortTvInfo;
        String title = subject2 != null ? subject2.getTitle() : null;
        ShortTvDetailListFragment shortTvDetailListFragment2 = this.fragment;
        if (shortTvDetailListFragment2 == null || (str = shortTvDetailListFragment2.getPageName()) == null) {
            str = "";
        }
        C0.a(shortTvDetailListFragment, subjectId2, title, str);
    }

    private final void C0() {
        a.C0856a.f(lg.a.f68962a, this.TAG, "VideoSpeed, click", false, 4, null);
        P0();
        final float f11 = com.transsion.shorttv.utils.h.f53707a.d().getFloat("k_short_tv_speed", 1.0f);
        for (ShortTvVideoCtrBean shortTvVideoCtrBean : com.transsion.shorttv.utils.l.b()) {
            shortTvVideoCtrBean.setSelect(shortTvVideoCtrBean.getContent() == f11);
        }
        AppCompatTextView tvSpeed = this.viewBinding.E;
        Intrinsics.g(tvSpeed, "tvSpeed");
        com.transsion.shorttv.utils.l.c(tvSpeed, com.transsion.shorttv.utils.l.b(), new Function1() { // from class: com.transsion.shorttv.ui.widget.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D0;
                D0 = ShortTvVideoItemView.D0(ShortTvVideoItemView.this, f11, (ShortTvVideoCtrBean) obj);
                return D0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(ShortTvVideoItemView shortTvVideoItemView, float f11, ShortTvVideoCtrBean clickItem) {
        Intrinsics.h(clickItem, "clickItem");
        shortTvVideoItemView.L();
        float content = clickItem.getContent();
        if (f11 == content) {
            return Unit.f67184a;
        }
        com.transsion.shorttv.utils.h.f53707a.d().putFloat("k_short_tv_speed", content);
        int i11 = (int) content;
        String valueOf = ((float) i11) == content ? String.valueOf(i11) : String.valueOf(content);
        shortTvVideoItemView.viewBinding.E.setText(valueOf + "x");
        com.transsion.player.orplayer.g gVar = shortTvVideoItemView.orPlayer;
        if (gVar != null) {
            gVar.setSpeed(content);
        }
        return Unit.f67184a;
    }

    private final void E0() {
        androidx.view.b0 d11;
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_no_network_toast));
            return;
        }
        ws.a aVar = this.mShortTvSubViewModel;
        List list = (aVar == null || (d11 = aVar.d()) == null) ? null : (List) d11.f();
        if (list == null || list.isEmpty()) {
            fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_no_error_content));
            return;
        }
        ShortTvLanguageSelectDialog shortTvLanguageSelectDialog = new ShortTvLanguageSelectDialog();
        shortTvLanguageSelectDialog.D0(2);
        shortTvLanguageSelectDialog.C0(new Function1() { // from class: com.transsion.shorttv.ui.widget.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = ShortTvVideoItemView.F0(ShortTvVideoItemView.this, (DubsInfo) obj);
                return F0;
            }
        });
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment != null) {
            shortTvLanguageSelectDialog.j0(shortTvDetailListFragment, "ShortTvLanguageSelectDialog_Subtitle");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(ShortTvVideoItemView shortTvVideoItemView, DubsInfo item) {
        Intrinsics.h(item, "item");
        if (Intrinsics.c(item.getLanCode(), "off")) {
            com.transsion.shorttv.subtitle.a aVar = shortTvVideoItemView.subtitleControl;
            if (aVar != null) {
                aVar.f();
            }
        } else {
            ts.b subInfo = item.getSubInfo();
            if (subInfo != null) {
                shortTvVideoItemView.G0(subInfo);
            }
        }
        return Unit.f67184a;
    }

    private final void G0(ts.b item) {
        a.C0856a.f(lg.a.f68962a, this.TAG, "onSubtitleSelect", false, 4, null);
        com.transsion.shorttv.utils.h.f53707a.d().putString("k_subtitle_language", item.a().getLanName());
        com.transsion.subtitle_download.utils.d.f55168a.b().putString("k_subtitle_select_lan", item.a().getLan());
        if (!item.b()) {
            S(item);
            return;
        }
        com.transsion.shorttv.subtitle.a aVar = this.subtitleControl;
        if (aVar != null) {
            aVar.h(item);
        }
        this.subDownloadBean = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0() {
        com.transsion.player.orplayer.g gVar;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.TAG, "playVideo   data:" + this.data + "  orPlayer:" + this.orPlayer, false, 4, null);
        if (this.orPlayer == null || js.l.b(this.data) || this.orPlayer == null || js.l.b(this.data)) {
            return;
        }
        if (!i0() && !this.isFreePreviewMode) {
            a.C0856a.f(c0856a, this.TAG, "player- no free now, show pay dialog", false, 4, null);
            setLoading(false);
            com.transsion.player.orplayer.g gVar2 = this.orPlayer;
            if (gVar2 != null) {
                gVar2.pause();
                return;
            }
            return;
        }
        com.transsion.player.orplayer.g gVar3 = this.orPlayer;
        if (gVar3 != null && gVar3.isComplete() && (gVar = this.orPlayer) != null) {
            gVar.seekTo(0L);
        }
        com.transsion.player.orplayer.g gVar4 = this.orPlayer;
        if (gVar4 != null) {
            gVar4.play();
        }
        a.C0856a.f(c0856a, this.TAG, "player- startplay    ", false, 4, null);
    }

    private final void I(ORPlayerView orPlayerView, Video video) {
        ViewParent parent = orPlayerView.getParent();
        if (!Intrinsics.c(parent, this.viewBinding.f69963e)) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(orPlayerView);
            }
            this.viewBinding.f69963e.addView(orPlayerView, new FrameLayout.LayoutParams(-1, -1));
        }
        if (video != null) {
            Z0(video.getWidth(), video.getHeight());
        }
    }

    private final void I0(String ep2, Subject subject, ShortTVItem item, boolean fromTrending) {
        String description;
        String format;
        String description2;
        ExpandView expandView = this.viewBinding.f69962d;
        expandView.setExpandListener(new h());
        if (item == null || (description2 = item.getDescription()) == null || description2.length() <= 0) {
            description = subject.getDescription();
            if (description == null) {
                description = "";
            }
        } else {
            description = item.getDescription();
        }
        if (description == null || description.length() == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            format = String.format("EP%s", Arrays.copyOf(new Object[]{ep2}, 1));
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f67412a;
            format = String.format("EP%s | %s", Arrays.copyOf(new Object[]{ep2, description}, 2));
        }
        Intrinsics.g(format, "format(...)");
        expandView.setTitle(format);
    }

    private final void J(View view, Subject subject) {
        List l11;
        if (subject == null || (l11 = subject.getUnlockType()) == null) {
            l11 = CollectionsKt.l();
        }
        boolean contains = l11.contains(1);
        boolean contains2 = l11.contains(2);
        View findViewById = view != null ? view.findViewById(R$id.iv_lock_icon) : null;
        View findViewById2 = view != null ? view.findViewById(R$id.btn_watch_ad_unlock) : null;
        View findViewById3 = view != null ? view.findViewById(R$id.tv_buy_to_continue) : null;
        View findViewById4 = view != null ? view.findViewById(R$id.container_series_info) : null;
        if (contains && contains2) {
            if (findViewById != null) {
                yr.b.e(findViewById);
            }
            if (findViewById2 != null) {
                yr.b.e(findViewById2);
            }
            if (findViewById3 != null) {
                yr.b.b(findViewById3);
            }
            if (findViewById4 != null) {
                yr.b.e(findViewById4);
                return;
            }
            return;
        }
        if (contains) {
            if (findViewById != null) {
                yr.b.e(findViewById);
            }
            if (findViewById2 != null) {
                yr.b.b(findViewById2);
            }
            if (findViewById3 != null) {
                yr.b.e(findViewById3);
            }
            if (findViewById4 != null) {
                yr.b.e(findViewById4);
                return;
            }
            return;
        }
        if (contains2) {
            if (findViewById != null) {
                yr.b.e(findViewById);
            }
            if (findViewById2 != null) {
                yr.b.e(findViewById2);
            }
            if (findViewById3 != null) {
                yr.b.b(findViewById3);
            }
            if (findViewById4 != null) {
                yr.b.b(findViewById4);
                return;
            }
            return;
        }
        if (findViewById != null) {
            yr.b.b(findViewById);
        }
        if (findViewById2 != null) {
            yr.b.b(findViewById2);
        }
        if (findViewById3 != null) {
            yr.b.b(findViewById3);
        }
        if (findViewById4 != null) {
            yr.b.b(findViewById4);
        }
    }

    private final void J0() {
        LiveData H0;
        Subject subject;
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        int unlockFrom = (shortTvViewModel == null || (H0 = shortTvViewModel.H0()) == null || (subject = (Subject) H0.f()) == null) ? 0 : subject.getUnlockFrom();
        if (unlockFrom <= 0) {
            return;
        }
        this.isFreePreviewMode = true;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(unlockFrom / 60), Integer.valueOf(unlockFrom % 60)}, 2));
        Intrinsics.g(format, "format(...)");
        this.viewBinding.H.setText(N(format));
        BLTextView tvWatchFreeCountdown = this.viewBinding.H;
        Intrinsics.g(tvWatchFreeCountdown, "tvWatchFreeCountdown");
        yr.b.e(tvWatchFreeCountdown);
    }

    private final void K(View view, Subject subject) {
        List l11;
        if (subject == null || (l11 = subject.getUnlockType()) == null) {
            l11 = CollectionsKt.l();
        }
        View findViewById = view != null ? view.findViewById(R$id.iv_lock_icon) : null;
        View findViewById2 = view != null ? view.findViewById(R$id.btn_watch_ad_unlock) : null;
        View findViewById3 = view != null ? view.findViewById(R$id.tv_buy_to_continue) : null;
        View findViewById4 = view != null ? view.findViewById(R$id.container_series_info) : null;
        if (l11.contains(1)) {
            if (findViewById != null) {
                yr.b.e(findViewById);
            }
            if (findViewById2 != null) {
                yr.b.b(findViewById2);
            }
            if (findViewById3 != null) {
                yr.b.e(findViewById3);
            }
            if (findViewById4 != null) {
                yr.b.e(findViewById4);
                return;
            }
            return;
        }
        if (l11.contains(2)) {
            if (findViewById != null) {
                yr.b.e(findViewById);
            }
            if (findViewById2 != null) {
                yr.b.e(findViewById2);
            }
            if (findViewById3 != null) {
                yr.b.b(findViewById3);
            }
            if (findViewById4 != null) {
                yr.b.b(findViewById4);
                return;
            }
            return;
        }
        if (findViewById != null) {
            yr.b.b(findViewById);
        }
        if (findViewById2 != null) {
            yr.b.b(findViewById2);
        }
        if (findViewById3 != null) {
            yr.b.b(findViewById3);
        }
        if (findViewById4 != null) {
            yr.b.b(findViewById4);
        }
    }

    private final void K0(js.e item) {
        FragmentActivity fragmentActivity;
        List unlockType;
        List unlockType2;
        List unlockType3;
        ShortTVItem d11;
        Media video;
        Cover cover;
        Cover cover2;
        AppCompatTextView appCompatTextView;
        String str;
        SkuInfo skuInfo;
        SkuInfo skuInfo2;
        String price;
        AppCompatTextView appCompatTextView2;
        LiveData H0;
        AppCompatTextView appCompatTextView3;
        View findViewById;
        if (this.lockedView == null) {
            View inflate = this.viewBinding.L.inflate();
            this.lockedView = inflate;
            if (inflate != null && (findViewById = inflate.findViewById(R$id.btn_buy_full_series)) != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.widget.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ShortTvVideoItemView.L0(ShortTvVideoItemView.this, view);
                    }
                });
            }
        }
        View view = this.lockedView;
        if (view != null && (appCompatTextView3 = (AppCompatTextView) view.findViewById(R$id.btn_watch_ad_unlock)) != null) {
            appCompatTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.widget.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ShortTvVideoItemView.M0(ShortTvVideoItemView.this, view2);
                }
            });
        }
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        String str2 = null;
        Subject subject = (shortTvViewModel == null || (H0 = shortTvViewModel.H0()) == null) ? null : (Subject) H0.f();
        View view2 = this.lockedView;
        if (view2 != null && (appCompatTextView2 = (AppCompatTextView) view2.findViewById(R$id.tv_series_title)) != null) {
            appCompatTextView2.setText(subject != null ? subject.getTitle() : null);
        }
        View view3 = this.lockedView;
        if (view3 != null && (appCompatTextView = (AppCompatTextView) view3.findViewById(R$id.tv_series_price)) != null) {
            Float t11 = (subject == null || (skuInfo2 = subject.getSkuInfo()) == null || (price = skuInfo2.getPrice()) == null) ? null : StringsKt.t(price);
            if (subject == null || (skuInfo = subject.getSkuInfo()) == null || (str = skuInfo.getCurrencySymbol()) == null) {
                str = "$";
            }
            if (t11 != null) {
                String format = String.format("From " + str + "%.2f", Arrays.copyOf(new Object[]{t11}, 1));
                Intrinsics.g(format, "format(...)");
                appCompatTextView.setText(format);
                yr.b.e(appCompatTextView);
            } else {
                yr.b.b(appCompatTextView);
            }
        }
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment == null || (fragmentActivity = shortTvDetailListFragment.getActivity()) == null) {
            Context context = getContext();
            fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        }
        String url = (subject == null || (cover2 = subject.getCover()) == null) ? null : cover2.getUrl();
        View view4 = this.lockedView;
        AppCompatImageView appCompatImageView = view4 != null ? (AppCompatImageView) view4.findViewById(R$id.iv_series_cover) : null;
        if (appCompatImageView != null && url != null && url.length() != 0 && fragmentActivity != null) {
            Glide.with(fragmentActivity).load2(url).centerCrop().into(appCompatImageView);
        }
        View view5 = this.lockedView;
        final AppCompatImageView appCompatImageView2 = view5 != null ? (AppCompatImageView) view5.findViewById(R$id.iv_blur_bg) : null;
        if (item != null && (d11 = item.d()) != null && (video = d11.getVideo()) != null && (cover = video.getCover()) != null) {
            str2 = cover.getUrl();
        }
        String str3 = str2;
        if (appCompatImageView2 != null && str3 != null && str3.length() != 0) {
            com.transsion.shorttv.base.image.blurhash.e.d(com.transsion.shorttv.base.image.blurhash.e.f52845a, str3, 0, 0, new Function1() { // from class: com.transsion.shorttv.ui.widget.a0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit N0;
                    N0 = ShortTvVideoItemView.N0(AppCompatImageView.this, (BitmapDrawable) obj);
                    return N0;
                }
            }, 6, null);
        }
        if (subject == null || subject.getMiniTvType() != 2) {
            J(this.lockedView, subject);
        } else {
            K(this.lockedView, subject);
        }
        View view6 = this.lockedView;
        if (view6 != null) {
            yr.b.e(view6);
        }
        this.isEpisodeLocked = true;
        this.autoHideRightMenuHandle.removeCallbacks(this.autoHideRightMenuRunnable);
        P0();
        if (subject != null && (unlockType3 = subject.getUnlockType()) != null && unlockType3.contains(1)) {
            Group groupPayLockHide = this.viewBinding.f69967i;
            Intrinsics.g(groupPayLockHide, "groupPayLockHide");
            yr.b.b(groupPayLockHide);
        }
        V();
        boolean z10 = subject != null && subject.getMiniTvType() == 2 && (unlockType2 = subject.getUnlockType()) != null && unlockType2.contains(1);
        if (subject != null && (unlockType = subject.getUnlockType()) != null && unlockType.contains(2) && !z10) {
            R0();
        }
        ss.b bVar = ss.b.f75981a;
        js.e eVar = this.data;
        bVar.i(subject, eVar != null ? eVar.c() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        if (this.isEpisodeLocked) {
            return;
        }
        AppCompatImageView ivDownload = this.viewBinding.f69970l;
        Intrinsics.g(ivDownload, "ivDownload");
        if (ivDownload.getVisibility() == 0) {
            this.autoHideRightMenuHandle.removeCallbacks(this.autoHideRightMenuRunnable);
            this.autoHideRightMenuHandle.postDelayed(this.autoHideRightMenuRunnable, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(ShortTvVideoItemView shortTvVideoItemView, View view) {
        shortTvVideoItemView.S0();
        shortTvVideoItemView.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(ShortTvVideoItemView shortTvVideoItemView) {
        shortTvVideoItemView.X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(ShortTvVideoItemView shortTvVideoItemView, View view) {
        shortTvVideoItemView.S0();
        watchAdToUnlock$shortTvLib_release$default(shortTvVideoItemView, false, 1, null);
    }

    private final SpannableString N(String time) {
        String string = getContext().getString(R$string.short_tv_watch_free_countdown, time);
        Intrinsics.g(string, "getString(...)");
        SpannableString spannableString = new SpannableString(string);
        int o02 = StringsKt.o0(string, time, 0, false, 6, null);
        if (o02 < 0) {
            return spannableString;
        }
        int length = time.length() + o02;
        int color = androidx.core.content.b.getColor(getContext(), R$color.short_tv_white_60);
        int color2 = androidx.core.content.b.getColor(getContext(), R$color.short_tv_white);
        if (o02 > 0) {
            spannableString.setSpan(new ForegroundColorSpan(color), 0, o02, 33);
        }
        spannableString.setSpan(new ForegroundColorSpan(color2), o02, length, 33);
        if (length < string.length()) {
            spannableString.setSpan(new ForegroundColorSpan(color), length, string.length(), 33);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(AppCompatImageView appCompatImageView, BitmapDrawable drawable) {
        Intrinsics.h(drawable, "drawable");
        appCompatImageView.setImageDrawable(drawable);
        return Unit.f67184a;
    }

    private final void O() {
        final qs.i B0;
        final ShortTvDetailListFragment shortTvDetailListFragment;
        LiveData H0;
        ss.b bVar = ss.b.f75981a;
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        Subject subject = (shortTvViewModel == null || (H0 = shortTvViewModel.H0()) == null) ? null : (Subject) H0.f();
        js.e eVar = this.data;
        bVar.h(subject, eVar != null ? eVar.c() : 0, "minitv_pay", "");
        S0();
        ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
        if (shortTvViewModel2 == null || (B0 = shortTvViewModel2.B0()) == null || (shortTvDetailListFragment = this.fragment) == null) {
            return;
        }
        if (B0.a()) {
            Q(B0.getUserId());
        } else {
            shortTvDetailListFragment.e1(B0, new Function0() { // from class: com.transsion.shorttv.ui.widget.e0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit P;
                    P = ShortTvVideoItemView.P(ShortTvVideoItemView.this, shortTvDetailListFragment, B0);
                    return P;
                }
            });
        }
    }

    private final void O0() {
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment != null) {
            shortTvDetailListFragment.p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(ShortTvVideoItemView shortTvVideoItemView, ShortTvDetailListFragment shortTvDetailListFragment, qs.i iVar) {
        String e11;
        androidx.view.b0 l02;
        js.e eVar = shortTvVideoItemView.data;
        if (eVar == null || (e11 = eVar.e()) == null) {
            return Unit.f67184a;
        }
        js.e eVar2 = shortTvVideoItemView.data;
        if (eVar2 == null) {
            return Unit.f67184a;
        }
        int c11 = eVar2.c();
        b bVar = new b(iVar);
        ShortTvViewModel shortTvViewModel = shortTvVideoItemView.mShortTvViewModel;
        if (shortTvViewModel != null && (l02 = shortTvViewModel.l0()) != null) {
            l02.j(shortTvDetailListFragment.getViewLifecycleOwner(), bVar);
        }
        shortTvVideoItemView.setLoading(true);
        ShortTvViewModel shortTvViewModel2 = shortTvVideoItemView.mShortTvViewModel;
        if (shortTvViewModel2 != null) {
            shortTvViewModel2.T(e11, c11);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0() {
        this.autoHideRightMenuHandle.removeCallbacks(this.autoHideRightMenuRunnable);
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        if (shortTvViewModel != null) {
            shortTvViewModel.q1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(String userId) {
        LiveData H0;
        Subject subject;
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_no_network_toast));
            return;
        }
        if (userId != null) {
            String str = userId.length() > 0 ? userId : null;
            if (str != null) {
                ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
                if (shortTvViewModel == null || (H0 = shortTvViewModel.H0()) == null || (subject = (Subject) H0.f()) == null) {
                    return;
                }
                SkuInfo skuInfo = subject.getSkuInfo();
                if (skuInfo == null) {
                    a.C0856a.l(lg.a.f68962a, this.TAG, "callPayMethod failed, no sku info.", false, 4, null);
                    return;
                }
                String skuId = skuInfo.getSkuId();
                if (skuId != null) {
                    String str2 = skuId.length() > 0 ? skuId : null;
                    if (str2 != null) {
                        String subjectId = subject.getSubjectId();
                        if (subjectId != null) {
                            String str3 = subjectId.length() > 0 ? subjectId : null;
                            if (str3 == null) {
                                return;
                            }
                            js.e eVar = this.data;
                            com.transsion.shorttv.order.d.f53100a.d(getContext(), new CreatePaynicornOrderReqBean("MovieBox", str2, str, null, null, null, MapsKt.f(TuplesKt.a("subject_id", str3)), false, null, Sdk$SDKError.Reason.DEEPLINK_OPEN_FAILED_VALUE, null), new c(subject, eVar != null ? eVar.c() : 0, str));
                            return;
                        }
                        return;
                    }
                }
                a.C0856a.l(lg.a.f68962a, this.TAG, "callPayMethod failed, skuId is empty.", false, 4, null);
                return;
            }
        }
        a.C0856a.l(lg.a.f68962a, this.TAG, "callPayMethod failed, userId is empty.", false, 4, null);
    }

    private final void Q0() {
        FragmentActivity activity;
        Window window;
        WindowInsetsController insetsController;
        int statusBars;
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment == null || (activity = shortTvDetailListFragment.getActivity()) == null || (window = activity.getWindow()) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 30) {
            window.clearFlags(1024);
            window.getDecorView().setSystemUiVisibility(256);
            return;
        }
        insetsController = window.getInsetsController();
        if (insetsController != null) {
            statusBars = WindowInsets.Type.statusBars();
            insetsController.show(statusBars);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(ShortTvVideoItemView shortTvVideoItemView) {
        shortTvVideoItemView.O0();
    }

    private final void R0() {
        a1 a1Var;
        S0();
        Integer num = this.watchAdUnlockSeconds;
        if (num == null || num.intValue() <= 0) {
            num = null;
        }
        updateUnlockCountdownText$shortTvLib_release(num);
        if (num == null || (a1Var = this.countdownController) == null) {
            return;
        }
        a1Var.a(num.intValue());
    }

    private final void S(ts.b item) {
        if (this.hasSubDownloading) {
            fs.b.f62582a.d(R$string.short_tv_subtitle_is_downloading);
            return;
        }
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.d(R$string.short_tv_no_network_toast);
            return;
        }
        b.a aVar = com.transsion.shorttv.subtitle.manager.b.f53144a;
        aVar.b().b(this);
        item.a().setStatus(2);
        this.hasSubDownloading = true;
        a.C0856a.f(lg.a.f68962a, this.TAG, ShortTvVideoItemView.class.getSimpleName() + " --> downloadSubtitle() --> 内置字幕列表，下载字幕，name = " + item.a().getName() + ", subtype = " + item.a().getType() + ",download subtitleName = " + item.a().getSubtitleName() + ", subResourceId = " + item.a().getResourceId() + "~", false, 4, null);
        item.a().setAutoDownload(false);
        this.subDownloadBean = item;
        aVar.b().d(item);
    }

    private final void S0() {
        a1 a1Var = this.countdownController;
        if (a1Var != null) {
            a1Var.b();
        }
        updateUnlockCountdownText$shortTvLib_release(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(ShortTvVideoItemView shortTvVideoItemView, Boolean bool) {
        shortTvVideoItemView.T0();
    }

    private final void T0() {
        LiveData H0;
        Subject subject;
        ShortTVFavInfo shortTVFavInfo;
        LiveData H02;
        Subject subject2;
        ShortTVFavInfo shortTVFavInfo2;
        String favoriteNum;
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        this.viewBinding.f69984z.setText(ds.f.a((shortTvViewModel == null || (H02 = shortTvViewModel.H0()) == null || (subject2 = (Subject) H02.f()) == null || (shortTVFavInfo2 = subject2.getShortTVFavInfo()) == null || (favoriteNum = shortTVFavInfo2.getFavoriteNum()) == null) ? 0L : Long.parseLong(favoriteNum)));
        AppCompatTextView appCompatTextView = this.viewBinding.f69984z;
        ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
        appCompatTextView.setSelected((shortTvViewModel2 == null || (H0 = shortTvViewModel2.H0()) == null || (subject = (Subject) H0.f()) == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) ? false : shortTVFavInfo.getHasFavorite());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(js.f result) {
        Integer valueOf = result instanceof js.i ? Integer.valueOf(R$string.short_tv_error_load_failed) : result instanceof js.h ? Integer.valueOf(R$string.short_tv_favorite_remove_toast) : result instanceof js.g ? Integer.valueOf(R$string.short_tv_favorite_toast) : null;
        if (valueOf != null) {
            fs.b.f62582a.d(valueOf.intValue());
        }
    }

    private final void U0(long remainingMs) {
        long g11 = RangesKt.g(remainingMs / 1000, 0L);
        long j11 = 60;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(g11 / j11), Long.valueOf(g11 % j11)}, 2));
        Intrinsics.g(format, "format(...)");
        this.viewBinding.H.setText(N(format));
    }

    private final void V() {
        this.isFreePreviewMode = false;
        BLTextView tvWatchFreeCountdown = this.viewBinding.H;
        Intrinsics.g(tvWatchFreeCountdown, "tvWatchFreeCountdown");
        yr.b.b(tvWatchFreeCountdown);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(long progress) {
        int i11 = (int) progress;
        this.viewBinding.f69979u.setProgress(i11);
        this.viewBinding.f69977s.setProgress(i11);
    }

    private final void W() {
        S0();
        V();
        STCommonVideoAdHelper sTCommonVideoAdHelper = this.videoAdHelper;
        if (sTCommonVideoAdHelper != null) {
            STCommonVideoAdHelper.q(sTCommonVideoAdHelper, 0, 1, null);
        }
        this.videoAdHelper = null;
        this.isEpisodeLocked = false;
        View view = this.lockedView;
        if (view != null) {
            yr.b.b(view);
        }
        Group groupPayLockHide = this.viewBinding.f69967i;
        Intrinsics.g(groupPayLockHide, "groupPayLockHide");
        yr.b.e(groupPayLockHide);
        L();
    }

    private final void W0(long max) {
        int i11 = (int) max;
        this.viewBinding.f69979u.setMax(i11);
        this.viewBinding.f69977s.setMax(i11);
        a.C0856a.f(lg.a.f68962a, this.TAG, "updateProgressMax: " + max + "  : " + this, false, 4, null);
    }

    private final void X() {
        if (this.isEpisodeLocked) {
            return;
        }
        this.autoHideRightMenuHandle.removeCallbacks(this.autoHideRightMenuRunnable);
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        if (shortTvViewModel != null) {
            shortTvViewModel.q1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(ShortTvVideoItemView shortTvVideoItemView) {
        ShortTvViewModel shortTvViewModel = shortTvVideoItemView.mShortTvViewModel;
        if (shortTvViewModel != null) {
            shortTvViewModel.e1(false);
        }
    }

    private final void Y() {
        FragmentActivity activity;
        Window window;
        WindowInsetsController insetsController;
        int statusBars;
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment == null || (activity = shortTvDetailListFragment.getActivity()) == null || (window = activity.getWindow()) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 30) {
            window.addFlags(1024);
            window.getDecorView().setSystemUiVisibility(1284);
            return;
        }
        insetsController = window.getInsetsController();
        if (insetsController != null) {
            statusBars = WindowInsets.Type.statusBars();
            insetsController.hide(statusBars);
            insetsController.setSystemBarsBehavior(2);
        }
    }

    private final void Y0(boolean isImmersive) {
        int c11 = (int) (com.blankj.utilcode.util.y.c() * (isImmersive ? 0.27d : this.hasAd ? 0.4d : 0.36d));
        FrameLayout flSubtitle = this.viewBinding.f69964f;
        Intrinsics.g(flSubtitle, "flSubtitle");
        ViewGroup.LayoutParams layoutParams = flSubtitle.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.f7757k = -1;
        bVar.f7759l = 0;
        ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = c11;
        bVar.f7777u = -1;
        bVar.f7779v = 0;
        flSubtitle.setLayoutParams(bVar);
    }

    private final void Z(Context context) {
        this.gestureDetector = new GestureDetector(context, new e());
        e0();
    }

    private final void Z0(final Integer w11, final Integer h11) {
        if (w11 == null || h11 == null || w11.intValue() == 0) {
            return;
        }
        if (!this.isOptimizeEnable) {
            FrameLayout flContainer = this.viewBinding.f69963e;
            Intrinsics.g(flContainer, "flContainer");
            ViewGroup.LayoutParams layoutParams = flContainer.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).width = com.blankj.utilcode.util.y.e();
            ((ViewGroup.MarginLayoutParams) bVar).height = (h11.intValue() * ((ViewGroup.MarginLayoutParams) bVar).width) / w11.intValue();
            flContainer.setLayoutParams(bVar);
            return;
        }
        if (getWidth() <= 0 || getHeight() <= 0) {
            post(new Runnable() { // from class: com.transsion.shorttv.ui.widget.m0
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvVideoItemView.a1(ShortTvVideoItemView.this, w11, h11);
                }
            });
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.hasAd = false;
        com.blankj.utilcode.util.a0.a(54.0f);
        int a11 = com.blankj.utilcode.util.a0.a(14.0f);
        com.blankj.utilcode.util.a0.a(4.0f);
        if (h11.intValue() <= w11.intValue()) {
            FrameLayout flContainer2 = this.viewBinding.f69963e;
            Intrinsics.g(flContainer2, "flContainer");
            ViewGroup.LayoutParams layoutParams2 = flContainer2.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
            ((ViewGroup.MarginLayoutParams) bVar2).width = width;
            ((ViewGroup.MarginLayoutParams) bVar2).height = (h11.intValue() * width) / w11.intValue();
            bVar2.H = 0.5f;
            flContainer2.setLayoutParams(bVar2);
            com.transsion.player.orplayer.g gVar = this.orPlayer;
            if (gVar != null) {
                gVar.setScaleMode(ScaleMode.SCALE_ASPECT_FIT);
            }
            LinearLayout llCtr = this.viewBinding.f69974p;
            Intrinsics.g(llCtr, "llCtr");
            ViewGroup.LayoutParams layoutParams3 = llCtr.getLayoutParams();
            if (layoutParams3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar3 = (ConstraintLayout.b) layoutParams3;
            bVar3.f7759l = 0;
            bVar3.f7757k = -1;
            ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin = a11;
            llCtr.setLayoutParams(bVar3);
            return;
        }
        int a12 = com.blankj.utilcode.util.a0.a(50.0f);
        FrameLayout flContainer3 = this.viewBinding.f69963e;
        Intrinsics.g(flContainer3, "flContainer");
        ViewGroup.LayoutParams layoutParams4 = flContainer3.getLayoutParams();
        if (layoutParams4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar4 = (ConstraintLayout.b) layoutParams4;
        ((ViewGroup.MarginLayoutParams) bVar4).width = width;
        ((ViewGroup.MarginLayoutParams) bVar4).height = height - a12;
        bVar4.H = 0.0f;
        flContainer3.setLayoutParams(bVar4);
        com.transsion.player.orplayer.g gVar2 = this.orPlayer;
        if (gVar2 != null) {
            gVar2.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
        }
        LinearLayout llCtr2 = this.viewBinding.f69974p;
        Intrinsics.g(llCtr2, "llCtr");
        ViewGroup.LayoutParams layoutParams5 = llCtr2.getLayoutParams();
        if (layoutParams5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar5 = (ConstraintLayout.b) layoutParams5;
        bVar5.f7759l = 0;
        bVar5.f7757k = -1;
        ((ViewGroup.MarginLayoutParams) bVar5).bottomMargin = a11;
        llCtr2.setLayoutParams(bVar5);
    }

    private final void a0() {
        LinearLayout llDownloadGuideBubble = this.viewBinding.f69975q;
        Intrinsics.g(llDownloadGuideBubble, "llDownloadGuideBubble");
        this.downloadGuideBubbleController = new com.transsion.shorttv.ui.widget.c(llDownloadGuideBubble, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(ShortTvVideoItemView shortTvVideoItemView, Integer num, Integer num2) {
        shortTvVideoItemView.Z0(num, num2);
    }

    private final void b0() {
        List<DubsInfo> dubs;
        LiveData H0;
        Subject subject;
        FragmentActivity activity;
        js.e eVar;
        LiveData H02;
        Subject subject2;
        List<DubsInfo> dubs2;
        List<DubsInfo> dubs3;
        LiveData Z;
        a.C0856a c0856a = lg.a.f68962a;
        boolean z10 = false;
        a.C0856a.f(c0856a, this.TAG, "initLanguage", false, 4, null);
        if (this.isOptimizeEnable) {
            SimpleSubtitleView simpleSubtitleView = this.viewBinding.K;
            simpleSubtitleView.setTextSize(2, 24.0f);
            simpleSubtitleView.setTypeface(Typeface.create("sans-serif-medium", 0));
            simpleSubtitleView.setShadowLayer(4.0f, 0.0f, 2.0f, Color.parseColor("#CC000000"));
            simpleSubtitleView.setGravity(17);
        } else {
            SimpleSubtitleView simpleSubtitleView2 = this.viewBinding.K;
            simpleSubtitleView2.setTextSize(2, 16.0f);
            simpleSubtitleView2.setTypeface(Typeface.DEFAULT);
            simpleSubtitleView2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        String str = null;
        DubsInfoData dubsInfoData = (shortTvViewModel == null || (Z = shortTvViewModel.Z()) == null) ? null : (DubsInfoData) Z.f();
        boolean z11 = (dubsInfoData == null || (dubs3 = dubsInfoData.getDubs()) == null || dubs3.isEmpty()) ? false : true;
        if (this.isOptimizeEnable) {
            AppCompatTextView tvLanguage = this.viewBinding.A;
            Intrinsics.g(tvLanguage, "tvLanguage");
            yr.b.b(tvLanguage);
            if (z11) {
                if (((dubsInfoData == null || (dubs2 = dubsInfoData.getDubs()) == null) ? 0 : dubs2.size()) > 1) {
                    AppCompatTextView tvAudio = this.viewBinding.f69981w;
                    Intrinsics.g(tvAudio, "tvAudio");
                    yr.b.e(tvAudio);
                }
            }
            AppCompatTextView tvAudio2 = this.viewBinding.f69981w;
            Intrinsics.g(tvAudio2, "tvAudio");
            yr.b.b(tvAudio2);
        } else {
            AppCompatTextView tvLanguage2 = this.viewBinding.A;
            Intrinsics.g(tvLanguage2, "tvLanguage");
            yr.b.e(tvLanguage2);
            if (z11) {
                a.C0856a.f(c0856a, this.TAG, "initLanguage--- hasDubs :" + (dubsInfoData != null ? dubsInfoData.getDubs() : null), false, 4, null);
                this.viewBinding.A.setSelected(true);
                if (dubsInfoData == null || (dubs = dubsInfoData.getDubs()) == null) {
                    return;
                }
                for (DubsInfo dubsInfo : dubs) {
                    String subjectId = dubsInfo.getSubjectId();
                    ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
                    if (Intrinsics.c(subjectId, (shortTvViewModel2 == null || (H0 = shortTvViewModel2.H0()) == null || (subject = (Subject) H0.f()) == null) ? null : subject.getSubjectId())) {
                        this.viewBinding.A.setText(dubsInfo.getLanName());
                    }
                }
                return;
            }
        }
        js.e eVar2 = this.data;
        if (eVar2 != null && eVar2.c() == 0) {
            z10 = true;
        }
        if (z10) {
            a.C0856a.f(c0856a, this.TAG, "预告片没有字幕，不处理", false, 4, null);
            return;
        }
        a.C0856a.f(c0856a, this.TAG, ">>>>>>>--------------------initLanguage subtitle, position:" + this.position, false, 4, null);
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment == null || (activity = shortTvDetailListFragment.getActivity()) == null || activity.isDestroyed() || activity.isFinishing() || (eVar = this.data) == null) {
            return;
        }
        com.transsion.shorttv.subtitle.a aVar = this.subtitleControl;
        if (aVar != null) {
            aVar.onDestroy();
        }
        a.C0657a c0657a = com.transsion.shorttv.subtitle.a.f53129a;
        ms.k0 k0Var = this.viewBinding;
        ShortTvViewModel shortTvViewModel3 = this.mShortTvViewModel;
        if (shortTvViewModel3 != null && (H02 = shortTvViewModel3.H0()) != null && (subject2 = (Subject) H02.f()) != null) {
            str = subject2.getOps();
        }
        com.transsion.shorttv.subtitle.a a11 = c0657a.a(activity, k0Var, shortTvViewModel3, eVar, str);
        a11.e();
        a11.a(new Function1() { // from class: com.transsion.shorttv.ui.widget.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit c02;
                c02 = ShortTvVideoItemView.c0(ShortTvVideoItemView.this, ((Boolean) obj).booleanValue());
                return c02;
            }
        });
        a11.b(new Function1() { // from class: com.transsion.shorttv.ui.widget.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d02;
                d02 = ShortTvVideoItemView.d0(ShortTvVideoItemView.this, (ts.b) obj);
                return d02;
            }
        });
        this.subtitleControl = a11;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b1(js.e r13) {
        /*
            r12 = this;
            r0 = 1
            r1 = 0
            r12.V0(r1)
            if (r13 == 0) goto L45
            int r1 = r13.c()
            if (r1 != 0) goto L20
            ms.k0 r0 = r12.viewBinding
            com.transsion.shorttv.base.widget.TnTextView r0 = r0.G
            android.content.Context r1 = r12.getContext()
            int r2 = com.transsion.shorttv.R$string.short_tv_trailer
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            goto L45
        L20:
            ms.k0 r2 = r12.viewBinding
            com.transsion.shorttv.base.widget.TnTextView r2 = r2.G
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.f67412a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = com.transsion.shorttv.utils.i.e(r1)
            java.lang.Object[] r3 = new java.lang.Object[r0]
            r4 = 0
            r3[r4] = r1
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r3, r0)
            java.lang.String r1 = "EP%s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            java.lang.String r1 = "format(...)"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            r2.setText(r0)
        L45:
            r0 = 0
            if (r13 == 0) goto Ld6
            com.transsion.shorttv.bean.ShortTVItem r13 = r13.d()
            if (r13 == 0) goto Ld6
            com.transsion.shorttv.bean.Media r13 = r13.getVideo()
            if (r13 == 0) goto Ld6
            com.transsion.shorttv.bean.FirstFrame r1 = r13.getFirstFrame()
            if (r1 == 0) goto L63
            java.lang.String r1 = r1.getUrl()
            if (r1 != 0) goto L61
            goto L63
        L61:
            r3 = r1
            goto L6f
        L63:
            com.transsion.shorttv.bean.Cover r13 = r13.getCover()
            if (r13 == 0) goto L6e
            java.lang.String r1 = r13.getUrl()
            goto L61
        L6e:
            r3 = r0
        L6f:
            if (r3 == 0) goto Ld6
            as.b$a r2 = as.b.f16186a
            int r5 = r12.screenWidth
            r10 = 120(0x78, float:1.68E-43)
            r11 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r4 = r5
            java.lang.String r13 = as.b.a.e(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            ms.k0 r0 = r12.viewBinding
            androidx.appcompat.widget.AppCompatImageView r0 = r0.f69969k
            java.lang.Object r0 = r0.getTag()
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r13, r0)
            if (r0 == 0) goto L90
            return
        L90:
            com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment r0 = r12.fragment
            if (r0 == 0) goto Ldd
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            if (r0 != 0) goto L9b
            goto Ldd
        L9b:
            lg.a$a r1 = lg.a.f68962a
            java.lang.String r2 = r12.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "into  "
            r3.append(r4)
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            r5 = 4
            r6 = 0
            r4 = 0
            lg.a.C0856a.f(r1, r2, r3, r4, r5, r6)
            ms.k0 r1 = r12.viewBinding
            androidx.appcompat.widget.AppCompatImageView r1 = r1.f69969k
            r1.setTag(r13)
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)
            com.bumptech.glide.RequestBuilder r13 = r0.load2(r13)
            com.transsion.shorttv.ui.widget.ShortTvVideoItemView$i r0 = new com.transsion.shorttv.ui.widget.ShortTvVideoItemView$i
            r0.<init>()
            com.bumptech.glide.RequestBuilder r13 = r13.addListener(r0)
            ms.k0 r0 = r12.viewBinding
            androidx.appcompat.widget.AppCompatImageView r0 = r0.f69969k
            r13.into(r0)
            goto Ldd
        Ld6:
            ms.k0 r13 = r12.viewBinding
            androidx.appcompat.widget.AppCompatImageView r13 = r13.f69969k
            r13.setImageDrawable(r0)
        Ldd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.widget.ShortTvVideoItemView.b1(js.e):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(ShortTvVideoItemView shortTvVideoItemView, boolean z10) {
        List<DubsInfo> dubs;
        LiveData Z;
        if (shortTvVideoItemView.isOptimizeEnable) {
            AppCompatTextView tvSubtitles = shortTvVideoItemView.viewBinding.F;
            Intrinsics.g(tvSubtitles, "tvSubtitles");
            tvSubtitles.setVisibility(z10 ? 0 : 8);
        } else {
            ShortTvViewModel shortTvViewModel = shortTvVideoItemView.mShortTvViewModel;
            DubsInfoData dubsInfoData = (shortTvViewModel == null || (Z = shortTvViewModel.Z()) == null) ? null : (DubsInfoData) Z.f();
            if (dubsInfoData != null && (dubs = dubsInfoData.getDubs()) != null && !dubs.isEmpty()) {
                return Unit.f67184a;
            }
            shortTvVideoItemView.viewBinding.A.setSelected(z10);
            if (!z10) {
                shortTvVideoItemView.viewBinding.A.setText(Utils.a().getString(R$string.short_tv_language));
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(final ShortTvVideoItemView shortTvVideoItemView, FragmentActivity fragmentActivity, final Subject subject, final int i11, final AppCompatTextView appCompatTextView, final js.e eVar, boolean z10, String errorCode, String errorMessage) {
        Intrinsics.h(errorCode, "errorCode");
        Intrinsics.h(errorMessage, "errorMessage");
        if (z10) {
            STCommonVideoAdHelper sTCommonVideoAdHelper = shortTvVideoItemView.videoAdHelper;
            if (sTCommonVideoAdHelper != null) {
                sTCommonVideoAdHelper.u(fragmentActivity, new Function0() { // from class: com.transsion.shorttv.ui.widget.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit d12;
                        d12 = ShortTvVideoItemView.d1(ShortTvVideoItemView.this, eVar);
                        return d12;
                    }
                }, new Function1() { // from class: com.transsion.shorttv.ui.widget.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit e12;
                        e12 = ShortTvVideoItemView.e1(ShortTvVideoItemView.this, subject, i11, eVar, appCompatTextView, ((Boolean) obj).booleanValue());
                        return e12;
                    }
                });
            }
        } else {
            ss.b.f75981a.l(subject, i11, "fail", errorMessage, errorCode, MediaItem.MUSIC_FLOAT_STATE_PLAY);
            fs.b.f62582a.d(R$string.short_tv_ad_unlocked_get_ad_failed);
            shortTvVideoItemView.videoAdHelper = null;
            if (appCompatTextView != null) {
                appCompatTextView.setEnabled(true);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(ShortTvVideoItemView shortTvVideoItemView, ts.b bVar) {
        SubtitleDownloadTable a11;
        if (!shortTvVideoItemView.isOptimizeEnable) {
            shortTvVideoItemView.viewBinding.A.setText((bVar == null || (a11 = bVar.a()) == null) ? null : a11.getLanName());
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit d1(com.transsion.shorttv.ui.widget.ShortTvVideoItemView r5, js.e r6) {
        /*
            com.transsion.shorttv.viewmodel.ShortTvViewModel r0 = r5.mShortTvViewModel
            if (r0 == 0) goto Lc4
            androidx.lifecycle.LiveData r0 = r0.H0()
            if (r0 == 0) goto Lc4
            java.lang.Object r0 = r0.f()
            com.transsion.shorttv.bean.Subject r0 = (com.transsion.shorttv.bean.Subject) r0
            if (r0 != 0) goto L14
            goto Lc4
        L14:
            if (r6 == 0) goto Lb4
            com.transsion.shorttv.bean.ShortTVItem r6 = r6.d()
            if (r6 == 0) goto Lb4
            ur.a r1 = ur.a.f77012a
            java.lang.String r1 = "unlockEpCount"
            java.lang.String r2 = "ShortTvPlayerUnlockPlayScene"
            r3 = 0
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.transsion.ad.scene.d r4 = com.transsion.ad.scene.d.f42258a     // Catch: java.lang.Throwable -> L32
            com.google.gson.JsonObject r2 = r4.b(r2)     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L34
            com.google.gson.JsonElement r1 = r2.get(r1)     // Catch: java.lang.Throwable -> L32
            goto L35
        L32:
            r1 = move-exception
            goto L94
        L34:
            r1 = r3
        L35:
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.b(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.b(r4)     // Catch: java.lang.Throwable -> L32
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r2, r4)     // Catch: java.lang.Throwable -> L32
            if (r4 == 0) goto L4e
            if (r1 == 0) goto L4c
            r1.getAsString()     // Catch: java.lang.Throwable -> L32
        L4c:
            r1 = r3
            goto L8f
        L4e:
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L32
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.b(r4)     // Catch: java.lang.Throwable -> L32
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r2, r4)     // Catch: java.lang.Throwable -> L32
            if (r4 == 0) goto L6b
            if (r1 == 0) goto L65
            int r1 = r1.getAsInt()     // Catch: java.lang.Throwable -> L32
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L32
            goto L66
        L65:
            r1 = r3
        L66:
            boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L8f
            goto L4c
        L6b:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch: java.lang.Throwable -> L32
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.b(r4)     // Catch: java.lang.Throwable -> L32
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r2, r4)     // Catch: java.lang.Throwable -> L32
            if (r4 == 0) goto L7d
            if (r1 == 0) goto L4c
            r1.getAsLong()     // Catch: java.lang.Throwable -> L32
            goto L4c
        L7d:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch: java.lang.Throwable -> L32
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.b(r4)     // Catch: java.lang.Throwable -> L32
            boolean r2 = kotlin.jvm.internal.Intrinsics.c(r2, r4)     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L4c
            if (r1 == 0) goto L4c
            r1.getAsBoolean()     // Catch: java.lang.Throwable -> L32
            goto L4c
        L8f:
            java.lang.Object r1 = kotlin.Result.m1185constructorimpl(r1)     // Catch: java.lang.Throwable -> L32
            goto L9e
        L94:
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.a(r1)
            java.lang.Object r1 = kotlin.Result.m1185constructorimpl(r1)
        L9e:
            java.lang.Throwable r2 = kotlin.Result.m1188exceptionOrNullimpl(r1)
            if (r2 != 0) goto La5
            r3 = r1
        La5:
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto Lae
            int r1 = r3.intValue()
            goto Laf
        Lae:
            r1 = 1
        Laf:
            zr.b r2 = zr.b.f79574a
            r2.g(r0, r6, r1)
        Lb4:
            java.lang.String r6 = r0.getSubjectId()
            if (r6 == 0) goto Lc1
            com.transsion.shorttv.viewmodel.ShortTvViewModel r5 = r5.mShortTvViewModel
            if (r5 == 0) goto Lc1
            r5.a1(r6)
        Lc1:
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        Lc4:
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.widget.ShortTvVideoItemView.d1(com.transsion.shorttv.ui.widget.ShortTvVideoItemView, js.e):kotlin.Unit");
    }

    private final void e0() {
        new com.transsion.shorttv.base.widget.e(getContext(), this.viewBinding.J).r(new g());
        this.viewBinding.f69979u.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.shorttv.ui.widget.n0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean f02;
                f02 = ShortTvVideoItemView.f0(view, motionEvent);
                return f02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(ShortTvVideoItemView shortTvVideoItemView, Subject subject, int i11, js.e eVar, AppCompatTextView appCompatTextView, boolean z10) {
        shortTvVideoItemView.videoAdHelper = null;
        if (z10) {
            ss.b.f75981a.l(subject, i11, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, "", "0", MediaItem.MUSIC_FLOAT_STATE_PLAY);
            shortTvVideoItemView.updateShortTvInfo(shortTvVideoItemView.orPlayer, shortTvVideoItemView.orPlayerView, eVar);
            if (eVar != null) {
                shortTvVideoItemView.o0(eVar);
            }
            fs.b.f62582a.d(R$string.short_tv_locked_episode_unlocked);
        } else {
            ss.b.f75981a.l(subject, i11, "cancel", "", "0", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
        if (appCompatTextView != null) {
            appCompatTextView.setEnabled(true);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if (r2 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void g0() {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.widget.ShortTvVideoItemView.g0():void");
    }

    private final void h0() {
        float f11 = com.transsion.shorttv.utils.h.f53707a.d().getFloat("k_short_tv_speed", 1.0f);
        int i11 = (int) f11;
        String valueOf = ((float) i11) == f11 ? String.valueOf(i11) : String.valueOf(f11);
        this.viewBinding.E.setText(valueOf + "x");
        com.transsion.player.orplayer.g gVar = this.orPlayer;
        if (gVar != null) {
            gVar.setSpeed(f11);
        }
        a.C0856a.f(lg.a.f68962a, this.TAG, "initVideoSpeed, speed:" + f11, false, 4, null);
    }

    private final boolean i0() {
        return !j0();
    }

    private final boolean j0() {
        LiveData H0;
        zr.b bVar = zr.b.f79574a;
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        Subject subject = (shortTvViewModel == null || (H0 = shortTvViewModel.H0()) == null) ? null : (Subject) H0.f();
        js.e eVar = this.data;
        return bVar.c(subject, eVar != null ? eVar.d() : null);
    }

    private final void k0(js.e item) {
        final ShortTvPlayerOverlayAdContainer adOverlayContainerView = this.viewBinding.f69960b;
        Intrinsics.g(adOverlayContainerView, "adOverlayContainerView");
        adOverlayContainerView.setVisibility(8);
        if (j0()) {
            ur.a.e(ur.a.f77012a, "overlay", "loadAd, this video is locked, don't load", null, 4, null);
            return;
        }
        final com.transsion.shorttv.ad.playeroverlayad.a c11 = ShortTvPlayerOverlayAdManager.f52770a.c(item.a());
        if (c11 == null) {
            return;
        }
        if (!c11.d()) {
            ur.a.c(ur.a.f77012a, "overlay", "loadAd, this video no need to load, key=" + item.a(), null, 4, null);
            return;
        }
        c11.i(true);
        ur.a aVar = ur.a.f77012a;
        ur.a.g(aVar, "overlay", "loadAd, adLoadState=" + c11.c(), null, 4, null);
        switch (a.f53593b[c11.c().ordinal()]) {
            case 1:
                c11.g(AdLoadState.LOADING);
                com.transsion.shorttv.ad.playeroverlayad.e b11 = c11.b();
                if (b11 != null) {
                    b11.i(new Function1() { // from class: com.transsion.shorttv.ui.widget.x
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit l02;
                            l02 = ShortTvVideoItemView.l0(com.transsion.shorttv.ad.playeroverlayad.a.this, this, adOverlayContainerView, ((Boolean) obj).booleanValue());
                            return l02;
                        }
                    });
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
                return;
            case 6:
                if (j0()) {
                    ur.a.e(aVar, "overlay", "show cached ad, video is locked, skip show", null, 4, null);
                    return;
                }
                com.transsion.shorttv.ad.playeroverlayad.e b12 = c11.b();
                if (b12 != null) {
                    b12.k(adOverlayContainerView, new Function0() { // from class: com.transsion.shorttv.ui.widget.i0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit n02;
                            n02 = ShortTvVideoItemView.n0(com.transsion.shorttv.ad.playeroverlayad.a.this);
                            return n02;
                        }
                    });
                    return;
                }
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(final com.transsion.shorttv.ad.playeroverlayad.a aVar, ShortTvVideoItemView shortTvVideoItemView, ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer, boolean z10) {
        if (z10) {
            aVar.g(AdLoadState.SUCCEED);
            if (shortTvVideoItemView.j0()) {
                ur.a.e(ur.a.f77012a, "overlay", "loadAd callback, video is now locked, skip show", null, 4, null);
                return Unit.f67184a;
            }
            com.transsion.shorttv.ad.playeroverlayad.e b11 = aVar.b();
            if (b11 != null) {
                b11.k(shortTvPlayerOverlayAdContainer, new Function0() { // from class: com.transsion.shorttv.ui.widget.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit m02;
                        m02 = ShortTvVideoItemView.m0(com.transsion.shorttv.ad.playeroverlayad.a.this);
                        return m02;
                    }
                });
            }
        } else {
            aVar.a();
            aVar.g(AdLoadState.FAILED);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(com.transsion.shorttv.ad.playeroverlayad.a aVar) {
        aVar.a();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(com.transsion.shorttv.ad.playeroverlayad.a aVar) {
        aVar.a();
        return Unit.f67184a;
    }

    private final void o0(js.e item) {
        k0(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(ShortTvVideoItemView shortTvVideoItemView, boolean z10) {
        ShortTvViewModel shortTvViewModel;
        LiveData H0;
        Subject subject;
        List unlockType;
        if (shortTvVideoItemView.isOptimizeEnable) {
            shortTvVideoItemView.Y0(!z10);
        }
        if (!z10) {
            yr.b.b(shortTvVideoItemView.groupContent);
            Group groupPayLockHide = shortTvVideoItemView.viewBinding.f69967i;
            Intrinsics.g(groupPayLockHide, "groupPayLockHide");
            yr.b.b(groupPayLockHide);
            LinearLayout llCtr = shortTvVideoItemView.viewBinding.f69974p;
            Intrinsics.g(llCtr, "llCtr");
            yr.b.b(llCtr);
            com.transsion.shorttv.ui.widget.c cVar = shortTvVideoItemView.downloadGuideBubbleController;
            if (cVar != null) {
                cVar.f();
            }
            if (shortTvVideoItemView.isOptimizeEnable) {
                ProgressBar progressBar = shortTvVideoItemView.viewBinding.f69977s;
                Intrinsics.g(progressBar, "progressBar");
                yr.b.b(progressBar);
            }
            shortTvVideoItemView.Y();
            return;
        }
        yr.b.e(shortTvVideoItemView.groupContent);
        Group groupPayLockHide2 = shortTvVideoItemView.viewBinding.f69967i;
        Intrinsics.g(groupPayLockHide2, "groupPayLockHide");
        yr.b.e(groupPayLockHide2);
        LinearLayout llCtr2 = shortTvVideoItemView.viewBinding.f69974p;
        Intrinsics.g(llCtr2, "llCtr");
        yr.b.e(llCtr2);
        if (shortTvVideoItemView.isEpisodeLocked && (shortTvViewModel = shortTvVideoItemView.mShortTvViewModel) != null && (H0 = shortTvViewModel.H0()) != null && (subject = (Subject) H0.f()) != null && (unlockType = subject.getUnlockType()) != null && unlockType.contains(1)) {
            Group groupPayLockHide3 = shortTvVideoItemView.viewBinding.f69967i;
            Intrinsics.g(groupPayLockHide3, "groupPayLockHide");
            yr.b.b(groupPayLockHide3);
        }
        if (shortTvVideoItemView.isOptimizeEnable) {
            ProgressBar progressBar2 = shortTvVideoItemView.viewBinding.f69977s;
            Intrinsics.g(progressBar2, "progressBar");
            yr.b.e(progressBar2);
        }
        shortTvVideoItemView.Q0();
    }

    private final void q0() {
        List<DubsInfo> dubs;
        LiveData Z;
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_no_network_toast));
            return;
        }
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        DubsInfoData dubsInfoData = (shortTvViewModel == null || (Z = shortTvViewModel.Z()) == null) ? null : (DubsInfoData) Z.f();
        if (dubsInfoData == null || (dubs = dubsInfoData.getDubs()) == null || dubs.isEmpty()) {
            fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_no_error_content));
            return;
        }
        ShortTvLanguageSelectDialog shortTvLanguageSelectDialog = new ShortTvLanguageSelectDialog();
        shortTvLanguageSelectDialog.D0(1);
        shortTvLanguageSelectDialog.C0(new Function1() { // from class: com.transsion.shorttv.ui.widget.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r02;
                r02 = ShortTvVideoItemView.r0(ShortTvVideoItemView.this, (DubsInfo) obj);
                return r02;
            }
        });
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment != null) {
            shortTvLanguageSelectDialog.j0(shortTvDetailListFragment, "ShortTvLanguageSelectDialog_Audio");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(ShortTvVideoItemView shortTvVideoItemView, DubsInfo item) {
        Intrinsics.h(item, "item");
        shortTvVideoItemView.s0(item);
        return Unit.f67184a;
    }

    private final void s0(DubsInfo info) {
        androidx.view.b0 X;
        ShortTvViewModel shortTvViewModel;
        ShortTVItem shortTVItem;
        Video video;
        String url;
        ShortTVItem d11;
        Map a11;
        ShortTVItem d12;
        androidx.view.b0 X2;
        ConcurrentHashMap u02;
        androidx.view.b0 b0Var;
        List list;
        Object obj;
        ConcurrentHashMap u03;
        LiveData H0;
        Subject subject;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.TAG, "onAudioTrackSelect, lanName:" + info.getLanName() + ", subjectId:" + info.getSubjectId(), false, 4, null);
        ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
        String subjectId = (shortTvViewModel2 == null || (H0 = shortTvViewModel2.H0()) == null || (subject = (Subject) H0.f()) == null) ? null : subject.getSubjectId();
        if (subjectId != null && info.getSubjectId() != null) {
            com.transsion.shorttv.utils.h.f53707a.d().putString("k_audio_subject_" + subjectId, info.getSubjectId());
        }
        ShortTvViewModel shortTvViewModel3 = this.mShortTvViewModel;
        if (shortTvViewModel3 != null) {
            shortTvViewModel3.f1(info.getSubjectId());
        }
        ShortTvViewModel shortTvViewModel4 = this.mShortTvViewModel;
        if ((shortTvViewModel4 == null || (u03 = shortTvViewModel4.u0()) == null) ? false : u03.containsKey(info.getSubjectId())) {
            ShortTvViewModel shortTvViewModel5 = this.mShortTvViewModel;
            if (shortTvViewModel5 == null || (u02 = shortTvViewModel5.u0()) == null || (b0Var = (androidx.view.b0) u02.get(info.getSubjectId())) == null || (list = (List) b0Var.f()) == null) {
                shortTVItem = null;
            } else {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    ShortTVItem shortTVItem2 = (ShortTVItem) obj;
                    js.e eVar = this.data;
                    if (eVar != null && shortTVItem2.getEp() == eVar.c()) {
                        break;
                    }
                }
                shortTVItem = (ShortTVItem) obj;
            }
            if (shortTVItem == null) {
                a.C0856a.f(lg.a.f68962a, this.TAG, "onAudioTrackSelect, 有该作品信息，没有该集信息，需要请求", false, 4, null);
                String subjectId2 = info.getSubjectId();
                if (subjectId2 != null) {
                    ShortTvViewModel shortTvViewModel6 = this.mShortTvViewModel;
                    if (shortTvViewModel6 != null && (X2 = shortTvViewModel6.X()) != null) {
                        X2.q(Boolean.TRUE);
                    }
                    ShortTvViewModel shortTvViewModel7 = this.mShortTvViewModel;
                    if (shortTvViewModel7 != null) {
                        js.e eVar2 = this.data;
                        shortTvViewModel7.v0(subjectId2, null, eVar2 != null ? eVar2.c() : 1, false);
                    }
                    ShortTvViewModel shortTvViewModel8 = this.mShortTvViewModel;
                    if (shortTvViewModel8 != null) {
                        js.e eVar3 = this.data;
                        shortTvViewModel8.w0(subjectId2, eVar3 != null ? eVar3.c() : 1);
                    }
                }
            } else {
                a.C0856a c0856a2 = lg.a.f68962a;
                a.C0856a.f(c0856a2, this.TAG, "onAudioTrackSelect, 有该作品信息，直接播放", false, 4, null);
                Media video2 = shortTVItem.getVideo();
                if (video2 != null && (video = video2.getVideo()) != null && (url = video.getUrl()) != null) {
                    js.e eVar4 = this.data;
                    ao.e eVar5 = new ao.e(url, url, (eVar4 == null || (d12 = eVar4.d()) == null) ? 0 : d12.getEp(), null, null, 24, null);
                    com.transsion.player.orplayer.g gVar = this.orPlayer;
                    lo.f fVar = gVar instanceof lo.f ? (lo.f) gVar : null;
                    boolean containsKey = (fVar == null || (a11 = fVar.a()) == null) ? false : a11.containsKey(eVar5.e());
                    String str = this.TAG;
                    js.e eVar6 = this.data;
                    a.C0856a.f(c0856a2, str, "onAudioTrackSelect, url:" + url + ",EP:" + ((eVar6 == null || (d11 = eVar6.d()) == null) ? null : Integer.valueOf(d11.getEp())) + ",inList:" + containsKey, false, 4, null);
                    if (!containsKey) {
                        com.transsion.player.orplayer.g gVar2 = this.orPlayer;
                        if (gVar2 != null) {
                            gVar2.addDataSource(eVar5);
                        }
                        com.transsion.player.orplayer.g gVar3 = this.orPlayer;
                        if (gVar3 != null) {
                            gVar3.prepare();
                        }
                    }
                    ShortTvViewModel shortTvViewModel9 = this.mShortTvViewModel;
                    if (shortTvViewModel9 != null) {
                        shortTvViewModel9.e1(true);
                    }
                    com.transsion.player.orplayer.g gVar4 = this.orPlayer;
                    if (gVar4 != null) {
                        String e11 = eVar5.e();
                        if (e11 == null) {
                            e11 = "";
                        }
                        gVar4.seekTo(e11, 0L);
                    }
                    post(new Runnable() { // from class: com.transsion.shorttv.ui.widget.p0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ShortTvVideoItemView.t0(ShortTvVideoItemView.this);
                        }
                    });
                }
                onAudioTrackChange();
            }
        } else {
            a.C0856a.f(c0856a, this.TAG, "onAudioTrackSelect, 没有该作品信息，需要重新请求", false, 4, null);
            String subjectId3 = info.getSubjectId();
            if (subjectId3 != null) {
                ShortTvViewModel shortTvViewModel10 = this.mShortTvViewModel;
                if (shortTvViewModel10 != null && (X = shortTvViewModel10.X()) != null) {
                    X.q(Boolean.TRUE);
                }
                ShortTvViewModel shortTvViewModel11 = this.mShortTvViewModel;
                if (shortTvViewModel11 != null) {
                    js.e eVar7 = this.data;
                    shortTvViewModel11.v0(subjectId3, null, eVar7 != null ? eVar7.c() : 1, false);
                }
                ShortTvViewModel shortTvViewModel12 = this.mShortTvViewModel;
                if (shortTvViewModel12 != null) {
                    js.e eVar8 = this.data;
                    shortTvViewModel12.w0(subjectId3, eVar8 != null ? eVar8.c() : 1);
                }
            }
        }
        String subjectId4 = info.getSubjectId();
        if (subjectId4 == null || (shortTvViewModel = this.mShortTvViewModel) == null) {
            return;
        }
        js.e eVar9 = this.data;
        int c11 = eVar9 != null ? eVar9.c() : 0;
        com.transsion.player.orplayer.g gVar5 = this.orPlayer;
        shortTvViewModel.U0(subjectId4, c11, gVar5 instanceof lo.f ? (lo.f) gVar5 : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLoading(boolean show) {
        this.isLoading = show;
        if (show) {
            ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
            Intrinsics.f(shortTvDetailListFragment, "null cannot be cast to non-null type com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment");
            shortTvDetailListFragment.startLoading();
        } else {
            ShortTvDetailListFragment shortTvDetailListFragment2 = this.fragment;
            Intrinsics.f(shortTvDetailListFragment2, "null cannot be cast to non-null type com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment");
            shortTvDetailListFragment2.hideLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ShortTvVideoItemView shortTvVideoItemView) {
        ShortTvViewModel shortTvViewModel = shortTvVideoItemView.mShortTvViewModel;
        if (shortTvViewModel != null) {
            shortTvViewModel.e1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ShortTvVideoItemView shortTvVideoItemView, SubtitleDownloadTable subtitleDownloadTable) {
        SubtitleDownloadTable a11;
        ts.b bVar = shortTvVideoItemView.subDownloadBean;
        if (bVar != null) {
            if (Intrinsics.c((bVar == null || (a11 = bVar.a()) == null) ? null : a11.getLan(), subtitleDownloadTable.getLan())) {
                a.C0856a.f(lg.a.f68962a, shortTvVideoItemView.TAG, "内置字幕点击下载成功，name = " + subtitleDownloadTable.getName() + ", videoResourceId = " + subtitleDownloadTable.getResourceId() + ", download subtitleName = " + subtitleDownloadTable.getName() + ", lan = " + subtitleDownloadTable.getLan() + "， status:" + subtitleDownloadTable.getStatus() + "~", false, 4, null);
                ts.b bVar2 = shortTvVideoItemView.subDownloadBean;
                Intrinsics.e(bVar2);
                shortTvVideoItemView.G0(bVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        if (this.isEpisodeLocked) {
            return;
        }
        if (this.isLoading) {
            AppCompatImageView ivDownload = this.viewBinding.f69970l;
            Intrinsics.g(ivDownload, "ivDownload");
            if (ivDownload.getVisibility() == 0) {
                X();
                return;
            } else {
                P0();
                return;
            }
        }
        com.transsion.player.orplayer.g gVar = this.orPlayer;
        if (gVar == null || !gVar.isPlaying()) {
            AppCompatImageView ivDownload2 = this.viewBinding.f69970l;
            Intrinsics.g(ivDownload2, "ivDownload");
            if (ivDownload2.getVisibility() != 0) {
                P0();
            }
            ss.c cVar = this.dotLayer;
            if (cVar != null) {
                cVar.c();
            }
            H0();
            this.isClickPause = false;
            ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
            if (shortTvDetailListFragment != null) {
                shortTvDetailListFragment.m1(false);
                return;
            }
            return;
        }
        AppCompatImageView ivDownload3 = this.viewBinding.f69970l;
        Intrinsics.g(ivDownload3, "ivDownload");
        if (ivDownload3.getVisibility() != 0) {
            P0();
            L();
            return;
        }
        this.isClickPause = true;
        ShortTvDetailListFragment shortTvDetailListFragment2 = this.fragment;
        if (shortTvDetailListFragment2 != null) {
            shortTvDetailListFragment2.m1(true);
        }
        ss.c cVar2 = this.dotLayer;
        if (cVar2 != null) {
            cVar2.b();
        }
        com.transsion.player.orplayer.g gVar2 = this.orPlayer;
        if (gVar2 != null) {
            gVar2.pause();
        }
        P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(ShortTvVideoItemView shortTvVideoItemView, SubtitleDownloadTable subtitleDownloadTable) {
        ts.b bVar = shortTvVideoItemView.subDownloadBean;
        if (bVar != null) {
            bVar.e(subtitleDownloadTable);
        }
        a.C0856a.f(lg.a.f68962a, shortTvVideoItemView.TAG, ShortTvVideoItemView.class.getSimpleName() + " --> onFail() --> 内置字幕点击下载失败TnT，name = " + subtitleDownloadTable.getName() + ", videoResourceId = " + subtitleDownloadTable.getResourceId() + ", download subtitleName = " + subtitleDownloadTable.getName() + ", lan = " + subtitleDownloadTable.getLan() + "， status:" + subtitleDownloadTable.getStatus() + "~", false, 4, null);
    }

    public static /* synthetic */ void watchAdToUnlock$shortTvLib_release$default(ShortTvVideoItemView shortTvVideoItemView, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        shortTvVideoItemView.watchAdToUnlock$shortTvLib_release(z10);
    }

    private final void x0() {
        List<DubsInfo> dubs;
        List list;
        androidx.view.b0 d11;
        LiveData Z;
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_no_network_toast));
            return;
        }
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        List list2 = null;
        DubsInfoData dubsInfoData = (shortTvViewModel == null || (Z = shortTvViewModel.Z()) == null) ? null : (DubsInfoData) Z.f();
        ws.a aVar = this.mShortTvSubViewModel;
        if (aVar != null && (d11 = aVar.d()) != null) {
            list2 = (List) d11.f();
        }
        if (dubsInfoData == null || (((dubs = dubsInfoData.getDubs()) == null || dubs.isEmpty()) && ((list = list2) == null || list.isEmpty()))) {
            fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_no_error_content));
            return;
        }
        ShortTvLanguageSelectDialog shortTvLanguageSelectDialog = new ShortTvLanguageSelectDialog();
        shortTvLanguageSelectDialog.C0(new Function1() { // from class: com.transsion.shorttv.ui.widget.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y02;
                y02 = ShortTvVideoItemView.y0(ShortTvVideoItemView.this, (DubsInfo) obj);
                return y02;
            }
        });
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment != null) {
            shortTvLanguageSelectDialog.j0(shortTvDetailListFragment, "ShortTvLanguageSelectDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(ShortTvVideoItemView shortTvVideoItemView, DubsInfo item) {
        Intrinsics.h(item, "item");
        if (item.getIsSubtitle()) {
            ts.b subInfo = item.getSubInfo();
            if (subInfo != null) {
                shortTvVideoItemView.viewBinding.A.setText(subInfo.a().getLanName());
                shortTvVideoItemView.G0(subInfo);
            }
        } else {
            shortTvVideoItemView.viewBinding.A.setText(item.getLanName());
            shortTvVideoItemView.s0(item);
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if (r2 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void z0() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.widget.ShortTvVideoItemView.z0():void");
    }

    public void app2Background() {
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            cVar.e(i0(), true);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    public final a1 getCountdownController() {
        return this.countdownController;
    }

    public FrameLayout getPlayerContainer() {
        FrameLayout flContainer = this.viewBinding.f69963e;
        Intrinsics.g(flContainer, "flContainer");
        return flContainer;
    }

    @Override // com.transsion.shorttv.ui.widget.d
    public long getProgress() {
        return this.viewBinding.f69979u.getProgress();
    }

    public ShortTvViewModel getViewModel(FragmentActivity activity) {
        Intrinsics.h(activity, "activity");
        return (ShortTvViewModel) new androidx.view.v0(activity).a(ShortTvViewModel.class);
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
    }

    /* renamed from: isFirstPlayInSession, reason: from getter */
    public final boolean getIsFirstPlayInSession() {
        return this.isFirstPlayInSession;
    }

    @Override // com.transsion.player.orplayer.f
    public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
        f.a.c(this, eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        androidx.view.u viewLifecycleOwner;
        LiveData e02;
        LiveData e03;
        LiveData d02;
        super.onAttachedToWindow();
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment == null || (viewLifecycleOwner = shortTvDetailListFragment.getViewLifecycleOwner()) == null) {
            return;
        }
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        if (shortTvViewModel != null && (d02 = shortTvViewModel.d0()) != null) {
            d02.j(viewLifecycleOwner, this.favoriteObserver);
        }
        d dVar = this.favoriteResultObserver;
        ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
        dVar.b((shortTvViewModel2 == null || (e03 = shortTvViewModel2.e0()) == null) ? null : (js.f) e03.f());
        ShortTvViewModel shortTvViewModel3 = this.mShortTvViewModel;
        if (shortTvViewModel3 == null || (e02 = shortTvViewModel3.e0()) == null) {
            return;
        }
        e02.j(viewLifecycleOwner, this.favoriteResultObserver);
    }

    @Override // com.transsion.shorttv.ui.widget.d
    public void onAudioTrackChange() {
        a.C0856a.f(lg.a.f68962a, this.TAG, "onAudioTrackChange initResolution", false, 4, null);
        g0();
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        f.a.d(this, j11, eVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v11) {
        FragmentActivity activity;
        LiveData H0;
        Subject subject;
        ShortTvDetailListFragment shortTvDetailListFragment;
        FragmentActivity activity2;
        LiveData H02;
        Subject subject2;
        String str;
        if (ds.d.f61551a.a(v11 != null ? v11.getId() : 0, 500L)) {
            return;
        }
        if (this.isEpisodeLocked) {
            S0();
        }
        a.C0856a.f(lg.a.f68962a, this.TAG, "onclick, " + v11, false, 4, null);
        Integer valueOf = v11 != null ? Integer.valueOf(v11.getId()) : null;
        int i11 = R$id.tv_episode;
        if (valueOf != null && valueOf.intValue() == i11) {
            showEpisodeListDialog();
            return;
        }
        int i12 = R$id.tv_favorite;
        if (valueOf != null && valueOf.intValue() == i12) {
            ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
            if (shortTvViewModel == null || (H02 = shortTvViewModel.H0()) == null || (subject2 = (Subject) H02.f()) == null) {
                return;
            }
            if (!nh.m.f70597a.e()) {
                O0();
                return;
            }
            if (this.data != null) {
                ss.b bVar = ss.b.f75981a;
                String subjectId = subject2.getSubjectId();
                String ops = subject2.getOps();
                ShortTVFavInfo shortTVFavInfo = subject2.getShortTVFavInfo();
                boolean hasFavorite = shortTVFavInfo != null ? shortTVFavInfo.getHasFavorite() : false;
                ShortTvDetailListFragment shortTvDetailListFragment2 = this.fragment;
                if (shortTvDetailListFragment2 == null || (str = shortTvDetailListFragment2.getPageName()) == null) {
                    str = "";
                }
                ss.b.g(bVar, subjectId, ops, "", hasFavorite, str, null, 32, null);
            }
            ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
            if (shortTvViewModel2 != null) {
                shortTvViewModel2.P(subject2);
                return;
            }
            return;
        }
        int i13 = R$id.iv_play_status;
        if (valueOf != null && valueOf.intValue() == i13) {
            v0();
            return;
        }
        int i14 = R$id.iv_share;
        if (valueOf != null && valueOf.intValue() == i14) {
            B0(v11);
            return;
        }
        int i15 = R$id.iv_download;
        if (valueOf == null || valueOf.intValue() != i15) {
            int i16 = R$id.iv_short_cover;
            if (valueOf == null || valueOf.intValue() != i16) {
                int i17 = R$id.tv_name;
                if (valueOf == null || valueOf.intValue() != i17) {
                    int i18 = R$id.iv_back;
                    if (valueOf != null && valueOf.intValue() == i18) {
                        ShortTvDetailListFragment shortTvDetailListFragment3 = this.fragment;
                        if (shortTvDetailListFragment3 == null || (activity = shortTvDetailListFragment3.getActivity()) == null) {
                            return;
                        }
                        activity.finish();
                        return;
                    }
                    int i19 = R$id.tv_language;
                    if (valueOf != null && valueOf.intValue() == i19) {
                        if (this.viewBinding.A.isSelected()) {
                            x0();
                            return;
                        } else {
                            fs.b.f62582a.d(R$string.short_tv_no_language_toast);
                            return;
                        }
                    }
                    int i20 = R$id.tv_audio;
                    if (valueOf != null && valueOf.intValue() == i20) {
                        q0();
                        return;
                    }
                    int i21 = R$id.tv_subtitles;
                    if (valueOf != null && valueOf.intValue() == i21) {
                        E0();
                        return;
                    }
                    int i22 = R$id.tv_resolution;
                    if (valueOf != null && valueOf.intValue() == i22) {
                        z0();
                        return;
                    }
                    int i23 = R$id.tv_speed;
                    if (valueOf != null && valueOf.intValue() == i23) {
                        C0();
                        return;
                    }
                    return;
                }
            }
        }
        com.transsion.shorttv.ui.widget.c cVar = this.downloadGuideBubbleController;
        if (cVar != null) {
            cVar.f();
        }
        ShortTvViewModel shortTvViewModel3 = this.mShortTvViewModel;
        if (shortTvViewModel3 == null || (H0 = shortTvViewModel3.H0()) == null || (subject = (Subject) H0.f()) == null || (shortTvDetailListFragment = this.fragment) == null || (activity2 = shortTvDetailListFragment.getActivity()) == null) {
            return;
        }
        js.e eVar = this.data;
        int c11 = eVar != null ? eVar.c() : 0;
        ss.b.f75981a.c(subject, c11, subject.getNeedPaid() == 0, !j0(), zr.b.f79574a.b(subject, c11));
        ns.a aVar = ns.a.f70665a;
        ShortTvDetailListFragment shortTvDetailListFragment4 = this.fragment;
        aVar.a(activity2, shortTvDetailListFragment4 != null ? shortTvDetailListFragment4.getPageName() : null, subject.getOps(), (r21 & 8) != 0 ? null : "download_subject", (r21 & 16) != 0 ? false : v11.getId() == R$id.iv_download, (r21 & 32) != 0 ? null : subject, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? Boolean.FALSE : Boolean.valueOf(v11.getId() != R$id.iv_download));
    }

    @Override // com.transsion.subtitle_download.a
    public void onComplete(final SubtitleDownloadTable stDownloadTable) {
        Intrinsics.h(stDownloadTable, "stDownloadTable");
        this.hasSubDownloading = false;
        ThreadUtils.k(new Runnable() { // from class: com.transsion.shorttv.ui.widget.w0
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvVideoItemView.u0(ShortTvVideoItemView.this, stDownloadTable);
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e mediaSource) {
        a.C0856a.r(lg.a.f68962a, this.TAG, new String[]{"onCompletion， play next"}, false, 4, null);
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            f.a.f(cVar, null, 1, null);
        }
        V0(0L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        LiveData e02;
        LiveData d02;
        super.onDetachedFromWindow();
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        if (shortTvViewModel != null && (d02 = shortTvViewModel.d0()) != null) {
            d02.o(this.favoriteObserver);
        }
        this.autoHideRightMenuHandle.removeCallbacksAndMessages(null);
        com.transsion.shorttv.ui.widget.c cVar = this.downloadGuideBubbleController;
        if (cVar != null) {
            cVar.c();
        }
        S0();
        STCommonVideoAdHelper sTCommonVideoAdHelper = this.videoAdHelper;
        if (sTCommonVideoAdHelper != null) {
            STCommonVideoAdHelper.q(sTCommonVideoAdHelper, 0, 1, null);
        }
        this.videoAdHelper = null;
        V();
        ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
        if (shortTvViewModel2 != null && (e02 = shortTvViewModel2.e0()) != null) {
            e02.o(this.favoriteResultObserver);
        }
        ShortTvViewModel shortTvViewModel3 = this.mShortTvViewModel;
        if (shortTvViewModel3 != null) {
            shortTvViewModel3.N();
        }
        com.transsion.shorttv.subtitle.manager.b.f53144a.b().c(this);
        com.transsion.shorttv.subtitle.a aVar = this.subtitleControl;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    @Override // com.transsion.subtitle_download.a
    public void onDownloading(int progress, SubtitleDownloadTable stDownloadTable) {
        Intrinsics.h(stDownloadTable, "stDownloadTable");
    }

    @Override // com.transsion.subtitle_download.a
    public void onFail(Exception e11, final SubtitleDownloadTable dbBean) {
        Intrinsics.h(e11, "e");
        Intrinsics.h(dbBean, "dbBean");
        this.hasSubDownloading = false;
        ThreadUtils.k(new Runnable() { // from class: com.transsion.shorttv.ui.widget.x0
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvVideoItemView.w0(ShortTvVideoItemView.this, dbBean);
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        f.a.g(this, z10);
    }

    @Override // com.transsion.shorttv.ui.widget.d
    public void onGetDubsInfo() {
        b0();
    }

    @Override // com.transsion.player.orplayer.f
    public void onIsPlayingChanged(boolean z10) {
        f.a.h(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingBegin(ao.e mediaSource) {
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            f.a.j(cVar, null, 1, null);
        }
        setLoading(true);
        com.transsion.shorttv.ui.widget.c cVar2 = this.downloadGuideBubbleController;
        if (cVar2 != null) {
            cVar2.i();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(ao.e mediaSource) {
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            f.a.l(cVar, null, 1, null);
        }
        setLoading(false);
        removeCallbacks(this.delayToastNetErrRunnable);
        com.transsion.shorttv.ui.widget.c cVar2 = this.downloadGuideBubbleController;
        if (cVar2 != null) {
            cVar2.h();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, ao.e eVar) {
        f.a.m(this, i11, f11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
    }

    public final void onMediaItemTransition() {
        a.C0856a.f(lg.a.f68962a, this.TAG, "onMediaItemTransition: " + this.viewBinding.f69977s.getMax() + "  : " + this, false, 4, null);
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            f.a.f(cVar, null, 1, null);
        }
        reset();
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    public final void onNetConnect() {
        a.C0856a.f(lg.a.f68962a, "ORSubtitle_v", "onNetConnect, 网络恢复，检测字幕", false, 4, null);
        com.transsion.shorttv.subtitle.a aVar = this.subtitleControl;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.transsion.shorttv.ui.widget.d
    public void onPageRelease(int position) {
        LiveData G0;
        js.e eVar = this.data;
        if (eVar != null) {
            int c11 = eVar.c();
            ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
            if (shortTvViewModel != null) {
                shortTvViewModel.K(c11, getProgress());
            }
        }
        S0();
        this.countdownController = null;
        STCommonVideoAdHelper sTCommonVideoAdHelper = this.videoAdHelper;
        if (sTCommonVideoAdHelper != null) {
            STCommonVideoAdHelper.q(sTCommonVideoAdHelper, 0, 1, null);
        }
        this.videoAdHelper = null;
        onPlayerReset();
        ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
        if (shortTvViewModel2 == null || (G0 = shortTvViewModel2.G0()) == null) {
            return;
        }
        G0.o(this.observer);
    }

    @Override // com.transsion.shorttv.ui.widget.d
    public void onPageSelected(com.transsion.player.orplayer.g orPlayer, ORPlayerView orPlayerView, js.e item) {
        LiveData H0;
        ShortTvViewModel shortTvViewModel;
        LiveData G0;
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment == null || !shortTvDetailListFragment.isAdded() || shortTvDetailListFragment.getView() == null) {
            return;
        }
        com.transsion.shorttv.ui.widget.c cVar = this.downloadGuideBubbleController;
        if (cVar != null) {
            cVar.d();
        }
        androidx.view.u viewLifecycleOwner = shortTvDetailListFragment.getViewLifecycleOwner();
        Intrinsics.g(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
        if (shortTvViewModel2 != null && (G0 = shortTvViewModel2.G0()) != null) {
            G0.j(viewLifecycleOwner, this.observer);
        }
        this.orPlayer = orPlayer;
        this.orPlayerView = orPlayerView;
        ss.c cVar2 = this.dotLayer;
        if (cVar2 != null) {
            cVar2.p(orPlayer);
        }
        ss.c cVar3 = this.dotLayer;
        if (cVar3 != null && orPlayer != null) {
            orPlayer.addPlayerListener(cVar3);
        }
        if (item != null && (shortTvViewModel = this.mShortTvViewModel) != null) {
            shortTvViewModel.d1(item.c());
        }
        updateShortTvInfo(orPlayer, orPlayerView, item);
        b0();
        g0();
        h0();
        P0();
        L();
        if (item != null) {
            o0(item);
        }
        ShortTvViewModel shortTvViewModel3 = this.mShortTvViewModel;
        Subject subject = (shortTvViewModel3 == null || (H0 = shortTvViewModel3.H0()) == null) ? null : (Subject) H0.f();
        js.e eVar = this.data;
        int c11 = eVar != null ? eVar.c() : 0;
        ss.b.f75981a.k(subject, c11, subject != null && subject.getNeedPaid() == 0, !j0(), zr.b.f79574a.b(subject, c11));
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e mediaSource) {
        Integer errorCode;
        Intrinsics.h(errorInfo, "errorInfo");
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            f.a.r(cVar, errorInfo, null, 2, null);
        }
        lg.a.f68962a.i("i_media", this.TAG + " --> IPlayerListener --> onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + " url:" + (mediaSource != null ? mediaSource.k() : null) + " --> 短播放失败了", true);
        setLoading(false);
        com.transsion.shorttv.ui.widget.c cVar2 = this.downloadGuideBubbleController;
        if (cVar2 != null) {
            cVar2.h();
        }
        Integer errorCode2 = errorInfo.getErrorCode();
        if ((errorCode2 != null && errorCode2.intValue() == 2001) || ((errorCode = errorInfo.getErrorCode()) != null && errorCode.intValue() == 2002)) {
            O0();
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
        com.transsion.player.orplayer.g gVar;
        ShortTvViewModel shortTvViewModel;
        LiveData H0;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.TAG, "player- onPlayerReset data: " + this.data, false, 4, null);
        com.transsion.shorttv.ui.widget.c cVar = this.downloadGuideBubbleController;
        if (cVar != null) {
            cVar.d();
        }
        V();
        com.transsion.shorttv.subtitle.a aVar = this.subtitleControl;
        if (aVar != null) {
            aVar.onDestroy();
        }
        this.subtitleControl = null;
        setKeepScreenOn(false);
        this.isClickPause = false;
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment != null) {
            shortTvDetailListFragment.m1(false);
        }
        this.isFirstFrame = false;
        this.isPrepare = false;
        boolean i02 = i0();
        ss.c cVar2 = this.dotLayer;
        if (cVar2 != null) {
            cVar2.e(i02, false);
        }
        if (i02 && (shortTvViewModel = this.mShortTvViewModel) != null) {
            shortTvViewModel.s1((shortTvViewModel == null || (H0 = shortTvViewModel.H0()) == null) ? null : (Subject) H0.f(), this.data, this.viewBinding.f69979u.getProgress());
        }
        AppCompatImageView ivCover = this.viewBinding.f69969k;
        Intrinsics.g(ivCover, "ivCover");
        yr.b.e(ivCover);
        a.C0856a.f(c0856a, this.TAG, "onPlayerReset   visible  " + this, false, 4, null);
        AppCompatImageView ivPlayStatus = this.viewBinding.f69971m;
        Intrinsics.g(ivPlayStatus, "ivPlayStatus");
        yr.b.b(ivPlayStatus);
        com.transsion.player.orplayer.g gVar2 = this.orPlayer;
        if (gVar2 != null) {
            gVar2.removePlayerListener(this);
        }
        ss.c cVar3 = this.dotLayer;
        if (cVar3 != null && (gVar = this.orPlayer) != null) {
            gVar.removePlayerListener(cVar3);
        }
        this.orPlayer = null;
        this.orPlayerView = null;
        this.pagerLayoutManager = null;
        this.currentSaveProgress = 0L;
        V0(0L);
        W0(100L);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e mediaSource) {
        ShortTvDetailListFragment shortTvDetailListFragment;
        LiveData f02;
        ShortTvInnerPlayBean shortTvInnerPlayBean;
        js.e eVar;
        ShortTVItem d11;
        if (this.isPrepare) {
            return;
        }
        this.isPrepare = true;
        com.transsion.player.orplayer.g gVar = this.orPlayer;
        long duration = gVar != null ? gVar.getDuration() : 0L;
        W0(duration);
        if (duration / 1000 >= 30) {
            ShortTvVideoProgressDragGestureView vProgressGesture = this.viewBinding.J;
            Intrinsics.g(vProgressGesture, "vProgressGesture");
            yr.b.e(vProgressGesture);
        } else {
            ShortTvVideoProgressDragGestureView vProgressGesture2 = this.viewBinding.J;
            Intrinsics.g(vProgressGesture2, "vProgressGesture");
            yr.b.b(vProgressGesture2);
        }
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        if (shortTvViewModel != null && (f02 = shortTvViewModel.f0()) != null && (shortTvInnerPlayBean = (ShortTvInnerPlayBean) f02.f()) != null && (eVar = this.data) != null && (d11 = eVar.d()) != null && shortTvInnerPlayBean.getEp() == d11.getEp()) {
            long progress = shortTvInnerPlayBean.getProgress();
            a.C0856a.f(lg.a.f68962a, this.TAG, "player- onPrepare, duration = " + this.viewBinding.f69979u.getProgress() + ", progress = " + progress + "  this = " + this, false, 4, null);
            if (progress > 0) {
                this.currentSaveProgress = progress;
                com.transsion.player.orplayer.g gVar2 = this.orPlayer;
                if (gVar2 != null) {
                    gVar2.seekTo(progress);
                }
            }
            ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
            if (shortTvViewModel2 != null) {
                shortTvViewModel2.O();
            }
        }
        if (!this.isClickPause && !this.isPageHide && (shortTvDetailListFragment = this.fragment) != null && shortTvDetailListFragment.isVisible()) {
            a.C0856a.f(lg.a.f68962a, this.TAG, "player- onPrepare， play~", false, 4, null);
        }
        setKeepScreenOn(true);
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long progress, ao.e mediaSource) {
        LiveData H0;
        com.transsion.player.orplayer.g gVar;
        com.transsion.player.orplayer.g gVar2;
        if (this.isHorizontalDragging) {
            return;
        }
        long max = this.viewBinding.f69979u.getMax();
        if (max <= 0 || max == 100 || (gVar2 = this.orPlayer) == null || max != gVar2.getDuration()) {
            com.transsion.player.orplayer.g gVar3 = this.orPlayer;
            long duration = gVar3 != null ? gVar3.getDuration() : 0L;
            if (duration <= 0) {
                a.C0856a.f(lg.a.f68962a, this.TAG, "onProgress- duration <= 0, return", false, 4, null);
                return;
            }
            W0(duration);
        }
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            f.a.z(cVar, progress, null, 2, null);
        }
        com.transsion.shorttv.subtitle.a aVar = this.subtitleControl;
        if (aVar != null) {
            aVar.d(progress);
        }
        V0(progress);
        setLoading(false);
        if (progress > 0) {
            AppCompatImageView ivCover = this.viewBinding.f69969k;
            Intrinsics.g(ivCover, "ivCover");
            if (ivCover.getVisibility() == 0 && (gVar = this.orPlayer) != null && gVar.isPlaying()) {
                a.C0856a.f(lg.a.f68962a, this.TAG, "onProgress-progress>= cover gone", false, 4, null);
                AppCompatImageView ivCover2 = this.viewBinding.f69969k;
                Intrinsics.g(ivCover2, "ivCover");
                yr.b.b(ivCover2);
            }
        }
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        Subject subject = (shortTvViewModel == null || (H0 = shortTvViewModel.H0()) == null) ? null : (Subject) H0.f();
        if (subject != null && subject.getMiniTvType() == 2 && j0()) {
            long unlockFrom = subject.getUnlockFrom() * 1000;
            if (1 > unlockFrom || unlockFrom > progress) {
                if (unlockFrom > 0) {
                    U0(unlockFrom - progress);
                }
            } else {
                com.transsion.player.orplayer.g gVar4 = this.orPlayer;
                if (gVar4 != null) {
                    gVar4.pause();
                }
                V();
                K0(this.data);
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        a.C0856a c0856a = lg.a.f68962a;
        String str = this.TAG;
        AppCompatImageView ivCover = this.viewBinding.f69969k;
        Intrinsics.g(ivCover, "ivCover");
        a.C0856a.f(c0856a, str, "player-   viewBinding.ivCover.isVisible:" + (ivCover.getVisibility() == 0) + " onRenderFirstFrame" + this, false, 4, null);
        if (!this.isFirstFrame) {
            this.isFirstFrame = true;
            ss.c cVar = this.dotLayer;
            if (cVar != null) {
                cVar.onRenderFirstFrame();
            }
        }
        setLoading(false);
        com.transsion.shorttv.ui.widget.c cVar2 = this.downloadGuideBubbleController;
        if (cVar2 != null) {
            cVar2.h();
        }
        AppCompatImageView ivCover2 = this.viewBinding.f69969k;
        Intrinsics.g(ivCover2, "ivCover");
        yr.b.b(ivCover2);
    }

    @Override // com.transsion.subtitle_download.a
    public void onSaveDownload(SubtitleDownloadTable subtitleDownloadTable) {
        a.C0697a.a(this, subtitleDownloadTable);
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
    }

    @Override // androidx.view.r
    public void onStateChanged(androidx.view.u source, Lifecycle.Event event) {
        com.transsion.player.orplayer.g gVar;
        qs.g z02;
        ShortTvDetailListFragment shortTvDetailListFragment;
        com.transsion.player.orplayer.g gVar2;
        Lifecycle lifecycle;
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        int i11 = a.f53592a[event.ordinal()];
        if (i11 == 1) {
            this.isPageHide = true;
            a.C0856a.f(lg.a.f68962a, this.TAG, "player- onPause", false, 4, null);
            ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
            if ((shortTvViewModel == null || (z02 = shortTvViewModel.z0()) == null || !z02.f(this.orPlayer)) && (gVar = this.orPlayer) != null) {
                gVar.pause();
                return;
            }
            return;
        }
        if (i11 == 2) {
            this.isPageHide = false;
            if (this.isClickPause || (shortTvDetailListFragment = this.fragment) == null || !shortTvDetailListFragment.isVisible()) {
                return;
            }
            a.C0856a.f(lg.a.f68962a, this.TAG, "ON_RESUME", false, 4, null);
            H0();
            return;
        }
        if (i11 != 5) {
            return;
        }
        ShortTvDetailListFragment shortTvDetailListFragment2 = this.fragment;
        if (shortTvDetailListFragment2 != null && (lifecycle = shortTvDetailListFragment2.getLifecycle()) != null) {
            lifecycle.d(this);
        }
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            cVar.h();
        }
        com.transsion.player.orplayer.g gVar3 = this.orPlayer;
        if (gVar3 != null) {
            gVar3.removePlayerListener(this);
        }
        ss.c cVar2 = this.dotLayer;
        if (cVar2 == null || (gVar2 = this.orPlayer) == null) {
            return;
        }
        gVar2.removePlayerListener(cVar2);
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

    @Override // com.transsion.subtitle_download.a
    public void onUnGzZip(SubtitleDownloadTable subtitleDownloadTable) {
        a.C0697a.b(this, subtitleDownloadTable);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoPause(ao.e mediaSource) {
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onVideoPause", false, 4, null);
        if (this.isClickPause) {
            AppCompatImageView ivPlayStatus = this.viewBinding.f69971m;
            Intrinsics.g(ivPlayStatus, "ivPlayStatus");
            ivPlayStatus.setVisibility(0);
        }
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            f.a.G(cVar, null, 1, null);
        }
        com.transsion.shorttv.subtitle.a aVar = this.subtitleControl;
        if (aVar != null) {
            aVar.c(false);
        }
        setKeepScreenOn(false);
        P0();
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int width, int height) {
        this.videoWidth = width;
        this.videoHeight = height;
        Z0(Integer.valueOf(width), Integer.valueOf(height));
        a.C0856a.f(lg.a.f68962a, this.TAG, "onVideoSizeChanged " + this, false, 4, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e mediaSource) {
        a.C0856a.f(lg.a.f68962a, this.TAG, "player- onVideoStart", false, 4, null);
        onPrepare(mediaSource);
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            f.a.J(cVar, null, 1, null);
        }
        AppCompatImageView ivPlayStatus = this.viewBinding.f69971m;
        Intrinsics.g(ivPlayStatus, "ivPlayStatus");
        ivPlayStatus.setVisibility(8);
        com.transsion.shorttv.subtitle.a aVar = this.subtitleControl;
        if (aVar != null) {
            aVar.c(true);
        }
        setLoading(false);
        setKeepScreenOn(true);
        L();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
    }

    public final void reset() {
        ShortTvViewModel shortTvViewModel;
        LiveData H0;
        a.C0856a.f(lg.a.f68962a, this.TAG, "playNewMedia data: " + this.data, false, 4, null);
        setKeepScreenOn(false);
        this.isClickPause = false;
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment != null) {
            shortTvDetailListFragment.m1(false);
        }
        this.isFirstFrame = false;
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            cVar.e(i0(), false);
        }
        if (i0() && (shortTvViewModel = this.mShortTvViewModel) != null) {
            shortTvViewModel.s1((shortTvViewModel == null || (H0 = shortTvViewModel.H0()) == null) ? null : (Subject) H0.f(), this.data, this.viewBinding.f69979u.getProgress());
        }
        AppCompatImageView ivPlayStatus = this.viewBinding.f69971m;
        Intrinsics.g(ivPlayStatus, "ivPlayStatus");
        yr.b.b(ivPlayStatus);
        this.currentSaveProgress = 0L;
        V0(0L);
        W0(100L);
    }

    public final void setCountdownController(a1 a1Var) {
        this.countdownController = a1Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x01f8, code lost:
    
        if (com.blankj.utilcode.util.d.a() > 1) goto L80;
     */
    @Override // com.transsion.shorttv.ui.widget.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setData(js.e r24, com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment r25, java.lang.Integer r26, boolean r27, java.lang.String r28, java.lang.String r29, boolean r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 699
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.widget.ShortTvVideoItemView.setData(js.e, com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment, java.lang.Integer, boolean, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    public final void setFirstPlayInSession(boolean z10) {
        this.isFirstPlayInSession = z10;
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }

    public void setPagerLayoutManager(PagerLayoutManager pagerLayoutManager) {
        Intrinsics.h(pagerLayoutManager, "pagerLayoutManager");
        this.pagerLayoutManager = pagerLayoutManager;
    }

    public final void setVideoUrl(String url) {
        Intrinsics.h(url, "url");
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            cVar.v(url);
        }
    }

    public final void showEpisodeListDialog() {
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        Intrinsics.f(shortTvDetailListFragment, "null cannot be cast to non-null type com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment");
        shortTvDetailListFragment.n1();
    }

    public void updateLockState(js.e item) {
        LiveData H0;
        if (item == null) {
            return;
        }
        if (!j0()) {
            W();
            V();
            return;
        }
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        Subject subject = (shortTvViewModel == null || (H0 = shortTvViewModel.H0()) == null) ? null : (Subject) H0.f();
        if (subject == null || subject.getMiniTvType() != 2 || subject.getUnlockFrom() <= 0) {
            K0(item);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateShortTvInfo(com.transsion.player.orplayer.g r24, com.transsion.player.ui.ORPlayerView r25, js.e r26) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.widget.ShortTvVideoItemView.updateShortTvInfo(com.transsion.player.orplayer.g, com.transsion.player.ui.ORPlayerView, js.e):void");
    }

    public final void updateUnlockCountdownText$shortTvLib_release(Integer remaining) {
        View view = this.lockedView;
        AppCompatTextView appCompatTextView = view != null ? (AppCompatTextView) view.findViewById(R$id.btn_watch_ad_unlock) : null;
        String string = getContext().getString(R$string.short_tv_locked_watch_ad_unlock_static);
        Intrinsics.g(string, "getString(...)");
        if (remaining == null) {
            if (appCompatTextView != null) {
                appCompatTextView.setText(string);
            }
        } else if (appCompatTextView != null) {
            appCompatTextView.setText(string + " · " + remaining + "s");
        }
    }

    public final void videoStartPrepare(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        this.isFirstFrame = false;
        this.pageFrom = pageFrom;
        ss.c cVar = this.dotLayer;
        if (cVar != null) {
            cVar.q(pageFrom);
        }
        ss.c cVar2 = this.dotLayer;
        if (cVar2 != null) {
            cVar2.o("immersive_play");
        }
        ss.c cVar3 = this.dotLayer;
        if (cVar3 != null) {
            cVar3.u(SubjectType.SHORT_TV.getValue());
        }
        ss.c cVar4 = this.dotLayer;
        if (cVar4 != null) {
            js.e eVar = this.data;
            cVar4.m(String.valueOf(eVar != null ? eVar.c() : 0));
        }
        ss.c cVar5 = this.dotLayer;
        if (cVar5 != null) {
            cVar5.g(this, false);
        }
        ss.c cVar6 = this.dotLayer;
        if (cVar6 != null) {
            cVar6.a(0, 0);
        }
        ss.c cVar7 = this.dotLayer;
        if (cVar7 != null) {
            cVar7.s(this.position);
        }
        ss.c cVar8 = this.dotLayer;
        if (cVar8 != null) {
            cVar8.n(this.isFirstPlayInSession);
        }
        setLoading(true);
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        if (shortTvViewModel != null) {
            shortTvViewModel.T0();
        }
    }

    public final void watchAdToUnlock$shortTvLib_release(boolean isAuto) {
        FragmentActivity fragmentActivity;
        LiveData H0;
        LiveData H02;
        ss.b bVar = ss.b.f75981a;
        ShortTvViewModel shortTvViewModel = this.mShortTvViewModel;
        Subject subject = null;
        Subject subject2 = (shortTvViewModel == null || (H02 = shortTvViewModel.H0()) == null) ? null : (Subject) H02.f();
        js.e eVar = this.data;
        bVar.h(subject2, eVar != null ? eVar.c() : 0, "minitv_ad", isAuto ? "auto" : "manual");
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_no_network_toast));
            return;
        }
        ShortTvDetailListFragment shortTvDetailListFragment = this.fragment;
        if (shortTvDetailListFragment != null) {
            if (shortTvDetailListFragment.getView() == null) {
                shortTvDetailListFragment = null;
            }
            if (shortTvDetailListFragment == null) {
                return;
            }
            androidx.view.u viewLifecycleOwner = shortTvDetailListFragment.getViewLifecycleOwner();
            Intrinsics.g(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            LifecycleCoroutineScope a11 = androidx.view.v.a(viewLifecycleOwner);
            ShortTvDetailListFragment shortTvDetailListFragment2 = this.fragment;
            if (shortTvDetailListFragment2 == null || (fragmentActivity = shortTvDetailListFragment2.getActivity()) == null) {
                Context context = getContext();
                fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
                if (fragmentActivity == null) {
                    return;
                }
            }
            final FragmentActivity fragmentActivity2 = fragmentActivity;
            View view = this.lockedView;
            final AppCompatTextView appCompatTextView = view != null ? (AppCompatTextView) view.findViewById(R$id.btn_watch_ad_unlock) : null;
            if (appCompatTextView != null) {
                appCompatTextView.setEnabled(false);
            }
            final js.e eVar2 = this.data;
            STCommonVideoAdHelper sTCommonVideoAdHelper = this.videoAdHelper;
            if (sTCommonVideoAdHelper != null) {
                STCommonVideoAdHelper.q(sTCommonVideoAdHelper, 0, 1, null);
            }
            this.videoAdHelper = new STCommonVideoAdHelper("ShortTvPlayerUnlockPlayScene", a11);
            ShortTvViewModel shortTvViewModel2 = this.mShortTvViewModel;
            if (shortTvViewModel2 != null && (H0 = shortTvViewModel2.H0()) != null) {
                subject = (Subject) H0.f();
            }
            final Subject subject3 = subject;
            js.e eVar3 = this.data;
            final int c11 = eVar3 != null ? eVar3.c() : 0;
            STCommonVideoAdHelper sTCommonVideoAdHelper2 = this.videoAdHelper;
            if (sTCommonVideoAdHelper2 != null) {
                sTCommonVideoAdHelper2.t(new Function3() { // from class: com.transsion.shorttv.ui.widget.u0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit c12;
                        c12 = ShortTvVideoItemView.c1(ShortTvVideoItemView.this, fragmentActivity2, subject3, c11, appCompatTextView, eVar2, ((Boolean) obj).booleanValue(), (String) obj2, (String) obj3);
                        return c12;
                    }
                });
            }
        }
    }
}
