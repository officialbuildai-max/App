package androidx.compose.runtime;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k2 implements androidx.compose.runtime.tooling.b, Iterable, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final j2 f3875a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3876b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3877c;

    public k2(j2 j2Var, int i11, int i12) {
        this.f3875a = j2Var;
        this.f3876b = i11;
        this.f3877c = i12;
    }

    private final void a() {
        if (this.f3875a.t() != this.f3877c) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        int I;
        a();
        this.f3875a.A(this.f3876b);
        j2 j2Var = this.f3875a;
        int i11 = this.f3876b;
        I = l2.I(j2Var.o(), this.f3876b);
        return new j0(j2Var, i11 + 1, i11 + I);
    }
}
