package mm;

import com.transsion.lib_web.download_render.FileDownloadTaskManager;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.FileOperateStatus;
import com.transsion.lib_web.download_render.utils.e;
import gm.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes6.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    private final String f69752a;

    /* renamed from: b, reason: collision with root package name */
    private final String f69753b;

    /* renamed from: c, reason: collision with root package name */
    private final List f69754c;

    /* renamed from: d, reason: collision with root package name */
    private final Function4 f69755d;

    /* renamed from: e, reason: collision with root package name */
    private final String f69756e;

    public c(String url, String version, List files, Function4 callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(version, "version");
        Intrinsics.h(files, "files");
        Intrinsics.h(callback, "callback");
        this.f69752a = url;
        this.f69753b = version;
        this.f69754c = files;
        this.f69755d = callback;
        this.f69756e = "DR_FileOperateDownload";
    }

    public String a() {
        return this.f69756e;
    }

    @Override // mm.d
    public void invoke() {
        Iterator it;
        String md5;
        File parentFile;
        Iterator it2 = this.f69754c.iterator();
        int i11 = 0;
        String str = "";
        long j11 = 0;
        while (it2.hasNext()) {
            FileData fileData = (FileData) it2.next();
            String i12 = FileDownloadTaskManager.f46201a.i();
            if (i12 == null) {
                i12 = "";
            }
            e eVar = e.f46244a;
            if (Intrinsics.c(eVar.a(i12), eVar.a(this.f69752a))) {
                i.f64006a.f(a(), "<FileOperateDownload> current webview is loading:" + ((Object) i12) + ", downloading:" + this.f69752a + ", are the same, so intercept!");
                this.f69755d.invoke(Boolean.TRUE, i12, Integer.valueOf(i11), Long.valueOf(j11));
                return;
            }
            String fileUrl = fileData.getFileUrl();
            if (fileUrl == null || (md5 = fileData.getMd5()) == null) {
                it = it2;
            } else {
                try {
                    Response execute = com.transsion.lib_web.zip.loader.b.f46254a.d().newCall(new Request.Builder().url(fileUrl).build()).execute();
                    try {
                        if (!execute.isSuccessful()) {
                            throw new IOException("Unexpected code " + execute);
                        }
                        File b11 = com.transsion.lib_web.download_render.utils.c.f46241a.b(this.f69752a, fileUrl, md5, fileData.getMimeType());
                        File parentFile2 = b11.getParentFile();
                        if (parentFile2 != null && !parentFile2.exists() && (parentFile = b11.getParentFile()) != null) {
                            parentFile.mkdirs();
                        }
                        ResponseBody body = execute.body();
                        InputStream byteStream = body != null ? body.byteStream() : null;
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(b11);
                            if (byteStream != null) {
                                it = it2;
                                try {
                                    try {
                                        ByteStreamsKt.b(byteStream, fileOutputStream, 0, 2, null);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Throwable th3 = th;
                                        try {
                                            throw th3;
                                            break;
                                        } catch (Throwable th4) {
                                            CloseableKt.a(byteStream, th3);
                                            throw th4;
                                        }
                                    }
                                } finally {
                                    try {
                                        break;
                                    } catch (Throwable th5) {
                                    }
                                }
                            } else {
                                it = it2;
                            }
                            CloseableKt.a(fileOutputStream, null);
                            try {
                                CloseableKt.a(byteStream, null);
                                fileData.setFileOperateStatus$lib_web_release(FileOperateStatus.NONE);
                                fileData.setFileLocalPath$lib_web_release(b11.getAbsolutePath());
                                com.transsion.lib_web.download_render.c.f46221a.b(this.f69752a, this.f69753b, fileData);
                                i11++;
                                Long size = fileData.getSize();
                                j11 += size != null ? size.longValue() : 0L;
                                i.f64006a.a(a(), "<FileOperateDownload> download: " + fileUrl + " success, dst:" + b11.getAbsolutePath());
                                Unit unit = Unit.f67184a;
                                try {
                                    CloseableKt.a(execute, null);
                                } catch (Throwable th6) {
                                    th = th6;
                                    i.f64006a.f(a(), "<FileOperateDownload> download: " + fileUrl + " fail, msg:" + th);
                                    str = i12;
                                    it2 = it;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                Throwable th8 = th;
                                try {
                                    throw th8;
                                    break;
                                } catch (Throwable th9) {
                                    CloseableKt.a(execute, th8);
                                    throw th9;
                                    break;
                                }
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            it = it2;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        it = it2;
                    }
                } catch (Throwable th12) {
                    th = th12;
                    it = it2;
                }
            }
            str = i12;
            it2 = it;
        }
        this.f69755d.invoke(Boolean.FALSE, str, Integer.valueOf(i11), Long.valueOf(j11));
    }
}
