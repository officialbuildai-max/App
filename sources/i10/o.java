package i10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class o implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f64997a;

    /* renamed from: b, reason: collision with root package name */
    private static i10.i f64998b;

    /* loaded from: classes7.dex */
    static class a implements i10.i {
        a() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long convert(Object obj) {
            return ((Boolean) obj).booleanValue() ? 1L : 0L;
        }
    }

    /* loaded from: classes7.dex */
    static class b implements i10.i {
        b() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            String str = (String) obj;
            if (str.length() == 0) {
                return 0L;
            }
            return Long.valueOf(Long.parseLong(str));
        }
    }

    /* loaded from: classes7.dex */
    static class c implements i10.i {
        c() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return o.f64998b.convert(String.valueOf(obj));
        }
    }

    /* loaded from: classes7.dex */
    static class d implements i10.i {
        d() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long convert(Object obj) {
            return Long.valueOf(((BigDecimal) obj).longValue());
        }
    }

    /* loaded from: classes7.dex */
    static class e implements i10.i {
        e() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long convert(Object obj) {
            return Long.valueOf(((BigInteger) obj).longValue());
        }
    }

    /* loaded from: classes7.dex */
    static class f implements i10.i {
        f() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Long.valueOf(((Short) obj).longValue());
        }
    }

    /* loaded from: classes7.dex */
    static class g implements i10.i {
        g() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return new Long(((Long) obj).longValue());
        }
    }

    /* loaded from: classes7.dex */
    static class h implements i10.i {
        h() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Long.valueOf(((Integer) obj).longValue());
        }
    }

    /* loaded from: classes7.dex */
    static class i implements i10.i {
        i() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Long.valueOf(((Double) obj).longValue());
        }
    }

    /* loaded from: classes7.dex */
    static class j implements i10.i {
        j() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Long.valueOf(((Float) obj).longValue());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f64997a = hashMap;
        b bVar = new b();
        f64998b = bVar;
        hashMap.put(String.class, bVar);
        hashMap.put(Object.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(BigInteger.class, new e());
        hashMap.put(Short.class, new f());
        hashMap.put(Long.class, new g());
        hashMap.put(Integer.class, new h());
        hashMap.put(Double.class, new i());
        hashMap.put(Float.class, new j());
        hashMap.put(Boolean.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f64997a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f64997a;
        if (map.containsKey(obj.getClass())) {
            return ((i10.i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Long.class.getName());
    }
}
