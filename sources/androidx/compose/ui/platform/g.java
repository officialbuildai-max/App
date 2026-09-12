package androidx.compose.ui.platform;

import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class g extends androidx.compose.ui.platform.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f5856d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final int f5857e = 8;

    /* renamed from: f, reason: collision with root package name */
    private static g f5858f;

    /* renamed from: c, reason: collision with root package name */
    private BreakIterator f5859c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a(Locale locale) {
            if (g.f5858f == null) {
                g.f5858f = new g(locale, null);
            }
            g gVar = g.f5858f;
            Intrinsics.f(gVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
            return gVar;
        }
    }

    private g(Locale locale) {
        l(locale);
    }

    public /* synthetic */ g(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale);
    }

    private final boolean i(int i11) {
        return i11 > 0 && j(i11 + (-1)) && (i11 == d().length() || !j(i11));
    }

    private final boolean j(int i11) {
        if (i11 < 0 || i11 >= d().length()) {
            return false;
        }
        return Character.isLetterOrDigit(d().codePointAt(i11));
    }

    private final boolean k(int i11) {
        return j(i11) && (i11 == 0 || !j(i11 - 1));
    }

    private final void l(Locale locale) {
        this.f5859c = BreakIterator.getWordInstance(locale);
    }

    @Override // androidx.compose.ui.platform.f
    public int[] a(int i11) {
        if (d().length() <= 0 || i11 >= d().length()) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (!j(i11) && !k(i11)) {
            BreakIterator breakIterator = this.f5859c;
            if (breakIterator == null) {
                Intrinsics.z("impl");
                breakIterator = null;
            }
            i11 = breakIterator.following(i11);
            if (i11 == -1) {
                return null;
            }
        }
        BreakIterator breakIterator2 = this.f5859c;
        if (breakIterator2 == null) {
            Intrinsics.z("impl");
            breakIterator2 = null;
        }
        int following = breakIterator2.following(i11);
        if (following == -1 || !i(following)) {
            return null;
        }
        return c(i11, following);
    }

    @Override // androidx.compose.ui.platform.f
    public int[] b(int i11) {
        int length = d().length();
        if (length <= 0 || i11 <= 0) {
            return null;
        }
        if (i11 > length) {
            i11 = length;
        }
        while (i11 > 0 && !j(i11 - 1) && !i(i11)) {
            BreakIterator breakIterator = this.f5859c;
            if (breakIterator == null) {
                Intrinsics.z("impl");
                breakIterator = null;
            }
            i11 = breakIterator.preceding(i11);
            if (i11 == -1) {
                return null;
            }
        }
        BreakIterator breakIterator2 = this.f5859c;
        if (breakIterator2 == null) {
            Intrinsics.z("impl");
            breakIterator2 = null;
        }
        int preceding = breakIterator2.preceding(i11);
        if (preceding == -1 || !k(preceding)) {
            return null;
        }
        return c(preceding, i11);
    }

    @Override // androidx.compose.ui.platform.a
    public void e(String str) {
        super.e(str);
        BreakIterator breakIterator = this.f5859c;
        if (breakIterator == null) {
            Intrinsics.z("impl");
            breakIterator = null;
        }
        breakIterator.setText(str);
    }
}
