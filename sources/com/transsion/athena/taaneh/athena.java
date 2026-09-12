package com.transsion.athena.taaneh;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.core.utils.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class athena {

    /* renamed from: a, reason: collision with root package name */
    private static String f42858a;

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference<Activity> f42859b;

    /* loaded from: classes5.dex */
    public static final class aethna {

        /* renamed from: a, reason: collision with root package name */
        private final String f42860a;

        aethna(String str, boolean z10) {
            this.f42860a = str;
        }

        public String a() {
            return this.f42860a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class anehat implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f42861a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f42862b;

        private anehat() {
            this.f42861a = false;
            this.f42862b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f42861a) {
                throw new IllegalStateException();
            }
            this.f42861a = true;
            return this.f42862b.poll(10L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (this.f42862b.isEmpty()) {
                    this.f42862b.put(iBinder);
                }
            } catch (InterruptedException e11) {
                e11.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class enatha implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f42863a;

        enatha(IBinder iBinder) {
            this.f42863a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f42863a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        boolean a(boolean z10) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z10 ? 1 : 0);
                this.f42863a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f42863a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.app.Activity r7) {
        /*
            r0 = 0
            if (r7 == 0) goto Lbb
            android.content.Intent r1 = r7.getIntent()
            if (r1 != 0) goto Lb
            goto Lbb
        Lb:
            java.lang.String r2 = "Athena_push_call"
            boolean r1 = r1.getBooleanExtra(r2, r0)
            if (r1 == 0) goto L15
            r7 = 3
            return r7
        L15:
            java.lang.String r1 = r7.getCallingPackage()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            java.lang.String r4 = ""
            if (r2 != 0) goto L23
            goto L59
        L23:
            android.content.Intent r1 = r7.getIntent()
            if (r1 != 0) goto L2b
            r2 = r3
            goto L4b
        L2b:
            java.lang.String r2 = "android.intent.extra.REFERRER"
            android.os.Parcelable r2 = r1.getParcelableExtra(r2)
            android.net.Uri r2 = (android.net.Uri) r2
            if (r2 == 0) goto L36
            goto L4b
        L36:
            java.lang.String r2 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r1 = r1.getStringExtra(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L47
            android.net.Uri r2 = android.net.Uri.parse(r1)
            goto L4b
        L47:
            android.net.Uri r2 = r7.getReferrer()
        L4b:
            if (r2 == 0) goto L58
            java.lang.String r1 = r2.getHost()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L58
            goto L59
        L58:
            r1 = r4
        L59:
            java.lang.String r2 = r7.getPackageName()
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            r6 = 1
            if (r5 != 0) goto Lba
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto Lba
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r5 = "android.intent.action.MAIN"
            r2.<init>(r5)
            java.lang.String r5 = "android.intent.category.HOME"
            r2.addCategory(r5)
            android.content.pm.PackageManager r5 = r7.getPackageManager()
            if (r5 != 0) goto L7d
            goto La4
        L7d:
            android.content.pm.ResolveInfo r3 = r5.resolveActivity(r2, r0)     // Catch: java.lang.Exception -> L82
            goto L8a
        L82:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.transsion.athena.taaneh.aethna.b(r0)
        L8a:
            if (r3 != 0) goto L8d
            goto La4
        L8d:
            android.content.pm.ActivityInfo r0 = r3.activityInfo
            if (r0 != 0) goto L92
            goto La4
        L92:
            java.lang.String r0 = r0.packageName
            java.lang.String r2 = "android"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L9d
            goto La4
        L9d:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto La4
            r4 = r0
        La4:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r2 = 2
            if (r0 != 0) goto Lb3
            boolean r7 = r1.equals(r4)
            if (r7 != 0) goto Lb2
            return r2
        Lb2:
            return r6
        Lb3:
            boolean r7 = b(r7, r1)
            if (r7 != 0) goto Lba
            return r2
        Lba:
            return r6
        Lbb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.taaneh.athena.a(android.app.Activity):int");
    }

    public static aethna a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        anehat anehatVar = new anehat();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, anehatVar, 1)) {
            try {
                try {
                    IBinder a11 = anehatVar.a();
                    if (a11 != null) {
                        enatha enathaVar = new enatha(a11);
                        return new aethna(enathaVar.a(), enathaVar.a(true));
                    }
                } catch (Exception e11) {
                    throw e11;
                }
            } finally {
                context.unbindService(anehatVar);
            }
        }
        throw new IOException("Google Play connection failed");
    }

    public static String a(Context context, int i11) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            Class<?> cls = telephonyManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            String str = (String) cls.getMethod("getImei", cls2).invoke(telephonyManager, Integer.valueOf(i11));
            if (TextUtils.isEmpty(str)) {
                str = (String) telephonyManager.getClass().getMethod("getDeviceId", cls2).invoke(telephonyManager, Integer.valueOf(i11));
            }
            return !TextUtils.isEmpty(str) ? c.a(str) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static List<File> a(String str) {
        List<File> a11 = a(str, new ArrayList(), null);
        if (a11 != null && a11.size() > 0) {
            try {
                Collections.sort(a11, new anateh());
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            }
        }
        return a11;
    }

    public static List<File> a(String str, long j11) {
        List<File> a11 = a(str, new ArrayList(), String.valueOf(j11));
        if (a11 != null && a11.size() > 0) {
            Collections.sort(a11, new ehanat());
        }
        return a11;
    }

    static List<File> a(String str, List<File> list, String str2) {
        File[] listFiles;
        if (str == null) {
            return list;
        }
        File file = new File(str);
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return list;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2.getAbsolutePath(), list, str2);
            } else if (str2 == null) {
                list.add(file2);
            } else if (file2.getName().contains(str2)) {
                list.add(file2);
            }
        }
        return list;
    }

    public static void a() {
        WeakReference<Activity> weakReference = f42859b;
        if (weakReference != null) {
            weakReference.clear();
            f42859b = null;
        }
    }

    private static void a(Context context, File file) {
        if (file.exists() && file.isDirectory() && file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    b(context, file2);
                } else if (file2.isDirectory()) {
                    a(context, file2);
                }
            }
        }
    }

    public static void a(Context context, String str) {
        File file = new File(str);
        a(context, file);
        if (file.isDirectory()) {
            if (file.listFiles() == null || file.listFiles().length == 0) {
                file.delete();
            }
        }
    }

    private static void a(StringBuilder sb2, int i11) {
        String num = Integer.toString(i11);
        for (int i12 = 0; i12 < 2 - num.length(); i12++) {
            sb2.append('0');
        }
        sb2.append(num);
    }

    public static String b() {
        char c11;
        try {
            int rawOffset = TimeZone.getDefault().getRawOffset() / 60000;
            if (rawOffset < 0) {
                rawOffset = -rawOffset;
                c11 = '-';
            } else {
                c11 = '+';
            }
            StringBuilder sb2 = new StringBuilder(9);
            sb2.append("GMT");
            sb2.append(c11);
            a(sb2, rawOffset / 60);
            sb2.append(':');
            a(sb2, rawOffset % 60);
            return sb2.toString();
        } catch (Throwable th2) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(th2));
            return "";
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String b(Context context) {
        if (!TextUtils.isEmpty(f42858a)) {
            return f42858a;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                String trim = string.trim();
                String a11 = TextUtils.isEmpty(trim) ? "" : c.a(trim);
                f42858a = a11;
                return a11;
            }
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(e11.getMessage());
        }
        return "";
    }

    public static String b(Context context, int i11) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            String str = (String) telephonyManager.getClass().getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i11));
            return !TextUtils.isEmpty(str) ? c.a(str) : "";
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(e11.getMessage());
            return "";
        }
    }

    public static void b(Activity activity) {
        f42859b = new WeakReference<>(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.nio.channels.spi.AbstractInterruptibleChannel, java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    public static boolean b(Context context, File file) {
        Throwable th2;
        ?? r72;
        RandomAccessFile randomAccessFile;
        ?? r73;
        FileLock fileLock;
        FileLock fileLock2;
        if (file == null) {
            return true;
        }
        if (file.getParent().contains(context.getFilesDir().getPath())) {
            File file2 = new File(file.getParent() + File.separator + System.currentTimeMillis());
            file.renameTo(file2);
            return file2.delete();
        }
        FileLock fileLock3 = null;
        try {
            randomAccessFile = new RandomAccessFile(file.getPath(), "rw");
            try {
                ?? channel = randomAccessFile.getChannel();
                try {
                    fileLock3 = channel.lock();
                    File file3 = new File(file.getParent() + File.separator + System.currentTimeMillis());
                    file.renameTo(file3);
                    boolean delete = file3.delete();
                    if (fileLock3 != null) {
                        try {
                            fileLock3.release();
                        } catch (IOException unused) {
                        }
                    }
                    try {
                        channel.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused3) {
                    }
                    return delete;
                } catch (Exception unused4) {
                    fileLock2 = fileLock3;
                    fileLock3 = channel;
                    FileLock fileLock4 = fileLock2;
                    r73 = fileLock3;
                    fileLock3 = fileLock4;
                    if (fileLock3 != null) {
                        try {
                            fileLock3.release();
                        } catch (IOException unused5) {
                        }
                    }
                    if (r73 != 0) {
                        try {
                            r73.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (IOException unused7) {
                        return false;
                    }
                } catch (Throwable th3) {
                    fileLock = fileLock3;
                    fileLock3 = channel;
                    th2 = th3;
                    FileLock fileLock5 = fileLock;
                    r72 = fileLock3;
                    fileLock3 = fileLock5;
                    if (fileLock3 != null) {
                        try {
                            fileLock3.release();
                        } catch (IOException unused8) {
                        }
                    }
                    if (r72 != 0) {
                        try {
                            r72.close();
                        } catch (IOException unused9) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th2;
                    }
                    try {
                        randomAccessFile.close();
                        throw th2;
                    } catch (IOException unused10) {
                        throw th2;
                    }
                }
            } catch (Exception unused11) {
                fileLock2 = null;
            } catch (Throwable th4) {
                th2 = th4;
                fileLock = null;
            }
        } catch (Exception unused12) {
            r73 = 0;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th2 = th5;
            r72 = 0;
            randomAccessFile = null;
        }
    }

    private static boolean b(Context context, String str) {
        PackageManager packageManager;
        List<ResolveInfo> list;
        if (TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        try {
            list = packageManager.queryIntentActivities(intent, 65536);
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(e11.getMessage());
            list = null;
        }
        if (list == null) {
            return false;
        }
        Iterator<ResolveInfo> it = list.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && str.equals(activityInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"MissingPermission", "PrivateApi", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c() {
        /*
            r0 = 0
            r1 = 1
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            java.lang.String r4 = ""
            if (r2 < r3) goto L11
            java.lang.String r2 = com.transsion.api.gateway.utils.a.a()     // Catch: java.lang.Exception -> Lf
            goto L13
        Lf:
            r2 = r4
            goto L13
        L11:
            java.lang.String r2 = android.os.Build.SERIAL
        L13:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L22
            if (r3 != 0) goto L24
            java.lang.String r3 = "unknown"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Exception -> L22
            if (r3 == 0) goto L4b
            goto L24
        L22:
            r0 = move-exception
            goto L44
        L24:
            java.lang.String r3 = "android.os.SystemProperties"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L22
            java.lang.String r5 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L22
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r0] = r7     // Catch: java.lang.Exception -> L22
            java.lang.reflect.Method r5 = r3.getMethod(r5, r6)     // Catch: java.lang.Exception -> L22
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L22
            java.lang.String r6 = "ro.serialno"
            r1[r0] = r6     // Catch: java.lang.Exception -> L22
            java.lang.Object r0 = r5.invoke(r3, r1)     // Catch: java.lang.Exception -> L22
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L22
            r2 = r0
            goto L4b
        L44:
            java.lang.String r0 = r0.getMessage()
            com.transsion.athena.taaneh.aethna.b(r0)
        L4b:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L52
            goto L56
        L52:
            java.lang.String r4 = com.transsion.core.utils.c.a(r2)
        L56:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.taaneh.athena.c():java.lang.String");
    }

    @SuppressLint({"MissingPermission"})
    public static List<com.transsion.athena.aatnhe.athena> c(Context context) {
        String str;
        String str2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        if (TextUtils.isEmpty(networkOperator)) {
            str = "";
            str2 = "";
        } else {
            str = networkOperator.substring(0, 3);
            str2 = networkOperator.substring(3);
        }
        List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
        ArrayList arrayList = new ArrayList();
        if (allCellInfo != null) {
            com.transsion.athena.aatnhe.athena athenaVar = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                    int asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (cellIdentity.getCid() > 0 && cellIdentity.getLac() > 0 && asuLevel != 99) {
                        athenaVar = (cellIdentity.getMcc() == Integer.MAX_VALUE || cellIdentity.getMnc() == Integer.MAX_VALUE) ? new com.transsion.athena.aatnhe.athena(str, str2, cellIdentity.getCid(), cellIdentity.getLac(), asuLevel, cellInfo.isRegistered()) : new com.transsion.athena.aatnhe.athena(com.transsion.athena.taaneh.anehat.a(cellIdentity.getMcc()), com.transsion.athena.taaneh.anehat.a(cellIdentity.getMnc()), cellIdentity.getCid(), cellIdentity.getLac(), asuLevel, cellInfo.isRegistered());
                    }
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellIdentityWcdma cellIdentity2 = cellInfoWcdma.getCellIdentity();
                    int asuLevel2 = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                    if (cellIdentity2.getCid() > 0 && cellIdentity2.getLac() > 0 && asuLevel2 != 99) {
                        athenaVar = (cellIdentity2.getMcc() == Integer.MAX_VALUE || cellIdentity2.getMnc() == Integer.MAX_VALUE) ? new com.transsion.athena.aatnhe.athena(str, str2, cellIdentity2.getCid(), cellIdentity2.getLac(), asuLevel2, cellInfo.isRegistered()) : new com.transsion.athena.aatnhe.athena(com.transsion.athena.taaneh.anehat.a(cellIdentity2.getMcc()), com.transsion.athena.taaneh.anehat.a(cellIdentity2.getMnc()), cellIdentity2.getCid(), cellIdentity2.getLac(), asuLevel2, cellInfo.isRegistered());
                    }
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    int asuLevel3 = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    if (cellIdentity3.getCi() > 0 && cellIdentity3.getTac() > 0 && asuLevel3 != 99) {
                        athenaVar = (cellIdentity3.getMcc() == Integer.MAX_VALUE || cellIdentity3.getMnc() == Integer.MAX_VALUE) ? new com.transsion.athena.aatnhe.athena(str, str2, cellIdentity3.getCi(), cellIdentity3.getTac(), asuLevel3, cellInfo.isRegistered()) : new com.transsion.athena.aatnhe.athena(com.transsion.athena.taaneh.anehat.a(cellIdentity3.getMcc()), com.transsion.athena.taaneh.anehat.a(cellIdentity3.getMnc()), cellIdentity3.getCi(), cellIdentity3.getTac(), asuLevel3, cellInfo.isRegistered());
                    }
                }
                if (athenaVar != null && !arrayList.contains(athenaVar)) {
                    arrayList.add(athenaVar);
                }
                if (arrayList.size() == 10) {
                    break;
                }
            }
        }
        Collections.sort(arrayList, new com.transsion.athena.taaneh.enatha());
        return arrayList;
    }

    public static Activity d() {
        WeakReference<Activity> weakReference = f42859b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return f42859b.get();
    }

    public static String d(Context context) {
        String str;
        String processName;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName)) {
                    return processName;
                }
            }
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == Process.myPid()) {
                            str = runningAppProcessInfo.processName;
                            break;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
                try {
                    Method declaredMethod = Class.forName(ProcessUtils.ACTIVITY_THREAD, false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(null, null);
                    if (!(invoke instanceof String)) {
                        return null;
                    }
                    str = (String) invoke;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return str;
        } catch (Exception e11) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.f42852a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    public static String e(Context context) {
        try {
            return context.getPackageManager().getInstallerPackageName(h(context));
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(e11.getMessage());
            return "";
        }
    }

    public static String f(Context context) {
        String str;
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception unused) {
        }
        if (telephonyManager == null) {
            str = "";
            return (!TextUtils.isEmpty(str) || str.length() < 3) ? "" : str.substring(0, 3);
        }
        str = telephonyManager.getSimOperator();
        if (TextUtils.isEmpty(str)) {
        }
    }

    public static String g(Context context) {
        String str;
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception unused) {
        }
        if (telephonyManager == null) {
            str = "";
            return (!TextUtils.isEmpty(str) || str.length() < 3) ? "" : str.substring(3);
        }
        str = telephonyManager.getSimOperator();
        if (TextUtils.isEmpty(str)) {
        }
    }

    public static String h(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception e11) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.f42852a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return "";
        }
    }

    public static int i(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(h(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return 0;
        }
    }

    public static String j(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(h(context), 0).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.f42852a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return "";
        }
    }
}
