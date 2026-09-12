package i3;

import com.google.common.collect.ImmutableList;
import i3.s;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class r {
    public static k a(s sVar, byte[] bArr, int i11, int i12) {
        s.b bVar;
        final ImmutableList.a builder = ImmutableList.builder();
        bVar = s.b.f65047c;
        Objects.requireNonNull(builder);
        sVar.a(bArr, i11, i12, bVar, new androidx.media3.common.util.m() { // from class: i3.q
            @Override // androidx.media3.common.util.m
            public final void accept(Object obj) {
                ImmutableList.a.this.a((e) obj);
            }
        });
        return new g(builder.e());
    }

    public static void b(s sVar) {
    }
}
