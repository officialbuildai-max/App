package i10;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* loaded from: classes7.dex */
public class l implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f64995a;

    /* loaded from: classes7.dex */
    static class a implements i {
        a() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            String[] strArr = (String[]) obj;
            Integer[] numArr = new Integer[strArr.length];
            for (int i11 = 0; i11 < strArr.length; i11++) {
                numArr[i11] = Integer.valueOf(Integer.parseInt(strArr[i11]));
            }
            return numArr;
        }
    }

    /* loaded from: classes7.dex */
    static class b implements i {
        b() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            Object[] objArr = (Object[]) obj;
            Integer[] numArr = new Integer[objArr.length];
            for (int i11 = 0; i11 < objArr.length; i11++) {
                numArr[i11] = Integer.valueOf(Integer.parseInt(String.valueOf(objArr[i11])));
            }
            return numArr;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f64995a = hashMap;
        hashMap.put(String[].class, new a());
        hashMap.put(Object[].class, new b());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f64995a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map map = f64995a;
        if (map.containsKey(obj.getClass())) {
            return ((i) map.get(obj.getClass())).convert(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Boolean.class.getName());
    }
}
