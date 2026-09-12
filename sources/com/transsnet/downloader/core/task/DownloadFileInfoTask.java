package com.transsnet.downloader.core.task;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes7.dex */
public final class DownloadFileInfoTask {
    private final void c(DownloadBean downloadBean, long j11) {
        if (j11 <= 0) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.c("download", "-------try_update_download_size, net size = " + downloadBean.getSize() + ", real size = " + j11, true);
        Long size = downloadBean.getSize();
        if (size != null && size.longValue() == j11) {
            return;
        }
        c0856a.c("download", "-------update_download_size, net size = " + downloadBean.getSize() + ", real size = " + j11, true);
        downloadBean.setSize(Long.valueOf(j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.transsion.baselib.db.download.DownloadBean r13, com.transsnet.downloader.core.task.a r14, kotlin.coroutines.Continuation r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.transsnet.downloader.core.task.DownloadFileInfoTask$checkWithOkhttp$1
            if (r0 == 0) goto L13
            r0 = r15
            com.transsnet.downloader.core.task.DownloadFileInfoTask$checkWithOkhttp$1 r0 = (com.transsnet.downloader.core.task.DownloadFileInfoTask$checkWithOkhttp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.core.task.DownloadFileInfoTask$checkWithOkhttp$1 r0 = new com.transsnet.downloader.core.task.DownloadFileInfoTask$checkWithOkhttp$1
            r0.<init>(r12, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L3c
            if (r2 == r3) goto L33
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L33:
            java.lang.Object r13 = r0.L$0
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            kotlin.ResultKt.b(r15)
            goto Ld9
        L3c:
            kotlin.ResultKt.b(r15)
            goto Lc5
        L41:
            kotlin.ResultKt.b(r15)
            r6 = 0
            r15 = 0
            r2 = 0
            com.transsnet.downloader.core.b$a r8 = com.transsnet.downloader.core.b.f58736c     // Catch: java.lang.Throwable -> L89
            com.transsnet.downloader.core.b r8 = r8.a()     // Catch: java.lang.Throwable -> L89
            okhttp3.OkHttpClient r8 = r8.c()     // Catch: java.lang.Throwable -> L89
            okhttp3.Request$Builder r9 = new okhttp3.Request$Builder     // Catch: java.lang.Throwable -> L89
            r9.<init>()     // Catch: java.lang.Throwable -> L89
            java.lang.String r10 = r13.getUrl()     // Catch: java.lang.Throwable -> L89
            r9.url(r10)     // Catch: java.lang.Throwable -> L89
            java.lang.String r10 = "Range"
            java.lang.String r11 = "bytes=0-"
            r9.addHeader(r10, r11)     // Catch: java.lang.Throwable -> L89
            okhttp3.Request r9 = r9.build()     // Catch: java.lang.Throwable -> L89
            okhttp3.Call r2 = r8.newCall(r9)     // Catch: java.lang.Throwable -> L89
            okhttp3.Response r8 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r2)     // Catch: java.lang.Throwable -> L89
            int r9 = r8.code()     // Catch: java.lang.Throwable -> L89
            r10 = 200(0xc8, float:2.8E-43)
            if (r9 == r10) goto L7e
            r10 = 206(0xce, float:2.89E-43)
            if (r9 == r10) goto L7e
            goto L91
        L7e:
            okhttp3.ResponseBody r8 = r8.body()     // Catch: java.lang.Throwable -> L89
            if (r8 == 0) goto L8b
            long r8 = r8.getContentLength()     // Catch: java.lang.Throwable -> L89
            goto L8c
        L89:
            r13 = move-exception
            goto L9f
        L8b:
            r8 = r6
        L8c:
            r12.c(r13, r8)     // Catch: java.lang.Throwable -> L89
            r15 = r5
            r6 = r8
        L91:
            if (r2 == 0) goto L96
            r2.cancel()
        L96:
            r0.label = r5
            java.lang.Object r13 = r14.a(r15, r6, r0)
            if (r13 != r1) goto Lc5
            return r1
        L9f:
            lg.a$a r8 = lg.a.f68962a     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r9 = "download"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc8
            r10.<init>()     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r11 = "DownloadFileInfoTask --> checkWithOkhttp --> e = "
            r10.append(r11)     // Catch: java.lang.Throwable -> Lc8
            r10.append(r13)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r13 = r10.toString()     // Catch: java.lang.Throwable -> Lc8
            r8.i(r9, r13, r5)     // Catch: java.lang.Throwable -> Lc8
            if (r2 == 0) goto Lbc
            r2.cancel()
        Lbc:
            r0.label = r4
            java.lang.Object r13 = r14.a(r15, r6, r0)
            if (r13 != r1) goto Lc5
            return r1
        Lc5:
            kotlin.Unit r13 = kotlin.Unit.f67184a
            return r13
        Lc8:
            r13 = move-exception
            if (r2 == 0) goto Lce
            r2.cancel()
        Lce:
            r0.L$0 = r13
            r0.label = r3
            java.lang.Object r14 = r14.a(r15, r6, r0)
            if (r14 != r1) goto Ld9
            return r1
        Ld9:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.task.DownloadFileInfoTask.d(com.transsion.baselib.db.download.DownloadBean, com.transsnet.downloader.core.task.a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void b(DownloadBean bean, a callback) {
        Intrinsics.h(bean, "bean");
        Intrinsics.h(callback, "callback");
        k.d(o0.a(y0.b()), null, null, new DownloadFileInfoTask$checkFileInfo$1(this, bean, callback, null), 3, null);
    }
}
