package i10;

/* loaded from: classes7.dex */
public class h implements org.mvel2.a {

    /* renamed from: a, reason: collision with root package name */
    private final org.mvel2.a[] f64990a;

    public h(org.mvel2.a... aVarArr) {
        this.f64990a = aVarArr;
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        for (org.mvel2.a aVar : this.f64990a) {
            if (aVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        for (org.mvel2.a aVar : this.f64990a) {
            if (aVar.a(obj.getClass())) {
                return aVar.b(obj);
            }
        }
        return null;
    }
}
