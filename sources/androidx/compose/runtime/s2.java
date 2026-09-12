package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract /* synthetic */ class s2 {

    /* renamed from: a, reason: collision with root package name */
    private static final v2 f3959a = new v2();

    /* renamed from: b, reason: collision with root package name */
    private static final v2 f3960b = new v2();

    public static final androidx.compose.runtime.collection.b b() {
        v2 v2Var = f3960b;
        androidx.compose.runtime.collection.b bVar = (androidx.compose.runtime.collection.b) v2Var.a();
        if (bVar != null) {
            return bVar;
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new a0[0], 0);
        v2Var.b(bVar2);
        return bVar2;
    }

    public static final a3 c(q2 q2Var, Function0 function0) {
        return new DerivedSnapshotState(function0, q2Var);
    }

    public static final a3 d(Function0 function0) {
        return new DerivedSnapshotState(function0, null);
    }
}
