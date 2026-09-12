package com.transsion.lib_web.download_render.utils;

import androidx.core.view.PointerIconCompat;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.data.PageListData;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f46239a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f46240b = new ConcurrentHashMap();

    private a() {
    }

    private final RenderStage c(String str) {
        try {
            return (RenderStage) f46240b.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private final void l(String str) {
        try {
            f46240b.remove(str);
        } catch (Throwable unused) {
        }
    }

    public final void a(String url, RenderSource source) {
        Intrinsics.h(url, "url");
        Intrinsics.h(source, "source");
        try {
            ConcurrentHashMap concurrentHashMap = f46240b;
            concurrentHashMap.remove(url);
            concurrentHashMap.put(url, new RenderStage(url, source.getDes(), System.currentTimeMillis(), false, false, false, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null));
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        List<PageData> l11;
        Map<String, PageData> h11;
        try {
            com.transsion.lib_web.download_render.c cVar = com.transsion.lib_web.download_render.c.f46221a;
            PageListData l12 = cVar.l();
            if (l12 == null || (l11 = l12.getH5Pages()) == null) {
                l11 = CollectionsKt.l();
            }
            PageListData l13 = cVar.l();
            if (l13 == null || (h11 = l13.getLocalH5Pages()) == null) {
                h11 = MapsKt.h();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (PageData pageData : l11) {
                String url = pageData.getUrl();
                if (url != null) {
                    PageData pageData2 = h11.get(url);
                    String str = "";
                    if (pageData2 == null) {
                        String versionCode = pageData.getVersionCode();
                        if (versionCode != null) {
                            str = versionCode;
                        }
                        List<FileData> files = pageData.getFiles();
                        linkedHashMap.put(url, new DownloadData(url, str, files != null ? files.size() : 0, 0));
                    } else {
                        String versionCode2 = pageData.getVersionCode();
                        if (versionCode2 != null) {
                            str = versionCode2;
                        }
                        List<FileData> files2 = pageData.getFiles();
                        linkedHashMap.put(url, new DownloadData(url, str, files2 != null ? files2.size() : 0, pageData2.getLocalFileMap().size()));
                    }
                }
            }
            ReportUtil.f46237a.a(linkedHashMap);
        } catch (Throwable unused) {
        }
    }

    public final void d(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            if (!c11.getStage1().getStageFinished()) {
                FileScoreData stage1 = c11.getStage1();
                stage1.setException(stage1.getException() + 1);
            }
            if (!c11.getStage2().getStageFinished()) {
                FileScoreData stage2 = c11.getStage2();
                stage2.setException(stage2.getException() + 1);
            }
            if (c11.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c11.getStage3();
            stage3.setException(stage3.getException() + 1);
        }
    }

    public final void e(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            if (!c11.getStage1().getStageFinished()) {
                FileScoreData stage1 = c11.getStage1();
                stage1.setFileDataNull(stage1.getFileDataNull() + 1);
            }
            if (!c11.getStage2().getStageFinished()) {
                FileScoreData stage2 = c11.getStage2();
                stage2.setFileDataNull(stage2.getFileDataNull() + 1);
            }
            if (c11.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c11.getStage3();
            stage3.setFileDataNull(stage3.getFileDataNull() + 1);
        }
    }

    public final void f(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            if (!c11.getStage1().getStageFinished()) {
                FileScoreData stage1 = c11.getStage1();
                stage1.setFileOperateStatusAbort(stage1.getFileOperateStatusAbort() + 1);
            }
            if (!c11.getStage2().getStageFinished()) {
                FileScoreData stage2 = c11.getStage2();
                stage2.setFileOperateStatusAbort(stage2.getFileOperateStatusAbort() + 1);
            }
            if (c11.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c11.getStage3();
            stage3.setFileOperateStatusAbort(stage3.getFileOperateStatusAbort() + 1);
        }
    }

    public final void g(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            if (!c11.getStage1().getStageFinished()) {
                FileScoreData stage1 = c11.getStage1();
                stage1.setFileUnExist(stage1.getFileUnExist() + 1);
            }
            if (!c11.getStage2().getStageFinished()) {
                FileScoreData stage2 = c11.getStage2();
                stage2.setFileUnExist(stage2.getFileUnExist() + 1);
            }
            if (c11.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c11.getStage3();
            stage3.setFileUnExist(stage3.getFileUnExist() + 1);
        }
    }

    public final void h(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            if (!c11.getStage1().getStageFinished()) {
                FileScoreData stage1 = c11.getStage1();
                stage1.setHtmlFromRemote(stage1.getHtmlFromRemote() + 1);
            }
            if (!c11.getStage2().getStageFinished()) {
                FileScoreData stage2 = c11.getStage2();
                stage2.setHtmlFromRemote(stage2.getHtmlFromRemote() + 1);
            }
            if (c11.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c11.getStage3();
            stage3.setHtmlFromRemote(stage3.getHtmlFromRemote() + 1);
        }
    }

    public final void i(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            if (!c11.getStage1().getStageFinished()) {
                FileScoreData stage1 = c11.getStage1();
                stage1.setScore(stage1.getScore() + 1);
            }
            if (!c11.getStage2().getStageFinished()) {
                FileScoreData stage2 = c11.getStage2();
                stage2.setScore(stage2.getScore() + 1);
            }
            if (c11.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c11.getStage3();
            stage3.setScore(stage3.getScore() + 1);
        }
    }

    public final void j(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            c11.setNeedReport(true);
        }
    }

    public final void k(String url, String originalUrl, int i11) {
        Intrinsics.h(url, "url");
        Intrinsics.h(originalUrl, "originalUrl");
        if (Intrinsics.c(url, originalUrl) && i11 == 100) {
            p(url);
        }
    }

    public final void m(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            c11.setRenderWithDownload(true);
        }
    }

    public final void n() {
        ConcurrentHashMap concurrentHashMap = f46240b;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        Set keySet = concurrentHashMap.keySet();
        Intrinsics.g(keySet, "<get-keys>(...)");
        Object h02 = CollectionsKt.h0(keySet);
        Intrinsics.g(h02, "first(...)");
        String str = (String) h02;
        q(str);
        ReportUtil reportUtil = ReportUtil.f46237a;
        Collection values = concurrentHashMap.values();
        Intrinsics.g(values, "<get-values>(...)");
        reportUtil.c((RenderStage) CollectionsKt.h0(values));
        l(str);
    }

    public final void o(String url, CacheType cacheType) {
        Intrinsics.h(url, "url");
        Intrinsics.h(cacheType, "cacheType");
        RenderStage c11 = c(url);
        if (c11 != null) {
            c11.setType(cacheType.getDes());
        }
    }

    public final void p(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            c11.getStage1().setStageFinished(true);
            c11.getStage1().setRenderTime(System.currentTimeMillis() - c11.getRenderStartTime());
        }
    }

    public final void q(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            c11.getStage3().setStageFinished(true);
            c11.getStage3().setRenderTime(System.currentTimeMillis() - c11.getRenderStartTime());
        }
    }

    public final void r(String url) {
        Intrinsics.h(url, "url");
        RenderStage c11 = c(url);
        if (c11 != null) {
            c11.getStage2().setStageFinished(true);
            c11.getStage2().setRenderTime(System.currentTimeMillis() - c11.getRenderStartTime());
        }
    }
}
