package com.transsion.transfer.impl.client;

import com.transsion.transfer.androidasync.http.AsyncHttpClient;
import com.transsion.transfer.impl.entity.FileData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class n {

    /* renamed from: i, reason: collision with root package name */
    public static final a f55835i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final AsyncHttpClient f55836a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55837b;

    /* renamed from: c, reason: collision with root package name */
    private final String f55838c;

    /* renamed from: d, reason: collision with root package name */
    private final String f55839d;

    /* renamed from: e, reason: collision with root package name */
    private final com.transsion.transfer.impl.f f55840e;

    /* renamed from: f, reason: collision with root package name */
    private final List f55841f;

    /* renamed from: g, reason: collision with root package name */
    private final List f55842g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f55843h;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends AsyncHttpClient.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f55845b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ File f55846c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FileData f55847d;

        b(File file, File file2, FileData fileData) {
            this.f55845b = file;
            this.f55846c = file2;
            this.f55847d = fileData;
        }

        @Override // com.transsion.transfer.androidasync.http.AsyncHttpClient.i, dv.b
        public void a(com.transsion.transfer.androidasync.http.k kVar, long j11, long j12) {
            super.a(kVar, j11, j12);
        }

        @Override // com.transsion.transfer.androidasync.http.AsyncHttpClient.i, dv.b
        public void b(com.transsion.transfer.androidasync.http.k kVar) {
        }

        @Override // bv.g
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(Exception exc, com.transsion.transfer.androidasync.http.k kVar, File file) {
            Boolean valueOf = file != null ? Boolean.valueOf(file.exists()) : null;
            Long valueOf2 = file != null ? Long.valueOf(file.length()) : null;
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCompleted: exist:");
            sb2.append(valueOf);
            sb2.append(" , length:");
            sb2.append(valueOf2);
            sb2.append(" , e:");
            sb2.append(message);
            n.this.f55843h = false;
            if (exc == null) {
                this.f55845b.renameTo(this.f55846c);
                n.this.f55840e.o(this.f55847d.getFileRemotePath());
            }
            n.this.f55842g.remove(this.f55847d);
            n.this.f();
        }
    }

    public n(AsyncHttpClient httpClient, String clientIp, String transferId, String urlPath, com.transsion.transfer.impl.f listener) {
        Intrinsics.h(httpClient, "httpClient");
        Intrinsics.h(clientIp, "clientIp");
        Intrinsics.h(transferId, "transferId");
        Intrinsics.h(urlPath, "urlPath");
        Intrinsics.h(listener, "listener");
        this.f55836a = httpClient;
        this.f55837b = clientIp;
        this.f55838c = transferId;
        this.f55839d = urlPath;
        this.f55840e = listener;
        this.f55841f = new ArrayList();
        this.f55842g = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        Object m1185constructorimpl;
        if (this.f55842g.isEmpty() && !this.f55841f.isEmpty()) {
            this.f55842g.add(this.f55841f.remove(0));
        }
        if (this.f55842g.isEmpty() || this.f55843h) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            g((FileData) this.f55842g.get(0));
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Result.m1184boximpl(m1185constructorimpl);
    }

    private final void g(FileData fileData) {
        File tempCoverFile = fileData.getTempCoverFile();
        File coverFile = fileData.getCoverFile();
        if (!StringsKt.W(fileData.getCoverUrl(), "/", false, 2, null) || coverFile.exists()) {
            this.f55840e.o(fileData.getFileRemotePath());
            this.f55842g.remove(fileData);
            f();
            return;
        }
        this.f55843h = true;
        String coverUrl = fileData.getCoverUrl();
        String absolutePath = tempCoverFile.getAbsolutePath();
        this.f55836a.t(TransferClient.f55788t.c(this.f55839d + "/client/fetchFile?file=" + jv.a.b(coverUrl), this.f55837b, this.f55838c), absolutePath, new b(tempCoverFile, coverFile, fileData));
    }

    public final synchronized void e(List files) {
        Intrinsics.h(files, "files");
        this.f55841f.addAll(files);
        f();
    }
}
