package ka;

import ba.b;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class a extends ba.h {

    /* renamed from: o, reason: collision with root package name */
    private final d0 f66805o;

    public a() {
        super("Mp4WebvttDecoder");
        this.f66805o = new d0();
    }

    private static ba.b x(d0 d0Var, int i11) {
        CharSequence charSequence = null;
        b.C0151b c0151b = null;
        while (i11 > 0) {
            if (i11 < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int n11 = d0Var.n();
            int n12 = d0Var.n();
            int i12 = n11 - 8;
            String E = p0.E(d0Var.d(), d0Var.e(), i12);
            d0Var.Q(i12);
            i11 = (i11 - 8) - i12;
            if (n12 == 1937011815) {
                c0151b = f.o(E);
            } else if (n12 == 1885436268) {
                charSequence = f.q(null, E.trim(), Collections.emptyList());
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        return c0151b != null ? c0151b.o(charSequence).a() : f.l(charSequence);
    }

    @Override // ba.h
    protected ba.i v(byte[] bArr, int i11, boolean z10) {
        this.f66805o.N(bArr, i11);
        ArrayList arrayList = new ArrayList();
        while (this.f66805o.a() > 0) {
            if (this.f66805o.a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int n11 = this.f66805o.n();
            if (this.f66805o.n() == 1987343459) {
                arrayList.add(x(this.f66805o, n11 - 8));
            } else {
                this.f66805o.Q(n11 - 8);
            }
        }
        return new b(arrayList);
    }
}
