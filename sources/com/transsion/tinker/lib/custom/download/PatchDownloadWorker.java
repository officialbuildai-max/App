package com.transsion.tinker.lib.custom.download;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.f;
import androidx.work.s;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.transsion.push.PushConstants;
import com.transsion.tinker.lib.custom.api.DownloadPolicy;
import com.transsion.tinker.lib.custom.api.PatchState;
import com.transsion.tinker.lib.custom.download.DownloadManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import nu.h;
import ou.d;

/* loaded from: classes6.dex */
public class PatchDownloadWorker extends Worker {

    /* loaded from: classes6.dex */
    class a implements DownloadManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f55209a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f55210b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicReference f55211c;

        a(AtomicBoolean atomicBoolean, CountDownLatch countDownLatch, AtomicReference atomicReference) {
            this.f55209a = atomicBoolean;
            this.f55210b = countDownLatch;
            this.f55211c = atomicReference;
        }

        @Override // com.transsion.tinker.lib.custom.download.DownloadManager.a
        public void a(long j11, long j12) {
        }

        @Override // com.transsion.tinker.lib.custom.download.DownloadManager.a
        public void b(Exception exc) {
            this.f55211c.set(exc);
            this.f55210b.countDown();
        }

        @Override // com.transsion.tinker.lib.custom.download.DownloadManager.a
        public void onSuccess(String str) {
            this.f55209a.set(true);
            this.f55210b.countDown();
        }
    }

    public PatchDownloadWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public s.a p() {
        f e11 = e();
        String g11 = e11.g("url");
        String g12 = e11.g("patch_id");
        if (g11 == null || g11.isEmpty() || g12 == null || g12.isEmpty()) {
            ShareTinkerLog.e("Tinker.DownloadWorker", "invalid input: url or patchId is empty", new Object[0]);
            return s.a.a();
        }
        Context a11 = a();
        PatchState e12 = yu.a.e(a11);
        if (g12.equals(yu.a.d(a11))) {
            if (e12 == PatchState.INSTALLED) {
                ShareTinkerLog.i("Tinker.DownloadWorker", "patch %s already installed, skip worker", g12);
                return s.a.c();
            }
            if (e12 == PatchState.READY) {
                ShareTinkerLog.i("Tinker.DownloadWorker", "patch %s in READY state, retry after TinkerPatchService", g12);
                return s.a.b();
            }
        }
        d.b bVar = new d.b(g11, g12);
        String g13 = e11.g("md5");
        if (g13 != null) {
            bVar.u(g13);
        }
        long f11 = e11.f("size", 0L);
        if (f11 > 0) {
            bVar.x(f11);
        }
        bVar.t(e11.c("mandatory", false));
        bVar.s(e11.f("expires_at", 0L));
        String g14 = e11.g("download_policy");
        if (g14 != null) {
            try {
                bVar.r(DownloadPolicy.valueOf(g14));
            } catch (IllegalArgumentException unused) {
                ShareTinkerLog.w("Tinker.DownloadWorker", "unknown DownloadPolicy='%s', fallback to default", g14);
            }
        }
        int d11 = e11.d(PushConstants.SP_KEY_RETRY_COUNT, 0);
        if (d11 > 0) {
            bVar.v(d11);
        }
        long f12 = e11.f("retry_delay_ms", 0L);
        if (f12 > 0) {
            bVar.w(f12);
        }
        d q11 = bVar.q();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AtomicReference atomicReference = new AtomicReference();
        h.q(a11, q11, new a(atomicBoolean, countDownLatch, atomicReference));
        try {
            countDownLatch.await();
            if (atomicBoolean.get()) {
                ShareTinkerLog.i("Tinker.DownloadWorker", "background download succeeded, patchId=%s", g12);
                return s.a.c();
            }
            Exception exc = (Exception) atomicReference.get();
            if (exc instanceof DownloadManager.NetworkPolicyException) {
                ShareTinkerLog.w("Tinker.DownloadWorker", "network policy rejected, will retry when wifi available", new Object[0]);
                return s.a.b();
            }
            if (yu.a.e(a11) == PatchState.DOWNLOADING) {
                ShareTinkerLog.w("Tinker.DownloadWorker", "another download in progress, retry later", new Object[0]);
                return s.a.b();
            }
            ShareTinkerLog.w("Tinker.DownloadWorker", "background download failed: %s", exc != null ? exc.getMessage() : TmcConstants.ROUTE_UNKNOWN);
            return s.a.a();
        } catch (InterruptedException unused2) {
            Thread.currentThread().interrupt();
            return s.a.b();
        }
    }
}
