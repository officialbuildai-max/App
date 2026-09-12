package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0050a f5233b = new C0050a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f5234a;

    /* renamed from: androidx.compose.ui.layout.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0050a {
        private C0050a() {
        }

        public /* synthetic */ C0050a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private a(Function2 function2) {
        this.f5234a = function2;
    }

    public /* synthetic */ a(Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2);
    }

    public final Function2 a() {
        return this.f5234a;
    }
}
