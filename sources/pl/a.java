package pl;

import com.transsion.player.orplayer.PlayError;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private long f72587b;

    /* renamed from: c, reason: collision with root package name */
    private long f72588c;

    /* renamed from: e, reason: collision with root package name */
    private long f72590e;

    /* renamed from: f, reason: collision with root package name */
    private long f72591f;

    /* renamed from: g, reason: collision with root package name */
    private long f72592g;

    /* renamed from: h, reason: collision with root package name */
    private long f72593h;

    /* renamed from: i, reason: collision with root package name */
    private long f72594i;

    /* renamed from: j, reason: collision with root package name */
    private long f72595j;

    /* renamed from: k, reason: collision with root package name */
    private int f72596k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f72597l;

    /* renamed from: m, reason: collision with root package name */
    private Integer f72598m;

    /* renamed from: n, reason: collision with root package name */
    private String f72599n;

    /* renamed from: a, reason: collision with root package name */
    private final String f72586a = "long_video_play";

    /* renamed from: d, reason: collision with root package name */
    private String f72589d = "";

    private final void j() {
        this.f72589d = "";
        this.f72588c = 0L;
        this.f72590e = 0L;
        this.f72591f = 0L;
        this.f72592g = 0L;
        this.f72593h = 0L;
        this.f72594i = 0L;
        this.f72595j = 0L;
        this.f72596k = 0;
        this.f72597l = false;
        this.f72598m = null;
        this.f72599n = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.a():void");
    }

    public final void b() {
        this.f72587b = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, this.f72586a, "TvLiveDot initView", false, 4, null);
    }

    public final void c() {
        this.f72594i = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, this.f72586a, "TvLiveDot onLoadingBegin", false, 4, null);
    }

    public final void d() {
        if (this.f72594i > 0) {
            this.f72595j += System.currentTimeMillis() - this.f72594i;
            this.f72596k++;
            this.f72594i = 0L;
        }
        a.C0856a.f(lg.a.f68962a, this.f72586a, "TvLiveDot onLoadingEnd", false, 4, null);
    }

    public final void e(PlayError errorInfo) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.f72598m = errorInfo.getErrorCode();
        String errorMessage = errorInfo.getErrorMessage();
        this.f72599n = errorMessage;
        this.f72597l = false;
        a.C0856a.f(lg.a.f68962a, this.f72586a, "TvLiveDot onPlayError code=" + this.f72598m + " msg=" + errorMessage, false, 4, null);
    }

    public final void f(String url) {
        Intrinsics.h(url, "url");
        this.f72589d = url;
        this.f72588c = 0L;
        this.f72590e = 0L;
        this.f72591f = 0L;
        this.f72592g = 0L;
        this.f72593h = 0L;
        this.f72594i = 0L;
        this.f72595j = 0L;
        this.f72596k = 0;
        this.f72597l = false;
        this.f72598m = null;
        this.f72599n = null;
        a.C0856a.f(lg.a.f68962a, this.f72586a, "TvLiveDot onPlayStream url=" + url, false, 4, null);
    }

    public final void g() {
        this.f72588c = System.currentTimeMillis();
        this.f72597l = true;
        a.C0856a.f(lg.a.f68962a, this.f72586a, "TvLiveDot onRenderFirstFrame", false, 4, null);
    }

    public final void h() {
        if (this.f72590e > 0) {
            this.f72591f += System.currentTimeMillis() - this.f72590e;
            this.f72590e = 0L;
        }
        this.f72592g = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, this.f72586a, "TvLiveDot onVideoPause", false, 4, null);
    }

    public final void i() {
        if (this.f72592g > 0) {
            this.f72593h += System.currentTimeMillis() - this.f72592g;
            this.f72592g = 0L;
        }
        if (!this.f72597l) {
            this.f72597l = true;
        }
        this.f72590e = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, this.f72586a, "TvLiveDot onVideoStart", false, 4, null);
    }
}
