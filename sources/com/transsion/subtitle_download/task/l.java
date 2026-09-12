package com.transsion.subtitle_download.task;

import android.app.Application;
import android.net.Uri;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.blankj.utilcode.util.Utils;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.io.File;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes6.dex */
public final class l extends b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(SubtitleDownloadTable subtitleDownloadTable, int i11) {
        SubtitleDownloadManager.f55121a.p(i11, subtitleDownloadTable);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(SubtitleDownloadTable subtitleDownloadTable, String str, l lVar) {
        subtitleDownloadTable.setZipPath(str);
        SubtitleDownloadDatabase.Companion companion = SubtitleDownloadDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        companion.b(a11).l0().f(subtitleDownloadTable);
        com.transsion.subtitle_download.utils.b.f55167a.a(lVar.l() + " --> disposeOnResponse() --> 压缩文件保存在 = " + str + " -- getSubtitleInfo = " + subtitleDownloadTable.getSubtitleInfo());
        return Unit.f67184a;
    }

    private final boolean q(SubtitleDownloadTable subtitleDownloadTable) {
        if (com.transsion.subtitle_download.utils.e.f55170a.j(subtitleDownloadTable)) {
            com.transsion.subtitle_download.utils.b.f55167a.a(l() + " --> parseFileCharsetName() --> 字幕压缩包下载成功 --> 开始解析字幕文件的编码格式 --> 成功 --> 保存状态到数据库");
            subtitleDownloadTable.setStatus(5);
            SubtitleDownloadDatabase.Companion companion = SubtitleDownloadDatabase.INSTANCE;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            companion.b(a11).l0().f(subtitleDownloadTable);
            SubtitleDownloadManager.f55121a.n(subtitleDownloadTable);
            return true;
        }
        try {
            Result.Companion companion2 = Result.INSTANCE;
            String path = subtitleDownloadTable.getPath();
            if (path == null) {
                path = "";
            }
            Result.m1185constructorimpl(Boolean.valueOf(new File(path).delete()));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        h(subtitleDownloadTable, new RuntimeException(l() + " --> parseFileCharsetName() --> 解析字幕文件的编码格式失败 --> 删除字幕文件"));
        return false;
    }

    private final boolean r(SubtitleDownloadTable subtitleDownloadTable) {
        String str;
        boolean z10;
        SubtitleDownloadManager.f55121a.r(subtitleDownloadTable);
        String zipPath = subtitleDownloadTable.getZipPath();
        com.transsion.subtitle_download.utils.b bVar = com.transsion.subtitle_download.utils.b.f55167a;
        bVar.a(l() + " --> unGzZip() --> 字幕压缩包下载成功 --> 开始解压缩 .... zipPath = " + zipPath);
        if (subtitleDownloadTable.getEp() > 0) {
            str = b.f55139a.c() + File.separatorChar + subtitleDownloadTable.getSubjectFileName() + "_S" + subtitleDownloadTable.getSe() + "_E" + subtitleDownloadTable.getEp();
        } else {
            str = b.f55139a.c() + File.separatorChar + subtitleDownloadTable.getSubjectFileName();
        }
        com.transsion.subtitle_download.utils.e.f55170a.a(str);
        String str2 = str + File.separatorChar + subtitleDownloadTable.getName();
        boolean a11 = com.transsion.subtitle_download.utils.a.f55166a.a(subtitleDownloadTable.getZipPath(), str2);
        if (a11) {
            bVar.a(l() + " --> unGzZip() --> 字幕压缩包下载成功 --> 开始解压缩 --> 解压缩成功");
            subtitleDownloadTable.setPath(str2);
            z10 = true;
        } else {
            h(subtitleDownloadTable, new RuntimeException(l() + " --> unGzZip() --> 字幕压缩文件解压失败"));
            z10 = false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            new File(zipPath).delete();
            bVar.a(l() + " --> unGzZip() --> result = " + a11 + " -- 无论成功失败，都删除压缩包 -- 这里修改成删除压缩缓存文件夹里面的所有文件");
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return z10;
    }

    @Override // com.transsion.subtitle_download.task.b
    public void i(Response response, final SubtitleDownloadTable dbBean) {
        String str;
        Intrinsics.h(response, "response");
        Intrinsics.h(dbBean, "dbBean");
        int code = response.code();
        if (200 > code || code >= 300) {
            h(dbBean, new RuntimeException(l() + " --> disposeOnResponse() --> 搜索字幕接口请求失败 --> response.code = " + response.code()));
            return;
        }
        String str2 = response.headers().get(HttpHeaders.CONTENT_DISPOSITION);
        List S0 = str2 != null ? StringsKt.S0(str2, new String[]{"filename="}, false, 0, 6, null) : null;
        com.transsion.subtitle_download.utils.b bVar = com.transsion.subtitle_download.utils.b.f55167a;
        bVar.a(l() + " --> disposeOnResponse() --> 请求成功 --> response.code = " + response.code() + " -- list = " + S0);
        if (S0 == null || !(!S0.isEmpty()) || S0.size() <= 1) {
            str = b.f55139a.d() + File.separatorChar + Uri.decode(dbBean.getName()).hashCode();
        } else {
            String replace = new Regex("[\\\\/:*?\"<>|]").replace(Uri.decode((String) S0.get(1)).toString(), "");
            str = b.f55139a.d() + File.separatorChar + replace;
        }
        final String str3 = str;
        ResponseBody body = response.body();
        if (j(response, str3, body != null ? body.getContentLength() : 0L, dbBean, new Function1() { // from class: com.transsion.subtitle_download.task.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o11;
                o11 = l.o(SubtitleDownloadTable.this, ((Integer) obj).intValue());
                return o11;
            }
        }, new Function0() { // from class: com.transsion.subtitle_download.task.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit p11;
                p11 = l.p(SubtitleDownloadTable.this, str3, this);
                return p11;
            }
        }) && r(dbBean) && q(dbBean)) {
            bVar.b("--------------------------------------------------------------------");
        }
    }
}
