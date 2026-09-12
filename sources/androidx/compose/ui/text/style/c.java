package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.u1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements l {

    /* renamed from: b, reason: collision with root package name */
    private final long f6436b;

    private c(long j11) {
        this.f6436b = j11;
        if (j11 == 16) {
            throw new IllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
        }
    }

    public /* synthetic */ c(long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11);
    }

    @Override // androidx.compose.ui.text.style.l
    public long a() {
        return this.f6436b;
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
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && u1.m(this.f6436b, ((c) obj).f6436b);
    }

    @Override // androidx.compose.ui.text.style.l
    public float getAlpha() {
        return u1.n(a());
    }

    public int hashCode() {
        return u1.s(this.f6436b);
    }

    public String toString() {
        return "ColorStyle(value=" + ((Object) u1.t(this.f6436b)) + ')';
    }
}
