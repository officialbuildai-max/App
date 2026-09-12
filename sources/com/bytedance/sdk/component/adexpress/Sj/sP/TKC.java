package com.bytedance.sdk.component.adexpress.Sj.sP;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.adexpress.Sj.TKC.Sj;
import com.bytedance.sdk.component.utils.LD;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class TKC {
    public static void Sj(File file, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2, String str) {
        FileOutputStream fileOutputStream;
        if (sj2 == null) {
            return;
        }
        String TEQ = sj2.TEQ();
        if (TextUtils.isEmpty(TEQ)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file3);
        } catch (Throwable unused) {
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(TEQ.getBytes("utf-8"));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            try {
                fileOutputStream.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable unused3) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                }
            }
        }
    }

    @Deprecated
    public static boolean Sj(com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2, String str) {
        if (sj2 == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(sj2.TKC())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Sj(sj2.TKC(), str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean Sj(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "\\."
            java.lang.String[] r7 = r7.split(r0)
            java.lang.String[] r6 = r6.split(r0)
            int r0 = r7.length
            int r1 = r6.length
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 0
            r2 = r1
        L12:
            if (r2 >= r0) goto L42
            r3 = r7[r2]
            int r3 = r3.length()
            r4 = r6[r2]
            int r4 = r4.length()
            int r3 = r3 - r4
            r4 = 1
            if (r3 != 0) goto L3f
            r3 = r7[r2]
            r5 = r6[r2]
            int r3 = r3.compareTo(r5)
            if (r3 <= 0) goto L2f
            return r4
        L2f:
            if (r3 >= 0) goto L32
            return r1
        L32:
            int r3 = r0 + (-1)
            if (r2 != r3) goto L3c
            int r7 = r7.length
            int r6 = r6.length
            if (r7 <= r6) goto L3b
            return r4
        L3b:
            return r1
        L3c:
            int r2 = r2 + 1
            goto L12
        L3f:
            if (r3 <= 0) goto L42
            return r4
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.Sj.sP.TKC.Sj(java.lang.String, java.lang.String):boolean");
    }

    private boolean Sj(List<Sj.C0225Sj> list, List<Sj.C0225Sj> list2) {
        for (Sj.C0225Sj c0225Sj : list) {
            String Sj = c0225Sj.Sj();
            String Sj2 = com.bytedance.sdk.component.utils.HiB.Sj(Sj);
            File file = new File(Sj(), Sj2);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.Jcg.sP.Sj vS = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().vS();
            vS.sP(Sj);
            vS.Sj(Sj().getAbsolutePath(), Sj2);
            com.bytedance.sdk.component.Jcg.sP Sj3 = vS.Sj();
            list2.add(c0225Sj);
            if (Sj3 == null || !Sj3.vS() || Sj3.HiB() == null || !Sj3.HiB().exists()) {
                TKC(list2);
                return false;
            }
        }
        return true;
    }

    private static boolean Sj(Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> map, Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2 = map.get(str);
            if (sj2 == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj3 = map2.get(str);
            if (sj3 == null) {
                return false;
            }
            if (Sj(sj2.TKC(), sj3.TKC())) {
                return true;
            }
        }
        return false;
    }

    public static boolean TKC(com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj3) {
        if (sj2 != null) {
            try {
                if (!TextUtils.isEmpty(sj2.TKC())) {
                    if (sj3 == null) {
                        return false;
                    }
                    String Jcg = sj2.Jcg();
                    String Jcg2 = sj3.Jcg();
                    if ((!TextUtils.isEmpty(Jcg2) && !Jcg2.equals(Jcg)) || Sj(sj2.TKC(), sj3.TKC())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> Sj = sj2.Sj();
                    Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> Sj2 = sj3.Sj();
                    if (Sj.isEmpty()) {
                        return !Sj2.isEmpty();
                    }
                    if (Sj2.isEmpty()) {
                        return false;
                    }
                    return Sj(Sj, Sj2);
                }
            } catch (Throwable th2) {
                th2.getMessage();
                return false;
            }
        }
        return true;
    }

    public static void sP(File file, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2, String str) {
        if (sj2 == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (sj2.vS() != null) {
            Iterator<Sj.C0225Sj> it = sj2.vS().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.HiB.Sj(it.next().Sj())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public abstract File Sj();

    public List<Sj.C0225Sj> Sj(com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj3) {
        Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> Sj = sj2.Sj();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (Sj.size() == 0) {
            if (sj3 != null && sj3.Sj().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> Sj2 = sj3.Sj();
                Iterator<String> it = Sj2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj4 = Sj2.get(it.next());
                    if (sj4 != null) {
                        arrayList.addAll(sj4.vS());
                    }
                }
            }
        } else if (sj3 != null && sj3.Sj().size() != 0) {
            Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> Sj3 = sj3.Sj();
            for (String str : Sj.keySet()) {
                com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj5 = Sj.get(str);
                com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj6 = Sj3.get(str);
                if (sj6 == null && sj5 != null) {
                    arrayList2.addAll(sj5.vS());
                } else if (sj5 == null && sj6 != null) {
                    arrayList.addAll(sj6.vS());
                } else if (sj5 != null) {
                    for (Sj.C0225Sj c0225Sj : sj5.vS()) {
                        if (c0225Sj != null && !sj6.vS().contains(c0225Sj) && c0225Sj.sP() != null && c0225Sj.Sj() != null) {
                            arrayList2.add(c0225Sj);
                        }
                    }
                    for (Sj.C0225Sj c0225Sj2 : sj6.vS()) {
                        if (c0225Sj2 != null && !sj5.vS().contains(c0225Sj2)) {
                            arrayList.add(c0225Sj2);
                        }
                    }
                }
            }
        } else if (Sj.size() != 0) {
            Iterator<String> it2 = Sj.keySet().iterator();
            while (it2.hasNext()) {
                com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj7 = Sj.get(it2.next());
                if (sj7 != null) {
                    arrayList2.addAll(sj7.vS());
                }
            }
        }
        if (Sj(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void Sj(int i11) {
        if (com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().EjP() != null) {
            com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().EjP().Sj(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Sj(Sj.sP sPVar) {
        if (sPVar == null || Sj() == null) {
            return false;
        }
        List<Pair<String, String>> sP = sPVar.sP();
        if (sP == null || sP.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = sP.iterator();
        while (it.hasNext()) {
            File file = new File(Sj(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public boolean Sj(String str) {
        String Sj = com.bytedance.sdk.component.utils.HiB.Sj(str);
        File file = new File(Sj().getAbsoluteFile(), Sj + ".zip");
        com.bytedance.sdk.component.Jcg.sP.Sj vS = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().vS();
        vS.sP(str);
        vS.Sj(file.getParent(), file.getName());
        com.bytedance.sdk.component.Jcg.sP Sj2 = vS.Sj();
        if (Sj2.vS() && Sj2.HiB() != null && Sj2.HiB().exists()) {
            File HiB = Sj2.HiB();
            try {
                LD.Sj(HiB.getAbsolutePath(), file.getParent());
                if (!HiB.exists()) {
                    return true;
                }
                HiB.delete();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Sj(List<Sj.C0225Sj> list) {
        if (list == null || list.size() <= 0 || Sj() == null) {
            return false;
        }
        for (Sj.C0225Sj c0225Sj : list) {
            String Sj = com.bytedance.sdk.component.utils.HiB.Sj(c0225Sj.Sj());
            if (TextUtils.isEmpty(Sj)) {
                return false;
            }
            File file = new File(Sj(), Sj);
            String Sj2 = com.bytedance.sdk.component.utils.HiB.Sj(file);
            if (!file.exists() || !file.isFile() || c0225Sj.sP() == null || !c0225Sj.sP().equals(Sj2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Sj(Map<String, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2 = map.get(it.next());
            if (sj2 != null && !Sj(sj2.vS())) {
                return false;
            }
        }
        return true;
    }

    public void TKC(List<Sj.C0225Sj> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Sj.C0225Sj> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(Sj(), com.bytedance.sdk.component.utils.HiB.Sj(it.next().Sj()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public List<Sj.C0225Sj> sP(com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2, com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (sj3 == null || sj3.vS().isEmpty()) {
            arrayList2.addAll(sj2.vS());
        } else if (sj2.vS().isEmpty()) {
            arrayList.addAll(sj3.vS());
        } else {
            for (Sj.C0225Sj c0225Sj : sj2.vS()) {
                if (!sj3.vS().contains(c0225Sj) && c0225Sj != null && c0225Sj.Sj() != null && c0225Sj.sP() != null) {
                    arrayList2.add(c0225Sj);
                }
            }
            for (Sj.C0225Sj c0225Sj2 : sj3.vS()) {
                if (!sj2.vS().contains(c0225Sj2)) {
                    arrayList.add(c0225Sj2);
                }
            }
        }
        if (Sj(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void sP(List<Sj.C0225Sj> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Sj.C0225Sj> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(Sj(), com.bytedance.sdk.component.utils.HiB.Sj(it.next().Sj()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
