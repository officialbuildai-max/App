package ba;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class d {
    public byte[] a(List list) {
        ArrayList<? extends Parcelable> d11 = com.google.android.exoplayer2.util.d.d(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", d11);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
