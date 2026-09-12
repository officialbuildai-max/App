package com.cloud.h5update.utils;

import android.content.Context;
import android.os.Bundle;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.DownloadEntity;
import com.cloud.h5update.bean.PreloadResource;
import com.cloud.h5update.download.DownloadManager;
import com.cloud.h5update.download.DownloadTask;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f21374a = new a();

    /* renamed from: com.cloud.h5update.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0301a implements com.cloud.h5update.download.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PreloadResource f21375a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f21376b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f21377c;

        C0301a(PreloadResource preloadResource, Ref.ObjectRef objectRef, Context context) {
            this.f21375a = preloadResource;
            this.f21376b = objectRef;
            this.f21377c = context;
        }

        @Override // com.cloud.h5update.download.a
        public void a(DownloadTask downloadTask) {
            t6.b j11 = TH5Update.f21320c.j();
            if (j11 != null) {
                j11.onZipDownloadCancel(this.f21375a.getStaticZipUrl());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.cloud.h5update.download.a
        public void b(DownloadTask downloadTask) {
            t6.b j11 = TH5Update.f21320c.j();
            if (j11 != null) {
                j11.onDownloadProcess(this.f21375a.getStaticZipUrl(), ((DownloadEntity) this.f21376b.element).getCompletedSize(), ((DownloadEntity) this.f21376b.element).getTotalSize());
            }
        }

        @Override // com.cloud.h5update.download.a
        public void c(DownloadTask downloadTask) {
        }

        @Override // com.cloud.h5update.download.a
        public void d(DownloadTask downloadTask, int i11) {
            t6.b j11 = TH5Update.f21320c.j();
            if (j11 != null) {
                String staticZipUrl = this.f21375a.getStaticZipUrl();
                Intrinsics.e(staticZipUrl);
                j11.onError(staticZipUrl, 103, "ERROR_DOWNLOAD");
            }
        }

        @Override // com.cloud.h5update.download.a
        public void e(DownloadTask downloadTask) {
            new Bundle().putString("url", this.f21375a.getStaticZipUrl());
            TH5Update.a aVar = TH5Update.f21320c;
            t6.b j11 = aVar.j();
            if (j11 != null) {
                j11.onZipDownloadFinish(this.f21375a.getStaticZipUrl());
            }
            l.f21391a.n(this.f21377c, this.f21375a);
            aVar.i().put(this.f21375a.getStaticZipUrl(), Boolean.TRUE);
            aVar.a();
        }
    }

    private a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.cloud.h5update.bean.DownloadEntity] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, com.cloud.h5update.bean.DownloadEntity] */
    public final void a(Context context, PreloadResource preloadResource) {
        Intrinsics.h(context, "context");
        Intrinsics.h(preloadResource, "preloadResource");
        String staticZipUrl = preloadResource.getStaticZipUrl();
        if (staticZipUrl == null || StringsKt.q0(staticZipUrl)) {
            return;
        }
        l lVar = l.f21391a;
        String i11 = lVar.i(preloadResource);
        DownloadManager.a aVar = DownloadManager.f21350g;
        DownloadTask h11 = aVar.a().h(i11);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new DownloadEntity(preloadResource.getEncryptedStaticZip(), staticZipUrl);
        C0301a c0301a = new C0301a(preloadResource, objectRef, context);
        if (h11 == null) {
            ((DownloadEntity) objectRef.element).setTaskId(i11);
            DownloadTask downloadTask = new DownloadTask((DownloadEntity) objectRef.element);
            downloadTask.setListener(c0301a);
            t6.b j11 = TH5Update.f21320c.j();
            if (j11 != null) {
                j11.onZipDownloadStart(preloadResource.getStaticZipUrl());
            }
            new Bundle().putString("url", preloadResource.getStaticZipUrl());
            DownloadManager.c(aVar.a(), downloadTask, false, 2, null);
            return;
        }
        ?? downloadEntity = h11.getDownloadEntity();
        if (downloadEntity == 0) {
            return;
        }
        objectRef.element = downloadEntity;
        h11.setListener(c0301a);
        DownloadManager a11 = aVar.a();
        switch (downloadEntity.getTaskStatus()) {
            case 0:
                DownloadManager.c(a11, h11, false, 2, null);
                return;
            case 1:
                DownloadManager.c(a11, h11, false, 2, null);
                return;
            case 2:
                a11.m(h11);
                return;
            case 3:
                DownloadManager.c(a11, h11, false, 2, null);
                return;
            case 4:
                DownloadManager.c(a11, h11, false, 2, null);
                return;
            case 5:
                DownloadManager.c(a11, h11, false, 2, null);
                return;
            case 6:
                lVar.n(context, preloadResource);
                return;
            default:
                return;
        }
    }

    public final void b(String packageName, PreloadResource preloadResource) {
        Intrinsics.h(packageName, "packageName");
        Intrinsics.h(preloadResource, "preloadResource");
        String staticZipUrl = preloadResource.getStaticZipUrl();
        if (staticZipUrl == null || StringsKt.q0(staticZipUrl)) {
            return;
        }
        TH5Update.a aVar = TH5Update.f21320c;
        t6.b j11 = aVar.j();
        if (j11 != null) {
            String url = preloadResource.getUrl();
            if (url == null) {
                url = "";
            }
            if (!j11.onZipTryDownload(packageName, url, preloadResource.getStaticZipUrl())) {
                return;
            }
        }
        Context c11 = aVar.c();
        if (!StringsKt.W(staticZipUrl, "http://", false, 2, null) && !StringsKt.W(staticZipUrl, "https://", false, 2, null)) {
            gg.b.f63690a.c("error url :" + staticZipUrl);
            t6.b j12 = aVar.j();
            if (j12 != null) {
                String staticZipUrl2 = preloadResource.getStaticZipUrl();
                Intrinsics.e(staticZipUrl2);
                j12.onError(staticZipUrl2, 101, "ERROR_PARAMS");
                return;
            }
            return;
        }
        if (StringsKt.G(staticZipUrl, ".zip", false, 2, null)) {
            a(c11, preloadResource);
            return;
        }
        gg.b.f63690a.c("error url :" + staticZipUrl);
        t6.b j13 = aVar.j();
        if (j13 != null) {
            String staticZipUrl3 = preloadResource.getStaticZipUrl();
            Intrinsics.e(staticZipUrl3);
            j13.onError(staticZipUrl3, 101, "ERROR_PARAMS");
        }
    }
}
