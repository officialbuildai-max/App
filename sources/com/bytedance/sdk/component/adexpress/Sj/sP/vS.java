package com.bytedance.sdk.component.adexpress.Sj.sP;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class vS {
    public static int Sj = 20;
    private static volatile vS sP;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.Sj.TKC.TKC> HiB;
    private final Object EjP = new Object();
    private AtomicBoolean vS = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.Sj.TKC.sP> Jcg = new LruCache<String, com.bytedance.sdk.component.adexpress.Sj.TKC.sP>(Sj) { // from class: com.bytedance.sdk.component.adexpress.Sj.sP.vS.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.Sj.TKC.sP sPVar) {
            return 1;
        }
    };
    private Set<String> TKC = Collections.synchronizedSet(new HashSet());

    private vS() {
    }

    private void EjP(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.Sj.TKC.sP> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.Jcg) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.EjP) {
            this.Jcg.remove(str);
        }
    }

    public static vS Sj() {
        if (sP == null) {
            synchronized (vS.class) {
                try {
                    if (sP == null) {
                        sP = new vS();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return sP;
    }

    public static void Sj(int i11) {
        Sj = i11;
    }

    public static String TKC() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)").toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if (r11.moveToFirst() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        r0 = r11.getString(r11.getColumnIndex("rit"));
        r2 = r11.getString(r11.getColumnIndex("id"));
        r3 = r11.getString(r11.getColumnIndex("md5"));
        r4 = r11.getString(r11.getColumnIndex("url"));
        r5 = r11.getString(r11.getColumnIndex("data"));
        r6 = r11.getString(r11.getColumnIndex("version"));
        r0 = new com.bytedance.sdk.component.adexpress.Sj.TKC.sP().Sj(r0).sP(r2).TKC(r3).EjP(r4).HiB(r5).vS(r6).Sj(java.lang.Long.valueOf(r11.getLong(r11.getColumnIndex(com.transsion.push.PushConstants.PROVIDER_FIELD_UPDATE_TIME))));
        r3 = r10.EjP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b3, code lost:
    
        monitor-enter(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b4, code lost:
    
        r10.Jcg.put(r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b9, code lost:
    
        monitor-exit(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ba, code lost:
    
        r10.TKC.add(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c3, code lost:
    
        if (r11.moveToNext() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c5, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c8, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.adexpress.Sj.TKC.sP Sj(java.lang.String r11) {
        /*
            r10 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = 0
            if (r0 != 0) goto Ld3
            com.bytedance.sdk.component.adexpress.Sj.Sj.Sj r0 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj()
            com.bytedance.sdk.component.adexpress.Sj.Sj.sP r0 = r0.sP()
            if (r0 != 0) goto L13
            goto Ld3
        L13:
            java.lang.Object r0 = r10.EjP
            monitor-enter(r0)
            android.util.LruCache<java.lang.String, com.bytedance.sdk.component.adexpress.Sj.TKC.sP> r2 = r10.Jcg     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> Ld0
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> Ld0
            com.bytedance.sdk.component.adexpress.Sj.TKC.sP r2 = (com.bytedance.sdk.component.adexpress.Sj.TKC.sP) r2     // Catch: java.lang.Throwable -> Ld0
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld0
            if (r2 == 0) goto L26
            return r2
        L26:
            com.bytedance.sdk.component.adexpress.Sj.Sj.Sj r0 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj()
            com.bytedance.sdk.component.adexpress.Sj.Sj.sP r2 = r0.sP()
            java.lang.String r3 = "template_diff_new"
            java.lang.String r5 = "id=?"
            java.lang.String[] r6 = new java.lang.String[]{r11}
            r8 = 0
            r9 = 0
            r4 = 0
            r7 = 0
            android.database.Cursor r11 = r2.Sj(r3, r4, r5, r6, r7, r8, r9)
            if (r11 == 0) goto Lcf
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Throwable -> Lcc
            if (r0 == 0) goto Lcc
        L46:
            java.lang.String r0 = "rit"
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r0 = r11.getString(r0)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r2 = "id"
            int r2 = r11.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r2 = r11.getString(r2)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r3 = "md5"
            int r3 = r11.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r3 = r11.getString(r3)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r4 = "url"
            int r4 = r11.getColumnIndex(r4)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r4 = r11.getString(r4)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r5 = "data"
            int r5 = r11.getColumnIndex(r5)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r5 = r11.getString(r5)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r6 = "version"
            int r6 = r11.getColumnIndex(r6)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r6 = r11.getString(r6)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r7 = "update_time"
            int r7 = r11.getColumnIndex(r7)     // Catch: java.lang.Throwable -> Lcc
            long r7 = r11.getLong(r7)     // Catch: java.lang.Throwable -> Lcc
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> Lcc
            com.bytedance.sdk.component.adexpress.Sj.TKC.sP r8 = new com.bytedance.sdk.component.adexpress.Sj.TKC.sP     // Catch: java.lang.Throwable -> Lcc
            r8.<init>()     // Catch: java.lang.Throwable -> Lcc
            com.bytedance.sdk.component.adexpress.Sj.TKC.sP r0 = r8.Sj(r0)     // Catch: java.lang.Throwable -> Lcc
            com.bytedance.sdk.component.adexpress.Sj.TKC.sP r0 = r0.sP(r2)     // Catch: java.lang.Throwable -> Lcc
            com.bytedance.sdk.component.adexpress.Sj.TKC.sP r0 = r0.TKC(r3)     // Catch: java.lang.Throwable -> Lcc
            com.bytedance.sdk.component.adexpress.Sj.TKC.sP r0 = r0.EjP(r4)     // Catch: java.lang.Throwable -> Lcc
            com.bytedance.sdk.component.adexpress.Sj.TKC.sP r0 = r0.HiB(r5)     // Catch: java.lang.Throwable -> Lcc
            com.bytedance.sdk.component.adexpress.Sj.TKC.sP r0 = r0.vS(r6)     // Catch: java.lang.Throwable -> Lcc
            com.bytedance.sdk.component.adexpress.Sj.TKC.sP r0 = r0.Sj(r7)     // Catch: java.lang.Throwable -> Lcc
            java.lang.Object r3 = r10.EjP     // Catch: java.lang.Throwable -> Lcc
            monitor-enter(r3)     // Catch: java.lang.Throwable -> Lcc
            android.util.LruCache<java.lang.String, com.bytedance.sdk.component.adexpress.Sj.TKC.sP> r4 = r10.Jcg     // Catch: java.lang.Throwable -> Lc9
            r4.put(r2, r0)     // Catch: java.lang.Throwable -> Lc9
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lc9
            java.util.Set<java.lang.String> r3 = r10.TKC     // Catch: java.lang.Throwable -> Lcc
            r3.add(r2)     // Catch: java.lang.Throwable -> Lcc
            boolean r2 = r11.moveToNext()     // Catch: java.lang.Throwable -> Lcc
            if (r2 != 0) goto L46
            r11.close()
            return r0
        Lc9:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lcc
            throw r0     // Catch: java.lang.Throwable -> Lcc
        Lcc:
            r11.close()
        Lcf:
            return r1
        Ld0:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        Ld3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.Sj.sP.vS.Sj(java.lang.String):com.bytedance.sdk.component.adexpress.Sj.TKC.sP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(com.bytedance.sdk.component.adexpress.Sj.TKC.sP sPVar, boolean z10) {
        if (sPVar == null || com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().sP() == null || TextUtils.isEmpty(sPVar.sP())) {
            return;
        }
        Cursor Sj2 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().sP().Sj("template_diff_new", null, "id=?", new String[]{sPVar.sP()}, null, null, null);
        boolean z11 = Sj2 != null && Sj2.getCount() > 0;
        if (Sj2 != null) {
            try {
                r2 = Sj2.moveToFirst() ? Sj2.getString(Sj2.getColumnIndex("rit")) : null;
                Sj2.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", sPVar.Sj());
        contentValues.put("id", sPVar.sP());
        contentValues.put("md5", sPVar.TKC());
        contentValues.put("url", sPVar.EjP());
        contentValues.put("data", sPVar.HiB());
        contentValues.put("version", sPVar.vS());
        contentValues.put(PushConstants.PROVIDER_FIELD_UPDATE_TIME, sPVar.Jcg());
        if (z11) {
            com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().sP().Sj("template_diff_new", contentValues, "id=?", new String[]{sPVar.sP()});
        } else {
            com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().sP().Sj("template_diff_new", contentValues);
        }
        synchronized (this.EjP) {
            this.Jcg.put(sPVar.sP(), sPVar);
        }
        this.TKC.add(sPVar.sP());
        if (z10) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().vS() == null) {
                return;
            }
            if (this.HiB == null) {
                this.HiB = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.Sj.TKC.TKC tkc = new com.bytedance.sdk.component.adexpress.Sj.TKC.TKC(sPVar.Sj(), sPVar.sP(), sPVar.TKC());
            this.HiB.put(sPVar.sP(), tkc);
            if (r2 != null) {
                com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().vS();
                tkc.sP();
            }
            com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().vS();
            sPVar.Sj();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().sP() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i11 = 0; i11 < strArr.length; i11++) {
                EjP(strArr[i11]);
                com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().sP().Sj("template_diff_new", "id=?", new String[]{strArr[i11]});
                TKC(strArr[i11]);
            }
        }
    }

    void TKC(String str) {
        com.bytedance.sdk.component.adexpress.Sj.TKC.TKC tkc;
        try {
            if (this.HiB == null || this.HiB.isEmpty() || (tkc = this.HiB.get(str)) == null) {
                return;
            }
            if (!TextUtils.isEmpty(tkc.Sj()) && com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().vS() != null) {
                com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().vS();
            }
            this.HiB.remove(str);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public List<com.bytedance.sdk.component.adexpress.Sj.TKC.sP> sP() {
        if (com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().sP() == null) {
            return null;
        }
        boolean z10 = this.vS.get();
        this.vS.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor Sj2 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().sP().Sj("template_diff_new", null, null, null, null, null, null);
        if (Sj2 != null) {
            while (Sj2.moveToNext()) {
                try {
                    String string = Sj2.getString(Sj2.getColumnIndex("rit"));
                    String string2 = Sj2.getString(Sj2.getColumnIndex("id"));
                    String string3 = Sj2.getString(Sj2.getColumnIndex("md5"));
                    String string4 = Sj2.getString(Sj2.getColumnIndex("url"));
                    String string5 = Sj2.getString(Sj2.getColumnIndex("data"));
                    String string6 = Sj2.getString(Sj2.getColumnIndex("version"));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.Sj.TKC.sP().Sj(string).sP(string2).TKC(string3).EjP(string4).HiB(string5).vS(string6).Sj(Long.valueOf(Sj2.getLong(Sj2.getColumnIndex(PushConstants.PROVIDER_FIELD_UPDATE_TIME)))));
                    synchronized (this.EjP) {
                        this.Jcg.put(string2, arrayList.get(arrayList.size() - 1));
                    }
                    this.TKC.add(string2);
                    if (!z10 && com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().vS() != null) {
                        if (this.HiB == null) {
                            this.HiB = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.HiB.contains(string2)) {
                            this.HiB.put(string2, new com.bytedance.sdk.component.adexpress.Sj.TKC.TKC(string, string2, string3));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            Sj2.close();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0037, code lost:
    
        r0.add(r12.getString(r12.getColumnIndex("id")));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r12.moveToNext() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
    
        if (r12.moveToFirst() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Set<java.lang.String> sP(java.lang.String r12) {
        /*
            r11 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r1 = 0
            if (r0 != 0) goto L62
            com.bytedance.sdk.component.adexpress.Sj.Sj.Sj r0 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj()
            com.bytedance.sdk.component.adexpress.Sj.Sj.sP r0 = r0.sP()
            if (r0 != 0) goto L12
            goto L62
        L12:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            com.bytedance.sdk.component.adexpress.Sj.Sj.Sj r2 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj()
            com.bytedance.sdk.component.adexpress.Sj.Sj.sP r3 = r2.sP()
            java.lang.String[] r7 = new java.lang.String[]{r12}
            r9 = 0
            r10 = 0
            java.lang.String r4 = "template_diff_new"
            r5 = 0
            java.lang.String r6 = "rit=?"
            r8 = 0
            android.database.Cursor r12 = r3.Sj(r4, r5, r6, r7, r8, r9, r10)
            if (r12 == 0) goto L62
            boolean r2 = r12.moveToFirst()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            if (r2 == 0) goto L52
        L37:
            java.lang.String r2 = "id"
            int r2 = r12.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            java.lang.String r2 = r12.getString(r2)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r0.add(r2)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            boolean r2 = r12.moveToNext()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            if (r2 != 0) goto L37
            r12.close()
            return r0
        L4e:
            r0 = move-exception
            goto L5e
        L50:
            r0 = move-exception
            goto L56
        L52:
            r12.close()
            goto L62
        L56:
            java.lang.String r2 = "TmplDbHelper"
            java.lang.String r3 = ""
            android.util.Log.e(r2, r3, r0)     // Catch: java.lang.Throwable -> L4e
            goto L52
        L5e:
            r12.close()
            throw r0
        L62:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.Sj.sP.vS.sP(java.lang.String):java.util.Set");
    }
}
