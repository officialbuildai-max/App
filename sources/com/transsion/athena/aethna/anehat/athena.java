package com.transsion.athena.aethna.anehat;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.athena.config.data.model.aatnhe;
import com.transsion.athena.config.data.model.anateh;
import com.transsion.athena.config.data.model.anehat;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.config.data.model.enatha;
import com.transsion.athena.hatnea.atenha;
import com.transsion.athena.hatnea.athaen;
import com.transsion.athena.taaneh.aethna;
import com.transsion.ga.AthenaAnalytics;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class athena {

    /* renamed from: a, reason: collision with root package name */
    private static volatile athena f42603a;

    /* renamed from: b, reason: collision with root package name */
    private com.transsion.athena.aethna.anehat.aethna.athena f42604b;

    /* renamed from: c, reason: collision with root package name */
    private anateh f42605c = new anateh();

    private athena(com.transsion.athena.aethna.anehat.aethna.athena athenaVar) {
        this.f42604b = athenaVar;
    }

    public static athena a(com.transsion.athena.aethna.anehat.aethna.athena athenaVar) {
        if (f42603a == null) {
            synchronized (athena.class) {
                try {
                    if (f42603a == null) {
                        f42603a = new athena(athenaVar);
                    }
                } finally {
                }
            }
        }
        return f42603a;
    }

    private void c() {
        String str;
        try {
            try {
                this.f42604b.getClass();
                byte[] a11 = anehat.a("63D4BEBEBC7ABCA4BC6A796B6AB06B766A6C7D706B6B756F70B07B6F71A4A5AEBCB2D4BEBEBC6A69BCA4BC7A6B69B16A796B6AB06B767D72726A6C65B07B6F71BCB2D4BEBEBC6A7BBCA4BC7A6B7BB16A796B6AB06B767D72726A6C65B07B6F71BCB2D4BEBEBC6F69BCA4BC7A6B69B06B767D72726A6C65B07B6F71BCB2D4BEBEBC6F7BBCA4BC7A6B7BB06B767D72726A6C65B07B6F71BCB2D4BEBEBC7BBCA4BCAF726F777B6F7078AF68A8AF696E726F7D7A7B6F7078BCB2D4BEBEBC77BCA4BCAF726F777B6F7078AF68ADAF6B797B6C796ABCB2D4BEBEBC69BCA4BCAF7D6A7679707DAF7B76797B736E6F75706AAF68ACAF696E726F7D7ABCB2D4BEBEBC787BBCA4BC68AEAC7BBCB2D4BEBEBC787ABCA4BC68AEAC7ABCB2D4BEBEBC7879BCA4BC68AEAC79BCB2D4BEBEBC7568BCA4BC7D7C7B7A79787776757473AD71706F6EBCB2D4BEBEBC67BCA4BCABA7ADA899A99B9CAD9CA5A6AC9BAEABA9AEADAB99A9ACADA8A79D9D98A9AA9DBCD461D4D4");
                if (a11 == null) {
                    str = "";
                } else {
                    for (int i11 = 0; i11 < a11.length; i11++) {
                        a11[i11] = (byte) (222 - ((char) a11[i11]));
                    }
                    str = new String(a11);
                }
                ehanat.c(str);
                this.f42604b.a(ehanat.f42663j);
                this.f42604b.a(ehanat.f42666m);
            } catch (Exception e11) {
                aethna.b(Log.getStackTraceString(e11));
                com.transsion.ga.anateh.a("initSDKConfig", e11);
                this.f42604b.a(ehanat.f42663j);
                this.f42604b.a(ehanat.f42666m);
            }
        } catch (Throwable th2) {
            this.f42604b.a(ehanat.f42663j);
            this.f42604b.a(ehanat.f42666m);
            throw th2;
        }
    }

    public com.transsion.athena.config.data.model.aethna a(long j11) {
        com.transsion.athena.config.data.model.aethna aethnaVar = new com.transsion.athena.config.data.model.aethna();
        String a11 = this.f42605c.a(j11);
        if (TextUtils.isEmpty(a11)) {
            a11 = ehanat.a(true);
        }
        aethnaVar.f42638a = a11 + ehanat.f42661h;
        aethnaVar.f42639b = e();
        aethnaVar.f42640c = this.f42605c.b().f();
        return aethnaVar;
    }

    public List<com.transsion.athena.config.data.model.athena> a() {
        return this.f42605c.a();
    }

    public void a(int i11) {
        List<com.transsion.athena.config.data.model.athena> a11 = this.f42605c.a();
        Iterator<com.transsion.athena.config.data.model.athena> it = a11.iterator();
        while (it.hasNext()) {
            if (it.next().b() == i11) {
                return;
            }
        }
        com.transsion.athena.config.data.model.athena athenaVar = new com.transsion.athena.config.data.model.athena();
        athenaVar.a(i11);
        a11.add(athenaVar);
    }

    public void a(Handler handler, com.transsion.athena.aethna.aethna aethnaVar) {
        if (ehanat.r()) {
            enatha b11 = this.f42605c.b();
            if (b11.a(32)) {
                com.transsion.athena.hatnea.athena.a().a(new atenha(handler, b11, aethnaVar));
            }
            for (com.transsion.athena.config.data.model.athena athenaVar : this.f42605c.a()) {
                int e11 = athenaVar.e();
                long c11 = e11 > 0 ? e11 * 3600000 : b11.c();
                if (athenaVar.a(c11, 32)) {
                    com.transsion.athena.hatnea.athena.a().a(new athaen(athenaVar, c11, aethnaVar));
                }
            }
        }
    }

    public void a(@NonNull com.transsion.athena.config.data.model.athena athenaVar, @NonNull String str) {
        String str2;
        String str3;
        com.transsion.athena.config.data.model.athena athenaVar2 = athenaVar;
        String str4 = "cfg";
        String str5 = "gpct";
        String str6 = "upct";
        String str7 = "pr";
        String str8 = "stats";
        String str9 = "cv";
        String str10 = "frq";
        try {
            String str11 = "ur";
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("ver")) {
                str2 = "iw";
                athenaVar2.c(jSONObject.getLong("ver"));
            } else {
                str2 = "iw";
            }
            if (jSONObject.has("url")) {
                athenaVar2.e(jSONObject.getString("url"));
            }
            if (jSONObject.has("interval")) {
                athenaVar2.c(jSONObject.getInt("interval"));
            }
            if (jSONObject.has(OfflineConstantsKt.OFFLINE)) {
                athenaVar2.d(jSONObject.getInt(OfflineConstantsKt.OFFLINE));
            }
            if (jSONObject.has("url_config")) {
                athenaVar2.c(jSONObject.getString("url_config"));
            }
            if (jSONObject.has("data")) {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                if (jSONArray.length() > 0) {
                    int i11 = 0;
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0).getJSONObject("cfg");
                    int i12 = 0;
                    while (i12 < jSONArray.length()) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i12).getJSONObject(str4);
                        JSONArray jSONArray2 = jSONArray.getJSONObject(i12).getJSONArray("tids");
                        int i13 = i11;
                        while (i13 < jSONArray2.length()) {
                            JSONObject jSONObject4 = jSONObject2;
                            long j11 = jSONArray2.getLong(i13);
                            TidConfigBean a11 = athenaVar2.a(j11);
                            if (a11 == null) {
                                str3 = str4;
                                TidConfigBean tidConfigBean = new TidConfigBean();
                                tidConfigBean.setTid(j11);
                                athenaVar2.a(tidConfigBean);
                                a11 = tidConfigBean;
                            } else {
                                str3 = str4;
                            }
                            int optInt = jSONObject4.optInt(str9, 0);
                            if (jSONObject3.has(str9)) {
                                optInt = jSONObject3.getInt(str9);
                            }
                            aatnhe tidConfig = a11.getTidConfig();
                            String str12 = str9;
                            JSONObject jSONObject5 = jSONObject;
                            long j12 = optInt;
                            if (optInt > 0) {
                                j12 *= 60000;
                            }
                            tidConfig.b(j12);
                            int optInt2 = jSONObject4.optInt("gmin", 0);
                            if (jSONObject3.has("gmin")) {
                                optInt2 = jSONObject3.getInt("gmin");
                            }
                            a11.getTidConfig().c(optInt2);
                            int optInt3 = jSONObject4.optInt("gmax", 100);
                            if (jSONObject3.has("gmax")) {
                                optInt3 = jSONObject3.getInt("gmax");
                            }
                            a11.getTidConfig().b(optInt3);
                            int optInt4 = jSONObject4.optInt("num", 0);
                            if (jSONObject3.has("num")) {
                                optInt4 = jSONObject3.getInt("num");
                            }
                            a11.getTidConfig().e(optInt4);
                            int optInt5 = jSONObject4.optInt("s", 10);
                            if (jSONObject3.has("s")) {
                                optInt5 = jSONObject3.getInt("s");
                            }
                            a11.getTidConfig().d(optInt5 * 60000);
                            String str13 = str2;
                            int optInt6 = jSONObject4.optInt(str13, 0);
                            if (jSONObject3.has(str13)) {
                                optInt6 = jSONObject3.getInt(str13);
                            }
                            a11.getTidConfig().f(optInt6);
                            String str14 = str11;
                            int optInt7 = jSONObject4.optInt(str14, 100);
                            if (jSONObject3.has(str14)) {
                                optInt7 = jSONObject3.getInt(str14);
                            }
                            a11.getTidConfig().j(optInt7);
                            String str15 = str10;
                            int optInt8 = jSONObject4.optInt(str15, 0);
                            if (jSONObject3.has(str15)) {
                                optInt8 = jSONObject3.getInt(str15);
                            }
                            str2 = str13;
                            a11.getTidConfig().a(optInt8 * 60 * 1000);
                            String str16 = str8;
                            int optInt9 = jSONObject4.optInt(str16, 0);
                            if (jSONObject3.has(str16)) {
                                optInt9 = jSONObject3.getInt(str16);
                            }
                            a11.getTidConfig().h(optInt9);
                            String str17 = str7;
                            int optInt10 = jSONObject4.optInt(str17, 0);
                            if (jSONObject3.has(str17)) {
                                optInt10 = jSONObject3.getInt(str17);
                            }
                            str8 = str16;
                            a11.getTidConfig().g(optInt10);
                            String str18 = str6;
                            int optInt11 = jSONObject4.optInt(str18, 1);
                            if (jSONObject3.has(str18)) {
                                optInt11 = jSONObject3.getInt(str18);
                            }
                            a11.getTidConfig().i(optInt11);
                            String str19 = str5;
                            int optInt12 = jSONObject4.optInt(str19, 1);
                            if (jSONObject3.has(str19)) {
                                optInt12 = jSONObject3.getInt(str19);
                            }
                            str5 = str19;
                            a11.getTidConfig().d(optInt12);
                            i13++;
                            athenaVar2 = athenaVar;
                            str10 = str15;
                            str11 = str14;
                            str9 = str12;
                            str7 = str17;
                            str4 = str3;
                            jSONObject2 = jSONObject4;
                            str6 = str18;
                            jSONObject = jSONObject5;
                        }
                        i12++;
                        athenaVar2 = athenaVar;
                        str9 = str9;
                        jSONObject2 = jSONObject2;
                        str6 = str6;
                        jSONObject = jSONObject;
                        i11 = 0;
                    }
                }
            }
            JSONObject jSONObject6 = jSONObject;
            if (jSONObject6.has("table")) {
                JSONObject jSONObject7 = jSONObject6.getJSONObject("table");
                for (TidConfigBean tidConfigBean2 : athenaVar.j()) {
                    String optString = jSONObject7.optString(String.valueOf(tidConfigBean2.getTid()), "");
                    if (optString.length() > 0) {
                        tidConfigBean2.setEvent(optString);
                    }
                }
            }
            try {
                com.transsion.athena.config.data.model.athena a12 = this.f42605c.a(com.transsion.athena.data.athena.b());
                if (a12 == null) {
                    return;
                }
                ehanat.a(a12.i());
            } catch (Exception e11) {
                e = e11;
                aethna.b(Log.getStackTraceString(e));
                com.transsion.ga.anateh.a("updateAppConfig", e);
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public void a(@NonNull String str) {
        try {
            enatha b11 = this.f42605c.b();
            JSONObject jSONObject = new JSONObject(str);
            b11.d(jSONObject.getLong("cv") * 3600000);
            b11.e(jSONObject.getLong("threshold"));
            b11.b(jSONObject.getInt("once") == 1);
            if (jSONObject.has("networks")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("networks");
                b11.c(jSONObject2.getString("url"));
                b11.b(jSONObject2.getJSONObject("tids"));
            }
            if (jSONObject.has(TtmlNode.TAG_P)) {
                b11.a(jSONObject.getJSONArray(TtmlNode.TAG_P));
            }
            if (jSONObject.has("ver")) {
                b11.f(jSONObject.getLong("ver"));
            }
            if (jSONObject.has("delays")) {
                String[] split = jSONObject.getString("delays").split(",");
                b11.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }
            if (jSONObject.has("tz")) {
                b11.b(jSONObject.getString("tz"));
            }
            if (jSONObject.has("dlt")) {
                b11.d(jSONObject.getInt("dlt"));
            }
            b11.b(jSONObject.optInt("geo", 6));
        } catch (Exception e11) {
            aethna.b(Log.getStackTraceString(e11));
            com.transsion.ga.anateh.a("updateGlobalConfig", e11);
        }
    }

    public void a(List<com.transsion.athena.config.data.model.athena> list) {
        this.f42605c.a(list);
    }

    public anateh b() {
        return this.f42605c;
    }

    public List<TidConfigBean> b(int i11) {
        if (i11 == -1) {
            return this.f42605c.c();
        }
        com.transsion.athena.config.data.model.athena a11 = this.f42605c.a(i11);
        return a11 != null ? a11.j() : Collections.emptyList();
    }

    public void d() {
        try {
            c();
            anateh a11 = anateh.a(this.f42604b.c());
            if (a11 == null) {
                this.f42604b.b(this.f42605c.e());
            } else {
                this.f42605c = a11;
            }
            com.transsion.athena.config.data.model.athena a12 = this.f42605c.a(com.transsion.athena.data.athena.b());
            if (a12 == null) {
                return;
            }
            ehanat.a(a12.i());
        } catch (Exception e11) {
            aethna.b(Log.getStackTraceString(e11));
        }
    }

    @NonNull
    public Pair<Integer, byte[]> e() {
        List<byte[]> b11 = this.f42605c.b().b();
        if (!anehat.b(b11)) {
            return new Pair<>(0, ehanat.f42667n);
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() % b11.size());
        return new Pair<>(Integer.valueOf(currentTimeMillis), b11.get(currentTimeMillis));
    }

    public void f() {
        this.f42605c.d();
        this.f42604b.b(this.f42605c.e());
    }

    public void g() {
        enatha b11 = this.f42605c.b();
        b11.a(com.transsion.athena.taaneh.athena.j(AthenaAnalytics.J()));
        b11.a(true);
        this.f42604b.b(this.f42605c.e());
    }

    public void h() {
        com.transsion.athena.aethna.anehat.aethna.athena athenaVar = this.f42604b;
        if (athenaVar != null) {
            athenaVar.b(this.f42605c.e());
        }
    }
}
