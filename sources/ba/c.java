package ba;

import android.os.Bundle;
import android.os.Parcel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class c {
    public ImmutableList a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return com.google.android.exoplayer2.util.d.b(b.f16332s, (ArrayList) com.google.android.exoplayer2.util.a.e(readBundle.getParcelableArrayList("c")));
    }
}
