package ao;

import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.p007enum.PlayMimeType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oo.d;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f16160a;

    /* renamed from: b, reason: collision with root package name */
    private final String f16161b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16162c;

    /* renamed from: d, reason: collision with root package name */
    private PlayMimeType f16163d;

    /* renamed from: e, reason: collision with root package name */
    private final MediaItem f16164e;

    /* renamed from: f, reason: collision with root package name */
    private String f16165f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f16166g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f16167h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f16168i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16169j;

    /* renamed from: k, reason: collision with root package name */
    private Map f16170k;

    public e(String str, String url, int i11, PlayMimeType mimeType, MediaItem mediaItem) {
        Intrinsics.h(url, "url");
        Intrinsics.h(mimeType, "mimeType");
        this.f16160a = str;
        this.f16161b = url;
        this.f16162c = i11;
        this.f16163d = mimeType;
        this.f16164e = mediaItem;
        this.f16166g = LazyKt.b(new Function0() { // from class: ao.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String o11;
                o11 = e.o(e.this);
                return o11;
            }
        });
    }

    public /* synthetic */ e(String str, String str2, int i11, PlayMimeType playMimeType, MediaItem mediaItem, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i12 & 4) != 0 ? -1 : i11, (i12 & 8) != 0 ? PlayMimeType.DEFAULT : playMimeType, (i12 & 16) != 0 ? null : mediaItem);
    }

    private final String b() {
        int o02 = StringsKt.o0(this.f16161b, UrlUtils.QUESTION_MARK, 0, false, 6, null);
        if (o02 < 0) {
            return oo.d.f71195a.a(this.f16161b);
        }
        d.a aVar = oo.d.f71195a;
        String substring = this.f16161b.substring(0, o02);
        Intrinsics.g(substring, "substring(...)");
        return aVar.a(substring);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String o(e eVar) {
        return eVar.b();
    }

    public final boolean c() {
        return this.f16167h;
    }

    public final Map d() {
        return this.f16170k;
    }

    public final String e() {
        return this.f16160a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.c(this.f16160a, eVar.f16160a) && Intrinsics.c(this.f16161b, eVar.f16161b) && this.f16162c == eVar.f16162c && this.f16163d == eVar.f16163d && Intrinsics.c(this.f16164e, eVar.f16164e);
    }

    public final boolean f() {
        return this.f16169j;
    }

    public final String g() {
        return (String) this.f16166g.getValue();
    }

    public final String h() {
        return this.f16165f;
    }

    public int hashCode() {
        String str = this.f16160a;
        int hashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.f16161b.hashCode()) * 31) + this.f16162c) * 31) + this.f16163d.hashCode()) * 31;
        MediaItem mediaItem = this.f16164e;
        return hashCode + (mediaItem != null ? mediaItem.hashCode() : 0);
    }

    public final MediaItem i() {
        return this.f16164e;
    }

    public final PlayMimeType j() {
        return this.f16163d;
    }

    public final String k() {
        return this.f16161b;
    }

    public final int l() {
        return this.f16162c;
    }

    public final boolean m() {
        return this.f16168i;
    }

    public final boolean n() {
        PlayMimeType playMimeType = this.f16163d;
        return playMimeType == PlayMimeType.DASH || playMimeType == PlayMimeType.HLS || StringsKt.c0(this.f16161b, ".mpd", false, 2, null) || StringsKt.c0(this.f16161b, ".m3u8", false, 2, null);
    }

    public final void p(boolean z10) {
        this.f16167h = z10;
    }

    public final void q(Map map) {
        this.f16170k = map;
    }

    public final void r(boolean z10) {
        this.f16169j = z10;
    }

    public final void s(boolean z10) {
        this.f16168i = z10;
    }

    public final void t(String str) {
        this.f16165f = str;
    }

    public String toString() {
        return "MediaSource(id=" + this.f16160a + ", url=" + this.f16161b + ", weights=" + this.f16162c + ", mimeType=" + this.f16163d + ", mediaItem=" + this.f16164e + ")";
    }

    public final void u(PlayMimeType playMimeType) {
        Intrinsics.h(playMimeType, "<set-?>");
        this.f16163d = playMimeType;
    }
}
