package androidx.compose.ui;

import androidx.compose.ui.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class CombinedModifier implements f {

    /* renamed from: b, reason: collision with root package name */
    private final f f4158b;

    /* renamed from: c, reason: collision with root package name */
    private final f f4159c;

    public CombinedModifier(f fVar, f fVar2) {
        this.f4158b = fVar;
        this.f4159c = fVar2;
    }

    public final f a() {
        return this.f4159c;
    }

    @Override // androidx.compose.ui.f
    public Object b(Object obj, Function2 function2) {
        return this.f4159c.b(this.f4158b.b(obj, function2), function2);
    }

    @Override // androidx.compose.ui.f
    public boolean c(Function1 function1) {
        return this.f4158b.c(function1) && this.f4159c.c(function1);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ f e(f fVar) {
        return e.a(this, fVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CombinedModifier) {
            CombinedModifier combinedModifier = (CombinedModifier) obj;
            if (Intrinsics.c(this.f4158b, combinedModifier.f4158b) && Intrinsics.c(this.f4159c, combinedModifier.f4159c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f4158b.hashCode() + (this.f4159c.hashCode() * 31);
    }

    public final f i() {
        return this.f4158b;
    }

    public String toString() {
        return '[' + ((String) b("", new Function2<String, f.b, String>() { // from class: androidx.compose.ui.CombinedModifier$toString$1
            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String str, f.b bVar) {
                if (str.length() == 0) {
                    return bVar.toString();
                }
                return str + ", " + bVar;
            }
        })) + ']';
    }
}
