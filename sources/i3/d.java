package i3;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class d {
    public byte[] a(List list, long j11) {
        ArrayList<? extends Parcelable> b11 = androidx.media3.common.util.h.b(list, new com.google.common.base.f() { // from class: i3.c
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return ((u1.a) obj).d();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", b11);
        bundle.putLong("d", j11);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
