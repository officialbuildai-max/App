package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.o0;

/* loaded from: classes7.dex */
public final class o extends u {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f68476c;

    /* renamed from: d, reason: collision with root package name */
    private final String f68477d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Object body, boolean z10) {
        super(null);
        Intrinsics.h(body, "body");
        this.f68476c = z10;
        this.f68477d = body.toString();
    }

    @Override // kotlinx.serialization.json.u
    public String a() {
        return this.f68477d;
    }

    public boolean c() {
        return this.f68476c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(Reflection.b(o.class), Reflection.b(obj.getClass()))) {
            return false;
        }
        o oVar = (o) obj;
        return c() == oVar.c() && Intrinsics.c(a(), oVar.a());
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(c()) * 31) + a().hashCode();
    }

    @Override // kotlinx.serialization.json.u
    public String toString() {
        if (!c()) {
            return a();
        }
        StringBuilder sb2 = new StringBuilder();
        o0.c(sb2, a());
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
