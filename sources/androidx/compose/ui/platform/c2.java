package androidx.compose.ui.platform;

import androidx.compose.ui.semantics.SemanticsNode;
import java.util.List;

/* loaded from: classes.dex */
public final class c2 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.semantics.i f5826a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.collection.f0 f5827b = androidx.collection.r.b();

    public c2(SemanticsNode semanticsNode, androidx.collection.o oVar) {
        this.f5826a = semanticsNode.w();
        List t11 = semanticsNode.t();
        int size = t11.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) t11.get(i11);
            if (oVar.a(semanticsNode2.o())) {
                this.f5827b.f(semanticsNode2.o());
            }
        }
    }

    public final androidx.collection.f0 a() {
        return this.f5827b;
    }

    public final androidx.compose.ui.semantics.i b() {
        return this.f5826a;
    }
}
