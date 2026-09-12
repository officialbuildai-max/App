package com.cloud.tmc.miniapp;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IIpcMiniPSChannel extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IIpcMiniPSChannel {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniPSChannel
        public boolean miniAppAbility(String str, String str2, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniPSChannel
        public boolean miniAppDataSync(String str, String str2, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniPSChannel
        public boolean miniAppExtra(String str, String str2, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniPSChannel
        public boolean miniAppPerformance(String str, String str2, Bundle bundle) throws RemoteException {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IIpcMiniPSChannel {
        private static final String DESCRIPTOR = "com.cloud.tmc.miniapp.IIpcMiniPSChannel";
        static final int TRANSACTION_miniAppAbility = 3;
        static final int TRANSACTION_miniAppDataSync = 2;
        static final int TRANSACTION_miniAppExtra = 4;
        static final int TRANSACTION_miniAppPerformance = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static class Proxy implements IIpcMiniPSChannel {
            public static IIpcMiniPSChannel sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.cloud.tmc.miniapp.IIpcMiniPSChannel
            public boolean miniAppAbility(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean miniAppAbility = Stub.getDefaultImpl().miniAppAbility(str, str2, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return miniAppAbility;
                    }
                    obtain2.readException();
                    boolean z10 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // com.cloud.tmc.miniapp.IIpcMiniPSChannel
            public boolean miniAppDataSync(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean miniAppDataSync = Stub.getDefaultImpl().miniAppDataSync(str, str2, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return miniAppDataSync;
                    }
                    obtain2.readException();
                    boolean z10 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // com.cloud.tmc.miniapp.IIpcMiniPSChannel
            public boolean miniAppExtra(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean miniAppExtra = Stub.getDefaultImpl().miniAppExtra(str, str2, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return miniAppExtra;
                    }
                    obtain2.readException();
                    boolean z10 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // com.cloud.tmc.miniapp.IIpcMiniPSChannel
            public boolean miniAppPerformance(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean miniAppPerformance = Stub.getDefaultImpl().miniAppPerformance(str, str2, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return miniAppPerformance;
                    }
                    obtain2.readException();
                    boolean z10 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IIpcMiniPSChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IIpcMiniPSChannel)) ? new Proxy(iBinder) : (IIpcMiniPSChannel) queryLocalInterface;
        }

        public static IIpcMiniPSChannel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IIpcMiniPSChannel iIpcMiniPSChannel) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iIpcMiniPSChannel == null) {
                return false;
            }
            Proxy.sDefaultImpl = iIpcMiniPSChannel;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean miniAppPerformance = miniAppPerformance(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(miniAppPerformance ? 1 : 0);
                return true;
            }
            if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean miniAppDataSync = miniAppDataSync(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(miniAppDataSync ? 1 : 0);
                return true;
            }
            if (i11 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean miniAppAbility = miniAppAbility(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(miniAppAbility ? 1 : 0);
                return true;
            }
            if (i11 != 4) {
                if (i11 != 1598968902) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean miniAppExtra = miniAppExtra(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(miniAppExtra ? 1 : 0);
            return true;
        }
    }

    boolean miniAppAbility(String str, String str2, Bundle bundle) throws RemoteException;

    boolean miniAppDataSync(String str, String str2, Bundle bundle) throws RemoteException;

    boolean miniAppExtra(String str, String str2, Bundle bundle) throws RemoteException;

    boolean miniAppPerformance(String str, String str2, Bundle bundle) throws RemoteException;
}
