package com.transsion.athena.hatnea;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.hatnea.aatnhe;
import com.transsion.ga.AthenaAnalytics;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class hatnea extends enatha {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f42838c;

    /* renamed from: d, reason: collision with root package name */
    private final String f42839d;

    /* renamed from: e, reason: collision with root package name */
    private final List<AppIdData> f42840e;

    /* renamed from: f, reason: collision with root package name */
    private final SparseArray<String> f42841f;

    /* renamed from: g, reason: collision with root package name */
    boolean f42842g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class athena {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f42843a;

        /* renamed from: b, reason: collision with root package name */
        public int f42844b;

        /* renamed from: c, reason: collision with root package name */
        public List<Integer> f42845c;

        private athena(byte[] bArr, int i11, List<Integer> list, int i12) {
            this.f42843a = bArr;
            this.f42844b = i11;
            this.f42845c = list;
        }

        public static athena a(byte[] bArr, int i11, List<Integer> list, int i12) {
            return new athena(bArr, i11, list, i12);
        }
    }

    public hatnea(Handler handler, String str, @NonNull List<AppIdData> list, boolean z10, @NonNull SparseArray<String> sparseArray) {
        super(handler);
        this.f42842g = false;
        this.f42839d = str;
        this.f42840e = list;
        this.f42838c = z10;
        this.f42841f = sparseArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.util.Pair<java.lang.String, java.util.List<com.transsion.athena.data.AppIdData>> a(long r22, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.hatnea.hatnea.a(long, java.lang.String):android.util.Pair");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(SparseArray sparseArray) {
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            com.transsion.athena.data.enatha enathaVar = (com.transsion.athena.data.enatha) sparseArray.valueAt(i11);
            Bundle bundle = new Bundle();
            bundle.putInt(SafeStringUtils.SP_APPID, enathaVar.f42755a);
            bundle.putString("date", enathaVar.f42756b);
            bundle.putInt("count", enathaVar.f42757c);
            bundle.putInt("packet", enathaVar.f42758d);
            new yi.a("day_up_record", 9999).c(bundle, null).b();
            if (com.transsion.athena.data.athena.b() > 0) {
                new yi.a("day_up_record", com.transsion.athena.data.athena.b()).c(bundle, null).b();
            }
        }
    }

    private void a(com.transsion.athena.config.data.model.athena athenaVar, String str, boolean z10) {
        int abs;
        if (z10) {
            try {
                String a11 = com.transsion.athena.taaneh.anehat.a();
                if (TextUtils.isEmpty(a11)) {
                    a11 = com.transsion.athena.taaneh.athena.b(AthenaAnalytics.J());
                }
                abs = (TextUtils.isEmpty(a11) || a11.hashCode() == 0) ? 1800000 : (Math.abs(a11.hashCode()) % 30) * 60000;
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b("Handle pull config exception after upload : %s", e11.getMessage());
                com.transsion.ga.anateh.a("handlePullConfig", e11);
                return;
            }
        } else {
            abs = 0;
        }
        athenaVar.d(str);
        athenaVar.c(0L);
        athenaVar.b(System.currentTimeMillis() + abs);
        com.transsion.athena.data.anateh.aethna.a(AthenaAnalytics.J()).a(athenaVar, false);
    }

    private void a(aatnhe aatnheVar, List<AppIdData> list, long j11, int i11) {
        TidConfigBean b11;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(com.transsion.athena.aethna.athena.c().f()));
        com.transsion.athena.data.anateh.aethna.a(AthenaAnalytics.J()).a(list, j11, calendar.get(1) + "-" + (calendar.get(2) + 1) + "-" + calendar.get(5), new com.transsion.athena.data.anateh.enatha() { // from class: com.transsion.athena.hatnea.e
            @Override // com.transsion.athena.data.anateh.enatha
            public final void a(Object obj) {
                hatnea.a((SparseArray) obj);
            }
        });
        if (com.transsion.athena.taaneh.anehat.b(AthenaAnalytics.J())) {
            k4.a.a(AthenaAnalytics.J()).g("first_launch", "false");
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", i11);
            jSONObject.put("code", aatnheVar.f42807a);
            jSONObject.put("message", aatnheVar.f42808b);
            jSONObject.put("app", aatnheVar.f42809c);
            JSONArray jSONArray = new JSONArray();
            Iterator<AppIdData> it = list.iterator();
            while (it.hasNext()) {
                for (com.transsion.athena.data.anehat anehatVar : it.next().f42700e) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("tid", anehatVar.f42741a);
                    jSONObject2.put(NotificationCompat.CATEGORY_EVENT, anehatVar.f42742b);
                    jSONObject2.put("count", anehatVar.f42746f);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("events", jSONArray);
            com.transsion.athena.taaneh.aethna.c("<-- upload success:%s", jSONObject.toString());
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b("exception when print upload events success: ", e11.getMessage());
        }
        if (this.f42842g) {
            Iterator<AppIdData> it2 = list.iterator();
            while (it2.hasNext()) {
                int i12 = it2.next().f42696a;
                if (this.f42841f.indexOfKey(i12) >= 0) {
                    this.f42841f.put(i12, "");
                    k4.a.a(AthenaAnalytics.J()).g("first_page_enter_" + i12, "");
                }
            }
        }
        Iterator<AppIdData> it3 = list.iterator();
        while (it3.hasNext()) {
            for (com.transsion.athena.data.anehat anehatVar2 : it3.next().f42700e) {
                if (anehatVar2.f42748h && (b11 = com.transsion.athena.aethna.athena.c().b(anehatVar2.f42741a)) != null) {
                    b11.getTidConfig().c(j11);
                    b11.getTidConfig().a(0);
                }
            }
        }
        List<aatnhe.athena> list2 = aatnheVar.f42809c;
        if (list2 != null) {
            for (aatnhe.athena athenaVar : list2) {
                com.transsion.athena.config.data.model.athena b12 = com.transsion.athena.aethna.athena.c().b(athenaVar.f42811a);
                if (b12 != null && !TextUtils.equals(b12.f(), athenaVar.a())) {
                    int i13 = athenaVar.f42812b;
                    if (i13 == 1) {
                        String a11 = athenaVar.a();
                        try {
                            if (com.transsion.athena.data.anateh.aethna.a(AthenaAnalytics.J()).a(b12.b())) {
                                b12.d(a11);
                                b12.c(0L);
                                b12.b(-1L);
                                com.transsion.athena.data.anateh.aethna.a(AthenaAnalytics.J()).a(b12, false);
                            }
                        } catch (Exception e12) {
                            com.transsion.athena.taaneh.aethna.b("Handle cleanup data exception : %s", e12.getMessage());
                            com.transsion.ga.anateh.a("handleCleanupData", e12);
                        }
                    } else if (i13 == 2) {
                        a(b12, athenaVar.a(), true);
                    } else if (i13 == 3) {
                        a(b12, athenaVar.a(), false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(anateh anatehVar) {
        com.transsion.athena.hatnea.athena.a().a(anatehVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:290:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05e1 A[Catch: Exception -> 0x0613, TryCatch #6 {Exception -> 0x0613, blocks: (B:304:0x05cf, B:305:0x05db, B:307:0x05e1, B:308:0x05ed, B:310:0x05f3, B:312:0x060a, B:315:0x0616, B:318:0x061d, B:320:0x0623, B:321:0x0634), top: B:303:0x05cf }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x061d A[Catch: Exception -> 0x0613, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0613, blocks: (B:304:0x05cf, B:305:0x05db, B:307:0x05e1, B:308:0x05ed, B:310:0x05f3, B:312:0x060a, B:315:0x0616, B:318:0x061d, B:320:0x0623, B:321:0x0634), top: B:303:0x05cf }] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x069a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0674 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018c A[Catch: Exception -> 0x014c, TryCatch #1 {Exception -> 0x014c, blocks: (B:56:0x0193, B:69:0x0144, B:64:0x0174, B:65:0x017c, B:66:0x0184, B:67:0x018c, B:72:0x014f, B:75:0x0157, B:78:0x015f), top: B:68:0x0144 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.util.List<com.transsion.athena.data.AppIdData> r33, java.lang.String r34, long r35, long r37, int r39) {
        /*
            Method dump skipped, instructions count: 1864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.hatnea.hatnea.a(java.util.List, java.lang.String, long, long, int):void");
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject != null) {
            if (jSONObject3 != null) {
                try {
                    if (jSONObject3.length() > 0) {
                        JSONObject jSONObject4 = new JSONObject();
                        if (jSONObject2.has("_ext")) {
                            jSONObject4 = jSONObject2.getJSONObject("_ext");
                        }
                        Iterator<String> keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String str = "_" + next;
                            Object obj = jSONObject3.get(next);
                            if (!jSONObject4.has(str)) {
                                jSONObject4.putOpt(str, obj);
                            }
                        }
                        int length = jSONObject4.toString().getBytes(StandardCharsets.UTF_8).length;
                        if (length > 2000) {
                            String format = String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length));
                            com.transsion.athena.taaneh.aethna.b(format);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("errorMsg", format);
                            jSONObject2.put("_ext", jSONObject5);
                        } else {
                            jSONObject2.put("_ext", jSONObject4);
                        }
                    }
                } catch (Exception e11) {
                    com.transsion.athena.taaneh.aethna.b("Insert common params exception : %s", e11.getMessage());
                    return;
                }
            }
            jSONObject.put("eparam", jSONObject2.toString());
        }
    }

    @Override // com.transsion.athena.hatnea.anateh
    public void a() {
        long a11 = com.transsion.athena.ehatna.aethna.b().a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
        Iterator<AppIdData> it = this.f42840e.iterator();
        int i11 = 0;
        AppIdData appIdData = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AppIdData next = it.next();
            if (!TextUtils.isEmpty(next.f42698c) && TextUtils.equals(next.f42701f, this.f42839d)) {
                if (appIdData != null) {
                    if (!TextUtils.equals(appIdData.f42698c, next.f42698c)) {
                        i11++;
                        break;
                    }
                } else {
                    i11++;
                    appIdData = next;
                }
            }
        }
        if (i11 != 1) {
            if (i11 > 1) {
                ArrayList arrayList = new ArrayList();
                for (AppIdData appIdData2 : this.f42840e) {
                    if (!TextUtils.isEmpty(appIdData2.f42698c) && TextUtils.equals(appIdData2.f42701f, this.f42839d)) {
                        arrayList.add(appIdData2);
                    }
                }
                com.transsion.athena.data.anateh.aethna.a(AthenaAnalytics.J()).a(arrayList);
            }
            appIdData = null;
        }
        long e11 = com.transsion.athena.aethna.athena.c().e() * 1000;
        if (appIdData != null) {
            Pair<String, List<AppIdData>> a12 = a(0L, appIdData.f42698c);
            List<AppIdData> list = (List) a12.second;
            if (com.transsion.athena.config.data.model.anehat.b(list)) {
                a(list, (String) a12.first, a11, e11, appIdData.f42699d);
                return;
            }
            return;
        }
        Pair<String, List<AppIdData>> a13 = a(a11, null);
        String str = (String) a13.first;
        List<AppIdData> list2 = (List) a13.second;
        if (com.transsion.athena.config.data.model.anehat.b(list2)) {
            a(list2, str, a11, e11, 0);
        }
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        if (TextUtils.isEmpty(this.f42839d)) {
            return "Default";
        }
        try {
            String[] split = this.f42839d.split("//");
            if (split.length > 0) {
                return split[1].split("\\.")[0];
            }
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b("get domain exception : %s", e11.getMessage());
        }
        return "Default";
    }
}
