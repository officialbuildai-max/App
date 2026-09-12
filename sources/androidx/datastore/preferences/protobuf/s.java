package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class s {

    /* renamed from: d, reason: collision with root package name */
    private static final s f8988d = new s(true);

    /* renamed from: a, reason: collision with root package name */
    private final e1 f8989a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8990b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8991c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8992a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f8993b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f8993b = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8993b[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8993b[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8993b[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8993b[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8993b[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8993b[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8993b[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8993b[WireFormat.FieldType.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8993b[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8993b[WireFormat.FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8993b[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f8993b[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f8993b[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f8993b[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f8993b[WireFormat.FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f8993b[WireFormat.FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f8993b[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f8992a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f8992a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f8992a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f8992a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f8992a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f8992a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f8992a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f8992a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f8992a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b extends Comparable {
        WireFormat.FieldType getLiteType();

        int getNumber();

        boolean isPacked();

        boolean isRepeated();
    }

    private s() {
        this.f8989a = e1.s();
    }

    private s(e1 e1Var) {
        this.f8989a = e1Var;
        q();
    }

    private s(boolean z10) {
        this(e1.s());
        q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(WireFormat.FieldType fieldType, int i11, Object obj) {
        int S = CodedOutputStream.S(i11);
        if (fieldType == WireFormat.FieldType.GROUP) {
            S *= 2;
        }
        return S + c(fieldType, obj);
    }

    static int c(WireFormat.FieldType fieldType, Object obj) {
        switch (a.f8993b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.k(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.s(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.z(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.W(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.x(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.q(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.o(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.f(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.u((n0) obj);
            case 10:
                return CodedOutputStream.E((n0) obj);
            case 11:
                return obj instanceof ByteString ? CodedOutputStream.i((ByteString) obj) : CodedOutputStream.R((String) obj);
            case 12:
                return obj instanceof ByteString ? CodedOutputStream.i((ByteString) obj) : CodedOutputStream.g((byte[]) obj);
            case 13:
                return CodedOutputStream.U(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.J(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.L(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.N(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.P(((Long) obj).longValue());
            case 18:
                return obj instanceof w.a ? CodedOutputStream.m(((w.a) obj).getNumber()) : CodedOutputStream.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(b bVar, Object obj) {
        WireFormat.FieldType liteType = bVar.getLiteType();
        int number = bVar.getNumber();
        if (!bVar.isRepeated()) {
            return b(liteType, number, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i11 = 0;
        if (!bVar.isPacked()) {
            int i12 = 0;
            while (i11 < size) {
                i12 += b(liteType, number, list.get(i11));
                i11++;
            }
            return i12;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int i13 = 0;
        while (i11 < size) {
            i13 += c(liteType, list.get(i11));
            i11++;
        }
        return CodedOutputStream.S(number) + i13 + CodedOutputStream.U(i13);
    }

    public static s f() {
        return f8988d;
    }

    private int h(Map.Entry entry) {
        android.support.v4.media.session.c.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    static int j(WireFormat.FieldType fieldType, boolean z10) {
        if (z10) {
            return 2;
        }
        return fieldType.getWireType();
    }

    private static boolean n(Map.Entry entry) {
        android.support.v4.media.session.c.a(entry.getKey());
        throw null;
    }

    private static boolean o(WireFormat.FieldType fieldType, Object obj) {
        w.a(obj);
        switch (a.f8992a[fieldType.getJavaType().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                return (obj instanceof ByteString) || (obj instanceof byte[]);
            case 8:
                return (obj instanceof Integer) || (obj instanceof w.a);
            case 9:
                return obj instanceof n0;
            default:
                return false;
        }
    }

    private void s(Map.Entry entry) {
        android.support.v4.media.session.c.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public static s t() {
        return new s();
    }

    private void v(b bVar, Object obj) {
        if (!o(bVar.getLiteType(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.getNumber()), bVar.getLiteType().getJavaType(), obj.getClass().getName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i11, Object obj) {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.x0(i11, (n0) obj);
        } else {
            codedOutputStream.T0(i11, j(fieldType, false));
            x(codedOutputStream, fieldType, obj);
        }
    }

    static void x(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) {
        switch (a.f8993b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.o0(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.w0(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.E0(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.X0(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.C0(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.u0(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.s0(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.i0(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.z0((n0) obj);
                return;
            case 10:
                codedOutputStream.G0((n0) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.m0((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.S0((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ByteString) {
                    codedOutputStream.m0((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.j0((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.V0(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.K0(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.M0(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.O0(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.Q0(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof w.a) {
                    codedOutputStream.q0(((w.a) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.q0(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public s clone() {
        s t11 = t();
        int m11 = this.f8989a.m();
        for (int i11 = 0; i11 < m11; i11++) {
            Map.Entry l11 = this.f8989a.l(i11);
            android.support.v4.media.session.c.a(l11.getKey());
            t11.u(null, l11.getValue());
        }
        for (Map.Entry entry : this.f8989a.o()) {
            android.support.v4.media.session.c.a(entry.getKey());
            t11.u(null, entry.getValue());
        }
        t11.f8991c = this.f8991c;
        return t11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator e() {
        return k() ? Collections.emptyIterator() : this.f8991c ? new z(this.f8989a.j().iterator()) : this.f8989a.j().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            return this.f8989a.equals(((s) obj).f8989a);
        }
        return false;
    }

    public int g() {
        int m11 = this.f8989a.m();
        int i11 = 0;
        for (int i12 = 0; i12 < m11; i12++) {
            i11 += h(this.f8989a.l(i12));
        }
        Iterator it = this.f8989a.o().iterator();
        while (it.hasNext()) {
            i11 += h((Map.Entry) it.next());
        }
        return i11;
    }

    public int hashCode() {
        return this.f8989a.hashCode();
    }

    public int i() {
        int m11 = this.f8989a.m();
        int i11 = 0;
        for (int i12 = 0; i12 < m11; i12++) {
            Map.Entry l11 = this.f8989a.l(i12);
            android.support.v4.media.session.c.a(l11.getKey());
            i11 += d(null, l11.getValue());
        }
        for (Map.Entry entry : this.f8989a.o()) {
            android.support.v4.media.session.c.a(entry.getKey());
            i11 += d(null, entry.getValue());
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f8989a.isEmpty();
    }

    public boolean l() {
        return this.f8990b;
    }

    public boolean m() {
        int m11 = this.f8989a.m();
        for (int i11 = 0; i11 < m11; i11++) {
            if (!n(this.f8989a.l(i11))) {
                return false;
            }
        }
        Iterator it = this.f8989a.o().iterator();
        while (it.hasNext()) {
            if (!n((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator p() {
        return k() ? Collections.emptyIterator() : this.f8991c ? new z(this.f8989a.entrySet().iterator()) : this.f8989a.entrySet().iterator();
    }

    public void q() {
        if (this.f8990b) {
            return;
        }
        int m11 = this.f8989a.m();
        for (int i11 = 0; i11 < m11; i11++) {
            Map.Entry l11 = this.f8989a.l(i11);
            if (l11.getValue() instanceof GeneratedMessageLite) {
                ((GeneratedMessageLite) l11.getValue()).A();
            }
        }
        this.f8989a.r();
        this.f8990b = true;
    }

    public void r(s sVar) {
        int m11 = sVar.f8989a.m();
        for (int i11 = 0; i11 < m11; i11++) {
            s(sVar.f8989a.l(i11));
        }
        Iterator it = sVar.f8989a.o().iterator();
        while (it.hasNext()) {
            s((Map.Entry) it.next());
        }
    }

    public void u(b bVar, Object obj) {
        if (!bVar.isRepeated()) {
            v(bVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                v(bVar, it.next());
            }
            obj = arrayList;
        }
        this.f8989a.t(bVar, obj);
    }
}
