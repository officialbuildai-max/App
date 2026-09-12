package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z0 implements l0 {

    /* renamed from: a, reason: collision with root package name */
    private final n0 f9020a;

    /* renamed from: b, reason: collision with root package name */
    private final String f9021b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f9022c;

    /* renamed from: d, reason: collision with root package name */
    private final int f9023d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(n0 n0Var, String str, Object[] objArr) {
        this.f9020a = n0Var;
        this.f9021b = str;
        this.f9022c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f9023d = charAt;
            return;
        }
        int i11 = charAt & 8191;
        int i12 = 13;
        int i13 = 1;
        while (true) {
            int i14 = i13 + 1;
            char charAt2 = str.charAt(i13);
            if (charAt2 < 55296) {
                this.f9023d = i11 | (charAt2 << i12);
                return;
            } else {
                i11 |= (charAt2 & 8191) << i12;
                i12 += 13;
                i13 = i14;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] a() {
        return this.f9022c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f9021b;
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public n0 getDefaultInstance() {
        return this.f9020a;
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public ProtoSyntax getSyntax() {
        int i11 = this.f9023d;
        return (i11 & 1) != 0 ? ProtoSyntax.PROTO2 : (i11 & 4) == 4 ? ProtoSyntax.EDITIONS : ProtoSyntax.PROTO3;
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public boolean isMessageSetWireFormat() {
        return (this.f9023d & 2) == 2;
    }
}
