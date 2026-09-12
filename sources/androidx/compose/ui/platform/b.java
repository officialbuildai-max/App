package androidx.compose.ui.platform;

import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class b extends androidx.compose.ui.platform.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f5809d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final int f5810e = 8;

    /* renamed from: f, reason: collision with root package name */
    private static b f5811f;

    /* renamed from: c, reason: collision with root package name */
    private BreakIterator f5812c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(Locale locale) {
            if (b.f5811f == null) {
                b.f5811f = new b(locale, null);
            }
            b bVar = b.f5811f;
            Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
            return bVar;
        }
    }

    private b(Locale locale) {
        i(locale);
    }

    public /* synthetic */ b(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale);
    }

    private final void i(Locale locale) {
        this.f5812c = BreakIterator.getCharacterInstance(locale);
    }

    @Override // androidx.compose.ui.platform.f
    public int[] a(int i11) {
        int length = d().length();
        if (length <= 0 || i11 >= length) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        do {
            BreakIterator breakIterator = this.f5812c;
            if (breakIterator == null) {
                Intrinsics.z("impl");
                breakIterator = null;
            }
            if (breakIterator.isBoundary(i11)) {
                BreakIterator breakIterator2 = this.f5812c;
                if (breakIterator2 == null) {
                    Intrinsics.z("impl");
                    breakIterator2 = null;
                }
                int following = breakIterator2.following(i11);
                if (following == -1) {
                    return null;
                }
                return c(i11, following);
            }
            BreakIterator breakIterator3 = this.f5812c;
            if (breakIterator3 == null) {
                Intrinsics.z("impl");
                breakIterator3 = null;
            }
            i11 = breakIterator3.following(i11);
        } while (i11 != -1);
        return null;
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
        do {
            BreakIterator breakIterator = this.f5812c;
            if (breakIterator == null) {
                Intrinsics.z("impl");
                breakIterator = null;
            }
            if (breakIterator.isBoundary(i11)) {
                BreakIterator breakIterator2 = this.f5812c;
                if (breakIterator2 == null) {
                    Intrinsics.z("impl");
                    breakIterator2 = null;
                }
                int preceding = breakIterator2.preceding(i11);
                if (preceding == -1) {
                    return null;
                }
                return c(preceding, i11);
            }
            BreakIterator breakIterator3 = this.f5812c;
            if (breakIterator3 == null) {
                Intrinsics.z("impl");
                breakIterator3 = null;
            }
            i11 = breakIterator3.preceding(i11);
        } while (i11 != -1);
        return null;
    }

    @Override // androidx.compose.ui.platform.a
    public void e(String str) {
        super.e(str);
        BreakIterator breakIterator = this.f5812c;
        if (breakIterator == null) {
            Intrinsics.z("impl");
            breakIterator = null;
        }
        breakIterator.setText(str);
    }
}
