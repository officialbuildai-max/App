package i10;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class f implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f64987a;

    /* loaded from: classes7.dex */
    static class a implements i {
        a() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return ((String) obj).toCharArray();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f64987a = hashMap;
        hashMap.put(String.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f64987a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f64987a;
        if (map.containsKey(obj.getClass())) {
            return ((i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Boolean.class.getName());
    }
}
