package com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.component.vS.Sj.Dq;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Jcg extends TKC {
    protected List<String> Sj;
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj TKC;

    public Jcg(Context context, com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj2) {
        super(context);
        this.Sj = new ArrayList();
        this.TKC = sj2;
        if (sj2 == null) {
            this.TKC = com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj.TKC();
        }
    }

    private static String Sj(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    private static String Sj(String str, List<?> list, int i11, boolean z10) {
        String str2 = z10 ? " IN " : " NOT IN ";
        String str3 = z10 ? " OR " : " AND ";
        int min = Math.min(i11, 1000);
        int size = list.size();
        int i12 = size % min == 0 ? size / min : (size / min) + 1;
        StringBuilder sb2 = new StringBuilder();
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * min;
            String Sj = Sj(TextUtils.join("','", list.subList(i14, Math.min(i14 + min, size))), "");
            if (i13 != 0) {
                sb2.append(str3);
            }
            sb2.append(str);
            sb2.append(str2);
            sb2.append("('");
            sb2.append(Sj);
            sb2.append("')");
        }
        return Sj(sb2.toString(), str + str2 + "('')");
    }

    public static String TKC(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    private void sP(int i11, long j11) {
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.TKC.Sj(HiB(), sP(), "gen_time <? AND retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j11), String.valueOf(i11)});
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        if (r1 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0021, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int EjP() {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.HiB()     // Catch: java.lang.Throwable -> L27
            java.lang.String r2 = r9.sP()     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "count(1)"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L27
            r7 = 0
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r1 = com.bytedance.sdk.component.vS.Sj.Sj.Sj.TKC.Sj(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L21
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L28
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L28
        L21:
            if (r1 == 0) goto L2b
        L23:
            r1.close()     // Catch: java.lang.Exception -> L2b
            goto L2b
        L27:
            r1 = 0
        L28:
            if (r1 == 0) goto L2b
            goto L23
        L2b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.Jcg.EjP():int");
    }

    public byte Sj() {
        return (byte) 1;
    }

    public List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj(int i11, String str) {
        long Sj = com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj(i11, HiB());
        if (Sj <= 0) {
            Sj = 1;
        } else if (Sj > 100) {
            Sj = 100;
        }
        ArrayList arrayList = new ArrayList();
        this.Sj.clear();
        Cursor Sj2 = com.bytedance.sdk.component.vS.Sj.Sj.Sj.TKC.Sj(HiB(), sP(), new String[]{"id", AppMeasurementSdk.ConditionalUserProperty.VALUE, "encrypt"}, null, null, null, null, str + " DESC limit " + Sj);
        if (Sj2 != null) {
            while (Sj2.moveToNext()) {
                try {
                    try {
                        String string = Sj2.getString(Sj2.getColumnIndex("id"));
                        String string2 = Sj2.getString(Sj2.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                        if (Sj2.getInt(Sj2.getColumnIndex("encrypt")) == 1) {
                            string2 = Dq.Jcg().uvD().Sj(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.Sj.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            com.bytedance.sdk.component.vS.Sj.EjP.Sj.Sj sj2 = new com.bytedance.sdk.component.vS.Sj.EjP.Sj.Sj(string, new JSONObject(string2));
                            sj2.sP(TKC());
                            sj2.Sj(Sj());
                            arrayList.add(sj2);
                        }
                    } catch (Throwable unused) {
                    }
                } finally {
                    try {
                        Sj2.close();
                        if (!this.Sj.isEmpty()) {
                            Sj(this.Sj);
                            this.Sj.clear();
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        return arrayList;
    }

    public void Sj(int i11, long j11) {
        sP(i11, j11);
    }

    protected void Sj(List<String> list) {
        sP();
        list.size();
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.TKC.Sj(HiB(), "DELETE FROM " + sP() + " WHERE " + Sj("id", list, 1000, true));
        com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.pfr(), list.size());
        TKC(list);
    }

    public boolean Sj(int i11) {
        return this.TKC != null && EjP() >= this.TKC.Sj();
    }

    public byte TKC() {
        return (byte) 2;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.TKC
    public String sP() {
        return Dq.Jcg().EjP().EjP();
    }

    public List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> sP(String str) {
        com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj2 = this.TKC;
        return sj2 == null ? new ArrayList() : Sj(sj2.sP(), str);
    }

    public void sP(List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2 : list) {
            linkedList.add(sj2.TKC());
            com.bytedance.sdk.component.vS.Sj.TKC.Sj.TEQ(sj2);
        }
        sP();
        linkedList.size();
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.TKC.Sj(HiB(), "DELETE FROM " + sP() + " WHERE " + Sj("id", linkedList, 1000, true));
        TKC(linkedList);
    }
}
