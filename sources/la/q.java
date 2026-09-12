package la;

import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.z2;
import t9.x;

/* loaded from: classes3.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private a f68921a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.exoplayer2.upstream.e f68922b;

    /* loaded from: classes3.dex */
    public interface a {
        void onTrackSelectionsInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.android.exoplayer2.upstream.e a() {
        return (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.i(this.f68922b);
    }

    public TrackSelectionParameters b() {
        return TrackSelectionParameters.A;
    }

    public void c(a aVar, com.google.android.exoplayer2.upstream.e eVar) {
        this.f68921a = aVar;
        this.f68922b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        a aVar = this.f68921a;
        if (aVar != null) {
            aVar.onTrackSelectionsInvalidated();
        }
    }

    public boolean e() {
        return false;
    }

    public abstract void f(Object obj);

    public void g() {
        this.f68921a = null;
        this.f68922b = null;
    }

    public abstract r h(z2[] z2VarArr, x xVar, o.b bVar, k3 k3Var);

    public void i(com.google.android.exoplayer2.audio.e eVar) {
    }

    public void j(TrackSelectionParameters trackSelectionParameters) {
    }
}
