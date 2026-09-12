package com.vungle.ads.internal.downloader;

import com.vungle.ads.NoSpaceError;
import com.vungle.ads.OutOfMemory;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.downloader.AssetDownloader;
import com.vungle.ads.internal.downloader.a;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.task.PriorityRunnable;
import com.vungle.ads.internal.util.o;
import com.vungle.ads.internal.util.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.Okio;

/* loaded from: classes7.dex */
public final class AssetDownloader implements Downloader {
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final a Companion = new a(null);
    private static final int DOWNLOAD_CHUNK_SIZE = 2048;
    private static final String GZIP = "gzip";
    private static final int MINIMUM_SPACE_REQUIRED_MB = 20971520;
    private static final String TAG = "AssetDownloader";
    private final VungleThreadPoolExecutor downloadExecutor;
    private final Lazy okHttpClient$delegate;
    private final p pathProvider;
    private final List<DownloadRequest> transitioning;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b {
        public static final b INSTANCE = new b();
        private static OkHttpClient client;

        private b() {
        }

        public final OkHttpClient createOkHttpClient(p pathProvider) {
            Intrinsics.h(pathProvider, "pathProvider");
            OkHttpClient okHttpClient = client;
            if (okHttpClient != null) {
                return okHttpClient;
            }
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder followSslRedirects = builder.readTimeout(60L, timeUnit).connectTimeout(60L, timeUnit).cache(null).followRedirects(true).followSslRedirects(true);
            ConfigManager configManager = ConfigManager.INSTANCE;
            if (configManager.isCleverCacheEnabled()) {
                long cleverCacheDiskSize = configManager.getCleverCacheDiskSize();
                int cleverCacheDiskPercentage = configManager.getCleverCacheDiskPercentage();
                String absolutePath = pathProvider.getCleverCacheDir().getAbsolutePath();
                Intrinsics.g(absolutePath, "pathProvider.getCleverCacheDir().absolutePath");
                long min = Math.min(cleverCacheDiskSize, (pathProvider.getAvailableBytes(absolutePath) * cleverCacheDiskPercentage) / 100);
                if (min > 0) {
                    followSslRedirects.cache(new Cache(pathProvider.getCleverCacheDir(), min));
                } else {
                    o.Companion.w("OkHttpClientWrapper", "cache disk capacity size <=0, no clever cache active.");
                }
            }
            OkHttpClient build = followSslRedirects.build();
            client = build;
            return build;
        }
    }

    public AssetDownloader(VungleThreadPoolExecutor downloadExecutor, p pathProvider) {
        Intrinsics.h(downloadExecutor, "downloadExecutor");
        Intrinsics.h(pathProvider, "pathProvider");
        this.downloadExecutor = downloadExecutor;
        this.pathProvider = pathProvider;
        this.okHttpClient$delegate = LazyKt.b(new Function0<OkHttpClient>() { // from class: com.vungle.ads.internal.downloader.AssetDownloader$okHttpClient$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                p pVar;
                AssetDownloader.b bVar = AssetDownloader.b.INSTANCE;
                pVar = AssetDownloader.this.pathProvider;
                return bVar.createOkHttpClient(pVar);
            }
        });
        this.transitioning = new ArrayList();
    }

    private final boolean checkSpaceAvailable(DownloadRequest downloadRequest) {
        p pVar = this.pathProvider;
        String absolutePath = pVar.getVungleDir().getAbsolutePath();
        Intrinsics.g(absolutePath, "pathProvider.getVungleDir().absolutePath");
        long availableBytes = pVar.getAvailableBytes(absolutePath);
        if (availableBytes >= 20971520) {
            return true;
        }
        new NoSpaceError("Insufficient space " + availableBytes).setLogEntry$vungle_ads_release(downloadRequest.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
        return false;
    }

    private final ResponseBody decodeGzipIfNeeded(Response response) {
        ResponseBody body = response.body();
        if (!StringsKt.H(GZIP, Response.header$default(response, "Content-Encoding", null, 2, null), true) || body == null) {
            return body;
        }
        return new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null), -1L, Okio.buffer(new GzipSource(body.getSource())));
    }

    private final void deliverError(DownloadRequest downloadRequest, com.vungle.ads.internal.downloader.a aVar, a.C0726a c0726a) {
        if (aVar != null) {
            aVar.onError(c0726a, downloadRequest);
        }
    }

    private final void deliverSuccess(File file, DownloadRequest downloadRequest, com.vungle.ads.internal.downloader.a aVar) {
        o.Companion.d(TAG, "On success " + downloadRequest);
        if (aVar != null) {
            aVar.onSuccess(file, downloadRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: download$lambda-0, reason: not valid java name */
    public static final void m1044download$lambda0(DownloadRequest downloadRequest, AssetDownloader this$0, com.vungle.ads.internal.downloader.a aVar) {
        Intrinsics.h(this$0, "this$0");
        this$0.deliverError(downloadRequest, aVar, new a.C0726a(-1, new OutOfMemory("Failed to execute download request: " + downloadRequest.getAsset().getServerPath()), a.C0726a.b.Companion.getINTERNAL_ERROR()));
    }

    private final OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient$delegate.getValue();
    }

    private final boolean isValidUrl(String str) {
        return (str == null || str.length() == 0 || HttpUrl.INSTANCE.parse(str) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02d6, code lost:
    
        r1.flush();
        r0 = r6.getStatus();
        r2 = com.vungle.ads.internal.downloader.a.b.InterfaceC0730b.Companion;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02e3, code lost:
    
        if (r0 != r2.getIN_PROGRESS()) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02e5, code lost:
    
        r6.setStatus(r2.getDONE());
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02f0, code lost:
    
        if (r13.body() == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x02f2, code lost:
    
        r0 = r13.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x02f6, code lost:
    
        if (r0 == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02f8, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x02fb, code lost:
    
        if (r12 == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x02fd, code lost:
    
        r12.cancel();
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0300, code lost:
    
        r0 = com.vungle.ads.internal.util.g.INSTANCE;
        r0.closeQuietly(r1);
        r0.closeQuietly(r4);
        r0 = com.vungle.ads.internal.util.o.Companion;
        r0.d(com.vungle.ads.internal.downloader.AssetDownloader.TAG, "download status: " + r6.getStatus());
        r1 = r6.getStatus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0328, code lost:
    
        if (r1 != r2.getERROR()) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x032a, code lost:
    
        r3 = r24;
        r10 = r25;
        r11 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0338, code lost:
    
        r3.deliverError(r10, r11, r14);
        r2 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0364, code lost:
    
        r23 = r9;
        r9 = r3;
        r3 = r14;
        r14 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0335, code lost:
    
        if (r1 != r2.getSTARTED()) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x033e, code lost:
    
        r3 = r24;
        r10 = r25;
        r11 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0348, code lost:
    
        if (r1 != r2.getCANCELLED()) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x034a, code lost:
    
        r1 = new java.lang.StringBuilder();
        r2 = r20;
        r1.append(r2);
        r1.append(r10);
        r0.d(com.vungle.ads.internal.downloader.AssetDownloader.TAG, r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x035f, code lost:
    
        r2 = r20;
        r3.deliverSuccess(r9, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x02ad, code lost:
    
        new com.vungle.ads.AssetWriteError("Asset save error " + r8).setLogEntry$vungle_ads_release(r25.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x02d5, code lost:
    
        throw new com.vungle.ads.internal.downloader.Downloader.RequestException("File is not existing");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0499 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x04d7 A[Catch: all -> 0x04c5, TryCatch #16 {all -> 0x04c5, blocks: (B:108:0x049d, B:57:0x04f9, B:53:0x04d7, B:55:0x04dd, B:103:0x04e1), top: B:107:0x049d }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x05e6  */
    /* JADX WARN: Type inference failed for: r0v24, types: [com.vungle.ads.internal.util.g] */
    /* JADX WARN: Type inference failed for: r0v97, types: [com.vungle.ads.internal.util.g] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v36, types: [okio.BufferedSink, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void launchRequest(com.vungle.ads.internal.downloader.DownloadRequest r25, com.vungle.ads.internal.downloader.a r26) {
        /*
            Method dump skipped, instructions count: 1553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.downloader.AssetDownloader.launchRequest(com.vungle.ads.internal.downloader.DownloadRequest, com.vungle.ads.internal.downloader.a):void");
    }

    @Override // com.vungle.ads.internal.downloader.Downloader
    public void cancel(DownloadRequest downloadRequest) {
        if (downloadRequest == null || downloadRequest.isCancelled()) {
            return;
        }
        downloadRequest.cancel();
    }

    @Override // com.vungle.ads.internal.downloader.Downloader
    public void cancelAll() {
        Iterator<T> it = this.transitioning.iterator();
        while (it.hasNext()) {
            cancel((DownloadRequest) it.next());
        }
        this.transitioning.clear();
    }

    @Override // com.vungle.ads.internal.downloader.Downloader
    public void download(final DownloadRequest downloadRequest, final com.vungle.ads.internal.downloader.a aVar) {
        if (downloadRequest == null) {
            return;
        }
        this.transitioning.add(downloadRequest);
        this.downloadExecutor.execute(new PriorityRunnable() { // from class: com.vungle.ads.internal.downloader.AssetDownloader$download$1
            @Override // com.vungle.ads.internal.task.PriorityRunnable
            public int getPriority() {
                return downloadRequest.getPriority();
            }

            @Override // java.lang.Runnable
            public void run() {
                AssetDownloader.this.launchRequest(downloadRequest, aVar);
            }
        }, new Runnable() { // from class: com.vungle.ads.internal.downloader.b
            @Override // java.lang.Runnable
            public final void run() {
                AssetDownloader.m1044download$lambda0(DownloadRequest.this, this, aVar);
            }
        });
    }
}
