package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SaversKt;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class TextFieldValue {

    /* renamed from: d, reason: collision with root package name */
    public static final a f6276d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final androidx.compose.runtime.saveable.d f6277e = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, TextFieldValue, Object>() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, TextFieldValue textFieldValue) {
            return CollectionsKt.h(SaversKt.y(textFieldValue.c(), SaversKt.h(), eVar), SaversKt.y(androidx.compose.ui.text.b0.b(textFieldValue.e()), SaversKt.l(androidx.compose.ui.text.b0.f6158b), eVar));
        }
    }, new Function1<Object, TextFieldValue>() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextFieldValue invoke(Object obj) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            androidx.compose.runtime.saveable.d h11 = SaversKt.h();
            Boolean bool = Boolean.FALSE;
            androidx.compose.ui.text.b0 b0Var = null;
            AnnotatedString annotatedString = ((!Intrinsics.c(obj2, bool) || (h11 instanceof androidx.compose.ui.text.j)) && obj2 != null) ? (AnnotatedString) h11.b(obj2) : null;
            Intrinsics.e(annotatedString);
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d l11 = SaversKt.l(androidx.compose.ui.text.b0.f6158b);
            if ((!Intrinsics.c(obj3, bool) || (l11 instanceof androidx.compose.ui.text.j)) && obj3 != null) {
                b0Var = (androidx.compose.ui.text.b0) l11.b(obj3);
            }
            Intrinsics.e(b0Var);
            return new TextFieldValue(annotatedString, b0Var.n(), (androidx.compose.ui.text.b0) null, 4, (DefaultConstructorMarker) null);
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final AnnotatedString f6278a;

    /* renamed from: b, reason: collision with root package name */
    private final long f6279b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.compose.ui.text.b0 f6280c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private TextFieldValue(AnnotatedString annotatedString, long j11, androidx.compose.ui.text.b0 b0Var) {
        this.f6278a = annotatedString;
        this.f6279b = androidx.compose.ui.text.c0.c(j11, 0, f().length());
        this.f6280c = b0Var != null ? androidx.compose.ui.text.b0.b(androidx.compose.ui.text.c0.c(b0Var.n(), 0, f().length())) : null;
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j11, androidx.compose.ui.text.b0 b0Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, (i11 & 2) != 0 ? androidx.compose.ui.text.b0.f6158b.a() : j11, (i11 & 4) != 0 ? null : b0Var, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j11, androidx.compose.ui.text.b0 b0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j11, b0Var);
    }

    private TextFieldValue(String str, long j11, androidx.compose.ui.text.b0 b0Var) {
        this(new AnnotatedString(str, null, null, 6, null), j11, b0Var, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextFieldValue(String str, long j11, androidx.compose.ui.text.b0 b0Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? androidx.compose.ui.text.b0.f6158b.a() : j11, (i11 & 4) != 0 ? null : b0Var, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextFieldValue(String str, long j11, androidx.compose.ui.text.b0 b0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11, b0Var);
    }

    public static /* synthetic */ TextFieldValue b(TextFieldValue textFieldValue, AnnotatedString annotatedString, long j11, androidx.compose.ui.text.b0 b0Var, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            annotatedString = textFieldValue.f6278a;
        }
        if ((i11 & 2) != 0) {
            j11 = textFieldValue.f6279b;
        }
        if ((i11 & 4) != 0) {
            b0Var = textFieldValue.f6280c;
        }
        return textFieldValue.a(annotatedString, j11, b0Var);
    }

    public final TextFieldValue a(AnnotatedString annotatedString, long j11, androidx.compose.ui.text.b0 b0Var) {
        return new TextFieldValue(annotatedString, j11, b0Var, (DefaultConstructorMarker) null);
    }

    public final AnnotatedString c() {
        return this.f6278a;
    }

    public final androidx.compose.ui.text.b0 d() {
        return this.f6280c;
    }

    public final long e() {
        return this.f6279b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) obj;
        return androidx.compose.ui.text.b0.e(this.f6279b, textFieldValue.f6279b) && Intrinsics.c(this.f6280c, textFieldValue.f6280c) && Intrinsics.c(this.f6278a, textFieldValue.f6278a);
    }

    public final String f() {
        return this.f6278a.i();
    }

    public int hashCode() {
        int hashCode = ((this.f6278a.hashCode() * 31) + androidx.compose.ui.text.b0.l(this.f6279b)) * 31;
        androidx.compose.ui.text.b0 b0Var = this.f6280c;
        return hashCode + (b0Var != null ? androidx.compose.ui.text.b0.l(b0Var.n()) : 0);
    }

    public String toString() {
        return "TextFieldValue(text='" + ((Object) this.f6278a) + "', selection=" + ((Object) androidx.compose.ui.text.b0.m(this.f6279b)) + ", composition=" + this.f6280c + ')';
    }
}
