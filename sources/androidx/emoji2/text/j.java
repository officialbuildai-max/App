package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import androidx.core.provider.k;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.j;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class j extends EmojiCompat.c {

    /* renamed from: k, reason: collision with root package name */
    private static final a f9194k = new a();

    /* loaded from: classes.dex */
    public static class a {
        public Typeface a(Context context, k.b bVar) {
            return androidx.core.provider.k.a(context, null, new k.b[]{bVar});
        }

        public k.a b(Context context, androidx.core.provider.e eVar) {
            return androidx.core.provider.k.b(context, null, eVar);
        }

        public void c(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void d(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements EmojiCompat.g {

        /* renamed from: a, reason: collision with root package name */
        private final Context f9195a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.provider.e f9196b;

        /* renamed from: c, reason: collision with root package name */
        private final a f9197c;

        /* renamed from: d, reason: collision with root package name */
        private final Object f9198d = new Object();

        /* renamed from: e, reason: collision with root package name */
        private Handler f9199e;

        /* renamed from: f, reason: collision with root package name */
        private Executor f9200f;

        /* renamed from: g, reason: collision with root package name */
        private ThreadPoolExecutor f9201g;

        /* renamed from: h, reason: collision with root package name */
        private c f9202h;

        /* renamed from: i, reason: collision with root package name */
        EmojiCompat.h f9203i;

        /* renamed from: j, reason: collision with root package name */
        private ContentObserver f9204j;

        /* renamed from: k, reason: collision with root package name */
        private Runnable f9205k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ContentObserver {
            a(Handler handler) {
                super(handler);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z10, Uri uri) {
                b.this.d();
            }
        }

        b(Context context, androidx.core.provider.e eVar, a aVar) {
            androidx.core.util.i.h(context, "Context cannot be null");
            androidx.core.util.i.h(eVar, "FontRequest cannot be null");
            this.f9195a = context.getApplicationContext();
            this.f9196b = eVar;
            this.f9197c = aVar;
        }

        private void b() {
            synchronized (this.f9198d) {
                try {
                    this.f9203i = null;
                    ContentObserver contentObserver = this.f9204j;
                    if (contentObserver != null) {
                        this.f9197c.d(this.f9195a, contentObserver);
                        this.f9204j = null;
                    }
                    Handler handler = this.f9199e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f9205k);
                    }
                    this.f9199e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f9201g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f9200f = null;
                    this.f9201g = null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        private k.b e() {
            try {
                k.a b11 = this.f9197c.b(this.f9195a, this.f9196b);
                if (b11.e() == 0) {
                    k.b[] c11 = b11.c();
                    if (c11 == null || c11.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return c11[0];
                }
                throw new RuntimeException("fetchFonts failed (" + b11.e() + ")");
            } catch (PackageManager.NameNotFoundException e11) {
                throw new RuntimeException("provider not found", e11);
            }
        }

        private void f(Uri uri, long j11) {
            synchronized (this.f9198d) {
                try {
                    Handler handler = this.f9199e;
                    if (handler == null) {
                        handler = androidx.emoji2.text.c.d();
                        this.f9199e = handler;
                    }
                    if (this.f9204j == null) {
                        a aVar = new a(handler);
                        this.f9204j = aVar;
                        this.f9197c.c(this.f9195a, uri, aVar);
                    }
                    if (this.f9205k == null) {
                        this.f9205k = new Runnable() { // from class: androidx.emoji2.text.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                j.b.this.d();
                            }
                        };
                    }
                    handler.postDelayed(this.f9205k, j11);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.g
        public void a(EmojiCompat.h hVar) {
            androidx.core.util.i.h(hVar, "LoaderCallback cannot be null");
            synchronized (this.f9198d) {
                this.f9203i = hVar;
            }
            d();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            synchronized (this.f9198d) {
                try {
                    if (this.f9203i == null) {
                        return;
                    }
                    try {
                        k.b e11 = e();
                        int b11 = e11.b();
                        if (b11 == 2) {
                            synchronized (this.f9198d) {
                                try {
                                    c cVar = this.f9202h;
                                    if (cVar != null) {
                                        long a11 = cVar.a();
                                        if (a11 >= 0) {
                                            f(e11.d(), a11);
                                            return;
                                        }
                                    }
                                } finally {
                                }
                            }
                        }
                        if (b11 != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + b11 + ")");
                        }
                        try {
                            androidx.core.os.s.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface a12 = this.f9197c.a(this.f9195a, e11);
                            ByteBuffer f11 = z0.p.f(this.f9195a, null, e11.d());
                            if (f11 == null || a12 == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            n b12 = n.b(a12, f11);
                            androidx.core.os.s.b();
                            synchronized (this.f9198d) {
                                try {
                                    EmojiCompat.h hVar = this.f9203i;
                                    if (hVar != null) {
                                        hVar.b(b12);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th2) {
                            androidx.core.os.s.b();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        synchronized (this.f9198d) {
                            try {
                                EmojiCompat.h hVar2 = this.f9203i;
                                if (hVar2 != null) {
                                    hVar2.a(th3);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d() {
            synchronized (this.f9198d) {
                try {
                    if (this.f9203i == null) {
                        return;
                    }
                    if (this.f9200f == null) {
                        ThreadPoolExecutor b11 = androidx.emoji2.text.c.b("emojiCompat");
                        this.f9201g = b11;
                        this.f9200f = b11;
                    }
                    this.f9200f.execute(new Runnable() { // from class: androidx.emoji2.text.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.b.this.c();
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void g(Executor executor) {
            synchronized (this.f9198d) {
                this.f9200f = executor;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract long a();
    }

    public j(Context context, androidx.core.provider.e eVar) {
        super(new b(context, eVar, f9194k));
    }

    public j c(Executor executor) {
        ((b) a()).g(executor);
        return this;
    }
}
