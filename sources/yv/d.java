package yv;

/* loaded from: classes7.dex */
public final class d {
    public final f a() {
        f fVar = f.f79191p;
        if (fVar == null) {
            synchronized (this) {
                fVar = f.f79191p;
                if (fVar == null) {
                    fVar = new f();
                    f.f79191p = fVar;
                }
            }
        }
        return fVar;
    }
}
