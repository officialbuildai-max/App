package com.mbridge.msdk.foundation.same.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.o0;
import java.io.File;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f35454a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f35455b;

    /* renamed from: c, reason: collision with root package name */
    private final String f35456c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f35457a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.foundation.same.image.c f35458b;

        /* renamed from: com.mbridge.msdk.foundation.same.image.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0488a implements Runnable {
            RunnableC0488a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.f35458b.onFailedLoad("create download request error", aVar.f35457a);
            }
        }

        a(String str, g gVar, com.mbridge.msdk.foundation.same.image.c cVar) {
            this.f35457a = str;
            this.f35458b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadRequest a11 = d.this.a(m0.d(this.f35457a), this.f35457a, null, this.f35458b);
            if (a11 != null) {
                a11.start();
                return;
            }
            if (MBridgeConstans.DEBUG) {
                o0.b("CommonImageLoaderRefactor", "createDownloadRequest error");
            }
            if (this.f35458b == null) {
                return;
            }
            d.this.f35455b.post(new RunnableC0488a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f35461a = new d(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c implements OnDownloadStateListener<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f35462a;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f35463b;

        /* renamed from: c, reason: collision with root package name */
        private final String f35464c;

        /* renamed from: d, reason: collision with root package name */
        private final String f35465d;

        /* renamed from: e, reason: collision with root package name */
        private final String f35466e;

        /* renamed from: f, reason: collision with root package name */
        private final com.mbridge.msdk.foundation.same.image.c f35467f;

        /* loaded from: classes5.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f35469a;

            b(String str) {
                this.f35469a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.f35467f.onFailedLoad(c.this.f35466e, this.f35469a);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("CommonImageLoaderRefactor", "callbackForFailed error", e11);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mbridge.msdk.foundation.same.image.d$c$c, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0489c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f35471a;

            RunnableC0489c(Bitmap bitmap) {
                this.f35471a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.f35467f.onSuccessLoad(this.f35471a, c.this.f35466e);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("CommonImageLoaderRefactor", "callbackForSuccess error", e11);
                    }
                }
            }
        }

        public c(Handler handler, ThreadPoolExecutor threadPoolExecutor, String str, String str2, String str3, g gVar, com.mbridge.msdk.foundation.same.image.c cVar) {
            this.f35463b = handler;
            this.f35462a = threadPoolExecutor;
            this.f35466e = str;
            this.f35464c = str2;
            this.f35465d = str3;
            this.f35467f = cVar;
        }

        private Bitmap a(Bitmap bitmap, g gVar) {
            if (gVar == null) {
                return bitmap;
            }
            try {
                return gVar.a(bitmap);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CommonImageLoaderRefactor", "handlerImageTransformation error", e11);
                }
                return bitmap;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.f35467f == null) {
                return;
            }
            try {
                Bitmap b11 = d.b(this.f35464c + this.f35465d);
                if (b11 == null) {
                    a("bitmap decode failed");
                    return;
                }
                Bitmap a11 = a(b11, null);
                if (a11 == null) {
                    a("bitmap transformation failed");
                } else {
                    a(a11);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.a("CommonImageLoaderRefactor", "onDownloadComplete decodeBitmap error = " + e11.getLocalizedMessage());
                }
                a("bitmap decode failed");
            }
        }

        private void a(Bitmap bitmap) {
            if (this.f35467f == null) {
                return;
            }
            this.f35463b.post(new RunnableC0489c(bitmap));
        }

        private void a(String str) {
            if (this.f35467f == null) {
                return;
            }
            this.f35463b.post(new b(str));
        }

        private void b() {
            File file;
            if (MBridgeConstans.DEBUG) {
                o0.a("CommonImageLoaderRefactor", "onDownloadComplete imageUrl = " + this.f35466e + " imagePath = " + this.f35464c + this.f35465d);
                try {
                    file = new File(this.f35464c + this.f35465d);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("CommonImageLoaderRefactor", "onDownloadComplete error", e11);
                    }
                    file = null;
                }
                if (file == null || !file.isFile() || !file.exists()) {
                    o0.b("CommonImageLoaderRefactor", "onDownloadComplete file not exist");
                    return;
                }
                o0.a("CommonImageLoaderRefactor", "onDownloadComplete file size = " + file.length());
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onCancelDownload(DownloadMessage<Object> downloadMessage) {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadComplete(DownloadMessage<Object> downloadMessage) {
            b();
            this.f35462a.execute(new a());
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadError(DownloadMessage<Object> downloadMessage, DownloadError downloadError) {
            if (MBridgeConstans.DEBUG) {
                o0.a("CommonImageLoaderRefactor", "onDownloadError imageUrl = " + downloadError.getException().getLocalizedMessage());
            }
            a(downloadError.getException().getLocalizedMessage());
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadStart(DownloadMessage<Object> downloadMessage) {
        }
    }

    private d() {
        this.f35455b = new Handler(Looper.getMainLooper());
        this.f35456c = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_IMG) + File.separator;
        this.f35454a = f.b();
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadRequest<?> a(String str, String str2, g gVar, com.mbridge.msdk.foundation.same.image.c cVar) {
        try {
            return MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str2, str, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_IMAGE)).withReadTimeout(com.mbridge.msdk.foundation.same.a.f35403u).withConnectTimeout(com.mbridge.msdk.foundation.same.a.f35402t).withWriteTimeout(com.mbridge.msdk.foundation.same.a.f35401s).withDownloadPriority(DownloadPriority.LOW).withHttpRetryCounter(1).withDirectoryPathInternal(this.f35456c).withDownloadStateListener(new c(this.f35455b, this.f35454a, str2, this.f35456c, str, gVar, cVar)).with("download_scene", "download_image").withProgressStateListener(null).withTimeout(60000L).with("do_us_fi_re", Boolean.FALSE.toString()).build();
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            o0.b("CommonImageLoaderRefactor", "createDownloadRequest error", e11);
            return null;
        }
    }

    public static d a() {
        return b.f35461a;
    }

    private Runnable a(String str, g gVar, com.mbridge.msdk.foundation.same.image.c cVar) {
        return new a(str, gVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap b(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inDither = true;
        return BitmapFactory.decodeFile(str, options);
    }

    public void b(String str, g gVar, com.mbridge.msdk.foundation.same.image.c cVar) {
        try {
            this.f35454a.execute(a(str, gVar, cVar));
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CommonImageLoaderRefactor", "loadImage error", e11);
            }
        }
    }

    public Bitmap c(String str) {
        if (MBridgeConstans.DEBUG) {
            o0.a("CommonImageLoaderRefactor", "getImageBitmapByUrl imageUrl = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f35456c + m0.d(str);
        File file = new File(str2);
        if (file.isFile() && file.exists()) {
            try {
                return b(str2);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CommonImageLoaderRefactor", "getImageBitmapByUrl error", e11);
                }
            }
        }
        return null;
    }

    public boolean d(String str) {
        File file;
        if (MBridgeConstans.DEBUG) {
            o0.a("CommonImageLoaderRefactor", "isImageFileExists imageUrl = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                file = new File(this.f35456c + m0.d(str));
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CommonImageLoaderRefactor", "isImageFileExists error", e11);
                }
                file = null;
            }
            if (file == null || !file.isFile()) {
                return false;
            }
            return file.exists();
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CommonImageLoaderRefactor", "isImageFileExists error", e12);
            }
            return false;
        }
    }
}
