package androidx.compose.foundation;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.x0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private e4 f2691a;

    /* renamed from: b, reason: collision with root package name */
    private m1 f2692b;

    /* renamed from: c, reason: collision with root package name */
    private z.a f2693c;

    /* renamed from: d, reason: collision with root package name */
    private Path f2694d;

    public c() {
        this(null, null, null, null, 15, null);
    }

    public c(e4 e4Var, m1 m1Var, z.a aVar, Path path) {
        this.f2691a = e4Var;
        this.f2692b = m1Var;
        this.f2693c = aVar;
        this.f2694d = path;
    }

    public /* synthetic */ c(e4 e4Var, m1 m1Var, z.a aVar, Path path, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : e4Var, (i11 & 2) != 0 ? null : m1Var, (i11 & 4) != 0 ? null : aVar, (i11 & 8) != 0 ? null : path);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.f2691a, cVar.f2691a) && Intrinsics.c(this.f2692b, cVar.f2692b) && Intrinsics.c(this.f2693c, cVar.f2693c) && Intrinsics.c(this.f2694d, cVar.f2694d);
    }

    public final Path g() {
        Path path = this.f2694d;
        if (path != null) {
            return path;
        }
        Path a11 = x0.a();
        this.f2694d = a11;
        return a11;
    }

    public int hashCode() {
        e4 e4Var = this.f2691a;
        int hashCode = (e4Var == null ? 0 : e4Var.hashCode()) * 31;
        m1 m1Var = this.f2692b;
        int hashCode2 = (hashCode + (m1Var == null ? 0 : m1Var.hashCode())) * 31;
        z.a aVar = this.f2693c;
        int hashCode3 = (hashCode2 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        Path path = this.f2694d;
        return hashCode3 + (path != null ? path.hashCode() : 0);
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.f2691a + ", canvas=" + this.f2692b + ", canvasDrawScope=" + this.f2693c + ", borderPath=" + this.f2694d + ')';
    }
}
