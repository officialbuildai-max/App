package com.bytedance.sdk.component.HiB.EjP.TKC.Sj.Sj;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Jcg;
import com.bytedance.sdk.component.utils.TEQ;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class Sj {
    private int Sj;
    private File sP;

    private Sj(int i11, File file) {
        this.Sj = i11;
        this.sP = file;
    }

    private static void EjP(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static Sj Sj(int i11, File file) {
        try {
            Sj sj2 = new Sj(i11, file);
            if (file != null) {
                file.mkdirs();
            }
            return sj2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private List<File> Sj(File file) {
        File[] listFiles;
        if (file != null) {
            try {
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                    List<File> asList = Arrays.asList(listFiles);
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : asList) {
                        if (file2 != null && file2.isFile() && !TextUtils.isEmpty(file2.getName()) && !file2.getName().endsWith(".temp")) {
                            arrayList.add(file2);
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private void Sj(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            EjP(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private File TKC(String str) {
        return new File(this.sP, str + ".temp");
    }

    private void TKC(File file) {
        if (file == null) {
            return;
        }
        try {
            Jcg.sP(file);
        } catch (Throwable unused) {
        }
    }

    private File sP(String str) {
        return new File(this.sP, str);
    }

    private List<File> sP(File file) {
        List<File> Sj = Sj(file);
        if (Sj == null || Sj.isEmpty()) {
            return null;
        }
        final HashMap hashMap = new HashMap();
        for (File file2 : Sj) {
            hashMap.put(file2, Long.valueOf(file2.lastModified()));
        }
        Collections.sort(Sj, new Comparator<File>() { // from class: com.bytedance.sdk.component.HiB.EjP.TKC.Sj.Sj.Sj.1
            @Override // java.util.Comparator
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public int compare(File file3, File file4) {
                if (file3 == null && file4 == null) {
                    return 0;
                }
                if (file3 == null) {
                    return 1;
                }
                if (file4 == null) {
                    return -1;
                }
                return Long.compare(((Long) hashMap.get(file4)).longValue(), ((Long) hashMap.get(file3)).longValue());
            }
        });
        return Sj;
    }

    public synchronized InputStream Sj(String str) {
        FileInputStream fileInputStream;
        if (this.Sj <= 0) {
            return null;
        }
        File sP = sP(str);
        try {
            try {
                fileInputStream = new FileInputStream(sP);
            } catch (Throwable unused) {
                return null;
            }
        } catch (FileNotFoundException unused2) {
            fileInputStream = null;
        }
        try {
            TKC(sP);
            return fileInputStream;
        } catch (FileNotFoundException unused3) {
            TEQ.Sj(fileInputStream);
            return null;
        }
    }

    public synchronized void Sj(int i11) {
        try {
            if (i11 > this.Sj) {
                return;
            }
            List<File> sP = sP(this.sP);
            if (sP != null && sP.size() > i11) {
                while (i11 < sP.size()) {
                    File file = sP.get(i11);
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    i11++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized boolean Sj(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (this.Sj > 0 && str != null && bArr != null) {
            File TKC = TKC(str);
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(TKC);
            } catch (FileNotFoundException unused) {
            } catch (Throwable unused2) {
            }
            try {
                fileOutputStream.write(bArr);
                if (TKC.exists()) {
                    Sj(TKC, sP(str), true);
                }
                TEQ.Sj(fileOutputStream);
                List<File> Sj = Sj(this.sP);
                if (Sj != null) {
                    int size = Sj.size();
                    int i11 = this.Sj;
                    if (size > i11) {
                        Sj((int) (i11 * 0.7d));
                    }
                }
                return true;
            } catch (FileNotFoundException unused3) {
                fileOutputStream2 = fileOutputStream;
                try {
                    File file = this.sP;
                    if (file != null) {
                        file.mkdirs();
                    }
                    TEQ.Sj(fileOutputStream2);
                    List<File> Sj2 = Sj(this.sP);
                    if (Sj2 != null) {
                        int size2 = Sj2.size();
                        int i12 = this.Sj;
                        if (size2 > i12) {
                            Sj((int) (i12 * 0.7d));
                        }
                    }
                    return false;
                } finally {
                    TEQ.Sj(fileOutputStream2);
                    List<File> Sj3 = Sj(this.sP);
                    if (Sj3 != null) {
                        int size3 = Sj3.size();
                        int i13 = this.Sj;
                        if (size3 > i13) {
                            Sj((int) (i13 * 0.7d));
                        }
                    }
                }
            } catch (Throwable unused4) {
                fileOutputStream2 = fileOutputStream;
                return false;
            }
        }
        return false;
    }
}
