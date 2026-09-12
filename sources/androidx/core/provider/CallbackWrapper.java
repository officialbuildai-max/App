package androidx.core.provider;

import android.graphics.Typeface;
import androidx.core.provider.i;
import androidx.core.provider.k;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CallbackWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final k.c f8259a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f8260b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackWrapper(k.c cVar, Executor executor) {
        this.f8259a = cVar;
        this.f8260b = executor;
    }

    private void a(final int i11) {
        final k.c cVar = this.f8259a;
        this.f8260b.execute(new Runnable() { // from class: androidx.core.provider.CallbackWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(i11);
            }
        });
    }

    private void c(final Typeface typeface) {
        final k.c cVar = this.f8259a;
        this.f8260b.execute(new Runnable() { // from class: androidx.core.provider.CallbackWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.b(typeface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i.e eVar) {
        if (eVar.a()) {
            c(eVar.f8291a);
        } else {
            a(eVar.f8292b);
        }
    }
}
