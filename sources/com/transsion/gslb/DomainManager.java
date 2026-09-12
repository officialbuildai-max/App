package com.transsion.gslb;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.gslb.GslbSdk;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class DomainManager {
    public static final String BLANK_DOMAIN = "blank";
    public static volatile DomainManager INSTANCE;
    public String filePath;
    public long lastSyncTime;
    public String sp_name = "gslb_";
    public String lastGaid = "";
    public String countryCode = "";
    public long firstSyncTryTime = 0;
    public long syncTimes = 0;
    public final long SYNC_TRY_TIMES = 4;
    public final String SEPARATOR = UrlUtils.AND_MARK;
    public Map<String, String> domainMap = new ConcurrentHashMap();
    public List<ListenerBean> listenerBeans = new ArrayList();
    public long syncInterval = 86400000;

    public DomainManager() {
        this.sp_name += Utils.getCurProcessName(GslbSdk.getContext());
        this.filePath = GslbSdk.getContext().getFilesDir().getPath() + File.separator + this.sp_name;
        read();
        if (this.domainMap.size() == 0) {
            this.domainMap.put("dsu.shalltry.com", BLANK_DOMAIN);
            this.domainMap.put("dsc.shalltry.com", BLANK_DOMAIN);
            this.domainMap.put("api.twibida.com", BLANK_DOMAIN);
        }
        checkSync();
    }

    public static DomainManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DomainManager.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new DomainManager();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    private boolean isDomain(String str) {
        return (TextUtils.isEmpty(str) || str.equals(BLANK_DOMAIN)) ? false : true;
    }

    private void read() {
        String[] split = Utils.bufferRead(new File(this.filePath)).split(UrlUtils.AND_MARK);
        if (split.length < 4) {
            return;
        }
        try {
            this.domainMap = Utils.stringToMap(split[0]);
            this.lastGaid = split[1];
            this.syncInterval = Long.parseLong(split[2]);
            this.lastSyncTime = Long.parseLong(split[3]);
            this.countryCode = split[4];
        } catch (Throwable unused) {
        }
    }

    private void write() {
        Utils.bufferSave(this.filePath, Utils.mapToString(this.domainMap) + UrlUtils.AND_MARK + this.lastGaid + UrlUtils.AND_MARK + this.syncInterval + UrlUtils.AND_MARK + this.lastSyncTime + UrlUtils.AND_MARK + this.countryCode);
    }

    public void addListener(ListenerBean listenerBean) {
        GslbSdk.ResultListener resultListener;
        GslbSdk.GetDomainListener getDomainListener;
        GslbSdk.ResultListener resultListener2;
        GslbSdk.GetDomainListener getDomainListener2;
        GslbSdk.InitListener initListener;
        GslbSdk.GslbInitListener gslbInitListener;
        GslbSdk.InitListener initListener2;
        GslbSdk.GslbInitListener gslbInitListener2;
        if (listenerBean.domains == null) {
            String str = listenerBean.url;
            if (str != null && listenerBean.resultListener != null) {
                String domain = Utils.getDomain(str);
                String str2 = this.domainMap.get(domain);
                if (!isDomain(str2)) {
                    this.listenerBeans.add(listenerBean);
                    return;
                }
                boolean z10 = listenerBean.isNewDomainListener;
                if (z10 && (getDomainListener2 = listenerBean.gslbDomainListener) != null) {
                    getDomainListener2.onGslbSuccess(listenerBean.url.replace(domain, str2));
                    return;
                } else {
                    if (z10 || (resultListener2 = listenerBean.resultListener) == null) {
                        return;
                    }
                    resultListener2.onGslbSuccess(listenerBean.url.replace(domain, str2));
                    return;
                }
            }
            if (str == null || listenerBean.gslbDomainListener == null) {
                return;
            }
            String domain2 = Utils.getDomain(str);
            String str3 = this.domainMap.get(domain2);
            if (!isDomain(str3)) {
                this.listenerBeans.add(listenerBean);
                return;
            }
            boolean z11 = listenerBean.isNewDomainListener;
            if (z11 && (getDomainListener = listenerBean.gslbDomainListener) != null) {
                getDomainListener.onGslbSuccess(listenerBean.url.replace(domain2, str3));
                return;
            } else {
                if (z11 || (resultListener = listenerBean.resultListener) == null) {
                    return;
                }
                resultListener.onGslbSuccess(listenerBean.url.replace(domain2, str3));
                return;
            }
        }
        boolean z12 = true;
        int i11 = 0;
        boolean z13 = false;
        boolean z14 = false;
        while (true) {
            String[] strArr = listenerBean.domains;
            if (i11 >= strArr.length) {
                break;
            }
            strArr[i11] = Utils.getDomain(strArr[i11]);
            if (!TextUtils.isEmpty(listenerBean.domains[i11])) {
                String str4 = this.domainMap.get(listenerBean.domains[i11]);
                if (str4 == null) {
                    this.domainMap.put(listenerBean.domains[i11], BLANK_DOMAIN);
                    z13 = true;
                } else if (!isDomain(str4)) {
                    z14 = true;
                }
                z12 = false;
            }
            i11++;
        }
        if (z12) {
            boolean z15 = listenerBean.isNewInitListener;
            if (z15 && (gslbInitListener2 = listenerBean.gslbInitListener) != null) {
                gslbInitListener2.onInitFail("all domains are empty");
            } else if (!z15 && (initListener2 = listenerBean.initListener) != null) {
                initListener2.onInitFail();
            }
        } else if (z13) {
            write();
        } else if (!z14 && !TextUtils.isEmpty(getCountry())) {
            boolean z16 = listenerBean.isNewInitListener;
            if (z16 && (gslbInitListener = listenerBean.gslbInitListener) != null) {
                gslbInitListener.onInitSuccess(new HashMap(this.domainMap));
                return;
            } else {
                if (z16 || (initListener = listenerBean.initListener) == null) {
                    return;
                }
                initListener.onInitSuccess(new HashMap(this.domainMap));
                return;
            }
        }
        this.listenerBeans.add(listenerBean);
    }

    public void checkAllListener() {
        for (ListenerBean listenerBean : this.listenerBeans) {
            if (listenerBean.domains != null) {
                boolean z10 = false;
                int i11 = 0;
                while (true) {
                    String[] strArr = listenerBean.domains;
                    if (i11 >= strArr.length) {
                        break;
                    }
                    if (this.domainMap.containsKey(strArr[i11]) && !isDomain(this.domainMap.get(listenerBean.domains[i11]))) {
                        z10 = true;
                        break;
                    }
                    i11++;
                }
                GslbSdk.InitListener initListener = listenerBean.initListener;
                if (initListener != null) {
                    if (z10) {
                        initListener.onInitFail();
                    } else {
                        initListener.onInitSuccess(new HashMap(this.domainMap));
                    }
                }
            } else {
                String str = listenerBean.url;
                if (str != null && listenerBean.resultListener != null) {
                    String domain = Utils.getDomain(str);
                    String str2 = this.domainMap.get(domain);
                    if (isDomain(str2)) {
                        listenerBean.resultListener.onGslbSuccess(listenerBean.url.replace(domain, str2));
                    } else {
                        listenerBean.resultListener.onGslbFail();
                    }
                }
            }
        }
        this.listenerBeans.clear();
    }

    public void checkSync() {
        Worker worker;
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(this.firstSyncTryTime - currentTimeMillis) > 86400000) {
            this.syncTimes = 0L;
        }
        long j11 = this.lastSyncTime;
        if (j11 <= 0 || Math.abs(currentTimeMillis - j11) <= this.syncInterval) {
            return;
        }
        long j12 = this.syncTimes;
        if (j12 == 0) {
            this.firstSyncTryTime = currentTimeMillis;
        }
        if (j12 < 4 && (worker = GslbSdk.getWorker()) != null) {
            worker.syncData();
        }
        this.syncTimes++;
    }

    public List<String> getAllDomains() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = this.domainMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    public List<String> getBlankDomains() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.domainMap.entrySet()) {
            if (!isDomain(entry.getValue())) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public String getCountry() {
        return this.countryCode;
    }

    public String getDomain(String str) {
        String str2 = this.domainMap.get(str);
        checkSync();
        return str2;
    }

    public String getLastGaid() {
        return this.lastGaid;
    }

    public void mergeResult(Map<String, String> map, boolean z10) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!isDomain(this.domainMap.get(entry.getKey())) || z10) {
                this.domainMap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x0189, code lost:
    
        if (r2.isNewDomainListener == false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x018b, code lost:
    
        r2 = r2.gslbDomainListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x018d, code lost:
    
        if (r2 == null) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x018f, code lost:
    
        r2.onGslbFail("get domain exception " + r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f1, code lost:
    
        if (r1.isNewDomainListener == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f5, code lost:
    
        if (r1.gslbDomainListener == null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f7, code lost:
    
        r2 = com.transsion.gslb.Utils.getDomain(r2);
        r3 = r10.domainMap.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0107, code lost:
    
        if (isDomain(r3) == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0116, code lost:
    
        r1.gslbDomainListener.onGslbFail("the mapping result is empty for " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0109, code lost:
    
        r1.gslbDomainListener.onGslbSuccess(r1.url.replace(r2, r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void notifyListener() {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.gslb.DomainManager.notifyListener():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        if (r2.isNewDomainListener == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
    
        r2 = r2.gslbDomainListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        if (r2 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        r2.onGslbFail("no network");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00af, code lost:
    
        if (r2.isNewDomainListener == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00b1, code lost:
    
        r2 = r2.gslbDomainListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b3, code lost:
    
        if (r2 == null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b5, code lost:
    
        r2.onGslbFail("get domain exception " + r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void notifyNoNetwork() {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Exception -> L23
            r0.<init>()     // Catch: java.lang.Exception -> L23
            java.util.List<com.transsion.gslb.ListenerBean> r1 = r6.listenerBeans     // Catch: java.lang.Exception -> L23
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L23
        Lb:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L23
            if (r2 == 0) goto L4f
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L23
            com.transsion.gslb.ListenerBean r2 = (com.transsion.gslb.ListenerBean) r2     // Catch: java.lang.Exception -> L23
            boolean r3 = r2.isNewInitListener     // Catch: java.lang.Exception -> L23
            if (r3 != 0) goto L25
            com.transsion.gslb.GslbSdk$InitListener r4 = r2.initListener     // Catch: java.lang.Exception -> L23
            if (r4 == 0) goto L25
            r0.add(r2)     // Catch: java.lang.Exception -> L23
            goto Lb
        L23:
            r0 = move-exception
            goto L5b
        L25:
            if (r3 == 0) goto L2f
            com.transsion.gslb.GslbSdk$GslbInitListener r3 = r2.gslbInitListener     // Catch: java.lang.Exception -> L23
            if (r3 == 0) goto L2f
            r0.add(r2)     // Catch: java.lang.Exception -> L23
            goto Lb
        L2f:
            java.lang.String r3 = r2.url     // Catch: java.lang.Exception -> L23
            if (r3 == 0) goto L3f
            boolean r4 = r2.isNewDomainListener     // Catch: java.lang.Exception -> L23
            if (r4 != 0) goto L3f
            com.transsion.gslb.GslbSdk$ResultListener r4 = r2.resultListener     // Catch: java.lang.Exception -> L23
            if (r4 == 0) goto L3f
            r4.onGslbFail()     // Catch: java.lang.Exception -> L23
            goto Lb
        L3f:
            if (r3 == 0) goto Lb
            boolean r3 = r2.isNewDomainListener     // Catch: java.lang.Exception -> L23
            if (r3 == 0) goto Lb
            com.transsion.gslb.GslbSdk$GetDomainListener r2 = r2.gslbDomainListener     // Catch: java.lang.Exception -> L23
            if (r2 == 0) goto Lb
            java.lang.String r3 = "no network"
            r2.onGslbFail(r3)     // Catch: java.lang.Exception -> L23
            goto Lb
        L4f:
            java.util.List<com.transsion.gslb.ListenerBean> r1 = r6.listenerBeans     // Catch: java.lang.Exception -> L23
            r1.clear()     // Catch: java.lang.Exception -> L23
            java.util.List<com.transsion.gslb.ListenerBean> r1 = r6.listenerBeans     // Catch: java.lang.Exception -> L23
            r1.addAll(r0)     // Catch: java.lang.Exception -> L23
            goto Ld1
        L5b:
            r0.printStackTrace()
            java.util.List<com.transsion.gslb.ListenerBean> r1 = r6.listenerBeans
            java.util.Iterator r1 = r1.iterator()
        L64:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lcc
            java.lang.Object r2 = r1.next()
            com.transsion.gslb.ListenerBean r2 = (com.transsion.gslb.ListenerBean) r2
            boolean r3 = r2.isNewInitListener
            if (r3 != 0) goto L7c
            com.transsion.gslb.GslbSdk$InitListener r4 = r2.initListener
            if (r4 == 0) goto L7c
            r4.onInitFail()
            goto L64
        L7c:
            java.lang.String r4 = "get domain exception "
            if (r3 == 0) goto L9b
            com.transsion.gslb.GslbSdk$GslbInitListener r3 = r2.gslbInitListener
            if (r3 == 0) goto L9b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r4 = r0.toString()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r3.onInitFail(r2)
            goto L64
        L9b:
            java.lang.String r3 = r2.url
            if (r3 == 0) goto Lab
            boolean r5 = r2.isNewDomainListener
            if (r5 != 0) goto Lab
            com.transsion.gslb.GslbSdk$ResultListener r5 = r2.resultListener
            if (r5 == 0) goto Lab
            r5.onGslbFail()
            goto L64
        Lab:
            if (r3 == 0) goto L64
            boolean r3 = r2.isNewDomainListener
            if (r3 == 0) goto L64
            com.transsion.gslb.GslbSdk$GetDomainListener r2 = r2.gslbDomainListener
            if (r2 == 0) goto L64
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r4 = r0.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.onGslbFail(r3)
            goto L64
        Lcc:
            java.util.List<com.transsion.gslb.ListenerBean> r0 = r6.listenerBeans
            r0.clear()
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.gslb.DomainManager.notifyNoNetwork():void");
    }

    public void reset() {
        this.domainMap.clear();
        this.domainMap.put("dsu.shalltry.com", BLANK_DOMAIN);
        this.domainMap.put("dsc.shalltry.com", BLANK_DOMAIN);
        this.domainMap.put("api.twibida.com", BLANK_DOMAIN);
    }

    public boolean reset(String str) {
        try {
            this.domainMap.remove(str);
            return true;
        } catch (Exception e11) {
            Utils.LOG.i("reset exception" + e11.toString());
            return false;
        }
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setLastGaid(String str) {
        this.lastGaid = str;
    }

    public void setSyncInterval(long j11) {
        this.syncInterval = j11;
        if (j11 < 86400000) {
            this.syncInterval = 86400000L;
        }
        this.lastSyncTime = System.currentTimeMillis();
    }

    public boolean updateNetData(String str, String str2) {
        boolean z10;
        String str3;
        setLastGaid(str2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i11 = jSONObject.getInt("code");
            String string = jSONObject.getString("message");
            if (i11 != 200) {
                Utils.LOG.i("error message is " + string);
                return false;
            }
            HashMap hashMap = new HashMap(4);
            long j11 = 86400000;
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                JSONObject jSONObject3 = jSONObject2.getJSONObject("domainPairs");
                z10 = jSONObject2.getBoolean("overrideFlag");
                try {
                    j11 = jSONObject2.getInt("expireTime");
                    Iterator<String> keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String valueOf = String.valueOf(keys.next());
                        hashMap.put(valueOf, jSONObject3.getString(valueOf));
                    }
                    str3 = jSONObject2.getString(PlaceTypes.COUNTRY);
                } catch (Exception e11) {
                    e = e11;
                    Utils.LOG.i(Log.getStackTraceString(e));
                    str3 = "";
                    mergeResult(hashMap, z10);
                    setSyncInterval(j11);
                    setCountryCode(str3);
                    write();
                    return true;
                }
            } catch (Exception e12) {
                e = e12;
                z10 = false;
            }
            mergeResult(hashMap, z10);
            setSyncInterval(j11);
            setCountryCode(str3);
            write();
            return true;
        } catch (JSONException e13) {
            e13.printStackTrace();
            return false;
        }
    }
}
