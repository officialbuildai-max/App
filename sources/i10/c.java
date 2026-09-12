package i10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class c implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f64982a;

    /* loaded from: classes7.dex */
    static class a implements i10.i {
        a() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    /* loaded from: classes7.dex */
    static class b implements i10.i {
        b() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return (BigInteger) obj;
        }
    }

    /* renamed from: i10.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0809c implements i10.i {
        C0809c() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return ((BigDecimal) obj).toBigInteger();
        }
    }

    /* loaded from: classes7.dex */
    static class d implements i10.i {
        d() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger((String) obj);
        }
    }

    /* loaded from: classes7.dex */
    static class e implements i10.i {
        e() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    /* loaded from: classes7.dex */
    static class f implements i10.i {
        f() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    /* loaded from: classes7.dex */
    static class g implements i10.i {
        g() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    /* loaded from: classes7.dex */
    static class h implements i10.i {
        h() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger((String) obj);
        }
    }

    /* loaded from: classes7.dex */
    static class i implements i10.i {
        i() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger convert(Object obj) {
            return new BigInteger(new String((char[]) obj));
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f64982a = hashMap;
        hashMap.put(Object.class, new a());
        hashMap.put(BigInteger.class, new b());
        hashMap.put(BigDecimal.class, new C0809c());
        hashMap.put(String.class, new d());
        hashMap.put(Short.class, new e());
        hashMap.put(Long.class, new f());
        hashMap.put(Integer.class, new g());
        hashMap.put(String.class, new h());
        hashMap.put(char[].class, new i());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f64982a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f64982a;
        if (map.containsKey(obj.getClass())) {
            return ((i10.i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
