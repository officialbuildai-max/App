package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* loaded from: classes7.dex */
public final class v extends e00.a {

    /* renamed from: a, reason: collision with root package name */
    private final a f68467a;

    /* renamed from: b, reason: collision with root package name */
    private final f00.c f68468b;

    public v(a lexer, kotlinx.serialization.json.a json) {
        Intrinsics.h(lexer, "lexer");
        Intrinsics.h(json, "json");
        this.f68467a = lexer;
        this.f68468b = json.a();
    }

    @Override // e00.a, e00.e
    public byte H() {
        a aVar = this.f68467a;
        String s11 = aVar.s();
        try {
            return UStringsKt.a(s11);
        } catch (IllegalArgumentException unused) {
            a.y(aVar, "Failed to parse type 'UByte' for input '" + s11 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // e00.e, e00.c
    public f00.c a() {
        return this.f68468b;
    }

    @Override // e00.a, e00.e
    public int h() {
        a aVar = this.f68467a;
        String s11 = aVar.s();
        try {
            return UStringsKt.d(s11);
        } catch (IllegalArgumentException unused) {
            a.y(aVar, "Failed to parse type 'UInt' for input '" + s11 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // e00.a, e00.e
    public long l() {
        a aVar = this.f68467a;
        String s11 = aVar.s();
        try {
            return UStringsKt.g(s11);
        } catch (IllegalArgumentException unused) {
            a.y(aVar, "Failed to parse type 'ULong' for input '" + s11 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // e00.c
    public int o(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // e00.a, e00.e
    public short s() {
        a aVar = this.f68467a;
        String s11 = aVar.s();
        try {
            return UStringsKt.j(s11);
        } catch (IllegalArgumentException unused) {
            a.y(aVar, "Failed to parse type 'UShort' for input '" + s11 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }
}
