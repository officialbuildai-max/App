package bo;

import androidx.compose.foundation.e;
import com.transsion.player.config.PlayerType;
import com.transsion.player.p007enum.ScaleMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final d f16715a;

    /* renamed from: b, reason: collision with root package name */
    private final PlayerType f16716b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f16717c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f16718d;

    /* renamed from: e, reason: collision with root package name */
    private final float f16719e;

    /* renamed from: f, reason: collision with root package name */
    private final ScaleMode f16720f;

    public a(d vodConfig, PlayerType playerType, boolean z10, boolean z11, float f11, ScaleMode scaleMode) {
        Intrinsics.h(vodConfig, "vodConfig");
        Intrinsics.h(playerType, "playerType");
        Intrinsics.h(scaleMode, "scaleMode");
        this.f16715a = vodConfig;
        this.f16716b = playerType;
        this.f16717c = z10;
        this.f16718d = z11;
        this.f16719e = f11;
        this.f16720f = scaleMode;
    }

    public /* synthetic */ a(d dVar, PlayerType playerType, boolean z10, boolean z11, float f11, ScaleMode scaleMode, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, (i11 & 2) != 0 ? PlayerType.EXO : playerType, (i11 & 4) != 0 ? true : z10, (i11 & 8) != 0 ? true : z11, f11, scaleMode);
    }

    public final ScaleMode a() {
        return this.f16720f;
    }

    public final float b() {
        return this.f16719e;
    }

    public final boolean c() {
        return this.f16718d;
    }

    public final d d() {
        return this.f16715a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f16715a, aVar.f16715a) && this.f16716b == aVar.f16716b && this.f16717c == aVar.f16717c && this.f16718d == aVar.f16718d && Float.compare(this.f16719e, aVar.f16719e) == 0 && this.f16720f == aVar.f16720f;
    }

    public int hashCode() {
        return (((((((((this.f16715a.hashCode() * 31) + this.f16716b.hashCode()) * 31) + e.a(this.f16717c)) * 31) + e.a(this.f16718d)) * 31) + Float.floatToIntBits(this.f16719e)) * 31) + this.f16720f.hashCode();
    }

    public String toString() {
        return "LongVodConfig(vodConfig=" + this.f16715a + ", playerType=" + this.f16716b + ", openMediaNotification=" + this.f16717c + ", useSurface=" + this.f16718d + ", speed=" + this.f16719e + ", scaleMode=" + this.f16720f + ")";
    }
}
