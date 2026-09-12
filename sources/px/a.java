package px;

import android.view.ViewGroup;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.player.orplayer.g;
import com.transsion.player.p007enum.PlayMimeType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.videofloat.bean.FloatPlayType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final ORPlayerView f72665a;

    /* renamed from: b, reason: collision with root package name */
    private final g f72666b;

    /* renamed from: c, reason: collision with root package name */
    private final ViewGroup f72667c;

    /* renamed from: d, reason: collision with root package name */
    private final FloatPlayType f72668d;

    /* renamed from: e, reason: collision with root package name */
    private final String f72669e;

    /* renamed from: f, reason: collision with root package name */
    private int f72670f;

    /* renamed from: g, reason: collision with root package name */
    private int f72671g;

    /* renamed from: h, reason: collision with root package name */
    private String f72672h;

    /* renamed from: i, reason: collision with root package name */
    private String f72673i;

    /* renamed from: j, reason: collision with root package name */
    private long f72674j;

    /* renamed from: k, reason: collision with root package name */
    private String f72675k;

    /* renamed from: l, reason: collision with root package name */
    private PlayMimeType f72676l;

    /* renamed from: m, reason: collision with root package name */
    private UGCVideo f72677m;

    /* renamed from: n, reason: collision with root package name */
    private DownloadBean f72678n;

    /* renamed from: o, reason: collision with root package name */
    private String f72679o;

    /* renamed from: p, reason: collision with root package name */
    private Integer f72680p;

    /* renamed from: q, reason: collision with root package name */
    private String f72681q;

    /* renamed from: r, reason: collision with root package name */
    private String f72682r;

    /* renamed from: s, reason: collision with root package name */
    private String f72683s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f72684t;

    /* renamed from: u, reason: collision with root package name */
    private String f72685u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f72686v;

    /* renamed from: w, reason: collision with root package name */
    private final boolean f72687w;

    public a(ORPlayerView playerView, g orPlayer, ViewGroup viewGroup, FloatPlayType playType, String subjectId, int i11, int i12, String str, String pageName) {
        Intrinsics.h(playerView, "playerView");
        Intrinsics.h(orPlayer, "orPlayer");
        Intrinsics.h(playType, "playType");
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(pageName, "pageName");
        this.f72665a = playerView;
        this.f72666b = orPlayer;
        this.f72667c = viewGroup;
        this.f72668d = playType;
        this.f72669e = subjectId;
        this.f72670f = i11;
        this.f72671g = i12;
        this.f72672h = str;
        this.f72673i = pageName;
        this.f72687w = playType == FloatPlayType.LOCAL || playType == FloatPlayType.STREAM;
    }

    private final boolean d() {
        PlayMimeType playMimeType = this.f72676l;
        return playMimeType == PlayMimeType.DASH || playMimeType == PlayMimeType.HLS;
    }

    public final void A(String str) {
        this.f72681q = str;
    }

    public final void B(String str) {
        this.f72683s = str;
    }

    public final void C(String str) {
        this.f72685u = str;
    }

    public final void D(boolean z10) {
        this.f72686v = z10;
    }

    public final void E(String str) {
        this.f72682r = str;
    }

    public final void F(long j11) {
        this.f72674j = j11;
    }

    public final void G(String str) {
        this.f72675k = str;
    }

    public final void H(int i11) {
        this.f72670f = i11;
    }

    public final void I(PlayMimeType playMimeType) {
        this.f72676l = playMimeType;
    }

    public final void J(Integer num) {
        this.f72680p = num;
    }

    public final void K(String str) {
        this.f72679o = str;
    }

    public final void L(UGCVideo uGCVideo) {
        this.f72677m = uGCVideo;
    }

    public final boolean a() {
        return this.f72684t;
    }

    public final DownloadBean b() {
        return this.f72678n;
    }

    public final int c() {
        return this.f72671g;
    }

    public final String e() {
        return this.f72681q;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f72665a, aVar.f72665a) && Intrinsics.c(this.f72666b, aVar.f72666b) && Intrinsics.c(this.f72667c, aVar.f72667c) && this.f72668d == aVar.f72668d && Intrinsics.c(this.f72669e, aVar.f72669e) && this.f72670f == aVar.f72670f && this.f72671g == aVar.f72671g && Intrinsics.c(this.f72672h, aVar.f72672h) && Intrinsics.c(this.f72673i, aVar.f72673i);
    }

    public final g f() {
        return this.f72666b;
    }

    public final String g() {
        return this.f72683s;
    }

    public final String h() {
        return this.f72673i;
    }

    public int hashCode() {
        int hashCode = ((this.f72665a.hashCode() * 31) + this.f72666b.hashCode()) * 31;
        ViewGroup viewGroup = this.f72667c;
        int hashCode2 = (((((((((hashCode + (viewGroup == null ? 0 : viewGroup.hashCode())) * 31) + this.f72668d.hashCode()) * 31) + this.f72669e.hashCode()) * 31) + this.f72670f) * 31) + this.f72671g) * 31;
        String str = this.f72672h;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.f72673i.hashCode();
    }

    public final FloatPlayType i() {
        return this.f72668d;
    }

    public final String j() {
        return this.f72685u;
    }

    public final String k() {
        if (this.f72677m != null) {
            String name = this.f72668d.name();
            UGCVideo uGCVideo = this.f72677m;
            Intrinsics.e(uGCVideo);
            String ugcVideoId = uGCVideo.getUgcVideoId();
            if (ugcVideoId == null) {
                ugcVideoId = "ugcVideo";
            }
            return name + ugcVideoId;
        }
        if (this.f72678n != null) {
            String name2 = this.f72668d.name();
            DownloadBean downloadBean = this.f72678n;
            Intrinsics.e(downloadBean);
            String ugcVideoId2 = downloadBean.getUgcVideoId();
            if (ugcVideoId2 == null) {
                ugcVideoId2 = "ugcLocalVideo";
            }
            return name2 + ugcVideoId2;
        }
        FloatPlayType floatPlayType = this.f72668d;
        if (floatPlayType == FloatPlayType.LOCAL) {
            return floatPlayType.name() + this.f72675k;
        }
        return floatPlayType.name() + this.f72669e;
    }

    public final ORPlayerView l() {
        return this.f72665a;
    }

    public final String m() {
        return this.f72682r;
    }

    public final long n() {
        return this.f72674j;
    }

    public final String o() {
        return this.f72672h;
    }

    public final String p() {
        return this.f72675k;
    }

    public final int q() {
        return this.f72670f;
    }

    public final String r() {
        return this.f72669e;
    }

    public final Integer s() {
        return this.f72680p;
    }

    public final String t() {
        UGCVideo uGCVideo = this.f72677m;
        if (uGCVideo != null) {
            Intrinsics.e(uGCVideo);
            return uGCVideo.getUgcVideoId() + "_" + this.f72679o;
        }
        DownloadBean downloadBean = this.f72678n;
        if (downloadBean != null) {
            Intrinsics.e(downloadBean);
            return downloadBean.getSubtitleResId();
        }
        return this.f72669e + "_" + this.f72670f + "_" + this.f72671g + "_en_" + (d() ? 2 : 1);
    }

    public String toString() {
        return "VideoFloatBean(playerView=" + this.f72665a + ", orPlayer=" + this.f72666b + ", subtitleViewGroup=" + this.f72667c + ", playType=" + this.f72668d + ", subjectId=" + this.f72669e + ", se=" + this.f72670f + ", ep=" + this.f72671g + ", resolution=" + this.f72672h + ", pageName=" + this.f72673i + ")";
    }

    public final ViewGroup u() {
        return this.f72667c;
    }

    public final UGCVideo v() {
        return this.f72677m;
    }

    public final boolean w() {
        return this.f72686v;
    }

    public final boolean x() {
        return this.f72687w;
    }

    public final void y(DownloadBean downloadBean) {
        this.f72678n = downloadBean;
    }

    public final void z(int i11) {
        this.f72671g = i11;
    }
}
