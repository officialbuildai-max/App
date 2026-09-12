package ka;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class h extends ba.h {

    /* renamed from: o, reason: collision with root package name */
    private final d0 f66855o;

    /* renamed from: p, reason: collision with root package name */
    private final c f66856p;

    public h() {
        super("WebvttDecoder");
        this.f66855o = new d0();
        this.f66856p = new c();
    }

    private static int x(d0 d0Var) {
        int i11 = -1;
        int i12 = 0;
        while (i11 == -1) {
            i12 = d0Var.e();
            String p11 = d0Var.p();
            i11 = p11 == null ? 0 : "STYLE".equals(p11) ? 2 : p11.startsWith("NOTE") ? 1 : 3;
        }
        d0Var.P(i12);
        return i11;
    }

    private static void y(d0 d0Var) {
        do {
        } while (!TextUtils.isEmpty(d0Var.p()));
    }

    @Override // ba.h
    protected ba.i v(byte[] bArr, int i11, boolean z10) {
        e m11;
        this.f66855o.N(bArr, i11);
        ArrayList arrayList = new ArrayList();
        try {
            i.e(this.f66855o);
            do {
            } while (!TextUtils.isEmpty(this.f66855o.p()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int x10 = x(this.f66855o);
                if (x10 == 0) {
                    return new k(arrayList2);
                }
                if (x10 == 1) {
                    y(this.f66855o);
                } else if (x10 == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.f66855o.p();
                    arrayList.addAll(this.f66856p.d(this.f66855o));
                } else if (x10 == 3 && (m11 = f.m(this.f66855o, arrayList)) != null) {
                    arrayList2.add(m11);
                }
            }
        } catch (ParserException e11) {
            throw new SubtitleDecoderException(e11);
        }
    }
}
