package i3;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class b {
    public e a(long j11, byte[] bArr, int i11, int i12) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, i11, i12);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return new e(androidx.media3.common.util.h.a(new com.google.common.base.f() { // from class: i3.a
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return u1.a.b((Bundle) obj);
            }
        }, (ArrayList) androidx.media3.common.util.a.e(readBundle.getParcelableArrayList("c"))), j11, readBundle.getLong("d"));
    }
}
