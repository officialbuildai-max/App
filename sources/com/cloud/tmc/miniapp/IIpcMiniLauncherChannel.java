package com.cloud.tmc.miniapp;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.cloud.tmc.miniapp.IMiniAppLifecycleInterface;

/* loaded from: classes3.dex */
public interface IIpcMiniLauncherChannel extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IIpcMiniLauncherChannel {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
        public boolean launchHostProcess() throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
        public boolean launcherMiniApp(String str, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
        public boolean preLauncherData(String str, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
        public boolean registerMiniAppLifecycleListener(IMiniAppLifecycleInterface iMiniAppLifecycleInterface) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
        public boolean syncLauncherLifecycletoMiniapp(int i11, int i12) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
        public boolean syncLauncherNewsData(String str, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
        public boolean updateLauncherData(String str, String str2) throws RemoteException {
            return false;
        }

        @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
        public boolean warmupWebview(boolean z10) throws RemoteException {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IIpcMiniLauncherChannel {
        private static final String DESCRIPTOR = "com.cloud.tmc.miniapp.IIpcMiniLauncherChannel";
        public static final int TRANSACTION_launchHostProcess = 6;
        public static final int TRANSACTION_launcherMiniApp = 1;
        public static final int TRANSACTION_preLauncherData = 3;
        public static final int TRANSACTION_registerMiniAppLifecycleListener = 8;
        public static final int TRANSACTION_syncLauncherLifecycletoMiniapp = 5;
        public static final int TRANSACTION_syncLauncherNewsData = 7;
        public static final int TRANSACTION_updateLauncherData = 4;
        public static final int TRANSACTION_warmupWebview = 2;

        /* loaded from: classes3.dex */
        public static class Proxy implements IIpcMiniLauncherChannel {
            public static IIpcMiniLauncherChannel sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
            public boolean launchHostProcess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().launchHostProcess();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
            public boolean launcherMiniApp(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean launcherMiniApp = Stub.getDefaultImpl().launcherMiniApp(str, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return launcherMiniApp;
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

            @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
            public boolean preLauncherData(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean preLauncherData = Stub.getDefaultImpl().preLauncherData(str, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return preLauncherData;
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

            @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
            public boolean registerMiniAppLifecycleListener(IMiniAppLifecycleInterface iMiniAppLifecycleInterface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMiniAppLifecycleInterface != null ? iMiniAppLifecycleInterface.asBinder() : null);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean registerMiniAppLifecycleListener = Stub.getDefaultImpl().registerMiniAppLifecycleListener(iMiniAppLifecycleInterface);
                        obtain2.recycle();
                        obtain.recycle();
                        return registerMiniAppLifecycleListener;
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

            @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
            public boolean syncLauncherLifecycletoMiniapp(int i11, int i12) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().syncLauncherLifecycletoMiniapp(i11, i12);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
            public boolean syncLauncherNewsData(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean syncLauncherNewsData = Stub.getDefaultImpl().syncLauncherNewsData(str, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return syncLauncherNewsData;
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

            @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
            public boolean updateLauncherData(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateLauncherData(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.cloud.tmc.miniapp.IIpcMiniLauncherChannel
            public boolean warmupWebview(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().warmupWebview(z10);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IIpcMiniLauncherChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IIpcMiniLauncherChannel)) ? new Proxy(iBinder) : (IIpcMiniLauncherChannel) queryLocalInterface;
        }

        public static IIpcMiniLauncherChannel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IIpcMiniLauncherChannel iIpcMiniLauncherChannel) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iIpcMiniLauncherChannel == null) {
                return false;
            }
            Proxy.sDefaultImpl = iIpcMiniLauncherChannel;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i11) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean launcherMiniApp = launcherMiniApp(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(launcherMiniApp ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean warmupWebview = warmupWebview(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(warmupWebview ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean preLauncherData = preLauncherData(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(preLauncherData ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean updateLauncherData = updateLauncherData(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(updateLauncherData ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean syncLauncherLifecycletoMiniapp = syncLauncherLifecycletoMiniapp(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(syncLauncherLifecycletoMiniapp ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean launchHostProcess = launchHostProcess();
                    parcel2.writeNoException();
                    parcel2.writeInt(launchHostProcess ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean syncLauncherNewsData = syncLauncherNewsData(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(syncLauncherNewsData ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean registerMiniAppLifecycleListener = registerMiniAppLifecycleListener(IMiniAppLifecycleInterface.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(registerMiniAppLifecycleListener ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i11, parcel, parcel2, i12);
            }
        }
    }

    boolean launchHostProcess() throws RemoteException;

    boolean launcherMiniApp(String str, Bundle bundle) throws RemoteException;

    boolean preLauncherData(String str, Bundle bundle) throws RemoteException;

    boolean registerMiniAppLifecycleListener(IMiniAppLifecycleInterface iMiniAppLifecycleInterface) throws RemoteException;

    boolean syncLauncherLifecycletoMiniapp(int i11, int i12) throws RemoteException;

    boolean syncLauncherNewsData(String str, Bundle bundle) throws RemoteException;

    boolean updateLauncherData(String str, String str2) throws RemoteException;

    boolean warmupWebview(boolean z10) throws RemoteException;
}
