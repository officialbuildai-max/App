package ut;

import androidx.fragment.app.Fragment;
import ao.e;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.g;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel;
import hj.i;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import mo.d;

/* loaded from: classes7.dex */
public final class c implements f {
    private ShorttvModel.UGCVideo A;
    private String B;
    private String C;
    private String D;
    private String E;

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f77017a;

    /* renamed from: b, reason: collision with root package name */
    private final ShortTvViewModel f77018b;

    /* renamed from: c, reason: collision with root package name */
    private final String f77019c;

    /* renamed from: d, reason: collision with root package name */
    private g f77020d;

    /* renamed from: e, reason: collision with root package name */
    private long f77021e;

    /* renamed from: f, reason: collision with root package name */
    private long f77022f;

    /* renamed from: g, reason: collision with root package name */
    private long f77023g;

    /* renamed from: h, reason: collision with root package name */
    private long f77024h;

    /* renamed from: i, reason: collision with root package name */
    private long f77025i;

    /* renamed from: j, reason: collision with root package name */
    private int f77026j;

    /* renamed from: k, reason: collision with root package name */
    private long f77027k;

    /* renamed from: l, reason: collision with root package name */
    private long f77028l;

    /* renamed from: m, reason: collision with root package name */
    private long f77029m;

    /* renamed from: n, reason: collision with root package name */
    private int f77030n;

    /* renamed from: o, reason: collision with root package name */
    private long f77031o;

    /* renamed from: p, reason: collision with root package name */
    private long f77032p;

    /* renamed from: q, reason: collision with root package name */
    private long f77033q;

    /* renamed from: r, reason: collision with root package name */
    private PlayError f77034r;

    /* renamed from: s, reason: collision with root package name */
    private int f77035s;

    /* renamed from: t, reason: collision with root package name */
    private int f77036t;

    /* renamed from: u, reason: collision with root package name */
    private String f77037u;

    /* renamed from: v, reason: collision with root package name */
    private String f77038v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f77039w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f77040x;

    /* renamed from: y, reason: collision with root package name */
    private String f77041y;

    /* renamed from: z, reason: collision with root package name */
    private int f77042z;

    public c(Fragment fragment, ShortTvViewModel shortTvViewModel) {
        Intrinsics.h(fragment, "fragment");
        this.f77017a = fragment;
        this.f77018b = shortTvViewModel;
        this.f77019c = c.class.getSimpleName();
        this.f77040x = true;
        this.f77041y = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "postdetail";
    }

    public static /* synthetic */ void f(c cVar, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        cVar.d(z10);
    }

    private final void j(boolean z10) {
        this.f77021e = 0L;
        this.f77022f = 0L;
        this.f77023g = 0L;
        this.f77024h = 0L;
        this.f77025i = 0L;
        this.f77026j = 0;
        this.f77027k = 0L;
        this.f77028l = 0L;
        this.f77029m = 0L;
        this.f77030n = 0;
        this.f77031o = 0L;
        this.f77032p = 0L;
        this.f77033q = 0L;
        this.f77042z = 0;
        if (z10) {
            return;
        }
        this.f77039w = false;
    }

    public final void a() {
        this.f77022f = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, "video_play", "addSurface", false, 4, null);
    }

    public final void b() {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f77019c;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "clickPause", false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "pause");
        i.f64628a.p(this.E, linkedHashMap);
    }

    public final void c() {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f77019c;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "clickPlay", false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        i.f64628a.p(this.E, linkedHashMap);
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(boolean r19) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ut.c.d(boolean):void");
    }

    public final void e(boolean z10, boolean z11) {
        if (z10) {
            d(z11);
        } else {
            j(z11);
        }
    }

    public final void g() {
        this.f77021e = System.currentTimeMillis();
        this.f77040x = true;
        a.C0856a.f(lg.a.f68962a, "video_play", "initView", false, 4, null);
    }

    public final void h() {
        this.f77042z++;
    }

    public final void i() {
        f(this, false, 1, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
    }

    public final void k(String str) {
        this.f77038v = str;
    }

    public final void l(String str) {
        this.f77037u = str;
    }

    public final void m(String str) {
        Intrinsics.h(str, "<set-?>");
        this.D = str;
    }

    public final void n(String str) {
        Intrinsics.h(str, "<set-?>");
        this.B = str;
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
        f.a.z(this, this.f77033q, null, 2, null);
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
        this.f77025i = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(e eVar) {
        if (this.f77025i > 0) {
            this.f77024h += System.currentTimeMillis() - this.f77025i;
            this.f77026j++;
            this.f77025i = 0L;
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, e eVar) {
        f.a.m(this, i11, f11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        this.f77030n++;
        this.f77027k = 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, e eVar) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.f77034r = errorInfo;
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
        st.a Q;
        if (0 == this.f77033q) {
            g gVar = this.f77020d;
            this.f77033q = gVar != null ? gVar.getDuration() : 0L;
        }
        long j12 = this.f77028l;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 1000) {
            this.f77029m += j11 - j12;
        }
        this.f77028l = j11;
        if (j11 > this.f77027k) {
            this.f77027k = j11;
        }
        ShortTvViewModel shortTvViewModel = this.f77018b;
        if (shortTvViewModel == null || (Q = shortTvViewModel.Q()) == null) {
            return;
        }
        Q.a(this.f77029m);
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        a.C0856a.f(lg.a.f68962a, "video_play", "onRenderFirstFrame", false, 4, null);
        this.f77023g = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        f.a.B(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksAudioBitrateChange(int i11) {
        this.f77036t = i11;
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksChange(mo.c cVar) {
        f.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksVideoBitrateChange(int i11) {
        this.f77035s = i11;
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoPause(e eVar) {
        this.f77031o = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        f.a.H(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(e eVar) {
        if (this.f77031o != 0) {
            this.f77032p += System.currentTimeMillis() - this.f77031o;
            this.f77031o = 0L;
        }
    }

    public final void p(g gVar) {
        this.f77020d = gVar;
    }

    public final void q(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        this.f77041y = pageFrom;
    }

    public final void r(String str) {
        Intrinsics.h(str, "<set-?>");
        this.E = str;
    }

    public final void s(ShorttvModel.UGCVideo uGCVideo) {
        this.A = uGCVideo;
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }
}
