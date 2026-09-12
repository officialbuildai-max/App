package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f68079a;

    /* renamed from: b, reason: collision with root package name */
    private final Function3 f68080b;

    /* renamed from: c, reason: collision with root package name */
    private final Function3 f68081c;

    /* renamed from: d, reason: collision with root package name */
    private final Function3 f68082d;

    public e(Object obj, Function3 function3, Function3 function32, Function3 function33) {
        this.f68079a = obj;
        this.f68080b = function3;
        this.f68081c = function32;
        this.f68082d = function33;
    }

    public /* synthetic */ e(Object obj, Function3 function3, Function3 function32, Function3 function33, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function3, function32, (i11 & 8) != 0 ? null : function33);
    }
}
