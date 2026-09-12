package kotlinx.serialization.json.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.internal.s0;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class JsonTreeDecoder extends c {

    /* renamed from: f, reason: collision with root package name */
    private final JsonObject f68401f;

    /* renamed from: g, reason: collision with root package name */
    private final String f68402g;

    /* renamed from: h, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68403h;

    /* renamed from: i, reason: collision with root package name */
    private int f68404i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f68405j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(kotlinx.serialization.json.a json, JsonObject value, String str, kotlinx.serialization.descriptors.f fVar) {
        super(json, value, null);
        Intrinsics.h(json, "json");
        Intrinsics.h(value, "value");
        this.f68401f = value;
        this.f68402g = str;
        this.f68403h = fVar;
    }

    public /* synthetic */ JsonTreeDecoder(kotlinx.serialization.json.a aVar, JsonObject jsonObject, String str, kotlinx.serialization.descriptors.f fVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, jsonObject, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : fVar);
    }

    private final boolean x0(kotlinx.serialization.descriptors.f fVar, int i11) {
        boolean z10 = (d().e().f() || fVar.j(i11) || !fVar.h(i11).b()) ? false : true;
        this.f68405j = z10;
        return z10;
    }

    private final boolean y0(kotlinx.serialization.descriptors.f fVar, int i11, String str) {
        kotlinx.serialization.json.a d11 = d();
        kotlinx.serialization.descriptors.f h11 = fVar.h(i11);
        if (!h11.b() && (g0(str) instanceof JsonNull)) {
            return true;
        }
        if (Intrinsics.c(h11.d(), h.b.f68192a)) {
            kotlinx.serialization.json.h g02 = g0(str);
            kotlinx.serialization.json.u uVar = g02 instanceof kotlinx.serialization.json.u ? (kotlinx.serialization.json.u) g02 : null;
            String f11 = uVar != null ? kotlinx.serialization.json.j.f(uVar) : null;
            if (f11 != null && JsonNamesMapKt.d(h11, d11, f11) == -3) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.json.internal.c, kotlinx.serialization.internal.TaggedDecoder, e00.e
    public boolean D() {
        return !this.f68405j && super.D();
    }

    @Override // kotlinx.serialization.json.internal.c, kotlinx.serialization.internal.TaggedDecoder, e00.e
    public e00.c b(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return descriptor == this.f68403h ? this : super.b(descriptor);
    }

    @Override // kotlinx.serialization.json.internal.c, kotlinx.serialization.internal.TaggedDecoder, e00.c
    public void c(kotlinx.serialization.descriptors.f descriptor) {
        Set l11;
        Intrinsics.h(descriptor, "descriptor");
        if (this.f68417e.g() || (descriptor.d() instanceof kotlinx.serialization.descriptors.d)) {
            return;
        }
        if (this.f68417e.j()) {
            Set a11 = s0.a(descriptor);
            Map map = (Map) kotlinx.serialization.json.w.a(d()).a(descriptor, JsonNamesMapKt.c());
            Set keySet = map != null ? map.keySet() : null;
            if (keySet == null) {
                keySet = SetsKt.f();
            }
            l11 = SetsKt.l(a11, keySet);
        } else {
            l11 = s0.a(descriptor);
        }
        for (String str : v0().keySet()) {
            if (!l11.contains(str) && !Intrinsics.c(str, this.f68402g)) {
                throw w.g(str, v0().toString());
            }
        }
    }

    @Override // kotlinx.serialization.internal.e1
    protected String c0(kotlinx.serialization.descriptors.f desc, int i11) {
        Object obj;
        Intrinsics.h(desc, "desc");
        String f11 = desc.f(i11);
        if (!this.f68417e.j() || v0().keySet().contains(f11)) {
            return f11;
        }
        Map map = (Map) kotlinx.serialization.json.w.a(d()).b(desc, JsonNamesMapKt.c(), new JsonTreeDecoder$elementName$alternativeNamesMap$1(desc));
        Iterator it = v0().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Integer num = (Integer) map.get((String) obj);
            if (num != null && num.intValue() == i11) {
                break;
            }
        }
        String str = (String) obj;
        return str == null ? f11 : str;
    }

    @Override // kotlinx.serialization.json.internal.c
    protected kotlinx.serialization.json.h g0(String tag) {
        Intrinsics.h(tag, "tag");
        return (kotlinx.serialization.json.h) MapsKt.i(v0(), tag);
    }

    @Override // e00.c
    public int o(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        while (this.f68404i < descriptor.e()) {
            int i11 = this.f68404i;
            this.f68404i = i11 + 1;
            String X = X(descriptor, i11);
            int i12 = this.f68404i - 1;
            this.f68405j = false;
            if (v0().containsKey(X) || x0(descriptor, i12)) {
                if (!this.f68417e.d() || !y0(descriptor, i12, X)) {
                    return i12;
                }
            }
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.c
    /* renamed from: z0 */
    public JsonObject v0() {
        return this.f68401f;
    }
}
