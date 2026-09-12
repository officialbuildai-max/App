package u;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c extends b implements Map.Entry, KMutableMap.Entry {

    /* renamed from: c, reason: collision with root package name */
    private final i f76612c;

    /* renamed from: d, reason: collision with root package name */
    private Object f76613d;

    public c(i iVar, Object obj, Object obj2) {
        super(obj, obj2);
        this.f76612c = iVar;
        this.f76613d = obj2;
    }

    public void a(Object obj) {
        this.f76613d = obj;
    }

    @Override // u.b, java.util.Map.Entry
    public Object getValue() {
        return this.f76613d;
    }

    @Override // u.b, java.util.Map.Entry
    public Object setValue(Object obj) {
        Object value = getValue();
        a(obj);
        this.f76612c.c(getKey(), obj);
        return value;
    }
}
