package kotlinx.serialization.json;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;

/* loaded from: classes7.dex */
public final class JsonNull extends u {

    /* renamed from: c, reason: collision with root package name */
    public static final JsonNull f68349c = new JsonNull();

    /* renamed from: d, reason: collision with root package name */
    private static final String f68350d = "null";

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ Lazy f68351e = LazyKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<kotlinx.serialization.b>() { // from class: kotlinx.serialization.json.JsonNull$$cachedSerializer$delegate$1
        @Override // kotlin.jvm.functions.Function0
        public final kotlinx.serialization.b invoke() {
            return r.f68480a;
        }
    });

    private JsonNull() {
        super(null);
    }

    @Override // kotlinx.serialization.json.u
    public String a() {
        return f68350d;
    }
}
