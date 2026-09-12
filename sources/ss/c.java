package ss;

import android.view.View;
import androidx.fragment.app.Fragment;
import ao.e;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.g;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.viewmodel.ShortTvViewModel;
import hj.i;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import mo.d;

/* loaded from: classes7.dex */
public final class c implements f {
    private int A;
    private Subject B;
    private String C;
    private String D;
    private int E;
    private int F;
    private boolean G;
    private String H;

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f75982a;

    /* renamed from: b, reason: collision with root package name */
    private final ShortTvViewModel f75983b;

    /* renamed from: c, reason: collision with root package name */
    private final String f75984c;

    /* renamed from: d, reason: collision with root package name */
    private g f75985d;

    /* renamed from: e, reason: collision with root package name */
    private long f75986e;

    /* renamed from: f, reason: collision with root package name */
    private long f75987f;

    /* renamed from: g, reason: collision with root package name */
    private long f75988g;

    /* renamed from: h, reason: collision with root package name */
    private long f75989h;

    /* renamed from: i, reason: collision with root package name */
    private long f75990i;

    /* renamed from: j, reason: collision with root package name */
    private int f75991j;

    /* renamed from: k, reason: collision with root package name */
    private long f75992k;

    /* renamed from: l, reason: collision with root package name */
    private long f75993l;

    /* renamed from: m, reason: collision with root package name */
    private long f75994m;

    /* renamed from: n, reason: collision with root package name */
    private int f75995n;

    /* renamed from: o, reason: collision with root package name */
    private long f75996o;

    /* renamed from: p, reason: collision with root package name */
    private long f75997p;

    /* renamed from: q, reason: collision with root package name */
    private long f75998q;

    /* renamed from: r, reason: collision with root package name */
    private Integer f75999r;

    /* renamed from: s, reason: collision with root package name */
    private String f76000s;

    /* renamed from: t, reason: collision with root package name */
    private String f76001t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f76002u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f76003v;

    /* renamed from: w, reason: collision with root package name */
    private String f76004w;

    /* renamed from: x, reason: collision with root package name */
    private String f76005x;

    /* renamed from: y, reason: collision with root package name */
    private int f76006y;

    /* renamed from: z, reason: collision with root package name */
    private int f76007z;

    public c(Fragment fragment, ShortTvViewModel shortTvViewModel) {
        Intrinsics.h(fragment, "fragment");
        this.f75982a = fragment;
        this.f75983b = shortTvViewModel;
        this.f75984c = c.class.getSimpleName();
        this.f76003v = true;
        this.f76004w = "";
        this.f76005x = "";
        this.f76006y = -1;
        this.C = "";
        this.D = "";
        this.H = "postdetail";
    }

    public static /* synthetic */ void f(c cVar, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        cVar.d(z10);
    }

    private final void i(boolean z10) {
        this.f75986e = 0L;
        this.f75987f = 0L;
        this.f75988g = 0L;
        this.f75989h = 0L;
        this.f75990i = 0L;
        this.f75991j = 0;
        this.f75992k = 0L;
        this.f75993l = 0L;
        this.f75994m = 0L;
        this.f75995n = 0;
        this.f75996o = 0L;
        this.f75997p = 0L;
        this.f75998q = 0L;
        this.f75999r = null;
        this.G = false;
        if (z10) {
            return;
        }
        this.f76006y = -1;
        this.f76002u = false;
    }

    public final void a(int i11, int i12) {
        this.f75987f = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, "video_play", "addSurface", false, 4, null);
    }

    public final void b() {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f75984c;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "clickPause", false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "pause");
        linkedHashMap.put("content_type", "ugc_video");
        i.f64628a.p(this.H, linkedHashMap);
    }

    public final void c() {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f75984c;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "clickPlay", false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        linkedHashMap.put("content_type", "ugc_video");
        i.f64628a.p(this.H, linkedHashMap);
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(boolean r19) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ss.c.d(boolean):void");
    }

    public final void e(boolean z10, boolean z11) {
        if (z10) {
            d(z11);
        } else {
            i(z11);
        }
    }

    public final void g(View rootView, boolean z10) {
        Intrinsics.h(rootView, "rootView");
        this.f75986e = System.currentTimeMillis();
        this.f76003v = true;
        a.C0856a.f(lg.a.f68962a, "video_play", "initView", false, 4, null);
    }

    public final void h() {
        f(this, false, 1, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
    }

    public final void j(String str) {
        this.f76001t = str;
    }

    public final void k(String str) {
        this.f76000s = str;
    }

    public final void l(int i11) {
        this.F = i11;
    }

    public final void m(String str) {
        Intrinsics.h(str, "<set-?>");
        this.D = str;
    }

    public final void n(boolean z10) {
        this.G = z10;
    }

    public final void o(String str) {
        Intrinsics.h(str, "<set-?>");
        this.C = str;
    }

    @Override // com.transsion.player.orplayer.f
    public void onAliyunDecodeErrorChangeSoftwareDecoder(e eVar) {
        f.a.c(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, e eVar) {
        f.a.d(this, j11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(e eVar) {
        f.a.e(this, eVar);
        f.a.z(this, this.f75998q, null, 2, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        f.a.g(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onIsPlayingChanged(boolean z10) {
        f.a.h(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingBegin(e eVar) {
        this.f75990i = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(e eVar) {
        if (this.f75990i > 0) {
            this.f75989h += System.currentTimeMillis() - this.f75990i;
            this.f75991j++;
            this.f75990i = 0L;
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, e eVar) {
        f.a.m(this, i11, f11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        this.f75995n++;
        this.f75992k = 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, e eVar) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.f75999r = errorInfo.getErrorCode();
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(e eVar) {
        f.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        f.a.v(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(e eVar) {
        f.a.w(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long j11, e eVar) {
        qs.a D0;
        if (0 == this.f75998q) {
            g gVar = this.f75985d;
            this.f75998q = gVar != null ? gVar.getDuration() : 0L;
        }
        long j12 = this.f75993l;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 1000) {
            this.f75994m += j11 - j12;
        }
        this.f75993l = j11;
        if (j11 > this.f75992k) {
            this.f75992k = j11;
        }
        ShortTvViewModel shortTvViewModel = this.f75983b;
        if (shortTvViewModel == null || (D0 = shortTvViewModel.D0()) == null) {
            return;
        }
        D0.a(this.f75994m);
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        a.C0856a.f(lg.a.f68962a, "video_play", "onRenderFirstFrame", false, 4, null);
        this.f75988g = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        f.a.B(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksAudioBitrateChange(int i11) {
        this.A = i11;
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksChange(mo.c cVar) {
        f.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksVideoBitrateChange(int i11) {
        this.f76007z = i11;
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoPause(e eVar) {
        this.f75996o = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        f.a.H(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(e eVar) {
        if (this.f75996o != 0) {
            this.f75997p += System.currentTimeMillis() - this.f75996o;
            this.f75996o = 0L;
        }
    }

    public final void p(g gVar) {
        this.f75985d = gVar;
    }

    public final void q(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        this.f76004w = pageFrom;
    }

    public final void r(String str) {
        Intrinsics.h(str, "<set-?>");
        this.H = str;
    }

    public final void s(Integer num) {
        this.f76006y = num != null ? num.intValue() : -1;
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }

    public final void t(Subject subject) {
        this.B = subject;
    }

    public final void u(int i11) {
        this.E = i11;
    }

    public final void v(String url) {
        Intrinsics.h(url, "url");
        this.f76005x = url;
    }
}
