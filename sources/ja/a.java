package ja;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import ba.b;
import ba.h;
import ba.i;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.common.base.c;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* loaded from: classes4.dex */
public final class a extends h {

    /* renamed from: o, reason: collision with root package name */
    private final d0 f66095o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f66096p;

    /* renamed from: q, reason: collision with root package name */
    private final int f66097q;

    /* renamed from: r, reason: collision with root package name */
    private final int f66098r;

    /* renamed from: s, reason: collision with root package name */
    private final String f66099s;

    /* renamed from: t, reason: collision with root package name */
    private final float f66100t;

    /* renamed from: u, reason: collision with root package name */
    private final int f66101u;

    public a(List list) {
        super("Tx3gDecoder");
        this.f66095o = new d0();
        int size = list.size();
        String str = C.SANS_SERIF_NAME;
        if (size != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f66097q = 0;
            this.f66098r = -1;
            this.f66099s = C.SANS_SERIF_NAME;
            this.f66096p = false;
            this.f66100t = 0.85f;
            this.f66101u = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f66097q = bArr[24];
        this.f66098r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f66099s = "Serif".equals(p0.E(bArr, 43, bArr.length - 43)) ? C.SERIF_NAME : str;
        int i11 = bArr[25] * 20;
        this.f66101u = i11;
        boolean z10 = (bArr[0] & 32) != 0;
        this.f66096p = z10;
        if (z10) {
            this.f66100t = p0.p(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i11, 0.0f, 0.95f);
        } else {
            this.f66100t = 0.85f;
        }
    }

    private static void A(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
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

    private static void B(SpannableStringBuilder spannableStringBuilder, String str, int i11, int i12) {
        if (str != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i11, i12, 16711713);
        }
    }

    private static String C(d0 d0Var) {
        char g11;
        y(d0Var.a() >= 2);
        int J = d0Var.J();
        return J == 0 ? "" : (d0Var.a() < 2 || !((g11 = d0Var.g()) == 65279 || g11 == 65534)) ? d0Var.B(J, c.f30282c) : d0Var.B(J, c.f30285f);
    }

    private void x(d0 d0Var, SpannableStringBuilder spannableStringBuilder) {
        y(d0Var.a() >= 12);
        int J = d0Var.J();
        int J2 = d0Var.J();
        d0Var.Q(2);
        int D = d0Var.D();
        d0Var.Q(1);
        int n11 = d0Var.n();
        if (J2 > spannableStringBuilder.length()) {
            s.i("Tx3gDecoder", "Truncating styl end (" + J2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            J2 = spannableStringBuilder.length();
        }
        if (J < J2) {
            int i11 = J2;
            A(spannableStringBuilder, D, this.f66097q, J, i11, 0);
            z(spannableStringBuilder, n11, this.f66098r, J, i11, 0);
            return;
        }
        s.i("Tx3gDecoder", "Ignoring styl with start (" + J + ") >= end (" + J2 + ").");
    }

    private static void y(boolean z10) {
        if (!z10) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void z(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i11 >>> 8) | ((i11 & 255) << 24)), i13, i14, i15 | 33);
        }
    }

    @Override // ba.h
    protected i v(byte[] bArr, int i11, boolean z10) {
        this.f66095o.N(bArr, i11);
        String C = C(this.f66095o);
        if (C.isEmpty()) {
            return b.f66102b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(C);
        A(spannableStringBuilder, this.f66097q, 0, 0, spannableStringBuilder.length(), 16711680);
        z(spannableStringBuilder, this.f66098r, -1, 0, spannableStringBuilder.length(), 16711680);
        B(spannableStringBuilder, this.f66099s, 0, spannableStringBuilder.length());
        float f11 = this.f66100t;
        while (this.f66095o.a() >= 8) {
            int e11 = this.f66095o.e();
            int n11 = this.f66095o.n();
            int n12 = this.f66095o.n();
            if (n12 == 1937013100) {
                y(this.f66095o.a() >= 2);
                int J = this.f66095o.J();
                for (int i12 = 0; i12 < J; i12++) {
                    x(this.f66095o, spannableStringBuilder);
                }
            } else if (n12 == 1952608120 && this.f66096p) {
                y(this.f66095o.a() >= 2);
                f11 = p0.p(this.f66095o.J() / this.f66101u, 0.0f, 0.95f);
            }
            this.f66095o.P(e11 + n11);
        }
        return new b(new b.C0151b().o(spannableStringBuilder).h(f11, 0).i(0).a());
    }
}
