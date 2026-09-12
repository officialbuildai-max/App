package go;

import androidx.compose.foundation.e;
import com.transsion.player.longvideo.constants.LongVodPlayerConfigType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f64036a;

    /* renamed from: b, reason: collision with root package name */
    private final String f64037b;

    /* renamed from: c, reason: collision with root package name */
    private final LongVodPlayerConfigType f64038c;

    public b() {
        this(false, null, null, 7, null);
    }

    public b(boolean z10, String content, LongVodPlayerConfigType configType) {
        Intrinsics.h(content, "content");
        Intrinsics.h(configType, "configType");
        this.f64036a = z10;
        this.f64037b = content;
        this.f64038c = configType;
    }

    public /* synthetic */ b(boolean z10, String str, LongVodPlayerConfigType longVodPlayerConfigType, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? LongVodPlayerConfigType.BITRATE : longVodPlayerConfigType);
    }

    public static /* synthetic */ b b(b bVar, boolean z10, String str, LongVodPlayerConfigType longVodPlayerConfigType, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = bVar.f64036a;
        }
        if ((i11 & 2) != 0) {
            str = bVar.f64037b;
        }
        if ((i11 & 4) != 0) {
            longVodPlayerConfigType = bVar.f64038c;
        }
        return bVar.a(z10, str, longVodPlayerConfigType);
    }

    public final b a(boolean z10, String content, LongVodPlayerConfigType configType) {
        Intrinsics.h(content, "content");
        Intrinsics.h(configType, "configType");
        return new b(z10, content, configType);
    }

    public final LongVodPlayerConfigType c() {
        return this.f64038c;
    }

    public final String d() {
        return this.f64037b;
    }

    public final boolean e() {
        return this.f64036a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f64036a == bVar.f64036a && Intrinsics.c(this.f64037b, bVar.f64037b) && this.f64038c == bVar.f64038c;
    }

    public final void f(boolean z10) {
        this.f64036a = z10;
    }

    public int hashCode() {
        return (((e.a(this.f64036a) * 31) + this.f64037b.hashCode()) * 31) + this.f64038c.hashCode();
    }

    public String toString() {
        return "LongVdPlayerConfigBean(isSelected=" + this.f64036a + ", content=" + this.f64037b + ", configType=" + this.f64038c + ")";
    }
}
