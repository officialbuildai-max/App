package com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj;

import android.text.TextUtils;
import com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC;
import e6.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class Sj implements x5.b {

    /* renamed from: a, reason: collision with root package name */
    private String f20259a = "video_reward_full";

    /* renamed from: b, reason: collision with root package name */
    private String f20260b = "video_brand";

    /* renamed from: c, reason: collision with root package name */
    private String f20261c = "video_splash";

    /* renamed from: d, reason: collision with root package name */
    private String f20262d = "video_default";

    /* renamed from: e, reason: collision with root package name */
    private String f20263e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f20264f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f20265g = null;

    /* renamed from: h, reason: collision with root package name */
    private String f20266h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f20267i = null;

    private Set b() {
        HashSet hashSet = new HashSet();
        for (d6.a aVar : d6.a.f61357e.values()) {
            if (aVar != null && aVar.d() != null) {
                TKC d11 = aVar.d();
                hashSet.add(c6.b.d(d11.sP(), d11.sef()).getAbsolutePath());
                hashSet.add(c6.b.c(d11.sP(), d11.sef()).getAbsolutePath());
            }
        }
        for (c cVar : e6.b.f61674a.values()) {
            if (cVar != null && cVar.e() != null) {
                TKC e11 = cVar.e();
                hashSet.add(c6.b.d(e11.sP(), e11.sef()).getAbsolutePath());
                hashSet.add(c6.b.c(e11.sP(), e11.sef()).getAbsolutePath());
            }
        }
        return hashSet;
    }

    private static void c(File[] fileArr, int i11, Set set) {
        if (i11 >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i11) {
                    List asList = Arrays.asList(fileArr);
                    Collections.sort(asList, new Comparator<File>() { // from class: com.bykv.vk.openvk.Sj.Sj.sP.Sj.Sj.Sj.1
                        @Override // java.util.Comparator
                        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long lastModified = file2.lastModified() - file.lastModified();
                            if (lastModified == 0) {
                                return 0;
                            }
                            return lastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i11 < asList.size()) {
                        File file = (File) asList.get(i11);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) asList.get(i11)).delete();
                        }
                        i11++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private List d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x5.a(new File(Sj()).listFiles(), b6.a.f()));
        arrayList.add(new x5.a(new File(sP()).listFiles(), b6.a.g()));
        arrayList.add(new x5.a(new File(a()).listFiles(), b6.a.a()));
        arrayList.add(new x5.a(new File(TKC()).listFiles(), b6.a.b()));
        return arrayList;
    }

    @Override // x5.b
    public synchronized void EjP() {
        try {
            Set set = null;
            for (x5.a aVar : d()) {
                File[] a11 = aVar.a();
                if (a11 != null && a11.length >= aVar.b()) {
                    if (set == null) {
                        set = b();
                    }
                    int b11 = aVar.b() - 2;
                    if (b11 < 0) {
                        b11 = 0;
                    }
                    c(aVar.a(), b11, set);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // x5.b
    public String Sj() {
        if (this.f20264f == null) {
            this.f20264f = this.f20263e + File.separator + this.f20259a;
            File file = new File(this.f20264f);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f20264f;
    }

    @Override // x5.b
    public void Sj(String str) {
        this.f20263e = str;
    }

    @Override // x5.b
    public boolean Sj(TKC tkc) {
        if (TextUtils.isEmpty(tkc.sP()) || TextUtils.isEmpty(tkc.sef())) {
            return false;
        }
        return new File(tkc.sP(), tkc.sef()).exists();
    }

    @Override // x5.b
    public String TKC() {
        if (this.f20267i == null) {
            this.f20267i = this.f20263e + File.separator + this.f20262d;
            File file = new File(this.f20267i);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f20267i;
    }

    public String a() {
        if (this.f20265g == null) {
            this.f20265g = this.f20263e + File.separator + this.f20260b;
            File file = new File(this.f20265g);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f20265g;
    }

    @Override // x5.b
    public long sP(TKC tkc) {
        if (TextUtils.isEmpty(tkc.sP()) || TextUtils.isEmpty(tkc.sef())) {
            return 0L;
        }
        return c6.b.a(tkc.sP(), tkc.sef());
    }

    @Override // x5.b
    public String sP() {
        if (this.f20266h == null) {
            this.f20266h = this.f20263e + File.separator + this.f20261c;
            File file = new File(this.f20266h);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f20266h;
    }
}
