package com.transsion.subroom.activity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.C0078;
import androidx.core.C0079;
import androidx.core.app.NotificationCompat;
import androidx.core.appcompat.C0066;
import androidx.fragment.app.Fragment;
import androidx.view.t0;
import androidx.view.v0;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.BottomTabItem;
import com.transsion.home.fragment.home.HomeFragment;
import com.transsion.memberapi.IMemberApi;
import com.transsion.pushapi.NoticePermissionFrom;
import com.transsion.subroom.premium.C0672;
import com.transsion.subroom.premium.C0673;
import com.transsion.subroom.premium.C0675;
import com.transsion.subroom.premium.C0678;
import com.transsion.subroom.premium.C0679;
import com.transsion.subroom.premium.C0680;
import com.transsion.subroom.premium.C0684;
import com.transsion.subroom.premium.C0686;
import com.transsion.subroom.premium.C0687;
import com.transsion.subroom.premium.C0688;
import com.transsion.subroom.premium.C0689;
import com.transsion.subroom.premium.C0690;
import com.transsion.subroom.premium.C0691;
import com.transsnet.loginapi.ILoginApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import gt.md.C0799;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j0;
import lg.a;
import ox.e;

@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006*\u0002\u0080\u0002\u0018\u0000 \u0084\u00022\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002§\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u0006J\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0014¢\u0006\u0004\b \u0010\u0006J\u0011\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH\u0016¢\u0006\u0004\b&\u0010'J)\u0010+\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b+\u0010,J/\u00102\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00132\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0-2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0007H\u0014¢\u0006\u0004\b5\u0010\u000bJ\u0019\u00108\u001a\u00020\u000e2\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u0010\u0010J\r\u0010;\u001a\u00020\t¢\u0006\u0004\b;\u0010\u0006J\u000f\u0010<\u001a\u00020\tH\u0016¢\u0006\u0004\b<\u0010\u0006J\u000f\u0010=\u001a\u00020\u000eH\u0016¢\u0006\u0004\b=\u0010\u0010J'\u0010B\u001a\u00020\t2\u0006\u0010>\u001a\u00020.2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020?H\u0016¢\u0006\u0004\bB\u0010CJ4\u0010I\u001a\u00020\t2#\u0010H\u001a\u001f\u0012\u0013\u0012\u00110.¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\t\u0018\u00010DH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0013H\u0016¢\u0006\u0004\bK\u0010\u0015J\u000f\u0010L\u001a\u00020\u000eH\u0016¢\u0006\u0004\bL\u0010\u0010J\u000f\u0010M\u001a\u00020\tH\u0002¢\u0006\u0004\bM\u0010\u0006J\u000f\u0010N\u001a\u00020\tH\u0002¢\u0006\u0004\bN\u0010\u0006J\u000f\u0010O\u001a\u00020\tH\u0002¢\u0006\u0004\bO\u0010\u0006J\u000f\u0010P\u001a\u00020\tH\u0002¢\u0006\u0004\bP\u0010\u0006J\u000f\u0010Q\u001a\u00020\tH\u0002¢\u0006\u0004\bQ\u0010\u0006J\u0019\u0010T\u001a\u00020\t2\b\u0010S\u001a\u0004\u0018\u00010RH\u0002¢\u0006\u0004\bT\u0010UJ\u001f\u0010Y\u001a\u00020\t2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010VH\u0002¢\u0006\u0004\bY\u0010ZJ\u001f\u0010]\u001a\u00020\t2\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010[H\u0002¢\u0006\u0004\b]\u0010ZJ\u001f\u0010^\u001a\u00020\u000e2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010[H\u0002¢\u0006\u0004\b^\u0010_J-\u0010f\u001a\u00020e2\u0006\u0010`\u001a\u00020W2\n\u0010c\u001a\u00060aR\u00020b2\b\u0010d\u001a\u0004\u0018\u00010WH\u0002¢\u0006\u0004\bf\u0010gJ-\u0010j\u001a\u00020\t2\b\u0010h\u001a\u0004\u0018\u00010W2\b\u0010i\u001a\u0004\u0018\u00010e2\b\u0010d\u001a\u0004\u0018\u00010WH\u0002¢\u0006\u0004\bj\u0010kJ\u001f\u0010m\u001a\u00020\t2\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010VH\u0002¢\u0006\u0004\bm\u0010ZJ\u001b\u0010o\u001a\u0004\u0018\u00010n2\b\u0010h\u001a\u0004\u0018\u00010WH\u0002¢\u0006\u0004\bo\u0010pJ\u001b\u0010q\u001a\u0004\u0018\u00010n2\b\u0010h\u001a\u0004\u0018\u00010WH\u0002¢\u0006\u0004\bq\u0010pJ\u001f\u0010t\u001a\u00020\t2\u0006\u0010r\u001a\u00020n2\u0006\u0010s\u001a\u00020.H\u0002¢\u0006\u0004\bt\u0010uJ\u0019\u0010w\u001a\u00020\t2\b\u0010`\u001a\u0004\u0018\u00010vH\u0002¢\u0006\u0004\bw\u0010xJ\u0019\u0010y\u001a\u00020\t2\b\u0010d\u001a\u0004\u0018\u00010WH\u0002¢\u0006\u0004\by\u0010zJ\u0017\u0010|\u001a\u00020\u00132\u0006\u0010{\u001a\u00020.H\u0002¢\u0006\u0004\b|\u0010}J\u0017\u0010\u007f\u001a\u00020\u00132\u0006\u0010~\u001a\u00020.H\u0002¢\u0006\u0004\b\u007f\u0010}J\u0011\u0010\u0080\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0080\u0001\u0010\u0006J\u0011\u0010\u0081\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0081\u0001\u0010\u0006J$\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0082\u0001\u001a\u00020\u00132\u0007\u0010\u0083\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0086\u0001\u0010\u0006J\u0011\u0010\u0087\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0087\u0001\u0010\u0006J>\u0010\u008d\u0001\u001a\u00020\t2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010e2\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0011\u0010\u008f\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u008f\u0001\u0010\u0006J\u0011\u0010\u0090\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0090\u0001\u0010\u0006J\u001b\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010\u0091\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0011\u0010\u0094\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0094\u0001\u0010\u0006J%\u0010\u0096\u0001\u001a\u00020\u00132\b\u0010~\u001a\u0004\u0018\u00010.2\u0007\u0010\u0095\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0098\u0001\u0010\u0006J\u001d\u0010\u009a\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0099\u0001\u001a\u00020?H\u0002¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J%\u0010\u009d\u0001\u001a\u00020\t2\b\u0010h\u001a\u0004\u0018\u00010W2\u0007\u0010\u009c\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0011\u0010\u009f\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u009f\u0001\u0010\u0006J\u0011\u0010 \u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b \u0001\u0010\u0006J\u0011\u0010¡\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b¡\u0001\u0010\u0006J\u0016\u0010¢\u0001\u001a\u00020\t*\u00020eH\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0011\u0010¤\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b¤\u0001\u0010\u0006J\u0011\u0010¥\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b¥\u0001\u0010\u0006R\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R&\u0010±\u0001\u001a\u000f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020n0®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001a\u0010³\u0001\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\"\u0010²\u0001R\u0019\u0010¶\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0019\u0010¸\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010µ\u0001R\u0019\u0010»\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u0019\u0010½\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010º\u0001R\u0018\u0010¾\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b:\u0010º\u0001R#\u0010Ä\u0001\u001a\u0005\u0018\u00010¿\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0019\u0010Ç\u0001\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u0019\u0010É\u0001\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010Æ\u0001R\u0019\u0010Ë\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010µ\u0001R\u0019\u0010Í\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010µ\u0001R\u001a\u0010Ñ\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u001b\u0010Ô\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001b\u0010×\u0001\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u0019\u0010Ù\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010º\u0001R\u0019\u0010Û\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010º\u0001R\u001b\u0010Ý\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Æ\u0001R!\u0010â\u0001\u001a\u00030Þ\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bß\u0001\u0010Á\u0001\u001a\u0006\bà\u0001\u0010á\u0001R\u0019\u0010ä\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010º\u0001R\u0019\u0010æ\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010º\u0001R\u0019\u0010è\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010º\u0001R!\u0010í\u0001\u001a\u00030é\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bê\u0001\u0010Á\u0001\u001a\u0006\bë\u0001\u0010ì\u0001R\u001e\u0010ñ\u0001\u001a\t\u0012\u0004\u0012\u00020\t0î\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u001a\u0010ó\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010Ð\u0001R\u0019\u0010õ\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0001\u0010º\u0001R\u001a\u0010ù\u0001\u001a\u00030ö\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R\u001c\u0010ý\u0001\u001a\u0005\u0018\u00010ú\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u0019\u0010ÿ\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010º\u0001R\u0018\u0010\u0083\u0002\u001a\u00030\u0080\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002¨\u0006\u0085\u0002"}, d2 = {"Lcom/transsion/subroom/activity/MainActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lau/a;", "Lcom/transsion/home/preload/a;", "Lvl/b;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "V0", "()Lau/a;", "", "isTranslucent", "()Z", "isChangeStatusBar", "isStatusDark", "", "statusColor", "()I", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "onBackPressed", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDestroy", "Lcom/transsion/home/preload/b;", "d", "()Lcom/transsion/home/preload/b;", "isWhiteFont", "isHomeFragment", "changeStatusFontColor", "(ZZ)V", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "outState", "onSaveInstanceState", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "i", "W0", "loadTwoLevelAd", "hasAd", EventConstants.KEY_ACTION, "", "distance", NotificationCompat.CATEGORY_PROGRESS, "onAction", "(Ljava/lang/String;FF)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "callback", "setStateCallback", "(Lkotlin/jvm/functions/Function1;)V", "getTipViewBottomMargin", "isShowMemberPushViewTip", "H0", "N0", "x1", "h1", "C1", "Lcom/transsion/home/bean/AppTab;", "homeTab", "I1", "(Lcom/transsion/home/bean/AppTab;)V", "", "Lcom/transsion/home/bean/BottomTabItem;", "bottomTabs", "G0", "(Ljava/util/List;)V", "", "notEmptyBottomTabs", "X0", "I0", "(Ljava/util/List;)Z", "tab", "Lcom/google/android/material/tabs/TabLayout$TabView;", "Lcom/google/android/material/tabs/TabLayout;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "selectedTabItem", "Landroid/view/View;", "S1", "(Lcom/transsion/home/bean/BottomTabItem;Lcom/google/android/material/tabs/TabLayout$TabView;Lcom/transsion/home/bean/BottomTabItem;)Landroid/view/View;", "tabItem", "tabView", "N1", "(Lcom/transsion/home/bean/BottomTabItem;Landroid/view/View;Lcom/transsion/home/bean/BottomTabItem;)V", "tabs", "e1", "Landroidx/fragment/app/Fragment;", "M0", "(Lcom/transsion/home/bean/BottomTabItem;)Landroidx/fragment/app/Fragment;", "R0", "fragment", "tag", "P1", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Lcom/google/android/material/tabs/TabLayout$Tab;", "z1", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "D1", "(Lcom/transsion/home/bean/BottomTabItem;)V", "tabType", "U0", "(Ljava/lang/String;)I", "tabCode", "T0", "initPlayer", "Y0", NotificationCompat.CATEGORY_STATUS, "size", "O1", "(II)V", "J1", "L1", "vTips", "Landroidx/appcompat/widget/AppCompatTextView;", "tvStatus", "Landroidx/appcompat/widget/AppCompatImageView;", "ivDownloadFail", "Q1", "(Landroid/view/View;Landroidx/appcompat/widget/AppCompatTextView;Landroidx/appcompat/widget/AppCompatImageView;I)V", "L0", "R1", "routerPosition", "H1", "(I)V", "G1", "tabId", "S0", "(Ljava/lang/String;I)I", "k1", "bottomMargin", "J0", "(F)V", "isUserAction", "F1", "(Lcom/transsion/home/bean/BottomTabItem;Z)V", "E1", "Z0", "f1", "F0", "(Landroid/view/View;)V", "B1", "A1", "Lny/e;", "a", "Lny/e;", "onDownloadIconStatusListener", "Lcom/transsion/home/fragment/home/HomeFragment;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/home/fragment/home/HomeFragment;", "homeFragment", "", "c", "Ljava/util/Map;", "mFragments", "Landroidx/fragment/app/Fragment;", "currentFragment", "e", "I", "defaultIndex", "f", "currentFragmentIndex", be.g.f16474b, "Z", "mVideoTabIsWhite", "h", "kidsDialogShown", "widgetDialogShowing", "Lcom/transsnet/loginapi/ILoginApi;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lkotlin/Lazy;", "O0", "()Lcom/transsnet/loginapi/ILoginApi;", "mLoginApi", CampaignEx.JSON_KEY_AD_K, "Ljava/lang/String;", "mTopTabCode", "l", "mBottomTabCode", "m", "mInitTabId", "n", "mSecondTabIndex", "", "o", "J", "mBackTime", TtmlNode.TAG_P, "Lcom/transsion/home/preload/b;", "xmlPreload", CampaignEx.JSON_KEY_AD_Q, "Lcom/transsion/home/bean/AppTab;", "mCurrentHomeTab", CampaignEx.JSON_KEY_AD_R, "runOnce", "s", "isShowHotTips", "t", "showHotTabCode", "Ldu/b;", TmcStartParams.KEY_URL_SHORT, "P0", "()Ldu/b;", "mbUpdateManager", "v", "mHomeStatusWhite", "w", "isBottomTabLargeType", "x", "isUserBottomTabClickAction", "Lcom/transsion/usercenter/profile/f;", "y", "Q0", "()Lcom/transsion/usercenter/profile/f;", "noticeViewModel", "Lkotlin/Function0;", "z", "Lkotlin/jvm/functions/Function0;", "onConfigLoadedCallback", "A", "lastClickTime", "B", "isColdStart", "Lcom/transsion/subroom/activity/MainDialogAdManager;", "C", "Lcom/transsion/subroom/activity/MainDialogAdManager;", "mainDialogAdManager", "Lcom/transsion/subroom/activity/SecondFloorHelper;", "D", "Lcom/transsion/subroom/activity/SecondFloorHelper;", "secondFloorHelper", "E", "shouldShowGuide", "com/transsion/subroom/activity/MainActivity$c", "F", "Lcom/transsion/subroom/activity/MainActivity$c;", "hiSdkInitListener", "G", "app_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class MainActivity extends BaseActivity<au.a> implements com.transsion.home.preload.a, vl.b {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f47short;

    /* renamed from: A, reason: from kotlin metadata */
    private long lastClickTime;

    /* renamed from: B, reason: from kotlin metadata */
    private boolean isColdStart;

    /* renamed from: C, reason: from kotlin metadata */
    private MainDialogAdManager mainDialogAdManager;

    /* renamed from: D, reason: from kotlin metadata */
    private SecondFloorHelper secondFloorHelper;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean shouldShowGuide;

    /* renamed from: F, reason: from kotlin metadata */
    private final c hiSdkInitListener;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ny.e onDownloadIconStatusListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private HomeFragment homeFragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Map mFragments;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Fragment currentFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int defaultIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentFragmentIndex;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean mVideoTabIsWhite;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean kidsDialogShown;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean widgetDialogShowing;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLoginApi;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public String mTopTabCode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public String mBottomTabCode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public int mInitTabId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public int mSecondTabIndex;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long mBackTime;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private com.transsion.home.preload.b xmlPreload;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private AppTab mCurrentHomeTab;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean runOnce;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isShowHotTips;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private String showHotTabCode;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Lazy mbUpdateManager;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean mHomeStatusWhite;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean isBottomTabLargeType;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private boolean isUserBottomTabClickAction;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final Lazy noticeViewModel;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final Function0 onConfigLoadedCallback;

    /* loaded from: classes6.dex */
    public static final class b extends AbstractCoroutineContextElement implements kotlinx.coroutines.j0 {
        public b(j0.a aVar) {
            super(aVar);
        }

        @Override // kotlinx.coroutines.j0
        public void o(CoroutineContext coroutineContext, Throwable th2) {
            lg.a.f68962a.i("MainActivity", "coroutineExceptionHandler " + th2.getMessage(), true);
            th2.printStackTrace();
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements com.transsion.ad.hi.a {
        c() {
        }

        @Override // com.transsion.ad.hi.a
        public void onInitSuccess() {
            MainActivity.C0(MainActivity.this);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements ny.e {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ny.e
        public void a(int i11, int i12) {
            if (((au.a) MainActivity.this.getMViewBinding()).f16220m.getTabCount() > 3) {
                MainActivity.E0(MainActivity.this, i11, i12);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements TabLayout.OnTabSelectedListener {
        e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            a.C0856a.f(lg.a.f68962a, "MainActivity", "onTabReselected", false, 4, null);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            a.C0856a.f(lg.a.f68962a, "MainActivity", "onTabSelected --> tag = " + (tab != null ? tab.getTag() : null), false, 4, null);
            MainActivity.B0(MainActivity.this, tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            a.C0856a.f(lg.a.f68962a, "MainActivity", "onTabUnselected", false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class f implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f54631a;

        f(Function1 function) {
            Intrinsics.h(function, "function");
            this.f54631a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f54631a;
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
            this.f54631a.invoke(obj);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        return;
     */
    static {
        /*
            java.lang.String r0 = "ۣۣۢ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1747777(0x1aab41, float:2.449157E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 98: goto Le;
                case 6438: goto L34;
                case 7461: goto L1c;
                case 27977: goto L11;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            java.lang.String r0 = "ۣۣۢ"
            goto L2
        L11:
            com.transsion.subroom.activity.MainActivity$a r0 = new com.transsion.subroom.activity.MainActivity$a
            r1 = 0
            r0.<init>(r1)
            com.transsion.subroom.activity.MainActivity.INSTANCE = r0
            java.lang.String r0 = "ۢ۠ۥ"
            goto L2
        L1c:
            r0 = 2294(0x8f6, float:3.215E-42)
            short[] r0 = new short[r0]
            r0 = {x0048: FILL_ARRAY_DATA , data: [2767, 2813, 2809, 2766, 2792, 2815, 2804, 2814, 2803, 2804, 2813, 770, 773, 775, 783, 2798, 2769, 2780, 2781, 2775, 2795, 2764, 2777, 2762, 2764, 2810, 2769, 2780, 2795, 2779, 2781, 2774, 2781, 1139, 1112, 1088, 1113, 1115, 1112, 1110, 1107, 1147, 1118, 1092, 1091, 1124, 1108, 1106, 1113, 1106, 625, 598, 592, 583, 579, 591, 587, 588, 581, 623, 583, 582, 587, 579, 609, 589, 588, 598, 583, 588, 598, 625, 577, 583, 588, 583, 2541, 2502, 2526, 2503, 2501, 2502, 2504, 2509, 2538, 2508, 2503, 2525, 2508, 2523, 2536, 2521, 2521, 2541, 2496, 2522, 2525, 2523, 2496, 2507, 2524, 2525, 2496, 2502, 2503, 2554, 2506, 2508, 2503, 2508, 893, 843, 847, 860, 845, 838, 870, 833, 858, 864, 847, 858, 839, 856, 843, 893, 845, 843, 832, 843, 2341, 2306, 2308, 2323, 2327, 2331, 2323, 2308, 2367, 2325, 2329, 2328, 2359, 2322, 2341, 2325, 2323, 2328, 2323, 1609, 1646, 1640, 1663, 1659, 1655, 1612, 1651, 1662, 1663, 1653, 1624, 1659, 1657, 1649, 1619, 1652, 1646, 1663, 1640, 1641, 1646, 1651, 1646, 1651, 1659, 1654, 1609, 1657, 1663, 1652, 1663, 981, 984, 963, 963, 984, 986, 995, 982, 981, 919, 981, 962, 990, 987, 979, 919, 977, 965, 984, 986, 919, 980, 982, 980, 991, 978, 902, 919, 596, 513, 531, 535, 569, 539, 528, 529, 596, 2118, 2148, 2163, 2170, 2169, 2167, 2162, 2114, 2148, 2163, 2168, 2162, 2175, 2168, 2161, 2926, 2939, 2936, 2885, 2937, 2933, 2942, 2943, 510, 491, 488, 469, 510, 499, 506, 495, 3000, 2989, 2990, 2963, 2978, 2989, 2977, 2985, 3132, 3120, 3128, 3135, 3086, 3105, 3120, 3126, 3124, 1310, 1322, 1308, 1286, 1322, 1299, 1300, 1304, 1308, 1305, 1292, 1322, 1304, 1306, 1297, 1296, 1322, 1303, 1300, 1297, 1298, 1296, 1925, 1936, 1939, 1966, 1938, 1950, 1941, 1940, 2429, 2408, 2411, 2390, 2429, 2416, 2425, 2412, 805, 816, 819, 782, 831, 816, 828, 820, 1371, 1358, 1357, 1392, 1370, 1372, 1354, 1373, 1392, 1356, 1347, 1350, 1356, 1348, 2760, 2756, 2764, 2763, 2810, 2773, 2756, 2754, 2752, 1361, 1372, 1351, 1351, 1372, 1374, 1299, 1351, 1362, 1361, 1344, 1299, 23089, 23307, 21615, 23462, 2132, 2168, 2160, 2167, 2136, 2170, 2157, 2160, 2159, 2160, 2157, 2144, 1655, 1637, 1627, 1647, 1633, 1661, 1627, 1647, 1645, 1632, 1627, 1641, 1643, 1632, 1633, 1627, 1634, 1633, 1637, 1648, 1649, 1654, 1633, 1627, 1633, 1642, 1637, 1638, 1640, 1633, 587, 615, 623, 616, 583, 613, 626, 623, 624, 623, 626, 639, 2456, 2452, 2453, 2461, 2450, 2460, 2523, 2453, 2452, 2447, 2523, 2455, 2452, 2458, 2463, 2462, 2463, 2523, 2434, 2462, 2447, 2519, 2523, 2444, 2458, 2450, 2447, 2523, 2461, 2452, 2441, 2523, 2456, 2452, 2453, 2461, 2450, 2460, 2523, 2456, 2458, 2455, 2455, 2457, 2458, 2456, 2448, 2517, 682, 679, 692, 673, 675, 644, 681, 690, 690, 681, 683, 644, 673, 1386, 1407, 1404, 1372, 1401, 1330, 1316, 1333, 1282, 1332, 1331, 1331, 1316, 1327, 1333, 1289, 1326, 1324, 1316, 1301, 1312, 1315, 1377, 1403, 829, 785, 793, 798, 817, 787, 772, 793, 774, 793, 772, 777, 2545, 2550, 2548, 2556, 1838, 1826, 1824, 1824, 1848, 1827, 1828, 1849, 1844, 3299, 3279, 3271, 3264, 3311, 3277, 3290, 3271, 3288, 3271, 3290, 3287, 2511, 2526, 2505, 2509, 2520, 2505, 2538, 2526, 2509, 2507, 2497, 2505, 2498, 2520, 2436, 2437, 2444, 2433, 2433, 2450, 2444, 2500, 2499, 2497, 2505, 2538, 2526, 2509, 2507, 2497, 2505, 2498, 2520, 2486, 2458, 2450, 2453, 2490, 2456, 2447, 2450, 2445, 2450, 2447, 2434, 1332, 1317, 1330, 1334, 1315, 1330, 1297, 1317, 1334, 1328, 1338, 1330, 1337, 1315, 1407, 1406, 1399, 1402, 1402, 1385, 1399, 1284, 1343, 1336, 1317, 1315, 1283, 1281, 1299, 1342, 1316, 1332, 1336, 1313, 1330, 1317, 1297, 1317, 1334, 1328, 1338, 1330, 1337, 1315, 2030, 2047, 2024, 2028, 2041, 2024, 1995, 2047, 2028, 2026, 2016, 2024, 2019, 2041, 1957, 1956, 1965, 1952, 1952, 1971, 1965, 1999, 2018, 2041, 2041, 2018, 2016, 1986, 2045, 1995, 2047, 2028, 2026, 2016, 2024, 2019, 2041, 1975, 1377, 1357, 1349, 1346, 1389, 1359, 1368, 1349, 1370, 1349, 1368, 1365, 1637, 1609, 1601, 1606, 1641, 1611, 1628, 1601, 1630, 1601, 1628, 1617, 868, 885, 866, 870, 883, 866, 833, 885, 870, 864, 874, 866, 873, 883, 815, 814, 807, 810, 810, 825, 807, 874, 866, 874, 869, 866, 885, 833, 885, 870, 864, 874, 866, 873, 883, 2502, 2538, 2530, 2533, 2506, 2536, 2559, 2530, 2557, 2530, 2559, 2546, 2184, 2201, 2190, 2186, 2207, 2190, 2221, 2201, 2186, 2188, 2182, 2190, 2181, 2207, 2243, 2242, 2251, 2246, 2246, 2261, 2251, 2223, 2180, 2204, 2181, 2183, 2180, 2186, 2191, 2214, 2186, 2178, 2181, 2221, 2201, 2186, 2188, 2182, 2190, 2181, 2207, 3122, 3113, 3113, 3114, 3097, 3108, 3111, 3124, 3097, 3118, 3119, 3106, 3106, 3107, 3112, 2323, 2324, 2314, 2340, 2357, 2338, 2342, 2355, 2338, 2305, 2357, 2342, 2336, 2346, 2338, 2345, 2355, 2415, 2414, 2407, 2410, 2410, 2425, 2407, 2320, 2338, 2341, 2305, 2357, 2342, 2336, 2346, 2338, 2345, 2355, 2321, 2421, 2407, 2410, 2410, 2425, 2407, 2487, 2459, 2451, 2452, 2491, 2457, 2446, 2451, 2444, 2451, 2446, 2435, 3101, 3080, 3083, 3126, 3082, 3078, 3085, 3084, 2364, 2353, 2346, 2346, 2353, 2355, 2305, 2355, 2367, 2348, 2361, 2359, 2352, 3131, 3095, 3103, 3096, 3127, 3093, 3074, 3103, 3072, 3103, 3074, 3087, 725, 708, 723, 727, 706, 723, 752, 708, 727, 721, 731, 723, 728, 706, 670, 671, 662, 667, 667, 648, 662, 763, 723, 752, 708, 727, 721, 731, 723, 728, 706, 2041, 2005, 2013, 2010, 2037, 2007, 1984, 2013, 1986, 2013, 1984, 1997, 1667, 1682, 1669, 1665, 1684, 1669, 1702, 1682, 1665, 1671, 1677, 1669, 1678, 1684, 1736, 1737, 1728, 1741, 1741, 1758, 1728, 1698, 1679, 1684, 1684, 1679, 1677, 1714, 1679, 1679, 1677, 1702, 1682, 1665, 1671, 1677, 1669, 1678, 1684, 545, 525, 517, 514, 557, 527, 536, 517, 538, 517, 536, 533, 3049, 3064, 3055, 3051, 3070, 3055, 3020, 3064, 3051, 3053, 3047, 3055, 3044, 3070, 2978, 2979, 2986, 2983, 2983, 2996, 2986, 3033, 3071, 3048, 3065, 3049, 3064, 3043, 3066, 3070, 3043, 3045, 3044, 3016, 3045, 3070, 3070, 3045, 3047, 3013, 3066, 3020, 3064, 3051, 3053, 3047, 3055, 3044, 3070, 2065, 2061, 2061, 2057, 2058, 2115, 2134, 2134, 2068, 2070, 2063, 2064, 2076, 2075, 2070, 2049, 2135, 2071, 2078, 2134, 2065, 2070, 2068, 2076, 447, 445, 428, 411, 439, 438, 428, 445, 416, 428, 496, 502, 502, 502, 497, 2365, 2347, 2362, 2330, 2351, 2348, 2331, 2311, 2406, 2407, 2414, 2403, 2403, 2416, 2336, 2351, 2339, 2347, 2420, 2640, 2580, 2562, 2577, 2567, 2577, 2578, 2588, 2581, 2597, 2562, 2588, 2640, 2637, 2640, 502, 506, 429, 435, 446, 430, 434, 506, 487, 506, 2021, 1993, 1985, 1990, 2025, 1995, 2012, 1985, 2014, 1985, 2012, 2001, 845, 856, 859, 870, 849, 854, 845, 870, 845, 848, 841, 842, 870, 848, 842, 870, 842, 849, 854, 846, 2759, 2784, 2811, 1051, 1024, 1031, 1055, 1070, 1050, 1033, 1039, 1029, 1037, 1030, 1052, 1088, 1089, 1096, 1093, 1093, 1110, 1096, 1052, 1033, 1039, 1106, 388, 461, 471, 485, 448, 448, 449, 448, 414, 907, 935, 943, 936, 903, 933, 946, 943, 944, 943, 946, 959, 2891, 2891, 2905, 2716, 2715, 2713, 2705, 2915, 2916, 2918, 2926, 2721, 2745, 2751, 2725, 2735, 1893, 1895, 1904, 1912, 1916, 1888, 1912, 2415, 2407, 1244, 1223, 1216, 1245, 1243, 1243, 1241, 2979, 2994, 2994, 2990, 3003, 3050, 3052, 3052, 3052, 3051, 577, 596, 599, 618, 605, 602, 577, 618, 577, 604, 581, 582, 618, 579, 592, 583, 582, 604, 602, 603, 485, 496, 499, 462, 505, 510, 485, 462, 485, 504, 481, 482, 462, 504, 482, 462, 482, 505, 510, 486, 2012, 1987, 1999, 2013, 2592, 2619, 2594, 2594, 2670, 2605, 2607, 2592, 2592, 2593, 2618, 2670, 2604, 2603, 2670, 2605, 2607, 2621, 2618, 2670, 2618, 2593, 2670, 2592, 2593, 2592, 2659, 2592, 2619, 2594, 2594, 2670, 2618, 2615, 2622, 2603, 2670, 2605, 2593, 2595, 2656, 2618, 2620, 2607, 2592, 2621, 2621, 2592, 2603, 2618, 2656, 2602, 2593, 2617, 2592, 2594, 2593, 2607, 2602, 2603, 2620, 2656, 2605, 2607, 2594, 2594, 2604, 2607, 2605, 2597, 2656, 2561, 2592, 2570, 2593, 2617, 2592, 2594, 2593, 2607, 2602, 2567, 2605, 2593, 2592, 2589, 2618, 2607, 2618, 2619, 2621, 2562, 2599, 2621, 2618, 2603, 2592, 2603, 2620, 2888, 2890, 2907, 2913, 2894, 2882, 2890, 2823, 2817, 2817, 2817, 2822, 1775, 1778, 2929, 2924, 616, 629, 933, 952, 2962, 3006, 2998, 2993, 2974, 3004, 2987, 2998, 2985, 2998, 2987, 2982, 672, 679, 672, 701, 655, 699, 680, 686, 676, 684, 679, 701, 737, 736, 745, 740, 740, 759, 745, 20692, 23298, 20959, 655, 699, 680, 686, 676, 684, 679, 701, 26553, 24999, -571, 23615, -29418, 20585, -29260, 26856, 24006, 2624, 2651, 2652, 2628, 2677, 2625, 2642, 2644, 2654, 2646, 2653, 2631, 2579, 2650, 2653, 2647, 2646, 2635, 2579, 2646, 2625, 2625, 2652, 2625, 2579, 2569, 2579, 2497, 2509, 2047, 2003, 2011, 2012, 2035, 2001, 1990, 2011, 1988, 2011, 1990, 1995, 1211, 1167, 1209, 1187, 1167, 1206, 1201, 1213, 1209, 1212, 1193, 1167, 1213, 1215, 1204, 1205, 1167, 1202, 1201, 1204, 1207, 1205, 408, 410, 395, 433, 414, 402, 410, 471, 465, 465, 465, 470, 1297, 1292, 3167, 3187, 3195, 3196, 3155, 3185, 3174, 3195, 3172, 3195, 3174, 3179, 1668, 1667, 1668, 1689, 1721, 1676, 1679, 1694, 1733, 1732, 1741, 1728, 1728, 1747, 1741, 23021, 24358, 21750, 22551, 1721, 1676, 1679, 18539, 1912, 1909, 1902, 1902, 1909, 1911, 1870, 1915, 1912, 1850, 1912, 1903, 1907, 1910, 1918, 1850, 1916, 1896, 1909, 1911, 1850, 1913, 1915, 1913, 1906, 1919, 1832, 1824, 1850, 2620, 2665, 2683, 2687, 2641, 2675, 2680, 2681, 2620, 1535, 1501, 1482, 1475, 1472, 1486, 1483, 1531, 1501, 1482, 1473, 1483, 1478, 1473, 1480, 2481, 2492, 2471, 2471, 2492, 2494, 2439, 2482, 2481, 2547, 2491, 2482, 2464, 2547, 2492, 2481, 2464, 2486, 2465, 2469, 2486, 2487, 2547, 329, 2990, 3067, 3049, 3053, 3011, 3041, 3050, 3051, 1762, 1728, 1751, 1758, 1757, 1747, 1750, 1766, 1728, 1751, 1756, 1750, 1755, 1756, 1749, 2174, 2163, 2152, 2152, 2163, 2161, 2120, 2173, 2174, 2108, 2174, 2153, 2165, 2160, 2168, 2108, 2170, 2158, 2163, 2161, 2108, 2162, 2169, 2152, 2086, 2695, 2725, 2738, 2747, 2744, 2742, 2739, 2691, 2725, 2738, 2745, 2739, 2750, 2745, 2736, 2692, 2728, 2720, 2727, 2696, 2730, 2749, 2720, 2751, 2720, 2749, 2736, 1537, 1581, 1573, 1570, 1549, 1583, 1592, 1573, 1594, 1573, 1592, 1589, 1644, 1599, 1577, 1583, 1571, 1570, 1576, 1644, 1578, 1568, 1571, 1571, 1598, 1644, 1579, 1593, 1573, 1576, 1577, 1644, 1578, 1573, 1570, 1573, 1599, 1572, 1577, 1576, 2916, 2918, 2935, 2896, 2935, 2929, 2922, 2925, 2916, 2859, 2861, 2861, 2861, 2858, 494, 482, 483, 505, 488, 483, 505, 3046, 3032, 3070, 3049, 3041, 3054, 3048, 3071, 3010, 3055, 2731, 2748, 2729, 2742, 2731, 2733, 2360, 2341, 733, 753, 761, 766, 721, 755, 740, 761, 742, 761, 740, 745, 1538, 1539, 1582, 1567, 1544, 1548, 1561, 1544, 1571, 1544, 1557, 1561, 1605, 1604, 1613, 1600, 1600, 1619, 1613, -24581, -25064, 22893, 24486, 21616, 24486, 21883, 18667, 420, 433, 434, 399, 440, 447, 420, 399, 420, 441, 416, 419, 399, 422, 437, 418, 419, 441, 447, 446, 3134, 3115, 3112, 3093, 3106, 3109, 3134, 3093, 3134, 3107, 3130, 3129, 3093, 3107, 3129, 3093, 3129, 3106, 3109, 3133, 637, 636, 582, 627, 624, 577, 631, 638, 631, 625, 614, 631, 630, 570, 571, 562, 575, 575, 556, 562, 628, 608, 627, 629, 639, 631, 636, 614, 562, 635, 609, 562, 636, 615, 638, 638, 562, 628, 637, 608, 562, 614, 627, 624, 552, 590, 610, 618, 621, 578, 608, 631, 618, 629, 618, 631, 634, 1667, 1668, 1676, 1670, 1675, 1694, 1679, 1730, 1732, 1732, 1732, 1731, 908, 910, 921, 900, 898, 899, 780, 791, 782, 782, 834, 769, 771, 780, 780, 781, 790, 834, 768, 775, 834, 769, 771, 785, 790, 834, 790, 781, 834, 780, 781, 780, 847, 780, 791, 782, 782, 834, 790, 795, 786, 775, 834, 769, 781, 783, 844, 790, 784, 771, 780, 785, 785, 779, 781, 780, 844, 789, 775, 768, 844, 772, 784, 771, 773, 783, 775, 780, 790, 844, 821, 775, 768, 804, 784, 771, 773, 783, 775, 780, 790, 820, 848, 1272, 1251, 1274, 1274, 1206, 1269, 1271, 1272, 1272, 1273, 1250, 1206, 1268, 1267, 1206, 1269, 1271, 1253, 1250, 1206, 1250, 1273, 1206, 1272, 1273, 1272, 1211, 1272, 1251, 1274, 1274, 1206, 1250, 1263, 1254, 1267, 1206, 1269, 1273, 1275, 1208, 1250, 1252, 1271, 1272, 1253, 1253, 1279, 1273, 1272, 1208, 1278, 1273, 1275, 1267, 1208, 1264, 1252, 1271, 1265, 1275, 1267, 1272, 1250, 1208, 1278, 1273, 1275, 1267, 1208, 1246, 1273, 1275, 1267, 1232, 1252, 1271, 1265, 1275, 1267, 1272, 1250, 1980, 1975, 1957, 1937, 1981, 1980, 1972, 1979, 1973, 1842, 1854, 1846, 1841, 1792, 1852, 1837, 1850, 1854, 1835, 1850, 3108, 3112, 3104, 3111, 3094, 3130, 3132, 3129, 3116, 3131, 403, 389, 386, 386, 405, 414, 388, 431, 406, 386, 401, 407, 413, 405, 414, 388, 431, 409, 414, 404, 405, 392, 2506, 2517, 2520, 2521, 2515, 2531, 2504, 2525, 2526, 2531, 2517, 2511, 2531, 2507, 2516, 2517, 2504, 2521, 455, 459, 451, 452, 501, 457, 472, 463, 459, 478, 463, 501, 452, 463, 466, 478, 978, 1022, 1014, 1009, 990, 1020, 1003, 1014, 1001, 1014, 1003, 998, 959, 1008, 1009, 988, 1005, 1018, 1022, 1003, 1018, 959, 1915, 1879, 1887, 1880, 1911, 1877, 1858, 1887, 1856, 1887, 1858, 1871, 2283, 2279, 2287, 2280, 2265, 2279, 2274, 2265, 2287, 2280, 2287, 2290, 2486, 2481, 2475, 2490, 2481, 2475, 1386, 1407, 1384, 1399, 1395, 1385, 1385, 1395, 1397, 1396, 1385, 1922, 1943, 1924, 1931, 1937, 1975, 1920, 1942, 1936, 1929, 1937, 1942, 1393, 1387, 1386, 1357, 1386, 1407, 1386, 1403, 1318, 1328, 1335, 1335, 1312, 1323, 1329, 1306, 1315, 1335, 1316, 1314, 1320, 1312, 1323, 1329, 1306, 1324, 1323, 1313, 1312, 1341, 988, 963, 974, 975, 965, 1013, 990, 971, 968, 1013, 963, 985, 1013, 989, 962, 963, 990, 975} // fill-array
            com.transsion.subroom.activity.MainActivity.f47short = r0
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 == 0) goto L31
            com.transsion.subroom.activity.C0667.m874()
            java.lang.String r0 = "ۢۨۦ"
            goto L2
        L31:
            java.lang.String r0 = "ۧۧۨ"
            goto L2
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.<clinit>():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0056. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:101:0x032c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0327 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MainActivity() {
        /*
            Method dump skipped, instructions count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.<init>():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        return r3.S0(r4, r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ int A0(com.transsion.subroom.activity.MainActivity r3, java.lang.String r4, int r5) {
        /*
            java.lang.String r0 = "ۡۧۥ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1746788(0x1aa764, float:2.447771E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 2075: goto Le;
                case 3457: goto L13;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            int r0 = r3.S0(r4, r5)
            return r0
        L13:
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 == 0) goto L1c
            java.lang.String r0 = "۠۟ۡ"
            goto L2
        L1c:
            java.lang.String r0 = "ۡۧۥ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.A0(com.transsion.subroom.activity.MainActivity, java.lang.String, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x08b5, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void A1() {
        /*
            Method dump skipped, instructions count: 2328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.A1():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void B0(com.transsion.subroom.activity.MainActivity r3, com.google.android.material.tabs.TabLayout.Tab r4) {
        /*
            java.lang.String r0 = "ۥۣۤ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1751717(0x1abaa5, float:2.454678E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 1187: goto Le;
                case 1196: goto L20;
                case 4378: goto L2d;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r3.z1(r4)
            int r0 = com.transsion.subroom.activity.C0667.m874()
            if (r0 < 0) goto L1d
            com.transsion.subroom.activity.C0667.m874()
            java.lang.String r0 = "ۥۨۢ"
            goto L2
        L1d:
            java.lang.String r0 = "۠ۧۦ"
            goto L2
        L20:
            int r1 = gt.md.C0799.m1162()
            if (r1 > 0) goto L2a
            gt.md.C0799.m1162()
            goto L2
        L2a:
            java.lang.String r0 = "ۥۣۤ"
            goto L2
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.B0(com.transsion.subroom.activity.MainActivity, com.google.android.material.tabs.TabLayout$Tab):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    private final void B1() {
        HiSavanaAdManager hiSavanaAdManager = null;
        String str = "۟ۧ۠";
        while (true) {
            switch (C0799.m1158((Object) str) ^ 56452) {
                case INVALID_ADS_ENDPOINT_VALUE:
                case AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE:
                    str = C0078.m391() >= 0 ? "ۨۨ۟" : "ۡ۠ۡ";
                case 187:
                    if (C0066.m207() == 0) {
                        str = "ۨۦ";
                    }
                case 1709480:
                    str = "ۤۢ۟";
                case 1709519:
                    if (C0667.m874() >= 0) {
                        C0079.m394();
                    } else {
                        str = "۟ۧ۠";
                    }
                case 1730213:
                    A1();
                    str = C0066.m207() != 0 ? "۠ۢۨ" : "ۡ۠ۡ";
                case 1733158:
                    break;
                case 1733400:
                    C0675.n(40229, hiSavanaAdManager, new Object[]{(c) C0675.n(97164, this)});
                    if (C0066.m207() != 0) {
                        C0799.m1162();
                    } else {
                        str = "ۢۡ";
                    }
                case 1735460:
                    if (((Boolean) C0675.n(90353, hiSavanaAdManager, new Object[0])).booleanValue()) {
                        str = "ۤۢ۟";
                    } else if (C0078.m391() >= 0) {
                        C0078.m391();
                    } else {
                        str = "ۣۡۨ";
                    }
                case 1735548:
                    HiSavanaAdManager hiSavanaAdManager2 = (HiSavanaAdManager) C0675.n(10567);
                    if (C0799.m1162() <= 0) {
                        hiSavanaAdManager = hiSavanaAdManager2;
                    } else {
                        str = "۟ۤۥ";
                        hiSavanaAdManager = hiSavanaAdManager2;
                    }
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void C0(com.transsion.subroom.activity.MainActivity r3) {
        /*
            java.lang.String r0 = "ۡۦۦ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1752702(0x1abe7e, float:2.456059E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 89: goto Le;
                case 4383: goto Lf;
                case 31802: goto L1f;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            return
        Lf:
            r3.A1()
            int r1 = androidx.core.appcompat.C0066.m207()
            if (r1 == 0) goto L1c
            androidx.core.C0078.m391()
            goto L2
        L1c:
            java.lang.String r0 = "ۥۤۦ"
            goto L2
        L1f:
            java.lang.String r0 = "ۡۦۦ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.C0(com.transsion.subroom.activity.MainActivity):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0054. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x062c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0637 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x004c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0627 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x061c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0617 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void C1() {
        /*
            Method dump skipped, instructions count: 1784
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.C1():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void D0(com.transsion.subroom.activity.MainActivity r3, int r4) {
        /*
            java.lang.String r0 = "۠ۤ۟"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1749819(0x1ab33b, float:2.452019E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 3806: goto Le;
                case 6240: goto L17;
                case 30291: goto L1d;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            int r1 = androidx.core.C0078.m391()
            if (r1 >= 0) goto L2
            java.lang.String r0 = "۠ۤ۟"
            goto L2
        L17:
            r3.H1(r4)
            java.lang.String r0 = "ۣۧۢ"
            goto L2
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.D0(com.transsion.subroom.activity.MainActivity, int):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x002f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0322 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x031d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0308 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0027 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02d8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void D1(com.transsion.home.bean.BottomTabItem r27) {
        /*
            Method dump skipped, instructions count: 978
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.D1(com.transsion.home.bean.BottomTabItem):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void E0(com.transsion.subroom.activity.MainActivity r3, int r4, int r5) {
        /*
            java.lang.String r0 = "ۨۥۦ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1753671(0x1ac247, float:2.457416E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 3022: goto Le;
                case 26106: goto L14;
                case 30042: goto L1d;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r3.O1(r4, r5)
            java.lang.String r0 = "ۣۨۢ"
            goto L2
        L14:
            int r1 = com.transsion.subroom.activity.C0667.m874()
            if (r1 >= 0) goto L2
            java.lang.String r0 = "ۨۥۦ"
            goto L2
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.E0(com.transsion.subroom.activity.MainActivity, int, int):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0050. Please report as an issue. */
    private final void E1() {
        AppTab appTab;
        AppTab appTab2 = null;
        Object[] objArr = null;
        BottomTabItem bottomTabItem = null;
        Iterator it = null;
        int i11 = 0;
        short[] sArr = null;
        short[] sArr2 = null;
        Pair pair = null;
        int i12 = 0;
        int i13 = 0;
        short[] sArr3 = null;
        int i14 = 0;
        hj.i iVar = null;
        Map map = null;
        int i15 = 0;
        int i16 = 0;
        List list = null;
        String str = null;
        int i17 = 0;
        int i18 = 0;
        Pair pair2 = null;
        int i19 = 0;
        short[] sArr4 = null;
        String str2 = "ۣۥۧ";
        while (true) {
            switch (C0799.m1158((Object) str2) ^ 1751531) {
                case 847:
                    Iterator it2 = (Iterator) C0686.n(35981, list, new Object[0]);
                    if (C0078.m391() >= 0) {
                        it = it2;
                    } else {
                        str2 = "ۧۢ۠";
                        it = it2;
                    }
                case 885:
                    objArr[8] = new Integer(4778786);
                    objArr[5] = new Integer(321753);
                    if (C0078.m391() >= 0) {
                        C0078.m391();
                    } else {
                        str2 = "۠۠۠";
                    }
                case 943:
                    int intValue = ((Integer) C0678.n(99165, (Integer) objArr[0], new Object[0])).intValue();
                    Map map2 = (Map) C0686.n(46405, null, new Object[]{new Pair[]{pair, pair2, (Pair) C0686.n(49501, null, new Object[]{(String) C0675.n(13983, null, new Object[]{sArr3, Integer.valueOf(((i19 ^ (-1)) & 7707324) | ((-7707325) & i19)), Integer.valueOf((intValue & (-2746596)) | ((intValue ^ (-1)) & 2746595)), Integer.valueOf(((i14 ^ (-1)) & 5524120) | ((-5524121) & i14))}), (String) C0686.n(24566, bottomTabItem, new Object[0])})}});
                    if (C0078.m391() >= 0) {
                        C0078.m391();
                        map = map2;
                    } else {
                        str2 = "ۣۨۦ";
                        map = map2;
                    }
                case 1899:
                    List list2 = (List) C0675.n(21659, appTab2, new Object[0]);
                    if (list2 != null) {
                        str2 = "ۤۦۦ";
                        list = list2;
                    } else {
                        list = list2;
                        appTab = appTab2;
                        str2 = "ۣۨۨ";
                        appTab2 = appTab;
                    }
                case 1964:
                case 4727:
                    if (C0066.m207() == 0) {
                        str2 = "ۧۢ۠";
                    }
                case 3883:
                    int intValue2 = ((Integer) C0678.n(99165, (Integer) objArr[2], new Object[0])).intValue();
                    int intValue3 = ((Integer) C0678.n(99165, (Integer) objArr[7], new Object[0])).intValue();
                    if (C0799.m1162() <= 0) {
                        i14 = intValue2;
                        i19 = intValue3;
                    } else {
                        str2 = "ۣۣۤ";
                        i14 = intValue2;
                        i19 = intValue3;
                    }
                case 3886:
                    Object[] objArr2 = new Object[12];
                    objArr2[10] = new Integer(6059278);
                    if (C0799.m1162() <= 0) {
                        C0078.m391();
                        objArr = objArr2;
                    } else {
                        str2 = "ۡۧۨ";
                        objArr = objArr2;
                    }
                case 3948:
                    objArr[11] = new Integer(3390672);
                    objArr[2] = new Integer(5521748);
                    str2 = "ۦۡۢ";
                case 4047:
                    int intValue4 = ((Integer) C0678.n(99165, (Integer) objArr[8], new Object[0])).intValue();
                    int intValue5 = ((Integer) C0678.n(99165, (Integer) objArr[5], new Object[0])).intValue();
                    if (C0079.m394() >= 0) {
                        i16 = intValue5;
                        i15 = intValue4;
                        str2 = "ۢ۟ۨ";
                    } else {
                        i16 = intValue5;
                        i15 = intValue4;
                        str2 = "ۨ۠ۡ";
                    }
                case 4079:
                    AppTab appTab3 = (AppTab) C0675.n(48319, this);
                    if (appTab3 == null) {
                        appTab = appTab3;
                        str2 = "ۣۨۨ";
                        appTab2 = appTab;
                    } else if (C0066.m207() != 0) {
                        str2 = "۠۟ۦ";
                        appTab2 = appTab3;
                    } else {
                        str2 = "ۥۧۢ";
                        appTab2 = appTab3;
                    }
                case 4598:
                    short[] sArr5 = (short[]) C0675.n(38382);
                    i18 = ((Integer) C0678.n(99165, (Integer) objArr[9], new Object[0])).intValue();
                    if (C0078.m391() >= 0) {
                        sArr2 = sArr5;
                    } else {
                        str2 = "۟ۡ۠";
                        sArr2 = sArr5;
                    }
                case 4789:
                    objArr[9] = new Integer(9108055);
                    objArr[4] = new Integer(5196620);
                    if (C0066.m207() == 0) {
                        str2 = "ۣۣۧ";
                    }
                case 4841:
                    int intValue6 = ((Integer) C0678.n(99165, (Integer) objArr[6], new Object[0])).intValue();
                    Pair pair3 = (Pair) C0686.n(49501, null, new Object[]{(String) C0675.n(18203, null, new Object[]{sArr, Integer.valueOf(((i17 ^ (-1)) & 7973448) | ((-7973449) & i17)), Integer.valueOf((intValue6 & (-7221337)) | ((intValue6 ^ (-1)) & 7221336)), Integer.valueOf(((i11 ^ (-1)) & 6061588) | ((-6061589) & i11))}), str});
                    if (C0799.m1162() <= 0) {
                        C0667.m874();
                        pair = pair3;
                    } else {
                        str2 = "۟ۨۦ";
                        pair = pair3;
                    }
                case 4875:
                    objArr[3] = new Integer(4506550);
                    if (C0667.m874() >= 0) {
                        C0079.m394();
                    } else {
                        str2 = "ۣ۟۠";
                    }
                case 4909:
                    String str3 = (String) C0686.n(77457, bottomTabItem, new Object[0]);
                    short[] sArr6 = (short[]) C0675.n(38382);
                    if (C0066.m207() != 0) {
                        C0667.m874();
                        sArr = sArr6;
                        str = str3;
                    } else {
                        str2 = "ۨۡ";
                        sArr = sArr6;
                        str = str3;
                    }
                case 5737:
                    objArr[1] = new Integer(7973537);
                    objArr[6] = new Integer(7221328);
                    str2 = "۠ۤۢ";
                case 7893:
                    int intValue7 = ((Integer) C0678.n(99165, (Integer) objArr[4], new Object[0])).intValue();
                    int intValue8 = ((Integer) C0678.n(99165, (Integer) objArr[11], new Object[0])).intValue();
                    if (C0066.m207() != 0) {
                        i12 = intValue8;
                        i13 = intValue7;
                        str2 = "ۣۤۤ";
                    } else {
                        i12 = intValue8;
                        i13 = intValue7;
                        str2 = "ۦۤۢ";
                    }
                case 7914:
                    if (C0667.m874() >= 0) {
                        C0079.m394();
                    } else {
                        str2 = "ۥۥۧ";
                    }
                case 28718:
                    if (C0799.m1162() <= 0) {
                        C0667.m874();
                    } else {
                        str2 = "ۣۥۧ";
                    }
                case 28832:
                    hj.i iVar2 = (hj.i) C0686.n(15166);
                    short[] sArr7 = (short[]) C0675.n(38382);
                    if (C0079.m394() >= 0) {
                        sArr4 = sArr7;
                        iVar = iVar2;
                    } else {
                        str2 = "ۣ۠ۡ";
                        sArr4 = sArr7;
                        iVar = iVar2;
                    }
                case 28838:
                    break;
                case 28930:
                    int intValue9 = ((Integer) C0678.n(99165, (Integer) objArr[3], new Object[0])).intValue();
                    C0686.n(13852, iVar, new Object[]{(String) C0684.n(75978, null, new Object[]{sArr4, Integer.valueOf(((i16 ^ (-1)) & 322008) | ((-322009) & i16)), Integer.valueOf((intValue9 & (-4506560)) | ((intValue9 ^ (-1)) & 4506559)), Integer.valueOf(((i15 ^ (-1)) & 4777843) | ((-4777844) & i15))}), map});
                    str2 = C0066.m207() != 0 ? "ۢ۟ۨ" : "۟۟ۡ";
                case 30735:
                    Pair pair4 = (Pair) C0686.n(49501, null, new Object[]{(String) C0675.n(18203, null, new Object[]{sArr2, Integer.valueOf(((i13 ^ (-1)) & 5196733) | ((-5196734) & i13)), Integer.valueOf(((i12 ^ (-1)) & 3390680) | ((-3390681) & i12)), Integer.valueOf(((i18 ^ (-1)) & 9108445) | ((-9108446) & i18))}), (String) C0686.n(52966, bottomTabItem, new Object[0])});
                    short[] sArr8 = (short[]) C0675.n(38382);
                    if (C0079.m394() >= 0) {
                        sArr3 = sArr8;
                        pair2 = pair4;
                    } else {
                        str2 = "ۣۥۢ";
                        sArr3 = sArr8;
                        pair2 = pair4;
                    }
                case 30828:
                    objArr[7] = new Integer(7707205);
                    objArr[0] = new Integer(2746603);
                    if (C0066.m207() == 0) {
                        str2 = "ۤۦ۠";
                    }
                case 31668:
                    appTab = appTab2;
                    str2 = "ۣۨۨ";
                    appTab2 = appTab;
                case 31886:
                    if (((Boolean) C0686.n(93887, it, new Object[0])).booleanValue()) {
                        BottomTabItem bottomTabItem2 = (BottomTabItem) C0686.n(36456, it, new Object[0]);
                        if (C0667.m874() >= 0) {
                            C0667.m874();
                            str2 = "۠ۤۧ";
                            bottomTabItem = bottomTabItem2;
                        } else {
                            str2 = "۠۟ۥ";
                            bottomTabItem = bottomTabItem2;
                        }
                    } else {
                        appTab = appTab2;
                        str2 = "ۣۨۨ";
                        appTab2 = appTab;
                    }
                case 1729810:
                    int intValue10 = ((Integer) C0678.n(99165, (Integer) objArr[10], new Object[0])).intValue();
                    int intValue11 = ((Integer) C0678.n(99165, (Integer) objArr[1], new Object[0])).intValue();
                    if (C0079.m394() >= 0) {
                        i11 = intValue10;
                        i17 = intValue11;
                    } else {
                        str2 = "ۣ۠ۡ";
                        i11 = intValue10;
                        i17 = intValue11;
                    }
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x032c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x030c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0321 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x031c A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v49, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void F0(android.view.View r21) {
        /*
            Method dump skipped, instructions count: 950
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.F0(android.view.View):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0072. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:169:0x07be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x006a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x07a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x079b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x078e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0787 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void F1(com.transsion.home.bean.BottomTabItem r48, boolean r49) {
        /*
            Method dump skipped, instructions count: 2146
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.F1(com.transsion.home.bean.BottomTabItem, boolean):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0409 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0404 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0455 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x044b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x043f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x043a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x042f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0427 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void G0(java.util.List r32) {
        /*
            Method dump skipped, instructions count: 1266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.G0(java.util.List):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0013. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x014f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x014a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x013f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void G1() {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.G1():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0526 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x051e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0506 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x04ff A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void H0() {
        /*
            Method dump skipped, instructions count: 1430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.H0():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void H1(int r10) {
        /*
            r9 = this;
            r7 = 1
            r6 = 0
            r1 = 0
            java.lang.String r0 = "۠۠ۦ"
        L5:
            int r2 = gt.md.C0799.m1158(r0)
            r3 = 1755398(0x1ac906, float:2.459837E-39)
            r2 = r2 ^ r3
            switch(r2) {
                case 196: goto L11;
                case 2882: goto L61;
                case 3310: goto L6e;
                case 25568: goto L47;
                case 26596: goto L21;
                case 29657: goto L1c;
                default: goto L10;
            }
        L10:
            goto L5
        L11:
            r9.isUserBottomTabClickAction = r7
            int r2 = androidx.core.C0079.m394()
            if (r2 >= 0) goto L5
            java.lang.String r0 = "ۧۦۧ"
            goto L5
        L1c:
            r9.isUserBottomTabClickAction = r6
            java.lang.String r0 = "ۣۡۢ"
            goto L5
        L21:
            r2 = 47680(0xba40, float:6.6814E-41)
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r0 = 10966(0x2ad6, float:1.5367E-41)
            java.lang.Object[] r4 = new java.lang.Object[r7]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            r4[r6] = r5
            java.lang.Object r0 = com.transsion.subroom.premium.C0675.n(r0, r1, r4)
            com.google.android.material.tabs.TabLayout$Tab r0 = (com.google.android.material.tabs.TabLayout.Tab) r0
            r3[r6] = r0
            com.transsion.subroom.premium.C0686.n(r2, r1, r3)
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 == 0) goto L44
            java.lang.String r0 = "ۡۡۨ"
            goto L5
        L44:
            java.lang.String r0 = "ۨۧۡ"
            goto L5
        L47:
            r1 = 6554(0x199a, float:9.184E-42)
            r0 = 5246(0x147e, float:7.351E-42)
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.Object r0 = com.transsion.subroom.premium.C0675.n(r0, r9, r2)
            g4.a r0 = (g4.a) r0
            au.a r0 = (au.a) r0
            java.lang.Object r0 = com.transsion.subroom.premium.C0675.n(r1, r0)
            com.google.android.material.tabs.TabLayout r0 = (com.google.android.material.tabs.TabLayout) r0
            java.lang.String r1 = "ۣۤۨ"
            r8 = r1
            r1 = r0
            r0 = r8
            goto L5
        L61:
            int r2 = com.transsion.subroom.activity.C0667.m874()
            if (r2 < 0) goto L6b
            androidx.core.appcompat.C0066.m207()
            goto L5
        L6b:
            java.lang.String r0 = "۠۠ۦ"
            goto L5
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.H1(int):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0077. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:114:0x06f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x06f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x06b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x06ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x06c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x064d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x006f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0637 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0632 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0642 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:394:0x006f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean I0(java.util.List r49) {
        /*
            Method dump skipped, instructions count: 2062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.I0(java.util.List):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x002b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0367 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0361 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void I1(com.transsion.home.bean.AppTab r28) {
        /*
            Method dump skipped, instructions count: 990
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.I1(com.transsion.home.bean.AppTab):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
    private final void J0(float bottomMargin) {
        String str = "ۡۡ۠";
        Float f11 = null;
        IMemberApi iMemberApi = null;
        while (true) {
            switch (C0799.m1158((Object) str) ^ 1746850) {
                case 2346:
                    C0678.n(5185, (PrintStream) C0678.n(82094), new Object[]{f11});
                    if (C0078.m391() < 0) {
                        str = "ۣۤ۟";
                    }
                case 2402:
                    IMemberApi iMemberApi2 = (IMemberApi) C0672.n(3250, null, new Object[]{IMemberApi.class, new Object[0]});
                    if (C0799.m1162() <= 0) {
                        iMemberApi = iMemberApi2;
                    } else {
                        str = "۠ۤ";
                        iMemberApi = iMemberApi2;
                    }
                case 3103:
                    Float f12 = (Float) C0672.n(18331, null, new Object[]{(String) C0680.n(35573, null, new Object[]{(String) C0672.n(67083)})});
                    if (C0079.m394() >= 0) {
                        C0079.m394();
                        str = "ۣۢۨ";
                        f11 = f12;
                    } else {
                        str = "ۡ۟ۦ";
                        f11 = f12;
                    }
                case 4418:
                    str = ((Integer) C0678.n(46727, null, new Object[0])).intValue() >= 0 ? "۠ۧۤ" : "ۣۤ۟";
                case 5248:
                    C0672.n(86321, iMemberApi, new Object[]{Float.valueOf(bottomMargin)});
                    str = C0799.m1162() <= 0 ? "ۣۢ۟" : "ۣۦۣ";
                case 7461:
                    if (C0078.m391() >= 0) {
                        C0799.m1162();
                        str = "۠ۦۣ";
                    } else {
                        str = "ۡۡ۠";
                    }
                case 7650:
                    break;
                case 1735520:
                case 1735590:
                    str = iMemberApi != null ? "ۢۦۦ" : "ۣۦۣ";
                case 1735618:
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01ca A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void J1() {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.J1():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void K0(com.transsion.subroom.activity.MainActivity r5, float r6, int r7, java.lang.Object r8) {
        /*
            r1 = 0
            java.lang.String r0 = "ۣۢۡ"
            r2 = r1
        L4:
            int r3 = gt.md.C0799.m1158(r0)
            r4 = 1754594(0x1ac5e2, float:2.45871E-39)
            r3 = r3 ^ r4
            switch(r3) {
                case 73: goto L10;
                case 1157: goto L3c;
                case 28444: goto L57;
                case 29604: goto L48;
                case 29674: goto L29;
                case 30566: goto L38;
                case 31591: goto L21;
                case 32613: goto L66;
                default: goto Lf;
            }
        Lf:
            goto L4
        L10:
            r0 = r7 ^ (-2)
            r0 = r0 & r7
            if (r0 == 0) goto L57
            int r0 = com.transsion.subroom.activity.C0667.m874()
            if (r0 < 0) goto L26
            androidx.core.C0078.m391()
            java.lang.String r0 = "ۣۢۡ"
            goto L4
        L21:
            r1 = 1112014848(0x42480000, float:50.0)
            java.lang.String r0 = "ۦ۠ۡ"
            goto L4
        L26:
            java.lang.String r0 = "ۥۧۧ"
            goto L4
        L29:
            r5.J0(r2)
            int r0 = androidx.core.C0079.m394()
            if (r0 < 0) goto L35
            java.lang.String r0 = "ۦۤ۟"
            goto L4
        L35:
            java.lang.String r0 = "ۤۥۨ"
            goto L4
        L38:
            java.lang.String r0 = "ۧۤۨ"
            r2 = r6
            goto L4
        L3c:
            int r2 = gt.md.C0799.m1162()
            if (r2 > 0) goto L44
            r2 = r1
            goto L4
        L44:
            java.lang.String r0 = "ۣ۟ۤ"
            r2 = r1
            goto L4
        L48:
            int r0 = androidx.core.C0078.m391()
            if (r0 < 0) goto L54
            androidx.core.C0078.m391()
            java.lang.String r0 = "ۡۦۦ"
            goto L4
        L54:
            java.lang.String r0 = "ۣۢۡ"
            goto L4
        L57:
            int r0 = androidx.core.C0078.m391()
            if (r0 < 0) goto L63
            gt.md.C0799.m1162()
            java.lang.String r0 = "ۦۣ۟"
            goto L4
        L63:
            java.lang.String r0 = "ۣ۟ۤ"
            goto L4
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.K0(com.transsion.subroom.activity.MainActivity, float, int, java.lang.Object):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x014c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void K1(com.transsion.subroom.activity.MainActivity r11, int r12, android.view.View r13) {
        /*
            Method dump skipped, instructions count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.K1(com.transsion.subroom.activity.MainActivity, int, android.view.View):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0013. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void L0() {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.L0():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0026. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02d2 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void L1() {
        /*
            Method dump skipped, instructions count: 858
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.L1():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 544
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final androidx.fragment.app.Fragment M0(com.transsion.home.bean.BottomTabItem r62) {
        /*
            Method dump skipped, instructions count: 9730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.M0(com.transsion.home.bean.BottomTabItem):androidx.fragment.app.Fragment");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0027. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x026d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void M1(com.transsion.subroom.activity.MainActivity r26, int r27, com.transsion.home.bean.BottomTabItem r28, android.view.View r29) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.M1(com.transsion.subroom.activity.MainActivity, int, com.transsion.home.bean.BottomTabItem, android.view.View):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b6, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void N0() {
        /*
            r12 = this;
            r11 = 1
            r3 = 0
            r5 = 0
            java.lang.String r0 = "ۣ۠ۡ"
            r1 = r0
            r2 = r3
            r4 = r5
            r6 = r5
            r7 = r5
        La:
            int r0 = gt.md.C0799.m1158(r1)
            r8 = 1750755(0x1ab6e3, float:2.45333E-39)
            r0 = r0 ^ r8
            switch(r0) {
                case 1057: goto L16;
                case 2150: goto L4e;
                case 3264: goto Lb6;
                case 4519: goto Lb1;
                case 7490: goto L86;
                case 7645: goto La3;
                case 1731200: goto L61;
                default: goto L15;
            }
        L15:
            goto La
        L16:
            r0 = 64810(0xfd2a, float:9.0818E-41)
            r1 = 6
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r6
            r1[r11] = r5
            r8 = 2
            r1[r8] = r5
            r8 = 3
            r1[r8] = r4
            r8 = 4
            r9 = r2 ^ (-1)
            r10 = 8338364(0x7f3bbc, float:1.1684537E-38)
            r9 = r9 & r10
            r10 = -8338365(0xffffffffff80c443, float:NaN)
            r10 = r10 & r2
            r9 = r9 | r10
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r1[r8] = r9
            r8 = 5
            r1[r8] = r5
            java.lang.Object r0 = com.transsion.subroom.premium.C0686.n(r0, r5, r1)
            kotlinx.coroutines.t1 r0 = (kotlinx.coroutines.t1) r0
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L5d
            androidx.core.C0079.m394()
            java.lang.String r0 = "ۣۢ۠"
            r1 = r0
            goto La
        L4e:
            com.transsion.subroom.activity.MainActivity$doShowKidsDialog$1 r4 = new com.transsion.subroom.activity.MainActivity$doShowKidsDialog$1
            r4.<init>(r12, r5)
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 != 0) goto La
            java.lang.String r0 = "ۣۦ"
            r1 = r0
            goto La
        L5d:
            java.lang.String r0 = "ۤۢۡ"
            r1 = r0
            goto La
        L61:
            r2 = 99165(0x1835d, float:1.3896E-40)
            java.lang.Object[] r0 = new java.lang.Object[r11]
            r0[r3] = r7
            r0 = r0[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            java.lang.Object[] r8 = new java.lang.Object[r3]
            java.lang.Object r0 = com.transsion.subroom.premium.C0678.n(r2, r0, r8)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r2 = r0.intValue()
            int r0 = com.transsion.subroom.activity.C0667.m874()
            if (r0 < 0) goto L82
            androidx.core.C0079.m394()
            goto La
        L82:
            java.lang.String r0 = "ۣۣۢ"
            r1 = r0
            goto La
        L86:
            r0 = 9293(0x244d, float:1.3022E-41)
            java.lang.Object[] r6 = new java.lang.Object[r11]
            r6[r3] = r12
            java.lang.Object r0 = com.transsion.subroom.premium.C0672.n(r0, r5, r6)
            androidx.lifecycle.LifecycleCoroutineScope r0 = (androidx.view.LifecycleCoroutineScope) r0
            int r6 = androidx.core.C0078.m391()
            if (r6 < 0) goto L9e
            com.transsion.subroom.activity.C0667.m874()
            r6 = r0
            goto La
        L9e:
            java.lang.String r1 = "ۥۧۧ"
            r6 = r0
            goto La
        La3:
            java.lang.Integer r1 = new java.lang.Integer
            r0 = 8338367(0x7f3bbf, float:1.1684541E-38)
            r1.<init>(r0)
            java.lang.String r0 = "۠ۦۧ"
            r7 = r1
            r1 = r0
            goto La
        Lb1:
            java.lang.String r0 = "ۣ۠ۡ"
            r1 = r0
            goto La
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.N0():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 862
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void N1(com.transsion.home.bean.BottomTabItem r88, android.view.View r89, com.transsion.home.bean.BottomTabItem r90) {
        /*
            Method dump skipped, instructions count: 6532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.N1(com.transsion.home.bean.BottomTabItem, android.view.View, com.transsion.home.bean.BottomTabItem):void");
    }

    private final ILoginApi O0() {
        return (ILoginApi) C0689.n(43812, (Lazy) C0689.n(34288, this), new Object[0]);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0021. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0422 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0417 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x040c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0407 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x042e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x043a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x044f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x044a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x03e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x03d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x03d1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void O1(int r19, int r20) {
        /*
            Method dump skipped, instructions count: 1426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.O1(int, int):void");
    }

    private final du.b P0() {
        return (du.b) C0689.n(43812, (Lazy) C0689.n(42617, this), new Object[0]);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0037. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0562 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x055d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void P1(androidx.fragment.app.Fragment r31, java.lang.String r32) {
        /*
            Method dump skipped, instructions count: 1528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.P1(androidx.fragment.app.Fragment, java.lang.String):void");
    }

    private final com.transsion.usercenter.profile.f Q0() {
        return (com.transsion.usercenter.profile.f) C0689.n(43812, (Lazy) C0689.n(42683, this), new Object[0]);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x027d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0278 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x02cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x02c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0292 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x028d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void Q1(android.view.View r19, androidx.appcompat.widget.AppCompatTextView r20, androidx.appcompat.widget.AppCompatImageView r21, int r22) {
        /*
            Method dump skipped, instructions count: 868
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.Q1(android.view.View, androidx.appcompat.widget.AppCompatTextView, androidx.appcompat.widget.AppCompatImageView, int):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0182 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x01a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0194 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.fragment.app.Fragment R0(com.transsion.home.bean.BottomTabItem r13) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.R0(com.transsion.home.bean.BottomTabItem):androidx.fragment.app.Fragment");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0038. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:156:0x036b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x002f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0380 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x037b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x038b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x002f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03a6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void R1() {
        /*
            Method dump skipped, instructions count: 1112
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.R1():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x007c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0793 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x078a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x077c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0777 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x07bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x07ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x07d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x07cc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x076c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int S0(java.lang.String r47, int r48) {
        /*
            Method dump skipped, instructions count: 2248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.S0(java.lang.String, int):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0257 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x024f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.view.View S1(com.transsion.home.bean.BottomTabItem r25, com.google.android.material.tabs.TabLayout.TabView r26, com.transsion.home.bean.BottomTabItem r27) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.S1(com.transsion.home.bean.BottomTabItem, com.google.android.material.tabs.TabLayout$TabView, com.transsion.home.bean.BottomTabItem):android.view.View");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0185 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0017 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int T0(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.T0(java.lang.String):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x001a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int U0(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.U0(java.lang.String):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x006f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:194:0x075b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0756 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0700 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0730 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0715 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0710 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x06f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x06f0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void X0(java.util.List r46) {
        /*
            Method dump skipped, instructions count: 2084
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.X0(java.util.List):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0281 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x027c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void Y0() {
        /*
            Method dump skipped, instructions count: 754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.Y0():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0043. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:51:0x04a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x04a1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void Z0() {
        /*
            Method dump skipped, instructions count: 1298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.Z0():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0105, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0686.n(73581);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit a1(com.transsion.subroom.activity.MainActivity r16, aq.f r17) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.a1(com.transsion.subroom.activity.MainActivity, aq.f):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01e6, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0686.n(73581);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit b1(com.transsion.subroom.activity.MainActivity r17, cx.a r18) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.b1(com.transsion.subroom.activity.MainActivity, cx.a):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0122, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0686.n(73581);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v23, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit c1(com.transsion.subroom.activity.MainActivity r17, ak.n r18) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.c1(com.transsion.subroom.activity.MainActivity, ak.n):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0686.n(73581);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit d1(com.transsion.subroom.activity.MainActivity r18, vl.a r19) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.d1(com.transsion.subroom.activity.MainActivity, vl.a):kotlin.Unit");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    public static /* synthetic */ void e0(MainActivity mainActivity) {
        String str = "ۣۨۧ";
        String str2 = null;
        while (true) {
            switch (C0799.m1158((Object) str) ^ 56417) {
                case 1709357:
                    C0690.n(73771, null, new Object[]{mainActivity});
                    str = "ۣۡۡ";
                case 1710407:
                    str = "ۡۦۨ";
                case 1729956:
                    String str3 = (String) C0678.n(66211, null, new Object[]{(String) C0690.n(79171)});
                    if (C0079.m394() >= 0) {
                        C0079.m394();
                        str = "ۡۨۥ";
                        str2 = str3;
                    } else {
                        str = "ۢۥۥ";
                        str2 = str3;
                    }
                case 1731106:
                    if (((Integer) C0678.n(96887, null, new Object[0])).intValue() > 0) {
                        str = "ۡۦۨ";
                    } else if (C0066.m207() != 0) {
                        C0667.m874();
                    } else {
                        str = "ۤ۟۠";
                    }
                case 1732451:
                    C0678.n(66915, (PrintStream) C0678.n(82094), new Object[]{str2});
                    str = C0079.m394() >= 0 ? "ۣۢۧ" : "ۡۦۨ";
                case 1733278:
                    if (C0066.m207() != 0) {
                        C0078.m391();
                        str = "ۤۡۤ";
                    } else {
                        str = "ۣۨۧ";
                    }
                case 1733378:
                    break;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0095. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0b03 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0afb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0ab5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0aae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0b25 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0b20 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0ad2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0a87 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0af0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0aeb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0a65 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0a61 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0b13 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0b0f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0ac7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0ac2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void e1(java.util.List r55) {
        /*
            Method dump skipped, instructions count: 3116
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.e1(java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0691.n(85822, null, new java.lang.Object[]{r4, r5});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ kotlin.Unit f0(com.transsion.subroom.activity.MainActivity r4, aq.f r5) {
        /*
            java.lang.String r0 = "۠ۤۦ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 56295(0xdbe7, float:7.8886E-41)
            r1 = r1 ^ r2
            switch(r1) {
                case 1732741: goto Le;
                case 1735748: goto L22;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 85822(0x14f3e, float:1.20262E-40)
            r1 = 0
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            java.lang.Object r0 = com.transsion.subroom.premium.C0691.n(r0, r1, r2)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L22:
            int r1 = androidx.core.C0078.m391()
            if (r1 >= 0) goto L2
            java.lang.String r0 = "۠ۤۦ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.f0(com.transsion.subroom.activity.MainActivity, aq.f):kotlin.Unit");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0035. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0466 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0461 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void f1() {
        /*
            Method dump skipped, instructions count: 1210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.f1():void");
    }

    public static /* synthetic */ du.b g0() {
        return (du.b) C0691.n(29721, null, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c4, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0686.n(73581);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit g1(com.transsion.subroom.activity.MainActivity r15, android.widget.ImageView r16, cx.b r17) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.g1(com.transsion.subroom.activity.MainActivity, android.widget.ImageView, cx.b):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0691.n(92300, null, new java.lang.Object[]{r4, r5});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ kotlin.Unit h0(com.transsion.subroom.activity.MainActivity r4, com.transsion.home.bean.AppTab r5) {
        /*
            java.lang.String r0 = "ۣۡۥ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 56538(0xdcda, float:7.9227E-41)
            r1 = r1 ^ r2
            switch(r1) {
                case 1731229: goto Le;
                case 1735544: goto L22;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 92300(0x1688c, float:1.2934E-40)
            r1 = 0
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            java.lang.Object r0 = com.transsion.subroom.premium.C0691.n(r0, r1, r2)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L22:
            int r0 = androidx.core.C0079.m394()
            if (r0 < 0) goto L2b
            java.lang.String r0 = "۠۟۠"
            goto L2
        L2b:
            java.lang.String r0 = "ۣۡۥ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.h0(com.transsion.subroom.activity.MainActivity, com.transsion.home.bean.AppTab):kotlin.Unit");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0027. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:45:0x04c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x04c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void h1() {
        /*
            Method dump skipped, instructions count: 1320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.h1():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0691.n(40618, null, new java.lang.Object[]{r4, r5});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ kotlin.Unit i0(com.transsion.subroom.activity.MainActivity r4, ak.n r5) {
        /*
            java.lang.String r0 = "ۡ۠۟"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1752547(0x1abde3, float:2.455841E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 4931: goto Le;
                case 1728930: goto L22;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 40618(0x9eaa, float:5.6918E-41)
            r1 = 0
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            java.lang.Object r0 = com.transsion.subroom.premium.C0691.n(r0, r1, r2)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L22:
            java.lang.String r0 = "ۡ۠۟"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.i0(com.transsion.subroom.activity.MainActivity, ak.n):kotlin.Unit");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0060. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0635 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0655 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0650 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x06aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x06a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0660 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit i1(com.transsion.subroom.activity.MainActivity r42, com.transsion.home.bean.AppTab r43) {
        /*
            Method dump skipped, instructions count: 1924
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.i1(com.transsion.subroom.activity.MainActivity, com.transsion.home.bean.AppTab):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x011c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void initPlayer() {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.initPlayer():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void j0(com.transsion.subroom.activity.MainActivity r5, int r6, com.transsion.home.bean.BottomTabItem r7, android.view.View r8) {
        /*
            java.lang.String r0 = "ۧۦ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1748835(0x1aaf63, float:2.45064E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 5383: goto Le;
                case 27965: goto L38;
                case 1733564: goto Lf;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            return
        Lf:
            r0 = 67464(0x10788, float:9.4537E-41)
            r1 = 0
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r2[r3] = r4
            r3 = 2
            r2[r3] = r7
            r3 = 3
            r2[r3] = r8
            com.transsion.subroom.premium.C0691.n(r0, r1, r2)
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L35
            androidx.core.appcompat.C0066.m207()
            java.lang.String r0 = "ۣۣۧ"
            goto L2
        L35:
            java.lang.String r0 = "ۤۤۤ"
            goto L2
        L38:
            int r1 = com.transsion.subroom.activity.C0667.m874()
            if (r1 < 0) goto L42
            androidx.core.appcompat.C0066.m207()
            goto L2
        L42:
            java.lang.String r0 = "ۧۦ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.j0(com.transsion.subroom.activity.MainActivity, int, com.transsion.home.bean.BottomTabItem, android.view.View):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0085. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0abc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0a76 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0a86 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0a81 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit j1(com.transsion.subroom.activity.MainActivity r54, com.transsion.home.bean.AppTab r55) {
        /*
            Method dump skipped, instructions count: 3004
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.j1(com.transsion.subroom.activity.MainActivity, com.transsion.home.bean.AppTab):kotlin.Unit");
    }

    public static /* synthetic */ com.transsion.usercenter.profile.f k0(MainActivity mainActivity) {
        return (com.transsion.usercenter.profile.f) C0691.n(64694, null, new Object[]{mainActivity});
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0012. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x000a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void k1() {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.k1():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0024, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0691.n(72106, null, new java.lang.Object[]{r4, r5, r6});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ kotlin.Unit l0(com.transsion.subroom.activity.MainActivity r4, android.widget.ImageView r5, cx.b r6) {
        /*
            java.lang.String r0 = "ۣۢۨ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 56296(0xdbe8, float:7.8887E-41)
            r1 = r1 ^ r2
            switch(r1) {
                case 1730863: goto Le;
                case 1735916: goto L25;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 72106(0x119aa, float:1.01042E-40)
            r1 = 0
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r3 = 2
            r2[r3] = r6
            java.lang.Object r0 = com.transsion.subroom.premium.C0691.n(r0, r1, r2)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L25:
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 == 0) goto L31
            androidx.core.C0078.m391()
            java.lang.String r0 = "ۣۤ۟"
            goto L2
        L31:
            java.lang.String r0 = "ۣۢۨ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.l0(com.transsion.subroom.activity.MainActivity, android.widget.ImageView, cx.b):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void l1(final com.transsion.subroom.activity.MainActivity r8, final com.google.android.material.tabs.TabLayout.TabView r9) {
        /*
            r7 = 0
            java.lang.String r0 = "۟ۦۣ"
            r1 = r0
        L4:
            int r0 = gt.md.C0799.m1158(r1)
            r2 = 1754661(0x1ac625, float:2.458804E-39)
            r0 = r0 ^ r2
            switch(r0) {
                case 834: goto L10;
                case 24965: goto L5f;
                case 25081: goto L2a;
                case 31877: goto L1a;
                default: goto Lf;
            }
        Lf:
            goto L4
        L10:
            int r0 = androidx.core.C0078.m391()
            if (r0 < 0) goto L5b
            java.lang.String r0 = "ۦ۠ۤ"
            r1 = r0
            goto L4
        L1a:
            r0 = 56124(0xdb3c, float:7.8646E-41)
            com.transsion.usercenter.profile.f r1 = r8.Q0()
            java.lang.Object[] r2 = new java.lang.Object[r7]
            com.transsion.subroom.premium.C0691.n(r0, r1, r2)
            java.lang.String r0 = "۟ۤۥ"
            r1 = r0
            goto L4
        L2a:
            r2 = 48543(0xbd9f, float:6.8023E-41)
            r0 = 37225(0x9169, float:5.2163E-41)
            com.transsion.usercenter.profile.f r3 = r8.Q0()
            java.lang.Object[] r4 = new java.lang.Object[r7]
            java.lang.Object r0 = com.transsion.subroom.premium.C0686.n(r0, r3, r4)
            androidx.lifecycle.b0 r0 = (androidx.view.b0) r0
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r7] = r8
            r4 = 1
            com.transsion.subroom.activity.MainActivity$f r5 = new com.transsion.subroom.activity.MainActivity$f
            com.transsion.subroom.activity.o r6 = new com.transsion.subroom.activity.o
            r6.<init>()
            r5.<init>(r6)
            r3[r4] = r5
            com.transsion.subroom.premium.C0691.n(r2, r0, r3)
            int r0 = androidx.core.C0078.m391()
            if (r0 >= 0) goto L4
            java.lang.String r0 = "ۤۦۢ"
            r1 = r0
            goto L4
        L5b:
            java.lang.String r0 = "۟ۦۣ"
            r1 = r0
            goto L4
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.l1(com.transsion.subroom.activity.MainActivity, com.google.android.material.tabs.TabLayout$TabView):void");
    }

    public static /* synthetic */ Unit m0(MainActivity mainActivity) {
        return (Unit) C0691.n(39895, null, new Object[]{mainActivity});
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit m1(com.google.android.material.tabs.TabLayout.TabView r7, com.transsion.subroom.activity.MainActivity r8, java.lang.Integer r9) {
        /*
            r3 = 0
            r6 = 1
            r5 = 0
            java.lang.String r0 = "ۣۧۦ"
            r1 = r0
            r2 = r3
        L7:
            int r0 = gt.md.C0799.m1158(r1)
            r4 = 1750811(0x1ab71b, float:2.453409E-39)
            r0 = r0 ^ r4
            switch(r0) {
                case 446: goto L13;
                case 1511: goto L96;
                case 2427: goto L75;
                case 3418: goto L71;
                case 7295: goto La6;
                case 7634: goto L96;
                case 28956: goto L20;
                case 29264: goto L60;
                case 29329: goto L3f;
                case 30450: goto L8a;
                case 1731489: goto L6a;
                default: goto L12;
            }
        L12:
            goto L7
        L13:
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 == 0) goto L91
            androidx.core.appcompat.C0066.m207()
            java.lang.String r0 = "ۧۤۡ"
            r1 = r0
            goto L7
        L20:
            r0 = 99165(0x1835d, float:1.3896E-40)
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Object r0 = com.transsion.subroom.premium.C0678.n(r0, r9, r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r0 <= 0) goto L13
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 == 0) goto L3b
            com.transsion.subroom.activity.C0667.m874()
            goto L7
        L3b:
            java.lang.String r0 = "ۥۦۡ"
            r1 = r0
            goto L7
        L3f:
            r1 = 26421(0x6735, float:3.7024E-41)
            java.lang.Object[] r2 = new java.lang.Object[r6]
            r0 = 89325(0x15ced, float:1.25171E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0686.n(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2[r5] = r0
            java.lang.Object r0 = com.transsion.subroom.premium.C0688.n(r1, r7, r2)
            android.view.View r0 = (android.view.View) r0
            java.lang.String r1 = "ۦۤۧ"
            r2 = r0
            goto L7
        L60:
            r0 = 73581(0x11f6d, float:1.03109E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0686.n(r0)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L6a:
            r8.F0(r2)
            java.lang.String r0 = "ۧۡۥ"
            r1 = r0
            goto L7
        L71:
            java.lang.String r0 = "۠۟ۨ"
            r1 = r0
            goto L7
        L75:
            r0 = 73124(0x11da4, float:1.02469E-40)
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r5] = r2
            com.transsion.subroom.premium.C0689.n(r0, r3, r4)
            int r0 = androidx.core.C0078.m391()
            if (r0 >= 0) goto L7
            java.lang.String r0 = "ۣۤ۠"
            r1 = r0
            goto L7
        L8a:
            if (r2 == 0) goto L96
            java.lang.String r0 = "ۧۧۧ"
            r1 = r0
            goto L7
        L91:
            java.lang.String r0 = "ۦ۠"
            r1 = r0
            goto L7
        L96:
            int r0 = androidx.core.C0078.m391()
            if (r0 < 0) goto La1
            java.lang.String r0 = "ۥۢ۠"
            r1 = r0
            goto L7
        La1:
            java.lang.String r0 = "ۧۡۥ"
            r1 = r0
            goto L7
        La6:
            int r0 = com.transsion.subroom.activity.C0667.m874()
            if (r0 >= 0) goto L7
            java.lang.String r0 = "ۣۧۦ"
            r1 = r0
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.m1(com.google.android.material.tabs.TabLayout$TabView, com.transsion.subroom.activity.MainActivity, java.lang.Integer):kotlin.Unit");
    }

    public static /* synthetic */ Unit n0(MainActivity mainActivity) {
        return (Unit) C0691.n(99212, null, new Object[]{mainActivity});
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x01c7, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0686.n(73581);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit n1(com.transsion.subroom.activity.MainActivity r24) {
        /*
            Method dump skipped, instructions count: 990
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.n1(com.transsion.subroom.activity.MainActivity):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void o0(com.transsion.subroom.activity.MainActivity r4) {
        /*
            java.lang.String r0 = "ۣۡ۠"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1755593(0x1ac9c9, float:2.46011E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 25354: goto Le;
                case 26423: goto Lf;
                case 31496: goto L1f;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            return
        Lf:
            r0 = 76166(0x12986, float:1.06731E-40)
            r1 = 0
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            com.transsion.subroom.premium.C0691.n(r0, r1, r2)
            java.lang.String r0 = "۠۟ۢ"
            goto L2
        L1f:
            int r1 = androidx.core.appcompat.C0066.m207()
            if (r1 == 0) goto L29
            com.transsion.subroom.activity.C0667.m874()
            goto L2
        L29:
            java.lang.String r0 = "ۣۡ۠"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.o0(com.transsion.subroom.activity.MainActivity):void");
    }

    private static final ILoginApi o1() {
        return (ILoginApi) C0672.n(3250, null, new Object[]{ILoginApi.class, new Object[0]});
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0691.n(18082, null, new java.lang.Object[]{r4, r5});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ kotlin.Unit p0(com.transsion.subroom.activity.MainActivity r4, com.transsion.home.bean.AppTab r5) {
        /*
            java.lang.String r0 = "ۥۢۤ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 56482(0xdca2, float:7.9148E-41)
            r1 = r1 ^ r2
            switch(r1) {
                case 1728837: goto Le;
                case 1735619: goto L21;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 18082(0x46a2, float:2.5338E-41)
            r1 = 0
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            java.lang.Object r0 = com.transsion.subroom.premium.C0691.n(r0, r1, r2)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L21:
            int r1 = com.transsion.subroom.activity.C0667.m874()
            if (r1 >= 0) goto L2
            java.lang.String r0 = "ۥۢۤ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.p0(com.transsion.subroom.activity.MainActivity, com.transsion.home.bean.AppTab):kotlin.Unit");
    }

    private static final du.b p1() {
        return new du.b();
    }

    public static /* synthetic */ String q0(ILoginApi iLoginApi) {
        return (String) C0687.n(49747, null, new Object[]{iLoginApi});
    }

    private static final com.transsion.usercenter.profile.f q1(MainActivity mainActivity) {
        return (com.transsion.usercenter.profile.f) ((t0) C0687.n(40708, new v0(mainActivity), new Object[]{com.transsion.usercenter.profile.f.class}));
    }

    public static /* synthetic */ ILoginApi r0() {
        return (ILoginApi) C0687.n(74403, null, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0686.n(73581);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit r1(final com.transsion.subroom.activity.MainActivity r4) {
        /*
            java.lang.String r0 = "ۨۦۡ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1753544(0x1ac1c8, float:2.457239E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 2155: goto Le;
                case 28482: goto L21;
                case 32685: goto L2b;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 11662(0x2d8e, float:1.6342E-41)
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            com.transsion.subroom.activity.c r3 = new com.transsion.subroom.activity.c
            r3.<init>()
            r1[r2] = r3
            com.transsion.subroom.premium.C0687.n(r0, r4, r1)
            java.lang.String r0 = "ۡ۟ۨ"
            goto L2
        L21:
            r0 = 73581(0x11f6d, float:1.03109E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0686.n(r0)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L2b:
            int r1 = gt.md.C0799.m1162()
            if (r1 > 0) goto L35
            androidx.core.appcompat.C0066.m207()
            goto L2
        L35:
            java.lang.String r0 = "ۨۦۡ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.r1(com.transsion.subroom.activity.MainActivity):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0687.n(25586, null, new java.lang.Object[]{r4, r5, r6});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ kotlin.Unit s0(com.google.android.material.tabs.TabLayout.TabView r4, com.transsion.subroom.activity.MainActivity r5, java.lang.Integer r6) {
        /*
            java.lang.String r0 = "ۣۤۧ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1751712(0x1abaa0, float:2.454671E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 232: goto Le;
                case 32680: goto L24;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 25586(0x63f2, float:3.5854E-41)
            r1 = 0
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r3 = 2
            r2[r3] = r6
            java.lang.Object r0 = com.transsion.subroom.premium.C0687.n(r0, r1, r2)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L24:
            int r1 = androidx.core.C0078.m391()
            if (r1 >= 0) goto L2
            java.lang.String r0 = "ۣۤۧ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.s0(com.google.android.material.tabs.TabLayout$TabView, com.transsion.subroom.activity.MainActivity, java.lang.Integer):kotlin.Unit");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void s1(com.transsion.subroom.activity.MainActivity r8) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.s1(com.transsion.subroom.activity.MainActivity):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0687.n(32646, null, new java.lang.Object[]{r4, r5});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ kotlin.Unit t0(com.transsion.subroom.activity.MainActivity r4, vl.a r5) {
        /*
            java.lang.String r0 = "ۢۧ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 56293(0xdbe5, float:7.8883E-41)
            r1 = r1 ^ r2
            switch(r1) {
                case 1952: goto Le;
                case 1711618: goto L21;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 32646(0x7f86, float:4.5747E-41)
            r1 = 0
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            java.lang.Object r0 = com.transsion.subroom.premium.C0687.n(r0, r1, r2)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L21:
            int r1 = androidx.core.C0078.m391()
            if (r1 < 0) goto L2b
            gt.md.C0799.m1162()
            goto L2
        L2b:
            java.lang.String r0 = "ۢۧ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.t0(com.transsion.subroom.activity.MainActivity, vl.a):kotlin.Unit");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0277 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void t1(com.transsion.subroom.activity.MainActivity r20) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.t1(com.transsion.subroom.activity.MainActivity):void");
    }

    public static /* synthetic */ Unit u0(MainActivity mainActivity) {
        return (Unit) C0687.n(12440, null, new Object[]{mainActivity});
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0008 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.String u1(com.transsnet.loginapi.ILoginApi r8) {
        /*
            r7 = 0
            r3 = 0
            java.lang.String r0 = "ۨ۠۟"
            r1 = r0
            r2 = r3
            r4 = r3
            r5 = r3
        L8:
            int r0 = gt.md.C0799.m1158(r1)
            r6 = 1753702(0x1ac266, float:2.45746E-39)
            r0 = r0 ^ r6
            switch(r0) {
                case 2021: goto L14;
                case 2689: goto L23;
                case 26054: goto L75;
                case 26936: goto L87;
                case 27257: goto L4a;
                case 27929: goto L36;
                case 28899: goto L92;
                case 28965: goto L75;
                case 29018: goto L61;
                case 29934: goto L83;
                case 30073: goto L3a;
                case 32751: goto L29;
                case 1711774: goto L71;
                default: goto L13;
            }
        L13:
            goto L8
        L14:
            r0 = 62610(0xf492, float:8.7735E-41)
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.Object r0 = com.transsion.subroom.premium.C0687.n(r0, r5, r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "ۥۣ۟"
            r4 = r0
            goto L8
        L23:
            if (r8 == 0) goto L87
            java.lang.String r0 = "۟ۨۨ"
            r1 = r0
            goto L8
        L29:
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 == 0) goto L31
            r2 = r4
            goto L8
        L31:
            java.lang.String r0 = "ۡۧۥ"
            r1 = r0
            r2 = r4
            goto L8
        L36:
            java.lang.String r0 = "۟ۤۥ"
            r1 = r0
            goto L8
        L3a:
            int r0 = androidx.core.C0078.m391()
            if (r0 < 0) goto L45
            androidx.core.C0078.m391()
            r2 = r3
            goto L8
        L45:
            java.lang.String r0 = "ۢۡۤ"
            r1 = r0
            r2 = r3
            goto L8
        L4a:
            r0 = 71622(0x117c6, float:1.00364E-40)
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Object r0 = com.transsion.subroom.premium.C0687.n(r0, r8, r5)
            com.transsnet.loginapi.bean.UserInfo r0 = (com.transsnet.loginapi.bean.UserInfo) r0
            int r5 = androidx.core.C0079.m394()
            if (r5 < 0) goto L5d
            r5 = r0
            goto L8
        L5d:
            java.lang.String r1 = "ۢۧۡ"
            r5 = r0
            goto L8
        L61:
            if (r5 == 0) goto L87
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L6d
            java.lang.String r0 = "ۣۣۤ"
            r1 = r0
            goto L8
        L6d:
            java.lang.String r0 = "ۣۧ۟"
            r1 = r0
            goto L8
        L71:
            java.lang.String r0 = "ۣۨۤ"
            r1 = r0
            goto L8
        L75:
            int r0 = androidx.core.C0078.m391()
            if (r0 < 0) goto L7f
            androidx.core.C0078.m391()
            goto L8
        L7f:
            java.lang.String r0 = "ۢۡۤ"
            r1 = r0
            goto L8
        L83:
            java.lang.String r0 = "ۨ۠۟"
            r1 = r0
            goto L8
        L87:
            int r0 = androidx.core.C0078.m391()
            if (r0 >= 0) goto L8
            java.lang.String r0 = "ۨ۠"
            r1 = r0
            goto L8
        L92:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.u1(com.transsnet.loginapi.ILoginApi):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0687.n(34273, null, new java.lang.Object[]{r4, r5});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ kotlin.Unit v0(com.transsion.subroom.activity.MainActivity r4, cx.a r5) {
        /*
            java.lang.String r0 = "ۨ۠ۦ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1753482(0x1ac18a, float:2.457152E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 2404: goto Le;
                case 29644: goto L22;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 34273(0x85e1, float:4.8027E-41)
            r1 = 0
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            java.lang.Object r0 = com.transsion.subroom.premium.C0687.n(r0, r1, r2)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L22:
            int r1 = gt.md.C0799.m1162()
            if (r1 > 0) goto L2c
            androidx.core.C0078.m391()
            goto L2
        L2c:
            java.lang.String r0 = "ۨ۠ۦ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.v0(com.transsion.subroom.activity.MainActivity, cx.a):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x034d, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0686.n(73581);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit v1(android.content.Context r26, java.lang.String r27, java.lang.String r28, com.transsion.share.share.a r29) {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.v1(android.content.Context, java.lang.String, java.lang.String, com.transsion.share.share.a):kotlin.Unit");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
    public static /* synthetic */ void w0(MainActivity mainActivity, int i11, View view) {
        long j11 = 0;
        String str = "ۣ۠ۥ";
        while (true) {
            switch (C0799.m1158(str) ^ 1749792) {
                case 1288:
                    C0687.n(74769, null, new Object[]{mainActivity, Integer.valueOf(i11), view});
                    if (C0799.m1162() <= 0) {
                        C0066.m207();
                        str = "ۤۧۢ";
                    } else {
                        str = "۟ۦۤ";
                    }
                case 1344:
                    break;
                case 1441:
                    if (C0066.m207() != 0) {
                        C0667.m874();
                        str = "ۦۥۦ";
                    } else {
                        str = "ۣ۠ۥ";
                    }
                case 2406:
                    str = "ۣۢ۟";
                case 5373:
                    if (((Integer) C0680.n(61769, null, new Object[0])).intValue() == 0) {
                        str = "ۣۢ۟";
                    } else if (C0667.m874() < 0) {
                        str = "ۦۨۤ";
                    }
                case 28994:
                    j11 = ((Long) C0690.n(93647, null, new Object[]{(String) C0680.n(35573, null, new Object[]{(String) C0687.n(78334)})})).longValue();
                    if (C0066.m207() != 0) {
                        C0667.m874();
                        str = "ۣ۟۟";
                    } else {
                        str = "ۦ۟ۦ";
                    }
                case 29293:
                    C0690.n(82937, (PrintStream) C0678.n(82094), new Object[]{Long.valueOf(j11)});
                    str = C0799.m1162() <= 0 ? "ۡۢۦ" : "ۣۢ۟";
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x009a, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0686.n(73581);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit w1(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.w1(java.lang.String):kotlin.Unit");
    }

    public static /* synthetic */ Unit x0(String str) {
        return (Unit) C0687.n(13286, null, new Object[]{str});
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0024. Please report as an issue. */
    private final void x1() {
        IMemberApi iMemberApi;
        a.C0856a c0856a = null;
        Object[] objArr = null;
        short[] sArr = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        String str = null;
        short[] sArr2 = null;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        IMemberApi iMemberApi2 = null;
        Object obj = "۟ۤۡ";
        while (true) {
            switch (C0799.m1158(obj) ^ 1748679) {
                case 24:
                    short[] sArr3 = (short[]) C0675.n(38382);
                    int intValue = ((Integer) C0678.n(99165, (Integer) objArr[2], new Object[0])).intValue();
                    if (C0799.m1162() <= 0) {
                        C0078.m391();
                        i14 = intValue;
                        sArr2 = sArr3;
                        obj = "ۥ۟۟";
                    } else {
                        i14 = intValue;
                        sArr2 = sArr3;
                        obj = "ۣ۟ۧ";
                    }
                case 70:
                    objArr[5] = new Integer(4851106);
                    objArr[6] = new Integer(2984998);
                    if (C0667.m874() >= 0) {
                        C0667.m874();
                    } else {
                        obj = "۠۟ۢ";
                    }
                case 473:
                    G1();
                    if (((Boolean) C0687.n(20484, (tp.e) C0687.n(47795), new Object[]{this, (NoticePermissionFrom) C0687.n(76725)})).booleanValue()) {
                        obj = "ۣ۟ۤ";
                    } else if (C0799.m1162() <= 0) {
                        C0667.m874();
                    } else {
                        obj = "ۤۤۢ";
                    }
                case 1028:
                    objArr[0] = new Integer(88933);
                    objArr[2] = new Integer(5268265);
                    obj = "۠ۤۤ";
                case 1447:
                    objArr[3] = new Integer(8490667);
                    objArr[4] = new Integer(7262234);
                    if (C0078.m391() < 0) {
                        obj = "ۡۤ";
                    }
                case 2393:
                    IMemberApi iMemberApi3 = (IMemberApi) C0672.n(3250, null, new Object[]{IMemberApi.class, new Object[0]});
                    if (iMemberApi3 == null) {
                        iMemberApi = iMemberApi3;
                        obj = "ۨۦۨ";
                        iMemberApi2 = iMemberApi;
                    } else if (C0667.m874() >= 0) {
                        obj = "ۢۥ۟";
                        iMemberApi2 = iMemberApi3;
                    } else {
                        obj = "۟ۢۤ";
                        iMemberApi2 = iMemberApi3;
                    }
                case 2395:
                    Object[] objArr2 = new Object[7];
                    objArr2[1] = new Integer(8067397);
                    if (C0667.m874() >= 0) {
                        C0078.m391();
                        obj = "۠۠";
                        objArr = objArr2;
                    } else {
                        obj = "ۡ۟۟";
                        objArr = objArr2;
                    }
                case 2470:
                    C0687.n(37939, iMemberApi2, new Object[0]);
                    obj = "ۨۦۨ";
                case 4257:
                    iMemberApi = iMemberApi2;
                    obj = "ۨۦۨ";
                    iMemberApi2 = iMemberApi;
                case 4962:
                    C0686.n(93000, null, new Object[]{c0856a, str, (String) C0675.n(13983, null, new Object[]{sArr2, Integer.valueOf(((i15 ^ (-1)) & 8489043) | ((-8489044) & i15)), Integer.valueOf(((i16 ^ (-1)) & 7262209) | ((-7262210) & i16)), Integer.valueOf(((i14 ^ (-1)) & 5268804) | ((-5268805) & i14))}), false, Integer.valueOf(((i11 ^ (-1)) & 8067393) | ((-8067394) & i11)), null});
                    h1();
                    if (C0078.m391() < 0) {
                        obj = "ۧۡۥ";
                    }
                case 5285:
                    this.widgetDialogShowing = ((Boolean) C0687.n(43059, (com.transsion.mbwidget.d) C0687.n(38050), new Object[]{new Function0() { // from class: com.transsion.subroom.activity.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivity.u0(MainActivity.this);
                        }
                    }})).booleanValue();
                    if (C0078.m391() >= 0) {
                        C0066.m207();
                        obj = "ۣۨۤ";
                    } else {
                        obj = "ۣ۟ۤ";
                    }
                case 6339:
                    if (C0066.m207() == 0) {
                        obj = "۟ۤۡ";
                    }
                case 6348:
                    int intValue2 = ((Integer) C0678.n(99165, (Integer) objArr[3], new Object[0])).intValue();
                    int intValue3 = ((Integer) C0678.n(99165, (Integer) objArr[4], new Object[0])).intValue();
                    if (C0799.m1162() <= 0) {
                        i16 = intValue3;
                        i15 = intValue2;
                        obj = "۠۟ۢ";
                    } else {
                        i16 = intValue3;
                        i15 = intValue2;
                        obj = "ۥ۠۠";
                    }
                case 7237:
                    int intValue4 = ((Integer) C0678.n(99165, (Integer) objArr[5], new Object[0])).intValue();
                    i12 = ((Integer) C0678.n(99165, (Integer) objArr[6], new Object[0])).intValue();
                    i13 = intValue4;
                    obj = "ۦۡۥ";
                case 7341:
                    int intValue5 = ((Integer) C0678.n(99165, (Integer) objArr[1], new Object[0])).intValue();
                    short[] sArr4 = (short[]) C0675.n(38382);
                    if (C0078.m391() >= 0) {
                        C0078.m391();
                        sArr = sArr4;
                        i11 = intValue5;
                        obj = "ۤ۟ۡ";
                    } else {
                        sArr = sArr4;
                        i11 = intValue5;
                        obj = "ۢۡۡ";
                    }
                case 26403:
                    break;
                case 26477:
                    C0679.n(71757, (ox.e) C0679.n(64944, (e.a) C0679.n(13255), new Object[0]), new Object[0]);
                    if (C0079.m394() >= 0) {
                        C0066.m207();
                        obj = "ۤۧ۟";
                    } else {
                        obj = "ۨۨۤ";
                    }
                case 27532:
                    initPlayer();
                    C0687.n(34253, (FrameLayout) C0687.n(46610, (au.a) ((g4.a) C0675.n(5246, this, new Object[0]))), new Object[]{Integer.valueOf(((Integer) C0687.n(96541)).intValue())});
                    if (C0667.m874() < 0) {
                        obj = "ۡۤۡ";
                    }
                case 28493:
                    int intValue6 = ((Integer) C0678.n(99165, (Integer) objArr[0], new Object[0])).intValue();
                    String str2 = (String) C0684.n(75978, null, new Object[]{sArr, Integer.valueOf(((i12 ^ (-1)) & 2984650) | ((-2984651) & i12)), Integer.valueOf((intValue6 & (-88938)) | ((intValue6 ^ (-1)) & 88937)), Integer.valueOf(((i13 ^ (-1)) & 4851506) | ((-4851507) & i13))});
                    if (C0079.m394() >= 0) {
                        obj = "ۣ۠ۧ";
                        str = str2;
                    } else {
                        obj = "ۡۢ۠";
                        str = str2;
                    }
                case 1733149:
                    obj = "ۣ۟ۤ";
                case 1733348:
                    a.C0856a c0856a2 = (a.C0856a) C0675.n(72288);
                    if (C0066.m207() != 0) {
                        obj = "ۥۡۢ";
                        c0856a = c0856a2;
                    } else {
                        obj = "ۢ۠ۨ";
                        c0856a = c0856a2;
                    }
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void y0(com.transsion.subroom.activity.MainActivity r4, com.google.android.material.tabs.TabLayout.TabView r5) {
        /*
            java.lang.String r0 = "۠ۡۨ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1755592(0x1ac9c8, float:2.460108E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 25295: goto Le;
                case 28182: goto L2f;
                case 1709482: goto L20;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 31056(0x7950, float:4.3519E-41)
            r1 = 0
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            com.transsion.subroom.premium.C0679.n(r0, r1, r2)
            java.lang.String r0 = "۟ۦۥ"
            goto L2
        L20:
            int r0 = androidx.core.C0079.m394()
            if (r0 < 0) goto L2c
            androidx.core.C0079.m394()
            java.lang.String r0 = "ۤۧ۠"
            goto L2
        L2c:
            java.lang.String r0 = "۠ۡۨ"
            goto L2
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.y0(com.transsion.subroom.activity.MainActivity, com.google.android.material.tabs.TabLayout$TabView):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Unit y1(com.transsion.subroom.activity.MainActivity r3) {
        /*
            java.lang.String r0 = "ۣۨۧ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1751773(0x1abadd, float:2.454757E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 157: goto Le;
                case 1274: goto L3c;
                case 3073: goto L23;
                case 3527: goto L2d;
                case 3583: goto L4e;
                case 4811: goto L11;
                case 5243: goto L5e;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            java.lang.String r0 = "ۣۨۧ"
            goto L2
        L11:
            r0 = 70454(0x11336, float:9.8727E-41)
            java.lang.Object r0 = com.transsion.subroom.premium.C0679.n(r0, r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L5e
            java.lang.String r0 = "ۥۤۦ"
            goto L2
        L23:
            r0 = 73581(0x11f6d, float:1.03109E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0686.n(r0)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L2d:
            r3.H0()
            int r0 = com.transsion.subroom.activity.C0667.m874()
            if (r0 < 0) goto L39
            java.lang.String r0 = "ۥۣۨ"
            goto L2
        L39:
            java.lang.String r0 = "ۣۦ۟"
            goto L2
        L3c:
            r0 = 1
            r3.kidsDialogShown = r0
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L4b
            androidx.core.C0079.m394()
            java.lang.String r0 = "ۢۧۤ"
            goto L2
        L4b:
            java.lang.String r0 = "ۣۨ۟"
            goto L2
        L4e:
            r1 = 0
            r3.widgetDialogShowing = r1
            int r1 = gt.md.C0799.m1162()
            if (r1 > 0) goto L5b
            androidx.core.appcompat.C0066.m207()
            goto L2
        L5b:
            java.lang.String r0 = "۟ۨ۟"
            goto L2
        L5e:
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L6a
            gt.md.C0799.m1162()
            java.lang.String r0 = "ۨۤۨ"
            goto L2
        L6a:
            java.lang.String r0 = "ۣۦ۟"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.y1(com.transsion.subroom.activity.MainActivity):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0027, code lost:
    
        return (kotlin.Unit) com.transsion.subroom.premium.C0679.n(97669, null, new java.lang.Object[]{r4, r5, r6, r7});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ kotlin.Unit z0(android.content.Context r4, java.lang.String r5, java.lang.String r6, com.transsion.share.share.a r7) {
        /*
            java.lang.String r0 = "ۣ۟ۧ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1754383(0x1ac50f, float:2.458414E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 25332: goto Le;
                case 27561: goto L28;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r0 = 97669(0x17d85, float:1.36863E-40)
            r1 = 0
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r3 = 2
            r2[r3] = r6
            r3 = 3
            r2[r3] = r7
            java.lang.Object r0 = com.transsion.subroom.premium.C0679.n(r0, r1, r2)
            kotlin.Unit r0 = (kotlin.Unit) r0
            return r0
        L28:
            int r1 = gt.md.C0799.m1162()
            if (r1 <= 0) goto L2
            java.lang.String r0 = "ۣ۟ۧ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.z0(android.content.Context, java.lang.String, java.lang.String, com.transsion.share.share.a):kotlin.Unit");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 579
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void z1(com.google.android.material.tabs.TabLayout.Tab r62) {
        /*
            Method dump skipped, instructions count: 4172
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.z1(com.google.android.material.tabs.TabLayout$Tab):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0198, code lost:
    
        return r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public au.a V0() {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.V0():au.a");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    public final void W0() {
        boolean z10 = false;
        SecondFloorHelper secondFloorHelper = null;
        Object obj = "ۥ۠ۤ";
        while (true) {
            switch (C0799.m1158(obj) ^ 1750533) {
                case 101:
                    break;
                case 2052:
                    z10 = ((Boolean) C0679.n(7055, secondFloorHelper, new Object[0])).booleanValue();
                    if (C0079.m394() >= 0) {
                        C0078.m391();
                    } else {
                        obj = "ۡۧ۟";
                    }
                case 2988:
                    secondFloorHelper = new SecondFloorHelper((au.a) ((g4.a) C0675.n(5246, this, new Object[0])));
                    if (C0667.m874() < 0) {
                        obj = "ۣ۠ۡ";
                    }
                case 3235:
                    this.isColdStart = false;
                    if (C0066.m207() == 0) {
                        obj = "ۣۢ۟";
                    }
                case 6524:
                    this.shouldShowGuide = z10;
                    if (C0066.m207() != 0) {
                        C0078.m391();
                    } else {
                        obj = "ۦۥۧ";
                    }
                case 7431:
                    this.secondFloorHelper = secondFloorHelper;
                    if (C0078.m391() >= 0) {
                        C0799.m1162();
                        obj = "ۦۢۦ";
                    } else {
                        obj = "ۥۣ۟";
                    }
                case 29709:
                    if (z10) {
                        obj = "ۣۢ۟";
                    } else if (C0667.m874() >= 0) {
                        C0799.m1162();
                    } else {
                        obj = "ۤۦۨ";
                    }
                case 32647:
                    obj = "ۣۢ۟";
                case 32717:
                    if (C0079.m394() >= 0) {
                        C0667.m874();
                    } else {
                        obj = "ۥ۠ۤ";
                    }
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004f A[SYNTHETIC] */
    @Override // com.transsion.baseui.activity.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void changeStatusFontColor(boolean r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "۠ۦۡ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1754562(0x1ac5c2, float:2.458665E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 3174: goto Le;
                case 3311: goto L40;
                case 27289: goto L52;
                case 27324: goto L22;
                case 27488: goto L31;
                case 28249: goto L17;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            int r0 = androidx.core.C0079.m394()
            if (r0 < 0) goto L4f
            java.lang.String r0 = "۟ۦ۠"
            goto L2
        L17:
            if (r5 == 0) goto Le
            int r1 = gt.md.C0799.m1162()
            if (r1 <= 0) goto L2
            java.lang.String r0 = "ۡ۠ۡ"
            goto L2
        L22:
            super.changeStatusFontColor(r4, r5)
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L2e
            java.lang.String r0 = "۠ۧ"
            goto L2
        L2e:
            java.lang.String r0 = "ۡۦ۠"
            goto L2
        L31:
            r3.mHomeStatusWhite = r4
            int r1 = androidx.core.C0078.m391()
            if (r1 < 0) goto L3d
            com.transsion.subroom.activity.C0667.m874()
            goto L2
        L3d:
            java.lang.String r0 = "ۡۧۤ"
            goto L2
        L40:
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L4c
            gt.md.C0799.m1162()
            java.lang.String r0 = "۠ۦۨ"
            goto L2
        L4c:
            java.lang.String r0 = "۠ۦۡ"
            goto L2
        L4f:
            java.lang.String r0 = "ۡۧۤ"
            goto L2
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.changeStatusFontColor(boolean, boolean):void");
    }

    @Override // com.transsion.home.preload.a
    public com.transsion.home.preload.b d() {
        return (com.transsion.home.preload.b) C0679.n(83024, this);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        com.transsion.home.view.g gVar = null;
        String str = "ۦۧۦ";
        while (true) {
            switch (C0799.m1158((Object) str) ^ 1748829) {
                case 2:
                    break;
                case 1123:
                    str = "ۢۨۨ";
                    gVar = (com.transsion.home.view.g) C0679.n(73916);
                case 7168:
                    C0679.n(89717, gVar, new Object[]{true});
                    if (C0078.m391() >= 0) {
                        C0667.m874();
                        str = "ۣۥۥ";
                    } else {
                        str = "ۡۦۤ";
                    }
                case 7231:
                    if (((Boolean) C0679.n(73980, gVar, new Object[0])).booleanValue()) {
                        str = "ۡۦۤ";
                    } else if (C0078.m391() >= 0) {
                        C0066.m207();
                    } else {
                        str = "ۣۢۨ";
                    }
                case 7292:
                    if (((Integer) C0684.n(93270, event, new Object[0])).intValue() != 0) {
                        str = "ۡۦۤ";
                    } else if (C0079.m394() < 0) {
                        str = "ۣ۠ۡ";
                    }
                case 26242:
                    str = "ۡۦۤ";
                case 26265:
                    str = "ۦۧۦ";
                case 27928:
                    if (event == null) {
                        str = "ۡۦۤ";
                    } else if (C0078.m391() >= 0) {
                        C0066.m207();
                    } else {
                        str = "ۢۦۥ";
                    }
            }
            return super.dispatchTouchEvent(event);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0017. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00f3 A[SYNTHETIC] */
    @Override // com.transsion.baseui.activity.BaseMusicFloatActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getTipViewBottomMargin() {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.getTipViewBottomMargin():int");
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public /* bridge */ /* synthetic */ g4.a getViewBinding() {
        return (au.a) C0679.n(31641, this, new Object[0]);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0008 A[SYNTHETIC] */
    @Override // com.transsion.baseui.activity.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean hasAd() {
        /*
            r7 = this;
            r3 = 0
            r1 = 0
            java.lang.String r0 = "ۣۨۤ"
            r2 = r3
            r4 = r3
            r5 = r1
            r1 = r0
        L8:
            int r0 = gt.md.C0799.m1158(r1)
            r6 = 1753449(0x1ac169, float:2.457105E-39)
            r0 = r0 ^ r6
            switch(r0) {
                case 1029: goto L14;
                case 1230: goto L36;
                case 2080: goto L21;
                case 2464: goto L90;
                case 26216: goto L51;
                case 28203: goto L57;
                case 29225: goto L40;
                case 29441: goto L9b;
                case 31562: goto L80;
                case 31692: goto L80;
                case 1711378: goto L67;
                case 1711606: goto La6;
                default: goto L13;
            }
        L13:
            goto L8
        L14:
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 == 0) goto L1c
            r2 = r3
            goto L8
        L1c:
            java.lang.String r0 = "ۥۤ"
            r1 = r0
            r2 = r3
            goto L8
        L21:
            r0 = 92692(0x16a14, float:1.29889E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0679.n(r0, r7)
            com.transsion.subroom.activity.SecondFloorHelper r0 = (com.transsion.subroom.activity.SecondFloorHelper) r0
            int r5 = androidx.core.appcompat.C0066.m207()
            if (r5 == 0) goto L32
            r5 = r0
            goto L8
        L32:
            java.lang.String r1 = "۟۟ۡ"
            r5 = r0
            goto L8
        L36:
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 != 0) goto L8
            java.lang.String r0 = "ۤۦۧ"
            r1 = r0
            goto L8
        L40:
            int r0 = androidx.core.C0079.m394()
            if (r0 < 0) goto L4d
            gt.md.C0799.m1162()
            java.lang.String r0 = "ۧ۟ۢ"
            r1 = r0
            goto L8
        L4d:
            java.lang.String r0 = "ۧۢۧ"
            r1 = r0
            goto L8
        L51:
            if (r5 == 0) goto L9b
            java.lang.String r0 = "ۤ۟"
            r1 = r0
            goto L8
        L57:
            int r0 = com.transsion.subroom.activity.C0667.m874()
            if (r0 < 0) goto L62
            androidx.core.C0078.m391()
            r2 = r4
            goto L8
        L62:
            java.lang.String r0 = "ۧۤۤ"
            r1 = r0
            r2 = r4
            goto L8
        L67:
            r0 = 38794(0x978a, float:5.4362E-41)
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.Object r0 = com.transsion.subroom.premium.C0679.n(r0, r5, r4)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r4 = r0.booleanValue()
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 != 0) goto L8
            java.lang.String r0 = "ۡۥۦ"
            r1 = r0
            goto L8
        L80:
            int r0 = com.transsion.subroom.activity.C0667.m874()
            if (r0 < 0) goto L8b
            java.lang.String r0 = "ۣ۟ۦ"
            r1 = r0
            goto L8
        L8b:
            java.lang.String r0 = "ۥۤ"
            r1 = r0
            goto L8
        L90:
            int r0 = com.transsion.subroom.activity.C0667.m874()
            if (r0 >= 0) goto L8
            java.lang.String r0 = "ۣۨۤ"
            r1 = r0
            goto L8
        L9b:
            int r0 = com.transsion.subroom.activity.C0667.m874()
            if (r0 >= 0) goto L8
            java.lang.String r0 = "ۢۧۥ"
            r1 = r0
            goto L8
        La6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.hasAd():boolean");
    }

    @Override // vl.b
    public boolean i() {
        return ((Boolean) C0672.n(82549, this)).booleanValue();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseMusicFloatActivity
    public boolean isShowMemberPushViewTip() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0017. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x000f A[SYNTHETIC] */
    @Override // com.transsion.baseui.activity.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadTwoLevelAd() {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.loadTwoLevelAd():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0017. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01cb A[SYNTHETIC] */
    @Override // com.transsion.baseui.activity.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAction(java.lang.String r19, float r20, float r21) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.onAction(java.lang.String, float, float):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        return;
     */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r7, int r8, android.content.Intent r9) {
        /*
            r6 = this;
            java.lang.String r0 = "ۥۦۢ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1746694(0x1aa706, float:2.44764E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 187: goto Le;
                case 6503: goto L35;
                case 25891: goto L3e;
                case 28651: goto L4a;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r1 = 6049(0x17a1, float:8.476E-42)
            du.b r2 = r6.P0()
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r3[r4] = r5
            r4 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r3[r4] = r5
            r4 = 2
            r3[r4] = r9
            com.transsion.subroom.premium.C0679.n(r1, r2, r3)
            int r1 = androidx.core.appcompat.C0066.m207()
            if (r1 == 0) goto L3b
            androidx.core.appcompat.C0066.m207()
            goto L2
        L35:
            super.onActivityResult(r7, r8, r9)
            java.lang.String r0 = "۟ۥۣ"
            goto L2
        L3b:
            java.lang.String r0 = "ۨ۠ۥ"
            goto L2
        L3e:
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L47
            java.lang.String r0 = "۠۟۟"
            goto L2
        L47:
            java.lang.String r0 = "ۥۦۢ"
            goto L2
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0050. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x05d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x05d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x05e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x05e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x05c7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x05b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x05c1 A[SYNTHETIC] */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBackPressed() {
        /*
            Method dump skipped, instructions count: 1678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.onBackPressed():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0019. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:134:0x025d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0255 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0268 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0011 A[SYNTHETIC] */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onConfigurationChanged(android.content.res.Configuration r20) {
        /*
            Method dump skipped, instructions count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.onConfigurationChanged(android.content.res.Configuration):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0086. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0bc5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0bc0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0b77 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0bb0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0ba8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0b91 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0b88 A[SYNTHETIC] */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r54) {
        /*
            Method dump skipped, instructions count: 3196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0012. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0287 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0297 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x000a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x028c A[SYNTHETIC] */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDestroy() {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.onDestroy():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0017. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0224 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021f A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.lang.Object[]] */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onNewIntent(android.content.Intent r18) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.onNewIntent(android.content.Intent):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001f. Please report as an issue. */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Object[] objArr = null;
        short[] sArr = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        short[] sArr2 = null;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        Integer num = null;
        String str = "ۣ۟ۡ";
        while (true) {
            switch (C0799.m1158((Object) str) ^ 56571) {
                case 34:
                    str = "ۣۨ۠";
                    num = (Integer) C0675.n(69214, null, new Object[]{(String) C0678.n(66211, null, new Object[]{(String) C0673.n(82661)})});
                case 1709433:
                    objArr[5] = new Integer(5459018);
                    if (C0066.m207() != 0) {
                        C0066.m207();
                    } else {
                        str = "ۥۤۧ";
                    }
                case 1709463:
                    C0690.n(97686, null, new Object[]{grantResults, (String) C0675.n(18203, null, new Object[]{sArr2, Integer.valueOf(((i15 ^ (-1)) & 1752766) | ((-1752767) & i15)), Integer.valueOf(((i16 ^ (-1)) & 9117052) | ((-9117053) & i16)), Integer.valueOf(((i14 ^ (-1)) & 4405684) | ((-4405685) & i14))})});
                    if (C0667.m874() < 0) {
                        str = "ۦۤۤ";
                    }
                case 1709502:
                    C0678.n(5185, (PrintStream) C0678.n(82094), new Object[]{num});
                    if (C0078.m391() >= 0) {
                        C0799.m1162();
                        str = "۠ۢۢ";
                    } else {
                        str = "ۧۨۢ";
                    }
                case 1709558:
                    objArr[1] = new Integer(444137);
                    str = "ۨۥ۟";
                case 1710416:
                    objArr[0] = new Integer(9117040);
                    if (C0667.m874() >= 0) {
                        C0078.m391();
                    } else {
                        str = "ۣ۟ۨ";
                    }
                case 1710810:
                    break;
                case 1711379:
                    objArr[4] = new Integer(1750532);
                    str = "ۧۤۨ";
                case 1711389:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                    str = C0079.m394() >= 0 ? "ۣۤۢ" : "ۥۥۡ";
                case 1711505:
                    C0690.n(97686, null, new Object[]{permissions, (String) C0675.n(18203, null, new Object[]{sArr, Integer.valueOf(((i12 ^ (-1)) & 446022) | ((-446023) & i12)), Integer.valueOf(((i13 ^ (-1)) & 5459009) | ((-5459010) & i13)), Integer.valueOf(((i11 ^ (-1)) & 1405875) | ((-1405876) & i11))})});
                    str = C0066.m207() != 0 ? "ۢۨ۟" : "ۣۤۤ";
                case 1711507:
                    if (C0078.m391() >= 0) {
                        C0079.m394();
                    } else {
                        str = "ۣۤۤ";
                    }
                case 1711769:
                    str = "ۧۨۢ";
                case 1711858:
                    i15 = ((Integer) C0678.n(99165, (Integer) objArr[4], new Object[0])).intValue();
                    str = "۟ۧۤ";
                case 1728786:
                    objArr[3] = new Integer(1406633);
                    if (C0799.m1162() > 0) {
                        str = "ۨۡۦ";
                    }
                case 1729210:
                    if (((Integer) C0678.n(46727, null, new Object[0])).intValue() < 0) {
                        str = "ۧۨۢ";
                    } else if (C0799.m1162() <= 0) {
                        C0078.m391();
                        str = "ۣۥۦ";
                    } else {
                        str = "ۧ۠";
                    }
                case 1729214:
                    if (C0799.m1162() <= 0) {
                        C0066.m207();
                    } else {
                        str = "ۣ۟ۡ";
                    }
                case 1729235:
                    objArr[2] = new Integer(4406865);
                    str = C0078.m391() >= 0 ? "ۨۤۢ" : "ۦۤۦ";
                case 1730170:
                    i12 = ((Integer) C0678.n(99165, (Integer) objArr[1], new Object[0])).intValue();
                    if (C0066.m207() == 0) {
                        str = "ۣۥۨ";
                    }
                case 1730200:
                    short[] sArr3 = (short[]) C0675.n(38382);
                    if (C0799.m1162() <= 0) {
                        C0079.m394();
                        str = "ۤۦ";
                        sArr2 = sArr3;
                    } else {
                        str = "ۢۧۢ";
                        sArr2 = sArr3;
                    }
                case 1731133:
                    i13 = ((Integer) C0678.n(99165, (Integer) objArr[5], new Object[0])).intValue();
                    if (C0078.m391() >= 0) {
                        C0799.m1162();
                    } else {
                        str = "ۦ۠ۤ";
                    }
                case 1731160:
                    short[] sArr4 = (short[]) C0675.n(38382);
                    if (C0799.m1162() <= 0) {
                        sArr = sArr4;
                    } else {
                        str = "ۢۨۨ";
                        sArr = sArr4;
                    }
                case 1732210:
                    if (C0667.m874() >= 0) {
                        C0078.m391();
                        str = "ۧۢۨ";
                    } else {
                        str = "۟۠ۦ";
                    }
                case 1732505:
                    i11 = ((Integer) C0678.n(99165, (Integer) objArr[3], new Object[0])).intValue();
                    str = "ۤۥۢ";
                case 1732550:
                    i14 = ((Integer) C0678.n(99165, (Integer) objArr[2], new Object[0])).intValue();
                    str = "ۦۥۨ";
                case 1735431:
                    int intValue = ((Integer) C0678.n(99165, (Integer) objArr[0], new Object[0])).intValue();
                    if (C0066.m207() != 0) {
                        C0066.m207();
                        i16 = intValue;
                        str = "ۣ۟ۧ";
                    } else {
                        i16 = intValue;
                        str = "ۨۤۨ";
                    }
                case 1735551:
                    str = "ۢۡۨ";
                case 1735558:
                    objArr = new Object[6];
                    if (C0079.m394() >= 0) {
                        C0667.m874();
                    } else {
                        str = "ۥۢۦ";
                    }
                case 1735646:
                    if (C0066.m207() != 0) {
                        C0078.m391();
                    } else {
                        str = "ۦ۠ۢ";
                    }
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0133 A[SYNTHETIC] */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.onResume():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0029. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0467 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0462 A[SYNTHETIC] */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSaveInstanceState(android.os.Bundle r28) {
        /*
            Method dump skipped, instructions count: 1212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.onSaveInstanceState(android.os.Bundle):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004a A[SYNTHETIC] */
    @Override // com.transsion.baseui.activity.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setStateCallback(kotlin.jvm.functions.Function1 r6) {
        /*
            r5 = this;
            r1 = 0
            java.lang.String r0 = "ۤۧۨ"
        L3:
            int r2 = gt.md.C0799.m1158(r0)
            r3 = 1748708(0x1aaee4, float:2.450462E-39)
            r2 = r2 ^ r3
            switch(r2) {
                case 1: goto Lf;
                case 5153: goto L29;
                case 7170: goto L1b;
                case 7227: goto L4d;
                case 26407: goto L3d;
                case 27808: goto L38;
                default: goto Le;
            }
        Le:
            goto L3
        Lf:
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L4a
            androidx.core.appcompat.C0066.m207()
            java.lang.String r0 = "ۦۧۢ"
            goto L3
        L1b:
            r0 = 32686(0x7fae, float:4.5803E-41)
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r6
            com.transsion.subroom.premium.C0673.n(r0, r1, r2)
            java.lang.String r0 = "ۢۤۡ"
            goto L3
        L29:
            r0 = 92692(0x16a14, float:1.29889E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0679.n(r0, r5)
            com.transsion.subroom.activity.SecondFloorHelper r0 = (com.transsion.subroom.activity.SecondFloorHelper) r0
            java.lang.String r1 = "ۦۧۥ"
            r4 = r1
            r1 = r0
            r0 = r4
            goto L3
        L38:
            if (r1 == 0) goto Lf
            java.lang.String r0 = "ۢۤۨ"
            goto L3
        L3d:
            int r2 = androidx.core.C0079.m394()
            if (r2 < 0) goto L47
            androidx.core.appcompat.C0066.m207()
            goto L3
        L47:
            java.lang.String r0 = "ۤۧۨ"
            goto L3
        L4a:
            java.lang.String r0 = "ۢۤۡ"
            goto L3
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.MainActivity.setStateCallback(kotlin.jvm.functions.Function1):void");
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public int statusColor() {
        return ((Integer) C0688.n(64056)).intValue();
    }
}
