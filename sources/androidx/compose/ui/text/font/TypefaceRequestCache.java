package androidx.compose.ui.text.font;

import androidx.compose.runtime.a3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class TypefaceRequestCache {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.text.platform.p f6183a = androidx.compose.ui.text.platform.o.a();

    /* renamed from: b, reason: collision with root package name */
    private final m0.b f6184b = new m0.b(16);

    public final androidx.compose.ui.text.platform.p b() {
        return this.f6183a;
    }

    public final a3 c(final d0 d0Var, Function1 function1) {
        synchronized (this.f6183a) {
            e0 e0Var = (e0) this.f6184b.d(d0Var);
            if (e0Var != null) {
                if (e0Var.a()) {
                    return e0Var;
                }
            }
            try {
                e0 e0Var2 = (e0) function1.invoke(new Function1<e0, Unit>() { // from class: androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((e0) obj);
                        return Unit.f67184a;
                    }

                    public final void invoke(e0 e0Var3) {
                        m0.b bVar;
                        m0.b bVar2;
                        androidx.compose.ui.text.platform.p b11 = TypefaceRequestCache.this.b();
                        TypefaceRequestCache typefaceRequestCache = TypefaceRequestCache.this;
                        d0 d0Var2 = d0Var;
                        synchronized (b11) {
                            try {
                                if (e0Var3.a()) {
                                    bVar2 = typefaceRequestCache.f6184b;
                                    bVar2.e(d0Var2, e0Var3);
                                } else {
                                    bVar = typefaceRequestCache.f6184b;
                                    bVar.f(d0Var2);
                                }
                                Unit unit = Unit.f67184a;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                });
                synchronized (this.f6183a) {
                    try {
                        if (this.f6184b.d(d0Var) == null && e0Var2.a()) {
                            this.f6184b.e(d0Var, e0Var2);
                        }
                        Unit unit = Unit.f67184a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return e0Var2;
            } catch (Exception e11) {
                throw new IllegalStateException("Could not load font", e11);
            }
        }
    }
}
