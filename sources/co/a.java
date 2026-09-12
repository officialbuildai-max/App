package co;

import android.content.Context;
import androidx.media3.datasource.a;
import androidx.media3.datasource.b;
import androidx.media3.datasource.c;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.datasource.cache.a;
import androidx.media3.datasource.cache.q;
import androidx.media3.datasource.cronet.CronetDataSource;
import androidx.media3.datasource.cronet.CronetUtil;
import androidx.media3.exoplayer.b4;
import androidx.media3.exoplayer.offline.DownloadManager;
import com.transsion.player.exo.ORExoDecoderType;
import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.Executors;
import org.chromium.net.CronetEngine;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static a.InterfaceC0099a f17621a;

    /* renamed from: b, reason: collision with root package name */
    private static a.InterfaceC0099a f17622b;

    /* renamed from: c, reason: collision with root package name */
    private static v1.a f17623c;

    /* renamed from: d, reason: collision with root package name */
    private static File f17624d;

    /* renamed from: e, reason: collision with root package name */
    private static Cache f17625e;

    /* renamed from: f, reason: collision with root package name */
    private static DownloadManager f17626f;

    /* renamed from: g, reason: collision with root package name */
    private static androidx.media3.exoplayer.offline.k f17627g;

    /* renamed from: co.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class C0177a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17628a;

        static {
            int[] iArr = new int[ORExoDecoderType.values().length];
            f17628a = iArr;
            try {
                iArr[ORExoDecoderType.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17628a[ORExoDecoderType.FFMPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17628a[ORExoDecoderType.AV1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static a.c a(a.InterfaceC0099a interfaceC0099a, Cache cache) {
        return new a.c().i(cache).j(interfaceC0099a);
    }

    public static b4 b(Context context, ORExoDecoderType oRExoDecoderType) {
        int i11;
        int i12 = C0177a.f17628a[oRExoDecoderType.ordinal()];
        if (i12 != 1) {
            i11 = 2;
            if (i12 != 2 && i12 != 3) {
                throw new IncompatibleClassChangeError();
            }
        } else {
            i11 = 1;
        }
        return new j(context.getApplicationContext(), oRExoDecoderType).o(true).p(i11).l();
    }

    private static synchronized void c(Context context) {
        synchronized (a.class) {
            if (f17626f == null) {
                DownloadManager downloadManager = new DownloadManager(context, new androidx.media3.exoplayer.offline.a(e(context)), new com.transsion.player.shorttv.preload.b(new a.c().i(f(context)).j(j(context)), Executors.newFixedThreadPool(6)));
                f17626f = downloadManager;
                downloadManager.u();
            }
        }
    }

    public static synchronized a.InterfaceC0099a d(Context context) {
        a.InterfaceC0099a interfaceC0099a;
        synchronized (a.class) {
            try {
                if (f17621a == null) {
                    Context applicationContext = context.getApplicationContext();
                    f17621a = a(new b.a(applicationContext, j(applicationContext)), f(applicationContext));
                }
                interfaceC0099a = f17621a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC0099a;
    }

    private static synchronized v1.a e(Context context) {
        v1.a aVar;
        synchronized (a.class) {
            try {
                if (f17623c == null) {
                    f17623c = new v1.b(context);
                }
                aVar = f17623c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public static synchronized Cache f(Context context) {
        Cache cache;
        synchronized (a.class) {
            try {
                if (f17625e == null) {
                    f17625e = new SimpleCache(new File(g(context), "downloads"), new q(314572800L), e(context));
                }
                cache = f17625e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cache;
    }

    private static synchronized File g(Context context) {
        File file;
        synchronized (a.class) {
            try {
                if (f17624d == null) {
                    File externalFilesDir = context.getExternalFilesDir(null);
                    f17624d = externalFilesDir;
                    if (externalFilesDir == null) {
                        f17624d = context.getFilesDir();
                    }
                }
                file = f17624d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return file;
    }

    public static synchronized DownloadManager h(Context context) {
        DownloadManager downloadManager;
        synchronized (a.class) {
            c(context);
            downloadManager = f17626f;
        }
        return downloadManager;
    }

    public static synchronized androidx.media3.exoplayer.offline.k i(Context context) {
        androidx.media3.exoplayer.offline.k kVar;
        synchronized (a.class) {
            try {
                if (f17627g == null) {
                    f17627g = new androidx.media3.exoplayer.offline.k(context, "download_channel");
                }
                kVar = f17627g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return kVar;
    }

    public static synchronized a.InterfaceC0099a j(Context context) {
        a.InterfaceC0099a interfaceC0099a;
        synchronized (a.class) {
            try {
                if (f17622b == null) {
                    CronetEngine a11 = CronetUtil.a(context.getApplicationContext());
                    if (a11 != null) {
                        f17622b = new CronetDataSource.b(a11, Executors.newSingleThreadExecutor());
                    }
                    if (f17622b == null) {
                        CookieManager cookieManager = new CookieManager();
                        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
                        CookieHandler.setDefault(cookieManager);
                        f17622b = new c.b();
                    }
                }
                interfaceC0099a = f17622b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC0099a;
    }
}
