package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    private ByteString f8814a;

    /* renamed from: b, reason: collision with root package name */
    private o f8815b;

    /* renamed from: c, reason: collision with root package name */
    protected volatile n0 f8816c;

    /* renamed from: d, reason: collision with root package name */
    private volatile ByteString f8817d;

    protected void a(n0 n0Var) {
        if (this.f8816c != null) {
            return;
        }
        synchronized (this) {
            if (this.f8816c != null) {
                return;
            }
            try {
                if (this.f8814a != null) {
                    this.f8816c = (n0) n0Var.getParserForType().a(this.f8814a, this.f8815b);
                    this.f8817d = this.f8814a;
                } else {
                    this.f8816c = n0Var;
                    this.f8817d = ByteString.EMPTY;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f8816c = n0Var;
                this.f8817d = ByteString.EMPTY;
            }
        }
    }

    public int b() {
        if (this.f8817d != null) {
            return this.f8817d.size();
        }
        ByteString byteString = this.f8814a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f8816c != null) {
            return this.f8816c.getSerializedSize();
        }
        return 0;
    }

    public n0 c(n0 n0Var) {
        a(n0Var);
        return this.f8816c;
    }

    public ByteString d() {
        if (this.f8817d != null) {
            return this.f8817d;
        }
        ByteString byteString = this.f8814a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            try {
                if (this.f8817d != null) {
                    return this.f8817d;
                }
                if (this.f8816c == null) {
                    this.f8817d = ByteString.EMPTY;
                } else {
                    this.f8817d = this.f8816c.toByteString();
                }
                return this.f8817d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        n0 n0Var = this.f8816c;
        n0 n0Var2 = a0Var.f8816c;
        return (n0Var == null && n0Var2 == null) ? d().equals(a0Var.d()) : (n0Var == null || n0Var2 == null) ? n0Var != null ? n0Var.equals(a0Var.c(n0Var.getDefaultInstanceForType())) : c(n0Var2.getDefaultInstanceForType()).equals(n0Var2) : n0Var.equals(n0Var2);
    }

    public int hashCode() {
        return 1;
    }
}
