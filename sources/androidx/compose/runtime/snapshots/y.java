package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;

/* loaded from: classes.dex */
abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private final t f4111a;

    /* renamed from: b, reason: collision with root package name */
    private final Iterator f4112b;

    /* renamed from: c, reason: collision with root package name */
    private int f4113c;

    /* renamed from: d, reason: collision with root package name */
    private Map.Entry f4114d;

    /* renamed from: e, reason: collision with root package name */
    private Map.Entry f4115e;

    public y(t tVar, Iterator it) {
        this.f4111a = tVar;
        this.f4112b = it;
        this.f4113c = tVar.e();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        this.f4114d = this.f4115e;
        this.f4115e = this.f4112b.hasNext() ? (Map.Entry) this.f4112b.next() : null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map.Entry f() {
        return this.f4114d;
    }

    public final t h() {
        return this.f4111a;
    }

    public final boolean hasNext() {
        return this.f4115e != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map.Entry i() {
        return this.f4115e;
    }

    public final void remove() {
        if (h().e() != this.f4113c) {
            throw new ConcurrentModificationException();
        }
        Map.Entry entry = this.f4114d;
        if (entry == null) {
            throw new IllegalStateException();
        }
        this.f4111a.remove(entry.getKey());
        this.f4114d = null;
        Unit unit = Unit.f67184a;
        this.f4113c = h().e();
    }
}
