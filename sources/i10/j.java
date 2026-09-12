package i10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class j implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f64991a;

    /* renamed from: b, reason: collision with root package name */
    private static i10.i f64992b;

    /* loaded from: classes7.dex */
    static class a implements i10.i {
        a() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return ((Boolean) obj).booleanValue() ? Double.valueOf(1.0d) : Double.valueOf(0.0d);
        }
    }

    /* loaded from: classes7.dex */
    static class b implements i10.i {
        b() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            String str = (String) obj;
            return str.length() == 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.parseDouble(str));
        }
    }

    /* loaded from: classes7.dex */
    static class c implements i10.i {
        c() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return j.f64992b.convert(String.valueOf(obj));
        }
    }

    /* loaded from: classes7.dex */
    static class d implements i10.i {
        d() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return Double.valueOf(((BigDecimal) obj).doubleValue());
        }
    }

    /* loaded from: classes7.dex */
    static class e implements i10.i {
        e() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return Double.valueOf(((BigInteger) obj).doubleValue());
        }
    }

    /* loaded from: classes7.dex */
    static class f implements i10.i {
        f() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return obj;
        }
    }

    /* loaded from: classes7.dex */
    static class g implements i10.i {
        g() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            Float f11 = (Float) obj;
            if (f11.floatValue() <= Double.MAX_VALUE) {
                return Double.valueOf(f11.doubleValue());
            }
            throw new ConversionException("cannot coerce Float to Double since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Double.");
        }
    }

    /* loaded from: classes7.dex */
    static class h implements i10.i {
        h() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
    }

    /* loaded from: classes7.dex */
    static class i implements i10.i {
        i() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return Double.valueOf(((Short) obj).doubleValue());
        }
    }

    /* renamed from: i10.j$j, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0812j implements i10.i {
        C0812j() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double convert(Object obj) {
            return Double.valueOf(((Long) obj).doubleValue());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f64991a = hashMap;
        b bVar = new b();
        f64992b = bVar;
        hashMap.put(String.class, bVar);
        hashMap.put(Object.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(BigInteger.class, new e());
        hashMap.put(Double.class, new f());
        hashMap.put(Float.class, new g());
        hashMap.put(Integer.class, new h());
        hashMap.put(Short.class, new i());
        hashMap.put(Long.class, new C0812j());
        hashMap.put(Boolean.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f64991a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f64991a;
        if (map.containsKey(obj.getClass())) {
            return ((i10.i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
