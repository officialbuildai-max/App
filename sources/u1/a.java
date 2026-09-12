package u1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import androidx.media3.common.util.a1;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f76681a;

    /* renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f76682b;

    /* renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f76683c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f76684d;

    /* renamed from: e, reason: collision with root package name */
    public final float f76685e;

    /* renamed from: f, reason: collision with root package name */
    public final int f76686f;

    /* renamed from: g, reason: collision with root package name */
    public final int f76687g;

    /* renamed from: h, reason: collision with root package name */
    public final float f76688h;

    /* renamed from: i, reason: collision with root package name */
    public final int f76689i;

    /* renamed from: j, reason: collision with root package name */
    public final float f76690j;

    /* renamed from: k, reason: collision with root package name */
    public final float f76691k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f76692l;

    /* renamed from: m, reason: collision with root package name */
    public final int f76693m;

    /* renamed from: n, reason: collision with root package name */
    public final int f76694n;

    /* renamed from: o, reason: collision with root package name */
    public final float f76695o;

    /* renamed from: p, reason: collision with root package name */
    public final int f76696p;

    /* renamed from: q, reason: collision with root package name */
    public final float f76697q;

    /* renamed from: r, reason: collision with root package name */
    public static final a f76672r = new b().o("").a();

    /* renamed from: s, reason: collision with root package name */
    private static final String f76673s = a1.C0(0);

    /* renamed from: t, reason: collision with root package name */
    private static final String f76674t = a1.C0(17);

    /* renamed from: u, reason: collision with root package name */
    private static final String f76675u = a1.C0(1);

    /* renamed from: v, reason: collision with root package name */
    private static final String f76676v = a1.C0(2);

    /* renamed from: w, reason: collision with root package name */
    private static final String f76677w = a1.C0(3);

    /* renamed from: x, reason: collision with root package name */
    private static final String f76678x = a1.C0(18);

    /* renamed from: y, reason: collision with root package name */
    private static final String f76679y = a1.C0(4);

    /* renamed from: z, reason: collision with root package name */
    private static final String f76680z = a1.C0(5);
    private static final String A = a1.C0(6);
    private static final String B = a1.C0(7);
    private static final String C = a1.C0(8);
    private static final String D = a1.C0(9);
    private static final String E = a1.C0(10);
    private static final String F = a1.C0(11);
    private static final String G = a1.C0(12);
    private static final String H = a1.C0(13);
    private static final String I = a1.C0(14);
    private static final String J = a1.C0(15);
    private static final String K = a1.C0(16);

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private CharSequence f76698a;

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f76699b;

        /* renamed from: c, reason: collision with root package name */
        private Layout.Alignment f76700c;

        /* renamed from: d, reason: collision with root package name */
        private Layout.Alignment f76701d;

        /* renamed from: e, reason: collision with root package name */
        private float f76702e;

        /* renamed from: f, reason: collision with root package name */
        private int f76703f;

        /* renamed from: g, reason: collision with root package name */
        private int f76704g;

        /* renamed from: h, reason: collision with root package name */
        private float f76705h;

        /* renamed from: i, reason: collision with root package name */
        private int f76706i;

        /* renamed from: j, reason: collision with root package name */
        private int f76707j;

        /* renamed from: k, reason: collision with root package name */
        private float f76708k;

        /* renamed from: l, reason: collision with root package name */
        private float f76709l;

        /* renamed from: m, reason: collision with root package name */
        private float f76710m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f76711n;

        /* renamed from: o, reason: collision with root package name */
        private int f76712o;

        /* renamed from: p, reason: collision with root package name */
        private int f76713p;

        /* renamed from: q, reason: collision with root package name */
        private float f76714q;

        public b() {
            this.f76698a = null;
            this.f76699b = null;
            this.f76700c = null;
            this.f76701d = null;
            this.f76702e = -3.4028235E38f;
            this.f76703f = Integer.MIN_VALUE;
            this.f76704g = Integer.MIN_VALUE;
            this.f76705h = -3.4028235E38f;
            this.f76706i = Integer.MIN_VALUE;
            this.f76707j = Integer.MIN_VALUE;
            this.f76708k = -3.4028235E38f;
            this.f76709l = -3.4028235E38f;
            this.f76710m = -3.4028235E38f;
            this.f76711n = false;
            this.f76712o = ViewCompat.MEASURED_STATE_MASK;
            this.f76713p = Integer.MIN_VALUE;
        }

        private b(a aVar) {
            this.f76698a = aVar.f76681a;
            this.f76699b = aVar.f76684d;
            this.f76700c = aVar.f76682b;
            this.f76701d = aVar.f76683c;
            this.f76702e = aVar.f76685e;
            this.f76703f = aVar.f76686f;
            this.f76704g = aVar.f76687g;
            this.f76705h = aVar.f76688h;
            this.f76706i = aVar.f76689i;
            this.f76707j = aVar.f76694n;
            this.f76708k = aVar.f76695o;
            this.f76709l = aVar.f76690j;
            this.f76710m = aVar.f76691k;
            this.f76711n = aVar.f76692l;
            this.f76712o = aVar.f76693m;
            this.f76713p = aVar.f76696p;
            this.f76714q = aVar.f76697q;
        }

        public a a() {
            return new a(this.f76698a, this.f76700c, this.f76701d, this.f76699b, this.f76702e, this.f76703f, this.f76704g, this.f76705h, this.f76706i, this.f76707j, this.f76708k, this.f76709l, this.f76710m, this.f76711n, this.f76712o, this.f76713p, this.f76714q);
        }

        public b b() {
            this.f76711n = false;
            return this;
        }

        public int c() {
            return this.f76704g;
        }

        public int d() {
            return this.f76706i;
        }

        public CharSequence e() {
            return this.f76698a;
        }

        public b f(Bitmap bitmap) {
            this.f76699b = bitmap;
            return this;
        }

        public b g(float f11) {
            this.f76710m = f11;
            return this;
        }

        public b h(float f11, int i11) {
            this.f76702e = f11;
            this.f76703f = i11;
            return this;
        }

        public b i(int i11) {
            this.f76704g = i11;
            return this;
        }

        public b j(Layout.Alignment alignment) {
            this.f76701d = alignment;
            return this;
        }

        public b k(float f11) {
            this.f76705h = f11;
            return this;
        }

        public b l(int i11) {
            this.f76706i = i11;
            return this;
        }

        public b m(float f11) {
            this.f76714q = f11;
            return this;
        }

        public b n(float f11) {
            this.f76709l = f11;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.f76698a = charSequence;
            return this;
        }

        public b p(Layout.Alignment alignment) {
            this.f76700c = alignment;
            return this;
        }

        public b q(float f11, int i11) {
            this.f76708k = f11;
            this.f76707j = i11;
            return this;
        }

        public b r(int i11) {
            this.f76713p = i11;
            return this;
        }

        public b s(int i11) {
            this.f76712o = i11;
            this.f76711n = true;
            return this;
        }
    }

    private a(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f11, int i11, int i12, float f12, int i13, int i14, float f13, float f14, float f15, boolean z10, int i15, int i16, float f16) {
        if (charSequence == null) {
            androidx.media3.common.util.a.e(bitmap);
        } else {
            androidx.media3.common.util.a.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f76681a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f76681a = charSequence.toString();
        } else {
            this.f76681a = null;
        }
        this.f76682b = alignment;
        this.f76683c = alignment2;
        this.f76684d = bitmap;
        this.f76685e = f11;
        this.f76686f = i11;
        this.f76687g = i12;
        this.f76688h = f12;
        this.f76689i = i13;
        this.f76690j = f14;
        this.f76691k = f15;
        this.f76692l = z10;
        this.f76693m = i15;
        this.f76694n = i14;
        this.f76695o = f13;
        this.f76696p = i16;
        this.f76697q = f16;
    }

    public static a b(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(f76673s);
        if (charSequence != null) {
            bVar.o(charSequence);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(f76674t);
            if (parcelableArrayList != null) {
                SpannableString valueOf = SpannableString.valueOf(charSequence);
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    c.c((Bundle) it.next(), valueOf);
                }
                bVar.o(valueOf);
            }
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(f76675u);
        if (alignment != null) {
            bVar.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(f76676v);
        if (alignment2 != null) {
            bVar.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(f76677w);
        if (bitmap != null) {
            bVar.f(bitmap);
        } else {
            byte[] byteArray = bundle.getByteArray(f76678x);
            if (byteArray != null) {
                bVar.f(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
            }
        }
        String str = f76679y;
        if (bundle.containsKey(str)) {
            String str2 = f76680z;
            if (bundle.containsKey(str2)) {
                bVar.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = A;
        if (bundle.containsKey(str3)) {
            bVar.i(bundle.getInt(str3));
        }
        String str4 = B;
        if (bundle.containsKey(str4)) {
            bVar.k(bundle.getFloat(str4));
        }
        String str5 = C;
        if (bundle.containsKey(str5)) {
            bVar.l(bundle.getInt(str5));
        }
        String str6 = E;
        if (bundle.containsKey(str6)) {
            String str7 = D;
            if (bundle.containsKey(str7)) {
                bVar.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = F;
        if (bundle.containsKey(str8)) {
            bVar.n(bundle.getFloat(str8));
        }
        String str9 = G;
        if (bundle.containsKey(str9)) {
            bVar.g(bundle.getFloat(str9));
        }
        String str10 = H;
        if (bundle.containsKey(str10)) {
            bVar.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(I, false)) {
            bVar.b();
        }
        String str11 = J;
        if (bundle.containsKey(str11)) {
            bVar.r(bundle.getInt(str11));
        }
        String str12 = K;
        if (bundle.containsKey(str12)) {
            bVar.m(bundle.getFloat(str12));
        }
        return bVar.a();
    }

    private Bundle c() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f76681a;
        if (charSequence != null) {
            bundle.putCharSequence(f76673s, charSequence);
            CharSequence charSequence2 = this.f76681a;
            if (charSequence2 instanceof Spanned) {
                ArrayList<? extends Parcelable> a11 = c.a((Spanned) charSequence2);
                if (!a11.isEmpty()) {
                    bundle.putParcelableArrayList(f76674t, a11);
                }
            }
        }
        bundle.putSerializable(f76675u, this.f76682b);
        bundle.putSerializable(f76676v, this.f76683c);
        bundle.putFloat(f76679y, this.f76685e);
        bundle.putInt(f76680z, this.f76686f);
        bundle.putInt(A, this.f76687g);
        bundle.putFloat(B, this.f76688h);
        bundle.putInt(C, this.f76689i);
        bundle.putInt(D, this.f76694n);
        bundle.putFloat(E, this.f76695o);
        bundle.putFloat(F, this.f76690j);
        bundle.putFloat(G, this.f76691k);
        bundle.putBoolean(I, this.f76692l);
        bundle.putInt(H, this.f76693m);
        bundle.putInt(J, this.f76696p);
        bundle.putFloat(K, this.f76697q);
        return bundle;
    }

    public b a() {
        return new b();
    }

    public Bundle d() {
        Bundle c11 = c();
        if (this.f76684d != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            androidx.media3.common.util.a.g(this.f76684d.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            c11.putByteArray(f76678x, byteArrayOutputStream.toByteArray());
        }
        return c11;
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f76681a, aVar.f76681a) && this.f76682b == aVar.f76682b && this.f76683c == aVar.f76683c && ((bitmap = this.f76684d) != null ? !((bitmap2 = aVar.f76684d) == null || !bitmap.sameAs(bitmap2)) : aVar.f76684d == null) && this.f76685e == aVar.f76685e && this.f76686f == aVar.f76686f && this.f76687g == aVar.f76687g && this.f76688h == aVar.f76688h && this.f76689i == aVar.f76689i && this.f76690j == aVar.f76690j && this.f76691k == aVar.f76691k && this.f76692l == aVar.f76692l && this.f76693m == aVar.f76693m && this.f76694n == aVar.f76694n && this.f76695o == aVar.f76695o && this.f76696p == aVar.f76696p && this.f76697q == aVar.f76697q;
    }

    public int hashCode() {
        return Objects.hash(this.f76681a, this.f76682b, this.f76683c, this.f76684d, Float.valueOf(this.f76685e), Integer.valueOf(this.f76686f), Integer.valueOf(this.f76687g), Float.valueOf(this.f76688h), Integer.valueOf(this.f76689i), Float.valueOf(this.f76690j), Float.valueOf(this.f76691k), Boolean.valueOf(this.f76692l), Integer.valueOf(this.f76693m), Integer.valueOf(this.f76694n), Float.valueOf(this.f76695o), Integer.valueOf(this.f76696p), Float.valueOf(this.f76697q));
    }
}
