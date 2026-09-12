package com.bytedance.sdk.openadsdk.dNu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.bytedance.sdk.openadsdk.BusMonitorDependWrapper;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Sj {
    private static Context EjP;
    private static final long HiB = System.currentTimeMillis();
    private sP Sj;
    private Boolean TKC;
    private com.bytedance.sdk.openadsdk.dNu.TKC.Sj sP;
    private int vS = 0;
    private final ArrayList<EjP> Jcg = new ArrayList<>();
    private Runnable Dq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.dNu.Sj.2
        @Override // java.lang.Runnable
        public void run() {
            Sj sj2 = Sj.this;
            sj2.TKC = Boolean.valueOf(sj2.Sj.isMonitorOpen());
            if (Sj.this.TKC.booleanValue()) {
                Sj sj3 = Sj.this;
                sj3.Sj(sj3.Jcg);
                Sj.this.Jcg.clear();
            }
        }
    };
    private Runnable uA = new Runnable() { // from class: com.bytedance.sdk.openadsdk.dNu.Sj.4
        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            ArrayList arrayList;
            String str3 = "is_init";
            String str4 = "mediation";
            try {
                SQLiteDatabase sP = com.bytedance.sdk.openadsdk.dNu.Sj.Sj.sP();
                if (sP != null) {
                    String[] strArr = {"_id", "sdk_version", FrameworkConstants.GLOBAL_DATA_KEY_SCENE, "start_count", "success_count", "fail_count", "rit", "tag", "label", CampaignEx.JSON_KEY_TIMESTAMP, "mediation", "is_init", "extra"};
                    String[] strArr2 = {String.valueOf(Sj.HiB)};
                    try {
                        int max = Math.max(10, Sj.this.Sj.getOnceLogCount());
                        int i11 = max > 100 ? 10 : max;
                        Cursor query = sP.query("monitor_table", strArr, "timestamp <= ?", strArr2, null, null, null, String.valueOf(i11));
                        if (query != null) {
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            while (query.moveToNext()) {
                                int i12 = i11;
                                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj2 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                if (query.getColumnIndex("_id") >= 0) {
                                    arrayList = arrayList2;
                                    str = str3;
                                    str2 = str4;
                                    long j11 = query.getLong(query.getColumnIndex("_id"));
                                    sj2.Sj(j11);
                                    arrayList3.add(String.valueOf(j11));
                                } else {
                                    str = str3;
                                    str2 = str4;
                                    arrayList = arrayList2;
                                }
                                if (query.getColumnIndex("sdk_version") >= 0) {
                                    sj2.Sj(query.getString(query.getColumnIndex("sdk_version")));
                                }
                                if (query.getColumnIndex(FrameworkConstants.GLOBAL_DATA_KEY_SCENE) >= 0) {
                                    sj2.sP(query.getString(query.getColumnIndex(FrameworkConstants.GLOBAL_DATA_KEY_SCENE)));
                                }
                                if (query.getColumnIndex("start_count") >= 0) {
                                    sj2.Sj(query.getInt(query.getColumnIndex("start_count")));
                                }
                                if (query.getColumnIndex("success_count") >= 0) {
                                    sj2.sP(query.getInt(query.getColumnIndex("success_count")));
                                }
                                if (query.getColumnIndex("fail_count") >= 0) {
                                    sj2.TKC(query.getInt(query.getColumnIndex("fail_count")));
                                }
                                if (query.getColumnIndex("rit") >= 0) {
                                    sj2.TKC(query.getString(query.getColumnIndex("rit")));
                                }
                                if (query.getColumnIndex("tag") >= 0) {
                                    sj2.EjP(query.getString(query.getColumnIndex("tag")));
                                }
                                if (query.getColumnIndex("label") >= 0) {
                                    sj2.HiB(query.getString(query.getColumnIndex("label")));
                                }
                                String str5 = str2;
                                if (query.getColumnIndex(str5) >= 0) {
                                    sj2.vS(query.getString(query.getColumnIndex(str5)));
                                }
                                String str6 = str;
                                if (query.getColumnIndex(str6) >= 0) {
                                    sj2.EjP(query.getInt(query.getColumnIndex(str6)));
                                }
                                if (query.getColumnIndex("extra") >= 0) {
                                    sj2.Jcg(query.getString(query.getColumnIndex("extra")));
                                }
                                arrayList2 = arrayList;
                                arrayList2.add(sj2);
                                i11 = i12;
                                str4 = str5;
                                str3 = str6;
                            }
                            int i13 = i11;
                            query.close();
                            if (!arrayList2.isEmpty()) {
                                Sj.this.Sj.onMonitorUpload(arrayList2);
                                SQLiteDatabase Sj = com.bytedance.sdk.openadsdk.dNu.Sj.Sj.Sj();
                                if (Sj != null && Sj.isOpen()) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("_id IN (");
                                    for (int i14 = 0; i14 < arrayList3.size(); i14++) {
                                        sb2.append(UrlUtils.QUESTION_MARK);
                                        if (i14 < arrayList3.size() - 1) {
                                            sb2.append(",");
                                        }
                                    }
                                    sb2.append(")");
                                    Sj.delete("monitor_table", sb2.toString(), (String[]) arrayList3.toArray(new String[0]));
                                    if (Sj.this.sP != null) {
                                        Sj.this.sP.Sj(Sj.HiB);
                                    }
                                }
                                if (arrayList2.size() < i13 || Sj.this.vS > 1000) {
                                    return;
                                }
                                Sj.this.Sj(false);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Log.e("BusMonitorCenter", th.getMessage());
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    };

    private Sj(sP sPVar) {
        try {
            this.Sj = new BusMonitorDependWrapper(sPVar);
            this.sP = new com.bytedance.sdk.openadsdk.dNu.TKC.Sj(sPVar.getContext());
            EjP = sPVar.getContext();
        } catch (Throwable th2) {
            Log.e("BusMonitorCenter", th2.getMessage());
        }
    }

    static /* synthetic */ int EjP(Sj sj2) {
        int i11 = sj2.vS;
        sj2.vS = i11 + 1;
        return i11;
    }

    public static Context Sj() {
        Context context = EjP;
        return context != null ? context : BusMonitorDependWrapper.getReflectContext();
    }

    public static Sj Sj(sP sPVar) {
        return new Sj(sPVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(List<EjP> list) {
        com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        SQLiteDatabase Sj = com.bytedance.sdk.openadsdk.dNu.Sj.Sj.Sj();
                        if (Sj != null) {
                            try {
                                Sj.beginTransaction();
                                for (int i11 = 0; i11 < list.size(); i11++) {
                                    EjP ejP = list.get(i11);
                                    if (ejP != null && (generatorModel = ejP.generatorModel()) != null) {
                                        Cursor query = Sj.query("monitor_table", new String[]{"_id", "sdk_version", FrameworkConstants.GLOBAL_DATA_KEY_SCENE, "start_count", "success_count", "fail_count", "rit", "tag", "label", CampaignEx.JSON_KEY_TIMESTAMP, "mediation", "is_init", "extra"}, new StringBuilder("sdk_version = ? AND scene = ? AND rit = ? AND tag = ? AND label = ? AND mediation = ? AND is_init = ? AND extra = ?").toString(), new String[]{generatorModel.sP(), generatorModel.TKC(), generatorModel.Jcg(), generatorModel.Dq(), generatorModel.uA(), generatorModel.Ym(), String.valueOf(generatorModel.aa()), generatorModel.Fmk()}, null, null, null);
                                        if (query != null) {
                                            if (query.moveToNext()) {
                                                int columnIndex = query.getColumnIndex("_id");
                                                if (columnIndex >= 0) {
                                                    generatorModel.Sj(query.getLong(columnIndex));
                                                }
                                                int columnIndex2 = query.getColumnIndex("start_count");
                                                if (columnIndex2 >= 0) {
                                                    generatorModel.Sj(query.getInt(columnIndex2) + generatorModel.EjP());
                                                }
                                                int columnIndex3 = query.getColumnIndex("success_count");
                                                if (columnIndex3 >= 0) {
                                                    generatorModel.sP(query.getInt(columnIndex3) + generatorModel.HiB());
                                                }
                                                int columnIndex4 = query.getColumnIndex("fail_count");
                                                if (columnIndex4 >= 0) {
                                                    generatorModel.TKC(query.getInt(columnIndex4) + generatorModel.vS());
                                                }
                                                int columnIndex5 = query.getColumnIndex(CampaignEx.JSON_KEY_TIMESTAMP);
                                                if (columnIndex5 >= 0) {
                                                    generatorModel.sP(Math.min(query.getLong(columnIndex5), generatorModel.TEQ()));
                                                }
                                            }
                                            query.close();
                                        }
                                        ContentValues contentValues = new ContentValues();
                                        if (generatorModel.Sj() > 0) {
                                            contentValues.put("_id", Long.valueOf(generatorModel.Sj()));
                                        }
                                        contentValues.put("sdk_version", generatorModel.sP());
                                        contentValues.put(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, generatorModel.TKC());
                                        contentValues.put("start_count", Integer.valueOf(generatorModel.EjP()));
                                        contentValues.put("success_count", Integer.valueOf(generatorModel.HiB()));
                                        contentValues.put("fail_count", Integer.valueOf(generatorModel.vS()));
                                        contentValues.put("rit", generatorModel.Jcg());
                                        contentValues.put("tag", generatorModel.Dq());
                                        contentValues.put("label", generatorModel.uA());
                                        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(generatorModel.TEQ()));
                                        contentValues.put("mediation", generatorModel.Ym());
                                        contentValues.put("is_init", Integer.valueOf(generatorModel.aa()));
                                        contentValues.put("extra", generatorModel.Fmk());
                                        Sj.insertWithOnConflict("monitor_table", null, contentValues, 5);
                                    }
                                }
                                new StringBuilder("exec save size = ").append(list.size());
                                Sj.setTransactionSuccessful();
                            } catch (Throwable th2) {
                                th = th2;
                                sQLiteDatabase = Sj;
                                try {
                                    Log.e("BusMonitorCenter", th.getMessage());
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.endTransaction();
                                        return;
                                    }
                                    return;
                                } finally {
                                }
                            }
                        }
                        sQLiteDatabase = Sj;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable th4) {
            Log.e("BusMonitorCenter", th4.getMessage());
        }
    }

    private boolean TKC() {
        if (this.TKC == null) {
            sP sPVar = this.Sj;
            if (sPVar == null || sPVar.getContext() == null || this.Sj.getHandler() == null) {
                return false;
            }
        } else {
            sP sPVar2 = this.Sj;
            if (sPVar2 == null || sPVar2.getContext() == null || !this.Sj.isMonitorOpen() || this.Sj.getHandler() == null) {
                return false;
            }
        }
        return true;
    }

    public void Sj(final EjP ejP) {
        if (ejP == null || !TKC()) {
            return;
        }
        this.Sj.getHandler().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.dNu.Sj.1
            @Override // java.lang.Runnable
            public void run() {
                Sj sj2 = Sj.this;
                sj2.TKC = Boolean.valueOf(sj2.Sj.isMonitorOpen());
                if (Sj.this.TKC.booleanValue()) {
                    Sj.this.Jcg.add(ejP);
                    if (Sj.this.Jcg.size() >= 10) {
                        Sj sj3 = Sj.this;
                        sj3.Sj(sj3.Jcg);
                        Sj.this.Jcg.clear();
                    }
                }
            }
        });
        this.Sj.getHandler().removeCallbacks(this.Dq);
        this.Sj.getHandler().postDelayed(this.Dq, 5000L);
    }

    public void Sj(final boolean z10) {
        sP sPVar = this.Sj;
        if (sPVar == null || sPVar.getHandler() == null || this.Sj.getContext() == null || this.sP == null || !this.Sj.isMonitorOpen()) {
            return;
        }
        this.Sj.getHandler().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.dNu.Sj.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Sj.EjP(Sj.this);
                    if (z10) {
                        long Sj = Sj.this.sP.Sj();
                        if (Sj == 0) {
                            Sj.this.sP.Sj(System.currentTimeMillis());
                            return;
                        } else if (Sj.HiB - Sj < Sj.this.Sj.getUploadIntervalTime()) {
                            return;
                        }
                    }
                    if (Sj.this.Sj.getHandler() != null) {
                        Sj.this.Sj.getHandler().post(Sj.this.uA);
                    }
                } catch (Throwable th2) {
                    Log.e("BusMonitorCenter", th2.getMessage());
                }
            }
        }, Math.max(this.Sj.getOnceLogInterval(), 10000));
    }
}
