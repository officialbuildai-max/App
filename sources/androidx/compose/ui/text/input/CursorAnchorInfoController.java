package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.graphics.i4;
import androidx.compose.ui.graphics.r0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class CursorAnchorInfoController {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.input.pointer.i0 f6255a;

    /* renamed from: b, reason: collision with root package name */
    private final r f6256b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6258d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6259e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6260f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6261g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6262h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6263i;

    /* renamed from: j, reason: collision with root package name */
    private TextFieldValue f6264j;

    /* renamed from: k, reason: collision with root package name */
    private androidx.compose.ui.text.z f6265k;

    /* renamed from: l, reason: collision with root package name */
    private v f6266l;

    /* renamed from: n, reason: collision with root package name */
    private y.i f6268n;

    /* renamed from: o, reason: collision with root package name */
    private y.i f6269o;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6257c = new Object();

    /* renamed from: m, reason: collision with root package name */
    private Function1 f6267m = new Function1<i4, Unit>() { // from class: androidx.compose.ui.text.input.CursorAnchorInfoController$textFieldToRootTransform$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m177invoke58bKbWc(((i4) obj).r());
            return Unit.f67184a;
        }

        /* renamed from: invoke-58bKbWc, reason: not valid java name */
        public final void m177invoke58bKbWc(float[] fArr) {
        }
    };

    /* renamed from: p, reason: collision with root package name */
    private final CursorAnchorInfo.Builder f6270p = new CursorAnchorInfo.Builder();

    /* renamed from: q, reason: collision with root package name */
    private final float[] f6271q = i4.c(null, 1, null);

    /* renamed from: r, reason: collision with root package name */
    private final Matrix f6272r = new Matrix();

    public CursorAnchorInfoController(androidx.compose.ui.input.pointer.i0 i0Var, r rVar) {
        this.f6255a = i0Var;
        this.f6256b = rVar;
    }

    private final void b() {
        if (this.f6256b.isActive()) {
            this.f6267m.invoke(i4.a(this.f6271q));
            this.f6255a.mo115localToScreen58bKbWc(this.f6271q);
            r0.a(this.f6272r, this.f6271q);
            r rVar = this.f6256b;
            CursorAnchorInfo.Builder builder = this.f6270p;
            TextFieldValue textFieldValue = this.f6264j;
            Intrinsics.e(textFieldValue);
            v vVar = this.f6266l;
            Intrinsics.e(vVar);
            androidx.compose.ui.text.z zVar = this.f6265k;
            Intrinsics.e(zVar);
            Matrix matrix = this.f6272r;
            y.i iVar = this.f6268n;
            Intrinsics.e(iVar);
            y.i iVar2 = this.f6269o;
            Intrinsics.e(iVar2);
            rVar.a(j.b(builder, textFieldValue, vVar, zVar, matrix, iVar, iVar2, this.f6260f, this.f6261g, this.f6262h, this.f6263i));
            this.f6259e = false;
        }
    }

    public final void a(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        synchronized (this.f6257c) {
            try {
                this.f6260f = z12;
                this.f6261g = z13;
                this.f6262h = z14;
                this.f6263i = z15;
                if (z10) {
                    this.f6259e = true;
                    if (this.f6264j != null) {
                        b();
                    }
                }
                this.f6258d = z11;
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
