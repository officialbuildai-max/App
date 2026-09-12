package com.google.android.exoplayer2;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public final class j extends Binder {

    /* renamed from: b, reason: collision with root package name */
    private static final int f25196b;

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableList f25197a;

    static {
        f25196b = com.google.android.exoplayer2.util.p0.f27680a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    public j(List list) {
        this.f25197a = ImmutableList.copyOf((Collection) list);
    }

    public static ImmutableList a(IBinder iBinder) {
        int readInt;
        ImmutableList.a builder = ImmutableList.builder();
        int i11 = 0;
        int i12 = 1;
        while (i12 != 0) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i11);
                try {
                    iBinder.transact(1, obtain, obtain2, 0);
                    while (true) {
                        readInt = obtain2.readInt();
                        if (readInt == 1) {
                            builder.a((Bundle) com.google.android.exoplayer2.util.a.e(obtain2.readBundle()));
                            i11++;
                        }
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    i12 = readInt;
                } catch (RemoteException e11) {
                    throw new RuntimeException(e11);
                }
            } catch (Throwable th2) {
                obtain2.recycle();
                obtain.recycle();
                throw th2;
            }
        }
        return builder.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Binder
    protected boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
        if (i11 != 1) {
            return super.onTransact(i11, parcel, parcel2, i12);
        }
        if (parcel2 == null) {
            return false;
        }
        int size = this.f25197a.size();
        int readInt = parcel.readInt();
        while (readInt < size && parcel2.dataSize() < f25196b) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) this.f25197a.get(readInt));
            readInt++;
        }
        parcel2.writeInt(readInt < size ? 2 : 0);
        return true;
    }
}
