package com.aliyun.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.cicada.player.utils.NativeUsed;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.json.JSONObject;

@NativeUsed
/* loaded from: classes2.dex */
public class DeviceInfoUtils {
    public static File ALIVC_DATA_FILE = null;
    public static final String DATA_DIRECTORY = "AlivcData";
    private static final int MAX_WRITE_COUNT = 10;
    private static final String UUID_FILE = "alivc_data.txt";
    private static final String UUID_PROP = "UUID";
    private static CpuProcessTracker mCpuTracker;
    private static Context sAppContext;
    private static String sCpuProcessorInfo;
    private static String sDeviceUUID;
    private static String sSessionId;
    private static int sWriteUUIDCount;

    static {
        NativeLoader.loadPlayer();
        ALIVC_DATA_FILE = null;
    }

    static /* synthetic */ int access$008() {
        int i11 = sWriteUUIDCount;
        sWriteUUIDCount = i11 + 1;
        return i11;
    }

    private static String canGetContext() {
        return getSDKContext() != null ? "true" : "false";
    }

    public static String generateNewSessionId() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        sSessionId = replace;
        return replace;
    }

    public static String getApplicationName() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = getSDKContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(getSDKContext().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static String getApplicationVersion() {
        try {
            return getSDKContext() != null ? getSDKContext().getPackageManager().getPackageInfo(getSDKContext().getPackageName(), 0).versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getCPUInfo() {
        String str;
        try {
            str = (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class).invoke(null, "ro.board.platform", "");
        } catch (Exception e11) {
            e11.printStackTrace();
            str = "";
        }
        return str.equals("") ? Build.HARDWARE : str;
    }

    public static String getCPUProcessorInfo() {
        if (!TextUtils.isEmpty(sCpuProcessorInfo)) {
            return sCpuProcessorInfo;
        }
        requestCPUInfo();
        return sCpuProcessorInfo;
    }

    public static String getCPUUsageRatio() {
        if (mCpuTracker == null) {
            mCpuTracker = new CpuProcessTracker();
        }
        return String.valueOf(mCpuTracker.getMyPicCpuPercent());
    }

    private static String getCacheDir() {
        File externalCacheDir;
        return (getSDKContext() == null || (externalCacheDir = getSDKContext().getExternalCacheDir()) == null || !externalCacheDir.exists()) ? "" : externalCacheDir.getAbsolutePath();
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String getCurrentTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    private static String getDeviceFeature() {
        JSONObject jSONObject = new JSONObject();
        if (sAppContext != null) {
            try {
                jSONObject.put("UIModeType", getUIModeType());
            } catch (Exception unused) {
            }
            putFeature(jSONObject, "android.hardware.audio.low_latency");
            putFeature(jSONObject, "android.hardware.bluetooth");
            putFeature(jSONObject, "android.hardware.bluetooth_le");
            putFeature(jSONObject, "android.hardware.screen.landscape");
            putFeature(jSONObject, "android.hardware.screen.portrait");
            int i11 = Build.VERSION.SDK_INT;
            putFeature(jSONObject, "android.hardware.type.watch");
            putFeature(jSONObject, "android.hardware.audio.output");
            putFeature(jSONObject, "android.software.live_tv");
            putFeature(jSONObject, "android.hardware.opengles.aep");
            putFeature(jSONObject, "android.hardware.audio.pro");
            putFeature(jSONObject, "android.hardware.type.automotive");
            putFeature(jSONObject, "android.hardware.sensor.hifi_sensors");
            putFeature(jSONObject, "android.software.midi");
            if (i11 >= 24) {
                putFeature(jSONObject, "android.software.picture_in_picture");
                putFeature(jSONObject, "android.hardware.vr.high_performance");
                putFeature(jSONObject, "android.hardware.vulkan.level");
                putFeature(jSONObject, "android.hardware.vulkan.version");
            }
            if (i11 >= 27) {
                putFeature(jSONObject, "android.hardware.ram.low");
                putFeature(jSONObject, "android.hardware.ram.normal");
            }
            if (i11 >= 26) {
                putFeature(jSONObject, "android.software.activities_on_secondary_displays");
                putFeature(jSONObject, "android.hardware.type.embedded");
                putFeature(jSONObject, "android.hardware.vr.headtracking");
                putFeature(jSONObject, "android.hardware.vulkan.compute");
            }
            putFeature(jSONObject, "android.hardware.touchscreen");
            putFeature(jSONObject, "android.hardware.faketouch");
            putFeature(jSONObject, "android.hardware.telephony");
            putFeature(jSONObject, "android.hardware.camera");
            putFeature(jSONObject, "android.hardware.nfc");
            putFeature(jSONObject, "android.hardware.location.gps");
            putFeature(jSONObject, "android.hardware.microphone");
            putFeature(jSONObject, "android.hardware.sensor.compass");
        }
        return jSONObject.toString();
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static synchronized String getDeviceUUID() {
        synchronized (DeviceInfoUtils.class) {
            if (!TextUtils.isEmpty(sDeviceUUID)) {
                return sDeviceUUID;
            }
            if (ALIVC_DATA_FILE == null) {
                ALIVC_DATA_FILE = new File(getSDKContext().getCacheDir(), DATA_DIRECTORY);
            }
            File file = new File(ALIVC_DATA_FILE, UUID_FILE);
            try {
                if (ALIVC_DATA_FILE.exists() || ALIVC_DATA_FILE.mkdir()) {
                    Properties properties = new Properties();
                    FileReader fileReader = new FileReader(file);
                    properties.load(fileReader);
                    fileReader.close();
                    sDeviceUUID = properties.getProperty(UUID_PROP);
                }
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(sDeviceUUID)) {
                sWriteUUIDCount = 0;
                String replace = UUID.randomUUID().toString().replace("-", "");
                sDeviceUUID = replace;
                writeUUIDToFile(file, replace);
            }
            return sDeviceUUID;
        }
    }

    public static String getElectricUsageRatio() {
        if (sAppContext == null) {
            return "0";
        }
        try {
            Intent registerReceiver = sAppContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            return String.valueOf((int) (((registerReceiver != null ? registerReceiver.getIntExtra(PermissionConstant.level, -1) : -1) / (registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1)) * 100.0f));
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static String getGPUInfo() {
        return "";
    }

    public static String getMemoryTotal() {
        try {
            Context context = sAppContext;
            if (context == null) {
                return "0";
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return ((int) (((float) memoryInfo.totalMem) / 1048576.0f)) + "";
        } catch (Exception unused) {
            return "0";
        }
    }

    public static String getMemoryUsage() {
        if (((ActivityManager) sAppContext.getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()}).length == 0) {
            return "0";
        }
        return (r0[0].getTotalPss() / 1024.0f) + "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x002d. Please report as an issue. */
    public static String getNetworkType() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) sAppContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "NoActive";
            }
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (activeNetworkInfo.getType() == 1) {
                return NetworkUtil.NETWORK_TYPE_WIFI;
            }
            if (activeNetworkInfo.getType() != 0) {
                return subtypeName;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return NetworkUtil.NETWORK_TYPE_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return NetworkUtil.NETWORK_TYPE_3G;
                case 13:
                    return NetworkUtil.NETWORK_TYPE_4G;
                default:
                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                        return "Mobile:" + subtypeName;
                    }
                    return NetworkUtil.NETWORK_TYPE_3G;
            }
        } catch (Exception unused) {
            return "Unknow";
        }
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getOpenGLVersion() {
        ConfigurationInfo deviceConfigurationInfo;
        Context context = sAppContext;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
                return null;
            }
            return Integer.toHexString(Integer.parseInt(deviceConfigurationInfo.reqGlEsVersion + ""));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Context getSDKContext() {
        return sAppContext;
    }

    public static String getSDKVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getTerminalType() {
        try {
            Context context = sAppContext;
            return (context == null || context.getResources() == null || sAppContext.getResources().getConfiguration() == null) ? "phone" : (sAppContext.getResources().getConfiguration().screenLayout & 15) >= 3 ? "pad" : "phone";
        } catch (Throwable unused) {
            return "phone";
        }
    }

    private static String getUIModeType() throws Exception {
        int currentModeType = ((UiModeManager) sAppContext.getSystemService("uimode")).getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 2 ? currentModeType != 3 ? currentModeType != 4 ? currentModeType != 6 ? currentModeType != 7 ? currentModeType != 15 ? "UNDEFINED" : "MASK" : "VR_HEADSET" : "WATCH" : "TELEVISION" : "CAR" : "DESK" : "NORMAL";
    }

    public static void loadClass() {
    }

    @NativeUsed
    private static String native_getDeviceInfo(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2133529830:
                if (str.equals("device_manufacturer")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1628011446:
                if (str.equals("cpu_usage")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1453464803:
                if (str.equals("terminal_type")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1287148950:
                if (str.equals("application_id")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1182845946:
                if (str.equals("os_name")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1117382559:
                if (str.equals("gpu_info")) {
                    c11 = 5;
                    break;
                }
                break;
            case -1010275000:
                if (str.equals("opengl_version")) {
                    c11 = 6;
                    break;
                }
                break;
            case -977897239:
                if (str.equals("application_version")) {
                    c11 = 7;
                    break;
                }
                break;
            case -902394881:
                if (str.equals("electric_usage")) {
                    c11 = '\b';
                    break;
                }
                break;
            case -601148322:
                if (str.equals("device_brand")) {
                    c11 = '\t';
                    break;
                }
                break;
            case -591076352:
                if (str.equals("device_model")) {
                    c11 = '\n';
                    break;
                }
                break;
            case -553266608:
                if (str.equals("cache_dir")) {
                    c11 = 11;
                    break;
                }
                break;
            case -379364393:
                if (str.equals("can_get_context")) {
                    c11 = '\f';
                    break;
                }
                break;
            case -19457365:
                if (str.equals("network_type")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 589850:
                if (str.equals("application_name")) {
                    c11 = 14;
                    break;
                }
                break;
            case 3601339:
                if (str.equals("uuid")) {
                    c11 = 15;
                    break;
                }
                break;
            case 216651451:
                if (str.equals("cpu_processor")) {
                    c11 = 16;
                    break;
                }
                break;
            case 501310693:
                if (str.equals("cpu_info")) {
                    c11 = 17;
                    break;
                }
                break;
            case 672836989:
                if (str.equals("os_version")) {
                    c11 = 18;
                    break;
                }
                break;
            case 1000114701:
                if (str.equals("device_feature")) {
                    c11 = 19;
                    break;
                }
                break;
            case 1270116442:
                if (str.equals("mem_total")) {
                    c11 = 20;
                    break;
                }
                break;
            case 1271141047:
                if (str.equals("mem_usage")) {
                    c11 = 21;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return getDeviceManufacturer();
            case 1:
                return getCPUUsageRatio();
            case 2:
                return getTerminalType();
            case 3:
                return getSDKContext().getPackageName();
            case 4:
                return "android";
            case 5:
                return getGPUInfo();
            case 6:
                return getOpenGLVersion();
            case 7:
                return getApplicationVersion();
            case '\b':
                return getElectricUsageRatio();
            case '\t':
                return getDeviceBrand();
            case '\n':
                return getDeviceModel();
            case 11:
                return getCacheDir();
            case '\f':
                return canGetContext();
            case '\r':
                return getNetworkType();
            case 14:
                return getApplicationName();
            case 15:
                return getDeviceUUID();
            case 16:
                return getCPUProcessorInfo();
            case 17:
                return getCPUInfo();
            case 18:
                return getOSVersion();
            case 19:
                return getDeviceFeature();
            case 20:
                return getMemoryTotal();
            case 21:
                return getMemoryUsage();
            default:
                return "";
        }
    }

    private static void putFeature(JSONObject jSONObject, String str) {
        try {
            jSONObject.put(str, sAppContext.getPackageManager().hasSystemFeature(str) ? "1" : "0");
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void requestCPUInfo() {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5d
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5d
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L56
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L56
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r3 = 0
            r4 = r3
        L13:
            r5 = 1
            int r4 = r4 + r5
            r6 = 30
            if (r4 < r6) goto L1a
            goto L3f
        L1a:
            java.lang.String r6 = ":\\s+"
            r7 = 2
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            int r6 = r0.length     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r6 <= r5) goto L37
            r6 = r0[r3]     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            java.lang.String r7 = "Processor"
            boolean r6 = r6.contains(r7)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r6 == 0) goto L37
            r0 = r0[r5]     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            com.aliyun.utils.DeviceInfoUtils.sCpuProcessorInfo = r0     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            goto L37
        L33:
            r0 = move-exception
            goto L5f
        L35:
            r0 = r1
            goto L6a
        L37:
            java.lang.String r0 = com.aliyun.utils.DeviceInfoUtils.sCpuProcessorInfo     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r0 != 0) goto L4c
        L3f:
            r1.close()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35 java.io.IOException -> L42
        L42:
            r2.close()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35 java.io.IOException -> L45
        L45:
            r1.close()     // Catch: java.io.IOException -> L48
        L48:
            r2.close()     // Catch: java.io.IOException -> L72
            goto L72
        L4c:
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            goto L13
        L51:
            r2 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
            goto L5f
        L56:
            r2 = r0
            goto L35
        L58:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L5f
        L5d:
            r2 = r0
            goto L6a
        L5f:
            if (r1 == 0) goto L64
            r1.close()     // Catch: java.io.IOException -> L64
        L64:
            if (r2 == 0) goto L69
            r2.close()     // Catch: java.io.IOException -> L69
        L69:
            throw r0
        L6a:
            if (r0 == 0) goto L6f
            r0.close()     // Catch: java.io.IOException -> L6f
        L6f:
            if (r2 == 0) goto L72
            goto L48
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.utils.DeviceInfoUtils.requestCPUInfo():void");
    }

    public static void setSDKContext(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        sAppContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeUUIDToFile(final File file, final String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        new Timer().schedule(new TimerTask() { // from class: com.aliyun.utils.DeviceInfoUtils.1
            /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0001, B:5:0x000a, B:9:0x0016, B:11:0x0024), top: B:2:0x0001 }] */
            @Override // java.util.TimerTask, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r6 = this;
                    r0 = 0
                    java.io.File r1 = r1     // Catch: java.lang.Throwable -> L33
                    boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L33
                    r2 = 1
                    if (r1 != 0) goto L15
                    java.io.File r1 = r1     // Catch: java.lang.Throwable -> L33
                    boolean r1 = r1.createNewFile()     // Catch: java.lang.Throwable -> L33
                    if (r1 == 0) goto L13
                    goto L15
                L13:
                    r1 = r0
                    goto L16
                L15:
                    r1 = r2
                L16:
                    java.util.Properties r3 = new java.util.Properties     // Catch: java.lang.Throwable -> L33
                    r3.<init>()     // Catch: java.lang.Throwable -> L33
                    java.lang.String r4 = "UUID"
                    java.lang.String r5 = r2     // Catch: java.lang.Throwable -> L33
                    r3.setProperty(r4, r5)     // Catch: java.lang.Throwable -> L33
                    if (r1 == 0) goto L33
                    java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L33
                    java.io.File r4 = r1     // Catch: java.lang.Throwable -> L33
                    r1.<init>(r4)     // Catch: java.lang.Throwable -> L33
                    r4 = 0
                    r3.store(r1, r4)     // Catch: java.lang.Throwable -> L33
                    r1.close()     // Catch: java.lang.Throwable -> L33
                    r0 = r2
                L33:
                    com.aliyun.utils.DeviceInfoUtils.access$008()
                    if (r0 != 0) goto L47
                    int r0 = com.aliyun.utils.DeviceInfoUtils.access$000()
                    r1 = 10
                    if (r0 >= r1) goto L47
                    java.io.File r0 = r1
                    java.lang.String r1 = r2
                    com.aliyun.utils.DeviceInfoUtils.access$100(r0, r1)
                L47:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.aliyun.utils.DeviceInfoUtils.AnonymousClass1.run():void");
            }
        }, 3000L);
    }
}
