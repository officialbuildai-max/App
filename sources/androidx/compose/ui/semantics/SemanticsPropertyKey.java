package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
public final class SemanticsPropertyKey {

    /* renamed from: a, reason: collision with root package name */
    private final String f6024a;

    /* renamed from: b, reason: collision with root package name */
    private final Function2 f6025b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6026c;

    public SemanticsPropertyKey(String str, Function2 function2) {
        this.f6024a = str;
        this.f6025b = function2;
    }

    public /* synthetic */ SemanticsPropertyKey(String str, Function2 function2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? new Function2<Object, Object, Object>() { // from class: androidx.compose.ui.semantics.SemanticsPropertyKey.1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return obj == null ? obj2 : obj;
            }
        } : function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticsPropertyKey(String str, boolean z10) {
        this(str, null, 2, 0 == true ? 1 : 0);
        this.f6026c = z10;
    }

    public SemanticsPropertyKey(String str, boolean z10, Function2 function2) {
        this(str, function2);
        this.f6026c = z10;
    }

    public final String a() {
        return this.f6024a;
    }

    public final boolean b() {
        return this.f6026c;
    }

    public final Object c(Object obj, Object obj2) {
        return this.f6025b.invoke(obj, obj2);
    }

    public final void d(n nVar, KProperty kProperty, Object obj) {
        nVar.a(this, obj);
    }

    public String toString() {
        return "AccessibilityKey: " + this.f6024a;
    }
}
