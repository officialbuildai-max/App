package com.bytedance.sdk.openadsdk.core.settings;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.settings.HiB;
import com.bytedance.sdk.openadsdk.utils.JcM;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class aa implements HiB {
    private final String Jcg;
    private Sj TEQ;
    private final ConcurrentHashMap<String, Object> TKC = new ConcurrentHashMap<>();
    private final Object EjP = new Object();
    private final Object HiB = new Object();
    private final CountDownLatch vS = new CountDownLatch(1);
    private Properties Dq = new Properties();
    private volatile boolean uA = false;

    /* loaded from: classes3.dex */
    public interface Sj {
        void Sj();

        void sP();
    }

    /* loaded from: classes3.dex */
    public class sP implements HiB.Sj {
        private final Map<String, Object> sP = new HashMap();
        private final Object TKC = new Object();

        public sP() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.Sj
        public HiB.Sj Sj(String str) {
            synchronized (this.TKC) {
                this.sP.put(str, this);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.Sj
        public HiB.Sj Sj(String str, float f11) {
            synchronized (this.TKC) {
                this.sP.put(str, Float.valueOf(f11));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.Sj
        public HiB.Sj Sj(String str, int i11) {
            synchronized (this.TKC) {
                this.sP.put(str, Integer.valueOf(i11));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.Sj
        public HiB.Sj Sj(String str, long j11) {
            synchronized (this.TKC) {
                this.sP.put(str, Long.valueOf(j11));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.Sj
        public HiB.Sj Sj(String str, String str2) {
            synchronized (this.TKC) {
                this.sP.put(str, str2);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.Sj
        public HiB.Sj Sj(String str, boolean z10) {
            synchronized (this.TKC) {
                this.sP.put(str, Boolean.valueOf(z10));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.HiB.Sj
        public void Sj() {
            Object obj;
            Properties properties = new Properties();
            synchronized (this.TKC) {
                try {
                    properties.putAll(aa.this.Dq);
                    boolean z10 = false;
                    for (Map.Entry<String, Object> entry : this.sP.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value != this && value != null) {
                            if (properties.containsKey(key) && (obj = properties.get(key)) != null && obj.equals(value)) {
                            }
                            properties.put(key, String.valueOf(value));
                            z10 = true;
                        }
                        if (properties.containsKey(key)) {
                            properties.remove(key);
                            z10 = true;
                        }
                    }
                    this.sP.clear();
                    if (z10) {
                        aa.this.Sj(properties);
                        aa.this.Dq = properties;
                        aa.this.TKC.clear();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public aa(String str, Sj sj2) {
        this.Jcg = str;
        this.TEQ = sj2;
        JcM.Sj(new com.bytedance.sdk.component.Dq.Dq("SetL_".concat(String.valueOf(str))) { // from class: com.bytedance.sdk.openadsdk.core.settings.aa.1
            @Override // java.lang.Runnable
            public void run() {
                aa.this.Sj(false);
            }
        });
    }

    private void HiB() {
        if (this.uA) {
            return;
        }
        try {
            SystemClock.elapsedRealtime();
            this.vS.await(JcM.vS() ? 4 : 8, TimeUnit.SECONDS);
        } catch (InterruptedException e11) {
            sU.Sj("SdkSettings.Prop", "awaitLoadedLocked: ", e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(Properties properties) {
        FileOutputStream fileOutputStream;
        synchronized (this.HiB) {
            File vS = vS();
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(vS);
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                properties.store(fileOutputStream, (String) null);
                vS.getAbsolutePath();
                com.bytedance.sdk.openadsdk.utils.aa.Sj(fileOutputStream);
            } catch (Exception e12) {
                e = e12;
                fileOutputStream2 = fileOutputStream;
                sU.Sj("SdkSettings.Prop", "saveToLocal: ", e);
                if (fileOutputStream2 != null) {
                    com.bytedance.sdk.openadsdk.utils.aa.Sj(fileOutputStream2);
                }
                Fmk.mj();
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    com.bytedance.sdk.openadsdk.utils.aa.Sj(fileOutputStream2);
                }
                throw th;
            }
        }
        Fmk.mj();
    }

    private File vS() {
        return new File(dNu.Sj().getFilesDir(), this.Jcg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EjP() {
        Sj sj2 = this.TEQ;
        if (sj2 != null) {
            sj2.sP();
        }
    }

    public float Sj(String str, float f11) {
        if (str != null && !str.isEmpty()) {
            HiB();
            try {
                return Float.parseFloat(this.Dq.getProperty(str, String.valueOf(f11)));
            } catch (NumberFormatException e11) {
                sU.Sj("SdkSettings.Prop", "", e11);
            }
        }
        return f11;
    }

    public int Sj(String str, int i11) {
        if (str != null && !str.isEmpty()) {
            HiB();
            try {
                return Integer.parseInt(this.Dq.getProperty(str, String.valueOf(i11)));
            } catch (NumberFormatException e11) {
                sU.Sj("SdkSettings.Prop", "", e11);
            }
        }
        return i11;
    }

    public long Sj(String str, long j11) {
        if (str != null && !str.isEmpty()) {
            HiB();
            try {
                return Long.parseLong(this.Dq.getProperty(str, String.valueOf(j11)));
            } catch (NumberFormatException e11) {
                sU.Sj("SdkSettings.Prop", "", e11);
            }
        }
        return j11;
    }

    public HiB.Sj Sj() {
        return new sP();
    }

    public <T> T Sj(String str, T t11, HiB.sP<T> sPVar) {
        T sP2;
        if (str != null && !str.isEmpty()) {
            if (this.TKC.containsKey(str)) {
                try {
                    return (T) this.TKC.get(str);
                } catch (Exception e11) {
                    sU.Sj("SdkSettings.Prop", "", e11);
                    return t11;
                }
            }
            HiB();
            String property = this.Dq.getProperty(str, null);
            if (property != null && sPVar != null && (sP2 = sPVar.sP(property)) != null) {
                this.TKC.put(str, sP2);
                return sP2;
            }
        }
        return t11;
    }

    public String Sj(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2;
        }
        HiB();
        return this.Dq.getProperty(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00fc A[Catch: all -> 0x000b, TryCatch #6 {all -> 0x000b, blocks: (B:4:0x0003, B:7:0x0009, B:10:0x000e, B:12:0x0019, B:22:0x0049, B:23:0x004e, B:24:0x00f8, B:26:0x00fc, B:28:0x0100, B:29:0x0103, B:30:0x010a, B:45:0x005f, B:46:0x0062, B:49:0x007d, B:50:0x0080, B:51:0x0085, B:36:0x0075, B:37:0x0078, B:54:0x0086, B:56:0x0090, B:59:0x009a, B:61:0x00af, B:62:0x00bf, B:64:0x00c5, B:67:0x00d7, B:72:0x00df, B:80:0x00ea, B:81:0x00ed, B:43:0x0056, B:40:0x006c, B:34:0x0067), top: B:3:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(boolean r9) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.aa.Sj(boolean):void");
    }

    public boolean Sj(String str, boolean z10) {
        if (str != null && !str.isEmpty()) {
            HiB();
            try {
                return Boolean.parseBoolean(this.Dq.getProperty(str, String.valueOf(z10)));
            } catch (Exception e11) {
                sU.Sj("SdkSettings.Prop", "", e11);
            }
        }
        return z10;
    }

    public void TKC() {
        File vS = vS();
        if (vS.exists()) {
            vS.delete();
        }
    }

    public boolean sP() {
        return this.uA;
    }
}
