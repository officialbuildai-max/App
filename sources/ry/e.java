package ry;

import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsion.upload.log.UploadLoggerManager;
import com.transsion.web.api.WebConstants;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import hj.i;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final a f74878c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f74879d = LazyKt.b(new Function0() { // from class: ry.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            e h11;
            h11 = e.h();
            return h11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f74880a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f74881b = LazyKt.b(new Function0() { // from class: ry.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi i11;
            i11 = e.i();
            return i11;
        }
    });

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return (e) e.f74879d.getValue();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements cw.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f74882a;

        b(Function1 function1) {
            this.f74882a = function1;
        }

        @Override // cw.a
        public void a(String uploadKey, long j11, long j12) {
            Intrinsics.h(uploadKey, "uploadKey");
        }

        @Override // cw.a
        public void b(String uploadKey, String url, String bucket) {
            Intrinsics.h(uploadKey, "uploadKey");
            Intrinsics.h(url, "url");
            Intrinsics.h(bucket, "bucket");
            this.f74882a.invoke(url);
        }

        @Override // cw.a
        public void c(String str, String str2, String str3, UploadTstTokenStorageType uploadTstTokenStorageType) {
            this.f74882a.invoke(null);
        }
    }

    private final void e(g gVar, DownloadBean downloadBean, long j11, HashMap hashMap) {
        long c11 = j11 - gVar.c();
        if (gVar.c() > 0 && c11 > 0 && c11 < TimeUnit.MINUTES.toMillis(2L)) {
            downloadBean.setSessionTime(downloadBean.getSessionTime() + c11);
        }
        gVar.f(0L);
        hashMap.put("full_time", String.valueOf(j11 - downloadBean.getCreateAt()));
        hashMap.put("real_time", String.valueOf(downloadBean.getSessionTime()));
    }

    private final void f(g gVar, HashMap hashMap) {
        hashMap.put("fail_times", String.valueOf(gVar.a()));
        hashMap.put("pause_times", String.valueOf(gVar.b()));
    }

    private final ILoginApi g() {
        return (ILoginApi) this.f74881b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e h() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi i() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(e eVar, DownloadBean downloadBean, Function0 function0, String str) {
        eVar.m(downloadBean, str);
        function0.invoke();
        return Unit.f67184a;
    }

    private final void m(DownloadBean downloadBean, String str) {
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        ILoginApi g11 = g();
        UserInfo i11 = g11 != null ? g11.i() : null;
        hashMap.put("opt_type", "re_download");
        hashMap.put("url", downloadBean.getUrl());
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = "";
        }
        hashMap.put("resource_id", resourceId);
        String subjectId = downloadBean.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        hashMap.put("subject_id", subjectId);
        String postId = downloadBean.getPostId();
        if (postId == null) {
            postId = "";
        }
        hashMap.put("post_id", postId);
        hashMap.put("media_type", String.valueOf(downloadBean.getType()));
        hashMap.put(NotificationCompat.CATEGORY_STATUS, downloadBean.toString());
        hashMap.put("size", String.valueOf(downloadBean.getSize()));
        hashMap.put(NotificationCompat.CATEGORY_PROGRESS, String.valueOf(downloadBean.getProgress()));
        String lastPageFrom = downloadBean.getLastPageFrom();
        if (lastPageFrom == null) {
            lastPageFrom = "";
        }
        hashMap.put(WebConstants.PAGE_FROM, lastPageFrom);
        String taskId = downloadBean.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        hashMap.put("task_id", taskId);
        hashMap.put("url_create_at", String.valueOf(downloadBean.getUrlCreateAt() == 0 ? downloadBean.getCreateAt() : downloadBean.getUrlCreateAt()));
        String ops = downloadBean.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        String path = downloadBean.getPath();
        if (path == null) {
            path = "";
        }
        hashMap.put("path", path);
        if (i11 == null || (str2 = i11.getUsername()) == null) {
            str2 = "";
        }
        hashMap.put("user_name", str2);
        if (i11 == null || (str3 = i11.getUserId()) == null) {
            str3 = "";
        }
        hashMap.put("user_id", str3);
        if (str == null) {
            str = "";
        }
        hashMap.put("log_url", str);
        i iVar = i.f64628a;
        String pageFrom = downloadBean.getPageFrom();
        if (pageFrom == null) {
            pageFrom = "download_link";
        }
        iVar.s(pageFrom, "app_perf", hashMap);
    }

    private final void n(Function1 function1) {
        UploadLoggerManager.f56759a.k(new b(function1));
    }

    public final Object j(DownloadBean downloadBean, oy.c cVar, Continuation continuation) {
        boolean z10;
        int i11;
        boolean z11;
        String resourceId = downloadBean.getResourceId();
        int status = downloadBean.getStatus();
        String taskId = downloadBean.getTaskId();
        if (com.transsion.baseui.util.c.f43558a.a((taskId + status).hashCode(), 2000L)) {
            return Unit.f67184a;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        g gVar = (g) this.f74880a.get(taskId);
        if (gVar == null) {
            gVar = new g(downloadBean.getUrl(), taskId, status);
            this.f74880a.put(taskId, gVar);
        }
        g gVar2 = gVar;
        HashMap hashMap = new HashMap();
        if (status == 1) {
            z10 = true;
            i11 = 2;
            if (downloadBean.getReportStatus() >= 1) {
                return Unit.f67184a;
            }
            downloadBean.setReportStatus(1);
        } else if (status == 2) {
            z10 = true;
            i11 = 2;
            long c11 = elapsedRealtime - gVar2.c();
            if (gVar2.c() > 0 && c11 > 0 && c11 < TimeUnit.MINUTES.toMillis(2L)) {
                downloadBean.setSessionTime(downloadBean.getSessionTime() + c11);
            }
            gVar2.f(elapsedRealtime);
            if (downloadBean.getReportStatus() >= 2) {
                return Unit.f67184a;
            }
            downloadBean.setReportStatus(2);
        } else if (status == 4) {
            z10 = true;
            i11 = 2;
            downloadBean.setReportStatus(4);
            gVar2.e(gVar2.b() + 1);
            gVar2.f(0L);
            f(gVar2, hashMap);
        } else if (status != 5) {
            if (status == 6) {
                z11 = true;
                i11 = 2;
                gVar2.d(gVar2.a() + 1);
                gVar2.f(0L);
                downloadBean.setReportStatus(6);
                f(gVar2, hashMap);
            } else if (status != 7) {
                z10 = true;
                i11 = 2;
            } else {
                if (downloadBean.getReportStatus() == 5) {
                    status = 57;
                }
                z11 = true;
                i11 = 2;
                e(gVar2, downloadBean, elapsedRealtime, hashMap);
            }
            z10 = z11;
        } else {
            i11 = 2;
            z10 = true;
            e(gVar2, downloadBean, elapsedRealtime, hashMap);
            this.f74880a.remove(taskId);
        }
        hashMap.put("url", downloadBean.getUrl());
        hashMap.put("resource_id", resourceId);
        hashMap.put("subject_id", downloadBean.getSubjectId());
        hashMap.put("post_id", downloadBean.getPostId());
        hashMap.put("media_type", String.valueOf(downloadBean.getType()));
        hashMap.put(NotificationCompat.CATEGORY_STATUS, String.valueOf(status));
        hashMap.put("size", String.valueOf(downloadBean.getSize()));
        hashMap.put(NotificationCompat.CATEGORY_PROGRESS, String.valueOf(downloadBean.getProgress()));
        hashMap.put(WebConstants.PAGE_FROM, downloadBean.getLastPageFrom());
        hashMap.put("task_id", downloadBean.getTaskId());
        hashMap.put("url_create_at", String.valueOf(downloadBean.getUrlCreateAt() == 0 ? downloadBean.getCreateAt() : downloadBean.getUrlCreateAt()));
        hashMap.put("ops", downloadBean.getOps());
        hashMap.put("path", downloadBean.getPath());
        if (downloadBean.getEp() > 0) {
            hashMap.put("ep", String.valueOf(downloadBean.getEp()));
        }
        if (downloadBean.getSe() > 0) {
            hashMap.put("se", String.valueOf(downloadBean.getSe()));
        }
        if (status == 7 || status == 57) {
            hashMap.put("pre_status", String.valueOf(downloadBean.getPreStatus()));
        }
        String ugcVideoId = downloadBean.getUgcVideoId();
        if (ugcVideoId != null) {
            hashMap.put("content_id", ugcVideoId);
            hashMap.put("content_type", "ugc_video");
        }
        String ugcVideoCollectionId = downloadBean.getUgcVideoCollectionId();
        if (ugcVideoCollectionId != null) {
            hashMap.put("belong_to_collection_id", ugcVideoCollectionId);
        }
        String ugcVideoType = downloadBean.getUgcVideoType();
        if (ugcVideoType != null) {
            hashMap.put("category_type", ugcVideoType);
        }
        hashMap.put("video_track_id", downloadBean.getUgcVideoTrackId());
        hashMap.put("parent_video_video_id", downloadBean.getUgcVideoParentVideoId());
        hashMap.put("parent_video_track_id", downloadBean.getUgcVideoParentTrackId());
        if (status == 6) {
            DownloadException exception = downloadBean.getException();
            hashMap.put("error_code", String.valueOf(exception != null ? Boxing.d(exception.getCode()) : null));
            DownloadException exception2 = downloadBean.getException();
            hashMap.put("error_response_code", String.valueOf(exception2 != null ? Boxing.d(exception2.getResponseCode()) : null));
            DownloadException exception3 = downloadBean.getException();
            hashMap.put(OfflineConstantsKt.TRACK_KEY_PRE_ERROR_MSG, exception3 != null ? exception3.getMessage() : null);
            DownloadException exception4 = downloadBean.getException();
            hashMap.put("error_format_msg", exception4 != null ? exception4.getFormatMessage() : null);
            DownloadException exception5 = downloadBean.getException();
            hashMap.put("download_range", exception5 != null ? exception5.getRange() : null);
            try {
                Result.Companion companion = Result.INSTANCE;
                if (downloadBean.is4xxError() && downloadBean.getUrl() != null && StringsKt.W(downloadBean.getUrl(), "http", false, i11, null)) {
                    InetAddress[] allByName = InetAddress.getAllByName(new URL(downloadBean.getUrl()).getHost());
                    StringBuilder sb2 = new StringBuilder("");
                    Iterator a11 = ArrayIteratorKt.a(allByName);
                    while (a11.hasNext()) {
                        InetAddress inetAddress = (InetAddress) a11.next();
                        if (sb2.length() > 0) {
                            sb2.append(",");
                        }
                        sb2.append(inetAddress);
                    }
                    hashMap.put("download_ips", sb2.toString());
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
        i iVar = i.f64628a;
        String pageFrom = downloadBean.getPageFrom();
        if (pageFrom == null) {
            pageFrom = "download_link";
        }
        iVar.s(pageFrom, "download", hashMap);
        if (5 <= status && status < 58) {
            lg.a.f68962a.c("download", iVar.o(hashMap), z10);
        }
        return Unit.f67184a;
    }

    public final void k(final DownloadBean bean, final Function0 function0) {
        Intrinsics.h(bean, "bean");
        if (function0 != null) {
            n(new Function1() { // from class: ry.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit l11;
                    l11 = e.l(e.this, bean, function0, (String) obj);
                    return l11;
                }
            });
        } else {
            m(bean, null);
        }
    }
}
