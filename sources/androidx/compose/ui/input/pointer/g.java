package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.collection.x f5063a;

    /* renamed from: b, reason: collision with root package name */
    private final y f5064b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5065c;

    public g(androidx.collection.x xVar, y yVar) {
        this.f5063a = xVar;
        this.f5064b = yVar;
    }

    public final boolean a(long j11) {
        Object obj;
        List b11 = this.f5064b.b();
        int size = b11.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                obj = null;
                break;
            }
            obj = b11.get(i11);
            if (v.d(((z) obj).d(), j11)) {
                break;
            }
            i11++;
        }
        z zVar = (z) obj;
        if (zVar != null) {
            return zVar.a();
        }
        return false;
    }

    public final androidx.collection.x b() {
        return this.f5063a;
    }

    public final MotionEvent c() {
        return this.f5064b.a();
    }

    public final boolean d() {
        return this.f5065c;
    }

    public final void e(boolean z10) {
        this.f5065c = z10;
    }
}
