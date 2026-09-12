package com.wecloud.load.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.wecloud.load.lib.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/* loaded from: classes7.dex */
public interface h extends IInterface {

    /* loaded from: classes7.dex */
    public static abstract class a extends Binder implements h {

        /* renamed from: com.wecloud.load.lib.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        private static class C0744a implements h {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f60967a;

            C0744a(IBinder iBinder) {
                this.f60967a = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void Z0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // com.wecloud.load.lib.h
            public void R(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadCallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f60967a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f60967a;
            }

            @Override // com.wecloud.load.lib.h
            public void e(String str, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadCallback");
                    obtain.writeString(str);
                    obtain.writeInt(i11);
                    this.f60967a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.wecloud.load.lib.h
            public void n0(int i11, int i12, int i13) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadCallback");
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeInt(i13);
                    this.f60967a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.wecloud.load.lib.h
            public void onError(int i11, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadCallback");
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    this.f60967a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.wecloud.load.lib.h
            public void q0(int i11, int i12, int i13, List list, Map map) {
                final Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadCallback");
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeInt(i13);
                    obtain.writeStringList(list);
                    if (map == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(map.size());
                        map.forEach(new BiConsumer() { // from class: com.wecloud.load.lib.g
                            @Override // java.util.function.BiConsumer
                            public final void accept(Object obj, Object obj2) {
                                h.a.C0744a.Z0(obtain, (String) obj, (String) obj2);
                            }
                        });
                    }
                    this.f60967a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public a() {
            attachInterface(this, "com.wecloud.load.lib.ISoLoadCallback");
        }

        public static h Z0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.wecloud.load.lib.ISoLoadCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof h)) ? new C0744a(iBinder) : (h) queryLocalInterface;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a1(Parcel parcel, Map map, int i11) {
            map.put(parcel.readString(), parcel.readString());
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, final Parcel parcel, Parcel parcel2, int i12) {
            IntStream range;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface("com.wecloud.load.lib.ISoLoadCallback");
            }
            if (i11 == 1598968902) {
                parcel2.writeString("com.wecloud.load.lib.ISoLoadCallback");
                return true;
            }
            if (i11 == 1) {
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                int readInt4 = parcel.readInt();
                final HashMap hashMap = readInt4 < 0 ? null : new HashMap();
                range = IntStream.range(0, readInt4);
                range.forEach(new IntConsumer() { // from class: com.wecloud.load.lib.e
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i13) {
                        h.a.a1(parcel, hashMap, i13);
                    }
                });
                q0(readInt, readInt2, readInt3, createStringArrayList, hashMap);
                parcel2.writeNoException();
            } else if (i11 == 2) {
                n0(parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
            } else if (i11 == 3) {
                onError(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            } else if (i11 == 4) {
                e(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i11 != 5) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                R(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void R(String str, String str2);

    void e(String str, int i11);

    void n0(int i11, int i12, int i13);

    void onError(int i11, String str);

    void q0(int i11, int i12, int i13, List list, Map map);
}
