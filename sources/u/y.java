package u;

import java.util.Map;

/* loaded from: classes2.dex */
public final class y extends u {

    /* renamed from: d, reason: collision with root package name */
    private final i f76651d;

    public y(i iVar) {
        this.f76651d = iVar;
    }

    @Override // java.util.Iterator
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        w.a.a(h());
        o(f() + 2);
        return new c(this.f76651d, e()[f() - 2], e()[f() - 1]);
    }
}
