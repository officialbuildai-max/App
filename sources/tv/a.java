package tv;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R$string;
import com.transsion.push.PushConstants;
import com.transsion.search_pugc.fragment.hot.SearchHotFragment;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCreator;
import com.transsion.ugcvideodetail.api.bean.UGCVideoInteractiveInfo;
import com.transsion.ugcvideodetail.dialog.UGCImmVideoCommentDialog;
import com.transsion.ugcvideodetail.dialog.UGCImmVideoPlayListDialog;
import com.transsion.ugcvideodetail.fragment.UGCImmVideoDetailFragment;
import com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;
import qv.r;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final C0955a f76489e = new C0955a(null);

    /* renamed from: a, reason: collision with root package name */
    private final b f76490a;

    /* renamed from: b, reason: collision with root package name */
    private final i f76491b;

    /* renamed from: c, reason: collision with root package name */
    private final e f76492c;

    /* renamed from: d, reason: collision with root package name */
    private ShareDialogFragment f76493d;

    /* renamed from: tv.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0955a {
        private C0955a() {
        }

        public /* synthetic */ C0955a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        r a();

        UGCImmVideoDetailViewModel b();

        UGCImmVideoDetailFragment c();

        String d();

        String e();

        String f();

        boolean g();

        UGCImmVideo getData();

        ILoginApi h();

        void i(boolean z10);
    }

    /* loaded from: classes7.dex */
    public static final class c implements com.transsion.share.share.a {
        c() {
        }

        @Override // com.transsion.share.share.a
        public void a(String id2, PostType postType) {
            Intrinsics.h(id2, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
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

    public a(b host, i reportDelegate, e downloadDelegate) {
        Intrinsics.h(host, "host");
        Intrinsics.h(reportDelegate, "reportDelegate");
        Intrinsics.h(downloadDelegate, "downloadDelegate");
        this.f76490a = host;
        this.f76491b = reportDelegate;
        this.f76492c = downloadDelegate;
    }

    private final void b() {
        UGCImmVideoDetailFragment c11;
        FragmentManager childFragmentManager;
        UGCVideo ugcVideo;
        UGCVideoInteractiveInfo interactiveInfo;
        String commentNum;
        Integer v11;
        UGCVideo ugcVideo2;
        UGCImmVideoDetailFragment c12 = this.f76490a.c();
        if (c12 == null || !c12.isAdded() || (c11 = this.f76490a.c()) == null || (childFragmentManager = c11.getChildFragmentManager()) == null) {
            return;
        }
        i iVar = this.f76491b;
        UGCImmVideo data = this.f76490a.getData();
        String str = null;
        UGCVideo ugcVideo3 = data != null ? data.getUgcVideo() : null;
        UGCImmVideoDetailViewModel b11 = this.f76490a.b();
        iVar.a("comment", ugcVideo3, (r13 & 4) != 0 ? null : b11 != null ? Boolean.valueOf(b11.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        UGCImmVideoCommentDialog.Companion companion = UGCImmVideoCommentDialog.INSTANCE;
        UGCImmVideo data2 = this.f76490a.getData();
        if (data2 != null && (ugcVideo2 = data2.getUgcVideo()) != null) {
            str = ugcVideo2.getUgcVideoId();
        }
        UGCImmVideo data3 = this.f76490a.getData();
        companion.a(str, (data3 == null || (ugcVideo = data3.getUgcVideo()) == null || (interactiveInfo = ugcVideo.getInteractiveInfo()) == null || (commentNum = interactiveInfo.getCommentNum()) == null || (v11 = StringsKt.v(commentNum)) == null) ? 0 : v11.intValue()).show(childFragmentManager, "immComment");
    }

    private final void c() {
        UGCImmVideo data;
        UGCVideo ugcVideo;
        UGCImmVideoDetailFragment c11 = this.f76490a.c();
        FragmentActivity activity = c11 != null ? c11.getActivity() : null;
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? activity : null;
        if (fragmentActivity == null || (data = this.f76490a.getData()) == null || (ugcVideo = data.getUgcVideo()) == null) {
            return;
        }
        if (this.f76490a.g()) {
            this.f76492c.f(ugcVideo, this.f76491b);
            return;
        }
        i iVar = this.f76491b;
        UGCImmVideoDetailViewModel b11 = this.f76490a.b();
        iVar.a("download", ugcVideo, (r13 & 4) != 0 ? null : b11 != null ? Boolean.valueOf(b11.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        this.f76492c.l(fragmentActivity, ugcVideo, this.f76490a.d(), this.f76490a.f(), this.f76490a.e());
    }

    private final void d() {
        UGCVideo ugcVideo;
        String ugcVideoId;
        String favoriteNum;
        Integer v11;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        i iVar = this.f76491b;
        UGCImmVideo data = this.f76490a.getData();
        UGCVideo ugcVideo2 = data != null ? data.getUgcVideo() : null;
        UGCImmVideoDetailViewModel b11 = this.f76490a.b();
        iVar.a("favorite", ugcVideo2, (r13 & 4) != 0 ? null : b11 != null ? Boolean.valueOf(b11.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        UGCImmVideo data2 = this.f76490a.getData();
        if (data2 == null || (ugcVideo = data2.getUgcVideo()) == null || (ugcVideoId = ugcVideo.getUgcVideoId()) == null) {
            return;
        }
        UGCVideoInteractiveInfo interactiveInfo = ugcVideo.getInteractiveInfo();
        boolean c11 = interactiveInfo != null ? Intrinsics.c(interactiveInfo.getHasFavorite(), Boolean.TRUE) : false;
        boolean z10 = !c11;
        com.transsion.baseui.util.m.c(!c11 ? com.transsion.ugcvideodetail.R$string.ugc_video_detail_added_to_list : com.transsion.ugcvideodetail.R$string.ugc_video_detail_removed_from_list);
        this.f76490a.a().C.setSelected(z10);
        UGCVideoInteractiveInfo interactiveInfo2 = ugcVideo.getInteractiveInfo();
        int intValue = (interactiveInfo2 == null || (favoriteNum = interactiveInfo2.getFavoriteNum()) == null || (v11 = StringsKt.v(favoriteNum)) == null) ? 0 : v11.intValue();
        int max = !c11 ? intValue + 1 : Math.max(0, intValue - 1);
        this.f76490a.a().C.setText(String.valueOf(max));
        UGCVideoInteractiveInfo interactiveInfo3 = ugcVideo.getInteractiveInfo();
        if (interactiveInfo3 != null) {
            interactiveInfo3.setFavoriteNum(String.valueOf(max));
        }
        UGCVideoInteractiveInfo interactiveInfo4 = ugcVideo.getInteractiveInfo();
        if (interactiveInfo4 != null) {
            interactiveInfo4.setHasFavorite(Boolean.valueOf(z10));
        }
        UGCImmVideoDetailViewModel b12 = this.f76490a.b();
        if (b12 != null) {
            b12.l0(ugcVideoId, z10);
        }
    }

    private final void e() {
        UGCVideo ugcVideo;
        String ugcVideoId;
        String likeNum;
        Integer v11;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        i iVar = this.f76491b;
        UGCImmVideo data = this.f76490a.getData();
        UGCVideo ugcVideo2 = data != null ? data.getUgcVideo() : null;
        UGCImmVideoDetailViewModel b11 = this.f76490a.b();
        iVar.a("like", ugcVideo2, (r13 & 4) != 0 ? null : b11 != null ? Boolean.valueOf(b11.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        UGCImmVideo data2 = this.f76490a.getData();
        if (data2 == null || (ugcVideo = data2.getUgcVideo()) == null || (ugcVideoId = ugcVideo.getUgcVideoId()) == null) {
            return;
        }
        UGCVideoInteractiveInfo interactiveInfo = ugcVideo.getInteractiveInfo();
        boolean c11 = interactiveInfo != null ? Intrinsics.c(interactiveInfo.getHasLike(), Boolean.TRUE) : false;
        boolean z10 = !c11;
        com.transsion.baseui.util.m.c(!c11 ? com.transsion.ugcvideodetail.R$string.ugc_video_detail_liked : com.transsion.ugcvideodetail.R$string.ugc_video_detail_like_removed);
        UGCVideoInteractiveInfo interactiveInfo2 = ugcVideo.getInteractiveInfo();
        int intValue = (interactiveInfo2 == null || (likeNum = interactiveInfo2.getLikeNum()) == null || (v11 = StringsKt.v(likeNum)) == null) ? 0 : v11.intValue();
        int max = !c11 ? intValue + 1 : Math.max(0, intValue - 1);
        this.f76490a.a().D.setText(String.valueOf(max));
        this.f76490a.a().D.setSelected(z10);
        UGCVideoInteractiveInfo interactiveInfo3 = ugcVideo.getInteractiveInfo();
        if (interactiveInfo3 != null) {
            interactiveInfo3.setLikeNum(String.valueOf(max));
        }
        UGCVideoInteractiveInfo interactiveInfo4 = ugcVideo.getInteractiveInfo();
        if (interactiveInfo4 != null) {
            interactiveInfo4.setHasLike(Boolean.valueOf(z10));
        }
        UGCImmVideoDetailViewModel b12 = this.f76490a.b();
        if (b12 != null) {
            b12.m0(ugcVideoId, z10);
        }
    }

    private final void f() {
        UGCImmVideoDetailFragment c11;
        FragmentManager childFragmentManager;
        Object m1185constructorimpl;
        UGCImmVideoDetailFragment c12 = this.f76490a.c();
        if (c12 != null) {
            boolean z10 = true;
            if (!c12.isAdded() || (c11 = this.f76490a.c()) == null || (childFragmentManager = c11.getChildFragmentManager()) == null) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                UGCImmVideoDetailViewModel b11 = this.f76490a.b();
                if (b11 == null || !b11.Y0()) {
                    z10 = false;
                }
                i iVar = this.f76491b;
                UGCImmVideo data = this.f76490a.getData();
                UGCVideo ugcVideo = data != null ? data.getUgcVideo() : null;
                UGCImmVideoDetailViewModel b12 = this.f76490a.b();
                iVar.a("play_list", ugcVideo, (r13 & 4) != 0 ? null : b12 != null ? Boolean.valueOf(b12.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
                UGCImmVideoPlayListDialog.INSTANCE.a(z10).show(childFragmentManager, "immPlayList");
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result.m1184boximpl(m1185constructorimpl);
        }
    }

    private final void g() {
        UGCVideo ugcVideo;
        UGCVideo ugcVideo2;
        List<String> searchWord;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        i iVar = this.f76491b;
        UGCImmVideo data = this.f76490a.getData();
        UGCVideo ugcVideo3 = data != null ? data.getUgcVideo() : null;
        UGCImmVideoDetailViewModel b11 = this.f76490a.b();
        iVar.a("search", ugcVideo3, (r13 & 4) != 0 ? null : b11 != null ? Boolean.valueOf(b11.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        UGCImmVideo data2 = this.f76490a.getData();
        Navigator K = TheRouter.c(SearchHotFragment.PAGE_NAME).K("keyword", (data2 == null || (ugcVideo2 = data2.getUgcVideo()) == null || (searchWord = ugcVideo2.getSearchWord()) == null) ? null : (String) CollectionsKt.k0(searchWord));
        UGCImmVideo data3 = this.f76490a.getData();
        Navigator z10 = K.K("form_ugc_video_id", (data3 == null || (ugcVideo = data3.getUgcVideo()) == null) ? null : ugcVideo.getUgcVideoId()).z("back_exit", true);
        UGCImmVideoDetailFragment c11 = this.f76490a.c();
        Navigator.x(z10, c11 != null ? c11.requireContext() : null, null, 2, null);
    }

    private final void h() {
        UGCImmVideoDetailFragment c11;
        FragmentManager childFragmentManager;
        ShareDialogFragment shareDialogFragment;
        PostType postType;
        ShareDialogFragment a11;
        UGCVideo ugcVideo;
        UGCVideo ugcVideo2;
        UGCVideo ugcVideo3;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        i iVar = this.f76491b;
        UGCImmVideo data = this.f76490a.getData();
        String str = null;
        UGCVideo ugcVideo4 = data != null ? data.getUgcVideo() : null;
        UGCImmVideoDetailViewModel b11 = this.f76490a.b();
        iVar.a("share", ugcVideo4, (r13 & 4) != 0 ? null : b11 != null ? Boolean.valueOf(b11.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        if (this.f76493d == null) {
            ILoginApi h11 = this.f76490a.h();
            UserInfo i11 = h11 != null ? h11.i() : null;
            ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
            postType = PostType.UGC_VIDEO;
            UGCImmVideo data2 = this.f76490a.getData();
            String ugcVideoId = (data2 == null || (ugcVideo3 = data2.getUgcVideo()) == null) ? null : ugcVideo3.getUgcVideoId();
            String userId = i11 != null ? i11.getUserId() : null;
            String value = ReportType.UFC_VIDEO.getValue();
            UGCImmVideo data3 = this.f76490a.getData();
            String title = (data3 == null || (ugcVideo2 = data3.getUgcVideo()) == null) ? null : ugcVideo2.getTitle();
            UGCImmVideo data4 = this.f76490a.getData();
            if (data4 != null && (ugcVideo = data4.getUgcVideo()) != null) {
                str = ugcVideo.getOps();
            }
            a11 = companion.a(postType, ugcVideoId, userId, value, (r29 & 16) != 0 ? "" : title, (r29 & 32) != 0 ? "" : null, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : false, (r29 & 256) != 0 ? false : false, "UGCVideoDetail", (r29 & 1024) != 0 ? "" : str, (r29 & 2048) != 0 ? "" : null);
            this.f76493d = a11;
            if (a11 != null) {
                a11.G0(new c());
            }
        }
        try {
            UGCImmVideoDetailFragment c12 = this.f76490a.c();
            if (c12 == null || !c12.isAdded() || (c11 = this.f76490a.c()) == null || (childFragmentManager = c11.getChildFragmentManager()) == null) {
                return;
            }
            childFragmentManager.g0();
            ShareDialogFragment shareDialogFragment2 = this.f76493d;
            if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.k0("share") == null && (shareDialogFragment = this.f76493d) != null) {
                shareDialogFragment.show(childFragmentManager, "share");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private final void i() {
        UGCVideo ugcVideo;
        UGCVideoCreator creator;
        String uid;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        UGCImmVideo data = this.f76490a.getData();
        if (data == null || (ugcVideo = data.getUgcVideo()) == null || (creator = ugcVideo.getCreator()) == null || (uid = creator.getUid()) == null) {
            return;
        }
        boolean z10 = !Intrinsics.c(creator.getHasSubscribe(), Boolean.TRUE);
        i iVar = this.f76491b;
        UGCImmVideoDetailViewModel b11 = this.f76490a.b();
        iVar.a(PushConstants.TOPIC_SUBSCRIBE, ugcVideo, (r13 & 4) != 0 ? null : b11 != null ? Boolean.valueOf(b11.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        this.f76490a.i(true);
        AppCompatImageView ivUgcImmSubscribe = this.f76490a.a().f73991p;
        Intrinsics.g(ivUgcImmSubscribe, "ivUgcImmSubscribe");
        jg.c.h(ivUgcImmSubscribe);
        ProgressBar pbUgcImmSubscribeLoading = this.f76490a.a().f73996u;
        Intrinsics.g(pbUgcImmSubscribeLoading, "pbUgcImmSubscribeLoading");
        jg.c.k(pbUgcImmSubscribeLoading);
        UGCImmVideoDetailViewModel b12 = this.f76490a.b();
        if (b12 != null) {
            b12.n0(uid, z10);
        }
    }

    private final void j() {
        UGCVideo ugcVideo;
        String uid;
        UGCImmVideoDetailFragment c11 = this.f76490a.c();
        FragmentActivity activity = c11 != null ? c11.getActivity() : null;
        UGCImmVideo data = this.f76490a.getData();
        if (data == null || (ugcVideo = data.getUgcVideo()) == null || activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        i iVar = this.f76491b;
        UGCImmVideoDetailViewModel b11 = this.f76490a.b();
        iVar.a("user", ugcVideo, (r13 & 4) != 0 ? null : b11 != null ? Boolean.valueOf(b11.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        UGCVideoCreator creator = ugcVideo.getCreator();
        if (creator == null || (uid = creator.getUid()) == null) {
            return;
        }
        Navigator K = TheRouter.c("/profile/user_profile").K("userId", uid);
        UGCImmVideoDetailFragment c12 = this.f76490a.c();
        Navigator.x(K, c12 != null ? c12.requireContext() : null, null, 2, null);
    }

    public final void a(View view) {
        FragmentActivity activity;
        if (com.transsion.baseui.util.c.f43558a.a(view != null ? view.getId() : 0, 500L)) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "UGCImmVideoAction", "onclick, " + view, false, 4, null);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i11 = R$id.ivUgcImmBack;
        if (valueOf != null && valueOf.intValue() == i11) {
            UGCImmVideoDetailFragment c11 = this.f76490a.c();
            if (c11 == null || (activity = c11.getActivity()) == null) {
                return;
            }
            activity.finish();
            return;
        }
        int i12 = R$id.tvUgcImmLike;
        if (valueOf != null && valueOf.intValue() == i12) {
            e();
            return;
        }
        int i13 = R$id.tvUgcImmFavorite;
        if (valueOf != null && valueOf.intValue() == i13) {
            d();
            return;
        }
        int i14 = R$id.tvUgcImmComment;
        if (valueOf != null && valueOf.intValue() == i14) {
            b();
            return;
        }
        int i15 = R$id.ivUgcImmShare;
        if (valueOf != null && valueOf.intValue() == i15) {
            h();
            return;
        }
        int i16 = R$id.ivUgcImmDownload;
        if (valueOf != null && valueOf.intValue() == i16) {
            c();
            return;
        }
        int i17 = R$id.ivUgcImmUserCover;
        if (valueOf == null || valueOf.intValue() != i17) {
            int i18 = R$id.tvUgcImmUserName;
            if (valueOf == null || valueOf.intValue() != i18) {
                int i19 = R$id.ivUgcImmSubscribe;
                if (valueOf != null && valueOf.intValue() == i19) {
                    i();
                    return;
                }
                int i20 = R$id.layoutUgcImmTvEpisode;
                if (valueOf != null && valueOf.intValue() == i20) {
                    f();
                    return;
                }
                int i21 = R$id.layoutUgcImmTvSearch;
                if (valueOf != null && valueOf.intValue() == i21) {
                    g();
                    return;
                }
                return;
            }
        }
        j();
    }
}
