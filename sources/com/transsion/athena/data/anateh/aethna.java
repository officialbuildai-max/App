package com.transsion.athena.data.anateh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.Track;
import com.transsion.athena.data.anateh.anehat;
import com.transsion.athena.hatnea.anateh;
import com.transsion.athena.hatnea.taaneh;
import com.transsion.ga.i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class aethna {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile aethna f42719a;

    /* renamed from: b, reason: collision with root package name */
    private Context f42720b;

    /* renamed from: c, reason: collision with root package name */
    private anehat f42721c;

    /* renamed from: d, reason: collision with root package name */
    private String f42722d;

    /* loaded from: classes5.dex */
    public interface athena {
        void a(anateh anatehVar);
    }

    private aethna(Context context) {
        try {
            this.f42720b = context;
            this.f42721c = anehat.a(context);
            this.f42722d = context.getFilesDir().getPath();
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.a(e11);
        }
    }

    public static aethna a(Context context) {
        if (f42719a == null) {
            synchronized (aethna.class) {
                try {
                    if (f42719a == null) {
                        f42719a = new aethna(context);
                    }
                } finally {
                }
            }
        }
        return f42719a;
    }

    public int a(int i11, enatha<String> enathaVar) {
        try {
            return this.f42721c.a(anehat.athena.f42726a, i11, enathaVar);
        } catch (com.transsion.ga.anateh e11) {
            int i12 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
            return -1;
        }
    }

    public int a(Track track) {
        int i11 = 1;
        if (track.getTrackFlag() != 1 && track.getTrackFlag() != 2) {
            i11 = 0;
        }
        try {
            return this.f42721c.a(anehat.athena.f42726a, track, i11);
        } catch (com.transsion.ga.anateh e11) {
            int i12 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
            return 0;
        }
    }

    public int a(ArrayList<Track> arrayList, enatha<LongSparseArray<Integer>> enathaVar) {
        try {
            return this.f42721c.b(anehat.athena.f42726a, arrayList, enathaVar);
        } catch (com.transsion.ga.anateh e11) {
            int i11 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
            return 0;
        }
    }

    public synchronized com.transsion.athena.data.anehat a(long j11, long j12, String str, int i11, int i12) {
        try {
        } catch (com.transsion.ga.anateh e11) {
            int i13 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
            return null;
        }
        return this.f42721c.a(anehat.athena.f42726a, j11, j12, str, i11, i12);
    }

    public synchronized void a() {
        this.f42721c.a();
        try {
            Context context = this.f42720b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f42722d);
            String str = File.separator;
            sb2.append(str);
            sb2.append(ehanat.f42664k);
            com.transsion.athena.taaneh.athena.a(context, sb2.toString());
            com.transsion.athena.taaneh.athena.a(this.f42720b, this.f42722d + str + ehanat.f42665l);
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    public synchronized void a(long j11, athena athenaVar) {
        try {
            String str = this.f42722d + File.separator + ehanat.f42664k;
            if (new File(str).exists()) {
                for (File file : com.transsion.athena.taaneh.athena.a(str, j11)) {
                    if (!file.getName().contains("upload")) {
                        if (!file.getName().startsWith("f_")) {
                            if (file.getName().startsWith("r_")) {
                            }
                        }
                        File file2 = new File(file.getPath() + "upload" + System.currentTimeMillis());
                        file = !file.renameTo(file2) ? null : file2;
                    }
                    if (file != null) {
                        athenaVar.a(new taaneh(j11, file, com.transsion.athena.aethna.athena.c().a(j11)));
                    }
                }
            }
            String str2 = this.f42722d + File.separator + ehanat.f42665l;
            if (new File(str2).exists()) {
                try {
                    com.transsion.athena.taaneh.athena.a(this.f42720b, str2);
                } catch (Exception e11) {
                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(com.transsion.athena.config.data.model.athena athenaVar, boolean z10) {
        try {
            this.f42721c.a(anehat.athena.f42729d, athenaVar, z10);
        } catch (com.transsion.ga.anateh e11) {
            int i11 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
        }
    }

    public void a(AppIdData appIdData) {
        try {
            this.f42721c.a(anehat.athena.f42729d, appIdData);
        } catch (com.transsion.ga.anateh e11) {
            int i11 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
        }
    }

    public void a(enatha<SparseArray<com.transsion.athena.config.data.model.athena>> enathaVar) {
        try {
            this.f42721c.a(enathaVar);
        } catch (com.transsion.ga.anateh e11) {
            int i11 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
        }
    }

    public synchronized void a(String str, long j11) {
        try {
            this.f42721c.a(anehat.athena.f42726a, str, j11);
        } catch (com.transsion.ga.anateh e11) {
            int i11 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
        }
    }

    public synchronized void a(List<AppIdData> list) {
        try {
            this.f42721c.a(anehat.athena.f42729d, list);
        } catch (com.transsion.ga.anateh e11) {
            int i11 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
        }
    }

    public synchronized void a(List<AppIdData> list, int i11) {
        try {
            this.f42721c.a(anehat.athena.f42729d, list, i11);
        } catch (com.transsion.ga.anateh e11) {
            int i12 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
        }
    }

    public synchronized void a(List<AppIdData> list, long j11, String str, enatha<SparseArray<com.transsion.athena.data.enatha>> enathaVar) {
        try {
            this.f42721c.a(anehat.athena.f42726a, list, j11, str, enathaVar);
        } catch (com.transsion.ga.anateh e11) {
            int i11 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
        }
    }

    public synchronized void a(List<AppIdData> list, String str) {
        try {
            this.f42721c.a(anehat.athena.f42726a, list, str);
        } catch (com.transsion.ga.anateh e11) {
            int i11 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
        }
    }

    public synchronized void a(List<Long> list, boolean z10, enatha<String> enathaVar) {
        if (z10) {
            try {
                String str = this.f42722d + File.separator + ehanat.f42664k;
                if (new File(str).exists()) {
                    for (File file : com.transsion.athena.taaneh.athena.a(str)) {
                        String name = file.getName();
                        if (!name.startsWith("f_") && !name.startsWith("r_")) {
                            com.transsion.athena.taaneh.aethna.a("cleanupEvents deleteFile " + name + " " + com.transsion.athena.taaneh.athena.b(this.f42720b, file));
                        }
                        if (list.contains(Long.valueOf(Long.parseLong(name.substring(2, name.indexOf(45)))))) {
                            com.transsion.athena.taaneh.aethna.a("cleanupEvents deleteFile " + name + " " + com.transsion.athena.taaneh.athena.b(this.f42720b, file));
                        }
                    }
                }
                String str2 = this.f42722d + File.separator + ehanat.f42665l;
                if (new File(str2).exists()) {
                    try {
                        com.transsion.athena.taaneh.athena.a(this.f42720b, str2);
                    } catch (Exception e11) {
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            this.f42721c.a(anehat.athena.f42726a, list, enathaVar);
        } catch (com.transsion.ga.anateh e12) {
            int i11 = com.transsion.ga.anateh.f44239a;
            i.a().c(e12);
        }
    }

    public synchronized boolean a(int i11) {
        try {
        } catch (com.transsion.ga.anateh e11) {
            int i12 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
            return false;
        }
        return this.f42721c.a(anehat.athena.f42726a, i11);
    }

    public void b() {
        this.f42721c.a(true);
    }

    public List<AppIdData> c() {
        try {
            return this.f42721c.a(anehat.athena.f42729d);
        } catch (com.transsion.ga.anateh e11) {
            int i11 = com.transsion.ga.anateh.f44239a;
            i.a().c(e11);
            return null;
        }
    }
}
