package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class d1 {

    /* renamed from: a, reason: collision with root package name */
    private static final Class f8823a = A();

    /* renamed from: b, reason: collision with root package name */
    private static final h1 f8824b = B();

    /* renamed from: c, reason: collision with root package name */
    private static final h1 f8825c = new j1();

    private static Class A() {
        if (x0.f9013d) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static h1 B() {
        try {
            Class C = C();
            if (C == null) {
                return null;
            }
            return (h1) C.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class C() {
        if (x0.f9013d) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void D(p pVar, Object obj, Object obj2) {
        s c11 = pVar.c(obj2);
        if (c11.k()) {
            return;
        }
        pVar.d(obj).r(c11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void E(i0 i0Var, Object obj, Object obj2, long j11) {
        k1.W(obj, j11, i0Var.mergeFrom(k1.G(obj, j11), k1.G(obj2, j11)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void F(h1 h1Var, Object obj, Object obj2) {
        h1Var.p(obj, h1Var.k(h1Var.g(obj), h1Var.g(obj2)));
    }

    public static void G(Class cls) {
        Class cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && !x0.f9013d && (cls2 = f8823a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean H(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object I(Object obj, int i11, int i12, Object obj2, h1 h1Var) {
        if (obj2 == null) {
            obj2 = h1Var.f(obj);
        }
        h1Var.e(obj2, i11, i12);
        return obj2;
    }

    public static h1 J() {
        return f8824b;
    }

    public static h1 K() {
        return f8825c;
    }

    public static void L(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBoolList(i11, list, z10);
    }

    public static void M(int i11, List list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBytesList(i11, list);
    }

    public static void N(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeDoubleList(i11, list, z10);
    }

    public static void O(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeEnumList(i11, list, z10);
    }

    public static void P(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed32List(i11, list, z10);
    }

    public static void Q(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed64List(i11, list, z10);
    }

    public static void R(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFloatList(i11, list, z10);
    }

    public static void S(int i11, List list, Writer writer, b1 b1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.a(i11, list, b1Var);
    }

    public static void T(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt32List(i11, list, z10);
    }

    public static void U(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt64List(i11, list, z10);
    }

    public static void V(int i11, List list, Writer writer, b1 b1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.f(i11, list, b1Var);
    }

    public static void W(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed32List(i11, list, z10);
    }

    public static void X(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed64List(i11, list, z10);
    }

    public static void Y(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt32List(i11, list, z10);
    }

    public static void Z(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt64List(i11, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? CodedOutputStream.S(i11) + CodedOutputStream.C(size) : size * CodedOutputStream.e(i11, true);
    }

    public static void a0(int i11, List list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeStringList(i11, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List list) {
        return list.size();
    }

    public static void b0(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt32List(i11, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i11, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int S = size * CodedOutputStream.S(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            S += CodedOutputStream.i((ByteString) list.get(i12));
        }
        return S;
    }

    public static void c0(int i11, List list, Writer writer, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt64List(i11, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e11 = e(list);
        return z10 ? CodedOutputStream.S(i11) + CodedOutputStream.C(e11) : e11 + (size * CodedOutputStream.S(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.m(vVar.getInt(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.m(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? CodedOutputStream.S(i11) + CodedOutputStream.C(size * 4) : size * CodedOutputStream.n(i11, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? CodedOutputStream.S(i11) + CodedOutputStream.C(size * 8) : size * CodedOutputStream.p(i11, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i11, List list, b1 b1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += CodedOutputStream.t(i11, (n0) list.get(i13), b1Var);
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l11 = l(list);
        return z10 ? CodedOutputStream.S(i11) + CodedOutputStream.C(l11) : l11 + (size * CodedOutputStream.S(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.x(vVar.getInt(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.x(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i11, List list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        int n11 = n(list);
        return z10 ? CodedOutputStream.S(i11) + CodedOutputStream.C(n11) : n11 + (list.size() * CodedOutputStream.S(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.z(f0Var.getLong(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.z(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i11, Object obj, b1 b1Var) {
        return obj instanceof a0 ? CodedOutputStream.A(i11, (a0) obj) : CodedOutputStream.D(i11, (n0) obj, b1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i11, List list, b1 b1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int S = CodedOutputStream.S(i11) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            S += obj instanceof a0 ? CodedOutputStream.B((a0) obj) : CodedOutputStream.F((n0) obj, b1Var);
        }
        return S;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r11 = r(list);
        return z10 ? CodedOutputStream.S(i11) + CodedOutputStream.C(r11) : r11 + (size * CodedOutputStream.S(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.N(vVar.getInt(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.N(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t11 = t(list);
        return z10 ? CodedOutputStream.S(i11) + CodedOutputStream.C(t11) : t11 + (size * CodedOutputStream.S(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.P(f0Var.getLong(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.P(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i11, List list) {
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        int S = CodedOutputStream.S(i11) * size;
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            while (i12 < size) {
                Object raw = b0Var.getRaw(i12);
                S += raw instanceof ByteString ? CodedOutputStream.i((ByteString) raw) : CodedOutputStream.R((String) raw);
                i12++;
            }
        } else {
            while (i12 < size) {
                Object obj = list.get(i12);
                S += obj instanceof ByteString ? CodedOutputStream.i((ByteString) obj) : CodedOutputStream.R((String) obj);
                i12++;
            }
        }
        return S;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w11 = w(list);
        return z10 ? CodedOutputStream.S(i11) + CodedOutputStream.C(w11) : w11 + (size * CodedOutputStream.S(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.U(vVar.getInt(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.U(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y10 = y(list);
        return z10 ? CodedOutputStream.S(i11) + CodedOutputStream.C(y10) : y10 + (size * CodedOutputStream.S(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.W(f0Var.getLong(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.W(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object z(Object obj, int i11, List list, w.c cVar, Object obj2, h1 h1Var) {
        if (cVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                Integer num = (Integer) list.get(i13);
                int intValue = num.intValue();
                if (cVar.isInRange(intValue)) {
                    if (i13 != i12) {
                        list.set(i12, num);
                    }
                    i12++;
                } else {
                    obj2 = I(obj, i11, intValue, obj2, h1Var);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!cVar.isInRange(intValue2)) {
                    obj2 = I(obj, i11, intValue2, obj2, h1Var);
                    it.remove();
                }
            }
        }
        return obj2;
    }
}
