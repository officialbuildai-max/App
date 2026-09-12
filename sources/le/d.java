package le;

import android.content.Context;
import com.iab.omid.library.mmadbridge.internal.i;
import com.iab.omid.library.mmadbridge.internal.j;
import oe.g;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f68933a;

    private void c(Context context) {
        g.d(context, "Application Context cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        c(context);
        if (d()) {
            return;
        }
        b(true);
        i.d().b(context);
        com.iab.omid.library.mmadbridge.internal.b.k().a(context);
        oe.a.b(context);
        oe.c.d(context);
        oe.e.c(context);
        com.iab.omid.library.mmadbridge.internal.g.c().b(context);
        com.iab.omid.library.mmadbridge.internal.a.a().b(context);
        j.f().b(context);
    }

    void b(boolean z10) {
        this.f68933a = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f68933a;
    }
}
