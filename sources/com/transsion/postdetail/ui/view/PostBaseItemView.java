package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.view.LifecycleCoroutineScope;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.NoScrollRecyclerView2;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$drawable;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.bean.CommentBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.bean.CommentLikeBody;
import com.transsion.postdetail.helper.NegativeFeedbackHelper;
import com.transsion.postdetail.ui.adapter.RoomPostContentImageAdapter;
import com.transsion.postdetail.video.PostFeedVideoView;
import com.transsion.postdetail.viewmodel.CommentViewModel;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b$\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u001f\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b \u0010\u0013J\u0017\u0010!\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b!\u0010\u0013J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\"\u0010\u0013J+\u0010&\u001a\u00020\f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0002¢\u0006\u0004\b&\u0010'J'\u0010*\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0#2\b\u0010)\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b*\u0010+J'\u0010-\u001a\u00020\f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0#2\b\u0010)\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b-\u0010+J'\u0010/\u001a\u00020\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0#2\b\u0010)\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b/\u0010+J'\u00101\u001a\u00020\f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0#2\b\u0010)\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b1\u0010+J\u001d\u00103\u001a\u00020\f2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\fH\u0014¢\u0006\u0004\b5\u0010\u000eJ\u0011\u00107\u001a\u0004\u0018\u000106H\u0004¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J!\u0010?\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010\u001c2\b\u0010>\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\bA\u0010\u0013J\u0015\u0010D\u001a\u00020\f2\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ!\u0010H\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bH\u0010IJ\u001f\u0010L\u001a\u00020\f2\u0006\u0010J\u001a\u00020F2\u0006\u0010K\u001a\u00020FH\u0016¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\bN\u0010\u0013J\u0015\u0010Q\u001a\u00020\f2\u0006\u0010P\u001a\u00020O¢\u0006\u0004\bQ\u0010RJ\u0097\u0001\u0010T\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0#2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\f0#2\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\f0#2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0#2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0#2\u000e\b\u0002\u0010S\u001a\b\u0012\u0004\u0012\u00020\f0#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0#2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0#¢\u0006\u0004\bT\u0010UJ'\u0010V\u001a\u00020\f2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\f0#2\b\u0010)\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\bV\u0010+J\r\u0010W\u001a\u00020\f¢\u0006\u0004\bW\u0010\u000eJ\u0015\u0010Y\u001a\u00020\f2\u0006\u0010X\u001a\u00020F¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b[\u0010\u0013J\u001d\u0010]\u001a\u00020\f2\u0006\u0010\\\u001a\u00020F2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b_\u0010\u0013J\u0017\u0010`\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b`\u0010\u0013R\u001a\u0010d\u001a\u00020\t8\u0004X\u0084\u0004¢\u0006\f\n\u0004\ba\u0010\u001e\u001a\u0004\bb\u0010cR\u001a\u0010g\u001a\u00020\t8\u0004X\u0084\u0004¢\u0006\f\n\u0004\be\u0010\u001e\u001a\u0004\bf\u0010cR\u001a\u0010j\u001a\u00020\t8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bh\u0010\u001e\u001a\u0004\bi\u0010cR\u0014\u0010l\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010\u001eR\u0014\u0010n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010\u001eR\u0014\u0010p\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010\u001eR\u001a\u0010v\u001a\u00020q8\u0004X\u0084\u0004¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010{\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010X\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R(\u0010=\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R)\u0010>\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\b\u0084\u0001\u0010\u007f\u001a\u0006\b\u0085\u0001\u0010\u0081\u0001\"\u0006\b\u0086\u0001\u0010\u0083\u0001R\u001a\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010\u007fR\u001a\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010\u007fR0\u0010\u0090\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0005\b\u008f\u0001\u00104R0\u0010\u0094\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0091\u0001\u0010\u008c\u0001\u001a\u0006\b\u0092\u0001\u0010\u008e\u0001\"\u0005\b\u0093\u0001\u00104¨\u0006\u0095\u0001"}, d2 = {"Lcom/transsion/postdetail/ui/view/PostBaseItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "G", "()V", "V", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", WebConstants.FIELD_ITEM, "setBottomDownLoadStatus", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "setPostContent", "setPostContentDes", "setHotComment", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "hotComment", "F", "(Lcom/transsion/moviedetailapi/bean/CommentBean;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "H", "", "moduleName", "I", "(Ljava/lang/String;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "setBottomBarContent", "setPostImage", "setPostVideo", "Lkotlin/Function0;", "onCLickHeader", "onClickNegativeFeedback", "c0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onCLickGroup", "postSubjectItem", "i0", "(Lkotlin/jvm/functions/Function0;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "onCLickSubject", "m0", "onCLickLike", "g0", "onCLickComment", "Y", "onCLickShare", "k0", "(Lkotlin/jvm/functions/Function0;)V", "onAttachedToWindow", "Landroidx/fragment/app/FragmentActivity;", "E", "()Landroidx/fragment/app/FragmentActivity;", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "viewModel", "setCommentViewModel", "(Lcom/transsion/postdetail/viewmodel/CommentViewModel;)V", "pageName", "pageFrom", "setPage", "(Ljava/lang/String;Ljava/lang/String;)V", "setData", "Landroidx/recyclerview/widget/RecyclerView$s;", "rvPool", "setRecycledViewPool", "(Landroidx/recyclerview/widget/RecyclerView$s;)V", "", "showDistance", "setHeaderPostData", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Z)V", "isShowSubject", "isShowRoom", "setBottomSubjectAndRoomVisibility", "(ZZ)V", "setBottomSubjectModuleData", "", "count", "setCommentCount", "(J)V", "onClickDownload", "setBottomBarClick", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "a0", "setContentMaxLine", "isDetail", "setIsDetail", "(Z)V", "setBottomRoomModuleData", "like", "refreshLike", "(ZLcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "setHeaderData", "setSubjectAndRoomContent", "a", "getDp36", "()I", "dp36", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getDp16", "dp16", "c", "getDp32", "dp32", "d", "rootWidth", "e", "dp78", "f", "dp280", "Lso/w;", be.g.f16474b, "Lso/w;", "getViewBinding", "()Lso/w;", "viewBinding", "h", "Landroidx/recyclerview/widget/RecyclerView$s;", "i", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "mCommentViewModel", com.mbridge.msdk.foundation.same.report.j.f35620b, "Z", CampaignEx.JSON_KEY_AD_K, "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "l", "getPageFrom", "setPageFrom", "m", "mPostId", "n", "mAuthorId", "o", "Lkotlin/jvm/functions/Function0;", "getOnNegativeFeedbackSuccess", "()Lkotlin/jvm/functions/Function0;", "setOnNegativeFeedbackSuccess", "onNegativeFeedbackSuccess", TtmlNode.TAG_P, "getOnNegativeFeedbackClick", "setOnNegativeFeedbackClick", "onNegativeFeedbackClick", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public abstract class PostBaseItemView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int dp36;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int dp16;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int dp32;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int rootWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int dp78;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int dp280;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final so.w viewBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.s rvPool;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommentViewModel mCommentViewModel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isDetail;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String pageFrom;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String mPostId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String mAuthorId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Function0 onNegativeFeedbackSuccess;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Function0 onNegativeFeedbackClick;

    /* loaded from: classes6.dex */
    public static final class a extends DiffUtil.e {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(Image oldItem, Image newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.getUrl(), newItem.getUrl());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(Image oldItem, Image newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.getUrl(), newItem.getUrl());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostBaseItemView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostBaseItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostBaseItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.dp36 = dk.a.b(36);
        this.dp16 = dk.a.b(16);
        this.dp32 = dk.a.b(32);
        Context context2 = getContext();
        Intrinsics.g(context2, "getContext(...)");
        this.rootWidth = com.transsion.baseui.util.b.a(context2) ? dk.a.b(300) : com.blankj.utilcode.util.y.e() - dk.a.b(72);
        this.dp78 = dk.a.b(78);
        this.dp280 = dk.a.b(280);
        View.inflate(getContext(), R$layout.item_provider_room_post_base_layout, this);
        setPadding(0, 0, 0, dk.a.b(4));
        so.w a11 = so.w.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
    }

    private final void F(CommentBean hotComment, PostSubjectItem item) {
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.base_net_err);
            return;
        }
        Boolean likeStatu = hotComment.getLikeStatu();
        Boolean bool = Boolean.TRUE;
        boolean c11 = Intrinsics.c(likeStatu, bool);
        AppCompatImageView appCompatImageView = this.viewBinding.f75863h;
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
        AppCompatTextView appCompatTextView = this.viewBinding.f75875t;
        if (appCompatTextView != null) {
            appCompatTextView.setText(hotComment.getLikeCnt() == 0 ? "" : com.transsion.baseui.util.j.a(hotComment.getLikeCnt()));
        }
        String commentId = hotComment.getCommentId();
        if (commentId != null) {
            if (this.mCommentViewModel == null) {
                G();
            }
            CommentLikeBody commentLikeBody = new CommentLikeBody(commentId, Integer.valueOf(c11 ? 1 : 0));
            I(c11 ? "dislike_hot_comment" : "like_hot_comment", item);
            in.b bVar = new in.b(!c11, commentId, hotComment.getLikeCnt());
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = in.b.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, bVar, 0L);
            CommentViewModel commentViewModel = this.mCommentViewModel;
            if (commentViewModel != null) {
                commentViewModel.q(commentLikeBody);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if ((r0 instanceof androidx.view.y0) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void G() {
        /*
            r3 = this;
            com.transsion.postdetail.viewmodel.CommentViewModel r0 = r3.mCommentViewModel
            if (r0 == 0) goto L5
            return
        L5:
            android.content.Context r0 = r3.getContext()
            boolean r1 = r0 instanceof androidx.view.y0
            r2 = 0
            if (r1 == 0) goto L11
            androidx.lifecycle.y0 r0 = (androidx.view.y0) r0
            goto L12
        L11:
            r0 = r2
        L12:
            if (r0 != 0) goto L1c
            androidx.fragment.app.FragmentActivity r0 = r3.E()
            boolean r1 = r0 instanceof androidx.view.y0
            if (r1 == 0) goto L1d
        L1c:
            r2 = r0
        L1d:
            if (r2 == 0) goto L2e
            androidx.lifecycle.v0 r0 = new androidx.lifecycle.v0
            r0.<init>(r2)
            java.lang.Class<com.transsion.postdetail.viewmodel.CommentViewModel> r1 = com.transsion.postdetail.viewmodel.CommentViewModel.class
            androidx.lifecycle.t0 r0 = r0.a(r1)
            com.transsion.postdetail.viewmodel.CommentViewModel r0 = (com.transsion.postdetail.viewmodel.CommentViewModel) r0
            r3.mCommentViewModel = r0
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.view.PostBaseItemView.G():void");
    }

    private final void H(PostSubjectItem item) {
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
        Map m11 = MapsKt.m(a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, TuplesKt.a("ops", ops != null ? ops : ""));
        String str5 = this.pageName;
        if (str5 != null) {
            hj.i.f64628a.D(str5, m11);
        }
    }

    private final void I(String moduleName, PostSubjectItem item) {
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
        String str5 = this.pageName;
        if (str5 != null) {
            com.transsion.baselib.helper.a.f43316a.i(str5, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J() {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K() {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L() {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M() {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N() {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O() {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P() {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q() {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(PostBaseItemView postBaseItemView, CommentBean commentBean, PostSubjectItem postSubjectItem, View view) {
        postBaseItemView.F(commentBean, postSubjectItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(CommentBean commentBean, PostBaseItemView postBaseItemView, in.b value) {
        Intrinsics.h(value, "value");
        if (Intrinsics.c(value.a(), commentBean.getCommentId())) {
            a.C0856a.r(lg.a.f68962a, "hotCommentLikeEvent", new String[]{"commentId=" + value.a()}, false, 4, null);
            commentBean.setLikeStatu(Boolean.valueOf(value.c()));
            commentBean.setLikeCnt(value.b());
            AppCompatTextView appCompatTextView = postBaseItemView.viewBinding.f75875t;
            if (appCompatTextView != null) {
                appCompatTextView.setText(value.b() == 0 ? "" : com.transsion.baseui.util.j.a(value.b()));
            }
            AppCompatImageView appCompatImageView = postBaseItemView.viewBinding.f75863h;
            if (appCompatImageView != null) {
                appCompatImageView.setEnabled(value.c());
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(PostBaseItemView postBaseItemView, String str) {
        AppCompatTextView appCompatTextView = postBaseItemView.viewBinding.f75877v;
        Intrinsics.e(appCompatTextView);
        com.transsion.baseui.util.l.h(appCompatTextView, str, 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(PostSubjectItem postSubjectItem, PostBaseItemView postBaseItemView, boolean z10) {
        FirstFrame firstFrame;
        String url;
        String str;
        Cover cover;
        Media media = postSubjectItem.getMedia();
        if (media == null || (firstFrame = media.getFirstFrame()) == null || (url = firstFrame.getUrl()) == null) {
            return;
        }
        if (postSubjectItem.getBuiltIn()) {
            kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), null, null, new PostBaseItemView$setPostVideo$2$1$1(postBaseItemView, url, null), 3, null);
            return;
        }
        f.a aVar = ej.f.f62005a;
        Context context = postBaseItemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m11 = aVar.m(context).g(url).c(z10 ? dk.a.b(280) : dk.a.b(162)).m(z10 ? dk.a.b(Sdk$SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE) : dk.a.b(280));
        Media media2 = postSubjectItem.getMedia();
        if (media2 == null || (cover = media2.getCover()) == null || (str = cover.getThumbnail()) == null) {
            str = "";
        }
        f.b l11 = m11.l(str);
        ShapeableImageView ivCover = postBaseItemView.viewBinding.f75871p.f75654d;
        Intrinsics.g(ivCover, "ivCover");
        l11.d(ivCover);
    }

    private final void V() {
        AppCompatImageView appCompatImageView = this.viewBinding.f75865j;
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.w0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostBaseItemView.W(PostBaseItemView.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final PostBaseItemView postBaseItemView, View view) {
        FragmentActivity E;
        String str;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L) || (E = postBaseItemView.E()) == null || (str = postBaseItemView.mPostId) == null) {
            return;
        }
        String str2 = postBaseItemView.mAuthorId;
        String str3 = str2 == null ? "" : str2;
        Function0 function0 = postBaseItemView.onNegativeFeedbackClick;
        if (function0 != null) {
            function0.invoke();
        }
        NegativeFeedbackHelper negativeFeedbackHelper = NegativeFeedbackHelper.f48903a;
        LifecycleCoroutineScope a11 = androidx.view.v.a(E);
        String str4 = postBaseItemView.pageName;
        if (str4 == null) {
            str4 = "";
        }
        negativeFeedbackHelper.k(str, str3, E, a11, str4, new Function0() { // from class: com.transsion.postdetail.ui.view.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit X;
                X = PostBaseItemView.X(PostBaseItemView.this);
                return X;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(PostBaseItemView postBaseItemView) {
        Function0 function0 = postBaseItemView.onNegativeFeedbackSuccess;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f67184a;
    }

    private final void Y(final Function0 onCLickComment, PostSubjectItem postSubjectItem) {
        this.viewBinding.E.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.Z(Function0.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function0 function0, View view) {
        function0.invoke();
    }

    private final void c0(final Function0 onCLickHeader, Function0 onClickNegativeFeedback) {
        this.viewBinding.f75881z.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.d0(Function0.this, view);
            }
        });
        this.viewBinding.f75860e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.e0(Function0.this, view);
            }
        });
        this.viewBinding.f75878w.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.f0(Function0.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Function0 function0, View view) {
        function0.invoke();
    }

    private final void g0(final Function0 onCLickLike, PostSubjectItem postSubjectItem) {
        this.viewBinding.G.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.h0(Function0.this, view);
            }
        });
        if (postSubjectItem != null) {
            setBottomBarContent(postSubjectItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function0 function0, View view) {
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L)) {
            return;
        }
        function0.invoke();
    }

    private final void i0(final Function0 onCLickGroup, PostSubjectItem postSubjectItem) {
        this.viewBinding.f75870o.f75624f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.j0(Function0.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function0 function0, View view) {
        function0.invoke();
    }

    private final void k0(final Function0 onCLickShare) {
        View view;
        so.w wVar = this.viewBinding;
        if (wVar == null || (view = wVar.H) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PostBaseItemView.l0(Function0.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function0 function0, View view) {
        function0.invoke();
    }

    private final void m0(final Function0 onCLickSubject, PostSubjectItem postSubjectItem) {
        this.viewBinding.f75870o.f75620b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.n0(Function0.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Function0 function0, View view) {
        function0.invoke();
    }

    public static /* synthetic */ void setBottomBarClick$default(PostBaseItemView postBaseItemView, PostSubjectItem postSubjectItem, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function0 function08, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBottomBarClick");
        }
        postBaseItemView.setBottomBarClick(postSubjectItem, (i11 & 2) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.a1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit J;
                J = PostBaseItemView.J();
                return J;
            }
        } : function0, (i11 & 4) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit K;
                K = PostBaseItemView.K();
                return K;
            }
        } : function02, (i11 & 8) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit L;
                L = PostBaseItemView.L();
                return L;
            }
        } : function03, (i11 & 16) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit M;
                M = PostBaseItemView.M();
                return M;
            }
        } : function04, (i11 & 32) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit N;
                N = PostBaseItemView.N();
                return N;
            }
        } : function05, (i11 & 64) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit O;
                O = PostBaseItemView.O();
                return O;
            }
        } : function06, (i11 & 128) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit P;
                P = PostBaseItemView.P();
                return P;
            }
        } : function07, (i11 & 256) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.l0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit Q;
                Q = PostBaseItemView.Q();
                return Q;
            }
        } : function08);
    }

    private final void setBottomBarContent(PostSubjectItem item) {
        AppCompatTextView appCompatTextView = this.viewBinding.f75879x;
        Stat stat = item.getStat();
        Long likeCount = stat != null ? stat.getLikeCount() : null;
        String str = "";
        appCompatTextView.setText((likeCount == null || likeCount.longValue() == 0) ? "" : com.transsion.baseui.util.j.a(likeCount.longValue()));
        if (Intrinsics.c(item.getHasLike(), Boolean.TRUE)) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.ic_post_like_select, 0, 0, 0);
        } else {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.ic_post_like, 0, 0, 0);
        }
        Stat stat2 = item.getStat();
        Long commentCount = stat2 != null ? stat2.getCommentCount() : null;
        this.viewBinding.f75876u.setText((commentCount == null || commentCount.longValue() == 0) ? "" : com.transsion.baseui.util.j.a(commentCount.longValue()));
        Stat stat3 = item.getStat();
        Long shareCount = stat3 != null ? stat3.getShareCount() : null;
        AppCompatTextView appCompatTextView2 = this.viewBinding.f75880y;
        if (appCompatTextView2 != null) {
            if (shareCount != null && shareCount.longValue() != 0) {
                str = com.transsion.baseui.util.j.a(shareCount.longValue());
            }
            appCompatTextView2.setText(str);
        }
    }

    private final void setBottomDownLoadStatus(PostSubjectItem item) {
        Media media = item.getMedia();
        if (!Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue())) {
            Media media2 = item.getMedia();
            if (!Intrinsics.c(media2 != null ? media2.getMediaType() : null, MediaType.IMAGE.getValue())) {
                Media media3 = item.getMedia();
                if (!Intrinsics.c(media3 != null ? media3.getMediaType() : null, MediaType.IMAGE_SINGLE.getValue())) {
                    View view = this.viewBinding.F;
                    if (view != null) {
                        jg.c.g(view);
                    }
                    AppCompatImageView appCompatImageView = this.viewBinding.f75866k;
                    if (appCompatImageView != null) {
                        jg.c.g(appCompatImageView);
                        return;
                    }
                    return;
                }
            }
        }
        View view2 = this.viewBinding.F;
        if (view2 != null) {
            jg.c.k(view2);
        }
        AppCompatImageView appCompatImageView2 = this.viewBinding.f75866k;
        if (appCompatImageView2 != null) {
            jg.c.k(appCompatImageView2);
        }
    }

    public static /* synthetic */ void setHeaderPostData$default(PostBaseItemView postBaseItemView, PostSubjectItem postSubjectItem, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderPostData");
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        postBaseItemView.setHeaderPostData(postSubjectItem, z10);
    }

    private final void setHotComment(final PostSubjectItem item) {
        String str;
        ShapeableImageView shapeableImageView;
        final CommentBean hotComment = item.getHotComment();
        String content = hotComment != null ? hotComment.getContent() : null;
        if (content == null || content.length() == 0 || (this instanceof PostDetailItemView)) {
            BLConstraintLayout bLConstraintLayout = this.viewBinding.f75857b;
            if (bLConstraintLayout != null) {
                jg.c.g(bLConstraintLayout);
                return;
            }
            return;
        }
        H(item);
        BLConstraintLayout bLConstraintLayout2 = this.viewBinding.f75857b;
        if (bLConstraintLayout2 != null) {
            jg.c.k(bLConstraintLayout2);
        }
        AppCompatTextView appCompatTextView = this.viewBinding.f75873r;
        if (appCompatTextView != null) {
            appCompatTextView.setText(content);
        }
        String avatarUrl = hotComment.getAvatarUrl();
        if (avatarUrl == null) {
            avatarUrl = "";
        }
        if (avatarUrl.length() > 0 && (shapeableImageView = this.viewBinding.f75861f) != null) {
            f.a aVar = ej.f.f62005a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(avatarUrl).m(dk.a.b(20)).c(dk.a.b(20)).d(shapeableImageView);
        }
        List<Cover> imageList = hotComment.getImageList();
        if (imageList == null || imageList.isEmpty()) {
            ShapeableImageView shapeableImageView2 = this.viewBinding.f75858c;
            if (shapeableImageView2 != null) {
                jg.c.g(shapeableImageView2);
            }
        } else {
            ShapeableImageView shapeableImageView3 = this.viewBinding.f75858c;
            if (shapeableImageView3 != null) {
                shapeableImageView3.setVisibility(0);
                f.a aVar2 = ej.f.f62005a;
                Context context2 = shapeableImageView3.getContext();
                Intrinsics.g(context2, "getContext(...)");
                f.b m11 = aVar2.m(context2);
                List<Cover> imageList2 = hotComment.getImageList();
                Intrinsics.e(imageList2);
                Cover cover = imageList2.get(0);
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = "";
                }
                m11.g(str).m(dk.a.b(20)).c(dk.a.b(20)).d(shapeableImageView3);
            }
        }
        AppCompatTextView appCompatTextView2 = this.viewBinding.f75875t;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(hotComment.getLikeCnt() != 0 ? com.transsion.baseui.util.j.a(hotComment.getLikeCnt()) : "");
        }
        AppCompatImageView appCompatImageView = this.viewBinding.f75863h;
        if (appCompatImageView != null) {
            appCompatImageView.setEnabled(Intrinsics.c(hotComment.getLikeStatu(), Boolean.TRUE));
        }
        View view = this.viewBinding.C;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.x0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PostBaseItemView.R(PostBaseItemView.this, hotComment, item, view2);
                }
            });
        }
        Context context3 = getContext();
        Intrinsics.f(context3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit S;
                S = PostBaseItemView.S(CommentBean.this, this, (in.b) obj);
                return S;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = in.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent((AppCompatActivity) context3, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    private final void setPostContent(PostSubjectItem item) {
        List<Image> image;
        setPostContentDes(item);
        Media media = item.getMedia();
        String mediaType = media != null ? media.getMediaType() : null;
        if (Intrinsics.c(mediaType, MediaType.TEXT.getValue())) {
            FrameLayout flContent = this.viewBinding.f75859d;
            Intrinsics.g(flContent, "flContent");
            jg.c.g(flContent);
        } else if (Intrinsics.c(mediaType, MediaType.IMAGE.getValue())) {
            FrameLayout flContent2 = this.viewBinding.f75859d;
            Intrinsics.g(flContent2, "flContent");
            Media media2 = item.getMedia();
            flContent2.setVisibility(((media2 == null || (image = media2.getImage()) == null) ? 0 : image.size()) > 0 ? 0 : 8);
            setPostImage(item);
        } else if (Intrinsics.c(mediaType, MediaType.AUDIO.getValue())) {
            FrameLayout flContent3 = this.viewBinding.f75859d;
            Intrinsics.g(flContent3, "flContent");
            jg.c.g(flContent3);
        } else if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
            FrameLayout flContent4 = this.viewBinding.f75859d;
            Intrinsics.g(flContent4, "flContent");
            jg.c.k(flContent4);
            setPostVideo(item);
        } else {
            FrameLayout flContent5 = this.viewBinding.f75859d;
            Intrinsics.g(flContent5, "flContent");
            jg.c.g(flContent5);
        }
        setHotComment(item);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
    
        r4 = r3.viewBinding.f75877v;
        kotlin.jvm.internal.Intrinsics.e(r4);
        com.transsion.baseui.util.l.e(r4, r1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        r3.viewBinding.f75877v.post(new com.transsion.postdetail.ui.view.r0(r3, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        if (r4 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r4 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        r4 = r3.viewBinding.f75877v;
        kotlin.jvm.internal.Intrinsics.g(r4, "tvPostContent");
        jg.c.k(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        if (r3.isDetail == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void setPostContentDes(com.transsion.moviedetailapi.bean.PostSubjectItem r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.getContent()
            java.lang.String r1 = ""
            java.lang.String r2 = "tvPostContent"
            if (r0 == 0) goto L1a
            int r0 = r0.length()
            if (r0 != 0) goto L11
            goto L1a
        L11:
            java.lang.String r4 = r4.getContent()
            if (r4 != 0) goto L18
            goto L2d
        L18:
            r1 = r4
            goto L2d
        L1a:
            java.lang.String r0 = r4.getTitle()
            if (r0 == 0) goto L54
            int r0 = r0.length()
            if (r0 != 0) goto L27
            goto L54
        L27:
            java.lang.String r4 = r4.getTitle()
            if (r4 != 0) goto L18
        L2d:
            so.w r4 = r3.viewBinding
            androidx.appcompat.widget.AppCompatTextView r4 = r4.f75877v
            kotlin.jvm.internal.Intrinsics.g(r4, r2)
            jg.c.k(r4)
            boolean r4 = r3.isDetail
            if (r4 == 0) goto L47
            so.w r4 = r3.viewBinding
            androidx.appcompat.widget.AppCompatTextView r4 = r4.f75877v
            kotlin.jvm.internal.Intrinsics.e(r4)
            r0 = 0
            com.transsion.baseui.util.l.e(r4, r1, r0)
            return
        L47:
            so.w r4 = r3.viewBinding
            androidx.appcompat.widget.AppCompatTextView r4 = r4.f75877v
            com.transsion.postdetail.ui.view.r0 r0 = new com.transsion.postdetail.ui.view.r0
            r0.<init>()
            r4.post(r0)
            return
        L54:
            so.w r4 = r3.viewBinding
            androidx.appcompat.widget.AppCompatTextView r4 = r4.f75877v
            kotlin.jvm.internal.Intrinsics.g(r4, r2)
            jg.c.g(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.view.PostBaseItemView.setPostContentDes(com.transsion.moviedetailapi.bean.PostSubjectItem):void");
    }

    private final void setPostImage(PostSubjectItem item) {
        List<Image> image;
        List<Image> image2;
        Media media = item.getMedia();
        int size = (media == null || (image2 = media.getImage()) == null) ? 0 : image2.size();
        CardView flVideo = this.viewBinding.f75871p.f75653c;
        Intrinsics.g(flVideo, "flVideo");
        jg.c.g(flVideo);
        if (size == 0) {
            NoScrollRecyclerView2 recyclerViewPost = this.viewBinding.f75872q;
            Intrinsics.g(recyclerViewPost, "recyclerViewPost");
            jg.c.g(recyclerViewPost);
            return;
        }
        NoScrollRecyclerView2 recyclerViewPost2 = this.viewBinding.f75872q;
        Intrinsics.g(recyclerViewPost2, "recyclerViewPost");
        jg.c.k(recyclerViewPost2);
        int i11 = 1;
        if (size != 1) {
            i11 = 2;
            if (size != 2 && size != 4) {
                i11 = 3;
            }
        }
        Media media2 = item.getMedia();
        if (media2 == null || (image = media2.getImage()) == null) {
            return;
        }
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        RoomPostContentImageAdapter roomPostContentImageAdapter = new RoomPostContentImageAdapter(i11, com.transsion.baseui.util.b.a(context), this.pageName, this.pageFrom, item);
        roomPostContentImageAdapter.R0(new a());
        NoScrollRecyclerView2 noScrollRecyclerView2 = this.viewBinding.f75872q;
        RecyclerView.s sVar = this.rvPool;
        if (sVar != null) {
            noScrollRecyclerView2.setRecycledViewPool(sVar);
        }
        noScrollRecyclerView2.setLayoutManager(new NpaGridLayoutManager(noScrollRecyclerView2.getContext(), i11));
        if (noScrollRecyclerView2.getItemDecorationCount() == 0) {
            noScrollRecyclerView2.addItemDecoration(new ig.a(dk.a.b(3), dk.a.b(3), 0, 0));
        }
        noScrollRecyclerView2.setAdapter(roomPostContentImageAdapter);
        roomPostContentImageAdapter.n1(image);
    }

    private final void setPostVideo(final PostSubjectItem item) {
        Video video;
        Integer duration;
        List<Video> video2;
        Video video3;
        Integer height;
        FirstFrame firstFrame;
        Integer height2;
        Cover cover;
        Integer height3;
        List<Video> video4;
        Video video5;
        Integer width;
        FirstFrame firstFrame2;
        Integer width2;
        Cover cover2;
        Integer width3;
        NoScrollRecyclerView2 recyclerViewPost = this.viewBinding.f75872q;
        Intrinsics.g(recyclerViewPost, "recyclerViewPost");
        jg.c.g(recyclerViewPost);
        CardView flVideo = this.viewBinding.f75871p.f75653c;
        Intrinsics.g(flVideo, "flVideo");
        jg.c.k(flVideo);
        ShapeableImageView ivCover = this.viewBinding.f75871p.f75654d;
        Intrinsics.g(ivCover, "ivCover");
        jg.c.k(ivCover);
        BLTextView tvVideoDuration = this.viewBinding.f75871p.f75656f;
        Intrinsics.g(tvVideoDuration, "tvVideoDuration");
        jg.c.k(tvVideoDuration);
        AppCompatImageView ivVideoPlay = this.viewBinding.f75871p.f75655e;
        Intrinsics.g(ivVideoPlay, "ivVideoPlay");
        jg.c.k(ivVideoPlay);
        FrameLayout flPlayer = this.viewBinding.f75871p.f75652b;
        Intrinsics.g(flPlayer, "flPlayer");
        int i11 = 0;
        if (flPlayer.getChildCount() != 0) {
            View childAt = this.viewBinding.f75871p.f75652b.getChildAt(0);
            PostFeedVideoView postFeedVideoView = childAt instanceof PostFeedVideoView ? (PostFeedVideoView) childAt : null;
            if (postFeedVideoView != null) {
                postFeedVideoView.removePlayer();
            }
        }
        Media media = item.getMedia();
        int intValue = (media == null || (cover2 = media.getCover()) == null || (width3 = cover2.getWidth()) == null) ? 0 : width3.intValue();
        Media media2 = item.getMedia();
        int intValue2 = (media2 == null || (firstFrame2 = media2.getFirstFrame()) == null || (width2 = firstFrame2.getWidth()) == null) ? 0 : width2.intValue();
        Media media3 = item.getMedia();
        int intValue3 = (media3 == null || (video4 = media3.getVideo()) == null || (video5 = (Video) CollectionsKt.k0(video4)) == null || (width = video5.getWidth()) == null) ? 0 : width.intValue();
        int i12 = intValue > 0 ? intValue : intValue2 > 0 ? intValue2 : intValue3 > 0 ? intValue3 : 0;
        Media media4 = item.getMedia();
        int intValue4 = (media4 == null || (cover = media4.getCover()) == null || (height3 = cover.getHeight()) == null) ? 0 : height3.intValue();
        Media media5 = item.getMedia();
        int intValue5 = (media5 == null || (firstFrame = media5.getFirstFrame()) == null || (height2 = firstFrame.getHeight()) == null) ? 0 : height2.intValue();
        Media media6 = item.getMedia();
        int intValue6 = (media6 == null || (video2 = media6.getVideo()) == null || (video3 = (Video) CollectionsKt.k0(video2)) == null || (height = video3.getHeight()) == null) ? 0 : height.intValue();
        if (intValue <= 0) {
            intValue4 = intValue2 > 0 ? intValue5 : intValue3 > 0 ? intValue6 : 0;
        }
        final boolean z10 = intValue4 > i12;
        ViewGroup.LayoutParams layoutParams = this.viewBinding.f75871p.f75653c.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int b11 = i12 / intValue4 < 1 ? this.rootWidth - dk.a.b(38) : this.rootWidth;
        marginLayoutParams.width = b11;
        int i13 = (intValue4 * b11) / i12;
        if (i13 > (b11 * 36) / 26) {
            i13 = (b11 * 36) / 26;
        }
        marginLayoutParams.height = i13;
        this.viewBinding.f75871p.f75653c.setLayoutParams(marginLayoutParams);
        this.viewBinding.f75871p.f75653c.post(new Runnable() { // from class: com.transsion.postdetail.ui.view.m0
            @Override // java.lang.Runnable
            public final void run() {
                PostBaseItemView.U(PostSubjectItem.this, this, z10);
            }
        });
        BLTextView bLTextView = this.viewBinding.f75871p.f75656f;
        Media media7 = item.getMedia();
        List<Video> video6 = media7 != null ? media7.getVideo() : null;
        if ((video6 != null ? video6.size() : 0) <= 0) {
            Intrinsics.e(bLTextView);
            jg.c.g(bLTextView);
            return;
        }
        if (video6 != null && (video = video6.get(0)) != null && (duration = video.getDuration()) != null) {
            i11 = duration.intValue();
        }
        if (i11 <= 0) {
            Intrinsics.e(bLTextView);
            jg.c.g(bLTextView);
        } else {
            bLTextView.setText(TimeUtilKt.o(i11));
            Intrinsics.e(bLTextView);
            jg.c.k(bLTextView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FragmentActivity E() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof FragmentActivity) {
                return (FragmentActivity) context;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0(final Function0 onClickDownload, PostSubjectItem postSubjectItem) {
        Intrinsics.h(onClickDownload, "onClickDownload");
        View view = this.viewBinding.F;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.u0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PostBaseItemView.b0(Function0.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getDp16() {
        return this.dp16;
    }

    protected final int getDp32() {
        return this.dp32;
    }

    protected final int getDp36() {
        return this.dp36;
    }

    public final Function0<Unit> getOnNegativeFeedbackClick() {
        return this.onNegativeFeedbackClick;
    }

    public final Function0<Unit> getOnNegativeFeedbackSuccess() {
        return this.onNegativeFeedbackSuccess;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getPageFrom() {
        return this.pageFrom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getPageName() {
        return this.pageName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final so.w getViewBinding() {
        return this.viewBinding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        G();
    }

    public final void refreshLike(boolean like, PostSubjectItem item) {
        Intrinsics.h(item, "item");
        AppCompatTextView appCompatTextView = this.viewBinding.f75879x;
        Stat stat = item.getStat();
        Long likeCount = stat != null ? stat.getLikeCount() : null;
        appCompatTextView.setText((likeCount == null || likeCount.longValue() == 0) ? "" : com.transsion.baseui.util.j.a(likeCount.longValue()));
        if (like) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.ic_post_like_select, 0, 0, 0);
        } else {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.ic_post_like, 0, 0, 0);
        }
    }

    public final void setBottomBarClick(PostSubjectItem postSubjectItem, Function0<Unit> onCLickLike, Function0<Unit> onCLickComment, Function0<Unit> onCLickShare, Function0<Unit> onCLickSubject, Function0<Unit> onCLickGroup, Function0<Unit> onClickDownload, Function0<Unit> onCLickHeader, Function0<Unit> onClickNegativeFeedback) {
        Intrinsics.h(onCLickLike, "onCLickLike");
        Intrinsics.h(onCLickComment, "onCLickComment");
        Intrinsics.h(onCLickShare, "onCLickShare");
        Intrinsics.h(onCLickSubject, "onCLickSubject");
        Intrinsics.h(onCLickGroup, "onCLickGroup");
        Intrinsics.h(onClickDownload, "onClickDownload");
        Intrinsics.h(onCLickHeader, "onCLickHeader");
        Intrinsics.h(onClickNegativeFeedback, "onClickNegativeFeedback");
        g0(onCLickLike, postSubjectItem);
        Y(onCLickComment, postSubjectItem);
        k0(onCLickShare);
        a0(onClickDownload, postSubjectItem);
        m0(onCLickSubject, postSubjectItem);
        i0(onCLickGroup, postSubjectItem);
        c0(onCLickHeader, onClickNegativeFeedback);
    }

    public void setBottomRoomModuleData(PostSubjectItem item) {
        String str;
        Cover cover;
        Intrinsics.h(item, "item");
        AppCompatTextView appCompatTextView = this.viewBinding.f75870o.f75625g;
        Group group = item.getGroup();
        String str2 = null;
        appCompatTextView.setText(group != null ? group.getName() : null);
        if (item.getBuiltIn()) {
            kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), null, null, new PostBaseItemView$setBottomRoomModuleData$1(item, this, null), 3, null);
            return;
        }
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
        f.b c11 = m11.g(str).m(this.dp32).c(this.dp32);
        ShapeableImageView ivRoomCover = this.viewBinding.f75870o.f75621c;
        Intrinsics.g(ivRoomCover, "ivRoomCover");
        c11.d(ivRoomCover);
    }

    public void setBottomSubjectAndRoomVisibility(boolean isShowSubject, boolean isShowRoom) {
        if (ak.g.f714a.b()) {
            BLLinearLayout root = this.viewBinding.f75870o.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            root.setVisibility(isShowRoom ? 0 : 8);
            ConstraintLayout clSubjectContent = this.viewBinding.f75870o.f75620b;
            Intrinsics.g(clSubjectContent, "clSubjectContent");
            jg.c.g(clSubjectContent);
            View vSubjectRoomLine = this.viewBinding.f75870o.f75631m;
            Intrinsics.g(vSubjectRoomLine, "vSubjectRoomLine");
            jg.c.g(vSubjectRoomLine);
            LinearLayout llRoomTag = this.viewBinding.f75870o.f75624f;
            Intrinsics.g(llRoomTag, "llRoomTag");
            llRoomTag.setVisibility(isShowRoom ? 0 : 8);
            return;
        }
        if (isShowSubject) {
            BLLinearLayout root2 = this.viewBinding.f75870o.getRoot();
            Intrinsics.g(root2, "getRoot(...)");
            jg.c.k(root2);
            ConstraintLayout clSubjectContent2 = this.viewBinding.f75870o.f75620b;
            Intrinsics.g(clSubjectContent2, "clSubjectContent");
            jg.c.k(clSubjectContent2);
            View vSubjectRoomLine2 = this.viewBinding.f75870o.f75631m;
            Intrinsics.g(vSubjectRoomLine2, "vSubjectRoomLine");
            vSubjectRoomLine2.setVisibility(isShowRoom ? 0 : 8);
            LinearLayout llRoomTag2 = this.viewBinding.f75870o.f75624f;
            Intrinsics.g(llRoomTag2, "llRoomTag");
            llRoomTag2.setVisibility(isShowRoom ? 0 : 8);
            return;
        }
        BLLinearLayout root3 = this.viewBinding.f75870o.getRoot();
        Intrinsics.g(root3, "getRoot(...)");
        root3.setVisibility(isShowRoom ? 0 : 8);
        ConstraintLayout clSubjectContent3 = this.viewBinding.f75870o.f75620b;
        Intrinsics.g(clSubjectContent3, "clSubjectContent");
        jg.c.g(clSubjectContent3);
        View vSubjectRoomLine3 = this.viewBinding.f75870o.f75631m;
        Intrinsics.g(vSubjectRoomLine3, "vSubjectRoomLine");
        jg.c.g(vSubjectRoomLine3);
        LinearLayout llRoomTag3 = this.viewBinding.f75870o.f75624f;
        Intrinsics.g(llRoomTag3, "llRoomTag");
        llRoomTag3.setVisibility(isShowRoom ? 0 : 8);
    }

    public void setBottomSubjectModuleData(PostSubjectItem item) {
        String str;
        String str2;
        Cover cover;
        Cover cover2;
        String str3;
        Subject subject;
        String genre;
        List S0;
        String str4;
        Intrinsics.h(item, "item");
        String str5 = "";
        if (item.getBuiltIn()) {
            kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), null, null, new PostBaseItemView$setBottomSubjectModuleData$1(item, this, null), 3, null);
        } else {
            f.a aVar = ej.f.f62005a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m11 = aVar.m(context);
            Subject subject2 = item.getSubject();
            if (subject2 == null || (cover2 = subject2.getCover()) == null || (str = cover2.getUrl()) == null) {
                str = "";
            }
            f.b c11 = m11.g(str).m(this.dp32).c(this.dp32);
            Subject subject3 = item.getSubject();
            if (subject3 == null || (cover = subject3.getCover()) == null || (str2 = cover.getThumbnail()) == null) {
                str2 = "";
            }
            f.b l11 = c11.l(str2);
            ShapeableImageView ivSubjectCover = this.viewBinding.f75870o.f75622d;
            Intrinsics.g(ivSubjectCover, "ivSubjectCover");
            l11.d(ivSubjectCover);
        }
        AppCompatTextView appCompatTextView = this.viewBinding.f75870o.f75628j;
        Subject subject4 = item.getSubject();
        if (subject4 == null || (str3 = subject4.getTitle()) == null) {
            str3 = "";
        }
        appCompatTextView.setText(str3);
        Subject subject5 = item.getSubject();
        this.viewBinding.f75870o.f75623e.setImageResource(com.transsion.moviedetailapi.g.a(subject5 != null ? subject5.getSubjectType() : null));
        Subject subject6 = item.getSubject();
        Date l12 = com.blankj.utilcode.util.c0.l(subject6 != null ? subject6.getReleaseDate() : null, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(l12);
        this.viewBinding.f75870o.f75626h.setText(String.valueOf(calendar.get(1)));
        Subject subject7 = item.getSubject();
        String genre2 = subject7 != null ? subject7.getGenre() : null;
        if (genre2 != null && genre2.length() != 0 && (subject = item.getSubject()) != null && (genre = subject.getGenre()) != null && (S0 = StringsKt.S0(genre, new String[]{", "}, false, 0, 6, null)) != null && (str4 = (String) CollectionsKt.k0(S0)) != null) {
            str5 = str4;
        }
        AppCompatTextView tvSubjectGenre = this.viewBinding.f75870o.f75627i;
        Intrinsics.g(tvSubjectGenre, "tvSubjectGenre");
        tvSubjectGenre.setVisibility(str5.length() > 0 ? 0 : 8);
        AppCompatTextView tvSubjectGenre2 = this.viewBinding.f75870o.f75627i;
        Intrinsics.g(tvSubjectGenre2, "tvSubjectGenre");
        tvSubjectGenre2.setVisibility(str5.length() > 0 ? 0 : 8);
        this.viewBinding.f75870o.f75627i.setText(str5);
    }

    public final void setCommentCount(long count) {
        AppCompatTextView appCompatTextView;
        so.w wVar = this.viewBinding;
        if (wVar == null || (appCompatTextView = wVar.f75876u) == null) {
            return;
        }
        appCompatTextView.setText(count == 0 ? "" : com.transsion.baseui.util.j.a(count));
    }

    public final void setCommentViewModel(CommentViewModel viewModel) {
        this.mCommentViewModel = viewModel;
    }

    public final void setContentMaxLine() {
        this.viewBinding.f75877v.setMaxLines(Integer.MAX_VALUE);
    }

    public final void setData(PostSubjectItem item) {
        Intrinsics.h(item, "item");
        this.mPostId = item.getPostId();
        User user = item.getUser();
        this.mAuthorId = user != null ? user.getUserId() : null;
        setBottomDownLoadStatus(item);
        setHeaderData(item);
        setPostContent(item);
        setSubjectAndRoomContent(item);
        setBottomBarContent(item);
        V();
    }

    public abstract void setHeaderData(PostSubjectItem item);

    public void setHeaderPostData(PostSubjectItem item, boolean showDistance) {
        String str;
        String poiName;
        Long x10;
        String nickname;
        Intrinsics.h(item, "item");
        String str2 = "";
        if (item.getBuiltIn()) {
            kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), null, null, new PostBaseItemView$setHeaderPostData$1(item, this, null), 3, null);
        } else {
            f.a aVar = ej.f.f62005a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m11 = aVar.m(context);
            User user = item.getUser();
            if (user == null || (str = user.getAvatar()) == null) {
                str = "";
            }
            f.b c11 = m11.g(str).m(this.dp16).c(this.dp16);
            ShapeableImageView ivUserAvatar2 = this.viewBinding.f75869n;
            Intrinsics.g(ivUserAvatar2, "ivUserAvatar2");
            c11.d(ivUserAvatar2);
        }
        AppCompatTextView appCompatTextView = this.viewBinding.f75881z;
        User user2 = item.getUser();
        if (user2 != null && (nickname = user2.getNickname()) != null) {
            str2 = nickname;
        }
        appCompatTextView.setText(str2);
        AppCompatTextView appCompatTextView2 = this.viewBinding.f75878w;
        String createdAt = item.getCreatedAt();
        appCompatTextView2.setText(com.transsion.postdetail.util.n.b((createdAt == null || (x10 = StringsKt.x(createdAt)) == null) ? 0L : x10.longValue()));
        if (this.isDetail) {
            AppCompatImageView appCompatImageView = this.viewBinding.f75865j;
            if (appCompatImageView != null) {
                jg.c.g(appCompatImageView);
            }
        } else {
            AppCompatImageView appCompatImageView2 = this.viewBinding.f75865j;
            if (appCompatImageView2 != null) {
                jg.c.k(appCompatImageView2);
            }
        }
        View vLocationLine = this.viewBinding.D;
        Intrinsics.g(vLocationLine, "vLocationLine");
        jg.c.g(vLocationLine);
        String poiName2 = item.getPoiName();
        if (poiName2 == null || poiName2.length() == 0) {
            AppCompatImageView ivLocationIcon = this.viewBinding.f75864i;
            Intrinsics.g(ivLocationIcon, "ivLocationIcon");
            jg.c.g(ivLocationIcon);
            AppCompatTextView tvUserNameOrLocation = this.viewBinding.A;
            Intrinsics.g(tvUserNameOrLocation, "tvUserNameOrLocation");
            jg.c.g(tvUserNameOrLocation);
            return;
        }
        AppCompatTextView tvUserNameOrLocation2 = this.viewBinding.A;
        Intrinsics.g(tvUserNameOrLocation2, "tvUserNameOrLocation");
        jg.c.k(tvUserNameOrLocation2);
        AppCompatImageView ivLocationIcon2 = this.viewBinding.f75864i;
        Intrinsics.g(ivLocationIcon2, "ivLocationIcon");
        jg.c.k(ivLocationIcon2);
        String distanceStr = item.getDistanceStr();
        if (distanceStr == null || distanceStr.length() == 0 || !showDistance) {
            poiName = item.getPoiName();
        } else {
            poiName = item.getPoiName() + " " + item.getDistanceStr();
        }
        this.viewBinding.A.setText(poiName);
    }

    public final void setIsDetail(boolean isDetail) {
        this.isDetail = isDetail;
    }

    public final void setOnNegativeFeedbackClick(Function0<Unit> function0) {
        this.onNegativeFeedbackClick = function0;
    }

    public final void setOnNegativeFeedbackSuccess(Function0<Unit> function0) {
        this.onNegativeFeedbackSuccess = function0;
    }

    public final void setPage(String pageName, String pageFrom) {
        this.pageName = pageName;
        this.pageFrom = pageFrom;
    }

    protected final void setPageFrom(String str) {
        this.pageFrom = str;
    }

    protected final void setPageName(String str) {
        this.pageName = str;
    }

    public final void setRecycledViewPool(RecyclerView.s rvPool) {
        Intrinsics.h(rvPool, "rvPool");
        this.rvPool = rvPool;
    }

    public abstract void setSubjectAndRoomContent(PostSubjectItem item);
}
