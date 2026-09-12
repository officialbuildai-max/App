package com.cloud.hisavana.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.common.util.g;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class P {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f21609a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f21610b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f21611a;

        a(String str) {
            this.f21611a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e4.b().d("CloudProviderManager", "updateConfigShowTimes " + this.f21611a);
            if (TextUtils.isEmpty(this.f21611a)) {
                return;
            }
            try {
                ConfigCodeSeatDTO h11 = P.this.h(this.f21611a);
                if (h11 != null) {
                    h11.setCurrentShowTimes(h11.getCurrentShowTimes() + 1);
                    h11.setLastShowAdTime(System.currentTimeMillis());
                    P.this.j(h11);
                } else {
                    e4.b().e("CloudProviderManager", "updateConfigShowTimes,can't find codeSeatId " + this.f21611a);
                }
            } catch (Exception e11) {
                e4.b().e("CloudProviderManager", "updateConfigShowTimes " + Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ContentValues f21613a;

        b(ContentValues contentValues) {
            this.f21613a = contentValues;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int update = com.cloud.sdk.commonutil.util.e.a().getContentResolver().update(P.this.f21609a, this.f21613a, null, null);
                e4.b().d("CloudProviderManager", "updateConfigData result " + update);
            } catch (Exception e11) {
                e4.b().d("CloudProviderManager", "updateConfigData " + Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final P f21615a = new P(null);
    }

    private P() {
        this.f21610b = new ConcurrentHashMap();
        this.f21609a = Uri.parse("content://" + com.cloud.sdk.commonutil.util.e.a().getPackageName() + ".HisavanaContentProvider/config");
    }

    /* synthetic */ P(a aVar) {
        this();
    }

    private void e(ConfigCodeSeatDTO configCodeSeatDTO, List list) {
        if (configCodeSeatDTO == null) {
            return;
        }
        long parseLong = Long.parseLong(configCodeSeatDTO.getDate());
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - parseLong) > 86400000) {
            configCodeSeatDTO.setDate(String.valueOf(com.cloud.hisavana.sdk.common.util.l0.c(currentTimeMillis)));
            configCodeSeatDTO.setCurrentShowTimes(0);
            if (list != null) {
                list.add(configCodeSeatDTO);
            }
        }
    }

    public static P g() {
        return c.f21615a;
    }

    public ConfigCodeSeatDTO b(ConfigCodeSeatDTO configCodeSeatDTO) {
        ConfigCodeSeatDTO configCodeSeatDTO2 = null;
        if (configCodeSeatDTO == null) {
            return null;
        }
        if (TextUtils.isEmpty(configCodeSeatDTO.getJson())) {
            return configCodeSeatDTO;
        }
        try {
            configCodeSeatDTO2 = (ConfigCodeSeatDTO) GsonUtil.a(configCodeSeatDTO.getJson(), ConfigCodeSeatDTO.class);
        } catch (GsonUtil.GsonParseException unused) {
            e4.b().e("CloudProviderManager", "");
        }
        if (configCodeSeatDTO2 != null) {
            this.f21610b.put(configCodeSeatDTO.getCodeSeatId(), configCodeSeatDTO2);
        }
        return configCodeSeatDTO2;
    }

    public ConfigCodeSeatDTO c(String str) {
        e4.b().d("CloudProviderManager", "getConfigById " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!l()) {
            d();
            Map map = this.f21610b;
            if (map == null || map.isEmpty()) {
                return null;
            }
        }
        try {
            ConfigCodeSeatDTO b11 = b((ConfigCodeSeatDTO) this.f21610b.get(str));
            e(b11, null);
            return b11;
        } catch (Exception e11) {
            e4.b().e("CloudProviderManager", "getConfigById " + Log.getStackTraceString(e11));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0086, code lost:
    
        if (r0 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0096, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
    
        if (r0 == null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map d() {
        /*
            r9 = this;
            boolean r0 = r9.l()
            java.lang.String r1 = "CloudProviderManager"
            if (r0 != 0) goto La0
            com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()
            java.lang.String r2 = "getAllConfig, memory cache is null, query from disk"
            r0.d(r1, r2)
            r0 = 0
            android.content.Context r2 = com.cloud.sdk.commonutil.util.e.a()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r6 = "select * from cloudList_room"
            android.net.Uri r4 = r9.f21609a     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r7 = 0
            r8 = 0
            r5 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r0 == 0) goto L86
        L27:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r2 == 0) goto L86
            java.lang.String r2 = "code_seat_bean"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r3 = ""
            if (r2 < 0) goto L40
            java.lang.String r3 = r0.getString(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            goto L40
        L3c:
            r1 = move-exception
            goto L9a
        L3e:
            r2 = move-exception
            goto L89
        L40:
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r2 == 0) goto L47
            goto L27
        L47:
            com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO r2 = new com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r2.<init>()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r2.setJson(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r3 = "codeSeatId"
            int r3 = r0.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r3 < 0) goto L5e
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r2.setCodeSeatId(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
        L5e:
            java.lang.String r3 = "current_codeseat_show_times"
            int r3 = r0.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r3 < 0) goto L6d
            int r3 = r0.getInt(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r2.setCurrentShowTimes(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
        L6d:
            java.lang.String r3 = "datetime"
            int r3 = r0.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r3 < 0) goto L7c
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r2.setDate(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
        L7c:
            java.util.Map r3 = r9.f21610b     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r4 = r2.getCodeSeatId()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r3.put(r4, r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            goto L27
        L86:
            if (r0 == 0) goto La9
            goto L96
        L89:
            com.cloud.hisavana.sdk.e4 r3 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = android.util.Log.getStackTraceString(r2)     // Catch: java.lang.Throwable -> L3c
            r3.e(r1, r2)     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto La9
        L96:
            r0.close()
            goto La9
        L9a:
            if (r0 == 0) goto L9f
            r0.close()
        L9f:
            throw r1
        La0:
            com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()
            java.lang.String r2 = "getAllConfig, memory cache has value"
            r0.d(r1, r2)
        La9:
            com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getAllConfig, size="
            r2.append(r3)
            java.util.Map r3 = r9.f21610b
            int r3 = r3.size()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.d(r1, r2)
            java.util.Map r0 = r9.f21610b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.P.d():java.util.Map");
    }

    public boolean f(List list) {
        Map map;
        if (list == null || list.isEmpty()) {
            return false;
        }
        if (this.f21610b.isEmpty()) {
            d();
        }
        try {
            Collection values = this.f21610b.values();
            long currentTimeMillis = System.currentTimeMillis();
            if (values != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ConfigCodeSeatDTO configCodeSeatDTO = (ConfigCodeSeatDTO) it.next();
                    if (configCodeSeatDTO != null) {
                        Iterator it2 = values.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            ConfigCodeSeatDTO configCodeSeatDTO2 = (ConfigCodeSeatDTO) it2.next();
                            if (configCodeSeatDTO2 != null && TextUtils.equals(configCodeSeatDTO.getCodeSeatId(), configCodeSeatDTO2.getCodeSeatId())) {
                                ConfigCodeSeatDTO b11 = b(configCodeSeatDTO2);
                                if (Math.abs(currentTimeMillis - Long.parseLong(b11.getDate())) >= 86400000) {
                                    configCodeSeatDTO.setCurrentShowTimes(0);
                                    configCodeSeatDTO.setDate(String.valueOf(com.cloud.hisavana.sdk.common.util.l0.c(currentTimeMillis)));
                                } else {
                                    configCodeSeatDTO.setDate(b11.getDate());
                                    configCodeSeatDTO.setCurrentShowTimes(b11.getCurrentShowTimes());
                                }
                                configCodeSeatDTO.setLastRequestAdTime(b11.getLastRequestAdTime());
                                configCodeSeatDTO.setAdRequestFail(b11.isAdRequestFail());
                                configCodeSeatDTO.setLastShowAdTime(b11.getLastShowAdTime());
                                configCodeSeatDTO.setAdRequestVer(b11.getAdRequestVer());
                                configCodeSeatDTO.setLocalOfflineAdCacheCount(b11.getLocalOfflineAdCacheCount());
                            }
                        }
                    }
                }
                this.f21610b.clear();
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                ConfigCodeSeatDTO configCodeSeatDTO3 = (ConfigCodeSeatDTO) it3.next();
                if (configCodeSeatDTO3 != null && (map = this.f21610b) != null) {
                    map.put(configCodeSeatDTO3.getCodeSeatId(), configCodeSeatDTO3);
                }
            }
            ContentResolver contentResolver = com.cloud.sdk.commonutil.util.e.a().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("CloudConfig", GsonUtil.d(list));
            return contentResolver.insert(this.f21609a, contentValues).toString().contains("true");
        } catch (Exception e11) {
            e4.b().e("CloudProviderManager", Log.getStackTraceString(e11));
            return false;
        }
    }

    public ConfigCodeSeatDTO h(String str) {
        return (ConfigCodeSeatDTO) this.f21610b.get(str);
    }

    public void i(ConfigCodeSeatDTO configCodeSeatDTO) {
        AdsDTO adsDTO;
        if (configCodeSeatDTO == null) {
            return;
        }
        String[] strArr = {configCodeSeatDTO.getCodeSeatId(), "1", configCodeSeatDTO.getCodeSeatId(), "1"};
        if (e4.c()) {
            e4.b().d("CloudProviderManager", "update config offline ad count------> code seat id:" + configCodeSeatDTO.getCodeSeatId() + ", selection: SELECT ad_bean FROM adList_room WHERE codeSeatId = ? AND is_offline_ad = ? AND ad_request_ver = ( SELECT MAX(ad_request_ver) FROM adList_room WHERE codeSeatId = ? AND is_offline_ad = ?);, selectionArgs: " + Arrays.toString(strArr));
        }
        try {
            Cursor query = com.cloud.sdk.commonutil.util.e.a().getContentResolver().query(this.f21609a, null, "SELECT ad_bean FROM adList_room WHERE codeSeatId = ? AND is_offline_ad = ? AND ad_request_ver = ( SELECT MAX(ad_request_ver) FROM adList_room WHERE codeSeatId = ? AND is_offline_ad = ?);", strArr, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                    return;
                }
                return;
            }
            int i11 = 0;
            while (query.moveToNext()) {
                try {
                    int columnIndex = query.getColumnIndex("ad_bean");
                    if (columnIndex >= 0) {
                        String string = query.getString(columnIndex);
                        if (!TextUtils.isEmpty(string)) {
                            try {
                                adsDTO = (AdsDTO) GsonUtil.a(string, AdsDTO.class);
                            } catch (Throwable unused) {
                                adsDTO = null;
                            }
                            if (adsDTO != null && !g.b(adsDTO)) {
                                i11++;
                            }
                        }
                    }
                } finally {
                }
            }
            e4.b().d("CloudProviderManager", "updateCodeOfflineAdCount ----> offline ad count is " + i11);
            configCodeSeatDTO.setLocalOfflineAdCacheCount(i11);
            query.close();
        } catch (Exception e11) {
            e4.b().e("CloudProviderManager", "updateCodeOfflineAdCount error: " + e11.getMessage());
        }
    }

    public void j(ConfigCodeSeatDTO configCodeSeatDTO) {
        if (configCodeSeatDTO == null || configCodeSeatDTO.isDefaultConfig().booleanValue()) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        ArrayList arrayList = new ArrayList();
        arrayList.add(configCodeSeatDTO);
        contentValues.put("CloudConfig", GsonUtil.d(arrayList));
        HSScopeHelper.f23249a.i(new b(contentValues));
    }

    public void k(String str) {
        HSScopeHelper.f23249a.i(new a(str));
    }

    public boolean l() {
        Map map = this.f21610b;
        return (map == null || map.isEmpty()) ? false : true;
    }
}
