package com.cloud.h5update.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.DownloadEntity;
import com.cloud.h5update.bean.PreloadResource;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.h5update.download.DownloadManager;
import com.cloud.h5update.service.LocalH5UpdateJobService;
import com.cloud.h5update.service.LocalH5UpdateService;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f21391a = new l();

    private l() {
    }

    private final void d(PreloadResource preloadResource) {
        String f11;
        String i11 = i(preloadResource);
        DownloadEntity h11 = h(i11);
        if (h11 != null) {
            try {
                String filePath = h11.getFilePath();
                String fileName = h11.getFileName();
                if (fileName == null) {
                    fileName = "";
                }
                File file = new File(filePath, fileName);
                if (file.exists() && !file.delete()) {
                    gg.b.f63690a.b("failed to delete file:" + file.getAbsolutePath());
                }
                c(i11);
                DownloadManager.f21350g.a().d(i11);
                return;
            } catch (Exception e11) {
                gg.b.f63690a.e(e11);
                return;
            }
        }
        try {
            String url = preloadResource.getUrl();
            Intrinsics.e(url);
            String k11 = k(url);
            TH5Update.a aVar = TH5Update.f21320c;
            if (aVar.g()) {
                f11 = aVar.f() + File.separator + preloadResource.getEncryptedStaticZip();
            } else {
                f11 = aVar.f();
            }
            File file2 = new File(f11, k11);
            if (!file2.exists() || file2.delete()) {
                return;
            }
            gg.b.f63690a.b("failed to delete file:" + file2.getAbsolutePath());
        } catch (Exception e12) {
            gg.b.f63690a.e(e12);
        }
    }

    private final String g(Context context, String str) {
        String path;
        if (!m() || context.getExternalCacheDir() == null) {
            path = context.getCacheDir().getPath();
        } else {
            File externalCacheDir = context.getExternalCacheDir();
            Intrinsics.e(externalCacheDir);
            path = externalCacheDir.getPath();
        }
        if (path == null) {
            path = context.getCacheDir().getPath();
        }
        String str2 = path + File.separator + str;
        File file = new File(str2);
        if (!file.exists() && file.mkdirs()) {
            gg.b.f63690a.b("create file dir success");
        }
        return str2;
    }

    private final File j(DownloadEntity downloadEntity) {
        if (downloadEntity == null) {
            return null;
        }
        String filePath = downloadEntity.getFilePath();
        if (filePath == null) {
            filePath = "";
        }
        return new File(filePath + File.separator + downloadEntity.getFileName());
    }

    private final void l(UpdateEntity updateEntity) {
        if (updateEntity.getUpdateMode() == null) {
            gg.b.f63690a.c("updateEntity.updateMode == null");
            return;
        }
        new Bundle().putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, updateEntity.getUpdateMode().intValue());
        Integer updateMode = updateEntity.getUpdateMode();
        if (updateMode != null && updateMode.intValue() == 1) {
            LocalH5UpdateService.INSTANCE.a(TH5Update.f21320c.c());
            return;
        }
        if (updateMode != null && updateMode.intValue() == 2) {
            LocalH5UpdateJobService.INSTANCE.a(TH5Update.f21320c.c());
            return;
        }
        if (updateMode != null && updateMode.intValue() == 3) {
            LocalH5UpdateService.Companion companion = LocalH5UpdateService.INSTANCE;
            TH5Update.a aVar = TH5Update.f21320c;
            companion.a(aVar.c());
            LocalH5UpdateJobService.INSTANCE.a(aVar.c());
            return;
        }
        if (updateMode != null && updateMode.intValue() == 4) {
            e(updateEntity);
        }
    }

    private final boolean m() {
        return Intrinsics.c("mounted", Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(PreloadResource preloadResource, Context context) {
        t6.b j11;
        Intrinsics.h(context, "$context");
        TH5Update.a aVar = TH5Update.f21320c;
        if (aVar.j() != null) {
            t6.b j12 = aVar.j();
            Intrinsics.e(j12);
            String staticZipUrl = preloadResource != null ? preloadResource.getStaticZipUrl() : null;
            Intrinsics.e(staticZipUrl);
            if (!j12.onZipDownloaded(staticZipUrl)) {
                return;
            }
        }
        l lVar = f21391a;
        File j13 = lVar.j(lVar.h(lVar.i(preloadResource)));
        if (h.f21378a.u(preloadResource != null ? preloadResource.getEncryptedStaticZip() : null, j13)) {
            lVar.r(context, j13);
            if (j13 != null && j13.getParentFile() != null && (j11 = aVar.j()) != null) {
                String staticZipUrl2 = preloadResource != null ? preloadResource.getStaticZipUrl() : null;
                Intrinsics.e(staticZipUrl2);
                File parentFile = j13.getParentFile();
                String absolutePath = parentFile != null ? parentFile.getAbsolutePath() : null;
                Intrinsics.e(absolutePath);
                j11.onUnZipDownloadFinish(staticZipUrl2, absolutePath, j13);
            }
            j jVar = j.f21386a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("last_update_url_version");
            sb2.append(preloadResource != null ? preloadResource.getStaticZipUrl() : null);
            String sb3 = sb2.toString();
            Long version = preloadResource != null ? preloadResource.getVersion() : null;
            Intrinsics.e(version);
            jVar.g(sb3, version.longValue());
        } else {
            t6.b j14 = aVar.j();
            if (j14 != null) {
                String staticZipUrl3 = preloadResource != null ? preloadResource.getStaticZipUrl() : null;
                Intrinsics.e(staticZipUrl3);
                j14.onError(staticZipUrl3, 104, "ERROR_VALID");
            }
            gg.b bVar = gg.b.f63690a;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("md5比对失败:");
            sb4.append(j13 != null ? j13.getAbsolutePath() : null);
            bVar.c(sb4.toString());
        }
        if (preloadResource != null) {
            lVar.d(preloadResource);
        }
    }

    private final void r(Context context, File file) {
        if (file == null) {
            return;
        }
        gg.b.f63690a.g("开始安装zip文件, 文件路径:" + file.getAbsolutePath());
        s(context, file);
    }

    private final boolean s(Context context, File file) {
        if (context != null && file != null) {
            try {
                m mVar = m.f21392a;
                String absolutePath = file.getParentFile().getAbsolutePath();
                Intrinsics.g(absolutePath, "zipFile.parentFile.absolutePath");
                mVar.a(file, absolutePath);
                return true;
            } catch (IOException e11) {
                t6.b j11 = TH5Update.f21320c.j();
                if (j11 != null) {
                    String absolutePath2 = file.getAbsolutePath();
                    Intrinsics.e(absolutePath2);
                    j11.onError(absolutePath2, 105, "ERROR_UNZIP");
                }
                gg.b.f63690a.g("An error occurred while install zip:" + e11.getMessage());
            }
        }
        return false;
    }

    public final boolean b() {
        Object systemService = TH5Update.f21320c.d().l().getSystemService("connectivity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void c(String str) {
        if (str == null || StringsKt.q0(str)) {
            return;
        }
        j.f21386a.i(str);
    }

    public final void e(UpdateEntity updateEntity) {
        if (updateEntity == null) {
            return;
        }
        TH5Update.a aVar = TH5Update.f21320c;
        if (aVar.h()) {
            gg.b.f63690a.i("update task is going on");
            return;
        }
        aVar.p(true);
        List<PreloadResource> preloadResource = updateEntity.getPreloadResource();
        if (preloadResource != null) {
            for (PreloadResource preloadResource2 : preloadResource) {
                if (preloadResource2.getVersion() != null && !TextUtils.isEmpty(preloadResource2.getStaticZipUrl())) {
                    j jVar = j.f21386a;
                    long c11 = jVar.c("last_update_url_version" + preloadResource2.getStaticZipUrl(), 0L);
                    if (c11 == 0) {
                        c11 = jVar.b("last_update_url_version" + preloadResource2.getStaticZipUrl(), 0);
                    }
                    if (c11 >= preloadResource2.getVersion().longValue()) {
                        gg.b.f63690a.g("h5update no need to update for version:" + preloadResource2.getVersion());
                        t6.b j11 = TH5Update.f21320c.j();
                        if (j11 != null) {
                            String staticZipUrl = preloadResource2.getStaticZipUrl();
                            Intrinsics.e(staticZipUrl);
                            j11.onNoNeedDownload(staticZipUrl);
                        }
                    } else {
                        l lVar = f21391a;
                        if (DownloadManager.f21350g.a().l(lVar.i(preloadResource2))) {
                            TH5Update.a aVar2 = TH5Update.f21320c;
                            lVar.n(aVar2.d().l(), preloadResource2);
                            ConcurrentHashMap i11 = aVar2.i();
                            String staticZipUrl2 = preloadResource2.getStaticZipUrl();
                            Intrinsics.e(staticZipUrl2);
                            i11.put(staticZipUrl2, Boolean.TRUE);
                        } else {
                            a aVar3 = a.f21374a;
                            String packageName = updateEntity.getPackageName();
                            if (packageName == null) {
                                packageName = "";
                            }
                            aVar3.b(packageName, preloadResource2);
                        }
                    }
                }
            }
        }
        TH5Update.f21320c.p(false);
    }

    public final String f() {
        return g(TH5Update.f21320c.d().l(), "tupdate");
    }

    public final DownloadEntity h(String str) {
        if (str != null && !StringsKt.q0(str)) {
            try {
                return (DownloadEntity) j.f21386a.d(str, DownloadEntity.class);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public final String i(PreloadResource preloadResource) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(preloadResource != null ? preloadResource.getStaticZipUrl() : null);
        sb2.append(preloadResource != null ? preloadResource.getVersion() : null);
        return String.valueOf(sb2.toString().hashCode());
    }

    public final String k(String downloadUrl) {
        Intrinsics.h(downloadUrl, "downloadUrl");
        if (TextUtils.isEmpty(downloadUrl)) {
            return "temp_" + System.currentTimeMillis() + ".zip";
        }
        String substring = downloadUrl.substring(StringsKt.v0(downloadUrl, "/", 0, false, 6, null) + 1);
        Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
        if (StringsKt.G(substring, ".zip", false, 2, null)) {
            return substring;
        }
        return "temp_" + System.currentTimeMillis() + ".zip";
    }

    public final void n(final Context context, final PreloadResource preloadResource) {
        Intrinsics.h(context, "context");
        ThreadPoolExecutor f11 = DownloadManager.f21350g.a().f();
        if (f11 != null) {
            f11.execute(new Runnable() { // from class: com.cloud.h5update.utils.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.o(PreloadResource.this, context);
                }
            });
        }
    }

    public final void p(UpdateEntity updateEntity) {
        if (updateEntity == null || updateEntity.getVersion() == null) {
            return;
        }
        j jVar = j.f21386a;
        long c11 = jVar.c("last_update_version", 0L);
        if (c11 == 0) {
            c11 = jVar.b("last_update_version", 0);
        }
        if (c11 < ((int) updateEntity.getVersion().longValue())) {
            l(updateEntity);
            return;
        }
        t6.b j11 = TH5Update.f21320c.j();
        if (j11 != null) {
            String packageName = updateEntity.getPackageName();
            Intrinsics.e(packageName);
            j11.onError(packageName, 102, "ERROR_VERSION");
        }
        gg.b.f63690a.g("no need update for version " + ((int) updateEntity.getVersion().longValue()));
    }

    public final Object q(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public final void t(String str, DownloadEntity downloadEntity) {
        if (downloadEntity == null || str == null || StringsKt.q0(str)) {
            return;
        }
        j.f21386a.h(str, downloadEntity);
    }
}
