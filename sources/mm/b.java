package mm;

import com.transsion.lib_web.download_render.data.FileData;
import gm.i;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private final String f69748a;

    /* renamed from: b, reason: collision with root package name */
    private final String f69749b;

    /* renamed from: c, reason: collision with root package name */
    private final List f69750c;

    /* renamed from: d, reason: collision with root package name */
    private final String f69751d;

    public b(String url, String version, List files) {
        Intrinsics.h(url, "url");
        Intrinsics.h(version, "version");
        Intrinsics.h(files, "files");
        this.f69748a = url;
        this.f69749b = version;
        this.f69750c = files;
        this.f69751d = "DR_FileOperateDelete";
    }

    public String a() {
        return this.f69751d;
    }

    @Override // mm.d
    public void invoke() {
        for (FileData fileData : this.f69750c) {
            String fileLocalPath$lib_web_release = fileData.getFileLocalPath$lib_web_release();
            if (fileLocalPath$lib_web_release != null) {
                try {
                    File file = new File(fileLocalPath$lib_web_release);
                    if (file.exists()) {
                        file.delete();
                    }
                    com.transsion.lib_web.download_render.c cVar = com.transsion.lib_web.download_render.c.f46221a;
                    String str = this.f69748a;
                    String fileUrl = fileData.getFileUrl();
                    if (fileUrl == null) {
                        fileUrl = "";
                    }
                    cVar.c(str, fileUrl);
                    i.f64006a.a(a(), "<FileOperateDelete> delete path: " + fileLocalPath$lib_web_release + " success!");
                } catch (Throwable th2) {
                    i.f64006a.f(a(), "<FileOperateDelete> delete path: " + fileLocalPath$lib_web_release + " fail, msg:" + th2);
                }
            }
        }
    }
}
