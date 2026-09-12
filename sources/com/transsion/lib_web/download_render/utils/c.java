package com.transsion.lib_web.download_render.utils;

import android.net.Uri;
import com.blankj.utilcode.util.Utils;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f46241a = new c();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(File file) {
        return file.isDirectory();
    }

    public final File b(String url, String fileUrl, String fileMd5, String str) {
        int v02;
        Intrinsics.h(url, "url");
        Intrinsics.h(fileUrl, "fileUrl");
        Intrinsics.h(fileMd5, "fileMd5");
        File file = new File(Utils.a().getFilesDir(), "DownloadRender");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, lh.a.f68965a.a(url));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        Uri parse = Uri.parse(fileUrl);
        Intrinsics.g(parse, "parse(this)");
        String lastPathSegment = parse.getLastPathSegment();
        String str2 = "";
        if (lastPathSegment == null) {
            lastPathSegment = "";
        }
        int v03 = StringsKt.v0(lastPathSegment, ".", 0, false, 6, null);
        if (v03 != -1) {
            str2 = lastPathSegment.substring(v03, lastPathSegment.length());
            Intrinsics.g(str2, "substring(...)");
        }
        if (str2.length() == 0 && str != null && (v02 = StringsKt.v0(str, "/", 0, false, 6, null)) != -1) {
            String substring = str.substring(v02, str.length());
            Intrinsics.g(substring, "substring(...)");
            str2 = StringsKt.Q(substring, "/", ".", false, 4, null);
        }
        return new File(file2, fileMd5 + ((Object) str2));
    }

    public final List c(String path) {
        List K0;
        Intrinsics.h(path, "path");
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            return CollectionsKt.l();
        }
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.transsion.lib_web.download_render.utils.b
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                boolean d11;
                d11 = c.d(file2);
                return d11;
            }
        });
        return (listFiles == null || (K0 = ArraysKt.K0(listFiles)) == null) ? CollectionsKt.l() : K0;
    }
}
