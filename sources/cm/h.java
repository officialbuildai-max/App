package cm;

/* loaded from: classes5.dex */
public class h extends g {

    /* renamed from: c, reason: collision with root package name */
    private final Object f17373c;

    public h(int i11) {
        super(i11);
        this.f17373c = new Object();
    }

    @Override // cm.g, cm.f
    public Object acquire() {
        Object acquire;
        synchronized (this.f17373c) {
            acquire = super.acquire();
        }
        return acquire;
    }

    @Override // cm.g, cm.f
    public boolean release(Object obj) {
        boolean release;
        synchronized (this.f17373c) {
            release = super.release(obj);
        }
        return release;
    }
}
