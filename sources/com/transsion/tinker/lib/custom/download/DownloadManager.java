package com.transsion.tinker.lib.custom.download;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.transsion.tinker.lib.custom.api.DownloadPolicy;
import com.transsion.tinker.lib.custom.download.DownloadManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import ou.d;

/* loaded from: classes6.dex */
public class DownloadManager {

    /* renamed from: a, reason: collision with root package name */
    private final Context f55201a;

    /* renamed from: c, reason: collision with root package name */
    private int f55203c;

    /* renamed from: d, reason: collision with root package name */
    private int f55204d;

    /* renamed from: h, reason: collision with root package name */
    private volatile Thread f55208h;

    /* renamed from: e, reason: collision with root package name */
    private int f55205e = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f55206f = -1;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f55207g = false;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f55202b = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public static final class NetworkPolicyException extends RuntimeException {
        public NetworkPolicyException(String str) {
            super(str);
        }
    }

    /* loaded from: classes6.dex */
    public interface a {
        void a(long j11, long j12);

        void b(Exception exc);

        void onSuccess(String str);
    }

    public DownloadManager(Context context) {
        this.f55203c = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        this.f55204d = 30000;
        this.f55201a = context.getApplicationContext();
        ou.a s11 = ou.a.s();
        this.f55203c = s11.z();
        this.f55204d = s11.A();
    }

    private void e(String str, File file, final a aVar) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        final long length;
        long contentLengthLong;
        long j11;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            length = file.exists() ? file.length() : 0L;
            if (length > 0) {
                long g11 = g(str);
                if (g11 > 0 && length >= g11) {
                    ShareTinkerLog.i("Tinker.DownloadManager", "local file already complete (%d bytes), skip download", Long.valueOf(length));
                    return;
                }
            }
            boolean z10 = length > 0;
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(this.f55203c);
                httpURLConnection.setReadTimeout(this.f55204d);
                if (z10) {
                    httpURLConnection.setRequestProperty("Range", "bytes=" + length + "-");
                    ShareTinkerLog.i("Tinker.DownloadManager", "resuming download from byte %d", Long.valueOf(length));
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    z10 = false;
                    length = 0;
                } else if (responseCode != 206) {
                    if (responseCode != 416) {
                        throw new RuntimeException("HTTP " + responseCode);
                    }
                    ShareTinkerLog.w("Tinker.DownloadManager", "HTTP 416: range offset %d exceeds server file size, deleting partial file", Long.valueOf(length));
                    if (file.exists() && !file.delete()) {
                        try {
                            new FileOutputStream(file).close();
                        } catch (Exception unused) {
                        }
                        ShareTinkerLog.w("Tinker.DownloadManager", "HTTP 416: delete failed, truncated file instead", new Object[0]);
                    }
                    throw new RuntimeException("HTTP " + responseCode);
                }
                contentLengthLong = httpURLConnection.getContentLengthLong();
                j11 = contentLengthLong > 0 ? contentLengthLong + length : -1L;
                inputStream = httpURLConnection.getInputStream();
                try {
                    fileOutputStream = new FileOutputStream(file, z10);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            httpURLConnection = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                    httpURLConnection.disconnect();
                    return;
                } else {
                    if (this.f55207g || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    length += read;
                    if (aVar != null && j11 > 0) {
                        final long j12 = j11;
                        this.f55202b.post(new Runnable() { // from class: ru.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                DownloadManager.a.this.a(length, j12);
                            }
                        });
                    }
                }
            }
            throw new InterruptedException("download_cancelled");
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused4) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused5) {
                }
            }
            if (httpURLConnection == null) {
                throw th;
            }
            httpURLConnection.disconnect();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long g(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L41
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L41
            java.net.URLConnection r7 = r1.openConnection()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L41
            java.lang.Object r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r7)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L41
            java.net.URLConnection r7 = (java.net.URLConnection) r7     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L41
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L41
            java.lang.String r0 = "HEAD"
            r7.setRequestMethod(r0)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            int r0 = r6.f55203c     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r7.setConnectTimeout(r0)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            int r0 = r6.f55204d     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r7.setReadTimeout(r0)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r7.connect()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            int r0 = r7.getResponseCode()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L38
            long r0 = uc.c.a(r7)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r7.disconnect()
            return r0
        L34:
            r0 = move-exception
            goto L5c
        L36:
            r0 = move-exception
            goto L45
        L38:
            r7.disconnect()
            goto L59
        L3c:
            r7 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L5c
        L41:
            r7 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L45:
            java.lang.String r1 = "Tinker.DownloadManager"
            java.lang.String r2 = "fetchContentLength failed: %s"
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L34
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L34
            r4 = 0
            r3[r4] = r0     // Catch: java.lang.Throwable -> L34
            com.tencent.tinker.loader.shareutil.ShareTinkerLog.w(r1, r2, r3)     // Catch: java.lang.Throwable -> L34
            if (r7 == 0) goto L59
            goto L38
        L59:
            r0 = -1
            return r0
        L5c:
            if (r7 == 0) goto L61
            r7.disconnect()
        L61:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.tinker.lib.custom.download.DownloadManager.g(java.lang.String):long");
    }

    private boolean h() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f55201a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getType() == 1;
        } catch (SecurityException unused) {
            ShareTinkerLog.w("Tinker.DownloadManager", "ACCESS_NETWORK_STATE not granted, skip wifi check", new Object[0]);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(int i11, a aVar, long j11, d dVar, File file) {
        int i12 = 0;
        Exception e11 = null;
        while (i12 <= i11) {
            try {
                if (this.f55207g) {
                    m(aVar, new InterruptedException("download_cancelled"));
                    return;
                }
                if (i12 > 0) {
                    long min = Math.min((1 << (i12 - 1)) * j11, ou.a.s().E());
                    ShareTinkerLog.w("Tinker.DownloadManager", "retry #%d in %dms", Integer.valueOf(i12), Long.valueOf(min));
                    Thread.sleep(min);
                }
                try {
                } catch (Exception e12) {
                    e11 = e12;
                }
                try {
                    e(dVar.c(), file, aVar);
                    n(aVar, file.getAbsolutePath());
                    return;
                } catch (Exception e13) {
                    e11 = e13;
                    i12++;
                    ShareTinkerLog.w("Tinker.DownloadManager", "download attempt %d/%d failed: %s", Integer.valueOf(i12), Integer.valueOf(i11 + 1), e11.getMessage());
                }
            } catch (InterruptedException unused) {
                m(aVar, new InterruptedException("download_cancelled"));
                return;
            } catch (InterruptedException unused2) {
                m(aVar, new InterruptedException("download_cancelled"));
                return;
            } finally {
                this.f55208h = null;
            }
        }
        if (e11 == null) {
            e11 = new RuntimeException("Unknown error");
        }
        m(aVar, e11);
    }

    private void m(final a aVar, final Exception exc) {
        if (aVar == null) {
            return;
        }
        this.f55202b.post(new Runnable() { // from class: ru.c
            @Override // java.lang.Runnable
            public final void run() {
                DownloadManager.a.this.b(exc);
            }
        });
    }

    private void n(final a aVar, final String str) {
        if (aVar == null) {
            return;
        }
        this.f55202b.post(new Runnable() { // from class: ru.d
            @Override // java.lang.Runnable
            public final void run() {
                DownloadManager.a.this.onSuccess(str);
            }
        });
    }

    public void f(final d dVar, File file, final a aVar) {
        int i11;
        long j11;
        if (dVar == null || dVar.c() == null || dVar.c().isEmpty()) {
            m(aVar, new IllegalArgumentException("PatchInfo or url is null"));
            return;
        }
        if (!dVar.c().toLowerCase().startsWith("https://")) {
            m(aVar, new SecurityException("Only HTTPS URLs are allowed: " + dVar.c()));
            return;
        }
        if (dVar.b() == DownloadPolicy.WIFI_ONLY && !h()) {
            m(aVar, new NetworkPolicyException("DownloadPolicy.WIFI_ONLY: current network is not Wi-Fi"));
            return;
        }
        this.f55207g = false;
        if (!file.exists() && !file.mkdirs()) {
            m(aVar, new IllegalStateException("Cannot create dir: " + file));
            return;
        }
        final File file2 = new File(file, "patch_" + dVar.f().replaceAll("[^a-zA-Z0-9._\\-]", "_") + ".apk");
        if (dVar.i() > 0 && file2.exists() && file2.length() == dVar.i()) {
            ShareTinkerLog.i("Tinker.DownloadManager", "local file already complete (size=%d), skip download", Long.valueOf(file2.length()));
            n(aVar, file2.getAbsolutePath());
            return;
        }
        ou.a s11 = ou.a.s();
        if (dVar.g() > 0) {
            i11 = dVar.g();
        } else {
            i11 = this.f55205e;
            if (i11 < 0) {
                i11 = s11.x();
            }
        }
        if (dVar.h() > 0) {
            j11 = dVar.h();
        } else {
            j11 = this.f55206f;
            if (j11 < 0) {
                j11 = s11.y();
            }
        }
        final long j12 = j11;
        final int i12 = i11;
        Thread thread = new Thread(new Runnable() { // from class: ru.a
            @Override // java.lang.Runnable
            public final void run() {
                DownloadManager.this.j(i12, aVar, j12, dVar, file2);
            }
        }, "tinker-download");
        this.f55208h = thread;
        thread.start();
    }
}
