package com.transsion.subtitle_download.task;

import android.app.Application;
import android.os.Environment;
import com.blankj.utilcode.util.Utils;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f55139a = new a(0 == true ? 1 : 0);

    /* renamed from: b, reason: collision with root package name */
    private static final String f55140b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f55141c;

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f55142d;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final OkHttpClient b() {
            return (OkHttpClient) b.f55142d.getValue();
        }

        public final String c() {
            return b.f55140b;
        }

        public final String d() {
            return b.f55141c;
        }
    }

    /* renamed from: com.transsion.subtitle_download.task.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0698b implements Callback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SubtitleDownloadTable f55144b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0 f55145c;

        C0698b(SubtitleDownloadTable subtitleDownloadTable, Function0 function0) {
            this.f55144b = subtitleDownloadTable;
            this.f55145c = function0;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e11) {
            Intrinsics.h(call, "call");
            Intrinsics.h(e11, "e");
            b.this.h(this.f55144b, new RuntimeException(e11.getMessage()));
            this.f55145c.invoke();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            int code;
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            if (response.isSuccessful()) {
                b.this.i(response, this.f55144b);
                this.f55145c.invoke();
            } else if (response.code() != 404 && 400 <= (code = response.code()) && code < 600) {
                b.this.g(response, this.f55144b, this.f55145c);
            } else {
                b.this.h(this.f55144b, new RuntimeException(response.message()));
                this.f55145c.invoke();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        File externalFilesDir = Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        String absolutePath = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
        char c11 = File.separatorChar;
        f55140b = absolutePath + c11 + "subtitle";
        File externalFilesDir2 = Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        f55141c = (externalFilesDir2 != null ? externalFilesDir2.getAbsolutePath() : null) + c11 + "subtitle_zip";
        f55142d = LazyKt.b(new Function0() { // from class: com.transsion.subtitle_download.task.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                OkHttpClient f11;
                f11 = b.f();
                return f11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient f() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).readTimeout(30L, timeUnit).cache(null).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Response response, SubtitleDownloadTable subtitleDownloadTable, Function0 function0) {
        h(subtitleDownloadTable, new RuntimeException(response.message()));
        function0.invoke();
    }

    public final void h(SubtitleDownloadTable dbBean, Exception e11) {
        Intrinsics.h(dbBean, "dbBean");
        Intrinsics.h(e11, "e");
        dbBean.setFailCount(dbBean.getFailCount() + 1);
        com.transsion.subtitle_download.utils.b bVar = com.transsion.subtitle_download.utils.b.f55167a;
        bVar.b(l() + " --> disposeOnFailure() --> e = " + e11.getMessage() + " -- getSubtitleInfo = " + dbBean.getSubtitleInfo() + " --> dbBean.failCount = " + dbBean.getFailCount());
        dbBean.setStatus(6);
        if (dbBean.getType() == 2 || dbBean.getType() == 4 || dbBean.getType() == 5 || dbBean.getFailCount() > 5) {
            bVar.b(l() + " --> disposeOnFailure() --> delete(dbBean) --> 如果是搜索字幕，下载失败就从数据库移除 --> getSubtitleInfo = " + dbBean.getSubtitleInfo() + " --> failCount = " + dbBean.getFailCount());
            SubtitleDownloadDatabase.Companion companion = SubtitleDownloadDatabase.INSTANCE;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            companion.b(a11).l0().g(dbBean);
        } else {
            SubtitleDownloadDatabase.Companion companion2 = SubtitleDownloadDatabase.INSTANCE;
            Application a12 = Utils.a();
            Intrinsics.g(a12, "getApp(...)");
            companion2.b(a12).l0().f(dbBean);
        }
        SubtitleDownloadManager.f55121a.o(e11, dbBean);
    }

    public abstract void i(Response response, SubtitleDownloadTable subtitleDownloadTable);

    public boolean j(Response response, String destination, long j11, SubtitleDownloadTable dbBean, Function1 progressCallback, Function0 completeCallback) {
        Intrinsics.h(response, "response");
        Intrinsics.h(destination, "destination");
        Intrinsics.h(dbBean, "dbBean");
        Intrinsics.h(progressCallback, "progressCallback");
        Intrinsics.h(completeCallback, "completeCallback");
        if (j11 <= 0 && !dbBean.isOpenSbNewApi()) {
            h(dbBean, new RuntimeException(l() + " --> disposeOutputStream --> length <= 0 --> length = " + j11));
            return false;
        }
        com.transsion.subtitle_download.utils.e eVar = com.transsion.subtitle_download.utils.e.f55170a;
        eVar.a(f55140b);
        eVar.a(f55141c);
        try {
            ResponseBody body = response.body();
            InputStream byteStream = body != null ? body.byteStream() : null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(destination);
                try {
                    byte[] bArr = new byte[102400];
                    dbBean.setStatus(2);
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        if (byteStream != null && (i11 = byteStream.read(bArr)) == -1) {
                            Unit unit = Unit.f67184a;
                            CloseableKt.a(fileOutputStream, null);
                            CloseableKt.a(byteStream, null);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, i11);
                        i12 += i11;
                        int i13 = (int) (((i12 * 1.0f) / ((float) j11)) * 100);
                        progressCallback.invoke(Integer.valueOf(i13));
                        if (i13 >= 100) {
                            completeCallback.invoke();
                        }
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
        } catch (Exception e11) {
            h(dbBean, new RuntimeException(l() + " --> disposeOutputStream --> 字幕下载出问题了,e = " + e11.getMessage()));
            return false;
        }
    }

    public final void k(SubtitleDownloadTable dbBean, Function0 callback) {
        Intrinsics.h(dbBean, "dbBean");
        Intrinsics.h(callback, "callback");
        com.transsion.subtitle_download.utils.b bVar = com.transsion.subtitle_download.utils.b.f55167a;
        bVar.a(l() + " --> download() --> 字幕下载 --> 开始执行下载任务了 --> getSubtitleInfo = " + dbBean.getSubtitleInfo());
        bVar.a("开始执行下载任务了 --> url = " + dbBean.getUrl());
        Request.Builder builder = new Request.Builder();
        String url = dbBean.getUrl();
        if (url == null) {
            url = "";
        }
        f55139a.b().newCall(builder.url(url).build()).enqueue(new C0698b(dbBean, callback));
    }

    public final String l() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }
}
