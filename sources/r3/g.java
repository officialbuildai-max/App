package r3;

import android.text.TextUtils;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.m;
import i3.k;
import i3.r;
import i3.s;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class g implements s {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f74207a = new j0();

    /* renamed from: b, reason: collision with root package name */
    private final b f74208b = new b();

    private static int d(j0 j0Var) {
        int i11 = -1;
        int i12 = 0;
        while (i11 == -1) {
            i12 = j0Var.f();
            String s11 = j0Var.s();
            i11 = s11 == null ? 0 : "STYLE".equals(s11) ? 2 : s11.startsWith("NOTE") ? 1 : 3;
        }
        j0Var.W(i12);
        return i11;
    }

    private static void e(j0 j0Var) {
        do {
        } while (!TextUtils.isEmpty(j0Var.s()));
    }

    @Override // i3.s
    public void a(byte[] bArr, int i11, int i12, s.b bVar, m mVar) {
        d n11;
        this.f74207a.U(bArr, i12 + i11);
        this.f74207a.W(i11);
        ArrayList arrayList = new ArrayList();
        try {
            h.e(this.f74207a);
            do {
            } while (!TextUtils.isEmpty(this.f74207a.s()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int d11 = d(this.f74207a);
                if (d11 == 0) {
                    i3.i.c(new j(arrayList2), bVar, mVar);
                    return;
                }
                if (d11 == 1) {
                    e(this.f74207a);
                } else if (d11 == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    this.f74207a.s();
                    arrayList.addAll(this.f74208b.d(this.f74207a));
                } else if (d11 == 3 && (n11 = e.n(this.f74207a, arrayList)) != null) {
                    arrayList2.add(n11);
                }
            }
        } catch (ParserException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    @Override // i3.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.a(this, bArr, i11, i12);
    }

    @Override // i3.s
    public int c() {
        return 1;
    }

    @Override // i3.s
    public /* synthetic */ void reset() {
        r.b(this);
    }
}
