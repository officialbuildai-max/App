package androidx.compose.ui.platform.coreshims;

import android.view.autofill.AutofillId;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Object f5828a;

    private b(AutofillId autofillId) {
        this.f5828a = autofillId;
    }

    public static b b(AutofillId autofillId) {
        return new b(autofillId);
    }

    public AutofillId a() {
        return a.a(this.f5828a);
    }
}
