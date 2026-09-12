package i10;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class e implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f64985a;

    /* renamed from: b, reason: collision with root package name */
    private static i f64986b;

    /* loaded from: classes7.dex */
    static class a implements i {
        a() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Byte.valueOf(Byte.parseByte((String) obj));
        }
    }

    /* loaded from: classes7.dex */
    static class b implements i {
        b() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return e.f64986b.convert(String.valueOf(obj));
        }
    }

    /* loaded from: classes7.dex */
    static class c implements i {
        c() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return new Byte(((Byte) obj).byteValue());
        }
    }

    /* loaded from: classes7.dex */
    static class d implements i {
        d() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Byte.valueOf(((Integer) obj).byteValue());
        }
    }

    /* renamed from: i10.e$e, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0811e implements i {
        C0811e() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Byte.valueOf(((Long) obj).byteValue());
        }
    }

    /* loaded from: classes7.dex */
    static class f implements i {
        f() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Byte.valueOf(((Double) obj).byteValue());
        }
    }

    /* loaded from: classes7.dex */
    static class g implements i {
        g() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Byte.valueOf(((Float) obj).byteValue());
        }
    }

    /* loaded from: classes7.dex */
    static class h implements i {
        h() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            return Byte.valueOf(((Short) obj).byteValue());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f64985a = hashMap;
        a aVar = new a();
        f64986b = aVar;
        hashMap.put(String.class, aVar);
        hashMap.put(Object.class, new b());
        hashMap.put(Byte.class, new c());
        hashMap.put(Integer.class, new d());
        hashMap.put(Long.class, new C0811e());
        hashMap.put(Double.class, new f());
        hashMap.put(Float.class, new g());
        hashMap.put(Short.class, new h());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f64985a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f64985a;
        if (map.containsKey(obj.getClass())) {
            return ((i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
