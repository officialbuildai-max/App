package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.e;
import androidx.datastore.preferences.protobuf.n0;
import androidx.datastore.preferences.protobuf.w;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class GeneratedMessageLite extends androidx.datastore.preferences.protobuf.a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected i1 unknownFields = i1.c();

    /* loaded from: classes.dex */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* loaded from: classes.dex */
    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        SerializedForm(n0 n0Var) {
            this.messageClass = n0Var.getClass();
            this.messageClassName = n0Var.getClass().getName();
            this.asBytes = n0Var.toByteArray();
        }

        public static SerializedForm of(n0 n0Var) {
            return new SerializedForm(n0Var);
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            return cls != null ? cls : Class.forName(this.messageClassName);
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((n0) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (InvalidProtocolBufferException e11) {
                throw new RuntimeException("Unable to understand proto buffer", e11);
            } catch (ClassNotFoundException e12) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e12);
            } catch (IllegalAccessException e13) {
                throw new RuntimeException("Unable to call parsePartialFrom", e13);
            } catch (NoSuchFieldException e14) {
                throw new RuntimeException("Unable to find DEFAULT_INSTANCE in " + this.messageClassName, e14);
            } catch (SecurityException e15) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e15);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a extends a.AbstractC0082a {

        /* renamed from: a, reason: collision with root package name */
        private final GeneratedMessageLite f8790a;

        /* renamed from: b, reason: collision with root package name */
        protected GeneratedMessageLite f8791b;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(GeneratedMessageLite generatedMessageLite) {
            this.f8790a = generatedMessageLite;
            if (generatedMessageLite.z()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f8791b = w();
        }

        private static void v(Object obj, Object obj2) {
            x0.a().d(obj).mergeFrom(obj, obj2);
        }

        private GeneratedMessageLite w() {
            return this.f8790a.F();
        }

        @Override // androidx.datastore.preferences.protobuf.o0
        public final boolean isInitialized() {
            return GeneratedMessageLite.y(this.f8791b, false);
        }

        public final GeneratedMessageLite m() {
            GeneratedMessageLite buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0082a.l(buildPartial);
        }

        @Override // androidx.datastore.preferences.protobuf.n0.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite buildPartial() {
            if (!this.f8791b.z()) {
                return this.f8791b;
            }
            this.f8791b.A();
            return this.f8791b;
        }

        @Override // androidx.datastore.preferences.protobuf.a.AbstractC0082a
        /* renamed from: o, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a e() {
            a newBuilderForType = getDefaultInstanceForType().newBuilderForType();
            newBuilderForType.f8791b = buildPartial();
            return newBuilderForType;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void p() {
            if (this.f8791b.z()) {
                return;
            }
            q();
        }

        protected void q() {
            GeneratedMessageLite w11 = w();
            v(w11, this.f8791b);
            this.f8791b = w11;
        }

        @Override // androidx.datastore.preferences.protobuf.o0
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite getDefaultInstanceForType() {
            return this.f8790a;
        }

        @Override // androidx.datastore.preferences.protobuf.a.AbstractC0082a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public a i(i iVar, o oVar) {
            p();
            try {
                x0.a().d(this.f8791b).a(this.f8791b, j.f(iVar), oVar);
                return this;
            } catch (RuntimeException e11) {
                if (e11.getCause() instanceof IOException) {
                    throw ((IOException) e11.getCause());
                }
                throw e11;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.a.AbstractC0082a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public a k(byte[] bArr, int i11, int i12) {
            return u(bArr, i11, i12, o.b());
        }

        public a u(byte[] bArr, int i11, int i12, o oVar) {
            p();
            try {
                x0.a().d(this.f8791b).c(this.f8791b, bArr, i11, i11 + i12, new e.a(oVar));
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e12);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
    }

    /* loaded from: classes.dex */
    protected static class b extends androidx.datastore.preferences.protobuf.b {

        /* renamed from: b, reason: collision with root package name */
        private final GeneratedMessageLite f8792b;

        public b(GeneratedMessageLite generatedMessageLite) {
            this.f8792b = generatedMessageLite;
        }

        @Override // androidx.datastore.preferences.protobuf.v0
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite b(i iVar, o oVar) {
            return GeneratedMessageLite.H(this.f8792b, iVar, oVar);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c extends GeneratedMessageLite implements o0 {
        protected s extensions = s.f();

        /* JADX INFO: Access modifiers changed from: package-private */
        public s K() {
            if (this.extensions.l()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.o0
        public /* bridge */ /* synthetic */ n0 getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.n0
        public /* bridge */ /* synthetic */ n0.a newBuilderForType() {
            return super.newBuilderForType();
        }
    }

    /* loaded from: classes.dex */
    public static class d extends m {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static w.d C(w.d dVar) {
        int size = dVar.size();
        return dVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object E(n0 n0Var, String str, Object[] objArr) {
        return new z0(n0Var, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static GeneratedMessageLite G(GeneratedMessageLite generatedMessageLite, InputStream inputStream) {
        return j(H(generatedMessageLite, i.g(inputStream), o.b()));
    }

    static GeneratedMessageLite H(GeneratedMessageLite generatedMessageLite, i iVar, o oVar) {
        GeneratedMessageLite F = generatedMessageLite.F();
        try {
            b1 d11 = x0.a().d(F);
            d11.a(F, j.f(iVar), oVar);
            d11.makeImmutable(F);
            return F;
        } catch (InvalidProtocolBufferException e11) {
            e = e11;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.setUnfinishedMessage(F);
        } catch (UninitializedMessageException e12) {
            throw e12.asInvalidProtocolBufferException().setUnfinishedMessage(F);
        } catch (IOException e13) {
            if (e13.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e13.getCause());
            }
            throw new InvalidProtocolBufferException(e13).setUnfinishedMessage(F);
        } catch (RuntimeException e14) {
            if (e14.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e14.getCause());
            }
            throw e14;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void I(Class cls, GeneratedMessageLite generatedMessageLite) {
        generatedMessageLite.B();
        defaultInstanceMap.put(cls, generatedMessageLite);
    }

    private static GeneratedMessageLite j(GeneratedMessageLite generatedMessageLite) {
        if (generatedMessageLite == null || generatedMessageLite.isInitialized()) {
            return generatedMessageLite;
        }
        throw generatedMessageLite.f().asInvalidProtocolBufferException().setUnfinishedMessage(generatedMessageLite);
    }

    private int n(b1 b1Var) {
        return b1Var == null ? x0.a().d(this).getSerializedSize(this) : b1Var.getSerializedSize(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static w.d s() {
        return y0.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GeneratedMessageLite t(Class cls) {
        GeneratedMessageLite generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = ((GeneratedMessageLite) k1.l(cls)).getDefaultInstanceForType();
            if (generatedMessageLite == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, generatedMessageLite);
        }
        return generatedMessageLite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object x(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e11);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final boolean y(GeneratedMessageLite generatedMessageLite, boolean z10) {
        byte byteValue = ((Byte) generatedMessageLite.p(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = x0.a().d(generatedMessageLite).isInitialized(generatedMessageLite);
        if (z10) {
            generatedMessageLite.q(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, isInitialized ? generatedMessageLite : null);
        }
        return isInitialized;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
        x0.a().d(this).makeImmutable(this);
        B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // androidx.datastore.preferences.protobuf.n0
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final a newBuilderForType() {
        return (a) p(MethodToInvoke.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneratedMessageLite F() {
        return (GeneratedMessageLite) p(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    void J(int i11) {
        this.memoizedHashCode = i11;
    }

    @Override // androidx.datastore.preferences.protobuf.n0
    public void a(CodedOutputStream codedOutputStream) {
        x0.a().d(this).b(this, k.g(codedOutputStream));
    }

    @Override // androidx.datastore.preferences.protobuf.a
    int c() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // androidx.datastore.preferences.protobuf.a
    int d(b1 b1Var) {
        if (!z()) {
            if (c() != Integer.MAX_VALUE) {
                return c();
            }
            int n11 = n(b1Var);
            g(n11);
            return n11;
        }
        int n12 = n(b1Var);
        if (n12 >= 0) {
            return n12;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + n12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return x0.a().d(this).equals(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.a
    void g(int i11) {
        if (i11 >= 0) {
            this.memoizedSerializedSize = (i11 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i11);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.n0
    public final v0 getParserForType() {
        return (v0) p(MethodToInvoke.GET_PARSER);
    }

    @Override // androidx.datastore.preferences.protobuf.n0
    public int getSerializedSize() {
        return d(null);
    }

    public int hashCode() {
        if (z()) {
            return m();
        }
        if (w()) {
            J(m());
        }
        return v();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object i() {
        return p(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    @Override // androidx.datastore.preferences.protobuf.o0
    public final boolean isInitialized() {
        return y(this, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        this.memoizedHashCode = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        g(Integer.MAX_VALUE);
    }

    int m() {
        return x0.a().d(this).hashCode(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a o() {
        return (a) p(MethodToInvoke.NEW_BUILDER);
    }

    protected Object p(MethodToInvoke methodToInvoke) {
        return r(methodToInvoke, null, null);
    }

    protected Object q(MethodToInvoke methodToInvoke, Object obj) {
        return r(methodToInvoke, obj, null);
    }

    protected abstract Object r(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public String toString() {
        return p0.f(this, super.toString());
    }

    @Override // androidx.datastore.preferences.protobuf.o0
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final GeneratedMessageLite getDefaultInstanceForType() {
        return (GeneratedMessageLite) p(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    int v() {
        return this.memoizedHashCode;
    }

    boolean w() {
        return v() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }
}
