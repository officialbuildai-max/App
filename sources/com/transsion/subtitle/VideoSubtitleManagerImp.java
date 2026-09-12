package com.transsion.subtitle;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle.helper.SubtitleSearchHelper;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.bean.SubtitleAppType;
import com.transsnet.downloader.manager.p;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import lj.v0;

/* loaded from: classes.dex */
public final class VideoSubtitleManagerImp implements h {

    /* renamed from: g, reason: collision with root package name */
    public static final a f54854g = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f54855b = LazyKt.b(new Function0() { // from class: com.transsion.subtitle.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            v0 D;
            D = VideoSubtitleManagerImp.D();
            return D;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private Set f54856c = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    private final String f54857d = VideoSubtitleManagerImp.class.getSimpleName();

    /* renamed from: e, reason: collision with root package name */
    private final n0 f54858e = o0.a(y0.c());

    /* renamed from: f, reason: collision with root package name */
    private final VideoSubtitleManagerImp$resDownloadListener$1 f54859f = new VideoSubtitleManagerImp$resDownloadListener$1(this);

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final v0 A() {
        return (v0) this.f54855b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String B() {
        return com.transsion.baselib.report.launch.b.f43424a.b().getString("k_language_short_name", null);
    }

    private final void C() {
        if (!com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("subtitle_old_db_move", false)) {
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new VideoSubtitleManagerImp$initOldSubtitleMoveDB$1(this, null), 3, null);
            return;
        }
        lg.a.f68962a.c(com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " 转移数据库, 已转移过，不再处理", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v0 D() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).z1();
    }

    private final void s(DownloadBean downloadBean, Function1 function1) {
        if (!downloadBean.isVideo() || downloadBean.isMusic()) {
            return;
        }
        if (nh.m.f70597a.e()) {
            if (downloadBean.isUGCVideo()) {
                y(downloadBean, function1);
                return;
            } else if (downloadBean.getIsStream()) {
                w(downloadBean, function1);
                return;
            } else {
                u(downloadBean, function1);
                return;
            }
        }
        lg.a.f68962a.x(com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " checkDownloadSubtitle ,无网络不做检测", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t(VideoSubtitleManagerImp videoSubtitleManagerImp, DownloadBean downloadBean, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        videoSubtitleManagerImp.s(downloadBean, function1);
    }

    private final void u(final DownloadBean downloadBean, final Function1 function1) {
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            a.C0856a.f(lg.a.f68962a, com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " checkDownloadSubtitleNormal fail， has no resourceId", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String resourceId2 = downloadBean.getResourceId();
        if ((resourceId2 != null ? StringsKt.x(resourceId2) : null) == null) {
            a.C0856a.z(lg.a.f68962a, com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " checkDownloadSubtitleNormal ,resourceId is abnormal", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        lg.a.f68962a.c(com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " checkDownloadSubtitleNormal, name = " + downloadBean.getName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId() + " resourceId:" + downloadBean.getResourceId(), true);
        if (downloadBean.isOutside()) {
            downloadBean.getPostIdNotNull();
        } else if (downloadBean.getPostId() == null) {
            downloadBean.getResourceId();
        }
        SubtitleDownloadManager.f55121a.e(downloadBean.getSubjectId(), downloadBean.getSubtitleResId(), downloadBean.getResourceId(), null, downloadBean.getSubjectName(), 1, downloadBean.getEpse(), downloadBean.getEp(), downloadBean.getSe(), downloadBean.getOps(), new Function1() { // from class: com.transsion.subtitle.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v11;
                v11 = VideoSubtitleManagerImp.v(VideoSubtitleManagerImp.this, function1, downloadBean, ((Boolean) obj).booleanValue());
                return v11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(VideoSubtitleManagerImp videoSubtitleManagerImp, Function1 function1, DownloadBean downloadBean, boolean z10) {
        kotlinx.coroutines.k.d(videoSubtitleManagerImp.f54858e, null, null, new VideoSubtitleManagerImp$checkDownloadSubtitleNormal$1$1(function1, z10, videoSubtitleManagerImp, downloadBean, null), 3, null);
        return Unit.f67184a;
    }

    private final void w(final DownloadBean downloadBean, final Function1 function1) {
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            a.C0856a.f(lg.a.f68962a, com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " checkStreamSubtitle fail， has no resourceId", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String resourceId2 = downloadBean.getResourceId();
        if ((resourceId2 != null ? StringsKt.x(resourceId2) : null) == null) {
            a.C0856a.z(lg.a.f68962a, com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " checkStreamSubtitle ,resourceId is abnormal", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        lg.a.f68962a.c(com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " checkStreamSubtitle, name = " + downloadBean.getName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId() + " resourceId:" + downloadBean.getResourceId(), true);
        SubtitleDownloadManager.f55121a.e(downloadBean.getSubjectId(), downloadBean.getSubtitleResId(), downloadBean.getResourceId(), null, downloadBean.getSubjectName(), 2, downloadBean.getEpse(), downloadBean.getEp(), downloadBean.getSe(), downloadBean.getOps(), new Function1() { // from class: com.transsion.subtitle.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x10;
                x10 = VideoSubtitleManagerImp.x(VideoSubtitleManagerImp.this, function1, downloadBean, ((Boolean) obj).booleanValue());
                return x10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(VideoSubtitleManagerImp videoSubtitleManagerImp, Function1 function1, DownloadBean downloadBean, boolean z10) {
        kotlinx.coroutines.k.d(videoSubtitleManagerImp.f54858e, null, null, new VideoSubtitleManagerImp$checkStreamSubtitle$1$1(function1, z10, videoSubtitleManagerImp, downloadBean, null), 3, null);
        return Unit.f67184a;
    }

    private final void y(final DownloadBean downloadBean, final Function1 function1) {
        String ugcVideoId = downloadBean.getUgcVideoId();
        if (ugcVideoId == null || ugcVideoId.length() == 0) {
            a.C0856a.f(lg.a.f68962a, com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " checkUGCVideoSubtitle fail，UGC视频缺少ugcVideoId", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            a.C0856a.f(lg.a.f68962a, com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " checkUGCVideoSubtitle fail，UGC视频缺少resourceId（videoResourceId）", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String subtitleIdType = downloadBean.getSubtitleIdType();
        if (subtitleIdType == null) {
            subtitleIdType = downloadBean.getIsStream() ? "StreamId" : "ResourceId";
        }
        String str = subtitleIdType;
        lg.a.f68962a.c(com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " checkUGCVideoSubtitle, name = " + downloadBean.getName() + " ugcVideoId:" + downloadBean.getUgcVideoId() + " collectionId:" + downloadBean.getUgcVideoCollectionId() + " videoResourceId:" + resourceId + " idType:" + str, true);
        SubtitleDownloadManager.f55121a.f(downloadBean.getSubjectId(), downloadBean.getSubtitleResId(), resourceId, downloadBean.getUgcVideoId(), downloadBean.getUgcVideoCollectionId(), downloadBean.getOps(), str, new Function1() { // from class: com.transsion.subtitle.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z10;
                z10 = VideoSubtitleManagerImp.z(VideoSubtitleManagerImp.this, function1, downloadBean, ((Boolean) obj).booleanValue());
                return z10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(VideoSubtitleManagerImp videoSubtitleManagerImp, Function1 function1, DownloadBean downloadBean, boolean z10) {
        kotlinx.coroutines.k.d(videoSubtitleManagerImp.f54858e, null, null, new VideoSubtitleManagerImp$checkUGCVideoSubtitle$1$1(function1, z10, videoSubtitleManagerImp, downloadBean, null), 3, null);
        return Unit.f67184a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.subtitle.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsion.subtitle.VideoSubtitleManagerImp$getSubtitleList$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.subtitle.VideoSubtitleManagerImp$getSubtitleList$1 r0 = (com.transsion.subtitle.VideoSubtitleManagerImp$getSubtitleList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.subtitle.VideoSubtitleManagerImp$getSubtitleList$1 r0 = new com.transsion.subtitle.VideoSubtitleManagerImp$getSubtitleList$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.b(r7)
            goto L4d
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.b(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.transsion.subtitle_download.SubtitleDownloadManager r2 = com.transsion.subtitle_download.SubtitleDownloadManager.f55121a
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r2.j(r6, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r4 = r7
            r7 = r6
            r6 = r4
        L4d:
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L6c
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L57:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L6c
            java.lang.Object r0 = r7.next()
            com.transsion.subtitle_download.db.SubtitleDownloadTable r0 = (com.transsion.subtitle_download.db.SubtitleDownloadTable) r0
            eu.a r1 = new eu.a
            r1.<init>(r0)
            r6.add(r1)
            goto L57
        L6c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.VideoSubtitleManagerImp.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsion.subtitle.h
    public void b(com.transsion.subtitle_download.a listener) {
        Intrinsics.h(listener, "listener");
        SubtitleDownloadManager.f55121a.b(listener);
    }

    @Override // com.transsion.subtitle.h
    public void c(com.transsion.subtitle_download.a listener) {
        Intrinsics.h(listener, "listener");
        SubtitleDownloadManager.f55121a.s(listener);
    }

    @Override // com.transsion.subtitle.h
    public void d(hu.c listener) {
        Intrinsics.h(listener, "listener");
        this.f54856c.add(listener);
    }

    @Override // com.transsion.subtitle.h
    public void destroy() {
    }

    @Override // com.transsion.subtitle.h
    public void e(DownloadBean bean, Function1 function1) {
        Intrinsics.h(bean, "bean");
        s(bean, function1);
    }

    @Override // com.transsion.subtitle.h
    public void f(hu.c listener) {
        Intrinsics.h(listener, "listener");
        this.f54856c.remove(listener);
    }

    @Override // com.transsion.subtitle.h
    public void g(eu.a bean) {
        Intrinsics.h(bean, "bean");
        Iterator it = this.f54856c.iterator();
        while (it.hasNext()) {
            ((hu.c) it.next()).g(bean);
        }
    }

    @Override // com.transsion.subtitle.h
    public void h(eu.a bean) {
        Intrinsics.h(bean, "bean");
        SubtitleDownloadManager.f55121a.d(bean.b());
    }

    @Override // com.transsion.subtitle.h
    public void i(DownloadBean bean) {
        Intrinsics.h(bean, "bean");
        lg.a.f68962a.c(com.transsion.baselib.report.a.f43394a.a(), this.f54857d + " 打开字幕弹窗检测字幕，subjectId:" + bean.getSubjectId() + " subtitleResId:" + bean.getSubtitleResId(), true);
        t(this, bean, null, 2, null);
    }

    @Override // com.transsion.subtitle.h
    public void init() {
        SubtitleSearchHelper.f55013c.a().j();
        SubtitleDownloadManager subtitleDownloadManager = SubtitleDownloadManager.f55121a;
        subtitleDownloadManager.l(new Function0() { // from class: com.transsion.subtitle.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String B;
                B = VideoSubtitleManagerImp.B();
                return B;
            }
        });
        subtitleDownloadManager.k(SubtitleAppType.MB);
        p.f59623a.a(Utils.a()).F(this.f54859f);
        C();
    }

    @Override // com.transsion.subtitle.h
    public void j(eu.a bean) {
        Intrinsics.h(bean, "bean");
        SubtitleDownloadManager.f55121a.d(bean.b());
    }

    @Override // com.transsion.subtitle.h
    public void reset() {
    }
}
