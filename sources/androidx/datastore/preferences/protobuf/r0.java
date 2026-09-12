package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class r0 implements b1 {

    /* renamed from: a, reason: collision with root package name */
    private final n0 f8984a;

    /* renamed from: b, reason: collision with root package name */
    private final h1 f8985b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f8986c;

    /* renamed from: d, reason: collision with root package name */
    private final p f8987d;

    private r0(h1 h1Var, p pVar, n0 n0Var) {
        this.f8985b = h1Var;
        this.f8986c = pVar.e(n0Var);
        this.f8987d = pVar;
        this.f8984a = n0Var;
    }

    private int d(h1 h1Var, Object obj) {
        return h1Var.i(h1Var.g(obj));
    }

    private void e(h1 h1Var, p pVar, Object obj, a1 a1Var, o oVar) {
        Object f11 = h1Var.f(obj);
        s d11 = pVar.d(obj);
        do {
            try {
                if (a1Var.getFieldNumber() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                h1Var.o(obj, f11);
            }
        } while (g(a1Var, oVar, pVar, d11, h1Var, f11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r0 f(h1 h1Var, p pVar, n0 n0Var) {
        return new r0(h1Var, pVar, n0Var);
    }

    private boolean g(a1 a1Var, o oVar, p pVar, s sVar, h1 h1Var, Object obj) {
        int tag = a1Var.getTag();
        int i11 = 0;
        if (tag != WireFormat.f8810a) {
            if (WireFormat.b(tag) != 2) {
                return a1Var.skipField();
            }
            Object b11 = pVar.b(oVar, this.f8984a, WireFormat.a(tag));
            if (b11 == null) {
                return h1Var.m(obj, a1Var, 0);
            }
            pVar.h(a1Var, b11, oVar, sVar);
            return true;
        }
        Object obj2 = null;
        ByteString byteString = null;
        while (a1Var.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = a1Var.getTag();
            if (tag2 == WireFormat.f8812c) {
                i11 = a1Var.readUInt32();
                obj2 = pVar.b(oVar, this.f8984a, i11);
            } else if (tag2 == WireFormat.f8813d) {
                if (obj2 != null) {
                    pVar.h(a1Var, obj2, oVar, sVar);
                } else {
                    byteString = a1Var.readBytes();
                }
            } else if (!a1Var.skipField()) {
                break;
            }
        }
        if (a1Var.getTag() != WireFormat.f8811b) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        if (byteString != null) {
            if (obj2 != null) {
                pVar.i(byteString, obj2, oVar, sVar);
            } else {
                h1Var.d(obj, i11, byteString);
            }
        }
        return true;
    }

    private void h(h1 h1Var, Object obj, Writer writer) {
        h1Var.s(h1Var.g(obj), writer);
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public void a(Object obj, a1 a1Var, o oVar) {
        e(this.f8985b, this.f8987d, obj, a1Var, oVar);
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public void b(Object obj, Writer writer) {
        Iterator p11 = this.f8987d.c(obj).p();
        if (p11.hasNext()) {
            android.support.v4.media.session.c.a(((Map.Entry) p11.next()).getKey());
            throw null;
        }
        h(this.f8985b, obj, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008c A[EDGE_INSN: B:24:0x008c->B:25:0x008c BREAK  A[LOOP:1: B:10:0x004a->B:18:0x004a], SYNTHETIC] */
    @Override // androidx.datastore.preferences.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(java.lang.Object r9, byte[] r10, int r11, int r12, androidx.datastore.preferences.protobuf.e.a r13) {
        /*
            r8 = this;
            r0 = r9
            androidx.datastore.preferences.protobuf.GeneratedMessageLite r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite) r0
            androidx.datastore.preferences.protobuf.i1 r1 = r0.unknownFields
            androidx.datastore.preferences.protobuf.i1 r2 = androidx.datastore.preferences.protobuf.i1.c()
            if (r1 != r2) goto L11
            androidx.datastore.preferences.protobuf.i1 r1 = androidx.datastore.preferences.protobuf.i1.k()
            r0.unknownFields = r1
        L11:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.c) r9
            r9.K()
        L16:
            if (r11 >= r12) goto L98
            int r4 = androidx.datastore.preferences.protobuf.e.I(r10, r11, r13)
            int r2 = r13.f8827a
            int r9 = androidx.datastore.preferences.protobuf.WireFormat.f8810a
            r11 = 2
            if (r2 == r9) goto L48
            int r9 = androidx.datastore.preferences.protobuf.WireFormat.b(r2)
            if (r9 != r11) goto L43
            androidx.datastore.preferences.protobuf.p r9 = r8.f8987d
            androidx.datastore.preferences.protobuf.o r11 = r13.f8830d
            androidx.datastore.preferences.protobuf.n0 r0 = r8.f8984a
            int r3 = androidx.datastore.preferences.protobuf.WireFormat.a(r2)
            java.lang.Object r9 = r9.b(r11, r0, r3)
            android.support.v4.media.session.c.a(r9)
            r3 = r10
            r5 = r12
            r6 = r1
            r7 = r13
            int r11 = androidx.datastore.preferences.protobuf.e.G(r2, r3, r4, r5, r6, r7)
            goto L16
        L43:
            int r11 = androidx.datastore.preferences.protobuf.e.P(r2, r10, r4, r12, r13)
            goto L16
        L48:
            r9 = 0
            r0 = 0
        L4a:
            if (r4 >= r12) goto L8b
            int r2 = androidx.datastore.preferences.protobuf.e.I(r10, r4, r13)
            int r3 = r13.f8827a
            int r4 = androidx.datastore.preferences.protobuf.WireFormat.a(r3)
            int r5 = androidx.datastore.preferences.protobuf.WireFormat.b(r3)
            if (r4 == r11) goto L6b
            r6 = 3
            if (r4 == r6) goto L60
            goto L81
        L60:
            if (r5 != r11) goto L81
            int r4 = androidx.datastore.preferences.protobuf.e.c(r10, r2, r13)
            java.lang.Object r0 = r13.f8829c
            androidx.datastore.preferences.protobuf.ByteString r0 = (androidx.datastore.preferences.protobuf.ByteString) r0
            goto L4a
        L6b:
            if (r5 != 0) goto L81
            int r4 = androidx.datastore.preferences.protobuf.e.I(r10, r2, r13)
            int r9 = r13.f8827a
            androidx.datastore.preferences.protobuf.p r2 = r8.f8987d
            androidx.datastore.preferences.protobuf.o r3 = r13.f8830d
            androidx.datastore.preferences.protobuf.n0 r5 = r8.f8984a
            java.lang.Object r2 = r2.b(r3, r5, r9)
            android.support.v4.media.session.c.a(r2)
            goto L4a
        L81:
            int r4 = androidx.datastore.preferences.protobuf.WireFormat.f8811b
            if (r3 != r4) goto L86
            goto L8c
        L86:
            int r4 = androidx.datastore.preferences.protobuf.e.P(r3, r10, r2, r12, r13)
            goto L4a
        L8b:
            r2 = r4
        L8c:
            if (r0 == 0) goto L95
            int r9 = androidx.datastore.preferences.protobuf.WireFormat.c(r9, r11)
            r1.n(r9, r0)
        L95:
            r11 = r2
            goto L16
        L98:
            if (r11 != r12) goto L9b
            return
        L9b:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.r0.c(java.lang.Object, byte[], int, int, androidx.datastore.preferences.protobuf.e$a):void");
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public boolean equals(Object obj, Object obj2) {
        if (!this.f8985b.g(obj).equals(this.f8985b.g(obj2))) {
            return false;
        }
        if (this.f8986c) {
            return this.f8987d.c(obj).equals(this.f8987d.c(obj2));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public int getSerializedSize(Object obj) {
        int d11 = d(this.f8985b, obj);
        return this.f8986c ? d11 + this.f8987d.c(obj).g() : d11;
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public int hashCode(Object obj) {
        int hashCode = this.f8985b.g(obj).hashCode();
        return this.f8986c ? (hashCode * 53) + this.f8987d.c(obj).hashCode() : hashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final boolean isInitialized(Object obj) {
        return this.f8987d.c(obj).m();
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public void makeImmutable(Object obj) {
        this.f8985b.j(obj);
        this.f8987d.f(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public void mergeFrom(Object obj, Object obj2) {
        d1.F(this.f8985b, obj, obj2);
        if (this.f8986c) {
            d1.D(this.f8987d, obj, obj2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public Object newInstance() {
        n0 n0Var = this.f8984a;
        return n0Var instanceof GeneratedMessageLite ? ((GeneratedMessageLite) n0Var).F() : n0Var.newBuilderForType().buildPartial();
    }
}
