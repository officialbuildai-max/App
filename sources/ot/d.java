package ot;

import com.transsion.player.orplayer.g;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.shorttv_pugc.ShorttvModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final ORPlayerView f72228a;

    /* renamed from: b, reason: collision with root package name */
    private final g f72229b;

    /* renamed from: c, reason: collision with root package name */
    private final String f72230c;

    /* renamed from: d, reason: collision with root package name */
    private final int f72231d;

    /* renamed from: e, reason: collision with root package name */
    private final String f72232e;

    /* renamed from: f, reason: collision with root package name */
    private final String f72233f;

    /* renamed from: g, reason: collision with root package name */
    private final String f72234g;

    /* renamed from: h, reason: collision with root package name */
    private final List f72235h;

    /* renamed from: i, reason: collision with root package name */
    private final ShorttvModel.UGCVideo f72236i;

    public d(ORPlayerView playerView, g orPlayer, String ugcVideoId, int i11, String pageName, String str, String str2, List playList, ShorttvModel.UGCVideo uGCVideo) {
        Intrinsics.h(playerView, "playerView");
        Intrinsics.h(orPlayer, "orPlayer");
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(playList, "playList");
        this.f72228a = playerView;
        this.f72229b = orPlayer;
        this.f72230c = ugcVideoId;
        this.f72231d = i11;
        this.f72232e = pageName;
        this.f72233f = str;
        this.f72234g = str2;
        this.f72235h = playList;
        this.f72236i = uGCVideo;
    }

    public final int a() {
        return this.f72231d;
    }

    public final String b() {
        return this.f72233f;
    }

    public final g c() {
        return this.f72229b;
    }

    public final String d() {
        return this.f72234g;
    }

    public final String e() {
        return this.f72232e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.c(this.f72228a, dVar.f72228a) && Intrinsics.c(this.f72229b, dVar.f72229b) && Intrinsics.c(this.f72230c, dVar.f72230c) && this.f72231d == dVar.f72231d && Intrinsics.c(this.f72232e, dVar.f72232e) && Intrinsics.c(this.f72233f, dVar.f72233f) && Intrinsics.c(this.f72234g, dVar.f72234g) && Intrinsics.c(this.f72235h, dVar.f72235h) && Intrinsics.c(this.f72236i, dVar.f72236i);
    }

    public final List f() {
        return this.f72235h;
    }

    public final ORPlayerView g() {
        return this.f72228a;
    }

    public final ShorttvModel.UGCVideo h() {
        return this.f72236i;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f72228a.hashCode() * 31) + this.f72229b.hashCode()) * 31) + this.f72230c.hashCode()) * 31) + this.f72231d) * 31) + this.f72232e.hashCode()) * 31;
        String str = this.f72233f;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f72234g;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f72235h.hashCode()) * 31;
        ShorttvModel.UGCVideo uGCVideo = this.f72236i;
        return hashCode3 + (uGCVideo != null ? uGCVideo.hashCode() : 0);
    }

    public String toString() {
        return "ShortTvFloatBean(playerView=" + this.f72228a + ", orPlayer=" + this.f72229b + ", ugcVideoId=" + this.f72230c + ", ep=" + this.f72231d + ", pageName=" + this.f72232e + ", ops=" + this.f72233f + ", pageFrom=" + this.f72234g + ", playList=" + this.f72235h + ", ugcVideo=" + this.f72236i + ")";
    }
}
