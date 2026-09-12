package com.cloud.tmc.miniutils.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.cloud.tmc.miniutils.util.Utils;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class UtilsBridge {
    private static final String TAG = "UtilsBridge";
    private static Handler mainHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    static final class FileHead {
        private LinkedHashMap<String, String> mFirst = new LinkedHashMap<>();
        private LinkedHashMap<String, String> mLast = new LinkedHashMap<>();
        private String mName;

        FileHead(String str) {
            this.mName = str;
        }

        private void append2Host(Map<String, String> map, String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            int length = 19 - str.length();
            if (length > 0) {
                str = str + "                   ".substring(0, length);
            }
            map.put(str, str2);
        }

        private void append2Host(Map<String, String> map, Map<String, String> map2) {
            if (map2 == null || map2.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                append2Host(map, entry.getKey(), entry.getValue());
            }
        }

        @Deprecated
        static Uri file2Uri(File file) {
            return UriUtils.file2Uri(file);
        }

        void addFirst(String str, String str2) {
            append2Host(this.mFirst, str, str2);
        }

        void append(String str, String str2) {
            append2Host(this.mLast, str, str2);
        }

        void append(Map<String, String> map) {
            append2Host(this.mLast, map);
        }

        public String getAppended() {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, String> entry : this.mLast.entrySet()) {
                sb2.append(entry.getKey());
                sb2.append(": ");
                sb2.append(entry.getValue());
                sb2.append("\n");
            }
            return sb2.toString();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = "************* " + this.mName + " Head ****************\n";
            sb2.append(str);
            for (Map.Entry<String, String> entry : this.mFirst.entrySet()) {
                sb2.append(entry.getKey());
                sb2.append(": ");
                sb2.append(entry.getValue());
                sb2.append("\n");
            }
            sb2.append("Device Manufacturer: ");
            sb2.append(Build.MANUFACTURER);
            sb2.append("\n");
            sb2.append("Device Model       : ");
            sb2.append(Build.MODEL);
            sb2.append("\n");
            sb2.append("Android Version    : ");
            sb2.append(Build.VERSION.RELEASE);
            sb2.append("\n");
            sb2.append("Android SDK        : ");
            sb2.append(Build.VERSION.SDK_INT);
            sb2.append("\n");
            sb2.append("App VersionName    : ");
            sb2.append(AppUtils.getAppVersionName());
            sb2.append("\n");
            sb2.append("App VersionCode    : ");
            sb2.append(AppUtils.getAppVersionCode());
            sb2.append("\n");
            sb2.append(getAppended());
            sb2.append(str);
            sb2.append("\n");
            return sb2.toString();
        }
    }

    UtilsBridge() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        UtilsActivityLifecycleImpl.INSTANCE.addOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] base64Decode(byte[] bArr) {
        return EncodeUtils.base64Decode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] base64Encode(byte[] bArr) {
        return EncodeUtils.base64Encode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        return ImageUtils.bitmap2Bytes(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i11) {
        return ImageUtils.bitmap2Bytes(bitmap, compressFormat, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable bitmap2Drawable(Bitmap bitmap) {
        return ImageUtils.bitmap2Drawable(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String byte2FitMemorySize(long j11) {
        return ConvertUtils.byte2FitMemorySize(j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap bytes2Bitmap(byte[] bArr) {
        return ImageUtils.bytes2Bitmap(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable bytes2Drawable(byte[] bArr) {
        return ImageUtils.bytes2Drawable(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String bytes2HexString(byte[] bArr) {
        return ConvertUtils.bytes2HexString(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean createFileByDeleteOldFile(File file) {
        return FileUtils.createFileByDeleteOldFile(file);
    }

    static boolean createOrExistsDir(File file) {
        return FileUtils.createOrExistsDir(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean createOrExistsFile(File file) {
        return FileUtils.createOrExistsFile(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean deleteAllInDir(File file) {
        return FileUtils.deleteAllInDir(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dp2px(float f11) {
        return SizeUtils.dp2px(f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap drawable2Bitmap(Drawable drawable) {
        return ImageUtils.drawable2Bitmap(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] drawable2Bytes(Drawable drawable) {
        return ImageUtils.drawable2Bytes(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat, int i11) {
        return ImageUtils.drawable2Bytes(drawable, compressFormat, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        return StringUtils.equals(charSequence, charSequence2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void finishAllActivities() {
        ActivityUtils.finishAllActivities();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fixSoftInputLeaks(Activity activity) {
        KeyboardUtils.fixSoftInputLeaks(activity);
    }

    static String format(@Nullable String str, Object... objArr) {
        return StringUtils.format(str, objArr);
    }

    static <T> T fromJson(String str, Type type) {
        return (T) GsonUtils.fromJson(str, type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Activity getActivityByContext(Context context) {
        return ActivityUtils.getActivityByContext(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Activity> getActivityList() {
        return UtilsActivityLifecycleImpl.INSTANCE.getActivityList();
    }

    static int getAppScreenWidth() {
        return ScreenUtils.getAppScreenWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Application getApplicationByReflect() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return UtilsActivityLifecycleImpl.INSTANCE.getApplicationByReflect();
        }
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cloud.tmc.miniutils.util.n
                @Override // java.lang.Runnable
                public final void run() {
                    UtilsBridge.lambda$getApplicationByReflect$0(atomicReference, countDownLatch);
                }
            });
            if (countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                Log.e(TAG, "getApplicationByReflect: get app by reflection");
                return (Application) atomicReference.get();
            }
        } catch (InterruptedException e11) {
            Log.e(TAG, "getApplicationByReflect: ", e11);
            Thread.currentThread().interrupt();
        } catch (Throwable th2) {
            Log.e(TAG, "getApplicationByReflect: ", th2);
        }
        return (Application) atomicReference.get();
    }

    static Intent getDialIntent(String str) {
        return IntentUtils.getDialIntent(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File getFileByPath(String str) {
        return FileUtils.getFileByPath(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getFsAvailableSize(String str) {
        return FileUtils.getFsAvailableSize(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getFsTotalSize(String str) {
        return FileUtils.getFsTotalSize(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getInstallAppIntent(Uri uri) {
        return IntentUtils.getInstallAppIntent(uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getInstallAppIntent(File file) {
        return IntentUtils.getInstallAppIntent(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getLaunchAppDetailsSettingsIntent(String str, boolean z10) {
        return IntentUtils.getLaunchAppDetailsSettingsIntent(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getLaunchAppIntent(String str) {
        return IntentUtils.getLaunchAppIntent(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getLauncherActivity(String str) {
        return ActivityUtils.getLauncherActivity(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getNavBarHeight() {
        return BarUtils.getNavBarHeight();
    }

    static Intent getSendSmsIntent(String str, String str2) {
        return IntentUtils.getSendSmsIntent(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getStatusBarHeight() {
        return BarUtils.getStatusBarHeight();
    }

    static String getString(int i11) {
        return StringUtils.getString(i11);
    }

    static String getString(int i11, Object... objArr) {
        return StringUtils.getString(i11, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Activity getTopActivity() {
        return UtilsActivityLifecycleImpl.INSTANCE.getTopActivity();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getUninstallAppIntent(String str) {
        return IntentUtils.getUninstallAppIntent(str);
    }

    static byte[] hashTemplate(byte[] bArr, String str) {
        return EncryptUtils.hashTemplate(bArr, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Application application) {
        try {
            if (ProcessUtils.isMiniProcess()) {
                UtilsActivityLifecycleImpl.INSTANCE.init(application);
            }
        } catch (Throwable th2) {
            Log.e(TAG, "init: " + th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] inputStream2Bytes(InputStream inputStream) {
        return ConvertUtils.inputStream2Bytes(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> inputStream2Lines(InputStream inputStream, String str) {
        return ConvertUtils.inputStream2Lines(inputStream, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isActivityAlive(Activity activity) {
        return ActivityUtils.isActivityAlive(activity);
    }

    static boolean isAppDebug() {
        return AppUtils.isAppDebug();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static boolean isAppForeground() {
        return UtilsActivityLifecycleImpl.INSTANCE.isAppForeground();
    }

    static boolean isAppInstalled(String str) {
        return AppUtils.isAppInstalled(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isFileExists(File file) {
        return FileUtils.isFileExists(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isGranted(String... strArr) {
        return PermissionUtils.isGranted(strArr);
    }

    static boolean isGrantedDrawOverlays() {
        return PermissionUtils.isGrantedDrawOverlays();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isIntentAvailable(Intent intent) {
        return IntentUtils.isIntentAvailable(intent);
    }

    static boolean isLayoutRtl() {
        return ViewUtils.isLayoutRtl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSDCardEnableByEnvironment() {
        return SDCardUtils.isSDCardEnableByEnvironment();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSpace(String str) {
        return StringUtils.isSpace(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getApplicationByReflect$0(AtomicReference atomicReference, CountDownLatch countDownLatch) {
        atomicReference.set(UtilsActivityLifecycleImpl.INSTANCE.getApplicationByReflect());
        countDownLatch.countDown();
    }

    static View layoutId2View(int i11) {
        return ViewUtils.layoutId2View(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void notifySystemToScan(File file) {
        FileUtils.notifySystemToScan(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int px2dp(float f11) {
        return SizeUtils.px2dp(f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int px2sp(float f11) {
        return SizeUtils.px2sp(f11);
    }

    static void relaunchApp() {
        AppUtils.relaunchApp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeActivityLifecycleCallbacks(Activity activity) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        UtilsActivityLifecycleImpl.INSTANCE.removeOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void runOnUiThread(Runnable runnable) {
        mainHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void runOnUiThreadDelayed(Runnable runnable, long j11) {
        mainHandler.postDelayed(runnable, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int sp2px(float f11) {
        return SizeUtils.sp2px(f11);
    }

    static void startHomeActivity() {
        ActivityUtils.startHomeActivity();
    }

    static String toJson(Object obj) {
        return GsonUtils.toJson(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unInit(Application application) {
        try {
            if (ProcessUtils.isMiniProcess()) {
                UtilsActivityLifecycleImpl.INSTANCE.unInit(application);
            }
        } catch (Throwable th2) {
            Log.e(TAG, "unInit: " + th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File uri2File(Uri uri) {
        return UriUtils.uri2File(uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap view2Bitmap(View view) {
        return ImageUtils.view2Bitmap(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean writeFileFromIS(String str, InputStream inputStream) {
        return FileIOUtils.writeFileFromIS(str, inputStream);
    }
}
