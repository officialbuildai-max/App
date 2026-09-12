package js;

import com.transsion.player.ui.ORPlayerView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final ORPlayerView f66393a;

    /* renamed from: b, reason: collision with root package name */
    private final com.transsion.player.orplayer.g f66394b;

    /* renamed from: c, reason: collision with root package name */
    private final String f66395c;

    /* renamed from: d, reason: collision with root package name */
    private final int f66396d;

    /* renamed from: e, reason: collision with root package name */
    private final int f66397e;

    /* renamed from: f, reason: collision with root package name */
    private final String f66398f;

    /* renamed from: g, reason: collision with root package name */
    private final String f66399g;

    /* renamed from: h, reason: collision with root package name */
    private final String f66400h;

    /* renamed from: i, reason: collision with root package name */
    private final List f66401i;

    public j(ORPlayerView playerView, com.transsion.player.orplayer.g orPlayer, String subjectId, int i11, int i12, String pageName, String str, String str2, List playList) {
        Intrinsics.h(playerView, "playerView");
        Intrinsics.h(orPlayer, "orPlayer");
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(playList, "playList");
        this.f66393a = playerView;
        this.f66394b = orPlayer;
        this.f66395c = subjectId;
        this.f66396d = i11;
        this.f66397e = i12;
        this.f66398f = pageName;
        this.f66399g = str;
        this.f66400h = str2;
        this.f66401i = playList;
    }

    public final int a() {
        return this.f66397e;
    }

    public final String b() {
        return this.f66399g;
    }

    public final com.transsion.player.orplayer.g c() {
        return this.f66394b;
    }

    public final String d() {
        return this.f66400h;
    }

    public final String e() {
        return this.f66398f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return Intrinsics.c(this.f66393a, jVar.f66393a) && Intrinsics.c(this.f66394b, jVar.f66394b) && Intrinsics.c(this.f66395c, jVar.f66395c) && this.f66396d == jVar.f66396d && this.f66397e == jVar.f66397e && Intrinsics.c(this.f66398f, jVar.f66398f) && Intrinsics.c(this.f66399g, jVar.f66399g) && Intrinsics.c(this.f66400h, jVar.f66400h) && Intrinsics.c(this.f66401i, jVar.f66401i);
    }

    public final List f() {
        return this.f66401i;
    }

    public final ORPlayerView g() {
        return this.f66393a;
    }

    public final int h() {
        return this.f66396d;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.f66393a.hashCode() * 31) + this.f66394b.hashCode()) * 31) + this.f66395c.hashCode()) * 31) + this.f66396d) * 31) + this.f66397e) * 31) + this.f66398f.hashCode()) * 31;
        String str = this.f66399g;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f66400h;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f66401i.hashCode();
    }

    public final String i() {
        return this.f66395c;
    }

    public String toString() {
        return "ShortTvFloatBean(playerView=" + this.f66393a + ", orPlayer=" + this.f66394b + ", subjectId=" + this.f66395c + ", se=" + this.f66396d + ", ep=" + this.f66397e + ", pageName=" + this.f66398f + ", ops=" + this.f66399g + ", pageFrom=" + this.f66400h + ", playList=" + this.f66401i + ")";
    }
}
