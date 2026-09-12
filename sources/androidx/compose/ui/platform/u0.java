package androidx.compose.ui.platform;

import androidx.compose.runtime.saveable.b;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class u0 implements androidx.compose.runtime.saveable.b {

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f5938a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ androidx.compose.runtime.saveable.b f5939b;

    public u0(androidx.compose.runtime.saveable.b bVar, Function0 function0) {
        this.f5938a = function0;
        this.f5939b = bVar;
    }

    @Override // androidx.compose.runtime.saveable.b
    public boolean a(Object obj) {
        return this.f5939b.a(obj);
    }

    @Override // androidx.compose.runtime.saveable.b
    public b.a b(String str, Function0 function0) {
        return this.f5939b.b(str, function0);
    }

    public final void c() {
        this.f5938a.invoke();
    }

    @Override // androidx.compose.runtime.saveable.b
    public Map e() {
        return this.f5939b.e();
    }

    @Override // androidx.compose.runtime.saveable.b
    public Object f(String str) {
        return this.f5939b.f(str);
    }
}
