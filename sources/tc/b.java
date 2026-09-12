package tc;

import com.google.firebase.perf.v1.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    private final f f76300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(f fVar) {
        this.f76300a = fVar;
    }

    @Override // tc.e
    public boolean c() {
        return this.f76300a.u() && (this.f76300a.q() > 0 || this.f76300a.p() > 0 || (this.f76300a.t() && this.f76300a.s().l()));
    }
}
