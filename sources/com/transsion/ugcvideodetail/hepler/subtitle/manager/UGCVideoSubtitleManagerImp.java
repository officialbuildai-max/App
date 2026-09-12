package com.transsion.ugcvideodetail.hepler.subtitle.manager;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import nh.m;

/* loaded from: classes6.dex */
public final class UGCVideoSubtitleManagerImp implements b {

    /* renamed from: f, reason: collision with root package name */
    public static final a f56519f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private Set f56520b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    private final String f56521c = UGCVideoSubtitleManagerImp.class.getSimpleName();

    /* renamed from: d, reason: collision with root package name */
    private final n0 f56522d = o0.a(y0.c());

    /* renamed from: e, reason: collision with root package name */
    private final UGCVideoSubtitleManagerImp$resDownloadListener$1 f56523e = new UGCVideoSubtitleManagerImp$resDownloadListener$1(this);

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void k(final DownloadBean downloadBean, final Function1 function1) {
        if (!downloadBean.isVideo() || downloadBean.isMusic()) {
            a.C0856a.f(lg.a.f68962a, b.f56525a.c(), this.f56521c + " checkDownloadSubtitle fail， has no shorTvId", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (!m.f70597a.e()) {
            lg.a.f68962a.x(b.f56525a.c(), this.f56521c + " checkDownloadSubtitle ,无网络不做检测", true);
            return;
        }
        String ugcVideoId = downloadBean.getUgcVideoId();
        if (ugcVideoId == null || ugcVideoId.length() == 0) {
            a.C0856a.f(lg.a.f68962a, com.transsion.baselib.report.a.f43394a.a(), this.f56521c + " checkUGCVideoSubtitle fail，UGC视频缺少ugcVideoId", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            a.C0856a.f(lg.a.f68962a, com.transsion.baselib.report.a.f43394a.a(), this.f56521c + " checkUGCVideoSubtitle fail，UGC视频缺少resourceId（videoResourceId）", false, 4, null);
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
        lg.a.f68962a.c(com.transsion.baselib.report.a.f43394a.a(), this.f56521c + " checkUGCVideoSubtitle, name = " + downloadBean.getName() + " ugcVideoId:" + downloadBean.getUgcVideoId() + " collectionId:" + downloadBean.getUgcVideoCollectionId() + " videoResourceId:" + resourceId + " idType:" + str, true);
        SubtitleDownloadManager.f55121a.f(downloadBean.getSubjectId(), downloadBean.getSubtitleResId(), resourceId, downloadBean.getUgcVideoId(), downloadBean.getUgcVideoCollectionId(), downloadBean.getOps(), str, new Function1() { // from class: com.transsion.ugcvideodetail.hepler.subtitle.manager.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m11;
                m11 = UGCVideoSubtitleManagerImp.m(UGCVideoSubtitleManagerImp.this, function1, downloadBean, ((Boolean) obj).booleanValue());
                return m11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(UGCVideoSubtitleManagerImp uGCVideoSubtitleManagerImp, DownloadBean downloadBean, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        uGCVideoSubtitleManagerImp.k(downloadBean, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(UGCVideoSubtitleManagerImp uGCVideoSubtitleManagerImp, Function1 function1, DownloadBean downloadBean, boolean z10) {
        k.d(uGCVideoSubtitleManagerImp.f56522d, null, null, new UGCVideoSubtitleManagerImp$checkDownloadSubtitle$1$1(function1, z10, uGCVideoSubtitleManagerImp, downloadBean, null), 3, null);
        return Unit.f67184a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.ugcvideodetail.hepler.subtitle.manager.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsion.ugcvideodetail.hepler.subtitle.manager.UGCVideoSubtitleManagerImp$getSubtitleList$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.ugcvideodetail.hepler.subtitle.manager.UGCVideoSubtitleManagerImp$getSubtitleList$1 r0 = (com.transsion.ugcvideodetail.hepler.subtitle.manager.UGCVideoSubtitleManagerImp$getSubtitleList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ugcvideodetail.hepler.subtitle.manager.UGCVideoSubtitleManagerImp$getSubtitleList$1 r0 = new com.transsion.ugcvideodetail.hepler.subtitle.manager.UGCVideoSubtitleManagerImp$getSubtitleList$1
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
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.hepler.subtitle.manager.UGCVideoSubtitleManagerImp.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.manager.b
    public void b(com.transsion.subtitle_download.a listener) {
        Intrinsics.h(listener, "listener");
        SubtitleDownloadManager.f55121a.b(listener);
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.manager.b
    public void c(com.transsion.subtitle_download.a listener) {
        Intrinsics.h(listener, "listener");
        SubtitleDownloadManager.f55121a.s(listener);
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.manager.b
    public void d(hu.c listener) {
        Intrinsics.h(listener, "listener");
        this.f56520b.add(listener);
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.manager.b
    public void e(DownloadBean bean, Function1 function1) {
        Intrinsics.h(bean, "bean");
        l(this, bean, null, 2, null);
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.manager.b
    public void f(hu.c listener) {
        Intrinsics.h(listener, "listener");
        this.f56520b.remove(listener);
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.manager.b
    public void h(eu.a bean) {
        Intrinsics.h(bean, "bean");
        SubtitleDownloadManager.f55121a.d(bean.b());
    }
}
