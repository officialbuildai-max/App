package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private static final u f8994a = new u();

    private u() {
    }

    public static u a() {
        return f8994a;
    }

    @Override // androidx.datastore.preferences.protobuf.m0
    public boolean isSupported(Class cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // androidx.datastore.preferences.protobuf.m0
    public l0 messageInfoFor(Class cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (l0) GeneratedMessageLite.t(cls.asSubclass(GeneratedMessageLite.class)).i();
        } catch (Exception e11) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e11);
        }
    }
}
