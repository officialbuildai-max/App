package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f8222a = versionedParcel.p(iconCompat.f8222a, 1);
        iconCompat.f8224c = versionedParcel.j(iconCompat.f8224c, 2);
        iconCompat.f8225d = versionedParcel.r(iconCompat.f8225d, 3);
        iconCompat.f8226e = versionedParcel.p(iconCompat.f8226e, 4);
        iconCompat.f8227f = versionedParcel.p(iconCompat.f8227f, 5);
        iconCompat.f8228g = (ColorStateList) versionedParcel.r(iconCompat.f8228g, 6);
        iconCompat.f8230i = versionedParcel.t(iconCompat.f8230i, 7);
        iconCompat.f8231j = versionedParcel.t(iconCompat.f8231j, 8);
        iconCompat.t();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.u(versionedParcel.f());
        int i11 = iconCompat.f8222a;
        if (-1 != i11) {
            versionedParcel.F(i11, 1);
        }
        byte[] bArr = iconCompat.f8224c;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f8225d;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i12 = iconCompat.f8226e;
        if (i12 != 0) {
            versionedParcel.F(i12, 4);
        }
        int i13 = iconCompat.f8227f;
        if (i13 != 0) {
            versionedParcel.F(i13, 5);
        }
        ColorStateList colorStateList = iconCompat.f8228g;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f8230i;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f8231j;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
