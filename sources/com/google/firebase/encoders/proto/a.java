package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f31871a;

    /* renamed from: b, reason: collision with root package name */
    private Protobuf.IntEncoding f31872b = Protobuf.IntEncoding.DEFAULT;

    /* renamed from: com.google.firebase.encoders.proto.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C0441a implements Protobuf {

        /* renamed from: b, reason: collision with root package name */
        private final int f31873b;

        /* renamed from: c, reason: collision with root package name */
        private final Protobuf.IntEncoding f31874c;

        C0441a(int i11, Protobuf.IntEncoding intEncoding) {
            this.f31873b = i11;
            this.f31874c = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public Class annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            return this.f31873b == protobuf.tag() && this.f31874c.equals(protobuf.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f31873b) + (this.f31874c.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.f31874c;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.f31873b;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f31873b + "intEncoding=" + this.f31874c + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public Protobuf a() {
        return new C0441a(this.f31871a, this.f31872b);
    }

    public a c(int i11) {
        this.f31871a = i11;
        return this;
    }
}
