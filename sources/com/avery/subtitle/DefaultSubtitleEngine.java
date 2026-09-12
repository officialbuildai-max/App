package com.avery.subtitle;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.avery.subtitle.SubtitleLoader;
import com.avery.subtitle.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import k5.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes2.dex */
public final class DefaultSubtitleEngine implements com.avery.subtitle.b {

    /* renamed from: o, reason: collision with root package name */
    public static final a f19939o = new a(null);

    /* renamed from: p, reason: collision with root package name */
    private static final String f19940p = DefaultSubtitleEngine.class.getSimpleName();

    /* renamed from: q, reason: collision with root package name */
    private static final long f19941q = TimeUnit.MINUTES.toMillis(2);

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f19942a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f19943b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f19944c;

    /* renamed from: e, reason: collision with root package name */
    private i5.a f19946e;

    /* renamed from: f, reason: collision with root package name */
    private b.InterfaceC0190b f19947f;

    /* renamed from: g, reason: collision with root package name */
    private b.a f19948g;

    /* renamed from: h, reason: collision with root package name */
    private String f19949h;

    /* renamed from: i, reason: collision with root package name */
    private long f19950i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f19951j;

    /* renamed from: n, reason: collision with root package name */
    private long f19955n;

    /* renamed from: d, reason: collision with root package name */
    private final Map f19945d = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private n0 f19952k = o0.a(y0.c());

    /* renamed from: l, reason: collision with root package name */
    private n0 f19953l = o0.a(y0.b());

    /* renamed from: m, reason: collision with root package name */
    private final Lazy f19954m = LazyKt.b(new Function0<l5.a>() { // from class: com.avery.subtitle.DefaultSubtitleEngine$subtitleCacheManager$2
        @Override // kotlin.jvm.functions.Function0
        public final l5.a invoke() {
            return new l5.a();
        }
    });

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements SubtitleLoader.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19957b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19958c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f19959d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f19960e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i5.b f19961f;

        b(String str, String str2, String str3, boolean z10, i5.b bVar) {
            this.f19957b = str;
            this.f19958c = str2;
            this.f19959d = str3;
            this.f19960e = z10;
            this.f19961f = bVar;
        }

        @Override // com.avery.subtitle.SubtitleLoader.a
        public void a(Exception exc) {
            DefaultSubtitleEngine.this.i().k(this.f19957b, null);
            String str = DefaultSubtitleEngine.f19940p;
            Intrinsics.e(exc);
            Log.e(str, "onError: " + exc.getMessage());
            i5.b bVar = this.f19961f;
            if (bVar != null) {
                bVar.a(false);
            }
        }

        @Override // com.avery.subtitle.SubtitleLoader.a
        public void b(d dVar) {
            l5.a i11 = DefaultSubtitleEngine.this.i();
            String str = this.f19957b;
            Intrinsics.e(dVar);
            i11.k(str, dVar);
            DefaultSubtitleEngine.this.i().i(this.f19957b);
            DefaultSubtitleEngine.this.j(this.f19958c, this.f19959d, this.f19960e, this.f19961f, dVar);
        }
    }

    private final void e() {
        if (this.f19945d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f19955n < 2000) {
            return;
        }
        this.f19955n = currentTimeMillis;
        this.f19945d.put(this.f19949h, Long.valueOf(currentTimeMillis));
        Iterator it = this.f19945d.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            long longValue = ((Number) entry.getValue()).longValue();
            if (!TextUtils.equals(str, this.f19949h) && currentTimeMillis - longValue > f19941q) {
                Log.v(f19940p, "-----------------------timeout remove~ md5 = " + str + ", setTime = " + longValue + ", cur = " + currentTimeMillis);
                it.remove();
                l5.a i11 = i();
                Intrinsics.e(str);
                i11.j(str);
            }
        }
    }

    private final void f() {
        HandlerThread handlerThread = new HandlerThread("SubtitleFindThread");
        this.f19942a = handlerThread;
        Intrinsics.e(handlerThread);
        handlerThread.start();
        HandlerThread handlerThread2 = this.f19942a;
        Intrinsics.e(handlerThread2);
        this.f19943b = new Handler(handlerThread2.getLooper(), new Handler.Callback() { // from class: com.avery.subtitle.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean g11;
                g11 = DefaultSubtitleEngine.g(DefaultSubtitleEngine.this, message);
                return g11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071 A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #0 {all -> 0x0019, blocks: (B:6:0x0010, B:8:0x0014, B:11:0x0025, B:14:0x002e, B:16:0x0032, B:17:0x0039, B:19:0x003e, B:21:0x0042, B:24:0x0067, B:26:0x0071, B:29:0x0048, B:31:0x005e, B:34:0x0021), top: B:5:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean g(com.avery.subtitle.DefaultSubtitleEngine r6, android.os.Message r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.h(r6, r0)
            java.lang.String r0 = "msg"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            boolean r0 = r6.f19951j
            r1 = 1
            if (r0 == 0) goto L10
            return r1
        L10:
            i5.a r0 = r6.f19946e     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1b
            java.lang.Float r0 = r0.getSpeed()     // Catch: java.lang.Throwable -> L19
            goto L1c
        L19:
            r6 = move-exception
            goto L82
        L1b:
            r0 = 0
        L1c:
            if (r0 != 0) goto L21
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L25
        L21:
            float r0 = r0.floatValue()     // Catch: java.lang.Throwable -> L19
        L25:
            int r7 = r7.what     // Catch: java.lang.Throwable -> L19
            r2 = 2185(0x889, float:3.062E-42)
            if (r7 != r2) goto L2d
            r7 = r1
            goto L2e
        L2d:
            r7 = 0
        L2e:
            i5.a r2 = r6.f19946e     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L37
            long r2 = r2.getCurrentPosition()     // Catch: java.lang.Throwable -> L19
            goto L39
        L37:
            r2 = 0
        L39:
            long r4 = r6.f19950i     // Catch: java.lang.Throwable -> L19
            long r2 = r2 + r4
            if (r7 != 0) goto L48
            i5.a r7 = r6.f19946e     // Catch: java.lang.Throwable -> L19
            if (r7 == 0) goto L65
            boolean r7 = r7.isPlaying()     // Catch: java.lang.Throwable -> L19
            if (r7 != r1) goto L65
        L48:
            l5.a r7 = r6.i()     // Catch: java.lang.Throwable -> L19
            java.lang.String r4 = r6.f19949h     // Catch: java.lang.Throwable -> L19
            kotlin.jvm.internal.Intrinsics.e(r4)     // Catch: java.lang.Throwable -> L19
            java.util.List r7 = r7.d(r4)     // Catch: java.lang.Throwable -> L19
            k5.b r7 = com.avery.subtitle.c.a(r2, r7)     // Catch: java.lang.Throwable -> L19
            r6.m(r7)     // Catch: java.lang.Throwable -> L19
            if (r7 == 0) goto L65
            k5.c r7 = r7.f66775c     // Catch: java.lang.Throwable -> L19
            int r7 = r7.f66777a     // Catch: java.lang.Throwable -> L19
            long r4 = (long) r7     // Catch: java.lang.Throwable -> L19
            long r4 = r4 - r2
            goto L67
        L65:
            r4 = 1000(0x3e8, double:4.94E-321)
        L67:
            r6.e()     // Catch: java.lang.Throwable -> L19
            float r7 = (float) r4     // Catch: java.lang.Throwable -> L19
            float r7 = r7 / r0
            long r2 = (long) r7     // Catch: java.lang.Throwable -> L19
            android.os.Handler r7 = r6.f19943b     // Catch: java.lang.Throwable -> L19
            if (r7 == 0) goto L85
            kotlin.jvm.internal.Intrinsics.e(r7)     // Catch: java.lang.Throwable -> L19
            r0 = 2184(0x888, float:3.06E-42)
            r7.removeMessages(r0)     // Catch: java.lang.Throwable -> L19
            android.os.Handler r6 = r6.f19943b     // Catch: java.lang.Throwable -> L19
            kotlin.jvm.internal.Intrinsics.e(r6)     // Catch: java.lang.Throwable -> L19
            r6.sendEmptyMessageDelayed(r0, r2)     // Catch: java.lang.Throwable -> L19
            goto L85
        L82:
            r6.printStackTrace()
        L85:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avery.subtitle.DefaultSubtitleEngine.g(com.avery.subtitle.DefaultSubtitleEngine, android.os.Message):boolean");
    }

    private final void h() {
        if (this.f19942a != null) {
            return;
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l5.a i() {
        return (l5.a) this.f19954m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String str, String str2, boolean z10, i5.b bVar, d dVar) {
        if (dVar == null) {
            if (bVar != null) {
                bVar.a(false);
            }
            Log.e(f19940p, "onSuccess: timedTextObject is null.");
            return;
        }
        TreeMap treeMap = dVar.f66786i;
        if (treeMap == null) {
            if (bVar != null) {
                bVar.a(false);
            }
            Log.e(f19940p, "onSuccess: captions is null.");
            return;
        }
        String md5 = l5.b.a(str);
        String str3 = dVar.f66787j;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onSuccess: md5 = ");
        sb2.append(md5);
        sb2.append(".,path = ");
        sb2.append(str);
        sb2.append(" warnings = ");
        sb2.append(str3);
        ArrayList arrayList = new ArrayList(treeMap.values());
        l5.a i11 = i();
        Intrinsics.g(md5, "md5");
        i11.f(md5, arrayList);
        if (!this.f19944c) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("add timeout map : md5 = ");
            sb3.append(md5);
            sb3.append("， path = ");
            sb3.append(str);
            this.f19945d.put(md5, Long.valueOf(System.currentTimeMillis()));
        }
        if (!this.f19944c || TextUtils.equals(md5, this.f19949h)) {
            l(z10);
        }
        if (bVar != null) {
            bVar.a(true);
        }
    }

    private final void k(String str, final String str2, final String str3, final boolean z10, final i5.b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadSubtitle: path = ");
        sb2.append(str2);
        if (!i().h(str)) {
            i().a(str);
            SubtitleLoader.f19962a.h(str2, str3, new b(str, str2, str3, z10, bVar));
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("loadSubtitle, 当前有加载，无需处理: path = ");
            sb3.append(str2);
            i().b(new Function2<String, d, Unit>() { // from class: com.avery.subtitle.DefaultSubtitleEngine$loadSubtitle$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((String) obj, (d) obj2);
                    return Unit.f67184a;
                }

                public final void invoke(String str4, d dVar) {
                    String unused = DefaultSubtitleEngine.f19940p;
                    String str5 = str2;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("其他的加载成功: path = ");
                    sb4.append(str5);
                    this.j(str2, str3, z10, bVar, dVar);
                }
            });
        }
    }

    private final void l(boolean z10) {
        b.InterfaceC0190b interfaceC0190b;
        if (i().g() || this.f19951j || (interfaceC0190b = this.f19947f) == null) {
            return;
        }
        if (z10) {
            Intrinsics.e(interfaceC0190b);
            interfaceC0190b.onRefreshSubtitle();
        } else {
            Intrinsics.e(interfaceC0190b);
            interfaceC0190b.onSubtitlePrepared();
        }
    }

    private final void m(k5.b bVar) {
        b.a aVar = this.f19948g;
        if (aVar != null) {
            k.d(this.f19952k, null, null, new DefaultSubtitleEngine$notifyRefreshUI$1$1(aVar, bVar, null), 3, null);
        }
    }

    private final void n() {
        HandlerThread handlerThread = this.f19942a;
        if (handlerThread != null) {
            Intrinsics.e(handlerThread);
            handlerThread.quit();
            this.f19942a = null;
        }
        Handler handler = this.f19943b;
        if (handler != null) {
            Intrinsics.e(handler);
            handler.removeCallbacksAndMessages(null);
            this.f19943b = null;
        }
    }

    @Override // com.avery.subtitle.b
    public void destroy() {
        reset();
        n();
        this.f19951j = false;
    }

    @Override // com.avery.subtitle.b
    public void initSubtitle(i5.a playerControl, boolean z10) {
        Intrinsics.h(playerControl, "playerControl");
        this.f19946e = playerControl;
        this.f19944c = z10;
    }

    @Override // com.avery.subtitle.b
    public void pause() {
        this.f19951j = true;
        Handler handler = this.f19943b;
        if (handler != null) {
            Intrinsics.e(handler);
            handler.removeMessages(2184);
        }
    }

    @Override // com.avery.subtitle.b
    public void refreshImmediately() {
        if (i().g()) {
            return;
        }
        this.f19951j = false;
        Handler handler = this.f19943b;
        if (handler != null) {
            Intrinsics.e(handler);
            handler.removeMessages(2184);
            Handler handler2 = this.f19943b;
            Intrinsics.e(handler2);
            handler2.sendEmptyMessage(2185);
        }
    }

    @Override // com.avery.subtitle.b
    public void reset() {
        this.f19951j = false;
        n();
        i().c();
    }

    @Override // com.avery.subtitle.b
    public void resume() {
        start();
    }

    @Override // com.avery.subtitle.b
    public void selectSubtitle(String path, String unicode, i5.b bVar) {
        Intrinsics.h(path, "path");
        Intrinsics.h(unicode, "unicode");
        if (path.length() == 0) {
            if (bVar != null) {
                bVar.a(false);
                return;
            }
            return;
        }
        String md5 = l5.b.a(path);
        if (TextUtils.equals(md5, this.f19949h)) {
            if (bVar != null) {
                bVar.a(true);
                return;
            }
            return;
        }
        this.f19949h = md5;
        l5.a i11 = i();
        Intrinsics.g(md5, "md5");
        if (!i11.e(md5)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("selectSubtitle: load md5 = ");
            sb2.append(md5);
            sb2.append(", path = ");
            sb2.append(path);
            k(md5, path, unicode, true, bVar);
            return;
        }
        this.f19945d.put(this.f19949h, Long.valueOf(System.currentTimeMillis()));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("selectSubtitle: immediately, md5 = ");
        sb3.append(md5);
        sb3.append(", path = ");
        sb3.append(path);
        l(true);
        if (bVar != null) {
            bVar.a(true);
        }
    }

    @Override // com.avery.subtitle.b
    public void setDefaultSubtitle(String path) {
        Intrinsics.h(path, "path");
        String a11 = l5.b.a(path);
        if (TextUtils.equals(a11, this.f19949h)) {
            return;
        }
        this.f19949h = a11;
    }

    @Override // com.avery.subtitle.b
    public void setOnSubtitleChangeListener(b.a listener) {
        Intrinsics.h(listener, "listener");
        this.f19948g = listener;
    }

    @Override // com.avery.subtitle.b
    public void setOnSubtitlePreparedListener(b.InterfaceC0190b listener) {
        Intrinsics.h(listener, "listener");
        this.f19947f = listener;
    }

    @Override // com.avery.subtitle.b
    public void setSubtitlePath(String path, String unicode) {
        Intrinsics.h(path, "path");
        Intrinsics.h(unicode, "unicode");
        h();
        if (TextUtils.isEmpty(path)) {
            Log.w(f19940p, "loadSubtitleFromRemote: path is null.");
            return;
        }
        String md5 = l5.b.a(path);
        if (!TextUtils.isEmpty(md5)) {
            l5.a i11 = i();
            Intrinsics.g(md5, "md5");
            if (i11.e(md5)) {
                return;
            }
        }
        if (this.f19944c || TextUtils.isEmpty(this.f19949h) || TextUtils.equals(this.f19949h, md5)) {
            Intrinsics.g(md5, "md5");
            k(md5, path, unicode, false, null);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setSubtitlePath: skip~ md5 = ");
        sb2.append(md5);
        sb2.append(", path = ");
        sb2.append(path);
    }

    @Override // com.avery.subtitle.b
    public void start() {
        if (i().g()) {
            return;
        }
        if (this.f19946e == null) {
            Log.w(f19940p, "PlayerControl is not bind, You must bind PlayerControl to " + com.avery.subtitle.b.class.getSimpleName() + " before start() method be called, you can do this by call bindPlayerControl(PlayerControl playerControl) method.");
            return;
        }
        this.f19951j = false;
        Handler handler = this.f19943b;
        if (handler != null) {
            Intrinsics.e(handler);
            handler.removeMessages(2184);
            Handler handler2 = this.f19943b;
            Intrinsics.e(handler2);
            handler2.sendEmptyMessageDelayed(2184, 1000L);
        }
    }

    @Override // com.avery.subtitle.b
    public void stop() {
        this.f19951j = true;
        Handler handler = this.f19943b;
        if (handler != null) {
            Intrinsics.e(handler);
            handler.removeMessages(2184);
        }
    }

    @Override // com.avery.subtitle.b
    public void subtitleDelay(long j11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("subtitleDelay = ");
        sb2.append(j11);
        this.f19950i = j11;
        l(true);
    }
}
