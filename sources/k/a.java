package k;

import java.util.HashMap;
import java.util.Map;
import k.b;

/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: e, reason: collision with root package name */
    private final HashMap f66578e = new HashMap();

    @Override // k.b
    protected b.c b(Object obj) {
        return (b.c) this.f66578e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.f66578e.containsKey(obj);
    }

    @Override // k.b
    public Object g(Object obj, Object obj2) {
        b.c b11 = b(obj);
        if (b11 != null) {
            return b11.f66584b;
        }
        this.f66578e.put(obj, f(obj, obj2));
        return null;
    }

    @Override // k.b
    public Object h(Object obj) {
        Object h11 = super.h(obj);
        this.f66578e.remove(obj);
        return h11;
    }

    public Map.Entry j(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f66578e.get(obj)).f66586d;
        }
        return null;
    }
}
