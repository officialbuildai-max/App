package com.transsnet.downloader.util;

import android.app.Application;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsion.baseui.R$mipmap;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResolutionItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.bean.DownloadUrlBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import lj.n0;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public final class DownloadUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadUtil f60023a = new DownloadUtil();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f60024b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.util.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g m11;
            m11 = DownloadUtil.m();
            return m11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f60025c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.util.n
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            n0 n11;
            n11 = DownloadUtil.n();
            return n11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f60026d = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};

    private DownloadUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Function2 function2, long j11, long j12) {
        if (function2 != null) {
            function2.invoke(Long.valueOf(j11), Long.valueOf(j12));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit M(Ref.ObjectRef objectRef, String newPath) {
        Intrinsics.h(newPath, "newPath");
        objectRef.element = newPath;
        lg.a.f68962a.u("resource_save", "转存到相册 newPath = " + newPath, true);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Function2 function2, long j11, long j12) {
        if (function2 != null) {
            function2.invoke(Long.valueOf(j11), Long.valueOf(j12));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit O(Ref.ObjectRef objectRef, String newPath) {
        Intrinsics.h(newPath, "newPath");
        objectRef.element = newPath;
        lg.a.f68962a.u("resource_save", "转存到sdcard newPath = " + newPath, true);
        return Unit.f67184a;
    }

    private final Object P(DownloadBean downloadBean, boolean z10, Continuation continuation) {
        if (!z10) {
            return Unit.f67184a;
        }
        downloadBean.setTransferFailed(true);
        Object b02 = DownloadEsHelper.f59542m.a().b0(downloadBean, continuation);
        return b02 == IntrinsicsKt.f() ? b02 : Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q(com.transsion.baselib.db.download.DownloadBean r17, java.lang.String r18, java.lang.String r19, int r20, java.lang.String r21, int r22, java.lang.String r23, boolean r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.util.DownloadUtil.Q(com.transsion.baselib.db.download.DownloadBean, java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g m() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 n() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).q1();
    }

    private final com.transsnet.downloader.manager.g p() {
        return (com.transsnet.downloader.manager.g) f60024b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n0 q() {
        return (n0) f60025c.getValue();
    }

    private final File u(String str) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            int i11 = 1;
            if ((parentFile == null || !parentFile.exists()) && parentFile != null) {
                parentFile.mkdirs();
            }
            String x10 = FilesKt.x(file);
            String w11 = FilesKt.w(file);
            File file2 = new File(parentFile, file.getName());
            while (file2.exists()) {
                file2 = new File(parentFile, x10 + "_" + i11 + "." + w11);
                i11++;
            }
            return file2;
        } catch (Throwable unused) {
            return new File(str);
        }
    }

    private final DownloadBean z(DownloadListBean downloadListBean, Subject subject, DownloadItem downloadItem, String str, String str2, String str3, String str4, String str5) {
        String genre;
        String thumbnail;
        String releaseDate;
        String countryName;
        Cover cover;
        String url;
        String url2 = downloadItem.getUrl();
        String str6 = url2 == null ? "" : url2;
        String resourceId = downloadItem.getResourceId();
        String str7 = resourceId == null ? "" : resourceId;
        String name = downloadItem.getName();
        String str8 = name == null ? "" : name;
        Cover cover2 = downloadListBean.getCover();
        DownloadBean downloadBean = new DownloadBean(str6, str7, str8, (cover2 == null || (url = cover2.getUrl()) == null) ? "" : url, downloadItem.getSize(), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
        if (subject == null || (genre = subject.getGenre()) == null) {
            genre = downloadListBean.getGenre();
        }
        downloadBean.setGenre(genre);
        downloadBean.setCreateAt(System.currentTimeMillis());
        if (subject == null || (cover = subject.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
            Cover cover3 = downloadListBean.getCover();
            thumbnail = cover3 != null ? cover3.getThumbnail() : null;
            if (thumbnail == null) {
                thumbnail = "";
            }
        }
        downloadBean.setThumbnail(thumbnail);
        if (subject == null || (releaseDate = subject.getGenre()) == null) {
            releaseDate = downloadListBean.getReleaseDate();
        }
        downloadBean.setReleaseDate(releaseDate);
        if (subject == null || (countryName = subject.getCountryName()) == null) {
            countryName = downloadListBean.getCountryName();
        }
        downloadBean.setCountryName(countryName);
        downloadBean.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
        downloadBean.setImdbRate(subject != null ? subject.getImdbRate() : null);
        downloadBean.setSeNum(subject != null ? subject.getSeNum() : null);
        downloadBean.setSubtitles(subject != null ? subject.getSubtitles() : null);
        downloadBean.setDuration(downloadItem.getDuration());
        Cover cover4 = downloadListBean.getCover();
        downloadBean.setAverageHueLight(cover4 != null ? cover4.getAverageHueLight() : null);
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
        downloadBean.setSubjectId(downloadListBean.getSubjectId());
        downloadBean.setGroupId(str == null ? downloadListBean.getGroupId() : str);
        downloadBean.setSubjectName((str5 == null || str5.length() == 0) ? downloadListBean.getTitle() : str5);
        downloadBean.setPageFrom(str2);
        downloadBean.setLastPageFrom(str3);
        downloadBean.setOps(str4);
        String sourceUrl = downloadItem.getSourceUrl();
        if (sourceUrl == null) {
            sourceUrl = "";
        }
        downloadBean.setSourceUrl(sourceUrl);
        downloadBean.setRequireMemberType(downloadItem.getRequireMemberType());
        downloadBean.setType(DownloadBean.INSTANCE.c(Integer.valueOf(downloadListBean.getSubjectType())));
        downloadBean.setSubjectType(downloadListBean.getSubjectType());
        downloadBean.setSubjectDurationSeconds(downloadListBean.getDurationSeconds());
        Integer totalEpisode = downloadListBean.getTotalEpisode();
        downloadBean.setTotalEpisode(totalEpisode != null ? totalEpisode.intValue() : 1);
        List<DownloadItem> items = downloadListBean.getItems();
        Integer valueOf = items != null ? Integer.valueOf(items.size()) : null;
        Intrinsics.e(valueOf);
        if (valueOf.intValue() > downloadBean.getTotalEpisode()) {
            downloadBean.setMultiresolution(1);
        }
        return downloadBean;
    }

    public final Pair A(List seasons, int i11, int i12) {
        int epNum;
        Intrinsics.h(seasons, "seasons");
        List<ResourcesSeason> list = seasons;
        CollectionsKt.I0(list, new Comparator() { // from class: com.transsnet.downloader.util.DownloadUtil$initGetPositions$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(Integer.valueOf(((ResourcesSeason) t11).getSe()), Integer.valueOf(((ResourcesSeason) t12).getSe()));
            }
        });
        int i13 = 0;
        int i14 = 0;
        for (ResourcesSeason resourcesSeason : list) {
            Object obj = null;
            if (i12 == 0) {
                List<ResolutionItem> resolutions = resourcesSeason.getResolutions();
                if (resolutions != null) {
                    Iterator<T> it = resolutions.iterator();
                    if (it.hasNext()) {
                        obj = it.next();
                        if (it.hasNext()) {
                            int epNum2 = ((ResolutionItem) obj).getEpNum();
                            do {
                                Object next = it.next();
                                int epNum3 = ((ResolutionItem) next).getEpNum();
                                if (epNum2 < epNum3) {
                                    obj = next;
                                    epNum2 = epNum3;
                                }
                            } while (it.hasNext());
                        }
                    }
                    ResolutionItem resolutionItem = (ResolutionItem) obj;
                    if (resolutionItem != null) {
                        lg.a.f68962a.c("DownloadRes", "initGetPositions,分辨率0  it.epNum:" + resolutionItem.getEpNum() + " ", true);
                        if (resourcesSeason.getSe() < i11) {
                            i13 += resolutionItem.getEpNum();
                        }
                        if (resourcesSeason.getSe() <= i11) {
                            epNum = resolutionItem.getEpNum();
                            i14 += epNum;
                        }
                    }
                }
            } else {
                List<ResolutionItem> resolutions2 = resourcesSeason.getResolutions();
                if (resolutions2 != null) {
                    Iterator<T> it2 = resolutions2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next2 = it2.next();
                        if (((ResolutionItem) next2).getResolution() == i12) {
                            obj = next2;
                            break;
                        }
                    }
                    ResolutionItem resolutionItem2 = (ResolutionItem) obj;
                    if (resolutionItem2 != null) {
                        lg.a.f68962a.c("DownloadRes", "initGetPositions,分辨率0  resolution:" + i12 + " ", true);
                        if (resourcesSeason.getSe() < i11) {
                            i13 += resolutionItem2.getEpNum();
                        }
                        if (resourcesSeason.getSe() <= i11) {
                            epNum = resolutionItem2.getEpNum();
                            i14 += epNum;
                        }
                    }
                }
            }
        }
        int i15 = i13 + 1;
        if (i14 < i15) {
            i14 = i15;
        }
        return new Pair(Integer.valueOf(i14), Integer.valueOf(i15));
    }

    public final void B(DownloadBean bean) {
        Intrinsics.h(bean, "bean");
        if (bean.getDownloadRanges().isEmpty()) {
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new DownloadUtil$initSetDownloadInfoAndRanges$1(bean, null), 3, null);
        }
    }

    public final boolean C(DownloadBean data) {
        Intrinsics.h(data, "data");
        boolean z10 = true;
        if (!data.isSeriesCollection()) {
            return true;
        }
        Iterator<T> it = data.getSeriesList().iterator();
        while (it.hasNext()) {
            if (!((DownloadBean) it.next()).getIsCheck()) {
                z10 = false;
            }
        }
        return z10;
    }

    public final boolean D() {
        if (Build.VERSION.SDK_INT > 29) {
            return true;
        }
        try {
            return PermissionUtils.s("android.permission.WRITE_EXTERNAL_STORAGE");
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean E(DownloadBean bean) {
        String subjectId;
        String resourceId;
        Object obj;
        Intrinsics.h(bean, "bean");
        if (bean.isVideo() && (subjectId = bean.getSubjectId()) != null && subjectId.length() != 0 && (resourceId = bean.getResourceId()) != null && resourceId.length() != 0) {
            ConfigBean c11 = sm.f.f75530c.a().c("download_error_opt_off", false);
            if (c11 == null || (obj = c11.getValue()) == null) {
                obj = 0;
            }
            DownloadException exception = bean.getException();
            if (exception != null && exception.getCode() == bean.getPreErrorCode() && Intrinsics.c(obj, 0)) {
                return false;
            }
            if ((bean.isCNDError() || bean.is4xxError()) && bean.getRequestNewSourceCount() < 5) {
                return true;
            }
        }
        return false;
    }

    public final boolean F(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        boolean z10 = false;
        for (String str : f60026d) {
            if (!fragment.shouldShowRequestPermissionRationale(str)) {
                z10 = true;
            }
        }
        return z10;
    }

    public final DownloadBean G(PostSubjectItem item) {
        String content;
        Integer height;
        Integer height2;
        Integer width;
        Integer duration;
        Integer size;
        List<Video> video;
        Intrinsics.h(item, "item");
        Media media = item.getMedia();
        DownloadBean downloadBean = null;
        downloadBean = null;
        if (!Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue())) {
            Media media2 = item.getMedia();
            if (!Intrinsics.c(media2 != null ? media2.getMediaType() : null, "VIDEO")) {
                return null;
            }
        }
        Media media3 = item.getMedia();
        Video video2 = (media3 == null || (video = media3.getVideo()) == null) ? null : (Video) CollectionsKt.k0(video);
        String url = video2 != null ? video2.getUrl() : null;
        if (url != null && url.length() != 0) {
            String title = item.getTitle();
            if (title == null || title.length() == 0) {
                String content2 = item.getContent();
                content = (content2 == null || content2.length() == 0) ? "" : item.getContent();
            } else {
                content = item.getTitle();
            }
            String str = content;
            String postId = item.getPostId();
            if (postId == null) {
                postId = String.valueOf(url.hashCode());
            }
            String str2 = postId;
            String coverUrl = item.getCoverUrl(false);
            long j11 = 0;
            long intValue = (video2 == null || (size = video2.getSize()) == null) ? 0L : size.intValue();
            String postId2 = item.getPostId();
            if (video2 != null && (duration = video2.getDuration()) != null) {
                j11 = duration.intValue();
            }
            long j12 = 1000 * j11;
            Subject subject = item.getSubject();
            String subjectId = subject != null ? subject.getSubjectId() : null;
            Subject subject2 = item.getSubject();
            String title2 = subject2 != null ? subject2.getTitle() : null;
            User user = item.getUser();
            String nickname = user != null ? user.getNickname() : null;
            int intValue2 = (video2 == null || (width = video2.getWidth()) == null) ? 0 : width.intValue();
            int intValue3 = (video2 == null || (height2 = video2.getHeight()) == null) ? 0 : height2.intValue();
            int intValue4 = (video2 == null || (height = video2.getHeight()) == null) ? 0 : height.intValue();
            String ops = item.getOps();
            String coverUrl2 = item.getCoverUrl(true);
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            String uuid = UUID.randomUUID().toString();
            Long valueOf = Long.valueOf(intValue);
            Long valueOf2 = Long.valueOf(j12);
            Long valueOf3 = Long.valueOf(currentTimeMillis2);
            downloadBean = r10;
            DownloadBean downloadBean2 = new DownloadBean(url, str2, str, coverUrl, valueOf, postId2, null, "", valueOf2, valueOf3, 0L, 0, 0, 9, 0L, currentTimeMillis, 0, 0, 0, 0, intValue4, 0, 0, intValue2, intValue3, 0, 0, subjectId, null, null, title2, 0L, 1, 0, nickname, null, 0L, null, uuid, 0L, 0, 0L, null, 0, coverUrl2, null, false, false, 1, null, null, null, null, ops, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -1234219968, -2166854, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
            try {
                downloadBean.setOriginData(com.blankj.utilcode.util.o.j(item));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return downloadBean;
    }

    public final void H(DownloadBean bean) {
        Intrinsics.h(bean, "bean");
        bean.setProgress(0L);
        Iterator<T> it = bean.getDownloadRanges().iterator();
        while (it.hasNext()) {
            ((DownloadRange) it.next()).setProgress(0L);
        }
    }

    public final void I(boolean z10, DownloadBean data) {
        Intrinsics.h(data, "data");
        if (data.isSeriesCollection()) {
            data.setSeriesAllCheck(z10);
            Iterator<T> it = data.getSeriesList().iterator();
            while (it.hasNext()) {
                ((DownloadBean) it.next()).setCheck(z10);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(android.content.Context r26, boolean r27, com.transsion.baselib.db.download.DownloadBean r28, java.lang.String r29, int r30, java.lang.String r31, int r32, final kotlin.jvm.functions.Function2 r33, kotlin.jvm.functions.Function1 r34, boolean r35, kotlin.coroutines.Continuation r36) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.util.DownloadUtil.J(android.content.Context, boolean, com.transsion.baselib.db.download.DownloadBean, java.lang.String, int, java.lang.String, int, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean i(DownloadBean bean) {
        String path;
        Intrinsics.h(bean, "bean");
        if (bean.getProgress() != 0) {
            Long size = bean.getSize();
            if ((size != null ? size.longValue() : 0L) > 31457280 && (path = bean.getPath()) != null) {
                File file = new File(path);
                long length = file.length();
                if (!file.exists() || length <= 0) {
                    lg.a.f68962a.i("download", "文件不存在，重新下载，fileLength = " + length + ",progress = " + bean.getProgress() + "，path = " + path, true);
                    return true;
                }
                long progress = bean.getProgress() - length;
                if (progress > 5120) {
                    lg.a.f68962a.x("download", "文件已经开始出现异常 name：" + bean.getTitleName(), true);
                }
                if (progress > 10485760) {
                    lg.a.f68962a.i("download", "重新下载，fileLength = " + length + ",progress = " + bean.getProgress() + ",extra = " + progress + "，path = " + path, true);
                    return true;
                }
            }
        }
        return false;
    }

    public final DownloadBean j(Subject subject, String str, String str2, String str3, String str4, String str5) {
        String downloadUrl;
        ResourceDetectors resourceDetector;
        String str6;
        ResourceDetectors resourceDetector2;
        String resourceLink;
        ResourceDetectors resourceDetector3;
        Integer subjectType;
        ResourceDetectors resourceDetector4;
        Integer resolution;
        ResourceDetectors resourceDetector5;
        Cover cover;
        ResourceDetectors resourceDetector6;
        Cover cover2;
        String title;
        ResourceDetectors resourceDetector7;
        String resourceId;
        ResourceDetectors resourceDetector8;
        String downloadUrl2;
        ResourceDetectors resourceDetector9;
        DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
        String str7 = "";
        if (subject == null || (resourceDetector9 = subject.getResourceDetector()) == null || (downloadUrl = resourceDetector9.getResourceId()) == null) {
            downloadUrl = (subject == null || (resourceDetector = subject.getResourceDetector()) == null) ? null : resourceDetector.getDownloadUrl();
            if (downloadUrl == null) {
                downloadUrl = "";
            }
        }
        DownloadBean q11 = a11.q(downloadUrl);
        if (q11 != null) {
            a.C0856a.f(lg.a.f68962a, "downloadAna", "single， get download bean from database", false, 4, null);
        } else {
            q11 = new DownloadBean((subject == null || (resourceDetector8 = subject.getResourceDetector()) == null || (downloadUrl2 = resourceDetector8.getDownloadUrl()) == null) ? "" : downloadUrl2, (subject == null || (resourceDetector7 = subject.getResourceDetector()) == null || (resourceId = resourceDetector7.getResourceId()) == null) ? "" : resourceId, (subject == null || (title = subject.getTitle()) == null) ? "" : title, (subject == null || (cover2 = subject.getCover()) == null) ? null : cover2.getUrl(), (subject == null || (resourceDetector6 = subject.getResourceDetector()) == null) ? null : resourceDetector6.getTotalSize(), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, subject != null ? subject.getGenre() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -131073, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
            q11.setGenre(subject != null ? subject.getGenre() : null);
            q11.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
            q11.setReleaseDate(subject != null ? subject.getReleaseDate() : null);
            q11.setImdbRate(subject != null ? subject.getImdbRate() : null);
            q11.setCountryName(subject != null ? subject.getCountryName() : null);
            q11.setSeNum(subject != null ? subject.getSeNum() : null);
            q11.setSubtitles(subject != null ? subject.getSubtitles() : null);
            q11.setThumbnail((subject == null || (cover = subject.getCover()) == null) ? null : cover.getThumbnail());
            q11.setPostId((subject == null || (resourceDetector5 = subject.getResourceDetector()) == null) ? null : resourceDetector5.getPostId());
            q11.setSubjectId(subject != null ? subject.getSubjectId() : null);
            q11.setGroupId(str4);
            q11.setSubjectName(subject != null ? subject.getTitle() : null);
            q11.setResolution((subject == null || (resourceDetector4 = subject.getResourceDetector()) == null || (resolution = resourceDetector4.getResolution()) == null) ? 0 : resolution.intValue());
            q11.setType(DownloadBean.INSTANCE.c(subject != null ? subject.getSubjectType() : null));
            q11.setSubjectType((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
            if (subject == null || (resourceDetector3 = subject.getResourceDetector()) == null || (str6 = resourceDetector3.getUploadBy()) == null) {
                str6 = str5 == null ? "" : str5;
            }
            q11.setUploadBy(str6);
            if (subject != null && (resourceDetector2 = subject.getResourceDetector()) != null && (resourceLink = resourceDetector2.getResourceLink()) != null) {
                str7 = resourceLink;
            }
            q11.setSourceUrl(str7);
        }
        a.C0856a.f(lg.a.f68962a, "downloadAna", "single， add download task， " + q11, false, 4, null);
        q11.setCreateAt(System.currentTimeMillis());
        q11.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
        q11.setPageFrom(str);
        q11.setLastPageFrom(str2);
        q11.setOps(str3);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        q11.setTaskId(uuid);
        q11.setDuration(subject != null ? Long.valueOf(subject.getResourceAboutDuration()) : null);
        return q11;
    }

    public final DownloadBean k(DownloadUrlBean urlBean, Subject subject, String str, String str2, String str3) {
        String str4;
        String str5;
        Integer subjectType;
        Integer resolution;
        Integer epse;
        Cover cover;
        Cover cover2;
        Cover cover3;
        String name;
        String resourceId;
        String url;
        Intrinsics.h(urlBean, "urlBean");
        DownloadItem resource = urlBean.getResource();
        int totalEpisode = urlBean.getTotalEpisode();
        DownloadBean downloadBean = new DownloadBean((resource == null || (url = resource.getUrl()) == null) ? "" : url, (resource == null || (resourceId = resource.getResourceId()) == null) ? "" : resourceId, (resource == null || (name = resource.getName()) == null) ? "" : name, (subject == null || (cover3 = subject.getCover()) == null) ? null : cover3.getUrl(), resource != null ? resource.getSize() : null, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, subject != null ? subject.getGenre() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -131073, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
        downloadBean.setThumbnail((subject == null || (cover2 = subject.getCover()) == null) ? null : cover2.getThumbnail());
        downloadBean.setGenre(subject != null ? subject.getGenre() : null);
        downloadBean.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
        downloadBean.setReleaseDate(subject != null ? subject.getReleaseDate() : null);
        downloadBean.setImdbRate(subject != null ? subject.getImdbRate() : null);
        downloadBean.setCountryName(subject != null ? subject.getCountryName() : null);
        downloadBean.setSeNum(subject != null ? subject.getSeNum() : null);
        downloadBean.setSubtitles(subject != null ? subject.getSubtitles() : null);
        downloadBean.setAverageHueLight((subject == null || (cover = subject.getCover()) == null) ? null : cover.getAverageHueLight());
        downloadBean.setSubjectDurationSeconds(subject != null ? subject.getDurationSeconds() : null);
        if (resource == null || (str4 = resource.getUploadBy()) == null) {
            str4 = "";
        }
        downloadBean.setUploadBy(str4);
        if (resource == null || (str5 = resource.getSourceUrl()) == null) {
            str5 = "";
        }
        downloadBean.setSourceUrl(str5);
        downloadBean.setPostId(resource != null ? resource.getPostId() : null);
        int i11 = 0;
        downloadBean.setEpse((resource == null || (epse = resource.getEpse()) == null) ? 0 : epse.intValue());
        downloadBean.setEp(resource != null ? resource.getEp() : 0);
        downloadBean.setSe(resource != null ? resource.getSe() : 0);
        if (resource != null && (resolution = resource.getResolution()) != null) {
            i11 = resolution.intValue();
        }
        downloadBean.setResolution(i11);
        downloadBean.setSubjectId(subject != null ? subject.getSubjectId() : null);
        downloadBean.setType(DownloadBean.INSTANCE.c(subject != null ? subject.getSubjectType() : null));
        downloadBean.setSubjectType((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
        downloadBean.setTotalEpisode(totalEpisode);
        downloadBean.setCreateAt(System.currentTimeMillis());
        downloadBean.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
        String title = subject != null ? subject.getTitle() : null;
        downloadBean.setSubjectName((title == null || title.length() == 0) ? urlBean.getName() : subject != null ? subject.getTitle() : null);
        downloadBean.setPageFrom(str);
        downloadBean.setLastPageFrom(str2);
        downloadBean.setOps(str3);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        downloadBean.setTaskId(uuid);
        downloadBean.setDuration(subject != null ? Long.valueOf(subject.getResourceAboutDuration()) : null);
        return downloadBean;
    }

    public final PostSubjectItem l(DownloadBean bean) {
        List<Video> video;
        Intrinsics.h(bean, "bean");
        String originData = bean.getOriginData();
        if (originData != null && originData.length() != 0) {
            try {
                PostSubjectItem postSubjectItem = (PostSubjectItem) com.blankj.utilcode.util.o.d(bean.getOriginData(), PostSubjectItem.class);
                if (postSubjectItem != null) {
                    Media media = postSubjectItem.getMedia();
                    Video video2 = (media == null || (video = media.getVideo()) == null) ? null : (Video) CollectionsKt.k0(video);
                    if (video2 != null) {
                        video2.setUrl(bean.getPath());
                    }
                    return postSubjectItem;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        String path = bean.getPath();
        int videoWidth = bean.getVideoWidth();
        int videoHeight = bean.getVideoHeight();
        Long duration = bean.getDuration();
        Media media2 = new Media(null, new Cover(null, null, null, bean.getCover(), null, bean.getThumbnail(), null, null, null, 471, null), null, null, MediaType.VIDEO.getValue(), CollectionsKt.e(new Video(0, 0, duration != null ? Integer.valueOf((int) duration.longValue()) : null, 0, Integer.valueOf(videoHeight), 0, path, Integer.valueOf(videoWidth))), null);
        String subjectId = bean.getSubjectId();
        String subjectName = bean.getSubjectName();
        int subjectType = bean.getSubjectType();
        String releaseDate = bean.getReleaseDate();
        if (releaseDate == null) {
            releaseDate = com.blankj.utilcode.util.c0.i(bean.getCreateAt(), "yyyy-MM-dd");
        }
        return new PostSubjectItem(null, String.valueOf(bean.getCreateAt()), null, null, null, null, media2, bean.getPostId(), null, null, new Subject(subjectId, Integer.valueOf(subjectType), subjectName, null, null, releaseDate, null, null, null, bean.getGenre(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -552, 134217727, null), null, bean.getTitleName(), null, null, null, null, null, null, false, null, null, null, null, false, null, false, null, true, false, false, false, null, -268440771, 1, null);
    }

    public final long o(DownloadBean bean) {
        Long duration;
        Intrinsics.h(bean, "bean");
        if (bean.getDuration() == null || ((duration = bean.getDuration()) != null && duration.longValue() == 0)) {
            return bean.getType() != 2 ? 5242880L : 7864320L;
        }
        Long duration2 = bean.getDuration();
        Intrinsics.e(duration2);
        long longValue = duration2.longValue() - 3600000;
        if (longValue > 0) {
            long j11 = ((46080 * longValue) / 60000) + 5242880;
            if (j11 > 9437184) {
                return 9437184L;
            }
            return j11;
        }
        long abs = 5242880 - ((87040 * Math.abs(longValue)) / 60000);
        if (abs < 3145728) {
            return 3145728L;
        }
        return abs;
    }

    public final int r(DownloadBean downloadBean) {
        Integer valueOf = downloadBean != null ? Integer.valueOf(downloadBean.getType()) : null;
        return (valueOf != null && valueOf.intValue() == 1) ? R$mipmap.home_ic_audio_white : (valueOf != null && valueOf.intValue() == 3) ? downloadBean.isShotTV() ? R$mipmap.home_ic_short_tv_white : R$mipmap.home_ic_tv_white : R$mipmap.home_ic_movie_white;
    }

    public final String s(DownloadBean bean) {
        File parentFile;
        Intrinsics.h(bean, "bean");
        String replace = new Regex("[\\\\/:#*?\"<>|&,]").replace(bean.getFileName(), "");
        String f12 = StringsKt.f1(StringsKt.h1(bean.getUrl(), UrlUtils.QUESTION_MARK, null, 2, null), ".", null, 2, null);
        if (f12.length() == 0) {
            f12 = "mp4";
        }
        DownloadEsHelper.a aVar = DownloadEsHelper.f59542m;
        String absolutePath = u((aVar.a().h().getAbsolutePath() + File.separatorChar + replace) + "." + f12).getAbsolutePath();
        bean.setRootPath(aVar.a().t());
        bean.setRootPathType(aVar.a().u());
        File file = new File(absolutePath);
        if (!file.exists()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                if (file.getParentFile() != null && (!r1.exists()) && (parentFile = file.getParentFile()) != null) {
                    parentFile.mkdirs();
                }
                Result.m1185constructorimpl(Boolean.valueOf(file.createNewFile()));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
        Intrinsics.e(absolutePath);
        return absolutePath;
    }

    public final int t(List seasons, int i11) {
        Object obj;
        Object obj2;
        List<ResolutionItem> resolutions;
        Intrinsics.h(seasons, "seasons");
        Iterator it = seasons.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((ResourcesSeason) obj2).getSe() == i11) {
                break;
            }
        }
        ResourcesSeason resourcesSeason = (ResourcesSeason) obj2;
        if (resourcesSeason == null || (resolutions = resourcesSeason.getResolutions()) == null) {
            return 0;
        }
        Iterator<T> it2 = resolutions.iterator();
        if (it2.hasNext()) {
            obj = it2.next();
            if (it2.hasNext()) {
                int epNum = ((ResolutionItem) obj).getEpNum();
                do {
                    Object next = it2.next();
                    int epNum2 = ((ResolutionItem) next).getEpNum();
                    if (epNum < epNum2) {
                        obj = next;
                        epNum = epNum2;
                    }
                } while (it2.hasNext());
            }
        }
        ResolutionItem resolutionItem = (ResolutionItem) obj;
        if (resolutionItem != null) {
            return resolutionItem.getResolution();
        }
        return 0;
    }

    public final String[] v() {
        return f60026d;
    }

    public final int w(List list) {
        int i11;
        if (list == null) {
            return 0;
        }
        Iterator it = list.iterator();
        int i12 = 0;
        while (it.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it.next();
            if (downloadBean.getStatus() != 10) {
                i11 = 1;
            } else if (downloadBean.getIsSeriesAllCheck()) {
                i11 = downloadBean.getSeriesList().size();
            } else {
                Iterator<T> it2 = downloadBean.getSeriesList().iterator();
                int i13 = 0;
                while (it2.hasNext()) {
                    if (((DownloadBean) it2.next()).getIsCheck()) {
                        i13++;
                    }
                }
                i11 = i13;
            }
            i12 += i11;
        }
        return i12;
    }

    public final List x(DownloadListBean downloadListBean, Subject subject, String str, String str2, String str3, String str4, String str5, List list) {
        List<DownloadItem> items;
        DownloadBean z10;
        Object obj;
        ArrayList arrayList = new ArrayList();
        if (downloadListBean != null && (items = downloadListBean.getItems()) != null) {
            for (DownloadItem downloadItem : items) {
                if (list == null || !(!list.isEmpty())) {
                    z10 = f60023a.z(downloadListBean, subject, downloadItem, str, str2, str3, str4, str5);
                } else {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.c(((DownloadBean) obj).getResourceId(), downloadItem.getResourceId())) {
                            break;
                        }
                    }
                    z10 = (DownloadBean) obj;
                    if (z10 == null) {
                        z10 = f60023a.z(downloadListBean, subject, downloadItem, str, str2, str3, str4, str5);
                    }
                }
                z10.setVipInfo(downloadListBean.getVipInfo());
                arrayList.add(z10);
            }
        }
        return arrayList;
    }
}
