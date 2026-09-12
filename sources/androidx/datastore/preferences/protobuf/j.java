package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements a1 {

    /* renamed from: a, reason: collision with root package name */
    private final i f8922a;

    /* renamed from: b, reason: collision with root package name */
    private int f8923b;

    /* renamed from: c, reason: collision with root package name */
    private int f8924c;

    /* renamed from: d, reason: collision with root package name */
    private int f8925d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8926a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f8926a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8926a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8926a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8926a[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8926a[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8926a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8926a[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8926a[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8926a[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8926a[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8926a[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8926a[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f8926a[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f8926a[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f8926a[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f8926a[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f8926a[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private j(i iVar) {
        i iVar2 = (i) w.b(iVar, "input");
        this.f8922a = iVar2;
        iVar2.f8872d = this;
    }

    public static j f(i iVar) {
        j jVar = iVar.f8872d;
        return jVar != null ? jVar : new j(iVar);
    }

    private void g(Object obj, b1 b1Var, o oVar) {
        int i11 = this.f8924c;
        this.f8924c = WireFormat.c(WireFormat.a(this.f8923b), 4);
        try {
            b1Var.a(obj, this, oVar);
            if (this.f8923b == this.f8924c) {
            } else {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } finally {
            this.f8924c = i11;
        }
    }

    private void h(Object obj, b1 b1Var, o oVar) {
        int F = this.f8922a.F();
        i iVar = this.f8922a;
        if (iVar.f8869a >= iVar.f8870b) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int o11 = iVar.o(F);
        this.f8922a.f8869a++;
        b1Var.a(obj, this, oVar);
        this.f8922a.a(0);
        r5.f8869a--;
        this.f8922a.n(o11);
    }

    private Object i(WireFormat.FieldType fieldType, Class cls, o oVar) {
        switch (a.f8926a[fieldType.ordinal()]) {
            case 1:
                return Boolean.valueOf(readBool());
            case 2:
                return readBytes();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(readEnum());
            case 5:
                return Integer.valueOf(readFixed32());
            case 6:
                return Long.valueOf(readFixed64());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(readInt32());
            case 9:
                return Long.valueOf(readInt64());
            case 10:
                return l(cls, oVar);
            case 11:
                return Integer.valueOf(readSFixed32());
            case 12:
                return Long.valueOf(readSFixed64());
            case 13:
                return Integer.valueOf(readSInt32());
            case 14:
                return Long.valueOf(readSInt64());
            case 15:
                return readStringRequireUtf8();
            case 16:
                return Integer.valueOf(readUInt32());
            case 17:
                return Long.valueOf(readUInt64());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private Object j(b1 b1Var, o oVar) {
        Object newInstance = b1Var.newInstance();
        g(newInstance, b1Var, oVar);
        b1Var.makeImmutable(newInstance);
        return newInstance;
    }

    private Object k(b1 b1Var, o oVar) {
        Object newInstance = b1Var.newInstance();
        h(newInstance, b1Var, oVar);
        b1Var.makeImmutable(newInstance);
        return newInstance;
    }

    private void n(int i11) {
        if (this.f8922a.e() != i11) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void o(int i11) {
        if (WireFormat.b(this.f8923b) != i11) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private void p(int i11) {
        if ((i11 & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    private void q(int i11) {
        if ((i11 & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void a(Object obj, b1 b1Var, o oVar) {
        o(2);
        h(obj, b1Var, oVar);
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void b(List list, b1 b1Var, o oVar) {
        int E;
        if (WireFormat.b(this.f8923b) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int i11 = this.f8923b;
        do {
            list.add(k(b1Var, oVar));
            if (this.f8922a.f() || this.f8925d != 0) {
                return;
            } else {
                E = this.f8922a.E();
            }
        } while (E == i11);
        this.f8925d = E;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0061, code lost:
    
        r7.f8922a.n(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0066, code lost:
    
        return;
     */
    @Override // androidx.datastore.preferences.protobuf.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(java.util.Map r8, androidx.datastore.preferences.protobuf.h0.a r9, androidx.datastore.preferences.protobuf.o r10) {
        /*
            r7 = this;
            r0 = 2
            r7.o(r0)
            androidx.datastore.preferences.protobuf.i r1 = r7.f8922a
            int r1 = r1.F()
            androidx.datastore.preferences.protobuf.i r2 = r7.f8922a
            int r1 = r2.o(r1)
            java.lang.Object r2 = r9.f8864b
            java.lang.Object r3 = r9.f8866d
        L14:
            int r4 = r7.getFieldNumber()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.datastore.preferences.protobuf.i r5 = r7.f8922a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.skipField()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f8865c     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r5 = r9.f8866d     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r3 = r7.i(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L49:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f8863a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r5 = 0
            java.lang.Object r2 = r7.i(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L51:
            boolean r4 = r7.skipField()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            androidx.datastore.preferences.protobuf.i r8 = r7.f8922a
            r8.n(r1)
            return
        L67:
            androidx.datastore.preferences.protobuf.i r9 = r7.f8922a
            r9.n(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.j.c(java.util.Map, androidx.datastore.preferences.protobuf.h0$a, androidx.datastore.preferences.protobuf.o):void");
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void d(Object obj, b1 b1Var, o oVar) {
        o(3);
        g(obj, b1Var, oVar);
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void e(List list, b1 b1Var, o oVar) {
        int E;
        if (WireFormat.b(this.f8923b) != 3) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int i11 = this.f8923b;
        do {
            list.add(j(b1Var, oVar));
            if (this.f8922a.f() || this.f8925d != 0) {
                return;
            } else {
                E = this.f8922a.E();
            }
        } while (E == i11);
        this.f8925d = E;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public int getFieldNumber() {
        int i11 = this.f8925d;
        if (i11 != 0) {
            this.f8923b = i11;
            this.f8925d = 0;
        } else {
            this.f8923b = this.f8922a.E();
        }
        int i12 = this.f8923b;
        if (i12 == 0 || i12 == this.f8924c) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.a(i12);
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public int getTag() {
        return this.f8923b;
    }

    public Object l(Class cls, o oVar) {
        o(2);
        return k(x0.a().c(cls), oVar);
    }

    public void m(List list, boolean z10) {
        int E;
        int E2;
        if (WireFormat.b(this.f8923b) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        if (!(list instanceof b0) || z10) {
            do {
                list.add(z10 ? readStringRequireUtf8() : readString());
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        b0 b0Var = (b0) list;
        do {
            b0Var.i(readBytes());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public boolean readBool() {
        o(0);
        return this.f8922a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readBoolList(List list) {
        int E;
        int E2;
        if (!(list instanceof f)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 0) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int e11 = this.f8922a.e() + this.f8922a.F();
                do {
                    list.add(Boolean.valueOf(this.f8922a.p()));
                } while (this.f8922a.e() < e11);
                n(e11);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.f8922a.p()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        f fVar = (f) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 0) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int e12 = this.f8922a.e() + this.f8922a.F();
            do {
                fVar.addBoolean(this.f8922a.p());
            } while (this.f8922a.e() < e12);
            n(e12);
            return;
        }
        do {
            fVar.addBoolean(this.f8922a.p());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public ByteString readBytes() {
        o(2);
        return this.f8922a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readBytesList(List list) {
        int E;
        if (WireFormat.b(this.f8923b) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(readBytes());
            if (this.f8922a.f()) {
                return;
            } else {
                E = this.f8922a.E();
            }
        } while (E == this.f8923b);
        this.f8925d = E;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public double readDouble() {
        o(1);
        return this.f8922a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readDoubleList(List list) {
        int E;
        int E2;
        if (!(list instanceof l)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 1) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int F = this.f8922a.F();
                q(F);
                int e11 = this.f8922a.e() + F;
                do {
                    list.add(Double.valueOf(this.f8922a.r()));
                } while (this.f8922a.e() < e11);
                return;
            }
            do {
                list.add(Double.valueOf(this.f8922a.r()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        l lVar = (l) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 1) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int F2 = this.f8922a.F();
            q(F2);
            int e12 = this.f8922a.e() + F2;
            do {
                lVar.addDouble(this.f8922a.r());
            } while (this.f8922a.e() < e12);
            return;
        }
        do {
            lVar.addDouble(this.f8922a.r());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public int readEnum() {
        o(0);
        return this.f8922a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readEnumList(List list) {
        int E;
        int E2;
        if (!(list instanceof v)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 0) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int e11 = this.f8922a.e() + this.f8922a.F();
                do {
                    list.add(Integer.valueOf(this.f8922a.s()));
                } while (this.f8922a.e() < e11);
                n(e11);
                return;
            }
            do {
                list.add(Integer.valueOf(this.f8922a.s()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        v vVar = (v) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 0) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int e12 = this.f8922a.e() + this.f8922a.F();
            do {
                vVar.addInt(this.f8922a.s());
            } while (this.f8922a.e() < e12);
            n(e12);
            return;
        }
        do {
            vVar.addInt(this.f8922a.s());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public int readFixed32() {
        o(5);
        return this.f8922a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readFixed32List(List list) {
        int E;
        int E2;
        if (!(list instanceof v)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 == 2) {
                int F = this.f8922a.F();
                p(F);
                int e11 = this.f8922a.e() + F;
                do {
                    list.add(Integer.valueOf(this.f8922a.t()));
                } while (this.f8922a.e() < e11);
                return;
            }
            if (b11 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.f8922a.t()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        v vVar = (v) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 == 2) {
            int F2 = this.f8922a.F();
            p(F2);
            int e12 = this.f8922a.e() + F2;
            do {
                vVar.addInt(this.f8922a.t());
            } while (this.f8922a.e() < e12);
            return;
        }
        if (b12 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            vVar.addInt(this.f8922a.t());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public long readFixed64() {
        o(1);
        return this.f8922a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readFixed64List(List list) {
        int E;
        int E2;
        if (!(list instanceof f0)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 1) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int F = this.f8922a.F();
                q(F);
                int e11 = this.f8922a.e() + F;
                do {
                    list.add(Long.valueOf(this.f8922a.u()));
                } while (this.f8922a.e() < e11);
                return;
            }
            do {
                list.add(Long.valueOf(this.f8922a.u()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        f0 f0Var = (f0) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 1) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int F2 = this.f8922a.F();
            q(F2);
            int e12 = this.f8922a.e() + F2;
            do {
                f0Var.addLong(this.f8922a.u());
            } while (this.f8922a.e() < e12);
            return;
        }
        do {
            f0Var.addLong(this.f8922a.u());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public float readFloat() {
        o(5);
        return this.f8922a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readFloatList(List list) {
        int E;
        int E2;
        if (!(list instanceof t)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 == 2) {
                int F = this.f8922a.F();
                p(F);
                int e11 = this.f8922a.e() + F;
                do {
                    list.add(Float.valueOf(this.f8922a.v()));
                } while (this.f8922a.e() < e11);
                return;
            }
            if (b11 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Float.valueOf(this.f8922a.v()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        t tVar = (t) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 == 2) {
            int F2 = this.f8922a.F();
            p(F2);
            int e12 = this.f8922a.e() + F2;
            do {
                tVar.addFloat(this.f8922a.v());
            } while (this.f8922a.e() < e12);
            return;
        }
        if (b12 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            tVar.addFloat(this.f8922a.v());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public int readInt32() {
        o(0);
        return this.f8922a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readInt32List(List list) {
        int E;
        int E2;
        if (!(list instanceof v)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 0) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int e11 = this.f8922a.e() + this.f8922a.F();
                do {
                    list.add(Integer.valueOf(this.f8922a.w()));
                } while (this.f8922a.e() < e11);
                n(e11);
                return;
            }
            do {
                list.add(Integer.valueOf(this.f8922a.w()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        v vVar = (v) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 0) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int e12 = this.f8922a.e() + this.f8922a.F();
            do {
                vVar.addInt(this.f8922a.w());
            } while (this.f8922a.e() < e12);
            n(e12);
            return;
        }
        do {
            vVar.addInt(this.f8922a.w());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public long readInt64() {
        o(0);
        return this.f8922a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readInt64List(List list) {
        int E;
        int E2;
        if (!(list instanceof f0)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 0) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int e11 = this.f8922a.e() + this.f8922a.F();
                do {
                    list.add(Long.valueOf(this.f8922a.x()));
                } while (this.f8922a.e() < e11);
                n(e11);
                return;
            }
            do {
                list.add(Long.valueOf(this.f8922a.x()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        f0 f0Var = (f0) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 0) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int e12 = this.f8922a.e() + this.f8922a.F();
            do {
                f0Var.addLong(this.f8922a.x());
            } while (this.f8922a.e() < e12);
            n(e12);
            return;
        }
        do {
            f0Var.addLong(this.f8922a.x());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public int readSFixed32() {
        o(5);
        return this.f8922a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readSFixed32List(List list) {
        int E;
        int E2;
        if (!(list instanceof v)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 == 2) {
                int F = this.f8922a.F();
                p(F);
                int e11 = this.f8922a.e() + F;
                do {
                    list.add(Integer.valueOf(this.f8922a.y()));
                } while (this.f8922a.e() < e11);
                return;
            }
            if (b11 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.f8922a.y()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        v vVar = (v) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 == 2) {
            int F2 = this.f8922a.F();
            p(F2);
            int e12 = this.f8922a.e() + F2;
            do {
                vVar.addInt(this.f8922a.y());
            } while (this.f8922a.e() < e12);
            return;
        }
        if (b12 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            vVar.addInt(this.f8922a.y());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public long readSFixed64() {
        o(1);
        return this.f8922a.z();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readSFixed64List(List list) {
        int E;
        int E2;
        if (!(list instanceof f0)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 1) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int F = this.f8922a.F();
                q(F);
                int e11 = this.f8922a.e() + F;
                do {
                    list.add(Long.valueOf(this.f8922a.z()));
                } while (this.f8922a.e() < e11);
                return;
            }
            do {
                list.add(Long.valueOf(this.f8922a.z()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        f0 f0Var = (f0) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 1) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int F2 = this.f8922a.F();
            q(F2);
            int e12 = this.f8922a.e() + F2;
            do {
                f0Var.addLong(this.f8922a.z());
            } while (this.f8922a.e() < e12);
            return;
        }
        do {
            f0Var.addLong(this.f8922a.z());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public int readSInt32() {
        o(0);
        return this.f8922a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readSInt32List(List list) {
        int E;
        int E2;
        if (!(list instanceof v)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 0) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int e11 = this.f8922a.e() + this.f8922a.F();
                do {
                    list.add(Integer.valueOf(this.f8922a.A()));
                } while (this.f8922a.e() < e11);
                n(e11);
                return;
            }
            do {
                list.add(Integer.valueOf(this.f8922a.A()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        v vVar = (v) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 0) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int e12 = this.f8922a.e() + this.f8922a.F();
            do {
                vVar.addInt(this.f8922a.A());
            } while (this.f8922a.e() < e12);
            n(e12);
            return;
        }
        do {
            vVar.addInt(this.f8922a.A());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public long readSInt64() {
        o(0);
        return this.f8922a.B();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readSInt64List(List list) {
        int E;
        int E2;
        if (!(list instanceof f0)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 0) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int e11 = this.f8922a.e() + this.f8922a.F();
                do {
                    list.add(Long.valueOf(this.f8922a.B()));
                } while (this.f8922a.e() < e11);
                n(e11);
                return;
            }
            do {
                list.add(Long.valueOf(this.f8922a.B()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        f0 f0Var = (f0) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 0) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int e12 = this.f8922a.e() + this.f8922a.F();
            do {
                f0Var.addLong(this.f8922a.B());
            } while (this.f8922a.e() < e12);
            n(e12);
            return;
        }
        do {
            f0Var.addLong(this.f8922a.B());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public String readString() {
        o(2);
        return this.f8922a.C();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readStringList(List list) {
        m(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readStringListRequireUtf8(List list) {
        m(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public String readStringRequireUtf8() {
        o(2);
        return this.f8922a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public int readUInt32() {
        o(0);
        return this.f8922a.F();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readUInt32List(List list) {
        int E;
        int E2;
        if (!(list instanceof v)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 0) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int e11 = this.f8922a.e() + this.f8922a.F();
                do {
                    list.add(Integer.valueOf(this.f8922a.F()));
                } while (this.f8922a.e() < e11);
                n(e11);
                return;
            }
            do {
                list.add(Integer.valueOf(this.f8922a.F()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        v vVar = (v) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 0) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int e12 = this.f8922a.e() + this.f8922a.F();
            do {
                vVar.addInt(this.f8922a.F());
            } while (this.f8922a.e() < e12);
            n(e12);
            return;
        }
        do {
            vVar.addInt(this.f8922a.F());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public long readUInt64() {
        o(0);
        return this.f8922a.G();
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public void readUInt64List(List list) {
        int E;
        int E2;
        if (!(list instanceof f0)) {
            int b11 = WireFormat.b(this.f8923b);
            if (b11 != 0) {
                if (b11 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int e11 = this.f8922a.e() + this.f8922a.F();
                do {
                    list.add(Long.valueOf(this.f8922a.G()));
                } while (this.f8922a.e() < e11);
                n(e11);
                return;
            }
            do {
                list.add(Long.valueOf(this.f8922a.G()));
                if (this.f8922a.f()) {
                    return;
                } else {
                    E = this.f8922a.E();
                }
            } while (E == this.f8923b);
            this.f8925d = E;
            return;
        }
        f0 f0Var = (f0) list;
        int b12 = WireFormat.b(this.f8923b);
        if (b12 != 0) {
            if (b12 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int e12 = this.f8922a.e() + this.f8922a.F();
            do {
                f0Var.addLong(this.f8922a.G());
            } while (this.f8922a.e() < e12);
            n(e12);
            return;
        }
        do {
            f0Var.addLong(this.f8922a.G());
            if (this.f8922a.f()) {
                return;
            } else {
                E2 = this.f8922a.E();
            }
        } while (E2 == this.f8923b);
        this.f8925d = E2;
    }

    @Override // androidx.datastore.preferences.protobuf.a1
    public boolean skipField() {
        int i11;
        if (this.f8922a.f() || (i11 = this.f8923b) == this.f8924c) {
            return false;
        }
        return this.f8922a.H(i11);
    }
}
