package xa;

import android.graphics.Typeface;

/* loaded from: classes5.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Typeface f78276a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0988a f78277b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f78278c;

    /* renamed from: xa.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0988a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0988a interfaceC0988a, Typeface typeface) {
        this.f78276a = typeface;
        this.f78277b = interfaceC0988a;
    }

    private void d(Typeface typeface) {
        if (this.f78278c) {
            return;
        }
        this.f78277b.a(typeface);
    }

    @Override // xa.f
    public void a(int i11) {
        d(this.f78276a);
    }

    @Override // xa.f
    public void b(Typeface typeface, boolean z10) {
        d(typeface);
    }

    public void c() {
        this.f78278c = true;
    }
}
