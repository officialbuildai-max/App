package com.transsion.player.orplayer;

import com.aliyun.loader.MediaLoader;
import com.aliyun.player.AliPlayerGlobalSettings;
import com.blankj.utilcode.util.Utils;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class ORPlayerPreloadManager implements MediaLoader.OnLoadStatusListener {

    /* renamed from: i, reason: collision with root package name */
    public static final a f48463i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static final Lazy f48464j = LazyKt.b(new Function0() { // from class: com.transsion.player.orplayer.d0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ORPlayerPreloadManager d11;
            d11 = ORPlayerPreloadManager.d();
            return d11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final String f48465a = "ORPlayerPreload";

    /* renamed from: b, reason: collision with root package name */
    private final long f48466b = 4000;

    /* renamed from: c, reason: collision with root package name */
    private long f48467c = 4000;

    /* renamed from: d, reason: collision with root package name */
    private String f48468d = "";

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList f48469e = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList f48470f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final CopyOnWriteArrayList f48471g = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    private long f48472h;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ORPlayerPreloadManager a() {
            return (ORPlayerPreloadManager) ORPlayerPreloadManager.f48464j.getValue();
        }
    }

    public ORPlayerPreloadManager() {
        MediaLoader.getInstance().setOnLoadStatusListener(this);
        File externalCacheDir = Utils.a().getExternalCacheDir();
        String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
        String str = absolutePath + File.separator + "video_cache";
        try {
            Result.Companion companion = Result.INSTANCE;
            AliPlayerGlobalSettings.enableLocalCache(true, 0, str);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ORPlayerPreloadManager d() {
        return new ORPlayerPreloadManager();
    }

    private final void l(String str) {
        this.f48472h = System.currentTimeMillis();
        oo.e.b(oo.e.f71197a, this.f48465a, "startPreload, url = " + str, false, 4, null);
        MediaLoader.getInstance().load(str, this.f48467c);
    }

    public final void c() {
        oo.e.b(oo.e.f71197a, this.f48465a, "cancelAll", false, 4, null);
        this.f48468d = "";
        this.f48471g.clear();
        this.f48469e.clear();
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new ORPlayerPreloadManager$cancelAll$1(null), 3, null);
    }

    public final boolean e(String url) {
        Intrinsics.h(url, "url");
        return this.f48470f.contains(url);
    }

    public final boolean f(String url) {
        Intrinsics.h(url, "url");
        return (this.f48468d.length() > 0 && Intrinsics.c(url, this.f48468d)) || this.f48471g.contains(url);
    }

    public final void g(String url) {
        Intrinsics.h(url, "url");
        if (!f(url)) {
            oo.e.b(oo.e.f71197a, this.f48465a, "pause, but not contains, PausedContains =  " + this.f48469e.contains(url) + ", url = " + url, false, 4, null);
            return;
        }
        oo.e.b(oo.e.f71197a, this.f48465a, "pause, url = " + url, false, 4, null);
        this.f48469e.add(url);
        if (!Intrinsics.c(this.f48468d, url)) {
            if (this.f48471g.contains(url)) {
                this.f48471g.remove(url);
                return;
            }
            return;
        }
        this.f48468d = "";
        MediaLoader.getInstance().pause(url);
        if (this.f48471g.isEmpty()) {
            return;
        }
        Object i02 = CollectionsKt.i0(this.f48471g);
        Intrinsics.g(i02, "first(...)");
        String str = (String) i02;
        this.f48468d = str;
        l(str);
        this.f48471g.remove(this.f48468d);
    }

    public final void h() {
        oo.e.b(oo.e.f71197a, this.f48465a, "pauseAll, paused size = " + this.f48469e.size() + ", urlsCache size = " + this.f48471g.size() + ", curUrl = " + this.f48468d + " ", false, 4, null);
        if (this.f48468d.length() > 0) {
            MediaLoader.getInstance().pause(this.f48468d);
            this.f48469e.add(this.f48468d);
            this.f48468d = "";
        }
        if (this.f48471g.isEmpty()) {
            return;
        }
        this.f48469e.addAll(this.f48471g);
        this.f48471g.clear();
    }

    public final void i(String url) {
        Intrinsics.h(url, "url");
        j(url, this.f48466b);
    }

    public final void j(String url, long j11) {
        Intrinsics.h(url, "url");
        if (j11 > 0) {
            this.f48467c = j11;
        }
        if (f(url)) {
            oo.e.b(oo.e.f71197a, this.f48465a, "start preload, contains return~ url = " + url, false, 4, null);
            return;
        }
        if (this.f48469e.contains(url)) {
            oo.e.b(oo.e.f71197a, this.f48465a, "start preload, pause contains resume~ url = " + url, false, 4, null);
            if (this.f48468d.length() > 0) {
                this.f48471g.add(url);
            } else {
                this.f48468d = url;
                MediaLoader.getInstance().resume(url);
            }
            this.f48469e.remove(url);
            return;
        }
        if (this.f48470f.contains(url)) {
            oo.e.b(oo.e.f71197a, this.f48465a, "is preloaded, return, url = " + url, false, 4, null);
            return;
        }
        if (this.f48468d.length() <= 0) {
            this.f48468d = url;
            l(url);
            return;
        }
        if (System.currentTimeMillis() - this.f48472h <= 5000) {
            oo.e.b(oo.e.f71197a, this.f48465a, "start preload, add to cache, url = " + url, false, 4, null);
            this.f48471g.add(url);
            return;
        }
        oo.e.i(oo.e.f71197a, this.f48465a, "last is more than 5 sec, preload new url", false, 4, null);
        if (this.f48471g.isEmpty()) {
            this.f48468d = url;
            l(url);
            return;
        }
        Object i02 = CollectionsKt.i0(this.f48471g);
        Intrinsics.g(i02, "first(...)");
        String str = (String) i02;
        this.f48468d = str;
        l(str);
        this.f48471g.remove(this.f48468d);
        this.f48471g.add(url);
    }

    public final void k() {
        oo.e.b(oo.e.f71197a, this.f48465a, "resumeAll, paused size = " + this.f48469e.size() + ", urlsCache size = " + this.f48471g.size() + ", curUrl = " + this.f48468d + " ", false, 4, null);
        if (this.f48468d.length() > 0) {
            return;
        }
        if (!this.f48469e.isEmpty()) {
            Iterator it = this.f48469e.iterator();
            Intrinsics.g(it, "iterator(...)");
            while (it.hasNext()) {
                String str = (String) it.next();
                if (this.f48468d.length() > 0) {
                    this.f48471g.add(str);
                } else {
                    Intrinsics.e(str);
                    this.f48468d = str;
                    MediaLoader.getInstance().resume(str);
                }
            }
        }
        this.f48469e.clear();
    }

    @Override // com.aliyun.loader.MediaLoader.OnLoadStatusListener
    public void onCanceled(String str) {
    }

    @Override // com.aliyun.loader.MediaLoader.OnLoadStatusListener
    public void onCompleted(String str) {
        oo.e.i(oo.e.f71197a, this.f48465a, "preload complete, url = " + str, false, 4, null);
        this.f48469e.remove(str);
        if (this.f48471g.isEmpty()) {
            this.f48468d = "";
        } else {
            Object i02 = CollectionsKt.i0(this.f48471g);
            Intrinsics.g(i02, "first(...)");
            String str2 = (String) i02;
            this.f48468d = str2;
            l(str2);
            this.f48471g.remove(this.f48468d);
        }
        if (str != null) {
            this.f48470f.add(str);
        }
    }

    @Override // com.aliyun.loader.MediaLoader.OnLoadStatusListener
    public void onError(String str, int i11, String str2) {
        oo.e.b(oo.e.f71197a, this.f48465a, "preload error, " + (i11 == -300 ? "is preloaded code" : "errorCode") + " = " + i11 + ", errorMsg= " + str2 + ", url = " + str, false, 4, null);
        if (!this.f48471g.isEmpty()) {
            Object i02 = CollectionsKt.i0(this.f48471g);
            Intrinsics.g(i02, "first(...)");
            String str3 = (String) i02;
            this.f48468d = str3;
            l(str3);
            this.f48471g.remove(this.f48468d);
        }
        this.f48469e.remove(str);
        if (i11 == -300) {
            this.f48470f.add(str);
        }
    }
}
