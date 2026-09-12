package com.transsion.subtitle_download.task;

import android.app.Application;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.task.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes6.dex */
public final class i extends b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(SubtitleDownloadTable subtitleDownloadTable, int i11) {
        SubtitleDownloadManager.f55121a.p(i11, subtitleDownloadTable);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(SubtitleDownloadTable subtitleDownloadTable, String str, i iVar) {
        subtitleDownloadTable.setPath(str);
        com.transsion.subtitle_download.utils.e.f55170a.j(subtitleDownloadTable);
        subtitleDownloadTable.setStatus(5);
        SubtitleDownloadDatabase.Companion companion = SubtitleDownloadDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        companion.b(a11).l0().f(subtitleDownloadTable);
        com.transsion.subtitle_download.utils.b.f55167a.a(iVar.l() + " --> disposeOnResponse() --> 文件保存在 = " + str + " -- resourceId = " + subtitleDownloadTable.getResourceId() + " --> getSubtitleInfo = " + subtitleDownloadTable.getSubtitleInfo());
        SubtitleDownloadManager.f55121a.n(subtitleDownloadTable);
        return Unit.f67184a;
    }

    private final String q(Response response) {
        String header$default = Response.header$default(response, HttpHeaders.CONTENT_DISPOSITION, null, 2, null);
        if (header$default != null) {
            Matcher matcher = Pattern.compile("filename=\"?([^\";]*)\"?").matcher(header$default);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return null;
    }

    @Override // com.transsion.subtitle_download.task.b
    public void i(Response response, final SubtitleDownloadTable dbBean) {
        String str;
        String h12;
        Intrinsics.h(response, "response");
        Intrinsics.h(dbBean, "dbBean");
        ResponseBody body = response.body();
        long contentLength = body != null ? body.getContentLength() : 0L;
        if (response.body() == null) {
            com.transsion.subtitle_download.utils.b.f55167a.b(l() + " --> disposeOnResponse() --> null == response.body --> headers = " + response.headers());
        }
        String url = dbBean.getUrl();
        String str2 = null;
        if (url != null && (h12 = StringsKt.h1(url, UrlUtils.QUESTION_MARK, null, 2, null)) != null) {
            str2 = StringsKt.f1(h12, ".", null, 2, null);
        }
        String valueOf = String.valueOf(str2);
        String q11 = q(response);
        if (q11 == null) {
            q11 = dbBean.getName() + "." + valueOf;
        }
        if (dbBean.getEp() > 0) {
            str = b.f55139a.c() + File.separatorChar + dbBean.getSubjectFileName() + "_S" + dbBean.getSe() + "_E" + dbBean.getEp();
        } else {
            str = b.f55139a.c() + File.separatorChar + dbBean.getSubjectFileName();
        }
        com.transsion.subtitle_download.utils.e eVar = com.transsion.subtitle_download.utils.e.f55170a;
        eVar.a(str);
        final String path = eVar.h(str, q11).getPath();
        com.transsion.subtitle_download.utils.b.f55167a.a(l() + " --> disposeOnResponse() --> 接口请求成功 开始保存数据到本 --> " + dbBean.getName() + "." + dbBean.getResourceId() + ",文件大小 = " + contentLength + " --> destination = " + path);
        Intrinsics.e(path);
        j(response, path, contentLength, dbBean, new Function1() { // from class: com.transsion.subtitle_download.task.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o11;
                o11 = i.o(SubtitleDownloadTable.this, ((Integer) obj).intValue());
                return o11;
            }
        }, new Function0() { // from class: com.transsion.subtitle_download.task.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit p11;
                p11 = i.p(SubtitleDownloadTable.this, path, this);
                return p11;
            }
        });
    }

    @Override // com.transsion.subtitle_download.task.b
    public boolean j(Response response, String destination, long j11, SubtitleDownloadTable dbBean, Function1 progressCallback, Function0 completeCallback) {
        InputStream byteStream;
        Intrinsics.h(response, "response");
        Intrinsics.h(destination, "destination");
        Intrinsics.h(dbBean, "dbBean");
        Intrinsics.h(progressCallback, "progressCallback");
        Intrinsics.h(completeCallback, "completeCallback");
        com.transsion.subtitle_download.utils.e eVar = com.transsion.subtitle_download.utils.e.f55170a;
        b.a aVar = b.f55139a;
        eVar.a(aVar.c());
        eVar.a(aVar.d());
        try {
            ResponseBody body = response.body();
            if (body == null || (byteStream = body.byteStream()) == null) {
                return false;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(destination);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = byteStream.read(bArr);
                        if (read == -1) {
                            completeCallback.invoke();
                            CloseableKt.a(fileOutputStream, null);
                            CloseableKt.a(byteStream, null);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(byteStream, th2);
                    throw th3;
                }
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
