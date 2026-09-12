package com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj;

import android.os.Handler;
import com.bytedance.sdk.component.Dq.Dq;
import com.bytedance.sdk.component.Dq.vS;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public abstract class TKC extends com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.a {

    /* renamed from: a, reason: collision with root package name */
    public final File f20308a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashMap f20309b;

    /* renamed from: c, reason: collision with root package name */
    private final ReentrantReadWriteLock.WriteLock f20310c;

    /* renamed from: d, reason: collision with root package name */
    private final Set f20311d;

    /* renamed from: e, reason: collision with root package name */
    private volatile long f20312e;

    /* renamed from: f, reason: collision with root package name */
    private volatile float f20313f;

    /* renamed from: g, reason: collision with root package name */
    private final b f20314g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f20315h;

    /* renamed from: i, reason: collision with root package name */
    private final Handler f20316i;

    /* renamed from: com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.TKC$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ TKC Sj;

        AnonymousClass1(TKC tkc) {
        }

        @Override // java.lang.Runnable
        public void run() {
            vS.sP(new Dq("cleanupCmd", 1) { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.TKC.1.1
                @Override // java.lang.Runnable
                public void run() {
                    TKC tkc = AnonymousClass1.this.Sj;
                    tkc.k(tkc.f20312e);
                }
            });
        }
    }

    /* renamed from: com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.TKC$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 extends Dq {
        final /* synthetic */ TKC Sj;

        AnonymousClass2(TKC tkc, String str, int i11) {
            super(str, i11);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.Sj.j();
        }
    }

    /* renamed from: com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.TKC$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass4 extends Dq {
        final /* synthetic */ TKC Sj;

        AnonymousClass4(TKC tkc, String str, int i11) {
            super(str, i11);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.Sj.k(0L);
        }
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(Set set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        abstract boolean a(String str);
    }

    private String f(File file) {
        return file.getName();
    }

    private void i() {
        this.f20316i.removeCallbacks(this.f20315h);
        this.f20316i.postDelayed(this.f20315h, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f20310c.lock();
        try {
            File[] listFiles = this.f20308a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>(this) { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.TKC.3
                    final /* synthetic */ TKC sP;

                    @Override // java.util.Comparator
                    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long longValue = ((Long) hashMap.get(file2)).longValue() - ((Long) hashMap.get(file3)).longValue();
                        if (longValue < 0) {
                            return -1;
                        }
                        return longValue > 0 ? 1 : 0;
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    this.f20309b.put(f(file2), file2);
                }
            }
            this.f20310c.unlock();
            i();
        } catch (Throwable th2) {
            this.f20310c.unlock();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j11) {
        HashSet hashSet;
        long j12;
        final HashSet hashSet2 = new HashSet();
        this.f20310c.lock();
        try {
            Iterator it = this.f20309b.entrySet().iterator();
            j12 = 0;
            while (it.hasNext()) {
                j12 += ((File) ((Map.Entry) it.next()).getValue()).length();
            }
        } catch (Throwable unused) {
            hashSet = null;
        }
        if (j12 <= j11) {
            this.f20310c.unlock();
            return;
        }
        long j13 = ((float) j11) * this.f20313f;
        hashSet = new HashSet();
        try {
            for (Map.Entry entry : this.f20309b.entrySet()) {
                File file = (File) entry.getValue();
                if (file == null || !file.exists()) {
                    hashSet.add(entry.getKey());
                } else if (!this.f20314g.a(f(file))) {
                    long length = file.length();
                    File file2 = new File(file.getAbsolutePath() + "-tmp");
                    if (file.renameTo(file2)) {
                        hashSet2.add(file2);
                        j12 -= length;
                        hashSet.add(entry.getKey());
                    }
                }
                if (j12 <= j13) {
                    break;
                }
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                this.f20309b.remove((String) it2.next());
            }
        } catch (Throwable unused2) {
        }
        this.f20310c.unlock();
        Iterator it3 = this.f20311d.iterator();
        while (it3.hasNext()) {
            ((a) it3.next()).a(hashSet);
        }
        vS.sP(new Dq(this, "trimSize", 1) { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.TKC.5
            final /* synthetic */ TKC sP;

            @Override // java.lang.Runnable
            public void run() {
                Iterator it4 = hashSet2.iterator();
                while (it4.hasNext()) {
                    try {
                        ((File) it4.next()).delete();
                    } catch (Throwable unused3) {
                    }
                }
            }
        });
    }

    public abstract void g();
}
