package androidx.work;

import android.content.Context;
import androidx.work.b;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class WorkManagerInitializer implements e4.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15482a = t.i("WrkMgrInitializer");

    @Override // e4.a
    public List a() {
        return Collections.emptyList();
    }

    @Override // e4.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public WorkManager b(Context context) {
        t.e().a(f15482a, "Initializing WorkManager with default configuration.");
        WorkManager.h(context, new b.a().a());
        return WorkManager.f(context);
    }
}
