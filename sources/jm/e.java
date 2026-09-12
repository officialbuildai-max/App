package jm;

import com.blankj.utilcode.util.o;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.data.PageListData;
import gm.i;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes6.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    private final long f66357a;

    /* renamed from: b, reason: collision with root package name */
    private final PageData f66358b;

    /* renamed from: c, reason: collision with root package name */
    private final String f66359c;

    public e(long j11, PageData pageData) {
        Intrinsics.h(pageData, "pageData");
        this.f66357a = j11;
        this.f66358b = pageData;
        this.f66359c = "DR_ManifestDownloadTask";
    }

    @Override // jm.d
    public void start() {
        String manifestUrl;
        List<PageData> h5Pages;
        PageListData l11 = com.transsion.lib_web.download_render.c.f46221a.l();
        if (l11 != null && (h5Pages = l11.getH5Pages()) != null) {
            for (PageData pageData : h5Pages) {
                if (Intrinsics.c(pageData.getUrl(), this.f66358b.getUrl())) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        pageData = null;
        List<FileData> files = pageData != null ? pageData.getFiles() : null;
        if ((files != null && !files.isEmpty()) || pageData == null || (manifestUrl = pageData.getManifestUrl()) == null) {
            return;
        }
        try {
            i iVar = i.f64006a;
            iVar.a(this.f66359c, "<ManifestDownloadTask> start id:" + this.f66357a);
            Response execute = com.transsion.lib_web.zip.loader.b.f46254a.d().newCall(new Request.Builder().url(manifestUrl).build()).execute();
            try {
                if (!execute.isSuccessful()) {
                    throw new IOException("Unexpected code " + execute);
                }
                ResponseBody body = execute.body();
                if (body != null) {
                    try {
                        pageData.setFiles(((PageData) o.d(body.string(), PageData.class)).getFiles());
                        com.transsion.lib_web.download_render.c.f46221a.o(pageData);
                        Unit unit = Unit.f67184a;
                        CloseableKt.a(body, null);
                    } finally {
                    }
                }
                CloseableKt.a(execute, null);
                iVar.a(this.f66359c, "<ManifestDownloadTask> end id:" + this.f66357a);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(execute, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            try {
                i iVar2 = i.f64006a;
                iVar2.f(this.f66359c, "<ManifestDownloadTask> download: " + manifestUrl + " fail, msg:" + th4);
                Unit unit2 = Unit.f67184a;
                iVar2.a(this.f66359c, "<ManifestDownloadTask> end id:" + this.f66357a);
            } catch (Throwable th5) {
                i.f64006a.a(this.f66359c, "<ManifestDownloadTask> end id:" + this.f66357a);
                throw th5;
            }
        }
    }
}
