package com.bytedance.sdk.openadsdk.EjP.Sj;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.Zq.TKC.TKC;
import com.bytedance.sdk.openadsdk.core.RiZ;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.ib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TEQ implements com.bytedance.sdk.component.vS.Sj.sP.TKC {
    public RiZ<com.bytedance.sdk.openadsdk.EjP.Sj> Sj;
    private final TKC sP = TKC.Sj();

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, List<com.bytedance.sdk.component.vS.Sj.EjP.Sj>> EjP(List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list) {
        HashMap<String, List<com.bytedance.sdk.component.vS.Sj.EjP.Sj>> hashMap = new HashMap<>();
        new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2 = list.get(i11);
            JSONObject Jcg = sj2.Jcg();
            if (Jcg != null) {
                String optString = Jcg.optString("app_log_url");
                List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list2 = hashMap.get(optString);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    hashMap.put(optString, list2);
                }
                list2.add(sj2);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sj(List<com.bytedance.sdk.openadsdk.EjP.Sj> list, com.bytedance.sdk.openadsdk.EjP.HiB hiB) {
        int i11;
        return !TKC(list) && (i11 = hiB.sP) >= 400 && i11 < 500;
    }

    private boolean TKC(List<com.bytedance.sdk.openadsdk.EjP.Sj> list) {
        JSONObject TKC;
        if (list == null || list.size() == 0 || (TKC = list.get(0).TKC()) == null) {
            return true;
        }
        return TextUtils.isEmpty(TKC.optString("app_log_url"));
    }

    public com.bytedance.sdk.openadsdk.EjP.HiB Sj(List<com.bytedance.sdk.openadsdk.EjP.Sj> list) {
        if (this.Sj == null) {
            this.Sj = dNu.TKC();
        }
        if (this.Sj == null) {
            return null;
        }
        int gY = com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().gY();
        if (3 == gY) {
            return this.Sj.Sj(this.sP.Sj(this.sP.Sj(list, false), System.currentTimeMillis(), this.sP.sP(), true), this.sP.Sj(list), true);
        }
        if (2 != gY) {
            return this.Sj.Sj(this.sP.Sj(list, System.currentTimeMillis(), this.sP.sP(), false), this.sP.Sj(list), false);
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject sP = this.sP.sP();
        this.Sj.Sj(this.sP.Sj(this.sP.Sj(list, true), currentTimeMillis, sP, true), this.sP.Sj(list), true);
        return this.Sj.Sj(this.sP.Sj(this.sP.sP(list), currentTimeMillis, sP, false), this.sP.Sj(list), false);
    }

    @Override // com.bytedance.sdk.component.vS.Sj.sP.TKC
    public void Sj(final List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list, @Nullable final com.bytedance.sdk.component.vS.Sj.sP.sP sPVar) {
        com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2;
        if (list == null || list.isEmpty() || !dNu.EjP().zwV() || (sj2 = list.get(0)) == null) {
            return;
        }
        byte EjP = sj2.EjP();
        final ArrayList arrayList = new ArrayList();
        if (EjP == 0) {
            com.bytedance.sdk.openadsdk.dNu.TKC.Sj(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.1
                @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                    com.bytedance.sdk.openadsdk.dNu.sP.Sj sj3 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                    sj3.sP("applog");
                    return sj3;
                }
            });
            JcM.Sj(new com.bytedance.sdk.component.Dq.TKC.sP(7, "upload_ad_event") { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it;
                    try {
                        it = TEQ.this.EjP(list).entrySet().iterator();
                    } catch (Throwable th2) {
                        sU.sP("OverSeaEventUploadImp", th2.getMessage());
                        it = null;
                    }
                    if (it == null) {
                        com.bytedance.sdk.component.vS.Sj.sP.sP sPVar2 = sPVar;
                        if (sPVar2 != null) {
                            sPVar2.Sj(arrayList);
                            return;
                        }
                        return;
                    }
                    while (it.hasNext()) {
                        try {
                            Sj.Sj(Sj.EjP);
                            List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list2 = (List) ((Map.Entry) it.next()).getValue();
                            ArrayList arrayList2 = new ArrayList();
                            for (com.bytedance.sdk.component.vS.Sj.EjP.Sj sj3 : list2) {
                                arrayList2.add(new com.bytedance.sdk.openadsdk.EjP.Sj(sj3.TKC(), sj3.Jcg()));
                            }
                            com.bytedance.sdk.openadsdk.EjP.HiB Sj = TEQ.this.Sj(arrayList2);
                            if (sPVar != null && Sj != null) {
                                boolean z10 = Sj.EjP;
                                if (TEQ.this.Sj(arrayList2, Sj)) {
                                    z10 = true;
                                }
                                arrayList.add(new com.bytedance.sdk.component.vS.Sj.sP.TKC.Sj(new com.bytedance.sdk.component.vS.Sj.sP.TKC.sP(Sj.Sj, Sj.sP, Sj.TKC, z10, ""), list2));
                                if (Sj.sP == 200) {
                                    Sj.Sj(Sj.EjP, true);
                                    com.bytedance.sdk.openadsdk.dNu.TKC.sP(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.2.1
                                        @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                        public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                            com.bytedance.sdk.openadsdk.dNu.sP.Sj sj4 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                            sj4.sP("applog");
                                            return sj4;
                                        }
                                    });
                                } else if (z10) {
                                    Sj.Sj(Sj.EjP, false);
                                    com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.2.2
                                        @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                        public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                            com.bytedance.sdk.openadsdk.dNu.sP.Sj sj4 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                            sj4.sP("applog");
                                            return sj4;
                                        }
                                    });
                                } else {
                                    com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.2.3
                                        @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                        public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                            com.bytedance.sdk.openadsdk.dNu.sP.Sj sj4 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                            sj4.sP("applog");
                                            return sj4;
                                        }
                                    });
                                }
                            }
                            if (sPVar != null && Sj == null) {
                                com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.2.4
                                    @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                    public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                        com.bytedance.sdk.openadsdk.dNu.sP.Sj sj4 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                        sj4.sP("applog");
                                        return sj4;
                                    }
                                });
                            }
                        } catch (Throwable th3) {
                            sU.sP("OverSeaEventUploadImp", th3.getMessage());
                        }
                    }
                    com.bytedance.sdk.component.vS.Sj.sP.sP sPVar3 = sPVar;
                    if (sPVar3 != null) {
                        sPVar3.Sj(arrayList);
                    }
                }
            });
            return;
        }
        if (EjP == 1) {
            final ArrayList arrayList2 = new ArrayList();
            for (com.bytedance.sdk.component.vS.Sj.EjP.Sj sj3 : list) {
                arrayList2.add(new TKC.Sj(sj3.TKC(), sj3.Jcg()));
            }
            Sj.Sj(Sj.HiB);
            if (arrayList2.size() > 0) {
                com.bytedance.sdk.openadsdk.dNu.TKC.Sj(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.3
                    @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                    public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                        com.bytedance.sdk.openadsdk.dNu.sP.Sj sj4 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                        sj4.sP("stats");
                        return sj4;
                    }
                });
                JcM.Sj(new com.bytedance.sdk.component.Dq.TKC.sP(6, "upload_stats_event") { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.4
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.EjP.HiB sP = TEQ.this.sP(arrayList2);
                        if (sPVar != null && sP != null) {
                            arrayList.add(new com.bytedance.sdk.component.vS.Sj.sP.TKC.Sj(new com.bytedance.sdk.component.vS.Sj.sP.TKC.sP(sP.Sj, sP.sP, sP.TKC, sP.EjP, ""), list));
                            sPVar.Sj(arrayList);
                            if (sP.sP == 200) {
                                Sj.Sj(Sj.HiB, true);
                                com.bytedance.sdk.openadsdk.dNu.TKC.sP(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.4.1
                                    @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                    public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                        com.bytedance.sdk.openadsdk.dNu.sP.Sj sj4 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                        sj4.sP("stats");
                                        return sj4;
                                    }
                                });
                            } else if (sP.EjP) {
                                Sj.Sj(Sj.HiB, false);
                                com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.4.2
                                    @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                    public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                        com.bytedance.sdk.openadsdk.dNu.sP.Sj sj4 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                        sj4.sP("stats");
                                        return sj4;
                                    }
                                });
                            } else {
                                com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.4.3
                                    @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                                    public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                        com.bytedance.sdk.openadsdk.dNu.sP.Sj sj4 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                        sj4.sP("stats");
                                        return sj4;
                                    }
                                });
                            }
                        }
                        if (sPVar == null || sP != null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.dNu.TKC.TKC(new com.bytedance.sdk.openadsdk.dNu.EjP() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.TEQ.4.4
                            @Override // com.bytedance.sdk.openadsdk.dNu.EjP
                            public com.bytedance.sdk.openadsdk.dNu.sP.Sj generatorModel() {
                                com.bytedance.sdk.openadsdk.dNu.sP.Sj sj4 = new com.bytedance.sdk.openadsdk.dNu.sP.Sj();
                                sj4.sP("stats");
                                return sj4;
                            }
                        });
                    }
                });
            }
        }
    }

    public com.bytedance.sdk.openadsdk.EjP.HiB sP(List<TKC.Sj> list) {
        if (this.Sj == null) {
            this.Sj = dNu.TKC();
        }
        if (list != null && list.size() != 0 && com.bytedance.sdk.openadsdk.core.settings.uA.Sj()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Iterator<TKC.Sj> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().sP);
                }
                jSONObject.put("stats_list", jSONArray);
                long currentTimeMillis = System.currentTimeMillis();
                long j11 = currentTimeMillis / 1000;
                jSONObject.put("ts", j11);
                jSONObject.put("ts_ms", currentTimeMillis);
                String EjP = com.bytedance.sdk.openadsdk.core.uA.sP().EjP();
                if (EjP == null) {
                    EjP = "";
                }
                StringBuilder sb2 = new StringBuilder(ib.Sj());
                sb2.append("-");
                sb2.append(currentTimeMillis);
                jSONObject.put("req_sign", com.bytedance.sdk.component.utils.HiB.Sj(EjP + j11 + BuildConfig.VERSION_NAME));
                jSONObject.put("req_uniq", com.bytedance.sdk.component.utils.HiB.Sj(sb2.toString()));
                return this.Sj.sP(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
