package com.transsnet.downloader.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsnet.downloader.R$string;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lj.b;

/* loaded from: classes.dex */
public final class DownloadSDCardUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadSDCardUtil f60017a = new DownloadSDCardUtil();

    /* renamed from: b, reason: collision with root package name */
    private static final String f60018b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f60019c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f60020d;

    /* renamed from: e, reason: collision with root package name */
    private static final DownloadSDCardUtil$sdcardBroadcastReceiver$1 f60021e;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.transsnet.downloader.util.DownloadSDCardUtil$sdcardBroadcastReceiver$1] */
    static {
        String string = Utils.a().getString(R$string.sdcard_name);
        Intrinsics.g(string, "getString(...)");
        f60018b = string;
        f60021e = new BroadcastReceiver() { // from class: com.transsnet.downloader.util.DownloadSDCardUtil$sdcardBroadcastReceiver$1
            /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001f. Please report as an issue. */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.h(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    switch (action.hashCode()) {
                        case -1665311200:
                            if (!action.equals("android.intent.action.MEDIA_REMOVED")) {
                                return;
                            }
                            DownloadSDCardUtil.f60017a.d(false);
                            lg.a.f68962a.c("DownloadSDCard", "SD/TF卡已拔出", true);
                            DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent("", "", false, false, 12, null);
                            AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
                            FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                            String name = DownloadRefreshEvent.class.getName();
                            Intrinsics.g(name, "getName(...)");
                            flowEventBus.postEvent(name, downloadRefreshEvent, 0L);
                            my.e eVar = new my.e(true, false);
                            FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                            String name2 = my.e.class.getName();
                            Intrinsics.g(name2, "getName(...)");
                            flowEventBus2.postEvent(name2, eVar, 0L);
                            return;
                        case -1514214344:
                            if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                                DownloadSDCardUtil.f60017a.d(true);
                                lg.a.f68962a.c("DownloadSDCard", "SD/TF卡已插入", true);
                                DownloadRefreshEvent downloadRefreshEvent2 = new DownloadRefreshEvent("", "", false, false, 12, null);
                                AppScopeVMlProvider appScopeVMlProvider2 = AppScopeVMlProvider.INSTANCE;
                                FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
                                String name3 = DownloadRefreshEvent.class.getName();
                                Intrinsics.g(name3, "getName(...)");
                                flowEventBus3.postEvent(name3, downloadRefreshEvent2, 0L);
                                my.e eVar2 = new my.e(true, false);
                                FlowEventBus flowEventBus4 = (FlowEventBus) appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
                                String name4 = my.e.class.getName();
                                Intrinsics.g(name4, "getName(...)");
                                flowEventBus4.postEvent(name4, eVar2, 0L);
                                return;
                            }
                            return;
                        case -963871873:
                            if (!action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
                                return;
                            }
                            DownloadSDCardUtil.f60017a.d(false);
                            lg.a.f68962a.c("DownloadSDCard", "SD/TF卡已拔出", true);
                            DownloadRefreshEvent downloadRefreshEvent3 = new DownloadRefreshEvent("", "", false, false, 12, null);
                            AppScopeVMlProvider appScopeVMlProvider3 = AppScopeVMlProvider.INSTANCE;
                            FlowEventBus flowEventBus5 = (FlowEventBus) appScopeVMlProvider3.getApplicationScopeViewModel(FlowEventBus.class);
                            String name5 = DownloadRefreshEvent.class.getName();
                            Intrinsics.g(name5, "getName(...)");
                            flowEventBus5.postEvent(name5, downloadRefreshEvent3, 0L);
                            my.e eVar3 = new my.e(true, false);
                            FlowEventBus flowEventBus22 = (FlowEventBus) appScopeVMlProvider3.getApplicationScopeViewModel(FlowEventBus.class);
                            String name22 = my.e.class.getName();
                            Intrinsics.g(name22, "getName(...)");
                            flowEventBus22.postEvent(name22, eVar3, 0L);
                            return;
                        case 2045140818:
                            if (!action.equals("android.intent.action.MEDIA_BAD_REMOVAL")) {
                                return;
                            }
                            DownloadSDCardUtil.f60017a.d(false);
                            lg.a.f68962a.c("DownloadSDCard", "SD/TF卡已拔出", true);
                            DownloadRefreshEvent downloadRefreshEvent32 = new DownloadRefreshEvent("", "", false, false, 12, null);
                            AppScopeVMlProvider appScopeVMlProvider32 = AppScopeVMlProvider.INSTANCE;
                            FlowEventBus flowEventBus52 = (FlowEventBus) appScopeVMlProvider32.getApplicationScopeViewModel(FlowEventBus.class);
                            String name52 = DownloadRefreshEvent.class.getName();
                            Intrinsics.g(name52, "getName(...)");
                            flowEventBus52.postEvent(name52, downloadRefreshEvent32, 0L);
                            my.e eVar32 = new my.e(true, false);
                            FlowEventBus flowEventBus222 = (FlowEventBus) appScopeVMlProvider32.getApplicationScopeViewModel(FlowEventBus.class);
                            String name222 = my.e.class.getName();
                            Intrinsics.g(name222, "getName(...)");
                            flowEventBus222.postEvent(name222, eVar32, 0L);
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    private DownloadSDCardUtil() {
    }

    public final List a() {
        List<my.f> b11;
        ArrayList arrayList = new ArrayList();
        try {
            b11 = b();
        } catch (Throwable unused) {
        }
        if (b11.size() < 2) {
            return arrayList;
        }
        String str = "";
        Iterator it = b11.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            my.f fVar = (my.f) it.next();
            if (!fVar.c()) {
                str = fVar.b();
                break;
            }
        }
        if (str.length() == 0) {
            return arrayList;
        }
        int i11 = 0;
        boolean z10 = b11.size() > 2;
        for (my.f fVar2 : b11) {
            if (fVar2.c()) {
                i11++;
                String b12 = fVar2.b();
                String str2 = File.separator;
                b.a aVar = lj.b.f68989a;
                arrayList.add(new my.b(b12 + str2 + aVar.f(), str2 + aVar.f(), z10 ? f60018b + " " + i11 + " " : f60018b, 2, fVar2.a(), 3));
            }
        }
        return arrayList;
    }

    public final List b() {
        List storageVolumes;
        boolean isRemovable;
        boolean isEmulated;
        String state;
        int i11 = 1;
        Object systemService = Utils.a().getSystemService(PlaceTypes.STORAGE);
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
        StorageManager storageManager = (StorageManager) systemService;
        ArrayList arrayList = new ArrayList();
        Object[] objArr = null;
        if (Build.VERSION.SDK_INT >= 24) {
            storageVolumes = storageManager.getStorageVolumes();
            Intrinsics.g(storageVolumes, "getStorageVolumes(...)");
            try {
                Iterator it = storageVolumes.iterator();
                while (it.hasNext()) {
                    StorageVolume a11 = com.cloud.tmc.miniutils.util.i.a(it.next());
                    isRemovable = a11.isRemovable();
                    isEmulated = a11.isEmulated();
                    state = a11.getState();
                    if (isRemovable) {
                        f60020d = true;
                    }
                    try {
                        Class<?> cls = Class.forName(a11.getClass().getName());
                        try {
                            Method declaredMethod = cls.getDeclaredMethod("getPath", null);
                            declaredMethod.setAccessible(true);
                            Object invoke = declaredMethod.invoke(a11, null);
                            Intrinsics.f(invoke, "null cannot be cast to non-null type kotlin.String");
                            Intrinsics.e(state);
                            arrayList.add(new my.f((String) invoke, state, isRemovable, isEmulated));
                        } catch (Throwable unused) {
                            Field declaredField = cls.getDeclaredField("mPath");
                            declaredField.setAccessible(true);
                            Object obj = declaredField.get(a11);
                            if (obj != null) {
                                String obj2 = obj.toString();
                                Intrinsics.e(state);
                                arrayList.add(new my.f(obj2, state, isRemovable, isEmulated));
                            }
                            Unit unit = Unit.f67184a;
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        Unit unit2 = Unit.f67184a;
                    }
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        } else {
            try {
                Class<?> cls2 = Class.forName("android.os.storage.StorageVolume");
                Method method = cls2.getMethod("getPath", null);
                Method method2 = cls2.getMethod("isRemovable", null);
                Method method3 = cls2.getMethod("isEmulated", null);
                Method method4 = StorageManager.class.getMethod("getVolumeState", String.class);
                Object invoke2 = StorageManager.class.getMethod("getVolumeList", null).invoke(storageManager, null);
                int length = Array.getLength(invoke2);
                int i12 = 0;
                while (i12 < length) {
                    Object obj3 = Array.get(invoke2, i12);
                    Object invoke3 = method.invoke(obj3, objArr);
                    Intrinsics.f(invoke3, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) invoke3;
                    Object invoke4 = method2.invoke(obj3, objArr);
                    Intrinsics.f(invoke4, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue = ((Boolean) invoke4).booleanValue();
                    Object invoke5 = method3.invoke(obj3, objArr);
                    Intrinsics.f(invoke5, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue2 = ((Boolean) invoke5).booleanValue();
                    Object[] objArr2 = new Object[i11];
                    objArr2[0] = str;
                    Object invoke6 = method4.invoke(storageManager, objArr2);
                    Intrinsics.f(invoke6, "null cannot be cast to non-null type kotlin.String");
                    arrayList.add(new my.f(str, (String) invoke6, booleanValue, booleanValue2));
                    i12++;
                    i11 = 1;
                    objArr = null;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
        return arrayList;
    }

    public final void c() {
        if (f60019c) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter.addDataScheme(OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_FILE);
        if (Build.VERSION.SDK_INT >= 33) {
            Utils.a().registerReceiver(f60021e, intentFilter, 2);
        } else {
            Utils.a().registerReceiver(f60021e, intentFilter);
        }
        f60019c = true;
    }

    public final void d(boolean z10) {
        f60020d = z10;
    }

    public final void e() {
        try {
            if (f60019c) {
                f60019c = false;
                Utils.a().unregisterReceiver(f60021e);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
