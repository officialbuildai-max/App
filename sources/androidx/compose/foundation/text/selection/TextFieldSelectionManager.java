package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.f;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.platform.h2;
import androidx.compose.ui.platform.q0;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.b0;
import androidx.compose.ui.text.c0;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.d0;
import androidx.compose.ui.text.input.j0;
import androidx.compose.ui.text.input.v;
import androidx.compose.ui.text.input.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import y.g;
import y.i;

/* loaded from: classes.dex */
public final class TextFieldSelectionManager {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.foundation.text.d f3400a;

    /* renamed from: b, reason: collision with root package name */
    private v f3401b;

    /* renamed from: c, reason: collision with root package name */
    private Function1 f3402c;

    /* renamed from: d, reason: collision with root package name */
    private final i1 f3403d;

    /* renamed from: e, reason: collision with root package name */
    private j0 f3404e;

    /* renamed from: f, reason: collision with root package name */
    private q0 f3405f;

    /* renamed from: g, reason: collision with root package name */
    private h2 f3406g;

    /* renamed from: h, reason: collision with root package name */
    private final i1 f3407h;

    /* renamed from: i, reason: collision with root package name */
    private final i1 f3408i;

    /* renamed from: j, reason: collision with root package name */
    private long f3409j;

    /* renamed from: k, reason: collision with root package name */
    private long f3410k;

    /* renamed from: l, reason: collision with root package name */
    private final i1 f3411l;

    /* renamed from: m, reason: collision with root package name */
    private final i1 f3412m;

    /* renamed from: n, reason: collision with root package name */
    private int f3413n;

    /* renamed from: o, reason: collision with root package name */
    private TextFieldValue f3414o;

    /* renamed from: p, reason: collision with root package name */
    private final androidx.compose.foundation.text.c f3415p;

    /* renamed from: q, reason: collision with root package name */
    private final androidx.compose.foundation.text.selection.a f3416q;

    /* loaded from: classes.dex */
    public static final class a implements androidx.compose.foundation.text.selection.a {
        a() {
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements androidx.compose.foundation.text.c {
        b() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldSelectionManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TextFieldSelectionManager(androidx.compose.foundation.text.d dVar) {
        i1 c11;
        i1 c12;
        i1 c13;
        i1 c14;
        i1 c15;
        this.f3400a = dVar;
        this.f3401b = f.b();
        this.f3402c = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TextFieldValue) obj);
                return Unit.f67184a;
            }

            public final void invoke(TextFieldValue textFieldValue) {
            }
        };
        c11 = u2.c(new TextFieldValue((String) null, 0L, (b0) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.f3403d = c11;
        this.f3404e = j0.f6308a.a();
        Boolean bool = Boolean.TRUE;
        c12 = u2.c(bool, null, 2, null);
        this.f3407h = c12;
        c13 = u2.c(bool, null, 2, null);
        this.f3408i = c13;
        g.a aVar = g.f78593b;
        this.f3409j = aVar.c();
        this.f3410k = aVar.c();
        c14 = u2.c(null, null, 2, null);
        this.f3411l = c14;
        c15 = u2.c(null, null, 2, null);
        this.f3412m = c15;
        this.f3413n = -1;
        this.f3414o = new TextFieldValue((String) null, 0L, (b0) null, 7, (DefaultConstructorMarker) null);
        this.f3415p = new b();
        this.f3416q = new a();
    }

    public /* synthetic */ TextFieldSelectionManager(androidx.compose.foundation.text.d dVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : dVar);
    }

    public static /* synthetic */ void b(TextFieldSelectionManager textFieldSelectionManager, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        textFieldSelectionManager.a(z10);
    }

    private final TextFieldValue c(AnnotatedString annotatedString, long j11) {
        return new TextFieldValue(annotatedString, j11, (b0) null, 4, (DefaultConstructorMarker) null);
    }

    private final i f() {
        return i.f78598e.a();
    }

    private final void m(HandleState handleState) {
    }

    private final void o(boolean z10) {
        if (z10) {
            n();
        } else {
            j();
        }
    }

    public final void a(boolean z10) {
        if (b0.f(i().e())) {
            return;
        }
        q0 q0Var = this.f3405f;
        if (q0Var != null) {
            q0Var.c(d0.a(i()));
        }
        if (z10) {
            int i11 = b0.i(i().e());
            this.f3402c.invoke(c(i().c(), c0.b(i11, i11)));
            m(HandleState.None);
        }
    }

    public final void d() {
        if (b0.f(i().e())) {
            return;
        }
        q0 q0Var = this.f3405f;
        if (q0Var != null) {
            q0Var.c(d0.a(i()));
        }
        AnnotatedString n11 = d0.c(i(), i().f().length()).n(d0.b(i(), i().f().length()));
        int j11 = b0.j(i().e());
        this.f3402c.invoke(c(n11, c0.b(j11, j11)));
        m(HandleState.None);
        androidx.compose.foundation.text.d dVar = this.f3400a;
        if (dVar != null) {
            dVar.a();
        }
    }

    public final void e(boolean z10) {
        this.f3414o = i();
        o(z10);
        m(HandleState.Selection);
    }

    public final boolean g() {
        return ((Boolean) this.f3407h.getValue()).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) this.f3408i.getValue()).booleanValue();
    }

    public final TextFieldValue i() {
        return (TextFieldValue) this.f3403d.getValue();
    }

    public final void j() {
        h2 h2Var;
        h2 h2Var2 = this.f3406g;
        if ((h2Var2 != null ? h2Var2.getStatus() : null) != TextToolbarStatus.Shown || (h2Var = this.f3406g) == null) {
            return;
        }
        h2Var.hide();
    }

    public final void k() {
        AnnotatedString a11;
        q0 q0Var = this.f3405f;
        if (q0Var == null || (a11 = q0Var.a()) == null) {
            return;
        }
        AnnotatedString n11 = d0.c(i(), i().f().length()).n(a11).n(d0.b(i(), i().f().length()));
        int j11 = b0.j(i().e()) + a11.length();
        this.f3402c.invoke(c(n11, c0.b(j11, j11)));
        m(HandleState.None);
        androidx.compose.foundation.text.d dVar = this.f3400a;
        if (dVar != null) {
            dVar.a();
        }
    }

    public final void l() {
        TextFieldValue c11 = c(i().c(), c0.b(0, i().f().length()));
        this.f3402c.invoke(c11);
        this.f3414o = TextFieldValue.b(this.f3414o, null, c11.e(), null, 5, null);
        e(true);
    }

    public final void n() {
        q0 q0Var;
        if (h()) {
            boolean z10 = this.f3404e instanceof w;
            Function0<Unit> function0 = (b0.f(i().e()) || z10) ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m65invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m65invoke() {
                    TextFieldSelectionManager.b(TextFieldSelectionManager.this, false, 1, null);
                    TextFieldSelectionManager.this.j();
                }
            };
            Function0<Unit> function02 = (b0.f(i().e()) || !g() || z10) ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m66invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m66invoke() {
                    TextFieldSelectionManager.this.d();
                    TextFieldSelectionManager.this.j();
                }
            };
            Function0<Unit> function03 = (g() && (q0Var = this.f3405f) != null && q0Var.b()) ? new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m67invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m67invoke() {
                    TextFieldSelectionManager.this.k();
                    TextFieldSelectionManager.this.j();
                }
            } : null;
            Function0<Unit> function04 = b0.h(i().e()) != i().f().length() ? new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m68invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m68invoke() {
                    TextFieldSelectionManager.this.l();
                }
            } : null;
            h2 h2Var = this.f3406g;
            if (h2Var != null) {
                h2Var.a(f(), function0, function03, function02, function04);
            }
        }
    }
}
