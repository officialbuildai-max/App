package com.transsion.subtitle_download.utils;

import android.os.Build;
import android.os.LocaleList;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.m;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.io.File;
import java.util.Locale;
import java.util.Random;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f55170a = new e();

    private e() {
    }

    private final String d() {
        String simpleName = e.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void a(String directoryPath) {
        Intrinsics.h(directoryPath, "directoryPath");
        File file = new File(directoryPath);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public final void b(String str) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            File file = new File(str == null ? "" : str);
            String str2 = file.exists() ? file.delete() ? "文件删除成功" : "文件删除失败" : "文件不存在";
            b.f55167a.a(f55170a.d() + " --> deleteFile() --> " + str2 + " --> path = " + str);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        b.f55167a.b(f55170a.d() + " --> deleteFile() --> 删除文件发生异常 --> it = " + m1188exceptionOrNullimpl);
    }

    public final String c(int i11) {
        Random random = new Random();
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return sb2.toString();
    }

    public final String e() {
        return "en";
    }

    public final String f() {
        Object m1185constructorimpl;
        Locale locale;
        LocaleList locales;
        try {
            Result.Companion companion = Result.INSTANCE;
            String g11 = SubtitleDownloadManager.f55121a.g();
            if (Build.VERSION.SDK_INT >= 24) {
                locales = Utils.a().getResources().getConfiguration().getLocales();
                locale = locales.get(0);
            } else {
                locale = Utils.a().getResources().getConfiguration().locale;
            }
            m1185constructorimpl = Result.m1185constructorimpl((Intrinsics.c(locale.getLanguage(), g11) || g11 == null || g11.length() <= 0) ? locale.getLanguage() : new Locale(g11, locale.getCountry()).getLanguage());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = "";
        }
        return (String) m1185constructorimpl;
    }

    public final String g() {
        return lh.a.f68965a.a(System.currentTimeMillis() + c(10));
    }

    public final File h(String directory, String fileName) {
        Intrinsics.h(directory, "directory");
        Intrinsics.h(fileName, "fileName");
        String k12 = StringsKt.k1(fileName, '.', null, 2, null);
        String str = "";
        String c12 = StringsKt.c1(fileName, '.', "");
        if (c12.length() > 0) {
            str = "." + c12;
        }
        File file = new File(directory, fileName);
        int i11 = 1;
        while (file.exists()) {
            file = new File(directory, k12 + "_" + i11 + str);
            i11++;
        }
        return file;
    }

    public final boolean i(String str) {
        if (str != null) {
            return new File(str).exists();
        }
        return false;
    }

    public final boolean j(SubtitleDownloadTable subtitleBean) {
        Intrinsics.h(subtitleBean, "subtitleBean");
        String path = subtitleBean.getPath();
        if (path == null) {
            path = "";
        }
        if (!new File(path).exists()) {
            return false;
        }
        try {
            String path2 = subtitleBean.getPath();
            Intrinsics.e(path2);
            String b11 = sz.a.b(m.b(path2), true);
            b.f55167a.a(d() + " --> parseFileCharsetName() --> fileCharsetName = " + b11);
            Intrinsics.e(b11);
            if (b11.length() <= 0) {
                return true;
            }
            subtitleBean.setFileCharsetName(b11);
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }
}
