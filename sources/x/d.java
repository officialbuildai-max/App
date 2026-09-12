package x;

import android.view.View;
import android.view.autofill.AutofillManager;

/* loaded from: classes2.dex */
public final class d implements g {

    /* renamed from: a, reason: collision with root package name */
    private final View f78115a;

    /* renamed from: b, reason: collision with root package name */
    private final w f78116b;

    /* renamed from: c, reason: collision with root package name */
    private final AutofillManager f78117c;

    public d(View view, w wVar) {
        this.f78115a = view;
        this.f78116b = wVar;
        AutofillManager a11 = b.a(view.getContext().getSystemService(a.a()));
        if (a11 == null) {
            throw new IllegalStateException("Autofill service could not be located.");
        }
        this.f78117c = a11;
        view.setImportantForAutofill(1);
    }

    public final AutofillManager a() {
        return this.f78117c;
    }

    public final w b() {
        return this.f78116b;
    }

    public final View c() {
        return this.f78115a;
    }
}
