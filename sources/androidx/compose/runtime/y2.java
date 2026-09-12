package androidx.compose.runtime;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
final class y2 implements androidx.compose.runtime.tooling.b, Iterable, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final j2 f4149a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4150b;

    /* renamed from: c, reason: collision with root package name */
    private final l0 f4151c;

    /* renamed from: d, reason: collision with root package name */
    private final x2 f4152d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f4153e;

    /* renamed from: f, reason: collision with root package name */
    private final Iterable f4154f = this;

    public y2(j2 j2Var, int i11, l0 l0Var, x2 x2Var) {
        this.f4149a = j2Var;
        this.f4150b = i11;
        this.f4152d = x2Var;
        this.f4153e = Integer.valueOf(l0Var.c());
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new w2(this.f4149a, this.f4150b, this.f4151c, this.f4152d);
    }
}
