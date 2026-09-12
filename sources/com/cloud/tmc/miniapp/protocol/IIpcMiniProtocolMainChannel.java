package com.cloud.tmc.miniapp.protocol;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IIpcMiniProtocolMainChannel extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IIpcMiniProtocolMainChannel {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel
        public boolean onMiniAppAbility(String str, String str2, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel
        public boolean onMiniAppDataSync(String str, String str2, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel
        public boolean onMiniAppExtra(String str, String str2, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel
        public boolean onMiniAppPerformance(String str, String str2, Bundle bundle) throws RemoteException {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IIpcMiniProtocolMainChannel {
        private static final String DESCRIPTOR = "com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel";
        static final int TRANSACTION_onMiniAppAbility = 3;
        static final int TRANSACTION_onMiniAppDataSync = 2;
        static final int TRANSACTION_onMiniAppExtra = 4;
        static final int TRANSACTION_onMiniAppPerformance = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static class Proxy implements IIpcMiniProtocolMainChannel {
            public static IIpcMiniProtocolMainChannel sDefaultImpl;
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

            @Override // com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel
            public boolean onMiniAppAbility(String str, String str2, Bundle bundle) throws RemoteException {
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
                        boolean onMiniAppAbility = Stub.getDefaultImpl().onMiniAppAbility(str, str2, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return onMiniAppAbility;
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

            @Override // com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel
            public boolean onMiniAppDataSync(String str, String str2, Bundle bundle) throws RemoteException {
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
                        boolean onMiniAppDataSync = Stub.getDefaultImpl().onMiniAppDataSync(str, str2, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return onMiniAppDataSync;
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

            @Override // com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel
            public boolean onMiniAppExtra(String str, String str2, Bundle bundle) throws RemoteException {
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
                        boolean onMiniAppExtra = Stub.getDefaultImpl().onMiniAppExtra(str, str2, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return onMiniAppExtra;
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

            @Override // com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel
            public boolean onMiniAppPerformance(String str, String str2, Bundle bundle) throws RemoteException {
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
                        boolean onMiniAppPerformance = Stub.getDefaultImpl().onMiniAppPerformance(str, str2, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return onMiniAppPerformance;
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

        public static IIpcMiniProtocolMainChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IIpcMiniProtocolMainChannel)) ? new Proxy(iBinder) : (IIpcMiniProtocolMainChannel) queryLocalInterface;
        }

        public static IIpcMiniProtocolMainChannel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IIpcMiniProtocolMainChannel iIpcMiniProtocolMainChannel) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iIpcMiniProtocolMainChannel == null) {
                return false;
            }
            Proxy.sDefaultImpl = iIpcMiniProtocolMainChannel;
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
                boolean onMiniAppPerformance = onMiniAppPerformance(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(onMiniAppPerformance ? 1 : 0);
                return true;
            }
            if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean onMiniAppDataSync = onMiniAppDataSync(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(onMiniAppDataSync ? 1 : 0);
                return true;
            }
            if (i11 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean onMiniAppAbility = onMiniAppAbility(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(onMiniAppAbility ? 1 : 0);
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
            boolean onMiniAppExtra = onMiniAppExtra(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(onMiniAppExtra ? 1 : 0);
            return true;
        }
    }

    boolean onMiniAppAbility(String str, String str2, Bundle bundle) throws RemoteException;

    boolean onMiniAppDataSync(String str, String str2, Bundle bundle) throws RemoteException;

    boolean onMiniAppExtra(String str, String str2, Bundle bundle) throws RemoteException;

    boolean onMiniAppPerformance(String str, String str2, Bundle bundle) throws RemoteException;
}
