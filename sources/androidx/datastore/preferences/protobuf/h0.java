package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;

/* loaded from: classes.dex */
public class h0 {

    /* renamed from: a, reason: collision with root package name */
    private final a f8860a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f8861b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f8862c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f8863a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f8864b;

        /* renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f8865c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f8866d;

        public a(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
            this.f8863a = fieldType;
            this.f8864b = obj;
            this.f8865c = fieldType2;
            this.f8866d = obj2;
        }
    }

    private h0(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        this.f8860a = new a(fieldType, obj, fieldType2, obj2);
        this.f8861b = obj;
        this.f8862c = obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(a aVar, Object obj, Object obj2) {
        return s.b(aVar.f8863a, 1, obj) + s.b(aVar.f8865c, 2, obj2);
    }

    public static h0 d(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        return new h0(fieldType, obj, fieldType2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(CodedOutputStream codedOutputStream, a aVar, Object obj, Object obj2) {
        s.w(codedOutputStream, aVar.f8863a, 1, obj);
        s.w(codedOutputStream, aVar.f8865c, 2, obj2);
    }

    public int a(int i11, Object obj, Object obj2) {
        return CodedOutputStream.S(i11) + CodedOutputStream.C(b(this.f8860a, obj, obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c() {
        return this.f8860a;
    }
}
