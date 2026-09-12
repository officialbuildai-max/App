package fe;

import android.content.Context;
import com.iab.omid.library.hisavana.internal.i;
import com.iab.omid.library.hisavana.internal.j;
import ie.e;
import ie.g;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f62504a;

    private void d(Context context) {
        g.d(context, "Application Context cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return "1.5.4-Hisavana";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context) {
        d(context);
        if (e()) {
            return;
        }
        c(true);
        i.d().b(context);
        com.iab.omid.library.hisavana.internal.b.k().a(context);
        ie.a.b(context);
        ie.c.d(context);
        e.c(context);
        com.iab.omid.library.hisavana.internal.g.c().b(context);
        com.iab.omid.library.hisavana.internal.a.a().b(context);
        j.f().b(context);
    }

    void c(boolean z10) {
        this.f62504a = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f62504a;
    }
}
