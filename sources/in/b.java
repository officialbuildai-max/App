package in;

import androidx.compose.foundation.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f65391a;

    /* renamed from: b, reason: collision with root package name */
    private final String f65392b;

    /* renamed from: c, reason: collision with root package name */
    private final int f65393c;

    public b(boolean z10, String str, int i11) {
        this.f65391a = z10;
        this.f65392b = str;
        this.f65393c = i11;
    }

    public final String a() {
        return this.f65392b;
    }

    public final int b() {
        return this.f65393c;
    }

    public final boolean c() {
        return this.f65391a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f65391a == bVar.f65391a && Intrinsics.c(this.f65392b, bVar.f65392b) && this.f65393c == bVar.f65393c;
    }

    public int hashCode() {
        int a11 = e.a(this.f65391a) * 31;
        String str = this.f65392b;
        return ((a11 + (str == null ? 0 : str.hashCode())) * 31) + this.f65393c;
    }

    public String toString() {
        return "CommentLikeEvent(result=" + this.f65391a + ", commentId=" + this.f65392b + ", likeCount=" + this.f65393c + ")";
    }
}
