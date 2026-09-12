package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.storage.TmcStorage;
import com.cloud.tmc.storage.impl.IStorage;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J%\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J%\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u000eJ\"\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J(\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J(\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J(\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J(\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J \u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006!"}, d2 = {"Lcom/cloud/tmc/integration/defaultImpl/TmcKVStorageImpl;", "Lcom/cloud/tmc/kernel/proxy/storage/KVStorageProxy;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clear", "", "context", "Landroid/content/Context;", "appId", "getAllKeys", "", "(Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/String;", "getBoolean", "", "key", "defaultValue", "getInt", "", "getKVSize", "", "getLong", "getMMKVFileAllKeys", "getString", "putBoolean", AppMeasurementSdk.ConditionalUserProperty.VALUE, "putInt", "putLong", "putString", "remove", "warmUpMMKVFile", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TmcKVStorageImpl implements KVStorageProxy {
    private final String TAG = "TmcKVStorageImpl";

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void clear(Context context, String appId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        new TmcStorage(context, appId, true, null, 8, null).clearAll();
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public String[] getAllKeys(Context context, String appId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        return new TmcStorage(context, appId, true, null, 8, null).getKv().a();
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public boolean getBoolean(Context context, String appId, String key, boolean defaultValue) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(key, "key");
        return new TmcStorage(context, appId, true, null, 8, null).getBoolean(key, defaultValue);
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public int getInt(Context context, String appId, String key) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(key, "key");
        return IStorage.DefaultImpls.getInt$default(new TmcStorage(context, appId, true, null, 8, null), key, 0, 2, null);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:489)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkArrayForEach(LoopRegionVisitor.java:230)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkForIndexedLoop(LoopRegionVisitor.java:144)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:81)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:65)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:55)
        */
    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public long getKVSize(android.content.Context r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.h(r11, r0)
            java.lang.String r0 = "appId"
            kotlin.jvm.internal.Intrinsics.h(r12, r0)
            r0 = 0
            com.cloud.tmc.storage.TmcStorage r9 = new com.cloud.tmc.storage.TmcStorage     // Catch: java.lang.Throwable -> L33
            r7 = 8
            r8 = 0
            r5 = 1
            r6 = 0
            r2 = r9
            r3 = r11
            r4 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L33
            com.tencent.mmkv.MMKV r11 = r9.getKv()     // Catch: java.lang.Throwable -> L33
            java.lang.String[] r12 = r11.a()     // Catch: java.lang.Throwable -> L33
            if (r12 == 0) goto L3c
            int r2 = r12.length     // Catch: java.lang.Throwable -> L33
            r3 = 0
            r4 = r0
        L26:
            if (r3 >= r2) goto L35
            r6 = r12[r3]     // Catch: java.lang.Throwable -> L33
            int r6 = r11.B(r6)     // Catch: java.lang.Throwable -> L33
            long r6 = (long) r6
            long r4 = r4 + r6
            int r3 = r3 + 1
            goto L26
        L33:
            r11 = move-exception
            goto L37
        L35:
            r0 = r4
            goto L3c
        L37:
            java.lang.String r12 = "TmcKVStorageImpl"
            com.cloud.tmc.kernel.log.TmcLogger.e(r12, r11)
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.defaultImpl.TmcKVStorageImpl.getKVSize(android.content.Context, java.lang.String):long");
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public long getLong(Context context, String appId, String key) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(key, "key");
        return IStorage.DefaultImpls.getLong$default(new TmcStorage(context, appId, true, null, 8, null), key, 0L, 2, null);
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public String[] getMMKVFileAllKeys(Context context, String appId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        try {
            return new TmcStorage(context, appId, true, null, 8, null).getKv().a();
        } catch (Throwable th2) {
            TmcLogger.e("TmcKVStorageImpl", th2);
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public String getString(Context context, String appId, String key) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(key, "key");
        return IStorage.DefaultImpls.getString$default(new TmcStorage(context, appId, true, null, 8, null), key, null, 2, null);
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void putBoolean(Context context, String appId, String key, boolean value) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(key, "key");
        try {
            new TmcStorage(context, appId, true, null, 8, null).putBoolean(key, value);
        } catch (Throwable th2) {
            TmcLogger.e(this.TAG, th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void putInt(Context context, String appId, String key, int value) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(key, "key");
        try {
            new TmcStorage(context, appId, true, null, 8, null).putInt(key, value);
        } catch (Throwable th2) {
            TmcLogger.e(this.TAG, th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void putLong(Context context, String appId, String key, long value) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(key, "key");
        try {
            new TmcStorage(context, appId, true, null, 8, null).putLong(key, value);
        } catch (Throwable th2) {
            TmcLogger.e(this.TAG, th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void putString(Context context, String appId, String key, String value) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        try {
            new TmcStorage(context, appId, true, null, 8, null).putString(key, value);
        } catch (Throwable th2) {
            TmcLogger.e(this.TAG, th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void remove(Context context, String appId, String key) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(key, "key");
        try {
            new TmcStorage(context, appId, true, null, 8, null).removeKey(key);
        } catch (Throwable unused) {
            TmcLogger.e(this.TAG);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.storage.KVStorageProxy
    public void warmUpMMKVFile(Context context, String appId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        try {
            new TmcStorage(context, appId, true, null, 8, null);
        } catch (Throwable th2) {
            TmcLogger.e("warmUpMMKVFile error: " + th2.getMessage());
        }
    }
}
