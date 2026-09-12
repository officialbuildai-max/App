package pc;

import com.google.firebase.perf.application.a;

/* loaded from: classes5.dex */
public final class f implements a.InterfaceC0447a {

    /* renamed from: a, reason: collision with root package name */
    private static final sc.a f72543a = sc.a.e();

    @Override // com.google.firebase.perf.application.a.InterfaceC0447a
    public void a() {
        try {
            e.c();
        } catch (IllegalStateException e11) {
            f72543a.k("FirebaseApp is not initialized. Firebase Performance will not be collecting any performance metrics until initialized. %s", e11);
        }
    }
}
