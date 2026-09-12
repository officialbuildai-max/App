package kotlinx.serialization.json;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes7.dex */
public final class t implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    public static final t f68483a = new t();

    /* renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f68484b = a.f68485b;

    /* loaded from: classes7.dex */
    private static final class a implements kotlinx.serialization.descriptors.f {

        /* renamed from: b, reason: collision with root package name */
        public static final a f68485b = new a();

        /* renamed from: c, reason: collision with root package name */
        private static final String f68486c = "kotlinx.serialization.json.JsonObject";

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ kotlinx.serialization.descriptors.f f68487a = d00.a.k(d00.a.G(StringCompanionObject.f67412a), JsonElementSerializer.f68347a).getDescriptor();

        private a() {
        }

        @Override // kotlinx.serialization.descriptors.f
        public boolean b() {
            return this.f68487a.b();
        }

        @Override // kotlinx.serialization.descriptors.f
        public int c(String name) {
            Intrinsics.h(name, "name");
            return this.f68487a.c(name);
        }

        @Override // kotlinx.serialization.descriptors.f
        public kotlinx.serialization.descriptors.h d() {
            return this.f68487a.d();
        }

        @Override // kotlinx.serialization.descriptors.f
        public int e() {
            return this.f68487a.e();
        }

        @Override // kotlinx.serialization.descriptors.f
        public String f(int i11) {
            return this.f68487a.f(i11);
        }

        @Override // kotlinx.serialization.descriptors.f
        public List g(int i11) {
            return this.f68487a.g(i11);
        }

        @Override // kotlinx.serialization.descriptors.f
        public List getAnnotations() {
            return this.f68487a.getAnnotations();
        }

        @Override // kotlinx.serialization.descriptors.f
        public kotlinx.serialization.descriptors.f h(int i11) {
            return this.f68487a.h(i11);
        }

        @Override // kotlinx.serialization.descriptors.f
        public String i() {
            return f68486c;
        }

        @Override // kotlinx.serialization.descriptors.f
        public boolean isInline() {
            return this.f68487a.isInline();
        }

        @Override // kotlinx.serialization.descriptors.f
        public boolean j(int i11) {
            return this.f68487a.j(i11);
        }
    }

    private t() {
    }

    @Override // kotlinx.serialization.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonObject deserialize(e00.e decoder) {
        Intrinsics.h(decoder, "decoder");
        k.g(decoder);
        return new JsonObject((Map) d00.a.k(d00.a.G(StringCompanionObject.f67412a), JsonElementSerializer.f68347a).deserialize(decoder));
    }

    @Override // kotlinx.serialization.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(e00.f encoder, JsonObject value) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        k.h(encoder);
        d00.a.k(d00.a.G(StringCompanionObject.f67412a), JsonElementSerializer.f68347a).serialize(encoder, value);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return f68484b;
    }
}
