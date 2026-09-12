package i3;

import android.util.SparseArray;
import i3.s;
import l2.m0;
import l2.s0;

/* loaded from: classes2.dex */
public final class t implements l2.t {

    /* renamed from: a, reason: collision with root package name */
    private final l2.t f65050a;

    /* renamed from: b, reason: collision with root package name */
    private final s.a f65051b;

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray f65052c = new SparseArray();

    /* renamed from: d, reason: collision with root package name */
    private boolean f65053d;

    public t(l2.t tVar, s.a aVar) {
        this.f65050a = tVar;
        this.f65051b = aVar;
    }

    @Override // l2.t
    public void endTracks() {
        this.f65050a.endTracks();
        if (this.f65053d) {
            for (int i11 = 0; i11 < this.f65052c.size(); i11++) {
                ((v) this.f65052c.valueAt(i11)).l(true);
            }
        }
    }

    @Override // l2.t
    public void f(m0 m0Var) {
        this.f65050a.f(m0Var);
    }

    @Override // l2.t
    public s0 track(int i11, int i12) {
        if (i12 != 3) {
            this.f65053d = true;
            return this.f65050a.track(i11, i12);
        }
        v vVar = (v) this.f65052c.get(i11);
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v(this.f65050a.track(i11, i12), this.f65051b);
        this.f65052c.put(i11, vVar2);
        return vVar2;
    }
}
