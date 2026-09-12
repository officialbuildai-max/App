package com.transsion.postdetail.ui.activity;

import ak.x;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.view.ViewModelLazy;
import androidx.view.c0;
import androidx.view.v0;
import androidx.view.x0;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.fragment.PostAudioDetailFragment;
import com.transsion.postdetail.ui.fragment.PostDetailFragment;
import com.transsion.postdetail.ui.fragment.VideoFragment;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.room.api.IFloatingApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\tJ\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010\tJ\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\tJ\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010\u001cJ\u000f\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010,R\u0016\u00103\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b4\u0010,R\u0016\u00108\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b9\u00102R\u0018\u0010<\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b;\u0010,R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bA\u0010,R\u0016\u0010D\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bC\u00102R\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010,¨\u0006T"}, d2 = {"Lcom/transsion/postdetail/ui/activity/PostDetailActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lso/d;", "<init>", "()V", "", "M0", "", "L0", "()Z", "N0", "", "mediaType", "Landroidx/fragment/app/Fragment;", "Q0", "(Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "O0", "P0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "onResume", "onStop", "H0", "()Lso/d;", "i0", "()Ljava/lang/String;", "o0", "p0", "n0", "s0", "isTranslucent", "isChangeStatusBar", "", "statusColor", "()I", "isStatusDark", "r0", "retryLoadData", "getPageName", "d0", "i", "Ljava/lang/String;", com.mbridge.msdk.foundation.same.report.j.f35620b, "postId", CampaignEx.JSON_KEY_AD_K, "itemType", "l", "Z", "fromComment", "m", "ops", "n", "I", "tabId", "o", "videoLoadMore", TtmlNode.TAG_P, "pageFrom", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", CampaignEx.JSON_KEY_AD_Q, "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "itemObject", CampaignEx.JSON_KEY_AD_R, "commentId", "s", "needBackToRoom", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "t", "Lkotlin/Lazy;", "I0", "()Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "viewModel", TmcStartParams.KEY_URL_SHORT, "Landroidx/fragment/app/Fragment;", "mFragment", "v", "target", "w", "emptyDesc", "x", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class PostDetailActivity extends BaseNewActivity<so.d> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public String mediaType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public String postId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public String itemType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public boolean fromComment;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public String ops;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public int tabId;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public String pageFrom;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public PostSubjectItem itemObject;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public String commentId;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public boolean needBackToRoom;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private Fragment mFragment;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private Fragment target;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public boolean videoLoadMore = true;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private String emptyDesc = "";

    /* loaded from: classes6.dex */
    static final class b implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f49402a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f49402a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f49402a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f49402a.invoke(obj);
        }
    }

    public PostDetailActivity() {
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.b(PostDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<p1.a>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final p1.a invoke() {
                p1.a aVar;
                Function0 function02 = Function0.this;
                return (function02 == null || (aVar = (p1.a) function02.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
            }
        });
    }

    private final PostDetailViewModel I0() {
        return (PostDetailViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(PostDetailActivity postDetailActivity, PostSubjectItem postSubjectItem) {
        if (postSubjectItem == null) {
            postDetailActivity.y0();
        } else {
            Media media = postSubjectItem.getMedia();
            String mediaType = media != null ? media.getMediaType() : null;
            postDetailActivity.mediaType = mediaType;
            if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
                ImmVideoHelper.f48894h.a().s(postSubjectItem);
            }
            postDetailActivity.itemObject = postSubjectItem;
            postDetailActivity.w0();
            postDetailActivity.N0();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(PostDetailActivity postDetailActivity, String str) {
        if (Intrinsics.c(str, "404")) {
            String string = postDetailActivity.getString(R$string.post_delete_tips);
            Intrinsics.g(string, "getString(...)");
            postDetailActivity.emptyDesc = string;
        }
        return Unit.f67184a;
    }

    private final boolean L0() {
        return Intrinsics.c(MediaType.VIDEO.getValue(), this.mediaType) || Intrinsics.c(MediaType.AUDIO.getValue(), this.mediaType) || x.f733a.a();
    }

    private final void M0() {
        String str;
        z0();
        if (!nh.m.f70597a.e()) {
            B0();
            return;
        }
        if (this.postId == null || !((str = this.mediaType) == null || str.length() == 0)) {
            N0();
            return;
        }
        PostDetailViewModel I0 = I0();
        String str2 = this.postId;
        if (str2 == null) {
            str2 = "";
        }
        I0.x(str2);
    }

    private final void N0() {
        P0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p11 = supportFragmentManager.p();
        Intrinsics.g(p11, "beginTransaction()");
        Fragment Q0 = Q0(this.mediaType);
        if (Q0 != null) {
            p11.s(R$id.container, Q0);
        } else {
            Q0 = null;
        }
        this.target = Q0;
        p11.j();
    }

    private final void O0() {
        IFloatingApi iFloatingApi;
        if (!TextUtils.equals(MediaType.VIDEO.getValue(), this.mediaType) || (iFloatingApi = (IFloatingApi) TheRouter.d(IFloatingApi.class, new Object[0])) == null) {
            return;
        }
        iFloatingApi.e();
    }

    private final void P0() {
        IFloatingApi iFloatingApi;
        if (!TextUtils.equals(MediaType.VIDEO.getValue(), this.mediaType) || (iFloatingApi = (IFloatingApi) TheRouter.d(IFloatingApi.class, new Object[0])) == null) {
            return;
        }
        iFloatingApi.c();
    }

    private final Fragment Q0(String mediaType) {
        Fragment a11;
        if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
            x0();
            PostSubjectItem postSubjectItem = this.itemObject;
            if (postSubjectItem != null) {
                ImmVideoHelper.f48894h.a().s(postSubjectItem);
            }
            a11 = VideoFragment.INSTANCE.a(this.postId, this.itemType, Integer.valueOf(this.tabId), this.videoLoadMore, (r30 & 16) != 0 ? true : this.fromComment, (r30 & 32) != 0 ? "" : this.ops, (r30 & 64) != 0 ? false : false, (r30 & 128) != 0 ? "" : this.commentId, (r30 & 256) != 0 ? null : this.pageFrom, (r30 & 512) != 0 ? false : this.needBackToRoom, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? false : false, (r30 & 4096) != 0 ? false : false);
        } else {
            setRequestedOrientation(1);
            a11 = PostDetailFragment.INSTANCE.a(this.postId, this.fromComment, this.ops, this.itemObject, this.commentId, this.pageFrom);
        }
        this.mFragment = a11;
        return a11;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public so.d getViewBinding() {
        so.d c11 = so.d.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    /* renamed from: d0, reason: from getter */
    public String getEmptyDesc() {
        return this.emptyDesc;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "postdetail";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String i0() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isChangeStatusBar() {
        return L0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        if (L0()) {
            return false;
        }
        return super.isStatusDark();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void n0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void o0() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.needBackToRoom) {
            aq.h.i(aq.h.f16175a, null, null, null, false, 15, null);
            finish();
            return;
        }
        Fragment fragment = this.mFragment;
        if (fragment instanceof PostAudioDetailFragment) {
            Intrinsics.f(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.PostAudioDetailFragment");
            ((PostAudioDetailFragment) fragment).p1();
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
        com.transsion.baselib.report.l.f43413a.x(3, this);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        P0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseNewActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        O0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void p0() {
        I0().A().j(this, new b(new Function1() { // from class: com.transsion.postdetail.ui.activity.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit J0;
                J0 = PostDetailActivity.J0(PostDetailActivity.this, (PostSubjectItem) obj);
                return J0;
            }
        }));
        I0().y().j(this, new b(new Function1() { // from class: com.transsion.postdetail.ui.activity.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K0;
                K0 = PostDetailActivity.K0(PostDetailActivity.this, (String) obj);
                return K0;
            }
        }));
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean r0() {
        if (Intrinsics.c(MediaType.VIDEO.getValue(), this.mediaType)) {
            return false;
        }
        return super.r0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        if (this.target == null) {
            M0();
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void s0() {
        M0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public int statusColor() {
        return L0() ? R$color.gray_0_1 : super.statusColor();
    }
}
