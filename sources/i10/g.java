package i10;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class g implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f64988a;

    /* renamed from: b, reason: collision with root package name */
    private static final i f64989b;

    /* loaded from: classes7.dex */
    static class a implements i {
        a() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            String str = (String) obj;
            if (str.length() <= 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new ConversionException("cannot convert a string with a length greater than 1 to java.lang.Character");
        }
    }

    /* loaded from: classes7.dex */
    static class b implements i {
        b() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return g.f64989b.convert(String.valueOf(obj));
        }
    }

    /* loaded from: classes7.dex */
    static class c implements i {
        c() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return new Character(((Character) obj).charValue());
        }
    }

    /* loaded from: classes7.dex */
    static class d implements i {
        d() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Character.valueOf((char) ((BigDecimal) obj).intValue());
        }
    }

    /* loaded from: classes7.dex */
    static class e implements i {
        e() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Character.valueOf((char) ((Integer) obj).intValue());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f64988a = hashMap;
        a aVar = new a();
        f64989b = aVar;
        hashMap.put(String.class, aVar);
        hashMap.put(Object.class, new b());
        hashMap.put(Character.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(Integer.class, new e());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f64988a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f64988a;
        if (map.containsKey(obj.getClass())) {
            return ((i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
