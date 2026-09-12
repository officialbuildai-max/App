package i10;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class s implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f65003a;

    /* loaded from: classes7.dex */
    static class a implements i {
        a() {
        }

        @Override // i10.i
        public Object convert(Object obj) {
            Object[] objArr = (Object[]) obj;
            String[] strArr = new String[objArr.length];
            for (int i11 = 0; i11 < objArr.length; i11++) {
                strArr[i11] = String.valueOf(objArr[i11]);
            }
            return strArr;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f65003a = hashMap;
        hashMap.put(Object[].class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f65003a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        if (!obj.getClass().isArray()) {
            return new String[]{String.valueOf(obj)};
        }
        Object[] objArr = (Object[]) obj;
        String[] strArr = new String[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            strArr[i11] = String.valueOf(objArr[i11]);
        }
        return strArr;
    }
}
