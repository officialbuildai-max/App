package da;

import ba.h;
import ba.i;
import com.google.android.exoplayer2.util.d0;
import java.util.List;

/* loaded from: classes4.dex */
public final class a extends h {

    /* renamed from: o, reason: collision with root package name */
    private final b f61370o;

    public a(List list) {
        super("DvbDecoder");
        d0 d0Var = new d0((byte[]) list.get(0));
        this.f61370o = new b(d0Var.J(), d0Var.J());
    }

    @Override // ba.h
    protected i v(byte[] bArr, int i11, boolean z10) {
        if (z10) {
            this.f61370o.r();
        }
        return new c(this.f61370o.b(bArr, i11));
    }
}
