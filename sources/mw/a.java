package mw;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private Reference f70140a;

    public final void a(Object obj) {
        this.f70140a = new WeakReference(obj);
    }

    public void b() {
        Reference reference = this.f70140a;
        if (reference != null) {
            Intrinsics.e(reference);
            reference.clear();
            this.f70140a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object c() {
        Reference reference = this.f70140a;
        if (reference == null) {
            return null;
        }
        Intrinsics.e(reference);
        return reference.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean d() {
        Reference reference = this.f70140a;
        if (reference != null) {
            Intrinsics.e(reference);
            if (reference.get() != null) {
                return true;
            }
        }
        return false;
    }
}
