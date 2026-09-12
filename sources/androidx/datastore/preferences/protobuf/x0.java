package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: c, reason: collision with root package name */
    private static final x0 f9012c = new x0();

    /* renamed from: d, reason: collision with root package name */
    static boolean f9013d = false;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f9015b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final c1 f9014a = new g0();

    private x0() {
    }

    public static x0 a() {
        return f9012c;
    }

    public b1 b(Class cls, b1 b1Var) {
        w.b(cls, "messageType");
        w.b(b1Var, "schema");
        return (b1) this.f9015b.putIfAbsent(cls, b1Var);
    }

    public b1 c(Class cls) {
        w.b(cls, "messageType");
        b1 b1Var = (b1) this.f9015b.get(cls);
        if (b1Var != null) {
            return b1Var;
        }
        b1 createSchema = this.f9014a.createSchema(cls);
        b1 b11 = b(cls, createSchema);
        return b11 != null ? b11 : createSchema;
    }

    public b1 d(Object obj) {
        return c(obj.getClass());
    }
}
