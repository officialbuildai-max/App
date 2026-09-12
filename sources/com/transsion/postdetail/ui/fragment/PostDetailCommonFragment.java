package com.transsion.postdetail.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.Lifecycle;
import androidx.view.v0;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Audio;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.ninegridview.video.NineGridVideoViewAdapter;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.ui.dialog.ImmVideoCommentDialog;
import com.transsion.postdetail.ui.fragment.CommentFragment;
import com.transsion.postdetail.ui.view.PostDetailOperationView;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.a;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.loginapi.ILoginApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import lg.a;
import okhttp3.internal.http2.Settings;
import uh.b;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 l2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u001b\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000fH\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000bH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u000bH\u0016¢\u0006\u0004\b1\u00100J\u000f\u00102\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u0010\u0004J\u000f\u00103\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u0010\u0004J\u000f\u00104\u001a\u00020\u0005H\u0016¢\u0006\u0004\b4\u0010\u0004J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u000fH&¢\u0006\u0004\b8\u0010.J\u000f\u00109\u001a\u00020\u0005H\u0016¢\u0006\u0004\b9\u0010\u0004J\u000f\u0010:\u001a\u00020\u0005H&¢\u0006\u0004\b:\u0010\u0004J\u000f\u0010;\u001a\u00020\u0005H&¢\u0006\u0004\b;\u0010\u0004J\u000f\u0010<\u001a\u00020\u0005H&¢\u0006\u0004\b<\u0010\u0004J\u000f\u0010=\u001a\u00020\u0005H\u0016¢\u0006\u0004\b=\u0010\u0004J\u000f\u0010>\u001a\u00020\u0005H\u0016¢\u0006\u0004\b>\u0010\u0004J\u000f\u0010?\u001a\u00020\u0005H\u0016¢\u0006\u0004\b?\u0010\u0004R\u0018\u0010B\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010G\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010A\u001a\u0004\bD\u0010.\"\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR$\u0010P\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010 R\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u001b\u0010Z\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR$\u0010b\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001d\u0010g\u001a\u0004\u0018\u00010c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010W\u001a\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006m"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/PostDetailCommonFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lso/p;", "<init>", "()V", "", "C0", "L0", "Z0", "loadData", "updatePostDetail", "", "hasResource", "a1", "(Ljava/lang/Boolean;)V", "", CampaignEx.JSON_KEY_TITLE, "content", "link", "V0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "subjectRate", "Y0", "(Ljava/lang/Integer;)V", "Lcom/transsion/moviedetailapi/bean/Media;", "media", "T0", "(Lcom/transsion/moviedetailapi/bean/Media;)V", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", WebConstants.FIELD_ITEM, "setPTParams", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "initPlayer", "observeLike", "O0", "clickLike", "showCommentsDialog", "doShare", "clickDownload", "receiveArguments", "Landroid/view/LayoutInflater;", "inflater", "E0", "(Landroid/view/LayoutInflater;)Lso/p;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "initViewData", "initViewModel", "initListener", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "getPageName", "retryLoadData", "G0", "initAudioListener", "F0", "onResume", "onPause", "onDestroy", "a", "Ljava/lang/String;", "tranOps", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getPostId", "setPostId", "(Ljava/lang/String;)V", "postId", "c", "Z", "fromComment", "d", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "getMPostDetailBean", "()Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "setMPostDetailBean", "mPostDetailBean", "Lcom/transsion/postdetail/ui/fragment/PostRecommendFragment;", "e", "Lcom/transsion/postdetail/ui/fragment/PostRecommendFragment;", "mPostRecommendFragment", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "f", "Lkotlin/Lazy;", "getViewModel", "()Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "viewModel", "Lcom/transsnet/downloader/widget/DownloadView;", be.g.f16474b, "Lcom/transsnet/downloader/widget/DownloadView;", "getDownloadViewFloat", "()Lcom/transsnet/downloader/widget/DownloadView;", "setDownloadViewFloat", "(Lcom/transsnet/downloader/widget/DownloadView;)V", "downloadViewFloat", "Lcom/transsnet/loginapi/ILoginApi;", "h", "getMLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "mLoginApi", "Lcom/transsion/ninegridview/a;", "i", "Lcom/transsion/ninegridview/a;", "mGifPlayerManager", com.mbridge.msdk.foundation.same.report.j.f35620b, "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public abstract class PostDetailCommonFragment extends PageStatusFragment<so.p> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String tranOps;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String postId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean fromComment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PostSubjectItem mPostDetailBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private PostRecommendFragment mPostRecommendFragment;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private DownloadView downloadViewFloat;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLoginApi;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.transsion.ninegridview.a mGifPlayerManager;

    /* loaded from: classes6.dex */
    public static final class b implements com.transsion.share.share.a {
        b() {
        }

        @Override // com.transsion.share.share.a
        public void a(String id2, PostType postType) {
            Intrinsics.h(id2, "id");
            PostDetailCommonFragment.this.getViewModel().r(id2);
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            new Intent().putExtra("id", str);
            Activity b11 = com.blankj.utilcode.util.a.b();
            if (b11 != null) {
                b11.finish();
            }
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

    /* loaded from: classes6.dex */
    static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f49639a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f49639a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f49639a;
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
            this.f49639a.invoke(obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements CommentFragment.b {
        d() {
        }

        @Override // com.transsion.postdetail.ui.fragment.CommentFragment.b
        public void a(long j11) {
            Stat stat;
            Stat stat2;
            Long commentCount;
            PostSubjectItem mPostDetailBean = PostDetailCommonFragment.this.getMPostDetailBean();
            if (mPostDetailBean == null || (stat2 = mPostDetailBean.getStat()) == null || (commentCount = stat2.getCommentCount()) == null || commentCount.longValue() != j11) {
                PostSubjectItem mPostDetailBean2 = PostDetailCommonFragment.this.getMPostDetailBean();
                if (mPostDetailBean2 != null && (stat = mPostDetailBean2.getStat()) != null) {
                    stat.setCommentCount(Long.valueOf(j11));
                }
                PostDetailCommonFragment.this.O0();
            }
        }
    }

    public PostDetailCommonFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(PostDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$special$$inlined$viewModels$default$3
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
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.i2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi mLoginApi_delegate$lambda$0;
                mLoginApi_delegate$lambda$0 = PostDetailCommonFragment.mLoginApi_delegate$lambda$0();
                return mLoginApi_delegate$lambda$0;
            }
        });
    }

    private final void C0() {
        Subject subject;
        ConstraintLayout root;
        Context context = getContext();
        Boolean bool = null;
        DownloadView downloadView = context != null ? new DownloadView(context) : null;
        this.downloadViewFloat = downloadView;
        if (downloadView != null) {
            downloadView.setPageFrom(getPageName());
        }
        DownloadView downloadView2 = this.downloadViewFloat;
        if (downloadView2 != null) {
            DownloadView.setAttrs$default(downloadView2, null, Float.valueOf(com.blankj.utilcode.util.a0.d(16.0f)), null, 5, null);
        }
        DownloadView downloadView3 = this.downloadViewFloat;
        if (downloadView3 != null) {
            Context context2 = getContext();
            downloadView3.setBackground(context2 != null ? androidx.core.content.b.getDrawable(context2, R$drawable.bg_btn_radius_20) : null);
        }
        ConstraintLayout.b bVar = new ConstraintLayout.b(com.blankj.utilcode.util.a0.a(140.0f), com.blankj.utilcode.util.a0.a(40.0f));
        int i11 = R$id.cl_container;
        bVar.f7759l = i11;
        bVar.f7775t = i11;
        bVar.f7779v = i11;
        bVar.setMargins(0, 0, 0, com.blankj.utilcode.util.a0.a(48.0f));
        so.p mViewBinding = getMViewBinding();
        if (mViewBinding != null && (root = mViewBinding.getRoot()) != null) {
            root.addView(this.downloadViewFloat, -1, bVar);
        }
        DownloadView downloadView4 = this.downloadViewFloat;
        if (downloadView4 != null) {
            downloadView4.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.j2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailCommonFragment.D0(PostDetailCommonFragment.this, view);
                }
            });
        }
        PostSubjectItem postSubjectItem = this.mPostDetailBean;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
            bool = subject.getHasResource();
        }
        a1(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(PostDetailCommonFragment postDetailCommonFragment, View view) {
        String str;
        User user;
        Subject subject;
        ResourceDetectors resourceDetector;
        Group group;
        Subject subject2;
        String subjectId;
        Subject subject3;
        Subject subject4;
        ResourceDetectors resourceDetector2;
        Subject subject5;
        DownloadManagerApi.a aVar = DownloadManagerApi.f58521j;
        DownloadManagerApi a11 = aVar.a();
        PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
        String str2 = null;
        String subjectId2 = (postSubjectItem == null || (subject5 = postSubjectItem.getSubject()) == null) ? null : subject5.getSubjectId();
        PostSubjectItem postSubjectItem2 = postDetailCommonFragment.mPostDetailBean;
        String resourceId = (postSubjectItem2 == null || (subject4 = postSubjectItem2.getSubject()) == null || (resourceDetector2 = subject4.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId();
        PostSubjectItem postSubjectItem3 = postDetailCommonFragment.mPostDetailBean;
        if (DownloadManagerApi.x0(a11, subjectId2, resourceId, (postSubjectItem3 == null || (subject3 = postSubjectItem3.getSubject()) == null) ? false : subject3.isSeries(), false, 8, null)) {
            PostSubjectItem postSubjectItem4 = postDetailCommonFragment.mPostDetailBean;
            if (postSubjectItem4 == null || (subject2 = postSubjectItem4.getSubject()) == null || (subjectId = subject2.getSubjectId()) == null) {
                return;
            }
            DownloadManagerApi a12 = aVar.a();
            Context context = postDetailCommonFragment.getContext();
            Intrinsics.e(context);
            DownloadManagerApi.z0(a12, subjectId, context, postDetailCommonFragment.getPageName(), null, 8, null);
            return;
        }
        DownloadManagerApi a13 = aVar.a();
        Context context2 = postDetailCommonFragment.getContext();
        Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) context2;
        PostSubjectItem postSubjectItem5 = postDetailCommonFragment.mPostDetailBean;
        Subject subject6 = postSubjectItem5 != null ? postSubjectItem5.getSubject() : null;
        String pageName = postDetailCommonFragment.getPageName();
        PostSubjectItem postSubjectItem6 = postDetailCommonFragment.mPostDetailBean;
        String groupId = (postSubjectItem6 == null || (group = postSubjectItem6.getGroup()) == null) ? null : group.getGroupId();
        PostSubjectItem postSubjectItem7 = postDetailCommonFragment.mPostDetailBean;
        String ops = postSubjectItem7 != null ? postSubjectItem7.getOps() : null;
        PostSubjectItem postSubjectItem8 = postDetailCommonFragment.mPostDetailBean;
        if (postSubjectItem8 == null || (subject = postSubjectItem8.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (str = resourceDetector.getResourceLink()) == null) {
            str = "";
        }
        String str3 = str;
        PostSubjectItem postSubjectItem9 = postDetailCommonFragment.mPostDetailBean;
        if (postSubjectItem9 != null && (user = postSubjectItem9.getUser()) != null) {
            str2 = user.getNickname();
        }
        a13.K(fragmentActivity, subject6, pageName, (r25 & 8) != 0 ? "" : groupId, ops, str3, (r25 & 64) != 0 ? "" : null, (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : str2, (r25 & 512) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(PostDetailCommonFragment postDetailCommonFragment, View view) {
        FragmentActivity activity = postDetailCommonFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(PostDetailCommonFragment postDetailCommonFragment, View view) {
        User user;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L)) {
            return;
        }
        Navigator c11 = TheRouter.c("/profile/user_profile");
        PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
        Navigator.x(c11.K("userId", (postSubjectItem == null || (user = postSubjectItem.getUser()) == null) ? null : user.getUserId()), postDetailCommonFragment.requireContext(), null, 2, null);
        com.transsion.postdetail.helper.a.d(com.transsion.postdetail.helper.a.f48920a, postDetailCommonFragment.mPostDetailBean, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(PostDetailCommonFragment postDetailCommonFragment, PostSubjectItem postSubjectItem) {
        if (postSubjectItem == null) {
            PageStatusFragment.showEmptyView$default(postDetailCommonFragment, false, 1, null);
            return Unit.f67184a;
        }
        postDetailCommonFragment.showContentView();
        postDetailCommonFragment.mPostDetailBean = postSubjectItem;
        postSubjectItem.setTran_ops(postDetailCommonFragment.tranOps);
        postDetailCommonFragment.updatePostDetail();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(PostDetailCommonFragment postDetailCommonFragment, String str) {
        if (TextUtils.equals("0", str)) {
            String str2 = postDetailCommonFragment.postId;
            if (str2 != null) {
                ty.b.f76540a.a().e(str2);
            }
            FragmentActivity activity = postDetailCommonFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else {
            b.a aVar = uh.b.f76876a;
            FragmentActivity activity2 = postDetailCommonFragment.getActivity();
            aVar.e(activity2 != null ? activity2.getString(R$string.delete_post_failed) : null);
        }
        return Unit.f67184a;
    }

    private final void L0() {
        Context context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.y1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit M0;
                M0 = PostDetailCommonFragment.M0(PostDetailCommonFragment.this, (AddToDownloadEvent) obj);
                return M0;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(PostDetailCommonFragment postDetailCommonFragment, AddToDownloadEvent value) {
        String subjectId;
        PostSubjectItem postSubjectItem;
        Subject subject;
        Subject subject2;
        Intrinsics.h(value, "value");
        try {
            subjectId = value.getSubjectId();
            postSubjectItem = postDetailCommonFragment.mPostDetailBean;
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        if (!TextUtils.equals(subjectId, (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) ? null : subject2.getSubjectId())) {
            return Unit.f67184a;
        }
        PostSubjectItem postSubjectItem2 = postDetailCommonFragment.mPostDetailBean;
        postDetailCommonFragment.a1((postSubjectItem2 == null || (subject = postSubjectItem2.getSubject()) == null) ? null : subject.getHasResource());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(PostDetailCommonFragment postDetailCommonFragment, LikeEvent value) {
        PostSubjectItem postSubjectItem;
        Long l11;
        Stat stat;
        Stat stat2;
        Long likeCount;
        Stat stat3;
        Stat stat4;
        Long likeCount2;
        Intrinsics.h(value, "value");
        try {
            Result.Companion companion = Result.INSTANCE;
            postSubjectItem = postDetailCommonFragment.mPostDetailBean;
            l11 = null;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (!TextUtils.equals(postSubjectItem != null ? postSubjectItem.getPostId() : null, value.getSubjectId())) {
            return Unit.f67184a;
        }
        PostSubjectItem postSubjectItem2 = postDetailCommonFragment.mPostDetailBean;
        if (postSubjectItem2 != null) {
            postSubjectItem2.setHasLike(Boolean.valueOf(value.getLike()));
        }
        if (value.getLike()) {
            PostSubjectItem postSubjectItem3 = postDetailCommonFragment.mPostDetailBean;
            if (postSubjectItem3 != null && (stat3 = postSubjectItem3.getStat()) != null) {
                PostSubjectItem postSubjectItem4 = postDetailCommonFragment.mPostDetailBean;
                if (postSubjectItem4 != null && (stat4 = postSubjectItem4.getStat()) != null && (likeCount2 = stat4.getLikeCount()) != null) {
                    l11 = Long.valueOf(likeCount2.longValue() + 1);
                }
                stat3.setLikeCount(l11);
            }
        } else {
            PostSubjectItem postSubjectItem5 = postDetailCommonFragment.mPostDetailBean;
            if (postSubjectItem5 != null && (stat = postSubjectItem5.getStat()) != null) {
                PostSubjectItem postSubjectItem6 = postDetailCommonFragment.mPostDetailBean;
                if (postSubjectItem6 != null && (stat2 = postSubjectItem6.getStat()) != null && (likeCount = stat2.getLikeCount()) != null) {
                    l11 = Long.valueOf(likeCount.longValue() - 1);
                }
                stat.setLikeCount(l11);
            }
        }
        postDetailCommonFragment.O0();
        Result.m1185constructorimpl(Unit.f67184a);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0() {
        PostDetailOperationView postDetailOperationView;
        so.p mViewBinding = getMViewBinding();
        if (mViewBinding == null || (postDetailOperationView = mViewBinding.f75787s) == null) {
            return;
        }
        postDetailOperationView.showData(this.mPostDetailBean, new Function0() { // from class: com.transsion.postdetail.ui.fragment.b2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit P0;
                P0 = PostDetailCommonFragment.P0(PostDetailCommonFragment.this);
                return P0;
            }
        }, new Function0() { // from class: com.transsion.postdetail.ui.fragment.c2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit Q0;
                Q0 = PostDetailCommonFragment.Q0(PostDetailCommonFragment.this);
                return Q0;
            }
        }, new Function0() { // from class: com.transsion.postdetail.ui.fragment.d2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit R0;
                R0 = PostDetailCommonFragment.R0(PostDetailCommonFragment.this);
                return R0;
            }
        }, new Function0() { // from class: com.transsion.postdetail.ui.fragment.e2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit S0;
                S0 = PostDetailCommonFragment.S0(PostDetailCommonFragment.this);
                return S0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(PostDetailCommonFragment postDetailCommonFragment) {
        postDetailCommonFragment.clickLike();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(PostDetailCommonFragment postDetailCommonFragment) {
        postDetailCommonFragment.showCommentsDialog();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(PostDetailCommonFragment postDetailCommonFragment) {
        postDetailCommonFragment.doShare();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(PostDetailCommonFragment postDetailCommonFragment) {
        postDetailCommonFragment.clickDownload();
        return Unit.f67184a;
    }

    private final void T0(Media media) {
        NineGridVideoView nineGridVideoView;
        so.p mViewBinding = getMViewBinding();
        if (mViewBinding == null || (nineGridVideoView = mViewBinding.f75786r) == null) {
            return;
        }
        if ((media != null ? media.getImage() : null) == null) {
            jg.c.g(nineGridVideoView);
        } else {
            List<Image> image = media.getImage();
            if (image != null) {
                nineGridVideoView.setAdapter(new NineGridVideoViewAdapter(image));
                nineGridVideoView.loadImage();
            }
            jg.c.k(nineGridVideoView);
        }
        if (qn.b.a(media)) {
            nineGridVideoView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.o2
                @Override // java.lang.Runnable
                public final void run() {
                    PostDetailCommonFragment.U0(PostDetailCommonFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(PostDetailCommonFragment postDetailCommonFragment) {
        postDetailCommonFragment.initPlayer();
    }

    private final void V0(String title, final String content, final String link) {
        final so.m0 m0Var;
        so.o0 o0Var;
        so.p mViewBinding = getMViewBinding();
        if (mViewBinding != null && (o0Var = mViewBinding.f75793y) != null) {
            if (TextUtils.isEmpty(title)) {
                AppCompatTextView tvPostTitle = o0Var.f75768b;
                Intrinsics.g(tvPostTitle, "tvPostTitle");
                jg.c.g(tvPostTitle);
            } else {
                AppCompatTextView tvPostTitle2 = o0Var.f75768b;
                Intrinsics.g(tvPostTitle2, "tvPostTitle");
                jg.c.k(tvPostTitle2);
                o0Var.f75768b.setText(title);
            }
        }
        so.p mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (m0Var = mViewBinding2.f75791w) == null) {
            return;
        }
        m0Var.f75742b.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.z1
            @Override // java.lang.Runnable
            public final void run() {
                PostDetailCommonFragment.W0(content, m0Var, link, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(String str, so.m0 m0Var, String str2, final PostDetailCommonFragment postDetailCommonFragment) {
        Subject subject;
        String subjectId;
        if (TextUtils.isEmpty(str)) {
            ExpandView tvPostDesc = m0Var.f75742b;
            Intrinsics.g(tvPostDesc, "tvPostDesc");
            jg.c.g(tvPostDesc);
            return;
        }
        ExpandView expandView = m0Var.f75742b;
        Intrinsics.e(expandView);
        jg.c.k(expandView);
        if (!TextUtils.isEmpty(str2)) {
            str = str + "\n" + (str2 != null ? StringsKt.Q(str2, " ", "%20", false, 4, null) : null);
        }
        PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
        final boolean z10 = false;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null && (subjectId = subject.getSubjectId()) != null && subjectId.length() > 0) {
            z10 = true;
        }
        com.transsion.baseui.util.l.f(expandView, str, !z10, new Function2() { // from class: com.transsion.postdetail.ui.fragment.f2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit X0;
                X0 = PostDetailCommonFragment.X0(z10, postDetailCommonFragment, (View) obj, (String) obj2);
                return X0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(boolean z10, PostDetailCommonFragment postDetailCommonFragment, View view, String str) {
        String str2;
        User user;
        Subject subject;
        ResourceDetectors resourceDetector;
        if (z10) {
            DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
            FragmentActivity requireActivity = postDetailCommonFragment.requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
            Subject subject2 = postSubjectItem != null ? postSubjectItem.getSubject() : null;
            Intrinsics.e(str);
            String str3 = postDetailCommonFragment.tranOps;
            PostSubjectItem postSubjectItem2 = postDetailCommonFragment.mPostDetailBean;
            if (postSubjectItem2 == null || (subject = postSubjectItem2.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (str2 = resourceDetector.getResourceLink()) == null) {
                str2 = "";
            }
            String str4 = str2;
            PostSubjectItem postSubjectItem3 = postDetailCommonFragment.mPostDetailBean;
            a11.U(requireActivity, subject2, str, "postdetail", str3, str4, (postSubjectItem3 == null || (user = postSubjectItem3.getUser()) == null) ? null : user.getNickname());
        }
        return Unit.f67184a;
    }

    private final void Y0(Integer subjectRate) {
        so.n0 n0Var;
        so.p mViewBinding = getMViewBinding();
        if (mViewBinding == null || (n0Var = mViewBinding.f75777i) == null) {
            return;
        }
        if ((subjectRate != null ? subjectRate.intValue() : 0) <= 0) {
            ConstraintLayout clRating = n0Var.f75751b;
            Intrinsics.g(clRating, "clRating");
            jg.c.g(clRating);
            return;
        }
        ConstraintLayout clRating2 = n0Var.f75751b;
        Intrinsics.g(clRating2, "clRating");
        jg.c.k(clRating2);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
        String string = getString(R$string.score);
        Intrinsics.g(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{subjectRate}, 1));
        Intrinsics.g(format, "format(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        int length = String.valueOf(subjectRate).length();
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(16, true), 0, length, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.getColor(requireActivity(), R$color.color_ffaa33)), 0, length, 17);
        n0Var.f75753d.setText(spannableStringBuilder);
    }

    private final void Z0() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.w p11 = childFragmentManager.p();
        Intrinsics.g(p11, "beginTransaction()");
        PostRecommendFragment a11 = PostRecommendFragment.INSTANCE.a(this.postId);
        p11.s(R$id.flContainer, a11);
        this.mPostRecommendFragment = a11;
        p11.j();
    }

    private final void a1(Boolean hasResource) {
        HashMap g11;
        Subject subject;
        Subject subject2;
        ResourceDetectors resourceDetector;
        Subject subject3;
        if (Intrinsics.c(hasResource, Boolean.TRUE)) {
            DownloadView downloadView = this.downloadViewFloat;
            if (downloadView != null) {
                downloadView.setVisibility(0);
            }
        } else {
            DownloadView downloadView2 = this.downloadViewFloat;
            if (downloadView2 != null) {
                downloadView2.setVisibility(8);
            }
        }
        DownloadView downloadView3 = this.downloadViewFloat;
        if (downloadView3 != null) {
            PostSubjectItem postSubjectItem = this.mPostDetailBean;
            String subjectId = (postSubjectItem == null || (subject3 = postSubjectItem.getSubject()) == null) ? null : subject3.getSubjectId();
            PostSubjectItem postSubjectItem2 = this.mPostDetailBean;
            String resourceId = (postSubjectItem2 == null || (subject2 = postSubjectItem2.getSubject()) == null || (resourceDetector = subject2.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
            PostSubjectItem postSubjectItem3 = this.mPostDetailBean;
            DownloadView.setShowType$default(downloadView3, subjectId, resourceId, (postSubjectItem3 == null || (subject = postSubjectItem3.getSubject()) == null) ? null : Boolean.valueOf(subject.isSeries()), false, 0, 24, null);
        }
        DownloadView downloadView4 = this.downloadViewFloat;
        String str = (downloadView4 == null || downloadView4.getType() != 1) ? "download_subject" : "play_subject";
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(PostDetailCommonFragment postDetailCommonFragment, View view) {
        Group group;
        Navigator c11 = TheRouter.c("/room/detail");
        PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
        Navigator.x(c11.K("id", (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getGroupId()), postDetailCommonFragment.requireContext(), null, 2, null);
        com.transsion.postdetail.helper.a.n(com.transsion.postdetail.helper.a.f48920a, postDetailCommonFragment.mPostDetailBean, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(PostDetailCommonFragment postDetailCommonFragment) {
        Subject subject;
        String subjectId;
        Subject subject2;
        Integer subjectType;
        String c11 = hh.b.f64584b.a().c();
        IMovieDetailService iMovieDetailService = (IMovieDetailService) TheRouter.d(IMovieDetailService.class, new Object[0]);
        if (TextUtils.equals(c11, iMovieDetailService != null ? iMovieDetailService.d() : null)) {
            postDetailCommonFragment.requireActivity().finish();
        } else {
            PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
            if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null && (subjectId = subject.getSubjectId()) != null) {
                Navigator c12 = TheRouter.c("/movie/detail");
                PostSubjectItem postSubjectItem2 = postDetailCommonFragment.mPostDetailBean;
                Navigator K = c12.F("subject_type", (postSubjectItem2 == null || (subject2 = postSubjectItem2.getSubject()) == null || (subjectType = subject2.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()).K("id", subjectId);
                PostSubjectItem postSubjectItem3 = postDetailCommonFragment.mPostDetailBean;
                Navigator.x(K.K("ops", postSubjectItem3 != null ? postSubjectItem3.getOps() : null), postDetailCommonFragment.requireContext(), null, 2, null);
            }
            com.transsion.postdetail.helper.a.D(com.transsion.postdetail.helper.a.f48920a, postDetailCommonFragment.mPostDetailBean, null, null, 6, null);
        }
        return Unit.f67184a;
    }

    private final void clickDownload() {
        String url;
        String str;
        Subject subject;
        ResourceDetectors resourceDetector;
        String resourceLink;
        Subject subject2;
        Subject subject3;
        Integer size;
        String url2;
        Subject subject4;
        ResourceDetectors resourceDetector2;
        PostSubjectItem postSubjectItem;
        Media media;
        Cover cover;
        Media media2;
        List<Audio> audio;
        PostSubjectItem postSubjectItem2 = this.mPostDetailBean;
        Audio audio2 = (postSubjectItem2 == null || (media2 = postSubjectItem2.getMedia()) == null || (audio = media2.getAudio()) == null) ? null : audio.get(0);
        PostSubjectItem postSubjectItem3 = this.mPostDetailBean;
        String title = postSubjectItem3 != null ? postSubjectItem3.getTitle() : null;
        if (TextUtils.isEmpty(title)) {
            PostSubjectItem postSubjectItem4 = this.mPostDetailBean;
            title = postSubjectItem4 != null ? postSubjectItem4.getContent() : null;
        }
        String str2 = title;
        PostSubjectItem postSubjectItem5 = this.mPostDetailBean;
        String coverUrl$default = postSubjectItem5 != null ? PostSubjectItem.getCoverUrl$default(postSubjectItem5, false, 1, null) : null;
        if (TextUtils.isEmpty(coverUrl$default) && ((postSubjectItem = this.mPostDetailBean) == null || (media = postSubjectItem.getMedia()) == null || (cover = media.getCover()) == null || (coverUrl$default = cover.getUrl()) == null)) {
            coverUrl$default = "";
        }
        String str3 = coverUrl$default;
        PostSubjectItem postSubjectItem6 = this.mPostDetailBean;
        if ((postSubjectItem6 != null ? postSubjectItem6.getSubject() : null) != null) {
            PostSubjectItem postSubjectItem7 = this.mPostDetailBean;
            if (postSubjectItem7 != null && (subject4 = postSubjectItem7.getSubject()) != null && (resourceDetector2 = subject4.getResourceDetector()) != null) {
                url = resourceDetector2.getResourceId();
                str = url;
            }
            str = null;
        } else {
            if (audio2 != null) {
                url = audio2.getUrl();
                str = url;
            }
            str = null;
        }
        DownloadBean downloadBean = new DownloadBean((audio2 == null || (url2 = audio2.getUrl()) == null) ? "" : url2, str, str2, str3, (audio2 == null || (size = audio2.getSize()) == null) ? null : Long.valueOf(size.intValue()), "", null, null, null, null, 0L, 0, 0, 1, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -8256, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
        PostSubjectItem postSubjectItem8 = this.mPostDetailBean;
        downloadBean.setPostId(postSubjectItem8 != null ? postSubjectItem8.getPostId() : null);
        PostSubjectItem postSubjectItem9 = this.mPostDetailBean;
        downloadBean.setSubjectId((postSubjectItem9 == null || (subject3 = postSubjectItem9.getSubject()) == null) ? null : subject3.getSubjectId());
        PostSubjectItem postSubjectItem10 = this.mPostDetailBean;
        downloadBean.setSubjectName((postSubjectItem10 == null || (subject2 = postSubjectItem10.getSubject()) == null) ? null : subject2.getTitle());
        DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
        Context context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        PostSubjectItem postSubjectItem11 = this.mPostDetailBean;
        String ops = postSubjectItem11 != null ? postSubjectItem11.getOps() : null;
        PostSubjectItem postSubjectItem12 = this.mPostDetailBean;
        String str4 = (postSubjectItem12 == null || (subject = postSubjectItem12.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? "" : resourceLink;
        PostSubjectItem postSubjectItem13 = this.mPostDetailBean;
        a11.O(fragmentActivity, downloadBean, "post_audio_detail", ops, str4, (r18 & 32) != 0 ? null : postSubjectItem13 != null ? postSubjectItem13.getSubject() : null, (r18 & 64) != 0 ? null : null);
        com.transsion.postdetail.helper.a.j(com.transsion.postdetail.helper.a.f48920a, this.mPostDetailBean, getPageName(), null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void clickLike() {
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_tips);
            return;
        }
        PostSubjectItem postSubjectItem = this.mPostDetailBean;
        int c11 = postSubjectItem != null ? Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE) : 0;
        PostDetailViewModel viewModel = getViewModel();
        PostSubjectItem postSubjectItem2 = this.mPostDetailBean;
        viewModel.G(postSubjectItem2 != null ? postSubjectItem2.getPostId() : null, c11);
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.f48920a;
        PostSubjectItem postSubjectItem3 = this.mPostDetailBean;
        com.transsion.postdetail.helper.a.q(aVar, postSubjectItem3, postSubjectItem3 != null ? Intrinsics.c(postSubjectItem3.getHasLike(), Boolean.TRUE) : false, getPageName(), null, 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void doShare() {
        /*
            r18 = this;
            r0 = r18
            com.transsnet.loginapi.ILoginApi r1 = r18.getMLoginApi()
            r2 = 0
            if (r1 == 0) goto Le
            com.transsnet.loginapi.bean.UserInfo r1 = r1.i()
            goto Lf
        Le:
            r1 = r2
        Lf:
            if (r1 == 0) goto L16
            java.lang.String r3 = r1.getUserId()
            goto L17
        L16:
            r3 = r2
        L17:
            if (r3 == 0) goto L36
            java.lang.String r1 = r1.getUserId()
            com.transsion.moviedetailapi.bean.PostSubjectItem r3 = r0.mPostDetailBean
            if (r3 == 0) goto L2c
            com.transsion.moviedetailapi.bean.User r3 = r3.getUser()
            if (r3 == 0) goto L2c
            java.lang.String r3 = r3.getUserId()
            goto L2d
        L2c:
            r3 = r2
        L2d:
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r3)
            if (r1 == 0) goto L36
            r1 = 1
        L34:
            r11 = r1
            goto L38
        L36:
            r1 = 0
            goto L34
        L38:
            com.transsion.share.share.ShareDialogFragment$a r3 = com.transsion.share.share.ShareDialogFragment.INSTANCE
            com.transsion.share.bean.PostType r4 = com.transsion.share.bean.PostType.POST_TYPE
            com.transsion.moviedetailapi.bean.PostSubjectItem r1 = r0.mPostDetailBean
            if (r1 == 0) goto L46
            java.lang.String r1 = r1.getPostId()
            r5 = r1
            goto L47
        L46:
            r5 = r2
        L47:
            com.transsion.moviedetailapi.bean.PostSubjectItem r1 = r0.mPostDetailBean
            if (r1 == 0) goto L57
            com.transsion.moviedetailapi.bean.User r1 = r1.getUser()
            if (r1 == 0) goto L57
            java.lang.String r1 = r1.getUserId()
            r6 = r1
            goto L58
        L57:
            r6 = r2
        L58:
            com.transsion.usercenterapi.ReportType r1 = com.transsion.usercenterapi.ReportType.POST
            java.lang.String r7 = r1.getValue()
            com.transsion.moviedetailapi.bean.PostSubjectItem r1 = r0.mPostDetailBean
            if (r1 == 0) goto L66
            java.lang.String r2 = r1.getTitle()
        L66:
            r8 = r2
            java.lang.String r14 = r0.tranOps
            r16 = 2304(0x900, float:3.229E-42)
            r17 = 0
            java.lang.String r9 = ""
            r10 = 0
            r12 = 0
            java.lang.String r13 = "postdetail"
            r15 = 0
            com.transsion.share.share.ShareDialogFragment r1 = com.transsion.share.share.ShareDialogFragment.Companion.b(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$b r2 = new com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$b
            r2.<init>()
            r1.G0(r2)
            androidx.fragment.app.FragmentManager r2 = r18.getChildFragmentManager()
            java.lang.String r3 = "share"
            r1.show(r2, r3)
            com.transsion.postdetail.helper.a r4 = com.transsion.postdetail.helper.a.f48920a
            com.transsion.moviedetailapi.bean.PostSubjectItem r5 = r0.mPostDetailBean
            java.lang.String r6 = r18.getPageName()
            r8 = 4
            r9 = 0
            r7 = 0
            com.transsion.postdetail.helper.a.B(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment.doShare():void");
    }

    private final ILoginApi getMLoginApi() {
        return (ILoginApi) this.mLoginApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostDetailViewModel getViewModel() {
        return (PostDetailViewModel) this.viewModel.getValue();
    }

    private final void initPlayer() {
        com.transsion.ninegridview.a aVar = new com.transsion.ninegridview.a();
        aVar.h();
        aVar.i();
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        aVar.j(requireContext);
        qn.a g11 = aVar.g();
        if (g11 != null) {
            g11.a();
        }
        qn.a g12 = aVar.g();
        if (g12 != null) {
            PostSubjectItem postSubjectItem = this.mPostDetailBean;
            so.p mViewBinding = getMViewBinding();
            g12.s(postSubjectItem, mViewBinding != null ? mViewBinding.f75786r : null, 0);
        }
        qn.a g13 = aVar.g();
        if (g13 != null) {
            g13.y(true);
        }
        this.mGifPlayerManager = aVar;
    }

    private final void loadData() {
        String subjectId;
        PostSubjectItem postSubjectItem = this.mPostDetailBean;
        if (postSubjectItem == null) {
            showLoadingView();
            PostDetailViewModel viewModel = getViewModel();
            String str = this.postId;
            viewModel.x(str != null ? str : "");
            return;
        }
        if (postSubjectItem != null) {
            postSubjectItem.setTran_ops(this.tranOps);
        }
        updatePostDetail();
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (subjectId = subject.getSubjectId()) == null || subjectId.length() != 0) {
            return;
        }
        PostDetailViewModel viewModel2 = getViewModel();
        String str2 = this.postId;
        viewModel2.x(str2 != null ? str2 : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi mLoginApi_delegate$lambda$0() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    private final void observeLike() {
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.a2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit N0;
                N0 = PostDetailCommonFragment.N0(PostDetailCommonFragment.this, (LikeEvent) obj);
                return N0;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    private final void setPTParams(PostSubjectItem item) {
        HashMap g11;
        HashMap g12;
        hj.b logViewConfig;
        HashMap g13;
        String mediaType;
        hj.b logViewConfig2;
        HashMap g14;
        hj.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null) {
            logViewConfig3.k(true);
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null) {
            logViewConfig4.n(item.getRec_ops());
        }
        String str = "";
        if (!TextUtils.isEmpty(item.getPostId()) && (logViewConfig2 = getLogViewConfig()) != null && (g14 = logViewConfig2.g()) != null) {
            String postId = item.getPostId();
            if (postId == null) {
                postId = "";
            }
            g14.put("post_id", postId);
        }
        Media media = item.getMedia();
        if (!TextUtils.isEmpty(media != null ? media.getMediaType() : null) && (logViewConfig = getLogViewConfig()) != null && (g13 = logViewConfig.g()) != null) {
            Media media2 = item.getMedia();
            if (media2 != null && (mediaType = media2.getMediaType()) != null) {
                str = mediaType;
            }
            g13.put("post_media_type", str);
        }
        hj.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 != null && (g12 = logViewConfig5.g()) != null) {
            Subject subject = item.getSubject();
            g12.put("subject_id", subject != null ? subject.getSubjectId() : null);
        }
        hj.b logViewConfig6 = getLogViewConfig();
        if (logViewConfig6 == null || (g11 = logViewConfig6.g()) == null) {
            return;
        }
        Subject subject2 = item.getSubject();
        g11.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
    }

    private final void showCommentsDialog() {
        ImmVideoCommentDialog b11 = ImmVideoCommentDialog.Companion.b(ImmVideoCommentDialog.INSTANCE, this.mPostDetailBean, null, null, null, 14, null);
        b11.A0(new d());
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        b11.show(childFragmentManager, "PostDetailCommentsFragment.TAG_POST_DETAIL_COMMENTS_FRAGMENT");
    }

    private final void updatePostDetail() {
        Subject subject;
        String str;
        PostSubjectItem postSubjectItem = this.mPostDetailBean;
        if (postSubjectItem != null) {
            so.p mViewBinding = getMViewBinding();
            Boolean bool = null;
            if (mViewBinding != null) {
                AppCompatTextView appCompatTextView = mViewBinding.A;
                User user = postSubjectItem.getUser();
                appCompatTextView.setText(user != null ? user.getNickname() : null);
                ShapeableImageView shapeableImageView = mViewBinding.f75782n;
                int a11 = com.blankj.utilcode.util.a0.a(28.0f);
                f.a aVar = ej.f.f62005a;
                Context context = shapeableImageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m11 = aVar.m(context);
                User user2 = postSubjectItem.getUser();
                if (user2 == null || (str = user2.getAvatar()) == null) {
                    str = "";
                }
                f.b c11 = m11.g(str).m(a11).c(a11);
                Intrinsics.e(shapeableImageView);
                c11.d(shapeableImageView);
                if (postSubjectItem.getGroup() != null) {
                    AppCompatTextView appCompatTextView2 = mViewBinding.f75794z;
                    Group group = postSubjectItem.getGroup();
                    appCompatTextView2.setText(group != null ? group.getName() : null);
                    AppCompatTextView tvSubject = mViewBinding.f75794z;
                    Intrinsics.g(tvSubject, "tvSubject");
                    jg.c.k(tvSubject);
                    mViewBinding.f75794z.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.k2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PostDetailCommonFragment.b1(PostDetailCommonFragment.this, view);
                        }
                    });
                } else {
                    AppCompatTextView tvSubject2 = mViewBinding.f75794z;
                    Intrinsics.g(tvSubject2, "tvSubject");
                    jg.c.g(tvSubject2);
                }
                AppCompatTextView appCompatTextView3 = mViewBinding.f75792x;
                if (postSubjectItem.getCreatedAt() == null) {
                    Intrinsics.e(appCompatTextView3);
                    jg.c.g(appCompatTextView3);
                } else {
                    Intrinsics.e(appCompatTextView3);
                    jg.c.k(appCompatTextView3);
                    String createdAt = postSubjectItem.getCreatedAt();
                    appCompatTextView3.setText(com.transsion.postdetail.util.n.a(createdAt != null ? Long.parseLong(createdAt) : 0L));
                }
                mViewBinding.f75788t.showData(postSubjectItem, getPageName(), new Function0() { // from class: com.transsion.postdetail.ui.fragment.l2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit c12;
                        c12 = PostDetailCommonFragment.c1(PostDetailCommonFragment.this);
                        return c12;
                    }
                });
            }
            Y0(postSubjectItem.getSubjectRate());
            T0(postSubjectItem.getMedia());
            setPTParams(postSubjectItem);
            String title = postSubjectItem.getTitle();
            String content = postSubjectItem.getContent();
            Link link = postSubjectItem.getLink();
            V0(title, content, link != null ? link.getUrl() : null);
            F0();
            PostSubjectItem postSubjectItem2 = this.mPostDetailBean;
            if (postSubjectItem2 != null && (subject = postSubjectItem2.getSubject()) != null) {
                bool = subject.getHasResource();
            }
            a1(bool);
            O0();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public so.p getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        so.p c11 = so.p.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    public abstract void F0();

    public abstract void G0();

    public final PostSubjectItem getMPostDetailBean() {
        return this.mPostDetailBean;
    }

    public abstract String getPageName();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    public abstract void initAudioListener();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        so.p mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.f75783o) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.g2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailCommonFragment.H0(PostDetailCommonFragment.this, view);
                }
            });
        }
        com.transsion.baseui.util.o oVar = com.transsion.baseui.util.o.f43586a;
        so.p mViewBinding2 = getMViewBinding();
        ShapeableImageView shapeableImageView = mViewBinding2 != null ? mViewBinding2.f75782n : null;
        so.p mViewBinding3 = getMViewBinding();
        oVar.a(new View[]{shapeableImageView, mViewBinding3 != null ? mViewBinding3.A : null}, new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostDetailCommonFragment.I0(PostDetailCommonFragment.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        Z0();
        G0();
        initAudioListener();
        loadData();
        C0();
        L0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        PostDetailViewModel viewModel = getViewModel();
        viewModel.A().j(this, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.m2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit J0;
                J0 = PostDetailCommonFragment.J0(PostDetailCommonFragment.this, (PostSubjectItem) obj);
                return J0;
            }
        }));
        viewModel.t().j(this, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.n2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K0;
                K0 = PostDetailCommonFragment.K0(PostDetailCommonFragment.this, (String) obj);
                return K0;
            }
        }));
        observeLike();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.transsion.ninegridview.a aVar = this.mGifPlayerManager;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.ninegridview.a aVar = this.mGifPlayerManager;
        if (aVar != null) {
            aVar.k();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.ninegridview.a aVar = this.mGifPlayerManager;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        Serializable serializable;
        super.receiveArguments();
        Bundle arguments = getArguments();
        PostSubjectItem postSubjectItem = null;
        this.postId = arguments != null ? arguments.getString("id") : null;
        Bundle arguments2 = getArguments();
        this.fromComment = arguments2 != null ? arguments2.getBoolean("from_comment") : false;
        Bundle arguments3 = getArguments();
        this.tranOps = arguments3 != null ? arguments3.getString("rec_ops") : null;
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (serializable = arguments4.getSerializable("item_object")) != null) {
            postSubjectItem = (PostSubjectItem) serializable;
        }
        this.mPostDetailBean = postSubjectItem;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }
}
