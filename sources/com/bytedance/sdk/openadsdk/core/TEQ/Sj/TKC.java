package com.bytedance.sdk.openadsdk.core.TEQ.Sj;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.transsion.push.PushConstants;
import java.util.Set;

/* loaded from: classes3.dex */
public class TKC {
    public static int Sj = 20;
    private static volatile TKC sP;
    private final Object TKC = new Object();
    private final LruCache<String, Sj> EjP = new LruCache<String, Sj>(Sj) { // from class: com.bytedance.sdk.openadsdk.core.TEQ.Sj.TKC.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Sj sj2) {
            return 1;
        }
    };

    private TKC() {
    }

    public static String EjP() {
        return "ALTER TABLE ugen_template ADD COLUMN rit TEXT ";
    }

    public static TKC Sj() {
        if (sP == null) {
            synchronized (TKC.class) {
                try {
                    if (sP == null) {
                        sP = new TKC();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return sP;
    }

    public static String TKC() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)").toString();
    }

    private void sP(String str) {
        if (!TextUtils.isEmpty(str) && this.EjP.size() > 0) {
            synchronized (this.TKC) {
                this.EjP.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (r0.moveToFirst() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r11 = r0.getColumnIndex("id");
        r12 = r0.getColumnIndex("md5");
        r2 = r0.getColumnIndex("url");
        r3 = r0.getColumnIndex("data");
        r4 = r0.getColumnIndex(com.transsion.push.PushConstants.PROVIDER_FIELD_UPDATE_TIME);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        if (r11 == (-1)) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
    
        if (r12 == (-1)) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        if (r2 == (-1)) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
    
        if (r4 == (-1)) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        if (r3 != (-1)) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
    
        r6 = r0.getColumnIndex("rit");
        r11 = r0.getString(r11);
        r12 = r0.getString(r12);
        r2 = r0.getString(r2);
        r3 = r0.getString(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008e, code lost:
    
        if (r6 == (-1)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
    
        r5 = r0.getString(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:
    
        r12 = new com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj().Sj(r11).sP(r12).EjP(r3).TKC(r2).HiB(r5).Sj(java.lang.Long.valueOf(r0.getLong(r4)));
        r2 = r10.TKC;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bf, code lost:
    
        monitor-enter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c0, code lost:
    
        r10.EjP.put(r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c5, code lost:
    
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ca, code lost:
    
        if (r0.moveToNext() != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d6, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj Sj(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.lang.Object r0 = r10.TKC
            monitor-enter(r0)
            android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj> r2 = r10.EjP     // Catch: java.lang.Throwable -> Le9
            java.lang.Object r2 = r2.get(r11)     // Catch: java.lang.Throwable -> Le9
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r2 = (com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj) r2     // Catch: java.lang.Throwable -> Le9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le9
            if (r2 == 0) goto L25
            java.lang.String r11 = r2.sP()
            boolean r11 = android.text.TextUtils.equals(r12, r11)
            if (r11 != 0) goto L24
            r10.sP(r12)
            return r1
        L24:
            return r2
        L25:
            com.bytedance.sdk.openadsdk.multipro.aidl.TKC r0 = new com.bytedance.sdk.openadsdk.multipro.aidl.TKC
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.dNu.Sj()
            java.lang.String r3 = "ugen_template"
            java.lang.String r5 = "id=? AND md5=?"
            java.lang.String[] r6 = new java.lang.String[]{r11, r12}
            r8 = 0
            r9 = 0
            r4 = 0
            r7 = 0
            java.util.Map r11 = com.bytedance.sdk.openadsdk.multipro.Sj.Sj.Sj(r2, r3, r4, r5, r6, r7, r8, r9)
            r0.<init>(r11)
            boolean r11 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L95
            if (r11 == 0) goto Ld7
        L44:
            java.lang.String r11 = "id"
            int r11 = r0.getColumnIndex(r11)     // Catch: java.lang.Throwable -> L95
            java.lang.String r12 = "md5"
            int r12 = r0.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L95
            java.lang.String r2 = "url"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L95
            java.lang.String r3 = "data"
            int r3 = r0.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L95
            java.lang.String r4 = "update_time"
            int r4 = r0.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L95
            r5 = -1
            if (r11 == r5) goto Ld3
            if (r12 == r5) goto Ld3
            if (r2 == r5) goto Ld3
            if (r4 == r5) goto Ld3
            if (r3 != r5) goto L6e
            goto Ld3
        L6e:
            java.lang.String r6 = "rit"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L95
            java.lang.String r11 = r0.getString(r11)     // Catch: java.lang.Throwable -> L95
            java.lang.String r12 = r0.getString(r12)     // Catch: java.lang.Throwable -> L95
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L95
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Throwable -> L95
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L95
            if (r7 == 0) goto L8e
            r0.close()
            return r1
        L8e:
            if (r6 == r5) goto L97
            java.lang.String r5 = r0.getString(r6)     // Catch: java.lang.Throwable -> L95
            goto L98
        L95:
            r11 = move-exception
            goto Ldb
        L97:
            r5 = r1
        L98:
            long r6 = r0.getLong(r4)     // Catch: java.lang.Throwable -> L95
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L95
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r6 = new com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj     // Catch: java.lang.Throwable -> L95
            r6.<init>()     // Catch: java.lang.Throwable -> L95
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r6 = r6.Sj(r11)     // Catch: java.lang.Throwable -> L95
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r12 = r6.sP(r12)     // Catch: java.lang.Throwable -> L95
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r12 = r12.EjP(r3)     // Catch: java.lang.Throwable -> L95
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r12 = r12.TKC(r2)     // Catch: java.lang.Throwable -> L95
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r12 = r12.HiB(r5)     // Catch: java.lang.Throwable -> L95
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r12 = r12.Sj(r4)     // Catch: java.lang.Throwable -> L95
            java.lang.Object r2 = r10.TKC     // Catch: java.lang.Throwable -> L95
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L95
            android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj> r3 = r10.EjP     // Catch: java.lang.Throwable -> Ld0
            r3.put(r11, r12)     // Catch: java.lang.Throwable -> Ld0
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Ld0
            boolean r11 = r0.moveToNext()     // Catch: java.lang.Throwable -> L95
            if (r11 != 0) goto L44
            r0.close()
            return r12
        Ld0:
            r11 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L95
            throw r11     // Catch: java.lang.Throwable -> L95
        Ld3:
            r0.close()
            return r1
        Ld7:
            r0.close()
            goto Le3
        Ldb:
            java.lang.String r12 = "UGTmplDbHelper"
            java.lang.String r2 = "getGgenTemplate error"
            com.bytedance.sdk.component.utils.sU.Sj(r12, r2, r11)     // Catch: java.lang.Throwable -> Le4
            goto Ld7
        Le3:
            return r1
        Le4:
            r11 = move-exception
            r0.close()
            throw r11
        Le9:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.TEQ.Sj.TKC.Sj(java.lang.String, java.lang.String):com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        if (r2 == (-1)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        r2 = r1.getString(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        r4 = r10.TKC;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        r5 = r10.EjP.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        if (r5 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        r0.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        r4 = new com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj();
        r5 = r1.getColumnIndex("data");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r5 == (-1)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        r5 = r1.getString(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        r4.EjP(r5);
        r4.Sj(r2);
        r4.HiB(r11);
        r5 = r1.getColumnIndex("md5");
        r6 = r1.getColumnIndex("url");
        r7 = r1.getColumnIndex(com.transsion.push.PushConstants.PROVIDER_FIELD_UPDATE_TIME);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
    
        if (r5 == (-1)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
    
        r4.sP(r1.getString(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:
    
        if (r6 == (-1)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
    
        r4.TKC(r1.getString(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0097, code lost:
    
        if (r7 == (-1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
    
        r4.Sj(java.lang.Long.valueOf(r1.getLong(r7)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
    
        r0.add(r4);
        r3 = r10.TKC;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a9, code lost:
    
        monitor-enter(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00aa, code lost:
    
        r10.EjP.put(r2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00af, code lost:
    
        monitor-exit(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bb, code lost:
    
        if (r1.moveToNext() != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
    
        if (r1.moveToFirst() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
    
        r2 = r1.getColumnIndex("id");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Set<com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj> Sj(java.lang.String r11) {
        /*
            r10 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 == 0) goto L8
            r11 = 0
            return r11
        L8:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            com.bytedance.sdk.openadsdk.multipro.aidl.TKC r1 = new com.bytedance.sdk.openadsdk.multipro.aidl.TKC
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.dNu.Sj()
            java.lang.String r3 = "ugen_template"
            java.lang.String r5 = "rit=?"
            java.lang.String[] r6 = new java.lang.String[]{r11}
            r8 = 0
            r9 = 0
            r4 = 0
            r7 = 0
            java.util.Map r2 = com.bytedance.sdk.openadsdk.multipro.Sj.Sj.Sj(r2, r3, r4, r5, r6, r7, r8, r9)
            r1.<init>(r2)
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto Lbd
        L2c:
            java.lang.String r2 = "id"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L51
            r3 = -1
            if (r2 == r3) goto Lb7
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L51
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L51
            if (r4 != 0) goto Lb7
            java.lang.Object r4 = r10.TKC     // Catch: java.lang.Throwable -> L51
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L51
            android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj> r5 = r10.EjP     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r5 = r5.get(r2)     // Catch: java.lang.Throwable -> Lb4
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r5 = (com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj) r5     // Catch: java.lang.Throwable -> Lb4
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lb4
            if (r5 == 0) goto L53
            r0.add(r5)     // Catch: java.lang.Throwable -> L51
            goto Lb7
        L51:
            r11 = move-exception
            goto Lc1
        L53:
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r4 = new com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj     // Catch: java.lang.Throwable -> L51
            r4.<init>()     // Catch: java.lang.Throwable -> L51
            java.lang.String r5 = "data"
            int r5 = r1.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L51
            if (r5 == r3) goto Lb7
            java.lang.String r5 = r1.getString(r5)     // Catch: java.lang.Throwable -> L51
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L51
            if (r6 != 0) goto Lb7
            r4.EjP(r5)     // Catch: java.lang.Throwable -> L51
            r4.Sj(r2)     // Catch: java.lang.Throwable -> L51
            r4.HiB(r11)     // Catch: java.lang.Throwable -> L51
            java.lang.String r5 = "md5"
            int r5 = r1.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L51
            java.lang.String r6 = "url"
            int r6 = r1.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L51
            java.lang.String r7 = "update_time"
            int r7 = r1.getColumnIndex(r7)     // Catch: java.lang.Throwable -> L51
            if (r5 == r3) goto L8e
            java.lang.String r5 = r1.getString(r5)     // Catch: java.lang.Throwable -> L51
            r4.sP(r5)     // Catch: java.lang.Throwable -> L51
        L8e:
            if (r6 == r3) goto L97
            java.lang.String r5 = r1.getString(r6)     // Catch: java.lang.Throwable -> L51
            r4.TKC(r5)     // Catch: java.lang.Throwable -> L51
        L97:
            if (r7 == r3) goto La4
            long r5 = r1.getLong(r7)     // Catch: java.lang.Throwable -> L51
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L51
            r4.Sj(r3)     // Catch: java.lang.Throwable -> L51
        La4:
            r0.add(r4)     // Catch: java.lang.Throwable -> L51
            java.lang.Object r3 = r10.TKC     // Catch: java.lang.Throwable -> L51
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L51
            android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj> r5 = r10.EjP     // Catch: java.lang.Throwable -> Lb1
            r5.put(r2, r4)     // Catch: java.lang.Throwable -> Lb1
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lb1
            goto Lb7
        Lb1:
            r11 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            throw r11     // Catch: java.lang.Throwable -> L51
        Lb4:
            r11 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
            throw r11     // Catch: java.lang.Throwable -> L51
        Lb7:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L51
            if (r2 != 0) goto L2c
        Lbd:
            r1.close()
            goto Lc9
        Lc1:
            java.lang.String r2 = "UGTmplDbHelper"
            java.lang.String r3 = "getUgenTemplateFormRit error"
            com.bytedance.sdk.component.utils.sU.Sj(r2, r3, r11)     // Catch: java.lang.Throwable -> Lca
            goto Lbd
        Lc9:
            return r0
        Lca:
            r11 = move-exception
            r1.close()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.TEQ.Sj.TKC.Sj(java.lang.String):java.util.Set");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(Sj sj2) {
        if (sj2 == null || TextUtils.isEmpty(sj2.Sj())) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.TKC tkc = new com.bytedance.sdk.openadsdk.multipro.aidl.TKC(com.bytedance.sdk.openadsdk.multipro.Sj.Sj.Sj(dNu.Sj(), "ugen_template", null, "id=?", new String[]{sj2.Sj()}, null, null, null));
        boolean z10 = tkc.getCount() > 0;
        try {
            tkc.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", sj2.Sj());
            contentValues.put("md5", sj2.sP());
            contentValues.put("url", sj2.TKC());
            contentValues.put("data", sj2.HiB());
            contentValues.put("rit", sj2.vS());
            contentValues.put(PushConstants.PROVIDER_FIELD_UPDATE_TIME, sj2.EjP());
            if (z10) {
                com.bytedance.sdk.openadsdk.multipro.Sj.Sj.Sj(dNu.Sj(), "ugen_template", contentValues, "id=?", new String[]{sj2.Sj()});
            } else {
                com.bytedance.sdk.openadsdk.multipro.Sj.Sj.Sj(dNu.Sj(), "ugen_template", contentValues);
            }
            synchronized (this.TKC) {
                this.EjP.put(sj2.Sj(), sj2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (String str : strArr) {
                sP(str);
                com.bytedance.sdk.openadsdk.multipro.Sj.Sj.Sj(dNu.Sj(), "ugen_template", "id=?", new String[]{str});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0047, code lost:
    
        if (r5 == (-1)) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        r8 = r1.getColumnIndex("rit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004f, code lost:
    
        if (r8 == (-1)) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        r7 = r1.getString(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
    
        r2 = r1.getString(r2);
        r3 = r1.getString(r3);
        r4 = r1.getString(r4);
        r5 = r1.getString(r5);
        r3 = new com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj().Sj(r2).sP(r3).TKC(r4).EjP(r5).HiB(r7).Sj(java.lang.Long.valueOf(r1.getLong(r6)));
        r0.add(r3);
        r4 = r10.TKC;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0093, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0094, code lost:
    
        r10.EjP.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0099, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a2, code lost:
    
        if (r1.moveToNext() != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001e, code lost:
    
        if (r1.moveToFirst() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
    
        r2 = r1.getColumnIndex("id");
        r3 = r1.getColumnIndex("md5");
        r4 = r1.getColumnIndex("url");
        r5 = r1.getColumnIndex("data");
        r6 = r1.getColumnIndex(com.transsion.push.PushConstants.PROVIDER_FIELD_UPDATE_TIME);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003f, code lost:
    
        if (r2 == (-1)) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0041, code lost:
    
        if (r3 == (-1)) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0043, code lost:
    
        if (r4 == (-1)) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0045, code lost:
    
        if (r6 == (-1)) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj> sP() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.bytedance.sdk.openadsdk.multipro.aidl.TKC r1 = new com.bytedance.sdk.openadsdk.multipro.aidl.TKC
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.dNu.Sj()
            java.lang.String r3 = "ugen_template"
            r8 = 0
            r9 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.util.Map r2 = com.bytedance.sdk.openadsdk.multipro.Sj.Sj.Sj(r2, r3, r4, r5, r6, r7, r8, r9)
            r1.<init>(r2)
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L56
            if (r2 == 0) goto La4
        L20:
            java.lang.String r2 = "id"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L56
            java.lang.String r3 = "md5"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = "url"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L56
            java.lang.String r5 = "data"
            int r5 = r1.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r6 = "update_time"
            int r6 = r1.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L56
            r7 = -1
            if (r2 == r7) goto L9e
            if (r3 == r7) goto L9e
            if (r4 == r7) goto L9e
            if (r6 == r7) goto L9e
            if (r5 == r7) goto L9e
            java.lang.String r8 = "rit"
            int r8 = r1.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L56
            if (r8 == r7) goto L58
            java.lang.String r7 = r1.getString(r8)     // Catch: java.lang.Throwable -> L56
            goto L59
        L56:
            r2 = move-exception
            goto La8
        L58:
            r7 = 0
        L59:
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L56
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L56
            java.lang.String r5 = r1.getString(r5)     // Catch: java.lang.Throwable -> L56
            long r8 = r1.getLong(r6)     // Catch: java.lang.Throwable -> L56
            java.lang.Long r6 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r8 = new com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj     // Catch: java.lang.Throwable -> L56
            r8.<init>()     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r8 = r8.Sj(r2)     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r3 = r8.sP(r3)     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r3 = r3.TKC(r4)     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r3 = r3.EjP(r5)     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r3 = r3.HiB(r7)     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj r3 = r3.Sj(r6)     // Catch: java.lang.Throwable -> L56
            r0.add(r3)     // Catch: java.lang.Throwable -> L56
            java.lang.Object r4 = r10.TKC     // Catch: java.lang.Throwable -> L56
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L56
            android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.core.TEQ.Sj.Sj> r5 = r10.EjP     // Catch: java.lang.Throwable -> L9b
            r5.put(r2, r3)     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L9b
            goto L9e
        L9b:
            r2 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L56
            throw r2     // Catch: java.lang.Throwable -> L56
        L9e:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L56
            if (r2 != 0) goto L20
        La4:
            r1.close()
            goto Lb0
        La8:
            java.lang.String r3 = "UGTmplDbHelper"
            java.lang.String r4 = "getUgenTemplate error"
            com.bytedance.sdk.component.utils.sU.Sj(r3, r4, r2)     // Catch: java.lang.Throwable -> Lb1
            goto La4
        Lb0:
            return r0
        Lb1:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.TEQ.Sj.TKC.sP():java.util.List");
    }
}
