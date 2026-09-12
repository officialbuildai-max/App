package pc;

import android.content.Context;
import com.google.firebase.n;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.session.SessionManager;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class b {
    public b(com.google.firebase.f fVar, n nVar, Executor executor) {
        Context k11 = fVar.k();
        com.google.firebase.perf.config.a.g().O(k11);
        com.google.firebase.perf.application.a b11 = com.google.firebase.perf.application.a.b();
        b11.i(k11);
        b11.j(new f());
        if (nVar != null) {
            AppStartTrace j11 = AppStartTrace.j();
            j11.t(k11);
            executor.execute(new AppStartTrace.StartFromBackgroundRunnable(j11));
        }
        SessionManager.getInstance().initializeGaugeCollection();
    }
}
