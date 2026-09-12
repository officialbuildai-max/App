package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private final Object f68075a;

    /* renamed from: b, reason: collision with root package name */
    private final Function3 f68076b;

    /* renamed from: c, reason: collision with root package name */
    private final Function3 f68077c;

    /* renamed from: d, reason: collision with root package name */
    private final Function3 f68078d;

    public c(Object obj, Function3 function3, Function3 function32) {
        Function3 function33;
        this.f68075a = obj;
        this.f68076b = function3;
        this.f68077c = function32;
        function33 = g.f68083a;
        this.f68078d = function33;
    }

    public /* synthetic */ c(Object obj, Function3 function3, Function3 function32, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function3, (i11 & 4) != 0 ? null : function32);
    }
}
