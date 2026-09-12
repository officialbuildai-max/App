package com.tencent.tinker.loader;

import android.app.Application;
import android.os.Build;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class SystemClassLoaderAdder {
    private static int sPatchDexCount;

    /* loaded from: classes5.dex */
    private static final class ArkHot {
        private ArkHot() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException, ClassNotFoundException, SecurityException {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().getParent().loadClass("com.huawei.ark.classloader.ExtendedClassLoaderHelper");
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                String canonicalPath = it.next().getCanonicalPath();
                Method declaredMethod = loadClass.getDeclaredMethod("applyPatch", ClassLoader.class, String.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, classLoader, canonicalPath);
                ShareTinkerLog.i("Tinker.ClassLoaderAdder", "ArkHot install path = " + canonicalPath, new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class V14 {
        private V14() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class V19 {
        private V19() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Method findMethod;
            try {
                findMethod = ShareReflectUtil.findMethod(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class});
            } catch (NoSuchMethodException unused) {
                ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure", new Object[0]);
                try {
                    findMethod = ShareReflectUtil.findMethod(obj, "makeDexElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
                } catch (NoSuchMethodException e11) {
                    ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makeDexElements(List,File,List) failure", new Object[0]);
                    throw e11;
                }
            }
            return (Object[]) findMethod.invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class V23 {
        private V23() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            Object obj = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.expandFieldArray(obj, "dexElements", makePathElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    ShareTinkerLog.w("Tinker.ClassLoaderAdder", "Exception in makePathElement", iOException);
                    throw iOException;
                }
            }
        }

        private static Object[] makePathElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Method findMethod;
            try {
                findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
            } catch (NoSuchMethodException unused) {
                ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makePathElements(List,File,List) failure", new Object[0]);
                try {
                    findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class});
                } catch (NoSuchMethodException unused2) {
                    ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure", new Object[0]);
                    try {
                        ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: try use v19 instead", new Object[0]);
                        return V19.makeDexElements(obj, arrayList, file, arrayList2);
                    } catch (NoSuchMethodException e11) {
                        ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makeDexElements(List,File,List) failure", new Object[0]);
                        throw e11;
                    }
                }
            }
            return (Object[]) findMethod.invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* loaded from: classes5.dex */
    private static final class V4 {
        private V4() {
        }
    }

    private static boolean checkDexInstall(ClassLoader classLoader) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> cls = Class.forName("com.tencent.tinker.loader.TinkerTestDexLoad", true, classLoader);
        Boolean bool = (Boolean) ShareReflectUtil.findField(cls, "isPatch").get(null);
        boolean booleanValue = bool.booleanValue();
        ShareTinkerLog.i("Tinker.ClassLoaderAdder", "checkDexInstall result: %s, checker_classloader: %s", bool, cls.getClassLoader());
        return booleanValue;
    }

    private static List<File> createSortedAdditionalPathEntries(List<File> list) {
        ArrayList arrayList = new ArrayList(list);
        final HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String name = ((File) it.next()).getName();
            hashMap.put(name, Boolean.valueOf(ShareConstants.CLASS_N_PATTERN.matcher(name).matches()));
        }
        Collections.sort(arrayList, new Comparator<File>() { // from class: com.tencent.tinker.loader.SystemClassLoaderAdder.1
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                if (file == null && file2 == null) {
                    return 0;
                }
                if (file == null) {
                    return -1;
                }
                if (file2 == null) {
                    return 1;
                }
                String name2 = file.getName();
                String name3 = file2.getName();
                if (name2.equals(name3)) {
                    return 0;
                }
                if (name2.startsWith("test.dex")) {
                    return 1;
                }
                if (name3.startsWith("test.dex")) {
                    return -1;
                }
                boolean booleanValue = ((Boolean) hashMap.get(name2)).booleanValue();
                boolean booleanValue2 = ((Boolean) hashMap.get(name3)).booleanValue();
                if (!booleanValue || !booleanValue2) {
                    if (booleanValue) {
                        return -1;
                    }
                    if (booleanValue2) {
                        return 1;
                    }
                    return name2.compareTo(name3);
                }
                int indexOf = name2.indexOf(46);
                int indexOf2 = name3.indexOf(46);
                int parseInt = indexOf > 7 ? Integer.parseInt(name2.substring(7, indexOf)) : 1;
                int parseInt2 = indexOf2 > 7 ? Integer.parseInt(name3.substring(7, indexOf2)) : 1;
                if (parseInt == parseInt2) {
                    return 0;
                }
                return parseInt < parseInt2 ? -1 : 1;
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void injectDexesInternal(ClassLoader classLoader, List<File> list, File file) throws Throwable {
        V23.install(classLoader, list, file);
    }

    public static void installApk(PathClassLoader pathClassLoader, List<File> list) throws Throwable {
        if (list.isEmpty()) {
            return;
        }
        List<File> createSortedAdditionalPathEntries = createSortedAdditionalPathEntries(list);
        ArkHot.install(pathClassLoader, createSortedAdditionalPathEntries);
        sPatchDexCount = createSortedAdditionalPathEntries.size();
        ShareTinkerLog.i("Tinker.ClassLoaderAdder", "after loaded classloader: " + pathClassLoader + ", dex size:" + sPatchDexCount, new Object[0]);
        checkDexInstall(pathClassLoader);
    }

    public static void installDexes(Application application, ClassLoader classLoader, File file, List<File> list, boolean z10, boolean z11) throws Throwable {
        ShareTinkerLog.i("Tinker.ClassLoaderAdder", "installDexes dexOptDir: " + file.getAbsolutePath() + ", dex size:" + list.size(), new Object[0]);
        if (list.isEmpty()) {
            return;
        }
        List<File> createSortedAdditionalPathEntries = createSortedAdditionalPathEntries(list);
        if (Build.VERSION.SDK_INT < 24 || z10) {
            injectDexesInternal(classLoader, createSortedAdditionalPathEntries, file);
        } else {
            classLoader = NewClassLoaderInjector.inject(application, classLoader, file, z11, createSortedAdditionalPathEntries);
        }
        sPatchDexCount = createSortedAdditionalPathEntries.size();
        ShareTinkerLog.i("Tinker.ClassLoaderAdder", "after loaded classloader: " + classLoader + ", dex size:" + sPatchDexCount, new Object[0]);
        if (checkDexInstall(classLoader)) {
            return;
        }
        uninstallPatchDex(classLoader);
        throw new TinkerRuntimeException("checkDexInstall failed");
    }

    public static void uninstallPatchDex(ClassLoader classLoader) throws Throwable {
        if (sPatchDexCount <= 0) {
            return;
        }
        ShareReflectUtil.reduceFieldArray(ShareReflectUtil.findField(classLoader, "pathList").get(classLoader), "dexElements", sPatchDexCount);
    }
}
