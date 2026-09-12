package tv;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LiveData;
import androidx.view.c0;
import androidx.view.u;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.UGCPageStyle;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoDownload;
import com.transsion.ugcvideodetail.api.bean.UGCVideoDownloadResource;
import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayStream;
import com.transsion.ugcvideodetail.fragment.UGCImmVideoDetailFragment;
import com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.manager.p;
import com.transsnet.downloader.ugc.viewmodel.UGCDownloadViewModel;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final a f76497d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final b f76498a;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f76499b;

    /* renamed from: c, reason: collision with root package name */
    private final c0 f76500c;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z10);

        UGCImmVideoDetailViewModel b();

        UGCImmVideoDetailFragment c();

        String d();

        String e();

        UGCDownloadViewModel f();

        String g();

        UGCImmVideo getData();
    }

    public e(b host) {
        Intrinsics.h(host, "host");
        this.f76498a = host;
        this.f76499b = LazyKt.b(new Function0() { // from class: tv.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                StartDownloadHelper n11;
                n11 = e.n();
                return n11;
            }
        });
        this.f76500c = new c0() { // from class: tv.c
            @Override // androidx.view.c0
            public final void onChanged(Object obj) {
                e.g(e.this, (UGCVideoDownload) obj);
            }
        };
    }

    private final DownloadBean d(Context context, UGCVideoDownload uGCVideoDownload, UGCVideo uGCVideo, String str, String str2, String str3, String str4) {
        String resolutions;
        Integer v11;
        String url;
        String i11 = hj.i.f64628a.i();
        UGCVideoDownloadResource resource = uGCVideoDownload.getResource();
        String str5 = (resource == null || (url = resource.getUrl()) == null) ? "" : url;
        UGCVideoDownloadResource resource2 = uGCVideoDownload.getResource();
        String id2 = resource2 != null ? resource2.getId() : null;
        String title = uGCVideo.getTitle();
        if (title == null) {
            title = uGCVideoDownload.getTitle();
        }
        String str6 = title;
        Cover cover = uGCVideoDownload.getCover();
        String url2 = cover != null ? cover.getUrl() : null;
        UGCVideoDownloadResource resource3 = uGCVideoDownload.getResource();
        Long size = resource3 != null ? resource3.getSize() : null;
        Cover cover2 = uGCVideoDownload.getCover();
        String thumbnail = cover2 != null ? cover2.getThumbnail() : null;
        UGCVideoDownloadResource resource4 = uGCVideoDownload.getResource();
        int intValue = (resource4 == null || (resolutions = resource4.getResolutions()) == null || (v11 = StringsKt.v(resolutions)) == null) ? 0 : v11.intValue();
        UGCVideoDownloadResource resource5 = uGCVideoDownload.getResource();
        long duration = (resource5 != null ? resource5.getDuration() : 0L) * 1000;
        UGCVideoDownloadResource resource6 = uGCVideoDownload.getResource();
        String idType = resource6 != null ? resource6.getIdType() : null;
        String ugcVideoId = uGCVideoDownload.getUgcVideoId();
        int videoUGCPosition = uGCVideo.videoUGCPosition() > 0 ? uGCVideo.videoUGCPosition() : uGCVideoDownload.videoUGCPosition();
        UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
        String collectionId = belongToCollection != null ? belongToCollection.getCollectionId() : null;
        String title2 = uGCVideo.getTitle();
        if (title2 == null) {
            title2 = uGCVideoDownload.getTitle();
        }
        String str7 = title2;
        String category = uGCVideo.getCategory();
        if (category == null) {
            category = uGCVideoDownload.getCategory();
        }
        DownloadBean downloadBean = new DownloadBean(str5, id2, str6, url2, size, null, null, null, Long.valueOf(duration), null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, intValue, 0, 0, 0, 0, 0, 0, "", str, i11, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, thumbnail, null, false, false, 0, null, null, null, null, uGCVideo.getOps(), null, null, null, null, null, null, null, null, idType, collectionId, ugcVideoId, str7, "", Integer.valueOf(videoUGCPosition), category, null, null, null, null, str2, str3, str4, null, Intrinsics.c(uGCVideo.getVideoStyle(), UGCPageStyle.UGC_PAGE_STYLE_IMM_VERTICAL_VIDEO.getValue()), null, null, -940572960, 1071640573, 53728, null);
        downloadBean.setTaskId(UUID.randomUUID().toString());
        UGCVideoDownloadResource resource7 = uGCVideoDownload.getResource();
        downloadBean.setSubtitleIdType(resource7 != null ? resource7.getIdType() : null);
        String str8 = i11 == null ? "" : i11;
        String ops = uGCVideo.getOps();
        String taskId = downloadBean.getTaskId();
        Intrinsics.e(taskId);
        h(context, str, str8, ops, taskId, downloadBean);
        lg.a.f68962a.p("download", new String[]{"UGC视频，开始下载:  resourceId = " + downloadBean.getResourceId() + ", name = " + downloadBean.getName()}, true);
        return downloadBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e eVar, UGCVideoDownload uGCVideoDownload) {
        UGCVideo ugcVideo;
        Object m1185constructorimpl;
        Context requireContext;
        UGCImmVideo data = eVar.f76498a.getData();
        if (data == null || (ugcVideo = data.getUgcVideo()) == null) {
            return;
        }
        if (Intrinsics.c(uGCVideoDownload != null ? uGCVideoDownload.getUgcVideoId() : null, ugcVideo.getUgcVideoId())) {
            a.C0856a.r(lg.a.f68962a, "UGCImmVideoDownload", new String[]{"单视频直接下载，已获取数据执行下载， ugcVideoId:" + ugcVideo.getUgcVideoId() + ", category:" + (uGCVideoDownload != null ? uGCVideoDownload.getCategory() : null)}, false, 4, null);
            if (uGCVideoDownload == null) {
                uh.b.f76876a.d(R$string.notification_download_failed);
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                UGCImmVideoDetailFragment c11 = eVar.f76498a.c();
                if (c11 != null && (requireContext = c11.requireContext()) != null) {
                    eVar.e(requireContext, uGCVideoDownload, ugcVideo, "/ugc_video/immersive_detail", eVar.f76498a.d(), eVar.f76498a.g(), eVar.f76498a.e());
                }
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result.m1184boximpl(m1185constructorimpl);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x00a4, code lost:
    
        if (r4 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void h(android.content.Context r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, com.transsion.baselib.db.download.DownloadBean r20) {
        /*
            r14 = this;
            java.lang.String r0 = "page_from"
            r1 = r17
            kotlin.Pair r0 = kotlin.TuplesKt.a(r0, r1)
            java.lang.String r1 = "ops"
            r2 = r18
            kotlin.Pair r1 = kotlin.TuplesKt.a(r1, r2)
            java.lang.String r2 = r20.getResourceId()
            java.lang.String r3 = "resource_id"
            kotlin.Pair r2 = kotlin.TuplesKt.a(r3, r2)
            java.lang.String r4 = "task_id"
            r5 = r19
            kotlin.Pair r4 = kotlin.TuplesKt.a(r4, r5)
            java.lang.String r5 = "refer_subject_id"
            java.lang.String r6 = r20.getSubjectId()
            kotlin.Pair r5 = kotlin.TuplesKt.a(r5, r6)
            java.lang.String r6 = "content_id"
            java.lang.String r7 = r20.getUgcVideoId()
            kotlin.Pair r6 = kotlin.TuplesKt.a(r6, r7)
            java.lang.String r7 = "belong_to_collection_id"
            java.lang.String r8 = r20.getUgcVideoCollectionId()
            kotlin.Pair r7 = kotlin.TuplesKt.a(r7, r8)
            java.lang.String r8 = "category_type"
            java.lang.String r9 = r20.getUgcVideoType()
            kotlin.Pair r8 = kotlin.TuplesKt.a(r8, r9)
            java.lang.String r9 = "video_track_id"
            java.lang.String r10 = r20.getUgcVideoTrackId()
            kotlin.Pair r9 = kotlin.TuplesKt.a(r9, r10)
            java.lang.String r10 = "video_parent_content_id"
            java.lang.String r11 = r20.getUgcVideoParentVideoId()
            kotlin.Pair r10 = kotlin.TuplesKt.a(r10, r11)
            java.lang.String r11 = "video_parent_video_track_id"
            java.lang.String r12 = r20.getUgcVideoParentTrackId()
            kotlin.Pair r11 = kotlin.TuplesKt.a(r11, r12)
            r12 = 11
            kotlin.Pair[] r12 = new kotlin.Pair[r12]
            r13 = 0
            r12[r13] = r0
            r0 = 1
            r12[r0] = r1
            r0 = 2
            r12[r0] = r2
            r0 = 3
            r12[r0] = r4
            r0 = 4
            r12[r0] = r5
            r0 = 5
            r12[r0] = r6
            r0 = 6
            r12[r0] = r7
            r0 = 7
            r12[r0] = r8
            r0 = 8
            r12[r0] = r9
            r0 = 9
            r12[r0] = r10
            r0 = 10
            r12[r0] = r11
            java.util.Map r0 = kotlin.collections.MapsKt.l(r12)
            hj.i r1 = hj.i.f64628a
            java.lang.String r2 = "download_click"
            if (r16 == 0) goto La6
            boolean r4 = kotlin.text.StringsKt.q0(r16)
            if (r4 != 0) goto La3
            r4 = r16
            goto La4
        La3:
            r4 = 0
        La4:
            if (r4 != 0) goto La7
        La6:
            r4 = r2
        La7:
            r1.s(r4, r2, r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = r20.getResourceId()
            r0.putString(r3, r1)
            com.transsion.baselib.report.e r1 = com.transsion.baselib.report.e.f43398a
            r3 = r15
            r1.l(r2, r0, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.e.h(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.transsion.baselib.db.download.DownloadBean):void");
    }

    private final StartDownloadHelper i() {
        return (StartDownloadHelper) this.f76499b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(e eVar, UGCVideo uGCVideo, int i11, String formatSize, DownloadBean downloadBean, boolean z10) {
        Intrinsics.h(formatSize, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        UGCImmVideoDetailFragment c11 = eVar.f76498a.c();
        if (c11 != null) {
            c11.c1(uGCVideo.getUgcVideoId());
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StartDownloadHelper n() {
        return new StartDownloadHelper();
    }

    public final void e(Context context, UGCVideoDownload data, UGCVideo ugcVideo, String pageFrom, String trackId, String str, String str2) {
        Intrinsics.h(context, "context");
        Intrinsics.h(data, "data");
        Intrinsics.h(ugcVideo, "ugcVideo");
        Intrinsics.h(pageFrom, "pageFrom");
        Intrinsics.h(trackId, "trackId");
        DownloadBean d11 = d(context, data, ugcVideo, pageFrom, trackId, str, str2);
        p.f59623a.a(Utils.a()).p(d11);
        i().f(CollectionsKt.q(d11));
        DownloadManagerApi.f58521j.a().T(d11.getSubjectId(), d11.getResourceId(), d11.isSeries(), d11.getTotalEpisode(), d11.isMultiresolution(), d11.isMultiresolution());
    }

    public final void f(UGCVideo video, i reportDelegate) {
        UGCVideoPlayInfo playInfo;
        List<UGCVideoPlayStream> resources;
        UGCVideoPlayStream uGCVideoPlayStream;
        Context requireContext;
        UGCImmVideo data;
        Intrinsics.h(video, "video");
        Intrinsics.h(reportDelegate, "reportDelegate");
        UGCImmVideo data2 = this.f76498a.getData();
        if (data2 != null && (playInfo = data2.getPlayInfo()) != null && (resources = playInfo.getResources()) != null && (uGCVideoPlayStream = (UGCVideoPlayStream) CollectionsKt.k0(resources)) != null && (!uGCVideoPlayStream.isOnline() || ((data = this.f76498a.getData()) != null && data.getDownloadStatus() == 5))) {
            UGCImmVideoDetailFragment c11 = this.f76498a.c();
            if (c11 == null || (requireContext = c11.requireContext()) == null) {
                return;
            }
            UGCImmVideoDetailViewModel b11 = this.f76498a.b();
            reportDelegate.a("downloaded", video, (r13 & 4) != 0 ? null : b11 != null ? Boolean.valueOf(b11.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
            Navigator.x(TheRouter.c("/download/ugc_my_downloads").F("main_tab_index", 1), requireContext, null, 2, null);
            return;
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
            return;
        }
        UGCImmVideoDetailViewModel b12 = this.f76498a.b();
        reportDelegate.a("download", video, (r13 & 4) != 0 ? null : b12 != null ? Boolean.valueOf(b12.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        String ugcVideoId = video.getUgcVideoId();
        if (ugcVideoId != null) {
            this.f76498a.a(true);
            a.C0856a.r(lg.a.f68962a, "UGCImmVideoDownload", new String[]{"单视频直接下载，点击去请求下载数据--， ugcVideoId:" + video.getUgcVideoId() + "}"}, false, 4, null);
            UGCDownloadViewModel f11 = this.f76498a.f();
            if (f11 != null) {
                f11.H(ugcVideoId);
            }
            UGCImmVideoDetailFragment c12 = this.f76498a.c();
            if (c12 != null) {
                c12.c1(ugcVideoId);
            }
        }
    }

    public final void j(u owner) {
        LiveData z10;
        Intrinsics.h(owner, "owner");
        UGCDownloadViewModel f11 = this.f76498a.f();
        if (f11 == null || (z10 = f11.z()) == null) {
            return;
        }
        z10.j(owner, this.f76500c);
    }

    public final void k(u owner) {
        LiveData z10;
        Intrinsics.h(owner, "owner");
        UGCDownloadViewModel f11 = this.f76498a.f();
        if (f11 == null || (z10 = f11.z()) == null) {
            return;
        }
        z10.o(this.f76500c);
    }

    public final void l(FragmentActivity activity, final UGCVideo video, String trackId, String str, String str2) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(video, "video");
        Intrinsics.h(trackId, "trackId");
        DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
        UGCVideoBelongToCollection belongToCollection = video.getBelongToCollection();
        String collectionId = belongToCollection != null ? belongToCollection.getCollectionId() : null;
        String ugcVideoId = video.getUgcVideoId();
        UGCVideoBelongToCollection belongToCollection2 = video.getBelongToCollection();
        a11.f0(activity, collectionId, ugcVideoId, belongToCollection2 != null ? belongToCollection2.getCollectionName() : null, video.getCategory(), "/ugc_video/immersive_detail", video.getOps(), video.getSubjectId(), trackId, str, str2, Intrinsics.c(video.getVideoStyle(), UGCPageStyle.UGC_PAGE_STYLE_IMM_VERTICAL_VIDEO.getValue()), new Function4() { // from class: tv.d
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit m11;
                m11 = e.m(e.this, video, ((Integer) obj).intValue(), (String) obj2, (DownloadBean) obj3, ((Boolean) obj4).booleanValue());
                return m11;
            }
        });
    }
}
