package i10;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class d implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f64983a;

    /* renamed from: b, reason: collision with root package name */
    private static i10.i f64984b;

    /* loaded from: classes7.dex */
    static class a implements i10.i {
        a() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((BigDecimal) obj).doubleValue() > 0.0d);
        }
    }

    /* loaded from: classes7.dex */
    static class b implements i10.i {
        b() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            String str = (String) obj;
            return Boolean.valueOf((str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("off") || "0".equals(obj) || "".equals(obj)) ? false : true);
        }
    }

    /* loaded from: classes7.dex */
    static class c implements i10.i {
        c() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return d.f64984b.convert(String.valueOf(obj));
        }
    }

    /* renamed from: i10.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0810d implements i10.i {
        C0810d() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return obj;
        }
    }

    /* loaded from: classes7.dex */
    static class e implements i10.i {
        e() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((Integer) obj).intValue() > 0);
        }
    }

    /* loaded from: classes7.dex */
    static class f implements i10.i {
        f() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((Float) obj).floatValue() > 0.0f);
        }
    }

    /* loaded from: classes7.dex */
    static class g implements i10.i {
        g() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((Double) obj).doubleValue() > 0.0d);
        }
    }

    /* loaded from: classes7.dex */
    static class h implements i10.i {
        h() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((Short) obj).shortValue() > 0);
        }
    }

    /* loaded from: classes7.dex */
    static class i implements i10.i {
        i() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            return Boolean.valueOf(((Long) obj).longValue() > 0);
        }
    }

    /* loaded from: classes7.dex */
    static class j implements i10.i {
        j() {
        }

        @Override // i10.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean convert(Object obj) {
            Boolean bool = (Boolean) obj;
            bool.booleanValue();
            return bool;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f64983a = hashMap;
        b bVar = new b();
        f64984b = bVar;
        hashMap.put(String.class, bVar);
        hashMap.put(Object.class, new c());
        hashMap.put(Boolean.class, new C0810d());
        hashMap.put(Integer.class, new e());
        hashMap.put(Float.class, new f());
        hashMap.put(Double.class, new g());
        hashMap.put(Short.class, new h());
        hashMap.put(Long.class, new i());
        hashMap.put(Boolean.TYPE, new j());
        hashMap.put(BigDecimal.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f64983a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f64983a;
        if (map.containsKey(obj.getClass())) {
            return ((i10.i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Boolean.class.getName());
    }
}
