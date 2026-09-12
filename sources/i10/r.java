package i10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class r implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Short f64999a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final Short f65000b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static i10.i f65001c = new b();

    /* renamed from: d, reason: collision with root package name */
    private static final Map f65002d;

    /* loaded from: classes7.dex */
    static class a implements i10.i {
        a() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            return ((Boolean) obj).booleanValue() ? r.f64999a : r.f65000b;
        }
    }

    /* loaded from: classes7.dex */
    static class b implements i10.i {
        b() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            return Short.valueOf(Short.parseShort((String) obj));
        }
    }

    /* loaded from: classes7.dex */
    static class c implements i10.i {
        c() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return r.f65001c.convert(String.valueOf(obj));
        }
    }

    /* loaded from: classes7.dex */
    static class d implements i10.i {
        d() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            return Short.valueOf(((BigDecimal) obj).shortValue());
        }
    }

    /* loaded from: classes7.dex */
    static class e implements i10.i {
        e() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            return Short.valueOf(((BigInteger) obj).shortValue());
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
        public Short convert(Object obj) {
            Integer num = (Integer) obj;
            if (num.intValue() <= 32767) {
                return Short.valueOf(num.shortValue());
            }
            throw new ConversionException("cannot coerce Integer to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* loaded from: classes7.dex */
    static class h implements i10.i {
        h() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            Float f11 = (Float) obj;
            if (f11.floatValue() <= 32767.0f) {
                return Short.valueOf(f11.shortValue());
            }
            throw new ConversionException("cannot coerce Float to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* loaded from: classes7.dex */
    static class i implements i10.i {
        i() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            Double d11 = (Double) obj;
            if (d11.doubleValue() <= 32767.0d) {
                return Short.valueOf(d11.shortValue());
            }
            throw new ConversionException("cannot coerce Double to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* loaded from: classes7.dex */
    static class j implements i10.i {
        j() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short convert(Object obj) {
            Long l11 = (Long) obj;
            if (l11.longValue() <= 32767) {
                return Short.valueOf(l11.shortValue());
            }
            throw new ConversionException("cannot coerce Integer to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f65002d = hashMap;
        hashMap.put(String.class, f65001c);
        hashMap.put(Object.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(BigInteger.class, new e());
        hashMap.put(Short.class, new f());
        hashMap.put(Integer.class, new g());
        hashMap.put(Float.class, new h());
        hashMap.put(Double.class, new i());
        hashMap.put(Long.class, new j());
        hashMap.put(Boolean.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f65002d.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f65002d;
        if (map.containsKey(obj.getClass())) {
            return ((i10.i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Short.class.getName());
    }
}
