package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.p0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class o implements p0 {

    /* renamed from: a, reason: collision with root package name */
    private final LazyLayoutItemContentFactory f3139a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f3140b = new LinkedHashMap();

    public o(LazyLayoutItemContentFactory lazyLayoutItemContentFactory) {
        this.f3139a = lazyLayoutItemContentFactory;
    }

    @Override // androidx.compose.ui.layout.p0
    public void a(p0.a aVar) {
        this.f3140b.clear();
        Iterator it = aVar.iterator();
        while (it.hasNext()) {
            Object c11 = this.f3139a.c(it.next());
            Integer num = (Integer) this.f3140b.get(c11);
            int intValue = num != null ? num.intValue() : 0;
            if (intValue == 7) {
                it.remove();
            } else {
                this.f3140b.put(c11, Integer.valueOf(intValue + 1));
            }
        }
    }

    @Override // androidx.compose.ui.layout.p0
    public boolean b(Object obj, Object obj2) {
        return Intrinsics.c(this.f3139a.c(obj), this.f3139a.c(obj2));
    }
}
