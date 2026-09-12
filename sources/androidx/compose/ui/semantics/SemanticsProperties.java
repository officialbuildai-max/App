package androidx.compose.ui.semantics;

import androidx.compose.ui.text.AnnotatedString;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import x.x;
import x.y;

/* loaded from: classes.dex */
public final class SemanticsProperties {

    /* renamed from: a, reason: collision with root package name */
    public static final SemanticsProperties f5994a = new SemanticsProperties();

    /* renamed from: b, reason: collision with root package name */
    private static final SemanticsPropertyKey f5995b = SemanticsPropertiesKt.b("ContentDescription", new Function2<List<? extends String>, List<? extends String>, List<? extends String>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDescription$1
        @Override // kotlin.jvm.functions.Function2
        public final List<String> invoke(List<String> list, List<String> list2) {
            List<String> U0;
            if (list == null || (U0 = CollectionsKt.U0(list)) == null) {
                return list2;
            }
            U0.addAll(list2);
            return U0;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final SemanticsPropertyKey f5996c = SemanticsPropertiesKt.a("StateDescription");

    /* renamed from: d, reason: collision with root package name */
    private static final SemanticsPropertyKey f5997d = SemanticsPropertiesKt.a("ProgressBarRangeInfo");

    /* renamed from: e, reason: collision with root package name */
    private static final SemanticsPropertyKey f5998e = SemanticsPropertiesKt.b("PaneTitle", new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$PaneTitle$1
        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, String str2) {
            throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static final SemanticsPropertyKey f5999f = SemanticsPropertiesKt.a("SelectableGroup");

    /* renamed from: g, reason: collision with root package name */
    private static final SemanticsPropertyKey f6000g = SemanticsPropertiesKt.a("CollectionInfo");

    /* renamed from: h, reason: collision with root package name */
    private static final SemanticsPropertyKey f6001h = SemanticsPropertiesKt.a("CollectionItemInfo");

    /* renamed from: i, reason: collision with root package name */
    private static final SemanticsPropertyKey f6002i = SemanticsPropertiesKt.a("Heading");

    /* renamed from: j, reason: collision with root package name */
    private static final SemanticsPropertyKey f6003j = SemanticsPropertiesKt.a(BucketLifecycleConfiguration.DISABLED);

    /* renamed from: k, reason: collision with root package name */
    private static final SemanticsPropertyKey f6004k = SemanticsPropertiesKt.a("LiveRegion");

    /* renamed from: l, reason: collision with root package name */
    private static final SemanticsPropertyKey f6005l = SemanticsPropertiesKt.a("Focused");

    /* renamed from: m, reason: collision with root package name */
    private static final SemanticsPropertyKey f6006m = SemanticsPropertiesKt.a("IsTraversalGroup");

    /* renamed from: n, reason: collision with root package name */
    private static final SemanticsPropertyKey f6007n = new SemanticsPropertyKey("InvisibleToUser", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$InvisibleToUser$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            return unit;
        }
    });

    /* renamed from: o, reason: collision with root package name */
    private static final SemanticsPropertyKey f6008o = new SemanticsPropertyKey("ContentType", new Function2<y, y, y>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentType$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            android.support.v4.media.session.c.a(obj);
            android.support.v4.media.session.c.a(obj2);
            invoke((y) null, (y) null);
            return null;
        }

        public final y invoke(y yVar, y yVar2) {
            return yVar;
        }
    });

    /* renamed from: p, reason: collision with root package name */
    private static final SemanticsPropertyKey f6009p = new SemanticsPropertyKey("ContentDataType", new Function2<x, x, x>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDataType$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            android.support.v4.media.session.c.a(obj);
            android.support.v4.media.session.c.a(obj2);
            throw null;
        }

        /* renamed from: invoke-x33U9Dw, reason: not valid java name */
        public final x m165invokex33U9Dw(x xVar, int i11) {
            return xVar;
        }
    });

    /* renamed from: q, reason: collision with root package name */
    private static final SemanticsPropertyKey f6010q = SemanticsPropertiesKt.b("TraversalIndex", new Function2<Float, Float, Float>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TraversalIndex$1
        public final Float invoke(Float f11, float f12) {
            return f11;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((Float) obj, ((Number) obj2).floatValue());
        }
    });

    /* renamed from: r, reason: collision with root package name */
    private static final SemanticsPropertyKey f6011r = SemanticsPropertiesKt.a("HorizontalScrollAxisRange");

    /* renamed from: s, reason: collision with root package name */
    private static final SemanticsPropertyKey f6012s = SemanticsPropertiesKt.a("VerticalScrollAxisRange");

    /* renamed from: t, reason: collision with root package name */
    private static final SemanticsPropertyKey f6013t = SemanticsPropertiesKt.b("IsPopup", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsPopup$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
        }
    });

    /* renamed from: u, reason: collision with root package name */
    private static final SemanticsPropertyKey f6014u = SemanticsPropertiesKt.b("IsDialog", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsDialog$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
        }
    });

    /* renamed from: v, reason: collision with root package name */
    private static final SemanticsPropertyKey f6015v = SemanticsPropertiesKt.b("Role", new Function2<f, f, f>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Role$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m166invokeqtAw6s((f) obj, ((f) obj2).n());
        }

        /* renamed from: invoke-qtA-w6s, reason: not valid java name */
        public final f m166invokeqtAw6s(f fVar, int i11) {
            return fVar;
        }
    });

    /* renamed from: w, reason: collision with root package name */
    private static final SemanticsPropertyKey f6016w = new SemanticsPropertyKey("TestTag", false, new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TestTag$1
        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, String str2) {
            return str;
        }
    });

    /* renamed from: x, reason: collision with root package name */
    private static final SemanticsPropertyKey f6017x = SemanticsPropertiesKt.b("Text", new Function2<List<? extends AnnotatedString>, List<? extends AnnotatedString>, List<? extends AnnotatedString>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Text$1
        @Override // kotlin.jvm.functions.Function2
        public final List<AnnotatedString> invoke(List<AnnotatedString> list, List<AnnotatedString> list2) {
            List<AnnotatedString> U0;
            if (list == null || (U0 = CollectionsKt.U0(list)) == null) {
                return list2;
            }
            U0.addAll(list2);
            return U0;
        }
    });

    /* renamed from: y, reason: collision with root package name */
    private static final SemanticsPropertyKey f6018y = new SemanticsPropertyKey("TextSubstitution", null, 2, null);

    /* renamed from: z, reason: collision with root package name */
    private static final SemanticsPropertyKey f6019z = new SemanticsPropertyKey("IsShowingTextSubstitution", null, 2, null);
    private static final SemanticsPropertyKey A = SemanticsPropertiesKt.a("EditableText");
    private static final SemanticsPropertyKey B = SemanticsPropertiesKt.a("TextSelectionRange");
    private static final SemanticsPropertyKey C = SemanticsPropertiesKt.a("ImeAction");
    private static final SemanticsPropertyKey D = SemanticsPropertiesKt.a("Selected");
    private static final SemanticsPropertyKey E = SemanticsPropertiesKt.a("ToggleableState");
    private static final SemanticsPropertyKey F = SemanticsPropertiesKt.a("Password");
    private static final SemanticsPropertyKey G = SemanticsPropertiesKt.a("Error");
    private static final SemanticsPropertyKey H = new SemanticsPropertyKey("IndexForKey", null, 2, null);
    private static final SemanticsPropertyKey I = new SemanticsPropertyKey("IsEditable", null, 2, null);
    private static final SemanticsPropertyKey J = new SemanticsPropertyKey("MaxTextLength", null, 2, null);
    public static final int K = 8;

    private SemanticsProperties() {
    }

    public final SemanticsPropertyKey A() {
        return f5996c;
    }

    public final SemanticsPropertyKey B() {
        return f6016w;
    }

    public final SemanticsPropertyKey C() {
        return f6017x;
    }

    public final SemanticsPropertyKey D() {
        return B;
    }

    public final SemanticsPropertyKey E() {
        return f6018y;
    }

    public final SemanticsPropertyKey F() {
        return E;
    }

    public final SemanticsPropertyKey G() {
        return f6010q;
    }

    public final SemanticsPropertyKey H() {
        return f6012s;
    }

    public final SemanticsPropertyKey a() {
        return f6000g;
    }

    public final SemanticsPropertyKey b() {
        return f6001h;
    }

    public final SemanticsPropertyKey c() {
        return f6009p;
    }

    public final SemanticsPropertyKey d() {
        return f5995b;
    }

    public final SemanticsPropertyKey e() {
        return f6008o;
    }

    public final SemanticsPropertyKey f() {
        return f6003j;
    }

    public final SemanticsPropertyKey g() {
        return A;
    }

    public final SemanticsPropertyKey h() {
        return G;
    }

    public final SemanticsPropertyKey i() {
        return f6005l;
    }

    public final SemanticsPropertyKey j() {
        return f6002i;
    }

    public final SemanticsPropertyKey k() {
        return f6011r;
    }

    public final SemanticsPropertyKey l() {
        return C;
    }

    public final SemanticsPropertyKey m() {
        return H;
    }

    public final SemanticsPropertyKey n() {
        return f6007n;
    }

    public final SemanticsPropertyKey o() {
        return f6014u;
    }

    public final SemanticsPropertyKey p() {
        return I;
    }

    public final SemanticsPropertyKey q() {
        return f6019z;
    }

    public final SemanticsPropertyKey r() {
        return f6006m;
    }

    public final SemanticsPropertyKey s() {
        return f6004k;
    }

    public final SemanticsPropertyKey t() {
        return J;
    }

    public final SemanticsPropertyKey u() {
        return f5998e;
    }

    public final SemanticsPropertyKey v() {
        return F;
    }

    public final SemanticsPropertyKey w() {
        return f5997d;
    }

    public final SemanticsPropertyKey x() {
        return f6015v;
    }

    public final SemanticsPropertyKey y() {
        return f5999f;
    }

    public final SemanticsPropertyKey z() {
        return D;
    }
}
