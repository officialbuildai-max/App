package i10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class b implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f64981a;

    /* loaded from: classes7.dex */
    static class a implements i10.i {
        a() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal((String) obj, MathContext.DECIMAL128);
        }
    }

    /* renamed from: i10.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0808b implements i10.i {
        C0808b() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal((char[]) obj, MathContext.DECIMAL128);
        }
    }

    /* loaded from: classes7.dex */
    static class c implements i10.i {
        c() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(String.valueOf(obj), MathContext.DECIMAL128);
        }
    }

    /* loaded from: classes7.dex */
    static class d implements i10.i {
        d() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return (BigDecimal) obj;
        }
    }

    /* loaded from: classes7.dex */
    static class e implements i10.i {
        e() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((BigInteger) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    /* loaded from: classes7.dex */
    static class f implements i10.i {
        f() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal((String) obj, MathContext.DECIMAL128);
        }
    }

    /* loaded from: classes7.dex */
    static class g implements i10.i {
        g() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((Double) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    /* loaded from: classes7.dex */
    static class h implements i10.i {
        h() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((Float) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    /* loaded from: classes7.dex */
    static class i implements i10.i {
        i() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((Short) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    /* loaded from: classes7.dex */
    static class j implements i10.i {
        j() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((Long) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    /* loaded from: classes7.dex */
    static class k implements i10.i {
        k() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal convert(Object obj) {
            return new BigDecimal(((Integer) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f64981a = hashMap;
        hashMap.put(Object.class, new c());
        hashMap.put(BigDecimal.class, new d());
        hashMap.put(BigInteger.class, new e());
        hashMap.put(String.class, new f());
        hashMap.put(Double.class, new g());
        hashMap.put(Float.class, new h());
        hashMap.put(Short.class, new i());
        hashMap.put(Long.class, new j());
        hashMap.put(Integer.class, new k());
        hashMap.put(String.class, new a());
        hashMap.put(char[].class, new C0808b());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f64981a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f64981a;
        if (map.containsKey(obj.getClass())) {
            return ((i10.i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
