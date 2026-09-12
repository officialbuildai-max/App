package p3;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.m;
import androidx.media3.common.util.u;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.e;
import i3.k;
import i3.r;
import i3.s;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import u1.a;

/* loaded from: classes2.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f72398a = new j0();

    /* renamed from: b, reason: collision with root package name */
    private final boolean f72399b;

    /* renamed from: c, reason: collision with root package name */
    private final int f72400c;

    /* renamed from: d, reason: collision with root package name */
    private final int f72401d;

    /* renamed from: e, reason: collision with root package name */
    private final String f72402e;

    /* renamed from: f, reason: collision with root package name */
    private final float f72403f;

    /* renamed from: g, reason: collision with root package name */
    private final int f72404g;

    public a(List list) {
        int size = list.size();
        String str = C.SANS_SERIF_NAME;
        if (size != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f72400c = 0;
            this.f72401d = -1;
            this.f72402e = C.SANS_SERIF_NAME;
            this.f72399b = false;
            this.f72403f = 0.85f;
            this.f72404g = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f72400c = bArr[24];
        this.f72401d = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f72402e = "Serif".equals(a1.I(bArr, 43, bArr.length - 43)) ? C.SERIF_NAME : str;
        int i11 = bArr[25] * 20;
        this.f72404g = i11;
        boolean z10 = (bArr[0] & 32) != 0;
        this.f72399b = z10;
        if (z10) {
            this.f72403f = a1.o(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i11, 0.0f, 0.95f);
        } else {
            this.f72403f = 0.85f;
        }
    }

    private void d(j0 j0Var, SpannableStringBuilder spannableStringBuilder) {
        androidx.media3.common.util.a.a(j0Var.a() >= 12);
        int P = j0Var.P();
        int P2 = j0Var.P();
        j0Var.X(2);
        int H = j0Var.H();
        j0Var.X(1);
        int q11 = j0Var.q();
        if (P2 > spannableStringBuilder.length()) {
            u.h("Tx3gParser", "Truncating styl end (" + P2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            P2 = spannableStringBuilder.length();
        }
        if (P < P2) {
            int i11 = P2;
            f(spannableStringBuilder, H, this.f72400c, P, i11, 0);
            e(spannableStringBuilder, q11, this.f72401d, P, i11, 0);
            return;
        }
        u.h("Tx3gParser", "Ignoring styl with start (" + P + ") >= end (" + P2 + ").");
    }

    private static void e(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i11 >>> 8) | ((i11 & 255) << 24)), i13, i14, i15 | 33);
        }
    }

    private static void f(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            int i16 = i15 | 33;
            boolean z10 = (i11 & 1) != 0;
            boolean z11 = (i11 & 2) != 0;
            if (z10) {
                if (z11) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i13, i14, i16);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i13, i14, i16);
                }
            } else if (z11) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i13, i14, i16);
            }
            boolean z12 = (i11 & 4) != 0;
            if (z12) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i13, i14, i16);
            }
            if (z12 || z10 || z11) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i13, i14, i16);
        }
    }

    private static void g(SpannableStringBuilder spannableStringBuilder, String str, int i11, int i12) {
        if (str != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i11, i12, 16711713);
        }
    }

    private static String h(j0 j0Var) {
        androidx.media3.common.util.a.a(j0Var.a() >= 2);
        int P = j0Var.P();
        if (P == 0) {
            return "";
        }
        int f11 = j0Var.f();
        Charset R = j0Var.R();
        int f12 = P - (j0Var.f() - f11);
        if (R == null) {
            R = StandardCharsets.UTF_8;
        }
        return j0Var.F(f12, R);
    }

    @Override // i3.s
    public void a(byte[] bArr, int i11, int i12, s.b bVar, m mVar) {
        this.f72398a.U(bArr, i11 + i12);
        this.f72398a.W(i11);
        String h11 = h(this.f72398a);
        if (h11.isEmpty()) {
            mVar.accept(new e(ImmutableList.of(), C.TIME_UNSET, C.TIME_UNSET));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(h11);
        f(spannableStringBuilder, this.f72400c, 0, 0, spannableStringBuilder.length(), 16711680);
        e(spannableStringBuilder, this.f72401d, -1, 0, spannableStringBuilder.length(), 16711680);
        g(spannableStringBuilder, this.f72402e, 0, spannableStringBuilder.length());
        float f11 = this.f72403f;
        while (this.f72398a.a() >= 8) {
            int f12 = this.f72398a.f();
            int q11 = this.f72398a.q();
            int q12 = this.f72398a.q();
            if (q12 == 1937013100) {
                androidx.media3.common.util.a.a(this.f72398a.a() >= 2);
                int P = this.f72398a.P();
                for (int i13 = 0; i13 < P; i13++) {
                    d(this.f72398a, spannableStringBuilder);
                }
            } else if (q12 == 1952608120 && this.f72399b) {
                androidx.media3.common.util.a.a(this.f72398a.a() >= 2);
                f11 = a1.o(this.f72398a.P() / this.f72404g, 0.0f, 0.95f);
            }
            this.f72398a.W(f12 + q11);
        }
        mVar.accept(new e(ImmutableList.of(new a.b().o(spannableStringBuilder).h(f11, 0).i(0).a()), C.TIME_UNSET, C.TIME_UNSET));
    }

    @Override // i3.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.a(this, bArr, i11, i12);
    }

    @Override // i3.s
    public int c() {
        return 2;
    }

    @Override // i3.s
    public /* synthetic */ void reset() {
        r.b(this);
    }
}
