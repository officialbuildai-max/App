package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Map;

/* loaded from: classes.dex */
final class q extends p {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.p
    public int a(Map.Entry entry) {
        android.support.v4.media.session.c.a(entry.getKey());
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.p
    public Object b(o oVar, n0 n0Var, int i11) {
        oVar.a(n0Var, i11);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.p
    public s c(Object obj) {
        return ((GeneratedMessageLite.c) obj).extensions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.p
    public s d(Object obj) {
        return ((GeneratedMessageLite.c) obj).K();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.p
    public boolean e(n0 n0Var) {
        return n0Var instanceof GeneratedMessageLite.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.p
    public void f(Object obj) {
        c(obj).q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.p
    public Object g(Object obj, a1 a1Var, Object obj2, o oVar, s sVar, Object obj3, h1 h1Var) {
        android.support.v4.media.session.c.a(obj2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.p
    public void h(a1 a1Var, Object obj, o oVar, s sVar) {
        android.support.v4.media.session.c.a(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.p
    public void i(ByteString byteString, Object obj, o oVar, s sVar) {
        android.support.v4.media.session.c.a(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.p
    public void j(Writer writer, Map.Entry entry) {
        android.support.v4.media.session.c.a(entry.getKey());
        throw null;
    }
}
