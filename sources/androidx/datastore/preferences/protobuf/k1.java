package androidx.datastore.preferences.protobuf;

import com.google.android.libraries.places.api.model.PlaceTypes;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class k1 {

    /* renamed from: a, reason: collision with root package name */
    private static final Unsafe f8931a = H();

    /* renamed from: b, reason: collision with root package name */
    private static final Class f8932b = androidx.datastore.preferences.protobuf.d.b();

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f8933c = q(Long.TYPE);

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f8934d = q(Integer.TYPE);

    /* renamed from: e, reason: collision with root package name */
    private static final e f8935e = F();

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f8936f = Y();

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f8937g = X();

    /* renamed from: h, reason: collision with root package name */
    static final long f8938h;

    /* renamed from: i, reason: collision with root package name */
    private static final long f8939i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f8940j;

    /* renamed from: k, reason: collision with root package name */
    private static final long f8941k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f8942l;

    /* renamed from: m, reason: collision with root package name */
    private static final long f8943m;

    /* renamed from: n, reason: collision with root package name */
    private static final long f8944n;

    /* renamed from: o, reason: collision with root package name */
    private static final long f8945o;

    /* renamed from: p, reason: collision with root package name */
    private static final long f8946p;

    /* renamed from: q, reason: collision with root package name */
    private static final long f8947q;

    /* renamed from: r, reason: collision with root package name */
    private static final long f8948r;

    /* renamed from: s, reason: collision with root package name */
    private static final long f8949s;

    /* renamed from: t, reason: collision with root package name */
    private static final long f8950t;

    /* renamed from: u, reason: collision with root package name */
    private static final long f8951u;

    /* renamed from: v, reason: collision with root package name */
    private static final int f8952v;

    /* renamed from: w, reason: collision with root package name */
    static final boolean f8953w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements PrivilegedExceptionAction {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void c(long j11, byte[] bArr, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean d(Object obj, long j11) {
            return k1.f8953w ? k1.u(obj, j11) : k1.v(obj, j11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte e(long j11) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte f(Object obj, long j11) {
            return k1.f8953w ? k1.y(obj, j11) : k1.z(obj, j11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public double g(Object obj, long j11) {
            return Double.longBitsToDouble(k(obj, j11));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public float h(Object obj, long j11) {
            return Float.intBitsToFloat(i(obj, j11));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public long j(long j11) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void n(Object obj, long j11, boolean z10) {
            if (k1.f8953w) {
                k1.N(obj, j11, z10);
            } else {
                k1.O(obj, j11, z10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void o(Object obj, long j11, byte b11) {
            if (k1.f8953w) {
                k1.Q(obj, j11, b11);
            } else {
                k1.R(obj, j11, b11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void p(Object obj, long j11, double d11) {
            s(obj, j11, Double.doubleToLongBits(d11));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void q(Object obj, long j11, float f11) {
            r(obj, j11, Float.floatToIntBits(f11));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean v() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void c(long j11, byte[] bArr, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean d(Object obj, long j11) {
            return k1.f8953w ? k1.u(obj, j11) : k1.v(obj, j11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte e(long j11) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte f(Object obj, long j11) {
            return k1.f8953w ? k1.y(obj, j11) : k1.z(obj, j11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public double g(Object obj, long j11) {
            return Double.longBitsToDouble(k(obj, j11));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public float h(Object obj, long j11) {
            return Float.intBitsToFloat(i(obj, j11));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public long j(long j11) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void n(Object obj, long j11, boolean z10) {
            if (k1.f8953w) {
                k1.N(obj, j11, z10);
            } else {
                k1.O(obj, j11, z10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void o(Object obj, long j11, byte b11) {
            if (k1.f8953w) {
                k1.Q(obj, j11, b11);
            } else {
                k1.R(obj, j11, b11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void p(Object obj, long j11, double d11) {
            s(obj, j11, Double.doubleToLongBits(d11));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void q(Object obj, long j11, float f11) {
            r(obj, j11, Float.floatToIntBits(f11));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean v() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void c(long j11, byte[] bArr, long j12, long j13) {
            this.f8954a.copyMemory((Object) null, j11, bArr, k1.f8938h + j12, j13);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean d(Object obj, long j11) {
            return this.f8954a.getBoolean(obj, j11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte e(long j11) {
            return this.f8954a.getByte(j11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte f(Object obj, long j11) {
            return this.f8954a.getByte(obj, j11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public double g(Object obj, long j11) {
            return this.f8954a.getDouble(obj, j11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public float h(Object obj, long j11) {
            return this.f8954a.getFloat(obj, j11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public long j(long j11) {
            return this.f8954a.getLong(j11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void n(Object obj, long j11, boolean z10) {
            this.f8954a.putBoolean(obj, j11, z10);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void o(Object obj, long j11, byte b11) {
            this.f8954a.putByte(obj, j11, b11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void p(Object obj, long j11, double d11) {
            this.f8954a.putDouble(obj, j11, d11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void q(Object obj, long j11, float f11) {
            this.f8954a.putFloat(obj, j11, f11);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean u() {
            if (!super.u()) {
                return false;
            }
            try {
                Class<?> cls = this.f8954a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th2) {
                k1.K(th2);
                return false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean v() {
            if (!super.v()) {
                return false;
            }
            try {
                Class<?> cls = this.f8954a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th2) {
                k1.K(th2);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f8954a;

        e(Unsafe unsafe) {
            this.f8954a = unsafe;
        }

        public final int a(Class cls) {
            return this.f8954a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f8954a.arrayIndexScale(cls);
        }

        public abstract void c(long j11, byte[] bArr, long j12, long j13);

        public abstract boolean d(Object obj, long j11);

        public abstract byte e(long j11);

        public abstract byte f(Object obj, long j11);

        public abstract double g(Object obj, long j11);

        public abstract float h(Object obj, long j11);

        public final int i(Object obj, long j11) {
            return this.f8954a.getInt(obj, j11);
        }

        public abstract long j(long j11);

        public final long k(Object obj, long j11) {
            return this.f8954a.getLong(obj, j11);
        }

        public final Object l(Object obj, long j11) {
            return this.f8954a.getObject(obj, j11);
        }

        public final long m(Field field) {
            return this.f8954a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j11, boolean z10);

        public abstract void o(Object obj, long j11, byte b11);

        public abstract void p(Object obj, long j11, double d11);

        public abstract void q(Object obj, long j11, float f11);

        public final void r(Object obj, long j11, int i11) {
            this.f8954a.putInt(obj, j11, i11);
        }

        public final void s(Object obj, long j11, long j12) {
            this.f8954a.putLong(obj, j11, j12);
        }

        public final void t(Object obj, long j11, Object obj2) {
            this.f8954a.putObject(obj, j11, obj2);
        }

        public boolean u() {
            Unsafe unsafe = this.f8954a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th2) {
                k1.K(th2);
                return false;
            }
        }

        public boolean v() {
            Unsafe unsafe = this.f8954a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return k1.b() != null;
            } catch (Throwable th2) {
                k1.K(th2);
                return false;
            }
        }
    }

    static {
        long m11 = m(byte[].class);
        f8938h = m11;
        f8939i = m(boolean[].class);
        f8940j = n(boolean[].class);
        f8941k = m(int[].class);
        f8942l = n(int[].class);
        f8943m = m(long[].class);
        f8944n = n(long[].class);
        f8945o = m(float[].class);
        f8946p = n(float[].class);
        f8947q = m(double[].class);
        f8948r = n(double[].class);
        f8949s = m(Object[].class);
        f8950t = n(Object[].class);
        f8951u = s(o());
        f8952v = (int) (m11 & 7);
        f8953w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double A(Object obj, long j11) {
        return f8935e.g(obj, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float B(Object obj, long j11) {
        return f8935e.h(obj, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(Object obj, long j11) {
        return f8935e.i(obj, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long D(long j11) {
        return f8935e.j(j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long E(Object obj, long j11) {
        return f8935e.k(obj, j11);
    }

    private static e F() {
        Unsafe unsafe = f8931a;
        if (unsafe == null) {
            return null;
        }
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return new d(unsafe);
        }
        if (f8933c) {
            return new c(unsafe);
        }
        if (f8934d) {
            return new b(unsafe);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object G(Object obj, long j11) {
        return f8935e.l(obj, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe H() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean I() {
        return f8937g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean J() {
        return f8936f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(Throwable th2) {
        Logger.getLogger(k1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long L(Field field) {
        return f8935e.m(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void M(Object obj, long j11, boolean z10) {
        f8935e.n(obj, j11, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(Object obj, long j11, boolean z10) {
        Q(obj, j11, z10 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(Object obj, long j11, boolean z10) {
        R(obj, j11, z10 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void P(byte[] bArr, long j11, byte b11) {
        f8935e.o(bArr, f8938h + j11, b11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(Object obj, long j11, byte b11) {
        long j12 = (-4) & j11;
        int C = C(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        U(obj, j12, ((255 & b11) << i11) | (C & (~(255 << i11))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R(Object obj, long j11, byte b11) {
        long j12 = (-4) & j11;
        int i11 = (((int) j11) & 3) << 3;
        U(obj, j12, ((255 & b11) << i11) | (C(obj, j12) & (~(255 << i11))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void S(Object obj, long j11, double d11) {
        f8935e.p(obj, j11, d11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void T(Object obj, long j11, float f11) {
        f8935e.q(obj, j11, f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void U(Object obj, long j11, int i11) {
        f8935e.r(obj, j11, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void V(Object obj, long j11, long j12) {
        f8935e.s(obj, j11, j12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void W(Object obj, long j11, Object obj2) {
        f8935e.t(obj, j11, obj2);
    }

    private static boolean X() {
        e eVar = f8935e;
        if (eVar == null) {
            return false;
        }
        return eVar.u();
    }

    private static boolean Y() {
        e eVar = f8935e;
        if (eVar == null) {
            return false;
        }
        return eVar.v();
    }

    static /* synthetic */ Field b() {
        return o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long k(ByteBuffer byteBuffer) {
        return f8935e.k(byteBuffer, f8951u);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object l(Class cls) {
        try {
            return f8931a.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    private static int m(Class cls) {
        if (f8937g) {
            return f8935e.a(cls);
        }
        return -1;
    }

    private static int n(Class cls) {
        if (f8937g) {
            return f8935e.b(cls);
        }
        return -1;
    }

    private static Field o() {
        Field r11;
        if (androidx.datastore.preferences.protobuf.d.c() && (r11 = r(Buffer.class, "effectiveDirectAddress")) != null) {
            return r11;
        }
        Field r12 = r(Buffer.class, PlaceTypes.ADDRESS);
        if (r12 == null || r12.getType() != Long.TYPE) {
            return null;
        }
        return r12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(long j11, byte[] bArr, long j12, long j13) {
        f8935e.c(j11, bArr, j12, j13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean q(Class cls) {
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return false;
        }
        try {
            Class cls2 = f8932b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field r(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long s(Field field) {
        e eVar;
        if (field == null || (eVar = f8935e) == null) {
            return -1L;
        }
        return eVar.m(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t(Object obj, long j11) {
        return f8935e.d(obj, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean u(Object obj, long j11) {
        return y(obj, j11) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(Object obj, long j11) {
        return z(obj, j11) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte w(long j11) {
        return f8935e.e(j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte x(byte[] bArr, long j11) {
        return f8935e.f(bArr, f8938h + j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte y(Object obj, long j11) {
        return (byte) ((C(obj, (-4) & j11) >>> ((int) (((~j11) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte z(Object obj, long j11) {
        return (byte) ((C(obj, (-4) & j11) >>> ((int) ((j11 & 3) << 3))) & 255);
    }
}
