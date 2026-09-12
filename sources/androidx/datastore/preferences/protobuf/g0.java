package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g0 implements c1 {

    /* renamed from: b, reason: collision with root package name */
    private static final m0 f8855b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final m0 f8856a;

    /* loaded from: classes.dex */
    class a implements m0 {
        a() {
        }

        @Override // androidx.datastore.preferences.protobuf.m0
        public boolean isSupported(Class cls) {
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.m0
        public l0 messageInfoFor(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8857a;

        static {
            int[] iArr = new int[ProtoSyntax.values().length];
            f8857a = iArr;
            try {
                iArr[ProtoSyntax.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements m0 {

        /* renamed from: a, reason: collision with root package name */
        private m0[] f8858a;

        c(m0... m0VarArr) {
            this.f8858a = m0VarArr;
        }

        @Override // androidx.datastore.preferences.protobuf.m0
        public boolean isSupported(Class cls) {
            for (m0 m0Var : this.f8858a) {
                if (m0Var.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.m0
        public l0 messageInfoFor(Class cls) {
            for (m0 m0Var : this.f8858a) {
                if (m0Var.isSupported(cls)) {
                    return m0Var.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    public g0() {
        this(b());
    }

    private g0(m0 m0Var) {
        this.f8856a = (m0) w.b(m0Var, "messageInfoFactory");
    }

    private static boolean a(l0 l0Var) {
        return b.f8857a[l0Var.getSyntax().ordinal()] != 1;
    }

    private static m0 b() {
        return new c(u.a(), c());
    }

    private static m0 c() {
        if (x0.f9013d) {
            return f8855b;
        }
        try {
            return (m0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f8855b;
        }
    }

    private static b1 d(Class cls, l0 l0Var) {
        if (e(cls)) {
            return q0.M(cls, l0Var, u0.b(), e0.b(), d1.K(), a(l0Var) ? r.b() : null, k0.b());
        }
        return q0.M(cls, l0Var, u0.a(), e0.a(), d1.J(), a(l0Var) ? r.a() : null, k0.a());
    }

    private static boolean e(Class cls) {
        return x0.f9013d || GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public b1 createSchema(Class cls) {
        d1.G(cls);
        l0 messageInfoFor = this.f8856a.messageInfoFor(cls);
        return messageInfoFor.isMessageSetWireFormat() ? e(cls) ? r0.f(d1.K(), r.b(), messageInfoFor.getDefaultInstance()) : r0.f(d1.J(), r.a(), messageInfoFor.getDefaultInstance()) : d(cls, messageInfoFor);
    }
}
