package mo;

import androidx.compose.foundation.e;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f69792a;

    /* renamed from: b, reason: collision with root package name */
    private final String f69793b;

    /* renamed from: c, reason: collision with root package name */
    private final int f69794c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f69795d;

    /* renamed from: e, reason: collision with root package name */
    private final b[] f69796e;

    public d(int i11, String str, int i12, boolean z10, b[] formats) {
        Intrinsics.h(formats, "formats");
        this.f69792a = i11;
        this.f69793b = str;
        this.f69794c = i12;
        this.f69795d = z10;
        this.f69796e = formats;
    }

    public final boolean a() {
        return this.f69795d;
    }

    public final b[] b() {
        return this.f69796e;
    }

    public final String c() {
        return this.f69793b;
    }

    public final int d() {
        return this.f69792a;
    }

    public final int e() {
        return this.f69794c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f69792a == dVar.f69792a && Intrinsics.c(this.f69793b, dVar.f69793b) && this.f69794c == dVar.f69794c && this.f69795d == dVar.f69795d && Intrinsics.c(this.f69796e, dVar.f69796e);
    }

    public int hashCode() {
        int i11 = this.f69792a * 31;
        String str = this.f69793b;
        return ((((((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.f69794c) * 31) + e.a(this.f69795d)) * 31) + Arrays.hashCode(this.f69796e);
    }

    public String toString() {
        return "TnTracksGroup(length=" + this.f69792a + ", id=" + this.f69793b + ", type=" + this.f69794c + ", adaptiveSupported=" + this.f69795d + ", formats=" + Arrays.toString(this.f69796e) + ")";
    }
}
