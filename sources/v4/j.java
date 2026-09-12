package v4;

/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private float f77166a;

    /* renamed from: b, reason: collision with root package name */
    private int f77167b;

    public void a(float f11) {
        float f12 = this.f77166a + f11;
        this.f77166a = f12;
        int i11 = this.f77167b + 1;
        this.f77167b = i11;
        if (i11 == Integer.MAX_VALUE) {
            this.f77166a = f12 / 2.0f;
            this.f77167b = i11 / 2;
        }
    }
}
