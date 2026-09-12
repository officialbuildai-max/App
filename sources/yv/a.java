package yv;

/* loaded from: classes7.dex */
public final class a {
    public final c a() {
        c cVar = c.f79184e;
        if (cVar == null) {
            synchronized (this) {
                cVar = c.f79184e;
                if (cVar == null) {
                    cVar = new c();
                    c.f79184e = cVar;
                }
            }
        }
        return cVar;
    }
}
