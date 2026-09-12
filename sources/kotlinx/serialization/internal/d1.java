package kotlinx.serialization.internal;

import e00.c;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* loaded from: classes7.dex */
public abstract class d1 extends a {

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.b f68246a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.b f68247b;

    private d1(kotlinx.serialization.b bVar, kotlinx.serialization.b bVar2) {
        super(null);
        this.f68246a = bVar;
        this.f68247b = bVar2;
    }

    public /* synthetic */ d1(kotlinx.serialization.b bVar, kotlinx.serialization.b bVar2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, bVar2);
    }

    @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public abstract kotlinx.serialization.descriptors.f getDescriptor();

    public final kotlinx.serialization.b m() {
        return this.f68246a;
    }

    public final kotlinx.serialization.b n() {
        return this.f68247b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void g(e00.c decoder, Map builder, int i11, int i12) {
        Intrinsics.h(decoder, "decoder");
        Intrinsics.h(builder, "builder");
        if (i12 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        IntProgression s11 = RangesKt.s(RangesKt.t(0, i12 * 2), 2);
        int first = s11.getFirst();
        int last = s11.getLast();
        int step = s11.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return;
        }
        while (true) {
            h(decoder, i11 + first, builder, false);
            if (first == last) {
                return;
            } else {
                first += step;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void h(e00.c decoder, int i11, Map builder, boolean z10) {
        int i12;
        Intrinsics.h(decoder, "decoder");
        Intrinsics.h(builder, "builder");
        Object c11 = c.a.c(decoder, getDescriptor(), i11, this.f68246a, null, 8, null);
        if (z10) {
            i12 = decoder.o(getDescriptor());
            if (i12 != i11 + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i11 + ", returned index for value: " + i12).toString());
            }
        } else {
            i12 = i11 + 1;
        }
        int i13 = i12;
        builder.put(c11, (!builder.containsKey(c11) || (this.f68247b.getDescriptor().d() instanceof kotlinx.serialization.descriptors.e)) ? c.a.c(decoder, getDescriptor(), i13, this.f68247b, null, 8, null) : decoder.y(getDescriptor(), i13, this.f68247b, MapsKt.i(builder, c11)));
    }

    @Override // kotlinx.serialization.g
    public void serialize(e00.f encoder, Object obj) {
        Intrinsics.h(encoder, "encoder");
        int e11 = e(obj);
        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
        e00.d j11 = encoder.j(descriptor, e11);
        Iterator d11 = d(obj);
        int i11 = 0;
        while (d11.hasNext()) {
            Map.Entry entry = (Map.Entry) d11.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i12 = i11 + 1;
            j11.C(getDescriptor(), i11, m(), key);
            i11 += 2;
            j11.C(getDescriptor(), i12, n(), value);
        }
        j11.c(descriptor);
    }
}
