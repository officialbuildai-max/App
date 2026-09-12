package kotlinx.serialization.internal;

import e00.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* loaded from: classes7.dex */
public abstract class t0 implements kotlinx.serialization.b {

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.b f68323a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.b f68324b;

    private t0(kotlinx.serialization.b bVar, kotlinx.serialization.b bVar2) {
        this.f68323a = bVar;
        this.f68324b = bVar2;
    }

    public /* synthetic */ t0(kotlinx.serialization.b bVar, kotlinx.serialization.b bVar2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, bVar2);
    }

    protected abstract Object a(Object obj);

    protected abstract Object b(Object obj);

    protected abstract Object c(Object obj, Object obj2);

    @Override // kotlinx.serialization.a
    public Object deserialize(e00.e decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Intrinsics.h(decoder, "decoder");
        e00.c b11 = decoder.b(getDescriptor());
        if (b11.p()) {
            return c(c.a.c(b11, getDescriptor(), 0, this.f68323a, null, 8, null), c.a.c(b11, getDescriptor(), 1, this.f68324b, null, 8, null));
        }
        obj = d2.f68248a;
        obj2 = d2.f68248a;
        Object obj5 = obj2;
        while (true) {
            int o11 = b11.o(getDescriptor());
            if (o11 == -1) {
                b11.c(getDescriptor());
                obj3 = d2.f68248a;
                if (obj == obj3) {
                    throw new SerializationException("Element 'key' is missing");
                }
                obj4 = d2.f68248a;
                if (obj5 != obj4) {
                    return c(obj, obj5);
                }
                throw new SerializationException("Element 'value' is missing");
            }
            if (o11 == 0) {
                obj = c.a.c(b11, getDescriptor(), 0, this.f68323a, null, 8, null);
            } else {
                if (o11 != 1) {
                    throw new SerializationException("Invalid index: " + o11);
                }
                obj5 = c.a.c(b11, getDescriptor(), 1, this.f68324b, null, 8, null);
            }
        }
    }

    @Override // kotlinx.serialization.g
    public void serialize(e00.f encoder, Object obj) {
        Intrinsics.h(encoder, "encoder");
        e00.d b11 = encoder.b(getDescriptor());
        b11.C(getDescriptor(), 0, this.f68323a, a(obj));
        b11.C(getDescriptor(), 1, this.f68324b, b(obj));
        b11.c(getDescriptor());
    }
}
