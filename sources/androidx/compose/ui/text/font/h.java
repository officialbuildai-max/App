package androidx.compose.ui.text.font;

import androidx.compose.runtime.a3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6199b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final c0 f6200c = new f();

    /* renamed from: d, reason: collision with root package name */
    private static final s f6201d = new s(C.SANS_SERIF_NAME, "FontFamily.SansSerif");

    /* renamed from: e, reason: collision with root package name */
    private static final s f6202e = new s(C.SERIF_NAME, "FontFamily.Serif");

    /* renamed from: f, reason: collision with root package name */
    private static final s f6203f = new s("monospace", "FontFamily.Monospace");

    /* renamed from: g, reason: collision with root package name */
    private static final s f6204g = new s("cursive", "FontFamily.Cursive");

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6205a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c0 a() {
            return h.f6200c;
        }

        public final s b() {
            return h.f6201d;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        a3 a(h hVar, p pVar, int i11, int i12);
    }

    private h(boolean z10) {
        this.f6205a = z10;
    }

    public /* synthetic */ h(boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10);
    }
}
