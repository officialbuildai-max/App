package kotlinx.serialization.internal;

import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class q extends r1 implements kotlinx.serialization.b {

    /* renamed from: c, reason: collision with root package name */
    public static final q f68308c = new q();

    private q() {
        super(d00.a.A(CharCompanionObject.f67393a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(char[] cArr) {
        Intrinsics.h(cArr, "<this>");
        return cArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.r1
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public char[] r() {
        return new char[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.w, kotlinx.serialization.internal.a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(e00.c decoder, int i11, p builder, boolean z10) {
        Intrinsics.h(decoder, "decoder");
        Intrinsics.h(builder, "builder");
        builder.e(decoder.A(getDescriptor(), i11));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public p k(char[] cArr) {
        Intrinsics.h(cArr, "<this>");
        return new p(cArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.r1
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(e00.d encoder, char[] content, int i11) {
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(content, "content");
        for (int i12 = 0; i12 < i11; i12++) {
            encoder.n(getDescriptor(), i12, content[i12]);
        }
    }
}
