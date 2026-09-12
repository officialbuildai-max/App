package n5;

/* loaded from: classes3.dex */
public class b implements m7.a {

    /* renamed from: a, reason: collision with root package name */
    private int f70372a;

    /* renamed from: b, reason: collision with root package name */
    private int f70373b;

    public b(int i11, int i12) {
        this.f70372a = i11;
        this.f70373b = i12;
    }

    @Override // m7.a
    public int a() {
        return (this.f70373b - this.f70372a) + 1;
    }

    @Override // m7.a
    public Object getItem(int i11) {
        if (i11 < 0 || i11 >= a()) {
            return 0;
        }
        return Integer.valueOf(this.f70372a + i11);
    }
}
