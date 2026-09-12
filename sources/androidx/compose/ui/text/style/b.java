package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.y4;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements l {

    /* renamed from: b, reason: collision with root package name */
    private final y4 f6434b;

    /* renamed from: c, reason: collision with root package name */
    private final float f6435c;

    public b(y4 y4Var, float f11) {
        this.f6434b = y4Var;
        this.f6435c = f11;
    }

    @Override // androidx.compose.ui.text.style.l
    public long a() {
        return u1.f4733b.e();
    }

    @Override // androidx.compose.ui.text.style.l
    public /* synthetic */ l b(Function0 function0) {
        return TextForegroundStyle$CC.b(this, function0);
    }

    @Override // androidx.compose.ui.text.style.l
    public /* synthetic */ l c(l lVar) {
        return TextForegroundStyle$CC.a(this, lVar);
    }

    @Override // androidx.compose.ui.text.style.l
    public j1 d() {
        return this.f6434b;
    }

    public final y4 e() {
        return this.f6434b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f6434b, bVar.f6434b) && Float.compare(this.f6435c, bVar.f6435c) == 0;
    }

    @Override // androidx.compose.ui.text.style.l
    public float getAlpha() {
        return this.f6435c;
    }

    public int hashCode() {
        return (this.f6434b.hashCode() * 31) + Float.floatToIntBits(this.f6435c);
    }

    public String toString() {
        return "BrushStyle(value=" + this.f6434b + ", alpha=" + this.f6435c + ')';
    }
}
