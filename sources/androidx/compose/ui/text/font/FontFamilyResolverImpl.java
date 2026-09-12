package androidx.compose.ui.text.font;

import androidx.compose.runtime.a3;
import androidx.compose.ui.text.font.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class FontFamilyResolverImpl implements h.b {

    /* renamed from: a, reason: collision with root package name */
    private final u f6177a;

    /* renamed from: b, reason: collision with root package name */
    private final w f6178b;

    /* renamed from: c, reason: collision with root package name */
    private final TypefaceRequestCache f6179c;

    /* renamed from: d, reason: collision with root package name */
    private final l f6180d;

    /* renamed from: e, reason: collision with root package name */
    private final t f6181e;

    /* renamed from: f, reason: collision with root package name */
    private final Function1 f6182f;

    public FontFamilyResolverImpl(u uVar, w wVar, TypefaceRequestCache typefaceRequestCache, l lVar, t tVar) {
        this.f6177a = uVar;
        this.f6178b = wVar;
        this.f6179c = typefaceRequestCache;
        this.f6180d = lVar;
        this.f6181e = tVar;
        this.f6182f = new Function1<d0, Object>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$createDefaultTypeface$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(d0 d0Var) {
                a3 g11;
                g11 = FontFamilyResolverImpl.this.g(d0.b(d0Var, null, null, 0, 0, null, 30, null));
                return g11.getValue();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ FontFamilyResolverImpl(u uVar, w wVar, TypefaceRequestCache typefaceRequestCache, l lVar, t tVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(uVar, (i11 & 2) != 0 ? w.f6250a.a() : wVar, (i11 & 4) != 0 ? j.b() : typefaceRequestCache, (i11 & 8) != 0 ? new l(j.a(), null, 2, 0 == true ? 1 : 0) : lVar, (i11 & 16) != 0 ? new t() : tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a3 g(final d0 d0Var) {
        return this.f6179c.c(d0Var, new Function1<Function1<? super e0, ? extends Unit>, e0>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$resolve$result$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final e0 invoke(Function1<? super e0, Unit> function1) {
                l lVar;
                Function1 function12;
                t tVar;
                Function1 function13;
                lVar = FontFamilyResolverImpl.this.f6180d;
                d0 d0Var2 = d0Var;
                u f11 = FontFamilyResolverImpl.this.f();
                function12 = FontFamilyResolverImpl.this.f6182f;
                e0 a11 = lVar.a(d0Var2, f11, function1, function12);
                if (a11 == null) {
                    tVar = FontFamilyResolverImpl.this.f6181e;
                    d0 d0Var3 = d0Var;
                    u f12 = FontFamilyResolverImpl.this.f();
                    function13 = FontFamilyResolverImpl.this.f6182f;
                    a11 = tVar.a(d0Var3, f12, function1, function13);
                    if (a11 == null) {
                        throw new IllegalStateException("Could not load font");
                    }
                }
                return a11;
            }
        });
    }

    @Override // androidx.compose.ui.text.font.h.b
    public a3 a(h hVar, p pVar, int i11, int i12) {
        return g(new d0(this.f6178b.d(hVar), this.f6178b.a(pVar), this.f6178b.b(i11), this.f6178b.c(i12), this.f6177a.a(), null));
    }

    public final u f() {
        return this.f6177a;
    }
}
