package com.bytedance.sdk.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class Sj {
    private static ArrayMap<File, Sj> Fmk;
    protected static InterfaceC0224Sj Sj;

    /* renamed from: aa, reason: collision with root package name */
    private static ArrayMap<String, File> f20948aa;
    private static boolean sP;
    private long Dq;
    private final Object EjP;
    private Properties HiB;
    private int Jcg;
    private final File TEQ;
    private final Object TKC;
    private final File Ym;
    private long uA;
    private volatile boolean vS;

    /* renamed from: com.bytedance.sdk.component.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0224Sj {
        ExecutorService getExecutorService();

        HandlerThread getSafeHandlerThread(String str, int i11);
    }

    /* loaded from: classes2.dex */
    public class TKC implements SharedPreferences.Editor {
        private final Object sP = new Object();
        private final Map<String, Object> TKC = new HashMap();
        private boolean EjP = false;

        public TKC() {
        }

        private sP sP() {
            Properties properties;
            long j11;
            Object obj;
            boolean z10;
            synchronized (Sj.this.TKC) {
                try {
                    if (Sj.this.Jcg > 0) {
                        Properties properties2 = new Properties();
                        properties2.putAll(Sj.this.HiB);
                        Sj.this.HiB = properties2;
                    }
                    properties = Sj.this.HiB;
                    Sj.HiB(Sj.this);
                    synchronized (this.sP) {
                        try {
                            boolean z11 = false;
                            if (this.EjP) {
                                if (properties.isEmpty()) {
                                    z10 = false;
                                } else {
                                    properties.clear();
                                    z10 = true;
                                }
                                this.EjP = false;
                                z11 = z10;
                            }
                            for (Map.Entry<String, Object> entry : this.TKC.entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                if (value != this && value != null) {
                                    if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(String.valueOf(value))) {
                                        properties.put(key, String.valueOf(value));
                                        z11 = true;
                                    }
                                }
                                if (properties.containsKey(key)) {
                                    properties.remove(key);
                                    z11 = true;
                                }
                            }
                            this.TKC.clear();
                            if (z11) {
                                Sj.vS(Sj.this);
                            }
                            j11 = Sj.this.Dq;
                        } finally {
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return new sP(j11, properties);
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC clear() {
            synchronized (this.sP) {
                this.EjP = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC remove(String str) {
            synchronized (this.sP) {
                this.TKC.put(str, this);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC putFloat(String str, float f11) {
            synchronized (this.sP) {
                this.TKC.put(str, Float.valueOf(f11));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC putInt(String str, int i11) {
            synchronized (this.sP) {
                this.TKC.put(str, Integer.valueOf(i11));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC putLong(String str, long j11) {
            synchronized (this.sP) {
                this.TKC.put(str, Long.valueOf(j11));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC putString(String str, String str2) {
            synchronized (this.sP) {
                this.TKC.put(str, str2);
            }
            return this;
        }

        public TKC Sj(String str, Set<String> set) {
            synchronized (this.sP) {
                this.TKC.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public TKC putBoolean(String str, boolean z10) {
            synchronized (this.sP) {
                this.TKC.put(str, Boolean.valueOf(z10));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            Sj.this.Sj(sP(), false);
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            long currentTimeMillis = Sj.sP ? System.currentTimeMillis() : 0L;
            sP sP = sP();
            Sj.this.Sj(sP, true);
            try {
                sP.TKC.await();
                if (Sj.sP) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Sj.this.TEQ.getName());
                    sb2.append(":");
                    sb2.append(sP.Sj);
                    sb2.append(" committed after ");
                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                    sb2.append(" ms");
                }
                return sP.EjP;
            } catch (InterruptedException unused) {
                if (!Sj.sP) {
                    return false;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Sj.this.TEQ.getName());
                sb3.append(":");
                sb3.append(sP.Sj);
                sb3.append(" committed after ");
                sb3.append(System.currentTimeMillis() - currentTimeMillis);
                sb3.append(" ms");
                return false;
            } catch (Throwable th2) {
                if (Sj.sP) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(Sj.this.TEQ.getName());
                    sb4.append(":");
                    sb4.append(sP.Sj);
                    sb4.append(" committed after ");
                    sb4.append(System.currentTimeMillis() - currentTimeMillis);
                    sb4.append(" ms");
                }
                throw th2;
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public /* synthetic */ SharedPreferences.Editor putStringSet(String str, Set set) {
            return Sj(str, (Set<String>) set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class sP {
        volatile boolean EjP;
        boolean HiB;
        final long Sj;
        final CountDownLatch TKC;
        final Properties sP;

        private sP(long j11, Properties properties) {
            this.TKC = new CountDownLatch(1);
            this.EjP = false;
            this.HiB = false;
            this.Sj = j11;
            this.sP = properties;
        }

        void Sj(boolean z10, boolean z11) {
            this.HiB = z10;
            this.EjP = z11;
            this.TKC.countDown();
        }
    }

    private Sj(File file) {
        Object obj = new Object();
        this.TKC = obj;
        this.EjP = new Object();
        this.HiB = new Properties();
        this.vS = false;
        this.Jcg = 0;
        this.TEQ = file;
        this.Ym = Sj(file);
        synchronized (obj) {
            this.vS = false;
        }
        InterfaceC0224Sj interfaceC0224Sj = Sj;
        if (interfaceC0224Sj == null || interfaceC0224Sj.getExecutorService() == null) {
            new Thread("TTPropHelper") { // from class: com.bytedance.sdk.component.Sj.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Sj.this.Sj();
                }
            }.start();
        } else {
            Sj.getExecutorService().execute(new Runnable() { // from class: com.bytedance.sdk.component.Sj.2
                @Override // java.lang.Runnable
                public void run() {
                    Sj.this.Sj();
                }
            });
        }
    }

    private void EjP() {
        while (!this.vS) {
            try {
                this.TKC.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    static /* synthetic */ int HiB(Sj sj2) {
        int i11 = sj2.Jcg;
        sj2.Jcg = i11 + 1;
        return i11;
    }

    public static Sj Sj(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_prop";
        }
        synchronized (Sj.class) {
            try {
                if (f20948aa == null) {
                    f20948aa = new ArrayMap<>();
                }
                File file = f20948aa.get(str);
                if (file == null) {
                    file = new File(context.getFilesDir(), str);
                    f20948aa.put(str, file);
                }
                if (Fmk == null) {
                    Fmk = new ArrayMap<>();
                }
                Sj sj2 = Fmk.get(file);
                if (sj2 != null) {
                    return sj2;
                }
                Sj sj3 = new Sj(file);
                Fmk.put(file, sj3);
                return sj3;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    static File Sj(File file) {
        return new File(file.getPath() + ".bak");
    }

    public static void Sj(InterfaceC0224Sj interfaceC0224Sj) {
        Sj = interfaceC0224Sj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(final sP sPVar, final boolean z10) {
        boolean z11;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.Sj.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (Sj.this.EjP) {
                    try {
                        Sj.this.sP(sPVar, z10);
                    } catch (OutOfMemoryError unused) {
                    }
                }
                synchronized (Sj.this.TKC) {
                    Sj.uA(Sj.this);
                }
            }
        };
        if (z10) {
            synchronized (this.TKC) {
                z11 = this.Jcg == 1;
            }
            if (z11) {
                runnable.run();
                return;
            }
        }
        com.bytedance.sdk.component.sP.Sj(runnable, true ^ z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0118 A[Catch: all -> 0x011d, TryCatch #9 {all -> 0x011d, blocks: (B:38:0x0090, B:39:0x0092, B:107:0x0181, B:108:0x0182, B:56:0x0114, B:58:0x0118, B:59:0x0121, B:61:0x012a, B:62:0x0132, B:64:0x013e, B:54:0x00de, B:73:0x00e4, B:55:0x0113, B:83:0x010a, B:96:0x0180, B:95:0x0177), top: B:37:0x0090, inners: #2, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012a A[Catch: all -> 0x011d, TryCatch #9 {all -> 0x011d, blocks: (B:38:0x0090, B:39:0x0092, B:107:0x0181, B:108:0x0182, B:56:0x0114, B:58:0x0118, B:59:0x0121, B:61:0x012a, B:62:0x0132, B:64:0x013e, B:54:0x00de, B:73:0x00e4, B:55:0x0113, B:83:0x010a, B:96:0x0180, B:95:0x0177), top: B:37:0x0090, inners: #2, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013e A[Catch: all -> 0x011d, TRY_LEAVE, TryCatch #9 {all -> 0x011d, blocks: (B:38:0x0090, B:39:0x0092, B:107:0x0181, B:108:0x0182, B:56:0x0114, B:58:0x0118, B:59:0x0121, B:61:0x012a, B:62:0x0132, B:64:0x013e, B:54:0x00de, B:73:0x00e4, B:55:0x0113, B:83:0x010a, B:96:0x0180, B:95:0x0177), top: B:37:0x0090, inners: #2, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v21, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void sP(com.bytedance.sdk.component.Sj.sP r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.Sj.sP(com.bytedance.sdk.component.Sj$sP, boolean):void");
    }

    static /* synthetic */ int uA(Sj sj2) {
        int i11 = sj2.Jcg;
        sj2.Jcg = i11 - 1;
        return i11;
    }

    static /* synthetic */ long vS(Sj sj2) {
        long j11 = sj2.Dq;
        sj2.Dq = 1 + j11;
        return j11;
    }

    public float Sj(String str, float f11) {
        float parseFloat;
        if (TextUtils.isEmpty(str)) {
            return f11;
        }
        synchronized (this.TKC) {
            try {
                try {
                    EjP();
                    parseFloat = Float.parseFloat(this.HiB.getProperty(str, String.valueOf(f11)));
                } catch (NumberFormatException e11) {
                    Log.e("TTPropHelper", e11.getMessage());
                    return f11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return parseFloat;
    }

    public int Sj(String str, int i11) {
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        synchronized (this.TKC) {
            try {
                try {
                    EjP();
                    parseInt = Integer.parseInt(this.HiB.getProperty(str, String.valueOf(i11)));
                } catch (NumberFormatException e11) {
                    Log.e("TTPropHelper", e11.getMessage());
                    return i11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return parseInt;
    }

    public long Sj(String str, long j11) {
        long parseLong;
        if (TextUtils.isEmpty(str)) {
            return j11;
        }
        synchronized (this.TKC) {
            try {
                try {
                    EjP();
                    parseLong = Long.parseLong(this.HiB.getProperty(str, String.valueOf(j11)));
                } catch (NumberFormatException e11) {
                    Log.e("TTPropHelper", e11.getMessage());
                    return j11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return parseLong;
    }

    public String Sj(String str, String str2) {
        String property;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        synchronized (this.TKC) {
            EjP();
            property = this.HiB.getProperty(str, str2);
        }
        return property;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00b4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0083 -> B:27:0x009d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj() {
        /*
            Method dump skipped, instructions count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.Sj.Sj():void");
    }

    public boolean Sj(String str) {
        boolean containsKey;
        synchronized (this.TKC) {
            try {
                try {
                    EjP();
                    containsKey = this.HiB.containsKey(str);
                } catch (NumberFormatException e11) {
                    Log.e("TTPropHelper", e11.getMessage());
                    return false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return containsKey;
    }

    public boolean Sj(String str, boolean z10) {
        boolean parseBoolean;
        if (TextUtils.isEmpty(str)) {
            return z10;
        }
        synchronized (this.TKC) {
            try {
                try {
                    EjP();
                    parseBoolean = Boolean.parseBoolean(this.HiB.getProperty(str, String.valueOf(z10)));
                } catch (NumberFormatException e11) {
                    Log.e("TTPropHelper", e11.getMessage());
                    return z10;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return parseBoolean;
    }

    public TKC sP() {
        return new TKC();
    }
}
