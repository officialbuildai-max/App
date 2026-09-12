package com.transsion.postdetail.shorttv.factory;

import android.R;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R$string;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.DownloadItem;
import com.transsion.shorttv.bean.DownloadListBean;
import com.transsion.shorttv.bean.Media;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.bean.SubjectType;
import com.transsion.shorttv.bean.Video;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.manager.p;
import com.transsnet.downloader.view.DownloadingTipsDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lj.m0;
import lj.s0;
import okhttp3.internal.http2.Settings;
import qs.d;

/* loaded from: classes6.dex */
public final class ShortTvDownloadProvider implements qs.d {

    /* renamed from: b, reason: collision with root package name */
    private qs.m f49259b;

    /* renamed from: c, reason: collision with root package name */
    private qs.n f49260c;

    /* renamed from: f, reason: collision with root package name */
    private DownloadBean f49263f;

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f49258a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.factory.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g r11;
            r11 = ShortTvDownloadProvider.r();
            return r11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final m0 f49261d = new a();

    /* renamed from: e, reason: collision with root package name */
    private final s0 f49262e = new b();

    /* loaded from: classes6.dex */
    public static final class a extends lj.a {
        a() {
        }

        @Override // lj.a, lj.m0
        public void e(DownloadBean bean, String str) {
            Intrinsics.h(bean, "bean");
            qs.m mVar = ShortTvDownloadProvider.this.f49259b;
            if (mVar != null) {
                mVar.a(bean.getSubjectId(), bean.getEp());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements s0 {
        b() {
        }

        private final ts.a d(DownloadBean downloadBean) {
            return new ts.a(downloadBean.getSubjectId(), downloadBean.getSubjectId() + "_" + downloadBean.getEp() + "short", downloadBean.getName(), downloadBean.getTitleName(), downloadBean.getResourceId(), downloadBean.getEp(), downloadBean.getSe(), downloadBean.getOps());
        }

        @Override // lj.s0
        public void a(String subtitleResId) {
            Intrinsics.h(subtitleResId, "subtitleResId");
            qs.n nVar = ShortTvDownloadProvider.this.f49260c;
            if (nVar != null) {
                nVar.a(subtitleResId);
            }
        }

        @Override // lj.s0
        public void b(DownloadBean bean) {
            String resourceId;
            qs.n nVar;
            Intrinsics.h(bean, "bean");
            if (!bean.isShotTV() || !bean.isVideo() || bean.isMusic() || (resourceId = bean.getResourceId()) == null || resourceId.length() == 0 || (nVar = ShortTvDownloadProvider.this.f49260c) == null) {
                return;
            }
            nVar.c(d(bean));
        }

        @Override // lj.s0
        public void c(DownloadBean bean, boolean z10) {
            String resourceId;
            qs.n nVar;
            Intrinsics.h(bean, "bean");
            if (!bean.isShotTV() || (resourceId = bean.getResourceId()) == null || resourceId.length() == 0 || (nVar = ShortTvDownloadProvider.this.f49260c) == null) {
                return;
            }
            nVar.b(d(bean), z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(DownloadItem downloadItem, int i11, FragmentActivity fragmentActivity) {
        DownloadBean q11;
        String resourceId = downloadItem.getResourceId();
        if (resourceId == null) {
            resourceId = downloadItem.getUrl();
        }
        if (resourceId == null || (q11 = DownloadEsHelper.f59542m.a().q(resourceId)) == null) {
            return;
        }
        DownloadingTipsDialogFragment a11 = DownloadingTipsDialogFragment.INSTANCE.a(i11);
        a11.O0(q11);
        a11.k0(fragmentActivity, "DownloadingTipsDialogFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g r() {
        return p.f59623a.a(Utils.a());
    }

    private final com.transsnet.downloader.manager.g s() {
        return (com.transsnet.downloader.manager.g) this.f49258a.getValue();
    }

    private final ShortTVItem t(DownloadBean downloadBean) {
        Integer valueOf = Integer.valueOf(downloadBean.getVideoHeight());
        Long size = downloadBean.getSize();
        return new ShortTVItem(downloadBean.getResourceId(), downloadBean.getSubjectId(), downloadBean.getSe(), downloadBean.getEp(), null, new Media(null, null, null, null, null, null, new Video(null, null, null, null, valueOf, size != null ? Integer.valueOf((int) size.longValue()) : null, downloadBean.getPath(), Integer.valueOf(downloadBean.getVideoWidth()), null), null), null, null, downloadBean.getReadProgress(), downloadBean.getStatus(), 0, 1232, null);
    }

    private final Subject u(DownloadBean downloadBean) {
        Cover cover = new Cover(null, null, null, downloadBean.getCover(), null, downloadBean.getThumbnail(), null, null, null, 471, null);
        String subjectId = downloadBean.getSubjectId();
        String subjectName = downloadBean.getSubjectName();
        int subjectType = downloadBean.getSubjectType();
        return new Subject(subjectId, Integer.valueOf(subjectType), subjectName, null, cover, null, null, null, null, null, null, null, null, null, null, null, null, null, null, downloadBean.getOps(), null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, downloadBean.getTotalEpisode(), false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, false, null, null, 0, 0, null, 0, null, 0, null, -524312, 1073741815, null);
    }

    private final DownloadBean v(DownloadListBean downloadListBean, Subject subject, String str, String str2, String str3, DownloadItem downloadItem) {
        String genre;
        String thumbnail;
        Cover cover;
        String releaseDate;
        String countryName;
        String title;
        List<DownloadItem> items;
        Integer totalEpisode;
        Cover cover2;
        Cover cover3;
        Cover cover4;
        String url;
        String url2 = downloadItem.getUrl();
        String str4 = url2 == null ? "" : url2;
        String resourceId = downloadItem.getResourceId();
        String str5 = resourceId == null ? "" : resourceId;
        String name = downloadItem.getName();
        DownloadBean downloadBean = new DownloadBean(str4, str5, name == null ? "" : name, (downloadListBean == null || (cover4 = downloadListBean.getCover()) == null || (url = cover4.getUrl()) == null) ? "" : url, downloadItem.getSize(), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
        Integer num = null;
        if (subject == null || (genre = subject.getGenre()) == null) {
            genre = downloadListBean != null ? downloadListBean.getGenre() : null;
        }
        downloadBean.setGenre(genre);
        downloadBean.setCreateAt(System.currentTimeMillis());
        if (subject == null || (cover3 = subject.getCover()) == null || (thumbnail = cover3.getThumbnail()) == null) {
            thumbnail = (downloadListBean == null || (cover = downloadListBean.getCover()) == null) ? null : cover.getThumbnail();
            if (thumbnail == null) {
                thumbnail = "";
            }
        }
        downloadBean.setThumbnail(thumbnail);
        if (subject == null || (releaseDate = subject.getGenre()) == null) {
            releaseDate = downloadListBean != null ? downloadListBean.getReleaseDate() : null;
        }
        downloadBean.setReleaseDate(releaseDate);
        if (subject == null || (countryName = subject.getCountryName()) == null) {
            countryName = downloadListBean != null ? downloadListBean.getCountryName() : null;
        }
        downloadBean.setCountryName(countryName);
        downloadBean.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
        downloadBean.setImdbRate(subject != null ? subject.getImdbRate() : null);
        downloadBean.setSeNum(subject != null ? subject.getSeNum() : null);
        downloadBean.setSubtitles(subject != null ? subject.getSubtitles() : null);
        downloadBean.setDuration(downloadItem.getDuration());
        downloadBean.setAverageHueLight((downloadListBean == null || (cover2 = downloadListBean.getCover()) == null) ? null : cover2.getAverageHueLight());
        String uploadBy = downloadItem.getUploadBy();
        if (uploadBy == null) {
            uploadBy = "";
        }
        downloadBean.setUploadBy(uploadBy);
        downloadBean.setPostId(downloadItem.getPostId());
        Integer epse = downloadItem.getEpse();
        downloadBean.setEpse(epse != null ? epse.intValue() : 0);
        downloadBean.setEp(downloadItem.getEp());
        downloadBean.setSe(downloadItem.getSe());
        Integer resolution = downloadItem.getResolution();
        downloadBean.setResolution(resolution != null ? resolution.intValue() : 0);
        downloadBean.setSubjectId(downloadListBean != null ? downloadListBean.getSubjectId() : null);
        if (downloadListBean == null || (title = downloadListBean.getTitle()) == null) {
            title = subject != null ? subject.getTitle() : null;
        }
        downloadBean.setSubjectName(title);
        downloadBean.setPageFrom(str2);
        downloadBean.setLastPageFrom(str3);
        downloadBean.setOps(str);
        String sourceUrl = downloadItem.getSourceUrl();
        if (sourceUrl == null) {
            sourceUrl = "";
        }
        downloadBean.setSourceUrl(sourceUrl);
        downloadBean.setTaskId(downloadItem.getTaskId());
        downloadBean.setRequireMemberType(downloadItem.getRequireMemberType());
        downloadBean.setType(DownloadBean.INSTANCE.c(downloadListBean != null ? Integer.valueOf(downloadListBean.getSubjectType()) : null));
        downloadBean.setSubjectType(downloadListBean != null ? downloadListBean.getSubjectType() : SubjectType.SHORT_TV.getValue());
        downloadBean.setSubjectDurationSeconds(downloadListBean != null ? downloadListBean.getDurationSeconds() : null);
        downloadBean.setTotalEpisode((downloadListBean == null || (totalEpisode = downloadListBean.getTotalEpisode()) == null) ? 1 : totalEpisode.intValue());
        if (downloadListBean != null && (items = downloadListBean.getItems()) != null) {
            num = Integer.valueOf(items.size());
        }
        Intrinsics.e(num);
        if (num.intValue() > downloadBean.getTotalEpisode()) {
            downloadBean.setMultiresolution(1);
        }
        return downloadBean;
    }

    @Override // qs.d
    public Object a(String str, int i11, String str2, Continuation continuation) {
        return s().a(str, i11, str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[LOOP:0: B:11:0x0054->B:13:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // qs.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider$fetchDownloadList$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider$fetchDownloadList$1 r0 = (com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider$fetchDownloadList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider$fetchDownloadList$1 r0 = new com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider$fetchDownloadList$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            com.transsnet.downloader.manager.DownloadEsHelper$a r6 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r6 = r6.a()
            r0.label = r3
            java.lang.Object r6 = r6.v(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r5 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.v(r6, r0)
            r5.<init>(r0)
            java.util.Iterator r6 = r6.iterator()
        L54:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L68
            java.lang.Object r0 = r6.next()
            com.transsion.baselib.db.download.DownloadBean r0 = (com.transsion.baselib.db.download.DownloadBean) r0
            com.transsion.shorttv.bean.ShortTVItem r0 = r4.t(r0)
            r5.add(r0)
            goto L54
        L68:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider.b(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // qs.d
    public void c() {
        s().x(this.f49261d);
        this.f49259b = null;
    }

    @Override // qs.d
    public Object d(String str, int i11, long j11, Continuation continuation) {
        Object d02 = DownloadEsHelper.f59542m.a().d0(str, i11, j11, continuation);
        return d02 == IntrinsicsKt.f() ? d02 : Unit.f67184a;
    }

    @Override // qs.d
    public boolean e(long j11) {
        DownloadEsHelper.a aVar = DownloadEsHelper.f59542m;
        aVar.a().i();
        String t11 = aVar.a().t();
        if (t11.length() == 0) {
            return false;
        }
        try {
            long j12 = com.blankj.utilcode.util.n.j(t11);
            Long y10 = s().y();
            if (j11 + (y10 != null ? y10.longValue() : 0L) >= j12) {
                uh.b.f76876a.d(R$string.insufficient_storage_available);
                lg.a.f68962a.o("--- 可用存储空间不足，释放空间并重试 ---", true);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // qs.d
    public void f(qs.m listener) {
        Intrinsics.h(listener, "listener");
        this.f49259b = listener;
        s().e(this.f49261d);
    }

    @Override // qs.d
    public DownloadItem g(String str) {
        DownloadItem downloadItem = null;
        if (str != null && str.length() != 0) {
            DownloadBean q11 = DownloadEsHelper.f59542m.a().q(str);
            if (q11 == null) {
                return null;
            }
            String resourceId = q11.getResourceId();
            if (resourceId == null) {
                resourceId = q11.getUrl();
            }
            String str2 = resourceId;
            String totalTitleName = q11.getTotalTitleName();
            String url = q11.getUrl();
            Long size = q11.getSize();
            downloadItem = new DownloadItem(str2, totalTitleName, url, 1, Long.valueOf(size != null ? size.longValue() : 0L), q11.getUploadBy(), q11.getPostId(), Integer.valueOf(q11.getEpse()), q11.getSe(), q11.getEp(), q11.getStatus(), q11.getSourceUrl(), Integer.valueOf(q11.getResolution()), null, null);
            String taskId = q11.getTaskId();
            if (taskId == null) {
                taskId = "";
            }
            downloadItem.setTaskId(taskId);
        }
        return downloadItem;
    }

    @Override // qs.d
    public void h(DownloadListBean downloadListBean, Subject subject, String str, String str2, String str3, List list) {
        Intrinsics.h(list, "list");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DownloadBean v11 = v(downloadListBean, subject, str, str2, str3, (DownloadItem) it.next());
            if (this.f49263f != null) {
                this.f49263f = v11;
            }
            arrayList.add(v11);
        }
        s().D(arrayList);
    }

    @Override // qs.d
    public void i(final FragmentActivity activity, final DownloadItem item, final int i11, String formatSize) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(item, "item");
        Intrinsics.h(formatSize, "formatSize");
        ((FrameLayout) activity.findViewById(R.id.content)).postDelayed(new Runnable() { // from class: com.transsion.postdetail.shorttv.factory.d
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvDownloadProvider.q(DownloadItem.this, i11, activity);
            }
        }, 300L);
    }

    @Override // qs.d
    public void j(qs.n listener) {
        Intrinsics.h(listener, "listener");
        this.f49260c = listener;
        s().F(this.f49262e);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // qs.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider$getDownloadSubject$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider$getDownloadSubject$1 r0 = (com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider$getDownloadSubject$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider$getDownloadSubject$1 r0 = new com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider$getDownloadSubject$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            com.transsnet.downloader.manager.DownloadEsHelper$a r6 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r6 = r6.a()
            r0.label = r3
            java.lang.Object r6 = r6.v(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r5 = kotlin.collections.CollectionsKt.k0(r6)
            com.transsion.baselib.db.download.DownloadBean r5 = (com.transsion.baselib.db.download.DownloadBean) r5
            if (r5 == 0) goto L52
            com.transsion.shorttv.bean.Subject r5 = r4.u(r5)
            goto L53
        L52:
            r5 = 0
        L53:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.shorttv.factory.ShortTvDownloadProvider.k(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // qs.d
    public void l(FragmentActivity fragmentActivity, String str, int i11) {
        d.a.a(this, fragmentActivity, str, i11);
    }
}
