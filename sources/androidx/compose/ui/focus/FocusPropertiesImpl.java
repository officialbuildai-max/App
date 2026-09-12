package androidx.compose.ui.focus;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class FocusPropertiesImpl implements k {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4287a = true;

    /* renamed from: b, reason: collision with root package name */
    private FocusRequester f4288b;

    /* renamed from: c, reason: collision with root package name */
    private FocusRequester f4289c;

    /* renamed from: d, reason: collision with root package name */
    private FocusRequester f4290d;

    /* renamed from: e, reason: collision with root package name */
    private FocusRequester f4291e;

    /* renamed from: f, reason: collision with root package name */
    private FocusRequester f4292f;

    /* renamed from: g, reason: collision with root package name */
    private FocusRequester f4293g;

    /* renamed from: h, reason: collision with root package name */
    private FocusRequester f4294h;

    /* renamed from: i, reason: collision with root package name */
    private FocusRequester f4295i;

    /* renamed from: j, reason: collision with root package name */
    private Function1 f4296j;

    /* renamed from: k, reason: collision with root package name */
    private Function1 f4297k;

    public FocusPropertiesImpl() {
        FocusRequester.a aVar = FocusRequester.f4298b;
        this.f4288b = aVar.b();
        this.f4289c = aVar.b();
        this.f4290d = aVar.b();
        this.f4291e = aVar.b();
        this.f4292f = aVar.b();
        this.f4293g = aVar.b();
        this.f4294h = aVar.b();
        this.f4295i = aVar.b();
        this.f4296j = new Function1<b, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$enter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m108invoke3ESFkO8(((b) obj).o());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m108invoke3ESFkO8(int i11) {
                return FocusRequester.f4298b.b();
            }
        };
        this.f4297k = new Function1<b, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$exit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m109invoke3ESFkO8(((b) obj).o());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m109invoke3ESFkO8(int i11) {
                return FocusRequester.f4298b.b();
            }
        };
    }

    @Override // androidx.compose.ui.focus.k
    public FocusRequester i() {
        return this.f4292f;
    }

    @Override // androidx.compose.ui.focus.k
    public FocusRequester j() {
        return this.f4294h;
    }

    @Override // androidx.compose.ui.focus.k
    public FocusRequester k() {
        return this.f4288b;
    }

    @Override // androidx.compose.ui.focus.k
    public FocusRequester m() {
        return this.f4293g;
    }

    @Override // androidx.compose.ui.focus.k
    public FocusRequester n() {
        return this.f4290d;
    }

    @Override // androidx.compose.ui.focus.k
    public Function1 o() {
        return this.f4297k;
    }

    @Override // androidx.compose.ui.focus.k
    public FocusRequester p() {
        return this.f4295i;
    }

    @Override // androidx.compose.ui.focus.k
    public FocusRequester q() {
        return this.f4291e;
    }

    @Override // androidx.compose.ui.focus.k
    public void r(boolean z10) {
        this.f4287a = z10;
    }

    @Override // androidx.compose.ui.focus.k
    public Function1 s() {
        return this.f4296j;
    }

    @Override // androidx.compose.ui.focus.k
    public boolean t() {
        return this.f4287a;
    }

    @Override // androidx.compose.ui.focus.k
    public FocusRequester u() {
        return this.f4289c;
    }
}
