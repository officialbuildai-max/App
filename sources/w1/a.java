package w1;

import androidx.media3.common.util.a1;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class a implements androidx.media3.datasource.a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f77620a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f77621b = new ArrayList(1);

    /* renamed from: c, reason: collision with root package name */
    private int f77622c;

    /* renamed from: d, reason: collision with root package name */
    private h f77623d;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(boolean z10) {
        this.f77620a = z10;
    }

    @Override // androidx.media3.datasource.a
    public final void c(n nVar) {
        androidx.media3.common.util.a.e(nVar);
        if (this.f77621b.contains(nVar)) {
            return;
        }
        this.f77621b.add(nVar);
        this.f77622c++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(int i11) {
        h hVar = (h) a1.i(this.f77623d);
        for (int i12 = 0; i12 < this.f77622c; i12++) {
            ((n) this.f77621b.get(i12)).e(this, hVar, this.f77620a, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        h hVar = (h) a1.i(this.f77623d);
        for (int i11 = 0; i11 < this.f77622c; i11++) {
            ((n) this.f77621b.get(i11)).f(this, hVar, this.f77620a);
        }
        this.f77623d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(h hVar) {
        for (int i11 = 0; i11 < this.f77622c; i11++) {
            ((n) this.f77621b.get(i11)).g(this, hVar, this.f77620a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(h hVar) {
        this.f77623d = hVar;
        for (int i11 = 0; i11 < this.f77622c; i11++) {
            ((n) this.f77621b.get(i11)).h(this, hVar, this.f77620a);
        }
    }

    @Override // androidx.media3.datasource.a
    public /* synthetic */ Map getResponseHeaders() {
        return e.a(this);
    }
}
