package ba;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.k;

/* loaded from: classes3.dex */
public final class b implements com.google.android.exoplayer2.k {

    /* renamed from: r, reason: collision with root package name */
    public static final b f16331r = new C0151b().o("").a();

    /* renamed from: s, reason: collision with root package name */
    public static final k.a f16332s = new k.a() { // from class: ba.a
        @Override // com.google.android.exoplayer2.k.a
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            b c11;
            c11 = b.c(bundle);
            return c11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f16333a;

    /* renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f16334b;

    /* renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f16335c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f16336d;

    /* renamed from: e, reason: collision with root package name */
    public final float f16337e;

    /* renamed from: f, reason: collision with root package name */
    public final int f16338f;

    /* renamed from: g, reason: collision with root package name */
    public final int f16339g;

    /* renamed from: h, reason: collision with root package name */
    public final float f16340h;

    /* renamed from: i, reason: collision with root package name */
    public final int f16341i;

    /* renamed from: j, reason: collision with root package name */
    public final float f16342j;

    /* renamed from: k, reason: collision with root package name */
    public final float f16343k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f16344l;

    /* renamed from: m, reason: collision with root package name */
    public final int f16345m;

    /* renamed from: n, reason: collision with root package name */
    public final int f16346n;

    /* renamed from: o, reason: collision with root package name */
    public final float f16347o;

    /* renamed from: p, reason: collision with root package name */
    public final int f16348p;

    /* renamed from: q, reason: collision with root package name */
    public final float f16349q;

    /* renamed from: ba.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0151b {

        /* renamed from: a, reason: collision with root package name */
        private CharSequence f16350a;

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f16351b;

        /* renamed from: c, reason: collision with root package name */
        private Layout.Alignment f16352c;

        /* renamed from: d, reason: collision with root package name */
        private Layout.Alignment f16353d;

        /* renamed from: e, reason: collision with root package name */
        private float f16354e;

        /* renamed from: f, reason: collision with root package name */
        private int f16355f;

        /* renamed from: g, reason: collision with root package name */
        private int f16356g;

        /* renamed from: h, reason: collision with root package name */
        private float f16357h;

        /* renamed from: i, reason: collision with root package name */
        private int f16358i;

        /* renamed from: j, reason: collision with root package name */
        private int f16359j;

        /* renamed from: k, reason: collision with root package name */
        private float f16360k;

        /* renamed from: l, reason: collision with root package name */
        private float f16361l;

        /* renamed from: m, reason: collision with root package name */
        private float f16362m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f16363n;

        /* renamed from: o, reason: collision with root package name */
        private int f16364o;

        /* renamed from: p, reason: collision with root package name */
        private int f16365p;

        /* renamed from: q, reason: collision with root package name */
        private float f16366q;

        public C0151b() {
            this.f16350a = null;
            this.f16351b = null;
            this.f16352c = null;
            this.f16353d = null;
            this.f16354e = -3.4028235E38f;
            this.f16355f = Integer.MIN_VALUE;
            this.f16356g = Integer.MIN_VALUE;
            this.f16357h = -3.4028235E38f;
            this.f16358i = Integer.MIN_VALUE;
            this.f16359j = Integer.MIN_VALUE;
            this.f16360k = -3.4028235E38f;
            this.f16361l = -3.4028235E38f;
            this.f16362m = -3.4028235E38f;
            this.f16363n = false;
            this.f16364o = ViewCompat.MEASURED_STATE_MASK;
            this.f16365p = Integer.MIN_VALUE;
        }

        private C0151b(b bVar) {
            this.f16350a = bVar.f16333a;
            this.f16351b = bVar.f16336d;
            this.f16352c = bVar.f16334b;
            this.f16353d = bVar.f16335c;
            this.f16354e = bVar.f16337e;
            this.f16355f = bVar.f16338f;
            this.f16356g = bVar.f16339g;
            this.f16357h = bVar.f16340h;
            this.f16358i = bVar.f16341i;
            this.f16359j = bVar.f16346n;
            this.f16360k = bVar.f16347o;
            this.f16361l = bVar.f16342j;
            this.f16362m = bVar.f16343k;
            this.f16363n = bVar.f16344l;
            this.f16364o = bVar.f16345m;
            this.f16365p = bVar.f16348p;
            this.f16366q = bVar.f16349q;
        }

        public b a() {
            return new b(this.f16350a, this.f16352c, this.f16353d, this.f16351b, this.f16354e, this.f16355f, this.f16356g, this.f16357h, this.f16358i, this.f16359j, this.f16360k, this.f16361l, this.f16362m, this.f16363n, this.f16364o, this.f16365p, this.f16366q);
        }

        public C0151b b() {
            this.f16363n = false;
            return this;
        }

        public int c() {
            return this.f16356g;
        }

        public int d() {
            return this.f16358i;
        }

        public CharSequence e() {
            return this.f16350a;
        }

        public C0151b f(Bitmap bitmap) {
            this.f16351b = bitmap;
            return this;
        }

        public C0151b g(float f11) {
            this.f16362m = f11;
            return this;
        }

        public C0151b h(float f11, int i11) {
            this.f16354e = f11;
            this.f16355f = i11;
            return this;
        }

        public C0151b i(int i11) {
            this.f16356g = i11;
            return this;
        }

        public C0151b j(Layout.Alignment alignment) {
            this.f16353d = alignment;
            return this;
        }

        public C0151b k(float f11) {
            this.f16357h = f11;
            return this;
        }

        public C0151b l(int i11) {
            this.f16358i = i11;
            return this;
        }

        public C0151b m(float f11) {
            this.f16366q = f11;
            return this;
        }

        public C0151b n(float f11) {
            this.f16361l = f11;
            return this;
        }

        public C0151b o(CharSequence charSequence) {
            this.f16350a = charSequence;
            return this;
        }

        public C0151b p(Layout.Alignment alignment) {
            this.f16352c = alignment;
            return this;
        }

        public C0151b q(float f11, int i11) {
            this.f16360k = f11;
            this.f16359j = i11;
            return this;
        }

        public C0151b r(int i11) {
            this.f16365p = i11;
            return this;
        }

        public C0151b s(int i11) {
            this.f16364o = i11;
            this.f16363n = true;
            return this;
        }
    }

    private b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f11, int i11, int i12, float f12, int i13, int i14, float f13, float f14, float f15, boolean z10, int i15, int i16, float f16) {
        if (charSequence == null) {
            com.google.android.exoplayer2.util.a.e(bitmap);
        } else {
            com.google.android.exoplayer2.util.a.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f16333a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f16333a = charSequence.toString();
        } else {
            this.f16333a = null;
        }
        this.f16334b = alignment;
        this.f16335c = alignment2;
        this.f16336d = bitmap;
        this.f16337e = f11;
        this.f16338f = i11;
        this.f16339g = i12;
        this.f16340h = f12;
        this.f16341i = i13;
        this.f16342j = f14;
        this.f16343k = f15;
        this.f16344l = z10;
        this.f16345m = i15;
        this.f16346n = i14;
        this.f16347o = f13;
        this.f16348p = i16;
        this.f16349q = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b c(Bundle bundle) {
        C0151b c0151b = new C0151b();
        CharSequence charSequence = bundle.getCharSequence(d(0));
        if (charSequence != null) {
            c0151b.o(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(d(1));
        if (alignment != null) {
            c0151b.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(d(2));
        if (alignment2 != null) {
            c0151b.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(d(3));
        if (bitmap != null) {
            c0151b.f(bitmap);
        }
        if (bundle.containsKey(d(4)) && bundle.containsKey(d(5))) {
            c0151b.h(bundle.getFloat(d(4)), bundle.getInt(d(5)));
        }
        if (bundle.containsKey(d(6))) {
            c0151b.i(bundle.getInt(d(6)));
        }
        if (bundle.containsKey(d(7))) {
            c0151b.k(bundle.getFloat(d(7)));
        }
        if (bundle.containsKey(d(8))) {
            c0151b.l(bundle.getInt(d(8)));
        }
        if (bundle.containsKey(d(10)) && bundle.containsKey(d(9))) {
            c0151b.q(bundle.getFloat(d(10)), bundle.getInt(d(9)));
        }
        if (bundle.containsKey(d(11))) {
            c0151b.n(bundle.getFloat(d(11)));
        }
        if (bundle.containsKey(d(12))) {
            c0151b.g(bundle.getFloat(d(12)));
        }
        if (bundle.containsKey(d(13))) {
            c0151b.s(bundle.getInt(d(13)));
        }
        if (!bundle.getBoolean(d(14), false)) {
            c0151b.b();
        }
        if (bundle.containsKey(d(15))) {
            c0151b.r(bundle.getInt(d(15)));
        }
        if (bundle.containsKey(d(16))) {
            c0151b.m(bundle.getFloat(d(16)));
        }
        return c0151b.a();
    }

    private static String d(int i11) {
        return Integer.toString(i11, 36);
    }

    public C0151b b() {
        return new C0151b();
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.f16333a, bVar.f16333a) && this.f16334b == bVar.f16334b && this.f16335c == bVar.f16335c && ((bitmap = this.f16336d) != null ? !((bitmap2 = bVar.f16336d) == null || !bitmap.sameAs(bitmap2)) : bVar.f16336d == null) && this.f16337e == bVar.f16337e && this.f16338f == bVar.f16338f && this.f16339g == bVar.f16339g && this.f16340h == bVar.f16340h && this.f16341i == bVar.f16341i && this.f16342j == bVar.f16342j && this.f16343k == bVar.f16343k && this.f16344l == bVar.f16344l && this.f16345m == bVar.f16345m && this.f16346n == bVar.f16346n && this.f16347o == bVar.f16347o && this.f16348p == bVar.f16348p && this.f16349q == bVar.f16349q;
    }

    public int hashCode() {
        return com.google.common.base.j.b(this.f16333a, this.f16334b, this.f16335c, this.f16336d, Float.valueOf(this.f16337e), Integer.valueOf(this.f16338f), Integer.valueOf(this.f16339g), Float.valueOf(this.f16340h), Integer.valueOf(this.f16341i), Float.valueOf(this.f16342j), Float.valueOf(this.f16343k), Boolean.valueOf(this.f16344l), Integer.valueOf(this.f16345m), Integer.valueOf(this.f16346n), Float.valueOf(this.f16347o), Integer.valueOf(this.f16348p), Float.valueOf(this.f16349q));
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(d(0), this.f16333a);
        bundle.putSerializable(d(1), this.f16334b);
        bundle.putSerializable(d(2), this.f16335c);
        bundle.putParcelable(d(3), this.f16336d);
        bundle.putFloat(d(4), this.f16337e);
        bundle.putInt(d(5), this.f16338f);
        bundle.putInt(d(6), this.f16339g);
        bundle.putFloat(d(7), this.f16340h);
        bundle.putInt(d(8), this.f16341i);
        bundle.putInt(d(9), this.f16346n);
        bundle.putFloat(d(10), this.f16347o);
        bundle.putFloat(d(11), this.f16342j);
        bundle.putFloat(d(12), this.f16343k);
        bundle.putBoolean(d(14), this.f16344l);
        bundle.putInt(d(13), this.f16345m);
        bundle.putInt(d(15), this.f16348p);
        bundle.putFloat(d(16), this.f16349q);
        return bundle;
    }
}
