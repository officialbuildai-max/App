package androidx.compose.ui.semantics;

import kotlin.Function;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class h {
    private static final SemanticsPropertyKey A;
    private static final SemanticsPropertyKey B;
    private static final SemanticsPropertyKey C;
    private static final SemanticsPropertyKey D;
    public static final int E;

    /* renamed from: a, reason: collision with root package name */
    public static final h f6051a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final SemanticsPropertyKey f6052b;

    /* renamed from: c, reason: collision with root package name */
    private static final SemanticsPropertyKey f6053c;

    /* renamed from: d, reason: collision with root package name */
    private static final SemanticsPropertyKey f6054d;

    /* renamed from: e, reason: collision with root package name */
    private static final SemanticsPropertyKey f6055e;

    /* renamed from: f, reason: collision with root package name */
    private static final SemanticsPropertyKey f6056f;

    /* renamed from: g, reason: collision with root package name */
    private static final SemanticsPropertyKey f6057g;

    /* renamed from: h, reason: collision with root package name */
    private static final SemanticsPropertyKey f6058h;

    /* renamed from: i, reason: collision with root package name */
    private static final SemanticsPropertyKey f6059i;

    /* renamed from: j, reason: collision with root package name */
    private static final SemanticsPropertyKey f6060j;

    /* renamed from: k, reason: collision with root package name */
    private static final SemanticsPropertyKey f6061k;

    /* renamed from: l, reason: collision with root package name */
    private static final SemanticsPropertyKey f6062l;

    /* renamed from: m, reason: collision with root package name */
    private static final SemanticsPropertyKey f6063m;

    /* renamed from: n, reason: collision with root package name */
    private static final SemanticsPropertyKey f6064n;

    /* renamed from: o, reason: collision with root package name */
    private static final SemanticsPropertyKey f6065o;

    /* renamed from: p, reason: collision with root package name */
    private static final SemanticsPropertyKey f6066p;

    /* renamed from: q, reason: collision with root package name */
    private static final SemanticsPropertyKey f6067q;

    /* renamed from: r, reason: collision with root package name */
    private static final SemanticsPropertyKey f6068r;

    /* renamed from: s, reason: collision with root package name */
    private static final SemanticsPropertyKey f6069s;

    /* renamed from: t, reason: collision with root package name */
    private static final SemanticsPropertyKey f6070t;

    /* renamed from: u, reason: collision with root package name */
    private static final SemanticsPropertyKey f6071u;

    /* renamed from: v, reason: collision with root package name */
    private static final SemanticsPropertyKey f6072v;

    /* renamed from: w, reason: collision with root package name */
    private static final SemanticsPropertyKey f6073w;

    /* renamed from: x, reason: collision with root package name */
    private static final SemanticsPropertyKey f6074x;

    /* renamed from: y, reason: collision with root package name */
    private static final SemanticsPropertyKey f6075y;

    /* renamed from: z, reason: collision with root package name */
    private static final SemanticsPropertyKey f6076z;

    static {
        SemanticsPropertiesKt$ActionPropertyKey$1 semanticsPropertiesKt$ActionPropertyKey$1 = new Function2<a, a, a>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt$ActionPropertyKey$1
            @Override // kotlin.jvm.functions.Function2
            public final a invoke(a aVar, a aVar2) {
                String b11;
                Function a11;
                if (aVar == null || (b11 = aVar.b()) == null) {
                    b11 = aVar2.b();
                }
                if (aVar == null || (a11 = aVar.a()) == null) {
                    a11 = aVar2.a();
                }
                return new a(b11, a11);
            }
        };
        f6052b = SemanticsPropertiesKt.b("GetTextLayoutResult", semanticsPropertiesKt$ActionPropertyKey$1);
        f6053c = SemanticsPropertiesKt.b("OnClick", semanticsPropertiesKt$ActionPropertyKey$1);
        f6054d = SemanticsPropertiesKt.b("OnLongClick", semanticsPropertiesKt$ActionPropertyKey$1);
        f6055e = SemanticsPropertiesKt.b("ScrollBy", semanticsPropertiesKt$ActionPropertyKey$1);
        f6056f = new SemanticsPropertyKey("ScrollByOffset", null, 2, null);
        f6057g = SemanticsPropertiesKt.b("ScrollToIndex", semanticsPropertiesKt$ActionPropertyKey$1);
        f6058h = SemanticsPropertiesKt.b("OnAutofillText", semanticsPropertiesKt$ActionPropertyKey$1);
        f6059i = SemanticsPropertiesKt.b("SetProgress", semanticsPropertiesKt$ActionPropertyKey$1);
        f6060j = SemanticsPropertiesKt.b("SetSelection", semanticsPropertiesKt$ActionPropertyKey$1);
        f6061k = SemanticsPropertiesKt.b("SetText", semanticsPropertiesKt$ActionPropertyKey$1);
        f6062l = SemanticsPropertiesKt.b("SetTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        f6063m = SemanticsPropertiesKt.b("ShowTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        f6064n = SemanticsPropertiesKt.b("ClearTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        f6065o = SemanticsPropertiesKt.b("InsertTextAtCursor", semanticsPropertiesKt$ActionPropertyKey$1);
        f6066p = SemanticsPropertiesKt.b("PerformImeAction", semanticsPropertiesKt$ActionPropertyKey$1);
        f6067q = SemanticsPropertiesKt.b("PerformImeAction", semanticsPropertiesKt$ActionPropertyKey$1);
        f6068r = SemanticsPropertiesKt.b("CopyText", semanticsPropertiesKt$ActionPropertyKey$1);
        f6069s = SemanticsPropertiesKt.b("CutText", semanticsPropertiesKt$ActionPropertyKey$1);
        f6070t = SemanticsPropertiesKt.b("PasteText", semanticsPropertiesKt$ActionPropertyKey$1);
        f6071u = SemanticsPropertiesKt.b("Expand", semanticsPropertiesKt$ActionPropertyKey$1);
        f6072v = SemanticsPropertiesKt.b("Collapse", semanticsPropertiesKt$ActionPropertyKey$1);
        f6073w = SemanticsPropertiesKt.b("Dismiss", semanticsPropertiesKt$ActionPropertyKey$1);
        f6074x = SemanticsPropertiesKt.b("RequestFocus", semanticsPropertiesKt$ActionPropertyKey$1);
        f6075y = SemanticsPropertiesKt.a("CustomActions");
        f6076z = SemanticsPropertiesKt.b("PageUp", semanticsPropertiesKt$ActionPropertyKey$1);
        A = SemanticsPropertiesKt.b("PageLeft", semanticsPropertiesKt$ActionPropertyKey$1);
        B = SemanticsPropertiesKt.b("PageDown", semanticsPropertiesKt$ActionPropertyKey$1);
        C = SemanticsPropertiesKt.b("PageRight", semanticsPropertiesKt$ActionPropertyKey$1);
        D = SemanticsPropertiesKt.b("GetScrollViewportLength", semanticsPropertiesKt$ActionPropertyKey$1);
        E = 8;
    }

    private h() {
    }

    public final SemanticsPropertyKey a() {
        return f6064n;
    }

    public final SemanticsPropertyKey b() {
        return f6072v;
    }

    public final SemanticsPropertyKey c() {
        return f6068r;
    }

    public final SemanticsPropertyKey d() {
        return f6075y;
    }

    public final SemanticsPropertyKey e() {
        return f6069s;
    }

    public final SemanticsPropertyKey f() {
        return f6073w;
    }

    public final SemanticsPropertyKey g() {
        return f6071u;
    }

    public final SemanticsPropertyKey h() {
        return D;
    }

    public final SemanticsPropertyKey i() {
        return f6052b;
    }

    public final SemanticsPropertyKey j() {
        return f6053c;
    }

    public final SemanticsPropertyKey k() {
        return f6066p;
    }

    public final SemanticsPropertyKey l() {
        return f6054d;
    }

    public final SemanticsPropertyKey m() {
        return B;
    }

    public final SemanticsPropertyKey n() {
        return A;
    }

    public final SemanticsPropertyKey o() {
        return C;
    }

    public final SemanticsPropertyKey p() {
        return f6076z;
    }

    public final SemanticsPropertyKey q() {
        return f6070t;
    }

    public final SemanticsPropertyKey r() {
        return f6074x;
    }

    public final SemanticsPropertyKey s() {
        return f6055e;
    }

    public final SemanticsPropertyKey t() {
        return f6056f;
    }

    public final SemanticsPropertyKey u() {
        return f6057g;
    }

    public final SemanticsPropertyKey v() {
        return f6059i;
    }

    public final SemanticsPropertyKey w() {
        return f6060j;
    }

    public final SemanticsPropertyKey x() {
        return f6061k;
    }

    public final SemanticsPropertyKey y() {
        return f6062l;
    }

    public final SemanticsPropertyKey z() {
        return f6063m;
    }
}
