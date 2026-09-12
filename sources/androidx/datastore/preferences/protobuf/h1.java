package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class h1 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f8867a = 100;

    private final void l(Object obj, a1 a1Var, int i11) {
        while (a1Var.getFieldNumber() != Integer.MAX_VALUE && m(obj, a1Var, i11)) {
        }
    }

    abstract void a(Object obj, int i11, int i12);

    abstract void b(Object obj, int i11, long j11);

    abstract void c(Object obj, int i11, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(Object obj, int i11, ByteString byteString);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(Object obj, int i11, long j11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object f(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object g(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int i(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object k(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(Object obj, a1 a1Var, int i11) {
        int tag = a1Var.getTag();
        int a11 = WireFormat.a(tag);
        int b11 = WireFormat.b(tag);
        if (b11 == 0) {
            e(obj, a11, a1Var.readInt64());
            return true;
        }
        if (b11 == 1) {
            b(obj, a11, a1Var.readFixed64());
            return true;
        }
        if (b11 == 2) {
            d(obj, a11, a1Var.readBytes());
            return true;
        }
        if (b11 != 3) {
            if (b11 == 4) {
                return false;
            }
            if (b11 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            a(obj, a11, a1Var.readFixed32());
            return true;
        }
        Object n11 = n();
        int c11 = WireFormat.c(a11, 4);
        int i12 = i11 + 1;
        if (i12 >= f8867a) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        l(n11, a1Var, i12);
        if (c11 != a1Var.getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        c(obj, a11, r(n11));
        return true;
    }

    abstract Object n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void p(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean q(a1 a1Var);

    abstract Object r(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void s(Object obj, Writer writer);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void t(Object obj, Writer writer);
}
