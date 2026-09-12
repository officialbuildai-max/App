package i10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class m implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f64996a;

    /* loaded from: classes7.dex */
    static class a implements i10.i {
        a() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer convert(Object obj) {
            return ((Boolean) obj).booleanValue() ? 1 : 0;
        }
    }

    /* loaded from: classes7.dex */
    static class b implements i10.i {
        b() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer convert(Object obj) {
            return Integer.valueOf(((Character) obj).charValue());
        }
    }

    /* loaded from: classes7.dex */
    static class c implements i10.i {
        c() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            if (((String) obj).length() == 0) {
                return 0;
            }
            return Integer.valueOf(Integer.parseInt(String.valueOf(obj)));
        }
    }

    /* loaded from: classes7.dex */
    static class d implements i10.i {
        d() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer convert(Object obj) {
            return Integer.valueOf(((BigDecimal) obj).intValue());
        }
    }

    /* loaded from: classes7.dex */
    static class e implements i10.i {
        e() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer convert(Object obj) {
            return Integer.valueOf(((BigInteger) obj).intValue());
        }
    }

    /* loaded from: classes7.dex */
    static class f implements i10.i {
        f() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Integer.valueOf(Integer.parseInt((String) obj));
        }
    }

    /* loaded from: classes7.dex */
    static class g implements i10.i {
        g() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Integer.valueOf(((Short) obj).intValue());
        }
    }

    /* loaded from: classes7.dex */
    static class h implements i10.i {
        h() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            Long l11 = (Long) obj;
            if (l11.longValue() <= 2147483647L) {
                return Integer.valueOf(l11.intValue());
            }
            throw new ConversionException("cannot coerce Long to Integer since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* loaded from: classes7.dex */
    static class i implements i10.i {
        i() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            Float f11 = (Float) obj;
            if (f11.floatValue() <= 2.14748365E9f) {
                return Integer.valueOf(f11.intValue());
            }
            throw new ConversionException("cannot coerce Float to Integer since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* loaded from: classes7.dex */
    static class j implements i10.i {
        j() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            Double d11 = (Double) obj;
            if (d11.doubleValue() <= 2.147483647E9d) {
                return Integer.valueOf(d11.intValue());
            }
            throw new ConversionException("cannot coerce Long to Integer since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* loaded from: classes7.dex */
    static class k implements i10.i {
        k() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return obj;
        }
    }

    static {
        HashMap hashMap = new HashMap(10);
        f64996a = hashMap;
        hashMap.put(Object.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(BigInteger.class, new e());
        hashMap.put(String.class, new f());
        hashMap.put(Short.class, new g());
        hashMap.put(Long.class, new h());
        hashMap.put(Float.class, new i());
        hashMap.put(Double.class, new j());
        hashMap.put(Integer.class, new k());
        hashMap.put(Boolean.class, new a());
        hashMap.put(Character.class, new b());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f64996a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f64996a;
        if (map.containsKey(obj.getClass())) {
            return ((i10.i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
