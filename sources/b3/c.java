package b3;

import androidx.media3.common.util.i0;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.p0;
import androidx.media3.common.x;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class c extends u2.c {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f16259a = new j0();

    /* renamed from: b, reason: collision with root package name */
    private final i0 f16260b = new i0();

    /* renamed from: c, reason: collision with root package name */
    private p0 f16261c;

    @Override // u2.c
    protected x b(u2.b bVar, ByteBuffer byteBuffer) {
        p0 p0Var = this.f16261c;
        if (p0Var == null || bVar.f76737i != p0Var.f()) {
            p0 p0Var2 = new p0(bVar.f11002e);
            this.f16261c = p0Var2;
            p0Var2.a(bVar.f11002e - bVar.f76737i);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f16259a.U(array, limit);
        this.f16260b.o(array, limit);
        this.f16260b.r(39);
        long h11 = (this.f16260b.h(1) << 32) | this.f16260b.h(32);
        this.f16260b.r(20);
        int h12 = this.f16260b.h(12);
        int h13 = this.f16260b.h(8);
        this.f16259a.X(14);
        x.a b11 = h13 != 0 ? h13 != 255 ? h13 != 4 ? h13 != 5 ? h13 != 6 ? null : g.b(this.f16259a, h11, this.f16261c) : d.b(this.f16259a, h11, this.f16261c) : f.b(this.f16259a) : a.b(this.f16259a, h12, h11) : new e();
        return b11 == null ? new x(new x.a[0]) : new x(b11);
    }
}
