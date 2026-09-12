package com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.component.vS.Sj.Dq;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.meituan.android.walle.ChannelReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Sj extends TKC {
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj EjP;
    protected List<String> Sj;
    private final Context TKC;

    public Sj(Context context, com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj2) {
        super(context);
        this.Sj = new ArrayList();
        this.TKC = context;
        this.EjP = sj2;
        if (sj2 == null) {
            this.EjP = com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj.TKC();
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

    public static String sP(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    private void sP(int i11, long j11) {
        if (j11 > 0 || i11 > 0) {
            com.bytedance.sdk.component.vS.Sj.Sj.Sj.TKC.Sj(HiB(), sP(), "gen_time <? OR retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j11), String.valueOf(i11)});
            sP();
        }
    }

    public byte EjP() {
        return (byte) 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
    
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int Sj() {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r10.HiB()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            java.lang.String r3 = r10.sP()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            java.lang.String r4 = "count(1)"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            r8 = 0
            r9 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = com.bytedance.sdk.component.vS.Sj.Sj.Sj.TKC.Sj(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            if (r0 == 0) goto L25
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            int r1 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            goto L25
        L23:
            r1 = move-exception
            goto L2b
        L25:
            if (r0 == 0) goto L34
        L27:
            r0.close()     // Catch: java.lang.Exception -> L34
            goto L34
        L2b:
            if (r0 == 0) goto L30
            r0.close()     // Catch: java.lang.Exception -> L30
        L30:
            throw r1
        L31:
            if (r0 == 0) goto L34
            goto L27
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.Sj.Sj():int");
    }

    public List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj(int i11, String str) {
        String str2;
        String[] strArr;
        byte b11;
        String str3;
        Cursor Sj;
        long Sj2 = com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj(i11, HiB());
        sP();
        if (Sj2 <= 0) {
            Sj2 = 1;
        } else if (Sj2 > 100) {
            Sj2 = 100;
        }
        String str4 = str + " DESC limit " + Sj2;
        ArrayList arrayList = new ArrayList();
        this.Sj.clear();
        long dNu = Dq.Jcg().dNu();
        if (dNu > 0) {
            strArr = new String[]{String.valueOf(System.currentTimeMillis() - dNu)};
            str2 = "gen_time>?";
        } else {
            str2 = null;
            strArr = null;
        }
        if (com.bytedance.sdk.component.vS.Sj.TKC.Sj.EjP() && EjP() == 3) {
            b11 = 3;
            str3 = "id";
            Sj = com.bytedance.sdk.component.vS.Sj.Sj.Sj.TKC.Sj(HiB(), sP(), new String[]{"id", AppMeasurementSdk.ConditionalUserProperty.VALUE, "encrypt", ChannelReader.CHANNEL_KEY}, str2, strArr, null, null, str4);
        } else {
            b11 = 3;
            str3 = "id";
            Sj = com.bytedance.sdk.component.vS.Sj.Sj.Sj.TKC.Sj(HiB(), sP(), new String[]{str3, AppMeasurementSdk.ConditionalUserProperty.VALUE, "encrypt"}, str2, strArr, null, null, str4);
        }
        Cursor cursor = Sj;
        if (cursor != null) {
            try {
                com.bytedance.sdk.component.vS.Sj.HiB uvD = Dq.Jcg().uvD();
                while (cursor.moveToNext()) {
                    try {
                        String string = cursor.getString(cursor.getColumnIndex(str3));
                        String string2 = cursor.getString(cursor.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                        int i12 = cursor.getInt(cursor.getColumnIndex("encrypt"));
                        int i13 = (com.bytedance.sdk.component.vS.Sj.TKC.Sj.EjP() && EjP() == b11) ? cursor.getInt(cursor.getColumnIndex(ChannelReader.CHANNEL_KEY)) : 0;
                        if (i12 == 1) {
                            try {
                                string2 = uvD.Sj(string2);
                            } catch (Throwable th2) {
                                th = th2;
                                th.getMessage();
                            }
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.Sj.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(string2);
                            com.bytedance.sdk.component.vS.Sj.EjP.Sj.Sj sj2 = new com.bytedance.sdk.component.vS.Sj.EjP.Sj.Sj(string, jSONObject);
                            sj2.Sj(EjP());
                            sj2.sP(TKC());
                            if (com.bytedance.sdk.component.vS.Sj.TKC.Sj.EjP() && EjP() == b11) {
                                sj2.Sj(i13);
                            }
                            com.bytedance.sdk.component.vS.Sj.TKC.Sj.Sj(jSONObject, sj2);
                            arrayList.add(sj2);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                try {
                    cursor.close();
                    if (!this.Sj.isEmpty()) {
                        Sj(this.Sj);
                        this.Sj.clear();
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th4) {
                try {
                    cursor.close();
                    if (!this.Sj.isEmpty()) {
                        Sj(this.Sj);
                        this.Sj.clear();
                    }
                } catch (Exception unused2) {
                }
                throw th4;
            }
        }
        sP();
        arrayList.size();
        return arrayList;
    }

    public List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj(String str) {
        com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj2 = this.EjP;
        return sj2 == null ? new ArrayList() : Sj(sj2.sP(), str);
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
        if (this.EjP == null) {
            return false;
        }
        int Sj = Sj();
        int Sj2 = this.EjP.Sj();
        sP();
        return (com.bytedance.sdk.component.vS.Sj.TKC.Sj.TKC() && (i11 == 1 || i11 == 2)) ? Sj > 0 : Sj >= Sj2;
    }

    public byte TKC() {
        return (byte) 2;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.TKC
    public String sP() {
        com.bytedance.sdk.component.vS.Sj.Sj.HiB EjP = Dq.Jcg().EjP();
        if (EjP != null) {
            return EjP.sP();
        }
        return null;
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
